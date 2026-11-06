package com.hzchum.scim.mes.building.core.biz.impl.quota_config;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectContentCategoryEnum;
import com.hzchum.scim.mes.building.core.api.biz.quota_config.MesManualReportBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingNewTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesManualReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskMissingDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesManualReportQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingProduceTeamReportDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.mes.building.core.mapper.quota_config.MesManualReportMapper;
import com.hzchum.scim.mes.enclosure.core.api.biz.factory.MesEnclosureTeamBiz;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureTaskOrderBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureTeam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureProduceTeamReport;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTask;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTaskOrder;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureProduceTeamReportService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskService;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesManualReportBizImpl implements MesManualReportBiz {
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesBuildingNewTaskBiz newTaskBiz;
   @Autowired
   private MesEnclosureTaskService enclosureTaskService;
   @Autowired
   private MesManualReportMapper manualReportMapper;
   @Autowired
   private MesEnclosureTaskOrderBiz taskOrderBiz;
   @Autowired
   private MesEnclosureTeamBiz teamBiz;
   @Autowired
   private TechEnclosureService enclosureService;
   @Autowired
   private MesEnclosureProduceTeamReportService teamReportService;
   @Autowired
   private MesBuildingCompleteService completeService;
   @Autowired
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Autowired
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private RedisUtils redisUtils;
   @Autowired
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Autowired
   private MesBuildingTaskNumberLinkService taskNumberLinkService;
   @Autowired
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Autowired
   private MesBuildingTaskBiz taskBiz;

   @Override
   public List<MesManualReportDTO> unreportedList(@NonNull MesManualReportQuery query) {
      if (query == null) {
         throw new NullPointerException("query is marked non-null but is null");
      }

      Preconditions.checkArgument(query.getWorkshopId() != null, "车间不能为空");
      Preconditions.checkArgument(query.getProductType() != null, "产品类型不能为空");
      Preconditions.checkArgument(query.getProcessId() != null, "工序不能为空");
      Preconditions.checkArgument(query.getTeamId() != null, "班组不能为空");
      Preconditions.checkArgument(query.getProjectId() != null, "项目不能为空");
      Preconditions.checkArgument(query.getMonomerId() != null, "单体不能为空");
      Preconditions.checkArgument(query.getAreaId() != null, "区域不能为空");
      if (Objects.equals(ProductTypeEnum.ENCLOSURE.getType(), query.getProductType())) {
         return this.manualReportMapper.unreportedEnclosureList(query);
      }

      List<MesManualReportDTO> list = this.taskProcessService.manualReportUnreportedList(query);
      return list.stream().filter(i -> {
         List<AppTaskMissingDetailsDTO> missingList = this.taskBiz.taskProcessMissingDetails2(i.getTaskProcessId(), i.getBoolAssist(), i.getAssistLineId());
         return CollUtil.isEmpty(missingList);
      }).collect(Collectors.toList());
   }

   @Override
   public List<MesManualReportDTO> flexibleProcessUnreportedList(@NonNull MesManualReportQuery query) {
      if (query == null) {
         throw new NullPointerException("query is marked non-null but is null");
      }

      Preconditions.checkArgument(query.getWorkshopId() != null, "车间不能为空");
      Preconditions.checkArgument(query.getProductType() != null, "产品类型不能为空");
      Preconditions.checkArgument(query.getProcessId() != null, "工序不能为空");
      Preconditions.checkArgument(query.getTeamId() != null, "班组不能为空");
      Preconditions.checkArgument(query.getProjectId() != null, "项目不能为空");
      Preconditions.checkArgument(query.getMonomerId() != null, "单体不能为空");
      Preconditions.checkArgument(query.getAreaId() != null, "区域不能为空");
      return this.manualReportMapper.flexibleProcessUnreportedList(query);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchAddProduceReport(Integer productTypeEnum, List<MesBuildingProduceTeamReportDTOParam> paramList) {
      if (Objects.equals(ProductTypeEnum.ENCLOSURE.getType(), productTypeEnum)) {
         paramList.forEach(i -> this.enclosureReport(i.getTaskId(), i.getReportQuantity(), i.getReportPersonId()));
      } else {
         paramList.forEach(i -> {
            try {
               this.newTaskBiz.manualReportSaveProduceTeamReport(i);
            } catch (Exception e) {
               Preconditions.checkArgument(false, "存在未满足上报条件数据");
            }
         });
      }

      return true;
   }

   @Override
   public Boolean flexibleProcessBatchAddProduceReport(
      Integer productTypeEnum, Long processId, Long teamId, List<MesBuildingProduceTeamReportDTOParam> paramList
   ) {
      Preconditions.checkArgument(CollUtil.isNotEmpty(paramList), "无数据");
      List<Long> taskIdList = paramList.stream().map(MesBuildingProduceTeamReportDTOParam::getTaskId).collect(Collectors.toList());
      List<MesBuildingTask> taskList = Optional.of(taskIdList).filter(CollUtil::isNotEmpty).map(this.taskService::listByIds).orElse(Collections.emptyList());
      Map<Long, MesBuildingTask> taskMap = taskList.stream().collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
      switch (ProductTypeEnum.getEnumByType(productTypeEnum)) {
         case ARTIFACT:
            List<MesBuildingTaskNumberLink> artifactTaskNumberLinkList = this.taskNumberLinkService
               .list((Wrapper<MesBuildingTaskNumberLink>)new LambdaQueryWrapper<MesBuildingTaskNumberLink>().in(MesBuildingTaskNumberLink::getArtifactTaskId, taskIdList));
            Map<Long, List<MesBuildingTaskNumberLink>> artifactTaskNumberLinkGroup = artifactTaskNumberLinkList.stream()
               .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskId));
            Map<Long, List<MesBuildingProduceTeamReport>> artifactProduceTeamReportGroup = this.produceTeamReportService
               .list(
                  (Wrapper<MesBuildingProduceTeamReport>)(new LambdaQueryWrapper<MesBuildingProduceTeamReport>().in(MesBuildingProduceTeamReport::getTaskId, taskIdList))
                     .eq(MesBuildingProduceTeamReport::getProcessId, processId)
               )
               .stream()
               .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getTaskId));
            paramList.forEach(
               param -> {
                  MesBuildingTask nowTask = taskMap.get(param.getTaskId());
                  Preconditions.checkArgument(BeanUtil.isNotEmpty(nowTask), "任务不存在, 请刷新后重试");
                  List<MesBuildingTeamUserLink> teamUserLinkList = this.teamUserLinkService
                     .list(
                        (Wrapper<MesBuildingTeamUserLink>)(new LambdaQueryWrapper<MesBuildingTeamUserLink>().eq(MesBuildingTeamUserLink::getTeamId, teamId))
                           .eq(MesBuildingTeamUserLink::getUserId, param.getReportPersonId())
                     );
                  Preconditions.checkArgument(CollUtil.isNotEmpty(teamUserLinkList), "上报人和上报班组不匹配, 请刷新后重试");
                  List<MesBuildingTaskNumberLink> nowArtifactTaskNumberLinkList = artifactTaskNumberLinkGroup.get(param.getTaskId());
                  Preconditions.checkArgument(CollUtil.isNotEmpty(nowArtifactTaskNumberLinkList), "任务数据异常, 请刷新后重试");
                  List<Integer> nowArtifactNumberList = nowArtifactTaskNumberLinkList.stream()
                     .map(MesBuildingTaskNumberLink::getArtifactNumber)
                     .distinct()
                     .collect(Collectors.toList());
                  List<Integer> nowReportNumberList = artifactProduceTeamReportGroup.getOrDefault(param.getTaskId(), new ArrayList<>())
                     .stream()
                     .map(MesBuildingProduceTeamReport::getNumber)
                     .collect(Collectors.toList());
                  nowArtifactNumberList = nowArtifactNumberList.stream()
                     .filter(an -> !nowReportNumberList.contains(an))
                     .limit(param.getReportQuantity().intValue())
                     .collect(Collectors.toList());
                  Preconditions.checkArgument(nowArtifactNumberList.size() == param.getReportQuantity(), "可操作数量不足, 请刷新后重试");
                  AtomicReference<Long> reportNumber = new AtomicReference<>();
                  if (!nowTask.getBoolOneCode()) {
                     reportNumber.set(this.redisUtils.incr("teamreport_reportnumber:", 1L));
                  }

                  nowArtifactNumberList.forEach(an -> {
                     if (nowTask.getBoolOneCode()) {
                        reportNumber.set(this.redisUtils.incr("teamreport_reportnumber:", 1L));
                     }

                     MesBuildingProduceTeamReport produceTeamReport = new MesBuildingProduceTeamReport();
                     produceTeamReport.setBoolFixedProcess(false);
                     produceTeamReport.setProjectId(nowTask.getProjectId());
                     produceTeamReport.setMonomerId(nowTask.getMonomerId());
                     produceTeamReport.setAreaId(nowTask.getAreaId());
                     produceTeamReport.setWorkshopId(nowTask.getWorkshopId());
                     produceTeamReport.setProductionLineId(nowTask.getProductionLineId());
                     produceTeamReport.setTaskId(param.getTaskId());
                     produceTeamReport.setTaskProcessId(0L);
                     produceTeamReport.setProcessId(processId);
                     produceTeamReport.setSchedulingId(nowTask.getSchedulingId());
                     produceTeamReport.setProductId(nowTask.getProductId());
                     produceTeamReport.setTaskTypeEnum(nowTask.getTaskTypeEnum());
                     produceTeamReport.setQuantity(param.getReportQuantity());
                     produceTeamReport.setInspectionQuantity(produceTeamReport.getQuantity());
                     produceTeamReport.setTeamId(teamId);
                     produceTeamReport.setUserId(param.getReportPersonId());
                     produceTeamReport.setNumber(an);
                     produceTeamReport.setReportTime(LocalDateTime.now());
                     produceTeamReport.setReportNumber(reportNumber.get());
                     produceTeamReport.setTaskOrderId(nowTask.getTaskOrderId());
                     produceTeamReport.setInspectionTime(produceTeamReport.getReportTime());
                     this.produceTeamReportService.save(produceTeamReport);
                  });
               }
            );
            break;
         case ASSEMBLE:
            List<MesBuildingTaskNumberLink> assembleTaskNumberLinkList = this.taskNumberLinkService
               .list((Wrapper<MesBuildingTaskNumberLink>)new LambdaQueryWrapper<MesBuildingTaskNumberLink>().in(MesBuildingTaskNumberLink::getAssembleTaskId, taskIdList));
            Map<Long, List<MesBuildingTaskNumberLink>> assembleTaskNumberLinkGroup = assembleTaskNumberLinkList.stream()
               .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleTaskId));
            Map<Long, List<MesBuildingProduceTeamReport>> assembleProduceTeamReportGroup = this.produceTeamReportService
               .list(
                  (Wrapper<MesBuildingProduceTeamReport>)(new LambdaQueryWrapper<MesBuildingProduceTeamReport>().in(MesBuildingProduceTeamReport::getTaskId, taskIdList))
                     .eq(MesBuildingProduceTeamReport::getProcessId, processId)
               )
               .stream()
               .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getTaskId));
            paramList.forEach(
               param -> {
                  MesBuildingTask nowTask = taskMap.get(param.getTaskId());
                  Preconditions.checkArgument(BeanUtil.isNotEmpty(nowTask), "任务不存在, 请刷新后重试");
                  List<MesBuildingTeamUserLink> teamUserLinkList = this.teamUserLinkService
                     .list(
                        (Wrapper<MesBuildingTeamUserLink>)(new LambdaQueryWrapper<MesBuildingTeamUserLink>().eq(MesBuildingTeamUserLink::getTeamId, teamId))
                           .eq(MesBuildingTeamUserLink::getUserId, param.getReportPersonId())
                     );
                  Preconditions.checkArgument(CollUtil.isNotEmpty(teamUserLinkList), "上报人和上报班组不匹配, 请刷新后重试");
                  List<MesBuildingTaskNumberLink> nowAssembleTaskNumberLinkList = assembleTaskNumberLinkGroup.get(param.getTaskId());
                  Preconditions.checkArgument(CollUtil.isNotEmpty(nowAssembleTaskNumberLinkList), "任务数据异常, 请刷新后重试");
                  List<Integer> nowAssembletNumberList = nowAssembleTaskNumberLinkList.stream()
                     .map(MesBuildingTaskNumberLink::getArtifactNumber)
                     .distinct()
                     .collect(Collectors.toList());
                  List<Integer> nowReportNumberList = assembleProduceTeamReportGroup.getOrDefault(param.getTaskId(), new ArrayList<>())
                     .stream()
                     .map(MesBuildingProduceTeamReport::getNumber)
                     .collect(Collectors.toList());
                  nowAssembletNumberList = nowAssembletNumberList.stream()
                     .filter(an -> !nowReportNumberList.contains(an))
                     .limit(param.getReportQuantity().intValue())
                     .collect(Collectors.toList());
                  Preconditions.checkArgument(nowAssembletNumberList.size() == param.getReportQuantity(), "可操作数量不足, 请刷新后重试");
                  AtomicReference<Long> reportNumber = new AtomicReference<>();
                  if (!nowTask.getBoolOneCode()) {
                     reportNumber.set(this.redisUtils.incr("teamreport_reportnumber:", 1L));
                  }

                  nowAssembletNumberList.forEach(an -> {
                     if (nowTask.getBoolOneCode()) {
                        reportNumber.set(this.redisUtils.incr("teamreport_reportnumber:", 1L));
                     }

                     MesBuildingProduceTeamReport produceTeamReport = new MesBuildingProduceTeamReport();
                     produceTeamReport.setBoolFixedProcess(false);
                     produceTeamReport.setProjectId(nowTask.getProjectId());
                     produceTeamReport.setMonomerId(nowTask.getMonomerId());
                     produceTeamReport.setAreaId(nowTask.getAreaId());
                     produceTeamReport.setWorkshopId(nowTask.getWorkshopId());
                     produceTeamReport.setProductionLineId(nowTask.getProductionLineId());
                     produceTeamReport.setTaskId(param.getTaskId());
                     produceTeamReport.setTaskProcessId(0L);
                     produceTeamReport.setProcessId(processId);
                     produceTeamReport.setSchedulingId(nowTask.getSchedulingId());
                     produceTeamReport.setProductId(nowTask.getProductId());
                     produceTeamReport.setTaskTypeEnum(nowTask.getTaskTypeEnum());
                     produceTeamReport.setQuantity(param.getReportQuantity());
                     produceTeamReport.setInspectionQuantity(produceTeamReport.getQuantity());
                     produceTeamReport.setTeamId(teamId);
                     produceTeamReport.setUserId(param.getReportPersonId());
                     produceTeamReport.setNumber(an);
                     produceTeamReport.setReportTime(LocalDateTime.now());
                     produceTeamReport.setReportNumber(reportNumber.get());
                     produceTeamReport.setTaskOrderId(nowTask.getTaskOrderId());
                     produceTeamReport.setInspectionTime(produceTeamReport.getReportTime());
                     produceTeamReport.setPerforateQuantity(param.getPerforateQuantity());
                     this.produceTeamReportService.save(produceTeamReport);
                  });
               }
            );
            break;
         case MACHINE_PART:
            paramList.forEach(
               param -> {
                  MesBuildingTask nowTask = taskMap.get(param.getTaskId());
                  Preconditions.checkArgument(BeanUtil.isNotEmpty(nowTask), "任务不存在, 请刷新后重试");
                  List<MesBuildingTeamUserLink> teamUserLinkList = this.teamUserLinkService
                     .list(
                        (Wrapper<MesBuildingTeamUserLink>)(new LambdaQueryWrapper<MesBuildingTeamUserLink>().eq(MesBuildingTeamUserLink::getTeamId, teamId))
                           .eq(MesBuildingTeamUserLink::getUserId, param.getReportPersonId())
                     );
                  Preconditions.checkArgument(CollUtil.isNotEmpty(teamUserLinkList), "上报人和上报班组不匹配, 请刷新后重试");
                  MesBuildingProduceTeamReport produceTeamReport = new MesBuildingProduceTeamReport();
                  produceTeamReport.setBoolFixedProcess(false);
                  produceTeamReport.setProjectId(nowTask.getProjectId());
                  produceTeamReport.setMonomerId(nowTask.getMonomerId());
                  produceTeamReport.setAreaId(nowTask.getAreaId());
                  produceTeamReport.setWorkshopId(nowTask.getWorkshopId());
                  produceTeamReport.setProductionLineId(nowTask.getProductionLineId());
                  produceTeamReport.setTaskId(param.getTaskId());
                  produceTeamReport.setTaskProcessId(0L);
                  produceTeamReport.setProcessId(processId);
                  produceTeamReport.setSchedulingId(nowTask.getSchedulingId());
                  produceTeamReport.setProductId(nowTask.getProductId());
                  produceTeamReport.setTaskTypeEnum(nowTask.getTaskTypeEnum());
                  produceTeamReport.setQuantity(param.getReportQuantity());
                  produceTeamReport.setInspectionQuantity(produceTeamReport.getQuantity());
                  produceTeamReport.setTeamId(teamId);
                  produceTeamReport.setUserId(param.getReportPersonId());
                  produceTeamReport.setReportTime(LocalDateTime.now());
                  produceTeamReport.setTaskOrderId(nowTask.getTaskOrderId());
                  produceTeamReport.setInspectionTime(produceTeamReport.getReportTime());
                  this.produceTeamReportService.save(produceTeamReport);
               }
            );
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   public Boolean enclosureReport(Long taskId, Integer quantity, Long reportPersonId) {
      MesEnclosureTask task = this.enclosureTaskService.getById(taskId);
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
         .userId(reportPersonId)
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
         .userId(reportPersonId)
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
         .userId(reportPersonId)
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

      this.enclosureTaskService.updateById(task);
      MesEnclosureTaskOrder taskOrder = this.taskOrderBiz.getById(task.getTaskOrderId());
      Preconditions.checkArgument(taskOrder != null, "工单不存在!请刷新后重试");
      List<MesEnclosureTask> tasks = this.enclosureTaskService
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
}
