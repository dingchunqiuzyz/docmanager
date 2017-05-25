package com.jlju.docmanager.controller;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Projects;
import com.jlju.docmanager.dto.WebResult;
import com.jlju.docmanager.service.ProjectService;
import com.jlju.docmanager.utils.ValidateUtils;
import net.sf.oval.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Created by zyz on 2016/11/21.
 */
@Controller
@RequestMapping("/project")
public class ProjectController extends BaseController{
    @Autowired
    private ProjectService ps;

    @Autowired
    private Validator validator;

    @RequestMapping(value = "/insert",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> insert(Projects projects,String files){
        WebResult<Void> validateRet = ValidateUtils.validate(validator, projects);
        if(validateRet!=null){
            return validateRet;
        }
        try{
            int result = ps.insert(projects, files);
            if(result>0){
                return new WebResult<Void>(true,"成功上传"+(result-1)+"个文件到该教师文档库中");
            }else{
                return new WebResult<Void>(false,"保存失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new WebResult<Void>(false,"保存失败！");
        }
    }
    @RequestMapping("/manager")
    public String manager(String proName,String teacherName,Long teacherCode,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,Model model){
        teacherCode=getLoginTeacherCode()==null?teacherCode:getLoginTeacherCode();
        PageInfo<Projects> info = ps.projectsWithTeachers(pageNum,proName,teacherName,teacherCode);
        model.addAttribute("info",info);
        model.addAttribute("proName",proName);
        model.addAttribute("teacherName",teacherName);
        model.addAttribute("teacherCode",teacherCode);
        return "/manager/project";
    }
    @RequestMapping(value = "/{uuid}/delete",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> delete(@PathVariable("uuid")String uuid){

        try{
            int result = ps.delete(uuid);
            if(result>0){
                return new WebResult<Void>(true,"删除成功");
            }else{
                return new WebResult<Void>(false,"保存失败！");
            }
        }catch (Exception e){
            return new WebResult<Void>(false,"保存失败！");
        }

    }

    @RequestMapping(value = "/{uuid}/detail",produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    @ResponseBody
    public WebResult<Projects> detail(@PathVariable("uuid")String uuid){

        try{
            Projects projects = ps.selectById(uuid);
            if(projects!=null){
                return new WebResult<Projects>(true,"查询成功",projects);
            }else{
                return new WebResult<Projects>(false,"查询失败！",null);
            }
        }catch (Exception e){
            return new WebResult<Projects>(false,"查询失败"+e.getMessage(),null);
        }

    }

    @RequestMapping(value = "/update",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> update(Projects projects,String files){
        WebResult<Void> validateRet = ValidateUtils.validate(validator, projects);
        if(validateRet!=null){
            return validateRet;
        }
        try{
            int result = ps.update(projects, files);
            if(result>0){
                return new WebResult<Void>(true,"更新成功");
            }else{
                return new WebResult<Void>(false,"保存失败！");
            }
        }catch (Exception e){
            return new WebResult<Void>(false,"保存失败！"+e.getMessage());
        }

    }
}
