package com.schoolpal.db.inf;

import com.schoolpal.db.model.TParent;

public interface TParentMapper {
    int deleteByPrimaryKey(String id);

    int insert(TParent record);

    int insertSelective(TParent record);

    TParent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TParent record);

    int updateByPrimaryKey(TParent record);
}