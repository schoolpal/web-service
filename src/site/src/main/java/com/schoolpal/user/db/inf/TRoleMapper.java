package com.schoolpal.user.db.inf;

import java.util.List;

import com.schoolpal.user.db.model.TRole;

public interface TRoleMapper {
	
    List<TRole> selectRolesByUserId(String cId);
    
    TRole selectOneById(String cid);
    
/*    long countByExample(TRoleExample example);

    int deleteByExample(TRoleExample example);

    int deleteByPrimaryKey(String cId);

    int insert(TRole record);

    int insertSelective(TRole record);

    List<TRole> selectByExample(TRoleExample example);

    TRole selectByPrimaryKey(String cId);

    int updateByExampleSelective(@Param("record") TRole record, @Param("example") TRoleExample example);

    int updateByExample(@Param("record") TRole record, @Param("example") TRoleExample example);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);*/
}