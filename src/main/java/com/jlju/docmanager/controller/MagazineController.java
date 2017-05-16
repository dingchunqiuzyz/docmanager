package com.jlju.docmanager.controller;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Magazine;
import com.jlju.docmanager.dto.WebResult;
import com.jlju.docmanager.service.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Created by zyz on 2016/11/21.
 */
@Controller
@RequestMapping("/magazine")
public class MagazineController {
    @Autowired
    private MagazineService ms;

    @RequestMapping(value = "/insert",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> insert(Magazine magazine,String files){

        try{
            int result = ms.insert(magazine, files);
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
    public String manager(String magName,String teacherName,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,Model model){
        PageInfo<Magazine> info = ms.queryMagazine(magName,teacherName, pageNum);
        model.addAttribute("info",info);
        model.addAttribute("magName",magName);
        model.addAttribute("teacherName",teacherName);
        return "/manager/magazine";
    }
    @RequestMapping(value = "/{uuid}/delete",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> delete(@PathVariable("uuid")String uuid){

        try{
            int result = ms.delete(uuid);
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
    public WebResult<Magazine> detail(@PathVariable("uuid")String uuid){

        try{
            Magazine magazine = ms.selectById(uuid);
            if(magazine!=null){
                return new WebResult<Magazine>(true,"查询成功",magazine);
            }else{
                return new WebResult<Magazine>(false,"查询失败！",null);
            }
        }catch (Exception e){
            return new WebResult<Magazine>(false,"查询失败"+e.getMessage(),null);
        }

    }

    @RequestMapping(value = "/update",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> update(Magazine magazine,String files){

        try{
            int result = ms.update(magazine, files);
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
