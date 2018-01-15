package com.schoolpal.db.inf;

import com.schoolpal.db.model.TContract;

import java.util.List;

public interface TContractMapper {
    int deleteOneById(String id);

    int insertOne(TContract record);

    TContract selectOneById(String id);

    default List<TContract> selectManyByExecutiveId(String id) {
        return null;
    }

    int updateOne(TContract record);
}