package com.hzchum.scim.system.core.service.impl.notification;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationSuitableObjectLink;
import com.hzchum.scim.system.core.api.service.notification.SysPushNotificationSuitableObjectLinkService;
import com.hzchum.scim.system.core.mapper.notification.SysPushNotificationSuitableObjectLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class SysPushNotificationSuitableObjectLinkServiceImpl
   extends ServiceImpl<SysPushNotificationSuitableObjectLinkMapper, SysPushNotificationSuitableObjectLink>
   implements SysPushNotificationSuitableObjectLinkService {
}
