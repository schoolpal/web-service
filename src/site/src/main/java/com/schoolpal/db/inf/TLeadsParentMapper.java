package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeadsParent;

public interface TLeadsParentMapper {
    int deleteByPrimaryKey(String leadsId);

    int insertOne(TLeadsParent record);

    TLeadsParent selectByPrimaryKey(String leadsId);

    int updateByPrimaryKeySelective(TLeadsParent record);

    int updateByPrimaryKey(TLeadsParent record);
}