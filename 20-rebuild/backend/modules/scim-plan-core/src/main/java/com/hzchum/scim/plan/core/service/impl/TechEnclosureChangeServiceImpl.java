package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.scim.business.core.api.pojo.dtoParam.EnclosureEditDTOParam;
import com.hzchum.scim.business.core.api.service.BusinessEnclosureService;
import com.hzchum.scim.common.core.api.enums.BoolStatusEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.mes.enclosure.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureProduceTeamReport;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTask;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTaskOrder;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report.MesEnclosureProduceTeamReportDTO;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureProduceTeamReportService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskOrderService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskService;
import com.hzchum.scim.plan.core.api.enums.EnclosureChangeLogTypeEnum;
import com.hzchum.scim.plan.core.api.enums.HandleStatusEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosureChange;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosureChangeLog;
import com.hzchum.scim.plan.core.api.pojo.dto.TechEnclosureDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.EnclosureChangeExamineDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.EnclosureQuantityChangeDTOParam;
import com.hzchum.scim.plan.core.api.pojo.vo.change.EnclosureChangeVo;
import com.hzchum.scim.plan.core.api.pojo.voParam.EnclosureChangeVoParam;
import com.hzchum.scim.plan.core.api.service.TechEnclosureChangeLogService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureChangeService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.mapper.TechEnclosureChangeMapper;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysChangeReason;
import com.hzchum.scim.system.core.api.service.SysChangeReasonService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TechEnclosureChangeServiceImpl extends ServiceImpl<TechEnclosureChangeMapper, TechEnclosureChange> implements TechEnclosureChangeService {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private TechEnclosureService enclosureService;
   @Resource
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Resource
   private SysChangeReasonService changeReasonService;
   @Resource
   private MesEnclosureTaskService taskService;
   @Resource
   private MesBuildingCompleteService completeService;
   @Resource
   private MesEnclosureProduceTeamReportService teamReportService;
   @Resource
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Resource
   private MesEnclosureTaskOrderService taskOrderService;
   @Resource
   private TechEnclosureChangeLogService changeLogService;
   @Resource
   private BusinessEnclosureService businessService;

   @Override
   public Boolean changeEnclosure(EnclosureQuantityChangeDTOParam param) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Long enclosureId = param.getId();
      TechEnclosure enclosure = this.enclosureService.getById(enclosureId);
      Preconditions.checkArgument(enclosure != null, "围护不存在!");
      Preconditions.checkArgument(enclosure.getBoolStatusEnum().equals(BoolStatusEnum.NORMAL.getType()), "围护处于暂停状态!");
      this.projectService.checkProjectStatus(enclosure.getProjectId());
      Preconditions.checkArgument(
         currentUser.isAdmin() || param.getQuantity() >= enclosure.getQuantity() || currentUser.getId().equals(enclosure.getUserId()), "您无权限进行变更!"
      );
      Preconditions.checkArgument(param.getQuantity() >= enclosure.getSubscribeQuantity(), "变更数量不能小于申购数量!");
      int count = this.count(
         Wrappers.lambdaQuery(TechEnclosureChange.builder().enclosureId(enclosureId).handleStatusEnum(HandleStatusEnum.UN.getType()).build())
      );
      Preconditions.checkArgument(count == 0, "围护处于变更待审核状态!");
      SysChangeReason changeReason = this.changeReasonService.getById(param.getReasonId());
      Preconditions.checkArgument(changeReason != null, "变更原因未配置!");
      LambdaQueryWrapper<MesBuildingWarehouseSummary> queryWrapper = Wrappers.lambdaQuery(
         MesBuildingWarehouseSummary.builder()
            .productId(enclosureId)
            .type(WarehouseTypeEnum.INTO.getType())
            .productType(ProductTypeEnum.ENCLOSURE.getType())
            .build()
      );
      List<MesBuildingWarehouseSummary> warehouseSummaryList = this.warehouseSummaryService.list(queryWrapper);
      int sumPackageQuantity = warehouseSummaryList.stream().mapToInt(s -> s.getPackageQuantity().intValue()).sum();
      int sumCargoQuantity = warehouseSummaryList.stream().mapToInt(s -> s.getCargoQuantity().intValue()).sum();
      int sumQuantity = sumCargoQuantity + sumPackageQuantity;
      Preconditions.checkArgument(sumQuantity <= param.getQuantity(), "提交失败,新数量不能小于打包装车数[" + sumQuantity + "]!");
      TechEnclosureChange enclosureChange = TechEnclosureChange.builder()
         .enclosureId(enclosureId)
         .projectId(enclosure.getProjectId())
         .planId(enclosure.getEnclosurePlanId())
         .name(enclosure.getName())
         .serialNumber(enclosure.getSerialNumber())
         .plate(enclosure.getPlate())
         .oldQuantity(enclosure.getQuantity())
         .newQuantity(param.getQuantity())
         .userId(UserUtil.getCurrentUserId())
         .reasonId(param.getReasonId())
         .changeRemark(param.getChangeRemark())
         .category(enclosure.getCategory())
         .build();
      if (param.getQuantity() > enclosure.getQuantity()) {
         enclosureChange.setHandleStatusEnum(HandleStatusEnum.PASS.getType());
         enclosureChange.setHandleUserId(UserUtil.getCurrentUserId());
         enclosureChange.setHandleTime(LocalDateTime.now());
         enclosure.setQuantity(param.getQuantity());
         enclosure.setUserId(enclosureChange.getUserId());
         setTotalInfo(param.getQuantity(), enclosure);
         EnclosureEditDTOParam editDTOParam = EnclosureEditDTOParam.builder()
            .businessId(enclosure.getBusinessId())
            .quantity(param.getQuantity() - enclosure.getQuantity())
            .totalArea(
               enclosure.getSurfaceArea().multiply(BigDecimal.valueOf(param.getQuantity() - enclosure.getQuantity())).divide(BigDecimal.valueOf(1000000L))
            )
            .totalLength(enclosure.getLength().multiply(BigDecimal.valueOf(param.getQuantity() - enclosure.getQuantity())).divide(BigDecimal.valueOf(1000L)))
            .build();
         this.businessService.editBusinessInfo(editDTOParam);
      } else {
         enclosureChange.setHandleStatusEnum(HandleStatusEnum.UN.getType());
         enclosure.setBoolStatusEnum(false);
      }

      this.save(enclosureChange);
      this.enclosureService.updateById(enclosure);
      return Boolean.TRUE;
   }

   private static void setTotalInfo(Integer quantity, TechEnclosure enclosure) {
      enclosure.setTotalLength(new BigDecimal(quantity).multiply(enclosure.getLength()));
      enclosure.setTotalArea(new BigDecimal(quantity).multiply(enclosure.getSurfaceArea()));
      enclosure.setTotalWeight(new BigDecimal(quantity).multiply(enclosure.getWeight()));
   }

   @Override
   public List<EnclosureChangeVo> findAllEnclosureList(EnclosureChangeVoParam voParam, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      return this.baseMapper.findAllEnclosureList(voParam);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean handleChange(EnclosureChangeExamineDTO examineDTO) {
      TechEnclosureChange enclosureChange = this.baseMapper.selectById(examineDTO.getId());
      Preconditions.checkArgument(enclosureChange != null, "变更记录不存在!");
      enclosureChange.setHandleStatusEnum(examineDTO.getHandleStatusEnum());
      enclosureChange.setHandleUserId(UserUtil.getCurrentUserId());
      enclosureChange.setHandleTime(LocalDateTime.now());
      this.updateById(enclosureChange);
      TechEnclosure enclosure = this.enclosureService.getById(enclosureChange.getEnclosureId());
      Preconditions.checkArgument(enclosure != null, "变更围护不存在!");
      enclosure.setBoolStatusEnum(true);
      this.enclosureService.updateById(enclosure);
      if (examineDTO.getHandleStatusEnum().equals(HandleStatusEnum.PASS.getType())) {
         this.approvalChange(enclosureChange);
      }

      return true;
   }

   public Boolean approvalChange(TechEnclosureChange change) {
      Long enclosureId = change.getEnclosureId();
      Integer reduceQuantity = change.getOldQuantity() - change.getNewQuantity();
      List<TechEnclosureChangeLog> logLists = new ArrayList<>();
      TechEnclosure enclosure = this.enclosureService.getById(enclosureId);
      Preconditions.checkArgument(enclosure.getQuantity() - reduceQuantity >= 0, "删除数量超出清单数，无法变更！");
      TechEnclosureChangeLog techEnclosureLog = TechEnclosureChangeLog.builder()
         .productId(enclosureId)
         .changeId(change.getId())
         .tableId(enclosure.getId())
         .oldQuantity(enclosure.getQuantity())
         .changeQuantity(reduceQuantity)
         .quantity(enclosure.getQuantity() - reduceQuantity)
         .userId(UserUtil.getCurrentUserId())
         .category(enclosure.getCategory())
         .type(EnclosureChangeLogTypeEnum.TECH_ENCLOSURE.getType())
         .build();
      logLists.add(techEnclosureLog);
      int afterChangeCount = change.getNewQuantity();
      int quantityCount = reduceQuantity - (enclosure.getQuantity() - enclosure.getSchedulingQuantity());
      enclosure.setQuantity(afterChangeCount);
      setTotalInfo(afterChangeCount, enclosure);
      if (quantityCount > 0) {
         enclosure.setSchedulingQuantity(enclosure.getSchedulingQuantity() - quantityCount);
         List<MesEnclosureTask> tasks = this.taskService.list(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getProductId, enclosureId));
         List<MesEnclosureTaskOrder> taskOrders = this.taskOrderService
            .list(
               Wrappers.lambdaQuery(MesEnclosureTaskOrder.class)
                  .in(MesEnclosureTaskOrder::getId, tasks.stream().map(MesEnclosureTask::getTaskOrderId).collect(Collectors.toSet()))
            );
         Map<Long, Long> taskOrderMap = tasks.stream().collect(Collectors.toMap(MesEnclosureTask::getId, MesEnclosureTask::getTaskOrderId));
         Map<Long, MesEnclosureTaskOrder> orderMap = taskOrders.stream().collect(Collectors.toMap(MesEnclosureTaskOrder::getId, Function.identity()));
         List<MesEnclosureTaskOrder> updateOrDelOrderList = new ArrayList<>();
         List<MesEnclosureTask> updateOrDelTaskList = new ArrayList<>();

         for (MesEnclosureTask task : tasks) {
            if (task.getTaskQuantity() > task.getCompleteQuantity() && quantityCount > 0) {
               int canReduce = task.getTaskQuantity() - task.getCompleteQuantity();
               int trueReduce = Math.min(canReduce, quantityCount);
               task.setTaskQuantity(task.getTaskQuantity() - trueReduce);
               task.setBoolCompleteEnum(task.getTaskQuantity().equals(task.getCompleteQuantity()));
               MesEnclosureTaskOrder order = orderMap.get(task.getTaskOrderId());
               order.setQuantity(order.getQuantity() - trueReduce);
               if (order.getQuantity() == 0) {
                  updateOrDelOrderList.add(order);
               } else {
                  if (order.getQuantity().equals(order.getCompleteQuantity())) {
                     order.setBoolCompleteEnum(Boolean.TRUE);
                  }

                  updateOrDelOrderList.add(order);
               }

               if (task.getTaskQuantity() == 0) {
                  updateOrDelTaskList.add(task);
               } else {
                  updateOrDelTaskList.add(task);
               }

               quantityCount -= trueReduce;
            }
         }

         HashMap<Long, Integer> taskReduceMap = new HashMap<>();

         for (MesEnclosureTask task : tasks) {
            if (quantityCount > 0) {
               int canReduce = task.getCompleteQuantity();
               int trueReduce = Math.min(canReduce, quantityCount);
               task.setTaskQuantity(task.getTaskQuantity() - trueReduce);
               task.setCompleteQuantity(task.getCompleteQuantity() - trueReduce);
               MesEnclosureTaskOrder order = orderMap.get(task.getTaskOrderId());
               order.setQuantity(order.getQuantity() - trueReduce);
               order.setCompleteQuantity(order.getCompleteQuantity() - trueReduce);
               Integer i = taskReduceMap.get(task.getId());
               if (i == null) {
                  taskReduceMap.put(task.getId(), trueReduce);
               } else {
                  taskReduceMap.put(task.getId(), i + trueReduce);
               }

               if (order.getQuantity() == 0) {
                  updateOrDelOrderList.add(order);
               } else {
                  if (order.getQuantity().equals(order.getCompleteQuantity())) {
                     order.setBoolCompleteEnum(Boolean.TRUE);
                  }

                  updateOrDelOrderList.add(order);
               }

               if (task.getTaskQuantity() == 0) {
                  updateOrDelTaskList.add(task);
               } else {
                  if (task.getTaskQuantity().equals(task.getCompleteQuantity())) {
                     task.setBoolCompleteEnum(Boolean.TRUE);
                  }

                  updateOrDelTaskList.add(task);
               }

               quantityCount -= trueReduce;
            }
         }

         this.taskOrderService.updateBatchById(updateOrDelOrderList.stream().filter(s -> s.getQuantity() != 0).collect(Collectors.toList()));
         this.taskOrderService
            .removeByIds(updateOrDelOrderList.stream().filter(s -> s.getQuantity() == 0).map(MesEnclosureTaskOrder::getId).collect(Collectors.toList()));
         this.taskService.updateBatchById(updateOrDelTaskList.stream().filter(s -> s.getTaskQuantity() != 0).collect(Collectors.toList()));
         this.taskService
            .removeByIds(updateOrDelTaskList.stream().filter(s -> s.getTaskQuantity() == 0).map(MesEnclosureTask::getId).collect(Collectors.toList()));
         int reduceProduceCount = taskReduceMap.values().stream().mapToInt(Integer::intValue).sum();
         enclosure.setProducedQuantity(enclosure.getProducedQuantity() - reduceProduceCount);
         if (!taskReduceMap.isEmpty()) {
            for (Long taskId : taskReduceMap.keySet()) {
               Integer needReduceProduce = taskReduceMap.get(taskId);
               List<MesEnclosureProduceTeamReport> list = this.teamReportService
                  .list(
                     Wrappers.lambdaQuery(MesEnclosureProduceTeamReport.class)
                        .eq(MesEnclosureProduceTeamReport::getProductId, enclosureId)
                        .eq(MesEnclosureProduceTeamReport::getTaskId, taskId)
                  );
               List<MesEnclosureProduceTeamReport> reportList = new ArrayList<>();
               int i = needReduceProduce;

               for (MesEnclosureProduceTeamReport teamReport : list) {
                  if (i > 0) {
                     TechEnclosureChangeLog reportLog = TechEnclosureChangeLog.builder()
                        .productId(enclosureId)
                        .changeId(change.getId())
                        .tableId(teamReport.getId())
                        .oldQuantity(teamReport.getQuantity())
                        .changeQuantity(i)
                        .quantity(teamReport.getQuantity() - i)
                        .userId(UserUtil.getCurrentUserId())
                        .category(enclosure.getCategory())
                        .type(EnclosureChangeLogTypeEnum.TEAM_REPORT.getType())
                        .build();
                     logLists.add(reportLog);
                     int reduceCount = Math.min(teamReport.getQuantity(), i);
                     teamReport.setQuantity(teamReport.getQuantity() - reduceCount);
                     reportList.add(teamReport);
                     i -= reduceCount;
                  }
               }

               this.teamReportService.updateBatchById(reportList.stream().filter(s -> s.getQuantity() != 0).collect(Collectors.toList()));
               this.teamReportService
                  .removeByIds(reportList.stream().filter(s -> s.getQuantity() == 0).map(MesEnclosureProduceTeamReport::getId).collect(Collectors.toList()));
               List<MesBuildingComplete> completeList = this.completeService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingComplete.class)
                        .eq(MesBuildingComplete::getProductId, enclosureId)
                        .eq(MesBuildingComplete::getTaskId, taskId)
                        .eq(MesBuildingComplete::getTaskTypeEnum, TaskTypeEnum.ENCLOSURE.getType())
                  );
               List<MesBuildingComplete> compleList = new ArrayList<>();
               int j = needReduceProduce;

               for (MesBuildingComplete complete : completeList) {
                  if (j > 0) {
                     TechEnclosureChangeLog completeLog = TechEnclosureChangeLog.builder()
                        .productId(enclosureId)
                        .changeId(change.getId())
                        .tableId(complete.getId())
                        .oldQuantity(complete.getQuantity())
                        .changeQuantity(j)
                        .quantity(complete.getQuantity() - j)
                        .userId(UserUtil.getCurrentUserId())
                        .category(enclosure.getCategory())
                        .type(EnclosureChangeLogTypeEnum.ENCLOSURE_COMPLETE.getType())
                        .build();
                     logLists.add(completeLog);
                     int reduceCount = Math.min(complete.getQuantity(), j);
                     complete.setQuantity(complete.getQuantity() - reduceCount);
                     compleList.add(complete);
                     this.completeService.updateById(complete);
                     if (complete.getQuantity() == 0) {
                        this.completeService.removeById(complete.getId());
                     }

                     j -= reduceCount;
                  }
               }

               this.completeService.updateBatchById(compleList.stream().filter(s -> s.getQuantity() != 0).collect(Collectors.toList()));
               this.completeService
                  .removeByIds(compleList.stream().filter(s -> s.getQuantity() == 0).map(MesBuildingComplete::getId).collect(Collectors.toList()));
               List<MesBuildingWarehouseRecord> warehouseRecordList = this.warehouseRecordService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
                        .eq(MesBuildingWarehouseRecord::getProductId, enclosureId)
                        .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ENCLOSURE.getType())
                        .eq(MesBuildingWarehouseRecord::getType, WarehouseRecordStatusTypeEnum.INTO.getType())
                  );
               List<MesBuildingWarehouseRecord> recordList = new ArrayList<>();
               int k = needReduceProduce;

               for (MesBuildingWarehouseRecord record : warehouseRecordList) {
                  if (k > 0) {
                     TechEnclosureChangeLog recordLog = TechEnclosureChangeLog.builder()
                        .productId(enclosureId)
                        .changeId(change.getId())
                        .tableId(record.getId())
                        .oldQuantity(record.getQuantity().intValue())
                        .changeQuantity(k)
                        .quantity(record.getQuantity().intValue() - k)
                        .userId(UserUtil.getCurrentUserId())
                        .category(enclosure.getCategory())
                        .type(EnclosureChangeLogTypeEnum.ENCLOSURE_WAREHOUSE.getType())
                        .build();
                     logLists.add(recordLog);
                     int reduceCount = Math.min(record.getQuantity().intValue(), k);
                     record.setQuantity(record.getQuantity().subtract(BigDecimal.valueOf(reduceCount)));
                     recordList.add(record);
                     k -= reduceCount;
                  }
               }

               this.warehouseRecordService.updateBatchById(recordList.stream().filter(s -> s.getQuantity().intValue() != 0).collect(Collectors.toList()));
               this.warehouseRecordService
                  .removeByIds(
                     recordList.stream().filter(s -> s.getQuantity().intValue() == 0).map(MesBuildingWarehouseRecord::getId).collect(Collectors.toList())
                  );
               List<MesBuildingWarehouseSummary> summary = this.warehouseSummaryService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                        .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                        .eq(MesBuildingWarehouseSummary::getProductId, enclosureId)
                        .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ENCLOSURE.getType())
                  );
               List<MesBuildingWarehouseSummary> summaryList = new ArrayList<>();
               int z = needReduceProduce;

               for (MesBuildingWarehouseSummary warehouseSummary : summary) {
                  if (z > 0) {
                     TechEnclosureChangeLog summaryLog = TechEnclosureChangeLog.builder()
                        .productId(enclosureId)
                        .changeId(change.getId())
                        .tableId(warehouseSummary.getId())
                        .oldQuantity(warehouseSummary.getQuantity().intValue())
                        .changeQuantity(z)
                        .quantity(warehouseSummary.getQuantity().intValue() - z)
                        .userId(UserUtil.getCurrentUserId())
                        .category(enclosure.getCategory())
                        .type(EnclosureChangeLogTypeEnum.ENCLOSURE_WAREHOUSE_SUMMARY.getType())
                        .build();
                     logLists.add(summaryLog);
                     int reduceCount = Math.min(warehouseSummary.getQuantity().intValue(), z);
                     warehouseSummary.setQuantity(warehouseSummary.getQuantity().subtract(BigDecimal.valueOf(reduceCount)));
                     summaryList.add(warehouseSummary);
                     z -= reduceCount;
                  }
               }

               this.warehouseSummaryService.updateBatchById(summaryList.stream().filter(s -> s.getQuantity().intValue() != 0).collect(Collectors.toList()));
               this.warehouseSummaryService
                  .removeByIds(
                     summaryList.stream().filter(s -> s.getQuantity().intValue() == 0).map(MesBuildingWarehouseSummary::getId).collect(Collectors.toList())
                  );
            }
         }

         this.changeLogService.saveBatch(logLists);
      }

      EnclosureEditDTOParam editDTOParam = EnclosureEditDTOParam.builder()
         .businessId(enclosure.getBusinessId())
         .quantity(-reduceQuantity)
         .totalArea(enclosure.getSurfaceArea().multiply(BigDecimal.valueOf(reduceQuantity.intValue())).divide(BigDecimal.valueOf(1000000L)).negate())
         .totalLength(enclosure.getLength().multiply(BigDecimal.valueOf(reduceQuantity.intValue())).divide(BigDecimal.valueOf(1000L)).negate())
         .build();
      this.businessService.editBusinessInfo(editDTOParam);
      if (enclosure.getQuantity() == 0) {
         this.enclosureService.removeById(enclosure.getId());
      } else {
         this.enclosureService.updateById(enclosure);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteEnclosureTask(Long orderId, List<Long> taskIds) {
      List<MesEnclosureProduceTeamReportDTO> enclosureReport = this.teamReportService.findEnclosureReport(orderId, taskIds);
      Set<String> enclosureSet = enclosureReport.stream().map(MesEnclosureProduceTeamReportDTO::getEnclosureName).collect(Collectors.toSet());
      Preconditions.checkArgument(CollectionUtils.isEmpty(enclosureSet), enclosureSet.toString() + "围护已生产无法撤回");
      Set<String> nameSet = this.teamReportService.findFreezeEnclosure(orderId, taskIds).stream().map(TechEnclosureDTO::getName).collect(Collectors.toSet());
      Preconditions.checkArgument(CollectionUtils.isEmpty(nameSet), nameSet.toString() + "围护处于变更中无法撤回");
      List<MesEnclosureTask> tasks = this.taskService
         .list(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getTaskOrderId, orderId).in(MesEnclosureTask::getId, taskIds));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(tasks), "任务不存在,请刷新后重试");
      int sum = tasks.stream().mapToInt(MesEnclosureTask::getTaskQuantity).sum();
      MesEnclosureTaskOrder taskOrder = this.taskOrderService
         .getOne(Wrappers.lambdaQuery(MesEnclosureTaskOrder.class).eq(MesEnclosureTaskOrder::getId, orderId));
      Preconditions.checkArgument(sum <= taskOrder.getQuantity(), "任务数量大于工单数量");
      taskOrder.setQuantity(taskOrder.getQuantity() - sum);
      List<Long> productIds = tasks.stream().map(MesEnclosureTask::getProductId).collect(Collectors.toList());
      Map<Long, Integer> taskMap = tasks.stream().collect(Collectors.toMap(MesEnclosureTask::getProductId, MesEnclosureTask::getTaskQuantity));
      List<TechEnclosure> enclosureList = this.enclosureService.listByIds(productIds);
      Preconditions.checkArgument(productIds.size() == enclosureList.size(), "工单数据,与清单数据不符,请联系管理员!!");

      for (TechEnclosure techEnclosure : enclosureList) {
         techEnclosure.setSchedulingQuantity(techEnclosure.getSchedulingQuantity() - taskMap.get(techEnclosure.getId()));
         Preconditions.checkArgument(techEnclosure.getSchedulingQuantity() >= 0, "删除失败,请联系管理员");
      }

      this.taskService.removeByIds(taskIds);
      if (taskOrder.getQuantity() == 0) {
         this.taskOrderService.removeById(taskOrder.getId());
      } else {
         if (taskOrder.getQuantity().equals(taskOrder.getCompleteQuantity())) {
            taskOrder.setBoolCompleteEnum(Boolean.TRUE);
         }

         this.taskOrderService.updateById(taskOrder);
      }

      this.enclosureService.updateBatchById(enclosureList);
      return true;
   }
}
