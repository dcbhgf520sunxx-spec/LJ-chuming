package com.hzchum.scim.mes.building.core.service.impl.process;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskProcessDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.utils.SerialNumberComparatorUtils;
import com.hzchum.scim.mes.building.core.mapper.process.MesBuildingProcessMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class MesBuildingProcessServiceImpl extends ServiceImpl<MesBuildingProcessMapper, MesBuildingProcess> implements MesBuildingProcessService {
   @Autowired
   private MesBuildingTeamService teamService;

   @Override
   public List<MesBuildingProcess> listByCondition(Boolean type, Integer taskTypeEnum, Long userId) {
      return this.baseMapper.listByUserId(type, taskTypeEnum, userId);
   }

   @Override
   public List<MesBuildingProcess> listByCondition2(Boolean type, Integer taskTypeEnum, Long userId) {
      return this.baseMapper.listByUserId2(type, taskTypeEnum, userId);
   }

   @Override
   public List<MesBuildingProcessDTO> getWorkshopByProcessList(Long workshopId) {
      return this.baseMapper.getWorkshopByProcessList(workshopId);
   }

   @Override
   public List<AppTaskProcessDTO> listAssistDetail(
      List<Long> assIstIds, Integer taskTypeEnum, Long taskId, Long projectId, Long monomerId, Long areaId, Long areaBatchId, String serialNumber
   ) {
      List<AppTaskProcessDTO> doList = this.baseMapper
         .listAssistDetail(assIstIds, taskTypeEnum, taskId, projectId, monomerId, areaId, areaBatchId, serialNumber);
      if (CollectionUtils.isNotEmpty(doList)) {
         doList.sort(SerialNumberComparatorUtils.create(AppTaskProcessDTO::getSerialNumber));
      }

      return doList;
   }

   @Override
   public List<AppTaskProcessDTO> listAssistDetail2(
      List<Long> assIstIds,
      Integer taskTypeEnum,
      Long taskId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      String serialNumber
   ) {
      List<AppTaskProcessDTO> doList = this.baseMapper
         .listAssistDetail2(assIstIds, taskTypeEnum, taskId, projectId, monomerId, areaId, processId, areaBatchId, serialNumber);
      if (CollectionUtils.isNotEmpty(doList)) {
         doList.sort(SerialNumberComparatorUtils.create(AppTaskProcessDTO::getSerialNumber));
      }

      return doList;
   }
}
