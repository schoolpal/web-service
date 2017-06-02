package com.schoolpal.db.inf;

import com.schoolpal.db.model.TStudent;

public interface TStudentMapper {
    int deleteByPrimaryKey(String id);

    int insert(TStudent record);

    int insertSelective(TStudent record);

    TStudent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TStudent record);

    int updateByPrimaryKey(TStudent record);
}