package com.hzchum.scim.operational.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.KevMeteDO;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.CompleteMeteYearDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.ProductionTypeAnalysisDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.DateMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProjectMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.TeamProduceOperateAnalyseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.TeamProduceOperateAnalyseDetailsDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.operational.analysis.core.api.biz.ProduceAchievementBiz;
import com.hzchum.scim.operational.analysis.core.api.enums.DateTypeEnum;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.CommonHeadDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ProductionSummaryDTO;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsDateMeteDTO;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnDetailService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class ProduceAchievementBizImpl implements ProduceAchievementBiz {
   private static final Logger log = LoggerFactory.getLogger(ProduceAchievementBizImpl.class);
   @Resource
   private ContractProjectService projectService;
   @Resource
   private MesBuildingProduceTeamReportService teamReportService;
   @Resource
   private MesBuildingProductionLineService lineService;
   @Resource
   private MesBuildingCompleteService completeService;
   @Resource
   private MoveOutboundDetailService moveOutboundDetailService;
   @Resource
   private ReturnDetailService returnDetailService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private MesBuildingWorkshopService workshopService;
   @Resource
   private ReportService reportService;
   @Resource
   private MesBuildingWarehouseSummaryService warehouseSummaryService;

   @Override
   public ProductionSummaryDTO getProductionSummary(LocalDate year, Long branchCompanyId, Long workshopId) {
      ProductionSummaryDTO summaryDTO = ProductionSummaryDTO.builder()
         .totalMete(BigDecimal.ZERO)
         .lastYearTotalMete(BigDecimal.ZERO)
         .ratio(BigDecimal.ZERO)
         .build();
      List<DateMeteDTO> productionSummary = this.teamReportService.getProductionSummary(null, year, branchCompanyId, workshopId);
      Map<String, BigDecimal> productionMap = productionSummary.stream().collect(Collectors.toMap(DateMeteDTO::getDateTime, DateMeteDTO::getMete));
      summaryDTO.setTotalMete(productionMap.getOrDefault(String.valueOf(year.getYear()), BigDecimal.ZERO));
      summaryDTO.setLastYearTotalMete(productionMap.getOrDefault(String.valueOf(year.getYear() - 1), BigDecimal.ZERO));
      if (summaryDTO.getTotalMete().compareTo(BigDecimal.ZERO) == 0) {
         summaryDTO.setRatio(BigDecimal.ZERO);
      } else if (summaryDTO.getLastYearTotalMete().compareTo(BigDecimal.ZERO) == 0) {
         summaryDTO.setRatio(BigDecimal.ZERO);
      } else {
         summaryDTO.setRatio(
            summaryDTO.getTotalMete()
               .subtract(summaryDTO.getLastYearTotalMete())
               .multiply(BigDecimal.valueOf(100L))
               .divide(summaryDTO.getLastYearTotalMete(), 2, RoundingMode.HALF_UP)
         );
      }

      return summaryDTO;
   }

   @Override
   public CompleteMeteYearDTO getTargetRatio(LocalDate year, Long branchCompanyId, Long workshopId) {
      BigDecimal yearMete = BigDecimal.ZERO;
      Map<String, BigDecimal> productionMap = this.teamReportService
         .getProductionSummary(null, year, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(DateMeteDTO::getDateTime, DateMeteDTO::getMete));
      yearMete = productionMap.getOrDefault(String.valueOf(year.getYear()), BigDecimal.ZERO);
      int mouthValue = 12;
      if (year.getYear() == LocalDate.now().getYear()) {
         mouthValue = LocalDate.now().getMonthValue();
      }

      BigDecimal targetMete = this.lineService
         .list(
            Wrappers.lambdaQuery(MesBuildingProductionLine.class)
               .eq(workshopId != null, MesBuildingProductionLine::getWorkshopId, workshopId)
               .eq(MesBuildingProductionLine::getBoolEnabledEnum, 1)
               .eq(MesBuildingProductionLine::getProductType, ProductTypeEnum.ARTIFACT.getType())
         )
         .stream()
         .map(MesBuildingProductionLine::getTargetProduction)
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .multiply(new BigDecimal(mouthValue));
      return CompleteMeteYearDTO.builder()
         .completeMete(yearMete.divide(BigDecimal.valueOf(1000L)))
         .target(targetMete.divide(BigDecimal.valueOf(1000L)))
         .build();
   }

   @Override
   public Map<String, Object> getAvgProduction(LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      int mouthValue = 12;
      if (yearDate.getYear() == LocalDate.now().getYear()) {
         mouthValue = LocalDate.now().getMonthValue();
      }

      Map<String, BigDecimal> productionMap = this.teamReportService
         .getProductionMonthlyV2(null, LocalDate.of(yearDate.getYear(), 1, 1), LocalDate.of(yearDate.getYear(), mouthValue, 1), branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(DateMeteDTO::getDateTime, DateMeteDTO::getMete));
      List<DateMeteDTO> numbersMonthly = this.teamReportService
         .getNumbersMonthly(null, LocalDate.of(yearDate.getYear(), 1, 1), LocalDate.of(yearDate.getYear(), mouthValue, 1), branchCompanyId, workshopId);
      Map<String, Integer> numbersMap = numbersMonthly.stream().collect(Collectors.toMap(DateMeteDTO::getDateTime, DateMeteDTO::getNumbers));
      Map<String, BigDecimal> productionMap2 = this.teamReportService
         .getProductionMonthlyV2(null, LocalDate.of(yearDate.getYear() - 1, 1, 1), LocalDate.of(yearDate.getYear(), mouthValue, 1), branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(DateMeteDTO::getDateTime, DateMeteDTO::getMete));
      Map<String, Integer> numbersMap2 = this.teamReportService
         .getNumbersMonthly(null, LocalDate.of(yearDate.getYear() - 1, 1, 1), LocalDate.of(yearDate.getYear(), mouthValue, 1), branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(DateMeteDTO::getDateTime, DateMeteDTO::getNumbers));
      HashMap<String, Object> map = new HashMap<>();
      List<DateMeteDTO> currentList = new ArrayList<>();
      List<DateMeteDTO> lastList = new ArrayList<>();

      for (int i = 1; i <= 12; i++) {
         String currentKey = yearDate.getYear() + "-" + String.format("%02d", i);
         String lastKey = yearDate.getYear() - 1 + "-" + String.format("%02d", i);
         DateMeteDTO currentMeteDO = DateMeteDTO.builder()
            .dateTime(currentKey)
            .mete(productionMap.getOrDefault(currentKey, BigDecimal.ZERO))
            .numbers(numbersMap.getOrDefault(currentKey, 0))
            .build();
         currentList.add(currentMeteDO);
         DateMeteDTO lastMeteDO = DateMeteDTO.builder()
            .dateTime(lastKey)
            .mete(productionMap2.getOrDefault(lastKey, BigDecimal.ZERO))
            .numbers(numbersMap2.getOrDefault(lastKey, 0))
            .build();
         lastList.add(lastMeteDO);
      }

      map.put("currentList", currentList);
      map.put("lastList", lastList);
      return map;
   }

   @Override
   public Map<String, Object> getAvgProductionYear(LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      Map<String, BigDecimal> meteMap = this.teamReportService
         .getProductionSummary(null, yearDate, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(DateMeteDTO::getDateTime, DateMeteDTO::getMete));
      Map<String, Integer> numbersMap = this.teamReportService
         .getNumbersYear(null, yearDate, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(DateMeteDTO::getDateTime, DateMeteDTO::getNumbers));
      BigDecimal currentMete = meteMap.getOrDefault(String.valueOf(yearDate.getYear()), BigDecimal.ZERO);
      BigDecimal lastMete = meteMap.getOrDefault(String.valueOf(yearDate.getYear() - 1), BigDecimal.ZERO);
      Integer currentNumbers = numbersMap.getOrDefault(String.valueOf(yearDate.getYear()), 0);
      Integer lastNumbers = numbersMap.getOrDefault(String.valueOf(yearDate.getYear() - 1), 0);
      Map<String, Object> map = new HashMap<>();
      map.put(
         "currentRatio",
         currentMete.compareTo(BigDecimal.ZERO) != 0 && currentNumbers != 0
            ? currentMete.divide(BigDecimal.valueOf(1000L)).divide(BigDecimal.valueOf(currentNumbers.intValue()), 3, 4)
            : 0
      );
      map.put(
         "lastRatio",
         lastMete.compareTo(BigDecimal.ZERO) != 0 && lastNumbers != 0
            ? lastMete.divide(BigDecimal.valueOf(1000L)).divide(BigDecimal.valueOf(lastNumbers.intValue()), 3, 4)
            : 0
      );
      return map;
   }

   @Override
   public List<DateMeteDTO> getMainOutMete(LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      Map<String, BigDecimal> productionMap = this.teamReportService
         .getProductionMonthlyV2(null, LocalDate.of(yearDate.getYear(), 1, 1), LocalDate.of(yearDate.getYear(), 12, 1), branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(DateMeteDTO::getDateTime, DateMeteDTO::getMete));
      Map<String, BigDecimal> outMeteMap = this.moveOutboundDetailService
         .getMaterialLossMete(263, null, LocalDate.of(yearDate.getYear(), 1, 1), LocalDate.of(yearDate.getYear(), 12, 1), branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(WmsDateMeteDTO::getDateTime, WmsDateMeteDTO::getMete));
      List<DateMeteDTO> resultList = new ArrayList<>();

      for (int i = 1; i <= 12; i++) {
         String key = yearDate.getYear() + "-" + String.format("%02d", i);
         DateMeteDTO meteDO = DateMeteDTO.builder()
            .dateTime(key)
            .mete(productionMap.getOrDefault(key, BigDecimal.ZERO))
            .outMete(outMeteMap.getOrDefault(key, BigDecimal.ZERO))
            .build();
         if (meteDO.getMete().compareTo(BigDecimal.ZERO) != 0 && meteDO.getOutMete().compareTo(BigDecimal.ZERO) != 0) {
            meteDO.setRatio(
               meteDO.getOutMete().subtract(meteDO.getMete()).multiply(BigDecimal.valueOf(100L)).divide(meteDO.getOutMete(), 2, RoundingMode.HALF_UP)
            );
         } else {
            meteDO.setRatio(BigDecimal.ZERO);
         }

         resultList.add(meteDO);
      }

      return resultList;
   }

   @Override
   public List<DateMeteDTO> getMainOutMeteV2(LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      List<LocalDate> dateList = this.getNearSixYearDate(yearDate);
      Map<String, BigDecimal> mainOutMap = this.moveOutboundDetailService
         .getMainOutMeteV2(dateList, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(WmsDateMeteDTO::getDateTime, WmsDateMeteDTO::getMete));
      Map<String, BigDecimal> productOutMeteMap = this.warehouseSummaryService
         .getProductOutMete(dateList, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(KevMeteDO::getGroupKey, KevMeteDO::getMete));
      Map<String, BigDecimal> saleMeteMap = this.reportService
         .getWasteSaleMete(dateList, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(WmsDateMeteDTO::getDateTime, WmsDateMeteDTO::getMete));
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
      return dateList.stream().map(e -> {
         String key = e.format(formatter);
         BigDecimal productKg = productOutMeteMap.getOrDefault(key, BigDecimal.ZERO);
         BigDecimal issuedKg = mainOutMap.getOrDefault(key, BigDecimal.ZERO);
         BigDecimal wasteTonnes = saleMeteMap.getOrDefault(key, BigDecimal.ZERO);
         BigDecimal kgPerTonne = BigDecimal.valueOf(1000L);
         BigDecimal lossRate = issuedKg.signum() == 0 ? BigDecimal.ZERO :
            issuedKg.subtract(productKg).subtract(wasteTonnes.multiply(kgPerTonne))
               .movePointRight(2).divide(issuedKg, 2, RoundingMode.HALF_UP);
         return DateMeteDTO.builder().dateTime(key)
            .mete(productKg.divide(kgPerTonne, 0, RoundingMode.HALF_UP))
            .outMete(issuedKg.divide(kgPerTonne, 0, RoundingMode.HALF_UP))
            .sellMete(wasteTonnes.setScale(0, RoundingMode.HALF_UP))
            .ratio(lossRate)
            .build();
      }).collect(Collectors.toList());
   }

   @Override
   public List<DateMeteDTO> getMaterialLossDetailsV2(LocalDate year, Long branchCompanyId, Long workshopId) {
      List<LocalDate> twelveMonthList = this.getTwelveMonthDate(year);
      Map<String, BigDecimal> mainOutMeteMap = this.moveOutboundDetailService
         .getMainOutMeteDetailV2(twelveMonthList, year, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(WmsDateMeteDTO::getDateTime, WmsDateMeteDTO::getMete));
      Map<String, BigDecimal> productOutMeteMap = this.warehouseSummaryService
         .getProductOutMeteDetailV2(twelveMonthList, year, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(KevMeteDO::getGroupKey, KevMeteDO::getMete));
      Map<String, BigDecimal> saleMeteMap = this.reportService
         .getWasteSaleMeteDetail(twelveMonthList, year, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(WmsDateMeteDTO::getDateTime, WmsDateMeteDTO::getMete));
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
      return twelveMonthList.stream().map(e -> {
         String key = e.format(formatter);
         BigDecimal productOutMete = productOutMeteMap.getOrDefault(key, BigDecimal.ZERO);
         BigDecimal mainOutMete = mainOutMeteMap.getOrDefault(key, BigDecimal.ZERO);
         BigDecimal saleMete = saleMeteMap.getOrDefault(key, BigDecimal.ZERO);
         BigDecimal lossMete = mainOutMete.subtract(productOutMete).divide(BigDecimal.valueOf(1000L)).subtract(saleMete).setScale(0, RoundingMode.HALF_UP);
         return DateMeteDTO.builder().dateTime(key).mete(productOutMete).outMete(mainOutMete).sellMete(saleMete).lossMete(lossMete).build();
      }).collect(Collectors.toList());
   }

   @Override
   public void getMaterialLossDetailsDownloadV2(LocalDate mouthDate, Long branchCompanyId, Long workshopId) {
      CommonHeadDTO headDTO = this.getProduceAchievementHeadDTO(mouthDate, branchCompanyId, workshopId, DateTypeEnum.YEAR.getType());
      Map<String, Object> resultMap = BeanUtil.beanToMap(headDTO);
      List<DateMeteDTO> resultList = this.getMaterialLossDetailsV2(mouthDate, branchCompanyId, workshopId);
      BigDecimal avgLossRate = BigDecimal.ZERO;
      BigDecimal outMete = resultList.stream().filter(e -> e.getOutMete() != null).map(DateMeteDTO::getOutMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal productMete = resultList.stream().map(DateMeteDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal wasteTonnes = resultList.stream().map(DateMeteDTO::getSellMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      if (outMete.compareTo(BigDecimal.ZERO) != 0) {
         avgLossRate = outMete.subtract(productMete).subtract(wasteTonnes.multiply(BigDecimal.valueOf(1000L)))
            .multiply(BigDecimal.valueOf(100L)).divide(outMete, 2, RoundingMode.HALF_UP);
      }

      // The API uses kg for issued/shipped material; this existing workbook is labelled tonnes.
      resultList.forEach(e -> {
         e.setOutMete(e.getOutMete().divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP));
         e.setMete(e.getMete().divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP));
      });
      resultMap.put("resultList", resultList);
      resultMap.put("avgLossRate", avgLossRate);
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/MaterialLossDetails.xlsx";
      String exportFileName = "月度主材损耗详情.xlsx";
      this.download(resultMap, tempFileName, resourcePath, exportFileName);
   }

   private List<LocalDate> getNearSixYearDate(LocalDate yearDate) {
      int currentYear = yearDate.getYear();
      return IntStream.rangeClosed(currentYear - 5, currentYear).mapToObj(year -> LocalDate.of(year, 1, 1)).collect(Collectors.toList());
   }

   public List<LocalDate> getTwelveMonthDate(LocalDate yearDate) {
      int year = yearDate.getYear();
      return IntStream.rangeClosed(1, 12).mapToObj(month -> LocalDate.of(year, month, 1)).collect(Collectors.toList());
   }

   @Override
   public void getMainOutMeteDownload(LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      CommonHeadDTO headDTO = this.getProduceAchievementHeadDTO(yearDate, branchCompanyId, workshopId, DateTypeEnum.YEAR.getType());
      Map<String, Object> resultMap = BeanUtil.beanToMap(headDTO);
      List<DateMeteDTO> resultList = this.getMainOutMete(yearDate, branchCompanyId, workshopId);
      AtomicReference<Long> orderNo = new AtomicReference<>(0L);
      resultList.forEach(e -> {
         orderNo.set(orderNo.get() + 1L);
         e.setIndex(orderNo.get());
         e.setMete(e.getMete().divide(BigDecimal.valueOf(1000L), 0, 4));
         e.setOutMete(e.getOutMete().divide(BigDecimal.valueOf(1000L), 0, 4));
      });
      resultMap.put("resultList", resultList);
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/MainOutMete.xlsx";
      String exportFileName = "年度主材损耗详情.xlsx";
      this.download(resultMap, tempFileName, resourcePath, exportFileName);
   }

   @Override
   public List<ProjectMeteDTO> getMaterialLossDetails(LocalDate mouthDate, Long branchCompanyId, Long workshopId) {
      return this.moveOutboundDetailService.getMaterialLossDetails(263, mouthDate, branchCompanyId, workshopId).stream().peek(e -> {
         e.setMete(e.getMete().divide(BigDecimal.valueOf(1000L), 0, 4));
         e.setLoseMete(e.getLoseMete().divide(BigDecimal.valueOf(1000L), 0, 4));
      }).collect(Collectors.toList());
   }

   @Override
   public void getMaterialLossDetailsDownload(LocalDate mouthDate, Long branchCompanyId, Long workshopId) {
      CommonHeadDTO headDTO = this.getProduceAchievementHeadDTO(mouthDate, branchCompanyId, workshopId, DateTypeEnum.MONTH.getType());
      Map<String, Object> resultMap = BeanUtil.beanToMap(headDTO);
      List<ProjectMeteDTO> resultList = this.getMaterialLossDetails(mouthDate, branchCompanyId, workshopId);
      AtomicReference<Long> orderNo = new AtomicReference<>(0L);
      resultList.forEach(e -> {
         orderNo.set(orderNo.get() + 1L);
         e.setIndex(orderNo.get());
         e.setProjectSimpleInfo(e.getProjectInfo().getSerialNumber() + "-" + e.getProjectInfo().getShortName());
      });
      resultMap.put("resultList", resultList);
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/MaterialLossDetails.xlsx";
      String exportFileName = "月度主材损耗详情.xlsx";
      this.download(resultMap, tempFileName, resourcePath, exportFileName);
   }

   @Override
   public List<DateMeteDTO> getYearSchedulingProductionInfo(LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      List<DateMeteDTO> resultList = new ArrayList<>();
      Map<String, BigDecimal> taskMeteMap = this.teamReportService
         .getSchedulingMonthly(null, yearDate, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(DateMeteDTO::getDateTime, DateMeteDTO::getMete));
      Map<String, BigDecimal> meteMap = this.teamReportService
         .getProductionMonthlyV2(null, LocalDate.of(yearDate.getYear(), 1, 1), LocalDate.of(yearDate.getYear(), 12, 1), branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(DateMeteDTO::getDateTime, DateMeteDTO::getMete));

      for (int i = 1; i <= 12; i++) {
         String key = yearDate.getYear() + "-" + String.format("%02d", i);
         BigDecimal taskMete = taskMeteMap.getOrDefault(key, BigDecimal.ZERO);
         BigDecimal mete = meteMap.getOrDefault(key, BigDecimal.ZERO);
         DateMeteDTO build = DateMeteDTO.builder()
            .dateTime(key)
            .taskMete(taskMete)
            .mete(mete)
            .ratio(
               mete.compareTo(BigDecimal.ZERO) != 0 && taskMete.compareTo(BigDecimal.ZERO) != 0
                  ? mete.multiply(BigDecimal.valueOf(100L)).divide(taskMete, 2, 4)
                  : BigDecimal.ZERO
            )
            .build();
         resultList.add(build);
      }

      return resultList;
   }

   @Override
   public void getYearSchedulingProductionInfoDownload(LocalDate year, Long branchCompanyId, Long workshopId) {
      CommonHeadDTO headDTO = this.getProduceAchievementHeadDTO(year, branchCompanyId, workshopId, DateTypeEnum.YEAR.getType());
      Map<String, Object> resultMap = BeanUtil.beanToMap(headDTO);
      List<DateMeteDTO> resultList = this.getYearSchedulingProductionInfo(year, branchCompanyId, workshopId);
      AtomicReference<Long> orderNo = new AtomicReference<>(0L);
      resultList.forEach(e -> {
         orderNo.set(orderNo.get() + 1L);
         e.setIndex(orderNo.get());
         e.setMete(e.getMete().divide(BigDecimal.valueOf(1000L), 0, 4));
         e.setTaskMete(e.getTaskMete().divide(BigDecimal.valueOf(1000L), 0, 4));
      });
      resultMap.put("resultList", resultList);
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/yearSchedulingProductionInfoDetails.xlsx";
      String exportFileName = "年度任务达成率分析.xlsx";
      this.download(resultMap, tempFileName, resourcePath, exportFileName);
   }

   @Override
   public List<ProjectMeteDTO> getProjectSchedulingProductionInfo(LocalDate yearMonth, Long branchCompanyId, Long workshopId) {
      return this.teamReportService.getProjectSchedulingProductionInfo(null, yearMonth, branchCompanyId, workshopId);
   }

   @Override
   public void getProjectSchedulingProductionInfoDownload(LocalDate year, Long branchCompanyId, Long workshopId) {
      CommonHeadDTO headDTO = this.getProduceAchievementHeadDTO(year, branchCompanyId, workshopId, DateTypeEnum.MONTH.getType());
      Map<String, Object> resultMap = BeanUtil.beanToMap(headDTO);
      List<ProjectMeteDTO> resultList = this.getProjectSchedulingProductionInfo(year, branchCompanyId, workshopId);
      AtomicReference<Long> orderNo = new AtomicReference<>(0L);
      resultList.forEach(e -> {
         orderNo.set(orderNo.get() + 1L);
         e.setIndex(orderNo.get());
         e.setProjectSimpleInfo(e.getProjectInfo().getSerialNumber() + "-" + e.getProjectInfo().getShortName());
         if (e.getMete() != null) {
            e.setMete(e.getMete().divide(BigDecimal.valueOf(1000L), 0, 4));
         }

         if (e.getTaskMete() != null) {
            e.setTaskMete(e.getTaskMete().divide(BigDecimal.valueOf(1000L), 0, 4));
         }
      });
      resultMap.put("resultList", resultList);
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/ProjectSchedulingProductionInfoDetails.xlsx";
      String exportFileName = "月度项目任务达成率分析.xlsx";
      this.download(resultMap, tempFileName, resourcePath, exportFileName);
   }

   @Override
   public List<TeamProduceOperateAnalyseDTO> getTeamProduceOperateAnalyse(LocalDate year, Long branchCompanyId, Long workshopId, Long processId) {
      return this.teamReportService
         .getTeamProduceOperateAnalyse(null, year, branchCompanyId, workshopId, processId)
         .stream()
         .sorted(
            Comparator.<TeamProduceOperateAnalyseDTO, Long>comparing(o -> o.getWorkshop().getId())
               .thenComparing(o -> o.getTeam().getId())
               .thenComparingInt(p -> Arrays.asList(1, 16, 2).indexOf(p.getTaskTypeEnum()))
         )
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<TeamProduceOperateAnalyseDetailsDTO> getTeamProduceDetailsOperateAnalyse(
      LocalDate yearDate,
      LocalDate startDate,
      LocalDate endDate,
      Long branchCompanyId,
      Long workshopId,
      Long teamId,
      Integer taskTypeEnum,
      Long processId,
      Integer pageNumber,
      Integer pageSize
   ) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<TeamProduceOperateAnalyseDetailsDTO> detailsDTOList = this.teamReportService
         .getTeamProduceDetailsOperateAnalyse(null, yearDate, startDate, endDate, branchCompanyId, workshopId, teamId, taskTypeEnum, processId);
      return new PageVO<>(page, detailsDTOList);
   }

   @Override
   public void getTeamProduceDetailsOperateAnalyseDownload(
      LocalDate yearDate, LocalDate startDate, LocalDate endDate, Long branchCompanyId, Long workshopId, Long teamId, Integer taskTypeEnum, Long processId
   ) {
      CommonHeadDTO headDTO = this.getProduceAchievementHeadDTO(
         startDate != null ? startDate : yearDate,
         branchCompanyId,
         workshopId,
         yearDate.compareTo(startDate) != 0 ? DateTypeEnum.MONTH.getType() : DateTypeEnum.YEAR.getType()
      );
      Map<String, Object> resultMap = BeanUtil.beanToMap(headDTO);
      List<TeamProduceOperateAnalyseDetailsDTO> resultList = this.teamReportService
         .getTeamProduceDetailsOperateAnalyse(null, yearDate, startDate, endDate, branchCompanyId, workshopId, teamId, taskTypeEnum, processId);
      AtomicReference<Long> orderNo = new AtomicReference<>(0L);
      resultList.forEach(e -> {
         orderNo.set(orderNo.get() + 1L);
         e.setIndex(orderNo.get());
         e.setProjectSimpleInfo(e.getProjectInfo().getSerialNumber() + "-" + e.getProjectInfo().getShortName());
      });
      resultMap.put("resultList", resultList);
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/TeamProduceDetailsOperateAnalyse.xlsx";
      String exportFileName = "班组产量详情.xlsx";
      this.download(resultMap, tempFileName, resourcePath, exportFileName);
   }

   @Override
   public List<ProductionTypeAnalysisDO> productionTypeAnalysisV2(LocalDate dateTime, Integer productType, Long branchCompanyId) {
      return this.completeService.productionTypeAnalysisV2(dateTime, productType, null, branchCompanyId);
   }

   @Override
   public HashMap<String, Object> getProductionMonthly(LocalDate year, Long branchCompanyId, Long workshopId) {
      LocalDate year2 = year.minusYears(1L);
      LocalDate year3 = year.minusYears(2L);
      Map<String, BigDecimal> map1 = this.teamReportService
         .getProductionMonthly(year, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(DateMeteDTO::getDateTime, DateMeteDTO::getMete));
      Map<String, BigDecimal> map2 = this.teamReportService
         .getProductionMonthly(year2, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(DateMeteDTO::getDateTime, DateMeteDTO::getMete));
      Map<String, BigDecimal> map3 = this.teamReportService
         .getProductionMonthly(year3, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(DateMeteDTO::getDateTime, DateMeteDTO::getMete));
      List<WmsDateMeteDTO> currentList = new ArrayList<>();
      List<WmsDateMeteDTO> lastList = new ArrayList<>();
      List<WmsDateMeteDTO> frontList = new ArrayList<>();

      for (int i = 1; i <= 12; i++) {
         String key1 = year.getYear() + "-" + String.format("%02d", i);
         String key2 = year2.getYear() + "-" + String.format("%02d", i);
         String key3 = year3.getYear() + "-" + String.format("%02d", i);
         currentList.add(WmsDateMeteDTO.builder().dateTime(key1).mete(map1.getOrDefault(key1, BigDecimal.ZERO)).build());
         lastList.add(WmsDateMeteDTO.builder().dateTime(key2).mete(map2.getOrDefault(key2, BigDecimal.ZERO)).build());
         frontList.add(WmsDateMeteDTO.builder().dateTime(key3).mete(map3.getOrDefault(key3, BigDecimal.ZERO)).build());
      }

      HashMap<String, Object> resultMap = new HashMap<>();
      resultMap.put("currentList", currentList);
      resultMap.put("lastList", lastList);
      resultMap.put("frontList", frontList);
      return resultMap;
   }

   @Override
   public List<DateMeteDTO> getTargetProductionAnalysis(LocalDate year, Long branchCompanyId, Long workshopId) {
      int mouthValue = 12;
      if (year.getYear() == LocalDate.now().getYear()) {
         mouthValue = LocalDate.now().getMonthValue();
      }

      BigDecimal targetMete = this.lineService
         .list(
            Wrappers.lambdaQuery(MesBuildingProductionLine.class)
               .eq(workshopId != null, MesBuildingProductionLine::getWorkshopId, workshopId)
               .eq(MesBuildingProductionLine::getBoolEnabledEnum, 1)
               .eq(MesBuildingProductionLine::getProductType, ProductTypeEnum.ARTIFACT.getType())
         )
         .stream()
         .map(MesBuildingProductionLine::getTargetProduction)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      return this.teamReportService
         .getProductionMonthlyV2(null, LocalDate.of(year.getYear(), 1, 1), LocalDate.of(year.getYear(), mouthValue, 1), branchCompanyId, workshopId)
         .stream()
         .peek(e -> e.setRatio(e.getMete().multiply(BigDecimal.valueOf(100L)).divide(targetMete, 2, RoundingMode.HALF_UP)))
         .collect(Collectors.toList());
   }

   @Override
   public void downloadTargetProductionAnalysis(LocalDate year, Long branchCompanyId, Long workshopId) {
      CommonHeadDTO headDTO = this.getProduceAchievementHeadDTO(year, branchCompanyId, workshopId, DateTypeEnum.YEAR.getType());
      Map<String, Object> resultMap = BeanUtil.beanToMap(headDTO);
      List<DateMeteDTO> resultList = this.getTargetProductionAnalysis(year, branchCompanyId, workshopId);
      AtomicReference<Long> orderNo = new AtomicReference<>(0L);
      resultList.forEach(e -> {
         orderNo.set(orderNo.get() + 1L);
         e.setIndex(orderNo.get());
         e.setMete(e.getMete().divide(BigDecimal.valueOf(1000L), 0, 4));
      });
      resultMap.put("resultList", resultList);
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/targetProductionDetailsV2.xlsx";
      String exportFileName = "年度目标产量达成率详情.xlsx";
      this.download(resultMap, tempFileName, resourcePath, exportFileName);
   }

   @Override
   public List<DateMeteDTO> getProductionDay(LocalDate yearDate, LocalDate mouthDate, Long branchCompanyId, Long workshopId) {
      mouthDate = LocalDate.of(mouthDate.getYear(), mouthDate.getMonthValue(), 1);
      Map<String, DateMeteDTO> dayMap = this.teamReportService
         .getProductionDay(null, yearDate, mouthDate, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(DateMeteDTO::getDateTime, Function.identity()));
      return this.getDatesUntilToday(mouthDate)
         .stream()
         .map(e -> dayMap.getOrDefault(e, DateMeteDTO.builder().dateTime(e).mete(BigDecimal.ZERO).build()))
         .collect(Collectors.toList());
   }

   @Override
   public List<ProjectMeteDTO> getProjectMete(LocalDate dateTime, Long branchCompanyId, Long workshopId, Boolean isMonthly) {
      List<ProjectMeteDTO> projectMeteList = this.teamReportService.getProjectMete(null, dateTime, branchCompanyId, workshopId, isMonthly);
      return CollectionUtils.isEmpty(projectMeteList) ? new ArrayList<>() : projectMeteList;
   }

   @Override
   public void getProjectMeteDownload(LocalDate dateTime, Long branchCompanyId, Long workshopId, Boolean isMonthly) {
      CommonHeadDTO headDTO = this.getProduceAchievementHeadDTO(
         dateTime, branchCompanyId, workshopId, isMonthly ? DateTypeEnum.MONTH.getType() : DateTypeEnum.DAY.getType()
      );
      Map<String, Object> resultMap = BeanUtil.beanToMap(headDTO);
      List<ProjectMeteDTO> resultList = this.getProjectMete(dateTime, branchCompanyId, workshopId, isMonthly);
      AtomicReference<Long> orderNo = new AtomicReference<>(0L);
      resultList.forEach(e -> {
         orderNo.set(orderNo.get() + 1L);
         e.setIndex(orderNo.get());
         e.setProjectSimpleInfo(e.getProjectInfo().getSerialNumber() + "-" + e.getProjectInfo().getShortName());
         e.setMete(e.getMete().divide(BigDecimal.valueOf(1000L), 0, 4));
      });
      resultMap.put("resultList", resultList);
      String tempFileName = "ResourcePlan";
      String resourcePath = "files/monthDayProductionDetails.xlsx";
      String exportFileName = (isMonthly ? "月" : "日") + "产量详情.xlsx";
      this.download(resultMap, tempFileName, resourcePath, exportFileName);
   }

   private CommonHeadDTO getProduceAchievementHeadDTO(LocalDate dateTime, Long branchCompanyId, Long workshopId, @NotNull Integer dateType) {
      CommonHeadDTO commonHeadDTO = CommonHeadDTO.builder().dateTime("全部").branchCompanyName("全部").workshopName("全部").build();
      if (dateTime != null) {
         String formatStr = DateTypeEnum.getFormatByType(dateType);
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStr);
         commonHeadDTO.setDateTime(dateTime.format(formatter));
      }

      if (branchCompanyId != null) {
         BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
         if (branchCompany != null) {
            commonHeadDTO.setBranchCompanyName(branchCompany.getName());
         }
      }

      if (workshopId != null) {
         MesBuildingWorkshop workshop = this.workshopService.getById(workshopId);
         if (workshop != null) {
            commonHeadDTO.setWorkshopName(workshop.getName());
         }
      }

      return commonHeadDTO;
   }

   private void download(Map<String, Object> result, String tempFileName, String resourcePath, String exportFileName) {
      ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
      assert servletRequestAttributes != null;
      HttpServletResponse response = servletRequestAttributes.getResponse();
      org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
      InputStream inputStream = null;

      try {
         inputStream = resource.getInputStream();
      } catch (IOException e) {
         e.printStackTrace();
      }

      File file = null;

      try {
         file = File.createTempFile(tempFileName, "xlsx");
      } catch (IOException e) {
         e.printStackTrace();
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      assert file != null;
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      params.setColForEach(true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, result);
      assert response != null;
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
   }

   private List<String> getDatesUntilToday(LocalDate inputDate) {
      List<String> dates = new ArrayList<>();
      LocalDate today = LocalDate.now();
      LocalDate firstDayOfInputMonth = inputDate.withDayOfMonth(1);
      if (inputDate.getYear() == today.getYear() && inputDate.getMonth() == today.getMonth()) {
         for (LocalDate date = firstDayOfInputMonth; !date.isAfter(today); date = date.plusDays(1L)) {
            dates.add(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
         }
      } else {
         int daysInMonth = inputDate.lengthOfMonth();

         for (int day = 1; day <= daysInMonth; day++) {
            LocalDate date = inputDate.withDayOfMonth(day);
            dates.add(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
         }
      }

      return dates;
   }

   private List<LocalDate> getYearMonthDateList(LocalDate year) {
      LocalDate startDate = LocalDate.of(year.getYear(), 1, 1);
      LocalDate endDate = LocalDate.of(year.getYear(), 12, 1);
      List<LocalDate> yearMonthList = new ArrayList<>();
      long monthsBetween = ChronoUnit.MONTHS.between(startDate, endDate);
      Stream.<LocalDate>iterate(startDate, date -> date.plusMonths(1L)).limit(monthsBetween + 1L).forEach(yearMonthList::add);
      return yearMonthList;
   }
}
