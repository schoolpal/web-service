package com.schoolpal.db.inf;

import com.schoolpal.db.model.TRoleFunctionExclude;

public interface TRoleFunctionExcludeMapper {
    int deleteOneByPrimaryKey(String roleId, String functionId);
    int deleteManyByRoleId(String roleId);

    int insertOne(TRoleFunctionExclude record);

    TRoleFunctionExclude selectOneByPrimaryKey(String roleId, String functionId);
}