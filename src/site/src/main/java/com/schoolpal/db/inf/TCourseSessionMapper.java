package com.schoolpal.db.inf;

import com.schoolpal.db.model.TCourseSession;
import com.schoolpal.db.model.TCourseSessionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCourseSessionMapper {
    long countByExample(TCourseSessionExample example);

    int deleteByExample(TCourseSessionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCourseSession record);

    int insertSelective(TCourseSession record);

    List<TCourseSession> selectByExample(TCourseSessionExample example);

    TCourseSession selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCourseSession record, @Param("example") TCourseSessionExample example);

    int updateByExample(@Param("record") TCourseSession record, @Param("example") TCourseSessionExample example);

    int updateByPrimaryKeySelective(TCourseSession record);

    int updateByPrimaryKey(TCourseSession record);
}