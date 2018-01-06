package com.schoolpal.db.inf;

import com.schoolpal.db.model.TContact;

import java.util.List;

public interface TContactMapper {
    int deleteOneById(String id);

    int insertOne(TContact record);

    TContact selectOneById(String id);
    List<TContact> selectManyByLeadsId(String leadsId);

    int updateOne(TContact record);

}