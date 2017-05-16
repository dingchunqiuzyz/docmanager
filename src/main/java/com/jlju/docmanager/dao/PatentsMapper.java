package com.jlju.docmanager.dao;

import com.jlju.docmanager.bean.Patents;
import com.jlju.docmanager.bean.PatentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PatentsMapper {
    int countByExample(PatentsExample example);

    int deleteByExample(PatentsExample example);

    int deleteByPrimaryKey(String patUuid);

    int insert(Patents record);

    int insertSelective(Patents record);

    List<Patents> selectByExample(PatentsExample example);

    Patents selectByPrimaryKey(String patUuid);

    int updateByExampleSelective(@Param("record") Patents record, @Param("example") PatentsExample example);

    int updateByExample(@Param("record") Patents record, @Param("example") PatentsExample example);

    int updateByPrimaryKeySelective(Patents record);

    int updateByPrimaryKey(Patents record);

    List<Patents> selectPatentsWithTeachers(@Param("patentName")String patentName,@Param("teacherName")String teacherName);
}