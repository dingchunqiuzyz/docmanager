package com.jlju.docmanager.controller;

import com.jlju.docmanager.bean.Teachers;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * User: 张月忠
 * Date: 2017/5/25
 * Time: 上午10:28
 * To change this template use File | Settings | File Templates.
 */

public class BaseController {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    @ModelAttribute
    public void setAttribute(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        this.request=request;
        this.response=response;
        this.session=session;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public HttpSession getSession() {
        return session;
    }

    public Long getLoginTeacherCode(){
        Teachers teachers= (Teachers) session.getAttribute("teacher");
        if(teachers!=null){
           return teachers.getTeacherCode();
        }
        return  null;
    }
}
