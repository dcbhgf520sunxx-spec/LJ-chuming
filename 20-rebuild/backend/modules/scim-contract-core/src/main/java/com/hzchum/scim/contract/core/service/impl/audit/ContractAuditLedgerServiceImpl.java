package com.hzchum.scim.contract.core.service.impl.audit;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import com.hzchum.scim.contract.core.mapper.audit.ContractAuditLedgerMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractAuditLedgerServiceImpl extends ServiceImpl<ContractAuditLedgerMapper, ContractAuditLedger> implements ContractAuditLedgerService {
   @Override
   public ContractAuditLedger getById(Long id) {
      return this.baseMapper.getById(id);
   }

   @Override
   public Boolean update(Long id) {
      return this.baseMapper.update(id);
   }
}
