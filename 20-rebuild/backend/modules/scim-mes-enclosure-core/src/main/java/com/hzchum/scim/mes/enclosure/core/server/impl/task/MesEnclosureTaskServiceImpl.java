package com.hzchum.scim.mes.enclosure.core.server.impl.task;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTask;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.TaskProductDetailDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.AppEnclosureTaskDTO;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskService;
import com.hzchum.scim.mes.enclosure.core.mapper.task.MesEnclosureTaskMapper;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectProductDTO;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureTaskServiceImpl extends ServiceImpl<MesEnclosureTaskMapper, MesEnclosureTask> implements MesEnclosureTaskService {
   @Override
   public Boolean checkStatus(Long productionLine) {
      return this.baseMapper
         .selectList((Wrapper<MesEnclosureTask>)Wrappers.<MesEnclosureTask>lambdaQuery().eq(MesEnclosureTask::getProductionLineId, productionLine))
         .stream()
         .noneMatch(e -> e.getTaskQuantity().equals(e.getCompleteQuantity()));
   }

   @Override
   public List<TaskProductDetailDTO> listAllProductDetail() {
      return this.baseMapper.listAllProductDetail();
   }

   @Override
   public List<AppEnclosureTaskDTO> listTasks(Long projectId, Long areaId, String serialNumber, Long taskOrderId, List<Long> teamIds, List<Long> projectIds) {
      return this.baseMapper.listTasks(projectId, areaId, serialNumber, taskOrderId, teamIds, projectIds);
   }

   @Override
   public List<AppEnclosureTaskDTO> listTasksV2(Long projectId, Long areaId, String serialNumber, Long taskOrderId, List<Long> teamIds, List<Long> projectIds) {
      return this.baseMapper.listTasksV2(projectId, areaId, serialNumber, taskOrderId, teamIds, projectIds);
   }

   @Override
   public List<MesEnclosureTask> findProductReportCountByOrderId(Long orderId) {
      return this.baseMapper.findProductReportCountByOrderId(orderId);
   }

   @Override
   public List<ProjectProductDTO> getEnclosureTaskDetails(Long areaId, Long processId) {
      return this.baseMapper.getEnclosureTaskDetails(areaId, processId);
   }
}
