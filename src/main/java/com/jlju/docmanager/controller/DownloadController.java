package com.jlju.docmanager.controller;

import com.jlju.docmanager.bean.QueryCache;
import com.jlju.docmanager.service.QueryCacheService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by zyz on 2016/11/23.
 */
@Controller
@RequestMapping("/download")
public class DownloadController {
    @Autowired
    private QueryCacheService service;
    @Value("#{configProperties['FileRoot']}")
    private String FILE_ROOT;

    @RequestMapping("/{cacheId}/one")
    public void one(@PathVariable("cacheId") Integer cacheId, HttpServletResponse response) throws IOException {
        QueryCache cache = service.selectById(cacheId);
        String path = cache.getFilePath();
        String realPath = FILE_ROOT + path;

        try {
            InputStream in = new FileInputStream(new File(realPath));
            OutputStream os = response.getOutputStream();
            downloadFile(in, os, cache.getFileName(), response);
        } catch (Exception e) {
            //下载失败
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<script type='text/javascript'>alert('对不起你要下载的内容不存在');window.history.back();</script>");
        }

    }

    @RequestMapping("/many")
    public void many(@RequestParam("ids")ArrayList<Integer> ids, HttpServletResponse response) throws IOException {
        try {
            List<QueryCache> caches = service.listByIds(ids);
            List<File> files = new ArrayList<File>();
            List<String> names = new ArrayList<String>();
            if(caches!=null&&caches.size()>0){
                for(int i =0;i<caches.size();i++){
                    QueryCache c = caches.get(i);
                    File file =new File(FILE_ROOT+c.getFilePath());
                    if(!file.exists())
                        throw  new Exception(c.getFileName());
                    files.add(file);
                    names.add((i+1)+c.getFileName());
                }
            }
            if(files.size()>0){
                downZip(response,files,names);
            }
        } catch (Exception e) {
            //下载失败
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<script type='text/javascript'>alert('对不起你要下载"+e.getMessage()+"的内容不存在');window.history.back();</script>");
        }

    }


    private void downloadFile(InputStream in, OutputStream os, String fileName, HttpServletResponse response) throws IOException {
        try {
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("content-type", "application/octet-stream");
            IOUtils.copy(in, os);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }

            if (os != null) {
                os.close();
            }
        }
    }

    private void downZip(HttpServletResponse response, List<File> files,List<String> names) throws Exception {
            //创建压缩包
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(names.get(0) + "等多个文件.zip", "UTF-8"));
            response.setHeader("content-type", "application/octet-stream");
            OutputStream os = response.getOutputStream();
            ZipOutputStream zos = new ZipOutputStream(os);
            InputStream is = null;
            int len = -1;
            byte[] b = new byte[1024 * 4];
            try {
                for (int i = 0; i < files.size(); i++) {
                    File file = files.get(i);
                    //向压缩包中添加数据
                    ZipEntry ze = new ZipEntry(names.get(i));
                    zos.putNextEntry(ze);
                    //写数据
                    is = new FileInputStream(file);
                    while (-1 != (len = is.read(b, 0, b.length))) {
                        zos.write(b, 0, len);
                        zos.flush();
                    }
                    zos.closeEntry();
                    is.close();
                }

            }catch (Exception e){
                throw  e;

            } finally {
                try {
                    if(is!=null){
                        is.close();
                    }
                }catch (Exception e){

                }
                try {
                    if(zos!=null){
                        zos.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                try {
                    if(os!=null){
                        os.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
    }
}
