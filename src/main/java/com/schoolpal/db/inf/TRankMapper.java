package com.schoolpal.db.inf;

import com.schoolpal.db.model.TRank;

import java.util.List;

public interface TRankMapper {
    int deleteOneById(Integer cId);

    int insertOne(TRank record);

    TRank selectOneById(Integer cId);
    List<TRank> selectAll();

    int updateById(TRank record);
}