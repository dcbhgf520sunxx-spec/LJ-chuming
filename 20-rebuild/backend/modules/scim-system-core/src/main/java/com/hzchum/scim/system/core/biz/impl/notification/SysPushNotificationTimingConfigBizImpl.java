package com.hzchum.scim.system.core.biz.impl.notification;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.notification.SysPushNotificationTimingConfigBiz;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationTimingConfig;
import com.hzchum.scim.system.core.api.service.notification.SysPushNotificationTimingConfigService;
import com.hzchum.scim.system.core.mapper.notification.SysPushNotificationTimingConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class SysPushNotificationTimingConfigBizImpl
   extends IBizImpl<SysPushNotificationTimingConfigService, SysPushNotificationTimingConfigMapper, SysPushNotificationTimingConfig>
   implements SysPushNotificationTimingConfigBiz {
}
