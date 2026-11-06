package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingSchedulingDTOParam;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingSchedulingBiz {
   Boolean saveScheduling(List<MesBuildingSchedulingDTOParam> schedulingDTOParamList, LocalDateTime askCompleteTime, Boolean booleanSaveTask);

   List<MesBuildingScheduling> selectSummaryData(Long id, Long projectId);
}
