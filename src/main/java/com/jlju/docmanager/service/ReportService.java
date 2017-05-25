package com.jlju.docmanager.service;

import com.github.pagehelper.PageInfo;
import com.jlju.docmanager.bean.Report;

/**
 * Created by zyz on 2016/11/21.
 */

public interface ReportService {


     int insert(Report report, String files);

     PageInfo<Report> selectReportWithTeachers(Integer pageNum, String repName, String teacherName, Long teacherCode);

     int delete(String uuid);

     Report selectById(String uuid);

     int update(Report report, String files);
}
