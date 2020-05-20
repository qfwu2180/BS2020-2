package com.dao;

import com.pojo.Student;
import com.pojo.StudentQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentDao {
    int countByExample(StudentQuery example);

    int deleteByExample(StudentQuery example);

    int deleteByPrimaryKey(Integer stid);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentQuery example);

    Student selectByPrimaryKey(Integer stid);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentQuery example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentQuery example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}