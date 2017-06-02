package com.schoolpal.db.inf;

import com.schoolpal.db.model.TContract;

public interface TContractMapper {
    int deleteByPrimaryKey(String id);

    int insert(TContract record);

    int insertSelective(TContract record);

    TContract selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TContract record);

    int updateByPrimaryKey(TContract record);
}