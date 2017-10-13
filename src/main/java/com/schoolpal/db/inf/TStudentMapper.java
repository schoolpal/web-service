package com.schoolpal.db.inf;

import java.util.List;

import com.schoolpal.db.model.TStudent;

public interface TStudentMapper {
    int deleteOneById(String id);
    int deleteOneByCode(String code);

    int insertOne(TStudent record);

    TStudent selectOneById(String id);
    TStudent selectOneByCode(String code);
    List<TStudent> selectManyByExectiveId(String id);

    int updateOne(TStudent record);

}