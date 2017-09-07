package com.schoolpal.db.inf;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.schoolpal.db.model.TActivity;

public interface TActivityMapper {
/*    int deleteByPrimaryKey(Integer id);

    int insert(TActivity record);

    int insertSelective(TActivity record);

    TActivity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TActivity record);

    int updateByPrimaryKey(TActivity record);
*/    
    List<TActivity> selectManyByParentId(@Param("id")String id);
    List<TActivity> selectManyByTopLevel();
    List<TActivity> selectManyByOrgId(@Param("id")String id);
    List<TActivity> selectAll();
    TActivity selectOneById(@Param("id")String id);
    
    int insertOne(TActivity record);
    int updateOneById(TActivity record);
    int updateLeadsCountsById(String id);
    int deleteOneById(String id);
}