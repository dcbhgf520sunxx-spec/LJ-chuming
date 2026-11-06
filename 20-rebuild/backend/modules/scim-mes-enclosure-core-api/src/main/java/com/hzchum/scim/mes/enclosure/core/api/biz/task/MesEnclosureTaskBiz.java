package com.hzchum.scim.mes.enclosure.core.api.biz.task;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.EnclosurePrint;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTask;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.CategoryProduceAnalysisDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.PlateProduceAnalysisDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.TeamProduceDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.TeamProduceDetailDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.WorkshopMonthAndMeteDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.WorkshopSummaryDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report.ProduceTeamReportDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.AppEnclosureTaskDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.MesEnclosureTaskOrderDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.ProjectTreeResponseDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.TechEnclosureDetailDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.app.AppTaskOrderSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanAreaDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosurePlanDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProductDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProjectOverviewStateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProjectProduceStateDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface MesEnclosureTaskBiz extends IBiz<MesEnclosureTask> {
   List<ProjectTreeResponseDTO> getProjecTrees(Integer projectType, Integer lumpSumSystemType);

   PageVO<AppTaskOrderSummaryDTO> taskOrderPage(
      Long projectId, Long planId, String orderNumber, Integer projectType, Integer lumpSumSystemType, Integer pageNumber, Integer pageSize
   );

   PageVO<AppTaskOrderSummaryDTO> taskOrderPageV2(Long projectId, Long areaId, String orderNumber, Integer pageNumber, Integer pageSize);

   List<AppTaskOrderSummaryDTO> taskOrder(Long projectId, Long planId, String orderNumber, Integer projectType, Integer lumpSumSystemType);

   PageVO<AppEnclosureTaskDTO> pageProductTaskByTaskOrderId(
      Long projectId, Long planId, String serialNumber, Long taskOrderId, Integer projectType, Integer lumpSumSystemType, Integer pageNumber, Integer pageSize
   );

   PageVO<AppEnclosureTaskDTO> pageProductTaskByTaskOrderIdV2(
      Long projectId, Long areaId, String serialNumber, Long taskOrderId, Integer pageNumber, Integer pageSize
   );

   Boolean report(Long taskId, Integer quantity);

   Boolean reportV2(Long taskId, Integer quantity);

   PageVO<ProduceTeamReportDTO> reportRecords(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long projectId,
      String serialNumber,
      Integer projectType,
      Integer lumpSumSystemType,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<ProduceTeamReportDTO> reportRecordsV2(
      LocalDateTime startDate, LocalDateTime endDate, Long projectId, String serialNumber, Integer pageNumber, Integer pageSize
   );

   Map<String, BigDecimal> reportTotal(
      LocalDateTime startDate, LocalDateTime endDate, Long projectId, String serialNumber, Integer projectType, Integer lumpSumSystemType
   );

   Map<String, BigDecimal> reportTotalV2(LocalDateTime startDate, LocalDateTime endDate, Long projectId, String serialNumber);

   List<EnclosureProjectProduceStateDTO> getProjectProduce(Integer year, Integer state, String name, Integer projectType, Integer lumpSumSystemType);

   PageVO<MesEnclosureTaskOrderDTO> getOrders(String orderNumber, Long projectId, String userName, Integer pageNumber, Integer pageSize);

   PageVO<TechEnclosureDetailDTO> orderDetail(Long id);

   PageVO<TechEnclosureDetailDTO> orderDetailV2(Long id);

   PrintVO<List<Map<String, Object>>> orderDetailPrint(Long id);

   PrintVO<List<Map<String, Object>>> orderDetailPrintV2(Long id);

   List<EnclosureProjectOverviewStateDTO> getProjectOverview(Integer year, Integer state, String name, Integer projectType, Integer lumpSumSystemType);

   List<Integer> getProjectCategory(Long projectId);

   Map<Long, String> getProjectCategoryV2(Long projectId, List<Long> areaIds);

   List<EnclosurePlanDTO> getPlan(Long projectId, Integer category);

   List<PlanAreaDTO> getArea(Long projectId, Long dictionaryId);

   PageVO<EnclosureProductDetailDTO> getproductDetaile(List<Long> planIds, Integer status, Integer category, Integer pageNumber, Integer pageSize);

   PageVO<EnclosureProductDetailDTO> getproductDetaileV2(List<Long> areaIds, Integer status, Long dictionaryId, Integer pageNumber, Integer pageSize);

   Map getproductTotal(Long projectId, List<Long> planIds, Integer category);

   Map getProductTotalV2(Long projectId, List<Long> areaIds, Long dictionaryId);

   List<WorkshopMonthAndMeteDTO> getYearList(LocalDateTime dateTime, Integer type, Integer category);

   List<WorkshopMonthAndMeteDTO> getYearListV2(LocalDateTime dateTime, Integer type, Integer dictionaryId);

   PageVO<WorkshopSummaryDTO> getOverviewDetail(
      LocalDateTime startTime, LocalDateTime endTime, Long projectId, Integer category, Integer pageNumber, Integer pageSize
   );

   PageVO<WorkshopSummaryDTO> getOverviewDetailV2(
      LocalDateTime startTime, LocalDateTime endTime, Long projectId, Long dictionaryId, Integer pageNumber, Integer pageSize
   );

   BigDecimal getOverviewTotal(LocalDateTime time, Integer category);

   BigDecimal getOverviewTotalV2(LocalDateTime time, Integer dictionaryId);

   PrintVO<List<Map<String, Object>>> getOverviewDetailPrint(LocalDateTime startTime, LocalDateTime endTime, Long projectId, Integer category);

   PrintVO<List<Map<String, Object>>> getOverviewDetailPrintV2(LocalDateTime startTime, LocalDateTime endTime, Long projectId, Long dictionaryId);

   PageVO<TeamProduceDTO> getTeamProduce(
      LocalDateTime startTime,
      LocalDateTime endTime,
      Long projectId,
      LocalDateTime category,
      Integer projectType,
      Integer lumpSumSystemType,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> getTeamProducePrint(
      LocalDateTime startTime, LocalDateTime endTime, Long projectId, LocalDateTime category, Integer projectType, Integer lumpSumSystemType
   );

   PageVO<TeamProduceDetailDTO> getTeamProduceDetail(
      LocalDateTime startTime,
      LocalDateTime endTime,
      BigDecimal price,
      Long projectId,
      Long teamId,
      Long lineId,
      LocalDateTime category,
      Integer projectType,
      Integer lumpSumSystemType,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> getTeamProduceDetailPrint(
      LocalDateTime startTime,
      LocalDateTime endTime,
      BigDecimal price,
      Long projectId,
      Long teamId,
      Long lineId,
      LocalDateTime category,
      Integer projectType,
      Integer lumpSumSystemType
   );

   List<CategoryProduceAnalysisDTO> produceAnalysis(LocalDateTime startTime, LocalDateTime endTime, Long projectId);

   List<PlateProduceAnalysisDTO> plateAnalysis(LocalDateTime startTime, LocalDateTime endTime, Long projectId, Integer category);

   Map<Long, String> listHasTaskProductionLineId(Long projectId, Long planId, Integer category);

   PageVO listEnclosurePrint(
      Long projectId,
      Long planId,
      Integer category,
      Long lineId,
      String name,
      String serialNumber,
      String specification,
      String material,
      Integer warehousingStatusEnum,
      Integer pageNumber,
      Integer pageSize
   );

   Boolean savePrint(Long taskId, Integer quantity);

   List<EnclosurePrint> getPrint(Long taskId);

   AppEnclosureTaskDTO taskByTaskId(Long id);
}
