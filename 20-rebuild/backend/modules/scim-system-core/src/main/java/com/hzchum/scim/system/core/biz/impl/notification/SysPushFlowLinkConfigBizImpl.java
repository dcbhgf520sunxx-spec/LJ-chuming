package com.hzchum.scim.system.core.biz.impl.notification;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowLinkConfigBiz;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushFlowLinkConfig;
import com.hzchum.scim.system.core.api.service.notification.SysPushFlowLinkConfigService;
import com.hzchum.scim.system.core.mapper.notification.SysPushFlowLinkConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class SysPushFlowLinkConfigBizImpl
   extends IBizImpl<SysPushFlowLinkConfigService, SysPushFlowLinkConfigMapper, SysPushFlowLinkConfig>
   implements SysPushFlowLinkConfigBiz {
}
