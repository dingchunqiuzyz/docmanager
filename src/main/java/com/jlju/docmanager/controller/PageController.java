package com.jlju.docmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zyz on 2016/11/21.
 */
@Controller
public class PageController {
    @RequestMapping("/topage/{page}")
    public String toPage(@PathVariable(value ="page" )String page){
        return "/"+page;
    }
    @RequestMapping("/uploadpage/{teacherCode}/{page}")
    public String toUpload(Model model,@PathVariable(value ="teacherCode" )String teacherCode,@PathVariable(value ="page" )String page){
        model.addAttribute("teacherCode",teacherCode);
        return "/static/"+page;
    }
}
