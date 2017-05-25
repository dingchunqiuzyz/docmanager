package com.jlju.docmanager.dao;

import com.jlju.docmanager.bean.Projects;
import com.jlju.docmanager.bean.ProjectsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectsMapper {
    int countByExample(ProjectsExample example);

    int deleteByExample(ProjectsExample example);

    int deleteByPrimaryKey(String proUuid);

    int insert(Projects record);

    int insertSelective(Projects record);

    List<Projects> selectByExample(ProjectsExample example);

    Projects selectByPrimaryKey(String proUuid);

    int updateByExampleSelective(@Param("record") Projects record, @Param("example") ProjectsExample example);

    int updateByExample(@Param("record") Projects record, @Param("example") ProjectsExample example);

    int updateByPrimaryKeySelective(Projects record);

    int updateByPrimaryKey(Projects record);

    List<Projects> selectWithTeachers(@Param("projectName") String projectName, @Param("teacherName") String teacherName, @Param("teacherCode") Long teacherCode);


}