package com.hzchum.scim.contract.core.biz.impl.finance;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.common.core.api.pojo.common.MonthMeteInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectAmountInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.biz.finance.ContractProjectFinanceBiz;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.finance.WaterElectricityEnum;
import com.hzchum.scim.contract.core.api.enums.finance.WmsBasicClassEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseReimburse;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractFixedAssetsDepreciation;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractTestingFee;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractFinanceProcessPriceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectFinanceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProjectCompositeCostDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.finance.ContractExpenseReimburseService;
import com.hzchum.scim.contract.core.api.service.finance.ContractFixedAssetsDepreciationService;
import com.hzchum.scim.contract.core.api.service.finance.ContractGasSummaryService;
import com.hzchum.scim.contract.core.api.service.finance.ContractPropertyFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractTestingFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractWageSummaryService;
import com.hzchum.scim.contract.core.api.service.finance.ContractWaterElectricityService;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.CargoListStatusEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoList;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.FinanceProcessPriceDTO;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.wages.MesBuildingProduceTeamReportPriceService;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractClassConfig;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.service.SubcontractClassConfigService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailDTO;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContractProjectFinanceBizImpl implements ContractProjectFinanceBiz {
   private static final Logger log = LoggerFactory.getLogger(ContractProjectFinanceBizImpl.class);
   @Resource
   private ContractProjectService projectService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private MoveOutboundDetailService moveOutboundDetailService;
   @Resource
   private MesBuildingCompleteService completeService;
   @Resource
   private ContractWaterElectricityService waterElectricityService;
   @Resource
   private ContractGasSummaryService gasSummaryService;
   @Resource
   private ContractFixedAssetsDepreciationService fixedAssetsDepreciationService;
   @Resource
   private ContractExpenseReimburseService expenseReimburseService;
   @Resource
   private ContractWageSummaryService wageSummaryService;
   @Resource
   private ContractPropertyFeeService propertyFeeService;
   @Resource
   private ContractTestingFeeService testingFeeService;
   @Resource
   private MesBuildingUtilsBiz mesBuildingUtilsBiz;
   @Resource
   private MesBuildingCargoListService buildingCargoListService;
   @Resource
   private MesBuildingProduceTeamReportPriceService buildingProduceTeamReportPriceService;
   @Resource
   private OutboundService outboundService;
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private SubcontractOrderService subcontractOrderService;
   @Resource
   private SubcontractClassConfigService subcontractClassConfigService;
   @Resource
   private SupplierPaymentService supplierPaymentService;

   @Override
   public PageVO<ContractProjectFinanceDTO> listProjectFinance(
      Integer year,
      Long projectId,
      Integer businessType,
      Integer projectType,
      Integer orderSourceType,
      Integer status,
      Integer settlementStatus,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      Integer settlementEnum = null;
      Integer projectStatusEnum = null;
      if (ProjectStatusEnum.SETTLED.getType().equals(settlementStatus)) {
         settlementEnum = SettlementStatusEnum.SETTLED.getType();
      } else if (settlementStatus != null) {
         projectStatusEnum = settlementStatus;
         settlementEnum = SettlementStatusEnum.UN_SETTLED.getType();
      }

      return new PageVO<>(this.listFinance(year, projectId, businessType, projectType, orderSourceType, projectStatusEnum, settlementEnum));
   }

   private List<ContractProjectFinanceDTO> listFinance(
      Integer year, Long projectId, Integer businessType, Integer projectType, Integer orderSourceType, Integer status, Integer settlementStatus
   ) {
      List<ContractProjectFinanceDTO> financeDTOList = this.projectService
         .listProjectFinancialStatement(year, projectId, businessType, projectType, orderSourceType, status, settlementStatus);
      if (CollectionUtils.isNotEmpty(financeDTOList)) {
         List<Long> projectIdList = financeDTOList.stream().map(ContractProjectFinanceDTO::getId).collect(Collectors.toList());
         Map<Long, BigDecimal> mainOutboundAmountMap = this.moveOutboundDetailService
            .listProjectOutboundAmount(projectIdList, WmsBasicClassEnum.MAIN_MATERIAL.getType())
            .stream()
            .collect(Collectors.toMap(ProjectAmountInfo::getProjectId, ProjectAmountInfo::getAmount));
         Map<Long, BigDecimal> auxiliaryOutboundAmountMap = this.moveOutboundDetailService
            .listProjectOutboundAmount(projectIdList, WmsBasicClassEnum.GENERAL_MATERIAL.getType())
            .stream()
            .collect(Collectors.toMap(ProjectAmountInfo::getProjectId, ProjectAmountInfo::getAmount));
         Map<Long, List<ContractExpenseReimburse>> listMap = this.expenseReimburseService
            .list(Wrappers.lambdaQuery(ContractExpenseReimburse.class).in(ContractExpenseReimburse::getProjectId, projectIdList))
            .stream()
            .collect(Collectors.groupingBy(ContractExpenseReimburse::getProjectId));
         Map<Long, BigDecimal> projectExpenseReimburseMap = new HashMap<>(32);
         listMap.forEach((pId, list) -> {
            BigDecimal reduce = list.stream().map(ContractExpenseReimburse::getReimburseAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            projectExpenseReimburseMap.put(pId, reduce);
         });
         Map<Long, List<ContractTestingFee>> testingFeelListMap = this.testingFeeService
            .list(Wrappers.lambdaQuery(ContractTestingFee.class).in(ContractTestingFee::getProjectId, projectIdList))
            .stream()
            .collect(Collectors.groupingBy(ContractTestingFee::getProjectId));
         Map<Long, BigDecimal> projectTestingFeeMap = new HashMap<>(32);
         testingFeelListMap.forEach((pid, list) -> {
            BigDecimal reduce = list.stream().map(ContractTestingFee::getFeeAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            projectTestingFeeMap.put(pid, reduce);
         });
         Map<Long, BigDecimal> projectCargoFeeMap = this.getCargoFeeMap(financeDTOList);
         Map<Long, List<SubcontractOrder>> subListMap = this.subcontractOrderService
            .list(Wrappers.lambdaQuery(SubcontractOrder.class).in(SubcontractOrder::getProjectId, projectIdList))
            .stream()
            .collect(Collectors.groupingBy(SubcontractOrder::getProjectId));
         Map<Long, BigDecimal> projectSubFeeMap = new HashMap<>(32);
         subListMap.forEach(
            (pid, list) -> {
               List<Long> orderIds = list.stream().map(SubcontractOrder::getId).collect(Collectors.toList());
               BigDecimal totalPayAmount = this.supplierPaymentService
                  .list(
                     Wrappers.lambdaQuery(SupplierPayment.class)
                        .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                        .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
                        .in(SupplierPayment::getOrderId, orderIds)
                  )
                  .stream()
                  .map(SupplierPayment::getActuallyPaymentAmount)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               projectSubFeeMap.put(pid, totalPayAmount);
            }
         );
         Map<Long, BigDecimal> projectPriceSumMap = this.buildingProduceTeamReportPriceService
            .listProcessWageByProjectId(projectIdList)
            .stream()
            .collect(
               Collectors.groupingBy(
                  FinanceProcessPriceDTO::getProjectId,
                  Collectors.mapping(FinanceProcessPriceDTO::getPrice, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
               )
            );
         financeDTOList.forEach(
            dto -> {
               BigDecimal totalCost = mainOutboundAmountMap.getOrDefault(dto.getId(), BigDecimal.ZERO)
                  .add(auxiliaryOutboundAmountMap.getOrDefault(dto.getId(), BigDecimal.ZERO))
                  .add(projectExpenseReimburseMap.getOrDefault(dto.getId(), BigDecimal.ZERO))
                  .add(projectTestingFeeMap.getOrDefault(dto.getId(), BigDecimal.ZERO))
                  .add(projectCargoFeeMap.getOrDefault(dto.getId(), BigDecimal.ZERO))
                  .add(projectSubFeeMap.getOrDefault(dto.getId(), BigDecimal.ZERO))
                  .add(projectPriceSumMap.getOrDefault(dto.getId(), BigDecimal.ZERO));
               ProjectCompositeCostDTO compositeCostDTO = ProjectCompositeCostDTO.builder()
                  .projectId(dto.getId())
                  .mainMaterialFee(mainOutboundAmountMap.getOrDefault(dto.getId(), BigDecimal.ZERO))
                  .auxiliaryMaterialFee(auxiliaryOutboundAmountMap.getOrDefault(dto.getId(), BigDecimal.ZERO))
                  .managementFee(projectExpenseReimburseMap.getOrDefault(dto.getId(), BigDecimal.ZERO))
                  .testingFee(projectTestingFeeMap.getOrDefault(dto.getId(), BigDecimal.ZERO))
                  .transportationFee(projectCargoFeeMap.getOrDefault(dto.getId(), BigDecimal.ZERO))
                  .subFee(projectSubFeeMap.getOrDefault(dto.getId(), BigDecimal.ZERO))
                  .laborFee(projectPriceSumMap.getOrDefault(dto.getId(), BigDecimal.ZERO))
                  .build();
               List<MonthMeteInfo> monthMeteList = this.getProjectMonthMeteList(dto.getId(), dto.getProjectType());
               if (CollectionUtils.isNotEmpty(monthMeteList)) {
                  List<Integer> monthList = monthMeteList.stream().map(MonthMeteInfo::getMonth).sorted().collect(Collectors.toList());
                  Integer startMonth = Collections.min(monthList);
                  Integer endMonth = Collections.max(monthList);
                  Integer lastProductionMonth = this.completeService.getLastProductionMonth(startMonth);
                  Map<Integer, BigDecimal> monthTotalMeteMap = this.getMonthTotalMeteMap(startMonth, endMonth);
                  List<MonthAmountInfo> monthAmountList = this.moveOutboundDetailService
                     .listMonthOutboundAmount(lastProductionMonth, endMonth, BasicClassEnum.GENERAL_MATERIAL.getType());
                  BigDecimal amortizationAuxiliaryAmount = this.getTotalAmortizationFee(monthMeteList, monthTotalMeteMap, monthAmountList);
                  totalCost = totalCost.add(amortizationAuxiliaryAmount);
                  compositeCostDTO.setAuxiliaryMaterialFee(compositeCostDTO.getAuxiliaryMaterialFee().add(amortizationAuxiliaryAmount));
                  List<MonthAmountInfo> waterEleMonthAmountList = this.waterElectricityService.listWaterEleMonthAmount(lastProductionMonth, endMonth, null);
                  BigDecimal waterEleAmortizationFee = this.getTotalAmortizationFee(monthMeteList, monthTotalMeteMap, waterEleMonthAmountList);
                  totalCost = totalCost.add(waterEleAmortizationFee);
                  List<MonthAmountInfo> gasMonthAmountList = this.gasSummaryService.listGasMonthAmount(lastProductionMonth, endMonth);
                  BigDecimal gasAmortizationFee = this.getTotalAmortizationFee(monthMeteList, monthTotalMeteMap, gasMonthAmountList);
                  totalCost = totalCost.add(gasAmortizationFee);
                  compositeCostDTO.setWaterElectricityGasFee(waterEleAmortizationFee.add(gasAmortizationFee));
                  List<MonthAmountInfo> depreciationFeeList = this.getDepreciationFeeList(lastProductionMonth, endMonth, null);
                  BigDecimal depreciationAmortizationFee = this.getTotalAmortizationFee(monthMeteList, monthTotalMeteMap, depreciationFeeList);
                  totalCost = totalCost.add(depreciationAmortizationFee);
                  compositeCostDTO.setDepreciationFee(depreciationAmortizationFee);
                  List<MonthAmountInfo> expenseReimburseMonthAmountList = this.expenseReimburseService.listByMonth(lastProductionMonth, endMonth);
                  BigDecimal expenseAmortizationAmount = this.getTotalAmortizationFee(monthMeteList, monthTotalMeteMap, expenseReimburseMonthAmountList);
                  totalCost = totalCost.add(expenseAmortizationAmount);
                  List<MonthAmountInfo> monthTotalWageList = this.wageSummaryService.listMonthTotalWage(lastProductionMonth, endMonth);
                  BigDecimal wageAmortizationAmount = this.getTotalAmortizationFee(monthMeteList, monthTotalMeteMap, monthTotalWageList);
                  totalCost = totalCost.add(wageAmortizationAmount);
                  List<MonthAmountInfo> propertyFeeMonthAmountList = this.propertyFeeService.listMonthFee(lastProductionMonth, endMonth);
                  BigDecimal propertyFeeAmortizationAmount = this.getTotalAmortizationFee(monthMeteList, monthTotalMeteMap, propertyFeeMonthAmountList);
                  totalCost = totalCost.add(propertyFeeAmortizationAmount);
                  compositeCostDTO.setManagementFee(
                     projectExpenseReimburseMap.getOrDefault(dto.getId(), BigDecimal.ZERO)
                        .add(expenseAmortizationAmount)
                        .add(wageAmortizationAmount)
                        .add(propertyFeeAmortizationAmount)
                  );
                  List<MonthAmountInfo> testingFellMonthAmountList = this.testingFeeService.listMonthFee(lastProductionMonth, endMonth);
                  BigDecimal amortizationTestingAmount = this.getTotalAmortizationFee(monthMeteList, monthTotalMeteMap, testingFellMonthAmountList);
                  totalCost = totalCost.add(amortizationTestingAmount);
                  compositeCostDTO.setTestingFee(compositeCostDTO.getTestingFee().add(amortizationTestingAmount));
               }

               dto.setCostAmount(totalCost);
               dto.setGrossProfit(
                  dto.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())
                     ? dto.getContractAmount().subtract(totalCost)
                     : dto.getSettlementAmount().subtract(totalCost)
               );
               dto.setGrossProfitRate(
                  dto.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())
                     ? dto.getGrossProfit().divide(dto.getContractAmount(), 4, RoundingMode.HALF_UP)
                     : dto.getGrossProfit().divide(dto.getSettlementAmount(), 4, RoundingMode.HALF_UP)
               );
               dto.setSettlementAttachments(this.attachmentService.listByIds(dto.getSettlementAttachmentIds()));
               dto.setCompositeCostDTO(compositeCostDTO);
            }
         );
      }

      return financeDTOList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListProjectFinance(
      Integer year, Long projectId, Integer businessType, Integer projectType, Integer orderSourceType, Integer status, Integer settlementStatus
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (year != null) {
         header.put("year", year);
      }

      printVO.setHeader(header);
      Integer settlementEnum = null;
      Integer projectStatusEnum = null;
      if (ProjectStatusEnum.SETTLED.getType().equals(settlementStatus)) {
         settlementEnum = SettlementStatusEnum.SETTLED.getType();
      } else if (settlementStatus != null) {
         projectStatusEnum = settlementStatus;
         settlementEnum = SettlementStatusEnum.UN_SETTLED.getType();
      }

      List<Map<String, Object>> mapList = this.listFinance(year, projectId, businessType, projectType, orderSourceType, projectStatusEnum, settlementEnum)
         .stream()
         .map(s -> {
            s.setGrossProfitRate(s.getGrossProfitRate().multiply(BigDecimal.valueOf(100L)));
            return BeanUtil.beanToMap(s);
         })
         .collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   private List<MonthMeteInfo> getProjectMonthMeteList(Long projectId, Integer projectType) {
      List<MonthMeteInfo> monthMeteList = new ArrayList<>(16);
      if (projectType.equals(ProjectTypeEnum.MES.getType()) || projectType.equals(ProjectTypeEnum.BRIDGE.getType())) {
         monthMeteList = this.completeService.listProjectMonthMete(projectId, ProductTypeEnum.ARTIFACT.getType());
      }

      return monthMeteList;
   }

   private Map<Integer, BigDecimal> getMonthTotalMeteMap(Integer startMonth, Integer endMonth) {
      return this.completeService.listMonthTotalMete(startMonth, endMonth).stream().collect(Collectors.toMap(MonthMeteInfo::getMonth, MonthMeteInfo::getMete));
   }

   private BigDecimal getTotalAmortizationFee(
      List<MonthMeteInfo> monthMeteList, Map<Integer, BigDecimal> monthTotalMeteMap, List<MonthAmountInfo> monthAmountList
   ) {
      List<Integer> amountMonthList = monthAmountList.stream().map(MonthAmountInfo::getMonth).collect(Collectors.toList());
      Map<Integer, BigDecimal> amountInfoMap = monthAmountList.stream().collect(Collectors.toMap(MonthAmountInfo::getMonth, MonthAmountInfo::getAmount));
      amountMonthList.addAll(monthTotalMeteMap.keySet());
      List<Integer> monthList = amountMonthList.stream().distinct().sorted().collect(Collectors.toList());
      List<MonthAmountInfo> monthAmountInfoList = monthList.stream().map(monthx -> {
         MonthAmountInfo monthAmountInfo = new MonthAmountInfo();
         monthAmountInfo.setMonth(monthx);
         monthAmountInfo.setAmount(amountInfoMap.getOrDefault(monthx, BigDecimal.ZERO));
         return monthAmountInfo;
      }).collect(Collectors.toList());
      Map<Integer, BigDecimal> monthMeteMap = monthMeteList.stream().collect(Collectors.toMap(MonthMeteInfo::getMonth, MonthMeteInfo::getMete));
      BigDecimal totalAmortizationAmount = BigDecimal.ZERO;
      BigDecimal unMatch = BigDecimal.ZERO;

      for (MonthAmountInfo monthAmount : monthAmountInfoList) {
         Integer month = monthAmount.getMonth();
         if (monthMeteMap.containsKey(month)) {
            BigDecimal amortizationAmount = monthAmount.getAmount()
               .add(unMatch)
               .multiply(monthMeteMap.get(month))
               .divide(monthTotalMeteMap.get(month), 4, RoundingMode.HALF_UP);
            totalAmortizationAmount = totalAmortizationAmount.add(amortizationAmount);
            unMatch = BigDecimal.ZERO;
         } else if (monthTotalMeteMap.containsKey(month)) {
            unMatch = BigDecimal.ZERO;
         } else {
            unMatch = unMatch.add(monthAmount.getAmount());
         }
      }

      return totalAmortizationAmount;
   }

   private List<MonthAmountInfo> getDepreciationFeeList(Integer lastMonth, Integer endMonth, Integer type) {
      int startMonth = 0;
      if (lastMonth > 0) {
         int year = lastMonth / 100;
         int month = lastMonth % year;
         if (month == 12) {
            startMonth = (year + 1) * 100 + 1;
         } else {
            startMonth = year * 100 + month + 1;
         }
      }

      int finalStartMonth = startMonth;
      List<ContractFixedAssetsDepreciation> depreciationList = this.fixedAssetsDepreciationService
         .list(
            Wrappers.lambdaQuery(ContractFixedAssetsDepreciation.class)
               .eq(type != null, ContractFixedAssetsDepreciation::getType, type)
               .or(
                  w -> {
                     LambdaQueryWrapper var10000 = w.le(finalStartMonth > 0, ContractFixedAssetsDepreciation::getYearMonthValue, finalStartMonth)
                        .le(finalStartMonth == 0, ContractFixedAssetsDepreciation::getYearMonthValue, endMonth)
                        .ge(ContractFixedAssetsDepreciation::getEndYearMonth, endMonth);
                  }
               )
               .or(
                  w -> {
                     LambdaQueryWrapper var10000 = w.gt(ContractFixedAssetsDepreciation::getEndYearMonth, lastMonth)
                        .le(ContractFixedAssetsDepreciation::getEndYearMonth, endMonth);
                  }
               )
               .or(
                  w -> {
                     LambdaQueryWrapper var10000 = w.gt(ContractFixedAssetsDepreciation::getYearMonthValue, lastMonth)
                        .le(ContractFixedAssetsDepreciation::getYearMonthValue, endMonth);
                  }
               )
         );
      Map<Integer, BigDecimal> monthDepreciationFeeMap = new HashMap<>(16);
      int endYear = endMonth / 100;
      int endMonthValue = endMonth % endYear;
      if (lastMonth == 0) {
         depreciationList.forEach(
            de -> {
               int startYearx = de.getYearMonthValue() / 100;
               int startMonthValuex = de.getYearMonthValue() % startYearx;
               if (startYearx == endYear) {
                  for (int ixx = startMonthValuex; ixx <= endMonthValue; ixx++) {
                     int yearMonthKey = startYearx * 100 + startMonthValuex;
                     monthDepreciationFeeMap.put(
                        yearMonthKey, monthDepreciationFeeMap.getOrDefault(yearMonthKey, BigDecimal.ZERO).add(de.getMonthDepreciationAmount())
                     );
                  }
               } else {
                  for (int ix = startYearx; ix <= endYear; ix++) {
                     if (ix == startYearx) {
                        for (int monthxxx = startMonthValuex; monthxxx <= 12; monthxxx++) {
                           int yearMonthKey = ix * 100 + monthxxx;
                           monthDepreciationFeeMap.put(
                              yearMonthKey, monthDepreciationFeeMap.getOrDefault(yearMonthKey, BigDecimal.ZERO).add(de.getMonthDepreciationAmount())
                           );
                        }
                     }

                     if (ix == endYear) {
                        for (int monthxx = 1; monthxx <= endMonthValue; monthxx++) {
                           int yearMonthKey = ix * 100 + monthxx;
                           monthDepreciationFeeMap.put(
                              yearMonthKey, monthDepreciationFeeMap.getOrDefault(yearMonthKey, BigDecimal.ZERO).add(de.getMonthDepreciationAmount())
                           );
                        }
                     }

                     if (ix > startYearx && ix < endYear) {
                        for (int monthx = 1; monthx <= 12; monthx++) {
                           int yearMonthKey = ix * 100 + monthx;
                           monthDepreciationFeeMap.put(
                              yearMonthKey, monthDepreciationFeeMap.getOrDefault(yearMonthKey, BigDecimal.ZERO).add(de.getMonthDepreciationAmount())
                           );
                        }
                     }
                  }
               }
            }
         );
      }

      if (lastMonth > 0) {
         List<Integer> monthList = new ArrayList<>(16);
         int startYear = startMonth / 100;
         int startMonthValue = startMonth % startYear;
         if (startYear == endYear) {
            for (int month = startMonthValue; month <= endMonthValue; month++) {
               monthList.add(startYear * 100 + month);
            }
         } else {
            for (int i = startYear; i <= endYear; i++) {
               if (i == startYear) {
                  for (int month = startMonthValue; month <= 12; month++) {
                     monthList.add(i * 100 + month);
                  }
               }

               if (i == endYear) {
                  for (int month = 1; month <= endMonthValue; month++) {
                     monthList.add(i * 100 + month);
                  }
               }

               if (i > startYear && i < endYear) {
                  for (int month = 1; month <= 12; month++) {
                     monthList.add(i * 100 + month);
                  }
               }
            }
         }

         depreciationList.forEach(de -> {
            for (Integer monthx : monthList) {
               if (monthx >= de.getYearMonthValue() && monthx <= de.getEndYearMonth()) {
                  monthDepreciationFeeMap.put(monthx, monthDepreciationFeeMap.getOrDefault(monthx, BigDecimal.ZERO).add(de.getMonthDepreciationAmount()));
               }
            }
         });
      }

      List<MonthAmountInfo> monthAmountList = new ArrayList<>(16);
      monthDepreciationFeeMap.forEach((monthx, amount) -> {
         MonthAmountInfo monthAmountInfo = new MonthAmountInfo();
         monthAmountInfo.setMonth(monthx);
         monthAmountInfo.setAmount(amount);
         monthAmountList.add(monthAmountInfo);
      });
      return monthAmountList;
   }

   private Map<Long, BigDecimal> getCargoFeeMap(List<ContractProjectFinanceDTO> financeDTOList) {
      List<Long> buildingProjectIds = financeDTOList.stream()
         .filter(f -> f.getProjectType().equals(ProjectTypeEnum.MES.getType()) || f.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()))
         .map(ContractProjectFinanceDTO::getId)
         .collect(Collectors.toList());
      Map<Long, BigDecimal> cargoListFeeMap = new HashMap<>(32);
      if (CollectionUtils.isNotEmpty(buildingProjectIds)) {
         Map<Long, List<MesBuildingCargoList>> buildingCargoListMap = this.buildingCargoListService
            .list(
               Wrappers.lambdaQuery(MesBuildingCargoList.class)
                  .in(MesBuildingCargoList::getProjectId, buildingProjectIds)
                  .in(MesBuildingCargoList::getStatus, CargoListStatusEnum.SHIPMENT.getType(), CargoListStatusEnum.RECEIPT.getType())
            )
            .stream()
            .collect(Collectors.groupingBy(MesBuildingCargoList::getProjectId));
         buildingCargoListMap.forEach((pid, list) -> {
            BigDecimal reduce = list.stream().map(MesBuildingCargoList::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
            cargoListFeeMap.put(pid, reduce);
         });
      }

      return cargoListFeeMap;
   }

   @Override
   public PageVO<OutboundDetailDTO> listProjectOutbound(Long projectId, Integer basicClassEnum, Integer pageNumber, Integer pageSize) {
      PageVO<OutboundDetailDTO> pageVO = this.outboundService.getUseDetail(projectId, basicClassEnum, null, null, null, true, pageNumber, pageSize);
      pageVO.getContent().forEach(s -> {
         if (BasicClassEnum.checkIsSteel(s.getBasicClass())) {
            s.setAccountingUnit("kg");
            s.setMete(s.getMete().divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP));
         }
      });
      return pageVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListProjectOutbound(Long projectId, Integer basicClassEnum) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo projectInfo = this.projectService.getSimpleById(projectId);
      header.put("project", projectInfo);
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.listProjectOutbound(projectId, basicClassEnum, null, null)
         .getContent()
         .stream()
         .map(BeanUtil::beanToMap)
         .collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<Map<String, Object>> listDepreciationFee(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      List<MonthMeteInfo> monthMeteList = this.getProjectMonthMeteList(projectId, project.getProjectType());
      List<Map<String, Object>> depreciationFeeList = new ArrayList<>(16);
      if (CollectionUtils.isNotEmpty(monthMeteList)) {
         Map<String, Object> map = new HashMap<>(16);
         BigDecimal totalMete = monthMeteList.stream()
            .map(MonthMeteInfo::getMete)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
         List<Integer> monthList = monthMeteList.stream().map(MonthMeteInfo::getMonth).collect(Collectors.toList());
         Integer startMonth = Collections.min(monthList);
         Integer endMonth = Collections.min(monthList);
         Integer lastProductionMonth = this.completeService.getLastProductionMonth(startMonth);
         Map<Integer, BigDecimal> monthTotalMeteMap = this.getMonthTotalMeteMap(startMonth, endMonth);
         List<MonthAmountInfo> monthAmountList = this.getDepreciationFeeList(lastProductionMonth, endMonth, 1);
         BigDecimal amortizationAmount = this.getTotalAmortizationFee(monthMeteList, monthTotalMeteMap, monthAmountList);
         map.put("type", "厂房折旧");
         map.put("mete", totalMete);
         map.put("amount", amortizationAmount);
         map.put("avgPrice", amortizationAmount.divide(totalMete, 2, RoundingMode.HALF_UP));
         depreciationFeeList.add(map);
      }

      return depreciationFeeList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListDepreciationFee(Long projectId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo projectInfo = this.projectService.getSimpleById(projectId);
      header.put("project", projectInfo);
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.listDepreciationFee(projectId);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<ContractFinanceProcessPriceDTO> listLaborFee(Long projectId) {
      List<FinanceProcessPriceDTO> financeProcessPriceDTOS = this.buildingProduceTeamReportPriceService
         .listProcessWageByProjectId(Collections.singletonList(projectId));
      return financeProcessPriceDTOS.stream().map(s -> {
         ContractFinanceProcessPriceDTO dto = BeanUtil.copy(s, ContractFinanceProcessPriceDTO.class);
         dto.setAvgPrice(s.getMete().compareTo(BigDecimal.ZERO) != 0 ? s.getPrice().divide(s.getMete(), 2, RoundingMode.HALF_UP) : s.getPrice());
         return dto;
      }).collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<ContractFinanceProcessPriceDTO>> printListLaborFee(Long projectId) {
      PrintVO<List<ContractFinanceProcessPriceDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo projectInfo = this.projectService.getSimpleById(projectId);
      header.put("project", projectInfo);
      printVO.setHeader(header);
      List<ContractFinanceProcessPriceDTO> contractFinanceProcessPriceDTOS = this.listLaborFee(projectId);
      printVO.setTable(contractFinanceProcessPriceDTOS);
      return printVO;
   }

   @Override
   public List<Map<String, Object>> listTestingFee(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      List<ContractTestingFee> projectTestingFeeList = this.testingFeeService
         .list(Wrappers.lambdaQuery(ContractTestingFee.builder().projectId(projectId).build()));
      Map<Long, BigDecimal> projectTypeAmountMap = projectTestingFeeList.stream()
         .collect(
            Collectors.groupingBy(
               ContractTestingFee::getTestingFeeTypeId,
               Collectors.mapping(ContractTestingFee::getFeeAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
            )
         );
      List<MonthMeteInfo> monthMeteList = this.getProjectMonthMeteList(projectId, project.getProjectType());
      if (CollectionUtils.isNotEmpty(monthMeteList)) {
         List<Integer> monthList = monthMeteList.stream().map(MonthMeteInfo::getMonth).sorted().collect(Collectors.toList());
         Integer startMonth = monthList.get(0);
         Integer endMonth = monthList.get(monthList.size() - 1);
         Integer lastProductionMonth = this.completeService.getLastProductionMonth(startMonth);
         List<ContractTestingFee> unProjectTestFeeList = this.testingFeeService
            .list(
               Wrappers.lambdaQuery(ContractTestingFee.class)
                  .isNull(ContractTestingFee::getProjectId)
                  .gt(ContractTestingFee::getYearMonthValue, lastProductionMonth)
                  .le(ContractTestingFee::getYearMonthValue, endMonth)
            );
         if (CollectionUtils.isNotEmpty(unProjectTestFeeList)) {
            Map<Integer, BigDecimal> monthTotalMeteMap = this.getMonthTotalMeteMap(startMonth, endMonth);
            Map<Long, List<ContractTestingFee>> typeMonthAmountListMap = unProjectTestFeeList.stream()
               .collect(Collectors.groupingBy(ContractTestingFee::getTestingFeeTypeId));
            typeMonthAmountListMap.forEach(
               (typeId, list) -> {
                  Map<Integer, BigDecimal> monthSumAmountMap = list.stream()
                     .collect(
                        Collectors.groupingBy(
                           ContractTestingFee::getYearMonthValue,
                           Collectors.mapping(ContractTestingFee::getFeeAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                        )
                     );
                  List<MonthAmountInfo> monthAmountInfoList = new ArrayList<>(16);
                  monthSumAmountMap.forEach((month, amount) -> {
                     MonthAmountInfo monthAmountInfo = new MonthAmountInfo();
                     monthAmountInfo.setMonth(month);
                     monthAmountInfo.setAmount(amount);
                     monthAmountInfoList.add(monthAmountInfo);
                  });
                  List<MonthAmountInfo> sortMonthAmountInfoList = monthAmountInfoList.stream()
                     .sorted(Comparator.comparing(MonthAmountInfo::getMonth))
                     .collect(Collectors.toList());
                  BigDecimal amortizationTestingAmount = this.getTotalAmortizationFee(monthMeteList, monthTotalMeteMap, sortMonthAmountInfoList);
                  projectTypeAmountMap.put(typeId, projectTypeAmountMap.getOrDefault(typeId, BigDecimal.ZERO).add(amortizationTestingAmount));
               }
            );
         }
      }

      BigDecimal totalMete = monthMeteList.stream().map(MonthMeteInfo::getMete).reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(1000L));
      List<Map<String, Object>> mapList = new ArrayList<>(16);
      projectTypeAmountMap.forEach((typeId, amount) -> {
         Map<String, Object> map = new HashMap<>(16);
         map.put("testingFeeTypeId", typeId);
         SysDictionary dictionary = this.dictionaryService.getById(typeId);
         map.put("testingFeeTypeName", dictionary != null ? dictionary.getLabel() : "其他");
         map.put("amount", amount);
         map.put("mete", totalMete);
         mapList.add(map);
      });
      return mapList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListTestingFee(Long projectId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      header.put("project", BeanUtil.copy(project, ProjectInfo.class));
      List<MonthMeteInfo> meteInfoList = this.getProjectMonthMeteList(projectId, project.getProjectType());
      BigDecimal totalMete = meteInfoList.stream().map(MonthMeteInfo::getMete).reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(1000L));
      header.put("mete", totalMete);
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.listTestingFee(projectId);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<Map<String, Object>> listSubFee(Long projectId) {
      Map<Long, List<SubcontractOrder>> listMap = this.subcontractOrderService
         .list(Wrappers.lambdaQuery(SubcontractOrder.builder().projectId(projectId).build()))
         .stream()
         .collect(Collectors.groupingBy(SubcontractOrder::getSubcontractClassId));
      List<Map<String, Object>> mapList = new ArrayList<>(16);
      listMap.forEach(
         (orderTypeId, list) -> {
            Map<String, Object> map = new HashMap<>(16);
            map.put("subcontractClassId", orderTypeId);
            SubcontractClassConfig subcontractClassConfig = this.subcontractClassConfigService.getById(orderTypeId);
            map.put("subcontractClassName", subcontractClassConfig != null ? subcontractClassConfig.getName() : "未知");
            List<Long> orderIds = list.stream().map(SubcontractOrder::getId).collect(Collectors.toList());
            BigDecimal payAmount = this.supplierPaymentService
               .list(
                  Wrappers.lambdaQuery(SupplierPayment.class)
                     .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                     .in(SupplierPayment::getOrderId, orderIds)
                     .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               )
               .stream()
               .map(SupplierPayment::getActuallyPaymentAmount)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            map.put("amount", payAmount);
            mapList.add(map);
         }
      );
      return mapList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListSubFee(Long projectId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo projectInfo = this.projectService.getSimpleById(projectId);
      header.put("project", projectInfo);
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.listSubFee(projectId);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<Map<String, Object>> listWaterEleFee(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      List<MonthMeteInfo> monthMeteList = this.getProjectMonthMeteList(projectId, project.getProjectType());
      BigDecimal totalMete = monthMeteList.stream()
         .map(MonthMeteInfo::getMete)
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
      List<Map<String, Object>> list = new ArrayList<>(16);
      if (CollectionUtils.isNotEmpty(monthMeteList)) {
         List<Integer> monthList = monthMeteList.stream().map(MonthMeteInfo::getMonth).collect(Collectors.toList());
         Integer startMonth = Collections.min(monthList);
         Integer endMonth = Collections.max(monthList);
         Map<Integer, BigDecimal> monthTotalMeteMap = this.getMonthTotalMeteMap(startMonth, endMonth);
         Integer lastProductionMonth = this.completeService.getLastProductionMonth(startMonth);
         int scale = 2;
         List<MonthAmountInfo> waterMonthAmountList = this.waterElectricityService
            .listWaterEleMonthAmount(lastProductionMonth, endMonth, WaterElectricityEnum.WATER.getType());
         BigDecimal waterAmortizationFee = this.getTotalAmortizationFee(monthMeteList, monthTotalMeteMap, waterMonthAmountList);
         Map<String, Object> waterFeeMap = new HashMap<>();
         waterFeeMap.put("type", "水费");
         waterFeeMap.put("amount", waterAmortizationFee);
         waterFeeMap.put("mete", totalMete);
         waterFeeMap.put("avgPrice", waterAmortizationFee.divide(totalMete, scale, RoundingMode.HALF_UP));
         list.add(waterFeeMap);
         List<MonthAmountInfo> electricityMonthAmountList = this.waterElectricityService
            .listWaterEleMonthAmount(lastProductionMonth, endMonth, WaterElectricityEnum.ELECTRICITY.getType());
         BigDecimal electricityAmortizationFee = this.getTotalAmortizationFee(monthMeteList, monthTotalMeteMap, electricityMonthAmountList);
         Map<String, Object> electricityFeeMap = new HashMap<>();
         electricityFeeMap.put("type", "电费");
         electricityFeeMap.put("amount", electricityAmortizationFee);
         electricityFeeMap.put("mete", totalMete);
         electricityFeeMap.put("avgPrice", electricityAmortizationFee.divide(totalMete, scale, RoundingMode.HALF_UP));
         list.add(electricityFeeMap);
         List<MonthAmountInfo> gasMonthAmountList = this.gasSummaryService.listGasMonthAmount(lastProductionMonth, endMonth);
         BigDecimal gasAmortizationFee = this.getTotalAmortizationFee(monthMeteList, monthTotalMeteMap, gasMonthAmountList);
         Map<String, Object> gasFeeMap = new HashMap<>();
         gasFeeMap.put("type", "气费");
         gasFeeMap.put("amount", gasAmortizationFee);
         gasFeeMap.put("mete", totalMete);
         gasFeeMap.put("avgPrice", gasAmortizationFee.divide(totalMete, scale, RoundingMode.HALF_UP));
         list.add(gasFeeMap);
      }

      return list;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListWaterEleFee(Long projectId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo projectInfo = this.projectService.getSimpleById(projectId);
      header.put("project", projectInfo);
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.listWaterEleFee(projectId);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<Map<String, Object>> listManagerFee(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      List<MonthMeteInfo> monthMeteList = this.getProjectMonthMeteList(projectId, project.getProjectType());
      List<Map<String, Object>> managerFeeList = new ArrayList<>(16);
      BigDecimal projectExpenseSum = this.expenseReimburseService
         .list(Wrappers.lambdaQuery(ContractExpenseReimburse.builder().projectId(projectId).build()))
         .stream()
         .map(ContractExpenseReimburse::getReimburseAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      if (CollectionUtils.isNotEmpty(monthMeteList)) {
         List<Integer> monthList = monthMeteList.stream().map(MonthMeteInfo::getMonth).collect(Collectors.toList());
         Integer startMonth = Collections.min(monthList);
         Integer endMonth = Collections.max(monthList);
         Map<Integer, BigDecimal> monthTotalMeteMap = this.getMonthTotalMeteMap(startMonth, endMonth);
         Integer lastProductionMonth = this.completeService.getLastProductionMonth(startMonth);
         List<MonthAmountInfo> monthAmountList = this.expenseReimburseService.listByMonth(lastProductionMonth, endMonth);
         BigDecimal amortizationFee = this.getTotalAmortizationFee(monthMeteList, monthTotalMeteMap, monthAmountList);
         Map<String, Object> expenseAmortizationMap = new HashMap<>();
         expenseAmortizationMap.put("subject", "报销费用");
         expenseAmortizationMap.put("amount", amortizationFee.add(projectExpenseSum));
         managerFeeList.add(expenseAmortizationMap);
         List<MonthAmountInfo> monthTotalWageList = this.wageSummaryService.listMonthTotalWage(lastProductionMonth, endMonth);
         BigDecimal wageAmortizationAmount = this.getTotalAmortizationFee(monthMeteList, monthTotalMeteMap, monthTotalWageList);
         Map<String, Object> wageAmortizationMap = new HashMap<>();
         wageAmortizationMap.put("subject", "管理人员工资");
         wageAmortizationMap.put("amount", wageAmortizationAmount);
         managerFeeList.add(wageAmortizationMap);
         List<MonthAmountInfo> monthPropertyFeeList = this.propertyFeeService.listMonthFee(lastProductionMonth, endMonth);
         BigDecimal propertyFeeAmortizationAmount = this.getTotalAmortizationFee(monthMeteList, monthTotalMeteMap, monthPropertyFeeList);
         Map<String, Object> propertyFeeMap = new HashMap<>();
         propertyFeeMap.put("subject", "物业费");
         propertyFeeMap.put("amount", propertyFeeAmortizationAmount);
         managerFeeList.add(propertyFeeMap);
      }

      return managerFeeList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListManagerFee(Long projectId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ProjectInfo projectInfo = this.projectService.getSimpleById(projectId);
      header.put("project", projectInfo);
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.listManagerFee(projectId);
      printVO.setTable(mapList);
      return printVO;
   }
}
