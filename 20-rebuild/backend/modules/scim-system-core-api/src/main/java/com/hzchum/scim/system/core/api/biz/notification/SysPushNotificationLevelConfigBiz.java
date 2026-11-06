package com.hzchum.scim.system.core.api.biz.notification;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationLevelConfig;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationLevelConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationLevelConfigSaveDTOParam;
import java.util.List;

public interface SysPushNotificationLevelConfigBiz extends IBiz<SysPushNotificationLevelConfig> {
   Boolean saveConfig(List<NotificationLevelConfigSaveDTOParam> params);

   List<NotificationLevelConfigDTO> getConfig();

   String numberToLetter(int number);
}
