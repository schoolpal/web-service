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
    List<TActivity> selectManyByParentId(@Param("id")int id);
    List<TActivity> selectManyByTopLevel();
    List<TActivity> selectAll();
    TActivity selectOneById(@Param("id")int id);
    
    int insertOne(TActivity record);
    int updateOneById(TActivity record);
    int deleteOneById(Integer id);
}