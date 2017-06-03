package com.schoolpal.db.inf;

import com.schoolpal.db.model.TParStu;
import com.schoolpal.db.model.TParStuKey;

public interface TParStuMapper {
    int deleteByPrimaryKey(TParStuKey key);

    int insertOne(TParStu record);

//    TParStu selectByPrimaryKey(TParStuKey key);

//    int updateByPrimaryKey(TParStu record);
}