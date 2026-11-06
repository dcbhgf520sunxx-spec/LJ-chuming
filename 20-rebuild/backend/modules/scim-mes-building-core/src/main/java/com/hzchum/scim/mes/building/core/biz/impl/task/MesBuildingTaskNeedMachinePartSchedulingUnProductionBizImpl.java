package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskNeedMachinePartSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskNeedMachinePartSchedulingUnProductionBiz;
import com.hzchum.scim.mes.building.core.api.enums.task.IssuedToNestingSoftwareStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MachinePartSchedulingUnProductionDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartSchedulingUnProduction;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MachinePartSchedulingUnProductionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.PicturePathDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartSchedulingUnProductionParam;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNeedMachinePartSchedulingUnProductionService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskNeedMachinePartSchedulingUnProductionMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingTaskNeedMachinePartSchedulingUnProductionBizImpl
   extends IBizImpl<MesBuildingTaskNeedMachinePartSchedulingUnProductionService, MesBuildingTaskNeedMachinePartSchedulingUnProductionMapper, MesBuildingTaskNeedMachinePartSchedulingUnProduction>
   implements MesBuildingTaskNeedMachinePartSchedulingUnProductionBiz {
   @Resource
   private MesBuildingTaskNeedMachinePartSchedulingBiz needMachinePartSchedulingBiz;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private TechDrawingService drawingService;
   @Resource
   private MesBuildingTaskBiz taskBiz;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private MesBuildingTaskNumberLinkService numberLinkService;
   @Value("${chum.config.url}")
   private String ip;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveUnProduction(List<MachinePartSchedulingUnProductionParam> paramList) {
      List<MachinePartSchedulingUnProductionParam> paramNewList = new ArrayList<>();
      paramList.forEach(
         param -> {
            Long needId = param.getNeedId();
            MesBuildingTaskNeedMachinePartScheduling mesBuildingTaskNeedMachinePartScheduling = this.needMachinePartSchedulingBiz.getById(needId);
            Long taskOrderId = mesBuildingTaskNeedMachinePartScheduling.getTaskOrderId();
            Long productId = mesBuildingTaskNeedMachinePartScheduling.getProductId();
            List<MesBuildingTaskNeedMachinePartScheduling> mesBuildingTaskNeedMachinePartSchedulingList = this.needMachinePartSchedulingBiz
               .list(
                  (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)(new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                        .eq(MesBuildingTaskNeedMachinePartScheduling::getProductId, productId))
                     .eq(MesBuildingTaskNeedMachinePartScheduling::getTaskOrderId, taskOrderId)
               );
            Preconditions.checkArgument(
               mesBuildingTaskNeedMachinePartSchedulingList.stream().noneMatch(MesBuildingTaskNeedMachinePartScheduling::getSendNestingStatus),
               "操作失败,存在已下发的零件!"
            );
            mesBuildingTaskNeedMachinePartSchedulingList.forEach(e -> {
               MachinePartSchedulingUnProductionParam machinePartSchedulingUnProductionParam = new MachinePartSchedulingUnProductionParam();
               machinePartSchedulingUnProductionParam.setNeedId(e.getId());
               machinePartSchedulingUnProductionParam.setQuantity(e.getNeedQuantity());
               paramNewList.add(machinePartSchedulingUnProductionParam);
            });
         }
      );
      Map<Long, MesBuildingTaskNeedMachinePartScheduling> needMachinePartSchedulingMap = this.needMachinePartSchedulingBiz
         .listByIds(paramNewList.stream().map(MachinePartSchedulingUnProductionParam::getNeedId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(MesBuildingTaskNeedMachinePartScheduling::getId, Function.identity()));
      paramNewList.forEach(
         param -> {
            Preconditions.checkArgument(param.getQuantity() > 0, "操作失败：数量必须大于0");
            MesBuildingTaskNeedMachinePartSchedulingUnProduction unProduction = this.baseService
               .getOne(
                  Wrappers.lambdaQuery(MesBuildingTaskNeedMachinePartSchedulingUnProduction.class)
                     .eq(MesBuildingTaskNeedMachinePartSchedulingUnProduction::getNeedId, param.getNeedId())
               );
            MesBuildingTaskNeedMachinePartScheduling needMachinePartScheduling = needMachinePartSchedulingMap.get(param.getNeedId());
            needMachinePartScheduling.setNeedQuantity(needMachinePartScheduling.getNeedQuantity() - param.getQuantity());
            Preconditions.checkArgument(needMachinePartScheduling.getNeedQuantity() >= needMachinePartScheduling.getSchedulingQuantity(), "操作失败：数量超出可排产数量");
            Preconditions.checkArgument(needMachinePartScheduling.getNeedQuantity() >= 0, "操作失败：数量超出可排产数量");
            this.needMachinePartSchedulingBiz.updateById(needMachinePartScheduling);
            MesBuildingTask task = this.taskBiz.getById(needMachinePartScheduling.getTaskId());
            if (task.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
               TechArtifact artifact = this.artifactService.getById(task.getProductId());
               Preconditions.checkArgument(!artifact.getBoolAllPartSendDirectly(), "操作失败：檩条不可操作");
            }

            TechMachinePart machinePart = this.machinePartService.getById(needMachinePartScheduling.getProductId());
            machinePart.setProducedQuantity(machinePart.getProducedQuantity() + param.getQuantity());
            this.machinePartService.updateById(machinePart);
            if (unProduction == null) {
               this.baseService
                  .save(
                     MesBuildingTaskNeedMachinePartSchedulingUnProduction.builder()
                        .needId(param.getNeedId())
                        .quantity(param.getQuantity())
                        .useId(UserUtil.getCurrentUserId())
                        .projectId(needMachinePartScheduling.getProjectId())
                        .monomerId(needMachinePartScheduling.getMonomerId())
                        .areaId(needMachinePartScheduling.getAreaId())
                        .workshopId(needMachinePartScheduling.getWorkshopId())
                        .productionLineId(needMachinePartScheduling.getProductionLineId())
                        .groupsId(needMachinePartScheduling.getGroupsId())
                        .productId(needMachinePartScheduling.getProductId())
                        .taskId(needMachinePartScheduling.getTaskId())
                        .build()
                  );
            } else {
               unProduction.setQuantity(unProduction.getQuantity() + param.getQuantity());
               this.baseService.updateById(unProduction);
            }
         }
      );
      return Boolean.TRUE;
   }

   @Override
   public PageVO<MachinePartSchedulingUnProductionDTO> getUnProductionPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productionLineId,
      Long groupsId,
      String artifactSerialNumber,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.getUnProductionList(projectId, monomerId, areaId, workshopId, productionLineId, groupsId, artifactSerialNumber, serialNumber)
      );
   }

   @Override
   public List<MachinePartSchedulingUnProductionDTO> getUnProductionList(
      Long projectId, Long monomerId, Long areaId, Long workshopId, Long productionLineId, Long groupsId, String artifactSerialNumber, String serialNumber
   ) {
      List<MachinePartSchedulingUnProductionDTO> dtoList = this.baseService
         .getUnProductionList(projectId, monomerId, areaId, workshopId, productionLineId, groupsId, artifactSerialNumber, serialNumber)
         .stream()
         .map(e -> BeanUtil.copy(e, MachinePartSchedulingUnProductionDTO.class))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(dtoList)) {
         dtoList.stream()
            .collect(Collectors.groupingBy(MachinePartSchedulingUnProductionDO::getTaskTypeEnum))
            .forEach(
               (type, dtoList1) -> {
                  if (type.equals(TaskTypeEnum.ARTIFACT.getType())) {
                     List<MesBuildingTask> mesBuildingTasks = this.taskBiz
                        .listByIds(dtoList1.stream().map(MachinePartSchedulingUnProductionDO::getTaskId).collect(Collectors.toList()));
                     Map<Long, TechArtifact> techArtifactMap = this.artifactService
                        .listByIds(mesBuildingTasks.stream().map(MesBuildingTask::getProductId).collect(Collectors.toSet()))
                        .stream()
                        .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
                     Map<Long, MesBuildingTask> taskMap = mesBuildingTasks.stream().collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
                     dtoList1.forEach(e -> {
                        MesBuildingTask mesBuildingTask = taskMap.get(e.getTaskId());
                        e.setArtifactSerialNumber(techArtifactMap.get(mesBuildingTask.getProductId()).getSerialNumber());
                     });
                  }

                  if (type.equals(TaskTypeEnum.ASSEMBLE.getType())) {
                     List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinkList = this.numberLinkService
                        .list(
                           (Wrapper<MesBuildingTaskNumberLink>)new LambdaQueryWrapper<MesBuildingTaskNumberLink>()
                              .in(
                                 MesBuildingTaskNumberLink::getAssembleTaskId,
                                 dtoList1.stream().map(MachinePartSchedulingUnProductionDO::getTaskId).collect(Collectors.toList())
                              )
                        );
                     Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesBuildingTaskNumberLinkList), "部件任务不存在");
                     Map<Long, List<MesBuildingTaskNumberLink>> assembleTaskIdMap = mesBuildingTaskNumberLinkList.stream()
                        .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleTaskId));
                     Map<Long, TechArtifact> techArtifactMap = this.artifactService
                        .listByIds(mesBuildingTaskNumberLinkList.stream().map(MesBuildingTaskNumberLink::getArtifactId).collect(Collectors.toSet()))
                        .stream()
                        .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
                     dtoList1.forEach(e -> {
                        MesBuildingTaskNumberLink mesBuildingTaskNumberLink = assembleTaskIdMap.get(e.getTaskId()).get(0);
                        e.setArtifactSerialNumber(techArtifactMap.get(mesBuildingTaskNumberLink.getArtifactId()).getSerialNumber());
                     });
                  }
               }
            );
         Map<Long, String> pictureMap = new HashMap<>();
         List<PicturePathDTO> techDrawing = this.drawingService
            .selectMachDrawing(dtoList.stream().map(MachinePartSchedulingUnProductionDO::getProductId).collect(Collectors.toList()));
         techDrawing.forEach(e -> {
            String var10000 = pictureMap.put(e.getProductId(), this.ip + "files/" + e.getPicturePath());
         });
         dtoList.forEach(e -> e.setPicturePath(pictureMap.get(e.getProductId()) == null ? null : pictureMap.get(e.getProductId())));
      }

      return dtoList;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateUnProduction(Long id, Integer quantity) {
      MesBuildingTaskNeedMachinePartSchedulingUnProduction unProduction = this.baseService.getById(id);
      Preconditions.checkArgument(unProduction != null, "操作失败：id不正确");
      Preconditions.checkArgument(quantity < unProduction.getQuantity(), "操作失败：数量超过可删除数量");
      Integer reduceQuantity = -(quantity - unProduction.getQuantity());
      unProduction.setQuantity(unProduction.getQuantity() - reduceQuantity);
      MesBuildingTaskNeedMachinePartScheduling machinePartScheduling = this.needMachinePartSchedulingBiz.getById(unProduction.getNeedId());
      if (!machinePartScheduling.getSendNestingStatus()
         && !machinePartScheduling.getIssuedToNestingSoftwareStatus().equals(IssuedToNestingSoftwareStatusEnum.ISSUED_IN_PROGRESS.getType())) {
         machinePartScheduling.setNeedQuantity(machinePartScheduling.getNeedQuantity() + reduceQuantity);
         this.needMachinePartSchedulingBiz.updateById(machinePartScheduling);
      } else {
         MesBuildingTaskNeedMachinePartScheduling newTaskNeedMachinePartScheduling = BeanUtil.copy(
            machinePartScheduling, MesBuildingTaskNeedMachinePartScheduling.class
         );
         newTaskNeedMachinePartScheduling.setNeedQuantity(unProduction.getQuantity());
         newTaskNeedMachinePartScheduling.setNeedQuantity(reduceQuantity);
         newTaskNeedMachinePartScheduling.setSchedulingQuantity(0);
         newTaskNeedMachinePartScheduling.setSendNestingStatus(Boolean.FALSE);
         newTaskNeedMachinePartScheduling.setIssuedToNestingSoftwareStatus(IssuedToNestingSoftwareStatusEnum.NOT_ISSUED_YET.getType());
         newTaskNeedMachinePartScheduling.setNestingJobId(null);
         newTaskNeedMachinePartScheduling.setSchedulingDate(null);
         newTaskNeedMachinePartScheduling.setSchedulingUserId(null);
         newTaskNeedMachinePartScheduling.setIssuedToNestingSoftwareOperationTime(null);
         this.needMachinePartSchedulingBiz.save(newTaskNeedMachinePartScheduling);
         unProduction.setNeedId(newTaskNeedMachinePartScheduling.getId());
      }

      TechMachinePart machinePart = this.machinePartService.getById(unProduction.getProductId());
      machinePart.setProducedQuantity(machinePart.getProducedQuantity() - reduceQuantity);
      this.machinePartService.updateById(machinePart);
      if (unProduction.getQuantity() > 0) {
         this.baseService.updateById(unProduction);
      } else {
         this.baseService.removeById(unProduction);
      }

      return null;
   }
}
