package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLeadsStudent;

import java.util.List;

public interface TLeadsStudentMapper {

    int insertOne(TLeadsStudent record);
    int updateOne(TLeadsStudent record);
    int deleteOneById(String id);
    int deleteManyByLeadsId(String leadsId);

    TLeadsStudent selectOneById(String id);
    List<String> selectIdsByLeadsId(String leadsId);

}