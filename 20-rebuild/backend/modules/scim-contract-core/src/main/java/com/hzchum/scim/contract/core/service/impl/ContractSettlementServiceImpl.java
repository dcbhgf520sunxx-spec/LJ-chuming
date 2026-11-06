package com.hzchum.scim.contract.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.ContractSettlement;
import com.hzchum.scim.contract.core.api.service.ContractSettlementService;
import com.hzchum.scim.contract.core.mapper.ContractSettlementMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractSettlementServiceImpl extends ServiceImpl<ContractSettlementMapper, ContractSettlement> implements ContractSettlementService {
}
