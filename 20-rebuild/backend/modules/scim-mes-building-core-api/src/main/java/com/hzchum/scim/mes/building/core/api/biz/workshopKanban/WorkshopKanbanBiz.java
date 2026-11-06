package com.hzchum.scim.mes.building.core.api.biz.workshopKanban;

import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TeamTaskCompleteDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TeamTaskCompleteRateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.WorkShopTaskCompleteDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.WorkShopTaskCompleteRateDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface WorkshopKanbanBiz {
   List<WorkShopTaskCompleteRateDTO> getWorkShopTaskPercentageComplete(LocalDateTime date);

   List<TeamTaskCompleteRateDTO> getTeamTaskPercentageComplete(Long workShopId, Long processId, LocalDateTime time);

   List<WorkShopTaskCompleteDetailDTO> findTaskPercentageDetail(LocalDateTime date, Long workShopId);

   List<TeamTaskCompleteDetailDTO> findTeamPercentageDetail(LocalDateTime date, Long workShopId, Long processId, Long teamId);
}
