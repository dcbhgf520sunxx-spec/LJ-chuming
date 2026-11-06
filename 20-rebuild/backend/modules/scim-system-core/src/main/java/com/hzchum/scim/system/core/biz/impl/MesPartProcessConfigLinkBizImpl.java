package com.hzchum.scim.system.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.MesPartProcessConfigLinkBiz;
import com.hzchum.scim.system.core.api.pojo._do.MesPartProcessConfigLink;
import com.hzchum.scim.system.core.api.service.MesPartProcessConfigLinkService;
import com.hzchum.scim.system.core.mapper.MesPartProcessConfigLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesPartProcessConfigLinkBizImpl
   extends IBizImpl<MesPartProcessConfigLinkService, MesPartProcessConfigLinkMapper, MesPartProcessConfigLink>
   implements MesPartProcessConfigLinkBiz {
}
