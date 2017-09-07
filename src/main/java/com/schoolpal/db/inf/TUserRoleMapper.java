package com.schoolpal.db.inf;

import com.schoolpal.db.model.TUserRole;

public interface TUserRoleMapper {
    int deleteOneByPrimaryKey(String userId, String roleId);
    int deleteManyByUserId(String userId);

    int insertOne(TUserRole record);

    TUserRole selectByPrimaryKey(String userId, String roleId);
}