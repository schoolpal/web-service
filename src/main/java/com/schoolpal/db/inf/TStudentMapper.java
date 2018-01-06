package com.schoolpal.db.inf;

import com.schoolpal.db.model.TStudent;

import java.util.List;

public interface TStudentMapper {
    int deleteOneById(String id);
    int deleteOneByCode(String code);

    int insertOne(TStudent record);

    TStudent selectOneById(String id);
    TStudent selectOneByCode(String code);
    List<TStudent> selectManyByExectiveId(String id);

    int updateOne(TStudent record);

}