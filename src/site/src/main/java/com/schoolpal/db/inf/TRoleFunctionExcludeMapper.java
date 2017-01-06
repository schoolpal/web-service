package com.schoolpal.db.inf;

import com.schoolpal.db.model.TRoleFunctionExclude;
import com.schoolpal.db.model.TRoleFunctionExcludeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRoleFunctionExcludeMapper {
    long countByExample(TRoleFunctionExcludeExample example);

    int deleteByExample(TRoleFunctionExcludeExample example);

    int insert(TRoleFunctionExclude record);

    int insertSelective(TRoleFunctionExclude record);

    List<TRoleFunctionExclude> selectByExample(TRoleFunctionExcludeExample example);

    int updateByExampleSelective(@Param("record") TRoleFunctionExclude record, @Param("example") TRoleFunctionExcludeExample example);

    int updateByExample(@Param("record") TRoleFunctionExclude record, @Param("example") TRoleFunctionExcludeExample example);
}