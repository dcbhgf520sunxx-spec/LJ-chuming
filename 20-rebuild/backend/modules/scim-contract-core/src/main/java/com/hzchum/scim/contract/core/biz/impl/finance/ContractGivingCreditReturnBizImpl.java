package com.hzchum.scim.contract.core.biz.impl.finance;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.contract.core.api.biz.finance.ContractGivingCreditReturnBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGivingCreditReturn;
import com.hzchum.scim.contract.core.api.service.finance.ContractGivingCreditReturnService;
import com.hzchum.scim.contract.core.mapper.finance.ContractGivingCreditReturnMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractGivingCreditReturnBizImpl
   extends IBizImpl<ContractGivingCreditReturnService, ContractGivingCreditReturnMapper, ContractGivingCreditReturn>
   implements ContractGivingCreditReturnBiz {
}
