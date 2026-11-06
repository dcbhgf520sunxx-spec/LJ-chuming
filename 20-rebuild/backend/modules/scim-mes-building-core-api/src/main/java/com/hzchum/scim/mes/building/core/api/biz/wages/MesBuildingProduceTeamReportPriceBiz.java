package com.hzchum.scim.mes.building.core.api.biz.wages;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProjectPainingPriceDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingProduceTeamReportPrice;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.ProcessPriceDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.ProcessPriceDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.ProductionPriceSummaryDTO;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MesBuildingProduceTeamReportPriceBiz extends IBiz<MesBuildingProduceTeamReportPrice> {
   ProductionPriceSummaryDTO getProductionPriceSummary(LocalDateTime dateTime);

   List<ProcessPriceDTO> getProcessPriceList(LocalDateTime startTime, LocalDateTime endTime, Long workshopId);

   List<ProcessPriceDetailsDTO> getProcessPriceDetailsList(LocalDateTime startTime, LocalDateTime endTime, Long workshopId, Long processId, String userName);

   void exportPriceExcel(
      LocalDateTime startTime,
      LocalDateTime endTime,
      Long workshopId,
      Long processId,
      String userName,
      HttpServletRequest request,
      HttpServletResponse response
   );

   List<ProjectPainingPriceDO> getProjectPaintingPrice(LocalDateTime dateTime);
}
