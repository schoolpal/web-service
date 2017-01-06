package com.schoolpal.db.inf;

import com.schoolpal.db.model.TIndex;
import com.schoolpal.db.model.TIndexExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TIndexMapper {
    long countByExample(TIndexExample example);

    int deleteByExample(TIndexExample example);

    int deleteByPrimaryKey(String cTable);

    int insert(TIndex record);

    int insertSelective(TIndex record);

    List<TIndex> selectByExample(TIndexExample example);

    TIndex selectByPrimaryKey(String cTable);

    int updateByExampleSelective(@Param("record") TIndex record, @Param("example") TIndexExample example);

    int updateByExample(@Param("record") TIndex record, @Param("example") TIndexExample example);

    int updateByPrimaryKeySelective(TIndex record);

    int updateByPrimaryKey(TIndex record);
}