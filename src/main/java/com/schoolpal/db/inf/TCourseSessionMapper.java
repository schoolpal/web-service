package com.schoolpal.db.inf;

import com.schoolpal.db.model.TCourseSession;

import java.util.List;

public interface TCourseSessionMapper {
    int deleteByPrimaryKey(String id);

    int insert(TCourseSession record);

    int insertSelective(TCourseSession record);

    TCourseSession selectOneById(String id);
    List<TCourseSession> selectManyByTypeId(String typeId);

    int updateByPrimaryKeySelective(TCourseSession record);

    int updateByPrimaryKey(TCourseSession record);
}