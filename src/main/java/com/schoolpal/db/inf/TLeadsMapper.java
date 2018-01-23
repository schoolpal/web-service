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
    TLeads selectStudentAndParentById(String id);
    List<TLeads> selectManyByOrgAndTypeId(@Param("orgId")String orgId, @Param("typeId")Integer typeId);
    List<TLeads> selectManyByExecutiveId(@Param("executiveId")String executiveId);

}