package com.hzchum.scim.system.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.MesInspectConfigUserLinkBiz;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfigUserLink;
import com.hzchum.scim.system.core.api.service.MesInspectConfigUserLinkService;
import com.hzchum.scim.system.core.mapper.MesInspectConfigUserLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesInspectConfigUserLinkBizImpl
   extends IBizImpl<MesInspectConfigUserLinkService, MesInspectConfigUserLinkMapper, MesInspectConfigUserLink>
   implements MesInspectConfigUserLinkBiz {
}
