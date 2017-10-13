package com.schoolpal.db.inf;

import java.util.List;

import com.schoolpal.db.model.TContract;

public interface TContractMapper {
    int deleteOneById(String id);

    int insertOne(TContract record);

    TContract selectOneById(String id);
    List<TContract> selectManyByExecutiveId(String id);

    int updateOne(TContract record);
}