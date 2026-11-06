package com.hzchum.scim.mes.building.core.biz.impl.task;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.enums.CodingTypeEnum;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingCutConfigBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNestCutPlatePartBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingAssistBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingNewTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingProduceTeamReportBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingProjectProductionSummaryBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskProcessBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.SaveProduceTeamReportSummaryTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.manager.MesBuildingCalcMaxNumManager;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingNextProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssistNumberDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingInProduction;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReportSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingSinglePartArtifactPrint;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingProduceTeamReportPrice;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.ProductProductionSummaryDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.scheduling.MesBuildingArtifactSchedulingParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.SchedulingArtifactDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.SchedulingArtifactSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange.MesBuildingReportSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.AssNumberArtNumberLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.InspectionReportSavedDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.LastProcessInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.PaintThicknessSaveDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ReportRecordV2DTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.TeamAndNumberDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.TeamScheduledInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.TeamScheduledSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.AddWarehouseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskProcessDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.ProductClassificationDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.BatchInspectDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.BatchPrintDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.BatchReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingProduceTeamReportDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingNextProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.api.service.record.MesBuildingProductProductionSummaryService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistNumberDetailService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingInProductionService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportSummaryService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingSinglePartArtifactPrintService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.wages.MesBuildingProduceTeamReportPriceService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReportPaintThicknessLink;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.service.task.MesBuildingProduceInspectionTeamReportPaintThicknessLinkService;
import com.hzchum.scim.system.core.api.common.enums.ProjectModeEnum;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfig;
import com.hzchum.scim.system.core.api.pojo._do.PaintThicknessDO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.MesInspectConfigService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingNewTaskBizImpl extends IBizImpl<MesBuildingTaskService, MesBuildingTaskMapper, MesBuildingTask> implements MesBuildingNewTaskBiz {
   @Autowired
   private MesBuildingCalcMaxNumManager mesBuildingCalcMaxNumManager;
   @Autowired
   private MesBuildingTaskBiz taskBiz;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesBuildingAssistBiz assistBiz;
   @Autowired
   private MesBuildingAssistBiz mesBuildingAssistBiz;
   @Autowired
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Autowired
   private MesBuildingTeamService teamService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingProductProductionSummaryService productionSummaryService;
   @Autowired
   private MesBuildingTaskNumberLinkService mesBuildingTaskNumberLinkService;
   @Autowired
   private MesBuildingAssistNumberDetailService assistNumberDetailService;
   @Autowired
   private MesBuildingProduceTeamReportSummaryService produceTeamReportSummaryService;
   @Autowired
   private TechAssembleDetailService assembleDetailService;
   @Autowired
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Autowired
   private MesBuildingMachinePartSchedulingService machinePartSchedulingService;
   @Autowired
   private MesBuildingCutConfigBiz cutConfigBiz;
   @Autowired
   private MesBuildingTaskOrderBiz taskOrderBiz;
   @Autowired
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Autowired
   private RedisUtils redisUtils;
   @Autowired
   private MesBuildingProduceInspectionTeamReportService produceInspectionTeamReportService;
   @Autowired
   private MesBuildingProduceTeamReportBiz teamReportBiz;
   @Autowired
   private MesBuildingNestCutPlatePartBiz nestCutPlatePartBiz;
   @Autowired
   private MesBuildingNextProcessLinkService nextProcessLinkService;
   @Autowired
   private MesBuildingProductProcessService productProcessService;
   @Autowired
   private MesBuildingInProductionService inProductionService;
   @Autowired
   private MesBuildingProjectProductionSummaryBiz projectProductionSummaryBiz;
   @Autowired
   private MesInspectConfigService inspectConfigService;
   @Autowired
   private MesBuildingCompleteService completeService;
   @Autowired
   private MesBuildingProduceTeamReportPriceService teamReportPriceService;
   @Autowired
   private MesBuildingSinglePartArtifactPrintService singlePartArtifactPrintService;
   @Autowired
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Autowired
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Autowired
   private MesBuildingAssistNumberDetailService mesBuildingAssistNumberDetailService;
   @Autowired
   private MesBuildingTaskNumberLinkService taskNumberLinkService;
   @Resource
   private MesBuildingProduceTeamReportService teamReportService;
   @Autowired
   private MesBuildingTaskProcessBiz mesBuildingTaskProcessBiz;
   @Autowired
   private ConfigService configService;
   @Autowired
   private MesBuildingProduceInspectionTeamReportPaintThicknessLinkService paintThicknessLinkService;

   private void updateQuantity(Long taskId, Integer reportQuantity) {
      Objects.requireNonNull(taskId, "任务ID不能为空");
      Objects.requireNonNull(reportQuantity, "上报数量不能为空");
      Preconditions.checkArgument(reportQuantity > 0, "上报数量必须大于0");
      MesBuildingTask task = this.taskService.getById(taskId);
      Preconditions.checkArgument(task != null, "未找到指定任务");
      boolean needUpdateTask = false;
      boolean needUpdateProject = false;
      ContractProject project = null;
      if (task.getInProductionTime() == null) {
         task.setInProductionTime(LocalDateTime.now());
         needUpdateTask = true;
         project = this.projectService.getById(task.getProjectId());
         if (project != null && project.getMesStartDate() == null) {
            project.setMesStartDate(LocalDateTime.now());
            needUpdateProject = true;
         }
      }

      Integer newInProductionQuantity = task.getInProductionQuantity() + reportQuantity;
      task.setInProductionQuantity(newInProductionQuantity);
      needUpdateTask = true;
      if (needUpdateProject) {
         this.projectService.updateById(project);
      }

      if (needUpdateTask) {
         this.taskService.updateById(task);
      }

      Preconditions.checkArgument(this.taskService.updateById(task), "上报中,请刷新页面");
      ProductProductionSummaryDTOParam param = ProductProductionSummaryDTOParam.builder()
         .projectId(task.getProjectId())
         .monomerId(task.getMonomerId())
         .productId(task.getProductId())
         .productType(task.getTaskTypeEnum())
         .inProductionQuantity(reportQuantity)
         .build();
      this.productionSummaryService.updateRecord(param);
   }

   @Transactional(rollbackFor = Exception.class)
   public List<Integer> updateTaskProcess2(
      MesBuildingTaskProcess mesBuildingTaskProcess,
      Integer reportQuantity,
      boolean isInspection,
      Long assistLineId,
      Long teamId,
      Boolean reportType,
      List<Integer> numberList,
      MesBuildingAssist assist,
      Long currentNextProcessId
   ) {
      boolean booleOneCode = CollectionUtils.isNotEmpty(numberList);
      MesBuildingTeam team = this.validateTeam(teamId);
      MesBuildingNewTaskBizImpl.AssistDataResult assistDataResult = this.processAssistData(assist, mesBuildingTaskProcess, numberList, reportQuantity);
      Long nextProcessId = this.getNextProcessId(mesBuildingTaskProcess, currentNextProcessId);
      numberList = this.processNumberLinks(
         mesBuildingTaskProcess, nextProcessId, reportQuantity, isInspection, numberList, assist, assistDataResult, booleOneCode
      );
      if (!mesBuildingTaskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())
         && !mesBuildingTaskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         this.taskBiz.saveTeamReport(mesBuildingTaskProcess, reportQuantity, isInspection, reportType, null, team, assist, booleOneCode);
      } else {
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(numberList), "操作失败,产品需要一物一码");
         this.taskBiz.saveTeamReport(mesBuildingTaskProcess, reportQuantity, isInspection, reportType, numberList, team, assist, booleOneCode);
      }

      if (isInspection) {
         mesBuildingTaskProcess.setCompleteQuantity(mesBuildingTaskProcess.getCompleteQuantity() + reportQuantity);
         this.taskProcessService.updateById(mesBuildingTaskProcess);
         this.saveProduceTeamReportSummary2(
            mesBuildingTaskProcess,
            reportQuantity,
            assist == null ? assistLineId : assist.getProductionLineId(),
            team.getId(),
            SaveProduceTeamReportSummaryTypeEnum.PRODUCE_REPORT.getType()
         );
      } else {
         this.saveProduceTeamReportSummary2(
            mesBuildingTaskProcess,
            reportQuantity,
            assist == null ? assistLineId : assist.getProductionLineId(),
            team.getId(),
            SaveProduceTeamReportSummaryTypeEnum.UN_INSPECTION_REPORT.getType()
         );
         mesBuildingTaskProcess.setCompleteQuantity(mesBuildingTaskProcess.getCompleteQuantity() + reportQuantity);
         mesBuildingTaskProcess.setInspectionQuantity(mesBuildingTaskProcess.getInspectionQuantity() + reportQuantity);
         if (mesBuildingTaskProcess.getCompleteQuantity().equals(mesBuildingTaskProcess.getNeedQuantity())) {
            mesBuildingTaskProcess.setCompleteTime(LocalDateTime.now());
         }

         this.taskProcessService.updateById(mesBuildingTaskProcess);
         this.taskBiz.updateNextTaskProcess(mesBuildingTaskProcess, reportQuantity, team.getId(), numberList);
      }

      return numberList;
   }

   private MesBuildingTeam validateTeam(Long teamId) {
      MesBuildingTeam team = this.teamService.getById(teamId);
      Preconditions.checkArgument(team != null, "上报失败,用户没有处于可以生产班组内");
      return team;
   }

   private MesBuildingNewTaskBizImpl.AssistDataResult processAssistData(
      MesBuildingAssist assist, MesBuildingTaskProcess taskProcess, List<Integer> numberList, Integer reportQuantity
   ) {
      MesBuildingNewTaskBizImpl.AssistDataResult result = new MesBuildingNewTaskBizImpl.AssistDataResult();
      if (assist != null) {
         List<MesBuildingAssistNumberDetail> assistDetails = this.assistNumberDetailService
            .list(
               Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class)
                  .eq(MesBuildingAssistNumberDetail::getAssistId, assist.getId())
                  .eq(MesBuildingAssistNumberDetail::getTaskProcessId, taskProcess.getId())
                  .orderByAsc(MesBuildingAssistNumberDetail::getNumber)
            );
         if (CollectionUtils.isNotEmpty(numberList)) {
            Set<Integer> numberSet = new HashSet<>(numberList);
            assistDetails = assistDetails.stream().filter(s -> numberSet.contains(s.getNumber())).collect(Collectors.toList());
            Preconditions.checkArgument(assistDetails.stream().noneMatch(MesBuildingAssistNumberDetail::getBoolFinishEnum), "操作失败!");
         }

         Preconditions.checkArgument(assistDetails.size() >= reportQuantity, "操作失败!");
         Map<Integer, MesBuildingAssistNumberDetail> assistDetaiMap = assistDetails.stream()
            .collect(Collectors.toMap(MesBuildingAssistNumberDetail::getNumber, Function.identity()));
         List<Integer> assistNumbers = assistDetails.stream()
            .filter(s -> !s.getBoolFinishEnum())
            .map(MesBuildingAssistNumberDetail::getNumber)
            .collect(Collectors.toList());
         result.setAssistDetails(assistDetails);
         result.setAssistDetaiMap(assistDetaiMap);
         result.setAssistNumbers(assistNumbers);
      } else {
         List<MesBuildingAssistNumberDetail> assistDetails = this.assistNumberDetailService
            .list(
               Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class)
                  .eq(MesBuildingAssistNumberDetail::getTaskProcessId, taskProcess.getId())
                  .orderByAsc(MesBuildingAssistNumberDetail::getNumber)
            );
         Map<Integer, MesBuildingAssistNumberDetail> assistDetaiMap = assistDetails.stream()
            .collect(Collectors.toMap(MesBuildingAssistNumberDetail::getNumber, Function.identity()));
         List<Integer> assistNumbers = assistDetails.stream().map(MesBuildingAssistNumberDetail::getNumber).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(numberList)) {
            Set<Integer> assistNumberSet = new HashSet<>(assistNumbers);

            for (Integer number : numberList) {
               Preconditions.checkArgument(!assistNumberSet.contains(number), "操作失败,码号" + number + "属于协同码号");
            }
         }

         result.setAssistDetails(assistDetails);
         result.setAssistDetaiMap(assistDetaiMap);
         result.setAssistNumbers(assistNumbers);
      }

      return result;
   }

   private Long getNextProcessId(MesBuildingTaskProcess taskProcess, Long currentNextProcessId) {
      List<MesBuildingNextProcessLink> nextProcessLinks = this.nextProcessLinkService
         .list(Wrappers.lambdaQuery(MesBuildingNextProcessLink.class).eq(MesBuildingNextProcessLink::getTaskProcessId, taskProcess.getId()));
      if (currentNextProcessId != null && nextProcessLinks.size() > 1) {
         return currentNextProcessId;
      }

      if (nextProcessLinks.size() == 1) {
         return nextProcessLinks.get(0).getNextProcessId() == null ? 0L : nextProcessLinks.get(0).getNextProcessId();
      }

      Preconditions.checkArgument(false, "数据错误，请联系管理员");
      return 0L;
   }

   private List<Integer> processNumberLinks(
      MesBuildingTaskProcess taskProcess,
      Long nextProcessId,
      Integer reportQuantity,
      boolean isInspection,
      List<Integer> numberList,
      MesBuildingAssist assist,
      MesBuildingNewTaskBizImpl.AssistDataResult assistDataResult,
      boolean booleOneCode
   ) {
      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         return this.processArtifactNumberLinks(taskProcess, nextProcessId, reportQuantity, isInspection, numberList, assist, assistDataResult);
      } else {
         return taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())
            ? this.processAssembleNumberLinks(taskProcess, nextProcessId, reportQuantity, isInspection, numberList, assist, assistDataResult)
            : new ArrayList<>();
      }
   }

   private List<Integer> processArtifactNumberLinks(
      MesBuildingTaskProcess taskProcess,
      Long nextProcessId,
      Integer reportQuantity,
      boolean isInspection,
      List<Integer> numberList,
      MesBuildingAssist assist,
      MesBuildingNewTaskBizImpl.AssistDataResult assistDataResult
   ) {
      List<MesBuildingTaskNumberLink> numberLinks = this.getArtifactNumberLinks(taskProcess, numberList);
      Map<Integer, List<MesBuildingTaskNumberLink>> numberLinkMap = this.groupAndSortArtifactNumberLinks(numberLinks);
      Preconditions.checkArgument(numberLinkMap.keySet().size() >= reportQuantity, "操作失败,请刷新页面后重试!!!!");
      List<Long> assembleIds = numberLinks.stream()
         .map(MesBuildingTaskNumberLink::getAssembleId)
         .filter(Objects::nonNull)
         .distinct()
         .collect(Collectors.toList());
      Map<Long, List<MesBuildingTaskNumberLink>>[] assembleMaps = this.processAssembleLinks(assembleIds, numberLinks);
      Map<Long, List<MesBuildingTaskNumberLink>> assembleTaskNumberLinkMap = assembleMaps[0];
      Map<Long, List<MesBuildingTaskNumberLink>> useaAssembleTaskNumberLinkMap = assembleMaps[1];
      List<MesBuildingTaskNumberLink> allValues = new ArrayList<>();
      List<MesBuildingTaskNumberLink> usedTaskNumberLinks = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(numberList)) {
         this.processSelectedNumberLinks(numberLinks, assembleTaskNumberLinkMap, allValues, taskProcess);
      } else {
         this.processUnselectedNumberLinks(numberLinkMap, reportQuantity, assembleTaskNumberLinkMap, allValues, assist, assistDataResult);
      }

      MesBuildingTaskProcess nextTaskProcess = this.getNextTaskProcess(taskProcess, nextProcessId);
      this.updateArtifactNumberLinks(allValues, usedTaskNumberLinks, nextProcessId, nextTaskProcess, isInspection, taskProcess, useaAssembleTaskNumberLinkMap);
      this.batchUpdateNumberLinks(allValues, usedTaskNumberLinks);
      this.updateAssistNumberDetails(assistDataResult.getAssistNumberDetailUpdates());
      return allValues.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().collect(Collectors.toList());
   }

   private List<Integer> processAssembleNumberLinks(
      MesBuildingTaskProcess taskProcess,
      Long nextProcessId,
      Integer reportQuantity,
      boolean isInspection,
      List<Integer> numberList,
      MesBuildingAssist assist,
      MesBuildingNewTaskBizImpl.AssistDataResult assistDataResult
   ) {
      List<MesBuildingTaskNumberLink> numberLinks = this.getAssembleNumberLinks(taskProcess, numberList);
      if (assist != null) {
         Set<Integer> assistNumberSet = new HashSet<>(assistDataResult.getAssistNumbers());
         numberLinks = numberLinks.stream().filter(s -> assistNumberSet.contains(s.getAssembleNumber())).collect(Collectors.toList());
         Preconditions.checkArgument(numberLinks.size() >= reportQuantity);
      }

      numberLinks = numberLinks.stream().limit(reportQuantity.intValue()).collect(Collectors.toList());
      Preconditions.checkArgument(numberLinks.size() >= reportQuantity, "操作失败,请刷新页面后重试!!!!");
      if (assist != null) {
         Map<Integer, MesBuildingAssistNumberDetail> assistDetaiMap = assistDataResult.getAssistDetaiMap();

         for (MesBuildingTaskNumberLink numberLink : numberLinks) {
            MesBuildingAssistNumberDetail detail = assistDetaiMap.get(numberLink.getAssembleNumber());
            assistDataResult.getAssistNumberDetailUpdates().add(detail);
         }
      }

      MesBuildingTaskProcess nextTaskProcess = this.getNextTaskProcess(taskProcess, nextProcessId);
      this.updateAssembleNumberLinks(numberLinks, nextProcessId, nextTaskProcess, isInspection);
      this.mesBuildingTaskNumberLinkService.updateBatchById(numberLinks);
      this.updateAssistNumberDetails(assistDataResult.getAssistNumberDetailUpdates());
      return numberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList());
   }

   private List<MesBuildingTaskNumberLink> getArtifactNumberLinks(MesBuildingTaskProcess taskProcess, List<Integer> numberList) {
      return this.mesBuildingTaskNumberLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
               .eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, taskProcess.getId())
               .in(CollectionUtils.isNotEmpty(numberList), MesBuildingTaskNumberLink::getArtifactNumber, numberList)
               .eq(CollectionUtils.isNotEmpty(numberList), MesBuildingTaskNumberLink::getBoolOneCode, true)
               .eq(CollectionUtils.isEmpty(numberList), MesBuildingTaskNumberLink::getBoolOneCode, false)
               .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, false)
               .orderByAsc(MesBuildingTaskNumberLink::getArtifactNumber)
         );
   }

   private List<MesBuildingTaskNumberLink> getAssembleNumberLinks(MesBuildingTaskProcess taskProcess, List<Integer> numberList) {
      return this.mesBuildingTaskNumberLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
               .eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, taskProcess.getId())
               .in(CollectionUtils.isNotEmpty(numberList), MesBuildingTaskNumberLink::getAssembleNumber, numberList)
               .eq(CollectionUtils.isNotEmpty(numberList), MesBuildingTaskNumberLink::getBoolOneCode, true)
               .eq(CollectionUtils.isEmpty(numberList), MesBuildingTaskNumberLink::getBoolOneCode, false)
               .eq(MesBuildingTaskNumberLink::getBoolAssembleReport, false)
               .orderByAsc(MesBuildingTaskNumberLink::getAssembleNumber)
         );
   }

   private Map<Integer, List<MesBuildingTaskNumberLink>> groupAndSortArtifactNumberLinks(List<MesBuildingTaskNumberLink> numberLinks) {
      return numberLinks.stream().collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactNumber)).entrySet().stream().sorted((entry1, entry2) -> {
         boolean allTrue1 = entry1.getValue().stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete);
         boolean allTrue2 = entry2.getValue().stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete);
         if (allTrue1 && !allTrue2) {
            return -1;
         } else {
            return !allTrue1 && allTrue2 ? 1 : entry1.getKey().compareTo(entry2.getKey());
         }
      }).collect(Collectors.toMap(Entry::getKey, Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
   }

   private Map<Long, List<MesBuildingTaskNumberLink>>[] processAssembleLinks(List<Long> assembleIds, List<MesBuildingTaskNumberLink> numberLinks) {
      Map<Long, List<MesBuildingTaskNumberLink>> assembleTaskNumberLinkMap = new HashMap<>();
      Map<Long, List<MesBuildingTaskNumberLink>> useaAssembleTaskNumberLinkMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(assembleIds)) {
         Set<Long> idSet = new HashSet<>(numberLinks.stream().map(MesBuildingTaskNumberLink::getId).collect(Collectors.toList()));
         List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinks = this.mesBuildingTaskNumberLinkService
            .list(
               (Wrapper<MesBuildingTaskNumberLink>)((((((new LambdaQueryWrapper<MesBuildingTaskNumberLink>()
                                    .in(MesBuildingTaskNumberLink::getAssembleId, assembleIds))
                                 .eq(MesBuildingTaskNumberLink::getBoolAssembleComplete, Boolean.TRUE))
                              .eq(MesBuildingTaskNumberLink::getBoolArtifactInspection, Boolean.FALSE))
                           .eq(MesBuildingTaskNumberLink::getBoolArtifactInproduce, Boolean.FALSE))
                        .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, Boolean.FALSE))
                     .eq(MesBuildingTaskNumberLink::getBoolArtifactComplete, Boolean.FALSE))
                  .notIn(MesBuildingTaskNumberLink::getId, idSet)
            );
         if (CollectionUtils.isNotEmpty(mesBuildingTaskNumberLinks)) {
            List<MesBuildingTaskNumberLink> usedNumberLinks = BeanUtil.copyToList(mesBuildingTaskNumberLinks, MesBuildingTaskNumberLink.class);
            assembleTaskNumberLinkMap = mesBuildingTaskNumberLinks.stream().collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId));
            useaAssembleTaskNumberLinkMap = usedNumberLinks.stream().collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId));
         }
      }

      return new Map[]{assembleTaskNumberLinkMap, useaAssembleTaskNumberLinkMap};
   }

   private void processSelectedNumberLinks(
      List<MesBuildingTaskNumberLink> numberLinks,
      Map<Long, List<MesBuildingTaskNumberLink>> assembleTaskNumberLinkMap,
      List<MesBuildingTaskNumberLink> allValues,
      MesBuildingTaskProcess taskProcess
   ) {
      if (!numberLinks.stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete)
         && numberLinks.stream().allMatch(e -> e.getAssembleId() != null)
         && taskProcess.getSequence() == 0) {
         numberLinks.stream()
            .filter(e -> !e.getBoolAssembleComplete())
            .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId))
            .forEach(
               (assembleId, taskNumberLinkList) -> {
                  List<MesBuildingTaskNumberLink> assembleTaskNumberLinks = assembleTaskNumberLinkMap.get(assembleId);
                  Preconditions.checkArgument(
                     CollectionUtils.isNotEmpty(assembleTaskNumberLinks) && assembleTaskNumberLinks.size() >= taskNumberLinkList.size(), "操作失败,请刷新页面后重试!"
                  );
                  assembleTaskNumberLinks.subList(0, taskNumberLinkList.size()).clear();
               }
            );
      }

      allValues.addAll(numberLinks);
   }

   private void processUnselectedNumberLinks(
      Map<Integer, List<MesBuildingTaskNumberLink>> numberLinkMap,
      Integer reportQuantity,
      Map<Long, List<MesBuildingTaskNumberLink>> assembleTaskNumberLinkMap,
      List<MesBuildingTaskNumberLink> allValues,
      MesBuildingAssist assist,
      MesBuildingNewTaskBizImpl.AssistDataResult assistDataResult
   ) {
      Integer needLimit = reportQuantity;
      List<Integer> assistNumbers = assistDataResult.getAssistNumbers();
      Map<Integer, MesBuildingAssistNumberDetail> assistDetaiMap = assistDataResult.getAssistDetaiMap();

      for (Integer number : numberLinkMap.keySet()) {
         if (assist == null && !assistNumbers.contains(number) || assist != null && assistNumbers.contains(number)) {
            List<MesBuildingTaskNumberLink> links = numberLinkMap.get(number);
            if (needLimit > 0 && links.stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete)) {
               needLimit = needLimit - 1;
               allValues.addAll(links);
               if (assist != null) {
                  MesBuildingAssistNumberDetail detail = assistDetaiMap.get(number);
                  assistDataResult.getAssistNumberDetailUpdates().add(detail);
               }
            }

            if (needLimit > 0
               && !links.stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete)
               && links.stream().allMatch(e -> e.getAssembleId() != null)) {
               links.stream()
                  .filter(e -> !e.getBoolAssembleComplete())
                  .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId))
                  .forEach(
                     (assembleId, taskNumberLinkList) -> {
                        List<MesBuildingTaskNumberLink> assembleTaskNumberLinks = assembleTaskNumberLinkMap.get(assembleId);
                        Preconditions.checkArgument(
                           CollectionUtils.isNotEmpty(assembleTaskNumberLinks) && assembleTaskNumberLinks.size() >= taskNumberLinkList.size(), "操作失败,请刷新页面后重试!"
                        );
                        assembleTaskNumberLinks.subList(0, taskNumberLinkList.size()).clear();
                     }
                  );
               needLimit = needLimit - 1;
               allValues.addAll(links);
               if (assist != null) {
                  MesBuildingAssistNumberDetail detail = assistDetaiMap.get(number);
                  assistDataResult.getAssistNumberDetailUpdates().add(detail);
               }
            }
         }

         if (needLimit <= 0) {
            break;
         }
      }

      Preconditions.checkArgument(needLimit == 0, "操作失败!");
   }

   private MesBuildingTaskProcess getNextTaskProcess(MesBuildingTaskProcess taskProcess, Long nextProcessId) {
      return nextProcessId == 0L
         ? null
         : this.taskProcessService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                  .eq(MesBuildingTaskProcess::getTaskId, taskProcess.getTaskId())
                  .eq(MesBuildingTaskProcess::getProcessId, nextProcessId)
            );
   }

   private void updateArtifactNumberLinks(
      List<MesBuildingTaskNumberLink> allValues,
      List<MesBuildingTaskNumberLink> usedTaskNumberLinks,
      Long nextProcessId,
      MesBuildingTaskProcess nextTaskProcess,
      boolean isInspection,
      MesBuildingTaskProcess taskProcess,
      Map<Long, List<MesBuildingTaskNumberLink>> useaAssembleTaskNumberLinkMap
   ) {
      for (MesBuildingTaskNumberLink numberLink : allValues) {
         numberLink.setBoolArtifactInproduce(Boolean.TRUE);
         numberLink.setArtifactNextProcessId(nextProcessId);
         if (!isInspection) {
            if (nextProcessId == 0L) {
               numberLink.setArtifactTaskProcessId(0L);
               numberLink.setBoolArtifactReport(Boolean.TRUE);
               numberLink.setBoolArtifactInspection(Boolean.TRUE);
               numberLink.setBoolArtifactComplete(Boolean.TRUE);
            } else {
               Long nextTaskProcessId = nextTaskProcess == null ? 0L : nextTaskProcess.getId();
               numberLink.setArtifactTaskProcessId(nextTaskProcessId);
               numberLink.setBoolArtifactReport(Boolean.FALSE);
               numberLink.setBoolArtifactInspection(Boolean.FALSE);
            }
         } else {
            numberLink.setBoolArtifactReport(true);
            numberLink.setBoolArtifactInspection(Boolean.FALSE);
         }

         if (taskProcess.getSequence() == 0 && numberLink.getAssembleId() != null && !numberLink.getBoolAssembleComplete()) {
            List<MesBuildingTaskNumberLink> usedNumberLinks = useaAssembleTaskNumberLinkMap.get(numberLink.getAssembleId());
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(usedNumberLinks), "操作失败,请刷新页面后重试!");
            MesBuildingTaskNumberLink usedLink = usedNumberLinks.get(0);
            this.swapNumberLinkProperties(numberLink, usedLink);
            usedTaskNumberLinks.add(usedLink);
            usedNumberLinks.remove(usedLink);
         }
      }

      this.batchUpdateNumberLinks(allValues, usedTaskNumberLinks);
   }

   private void updateAssembleNumberLinks(
      List<MesBuildingTaskNumberLink> numberLinks, Long nextProcessId, MesBuildingTaskProcess nextTaskProcess, boolean isInspection
   ) {
      for (MesBuildingTaskNumberLink numberLink : numberLinks) {
         numberLink.setBoolAssembleInproduce(Boolean.TRUE);
         numberLink.setAssembleNextProcessId(nextProcessId);
         if (!isInspection) {
            if (nextProcessId == 0L) {
               numberLink.setAssembleTaskProcessId(0L);
               numberLink.setBoolAssembleReport(Boolean.TRUE);
               numberLink.setBoolAssembleInspection(Boolean.TRUE);
               numberLink.setBoolAssembleComplete(Boolean.TRUE);
            } else {
               Long nextTaskProcessId = nextTaskProcess == null ? 0L : nextTaskProcess.getId();
               numberLink.setAssembleTaskProcessId(nextTaskProcessId);
               numberLink.setBoolAssembleReport(Boolean.FALSE);
               numberLink.setBoolAssembleInspection(Boolean.FALSE);
            }
         } else {
            numberLink.setBoolAssembleReport(true);
            numberLink.setBoolAssembleInspection(Boolean.FALSE);
         }
      }
   }

   private void batchUpdateNumberLinks(List<MesBuildingTaskNumberLink> allValues, List<MesBuildingTaskNumberLink> usedTaskNumberLinks) {
      if (!allValues.isEmpty()) {
         this.mesBuildingTaskNumberLinkService.updateBatchById(allValues);
      }

      if (!usedTaskNumberLinks.isEmpty()) {
         this.mesBuildingTaskNumberLinkService.updateBatchById(usedTaskNumberLinks);
      }
   }

   private void updateAssistNumberDetails(List<MesBuildingAssistNumberDetail> assistNumberDetailUpdates) {
      if (CollectionUtils.isNotEmpty(assistNumberDetailUpdates)) {
         assistNumberDetailUpdates.forEach(s -> s.setBoolFinishEnum(Boolean.TRUE));
         this.assistNumberDetailService.updateBatchById(assistNumberDetailUpdates);
      }
   }

   private void swapNumberLinkProperties(MesBuildingTaskNumberLink source, MesBuildingTaskNumberLink target) {
      Long assembleTaskId = source.getAssembleTaskId();
      Long assembleTaskProcessId = source.getAssembleTaskProcessId();
      Long assembleNextProcessId = source.getAssembleNextProcessId();
      Integer assembleNumber = source.getAssembleNumber();
      Boolean boolAssembleComplete = source.getBoolAssembleComplete();
      Boolean boolAssembleReport = source.getBoolAssembleReport();
      Boolean boolAssembleInproduce = source.getBoolAssembleInproduce();
      Boolean boolAssembleInspection = source.getBoolAssembleInspection();
      source.setAssembleTaskId(target.getAssembleTaskId());
      source.setAssembleTaskProcessId(target.getAssembleTaskProcessId());
      source.setAssembleNextProcessId(target.getAssembleNextProcessId());
      source.setAssembleNumber(target.getAssembleNumber());
      source.setBoolAssembleComplete(target.getBoolAssembleComplete());
      source.setBoolAssembleReport(target.getBoolAssembleReport());
      source.setBoolAssembleInproduce(target.getBoolAssembleInproduce());
      source.setBoolAssembleInspection(target.getBoolAssembleInspection());
      target.setAssembleTaskId(assembleTaskId);
      target.setAssembleTaskProcessId(assembleTaskProcessId);
      target.setAssembleNextProcessId(assembleNextProcessId);
      target.setAssembleNumber(assembleNumber);
      target.setBoolAssembleComplete(boolAssembleComplete);
      target.setBoolAssembleReport(boolAssembleReport);
      target.setBoolAssembleInproduce(boolAssembleInproduce);
      target.setBoolAssembleInspection(boolAssembleInspection);
   }

   List<Integer> updateTaskProcessV3(
      MesBuildingTaskProcess mesBuildingTaskProcess,
      Integer reportQuantity,
      boolean isInspection,
      Long assistLineId,
      Long teamId,
      Boolean reportType,
      List<Integer> numberList,
      MesBuildingAssist assist,
      Long currentNextProcessId,
      Long reportPersonId,
      BigDecimal perforateQuantity
   ) {
      boolean booleOneCode = CollectionUtils.isNotEmpty(numberList);
      MesBuildingTeam team = this.teamService.getById(teamId);
      Preconditions.checkArgument(team != null, "上报失败,用户没有处于可以生产班组内");
      new HashMap();
      new ArrayList();
      List<Integer> finalNumberList = numberList;
      List<MesBuildingAssistNumberDetail> assistDetails;
      Map assistDetaiMap;
      List<Integer> assistNumbers;
      if (assist != null) {
         assistDetails = this.assistNumberDetailService
            .list(
               Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class)
                  .eq(MesBuildingAssistNumberDetail::getAssistId, assist.getId())
                  .eq(MesBuildingAssistNumberDetail::getTaskProcessId, mesBuildingTaskProcess.getId())
                  .orderByAsc(MesBuildingAssistNumberDetail::getNumber)
            );
         if (CollectionUtils.isNotEmpty(numberList)) {
            assistDetails = assistDetails.stream().filter(s -> finalNumberList.contains(s.getNumber())).collect(Collectors.toList());
            Preconditions.checkArgument(assistDetails.stream().noneMatch(MesBuildingAssistNumberDetail::getBoolFinishEnum), "操作失败!");
         }

         Preconditions.checkArgument(assistDetails.size() >= reportQuantity, "操作失败!");
         assistDetaiMap = assistDetails.stream().collect(Collectors.toMap(MesBuildingAssistNumberDetail::getNumber, Function.identity()));
         assistNumbers = assistDetails.stream().filter(s -> !s.getBoolFinishEnum()).map(MesBuildingAssistNumberDetail::getNumber).collect(Collectors.toList());
      } else {
         assistDetails = this.assistNumberDetailService
            .list(
               Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class)
                  .eq(MesBuildingAssistNumberDetail::getTaskProcessId, mesBuildingTaskProcess.getId())
                  .orderByAsc(MesBuildingAssistNumberDetail::getNumber)
            );
         assistDetaiMap = assistDetails.stream().collect(Collectors.toMap(MesBuildingAssistNumberDetail::getNumber, Function.identity()));
         assistNumbers = assistDetails.stream().map(MesBuildingAssistNumberDetail::getNumber).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(numberList)) {
            for (Integer assistNumber : assistNumbers) {
               if (finalNumberList.contains(assistNumber)) {
                  throw new IllegalArgumentException("操作失败,码号" + assistNumber + "属于协同码号");
               }
            }
         }
      }

      List<MesBuildingNextProcessLink> nextProcessLinks = this.nextProcessLinkService
         .list(Wrappers.lambdaQuery(MesBuildingNextProcessLink.class).eq(MesBuildingNextProcessLink::getTaskProcessId, mesBuildingTaskProcess.getId()));
      Long nextProcessId = 0L;
      if (currentNextProcessId != null && nextProcessLinks.size() > 1) {
         nextProcessId = currentNextProcessId;
      } else if (nextProcessLinks.size() == 1) {
         nextProcessId = nextProcessLinks.get(0).getNextProcessId() == null ? 0L : nextProcessLinks.get(0).getNextProcessId();
      } else {
         Preconditions.checkArgument(false, "数据错误，请联系管理员");
      }

      List<MesBuildingAssistNumberDetail> assistNumberDetailUpdates = new ArrayList<>();
      if (mesBuildingTaskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<MesBuildingTaskNumberLink> numberLinks = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, mesBuildingTaskProcess.getId())
                  .in(CollectionUtils.isNotEmpty(numberList), MesBuildingTaskNumberLink::getArtifactNumber, numberList)
                  .eq(CollectionUtils.isNotEmpty(numberList), MesBuildingTaskNumberLink::getBoolOneCode, true)
                  .eq(CollectionUtils.isEmpty(numberList), MesBuildingTaskNumberLink::getBoolOneCode, false)
                  .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, false)
                  .orderByAsc(MesBuildingTaskNumberLink::getArtifactNumber)
            );
         Map<Integer, List<MesBuildingTaskNumberLink>> numberLinkMap = numberLinks.stream()
            .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactNumber));
         Preconditions.checkArgument(numberLinkMap.keySet().size() >= reportQuantity, "操作失败,请刷新页面后重试!!!!");
         List<MesBuildingTaskNumberLink> allValues = new ArrayList<>();
         if (CollectionUtils.isNotEmpty(numberList)) {
            Preconditions.checkArgument(numberLinks.stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete), "操作失败!");
            allValues.addAll(numberLinks);
            if (assist != null) {
               assistNumberDetailUpdates.addAll(assistDetails);
            }
         } else {
            Integer needLimit = reportQuantity;

            for (Integer number : numberLinkMap.keySet()) {
               if (assist == null && !assistNumbers.contains(number) || assist != null && assistNumbers.contains(number)) {
                  List<MesBuildingTaskNumberLink> links = numberLinkMap.get(number);
                  if (needLimit > 0 && links.stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete)) {
                     needLimit = needLimit - 1;
                     allValues.addAll(links);
                     if (assist != null) {
                        MesBuildingAssistNumberDetail detail = (MesBuildingAssistNumberDetail)assistDetaiMap.get(number);
                        assistNumberDetailUpdates.add(detail);
                     }
                  }
               }
            }

            Preconditions.checkArgument(needLimit == 0, "操作失败!");
         }

         MesBuildingTaskProcess nextTaskProcess = this.taskProcessService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                  .eq(MesBuildingTaskProcess::getTaskId, mesBuildingTaskProcess.getTaskId())
                  .eq(MesBuildingTaskProcess::getProcessId, nextProcessId)
            );

         for (MesBuildingTaskNumberLink numberLink : allValues) {
            numberLink.setBoolArtifactInproduce(Boolean.TRUE);
            numberLink.setArtifactNextProcessId(nextProcessId);
            if (!isInspection) {
               if (nextProcessId == 0L) {
                  numberLink.setArtifactTaskProcessId(0L);
                  numberLink.setBoolArtifactReport(Boolean.TRUE);
                  numberLink.setBoolArtifactInspection(Boolean.TRUE);
                  numberLink.setBoolArtifactComplete(Boolean.TRUE);
               } else {
                  Long nextTaskProcessId = nextTaskProcess == null ? 0L : nextTaskProcess.getId();
                  numberLink.setArtifactTaskProcessId(nextTaskProcessId);
                  numberLink.setBoolArtifactReport(Boolean.FALSE);
                  numberLink.setBoolArtifactInspection(Boolean.FALSE);
               }
            } else {
               numberLink.setBoolArtifactReport(true);
               numberLink.setBoolArtifactInspection(Boolean.FALSE);
            }
         }

         this.mesBuildingTaskNumberLinkService.updateBatchById(allValues);
         numberList = allValues.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().collect(Collectors.toList());
      } else if (mesBuildingTaskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<MesBuildingTaskNumberLink> numberLinks = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, mesBuildingTaskProcess.getId())
                  .in(CollectionUtils.isNotEmpty(numberList), MesBuildingTaskNumberLink::getAssembleNumber, numberList)
                  .eq(CollectionUtils.isNotEmpty(numberList), MesBuildingTaskNumberLink::getBoolOneCode, true)
                  .eq(CollectionUtils.isEmpty(numberList), MesBuildingTaskNumberLink::getBoolOneCode, false)
                  .eq(MesBuildingTaskNumberLink::getBoolAssembleReport, false)
                  .orderByAsc(MesBuildingTaskNumberLink::getAssembleNumber)
            );
         if (assist != null) {
            List<Integer> finalAssistNumbers = assistNumbers;
            numberLinks = numberLinks.stream().filter(s -> finalAssistNumbers.contains(s.getAssembleNumber())).collect(Collectors.toList());
            Preconditions.checkArgument(numberLinks.size() >= reportQuantity);
         }

         numberLinks = numberLinks.stream().limit(reportQuantity.intValue()).collect(Collectors.toList());
         Preconditions.checkArgument(numberLinks.size() >= reportQuantity, "操作失败,请刷新页面后重试!!!!");
         if (assist != null) {
            for (MesBuildingTaskNumberLink numberLink : numberLinks) {
               MesBuildingAssistNumberDetail detail = (MesBuildingAssistNumberDetail)assistDetaiMap.get(numberLink.getAssembleNumber());
               assistNumberDetailUpdates.add(detail);
            }
         }

         MesBuildingTaskProcess nextTaskProcess = this.taskProcessService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                  .eq(MesBuildingTaskProcess::getTaskId, mesBuildingTaskProcess.getTaskId())
                  .eq(MesBuildingTaskProcess::getProcessId, nextProcessId)
            );

         for (MesBuildingTaskNumberLink numberLink : numberLinks) {
            numberLink.setBoolAssembleInproduce(Boolean.TRUE);
            numberLink.setAssembleNextProcessId(nextProcessId);
            if (!isInspection) {
               if (nextProcessId == 0L) {
                  numberLink.setAssembleTaskProcessId(0L);
                  numberLink.setBoolAssembleReport(Boolean.TRUE);
                  numberLink.setBoolAssembleInspection(Boolean.TRUE);
                  numberLink.setBoolAssembleComplete(Boolean.TRUE);
               } else {
                  Long nextTaskProcessId = nextTaskProcess == null ? 0L : nextTaskProcess.getId();
                  numberLink.setAssembleTaskProcessId(nextTaskProcessId);
                  numberLink.setBoolAssembleReport(Boolean.FALSE);
                  numberLink.setBoolAssembleInspection(Boolean.FALSE);
               }
            } else {
               numberLink.setBoolAssembleReport(true);
               numberLink.setBoolAssembleInspection(Boolean.FALSE);
            }
         }

         this.mesBuildingTaskNumberLinkService.updateBatchById(numberLinks);
         numberList = numberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList());
      }

      if (CollectionUtils.isNotEmpty(assistNumberDetailUpdates)) {
         assistNumberDetailUpdates.forEach(s -> s.setBoolFinishEnum(Boolean.TRUE));
         this.assistNumberDetailService.updateBatchById(assistNumberDetailUpdates);
      }

      if (!mesBuildingTaskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())
         && !mesBuildingTaskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         this.taskBiz
            .saveTeamReportV2(mesBuildingTaskProcess, reportQuantity, isInspection, reportType, null, team, assist, booleOneCode, reportPersonId, null);
      } else {
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(numberList), "操作失败,产品需要一物一码");
         this.taskBiz
            .saveTeamReportV2(
               mesBuildingTaskProcess, reportQuantity, isInspection, reportType, numberList, team, assist, booleOneCode, reportPersonId, perforateQuantity
            );
      }

      if (isInspection) {
         mesBuildingTaskProcess.setCompleteQuantity(mesBuildingTaskProcess.getCompleteQuantity() + reportQuantity);
         this.taskProcessService.updateById(mesBuildingTaskProcess);
         this.saveProduceTeamReportSummaryV3(
            mesBuildingTaskProcess,
            reportQuantity,
            assist == null ? assistLineId : assist.getProductionLineId(),
            team.getId(),
            SaveProduceTeamReportSummaryTypeEnum.PRODUCE_REPORT.getType(),
            reportPersonId
         );
      } else {
         this.saveProduceTeamReportSummaryV3(
            mesBuildingTaskProcess,
            reportQuantity,
            assist == null ? assistLineId : assist.getProductionLineId(),
            team.getId(),
            SaveProduceTeamReportSummaryTypeEnum.UN_INSPECTION_REPORT.getType(),
            reportPersonId
         );
         mesBuildingTaskProcess.setCompleteQuantity(mesBuildingTaskProcess.getCompleteQuantity() + reportQuantity);
         mesBuildingTaskProcess.setInspectionQuantity(mesBuildingTaskProcess.getInspectionQuantity() + reportQuantity);
         if (mesBuildingTaskProcess.getCompleteQuantity().equals(mesBuildingTaskProcess.getNeedQuantity())) {
            mesBuildingTaskProcess.setCompleteTime(LocalDateTime.now());
         }

         this.taskProcessService.updateById(mesBuildingTaskProcess);
         this.taskBiz.updateNextTaskProcess(mesBuildingTaskProcess, reportQuantity, team.getId(), numberList);
      }

      return numberList;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveProduceTeamReportSummary2(MesBuildingTaskProcess taskProcess, Integer reportQuantity, Long assistLineId, Long teamId, Integer type) {
      Long productionLineId = assistLineId == null ? taskProcess.getProductionLineId() : assistLineId;
      MesBuildingProduceTeamReportSummary produceTeamReportSummary = this.produceTeamReportSummaryService
         .getOne(
            (Wrapper<MesBuildingProduceTeamReportSummary>)((Wrappers.<MesBuildingProduceTeamReportSummary>lambdaQuery()
                     .eq(MesBuildingProduceTeamReportSummary::getTaskProcessId, taskProcess.getId()))
                  .eq(MesBuildingProduceTeamReportSummary::getProductionLineId, productionLineId))
               .eq(MesBuildingProduceTeamReportSummary::getTeamId, teamId)
         );
      if (produceTeamReportSummary != null) {
         if (type == SaveProduceTeamReportSummaryTypeEnum.PRODUCE_REPORT.getType()) {
            produceTeamReportSummary.setQuantity(produceTeamReportSummary.getQuantity() + reportQuantity);
         } else if (type == SaveProduceTeamReportSummaryTypeEnum.UN_INSPECTION_REPORT.getType()) {
            produceTeamReportSummary.setQuantity(produceTeamReportSummary.getQuantity() + reportQuantity);
            produceTeamReportSummary.setInspectionQuantity(produceTeamReportSummary.getInspectionQuantity() + reportQuantity);
         } else if (type == SaveProduceTeamReportSummaryTypeEnum.INSPECTION_REPORT.getType()) {
            produceTeamReportSummary.setInspectionQuantity(produceTeamReportSummary.getInspectionQuantity() + reportQuantity);
         } else if (type == SaveProduceTeamReportSummaryTypeEnum.PROBLEM_REPORT.getType()) {
            produceTeamReportSummary.setProblemQuantity(produceTeamReportSummary.getProblemQuantity() + reportQuantity);
         } else if (type == SaveProduceTeamReportSummaryTypeEnum.ADOPT_PROBLEM_REPORT.getType()) {
            produceTeamReportSummary.setProblemQuantity(produceTeamReportSummary.getProblemQuantity() - reportQuantity);
            produceTeamReportSummary.setInspectionQuantity(produceTeamReportSummary.getInspectionQuantity() + reportQuantity);
         }

         Preconditions.checkArgument(produceTeamReportSummary.getProblemQuantity() >= 0, "操作失败!!");
         Preconditions.checkArgument(
            produceTeamReportSummary.getQuantity() >= produceTeamReportSummary.getInspectionQuantity() + produceTeamReportSummary.getProblemQuantity(),
            "操作失败!!"
         );
         this.produceTeamReportSummaryService.updateById(produceTeamReportSummary);
      } else {
         MesBuildingProduceTeamReportSummary summary = MesBuildingProduceTeamReportSummary.builder()
            .productId(taskProcess.getProductId())
            .taskTypeEnum(taskProcess.getTaskTypeEnum())
            .processId(taskProcess.getProcessId())
            .taskId(taskProcess.getTaskId())
            .productionLineId(productionLineId)
            .teamId(teamId)
            .taskProcessId(taskProcess.getId())
            .quantity(reportQuantity)
            .userId(UserUtil.getCurrentUserId())
            .schedulingId(taskProcess.getSchedulingId())
            .build();
         if (type == SaveProduceTeamReportSummaryTypeEnum.UN_INSPECTION_REPORT.getType()) {
            summary.setInspectionQuantity(reportQuantity);
         }

         this.produceTeamReportSummaryService.save(summary);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveProduceTeamReportSummaryV3(
      MesBuildingTaskProcess taskProcess, Integer reportQuantity, Long assistLineId, Long teamId, Integer type, Long reportPersonId
   ) {
      MesBuildingProduceTeamReportSummary produceTeamReportSummary = this.produceTeamReportSummaryService
         .getOne(
            (Wrapper<MesBuildingProduceTeamReportSummary>)(((Wrappers.<MesBuildingProduceTeamReportSummary>lambdaQuery()
                        .eq(MesBuildingProduceTeamReportSummary::getTaskProcessId, taskProcess.getId()))
                     .eq(assistLineId == null, MesBuildingProduceTeamReportSummary::getProductionLineId, taskProcess.getProductionLineId()))
                  .eq(assistLineId != null, MesBuildingProduceTeamReportSummary::getProductionLineId, assistLineId))
               .eq(MesBuildingProduceTeamReportSummary::getTeamId, teamId)
         );
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

         Preconditions.checkArgument(produceTeamReportSummary.getProblemQuantity() >= 0, "操作失败!!");
         Preconditions.checkArgument(
            produceTeamReportSummary.getQuantity() >= produceTeamReportSummary.getInspectionQuantity() + produceTeamReportSummary.getProblemQuantity(),
            "操作失败!!"
         );
         this.produceTeamReportSummaryService.updateById(produceTeamReportSummary);
      } else {
         MesBuildingProduceTeamReportSummary summary = MesBuildingProduceTeamReportSummary.builder()
            .productId(taskProcess.getProductId())
            .taskTypeEnum(taskProcess.getTaskTypeEnum())
            .processId(taskProcess.getProcessId())
            .taskId(taskProcess.getTaskId())
            .productionLineId(assistLineId == null ? taskProcess.getProductionLineId() : assistLineId)
            .teamId(teamId)
            .taskProcessId(taskProcess.getId())
            .quantity(reportQuantity)
            .userId(reportPersonId)
            .schedulingId(taskProcess.getSchedulingId())
            .build();
         if (type.equals(SaveProduceTeamReportSummaryTypeEnum.UN_INSPECTION_REPORT.getType())) {
            summary.setInspectionQuantity(reportQuantity);
         }

         this.produceTeamReportSummaryService.save(summary);
      }

      return true;
   }

   private List<Integer> productProduceTeamReport2(
      MesBuildingTaskProcess mesBuildingTaskProcess,
      Integer reportQuantity,
      Long assistLineId,
      Long teamId,
      Boolean reportType,
      List<Integer> numberList,
      MesBuildingAssist assist,
      Long nextProcessId
   ) {
      Boolean boolHaveInspect = this.utilsBiz
         .checkProductLineTeam2(
            mesBuildingTaskProcess.getProductProcessId(),
            assist != null ? assist.getProductionLineId() : mesBuildingTaskProcess.getProductionLineId(),
            teamId,
            mesBuildingTaskProcess.getProcessId()
         );
      return this.updateTaskProcess2(
         mesBuildingTaskProcess, reportQuantity, boolHaveInspect, assistLineId, teamId, reportType, numberList, assist, nextProcessId
      );
   }

   private List<Integer> productProduceTeamReportV3(
      MesBuildingTaskProcess mesBuildingTaskProcess,
      Integer reportQuantity,
      Long assistLineId,
      Long teamId,
      Boolean reportType,
      List<Integer> numberList,
      MesBuildingAssist assist,
      Long nextProcessId,
      Long reportPersonId,
      BigDecimal perforateQuantity
   ) {
      Boolean boolHaveInspect = this.utilsBiz
         .checkProductLineTeam2(
            mesBuildingTaskProcess.getProductProcessId(),
            assist != null ? assist.getProductionLineId() : mesBuildingTaskProcess.getProductionLineId(),
            teamId,
            mesBuildingTaskProcess.getProcessId()
         );
      return this.updateTaskProcessV3(
         mesBuildingTaskProcess,
         reportQuantity,
         boolHaveInspect,
         assistLineId,
         teamId,
         reportType,
         numberList,
         assist,
         nextProcessId,
         reportPersonId,
         perforateQuantity
      );
   }

   List<Integer> checkProductAndProduceTeamReport2(
      MesBuildingTaskProcess taskProcess,
      Integer reportQuantity,
      Long assistLineId,
      Long teamId,
      Boolean reportType,
      List<Integer> numberList,
      MesBuildingAssist assist,
      Long nextProcessId
   ) {
      Integer taskType = taskProcess.getTaskTypeEnum();
      Long projectId = taskProcess.getProjectId();
      boolean isFirstSequence = taskProcess.getSequence() == 0;
      boolean isStandardMode = ProjectModeEnum.STANDARD_MODE.getType().equals(this.projectService.getProjectMode(projectId));
      if (isFirstSequence) {
         if (TaskTypeEnum.ASSEMBLE.getType().equals(taskType)) {
            this.handleFirstSequenceForAssemble(taskProcess, reportQuantity, isStandardMode);
         } else if (TaskTypeEnum.ARTIFACT.getType().equals(taskType)) {
            this.handleFirstSequenceForArtifact(taskProcess, reportQuantity, isStandardMode);
         } else if (TaskTypeEnum.MACHINE_PART.getType().equals(taskType)) {
            this.handleFirstSequenceForMachinePart(taskProcess, reportQuantity);
         }
      }

      if (TaskTypeEnum.MACHINE_PART.getType().equals(taskType)) {
         this.productProduceTeamReport2(taskProcess, reportQuantity, assistLineId, teamId, reportType, numberList, assist, nextProcessId);
      } else {
         numberList = this.productProduceTeamReport2(taskProcess, reportQuantity, assistLineId, teamId, reportType, numberList, assist, nextProcessId);
      }

      return numberList;
   }

   private void handleFirstSequenceForAssemble(MesBuildingTaskProcess taskProcess, Integer reportQuantity, boolean isStandardMode) {
      if (isStandardMode) {
         TechAssemble assemble = this.assembleService.getById(taskProcess.getProductId());
         Preconditions.checkArgument(assemble != null, "操作失败，找不到对应组立");
         List<TechAssembleMachinePartLink> assembleMachinePartLinks = this.assembleMachinePartLinkService
            .list((Wrapper<TechAssembleMachinePartLink>)Wrappers.<TechAssembleMachinePartLink>lambdaQuery().eq(TechAssembleMachinePartLink::getAssembleId, assemble.getId()));
         if (CollectionUtils.isNotEmpty(assembleMachinePartLinks)) {
            this.updateMachinePartQuantitiesForAssemble(assembleMachinePartLinks, reportQuantity);
         }
      }

      this.updateQuantity(taskProcess.getTaskId(), reportQuantity);
   }

   private void handleFirstSequenceForArtifact(MesBuildingTaskProcess taskProcess, Integer reportQuantity, boolean isStandardMode) {
      TechArtifact artifact = this.artifactService.getById(taskProcess.getProductId());
      Preconditions.checkArgument(artifact != null, "操作失败，找不到对应构件");
      if (isStandardMode) {
         this.handleAssembleDetailsForArtifact(artifact, reportQuantity);
         this.handleMachinePartsForArtifact(artifact, reportQuantity);
      }

      this.updateQuantity(taskProcess.getTaskId(), reportQuantity);
   }

   private void handleFirstSequenceForMachinePart(MesBuildingTaskProcess taskProcess, Integer reportQuantity) {
      this.updateQuantity(taskProcess.getTaskId(), reportQuantity);
   }

   private void updateMachinePartQuantitiesForAssemble(List<TechAssembleMachinePartLink> assembleMachinePartLinks, Integer reportQuantity) {
      Set<Long> partIds = new HashSet<>();

      for (TechAssembleMachinePartLink link : assembleMachinePartLinks) {
         partIds.add(link.getMachinePartId());
      }

      if (!partIds.isEmpty()) {
         List<TechMachinePart> machineParts = this.machinePartService.listByIds(partIds);
         Map<Long, TechMachinePart> partMap = new HashMap<>();

         for (TechMachinePart part : machineParts) {
            partMap.put(part.getId(), part);
         }

         List<TechMachinePart> updatedParts = new ArrayList<>();

         for (TechAssembleMachinePartLink link : assembleMachinePartLinks) {
            TechMachinePart machinePart = partMap.get(link.getMachinePartId());
            Preconditions.checkArgument(machinePart != null, "操作失败，找不到对应零件");
            if (!machinePart.getBoolProcess()) {
               machinePart.setProducedQuantity(machinePart.getProducedQuantity() + link.getQuantity() * reportQuantity);
            }

            if (!machinePart.getBoolSendDirectly()) {
               Preconditions.checkArgument(
                  machinePart.getProducedQuantity() - machinePart.getUsedQuantity() >= reportQuantity * link.getQuantity(),
                  "操作失败，零件" + machinePart.getSerialNumber() + "数量不足"
               );
            }

            machinePart.setUsedQuantity(machinePart.getUsedQuantity() + reportQuantity * link.getQuantity());
            updatedParts.add(machinePart);
         }

         if (!updatedParts.isEmpty()) {
            this.machinePartService.updateBatchById(updatedParts);
         }
      }
   }

   private void handleAssembleDetailsForArtifact(TechArtifact artifact, Integer reportQuantity) {
      List<TechAssembleDetail> assembleDetails = this.assembleDetailService
         .list((Wrapper<TechAssembleDetail>)Wrappers.<TechAssembleDetail>lambdaQuery().eq(TechAssembleDetail::getArtifactId, artifact.getId()));
      if (!assembleDetails.isEmpty()) {
         Set<Long> assembleIds = new HashSet<>();

         for (TechAssembleDetail detail : assembleDetails) {
            assembleIds.add(detail.getAssembleId());
         }

         List<TechAssemble> assembleList = this.assembleService.listByIds(assembleIds);
         Map<Long, TechAssemble> assembleMap = new HashMap<>();

         for (TechAssemble assemble : assembleList) {
            assembleMap.put(assemble.getId(), assemble);
         }

         List<TechAssemble> updatedAssembles = new ArrayList<>();

         for (TechAssembleDetail detail : assembleDetails) {
            TechAssemble assemble = assembleMap.get(detail.getAssembleId());
            Preconditions.checkArgument(assemble != null, "操作失败，找不到对应组立");
            if (!assemble.getBoolSendDirectly()) {
               Preconditions.checkArgument(
                  assemble.getProducedQuantity() - assemble.getUsedQuantity() >= reportQuantity * detail.getQuantity(), "操作失败，对应组立数量不足"
               );
            }

            assemble.setUsedQuantity(assemble.getUsedQuantity() + reportQuantity * detail.getQuantity());
            updatedAssembles.add(assemble);
         }

         if (!updatedAssembles.isEmpty()) {
            this.assembleService.updateBatchById(updatedAssembles);
         }
      }
   }

   private void handleMachinePartsForArtifact(TechArtifact artifact, Integer reportQuantity) {
      List<TechArtifactMachinePartLink> artifactMachinePartLinkList = this.artifactMachinePartLinkService
         .list((Wrapper<TechArtifactMachinePartLink>)Wrappers.<TechArtifactMachinePartLink>lambdaQuery().eq(TechArtifactMachinePartLink::getArtifactId, artifact.getId()));
      if (!artifactMachinePartLinkList.isEmpty()) {
         Set<Long> partIds = new HashSet<>();

         for (TechArtifactMachinePartLink link : artifactMachinePartLinkList) {
            partIds.add(link.getMachinePartId());
         }

         List<TechMachinePart> machineParts = this.machinePartService.listByIds(partIds);
         Map<Long, TechMachinePart> partMap = new HashMap<>();

         for (TechMachinePart part : machineParts) {
            partMap.put(part.getId(), part);
         }

         List<TechMachinePart> updatedParts = new ArrayList<>();

         for (TechArtifactMachinePartLink link : artifactMachinePartLinkList) {
            TechMachinePart machinePart = partMap.get(link.getMachinePartId());
            Preconditions.checkArgument(machinePart != null, "操作失败，找不到对应零件");
            if (!machinePart.getRelationType().equals(18) && machinePart.getRelationType().equals(TaskTypeEnum.ARTIFACT.getType())) {
               if (!machinePart.getBoolSendDirectly()) {
                  Preconditions.checkArgument(
                     machinePart.getProducedQuantity() - machinePart.getUsedQuantity() >= reportQuantity * link.getQuantity(),
                     "操作失败，零件" + machinePart.getSerialNumber() + "数量不足"
                  );
               }

               machinePart.setUsedQuantity(machinePart.getUsedQuantity() + reportQuantity * link.getQuantity());
               updatedParts.add(machinePart);
            }
         }

         if (!updatedParts.isEmpty()) {
            this.machinePartService.updateBatchById(updatedParts);
         }
      }
   }

   List<Integer> checkProductAndProduceTeamReportV3(
      MesBuildingTaskProcess taskProcess,
      Integer reportQuantity,
      Long assistLineId,
      Long teamId,
      Boolean reportType,
      List<Integer> numberList,
      MesBuildingAssist assist,
      Long nextProcessId,
      Long reportPersonId,
      BigDecimal perforateQuantity
   ) {
      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         if (taskProcess.getSequence() == 0 && this.projectService.getProjectMode(taskProcess.getProjectId()).equals(ProjectModeEnum.STANDARD_MODE.getType())) {
            TechAssemble assemble = this.assembleService.getById(taskProcess.getProductId());
            Preconditions.checkArgument(assemble != null, "操作失败，找不到对应组立");
            List<TechAssembleMachinePartLink> assembleMachinePartLinks = this.assembleMachinePartLinkService
               .list((Wrapper<TechAssembleMachinePartLink>)Wrappers.<TechAssembleMachinePartLink>lambdaQuery().eq(TechAssembleMachinePartLink::getAssembleId, assemble.getId()));
            if (CollectionUtils.isNotEmpty(assembleMachinePartLinks)) {
               List<Long> partIds = assembleMachinePartLinks.stream().map(TechAssembleMachinePartLink::getMachinePartId).collect(Collectors.toList());
               List<TechMachinePart> machineParts = this.machinePartService.listByIds(partIds);
               Map<Long, TechMachinePart> partMap = machineParts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
               assembleMachinePartLinks.forEach(
                  e -> {
                     TechMachinePart machinePart = partMap.get(e.getMachinePartId());
                     Preconditions.checkArgument(machinePart != null, "操作失败，找不到对应零件");
                     if (!machinePart.getBoolProcess()) {
                        machinePart.setProducedQuantity(machinePart.getProducedQuantity() + e.getQuantity() * reportQuantity);
                     }

                     if (!machinePart.getBoolSendDirectly()) {
                        Preconditions.checkArgument(
                           machinePart.getProducedQuantity() - machinePart.getUsedQuantity() >= reportQuantity * e.getQuantity(),
                           "操作失败，零件" + machinePart.getSerialNumber() + "数量不足"
                        );
                     }

                     machinePart.setUsedQuantity(machinePart.getUsedQuantity() + reportQuantity * e.getQuantity());
                  }
               );
               this.machinePartService.updateBatchById(new ArrayList<>(partMap.values()));
            }

            this.updateQuantity(taskProcess.getTaskId(), reportQuantity);
         }

         numberList = this.productProduceTeamReportV3(
            taskProcess, reportQuantity, assistLineId, teamId, reportType, numberList, assist, nextProcessId, reportPersonId, perforateQuantity
         );
      }

      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         TechArtifact artifact = this.artifactService.getById(taskProcess.getProductId());
         Preconditions.checkArgument(artifact != null, "操作失败，找不到对应构件");
         if (taskProcess.getSequence() == 0) {
            if (this.projectService.getProjectMode(taskProcess.getProjectId()).equals(ProjectModeEnum.STANDARD_MODE.getType())) {
               List<TechAssembleDetail> assembleDetails = this.assembleDetailService
                  .list((Wrapper<TechAssembleDetail>)Wrappers.<TechAssembleDetail>lambdaQuery().eq(TechAssembleDetail::getArtifactId, artifact.getId()));
               if (!assembleDetails.isEmpty()) {
                  List<Long> assIds = assembleDetails.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList());
                  List<TechAssemble> assembleList = this.assembleService.listByIds(assIds);
                  Map<Long, TechAssemble> assembleMap = assembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
                  assembleDetails.forEach(
                     e -> {
                        TechAssemble assemble = assembleMap.get(e.getAssembleId());
                        Preconditions.checkArgument(assemble != null, "操作失败，找不到对应组立");
                        if (!assemble.getBoolSendDirectly()) {
                           Preconditions.checkArgument(
                              assemble.getProducedQuantity() - assemble.getUsedQuantity() >= reportQuantity * e.getQuantity(), "操作失败，对应组立数量不足"
                           );
                        }

                        assemble.setUsedQuantity(assemble.getUsedQuantity() + reportQuantity * e.getQuantity());
                     }
                  );
                  this.assembleService.updateBatchById(new ArrayList<>(assembleMap.values()));
               }

               if (this.projectService.getProjectMode(taskProcess.getProjectId()).equals(ProjectModeEnum.STANDARD_MODE.getType())) {
                  List<TechArtifactMachinePartLink> artifactMachinePartLinkList = this.artifactMachinePartLinkService
                     .list((Wrapper<TechArtifactMachinePartLink>)Wrappers.<TechArtifactMachinePartLink>lambdaQuery().eq(TechArtifactMachinePartLink::getArtifactId, artifact.getId()));
                  if (CollectionUtils.isNotEmpty(artifactMachinePartLinkList)) {
                     List<Long> partIds = artifactMachinePartLinkList.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList());
                     List<TechMachinePart> machineParts = this.machinePartService.listByIds(partIds);
                     Map<Long, TechMachinePart> partMap = machineParts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
                     artifactMachinePartLinkList.forEach(
                        e -> {
                           TechMachinePart machinePart = partMap.get(e.getMachinePartId());
                           Preconditions.checkArgument(machinePart != null, "操作失败，找不到对应零件");
                           if (!machinePart.getRelationType().equals(18) && machinePart.getRelationType().equals(TaskTypeEnum.ARTIFACT.getType())) {
                              if (!machinePart.getBoolSendDirectly()) {
                                 Preconditions.checkArgument(
                                    machinePart.getProducedQuantity() - machinePart.getUsedQuantity() >= reportQuantity * e.getQuantity(),
                                    "操作失败，零件" + machinePart.getSerialNumber() + "数量不足"
                                 );
                              }

                              machinePart.setUsedQuantity(machinePart.getUsedQuantity() + reportQuantity * e.getQuantity());
                           }
                        }
                     );
                     this.machinePartService.updateBatchById(new ArrayList<>(partMap.values()));
                  }
               }
            }

            this.updateQuantity(taskProcess.getTaskId(), reportQuantity);
         }

         numberList = this.productProduceTeamReportV3(
            taskProcess, reportQuantity, assistLineId, teamId, reportType, numberList, assist, nextProcessId, reportPersonId, null
         );
      }

      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType())) {
         if (taskProcess.getSequence() == 0) {
            this.updateQuantity(taskProcess.getTaskId(), reportQuantity);
         }

         this.productProduceTeamReportV3(taskProcess, reportQuantity, assistLineId, teamId, reportType, numberList, assist, nextProcessId, reportPersonId, null);
      }

      return numberList;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public List<Integer> saveProduceTeamReport2(MesBuildingProduceTeamReportDTOParam dtoParam) {
      dtoParam.setReportType(dtoParam.getReportType() != null ? dtoParam.getReportType() : false);
      dtoParam.setBoolAssistEnum(dtoParam.getBoolAssistEnum() != null ? dtoParam.getBoolAssistEnum() : Boolean.FALSE);
      if (CollectionUtils.isEmpty(dtoParam.getNumberList())) {
         List<Integer> numberList = this.mesBuildingCalcMaxNumManager
            .getNumberList(dtoParam.getId(), dtoParam.getBoolAssistEnum(), dtoParam.getAssistLineId(), dtoParam.getReportQuantity());
         dtoParam.setNumberList(CollectionUtils.isNotEmpty(numberList) ? numberList : Collections.emptyList());
      }

      Preconditions.checkArgument(dtoParam.getReportQuantity().intValue() > 0L, "上报数不能小于零");
      MesBuildingTaskProcess mesBuildingTaskProcess = this.taskProcessService.getById(dtoParam.getId());
      Preconditions.checkArgument(mesBuildingTaskProcess != null, "任务不存在，请刷新页面重试");
      this.taskBiz.checkProductStatus(Collections.singletonList(mesBuildingTaskProcess.getProductId()), mesBuildingTaskProcess.getTaskTypeEnum());
      MesBuildingAssist assist = null;
      Long teamId;
      if (dtoParam.getBoolAssistEnum()) {
         assist = this.assistBiz
            .getOne(
               Wrappers.lambdaQuery(MesBuildingAssist.class)
                  .eq(MesBuildingAssist::getTaskProcessId, dtoParam.getId())
                  .eq(MesBuildingAssist::getProductionLineId, dtoParam.getAssistLineId())
                  .eq(MesBuildingAssist::getBoolFinishEnum, false)
            );
         Preconditions.checkArgument(assist != null, "上报失败请刷新后重试!!!");
         teamId = this.handleAssistReport(dtoParam, mesBuildingTaskProcess, assist);
      } else {
         teamId = this.handleNormalReport(dtoParam, mesBuildingTaskProcess);
      }

      dtoParam.setTeamId(teamId);
      if (mesBuildingTaskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         TechArtifact artifact = this.artifactService.getById(mesBuildingTaskProcess.getProductId());
         Preconditions.checkArgument(artifact.getBoolStatusEnum(), "操作失败：该构件已暂停生产!");
      }

      Preconditions.checkArgument(
         mesBuildingTaskProcess.getNeedQuantity() >= mesBuildingTaskProcess.getCompleteQuantity() + dtoParam.getReportQuantity(), "上报失败，超出可生产数量"
      );
      return this.checkProductAndProduceTeamReport2(
         mesBuildingTaskProcess,
         dtoParam.getReportQuantity(),
         dtoParam.getAssistLineId(),
         dtoParam.getTeamId(),
         dtoParam.getReportType(),
         dtoParam.getNumberList(),
         assist,
         dtoParam.getNextProcessId()
      );
   }

   private Long handleAssistReport(MesBuildingProduceTeamReportDTOParam dtoParam, MesBuildingTaskProcess mesBuildingTaskProcess, MesBuildingAssist assist) {
      Preconditions.checkArgument(assist != null, "上报失败请刷新后重试!!!");
      assist.setProduceQuantity(assist.getProduceQuantity() + dtoParam.getReportQuantity());
      Preconditions.checkArgument(assist.getQuantity() >= assist.getProduceQuantity(), "操作失败,请刷新后重试!!!");
      assist.setBoolFinishEnum(assist.getQuantity().equals(assist.getProduceQuantity()));
      this.mesBuildingAssistBiz.updateById(assist);
      List<MesBuildingTeamUserLink> teamUserLinks = this.teamUserLinkService
         .list((Wrapper<MesBuildingTeamUserLink>)Wrappers.<MesBuildingTeamUserLink>lambdaQuery().eq(MesBuildingTeamUserLink::getUserId, UserUtil.getCurrentUserId()));
      Preconditions.checkArgument(!teamUserLinks.isEmpty(), "操作失败：你不在可以生产上报的班组内");
      Set<Long> userTeamIds = teamUserLinks.stream().map(MesBuildingTeamUserLink::getTeamId).collect(Collectors.toSet());
      Map<Long, MesBuildingTeam> teamMap = this.teamService
         .list(
            Wrappers.lambdaQuery(MesBuildingTeam.class)
               .eq(MesBuildingTeam::getProcessId, mesBuildingTaskProcess.getProcessId())
               .eq(MesBuildingTeam::getProductionLineId, assist.getProductionLineId())
               .eq(MesBuildingTeam::getTeamStatus, 1)
               .in(MesBuildingTeam::getId, userTeamIds)
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingTeam::getId, Function.identity()));
      Preconditions.checkArgument(teamMap.containsKey(assist.getTeamId()), "操作失败：你不在可以生产上报的班组内");
      MesBuildingTeam team = teamMap.get(assist.getTeamId());
      MesBuildingTeam linesTeamLink = this.teamService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingTeam.class)
               .eq(MesBuildingTeam::getProductionLineId, dtoParam.getAssistLineId())
               .eq(MesBuildingTeam::getId, team.getId())
         );
      Preconditions.checkArgument(linesTeamLink != null, "操作失败：你不在可以生产上报的班组内");
      Preconditions.checkArgument(assist.getQuantity() >= dtoParam.getReportQuantity(), "操作失败：请刷新后重试!!");
      return linesTeamLink.getId();
   }

   private Long handleNormalReport(MesBuildingProduceTeamReportDTOParam dtoParam, MesBuildingTaskProcess mesBuildingTaskProcess) {
      List<MesBuildingAssist> assistList = this.assistBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingAssist.class)
               .eq(MesBuildingAssist::getTaskProcessId, dtoParam.getId())
               .eq(MesBuildingAssist::getBoolFinishEnum, false)
         );
      Integer assquantity = this.getAssistQuantity(assistList, mesBuildingTaskProcess.getTaskTypeEnum());
      Preconditions.checkArgument(
         dtoParam.getReportQuantity() <= mesBuildingTaskProcess.getNeedQuantity() - mesBuildingTaskProcess.getCompleteQuantity() - assquantity, "操作失败：请刷新后重试!!"
      );
      return mesBuildingTaskProcess.getProductionLineId() != null
         ? this.handleNormalReportWithProductionLine(dtoParam, mesBuildingTaskProcess)
         : this.handleNormalReportWithoutProductionLine(dtoParam, mesBuildingTaskProcess);
   }

   private Long handleNormalReportWithProductionLine(MesBuildingProduceTeamReportDTOParam dtoParam, MesBuildingTaskProcess mesBuildingTaskProcess) {
      List<MesBuildingTeamUserLink> teamUserLinks = this.teamUserLinkService
         .list((Wrapper<MesBuildingTeamUserLink>)Wrappers.<MesBuildingTeamUserLink>lambdaQuery().eq(MesBuildingTeamUserLink::getUserId, UserUtil.getCurrentUserId()));
      Preconditions.checkArgument(!teamUserLinks.isEmpty(), "操作失败：你不在可以生产上报的班组内");
      Set<Long> userTeamIds = teamUserLinks.stream().map(MesBuildingTeamUserLink::getTeamId).collect(Collectors.toSet());
      Map<Long, MesBuildingTeam> teamMap = this.teamService
         .list(
            Wrappers.lambdaQuery(MesBuildingTeam.class)
               .eq(MesBuildingTeam::getProcessId, mesBuildingTaskProcess.getProcessId())
               .eq(MesBuildingTeam::getProductionLineId, mesBuildingTaskProcess.getProductionLineId())
               .eq(MesBuildingTeam::getTeamStatus, 1)
               .in(MesBuildingTeam::getId, userTeamIds)
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingTeam::getId, Function.identity()));
      Preconditions.checkArgument(teamMap.containsKey(mesBuildingTaskProcess.getTeamId()), "操作失败：你不在可以生产上报的班组内");
      MesBuildingTeam team = teamMap.get(mesBuildingTaskProcess.getTeamId());
      Preconditions.checkArgument(!Objects.equals(team.getProductionLineId(), dtoParam.getAssistLineId()), "操作失败：你不在可以生产上报的班组内!!");
      return team.getId();
   }

   private Long handleNormalReportWithoutProductionLine(MesBuildingProduceTeamReportDTOParam dtoParam, MesBuildingTaskProcess mesBuildingTaskProcess) {
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      List<Long> drillProcessIdList = this.processService
         .list(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType())
               .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
         )
         .stream()
         .map(MesBuildingProcess::getId)
         .collect(Collectors.toList());
      Long teamId;
      if (drillProcessIdList.contains(mesBuildingTaskProcess.getProcessId())) {
         teamId = teamList.stream()
            .filter(e -> drillProcessIdList.contains(e.getProcessId()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("操作失败：你不在可以生产上报的班组内"))
            .getId();
         this.updateTaskProcessWithProductionLineInfo(mesBuildingTaskProcess, teamId);
      } else {
         List<Long> teamIdList = this.teamService
            .list(
               Wrappers.lambdaQuery(MesBuildingTeam.class)
                  .eq(MesBuildingTeam::getProductionLineId, mesBuildingTaskProcess.getProductionLineId())
                  .eq(MesBuildingTeam::getTeamStatus, 1)
            )
            .stream()
            .map(MesBuildingTeam::getId)
            .collect(Collectors.toList());
         Preconditions.checkArgument(!teamIdList.isEmpty(), "操作失败：你不在可以生产上报的班组内");
         teamId = this.teamService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingTeam.class)
                  .in(MesBuildingTeam::getId, teamIdList)
                  .eq(MesBuildingTeam::getProcessId, mesBuildingTaskProcess.getProcessId())
                  .eq(MesBuildingTeam::getTeamStatus, 1)
            )
            .getId();
      }

      return teamId;
   }

   private void updateTaskProcessWithProductionLineInfo(MesBuildingTaskProcess mesBuildingTaskProcess, Long teamId) {
      MesBuildingTeam team = this.teamService
         .getOne(Wrappers.lambdaQuery(MesBuildingTeam.class).eq(MesBuildingTeam::getId, teamId).eq(MesBuildingTeam::getTeamStatus, 1));
      MesBuildingProductionLine lines = this.productionLineService.getById(team.getProductionLineId());
      mesBuildingTaskProcess.setFactoryId(lines.getFactoryId());
      mesBuildingTaskProcess.setWorkshopId(lines.getWorkshopId());
      mesBuildingTaskProcess.setProductionLineId(lines.getId());
   }

   @Override
   public List<Integer> manualReportSaveProduceTeamReport(MesBuildingProduceTeamReportDTOParam dtoParam) {
      if (dtoParam.getReportType() == null) {
         dtoParam.setReportType(false);
      }

      if (dtoParam.getBoolAssistEnum() == null) {
         dtoParam.setBoolAssistEnum(Boolean.FALSE);
      }

      if (CollectionUtils.isEmpty(dtoParam.getNumberList())) {
         List<Integer> numberList = this.mesBuildingCalcMaxNumManager
            .getNumberListV2(dtoParam.getId(), dtoParam.getBoolAssistEnum(), dtoParam.getAssistLineId(), dtoParam.getReportQuantity());
         if (CollectionUtils.isNotEmpty(numberList)) {
            dtoParam.setNumberList(numberList);
         }
      }

      Preconditions.checkArgument(dtoParam.getReportQuantity().intValue() > 0L, "上报数不能小于零");
      MesBuildingTaskProcess mesBuildingTaskProcess = this.taskProcessService.getById(dtoParam.getId());
      Preconditions.checkArgument(mesBuildingTaskProcess != null, "任务不存在，请刷新页面重试");
      this.taskBiz.checkProductStatus(Collections.singletonList(mesBuildingTaskProcess.getProductId()), mesBuildingTaskProcess.getTaskTypeEnum());
      MesBuildingAssist assist = null;
      Long teamId;
      if (dtoParam.getBoolAssistEnum()) {
         assist = this.assistBiz
            .getOne(
               Wrappers.lambdaQuery(MesBuildingAssist.class)
                  .eq(MesBuildingAssist::getTaskProcessId, dtoParam.getId())
                  .eq(MesBuildingAssist::getProductionLineId, dtoParam.getAssistLineId())
                  .eq(MesBuildingAssist::getBoolFinishEnum, false)
            );
         Preconditions.checkArgument(assist != null, "上报失败请刷新后重试!!!");
         Long processId = assist.getProcessId();
         assist.setProduceQuantity(assist.getProduceQuantity() + dtoParam.getReportQuantity());
         Preconditions.checkArgument(assist.getQuantity() >= assist.getProduceQuantity(), "操作失败,请刷新后重试!!!");
         assist.setBoolFinishEnum(assist.getQuantity().equals(assist.getProduceQuantity()));
         this.mesBuildingAssistBiz.updateById(assist);
         List<MesBuildingTeamUserLink> teamUserLinks = this.teamUserLinkService
            .list((Wrapper<MesBuildingTeamUserLink>)Wrappers.<MesBuildingTeamUserLink>lambdaQuery().eq(MesBuildingTeamUserLink::getUserId, dtoParam.getReportPersonId()));
         Preconditions.checkArgument(!teamUserLinks.isEmpty(), "操作失败：你不在可以生产上报的班组内");
         Map<Long, MesBuildingTeam> teamMap = this.teamService
            .list(
               Wrappers.lambdaQuery(MesBuildingTeam.class)
                  .eq(MesBuildingTeam::getProcessId, mesBuildingTaskProcess.getProcessId())
                  .eq(MesBuildingTeam::getProductionLineId, assist.getProductionLineId())
                  .eq(MesBuildingTeam::getTeamStatus, 1)
                  .in(MesBuildingTeam::getId, teamUserLinks.stream().map(MesBuildingTeamUserLink::getTeamId).collect(Collectors.toList()))
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingTeam::getId, Function.identity()));
         Preconditions.checkArgument(teamMap.containsKey(assist.getTeamId()), "操作失败：你不在可以生产上报的班组内");
         MesBuildingTeam team = teamMap.get(assist.getTeamId());
         MesBuildingTeam linesTeamLink = this.teamService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingTeam.class)
                  .eq(MesBuildingTeam::getProductionLineId, dtoParam.getAssistLineId())
                  .eq(MesBuildingTeam::getId, team.getId())
            );
         Preconditions.checkArgument(linesTeamLink != null, "操作失败：你不在可以生产上报的班组内");
         Preconditions.checkArgument(assist.getQuantity() >= dtoParam.getReportQuantity(), "操作失败：请刷新后重试!!");
         teamId = linesTeamLink.getId();
      } else {
         List<MesBuildingAssist> assistList = this.assistBiz
            .list(
               Wrappers.lambdaQuery(MesBuildingAssist.class)
                  .eq(MesBuildingAssist::getTaskProcessId, dtoParam.getId())
                  .eq(MesBuildingAssist::getBoolFinishEnum, false)
            );
         Integer assquantity = this.getAssistQuantity(assistList, mesBuildingTaskProcess.getTaskTypeEnum());
         Preconditions.checkArgument(
            dtoParam.getReportQuantity() <= mesBuildingTaskProcess.getNeedQuantity() - mesBuildingTaskProcess.getCompleteQuantity() - assquantity,
            "操作失败：请刷新后重试!!"
         );
         if (mesBuildingTaskProcess.getProductionLineId() != null) {
            List<MesBuildingTeamUserLink> teamUserLinks = this.teamUserLinkService
               .list((Wrapper<MesBuildingTeamUserLink>)Wrappers.<MesBuildingTeamUserLink>lambdaQuery().eq(MesBuildingTeamUserLink::getUserId, dtoParam.getReportPersonId()));
            Preconditions.checkArgument(!teamUserLinks.isEmpty(), "操作失败：你不在可以生产上报的班组内");
            Map<Long, MesBuildingTeam> teamMap = this.teamService
               .list(
                  Wrappers.lambdaQuery(MesBuildingTeam.class)
                     .eq(MesBuildingTeam::getProcessId, mesBuildingTaskProcess.getProcessId())
                     .eq(MesBuildingTeam::getProductionLineId, mesBuildingTaskProcess.getProductionLineId())
                     .eq(MesBuildingTeam::getTeamStatus, 1)
                     .in(MesBuildingTeam::getId, teamUserLinks.stream().map(MesBuildingTeamUserLink::getTeamId).collect(Collectors.toList()))
               )
               .stream()
               .collect(Collectors.toMap(MesBuildingTeam::getId, Function.identity()));
            Preconditions.checkArgument(teamMap.containsKey(mesBuildingTaskProcess.getTeamId()), "操作失败：你不在可以生产上报的班组内");
            MesBuildingTeam team = teamMap.get(mesBuildingTaskProcess.getTeamId());
            Preconditions.checkArgument(!Objects.equals(team.getProductionLineId(), dtoParam.getAssistLineId()), "操作失败：你不在可以生产上报的班组内!!");
            teamId = team.getId();
         } else {
            List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(dtoParam.getReportPersonId());
            List<Long> drillProcessIdList = this.processService
               .list(
                  Wrappers.lambdaQuery(MesBuildingProcess.class)
                     .eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType())
                     .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
               )
               .stream()
               .map(MesBuildingProcess::getId)
               .collect(Collectors.toList());
            if (drillProcessIdList.contains(mesBuildingTaskProcess.getProcessId())) {
               teamId = teamList.stream().filter(e -> drillProcessIdList.contains(e.getProcessId())).findFirst().get().getId();
            } else {
               List<Long> teamIdList = this.teamService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingTeam.class)
                        .eq(MesBuildingTeam::getProductionLineId, mesBuildingTaskProcess.getProductionLineId())
                        .eq(MesBuildingTeam::getTeamStatus, 1)
                  )
                  .stream()
                  .map(MesBuildingTeam::getId)
                  .collect(Collectors.toList());
               Preconditions.checkArgument(!teamIdList.isEmpty(), "操作失败：你不在可以生产上报的班组内");
               teamId = this.teamService
                  .getOne(
                     Wrappers.lambdaQuery(MesBuildingTeam.class)
                        .in(MesBuildingTeam::getId, teamIdList)
                        .eq(MesBuildingTeam::getProcessId, mesBuildingTaskProcess.getProcessId())
                        .eq(MesBuildingTeam::getTeamStatus, 1)
                  )
                  .getId();
            }

            if (drillProcessIdList.contains(mesBuildingTaskProcess.getProcessId())) {
               MesBuildingProductionLine lines = this.productionLineService
                  .getById(
                     this.teamService
                        .getOne(Wrappers.lambdaQuery(MesBuildingTeam.class).eq(MesBuildingTeam::getId, teamId).eq(MesBuildingTeam::getTeamStatus, 1))
                        .getProductionLineId()
                  );
               mesBuildingTaskProcess.setFactoryId(lines.getFactoryId());
               mesBuildingTaskProcess.setWorkshopId(lines.getWorkshopId());
               mesBuildingTaskProcess.setProductionLineId(lines.getId());
            }
         }
      }

      dtoParam.setTeamId(teamId);
      if (mesBuildingTaskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         TechArtifact artifact = this.artifactService.getById(mesBuildingTaskProcess.getProductId());
         Preconditions.checkArgument(artifact.getBoolStatusEnum(), "操作失败：该构件已暂停生产!");
      }

      Preconditions.checkArgument(
         mesBuildingTaskProcess.getNeedQuantity() >= mesBuildingTaskProcess.getCompleteQuantity() + dtoParam.getReportQuantity(), "上报失败，超出可生产数量"
      );
      return this.checkProductAndProduceTeamReportV3(
         mesBuildingTaskProcess,
         dtoParam.getReportQuantity(),
         dtoParam.getAssistLineId(),
         dtoParam.getTeamId(),
         dtoParam.getReportType(),
         dtoParam.getNumberList(),
         assist,
         dtoParam.getNextProcessId(),
         dtoParam.getReportPersonId(),
         dtoParam.getPerforateQuantity()
      );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public List<BatchPrintDTO> saveProduceTeamBatchReport(List<BatchReportDTO> dtos) {
      ArrayList<AppTaskProcessDetailsDTO> arrayList = new ArrayList<>();
      List<MesBuildingTaskProcess> taskProcessList = this.taskProcessService.listByIds(dtos.stream().map(BatchReportDTO::getId).collect(Collectors.toList()));
      Map<Long, List<MesBuildingTaskNumberLink>> assembleTaskNumberLinkMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(taskProcessList)) {
         MesBuildingTaskProcess taskProcess = taskProcessList.get(0);
         Preconditions.checkArgument(taskProcessList.stream().allMatch(e -> e.getTaskTypeEnum().equals(taskProcess.getTaskTypeEnum())));
         if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
            List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
               .list(
                  (Wrapper<TechAssembleDetail>)new LambdaQueryWrapper<TechAssembleDetail>()
                     .in(TechAssembleDetail::getArtifactId, taskProcessList.stream().map(MesBuildingTaskProcess::getProductId).collect(Collectors.toList()))
               );
            if (CollectionUtils.isNotEmpty(assembleDetailList)) {
               assembleTaskNumberLinkMap = this.mesBuildingTaskNumberLinkService
                  .list(
                     (Wrapper<MesBuildingTaskNumberLink>)(((((new LambdaQueryWrapper<MesBuildingTaskNumberLink>()
                                       .in(
                                          MesBuildingTaskNumberLink::getAssembleId,
                                          assembleDetailList.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList())
                                       ))
                                    .eq(MesBuildingTaskNumberLink::getBoolAssembleComplete, Boolean.TRUE))
                                 .eq(MesBuildingTaskNumberLink::getBoolArtifactInspection, Boolean.FALSE))
                              .eq(MesBuildingTaskNumberLink::getBoolArtifactInproduce, Boolean.FALSE))
                           .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, Boolean.FALSE))
                        .eq(MesBuildingTaskNumberLink::getBoolArtifactComplete, Boolean.FALSE)
                  )
                  .stream()
                  .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId));
            }
         }
      }

      Map<Long, List<MesBuildingTaskNumberLink>> finalAssembleTaskNumberLinkMap = assembleTaskNumberLinkMap;
      dtos.forEach(
         e -> {
            AppTaskProcessDetailsDTO appTaskProcessDetailsDTO = this.taskBiz
               .taskProcessDetails2(e.getId(), e.getBoolAssist(), e.getAssistLineId(), finalAssembleTaskNumberLinkMap);
            if (appTaskProcessDetailsDTO.getProducibleQuantity() > 0) {
               arrayList.add(appTaskProcessDetailsDTO);
            }
         }
      );
      List<BatchPrintDTO> printDTOs = new ArrayList<>();
      arrayList.forEach(s -> {
         MesBuildingProduceTeamReportDTOParam param = new MesBuildingProduceTeamReportDTOParam();
         if (s.getCodingType().equals(CodingTypeEnum.SINGLE.getType())) {
            param.setNumberList(s.getArtifactNumberList().stream().map(e -> e.getNumber()).collect(Collectors.toList()));
         }

         param.setId(s.getId());
         param.setReportQuantity(s.getProducibleQuantity());
         param.setAssistLineId(s.getAssistProductionLine() != null ? s.getAssistProductionLine().getId() : null);
         param.setBoolAssistEnum(s.getAssistProductionLine() != null);
         List<Integer> numberList = this.saveProduceTeamReport2(param);
         BatchPrintDTO build = BatchPrintDTO.builder().taskId(s.getTaskId()).taskProcessId(param.getId()).numberList(numberList).build();
         printDTOs.add(build);
      });
      return printDTOs;
   }

   private Integer getAssistQuantity(List<MesBuildingAssist> assistBizs, Integer productType) {
      if (CollectionUtil.isEmpty(assistBizs)) {
         return 0;
      }

      List<Long> assistIds = assistBizs.stream().map(MesBuildingAssist::getId).collect(Collectors.toList());
      List<MesBuildingAssistNumberDetail> assistNumberDetails = this.mesBuildingAssistNumberDetailService
         .list(
            (Wrapper<MesBuildingAssistNumberDetail>)(new LambdaQueryWrapper<MesBuildingAssistNumberDetail>().in(MesBuildingAssistNumberDetail::getAssistId, assistIds))
               .eq(MesBuildingAssistNumberDetail::getBoolFinishEnum, Boolean.FALSE)
         );
      if (CollectionUtil.isEmpty(assistNumberDetails)) {
         return 0;
      }

      Map<Long, List<Integer>> assistNumberDetailMap = assistNumberDetails.stream()
         .collect(
            Collectors.groupingBy(
               MesBuildingAssistNumberDetail::getTaskProcessId, Collectors.mapping(MesBuildingAssistNumberDetail::getNumber, Collectors.toList())
            )
         );
      LambdaQueryWrapper<MesBuildingTaskNumberLink> taskNumberQueryWrapper = Wrappers.<MesBuildingTaskNumberLink>lambdaQuery();
      boolean hasConditions = false;
      if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         for (Entry<Long, List<Integer>> entry : assistNumberDetailMap.entrySet()) {
            if (!hasConditions) {
               taskNumberQueryWrapper.eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, entry.getKey())
                  .in(MesBuildingTaskNumberLink::getArtifactNumber, entry.getValue());
               hasConditions = true;
            } else {
               taskNumberQueryWrapper.or(
                  subQuery -> {
                     LambdaQueryWrapper var10000 = subQuery.eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, entry.getKey())
                        .in(MesBuildingTaskNumberLink::getArtifactNumber, entry.getValue());
                  }
               );
            }
         }

         if (hasConditions) {
            List<MesBuildingTaskNumberLink> taskNumberLinks = this.taskNumberLinkService.list(taskNumberQueryWrapper);
            return taskNumberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).collect(Collectors.toSet()).size();
         }
      } else if (ProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
         for (Entry<Long, List<Integer>> entry : assistNumberDetailMap.entrySet()) {
            if (!hasConditions) {
               taskNumberQueryWrapper.eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, entry.getKey())
                  .in(MesBuildingTaskNumberLink::getAssembleNumber, entry.getValue());
               hasConditions = true;
            } else {
               taskNumberQueryWrapper.or(
                  subQuery -> {
                     LambdaQueryWrapper var10000 = subQuery.eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, entry.getKey())
                        .in(MesBuildingTaskNumberLink::getAssembleNumber, entry.getValue());
                  }
               );
            }
         }

         if (hasConditions) {
            List<MesBuildingTaskNumberLink> taskNumberLinks = this.taskNumberLinkService.list(taskNumberQueryWrapper);
            return taskNumberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).collect(Collectors.toSet()).size();
         }
      }

      return 0;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean addPartTaskProcess2(MesBuildingTask task, MesBuildingProductionLine prodLines, LocalDateTime drillAskCompleteTime) {
      List<MesBuildingProcess> processList = this.utilsBiz.getProcessIdByProductProcessId(task.getProductProcessId());
      Map<Long, LocalDateTime> taskProcessTimeMap = this.utilsBiz.getTaskProcessTime(task.getProductProcessId(), task.getAskCompleteTime());
      MesBuildingProcess makingsProcess = this.processService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
               .eq(MesBuildingProcess::getType, ProcessTypeEnum.MAKINGS.getType())
         );
      MesBuildingProcess drillProcess = this.processService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
               .eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType())
         );
      MesBuildingTaskProcess taskProcess = com.hzchum.pangu.common.util.BeanUtil.copy(task, MesBuildingTaskProcess.class);
      taskProcess.setTaskId(task.getId());
      taskProcess.setProductProcessId(task.getProductProcessId());
      taskProcess.setNeedQuantity(taskProcess.getTaskQuantity());
      taskProcess.setId(null);
      taskProcess.setCompleteQuantity(null);
      taskProcess.setProcessId(makingsProcess.getId());
      taskProcess.setAskCompleteTime(taskProcessTimeMap.get(taskProcess.getProcessId()));
      taskProcess.setSequence(0);
      this.taskProcessService.save(taskProcess);
      MesBuildingMachinePartScheduling partScheduling = this.machinePartSchedulingService.getById(task.getMachinePartSchedulingId());
      Preconditions.checkArgument(partScheduling != null, "操作失败，零件排产记录不存在");
      if (processList.stream().anyMatch(e -> e.getType().equals(ProcessTypeEnum.DRILL_HOLE.getType()))
         && this.cutConfigBiz.getBoolDrillHole(task.getProductId(), partScheduling.getCutConfigId(), partScheduling.getThick())) {
         taskProcess.setNextProcessId(drillProcess.getId());
         this.taskProcessService.updateById(taskProcess);
         MesBuildingTaskProcess drillTaskProcess = com.hzchum.pangu.common.util.BeanUtil.copy(task, MesBuildingTaskProcess.class);
         drillTaskProcess.setTaskId(task.getId());
         drillTaskProcess.setProductProcessId(task.getProductProcessId());
         drillTaskProcess.setNeedQuantity(0);
         drillTaskProcess.setId(null);
         drillTaskProcess.setCompleteQuantity(null);
         drillTaskProcess.setFactoryId(prodLines.getFactoryId());
         drillTaskProcess.setWorkshopId(prodLines.getWorkshopId());
         drillTaskProcess.setProductionLineId(prodLines.getId());
         drillTaskProcess.setProcessId(drillProcess.getId());
         drillTaskProcess.setAskCompleteTime(drillAskCompleteTime == null ? taskProcessTimeMap.get(taskProcess.getProcessId()) : drillAskCompleteTime);
         drillTaskProcess.setSequence(taskProcess.getSequence() + 1);
         this.taskProcessService.save(drillTaskProcess);
      }

      return true;
   }

   @Override
   public List<ProductClassificationDTO> productTypeByTaskOrderId2(Integer taskTypeEnum, Long taskOrderId, Integer boolLastProcessEnum) {
      MesBuildingTaskOrder taskOrder = this.taskOrderBiz.getById(taskOrderId);
      Preconditions.checkArgument(taskOrder != null, "操作失败：id有误!");
      List<Long> teamIdLinkList = this.teamService
         .list(Wrappers.lambdaQuery(MesBuildingTeam.class).eq(MesBuildingTeam::getProductionLineId, taskOrder.getProductionLineId()))
         .stream()
         .map(MesBuildingTeam::getId)
         .collect(Collectors.toList());
      if (teamIdLinkList.size() == 0) {
         return new ArrayList<>();
      }

      List<MesBuildingTeam> teamList = this.utilsBiz
         .selectTeamIdByUserId(UserUtil.getCurrentUserId())
         .stream()
         .filter(e -> teamIdLinkList.contains(e.getId()))
         .collect(Collectors.toList());
      List<MesBuildingTask> taskList = this.baseService.list(Wrappers.lambdaQuery(MesBuildingTask.class).eq(MesBuildingTask::getTaskOrderId, taskOrderId));
      List<MesBuildingAssist> assistList = this.assistBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingAssist.class)
               .in(MesBuildingAssist::getTaskId, taskList.stream().map(MesBuildingTask::getId).collect(Collectors.toList()))
         );
      List<MesBuildingTeam> assistTeamIdLinkList = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(assistList)) {
         assistTeamIdLinkList = this.teamService
            .list(
               Wrappers.lambdaQuery(MesBuildingTeam.class)
                  .in(MesBuildingTeam::getProductionLineId, assistList.stream().map(e -> e.getProductionLineId()).distinct().collect(Collectors.toList()))
            )
            .stream()
            .collect(Collectors.toList());
      }

      teamList.addAll(assistTeamIdLinkList);
      if (teamList.size() == 0) {
         return new ArrayList<>();
      }

      List<Long> lines = teamList.stream().map(MesBuildingTeam::getProductionLineId).distinct().collect(Collectors.toList());
      lines.add(taskOrder.getProductionLineId());
      return this.taskProcessService
         .productTypeByTaskOrderId2(
            teamList.stream().map(MesBuildingTeam::getProcessId).collect(Collectors.toList()), lines, taskTypeEnum, taskOrderId, boolLastProcessEnum
         );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveProduceInspection2(List<InspectionReportSavedDTO> inspectData) {
      List<Long> reportNumberIds = new ArrayList<>(inspectData.size());
      int allReportQuantity = 0;

      for (InspectionReportSavedDTO dto : inspectData) {
         reportNumberIds.add(dto.getReportNumberId());
         allReportQuantity += dto.getReportQuantity();
      }

      List<MesBuildingProduceTeamReport> allReports = this.produceTeamReportService
         .list(
            Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class)
               .in(MesBuildingProduceTeamReport::getReportNumber, reportNumberIds)
               .apply("problem_quantity + inspection_quantity = 0")
         );
      Map<Long, List<MesBuildingProduceTeamReport>> allReportMap = allReports.stream()
         .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getReportNumber));
      Preconditions.checkArgument(allReportMap.keySet().size() == reportNumberIds.size(), "操作失败!!请刷新页面后重试!!!!");
      List<Long> taskProcessIds = allReports.stream().map(MesBuildingProduceTeamReport::getTaskProcessId).distinct().collect(Collectors.toList());
      Preconditions.checkArgument(taskProcessIds.size() == 1, "数据校验失败!!!!");
      MesBuildingTaskProcess taskProcess = this.taskProcessService.getById(taskProcessIds.get(0));
      MesBuildingTask task = this.baseService.getById(taskProcess.getTaskId());
      this.taskBiz.checkProductStatus(Arrays.asList(taskProcess.getProductId()), taskProcess.getTaskTypeEnum());
      List<MesBuildingProduceInspectionTeamReport> inspectReports = new ArrayList<>();
      List<MesBuildingProduceTeamReport> needUpdateTeamReports = new ArrayList<>();
      MesBuildingProduceTeamReport firstReport = allReports.get(0);
      Long workshopId = firstReport.getWorkshopId();
      Preconditions.checkArgument(allReports.stream().allMatch(e -> e.getWorkshopId().equals(workshopId)), "操作失败,上报记录的车间不一致!");
      List<MesInspectConfig> inspectConfig = this.inspectConfigService
         .selectCurrentUserIsInspectUser(workshopId, taskProcess.getProcessId(), task.getClassificationId(), UserUtil.getCurrentUserId());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(inspectConfig), "上报失败,当前用户不是质检用户");
      taskProcess.setInspectionQuantity(taskProcess.getInspectionQuantity() + allReportQuantity);
      Preconditions.checkArgument(taskProcess.getCompleteQuantity() >= taskProcess.getInspectionQuantity() + taskProcess.getProblemQuantity(), "操作失败!!!");
      this.taskProcessService.updateById(taskProcess);
      HashMap<Long, Integer> savePriceMap = new HashMap<>();
      Long reportNumber = this.redisUtils.incr("inspection_reportnumber:", 1L);
      LocalDateTime currentTime = LocalDateTime.now();
      PaintThicknessDO paintThicknessConfig = this.configService.getPaintThicknessConfig();
      HashMap<String, List<PaintThicknessSaveDTO>> paintThicknessMap = new HashMap<>();

      for (InspectionReportSavedDTO dto : inspectData) {
         Preconditions.checkArgument(dto.getReportQuantity() > 0, "上报数不能小于零");
         List<MesBuildingProduceTeamReport> reports = allReportMap.get(dto.getReportNumberId());
         Preconditions.checkArgument(reports.size() >= dto.getReportQuantity(), "操作失败!!!!超出可质检数量!!!!");
         List<MesBuildingProduceTeamReport> needInspect = reports.stream().limit(dto.getReportQuantity().intValue()).collect(Collectors.toList());
         if (!TaskTypeEnum.ARTIFACT.getType().equals(taskProcess.getTaskTypeEnum()) && !TaskTypeEnum.ASSEMBLE.getType().equals(taskProcess.getTaskTypeEnum())) {
            Preconditions.checkArgument(false, "操作失败!!!!");
         } else {
            for (MesBuildingProduceTeamReport teamReport : needInspect) {
               Integer number = teamReport.getNumber();
               MesBuildingProduceInspectionTeamReport inspectionTeamReport = MesBuildingProduceInspectionTeamReport.builder()
                  .teamId(teamReport.getTeamId())
                  .productId(taskProcess.getProductId())
                  .taskTypeEnum(taskProcess.getTaskTypeEnum())
                  .processId(taskProcess.getProcessId())
                  .taskId(taskProcess.getTaskId())
                  .taskProcessId(taskProcess.getId())
                  .productionLineId(teamReport.getProductionLineId())
                  .inspectionQuantity(1)
                  .userId(UserUtil.getCurrentUserId())
                  .number(number)
                  .reportTime(currentTime)
                  .inspectReportTime(currentTime)
                  .inspectReportNumber(reportNumber)
                  .schedulingId(taskProcess.getSchedulingId())
                  .build();
               this.paintThicknessLinkService.buildInspectionPaintThicknessMap(paintThicknessMap, paintThicknessConfig, taskProcess, dto, inspectionTeamReport);
               inspectReports.add(inspectionTeamReport);
               savePriceMap.merge(teamReport.getId(), 1, Integer::sum);
               teamReport.setInspectionQuantity(teamReport.getInspectionQuantity() + 1);
               teamReport.setIsReversible(false);
               Preconditions.checkArgument(teamReport.getInspectionQuantity() + teamReport.getProblemQuantity() <= teamReport.getQuantity(), "操作失败!!请刷新页面!!!");
               needUpdateTeamReports.add(teamReport);
               if (task.getBoolOneCode()) {
                  reportNumber = this.redisUtils.incr("inspection_reportnumber:", 1L);
                  currentTime = LocalDateTime.now();
               }
            }
         }
      }

      this.produceInspectionTeamReportService.saveBatch(inspectReports);
      this.produceTeamReportService.updateBatchById(needUpdateTeamReports);
      this.teamReportBiz.savePiceByData(savePriceMap);
      List<MesBuildingProduceInspectionTeamReportPaintThicknessLink> paintThicknessLinks = this.paintThicknessLinkService
         .getPaintThicknessLinkSaveList(inspectReports, paintThicknessMap);
      this.paintThicknessLinkService.saveBatch(paintThicknessLinks);
      Map<String, Integer> reportSummaryMap = inspectReports.stream()
         .collect(
            Collectors.toMap(
               s -> s.getTaskProcessId() + "_" + s.getProductionLineId() + "_" + s.getTeamId(),
               MesBuildingProduceInspectionTeamReport::getInspectionQuantity,
               Integer::sum
            )
         );
      List<MesBuildingReportSummaryDTO> summaryDTOS = new ArrayList<>(reportSummaryMap.size());

      for (String key : reportSummaryMap.keySet()) {
         String[] split = key.split("_");
         summaryDTOS.add(
            MesBuildingReportSummaryDTO.builder()
               .taskProcessId(Long.valueOf(split[0]))
               .prodLineId(Long.valueOf(split[1]))
               .teamId(Long.valueOf(split[2]))
               .build()
         );
      }

      List<MesBuildingProduceTeamReportSummary> summaryList = this.produceTeamReportSummaryService.listReportSummarysByData(summaryDTOS);
      Map<String, MesBuildingProduceTeamReportSummary> summaryMap = summaryList.stream()
         .collect(Collectors.toMap(s -> s.getTaskProcessId() + "_" + s.getProductionLineId() + "_" + s.getTeamId(), Function.identity()));
      List<MesBuildingProduceTeamReportSummary> needUpdateSummarys = new ArrayList<>();

      for (Entry<String, MesBuildingProduceTeamReportSummary> entry : summaryMap.entrySet()) {
         String key = entry.getKey();
         MesBuildingProduceTeamReportSummary summary = entry.getValue();
         Integer inspectQuantity = reportSummaryMap.get(key);
         Preconditions.checkArgument(
            summary.getQuantity() >= summary.getProblemQuantity() + summary.getInspectionQuantity() + inspectQuantity, "操作失败!!请刷新页面后重试!!!!"
         );
         summary.setInspectionQuantity(summary.getInspectionQuantity() + inspectQuantity);
         needUpdateSummarys.add(summary);
      }

      this.produceTeamReportSummaryService.updateBatchById(needUpdateSummarys);
      List<Integer> inspectNumbers = inspectReports.stream().map(MesBuildingProduceInspectionTeamReport::getNumber).collect(Collectors.toList());
      if (TaskTypeEnum.ARTIFACT.getType().equals(taskProcess.getTaskTypeEnum())) {
         this.processNumberLinks(inspectNumbers, taskProcess, TaskTypeEnum.ARTIFACT);
      } else if (TaskTypeEnum.ASSEMBLE.getType().equals(taskProcess.getTaskTypeEnum())) {
         this.processNumberLinks(inspectNumbers, taskProcess, TaskTypeEnum.ASSEMBLE);
      } else {
         Preconditions.checkArgument(false, "产品类型不正确!!!");
      }

      List<TeamAndNumberDTO> teamAndNumberDTOS = BeanUtil.copyToList(inspectReports, TeamAndNumberDTO.class);
      this.taskBiz.updateNextTaskInspectionProcess(taskProcess, allReportQuantity, teamAndNumberDTOS);
      return true;
   }

   private void processNumberLinks(List<Integer> inspectNumbers, MesBuildingTaskProcess taskProcess, TaskTypeEnum taskType) {
      LambdaQueryWrapper<MesBuildingTaskNumberLink> queryWrapper = Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class);
      List<MesBuildingTaskNumberLink> numberLinks;
      List<Integer> linkNumbers;
      Function<MesBuildingTaskNumberLink, Long> nextProcessIdFunction;
      BiConsumer<MesBuildingTaskNumberLink, Long> taskProcessIdSetter;
      BiConsumer<MesBuildingTaskNumberLink, Boolean> reportStatusSetter;
      BiConsumer<MesBuildingTaskNumberLink, Boolean> inspectionStatusSetter;
      BiConsumer<MesBuildingTaskNumberLink, Boolean> completeStatusSetter;
      Function<MesBuildingTaskNumberLink, Long> taskIdGetter;
      if (TaskTypeEnum.ARTIFACT.equals(taskType)) {
         queryWrapper.eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, taskProcess.getId())
            .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, true)
            .in(MesBuildingTaskNumberLink::getArtifactNumber, inspectNumbers);
         numberLinks = this.mesBuildingTaskNumberLinkService.list(queryWrapper);
         linkNumbers = numberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().collect(Collectors.toList());
         nextProcessIdFunction = MesBuildingTaskNumberLink::getArtifactNextProcessId;
         taskProcessIdSetter = MesBuildingTaskNumberLink::setArtifactTaskProcessId;
         reportStatusSetter = MesBuildingTaskNumberLink::setBoolArtifactReport;
         inspectionStatusSetter = MesBuildingTaskNumberLink::setBoolArtifactInspection;
         completeStatusSetter = MesBuildingTaskNumberLink::setBoolArtifactComplete;
         Function<MesBuildingTaskNumberLink, Integer> numberGetter = MesBuildingTaskNumberLink::getArtifactNumber;
         taskIdGetter = MesBuildingTaskNumberLink::getArtifactTaskId;
      } else {
         if (!TaskTypeEnum.ASSEMBLE.equals(taskType)) {
            Preconditions.checkArgument(false, "不支持的任务类型");
            return;
         }

         queryWrapper.eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, taskProcess.getId())
            .eq(MesBuildingTaskNumberLink::getBoolAssembleReport, true)
            .in(MesBuildingTaskNumberLink::getAssembleNumber, inspectNumbers);
         numberLinks = this.mesBuildingTaskNumberLinkService.list(queryWrapper);
         linkNumbers = numberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList());
         nextProcessIdFunction = MesBuildingTaskNumberLink::getAssembleNextProcessId;
         taskProcessIdSetter = MesBuildingTaskNumberLink::setAssembleTaskProcessId;
         reportStatusSetter = MesBuildingTaskNumberLink::setBoolAssembleReport;
         inspectionStatusSetter = MesBuildingTaskNumberLink::setBoolAssembleInspection;
         completeStatusSetter = MesBuildingTaskNumberLink::setBoolAssembleComplete;
         Function<MesBuildingTaskNumberLink, Integer> numberGetter = MesBuildingTaskNumberLink::getAssembleNumber;
         taskIdGetter = MesBuildingTaskNumberLink::getAssembleTaskId;
      }

      Preconditions.checkArgument(linkNumbers.size() == inspectNumbers.size(), "操作失败!!!请刷新页面后重试!!!!");
      List<Long> nextProcessIds = numberLinks.stream().map(nextProcessIdFunction).distinct().collect(Collectors.toList());
      Map<String, MesBuildingTaskProcess> nextTaskProcessMap = this.taskProcessService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
               .eq(MesBuildingTaskProcess::getTaskId, taskProcess.getTaskId())
               .in(MesBuildingTaskProcess::getProcessId, nextProcessIds)
         )
         .stream()
         .collect(Collectors.toMap(p -> p.getTaskId() + "_" + p.getProcessId(), Function.identity()));

      for (MesBuildingTaskNumberLink link : numberLinks) {
         Long nextProcessId = 0L;
         MesBuildingTaskProcess process = nextTaskProcessMap.get(taskIdGetter.apply(link) + "_" + nextProcessIdFunction.apply(link));
         if (process != null) {
            nextProcessId = process.getId();
         }

         taskProcessIdSetter.accept(link, nextProcessId);
         reportStatusSetter.accept(link, Boolean.FALSE);
         inspectionStatusSetter.accept(link, Boolean.FALSE);
         completeStatusSetter.accept(link, nextProcessId == 0L);
      }

      this.mesBuildingTaskNumberLinkService.updateBatchById(numberLinks);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveBatchProduceInspection(List<BatchInspectDTO> dtos) {
      List<Long> taskProcessIdList = dtos.stream().map(BatchInspectDTO::getTaskProcessId).collect(Collectors.toList());
      List<MesBuildingTaskProcess> taskProcessList = this.taskProcessService.listByIds(taskProcessIdList);
      Map<Long, MesBuildingTaskProcess> taskProcessMap = taskProcessList.stream().collect(Collectors.toMap(MesBuildingTaskProcess::getId, Function.identity()));
      Integer taskTypeEnum = taskProcessList.get(0).getTaskTypeEnum();
      List<ReportRecordV2DTO> reportRecordV2DTOS = this.produceTeamReportService.listBatchReportDataByDate2List(dtos, taskTypeEnum);
      if (CollectionUtils.isEmpty(reportRecordV2DTOS)) {
         return Boolean.TRUE;
      }

      List<Long> reportNumberIds = reportRecordV2DTOS.stream().map(ReportRecordV2DTO::getReportNumberId).collect(Collectors.toList());
      Map<Long, List<MesBuildingProduceTeamReport>> produceTeamReportMap = this.teamReportService
         .list(
            Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class)
               .in(MesBuildingProduceTeamReport::getReportNumber, reportNumberIds)
               .apply("problem_quantity+inspection_quantity=0")
         )
         .stream()
         .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getTaskProcessId));
      List<InspectionReportSavedDTO> reportSavedDTOS = reportRecordV2DTOS.stream().map(a -> {
         InspectionReportSavedDTO dto = new InspectionReportSavedDTO();
         dto.setReportNumberId(a.getReportNumberId());
         dto.setReportQuantity(a.getReprotQuantity());
         dto.setTaskProcessId(a.getTaskProcessId());
         return dto;
      }).collect(Collectors.toList());
      Map<Long, MesBuildingTask> taskMap = this.taskService
         .listByIds(taskProcessList.stream().map(MesBuildingTaskProcess::getTaskId).distinct().collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
      this.saveBatchProduceInspection2List(reportSavedDTOS, taskProcessMap, produceTeamReportMap, taskMap);
      return true;
   }

   @Override
   public List<LastProcessInfoDTO> lastProcessInfo(Long id) {
      MesBuildingTaskProcess taskProcess = this.taskProcessService.getById(id);
      Preconditions.checkArgument(taskProcess != null, "操作失败：传入id不正确");
      Map<Long, List<Integer>> taskNumberMap;
      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<MesBuildingTaskNumberLink> canReportNumbers = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, id)
                  .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, false)
            );
         taskNumberMap = canReportNumbers.stream()
            .collect(
               Collectors.groupingBy(
                  MesBuildingTaskNumberLink::getArtifactTaskId, Collectors.mapping(MesBuildingTaskNumberLink::getArtifactNumber, Collectors.toList())
               )
            );
      } else {
         List<MesBuildingTaskNumberLink> canReportNumbers = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, id)
                  .eq(MesBuildingTaskNumberLink::getBoolAssembleReport, false)
            );
         taskNumberMap = canReportNumbers.stream()
            .collect(
               Collectors.groupingBy(
                  MesBuildingTaskNumberLink::getAssembleTaskId, Collectors.mapping(MesBuildingTaskNumberLink::getAssembleNumber, Collectors.toList())
               )
            );
      }

      MesBuildingTask task = this.taskService.getById(taskProcess.getTaskId());
      List<LastProcessInfoDTO> lastProcessInfoDTO;
      if (task.getBoolOneCode()) {
         lastProcessInfoDTO = this.produceTeamReportService.lastProcessInfo(taskNumberMap);
      } else {
         lastProcessInfoDTO = this.produceTeamReportService.lastProcessBatchInfo(taskNumberMap);
      }

      lastProcessInfoDTO.stream().map(s -> s.setBoolOneCode(task.getBoolOneCode())).collect(Collectors.toList());
      return lastProcessInfoDTO;
   }

   @Override
   public TeamScheduledSummaryDTO findAssembleScheduledSummary(Long workshopId, Long projectId) {
      TeamScheduledSummaryDTO teamScheduledSummaryDTO = new TeamScheduledSummaryDTO();
      List<TeamScheduledInfoDTO> scheduledList = this.baseMapper.findAssembleScheduledSummary(workshopId, projectId);
      teamScheduledSummaryDTO.setTeamScheduledInfo(scheduledList);
      teamScheduledSummaryDTO.setTotalScheduledWeight(
         scheduledList.stream().map(TeamScheduledInfoDTO::getScheduledWeight).reduce(BigDecimal.ZERO, BigDecimal::add)
      );
      return teamScheduledSummaryDTO;
   }

   @Override
   public List<AssNumberArtNumberLinkDTO> getAssembleNumberLink(Integer assId, List<Integer> assembleNumbers) {
      List<AssNumberArtNumberLinkDTO> dto = new ArrayList<>();
      List<MesBuildingTaskNumberLink> canReportNumbers = this.mesBuildingTaskNumberLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
               .eq(MesBuildingTaskNumberLink::getAssembleId, assId)
               .in(CollectionUtils.isNotEmpty(assembleNumbers), MesBuildingTaskNumberLink::getAssembleNumber, assembleNumbers)
         );
      if (CollectionUtils.isEmpty(canReportNumbers)) {
         return dto;
      }

      List<TechArtifact> artifacts = this.artifactService
         .listByIds(canReportNumbers.stream().map(s -> s.getArtifactId()).distinct().collect(Collectors.toList()));
      Map<Long, TechArtifact> artifactsMap = artifacts.stream().collect(Collectors.toMap(s -> s.getId(), Function.identity()));

      for (MesBuildingTaskNumberLink canReportNumber : canReportNumbers) {
         AssNumberArtNumberLinkDTO linkDTO = new AssNumberArtNumberLinkDTO();
         linkDTO.setAssId(canReportNumber.getAssembleId());
         linkDTO.setAssNumber(canReportNumber.getAssembleNumber());
         linkDTO.setArtId(canReportNumber.getArtifactId());
         linkDTO.setArtNumber(canReportNumber.getArtifactNumber());
         linkDTO.setArtSerialNumber(artifactsMap.get(canReportNumber.getArtifactId()).getSerialNumber());
         dto.add(linkDTO);
      }

      return dto;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void saveBatchProduceInspection2List(
      List<InspectionReportSavedDTO> inspectDataList,
      Map<Long, MesBuildingTaskProcess> taskProcessMap,
      Map<Long, List<MesBuildingProduceTeamReport>> produceTeamReportMap,
      Map<Long, MesBuildingTask> taskMap
   ) {
      Map<Long, List<InspectionReportSavedDTO>> inspectDataListMap = inspectDataList.stream()
         .collect(Collectors.groupingBy(InspectionReportSavedDTO::getTaskProcessId));
      inspectDataListMap.forEach(
         (taskProcessId, inspectData) -> {
            Long nextProcessId = 0L;
            List<Long> reportNumberIds = inspectData.stream().map(InspectionReportSavedDTO::getReportNumberId).collect(Collectors.toList());
            int allReportQuantity = inspectData.stream().mapToInt(InspectionReportSavedDTO::getReportQuantity).sum();
            List<MesBuildingProduceTeamReport> allReports = produceTeamReportMap.get(taskProcessId);
            Map<Long, List<MesBuildingProduceTeamReport>> allReportMap = allReports.stream()
               .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getReportNumber));
            Preconditions.checkArgument(allReportMap.keySet().size() == reportNumberIds.size(), "操作失败!!请刷新页面后重试!!!!");
            List<Long> taskProcessIds = allReports.stream().map(MesBuildingProduceTeamReport::getTaskProcessId).distinct().collect(Collectors.toList());
            Preconditions.checkArgument(taskProcessIds.size() == 1, "数据校验失败!!!!");
            MesBuildingTaskProcess taskProcess = taskProcessMap.get(taskProcessId);
            MesBuildingTask task = taskMap.get(taskProcess.getTaskId());
            this.taskBiz.checkProductStatus(Arrays.asList(taskProcess.getProductId()), taskProcess.getTaskTypeEnum());
            List<MesBuildingProduceInspectionTeamReport> inspectReports = new ArrayList<>();
            List<MesBuildingProduceTeamReport> needUpdateTeamReports = new ArrayList<>();
            MesBuildingProduceTeamReport produceTeamReport = allReports.get(0);
            Preconditions.checkArgument(allReports.stream().allMatch(e -> e.getWorkshopId().equals(produceTeamReport.getWorkshopId())), "操作失败,上报记录的车间不一致!");
            List<MesInspectConfig> inspectConfig = this.inspectConfigService
               .selectCurrentUserIsInspectUser(
                  produceTeamReport.getWorkshopId(), taskProcess.getProcessId(), task.getClassificationId(), UserUtil.getCurrentUserId()
               );
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(inspectConfig), "上报失败,当前用户不是质检用户");
            taskProcess.setInspectionQuantity(taskProcess.getInspectionQuantity() + allReportQuantity);
            Preconditions.checkArgument(taskProcess.getCompleteQuantity() >= taskProcess.getInspectionQuantity() + taskProcess.getProblemQuantity(), "操作失败!!!");
            this.taskProcessService.updateById(taskProcess);
            HashMap<Long, Integer> savePriceMap = new HashMap<>();
            Long reportNumber = this.redisUtils.incr("inspection_reportnumber:", 1L);

            for (InspectionReportSavedDTO dto : inspectData) {
               Preconditions.checkArgument(dto.getReportQuantity() > 0, "上报数不能小于零");
               List<MesBuildingProduceTeamReport> reports = allReportMap.get(dto.getReportNumberId());
               Preconditions.checkArgument(reports.size() >= dto.getReportQuantity(), "操作失败!!!!超出可质检数量!!!!");
               List<MesBuildingProduceTeamReport> needInspect = reports.stream().limit(dto.getReportQuantity().intValue()).collect(Collectors.toList());
               List<Integer> needInspectNumbers = needInspect.stream().map(MesBuildingProduceTeamReport::getNumber).collect(Collectors.toList());
               Map<Integer, MesBuildingProduceTeamReport> reportMap = needInspect.stream()
                  .collect(Collectors.toMap(MesBuildingProduceTeamReport::getNumber, Function.identity()));
               LocalDateTime time = LocalDateTime.now();
               if (!TaskTypeEnum.ARTIFACT.getType().equals(taskProcess.getTaskTypeEnum())
                  && !TaskTypeEnum.ASSEMBLE.getType().equals(taskProcess.getTaskTypeEnum())) {
                  Preconditions.checkArgument(false, "操作失败!!!!");
               } else {
                  for (Integer number : needInspectNumbers) {
                     MesBuildingProduceTeamReport teamReport = reportMap.get(number);
                     MesBuildingProduceInspectionTeamReport inspectionTeamReport = MesBuildingProduceInspectionTeamReport.builder()
                        .teamId(teamReport.getTeamId())
                        .productId(taskProcess.getProductId())
                        .taskTypeEnum(taskProcess.getTaskTypeEnum())
                        .processId(taskProcess.getProcessId())
                        .taskId(taskProcess.getTaskId())
                        .taskProcessId(taskProcess.getId())
                        .productionLineId(teamReport.getProductionLineId())
                        .inspectionQuantity(1)
                        .userId(UserUtil.getCurrentUserId())
                        .number(number)
                        .reportTime(time)
                        .inspectReportTime(time)
                        .inspectReportNumber(reportNumber)
                        .schedulingId(taskProcess.getSchedulingId())
                        .build();
                     inspectReports.add(inspectionTeamReport);
                     savePriceMap.merge(teamReport.getId(), 1, Integer::sum);
                     teamReport.setInspectionQuantity(teamReport.getInspectionQuantity() + 1);
                     Preconditions.checkArgument(
                        teamReport.getInspectionQuantity() + teamReport.getProblemQuantity() <= teamReport.getQuantity(), "操作失败!!请刷新页面!!!"
                     );
                     needUpdateTeamReports.add(teamReport);
                     if (task.getBoolOneCode()) {
                        reportNumber = this.redisUtils.incr("inspection_reportnumber:", 1L);
                        time = LocalDateTime.now();
                     }
                  }
               }
            }

            this.produceInspectionTeamReportService.saveBatch(inspectReports);
            this.produceTeamReportService.updateBatchById(needUpdateTeamReports);
            this.teamReportBiz.savePiceByData(savePriceMap);
            List<MesBuildingProduceTeamReportSummary> needUpdateSummarys = new ArrayList<>();
            Map<String, Integer> reportSummaryMap = inspectReports.stream()
               .collect(
                  Collectors.toMap(
                     s -> s.getTaskProcessId() + "_" + s.getProductionLineId() + "_" + s.getTeamId(),
                     MesBuildingProduceInspectionTeamReport::getInspectionQuantity,
                     Integer::sum
                  )
               );
            List<MesBuildingReportSummaryDTO> summaryDTOS = new ArrayList<>();

            for (String key : reportSummaryMap.keySet()) {
               String[] split = key.split("_");
               Long lineId = Long.valueOf(split[1]);
               Long teamId = Long.valueOf(split[2]);
               MesBuildingReportSummaryDTO build = MesBuildingReportSummaryDTO.builder().taskProcessId(taskProcessId).prodLineId(lineId).teamId(teamId).build();
               summaryDTOS.add(build);
            }

            List<MesBuildingProduceTeamReportSummary> summaryList = this.produceTeamReportSummaryService.listReportSummarysByData(summaryDTOS);
            Map<String, MesBuildingProduceTeamReportSummary> summaryMap = summaryList.stream()
               .collect(Collectors.toMap(s -> s.getTaskProcessId() + "_" + s.getProductionLineId() + "_" + s.getTeamId(), Function.identity()));

            for (String key : summaryMap.keySet()) {
               Integer inspectQuantity = reportSummaryMap.get(key);
               MesBuildingProduceTeamReportSummary dto = summaryMap.get(key);
               Preconditions.checkArgument(dto.getQuantity() >= dto.getProblemQuantity() + dto.getInspectionQuantity() + inspectQuantity, "操作失败!!请刷新页面后重试!!!!");
               dto.setInspectionQuantity(dto.getInspectionQuantity() + inspectQuantity);
               needUpdateSummarys.add(dto);
            }

            this.produceTeamReportSummaryService.updateBatchById(needUpdateSummarys);
            if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
               List<Integer> inspectNumbers = inspectReports.stream().map(MesBuildingProduceInspectionTeamReport::getNumber).collect(Collectors.toList());
               List<MesBuildingTaskNumberLink> numberLinks = this.mesBuildingTaskNumberLinkService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                        .eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, taskProcess.getId())
                        .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, true)
                        .in(MesBuildingTaskNumberLink::getArtifactNumber, inspectNumbers)
                  );
               List<Integer> numbers = numberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().collect(Collectors.toList());
               Preconditions.checkArgument(numbers.size() == inspectNumbers.size(), "操作失败!!!请刷新页面后重试!!!!");
               Map<String, MesBuildingTaskProcess> nextTaskProcess = this.taskProcessService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                        .eq(MesBuildingTaskProcess::getTaskId, taskProcess.getTaskId())
                        .in(
                           MesBuildingTaskProcess::getProcessId,
                           numberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactNextProcessId).distinct().collect(Collectors.toList())
                        )
                  )
                  .stream()
                  .collect(Collectors.toMap(s -> s.getTaskId() + "_" + s.getProcessId(), Function.identity()));

               for (MesBuildingTaskNumberLink numberLink : numberLinks) {
                  MesBuildingTaskProcess process = nextTaskProcess.get(numberLink.getArtifactTaskId() + "_" + numberLink.getArtifactNextProcessId());
                  if (process != null) {
                     nextProcessId = process.getId();
                  }

                  numberLink.setArtifactTaskProcessId(nextProcessId);
                  numberLink.setBoolArtifactReport(Boolean.FALSE);
                  numberLink.setBoolArtifactInspection(Boolean.FALSE);
                  numberLink.setBoolArtifactComplete(nextProcessId == 0L);
               }

               this.mesBuildingTaskNumberLinkService.updateBatchById(numberLinks);
            } else if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
               List<Integer> inspectNumbers = inspectReports.stream().map(MesBuildingProduceInspectionTeamReport::getNumber).collect(Collectors.toList());
               List<MesBuildingTaskNumberLink> numberLinks = this.mesBuildingTaskNumberLinkService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                        .eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, taskProcess.getId())
                        .eq(MesBuildingTaskNumberLink::getBoolAssembleReport, true)
                        .in(MesBuildingTaskNumberLink::getAssembleNumber, inspectNumbers)
                  );
               List<Integer> numbers = numberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList());
               Preconditions.checkArgument(numbers.size() == inspectNumbers.size(), "操作失败!!!请刷新页面后重试!!!!");
               Map<String, MesBuildingTaskProcess> nextTaskProcess = this.taskProcessService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                        .eq(MesBuildingTaskProcess::getTaskId, taskProcess.getTaskId())
                        .in(
                           MesBuildingTaskProcess::getProcessId,
                           numberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNextProcessId).distinct().collect(Collectors.toList())
                        )
                  )
                  .stream()
                  .collect(Collectors.toMap(s -> s.getTaskId() + "_" + s.getProcessId(), Function.identity()));

               for (MesBuildingTaskNumberLink numberLink : numberLinks) {
                  MesBuildingTaskProcess process = nextTaskProcess.get(numberLink.getAssembleTaskId() + "_" + numberLink.getAssembleNextProcessId());
                  if (process != null) {
                     nextProcessId = process.getId();
                  }

                  numberLink.setAssembleTaskProcessId(nextProcessId);
                  numberLink.setBoolAssembleReport(Boolean.FALSE);
                  numberLink.setBoolAssembleInspection(Boolean.FALSE);
                  numberLink.setBoolAssembleComplete(nextProcessId == 0L);
               }

               this.mesBuildingTaskNumberLinkService.updateBatchById(numberLinks);
            } else {
               Preconditions.checkArgument(false, "产品类型不正确!!!");
            }

            List<TeamAndNumberDTO> teamAndNumberDTOS = BeanUtil.copyToList(inspectReports, TeamAndNumberDTO.class);
            this.taskBiz.updateNextTaskInspectionProcess(taskProcess, allReportQuantity, teamAndNumberDTOS);
         }
      );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean revokeTaskPocess(Long id) {
      List<MesBuildingProduceTeamReport> teamReports = this.getAndValidateTeamReports(id);
      List<Long> reportIds = teamReports.stream().map(MesBuildingProduceTeamReport::getId).collect(Collectors.toList());
      this.handleAssistReports(teamReports);
      Boolean isReversible = teamReports.get(0).getIsReversible() == null ? false : teamReports.get(0).getIsReversible();
      int reduceQuantity = teamReports.stream().mapToInt(MesBuildingProduceTeamReport::getQuantity).sum();
      MesBuildingTaskProcess taskProcess = this.updateTaskProcessStatus(teamReports, reduceQuantity, isReversible);
      if (taskProcess.getSequence().equals(0)) {
         this.handleFirstProcessRollback(taskProcess, reduceQuantity);
      }

      this.maintainProductionAndTaskTables(reportIds, taskProcess, reduceQuantity);
      this.maintainReportSummaryTable(teamReports, reduceQuantity, isReversible);
      this.maintainTaskNumberLinks(teamReports, taskProcess, reduceQuantity, isReversible);
      if (isReversible) {
         this.handleReversibleSpecialBusiness(teamReports, taskProcess, reduceQuantity);
      }
      this.reverseMonthlyProductionSummary(teamReports, taskProcess, isReversible);

      return true;
   }

   private void reverseMonthlyProductionSummary(List<MesBuildingProduceTeamReport> reports, MesBuildingTaskProcess process, boolean reversible) {
      boolean first = process.getSequence().equals(0);
      MesBuildingTaskProcess last = this.taskProcessService.getOne(Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
         .eq(MesBuildingTaskProcess::getTaskId, process.getTaskId()).orderByDesc(MesBuildingTaskProcess::getSequence).last("LIMIT 1"));
      boolean completed = reversible && last.getId().equals(process.getId());
      if (!first && !completed) {
         return;
      }
      MesBuildingTask task = this.taskService.getById(process.getTaskId());
      Map<String, Integer> quantities = reports.stream().collect(Collectors.groupingBy(
         report -> com.hzchum.pangu.common.util.DateTimeUtil.getLocalMonthStr(report.getCreateTime()),
         Collectors.summingInt(MesBuildingProduceTeamReport::getQuantity)));
      quantities.forEach((month, quantity) -> this.productionSummaryService.updateRecordForMonth(
         ProductProductionSummaryDTOParam.builder().projectId(task.getProjectId()).monomerId(task.getMonomerId())
            .productId(task.getProductId()).productType(task.getTaskTypeEnum())
            .inProductionQuantity(first ? -quantity : 0).completeQuantity(completed ? -quantity : 0).build(), month));
   }

   private List<MesBuildingProduceTeamReport> getAndValidateTeamReports(Long id) {
      List<MesBuildingProduceTeamReport> teamReports = this.produceTeamReportService
         .list(Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class).eq(MesBuildingProduceTeamReport::getReportNumber, id));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(teamReports), "操作失败");
      Preconditions.checkArgument(teamReports.stream().allMatch(s -> s.getProblemQuantity().equals(0)), "操作失败!测回的任务存在问题!");
      Boolean isReversible = teamReports.get(0).getIsReversible() == null ? false : teamReports.get(0).getIsReversible();
      if (isReversible) {
         Preconditions.checkArgument(teamReports.stream().allMatch(s -> s.getInspectionQuantity() > 0), "操作失败,请刷新页面后重试!!!");
      }

      return teamReports;
   }

   private void handleAssistReports(List<MesBuildingProduceTeamReport> teamReports) {
      List<MesBuildingProduceTeamReport> assistReports = teamReports.stream()
         .filter(e -> e.getAssistId() != null && e.getAssistId() != 0L)
         .collect(Collectors.toList());
      if (!CollectionUtils.isEmpty(assistReports)) {
         assistReports.stream()
            .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getAssistId))
            .forEach((assistId, reportList) -> this.handleAssistReportGroup(assistId, (List<MesBuildingProduceTeamReport>)reportList));
      }
   }

   private void handleAssistReportGroup(Long assistId, List<MesBuildingProduceTeamReport> reportList) {
      MesBuildingAssist assist = this.assistBiz.getById(assistId);
      if (assist != null && assist.getProduceQuantity() >= reportList.size()) {
         assist.setProduceQuantity(assist.getProduceQuantity() - reportList.size());
         assist.setBoolFinishEnum(Boolean.FALSE);
         this.updateAssistNumberDetails(assistId, reportList);
         this.assistBiz.updateById(assist);
      }
   }

   private void updateAssistNumberDetails(Long assistId, List<MesBuildingProduceTeamReport> reportList) {
      Map<String, MesBuildingAssistNumberDetail> assistNumberDetailMap = this.assistNumberDetailService
         .list((Wrapper<MesBuildingAssistNumberDetail>)new LambdaQueryWrapper<MesBuildingAssistNumberDetail>().eq(MesBuildingAssistNumberDetail::getAssistId, assistId))
         .stream()
         .collect(Collectors.toMap(e -> e.getAssistId() + "-" + e.getTaskProcessId() + "-" + e.getNumber(), Function.identity()));
      List<MesBuildingAssistNumberDetail> updateDetails = new ArrayList<>();

      for (MesBuildingProduceTeamReport report : reportList) {
         MesBuildingAssistNumberDetail detail = assistNumberDetailMap.get(assistId + "-" + report.getTaskProcessId() + "-" + report.getNumber());
         if (detail != null) {
            detail.setBoolFinishEnum(Boolean.FALSE);
            updateDetails.add(detail);
         }
      }

      if (!updateDetails.isEmpty()) {
         this.assistNumberDetailService.updateBatchById(updateDetails);
      }
   }

   private MesBuildingTaskProcess updateTaskProcessStatus(List<MesBuildingProduceTeamReport> teamReports, int reduceQuantity, Boolean isReversible) {
      MesBuildingTaskProcess taskProcess = this.taskProcessService.getById(teamReports.get(0).getTaskProcessId());
      if (taskProcess.getTaskQuantity().equals(taskProcess.getCompleteQuantity())) {
         UpdateWrapper<MesBuildingTaskProcess> updateWrapper = new UpdateWrapper<>();
         updateWrapper.eq("id", taskProcess.getId()).setSql("complete_time = null");
         this.taskProcessService.update(updateWrapper);
      }

      taskProcess.setCompleteQuantity(taskProcess.getCompleteQuantity() - reduceQuantity);
      if (isReversible) {
         taskProcess.setInspectionQuantity(taskProcess.getInspectionQuantity() - reduceQuantity);
         Preconditions.checkArgument(taskProcess.getInspectionQuantity() <= taskProcess.getCompleteQuantity(), "操作失败,请联系管理员");
      }

      this.taskProcessService.updateById(taskProcess);
      this.taskBiz.checkProductStatus(Collections.singletonList(taskProcess.getProductId()), taskProcess.getTaskTypeEnum());
      this.produceTeamReportService.removeByIds(teamReports.stream().map(MesBuildingProduceTeamReport::getId).collect(Collectors.toList()));
      this.teamReportPriceService
         .remove(
            Wrappers.lambdaQuery(MesBuildingProduceTeamReportPrice.class)
               .eq(MesBuildingProduceTeamReportPrice::getTeamReoprtId, teamReports.get(0).getReportNumber())
         );
      return taskProcess;
   }

   private void handleFirstProcessRollback(MesBuildingTaskProcess taskProcess, int reduceQuantity) {
      if (TaskTypeEnum.ARTIFACT.getType().equals(taskProcess.getTaskTypeEnum())) {
         this.rollbackArtifactParts(taskProcess.getProductId(), reduceQuantity);
      } else if (TaskTypeEnum.ASSEMBLE.getType().equals(taskProcess.getTaskTypeEnum())) {
         this.rollbackAssembleParts(taskProcess.getProductId(), reduceQuantity);
      }
   }

   private void rollbackArtifactParts(Long artifactId, int reduceQuantity) {
      this.rollbackMachinePartsUsage(
         artifactId,
         reduceQuantity,
         TechArtifactMachinePartLink::getArtifactId,
         TechArtifactMachinePartLink::getMachinePartId,
         TechArtifactMachinePartLink::getQuantity,
         this.artifactMachinePartLinkService
      );
      this.rollbackAssemblePartsUsage(
         artifactId,
         reduceQuantity,
         TechAssembleDetail::getArtifactId,
         TechAssembleDetail::getAssembleId,
         TechAssembleDetail::getQuantity,
         this.assembleDetailService
      );
   }

   private void rollbackAssembleParts(Long assembleId, int reduceQuantity) {
      this.rollbackMachinePartsUsage(
         assembleId,
         reduceQuantity,
         TechAssembleMachinePartLink::getAssembleId,
         TechAssembleMachinePartLink::getMachinePartId,
         TechAssembleMachinePartLink::getQuantity,
         this.assembleMachinePartLinkService
      );
   }

   private <T> void rollbackMachinePartsUsage(
      Long productId,
      int reduceQuantity,
      SFunction<T, Long> productIdGetter,
      SFunction<T, Long> partIdGetter,
      SFunction<T, Integer> quantityGetter,
      IService<T> linkService
   ) {
      List<T> links = linkService.list(Wrappers.<T>lambdaQuery().eq(productIdGetter, productId));
      if (!CollectionUtils.isEmpty(links)) {
         List<Long> partIds = links.stream().map(partIdGetter).distinct().collect(Collectors.toList());
         Map<Long, TechMachinePart> partMap = this.machinePartService
            .listByIds(partIds)
            .stream()
            .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));

         for (T link : links) {
            TechMachinePart part = partMap.get(partIdGetter.apply(link));
            if (part != null) {
               part.setUsedQuantity(part.getUsedQuantity() - reduceQuantity * quantityGetter.apply(link));
            }
         }

         if (!partMap.isEmpty()) {
            this.machinePartService.updateBatchById(new ArrayList<>(partMap.values()));
         }
      }
   }

   private <T> void rollbackAssemblePartsUsage(
      Long productId,
      int reduceQuantity,
      SFunction<T, Long> productIdGetter,
      SFunction<T, Long> assembleIdGetter,
      SFunction<T, Integer> quantityGetter,
      IService<T> detailService
   ) {
      List<T> details = detailService.list(Wrappers.<T>lambdaQuery().eq(productIdGetter, productId));
      if (!CollectionUtils.isEmpty(details)) {
         List<Long> assembleIds = details.stream().map(assembleIdGetter).distinct().collect(Collectors.toList());
         Map<Long, TechAssemble> assembleMap = this.assembleService
            .listByIds(assembleIds)
            .stream()
            .collect(Collectors.toMap(TechAssemble::getId, Function.identity()));

         for (T detail : details) {
            TechAssemble assemble = assembleMap.get(assembleIdGetter.apply(detail));
            if (assemble != null) {
               assemble.setUsedQuantity(assemble.getUsedQuantity() - reduceQuantity * quantityGetter.apply(detail));
            }
         }

         if (!assembleMap.isEmpty()) {
            this.assembleService.updateBatchById(new ArrayList<>(assembleMap.values()));
         }
      }
   }

   private void maintainProductionAndTaskTables(List<Long> reportIds, MesBuildingTaskProcess taskProcess, int reduceQuantity) {
      List<MesBuildingInProduction> inProductionList = this.inProductionService
         .list((Wrapper<MesBuildingInProduction>)Wrappers.<MesBuildingInProduction>lambdaQuery().in(MesBuildingInProduction::getTeamReportId, reportIds));
      if (!inProductionList.isEmpty()) {
         this.inProductionService.removeByIds(inProductionList.stream().map(MesBuildingInProduction::getId).collect(Collectors.toList()));
      }

      MesBuildingTask task = this.taskService.getById(taskProcess.getTaskId());
      boolean updateTask = false;
      if (task.getTaskQuantity().equals(task.getCompleteQuantity())) {
         task.setCompleteTime(null);
         updateTask = true;
         UpdateWrapper<MesBuildingTask> updateWrapper = new UpdateWrapper<>();
         updateWrapper.eq("id", task.getId()).set("complete_time", null);
         this.taskService.update(updateWrapper);
      }

      boolean isFirstProcess = taskProcess.getSequence().equals(0);
      if (isFirstProcess) {
         task.setInProductionQuantity(task.getInProductionQuantity() - reduceQuantity);
         updateTask = true;
      }

      if (updateTask) {
         this.taskService.updateById(task);
      }
   }

   private void maintainReportSummaryTable(List<MesBuildingProduceTeamReport> teamReports, int reduceQuantity, Boolean isReversible) {
      MesBuildingProduceTeamReport firstReport = teamReports.get(0);
      MesBuildingProduceTeamReportSummary summary = this.produceTeamReportSummaryService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingProduceTeamReportSummary.class)
               .eq(MesBuildingProduceTeamReportSummary::getTaskProcessId, firstReport.getTaskProcessId())
               .eq(MesBuildingProduceTeamReportSummary::getProductionLineId, firstReport.getProductionLineId())
               .eq(MesBuildingProduceTeamReportSummary::getTeamId, firstReport.getTeamId())
         );
      if (summary != null) {
         summary.setQuantity(summary.getQuantity() - reduceQuantity);
         if (isReversible) {
            summary.setInspectionQuantity(summary.getInspectionQuantity() - reduceQuantity);
         }

         if (summary.getQuantity().equals(0)) {
            this.produceTeamReportSummaryService.removeById(summary.getId());
         } else {
            this.produceTeamReportSummaryService.updateById(summary);
         }
      }
   }

   private void maintainTaskNumberLinks(
      List<MesBuildingProduceTeamReport> teamReports, MesBuildingTaskProcess taskProcess, int reduceQuantity, Boolean isReversible
   ) {
      List<Integer> reportNumbers = teamReports.stream().map(MesBuildingProduceTeamReport::getNumber).collect(Collectors.toList());
      List<MesBuildingTaskNumberLink> numberLinks = this.queryTaskNumberLinks(taskProcess, reportNumbers);
      if (TaskTypeEnum.ARTIFACT.getType().equals(taskProcess.getTaskTypeEnum())) {
         this.handleArtifactNumberLinks(numberLinks, reportNumbers, taskProcess, isReversible);
      } else if (TaskTypeEnum.ASSEMBLE.getType().equals(taskProcess.getTaskTypeEnum())) {
         this.handleAssembleNumberLinks(numberLinks, reportNumbers, taskProcess, isReversible);
      }

      if (!numberLinks.isEmpty()) {
         this.mesBuildingTaskNumberLinkService.updateBatchById(numberLinks);
      }
   }

   private List<MesBuildingTaskNumberLink> queryTaskNumberLinks(MesBuildingTaskProcess taskProcess, List<Integer> reportNumbers) {
      LambdaQueryWrapper<MesBuildingTaskNumberLink> queryWrapper = Wrappers.<MesBuildingTaskNumberLink>lambdaQuery();
      if (TaskTypeEnum.ARTIFACT.getType().equals(taskProcess.getTaskTypeEnum())) {
         queryWrapper.eq(MesBuildingTaskNumberLink::getArtifactId, taskProcess.getProductId()).in(MesBuildingTaskNumberLink::getArtifactNumber, reportNumbers);
      } else if (TaskTypeEnum.ASSEMBLE.getType().equals(taskProcess.getTaskTypeEnum())) {
         queryWrapper.eq(MesBuildingTaskNumberLink::getAssembleId, taskProcess.getProductId()).in(MesBuildingTaskNumberLink::getAssembleNumber, reportNumbers);
      }

      return this.mesBuildingTaskNumberLinkService.list(queryWrapper);
   }

   private void handleArtifactNumberLinks(
      List<MesBuildingTaskNumberLink> numberLinks, List<Integer> reportNumbers, MesBuildingTaskProcess taskProcess, Boolean isReversible
   ) {
      Preconditions.checkArgument(numberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().count() == reportNumbers.size(), "操作失败!!!");
      Preconditions.checkArgument(numberLinks.stream().allMatch(e -> e.getArtifactNextProcessId() != null), "操作失败产品已入库!!!");
      Preconditions.checkArgument(numberLinks.stream().noneMatch(MesBuildingTaskNumberLink::getBoolArtifactInspection), "操作失败产品已质检!!!");

      for (MesBuildingTaskNumberLink link : numberLinks) {
         link.setBoolArtifactReport(Boolean.FALSE);
         if (isReversible) {
            link.setBoolArtifactInspection(Boolean.FALSE);
         }

         if (taskProcess.getSequence().equals(0)) {
            link.setBoolArtifactInproduce(Boolean.FALSE);
            link.setArtifactNextProcessId(null);
         }
      }

      if (taskProcess.getSequence().equals(0)) {
         UpdateWrapper<MesBuildingTaskNumberLink> updateWrapper = new UpdateWrapper<>();
         updateWrapper.in("id", numberLinks.stream().map(MesBuildingTaskNumberLink::getId).collect(Collectors.toList())).set("artifact_next_process_id", null);
         this.mesBuildingTaskNumberLinkService.update(updateWrapper);
      }
   }

   private void handleAssembleNumberLinks(
      List<MesBuildingTaskNumberLink> numberLinks, List<Integer> reportNumbers, MesBuildingTaskProcess taskProcess, Boolean isReversible
   ) {
      Preconditions.checkArgument(numberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().count() == reportNumbers.size(), "操作失败!!!");

      for (MesBuildingTaskNumberLink link : numberLinks) {
         link.setBoolAssembleReport(Boolean.FALSE);
         if (isReversible) {
            link.setBoolAssembleInspection(Boolean.FALSE);
         }

         link.setBoolAssembleComplete(Boolean.FALSE);
         if (taskProcess.getSequence().equals(0)) {
            link.setBoolAssembleInproduce(Boolean.FALSE);
            link.setAssembleNextProcessId(null);
         }
      }

      if (taskProcess.getSequence().equals(0)) {
         UpdateWrapper<MesBuildingTaskNumberLink> updateWrapper = new UpdateWrapper<>();
         updateWrapper.in("id", numberLinks.stream().map(MesBuildingTaskNumberLink::getId).collect(Collectors.toList())).set("assemble_next_process_id", null);
         this.mesBuildingTaskNumberLinkService.update(updateWrapper);
      }
   }

   private void handleReversibleSpecialBusiness(List<MesBuildingProduceTeamReport> teamReports, MesBuildingTaskProcess taskProcess, int reduceQuantity) {
      List<NumberInfoDTO> productNumberMap = teamReports.stream()
         .map(e -> NumberInfoDTO.builder().productId(e.getProductId()).number(e.getNumber()).build())
         .collect(Collectors.toList());
      Map<Long, List<Integer>> productIdSortNumberListMap = productNumberMap.stream()
         .collect(Collectors.groupingBy(NumberInfoDTO::getProductId, Collectors.mapping(NumberInfoDTO::getNumber, Collectors.toList())));
      if (TaskTypeEnum.ARTIFACT.getType().equals(teamReports.get(0).getTaskTypeEnum())) {
         this.mesBuildingCalcMaxNumManager.checkArtifactNumberChanger(productIdSortNumberListMap, Boolean.FALSE);
         this.projectProductionSummaryBiz
            .revokeProjectMeteSummary(taskProcess.getTaskId(), taskProcess.getId(), reduceQuantity, teamReports.get(0).getCreateTime());
      } else if (TaskTypeEnum.ASSEMBLE.getType().equals(teamReports.get(0).getTaskTypeEnum())) {
         this.mesBuildingCalcMaxNumManager.checkAssembleNumberChanger(productIdSortNumberListMap, Boolean.FALSE);
      }

      this.handleNextProcessBusiness(taskProcess, productNumberMap, teamReports.get(0).getTaskTypeEnum(), reduceQuantity);
   }

   private void handleNextProcessBusiness(MesBuildingTaskProcess taskProcess, List<NumberInfoDTO> productNumberMap, Integer taskTypeEnum, int reduceQuantity) {
      List<MesBuildingNextProcessLink> nextProcessLinks = this.nextProcessLinkService
         .list(Wrappers.lambdaQuery(MesBuildingNextProcessLink.class).eq(MesBuildingNextProcessLink::getTaskProcessId, taskProcess.getId()));
      if (!CollectionUtils.isEmpty(nextProcessLinks)) {
         List<Long> nextProcessIds = nextProcessLinks.stream().map(e -> e.getNextProcessId() == null ? 0L : e.getNextProcessId()).collect(Collectors.toList());
         List<Long> taskProcessIds = this.taskProcessService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                  .eq(MesBuildingTaskProcess::getTaskId, taskProcess.getTaskId())
                  .in(MesBuildingTaskProcess::getProcessId, nextProcessIds.stream().collect(Collectors.toList()))
            )
            .stream()
            .map(MesBuildingTaskProcess::getId)
            .collect(Collectors.toList());
         if (CollectionUtils.isEmpty(taskProcessIds) && nextProcessLinks.size() == 1 && nextProcessIds.get(0) == 0L) {
            taskProcessIds.add(0L);
         }

         List<MesBuildingTaskNumberLink> artOrAssLinks = this.mesBuildingTaskNumberLinkService.listLinksBydata(productNumberMap, taskTypeEnum);
         if (!CollectionUtils.isEmpty(artOrAssLinks)) {
            this.validateCanRevoke(artOrAssLinks, taskTypeEnum, taskProcessIds);
            this.updateNextProcessNeedQuantity(artOrAssLinks, taskTypeEnum, reduceQuantity);

            for (MesBuildingTaskNumberLink link : artOrAssLinks) {
               if (TaskTypeEnum.ARTIFACT.getType().equals(taskTypeEnum)) {
                  link.setArtifactTaskProcessId(taskProcess.getId());
                  link.setBoolArtifactInspection(Boolean.FALSE);
                  link.setBoolArtifactComplete(Boolean.FALSE);
               } else if (TaskTypeEnum.ASSEMBLE.getType().equals(taskTypeEnum)) {
                  link.setAssembleTaskProcessId(taskProcess.getId());
                  link.setBoolArtifactInspection(Boolean.FALSE);
                  link.setBoolAssembleComplete(Boolean.FALSE);
               }
            }

            this.mesBuildingTaskNumberLinkService.updateBatchById(artOrAssLinks);
            this.handleLastProcessArtOrAssRollback(taskProcess, productNumberMap, taskTypeEnum, reduceQuantity);
         }
      }
   }

   private void validateCanRevoke(List<MesBuildingTaskNumberLink> artOrAssLinks, Integer taskTypeEnum, List<Long> taskProcessIds) {
      if (TaskTypeEnum.ARTIFACT.getType().equals(taskTypeEnum)) {
         if (taskProcessIds.size() == 1 && taskProcessIds.get(0) == 0L) {
            Preconditions.checkArgument(
               artOrAssLinks.stream().allMatch(e -> taskProcessIds.get(0).equals(e.getArtifactTaskProcessId())), "撤回的构件，已流转到下一道工序，并生产无法撤回"
            );
         } else {
            Preconditions.checkArgument(
               artOrAssLinks.stream()
                  .allMatch(e -> taskProcessIds.contains(e.getArtifactTaskProcessId()) && !e.getBoolArtifactReport() && !e.getBoolArtifactInspection()),
               "撤回的构件，已流转到下一道工序，并生产无法撤回"
            );
         }
      } else if (TaskTypeEnum.ASSEMBLE.getType().equals(taskTypeEnum)) {
         if (taskProcessIds.size() == 1 && taskProcessIds.get(0) == 0L) {
            Preconditions.checkArgument(
               artOrAssLinks.stream().allMatch(e -> taskProcessIds.get(0).equals(e.getAssembleTaskProcessId()))
                  && artOrAssLinks.stream().allMatch(e -> e.getArtifactNextProcessId() == null),
               "撤回的部件，已流转到下一道工序，并生产无法撤回"
            );
         } else {
            Preconditions.checkArgument(
               artOrAssLinks.stream()
                  .allMatch(e -> taskProcessIds.contains(e.getAssembleTaskProcessId()) && !e.getBoolAssembleReport() && !e.getBoolAssembleInspection()),
               "撤回的部件，已流转到下一道工序，并生产无法撤回"
            );
         }
      }
   }

   private void updateNextProcessNeedQuantity(List<MesBuildingTaskNumberLink> artOrAssLinks, Integer taskTypeEnum, int reduceQuantity) {
      Long nextTaskProcessId = taskTypeEnum.equals(TaskTypeEnum.ARTIFACT.getType())
         ? artOrAssLinks.get(0).getArtifactTaskProcessId()
         : artOrAssLinks.get(0).getAssembleTaskProcessId();
      if (nextTaskProcessId != null) {
         MesBuildingTaskProcess nextTaskProcess = this.taskProcessService.getById(nextTaskProcessId);
         if (nextTaskProcess != null) {
            nextTaskProcess.setNeedQuantity(nextTaskProcess.getNeedQuantity() - reduceQuantity);
            Preconditions.checkArgument(nextTaskProcess.getCompleteQuantity() <= nextTaskProcess.getNeedQuantity(), "操作失败，请联系管理员！！");
            this.taskProcessService.updateById(nextTaskProcess);
         }
      }
   }

   private void handleLastProcessArtOrAssRollback(
      MesBuildingTaskProcess taskProcess, List<NumberInfoDTO> productNumberMap, Integer taskTypeEnum, int reduceQuantity
   ) {
      MesBuildingTaskProcess maxTaskProcess = this.taskProcessService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
               .eq(MesBuildingTaskProcess::getTaskId, taskProcess.getTaskId())
               .orderByDesc(MesBuildingTaskProcess::getSequence)
               .last("LIMIT 1")
         );
      if (maxTaskProcess.getProcessId().equals(taskProcess.getProcessId())) {
         MesBuildingTask task = this.taskService.getById(taskProcess.getTaskId());
         task.setCompleteQuantity(task.getCompleteQuantity() - reduceQuantity);
         this.taskService.updateById(task);
         LambdaQueryWrapper<MesBuildingComplete> lambdaQuery = Wrappers.lambdaQuery(MesBuildingComplete.class);
         productNumberMap.stream()
            .forEach(
               e -> {
                  if (lambdaQuery.isEmptyOfNormal()) {
                     lambdaQuery.eq(MesBuildingComplete::getProductId, e.getProductId());
                     lambdaQuery.eq(MesBuildingComplete::getNumber, e.getNumber());
                     lambdaQuery.eq(MesBuildingComplete::getTaskTypeEnum, taskTypeEnum);
                  } else {
                     lambdaQuery.or(
                        subQuery -> {
                           LambdaQueryWrapper var10000 = subQuery.eq(MesBuildingComplete::getProductId, e.getProductId())
                              .eq(MesBuildingComplete::getTaskTypeEnum, taskTypeEnum)
                              .eq(MesBuildingComplete::getNumber, e.getNumber());
                        }
                     );
                  }
               }
            );
         List<MesBuildingComplete> completes = this.completeService.list(lambdaQuery);
         if (TaskTypeEnum.ARTIFACT.getType().equals(taskTypeEnum)) {
            TechArtifact artifact = this.artifactService.getById(taskProcess.getProductId());
            artifact.setProducedQuantity(artifact.getProducedQuantity() - reduceQuantity);
            Preconditions.checkArgument(artifact.getQuantity() >= artifact.getProducedQuantity(), "操作失败!!!");
            this.artifactService.updateById(artifact);
         } else {
            TechAssemble assemble = this.assembleService.getById(taskProcess.getProductId());
            assemble.setProducedQuantity(assemble.getProducedQuantity() - reduceQuantity);
            Preconditions.checkArgument(assemble.getQuantity() >= assemble.getProducedQuantity(), "操作失败!!!");
            this.assembleService.updateById(assemble);
            this.revokeAllSendWarehouseData(completes, TaskTypeEnum.ASSEMBLE.getType());
         }

         this.revokeWarehouseByCompletes(completes);
         this.completeService.removeByIds(completes.stream().map(e -> e.getId()).collect(Collectors.toList()));
      }
   }

   private void revokeAllSendWarehouseData(List<MesBuildingComplete> neewUpdateAllSendList, Integer taskType) {
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
         sings.forEach(s -> s.setQuantity(0));
         this.singlePartArtifactPrintService.updateBatchById(sings);
      }
   }

   public void revokeWarehouseByCompletes(List<MesBuildingComplete> completes) {
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
      LambdaQueryWrapper<MesBuildingWarehouseRecord> wrapper = new LambdaQueryWrapper<>();

      for (MesBuildingComplete complete : completes) {
         if (wrapper.isEmptyOfNormal()) {
            wrapper.eq(MesBuildingWarehouseRecord::getCompleteId, complete.getId());
            wrapper.eq(MesBuildingWarehouseRecord::getProductId, complete.getProductId());
            wrapper.eq(complete.getNumber() != null, MesBuildingWarehouseRecord::getNumber, complete.getNumber());
         } else {
            wrapper.or(
               subQuery -> {
                  LambdaQueryWrapper var10000 = subQuery.eq(MesBuildingWarehouseRecord::getCompleteId, complete.getId())
                     .eq(MesBuildingWarehouseRecord::getProductId, complete.getProductId())
                     .eq(complete.getNumber() != null, MesBuildingWarehouseRecord::getNumber, complete.getNumber());
               }
            );
         }
      }

      this.warehouseRecordService.remove(wrapper);
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
      Map<String, MesBuildingWarehouseSummary> summaryMap = summaries.stream()
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
            if (updateSummary != null) {
               updateSummary.setQuantity(updateSummary.getQuantity().subtract(BigDecimal.valueOf(quantity.intValue())));
               saveSummaryMap.put(key, updateSummary);
            }
         } else {
            summary.setQuantity(summary.getQuantity().subtract(BigDecimal.valueOf(quantity.intValue())));
         }
      }

      this.warehouseSummaryService.saveBatch(new ArrayList<>(saveSummaryMap.values()));
      this.warehouseSummaryService.updateBatchById(new ArrayList<>(summaryMap.values()));
   }

   @Override
   public PageVO<SchedulingArtifactSummaryDTO> findSchedulingArtifactSummary(Long projectId, Long monomerId, Integer pageNum, Integer pageSize) {
      PageHelper.startPage(pageNum, pageSize);
      return new PageVO<>(this.baseService.findSchedulingArtifactSummary(projectId, monomerId));
   }

   @Override
   public PageVO<SchedulingArtifactDetailDTO> findSchedulingArtifactDetail(MesBuildingArtifactSchedulingParam param, Integer pageNum, Integer pageSize) {
      PageHelper.startPage(pageNum, pageSize);
      return new PageVO<>(this.baseService.findSchedulingArtifactDetail(param));
   }

   private static class AssistDataResult {
      private List<MesBuildingAssistNumberDetail> assistDetails;
      private Map<Integer, MesBuildingAssistNumberDetail> assistDetaiMap = new HashMap<>();
      private List<Integer> assistNumbers = new ArrayList<>();
      private List<MesBuildingAssistNumberDetail> assistNumberDetailUpdates = new ArrayList<>();

      public AssistDataResult() {
      }

      public List<MesBuildingAssistNumberDetail> getAssistDetails() {
         return this.assistDetails;
      }

      public Map<Integer, MesBuildingAssistNumberDetail> getAssistDetaiMap() {
         return this.assistDetaiMap;
      }

      public List<Integer> getAssistNumbers() {
         return this.assistNumbers;
      }

      public List<MesBuildingAssistNumberDetail> getAssistNumberDetailUpdates() {
         return this.assistNumberDetailUpdates;
      }

      public void setAssistDetails(final List<MesBuildingAssistNumberDetail> assistDetails) {
         this.assistDetails = assistDetails;
      }

      public void setAssistDetaiMap(final Map<Integer, MesBuildingAssistNumberDetail> assistDetaiMap) {
         this.assistDetaiMap = assistDetaiMap;
      }

      public void setAssistNumbers(final List<Integer> assistNumbers) {
         this.assistNumbers = assistNumbers;
      }

      public void setAssistNumberDetailUpdates(final List<MesBuildingAssistNumberDetail> assistNumberDetailUpdates) {
         this.assistNumberDetailUpdates = assistNumberDetailUpdates;
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         }

         if (!(o instanceof MesBuildingNewTaskBizImpl.AssistDataResult)) {
            return false;
         }

         MesBuildingNewTaskBizImpl.AssistDataResult other = (MesBuildingNewTaskBizImpl.AssistDataResult)o;
         if (!other.canEqual(this)) {
            return false;
         }

         Object this$assistDetails = this.getAssistDetails();
         Object other$assistDetails = other.getAssistDetails();
         if (this$assistDetails == null ? other$assistDetails == null : this$assistDetails.equals(other$assistDetails)) {
            Object this$assistDetaiMap = this.getAssistDetaiMap();
            Object other$assistDetaiMap = other.getAssistDetaiMap();
            if (this$assistDetaiMap == null ? other$assistDetaiMap == null : this$assistDetaiMap.equals(other$assistDetaiMap)) {
               Object this$assistNumbers = this.getAssistNumbers();
               Object other$assistNumbers = other.getAssistNumbers();
               if (this$assistNumbers == null ? other$assistNumbers == null : this$assistNumbers.equals(other$assistNumbers)) {
                  Object this$assistNumberDetailUpdates = this.getAssistNumberDetailUpdates();
                  Object other$assistNumberDetailUpdates = other.getAssistNumberDetailUpdates();
                  return this$assistNumberDetailUpdates == null
                     ? other$assistNumberDetailUpdates == null
                     : this$assistNumberDetailUpdates.equals(other$assistNumberDetailUpdates);
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      }

      protected boolean canEqual(final Object other) {
         return other instanceof MesBuildingNewTaskBizImpl.AssistDataResult;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         Object $assistDetails = this.getAssistDetails();
         result = result * 59 + ($assistDetails == null ? 43 : $assistDetails.hashCode());
         Object $assistDetaiMap = this.getAssistDetaiMap();
         result = result * 59 + ($assistDetaiMap == null ? 43 : $assistDetaiMap.hashCode());
         Object $assistNumbers = this.getAssistNumbers();
         result = result * 59 + ($assistNumbers == null ? 43 : $assistNumbers.hashCode());
         Object $assistNumberDetailUpdates = this.getAssistNumberDetailUpdates();
         return result * 59 + ($assistNumberDetailUpdates == null ? 43 : $assistNumberDetailUpdates.hashCode());
      }

      @Override
      public String toString() {
         return "MesBuildingNewTaskBizImpl.AssistDataResult(assistDetails="
            + this.getAssistDetails()
            + ", assistDetaiMap="
            + this.getAssistDetaiMap()
            + ", assistNumbers="
            + this.getAssistNumbers()
            + ", assistNumberDetailUpdates="
            + this.getAssistNumberDetailUpdates()
            + ")";
      }
   }
}
