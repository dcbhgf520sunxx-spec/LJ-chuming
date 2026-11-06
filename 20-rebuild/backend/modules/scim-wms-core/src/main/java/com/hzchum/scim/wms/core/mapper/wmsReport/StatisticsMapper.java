package com.hzchum.scim.wms.core.mapper.wmsReport;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryStatisticsDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatisticsMapper extends BaseMapper<Statistics> {
   Statistics get(MaterialInventory materialInventory);

   List<Statistics> getIdByMap(
      @Param("classifyId") String classifyId,
      @Param("thickness") String thickness,
      @Param("specs") String specs,
      @Param("brand") String brand,
      @Param("color") String color,
      @Param("HN") String HN,
      @Param("workshopId") String workshopId,
      @Param("standard") String standard,
      @Param("boolPartyA") String boolPartyA,
      @Param("projectId") String projectId
   );

   List<StatisticsDTO> getListById(QueryStatisticsDTOParam param);

   List<StatisticsDTO> getList(QueryStatisticsDTOParam param);
}
