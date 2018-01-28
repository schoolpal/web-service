package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeads;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TLeadsMapper {

    int insertOne(TLeads record);
    int updateOne(TLeads record);
    int updateExecutiveById(@Param("id")String id, @Param("userId")String userId);
    int updateTypeById(@Param("id")String id, @Param("typeId")Integer typeId);
    int deleteOneById(String id);

    TLeads selectOneById(String id);
    TLeads selectOneByIdAndRankId(@Param("id") String id, @Param("rankId")Integer rankId);
    TLeads selectStudentAndParentById(String id);
    List<TLeads> selectManyByTypeIdAndOrgId(@Param("typeId")Integer typeId, @Param("orgId")String orgId);
    List<TLeads> selectManyByTypeIdAndOrgIdAndRankId(@Param("typeId")Integer typeId, @Param("orgId")String orgId, @Param("rankId")Integer rankId);
    List<TLeads> selectManyByTypeIdAndExecutiveId(@Param("typeId")Integer typeId, @Param("executiveId")String executiveId);

}