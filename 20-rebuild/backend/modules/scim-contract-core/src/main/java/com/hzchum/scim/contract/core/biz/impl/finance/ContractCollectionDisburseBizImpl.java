package com.hzchum.scim.contract.core.biz.impl.finance;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.contract.core.api.biz.finance.ContractCollectionDisburseBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractCollectionDisburse;
import com.hzchum.scim.contract.core.api.service.finance.ContractCollectionDisburseService;
import com.hzchum.scim.contract.core.mapper.finance.ContractCollectionDisburseMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractCollectionDisburseBizImpl
   extends IBizImpl<ContractCollectionDisburseService, ContractCollectionDisburseMapper, ContractCollectionDisburse>
   implements ContractCollectionDisburseBiz {
}
