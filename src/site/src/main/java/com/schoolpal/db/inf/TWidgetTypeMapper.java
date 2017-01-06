package com.schoolpal.db.inf;

import com.schoolpal.db.model.TWidgetType;
import com.schoolpal.db.model.TWidgetTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TWidgetTypeMapper {
    long countByExample(TWidgetTypeExample example);

    int deleteByExample(TWidgetTypeExample example);

    int deleteByPrimaryKey(Integer cId);

    int insert(TWidgetType record);

    int insertSelective(TWidgetType record);

    List<TWidgetType> selectByExample(TWidgetTypeExample example);

    TWidgetType selectByPrimaryKey(Integer cId);

    int updateByExampleSelective(@Param("record") TWidgetType record, @Param("example") TWidgetTypeExample example);

    int updateByExample(@Param("record") TWidgetType record, @Param("example") TWidgetTypeExample example);

    int updateByPrimaryKeySelective(TWidgetType record);

    int updateByPrimaryKey(TWidgetType record);
}