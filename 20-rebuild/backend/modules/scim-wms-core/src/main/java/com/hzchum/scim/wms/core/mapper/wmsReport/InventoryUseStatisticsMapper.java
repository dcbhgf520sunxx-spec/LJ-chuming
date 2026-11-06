package com.hzchum.scim.wms.core.mapper.wmsReport;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.InventoryUseConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryUseStatistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryInventoryUseStatisticsDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InventoryUseStatisticsMapper extends BaseMapper<InventoryUseStatistics> {
   List<InventoryUseStatistics> getInventoryUseStatistics(@Param("param") QueryInventoryUseStatisticsDTOParam param);

   List<String> getInventoryUseStatisticsNew(
      @Param("param") QueryInventoryUseStatisticsDTOParam dtoParam, @Param("config") InventoryUseConfig inventoryBasicConf
   );

   InventoryUseStatistics getInventoryUseStatisticsByMaterialInventory(
      @Param("param") MaterialInventory materialInventory, @Param("statisticsDateId") Long statisticsDateId
   );
}
