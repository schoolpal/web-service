package com.schoolpal.db.inf;

import java.util.List;

import com.schoolpal.db.model.TLeadsStudent;

public interface TLeadsStudentMapper {

    int insertOne(TLeadsStudent record);
    int updateOne(TLeadsStudent record);
    int deleteOneById(String id);
    int deleteManyByLeadsId(String leadsId);

    TLeadsStudent selectOneById(String id);
    List<String> selectIdsByLeadsId(String leadsId);

}