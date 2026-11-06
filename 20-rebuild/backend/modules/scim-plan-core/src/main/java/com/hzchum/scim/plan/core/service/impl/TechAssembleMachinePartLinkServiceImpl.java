package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.mapper.TechAssembleMachinePartLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class TechAssembleMachinePartLinkServiceImpl
   extends ServiceImpl<TechAssembleMachinePartLinkMapper, TechAssembleMachinePartLink>
   implements TechAssembleMachinePartLinkService {
}
