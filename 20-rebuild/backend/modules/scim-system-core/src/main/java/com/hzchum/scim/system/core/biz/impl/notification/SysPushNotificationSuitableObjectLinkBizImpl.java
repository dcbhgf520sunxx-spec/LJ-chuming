package com.hzchum.scim.system.core.biz.impl.notification;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.notification.SysPushNotificationSuitableObjectLinkBiz;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationSuitableObjectLink;
import com.hzchum.scim.system.core.api.service.notification.SysPushNotificationSuitableObjectLinkService;
import com.hzchum.scim.system.core.mapper.notification.SysPushNotificationSuitableObjectLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class SysPushNotificationSuitableObjectLinkBizImpl
   extends IBizImpl<SysPushNotificationSuitableObjectLinkService, SysPushNotificationSuitableObjectLinkMapper, SysPushNotificationSuitableObjectLink>
   implements SysPushNotificationSuitableObjectLinkBiz {
}
