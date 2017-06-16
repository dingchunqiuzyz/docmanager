package com.jlju.docmanager.controller;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.QueryCache;
import com.jlju.docmanager.dto.WebResult;
import com.jlju.docmanager.dto.echarts.Bar;
import com.jlju.docmanager.dto.echarts.Data;
import com.jlju.docmanager.dto.echarts.Pie;
import com.jlju.docmanager.dto.echarts.Title;
import com.jlju.docmanager.service.QueryCacheService;
import com.jlju.docmanager.service.SearchService;
import com.jlju.docmanager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by zyz on 2016/11/17.
 */
@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService service;
    @Autowired
    private QueryCacheService queryCacheService;

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


    @RequestMapping(value = "/count",produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    @ResponseBody
    public WebResult<Map<String,Object>> count(){
        try{
            List<Data> top6Datas = queryCacheService.countFileTop6();
            List<Data> fileTypeDatas = queryCacheService.countFileType();
//            /////柱状体
            Title barTitle = new Title();
            barTitle.setText("上传文档数量前六名");
            barTitle.setX("center");
            Bar bar = new Bar();
            bar.setDatas(top6Datas);
            bar.setTitle(barTitle);
//            ////饼状图
            Title pieTitle = new Title();
            pieTitle.setText("上传文档类型分布比例");
            pieTitle.setSubtext("按面积展示%");
            pieTitle.setX("center");
            Pie pie = new Pie();
            pie.setTitle(pieTitle);
            pie.setDatas(fileTypeDatas);
            Map<String,Object> map =new HashMap<>();
            map.put("bar",bar);
            map.put("pie",pie);
            return new WebResult<Map<String,Object>>(true,"统计成功!",map);
        }catch (Exception e){
            return new WebResult<Map<String,Object>>(false,"统计失败！"+e.getMessage());
        }

    }
}
