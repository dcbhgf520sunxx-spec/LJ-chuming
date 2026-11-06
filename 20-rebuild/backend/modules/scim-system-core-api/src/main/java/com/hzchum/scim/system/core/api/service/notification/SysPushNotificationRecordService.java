package com.hzchum.scim.system.core.api.service.notification;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationRecord;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushAppDetailsDTO;
import java.time.LocalDate;
import java.util.List;

public interface SysPushNotificationRecordService extends IService<SysPushNotificationRecord> {
   List<SysPushAppDetailsDTO> getRecodeDetail(Integer operationalModuleType, LocalDate startDate, LocalDate endDate, String content, Long user);
}
