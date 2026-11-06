package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractCollectionDisburse;
import com.hzchum.scim.contract.core.api.service.finance.ContractCollectionDisburseService;
import com.hzchum.scim.contract.core.mapper.finance.ContractCollectionDisburseMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractCollectionDisburseServiceImpl
   extends ServiceImpl<ContractCollectionDisburseMapper, ContractCollectionDisburse>
   implements ContractCollectionDisburseService {
}
