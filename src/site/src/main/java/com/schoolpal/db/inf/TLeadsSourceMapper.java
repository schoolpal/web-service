package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeadsSource;

public interface TLeadsSourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TLeadsSource record);

    int insertSelective(TLeadsSource record);

    TLeadsSource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TLeadsSource record);

    int updateByPrimaryKey(TLeadsSource record);
}