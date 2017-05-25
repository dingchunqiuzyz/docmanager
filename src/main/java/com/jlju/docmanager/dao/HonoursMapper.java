package com.jlju.docmanager.dao;

import com.jlju.docmanager.bean.Honours;
import com.jlju.docmanager.bean.HonoursExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HonoursMapper {
    int countByExample(HonoursExample example);

    int deleteByExample(HonoursExample example);

    int deleteByPrimaryKey(String hoUuid);

    int insert(Honours record);

    int insertSelective(Honours record);

    List<Honours> selectByExample(HonoursExample example);

    Honours selectByPrimaryKey(String hoUuid);

    int updateByExampleSelective(@Param("record") Honours record, @Param("example") HonoursExample example);

    int updateByExample(@Param("record") Honours record, @Param("example") HonoursExample example);

    int updateByPrimaryKeySelective(Honours record);

    int updateByPrimaryKey(Honours record);

    List<Honours> selectHonoursWithTeachers(@Param("honName") String honName, @Param("teacherName") String teacherName, @Param("teacherCode")Long teacherCode);
}