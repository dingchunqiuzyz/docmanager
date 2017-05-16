package com.jlju.docmanager.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Teachers;
import com.jlju.docmanager.bean.TeachersExample;
import com.jlju.docmanager.dao.TeachersMapper;
import com.jlju.docmanager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zyz on 2016/11/9.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeachersMapper mapper;

    @Transactional(readOnly = false)
    public int updateTeachers(Teachers teachers) {
        return mapper.updateByPrimaryKey(teachers);
    }
    @Transactional(readOnly = false)
    public int insertTeachers(Teachers teachers) {
        return mapper.insert(teachers);
    }
    @Transactional(readOnly = false)
    public int deleteById(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public PageInfo<Teachers> queryPage(int pageNum, Teachers teachers) {
//        每页显示10条
        PageHelper.startPage(pageNum,10);
        //创建查询条件
        TeachersExample example = new TeachersExample();
        TeachersExample.Criteria criteria = example.createCriteria();
        if(teachers.getTeacherName()!=null&&!"".equals(teachers.getTeacherName())){
            criteria.andTeacherNameLike("%" + teachers.getTeacherName() + "%");
        }

        if(teachers.getTeacherCode()!=null&&teachers.getTeacherCode()>0){
            criteria.andTeacherCodeEqualTo(teachers.getTeacherCode());
        }
        List<Teachers> teacherses = mapper.selectByExample(example);
        PageInfo<Teachers> info = new PageInfo<Teachers>(teacherses);
        return info;
    }

    public Teachers selectById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public List<Teachers> selectTeacherByName(String teacherName) {
        TeachersExample example = new TeachersExample();
        TeachersExample.Criteria criteria = example.createCriteria();
        if(teacherName!=null&&!"".equals(teacherName)){
            criteria.andTeacherNameLike("%" + teacherName + "%");
        }
        return mapper.selectByExample(example);
    }

    public String selectTeacherByNameAsJson(String teacherName)  {
        List<Teachers> teacherses = null;
        Map<Long,String> map =null;
        if(teacherName!=null&&!"".equals(teacherName)){
            teacherses= this.selectTeacherByName(teacherName);
        }
        if(teacherses!=null&&teacherses.size()>0){
            map = new HashMap<Long, String>();
            for(Teachers t:teacherses){
                map.put(t.getTeacherCode(),"学院："+t.getCollege()+" 专业:"+t.getMajor());
            }
        }
        if (map!=null){
            ObjectMapper mapper = new ObjectMapper();
            try {
             return   mapper.writeValueAsString(map);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
