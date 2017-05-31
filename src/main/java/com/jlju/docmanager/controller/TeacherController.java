package com.jlju.docmanager.controller;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Teachers;
import com.jlju.docmanager.dto.SugResult;
import com.jlju.docmanager.dto.WebResult;
import com.jlju.docmanager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by zyz on 2016/11/9.
 */
@Controller
@RequestMapping("/teachers")
public class TeacherController extends BaseController{


    @Autowired
    private TeacherService teacherService;

    /**
     * 查询所有教师
     *
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model, Teachers teachers, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageInfo<Teachers> info = teacherService.queryPage(pageNum, teachers);
        model.addAttribute("info", info);
        model.addAttribute("teachers", teachers);
        return "teachers/list";
    }

    @RequestMapping(value = "/edit", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> edit(Teachers teachers) {
        int result = -1;
        try {
            if (teachers.getTeacherId() != null && teachers.getTeacherId() > 0) {
                //修改
                result = teacherService.updateTeachers(teachers);
                Teachers teacher = (Teachers) session.getAttribute("teacher");
                if(teacher!=null&&teacher.getTeacherCode().equals(teachers.getTeacherCode())){
                    session.setAttribute("teacher",teachers);
                }
            } else {
                //添加
                result = teacherService.insertTeachers(teachers);
            }
            if (result > 0) {
                return new WebResult<Void>(true, "操作成功");
            } else {
                return new WebResult<Void>(false, "操作失败");
            }

        } catch (Exception e) {
            return new WebResult<Void>(false, "操作失败:可能原因：该教师号已经注册过了\n\r" + e.getMessage());
        }

    }

    @RequestMapping(value = "/{teacherId}/detail", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    @ResponseBody
    public WebResult<Teachers> detail(@PathVariable("teacherId") Integer teacherId) {
        Teachers teachers = null;
        try {
            if (teacherId != null) {
                teachers = teacherService.selectById(teacherId);
            }
            if (teacherId == null || teachers == null) {
                return new WebResult<Teachers>(false, "查找失败");
            } else {
                return new WebResult<Teachers>(true, "查找成功", teachers);
            }
        } catch (Exception e) {
            return new WebResult<Teachers>(false, "操作失败:" + e.getMessage());
        }

    }


    @RequestMapping(value = "/{teacherId}/delete", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> delete(@PathVariable("teacherId") Integer teacherId) {
        int result = -1;
        try {
            if (teacherId != null) {
                result = teacherService.deleteById(teacherId);
            }
            if (result > 0) {
                return new WebResult<Void>(true, "删除成功！");
            } else {
                return new WebResult<Void>(false, "删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new WebResult<Void>(false, "操作失败:" + e.getMessage());
        }

    }

//    @RequestMapping(value = "/queryTeacher", produces = {"application/json;charset=UTF-8"})
//    @ResponseBody
//    public WebResult<String> queryTeacher(String teacherName) {
//        String result = teacherService.selectTeacherByNameAsJson(teacherName);
//        if (result == null) {
//            return new WebResult<String>(false, "查询失败");
//        } else {
//            return new WebResult<String>(true, "查询成功", result);
//        }
//
//    }

    @RequestMapping(value = "/queryTeacher", produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public SugResult<Teachers> queryTeacher(String teacherName) {
        List<Teachers> teachersList = teacherService.selectTeacherByName(teacherName);
        if (teachersList != null) {
            return new SugResult<Teachers>("查询成功",200,teachersList,"");
        } else {
            return new SugResult<Teachers>("查询失败",500,teachersList,"");
        }

    }

    /**
     * 批量导入教师信息
     *
     * @return
     */
    @RequestMapping(value = "/batchImport", method = RequestMethod.POST)
    public String batchImport(@RequestParam("file") MultipartFile file, Model model) {
        String message;
        String page = "/message";
        WebResult<String> webResult;
        try {
            teacherService.batchInsert(file);
            message = "成功添加教师信息到教师库中！";
            webResult = new WebResult<String>(true, message, request.getContextPath()+"/teachers/list");//导出更高
        } catch (Exception e) {
            message = e.getMessage();
            webResult = new WebResult<String>(false, message, request.getContextPath()+"/teachers/toPage/import");//重新导入
        }

        model.addAttribute("result", webResult);
        return page;
    }

    /**
     * 界面跳转
     *
     * @return
     */
    @RequestMapping(value = "/toPage/{page}", method = RequestMethod.GET)
    public String toPage(@PathVariable("page") String page) {

        return "/teachers/" + page;
    }
}
