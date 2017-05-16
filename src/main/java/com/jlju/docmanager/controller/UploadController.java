package com.jlju.docmanager.controller;

import com.jlju.docmanager.dto.FileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyz on 2016/11/21.
 */
@Controller
public class UploadController {
    @Value("#{configProperties['virtualPath']}")
    private String VIRTUAL_PATH;
    @Value("#{configProperties['FileRoot']}")
    private String FILE_ROOT;

    @RequestMapping(value = "/upload",method= RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String,FileUpload> upload(@RequestParam("file") MultipartFile file){
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String format = df.format(date);
        //获取原来的文件名
        String fileFullName= file.getOriginalFilename();
        //扩展名
        String extName = null;
        //获取扩展名
        if(fileFullName.contains(".")){
            extName = fileFullName.substring(fileFullName.lastIndexOf("."));
        }else{
            extName="";
        }
        //开始读写
        File rootPath = new File(FILE_ROOT+"/"+format);

        if (!rootPath.exists()){
            rootPath.mkdirs();
        }

        FileOutputStream fos = null;
        try {
             fos = new FileOutputStream(new File(rootPath,date.getTime()+extName));
            IOUtils.copy(file.getInputStream(),fos);


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(file.getInputStream()!=null){
                    file.getInputStream().close();
                }
                if(fos!=null){
                    fos.close();
                }
            }catch (Exception e){

            }
        }
        FileUpload fileUpload = new FileUpload(fileFullName,"/"+format+"/"+date.getTime()+extName);
        Map<String,FileUpload> result = new HashMap<String, FileUpload>();
        result.put("path",fileUpload);
        return result;
    }
}
