package com.jlju.docmanager.dao;

import com.jlju.docmanager.bean.Teachers;
import com.jlju.docmanager.bean.TeachersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeachersMapper {
    int countByExample(TeachersExample example);

    int deleteByExample(TeachersExample example);

    int deleteByPrimaryKey(Integer teacherId);

    int insert(Teachers record);

    int insertSelective(Teachers record);

    List<Teachers> selectByExample(TeachersExample example);

    Teachers selectByPrimaryKey(Integer teacherId);

    int updateByExampleSelective(@Param("record") Teachers record, @Param("example") TeachersExample example);

    int updateByExample(@Param("record") Teachers record, @Param("example") TeachersExample example);

    int updateByPrimaryKeySelective(Teachers record);

    int updateByPrimaryKey(Teachers record);

    void batchInsert(List<Teachers> list);
}