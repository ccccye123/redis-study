package com.ccccye.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @RequestMapping(value = "/get/{key}")
    public String get(@PathVariable("key") String key){
//        stringRedisTemplate.opsForValue().set("redis1", "redisvalue");

        String value = stringRedisTemplate.opsForValue().get(key);
        return value;
    }

    @RequestMapping(value = "/set/{key}/{value}")
    public void set(@PathVariable("key") String key, @PathVariable("value") String value){
        stringRedisTemplate.opsForValue().set(key, value);
    }
}
