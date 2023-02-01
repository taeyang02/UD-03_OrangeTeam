package com.orange.redis;

import com.orange.Utils.JsonUtils;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

@SuppressWarnings({"rawtypes", "unchecked"})
public class RedisQueue<T> extends Queue<T> {
	private RedisTemplate redisTemplate;
	
	public RedisQueue(RedisTemplate redisTemplate, String queueName, Class<T> classOfT) {
		super(queueName, classOfT);
		this.redisTemplate = redisTemplate;
	}

	public void add(T t) {
		if (t == null) {
			LOG.warn("Failed to add NULL item to redis queue");
			return;
		}
		String json = JsonUtils.toJson(t);
		LOG.debug("Add item to redis queue [" + queueName + "]: " + json);
		try {
			ListOperations<String, String> list = redisTemplate.opsForList();
			list.rightPush(queueName, json);
		} catch (Exception e) {
			LOG.warn("Failed to add item to redis queue [" + queueName + "]: " + json + " [" + e.getMessage() + "]");
		}
	}

	public T remove() {
		try {
			ListOperations<String, String> list = redisTemplate.opsForList();
			String json = list.leftPop(queueName);
			if (json != null)
				return JsonUtils.fromJson(json, classOfT);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.warn("Failed to remove item to redis queue [" + queueName + "]: [" + e.getMessage() + "]");
		}
		return null;
	}
}