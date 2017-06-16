package com.jlju.docmanager.controller;

import com.jlju.docmanager.bean.QueryCache;
import com.jlju.docmanager.dto.WebResult;
import com.jlju.docmanager.service.QueryCacheService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
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
public class DownloadController extends BaseController{
    @Autowired
    private QueryCacheService service;
    @Value("#{configProperties['FileRoot']}")
    private String FILE_ROOT;

    @RequestMapping("/{cacheId}/one")
    public void one(@PathVariable("cacheId") Integer cacheId) throws IOException {
        QueryCache cache = service.selectById(cacheId);
        String path = cache.getFilePath();
        String realPath = FILE_ROOT + path;

        try {
            InputStream in = new FileInputStream(new File(realPath));
            OutputStream os = response.getOutputStream();
            downloadFile(in, cache.getFileName());
        } catch (Exception e) {
            //下载失败
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<script type='text/javascript'>alert('对不起你要下载的内容不存在');window.history.back();</script>");
        }

    }

    @RequestMapping("/many")
    public void many(@RequestParam("ids") ArrayList<Integer> ids) throws IOException {
        try {
            List<QueryCache> caches = service.listByIds(ids);
            List<File> files = new ArrayList<File>();
            List<String> names = new ArrayList<String>();
            if (caches != null && caches.size() > 0) {
                for (int i = 0; i < caches.size(); i++) {
                    QueryCache c = caches.get(i);
                    File file = new File(FILE_ROOT + c.getFilePath());
                    if (!file.exists())
                        throw new Exception(c.getFileName());
                    files.add(file);
                    names.add(renameFile((i + 1) ,c.getFileName()));
                }
            }
            if (files.size() > 0) {
                downZip( files, names);
            }
        } catch (Exception e) {
            //下载失败
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<script type='text/javascript'>alert('对不起你要下载" + e.getMessage() + "的内容不存在');window.history.back();</script>");
        }

    }

    private String renameFile(int i, String fileName) {
        StringBuilder sb = new StringBuilder();
        int pos=fileName.lastIndexOf(".");
       return sb.append(fileName.substring(0,pos)).append("(").append(i).append(").").append(fileName.substring(pos+1)).toString();
    }

    /**
     * 下载教师倒入excel模板
     */
    @RequestMapping("/teacherTemplate")
    public void downloadTemplate() {

        //获取服务器真实路径

        String templatePath = request.getSession().getServletContext().getRealPath("/resource/teacher_template.xlsx");
        File file = new File(templatePath);
        InputStream inputStream = null;
        try {
            if (!file.exists()) {//文件不存在，跳转到信息提示页面
                WebResult<String> webResult = new WebResult<String>(false,"操作失败！您要下载的界面不存在,只能手工添加了",request.getContextPath()+"/teachers/list");
                request.setAttribute("result",webResult);
                request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request,response);
            } else {//文件下载
                inputStream = new FileInputStream(file);
                downloadFile(inputStream,"教师信息导入模板.xlsx");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    private void downloadFile(InputStream in, String fileName) throws IOException {
        ServletOutputStream os = null;
        try {
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("content-type", "application/octet-stream");
            os = response.getOutputStream();
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

    private void downZip( List<File> files, List<String> names) throws Exception {
        //创建压缩包
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("批量下载_"+names.get(0) + "等多个文件.zip", "UTF-8"));
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

        } catch (Exception e) {
            throw e;

        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception e) {

            }
            try {
                if (zos != null) {
                    zos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
