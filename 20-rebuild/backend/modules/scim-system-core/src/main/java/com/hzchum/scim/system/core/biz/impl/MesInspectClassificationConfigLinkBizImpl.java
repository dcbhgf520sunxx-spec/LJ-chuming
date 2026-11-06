package com.hzchum.scim.system.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.MesInspectClassificationConfigLinkBiz;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectClassificationConfigLink;
import com.hzchum.scim.system.core.api.service.MesInspectClassificationConfigLinkService;
import com.hzchum.scim.system.core.mapper.MesInspectClassificationConfigLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesInspectClassificationConfigLinkBizImpl
   extends IBizImpl<MesInspectClassificationConfigLinkService, MesInspectClassificationConfigLinkMapper, MesInspectClassificationConfigLink>
   implements MesInspectClassificationConfigLinkBiz {
}
