package com.jlju.docmanager.controller;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Magazine;
import com.jlju.docmanager.bean.Patents;
import com.jlju.docmanager.bean.Projects;
import com.jlju.docmanager.dto.WebResult;
import com.jlju.docmanager.service.PatentService;
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
@RequestMapping("/patent")
public class PatentController extends BaseController{
    @Autowired
    private PatentService ps;
    @Autowired
    private Validator validator;

    @RequestMapping(value = "/insert",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> insert(Patents p,String files){
        WebResult<Void> validateRet = ValidateUtils.validate(validator, p);
        if(validateRet!=null){
            return validateRet;
        }
        try{
            int result = ps.insert(p, files);
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
    public String manager(String patName,String teacherName,Long teacherCode,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,Model model){
        //强制替换教工号
        teacherCode=getLoginTeacherCode()==null?teacherCode:getLoginTeacherCode();
        PageInfo<Patents> info = ps.selectPatentsWithTeachers(patName,teacherName,teacherCode,pageNum);
        model.addAttribute("info",info);
        model.addAttribute("patName",patName);
        model.addAttribute("teacherName",teacherName);
        return "/manager/patent";
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
    public WebResult<Patents> detail(@PathVariable("uuid")String uuid){

        try{
            Patents patents = ps.selectById(uuid);
            if(patents!=null){
                return new WebResult<Patents>(true,"查询成功",patents);
            }else{
                return new WebResult<Patents>(false,"查询失败！",null);
            }
        }catch (Exception e){
            return new WebResult<Patents>(false,"查询失败"+e.getMessage(),null);
        }

    }

    @RequestMapping(value = "/update",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> update(Patents patents,String files){
        WebResult<Void> validateRet = ValidateUtils.validate(validator, patents);
        if(validateRet!=null){
            return validateRet;
        }
        try{
            int result = ps.update(patents, files);
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
