package com.hzchum.scim.mes.building.core.service.impl.task;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.KevMeteDO;
import com.hzchum.scim.common.core.api.pojo.common.MonthMeteInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectMeteInfo;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.QueryTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.complete.CompleteMeteByMonthDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.complete.CompleteProductDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.CompleteMeteYearDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.ProductionCompleteYieldKpiDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.ProductionLineCompleteYieldKpiDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.ProductionTypeAnalysisDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.ProjectCompleteYieldKpiDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ArtifactProductionDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.ProductionAnalysisDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.ProjectProductionDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.complete.ProductionLoadDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.DateAndMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.ProjectAnalysisDataDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.ProjectInboundCurrentMonth;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.ProjectSteelRearingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingGroupsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.WorkshopMonthAndMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.WorkshopSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingWeeklyProductionReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.ProductMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.ResponseVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.artifactWarehouse.TonVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.manufacturingDeptProduction.TaskProductionVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.processProductionProgress.ProcessProductionProgressVO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingGroupsService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingGroupsTeamLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingCompleteMapper;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactSumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectProductDTO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.system.core.api.common.enums.ProductionLineTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingCompleteServiceImpl extends ServiceImpl<MesBuildingCompleteMapper, MesBuildingComplete> implements MesBuildingCompleteService {
   @Autowired
   private MesBuildingProductionLineService lineService;
   @Autowired
   private MesBuildingWorkshopService mesBuildingWorkshopService;
   @Autowired
   private MesBuildingProcessService mesBuildingProcessService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private SysDictionaryService dictionaryService;
   @Autowired
   private MesBuildingGroupsService groupsService;
   @Autowired
   private MesBuildingGroupsTeamLinkService groupsTeamLinkService;
   @Autowired
   private MesBuildingTeamService teamService;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private PlanMonomerService monomerService;
   @Autowired
   private PlanAreaService areaService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingTaskOrderService taskOrderService;
   @Autowired
   private MesBuildingProcessService processService;

   @Override
   public Map<String, BigDecimal> listGroupByDate(String year, String month, Integer productType, Long factoryId) {
      Preconditions.checkArgument(StringUtils.isNotBlank(year) | StringUtils.isNotBlank(month), "日期不能为空");
      Map<String, BigDecimal> result = new HashMap<>();
      List<KevMeteDO> kevMeteDOS;
      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         kevMeteDOS = this.baseMapper.listArtifactGroupByDate(year, month, null, factoryId);
      } else {
         kevMeteDOS = this.baseMapper.listEnclosureGroupByDate(year, month, factoryId);
      }

      kevMeteDOS.forEach(item -> {
         BigDecimal var10000 = result.put(item.getGroupKey(), item.getMete());
      });
      return result;
   }

   @Override
   public Map<String, Object> listEnclosureGroupByDate(String month, String date, Long factoryId) {
      Preconditions.checkArgument(StringUtils.isNotBlank(month) | StringUtils.isNotBlank(date), "日期不能为空");
      List<KevMeteDO> categories = this.baseMapper.listEnclosureCategoryGroupByDate(month, date, factoryId);
      List<KevMeteDO> plates = this.baseMapper.listEnclosurePlateGroupByDate(month, date, factoryId);
      Map<String, Object> result = new HashMap<>();
      result.put("categories", categories);
      result.put("plates", plates);
      return result;
   }

   @Override
   public List<KevMeteDO> listArtifactGroupByDate(String year, Long projectId) {
      return this.baseMapper.listArtifactGroupByDate(year, null, projectId, null);
   }

   @Override
   public List<ArtifactProductionDetailDO> listArtifactByProjectIdAndMonth(Long projectId, String month) {
      return this.baseMapper.listArtifactByProjectIdAndMonth(projectId, month);
   }

   @Override
   public BigDecimal sumMeteByProjectId(Long projectId) {
      return this.baseMapper.sumMeteByProjectId(projectId);
   }

   @Override
   public BigDecimal getSumStructureCompleteMete(Long monomerId, Long areaId) {
      Preconditions.checkArgument(monomerId != null || areaId != null, "单体id和区域ID不能都为空!");
      return this.baseMapper.getSumStructureCompleteMete(monomerId, areaId);
   }

   @Override
   public List<ProjectProductDTO> getAreaArtifactOneCodeCompleteDetails(Long areaId, Long processId) {
      return this.baseMapper.getAreaArtifactOneCodeCompleteDetails(areaId, processId);
   }

   @Override
   public ArtifactSumDTO listOneCodeByConditionsSummary(Long areaId, Long processId) {
      List<ProjectProductDTO> detailsList = this.baseMapper.getAreaArtifactOneCodeCompleteDetails(areaId, processId);
      ArtifactSumDTO dto = ArtifactSumDTO.builder().quantity(detailsList.size()).totalGrossWeight(BigDecimal.ZERO).totalNetWeight(BigDecimal.ZERO).build();
      detailsList.forEach(e -> {
         dto.setTotalNetWeight(dto.getTotalNetWeight().add(e.getNetWeight()));
         dto.setTotalGrossWeight(dto.getTotalGrossWeight().add(e.getGrossWeight()));
      });
      return dto;
   }

   @Override
   public List<MesBuildingProcessDTO> listOneCodeByConditionsProcessList(Long areaId) {
      List<ProjectProductDTO> detailsList = this.baseMapper.getAreaArtifactOneCodeCompleteDetails(areaId, null);
      if (CollectionUtils.isEmpty(detailsList)) {
         return new ArrayList<>();
      }

      List<Long> allProcessIds = detailsList.stream().map(e -> e.getProcess().getId()).distinct().collect(Collectors.toList());
      if (CollectionUtils.isEmpty(allProcessIds)) {
         return new ArrayList<>();
      }

      List<MesBuildingProcessDTO> allProcessDTOList = new ArrayList<>();
      List<Long> processIds = allProcessIds.stream().filter(e -> !e.equals(0L)).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(processIds)) {
         allProcessDTOList.addAll(
            this.processService.listByIds(processIds).stream().map(process -> BeanUtil.copy(process, MesBuildingProcessDTO.class)).collect(Collectors.toList())
         );
      }

      return allProcessDTOList;
   }

   @Override
   public BigDecimal getSumEnclosureCompleteMete(List<Long> areaIds) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(areaIds), "区域ID列表不能为空");
      return this.baseMapper.getSumEnclosureCompleteMete(areaIds);
   }

   @Override
   public List<ProductionAnalysisDetailsDO> getProductionByDateAndType(Long factoryId, LocalDateTime dateTime, Integer productType) {
      return this.baseMapper.getProductionByDateAndType(factoryId, dateTime, productType);
   }

   @Override
   public List<ProjectProductionDO> getProjectProductionByDate(LocalDateTime dateTime) {
      return this.baseMapper.getProjectProductionByDate(dateTime);
   }

   @Override
   public List<ProductionTypeAnalysisDO> productionTypeAnalysis(LocalDateTime dateTime, Integer productType) {
      return this.baseMapper.productionTypeAnalysis(dateTime, productType);
   }

   @Override
   public List<ProductionTypeAnalysisDO> productionTypeAnalysisV2(LocalDate dateTime, Integer productType, List<Long> projectIds, Long branchCompanyId) {
      return this.baseMapper.productionTypeAnalysisV2(dateTime, productType, projectIds, branchCompanyId);
   }

   @Override
   public List<ProductionCompleteYieldKpiDO> completeYieldGropMonth(LocalDateTime dateTime) {
      return this.baseMapper.completeYieldGropMonth(dateTime);
   }

   @Override
   public Map<Long, BigDecimal> completeYield(LocalDateTime dateTime, List<Long> productionLineIds) {
      Map<Long, BigDecimal> doMap = new HashMap<>();
      List<ProductionLineCompleteYieldKpiDO> doList = this.baseMapper.completeYield(dateTime, productionLineIds);
      doList.forEach(e -> doMap.put(e.getId(), e.getYield()));
      return doMap;
   }

   @Override
   public List<ProjectCompleteYieldKpiDO> projectCompleteYield(LocalDateTime dateTime) {
      return this.baseMapper.projectCompleteYield(dateTime);
   }

   @Override
   public List<ProductionLoadDO> productionLoad(LocalDateTime dateTime, Long factoryId) {
      return this.baseMapper.productionLoad(dateTime, factoryId);
   }

   @Override
   public List<CompleteProductDO> getTeamProduction(Long teamId, Integer productType, LocalDateTime dateTime) {
      return this.baseMapper.getTeamProduction(teamId, productType, dateTime);
   }

   @Override
   public List<CompleteMeteByMonthDO> getTeamMeteByMonth(Long teamId, Integer productType, LocalDateTime dateTime) {
      return this.baseMapper.getTeamMeteByMonth(teamId, productType, dateTime);
   }

   @Override
   public BigDecimal getMeteSummaryByCondition(LocalDateTime dateTime, Integer timeTypeEnum, Integer taskTypeEnum) {
      return this.baseMapper.getMeteSummaryByCondition(dateTime, timeTypeEnum, taskTypeEnum);
   }

   @Override
   public List<WorkshopMonthAndMeteDTO> getWorkshopReport(LocalDateTime dateTime, Long workShopId, Long productionLineId, Integer type) {
      return this.baseMapper.getWorkshopReport(dateTime, workShopId, productionLineId, type);
   }

   @Override
   public WorkshopMonthAndMeteDTO meteSummaryByYear(LocalDateTime dateTime, Long workShopId, Long productionLineId) {
      List<WorkshopMonthAndMeteDTO> workshopReport = this.baseMapper.getWorkshopReport(dateTime, workShopId, productionLineId, 1);
      return WorkshopMonthAndMeteDTO.builder()
         .totalNetWeight(workshopReport.stream().map(WorkshopMonthAndMeteDTO::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .totalGrossWeight(workshopReport.stream().map(WorkshopMonthAndMeteDTO::getTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .build();
   }

   @Override
   public PageVO<WorkshopSummaryDTO> artifactSummaryPage(
      LocalDateTime startTime, LocalDateTime endTime, Long workShopId, Long productionLineId, Long projectId, String name, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      LocalDateTime start = startTime == null ? null : LocalDateTime.of(startTime.toLocalDate(), LocalTime.MIDNIGHT);
      LocalDateTime end = endTime == null ? null : LocalDateTime.of(endTime.toLocalDate(), LocalTime.of(23, 59, 59, 999999999));
      PageHelper.startPage(pageNumber, pageSize);
      List<WorkshopSummaryDTO> allSummaryDTOS = this.baseMapper.listArtifactSummary(start, end, workShopId, productionLineId, projectId, name);
      PageVO<WorkshopSummaryDTO> pagevo = new PageVO<>(allSummaryDTOS);
      List<Long> lineIds = allSummaryDTOS.stream().map(s -> s.getProductionLine().getId()).distinct().collect(Collectors.toList());
      List<Long> teamIds = allSummaryDTOS.stream().map(WorkshopSummaryDTO::getTeamId).distinct().collect(Collectors.toList());
      List<Long> productIds = allSummaryDTOS.stream().map(WorkshopSummaryDTO::getProductId).distinct().collect(Collectors.toList());
      List<Long> projectIds = allSummaryDTOS.stream().map(s -> s.getProject().getId()).distinct().collect(Collectors.toList());
      List<Long> monIds = allSummaryDTOS.stream().map(s -> s.getMonomer().getId()).distinct().collect(Collectors.toList());
      List<Long> areaIds = allSummaryDTOS.stream().map(s -> s.getArea().getId()).distinct().collect(Collectors.toList());
      List<Long> taskIds = allSummaryDTOS.stream().map(WorkshopSummaryDTO::getTaskId).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new PageVO<>();
      }

      Map<Long, ContractProject> projectMap = this.projectService.listByIds(projectIds).stream().collect(Collectors.toMap(s -> s.getId(), Function.identity()));
      Map<Long, PlanMonomer> monomerMap = this.monomerService.listByIds(monIds).stream().collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
      Map<Long, PlanArea> areaMap = this.areaService.listByIds(areaIds).stream().collect(Collectors.toMap(PlanArea::getId, Function.identity()));
      Map<Long, MesBuildingProductionLine> lineMap = this.lineService
         .listByIds(lineIds)
         .stream()
         .collect(Collectors.toMap(s -> s.getId(), Function.identity()));
      Map<Long, MesBuildingTeamUserLink> userLinkMap = this.teamUserLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingTeamUserLink.class)
               .in(MesBuildingTeamUserLink::getTeamId, teamIds)
               .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, true)
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingTeamUserLink::getTeamId, Function.identity()));
      Map<Long, TechArtifact> artifactMap = this.artifactService.listByIds(productIds).stream().collect(Collectors.toMap(s -> s.getId(), Function.identity()));
      Map<Long, MesBuildingTask> taskMap = this.taskService.listByIds(taskIds).stream().collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
      Map<Long, MesBuildingTaskOrder> taskOrderMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(taskMap)) {
         taskOrderMap = this.taskOrderService
            .listByIds(taskMap.values().stream().map(MesBuildingTask::getTaskOrderId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(MesBuildingTaskOrder::getId, Function.identity()));
      }

      MesBuildingProcess process = this.mesBuildingProcessService.getOne(Wrappers.lambdaQuery(MesBuildingProcess.class).eq(MesBuildingProcess::getName, "装配"));
      if (CollectionUtils.isNotEmpty(allSummaryDTOS)) {
         List<Long> taskIdList = allSummaryDTOS.stream().map(WorkshopSummaryDTO::getTaskId).distinct().collect(Collectors.toList());
         Map<Long, MesBuildingGroupsDTO> pinProcessTeamName = new HashMap<>();
         if (process != null) {
         }

         for (WorkshopSummaryDTO dto : allSummaryDTOS) {
            MesBuildingTask task = taskMap.get(dto.getTaskId());
            if (task != null && CollectionUtils.isNotEmpty(taskOrderMap) && taskOrderMap.get(task.getTaskOrderId()) != null) {
               dto.setOrderNumber(taskOrderMap.get(task.getTaskOrderId()).getOrderNumber());
            }

            ProductionLineDetailDO line = dto.getProductionLine();
            if (lineMap.get(line.getId()) != null) {
               line.setName(lineMap.get(line.getId()).getName());
            }

            dto.setProductionLine(line);
            MesBuildingTeamUserLink userLink = userLinkMap.get(dto.getTeamId());
            if (userLink != null) {
               dto.setTeamName(userLink.getUserName());
            }

            Long artId = dto.getProductId();
            dto.setDate(dto.getDate());
            ProjectDetailDO dtoProject = dto.getProject();
            ContractProject project = projectMap.get(dtoProject.getId());
            dtoProject.setName(project.getName());
            dtoProject.setSerialNumber(project.getSerialNumber());
            dtoProject.setShortName(project.getShortName());
            MonomerDetailDO dtoMon = dto.getMonomer();
            PlanMonomer mon = monomerMap.get(dtoMon.getId());
            dtoMon.setName(mon.getName());
            AreaDetailDO dtoArea = dto.getArea();
            PlanArea area = areaMap.get(dtoArea.getId());
            dtoArea.setName(area.getName());
            TechArtifact artifact = artifactMap.get(artId);
            dto.setMaterial(artifact.getMaterial());
            dto.setName(artifact.getName());
            dto.setSerialNumber(artifact.getSerialNumber());
            dto.setSpecification(artifact.getSpecification());
            dto.setLength(artifact.getLength());
            dto.setNetWeight(artifact.getNetWeight());
            dto.setGrossWeight(artifact.getGrossWeight());
            dto.setSurfaceArea(artifact.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 4, 4));
            dto.setTotalNetWeight(artifact.getNetWeight().multiply(BigDecimal.valueOf(dto.getQuantity().intValue())));
            dto.setTotalGrossWeight(artifact.getGrossWeight().multiply(BigDecimal.valueOf(dto.getQuantity().intValue())));
            dto.setTotalSurfaceArea(
               artifact.getSurfaceArea().multiply(BigDecimal.valueOf(dto.getQuantity().intValue())).divide(BigDecimal.valueOf(1000000L), 4, 4)
            );
            MesBuildingGroupsDTO groupName = pinProcessTeamName.get(dto.getTaskId());
            if (groupName != null) {
               dto.setTeamName(dto.getTeamName());
            }
         }
      }

      return pagevo;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> artifactSummaryPrint(
      LocalDateTime startTime, LocalDateTime endTime, Long workShopId, Long productionLineId, Long projectId, String name
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      String date = startTime != null && endTime != null ? DateTimeUtil.getLocalDateStr(startTime) + "-" + DateTimeUtil.getLocalDateStr(endTime) : "全部";
      header.put("date", date);
      printVO.setHeader(header);
      printVO.setTable(
         this.artifactSummary(startTime, endTime, workShopId, productionLineId, projectId, name).stream().map(BeanUtil::beanToMap).collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public List<WorkshopSummaryDTO> artifactSummary(
      LocalDateTime startTime, LocalDateTime endTime, Long workShopId, Long productionLineId, Long projectId, String name
   ) {
      LocalDateTime start = startTime == null ? null : LocalDateTime.of(startTime.toLocalDate(), LocalTime.MIDNIGHT);
      LocalDateTime end = endTime == null ? null : LocalDateTime.of(endTime.toLocalDate(), LocalTime.of(23, 59, 59, 999999999));
      List<WorkshopSummaryDTO> allSummaryDTOS = this.baseMapper.listArtifactSummary(start, end, workShopId, productionLineId, projectId, name);
      if (CollectionUtils.isEmpty(allSummaryDTOS)) {
         return new ArrayList<>();
      }

      List<Long> lineIds = allSummaryDTOS.stream().map(s -> s.getProductionLine().getId()).distinct().collect(Collectors.toList());
      List<Long> teamIds = allSummaryDTOS.stream().map(WorkshopSummaryDTO::getTeamId).distinct().collect(Collectors.toList());
      List<Long> productIds = allSummaryDTOS.stream().map(WorkshopSummaryDTO::getProductId).distinct().collect(Collectors.toList());
      List<Long> projectIds = allSummaryDTOS.stream().map(s -> s.getProject().getId()).distinct().collect(Collectors.toList());
      List<Long> monIds = allSummaryDTOS.stream().map(s -> s.getMonomer().getId()).distinct().collect(Collectors.toList());
      List<Long> areaIds = allSummaryDTOS.stream().map(s -> s.getArea().getId()).distinct().collect(Collectors.toList());
      Map<Long, ContractProject> projectMap = this.projectService.listByIds(projectIds).stream().collect(Collectors.toMap(s -> s.getId(), Function.identity()));
      Map<Long, PlanMonomer> monomerMap = this.monomerService.listByIds(monIds).stream().collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
      Map<Long, PlanArea> areaMap = this.areaService.listByIds(areaIds).stream().collect(Collectors.toMap(PlanArea::getId, Function.identity()));
      Map<Long, MesBuildingProductionLine> lineMap = this.lineService
         .listByIds(lineIds)
         .stream()
         .collect(Collectors.toMap(s -> s.getId(), Function.identity()));
      Map<Long, MesBuildingTeamUserLink> userLinkMap = this.teamUserLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingTeamUserLink.class)
               .in(MesBuildingTeamUserLink::getTeamId, teamIds)
               .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, true)
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingTeamUserLink::getTeamId, Function.identity()));
      Map<Long, TechArtifact> artifactMap = this.artifactService.listByIds(productIds).stream().collect(Collectors.toMap(s -> s.getId(), Function.identity()));
      MesBuildingProcess process = this.mesBuildingProcessService.getOne(Wrappers.lambdaQuery(MesBuildingProcess.class).eq(MesBuildingProcess::getName, "装配"));
      if (CollectionUtils.isNotEmpty(allSummaryDTOS)) {
         List<Long> taskIdList = allSummaryDTOS.stream().map(WorkshopSummaryDTO::getTaskId).distinct().collect(Collectors.toList());
         Map<Long, MesBuildingGroupsDTO> pinProcessTeamName = new HashMap<>();
         if (process != null) {
         }

         for (WorkshopSummaryDTO dto : allSummaryDTOS) {
            ProductionLineDetailDO line = dto.getProductionLine();
            if (lineMap.get(line.getId()) != null) {
               line.setName(lineMap.get(line.getId()).getName());
            }

            dto.setProductionLine(line);
            MesBuildingTeamUserLink userLink = userLinkMap.get(dto.getTeamId());
            if (userLink != null) {
               dto.setTeamName(userLink.getUserName());
            }

            Long artId = dto.getProductId();
            dto.setDate(dto.getDate());
            ProjectDetailDO dtoProject = dto.getProject();
            ContractProject project = projectMap.get(dtoProject.getId());
            dtoProject.setName(project.getName());
            dtoProject.setSerialNumber(project.getSerialNumber());
            dtoProject.setShortName(project.getShortName());
            MonomerDetailDO dtoMon = dto.getMonomer();
            PlanMonomer mon = monomerMap.get(dtoMon.getId());
            dtoMon.setName(mon.getName());
            AreaDetailDO dtoArea = dto.getArea();
            PlanArea area = areaMap.get(dtoArea.getId());
            dtoArea.setName(area.getName());
            TechArtifact artifact = artifactMap.get(artId);
            dto.setMaterial(artifact.getMaterial());
            dto.setName(artifact.getName());
            dto.setSerialNumber(artifact.getSerialNumber());
            dto.setSpecification(artifact.getSpecification());
            dto.setLength(artifact.getLength());
            dto.setNetWeight(artifact.getNetWeight());
            dto.setGrossWeight(artifact.getGrossWeight());
            dto.setSurfaceArea(artifact.getSurfaceArea());
            dto.setTotalNetWeight(artifact.getNetWeight().multiply(BigDecimal.valueOf(dto.getQuantity().intValue())));
            dto.setTotalGrossWeight(artifact.getGrossWeight().multiply(BigDecimal.valueOf(dto.getQuantity().intValue())));
            dto.setTotalSurfaceArea(
               artifact.getSurfaceArea()
                  .multiply(BigDecimal.valueOf(dto.getQuantity().intValue()))
                  .divide(BigDecimal.valueOf(1000000L), 7, RoundingMode.HALF_UP)
            );
            MesBuildingGroupsDTO groupName = pinProcessTeamName.get(dto.getTaskId());
            if (groupName != null) {
               dto.setTeamName(dto.getTeamName());
            }
         }
      }

      return allSummaryDTOS;
   }

   @Override
   public WorkshopMonthAndMeteDTO meteSummary(
      LocalDateTime startTime, LocalDateTime endTime, Long workShopId, Long productionLineId, Long projectId, String name
   ) {
      List<WorkshopSummaryDTO> workshopSummaryDTOS = this.artifactSummary(startTime, endTime, workShopId, productionLineId, projectId, name);
      return WorkshopMonthAndMeteDTO.builder()
         .totalNetWeight(workshopSummaryDTOS.stream().map(WorkshopSummaryDTO::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .totalGrossWeight(workshopSummaryDTOS.stream().map(WorkshopSummaryDTO::getTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .build();
   }

   @Override
   public List<ProductMeteDTO> getWorkshopMeteByMonth(LocalDateTime dateTime, Long workShopId, Long productionLineId) {
      return this.baseMapper.getWorkshopMete(1, dateTime, workShopId, productionLineId);
   }

   @Override
   public List<ProductMeteDTO> getWorkshopMeteByMonthDetail(LocalDateTime dateTime, Long workShopId, Long productionLineId) {
      return this.baseMapper.getWorkshopMeteByMonthDetail(dateTime, workShopId, productionLineId);
   }

   @Override
   public List<ProductMeteDTO> getWorkshopMeteByDay(LocalDateTime dateTime, Long workShopId, Long productionLineId) {
      return this.baseMapper.getWorkshopMete(2, dateTime, workShopId, productionLineId);
   }

   @Override
   public CompleteMeteYearDTO getWorkshopMeteSummary(LocalDateTime dateTime, Long workShopId, Long productionLineId) {
      return CompleteMeteYearDTO.builder()
         .completeMete(
            this.baseMapper
               .getWorkshopMete(1, dateTime, workShopId, productionLineId)
               .stream()
               .map(ProductMeteDTO::getTotalNetWeight)
               .reduce(BigDecimal.ZERO, BigDecimal::add)
         )
         .target(
            this.lineService
               .list(Wrappers.lambdaQuery(MesBuildingProductionLine.class).eq(MesBuildingProductionLine::getProductType, ProductTypeEnum.ARTIFACT.getType()))
               .stream()
               .map(MesBuildingProductionLine::getTargetProduction)
               .reduce(BigDecimal.ZERO, BigDecimal::add)
               .multiply(new BigDecimal(12))
         )
         .build();
   }

   @Override
   public List<MonthMeteInfo> listProjectMonthMete(Long projectId, Integer productType) {
      return this.baseMapper.selectProjectMonthMete(projectId, productType);
   }

   @Override
   public List<MonthMeteInfo> listMonthTotalMete(Integer startMonth, Integer endMonth) {
      return this.baseMapper.selectMonthTotalMete(startMonth, endMonth);
   }

   @Override
   public Integer getLastProductionMonth(Integer startMonth) {
      return this.baseMapper.selectLastProductionMonth(startMonth);
   }

   @Override
   public List<ProjectMeteInfo> listProjectMete(Integer year) {
      return this.baseMapper.selectListProjectMete(year);
   }

   @Override
   public List<TaskProductionVO> getCompleteProduction(Date date, List<String> taskIds) {
      return this.baseMapper.getCompleteProduction(date, taskIds);
   }

   @Override
   public List<ResponseVO> manufacturingDeptProductionLaborEfficiency() {
      List<DateTime> dateList = new ArrayList<>();

      for (int i = 1; i <= 7; i++) {
         dateList.add(DateUtil.offsetDay(new Date(), -i));
      }

      List<ResponseVO> voList = new ArrayList<>();

      for (MesBuildingWorkshop workshop : this.mesBuildingWorkshopService.list()) {
         for (DateTime date : dateList) {
            ResponseVO vo = new ResponseVO();
            vo.setKey(Objects.nonNull(workshop.getShortName()) ? workshop.getShortName() : workshop.getName());
            vo.setKey2(DateUtil.format(date, "yyyy-MM-dd"));
            vo.setVal(this.baseMapper.manufacturingDeptProductionLaborEfficiency(workshop.getId(), date));
            voList.add(vo);
         }
      }

      return voList;
   }

   @Override
   public BigDecimal sumProduceTon(Long projectId) {
      return this.baseMapper.sumProduceTon(projectId);
   }

   @Override
   public List<TonVO> productAnalysis(Long projectId, String type) {
      if (Objects.isNull(type)) {
         type = QueryTypeEnum.DAY.getTypeEn();
      }

      List<TonVO> listVo = new ArrayList<>();
      List<TonVO> list1 = new ArrayList<>();
      List<TonVO> list2 = new ArrayList<>();
      List<TonVO> list3 = new ArrayList<>();
      if (type.equals(QueryTypeEnum.DAY.getTypeEn())) {
         list1 = this.baseMapper.getTechArtifactTonOfDimension("%Y-%m-%d", 29, projectId);
         list2 = this.baseMapper.getTechAssembleTonOfDimension("%Y-%m-%d", 29, projectId);
         list3 = this.baseMapper.getTechMachinePartTonOfDimension("%Y-%m-%d", 29, projectId);
      } else if (type.equals(QueryTypeEnum.MONTH.getTypeEn())) {
         list1 = this.baseMapper.getTechArtifactTonOfDimension("%Y-%m", 11, projectId);
         list2 = this.baseMapper.getTechAssembleTonOfDimension("%Y-%m", 11, projectId);
         list3 = this.baseMapper.getTechMachinePartTonOfDimension("%Y-%m", 11, projectId);
      } else if (type.equals(QueryTypeEnum.YEAY.getTypeEn())) {
         list1 = this.baseMapper.getTechArtifactTonOfDimension("%Y", 4, projectId);
         list2 = this.baseMapper.getTechAssembleTonOfDimension("%Y", 4, projectId);
         list3 = this.baseMapper.getTechMachinePartTonOfDimension("%Y", 4, projectId);
      }

      listVo.addAll(list1);
      listVo.addAll(list2);
      listVo.addAll(list3);
      return listVo;
   }

   @Override
   public List<ProcessProductionProgressVO> processProductionProgress(Long projectId) {
      List<ProcessProductionProgressVO> list = this.baseMapper.processProductionProgress(projectId);
      Map<Long, List<ProcessProductionProgressVO>> map = list.stream().collect(Collectors.groupingBy(ProcessProductionProgressVO::getProcessId));
      List<ProcessProductionProgressVO> voList = new ArrayList<>();
      List<MesBuildingProcess> pList = this.mesBuildingProcessService
         .list(
            (Wrapper<MesBuildingProcess>)new LambdaQueryWrapper<MesBuildingProcess>()
               .eq(MesBuildingProcess::getProductionLineTypeEnum, ProductionLineTypeEnum.TRADITIONAL_LINE.getType())
         );
      if (CollectionUtils.isNotEmpty(pList)) {
         Map<Long, MesBuildingProcess> processMap = pList.stream().collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));

         for (Long processId : map.keySet()) {
            MesBuildingProcess process = processMap.get(processId);
            List<ProcessProductionProgressVO> listVo = map.get(processId);
            BigDecimal taskQuantity = listVo.stream().map(ProcessProductionProgressVO::getTaskQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal taskTon = listVo.stream().map(ProcessProductionProgressVO::getTaskTon).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inspectionQuantity = listVo.stream().map(ProcessProductionProgressVO::getInspectionQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal inspectionTon = listVo.stream().map(ProcessProductionProgressVO::getInspectionTon).reduce(BigDecimal.ZERO, BigDecimal::add);
            ProcessProductionProgressVO voObj = new ProcessProductionProgressVO();
            voObj.setProcessId(process.getId());
            voObj.setName(process.getName());
            voObj.setTaskQuantity(taskQuantity);
            voObj.setTaskTon(taskTon);
            voObj.setInspectionQuantity(inspectionQuantity);
            voObj.setInspectionTon(inspectionTon);
            voObj.setRateOfQuantity(NumberUtil.round(NumberUtil.div(inspectionQuantity, taskQuantity), 2));
            voObj.setRateOfTon(NumberUtil.round(NumberUtil.div(inspectionTon, taskTon), 2));
            voList.add(voObj);
         }

         for (Long pId : processMap.keySet()) {
            if (!voList.stream().map(ProcessProductionProgressVO::getProcessId).collect(Collectors.toList()).contains(pId)) {
               ProcessProductionProgressVO voObj = new ProcessProductionProgressVO();
               voObj.setProcessId(pId);
               voObj.setName(processMap.get(pId).getName());
               voObj.setTaskQuantity(new BigDecimal("0"));
               voObj.setTaskTon(new BigDecimal("0"));
               voObj.setInspectionQuantity(new BigDecimal("0"));
               voObj.setInspectionTon(new BigDecimal("0"));
               voObj.setRateOfQuantity(new BigDecimal("0"));
               voObj.setRateOfTon(new BigDecimal("0"));
               voList.add(voObj);
            }
         }
      }

      return voList;
   }

   @Override
   public List<MesBuildingComplete> listCompleteByData(List<NumberInfoDTO> numberInfoDTOS, Integer type) {
      return this.baseMapper.listCompleteByData(numberInfoDTOS, type);
   }

   @Override
   public List<ProjectAnalysisDataDTO> findProjectAnalysisDataDTO(Long workShopId, String year) {
      List<ProjectAnalysisDataDTO> dataDTOS = this.baseMapper.findProjectAnalysisDataDTO(workShopId, year);
      Map<Long, String> structureStatus = this.dictionaryService
         .listByName("structure_status")
         .stream()
         .collect(Collectors.toMap(e -> e.getId(), s -> s.getLabel()));
      dataDTOS.forEach(e -> {
         e.setStructureStatusName(structureStatus.get(e.getStructureStatus()));
         e.setDeepenTon(e.getDeepenTon().multiply(BigDecimal.valueOf(100L)).setScale(0, RoundingMode.HALF_UP));
         e.setProductionCompleteTon(e.getProductionCompleteTon().multiply(BigDecimal.valueOf(100L)).setScale(0, RoundingMode.HALF_UP));
         e.setShippedCompleteTon(e.getShippedCompleteTon().multiply(BigDecimal.valueOf(100L)).setScale(0, RoundingMode.HALF_UP));
      });
      return dataDTOS;
   }

   @Override
   public List<ProjectSteelRearingDTO> findProjectSteelRearing(Long workShopId, String year) {
      return this.baseMapper.findProjectSteelRearing(workShopId, year);
   }

   @Override
   public List<MesBuildingWeeklyProductionReportDTO> getWeeklyProductionReportDetails(LocalDateTime StartTime, LocalDateTime EndTime) {
      return this.baseMapper.getWeeklyProductionReportDetails(StartTime, EndTime);
   }

   @Override
   public List<MesBuildingWeeklyProductionReportDTO> getMonthProductionReportDetails() {
      List<MesBuildingWeeklyProductionReportDTO> monthlyProductionReportDetails = this.baseMapper.getMonthlyProductionReportDetails();
      Map<String, List<MesBuildingWeeklyProductionReportDTO>> productionReportDTOMap = this.baseMapper
         .getYeaslyProductionReportDetails()
         .stream()
         .collect(Collectors.groupingBy(MesBuildingWeeklyProductionReportDTO::getWorkShopName));
      monthlyProductionReportDetails.forEach(e -> {
         if (productionReportDTOMap.containsKey(e.getWorkShopName())) {
            e.setTotalNetWeight(productionReportDTOMap.get(e.getWorkShopName()).get(0).getTotalNetWeight());
         }
      });
      return monthlyProductionReportDetails;
   }

   @Override
   public List<ProjectInboundCurrentMonth> getProjectInboundCurrentMonth(Long workshopId, Long productionId) {
      return this.baseMapper.getProjectInboundCurrentMonth(workshopId, productionId);
   }

   @Override
   public List<ProjectProductDTO> getEnclosureCompleteDetails(Long areaId) {
      return this.baseMapper.getEnclosureCompleteDetails(areaId);
   }

   @Override
   public List<DateAndMeteDTO> getAccumulatedCompleteMeteByDate(List<String> dateStrList, String dateQueryFormat, Long factoryId, Long workshopId, Long teamId) {
      return this.baseMapper.getAccumulatedCompleteMeteByDate(dateStrList, dateQueryFormat, factoryId, workshopId, teamId);
   }

   @Override
   public BigDecimal getYearAccumulatedCompleteMete(String dateQueryTypeEnum, Long workshopId, Long teamId) {
      return this.baseMapper.getYearAccumulatedCompleteMete(dateQueryTypeEnum, workshopId, teamId);
   }
}
