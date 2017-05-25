package com.jlju.docmanager.service.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.*;
import com.jlju.docmanager.dao.QueryCacheMapper;
import com.jlju.docmanager.dao.ReportMapper;
import com.jlju.docmanager.dao.TeachersMapper;
import com.jlju.docmanager.dto.FileUpload;
import com.jlju.docmanager.service.ReportService;
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
 * Created by zyz on 2017/1/11.
 */
@Service
public class ReportServiceImpl implements ReportService{
    @Autowired
    private ReportMapper mapper;

    @Autowired
    private QueryCacheMapper qMapper;
    @Autowired
    private TeachersMapper tMapper;
    @Value("#{configProperties['FileRoot']}")
    private String FILE_ROOT;
    @Transactional(readOnly = false)
    public int insert(Report report, String filesStr) {
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
        report.setRepUuid(uuid);
        int result = mapper.insert(report);
        Teachers teachers = null;
        //根据教师号查询教师信息
        TeachersExample example = new TeachersExample();
        example.createCriteria().andTeacherCodeEqualTo(report.getFkTeacherCode());
        List<Teachers> teacherses = tMapper.selectByExample(example);
        teachers = teacherses.get(0);

        //保存缓存信息
        QueryCache qc = new QueryCache();
        for (FileUpload fp : files) {
            qc.setTeacherName(teachers.getTeacherName());
            qc.setProjectName(report.getRepName());
            qc.setFkTeacherCode(report.getFkTeacherCode());
            qc.setFileName(fp.getFileName());
            qc.setFileDate(report.getRepDate());
            qc.setFilePath(fp.getSavePath());
            qc.setOrders(report.getRepTeacherOrder());
            qc.setFileType("论证报告");
            qc.setFkFileUuid(uuid);
            result += qMapper.insert(qc);
        }
        return result;
    }



    public PageInfo<Report> selectReportWithTeachers(Integer pageNum, String repName, String teacherName, Long teacherCode) {
        PageHelper.startPage(pageNum, 10);

        if(repName!=null){
            repName ="%"+repName+"%";
        }
        if(teacherName!=null){
            teacherName ="%"+teacherName+"%";
        }
        List<Report> projectses = mapper.selectReportWithTeachers(repName,teacherName,teacherCode);
        return new PageInfo<Report>(projectses);
    }
    @Transactional(readOnly = false)
    public int delete(String uuid) {
        deleteFilesAndCache(uuid);
        return mapper.deleteByPrimaryKey(uuid);
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
    public Report selectById(String uuid) {
        return mapper.selectByPrimaryKey(uuid);
    }
    @Transactional(readOnly = false)
    public int update(Report report, String files) {
        int result =update(report);

        if(files!=null&&!"".equals(files)){
            //删除旧文档
            deleteFilesAndCache(report.getRepUuid());
            //上传新文档
            uploadNewFiles(files,report);
        }

        return result;
    }

    private int update(Report report) {

        return mapper.updateByPrimaryKeySelective(report);
    }

    private void uploadNewFiles(String filesStr, Report p) {

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
            qc.setProjectName(p.getRepName());
            qc.setFkTeacherCode(p.getFkTeacherCode());
            qc.setFileName(fp.getFileName());
            qc.setFileDate(p.getRepDate());
            qc.setFilePath(fp.getSavePath());
            qc.setOrders(p.getRepTeacherOrder());
            qc.setFileType("论证报告");
            qc.setFkFileUuid(p.getRepUuid());
            qMapper.insert(qc);
        }

    }
}
