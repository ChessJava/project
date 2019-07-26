package com.test.log;

import com.test.entity.LogEntity;
import com.test.tools.FileIO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class WebLogAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");

    public static Date getDateTime() {
        return new Date();
    }

    public String getStringTime() {
        return this.sdf.format(getDateTime());
    }

    //定义execution表达式使用
    @Pointcut("execution(public * com.test.web..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 以日期+时间形式输入信息输出到日志文件中
        String time = getStringTime();
        LogEntity le = new LogEntity();
        le.setUrl(request.getRequestURL().toString());
        le.setHttp_method(request.getMethod());
        le.setIp(request.getRemoteAddr());
        le.setClass_method(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        le.setArgs(Arrays.toString(joinPoint.getArgs()));
        // 记录下请求内容
        logger.info("URL : " + le.getUrl());
        logger.info("HTTP_METHOD : " + le.getHttp_method());
        logger.info("IP : " + le.getIp());
        logger.info("CLASS_METHOD : " + le.getClass_method());
        logger.info("ARGS : " + le.getArgs());
        FileIO.outRecord(le.toString(),"e://test/"+time+".txt");
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }
}
