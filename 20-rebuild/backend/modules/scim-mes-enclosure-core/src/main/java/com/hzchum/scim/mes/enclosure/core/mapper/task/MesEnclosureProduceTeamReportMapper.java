package com.hzchum.scim.mes.enclosure.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.report.ProduceAbonrmalReportDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.report.ProduceInspectionTeamReportDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.report.ProduceTeamReportDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.report.ReportSourceDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.report.YearMeteDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.task.MesEnclosureArtifactTaskProcessDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages.DistributionDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages.DistributionProcessDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages.OutStaffDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages.ReckonPriceDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages.ReckonPriceTeamDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureProduceTeamReport;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.wages.OutStaffDOParam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.wages.PriceDOParam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.wages.get.PriceDetailsDOParam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.CategoryProduceAnalysisDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.PlateProduceAnalysisDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.TeamProduceDetailDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report.ArtifactReportSourceDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report.AssembleReportSourceDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report.MesEnclosureProduceTeamReportDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report.ProduceTeamReportDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report.ProductTeamSummaryDetailDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report.productTeamSummaryDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.MesEnclosureReportNumberStatusDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.wages.PriceDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.TechEnclosureDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesEnclosureProduceTeamReportMapper extends BaseMapper<MesEnclosureProduceTeamReport> {
   List<ProduceTeamReportDO> listByCondition(
      @Param("date") String date,
      @Param("taskId") Long taskId,
      @Param("productId") Long productId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("teamId") Long teamId,
      @Param("reportType") Integer reportType,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("planId") Long planId,
      @Param("workshopId") Long workshopId,
      @Param("productLineId") Long productLineId,
      @Param("factoryId") Long factoryId,
      @Param("serialNumber") String serialNumber
   );

   List<ProduceAbonrmalReportDO> reportList(
      @Param("productId") Long productId,
      @Param("productType") Integer productType,
      @Param("taskId") Long taskId,
      @Param("processIdList") List<Long> processIdList
   );

   DistributionDO getComplete(PriceDTOParam copy);

   List<OutStaffDO> outStaffWageList(OutStaffDOParam doParam);

   List<ReckonPriceTeamDO> getTeamMate(PriceDOParam doParam);

   List<ReckonPriceDetailDO> getTeamMateDetails(PriceDetailsDOParam copy);

   List<DistributionProcessDO> getProcessPrice(PriceDOParam copy);

   BigDecimal getProcessPriceSummary(PriceDOParam copy);

   List<ReportSourceDO> reportSourceList(@Param("id") Long id, @Param("prodcutType") Integer prodcutType);

   List<MesEnclosureArtifactTaskProcessDO> artifactTaskList(
      @Param("previousTaskProcessId") Long previousTaskProcessId, @Param("taskProcessId") Long taskProcessId, @Param("number") Long number
   );

   List<MesEnclosureArtifactTaskProcessDO> artifactTaskLogList(
      @Param("previousTaskProcessId") Long previousTaskProcessId, @Param("taskProcessId") Long taskProcessId, @Param("number") Long number
   );

   List<MesEnclosureArtifactTaskProcessDO> artifactInspectionTaskList(
      @Param("taskProcessId") Long taskProcessId, @Param("number") Long number, @Param("teamId") Long teamId
   );

   List<MesEnclosureReportNumberStatusDTO> artifactNumberStatusList(
      @Param("productId") Long productId, @Param("taskId") Long taskId, @Param("taskTypeEnum") Integer taskTypeEnum, @Param("planId") Long planId
   );

   List<ProduceTeamReportDO> listByConditionBydate(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("taskId") Long taskId,
      @Param("productId") Long productId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("teamId") Long teamId,
      @Param("reportType") Integer reportType,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("planId") Long planId,
      @Param("workshopId") Long workshopId,
      @Param("productLineId") Long productLineId,
      @Param("factoryId") Long factoryId,
      @Param("serialNumber") String serialNumber
   );

   List<ProduceInspectionTeamReportDO> inspectionListByConditionByDate(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("taskId") Long taskId,
      @Param("productId") Long productId,
      @Param("teamId") Long teamId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("boolAdoptEnum") Boolean boolAdoptEnum,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("planId") Long planId,
      @Param("workshopId") Long workshopId,
      @Param("productLineId") Long productLineId,
      @Param("factoryId") Long factoryId,
      @Param("serialNumber") String serialNumber
   );

   List<ProduceTeamReportDTO> teamReportMachinePartList(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("processType") Integer processType,
      @Param("serialNumber") String serialNumber,
      @Param("projectId") Long projectId,
      @Param("cutId") Long cutId
   );

   List<ArtifactReportSourceDTO> artifactSourceReportProductList(@Param("productId") Long productId, @Param("number") Integer number);

   List<YearMeteDO> getMeteByYear(
      @Param("dateTime") LocalDateTime dateTime, @Param("processTypeEnum") Integer processTypeEnum, @Param("projectId") Long projectId
   );

   List<productTeamSummaryDTO> productTeamSummaryReport(
      @Param("workshopId") Long workshopId,
      @Param("processId") Long processId,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<ProductTeamSummaryDetailDTO> productTeamSummaryReportDetailList(
      @Param("workshopId") Long workshopId,
      @Param("groupsId") Long groupsId,
      @Param("teamId") Long teamId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<AssembleReportSourceDTO> assembleSourceReportProductList(Long productId);

   List<ProduceTeamReportDTO> listRecords(
      @Param("projectId") Long projectId,
      @Param("serialNumber") String serialNumber,
      @Param("projectIds") List<Long> projectIds,
      @Param("teamIds") List<Long> teamIds,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<ProduceTeamReportDTO> listRecordsV2(
      @Param("projectId") Long projectId,
      @Param("serialNumber") String serialNumber,
      @Param("projectIds") List<Long> projectIds,
      @Param("teamIds") List<Long> teamIds,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<TeamProduceDetailDTO> listDetail(
      @Param("startTime") LocalDateTime startTime,
      @Param("endTime") LocalDateTime endTime,
      @Param("price") BigDecimal price,
      @Param("projectId") Long projectId,
      @Param("teamId") Long teamId,
      @Param("lineId") Long lineId,
      @Param("projectIds") List<Long> projectIds,
      @Param("category") LocalDateTime category
   );

   List<CategoryProduceAnalysisDTO> produceAnalysis(
      @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime, @Param("projectId") Long projectId
   );

   List<PlateProduceAnalysisDTO> plateAnalysis(
      @Param("startTime") LocalDateTime startTime,
      @Param("endTime") LocalDateTime endTime,
      @Param("projectId") Long projectId,
      @Param("category") Integer category
   );

   List<MesEnclosureProduceTeamReportDTO> findEnclosureReport(Long orderId, List<Long> taskIds);

   List<TechEnclosureDTO> findFreezeEnclosure(Long orderId, List<Long> taskIds);
}
