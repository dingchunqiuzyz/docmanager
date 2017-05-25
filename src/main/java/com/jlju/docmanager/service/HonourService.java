package com.jlju.docmanager.service;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Honours;

/**
 * Created by zyz on 2016/11/21.
 */

public interface HonourService {


     int insert(Honours honours, String files);

     PageInfo<Honours> selectHonoursWithTeachers(String hoName, String teacherName, Integer pageNum, Long teacherCode);

     int delete(String uuid);

     Honours selectById(String uuid);

     int update(Honours honours,String files);
}
