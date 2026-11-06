package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.scheduling.MesBuildingArtifactSchedulingParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.SchedulingArtifactDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.SchedulingArtifactSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.AssNumberArtNumberLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.InspectionReportSavedDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.LastProcessInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.TeamScheduledSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.ProductClassificationDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.BatchInspectDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.BatchPrintDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.BatchReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingProduceTeamReportDTOParam;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;

public interface MesBuildingNewTaskBiz extends IBiz<MesBuildingTask> {
   @Transactional(rollbackFor = Exception.class)
   Boolean saveProduceTeamReportSummary2(MesBuildingTaskProcess taskProcess, Integer reportQuantity, Long assistLineId, Long teamId, Integer type);

   Boolean saveProduceTeamReportSummaryV3(
      MesBuildingTaskProcess taskProcess, Integer reportQuantity, Long assistLineId, Long teamId, Integer type, Long reportPersonId
   );

   @Transactional(rollbackFor = Exception.class)
   List<Integer> saveProduceTeamReport2(MesBuildingProduceTeamReportDTOParam dtoParam);

   List<Integer> manualReportSaveProduceTeamReport(MesBuildingProduceTeamReportDTOParam dtoParam);

   @Transactional(rollbackFor = Exception.class)
   Boolean addPartTaskProcess2(MesBuildingTask task, MesBuildingProductionLine prodLines, LocalDateTime drillAskCompleteTime);

   List<ProductClassificationDTO> productTypeByTaskOrderId2(Integer taskTypeEnum, Long taskOrderId, Integer boolLastProcessEnum);

   @Transactional(rollbackFor = Exception.class)
   Boolean saveProduceInspection2(List<InspectionReportSavedDTO> inspectData);

   List<LastProcessInfoDTO> lastProcessInfo(Long id);

   TeamScheduledSummaryDTO findAssembleScheduledSummary(Long workshopId, Long projectId);

   List<AssNumberArtNumberLinkDTO> getAssembleNumberLink(Integer assId, List<Integer> assembleNumbers);

   List<BatchPrintDTO> saveProduceTeamBatchReport(List<BatchReportDTO> dtos);

   Boolean saveBatchProduceInspection(List<BatchInspectDTO> dtos);

   void saveBatchProduceInspection2List(
      List<InspectionReportSavedDTO> inspectDataList,
      Map<Long, MesBuildingTaskProcess> taskProcessMap,
      Map<Long, List<MesBuildingProduceTeamReport>> produceTeamReportMap,
      Map<Long, MesBuildingTask> taskMap
   );

   @Transactional(rollbackFor = Exception.class)
   Boolean revokeTaskPocess(Long id);

   PageVO<SchedulingArtifactSummaryDTO> findSchedulingArtifactSummary(Long projectId, Long monomerId, Integer pageNum, Integer pageSize);

   PageVO<SchedulingArtifactDetailDTO> findSchedulingArtifactDetail(MesBuildingArtifactSchedulingParam param, Integer pageNum, Integer pageSize);
}
