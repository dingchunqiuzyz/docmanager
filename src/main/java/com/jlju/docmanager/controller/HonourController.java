package com.jlju.docmanager.controller;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Honours;
import com.jlju.docmanager.dto.WebResult;
import com.jlju.docmanager.service.HonourService;
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
@RequestMapping("/honour")
public class HonourController extends BaseController{
    @Autowired
    private HonourService hs;
    @Autowired
    private Validator validator;

    @RequestMapping(value = "/insert",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> insert(Honours honours,String files){
        WebResult<Void> validateRet = ValidateUtils.validate(validator, honours);
        if(validateRet!=null){
            return validateRet;
        }
        try{
            int result = hs.insert(honours, files);
            if(result>0){
                return new WebResult<Void>(true,"成功上传"+(result-1)+"个文件到该教师文档库中");
            }else{
                return new WebResult<Void>(false,"保存失败！");
            }
        }catch (Exception e){
            return new WebResult<Void>(false,"保存失败！");
        }

    }
    @RequestMapping("/manager")
    public String manager(String hoName,String teacherName,Long teacherCode,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,Model model){
        //强制替换教工号
        teacherCode=getLoginTeacherCode()==null?teacherCode:getLoginTeacherCode();
        PageInfo<Honours> info = hs.selectHonoursWithTeachers(hoName,teacherName,pageNum,teacherCode);
        model.addAttribute("info",info);
        model.addAttribute("hoName",hoName);
        model.addAttribute("teacherName",teacherName);
        model.addAttribute("teacherCode",teacherCode);
        return "/manager/honour";
    }
    @RequestMapping(value = "/{uuid}/delete",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> delete(@PathVariable("uuid")String uuid){

        try{
            int result = hs.delete(uuid);
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
    public WebResult<Honours> detail(@PathVariable("uuid")String uuid){

        try{
            Honours honours = hs.selectById(uuid);
            if(honours!=null){
                return new WebResult<Honours>(true,"查询成功",honours);
            }else{
                return new WebResult<Honours>(false,"查询失败！",null);
            }
        }catch (Exception e){
            return new WebResult<Honours>(false,"查询失败"+e.getMessage(),null);
        }

    }

    @RequestMapping(value = "/update",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> update(Honours honours,String files){
        WebResult<Void> validateRet = ValidateUtils.validate(validator, honours);
        if(validateRet!=null){
            return validateRet;
        }
        try{
            int result = hs.update(honours, files);
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
