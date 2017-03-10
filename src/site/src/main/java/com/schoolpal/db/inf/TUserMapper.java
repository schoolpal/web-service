package com.schoolpal.db.inf;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.schoolpal.db.model.TUser;

public interface TUserMapper {

    int insertOne(TUser record);
    int updateOneById(TUser record);
    int deleteOneById(String cId);

    TUser selectOneById(String cId);
    TUser selectOneByLoginName(String cName);
    List<TUser> selectManyByOrgId(String cId);
    
    String selectPasswordByLoginName(String cName);
    
    int updateLastVisitByLoginName(@Param("cName")String cName, @Param("cLastVisitIp")String cLastVisitIp);
    int updateAvaiabilityById(@Param("cId")String cId, @Param("cAvailable")boolean cAvailable);
}