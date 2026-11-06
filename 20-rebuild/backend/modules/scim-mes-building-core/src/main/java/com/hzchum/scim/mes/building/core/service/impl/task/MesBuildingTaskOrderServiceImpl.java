package com.hzchum.scim.mes.building.core.service.impl.task;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingTaskOrderDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingArtifactTaskOrderDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskOrderTrackingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.topTaskOrder.MesBuildingAssistTaskOrderDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductIdAndProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.MesBuildingTaskOrderDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange.MesBuildingOrderIdAndQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingMachineTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingMachineTaskOrderDTO;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskOrderMapper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTaskOrderServiceImpl extends ServiceImpl<MesBuildingTaskOrderMapper, MesBuildingTaskOrder> implements MesBuildingTaskOrderService {
   @Override
   public List<MesBuildingTaskOrderDO> getTaskOrderList(MesBuildingTaskOrderDOParam doParam) {
      return this.baseMapper.getTaskOrderList(doParam);
   }

   @Override
   public List<MesBuildingArtifactTaskOrderDO> getArtifactsTaskList(
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      List<Long> areaBatchIds,
      String serialNumber,
      Integer taskType,
      Boolean printType,
      Long workshopId,
      LocalDateTime localDateTime,
      String orderNumber,
      List<Long> assembleIds,
      LocalDateTime startDate,
      LocalDateTime endDate
   ) {
      return this.baseMapper
         .getArtifactsTaskList(
            projectIds,
            monomerIds,
            areaIds,
            areaBatchIds,
            serialNumber,
            taskType,
            printType,
            workshopId,
            localDateTime,
            orderNumber,
            assembleIds,
            startDate,
            endDate
         );
   }

   @Override
   public List<MesBuildingArtifactTaskOrderDO> getAllArtifactsTaskList(
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      List<Long> areaBatchIds,
      String serialNumber,
      Boolean printType,
      Long workshopId,
      LocalDateTime localDateTime,
      String orderNumber,
      List<Long> assembleIds,
      LocalDateTime startDate,
      LocalDateTime endDate
   ) {
      List<MesBuildingArtifactTaskOrderDO> allArtifactsTaskList = new ArrayList<>();
      List<MesBuildingArtifactTaskOrderDO> artifactTaskList = this.baseMapper
         .getArtifactsTaskList(
            projectIds,
            monomerIds,
            areaIds,
            areaBatchIds,
            serialNumber,
            TaskTypeEnum.ARTIFACT.getType(),
            printType,
            workshopId,
            localDateTime,
            orderNumber,
            assembleIds,
            startDate,
            endDate
         );
      List<MesBuildingArtifactTaskOrderDO> assembleTaskList = this.baseMapper
         .getArtifactsTaskList(
            projectIds,
            monomerIds,
            areaIds,
            areaBatchIds,
            serialNumber,
            TaskTypeEnum.ASSEMBLE.getType(),
            printType,
            workshopId,
            localDateTime,
            orderNumber,
            assembleIds,
            startDate,
            endDate
         );
      allArtifactsTaskList.addAll(artifactTaskList);
      allArtifactsTaskList.addAll(assembleTaskList);
      return allArtifactsTaskList;
   }

   @Override
   public List<TaskOrderTrackingDO> taskTrackMachinePart(
      LocalDateTime dateTime, Long workshopId, Long productionLineId, List<Long> partIds, Integer taskType, Integer status, String orderNumber
   ) {
      return this.baseMapper.taskTrackMachinePart(dateTime, workshopId, productionLineId, partIds, taskType, status, orderNumber);
   }

   @Override
   public List<TaskOrderTrackingDO> taskTrackArtifact(
      LocalDateTime dateTime,
      Long workshopId,
      Long productionLineId,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer taskType,
      Integer status,
      String orderNumber
   ) {
      return this.baseMapper
         .taskTrackArtifact(dateTime, workshopId, productionLineId, projectIds, monomerId, areaId, areaBatchId, taskType, status, orderNumber);
   }

   @Override
   public List<MesBuildingMachineTaskOrderDTO> getMachinePartTaskList(
      Long projectId, Integer processType, Boolean printType, Long workshopId, LocalDateTime localDateTime, String orderNumber
   ) {
      return this.baseMapper.getMachinePartTaskList(projectId, processType, printType, workshopId, localDateTime, orderNumber);
   }

   @Override
   public List<MesBuildingMachineTaskDTO> getMachinePartDetail(Long orderId) {
      return this.baseMapper.getMachinePartDetail(orderId);
   }

   @Override
   public List<MesBuildingMachineTaskDTO> getMachinePartDrilling(Long cutId, Integer processType) {
      return this.baseMapper.getMachinePartDrilling(cutId, processType);
   }

   @Override
   public String getMachinePartNesting(Long orderId) {
      return this.baseMapper.getMachinePartNesting(orderId);
   }

   @Override
   public List<Long> getAllids(Long cutId, Integer processType) {
      return this.baseMapper.getAllids(cutId, processType);
   }

   @Override
   public Integer cunRows(Integer taskTypeEnum, Long topTaskOrderId) {
      return this.baseMapper.cunRows(taskTypeEnum, topTaskOrderId);
   }

   @Override
   public List<MesBuildingAssistTaskOrderDO> getTaskOrderAssistList(Long topTaskOrderId) {
      return this.baseMapper.getTaskOrderAssistList(topTaskOrderId);
   }

   @Override
   public List<MesBuildingMachineTaskDTO> getMachinePartOffLine(Long cutId) {
      return this.baseMapper.getMachinePartOffLine(cutId);
   }

   @Override
   public List<MesBuildingMachineTaskDTO> getMachinePartOffLineDrill(Long cutId, Long monomerId, Long areaId) {
      return this.baseMapper.getMachinePartOffLineDrill(cutId, monomerId, areaId);
   }

   @Override
   public List<MesBuildingMachineTaskDTO> getMachinePartOffLineAuto(Long cutId, Long monomerId, Long areaId) {
      return this.baseMapper.getMachinePartOffLineAuto(cutId, monomerId, areaId);
   }

   @Override
   public List<ProductIdAndProcessDO> listBoolenProcess(List<Long> productIds) {
      return this.baseMapper.listBoolenProcess(productIds);
   }

   @Override
   public List<MesBuildingTaskOrder> findOrderByUser(Long processId, Long userId) {
      return this.baseMapper.findOrderByUser(processId, userId);
   }

   @Override
   public List<ProductIdAndProcessDO> listBoolenProcessBase(List<Long> productIds) {
      return this.baseMapper.listBoolenProcessBase(productIds);
   }

   @Override
   public List<MesBuildingOrderIdAndQuantityDTO> boolOrderComplete(List<Long> oderIds) {
      return this.baseMapper.boolOrderComplete(oderIds);
   }
}
