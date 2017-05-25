package com.jlju.docmanager.controller;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Magazine;
import com.jlju.docmanager.bean.Prizes;
import com.jlju.docmanager.dto.WebResult;
import com.jlju.docmanager.service.MagazineService;
import com.jlju.docmanager.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Created by zyz on 2016/11/21.
 */
@Controller
@RequestMapping("/prize")
public class PrizeController extends BaseController{
    @Autowired
    private PrizeService ps;

    @RequestMapping(value = "/insert",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> insert(Prizes p,String files){

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
    public String manager(String priName,String teacherName,Long teacherCode,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,Model model){
        teacherCode=getLoginTeacherCode()==null?teacherCode:getLoginTeacherCode();
        PageInfo<Prizes> info = ps.selectPrizisWithTeachers(pageNum,priName,teacherName,teacherCode);
        model.addAttribute("info",info);
        model.addAttribute("priName",priName);
        model.addAttribute("teacherName",teacherName);
        model.addAttribute("teacherCode",teacherCode);
        return "/manager/prize";
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
    public WebResult<Prizes> detail(@PathVariable("uuid")String uuid){

        try{
            Prizes patents = ps.selectById(uuid);
            if(patents!=null){
                return new WebResult<Prizes>(true,"查询成功",patents);
            }else{
                return new WebResult<Prizes>(false,"查询失败！",null);
            }
        }catch (Exception e){
            return new WebResult<Prizes>(false,"查询失败"+e.getMessage(),null);
        }

    }

    @RequestMapping(value = "/update",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> update(Prizes prizes,String files){

        try{
            int result = ps.update(prizes, files);
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
