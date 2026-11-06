package com.hzchum.scim.mes.building.core.api.service.scheduling;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingMachinePartSchedulingLinkDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartSchedulingLink;
import java.util.List;

public interface MesBuildingMachinePartSchedulingLinkService extends IService<MesBuildingMachinePartSchedulingLink> {
   List<MesBuildingMachinePartSchedulingLinkDO> getMachinePartSchedulingRecordDetails(Long id);
}
