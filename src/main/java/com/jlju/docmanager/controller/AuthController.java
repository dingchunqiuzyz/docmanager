package com.jlju.docmanager.controller;

import com.jlju.docmanager.bean.Users;
import com.jlju.docmanager.dto.WebResult;
import com.jlju.docmanager.service.UsersSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zyz on 2016/11/23.
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsersSerivce us;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/login",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> login(String username,String password, HttpServletRequest request){

        WebResult<Users> result = us.login(username, password);
        if(result.isSuccess()&&result.getData()!=null){
            //登录成功
            HttpSession session = request.getSession();
            session.setAttribute("users",result.getData());
        }
        return new WebResult<Void>(result.isSuccess(),result.getMessage());
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/topage/login";
    }
}
