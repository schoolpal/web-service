package com.schoolpal.db.inf;

import com.schoolpal.db.model.TUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserMapper {

    int insertOne(TUser record);
    int updateOneById(TUser record);
    int deleteOneById(String cId);

    boolean ifExistsById(String cId);
    TUser selectOneById(String cId);
    boolean ifExistsByName(String cName);
    TUser selectOneByLoginName(String cName);
    List<TUser> selectManyByOrgId(String cId);
    
    String selectPasswordByLoginName(String cName);
    
    int updateLastVisitByLoginName(@Param("cName")String cName, @Param("cLastVisitIp")String cLastVisitIp);
    int updateAvaiabilityById(@Param("cId")String cId, @Param("cAvailable")boolean cAvailable);
    int updateLoginPassById(@Param("cId")String cId, @Param("cOriPass")String cOriPass, @Param("cNewPass")String cNewPass);
}