package com.hzchum.scim.wms.core.mapper.wmsReport;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsMonthRecord;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryStatisticsDTOParam;
import java.util.List;

public interface StatisticsMonthRecordMapper extends BaseMapper<StatisticsMonthRecord> {
   List<StatisticsDTO> getListById(QueryStatisticsDTOParam param);
}
