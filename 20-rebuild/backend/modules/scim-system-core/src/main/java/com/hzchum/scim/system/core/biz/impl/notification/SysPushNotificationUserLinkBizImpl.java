package com.hzchum.scim.system.core.biz.impl.notification;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.notification.SysPushNotificationUserLinkBiz;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationUserLink;
import com.hzchum.scim.system.core.api.service.notification.SysPushNotificationUserLinkService;
import com.hzchum.scim.system.core.mapper.notification.SysPushNotificationUserLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class SysPushNotificationUserLinkBizImpl
   extends IBizImpl<SysPushNotificationUserLinkService, SysPushNotificationUserLinkMapper, SysPushNotificationUserLink>
   implements SysPushNotificationUserLinkBiz {
}
