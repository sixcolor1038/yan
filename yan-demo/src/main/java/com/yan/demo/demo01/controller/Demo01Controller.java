package com.yan.demo.demo01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("demo")
public class Demo01Controller {
    @Autowired
    StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/redisTest",method = RequestMethod.POST )
    public String redisTest(){
        redisTemplate.opsForValue().set("081624a","081624b", 60, TimeUnit.SECONDS); // 设置过期时间为60秒
        return "success";
    }

}
