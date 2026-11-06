package com.hzchum.scim.mes.building.core.mapper.scheduling;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingMachinePartSchedulingLinkDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartSchedulingLink;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingMachinePartSchedulingLinkMapper extends BaseMapper<MesBuildingMachinePartSchedulingLink> {
   List<MesBuildingMachinePartSchedulingLinkDO> getMachinePartSchedulingRecordDetails(@Param("id") Long id);
}
