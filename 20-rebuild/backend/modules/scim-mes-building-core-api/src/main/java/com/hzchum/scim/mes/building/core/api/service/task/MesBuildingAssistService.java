package com.hzchum.scim.mes.building.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskAssistDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskOrderSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistProjectDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.MesBuildingProductProcessDTOParam;
import java.util.List;

public interface MesBuildingAssistService extends IService<MesBuildingAssist> {
   List<MesBuildingTaskAssistDTO> listAssistByTaskIds(List<Long> taskIds);

   List<MesBuildingAssistProjectDTO> findProcessReportProjectList(Long processId, String projectName, Long userId);

   List<AppTaskOrderSummaryDTO> findAssistCorrelationOrder(Long processId, List<Long> groupsId);

   List<AppTaskOrderSummaryDTO> findAssistCorrelationOrderV2(Long processId, List<Long> producLineIds, List<Long> projectIds, Integer taskTypeEnum);

   List<MesBuildingAssistOrderDTO> findAssistByUserIds(Long processId, Long userId);

   List<MesBuildingAssistProjectDTO> findProcessReportProjectListAV2(Long processId, String projectName, Long id, Integer taskTypeEnum);

   List<MesBuildingAssist> findAssistProcessByProductPorcess(MesBuildingProductProcessDTOParam dtoParam, List<Long> processIds);
}
