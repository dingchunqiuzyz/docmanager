package com.jlju.docmanager.controller;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Works;
import com.jlju.docmanager.dto.WebResult;
import com.jlju.docmanager.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Created by zyz on 2016/11/21.
 */
@Controller
@RequestMapping("/work")
public class WorkController extends BaseController{
    @Autowired
    private WorkService ws;

    @RequestMapping(value = "/insert",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> insert(Works works,String files){
        try{
            int result = ws.insert(works, files);
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

    @RequestMapping(value = "/{uuid}/delete",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> delete(@PathVariable("uuid")String uuid){

        try{
            int result = ws.delete(uuid);
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
    public WebResult<Works> detail(@PathVariable("uuid")String uuid){

        try{
            Works works = ws.selectById(uuid);
            if(works!=null){
                return new WebResult<Works>(true,"查询成功",works);
            }else{
                return new WebResult<Works>(false,"查询失败！",null);
            }
        }catch (Exception e){
            return new WebResult<Works>(false,"查询失败"+e.getMessage(),null);
        }

    }

    @RequestMapping(value = "/update",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> update(Works magazine,String files){

        try{
            int result = ws.update(magazine, files);
            if(result>0){
                return new WebResult<Void>(true,"更新成功");
            }else{
                return new WebResult<Void>(false,"保存失败！");
            }
        }catch (Exception e){
            return new WebResult<Void>(false,"保存失败！"+e.getMessage());
        }

    }

    @RequestMapping("/manager")
    public String manager(String workName,String teacherName,Long teacherCode,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,Model model){
        teacherCode=getLoginTeacherCode()==null?teacherCode:getLoginTeacherCode();
        PageInfo<Works> info = ws.selectWroksWithTeachers(workName,teacherName,pageNum,teacherCode);
        model.addAttribute("info",info);
        model.addAttribute("workName",workName);
        model.addAttribute("teacherName",teacherName);
        model.addAttribute("teacherCode",teacherCode);
        return "/manager/work";
    }
}
