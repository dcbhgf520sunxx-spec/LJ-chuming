package com.hzchum.scim.operational.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.utils.DateTimeUtil;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.visa.VisaTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.ContractVisa;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPaymentDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectAbleCollectionDTO;
import com.hzchum.scim.contract.core.api.service.ContractCollectionService;
import com.hzchum.scim.contract.core.api.service.ContractInvoiceService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractVisaService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentDetailService;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.WarehouseBiz;
import com.hzchum.scim.mes.building.core.api.enums.QhseTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.InspectionAnalysisDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.complete.ProductionLoadDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.DeliverDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.operational.analysis.core.api.biz.OperationalAnalysisBiz;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.AuxiliaryMaterialsAnalysisDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.AverageDifferenceRatioDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.InspectionDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.InspectionDetailsDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.InventoryDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.InventoryStockDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.MonthSummaryDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.MonthSummaryRangeDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.OrderAnalysisDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.OrderDeliverDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.OrderDeliverDetailsDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ProductionAnalysisDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ProductionLoadDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ProductionLoadDetailsDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ProductionTypeAnalysisDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ProjectCostDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ProjectProductionDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.QhseDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.QhseDetailsDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.YearSummaryDTO;
import com.hzchum.scim.plan.core.api.biz.PlanSummaryBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanSummaryDetailDTO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthSummaryDO;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationalAnalysisBizImpl implements OperationalAnalysisBiz {
   @Autowired
   private ContractProjectService contractProjectService;
   @Autowired
   private MesBuildingCompleteService completeService;
   @Autowired
   private OutboundService outboundService;
   @Autowired
   private MesBuildingQhseService qhseService;
   @Autowired
   private InboundService inboundService;
   @Autowired
   private ReportService reportService;
   @Autowired
   private ContractCollectionService contractCollectionService;
   @Autowired
   private ContractInvoiceService contractInvoiceService;
   @Autowired
   private ContractVisaService contractVisaService;
   @Autowired
   private SupplierPaymentDetailService supplierPaymentDetailService;
   @Autowired
   private MesBuildingFactoryService factoryService;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Autowired
   private MesBuildingTaskBiz taskBiz;
   @Autowired
   private PlanSummaryBiz planSummaryBiz;
   @Autowired
   private WarehouseBiz warehouseBiz;
   @Autowired
   private MesBuildingProduceInspectionTeamReportService inspectionTeamReportService;

   @Override
   public OrderAnalysisDTO orderAnalysis(LocalDateTime dateTime) {
      return OrderAnalysisDTO.builder().orders(this.contractProjectService.listProjectOrderCount(dateTime)).build();
   }

   @Override
   public List<ProductionAnalysisDTO> productionAnalysis(LocalDateTime dateTime, Long factoryId, Integer yearSize, Integer productType) {
      List<ProductionAnalysisDTO> dtoList = new ArrayList<>();

      for (int i = yearSize - 1; i >= 0; i--) {
         dtoList.add(
            ProductionAnalysisDTO.builder()
               .year(String.valueOf(dateTime.plusYears(-i).getYear()))
               .productionDetailsList(this.completeService.getProductionByDateAndType(factoryId, dateTime.plusYears(-i), productType))
               .build()
         );
      }

      return dtoList;
   }

   @Override
   public List<ProjectProductionDTO> differenceAnalysis(LocalDateTime dateTime) {
      List<ProjectProductionDTO> dtoList = this.completeService
         .getProjectProductionByDate(dateTime)
         .stream()
         .map(e -> BeanUtil.copy(e, ProjectProductionDTO.class))
         .collect(Collectors.toList());
      Map<Long, BigDecimal> amountOfUsageMap = this.outboundService
         .getProjectUseSteel(dtoList.stream().map(e -> e.getProject().getId()).collect(Collectors.toList()));
      dtoList.forEach(e -> {
         e.setAmountOfUsage(amountOfUsageMap.get(e.getProject().getId()));
         if (e.getAmountOfUsage().compareTo(BigDecimal.ZERO) == 0) {
            e.setDifference(BigDecimal.ZERO);
            e.setDifferenceRatio(BigDecimal.ZERO);
         } else {
            e.setDifference(e.getAmountOfUsage().subtract(e.getProduction()).abs());
            e.setDifferenceRatio(e.getDifference().divide(e.getAmountOfUsage(), 5, 4).multiply(BigDecimal.valueOf(100L)));
         }
      });
      return dtoList;
   }

   @Override
   public List<AverageDifferenceRatioDTO> averageDifferenceRatioAnalysis(Integer range) {
      List<AverageDifferenceRatioDTO> dtoList = new ArrayList<>();

      for (int i = range - 1; i >= 0; i--) {
         List<ProjectProductionDTO> detailsList = this.differenceAnalysis(LocalDateTime.now().plusYears(-i));
         BigDecimal sumDifferenceRatio = detailsList.stream().map(ProjectProductionDTO::getDifferenceRatio).reduce(BigDecimal.ZERO, BigDecimal::add);
         dtoList.add(
            AverageDifferenceRatioDTO.builder()
               .year(String.valueOf(LocalDateTime.now().plusYears(-i).getYear()))
               .averageDifferenceRatio(
                  detailsList.size() == 0
                     ? BigDecimal.ZERO
                     : sumDifferenceRatio.divide(BigDecimal.valueOf(detailsList.size()), 5, 4).multiply(BigDecimal.valueOf(100L))
               )
               .build()
         );
      }

      return dtoList;
   }

   @Override
   public AuxiliaryMaterialsAnalysisDTO auxiliaryMaterialsAnalysis(LocalDateTime dateTime, Long factoryId) {
      return AuxiliaryMaterialsAnalysisDTO.builder()
         .productionAnalysisDetails(this.completeService.getProductionByDateAndType(factoryId, dateTime, ProductTypeEnum.ARTIFACT.getType()))
         .outboundAmounts(this.outboundService.getAuxiliaryMaterialAmount(dateTime))
         .build();
   }

   @Override
   public List<QhseDTO> qhseAnalysis(LocalDateTime dateTime) {
      List<QhseDTO> dtoList = new ArrayList<>();
      dtoList.add(
         QhseDTO.builder()
            .type(QhseTypeEnum.QUALITY.getType())
            .qhseDetailsList(
               this.qhseService
                  .qhseSummaryList(dateTime, QhseTypeEnum.QUALITY.getType() + QhseTypeEnum.SPECIAL_QUALITY.getType(), null)
                  .stream()
                  .map(e -> BeanUtil.copy(e, QhseDetailsDTO.class))
                  .collect(Collectors.toList())
            )
            .build()
      );
      dtoList.add(
         QhseDTO.builder()
            .type(QhseTypeEnum.SECURITY.getType())
            .qhseDetailsList(
               this.qhseService
                  .qhseSummaryList(dateTime, QhseTypeEnum.SECURITY.getType(), null)
                  .stream()
                  .map(e -> BeanUtil.copy(e, QhseDetailsDTO.class))
                  .collect(Collectors.toList())
            )
            .build()
      );
      dtoList.add(
         QhseDTO.builder()
            .type(QhseTypeEnum.ENVIRONMENT.getType())
            .qhseDetailsList(
               this.qhseService
                  .qhseSummaryList(dateTime, QhseTypeEnum.ENVIRONMENT.getType(), null)
                  .stream()
                  .map(e -> BeanUtil.copy(e, QhseDetailsDTO.class))
                  .collect(Collectors.toList())
            )
            .build()
      );
      return dtoList;
   }

   @Override
   public List<ProductionTypeAnalysisDTO> productionTypeAnalysis(LocalDateTime dateTime, Integer productType) {
      List<ProductionTypeAnalysisDTO> dtoList = this.completeService
         .productionTypeAnalysis(dateTime, productType)
         .stream()
         .map(e -> BeanUtil.copy(e, ProductionTypeAnalysisDTO.class))
         .collect(Collectors.toList());
      BigDecimal sumYield = dtoList.stream().map(ProductionTypeAnalysisDTO::getYield).reduce(BigDecimal.ZERO, BigDecimal::add);
      dtoList.forEach(e -> e.setRatio(e.getYield().divide(sumYield, 5, 4).multiply(BigDecimal.valueOf(100L))));
      return dtoList;
   }

   @Override
   public List<MonthSummaryRangeDTO> purchaseTrendAnalysis(
      LocalDateTime dateTime, Integer basicClass, Long classifyId, Integer thickness, Long specId, Long sectionSteelSpecId, Integer range
   ) {
      List<MonthSummaryRangeDTO> dtoList = new ArrayList<>();

      for (int i = 0; i < range; i++) {
         dtoList.add(
            MonthSummaryRangeDTO.builder()
               .year(String.valueOf(dateTime.plusYears(-i).getYear()))
               .summaryList(
                  this.inboundService
                     .getMonthSummary(dateTime.plusYears(-i), basicClass, classifyId, thickness, specId, sectionSteelSpecId)
                     .stream()
                     .map(e -> BeanUtil.copy(e, MonthSummaryDTO.class))
                     .collect(Collectors.toList())
               )
               .build()
         );
      }

      return dtoList;
   }

   @Override
   public List<YearSummaryDTO> purchaseRatioAnalysis(LocalDateTime dateTime, Integer basicClass) {
      List<YearSummaryDTO> dtoList = this.inboundService
         .getYearSummary(dateTime, basicClass)
         .stream()
         .map(e -> BeanUtil.copy(e, YearSummaryDTO.class))
         .collect(Collectors.toList());
      BigDecimal summaryMete = dtoList.stream().map(YearSummaryDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      dtoList.forEach(e -> e.setRatio(e.getMete().divide(summaryMete, 5, 4).multiply(BigDecimal.valueOf(100L))));
      return dtoList;
   }

   @Override
   public List<InventoryDTO> inventorySummaryAnalysis(LocalDateTime dateTime, Integer tax, Integer type) {
      List<InventoryDTO> dtoList = new ArrayList<>();
      Map<String, List<MonthSummaryDO>> amountMap = this.reportService.getTotalAmount(dateTime, tax);

      for (int i = 1; i < 13; i++) {
         BigDecimal intoAmount = BigDecimal.ZERO;
         BigDecimal outAmount = BigDecimal.ZERO;
         Integer finalI = i;
         if (type == null) {
            intoAmount = intoAmount.add(
               amountMap.get("钢材入库").stream().filter(e -> e.getDate().equals(finalI)).map(MonthSummaryDO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
            );
            intoAmount = intoAmount.add(
               amountMap.get("辅材入库").stream().filter(e -> e.getDate().equals(finalI)).map(MonthSummaryDO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
            );
            outAmount = outAmount.add(
               amountMap.get("钢材出库").stream().filter(e -> e.getDate().equals(finalI)).map(MonthSummaryDO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
            );
            outAmount = outAmount.add(
               amountMap.get("辅材出库").stream().filter(e -> e.getDate().equals(finalI)).map(MonthSummaryDO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
            );
         } else if (type == 1) {
            intoAmount = intoAmount.add(
               amountMap.get("钢材入库").stream().filter(e -> e.getDate().equals(finalI)).map(MonthSummaryDO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
            );
            outAmount = outAmount.add(
               amountMap.get("钢材出库").stream().filter(e -> e.getDate().equals(finalI)).map(MonthSummaryDO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
            );
         } else {
            intoAmount = intoAmount.add(
               amountMap.get("辅材入库").stream().filter(e -> e.getDate().equals(finalI)).map(MonthSummaryDO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
            );
            outAmount = outAmount.add(
               amountMap.get("辅材出库").stream().filter(e -> e.getDate().equals(finalI)).map(MonthSummaryDO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
            );
         }

         InventoryDTO dto = InventoryDTO.builder().intoAmount(intoAmount).outAmount(outAmount).month(i).build();
         dtoList.add(dto);
      }

      return dtoList;
   }

   @Override
   public List<InventoryDTO> incomeAnalysis(LocalDateTime dateTime, Long branchCompanyId) {
      return this.contractCollectionService
         .listIncomeExpense(dateTime.getYear(), branchCompanyId)
         .stream()
         .map(e -> InventoryDTO.builder().month(e.getMonth()).intoAmount(e.getCollectionAmount()).outAmount(e.getPaymentAmount()).build())
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<ProjectAbleCollectionDTO> collectionAnalysis(Integer type, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectAbleCollectionDTO> collectionDTOList = this.contractProjectService.listAbleCollection(type);
      collectionDTOList.forEach(
         c -> {
            if (type == 1) {
               ContractInvoice invoice = this.contractInvoiceService
                  .getOne(
                     Wrappers.lambdaQuery(ContractInvoice.class)
                        .eq(ContractInvoice::getProjectId, c.getId())
                        .orderByAsc(ContractInvoice::getInvoiceDate)
                        .last("limit 1")
                  );
               if (invoice != null) {
                  c.setAccountAge(DateTimeUtil.getBetweenDays(invoice.getInvoiceDate().toLocalDate(), LocalDate.now()));
               }
            }

            if (type == 2) {
               ContractVisa visa = this.contractVisaService
                  .getOne(
                     Wrappers.lambdaQuery(ContractVisa.class)
                        .eq(ContractVisa::getProjectId, c.getId())
                        .eq(ContractVisa::getType, VisaTypeEnum.SETTLEMENT.getType())
                        .eq(ContractVisa::getStatus, AuditStatusEnum.SUCCEED.getType())
                  );
               if (visa != null) {
                  c.setAccountAge(DateTimeUtil.getBetweenDays(visa.getSettlementDate(), LocalDate.now()));
               }
            }
         }
      );
      return new PageVO<>(collectionDTOList);
   }

   @Override
   public List<ProjectCostDTO> costAnalysis(Integer settlementStatus, Integer status) {
      List<ProjectCostDTO> dtoList = this.contractProjectService
         .costAnalysis(settlementStatus, status)
         .stream()
         .map(e -> BeanUtil.copy(e, ProjectCostDTO.class))
         .collect(Collectors.toList());
      dtoList.forEach(
         e -> {
            BigDecimal payAmount = BigDecimal.ZERO;
            payAmount.add(
               this.supplierPaymentDetailService
                  .list(
                     (Wrapper<SupplierPaymentDetail>)(Wrappers.<SupplierPaymentDetail>lambdaQuery().eq(SupplierPaymentDetail::getProjectId, e.getId()))
                        .eq(SupplierPaymentDetail::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
                  )
                  .stream()
                  .map(SupplierPaymentDetail::getActuallyPaymentAmount)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
            );
            e.setPayAmount(payAmount);
         }
      );
      return null;
   }

   @Override
   public List<InventoryStockDTO> inventoryStockAnalysis(LocalDateTime dateTime, Integer tax, Integer type) {
      List<InventoryStockDTO> dtoList = new ArrayList<>();
      Map<String, List<MonthSummaryDO>> amountMap = this.reportService.getStockAmount(dateTime, tax);

      for (int i = 1; i < 13; i++) {
         BigDecimal amount = BigDecimal.ZERO;
         int finalI = i;
         if (type == null) {
            amount = amount.add(
               amountMap.get("钢材").stream().filter(e -> e.getDate().equals(finalI)).map(MonthSummaryDO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
            );
            amount = amount.add(
               amountMap.get("辅材").stream().filter(e -> e.getDate().equals(finalI)).map(MonthSummaryDO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
            );
         } else if (type.equals(1)) {
            amount = amount.add(
               amountMap.get("钢材").stream().filter(e -> e.getDate().equals(finalI)).map(MonthSummaryDO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
            );
         } else {
            if (!type.equals(2)) {
               throw new IllegalArgumentException("类型不正确");
            }

            amount = amount.add(
               amountMap.get("辅材").stream().filter(e -> e.getDate().equals(finalI)).map(MonthSummaryDO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
            );
         }

         InventoryStockDTO dto = InventoryStockDTO.builder().amount(amount).month(i).build();
         dtoList.add(dto);
      }

      return dtoList;
   }

   @Override
   public List<InventoryStockDTO> inventoryStockSteelAnalysis(LocalDateTime dateTime, Integer tax) {
      List<InventoryStockDTO> dtoList = new ArrayList<>();
      Map<String, List<MonthSummaryDO>> amountMap = this.reportService.getStockAmount(dateTime, tax);

      for (int i = 1; i < 13; i++) {
         BigDecimal amount = BigDecimal.ZERO;
         BigDecimal weight = BigDecimal.ZERO;
         int finalI = i;
         amount = amount.add(
            amountMap.get("钢材").stream().filter(e -> e.getDate().equals(finalI)).map(MonthSummaryDO::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add)
         );
         weight = weight.add(
            amountMap.get("钢材").stream().filter(e -> e.getDate().equals(finalI)).map(MonthSummaryDO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add)
         );
         InventoryStockDTO dto = InventoryStockDTO.builder().amount(amount).weight(weight).month(i).build();
         dtoList.add(dto);
      }

      return dtoList;
   }

   @Override
   public ProductionLoadDTO loadAnalysis(LocalDateTime dateTime, Long factoryId) {
      List<MesBuildingProductionLine> productionLines = this.productionLineService
         .list(Wrappers.<MesBuildingProductionLine>lambdaQuery().eq(factoryId != null, MesBuildingProductionLine::getFactoryId, factoryId));
      BigDecimal targetSummary = productionLines.stream()
         .filter(e -> factoryId != null ? e.getFactoryId().equals(factoryId) : e.getTargetProduction() != null)
         .map(MesBuildingProductionLine::getTargetProduction)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      List<ProductionLoadDO> productionLoadDOS = this.taskBiz.productionLoad(dateTime, factoryId);
      Map<Integer, BigDecimal> completeMap = new HashMap<>();
      productionLoadDOS.forEach(e -> {
         BigDecimal var10000 = completeMap.put(e.getMonth(), e.getComplete());
      });
      Integer monthQuantity = 0;
      if (productionLoadDOS.size() != 0) {
         monthQuantity = productionLoadDOS.stream().max(Comparator.comparingInt(ProductionLoadDO::getMonth)).get().getMonth();
      }

      BigDecimal completeSummary = productionLoadDOS.stream().map(ProductionLoadDO::getComplete).reduce(BigDecimal.ZERO, BigDecimal::add);
      List<ProductionLoadDetailsDTO> detailsList = new ArrayList<>();

      for (int i = 1; i <= 12; i++) {
         if (i <= monthQuantity) {
            detailsList.add(
               ProductionLoadDetailsDTO.builder()
                  .month(i)
                  .complete(completeMap.get(i))
                  .target(targetSummary)
                  .lodaRatio(
                     completeMap.get(i) != null && targetSummary.compareTo(BigDecimal.ZERO) > 0
                        ? completeMap.get(i).divide(targetSummary, 5, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L))
                        : BigDecimal.ZERO
                  )
                  .build()
            );
         } else {
            detailsList.add(ProductionLoadDetailsDTO.builder().month(i).complete(BigDecimal.ZERO).target(BigDecimal.ZERO).lodaRatio(BigDecimal.ZERO).build());
         }
      }

      BigDecimal avgLoadRatio = detailsList.stream()
         .map(ProductionLoadDetailsDTO::getLodaRatio)
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .divide(BigDecimal.valueOf(detailsList.size()), 5, RoundingMode.HALF_UP);
      return ProductionLoadDTO.builder().targetSummary(targetSummary).completeSummary(completeSummary).details(detailsList).avgLoadRatio(avgLoadRatio).build();
   }

   @Override
   public OrderDeliverDTO deliverAnalysis(LocalDateTime dateTime) {
      List<PlanSummaryDTO> planSummaryList = this.planSummaryBiz.listMetByProduct(String.valueOf(dateTime.getYear()), 1).getContent();
      Map<Integer, BigDecimal> orderMap = new HashMap<>();
      planSummaryList.forEach(e -> e.getDetails().forEach(temp -> {
         if (temp.getMete() == null) {
            temp.setMete(BigDecimal.ZERO);
         } else {
            temp.setMete(temp.getMete().multiply(BigDecimal.valueOf(1000L)));
         }

         if (orderMap.get(temp.getMonth()) == null) {
            orderMap.put(temp.getMonth(), temp.getMete());
         } else {
            orderMap.replace(temp.getMonth(), orderMap.get(temp.getMonth()).add(temp.getMete()));
         }
      }));
      List<DeliverDTO> completeList = this.warehouseBiz.DeliverGroupByMonth(dateTime);
      Map<Integer, BigDecimal> completeMap = new HashMap<>();
      completeList.forEach(e -> {
         BigDecimal var10000 = completeMap.put(e.getMonth(), e.getComplete());
      });
      List<OrderDeliverDetailsDTO> detailsList = new ArrayList<>();

      for (int i = 1; i < 13; i++) {
         detailsList.add(
            OrderDeliverDetailsDTO.builder()
               .month(i)
               .order(orderMap.get(i) == null ? BigDecimal.ZERO : orderMap.get(i))
               .complete(completeMap.get(i) == null ? BigDecimal.ZERO : completeMap.get(i))
               .deliverRatio(BigDecimal.ZERO)
               .build()
         );
      }

      detailsList.forEach(e -> {
         if (e.getOrder().compareTo(BigDecimal.ZERO) > 0) {
            e.setDeliverRatio(e.getComplete().divide(e.getOrder(), 5, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L)));
         }
      });
      Integer monthQuantity = (int)detailsList.stream().filter(e -> e.getOrder().compareTo(BigDecimal.ZERO) > 0).count();
      BigDecimal avgDeliverRatio = BigDecimal.ZERO;
      if (monthQuantity != 0) {
         avgDeliverRatio = detailsList.stream()
            .map(OrderDeliverDetailsDTO::getDeliverRatio)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(BigDecimal.valueOf(monthQuantity.intValue()), 5, RoundingMode.HALF_UP);
      }

      return OrderDeliverDTO.builder()
         .orderSummary(
            planSummaryList.stream()
               .map(e -> e.getDetails().stream().map(PlanSummaryDetailDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add))
               .reduce(BigDecimal.ZERO, BigDecimal::add)
         )
         .completeSummary(completeList.stream().map(DeliverDTO::getComplete).reduce(BigDecimal.ZERO, BigDecimal::add))
         .details(detailsList)
         .avgDeliverRatio(avgDeliverRatio)
         .build();
   }

   @Override
   public InspectionDTO inspectionAnalysis(LocalDateTime dateTime) {
      Map<Integer, InspectionAnalysisDO> analysisDOMap = new HashMap<>();
      this.inspectionTeamReportService.inspectionAnalysisList(dateTime).forEach(e -> {
         InspectionAnalysisDO var10000 = analysisDOMap.put(e.getMonth(), e);
      });
      Integer monthQuantity = 0;
      BigDecimal sumPassRatio = BigDecimal.ZERO;
      List<InspectionDetailsDTO> details = new ArrayList<>();

      for (int i = 1; i < 13; i++) {
         if (analysisDOMap.get(i) == null) {
            details.add(InspectionDetailsDTO.builder().month(i).quantity(0).problemQuantity(0).passRatio(BigDecimal.ZERO).build());
         } else {
            InspectionDetailsDTO dto = BeanUtil.copy(analysisDOMap.get(i), InspectionDetailsDTO.class);
            dto.setPassRatio(
               BigDecimal.valueOf(dto.getQuantity().intValue())
                  .subtract(BigDecimal.valueOf(dto.getProblemQuantity().intValue()))
                  .divide(BigDecimal.valueOf(dto.getQuantity().intValue()), 5, RoundingMode.HALF_UP)
                  .multiply(BigDecimal.valueOf(100L))
            );
            monthQuantity = monthQuantity + 1;
            sumPassRatio = sumPassRatio.add(dto.getPassRatio());
            details.add(dto);
         }
      }

      InspectionDTO dto = InspectionDTO.builder()
         .details(details)
         .problemQuantitySummary(details.stream().mapToInt(InspectionDetailsDTO::getProblemQuantity).sum())
         .quantitySummary(details.stream().mapToInt(InspectionDetailsDTO::getQuantity).sum())
         .avgPassRatio(BigDecimal.ZERO)
         .build();
      if (monthQuantity != 0) {
         dto.setAvgPassRatio(sumPassRatio.divide(BigDecimal.valueOf(monthQuantity.intValue()), 5, RoundingMode.HALF_UP));
      }

      return dto;
   }
}
