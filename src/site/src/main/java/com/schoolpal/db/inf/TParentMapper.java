package com.schoolpal.db.inf;

import com.schoolpal.db.model.TParent;
import com.schoolpal.db.model.TParentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TParentMapper {
    long countByExample(TParentExample example);

    int deleteByExample(TParentExample example);

    int deleteByPrimaryKey(String id);

    int insert(TParent record);

    int insertSelective(TParent record);

    List<TParent> selectByExample(TParentExample example);

    TParent selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TParent record, @Param("example") TParentExample example);

    int updateByExample(@Param("record") TParent record, @Param("example") TParentExample example);

    int updateByPrimaryKeySelective(TParent record);

    int updateByPrimaryKey(TParent record);
}