package com.schoolpal.db.inf;

import com.schoolpal.db.model.TCourseType;
import com.schoolpal.db.model.TCourseTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCourseTypeMapper {
    long countByExample(TCourseTypeExample example);

    int deleteByExample(TCourseTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCourseType record);

    int insertSelective(TCourseType record);

    List<TCourseType> selectByExample(TCourseTypeExample example);

    TCourseType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCourseType record, @Param("example") TCourseTypeExample example);

    int updateByExample(@Param("record") TCourseType record, @Param("example") TCourseTypeExample example);

    int updateByPrimaryKeySelective(TCourseType record);

    int updateByPrimaryKey(TCourseType record);
}