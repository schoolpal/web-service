package com.schoolpal.db.inf;

import com.schoolpal.db.model.TCoursePrototype;
import com.schoolpal.db.model.TCoursePrototypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCoursePrototypeMapper {
    long countByExample(TCoursePrototypeExample example);

    int deleteByExample(TCoursePrototypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCoursePrototype record);

    int insertSelective(TCoursePrototype record);

    List<TCoursePrototype> selectByExample(TCoursePrototypeExample example);

    TCoursePrototype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCoursePrototype record, @Param("example") TCoursePrototypeExample example);

    int updateByExample(@Param("record") TCoursePrototype record, @Param("example") TCoursePrototypeExample example);

    int updateByPrimaryKeySelective(TCoursePrototype record);

    int updateByPrimaryKey(TCoursePrototype record);
}