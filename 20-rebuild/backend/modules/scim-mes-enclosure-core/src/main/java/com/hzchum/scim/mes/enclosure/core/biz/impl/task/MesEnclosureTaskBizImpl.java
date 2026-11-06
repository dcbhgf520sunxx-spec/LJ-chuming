package com.hzchum.scim.mes.enclosure.core.biz.impl.task;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.enums.ProjectContentCategoryEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.mes.enclosure.core.api.biz.factory.MesEnclosureTeamBiz;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureTaskBiz;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureTaskOrderBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.report.ProduceTeamReportDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureProductionLine;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureTeam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureTeamUserLink;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.EnclosurePrint;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureProduceTeamReport;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTask;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTaskOrder;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.TaskProductDetailDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.CategoryProduceAnalysisDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.PlateProduceAnalysisDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.TeamProduceDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.TeamProduceDetailDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.WorkshopMonthAndMeteDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.WorkshopSummaryDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report.ProduceTeamReportDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.AppEnclosureTaskDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.EnclosureTaskPrintDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.MesEnclosureTaskOrderDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.OrderTaskAndCompleteLengthDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.PlanTreeResponseDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.ProjectTreeResponseDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.TechEnclosureDetailDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.app.AppTaskOrderSummaryDTO;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureProductionLineService;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureTeamUserLinkService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.EnclosurePrintService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureProduceTeamReportService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskOrderService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskService;
import com.hzchum.scim.mes.enclosure.core.mapper.task.MesEnclosureTaskMapper;
import com.hzchum.scim.plan.core.api.pojo._do.EnclosurePlan;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanAreaDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosurePlanDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProductDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProjectOverviewStateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProjectProduceStateDTO;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.system.core.api.common.enums.EnclosureDictionaryTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesEnclosureTaskBizImpl extends IBizImpl<MesEnclosureTaskService, MesEnclosureTaskMapper, MesEnclosureTask> implements MesEnclosureTaskBiz {
   @Value("${chum.config.url}")
   private String ip;
   @Autowired
   private MesEnclosureProduceTeamReportService teamReportService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private EnclosurePlanService enclosurePlanService;
   @Autowired
   private PlanAreaService planAreaService;
   @Autowired
   private MesEnclosureTeamUserLinkService userLinkService;
   @Resource
   private SysDictionaryService dictionaryService;
   @Autowired
   private MesEnclosureTaskOrderBiz taskOrderBiz;
   @Autowired
   private MesEnclosureTaskService enclosureTaskService;
   @Autowired
   private TechEnclosureService enclosureService;
   @Autowired
   private MesBuildingCompleteService completeService;
   @Autowired
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Autowired
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Autowired
   private MesBuildingFactoryService factoryService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesEnclosureProductionLineService lineService;
   @Autowired
   private MesEnclosureTeamBiz teamBiz;
   @Resource
   private UserService userService;
   @Autowired
   private MesEnclosureTaskOrderService taskOrderService;
   @Resource
   private MesEnclosureTeamUserLinkService teamUserLinkService;
   @Resource
   private EnclosurePrintService enclosurePrintService;

   @Override
   public List<ProjectTreeResponseDTO> getProjecTrees(Integer projectType, Integer lumpSumSystemType) {
      List<ProjectTreeResponseDTO> dtos = new ArrayList<>();
      List<Long> projectIds = this.projectService
         .listSimpleProject(projectType, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return dtos;
      }

      int i = ProjectContentCategoryEnum.STRUCTURE.getType() | ProjectContentCategoryEnum.ENCLOSURE.getType();

      for (ContractProject project : this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .in(ContractProject::getId, projectIds)
               .isNotNull(ContractProject::getEnclosureTransportMode)
               .apply(" ( product_category = 4  OR product_category = 6)")
               .orderByDesc(BaseEntity::getCreateTime)
         )) {
         ProjectTreeResponseDTO dto = BeanUtil.copy(project, ProjectTreeResponseDTO.class);
         List<EnclosurePlan> plans = this.enclosurePlanService.list(Wrappers.lambdaQuery(EnclosurePlan.class).eq(EnclosurePlan::getProjectId, project.getId()));
         if (CollectionUtils.isNotEmpty(plans)) {
            List<PlanTreeResponseDTO> children = new ArrayList<>();

            for (EnclosurePlan plan : plans) {
               PlanTreeResponseDTO copy = BeanUtil.copy(plan, PlanTreeResponseDTO.class);
               children.add(copy);
            }

            dto.setChildren(children);
         }

         dtos.add(dto);
      }

      return dtos;
   }

   @Override
   public PageVO<AppTaskOrderSummaryDTO> taskOrderPage(
      Long projectId, Long planId, String orderNumber, Integer projectType, Integer lumpSumSystemType, Integer pageNumber, Integer pageSize
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(projectType, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new PageVO<>();
      }

      List<MesEnclosureTeamUserLink> links = this.userLinkService
         .list(Wrappers.lambdaQuery(MesEnclosureTeamUserLink.class).eq(MesEnclosureTeamUserLink::getUserId, UserUtil.getCurrentUserId()));
      if (CollectionUtils.isEmpty(links)) {
         return new PageVO<>();
      }

      List<TaskProductDetailDTO> detailDTOS = this.enclosureTaskService.listAllProductDetail();
      Map<Long, TaskProductDetailDTO> detailMap = detailDTOS.stream().collect(Collectors.toMap(TaskProductDetailDTO::getTaskOrderId, Function.identity()));
      List<Long> orderIds = null;
      if (planId != null) {
         orderIds = this.baseService
            .list(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getPlanId, planId))
            .stream()
            .map(MesEnclosureTask::getTaskOrderId)
            .distinct()
            .collect(Collectors.toList());
         if (orderIds.size() == 0) {
            return new PageVO<>();
         }
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<MesEnclosureTaskOrder> orders = this.taskOrderBiz
         .list(
            Wrappers.lambdaQuery(MesEnclosureTaskOrder.class)
               .in(MesEnclosureTaskOrder::getTeamId, links.stream().map(MesEnclosureTeamUserLink::getTeamId).collect(Collectors.toList()))
               .eq(MesEnclosureTaskOrder::getBoolCompleteEnum, 0)
               .in(MesEnclosureTaskOrder::getProjectId, projectIds)
               .in(CollectionUtils.isNotEmpty(orderIds), MesEnclosureTaskOrder::getId, orderIds)
               .eq(projectId != null, MesEnclosureTaskOrder::getProjectId, projectId)
               .like(orderNumber != null, MesEnclosureTaskOrder::getOrderNumber, orderNumber)
         );
      if (CollectionUtils.isEmpty(orders)) {
         return new PageVO<>();
      }

      PageVO pageVO = new PageVO<>(orders);
      Map<Long, ContractProject> projectMap = this.projectService
         .listByIds(orders.stream().map(MesEnclosureTaskOrder::getProjectId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      List<AppTaskOrderSummaryDTO> dtos = new ArrayList<>();

      for (Object o : pageVO.getContent()) {
         MesEnclosureTaskOrder order = (MesEnclosureTaskOrder)o;
         AppTaskOrderSummaryDTO dto = BeanUtil.copy(order, AppTaskOrderSummaryDTO.class);
         TaskProductDetailDTO detail = detailMap.get(order.getId());
         dto.setQuantity(detail.getTaskQuantity() - detail.getCompleteQuantity());
         dto.setTotalLength(detail.getTotalLength());
         ContractProject project = projectMap.get(order.getProjectId());
         ProjectInfo projectInfo = BeanUtil.copy(project, ProjectInfo.class);
         dto.setProject(projectInfo);
         dtos.add(dto);
      }

      pageVO.setContent(dtos);
      return pageVO;
   }

   @Override
   public PageVO<AppTaskOrderSummaryDTO> taskOrderPageV2(Long projectId, Long areaId, String orderNumber, Integer pageNumber, Integer pageSize) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new PageVO<>();
      }

      List<MesEnclosureTeamUserLink> links = this.userLinkService
         .list(Wrappers.lambdaQuery(MesEnclosureTeamUserLink.class).eq(MesEnclosureTeamUserLink::getUserId, UserUtil.getCurrentUserId()));
      if (CollectionUtils.isEmpty(links)) {
         return new PageVO<>();
      }

      List<TaskProductDetailDTO> detailDTOS = this.enclosureTaskService.listAllProductDetail();
      Map<Long, TaskProductDetailDTO> detailMap = detailDTOS.stream().collect(Collectors.toMap(TaskProductDetailDTO::getTaskOrderId, Function.identity()));
      List<Long> orderIds = null;
      if (areaId != null) {
         orderIds = this.baseService
            .list(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getAreaId, areaId))
            .stream()
            .map(MesEnclosureTask::getTaskOrderId)
            .distinct()
            .collect(Collectors.toList());
         if (orderIds.size() == 0) {
            return new PageVO<>();
         }
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<MesEnclosureTaskOrder> orders = this.taskOrderBiz
         .list(
            Wrappers.lambdaQuery(MesEnclosureTaskOrder.class)
               .in(MesEnclosureTaskOrder::getTeamId, links.stream().map(MesEnclosureTeamUserLink::getTeamId).collect(Collectors.toList()))
               .eq(MesEnclosureTaskOrder::getBoolCompleteEnum, 0)
               .in(MesEnclosureTaskOrder::getProjectId, projectIds)
               .in(CollectionUtils.isNotEmpty(orderIds), MesEnclosureTaskOrder::getId, orderIds)
               .eq(projectId != null, MesEnclosureTaskOrder::getProjectId, projectId)
               .like(orderNumber != null, MesEnclosureTaskOrder::getOrderNumber, orderNumber)
         );
      if (CollectionUtils.isEmpty(orders)) {
         return new PageVO<>();
      }

      PageVO pageVO = new PageVO<>(orders);
      Map<Long, ContractProject> projectMap = this.projectService
         .listByIds(orders.stream().map(MesEnclosureTaskOrder::getProjectId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      List<AppTaskOrderSummaryDTO> dtos = new ArrayList<>();

      for (Object o : pageVO.getContent()) {
         MesEnclosureTaskOrder order = (MesEnclosureTaskOrder)o;
         AppTaskOrderSummaryDTO dto = BeanUtil.copy(order, AppTaskOrderSummaryDTO.class);
         TaskProductDetailDTO detail = detailMap.get(order.getId());
         dto.setQuantity(detail.getTaskQuantity() - detail.getCompleteQuantity());
         dto.setTotalLength(detail.getTotalLength());
         ContractProject project = projectMap.get(order.getProjectId());
         ProjectInfo projectInfo = BeanUtil.copy(project, ProjectInfo.class);
         dto.setProject(projectInfo);
         dtos.add(dto);
      }

      pageVO.setContent(dtos);
      return pageVO;
   }

   @Override
   public List<AppTaskOrderSummaryDTO> taskOrder(Long projectId, Long planId, String orderNumber, Integer projectType, Integer lumpSumSystemType) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(projectType, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new ArrayList<>();
      }

      List<MesEnclosureTeamUserLink> links = this.userLinkService
         .list(Wrappers.lambdaQuery(MesEnclosureTeamUserLink.class).eq(MesEnclosureTeamUserLink::getUserId, UserUtil.getCurrentUserId()));
      if (CollectionUtils.isEmpty(links)) {
         return new ArrayList<>();
      }

      List<TaskProductDetailDTO> detailDTOS = this.enclosureTaskService.listAllProductDetail();
      Map<Long, TaskProductDetailDTO> detailMap = detailDTOS.stream().collect(Collectors.toMap(TaskProductDetailDTO::getTaskOrderId, Function.identity()));
      List<MesEnclosureTaskOrder> orders = this.taskOrderBiz
         .list(
            Wrappers.lambdaQuery(MesEnclosureTaskOrder.class)
               .in(MesEnclosureTaskOrder::getTeamId, links.stream().map(MesEnclosureTeamUserLink::getTeamId).collect(Collectors.toList()))
               .eq(MesEnclosureTaskOrder::getBoolCompleteEnum, 0)
               .in(MesEnclosureTaskOrder::getProjectId, projectIds)
               .eq(projectId != null, MesEnclosureTaskOrder::getProjectId, projectId)
               .like(orderNumber != null, MesEnclosureTaskOrder::getOrderNumber, orderNumber)
         );
      if (CollectionUtils.isEmpty(orders)) {
         return new ArrayList<>();
      }

      Map<Long, ContractProject> projectMap = this.projectService
         .listByIds(orders.stream().map(MesEnclosureTaskOrder::getProjectId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      PageVO pageVO = new PageVO<>(orders);
      List<AppTaskOrderSummaryDTO> dtos = new ArrayList<>();

      for (Object o : pageVO.getContent()) {
         MesEnclosureTaskOrder order = (MesEnclosureTaskOrder)o;
         AppTaskOrderSummaryDTO dto = BeanUtil.copy(order, AppTaskOrderSummaryDTO.class);
         TaskProductDetailDTO detail = detailMap.get(order.getId());
         dto.setQuantity(detail.getTaskQuantity() - detail.getCompleteQuantity());
         dto.setTotalLength(detail.getTotalLength());
         ContractProject project = projectMap.get(order.getProjectId());
         ProjectInfo projectInfo = BeanUtil.copy(project, ProjectInfo.class);
         dto.setProject(projectInfo);
         dtos.add(dto);
      }

      return dtos;
   }

   @Override
   public PageVO<AppEnclosureTaskDTO> pageProductTaskByTaskOrderId(
      Long projectId, Long planId, String serialNumber, Long taskOrderId, Integer projectType, Integer lumpSumSystemType, Integer pageNumber, Integer pageSize
   ) {
      MesEnclosureTaskOrder order = this.taskOrderBiz.getById(taskOrderId);
      List<Long> projectIds = this.projectService
         .listSimpleProject(projectType, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new PageVO<>();
      }

      List<MesEnclosureTeamUserLink> links = this.userLinkService
         .list(Wrappers.lambdaQuery(MesEnclosureTeamUserLink.class).eq(MesEnclosureTeamUserLink::getUserId, UserUtil.getCurrentUserId()));
      if (CollectionUtils.isEmpty(links)) {
         return new PageVO<>();
      }

      Preconditions.checkArgument(order != null, "工单不存在");
      PageHelper.startPage(pageNumber, pageSize);
      List<AppEnclosureTaskDTO> dtos = this.baseService
         .listTasks(
            projectId, planId, serialNumber, taskOrderId, links.stream().map(MesEnclosureTeamUserLink::getTeamId).collect(Collectors.toList()), projectIds
         );
      PageVO pageVO = new PageVO<>(dtos);
      pageVO.setContent(dtos.stream().map(s -> s.setCanReportQuantity(s.getTaskQuantity() - s.getCompleteQuantity())).collect(Collectors.toList()));
      return pageVO;
   }

   @Override
   public PageVO<AppEnclosureTaskDTO> pageProductTaskByTaskOrderIdV2(
      Long projectId, Long areaId, String serialNumber, Long taskOrderId, Integer pageNumber, Integer pageSize
   ) {
      MesEnclosureTaskOrder order = this.taskOrderBiz.getById(taskOrderId);
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new PageVO<>();
      }

      List<MesEnclosureTeamUserLink> links = this.userLinkService
         .list(Wrappers.lambdaQuery(MesEnclosureTeamUserLink.class).eq(MesEnclosureTeamUserLink::getUserId, UserUtil.getCurrentUserId()));
      if (CollectionUtils.isEmpty(links)) {
         return new PageVO<>();
      }

      Preconditions.checkArgument(order != null, "工单不存在");
      PageHelper.startPage(pageNumber, pageSize);
      List<AppEnclosureTaskDTO> dtos = this.baseService
         .listTasksV2(
            projectId, areaId, serialNumber, taskOrderId, links.stream().map(MesEnclosureTeamUserLink::getTeamId).collect(Collectors.toList()), projectIds
         );
      PageVO pageVO = new PageVO<>(dtos);
      pageVO.setContent(dtos.stream().map(s -> s.setCanReportQuantity(s.getTaskQuantity() - s.getCompleteQuantity())).collect(Collectors.toList()));
      return pageVO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean report(Long taskId, Integer quantity) {
      MesEnclosureTask task = this.baseService.getById(taskId);
      Preconditions.checkArgument(task != null, "任务不存在!请刷新后重试");
      Preconditions.checkArgument(task.getCompleteQuantity() + quantity <= task.getTaskQuantity(), "上报数不可大于任务数!!请刷新后重试");
      MesEnclosureTeam team = this.teamBiz.getById(task.getTeamId());
      Preconditions.checkArgument(team != null, "上报失败班组不存在");
      TechEnclosure enclosure = this.enclosureService.getById(task.getProductId());
      Preconditions.checkArgument(enclosure != null, "该围护不存在,请刷新后重试");
      Preconditions.checkArgument(enclosure.getBoolStatusEnum(), "该围护已暂停不可上报");
      MesEnclosureProduceTeamReport report = MesEnclosureProduceTeamReport.builder()
         .taskOrderId(task.getTaskOrderId())
         .taskId(taskId)
         .factoryId(task.getFactoryId())
         .workshopId(task.getWorkshopId())
         .productionLineId(task.getProductionLineId())
         .teamId(task.getTeamId())
         .userId(UserUtil.getCurrentUserId())
         .productId(task.getProductId())
         .quantity(quantity)
         .price(team.getPrice())
         .processId(task.getProcessId())
         .workshopId(task.getWorkshopId())
         .productionLineId(task.getProductionLineId())
         .projectId(enclosure.getProjectId())
         .enclosurePlanId(enclosure.getEnclosurePlanId())
         .build();
      this.teamReportService.save(report);
      MesBuildingComplete complete = MesBuildingComplete.builder()
         .planId(task.getPlanId())
         .factoryId(task.getFactoryId())
         .workshopId(task.getWorkshopId())
         .productionLineId(task.getProductionLineId())
         .teamId(task.getTeamId())
         .taskTypeEnum(ProjectContentCategoryEnum.ENCLOSURE.getType())
         .userId(UserUtil.getCurrentUserId())
         .taskId(task.getId())
         .quantity(quantity)
         .productId(task.getProductId())
         .projectId(task.getProjectId())
         .boolAbnormalEnum(false)
         .build();
      this.completeService.save(complete);
      MesBuildingWarehouseRecord warehouseRecord = MesBuildingWarehouseRecord.builder()
         .projectId(task.getProjectId())
         .planId(task.getPlanId())
         .factoryId(task.getFactoryId())
         .workshopId(task.getWorkshopId())
         .productType(ProjectContentCategoryEnum.ENCLOSURE.getType())
         .userId(UserUtil.getCurrentUserId())
         .userName(UserUtil.getCurrentName())
         .quantity(BigDecimal.valueOf(quantity.intValue()))
         .productId(task.getProductId())
         .type(WarehouseTypeEnum.INTO.getType())
         .completeId(complete.getId())
         .build();
      this.warehouseRecordService.save(warehouseRecord);
      MesBuildingWarehouseSummary summary = this.warehouseSummaryService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
               .eq(MesBuildingWarehouseSummary::getWorkshopId, task.getWorkshopId())
               .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
               .eq(MesBuildingWarehouseSummary::getProductType, ProjectContentCategoryEnum.ENCLOSURE.getType())
               .eq(MesBuildingWarehouseSummary::getProductId, task.getProductId())
         );
      if (summary == null) {
         summary = MesBuildingWarehouseSummary.builder()
            .projectId(task.getProjectId())
            .planId(task.getPlanId())
            .productType(ProjectContentCategoryEnum.ENCLOSURE.getType())
            .factoryId(task.getFactoryId())
            .workshopId(task.getWorkshopId())
            .productId(task.getProductId())
            .quantity(BigDecimal.valueOf(quantity.intValue()))
            .category(task.getCategory())
            .type(WarehouseTypeEnum.INTO.getType())
            .build();
      } else {
         summary.setQuantity(summary.getQuantity().add(BigDecimal.valueOf(quantity.intValue())));
      }

      this.warehouseSummaryService.saveOrUpdate(summary);
      Preconditions.checkArgument(enclosure.getSchedulingQuantity() >= enclosure.getProducedQuantity() + quantity, "上报数不可大于排产数!请刷新后重试");
      enclosure.setProducedQuantity(enclosure.getProducedQuantity() + quantity);
      this.enclosureService.updateById(enclosure);
      task.setCompleteQuantity(task.getCompleteQuantity() + quantity);
      if (task.getCompleteQuantity().equals(task.getTaskQuantity())) {
         task.setCompleteTime(LocalDateTime.now());
         task.setBoolCompleteEnum(true);
      }

      this.baseService.updateById(task);
      MesEnclosureTaskOrder taskOrder = this.taskOrderBiz.getById(task.getTaskOrderId());
      Preconditions.checkArgument(taskOrder != null, "工单不存在!请刷新后重试");
      List<MesEnclosureTask> tasks = this.baseService
         .list(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getTaskOrderId, taskOrder.getId()));
      int size = (int)tasks.stream().filter(s -> !s.getBoolCompleteEnum()).count();
      if (size == 0) {
         taskOrder.setBoolCompleteEnum(true);
         taskOrder.setCompleteTime(LocalDateTime.now());
      }

      if (taskOrder.getInProductionTime() == null) {
         taskOrder.setInProductionTime(LocalDateTime.now());
      }

      taskOrder.setCompleteQuantity(taskOrder.getCompleteQuantity() + quantity);
      this.taskOrderBiz.updateById(taskOrder);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean reportV2(Long taskId, Integer quantity) {
      MesEnclosureTask task = this.baseService.getById(taskId);
      Preconditions.checkArgument(task != null, "任务不存在!请刷新后重试");
      Preconditions.checkArgument(task.getCompleteQuantity() + quantity <= task.getTaskQuantity(), "上报数不可大于任务数!!请刷新后重试");
      MesEnclosureTeam team = this.teamBiz.getById(task.getTeamId());
      Preconditions.checkArgument(team != null, "上报失败班组不存在");
      TechEnclosure enclosure = this.enclosureService.getById(task.getProductId());
      Preconditions.checkArgument(enclosure != null, "该围护不存在,请刷新后重试");
      Preconditions.checkArgument(enclosure.getBoolStatusEnum(), "该围护已暂停不可上报");
      MesEnclosureProduceTeamReport report = MesEnclosureProduceTeamReport.builder()
         .taskOrderId(task.getTaskOrderId())
         .taskId(taskId)
         .factoryId(task.getFactoryId())
         .workshopId(task.getWorkshopId())
         .productionLineId(task.getProductionLineId())
         .teamId(task.getTeamId())
         .userId(UserUtil.getCurrentUserId())
         .productId(task.getProductId())
         .quantity(quantity)
         .price(team.getPrice())
         .processId(task.getProcessId())
         .workshopId(task.getWorkshopId())
         .productionLineId(task.getProductionLineId())
         .projectId(enclosure.getProjectId())
         .areaId(enclosure.getAreaId())
         .build();
      this.teamReportService.save(report);
      MesBuildingComplete complete = MesBuildingComplete.builder()
         .monomerId(task.getMonomerId())
         .areaId(task.getAreaId())
         .factoryId(task.getFactoryId())
         .workshopId(task.getWorkshopId())
         .productionLineId(task.getProductionLineId())
         .teamId(task.getTeamId())
         .taskTypeEnum(ProjectContentCategoryEnum.ENCLOSURE.getType())
         .userId(UserUtil.getCurrentUserId())
         .taskId(task.getId())
         .quantity(quantity)
         .productId(task.getProductId())
         .projectId(task.getProjectId())
         .boolAbnormalEnum(false)
         .build();
      this.completeService.save(complete);
      MesBuildingWarehouseRecord warehouseRecord = MesBuildingWarehouseRecord.builder()
         .projectId(task.getProjectId())
         .monomerId(task.getMonomerId())
         .areaId(task.getAreaId())
         .factoryId(task.getFactoryId())
         .workshopId(task.getWorkshopId())
         .productType(ProjectContentCategoryEnum.ENCLOSURE.getType())
         .userId(UserUtil.getCurrentUserId())
         .userName(UserUtil.getCurrentName())
         .quantity(BigDecimal.valueOf(quantity.intValue()))
         .productId(task.getProductId())
         .type(WarehouseTypeEnum.INTO.getType())
         .completeId(complete.getId())
         .inYearMonthDayDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")))
         .build();
      this.warehouseRecordService.save(warehouseRecord);
      MesBuildingWarehouseSummary summary = this.warehouseSummaryService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
               .eq(MesBuildingWarehouseSummary::getWorkshopId, task.getWorkshopId())
               .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
               .eq(MesBuildingWarehouseSummary::getProductType, ProjectContentCategoryEnum.ENCLOSURE.getType())
               .eq(MesBuildingWarehouseSummary::getProductId, task.getProductId())
         );
      if (summary == null) {
         summary = MesBuildingWarehouseSummary.builder()
            .projectId(task.getProjectId())
            .monomerId(task.getMonomerId())
            .areaId(task.getAreaId())
            .productType(ProjectContentCategoryEnum.ENCLOSURE.getType())
            .factoryId(task.getFactoryId())
            .workshopId(task.getWorkshopId())
            .productId(task.getProductId())
            .quantity(BigDecimal.valueOf(quantity.intValue()))
            .packageQuantity(BigDecimal.ZERO)
            .cargoQuantity(BigDecimal.ZERO)
            .dictionaryId(task.getDictionaryId())
            .type(WarehouseTypeEnum.INTO.getType())
            .build();
      } else {
         summary.setQuantity(summary.getQuantity().add(BigDecimal.valueOf(quantity.intValue())));
      }

      this.warehouseSummaryService.saveOrUpdate(summary);
      Preconditions.checkArgument(enclosure.getSchedulingQuantity() >= enclosure.getProducedQuantity() + quantity, "上报数不可大于排产数!请刷新后重试");
      enclosure.setProducedQuantity(enclosure.getProducedQuantity() + quantity);
      this.enclosureService.updateById(enclosure);
      task.setCompleteQuantity(task.getCompleteQuantity() + quantity);
      if (task.getCompleteQuantity().equals(task.getTaskQuantity())) {
         task.setCompleteTime(LocalDateTime.now());
         task.setBoolCompleteEnum(true);
      }

      this.baseService.updateById(task);
      MesEnclosureTaskOrder taskOrder = this.taskOrderBiz.getById(task.getTaskOrderId());
      Preconditions.checkArgument(taskOrder != null, "工单不存在!请刷新后重试");
      List<MesEnclosureTask> tasks = this.baseService
         .list(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getTaskOrderId, taskOrder.getId()));
      int size = (int)tasks.stream().filter(s -> !s.getBoolCompleteEnum()).count();
      if (size == 0) {
         taskOrder.setBoolCompleteEnum(true);
         taskOrder.setCompleteTime(LocalDateTime.now());
      }

      if (taskOrder.getInProductionTime() == null) {
         taskOrder.setInProductionTime(LocalDateTime.now());
      }

      taskOrder.setCompleteQuantity(taskOrder.getCompleteQuantity() + quantity);
      this.taskOrderBiz.updateById(taskOrder);
      return Boolean.TRUE;
   }

   @Override
   public PageVO<ProduceTeamReportDTO> reportRecords(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long projectId,
      String serialNumber,
      Integer projectType,
      Integer lumpSumSystemType,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(projectType, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new PageVO<>();
      }

      List<MesEnclosureTeamUserLink> links = this.userLinkService
         .list(Wrappers.lambdaQuery(MesEnclosureTeamUserLink.class).eq(MesEnclosureTeamUserLink::getUserId, UserUtil.getCurrentUserId()));
      if (CollectionUtils.isEmpty(links)) {
         return new PageVO<>();
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<ProduceTeamReportDTO> dtos = this.teamReportService
         .listRecords(
            projectId, serialNumber, projectIds, links.stream().map(MesEnclosureTeamUserLink::getTeamId).collect(Collectors.toList()), startDate, endDate
         );
      return new PageVO<>(dtos);
   }

   @Override
   public PageVO<ProduceTeamReportDTO> reportRecordsV2(
      LocalDateTime startDate, LocalDateTime endDate, Long projectId, String serialNumber, Integer pageNumber, Integer pageSize
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new PageVO<>();
      }

      List<MesEnclosureTeamUserLink> links = this.userLinkService
         .list(Wrappers.lambdaQuery(MesEnclosureTeamUserLink.class).eq(MesEnclosureTeamUserLink::getUserId, UserUtil.getCurrentUserId()));
      if (CollectionUtils.isEmpty(links)) {
         return new PageVO<>();
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<ProduceTeamReportDTO> dtos = this.teamReportService
         .listRecordsV2(
            projectId, serialNumber, projectIds, links.stream().map(MesEnclosureTeamUserLink::getTeamId).collect(Collectors.toList()), startDate, endDate
         );
      return new PageVO<>(dtos);
   }

   @Override
   public Map<String, BigDecimal> reportTotal(
      LocalDateTime startDate, LocalDateTime endDate, Long projectId, String serialNumber, Integer projectType, Integer lumpSumSystemType
   ) {
      Map<String, BigDecimal> map = new HashMap<>();
      BigDecimal quantity = BigDecimal.ZERO;
      BigDecimal totalLength = BigDecimal.ZERO;
      List<Long> projectIds = this.projectService
         .listSimpleProject(projectType, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      List<MesEnclosureTeamUserLink> links = this.userLinkService
         .list(Wrappers.lambdaQuery(MesEnclosureTeamUserLink.class).eq(MesEnclosureTeamUserLink::getUserId, UserUtil.getCurrentUserId()));
      if (CollectionUtils.isNotEmpty(links) && CollectionUtils.isNotEmpty(projectIds)) {
         List<ProduceTeamReportDTO> dtos = this.teamReportService
            .listRecords(
               projectId, serialNumber, projectIds, links.stream().map(MesEnclosureTeamUserLink::getTeamId).collect(Collectors.toList()), startDate, endDate
            );
         if (CollectionUtils.isNotEmpty(dtos)) {
            quantity = BigDecimal.valueOf(dtos.stream().mapToInt(ProduceTeamReportDO::getQuantity).sum());
            totalLength = dtos.stream().map(ProduceTeamReportDO::getLength).reduce(BigDecimal::add).get();
         }
      }

      map.put("quantity", quantity);
      map.put("totalLength", totalLength);
      return map;
   }

   @Override
   public Map<String, BigDecimal> reportTotalV2(LocalDateTime startDate, LocalDateTime endDate, Long projectId, String serialNumber) {
      Map<String, BigDecimal> map = new HashMap<>();
      BigDecimal quantity = BigDecimal.ZERO;
      BigDecimal totalLength = BigDecimal.ZERO;
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      List<MesEnclosureTeamUserLink> links = this.userLinkService
         .list(Wrappers.lambdaQuery(MesEnclosureTeamUserLink.class).eq(MesEnclosureTeamUserLink::getUserId, UserUtil.getCurrentUserId()));
      if (CollectionUtils.isNotEmpty(links) && CollectionUtils.isNotEmpty(projectIds)) {
         List<ProduceTeamReportDTO> dtos = this.teamReportService
            .listRecordsV2(
               projectId, serialNumber, projectIds, links.stream().map(MesEnclosureTeamUserLink::getTeamId).collect(Collectors.toList()), startDate, endDate
            );
         if (CollectionUtils.isNotEmpty(dtos)) {
            quantity = BigDecimal.valueOf(dtos.stream().mapToInt(ProduceTeamReportDO::getQuantity).sum());
            totalLength = dtos.stream().map(ProduceTeamReportDO::getLength).reduce(BigDecimal::add).get();
         }
      }

      map.put("quantity", quantity);
      map.put("totalLength", totalLength);
      return map;
   }

   @Override
   public List<EnclosureProjectProduceStateDTO> getProjectProduce(Integer year, Integer state, String name, Integer projectType, Integer lumpSumSystemType) {
      List<EnclosureProjectProduceStateDTO> dtos = new ArrayList<>();
      List<MesEnclosureTaskOrder> orders = this.taskOrderBiz.list();
      if (CollectionUtils.isEmpty(orders)) {
         return new ArrayList<>();
      }

      List<Long> projectIds = orders.stream().map(MesEnclosureTaskOrder::getProjectId).distinct().collect(Collectors.toList());
      List<ContractProject> projects = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .in(ContractProject::getId, projectIds)
               .and(
                  name != null,
                  i -> {
                     LambdaQueryWrapper var10000 = i.like(ContractProject::getName, name)
                        .or()
                        .like(ContractProject::getShortName, name)
                        .or()
                        .like(ContractProject::getSerialNumber, name);
                  }
               )
               .apply(year != null, "year(create_time) = '" + year + "'")
         );
      List<Long> userProjectIds = this.projectService
         .listSimpleProject(projectType, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      List<ContractProject> projectList = projects.stream().filter(s -> userProjectIds.contains(s.getId())).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectList)) {
         return new ArrayList<>();
      }

      Map<Long, ContractProject> projectMap = projectList.stream().collect(Collectors.toMap(s -> s.getId(), Function.identity()));
      List<Long> ids = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      orders = orders.stream().filter(s -> ids.contains(s.getProjectId())).collect(Collectors.toList());
      Map<Long, List<MesEnclosureTaskOrder>> projectGroupMap = orders.stream().collect(Collectors.groupingBy(MesEnclosureTaskOrder::getProjectId));

      for (Long aLong : projectGroupMap.keySet()) {
         EnclosureProjectProduceStateDTO build = EnclosureProjectProduceStateDTO.builder().build();
         ContractProject project = projectMap.get(aLong);
         ProjectInfo copy = BeanUtil.copy(project, ProjectInfo.class);
         build.setProject(copy);
         List<MesEnclosureTaskOrder> orderList = projectGroupMap.get(aLong);
         long count = orderList.stream().filter(s -> !s.getBoolCompleteEnum()).count();
         build.setStatus(count > 0L ? 1 : 2);
         dtos.add(build);
      }

      if (state != null) {
         dtos = dtos.stream().filter(s -> s.getStatus().equals(state)).collect(Collectors.toList());
      }

      return dtos.stream().sorted(Comparator.comparing(EnclosureProjectProduceStateDTO::getStatus)).collect(Collectors.toList());
   }

   @Override
   public PageVO<MesEnclosureTaskOrderDTO> getOrders(String orderNumber, Long projectId, String userName, Integer pageNumber, Integer pageSize) {
      List<MesEnclosureTeamUserLink> list = this.teamUserLinkService
         .list(Wrappers.lambdaQuery(MesEnclosureTeamUserLink.class).eq(MesEnclosureTeamUserLink::getBoolLeaderEnum, 1));
      Map<Long, String> teamLeaderMap = list.stream().collect(Collectors.toMap(MesEnclosureTeamUserLink::getTeamId, MesEnclosureTeamUserLink::getUserName));
      PageHelper.startPage(pageNumber, pageSize);
      List<MesEnclosureTaskOrderDTO> dtos = this.taskOrderService.getOrders(orderNumber, projectId, userName);
      if (CollectionUtils.isEmpty(dtos)) {
         return new PageVO<>();
      }

      dtos = dtos.stream()
         .map(s -> s.setBooleanProduce(s.getInProductionTime() != null))
         .map(s -> s.setLeaderName(teamLeaderMap.get(s.getTeamId())))
         .collect(Collectors.toList());
      List<Long> orderIds = dtos.stream().map(MesEnclosureTaskOrderDTO::getId).collect(Collectors.toList());
      List<OrderTaskAndCompleteLengthDTO> dtoList = this.taskOrderService.getTaskAndCompLength(orderIds);
      Map<Long, OrderTaskAndCompleteLengthDTO> ordMap = dtoList.stream().collect(Collectors.toMap(OrderTaskAndCompleteLengthDTO::getId, Function.identity()));

      for (MesEnclosureTaskOrderDTO dto : dtos) {
         OrderTaskAndCompleteLengthDTO length = ordMap.get(dto.getId());
         dto.setBooleanProduce(dto.getInProductionTime() != null);
         dto.setLeaderName(teamLeaderMap.get(dto.getTeamId()));
         dto.setTotalLength(length.getTaskLength());
         dto.setCompleteLength(length.getCompeteLength());
         if (dto.getCompleteTime() != null) {
            if (Long.parseLong(dto.getCompleteTime().format(DateTimeFormatter.ofPattern("yyyyMMdd")))
               <= Long.parseLong(dto.getAskCompleteTime().format(DateTimeFormatter.ofPattern("yyyyMMdd")))) {
               dto.setBooleanlag(1);
            } else {
               dto.setBooleanlag(0);
            }
         } else if (Long.parseLong(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")))
            <= Long.parseLong(dto.getAskCompleteTime().format(DateTimeFormatter.ofPattern("yyyyMMdd")))) {
            dto.setBooleanlag(1);
         } else {
            dto.setBooleanlag(0);
         }
      }

      return new PageVO<>(dtos);
   }

   @Override
   public PageVO<TechEnclosureDetailDTO> orderDetail(Long id) {
      List<MesEnclosureTask> enclosureTasks = this.enclosureTaskService
         .list(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getTaskOrderId, id));
      if (org.apache.commons.collections4.CollectionUtils.isEmpty(enclosureTasks)) {
         return new PageVO<>();
      }

      List<TechEnclosure> enclosureList = this.enclosureService
         .listByIds(enclosureTasks.stream().map(MesEnclosureTask::getProductId).collect(Collectors.toList()));
      Map<Long, TechEnclosure> enclosureMap = enclosureList.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity(), (s1, s2) -> s1));
      Map<Long, EnclosurePlan> planMap = this.enclosurePlanService
         .listByIds(enclosureList.stream().map(TechEnclosure::getEnclosurePlanId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(EnclosurePlan::getId, Function.identity()));
      Map<Long, ContractProject> projectMap = this.projectService
         .listByIds(enclosureList.stream().map(TechEnclosure::getProjectId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      List<TechEnclosureDetailDTO> dtos = new ArrayList<>();
      Map<Long, String> userMap = this.userService
         .list(Wrappers.lambdaQuery(User.class).in(User::getId, enclosureList.stream().map(TechEnclosure::getUserId).collect(Collectors.toList())))
         .stream()
         .collect(Collectors.toMap(User::getId, User::getName));

      for (MesEnclosureTask task : enclosureTasks) {
         TechEnclosure techEnclosure = enclosureMap.get(task.getProductId());
         Preconditions.checkArgument(techEnclosure != null, "查询失败,请刷新后重试");
         TechEnclosureDetailDTO dto = BeanUtil.copy(techEnclosure, TechEnclosureDetailDTO.class);
         dto.setId(task.getProductId());
         dto.setPlanId(task.getPlanId());
         dto.setPlanName(planMap.get(task.getPlanId()).getName());
         dto.setQuantity(task.getTaskQuantity());
         dto.setTotalLength(dto.getLength().multiply(new BigDecimal(task.getTaskQuantity())));
         dto.setAskCompleteTime(task.getAskCompleteTime());
         dto.setUserName(userMap.get(techEnclosure.getUserId()));
         dto.setCompleteQuantity(task.getCompleteQuantity());
         dto.setCompleteTime(task.getCompleteTime());
         dto.setCompleteLength(dto.getLength().multiply(new BigDecimal(dto.getCompleteQuantity())));
         if (dto.getCompleteTime() != null) {
            if (Long.parseLong(dto.getCompleteTime().format(DateTimeFormatter.ofPattern("yyyyMMdd")))
               <= Long.parseLong(dto.getAskCompleteTime().format(DateTimeFormatter.ofPattern("yyyyMMdd")))) {
               dto.setBooleanlag(1);
            } else {
               dto.setBooleanlag(0);
            }
         } else if (Long.parseLong(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")))
            <= Long.parseLong(dto.getAskCompleteTime().format(DateTimeFormatter.ofPattern("yyyyMMdd")))) {
            dto.setBooleanlag(1);
         } else {
            dto.setBooleanlag(0);
         }

         dtos.add(dto);
      }

      List<TechEnclosureDetailDTO> collect = dtos.stream()
         .sorted(Comparator.comparing(TechEnclosureDetailDTO::getCompleteQuantity).thenComparing(TechEnclosureDetailDTO::getBooleanlag))
         .collect(Collectors.toList());
      return new PageVO<>(collect);
   }

   @Override
   public PageVO<TechEnclosureDetailDTO> orderDetailV2(Long id) {
      List<MesEnclosureTask> enclosureTasks = this.enclosureTaskService
         .list(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getTaskOrderId, id));
      if (org.apache.commons.collections4.CollectionUtils.isEmpty(enclosureTasks)) {
         return new PageVO<>();
      }

      List<TechEnclosure> enclosureList = this.enclosureService
         .listByIds(enclosureTasks.stream().map(MesEnclosureTask::getProductId).collect(Collectors.toList()));
      Map<Long, TechEnclosure> enclosureMap = enclosureList.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity(), (s1, s2) -> s1));
      Map<Long, PlanArea> areaMap = this.planAreaService
         .listByIds(enclosureList.stream().map(TechEnclosure::getAreaId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(PlanArea::getId, Function.identity()));
      List<TechEnclosureDetailDTO> dtos = new ArrayList<>();
      Map<Long, String> userMap = this.userService
         .list(Wrappers.lambdaQuery(User.class).in(User::getId, enclosureList.stream().map(TechEnclosure::getUserId).collect(Collectors.toList())))
         .stream()
         .collect(Collectors.toMap(User::getId, User::getName));

      for (MesEnclosureTask task : enclosureTasks) {
         TechEnclosure techEnclosure = enclosureMap.get(task.getProductId());
         Preconditions.checkArgument(techEnclosure != null, "查询失败,请刷新后重试");
         TechEnclosureDetailDTO dto = BeanUtil.copy(techEnclosure, TechEnclosureDetailDTO.class);
         dto.setId(task.getProductId());
         dto.setAreaId(task.getAreaId());
         dto.setAreaName(areaMap.get(task.getAreaId()).getName());
         dto.setQuantity(task.getTaskQuantity());
         dto.setTotalLength(dto.getLength().multiply(new BigDecimal(task.getTaskQuantity())));
         dto.setAskCompleteTime(task.getAskCompleteTime());
         dto.setUserName(userMap.get(techEnclosure.getUserId()));
         dto.setCompleteQuantity(task.getCompleteQuantity());
         dto.setCompleteTime(task.getCompleteTime());
         dto.setCompleteLength(dto.getLength().multiply(new BigDecimal(dto.getCompleteQuantity())));
         if (dto.getCompleteTime() != null) {
            if (Long.parseLong(dto.getCompleteTime().format(DateTimeFormatter.ofPattern("yyyyMMdd")))
               <= Long.parseLong(dto.getAskCompleteTime().format(DateTimeFormatter.ofPattern("yyyyMMdd")))) {
               dto.setBooleanlag(1);
            } else {
               dto.setBooleanlag(0);
            }
         } else if (Long.parseLong(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")))
            <= Long.parseLong(dto.getAskCompleteTime().format(DateTimeFormatter.ofPattern("yyyyMMdd")))) {
            dto.setBooleanlag(1);
         } else {
            dto.setBooleanlag(0);
         }

         dtos.add(dto);
      }

      List<TechEnclosureDetailDTO> collect = dtos.stream()
         .sorted(Comparator.comparing(TechEnclosureDetailDTO::getCompleteQuantity).thenComparing(TechEnclosureDetailDTO::getBooleanlag))
         .collect(Collectors.toList());
      return new PageVO<>(collect);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> orderDetailPrint(Long id) {
      MesEnclosureTaskOrder order = this.taskOrderBiz.getById(id);
      Preconditions.checkArgument(order != null, "工单不存在请刷新后重试");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ContractProject project = this.projectService.getById(order.getProjectId());
      ProjectInfo projectInfo = BeanUtil.copy(project, ProjectInfo.class);
      header.put("orderNumber", order.getOrderNumber());
      header.put("projectInfo", projectInfo);
      header.put("factoryId", order.getFactoryId());
      header.put("workshopId", order.getWorkshopId());
      header.put("lineId", order.getProductionLineId());
      header.put("teamId", order.getTeamId());
      MesBuildingFactory factory = this.factoryService.getById(order.getFactoryId());
      header.put("factoryName", factory.getName());
      MesBuildingWorkshop workshop = this.workshopService.getById(order.getWorkshopId());
      header.put("workshopName", workshop.getName());
      MesEnclosureProductionLine line = this.lineService.getById(order.getProductionLineId());
      String userName = this.teamUserLinkService
         .getOne(
            Wrappers.lambdaQuery(MesEnclosureTeamUserLink.class)
               .eq(MesEnclosureTeamUserLink::getTeamId, order.getTeamId())
               .eq(MesEnclosureTeamUserLink::getBoolLeaderEnum, 1)
         )
         .getUserName();
      header.put("lineName", line.getName() + " / " + userName);
      printVO.setHeader(header);
      List<MesEnclosureTask> enclosureTasks = this.enclosureTaskService
         .list(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getTaskOrderId, id));
      if (CollectionUtils.isNotEmpty(enclosureTasks)) {
         List<TechEnclosure> enclosureList = this.enclosureService
            .listByIds(enclosureTasks.stream().map(MesEnclosureTask::getProductId).collect(Collectors.toList()));
         Map<Long, TechEnclosure> enclosureMap = enclosureList.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity(), (s1, s2) -> s1));
         Map<Long, EnclosurePlan> planMap = this.enclosurePlanService
            .listByIds(enclosureList.stream().map(TechEnclosure::getEnclosurePlanId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(EnclosurePlan::getId, Function.identity()));
         Map<Long, ContractProject> projectMap = this.projectService
            .listByIds(enclosureList.stream().map(TechEnclosure::getProjectId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
         List<TechEnclosureDetailDTO> dtos = new ArrayList<>();
         Map<Long, String> userMap = this.userService
            .list(Wrappers.lambdaQuery(User.class).in(User::getId, enclosureList.stream().map(TechEnclosure::getUserId).collect(Collectors.toList())))
            .stream()
            .collect(Collectors.toMap(User::getId, User::getName));

         for (MesEnclosureTask task : enclosureTasks) {
            TechEnclosure techEnclosure = enclosureMap.get(task.getProductId());
            Preconditions.checkArgument(techEnclosure != null, "查询失败,请刷新后重试");
            TechEnclosureDetailDTO dto = BeanUtil.copy(techEnclosure, TechEnclosureDetailDTO.class);
            dto.setId(task.getProductId());
            dto.setPlanId(task.getPlanId());
            dto.setPlanName(planMap.get(task.getPlanId()).getName());
            dto.setQuantity(task.getTaskQuantity());
            dto.setTotalLength(dto.getLength().multiply(new BigDecimal(task.getTaskQuantity())));
            dto.setAskCompleteTime(task.getAskCompleteTime());
            dto.setUserName(userMap.get(techEnclosure.getUserId()));
            dto.setCompleteQuantity(task.getCompleteQuantity());
            dto.setCompleteTime(task.getCompleteTime());
            dto.setCompleteLength(dto.getLength().multiply(new BigDecimal(dto.getCompleteQuantity())));
            if (dto.getCompleteTime() != null) {
               if (dto.getCompleteTime().isBefore(dto.getAskCompleteTime())) {
                  dto.setBooleanlag(0);
               } else {
                  dto.setBooleanlag(1);
               }
            } else if (LocalDateTime.now().isBefore(dto.getAskCompleteTime())) {
               dto.setBooleanlag(0);
            } else {
               dto.setBooleanlag(1);
            }

            dtos.add(dto);
         }

         printVO.setTable(dtos.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      }

      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> orderDetailPrintV2(Long id) {
      MesEnclosureTaskOrder order = this.taskOrderBiz.getById(id);
      Preconditions.checkArgument(order != null, "工单不存在请刷新后重试");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ContractProject project = this.projectService.getById(order.getProjectId());
      ProjectInfo projectInfo = BeanUtil.copy(project, ProjectInfo.class);
      header.put("orderNumber", order.getOrderNumber());
      header.put("projectInfo", projectInfo);
      header.put("factoryId", order.getFactoryId());
      header.put("workshopId", order.getWorkshopId());
      header.put("lineId", order.getProductionLineId());
      header.put("teamId", order.getTeamId());
      MesBuildingFactory factory = this.factoryService.getById(order.getFactoryId());
      header.put("factoryName", factory.getName());
      MesBuildingWorkshop workshop = this.workshopService.getById(order.getWorkshopId());
      header.put("workshopName", workshop.getName());
      MesEnclosureProductionLine line = this.lineService.getById(order.getProductionLineId());
      String userName = this.teamUserLinkService
         .getOne(
            Wrappers.lambdaQuery(MesEnclosureTeamUserLink.class)
               .eq(MesEnclosureTeamUserLink::getTeamId, order.getTeamId())
               .eq(MesEnclosureTeamUserLink::getBoolLeaderEnum, 1)
         )
         .getUserName();
      header.put("lineName", line.getName() + " / " + userName);
      printVO.setHeader(header);
      List<MesEnclosureTask> enclosureTasks = this.enclosureTaskService
         .list(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getTaskOrderId, id));
      if (CollectionUtils.isNotEmpty(enclosureTasks)) {
         List<TechEnclosure> enclosureList = this.enclosureService
            .listByIds(enclosureTasks.stream().map(MesEnclosureTask::getProductId).collect(Collectors.toList()));
         Map<Long, TechEnclosure> enclosureMap = enclosureList.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity(), (s1, s2) -> s1));
         Map<Long, PlanArea> areaMap = this.planAreaService
            .listByIds(enclosureList.stream().map(TechEnclosure::getAreaId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(PlanArea::getId, Function.identity()));
         List<TechEnclosureDetailDTO> dtos = new ArrayList<>();
         Map<Long, String> userMap = this.userService
            .list(Wrappers.lambdaQuery(User.class).in(User::getId, enclosureList.stream().map(TechEnclosure::getUserId).collect(Collectors.toList())))
            .stream()
            .collect(Collectors.toMap(User::getId, User::getName));

         for (MesEnclosureTask task : enclosureTasks) {
            TechEnclosure techEnclosure = enclosureMap.get(task.getProductId());
            Preconditions.checkArgument(techEnclosure != null, "查询失败,请刷新后重试");
            TechEnclosureDetailDTO dto = BeanUtil.copy(techEnclosure, TechEnclosureDetailDTO.class);
            dto.setId(task.getProductId());
            dto.setAreaId(task.getAreaId());
            dto.setAreaName(areaMap.get(task.getAreaId()).getName());
            dto.setQuantity(task.getTaskQuantity());
            dto.setTotalLength(dto.getLength().multiply(new BigDecimal(task.getTaskQuantity())));
            dto.setAskCompleteTime(task.getAskCompleteTime());
            dto.setUserName(userMap.get(techEnclosure.getUserId()));
            dto.setCompleteQuantity(task.getCompleteQuantity());
            dto.setCompleteTime(task.getCompleteTime());
            dto.setCompleteLength(dto.getLength().multiply(new BigDecimal(dto.getCompleteQuantity())));
            if (dto.getCompleteTime() != null) {
               if (dto.getCompleteTime().isBefore(dto.getAskCompleteTime())) {
                  dto.setBooleanlag(1);
               } else {
                  dto.setBooleanlag(0);
               }
            } else if (LocalDateTime.now().isBefore(dto.getAskCompleteTime())) {
               dto.setBooleanlag(1);
            } else {
               dto.setBooleanlag(0);
            }

            dtos.add(dto);
         }

         printVO.setTable(dtos.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      }

      return printVO;
   }

   @Override
   public List<EnclosureProjectOverviewStateDTO> getProjectOverview(Integer year, Integer state, String name, Integer projectType, Integer lumpSumSystemType) {
      List<ContractProject> projects = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .apply(year != null, "year(create_time) = '" + year + "'")
               .and(
                  name != null,
                  i -> {
                     LambdaQueryWrapper var10000 = i.like(ContractProject::getName, name)
                        .or()
                        .like(ContractProject::getShortName, name)
                        .or()
                        .like(ContractProject::getSerialNumber, name);
                  }
               )
         );
      List<Long> userProjectIds = this.projectService
         .listSimpleProject(projectType, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      projects = projects.stream().filter(s -> userProjectIds.contains(s.getId())).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projects)) {
         return new ArrayList<>();
      }

      List<EnclosureProjectOverviewStateDTO> dtos = this.enclosureService
         .getProjectOverview(projects.stream().map(ContractProject::getId).collect(Collectors.toList()));

      for (EnclosureProjectOverviewStateDTO dto : dtos) {
         if (dto.getTotalQuantity() > dto.getTotalCompleteQuantity()) {
            dto.setStatus(1);
         } else {
            dto.setStatus(2);
         }
      }

      if (state != null) {
         dtos = dtos.stream().filter(s -> s.getStatus().equals(state)).collect(Collectors.toList());
      } else {
         dtos = dtos.stream().sorted(Comparator.comparing(EnclosureProjectOverviewStateDTO::getStatus)).collect(Collectors.toList());
      }

      return dtos;
   }

   @Override
   public List<Integer> getProjectCategory(Long projectId) {
      List<TechEnclosure> techEnclosures = this.enclosureService.list(Wrappers.lambdaQuery(TechEnclosure.class).eq(TechEnclosure::getProjectId, projectId));
      return CollectionUtils.isEmpty(techEnclosures)
         ? new ArrayList<>()
         : techEnclosures.stream().map(TechEnclosure::getCategory).distinct().collect(Collectors.toList());
   }

   @Override
   public Map<Long, String> getProjectCategoryV2(Long projectId, List<Long> areaIds) {
      List<TechEnclosure> techEnclosures = this.enclosureService
         .list(
            Wrappers.lambdaQuery(TechEnclosure.class)
               .eq(projectId != null, TechEnclosure::getProjectId, projectId)
               .in(CollectionUtils.isNotEmpty(areaIds), TechEnclosure::getAreaId, areaIds)
         );
      if (CollectionUtils.isEmpty(techEnclosures)) {
         return new HashMap<>();
      }

      List<Long> idsList = techEnclosures.stream().map(s -> s.getDictionaryId()).collect(Collectors.toList());
      List<SysDictionary> sysDictionaries = this.dictionaryService.listByName("enclosure_type");
      Map<Long, String> enclosureDictMap = sysDictionaries.stream().collect(Collectors.toMap(e -> e.getId(), s -> s.getLabel()));
      return enclosureDictMap.entrySet()
         .stream()
         .filter(entry -> idsList.contains(entry.getKey()))
         .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
   }

   @Override
   public List<EnclosurePlanDTO> getPlan(Long projectId, Integer category) {
      List<EnclosurePlanDTO> dtos = new ArrayList<>();
      List<TechEnclosure> techEnclosures = this.enclosureService
         .list(Wrappers.lambdaQuery(TechEnclosure.class).eq(TechEnclosure::getProjectId, projectId).eq(category != null, TechEnclosure::getCategory, category));
      if (CollectionUtils.isEmpty(techEnclosures)) {
         return new ArrayList<>();
      }

      List<Long> planIds = techEnclosures.stream().map(TechEnclosure::getEnclosurePlanId).distinct().collect(Collectors.toList());

      for (EnclosurePlan plan : this.enclosurePlanService.listByIds(planIds)) {
         EnclosurePlanDTO copy = BeanUtil.copy(plan, EnclosurePlanDTO.class);
         copy.setProjectId(projectId);
         dtos.add(copy);
      }

      return dtos;
   }

   @Override
   public List<PlanAreaDTO> getArea(Long projectId, Long dictionaryId) {
      List<PlanAreaDTO> dtos = new ArrayList<>();
      List<TechEnclosure> techEnclosures = this.enclosureService
         .list(
            Wrappers.lambdaQuery(TechEnclosure.class)
               .eq(TechEnclosure::getProjectId, projectId)
               .eq(dictionaryId != null, TechEnclosure::getDictionaryId, dictionaryId)
         );
      if (CollectionUtils.isEmpty(techEnclosures)) {
         return new ArrayList<>();
      }

      List<Long> areaIds = techEnclosures.stream().map(TechEnclosure::getAreaId).distinct().collect(Collectors.toList());

      for (PlanArea area : this.planAreaService.listByIds(areaIds)) {
         PlanAreaDTO copy = BeanUtil.copy(area, PlanAreaDTO.class);
         dtos.add(copy);
      }

      return dtos;
   }

   @Override
   public PageVO<EnclosureProductDetailDTO> getproductDetaile(List<Long> planIds, Integer status, Integer category, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<EnclosureProductDetailDTO> dtos = this.enclosureService.getproductDetaile(planIds, status, category);

      for (EnclosureProductDetailDTO dto : dtos) {
         if (dto.getQuantity().equals(dto.getProducedQuantity())) {
            dto.setStatus(4);
         }

         if (dto.getProducedQuantity().equals(0)) {
            dto.setStatus(1);
         } else {
            dto.setStatus(2);
         }
      }

      return new PageVO<>(dtos);
   }

   @Override
   public PageVO<EnclosureProductDetailDTO> getproductDetaileV2(List<Long> areaIds, Integer status, Long dictionaryId, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<EnclosureProductDetailDTO> dtos = this.enclosureService.getproductDetaileV2(areaIds, status, dictionaryId);

      for (EnclosureProductDetailDTO dto : dtos) {
         if (dto.getQuantity().equals(dto.getProducedQuantity())) {
            dto.setStatus(4);
         }

         if (dto.getProducedQuantity().equals(0)) {
            dto.setStatus(1);
         } else {
            dto.setStatus(2);
         }
      }

      return new PageVO<>(dtos);
   }

   @Override
   public Map getproductTotal(Long projectId, List<Long> planIds, Integer category) {
      Map<String, BigDecimal> map = new HashMap<>();
      BigDecimal totalLength = BigDecimal.ZERO;
      BigDecimal completedLength = BigDecimal.ZERO;
      List<TechEnclosure> list = this.enclosureService
         .list(
            Wrappers.lambdaQuery(TechEnclosure.class)
               .eq(TechEnclosure::getProjectId, projectId)
               .in(planIds != null, TechEnclosure::getEnclosurePlanId, planIds)
               .eq(category != null, TechEnclosure::getCategory, category)
         );
      if (CollectionUtils.isNotEmpty(list)) {
         totalLength = list.stream().map(s -> s.getLength().multiply(new BigDecimal(s.getQuantity()))).reduce(BigDecimal::add).get();
         completedLength = list.stream().map(s -> s.getLength().multiply(new BigDecimal(s.getProducedQuantity()))).reduce(BigDecimal::add).get();
      }

      map.put("totalLength", totalLength.divide(new BigDecimal(1000)));
      map.put("completedLength", completedLength.divide(new BigDecimal(1000)));
      return map;
   }

   @Override
   public Map getProductTotalV2(Long projectId, List<Long> areaIds, Long dictionaryId) {
      Map<String, BigDecimal> map = new HashMap<>();
      BigDecimal totalLength = BigDecimal.ZERO;
      BigDecimal completedLength = BigDecimal.ZERO;
      List<TechEnclosure> list = this.enclosureService
         .list(
            Wrappers.lambdaQuery(TechEnclosure.class)
               .eq(TechEnclosure::getProjectId, projectId)
               .in(areaIds != null, TechEnclosure::getAreaId, areaIds)
               .eq(dictionaryId != null, TechEnclosure::getDictionaryId, dictionaryId)
         );
      if (CollectionUtils.isNotEmpty(list)) {
         totalLength = list.stream().map(s -> s.getLength().multiply(new BigDecimal(s.getQuantity()))).reduce(BigDecimal::add).get();
         completedLength = list.stream().map(s -> s.getLength().multiply(new BigDecimal(s.getProducedQuantity()))).reduce(BigDecimal::add).get();
      }

      map.put("totalLength", totalLength.divide(new BigDecimal(1000)));
      map.put("completedLength", completedLength.divide(new BigDecimal(1000)));
      return map;
   }

   @Override
   public List<WorkshopMonthAndMeteDTO> getYearList(LocalDateTime dateTime, Integer type, Integer category) {
      return this.baseMapper.getYearList(dateTime, type, category);
   }

   @Override
   public List<WorkshopMonthAndMeteDTO> getYearListV2(LocalDateTime dateTime, Integer type, Integer dictionaryId) {
      return this.baseMapper.getYearListV2(dateTime, type, dictionaryId);
   }

   @Override
   public PageVO<WorkshopSummaryDTO> getOverviewDetail(
      LocalDateTime startTime, LocalDateTime endTime, Long projectId, Integer category, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<WorkshopSummaryDTO> dtos = this.baseMapper.getOverviewDetail(startTime, endTime, projectId, category);
      return new PageVO<>(dtos);
   }

   @Override
   public PageVO<WorkshopSummaryDTO> getOverviewDetailV2(
      LocalDateTime startTime, LocalDateTime endTime, Long projectId, Long dictionaryId, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<WorkshopSummaryDTO> dtos = this.baseMapper.getOverviewDetailV2(startTime, endTime, projectId, dictionaryId);
      return new PageVO<>(dtos);
   }

   @Override
   public BigDecimal getOverviewTotal(LocalDateTime time, Integer category) {
      return this.baseMapper.getOverviewTotal(time, category);
   }

   @Override
   public BigDecimal getOverviewTotalV2(LocalDateTime time, Integer category) {
      return this.baseMapper.getOverviewTotalV2(time, category);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getOverviewDetailPrint(LocalDateTime startTime, LocalDateTime endTime, Long projectId, Integer category) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("time", startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "-" + endTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
      header.put("category", EnclosureDictionaryTypeEnum.getNameByType(category));
      List<WorkshopSummaryDTO> dtos = this.baseMapper.getOverviewDetail(startTime, endTime, projectId, category);
      BigDecimal totalLengthSum = Optional.ofNullable(dtos)
         .filter(CollUtil::isNotEmpty)
         .map(m -> m.stream().map(WorkshopSummaryDTO::getTotalLength).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add))
         .orElse(BigDecimal.ZERO);
      header.put("totalLengthSum", totalLengthSum);
      printVO.setHeader(header);
      printVO.setTable(dtos.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getOverviewDetailPrintV2(LocalDateTime startTime, LocalDateTime endTime, Long projectId, Long dictionaryId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("time", startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "-" + endTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
      List<SysDictionary> sysDictionaries = this.dictionaryService.listByName("enclosure_type");
      Map<Long, String> enclosureDictMap = sysDictionaries.stream().collect(Collectors.toMap(e -> e.getId(), s -> s.getLabel()));
      header.put("dictionaryName", enclosureDictMap.get(dictionaryId));
      printVO.setHeader(header);
      List<WorkshopSummaryDTO> dtos = this.baseMapper.getOverviewDetailV2(startTime, endTime, projectId, dictionaryId);
      printVO.setTable(dtos.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public PageVO<TeamProduceDTO> getTeamProduce(
      LocalDateTime startTime,
      LocalDateTime endTime,
      Long projectId,
      LocalDateTime category,
      Integer projectType,
      Integer lumpSumSystemType,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> userProjectIds = this.projectService
         .listSimpleProject(projectType, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(userProjectIds)) {
         return new PageVO<>();
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<TeamProduceDTO> dtos = this.baseMapper.getTeamProduce(projectId, userProjectIds, category, startTime, endTime);
      PageVO<TeamProduceDTO> pageVO = new PageVO<>(dtos);
      List<Long> teamIds = dtos.stream().map(TeamProduceDTO::getTeamId).distinct().collect(Collectors.toList());
      List<IdAndNameDO> idAndNameDOS = this.teamBiz.listNameByIds(teamIds);
      Map<Long, String> nameMap = idAndNameDOS.stream().collect(Collectors.toMap(IdAndNameDO::getId, IdAndNameDO::getName));

      for (TeamProduceDTO dto : pageVO.getContent()) {
         dto.setLeaderName(nameMap.get(dto.getTeamId()));
      }

      return pageVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getTeamProducePrint(
      LocalDateTime startTime, LocalDateTime endTime, Long projectId, LocalDateTime category, Integer projectType, Integer lumpSumSystemType
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (projectId != null) {
         ContractProject project = this.projectService.getById(projectId);
         ProjectInfo copy = BeanUtil.copy(project, ProjectInfo.class);
         header.put("project", copy);
      }

      header.put("category", category);
      if (startTime != null && endTime != null) {
         header.put("time", startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "/" + endTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
      } else {
         header.put("time", "全部");
      }

      List<Long> userProjectIds = this.projectService
         .listSimpleProject(projectType, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      List<TeamProduceDTO> dtos = this.baseMapper.getTeamProduce(projectId, userProjectIds, category, startTime, endTime);
      List<Long> teamIds = dtos.stream().map(TeamProduceDTO::getTeamId).distinct().collect(Collectors.toList());
      List<IdAndNameDO> idAndNameDOS = this.teamBiz.listNameByIds(teamIds);
      Map<Long, String> nameMap = idAndNameDOS.stream().collect(Collectors.toMap(IdAndNameDO::getId, IdAndNameDO::getName));

      for (TeamProduceDTO dto : dtos) {
         dto.setLeaderName(nameMap.get(dto.getTeamId()));
      }

      BigDecimal totalLengthSum = Optional.ofNullable(dtos)
         .filter(CollUtil::isNotEmpty)
         .map(m -> m.stream().map(TeamProduceDTO::getTotalLength).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add))
         .orElse(BigDecimal.ZERO);
      header.put("totalLengthSum", totalLengthSum);
      BigDecimal totalAmount = Optional.ofNullable(dtos)
         .filter(CollUtil::isNotEmpty)
         .map(
            m -> m.stream()
               .map(sm -> ObjectUtil.defaultIfNull(sm.getTotalLength(), BigDecimal.ZERO).multiply(ObjectUtil.defaultIfNull(sm.getPrice(), BigDecimal.ZERO)))
               .reduce(BigDecimal.ZERO, BigDecimal::add)
         )
         .orElse(BigDecimal.ZERO);
      header.put("totalAmount", totalAmount);
      printVO.setHeader(header);
      printVO.setTable(dtos.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public PageVO<TeamProduceDetailDTO> getTeamProduceDetail(
      LocalDateTime startTime,
      LocalDateTime endTime,
      BigDecimal price,
      Long projectId,
      Long teamId,
      Long lineId,
      LocalDateTime category,
      Integer projectType,
      Integer lumpSumSystemType,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(projectType, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new PageVO<>();
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<TeamProduceDetailDTO> dtos = this.teamReportService.listDetail(startTime, endTime, price, projectId, teamId, lineId, projectIds, category);
      return new PageVO<>(dtos);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getTeamProduceDetailPrint(
      LocalDateTime startTime,
      LocalDateTime endTime,
      BigDecimal price,
      Long projectId,
      Long teamId,
      Long lineId,
      LocalDateTime category,
      Integer projectType,
      Integer lumpSumSystemType
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (projectId != null) {
         ContractProject project = this.projectService.getById(projectId);
         ProjectInfo copy = BeanUtil.copy(project, ProjectInfo.class);
         header.put("project", copy);
      }

      header.put("category", category);
      if (startTime != null && endTime != null) {
         header.put("time", startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "/" + endTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
      } else {
         header.put("time", "全部");
      }

      MesEnclosureProductionLine line = this.lineService.getLineById(lineId);
      MesBuildingWorkshop workshop = this.workshopService.getWorkshopById(line.getWorkshopId());
      MesEnclosureTeamUserLink userLink = this.userLinkService
         .getOne(
            Wrappers.lambdaQuery(MesEnclosureTeamUserLink.class)
               .eq(MesEnclosureTeamUserLink::getTeamId, teamId)
               .eq(MesEnclosureTeamUserLink::getBoolLeaderEnum, 1)
         );
      User user = this.userService.getById(userLink.getUserId());
      header.put("workshop", workshop.getName());
      header.put("line", line.getName());
      header.put("teamLeader", user.getName());
      printVO.setHeader(header);
      List<Long> projectIds = this.projectService
         .listSimpleProject(projectType, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return printVO;
      }

      List<TeamProduceDetailDTO> dtos = this.teamReportService.listDetail(startTime, endTime, price, projectId, teamId, lineId, projectIds, category);
      printVO.setTable(dtos.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public List<CategoryProduceAnalysisDTO> produceAnalysis(LocalDateTime startTime, LocalDateTime endTime, Long projectId) {
      List<CategoryProduceAnalysisDTO> dtos = this.teamReportService.produceAnalysis(startTime, endTime, projectId);
      if (CollectionUtils.isEmpty(dtos)) {
         return new ArrayList<>();
      }

      dtos = dtos.stream().map(s -> s.setCompleteLength(s.getCompleteLength().divide(new BigDecimal(1000)))).collect(Collectors.toList());
      BigDecimal total = dtos.stream().map(CategoryProduceAnalysisDTO::getCompleteLength).reduce(BigDecimal::add).get();

      for (CategoryProduceAnalysisDTO dto : dtos) {
         dto.setName(EnclosureDictionaryTypeEnum.getNameByType(dto.getCategory()));
         dto.setProportion(dto.getCompleteLength().divide(total, 6).multiply(new BigDecimal(100)));
      }

      return dtos.stream().sorted(Comparator.comparing(CategoryProduceAnalysisDTO::getCategory)).collect(Collectors.toList());
   }

   @Override
   public List<PlateProduceAnalysisDTO> plateAnalysis(LocalDateTime startTime, LocalDateTime endTime, Long projectId, Integer category) {
      List<PlateProduceAnalysisDTO> dtos = this.teamReportService.plateAnalysis(startTime, endTime, projectId, category);
      if (CollectionUtils.isEmpty(dtos)) {
         return new ArrayList<>();
      }

      dtos = dtos.stream().map(s -> s.setCompleteLength(s.getCompleteLength().divide(new BigDecimal(1000)))).collect(Collectors.toList());
      BigDecimal total = dtos.stream().map(PlateProduceAnalysisDTO::getCompleteLength).reduce(BigDecimal::add).get();

      for (PlateProduceAnalysisDTO dto : dtos) {
         dto.setProportion(dto.getCompleteLength().divide(total, 6).multiply(new BigDecimal(100)));
      }

      return dtos.stream().sorted(Comparator.comparing(PlateProduceAnalysisDTO::getPlate)).collect(Collectors.toList());
   }

   @Override
   public Map<Long, String> listHasTaskProductionLineId(Long projectId, Long planId, Integer category) {
      List<MesEnclosureTask> list = this.baseService
         .list(
            Wrappers.lambdaQuery(MesEnclosureTask.class)
               .eq(planId != null, MesEnclosureTask::getPlanId, planId)
               .eq(projectId != null, MesEnclosureTask::getProjectId, projectId)
               .apply(category != null, "category & " + category + ">0")
         );
      if (CollectionUtils.isEmpty(list)) {
         return new HashMap<>();
      }

      List<Long> lineIds = list.stream().map(s -> s.getProductionLineId()).distinct().collect(Collectors.toList());
      return this.lineService.listByIds(lineIds).stream().collect(Collectors.toMap(MesEnclosureProductionLine::getId, MesEnclosureProductionLine::getName));
   }

   @Override
   public PageVO listEnclosurePrint(
      Long projectId,
      Long planId,
      Integer category,
      Long lineId,
      String name,
      String serialNumber,
      String specification,
      String material,
      Integer warehousingStatusEnum,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<EnclosureTaskPrintDTO> dtos = this.baseMapper
         .listEnclosurePrint(projectId, planId, category, lineId, name, serialNumber, specification, material, warehousingStatusEnum);
      return new PageVO<>(dtos);
   }

   @Override
   public Boolean savePrint(Long taskId, Integer quantity) {
      MesEnclosureTask task = this.baseService.getById(taskId);
      task.setBoolPrinted(true);
      this.baseService.updateById(task);
      Preconditions.checkArgument(task != null, "任务不存在");
      EnclosurePrint print = EnclosurePrint.builder()
         .printTime(LocalDateTime.now())
         .userId(UserUtil.getCurrentUserId())
         .userName(UserUtil.getCurrentName())
         .taskId(taskId)
         .quantity(quantity)
         .build();
      this.enclosurePrintService.save(print);
      return true;
   }

   @Override
   public List<EnclosurePrint> getPrint(Long taskId) {
      return this.enclosurePrintService
         .list(Wrappers.lambdaQuery(EnclosurePrint.class).eq(EnclosurePrint::getTaskId, taskId).orderByDesc(EnclosurePrint::getPrintTime));
   }

   @Override
   public AppEnclosureTaskDTO taskByTaskId(Long id) {
      Preconditions.checkArgument(id != null, "任务id不能为空");
      MesEnclosureProduceTeamReport report = this.teamReportService.getById(id);
      Preconditions.checkArgument(report != null, "任务上报记录不存在不能为空");
      return this.baseMapper.taskByTaskId(report.getTaskId());
   }
}
