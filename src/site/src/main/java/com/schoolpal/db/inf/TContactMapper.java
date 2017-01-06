package com.schoolpal.db.inf;

import com.schoolpal.db.model.TContact;
import com.schoolpal.db.model.TContactExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TContactMapper {
    long countByExample(TContactExample example);

    int deleteByExample(TContactExample example);

    int deleteByPrimaryKey(String id);

    int insert(TContact record);

    int insertSelective(TContact record);

    List<TContact> selectByExample(TContactExample example);

    TContact selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TContact record, @Param("example") TContactExample example);

    int updateByExample(@Param("record") TContact record, @Param("example") TContactExample example);

    int updateByPrimaryKeySelective(TContact record);

    int updateByPrimaryKey(TContact record);
}