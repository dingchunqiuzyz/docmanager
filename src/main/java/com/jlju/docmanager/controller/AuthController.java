package com.jlju.docmanager.controller;

import com.jlju.docmanager.bean.Teachers;
import com.jlju.docmanager.bean.Users;
import com.jlju.docmanager.dto.WebResult;
import com.jlju.docmanager.service.TeacherService;
import com.jlju.docmanager.service.UsersSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * Created by zyz on 2016/11/23.
 */
@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController{

    @Autowired
    private UsersSerivce us;
    @Autowired
    private TeacherService teacherService;

    /**
     * @return
     */
    @RequestMapping(value = "/login", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> login(String username, String password) {

        WebResult<Users> result = us.login(username, password);
        if (result.isSuccess() && result.getData() != null) {
            //登录成功
            session.setAttribute("users", result.getData());
        }
        return new WebResult<Void>(result.isSuccess(), result.getMessage());
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        request.getSession().invalidate();
        return "redirect:/topage/login";
    }

    @RequestMapping(value = "/teacherLogin", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> teacherLogin(String username, String password) {

        Teachers teachers=null;
        try {
            Long teacherCode = Long.parseLong(username);
            teachers = teacherService.getByTeacherCode(teacherCode);
        }catch (NumberFormatException e) {
            return new WebResult<Void>(false, "教师用户的账号必须为教工号且必须为数字!");
        } catch (Exception e) {
            return new WebResult<Void>(false, "数据库链接失败,请联系运维!");
        }
        if (teachers == null) {
            return new WebResult<Void>(false, "账号不存在!");
        }

        if (!teachers.getPassword().equals(password)) {
            return new WebResult<Void>(false, "密码不正确!");
        }

        //登录成功
        request.getSession().setAttribute("teacher", teachers);
        return new WebResult<Void>(true, "登录成功！");
    }
}
