package com.c4tman.play.design.pattern.frs.aop;

import com.c4tman.play.design.pattern.frs.annotation.LimitMethod;
import com.c4tman.play.design.pattern.frs.Utils;
import com.c4tman.play.design.pattern.frs.service.AccessService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;


/**
 * Created by zhangxiaoman on 2018/6/28.
 */
@Aspect
@Component
public class accessAspect {
    @Autowired
    AccessService accessService;

    @Pointcut("execution(* com.c4tman.play.design.pattern.frs.service.*.*(..))")
    public void pointCut() {}


    @Before("pointCut()")
    //获取切入点的方法：https://blog.csdn.net/guan_shijie/article/details/52573189
    public void beforeAccess(final JoinPoint joinPoint){

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        if(method.isAnnotationPresent(LimitMethod.class)){
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            String ip = Utils.getRealIp(request);

            LimitMethod limitMethod = method.getAnnotation(LimitMethod.class);
            String key = Utils.getStoreKey(ip, method.getDeclaringClass().getName(), method.getName(),limitMethod.keyWord());
            boolean canAccess =accessService.access(key, limitMethod.timeUnit(), limitMethod.maxTime());
            if (!canAccess){
                throw new RuntimeException(method.getName()+"访问被限制");
            }
        }
    }

}
