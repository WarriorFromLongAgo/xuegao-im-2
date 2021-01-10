package com.xuegao.imcommon.mvc.exception;

/**
 * <br/> @PackageName：com.xuegao.springboot_tool.mvc.exception
 * <br/> @ClassName：RedisLimitException
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/9/23 18:59
 */
public class RedisLimitException extends RuntimeException {

    public RedisLimitException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "RedisLimitException{" + "message=" + this.getMessage() + '}';
    }

    /* avoid the expensive and useless stack trace for api exceptions */
    /* 翻译：避免对api异常进行昂贵且无用的堆栈跟踪 */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}