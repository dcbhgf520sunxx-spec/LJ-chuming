package com.hzchum.scim.mes.building.core.api.service.process;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskProcessDTO;
import java.util.List;

public interface MesBuildingProcessService extends IService<MesBuildingProcess> {
   List<MesBuildingProcess> listByCondition(Boolean type, Integer taskTypeEnum, Long userId);

   List<MesBuildingProcess> listByCondition2(Boolean type, Integer taskTypeEnum, Long userId);

   List<MesBuildingProcessDTO> getWorkshopByProcessList(Long workshopId);

   List<AppTaskProcessDTO> listAssistDetail(
      List<Long> assIstIds, Integer taskTypeEnum, Long taskId, Long projectId, Long monomerId, Long areaId, Long areaBatchId, String serialNumber
   );

   List<AppTaskProcessDTO> listAssistDetail2(
      List<Long> assIstIds,
      Integer taskTypeEnum,
      Long taskId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      String serialNumber
   );
}
