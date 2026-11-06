package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.finance.SecurityDepositAndManagementCost;
import com.hzchum.scim.contract.core.api.service.finance.SecurityDepositAndManagementCostService;
import com.hzchum.scim.contract.core.mapper.finance.SecurityDepositAndManagementCostMapper;
import org.springframework.stereotype.Service;

@Service
public class SecurityDepositAndManagementCostServiceImpl
   extends ServiceImpl<SecurityDepositAndManagementCostMapper, SecurityDepositAndManagementCost>
   implements SecurityDepositAndManagementCostService {
}
