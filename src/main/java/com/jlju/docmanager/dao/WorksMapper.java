package com.jlju.docmanager.dao;

import com.jlju.docmanager.bean.Works;
import com.jlju.docmanager.bean.WorksExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorksMapper {
    int countByExample(WorksExample example);

    int deleteByExample(WorksExample example);

    int deleteByPrimaryKey(String workUuid);

    int insert(Works record);

    int insertSelective(Works record);

    List<Works> selectByExample(WorksExample example);

    Works selectByPrimaryKey(String workUuid);

    int updateByExampleSelective(@Param("record") Works record, @Param("example") WorksExample example);

    int updateByExample(@Param("record") Works record, @Param("example") WorksExample example);

    int updateByPrimaryKeySelective(Works record);

    int updateByPrimaryKey(Works record);


    List<Works> selectWorksWithTeachers(@Param("workName")String workName,@Param("teacherName")String teacherName);
}