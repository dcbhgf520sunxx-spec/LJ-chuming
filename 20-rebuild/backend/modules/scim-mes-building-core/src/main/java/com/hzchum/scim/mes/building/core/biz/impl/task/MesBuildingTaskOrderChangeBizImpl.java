package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNestCutPlateBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingMachinePartSchedulingArtifactTaskLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskNeedMachinePartSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderChangeBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderChangeDetailsBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTopTaskOrderBiz;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingCutConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroups;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingArtifactScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingMachinePartSchedulingArtifactTaskLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrderChange;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrderChangeDetails;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTopTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.GroupDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.ProductLineDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange.MesBuildingProductBoolChangeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.change.MesBuildingChangeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.change.MesBuildingChangeDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.change.MesBuildingLineChangeListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.change.MesBuildingOrderProductDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.change.MesBuildingTaskChangeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.change.MesBuildingTaskCollaborativeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.change.MesBuildingTaskOrderChangeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.post.TaskChangeDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingCutConfigService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingArtifactSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderChangeDetailsService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderChangeService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskOrderChangeMapper;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskOrderMapper;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleExtService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingTaskOrderChangeBizImpl
   extends IBizImpl<MesBuildingTaskOrderChangeService, MesBuildingTaskOrderChangeMapper, MesBuildingTaskOrderChange>
   implements MesBuildingTaskOrderChangeBiz {
   @Autowired
   private MesBuildingTaskOrderBiz taskOrderBiz;
   @Autowired
   private MesBuildingTopTaskOrderBiz topTaskOrderBiz;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesBuildingTaskNeedMachinePartSchedulingBiz taskNeedMachinePartSchedulingBiz;
   @Autowired
   private MesBuildingMachinePartSchedulingArtifactTaskLinkBiz machinePartSchedulingArtifactTaskLinkBiz;
   @Autowired
   private MesBuildingGroupsBiz groupsBiz;
   @Autowired
   private MesBuildingTaskOrderChangeDetailsBiz changeDetailsBiz;
   @Autowired
   private MesBuildingTaskOrderChangeDetailsService changeDetailsService;
   @Autowired
   private MesBuildingNestCutPlateBiz nestCutPlateBiz;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesBuildingTaskNumberLinkService numberLinkService;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Autowired
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Autowired
   private TechArtifactMachinePartLinkService artPartLinkService;
   @Autowired
   private TechAssembleMachinePartLinkService assPartLinkService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private PlanAreaService areaService;
   @Autowired
   private PlanMonomerService monomerService;
   @Autowired
   private UserService userService;
   @Autowired
   private MesBuildingCutConfigService cutConfigService;
   @Autowired
   private MesBuildingCompleteService completeService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingTaskOrderMapper orderMapper;
   @Autowired
   private MesBuildingArtifactSchedulingService schedulingService;
   @Autowired
   private TechArtifactExtService artifactExtService;
   @Autowired
   private TechAssembleExtService assembleExtService;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Autowired
   private MesBuildingAssistService assistService;

   @Override
   public List<MesBuildingTaskOrderChangeDTO> getTaskOrderList(Long projectId, Integer taskTypeEnum, LocalDateTime dateTime) {
      Preconditions.checkArgument(
         (taskTypeEnum & (TaskTypeEnum.MACHINE_PART.getType() | TaskTypeEnum.ASSEMBLE.getType() | TaskTypeEnum.ARTIFACT.getType())) > 0, "操作失败:产品类型不正确"
      );
      return this.baseService
         .getTaskOrderList(projectId, taskTypeEnum, dateTime)
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingTaskOrderChangeDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<MesBuildingTaskOrderChangeDTO> getTaskOrderPage(
      Long projectId, Integer taskTypeEnum, LocalDateTime dateTime, Integer pageNumber, Integer pageSize
   ) {
      Preconditions.checkArgument(
         (taskTypeEnum & (TaskTypeEnum.MACHINE_PART.getType() | TaskTypeEnum.ASSEMBLE.getType() | TaskTypeEnum.ARTIFACT.getType())) > 0, "操作失败:产品类型不正确"
      );
      Preconditions.checkArgument(!taskTypeEnum.equals(TaskTypeEnum.MACHINE_PART.getType()), "零件不支持协同!!!");
      List<MesBuildingTaskOrder> orders = this.taskOrderBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskOrder.class)
               .eq(projectId != null, MesBuildingTaskOrder::getProjectId, projectId)
               .eq(MesBuildingTaskOrder::getTaskTypeEnum, taskTypeEnum)
               .apply(dateTime != null, "date_format(create_time, '%Y-%m') = date_format({0}, '%Y-%m')", dateTime)
         );
      if (CollectionUtils.isEmpty(orders)) {
         return new PageVO<>();
      }

      List<Long> orderIds = orders.stream().map(MesBuildingTaskOrder::getId).collect(Collectors.toList());
      List<MesBuildingTask> tasks = this.taskService
         .list(Wrappers.lambdaQuery(MesBuildingTask.class).in(MesBuildingTask::getTaskOrderId, orderIds).apply("task_quantity>complete_quantity"));
      if (CollectionUtils.isEmpty(tasks)) {
         return new PageVO<>();
      }

      List<MesBuildingTaskCollaborativeDTO> taskCollDetails = this.checkTaskCollaborativeDetail(taskTypeEnum, tasks);
      List<MesBuildingTaskCollaborativeDTO> canCollabTasks = taskCollDetails.stream()
         .filter(s -> s.getCanCollaborativeQuantity() > 0)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(canCollabTasks)) {
         return new PageVO<>();
      }

      List<Long> canCollabOrderIds = canCollabTasks.stream().map(MesBuildingTaskCollaborativeDTO::getTaskOrderId).distinct().collect(Collectors.toList());
      PageHelper.startPage(pageNumber, pageSize);
      List<MesBuildingTaskOrder> canCollabOrders = this.taskOrderBiz
         .list(Wrappers.lambdaQuery(MesBuildingTaskOrder.class).in(MesBuildingTaskOrder::getId, canCollabOrderIds).orderByDesc(MesBuildingTaskOrder::getId));
      PageVO pageVO = new PageVO<>(canCollabOrders);
      List<Long> groupIds = canCollabOrders.stream().map(MesBuildingTaskOrder::getGroupsId).distinct().collect(Collectors.toList());
      Map<Long, GroupDetailDTO> treeMap = this.groupsBiz
         .getTreeByGroupIds(groupIds)
         .stream()
         .collect(Collectors.toMap(GroupDetailDTO::getGroupId, Function.identity()));
      List<Long> projectIds = canCollabOrders.stream().map(MesBuildingTaskOrder::getProjectId).distinct().collect(Collectors.toList());
      Map<Long, ContractProject> projectMap = this.projectService
         .listByIds(projectIds)
         .stream()
         .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      List<Long> monmerIds = canCollabOrders.stream().map(MesBuildingTaskOrder::getMonomerId).distinct().collect(Collectors.toList());
      Map<Long, PlanMonomer> monomerMap = this.monomerService.listByIds(monmerIds).stream().collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
      List<Long> userIds = canCollabOrders.stream().map(MesBuildingTaskOrder::getUserId).distinct().collect(Collectors.toList());
      Map<Long, User> userMap = this.userService.listByIds(userIds).stream().collect(Collectors.toMap(User::getId, Function.identity()));
      List<MesBuildingOrderProductDetailDTO> orderDetails = this.taskService.listOrderProduceDetail(canCollabOrderIds);
      Map<Long, List<MesBuildingOrderProductDetailDTO>> orderProduceMap = orderDetails.stream()
         .collect(Collectors.groupingBy(MesBuildingOrderProductDetailDTO::getId));
      List<Long> cutConfigIds = canCollabOrders.stream().map(s -> s.getCutConfigId()).distinct().collect(Collectors.toList());
      Map<Long, MesBuildingCutConfig> cutConfigMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(cutConfigIds)) {
         cutConfigMap = this.cutConfigService.listByIds(cutConfigIds).stream().collect(Collectors.toMap(MesBuildingCutConfig::getId, Function.identity()));
      }

      List<MesBuildingTaskOrderChangeDTO> dtos = new ArrayList<>();

      for (MesBuildingTaskOrder order : canCollabOrders) {
         GroupDetailDTO groupTree = treeMap.get(order.getGroupsId());
         ContractProject project = projectMap.get(order.getProjectId());
         PlanMonomer monomer = monomerMap.get(order.getMonomerId());
         User user = userMap.get(order.getUserId());
         List<MesBuildingOrderProductDetailDTO> orderProduceDtos = orderProduceMap.get(order.getId());
         int allTaskQuantity = orderProduceDtos.stream().mapToInt(MesBuildingOrderProductDetailDTO::getQuantity).sum();
         BigDecimal totalGrossWeight = orderProduceDtos.stream()
            .map(MesBuildingOrderProductDetailDTO::getTotalGrossWeight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal totalNetWeight = orderProduceDtos.stream()
            .map(MesBuildingOrderProductDetailDTO::getTotalNetWeight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         int allCompleteQuantity = orderProduceDtos.stream().mapToInt(MesBuildingOrderProductDetailDTO::getCompleteQuantity).sum();
         BigDecimal totalCompleteGrossWeight = orderProduceDtos.stream()
            .map(MesBuildingOrderProductDetailDTO::getTotalCompleteGrossWeight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal totalCompleteNetWeight = orderProduceDtos.stream()
            .map(MesBuildingOrderProductDetailDTO::getTotalCompleteNetWeight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         MesBuildingTaskOrderChangeDTO build = MesBuildingTaskOrderChangeDTO.builder()
            .id(order.getId())
            .groups(GroupsCurrencyDO.builder().id(groupTree.getGroupId()).name(groupTree.getGroupName()).build())
            .productionLine(ProductionLineDetailDO.builder().id(groupTree.getProductionLineId()).name(groupTree.getProductionLineName()).build())
            .workshop(WorkshopDetailDO.builder().id(groupTree.getWorkshopId()).name(groupTree.getWorkshopName()).build())
            .factory(FactoryDetailDO.builder().id(groupTree.getFactoryId()).name(groupTree.getFactoryName()).build())
            .project(
               ProjectDetailDO.builder()
                  .id(project.getId())
                  .name(project.getName())
                  .shortName(project.getShortName())
                  .serialNumber(project.getSerialNumber())
                  .build()
            )
            .monomer(MonomerDetailDO.builder().id(monomer.getId()).name(monomer.getName()).build())
            .taskTypeEnum(order.getTaskTypeEnum())
            .askCompleteTime(order.getAskCompleteTime())
            .user(IdAndNameDO.builder().id(user.getId()).name(user.getName()).build())
            .orderNumber(order.getOrderNumber())
            .quantity(allTaskQuantity)
            .totalNetWeight(totalNetWeight)
            .totalGrossWeight(totalGrossWeight)
            .completeQuantity(allCompleteQuantity)
            .totalCompleteNetWeight(totalCompleteNetWeight)
            .totalCompleteGrossWeight(totalCompleteGrossWeight)
            .cutConfig(
               order.getCutConfigId() == null
                  ? null
                  : IdAndNameDO.builder().id(order.getCutConfigId()).name(cutConfigMap.get(order.getCutConfigId()).getName()).build()
            )
            .build();
         dtos.add(build);
      }

      pageVO.setContent(dtos);
      return pageVO;
   }

   @Override
   public List<MesBuildingTaskChangeDTO> getTaskOrderDetailsList(Long taskOrderId, Long areaId, String serialNumber, String specification) {
      MesBuildingTaskOrder taskOrder = this.taskOrderBiz.getById(taskOrderId);
      Preconditions.checkArgument(taskOrder != null, "操作失败:id有误");
      Integer taskTypeEnum = taskOrder.getTaskTypeEnum();
      List<MesBuildingTask> tasks = this.taskService.listTasksByData(taskOrderId, areaId, serialNumber, specification, taskOrder.getTaskTypeEnum());
      List<MesBuildingTaskCollaborativeDTO> collaborativeDTOS = this.checkTaskCollaborativeDetail(taskTypeEnum, tasks);
      List<MesBuildingTaskChangeDTO> dtos = new ArrayList<>();

      for (MesBuildingTaskCollaborativeDTO taskDTO : collaborativeDTOS) {
         MesBuildingTaskChangeDTO build = MesBuildingTaskChangeDTO.builder()
            .id(taskDTO.getTaskId())
            .configId(taskDTO.getStructureClassId())
            .serialNumber(taskDTO.getSerialNumber())
            .specification(taskDTO.getSpecification())
            .askCompleteTime(taskDTO.getAskCompleteTime())
            .area(AreaDetailDO.builder().id(taskDTO.getAreaId()).name(taskDTO.getAreaName()).build())
            .quantity(taskDTO.getTaskQuantity())
            .netWeight(taskDTO.getNetWeight())
            .grossWeight(taskDTO.getGrocessWeight())
            .totalNetWeight(taskDTO.getNetWeight().multiply(BigDecimal.valueOf(taskDTO.getTaskQuantity().intValue())))
            .totalGrossWeight(taskDTO.getGrocessWeight().multiply(BigDecimal.valueOf(taskDTO.getTaskQuantity().intValue())))
            .taskTypeEnum(taskTypeEnum)
            .length(taskDTO.getLength())
            .canCollabQuantity(taskDTO.getCanCollaborativeQuantity())
            .groups(GroupsCurrencyDO.builder().id(taskDTO.getGroupId()).name(taskDTO.getGroupName()).build())
            .productionLine(ProductionLineDetailDO.builder().id(taskDTO.getLineId()).name(taskDTO.getLineName()).build())
            .workshop(WorkshopDetailDO.builder().id(taskDTO.getWorkShopId()).name(taskDTO.getWorkShopName()).build())
            .factory(FactoryDetailDO.builder().id(taskDTO.getFactoryId()).name(taskDTO.getFactoryName()).build())
            .numbers(taskDTO.getNumbers())
            .canCollabQuantity(taskDTO.getCanCollaborativeQuantity())
            .boolOneCode(taskDTO.getBoolOneCode())
            .build();
         dtos.add(build);
      }

      return dtos;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean taskChange(List<TaskChangeDTOParam> dtoParamList) {
      Preconditions.checkArgument(!dtoParamList.isEmpty(), "操作失败，数据有误");
      List<Long> taskIds = dtoParamList.stream().map(TaskChangeDTOParam::getId).collect(Collectors.toList());
      List<MesBuildingTask> tasks = this.taskService.listByIds(taskIds);
      Integer taskTypeEnum = tasks.get(0).getTaskTypeEnum();
      List<MesBuildingTaskCollaborativeDTO> collabDtos = this.checkTaskCollaborativeDetail(taskTypeEnum, tasks);
      Map<Long, MesBuildingTaskCollaborativeDTO> collabMap = collabDtos.stream()
         .collect(Collectors.toMap(MesBuildingTaskCollaborativeDTO::getTaskId, Function.identity()));
      Map<Long, MesBuildingTask> taskMap = tasks.stream().collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
      Map<String, MesBuildingArtifactScheduling> schedulingMap = new HashMap<>();
      if (taskTypeEnum.equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<Long> productIds = tasks.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList());
         schedulingMap = this.schedulingService
            .list(Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class).in(MesBuildingArtifactScheduling::getProductId, productIds))
            .stream()
            .collect(Collectors.toMap(s -> s.getProductId() + "_" + s.getGroupsId(), Function.identity()));
      }

      List<MesBuildingTaskProcess> oldTaskProcessList = this.taskProcessService
         .list(Wrappers.lambdaQuery(MesBuildingTaskProcess.class).in(MesBuildingTaskProcess::getTaskId, taskIds));
      Map<Long, List<MesBuildingTaskProcess>> oldTaskProcessMap = oldTaskProcessList.stream().collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId));
      HashMap<Long, Long> oldAndNewTaskIdMap = new HashMap<>();
      HashMap<Long, Long> newTaskProcessMap = new HashMap<>();
      Map<Long, List<Integer>> taskNumberMap = new HashMap<>();
      List<NumberInfoDTO> numberInfos = new ArrayList<>();
      HashMap<Long, Long> newTaskGroupMap = new HashMap<>();

      for (TaskChangeDTOParam param : dtoParamList) {
         MesBuildingTaskCollaborativeDTO dto = collabMap.get(param.getId());
         if (dto.getBoolOneCode()) {
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(param.getNumbers()), "操作失败!!请刷新页面!!!");
            Preconditions.checkArgument(param.getNumbers().size() <= dto.getCanCollaborativeQuantity(), "操作失败!!请刷新页面!!!");
            Preconditions.checkArgument(new HashSet<>(dto.getNumbers()).containsAll(param.getNumbers()), "操作失败!!请刷新页面!!!");
            taskNumberMap.put(dto.getTaskId(), param.getNumbers());

            for (Integer number : param.getNumbers()) {
               numberInfos.add(NumberInfoDTO.builder().productId(dto.getProductId()).number(number).build());
            }

            param.setQuantity(param.getNumbers().size());
         } else {
            Preconditions.checkArgument(param.getQuantity() > 0, "操作失败!!请刷新页面!!!");
            Preconditions.checkArgument(param.getQuantity() <= dto.getCanCollaborativeQuantity(), "操作失败!!请刷新页面!!!");
            List<Integer> numbers = dto.getNumbers().stream().limit(param.getQuantity().intValue()).collect(Collectors.toList());
            taskNumberMap.put(dto.getTaskId(), numbers);

            for (Integer number : numbers) {
               numberInfos.add(NumberInfoDTO.builder().productId(dto.getProductId()).number(number).build());
            }

            param.setNumbers(numbers);
         }
      }

      MesBuildingTaskOrder taskOrder = this.taskOrderBiz.getById(tasks.get(0).getTaskOrderId());
      MesBuildingTaskOrderChange change = MesBuildingTaskOrderChange.builder()
         .oldTaskOrderId(taskOrder.getId())
         .productionLineTypeEnum(taskOrder.getProductionLineTypeEnum())
         .taskTypeEnum(taskOrder.getTaskTypeEnum())
         .topTaskOrderId(taskOrder.getTopTaskOrderId())
         .userId(UserUtil.getCurrentUserId())
         .build();
      this.save(change);
      List<MesBuildingTaskOrderChangeDetails> lineCollabDetails = new ArrayList<>();
      MesBuildingTopTaskOrder topTaskOrder = this.topTaskOrderBiz.getById(taskOrder.getTopTaskOrderId());
      taskOrder.setQuantity(taskOrder.getQuantity() - dtoParamList.stream().mapToInt(TaskChangeDTOParam::getQuantity).sum());
      if (taskOrder.getQuantity() == 0) {
         this.taskOrderBiz.removeById(taskOrder);
      } else {
         this.taskOrderBiz.updateById(taskOrder);
      }

      Map<Long, List<TaskChangeDTOParam>> changeMap = dtoParamList.stream().collect(Collectors.groupingBy(TaskChangeDTOParam::getGroupsId));
      Map<Long, MesBuildingGroups> groupsMap = this.groupsBiz
         .listByIds(changeMap.keySet())
         .stream()
         .collect(Collectors.toMap(MesBuildingGroups::getId, Function.identity()));
      Map<Long, MesBuildingTask> newTaskMap = new HashMap<>();
      int sum = this.orderMapper.getNumber(taskTypeEnum, LocalDateTime.now());

      for (Long groupsId : changeMap.keySet()) {
         MesBuildingGroups groups = groupsMap.get(groupsId);
         List<TaskChangeDTOParam> list = changeMap.get(groupsId);
         MesBuildingTaskOrder newTaskOrder = BeanUtil.copy(taskOrder, MesBuildingTaskOrder.class);
         newTaskOrder.setQuantity(list.stream().mapToInt(TaskChangeDTOParam::getQuantity).sum());
         newTaskOrder.setUserId(UserUtil.getCurrentUserId());
         sum++;
         newTaskOrder.setOrderNumber(
            taskOrder.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())
               ? "构协-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd")) + "-" + sum
               : "部协-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd")) + "-" + sum
         );
         newTaskOrder.setGroupsId(groupsId);
         newTaskOrder.setPrintQuantity(0);
         this.taskOrderBiz.save(newTaskOrder);

         for (TaskChangeDTOParam dto : list) {
            MesBuildingTask oldTask = taskMap.get(dto.getId());
            Integer oldTaskQuantity = oldTask.getTaskQuantity();
            oldTask.setTaskQuantity(oldTask.getTaskQuantity() - dto.getQuantity());
            Preconditions.checkArgument(oldTask.getTaskQuantity() >= 0, "操作失败!!");
            MesBuildingTask newTask = BeanUtil.copy(oldTask, MesBuildingTask.class);
            if (taskTypeEnum.equals(TaskTypeEnum.ARTIFACT.getType())) {
               String oldSchedulingKey = oldTask.getProductId() + "_" + oldTask.getGroupsId();
               MesBuildingArtifactScheduling oldScheduling = schedulingMap.get(oldSchedulingKey);
               oldScheduling.setTaskQuantity(oldScheduling.getTaskQuantity() - dto.getQuantity());
               oldScheduling.setQuantity(oldScheduling.getQuantity() - dto.getQuantity());
               Preconditions.checkArgument(oldScheduling.getQuantity() >= oldScheduling.getTaskQuantity(), "操作失败,请刷新页面!");
               String newSchedulingKey = oldTask.getProductId() + "_" + groupsId;
               MesBuildingArtifactScheduling newScheduling = schedulingMap.get(newSchedulingKey);
               if (newScheduling != null) {
                  newScheduling.setQuantity(newScheduling.getQuantity() + dto.getQuantity());
                  newScheduling.setTaskQuantity(newScheduling.getTaskQuantity() + dto.getQuantity());
                  newTask.setSchedulingId(newScheduling.getId());
               } else {
                  newScheduling = BeanUtil.copy(oldScheduling, MesBuildingArtifactScheduling.class);
                  newScheduling.setWorkshopId(groups.getWorkshopId());
                  newScheduling.setProductionLineId(groups.getProductionLineId());
                  newScheduling.setGroupsId(groups.getId());
                  newScheduling.setQuantity(dto.getQuantity());
                  newScheduling.setTaskQuantity(dto.getQuantity());
                  newScheduling.setUserId(UserUtil.getCurrentUserId());
                  this.schedulingService.save(newScheduling);
                  newTask.setSchedulingId(newScheduling.getId());
                  schedulingMap.put(newSchedulingKey, newScheduling);
               }
            }

            newTask.setTaskQuantity(dto.getQuantity());
            newTask.setTaskOrderId(newTaskOrder.getId());
            newTask.setInProductionQuantity(0);
            newTask.setCompleteQuantity(0);
            newTask.setUserId(UserUtil.getCurrentUserId());
            newTask.setPrintQuantity(0);
            newTask.setFactoryId(groups.getFactoryId());
            newTask.setWorkshopId(groups.getWorkshopId());
            newTask.setProductionLineId(groups.getProductionLineId());
            newTask.setGroupsId(groupsId);
            newTask.setPrintTime(null);
            this.taskService.save(newTask);
            newTaskMap.put(newTask.getId(), newTask);
            newTaskGroupMap.put(newTask.getId(), newTask.getGroupsId());
            oldAndNewTaskIdMap.put(oldTask.getId(), newTask.getId());
            this.handleNeedMachinePart(oldTask.getId(), newTask, oldTaskQuantity);

            for (Integer number : dto.getNumbers()) {
               MesBuildingTaskOrderChangeDetails details = MesBuildingTaskOrderChangeDetails.builder()
                  .changeId(change.getId())
                  .oldTaskOrderId(oldTask.getTaskOrderId())
                  .newTaskOrderId(newTaskOrder.getId())
                  .newTaskId(newTask.getId())
                  .number(number)
                  .oldTaskId(oldTask.getId())
                  .productId(newTask.getProductId())
                  .taskTypeEnum(newTask.getTaskTypeEnum())
                  .build();
               lineCollabDetails.add(details);
            }

            for (MesBuildingTaskProcess taskProcess : oldTaskProcessMap.get(oldTask.getId())) {
               taskProcess.setTaskQuantity(taskProcess.getTaskQuantity() - newTask.getTaskQuantity());
               MesBuildingTaskProcess newTaskProcess = BeanUtil.copy(taskProcess, MesBuildingTaskProcess.class);
               if (taskProcess.getSequence().equals(0)) {
                  taskProcess.setNeedQuantity(taskProcess.getNeedQuantity() - newTask.getTaskQuantity());
                  newTaskProcess.setNeedQuantity(newTask.getTaskQuantity());
               }

               Preconditions.checkArgument(taskProcess.getTaskQuantity() >= taskProcess.getNeedQuantity(), "操作失败!!!");
               Preconditions.checkArgument(taskProcess.getNeedQuantity() >= taskProcess.getCompleteQuantity(), "操作失败!!!");
               Preconditions.checkArgument(taskProcess.getNeedQuantity() >= taskProcess.getInspectionQuantity(), "操作失败!!!");
               newTaskProcess.setTaskId(newTask.getId());
               newTaskProcess.setTaskQuantity(newTask.getTaskQuantity());
               newTaskProcess.setInspectionQuantity(0);
               newTaskProcess.setCompleteQuantity(0);
               newTaskProcess.setProblemQuantity(0);
               newTaskProcess.setTaskOrderId(newTask.getTaskOrderId());
               newTaskProcess.setFactoryId(newTask.getFactoryId());
               newTaskProcess.setWorkshopId(newTask.getWorkshopId());
               newTaskProcess.setProductionLineId(newTask.getProductionLineId());
               newTaskProcess.setGroupsId(newTask.getGroupsId());
               newTaskProcess.setUserId(newTask.getUserId());
               this.taskProcessService.save(newTaskProcess);
               if (taskProcess.getSequence().equals(0)) {
                  newTaskProcessMap.put(newTask.getId(), newTaskProcess.getId());
               }
            }
         }
      }

      this.changeDetailsService.saveBatch(lineCollabDetails);
      List<MesBuildingTask> updateTasks = new ArrayList<>(taskMap.values());
      this.taskService.updateBatchById(updateTasks);
      List<Long> removeTaskIds = updateTasks.stream().filter(s -> s.getTaskQuantity() == 0).map(MesBuildingTask::getId).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(removeTaskIds)) {
         this.taskService.removeByIds(removeTaskIds);
      }

      List<MesBuildingTaskProcess> updateTaskProcess = oldTaskProcessMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
      this.taskProcessService.updateBatchById(updateTaskProcess);
      List<Long> removeTaskProcessIds = updateTaskProcess.stream()
         .filter(s -> s.getTaskQuantity() == 0)
         .map(MesBuildingTaskProcess::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(removeTaskProcessIds)) {
         this.taskProcessService.removeByIds(removeTaskProcessIds);
      }

      if (taskTypeEnum.equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<MesBuildingTaskNumberLink> links = this.numberLinkService.listLinksBydata(numberInfos, TaskTypeEnum.ARTIFACT.getType());
         List<TechArtifactExt> artifactExts = this.artifactExtService.listArtifact(numberInfos);
         Map<Long, List<TechArtifactExt>> artExtMap = artifactExts.stream().collect(Collectors.groupingBy(TechArtifactExt::getTaskId));

         for (MesBuildingTaskNumberLink link : links) {
            List<TechArtifactExt> artexts = artExtMap.get(link.getArtifactTaskId());
            Long newTaskId = oldAndNewTaskIdMap.get(link.getArtifactTaskId());
            Long fistProcessId = newTaskProcessMap.get(newTaskId);
            link.setArtifactTaskId(newTaskId);
            link.setArtifactTaskProcessId(fistProcessId);
            MesBuildingTask task = newTaskMap.get(newTaskId);
            artexts.forEach(s -> s.setTaskId(newTaskId).setSchedulingId(task.getSchedulingId()));
         }

         List<TechArtifactExt> updateArtExts = artExtMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
         this.artifactExtService.updateBatchById(updateArtExts);
         this.numberLinkService.updateBatchById(links);
         Map<Long, MesBuildingTaskNumberLink> linkMap = links.stream().collect(Collectors.toMap(MesBuildingTaskNumberLink::getId, Function.identity()));
         List<Long> linkIds = links.stream().map(MesBuildingTaskNumberLink::getId).collect(Collectors.toList());
         List<MesBuildingComplete> completes = this.completeService
            .list(Wrappers.lambdaQuery(MesBuildingComplete.class).in(MesBuildingComplete::getNumberLinkId, linkIds));
         Map<String, Integer> houseSummaryReduceMap = new HashMap<>();
         Map<String, Integer> houseSummaryAppendMap = new HashMap<>();

         for (MesBuildingComplete complete : completes) {
            MesBuildingTaskNumberLink link = linkMap.get(complete.getNumberLinkId());
            Long groupId = newTaskGroupMap.get(link.getArtifactTaskId());
            String reduceKey = complete.getWorkshopId() + "_" + complete.getProductId() + "_" + complete.getTaskTypeEnum();
            MesBuildingGroups groups = groupsMap.get(groupId);
            complete.setArtifactTaskId(link.getArtifactTaskId());
            complete.setFactoryId(groups.getFactoryId());
            complete.setWorkshopId(groups.getWorkshopId());
            complete.setProductionLineId(groups.getProductionLineId());
            complete.setGroupsId(groups.getId());
            String appendKey = complete.getWorkshopId() + "_" + complete.getProductId() + "_" + complete.getTaskTypeEnum();
            houseSummaryReduceMap.merge(reduceKey, 1, Integer::sum);
            houseSummaryAppendMap.merge(appendKey, 1, Integer::sum);
         }

         this.completeService.updateBatchById(completes);
         Map<Long, MesBuildingComplete> completeMap = completes.stream().collect(Collectors.toMap(MesBuildingComplete::getId, Function.identity()));
         List<Long> completeIds = completes.stream().map(MesBuildingComplete::getId).collect(Collectors.toList());
         List<MesBuildingWarehouseRecord> records = this.warehouseRecordService
            .list(Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class).in(MesBuildingWarehouseRecord::getCompleteId, completeIds));
         Preconditions.checkArgument(records.stream().allMatch(s -> s.getType().equals(WarehouseTypeEnum.INTO.getType())), "操作失败!!请刷新页面!!");

         for (MesBuildingWarehouseRecord record : records) {
            MesBuildingComplete complete = completeMap.get(record.getCompleteId());
            record.setFactoryId(complete.getFactoryId());
            record.setWorkshopId(complete.getWorkshopId());
         }

         this.warehouseRecordService.updateBatchById(records);
         List<MesBuildingLineChangeListDTO> listDtos = new ArrayList<>();
         if (!houseSummaryReduceMap.isEmpty()) {
            for (String s : houseSummaryReduceMap.keySet()) {
               String[] split = s.split("_");
               MesBuildingLineChangeListDTO build = MesBuildingLineChangeListDTO.builder()
                  .shopId(Long.valueOf(split[0]))
                  .productId(Long.valueOf(split[1]))
                  .taskType(Integer.valueOf(split[2]))
                  .build();
               listDtos.add(build);
            }
         }

         if (!houseSummaryAppendMap.isEmpty()) {
            for (String s : houseSummaryAppendMap.keySet()) {
               String[] split = s.split("_");
               MesBuildingLineChangeListDTO build = MesBuildingLineChangeListDTO.builder()
                  .shopId(Long.valueOf(split[0]))
                  .productId(Long.valueOf(split[1]))
                  .taskType(Integer.valueOf(split[2]))
                  .build();
               listDtos.add(build);
            }
         }

         List<MesBuildingWarehouseSummary> summaries = this.warehouseSummaryService.listSummarysByData(listDtos);
         List<Long> shopIds = listDtos.stream().map(MesBuildingLineChangeListDTO::getShopId).distinct().collect(Collectors.toList());
         Map<Long, MesBuildingWorkshop> shopMap = this.workshopService
            .listByIds(shopIds)
            .stream()
            .collect(Collectors.toMap(MesBuildingWorkshop::getId, Function.identity()));

         for (MesBuildingWarehouseSummary summary : summaries) {
            String key = summary.getWorkshopId() + "_" + summary.getProductId() + "_" + summary.getProductType();
            if (houseSummaryReduceMap.containsKey(key)) {
               Integer reduce = houseSummaryReduceMap.get(key);
               summary.setQuantity(summary.getQuantity().subtract(BigDecimal.valueOf(reduce.intValue())));
               Preconditions.checkArgument(summary.getQuantity().intValue() >= 0, "操作失败!!!");
               Preconditions.checkArgument(
                  summary.getQuantity().intValue() >= summary.getPackageQuantity().intValue() + summary.getCargoQuantity().intValue(), "操作失败!!!"
               );
            }
         }

         Map<String, MesBuildingWarehouseSummary> wareSummaryMap = summaries.stream()
            .collect(Collectors.toMap(s -> s.getWorkshopId() + "_" + s.getProductId() + "_" + s.getProductType(), Function.identity()));
         Map<String, MesBuildingWarehouseRecord> prroductMap = records.stream()
            .collect(Collectors.toMap(s -> s.getProductId() + "_" + s.getProductType(), Function.identity(), (s1, s2) -> s1));

         for (String key : houseSummaryAppendMap.keySet()) {
            Integer append = houseSummaryAppendMap.get(key);
            MesBuildingWarehouseSummary summary = wareSummaryMap.get(key);
            String[] split = key.split("_");
            if (summary != null) {
               summary.setQuantity(summary.getQuantity().add(BigDecimal.valueOf(append.intValue())));
            } else {
               MesBuildingWorkshop workshop = shopMap.get(Long.valueOf(split[0]));
               MesBuildingWarehouseRecord record = prroductMap.get(split[1] + "_" + split[2]);
               MesBuildingWarehouseSummary build = MesBuildingWarehouseSummary.builder()
                  .projectId(record.getProjectId())
                  .monomerId(record.getMonomerId())
                  .areaId(record.getAreaId())
                  .factoryId(workshop.getFactoryId())
                  .workshopId(Long.valueOf(split[0]))
                  .productId(Long.valueOf(split[1]))
                  .productType(Integer.valueOf(split[2]))
                  .type(WarehouseTypeEnum.INTO.getType())
                  .quantity(BigDecimal.valueOf(append.intValue()))
                  .build();
               wareSummaryMap.put(key, build);
            }
         }

         List<MesBuildingWarehouseSummary> summaryList = new ArrayList<>(wareSummaryMap.values());
         this.warehouseSummaryService.saveOrUpdateBatch(summaryList);
         List<Long> needRemoveSummarys = summaryList.stream()
            .filter(s -> s.getQuantity().intValue() == 0)
            .map(MesBuildingWarehouseSummary::getId)
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(needRemoveSummarys)) {
            this.warehouseSummaryService.removeByIds(needRemoveSummarys);
         }
      } else if (taskTypeEnum.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<MesBuildingTaskNumberLink> links = this.numberLinkService.listLinksBydata(numberInfos, TaskTypeEnum.ASSEMBLE.getType());

         for (MesBuildingTaskNumberLink link : links) {
            Long newTaskId = oldAndNewTaskIdMap.get(link.getAssembleTaskId());
            Long fistProcessId = newTaskProcessMap.get(newTaskId);
            link.setAssembleTaskId(newTaskId);
            link.setAssembleTaskProcessId(fistProcessId);
         }

         this.numberLinkService.updateBatchById(links);
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean nestTaskChange(List<TaskChangeDTOParam> dtoParamList) {
      Map<Long, MesBuildingNestCutPlate> nestCutPlateMap = this.nestCutPlateBiz
         .listByIds(dtoParamList.stream().map(TaskChangeDTOParam::getId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(MesBuildingNestCutPlate::getId, Function.identity()));
      Preconditions.checkArgument(nestCutPlateMap.size() > 0, "操作失败，id不正确");
      Map<Long, MesBuildingGroups> groupsMap = this.groupsBiz
         .listByIds(dtoParamList.stream().map(TaskChangeDTOParam::getGroupsId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(MesBuildingGroups::getId, Function.identity()));
      Preconditions.checkArgument(groupsMap.size() > 0, "操作失败，班组不正确");
      Map<Long, List<MesBuildingTask>> taskListMap = this.taskService
         .list(Wrappers.lambdaQuery(MesBuildingTask.class).in(MesBuildingTask::getNestCutPlateId, nestCutPlateMap.keySet()))
         .stream()
         .collect(Collectors.groupingBy(MesBuildingTask::getNestCutPlateId));
      Map<Long, List<MesBuildingTaskProcess>> taskProcessListMap = this.taskProcessService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
               .in(MesBuildingTaskProcess::getNestCutPlateId, nestCutPlateMap.keySet())
               .in(
                  MesBuildingTaskProcess::getProcessId,
                  this.processService
                     .list(Wrappers.lambdaQuery(MesBuildingProcess.class).eq(MesBuildingProcess::getType, ProcessTypeEnum.MAKINGS.getType()))
                     .stream()
                     .map(MesBuildingProcess::getId)
                     .collect(Collectors.toList())
               )
         )
         .stream()
         .collect(Collectors.groupingBy(MesBuildingTaskProcess::getNestCutPlateId));
      dtoParamList.forEach(
         e -> {
            MesBuildingNestCutPlate nestCutPlate = nestCutPlateMap.get(e.getId());
            Preconditions.checkArgument(nestCutPlate != null, "操作失败:钢板不正确");
            MesBuildingGroups groups = groupsMap.get(e.getGroupsId());
            Preconditions.checkArgument(groups != null, "操作失败:班组不正确");
            MesBuildingTaskOrder taskOrder = this.taskOrderBiz.getById(nestCutPlate.getTaskOrderId());
            MesBuildingTaskOrderChange change = MesBuildingTaskOrderChange.builder()
               .oldTaskOrderId(taskOrder.getId())
               .productionLineTypeEnum(taskOrder.getProductionLineTypeEnum())
               .taskTypeEnum(taskOrder.getTaskTypeEnum())
               .topTaskOrderId(taskOrder.getTopTaskOrderId())
               .userId(UserUtil.getCurrentUserId())
               .groupsId(e.getGroupsId())
               .build();
            this.save(change);
            this.changeDetailsBiz
               .save(
                  MesBuildingTaskOrderChangeDetails.builder()
                     .changeId(change.getId())
                     .newTaskOrderId(taskOrder.getId())
                     .nestCutPlateId(e.getId())
                     .quantity(1)
                     .taskTypeEnum(taskOrder.getTaskTypeEnum())
                     .build()
               );
            nestCutPlate.setFactoryId(groups.getFactoryId());
            nestCutPlate.setWorkshopId(groups.getWorkshopId());
            nestCutPlate.setProductionLineId(groups.getProductionLineId());
            nestCutPlate.setGroupsId(groups.getId());
            this.nestCutPlateBiz.updateById(nestCutPlate);
            taskListMap.get(e.getId()).forEach(task -> {
               task.setFactoryId(groups.getFactoryId());
               task.setWorkshopId(groups.getWorkshopId());
               task.setProductionLineId(groups.getProductionLineId());
               task.setGroupsId(groups.getId());
               this.taskService.updateById(task);
            });
            taskProcessListMap.get(e.getId()).forEach(taskProcess -> {
               taskProcess.setFactoryId(groups.getFactoryId());
               taskProcess.setWorkshopId(groups.getWorkshopId());
               taskProcess.setProductionLineId(groups.getProductionLineId());
               taskProcess.setGroupsId(groups.getId());
               this.taskProcessService.updateById(taskProcess);
            });
         }
      );
      return null;
   }

   @Override
   public List<MesBuildingChangeDTO> getChangeList(Integer taskTypeEnum, String userName) {
      return this.baseService
         .getChangeList(taskTypeEnum, userName)
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingChangeDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<MesBuildingChangeDTO> getChangePage(String userName, Integer taskTypeEnum, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.getChangeList(taskTypeEnum, userName));
   }

   @Override
   public List<MesBuildingChangeDetailsDTO> getChangeDetailsList(Long changeId) {
      MesBuildingTaskOrderChange change = this.getById(changeId);
      Preconditions.checkArgument(change != null, "操作失败:参数不正确");
      List<MesBuildingChangeDetailsDTO> dtos = new ArrayList<>();
      List<MesBuildingTaskOrderChangeDetails> changeDetails = this.changeDetailsBiz
         .list(Wrappers.lambdaQuery(MesBuildingTaskOrderChangeDetails.class).eq(MesBuildingTaskOrderChangeDetails::getChangeId, changeId));
      Map<Long, List<MesBuildingTaskOrderChangeDetails>> deltailMap = changeDetails.stream()
         .collect(Collectors.groupingBy(MesBuildingTaskOrderChangeDetails::getNewTaskId));
      List<Long> productIds = changeDetails.stream().map(MesBuildingTaskOrderChangeDetails::getProductId).distinct().collect(Collectors.toList());
      List<Long> taskOrderIds = changeDetails.stream().map(MesBuildingTaskOrderChangeDetails::getNewTaskOrderId).distinct().collect(Collectors.toList());
      List<MesBuildingTaskOrder> taskOrders = this.taskOrderBiz.listByIds(taskOrderIds);
      Map<Long, MesBuildingTaskOrder> taskOrderMap = taskOrders.stream().collect(Collectors.toMap(MesBuildingTaskOrder::getId, Function.identity()));
      List<Long> taskIds = changeDetails.stream().map(MesBuildingTaskOrderChangeDetails::getNewTaskId).distinct().collect(Collectors.toList());
      List<MesBuildingTask> tasks = this.taskService.listByIds(taskIds);
      Map<Long, MesBuildingTask> taskMap = tasks.stream().collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
      List<Long> areaIds = tasks.stream().map(MesBuildingTask::getAreaId).distinct().collect(Collectors.toList());
      Map<Long, PlanArea> areaMap = this.areaService.listByIds(areaIds).stream().collect(Collectors.toMap(PlanArea::getId, Function.identity()));
      List<Long> groupIds = tasks.stream().map(MesBuildingTask::getGroupsId).distinct().collect(Collectors.toList());
      Map<Long, MesBuildingGroups> groupMap = this.groupsBiz
         .listByIds(groupIds)
         .stream()
         .collect(Collectors.toMap(MesBuildingGroups::getId, Function.identity()));
      Map<Long, MesBuildingWorkshop> shopMap = this.workshopService.list().stream().collect(Collectors.toMap(MesBuildingWorkshop::getId, Function.identity()));
      Map<Long, MesBuildingProductionLine> lineMap = this.productionLineService
         .list()
         .stream()
         .collect(Collectors.toMap(MesBuildingProductionLine::getId, Function.identity()));
      Map<Long, TechArtifact> artifactMap = this.artifactService
         .listByIds(productIds)
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      Map<Long, TechAssemble> assMap = this.assembleService.listByIds(productIds).stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));

      for (Long taskId : deltailMap.keySet()) {
         List<MesBuildingTaskOrderChangeDetails> details = deltailMap.get(taskId);
         MesBuildingTask task = taskMap.get(taskId);
         MesBuildingTaskOrder order = taskOrderMap.get(task.getTaskOrderId());
         MesBuildingGroups groups = groupMap.get(task.getGroupsId());
         MesBuildingProductionLine line = lineMap.get(groups.getProductionLineId());
         MesBuildingWorkshop shop = shopMap.get(groups.getWorkshopId());
         PlanArea area = areaMap.get(task.getAreaId());
         MesBuildingChangeDetailsDTO build = MesBuildingChangeDetailsDTO.builder()
            .orderNumber(order.getOrderNumber())
            .quantity(details.size())
            .numbers(details.stream().map(MesBuildingTaskOrderChangeDetails::getNumber).collect(Collectors.toList()))
            .boolOneCode(task.getBoolOneCode())
            .taskTypeEnum(task.getTaskTypeEnum())
            .workshop(WorkshopDetailDO.builder().id(shop.getId()).name(shop.getName()).build())
            .productionLine(ProductionLineDetailDO.builder().id(line.getId()).name(line.getName()).build())
            .groups(GroupsCurrencyDO.builder().id(groups.getId()).name(groups.getName()).build())
            .area(AreaDetailDO.builder().id(area.getId()).name(area.getName()).build())
            .build();
         if (task.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
            TechArtifact techArtifact = artifactMap.get(task.getProductId());
            build.setSerialNumber(techArtifact.getSerialNumber())
               .setNetWeight(techArtifact.getNetWeight())
               .setGrossWeight(techArtifact.getGrossWeight())
               .setTotalNetWeight(techArtifact.getNetWeight().multiply(BigDecimal.valueOf(build.getQuantity().intValue())).setScale(2, RoundingMode.HALF_DOWN))
               .setTotalGrossWeight(
                  techArtifact.getGrossWeight().multiply(BigDecimal.valueOf(build.getQuantity().intValue())).setScale(2, RoundingMode.HALF_DOWN)
               )
               .setSerialNumber(techArtifact.getSerialNumber())
               .setSpecification(techArtifact.getSpecification())
               .setLength(techArtifact.getLength());
         } else if (task.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
            TechAssemble assemble = assMap.get(task.getProductId());
            build.setSerialNumber(assemble.getSerialNumber())
               .setNetWeight(assemble.getNetWeight())
               .setGrossWeight(assemble.getGrossWeight())
               .setTotalNetWeight(assemble.getNetWeight().multiply(BigDecimal.valueOf(build.getQuantity().intValue())).setScale(2, RoundingMode.HALF_DOWN))
               .setTotalGrossWeight(assemble.getGrossWeight().multiply(BigDecimal.valueOf(build.getQuantity().intValue())).setScale(2, RoundingMode.HALF_DOWN))
               .setSerialNumber(assemble.getSerialNumber())
               .setSpecification(assemble.getSpecification())
               .setLength(assemble.getLength());
         }

         dtos.add(build);
      }

      return dtos;
   }

   private Boolean handleNeedMachinePart(Long oldTaskId, MesBuildingTask newTask, Integer oldTaskQuantity) {
      Integer reduceQuantity = oldTaskQuantity - newTask.getTaskQuantity();
      List<MesBuildingTaskNeedMachinePartScheduling> needMachinePartSchedulingList = this.taskNeedMachinePartSchedulingBiz
         .list(Wrappers.lambdaQuery(MesBuildingTaskNeedMachinePartScheduling.class).eq(MesBuildingTaskNeedMachinePartScheduling::getTaskId, oldTaskId));
      needMachinePartSchedulingList.forEach(
         e -> {
            e.setNeedQuantity(e.getNeedQuantity() / oldTaskQuantity * reduceQuantity);
            MesBuildingTaskNeedMachinePartScheduling newTaskNeed = MesBuildingTaskNeedMachinePartScheduling.builder()
               .taskOrderId(e.getTaskOrderId())
               .taskId(newTask.getId())
               .useId(e.getUseId())
               .askCompleteTime(e.getAskCompleteTime())
               .needQuantity(e.getNeedQuantity() / oldTaskQuantity * reduceQuantity)
               .schedulingQuantity(0)
               .workshopId(newTask.getWorkshopId())
               .productionLineId(newTask.getProductionLineId())
               .groupsId(newTask.getGroupsId())
               .projectId(e.getProjectId())
               .monomerId(e.getMonomerId())
               .areaId(e.getAreaId())
               .build();
            this.taskNeedMachinePartSchedulingBiz.save(newTaskNeed);
            if (e.getSchedulingQuantity() > e.getNeedQuantity()) {
               newTaskNeed.setSchedulingQuantity(e.getSchedulingQuantity() - e.getNeedQuantity());
               this.taskNeedMachinePartSchedulingBiz.updateById(newTaskNeed);
               MesBuildingMachinePartSchedulingArtifactTaskLink oldSchedulingArtifactTaskLink = this.machinePartSchedulingArtifactTaskLinkBiz
                  .getOne(
                     Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingArtifactTaskLink.class)
                        .eq(MesBuildingMachinePartSchedulingArtifactTaskLink::getNeedLinkId, e.getId())
                  );
               MesBuildingMachinePartSchedulingArtifactTaskLink newSchedulingArtifactTaskLink = MesBuildingMachinePartSchedulingArtifactTaskLink.builder()
                  .schedulingLinkId(oldSchedulingArtifactTaskLink.getSchedulingLinkId())
                  .needLinkId(newTaskNeed.getId())
                  .schedulingId(oldSchedulingArtifactTaskLink.getSchedulingId())
                  .taskId(newTask.getId())
                  .quantity(e.getSchedulingQuantity() - e.getNeedQuantity())
                  .build();
               this.machinePartSchedulingArtifactTaskLinkBiz.save(newSchedulingArtifactTaskLink);
               oldSchedulingArtifactTaskLink.setQuantity(oldSchedulingArtifactTaskLink.getQuantity() - (e.getSchedulingQuantity() - e.getNeedQuantity()));
               if (oldSchedulingArtifactTaskLink.getQuantity() == 0) {
                  this.machinePartSchedulingArtifactTaskLinkBiz.removeById(oldSchedulingArtifactTaskLink.getId());
               } else {
                  this.machinePartSchedulingArtifactTaskLinkBiz.updateById(oldSchedulingArtifactTaskLink);
               }
            }

            if (e.getNeedQuantity() == 0) {
               this.taskNeedMachinePartSchedulingBiz.removeById(e.getId());
            } else {
               this.taskNeedMachinePartSchedulingBiz.updateById(e);
            }
         }
      );
      return null;
   }

   private synchronized List<MesBuildingTaskCollaborativeDTO> checkTaskCollaborativeDetail(Integer taskTypeEnum, List<MesBuildingTask> tasks) {
      List<MesBuildingTaskCollaborativeDTO> collaborativeDTOS = new ArrayList<>();
      List<Long> productionLineIds = tasks.stream().map(MesBuildingTask::getProductionLineId).distinct().collect(Collectors.toList());
      Map<Long, ProductLineDetailDTO> productionLineMap = this.productionLineService
         .getTreeByLineIds(productionLineIds)
         .stream()
         .collect(Collectors.toMap(ProductLineDetailDTO::getProductionLineId, Function.identity()));
      List<Long> taskIds = tasks.stream().map(MesBuildingTask::getId).collect(Collectors.toList());
      List<MesBuildingTaskNumberLink> links = this.numberLinkService.listNumberLinksByTaskIds(taskIds);
      List<Long> productIds = tasks.stream().map(MesBuildingTask::getProductId).distinct().collect(Collectors.toList());
      List<Long> assistTaskIds = this.assistService
         .list(Wrappers.lambdaQuery(MesBuildingAssist.class).in(MesBuildingAssist::getTaskId, taskIds))
         .stream()
         .map(MesBuildingAssist::getTaskId)
         .distinct()
         .collect(Collectors.toList());
      new HashMap();
      Map<Long, TechMachinePart> partMap = new HashMap<>();
      Map<String, Integer> partShopQuantityMap = new HashMap<>();
      Map<Long, List<TechArtifactMachinePartLink>> artPartLinkMap = new HashMap<>();
      new HashMap();
      Map<Long, TechArtifact> artMap = new HashMap<>();
      Map<Long, PlanArea> areaMap = new HashMap<>();
      Map<Long, PlanMonomer> monMap = new HashMap<>();
      if (taskTypeEnum.equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<TechArtifact> artifacts = this.artifactService.listByIds(productIds);
         artMap = artifacts.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
         List<Long> areaIds = artifacts.stream().map(TechArtifact::getAreaId).distinct().collect(Collectors.toList());
         List<PlanArea> planAreas = this.areaService.listByIds(areaIds);
         planAreas.forEach(s -> {
            PlanArea var10000 = areaMap.put(s.getId(), s);
         });
         List<Long> monIds = artifacts.stream().map(TechArtifact::getMonomerId).distinct().collect(Collectors.toList());
         List<PlanMonomer> planMonomers = this.monomerService.listByIds(monIds);
         planMonomers.forEach(s -> {
            PlanMonomer var10000 = monMap.put(s.getId(), s);
         });
         List<TechArtifactMachinePartLink> artPartLinks = this.artPartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, productIds));
         artPartLinkMap = artPartLinks.stream().collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
         List<Long> partIds = artPartLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).distinct().collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(partIds)) {
            partMap = this.machinePartService.listByIds(partIds).stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
            List<MesBuildingWarehouseSummary> summaryList = this.warehouseSummaryService
               .list(
                  Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                     .in(MesBuildingWarehouseSummary::getProductId, partMap.keySet())
                     .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                     .eq(MesBuildingWarehouseSummary::getProductType, TaskTypeEnum.MACHINE_PART.getType())
               );
            partShopQuantityMap = summaryList.stream()
               .collect(
                  Collectors.toMap(
                     s -> s.getProductId() + "_" + s.getWorkshopId(),
                     s -> s.getQuantity().intValue() - s.getCargoQuantity().intValue() - s.getPackageQuantity().intValue()
                  )
               );
         }
      } else if (taskTypeEnum.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<TechAssemble> assembles = this.assembleService.listByIds(productIds);
         List<Long> areaIds = assembles.stream().map(TechAssemble::getAreaId).distinct().collect(Collectors.toList());
         List<PlanArea> planAreas = this.areaService.listByIds(areaIds);
         planAreas.forEach(s -> {
            PlanArea var10000 = areaMap.put(s.getId(), s);
         });
         List<Long> monIds = assembles.stream().map(TechAssemble::getMonomerId).distinct().collect(Collectors.toList());
         List<PlanMonomer> planMonomers = this.monomerService.listByIds(monIds);
         planMonomers.forEach(s -> {
            PlanMonomer var10000 = monMap.put(s.getId(), s);
         });
         List<TechAssembleMachinePartLink> assPartLinks = this.assPartLinkService
            .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getAssembleId, productIds));
         Map<Long, List<TechAssembleMachinePartLink>> assPartLinkMap = assPartLinks.stream()
            .collect(Collectors.groupingBy(TechAssembleMachinePartLink::getAssembleId));
         List<Long> partIds = assPartLinks.stream().map(TechAssembleMachinePartLink::getMachinePartId).distinct().collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(partIds)) {
            partMap = this.machinePartService.listByIds(partIds).stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
            List<MesBuildingWarehouseSummary> summaryList = this.warehouseSummaryService
               .list(
                  Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                     .eq(MesBuildingWarehouseSummary::getProductId, partMap.keySet())
                     .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                     .eq(MesBuildingWarehouseSummary::getProductType, TaskTypeEnum.MACHINE_PART.getType())
               );
            partShopQuantityMap = summaryList.stream()
               .collect(
                  Collectors.toMap(
                     s -> s.getProductId() + "_" + s.getWorkshopId(),
                     s -> s.getQuantity().intValue() - s.getCargoQuantity().intValue() - s.getPackageQuantity().intValue()
                  )
               );
         }
      }

      if (taskTypeEnum.equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<Long> assIds = links.stream().map(MesBuildingTaskNumberLink::getAssembleId).distinct().collect(Collectors.toList());
         List<TechAssemble> assembleList = this.assembleService.listByIds(assIds);
         Map<Long, TechAssemble> assembleMap = assembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
         Map<Long, List<MesBuildingTaskNumberLink>> numberLinkTaskMap = links.stream()
            .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskId));
         List<MesBuildingTaskNumberLink> allSendAssLinks = links.stream()
            .filter(s -> s.getAssembleId() != null)
            .filter(s -> !assembleMap.get(s.getAssembleId()).getBoolProcess())
            .filter(s -> assembleMap.get(s.getAssembleId()).getBoolSendDirectly())
            .collect(Collectors.toList());
         List<NumberInfoDTO> allSendAssNumbers = allSendAssLinks.stream()
            .map(s -> NumberInfoDTO.builder().productId(s.getAssembleId()).number(s.getAssembleNumber()).build())
            .collect(Collectors.toList());
         Map<String, MesBuildingProductBoolChangeDTO> assCargoMap = new HashMap<>();
         if (CollectionUtils.isNotEmpty(allSendAssNumbers)) {
            List<MesBuildingProductBoolChangeDTO> assNumberCargoList = this.warehouseRecordService.listBoolAssInCargo(allSendAssNumbers);
            assCargoMap = assNumberCargoList.stream().collect(Collectors.toMap(s -> s.getProductId() + "_" + s.getSortNumber(), Function.identity()));
         }

         for (MesBuildingTask task : tasks) {
            TechArtifact artifact = artMap.get(task.getProductId());
            PlanArea area = areaMap.get(artifact.getAreaId());
            PlanMonomer monomer = monMap.get(artifact.getMonomerId());
            ProductLineDetailDTO productLineDetailDTO = productionLineMap.get(task.getProductionLineId());
            List<MesBuildingTaskNumberLink> artTaskLinks = numberLinkTaskMap.get(task.getId());
            Map<String, List<MesBuildingTaskNumberLink>> artNumberLinkMap = artTaskLinks.stream()
               .collect(Collectors.groupingBy(s -> s.getArtifactId() + "_" + s.getArtifactNumber()));
            List<NumberInfoDTO> numberInfos = new ArrayList<>();

            for (String key : artNumberLinkMap.keySet()) {
               List<MesBuildingTaskNumberLink> numberLinks = artNumberLinkMap.get(key);
               boolean boolNeedProduceInProduce = numberLinks.stream()
                  .filter(s -> s.getAssembleId() != null)
                  .filter(s -> assembleMap.get(s.getAssembleId()).getBoolProcess())
                  .allMatch(s -> !s.getBoolAssembleInproduce());
               List<MesBuildingTaskNumberLink> sendAssLinks = numberLinks.stream()
                  .filter(s -> s.getAssembleId() != null)
                  .filter(s -> !assembleMap.get(s.getAssembleId()).getBoolProcess())
                  .filter(s -> assembleMap.get(s.getAssembleId()).getBoolSendDirectly())
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(sendAssLinks)) {
                  Map<String, MesBuildingProductBoolChangeDTO> finalAssCargoMap = assCargoMap;
                  boolean boolSendAssIncargo = sendAssLinks.stream()
                     .allMatch(s -> finalAssCargoMap.get(s.getAssembleId() + "_" + s.getAssembleNumber()).getBoolCanCange());
                  boolNeedProduceInProduce &= boolSendAssIncargo;
               }

               if (boolNeedProduceInProduce) {
                  NumberInfoDTO build = NumberInfoDTO.builder().productId(Long.valueOf(key.split("_")[0])).number(Integer.valueOf(key.split("_")[1])).build();
                  numberInfos.add(build);
               }
            }

            Integer maxQuantity = numberInfos.size();
            Long shopId = task.getWorkshopId();
            List<TechArtifactMachinePartLink> partLinks = artPartLinkMap.get(task.getProductId());
            if (CollectionUtils.isNotEmpty(partLinks)) {
               for (TechArtifactMachinePartLink partLink : partLinks) {
                  TechMachinePart part = partMap.get(partLink.getMachinePartId());
                  if (part.getRelationType().equals(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType()) && part.getBoolSendDirectly()) {
                     Integer houseQuantity = partShopQuantityMap.get(partLink.getMachinePartId() + "_" + shopId);
                     int i = houseQuantity / partLink.getQuantity();
                     maxQuantity = Math.min(maxQuantity, i);
                  }
               }
            }

            MesBuildingTaskCollaborativeDTO build = MesBuildingTaskCollaborativeDTO.builder()
               .taskId(task.getId())
               .taskOrderId(task.getTaskOrderId())
               .askCompleteTime(task.getAskCompleteTime())
               .taskQuantity(task.getTaskQuantity())
               .areaId(area.getId())
               .areaName(area.getName())
               .monomerId(monomer.getId())
               .monomerName(monomer.getName())
               .productId(artifact.getId())
               .structureClassId(artifact.getStructureClassId())
               .serialNumber(artifact.getSerialNumber())
               .specification(artifact.getSpecification())
               .length(artifact.getLength())
               .material(artifact.getMaterial())
               .quantity(artifact.getQuantity())
               .taskQuantity(task.getTaskQuantity())
               .netWeight(artifact.getNetWeight())
               .grocessWeight(artifact.getGrossWeight())
               .completeQuantity(task.getCompleteQuantity())
               .canCollaborativeQuantity(maxQuantity)
               .numbers(numberInfos.stream().map(NumberInfoDTO::getNumber).sorted().collect(Collectors.toList()))
               .factoryId(productLineDetailDTO.getFactoryId())
               .factoryName(productLineDetailDTO.getFactoryName())
               .workShopId(productLineDetailDTO.getWorkshopId())
               .workShopName(productLineDetailDTO.getWorkshopName())
               .lineId(productLineDetailDTO.getProductionLineId())
               .lineName(productLineDetailDTO.getProductionLineName())
               .boolOneCode(task.getBoolOneCode())
               .build();
            if (assistTaskIds.contains(task.getId())) {
               build.setCanCollaborativeQuantity(0);
               build.setNumbers(new ArrayList<>());
            }

            collaborativeDTOS.add(build);
         }
      }

      if (taskTypeEnum.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         Map<Long, TechAssemble> assembleMap = this.assembleService
            .listByIds(productIds)
            .stream()
            .collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
         Map<Long, List<MesBuildingTaskNumberLink>> assTaskLinkMap = links.stream()
            .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleTaskId));
         List<NumberInfoDTO> assNumbers = links.stream()
            .map(s -> NumberInfoDTO.builder().productId(s.getAssembleId()).number(s.getAssembleNumber()).build())
            .collect(Collectors.toList());
         List<MesBuildingProductBoolChangeDTO> assNumberCargoList = this.warehouseRecordService.listBoolAssInCargo(assNumbers);
         Map<String, MesBuildingProductBoolChangeDTO> assCargoMap = assNumberCargoList.stream()
            .collect(Collectors.toMap(s -> s.getProductId() + "_" + s.getSortNumber(), Function.identity()));

         for (MesBuildingTask task : tasks) {
            TechAssemble assemble = assembleMap.get(task.getProductId());
            PlanArea area = areaMap.get(assemble.getAreaId());
            PlanMonomer monomer = monMap.get(assemble.getMonomerId());
            ProductLineDetailDTO productLineDetailDTO = productionLineMap.get(task.getProductionLineId());
            List<MesBuildingTaskNumberLink> assTasklinks = assTaskLinkMap.get(task.getId());
            TechAssemble techAssemble = assembleMap.get(task.getProductId());
            new ArrayList();
            List var72;
            if (techAssemble.getBoolProcess()) {
               var72 = assTasklinks.stream()
                  .filter(s -> !s.getBoolAssembleInproduce())
                  .map(MesBuildingTaskNumberLink::getAssembleNumber)
                  .sorted()
                  .collect(Collectors.toList());
            } else if (techAssemble.getBoolSendDirectly()) {
               var72 = assTasklinks.stream()
                  .filter(s -> assCargoMap.get(s.getAssembleId() + "_" + s.getAssembleNumber()).getBoolCanCange())
                  .map(MesBuildingTaskNumberLink::getAssembleNumber)
                  .sorted()
                  .collect(Collectors.toList());
            } else {
               var72 = assTasklinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).sorted().collect(Collectors.toList());
            }

            MesBuildingTaskCollaborativeDTO build = MesBuildingTaskCollaborativeDTO.builder()
               .taskId(task.getId())
               .taskOrderId(task.getTaskOrderId())
               .taskQuantity(task.getTaskQuantity())
               .areaId(area.getId())
               .areaName(area.getName())
               .monomerId(monomer.getId())
               .askCompleteTime(task.getAskCompleteTime())
               .monomerName(monomer.getName())
               .productId(assemble.getId())
               .structureClassId(assemble.getAssembleConfigId())
               .serialNumber(assemble.getSerialNumber())
               .specification(assemble.getSpecification())
               .length(assemble.getLength())
               .material(assemble.getMaterial())
               .quantity(assemble.getQuantity())
               .netWeight(assemble.getNetWeight())
               .grocessWeight(assemble.getGrossWeight())
               .taskQuantity(task.getTaskQuantity())
               .completeQuantity(task.getCompleteQuantity())
               .canCollaborativeQuantity(var72.size())
               .numbers(var72)
               .factoryId(productLineDetailDTO.getFactoryId())
               .factoryName(productLineDetailDTO.getFactoryName())
               .workShopId(productLineDetailDTO.getWorkshopId())
               .workShopName(productLineDetailDTO.getWorkshopName())
               .lineId(productLineDetailDTO.getProductionLineId())
               .lineName(productLineDetailDTO.getProductionLineName())
               .boolOneCode(task.getBoolOneCode())
               .build();
            if (assistTaskIds.contains(task.getId())) {
               build.setCanCollaborativeQuantity(0);
               build.setNumbers(new ArrayList<>());
            }

            collaborativeDTOS.add(build);
         }
      }

      return collaborativeDTOS;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteOrderChanges(List<Long> orderIds) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(orderIds), "操作失败!!!");
      List<MesBuildingTaskOrderChange> orderChanges = this.baseService
         .list(Wrappers.lambdaQuery(MesBuildingTaskOrderChange.class).in(MesBuildingTaskOrderChange::getOldTaskOrderId, orderIds));
      List<Long> changeIds = orderChanges.stream().map(MesBuildingTaskOrderChange::getId).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(changeIds)) {
         this.baseService.removeByIds(changeIds);
         List<MesBuildingTaskOrderChangeDetails> details = this.changeDetailsService
            .list(Wrappers.lambdaQuery(MesBuildingTaskOrderChangeDetails.class).in(MesBuildingTaskOrderChangeDetails::getChangeId, changeIds));
         if (CollectionUtils.isNotEmpty(details)) {
            List<Long> detailIds = details.stream().map(MesBuildingTaskOrderChangeDetails::getId).collect(Collectors.toList());
            this.changeDetailsService.removeByIds(detailIds);
         }
      }

      List<MesBuildingTaskOrderChangeDetails> changeDetails = this.changeDetailsService
         .list(Wrappers.lambdaQuery(MesBuildingTaskOrderChangeDetails.class).in(MesBuildingTaskOrderChangeDetails::getNewTaskOrderId, orderIds));
      if (CollectionUtils.isNotEmpty(changeDetails)) {
         List<Long> detailIds = changeDetails.stream().map(MesBuildingTaskOrderChangeDetails::getChangeId).collect(Collectors.toList());
         this.changeDetailsService.removeByIds(detailIds);
      }

      return Boolean.TRUE;
   }
}
