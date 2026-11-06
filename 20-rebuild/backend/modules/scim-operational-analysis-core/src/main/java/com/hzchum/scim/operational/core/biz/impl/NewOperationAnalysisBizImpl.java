package com.hzchum.scim.operational.core.biz.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.contract.core.api.enums.finance.WaterElectricityPropertyFeeTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractEquipmentDepreciation;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractFixedAssetsDepreciation;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGasSummary;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractReimbursementFee;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractTestingFee;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWageFee;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWaterElectricityPropertyFee;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.finance.ContractEquipmentDepreciationService;
import com.hzchum.scim.contract.core.api.service.finance.ContractFixedAssetsDepreciationService;
import com.hzchum.scim.contract.core.api.service.finance.ContractGasSummaryService;
import com.hzchum.scim.contract.core.api.service.finance.ContractReimbursementFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractTestingFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractWageFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractWaterElectricityPropertyFeeService;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.DateMeteDTO;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.wages.MesBuildingProduceTeamReportPriceService;
import com.hzchum.scim.operational.analysis.core.api.biz.NewOperationAnalysisBiz;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.MonthCostOrMeteDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ProductionCostAnalysisBaseDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ProductionCostAnalysisDTOV2;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.DateCostDTO;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NewOperationAnalysisBizImpl implements NewOperationAnalysisBiz {
   private static final Logger log = LoggerFactory.getLogger(NewOperationAnalysisBizImpl.class);
   @Resource
   private ContractGasSummaryService gasSummaryService;
   @Resource
   private ContractTestingFeeService testingFeeService;
   @Resource
   private ContractFixedAssetsDepreciationService fixedAssetsDepreciationService;
   @Resource
   private MesBuildingUtilsBiz mesBuildingUtilsBiz;
   @Resource
   private MesBuildingProduceTeamReportPriceService produceTeamReportPriceService;
   @Resource
   private ContractWaterElectricityPropertyFeeService waterElectricityPropertyFeeService;
   @Resource
   private ContractEquipmentDepreciationService equipmentDepreciationService;
   @Resource
   private ContractReimbursementFeeService reimbursementFeeService;
   @Resource
   private ContractWageFeeService wageFeeService;
   @Resource
   private MoveOutboundDetailService moveOutboundDetailService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private ClassificationService classificationService;
   @Resource
   private MesBuildingProduceTeamReportService teamReportService;

   @Override
   public List<ProductionCostAnalysisBaseDTO> getProductionCostAnalysisSummary(LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      return this.getAuxiliaryAmortizationDTO(yearDate, branchCompanyId, workshopId, null, BigDecimal.ZERO)
         .stream()
         .filter(e -> e.getSumMete().compareTo(BigDecimal.ZERO) > 0)
         .map(e -> BeanUtil.copy(e, ProductionCostAnalysisBaseDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<DateMeteDTO> getThreeYearsAvgInfo(LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      return new ArrayList<>(
         Arrays.asList(
            DateMeteDTO.builder()
               .dateTime(String.valueOf(yearDate.getYear() - 2))
               .avgCost(this.getYearAvgMete(yearDate.minusYears(2L), branchCompanyId, workshopId, null))
               .build(),
            DateMeteDTO.builder()
               .dateTime(String.valueOf(yearDate.getYear() - 1))
               .avgCost(this.getYearAvgMete(yearDate.minusYears(1L), branchCompanyId, workshopId, null))
               .build(),
            DateMeteDTO.builder()
               .dateTime(String.valueOf(yearDate.getYear()))
               .avgCost(this.getYearAvgMete(yearDate, branchCompanyId, workshopId, null))
               .build()
         )
      );
   }

   @Override
   public HashMap<String, Object> getYearsSummary(LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      HashMap<String, Object> resultMap = new HashMap<>();
      resultMap.put("totalMete", 0);
      resultMap.put("totalCost", 0);
      List<DateMeteDTO> productionMonthlyV2 = this.teamReportService
         .getProductionMonthlyV2(null, LocalDate.of(yearDate.getYear(), 1, 1), LocalDate.of(yearDate.getYear(), 12, 1), branchCompanyId, workshopId)
         .stream()
         .peek(e -> e.setMete(e.getMete().divide(BigDecimal.valueOf(1000L))))
         .collect(Collectors.toList());
      Map<String, BigDecimal> clMap = productionMonthlyV2.stream().collect(Collectors.toMap(DateMeteDTO::getDateTime, DateMeteDTO::getMete));
      List<MonthCostOrMeteDTO> monthDetails = this.getMonthDetails(yearDate, clMap);
      BigDecimal totalProductionMete = monthDetails.stream().map(MonthCostOrMeteDTO::getCostOrMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      List<ProductionCostAnalysisBaseDTO> detailsList = this.getAuxiliaryAmortizationDTO(yearDate, branchCompanyId, workshopId, null, totalProductionMete)
         .stream()
         .filter(e -> e.getSumMete().compareTo(BigDecimal.ZERO) > 0)
         .map(e -> BeanUtil.copy(e, ProductionCostAnalysisBaseDTO.class))
         .collect(Collectors.toList());
      BigDecimal totalCost = detailsList.stream().map(ProductionCostAnalysisBaseDTO::getSumMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      resultMap.put("totalMete", totalProductionMete);
      resultMap.put("totalCost", totalCost);
      return resultMap;
   }

   private BigDecimal getYearAvgMete(LocalDate yearDate, Long branchCompanyId, Long workshopId, List<Long> projectIds) {
      List<DateMeteDTO> productionMonthlyV2 = this.teamReportService
         .getProductionMonthlyV2(projectIds, LocalDate.of(yearDate.getYear(), 1, 1), LocalDate.of(yearDate.getYear(), 12, 1), branchCompanyId, workshopId)
         .stream()
         .peek(e -> e.setMete(e.getMete().divide(BigDecimal.valueOf(1000L))))
         .collect(Collectors.toList());
      Map<String, BigDecimal> clMap = productionMonthlyV2.stream().collect(Collectors.toMap(DateMeteDTO::getDateTime, DateMeteDTO::getMete));
      List<MonthCostOrMeteDTO> monthDetails = this.getMonthDetails(yearDate, clMap);
      BigDecimal totalProductionMete = monthDetails.stream().map(MonthCostOrMeteDTO::getCostOrMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      List<ProductionCostAnalysisBaseDTO> detailsList = this.getAuxiliaryAmortizationDTO(yearDate, branchCompanyId, workshopId, projectIds, totalProductionMete)
         .stream()
         .filter(e -> e.getSumMete().compareTo(BigDecimal.ZERO) > 0)
         .map(e -> BeanUtil.copy(e, ProductionCostAnalysisBaseDTO.class))
         .collect(Collectors.toList());
      BigDecimal totalCost = detailsList.stream().map(ProductionCostAnalysisBaseDTO::getSumMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      return totalProductionMete.compareTo(BigDecimal.ZERO) != 0 && totalCost.compareTo(BigDecimal.ZERO) != 0
         ? totalCost.divide(totalProductionMete, 0, 4)
         : BigDecimal.ZERO;
   }

   @Override
   public List<ProductionCostAnalysisDTOV2> getProductionCostAnalysisV2(LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      List<ProductionCostAnalysisDTOV2> rowList = new ArrayList<>();
      List<DateMeteDTO> productionMonthlyV2 = this.teamReportService
         .getProductionMonthlyV2(null, LocalDate.of(yearDate.getYear(), 1, 1), LocalDate.of(yearDate.getYear(), 12, 1), branchCompanyId, workshopId)
         .stream()
         .peek(e -> e.setMete(e.getMete().divide(BigDecimal.valueOf(1000L))))
         .collect(Collectors.toList());
      Map<String, BigDecimal> clMap = productionMonthlyV2.stream().collect(Collectors.toMap(DateMeteDTO::getDateTime, DateMeteDTO::getMete));
      List<MonthCostOrMeteDTO> monthDetails = this.getMonthDetails(yearDate, clMap);
      BigDecimal totalProductionMete = monthDetails.stream().map(MonthCostOrMeteDTO::getCostOrMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      rowList.add(ProductionCostAnalysisDTOV2.builder().className("产量合计").costInfoList(monthDetails).sumMete(totalProductionMete).sort(99999).build());
      List<ProductionCostAnalysisDTOV2> auxiliaryAmortizationDTOList = this.getAuxiliaryAmortizationDTO(
         yearDate, branchCompanyId, workshopId, null, totalProductionMete
      );
      rowList.addAll(auxiliaryAmortizationDTOList);
      List<MonthCostOrMeteDTO> monthSummaryDetails = this.getMonthSummaryDetails(rowList);
      BigDecimal totalMonthSummary = monthSummaryDetails.stream().map(MonthCostOrMeteDTO::getCostOrMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      rowList.add(
         ProductionCostAnalysisDTOV2.builder()
            .className("金额合计")
            .costInfoList(monthSummaryDetails)
            .sumMete(totalMonthSummary)
            .avgMete(
               totalMonthSummary.compareTo(BigDecimal.ZERO) != 0 && totalProductionMete.compareTo(BigDecimal.ZERO) != 0
                  ? totalMonthSummary.divide(totalProductionMete, 0, 4)
                  : BigDecimal.ZERO
            )
            .sort(98888)
            .build()
      );
      List<MonthCostOrMeteDTO> monthAvgDetails = this.getMonthAvgDetails(rowList);
      rowList.add(ProductionCostAnalysisDTOV2.builder().className("平均单价").costInfoList(monthAvgDetails).sort(100000).build());
      rowList.sort(Comparator.comparingInt(ProductionCostAnalysisDTOV2::getSort));
      return rowList;
   }

   private List<ProductionCostAnalysisDTOV2> getAuxiliaryAmortizationDTO(
      LocalDate yearDate, Long branchCompanyId, Long workshopId, List<Long> projectIds, BigDecimal totalProductionMete
   ) {
      List<ProductionCostAnalysisDTOV2> rowList = new ArrayList<>();
      List<Classification> oneLevelList = this.classificationService
         .list(
            Wrappers.lambdaQuery(Classification.class)
               .ne(Classification::getName, "油漆涂料")
               .eq(Classification::getBasicClass, BasicClassEnum.GENERAL_MATERIAL.getType())
               .eq(Classification::getLevel, 1)
         );
      List<DateCostDTO> materialCost = this.getMaterialCost(oneLevelList, projectIds, yearDate, branchCompanyId, workshopId);
      Map<String, List<DateCostDTO>> groupedByClassifyName = materialCost.stream().collect(Collectors.groupingBy(DateCostDTO::getClassifyName));
      oneLevelList.forEach(
         e -> {
            List<DateCostDTO> monthList = groupedByClassifyName.getOrDefault(e.getName(), null);
            if (CollectionUtils.isNotEmpty(monthList)) {
               Map<String, BigDecimal> outMap = monthList.stream().collect(Collectors.toMap(DateCostDTO::getDateTime, DateCostDTO::getAmountExcludingVAT));
               List<MonthCostOrMeteDTO> outDetails = this.getMonthDetails(yearDate, outMap);
               BigDecimal totalCost = outDetails.stream().map(MonthCostOrMeteDTO::getCostOrMete).reduce(BigDecimal.ZERO, BigDecimal::add);
               ProductionCostAnalysisDTOV2 build = ProductionCostAnalysisDTOV2.builder()
                  .className(e.getName())
                  .costInfoList(outDetails)
                  .sumMete(totalCost)
                  .avgMete(
                     totalCost.compareTo(BigDecimal.ZERO) != 0 && totalProductionMete.compareTo(BigDecimal.ZERO) != 0
                        ? totalCost.divide(totalProductionMete, 0, 4)
                        : BigDecimal.ZERO
                  )
                  .sort(rowList.size() + 1)
                  .build();
               rowList.add(build);
            } else {
               List<MonthCostOrMeteDTO> outDetails = this.getMonthDetails(yearDate, new HashMap<>());
               rowList.add(
                  ProductionCostAnalysisDTOV2.builder()
                     .className(e.getName())
                     .costInfoList(outDetails)
                     .sumMete(BigDecimal.ZERO)
                     .avgMete(BigDecimal.ZERO)
                     .sort(rowList.size() + 1)
                     .build()
               );
            }
         }
      );
      Map<String, BigDecimal> laborFeeMap = this.getLaborFeeMap(projectIds, yearDate, branchCompanyId, workshopId);
      List<MonthCostOrMeteDTO> laborFeeDetails = this.getMonthDetails(yearDate, laborFeeMap);
      BigDecimal totalLaborFee = laborFeeDetails.stream().map(MonthCostOrMeteDTO::getCostOrMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      rowList.add(
         ProductionCostAnalysisDTOV2.builder()
            .className("人工费")
            .costInfoList(laborFeeDetails)
            .sumMete(totalLaborFee)
            .avgMete(
               totalLaborFee.compareTo(BigDecimal.ZERO) != 0 && totalProductionMete.compareTo(BigDecimal.ZERO) != 0
                  ? totalLaborFee.divide(totalProductionMete, 0, 4)
                  : BigDecimal.ZERO
            )
            .sort(89999)
            .build()
      );
      Map<String, BigDecimal> gasFeeMap = this.getGasFeeMap(yearDate);
      List<MonthCostOrMeteDTO> gasFeeDetails = this.getMonthDetails(yearDate, gasFeeMap);
      BigDecimal totalGasFee = gasFeeDetails.stream().map(MonthCostOrMeteDTO::getCostOrMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      rowList.add(
         ProductionCostAnalysisDTOV2.builder()
            .className("气体费")
            .costInfoList(gasFeeDetails)
            .sumMete(totalGasFee)
            .avgMete(
               totalGasFee.compareTo(BigDecimal.ZERO) != 0 && totalProductionMete.compareTo(BigDecimal.ZERO) != 0
                  ? totalGasFee.divide(totalProductionMete, 0, 4)
                  : BigDecimal.ZERO
            )
            .sort(90000)
            .build()
      );
      Map<String, BigDecimal> waterElectricityFeeMap = this.getWaterElectricityFeeMap(yearDate, branchCompanyId);
      List<MonthCostOrMeteDTO> waterElectricityFeeDetails = this.getMonthDetails(yearDate, waterElectricityFeeMap);
      BigDecimal totalWaterElectricityFee = waterElectricityFeeDetails.stream().map(MonthCostOrMeteDTO::getCostOrMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      rowList.add(
         ProductionCostAnalysisDTOV2.builder()
            .className("水电费")
            .costInfoList(waterElectricityFeeDetails)
            .sumMete(totalWaterElectricityFee)
            .avgMete(
               totalWaterElectricityFee.compareTo(BigDecimal.ZERO) != 0 && totalProductionMete.compareTo(BigDecimal.ZERO) != 0
                  ? totalWaterElectricityFee.divide(totalProductionMete, 0, 4)
                  : BigDecimal.ZERO
            )
            .sort(90001)
            .build()
      );
      Map<String, BigDecimal> workshopDepreciationFeeMap = this.getWorkshopDepreciationFeeMap(yearDate, branchCompanyId);
      List<MonthCostOrMeteDTO> workshopDepreciationFeeDetails = this.getMonthDetails(yearDate, workshopDepreciationFeeMap);
      BigDecimal totalWorkshopDepreciationFee = workshopDepreciationFeeDetails.stream()
         .map(MonthCostOrMeteDTO::getCostOrMete)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      rowList.add(
         ProductionCostAnalysisDTOV2.builder()
            .className("厂房折旧费")
            .costInfoList(workshopDepreciationFeeDetails)
            .sumMete(totalWorkshopDepreciationFee)
            .avgMete(
               totalWorkshopDepreciationFee.compareTo(BigDecimal.ZERO) != 0 && totalProductionMete.compareTo(BigDecimal.ZERO) != 0
                  ? totalWorkshopDepreciationFee.divide(totalProductionMete, 0, 4)
                  : BigDecimal.ZERO
            )
            .sort(90002)
            .build()
      );
      Map<String, BigDecimal> equipmentDepreciationMap = this.getEquipmentDepreciationMap(yearDate, branchCompanyId);
      List<MonthCostOrMeteDTO> equipmentDepreciationDetails = this.getMonthDetails(yearDate, equipmentDepreciationMap);
      BigDecimal totalEquipmentDepreciation = equipmentDepreciationDetails.stream()
         .map(MonthCostOrMeteDTO::getCostOrMete)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      rowList.add(
         ProductionCostAnalysisDTOV2.builder()
            .className("设备折旧")
            .costInfoList(equipmentDepreciationDetails)
            .sumMete(totalEquipmentDepreciation)
            .avgMete(
               totalEquipmentDepreciation.compareTo(BigDecimal.ZERO) != 0 && totalProductionMete.compareTo(BigDecimal.ZERO) != 0
                  ? totalEquipmentDepreciation.divide(totalProductionMete, 0, 4)
                  : BigDecimal.ZERO
            )
            .sort(90003)
            .build()
      );
      Map<String, BigDecimal> testingFeeMap = this.getTestingFeeMap(yearDate, branchCompanyId);
      List<MonthCostOrMeteDTO> testingFeeDetails = this.getMonthDetails(yearDate, testingFeeMap);
      BigDecimal totalTestingFee = testingFeeDetails.stream().map(MonthCostOrMeteDTO::getCostOrMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      rowList.add(
         ProductionCostAnalysisDTOV2.builder()
            .className("检测费")
            .costInfoList(testingFeeDetails)
            .sumMete(totalTestingFee)
            .avgMete(
               totalTestingFee.compareTo(BigDecimal.ZERO) != 0 && totalProductionMete.compareTo(BigDecimal.ZERO) != 0
                  ? totalTestingFee.divide(totalProductionMete, 0, 4)
                  : BigDecimal.ZERO
            )
            .sort(90004)
            .build()
      );
      Map<String, BigDecimal> wageMap = this.getWageMap(yearDate, branchCompanyId);
      List<MonthCostOrMeteDTO> wageDetails = this.getMonthDetails(yearDate, wageMap);
      BigDecimal totalWage = wageDetails.stream().map(MonthCostOrMeteDTO::getCostOrMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      rowList.add(
         ProductionCostAnalysisDTOV2.builder()
            .className("管理人员工资")
            .costInfoList(wageDetails)
            .sort(90005)
            .sumMete(totalWage)
            .avgMete(
               totalWage.compareTo(BigDecimal.ZERO) != 0 && totalProductionMete.compareTo(BigDecimal.ZERO) != 0
                  ? totalWage.divide(totalProductionMete, 0, 4)
                  : BigDecimal.ZERO
            )
            .build()
      );
      Map<String, BigDecimal> propertyFeeMap = this.getPropertyFeeMap(yearDate, branchCompanyId);
      List<MonthCostOrMeteDTO> propertyFeeDetails = this.getMonthDetails(yearDate, propertyFeeMap);
      BigDecimal totalPropertyFee = propertyFeeDetails.stream().map(MonthCostOrMeteDTO::getCostOrMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      rowList.add(
         ProductionCostAnalysisDTOV2.builder()
            .className("物业费")
            .costInfoList(propertyFeeDetails)
            .sumMete(totalPropertyFee)
            .avgMete(
               totalPropertyFee.compareTo(BigDecimal.ZERO) != 0 && totalProductionMete.compareTo(BigDecimal.ZERO) != 0
                  ? totalPropertyFee.divide(totalProductionMete, 0, 4)
                  : BigDecimal.ZERO
            )
            .sort(90006)
            .build()
      );
      Map<String, BigDecimal> expenseReimburseMap = this.getExpenseReimburseMap(yearDate, branchCompanyId);
      List<MonthCostOrMeteDTO> expenseReimburseDetails = this.getMonthDetails(yearDate, expenseReimburseMap);
      BigDecimal totalExpenseReimburse = expenseReimburseDetails.stream().map(MonthCostOrMeteDTO::getCostOrMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      rowList.add(
         ProductionCostAnalysisDTOV2.builder()
            .className("报销费用")
            .costInfoList(expenseReimburseDetails)
            .sumMete(totalExpenseReimburse)
            .avgMete(
               totalExpenseReimburse.compareTo(BigDecimal.ZERO) != 0 && totalProductionMete.compareTo(BigDecimal.ZERO) != 0
                  ? totalExpenseReimburse.divide(totalProductionMete, 0, 4)
                  : BigDecimal.ZERO
            )
            .sort(90007)
            .build()
      );
      return rowList;
   }

   @Override
   public void downloadProductionCostAnalysisV2(HttpServletResponse response, LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      List<ProductionCostAnalysisDTOV2> productionCostAnalysisV2 = this.getProductionCostAnalysisV2(yearDate, branchCompanyId, workshopId);
      AtomicInteger index = new AtomicInteger(0);
      productionCostAnalysisV2.forEach(ex -> ex.setIndex(index.incrementAndGet()));
      List<List<String>> headList = new ArrayList<>();
      ProductionCostAnalysisDTOV2 first = productionCostAnalysisV2.get(0);
      headList.add(Arrays.asList("序号"));
      headList.add(Arrays.asList("类别"));
      if (CollUtil.isNotEmpty(first.getCostInfoList())) {
         first.getCostInfoList().stream().map(MonthCostOrMeteDTO::getMonth).forEach(yearMonth -> headList.add(Arrays.asList(yearMonth)));
      }

      headList.add(Arrays.asList("合计(元)"));
      headList.add(Arrays.asList("平均(元/吨)"));
      List<List<Object>> dataList = new ArrayList<>();
      productionCostAnalysisV2.forEach(ex -> {
         List<Object> data = new ArrayList<>();
         data.add(ex.getIndex());
         data.add(ex.getClassName());
         data.addAll(ex.getCostInfoList().stream().map(MonthCostOrMeteDTO::getCostOrMete).collect(Collectors.toList()));
         data.add(ex.getSumMete());
         data.add(ex.getAvgMete());
         dataList.add(data);
      });

      try {
         response.reset();
         response.setContentType("application/vnd.ms-excel;charset=utf-8");
         String fileName = StrUtil.concat(true, "成本明细表.xlsx");
         response.setHeader("Access-Control-Allow-Origin", "*");
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setCharacterEncoding("UTF-8");
         response.setHeader("content-Type", "application/vnd.ms-excel");
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
         EasyExcel.write(response.getOutputStream())
            .head(headList)
            .registerWriteHandler(new SimpleColumnWidthStyleStrategy(15))
            .registerWriteHandler(new HorizontalCellStyleStrategy(new WriteCellStyle() {
               {
                  this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                  this.setVerticalAlignment(VerticalAlignment.CENTER);
               }
            }, new WriteCellStyle() {
               {
                  this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                  this.setVerticalAlignment(VerticalAlignment.CENTER);
                  this.setBorderBottom(BorderStyle.THIN);
                  this.setBorderLeft(BorderStyle.THIN);
                  this.setBorderRight(BorderStyle.THIN);
                  this.setBorderTop(BorderStyle.THIN);
               }
            }))
            .sheet("成本明细表")
            .doWrite(dataList);
      } catch (Exception e) {
         throw new RuntimeException(e.getMessage());
      }
   }

   private List<MonthCostOrMeteDTO> getMonthDetails(LocalDate yearDate, Map<String, BigDecimal> infoMap) {
      List<MonthCostOrMeteDTO> details = new ArrayList<>();

      for (int i = 1; i <= 12; i++) {
         String key = yearDate.getYear() + "-" + String.format("%02d", i);
         LocalDate now = LocalDate.now();
         if (now.getYear() <= yearDate.getYear()) {
            MonthCostOrMeteDTO costOrMeteDTO;
            if (now.getMonthValue() >= i) {
               costOrMeteDTO = MonthCostOrMeteDTO.builder()
                  .month(i + "月")
                  .costOrMete(infoMap.getOrDefault(key, BigDecimal.ZERO).setScale(0, RoundingMode.HALF_UP))
                  .build();
            } else {
               costOrMeteDTO = MonthCostOrMeteDTO.builder().month(i + "月").costOrMete(BigDecimal.ZERO).build();
            }

            details.add(costOrMeteDTO);
         } else {
            MonthCostOrMeteDTO costOrMeteDTO = MonthCostOrMeteDTO.builder()
               .month(i + "月")
               .costOrMete(infoMap.getOrDefault(key, BigDecimal.ZERO).setScale(0, RoundingMode.HALF_UP))
               .build();
            details.add(costOrMeteDTO);
         }
      }

      return details;
   }

   private List<MonthCostOrMeteDTO> getMonthSummaryDetails(List<ProductionCostAnalysisDTOV2> rowList) {
      rowList = rowList.stream()
         .filter(e -> !"产量合计".equals(e.getClassName()) && !"金额合计".equals(e.getClassName()) && !"平均单价".equals(e.getClassName()))
         .collect(Collectors.toList());
      List<MonthCostOrMeteDTO> details = new ArrayList<>();

      for (int i = 0; i < 12; i++) {
         int index = i;
         BigDecimal summaryCost = rowList.stream()
            .map(ProductionCostAnalysisDTOV2::getCostInfoList)
            .map(e -> e.get(index).getCostOrMete())
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         MonthCostOrMeteDTO costOrMeteDTO = MonthCostOrMeteDTO.builder().month(i + 1 + "月").costOrMete(summaryCost).build();
         details.add(costOrMeteDTO);
      }

      return details;
   }

   private List<MonthCostOrMeteDTO> getMonthAvgDetails(List<ProductionCostAnalysisDTOV2> rowList) {
      ProductionCostAnalysisDTOV2 costRow = rowList.stream().filter(dto -> "金额合计".equals(dto.getClassName())).findFirst().orElse(null);
      ProductionCostAnalysisDTOV2 productionRow = rowList.stream().filter(dto -> "产量合计".equals(dto.getClassName())).findFirst().orElse(null);
      Preconditions.checkArgument(costRow != null && productionRow != null, "操作失败,获取‘金额合计’或者‘产量合计’信息失败！");
      List<MonthCostOrMeteDTO> details = new ArrayList<>();

      for (int i = 0; i < 12; i++) {
         BigDecimal cost = costRow.getCostInfoList().get(i).getCostOrMete();
         BigDecimal mete = productionRow.getCostInfoList().get(i).getCostOrMete();
         MonthCostOrMeteDTO costOrMeteDTO = MonthCostOrMeteDTO.builder()
            .month(i + 1 + "月")
            .costOrMete(cost.compareTo(BigDecimal.ZERO) != 0 && mete.compareTo(BigDecimal.ZERO) != 0 ? cost.divide(mete, 0, 4) : BigDecimal.ZERO)
            .build();
         details.add(costOrMeteDTO);
      }

      return details;
   }

   private List<DateCostDTO> getMaterialCost(
      List<Classification> oneLevelList, List<Long> projectIds, LocalDate yearDate, Long branchCompanyId, Long workshopId
   ) {
      HashMap<Long, List<Long>> levelMap = this.getLevelMap(oneLevelList);
      List<Long> flatList = levelMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
      flatList.addAll(oneLevelList.stream().map(Classification::getId).collect(Collectors.toList()));
      Map<Long, String> classNameMap = oneLevelList.stream().collect(Collectors.toMap(Classification::getId, Classification::getName));
      List<DateCostDTO> materialCost = this.moveOutboundDetailService
         .getMaterialLossCost(BasicClassEnum.GENERAL_MATERIAL.getType(), projectIds, yearDate, branchCompanyId, workshopId);
      Map<String, DateCostDTO> resultMap = materialCost.stream()
         .filter(e -> flatList.contains(e.getClassifyId()))
         .collect(
            Collectors.toMap(
               e -> e.getDateTime() + "YBGL" + this.getOneLevel(levelMap, e.getClassifyId()), dto -> (DateCostDTO)dto, (existing, replacement) -> {
                  existing.setAmount(existing.getAmount().add(replacement.getAmount()));
                  existing.setAmountExcludingVAT(existing.getAmountExcludingVAT().add(replacement.getAmountExcludingVAT()));
                  return existing;
               }
            )
         );
      resultMap.forEach((oneLevel, mergedDTO) -> {
         Long oneId = Long.valueOf(oneLevel.split("YBGL")[1]);
         mergedDTO.setClassifyId(oneId);
         mergedDTO.setClassifyName(classNameMap.getOrDefault(oneId, ""));
      });
      return new ArrayList<>(resultMap.values());
   }

   private HashMap<Long, List<Long>> getLevelMap(List<Classification> oneLevelList) {
      HashMap<Long, List<Long>> oneLevelMap = new HashMap<>();
      oneLevelList.forEach(
         e -> {
            ArrayList<Long> childList = new ArrayList<>();
            List<Long> child2 = this.classificationService
               .list(Wrappers.lambdaQuery(Classification.class).eq(Classification::getParentId, e.getId()).eq(Classification::getLevel, 2))
               .stream()
               .map(Classification::getId)
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(child2)) {
               childList.addAll(child2);
               List<Long> child3 = this.classificationService
                  .list(Wrappers.lambdaQuery(Classification.class).in(Classification::getParentId, child2).eq(Classification::getLevel, 3))
                  .stream()
                  .map(Classification::getId)
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(child3)) {
                  childList.addAll(child3);
               }
            }

            if (CollectionUtils.isNotEmpty(childList)) {
               oneLevelMap.put(e.getId(), childList);
            }
         }
      );
      return oneLevelMap;
   }

   public Long getOneLevel(HashMap<Long, List<Long>> levelMap, Long id) {
      for (Entry<Long, List<Long>> entry : levelMap.entrySet()) {
         Long key = entry.getKey();
         List<Long> idList = entry.getValue();
         if (idList.contains(id)) {
            return key;
         }
      }

      return id;
   }

   private Map<Integer, BigDecimal> getTotalMonthMeteMap(Integer year, Long branchCompanyId, Long workshopId) {
      Map<Integer, BigDecimal> monthMeteMap = new HashMap<>(16);
      Map<String, BigDecimal> meteByYearMap = this.mesBuildingUtilsBiz.getMeteByYearV2(LocalDateTime.of(year, 1, 1, 1, 1), null, branchCompanyId, workshopId);
      meteByYearMap.forEach((month, mete) -> {
         String monthStr = StringUtils.split(month, "-")[1];
         monthMeteMap.put(Integer.parseInt(monthStr), mete);
      });
      return monthMeteMap;
   }

   private Map<String, BigDecimal> getWageMap(LocalDate yearDate, Long branchCompanyId) {
      Map<String, List<ContractWageFee>> collectMap = this.wageFeeService
         .list(
            Wrappers.lambdaQuery(ContractWageFee.class)
               .eq(ContractWageFee::getFillInYear, yearDate.getYear())
               .eq(branchCompanyId != null, ContractWageFee::getBranchCompanyId, branchCompanyId)
         )
         .stream()
         .collect(Collectors.groupingBy(e -> yearDate.getYear() + "-" + String.format("%02d", e.getFillInMonth())));
      Map<String, BigDecimal> monthWageMap = new HashMap<>(16);
      collectMap.forEach((integer, contractWageSummaries) -> {
         BigDecimal totalWage = contractWageSummaries.stream().map(ContractWageFee::getTotalWage).reduce(BigDecimal.ZERO, BigDecimal::add);
         monthWageMap.put(integer, totalWage);
      });
      return monthWageMap;
   }

   private Map<String, BigDecimal> getPropertyFeeMap(LocalDate yearDate, Long branchCompanyId) {
      return this.waterElectricityPropertyFeeService
         .list(
            Wrappers.lambdaQuery(ContractWaterElectricityPropertyFee.class)
               .eq(branchCompanyId != null, ContractWaterElectricityPropertyFee::getBranchCompanyId, branchCompanyId)
               .eq(ContractWaterElectricityPropertyFee::getYear, yearDate.getYear())
               .eq(ContractWaterElectricityPropertyFee::getType, WaterElectricityPropertyFeeTypeEnum.PROPERTY_FEE.getType())
         )
         .stream()
         .collect(
            Collectors.toMap(
               e -> yearDate.getYear() + "-" + String.format("%02d", e.getMonth()), ContractWaterElectricityPropertyFee::getTotalFee, BigDecimal::add
            )
         );
   }

   private Map<String, BigDecimal> getExpenseReimburseMap(LocalDate yearDate, Long branchCompanyId) {
      Map<String, BigDecimal> monthExpenseReimburseMap = new HashMap<>(16);
      Map<String, List<ContractReimbursementFee>> reimbursementFeeGroup = this.reimbursementFeeService
         .list(
            Wrappers.lambdaQuery(ContractReimbursementFee.class)
               .eq(branchCompanyId != null, ContractReimbursementFee::getBranchCompanyId, branchCompanyId)
               .apply("YEAR(reimbursement_date) = {0}", yearDate.getYear())
         )
         .stream()
         .collect(Collectors.groupingBy(rf -> yearDate.getYear() + "-" + String.format("%02d", rf.getReimbursementDate().getMonthValue())));
      reimbursementFeeGroup.forEach((month, list) -> {
         BigDecimal reduce = list.stream().map(ContractReimbursementFee::getReimbursementAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
         monthExpenseReimburseMap.put(month, reduce);
      });
      return monthExpenseReimburseMap;
   }

   private Map<String, BigDecimal> getWaterElectricityFeeMap(LocalDate yearDate, Long branchCompanyId) {
      Map<String, List<ContractWaterElectricityPropertyFee>> listMap = this.waterElectricityPropertyFeeService
         .list(
            Wrappers.lambdaQuery(ContractWaterElectricityPropertyFee.class)
               .eq(ContractWaterElectricityPropertyFee::getYear, yearDate.getYear())
               .eq(branchCompanyId != null, ContractWaterElectricityPropertyFee::getBranchCompanyId, branchCompanyId)
               .in(ContractWaterElectricityPropertyFee::getType, WaterElectricityPropertyFeeTypeEnum.getWaterElectricityType())
         )
         .stream()
         .collect(Collectors.groupingBy(e -> yearDate.getYear() + "-" + String.format("%02d", e.getMonth())));
      Map<String, BigDecimal> waterElectricityFeeMap = new HashMap<>(16);
      listMap.forEach((month, list) -> {
         BigDecimal totalFee = list.stream().map(ContractWaterElectricityPropertyFee::getTotalFee).reduce(BigDecimal.ZERO, BigDecimal::add);
         waterElectricityFeeMap.put(month, totalFee);
      });
      return waterElectricityFeeMap;
   }

   private Map<String, BigDecimal> getGasFeeMap(LocalDate yearDate) {
      Map<String, List<ContractGasSummary>> collectMap = this.gasSummaryService
         .list(Wrappers.lambdaQuery(ContractGasSummary.class).eq(ContractGasSummary::getYear, yearDate.getYear()))
         .stream()
         .collect(Collectors.groupingBy(e -> yearDate.getYear() + "-" + String.format("%02d", e.getMonth())));
      Map<String, BigDecimal> gasSummaryMap = new HashMap<>(16);
      collectMap.forEach((month, list) -> {
         BigDecimal monthFee = list.stream().map(ContractGasSummary::getTotalAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
         gasSummaryMap.put(month, monthFee);
      });
      return gasSummaryMap;
   }

   private Map<String, BigDecimal> getTestingFeeMap(LocalDate yearDate, Long branchCompanyId) {
      Map<String, List<ContractTestingFee>> collectMap = this.testingFeeService
         .list(
            Wrappers.lambdaQuery(ContractTestingFee.class)
               .eq(ContractTestingFee::getYear, yearDate.getYear())
               .eq(branchCompanyId != null, ContractTestingFee::getBranchCompanyId, branchCompanyId)
         )
         .stream()
         .collect(Collectors.groupingBy(e -> yearDate.getYear() + "-" + String.format("%02d", e.getMonth())));
      Map<String, BigDecimal> testingFeeMap = new HashMap<>(16);
      collectMap.forEach((month, list) -> {
         BigDecimal totalFee = list.stream().map(ContractTestingFee::getFeeAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
         testingFeeMap.put(month, totalFee);
      });
      return testingFeeMap;
   }

   private Map<String, BigDecimal> getWorkshopDepreciationFeeMap(LocalDate yearDate, Long branchCompanyId) {
      int year = yearDate.getYear();
      List<ContractFixedAssetsDepreciation> depreciationList = this.fixedAssetsDepreciationService
         .list(
            Wrappers.lambdaQuery(ContractFixedAssetsDepreciation.class)
               .eq(ContractFixedAssetsDepreciation::getType, 1)
               .eq(branchCompanyId != null, ContractFixedAssetsDepreciation::getBranchCompanyId, branchCompanyId)
               .apply("date_format(start_date, '%Y') <= {0}", year)
               .apply("end_year_month / 100 >= {0}", year)
         );
      Map<String, BigDecimal> monthDepreciationFeeMap = new HashMap<>(16);
      depreciationList.forEach(de -> {
         int startYear = de.getStartDate().getYear();
         int startMonth = de.getStartDate().getMonthValue();
         int endYear = de.getEndYearMonth() / 100;
         int endMonth = de.getEndYearMonth() % endYear;
         if (startYear < year && endYear > year) {
            for (int i = 1; i <= 12; i++) {
               String key = year + "-" + String.format("%02d", i);
               if (monthDepreciationFeeMap.containsKey(key)) {
                  monthDepreciationFeeMap.put(key, monthDepreciationFeeMap.get(key).add(de.getMonthDepreciationAmount()));
               } else {
                  monthDepreciationFeeMap.put(key, de.getMonthDepreciationAmount());
               }
            }
         } else if (startYear == year && endYear == year) {
            for (int i = startMonth; i <= endMonth; i++) {
               String key = year + "-" + String.format("%02d", i);
               if (monthDepreciationFeeMap.containsKey(key)) {
                  monthDepreciationFeeMap.put(key, monthDepreciationFeeMap.get(key).add(de.getMonthDepreciationAmount()));
               } else {
                  monthDepreciationFeeMap.put(key, de.getMonthDepreciationAmount());
               }
            }
         } else if (startYear < year && endYear == year) {
            for (int i = 1; i <= endMonth; i++) {
               String key = year + "-" + String.format("%02d", i);
               if (monthDepreciationFeeMap.containsKey(key)) {
                  monthDepreciationFeeMap.put(key, monthDepreciationFeeMap.get(key).add(de.getMonthDepreciationAmount()));
               } else {
                  monthDepreciationFeeMap.put(key, de.getMonthDepreciationAmount());
               }
            }
         } else {
            for (int i = startMonth; i <= 12; i++) {
               String key = year + "-" + String.format("%02d", i);
               if (monthDepreciationFeeMap.containsKey(key)) {
                  monthDepreciationFeeMap.put(key, monthDepreciationFeeMap.get(key).add(de.getMonthDepreciationAmount()));
               } else {
                  monthDepreciationFeeMap.put(key, de.getMonthDepreciationAmount());
               }
            }
         }
      });
      return monthDepreciationFeeMap;
   }

   private Map<String, BigDecimal> getLaborFeeMap(List<Long> projectIds, LocalDate yearDate, Long branchCompanyId, Long workshopId) {
      return this.produceTeamReportPriceService
         .selectByYearV2(projectIds, yearDate, branchCompanyId, workshopId)
         .stream()
         .collect(Collectors.toMap(e -> yearDate.getYear() + "-" + String.format("%02d", e.getMonth()), MonthAmountInfo::getAmount));
   }

   private Map<String, BigDecimal> getEquipmentDepreciationMap(LocalDate yearDate, Long branchCompanyId) {
      int year = yearDate.getYear();
      List<ContractEquipmentDepreciation> list = this.equipmentDepreciationService
         .list(
            Wrappers.lambdaQuery(ContractEquipmentDepreciation.class)
               .eq(branchCompanyId != null, ContractEquipmentDepreciation::getBranchCompanyId, branchCompanyId)
               .apply("YEAR(start_date) <= {0} AND year(end_date) >= {0}", year)
         );
      Map<String, BigDecimal> monthDepreciationFeeMap = new HashMap<>(16);

      for (int i = 1; i <= 12; i++) {
         BigDecimal currentFee = BigDecimal.ZERO;

         for (ContractEquipmentDepreciation item : list) {
            if (item.getStartDate().getYear() == year) {
               if (item.getStartDate().getMonthValue() > i) {
                  continue;
               }

               if (item.getStartDate().getMonthValue() == i) {
                  int daysInMonth = item.getStartDate().lengthOfMonth();
                  LocalDate lastDayOfMonth = item.getStartDate().withDayOfMonth(daysInMonth);
                  long days = ChronoUnit.DAYS.between(item.getStartDate(), lastDayOfMonth);
                  BigDecimal fee = item.getMonthDepreciationAmount().multiply(BigDecimal.valueOf(days * 1.0 / daysInMonth)).setScale(2, RoundingMode.HALF_UP);
                  currentFee = currentFee.add(fee);
                  continue;
               }
            }

            if (item.getEndDate().getYear() == year) {
               if (item.getEndDate().getMonthValue() < i) {
                  continue;
               }

               if (item.getEndDate().getMonthValue() == i) {
                  int daysInMonth = item.getEndDate().lengthOfMonth();
                  LocalDate firstDayOfMonth = item.getEndDate().withDayOfMonth(1);
                  long days = ChronoUnit.DAYS.between(firstDayOfMonth, item.getEndDate());
                  BigDecimal fee = item.getMonthDepreciationAmount().multiply(BigDecimal.valueOf(days * 1.0 / daysInMonth)).setScale(2, RoundingMode.HALF_UP);
                  currentFee = currentFee.add(fee);
                  continue;
               }
            }

            currentFee = currentFee.add(item.getMonthDepreciationAmount());
         }

         monthDepreciationFeeMap.put(year + "-" + String.format("%02d", i), currentFee);
      }

      return monthDepreciationFeeMap;
   }
}
