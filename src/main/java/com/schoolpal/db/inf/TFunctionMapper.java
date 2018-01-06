package com.schoolpal.db.inf;

import com.schoolpal.db.model.TFunction;

import java.util.List;

public interface TFunctionMapper {
//    int deleteByPrimaryKey(String cId);
//
//    int insert(TFunction record);
//
//    int insertSelective(TFunction record);
//
    TFunction selectOneById(String cId);
    String selectIdByAction(String cAction);
    List<TFunction> selectAllRoots();
    List<TFunction> selectAll();
    List<TFunction> selectManyByRootId(String cId);
    List<String> selectIdsByRootId(String cId);
    int ifExistsById(String cId);

//    int updateByPrimaryKeySelective(TFunction record);
//
//    int updateByPrimaryKey(TFunction record);
}