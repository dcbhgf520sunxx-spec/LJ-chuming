package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskNeedMachinePartSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingTaskNeedMachinePartSchedulingDTO;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNeedMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskNeedMachinePartSchedulingMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTaskNeedMachinePartSchedulingBizImpl
   extends IBizImpl<MesBuildingTaskNeedMachinePartSchedulingService, MesBuildingTaskNeedMachinePartSchedulingMapper, MesBuildingTaskNeedMachinePartScheduling>
   implements MesBuildingTaskNeedMachinePartSchedulingBiz {
   @Override
   public List<MesBuildingTaskNeedMachinePartSchedulingDTO> getNeedDetailByIds(List<Long> ids) {
      return this.baseService
         .getNeedDetailByIds(ids)
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingTaskNeedMachinePartSchedulingDTO.class))
         .collect(Collectors.toList());
   }
}
