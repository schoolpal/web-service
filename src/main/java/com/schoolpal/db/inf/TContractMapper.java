package com.schoolpal.db.inf;

import com.schoolpal.db.model.TContract;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TContractMapper {
    int deleteOneById(String id);

    int insertOne(TContract record);

    TContract selectOneById(String id);

    List<TContract> selectManyByOrgId(@Param("orgId")String orgId);
    List<TContract> selectManyByOrgIdAndRankId(@Param("orgId")String orgId, @Param("rankId")Integer rankId);

    List<TContract> selectManyByExecutiveId(String id);
    List<TContract> selectManyByStuId(String id);

    int updateOne(TContract record);
}