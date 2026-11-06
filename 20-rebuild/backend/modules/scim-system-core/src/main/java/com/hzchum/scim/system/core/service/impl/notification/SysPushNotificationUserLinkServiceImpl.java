package com.hzchum.scim.system.core.service.impl.notification;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationUserLink;
import com.hzchum.scim.system.core.api.service.notification.SysPushNotificationUserLinkService;
import com.hzchum.scim.system.core.mapper.notification.SysPushNotificationUserLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class SysPushNotificationUserLinkServiceImpl
   extends ServiceImpl<SysPushNotificationUserLinkMapper, SysPushNotificationUserLink>
   implements SysPushNotificationUserLinkService {
}
