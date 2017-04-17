package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeadsStage;

public interface TLeadsStageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TLeadsStage record);

    int insertSelective(TLeadsStage record);

    TLeadsStage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TLeadsStage record);

    int updateByPrimaryKey(TLeadsStage record);
}