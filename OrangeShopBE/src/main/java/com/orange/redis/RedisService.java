package com.orange.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    public String hmGetJson(String key, Object hashKey) {
        HashOperations hash = redisTemplate.opsForHash();
        String info = (String) hash.get(key, hashKey);
        return  info;
    }


}
