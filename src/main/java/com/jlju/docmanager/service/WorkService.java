package com.jlju.docmanager.service;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Works;

/**
 * Created by zyz on 2016/11/21.
 */

public interface WorkService {


     int insert(Works projects, String files);
     PageInfo<Works> selectWroksWithTeachers(String workName, String teacherName, Integer pageNum, Long teacherCode);

     int delete(String uuid);

     Works selectById(String uuid);

     int update(Works works,String files);
}
