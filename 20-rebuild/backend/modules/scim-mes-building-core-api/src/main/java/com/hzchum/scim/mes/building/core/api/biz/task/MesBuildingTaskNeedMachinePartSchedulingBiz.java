package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingTaskNeedMachinePartSchedulingDTO;
import java.util.List;

public interface MesBuildingTaskNeedMachinePartSchedulingBiz extends IBiz<MesBuildingTaskNeedMachinePartScheduling> {
   List<MesBuildingTaskNeedMachinePartSchedulingDTO> getNeedDetailByIds(List<Long> ids);
}
