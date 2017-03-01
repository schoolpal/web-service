package com.schoolpal.db.inf;

import java.util.List;

import com.schoolpal.db.model.TFunction;
import com.schoolpal.db.model.TRoleFunction;

public interface TRoleFunctionMapper {
	
	TRoleFunction selectOneByPrimaryKey(String roleId, String funcRootId);
	List<TFunction> selectManyByRoleId(String roleId);
	
    int insertOne(TRoleFunction record);
    
    int deleteOneByPrimaryKey(String roleId, String funcRootId);
    int deleteManyByRoleId(String roleId);

//    int insertSelective(TRoleFunction record);
//    int updateByPrimaryKeySelective(TRoleFunction record);

}