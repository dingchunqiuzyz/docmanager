package com.jlju.docmanager.service;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Patents;
import com.jlju.docmanager.bean.Projects;

/**
 * Created by zyz on 2016/11/21.
 */

public interface PatentService {


     int insert(Patents patents, String files);

     PageInfo<Patents> selectPatentsWithTeachers(String patName, String teacherName, Long teacherCode, Integer pageNum);

     int delete(String uuid);

     Patents selectById(String uuid);

     int update(Patents patents,String files);
}
