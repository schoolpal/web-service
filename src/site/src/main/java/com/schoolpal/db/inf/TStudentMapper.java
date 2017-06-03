package com.schoolpal.db.inf;

import com.schoolpal.db.model.TStudent;

public interface TStudentMapper {
    int deleteOneById(String id);
    int deleteOneByCode(String code);

    int insertOne(TStudent record);

    TStudent selectOneById(String id);
    TStudent selectOneByCode(String code);

    int updateOne(TStudent record);

}