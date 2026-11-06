package com.hzchum.scim.contract.core.mapper.audit;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.AuditUserDTO;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;

public interface ContractAuditLedgerMapper extends BaseMapper<ContractAuditLedger> {
   List<AuditUserDTO> getAuditList(Long auditId);

   ContractAuditLedger getById(@Param("id") Long id);

   Boolean update(@Param("id") Long id);
}
