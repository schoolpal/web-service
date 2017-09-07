package com.schoolpal.db.inf;

import java.util.List;

import com.schoolpal.db.model.TContactApproach;

public interface TContactApproachMapper {
    int deleteOneById(Integer id);

    int insertOne(TContactApproach record);

    TContactApproach selectOneById(Integer id);
    List<TContactApproach> selectAll();

    int updateOne(TContactApproach record);
}