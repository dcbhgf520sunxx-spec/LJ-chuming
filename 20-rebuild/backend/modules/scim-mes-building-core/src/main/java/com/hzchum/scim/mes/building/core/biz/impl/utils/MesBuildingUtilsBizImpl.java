package com.hzchum.scim.mes.building.core.biz.impl.utils;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.CodingTypeEnum;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractTechService;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsInspectionTeamLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.biz.wages.MesBuildingProduceTeamReportPriceBiz;
import com.hzchum.scim.mes.building.core.api.enums.MesBuildingInspectionAndTeamEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.TaskStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.YearMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingSchedulingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroupsInspectionTeamLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.MesBuildingSchedulingDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.DateMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskProcessLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.ProjectPainingPriceDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingInspectionTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingInspectionTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.biz.MesBuildingProductionLineTeamLinkBiz;
import com.hzchum.scim.system.core.api.biz.ProductClassificationConfigBiz;
import com.hzchum.scim.system.core.api.common.enums.ProductionLineTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfig;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfig;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassification;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.service.MesInspectConfigService;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingUtilsBizImpl implements MesBuildingUtilsBiz {
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private ContractTechService contractTechService;
   @Autowired
   private MesBuildingTeamService teamService;
   @Autowired
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Autowired
   private MesBuildingInspectionTeamService inspectionTeamService;
   @Autowired
   private MesBuildingInspectionTeamUserLinkService inspectionTeamUserLinkService;
   @Autowired
   private MesBuildingFactoryService mesBuildingFactoryService;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesBuildingProductProcessService productProcessService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private TechEnclosureService enclosureService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private MesBuildingSchedulingService schedulingService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingProductProcessLinkService productProcessLinkService;
   @Autowired
   private ProductClassificationConfigBiz productClassificationConfigBiz;
   @Resource
   private MesBuildingGroupsInspectionTeamLinkBiz groupsInspectionTeamLinkBiz;
   @Resource
   private MesBuildingProductionLineTeamLinkBiz lineTeamLinkBiz;
   @Resource
   private MesBuildingProduceTeamReportService teamReportService;
   @Resource
   private MesBuildingProduceTeamReportPriceBiz teamReportPriceBiz;
   @Resource
   private SysStructureClassificationService structureClassificationService;
   @Resource
   private SysAssembleConfigService assembleConfigService;
   @Autowired
   private SysSteelClassificationService steelClassificationService;
   @Autowired
   private MesInspectConfigService inspectConfigService;

   @Override
   public Boolean checkFactoryAndWorkshopAndProductionLineAndProcessIsExist(
      Long factoryId, Long workshopId, Long productionLineId, Long processId, Integer productionLineTypeEnum, Integer teamEnum
   ) {
      if (factoryId != null) {
         MesBuildingFactory mesBuildingFactory = this.mesBuildingFactoryService.getById(factoryId);
         Preconditions.checkArgument(mesBuildingFactory != null, "添加失败，传入工厂id有误");
         Preconditions.checkArgument(mesBuildingFactory.getBoolEnabledEnum(), "添加失败，工厂被禁用");
      }

      if (workshopId != null) {
         MesBuildingWorkshop mesBuildingWorkshop = this.workshopService.getById(workshopId);
         Preconditions.checkArgument(mesBuildingWorkshop != null, "添加失败，传入车间id有误");
         Preconditions.checkArgument(mesBuildingWorkshop.getBoolEnabledEnum(), "添加失败，车间被禁用");
      }

      if (productionLineId != null) {
         MesBuildingProductionLine mesBuildingProductionLine = this.productionLineService.getById(productionLineId);
         if (processId != null) {
            MesBuildingProcess mesBuildingProcess = this.processService.getById(processId);
            Preconditions.checkArgument(mesBuildingProcess.getProductType().equals(mesBuildingProductionLine.getProductType()), "添加失败，传入工序类型和产线类型不匹配");
            Preconditions.checkArgument(mesBuildingProcess != null, "添加失败，传入工序id有误");
            if (MesBuildingInspectionAndTeamEnum.Inspection.getType().equals(teamEnum)) {
               Preconditions.checkArgument(
                  ProductTypeEnum.ASSEMBLE.getType().equals(mesBuildingProcess.getProductType())
                     || ProductTypeEnum.ARTIFACT.getType().equals(mesBuildingProcess.getProductType()),
                  "只有组立和构件能设置质检班组"
               );
            }

            if (productionLineTypeEnum != null
               && (
                  ProductTypeEnum.ASSEMBLE.getType().equals(mesBuildingProcess.getProductType())
                     || ProductTypeEnum.MACHINE_PART.getType().equals(mesBuildingProcess.getProductType())
               )) {
               Preconditions.checkArgument(ProductionLineTypeEnum.TRADITIONAL_LINE.getType().equals(productionLineTypeEnum), "组立和零件工无法设置为智能线");
            }
         }

         Preconditions.checkArgument(mesBuildingProductionLine != null, "添加失败，传入生产线id有误");
         Preconditions.checkArgument(mesBuildingProductionLine.getBoolEnabledEnum(), "添加失败，生产线被禁用");
      }

      return true;
   }

   @Override
   public Boolean checkBatchClassIdOrProcessIdsOrTeamIds(List<Long> classIds, Integer productType, List<Long> processIds, List<Long> teamIds, Long lineId) {
      if (classIds != null) {
         if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
            List<SysSteelClassification> one = this.steelClassificationService
               .list(Wrappers.lambdaQuery(SysSteelClassification.class).in(SysSteelClassification::getId, classIds));
            Preconditions.checkArgument(one != null, "数据失效，请刷新页面重试");
         } else if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
            List<SysStructureClassification> one = this.structureClassificationService
               .list(Wrappers.lambdaQuery(SysStructureClassification.class).in(SysStructureClassification::getId, classIds));
            Preconditions.checkArgument(one != null, "数据失效，请刷新页面重试");
         } else if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
            List<SysAssembleConfig> one = this.assembleConfigService.list(Wrappers.lambdaQuery(SysAssembleConfig.class).in(SysAssembleConfig::getId, classIds));
            Preconditions.checkArgument(one != null, "数据失效，请刷新页面重试");
         }
      }

      if (teamIds != null) {
         List<MesBuildingTeam> teams = this.teamService.listByIds(teamIds);
         Preconditions.checkArgument(teams.size() == teamIds.size(), "数据失效，请刷新页面重试");
         Preconditions.checkArgument(teams.stream().allMatch(team -> team.getTeamStatus().equals(Boolean.TRUE)), "数据失效，请刷新页面重试");
         if (lineId != null) {
            Preconditions.checkArgument(teams.stream().allMatch(team -> team.getProductionLineId().equals(lineId)), "数据失效，请刷新页面重试");
         }
      }

      if (processIds != null) {
         Preconditions.checkArgument(this.processService.listByIds(processIds).size() == processIds.size(), "数据失效，请刷新页面重试");
      }

      return true;
   }

   @Override
   public Boolean checkSchedulingQuantity(Long productId, Integer productType, Integer schedulingQuantity) {
      if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         TechAssemble assemble = this.assembleService.getById(productId);
         Preconditions.checkArgument(assemble != null, "操作失败，传入产品id不正确");
         Preconditions.checkArgument(!assemble.getBoolAbnormalEnum(), "操作失败，部分产品进入异常状态，无法进行排产");
         MesBuildingSchedulingSummaryDO summaryDO = BeanUtil.copy(
            this.schedulingService.selectSummary(MesBuildingSchedulingDOParam.builder().productId(productId).productType(productType).build()),
            MesBuildingSchedulingSummaryDO.class
         );
         if (summaryDO.getTotalSchedulingQuantity() == null) {
            summaryDO.setTotalSchedulingQuantity(0);
         }

         int unSchedulingQuantity = assemble.getQuantity() - summaryDO.getTotalSchedulingQuantity();
         return unSchedulingQuantity >= schedulingQuantity;
      } else if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         TechArtifact artifact = this.artifactService.getById(productId);
         Preconditions.checkArgument(artifact != null, "操作失败，传入产品id不正确");
         Preconditions.checkArgument(!artifact.getBoolAbnormalEnum(), "操作失败，部分产品进入异常状态，无法进行排产");
         MesBuildingSchedulingSummaryDO summaryDO = BeanUtil.copy(
            this.schedulingService.selectSummary(MesBuildingSchedulingDOParam.builder().productId(productId).productType(productType).build()),
            MesBuildingSchedulingSummaryDO.class
         );
         if (summaryDO.getTotalSchedulingQuantity() == null) {
            summaryDO.setTotalSchedulingQuantity(0);
         }

         int unSchedulingQuantity = artifact.getQuantity() - summaryDO.getTotalSchedulingQuantity();
         return unSchedulingQuantity >= schedulingQuantity;
      } else if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         TechMachinePart machinePart = this.machinePartService.getById(productId);
         Preconditions.checkArgument(machinePart != null, "操作失败，传入产品id不正确");
         Preconditions.checkArgument(!machinePart.getBoolAbnormalEnum(), "操作失败，部分产品进入异常状态，无法进行排产");
         MesBuildingSchedulingSummaryDO summaryDO = BeanUtil.copy(
            this.schedulingService.selectSummary(MesBuildingSchedulingDOParam.builder().productId(productId).productType(productType).build()),
            MesBuildingSchedulingSummaryDO.class
         );
         if (summaryDO.getTotalSchedulingQuantity() == null) {
            summaryDO.setTotalSchedulingQuantity(0);
         }

         int unSchedulingQuantity = machinePart.getQuantity() - summaryDO.getTotalSchedulingQuantity();
         return unSchedulingQuantity >= schedulingQuantity;
      } else if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
         TechEnclosure enclosure = this.enclosureService.getById(productId);
         Preconditions.checkArgument(enclosure != null, "操作失败，传入产品id不正确");
         Preconditions.checkArgument(!enclosure.getBoolAbnormalEnum(), "操作失败，部分产品进入异常状态，无法进行排产");
         MesBuildingSchedulingSummaryDO summaryDO = BeanUtil.copy(
            this.schedulingService.selectSummary(MesBuildingSchedulingDOParam.builder().productId(productId).productType(productType).build()),
            MesBuildingSchedulingSummaryDO.class
         );
         if (summaryDO.getTotalSchedulingQuantity() == null) {
            summaryDO.setTotalSchedulingQuantity(0);
         }

         int unSchedulingQuantity = enclosure.getQuantity() - summaryDO.getTotalSchedulingQuantity();
         return unSchedulingQuantity >= schedulingQuantity;
      } else {
         return false;
      }
   }

   @Override
   public Boolean checkSchedulingQuantity(Long id, Integer schedulingQuantity) {
      MesBuildingScheduling scheduling = this.schedulingService.getById(id);
      Preconditions.checkArgument(scheduling != null, "操作失败，传入id不正确");
      return scheduling.getTaskQuantity() <= schedulingQuantity && scheduling.getSchedulingQuantity() >= schedulingQuantity;
   }

   @Override
   public Long selectProductProcessIdByProductIdAndType(Long productId, Integer productType) {
      MesBuildingProductProcess productProcess;
      if (!productType.equals(ProductTypeEnum.ARTIFACT.getType())
         && !productType.equals(ProductTypeEnum.ASSEMBLE.getType())
         && !productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         if (!productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
            throw new IllegalArgumentException("产品类型不正确");
         }

         productProcess = this.productProcessService
            .getOne(
               (Wrapper<MesBuildingProductProcess>)Wrappers.<MesBuildingProductProcess>lambdaQuery().eq(MesBuildingProductProcess::getProductType, ProductTypeEnum.ENCLOSURE.getType())
            );
      } else {
         Long id = this.productClassificationConfigBiz.getProductConfigId(productId, productType);
         Preconditions.checkArgument(id != null, "未配置定义");
         productProcess = this.productProcessService
            .getOne(
               (Wrapper<MesBuildingProductProcess>)((Wrappers.<MesBuildingProductProcess>lambdaQuery()
                        .eq(MesBuildingProductProcess::getProductType, productType))
                     .eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE))
                  .eq(MesBuildingProductProcess::getTypeId, this.productClassificationConfigBiz.getProductConfigId(productId, productType))
            );
      }

      return productProcess == null ? null : productProcess.getId();
   }

   @Override
   public Long getProductProcessIdByClassificationIdAndType(Long classificationId, Integer productType, Long productLineId) {
      MesBuildingProductProcess productProcess = this.productProcessService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingProductProcess.class)
               .eq(MesBuildingProductProcess::getProductType, productType)
               .eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE)
               .eq(MesBuildingProductProcess::getTypeId, classificationId)
               .eq(MesBuildingProductProcess::getProductionLineId, productLineId)
         );
      return productProcess == null ? null : productProcess.getId();
   }

   @Override
   public List<MesBuildingTeam> selectTeamIdByUserId(Long userid) {
      Preconditions.checkArgument(userid != null, "操作失败，传入id不正确");
      List<MesBuildingTeamUserLink> teamUserLinks = this.teamUserLinkService
         .list((Wrapper<MesBuildingTeamUserLink>)Wrappers.<MesBuildingTeamUserLink>lambdaQuery().eq(MesBuildingTeamUserLink::getUserId, userid));
      return teamUserLinks.size() == 0
         ? Collections.emptyList()
         : this.teamService.listByIds(teamUserLinks.stream().map(MesBuildingTeamUserLink::getTeamId).collect(Collectors.toList()));
   }

   @Override
   public List<MesBuildingInspectionTeam> selectInspectionTeamIdByUserId(Long userid) {
      Preconditions.checkArgument(userid != null, "操作失败，传入id不正确");
      List<MesBuildingInspectionTeamUserLink> inspectionTeamUserLinks = this.inspectionTeamUserLinkService
         .list((Wrapper<MesBuildingInspectionTeamUserLink>)Wrappers.<MesBuildingInspectionTeamUserLink>lambdaQuery().eq(MesBuildingInspectionTeamUserLink::getUserId, userid));
      if (inspectionTeamUserLinks.size() == 0) {
         return null;
      }

      List<Long> inspectionTeamIds = new ArrayList<>();
      inspectionTeamUserLinks.forEach(e -> inspectionTeamIds.add(e.getInspectionTeamId()));
      return this.inspectionTeamService.listByIds(inspectionTeamIds);
   }

   @Override
   public MesBuildingScheduling checkSchedulingStatus(Long id) {
      MesBuildingScheduling mesBuildingScheduling = this.schedulingService.getById(id);
      Preconditions.checkArgument(mesBuildingScheduling != null, "操作失败，未查询到相关排产信息");
      Preconditions.checkArgument(mesBuildingScheduling.getStatus().equals(true), "操作失败，排产已暂停");
      return mesBuildingScheduling;
   }

   @Override
   public MesBuildingTask checkTaskStatus(Long id) {
      MesBuildingTask mesBuildingTask = this.taskService.getById(id);
      Preconditions.checkArgument(mesBuildingTask != null, "操作失败，未查询到相关排产信息");
      Preconditions.checkArgument(mesBuildingTask.getStatus().equals(TaskStatusTypeEnum.START.getType()), "操作失败，任务已经暂停");
      return mesBuildingTask;
   }

   @Override
   public MesBuildingTask checkTaskAbnormalStatus(Long id) {
      MesBuildingTask mesBuildingTask = this.taskService.getById(id);
      Preconditions.checkArgument(mesBuildingTask != null, "操作失败，未查询到相关排产信息");
      Preconditions.checkArgument(mesBuildingTask.getStatus().equals(TaskStatusTypeEnum.ABNORMAL.getType()), "操作失败，任务正常或已停止上报");
      return mesBuildingTask;
   }

   @Override
   public Boolean checkInspectionTeam(Long groupsId, Long processId) {
      List<MesBuildingInspectionTeam> teamList = this.inspectionTeamService
         .list(Wrappers.<MesBuildingInspectionTeam>lambdaQuery().eq(processId != null, MesBuildingInspectionTeam::getProcessId, processId));
      if (teamList.size() == 0) {
         return Boolean.FALSE;
      }

      List<MesBuildingGroupsInspectionTeamLink> groupsInspectionTeamLinkList = this.groupsInspectionTeamLinkBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingGroupsInspectionTeamLink.class)
               .eq(MesBuildingGroupsInspectionTeamLink::getGroupsId, groupsId)
               .in(
                  MesBuildingGroupsInspectionTeamLink::getInspectionTeamId,
                  teamList.stream().map(MesBuildingInspectionTeam::getId).collect(Collectors.toList())
               )
         );
      return groupsInspectionTeamLinkList.size() == 0 ? Boolean.FALSE : Boolean.TRUE;
   }

   @Override
   public Boolean checkProductLineTeam2(Long productProcessId, Long lineId, Long teamId, Long processId) {
      MesBuildingProductionLine line = this.productionLineService.getById(lineId);
      MesBuildingProductProcess productProcess = this.productProcessService.getById(productProcessId);
      List<MesInspectConfig> inspectConfigList = this.inspectConfigService
         .queryInspectConfig(line.getWorkshopId(), processId, productProcess.getTypeId(), teamId);
      return CollectionUtils.isEmpty(inspectConfigList) ? Boolean.FALSE : Boolean.TRUE;
   }

   @Override
   public List<MesBuildingTeam> getTeamByProductionLineIdAndProcessIdAndUserId(Long productionLineId, Long processId, Long userId, List<Long> ids) {
      return this.teamService.getTeamByProductionLineIdAndProcessIdAndUserId(productionLineId, processId, userId, ids);
   }

   @Override
   public MesBuildingInspectionTeam getInspectionTeamBygroupsIdAndProcessIdAndUserId(Long groupsId, Long processId, Long userId) {
      return BeanUtil.copy(
         this.inspectionTeamService.getInspectionTeamBygroupsIdAndProcessIdAndUserId(groupsId, processId, userId), MesBuildingInspectionTeam.class
      );
   }

   @Override
   public MesBuildingInspectionTeam getInspectionTeamByLineIdAndProcessIdAndUserId(Long lineId, Long processId, Long userId, Boolean teamType) {
      return BeanUtil.copy(
         this.inspectionTeamService.getInspectionTeamByLineIdAndProcessIdAndUserId(lineId, processId, userId, teamType), MesBuildingInspectionTeam.class
      );
   }

   @Override
   public String longListToString(List<Long> list) {
      Preconditions.checkArgument(list.size() != 0, "传入list不能为空");
      return list.toString().replace(" ", "").replace("[", "").replace("]", "");
   }

   @Override
   public Boolean checkMachinePartProcess() {
      return this.processService.list((Wrapper<MesBuildingProcess>)Wrappers.<MesBuildingProcess>lambdaQuery().eq(MesBuildingProcess::getProductType, 1)).size() == 0;
   }

   @Override
   public Boolean checkQuantity(Integer productType, Long productId, Integer quantity) {
      Preconditions.checkArgument(ProductTypeEnum.isExist(productType), "产品类型不匹配");
      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         return quantity <= this.artifactService.getById(productId).getQuantity();
      } else if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         return quantity <= this.machinePartService.getById(productId).getQuantity();
      } else {
         return productType.equals(ProductTypeEnum.ASSEMBLE.getType())
            ? quantity <= this.assembleService.getById(productId).getQuantity()
            : quantity <= this.assembleService.getById(productId).getQuantity();
      }
   }

   @Override
   public List<MesBuildingProcess> getProcessByProduct(Long id, Integer productType, Boolean asc) {
      List<MesBuildingProcess> processList = new ArrayList<>();
      Long productProcessId = this.selectProductProcessIdByProductIdAndType(id, productType);
      Preconditions.checkArgument(productProcessId != null, "操作失败 没有对应的工序");
      this.productProcessLinkService
         .list(
            (Wrapper<MesBuildingProductProcessLink>)((Wrappers.<MesBuildingProductProcessLink>lambdaQuery()
                     .eq(MesBuildingProductProcessLink::getProductProcessId, productProcessId))
                  .orderByAsc(asc, MesBuildingProductProcessLink::getSequence))
               .orderByDesc(!asc, MesBuildingProductProcessLink::getSequence)
         )
         .forEach(e -> processList.add(this.processService.getById(e.getProcessId())));
      return processList;
   }

   @Override
   public List<MesBuildingProcess> getProcessIdByClassificationId(Long id, Integer productType) {
      Long productProcessId = this.getProductProcessIdByClassificationIdAndType(id, productType, null);
      Preconditions.checkArgument(productProcessId != null, "操作失败 没有对应的工序");
      Map<Long, MesBuildingProcess> processMap = new HashMap<>();
      List<MesBuildingProductProcessLink> processLinks = this.productProcessLinkService
         .list(
            (Wrapper<MesBuildingProductProcessLink>)(Wrappers.<MesBuildingProductProcessLink>lambdaQuery()
                  .eq(MesBuildingProductProcessLink::getProductProcessId, productProcessId))
               .orderByAsc(MesBuildingProductProcessLink::getSequence)
         );
      this.processService.listByIds(processLinks.stream().map(MesBuildingProductProcessLink::getProcessId).collect(Collectors.toList())).forEach(e -> {
         MesBuildingProcess var10000 = processMap.put(e.getId(), e);
      });
      List<MesBuildingProcess> processList = new ArrayList<>();
      processLinks.forEach(e -> processList.add(processMap.get(e.getProcessId())));
      return processList;
   }

   @Override
   public List<MesBuildingProcess> getProcessIdByProductProcessId(Long productProcessId) {
      Preconditions.checkArgument(productProcessId != null, "操作失败:工序id不正确，或没有配置对应工序！");
      Map<Long, MesBuildingProcess> processMap = new HashMap<>();
      List<MesBuildingProductProcessLink> processLinks = this.productProcessLinkService
         .list(
            (Wrapper<MesBuildingProductProcessLink>)(Wrappers.<MesBuildingProductProcessLink>lambdaQuery()
                  .eq(MesBuildingProductProcessLink::getProductProcessId, productProcessId))
               .orderByAsc(MesBuildingProductProcessLink::getSequence)
         );
      this.processService.listByIds(processLinks.stream().map(MesBuildingProductProcessLink::getProcessId).collect(Collectors.toList())).forEach(e -> {
         MesBuildingProcess var10000 = processMap.put(e.getId(), e);
      });
      List<MesBuildingProcess> processList = new ArrayList<>();
      processLinks.forEach(e -> processList.add(processMap.get(e.getProcessId())));
      return processList;
   }

   @Override
   public List<MesBuildingProcess> getProcessListByConfigIdAndTaskTypeEnum(Long configId, Integer taskTypeEnum) {
      return null;
   }

   @Override
   public Map<Long, LocalDateTime> getTaskProcessTime(Long productProcessId, LocalDateTime askCompleteDateTime) {
      List<MesBuildingProductProcessLink> links = this.productProcessLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingProductProcessLink.class)
               .eq(MesBuildingProductProcessLink::getProductProcessId, productProcessId)
               .orderByDesc(MesBuildingProductProcessLink::getSequence)
         );
      Map<Long, LocalDateTime> map = new HashMap<>();
      AtomicReference<Integer> cun = new AtomicReference<>(0);
      links.forEach(link -> {
         cun.set(cun.get() + link.getNodeTime());
         LocalDateTime localDateTime = askCompleteDateTime == null ? LocalDateTime.now() : askCompleteDateTime;
         if (localDateTime.plusDays(-cun.get()).isAfter(LocalDateTime.now())) {
            map.put(link.getProcessId(), localDateTime.plusDays(-cun.get()));
         } else {
            map.put(link.getProcessId(), LocalDateTime.now().plusDays(1L).withHour(0).withMinute(0).withSecond(0));
         }
      });
      return map;
   }

   @Override
   public Boolean getBoolDrillProcess(Long id) {
      Long productProcessId = this.productProcessService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingProductProcess.class)
               .eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE)
               .eq(MesBuildingProductProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
               .eq(MesBuildingProductProcess::getTypeId, id)
         )
         .getId();
      Preconditions.checkArgument(productProcessId != null, "操作失败 没有对应的工序");
      List<MesBuildingProcess> processList = this.processService
         .listByIds(
            this.productProcessLinkService
               .list((Wrapper<MesBuildingProductProcessLink>)Wrappers.<MesBuildingProductProcessLink>lambdaQuery().eq(MesBuildingProductProcessLink::getProductProcessId, productProcessId))
               .stream()
               .map(MesBuildingProductProcessLink::getProductProcessId)
               .collect(Collectors.toList())
         );
      return processList.stream().anyMatch(e -> e.getType().equals(ProcessTypeEnum.DRILL_HOLE.getType()));
   }

   @Override
   public List<Long> getProjectIds() {
      return this.projectService.listSimpleProject(null, null, null, null).getContent().stream().map(ProjectSimpleInfoDTO::getId).collect(Collectors.toList());
   }

   @Override
   public Boolean checkProductAbnormalstatus(Integer productType, Long productId) {
      Preconditions.checkArgument(ProductTypeEnum.isExist(productType), "操作失败:产品类型不正确！");
      boolean flg = Boolean.TRUE;
      if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         flg = this.machinePartService.getById(productId).getBoolAbnormalEnum().equals(false);
      } else if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         flg = this.assembleService.getById(productId).getBoolAbnormalEnum().equals(false);
      } else if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
         flg = this.enclosureService.getById(productId).getBoolAbnormalEnum().equals(false);
      } else if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         TechArtifact artifact = this.artifactService.getById(productId);
         flg = artifact.getBoolAbnormalEnum().equals(false) && artifact.getBoolStatusEnum().equals(true);
      }

      Preconditions.checkArgument(flg, "操作失败，产品处于异常状态或已暂停");
      return Boolean.TRUE;
   }

   @Override
   public Map<Integer, Integer> listEnclosureMeasureMode(Long id) {
      Map<Integer, Integer> map = new HashMap<>();
      this.contractTechService.listEnclosureMeasureMode(id).forEach(e -> {
         Integer var10000 = map.put(e.get("type"), e.get("measureMode"));
      });
      return map;
   }

   @Override
   public Boolean checkProductStatus(Integer productType, Long productId) {
      Preconditions.checkArgument(ProductTypeEnum.isExist(productType), "操作失败:产品类型不正确！");
      boolean flg = Boolean.TRUE;
      if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         flg = this.machinePartService.getById(productId).getBoolStatusEnum().equals(true);
      } else if (!productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
            flg = this.enclosureService.getById(productId).getBoolStatusEnum().equals(true);
         } else if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
            flg = this.artifactService.getById(productId).getBoolStatusEnum().equals(true);
         }
      }

      Preconditions.checkArgument(flg, "操作失败，产品处于暂停状态");
      return Boolean.TRUE;
   }

   @Override
   public Boolean getBoolOneCode(Long artifactId) {
      TechArtifact artifact = this.artifactService.getById(artifactId);
      Preconditions.checkArgument(artifact != null, "构件不存在");
      return artifact.getArtifactType().equals(1) ? Boolean.TRUE : CodingTypeEnum.SINGLE.getType().equals(artifact.getCodingType());
   }

   @Override
   public Boolean getAssBoolOneCode(Long assembleId, Long taskId) {
      TechAssemble ass = this.assembleService.getById(assembleId);
      MesBuildingTask task = this.taskService.getById(taskId);
      Preconditions.checkArgument(ass != null, "构件不存在");
      return CodingTypeEnum.SINGLE.getType().equals(task.getBoolOneCode());
   }

   @Override
   public Map<Long, Boolean> getBoolBatchCode(List<Long> artifactIds) {
      List<TechArtifact> techArtifacts = this.artifactService.listByIds(artifactIds);
      Preconditions.checkArgument(techArtifacts.size() == artifactIds.size(), "构件产品不存在!!!");
      return techArtifacts.stream().collect(Collectors.toMap(TechArtifact::getId, e -> e.getCodingType().equals(CodingTypeEnum.SINGLE.getType())));
   }

   @Override
   public Map<String, BigDecimal> getMeteByYear(LocalDateTime dateTime, Integer processTypeEnum) {
      return this.teamReportService
         .getMeteByYear(dateTime, processTypeEnum, null)
         .stream()
         .collect(Collectors.toMap(YearMeteDO::getMonth, YearMeteDO::getMete));
   }

   @Override
   public Map<String, BigDecimal> getMeteByYearV2(LocalDateTime dateTime, Integer processTypeEnum, Long branchCompanyId, Long workshopId) {
      return this.teamReportService
         .getMeteByYearV2(dateTime, processTypeEnum, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(DateMeteDTO::getDateTime, DateMeteDTO::getMete));
   }

   @Override
   public Map<String, BigDecimal> getMeteByYear(LocalDateTime dateTime, Integer processTypeEnum, Long projectId) {
      return this.teamReportService
         .getMeteByYear(dateTime, processTypeEnum, projectId)
         .stream()
         .collect(Collectors.toMap(YearMeteDO::getMonth, YearMeteDO::getMete));
   }

   @Override
   public List<ProjectPainingPriceDTO> getProjectPaintingPrice(LocalDateTime dateTime) {
      return this.teamReportPriceBiz
         .getProjectPaintingPrice(dateTime)
         .stream()
         .map(e -> BeanUtil.copy(e, ProjectPainingPriceDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public Boolean getBoolSinglePartArtifactPaintV2(
      TechArtifact artifact,
      Map<String, MesBuildingProductProcess> productProcessMap,
      Map<Long, List<MesBuildingProductProcessLink>> productProcessLinkMap,
      List<MesBuildingProcess> processes,
      Long productionLineId
   ) {
      List<MesBuildingProcess> processList = new ArrayList<>();
      if (artifact.getBoolCoatingEnum()) {
         MesBuildingProductProcess mesBuildingProductProcess = productProcessMap.get(productionLineId + "-" + artifact.getStructureClassId());
         Long productProcessId = mesBuildingProductProcess == null ? null : mesBuildingProductProcess.getId();
         if (productProcessId != null) {
            List<MesBuildingProductProcessLink> mesBuildingProductProcessLinks = productProcessLinkMap.get(productProcessId);
            Map<Long, MesBuildingProductProcessLink> processLinkMap = mesBuildingProductProcessLinks.stream()
               .collect(Collectors.toMap(MesBuildingProductProcessLink::getProcessId, Function.identity()));
            processList = processes.stream().filter(e -> processLinkMap.containsKey(e.getId())).collect(Collectors.toList());
            processList = processList.stream().filter(e -> e.getType().equals(ProcessTypeEnum.PAINT.getType())).collect(Collectors.toList());
         }
      }

      return processList.size() > 0;
   }

   @Override
   public Boolean getBoolSinglePartArtifactPaint(TechArtifact artifact, Long productLineId) {
      List<MesBuildingProcess> processList = new ArrayList<>();
      if (artifact.getBoolCoatingEnum()) {
         Long productProcessId = this.getProductProcessIdByClassificationIdAndType(
            artifact.getStructureClassId(), ProductTypeEnum.ARTIFACT.getType(), productLineId
         );
         if (productProcessId != null) {
            processList = this.getProcessIdByProductProcessId(productProcessId);
            processList = processList.stream().filter(e -> e.getType().equals(ProcessTypeEnum.PAINT.getType())).collect(Collectors.toList());
         }
      }

      return processList.size() > 0;
   }

   @Override
   public Map<Long, List<MesBuildingTaskProcessLinkDTO>> getProductLinkProcesses(List<Long> proudProcessIds) {
      Map<Long, List<MesBuildingTaskProcessLinkDTO>> dto = new HashMap<>();
      List<MesBuildingProductProcessLink> allProcessLinks = this.productProcessLinkService
         .list(
            (Wrapper<MesBuildingProductProcessLink>)(Wrappers.<MesBuildingProductProcessLink>lambdaQuery()
                  .in(MesBuildingProductProcessLink::getProductProcessId, proudProcessIds))
               .orderByAsc(MesBuildingProductProcessLink::getSequence)
         );
      Map<Long, List<MesBuildingProductProcessLink>> linkMap = allProcessLinks.stream()
         .collect(Collectors.groupingBy(MesBuildingProductProcessLink::getProductProcessId));
      List<Long> allProcessIds = allProcessLinks.stream().map(MesBuildingProductProcessLink::getProcessId).distinct().collect(Collectors.toList());
      Map<Long, MesBuildingProcess> processMap = this.processService
         .listByIds(allProcessIds)
         .stream()
         .collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));

      for (Long proudProcessId : proudProcessIds) {
         List<MesBuildingProductProcessLink> links = linkMap.get(proudProcessId);
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(links), "操作失败!!!构件工序丢失请联系管理员!!!!");
         links = links.stream().sorted(Comparator.comparing(MesBuildingProductProcessLink::getSequence)).collect(Collectors.toList());
         List<MesBuildingTaskProcessLinkDTO> linkDetails = new ArrayList<>();

         for (MesBuildingProductProcessLink link : links) {
            MesBuildingProcess process = processMap.get(link.getProcessId());
            MesBuildingTaskProcessLinkDTO build = MesBuildingTaskProcessLinkDTO.builder()
               .productProcessId(proudProcessId)
               .processId(link.getProcessId())
               .sequence(link.getSequence())
               .type(process.getType())
               .productType(process.getProductType())
               .nodeTime(link.getNodeTime())
               .boolParallelProcess(link.getBoolParallelProcess())
               .teamId(link.getTeamId())
               .build();
            linkDetails.add(build);
         }

         dto.put(proudProcessId, linkDetails);
      }

      return dto;
   }
}
