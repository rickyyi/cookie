package com.cookie.springFramework.myBatis;
import cn.upenny.common.exception.BaseException;
import cn.upenny.common.exception.BusinessExcepiton;
import cn.upenny.framework.constant.Constants;
import cn.upenny.framework.dto.ResponseEntity;
import org.apache.ibatis.binding.MapperProxy;
import org.apache.ibatis.jdbc.Null;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.Date;


@Aspect
@Component
public class ParseTableNameAspect {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @Around("execution(* cn.upenny.framework.dao.BaseDao.*(..))")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        parseTableName(proceedingJoinPoint);

        return proceedingJoinPoint.proceed();
    }

    private void parseTableName(ProceedingJoinPoint proceedingJoinPoint)
            throws NoSuchFieldException, IllegalAccessException,
            ClassNotFoundException {
        // 将modelClass添加到线程变量
        if(proceedingJoinPoint.getArgs()!=null &&proceedingJoinPoint.getArgs().length>0
                &&proceedingJoinPoint.getArgs()[0] instanceof Null){
            SqlProvider.setModelClass(proceedingJoinPoint.getArgs()[0].getClass());
        }else{
            // 获取代理目标对象
            Field h = Proxy.class.getDeclaredField("h");
            h.setAccessible(true);
            Object proxyTarget = h.get(proceedingJoinPoint.getTarget());
            // 获取dao类
            Field mapperInterface = MapperProxy.class
                    .getDeclaredField("mapperInterface");
            mapperInterface.setAccessible(true);
            Class<?> cl = (Class<?>) mapperInterface.get(proxyTarget);

            // 获取model类
            String modelName = cl.getName().replace(".dao.", ".entity.").replace("Dao", "");
            SqlProvider.setModelClass(Class.forName(modelName));
        }
    }

}
