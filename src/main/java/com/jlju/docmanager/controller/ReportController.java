package com.jlju.docmanager.controller;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Magazine;
import com.jlju.docmanager.bean.Report;
import com.jlju.docmanager.dto.WebResult;
import com.jlju.docmanager.service.MagazineService;
import com.jlju.docmanager.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Created by zyz on 2016/11/21.
 */
@Controller
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService rs;

    @RequestMapping(value = "/insert",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> insert(Report report, String files){

        try{
            int result = rs.insert(report, files);
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
    public String manager(String repName,String teacherName,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,Model model){
        PageInfo<Report> info = rs.selectReportWithTeachers(pageNum,repName,teacherName);
        model.addAttribute("info",info);
        model.addAttribute("repName",repName);
        model.addAttribute("teacherName",teacherName);
        return "/manager/report";
    }
    @RequestMapping(value = "/{uuid}/delete",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> delete(@PathVariable("uuid")String uuid){

        try{
            int result = rs.delete(uuid);
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
    public WebResult<Report> detail(@PathVariable("uuid")String uuid){

        try{
            Report report  = rs.selectById(uuid);
            if(report!=null){
                return new WebResult<Report>(true,"查询成功",report);
            }else{
                return new WebResult<Report>(false,"查询失败！",null);
            }
        }catch (Exception e){
            return new WebResult<Report>(false,"查询失败"+e.getMessage(),null);
        }

    }

    @RequestMapping(value = "/update",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public WebResult<Void> update(Report report,String files){

        try{
            int result = rs.update(report, files);
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
