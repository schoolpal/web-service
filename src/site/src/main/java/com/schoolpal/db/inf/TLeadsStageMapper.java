package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeadsStage;
import com.schoolpal.db.model.TLeadsStageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLeadsStageMapper {
    long countByExample(TLeadsStageExample example);

    int deleteByExample(TLeadsStageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TLeadsStage record);

    int insertSelective(TLeadsStage record);

    List<TLeadsStage> selectByExample(TLeadsStageExample example);

    TLeadsStage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TLeadsStage record, @Param("example") TLeadsStageExample example);

    int updateByExample(@Param("record") TLeadsStage record, @Param("example") TLeadsStageExample example);

    int updateByPrimaryKeySelective(TLeadsStage record);

    int updateByPrimaryKey(TLeadsStage record);
}