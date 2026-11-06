package com.hzchum.scim.plan.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.plan.core.api.biz.ProcessInstructionLinkBiz;
import com.hzchum.scim.plan.core.api.pojo._do.ProcessInstructionLink;
import com.hzchum.scim.plan.core.api.service.ProcessInstructionLinkService;
import com.hzchum.scim.plan.core.mapper.ProcessInstructionLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class ProcessInstructionLinkBizImpl
   extends IBizImpl<ProcessInstructionLinkService, ProcessInstructionLinkMapper, ProcessInstructionLink>
   implements ProcessInstructionLinkBiz {
}
