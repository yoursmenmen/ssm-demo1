package com.mingming.exception;

/**
 * 系统异常
 *
 * @author h
 * @date 2022/08/12
 */
public class SystemException extends RuntimeException{

    private Integer code;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public SystemException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException( Integer code, Throwable cause, String message) {
        super(message, cause);
        this.code = code;
    }

}
