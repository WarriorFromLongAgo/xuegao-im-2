package com.xuegao.imcommon.constant.aop.annotation;

import java.lang.annotation.*;

/**
 * <br/> @PackageName：com.xuegao.xuegaoimcommon.constant.aop.annotation
 * <br/> @ClassName：RedisLimit
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/11/21 11:42
 */
@Inherited
@Documented
@Target(value = {ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface RedisLimit {

    /**
     * 描述
     */
    String description() default "";

    /**
     * 限流key
     */
    String key() default "redisLimit";

    /**
     * 单位时间限制通过请求数
     */
    int limitCount() default 1;

    /**
     * 限流时间
     * 过期时间，单位毫秒
     */
    int expireTime() default 500;

    /**
     * 限流的类型(用户自定义key 或者 请求ip)
     */
    LimitType limitType() default LimitType.CUSTOMER;

    enum LimitType {
        /**
         * 自定义key
         */
        CUSTOMER,
        /**
         * 根据请求者IP
         */
        IP
    }
}