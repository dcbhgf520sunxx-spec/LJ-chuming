package com.hzchum.scim.wms.core.api.service.wmsReport;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WmsClosingTime;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface WmsClosingTimeService extends IService<WmsClosingTime> {
   Boolean checkBoolWmsClosing();

   Boolean checkInventoryMete(LocalDateTime endTime, Long materialInventoryId, BigDecimal mete);
}
