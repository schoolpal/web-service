package com.schoolpal.db.inf;

import org.apache.ibatis.annotations.Param;

import com.schoolpal.db.model.TUser;

public interface TUserMapper {

    int insertOne(TUser record);
    int updateOneById(TUser record);
    int deleteOneById(String cId);

    TUser selectOneById(String cId);
    TUser selectOneByLoginName(String cName);
    String selectPasswordByLoginName(String cName);
    int updateLastVisitByLoginName(@Param("cName")String cName, @Param("cLastVisitIp")String cLastVisitIp);
}