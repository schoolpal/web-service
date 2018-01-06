package com.schoolpal.db.inf;

import com.schoolpal.db.model.TContactApproach;

import java.util.List;

public interface TContactApproachMapper {
    int deleteOneById(Integer id);

    int insertOne(TContactApproach record);

    TContactApproach selectOneById(Integer id);
    List<TContactApproach> selectAll();

    int updateOne(TContactApproach record);
}