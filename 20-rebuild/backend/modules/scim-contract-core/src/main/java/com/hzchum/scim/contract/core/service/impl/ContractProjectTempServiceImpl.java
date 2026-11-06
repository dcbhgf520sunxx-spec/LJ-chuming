package com.hzchum.scim.contract.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectTemp;
import com.hzchum.scim.contract.core.api.service.ContractProjectTempService;
import com.hzchum.scim.contract.core.mapper.ContractProjectTempMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractProjectTempServiceImpl extends ServiceImpl<ContractProjectTempMapper, ContractProjectTemp> implements ContractProjectTempService {
}
