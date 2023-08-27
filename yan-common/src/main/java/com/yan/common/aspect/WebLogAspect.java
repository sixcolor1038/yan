package com.yan.common.aspect;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@ComponentScan("com.yan.common.*")
@Component
@Aspect
public class WebLogAspect {
    private final static Logger log = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("within(com.*..*.*Controller+)")
    public void controllerLog() {}

    @Before("controllerLog()")
    public void beforeLog(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 打印请求信息
        log.info("请求URL: {}", request.getRequestURL());
        log.info("HTTP 方法: {}", request.getMethod());
        //log.info("IP: {}", request.getRemoteAddr());
        log.info("类 方法: {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("请求 参数: {}", joinPoint.getArgs());

        long start = System.currentTimeMillis();
        request.setAttribute("start", start);

    }

    @AfterReturning(pointcut = "controllerLog()", returning="result")
    public void afterReturningLog(JoinPoint joinPoint, Object result) {

        long start = (Long) RequestContextHolder.getRequestAttributes().getAttribute("start", 0);
        long end = System.currentTimeMillis();

        log.info("请求 结果: {}", result);
        log.info("本次共耗时: {} ms", end - start);

    }

}


