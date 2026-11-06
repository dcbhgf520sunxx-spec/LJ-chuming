package com.hzchum.scim.wms.core.api.service.wmsReport;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsMonthManufactured;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsMonthManufacturedCountDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsMonthManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryStatisticsMonthManufacturedDTOParam;
import java.time.LocalDateTime;
import java.util.List;

public interface StatisticsMonthManufacturedService extends IService<StatisticsMonthManufactured> {
   void manufacturedStatistics(LocalDateTime now);

   List<StatisticsMonthManufacturedDTO> statistics(QueryStatisticsMonthManufacturedDTOParam param);

   StatisticsMonthManufacturedCountDTO statisticsCount(QueryStatisticsMonthManufacturedDTOParam param);
}
