package com.jlju.docmanager.dao;

import com.jlju.docmanager.bean.Magazine;
import com.jlju.docmanager.bean.MagazineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MagazineMapper {
    int countByExample(MagazineExample example);

    int deleteByExample(MagazineExample example);

    int deleteByPrimaryKey(String magUuid);

    int insert(Magazine record);

    int insertSelective(Magazine record);

    List<Magazine> selectByExample(MagazineExample example);

    Magazine selectByPrimaryKey(String magUuid);

    int updateByExampleSelective(@Param("record") Magazine record, @Param("example") MagazineExample example);

    int updateByExample(@Param("record") Magazine record, @Param("example") MagazineExample example);

    int updateByPrimaryKeySelective(Magazine record);

    int updateByPrimaryKey(Magazine record);

    List<Magazine> selectMagazineWithTheacher(@Param("magName")String magName,@Param("teacherName")String teacherName);

}