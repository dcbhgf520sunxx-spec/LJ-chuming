package com.hzchum.scim.mes.building.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.change.MesBuildingChangeDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.change.MesBuildingChangeDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.change.MesBuildingTaskChangeDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.change.MesBuildingTaskOrderChangeDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrderChange;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingTaskOrderChangeService extends IService<MesBuildingTaskOrderChange> {
   List<MesBuildingTaskOrderChangeDO> getTaskOrderList(Long projectId, Integer taskTypeEnum, LocalDateTime dateTime);

   List<MesBuildingTaskChangeDO> getTaskOrderDetailsList(Long taskOrderId, Integer taskTypeEnum, Long areaId, String serialNumber, String specification);

   List<MesBuildingChangeDO> getChangeList(Integer taskTypeEnum, String userName);

   List<MesBuildingChangeDetailsDO> getChangeDetailsList(Integer taskTypeEnum, Long changeId);
}
