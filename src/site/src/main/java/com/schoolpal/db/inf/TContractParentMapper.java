package com.schoolpal.db.inf;

import com.schoolpal.db.model.TContractParent;
import com.schoolpal.db.model.TContractParentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TContractParentMapper {
    long countByExample(TContractParentExample example);

    int deleteByExample(TContractParentExample example);

    int deleteByPrimaryKey(String id);

    int insert(TContractParent record);

    int insertSelective(TContractParent record);

    List<TContractParent> selectByExample(TContractParentExample example);

    TContractParent selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TContractParent record, @Param("example") TContractParentExample example);

    int updateByExample(@Param("record") TContractParent record, @Param("example") TContractParentExample example);

    int updateByPrimaryKeySelective(TContractParent record);

    int updateByPrimaryKey(TContractParent record);
}