package com.hzchum.scim.mes.building.core.service.impl.task;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.change.MesBuildingChangeDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.change.MesBuildingChangeDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.change.MesBuildingTaskChangeDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.change.MesBuildingTaskOrderChangeDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrderChange;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderChangeService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskOrderChangeMapper;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTaskOrderChangeServiceImpl
   extends ServiceImpl<MesBuildingTaskOrderChangeMapper, MesBuildingTaskOrderChange>
   implements MesBuildingTaskOrderChangeService {
   @Override
   public List<MesBuildingTaskOrderChangeDO> getTaskOrderList(Long projectId, Integer taskTypeEnum, LocalDateTime dateTime) {
      return this.baseMapper.getTaskOrderList(projectId, taskTypeEnum, dateTime);
   }

   @Override
   public List<MesBuildingTaskChangeDO> getTaskOrderDetailsList(Long taskOrderId, Integer taskTypeEnum, Long areaId, String serialNumber, String specification) {
      return this.baseMapper.getTaskOrderDetailsList(taskOrderId, taskTypeEnum, areaId, serialNumber, specification);
   }

   @Override
   public List<MesBuildingChangeDO> getChangeList(Integer taskTypeEnum, String userName) {
      return this.baseMapper.getChangeList(taskTypeEnum, userName);
   }

   @Override
   public List<MesBuildingChangeDetailsDO> getChangeDetailsList(Integer taskTypeEnum, Long changeId) {
      return this.baseMapper.getChangeDetailsList(taskTypeEnum, changeId);
   }
}
