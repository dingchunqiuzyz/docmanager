package com.jlju.docmanager.service;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Teachers;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by zyz on 2016/11/9.
 */
public interface TeacherService
{
     /**
      * 修改系统教师信息
      * @param teachers 教师信息
      * @return
      */
     int updateTeachers(Teachers teachers);

     /**
      * 添加系统教师
      * @param teachers  系统教师
      */
     int insertTeachers(Teachers teachers);

     /**
      * 根据id删除系统教师
      * @param id
      * @return
      */
     int deleteById(int id);

     /**
      * 分页查询教师信息
      * @param pageNum 起始页码
      * @param teachers 封装了查询条件
      * @return
      */
     PageInfo<Teachers> queryPage(int pageNum, Teachers teachers);

     /**
      * 根据id查询
      * @param id
      * @return
      */
     Teachers selectById(Integer id);

     /**
      * 根据教师名称搜索教师信息
      * @param teacherName
      * @return
      */
     List<Teachers> selectTeacherByName(String teacherName);

     /**
      * 根据教师名，将教师信息转换成json key:教师号，value ：学院信息
      * @param teacherName
      * @return
      */
     String selectTeacherByNameAsJson(String teacherName);


     void batchInsert(MultipartFile file) throws Exception;

}
