package com.yan.demo.demo01.controller;

import com.yan.common.utils.RResult;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Operation(summary = "redis测试", description = "redis测试")
    @RequestMapping(value = "/redisTest", method = RequestMethod.POST)
    public RResult redisTest() {
        System.out.println("azzzz");
        // 设置过期时间为60秒
        redisTemplate.opsForValue().set("081624a", "081624b", 60, TimeUnit.SECONDS);
        return RResult.ok();
    }

}
