package com.hzchum.scim.mes.building.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskAssistDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskOrderSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.UserLinkGroupProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.UserLinkLineProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistProjectDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.MesBuildingProductProcessDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingAssistMapper extends BaseMapper<MesBuildingAssist> {
   List<MesBuildingAssist> listUserLinkAssIst(
      @Param("taskId") Long taskId, @Param("links") List<UserLinkGroupProcessDTO> links, @Param("taskTypeEnum") Integer taskTypeEnum
   );

   List<MesBuildingTaskAssistDTO> listAssistByTaskIds(@Param("taskIds") List<Long> taskIds);

   List<MesBuildingAssistProjectDTO> findProcessReportProjectList(
      @Param("processId") Long processId, @Param("projectName") String projectName, @Param("userId") Long userId
   );

   List<AppTaskOrderSummaryDTO> findAssistCorrelationOrder(@Param("processId") Long processId, @Param("groupsId") List<Long> groupsId);

   List<MesBuildingAssistOrderDTO> findAssistByUserIds(@Param("processId") Long processId, @Param("userId") Long userId);

   List<MesBuildingAssist> listUserLinkAssIst2(
      @Param("taskId") Long taskId, @Param("lineProcessLinks") List<UserLinkLineProcessDTO> lineProcessLinks, @Param("taskTypeEnum") Integer taskTypeEnum
   );

   List<AppTaskOrderSummaryDTO> findAssistCorrelationOrderV2(
      @Param("processId") Long processId,
      @Param("producLineIds") List<Long> producLineIds,
      @Param("projectIds") List<Long> projectIds,
      @Param("taskTypeEnum") Integer taskTypeEnum
   );

   List<MesBuildingAssistProjectDTO> findProcessReportProjectListAV2(
      @Param("processId") Long processId, @Param("projectName") String projectName, @Param("userId") Long userId, @Param("taskTypeEnum") Integer taskTypeEnum
   );

   List<MesBuildingAssist> findAssistProcessByProductPorcess(
      @Param("dtoParam") MesBuildingProductProcessDTOParam dtoParam, @Param("processIds") List<Long> processIds
   );
}
