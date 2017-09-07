package com.schoolpal.db.inf;

import com.schoolpal.db.model.TIndex;

public interface TIndexMapper {
	
    String selectNextId(String cTable);
	
    int deleteByPrimaryKey(String cTable);

    int insert(TIndex record);

    int insertSelective(TIndex record);

    TIndex selectByPrimaryKey(String cTable);

    int updateByPrimaryKeySelective(TIndex record);

    int updateByPrimaryKey(TIndex record);
}