package com.hzchum.scim.system.core.mapper.notification;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationRecord;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushAppDetailsDTO;
import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPushNotificationRecordMapper extends BaseMapper<SysPushNotificationRecord> {
   List<SysPushAppDetailsDTO> getRecodeDetail(
      @Param("operationalModuleType") Integer operationalModuleType,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate,
      @Param("content") String content,
      @Param("userId") Long userId
   );
}
