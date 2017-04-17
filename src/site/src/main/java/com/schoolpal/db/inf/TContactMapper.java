package com.schoolpal.db.inf;

import com.schoolpal.db.model.TContact;

public interface TContactMapper {
    int deleteByPrimaryKey(String id);

    int insert(TContact record);

    int insertSelective(TContact record);

    TContact selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TContact record);

    int updateByPrimaryKey(TContact record);
}