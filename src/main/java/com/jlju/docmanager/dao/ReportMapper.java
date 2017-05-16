package com.jlju.docmanager.dao;

import com.jlju.docmanager.bean.Report;
import com.jlju.docmanager.bean.ReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReportMapper {
    int countByExample(ReportExample example);

    int deleteByExample(ReportExample example);

    int deleteByPrimaryKey(String repUuid);

    int insert(Report record);

    int insertSelective(Report record);

    List<Report> selectByExample(ReportExample example);

    Report selectByPrimaryKey(String repUuid);

    int updateByExampleSelective(@Param("record") Report record, @Param("example") ReportExample example);

    int updateByExample(@Param("record") Report record, @Param("example") ReportExample example);

    int updateByPrimaryKeySelective(Report record);

    int updateByPrimaryKey(Report record);




    List<Report> selectReportWithTeachers(@Param("repName") String repName, @Param("teacherName") String teacherName);
}