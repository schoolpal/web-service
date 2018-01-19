package com.schoolpal.db.inf;

import com.schoolpal.db.model.TLog;
import com.schoolpal.db.model.TLogWithBLOBs;

public interface TLogMapper {
    int deleteByPrimaryKey(String id);

    int insertOne(TLogWithBLOBs record);

    TLogWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TLogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TLogWithBLOBs record);

    int updateByPrimaryKey(TLog record);
}