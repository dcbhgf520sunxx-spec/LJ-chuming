package com.hzchum.scim.system.core.service.impl.notification;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationConfig;
import com.hzchum.scim.system.core.api.service.notification.SysPushNotificationConfigService;
import com.hzchum.scim.system.core.mapper.notification.SysPushNotificationConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class SysPushNotificationConfigServiceImpl
   extends ServiceImpl<SysPushNotificationConfigMapper, SysPushNotificationConfig>
   implements SysPushNotificationConfigService {
}
