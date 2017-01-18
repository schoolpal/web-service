package com.schoolpal.db.inf;

import com.schoolpal.db.model.TOrg;

public interface TOrgMapper {
	
    TOrg selectOneById(String cId);
    
/*    long countByExample(TOrgExample example);

    int deleteByExample(TOrgExample example);

    int deleteByPrimaryKey(String cId);

    int insert(TOrg record);

    int insertSelective(TOrg record);

    List<TOrg> selectByExample(TOrgExample example);

    TOrg selectByPrimaryKey(String cId);

    int updateByExampleSelective(@Param("record") TOrg record, @Param("example") TOrgExample example);

    int updateByExample(@Param("record") TOrg record, @Param("example") TOrgExample example);

    int updateByPrimaryKeySelective(TOrg record);

    int updateByPrimaryKey(TOrg record);*/
}