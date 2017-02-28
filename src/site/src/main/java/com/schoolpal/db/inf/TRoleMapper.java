package com.schoolpal.db.inf;

import java.util.List;

import com.schoolpal.db.model.TRole;

public interface TRoleMapper {
	
    List<TRole> selectRolesByUserId(String cId);
    
    List<TRole> selectRolesByOrgId(String cId);
    
    TRole selectOneById(String cid);
    
    int insertOne(TRole record);

/*    long countByExample(TRoleExample example);

    int deleteByExample(TRoleExample example);

    int deleteByPrimaryKey(String cId);

    int insertSelective(TRole record);

    List<TRole> selectByExample(TRoleExample example);

    TRole selectByPrimaryKey(String cId);

    int updateByExampleSelective(@Param("record") TRole record, @Param("example") TRoleExample example);

    int updateByExample(@Param("record") TRole record, @Param("example") TRoleExample example);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);*/
}