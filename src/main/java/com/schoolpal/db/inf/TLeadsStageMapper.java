package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeadsStage;

import java.util.List;

public interface TLeadsStageMapper {
    List<TLeadsStage> selectManyByTypeId(Integer typeId);
    TLeadsStage selectOneById(Integer id);
    
    int deleteByPrimaryKey(Integer id);

    int insert(TLeadsStage record);

    int insertSelective(TLeadsStage record);

    int updateByPrimaryKeySelective(TLeadsStage record);

    int updateByPrimaryKey(TLeadsStage record);
}