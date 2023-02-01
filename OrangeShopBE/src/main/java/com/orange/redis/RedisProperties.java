package com.orange.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {
	
    private Integer database;
    private String host;
    private Integer port;
    private Boolean ssl;
    private String password;
    private Long connTimeout;
    private Integer maxActive;
    private Integer maxIdle;
    private Integer minIdle;
    private Integer maxWait;
}
