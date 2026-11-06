package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.scim.mes.building.core.api.pojo._do.report.InspectionReportSourceDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ReportSourceDO;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface MesBuildingProduceTeamReportBiz {
   Boolean savePice(Long id, Integer inspectionQuantity);

   BigDecimal calculatePrice(Long productId, Integer productType, BigDecimal wage, Integer wageQuotaType, Integer quantity);

   List<ReportSourceDO> reportSourceList(Long id, Integer prodcutType);

   List<InspectionReportSourceDO> inspectionReportSourceList(Long id, Integer prodcutType);

   void savePiceByData(Map<Long, Integer> reportMap);
}
