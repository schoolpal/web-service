package com.schoolpal.db.inf;

import com.schoolpal.db.model.TUserRole;
import com.schoolpal.db.model.TUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserRoleMapper {
    long countByExample(TUserRoleExample example);

    int deleteByExample(TUserRoleExample example);

    int deleteByPrimaryKey(String cId);

    int insert(TUserRole record);

    int insertSelective(TUserRole record);

    List<TUserRole> selectByExample(TUserRoleExample example);

    TUserRole selectByPrimaryKey(String cId);

    int updateByExampleSelective(@Param("record") TUserRole record, @Param("example") TUserRoleExample example);

    int updateByExample(@Param("record") TUserRole record, @Param("example") TUserRoleExample example);

    int updateByPrimaryKeySelective(TUserRole record);

    int updateByPrimaryKey(TUserRole record);
}