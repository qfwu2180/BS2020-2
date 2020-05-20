package com.dao;

import com.pojo.Banji;
import com.pojo.BanjiQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BanjiDao {
    int countByExample(BanjiQuery example);

    int deleteByExample(BanjiQuery example);

    int deleteByPrimaryKey(Integer bid);

    int insert(Banji record);

    int insertSelective(Banji record);

    List<Banji> selectByExample(BanjiQuery example);

    Banji selectByPrimaryKey(Integer bid);

    int updateByExampleSelective(@Param("record") Banji record, @Param("example") BanjiQuery example);

    int updateByExample(@Param("record") Banji record, @Param("example") BanjiQuery example);

    int updateByPrimaryKeySelective(Banji record);

    int updateByPrimaryKey(Banji record);
}