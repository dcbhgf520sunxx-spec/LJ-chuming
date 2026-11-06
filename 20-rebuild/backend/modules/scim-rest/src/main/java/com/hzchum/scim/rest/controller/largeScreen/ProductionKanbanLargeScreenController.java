package com.hzchum.scim.rest.controller.largeScreen;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ContractTech;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractTechService;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.QhseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseTypeProductReturnEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoList;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhse;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.InspectRealtimeInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskProcessInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingTeamQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingTaskProcessQuery;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.rest.pojo.request.large_screen.KanbanQuery;
import com.hzchum.scim.system.core.api.pojo._do.MesQualityClassConfig;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.BranchCompanySimpleVO;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.MesQualityClassConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "生产看板大屏")
@RestController
@RequestMapping("/api/large-screen/production-kanban")
public class ProductionKanbanLargeScreenController {
   private static final Logger log = LoggerFactory.getLogger(ProductionKanbanLargeScreenController.class);
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Autowired
   private MesBuildingTeamService teamService;
   @Autowired
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Autowired
   private ContractTechService contractTechService;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesBuildingCargoListService cargoListService;
   @Autowired
   private MesBuildingQhseService qhseService;
   @Autowired
   private MesQualityClassConfigService qualityClassConfigService;
   @Autowired
   private MesBuildingTaskOrderService taskOrderService;
   @Autowired
   private InitializationService initializationService;
   @Autowired
   private UserService userService;
   @Autowired
   private BranchCompanyService branchCompanyService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingWarehouseRecordService warehouseRecordService;

   @ApiOperation("分支机构列表")
   @GetMapping("branch_company/list")
   public ResultVO branchCompanyList() {
      return ResultBuilder.success(BeanUtil.copyToList(this.branchCompanyService.list(), BranchCompanySimpleVO.class));
   }

   @ApiOperation("车间列表")
   @GetMapping("/workshop/list")
   public ResultVO workshopList() {
      log.info("API 调用 ：获取车间列表");
      return ResultBuilder.success(BeanUtil.copyToList(this.workshopService.list(), ShowInfo.class));
   }

   private List<YearMonth> getLast12Months() {
      List<YearMonth> months = new ArrayList<>();
      YearMonth current = YearMonth.now();

      for (int i = 11; i >= 0; i--) {
         months.add(current.minusMonths(i));
      }

      return months;
   }

   private List<LocalDate> getLast31Days() {
      List<LocalDate> days = new ArrayList<>();
      LocalDate today = LocalDate.now();

      for (int i = 30; i >= 0; i--) {
         days.add(today.minusDays(i));
      }

      return days;
   }

