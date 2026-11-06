package com.hzchum.scim.mes.building.core.api.biz.projectKanban;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.dto.ProjectProductInfoDTO;
import com.hzchum.scim.common.core.api.pojo.dto.ProjectsTreeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProgressDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectKanBanDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectProductTaskSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectStatusSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProcessProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskTrackingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskTrackingProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.ProjectSummaryDTOParam;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface ProjectKanbanBiz {
   ProjectKanBanDTO projectSummary(ProjectSummaryDTOParam dtoParam);

   List<ProjectSimpleInfoDTO> projectSummaryYear(LocalDateTime date, Integer status, String name, List<Long> projectIds, Integer projectType);

   PageVO<ProjectSimpleInfoDTO> projectSummaryYearPage(
      LocalDateTime date, Integer status, String name, Integer pageNumber, Integer pageSize, Integer projectType, Integer lumpSumSystemType
   );

   List<TaskTrackingProcessDTO> processSummary(
      Long projectId,
      Long monomerId,
      Long areaId,
      LocalDateTime dateTime,
      Long productionLineId,
      Integer productType,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long workshopId
   );

   List<TaskTrackingProductDTO> processSummaryDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productionLineId,
      String serialNumber,
      Integer taskType,
      Long processId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer status
   );

   PageVO<TaskTrackingProductDTO> processSummaryDetailPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      LocalDateTime dateTime,
      Long workshopId,
      Long productionLineId,
      String serialNumber,
      Integer productType,
      Long processId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer status,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> processSummaryDetailPrint(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productionLineId,
      String serialNumber,
      Integer productType,
      Long processId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer status
   );

   List<TaskProcessProductDTO> groupTaskDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long productId,
      Long productionLineId,
      Integer taskType,
      Long processId,
      LocalDateTime startDate,
      LocalDateTime endDate
   );

   PageVO<TaskProcessProductDTO> groupTaskDetailPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long productId,
      Long productionLineId,
      Integer productType,
      Long processId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer pageNumber,
      Integer pageSize
   );

   List<NameInfo> findHasTaskWorkShop();

   List<ProjectsTreeDTO> getProjectKanbanTrees(Long workshopId, Integer status, LocalDateTime dateTime);

   ProjectStatusSummaryDTO getProjectStatusSummary(Long workshopId, LocalDateTime dateTime);

   ProjectProductTaskSummaryDTO getProductTaskSummary(List<Long> areaIds);

   PageVO<ProjectProductInfoDTO> findProjectProductProcessInfos(
      List<Long> areaIds, Long monmerId, Long areaId, Long classId, String serialNumber, Integer pageNumber, Integer pageSize
   );

   ProgressDetailDTO findProductProcessDetails(Long productId, Long processId, Long classId, String serialNumber, Integer taskTypeEnum, Integer type);
}
