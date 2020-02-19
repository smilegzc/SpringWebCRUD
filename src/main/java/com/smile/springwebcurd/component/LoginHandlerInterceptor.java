package com.smile.springwebcurd.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器组件
 * 配置拦截器，进行登录检查
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if(user == null) {
            request.setAttribute("msg", "没有权限，请登录");
            request.getRequestDispatcher("/index").forward(request, response);
            return false;
        }

        return true;
    }
}
