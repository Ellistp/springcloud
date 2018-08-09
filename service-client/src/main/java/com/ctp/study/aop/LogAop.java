package com.ctp.study.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author chengtianping
 * @description 日志切面
 * @date 2017/9/14
 */
@Aspect
@Component
public class LogAop {

    private static final Logger logger = LoggerFactory.getLogger(LogAop.class);

    private static final ThreadLocal<Long> timeLocal = new ThreadLocal<>();

    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void controller(){

    }

    @Before("controller()")
    public void doBefore(JoinPoint joinPoint){
        timeLocal.set(System.currentTimeMillis());

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 接收到请求，记录请求内容
        logger.info("LogAop.doBefore()");

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning("controller()")
    public void  doAfterReturning(JoinPoint joinPoint){
        // 处理完请求，返回内容
        logger.info("LogAop.doAfterReturning()");

        //处理完请求 设置总的请求时间
        timeLocal.set(System.currentTimeMillis()-timeLocal.get());

        logger.info("request deal time ========== : " + timeLocal.get());
    }

    @AfterThrowing("controller()")
    public void doAfterThrowing(JoinPoint joinPoint){
        // 抛出异常请求，返回内容
        logger.info("LogAop.doAfterThrowing()");
        logger.error(joinPoint.getSignature().getName());
    }
}
