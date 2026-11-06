package com.hzchum.scim.wms.core.api.service.wmsReport;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryUseStatistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryUseStatisticsDate;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InventoryUseRecordDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InventoryUseStatisticsDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InventoryUseStatisticsMergeDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryInventoryUseStatisticsDTOParam;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface InventoryUseStatisticsService extends IService<InventoryUseStatistics> {
   List<InventoryUseStatisticsDate> getTimeList();

   PageVO<InventoryUseStatisticsDTO> getInventoryUseStatistics(
      QueryInventoryUseStatisticsDTOParam dtoParam, Integer pageNumber, Integer pageSize, List<String> sort
   );

   PageVO<InventoryUseStatisticsMergeDTO> getInventoryUseStatisticsNew(
      QueryInventoryUseStatisticsDTOParam dtoParam, Integer pageNumber, Integer pageSize, List<String> sort
   );

   List<InventoryUseStatisticsMergeDTO> convertMergeDTO(List<String> idStr, Boolean boolBalance);

   Boolean weighting(Boolean boolMonth, LocalDateTime endTime, String name);

   List<InventoryUseRecordDTO> getUseRecordByStatisticsId(Long id, Integer formType);

   List<InventoryUseRecordDTO> getUseRecordByStatisticsNew(List<Long> ids, Integer formType);

   InventoryUseStatistics getInventoryUseStatisticsByMaterialInventory(MaterialInventory materialInventory, Long statisticsDateId);

   Map<String, String> getSteelCount(QueryInventoryUseStatisticsDTOParam dtoParam);
}
