package com.hzchum.scim.mes.building.core.api.biz.projectKanban;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.MesTeamReportProductStaticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProjectWorkshopDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ClassificationBaseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProcessSummaryDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectKanBanProductProductionStateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectProductionKanBanListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectProductionKanBanNameInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectSignageProductionSumDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.projectProductionDashboardCardDisplayDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.projectProductionDashboardCardDisplayDetailDTO;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface ProductionSignageBiz {
   ProjectSignageProductionSumDTO projectSignageProductionSum(
      Long projectId, Long workShopId, Long productionLineId, Long monomerId, List<Long> areaIds, List<Long> areaBatchIds
   );

   List<ClassificationBaseDTO> projectSignageArtifactClass(
      Long projectId,
      Long workShopId,
      Long productionLineId,
      Long monomerId,
      List<Long> areaIds,
      Integer productType,
      List<Long> areaBatchIds,
      Boolean boolNotIssued
   );

   List<ProjectProductionKanBanNameInfoDTO> projectSignageProcessList(
      Long projectId,
      Long monomerId,
      List<Long> areaIds,
      Long classId,
      Long workshopId,
      Long productionLineId,
      String productSerialNumber,
      List<Long> areaBatchIds,
      String assembleSerialNumber
   );

   PageVO<ProjectProductionKanBanListDTO> projectSignageProcessProductList(
      Long projectId,
      Long workShopId,
      Long productionLineId,
      Long monomerId,
      List<Long> areaIds,
      Long classId,
      String serialNumber,
      Integer productKanBanEnum,
      List<LocalDateTime> dateTimeList,
      List<Long> areaBatchIds,
      String assembleSerialNumber,
      Long processId,
      Integer processStatus,
      Integer pageNumber,
      Integer pageSize
   );

   void projectSignageProcessProductDownload(
      Long projectId,
      Long workShopId,
      Long productionLineId,
      Long monomerId,
      List<Long> areaIds,
      Long classId,
      String serialNumber,
      String assembleSerialNumber,
      Integer productKanBanEnum,
      List<LocalDateTime> dateTimeList,
      Long processId,
      Integer processStatus,
      HttpServletResponse response
   ) throws IOException;

   List<?> projectSignageProcessProductDetailList(Long artifactTaskId, Long processId, Integer productType, Integer processType);

   PageVO<ProjectKanBanProductProductionStateDTO> pageProjectSignageProductProductionStateList(
      Long projectId,
      Long monomerId,
      List<Long> areaIds,
      Long classId,
      String serialNumber,
      Long workShopId,
      Long productionLineId,
      Long processId,
      Integer productClassificationEnum,
      List<LocalDateTime> dateTimeList,
      Integer productType,
      Integer productKanBanCompanyEnum,
      List<Long> areaBatchIds,
      Boolean boolNotIssued,
      Integer pageNumber,
      Integer pageSize
   );

   List<ProjectKanBanProductProductionStateDTO> projectSignageProductProductionStateList(
      Long projectId,
      Long monomerId,
      List<Long> areaIds,
      Long classId,
      String serialNumber,
      Long workShopId,
      Long productionLineId,
      Long processId,
      Integer productClassificationEnum,
      List<LocalDateTime> dateTimeList,
      Integer productType,
      Integer productKanBanCompanyEnum,
      List<Long> areaBatchIds
   );

   List<ProjectProductionKanBanNameInfoDTO> findProjectPartProcessList(
      Long projectId, Integer productType, Long workShopId, Long productionLineId, Long monomerId, List<Long> areaIds, List<Long> areaBatchIds
   );

   PrintVO<List<Map<String, Object>>> printProjectSignageProductProductionStateList(
      Long projectId,
      Long monomerId,
      List<Long> areaIds,
      Long classId,
      String serialNumber,
      Long workShopId,
      Long productionLineId,
      Long processId,
      Integer productClassificationEnum,
      List<LocalDateTime> dateTimeList,
      Integer productType,
      Integer productKanBanCompanyEnum,
      List<Long> areaBatchIds,
      Boolean boolNotIssued
   );

   ListVO<projectProductionDashboardCardDisplayDTO> projectProductionDashboardCardDisplay(
      Long projectId, Long monomerId, Long areaId, String serialNumber, String name, String specification, String material, Integer status, Long areaBatchId
   );

   projectProductionDashboardCardDisplayDetailDTO projectProductionDashboardCardDisplayDetail(Long productId);

   List<ProcessSummaryDetailsDTO> projectProductionDashboardCardDisplayProcessDetail(Long productId, Integer artifactId, Integer productType);

   PageVO<MesTeamReportProductStaticsDTO> pageTeamReportProductList(
      Integer productType,
      Long workShopId,
      Long productionLineId,
      Long teamId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      String serialNumber,
      List<LocalDateTime> dateTimeList,
      Integer pageNumber,
      Integer pageSize
   );

   List<MesTeamReportProductStaticsDTO> getTeamReportProductList(
      Integer productType,
      Long workShopId,
      Long productionLineId,
      Long teamId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      String serialNumber,
      List<LocalDateTime> dateTimeList
   );

   List<MesBuildingProjectWorkshopDTO> getTeamReportProductWorkList(Integer productType);

   PrintVO<List<Map<String, Object>>> printTeamReportProductList(
      Integer productType,
      Long workShopId,
      Long productionLineId,
      Long teamId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      String serialNumber,
      List<LocalDateTime> dateTimeList
   );
}
