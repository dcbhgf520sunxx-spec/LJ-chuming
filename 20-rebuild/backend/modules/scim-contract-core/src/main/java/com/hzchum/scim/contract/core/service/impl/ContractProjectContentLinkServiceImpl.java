package com.hzchum.scim.contract.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectContentLink;
import com.hzchum.scim.contract.core.api.service.ContractProjectContentLinkService;
import com.hzchum.scim.contract.core.mapper.ContractProjectContentLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractProjectContentLinkServiceImpl
   extends ServiceImpl<ContractProjectContentLinkMapper, ContractProjectContentLink>
   implements ContractProjectContentLinkService {
}
