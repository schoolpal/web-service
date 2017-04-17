package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeadsStudent;

public interface TLeadsStudentMapper {
    int deleteByPrimaryKey(String leadsId);

    int insert(TLeadsStudent record);

    int insertSelective(TLeadsStudent record);

    TLeadsStudent selectByPrimaryKey(String leadsId);

    int updateByPrimaryKeySelective(TLeadsStudent record);

    int updateByPrimaryKey(TLeadsStudent record);
}