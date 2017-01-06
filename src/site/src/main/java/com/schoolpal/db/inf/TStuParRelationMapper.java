package com.schoolpal.db.inf;

import com.schoolpal.db.model.TStuParRelation;
import com.schoolpal.db.model.TStuParRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TStuParRelationMapper {
    long countByExample(TStuParRelationExample example);

    int deleteByExample(TStuParRelationExample example);

    int deleteByPrimaryKey(String id);

    int insert(TStuParRelation record);

    int insertSelective(TStuParRelation record);

    List<TStuParRelation> selectByExample(TStuParRelationExample example);

    TStuParRelation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TStuParRelation record, @Param("example") TStuParRelationExample example);

    int updateByExample(@Param("record") TStuParRelation record, @Param("example") TStuParRelationExample example);

    int updateByPrimaryKeySelective(TStuParRelation record);

    int updateByPrimaryKey(TStuParRelation record);
}