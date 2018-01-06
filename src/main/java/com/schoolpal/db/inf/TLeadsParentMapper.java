package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeadsParent;

import java.util.List;

public interface TLeadsParentMapper {

    int insertOne(TLeadsParent record);
    int updateOne(TLeadsParent record);
    int deleteOneById(String id);
    int deleteManyByLeadsId(String leadsId);

    TLeadsParent selectOneById(String id);
    List<String> selectIdsByLeadsId(String leadsId);

}