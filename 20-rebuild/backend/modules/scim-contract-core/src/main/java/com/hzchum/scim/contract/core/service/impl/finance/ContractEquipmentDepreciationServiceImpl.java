package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractEquipmentDepreciation;
import com.hzchum.scim.contract.core.api.service.finance.ContractEquipmentDepreciationService;
import com.hzchum.scim.contract.core.mapper.finance.ContractEquipmentDepreciationMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractEquipmentDepreciationServiceImpl
   extends ServiceImpl<ContractEquipmentDepreciationMapper, ContractEquipmentDepreciation>
   implements ContractEquipmentDepreciationService {
}
