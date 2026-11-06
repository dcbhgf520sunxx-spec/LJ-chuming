package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGivingCreditReturn;
import com.hzchum.scim.contract.core.api.service.finance.ContractGivingCreditReturnService;
import com.hzchum.scim.contract.core.mapper.finance.ContractGivingCreditReturnMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractGivingCreditReturnServiceImpl
   extends ServiceImpl<ContractGivingCreditReturnMapper, ContractGivingCreditReturn>
   implements ContractGivingCreditReturnService {
}
