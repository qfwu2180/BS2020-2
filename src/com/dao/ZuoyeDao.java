package com.dao;

import com.pojo.Zuoye;
import com.pojo.ZuoyeQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZuoyeDao {
    int countByExample(ZuoyeQuery example);

    int deleteByExample(ZuoyeQuery example);

    int deleteByPrimaryKey(Integer zyid);

    int insert(Zuoye record);

    int insertSelective(Zuoye record);

    List<Zuoye> selectByExample(ZuoyeQuery example);

    Zuoye selectByPrimaryKey(Integer zyid);

    int updateByExampleSelective(@Param("record") Zuoye record, @Param("example") ZuoyeQuery example);

    int updateByExample(@Param("record") Zuoye record, @Param("example") ZuoyeQuery example);

    int updateByPrimaryKeySelective(Zuoye record);

    int updateByPrimaryKey(Zuoye record);
}