package com.smile.springwebcurd.controller;

import com.smile.springwebcurd.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

//    @ResponseBody
//    @ExceptionHandler(MyException.class)
//    public Map<String, Object> handlerException(){
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "user not found");
//        map.put("message", "没有这个用户");
//        return map;
//    }

    /**
     * 当MyException.class触发以后，将界面转发到error界面，以便让模板引擎(Thymeleaf)自动解析界面
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(MyException.class)
    public String handlerException(Exception e, HttpServletRequest request) {
        request.setAttribute("javax.servlet.error.status_code", 500);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user not found");
        map.put("message", "没有这个用户");
        return "forward:/error";
    }
}
