package com.schoolpal.db.inf;

import java.util.List;

import com.schoolpal.db.model.TLeadsSource;
import com.schoolpal.db.model.TLeadsStage;

public interface TLeadsSourceMapper {
    List<TLeadsSource> selectManyByTypeId(Integer typeId);
    TLeadsSource selectOneById(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(TLeadsSource record);

    int insertSelective(TLeadsSource record);

    int updateByPrimaryKeySelective(TLeadsSource record);

    int updateByPrimaryKey(TLeadsSource record);
}