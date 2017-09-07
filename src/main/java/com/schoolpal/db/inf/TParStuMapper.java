package com.schoolpal.db.inf;

import com.schoolpal.db.model.TParStu;
import com.schoolpal.db.model.TParStuKey;

public interface TParStuMapper {
    int deleteOneByPrimaryKey(TParStuKey key);
    int deleteManyByParId(String id);
    int deleteManyByStuId(String id);

    int insertOne(TParStu record);

//    TParStu selectByPrimaryKey(TParStuKey key);

//    int updateByPrimaryKey(TParStu record);
}