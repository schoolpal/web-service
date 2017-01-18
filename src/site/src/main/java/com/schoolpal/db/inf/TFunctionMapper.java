package com.schoolpal.db.inf;

import com.schoolpal.db.model.TFunction;
import com.schoolpal.db.model.TFunctionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TFunctionMapper {
	
    List<TFunction> selectFuncsByRoleId(String cId);
	
/*    long countByExample(TFunctionExample example);

    int deleteByExample(TFunctionExample example);

    int deleteByPrimaryKey(String cId);

    int insert(TFunction record);

    int insertSelective(TFunction record);

    List<TFunction> selectByExample(TFunctionExample example);

    TFunction selectByPrimaryKey(String cId);

    int updateByExampleSelective(@Param("record") TFunction record, @Param("example") TFunctionExample example);

    int updateByExample(@Param("record") TFunction record, @Param("example") TFunctionExample example);

    int updateByPrimaryKeySelective(TFunction record);

    int updateByPrimaryKey(TFunction record);*/
}