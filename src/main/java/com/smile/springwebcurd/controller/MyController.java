package com.smile.springwebcurd.controller;

import com.smile.springwebcurd.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class MyController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
        if(user.equals("a")){
            throw new MyException();
        }
        return "Hello World!";
    }

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session) {

        if(username != null && password.equals("123")) {
            session.setAttribute("loginUser", username);
            return "redirect:/main";
        } else {
            map.put("msg", "Username or password is error!");
            return "login";
        }
    }
}