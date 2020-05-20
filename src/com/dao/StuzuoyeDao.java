package com.dao;

import com.pojo.Stuzuoye;
import com.pojo.StuzuoyeQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StuzuoyeDao {
    int countByExample(StuzuoyeQuery example);

    int deleteByExample(StuzuoyeQuery example);

    int deleteByPrimaryKey(Integer stuzyid);

    int insert(Stuzuoye record);

    int insertSelective(Stuzuoye record);

    List<Stuzuoye> selectByExample(StuzuoyeQuery example);

    Stuzuoye selectByPrimaryKey(Integer stuzyid);

    int updateByExampleSelective(@Param("record") Stuzuoye record, @Param("example") StuzuoyeQuery example);

    int updateByExample(@Param("record") Stuzuoye record, @Param("example") StuzuoyeQuery example);

    int updateByPrimaryKeySelective(Stuzuoye record);

    int updateByPrimaryKey(Stuzuoye record);
}