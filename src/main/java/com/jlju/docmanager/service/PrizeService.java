package com.jlju.docmanager.service;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Prizes;

/**
 * Created by zyz on 2016/11/21.
 */

public interface PrizeService {


     int insert(Prizes prizes, String files);

     PageInfo<Prizes> selectPrizisWithTeachers(Integer pageNum,String priName,String teacherName);

     int delete(String uuid);

     Prizes selectById(String uuid);

     int update(Prizes prizes,String files);
}
