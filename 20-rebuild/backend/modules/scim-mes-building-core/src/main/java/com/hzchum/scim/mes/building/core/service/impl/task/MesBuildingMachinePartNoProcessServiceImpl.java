package com.hzchum.scim.mes.building.core.service.impl.task;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.app.AppTaskOrderSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingMachinePartNoProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPCutTaskProcessPartDetailDTO;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingMachinePartNoProcessService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingMachinePartNoProcessMapper;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingMachinePartNoProcessServiceImpl
   extends ServiceImpl<MesBuildingMachinePartNoProcessMapper, MesBuildingMachinePartNoProcess>
   implements MesBuildingMachinePartNoProcessService {
   @Override
   public Integer getNoProcessCount(LocalDateTime now) {
      return this.baseMapper.getNoProcessCount(now);
   }

   @Override
   public List<AppTaskOrderSummaryDO> getMachinePartNoProcessResult(List<Long> teamIds) {
      return this.baseMapper.getMachinePartNoProcessResult(teamIds);
   }

   @Override
   public List<APPCutTaskProcessPartDetailDTO> taskOrderProcessDetail(Long schedulingId) {
      return this.baseMapper.taskOrderProcessDetail(schedulingId);
   }

   @Override
   public List<APPCutTaskProcessPartDetailDTO> taskOrderProcessSemiAutoDetail(Long schedulingId) {
      return this.baseMapper.taskOrderProcessSemiAutoDetail(schedulingId);
   }
}
