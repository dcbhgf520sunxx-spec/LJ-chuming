package com.hzchum.scim.mes.building.core.biz.impl.task;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.scim.common.core.api.enums.SteelPlateTypeEnum;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.cut.core.api.biz.NestBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNestCutPlateBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNestCutPlatePartBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingProduceTeamReportBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskFastBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.SaveProduceTeamReportSummaryTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.TeamReportTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.CutStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.manager.MesBuildingCalcMaxNumManager;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MachinePartCompoleteReporyDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.record.MesBuildingProductProductionSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuNestingResult;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlatePart;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssistNumberDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingInProduction;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReportSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingSinglePartArtifactPrint;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.ProductProductionSummaryDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.IdAndRecelveQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.AddWarehouseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.machine_part_raw_material.MachinePartReportRawMaterialFeedingRecordParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingProduceTeamReportDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.machine_part_raw_material.MesMachinePartRawMaterialFeedingRecordService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.record.MesBuildingProductProductionSummaryService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuNestingResultService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlatePartService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistNumberDetailService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingInProductionService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportSummaryService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingSinglePartArtifactPrintService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskMapper;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.api.service.notification.SysPushNotificationConfigService;
import com.hzchum.scim.wms.core.api.manager.PickingApproveOutboundMesManger;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.MaterialConfig;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

