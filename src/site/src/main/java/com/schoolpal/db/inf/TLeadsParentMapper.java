package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeadsParent;
import com.schoolpal.db.model.TLeadsParentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLeadsParentMapper {
    long countByExample(TLeadsParentExample example);

    int deleteByExample(TLeadsParentExample example);

    int deleteByPrimaryKey(String leadsId);

    int insert(TLeadsParent record);

    int insertSelective(TLeadsParent record);

    List<TLeadsParent> selectByExample(TLeadsParentExample example);

    TLeadsParent selectByPrimaryKey(String leadsId);

    int updateByExampleSelective(@Param("record") TLeadsParent record, @Param("example") TLeadsParentExample example);

    int updateByExample(@Param("record") TLeadsParent record, @Param("example") TLeadsParentExample example);

    int updateByPrimaryKeySelective(TLeadsParent record);

    int updateByPrimaryKey(TLeadsParent record);
}