package com.schoolpal.db.inf;

import java.util.List;

import com.schoolpal.db.model.TActivity;

public interface TActivityMapper {
/*    int deleteByPrimaryKey(Integer id);

    int insert(TActivity record);

    int insertSelective(TActivity record);

    TActivity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TActivity record);

    int updateByPrimaryKey(TActivity record);
*/    
    List<TActivity> selectManyByParentId();
}