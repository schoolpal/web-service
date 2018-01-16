package com.schoolpal.db.inf;

import com.schoolpal.db.model.TCourseType;

import java.util.List;

public interface TCourseTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCourseType record);

    int insertSelective(TCourseType record);

    TCourseType selectOneById(Integer id);
    List<TCourseType> selectAll();

    int updateByPrimaryKeySelective(TCourseType record);

    int updateByPrimaryKey(TCourseType record);
}