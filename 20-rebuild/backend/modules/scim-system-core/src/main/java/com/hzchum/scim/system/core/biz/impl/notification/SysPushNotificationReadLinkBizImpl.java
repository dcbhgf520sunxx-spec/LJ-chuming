package com.hzchum.scim.system.core.biz.impl.notification;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.notification.SysPushNotificationReadLinkBiz;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationReadLink;
import com.hzchum.scim.system.core.api.service.notification.SysPushNotificationReadLinkService;
import com.hzchum.scim.system.core.mapper.notification.SysPushNotificationReadLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class SysPushNotificationReadLinkBizImpl
   extends IBizImpl<SysPushNotificationReadLinkService, SysPushNotificationReadLinkMapper, SysPushNotificationReadLink>
   implements SysPushNotificationReadLinkBiz {
}
