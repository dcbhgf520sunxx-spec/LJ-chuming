package com.hzchum.scim.mes.building.core.api.biz.util;

import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskProcessLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.ProjectPainingPriceDTO;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface MesBuildingUtilsBiz {
   Boolean checkFactoryAndWorkshopAndProductionLineAndProcessIsExist(
      Long factoryId, Long workshopId, Long productionLineId, Long processId, Integer productionLineTypeEnum, Integer teamEnum
   );

   Boolean checkSchedulingQuantity(Long productId, Integer productType, Integer schedulingQuantity);

   Boolean checkSchedulingQuantity(Long id, Integer schedulingQuantity);

   Long selectProductProcessIdByProductIdAndType(Long productId, Integer productType);

   Long getProductProcessIdByClassificationIdAndType(Long classificationId, Integer productType, Long productLineId);

   List<MesBuildingTeam> selectTeamIdByUserId(Long userid);

   List<MesBuildingInspectionTeam> selectInspectionTeamIdByUserId(Long userid);

   MesBuildingScheduling checkSchedulingStatus(Long id);

   MesBuildingTask checkTaskStatus(Long id);

   MesBuildingTask checkTaskAbnormalStatus(Long id);

   Boolean checkInspectionTeam(Long groupsId, Long processId);

   Boolean checkProductLineTeam2(Long productProcessId, Long lineId, Long teamId, Long processId);

   List<MesBuildingTeam> getTeamByProductionLineIdAndProcessIdAndUserId(Long productionLineId, Long processId, Long userId, List<Long> ids);

   MesBuildingInspectionTeam getInspectionTeamBygroupsIdAndProcessIdAndUserId(Long groupsId, Long processId, Long userId);

   MesBuildingInspectionTeam getInspectionTeamByLineIdAndProcessIdAndUserId(Long lineId, Long processId, Long userId, Boolean teamType);

   String longListToString(List<Long> list);

   Boolean checkMachinePartProcess();

   Boolean checkQuantity(Integer productType, Long productId, Integer quantity);

   List<MesBuildingProcess> getProcessByProduct(Long id, Integer productType, Boolean asc);

   List<MesBuildingProcess> getProcessIdByClassificationId(Long id, Integer productType);

   List<MesBuildingProcess> getProcessIdByProductProcessId(Long productProcessId);

   List<MesBuildingProcess> getProcessListByConfigIdAndTaskTypeEnum(Long configId, Integer taskTypeEnum);

   Map<Long, LocalDateTime> getTaskProcessTime(Long productProcessId, LocalDateTime askCompleteDateTime);

   Boolean getBoolDrillProcess(Long id);

   List<Long> getProjectIds();

   Boolean checkProductAbnormalstatus(Integer productType, Long productId);

   Map<Integer, Integer> listEnclosureMeasureMode(Long id);

   Boolean checkProductStatus(Integer productType, Long productId);

   Boolean getBoolOneCode(Long artifactId);

   Boolean getAssBoolOneCode(Long assembleId, Long taskId);

   Map<Long, Boolean> getBoolBatchCode(List<Long> artifactIds);

   Map<String, BigDecimal> getMeteByYear(LocalDateTime dateTime, Integer processTypeEnum);

   Map<String, BigDecimal> getMeteByYearV2(LocalDateTime dateTime, Integer processTypeEnum, Long branchCompanyId, Long workshopId);

   Map<String, BigDecimal> getMeteByYear(LocalDateTime dateTime, Integer processTypeEnum, Long projectId);

   List<ProjectPainingPriceDTO> getProjectPaintingPrice(LocalDateTime dateTime);

   Boolean getBoolSinglePartArtifactPaint(TechArtifact artifact, Long productLineId);

   Boolean getBoolSinglePartArtifactPaintV2(
      TechArtifact artifact,
      Map<String, MesBuildingProductProcess> productProcessMap,
      Map<Long, List<MesBuildingProductProcessLink>> productProcessLinkMap,
      List<MesBuildingProcess> processes,
      Long productionLineId
   );

   Map<Long, List<MesBuildingTaskProcessLinkDTO>> getProductLinkProcesses(List<Long> proudProcessLink);

   Boolean checkBatchClassIdOrProcessIdsOrTeamIds(List<Long> classIds, Integer productType, List<Long> processIds, List<Long> teamIds, Long lineId);
}
