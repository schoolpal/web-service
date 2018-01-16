package com.schoolpal.db.inf;

import com.schoolpal.db.model.TParent;

import java.util.List;

public interface TParentMapper {
    int deleteOneById(String id);

    int insertOne(TParent record);

    TParent selectOneById(String id);
    List<TParent> selectManyByExecutiveId(String id);
    List<TParent> selectManyByCellphone(String cellphone);
    List<TParent> selectManyByStudentId(String id);

    int updateOne(TParent record);

}