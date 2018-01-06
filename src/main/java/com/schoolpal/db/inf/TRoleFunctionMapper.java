package com.schoolpal.db.inf;

import com.schoolpal.db.model.TFunction;
import com.schoolpal.db.model.TRoleFunction;

import java.util.List;

public interface TRoleFunctionMapper {
	
	TRoleFunction selectOneByPrimaryKey(String roleId, String funcRootId);
	List<TFunction> selectAllFuncsByRoleId(String roleId);
	List<TFunction> selectRootFuncsByRoleId(String roleId);
	
    int insertOne(TRoleFunction record);
    
    int deleteOneByPrimaryKey(String roleId, String funcRootId);
    int deleteManyByRoleId(String roleId);

//    int insertSelective(TRoleFunction record);
//    int updateByPrimaryKeySelective(TRoleFunction record);

}