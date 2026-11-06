package com.hzchum.scim.plan.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.plan.core.api.biz.TechMachineHoleRadiusLinkBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachineHoleRadiusLink;
import com.hzchum.scim.plan.core.api.service.TechMachineHoleRadiusLinkService;
import com.hzchum.scim.plan.core.mapper.TechMachineHoleRadiusLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class TechMachineHoleRadiusLinkBizImpl
   extends IBizImpl<TechMachineHoleRadiusLinkService, TechMachineHoleRadiusLinkMapper, TechMachineHoleRadiusLink>
   implements TechMachineHoleRadiusLinkBiz {
}
