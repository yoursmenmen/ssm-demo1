package com.mingming.exception;

/**
 * 业务异常
 *
 * @author h
 * @date 2022/08/12
 */
public class BusinessException extends RuntimeException{
    private Integer code;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException( Integer code, Throwable cause, String message) {
        super(message, cause);
        this.code = code;
    }
}
