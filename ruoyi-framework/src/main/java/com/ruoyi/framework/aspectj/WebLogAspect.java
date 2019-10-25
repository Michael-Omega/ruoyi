package com.ruoyi.framework.aspectj;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class WebLogAspect {

    private  Long startTime = System.currentTimeMillis();
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 定义拦截规则：拦截cn.louiswu.controller..*(..))包下面的所有类中，有@PostMapping注解的方法
     */
    @Pointcut("execution(public * com.ruoyi.web.controller.*.*.*(..))")
    private void webLog(){}


    @Before("webLog()")
    public void controller(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        String before = "\n"+"SpringBoot"+"================================================"+sdf.format(new Date())+"================================================\n";
        String path = request.getRequestURL().toString()+"\n";
        String method = request.getMethod()+"\n";
        String ip = request.getRemoteAddr()+"\n";
//        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()+"\n";
        //获取所有参数方法一：
        Enumeration<String> enu=request.getParameterNames();
        Map<Object,Object> params = new HashMap<>();
        while(enu.hasMoreElements()){
            String paraName=enu.nextElement();
            params.put(paraName,request.getParameter(paraName));
        }

        log.info(before+"\t\tPATH:\t\t\t"+path+"\t\tMETHOD:\t\t\t"+method+"\t\tIP:\t\t\t\t"+ip+"\t\tCLASSMETHOD:\t"+classMethod+"\t\tPARAMS:\t\t\t"+params+"\n");
    }
    @After("webLog()")
    public void AfterConntroller(){
        String after = "=============================================================================================================================";
        System.out.println(after);
    }
}
