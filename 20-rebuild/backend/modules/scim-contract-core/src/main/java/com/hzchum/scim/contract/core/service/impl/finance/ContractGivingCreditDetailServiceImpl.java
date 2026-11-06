package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGivingCreditDetail;
import com.hzchum.scim.contract.core.api.service.finance.ContractGivingCreditDetailService;
import com.hzchum.scim.contract.core.mapper.finance.ContractGivingCreditDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractGivingCreditDetailServiceImpl
   extends ServiceImpl<ContractGivingCreditDetailMapper, ContractGivingCreditDetail>
   implements ContractGivingCreditDetailService {
}
