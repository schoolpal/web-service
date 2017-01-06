package com.schoolpal.db.inf;

import com.schoolpal.db.model.TCrmAudit;
import com.schoolpal.db.model.TCrmAuditExample;
import com.schoolpal.db.model.TCrmAuditWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCrmAuditMapper {
    long countByExample(TCrmAuditExample example);

    int deleteByExample(TCrmAuditExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TCrmAuditWithBLOBs record);

    int insertSelective(TCrmAuditWithBLOBs record);

    List<TCrmAuditWithBLOBs> selectByExampleWithBLOBs(TCrmAuditExample example);

    List<TCrmAudit> selectByExample(TCrmAuditExample example);

    TCrmAuditWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TCrmAuditWithBLOBs record, @Param("example") TCrmAuditExample example);

    int updateByExampleWithBLOBs(@Param("record") TCrmAuditWithBLOBs record, @Param("example") TCrmAuditExample example);

    int updateByExample(@Param("record") TCrmAudit record, @Param("example") TCrmAuditExample example);

    int updateByPrimaryKeySelective(TCrmAuditWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TCrmAuditWithBLOBs record);

    int updateByPrimaryKey(TCrmAudit record);
}