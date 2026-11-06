package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsTeamLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingTeamBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingAssistBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskProcessBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssistNumberDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskProcessLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesbuildingTaskProcessAssistDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.UserLinkGroupProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.UserLinkLineProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.post.AssistDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistNumberDetailService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingAssistMapper;
import com.hzchum.scim.plan.core.api.service.TechArtifactChangeService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
public class MesbuildingAssistBizImpl extends IBizImpl<MesBuildingAssistService, MesBuildingAssistMapper, MesBuildingAssist> implements MesBuildingAssistBiz {
   @Autowired
   private MesBuildingGroupsTeamLinkBiz teamLinkBiz;
   @Autowired
   private MesBuildingTeamBiz teamBiz;
   @Autowired
   private MesBuildingTaskProcessBiz taskProcessBiz;
   @Autowired
   private TechAssembleDetailService techAssembleDetailService;
   @Autowired
   private TechArtifactChangeService techArtifactChangeService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private MesBuildingTaskBiz mesBuildingTaskBiz;
   @Autowired
   private MesBuildingAssistNumberDetailService assistNumberDetailService;
   @Autowired
   private MesBuildingProductProcessService productProcessService;
   @Autowired
   private MesBuildingTaskService mesBuildingTaskService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingTaskNumberLinkService taskNumberLinkService;
   @Autowired
   private MesBuildingProductionLineService productionLineService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean assistSave(List<AssistDTOParam> newAssisList, Long taskProcessId, List<Long> nextProcessIds, Long artifactTaskId) {
      nextProcessIds = CollectionUtils.isEmpty(nextProcessIds) ? nextProcessIds : nextProcessIds.stream().distinct().collect(Collectors.toList());
      MesBuildingTaskProcess taskProcess = this.taskProcessBiz.getById(taskProcessId);
      Preconditions.checkArgument(taskProcess != null, "操作失败,任务工序不存在");
      MesBuildingTask task = this.mesBuildingTaskService.getById(taskProcess.getTaskId());
      this.mesBuildingTaskBiz.checkProductStatus(Collections.singletonList(taskProcess.getProductId()), taskProcess.getTaskTypeEnum());
      MesBuildingProductProcess productProcess = this.productProcessService.getById(taskProcess.getProductProcessId());
      List<Long> newProductionLineIds = newAssisList.stream().map(AssistDTOParam::getProductionLineId).distinct().collect(Collectors.toList());
      Preconditions.checkArgument(newAssisList.stream().allMatch(s -> s.getQuantity() > 0), "操作失败,协同数量不可为空或者0!");
      List<MesBuildingAssist> oldAssistList = this.baseService
         .list(Wrappers.lambdaQuery(MesBuildingAssist.class).eq(MesBuildingAssist::getTaskProcessId, taskProcessId));
      Map<Long, MesBuildingAssist> oldAssistMap = oldAssistList.stream().collect(Collectors.toMap(MesBuildingAssist::getProductionLineId, Function.identity()));
      List<Integer> assembleNumbers = new ArrayList<>();
      if (artifactTaskId != null && taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinks = this.taskNumberLinkService
            .list(
               (Wrapper<MesBuildingTaskNumberLink>)(new LambdaQueryWrapper<MesBuildingTaskNumberLink>()
                     .eq(MesBuildingTaskNumberLink::getArtifactTaskId, artifactTaskId))
                  .eq(MesBuildingTaskNumberLink::getAssembleId, taskProcess.getProductId())
            );
         assembleNumbers = mesBuildingTaskNumberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList());
      }

