package com.hzchum.scim.system.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.MesMachineToolUserLinkBiz;
import com.hzchum.scim.system.core.api.pojo._do.MesMachineToolUserLink;
import com.hzchum.scim.system.core.api.service.MesMachineToolUserLinkService;
import com.hzchum.scim.system.core.mapper.MesMachineToolUserLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesMachineToolUserLinkBizImpl
   extends IBizImpl<MesMachineToolUserLinkService, MesMachineToolUserLinkMapper, MesMachineToolUserLink>
   implements MesMachineToolUserLinkBiz {
}