@Service
public class MesBuildingTaskFastBizImpl extends ServiceImpl<MesBuildingTaskMapper, MesBuildingTask> implements MesBuildingTaskFastBiz {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingTaskFastBizImpl.class);
   @Value("${chum.config.url}")
   private String ip;
   @Autowired
   private SysPushNotificationConfigService pushNotificationConfigService;
   @Autowired
   private RedisUtils redisUtils;
   @Autowired
   private MesBuildingTeamService teamService;
   @Resource
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Resource
   private MesBuildingSinglePartArtifactPrintService singlePartArtifactPrintService;
   @Autowired
   private MesBuildingInProductionService inProductionService;
   @Resource
   private MesBuildingTaskNumberLinkService mesBuildingTaskNumberLinkService;
   @Resource
   private MesBuildingAssistNumberDetailService numberDetailService;
   @Resource
   private MesBuildingCalcMaxNumManager mesBuildingCalcMaxNumManager;
   @Resource
   private TechMachinePartService techMachinePartService;
   @Autowired
   private MesBuildingBoChuNestingResultService mesBuildingBoChuNestingResultService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingProduceTeamReportBiz teamReportBiz;
   @Autowired
   private TechAssembleDetailService assembleDetailService;
   @Resource
   private MesBuildingProductProductionSummaryService productionSummaryService;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Autowired
   private TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Autowired
   private MesBuildingProduceTeamReportSummaryService produceTeamReportSummaryService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private MesBuildingCompleteService completeService;
   @Autowired
   private MesBuildingTaskOrderBiz taskOrderBiz;
   @Autowired
   private MesBuildingNestCutPlatePartService nestCutPlatePartService;
   @Autowired
   private MesBuildingNestCutPlateBiz nestCutPlateBiz;
   @Autowired
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Autowired
   private MesBuildingAssistNumberDetailService assistNumberDetailService;
   @Autowired
   private MesBuildingTaskNumberLinkService taskNumberLinkService;
   @Resource
   private MesBuildingNestCutPlatePartBiz nestCutPlatePartBiz;
   @Resource
   private MesBuildingTaskOrderService mesBuildingTaskOrderService;
   @Resource
   NestBiz nestBiz;
   @Autowired
   private MesMachinePartRawMaterialFeedingRecordService mesMachinePartRawMaterialFeedingRecordService;
   @Autowired
   private PickingApproveOutboundMesManger pickingApproveOutboundMesManger;
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   private UserService userService;
   @Resource
   private MesBuildingProductProductionSummaryService productProductionSummaryService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveNestCutPlateReportFast(
      Long nestCutPlateId,
      List<Long> partIds,
      String ncCode,
      Boolean reportType,
      List<IdAndRecelveQuantityDTO> parts,
      Long userIdNest,
      List<MachinePartReportRawMaterialFeedingRecordParam> rawMaterialList
   ) {
      MesBuildingNestCutPlate nestCutPlate = this.nestCutPlateBiz
         .getOne(
            Wrappers.lambdaQuery(MesBuildingNestCutPlate.class)
               .eq(MesBuildingNestCutPlate::getId, nestCutPlateId)
               .eq(ncCode != null, MesBuildingNestCutPlate::getNcCode, ncCode)
         );
      StopWatch stopWatch = new StopWatch();
      stopWatch.start();
      Preconditions.checkArgument(nestCutPlate != null, "操作失败：任务切割指令不存在");
      if (CollUtil.isNotEmpty(rawMaterialList)) {
         this.mesMachinePartRawMaterialFeedingRecordService.machinePartReportBatchAdd(rawMaterialList);
         List<Long> pickingApproveDetailIdList = rawMaterialList.stream()
            .map(MachinePartReportRawMaterialFeedingRecordParam::getPickingApproveDetailId)
            .collect(Collectors.toList());
         this.pickingApproveOutboundMesManger.yesProcess(pickingApproveDetailIdList);
      }

      if (!nestCutPlate.getBoolNestCutEnum()) {
         Preconditions.checkArgument(!nestCutPlate.getBoolProductionEunm(), "操作失败：该切割指令已上报");
         Map<Long, Integer> partMap = parts.stream()
            .collect(Collectors.toMap(IdAndRecelveQuantityDTO::getProductId, IdAndRecelveQuantityDTO::getReceivedQuantity));
         List<Long> processIds = this.processService
            .list(
               Wrappers.lambdaQuery(MesBuildingProcess.class)
                  .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
                  .ne(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType())
            )
            .stream()
            .map(MesBuildingProcess::getId)
            .collect(Collectors.toList());
         List<MesBuildingTaskProcess> list = this.taskProcessService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                  .eq(MesBuildingTaskProcess::getNestCutPlateId, nestCutPlateId)
                  .in(!partMap.isEmpty(), MesBuildingTaskProcess::getProductId, partMap.keySet())
                  .in(MesBuildingTaskProcess::getProcessId, processIds)
                  .eq(MesBuildingTaskProcess::getSequence, 0)
            );
         ArrayList<MesBuildingNestCutPlatePart> cutPlateParts = new ArrayList<>();
         List<Long> nestCutPlateIds = list.stream().map(MesBuildingTaskProcess::getNestCutPlateId).distinct().collect(Collectors.toList());
         List<Long> productIds = list.stream().map(MesBuildingTaskProcess::getProductId).distinct().collect(Collectors.toList());
         List<MesBuildingNestCutPlatePart> nestCutPlateParts = this.nestCutPlatePartBiz
            .list(
               Wrappers.lambdaQuery(MesBuildingNestCutPlatePart.class)
                  .in(MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId, nestCutPlateIds)
                  .in(MesBuildingNestCutPlatePart::getPartId, productIds)
            );
         Map<String, MesBuildingNestCutPlatePart> nestCutPlatePartMap = nestCutPlateParts.stream()
            .collect(Collectors.toMap(part -> part.getMesBuildingNestCutPlateId() + "-" + part.getPartId(), part -> (MesBuildingNestCutPlatePart)part));
         List<MesBuildingProduceTeamReportDTOParam> mesBuildingProduceTeamReportDTOParamList = new ArrayList<>();
         List<MesBuildingTaskProcess> mesBuildingTaskProcessList = new ArrayList<>();
         Long taskOrderId = list.get(0).getTaskOrderId();
         MesBuildingTaskOrder mesBuildingTaskOrder = this.mesBuildingTaskOrderService.getById(taskOrderId);
         Boolean nestTask = Boolean.FALSE;
         if (null != mesBuildingTaskOrder.getJobId()) {
            nestTask = Boolean.TRUE;
         }

         for (MesBuildingTaskProcess taskProcess : list) {
            String key = taskProcess.getNestCutPlateId() + "-" + taskProcess.getProductId();
            MesBuildingNestCutPlatePart nestCutPlatePart = nestCutPlatePartMap.get(key);
            if (nestCutPlatePart != null) {
               nestCutPlatePart.setCompleteQuantity(nestCutPlatePart.getCompleteQuantity() + partMap.get(taskProcess.getProductId()));
               nestCutPlatePart.setBoolCompleteEnum(nestCutPlatePart.getQuantity().equals(nestCutPlatePart.getCompleteQuantity()));
               cutPlateParts.add(nestCutPlatePart);
               MesBuildingProduceTeamReportDTOParam mesBuildingProduceTeamReportDTOParam = MesBuildingProduceTeamReportDTOParam.builder()
                  .id(taskProcess.getId())
                  .reportQuantity(partMap.get(taskProcess.getProductId()))
                  .reportType(Boolean.FALSE)
                  .boolAssistEnum(Boolean.FALSE)
                  .taskOrderId(taskProcess.getTaskOrderId())
                  .nestTask(nestTask)
                  .build();
               mesBuildingProduceTeamReportDTOParamList.add(mesBuildingProduceTeamReportDTOParam);
               mesBuildingTaskProcessList.add(taskProcess);
            }
         }

         if (CollectionUtils.isNotEmpty(mesBuildingProduceTeamReportDTOParamList)) {
            this.saveProduceTeamReportFast(mesBuildingProduceTeamReportDTOParamList, mesBuildingTaskProcessList, userIdNest);
         }

         this.nestCutPlatePartService.updateBatchById(cutPlateParts);
         if (this.nestCutPlatePartBiz
               .count(
                  Wrappers.lambdaQuery(MesBuildingNestCutPlatePart.class)
                     .eq(MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId, nestCutPlate.getId())
                     .eq(MesBuildingNestCutPlatePart::getBoolCompleteEnum, Boolean.FALSE)
               )
            == 0) {
            nestCutPlate.setBoolProductionEunm(Boolean.TRUE);
            if (CollectionUtils.isNotEmpty(partMap.keySet())) {
               List<AppTaskProcessDTO> machinePartListByCutId = this.getMachinePartListByCutId(nestCutPlateId, null, null, null, null);
               int sum = machinePartListByCutId.stream().mapToInt(AppTaskProcessDTO::getQuantity).sum();
               nestCutPlate.setBoolProductionEunm(sum == 0);
            }

            this.nestCutPlateBiz.updateById(nestCutPlate);
            if (nestCutPlate.getBoolNestCutEnum()) {
               Preconditions.checkArgument(ncCode != null, "操作失败：扫描条形码有误");
               List<Long> checkNestCutPlateIdList = this.nestCutPlateBiz
                  .list(Wrappers.lambdaQuery(MesBuildingNestCutPlate.class).eq(MesBuildingNestCutPlate::getNcCode, ncCode))
                  .stream()
                  .map(MesBuildingNestCutPlate::getId)
                  .collect(Collectors.toList());
               Preconditions.checkArgument(checkNestCutPlateIdList.contains(nestCutPlate.getId()), "操作失败：扫码有误");
               Preconditions.checkArgument(nestCutPlate.getBoolNestCutEnum(), "操作失败：未绑定钢板");
            }
         }
      }

      stopWatch.stop();
      log.info("切割上报耗时：{}", stopWatch.getTotalTimeMillis());
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveDrillNestCutPlateReportFast(Long nestCutPlateId, List<IdAndRecelveQuantityDTO> parts, Boolean reportType, Long userIdNest) {
      MesBuildingNestCutPlate nestCutPlate = this.nestCutPlateBiz
         .getOne((Wrapper<MesBuildingNestCutPlate>)new LambdaQueryWrapper<MesBuildingNestCutPlate>().eq(MesBuildingNestCutPlate::getMachinePartSchedulingId, nestCutPlateId));
      if (this.nestCutPlatePartBiz
            .count(
               Wrappers.lambdaQuery(MesBuildingNestCutPlatePart.class)
                  .eq(MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId, nestCutPlate.getId())
                  .eq(MesBuildingNestCutPlatePart::getBoolCompleteEnum, Boolean.FALSE)
            )
         == 0) {
         nestCutPlate.setBoolProductionEunm(Boolean.TRUE);
         this.nestCutPlateBiz.updateById(nestCutPlate);
      }

      Map<Long, Integer> partMap = parts.stream()
         .collect(Collectors.toMap(IdAndRecelveQuantityDTO::getProductId, IdAndRecelveQuantityDTO::getReceivedQuantity));
      List<Long> processIds = this.processService
         .list(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
               .eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType())
         )
         .stream()
         .map(MesBuildingProcess::getId)
         .collect(Collectors.toList());
      List<MesBuildingTaskProcess> mesBuildingTaskProcessList = this.taskProcessService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
               .eq(MesBuildingTaskProcess::getMachinePartSchedulingId, nestCutPlateId)
               .in(!partMap.isEmpty(), MesBuildingTaskProcess::getProductId, partMap.keySet())
               .in(MesBuildingTaskProcess::getProcessId, processIds)
               .eq(MesBuildingTaskProcess::getSequence, 1)
         );
      Long taskOrderId = mesBuildingTaskProcessList.get(0).getTaskOrderId();
      MesBuildingTaskOrder mesBuildingTaskOrder = this.mesBuildingTaskOrderService.getById(taskOrderId);
      Boolean nestTask = Boolean.FALSE;
      if (null != mesBuildingTaskOrder.getJobId()) {
         nestTask = Boolean.TRUE;
      }

      List<MesBuildingProduceTeamReportDTOParam> mesBuildingProduceTeamReportDTOParamList = new ArrayList<>();

      for (MesBuildingTaskProcess taskProcess : mesBuildingTaskProcessList) {
         MesBuildingProduceTeamReportDTOParam mesBuildingProduceTeamReportDTOParam = MesBuildingProduceTeamReportDTOParam.builder()
            .id(taskProcess.getId())
            .reportQuantity(partMap.get(taskProcess.getProductId()))
            .reportType(Boolean.FALSE)
            .taskOrderId(taskProcess.getTaskOrderId())
            .nestTask(nestTask)
            .build();
         mesBuildingProduceTeamReportDTOParamList.add(mesBuildingProduceTeamReportDTOParam);
      }

      this.saveProduceTeamReportFast(mesBuildingProduceTeamReportDTOParamList, mesBuildingTaskProcessList, userIdNest);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public List<Integer> saveProduceTeamReportFast(
      List<MesBuildingProduceTeamReportDTOParam> mesBuildingProduceTeamReportDTOParamList,
      List<MesBuildingTaskProcess> mesBuildingTaskProcessList,
      Long userIdNest
   ) {
      mesBuildingProduceTeamReportDTOParamList.forEach(dtoParam -> Preconditions.checkArgument(dtoParam.getReportQuantity().intValue() > 0L, "上报数不能小于零"));
      List<Long> productIds = mesBuildingTaskProcessList.stream().map(MesBuildingTaskProcess::getProductId).collect(Collectors.toList());
      this.checkProductMachinePartStatusFast(productIds);
      Map<Long, MesBuildingTaskProcess> taskProcessMap = mesBuildingTaskProcessList.stream()
         .collect(Collectors.toMap(MesBuildingTaskProcess::getId, taskProcess -> (MesBuildingTaskProcess)taskProcess));
      mesBuildingProduceTeamReportDTOParamList.forEach(
         dtoParam -> {
            MesBuildingTaskProcess mesBuildingTaskProcess = taskProcessMap.get(dtoParam.getId());
            if (mesBuildingTaskProcess != null) {
               Preconditions.checkArgument(
                  dtoParam.getReportQuantity() <= mesBuildingTaskProcess.getNeedQuantity() - mesBuildingTaskProcess.getCompleteQuantity(), "操作失败：请刷新后重试!!"
               );
               Preconditions.checkArgument(
                  mesBuildingTaskProcess.getNeedQuantity() >= mesBuildingTaskProcess.getCompleteQuantity() + dtoParam.getReportQuantity(), "上报失败，超出可生产数量"
               );
               if (mesBuildingTaskProcess.getTeamId() != null) {
                  dtoParam.setTeamId(mesBuildingTaskProcess.getTeamId());
               }
            }
         }
      );
      return this.checkProductAndProduceTeamReportFast(mesBuildingTaskProcessList, mesBuildingProduceTeamReportDTOParamList, userIdNest);
   }

   @Override
   public List<AppTaskProcessDTO> getMachinePartListByCutId(Long cutId, Long projectId, Long monomerId, Long areaId, String serialNumber) {
      List<AppTaskProcessDTO> dtos = this.taskProcessService
         .listCutTaskByTaskOrderId(cutId, projectId, monomerId, areaId, serialNumber)
         .stream()
         .sorted(Comparator.comparing(AppTaskProcessDTO::getQuantity).reversed())
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(dtos)) {
         dtos = dtos.stream().map(s -> s.setPicturePath(this.ip + "files/" + s.getPicturePath())).collect(Collectors.toList());
      }

      return dtos;
   }

   @Override
   public Boolean checkProductMachinePartStatusFast(List<Long> productIds) {
      List<TechMachinePart> techMachineParts = this.techMachinePartService.listByIds(productIds);
      List<TechMachinePart> techMachinePartYFB = techMachineParts.stream()
         .filter(part -> part.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECONDARY_MEMBER.getType()))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(techMachinePartYFB)) {
         List<Long> productYFBIds = techMachinePartYFB.stream().map(TechMachinePart::getId).collect(Collectors.toList());
         List<TechAssembleMachinePartLink> assemblePartLinks = this.assembleMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getMachinePartId, productYFBIds));
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(assemblePartLinks), "翼腹板部件不存在");
         List<Long> assembleIds = assemblePartLinks.stream().map(TechAssembleMachinePartLink::getAssembleId).collect(Collectors.toList());
         List<TechAssembleDetail> assembleDetails = this.assembleDetailService
            .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getAssembleId, assembleIds));
         List<String> numbers = this.artifactService
            .listByIds(assembleDetails.stream().map(TechAssembleDetail::getArtifactId).collect(Collectors.toList()))
            .stream()
            .filter(s -> !s.getBoolStatusEnum())
            .map(TechArtifact::getSerialNumber)
            .collect(Collectors.toList());
         Preconditions.checkArgument(CollectionUtils.isEmpty(numbers), "本部件关联的构件:" + String.join(",", numbers) + "处于冻结中!!无法操作!!!");
      }

      List<TechMachinePart> techMachinePartOther = techMachineParts.stream()
         .filter(part -> !part.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECONDARY_MEMBER.getType()))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(techMachinePartOther)) {
         Map<Integer, List<TechMachinePart>> techMachinePartOtherMap = techMachinePartOther.stream()
            .collect(Collectors.groupingBy(TechMachinePart::getRelationType));
         techMachinePartOtherMap.forEach(
            (relationType, techMachinePartOtherList) -> {
               if (MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType().equals(relationType)) {
                  List<Long> productYFBIds = techMachinePartOtherList.stream().map(TechMachinePart::getId).collect(Collectors.toList());
                  List<TechAssembleMachinePartLink> assemblePartLinks = this.assembleMachinePartLinkService
                     .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getMachinePartId, productYFBIds));
                  Preconditions.checkArgument(CollectionUtils.isNotEmpty(assemblePartLinks), "翼腹板部件不存在");
                  List<Long> assembleIdsx = assemblePartLinks.stream().map(TechAssembleMachinePartLink::getAssembleId).collect(Collectors.toList());
                  List<TechAssembleDetail> assembleDetailsx = this.assembleDetailService
                     .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getAssembleId, assembleIdsx));
                  List<String> numbersxx = this.artifactService
                     .listByIds(assembleDetailsx.stream().map(TechAssembleDetail::getArtifactId).collect(Collectors.toList()))
                     .stream()
                     .filter(s -> !s.getBoolStatusEnum())
                     .map(TechArtifact::getSerialNumber)
                     .collect(Collectors.toList());
                  Preconditions.checkArgument(CollectionUtils.isEmpty(numbersxx), "本零件关联的层级区域:" + String.join(",", numbersxx) + "处于冻结中!!无法操作!!!");
               }

               if (MachinePartRelationTypeEnum.FOR_ARTIFACT.getType().equals(relationType)) {
                  List<Long> productOtherIds = techMachinePartOtherList.stream().map(TechMachinePart::getId).collect(Collectors.toList());
                  List<TechArtifactMachinePartLink> partLinks = this.artifactMachinePartLinkService
                     .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getMachinePartId, productOtherIds));
                  List<String> numbersx = this.artifactService
                     .listByIds(partLinks.stream().map(TechArtifactMachinePartLink::getArtifactId).collect(Collectors.toList()))
                     .stream()
                     .filter(s -> !s.getBoolStatusEnum())
                     .map(TechArtifact::getSerialNumber)
                     .collect(Collectors.toList());
                  Preconditions.checkArgument(CollectionUtils.isEmpty(numbersx), "本零件关联的构件:" + String.join(",", numbersx) + "处于冻结中!!无法操作!!!");
               }
            }
         );
      }

      return true;
   }

   private Integer getAssistQuantity(List<MesBuildingAssist> assistBizs, Integer productType) {
      int size = 0;
      if (CollectionUtil.isNotEmpty(assistBizs)) {
         List<MesBuildingAssistNumberDetail> assistNumberDetails = this.assistNumberDetailService
            .list(
               (Wrapper<MesBuildingAssistNumberDetail>)(new LambdaQueryWrapper<MesBuildingAssistNumberDetail>()
                     .in(MesBuildingAssistNumberDetail::getAssistId, assistBizs.stream().map(MesBuildingAssist::getId).collect(Collectors.toList())))
                  .eq(MesBuildingAssistNumberDetail::getBoolFinishEnum, Boolean.FALSE)
            );
         if (CollectionUtil.isNotEmpty(assistNumberDetails)) {
            Map<Long, List<Integer>> assistNumberDetailMap = assistNumberDetails.stream()
               .collect(
                  Collectors.groupingBy(
                     MesBuildingAssistNumberDetail::getTaskProcessId, Collectors.mapping(MesBuildingAssistNumberDetail::getNumber, Collectors.toList())
                  )
               );
            LambdaQueryWrapper<MesBuildingTaskNumberLink> taskNumberQueryWrapper = Wrappers.<MesBuildingTaskNumberLink>lambdaQuery();
            if (productType.equals(com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ARTIFACT.getType())) {
               for (Entry<Long, List<Integer>> entry : assistNumberDetailMap.entrySet()) {
                  if (taskNumberQueryWrapper.isEmptyOfNormal()) {
                     taskNumberQueryWrapper.eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, entry.getKey());
                     taskNumberQueryWrapper.in(MesBuildingTaskNumberLink::getArtifactNumber, entry.getValue());
                  } else {
                     taskNumberQueryWrapper.or(
                        subQuery -> {
                           LambdaQueryWrapper var10000 = subQuery.eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, entry.getKey())
                              .in(MesBuildingTaskNumberLink::getArtifactNumber, entry.getValue());
                        }
                     );
                  }
               }
            }

            if (productType.equals(com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ASSEMBLE.getType())) {
               for (Entry<Long, List<Integer>> entry : assistNumberDetailMap.entrySet()) {
                  if (taskNumberQueryWrapper.isEmptyOfNormal()) {
                     taskNumberQueryWrapper.eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, entry.getKey());
                     taskNumberQueryWrapper.in(MesBuildingTaskNumberLink::getAssembleNumber, entry.getValue());
                  } else {
                     taskNumberQueryWrapper.or(
                        subQuery -> {
                           LambdaQueryWrapper var10000 = subQuery.eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, entry.getKey())
                              .in(MesBuildingTaskNumberLink::getAssembleNumber, entry.getValue());
                        }
                     );
                  }
               }
            }

            List<MesBuildingTaskNumberLink> taskNumberLinks = this.taskNumberLinkService.list(taskNumberQueryWrapper);
            if (CollectionUtil.isNotEmpty(taskNumberLinks)) {
               if (productType.equals(com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ARTIFACT.getType())) {
                  size = taskNumberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().collect(Collectors.toList()).size();
               }

               if (productType.equals(com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ASSEMBLE.getType())) {
                  size = taskNumberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList()).size();
               }
            }
         }
      }

      return size;
   }

   List<Integer> checkProductAndProduceTeamReportFast(
      List<MesBuildingTaskProcess> mesBuildingTaskProcessList,
      List<MesBuildingProduceTeamReportDTOParam> mesBuildingProduceTeamReportDTOParamList,
      Long userIdNest
   ) {
      List<MesBuildingTaskProcess> firstMesBuildingTaskProcessList = mesBuildingTaskProcessList.stream()
         .filter(taskProcess -> taskProcess.getSequence() == 0)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(firstMesBuildingTaskProcessList)) {
         List<Long> ids = firstMesBuildingTaskProcessList.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList());
         List<MesBuildingProduceTeamReportDTOParam> firstMesBuildingProduceTeamReportDTOParamList = mesBuildingProduceTeamReportDTOParamList.stream()
            .filter(item -> ids.contains(item.getId()))
            .collect(Collectors.toList());
         this.updateQuantityFast(firstMesBuildingTaskProcessList, firstMesBuildingProduceTeamReportDTOParamList);
      }

      List<Long> productIds = mesBuildingTaskProcessList.stream().map(MesBuildingTaskProcess::getProductId).collect(Collectors.toList());
      this.productProduceTeamReportFast(mesBuildingTaskProcessList, mesBuildingProduceTeamReportDTOParamList, userIdNest);
      return null;
   }

   private void updateQuantityFast(
      List<MesBuildingTaskProcess> mesBuildingTaskProcessList, List<MesBuildingProduceTeamReportDTOParam> mesBuildingProduceTeamReportDTOParamList
   ) {
      Map<Long, MesBuildingTaskProcess> taskProcessMap = mesBuildingTaskProcessList.stream()
         .collect(Collectors.toMap(MesBuildingTaskProcess::getId, taskProcess -> (MesBuildingTaskProcess)taskProcess));
      List<ProductProductionSummaryDTOParam> productProductionSummaryDTOParamList = new ArrayList<>();
      mesBuildingProduceTeamReportDTOParamList.forEach(
         dtoParam -> {
            MesBuildingTaskProcess mesBuildingTaskProcess = taskProcessMap.get(dtoParam.getId());
            Integer reportQuantity = dtoParam.getReportQuantity();
            if (mesBuildingTaskProcess != null) {
               MesBuildingTask task = this.taskService.getById(mesBuildingTaskProcess.getTaskId());
               if (task.getInProductionTime() == null) {
                  task.setInProductionTime(LocalDateTime.now());
                  ContractProject project = this.projectService.getById(task.getProjectId());
                  if (project != null && project.getMesStartDate() == null) {
                     project.setMesStartDate(LocalDateTime.now());
                     this.projectService.updateById(project);
                  }
               }

               task.setInProductionQuantity(task.getInProductionQuantity() + reportQuantity);
               Preconditions.checkArgument(this.taskService.updateById(task), "上报中,请刷新页面");
               productProductionSummaryDTOParamList.add(
                  ProductProductionSummaryDTOParam.builder()
                     .projectId(task.getProjectId())
                     .monomerId(task.getMonomerId())
                     .productId(task.getProductId())
                     .productType(task.getTaskTypeEnum())
                     .inProductionQuantity(reportQuantity)
                     .build()
               );
            }
         }
      );
      this.updateRecordFast(productProductionSummaryDTOParamList);
   }

   public boolean updateRecordFast(List<ProductProductionSummaryDTOParam> productProductionSummaryDTOParamList) {
      List<MesBuildingProductProductionSummary> addList = new ArrayList<>();
      List<MesBuildingProductProductionSummary> updateList = new ArrayList<>();
      List<Long> productIds = productProductionSummaryDTOParamList.stream().map(ProductProductionSummaryDTOParam::getProductId).collect(Collectors.toList());
      List<MesBuildingProductProductionSummary> summaryList = this.productProductionSummaryService
         .list(
            (Wrapper<MesBuildingProductProductionSummary>)(new LambdaQueryWrapper<MesBuildingProductProductionSummary>()
                  .in(MesBuildingProductProductionSummary::getProductId, productIds))
               .eq(MesBuildingProductProductionSummary::getMonth, DateTimeUtil.getLocalMonthStr())
         );
      Map<String, MesBuildingProductProductionSummary> summaryListMap = summaryList.stream()
         .collect(
            Collectors.toMap(
               item -> item.getProductId() + "-" + item.getProductType() + "-" + item.getMonth(),
               item -> (MesBuildingProductProductionSummary)item,
               (existing, replacement) -> replacement
            )
         );

      for (ProductProductionSummaryDTOParam param : productProductionSummaryDTOParamList) {
         MesBuildingProductProductionSummary summary = summaryListMap.get(
            param.getProductId().toString() + "-" + param.getProductType().toString() + "-" + DateTimeUtil.getLocalMonthStr()
         );
         if (summary == null) {
            summary = MesBuildingProductProductionSummary.builder().build();
            summary.setProjectId(param.getProjectId());
            summary.setMonomerId(param.getMonomerId());
            summary.setProductId(param.getProductId());
            summary.setProductType(param.getProductType());
            summary.setTaskQuantity(param.getTaskQuantity());
            summary.setCompleteQuantity(param.getCompleteQuantity());
            summary.setInProductionQuantity(param.getInProductionQuantity());
            summary.setMonth(DateTimeUtil.getLocalMonthStr());
            addList.add(summary);
         } else {
            summary.setTaskQuantity(summary.getTaskQuantity() + param.getTaskQuantity());
            summary.setCompleteQuantity(summary.getCompleteQuantity() + param.getCompleteQuantity());
            summary.setInProductionQuantity(summary.getInProductionQuantity() + param.getInProductionQuantity());
            updateList.add(summary);
         }
      }

      this.productProductionSummaryService.saveBatch(addList);
      this.productProductionSummaryService.updateBatchById(updateList);
      return false;
   }

   private List<Integer> productProduceTeamReportFast(
      List<MesBuildingTaskProcess> mesBuildingTaskProcessList,
      List<MesBuildingProduceTeamReportDTOParam> mesBuildingProduceTeamReportDTOParamList,
      Long userIdNest
   ) {
      return this.updateTaskProcessFast(mesBuildingTaskProcessList, mesBuildingProduceTeamReportDTOParamList, userIdNest);
   }

   List<Integer> updateTaskProcessFast(
      List<MesBuildingTaskProcess> mesBuildingTaskProcessList,
      List<MesBuildingProduceTeamReportDTOParam> mesBuildingProduceTeamReportDTOParamList,
      Long userIdNest
   ) {
      Long teamId = mesBuildingTaskProcessList.get(0).getTeamId();
      Map<Long, MesBuildingTaskProcess> taskProcessMap = mesBuildingTaskProcessList.stream()
         .collect(Collectors.toMap(MesBuildingTaskProcess::getId, taskProcess -> (MesBuildingTaskProcess)taskProcess));
      List<MesBuildingTaskProcess> mesBuildingTaskProcessNewList = new ArrayList<>();
      mesBuildingProduceTeamReportDTOParamList.forEach(dtoParam -> {
         MesBuildingTaskProcess mesBuildingTaskProcess = taskProcessMap.get(dtoParam.getId());
         Integer reportQuantity = dtoParam.getReportQuantity();
         if (mesBuildingTaskProcess != null) {
            MesBuildingTeam team = this.teamService.getById(teamId);
            Preconditions.checkArgument(team != null, "上报失败,用户没有处于可以生产班组内");
            mesBuildingTaskProcess.setCompleteQuantity(mesBuildingTaskProcess.getCompleteQuantity() + reportQuantity);
            mesBuildingTaskProcess.setInspectionQuantity(mesBuildingTaskProcess.getCompleteQuantity());
            if (mesBuildingTaskProcess.getCompleteQuantity().equals(mesBuildingTaskProcess.getNeedQuantity())) {
               mesBuildingTaskProcess.setCompleteTime(LocalDateTime.now());
            }

            mesBuildingTaskProcessNewList.add(mesBuildingTaskProcess);
         }
      });
      this.saveProduceTeamReportSummaryFast(
         mesBuildingTaskProcessList,
         mesBuildingProduceTeamReportDTOParamList,
         teamId,
         SaveProduceTeamReportSummaryTypeEnum.UN_INSPECTION_REPORT.getType(),
         userIdNest
      );
      this.saveTeamReportFast(mesBuildingTaskProcessList, mesBuildingProduceTeamReportDTOParamList, teamId, userIdNest);
      this.taskProcessService.updateBatchById(mesBuildingTaskProcessNewList);
      this.updateNextTaskProcessFast(mesBuildingTaskProcessList, mesBuildingProduceTeamReportDTOParamList, teamId, userIdNest);
      return null;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveProduceTeamReportSummaryFast(
      List<MesBuildingTaskProcess> mesBuildingTaskProcessList,
      List<MesBuildingProduceTeamReportDTOParam> mesBuildingProduceTeamReportDTOParamList,
      Long teamId,
      Integer type,
      Long userIdNest
   ) {
      List<Long> ids = mesBuildingTaskProcessList.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList());
      Map<Long, MesBuildingTaskProcess> taskProcessMap = mesBuildingTaskProcessList.stream()
         .collect(Collectors.toMap(MesBuildingTaskProcess::getId, taskProcess -> (MesBuildingTaskProcess)taskProcess));
      List<MesBuildingProduceTeamReportSummary> mesBuildingProduceTeamReportSummaryList = this.produceTeamReportSummaryService
         .list(
            (Wrapper<MesBuildingProduceTeamReportSummary>)(new LambdaQueryWrapper<MesBuildingProduceTeamReportSummary>()
                  .in(MesBuildingProduceTeamReportSummary::getTaskProcessId, ids))
               .eq(MesBuildingProduceTeamReportSummary::getTeamId, teamId)
         );
      Map<Long, MesBuildingProduceTeamReportSummary> mesBuildingProduceTeamReportSummaryMap = mesBuildingProduceTeamReportSummaryList.stream()
         .collect(
            Collectors.toMap(
               MesBuildingProduceTeamReportSummary::getTaskProcessId,
               mesBuildingProduceTeamReportSummary -> (MesBuildingProduceTeamReportSummary)mesBuildingProduceTeamReportSummary
            )
         );
      List<MesBuildingProduceTeamReportSummary> addSummaryList = new ArrayList<>();
      List<MesBuildingProduceTeamReportSummary> updateSummaryList = new ArrayList<>();
      mesBuildingProduceTeamReportDTOParamList.forEach(
         dtoParam -> {
            MesBuildingProduceTeamReportSummary produceTeamReportSummary = mesBuildingProduceTeamReportSummaryMap.get(dtoParam.getId());
            MesBuildingTaskProcess mesBuildingTaskProcess = taskProcessMap.get(dtoParam.getId());
            Integer reportQuantity = dtoParam.getReportQuantity();
            if (produceTeamReportSummary != null) {
               if (type.equals(SaveProduceTeamReportSummaryTypeEnum.PRODUCE_REPORT.getType())) {
                  produceTeamReportSummary.setQuantity(produceTeamReportSummary.getQuantity() + reportQuantity);
               }

               if (type.equals(SaveProduceTeamReportSummaryTypeEnum.UN_INSPECTION_REPORT.getType())) {
                  produceTeamReportSummary.setQuantity(produceTeamReportSummary.getQuantity() + reportQuantity);
                  produceTeamReportSummary.setInspectionQuantity(produceTeamReportSummary.getInspectionQuantity() + reportQuantity);
               } else if (type.equals(SaveProduceTeamReportSummaryTypeEnum.INSPECTION_REPORT.getType())) {
                  produceTeamReportSummary.setInspectionQuantity(produceTeamReportSummary.getInspectionQuantity() + reportQuantity);
               } else if (type.equals(SaveProduceTeamReportSummaryTypeEnum.PROBLEM_REPORT.getType())) {
                  produceTeamReportSummary.setProblemQuantity(produceTeamReportSummary.getProblemQuantity() + reportQuantity);
               } else if (type.equals(SaveProduceTeamReportSummaryTypeEnum.ADOPT_PROBLEM_REPORT.getType())) {
                  produceTeamReportSummary.setProblemQuantity(produceTeamReportSummary.getProblemQuantity() - reportQuantity);
                  produceTeamReportSummary.setInspectionQuantity(produceTeamReportSummary.getInspectionQuantity() + reportQuantity);
               }

               updateSummaryList.add(produceTeamReportSummary);
            } else {
               MesBuildingProduceTeamReportSummary summary = MesBuildingProduceTeamReportSummary.builder()
                  .productId(mesBuildingTaskProcess.getProductId())
                  .taskTypeEnum(mesBuildingTaskProcess.getTaskTypeEnum())
                  .processId(mesBuildingTaskProcess.getProcessId())
                  .taskId(mesBuildingTaskProcess.getTaskId())
                  .groupsId(mesBuildingTaskProcess.getGroupsId())
                  .teamId(teamId)
                  .taskProcessId(mesBuildingTaskProcess.getId())
                  .quantity(reportQuantity)
                  .schedulingId(mesBuildingTaskProcess.getSchedulingId())
                  .build();
               summary.setUserId(null == userIdNest ? UserUtil.getCurrentUserId() : userIdNest);
               if (type.equals(SaveProduceTeamReportSummaryTypeEnum.UN_INSPECTION_REPORT.getType())) {
                  summary.setInspectionQuantity(reportQuantity);
               }

               addSummaryList.add(summary);
            }
         }
      );
      this.produceTeamReportSummaryService.updateBatchById(updateSummaryList);
      this.produceTeamReportSummaryService.saveBatch(addSummaryList);
      return true;
   }

   @Override
   public Boolean updateNextTaskProcessFast(
      List<MesBuildingTaskProcess> mesBuildingTaskProcessList,
      List<MesBuildingProduceTeamReportDTOParam> mesBuildingProduceTeamReportDTOParamList,
      Long teamId,
      Long userIdNest
   ) {
      Map<Long, MesBuildingTaskProcess> taskProcessMap = mesBuildingTaskProcessList.stream()
         .collect(Collectors.toMap(MesBuildingTaskProcess::getId, taskProcess -> (MesBuildingTaskProcess)taskProcess));
      this.buildProductProcessFast(mesBuildingTaskProcessList, mesBuildingProduceTeamReportDTOParamList, teamId, userIdNest);
      MaterialConfig inventoryTypeConfig = this.basicConfigService.getInventoryTypeConfig();
      ArrayList<String> objects = new ArrayList<>();
      mesBuildingProduceTeamReportDTOParamList.forEach(
         dtoParam -> {
            MesBuildingTaskProcess taskProcess = taskProcessMap.get(dtoParam.getId());
            if (taskProcess != null) {
               Integer typeEnum = taskProcess.getTaskTypeEnum();
               List<MesBuildingTask> taskList = this.taskService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingTask.class)
                        .eq(MesBuildingTask::getTaskOrderId, taskProcess.getTaskOrderId())
                        .isNull(MesBuildingTask::getCompleteTime)
                  );
               if (taskList.size() == 0) {
                  MesBuildingTaskOrder taskOrder = this.taskOrderBiz.getById(taskProcess.getTaskOrderId());
                  taskOrder.setCompleteTime(LocalDateTime.now());
                  this.taskOrderBiz.updateById(taskOrder);
                  if (typeEnum.equals(TaskTypeEnum.MACHINE_PART.getType()) && null != taskOrder.getChildGuid()) {
                     List<MesBuildingBoChuNestingResult> mesBuildingBoChuNestingResultList = this.mesBuildingBoChuNestingResultService
                        .list(
                           (Wrapper<MesBuildingBoChuNestingResult>)(new LambdaQueryWrapper<MesBuildingBoChuNestingResult>()
                                 .eq(MesBuildingBoChuNestingResult::getChildGuid, taskOrder.getChildGuid()))
                              .eq(MesBuildingBoChuNestingResult::getCutStatus, 0)
                        );
                     if (inventoryTypeConfig.getInventoryGainType() == 1 && !objects.contains(taskOrder.getChildGuid())) {
                        this.nestBiz.passed(taskOrder.getChildGuid());
                        objects.add(taskOrder.getChildGuid());
                     }

                     if (CollectionUtil.isNotEmpty(mesBuildingBoChuNestingResultList)) {
                        mesBuildingBoChuNestingResultList.forEach(item -> {
                           item.setCutStatus(CutStatusEnum.CUT_COMPLETED.getCode());
                           BigDecimal taskRate = new BigDecimal("100").setScale(8, RoundingMode.HALF_UP);
                           item.setTaskRate(taskRate);
                           this.mesBuildingBoChuNestingResultService.updateById(item);
                        });
                     }
                  }
               }
            }
         }
      );
      return true;
   }

   @Override
   public List<Integer> saveTeamReportFast(
      List<MesBuildingTaskProcess> mesBuildingTaskProcessList,
      List<MesBuildingProduceTeamReportDTOParam> mesBuildingProduceTeamReportDTOParamList,
      Long teamId,
      Long userIdNest
   ) {
      List<MesBuildingProduceTeamReport> reports = new ArrayList<>();
      List<MesBuildingInProduction> inProductions = new ArrayList<>();
      LocalDateTime reportTime = LocalDateTime.now();
      Long reportNumber = this.redisUtils.incr("teamreport_reportnumber:", 1L);
      Map<Long, MesBuildingTaskProcess> taskProcessMap = mesBuildingTaskProcessList.stream()
         .collect(Collectors.toMap(MesBuildingTaskProcess::getId, taskProcess -> (MesBuildingTaskProcess)taskProcess));
      mesBuildingProduceTeamReportDTOParamList.forEach(
         dtoParam -> {
            MesBuildingTaskProcess taskProcess = taskProcessMap.get(dtoParam.getId());
            Boolean nestTask = dtoParam.getNestTask();
            Long taskOrderId = dtoParam.getTaskOrderId();
            Integer reportQuantity = dtoParam.getReportQuantity();
            if (taskProcess != null) {
               MesBuildingProduceTeamReport teamReport = MesBuildingProduceTeamReport.builder()
                  .productId(taskProcess.getProductId())
                  .taskTypeEnum(taskProcess.getTaskTypeEnum())
                  .processId(taskProcess.getProcessId())
                  .productionLineId(taskProcess.getProductionLineId())
                  .taskId(taskProcess.getTaskId())
                  .teamId(teamId)
                  .taskProcessId(taskProcess.getId())
                  .quantity(reportQuantity)
                  .boolHandleEnum(false)
                  .reportTime(reportTime)
                  .inspectionQuantity(reportQuantity)
                  .groupsId(taskProcess.getGroupsId())
                  .reportType(TeamReportTypeEnum.NORMAL.getType())
                  .schedulingId(taskProcess.getSchedulingId())
                  .assistId(null)
                  .reportNumber(reportNumber)
                  .sequence(taskProcess.getSequence())
                  .nestTask(nestTask)
                  .taskOrderId(taskOrderId)
                  .projectId(taskProcess.getProjectId())
                  .monomerId(taskProcess.getMonomerId())
                  .areaId(taskProcess.getAreaId())
                  .workshopId(taskProcess.getWorkshopId())
                  .build();
               teamReport.setUserId(null == userIdNest ? UserUtil.getCurrentUserId() : userIdNest);
               reports.add(teamReport);
            }
         }
      );
      this.produceTeamReportService.saveBatch(reports);
      mesBuildingProduceTeamReportDTOParamList.forEach(
         dtoParam -> {
            MesBuildingTaskProcess taskProcess = taskProcessMap.get(dtoParam.getId());
            Integer reportQuantity = dtoParam.getReportQuantity();

            for (MesBuildingProduceTeamReport teamReport : reports) {
               if (teamReport.getTaskProcessId().equals(dtoParam.getId()) && taskProcess.getSequence().equals(0)) {
                  MesBuildingInProduction inProduction = MesBuildingInProduction.builder()
                     .projectId(taskProcess.getProjectId())
                     .monomerId(taskProcess.getMonomerId())
                     .areaId(taskProcess.getAreaId())
                     .factoryId(taskProcess.getFactoryId())
                     .workshopId(taskProcess.getWorkshopId())
                     .productionLineId(taskProcess.getProductionLineId())
                     .taskId(taskProcess.getTaskId())
                     .productId(taskProcess.getProductId())
                     .productType(taskProcess.getTaskTypeEnum())
                     .teamReportId(teamReport.getId())
                     .teamId(teamReport.getTeamId())
                     .quantity(reportQuantity)
                     .number(teamReport.getNumber())
                     .build();
                  inProduction.setUserId(null == userIdNest ? UserUtil.getCurrentUserId() : userIdNest);
                  inProductions.add(inProduction);
               }
            }
         }
      );
      this.inProductionService.saveBatch(inProductions);
      return null;
   }

   private void buildProductProcessFast(
      List<MesBuildingTaskProcess> mesBuildingTaskProcessList,
      List<MesBuildingProduceTeamReportDTOParam> mesBuildingProduceTeamReportDTOParamList,
      Long teamId,
      Long userIdNest
   ) {
      List<MesBuildingTaskProcess> mesBuildingTaskProcessesNotNull = mesBuildingTaskProcessList.stream()
         .filter(item -> item.getNextProcessId() != null)
         .collect(Collectors.toList());
      List<MesBuildingTaskProcess> mesBuildingTaskProcessesIsNull = mesBuildingTaskProcessList.stream()
         .filter(item -> item.getNextProcessId() == null)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(mesBuildingTaskProcessesNotNull)) {
         List<MesBuildingTaskProcess> nextTaskProcessList = new ArrayList<>();
         Map<Long, MesBuildingTaskProcess> taskProcessMapNotNull = mesBuildingTaskProcessesNotNull.stream()
            .collect(Collectors.toMap(MesBuildingTaskProcess::getId, taskProcess -> (MesBuildingTaskProcess)taskProcess));
         mesBuildingProduceTeamReportDTOParamList.forEach(
            dtoParam -> {
               MesBuildingTaskProcess taskProcess = taskProcessMapNotNull.get(dtoParam.getId());
               Integer reportQuantity = dtoParam.getReportQuantity();
               if (null != taskProcess) {
                  MesBuildingTaskProcess nextTaskProcess = this.taskProcessService
                     .getOne(
                        (Wrapper<MesBuildingTaskProcess>)(Wrappers.<MesBuildingTaskProcess>lambdaQuery()
                              .eq(MesBuildingTaskProcess::getTaskId, taskProcess.getTaskId()))
                           .eq(MesBuildingTaskProcess::getProcessId, taskProcess.getNextProcessId())
                     );
                  assert nextTaskProcess != null;
                  nextTaskProcess.setNeedQuantity(nextTaskProcess.getNeedQuantity() + reportQuantity);
                  nextTaskProcessList.add(nextTaskProcess);
               }
            }
         );
         this.taskProcessService.updateBatchById(nextTaskProcessList);
      }

      if (CollectionUtils.isNotEmpty(mesBuildingTaskProcessesIsNull)) {
         List<ProductProductionSummaryDTOParam> productProductionSummaryDTOParamList = new ArrayList<>();
         List<MachinePartCompoleteReporyDO> machinePartCompoleteReporyDOList = new ArrayList<>();
         List<Long> productIds = mesBuildingTaskProcessesIsNull.stream().map(MesBuildingTaskProcess::getProductId).collect(Collectors.toList());
         Map<Long, TechMachinePart> machinePartMap = this.machinePartService
            .list((Wrapper<TechMachinePart>)new LambdaQueryWrapper<TechMachinePart>().in(TechMachinePart::getId, productIds))
            .stream()
            .collect(Collectors.toMap(TechMachinePart::getId, part -> (TechMachinePart)part));
         List<Long> taskIds = mesBuildingTaskProcessesIsNull.stream().map(MesBuildingTaskProcess::getTaskId).collect(Collectors.toList());
         Map<Long, MesBuildingTask> taskMap = this.taskService
            .list((Wrapper<MesBuildingTask>)new LambdaQueryWrapper<MesBuildingTask>().in(MesBuildingTask::getId, taskIds))
            .stream()
            .collect(Collectors.toMap(MesBuildingTask::getId, task -> (MesBuildingTask)task));
         Map<Long, MesBuildingTaskProcess> taskProcessMapIsNull = mesBuildingTaskProcessesIsNull.stream()
            .collect(Collectors.toMap(MesBuildingTaskProcess::getId, taskProcess -> (MesBuildingTaskProcess)taskProcess));
         List<TechMachinePart> techMachinePartList = new ArrayList<>();
         List<MesBuildingTask> mesBuildingTaskList = new ArrayList<>();
         mesBuildingProduceTeamReportDTOParamList.forEach(
            dtoParam -> {
               MesBuildingTaskProcess taskProcess = taskProcessMapIsNull.get(dtoParam.getId());
               Integer reportQuantity = dtoParam.getReportQuantity();
               if (null != taskProcess) {
                  TechMachinePart machinePart = machinePartMap.get(taskProcess.getProductId());
                  if (machinePart.getBoolProcess()) {
                     Preconditions.checkArgument(machinePart.getProducedQuantity() + reportQuantity <= machinePart.getQuantity(), "生产数量不能大于清单数量");
                     machinePart.setProducedQuantity(machinePart.getProducedQuantity() + reportQuantity);
                     techMachinePartList.add(machinePart);
                  }

                  MesBuildingTask task = taskMap.get(taskProcess.getTaskId());
                  task.setCompleteQuantity(task.getCompleteQuantity() + reportQuantity);
                  Preconditions.checkArgument(task.getTaskQuantity() >= task.getCompleteQuantity(), "操作失败!!!!");
                  if (task.getTaskQuantity().equals(task.getCompleteQuantity())) {
                     task.setCompleteTime(LocalDateTime.now());
                  }

                  mesBuildingTaskList.add(task);
                  machinePartCompoleteReporyDOList.add(
                     MachinePartCompoleteReporyDO.builder()
                        .mesBuildingTaskProcess(taskProcess)
                        .numberList(null)
                        .teamId(teamId)
                        .reportQuantity(reportQuantity)
                        .build()
                  );
                  productProductionSummaryDTOParamList.add(
                     ProductProductionSummaryDTOParam.builder()
                        .projectId(task.getProjectId())
                        .monomerId(task.getMonomerId())
                        .productId(task.getProductId())
                        .productType(task.getTaskTypeEnum())
                        .completeQuantity(reportQuantity)
                        .build()
                  );
               }
            }
         );
         this.saveCompoleteReportFast(machinePartCompoleteReporyDOList, userIdNest);
         this.updateRecordFast(productProductionSummaryDTOParamList);
         this.machinePartService.updateBatchById(techMachinePartList);
         this.taskService.updateBatchById(mesBuildingTaskList);
      }
   }

   private void saveCompoleteReport(MesBuildingTaskProcess taskProcess, Integer reportQuantity, Long teamId, List<Integer> numberList, Long userIdNest) {
      List<MesBuildingComplete> completes = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(numberList)) {
         for (Integer number : numberList) {
            MesBuildingComplete complete = BeanUtil.copy(taskProcess, MesBuildingComplete.class);
            complete.setUserId(UserUtil.getCurrentUserId());
            complete.setCreateTime(LocalDateTime.now());
            complete.setUpdateTime(null);
            complete.setBoolAbnormalEnum(false);
            complete.setQuantity(1);
            complete.setNumber(number);
            complete.setGroupsId(taskProcess.getGroupsId());
            complete.setTeamId(teamId);
            complete.setFactoryId(taskProcess.getFactoryId());
            completes.add(complete);
         }
      } else {
         MesBuildingComplete complete = BeanUtil.copy(taskProcess, MesBuildingComplete.class);
         complete.setUserId(UserUtil.getCurrentUserId());
         complete.setCreateTime(LocalDateTime.now());
         complete.setUpdateTime(null);
         complete.setBoolAbnormalEnum(false);
         complete.setQuantity(reportQuantity);
         complete.setGroupsId(taskProcess.getGroupsId());
         complete.setTeamId(teamId);
         complete.setFactoryId(taskProcess.getFactoryId());
         completes.add(complete);
      }

      this.completeService.saveBatch(completes);
      List<MesBuildingComplete> needWrehouseCompletes = new ArrayList<>();
      List<MesBuildingComplete> neewUpdateAllSendList = new ArrayList<>();
      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType())) {
         List<Long> partIds = completes.stream().map(MesBuildingComplete::getProductId).distinct().collect(Collectors.toList());
         List<TechMachinePart> parts = this.machinePartService.listByIds(partIds);
         Map<Long, TechMachinePart> partMap = parts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));

         for (MesBuildingComplete complete : completes) {
            TechMachinePart machinePart = partMap.get(complete.getProductId());
            if (machinePart.getBoolAllPartSendDirectly()) {
            }

            if (machinePart.getBoolSendDirectly()) {
               needWrehouseCompletes.add(complete);
            }
         }
      }

      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<Long> assIds = completes.stream().map(MesBuildingComplete::getProductId).distinct().collect(Collectors.toList());
         List<TechAssemble> assembles = this.assembleService.listByIds(assIds);
         Map<Long, TechAssemble> assembleMap = assembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));

         for (MesBuildingComplete complete : completes) {
            TechAssemble assemble = assembleMap.get(complete.getProductId());
            if (assemble.getBoolAllPartSendDirectly()) {
               MesBuildingComplete copy = BeanUtil.copy(complete, MesBuildingComplete.class);
               neewUpdateAllSendList.add(copy);
            }

            if (assemble.getBoolSendDirectly()) {
               needWrehouseCompletes.add(complete);
            }
         }
      }

      if (CollectionUtils.isNotEmpty(neewUpdateAllSendList)) {
         this.updateAllSendWarehouseData(neewUpdateAllSendList, taskProcess.getTaskTypeEnum());
      }

      if (CollectionUtils.isNotEmpty(needWrehouseCompletes)) {
         this.addWrehouseByCompletes(needWrehouseCompletes, userIdNest);
      }
   }

   private void updateAllSendWarehouseData(List<MesBuildingComplete> neewUpdateAllSendList, Integer taskType) {
      List<NumberInfoDTO> needUpdataSendnumbers = new ArrayList<>();
      if (taskType.equals(TaskTypeEnum.MACHINE_PART.getType())) {
         Preconditions.checkArgument(false, "零件暂无生产业务");
      }

      if (taskType.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<Integer> allNumbers = neewUpdateAllSendList.stream().map(s -> s.getNumber()).collect(Collectors.toList());
         Long assId = neewUpdateAllSendList.get(0).getProductId();
         List<MesBuildingTaskNumberLink> numberLinks = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getAssembleId, assId)
                  .in(MesBuildingTaskNumberLink::getAssembleNumber, allNumbers)
            );
         List<NumberInfoDTO> numberInfoDTOS = new ArrayList<>();

         for (MesBuildingTaskNumberLink numberLink : numberLinks) {
            NumberInfoDTO build = NumberInfoDTO.builder().productId(numberLink.getArtifactId()).number(numberLink.getArtifactNumber()).build();
            numberInfoDTOS.add(build);
         }

         List<MesBuildingTaskNumberLink> allLinks = this.mesBuildingTaskNumberLinkService.listLinksBydata(numberInfoDTOS, TaskTypeEnum.ARTIFACT.getType());
         Map<String, List<MesBuildingTaskNumberLink>> allLinkMap = allLinks.stream()
            .collect(Collectors.groupingBy(s -> s.getArtifactId() + "_" + s.getArtifactNumber()));

         for (String key : allLinkMap.keySet()) {
            Long artId = Long.valueOf(key.split("_")[0]);
            Integer artNumber = Integer.valueOf(key.split("_")[1]);
            List<MesBuildingTaskNumberLink> links = allLinkMap.get(key);
            if (links.stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete)) {
               NumberInfoDTO build = NumberInfoDTO.builder().productId(artId).number(artNumber).build();
               needUpdataSendnumbers.add(build);
            }
         }
      }

      if (CollectionUtils.isNotEmpty(needUpdataSendnumbers)) {
         List<MesBuildingSinglePartArtifactPrint> sings = this.singlePartArtifactPrintService.listBydata(needUpdataSendnumbers);
         sings.forEach(s -> s.setQuantity(1));
         this.singlePartArtifactPrintService.updateBatchById(sings);
      }
   }

   void addWrehouseByCompletes(List<MesBuildingComplete> completes, Long userIdNest) {
      List<AddWarehouseDTO> addWarehouseDTOS = new ArrayList<>();

      for (MesBuildingComplete complete : completes) {
         AddWarehouseDTO build = AddWarehouseDTO.builder()
            .factoryId(complete.getFactoryId())
            .workshopId(complete.getWorkshopId())
            .productType(complete.getTaskTypeEnum())
            .productId(complete.getProductId())
            .type(WarehouseTypeEnum.INTO.getType())
            .build();
         addWarehouseDTOS.add(build);
      }

      List<MesBuildingWarehouseSummary> summaries = this.warehouseSummaryService.listWareHouseSummary(addWarehouseDTOS);
      List<MesBuildingWarehouseRecord> records = new ArrayList<>();
      User user = this.userService.getById(userIdNest == null ? UserUtil.getCurrentUserId() : userIdNest);

      for (MesBuildingComplete complete : completes) {
         MesBuildingWarehouseRecord record = BeanUtil.copy(complete, MesBuildingWarehouseRecord.class);
         record.setCompleteId(complete.getId());
         record.setQuantity(BigDecimal.valueOf(complete.getQuantity().intValue()));
         record.setUserId(null == userIdNest ? UserUtil.getCurrentUserId() : userIdNest);
         record.setUserName(user.getName());
         record.setNumber(complete.getNumber());
         record.setProductType(complete.getTaskTypeEnum());
         record.setStatus(WarehouseRecordStatusTypeEnum.INTO.getType());
         record.setType(WarehouseTypeEnum.INTO.getType());
         records.add(record);
      }

      this.warehouseRecordService.saveBatch(records);
      Map<String, Integer> completeMap = completes.stream()
         .collect(
            Collectors.toMap(
               s -> s.getFactoryId()
                  + "_"
                  + s.getWorkshopId()
                  + "_"
                  + s.getTaskTypeEnum()
                  + "_"
                  + s.getProductId()
                  + "_"
                  + WarehouseRecordStatusTypeEnum.INTO.getType(),
               MesBuildingComplete::getQuantity,
               Integer::sum
            )
         );
      Map<String, MesBuildingWarehouseSummary> summaryMap = CollectionUtils.isEmpty(summaries)
         ? new HashMap<>()
         : summaries.stream()
            .collect(
               Collectors.toMap(
                  s -> s.getFactoryId() + "_" + s.getWorkshopId() + "_" + s.getProductType() + "_" + s.getProductId() + "_" + s.getType(), Function.identity()
               )
            );
      Map<String, MesBuildingWarehouseSummary> saveSummaryMap = new HashMap<>();

      for (String key : completeMap.keySet()) {
         Integer quantity = completeMap.get(key);
         MesBuildingWarehouseSummary summary = summaryMap.get(key);
         if (summary == null) {
            MesBuildingWarehouseSummary updateSummary = saveSummaryMap.get(key);
            if (updateSummary == null) {
               MesBuildingWarehouseSummary saveSummary = BeanUtil.copy(completes.get(0), MesBuildingWarehouseSummary.class);
               saveSummary.setId(null);
               saveSummary.setQuantity(BigDecimal.valueOf(quantity.intValue()));
               saveSummary.setProductType(completes.get(0).getTaskTypeEnum());
               saveSummary.setType(WarehouseTypeEnum.INTO.getType());
               saveSummaryMap.put(key, saveSummary);
            } else {
               updateSummary.setQuantity(updateSummary.getQuantity().add(BigDecimal.valueOf(quantity.intValue())));
               saveSummaryMap.put(key, updateSummary);
            }
         } else {
            summary.setQuantity(summary.getQuantity().add(BigDecimal.valueOf(quantity.intValue())));
         }
      }

      this.warehouseSummaryService.saveBatch(new ArrayList<>(saveSummaryMap.values()));
      this.warehouseSummaryService.updateBatchById(new ArrayList<>(summaryMap.values()));
   }

   public void saveCompoleteReportFast(List<MachinePartCompoleteReporyDO> machinePartCompoleteReporyDOList, Long userIdNest) {
      List<MesBuildingComplete> completesAll = new ArrayList<>();

      for (MachinePartCompoleteReporyDO machinePartCompoleteReporyDO : machinePartCompoleteReporyDOList) {
         List<MesBuildingComplete> completes = new ArrayList<>();
         MesBuildingTaskProcess taskProcess = machinePartCompoleteReporyDO.getMesBuildingTaskProcess();
         Long teamId = machinePartCompoleteReporyDO.getTeamId();
         Integer reportQuantity = machinePartCompoleteReporyDO.getReportQuantity();
         MesBuildingComplete complete = BeanUtil.copy(taskProcess, MesBuildingComplete.class);
         if (null == userIdNest) {
            complete.setUserId(UserUtil.getCurrentUserId());
         }

         complete.setCreateTime(LocalDateTime.now());
         complete.setUpdateTime(null);
         complete.setBoolAbnormalEnum(false);
         complete.setQuantity(reportQuantity);
         complete.setGroupsId(taskProcess.getGroupsId());
         complete.setTeamId(teamId);
         complete.setFactoryId(taskProcess.getFactoryId());
         completes.add(complete);
         completesAll.add(complete);
         List<MesBuildingComplete> needWrehouseCompletes = new ArrayList<>();
         List<MesBuildingComplete> neewUpdateAllSendList = new ArrayList<>();
         if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType())) {
            List<Long> partIds = completes.stream().map(MesBuildingComplete::getProductId).distinct().collect(Collectors.toList());
            List<TechMachinePart> parts = this.machinePartService.listByIds(partIds);
            Map<Long, TechMachinePart> partMap = parts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));

            for (MesBuildingComplete mesBuildingComplete : completes) {
               TechMachinePart machinePart = partMap.get(mesBuildingComplete.getProductId());
               if (machinePart.getBoolAllPartSendDirectly()) {
               }

               if (machinePart.getBoolSendDirectly()) {
                  needWrehouseCompletes.add(mesBuildingComplete);
               }
            }
         }

         if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
            List<Long> assIds = completes.stream().map(MesBuildingComplete::getProductId).distinct().collect(Collectors.toList());
            List<TechAssemble> assembles = this.assembleService.listByIds(assIds);
            Map<Long, TechAssemble> assembleMap = assembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));

            for (MesBuildingComplete mesBuildingComplete : completes) {
               TechAssemble assemble = assembleMap.get(mesBuildingComplete.getProductId());
               if (assemble.getBoolAllPartSendDirectly()) {
                  MesBuildingComplete copy = BeanUtil.copy(mesBuildingComplete, MesBuildingComplete.class);
                  neewUpdateAllSendList.add(copy);
               }

               if (assemble.getBoolSendDirectly()) {
                  needWrehouseCompletes.add(mesBuildingComplete);
               }
            }
         }

         if (CollectionUtils.isNotEmpty(neewUpdateAllSendList)) {
            this.updateAllSendWarehouseData(neewUpdateAllSendList, taskProcess.getTaskTypeEnum());
         }

         if (CollectionUtils.isNotEmpty(needWrehouseCompletes)) {
            this.addWrehouseByCompletes(needWrehouseCompletes, userIdNest);
         }
      }

      this.completeService.saveBatch(completesAll);
   }
}
