package com.jlju.docmanager.dao;

import com.jlju.docmanager.bean.Prizes;
import com.jlju.docmanager.bean.PrizesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrizesMapper {
    int countByExample(PrizesExample example);

    int deleteByExample(PrizesExample example);

    int deleteByPrimaryKey(String priUuid);

    int insert(Prizes record);

    int insertSelective(Prizes record);

    List<Prizes> selectByExample(PrizesExample example);

    Prizes selectByPrimaryKey(String priUuid);

    int updateByExampleSelective(@Param("record") Prizes record, @Param("example") PrizesExample example);

    int updateByExample(@Param("record") Prizes record, @Param("example") PrizesExample example);

    int updateByPrimaryKeySelective(Prizes record);

    int updateByPrimaryKey(Prizes record);


    List<Prizes> selectPrizesWithTeachers(@Param("priName")String priName,@Param("teacherName")String teacherName);
}