package com.hzchum.scim.mes.building.core.biz.impl.largesreen;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.common.core.api.pojo.dto.DateQuantityDTO;
import com.hzchum.scim.common.core.api.pojo.dto.TwoQuantityDTO;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.largesreen.NewLargeScreenBiz;
import com.hzchum.scim.mes.building.core.api.enums.QhseStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.QhseTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhse;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.CargoRealtimeInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.InsepectSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.InspectRealtimeInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.InspectToDayInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.InspectToDayListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.LargeScreenSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.MonthlyFirstPassRateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.ProjectAnalysisDataDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.ProjectInboundCurrentMonth;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.ProjectProcessingProgressDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.ProjectSteelRearingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QhseAlertDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QhseGroupMonthByYearSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QhseQuantitySummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QhseWarnToDayDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QualityGroupSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QualityInspectionStatisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.TeamProduceInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.TeamProduceRealtimeInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.TeamProjectProduceInfo;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.TeamQhseQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.TeamQhseRankingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.WorkshopAchievementRateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.WorkshopProduceInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesSimpleTeamDTO;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ProjectSteelPickingStatistics;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewLargeScreenBizImpl implements NewLargeScreenBiz {
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Autowired
   private MesBuildingProduceInspectionTeamReportService inspectionTeamReportService;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingQhseService qhseService;
   @Autowired
   private MesBuildingCompleteService completeService;
   @Resource
   MoveOutboundDetailService moveOutboundDetailService;
   @Resource
   private MesBuildingCargoListService cargoListService;
   @Resource
   private RedisUtils redisUtils;

   @Override
   public LargeScreenSummaryDTO getHeaderLargeScreenSummaryDTO(String year, Long workShopId) {
      List<ContractProject> list = this.projectService.list();
      LocalDate now = LocalDate.now();
      LocalDate localDate = null;
      if (year != null && year != "") {
         localDate = now.withYear(Integer.parseInt(year));
      }

      long completeProject = list.stream()
         .filter(s -> (s.getStatus() & (ProjectStatusEnum.COMPLETED.getType() | ProjectStatusEnum.SETTLED.getType())) != 0)
         .count();
      Integer totalAmountByYear = this.taskService.findTotalAmountByDate(localDate, workShopId, "%Y");
      Integer totalAmountByMonth = this.taskService.findTotalAmountByDate(now, workShopId, "%Y-%M");
      Integer totalQuantityCurrentMonth = this.taskService.findTotalQuantityByDate(now, workShopId, "%Y-%M");
      TwoQuantityDTO quantityDTO = this.taskService.achievementRate(workShopId);
      return LargeScreenSummaryDTO.builder()
         .totalProject(list.size())
         .completeProject((int)completeProject)
         .annualCompletions(totalAmountByYear)
         .currentMonthTon(totalAmountByMonth)
         .currentMonthCount(totalQuantityCurrentMonth)
         .achievementRate(quantityDTO.getTwoQuantity().divide(quantityDTO.getOneQuantity(), 2, RoundingMode.HALF_UP))
         .build();
   }

   @Override
   public List<WorkshopAchievementRateDTO> findWorkshopAchievements(Long workShopId, String year) {
      LocalDate date = null;
      if (year != null && year != "") {
         date = LocalDate.now().withYear(Integer.parseInt(year));
      }

      Map<String, DateQuantityDTO> dateMap = this.taskProcessService
         .findWorkshopAchievements(workShopId, date)
         .stream()
         .collect(Collectors.toMap(e -> e.getDate(), Function.identity()));
      List<WorkshopAchievementRateDTO> dtos = new ArrayList<>();
      int appendYear = date.getYear();

      for (int i = 1; i <= 12; i++) {
         String appedstr;
         if (i < 10) {
            appedstr = "-0";
         } else {
            appedstr = "-";
         }

         DateQuantityDTO dateQuantityDTO = dateMap.get(appendYear + appedstr + i);
         WorkshopAchievementRateDTO dto = WorkshopAchievementRateDTO.builder()
            .month(appendYear + appedstr + i)
            .schedulingWeight(BigDecimal.ZERO)
            .completedWeight(BigDecimal.ZERO)
            .rate(BigDecimal.ZERO)
            .build();
         if (dateQuantityDTO != null) {
            dto.setSchedulingWeight(dateQuantityDTO.getOneQuantity());
            dto.setCompletedWeight(dateQuantityDTO.getTwoQuantity());
            dto.setRate(dateQuantityDTO.getTwoQuantity().divide(dateQuantityDTO.getOneQuantity(), 2, RoundingMode.HALF_UP));
         }

         dtos.add(dto);
      }

      return dtos;
   }

   @Override
   public List<DateQuantityDTO> findAchievementGroupWorkshop(String year) {
      LocalDate date = null;
      if (year != null && year != "") {
         date = LocalDate.now().withYear(Integer.parseInt(year));
      }

      return this.produceTeamReportService.findAchievementGroupWorkshop(date);
   }

   @Override
   public List<TeamQhseQuantityDTO> findTeamQhseQuantity(Long workShopId, String year) {
      LocalDate date = null;
      if (year != null && year != "") {
         date = LocalDate.now().withYear(Integer.parseInt(year));
      }

      return this.qhseService.findTeamQhseQuantity(workShopId, date);
   }

   @Override
   public List<QhseQuantitySummaryDTO> findQhseQuantityGroupQhseType(Long workShopId, String year) {
      LocalDate date = null;
      if (year != null && year != "") {
         date = LocalDate.now().withYear(Integer.parseInt(year));
      }

      return this.qhseService.findQhseQuantityGroupQhseType(workShopId, date);
   }

   @Override
   public List<QhseWarnToDayDTO> findQhseWarnToDay(Long workShopId) {
      return this.qhseService.findQhseWarnToDay(workShopId);
   }

   @Override
   public List<ProjectAnalysisDataDTO> findProjectAnalysisDataDTO(Long workShopId, String year) {
      return this.completeService.findProjectAnalysisDataDTO(workShopId, year);
   }

   @Override
   public List<ProjectSteelRearingDTO> findProjectSteelRearing(Long workShopId, String year) {
      List<ProjectSteelRearingDTO> dtos = this.completeService.findProjectSteelRearing(workShopId, year);
      Map<Long, ProjectSteelPickingStatistics> rearingMap = this.moveOutboundDetailService
         .projectSteelPickingStatistics(year, workShopId)
         .stream()
         .collect(Collectors.toMap(e -> e.getProjectId(), Function.identity()));
      if (!rearingMap.isEmpty()) {
         dtos.forEach(e -> {
            ProjectSteelPickingStatistics statistics = rearingMap.get(e.getProjectId());
            if (statistics != null) {
               e.setCumulativePicking(statistics.getYearMete());
               e.setPickedLastMonth(statistics.getAboveMonthMete());
               e.setPickThisMonth(statistics.getMonthMete());
            }
         });
      }

      return dtos;
   }

   @Override
   public TeamProduceRealtimeInfoDTO findTeamProjectProduceInfo(LocalDateTime date, Long workShopId, Long productionId) {
      List<TeamProjectProduceInfo> produceInfos = this.taskProcessService
         .findTeamProjectProduceInfo(date != null ? date.getYear() : null, workShopId, productionId);
      List<MesSimpleTeamDTO> teamNames = produceInfos.stream().map(s -> {
         new MesSimpleTeamDTO();
         return MesSimpleTeamDTO.builder().id(s.getProductionLineId()).name(s.getProductionLineName()).build();
      }).distinct().collect(Collectors.toList());
      TeamProduceRealtimeInfoDTO infoDTO = new TeamProduceRealtimeInfoDTO();
      infoDTO.setProjectInfos(produceInfos);
      infoDTO.setTeamNames(teamNames);
      return infoDTO;
   }

   @Override
   public List<TeamProduceInfoDTO> findTeamProduceInfo(LocalDateTime date, Long workShopId, Long productionId) {
      List<TeamProduceInfoDTO> teamProduceInfoDTOS = Convert.toList(
         TeamProduceInfoDTO.class,
         this.redisUtils
            .hget(
               (date != null ? date.getYear() : "date")
                  + "-"
                  + (workShopId == null ? "workShopId" : workShopId)
                  + "-"
                  + (productionId == null ? "productionId" : productionId),
               "findTeamProduceInfo"
            )
      );
      if (CollectionUtils.isNotEmpty(teamProduceInfoDTOS)) {
         return teamProduceInfoDTOS;
      }

      List<TeamProduceInfoDTO> produceInfos = this.produceTeamReportService
         .findTeamProjectProduceInfo(date != null ? date.getYear() : null, workShopId, productionId);
      if (CollectionUtils.isNotEmpty(produceInfos)) {
         this.redisUtils
            .hset(
               (date != null ? date.getYear() : "date")
                  + "-"
                  + (workShopId == null ? "workShopId" : workShopId)
                  + "-"
                  + (productionId == null ? "productionId" : productionId),
               "findTeamProduceInfo",
               produceInfos,
               2600L
            );
      }

      return produceInfos;
   }

   @Override
   public List<WorkshopProduceInfoDTO> findWorkshopProjectProduceInfo(LocalDateTime date, Long workShopId, Long productionId) {
      return this.produceTeamReportService.findWorkshopProjectProduceInfo(date != null ? date.getYear() : null, workShopId, productionId);
   }

   @Override
   public List<ProjectProcessingProgressDTO> projectProcessingProgress(LocalDateTime date, Long workShopId, Long productionId) {
      List<ProjectProcessingProgressDTO> produceInfos = this.taskProcessService
         .projectProcessingProgress(date != null ? date.getYear() : null, workShopId, productionId);
      Map<Long, BigDecimal> decimalMap = this.taskProcessService
         .projectTotalWeightProgressV2()
         .stream()
         .collect(Collectors.toMap(e -> e.getProjectId(), e -> e.getTotalWeight()));
      produceInfos.forEach(e -> e.setTotalWeight(decimalMap.get(e.getProjectId())));
      return produceInfos;
   }

   @Override
   public List<ProjectInboundCurrentMonth> getProjectInboundCurrentMonth(Long workshopId, Long productionId) {
      return this.completeService.getProjectInboundCurrentMonth(workshopId, productionId);
   }

   @Override
   public List<InspectRealtimeInfoDTO> findInspectRealtimeInfo(Long workShopId, Long productionId) {
      return this.produceTeamReportService.findInspectRealtimeInfo(workShopId, productionId);
   }

   @Override
   public List<CargoRealtimeInfoDTO> findCargoRealtimeInfo() {
      List<CargoRealtimeInfoDTO> info = this.cargoListService.findCargoRealtimeInfo();
      info = info.stream().map(s -> {
         switch (s.getStatus()) {
            case 1:
               s.setStatusName("装载中");
               break;
            case 2:
               s.setStatusName("装载中");
               break;
            case 4:
               s.setStatusName("已发运");
               break;
            case 8:
               s.setStatusName("已发运");
               break;
            case 16:
               s.setStatusName("空车过磅");
         }

         return (CargoRealtimeInfoDTO)s;
      }).collect(Collectors.toList());
      info.sort(Comparator.comparing(CargoRealtimeInfoDTO::getDate).reversed());
      return info;
   }

   @Override
   public InsepectSummaryDTO findInsepectSummary(LocalDateTime date) {
      Integer year = date == null ? LocalDateTime.now().getYear() : date.getYear();
      Integer inspectCountYear = this.inspectionTeamReportService
         .list(Wrappers.lambdaQuery(MesBuildingProduceInspectionTeamReport.class).apply("date_format(inspect_report_time,'%Y') = " + year))
         .stream()
         .map(e -> e.getInspectionQuantity())
         .reduce(0, Integer::sum);
      List<MesBuildingQhse> qhseList = this.qhseService
         .list(
            Wrappers.lambdaQuery(MesBuildingQhse.class)
               .in(MesBuildingQhse::getType, Arrays.asList(QhseTypeEnum.QUALITY.getType(), QhseTypeEnum.SPECIAL_QUALITY.getType()))
               .apply("date_format(create_time,'%Y') = " + year)
         );
      Integer qhseCount = 0;
      Integer rectificationCount = 0;
      if (CollectionUtils.isNotEmpty(qhseList)) {
         qhseCount = qhseList.stream().map(e -> e.getProblemQuantity()).reduce(0, Integer::sum);
         rectificationCount = qhseList.stream()
            .filter(s -> s.getStatus().equals(QhseStatusEnum.ADOPT.getType()) || s.getStatus().equals(QhseStatusEnum.CONCESSION_ACCEPTED_APPROVED.getType()))
            .map(e -> e.getProblemQuantity())
            .reduce(0, Integer::sum);
      }

      BigDecimal insepctDemal = BigDecimal.valueOf(inspectCountYear.intValue());
      BigDecimal qhseDemal = BigDecimal.valueOf(qhseCount.intValue());
      BigDecimal rectificationDemal = BigDecimal.valueOf(rectificationCount.intValue());
      new InsepectSummaryDTO();
      InsepectSummaryDTO build = InsepectSummaryDTO.builder()
         .inspectCountYear(insepctDemal)
         .qualifiedCount(insepctDemal.subtract(qhseDemal))
         .qualityQhseCountYear(qhseDemal)
         .rectificationCount(rectificationDemal)
         .build();
      if (insepctDemal.compareTo(BigDecimal.ZERO) != 0) {
         build.setFirstInspectionRate(insepctDemal.subtract(qhseDemal).divide(insepctDemal, 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L)));
      } else {
         build.setFirstInspectionRate(BigDecimal.ZERO);
      }

      if (rectificationDemal.compareTo(BigDecimal.ZERO) != 0) {
         build.setRectificationPlaceCount(rectificationDemal.divide(qhseDemal, 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L)));
      } else {
         build.setRectificationPlaceCount(BigDecimal.ZERO);
      }

      return build;
   }

   @Override
   public InspectToDayInfoDTO findInspectReportRealtime(Long workShopId) {
      List<InspectToDayListDTO> realtimeInfos = this.inspectionTeamReportService.findInspectReportRealtime(workShopId);
      long insepctCount = this.inspectionTeamReportService.findInspectCountByWorkshopId(workShopId).intValue();
      long qhseCount = this.qhseService
         .list(
            Wrappers.lambdaQuery(MesBuildingQhse.class)
               .eq(workShopId != null, MesBuildingQhse::getWorkshopId, workShopId)
               .apply("create_time > date_format(CURDATE(),'%Y-%m-%d')")
         )
         .stream()
         .count();
      return InspectToDayInfoDTO.builder()
         .qhseCount(BigDecimal.valueOf(insepctCount + qhseCount))
         .successQhseCount(BigDecimal.valueOf(insepctCount))
         .unSuccessQhseCount(BigDecimal.valueOf(qhseCount))
         .list(realtimeInfos)
         .build();
   }

   @Override
   public List<QualityGroupSummaryDTO> findQualityGroupSummary(LocalDateTime date) {
      return this.qhseService.findQualityGroupSummary(date != null ? date.getYear() : null);
   }

   @Override
   public List<QhseGroupMonthByYearSummaryDTO> findQualityGroupMonthByYear(LocalDateTime date) {
      return this.qhseService.findQualityGroupMonthByYear(date == null ? null : date.getYear());
   }

   @Override
   public List<MonthlyFirstPassRateDTO> findMonthlyFirstPassRate(LocalDateTime date) {
      Integer year = date == null ? LocalDateTime.now().getYear() : date.getYear();
      List<MonthlyFirstPassRateDTO> inspectList = this.inspectionTeamReportService.findInspectCountGroupMonth(year);
      List<MonthlyFirstPassRateDTO> qhseList = this.qhseService.findQhseCountGroupMonth(year);
      List<MonthlyFirstPassRateDTO> dtos = new ArrayList<>();
      Map<String, Integer> inspectMap = inspectList.stream().collect(Collectors.toMap(s -> s.getDate(), s -> s.getInspectQuantity()));
      Map<String, Integer> qhseMap = qhseList.stream().collect(Collectors.toMap(s -> s.getDate(), s -> s.getQhseQuantity()));
      int appendYear = year;

      for (int i = 1; i <= 12; i++) {
         String appedstr;
         if (i < 10) {
            appedstr = "-0";
         } else {
            appedstr = "-";
         }

         Integer insepctQuantity = inspectMap.get(appendYear + appedstr + i) == null ? 0 : inspectMap.get(appendYear + appedstr + i);
         Integer qhseQuantity = qhseMap.get(appendYear + appedstr + i) == null ? 0 : qhseMap.get(appendYear + appedstr + i);
         MonthlyFirstPassRateDTO dto = MonthlyFirstPassRateDTO.builder()
            .date(appendYear + appedstr + i)
            .qhseQuantity(qhseQuantity)
            .InspectQuantity(insepctQuantity)
            .build();
         if (dto.getQhseQuantity() + dto.getInspectQuantity() == 0) {
            dto.setPassingRate(BigDecimal.valueOf(0L));
         } else {
            dto.setPassingRate(
               BigDecimal.valueOf(dto.getInspectQuantity().intValue())
                  .divide(BigDecimal.valueOf(dto.getQhseQuantity() + dto.getInspectQuantity()), 2, RoundingMode.HALF_UP)
                  .multiply(BigDecimal.valueOf(100L))
            );
         }

         dtos.add(dto);
      }

      return dtos;
   }

   @Override
   public List<QhseAlertDTO> findQuailyQhseAlert() {
      return this.qhseService
         .findQuailyQhseAlert(
            null,
            Arrays.asList(
               QhseStatusEnum.UN_RECTIFIED.getType(),
               QhseStatusEnum.RECTIFIED.getType(),
               QhseStatusEnum.UN_ADOPT.getType(),
               QhseStatusEnum.CONCESSION_ACCEPTED.getType(),
               QhseStatusEnum.CONCESSION_ACCEPTED_UN_APPROVED.getType()
            )
         );
   }

   @Override
   public List<QhseAlertDTO> findQuailyQhsePassAlert() {
      List<QhseAlertDTO> quailyQhseAlert = this.qhseService
         .findQuailyQhseAlert(1, Arrays.asList(QhseStatusEnum.ADOPT.getType(), QhseStatusEnum.CONCESSION_ACCEPTED_APPROVED.getType()));
      quailyQhseAlert.forEach(e -> e.setStatusName(QhseStatusEnum.getVal(e.getStatus())));
      return quailyQhseAlert;
   }

   @Override
   public List<QualityInspectionStatisticsDTO> findQualityInspectionStatistics(LocalDateTime date) {
      return this.qhseService.findQualityInspectionStatistics(date == null ? null : date.getYear());
   }

   @Override
   public List<TeamQhseRankingDTO> findTeamQhseRanking(LocalDateTime date) {
      return this.qhseService.findTeamQhseRanking(date == null ? null : date.getYear());
   }
}
