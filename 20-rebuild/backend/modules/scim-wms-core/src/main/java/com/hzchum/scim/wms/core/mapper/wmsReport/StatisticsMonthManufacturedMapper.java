package com.hzchum.scim.wms.core.mapper.wmsReport;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsMonthManufactured;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsMonthManufacturedCountDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryStatisticsMonthManufacturedDTOParam;
import java.util.List;

public interface StatisticsMonthManufacturedMapper extends BaseMapper<StatisticsMonthManufactured> {
   List<StatisticsMonthManufactured> list(QueryStatisticsMonthManufacturedDTOParam param);

   StatisticsMonthManufacturedCountDTO statisticsCount(QueryStatisticsMonthManufacturedDTOParam param);
}
