package com.hzchum.scim.contract.core.biz.impl.finance;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.contract.core.api.biz.finance.ContractOperationAnalysisBiz;
import com.hzchum.scim.contract.core.api.enums.finance.WaterElectricityPropertyFeeTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractEquipmentDepreciation;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractFixedAssetsDepreciation;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractGasSummary;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractReimbursementFee;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractTestingFee;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWageFee;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWaterElectricityPropertyFee;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProductionCostAnalysisDTO;
import com.hzchum.scim.contract.core.api.service.finance.ContractEquipmentDepreciationService;
import com.hzchum.scim.contract.core.api.service.finance.ContractExpenseReimburseService;
import com.hzchum.scim.contract.core.api.service.finance.ContractFixedAssetsDepreciationService;
import com.hzchum.scim.contract.core.api.service.finance.ContractGasSummaryService;
import com.hzchum.scim.contract.core.api.service.finance.ContractPropertyFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractReimbursementFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractTestingFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractWageFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractWageSummaryService;
import com.hzchum.scim.contract.core.api.service.finance.ContractWaterElectricityPropertyFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractWaterElectricityService;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.ProjectPainingPriceDTO;
import com.hzchum.scim.mes.building.core.api.service.wages.MesBuildingProduceTeamReportPriceService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractOperationAnalysisBizImpl implements ContractOperationAnalysisBiz {
   private static final Logger log = LoggerFactory.getLogger(ContractOperationAnalysisBizImpl.class);
   @Resource
   private ContractWageSummaryService wageSummaryService;
   @Resource
   private ContractPropertyFeeService propertyFeeService;
   @Resource
   private ContractExpenseReimburseService expenseReimburseService;
   @Resource
   private ContractWaterElectricityService waterElectricityService;
   @Resource
   private ContractGasSummaryService gasSummaryService;
   @Resource
   private ContractTestingFeeService testingFeeService;
   @Resource
   private ContractFixedAssetsDepreciationService fixedAssetsDepreciationService;
   @Resource
   private OutboundService outboundService;
   @Resource
   private MesBuildingUtilsBiz mesBuildingUtilsBiz;
   @Resource
   private MesBuildingProduceTeamReportPriceService produceTeamReportPriceService;
   @Autowired
   private ContractWaterElectricityPropertyFeeService waterElectricityPropertyFeeService;
   @Autowired
   private ContractEquipmentDepreciationService equipmentDepreciationService;
   @Autowired
   private ContractReimbursementFeeService reimbursementFeeService;
   @Autowired
   private ContractWageFeeService wageFeeService;

   @Override
   public List<ProductionCostAnalysisDTO> productionCostAnalysis(Integer year) {
      Map<Integer, BigDecimal> monthMeteMap = this.getTotalMonthMeteMap(year);
      List<ProductionCostAnalysisDTO> productionCostAnalysisDTOList = new ArrayList<>(16);

      for (int i = 1; i <= 12; i++) {
         ProductionCostAnalysisDTO costAnalysisDTO = ProductionCostAnalysisDTO.builder().year(year).month(i).productionMete(BigDecimal.ZERO).build();
         if (monthMeteMap.containsKey(i)) {
            costAnalysisDTO.setProductionMete(monthMeteMap.get(i));
         }

         productionCostAnalysisDTOList.add(costAnalysisDTO);
      }

      Map<Integer, BigDecimal> wageMap = this.getWageMap(year);
      Map<Integer, BigDecimal> propertyFeeMap = this.getPropertyFeeMap(year);
      Map<Integer, BigDecimal> expenseReimburseMap = this.getExpenseReimburseMap(year);
      Map<Integer, BigDecimal> waterElectricityFeeMap = this.getWaterElectricityFeeMap(year);
      Map<Integer, BigDecimal> gasFeeMap = this.getGasFeeMap(year);
      Map<Integer, BigDecimal> testingFeeMap = this.getTestingFeeMap(year);
      Map<Integer, BigDecimal> workshopDepreciationFeeMap = this.getWorkshopDepreciationFeeMap(year);
      Map<Integer, BigDecimal> auxiliaryFeeMap = this.outboundService.getUseAmountByYear(String.valueOf(year));
      Map<Integer, BigDecimal> laborFeeMap = this.getLaborFeeMap(year);
      Map<Integer, BigDecimal> equipmentDepreciationMap = this.getEquipmentDepreciationMap(year);
      productionCostAnalysisDTOList.forEach(
         dto -> {
            Integer month = dto.getMonth();
            dto.setDeviceDepreciationFee(equipmentDepreciationMap.getOrDefault(month, BigDecimal.ZERO));
            dto.setLaborFee(laborFeeMap.getOrDefault(month, BigDecimal.ZERO));
            dto.setAuxiliaryFee(auxiliaryFeeMap.getOrDefault(month, BigDecimal.ZERO));
            dto.setWaterElectricityFee(waterElectricityFeeMap.getOrDefault(month, BigDecimal.ZERO));
            dto.setGasFee(gasFeeMap.getOrDefault(month, BigDecimal.ZERO));
            dto.setPlantDepreciationFee(workshopDepreciationFeeMap.getOrDefault(month, BigDecimal.ZERO));
            dto.setTestingFee(testingFeeMap.getOrDefault(month, BigDecimal.ZERO));
            BigDecimal wage = wageMap.getOrDefault(month, BigDecimal.ZERO);
            BigDecimal expenseReimburseFee = expenseReimburseMap.getOrDefault(month, BigDecimal.ZERO);
            BigDecimal propertyFee = propertyFeeMap.getOrDefault(month, BigDecimal.ZERO);
            dto.setManagementFee(wage.add(expenseReimburseFee).add(propertyFee));
            BigDecimal totalFee = dto.getLaborFee()
               .add(dto.getAuxiliaryFee())
               .add(dto.getGasFee())
               .add(dto.getWaterElectricityFee())
               .add(dto.getPlantDepreciationFee())
               .add(dto.getDeviceDepreciationFee())
               .add(dto.getTestingFee())
               .add(dto.getManagementFee());
            dto.setTotalFee(totalFee);
            dto.setAvgProductionFee(
               dto.getProductionMete().compareTo(BigDecimal.ZERO) == 0
                  ? dto.getTotalFee()
                  : dto.getTotalFee().multiply(BigDecimal.valueOf(1000L)).divide(dto.getProductionMete(), 2, RoundingMode.HALF_UP)
            );
            dto.setAvgWorkerProductionMete(
               dto.getAttendanceQuantity() != null
                  ? dto.getProductionMete().divide(BigDecimal.valueOf(dto.getAttendanceQuantity().intValue()), 2, RoundingMode.HALF_UP)
                  : null
            );
         }
      );
      return productionCostAnalysisDTOList;
   }

   private Map<Integer, BigDecimal> getEquipmentDepreciationMap(Integer year) {
      List<ContractEquipmentDepreciation> list = this.equipmentDepreciationService
         .list(Wrappers.lambdaQuery(ContractEquipmentDepreciation.class).apply("YEAR(start_date) <= {0} AND year(end_date) >= {0}", year));
      Map<Integer, BigDecimal> monthDepreciationFeeMap = new HashMap<>(16);

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

         monthDepreciationFeeMap.put(i, currentFee);
      }

      return monthDepreciationFeeMap;
   }

   private Map<Integer, BigDecimal> getTotalMonthMeteMap(Integer year) {
      Map<Integer, BigDecimal> monthMeteMap = new HashMap<>(16);
      Map<String, BigDecimal> meteByYearMap = this.mesBuildingUtilsBiz.getMeteByYear(LocalDateTime.of(year, 1, 1, 1, 1), null);
      meteByYearMap.forEach((month, mete) -> {
         String monthStr = StringUtils.split(month, "-")[1];
         monthMeteMap.put(Integer.parseInt(monthStr), mete);
      });
      return monthMeteMap;
   }

   private Map<Integer, BigDecimal> getWageMap(Integer year) {
      Map<Integer, List<ContractWageFee>> collectMap = this.wageFeeService
         .list(Wrappers.lambdaQuery(ContractWageFee.class).eq(ContractWageFee::getFillInYear, year))
         .stream()
         .collect(Collectors.groupingBy(ContractWageFee::getFillInMonth));
      Map<Integer, BigDecimal> monthWageMap = new HashMap<>(16);
      collectMap.forEach((integer, contractWageSummaries) -> {
         BigDecimal totalWage = contractWageSummaries.stream().map(ContractWageFee::getTotalWage).reduce(BigDecimal.ZERO, BigDecimal::add);
         monthWageMap.put(integer, totalWage);
      });
      return monthWageMap;
   }

   private Map<Integer, BigDecimal> getPropertyFeeMap(Integer year) {
      return this.waterElectricityPropertyFeeService
         .list(
            Wrappers.lambdaQuery(ContractWaterElectricityPropertyFee.class)
               .eq(ContractWaterElectricityPropertyFee::getYear, year)
               .eq(ContractWaterElectricityPropertyFee::getType, WaterElectricityPropertyFeeTypeEnum.PROPERTY_FEE.getType())
         )
         .stream()
         .collect(Collectors.toMap(ContractWaterElectricityPropertyFee::getMonth, ContractWaterElectricityPropertyFee::getTotalFee, BigDecimal::add));
   }

   private Map<Integer, BigDecimal> getExpenseReimburseMap(Integer year) {
      Preconditions.checkArgument(year != null, "年份不能为空");
      Map<Integer, BigDecimal> monthExpenseReimburseMap = new HashMap<>(16);
      Map<Integer, List<ContractReimbursementFee>> reimbursementFeeGroup = this.reimbursementFeeService
         .list(Wrappers.lambdaQuery(ContractReimbursementFee.class).apply("YEAR(reimbursement_date) = {0}", year))
         .stream()
         .collect(Collectors.groupingBy(rf -> rf.getReimbursementDate().getMonthValue()));
      reimbursementFeeGroup.forEach((month, list) -> {
         BigDecimal reduce = list.stream().map(ContractReimbursementFee::getReimbursementAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
         monthExpenseReimburseMap.put(month, reduce);
      });
      return monthExpenseReimburseMap;
   }

   private Map<Integer, BigDecimal> getWaterElectricityFeeMap(Integer year) {
      Map<Integer, List<ContractWaterElectricityPropertyFee>> listMap = this.waterElectricityPropertyFeeService
         .list(
            Wrappers.lambdaQuery(ContractWaterElectricityPropertyFee.class)
               .eq(ContractWaterElectricityPropertyFee::getYear, year)
               .in(ContractWaterElectricityPropertyFee::getType, WaterElectricityPropertyFeeTypeEnum.getWaterElectricityType())
         )
         .stream()
         .collect(Collectors.groupingBy(ContractWaterElectricityPropertyFee::getMonth));
      Map<Integer, BigDecimal> waterElectricityFeeMap = new HashMap<>(16);
      listMap.forEach((month, list) -> {
         BigDecimal totalFee = list.stream().map(ContractWaterElectricityPropertyFee::getTotalFee).reduce(BigDecimal.ZERO, BigDecimal::add);
         waterElectricityFeeMap.put(month, totalFee);
      });
      return waterElectricityFeeMap;
   }

   private Map<Integer, BigDecimal> getGasFeeMap(Integer year) {
      Preconditions.checkArgument(year != null, "年份不能为空");
      Map<Integer, List<ContractGasSummary>> collectMap = this.gasSummaryService
         .list(Wrappers.lambdaQuery(ContractGasSummary.builder().year(year).build()))
         .stream()
         .collect(Collectors.groupingBy(ContractGasSummary::getMonth));
      Map<Integer, BigDecimal> gasSummaryMap = new HashMap<>(16);
      collectMap.forEach((month, list) -> {
         BigDecimal monthFee = list.stream().map(ContractGasSummary::getTotalAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
         gasSummaryMap.put(month, monthFee);
      });
      return gasSummaryMap;
   }

   private Map<Integer, BigDecimal> getTestingFeeMap(Integer year) {
      Map<Integer, List<ContractTestingFee>> collectMap = this.testingFeeService
         .list(Wrappers.lambdaQuery(ContractTestingFee.builder().year(year).build()))
         .stream()
         .collect(Collectors.groupingBy(ContractTestingFee::getMonth));
      Map<Integer, BigDecimal> testingFeeMap = new HashMap<>(16);
      collectMap.forEach((month, list) -> {
         BigDecimal totalFee = list.stream().map(ContractTestingFee::getFeeAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
         testingFeeMap.put(month, totalFee);
      });
      return testingFeeMap;
   }

   private Map<Integer, BigDecimal> getWorkshopDepreciationFeeMap(Integer year) {
      List<ContractFixedAssetsDepreciation> depreciationList = this.fixedAssetsDepreciationService.listByYear(year);
      Map<Integer, BigDecimal> monthDepreciationFeeMap = new HashMap<>(16);
      depreciationList.forEach(de -> {
         int startYear = de.getStartDate().getYear();
         int startMonth = de.getStartDate().getMonthValue();
         int endYear = de.getEndYearMonth() / 100;
         int endMonth = de.getEndYearMonth() % endYear;
         if (startYear < year && endYear > year) {
            for (int i = 1; i <= 12; i++) {
               if (monthDepreciationFeeMap.containsKey(i)) {
                  monthDepreciationFeeMap.put(i, monthDepreciationFeeMap.get(i).add(de.getMonthDepreciationAmount()));
               } else {
                  monthDepreciationFeeMap.put(i, de.getMonthDepreciationAmount());
               }
            }
         } else if (startYear == year && endYear == year) {
            for (int i = startMonth; i <= endMonth; i++) {
               if (monthDepreciationFeeMap.containsKey(i)) {
                  monthDepreciationFeeMap.put(i, monthDepreciationFeeMap.get(i).add(de.getMonthDepreciationAmount()));
               } else {
                  monthDepreciationFeeMap.put(i, de.getMonthDepreciationAmount());
               }
            }
         } else if (startYear < year && endYear == year) {
            for (int i = 1; i <= endMonth; i++) {
               if (monthDepreciationFeeMap.containsKey(i)) {
                  monthDepreciationFeeMap.put(i, monthDepreciationFeeMap.get(i).add(de.getMonthDepreciationAmount()));
               } else {
                  monthDepreciationFeeMap.put(i, de.getMonthDepreciationAmount());
               }
            }
         } else {
            for (int i = startMonth; i <= 12; i++) {
               if (monthDepreciationFeeMap.containsKey(i)) {
                  monthDepreciationFeeMap.put(i, monthDepreciationFeeMap.get(i).add(de.getMonthDepreciationAmount()));
               } else {
                  monthDepreciationFeeMap.put(i, de.getMonthDepreciationAmount());
               }
            }
         }
      });
      return monthDepreciationFeeMap;
   }

   private Map<Integer, BigDecimal> getLaborFeeMap(Integer year) {
      return this.produceTeamReportPriceService.listByYear(year).stream().collect(Collectors.toMap(MonthAmountInfo::getMonth, MonthAmountInfo::getAmount));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printProductionCostAnalysis(Integer year) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("year", year);
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.productionCostAnalysis(year).stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<ProjectPainingPriceDTO> listProjectPaintingPrice(Integer year) {
      return this.mesBuildingUtilsBiz.getProjectPaintingPrice(LocalDateTime.of(year, 1, 1, 1, 1, 1));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> listProjectPaintingPricePrint(Integer year) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("date", year);
      printVO.setHeader(header);
      printVO.setTable(this.listProjectPaintingPrice(year).stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }
}
