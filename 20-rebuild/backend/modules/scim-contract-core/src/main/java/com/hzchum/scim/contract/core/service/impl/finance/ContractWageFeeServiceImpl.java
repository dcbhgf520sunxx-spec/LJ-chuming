package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWageFee;
import com.hzchum.scim.contract.core.api.service.finance.ContractWageFeeService;
import com.hzchum.scim.contract.core.mapper.finance.ContractWageFeeMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractWageFeeServiceImpl extends ServiceImpl<ContractWageFeeMapper, ContractWageFee> implements ContractWageFeeService {
}
