package com.xuegao.im.aop.annotaion;

import java.lang.annotation.*;

/**
 * <br/> @PackageName：com.xuegao.springboot_tool.constant.aop.annotation
 * <br/> @ClassName：PrintlnLog
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/7/21 10:23
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface PrintlnLog {
    /**
     * 自定义日志描述信息文案 
     */
    String description() default "";
}
