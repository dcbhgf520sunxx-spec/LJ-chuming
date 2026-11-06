package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWaterElectricityPropertyFee;
import com.hzchum.scim.contract.core.api.service.finance.ContractWaterElectricityPropertyFeeService;
import com.hzchum.scim.contract.core.mapper.finance.ContractWaterElectricityPropertyFeeMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractWaterElectricityPropertyFeeServiceImpl
   extends ServiceImpl<ContractWaterElectricityPropertyFeeMapper, ContractWaterElectricityPropertyFee>
   implements ContractWaterElectricityPropertyFeeService {
}
