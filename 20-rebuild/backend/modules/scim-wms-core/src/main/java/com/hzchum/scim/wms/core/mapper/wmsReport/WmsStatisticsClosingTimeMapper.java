package com.hzchum.scim.wms.core.mapper.wmsReport;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WmsStatisticsClosingTime;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryStatisticsDTOParam;
import java.util.List;

public interface WmsStatisticsClosingTimeMapper extends BaseMapper<WmsStatisticsClosingTime> {
   WmsStatisticsClosingTime get(MaterialInventory materialInventory);

   List<StatisticsDTO> getListById(QueryStatisticsDTOParam param);
}
