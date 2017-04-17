package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeadsStatus;

public interface TLeadsStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TLeadsStatus record);

    int insertSelective(TLeadsStatus record);

    TLeadsStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TLeadsStatus record);

    int updateByPrimaryKey(TLeadsStatus record);
}