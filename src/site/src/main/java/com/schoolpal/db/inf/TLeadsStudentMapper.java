package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeadsStudent;
import com.schoolpal.db.model.TLeadsStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLeadsStudentMapper {
    long countByExample(TLeadsStudentExample example);

    int deleteByExample(TLeadsStudentExample example);

    int deleteByPrimaryKey(String leadsId);

    int insert(TLeadsStudent record);

    int insertSelective(TLeadsStudent record);

    List<TLeadsStudent> selectByExample(TLeadsStudentExample example);

    TLeadsStudent selectByPrimaryKey(String leadsId);

    int updateByExampleSelective(@Param("record") TLeadsStudent record, @Param("example") TLeadsStudentExample example);

    int updateByExample(@Param("record") TLeadsStudent record, @Param("example") TLeadsStudentExample example);

    int updateByPrimaryKeySelective(TLeadsStudent record);

    int updateByPrimaryKey(TLeadsStudent record);
}