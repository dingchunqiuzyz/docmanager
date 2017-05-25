package com.jlju.docmanager.service.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.*;
import com.jlju.docmanager.dao.ProjectsMapper;
import com.jlju.docmanager.dao.QueryCacheMapper;
import com.jlju.docmanager.dao.TeachersMapper;
import com.jlju.docmanager.dto.FileUpload;
import com.jlju.docmanager.service.ProjectService;
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
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectsMapper pMapper;
    @Autowired
    private QueryCacheMapper qMapper;
    @Autowired
    private TeachersMapper tMapper;
    @Value("#{configProperties['FileRoot']}")
    private String FILE_ROOT;

    @Transactional(readOnly = false)
    public int insert(Projects p, String filesStr) {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, FileUpload.class);
        List<FileUpload> files = null;
        try {
            files = (List<FileUpload>) objectMapper.readValue(filesStr, javaType);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }

        //添加项目
        String uuid = UUID.randomUUID().toString();
        p.setProUuid(uuid);
        int result = pMapper.insert(p);
        Teachers teachers = null;
        //根据教师号查询教师信息
        TeachersExample example = new TeachersExample();
        example.createCriteria().andTeacherCodeEqualTo(p.getFkTeacherCode());
        List<Teachers> teacherses = tMapper.selectByExample(example);
        teachers = teacherses.get(0);

        //保存缓存信息
        QueryCache qc = new QueryCache();
        for (FileUpload fp : files) {
            qc.setTeacherName(teachers.getTeacherName());
            qc.setProjectName(p.getProName());
            qc.setFkTeacherCode(p.getFkTeacherCode());
            qc.setFileName(fp.getFileName());
            qc.setFileDate(p.getProEndDate());
            qc.setFilePath(fp.getSavePath());
            qc.setOrders(p.getProTeacherOrder());
            qc.setFileType("项目");
            qc.setFkFileUuid(uuid);
            result += qMapper.insert(qc);
        }
        return result;
    }



    public PageInfo<Projects> projectsWithTeachers(Integer pageNum, String proName, String teacherName, Long teacherCode) {
        PageHelper.startPage(pageNum, 10);

        if(proName!=null){
            proName ="%"+proName+"%";
        }
        if(teacherName!=null){
            teacherName ="%"+teacherName+"%";
        }
        List<Projects> projectses = pMapper.selectWithTeachers(proName,teacherName,teacherCode);
        return new PageInfo<Projects>(projectses);
    }
    @Transactional(readOnly = false)
    public int delete(String uuid) {
        deleteFilesAndCache(uuid);
        //删除条目
        return pMapper.deleteByPrimaryKey(uuid);
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
        //删除缓存
        qMapper.deleteByExample(example);
    }
    public Projects selectById(String uuid) {
        return pMapper.selectByPrimaryKey(uuid);
    }

    private int update(Projects projects) {

        return pMapper.updateByPrimaryKeySelective(projects);
    }
    @Transactional(readOnly = false)
    public int update(Projects projects, String files) {
        int result =update(projects);

        if(files!=null&&!"".equals(files)){
            //删除旧文档
            deleteFilesAndCache(projects.getProUuid());
            //上传新文档
            uploadNewFiles(files,projects);
        }

        return result;
    }

    private void uploadNewFiles(String filesStr, Projects p) {

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
        example.createCriteria().andTeacherCodeEqualTo(p.getFkTeacherCode());
        List<Teachers> teacherses = tMapper.selectByExample(example);
        Teachers teachers = teacherses.get(0);

        QueryCache qc = new QueryCache();
        for (FileUpload fp : files) {
            qc.setTeacherName(teachers.getTeacherName());
            qc.setProjectName(p.getProName());
            qc.setFkTeacherCode(p.getFkTeacherCode());
            qc.setFileName(fp.getFileName());
            qc.setFileDate(p.getProEndDate());
            qc.setFilePath(fp.getSavePath());
            qc.setOrders(p.getProTeacherOrder());
            qc.setFileType("项目");
            qc.setFkFileUuid(p.getProUuid());
            qMapper.insert(qc);
        }

    }
}
