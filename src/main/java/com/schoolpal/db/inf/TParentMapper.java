package com.schoolpal.db.inf;

import java.util.List;

import com.schoolpal.db.model.TParent;

public interface TParentMapper {
    int deleteOneById(String id);

    int insertOne(TParent record);

    TParent selectOneById(String id);
    List<TParent> selectManyByExecutiveId(String id);
    List<TParent> selectManyByCellphone(String cellphone);

    int updateOne(TParent record);

}