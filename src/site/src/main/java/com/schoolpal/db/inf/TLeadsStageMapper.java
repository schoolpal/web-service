package com.schoolpal.db.inf;

import java.util.List;

import com.schoolpal.db.model.TLeadsStage;

public interface TLeadsStageMapper {
    List<TLeadsStage> selectAll();
    TLeadsStage selectOneById(Integer id);
    
    int deleteByPrimaryKey(Integer id);

    int insert(TLeadsStage record);

    int insertSelective(TLeadsStage record);

    int updateByPrimaryKeySelective(TLeadsStage record);

    int updateByPrimaryKey(TLeadsStage record);
}