   @ApiOperation("顶部数据")
   @GetMapping("top-data")
   public ResultVO topData(KanbanQuery query) {
      log.info("API调用: 生产看板大屏-顶部数据");
      List<ContractProject> projectList = this.projectService
         .lambdaQuery()
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", query.getYear())
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .list();
      JSONObject result = JSONUtil.createObj(JSONConfig.create().setIgnoreNullValue(false));
      if (CollUtil.isEmpty(projectList)) {
         return ResultBuilder.success(result);
      }

      List<Long> projectIdList = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      int projectTotalQuantity = projectList.size();
      long projectCompletedQuantity = projectList.stream().filter(p -> Objects.equals(p.getStatus(), 4)).count();
      List<MesBuildingTask> thisYearTaskList = this.taskService
         .lambdaQuery()
         .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
         .eq(query.getWorkshopId() != null, MesBuildingTask::getWorkshopId, query.getWorkshopId())
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", LocalDate.now().getYear())
         .in(MesBuildingTask::getProjectId, projectIdList)
         .list();
      List<Long> thisYearArtifactIdList = thisYearTaskList.stream().map(MesBuildingTask::getProductId).distinct().collect(Collectors.toList());
      Map<Long, TechArtifact> thisYearArtifactMap = Optional.of(thisYearArtifactIdList)
         .filter(CollUtil::isNotEmpty)
         .map(this.artifactService::listByIds)
         .orElseGet(Collections::emptyList)
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      BigDecimal thisYearCompletionVolume = thisYearTaskList.stream().map(task -> {
         TechArtifact artifact = thisYearArtifactMap.get(task.getProductId());
         return BeanUtil.isNotEmpty(artifact) ? BigDecimal.valueOf(task.getCompleteQuantity().intValue()).multiply(artifact.getNetWeight()) : BigDecimal.ZERO;
      }).reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP);
      BigDecimal thisYearTaskVolume = thisYearTaskList.stream().map(task -> {
         TechArtifact artifact = thisYearArtifactMap.get(task.getProductId());
         return BeanUtil.isNotEmpty(artifact) ? BigDecimal.valueOf(task.getTaskQuantity().intValue()).multiply(artifact.getNetWeight()) : BigDecimal.ZERO;
      }).reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP);
      BigDecimal thisYearTaskAverageAchievementRate = Optional.of(thisYearTaskVolume)
         .filter(o -> o.compareTo(BigDecimal.ZERO) != 0)
         .map(o -> thisYearCompletionVolume.divide(o, 4, RoundingMode.HALF_UP))
         .orElse(BigDecimal.ZERO);
      List<MesBuildingTask> thisMonthTaskList = this.taskService
         .lambdaQuery()
         .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
         .eq(query.getWorkshopId() != null, MesBuildingTask::getWorkshopId, query.getWorkshopId())
         .apply("DATE_FORMAT(create_time, '%Y-%m') = {0}", LocalDate.now().format(DatePattern.NORM_MONTH_FORMATTER))
         .in(MesBuildingTask::getProjectId, projectIdList)
         .list();
      int thisMonthTaskQuantity = thisMonthTaskList.size();
      List<Long> thisMonthArtifactIdList = thisMonthTaskList.stream().map(MesBuildingTask::getProductId).distinct().collect(Collectors.toList());
      Map<Long, TechArtifact> thisMonthArtifactMap = Optional.of(thisMonthArtifactIdList)
         .filter(CollUtil::isNotEmpty)
         .map(this.artifactService::listByIds)
         .orElseGet(Collections::emptyList)
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      BigDecimal thisMonthTaskVolume = thisMonthTaskList.stream().map(task -> {
         TechArtifact artifact = thisMonthArtifactMap.get(task.getProductId());
         return BeanUtil.isNotEmpty(artifact) ? BigDecimal.valueOf(task.getTaskQuantity().intValue()).multiply(artifact.getNetWeight()) : BigDecimal.ZERO;
      }).reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP);
      result.set("projectTotalQuantity", projectTotalQuantity);
      result.set("projectCompletedQuantity", projectCompletedQuantity);
      result.set("thisYearCompletionVolume", thisYearCompletionVolume);
      result.set("thisMonthTaskQuantity", thisMonthTaskQuantity);
      result.set("thisMonthTaskVolume", thisMonthTaskVolume);
      result.set("thisYearTaskAverageAchievementRate", thisYearTaskAverageAchievementRate);
      return ResultBuilder.success(result);
   }

   @ApiOperation("近12个月车间产量统计")
   @GetMapping("last-12-month-workshop-production-volume-statistics")
   public ResultVO last12MonthWorkshopProductionVolumeStatistics(KanbanQuery query) {
      log.info("API调用: 生产看板大屏-近12个月车间生产量统计");
      List<ContractProject> projectList = this.projectService
         .lambdaQuery()
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", query.getYear())
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .list();
      if (CollUtil.isEmpty(projectList)) {
         return ResultBuilder.success(Collections.emptyList());
      }

      List<Long> projectIdList = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      List<YearMonth> yearMonthList = this.getLast12Months();
      List<MesBuildingWarehouseRecord> warehouseRecordList = this.warehouseRecordService
         .lambdaQuery()
         .in(MesBuildingWarehouseRecord::getProjectId, projectIdList)
         .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType())
         .eq(MesBuildingWarehouseRecord::getType, 1)
         .eq(MesBuildingWarehouseRecord::getWarehouseType, WarehouseTypeProductReturnEnum.NORMAL.getType())
         .eq(query.getWorkshopId() != null, MesBuildingWarehouseRecord::getWorkshopId, query.getWorkshopId())
         .apply("DATE_FORMAT(create_time, '%Y-%m') >= {0}", CollUtil.getFirst(yearMonthList))
         .apply("DATE_FORMAT(create_time, '%Y-%m') <= {0}", CollUtil.getLast(yearMonthList))
         .list();
      List<Long> atrifactIdList = warehouseRecordList.stream().map(MesBuildingWarehouseRecord::getProductId).distinct().collect(Collectors.toList());
      Map<Long, TechArtifact> artifactMap = Optional.of(atrifactIdList)
         .filter(CollUtil::isNotEmpty)
         .map(this.artifactService::listByIds)
         .orElseGet(Collections::emptyList)
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      Map<String, BigDecimal> monthProductionVolumeMap = warehouseRecordList.stream()
         .collect(Collectors.toMap(k -> k.getCreateTime().format(DatePattern.NORM_MONTH_FORMATTER), v -> {
            TechArtifact artifact = artifactMap.get(v.getProductId());
            return BeanUtil.isNotEmpty(artifact) ? v.getQuantity().multiply(artifact.getNetWeight()) : BigDecimal.ZERO;
         }, BigDecimal::add));
      List<JSONObject> resultList = yearMonthList.stream()
         .map(
            yearMonth -> JSONUtil.createObj(JSONConfig.create().setIgnoreNullValue(false))
               .set("yearMonth", yearMonth.format(DateTimeFormatter.ofPattern("yy/MM")))
               .set(
                  "productionVolume",
                  monthProductionVolumeMap.getOrDefault(yearMonth.toString(), BigDecimal.ZERO).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP)
               )
         )
         .collect(Collectors.toList());
      return ResultBuilder.success(resultList);
   }

   @ApiOperation("近31日车间日产量统计")
   @GetMapping("last-31-day-workshop-daily-production-volume-statistics")
   public ResultVO last31DayWorkshopDailyProductionVolumeStatistics(KanbanQuery query) {
      log.info("API调用: 生产看板大屏-近31日车间日产量统计");
      List<ContractProject> projectList = this.projectService
         .lambdaQuery()
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", query.getYear())
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .list();
      if (CollUtil.isEmpty(projectList)) {
         return ResultBuilder.success(Collections.emptyList());
      }

      List<Long> projectIdList = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      List<LocalDate> dateList = this.getLast31Days();
      List<MesBuildingWarehouseRecord> warehouseRecordList = this.warehouseRecordService
         .lambdaQuery()
         .in(MesBuildingWarehouseRecord::getProjectId, projectIdList)
         .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType())
         .eq(MesBuildingWarehouseRecord::getType, 1)
         .eq(MesBuildingWarehouseRecord::getWarehouseType, WarehouseTypeProductReturnEnum.NORMAL.getType())
         .eq(query.getWorkshopId() != null, MesBuildingWarehouseRecord::getWorkshopId, query.getWorkshopId())
         .apply("DATE_FORMAT(create_time, '%Y-%m-%d') >= {0}", CollUtil.getFirst(dateList))
         .apply("DATE_FORMAT(create_time, '%Y-%m-%d') <= {0}", CollUtil.getLast(dateList))
         .list();
      List<Long> atrifactIdList = warehouseRecordList.stream().map(MesBuildingWarehouseRecord::getProductId).distinct().collect(Collectors.toList());
      Map<Long, TechArtifact> artifactMap = Optional.of(atrifactIdList)
         .filter(CollUtil::isNotEmpty)
         .map(this.artifactService::listByIds)
         .orElseGet(Collections::emptyList)
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      Map<String, BigDecimal> monthProductionVolumeMap = warehouseRecordList.stream()
         .collect(Collectors.toMap(k -> k.getCreateTime().format(DatePattern.NORM_DATE_FORMATTER), v -> {
            TechArtifact artifact = artifactMap.get(v.getProductId());
            return BeanUtil.isNotEmpty(artifact) ? v.getQuantity().multiply(artifact.getNetWeight()) : BigDecimal.ZERO;
         }, BigDecimal::add));
      List<JSONObject> resultList = dateList.stream()
         .map(
            date -> JSONUtil.createObj(JSONConfig.create().setIgnoreNullValue(false))
               .set("date", date.format(DateTimeFormatter.ofPattern("MM/dd")))
               .set(
                  "productionVolume",
                  monthProductionVolumeMap.getOrDefault(date.toString(), BigDecimal.ZERO).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP)
               )
         )
         .collect(Collectors.toList());
      return ResultBuilder.success(resultList);
   }

   @ApiOperation("当日班组产量统计")
   @GetMapping("today-team-production-volume-statistics")
   public ResultVO todayTeamProductionVolumeStatistics(KanbanQuery query) {
      log.info("API调用: 生产看板大屏-当日班组产量统计");
      List<ContractProject> projectList = this.projectService
         .lambdaQuery()
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", query.getYear())
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .list();
      if (CollUtil.isEmpty(projectList)) {
         return ResultBuilder.success(Collections.emptyList());
      }

      List<Long> projectIdList = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      List<MesBuildingTeamInfoDTO> teamInfoList = this.teamService.listInfo(MesBuildingTeamQuery.builder().workshopId(query.getWorkshopId()).build());
      List<MesBuildingProduceTeamReport> produceTeamReportList = this.produceTeamReportService
         .lambdaQuery()
         .in(MesBuildingProduceTeamReport::getProjectId, projectIdList)
         .eq(query.getWorkshopId() != null, MesBuildingProduceTeamReport::getWorkshopId, query.getWorkshopId())
         .apply("inspection_in_year_month_date = {0}", YearMonth.now())
         .list();
      List<Long> artifactIdList = produceTeamReportList.stream()
         .filter(ptr -> Objects.equals(ptr.getTaskTypeEnum(), TaskTypeEnum.ARTIFACT.getType()))
         .map(MesBuildingProduceTeamReport::getProductId)
         .distinct()
         .collect(Collectors.toList());
      List<TechArtifact> artifactList = Optional.of(artifactIdList)
         .filter(CollUtil::isNotEmpty)
         .map(this.artifactService::listByIds)
         .orElseGet(Collections::emptyList);
      Map<Long, TechArtifact> artifactMap = artifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      List<Long> assembleIdList = produceTeamReportList.stream()
         .filter(ptr -> Objects.equals(ptr.getTaskTypeEnum(), TaskTypeEnum.ASSEMBLE.getType()))
         .map(MesBuildingProduceTeamReport::getProductId)
         .distinct()
         .collect(Collectors.toList());
      List<TechAssemble> assembleList = Optional.of(assembleIdList)
         .filter(CollUtil::isNotEmpty)
         .map(this.assembleService::listByIds)
         .orElseGet(Collections::emptyList);
      Map<Long, TechAssemble> assembleMap = assembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
      List<Long> machinePartIdList = produceTeamReportList.stream()
         .filter(ptr -> Objects.equals(ptr.getTaskTypeEnum(), TaskTypeEnum.MACHINE_PART.getType()))
         .map(MesBuildingProduceTeamReport::getProductId)
         .distinct()
         .collect(Collectors.toList());
      List<TechMachinePart> machinePartList = Optional.of(machinePartIdList)
         .filter(CollUtil::isNotEmpty)
         .map(this.machinePartService::listByIds)
         .orElseGet(Collections::emptyList);
      Map<Long, TechMachinePart> machinePartMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      Map<Long, BigDecimal> thisMonthProductionVolumeMap = produceTeamReportList.stream()
         .collect(Collectors.toMap(MesBuildingProduceTeamReport::getTeamId, v -> {
            BigDecimal productionVolume = BigDecimal.ZERO;
            if (Objects.equals(v.getTaskTypeEnum(), TaskTypeEnum.ARTIFACT.getType())) {
               TechArtifact artifact = artifactMap.get(v.getProductId());
               if (BeanUtil.isNotEmpty(artifact)) {
                  productionVolume = BigDecimal.valueOf(v.getInspectionQuantity().intValue()).multiply(artifact.getNetWeight());
               }
            }

            if (Objects.equals(v.getTaskTypeEnum(), TaskTypeEnum.ASSEMBLE.getType())) {
               TechAssemble assemble = assembleMap.get(v.getProductId());
               if (BeanUtil.isNotEmpty(assemble)) {
                  productionVolume = BigDecimal.valueOf(v.getInspectionQuantity().intValue()).multiply(assemble.getNetWeight());
               }
            }

            if (Objects.equals(v.getTaskTypeEnum(), TaskTypeEnum.MACHINE_PART.getType())) {
               TechMachinePart machinePart = machinePartMap.get(v.getProductId());
               if (BeanUtil.isNotEmpty(machinePart)) {
                  productionVolume = BigDecimal.valueOf(v.getInspectionQuantity().intValue()).multiply(machinePart.getNetWeight());
               }
            }

            return productionVolume;
         }, BigDecimal::add));
      Map<Long, BigDecimal> todayProductionVolumeMap = produceTeamReportList.stream()
         .filter(ptr -> Objects.equals(ptr.getInspectionInYearMonthDayDate(), LocalDate.now().toString()))
         .collect(Collectors.toMap(MesBuildingProduceTeamReport::getTeamId, v -> {
            BigDecimal productionVolume = BigDecimal.ZERO;
            if (Objects.equals(v.getTaskTypeEnum(), TaskTypeEnum.ARTIFACT.getType())) {
               TechArtifact artifact = artifactMap.get(v.getProductId());
               if (BeanUtil.isNotEmpty(artifact)) {
                  productionVolume = BigDecimal.valueOf(v.getInspectionQuantity().intValue()).multiply(artifact.getNetWeight());
               }
            }

            if (Objects.equals(v.getTaskTypeEnum(), TaskTypeEnum.ASSEMBLE.getType())) {
               TechAssemble assemble = assembleMap.get(v.getProductId());
               if (BeanUtil.isNotEmpty(assemble)) {
                  productionVolume = BigDecimal.valueOf(v.getInspectionQuantity().intValue()).multiply(assemble.getNetWeight());
               }
            }

            if (Objects.equals(v.getTaskTypeEnum(), TaskTypeEnum.MACHINE_PART.getType())) {
               TechMachinePart machinePart = machinePartMap.get(v.getProductId());
               if (BeanUtil.isNotEmpty(machinePart)) {
                  productionVolume = BigDecimal.valueOf(v.getInspectionQuantity().intValue()).multiply(machinePart.getNetWeight());
               }
            }

            return productionVolume;
         }, BigDecimal::add));
      List<JSONObject> resultList = teamInfoList.stream()
         .map(
            teamInfo -> JSONUtil.createObj(JSONConfig.create().setIgnoreNullValue(false))
               .set("teamId", teamInfo.getId())
               .set("processName", teamInfo.getProcess().getName())
               .set("teamName", teamInfo.getName())
               .set(
                  "todayProductionVolume",
                  todayProductionVolumeMap.getOrDefault(teamInfo.getId(), BigDecimal.ZERO).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP)
               )
               .set(
                  "thisMonthProductionVolume",
                  thisMonthProductionVolumeMap.getOrDefault(teamInfo.getId(), BigDecimal.ZERO).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP)
               )
         )
         .collect(Collectors.toList());
      return ResultBuilder.success(resultList);
   }

   @ApiOperation("班组平均能力")
   @GetMapping("team-average-ability")
   public ResultVO teamAverageAbility(KanbanQuery query) {
      log.info("API调用: 生产看板大屏-班组平均能力");
      List<ContractProject> projectList = this.projectService
         .lambdaQuery()
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", query.getYear())
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .list();
      if (CollUtil.isEmpty(projectList)) {
         return ResultBuilder.success(Collections.emptyList());
      }

      List<Long> projectIdList = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      List<MesBuildingTeamInfoDTO> teamInfoList = this.teamService.listInfo(MesBuildingTeamQuery.builder().workshopId(query.getWorkshopId()).build());
      List<MesBuildingProduceTeamReport> produceTeamReportList = this.produceTeamReportService
         .lambdaQuery()
         .in(MesBuildingProduceTeamReport::getProjectId, projectIdList)
         .eq(query.getWorkshopId() != null, MesBuildingProduceTeamReport::getWorkshopId, query.getWorkshopId())
         .apply("YEAR(create_time) = {0}", YearMonth.now().getYear())
         .list();
      List<Long> artifactIdList = produceTeamReportList.stream()
         .filter(ptr -> Objects.equals(ptr.getTaskTypeEnum(), TaskTypeEnum.ARTIFACT.getType()))
         .map(MesBuildingProduceTeamReport::getProductId)
         .distinct()
         .collect(Collectors.toList());
      List<TechArtifact> artifactList = Optional.of(artifactIdList)
         .filter(CollUtil::isNotEmpty)
         .map(this.artifactService::listByIds)
         .orElseGet(Collections::emptyList);
      Map<Long, TechArtifact> artifactMap = artifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      List<Long> assembleIdList = produceTeamReportList.stream()
         .filter(ptr -> Objects.equals(ptr.getTaskTypeEnum(), TaskTypeEnum.ASSEMBLE.getType()))
         .map(MesBuildingProduceTeamReport::getProductId)
         .distinct()
         .collect(Collectors.toList());
      List<TechAssemble> assembleList = Optional.of(assembleIdList)
         .filter(CollUtil::isNotEmpty)
         .map(this.assembleService::listByIds)
         .orElseGet(Collections::emptyList);
      Map<Long, TechAssemble> assembleMap = assembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
      List<Long> machinePartIdList = produceTeamReportList.stream()
         .filter(ptr -> Objects.equals(ptr.getTaskTypeEnum(), TaskTypeEnum.MACHINE_PART.getType()))
         .map(MesBuildingProduceTeamReport::getProductId)
         .distinct()
         .collect(Collectors.toList());
      List<TechMachinePart> machinePartList = Optional.of(machinePartIdList)
         .filter(CollUtil::isNotEmpty)
         .map(this.machinePartService::listByIds)
         .orElseGet(Collections::emptyList);
      Map<Long, TechMachinePart> machinePartMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      Map<Long, BigDecimal> thisYearProductionVolumeMap = produceTeamReportList.stream()
         .collect(Collectors.toMap(MesBuildingProduceTeamReport::getTeamId, v -> {
            BigDecimal productionVolume = BigDecimal.ZERO;
            if (Objects.equals(v.getTaskTypeEnum(), TaskTypeEnum.ARTIFACT.getType())) {
               TechArtifact artifact = artifactMap.get(v.getProductId());
               if (BeanUtil.isNotEmpty(artifact)) {
                  productionVolume = BigDecimal.valueOf(v.getInspectionQuantity().intValue()).multiply(artifact.getNetWeight());
               }
            }

            if (Objects.equals(v.getTaskTypeEnum(), TaskTypeEnum.ASSEMBLE.getType())) {
               TechAssemble assemble = assembleMap.get(v.getProductId());
               if (BeanUtil.isNotEmpty(assemble)) {
                  productionVolume = BigDecimal.valueOf(v.getInspectionQuantity().intValue()).multiply(assemble.getNetWeight());
               }
            }

            if (Objects.equals(v.getTaskTypeEnum(), TaskTypeEnum.MACHINE_PART.getType())) {
               TechMachinePart machinePart = machinePartMap.get(v.getProductId());
               if (BeanUtil.isNotEmpty(machinePart)) {
                  productionVolume = BigDecimal.valueOf(v.getInspectionQuantity().intValue()).multiply(machinePart.getNetWeight());
               }
            }

            return productionVolume;
         }, BigDecimal::add));
      int monthValue = YearMonth.now().getMonthValue();
      List<JSONObject> resultList = teamInfoList.stream()
         .map(
            teamInfo -> {
               BigDecimal thisYearProductionVolume = thisYearProductionVolumeMap.getOrDefault(teamInfo.getId(), BigDecimal.ZERO)
                  .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
               BigDecimal monthAverageAbility = NumberUtil.div(thisYearProductionVolume, monthValue, 2);
               return JSONUtil.createObj(JSONConfig.create().setIgnoreNullValue(false))
                  .set("teamId", teamInfo.getId())
                  .set("processName", teamInfo.getProcess().getName())
                  .set("teamName", teamInfo.getName())
                  .set("thisYearProductionVolume", thisYearProductionVolume)
                  .set("monthAverageAbility", monthAverageAbility);
            }
         )
         .collect(Collectors.toList());
      return ResultBuilder.success(resultList);
   }

   @ApiOperation("项目执行动态")
   @GetMapping("project-execution-dynamic")
   public ResultVO projectExecutionDynamic(KanbanQuery query) {
      log.info("API调用: 生产看板大屏-项目执行动态");
      List<ContractProject> projectList = this.projectService
         .lambdaQuery()
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", query.getYear())
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .list();
      if (CollUtil.isEmpty(projectList)) {
         return ResultBuilder.success(Collections.emptyList());
      }

      List<Long> projectIdList = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      List<ContractTech> contractTechList = this.contractTechService
         .lambdaQuery()
         .in(ContractTech::getProjectId, projectIdList)
         .eq(ContractTech::getCategoryType, 2)
         .list();
      Map<Long, BigDecimal> contractVolumeMap = contractTechList.stream()
         .collect(
            Collectors.groupingBy(
               ContractTech::getProjectId,
               Collectors.collectingAndThen(
                  Collectors.reducing(BigDecimal.ZERO, ContractTech::getQuantityWork, BigDecimal::add),
                  v -> v.divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP)
               )
            )
         );
      List<TechArtifact> artifactList = Optional.of(projectIdList)
         .filter(CollUtil::isNotEmpty)
         .map(o -> this.artifactService.lambdaQuery().in(TechArtifact::getProjectId, o).list())
         .orElseGet(Collections::emptyList);
      Map<Long, List<TechArtifact>> artifactGroup = artifactList.stream().collect(Collectors.groupingBy(TechArtifact::getProjectId));
      List<TechAssemble> assembleList = Optional.of(projectIdList)
         .filter(CollUtil::isNotEmpty)
         .map(o -> this.assembleService.lambdaQuery().in(TechAssemble::getProjectId, o).list())
         .orElseGet(Collections::emptyList);
      Map<Long, List<TechAssemble>> assembleGroup = assembleList.stream().collect(Collectors.groupingBy(TechAssemble::getProjectId));
      List<TechMachinePart> machinePartList = Optional.of(projectIdList)
         .filter(CollUtil::isNotEmpty)
         .map(o -> this.machinePartService.lambdaQuery().in(TechMachinePart::getProjectId, o).list())
         .orElseGet(Collections::emptyList);
      Map<Long, List<TechMachinePart>> machinePartGroup = machinePartList.stream().collect(Collectors.groupingBy(TechMachinePart::getProjectId));
      List<MesBuildingWarehouseSummary> warehouseSummaryList = this.warehouseSummaryService
         .lambdaQuery()
         .in(MesBuildingWarehouseSummary::getProjectId, projectIdList)
         .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ARTIFACT.getType())
         .eq(MesBuildingWarehouseSummary::getType, 2)
         .eq(MesBuildingWarehouseSummary::getWarehouseType, WarehouseTypeProductReturnEnum.NORMAL.getType())
         .list();
      Map<Long, List<MesBuildingWarehouseSummary>> warehouseSummaryGroup = warehouseSummaryList.stream()
         .collect(Collectors.groupingBy(MesBuildingWarehouseSummary::getProjectId));
      List<JSONObject> resultList = projectList.stream()
         .map(
            project -> {
               BigDecimal contractVolume = contractVolumeMap.getOrDefault(project.getId(), BigDecimal.ZERO);
               List<TechArtifact> cArtifactList = artifactGroup.getOrDefault(project.getId(), Collections.emptyList());
               Map<Long, TechArtifact> cArtifactMap = cArtifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
               BigDecimal deepeningVolume = cArtifactList.stream()
                  .map(product -> product.getNetWeight().multiply(BigDecimal.valueOf(product.getProducedQuantity().intValue())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
                  .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
               BigDecimal deepening = Optional.of(contractVolume)
                  .filter(o -> ObjectUtil.notEqual(o, BigDecimal.ZERO))
                  .map(o -> deepeningVolume.divide(o, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L)))
                  .orElse(BigDecimal.ZERO);
               List<TechMachinePart> cMachinePartList = machinePartGroup.getOrDefault(project.getId(), Collections.emptyList());
               BigDecimal machinePartVolume = cMachinePartList.stream()
                  .map(mp -> mp.getNetWeight().multiply(BigDecimal.valueOf(mp.getQuantity().intValue())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
                  .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
               BigDecimal machinePartProducedVolume = cMachinePartList.stream()
                  .map(mp -> mp.getNetWeight().multiply(BigDecimal.valueOf(mp.getProducedQuantity().intValue())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
                  .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
               BigDecimal machinePart = Optional.of(machinePartVolume)
                  .filter(o -> ObjectUtil.notEqual(o, BigDecimal.ZERO))
                  .map(o -> machinePartProducedVolume.divide(o, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L)))
                  .orElse(BigDecimal.ZERO);
               List<TechAssemble> cAssembleList = assembleGroup.getOrDefault(project.getId(), Collections.emptyList());
               BigDecimal assembleVolume = cAssembleList.stream()
                  .map(a -> a.getNetWeight().multiply(BigDecimal.valueOf(a.getQuantity().intValue())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
                  .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
               BigDecimal assembleProducedVolume = cAssembleList.stream()
                  .map(a -> a.getNetWeight().multiply(BigDecimal.valueOf(a.getProducedQuantity().intValue())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
                  .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
               BigDecimal assemble = Optional.of(assembleVolume)
                  .filter(o -> ObjectUtil.notEqual(o, BigDecimal.ZERO))
                  .map(o -> assembleProducedVolume.divide(o, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L)))
                  .orElse(BigDecimal.ZERO);
               BigDecimal artifactVolume = cArtifactList.stream()
                  .map(a -> a.getNetWeight().multiply(BigDecimal.valueOf(a.getQuantity().intValue())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
                  .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
               BigDecimal artifactProducedVolume = cArtifactList.stream()
                  .map(a -> a.getNetWeight().multiply(BigDecimal.valueOf(a.getProducedQuantity().intValue())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
                  .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
               BigDecimal artifact = Optional.of(artifactVolume)
                  .filter(o -> ObjectUtil.notEqual(o, BigDecimal.ZERO))
                  .map(o -> artifactProducedVolume.divide(o, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L)))
                  .orElse(BigDecimal.ZERO);
               List<MesBuildingWarehouseSummary> cWarehouseSummaryList = warehouseSummaryGroup.getOrDefault(project.getId(), Collections.emptyList());
               BigDecimal shippedVolume = cWarehouseSummaryList.stream().map(ws -> {
                  TechArtifact cArtifact = cArtifactMap.getOrDefault(ws.getProductId(), new TechArtifact());
                  return ObjectUtil.defaultIfNull(cArtifact.getNetWeight(), BigDecimal.ZERO).multiply(ws.getQuantity());
               }).reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
               BigDecimal shipped = Optional.of(artifactVolume)
                  .filter(o -> ObjectUtil.notEqual(o, BigDecimal.ZERO))
                  .map(o -> shippedVolume.divide(o, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L)))
                  .orElse(BigDecimal.ZERO);
               if (shipped.compareTo(BigDecimal.valueOf(100L)) == 0) {
                  MesBuildingCargoList cargoList = this.cargoListService
                     .lambdaQuery()
                     .eq(MesBuildingCargoList::getProjectId, project.getId())
                     .in(MesBuildingCargoList::getStatus, 4, 8)
                     .orderByDesc(MesBuildingCargoList::getAuditTime)
                     .last("LIMIT 1")
                     .one();
                  if (cargoList != null && cargoList.getAuditTime().plusHours(12L).isBefore(LocalDateTime.now())) {
                     return null;
                  }
               }

               return JSONUtil.createObj(JSONConfig.create().setIgnoreNullValue(false))
                  .set("projectId", project.getId())
                  .set("projectName", project.getName())
                  .set("projectShortName", project.getShortName())
                  .set("projectSerialNumber", project.getSerialNumber())
                  .set("contractVolume", contractVolume)
                  .set("deepening", deepening)
                  .set("machinePart", machinePart)
                  .set("assemble", assemble)
                  .set("artifact", artifact)
                  .set("shipped", shipped);
            }
         )
         .filter(ObjectUtil::isNotNull)
         .collect(Collectors.toList());
      return ResultBuilder.success(resultList);
   }

   @ApiOperation("工序工单执行动态")
   @GetMapping("process-work-order-execution-dynamic")
   public ResultVO processWorkOrderExecutionDynamic(KanbanQuery query) {
      log.info("API调用: 生产看板大屏-工序工单执行动态");
      List<ContractProject> projectList = this.projectService
         .lambdaQuery()
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", query.getYear())
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .list();
      if (CollUtil.isEmpty(projectList)) {
         return ResultBuilder.success(Collections.emptyList());
      }

      List<Long> projectIdList = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      List<MesBuildingTaskProcessInfoDTO> taskProcessInfoDTOList = this.taskProcessService
         .listInfo(MesBuildingTaskProcessQuery.builder().projectIdList(projectIdList).workshopId(query.getWorkshopId()).build());
      List<JSONObject> resultList = taskProcessInfoDTOList.stream()
         .collect(Collectors.groupingBy(k -> k.getProjectId() + "&" + k.getTaskOrderId() + "&" + k.getProcessId() + "&" + k.getTeamId() + "&"))
         .values()
         .stream()
         .map(
            mesBuildingTaskProcessInfoDTOS -> {
               MesBuildingTaskProcessInfoDTO taskProcessInfoDTO = mesBuildingTaskProcessInfoDTOS.get(0);
               Integer taskQuantity = mesBuildingTaskProcessInfoDTOS.stream().map(MesBuildingTaskProcess::getTaskQuantity).reduce(0, Integer::sum);
               Integer completedQuantity = mesBuildingTaskProcessInfoDTOS.stream().map(MesBuildingTaskProcess::getInspectionQuantity).reduce(0, Integer::sum);
               BigDecimal completionRate = Optional.of(taskQuantity)
                  .filter(o -> ObjectUtil.notEqual(o, 0))
                  .map(
                     o -> BigDecimal.valueOf(completedQuantity.intValue())
                        .divide(BigDecimal.valueOf(o.intValue()), 4, RoundingMode.HALF_UP)
                        .multiply(BigDecimal.valueOf(100L))
                  )
                  .orElse(BigDecimal.ZERO);
               if (completionRate.compareTo(BigDecimal.valueOf(100L)) == 0) {
                  LocalDateTime maxCompleteTime = mesBuildingTaskProcessInfoDTOS.stream()
                     .map(MesBuildingTaskProcess::getCompleteTime)
                     .filter(ObjectUtil::isNotNull)
                     .max(Comparator.naturalOrder())
                     .orElse(LocalDateTime.now());
                  if (maxCompleteTime.plusHours(12L).isBefore(LocalDateTime.now())) {
                     return null;
                  }
               }

               return JSONUtil.createObj(JSONConfig.create().setIgnoreNullValue(false))
                  .set("projectId", taskProcessInfoDTO.getProject().getId())
                  .set("projectName", taskProcessInfoDTO.getProject().getName())
                  .set("projectShortName", taskProcessInfoDTO.getProject().getShortName())
                  .set("projectSerialNumber", taskProcessInfoDTO.getProject().getSerialNumber())
                  .set("taskOrderId", taskProcessInfoDTO.getTaskOrder().getId())
                  .set("taskOrderOrderNumber", taskProcessInfoDTO.getTaskOrder().getOrderNumber())
                  .set("processId", taskProcessInfoDTO.getProcess().getId())
                  .set("processName", taskProcessInfoDTO.getProcess().getName())
                  .set("teamId", taskProcessInfoDTO.getTeam().getId())
                  .set("teamName", taskProcessInfoDTO.getTeam().getName())
                  .set("taskQuantity", taskQuantity)
                  .set("completedQuantity", completedQuantity)
                  .set("completionRate", completionRate);
            }
         )
         .filter(ObjectUtil::isNotNull)
         .collect(Collectors.toList());
      return ResultBuilder.success(resultList);
   }

   @ApiOperation("年度质量事件分析")
   @GetMapping("year-quality-event-analysis")
   public ResultVO yearQualityEventAnalysis(KanbanQuery query) {
      log.info("API调用: 生产看板大屏-年度质量事件分析");
      List<ContractProject> projectList = this.projectService
         .lambdaQuery()
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", query.getYear())
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .list();
      if (CollUtil.isEmpty(projectList)) {
         return ResultBuilder.success(Collections.emptyList());
      }

      List<Long> projectIdList = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      List<MesBuildingQhse> qhseList = this.qhseService
         .lambdaQuery()
         .in(MesBuildingQhse::getProjectId, projectIdList)
         .eq(query.getWorkshopId() != null, MesBuildingQhse::getWorkshopId, query.getWorkshopId())
         .apply("YEAR(create_time) = {0}", YearMonth.now().getYear())
         .apply("type & {0}", QhseTypeEnum.QUALITY.getType() | QhseTypeEnum.SPECIAL_QUALITY.getType())
         .list();
      if (CollUtil.isEmpty(qhseList)) {
         return ResultBuilder.success(Collections.emptyList());
      }

      Map<Long, Integer> qhseQuantityMap = qhseList.stream()
         .filter(qhse -> ObjectUtil.isNotNull(qhse.getLevelTwoType()))
         .collect(Collectors.toMap(MesBuildingQhse::getLevelTwoType, v -> ObjectUtil.defaultIfNull(v.getProblemQuantity(), 0), Integer::sum));
      Map<Long, MesQualityClassConfig> qualityClassConfigMap = Optional.of(qhseQuantityMap.keySet())
         .filter(CollUtil::isNotEmpty)
         .map(this.qualityClassConfigService::listByIds)
         .orElseGet(Collections::emptyList)
         .stream()
         .collect(Collectors.toMap(MesQualityClassConfig::getId, Function.identity()));
      JSONObject result = JSONUtil.createObj(JSONConfig.create().setIgnoreNullValue(false));
      qhseQuantityMap.forEach((k, v) -> {
         MesQualityClassConfig qualityClassConfig = qualityClassConfigMap.get(k);
         if (BeanUtil.isNotEmpty(qualityClassConfig)) {
            result.set(qualityClassConfig.getName(), v);
         } else if (result.containsKey("其他问题")) {
            Integer otherProblemQuantity = result.getInt("其他问题");
            result.set("其他问题", v + otherProblemQuantity);
         } else {
            result.set("其他问题", v);
         }
      });
      List<JSONObject> resultList = new ArrayList<>();
      result.forEach((k, v) -> resultList.add(JSONUtil.createObj(JSONConfig.create().setIgnoreNullValue(false)).set("problem", k).set("quantity", v)));
      return ResultBuilder.success(resultList);
   }

   @ApiOperation("班组质量问题排名")
   @GetMapping("team-quality-problem-ranking")
   public ResultVO teamQualityProblemRanking(KanbanQuery query) {
      log.info("API调用: 生产看板大屏-班组质量问题排名");
      List<ContractProject> projectList = this.projectService
         .lambdaQuery()
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", query.getYear())
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .list();
      if (CollUtil.isEmpty(projectList)) {
         return ResultBuilder.success(Collections.emptyList());
      }

      List<Long> projectIdList = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      List<MesBuildingQhse> qhseList = this.qhseService
         .lambdaQuery()
         .in(MesBuildingQhse::getProjectId, projectIdList)
         .eq(query.getWorkshopId() != null, MesBuildingQhse::getWorkshopId, query.getWorkshopId())
         .apply("YEAR(create_time) = {0}", YearMonth.now().getYear())
         .apply("type & {0}", QhseTypeEnum.QUALITY.getType() | QhseTypeEnum.SPECIAL_QUALITY.getType())
         .list();
      if (CollUtil.isEmpty(qhseList)) {
         return ResultBuilder.success(Collections.emptyList());
      }

      Map<Long, Integer> qhseQuantityMap = qhseList.stream()
         .filter(qhse -> ObjectUtil.isNotNull(qhse.getTeamId()))
         .collect(Collectors.toMap(MesBuildingQhse::getTeamId, v -> ObjectUtil.defaultIfNull(v.getProblemQuantity(), 0), Integer::sum));
      List<MesBuildingTeamInfoDTO> teamList = Optional.of(qhseQuantityMap.keySet())
         .filter(CollUtil::isNotEmpty)
         .map(o -> this.teamService.listInfo(MesBuildingTeamQuery.builder().idList(o).build()))
         .orElseGet(Collections::emptyList);
      List<JSONObject> resultList = teamList.stream()
         .map(
            team -> JSONUtil.createObj(JSONConfig.create().setIgnoreNullValue(false))
               .set("teamId", team.getId())
               .set("teamName", team.getName())
               .set("processName", team.getProcess().getName())
               .set("problemQuantity", qhseQuantityMap.getOrDefault(team.getId(), 0))
         )
         .sorted(Comparator.comparing(k -> k.getInt("problemQuantity"), Comparator.reverseOrder()))
         .collect(Collectors.toList());
      return ResultBuilder.success(resultList);
   }

   @ApiOperation("即时消息提示")
   @GetMapping("instant-message-prompt")
   public ResultVO instantMessagePrompt(KanbanQuery query) {
      log.info("API调用: 生产看板大屏-即时消息提示");
      List<ContractProject> projectList = this.projectService
         .lambdaQuery()
         .apply(query.getYear() != null, "YEAR(create_time) = {0}", query.getYear())
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .list();
      if (CollUtil.isEmpty(projectList)) {
         return ResultBuilder.success(Collections.emptyList());
      }

      List<Long> projectIdList = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      Map<Long, ContractProject> projectMap = projectList.stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      List<ProductionKanbanLargeScreenController.InstantMessagePrompt> resultList = new ArrayList<>();
      List<MesBuildingCargoList> cargoListList = this.cargoListService
         .lambdaQuery()
         .in(MesBuildingCargoList::getProjectId, projectIdList)
         .in(MesBuildingCargoList::getStatus, 4, 8)
         .apply("DATE_FORMAT(audit_time, '%Y-%m-%d %H') >= {0}", LocalDateTime.now().minusHours(12L).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH")))
         .apply("DATE_FORMAT(audit_time, '%Y-%m-%d %H') <= {0}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH")))
         .list();
      List<ProductionKanbanLargeScreenController.InstantMessagePrompt> shippingInfoList = cargoListList.stream()
         .map(
            cl -> {
               ContractProject cProject = projectMap.getOrDefault(cl.getProjectId(), new ContractProject());
               return ProductionKanbanLargeScreenController.InstantMessagePrompt.builder()
                  .messageType("发运信息")
                  .projectId(cProject.getId())
                  .projectName(cProject.getName())
                  .projectShortName(cProject.getShortName())
                  .projectSerialNumber(cProject.getSerialNumber())
                  .licensePlate(cl.getLicensePlate())
                  .totalNetWeight(cl.getTotalNetWeight())
                  .auditTime(cl.getAuditTime().format(DatePattern.NORM_DATETIME_MINUTE_FORMATTER))
                  .build();
            }
         )
         .collect(Collectors.toList());
      resultList.addAll(shippingInfoList);
      List<InspectRealtimeInfoDTO> inspectRealtimeInfoDTOList = this.qhseService
         .productionKanbanRealtimeInfo(projectIdList, query.getWorkshopId(), LocalDateTime.now().minusHours(12L), LocalDateTime.now(), 2);
      List<ProductionKanbanLargeScreenController.InstantMessagePrompt> qualityInspectionInfoList = inspectRealtimeInfoDTOList.stream()
         .map(
            inspectRealtimeInfoDTO -> ProductionKanbanLargeScreenController.InstantMessagePrompt.builder()
               .messageType("质检信息")
               .projectShortName(inspectRealtimeInfoDTO.getProject().getShortName())
               .projectSerialNumber(inspectRealtimeInfoDTO.getProject().getSerialNumber())
               .artifactSerialNumber(inspectRealtimeInfoDTO.getSerialNumber())
               .qualityInspectionIssues(inspectRealtimeInfoDTO.getLevelTwoTypeName())
               .inspectUserNames(inspectRealtimeInfoDTO.getInspectUserNames())
               .processName(inspectRealtimeInfoDTO.getProcessName())
               .teamName(inspectRealtimeInfoDTO.getTeam().getName())
               .qhseNumber(inspectRealtimeInfoDTO.getQhseNumber())
               .build()
         )
         .collect(Collectors.toList());
      resultList.addAll(qualityInspectionInfoList);
      List<ContractProject> newProjectList = this.projectService
         .lambdaQuery()
         .eq(query.getBranchCompanyId() != null, ContractProject::getContractSignBodyId, query.getBranchCompanyId())
         .apply("DATE_FORMAT(create_time, '%Y-%m-%d %H') >= {0}", LocalDateTime.now().minusHours(12L).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH")))
         .apply("DATE_FORMAT(create_time, '%Y-%m-%d %H') <= {0}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH")))
         .list();
      List<Long> newProjectIdList = newProjectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      Map<Long, ContractTech> contractTechMap = Optional.of(newProjectIdList)
         .filter(CollUtil::isNotEmpty)
         .map(o -> this.contractTechService.lambdaQuery().in(ContractTech::getProjectId, o).list())
         .orElseGet(Collections::emptyList)
         .stream()
         .collect(Collectors.toMap(ContractTech::getProjectId, Function.identity(), (v1, v2) -> v2));
      List<Long> projectUserIdList = newProjectList.stream().map(ContractProject::getUserId).distinct().collect(Collectors.toList());
      Map<Long, User> projectUserMap = Optional.of(projectUserIdList)
         .filter(CollUtil::isNotEmpty)
         .map(this.userService::listByIds)
         .orElseGet(Collections::emptyList)
         .stream()
         .collect(Collectors.toMap(User::getId, Function.identity()));
      List<ProductionKanbanLargeScreenController.InstantMessagePrompt> newProjectInfoList = newProjectList.stream()
         .map(
            cp -> {
               ContractTech contractTech = contractTechMap.get(cp.getId());
               long days = ChronoUnit.DAYS.between(cp.getStartDate(), cp.getEndDate());
               String startDateStr = cp.getStartDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
               String endDateStr = cp.getEndDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
               return ProductionKanbanLargeScreenController.InstantMessagePrompt.builder()
                  .messageType("项目信息")
                  .projectId(cp.getId())
                  .projectName(cp.getName())
                  .projectShortName(cp.getShortName())
                  .projectSerialNumber(cp.getSerialNumber())
                  .createTime(cp.getCreateTime().format(DatePattern.NORM_DATETIME_MINUTE_FORMATTER))
                  .contractVolume(contractTech.getQuantityWork().divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP))
                  .startDate(cp.getStartDate())
                  .endDate(cp.getEndDate())
                  .durationStr(startDateStr + "~" + endDateStr + " (" + days + "天)")
                  .creatorName(projectUserMap.getOrDefault(cp.getUserId(), new User()).getName())
                  .build();
            }
         )
         .collect(Collectors.toList());
      resultList.addAll(newProjectInfoList);
      List<JSONObject> lagInfoList = this.taskProcessService.productionKanbanLagInfo(projectIdList, query.getWorkshopId());
      resultList.addAll(
         lagInfoList.stream().map(li -> JSONUtil.toBean(li, ProductionKanbanLargeScreenController.InstantMessagePrompt.class)).collect(Collectors.toList())
      );
      resultList.forEach(r -> r.setOrdinal(resultList.indexOf(r) + 1));
      return ResultBuilder.success(resultList);
   }

   public static class InstantMessagePrompt {
      @ApiModelProperty("序号")
      private Integer ordinal;
      @ApiModelProperty("消息类型")
      private String messageType;
      @ApiModelProperty("项目ID")
      private Long projectId;
      @ApiModelProperty("项目名称")
      private String projectName;
      @ApiModelProperty("项目简称")
      private String projectShortName;
      @ApiModelProperty("项目编号")
      private String projectSerialNumber;
      @ApiModelProperty("车牌号")
      private String licensePlate;
      @ApiModelProperty("总净重")
      private BigDecimal totalNetWeight;
      @ApiModelProperty("审批时间")
      private String auditTime;
      @ApiModelProperty("构件编号")
      private String artifactSerialNumber;
      @ApiModelProperty("质检问题")
      private String qualityInspectionIssues;
      @ApiModelProperty("质检人员")
      private List<String> inspectUserNames;
      @ApiModelProperty("工序名称")
      private String processName;
      @ApiModelProperty("班组名称")
      private String teamName;
      @ApiModelProperty("创建时间")
      private String createTime;
      @ApiModelProperty("合同量")
      private BigDecimal contractVolume;
      @ApiModelProperty("开始日期")
      private LocalDate startDate;
      private LocalDate endDate;
      @ApiModelProperty("任务工单ID")
      private Long taskOrderId;
      @ApiModelProperty("任务工单工单编号")
      private String taskOrderOrderNumber;
      @ApiModelProperty("工序ID")
      private Long processId;
      @ApiModelProperty("需求完成日期")
      private String askCompleteDate;
      @ApiModelProperty("任务数量")
      private BigDecimal taskQuantity;
      @ApiModelProperty("质检数量")
      private BigDecimal inspectionQuantity;
      @ApiModelProperty("工期")
      private String durationStr;
      @ApiModelProperty("创建人名称")
      private String creatorName;
      @ApiModelProperty("问题编号")
      private String qhseNumber;

      public static ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder builder() {
         return new ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder();
      }

      public Integer getOrdinal() {
         return this.ordinal;
      }

      public String getMessageType() {
         return this.messageType;
      }

      public Long getProjectId() {
         return this.projectId;
      }

      public String getProjectName() {
         return this.projectName;
      }

      public String getProjectShortName() {
         return this.projectShortName;
      }

      public String getProjectSerialNumber() {
         return this.projectSerialNumber;
      }

      public String getLicensePlate() {
         return this.licensePlate;
      }

      public BigDecimal getTotalNetWeight() {
         return this.totalNetWeight;
      }

      public String getAuditTime() {
         return this.auditTime;
      }

      public String getArtifactSerialNumber() {
         return this.artifactSerialNumber;
      }

      public String getQualityInspectionIssues() {
         return this.qualityInspectionIssues;
      }

      public List<String> getInspectUserNames() {
         return this.inspectUserNames;
      }

      public String getProcessName() {
         return this.processName;
      }

      public String getTeamName() {
         return this.teamName;
      }

      public String getCreateTime() {
         return this.createTime;
      }

      public BigDecimal getContractVolume() {
         return this.contractVolume;
      }

      public LocalDate getStartDate() {
         return this.startDate;
      }

      public LocalDate getEndDate() {
         return this.endDate;
      }

      public Long getTaskOrderId() {
         return this.taskOrderId;
      }

      public String getTaskOrderOrderNumber() {
         return this.taskOrderOrderNumber;
      }

      public Long getProcessId() {
         return this.processId;
      }

      public String getAskCompleteDate() {
         return this.askCompleteDate;
      }

      public BigDecimal getTaskQuantity() {
         return this.taskQuantity;
      }

      public BigDecimal getInspectionQuantity() {
         return this.inspectionQuantity;
      }

      public String getDurationStr() {
         return this.durationStr;
      }

      public String getCreatorName() {
         return this.creatorName;
      }

      public String getQhseNumber() {
         return this.qhseNumber;
      }

      public void setOrdinal(final Integer ordinal) {
         this.ordinal = ordinal;
      }

      public void setMessageType(final String messageType) {
         this.messageType = messageType;
      }

      public void setProjectId(final Long projectId) {
         this.projectId = projectId;
      }

      public void setProjectName(final String projectName) {
         this.projectName = projectName;
      }

      public void setProjectShortName(final String projectShortName) {
         this.projectShortName = projectShortName;
      }

      public void setProjectSerialNumber(final String projectSerialNumber) {
         this.projectSerialNumber = projectSerialNumber;
      }

      public void setLicensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
      }

      public void setTotalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
      }

      public void setAuditTime(final String auditTime) {
         this.auditTime = auditTime;
      }

      public void setArtifactSerialNumber(final String artifactSerialNumber) {
         this.artifactSerialNumber = artifactSerialNumber;
      }

      public void setQualityInspectionIssues(final String qualityInspectionIssues) {
         this.qualityInspectionIssues = qualityInspectionIssues;
      }

      public void setInspectUserNames(final List<String> inspectUserNames) {
         this.inspectUserNames = inspectUserNames;
      }

      public void setProcessName(final String processName) {
         this.processName = processName;
      }

      public void setTeamName(final String teamName) {
         this.teamName = teamName;
      }

      public void setCreateTime(final String createTime) {
         this.createTime = createTime;
      }

      public void setContractVolume(final BigDecimal contractVolume) {
         this.contractVolume = contractVolume;
      }

      public void setStartDate(final LocalDate startDate) {
         this.startDate = startDate;
      }

      public void setEndDate(final LocalDate endDate) {
         this.endDate = endDate;
      }

      public void setTaskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
      }

      public void setTaskOrderOrderNumber(final String taskOrderOrderNumber) {
         this.taskOrderOrderNumber = taskOrderOrderNumber;
      }

      public void setProcessId(final Long processId) {
         this.processId = processId;
      }

      public void setAskCompleteDate(final String askCompleteDate) {
         this.askCompleteDate = askCompleteDate;
      }

      public void setTaskQuantity(final BigDecimal taskQuantity) {
         this.taskQuantity = taskQuantity;
      }

      public void setInspectionQuantity(final BigDecimal inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
      }

      public void setDurationStr(final String durationStr) {
         this.durationStr = durationStr;
      }

      public void setCreatorName(final String creatorName) {
         this.creatorName = creatorName;
      }

      public void setQhseNumber(final String qhseNumber) {
         this.qhseNumber = qhseNumber;
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         }

         if (!(o instanceof ProductionKanbanLargeScreenController.InstantMessagePrompt)) {
            return false;
         }

         ProductionKanbanLargeScreenController.InstantMessagePrompt other = (ProductionKanbanLargeScreenController.InstantMessagePrompt)o;
         if (!other.canEqual(this)) {
            return false;
         }

         Object this$ordinal = this.getOrdinal();
         Object other$ordinal = other.getOrdinal();
         if (this$ordinal == null ? other$ordinal == null : this$ordinal.equals(other$ordinal)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$taskOrderId = this.getTaskOrderId();
               Object other$taskOrderId = other.getTaskOrderId();
               if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$messageType = this.getMessageType();
                     Object other$messageType = other.getMessageType();
                     if (this$messageType == null ? other$messageType == null : this$messageType.equals(other$messageType)) {
                        Object this$projectName = this.getProjectName();
                        Object other$projectName = other.getProjectName();
                        if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                           Object this$projectShortName = this.getProjectShortName();
                           Object other$projectShortName = other.getProjectShortName();
                           if (this$projectShortName == null ? other$projectShortName == null : this$projectShortName.equals(other$projectShortName)) {
                              Object this$projectSerialNumber = this.getProjectSerialNumber();
                              Object other$projectSerialNumber = other.getProjectSerialNumber();
                              if (this$projectSerialNumber == null
                                 ? other$projectSerialNumber == null
                                 : this$projectSerialNumber.equals(other$projectSerialNumber)) {
                                 Object this$licensePlate = this.getLicensePlate();
                                 Object other$licensePlate = other.getLicensePlate();
                                 if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                                    Object this$totalNetWeight = this.getTotalNetWeight();
                                    Object other$totalNetWeight = other.getTotalNetWeight();
                                    if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                       Object this$auditTime = this.getAuditTime();
                                       Object other$auditTime = other.getAuditTime();
                                       if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
                                          Object this$artifactSerialNumber = this.getArtifactSerialNumber();
                                          Object other$artifactSerialNumber = other.getArtifactSerialNumber();
                                          if (this$artifactSerialNumber == null
                                             ? other$artifactSerialNumber == null
                                             : this$artifactSerialNumber.equals(other$artifactSerialNumber)) {
                                             Object this$qualityInspectionIssues = this.getQualityInspectionIssues();
                                             Object other$qualityInspectionIssues = other.getQualityInspectionIssues();
                                             if (this$qualityInspectionIssues == null
                                                ? other$qualityInspectionIssues == null
                                                : this$qualityInspectionIssues.equals(other$qualityInspectionIssues)) {
                                                Object this$inspectUserNames = this.getInspectUserNames();
                                                Object other$inspectUserNames = other.getInspectUserNames();
                                                if (this$inspectUserNames == null
                                                   ? other$inspectUserNames == null
                                                   : this$inspectUserNames.equals(other$inspectUserNames)) {
                                                   Object this$processName = this.getProcessName();
                                                   Object other$processName = other.getProcessName();
                                                   if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                                      Object this$teamName = this.getTeamName();
                                                      Object other$teamName = other.getTeamName();
                                                      if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
                                                         Object this$createTime = this.getCreateTime();
                                                         Object other$createTime = other.getCreateTime();
                                                         if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                            Object this$contractVolume = this.getContractVolume();
                                                            Object other$contractVolume = other.getContractVolume();
                                                            if (this$contractVolume == null
                                                               ? other$contractVolume == null
                                                               : this$contractVolume.equals(other$contractVolume)) {
                                                               Object this$startDate = this.getStartDate();
                                                               Object other$startDate = other.getStartDate();
                                                               if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                                                  Object this$endDate = this.getEndDate();
                                                                  Object other$endDate = other.getEndDate();
                                                                  if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                                                     Object this$taskOrderOrderNumber = this.getTaskOrderOrderNumber();
                                                                     Object other$taskOrderOrderNumber = other.getTaskOrderOrderNumber();
                                                                     if (this$taskOrderOrderNumber == null
                                                                        ? other$taskOrderOrderNumber == null
                                                                        : this$taskOrderOrderNumber.equals(other$taskOrderOrderNumber)) {
                                                                        Object this$askCompleteDate = this.getAskCompleteDate();
                                                                        Object other$askCompleteDate = other.getAskCompleteDate();
                                                                        if (this$askCompleteDate == null
                                                                           ? other$askCompleteDate == null
                                                                           : this$askCompleteDate.equals(other$askCompleteDate)) {
                                                                           Object this$taskQuantity = this.getTaskQuantity();
                                                                           Object other$taskQuantity = other.getTaskQuantity();
                                                                           if (this$taskQuantity == null
                                                                              ? other$taskQuantity == null
                                                                              : this$taskQuantity.equals(other$taskQuantity)) {
                                                                              Object this$inspectionQuantity = this.getInspectionQuantity();
                                                                              Object other$inspectionQuantity = other.getInspectionQuantity();
                                                                              if (this$inspectionQuantity == null
                                                                                 ? other$inspectionQuantity == null
                                                                                 : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                                                                                 Object this$durationStr = this.getDurationStr();
                                                                                 Object other$durationStr = other.getDurationStr();
                                                                                 if (this$durationStr == null
                                                                                    ? other$durationStr == null
                                                                                    : this$durationStr.equals(other$durationStr)) {
                                                                                    Object this$creatorName = this.getCreatorName();
                                                                                    Object other$creatorName = other.getCreatorName();
                                                                                    if (this$creatorName == null
                                                                                       ? other$creatorName == null
                                                                                       : this$creatorName.equals(other$creatorName)) {
                                                                                       Object this$qhseNumber = this.getQhseNumber();
                                                                                       Object other$qhseNumber = other.getQhseNumber();
                                                                                       return this$qhseNumber == null
                                                                                          ? other$qhseNumber == null
                                                                                          : this$qhseNumber.equals(other$qhseNumber);
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
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
         return other instanceof ProductionKanbanLargeScreenController.InstantMessagePrompt;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         Object $ordinal = this.getOrdinal();
         result = result * 59 + ($ordinal == null ? 43 : $ordinal.hashCode());
         Object $projectId = this.getProjectId();
         result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
         Object $taskOrderId = this.getTaskOrderId();
         result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
         Object $processId = this.getProcessId();
         result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
         Object $messageType = this.getMessageType();
         result = result * 59 + ($messageType == null ? 43 : $messageType.hashCode());
         Object $projectName = this.getProjectName();
         result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
         Object $projectShortName = this.getProjectShortName();
         result = result * 59 + ($projectShortName == null ? 43 : $projectShortName.hashCode());
         Object $projectSerialNumber = this.getProjectSerialNumber();
         result = result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
         Object $licensePlate = this.getLicensePlate();
         result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
         Object $totalNetWeight = this.getTotalNetWeight();
         result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
         Object $auditTime = this.getAuditTime();
         result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
         Object $artifactSerialNumber = this.getArtifactSerialNumber();
         result = result * 59 + ($artifactSerialNumber == null ? 43 : $artifactSerialNumber.hashCode());
         Object $qualityInspectionIssues = this.getQualityInspectionIssues();
         result = result * 59 + ($qualityInspectionIssues == null ? 43 : $qualityInspectionIssues.hashCode());
         Object $inspectUserNames = this.getInspectUserNames();
         result = result * 59 + ($inspectUserNames == null ? 43 : $inspectUserNames.hashCode());
         Object $processName = this.getProcessName();
         result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
         Object $teamName = this.getTeamName();
         result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
         Object $createTime = this.getCreateTime();
         result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
         Object $contractVolume = this.getContractVolume();
         result = result * 59 + ($contractVolume == null ? 43 : $contractVolume.hashCode());
         Object $startDate = this.getStartDate();
         result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
         Object $endDate = this.getEndDate();
         result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
         Object $taskOrderOrderNumber = this.getTaskOrderOrderNumber();
         result = result * 59 + ($taskOrderOrderNumber == null ? 43 : $taskOrderOrderNumber.hashCode());
         Object $askCompleteDate = this.getAskCompleteDate();
         result = result * 59 + ($askCompleteDate == null ? 43 : $askCompleteDate.hashCode());
         Object $taskQuantity = this.getTaskQuantity();
         result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
         Object $inspectionQuantity = this.getInspectionQuantity();
         result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
         Object $durationStr = this.getDurationStr();
         result = result * 59 + ($durationStr == null ? 43 : $durationStr.hashCode());
         Object $creatorName = this.getCreatorName();
         result = result * 59 + ($creatorName == null ? 43 : $creatorName.hashCode());
         Object $qhseNumber = this.getQhseNumber();
         return result * 59 + ($qhseNumber == null ? 43 : $qhseNumber.hashCode());
      }

      @Override
      public String toString() {
         return "ProductionKanbanLargeScreenController.InstantMessagePrompt(ordinal="
            + this.getOrdinal()
            + ", messageType="
            + this.getMessageType()
            + ", projectId="
            + this.getProjectId()
            + ", projectName="
            + this.getProjectName()
            + ", projectShortName="
            + this.getProjectShortName()
            + ", projectSerialNumber="
            + this.getProjectSerialNumber()
            + ", licensePlate="
            + this.getLicensePlate()
            + ", totalNetWeight="
            + this.getTotalNetWeight()
            + ", auditTime="
            + this.getAuditTime()
            + ", artifactSerialNumber="
            + this.getArtifactSerialNumber()
            + ", qualityInspectionIssues="
            + this.getQualityInspectionIssues()
            + ", inspectUserNames="
            + this.getInspectUserNames()
            + ", processName="
            + this.getProcessName()
            + ", teamName="
            + this.getTeamName()
            + ", createTime="
            + this.getCreateTime()
            + ", contractVolume="
            + this.getContractVolume()
            + ", startDate="
            + this.getStartDate()
            + ", endDate="
            + this.getEndDate()
            + ", taskOrderId="
            + this.getTaskOrderId()
            + ", taskOrderOrderNumber="
            + this.getTaskOrderOrderNumber()
            + ", processId="
            + this.getProcessId()
            + ", askCompleteDate="
            + this.getAskCompleteDate()
            + ", taskQuantity="
            + this.getTaskQuantity()
            + ", inspectionQuantity="
            + this.getInspectionQuantity()
            + ", durationStr="
            + this.getDurationStr()
            + ", creatorName="
            + this.getCreatorName()
            + ", qhseNumber="
            + this.getQhseNumber()
            + ")";
      }

      public InstantMessagePrompt(
         final Integer ordinal,
         final String messageType,
         final Long projectId,
         final String projectName,
         final String projectShortName,
         final String projectSerialNumber,
         final String licensePlate,
         final BigDecimal totalNetWeight,
         final String auditTime,
         final String artifactSerialNumber,
         final String qualityInspectionIssues,
         final List<String> inspectUserNames,
         final String processName,
         final String teamName,
         final String createTime,
         final BigDecimal contractVolume,
         final LocalDate startDate,
         final LocalDate endDate,
         final Long taskOrderId,
         final String taskOrderOrderNumber,
         final Long processId,
         final String askCompleteDate,
         final BigDecimal taskQuantity,
         final BigDecimal inspectionQuantity,
         final String durationStr,
         final String creatorName,
         final String qhseNumber
      ) {
         this.ordinal = ordinal;
         this.messageType = messageType;
         this.projectId = projectId;
         this.projectName = projectName;
         this.projectShortName = projectShortName;
         this.projectSerialNumber = projectSerialNumber;
         this.licensePlate = licensePlate;
         this.totalNetWeight = totalNetWeight;
         this.auditTime = auditTime;
         this.artifactSerialNumber = artifactSerialNumber;
         this.qualityInspectionIssues = qualityInspectionIssues;
         this.inspectUserNames = inspectUserNames;
         this.processName = processName;
         this.teamName = teamName;
         this.createTime = createTime;
         this.contractVolume = contractVolume;
         this.startDate = startDate;
         this.endDate = endDate;
         this.taskOrderId = taskOrderId;
         this.taskOrderOrderNumber = taskOrderOrderNumber;
         this.processId = processId;
         this.askCompleteDate = askCompleteDate;
         this.taskQuantity = taskQuantity;
         this.inspectionQuantity = inspectionQuantity;
         this.durationStr = durationStr;
         this.creatorName = creatorName;
         this.qhseNumber = qhseNumber;
      }

      public InstantMessagePrompt() {
      }

      public static class InstantMessagePromptBuilder {
         private Integer ordinal;
         private String messageType;
         private Long projectId;
         private String projectName;
         private String projectShortName;
         private String projectSerialNumber;
         private String licensePlate;
         private BigDecimal totalNetWeight;
         private String auditTime;
         private String artifactSerialNumber;
         private String qualityInspectionIssues;
         private List<String> inspectUserNames;
         private String processName;
         private String teamName;
         private String createTime;
         private BigDecimal contractVolume;
         private LocalDate startDate;
         private LocalDate endDate;
         private Long taskOrderId;
         private String taskOrderOrderNumber;
         private Long processId;
         private String askCompleteDate;
         private BigDecimal taskQuantity;
         private BigDecimal inspectionQuantity;
         private String durationStr;
         private String creatorName;
         private String qhseNumber;

         InstantMessagePromptBuilder() {
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder ordinal(final Integer ordinal) {
            this.ordinal = ordinal;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder messageType(final String messageType) {
            this.messageType = messageType;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder projectId(final Long projectId) {
            this.projectId = projectId;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder projectName(final String projectName) {
            this.projectName = projectName;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder projectShortName(final String projectShortName) {
            this.projectShortName = projectShortName;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder projectSerialNumber(final String projectSerialNumber) {
            this.projectSerialNumber = projectSerialNumber;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder licensePlate(final String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder totalNetWeight(final BigDecimal totalNetWeight) {
            this.totalNetWeight = totalNetWeight;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder auditTime(final String auditTime) {
            this.auditTime = auditTime;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder artifactSerialNumber(final String artifactSerialNumber) {
            this.artifactSerialNumber = artifactSerialNumber;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder qualityInspectionIssues(
            final String qualityInspectionIssues
         ) {
            this.qualityInspectionIssues = qualityInspectionIssues;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder inspectUserNames(final List<String> inspectUserNames) {
            this.inspectUserNames = inspectUserNames;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder processName(final String processName) {
            this.processName = processName;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder teamName(final String teamName) {
            this.teamName = teamName;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder createTime(final String createTime) {
            this.createTime = createTime;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder contractVolume(final BigDecimal contractVolume) {
            this.contractVolume = contractVolume;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder startDate(final LocalDate startDate) {
            this.startDate = startDate;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder endDate(final LocalDate endDate) {
            this.endDate = endDate;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder taskOrderId(final Long taskOrderId) {
            this.taskOrderId = taskOrderId;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder taskOrderOrderNumber(final String taskOrderOrderNumber) {
            this.taskOrderOrderNumber = taskOrderOrderNumber;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder processId(final Long processId) {
            this.processId = processId;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder askCompleteDate(final String askCompleteDate) {
            this.askCompleteDate = askCompleteDate;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder taskQuantity(final BigDecimal taskQuantity) {
            this.taskQuantity = taskQuantity;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder inspectionQuantity(final BigDecimal inspectionQuantity) {
            this.inspectionQuantity = inspectionQuantity;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder durationStr(final String durationStr) {
            this.durationStr = durationStr;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder creatorName(final String creatorName) {
            this.creatorName = creatorName;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder qhseNumber(final String qhseNumber) {
            this.qhseNumber = qhseNumber;
            return this;
         }

         public ProductionKanbanLargeScreenController.InstantMessagePrompt build() {
            return new ProductionKanbanLargeScreenController.InstantMessagePrompt(
               this.ordinal,
               this.messageType,
               this.projectId,
               this.projectName,
               this.projectShortName,
               this.projectSerialNumber,
               this.licensePlate,
               this.totalNetWeight,
               this.auditTime,
               this.artifactSerialNumber,
               this.qualityInspectionIssues,
               this.inspectUserNames,
               this.processName,
               this.teamName,
               this.createTime,
               this.contractVolume,
               this.startDate,
               this.endDate,
               this.taskOrderId,
               this.taskOrderOrderNumber,
               this.processId,
               this.askCompleteDate,
               this.taskQuantity,
               this.inspectionQuantity,
               this.durationStr,
               this.creatorName,
               this.qhseNumber
            );
         }

         @Override
         public String toString() {
            return "ProductionKanbanLargeScreenController.InstantMessagePrompt.InstantMessagePromptBuilder(ordinal="
               + this.ordinal
               + ", messageType="
               + this.messageType
               + ", projectId="
               + this.projectId
               + ", projectName="
               + this.projectName
               + ", projectShortName="
               + this.projectShortName
               + ", projectSerialNumber="
               + this.projectSerialNumber
               + ", licensePlate="
               + this.licensePlate
               + ", totalNetWeight="
               + this.totalNetWeight
               + ", auditTime="
               + this.auditTime
               + ", artifactSerialNumber="
               + this.artifactSerialNumber
               + ", qualityInspectionIssues="
               + this.qualityInspectionIssues
               + ", inspectUserNames="
               + this.inspectUserNames
               + ", processName="
               + this.processName
               + ", teamName="
               + this.teamName
               + ", createTime="
               + this.createTime
               + ", contractVolume="
               + this.contractVolume
               + ", startDate="
               + this.startDate
               + ", endDate="
               + this.endDate
               + ", taskOrderId="
               + this.taskOrderId
               + ", taskOrderOrderNumber="
               + this.taskOrderOrderNumber
               + ", processId="
               + this.processId
               + ", askCompleteDate="
               + this.askCompleteDate
               + ", taskQuantity="
               + this.taskQuantity
               + ", inspectionQuantity="
               + this.inspectionQuantity
               + ", durationStr="
               + this.durationStr
               + ", creatorName="
               + this.creatorName
               + ", qhseNumber="
               + this.qhseNumber
               + ")";
         }
      }
   }
}
