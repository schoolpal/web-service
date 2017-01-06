package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeads;
import com.schoolpal.db.model.TLeadsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLeadsMapper {
    long countByExample(TLeadsExample example);

    int deleteByExample(TLeadsExample example);

    int deleteByPrimaryKey(String id);

    int insert(TLeads record);

    int insertSelective(TLeads record);

    List<TLeads> selectByExample(TLeadsExample example);

    TLeads selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TLeads record, @Param("example") TLeadsExample example);

    int updateByExample(@Param("record") TLeads record, @Param("example") TLeadsExample example);

    int updateByPrimaryKeySelective(TLeads record);

    int updateByPrimaryKey(TLeads record);
}