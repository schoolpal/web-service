package com.schoolpal.db.inf;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.schoolpal.db.model.TRole;

public interface TRoleMapper {
	
    List<TRole> selectRolesByUserId(String cId);
    
    List<TRole> selectRolesByOrgId(String cId);
    
    TRole selectOneById(String cid);
    
    int ifExistsById(String cId);
    
    int insertOne(TRole record);

    int updateOneById(TRole record);

    int deleteOneById(String cId);
    
    int getCountByPrimaryIdsAndRankId(@Param("cIds")String[] cIds, @Param("cRankId")int cRankId);
    
    /*    long countByExample(TRoleExample example);

    int deleteByPrimaryKey(String cId);

    int insertSelective(TRole record);

    List<TRole> selectByExample(TRoleExample example);

    TRole selectByPrimaryKey(String cId);

    int updateByExampleSelective(@Param("record") TRole record, @Param("example") TRoleExample example);

    int updateByExample(@Param("record") TRole record, @Param("example") TRoleExample example);

    int updateByPrimaryKeySelective(TRole record);

*/
}