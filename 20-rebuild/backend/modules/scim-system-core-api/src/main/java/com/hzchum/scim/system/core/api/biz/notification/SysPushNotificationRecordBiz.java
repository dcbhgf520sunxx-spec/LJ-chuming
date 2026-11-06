package com.hzchum.scim.system.core.api.biz.notification;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationRecord;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushNotificationDetailDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushNotificationRecordAppListDTO;
import java.time.LocalDate;
import java.util.List;

public interface SysPushNotificationRecordBiz extends IBiz<SysPushNotificationRecord> {
   List<SysPushNotificationRecordAppListDTO> getAppList();

   Boolean readPushMessage(Long id);

   Boolean readBatchMessage(Integer operationalModuleType, LocalDate startDate, LocalDate endDate, String content);

   PageVO<SysPushNotificationDetailDTO> getAppMessageDetail(
      Integer operationalModuleType, LocalDate startDate, LocalDate endDate, Boolean isRead, String content, Integer pageNumber, Integer pageSize
   );
}
