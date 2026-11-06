package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.ProcessInstructionLink;
import com.hzchum.scim.plan.core.api.service.ProcessInstructionLinkService;
import com.hzchum.scim.plan.core.mapper.ProcessInstructionLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class ProcessInstructionLinkServiceImpl
   extends ServiceImpl<ProcessInstructionLinkMapper, ProcessInstructionLink>
   implements ProcessInstructionLinkService {
}
