package com.kanghe.notes.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: W_jun1
 * @Date: 2019/6/27 22:34
 * @Description:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1() throws Exception {
        // set
        stringRedisTemplate.opsForValue().set("key", "value");
        // get
        String value = stringRedisTemplate.opsForValue().get("key");
        Assert.assertEquals("value", value);
    }

    @Test
    public void test2() throws Exception {
        // set
        redisTemplate.opsForValue().set("key", "value");
        // get
        String value = redisTemplate.opsForValue().get("key", 0, 5);
        Assert.assertEquals("value", value);
    }

}
