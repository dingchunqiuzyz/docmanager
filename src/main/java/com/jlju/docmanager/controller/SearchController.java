package com.jlju.docmanager.controller;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.QueryCache;
import com.jlju.docmanager.service.SearchService;
import com.jlju.docmanager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by zyz on 2016/11/17.
 */
@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService service;

    @Value("#{configProperties['virtualPath']}")
    private String VIRTUAL_PATH;

    @Autowired
    private TeacherService teacherService;
    @RequestMapping("/list")
    public String search(Model model,QueryCache cache,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum){
    PageInfo<QueryCache> info = service.search(cache, pageNum);
        model.addAttribute("info",info);
        model.addAttribute("cache",cache);
        return "/search/list";
    }

    @RequestMapping("/hasUpload")
    public String search4upload(Model model,QueryCache cache,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum){
        PageInfo<QueryCache> info = service.search(cache, pageNum);
        model.addAttribute("info",info);
        model.addAttribute("cache",cache);
        return "/hasupload";
    }
    @RequestMapping("/{cacheId}/preview")
    public String preview(Model model,@PathVariable("cacheId")Integer cacheId){

        if(cacheId!=null&&cacheId>0){
            QueryCache cache = service.selectById(cacheId);
            if(cache!=null) {
                cache.setFilePath(VIRTUAL_PATH+cache.getFilePath());
                model.addAttribute("c", cache);
            }
        }
        return "/search/preview";
    }

}
