package com.schoolpal.db.inf;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.schoolpal.db.model.TLeads;

public interface TLeadsMapper {

    int insertOne(TLeads record);
    int updateOne(TLeads record);
    int deleteOneById(String id);

    TLeads selectOneById(String id);
    List<TLeads> selectManyByOrgAndTypeId(@Param("orgId")String orgId, @Param("typeId")Integer typeId);

}