package com.hzchum.scim.system.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.MesMachineToolConfigBiz;
import com.hzchum.scim.system.core.api.pojo._do.MesMachineToolConfig;
import com.hzchum.scim.system.core.api.service.MesMachineToolConfigService;
import com.hzchum.scim.system.core.mapper.MesMachineToolConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class MesMachineToolConfigBizImpl
   extends IBizImpl<MesMachineToolConfigService, MesMachineToolConfigMapper, MesMachineToolConfig>
   implements MesMachineToolConfigBiz {
}
