package com.sy.exception;

/**
 * 这个自定义异常，用于在项目中抛出业务相关的异常，通常都是我们手动自己抛出的异常
 * 一般可能就是校验不通过，业务逻辑不符合某些条件，……
 */
import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {
    private HttpStatus status;

    public BusinessException() {
    }

    public BusinessException(HttpStatus httpStatus, String message) {
        super(message);
        this.status = httpStatus;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
