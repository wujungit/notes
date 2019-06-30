package com.kanghe.notes.controller;

import com.alibaba.fastjson.JSON;
import com.kanghe.notes.entity.TeamInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @Author: W_jun1
 * @Date: 2019/6/27 22:34
 * @Description: TestRedis
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test1() {
        stringRedisTemplate.opsForValue().set("key", "value", 60 * 1000, TimeUnit.MILLISECONDS);
        String value = stringRedisTemplate.opsForValue().get("key");
        Assert.assertEquals("value", value);
    }

    @Test
    public void test2() {
        redisTemplate.opsForValue().set("key", "value", 60 * 1000, TimeUnit.MILLISECONDS);
        String value = (String) redisTemplate.opsForValue().get("key");
        System.out.println(value);
    }

    @Test
    public void test3() {
        TeamInfo teamInfo = new TeamInfo();
        teamInfo.setCode("123456");
        teamInfo.setName("吴俊");
        redisTemplate.opsForValue().set("teamInfo", teamInfo);
        TeamInfo info = (TeamInfo) redisTemplate.opsForValue().get("teamInfo");
        log.info(JSON.toJSONString(info));
    }

}
