package com.schoolpal.db.inf;

import java.util.List;

import com.schoolpal.db.model.TLeadsSource;

public interface TLeadsSourceMapper {
    List<TLeadsSource> selectAll();
    TLeadsSource selectOneById(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(TLeadsSource record);

    int insertSelective(TLeadsSource record);

    int updateByPrimaryKeySelective(TLeadsSource record);

    int updateByPrimaryKey(TLeadsSource record);
}