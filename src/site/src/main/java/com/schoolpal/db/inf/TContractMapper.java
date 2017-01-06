package com.schoolpal.db.inf;

import com.schoolpal.db.model.TContract;
import com.schoolpal.db.model.TContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TContractMapper {
    long countByExample(TContractExample example);

    int deleteByExample(TContractExample example);

    int deleteByPrimaryKey(String id);

    int insert(TContract record);

    int insertSelective(TContract record);

    List<TContract> selectByExample(TContractExample example);

    TContract selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TContract record, @Param("example") TContractExample example);

    int updateByExample(@Param("record") TContract record, @Param("example") TContractExample example);

    int updateByPrimaryKeySelective(TContract record);

    int updateByPrimaryKey(TContract record);
}