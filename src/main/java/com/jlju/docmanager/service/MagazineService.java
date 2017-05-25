package com.jlju.docmanager.service;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Magazine;


/**
 * Created by zyz on 2016/11/21.
 */

public interface MagazineService {


     int insert(Magazine magazine,String files);

     PageInfo<Magazine> queryMagazine(String magName, String teacherName, Long teacherCode, Integer pageNum);

     int delete(String uuid);

     Magazine selectById(String uuid);

     int update(Magazine magazine,String files);
}
