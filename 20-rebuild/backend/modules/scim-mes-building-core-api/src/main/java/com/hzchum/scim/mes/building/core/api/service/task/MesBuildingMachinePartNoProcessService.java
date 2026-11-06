package com.hzchum.scim.mes.building.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.app.AppTaskOrderSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingMachinePartNoProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPCutTaskProcessPartDetailDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingMachinePartNoProcessService extends IService<MesBuildingMachinePartNoProcess> {
   Integer getNoProcessCount(LocalDateTime now);

   List<AppTaskOrderSummaryDO> getMachinePartNoProcessResult(List<Long> teamIds);

   List<APPCutTaskProcessPartDetailDTO> taskOrderProcessDetail(Long schedulingId);

   List<APPCutTaskProcessPartDetailDTO> taskOrderProcessSemiAutoDetail(Long schedulingId);
}
