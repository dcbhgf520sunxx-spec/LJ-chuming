package com.hzchum.scim.mes.building.core.mapper.scheduling;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNeedMachinePartScheduling;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingNeedMachinePartSchedulingMapper extends BaseMapper<MesBuildingNeedMachinePartScheduling> {
   List<MesBuildingNeedMachinePartScheduling> listByMonthList(@Param("monthList") List<LocalDateTime> monthList);
}
