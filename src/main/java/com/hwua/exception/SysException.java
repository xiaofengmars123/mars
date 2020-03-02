package com.hwua.exception;

/**
 * 自定义一个异常类，用来处理所有的异常，自定义的那个类属于非受查异常
 */
public class SysException extends RuntimeException {
    private String message;//封装错误信息的属性

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
