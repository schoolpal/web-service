package com.schoolpal.db.inf;

import com.schoolpal.db.model.TRoleFunction;
import com.schoolpal.db.model.TRoleFunctionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRoleFunctionMapper {
    long countByExample(TRoleFunctionExample example);

    int deleteByExample(TRoleFunctionExample example);

    int insert(TRoleFunction record);

    int insertSelective(TRoleFunction record);

    List<TRoleFunction> selectByExample(TRoleFunctionExample example);

    int updateByExampleSelective(@Param("record") TRoleFunction record, @Param("example") TRoleFunctionExample example);

    int updateByExample(@Param("record") TRoleFunction record, @Param("example") TRoleFunctionExample example);
}