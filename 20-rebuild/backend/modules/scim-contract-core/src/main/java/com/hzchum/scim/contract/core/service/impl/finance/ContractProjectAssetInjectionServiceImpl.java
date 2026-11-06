package com.hzchum.scim.contract.core.service.impl.finance;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractProjectAssetInjection;
import com.hzchum.scim.contract.core.api.service.finance.ContractProjectAssetInjectionService;
import com.hzchum.scim.contract.core.mapper.finance.ContractProjectAssetInjectionMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractProjectAssetInjectionServiceImpl
   extends ServiceImpl<ContractProjectAssetInjectionMapper, ContractProjectAssetInjection>
   implements ContractProjectAssetInjectionService {
}
