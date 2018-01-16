package com.schoolpal.db.inf;

import com.schoolpal.db.model.TCourseProduct;

public interface TCourseProductMapper {
    int deleteByPrimaryKey(String id);

    int insert(TCourseProduct record);

    int insertSelective(TCourseProduct record);

    TCourseProduct selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TCourseProduct record);

    int updateByPrimaryKey(TCourseProduct record);
}