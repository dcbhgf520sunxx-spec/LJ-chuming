package com.hzchum.scim.system.core.service.impl.notification;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationTimingConfig;
import com.hzchum.scim.system.core.api.service.notification.SysPushNotificationTimingConfigService;
import com.hzchum.scim.system.core.mapper.notification.SysPushNotificationTimingConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class SysPushNotificationTimingConfigServiceImpl
   extends ServiceImpl<SysPushNotificationTimingConfigMapper, SysPushNotificationTimingConfig>
   implements SysPushNotificationTimingConfigService {
}
