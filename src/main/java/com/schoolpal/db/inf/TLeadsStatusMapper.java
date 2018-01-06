package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeadsStatus;

import java.util.List;

public interface TLeadsStatusMapper {
    List<TLeadsStatus> selectManyByTypeId(Integer typeId);
    TLeadsStatus selectOneById(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(TLeadsStatus record);

    int insertSelective(TLeadsStatus record);

    int updateByPrimaryKeySelective(TLeadsStatus record);

    int updateByPrimaryKey(TLeadsStatus record);
}