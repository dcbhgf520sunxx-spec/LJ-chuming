package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractReimbursementFee;
import com.hzchum.scim.contract.core.api.service.finance.ContractReimbursementFeeService;
import com.hzchum.scim.contract.core.mapper.finance.ContractReimbursementFeeMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractReimbursementFeeServiceImpl
   extends ServiceImpl<ContractReimbursementFeeMapper, ContractReimbursementFee>
   implements ContractReimbursementFeeService {
}
