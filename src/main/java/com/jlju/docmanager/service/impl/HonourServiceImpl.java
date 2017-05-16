package com.jlju.docmanager.service.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.*;
import com.jlju.docmanager.dao.HonoursMapper;
import com.jlju.docmanager.dao.MagazineMapper;
import com.jlju.docmanager.dao.QueryCacheMapper;
import com.jlju.docmanager.dao.TeachersMapper;
import com.jlju.docmanager.dto.FileUpload;
import com.jlju.docmanager.service.HonourService;
import com.jlju.docmanager.service.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by zyz on 2016/11/21.
 */
@Service
public class HonourServiceImpl implements HonourService {
    @Autowired
    private HonoursMapper hMapper;
    @Autowired
    private QueryCacheMapper qMapper;
    @Autowired
    private TeachersMapper tMapper;

    @Value("#{configProperties['FileRoot']}")
    private String FILE_ROOT;

    @Transactional(readOnly = false)
    public int insert(Honours honours, String filesStr) {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, FileUpload.class);
        List<FileUpload> files = null;
        try {
            files = (List<FileUpload>) objectMapper.readValue(filesStr, javaType);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }

        //添加杂志
        String uuid = UUID.randomUUID().toString();
        honours.setHoUuid(uuid);
        int result = hMapper.insert(honours);
        Teachers teachers = null;
        //根据教师号查询教师信息
        TeachersExample example = new TeachersExample();
        example.createCriteria().andTeacherCodeEqualTo(honours.getFkTeacherCode());
        List<Teachers> teacherses = tMapper.selectByExample(example);
        teachers = teacherses.get(0);

        //保存缓存信息
        QueryCache qc = new QueryCache();
        for (FileUpload fp : files) {
            qc.setTeacherName(teachers.getTeacherName());
            qc.setProjectName(honours.getHoName());
            qc.setFkTeacherCode(honours.getFkTeacherCode());
            qc.setFileName(fp.getFileName());
            qc.setFileDate(honours.getHoEndDate());
            qc.setFilePath(fp.getSavePath());
            qc.setOrders(honours.getHoTeacherOrder());
            qc.setFileType("成果转化");
            qc.setFkFileUuid(uuid);
            result += qMapper.insert(qc);
        }
        return result;
    }

    public PageInfo<Honours> selectHonoursWithTeachers(String hoName,String teacherName,Integer pageNum) {
        PageHelper.startPage(pageNum, 10);

        if(hoName!=null){
            hoName ="%"+hoName+"%";
        }
        if(teacherName!=null){
            teacherName ="%"+teacherName+"%";
        }
        List<Honours> honourses = hMapper.selectHonoursWithTeachers(hoName,teacherName);
        return new PageInfo<Honours>(honourses);
    }

    /**
     * 删除文档
     * @param uuid
     * @return
     */
    @Transactional(readOnly = false)
    public int delete(String uuid) {
        deleteFilesAndCache(uuid);
        //删除条目
        return hMapper.deleteByPrimaryKey(uuid);
    }

    public Honours selectById(String uuid) {
        return hMapper.selectByPrimaryKey(uuid);
    }

    /**
     * 更新期刊类文档：
     * 如果没有上传新文件，则只更新期刊类的基本信息。
     * 如果上传新文件，先将之前的文件删除，然后保存新文件信息
     * @param files
     * @return
     */
    @Transactional(readOnly = false)
    public int update(Honours honours, String files) {
        //判断新上传的文档是否为空。如果不为空，删除之前的旧文档重新上传
        int result =update(honours);

        if(files!=null&&!"".equals(files)){
            //删除旧文档
            deleteFilesAndCache(honours.getHoUuid());
            //上传新文档
            uploadNewFiles(files,honours);
        }

        return result;
    }

    private void uploadNewFiles(String filesStr, Honours honours) {

        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, FileUpload.class);
        List<FileUpload> files = null;
        try {
            files = (List<FileUpload>) objectMapper.readValue(filesStr, javaType);
        } catch (IOException e) {
            e.printStackTrace();
            return ;
        }
        TeachersExample example = new TeachersExample();
        example.createCriteria().andTeacherCodeEqualTo(honours.getFkTeacherCode());
        List<Teachers> teacherses = tMapper.selectByExample(example);
        Teachers teachers = teacherses.get(0);

        QueryCache qc = new QueryCache();
        for (FileUpload fp : files) {
            qc.setTeacherName(teachers.getTeacherName());
            qc.setProjectName(honours.getHoName());
            qc.setFkTeacherCode(honours.getFkTeacherCode());
            qc.setFileName(fp.getFileName());
            qc.setFileDate(honours.getHoEndDate());
            qc.setFilePath(fp.getSavePath());
            qc.setOrders(honours.getHoTeacherOrder());
            qc.setFileType("成果转化");
            qc.setFkFileUuid(honours.getHoUuid());
            qMapper.insert(qc);
        }

    }

    private int update(Honours honours) {
        return hMapper.updateByPrimaryKeySelective(honours);
    }

    private void deleteFilesAndCache(String uuid) {
        /**
         * 删除与之关联的文档
         * 删除缓存
         * 删除本条目
         */
        //删除文件
        QueryCacheExample example = new QueryCacheExample();
        example.createCriteria().andFkFileUuidEqualTo(uuid);
        List<QueryCache> queryCaches = qMapper.selectByExample(example);
        if(queryCaches!=null&&queryCaches.size()>0) {
            for (QueryCache cache : queryCaches) {
                File file = new File(FILE_ROOT+cache.getFilePath());
                if(file.exists()&&file.length()>0){
                    file.delete();
                }
            }
        }
        qMapper.deleteByExample(example);
    }
}
