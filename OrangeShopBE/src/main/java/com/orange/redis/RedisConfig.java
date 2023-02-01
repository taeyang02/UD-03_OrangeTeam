package com.orange.redis;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
@SuppressWarnings({ "rawtypes" })
public class RedisConfig {

	@Autowired
	private RedisProperties redisProperties;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
		RedisSerializer stringSerializer = new StringRedisSerializer();
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(lettuceConnectionFactory);
		redisTemplate.setKeySerializer(stringSerializer);// key serialization
		redisTemplate.setHashKeySerializer(stringSerializer);// Hash key serialization
		redisTemplate.setDefaultSerializer(stringSerializer);
		redisTemplate.setValueSerializer(stringSerializer);
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
	
	@Bean(name = "redisTemplateWithJsonSerializer")
	public RedisTemplate<String, String> redisTemplateWithJsonSerializer(LettuceConnectionFactory lettuceConnectionFactory) {
		RedisSerializer stringSerializer = new StringRedisSerializer();
		Jackson2JsonRedisSerializer<String> jsonRedisSerializer = new Jackson2JsonRedisSerializer<String>(String.class);
		jsonRedisSerializer.setObjectMapper(objectMapper);
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(lettuceConnectionFactory);
		
		redisTemplate.setKeySerializer(stringSerializer);// key serialization
		redisTemplate.setValueSerializer(jsonRedisSerializer);// value serialization
		
		redisTemplate.setHashKeySerializer(stringSerializer);// Hash key serialization
		redisTemplate.setHashValueSerializer(jsonRedisSerializer);// Hash value serialization
		
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

	@Bean
	public LettuceConnectionFactory lettuceConnectionFactory(GenericObjectPoolConfig genericObjectPoolConfig) {
		// Stand-alone configuration
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
		redisStandaloneConfiguration
				.setDatabase(redisProperties.getDatabase() == null ? 0 : redisProperties.getDatabase());
		redisStandaloneConfiguration.setHostName(redisProperties.getHost());
		redisStandaloneConfiguration.setPort(redisProperties.getPort());
		redisStandaloneConfiguration.setPassword(RedisPassword.of(redisProperties.getPassword()));
		LettuceClientConfiguration clientConfig = LettucePoolingClientConfiguration.builder()
				.commandTimeout(Duration.ofMillis(redisProperties.getConnTimeout())).poolConfig(genericObjectPoolConfig)
				.build();
		if (redisProperties.getSsl()) {
			clientConfig.isUseSsl();
		}
		LettuceConnectionFactory factory = new LettuceConnectionFactory(redisStandaloneConfiguration, clientConfig);
		return factory;
	}

	@Bean
	public GenericObjectPoolConfig genericObjectPoolConfig() {
		GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
		genericObjectPoolConfig.setMaxIdle(redisProperties.getMaxIdle());
		genericObjectPoolConfig.setMinIdle(redisProperties.getMinIdle());
		genericObjectPoolConfig.setMaxTotal(redisProperties.getMaxActive());
		genericObjectPoolConfig.setMaxWaitMillis(redisProperties.getMaxWait());
		return genericObjectPoolConfig;
	}
}