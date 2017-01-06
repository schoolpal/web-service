package com.schoolpal.db.inf;

import com.schoolpal.db.model.TRank;
import com.schoolpal.db.model.TRankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRankMapper {
    long countByExample(TRankExample example);

    int deleteByExample(TRankExample example);

    int deleteByPrimaryKey(Integer cId);

    int insert(TRank record);

    int insertSelective(TRank record);

    List<TRank> selectByExample(TRankExample example);

    TRank selectByPrimaryKey(Integer cId);

    int updateByExampleSelective(@Param("record") TRank record, @Param("example") TRankExample example);

    int updateByExample(@Param("record") TRank record, @Param("example") TRankExample example);

    int updateByPrimaryKeySelective(TRank record);

    int updateByPrimaryKey(TRank record);
}