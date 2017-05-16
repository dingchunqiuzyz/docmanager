package com.jlju.docmanager.interceptor;

import com.jlju.docmanager.bean.Users;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zyz on 2016/11/23.
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Users users = (Users) request.getSession().getAttribute("users");
        if(users ==null){
            request.setAttribute("message","您的身份已经过期，请重新登录");
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
            return  false;
        }
        return  true;
    }
}
