package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeadsSource;
import com.schoolpal.db.model.TLeadsSourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLeadsSourceMapper {
    long countByExample(TLeadsSourceExample example);

    int deleteByExample(TLeadsSourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TLeadsSource record);

    int insertSelective(TLeadsSource record);

    List<TLeadsSource> selectByExample(TLeadsSourceExample example);

    TLeadsSource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TLeadsSource record, @Param("example") TLeadsSourceExample example);

    int updateByExample(@Param("record") TLeadsSource record, @Param("example") TLeadsSourceExample example);

    int updateByPrimaryKeySelective(TLeadsSource record);

    int updateByPrimaryKey(TLeadsSource record);
}