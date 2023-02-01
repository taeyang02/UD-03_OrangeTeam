package com.orange.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
@SuppressWarnings({ "rawtypes", "unchecked" })
public class RedisCacheService implements CacheService {
	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * Write cache
	 * 
	 * @param key
	 * @param value
	 * @return boolean
	 */
	@Override
	public boolean set(String key, Object value) {
		boolean result = false;
		key = getKey(key);
		try {
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Write cache setting aging time
	 * 
	 * @param key
	 * @param value
	 * @return boolean
	 */
	@Override
	public boolean set(String key, Object value, Long expireTime) {
		boolean result = false;
		key = getKey(key);
		try {
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Delete the corresponding value in batches
	 * 
	 * @param keys
	 */
	@Override
	public void remove(String... keys) {
		for (String key : keys) {
			remove(key);
		}
	}

	/**
	 * Delete key in bulk
	 * 
	 * @param pattern
	 */
	@Override
	public void removePattern(String pattern) {
		Set<Serializable> keys = redisTemplate.keys(getKey(pattern));
		if (keys.size() > 0)
			redisTemplate.delete(keys);
	}

	/**
	 * Delete the corresponding value
	 * 
	 * @param key
	 */
	@Override
	public void remove(String key) {
		key = getKey(key);
		if (exists(key)) {
			redisTemplate.delete(key);
		}
	}

	/**
	 * Determine if there is a corresponding value in the cache
	 * 
	 * @param key
	 * @return
	 */
	@Override
	public boolean exists(String key) {
		key = getKey(key);
		return redisTemplate.hasKey(key);
	}

	/**
	 * Read cache
	 * 
	 * @param key
	 * @return
	 */
	@Override
	public Object get(String key) {
		key = getKey(key);
		Object result = null;
		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		result = operations.get(key);
		return result;
	}

	/**
	 * hash add
	 * 
	 * @param key
	 * @param hashKey
	 * @param value
	 */
	@Override
	public void hmSet(String key, Object hashKey, Object value) {
		key = getKey(key);
		HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
		hash.put(key, hashKey, value);
	}

	/**
	 * Hash to get data
	 * 
	 * @param key
	 * @param hashKey
	 * @return
	 */
	@Override
	public Object hmGet(String key, Object hashKey) {
		key = getKey(key);
		HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
		return hash.get(key, hashKey);
	}

	/**
	 * List added
	 * 
	 * @param k
	 * @param v
	 */
	@Override
	public void lPush(String k, Object v) {
		k = getKey(k);
		ListOperations<String, Object> list = redisTemplate.opsForList();
		list.rightPush(k, v);
	}

	/**
	 * List removed
	 * 
	 * @return object
	 */
	@Override
	public Object lPop(String k) {
		k = getKey(k);
		ListOperations<String, Object> list = redisTemplate.opsForList();
		return list.leftPop(k);
	}
	
	/**
	 * List acquisition
	 * 
	 * @param k
	 * @param l
	 * @param l1
	 * @return
	 */
	@Override
	public List<Object> lRange(String k, long l, long l1) {
		k = getKey(k);
		ListOperations<String, Object> list = redisTemplate.opsForList();
		return list.range(k, l, l1);
	}

	/**
	 * Collection added
	 * 
	 * @param key
	 * @param value
	 */
	@Override
	public void setArray(String key, Object value) {
		key = getKey(key);
		SetOperations<String, Object> set = redisTemplate.opsForSet();
		set.add(key, value);
	}

	/**
	 * Collection acquisition
	 * 
	 * @param key
	 * @return
	 */
	@Override
	public Set<Object> getArray(String key) {
		key = getKey(key);
		SetOperations<String, Object> set = redisTemplate.opsForSet();
		return set.members(key);
	}

	/**
	 * Ordered collection added
	 * 
	 * @param key
	 * @param value
	 * @param score
	 */
	@Override
	public void zAdd(String key, Object value, double score) {
		key = getKey(key);
		ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
		zset.add(key, value, score);
	}

	/**
	 * Ordered collection acquisition
	 * 
	 * @param key
	 * @param score
	 * @param score1
	 * @return
	 */
	@Override
	public Set<Object> rangeByScore(String key, double score, double score1) {
		key = getKey(key);
		ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
		return zset.rangeByScore(key, score, score1);
	}

	private String getKey(String key) {
		return  key;
	}
}
