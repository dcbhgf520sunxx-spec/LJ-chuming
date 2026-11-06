package com.hzchum.scim.contract.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.ContractReimbursementDetail;
import com.hzchum.scim.contract.core.api.service.ContractReimbursementDetailService;
import com.hzchum.scim.contract.core.mapper.ContractReimbursementDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractReimbursementDetailServiceImpl
   extends ServiceImpl<ContractReimbursementDetailMapper, ContractReimbursementDetail>
   implements ContractReimbursementDetailService {
}
