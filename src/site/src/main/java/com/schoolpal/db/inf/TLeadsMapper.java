package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeads;

public interface TLeadsMapper {

    int insertOne(TLeads record);
    int updateOne(TLeads record);
    int deleteOneById(String id);

    TLeads selectByPrimaryKey(String id);

}