      List<MesBuildingAssistNumberDetail> mesBuildingAssistNumberDetails = this.assistNumberDetailService
         .list(
            Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class)
               .eq(MesBuildingAssistNumberDetail::getTaskProcessId, taskProcessId)
               .in(CollectionUtils.isNotEmpty(assembleNumbers), MesBuildingAssistNumberDetail::getNumber, assembleNumbers)
         );
      Map<Long, List<MesBuildingAssistNumberDetail>> oldNumberMap = mesBuildingAssistNumberDetails.stream()
         .collect(Collectors.groupingBy(MesBuildingAssistNumberDetail::getProductionLineId));
      List<Long> oldProductionLineIds = new ArrayList<>(oldAssistMap.keySet());
      oldProductionLineIds.removeAll(newProductionLineIds);
      List<MesBuildingAssistNumberDetail> needDeleteNumbers = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(oldProductionLineIds)) {
         List<MesBuildingAssist> needDeleteAssist = new ArrayList<>();

         for (Long delProductionLineId : oldProductionLineIds) {
            MesBuildingAssist assist = oldAssistMap.get(delProductionLineId);
            needDeleteAssist.add(assist);
            oldAssistMap.remove(delProductionLineId);
            List<MesBuildingAssistNumberDetail> numberDetailList = oldNumberMap.get(delProductionLineId);
            needDeleteNumbers.addAll(numberDetailList);
            oldNumberMap.remove(delProductionLineId);
         }

         Preconditions.checkArgument(needDeleteAssist.stream().noneMatch(s -> s.getProduceQuantity() > 0), "操作失败,存在协同完成的产品,不可删除!");
         List<Long> assistIds = needDeleteAssist.stream().map(MesBuildingAssist::getId).collect(Collectors.toList());
         this.baseService.removeByIds(assistIds);
         Preconditions.checkArgument(needDeleteNumbers.stream().noneMatch(MesBuildingAssistNumberDetail::getBoolFinishEnum), "操作失败,存在协同完成的产品,不可删除!");
      }

      List<Long> productionLineIdIds = newAssisList.stream().map(AssistDTOParam::getProductionLineId).distinct().collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(productionLineIdIds)) {
         Preconditions.checkArgument(productionLineIdIds.size() == newAssisList.size(), "更换的生产线已存在!");
      }

      Map<Long, AssistDTOParam> paramMap = newAssisList.stream().collect(Collectors.toMap(AssistDTOParam::getProductionLineId, Function.identity()));

      for (Long productionLineId : oldAssistMap.keySet()) {
         List<MesBuildingAssistNumberDetail> oldNumbers = oldNumberMap.get(productionLineId);
         AssistDTOParam param = paramMap.get(productionLineId);
         Integer quantity = param.getQuantity();
         if (oldNumbers.size() > quantity) {
            int subQuantity = oldNumbers.size() - quantity;
            List<MesBuildingAssistNumberDetail> boolFinishEnumNumberDetailList = oldNumbers.stream()
               .filter(e -> !e.getBoolFinishEnum())
               .collect(Collectors.toList());
            Preconditions.checkArgument(
               CollectionUtils.isNotEmpty(boolFinishEnumNumberDetailList) && boolFinishEnumNumberDetailList.size() >= subQuantity, "操作失败,可减少协同的数量不足!"
            );
            List<MesBuildingAssistNumberDetail> deleteoldNumbers = boolFinishEnumNumberDetailList.stream()
               .sorted(Comparator.comparing(MesBuildingAssistNumberDetail::getNumber))
               .collect(Collectors.toList())
               .subList(0, subQuantity);
            List<Long> needDeleteIds = deleteoldNumbers.stream().map(MesBuildingAssistNumberDetail::getId).collect(Collectors.toList());
            List<Integer> removeNumbers = deleteoldNumbers.stream().map(MesBuildingAssistNumberDetail::getNumber).collect(Collectors.toList());
            needDeleteNumbers.addAll(deleteoldNumbers);
            MesBuildingAssist assist = oldAssistMap.get(productionLineId);
            assist.setQuantity(assist.getQuantity() - needDeleteIds.size());
            Preconditions.checkArgument(assist.getQuantity() >= assist.getProduceQuantity(), "操作失败,可减少协同的数量不足!");
            oldNumbers = oldNumbers.stream().filter(s -> !removeNumbers.contains(s.getNumber())).collect(Collectors.toList());
            oldNumberMap.put(productionLineId, oldNumbers);
         }
      }

      if (CollectionUtils.isNotEmpty(needDeleteNumbers)) {
         Map<Long, List<MesBuildingTaskProcess>> nextTaskProcessListMap = this.taskProcessBiz
            .list((Wrapper<MesBuildingTaskProcess>)new LambdaQueryWrapper<MesBuildingTaskProcess>().eq(MesBuildingTaskProcess::getTaskId, taskProcess.getTaskId()))
            .stream()
            .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId));
         Map<Long, List<MesBuildingAssistNumberDetail>> nextTaskssistNumberDetailMap = this.assistNumberDetailService
            .list((Wrapper<MesBuildingAssistNumberDetail>)new LambdaQueryWrapper<MesBuildingAssistNumberDetail>().eq(MesBuildingAssistNumberDetail::getTaskId, taskProcess.getTaskId()))
            .stream()
            .collect(Collectors.groupingBy(MesBuildingAssistNumberDetail::getTaskProcessId));
         Map<String, MesBuildingAssist> nextTaskGroupsAssistMap = this.list(
               (Wrapper<MesBuildingAssist>)new LambdaQueryWrapper<MesBuildingAssist>().eq(MesBuildingAssist::getTaskId, taskProcess.getTaskId())
            )
            .stream()
            .collect(Collectors.toMap(e -> e.getTaskProcessId() + "-" + e.getProductionLineId(), Function.identity()));
         List<Integer> linkNumbers = needDeleteNumbers.stream().map(MesBuildingAssistNumberDetail::getNumber).collect(Collectors.toList());
         this.assistRemoveNextList(
            nextProcessIds, nextTaskProcessListMap, taskProcess, linkNumbers, nextTaskssistNumberDetailMap, needDeleteNumbers, nextTaskGroupsAssistMap
         );
         this.assistNumberDetailService.removeByIds(needDeleteNumbers.stream().map(MesBuildingAssistNumberDetail::getId).collect(Collectors.toList()));
         List<MesBuildingAssist> removeAssist = nextTaskGroupsAssistMap.values().stream().filter(e -> e.getQuantity() <= 0).collect(Collectors.toList());
         List<MesBuildingAssist> updateAssist = nextTaskGroupsAssistMap.values()
            .stream()
            .filter(e -> e.getQuantity() > 0 && !e.getTaskProcessId().equals(taskProcessId))
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(removeAssist)) {
            Preconditions.checkArgument(removeAssist.stream().allMatch(e -> e.getQuantity() == 0 && e.getProduceQuantity() == 0), "操作失败,后续工序的协同数据异常!");
            this.removeByIds(removeAssist.stream().map(MesBuildingAssist::getId).collect(Collectors.toList()));
         }

         if (CollectionUtils.isNotEmpty(updateAssist)) {
            Preconditions.checkArgument(updateAssist.stream().allMatch(e -> e.getQuantity() >= e.getProduceQuantity()), "操作失败,后续工序的协同数据异常!");
            updateAssist.forEach(e -> e.setBoolFinishEnum(e.getQuantity().equals(e.getProduceQuantity())));
            this.baseService.updateBatchById(updateAssist);
         }

         needDeleteNumbers = new ArrayList<>();
      }

      Map<Long, List<MesBuildingTaskProcess>> nextTaskProcessListMap = this.taskProcessBiz
         .list((Wrapper<MesBuildingTaskProcess>)new LambdaQueryWrapper<MesBuildingTaskProcess>().eq(MesBuildingTaskProcess::getTaskId, taskProcess.getTaskId()))
         .stream()
         .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId));
      Map<Long, List<MesBuildingAssistNumberDetail>> nextTaskssistNumberDetailMap = this.assistNumberDetailService
         .list((Wrapper<MesBuildingAssistNumberDetail>)new LambdaQueryWrapper<MesBuildingAssistNumberDetail>().eq(MesBuildingAssistNumberDetail::getTaskId, taskProcess.getTaskId()))
         .stream()
         .collect(Collectors.groupingBy(MesBuildingAssistNumberDetail::getTaskProcessId));
      Map<String, MesBuildingAssist> nextTaskGroupsAssistMap = this.list(
            (Wrapper<MesBuildingAssist>)new LambdaQueryWrapper<MesBuildingAssist>().eq(MesBuildingAssist::getTaskId, taskProcess.getTaskId())
         )
         .stream()
         .collect(Collectors.toMap(e -> e.getTaskProcessId() + "-" + e.getProductionLineId(), Function.identity()));
      List<MesBuildingAssistProductDTO> taskProcessAssistList = this.taskProcessBiz
         .getProductAssistList(
            taskProcess.getTaskOrderId(),
            taskProcess.getAreaId(),
            taskProcess.getProcessId(),
            taskProcess.getTaskTypeEnum(),
            null,
            null,
            Collections.singletonList(taskProcess.getId()),
            null
         );
      Map<Long, MesBuildingAssistProductDTO> taskProcessAssistMap = taskProcessAssistList.stream()
         .collect(Collectors.toMap(MesBuildingAssistProductDTO::getId, Function.identity()));
      MesBuildingAssistProductDTO taskProcessAssistDetails = taskProcessAssistMap.get(taskProcessId);
      if (CollectionUtils.isNotEmpty(newAssisList)) {
         List<MesBuildingProductProcess> productProcessList = this.productProcessService
            .list(
               Wrappers.lambdaQuery(MesBuildingProductProcess.class)
                  .eq(MesBuildingProductProcess::getProductType, taskProcess.getTaskTypeEnum())
                  .eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE)
                  .eq(MesBuildingProductProcess::getTypeId, task.getClassificationId())
                  .in(
                     MesBuildingProductProcess::getProductionLineId,
                     newAssisList.stream().map(AssistDTOParam::getProductionLineId).collect(Collectors.toList())
                  )
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(productProcessList), "操作失败,所选产品类型未在协同产线下配置工序班组!");
         productProcessList = productProcessList.stream().filter(item -> item.getPartType() == null).collect(Collectors.toList());
         Map<String, MesBuildingProductProcess> productProcessMap = productProcessList.stream()
            .collect(Collectors.toMap(s -> s.getProductionLineId() + "-" + s.getProductType() + "-" + s.getTypeId(), Function.identity()));
         Map<Long, List<MesBuildingTaskProcessLinkDTO>> productLinkProcessesMap = this.utilsBiz
            .getProductLinkProcesses(productProcessList.stream().map(MesBuildingProductProcess::getId).collect(Collectors.toList()));
         int newAssistQuantity = newAssisList.stream().mapToInt(AssistDTOParam::getQuantity).sum();
         int totalAssistProduceQuantity = oldAssistMap.values().stream().mapToInt(MesBuildingAssist::getProduceQuantity).sum();
         int oldTotalQuantity = oldAssistMap.values().stream().mapToInt(MesBuildingAssist::getQuantity).sum();
         Preconditions.checkArgument(
            newAssistQuantity - oldTotalQuantity <= taskProcessAssistDetails.getTotalCanAssistMete().getQuantity(),
            "协同总数不可大于可协同总数" + taskProcessAssistDetails.getTotalCanAssistMete().getQuantity()
         );
         Preconditions.checkArgument(newAssistQuantity > totalAssistProduceQuantity, "协同总数不可小于协同已完成数");
         List<Integer> numberList = taskProcessAssistDetails.getNumberList();
         if (CollectionUtils.isNotEmpty(assembleNumbers)) {
            numberList = numberList.stream().filter(assembleNumbers::contains).collect(Collectors.toList());
         }

         Preconditions.checkArgument(CollectionUtils.isNotEmpty(numberList), "操作失败,可协同数不足,请刷新页面重试!");
         Collections.sort(numberList);
         List<MesBuildingAssistNumberDetail> numberDetailList = new ArrayList<>();

         for (AssistDTOParam assistParam : newAssisList) {
            MesbuildingTaskProcessAssistDTO dto = MesbuildingTaskProcessAssistDTO.builder()
               .taskProcessId(assistParam.getId())
               .quantity(assistParam.getQuantity())
               .productionLineId(assistParam.getProductionLineId())
               .nextProcessIds(
                  CollectionUtils.isEmpty(assistParam.getNextProcessIds())
                     ? assistParam.getNextProcessIds()
                     : assistParam.getNextProcessIds().stream().distinct().collect(Collectors.toList())
               )
               .build();
            Preconditions.checkArgument(!taskProcess.getProductionLineId().equals(assistParam.getProductionLineId()), "操作失败,不可协同给原生产组!");
            int canAssist = taskProcess.getTaskQuantity() - taskProcess.getCompleteQuantity();
            Long productId = taskProcess.getProductId();
            Integer taskTypeEnum = taskProcess.getTaskTypeEnum();
            Preconditions.checkArgument(canAssist > 0, "操作失败！：工序已完成");
            MesBuildingProductProcess mesBuildingProductProcess = productProcessMap.get(
               dto.getProductionLineId() + "-" + taskProcess.getTaskTypeEnum() + "-" + task.getClassificationId()
            );
            Preconditions.checkArgument(mesBuildingProductProcess != null, "操作失败,所选产品类型未在协同产线下配置工序班组!");
            List<MesBuildingTaskProcessLinkDTO> mesBuildingTaskProcessLinkDTOS = productLinkProcessesMap.get(mesBuildingProductProcess.getId());
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesBuildingTaskProcessLinkDTOS), "操作失败,所选产品类型未在协同产线下配置工序班组!");
            Map<Long, MesBuildingTaskProcessLinkDTO> processLinkDTOMap = mesBuildingTaskProcessLinkDTOS.stream()
               .collect(Collectors.toMap(MesBuildingTaskProcessLinkDTO::getProcessId, Function.identity()));
            MesBuildingTaskProcessLinkDTO mesBuildingTaskProcessLinkDTO = processLinkDTOMap.get(taskProcess.getProcessId());
            Preconditions.checkArgument(mesBuildingTaskProcessLinkDTO != null, "操作失败,所选产品类型未在协同产线下配置工序班组!");
            MesBuildingAssist assist = oldAssistMap.get(assistParam.getProductionLineId());
            if (assist == null) {
               MesBuildingProductionLine productionLine = this.productionLineService.getById(assistParam.getProductionLineId());
               assist = MesBuildingAssist.builder()
                  .taskId(taskProcess.getTaskId())
                  .userId(UserUtil.getCurrentUserId())
                  .taskProcessId(assistParam.getId())
                  .boolFinishEnum(Boolean.FALSE)
                  .quantity(assistParam.getQuantity())
                  .productionLineId(assistParam.getProductionLineId())
                  .processId(taskProcess.getProcessId())
                  .projectId(taskProcess.getProjectId())
                  .sequence(taskProcess.getSequence())
                  .workshopId(productionLine.getWorkshopId())
                  .taskCreateTime(taskProcess.getCreateTime())
                  .taskTypeEnum(taskProcess.getTaskTypeEnum())
                  .teamId(mesBuildingTaskProcessLinkDTO.getTeamId())
                  .classId(productProcess.getTypeId())
                  .build();
               this.save(assist);
               List<Integer> linkNumbers = assistParam.getNumbers();
               if (CollectionUtils.isEmpty(linkNumbers)) {
                  linkNumbers = numberList.stream().limit(assistParam.getQuantity().intValue()).collect(Collectors.toList());
               }

               Preconditions.checkArgument(new HashSet<>(numberList).containsAll(linkNumbers), "操作失败,请刷新重试!");
               numberList.removeAll(linkNumbers);
               Preconditions.checkArgument(linkNumbers.size() == assistParam.getQuantity(), "操作失败,协同数量与码号数量冲突!");

               for (Integer number : linkNumbers) {
                  MesBuildingAssistNumberDetail numberDetail = MesBuildingAssistNumberDetail.builder()
                     .assistId(assist.getId())
                     .taskProcessId(taskProcessId)
                     .taskId(assist.getTaskId())
                     .productionLineId(assistParam.getProductionLineId())
                     .userId(UserUtil.getCurrentUserId())
                     .productId(productId)
                     .taskType(taskTypeEnum)
                     .number(number)
                     .boolFinishEnum(Boolean.FALSE)
                     .processId(taskProcess.getProcessId())
                     .teamId(mesBuildingTaskProcessLinkDTO.getTeamId())
                     .projectId(taskProcess.getProjectId())
                     .productType(taskProcess.getTaskTypeEnum())
                     .build();
                  numberDetailList.add(numberDetail);
               }

               this.assistSaveNextList(
                  dto,
                  nextTaskProcessListMap,
                  taskProcess,
                  linkNumbers,
                  nextTaskssistNumberDetailMap,
                  needDeleteNumbers,
                  nextTaskGroupsAssistMap,
                  numberDetailList,
                  processLinkDTOMap,
                  productProcess
               );
            } else {
               new ArrayList();
               Integer oldQuantity = assist.getQuantity();
               int appendQuantity = assistParam.getQuantity() - oldQuantity;
               List<Integer> appendNumbers = numberList.stream().limit(appendQuantity).collect(Collectors.toList());
               Preconditions.checkArgument(new HashSet<>(numberList).containsAll(appendNumbers), "操作失败,请刷新重试!");
               numberList.removeAll(appendNumbers);
               Preconditions.checkArgument(appendNumbers.size() == appendQuantity, "操作失败,协同数量与码号数量冲突!");

               for (Integer number : appendNumbers) {
                  MesBuildingAssistNumberDetail numberDetail = MesBuildingAssistNumberDetail.builder()
                     .assistId(assist.getId())
                     .taskProcessId(taskProcessId)
                     .taskId(assist.getTaskId())
                     .productionLineId(assistParam.getProductionLineId())
                     .userId(UserUtil.getCurrentUserId())
                     .productId(productId)
                     .taskType(taskTypeEnum)
                     .number(number)
                     .boolFinishEnum(Boolean.FALSE)
                     .processId(taskProcess.getProcessId())
                     .teamId(mesBuildingTaskProcessLinkDTO.getTeamId())
                     .projectId(assist.getProjectId())
                     .productType(taskProcess.getTaskTypeEnum())
                     .build();
                  numberDetailList.add(numberDetail);
               }

               assist.setQuantity(assistParam.getQuantity());
               Preconditions.checkArgument(assist.getProduceQuantity() <= assist.getQuantity(), "操作失败,协同数量不可大于已生产数量!!");
               assist.setBoolFinishEnum(assist.getQuantity().equals(assist.getProduceQuantity()));
               this.updateById(assist);
               this.assistSaveNextList(
                  dto,
                  nextTaskProcessListMap,
                  taskProcess,
                  appendNumbers,
                  nextTaskssistNumberDetailMap,
                  needDeleteNumbers,
                  nextTaskGroupsAssistMap,
                  numberDetailList,
                  processLinkDTOMap,
                  productProcess
               );
            }
         }

         this.assistNumberDetailService.saveBatch(numberDetailList);
         if (CollectionUtils.isNotEmpty(needDeleteNumbers)) {
            this.assistNumberDetailService.removeByIds(needDeleteNumbers.stream().map(MesBuildingAssistNumberDetail::getId).collect(Collectors.toList()));
         }

         List<MesBuildingAssist> removeAssist = nextTaskGroupsAssistMap.values().stream().filter(e -> e.getQuantity() <= 0).collect(Collectors.toList());
         List<MesBuildingAssist> updateAssist = nextTaskGroupsAssistMap.values().stream().filter(e -> e.getQuantity() > 0).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(removeAssist)) {
            Preconditions.checkArgument(removeAssist.stream().allMatch(e -> e.getQuantity() == 0 && e.getProduceQuantity() == 0), "操作失败,后续工序的协同数据异常!");
            this.removeByIds(removeAssist.stream().map(MesBuildingAssist::getId).collect(Collectors.toList()));
         }

         if (CollectionUtils.isNotEmpty(updateAssist)) {
            Preconditions.checkArgument(updateAssist.stream().allMatch(e -> e.getQuantity() >= e.getProduceQuantity()), "操作失败,后续工序的协同数据异常!");
            updateAssist.forEach(e -> e.setBoolFinishEnum(e.getQuantity().equals(e.getProduceQuantity())));
            this.baseService.updateBatchById(updateAssist);
         }
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean assistRomve(List<Long> ids) {
      Preconditions.checkArgument(!ids.isEmpty(), "操作失败，参数不正确");
      List<MesBuildingAssist> assistList = this.list(
         Wrappers.lambdaQuery(MesBuildingAssist.class).in(MesBuildingAssist::getTaskProcessId, ids).eq(MesBuildingAssist::getBoolFinishEnum, Boolean.FALSE)
      );
      Preconditions.checkArgument(assistList.size() == ids.size(), "操作失败，已完成的工序不可删除");
      this.remove(Wrappers.lambdaQuery(MesBuildingAssist.class).in(MesBuildingAssist::getTaskProcessId, ids));
      return Boolean.TRUE;
   }

   @Override
   public List<MesBuildingAssist> listUserLinkAssIst(Long taskId, List<UserLinkGroupProcessDTO> groupProcessLinks, Integer taskTypeEnum) {
      return this.baseMapper.listUserLinkAssIst(taskId, groupProcessLinks, taskTypeEnum);
   }

   @Override
   public List<MesBuildingAssist> listUserLinkAssIst2(Long taskId, List<UserLinkLineProcessDTO> lineProcessLinks, Integer taskTypeEnum) {
      return this.baseMapper.listUserLinkAssIst2(taskId, lineProcessLinks, taskTypeEnum);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean assistSaveList(List<MesbuildingTaskProcessAssistDTO> taskProcessAssistDTOS) {
      Preconditions.checkArgument(taskProcessAssistDTOS.stream().allMatch(e -> e.getQuantity() > 0), "操作失败,协同数量不可为0!");
      List<Long> taskProcessIds = taskProcessAssistDTOS.stream().map(MesbuildingTaskProcessAssistDTO::getTaskProcessId).distinct().collect(Collectors.toList());
      List<MesBuildingTaskProcess> taskProcessList = this.taskProcessBiz.listByIds(taskProcessIds);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(taskProcessList) && taskProcessList.size() == taskProcessIds.size(), "操作失败,工序任务不存在!");
      List<Long> taskIds = taskProcessList.stream().map(MesBuildingTaskProcess::getTaskId).collect(Collectors.toList());
      Map<Long, MesBuildingTask> taskMap = this.mesBuildingTaskService
         .listByIds(taskIds)
         .stream()
         .collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
      MesBuildingTaskProcess taskProcess = taskProcessList.get(0);
      Preconditions.checkArgument(taskProcessList.stream().allMatch(e -> e.getTaskTypeEnum().equals(taskProcess.getTaskTypeEnum())), "操作失败,所选产品类型不一致!");
      this.mesBuildingTaskBiz
         .checkProductStatus(
            taskProcessList.stream().map(MesBuildingTaskProcess::getProductId).distinct().collect(Collectors.toList()), taskProcess.getTaskTypeEnum()
         );
      Map<Long, MesBuildingTaskProcess> taskProcessMap = taskProcessList.stream().collect(Collectors.toMap(MesBuildingTaskProcess::getId, Function.identity()));
      List<Long> artifactTaskIds = taskProcessAssistDTOS.stream()
         .map(MesbuildingTaskProcessAssistDTO::getArtifactTaskId)
         .distinct()
         .collect(Collectors.toList());
      Map<String, List<MesBuildingTaskNumberLink>> artifactTaskNumberLinkMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(artifactTaskIds)) {
         artifactTaskNumberLinkMap = this.taskNumberLinkService
            .list(
               (Wrapper<MesBuildingTaskNumberLink>)(new LambdaQueryWrapper<MesBuildingTaskNumberLink>()
                     .in(MesBuildingTaskNumberLink::getArtifactTaskId, artifactTaskIds))
                  .in(
                     MesBuildingTaskNumberLink::getAssembleTaskId, taskProcessList.stream().map(MesBuildingTaskProcess::getTaskId).collect(Collectors.toList())
                  )
            )
            .stream()
            .collect(Collectors.groupingBy(e -> e.getArtifactTaskId() + "-" + e.getAssembleTaskId()));
      }

      List<MesBuildingAssistProductDTO> taskProcessAssistList = this.taskProcessBiz
         .getProductAssistList(taskProcess.getTaskOrderId(), null, taskProcess.getProcessId(), taskProcess.getTaskTypeEnum(), null, null, taskProcessIds, null);
      Map<Long, MesBuildingAssistProductDTO> taskProcessAssistMap = taskProcessAssistList.stream()
         .collect(Collectors.toMap(MesBuildingAssistProductDTO::getId, Function.identity()));
      List<MesBuildingProductProcess> productProcessList = this.productProcessService
         .list(
            Wrappers.lambdaQuery(MesBuildingProductProcess.class)
               .eq(MesBuildingProductProcess::getProductType, taskProcess.getTaskTypeEnum())
               .eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE)
               .in(MesBuildingProductProcess::getTypeId, taskMap.values().stream().map(MesBuildingTask::getClassificationId).collect(Collectors.toList()))
               .in(
                  MesBuildingProductProcess::getProductionLineId,
                  taskProcessAssistDTOS.stream().map(MesbuildingTaskProcessAssistDTO::getProductionLineId).collect(Collectors.toList())
               )
         );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(productProcessList), "操作失败,产品未创建工序信息!");
      productProcessList = productProcessList.stream().filter(item -> item.getPartType() == null).collect(Collectors.toList());
      Map<String, MesBuildingProductProcess> productProcessMap = productProcessList.stream()
         .collect(Collectors.toMap(s -> s.getProductionLineId() + "-" + s.getProductType() + "-" + s.getTypeId(), Function.identity()));
      Map<Long, List<MesBuildingTaskProcessLinkDTO>> productLinkProcessesMap = this.utilsBiz
         .getProductLinkProcesses(productProcessList.stream().map(MesBuildingProductProcess::getId).collect(Collectors.toList()));
      Map<String, MesBuildingAssist> assistMap = this.baseService
         .list(
            (Wrapper<MesBuildingAssist>)new LambdaQueryWrapper<MesBuildingAssist>()
               .in(
                  MesBuildingAssist::getTaskProcessId,
                  taskProcessAssistDTOS.stream().map(MesbuildingTaskProcessAssistDTO::getTaskProcessId).collect(Collectors.toList())
               )
         )
         .stream()
         .collect(Collectors.toMap(e -> e.getTaskProcessId() + "-" + e.getProductionLineId(), Function.identity()));
      List<MesBuildingAssistNumberDetail> numberDetailList = new ArrayList<>();
      List<MesBuildingAssistNumberDetail> removeNumberDetailList = new ArrayList<>();
      Map<Long, List<MesBuildingTaskProcess>> nextTaskProcessListMap = this.taskProcessBiz
         .list((Wrapper<MesBuildingTaskProcess>)new LambdaQueryWrapper<MesBuildingTaskProcess>().in(MesBuildingTaskProcess::getTaskId, taskIds))
         .stream()
         .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId));
      Map<Long, List<MesBuildingAssistNumberDetail>> nextTaskssistNumberDetailMap = this.assistNumberDetailService
         .list((Wrapper<MesBuildingAssistNumberDetail>)new LambdaQueryWrapper<MesBuildingAssistNumberDetail>().in(MesBuildingAssistNumberDetail::getTaskId, taskIds))
         .stream()
         .collect(Collectors.groupingBy(MesBuildingAssistNumberDetail::getTaskProcessId));
      Map<String, MesBuildingAssist> nextTaskGroupsAssistMap = this.list(
            (Wrapper<MesBuildingAssist>)new LambdaQueryWrapper<MesBuildingAssist>().in(MesBuildingAssist::getTaskId, taskIds)
         )
         .stream()
         .collect(Collectors.toMap(e -> e.getTaskProcessId() + "-" + e.getProductionLineId(), Function.identity()));

      for (MesbuildingTaskProcessAssistDTO dto : taskProcessAssistDTOS) {
         dto.setNextProcessIds(
            CollectionUtils.isEmpty(dto.getNextProcessIds())
               ? dto.getNextProcessIds()
               : dto.getNextProcessIds().stream().distinct().collect(Collectors.toList())
         );
         MesBuildingAssistProductDTO append = taskProcessAssistMap.get(dto.getTaskProcessId());
         MesBuildingTaskProcess dtoTaskProcess = taskProcessMap.get(dto.getTaskProcessId());
         if (dtoTaskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType()) && dto.getArtifactTaskId() != null) {
            List<MesBuildingTaskNumberLink> numberLinks = artifactTaskNumberLinkMap.get(dto.getArtifactTaskId() + "-" + dtoTaskProcess.getTaskId());
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(numberLinks), "操作失败,构件任务关联信息异常!");
            List<Integer> assembleNumbers = numberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList());
            append.setNumberList(append.getNumberList().stream().filter(assembleNumbers::contains).collect(Collectors.toList()));
         }

         Preconditions.checkArgument(dto.getQuantity() != 0, "操作失败,协同数量不可为0!");
         MesBuildingTaskProcess linkTaskProcess = taskProcessMap.get(dto.getTaskProcessId());
         Preconditions.checkArgument(!linkTaskProcess.getProductionLineId().equals(dto.getProductionLineId()), "操作失败,不可协同给原生产线!");
         MesBuildingTask task = taskMap.get(linkTaskProcess.getTaskId());
         Preconditions.checkArgument(task != null, "操作失败,任务不存在!");
         MesBuildingProductProcess mesBuildingProductProcess = productProcessMap.get(
            dto.getProductionLineId() + "-" + linkTaskProcess.getTaskTypeEnum() + "-" + task.getClassificationId()
         );
         Preconditions.checkArgument(mesBuildingProductProcess != null, "操作失败,所选产品类型未在协同产线下配置工序班组!");
         List<MesBuildingTaskProcessLinkDTO> mesBuildingTaskProcessLinkDTOS = productLinkProcessesMap.get(mesBuildingProductProcess.getId());
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesBuildingTaskProcessLinkDTOS), "操作失败,所选产品类型未在协同产线下配置工序班组!");
         Map<Long, MesBuildingTaskProcessLinkDTO> processLinkDTOMap = mesBuildingTaskProcessLinkDTOS.stream()
            .collect(Collectors.toMap(MesBuildingTaskProcessLinkDTO::getProcessId, Function.identity()));
         MesBuildingTaskProcessLinkDTO mesBuildingTaskProcessLinkDTO = processLinkDTOMap.get(linkTaskProcess.getProcessId());
         Preconditions.checkArgument(mesBuildingTaskProcessLinkDTO != null, "操作失败,所选产品类型未在协同产线下配置工序班组!");
         MesBuildingAssistProductDTO append1 = taskProcessAssistMap.get(dto.getTaskProcessId());
         Preconditions.checkArgument(
            append1.getTotalCanAssistMete().getQuantity() >= dto.getQuantity(), "操作失败,不可超出最大可协同数" + append1.getTotalCanAssistMete().getQuantity()
         );
         MesBuildingAssist assist = assistMap.get(dto.getTaskProcessId() + "-" + dto.getProductionLineId());
         if (assist == null) {
            MesBuildingProductionLine productionLine = this.productionLineService.getById(dto.getProductionLineId());
            assist = MesBuildingAssist.builder()
               .taskId(taskProcessMap.get(dto.getTaskProcessId()).getTaskId())
               .userId(UserUtil.getCurrentUserId())
               .taskProcessId(dto.getTaskProcessId())
               .boolFinishEnum(Boolean.FALSE)
               .quantity(dto.getQuantity())
               .productionLineId(dto.getProductionLineId())
               .processId(taskProcess.getProcessId())
               .projectId(taskProcess.getProjectId())
               .sequence(taskProcess.getSequence())
               .workshopId(productionLine.getWorkshopId())
               .taskCreateTime(taskProcess.getCreateTime())
               .taskTypeEnum(taskProcess.getTaskTypeEnum())
               .teamId(mesBuildingTaskProcessLinkDTO.getTeamId())
               .classId(mesBuildingProductProcess.getTypeId())
               .build();
            this.save(assist);
            assistMap.put(assist.getTaskProcessId() + "-" + assist.getProductionLineId(), assist);
         } else {
            assist.setQuantity(assist.getQuantity() + dto.getQuantity());
            assist.setBoolFinishEnum(Boolean.FALSE);
            this.updateById(assist);
         }

         List<Integer> numberList = append.getNumberList();
         numberList = numberList.stream().limit(dto.getQuantity().intValue()).collect(Collectors.toList());
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(numberList), "操作失败,数据异常,请刷新重试!");

         for (Integer number : numberList) {
            MesBuildingAssistNumberDetail numberDetail = MesBuildingAssistNumberDetail.builder()
               .assistId(assist.getId())
               .taskProcessId(dto.getTaskProcessId())
               .taskId(assist.getTaskId())
               .productionLineId(dto.getProductionLineId())
               .teamId(assist.getTeamId())
               .userId(UserUtil.getCurrentUserId())
               .taskType(linkTaskProcess.getTaskTypeEnum())
               .productId(linkTaskProcess.getProductId())
               .number(number)
               .boolFinishEnum(Boolean.FALSE)
               .processId(taskProcess.getProcessId())
               .projectId(taskProcess.getProjectId())
               .productType(taskProcess.getTaskTypeEnum())
               .build();
            numberDetailList.add(numberDetail);
         }

         this.assistSaveNextList(
            dto,
            nextTaskProcessListMap,
            linkTaskProcess,
            numberList,
            nextTaskssistNumberDetailMap,
            removeNumberDetailList,
            nextTaskGroupsAssistMap,
            numberDetailList,
            processLinkDTOMap,
            mesBuildingProductProcess
         );
      }

      this.assistNumberDetailService.saveBatch(numberDetailList);
      if (CollectionUtils.isNotEmpty(removeNumberDetailList)) {
         this.assistNumberDetailService.removeByIds(removeNumberDetailList.stream().map(MesBuildingAssistNumberDetail::getId).collect(Collectors.toList()));
      }

      List<MesBuildingAssist> removeAssist = nextTaskGroupsAssistMap.values().stream().filter(e -> e.getQuantity() <= 0).collect(Collectors.toList());
      List<MesBuildingAssist> updateAssist = nextTaskGroupsAssistMap.values().stream().filter(e -> e.getQuantity() > 0).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(removeAssist)) {
         Preconditions.checkArgument(removeAssist.stream().allMatch(e -> e.getQuantity() == 0 && e.getProduceQuantity() == 0), "操作失败,后续工序的协同数据异常!");
         this.removeByIds(removeAssist.stream().map(MesBuildingAssist::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(updateAssist)) {
         Preconditions.checkArgument(updateAssist.stream().allMatch(e -> e.getQuantity() >= e.getProduceQuantity()), "操作失败,后续工序的协同数据异常!");
         updateAssist.forEach(e -> e.setBoolFinishEnum(e.getQuantity().equals(e.getProduceQuantity())));
         this.baseService.updateBatchById(updateAssist);
      }

      return Boolean.TRUE;
   }

   private void assistSaveNextList(
      MesbuildingTaskProcessAssistDTO dto,
      Map<Long, List<MesBuildingTaskProcess>> nextTaskProcessListMap,
      MesBuildingTaskProcess linkTaskProcess,
      List<Integer> numberList,
      Map<Long, List<MesBuildingAssistNumberDetail>> nextTaskssistNumberDetailMap,
      List<MesBuildingAssistNumberDetail> removeNumberDetailList,
      Map<String, MesBuildingAssist> nextTaskGroupsAssistMap,
      List<MesBuildingAssistNumberDetail> numberDetailList,
      Map<Long, MesBuildingTaskProcessLinkDTO> processLinkDTOMap,
      MesBuildingProductProcess productProcess
   ) {
      List<MesBuildingTaskProcess> allTaskProcesses = nextTaskProcessListMap.get(linkTaskProcess.getTaskId());
      if (CollectionUtils.isNotEmpty(dto.getNextProcessIds())) {
         dto.setNextProcessIds(dto.getNextProcessIds().stream().distinct().collect(Collectors.toList()));
         Map<Long, MesBuildingTaskProcess> taskProcessIdMap = allTaskProcesses.stream()
            .collect(Collectors.toMap(MesBuildingTaskProcess::getProcessId, Function.identity()));

         for (Long nextProcessId : dto.getNextProcessIds()) {
            MesBuildingTaskProcess nextTaskProcess = taskProcessIdMap.get(nextProcessId);
            if (nextTaskProcess != null) {
               List<MesBuildingAssistNumberDetail> nextNumberDetailList = nextTaskssistNumberDetailMap.get(nextTaskProcess.getId());
               if (CollectionUtils.isNotEmpty(nextNumberDetailList)) {
                  List<MesBuildingAssistNumberDetail> numberDetails = nextNumberDetailList.stream()
                     .filter(e -> numberList.contains(e.getNumber()))
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(numberDetails)) {
                     Preconditions.checkArgument(numberDetails.stream().noneMatch(MesBuildingAssistNumberDetail::getBoolFinishEnum), "操作失败,数据异常,下一道工序已上报!");
                     removeNumberDetailList.addAll(numberDetails);

                     for (MesBuildingAssistNumberDetail numberDetail : numberDetails) {
                        MesBuildingAssist nextmesBuildingAssist = nextTaskGroupsAssistMap.get(
                           numberDetail.getTaskProcessId() + "-" + numberDetail.getProductionLineId()
                        );
                        nextmesBuildingAssist.setQuantity(nextmesBuildingAssist.getQuantity() - 1);
                     }
                  }
               }

               if (CollectionUtils.isNotEmpty(numberList)) {
                  MesBuildingTaskProcessLinkDTO mesBuildingTaskProcessLinkDTO = processLinkDTOMap.get(nextTaskProcess.getProcessId());
                  Preconditions.checkArgument(mesBuildingTaskProcessLinkDTO != null, "操作失败,所选产品类型的后续工序未在协同产线下配置工序班组!");
                  MesBuildingAssist nextAssist = nextTaskGroupsAssistMap.get(nextTaskProcess.getId() + "-" + dto.getProductionLineId());
                  if (nextAssist == null) {
                     MesBuildingProductionLine productionLine = this.productionLineService.getById(dto.getProductionLineId());
                     nextAssist = MesBuildingAssist.builder()
                        .taskId(nextTaskProcess.getTaskId())
                        .userId(UserUtil.getCurrentUserId())
                        .taskProcessId(nextTaskProcess.getId())
                        .boolFinishEnum(Boolean.FALSE)
                        .quantity(dto.getQuantity())
                        .produceQuantity(0)
                        .productionLineId(dto.getProductionLineId())
                        .processId(nextTaskProcess.getProcessId())
                        .projectId(nextTaskProcess.getProjectId())
                        .sequence(nextTaskProcess.getSequence())
                        .workshopId(productionLine.getWorkshopId())
                        .taskCreateTime(nextTaskProcess.getCreateTime())
                        .taskTypeEnum(nextTaskProcess.getTaskTypeEnum())
                        .teamId(mesBuildingTaskProcessLinkDTO.getTeamId())
                        .classId(productProcess.getTypeId())
                        .build();
                     this.save(nextAssist);
                     nextTaskGroupsAssistMap.put(nextAssist.getTaskProcessId() + "-" + nextAssist.getProductionLineId(), nextAssist);
                  } else {
                     nextAssist.setQuantity(nextAssist.getQuantity() + dto.getQuantity());
                     nextAssist.setBoolFinishEnum(Boolean.FALSE);
                  }

                  for (Integer number : numberList) {
                     MesBuildingAssistNumberDetail numberDetail = MesBuildingAssistNumberDetail.builder()
                        .assistId(nextAssist.getId())
                        .taskProcessId(nextAssist.getTaskProcessId())
                        .taskId(nextAssist.getTaskId())
                        .productionLineId(dto.getProductionLineId())
                        .teamId(nextAssist.getTeamId())
                        .userId(UserUtil.getCurrentUserId())
                        .taskType(linkTaskProcess.getTaskTypeEnum())
                        .productId(linkTaskProcess.getProductId())
                        .number(number)
                        .boolFinishEnum(Boolean.FALSE)
                        .processId(nextAssist.getProcessId())
                        .projectId(nextAssist.getProjectId())
                        .productType(nextAssist.getProductType())
                        .build();
                     numberDetailList.add(numberDetail);
                  }
               }
            }
         }
      }
   }

   private void assistRemoveNextList(
      List<Long> nextProcessIds,
      Map<Long, List<MesBuildingTaskProcess>> nextTaskProcessListMap,
      MesBuildingTaskProcess linkTaskProcess,
      List<Integer> numberList,
      Map<Long, List<MesBuildingAssistNumberDetail>> nextTaskssistNumberDetailMap,
      List<MesBuildingAssistNumberDetail> removeNumberDetailList,
      Map<String, MesBuildingAssist> nextTaskGroupsAssistMap
   ) {
      List<MesBuildingTaskProcess> allTaskProcesses = nextTaskProcessListMap.get(linkTaskProcess.getTaskId());
      if (CollectionUtils.isNotEmpty(nextProcessIds)) {
         Map<Long, MesBuildingTaskProcess> taskProcessIdMap = allTaskProcesses.stream()
            .collect(Collectors.toMap(MesBuildingTaskProcess::getProcessId, Function.identity()));

         for (Long nextProcessId : nextProcessIds) {
            MesBuildingTaskProcess nextTaskProcess = taskProcessIdMap.get(nextProcessId);
            if (nextTaskProcess != null) {
               List<MesBuildingAssistNumberDetail> nextNumberDetailList = nextTaskssistNumberDetailMap.get(nextTaskProcess.getId());
               if (CollectionUtils.isNotEmpty(nextNumberDetailList)) {
                  List<MesBuildingAssistNumberDetail> numberDetails = nextNumberDetailList.stream()
                     .filter(e -> numberList.contains(e.getNumber()))
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(numberDetails)) {
                     Preconditions.checkArgument(numberDetails.stream().noneMatch(MesBuildingAssistNumberDetail::getBoolFinishEnum), "操作失败,数据异常,下一道工序已上报!");
                     removeNumberDetailList.addAll(numberDetails);

                     for (MesBuildingAssistNumberDetail numberDetail : numberDetails) {
                        MesBuildingAssist nextmesBuildingAssist = nextTaskGroupsAssistMap.get(
                           numberDetail.getTaskProcessId() + "-" + numberDetail.getProductionLineId()
                        );
                        nextmesBuildingAssist.setQuantity(nextmesBuildingAssist.getQuantity() - 1);
                     }
                  }
               }
            }
         }
      }
   }
}
