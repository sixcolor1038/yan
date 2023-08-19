package com.yan.common.aspect;

import com.yan.common.utils.JsonUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ComponentScan("com.yan")
@Aspect
@Component
public class WebLogAspect {
    private final static Logger log = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("within(com.yan..*.*Controller+)")
    public void controllerLog() {}

    @Before("controllerLog()")
    public void beforeLog(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 打印请求信息
        log.info("URL: {}", request.getRequestURL());
        log.info("HTTP Method: {}", request.getMethod());
        log.info("IP: {}", request.getRemoteAddr());
        log.info("Class Method: {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("Request Args: {}", joinPoint.getArgs());

        long start = System.currentTimeMillis();
        request.setAttribute("start", start);

    }

    @AfterReturning(pointcut = "controllerLog()", returning="result")
    public void afterReturningLog(JoinPoint joinPoint, Object result) {

        long start = (Long) RequestContextHolder.getRequestAttributes().getAttribute("start", 0);
        long end = System.currentTimeMillis();

        log.info("Result: {}", result);
        log.info("Time Cost: {} ms", end - start);

    }

}


