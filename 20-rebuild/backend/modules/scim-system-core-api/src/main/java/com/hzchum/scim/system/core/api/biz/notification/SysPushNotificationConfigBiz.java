package com.hzchum.scim.system.core.api.biz.notification;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationConfig;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationConfigDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.notification.PushNotificationConfigSimpleDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SuitableObjectCommonDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushNotificationRecordDTOParam;
import java.util.List;

public interface SysPushNotificationConfigBiz extends IBiz<SysPushNotificationConfig> {
   Boolean editNotification(List<NotificationConfigDTOParam> params, Integer notificationType, Integer operationalModuleType);

   Boolean editStatus(Long id);

   List<SuitableObjectCommonDTO> getSuitableObject(Integer suitableObjectTypeEnum);

   List<PushNotificationConfigSimpleDTO> getList(Integer operationalModuleTypeEnum, Boolean isDisposition, Boolean status, Integer notificationModeTypeEnum);

   void businessCompletion(SysPushNotificationRecordDTOParam sysPushNotificationRecordDTOParam, List<Long> userList);
}
