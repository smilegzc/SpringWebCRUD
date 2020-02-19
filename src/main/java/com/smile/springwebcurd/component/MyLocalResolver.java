package com.smile.springwebcurd.component;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 国际化组件
 * 本地化，修改显示语言
 */
public class MyLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String local = request.getParameter("local");
        Locale locale = Locale.getDefault();
        if(local != null) {
            String[] split = local.split("_");
            locale = new Locale(split[0], split[1]);
            request.getSession().setAttribute("local", locale);
        } else {
            Locale localInSession = (Locale)request.getSession().getAttribute("local");
            if(localInSession != null) {
                locale = localInSession;
            }
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
