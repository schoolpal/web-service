package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeads;

public interface TLeadsMapper {
    int deleteByPrimaryKey(String id);

    int insertOne(TLeads record);

    TLeads selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TLeads record);

    int updateByPrimaryKey(TLeads record);
}