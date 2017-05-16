package com.jlju.docmanager.controller;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Teachers;
import com.jlju.docmanager.dto.WebResult;
import com.jlju.docmanager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zyz on 2016/11/9.
 */
@Controller
@RequestMapping("/teachers")
public class TeacherController {


    @Autowired
    private TeacherService us;
    /**
     * 查询所有教师
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model,Teachers teachers,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum){
        PageInfo<Teachers> info = us.queryPage(pageNum, teachers);
        model.addAttribute("info",info);
        model.addAttribute("teachers",teachers);
        return "teachers/list";
    }
    @RequestMapping(value = "/edit",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> edit(Teachers teachers){
        int result = -1;
        try {
            if(teachers.getTeacherId()!=null&&teachers.getTeacherId()>0){
                //修改
                result =us.updateTeachers(teachers);
            }else {
                //添加
                result = us.insertTeachers(teachers);
            }
            if(result>0){
                return new WebResult<Void>(true,"操作成功");
            }else{
                return new WebResult<Void>(false,"操作失败");
            }

        }catch (Exception e){
            return new WebResult<Void>(false,"操作失败:可能原因：该教师号已经注册过了\n\r"+e.getMessage());
        }

    }

    @RequestMapping(value = "/{teacherId}/detail",produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    @ResponseBody
    public WebResult<Teachers> detail(@PathVariable("teacherId")Integer teacherId){
        Teachers teachers=null;
        try {
            if(teacherId!=null){
                teachers=us.selectById(teacherId);
            }
            if(teacherId==null||teachers==null){
                return new WebResult<Teachers>(false,"查找失败");
            }else{
                return new WebResult<Teachers>(true,"查找成功",teachers);
            }
        }catch (Exception e){
            return new WebResult<Teachers>(false,"操作失败:"+e.getMessage());
        }

    }


    @RequestMapping(value = "/{teacherId}/delete",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> delete(@PathVariable("teacherId")Integer teacherId){
        int result = -1;
        try {
            if(teacherId!=null){
                result = us.deleteById(teacherId);
            }
            if(result>0){
                return new WebResult<Void>(true,"删除成功！");
            }else{
                return new WebResult<Void>(false,"删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new WebResult<Void>(false,"操作失败:"+e.getMessage());
        }

    }

    @RequestMapping(value = "/queryTeacher",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<String> queryTeacher(String teacherName){
       String result= us.selectTeacherByNameAsJson(teacherName);
        if(result==null){
            return  new WebResult<String>(false,"查询失败");
        }else{
            return  new WebResult<String>(true,"查询成功",result);
        }

    }
}
