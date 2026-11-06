package com.hzchum.scim.mes.building.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingTaskOrderDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingArtifactTaskOrderDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.ProjectResponseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskOrderTrackingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.topTaskOrder.MesBuildingAssistTaskOrderDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductIdAndProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroupsTeamLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.MesBuildingTaskOrderDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange.MesBuildingOrderIdAndQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingMachineTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingMachineTaskOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.QuantityAndMeteDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingTaskOrderMapper extends BaseMapper<MesBuildingTaskOrder> {
   List<MesBuildingTaskOrderDO> getTaskOrderList(MesBuildingTaskOrderDOParam doParam);

   List<MesBuildingArtifactTaskOrderDO> getArtifactsTaskList(
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerIds") List<Long> monomerIds,
      @Param("areaIds") List<Long> areaIds,
      @Param("areaBatchIds") List<Long> areaBatchIds,
      @Param("serialNumber") String serialNumber,
      @Param("taskType") Integer taskType,
      @Param("printType") Boolean printType,
      @Param("workshopId") Long workshopId,
      @Param("localDateTime") LocalDateTime localDateTime,
      @Param("orderNumber") String orderNumber,
      @Param("assembleIds") List<Long> assembleIds,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<MesBuildingArtifactTaskOrderDO> getAllArtifactsTaskList(
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerIds") List<Long> monomerIds,
      @Param("areaIds") List<Long> areaIds,
      @Param("areaBatchIds") List<Long> areaBatchIds,
      @Param("serialNumber") String serialNumber,
      @Param("printType") Boolean printType,
      @Param("workshopId") Long workshopId,
      @Param("localDateTime") LocalDateTime localDateTime,
      @Param("orderNumber") String orderNumber,
      @Param("assembleIds") List<Long> assembleIds,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<ProjectResponseDTO> getTaskProjectList(
      @Param("projectIds") List<Long> projectIds, @Param("workshopId") Long workshopId, @Param("monthDate") LocalDate monthDate
   );

   List<TaskOrderTrackingDO> taskTrackMachinePart(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("workshopId") Long workshopId,
      @Param("productionLineId") Long productionLineId,
      @Param("partIds") List<Long> partIds,
      @Param("taskType") Integer taskType,
      @Param("status") Integer status,
      @Param("orderNumber") String orderNumber
   );

   List<TaskOrderTrackingDO> taskTrackArtifact(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("workshopId") Long workshopId,
      @Param("productionLineId") Long productionLineId,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("taskType") Integer taskType,
      @Param("status") Integer status,
      @Param("orderNumber") String orderNumber
   );

   List<MesBuildingMachineTaskOrderDTO> getMachinePartTaskList(
      @Param("projectId") Long projectId,
      @Param("processType") Integer processType,
      @Param("printType") Boolean printType,
      @Param("workshopId") Long workshopId,
      @Param("localDateTime") LocalDateTime localDateTime,
      @Param("orderNumber") String orderNumber
   );

   List<MesBuildingMachineTaskDTO> getMachinePartDetail(@Param("orderId") Long orderId);

   List<MesBuildingMachineTaskDTO> getMachinePartDrilling(@Param("cutId") Long cutId, @Param("processType") Integer processType);

   String getMachinePartNesting(@Param("orderId") Long orderId);

   List<Long> getAllids(@Param("cutId") Long cutId, @Param("processType") Integer processType);

   Integer cunRows(@Param("taskTypeEnum") Integer taskTypeEnum, @Param("topTaskOrderId") Long topTaskOrderId);

   List<QuantityAndMeteDTO> selectByCutId(@Param("cutId") List<Long> cutId, @Param("type") int type);

   List<MesBuildingAssistTaskOrderDO> getTaskOrderAssistList(@Param("topTaskOrderId") Long topTaskOrderId);

   List<MesBuildingMachineTaskDTO> getMachinePartOffLine(@Param("cutId") Long cutId);

   List<MesBuildingMachineTaskDTO> getMachinePartOffLineDrill(@Param("cutId") Long cutId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId);

   List<MesBuildingMachineTaskDTO> getMachinePartOffLineAuto(@Param("cutId") Long cutId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId);

   int getNumber(@Param("type") Integer type, @Param("now") LocalDateTime now);

   List<ProductIdAndProcessDO> listBoolenProcess(@Param("productIds") List<Long> productIds);

   List<MesBuildingTask> getArtListByAssTask(@Param("taskId") Long taskId);

   List<MesBuildingTask> getArtListByPartTask(@Param("taskId") Long taskId);

   int getNumber(@Param("type") Integer type);

   List<MesBuildingTaskOrder> findOrderByUser(@Param("processId") Long processId, @Param("userId") Long userId);

   List<ProductIdAndProcessDO> listBoolenProcessBase(@Param("productIds") List<Long> productIds);

   List<Long> listAareaIds(@Param("projectIds") List<Long> projectIds);

   List<MesBuildingOrderIdAndQuantityDTO> boolOrderComplete(@Param("oderIds") List<Long> oderIds);

   Long getTeamIdForMesBuildingTaskNeedMachinePartScheduling(MesBuildingGroupsTeamLink mesBuildingGroupsTeamLink);
}
