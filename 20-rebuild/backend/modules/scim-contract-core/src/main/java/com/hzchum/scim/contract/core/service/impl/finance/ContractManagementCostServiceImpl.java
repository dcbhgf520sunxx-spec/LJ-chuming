package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractManagementCost;
import com.hzchum.scim.contract.core.api.service.finance.ContractManagementCostService;
import com.hzchum.scim.contract.core.mapper.finance.ContractManagementCostMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractManagementCostServiceImpl
   extends ServiceImpl<ContractManagementCostMapper, ContractManagementCost>
   implements ContractManagementCostService {
}
