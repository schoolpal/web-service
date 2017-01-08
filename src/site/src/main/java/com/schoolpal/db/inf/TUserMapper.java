package com.schoolpal.db.inf;

import com.schoolpal.db.model.TUser;
import com.schoolpal.db.model.TUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserMapper {
//    long countByExample(TUserExample example);
//
//    int deleteByExample(TUserExample example);
//    int deleteByPrimaryKey(String cId);
//
//    int insert(TUser record);
//    int insertSelective(TUser record);
//
//    List<TUser> selectByExample(TUserExample example);
//    TUser selectByPrimaryKey(String cId);
    TUser selectByLoginName(String cName);
    String selectPasswordByLoginName(String cName);

//    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);
//    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);
//    int updateByPrimaryKeySelective(TUser record);
//    int updateByPrimaryKey(TUser record);
    int updateLastVisitByLoginName(TUser record);
}