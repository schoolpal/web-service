package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeadsStatus;
import com.schoolpal.db.model.TLeadsStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLeadsStatusMapper {
    long countByExample(TLeadsStatusExample example);

    int deleteByExample(TLeadsStatusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TLeadsStatus record);

    int insertSelective(TLeadsStatus record);

    List<TLeadsStatus> selectByExample(TLeadsStatusExample example);

    TLeadsStatus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TLeadsStatus record, @Param("example") TLeadsStatusExample example);

    int updateByExample(@Param("record") TLeadsStatus record, @Param("example") TLeadsStatusExample example);

    int updateByPrimaryKeySelective(TLeadsStatus record);

    int updateByPrimaryKey(TLeadsStatus record);
}