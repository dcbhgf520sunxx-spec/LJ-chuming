package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.pojo.common.KevMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ArtifactProductionDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ProductionDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ReportWastageDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.SteelReceiveRecordDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.WastageDO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface MainMaterialTrackingBiz {
   Map<String, BigDecimal> summary(Long projectId);

   ListVO<KevMeteDO> artifactRecord(Long projectId, String year);

   ListVO<KevMeteDO> plateRecord(Long projectId, String year);

   PageVO<ArtifactProductionDetailDO> artifactRecordDetail(Long projectId, String month, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> artifactRecordDetailPrint(Long projectId, String month);

   PageVO<Object> plateRecordDetail(Long projectId, String month, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> plateRecordDetailPrint(Long projectId, String month);

   PageVO<WastageDO> wastage(Integer year, Integer status, List<Long> projectIds, List<Long> workShopIds, Integer pageNumber, Integer pageSize);

   void wastageExport(Integer year, Integer status, List<Long> projectIds, List<Long> workShopIds, HttpServletResponse response);

   ReportWastageDO wastageCollect(Integer year, String status, List<Long> projectIds, List<Long> workShopIds);

   PageVO<SteelReceiveRecordDO> steelReceive(Integer year, String status, List<Long> projectIds, List<Long> workShopIds);

   PageVO<ProductionDetailDO> steelProduction(
      Integer year, LocalDateTime startDate, LocalDateTime endDate, Long projectId, Long workShopId, Integer pageNumber, Integer pageSize
   );

   BigDecimal recordTotalWeight(Integer year, LocalDateTime startDate, LocalDateTime endDate, Long projectId, Long workShopId);

   void exportSteelProduction(Integer year, LocalDateTime startDate, LocalDateTime endDate, Long projectId, Long workShopId, HttpServletResponse response);
}
