package com.hzchum.scim.system.core.api.biz.notification;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushFlowConfig;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationServiceTriggerDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushFlowConfigDetailDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushFlowConfigDetailSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushFlowConfigSimpleDTO;
import java.util.List;

public interface SysPushFlowConfigBiz extends IBiz<SysPushFlowConfig> {
   List<SysPushFlowConfigSimpleDTO> getPushFlowSimpleList(Boolean status, Integer notificationTypeEnum, String name);

   Boolean editFlow(SysPushFlowConfigDetailSaveDTOParam sysPushFlowConfigDetailSaveDTOParam);

   Boolean deleteFlow(Long id);

   SysPushFlowConfigDetailDTO getPushFlowDetail(Long id);

   Boolean editStatus(Long id);

   void triggerFlow(NotificationServiceTriggerDTO notificationServiceTriggerDTO);
}
