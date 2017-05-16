package com.jlju.docmanager.service;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Projects;


/**
 * Created by zyz on 2016/11/21.
 */

public interface ProjectService {


     int insert(Projects projects, String files);

     PageInfo<Projects> projectsWithTeachers(Integer pageNum,String proName,String teacherName);

     int delete(String uuid);

     Projects selectById(String uuid);

     int update(Projects projects,String files);
}
