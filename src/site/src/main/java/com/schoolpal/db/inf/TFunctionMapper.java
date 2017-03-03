package com.schoolpal.db.inf;

import java.util.List;

import com.schoolpal.db.model.TFunction;

public interface TFunctionMapper {
//    int deleteByPrimaryKey(String cId);
//
//    int insert(TFunction record);
//
//    int insertSelective(TFunction record);
//
    TFunction selectOneById(String cId);
    List<TFunction> selectAllRoots();
    List<TFunction> selectAll();
    List<TFunction> selectManyByRootId(String cId);
    int ifExistsById(String cId);

//    int updateByPrimaryKeySelective(TFunction record);
//
//    int updateByPrimaryKey(TFunction record);
}