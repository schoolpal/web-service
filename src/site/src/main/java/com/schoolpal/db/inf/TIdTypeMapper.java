package com.schoolpal.db.inf;

import com.schoolpal.db.model.TIdType;
import com.schoolpal.db.model.TIdTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TIdTypeMapper {
    long countByExample(TIdTypeExample example);

    int deleteByExample(TIdTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TIdType record);

    int insertSelective(TIdType record);

    List<TIdType> selectByExample(TIdTypeExample example);

    TIdType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TIdType record, @Param("example") TIdTypeExample example);

    int updateByExample(@Param("record") TIdType record, @Param("example") TIdTypeExample example);

    int updateByPrimaryKeySelective(TIdType record);

    int updateByPrimaryKey(TIdType record);
}