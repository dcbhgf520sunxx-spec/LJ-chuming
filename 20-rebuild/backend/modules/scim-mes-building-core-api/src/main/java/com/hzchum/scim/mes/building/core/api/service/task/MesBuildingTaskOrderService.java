package com.hzchum.scim.mes.building.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
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
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingTaskOrderService extends IService<MesBuildingTaskOrder> {
   List<MesBuildingTaskOrderDO> getTaskOrderList(MesBuildingTaskOrderDOParam doParam);

   List<MesBuildingArtifactTaskOrderDO> getArtifactsTaskList(
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
   );

   List<MesBuildingArtifactTaskOrderDO> getAllArtifactsTaskList(
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
   );

   List<TaskOrderTrackingDO> taskTrackMachinePart(
      LocalDateTime dateTime, Long workshopId, Long productionLineId, List<Long> partIds, Integer taskType, Integer status, String orderNumber
   );

   List<TaskOrderTrackingDO> taskTrackArtifact(
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
   );

   List<MesBuildingMachineTaskOrderDTO> getMachinePartTaskList(
      Long projectId, Integer processType, Boolean printType, Long workshopId, LocalDateTime localDateTime, String orderNumber
   );

   List<MesBuildingMachineTaskDTO> getMachinePartDetail(Long orderId);

   List<MesBuildingMachineTaskDTO> getMachinePartDrilling(Long cutId, Integer processType);

   String getMachinePartNesting(Long orderId);

   List<Long> getAllids(Long cutId, Integer processType);

   Integer cunRows(Integer taskTypeEnum, Long topTaskOrderId);

   List<MesBuildingAssistTaskOrderDO> getTaskOrderAssistList(Long topTaskOrderId);

   List<MesBuildingMachineTaskDTO> getMachinePartOffLine(Long cutId);

   List<MesBuildingMachineTaskDTO> getMachinePartOffLineDrill(Long cutId, Long monomerId, Long areaId);

   List<MesBuildingMachineTaskDTO> getMachinePartOffLineAuto(Long cutId, Long monomerId, Long areaId);

   List<ProductIdAndProcessDO> listBoolenProcess(List<Long> productIds);

   List<MesBuildingTaskOrder> findOrderByUser(Long processId, Long userId);

   List<ProductIdAndProcessDO> listBoolenProcessBase(List<Long> productIds);

   List<MesBuildingOrderIdAndQuantityDTO> boolOrderComplete(List<Long> artOrderIds);
}
