package com.schoolpal.db.inf;

import java.util.List;

import com.schoolpal.db.model.TRank;

public interface TRankMapper {
    int deleteOneById(Integer cId);

    int insertOne(TRank record);

    TRank selectOneById(Integer cId);
    List<TRank> selectAll();

    int updateById(TRank record);
}