package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeadsSource;

import java.util.List;

public interface TLeadsSourceMapper {
    List<TLeadsSource> selectManyByTypeId(Integer typeId);
    TLeadsSource selectOneById(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(TLeadsSource record);

    int insertSelective(TLeadsSource record);

    int updateByPrimaryKeySelective(TLeadsSource record);

    int updateByPrimaryKey(TLeadsSource record);
}