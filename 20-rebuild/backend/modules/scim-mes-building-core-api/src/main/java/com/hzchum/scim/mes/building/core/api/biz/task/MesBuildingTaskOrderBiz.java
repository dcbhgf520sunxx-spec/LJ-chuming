package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingCutConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingArtifactTaskOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingMachineTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingMachineTaskOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingNumberLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingNumberTaskOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingProductNumbersDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskOrderTrackingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistTaskOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingTaskOrderDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectTreeResponseVO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;

public interface MesBuildingTaskOrderBiz extends IBiz<MesBuildingTaskOrder> {
   Boolean saveArtifactTaskOrder(MesBuildingTaskOrderDTOParam dtoParam, MesBuildingMachinePartSchedulingDTOParam dtoParamOld);

   @Transactional(rollbackFor = Exception.class)
   Boolean saveArtifactTaskOrder2(MesBuildingTaskOrderDTOParam dtoParam);

   Boolean saveTaskOrderList(MesBuildingTaskOrderDTOParam dtoParam, MesBuildingMachinePartSchedulingDTOParam dtoParamOld);

   @Transactional(rollbackFor = Exception.class)
   Boolean saveTaskOrderList2(MesBuildingTaskOrderDTOParam dtoParam);

   List<MesBuildingTaskOrderDTO> getTaskOrderList(MesBuildingTaskOrderDTOParam dtoParam);

   PageVO<MesBuildingTaskOrderDTO> getTaskOrderPage(MesBuildingTaskOrderDTOParam dtoParam, Integer pageNumber, Integer pageSize);

   List<MesBuildingArtifactTaskOrderDTO> getArtifactsTaskList(
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      Integer productType,
      Boolean printType,
      Long workshopId,
      LocalDateTime localDateTime,
      String orderNumber,
      LocalDateTime startDate,
      LocalDateTime endDate
   );

   PageVO<MesBuildingArtifactTaskOrderDTO> getArtifactsTaskPage(
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
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<TaskOrderTrackingDTO> taskTrackMachinePartPage(
      LocalDateTime dateTime,
      Long workshopId,
      Long productionLineId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer taskType,
      Integer status,
      String orderNumber,
      Integer pageNumber,
      Integer pageSize
   );

   List<TaskOrderTrackingDTO> taskTrackMachinePart(
      LocalDateTime dateTime,
      Long workshopId,
      Long productionLineId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer productType,
      Integer status,
      String orderNumber
   );

   PageVO<TaskOrderTrackingDTO> taskTrackArtifactPage(
      LocalDateTime dateTime,
      Long workshopId,
      Long productionLineId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer taskType,
      Integer status,
      String orderNumber,
      Integer pageNumber,
      Integer pageSize
   );

   List<TaskOrderTrackingDTO> taskTrackArtifact(
      LocalDateTime dateTime,
      Long workshopId,
      Long productionLineId,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer productType,
      Integer status,
      String orderNumber
   );

   PageVO<MesBuildingMachineTaskOrderDTO> getMachinePartTaskPage(
      Integer boolNestCut,
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      String serialNumber,
      Integer processType,
      Boolean printType,
      Long workshopId,
      LocalDateTime localDateTime,
      String cutNumber,
      Long cutConfigId,
      Integer pageNumber,
      Integer pageSize
   );

   List<MesBuildingMachineTaskOrderDTO> getMachinePartTaskList(
      Integer boolNestCut,
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      String serialNumber,
      Integer processType,
      List<Long> processIds,
      Boolean printType,
      Long workshopId,
      LocalDateTime localDateTime,
      String orderNumber,
      Long cutConfigId
   );

   void getMachinePartNesting(Long orderId);

   List<MesBuildingMachineTaskDTO> getMachinePartDrilling(Long cutId, Integer processType);

   PageVO getMachinePartDrillingPage(Long cutId, Integer processType, Integer pageNumber, Integer pageSize);

   Integer cunRows(Integer TaskTypeEnum, Long topTaskOrderId);

   PrintVO<List<Map<String, Object>>> getMachinePartDrillingPrint(Long cutId, Integer processType);

   List<TaskOrderTrackingDTO> taskDull();

   PageVO<TaskOrderTrackingDTO> taskDullPage(Integer pageNumber, Integer pageSize);

   List<MesBuildingAssistTaskOrderDTO> getTaskOrderAssistList(Long topTaskOrderId);

   List<ProjectTreeResponseVO> getArtifactsTaskProjectList(LocalDateTime localDateTime, String serialNumber);

   List<ProjectTreeResponseVO> getArtifactsTaskProjectListV2(LocalDate localDateTime, String serialNumber, Long workshopId);

   List<ProjectTreeResponseVO> getMachinePartTaskprojectList(LocalDateTime localDateTime, String serialNumber, Integer processType);

   void saveMachinePartSeparate(Long taskOrder);

   void saveMachinePartSeparate2(Long id);

   void saveNestCutMachinePartSeparate(Long taskOrderId, Long nestCutId);

   void saveNestCutMachinePartSeparate2(Long taskOrderId, Long nestCutId);

   List<MesBuildingCutConfigDTO> getMachinePartCutConfig(List<Long> projectIds, List<Long> monomerIds, List<Long> areaIds, Integer processType);

   List<MesBuildingTask> getArtListByAssTask(Long taskId);

   List<MesBuildingTask> getArtListByPartTask(Long taskId);

   List<MesBuildingNumberTaskOrderDTO> listNumberOrders(Long projectId, Long monomerId, Long areaId, Integer taskType, String serialNumber);

   List<MesBuildingProductNumbersDTO> listProductNumbers(Long orderId, Long productId, Integer number);

   List<MesBuildingNumberLinkDTO> linknumbers(List<NumberInfoDTO> numbers);
}
