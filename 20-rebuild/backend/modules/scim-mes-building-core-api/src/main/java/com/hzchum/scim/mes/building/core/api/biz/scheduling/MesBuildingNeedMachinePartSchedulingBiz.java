package com.hzchum.scim.mes.building.core.api.biz.scheduling;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNeedMachinePartScheduling;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingNeedMachinePartSchedulingBiz extends IBiz<MesBuildingNeedMachinePartScheduling> {
   List<MesBuildingNeedMachinePartScheduling> listByMonthList(List<LocalDateTime> monthList);
}
