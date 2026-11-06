package com.hzchum.scim.contract.core.api.service.audit;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;

public interface ContractAuditLedgerService extends IService<ContractAuditLedger> {
   ContractAuditLedger getById(Long id);

   Boolean update(Long id);
}
