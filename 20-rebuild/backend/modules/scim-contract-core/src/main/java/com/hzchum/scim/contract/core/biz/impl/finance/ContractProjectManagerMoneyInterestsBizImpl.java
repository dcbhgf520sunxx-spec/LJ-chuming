package com.hzchum.scim.contract.core.biz.impl.finance;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.contract.core.api.biz.finance.ContractProjectManagerMoneyInterestsBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractProjectManagerMoneyInterests;
import com.hzchum.scim.contract.core.api.service.finance.ContractProjectManagerMoneyInterestsService;
import com.hzchum.scim.contract.core.mapper.finance.ContractProjectManagerMoneyInterestsMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractProjectManagerMoneyInterestsBizImpl
   extends IBizImpl<ContractProjectManagerMoneyInterestsService, ContractProjectManagerMoneyInterestsMapper, ContractProjectManagerMoneyInterests>
   implements ContractProjectManagerMoneyInterestsBiz {
}
