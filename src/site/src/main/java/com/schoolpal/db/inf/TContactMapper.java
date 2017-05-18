package com.schoolpal.db.inf;

import java.util.List;

import com.schoolpal.db.model.TContact;

public interface TContactMapper {
    int deleteOneById(String id);

    int insertOne(TContact record);

    TContact selectOneById(String id);
    List<TContact> selectManyByLeadsId(String leadsId);

    int updateOneById(TContact record);

}