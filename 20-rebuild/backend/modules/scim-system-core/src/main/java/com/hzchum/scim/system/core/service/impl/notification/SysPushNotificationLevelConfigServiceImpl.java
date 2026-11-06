package com.hzchum.scim.system.core.service.impl.notification;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationLevelConfig;
import com.hzchum.scim.system.core.api.service.notification.SysPushNotificationLevelConfigService;
import com.hzchum.scim.system.core.mapper.notification.SysPushNotificationLevelConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class SysPushNotificationLevelConfigServiceImpl
   extends ServiceImpl<SysPushNotificationLevelConfigMapper, SysPushNotificationLevelConfig>
   implements SysPushNotificationLevelConfigService {
}
