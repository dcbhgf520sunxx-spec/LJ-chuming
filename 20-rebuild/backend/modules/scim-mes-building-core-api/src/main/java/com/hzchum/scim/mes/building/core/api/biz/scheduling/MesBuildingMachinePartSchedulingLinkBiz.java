package com.hzchum.scim.mes.building.core.api.biz.scheduling;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartSchedulingLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingMachinePartSchedulingLinkDTO;
import java.util.List;

public interface MesBuildingMachinePartSchedulingLinkBiz extends IBiz<MesBuildingMachinePartSchedulingLink> {
   List<MesBuildingMachinePartSchedulingLinkDTO> getMachinePartSchedulingRecordDetails(Long id);
}
