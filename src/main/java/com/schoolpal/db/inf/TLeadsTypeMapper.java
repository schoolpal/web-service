package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeadsType;

public interface TLeadsTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TLeadsType record);

    int insertSelective(TLeadsType record);

    TLeadsType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TLeadsType record);

    int updateByPrimaryKey(TLeadsType record);
}