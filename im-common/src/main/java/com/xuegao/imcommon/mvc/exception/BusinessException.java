package com.xuegao.imcommon.mvc.exception;


/**
 *
 */
public class BusinessException extends RuntimeException {

    private String message;
    // 异常编码
    private String code;

    // public BusinessException(ErrorEnum errorEnum) {
    //     super(errorEnum.getMsg(errorEnum.getCode()));
    //     this.code = errorEnum.getCode();
    // }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message, String code) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, String code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
