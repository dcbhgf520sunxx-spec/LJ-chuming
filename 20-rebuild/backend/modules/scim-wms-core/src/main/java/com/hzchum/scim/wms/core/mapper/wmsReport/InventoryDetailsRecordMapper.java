package com.hzchum.scim.wms.core.mapper.wmsReport;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryDetailsRecord;
import java.time.LocalDateTime;
import java.util.List;

public interface InventoryDetailsRecordMapper extends BaseMapper<InventoryDetailsRecord> {
   List<InventoryDetailsRecord> getByTime(String detailKey, LocalDateTime minDate, LocalDateTime maxDate);
}
