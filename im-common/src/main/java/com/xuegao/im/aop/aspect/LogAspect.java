package com.xuegao.im.aop.aspect;

import com.alibaba.fastjson.JSON;
import com.xuegao.im.aop.annotaion.PrintlnLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * <br/> @PackageName：com.xuegao.springboot_tool.constant.aop.aspect
 * <br/> @ClassName：LogAspect
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/7/21 10:26
 */
@Aspect
// @Order(1)
@Component
public class LogAspect {
    private final Logger log = LoggerFactory.getLogger(getClass());
    // 另起一行
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final ThreadLocal<Long> LONG_THREAD_LOCAL = new ThreadLocal<>();

    /**
     * <br/> @Title:
     * <br/> @MethodName:  PrintlnLog
     * <br/>
     * <br/> @Return void
     * <br/> @Description: 以自定义 @PrintlnLog 注解作为切面入口
     * <br/> @author: xuegao
     * <br/> @date:  2020/7/21 10:35
     */
    @Pointcut("@annotation(com.xuegao.im.aop.annotaion.PrintlnLog)")
    public void PrintlnLog() {
    }

    /**
     * <br/> @Title:
     * <br/> @MethodName:  doBefore
     * <br/> @param joinPoint:
     * <br/> @Return void
     * <br/> @Description: 切面方法入参日志打印
     * <br/> @author: xuegao
     * <br/> @date:  2020/7/21 10:36
     */
    @Before("PrintlnLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String methodDetailDescription = this.getAspectMethodLogDescJP(joinPoint);

        log.info("------------------------------- start --------------------------");
        /**
         * 打印自定义方法描述
         */
        log.info("Method detail Description: {}", methodDetailDescription);
        /**
         * 打印请求入参
         */
        log.info("Request Args: {}", JSON.toJSONString(joinPoint.getArgs()));
        /**
         * 打印请求方式
         */
        log.info("Request method: {}", request.getMethod());
        /**
         * 打印请求 url
         */
        log.info("Request URL: {}", request.getRequestURL().toString());

        /**
         * 打印调用方法全路径以及执行方法
         */
        log.info("Request Class and Method: {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        log.info(Thread.currentThread().getName() + " = indexController = 执行前");
    }

    /**
     * <br/> @Title:
     * <br/> @MethodName:  doAround
     * <br/> @param proceedingJoinPoint:
     * <br/> @Return java.lang.Object
     * <br/> @Description: 切面方法返回结果日志打印
     * <br/> @author: xuegao
     * <br/> @date:  2020/7/21 10:38
     */
    @Around("PrintlnLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String aspectMethodLogDescPJ = getAspectMethodLogDescPJ(proceedingJoinPoint);
        Object result = proceedingJoinPoint.proceed();
        log.info(Thread.currentThread().getName() + " = indexController = 执行后");
        long startTime = System.currentTimeMillis();
        LONG_THREAD_LOCAL.set(startTime);
        /**
         * 输出结果
         */
        log.info("{}，Response result  : {}", aspectMethodLogDescPJ, JSON.toJSONString(result));

        /**
         * 方法执行耗时
         */
        log.info("Time Consuming: {} ms", System.currentTimeMillis() - startTime);

        log.info("------------------------------- End --------------------------" + LINE_SEPARATOR);
        return result;
    }

    /**
     * <br/> @Title:
     * <br/> @MethodName:  doAfter
     * <br/> @param joinPoint:
     * <br/> @Return void
     * <br/> @Description: 切面方法执行后执行
     * <br/> @author: xuegao
     * <br/> @date:  2020/7/21 10:38
     */
    // @After("PrintlnLog()")
    // public void doAfter(JoinPoint joinPoint) throws Throwable {
    //     log.info("------------------------------- End --------------------------" + LINE_SEPARATOR);
    // }
    @AfterThrowing("PrintlnLog()")
    public void doAfterThrowing(JoinPoint joinPoint) throws Throwable {
        /**
         * 方法执行耗时
         */
        log.info(Thread.currentThread().getName() + " =  doAfterThrowing ");
        log.info("------------------------------- End --------------------------" + LINE_SEPARATOR);
    }

    /**
     * <br/> @Title:
     * <br/> @MethodName:  getAspectMethodLogDescJP
     * <br/> @param joinPoint:
     * <br/> @Return java.lang.String
     * <br/> @Description: @PrintlnLog 注解作用的切面方法详细细信息
     * <br/> @author: xuegao
     * <br/> @date:  2020/7/21 10:38
     */
    public String getAspectMethodLogDescJP(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        return getAspectMethodLogDesc(targetName, methodName, arguments);
    }

    /**
     * <br/> @Title:
     * <br/> @MethodName:  getAspectMethodLogDescPJ
     * <br/> @param proceedingJoinPoint:
     * <br/> @Return java.lang.String
     * <br/> @Description: 注解作用的切面方法详细细信息
     * <br/> @author: xuegao
     * <br/> @date:  2020/7/21 10:39
     */
    public String getAspectMethodLogDescPJ(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
        String targetName = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] arguments = proceedingJoinPoint.getArgs();
        return getAspectMethodLogDesc(targetName, methodName, arguments);
    }

    /**
     * <br/> @Title:
     * <br/> @MethodName:  getAspectMethodLogDesc
     * <br/> @param targetName:
     * <br/> @param methodName:
     * <br/> @param arguments:
     * <br/> @Return java.lang.String
     * <br/> @Description: 自定义注解参数
     * <br/> @author: xuegao
     * <br/> @date:  2020/7/21 10:39
     */
    public String getAspectMethodLogDesc(String targetName, String methodName, Object[] arguments) throws Exception {
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuilder description = new StringBuilder();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description.append(method.getAnnotation(PrintlnLog.class).description());
                    break;
                }
            }
        }
        return description.toString();
    }
}