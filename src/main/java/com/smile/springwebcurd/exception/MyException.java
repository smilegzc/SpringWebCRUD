package com.smile.springwebcurd.exception;

/**
 * 自定义异常
 */
public class MyException extends RuntimeException {
    public MyException(){
        super("用户不存在!");
    }
}
