package com.hzchum.scim.system.core.service.impl.notification;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationRecord;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushAppDetailsDTO;
import com.hzchum.scim.system.core.api.service.notification.SysPushNotificationRecordService;
import com.hzchum.scim.system.core.mapper.notification.SysPushNotificationRecordMapper;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SysPushNotificationRecordServiceImpl
   extends ServiceImpl<SysPushNotificationRecordMapper, SysPushNotificationRecord>
   implements SysPushNotificationRecordService {
   @Override
   public List<SysPushAppDetailsDTO> getRecodeDetail(Integer operationalModuleType, LocalDate startDate, LocalDate endDate, String content, Long userId) {
      return this.baseMapper.getRecodeDetail(operationalModuleType, startDate, endDate, content, userId);
   }
}
