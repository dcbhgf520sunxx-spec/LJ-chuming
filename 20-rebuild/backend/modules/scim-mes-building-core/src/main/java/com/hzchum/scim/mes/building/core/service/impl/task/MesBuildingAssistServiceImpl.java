package com.hzchum.scim.mes.building.core.service.impl.task;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskAssistDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskOrderSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistProjectDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.MesBuildingProductProcessDTOParam;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingAssistMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingAssistServiceImpl extends ServiceImpl<MesBuildingAssistMapper, MesBuildingAssist> implements MesBuildingAssistService {
   @Override
   public List<MesBuildingTaskAssistDTO> listAssistByTaskIds(List<Long> taskIds) {
      return this.baseMapper.listAssistByTaskIds(taskIds);
   }

   @Override
   public List<MesBuildingAssistProjectDTO> findProcessReportProjectList(Long processId, String projectName, Long userId) {
      return this.baseMapper.findProcessReportProjectList(processId, projectName, userId);
   }

   @Override
   public List<AppTaskOrderSummaryDTO> findAssistCorrelationOrder(Long processId, List<Long> groupsId) {
      return this.baseMapper.findAssistCorrelationOrder(processId, groupsId);
   }

   @Override
   public List<AppTaskOrderSummaryDTO> findAssistCorrelationOrderV2(Long processId, List<Long> producLineIds, List<Long> projectIds, Integer taskTypeEnum) {
      return this.baseMapper.findAssistCorrelationOrderV2(processId, producLineIds, projectIds, taskTypeEnum);
   }

   @Override
   public List<MesBuildingAssistOrderDTO> findAssistByUserIds(Long processId, Long userId) {
      return this.baseMapper.findAssistByUserIds(processId, userId);
   }

   @Override
   public List<MesBuildingAssistProjectDTO> findProcessReportProjectListAV2(Long processId, String projectName, Long userId, Integer taskTypeEnum) {
      return this.baseMapper.findProcessReportProjectListAV2(processId, projectName, userId, taskTypeEnum);
   }

   @Override
   public List<MesBuildingAssist> findAssistProcessByProductPorcess(MesBuildingProductProcessDTOParam dtoParam, List<Long> processIds) {
      return this.baseMapper.findAssistProcessByProductPorcess(dtoParam, processIds);
   }
}
