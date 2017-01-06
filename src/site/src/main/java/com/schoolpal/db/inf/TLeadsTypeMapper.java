package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeadsType;
import com.schoolpal.db.model.TLeadsTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLeadsTypeMapper {
    long countByExample(TLeadsTypeExample example);

    int deleteByExample(TLeadsTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TLeadsType record);

    int insertSelective(TLeadsType record);

    List<TLeadsType> selectByExample(TLeadsTypeExample example);

    TLeadsType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TLeadsType record, @Param("example") TLeadsTypeExample example);

    int updateByExample(@Param("record") TLeadsType record, @Param("example") TLeadsTypeExample example);

    int updateByPrimaryKeySelective(TLeadsType record);

    int updateByPrimaryKey(TLeadsType record);
}