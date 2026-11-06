package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractProjectDisburseDetail;
import com.hzchum.scim.contract.core.api.service.finance.ContractProjectDisburseDetailService;
import com.hzchum.scim.contract.core.mapper.finance.ContractProjectDisburseDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractProjectDisburseDetailServiceImpl
   extends ServiceImpl<ContractProjectDisburseDetailMapper, ContractProjectDisburseDetail>
   implements ContractProjectDisburseDetailService {
}
