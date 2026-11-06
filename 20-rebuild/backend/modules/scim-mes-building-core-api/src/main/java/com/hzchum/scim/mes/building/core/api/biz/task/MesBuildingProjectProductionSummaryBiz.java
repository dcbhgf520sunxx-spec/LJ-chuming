package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProjectProductionSummary;
import java.time.LocalDateTime;
import org.springframework.transaction.annotation.Transactional;

public interface MesBuildingProjectProductionSummaryBiz extends IBiz<MesBuildingProjectProductionSummary> {
   Boolean updateProjectMeteSummary(Long taskId, Long taskProcessId, Integer quantity, LocalDateTime dateTime);

   @Transactional(rollbackFor = Exception.class)
   Boolean revokeProjectMeteSummary(Long taskId, Long taskProcessId, Integer quantity, LocalDateTime dateTime);
}
