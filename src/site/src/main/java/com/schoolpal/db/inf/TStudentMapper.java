package com.schoolpal.db.inf;

import com.schoolpal.db.model.TStudent;
import com.schoolpal.db.model.TStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TStudentMapper {
    long countByExample(TStudentExample example);

    int deleteByExample(TStudentExample example);

    int deleteByPrimaryKey(String id);

    int insert(TStudent record);

    int insertSelective(TStudent record);

    List<TStudent> selectByExample(TStudentExample example);

    TStudent selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TStudent record, @Param("example") TStudentExample example);

    int updateByExample(@Param("record") TStudent record, @Param("example") TStudentExample example);

    int updateByPrimaryKeySelective(TStudent record);

    int updateByPrimaryKey(TStudent record);
}