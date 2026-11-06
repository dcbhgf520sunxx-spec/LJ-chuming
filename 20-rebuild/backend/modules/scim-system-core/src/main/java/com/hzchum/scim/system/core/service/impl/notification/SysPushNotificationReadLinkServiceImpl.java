package com.hzchum.scim.system.core.service.impl.notification;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationReadLink;
import com.hzchum.scim.system.core.api.service.notification.SysPushNotificationReadLinkService;
import com.hzchum.scim.system.core.mapper.notification.SysPushNotificationReadLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class SysPushNotificationReadLinkServiceImpl
   extends ServiceImpl<SysPushNotificationReadLinkMapper, SysPushNotificationReadLink>
   implements SysPushNotificationReadLinkService {
}
