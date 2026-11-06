package com.hzchum.scim.mes.building.core.api.biz.scheduling;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingAreaScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.AreaSchedulingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.AssembleDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MachinePartDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProjectSchedulingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProjectSchedulingTreeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProjectSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.SchedulingDataSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.productionLineInformationDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingAreaSchedulingDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ComponentCrderInformationDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.building.ProductMetesDTO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface MesBuildingAreaSchedulingBiz extends IBiz<MesBuildingAreaScheduling> {
   List<ProjectSchedulingDTO> getProjectScheduling(
      LocalDateTime dateTime, Integer status, LocalDateTime endDate, List<LocalDateTime> endTimeList, List<Long> projectIds
   );

   PageVO<ProjectSchedulingDTO> getProjectSchedulingPage(
      LocalDateTime dateTime,
      Integer status,
      LocalDateTime endDate,
      Integer projectType,
      Integer lumpSumSystemType,
      Integer pageNumber,
      Integer pageSize,
      Integer month,
      Long projectId,
      Integer level
   );

   List<AreaSchedulingDTO> getAreaSchedulingList(Integer projectId, Integer projectType);

   PageVO<AreaSchedulingDTO> getAreaSchedulingPage(Integer projectId, Integer projectType, Integer pageNumber, Integer pageSize);

   Boolean updateAreaScheduling(List<MesBuildingAreaSchedulingDTOParam> dtoParamList);

   ProductMetesDTO getSumMeteByCondition(Long projectId);

   List<ArtifactDTO> getArtifactList(String classificationName, String material, Long projectId);

   List<AssembleDTO> getAssembleList(String classificationName, String material, Long projectId);

   List<MachinePartDTO> getMachinePartList(String classificationName, String material, String specification, Boolean boolHaveHole, Long projectId);

   List<ComponentCrderInformationDTO> getComponentsDetailed(Integer productType, Long projectId);

   List<productionLineInformationDTO> productionLineInformation(Long projectId, Long factoryId);

   PrintVO<List<Map<String, Object>>> printArtifactByCondition(String classificationName, String material, Long projectId);

   PrintVO<List<Map<String, Object>>> printAssembleByCondition(String classificationName, String material, Long projectId);

   PrintVO<List<Map<String, Object>>> printMachinePartByCondition(
      String classificationName, String material, String specification, Boolean boolHaveHole, Long projectId
   );

   ProjectSummaryDTO getProjectSchedulingSummay(
      LocalDateTime dateTime, Integer status, LocalDateTime endDate, Integer month, Long projectId, Integer projectType, Integer lumpSumSystemType
   );

   List<String> getSchedulingTime(Integer projectType, Integer lumpSumSystemType, Long workshopId, Integer level);

   List<ProjectSchedulingTreeDTO> getScheduling(LocalDateTime dateTime, Integer projectType, Integer lumpSumSystemType, Long workshopId, Integer level);

   List<ProjectSchedulingTreeDTO> getProjectScheduling(LocalDateTime dateTime, Integer projectType, Integer lumpSumSystemType, Long workshopId, Integer level);

   List<WorkshopDetailDO> getSchedulingWorkshop(Integer projectType, Integer lumpSumSystemType, Integer level);

   SchedulingDataSummaryDTO getSchedulingDataSummary(Long factoryId, Long workshopId, LocalDateTime dateTime, Integer level);
}
