package com.hzchum.scim.contract.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.scim.business.core.api.biz.BusinessBiz;
import com.hzchum.scim.business.core.api.utils.BusinessPriceUtils;
import com.hzchum.scim.common.core.api.enums.BranchAttributeEnum;
import com.hzchum.scim.common.core.api.enums.BranchCompanyLevelEnum;
import com.hzchum.scim.common.core.api.enums.HandleMethodEnum;
import com.hzchum.scim.common.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.enums.WasteHandleMethodEnum;
import com.hzchum.scim.common.core.api.pojo.common.CargoListProductLinkPriceDTO;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.BasicClassMeteAndAmountDTO;
import com.hzchum.scim.common.core.api.pojo.dto.CostSummaryDTO;
import com.hzchum.scim.common.core.api.pojo.dto.CostSummaryValueDTO;
import com.hzchum.scim.contract.core.api.biz.ContractCollectionBiz;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.finance.WaterElectricityPropertyFeeTypeEnum;
import com.hzchum.scim.contract.core.api.enums.payment.OrderClassEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.CommonDetailsDO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCollection;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ProjectBranchCompanyLink;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierSettlement;
import com.hzchum.scim.contract.core.api.pojo.dto.CostFinishedProductScrapLossDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.CostMainBusinessIncomeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.CostNonMainBusinessIncomeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.CostShipAmountDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.CostTransportationDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ManufactureCostAmortizationDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ManufactureCostDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ManufactureCostProductionLaborDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ReimbursementCostDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProjectMaterialsAllDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.ProjectLedgerSupplierInvoiceDetailDTO;
import com.hzchum.scim.contract.core.api.service.ContractCollectionService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ManufactureCostService;
import com.hzchum.scim.contract.core.api.service.ProjectBranchCompanyLinkService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.SupplierSettlementService;
import com.hzchum.scim.contract.core.api.utils.ProjectFinanceUtils;
import com.hzchum.scim.contract.core.mapper.ManufactureCostMapper;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.ShipmentStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseTypeProductReturnEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoList;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductLink;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.enclosure.core.api.enums.cargoList.CargoListStatusEnum;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReturnProductChild;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReturnProductMain;
import com.hzchum.scim.project.core.api.pojo._do.ProjectWasteProductChild;
import com.hzchum.scim.project.core.api.service.ProjectReturnProductChildService;
import com.hzchum.scim.project.core.api.service.ProjectReturnProductMainService;
import com.hzchum.scim.project.core.api.service.ProjectWasteProductChildService;
import com.hzchum.scim.scm.core.api.enums.PlaceEnum;
import com.hzchum.scim.scm.core.api.enums.PurchaseEnum;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.wms.core.api.biz.wmsReport.WasteSaleBiz;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnDetailService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufactureCostServiceImpl implements ManufactureCostService {
   private static final String NOTAX_REDIS_KEY = "manufacture_cost_data";
   private static final String TAX_REDIS_KEY = "manufacture_cost_data_tax_inclusive";
   private static final ObjectMapper objectMapper = new ObjectMapper();
   @Resource
   private ManufactureCostMapper manufactureCostMapper;
   @Autowired
   private ContractProjectService projectService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private ProjectBranchCompanyLinkService projectBranchCompanyLinkService;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private SupplierPaymentService supplierPaymentService;
   @Resource
   private SupplierSettlementService supplierSettlementService;
   @Resource
   private ProjectFinanceUtils projectFinanceUtils;
   @Resource
   private BusinessBiz businessBiz;
   @Resource
   private BusinessPriceUtils businessPriceUtils;
   @Resource
   private MesBuildingCargoListService cargoListService;
   @Resource
   private MesBuildingCargoListProductLinkService cargoListProductLinkService;
   @Resource
   private ProjectReturnProductMainService returnProductMainService;
   @Resource
   private ProjectReturnProductChildService returnProductChildService;
   @Resource
   private ProjectWasteProductChildService wasteProductChildService;
   @Resource
   private RedisUtils redisUtils;
   @Autowired
   private MoveOutboundDetailService moveOutboundDetailService;
   @Autowired
   private ReturnDetailService returnDetailService;
   @Resource
   private WasteSaleBiz wasteSaleBiz;
   @Resource
   private ContractCollectionService collectionService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Autowired
   private ContractCollectionBiz collectionBiz;

   private void updateAndCacheData(Boolean boolTaxIncluded) {
      List<ManufactureCostDTO> data = this.fetchDataFromDatabase(boolTaxIncluded);
      if (data != null && !data.isEmpty()) {
         try {
            String jsonData = objectMapper.writeValueAsString(data);
            this.redisUtils.del(boolTaxIncluded ? "manufacture_cost_data_tax_inclusive" : "manufacture_cost_data");
            this.redisUtils.set(boolTaxIncluded ? "manufacture_cost_data_tax_inclusive" : "manufacture_cost_data", jsonData);
         } catch (JsonProcessingException e) {
            e.printStackTrace();
         }
      }
   }

   private List<ManufactureCostDTO> fetchDataFromDatabase(Boolean boolTaxIncluded) {
      List<ManufactureCostDTO> manufactureCostDTOList = this.manufactureCostMapper.manufactureCost(null, null, null, null);
      if (CollectionUtils.isNotEmpty(manufactureCostDTOList)) {
         manufactureCostDTOList.forEach(
            manufactureCostDTO -> {
               manufactureCostDTO.setCreateTime(StrUtil.split(manufactureCostDTO.getCreateTime(), " ").get(0));
               BigDecimal cumulativeCost = this.costSummary(manufactureCostDTO.getProjectId(), boolTaxIncluded)
                  .stream()
                  .filter(e -> e.getIndexNumber().equals(1000))
                  .map(CostSummaryDTO::getTotal)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               manufactureCostDTO.setNonMainBusinessIncome(BigDecimal.ZERO);
               List<CostNonMainBusinessIncomeDTO> costNonMainBusinessIncomeDTOList = this.nonMainBusinessIncome(null, null, manufactureCostDTO.getProjectId());
               BigDecimal nonMainBusinessIncome = costNonMainBusinessIncomeDTOList.stream()
                  .map(CostNonMainBusinessIncomeDTO::getAmortizationAmount)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               manufactureCostDTO.setNonMainBusinessIncome(nonMainBusinessIncome);
               List<CostMainBusinessIncomeDTO> costMainBusinessIncomeDTOList = this.mainBusinessIncome(null, null, manufactureCostDTO.getProjectId());
               BigDecimal mainBusinessIncome = costMainBusinessIncomeDTOList.stream()
                  .map(CostMainBusinessIncomeDTO::getTotalAmount)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               manufactureCostDTO.setMainBusinessIncome(mainBusinessIncome);
               manufactureCostDTO.setCumulativeCost(cumulativeCost);
               BigDecimal incomeTotal = mainBusinessIncome.add(nonMainBusinessIncome);
               manufactureCostDTO.setIncomeTotal(incomeTotal);
               BigDecimal grossProfit = incomeTotal.subtract(cumulativeCost);
               manufactureCostDTO.setGrossProfit(grossProfit);
               if (incomeTotal.compareTo(BigDecimal.ZERO) != 0) {
                  BigDecimal grossProfitRate = grossProfit.divide(incomeTotal, 8, RoundingMode.HALF_UP);
                  manufactureCostDTO.setGrossProfitRate(grossProfitRate);
               } else {
                  manufactureCostDTO.setGrossProfitRate(BigDecimal.ZERO);
               }
            }
         );
      }

      return manufactureCostDTOList;
   }

   @Override
   public List<ProjectInfo> projectList(Integer status) {
      return this.manufactureCostMapper.projectList(status);
   }

   @Override
   public PageVO<ManufactureCostDTO> manufactureCostPage(
      String year, Long projectId, Integer status, Boolean boolTaxIncluded, Integer pageNumber, Integer pageSize
   ) {
      List<ManufactureCostDTO> manufactureCostDTOList = new ArrayList<>();
      manufactureCostDTOList = this.getManufactureCostDTOS(boolTaxIncluded, manufactureCostDTOList);
      manufactureCostDTOList = manufactureCostDTOList.stream().filter(i -> {
         boolean bool_result = true;
         if (StrUtil.isNotBlank(year) && NumberUtil.isInteger(year)) {
            List<String> dateList = StrUtil.split(i.getCreateTime(), " ");
            LocalDate createDate = LocalDate.parse(dateList.get(0), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            bool_result &= Integer.parseInt(year) == createDate.getYear();
         }

         if (projectId != null) {
            bool_result &= projectId.equals(i.getProjectId());
         }

         if (status != null) {
            bool_result &= status.equals(i.getStatus());
         }

         return bool_result;
      }).collect(Collectors.toList());
      return PageUtil.listPage(pageNumber, pageSize, manufactureCostDTOList);
   }

   @Override
   public List<ManufactureCostDTO> manufactureCostList(String year, Long projectId, Integer status, Boolean boolTaxIncluded) {
      List<ManufactureCostDTO> manufactureCostDTOList = this.manufactureCostMapper.manufactureCost(year, projectId, null, status);
      if (CollUtil.isNotEmpty(manufactureCostDTOList)) {
         ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() / 2);
         List<CompletableFuture<ManufactureCostDTO>> futures = manufactureCostDTOList.stream()
            .map(manufactureCostDTO -> CompletableFuture.supplyAsync(() -> this.extracted(boolTaxIncluded, manufactureCostDTO), executorService))
            .collect(Collectors.toList());
         CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
         return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
      } else {
         return manufactureCostDTOList;
      }
   }

   private ManufactureCostDTO extracted(Boolean boolTaxIncluded, ManufactureCostDTO manufactureCostDTO) {
      manufactureCostDTO.setCreateTime(StrUtil.split(manufactureCostDTO.getCreateTime(), " ").get(0));
      BigDecimal cumulativeCost = this.costSummary(manufactureCostDTO.getProjectId(), boolTaxIncluded)
         .stream()
         .filter(e -> e.getIndexNumber().equals(1000))
         .map(CostSummaryDTO::getTotal)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      manufactureCostDTO.setNonMainBusinessIncome(BigDecimal.ZERO);
      List<CostNonMainBusinessIncomeDTO> costNonMainBusinessIncomeDTOList = this.nonMainBusinessIncome(null, null, manufactureCostDTO.getProjectId());
      BigDecimal nonMainBusinessIncome = costNonMainBusinessIncomeDTOList.stream()
         .map(CostNonMainBusinessIncomeDTO::getAmortizationAmount)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      manufactureCostDTO.setNonMainBusinessIncome(nonMainBusinessIncome);
      List<CostMainBusinessIncomeDTO> costMainBusinessIncomeDTOList = this.mainBusinessIncome(null, null, manufactureCostDTO.getProjectId());
      BigDecimal mainBusinessIncome = costMainBusinessIncomeDTOList.stream()
         .map(CostMainBusinessIncomeDTO::getTotalAmount)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      manufactureCostDTO.setMainBusinessIncome(mainBusinessIncome);
      manufactureCostDTO.setCumulativeCost(cumulativeCost);
      BigDecimal incomeTotal = mainBusinessIncome.add(nonMainBusinessIncome);
      manufactureCostDTO.setIncomeTotal(incomeTotal);
      BigDecimal grossProfit = incomeTotal.subtract(cumulativeCost);
      manufactureCostDTO.setGrossProfit(grossProfit);
      if (incomeTotal.compareTo(BigDecimal.ZERO) != 0) {
         BigDecimal grossProfitRate = grossProfit.divide(incomeTotal, 8, RoundingMode.HALF_UP);
         manufactureCostDTO.setGrossProfitRate(grossProfitRate);
      } else {
         manufactureCostDTO.setGrossProfitRate(BigDecimal.ZERO);
      }

      return manufactureCostDTO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> manufactureCostPrint(
      HttpServletResponse response, String year, Long projectId, Integer status, Boolean boolTaxIncluded
   ) {
      new Thread(this::printUpdateData).start();
      List<ManufactureCostDTO> manufactureCostDTOList = this.manufactureCostList(year, projectId, status, boolTaxIncluded);
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "制造成本统计");
      printVO.setHeader(header);
      List<Map<String, Object>> mapList = manufactureCostDTOList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   private void printUpdateData() {
      this.updateAndCacheData(true);
      this.updateAndCacheData(false);
   }

   @Override
   public Map<String, BigDecimal> manufactureCostTotal(String year, Long projectId, Integer status, Boolean boolTaxIncluded) {
      List<ManufactureCostDTO> manufactureCostDTOList = new ArrayList<>();
      manufactureCostDTOList = this.getManufactureCostDTOS(boolTaxIncluded, manufactureCostDTOList);
      manufactureCostDTOList = manufactureCostDTOList.stream().filter(i -> {
         boolean bool_result = true;
         if (StrUtil.isNotBlank(year) && NumberUtil.isInteger(year)) {
            List<String> dateList = StrUtil.split(i.getCreateTime(), " ");
            LocalDate createDate = LocalDate.parse(dateList.get(0), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            bool_result &= Integer.parseInt(year) == createDate.getYear();
         }

         if (projectId != null) {
            bool_result &= projectId.equals(i.getProjectId());
         }

         if (status != null) {
            bool_result &= status.equals(i.getStatus());
         }

         return bool_result;
      }).collect(Collectors.toList());
      BigDecimal contractRevenue = manufactureCostDTOList.stream().map(ManufactureCostDTO::getIncomeTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal accumulatedCost = manufactureCostDTOList.stream().map(ManufactureCostDTO::getCumulativeCost).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal realizeProfits = contractRevenue.subtract(accumulatedCost);
      BigDecimal realizeProfitsRate;
      if (contractRevenue.compareTo(BigDecimal.ZERO) != 0) {
         realizeProfitsRate = realizeProfits.divide(contractRevenue, 4, RoundingMode.HALF_UP);
      } else {
         realizeProfitsRate = BigDecimal.ZERO;
      }

      return MapUtil.builder("contractRevenue", contractRevenue)
         .put("accumulatedCost", accumulatedCost)
         .put("realizeProfits", realizeProfits)
         .put("realizeProfitsRate", realizeProfitsRate)
         .build();
   }

   private List<ManufactureCostDTO> getManufactureCostDTOS(Boolean boolTaxIncluded, List<ManufactureCostDTO> manufactureCostDTOList) {
      if (boolTaxIncluded) {
         if (this.redisUtils.hasKey("manufacture_cost_data_tax_inclusive")) {
            String manufactureCostData = this.redisUtils.get("manufacture_cost_data_tax_inclusive").toString();
            if (null == manufactureCostData) {
               this.updateAndCacheData(boolTaxIncluded);
               manufactureCostData = this.redisUtils.get("manufacture_cost_data_tax_inclusive").toString();
            }

            try {
               manufactureCostDTOList = objectMapper.readValue(
                  manufactureCostData.toString(), objectMapper.getTypeFactory().constructCollectionType(List.class, ManufactureCostDTO.class)
               );
            } catch (JsonProcessingException e) {
               throw new RuntimeException(e);
            }
         } else {
            this.updateAndCacheData(boolTaxIncluded);
         }
      } else if (this.redisUtils.hasKey("manufacture_cost_data")) {
         String manufactureCostData = this.redisUtils.get("manufacture_cost_data").toString();
         if (null == manufactureCostData) {
            this.updateAndCacheData(boolTaxIncluded);
            manufactureCostData = this.redisUtils.get("manufacture_cost_data").toString();
         }

         try {
            manufactureCostDTOList = objectMapper.readValue(
               manufactureCostData.toString(), objectMapper.getTypeFactory().constructCollectionType(List.class, ManufactureCostDTO.class)
            );
         } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
         }
      } else {
         this.updateAndCacheData(boolTaxIncluded);
      }

      return manufactureCostDTOList;
   }

   @Override
   public List<CostSummaryDTO> costSummary(Long projectId, Boolean boolTaxIncluded) {
      List<CostSummaryDTO> costSummaryDTOS = Lists.newArrayList();
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      List<SupplierPayment> supplierPaymentList = this.getMaterialSentDirectlySitePayment(projectId, boolTaxIncluded);
      Set<LocalDate> paymentYearMonthDateList = supplierPaymentList.stream().map(s -> s.getPaymentDate().withDayOfMonth(1)).collect(Collectors.toSet());
      paymentYearMonthDateList.stream().filter(s -> !yearMonthDateList.contains(s)).forEach(yearMonthDateList::add);
      Map<String, ManufactureCostAmortizationDTO> totalYieldAndProjectYieldMap = this.manufactureCostMapper
         .getTotalYieldAndProjectYield(projectId, yearMonthDateList)
         .stream()
         .collect(Collectors.toMap(ManufactureCostAmortizationDTO::getYearMonth, Function.identity()));
      costSummaryDTOS.add(this.getFirst(yearMonthDateList));
      costSummaryDTOS.add(this.getStructuralProduct(projectId, yearMonthDateList));
      List<CostSummaryValueDTO> steelPlateValueList = this.moveOutboundDetailService
         .getMeteByProjectId(
            new ArrayList<>(Arrays.asList(BasicClassEnum.STEEL_PLATE.getType())), projectId, yearMonthDateList, null, null, null, null, boolTaxIncluded
         );
      steelPlateValueList.stream()
         .filter(i -> i.getCostMonthTotal() != null)
         .forEach(i -> i.setCostMonthTotal(i.getCostMonthTotal().setScale(0, RoundingMode.HALF_UP)));
      CostSummaryDTO steelPlate = CostSummaryDTO.builder().costSummaryValueDTO(steelPlateValueList).name("钢板").indexName("1.1").indexNumber(11).build();
      BigDecimal steelPlateTotal = this.getTotal(steelPlate.getCostSummaryValueDTO());
      steelPlate.setTotal(steelPlateTotal);
      List<CostSummaryValueDTO> profileMaterialValueList = this.moveOutboundDetailService
         .getMeteByProjectId(
            new ArrayList<>(Arrays.asList(BasicClassEnum.SECTION_STEEL.getType())), projectId, yearMonthDateList, null, null, null, null, boolTaxIncluded
         );
      profileMaterialValueList.stream()
         .filter(i -> i.getCostMonthTotal() != null)
         .forEach(i -> i.setCostMonthTotal(i.getCostMonthTotal().setScale(0, RoundingMode.HALF_UP)));
      CostSummaryDTO profileMaterial = CostSummaryDTO.builder()
         .costSummaryValueDTO(profileMaterialValueList)
         .name("型材")
         .indexName("1.2")
         .indexNumber(12)
         .build();
      BigDecimal profileMaterialTotal = this.getTotal(profileMaterial.getCostSummaryValueDTO());
      profileMaterial.setTotal(profileMaterialTotal);
      List<CostSummaryValueDTO> steelCoilValueList = this.moveOutboundDetailService
         .getMeteByProjectId(
            new ArrayList<>(Arrays.asList(BasicClassEnum.COLOR_ROLL.getType())), projectId, yearMonthDateList, null, null, null, null, boolTaxIncluded
         );
      steelCoilValueList.stream()
         .filter(i -> i.getCostMonthTotal() != null)
         .forEach(i -> i.setCostMonthTotal(i.getCostMonthTotal().setScale(0, RoundingMode.HALF_UP)));
      CostSummaryDTO steelCoil = CostSummaryDTO.builder().costSummaryValueDTO(steelCoilValueList).name("钢卷").indexName("1.3").indexNumber(13).build();
      BigDecimal steelCoilTotal = this.getTotal(steelCoil.getCostSummaryValueDTO());
      steelCoil.setTotal(steelCoilTotal);
      List<CostSummaryValueDTO> manufacturedGoodsValueList = this.collectionBiz.getProjectDisburse(projectId, yearMonthDateList);
      manufacturedGoodsValueList.stream()
         .filter(i -> i.getCostMonthTotal() != null)
         .forEach(i -> i.setCostMonthTotal(i.getCostMonthTotal().setScale(0, RoundingMode.HALF_UP)));
      CostSummaryDTO manufacturedGoods = CostSummaryDTO.builder()
         .costSummaryValueDTO(manufacturedGoodsValueList)
         .name("制成品采购")
         .indexName("1.4")
         .indexNumber(14)
         .build();
      BigDecimal manufacturedGoodsTotal = this.getTotal(manufacturedGoods.getCostSummaryValueDTO());
      manufacturedGoods.setTotal(manufacturedGoodsTotal);
      List<CostSummaryValueDTO> otherSteelMaterialsValueList = this.moveOutboundDetailService
         .getMeteByProjectId(
            new ArrayList<>(Arrays.asList(BasicClassEnum.OTHER_STEEL_MATERIALS.getType())),
            projectId,
            yearMonthDateList,
            null,
            null,
            null,
            null,
            boolTaxIncluded
         );
      otherSteelMaterialsValueList.stream()
         .filter(i -> i.getCostMonthTotal() != null)
         .forEach(i -> i.setCostMonthTotal(i.getCostMonthTotal().setScale(0, RoundingMode.HALF_UP)));
      CostSummaryDTO otherSteelMaterials = CostSummaryDTO.builder()
         .costSummaryValueDTO(otherSteelMaterialsValueList)
         .name("其它钢材")
         .indexName("1.5")
         .indexNumber(15)
         .build();
      BigDecimal otherSteelMaterialsTotal = this.getTotal(otherSteelMaterials.getCostSummaryValueDTO());
      otherSteelMaterials.setTotal(otherSteelMaterialsTotal);
      List<CostSummaryValueDTO> otherSteelMaterialsAmortizationList = this.moveOutboundDetailService
         .getMeteByProjectId(
            new ArrayList<>(Arrays.asList(BasicClassEnum.OTHER_STEEL_MATERIALS.getType())), null, yearMonthDateList, null, null, null, null, boolTaxIncluded
         );
      otherSteelMaterialsAmortizationList.forEach(e -> {
         BigDecimal monthAmortizedCost = null;
         ManufactureCostAmortizationDTO totalYieldAndProjectYield = totalYieldAndProjectYieldMap.get(e.getYearMonth());
         if (BeanUtil.isNotEmpty(totalYieldAndProjectYield) && totalYieldAndProjectYield.getTotalYield().compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal proportion = totalYieldAndProjectYield.getProjectYield().divide(totalYieldAndProjectYield.getTotalYield(), 2, RoundingMode.HALF_UP);
            if (e.getCostMonthTotal() != null) {
               monthAmortizedCost = e.getCostMonthTotal().multiply(proportion).setScale(0, RoundingMode.HALF_UP);
            }
         }

         e.setCostMonthTotal(monthAmortizedCost);
      });
      CostSummaryDTO otherSteelMaterialsAmortization = CostSummaryDTO.builder()
         .costSummaryValueDTO(otherSteelMaterialsAmortizationList)
         .name("其它钢材摊销")
         .indexName("1.6")
         .indexNumber(16)
         .build();
      BigDecimal otherSteelMaterialsAmortizationTotal = this.getTotal(otherSteelMaterialsAmortization.getCostSummaryValueDTO());
      otherSteelMaterialsAmortization.setTotal(otherSteelMaterialsAmortizationTotal);
      BigDecimal oneTotal = steelPlateTotal.add(profileMaterialTotal)
         .add(steelCoilTotal)
         .add(manufacturedGoodsTotal)
         .add(otherSteelMaterialsTotal)
         .add(otherSteelMaterialsAmortizationTotal);
      CostSummaryDTO one = CostSummaryDTO.builder().indexNumber(10).indexName("一").name("主材成本").total(oneTotal).build();
      if (oneTotal.compareTo(BigDecimal.ZERO) != 0) {
         steelPlate.setSubItemDisplay(steelPlateTotal.divide(oneTotal, 4, RoundingMode.HALF_UP));
         profileMaterial.setSubItemDisplay(profileMaterialTotal.divide(oneTotal, 4, RoundingMode.HALF_UP));
         steelCoil.setSubItemDisplay(steelCoilTotal.divide(oneTotal, 4, RoundingMode.HALF_UP));
         manufacturedGoods.setSubItemDisplay(manufacturedGoodsTotal.divide(oneTotal, 4, RoundingMode.HALF_UP));
         otherSteelMaterials.setSubItemDisplay(otherSteelMaterialsTotal.divide(oneTotal, 4, RoundingMode.HALF_UP));
         otherSteelMaterialsAmortization.setSubItemDisplay(otherSteelMaterialsAmortizationTotal.divide(oneTotal, 4, RoundingMode.HALF_UP));
      }

      List<CostSummaryValueDTO> auxiliaryMaterialDirectValueList = this.moveOutboundDetailService
         .getMeteByProjectId(
            new ArrayList<>(Arrays.asList(BasicClassEnum.GENERAL_MATERIAL.getType(), BasicClassEnum.OTHER.getType())),
            projectId,
            yearMonthDateList,
            null,
            null,
            Arrays.asList("油漆", "焊材", "焊接材料", "焊丝焊剂"),
            null,
            boolTaxIncluded
         );
      auxiliaryMaterialDirectValueList.stream()
         .filter(i -> i.getCostMonthTotal() != null)
         .forEach(i -> i.setCostMonthTotal(i.getCostMonthTotal().setScale(0, RoundingMode.HALF_UP)));
      CostSummaryDTO auxiliaryMaterialDirect = CostSummaryDTO.builder()
         .costSummaryValueDTO(auxiliaryMaterialDirectValueList)
         .name("直接成本")
         .indexName("2.1")
         .indexNumber(21)
         .build();
      BigDecimal auxiliaryMaterialDirectTotal = this.getTotal(auxiliaryMaterialDirect.getCostSummaryValueDTO());
      auxiliaryMaterialDirect.setTotal(auxiliaryMaterialDirectTotal);
      List<CostSummaryValueDTO> auxiliaryMaterialAmortizationValueList = this.moveOutboundDetailService
         .getMeteByProjectId(
            new ArrayList<>(Arrays.asList(BasicClassEnum.GENERAL_MATERIAL.getType(), BasicClassEnum.OTHER.getType())),
            null,
            yearMonthDateList,
            null,
            null,
            null,
            null,
            boolTaxIncluded
         );
      auxiliaryMaterialAmortizationValueList.forEach(e -> {
         BigDecimal monthAmortizedCost = null;
         ManufactureCostAmortizationDTO totalYieldAndProjectYield = totalYieldAndProjectYieldMap.get(e.getYearMonth());
         if (BeanUtil.isNotEmpty(totalYieldAndProjectYield)) {
            if (totalYieldAndProjectYield.getTotalYield().compareTo(BigDecimal.ZERO) != 0) {
               BigDecimal proportion = totalYieldAndProjectYield.getProjectYield().divide(totalYieldAndProjectYield.getTotalYield(), 2, RoundingMode.HALF_UP);
               if (e.getCostMonthTotal() != null) {
                  monthAmortizedCost = e.getCostMonthTotal().multiply(proportion).setScale(0, RoundingMode.HALF_UP);
               }
            } else {
               e.setCostMonthTotal(null);
            }
         } else {
            e.setCostMonthTotal(null);
         }

         e.setCostMonthTotal(monthAmortizedCost);
      });
      CostSummaryDTO auxiliaryMaterialsAmortization = CostSummaryDTO.builder()
         .costSummaryValueDTO(auxiliaryMaterialAmortizationValueList)
         .name("摊销成本")
         .indexName("2.2")
         .indexNumber(22)
         .build();
      BigDecimal auxiliaryMaterialsAmortizationTotal = this.getTotal(auxiliaryMaterialsAmortization.getCostSummaryValueDTO());
      auxiliaryMaterialsAmortization.setTotal(auxiliaryMaterialsAmortizationTotal);
      List<CostSummaryValueDTO> paintValueList = this.moveOutboundDetailService
         .getMeteByProjectId(
            new ArrayList<>(Arrays.asList(BasicClassEnum.GENERAL_MATERIAL.getType())),
            projectId,
            yearMonthDateList,
            null,
            null,
            null,
            Arrays.asList("油漆"),
            boolTaxIncluded
         );
      paintValueList.stream()
         .filter(i -> i.getCostMonthTotal() != null)
         .forEach(i -> i.setCostMonthTotal(i.getCostMonthTotal().setScale(0, RoundingMode.HALF_UP)));
      CostSummaryDTO paint = CostSummaryDTO.builder().costSummaryValueDTO(paintValueList).name("油漆成本").indexName("2.3").indexNumber(23).build();
      BigDecimal paintTotal = this.getTotal(paint.getCostSummaryValueDTO());
      paint.setTotal(paintTotal);
      List<CostSummaryValueDTO> weldingConsumablesValueList = this.moveOutboundDetailService
         .getMeteByProjectId(
            new ArrayList<>(Arrays.asList(BasicClassEnum.GENERAL_MATERIAL.getType())),
            projectId,
            yearMonthDateList,
            null,
            null,
            null,
            Arrays.asList("焊材", "焊接材料", "焊丝焊剂"),
            boolTaxIncluded
         );
      weldingConsumablesValueList.stream()
         .filter(i -> i.getCostMonthTotal() != null)
         .forEach(i -> i.setCostMonthTotal(i.getCostMonthTotal().setScale(0, RoundingMode.HALF_UP)));
      CostSummaryDTO weldingConsumables = CostSummaryDTO.builder()
         .costSummaryValueDTO(weldingConsumablesValueList)
         .name("焊材成本")
         .indexName("2.4")
         .indexNumber(24)
         .build();
      BigDecimal weldingConsumablesTotal = this.getTotal(weldingConsumables.getCostSummaryValueDTO());
      weldingConsumables.setTotal(weldingConsumablesTotal);
      BigDecimal twoTotal = auxiliaryMaterialDirectTotal.add(auxiliaryMaterialsAmortizationTotal).add(paintTotal).add(weldingConsumablesTotal);
      CostSummaryDTO two = CostSummaryDTO.builder().indexNumber(20).indexName("二").name("辅材成本").total(twoTotal).build();
      if (twoTotal.compareTo(BigDecimal.ZERO) != 0) {
         auxiliaryMaterialDirect.setSubItemDisplay(auxiliaryMaterialDirectTotal.divide(twoTotal, 4, RoundingMode.HALF_UP));
         auxiliaryMaterialsAmortization.setSubItemDisplay(auxiliaryMaterialsAmortizationTotal.divide(twoTotal, 4, RoundingMode.HALF_UP));
         paint.setSubItemDisplay(paintTotal.divide(twoTotal, 4, RoundingMode.HALF_UP));
         weldingConsumables.setSubItemDisplay(weldingConsumablesTotal.divide(twoTotal, 4, RoundingMode.HALF_UP));
      }

      CostSummaryDTO sendDirectlySiteMaterialCostDto = this.getMaterialSentDirectlySiteCost(yearMonthDateList, supplierPaymentList);
      BigDecimal sendDirectlySiteMaterialCostTotal = this.getTotal(sendDirectlySiteMaterialCostDto.getCostSummaryValueDTO());
      CostSummaryDTO three = CostSummaryDTO.builder().indexNumber(30).indexName("三").name("直发工地材料成本").total(sendDirectlySiteMaterialCostTotal).build();
      if (sendDirectlySiteMaterialCostTotal.compareTo(BigDecimal.ZERO) != 0) {
         sendDirectlySiteMaterialCostDto.setSubItemDisplay(BigDecimal.ONE);
      }

      CostSummaryDTO productionLaborCostFee = this.getProductionLaborCostFee(projectId, yearMonthDateList);
      BigDecimal productionLaborCostTotal = this.getTotal(productionLaborCostFee.getCostSummaryValueDTO());
      productionLaborCostFee.setTotal(productionLaborCostTotal);
      CostSummaryDTO tempWorkAmortizationCostFee = this.getTempWorkAmortizationCostFee(projectId, yearMonthDateList);
      BigDecimal tempWorkAmortizationCostTotal = this.getTotal(tempWorkAmortizationCostFee.getCostSummaryValueDTO());
      tempWorkAmortizationCostFee.setTotal(tempWorkAmortizationCostTotal);
      CostSummaryDTO managerAmortizationFee = this.getManagerAmortizationFee(projectId, yearMonthDateList);
      BigDecimal managerAmortizationTotal = this.getTotal(managerAmortizationFee.getCostSummaryValueDTO());
      managerAmortizationFee.setTotal(managerAmortizationTotal);
      BigDecimal fourTotal = productionLaborCostTotal.add(tempWorkAmortizationCostTotal).add(managerAmortizationTotal);
      CostSummaryDTO four = CostSummaryDTO.builder().indexNumber(40).indexName("四").name("人工成本").total(fourTotal).build();
      if (fourTotal.compareTo(BigDecimal.ZERO) != 0) {
         productionLaborCostFee.setSubItemDisplay(productionLaborCostTotal.divide(fourTotal, 4, RoundingMode.HALF_UP));
         tempWorkAmortizationCostFee.setSubItemDisplay(tempWorkAmortizationCostTotal.divide(fourTotal, 4, RoundingMode.HALF_UP));
         managerAmortizationFee.setSubItemDisplay(managerAmortizationTotal.divide(fourTotal, 4, RoundingMode.HALF_UP));
      }

      CostSummaryDTO freight = this.getFreight(projectId, boolTaxIncluded, yearMonthDateList);
      BigDecimal freightTotal = this.getTotal(freight.getCostSummaryValueDTO());
      freight.setTotal(freightTotal);
      CostSummaryDTO five = CostSummaryDTO.builder().indexNumber(50).indexName("五").name("运输成本").total(freightTotal).build();
      if (freightTotal.compareTo(BigDecimal.ZERO) != 0) {
         freight.setSubItemDisplay(BigDecimal.ONE);
      }

      CostSummaryDTO repairFeeDto = this.getReturnRepair(projectId, boolTaxIncluded, yearMonthDateList);
      repairFeeDto.setTotal(this.getTotal(repairFeeDto.getCostSummaryValueDTO()));
      CostSummaryDTO reuseFeeDto = this.getReturnReuse(projectId, boolTaxIncluded, yearMonthDateList);
      reuseFeeDto.setTotal(this.getTotal(reuseFeeDto.getCostSummaryValueDTO()));
      BigDecimal sixTotal = repairFeeDto.getTotal().add(reuseFeeDto.getTotal());
      CostSummaryDTO six = CostSummaryDTO.builder().indexNumber(60).indexName("六").name("制品退货成本").total(sixTotal).build();
      if (sixTotal.compareTo(BigDecimal.ZERO) != 0) {
         repairFeeDto.setSubItemDisplay(repairFeeDto.getTotal().divide(sixTotal, 4, RoundingMode.HALF_UP));
         reuseFeeDto.setSubItemDisplay(reuseFeeDto.getTotal().divide(sixTotal, 4, RoundingMode.HALF_UP));
      }

      CostSummaryDTO waterElectricFee = this.getWaterElectricFee(projectId, yearMonthDateList);
      BigDecimal waterElectricTotal = this.getTotal(waterElectricFee.getCostSummaryValueDTO());
      waterElectricFee.setTotal(waterElectricTotal);
      List<CostSummaryValueDTO> gasValueList = this.moveOutboundDetailService
         .getMeteByProjectId(new ArrayList<>(Arrays.asList(BasicClassEnum.GAS.getType())), null, yearMonthDateList, null, null, null, null, boolTaxIncluded);
      gasValueList.forEach(e -> {
         BigDecimal monthAmortizedCost = null;
         ManufactureCostAmortizationDTO totalYieldAndProjectYield = totalYieldAndProjectYieldMap.get(e.getYearMonth());
         if (BeanUtil.isNotEmpty(totalYieldAndProjectYield)) {
            if (totalYieldAndProjectYield.getTotalYield().compareTo(BigDecimal.ZERO) != 0) {
               BigDecimal proportion = totalYieldAndProjectYield.getProjectYield().divide(totalYieldAndProjectYield.getTotalYield(), 2, RoundingMode.HALF_UP);
               if (e.getCostMonthTotal() != null) {
                  monthAmortizedCost = e.getCostMonthTotal().multiply(proportion).setScale(0, RoundingMode.HALF_UP);
               }
            } else {
               e.setCostMonthTotal(null);
            }
         } else {
            e.setCostMonthTotal(null);
         }

         e.setCostMonthTotal(monthAmortizedCost);
      });
      CostSummaryDTO gas = CostSummaryDTO.builder().costSummaryValueDTO(gasValueList).name("气体摊销成本").indexName("7.2").indexNumber(72).build();
      BigDecimal gasTotal = this.getTotal(gas.getCostSummaryValueDTO());
      gas.setTotal(gasTotal);
      CostSummaryDTO propertyFee = this.getPropertyFee(projectId, yearMonthDateList);
      BigDecimal propertyTotal = this.getTotal(propertyFee.getCostSummaryValueDTO());
      propertyFee.setTotal(propertyTotal);
      List<CostSummaryValueDTO> gasDirectCostValueList = this.moveOutboundDetailService
         .getMeteByProjectId(
            new ArrayList<>(Arrays.asList(BasicClassEnum.GAS.getType())), projectId, yearMonthDateList, null, null, null, null, boolTaxIncluded
         );
      gasDirectCostValueList.stream()
         .filter(i -> i.getCostMonthTotal() != null)
         .forEach(i -> i.setCostMonthTotal(i.getCostMonthTotal().setScale(0, RoundingMode.HALF_UP)));
      CostSummaryDTO gasDirectCost = CostSummaryDTO.builder()
         .costSummaryValueDTO(gasDirectCostValueList)
         .name("气体直接成本")
         .indexName("7.4")
         .indexNumber(74)
         .build();
      BigDecimal gasDirectCostTotal = this.getTotal(gasDirectCost.getCostSummaryValueDTO());
      gasDirectCost.setTotal(gasDirectCostTotal);
      BigDecimal sevenTotal = waterElectricTotal.add(propertyTotal).add(gasTotal).add(gasDirectCostTotal);
      CostSummaryDTO seven = CostSummaryDTO.builder().indexNumber(70).indexName("七").name("水电气成本").total(sevenTotal).build();
      if (sevenTotal.compareTo(BigDecimal.ZERO) != 0) {
         waterElectricFee.setSubItemDisplay(waterElectricTotal.divide(sevenTotal, 4, RoundingMode.HALF_UP));
         gas.setSubItemDisplay(gasTotal.divide(sevenTotal, 4, RoundingMode.HALF_UP));
         propertyFee.setSubItemDisplay(propertyTotal.divide(sevenTotal, 4, RoundingMode.HALF_UP));
         gasDirectCost.setSubItemDisplay(gasDirectCostTotal.divide(sevenTotal, 4, RoundingMode.HALF_UP));
      }

      CostSummaryDTO directCost = this.getDirectCost(projectId, yearMonthDateList);
      BigDecimal directCostTotal = this.getTotal(directCost.getCostSummaryValueDTO());
      directCost.setTotal(directCostTotal);
      CostSummaryDTO amortizationCost = this.getAmortizationCost(projectId, yearMonthDateList);
      BigDecimal amortizationCostTotal = this.getTotal(amortizationCost.getCostSummaryValueDTO());
      amortizationCost.setTotal(amortizationCostTotal);
      BigDecimal eightTotal = directCostTotal.add(amortizationCostTotal);
      CostSummaryDTO eight = CostSummaryDTO.builder().indexNumber(80).indexName("八").name("期间费用").total(eightTotal).build();
      if (eightTotal.compareTo(BigDecimal.ZERO) != 0) {
         directCost.setSubItemDisplay(directCostTotal.divide(eightTotal, 4, RoundingMode.HALF_UP));
         amortizationCost.setSubItemDisplay(amortizationCostTotal.divide(eightTotal, 4, RoundingMode.HALF_UP));
      }

      CostSummaryDTO factoryDepreciation = this.getFactoryDepreciation(projectId, yearMonthDateList);
      BigDecimal factoryDepreciationTotal = this.getTotal(factoryDepreciation.getCostSummaryValueDTO());
      factoryDepreciation.setTotal(factoryDepreciationTotal);
      CostSummaryDTO equipmentDepreciation = this.getEquipmentDepreciation(projectId, yearMonthDateList);
      BigDecimal equipmentDepreciationTotal = this.getTotal(equipmentDepreciation.getCostSummaryValueDTO());
      equipmentDepreciation.setTotal(equipmentDepreciationTotal);
      BigDecimal nineTotal = factoryDepreciationTotal.add(equipmentDepreciationTotal);
      CostSummaryDTO nine = CostSummaryDTO.builder().indexNumber(90).indexName("九").name("固定资产摊销").total(nineTotal).build();
      if (nineTotal.compareTo(BigDecimal.ZERO) != 0) {
         factoryDepreciation.setSubItemDisplay(factoryDepreciationTotal.divide(nineTotal, 4, RoundingMode.HALF_UP));
         equipmentDepreciation.setSubItemDisplay(equipmentDepreciationTotal.divide(nineTotal, 4, RoundingMode.HALF_UP));
      }

      CostSummaryDTO testingFee = this.getTestingFee(projectId, yearMonthDateList);
      BigDecimal testingFeeTotal = this.getTotal(testingFee.getCostSummaryValueDTO());
      testingFee.setTotal(testingFeeTotal);
      CostSummaryDTO finishedProductScrapLoss = this.finishedProductScrapLoss(projectId, yearMonthDateList);
      BigDecimal finishedProductScrapLossTotal = BigDecimal.ZERO;
      if (!finishedProductScrapLoss.getCostSummaryValueDTO().isEmpty()) {
         finishedProductScrapLossTotal = this.getTotal(finishedProductScrapLoss.getCostSummaryValueDTO());
         finishedProductScrapLoss.setTotal(finishedProductScrapLossTotal);
      }

      BigDecimal tenTotal = testingFeeTotal.add(finishedProductScrapLossTotal);
      CostSummaryDTO ten = CostSummaryDTO.builder().indexNumber(100).indexName("十").name("其他费用").total(tenTotal).build();
      if (tenTotal.compareTo(BigDecimal.ZERO) != 0) {
         testingFee.setSubItemDisplay(testingFeeTotal.divide(tenTotal, 4, RoundingMode.HALF_UP));
         finishedProductScrapLoss.setSubItemDisplay(finishedProductScrapLossTotal.divide(tenTotal, 4, RoundingMode.HALF_UP));
      }

      BigDecimal allTotal = BigDecimal.ZERO
         .add(oneTotal)
         .add(twoTotal)
         .add(sendDirectlySiteMaterialCostTotal)
         .add(fourTotal)
         .add(freightTotal)
         .add(sixTotal)
         .add(sevenTotal)
         .add(eightTotal)
         .add(nineTotal)
         .add(tenTotal);
      if (allTotal.compareTo(BigDecimal.ZERO) != 0) {
         one.setCostProportion(oneTotal.divide(allTotal, 4, RoundingMode.HALF_UP));
         two.setCostProportion(twoTotal.divide(allTotal, 4, RoundingMode.HALF_UP));
         three.setCostProportion(sendDirectlySiteMaterialCostTotal.divide(allTotal, 4, RoundingMode.HALF_UP));
         four.setCostProportion(fourTotal.divide(allTotal, 4, RoundingMode.HALF_UP));
         five.setCostProportion(freightTotal.divide(allTotal, 4, RoundingMode.HALF_UP));
         six.setCostProportion(sixTotal.divide(allTotal, 4, RoundingMode.HALF_UP));
         seven.setCostProportion(sevenTotal.divide(allTotal, 4, RoundingMode.HALF_UP));
         eight.setCostProportion(eightTotal.divide(allTotal, 4, RoundingMode.HALF_UP));
         nine.setCostProportion(nineTotal.divide(allTotal, 4, RoundingMode.HALF_UP));
         ten.setCostProportion(tenTotal.divide(allTotal, 4, RoundingMode.HALF_UP));
      }

      costSummaryDTOS.add(one);
      costSummaryDTOS.add(steelPlate);
      costSummaryDTOS.add(profileMaterial);
      costSummaryDTOS.add(steelCoil);
      costSummaryDTOS.add(manufacturedGoods);
      costSummaryDTOS.add(otherSteelMaterials);
      costSummaryDTOS.add(otherSteelMaterialsAmortization);
      costSummaryDTOS.add(two);
      costSummaryDTOS.add(auxiliaryMaterialDirect);
      costSummaryDTOS.add(auxiliaryMaterialsAmortization);
      costSummaryDTOS.add(paint);
      costSummaryDTOS.add(weldingConsumables);
      costSummaryDTOS.add(three);
      costSummaryDTOS.add(sendDirectlySiteMaterialCostDto);
      costSummaryDTOS.add(four);
      costSummaryDTOS.add(productionLaborCostFee);
      costSummaryDTOS.add(tempWorkAmortizationCostFee);
      costSummaryDTOS.add(managerAmortizationFee);
      costSummaryDTOS.add(five);
      costSummaryDTOS.add(freight);
      costSummaryDTOS.add(six);
      costSummaryDTOS.add(repairFeeDto);
      costSummaryDTOS.add(reuseFeeDto);
      costSummaryDTOS.add(seven);
      costSummaryDTOS.add(waterElectricFee);
      costSummaryDTOS.add(gas);
      costSummaryDTOS.add(propertyFee);
      costSummaryDTOS.add(gasDirectCost);
      costSummaryDTOS.add(eight);
      costSummaryDTOS.add(directCost);
      costSummaryDTOS.add(amortizationCost);
      costSummaryDTOS.add(nine);
      costSummaryDTOS.add(factoryDepreciation);
      costSummaryDTOS.add(equipmentDepreciation);
      costSummaryDTOS.add(ten);
      costSummaryDTOS.add(testingFee);
      costSummaryDTOS.add(finishedProductScrapLoss);
      CostSummaryDTO sumTotal = CostSummaryDTO.builder().indexNumber(1000).indexName(null).name("合计").total(allTotal).build();
      costSummaryDTOS.add(sumTotal);
      costSummaryDTOS.sort(Comparator.comparingInt(CostSummaryDTO::getIndexNumber));
      return costSummaryDTOS;
   }

   private List<SupplierPayment> getMaterialSentDirectlySitePayment(Long projectId, Boolean boolTaxIncluded) {
      List<PurchaseOrder> purchaseOrderList;
      if (!this.projectFinanceUtils.getBoolTwoLevelUnit()) {
         purchaseOrderList = this.purchaseOrderService
            .list(
               Wrappers.lambdaQuery(PurchaseOrder.class)
                  .eq(PurchaseOrder::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
                  .eq(PurchaseOrder::getOrderPlace, PlaceEnum.CONSTRUCTION_SITE.getType())
                  .eq(PurchaseOrder::getPurchaseType, PurchaseEnum.MATERIAL.getType())
                  .eq(PurchaseOrder::getProjectIds, String.valueOf(projectId))
            );
      } else {
         List<BranchCompany> branchCompanyList = this.branchCompanyService.list();
         List<Long> branchCompanyIds = branchCompanyList.stream()
            .filter(bc -> bc.getBranchAttributeEnum().equals(BranchAttributeEnum.MANUFACTURING.getType()))
            .map(BranchCompany::getId)
            .collect(Collectors.toList());
         ProjectBranchCompanyLink projectBranchCompanyLink = this.projectBranchCompanyLinkService
            .getOne(
               Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
                  .eq(ProjectBranchCompanyLink::getProjectId, projectId)
                  .in(ProjectBranchCompanyLink::getBranchCompanyId, branchCompanyIds)
            );
         purchaseOrderList = this.purchaseOrderService
            .list(
               Wrappers.lambdaQuery(PurchaseOrder.class)
                  .eq(PurchaseOrder::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
                  .eq(PurchaseOrder::getOrderPlace, PlaceEnum.CONSTRUCTION_SITE.getType())
                  .eq(PurchaseOrder::getPurchaseType, PurchaseEnum.MATERIAL.getType())
                  .eq(PurchaseOrder::getProjectIds, String.valueOf(projectId))
                  .eq(PurchaseOrder::getBranchCompanyId, projectBranchCompanyLink.getBranchCompanyId())
            );
      }

      if (purchaseOrderList.isEmpty()) {
         return Collections.emptyList();
      }

      List<SupplierPayment> supplierPaymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .in(SupplierPayment::getOrderId, purchaseOrderList.stream().map(PurchaseOrder::getId).collect(Collectors.toList()))
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType())
         );
      if (!boolTaxIncluded) {
         Map<Long, BigDecimal> orderIdTaxRateMap = purchaseOrderList.stream().collect(Collectors.toMap(PurchaseOrder::getId, PurchaseOrder::getTaxRate));
         supplierPaymentList.forEach(
            sp -> {
               BigDecimal taxRate = orderIdTaxRateMap.get(sp.getOrderId());
               if (taxRate != null && taxRate.compareTo(BigDecimal.ZERO) != 0) {
                  BigDecimal divide = sp.getActuallyPaymentAmount()
                     .multiply(BigDecimal.valueOf(100L))
                     .divide(BigDecimal.valueOf(100L).add(taxRate), 2, RoundingMode.HALF_UP);
                  sp.setActuallyPaymentAmount(divide);
               }
            }
         );
      }

      return supplierPaymentList;
   }

   private CostSummaryDTO getMaterialSentDirectlySiteCost(List<LocalDate> yearMonthDateList, List<SupplierPayment> supplierPaymentList) {
      Map<String, BigDecimal> yearMonthPaymentAmountMap = supplierPaymentList.stream()
         .collect(
            Collectors.groupingBy(
               s -> s.getPaymentDate().format(DateTimeFormatter.ofPattern("yy-MM")),
               Collectors.reducing(BigDecimal.ZERO, SupplierPayment::getActuallyPaymentAmount, BigDecimal::add)
            )
         );
      List<CostSummaryValueDTO> costSummaryValueDtoList = new ArrayList<>(yearMonthDateList.size());
      yearMonthDateList.forEach(
         yearMonthDate -> {
            String yearMonth = yearMonthDate.format(DateTimeFormatter.ofPattern("yy-MM"));
            CostSummaryValueDTO dto = CostSummaryValueDTO.builder()
               .yearMonth(yearMonth)
               .costMonthTotal(yearMonthPaymentAmountMap.getOrDefault(yearMonth, BigDecimal.ZERO))
               .build();
            costSummaryValueDtoList.add(dto);
         }
      );
      BigDecimal reduce = costSummaryValueDtoList.stream().map(CostSummaryValueDTO::getCostMonthTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
      return CostSummaryDTO.builder().indexNumber(31).indexName("3.1").name("材料成本").costSummaryValueDTO(costSummaryValueDtoList).total(reduce).build();
   }

   private CostSummaryDTO getTempWorkAmortizationCostFee(Long projectId, List<LocalDate> yearMonthDateList) {
      List<CostSummaryValueDTO> valueDTOs = this.manufactureCostMapper.tempWorkAmortizationList(projectId, yearMonthDateList).stream().map(i -> {
         CostSummaryValueDTO valueDTO = new CostSummaryValueDTO();
         valueDTO.setYearMonth(i.getYearMonth());
         valueDTO.setCostMonthTotal(i.getAmortizationAmount());
         if (valueDTO.getCostMonthTotal() != null) {
            valueDTO.setCostMonthTotal(valueDTO.getCostMonthTotal().setScale(0, RoundingMode.HALF_UP));
         }

         return valueDTO;
      }).collect(Collectors.toList());
      return CostSummaryDTO.builder().indexNumber(42).indexName("4.2").name("零工摊销成本").costSummaryValueDTO(valueDTOs).build();
   }

   private CostSummaryDTO getProductionLaborCostFee(Long projectId, List<LocalDate> yearMonthDateList) {
      List<ManufactureCostProductionLaborDTO> list = this.manufactureCostMapper.productionLaborCostList(projectId, yearMonthDateList);
      List<CostSummaryValueDTO> valueList = new ArrayList<>();
      list.stream()
         .collect(Collectors.groupingBy(ManufactureCostProductionLaborDTO::getYearMonth))
         .forEach(
            (yearMonth, values) -> {
               CostSummaryValueDTO value = new CostSummaryValueDTO();
               value.setYearMonth(yearMonth);
               BigDecimal costMonthTotal = values.stream()
                  .map(ManufactureCostProductionLaborDTO::getTotalAmount)
                  .filter(Objects::nonNull)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
                  .setScale(0, RoundingMode.HALF_UP);
               value.setCostMonthTotal(costMonthTotal);
               valueList.add(value);
            }
         );
      valueList.sort(Comparator.comparing(CostSummaryValueDTO::getYearMonth));
      return CostSummaryDTO.builder().indexNumber(41).indexName("4.1").name("生产人工成本").costSummaryValueDTO(valueList).build();
   }

   private CostSummaryDTO getManagerAmortizationFee(Long projectId, List<LocalDate> yearMonthDateList) {
      List<CostSummaryValueDTO> valueDTOs = this.manufactureCostMapper.managerAmortizationList(projectId, yearMonthDateList).stream().map(i -> {
         CostSummaryValueDTO valueDTO = new CostSummaryValueDTO();
         valueDTO.setYearMonth(i.getYearMonth());
         valueDTO.setCostMonthTotal(i.getAmortizationAmount());
         if (valueDTO.getCostMonthTotal() != null) {
            valueDTO.setCostMonthTotal(valueDTO.getCostMonthTotal().setScale(0, RoundingMode.HALF_UP));
         }

         return valueDTO;
      }).collect(Collectors.toList());
      return CostSummaryDTO.builder().indexNumber(43).indexName("4.3").name("管理人员摊销").costSummaryValueDTO(valueDTOs).build();
   }

   private CostSummaryDTO getTestingFee(Long projectId, List<LocalDate> yearMonthDateList) {
      List<CostSummaryValueDTO> valueDTOs = this.manufactureCostMapper.testingFeeList(projectId, yearMonthDateList).stream().map(i -> {
         CostSummaryValueDTO valueDTO = new CostSummaryValueDTO();
         valueDTO.setYearMonth(i.getYearMonth());
         valueDTO.setCostMonthTotal(i.getTotalFee());
         if (valueDTO.getCostMonthTotal() != null) {
            valueDTO.setCostMonthTotal(valueDTO.getCostMonthTotal().setScale(0, RoundingMode.HALF_UP));
         }

         return valueDTO;
      }).collect(Collectors.toList());
      return CostSummaryDTO.builder().indexNumber(101).indexName("10.1").name("检测费用").costSummaryValueDTO(valueDTOs).build();
   }

   private CostSummaryDTO getEquipmentDepreciation(Long projectId, List<LocalDate> yearMonthDateList) {
      List<CostSummaryValueDTO> valueDTOs = this.manufactureCostMapper.equipmentDepreciationList(projectId, yearMonthDateList).stream().map(i -> {
         if (i.getProportion() != null && i.getTotalFee() != null) {
            i.setAmortizationAmount(i.getTotalFee().multiply(i.getProportion()).setScale(0, RoundingMode.HALF_UP));
         }

         CostSummaryValueDTO valueDTO = new CostSummaryValueDTO();
         valueDTO.setYearMonth(i.getYearMonth());
         valueDTO.setCostMonthTotal(i.getAmortizationAmount());
         if (valueDTO.getCostMonthTotal() != null) {
            valueDTO.setCostMonthTotal(valueDTO.getCostMonthTotal().setScale(0, RoundingMode.HALF_UP));
         }

         return valueDTO;
      }).collect(Collectors.toList());
      return CostSummaryDTO.builder().indexNumber(92).indexName("9.2").name("设备折旧摊销").costSummaryValueDTO(valueDTOs).build();
   }

   private CostSummaryDTO getFactoryDepreciation(Long projectId, List<LocalDate> yearMonthDateList) {
      List<CostSummaryValueDTO> valueDTOs = this.manufactureCostMapper.factoryDepreciationList(projectId, yearMonthDateList).stream().map(i -> {
         if (i.getProportion() != null && i.getTotalFee() != null) {
            i.setAmortizationAmount(i.getTotalFee().multiply(i.getProportion()).setScale(0, RoundingMode.HALF_UP));
         }

         CostSummaryValueDTO valueDTO = new CostSummaryValueDTO();
         valueDTO.setYearMonth(i.getYearMonth());
         valueDTO.setCostMonthTotal(i.getAmortizationAmount());
         if (valueDTO.getCostMonthTotal() != null) {
            valueDTO.setCostMonthTotal(valueDTO.getCostMonthTotal().setScale(0, RoundingMode.HALF_UP));
         }

         return valueDTO;
      }).collect(Collectors.toList());
      return CostSummaryDTO.builder().indexNumber(91).indexName("9.1").name("厂房折旧摊销").costSummaryValueDTO(valueDTOs).build();
   }

   private CostSummaryDTO getAmortizationCost(Long projectId, List<LocalDate> yearMonthDateList) {
      List<CostSummaryValueDTO> valueDTOs = this.manufactureCostMapper.amortizationCostList(projectId, yearMonthDateList).stream().map(i -> {
         CostSummaryValueDTO valueDTO = new CostSummaryValueDTO();
         valueDTO.setYearMonth(i.getYearMonth());
         valueDTO.setCostMonthTotal(i.getAmortizationAmount());
         if (valueDTO.getCostMonthTotal() != null) {
            valueDTO.setCostMonthTotal(valueDTO.getCostMonthTotal().setScale(0, RoundingMode.HALF_UP));
         }

         return valueDTO;
      }).collect(Collectors.toList());
      return CostSummaryDTO.builder().indexNumber(82).indexName("8.2").name("摊销成本").costSummaryValueDTO(valueDTOs).build();
   }

   private CostSummaryDTO getDirectCost(Long projectId, List<LocalDate> yearMonthDateList) {
      List<CostSummaryValueDTO> valueDTOs = this.manufactureCostMapper.directCostList(projectId, yearMonthDateList).stream().map(i -> {
         CostSummaryValueDTO valueDTO = new CostSummaryValueDTO();
         valueDTO.setYearMonth(i.getYearMonth());
         valueDTO.setCostMonthTotal(i.getTotalFee());
         if (valueDTO.getCostMonthTotal() != null) {
            valueDTO.setCostMonthTotal(valueDTO.getCostMonthTotal().setScale(0, RoundingMode.HALF_UP));
         }

         return valueDTO;
      }).collect(Collectors.toList());
      return CostSummaryDTO.builder().indexNumber(81).indexName("8.1").name("直接成本").costSummaryValueDTO(valueDTOs).build();
   }

   private CostSummaryDTO getPropertyFee(Long projectId, List<LocalDate> yearMonthDateList) {
      List<Integer> typeList = Arrays.asList(WaterElectricityPropertyFeeTypeEnum.PROPERTY_FEE.getType());
      List<CostSummaryValueDTO> valueDTOs = this.manufactureCostMapper
         .waterElectricityPropertyAmortizationList(projectId, typeList, yearMonthDateList)
         .stream()
         .map(i -> {
            CostSummaryValueDTO valueDTO = new CostSummaryValueDTO();
            valueDTO.setYearMonth(i.getYearMonth());
            valueDTO.setCostMonthTotal(i.getAmortizationAmount());
            if (valueDTO.getCostMonthTotal() != null) {
               valueDTO.setCostMonthTotal(valueDTO.getCostMonthTotal().setScale(0, RoundingMode.HALF_UP));
            }

            return valueDTO;
         })
         .collect(Collectors.toList());
      return CostSummaryDTO.builder().indexNumber(73).indexName("7.3").name("物业费").costSummaryValueDTO(valueDTOs).build();
   }

   private CostSummaryDTO getWaterElectricFee(Long projectId, List<LocalDate> yearMonthDateList) {
      List<Integer> typeList = Arrays.asList(
         WaterElectricityPropertyFeeTypeEnum.WATER_FEE.getType(), WaterElectricityPropertyFeeTypeEnum.ELECTRICITY_FEE.getType()
      );
      List<CostSummaryValueDTO> valueDTOs = this.manufactureCostMapper
         .waterElectricityPropertyAmortizationList(projectId, typeList, yearMonthDateList)
         .stream()
         .map(i -> {
            CostSummaryValueDTO valueDTO = new CostSummaryValueDTO();
            valueDTO.setYearMonth(i.getYearMonth());
            valueDTO.setCostMonthTotal(i.getAmortizationAmount());
            if (valueDTO.getCostMonthTotal() != null) {
               valueDTO.setCostMonthTotal(valueDTO.getCostMonthTotal().setScale(0, RoundingMode.HALF_UP));
            }

            return valueDTO;
         })
         .collect(Collectors.toList());
      return CostSummaryDTO.builder().indexNumber(71).indexName("7.1").name("水电费摊销").costSummaryValueDTO(valueDTOs).build();
   }

   private CostSummaryDTO getReturnRepair(Long projectId, Boolean boolTaxIncluded, List<LocalDate> yearMonthDateList) {
      Map<String, BigDecimal> yearMonthAmountMap = this.returnProductMainService
         .list(
            Wrappers.lambdaQuery(ProjectReturnProductMain.class)
               .eq(ProjectReturnProductMain::getHandleMethod, HandleMethodEnum.REPAIR.getType())
               .eq(ProjectReturnProductMain::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(ProjectReturnProductMain::getProjectId, projectId)
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               s -> s.getCreateTime().format(DatePattern.NORM_MONTH_FORMATTER),
               Collectors.reducing(BigDecimal.ZERO, ProjectReturnProductMain::getFreight, BigDecimal::add)
            )
         );
      List<CostSummaryValueDTO> costSummaryValueList = yearMonthDateList.stream()
         .map(
            ym -> {
               String yearMonth = ym.format(DatePattern.NORM_MONTH_FORMATTER);
               return CostSummaryValueDTO.builder()
                  .yearMonth(yearMonth)
                  .costMonthTotal(yearMonthAmountMap.getOrDefault(yearMonth, BigDecimal.ZERO).setScale(0, RoundingMode.HALF_UP))
                  .build();
            }
         )
         .collect(Collectors.toList());
      return CostSummaryDTO.builder().costSummaryValueDTO(costSummaryValueList).name("回厂返修").indexName("6.1").indexNumber(61).build();
   }

   private CostSummaryDTO getReturnReuse(Long projectId, Boolean boolTaxIncluded, List<LocalDate> yearMonthDateList) {
      List<ProjectWasteProductChild> wasteChildList = this.wasteProductChildService
         .list(
            Wrappers.lambdaQuery(ProjectWasteProductChild.class)
               .eq(ProjectWasteProductChild::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(ProjectWasteProductChild::getWasteHandleMethod, WasteHandleMethodEnum.REUSE.getType())
               .eq(ProjectWasteProductChild::getUseProjectId, projectId)
         );
      Map<Long, ProjectReturnProductChild> returnChildMap = wasteChildList.isEmpty()
         ? Collections.emptyMap()
         : this.returnProductChildService
            .listByIds(wasteChildList.stream().map(ProjectWasteProductChild::getMesBuildingReturnWarehouseRecordId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(ProjectReturnProductChild::getId, Function.identity()));
      Map<String, BigDecimal> yearMonthReuseFeeMap = wasteChildList.stream()
         .collect(
            Collectors.groupingBy(
               w -> w.getCreateTime().format(DatePattern.NORM_MONTH_FORMATTER),
               Collectors.reducing(
                  BigDecimal.ZERO,
                  s -> {
                     ProjectReturnProductChild returnChild = returnChildMap.get(s.getMesBuildingReturnWarehouseRecordId());
                     return returnChild.getQuantity().compareTo(s.getQuantity()) == 0
                        ? returnChild.getTotalAmount()
                        : returnChild.getTotalAmount().multiply(s.getQuantity()).divide(returnChild.getQuantity(), 8, RoundingMode.HALF_UP);
                  },
                  BigDecimal::add
               )
            )
         );
      List<CostSummaryValueDTO> collect = yearMonthDateList.stream()
         .map(
            ym -> {
               String yearMonth = ym.format(DatePattern.NORM_MONTH_FORMATTER);
               return CostSummaryValueDTO.builder()
                  .yearMonth(yearMonth)
                  .costMonthTotal(yearMonthReuseFeeMap.getOrDefault(yearMonth, BigDecimal.ZERO).setScale(0, RoundingMode.HALF_UP))
                  .build();
            }
         )
         .collect(Collectors.toList());
      return CostSummaryDTO.builder().indexNumber(62).indexName("6.2").name("废品二次利用").costSummaryValueDTO(collect).build();
   }

   private Map<Long, BigDecimal> getProjectReturnCostMap(Collection<Long> projectIds, LocalDate secondEndDate) {
      Map<Long, BigDecimal> projectReturnCostMap = new HashMap<>(projectIds.size());
      Map<Long, BigDecimal> projectRepairFeeMap = this.returnProductMainService
         .list(
            Wrappers.lambdaQuery(ProjectReturnProductMain.class)
               .eq(ProjectReturnProductMain::getHandleMethod, HandleMethodEnum.REPAIR.getType())
               .eq(ProjectReturnProductMain::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .in(ProjectReturnProductMain::getProjectId, projectIds)
               .apply(secondEndDate != null, "DATE_FORMAT(create_time,'%Y%m') <= DATE_FORMAT({0},'%Y%m')", secondEndDate)
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               ProjectReturnProductMain::getProjectId, Collectors.reducing(BigDecimal.ZERO, ProjectReturnProductMain::getFreight, BigDecimal::add)
            )
         );
      List<ProjectWasteProductChild> wasteChildList = this.wasteProductChildService
         .list(Wrappers.lambdaQuery(ProjectWasteProductChild.class).eq(ProjectWasteProductChild::getAuditStatus, AuditStatusEnum.SUCCEED.getType()).and(w -> {
            LambdaQueryWrapper var10000 = w.in(ProjectWasteProductChild::getUseProjectId, projectIds)
               .or()
               .in(ProjectWasteProductChild::getProjectId, projectIds);
         }).apply(secondEndDate != null, "DATE_FORMAT(create_time,'%Y%m') <= DATE_FORMAT({0},'%Y%m')", secondEndDate));
      Set<Long> returnChildIds = wasteChildList.stream().map(ProjectWasteProductChild::getMesBuildingReturnWarehouseRecordId).collect(Collectors.toSet());
      Map<Long, ProjectReturnProductChild> returnChildMap = wasteChildList.isEmpty()
         ? Collections.emptyMap()
         : this.returnProductChildService.listByIds(returnChildIds).stream().collect(Collectors.toMap(ProjectReturnProductChild::getId, Function.identity()));
      Map<Long, BigDecimal> projectIdReuseCostMap = wasteChildList.stream()
         .filter(s -> s.getWasteHandleMethod().equals(WasteHandleMethodEnum.REUSE.getType()))
         .filter(s -> projectIds.contains(s.getUseProjectId()))
         .collect(
            Collectors.groupingBy(
               ProjectWasteProductChild::getUseProjectId,
               Collectors.reducing(
                  BigDecimal.ZERO,
                  wasteChild -> {
                     ProjectReturnProductChild returnChild = returnChildMap.get(wasteChild.getMesBuildingReturnWarehouseRecordId());
                     return returnChild.getQuantity().equals(wasteChild.getQuantity())
                        ? returnChild.getTotalAmount()
                        : returnChild.getTotalAmount().multiply(wasteChild.getQuantity()).divide(returnChild.getQuantity(), 8, RoundingMode.HALF_UP);
                  },
                  BigDecimal::add
               )
            )
         );
      Map<Long, BigDecimal> reduceProjectIdCostMap = wasteChildList.stream()
         .filter(s -> projectIds.contains(s.getProjectId()))
         .collect(
            Collectors.groupingBy(
               ProjectWasteProductChild::getProjectId,
               Collectors.reducing(
                  BigDecimal.ZERO,
                  wasteChild -> {
                     ProjectReturnProductChild returnChild = returnChildMap.get(wasteChild.getMesBuildingReturnWarehouseRecordId());
                     return returnChild.getQuantity().equals(wasteChild.getQuantity())
                        ? returnChild.getTotalAmount()
                        : returnChild.getTotalAmount().multiply(wasteChild.getQuantity()).divide(returnChild.getQuantity(), 8, RoundingMode.HALF_UP);
                  },
                  BigDecimal::add
               )
            )
         );
      projectIds.forEach(projectId -> {
         BigDecimal repairFee = projectRepairFeeMap.getOrDefault(projectId, BigDecimal.ZERO);
         BigDecimal reuseFee = projectIdReuseCostMap.getOrDefault(projectId, BigDecimal.ZERO);
         BigDecimal reduceFee = reduceProjectIdCostMap.getOrDefault(projectId, BigDecimal.ZERO);
         projectReturnCostMap.put(projectId, repairFee.add(reuseFee).subtract(reduceFee).setScale(2, RoundingMode.HALF_UP));
      });
      return projectReturnCostMap;
   }

   private CostSummaryDTO getFreight(Long projectId, Boolean boolTaxIncluded, List<LocalDate> yearMonthDateList) {
      List<CostTransportationDTO> transportationCost = this.manufactureCostMapper.transportationCost(null, null, projectId, boolTaxIncluded);
      Map<String, BigDecimal> collectMap = transportationCost.stream()
         .collect(Collectors.toMap(CostTransportationDTO::getYearMonth, CostTransportationDTO::getCostMonthTotal));
      List<CostSummaryValueDTO> valueDTOs = yearMonthDateList.stream()
         .map(
            yearMonth -> {
               String format = yearMonth.format(DatePattern.NORM_MONTH_FORMATTER);
               return CostSummaryValueDTO.builder()
                  .yearMonth(format)
                  .costMonthTotal(collectMap.getOrDefault(format, BigDecimal.ZERO).setScale(0, RoundingMode.HALF_UP))
                  .build();
            }
         )
         .collect(Collectors.toList());
      return CostSummaryDTO.builder().costSummaryValueDTO(valueDTOs).name("运输费").indexName("5.1").indexNumber(51).build();
   }

   private CostSummaryDTO finishedProductScrapLoss(Long projectId, List<LocalDate> yearMonthDateList) {
      List<CostSummaryValueDTO> valueDTOs = this.manufactureCostMapper.finishedProductScrapLossSummary(projectId, yearMonthDateList);
      return CostSummaryDTO.builder().costSummaryValueDTO(valueDTOs).name("制成品报废损失").indexName("10.2").indexNumber(102).build();
   }

   private CostSummaryDTO getStructuralProduct(Long projectId, List<LocalDate> yearMonthDateList) {
      List<CostSummaryValueDTO> structuralProductCostSummaryValueDTOS = this.manufactureCostMapper.structuralProductOutput(projectId, yearMonthDateList);
      BigDecimal total = this.getOutputTotal(structuralProductCostSummaryValueDTOS);
      return CostSummaryDTO.builder()
         .costSummaryValueDTO(structuralProductCostSummaryValueDTOS)
         .name("结构制品（吨）")
         .indexName("产量")
         .indexNumber(2)
         .total(total)
         .build();
   }

   private CostSummaryDTO getFirst(List<LocalDate> yearMonthDateList) {
      List<CostSummaryValueDTO> valueDTOS = yearMonthDateList.stream().map(e -> {
         String yearMonth = e.format(DateTimeFormatter.ofPattern("yyyy-MM"));
         CostSummaryValueDTO valueDTO = new CostSummaryValueDTO();
         valueDTO.setYearMonth(yearMonth);
         return valueDTO;
      }).collect(Collectors.toList());
      return CostSummaryDTO.builder().indexNumber(1).costSummaryValueDTO(valueDTOS).build();
   }

   private BigDecimal getTotal(List<CostSummaryValueDTO> valueDTOList) {
      return valueDTOList.stream().map(CostSummaryValueDTO::getCostMonthTotal).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   private BigDecimal getOutputTotal(List<CostSummaryValueDTO> valueDTOList) {
      return valueDTOList.stream().map(CostSummaryValueDTO::getProductMonthOutput).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Override
   public void costSummaryExport(HttpServletResponse response, Long projectId, Boolean boolTaxIncluded) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(project), "项目不存在");
      List<CostSummaryDTO> costSummaryDTOList = this.costSummary(projectId, boolTaxIncluded);
      List<List<String>> headList = new ArrayList<>();
      String title = project.getSerialNumber() + "_" + project.getName();
      CostSummaryDTO first = costSummaryDTOList.get(0);
      headList.add(Arrays.asList(title, "序号"));
      headList.add(Arrays.asList(title, "类别"));
      if (CollUtil.isNotEmpty(first.getCostSummaryValueDTO())) {
         first.getCostSummaryValueDTO().stream().map(CostSummaryValueDTO::getYearMonth).forEach(yearMonth -> headList.add(Arrays.asList(title, yearMonth)));
      }

      headList.add(Arrays.asList(title, "合计"));
      headList.add(Arrays.asList(title, "分项展示"));
      headList.add(Arrays.asList(title, "成本占比"));
      List<List<Object>> dataList = new ArrayList<>();
      costSummaryDTOList.stream()
         .filter(ex -> costSummaryDTOList.indexOf(ex) > 0)
         .forEach(
            ex -> {
               List<Object> data = new ArrayList<>();
               data.add(ex.getIndexName());
               data.add(ex.getName());
               Map<String, CostSummaryValueDTO> valueMap;
               if (CollUtil.isNotEmpty(ex.getCostSummaryValueDTO())) {
                  valueMap = ex.getCostSummaryValueDTO().stream().collect(Collectors.toMap(CostSummaryValueDTO::getYearMonth, Function.identity()));
               } else {
                  valueMap = new HashMap<>();
               }

               first.getCostSummaryValueDTO().forEach(yearMonth -> {
                  CostSummaryValueDTO value = valueMap.getOrDefault(yearMonth.getYearMonth(), new CostSummaryValueDTO());
                  if (costSummaryDTOList.indexOf(ex) == 1) {
                     data.add(value.getProductMonthOutput() == null ? "-" : value.getProductMonthOutput());
                  } else {
                     data.add(value.getCostMonthTotal() == null ? "-" : value.getCostMonthTotal());
                  }
               });
               Object total = ex.getTotal() == null ? "-" : ex.getTotal().setScale(0, RoundingMode.HALF_UP);
               Object subItemDisplay = ex.getSubItemDisplay() == null
                  ? "-"
                  : ex.getSubItemDisplay().multiply(BigDecimal.valueOf(100L)).setScale(2, RoundingMode.HALF_UP) + "%";
               Object costProportion = ex.getCostProportion() == null
                  ? "-"
                  : ex.getCostProportion().multiply(BigDecimal.valueOf(100L)).setScale(2, RoundingMode.HALF_UP) + "%";
               data.add(total);
               data.add(subItemDisplay);
               data.add(costProportion);
               dataList.add(data);
            }
         );

      try {
         response.reset();
         response.setContentType("application/vnd.ms-excel;charset=utf-8");
         String fileName = StrUtil.concat(true, "成本汇总表.xlsx");
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
               }
            }))
            .sheet("成本汇总表")
            .doWrite(dataList);
      } catch (Exception e) {
         throw new RuntimeException(e.getMessage());
      }
   }

   private String getYearMonthBetweenDates(String startDate, String endDate) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      LocalDate start = LocalDate.parse(startDate, formatter);
      LocalDate end = LocalDate.parse(endDate, formatter);
      List<String> yearMonths = new ArrayList<>();

      for (LocalDate tempDate = start; !tempDate.isAfter(end); tempDate = tempDate.plusMonths(1L)) {
         String yearMonth = tempDate.format(DateTimeFormatter.ofPattern("yyyy-MM"));
         yearMonths.add(yearMonth);
      }

      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("SELECT '").append(yearMonths.get(0)).append("' AS yearMonth ");
      yearMonths.remove(0);
      yearMonths.forEach(yearMonth -> stringBuilder.append("UNION ALL SELECT '").append(yearMonth).append("'"));
      return stringBuilder.toString();
   }

   @Override
   public List<CostNonMainBusinessIncomeDTO> nonMainBusinessIncome(Date createTimeStartDate, Date createTimeEndDate, Long projectId) {
      List<CostNonMainBusinessIncomeDTO> costNonMainBusinessIncomeDTOList = new ArrayList<>();
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      List<ManufactureCostAmortizationDTO> auxiliaryMaterialsAmortizationCostList = this.manufactureCostMapper
         .getTotalYieldAndProjectYield(projectId, yearMonthDateList);
      if (CollectionUtils.isNotEmpty(auxiliaryMaterialsAmortizationCostList)) {
         auxiliaryMaterialsAmortizationCostList.forEach(e -> {
            CostNonMainBusinessIncomeDTO costNonMainBusinessIncomeDTO = new CostNonMainBusinessIncomeDTO();
            costNonMainBusinessIncomeDTO.setYearMonth(e.getYearMonth());
            costNonMainBusinessIncomeDTO.setTotalOutput(e.getTotalYield().setScale(3, 4));
            costNonMainBusinessIncomeDTO.setProjectOutput(e.getProjectYield().setScale(3, 4));
            costNonMainBusinessIncomeDTOList.add(costNonMainBusinessIncomeDTO);
         });
      }

      Long sysBranchCompanyByProjectId = this.manufactureCostMapper.getsysBranchCompanyByProjectId(projectId);
      costNonMainBusinessIncomeDTOList.forEach(
         e -> {
            BigDecimal totalOutput = e.getTotalOutput();
            CostNonMainBusinessIncomeDTO costNonMainBusinessIncomeDTOProject = this.manufactureCostMapper
               .nonMainBusinessIncomeProject(e.getYearMonth(), projectId);
            BigDecimal projectOutput = costNonMainBusinessIncomeDTOProject.getProjectOutput();
            if (projectOutput.compareTo(BigDecimal.ZERO) != 0) {
               e.setProjectOutputRatio(projectOutput.multiply(BigDecimal.valueOf(100L)).divide(totalOutput, 2, 4));
            } else {
               e.setProjectOutputRatio(BigDecimal.ZERO);
            }

            e.setProjectOutput(costNonMainBusinessIncomeDTOProject.getProjectOutput());
            YearMonth yearMonth = YearMonth.parse(this.getNextYearMonthDate(e.getYearMonth()));
            LocalDateTime firstDayOfMonth = yearMonth.atDay(1).atStartOfDay();
            LocalDateTime lastDayOfMonth = yearMonth.atEndOfMonth().atTime(LocalTime.MAX);
            List<BasicClassMeteAndAmountDTO> basicClassMeteAndAmountDTOList = this.wasteSaleBiz
               .getAmountByMonth(sysBranchCompanyByProjectId, firstDayOfMonth, lastDayOfMonth);
            if (CollUtil.isNotEmpty(basicClassMeteAndAmountDTOList)) {
               e.setWasteSale(basicClassMeteAndAmountDTOList.get(0).getAmount().setScale(2, 4));
            } else {
               e.setWasteSale(BigDecimal.ZERO);
            }

            if (CollUtil.isNotEmpty(basicClassMeteAndAmountDTOList) && e.getProjectOutput().compareTo(BigDecimal.ZERO) != 0) {
               e.setAmortizationAmount(e.getWasteSale().multiply(e.getProjectOutputRatio()).divide(new BigDecimal(100), 2, 4));
            } else {
               e.setAmortizationAmount(BigDecimal.ZERO);
            }
         }
      );
      return costNonMainBusinessIncomeDTOList;
   }

   private String getNextYearMonthDate(String chineseDateStr) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      LocalDate chineseDate = LocalDate.parse(chineseDateStr + "-01", formatter);
      LocalDate previousMonth = chineseDate.minusMonths(1L);
      return previousMonth.format(formatter).substring(0, 7);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> nonMainBusinessIncomePrint(
      Date createTimeStartDate, Date createTimeEndDate, Long projectId, Boolean boolTaxIncluded
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      List<ManufactureCostAmortizationDTO> auxiliaryMaterialsAmortizationCostList = this.manufactureCostMapper
         .getTotalYieldAndProjectYield(projectId, yearMonthDateList);
      List<CostNonMainBusinessIncomeDTO> costNonMainBusinessIncomeDTOList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(auxiliaryMaterialsAmortizationCostList)) {
         auxiliaryMaterialsAmortizationCostList.forEach(e -> {
            CostNonMainBusinessIncomeDTO costNonMainBusinessIncomeDTO = new CostNonMainBusinessIncomeDTO();
            costNonMainBusinessIncomeDTO.setYearMonth(e.getYearMonth());
            costNonMainBusinessIncomeDTO.setTotalOutput(e.getTotalYield().setScale(3, 4));
            costNonMainBusinessIncomeDTO.setProjectOutput(e.getProjectYield().setScale(3, 4));
            costNonMainBusinessIncomeDTOList.add(costNonMainBusinessIncomeDTO);
         });
      }

      Long sysBranchCompanyByProjectId = this.manufactureCostMapper.getsysBranchCompanyByProjectId(projectId);
      costNonMainBusinessIncomeDTOList.forEach(
         e -> {
            BigDecimal totalOutput = e.getTotalOutput();
            CostNonMainBusinessIncomeDTO costNonMainBusinessIncomeDTOProject = this.manufactureCostMapper
               .nonMainBusinessIncomeProject(e.getYearMonth(), projectId);
            BigDecimal projectOutput = costNonMainBusinessIncomeDTOProject.getProjectOutput();
            if (projectOutput.compareTo(BigDecimal.ZERO) != 0) {
               e.setProjectOutputRatio(projectOutput.multiply(BigDecimal.valueOf(100L)).divide(totalOutput, 2, 4));
            } else {
               e.setProjectOutputRatio(BigDecimal.ZERO);
            }

            e.setProjectOutput(costNonMainBusinessIncomeDTOProject.getProjectOutput());
            YearMonth yearMonth = YearMonth.parse(this.getNextYearMonthDate(e.getYearMonth()));
            LocalDateTime firstDayOfMonth = yearMonth.atDay(1).atStartOfDay();
            LocalDateTime lastDayOfMonth = yearMonth.atEndOfMonth().atTime(LocalTime.MAX);
            List<BasicClassMeteAndAmountDTO> basicClassMeteAndAmountDTOList = this.wasteSaleBiz
               .getAmountByMonth(sysBranchCompanyByProjectId, firstDayOfMonth, lastDayOfMonth);
            if (CollUtil.isNotEmpty(basicClassMeteAndAmountDTOList)) {
               e.setWasteSale(basicClassMeteAndAmountDTOList.get(0).getAmount().setScale(2, 4));
            } else {
               e.setWasteSale(BigDecimal.ZERO);
            }

            if (CollUtil.isNotEmpty(basicClassMeteAndAmountDTOList) && e.getProjectOutput().compareTo(BigDecimal.ZERO) != 0) {
               e.setAmortizationAmount(e.getWasteSale().multiply(e.getProjectOutputRatio()).divide(new BigDecimal(100), 2, 4));
            } else {
               e.setAmortizationAmount(BigDecimal.ZERO);
            }
         }
      );
      List<Map<String, Object>> mapList = costNonMainBusinessIncomeDTOList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "非主营业务收入");
      this.setPrintHeader(header, boolTaxIncluded, projectId);
      printVO.setHeader(header);
      header.put(
         "statisticalDate",
         CollUtil.getFirst(costNonMainBusinessIncomeDTOList).getYearMonth() + " ～ " + CollUtil.getLast(costNonMainBusinessIncomeDTOList).getYearMonth()
      );
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<CostMainBusinessIncomeDTO> mainBusinessIncome(Date createTimeStartDate, Date createTimeEndDate, Long projectId) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      List<CostMainBusinessIncomeDTO> costMainBusinessIncomeDTOS = this.manufactureCostMapper
         .mainBusinessIncome(createTimeStartDate, createTimeEndDate, projectId);
      Map<String, BigDecimal> secondCollectionAmountAll = this.getSecondCollectionAmountAll(projectId);

      for (Entry<String, BigDecimal> entry : secondCollectionAmountAll.entrySet()) {
         String yearMonth = entry.getKey();
         BigDecimal income = entry.getValue();
         Optional<CostMainBusinessIncomeDTO> existingDTO = costMainBusinessIncomeDTOS.stream().filter(dto -> dto.getYearMonth().equals(yearMonth)).findFirst();
         if (existingDTO.isPresent()) {
            existingDTO.get().setIncome(income);
         } else {
            CostMainBusinessIncomeDTO newDTO = new CostMainBusinessIncomeDTO();
            newDTO.setYearMonth(yearMonth);
            newDTO.setIncome(income);
            costMainBusinessIncomeDTOS.add(newDTO);
         }
      }

      List<CostMainBusinessIncomeDTO> costMainBusinessIncomeDTOSortedList = costMainBusinessIncomeDTOS.stream()
         .sorted(Comparator.comparing(CostMainBusinessIncomeDTO::getYearMonth))
         .collect(Collectors.toList());
      BigDecimal totalAmount = BigDecimal.ZERO;
      BigDecimal totalIncome = BigDecimal.ZERO;
      BigDecimal totalAdvancePayment = BigDecimal.ZERO;
      List<Long> projectIds = new ArrayList<>();
      projectIds.add(projectId);
      Map<String, BigDecimal> projectShipAmountMapMonth = this.getProjectYearMonthShipAmount(projectId);
      costMainBusinessIncomeDTOSortedList.forEach(e -> {
         String yearMonthString = e.getYearMonth();
         Map<Long, BigDecimal> secondCollectionAmountMap = this.getSecondCollectionAmountMap(projectIds, yearMonthString);
         e.setIncome(secondCollectionAmountMap.getOrDefault(projectId, BigDecimal.ZERO));
         YearMonth yearMonth = YearMonth.parse(yearMonthString);
         LocalDate firstDay = yearMonth.atDay(1);
         LocalDate lastDay = yearMonth.atEndOfMonth();
         LocalDateTime startDateTime = firstDay.atStartOfDay();
         LocalDateTime endDateTime = lastDay.atTime(23, 59, 59);
         CostShipAmountDTO costShipAmountDTO = this.businessBiz.getProjectCostShipAmountDTOMonth(projectIds, startDateTime, endDateTime);
         e.setTotalOutputArtifact(costShipAmountDTO.getTotalOutputArtifact());
         e.setTotalOutputEnclosure(costShipAmountDTO.getTotalOutputEnclosure());
         e.setTotalOutputStandard(costShipAmountDTO.getTotalOutputStandard());
         e.setTotalAmount(projectShipAmountMapMonth.getOrDefault(e.getYearMonth(), BigDecimal.ZERO));
         e.setVisaFee(BigDecimal.ZERO);
         e.setAdvancePayment(e.getIncome().subtract(e.getTotalAmount()));
      });
      return costMainBusinessIncomeDTOS;
   }

   private Map<String, BigDecimal> getProjectYearMonthShipAmount(Long projectId) {
      List<MesBuildingCargoList> cargoListList = this.cargoListService
         .list(
            Wrappers.lambdaQuery(MesBuildingCargoList.class)
               .eq(MesBuildingCargoList::getDeliveryStatus, ShipmentStatusEnum.DELIVERY.getType())
               .eq(MesBuildingCargoList::getProjectId, projectId)
               .in(MesBuildingCargoList::getStatus, CargoListStatusEnum.SHIPMENT.getType(), CargoListStatusEnum.RECEIPT.getType())
         );
      if (cargoListList.isEmpty()) {
         return Collections.emptyMap();
      }

      List<Long> cargoListIds = cargoListList.stream().map(MesBuildingCargoList::getId).collect(Collectors.toList());
      List<MesBuildingCargoListProductLink> cargoListProductLinkList = this.cargoListProductLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingCargoListProductLink.class)
               .in(MesBuildingCargoListProductLink::getCargoListId, cargoListIds)
               .ne(MesBuildingCargoListProductLink::getWarehouseType, WarehouseTypeProductReturnEnum.REPAIR.getType())
         );
      Map<Long, String> cargoListProductLinkIdYearMonthMap = cargoListProductLinkList.stream()
         .collect(Collectors.toMap(MesBuildingCargoListProductLink::getId, MesBuildingCargoListProductLink::getInYearMonthDate));
      List<CargoListProductLinkPriceDTO> productLinkPriceDTOList = this.businessPriceUtils.getCargoLinkPrice(cargoListProductLinkList);
      return productLinkPriceDTOList.stream()
         .filter(link -> Objects.nonNull(link.getTotalPrice()))
         .collect(
            Collectors.groupingBy(
               link -> cargoListProductLinkIdYearMonthMap.get(link.getId()),
               Collectors.reducing(BigDecimal.ZERO, CargoListProductLinkPriceDTO::getTotalPrice, BigDecimal::add)
            )
         );
   }

   @Override
   public PrintVO<List<Map<String, Object>>> mainBusinessIncomePrint(Date createTimeStartDate, Date createTimeEndDate, Long projectId, Boolean boolTaxIncluded) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<CostMainBusinessIncomeDTO> costMainBusinessIncomeDTOS = this.manufactureCostMapper
         .mainBusinessIncome(createTimeStartDate, createTimeEndDate, projectId);
      Map<String, BigDecimal> secondCollectionAmountAll = this.getSecondCollectionAmountAll(projectId);

      for (Entry<String, BigDecimal> entry : secondCollectionAmountAll.entrySet()) {
         String yearMonth = entry.getKey();
         BigDecimal income = entry.getValue();
         Optional<CostMainBusinessIncomeDTO> existingDTO = costMainBusinessIncomeDTOS.stream().filter(dto -> dto.getYearMonth().equals(yearMonth)).findFirst();
         if (existingDTO.isPresent()) {
            existingDTO.get().setIncome(income);
         } else {
            CostMainBusinessIncomeDTO newDTO = new CostMainBusinessIncomeDTO();
            newDTO.setYearMonth(yearMonth);
            newDTO.setIncome(income);
            costMainBusinessIncomeDTOS.add(newDTO);
         }
      }

      List<CostMainBusinessIncomeDTO> costMainBusinessIncomeDTOSortedList = costMainBusinessIncomeDTOS.stream()
         .sorted(Comparator.comparing(CostMainBusinessIncomeDTO::getYearMonth))
         .collect(Collectors.toList());
      BigDecimal totalAmount = BigDecimal.ZERO;
      BigDecimal totalIncome = BigDecimal.ZERO;
      BigDecimal totalAdvancePayment = BigDecimal.ZERO;
      Map<String, BigDecimal> projectShipAmountMapMonth = this.getProjectYearMonthShipAmount(projectId);
      costMainBusinessIncomeDTOSortedList.forEach(e -> {
         String yearMonthString = e.getYearMonth();
         List<Long> projectIds = new ArrayList<>();
         projectIds.add(projectId);
         Map<Long, BigDecimal> secondCollectionAmountMap = this.getSecondCollectionAmountMap(projectIds, yearMonthString);
         e.setIncome(secondCollectionAmountMap.getOrDefault(projectId, BigDecimal.ZERO));
         YearMonth yearMonth = YearMonth.parse(yearMonthString);
         LocalDate firstDay = yearMonth.atDay(1);
         LocalDate lastDay = yearMonth.atEndOfMonth();
         LocalDateTime startDateTime = firstDay.atStartOfDay();
         LocalDateTime endDateTime = lastDay.atTime(23, 59, 59);
         CostShipAmountDTO costShipAmountDTO = this.businessBiz.getProjectCostShipAmountDTOMonth(projectIds, startDateTime, endDateTime);
         e.setTotalOutputArtifact(costShipAmountDTO.getTotalOutputArtifact());
         e.setTotalOutputEnclosure(costShipAmountDTO.getTotalOutputEnclosure());
         e.setTotalOutputStandard(costShipAmountDTO.getTotalOutputStandard());
         e.setTotalAmount(projectShipAmountMapMonth.getOrDefault(e.getYearMonth(), BigDecimal.ZERO));
         e.setVisaFee(BigDecimal.ZERO);
         e.setAdvancePayment(e.getIncome().subtract(e.getTotalAmount()));
      });
      List<Map<String, Object>> mapList = costMainBusinessIncomeDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "主营业务收入");
      this.setPrintHeader(header, boolTaxIncluded, projectId);
      printVO.setHeader(header);
      if (CollUtil.isNotEmpty(costMainBusinessIncomeDTOS)) {
         header.put(
            "statisticalDate",
            CollUtil.getFirst(costMainBusinessIncomeDTOS).getYearMonth() + " ～ " + CollUtil.getLast(costMainBusinessIncomeDTOS).getYearMonth()
         );
      }

      return printVO;
   }

   private void setPrintHeader(Map<String, Object> header, Boolean boolTaxIncluded, Long projectId) {
      List<ManufactureCostDTO> manufactureCostDTOList = new ArrayList<>();
      manufactureCostDTOList = this.getManufactureCostDTOS(boolTaxIncluded, manufactureCostDTOList);
      ManufactureCostDTO manufactureCostDTO = manufactureCostDTOList.stream().filter(m -> m.getProjectId().equals(projectId)).findFirst().orElse(null);
      if (manufactureCostDTO != null) {
         header.put("createTime", manufactureCostDTO.getCreateTime());
         header.put("project", manufactureCostDTO.getSerialNumber() + "-" + manufactureCostDTO.getProjectName());
         header.put("projectStatus", ProjectStatusEnum.getNameByType(manufactureCostDTO.getStatus()));
         header.put("nonMainBusinessIncome", manufactureCostDTO.getNonMainBusinessIncome());
         header.put("mainBusinessIncome", manufactureCostDTO.getMainBusinessIncome());
         header.put("incomeTotal", manufactureCostDTO.getIncomeTotal());
         header.put("cumulativeCost", manufactureCostDTO.getCumulativeCost());
         header.put("grossProfit", manufactureCostDTO.getGrossProfit());
         header.put("grossProfitRate", manufactureCostDTO.getGrossProfitRate());
      } else {
         ContractProject project = this.projectService.getById(projectId);
         Preconditions.checkArgument(project != null, "项目不存在!");
         header.put("createTime", project.getCreateTime().toLocalDate());
         header.put("project", project.getSerialNumber() + "-" + project.getShortName());
         header.put("projectStatus", ProjectStatusEnum.getNameByType(project.getStatus()));
         header.put("nonMainBusinessIncome", BigDecimal.ZERO);
         header.put("mainBusinessIncome", BigDecimal.ZERO);
         header.put("incomeTotal", BigDecimal.ZERO);
         header.put("cumulativeCost", BigDecimal.ZERO);
         header.put("grossProfit", BigDecimal.ZERO);
         header.put("grossProfitRate", BigDecimal.ZERO);
      }
   }

   @Override
   public List<CostFinishedProductScrapLossDTO> finishedProductScrapLoss(Date createTimeStartDate, Date createTimeEndDate, Long projectId) {
      return this.manufactureCostMapper.finishedProductScrapLoss(createTimeStartDate, createTimeEndDate, projectId);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> finishedProductScrapLossPrint(Date createTimeStartDate, Date createTimeEndDate, Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<CostFinishedProductScrapLossDTO> dtoList = this.manufactureCostMapper.finishedProductScrapLoss(createTimeStartDate, createTimeEndDate, projectId);
      List<Map<String, Object>> mapList = dtoList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "制成品报废损失");
      if (CollectionUtils.isNotEmpty(dtoList)) {
         header.put("statisticalDate", CollUtil.getFirst(dtoList).getYearMonth() + " ～ " + CollUtil.getLast(dtoList).getYearMonth());
      }

      header.put("project", project.getSerialNumber() + "-" + project.getShortName());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<CostTransportationDTO> transportationCost(Date createTimeStartDate, Date createTimeEndDate, Long projectId, Boolean boolTaxIncluded) {
      return this.manufactureCostMapper.transportationCost(createTimeStartDate, createTimeEndDate, projectId, boolTaxIncluded);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> transportationCostPrint(Date createTimeStartDate, Date createTimeEndDate, Long projectId, Boolean boolTaxIncluded) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      List<CostTransportationDTO> dtoList = this.manufactureCostMapper.transportationCost(createTimeStartDate, createTimeEndDate, projectId, boolTaxIncluded);
      List<Map<String, Object>> mapList = dtoList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      if (CollectionUtils.isNotEmpty(dtoList)) {
         header.put("statisticalDate", CollUtil.getFirst(dtoList).getYearMonth() + " ～ " + CollUtil.getLast(dtoList).getYearMonth());
      }

      header.put("title", "运输费");
      header.put("project", project.getSerialNumber() + "-" + project.getShortName());
      printVO.setHeader(header);
      return printVO;
   }

   @Override
   public List<ManufactureCostAmortizationDTO> waterElectricityPropertyAmortization(Long projectId, List<Integer> typeList) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      return this.manufactureCostMapper.waterElectricityPropertyAmortizationList(projectId, typeList, yearMonthDateList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> waterElectricityPropertyAmortizationPrint(Long projectId, List<Integer> typeList) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<ManufactureCostAmortizationDTO> dtoList = this.waterElectricityPropertyAmortization(projectId, typeList);
      List<Map<String, Object>> mapList = dtoList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", WaterElectricityPropertyFeeTypeEnum.getWaterElectricityType().containsAll(typeList) ? "水电费" : "物业费");
      header.put("statisticalDate", CollUtil.getFirst(dtoList).getYearMonth() + " ～ " + CollUtil.getLast(dtoList).getYearMonth());
      header.put("project", project.getSerialNumber() + "-" + project.getShortName());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<ReimbursementCostDTO> directCost(Long projectId) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      return this.manufactureCostMapper.directCostList(projectId, yearMonthDateList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> directCostPrint(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<ReimbursementCostDTO> dtoList = this.directCost(projectId);
      List<Map<String, Object>> mapList = dtoList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "期间直接成本费用");
      header.put("statisticalDate", CollUtil.getFirst(dtoList).getYearMonth() + " ～ " + CollUtil.getLast(dtoList).getYearMonth());
      header.put("project", project.getSerialNumber() + "-" + project.getShortName());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<ReimbursementCostDTO> amortizationCost(Long projectId) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      return this.manufactureCostMapper.amortizationCostList(projectId, yearMonthDateList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> amortizationCostPrint(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<ReimbursementCostDTO> dtoList = this.amortizationCost(projectId);
      List<Map<String, Object>> mapList = dtoList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "期间摊销成本费用");
      header.put("statisticalDate", CollUtil.getFirst(dtoList).getYearMonth() + " ～ " + CollUtil.getLast(dtoList).getYearMonth());
      header.put("project", project.getSerialNumber() + "-" + project.getShortName());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<ManufactureCostAmortizationDTO> factoryDepreciation(Long projectId) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      List<ManufactureCostAmortizationDTO> dtoList = this.manufactureCostMapper.factoryDepreciationList(projectId, yearMonthDateList);
      if (CollUtil.isNotEmpty(dtoList)) {
         dtoList.forEach(e -> {
            if (e.getProportion() != null && e.getTotalFee() != null) {
               e.setAmortizationAmount(e.getTotalFee().multiply(e.getProportion()).setScale(2, RoundingMode.HALF_UP));
            }
         });
      }

      return dtoList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> factoryDepreciationPrint(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<ManufactureCostAmortizationDTO> dtoList = this.factoryDepreciation(projectId);
      List<Map<String, Object>> mapList = dtoList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "厂房折旧");
      header.put("statisticalDate", CollUtil.getFirst(dtoList).getYearMonth() + " ～ " + CollUtil.getLast(dtoList).getYearMonth());
      header.put("project", project.getSerialNumber() + "-" + project.getShortName());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<ManufactureCostAmortizationDTO> equipmentDepreciation(Long projectId) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      List<ManufactureCostAmortizationDTO> dtoList = this.manufactureCostMapper.equipmentDepreciationList(projectId, yearMonthDateList);
      if (CollUtil.isNotEmpty(dtoList)) {
         dtoList.forEach(e -> {
            if (e.getProportion() != null && e.getTotalFee() != null) {
               e.setAmortizationAmount(e.getTotalFee().multiply(e.getProportion()).setScale(2, RoundingMode.HALF_UP));
            }
         });
      }

      return dtoList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> equipmentDepreciationPrint(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<ManufactureCostAmortizationDTO> dtoList = this.equipmentDepreciation(projectId);
      List<Map<String, Object>> mapList = dtoList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "设备折旧");
      header.put("statisticalDate", CollUtil.getFirst(dtoList).getYearMonth() + " ～ " + CollUtil.getLast(dtoList).getYearMonth());
      header.put("project", project.getSerialNumber() + "-" + project.getShortName());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<ReimbursementCostDTO> testingFee(Long projectId) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      return this.manufactureCostMapper.testingFeeList(projectId, yearMonthDateList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> testingFeePrint(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<ReimbursementCostDTO> dtoList = this.testingFee(projectId);
      List<Map<String, Object>> mapList = dtoList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "检测费");
      header.put("statisticalDate", CollUtil.getFirst(dtoList).getYearMonth() + " ～ " + CollUtil.getLast(dtoList).getYearMonth());
      header.put("project", project.getSerialNumber() + "-" + project.getShortName());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<Map<String, List<CommonDetailsDO>>> mainMaterialsStatistics(Long projectId, Integer basicMaterialClassEnum) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      List<Map<String, List<CommonDetailsDO>>> resultList = new ArrayList<>();
      Map<String, List<CommonDetailsDO>> outboundDetailsDOGroup = this.moveOutboundDetailService
         .groupOutboundDetail(new ArrayList<>(Arrays.asList(basicMaterialClassEnum)), projectId, yearMonthDateList, null, null, null, null)
         .stream()
         .map(i -> BeanUtil.toBean(i, CommonDetailsDO.class))
         .collect(Collectors.groupingBy(CommonDetailsDO::getYearMonth));
      Map<String, List<CommonDetailsDO>> returnDetailsDOGroup = this.returnDetailService
         .groupReturnDetail(new ArrayList<>(Arrays.asList(basicMaterialClassEnum)), projectId, yearMonthDateList, null, null, null, null)
         .stream()
         .map(i -> BeanUtil.toBean(i, CommonDetailsDO.class))
         .collect(Collectors.groupingBy(CommonDetailsDO::getYearMonth));
      yearMonthDateList.forEach(i -> {
         String yearMonth = i.format(DatePattern.NORM_MONTH_FORMATTER);
         Map<String, List<CommonDetailsDO>> resultMap = new HashMap<>();
         List<CommonDetailsDO> outboundDetails = outboundDetailsDOGroup.get(yearMonth);
         List<CommonDetailsDO> returnDetails = returnDetailsDOGroup.get(yearMonth);
         if (CollUtil.isNotEmpty(outboundDetails) || CollUtil.isNotEmpty(returnDetails)) {
            resultMap.put("outboundList", outboundDetails);
            resultMap.put("returnList", returnDetails);
            resultList.add(resultMap);
         }
      });
      return resultList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> mainMaterialsStatisticsPrint(Long projectId, Integer basicMaterialClassEnum, Boolean boolTaxIncluded) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<Map<String, List<CommonDetailsDO>>> dtoList = this.mainMaterialsStatistics(projectId, basicMaterialClassEnum);
      List<CommonDetailsDO> resultList = dtoList.stream().map(i -> {
         List<CommonDetailsDO> allList = new ArrayList<>();
         List<CommonDetailsDO> outboundList = i.get("outboundList");
         if (CollUtil.isNotEmpty(outboundList)) {
            allList.addAll(outboundList);
         }

         List<CommonDetailsDO> returnList = i.get("returnList");
         if (CollUtil.isNotEmpty(returnList)) {
            returnList.forEach(r -> {
               if (r.getMeteCount() != null) {
                  r.setMeteCount(r.getMeteCount().negate());
               }

               if (r.getAmountCount() != null) {
                  r.setAmountCount(r.getAmountCount().negate());
               }

               if (r.getAmountExcludingVatCount() != null) {
                  r.setAmountExcludingVatCount(r.getAmountExcludingVatCount().negate());
               }
            });
            allList.addAll(returnList);
         }

         return allList;
      }).flatMap(Collection::stream).collect(Collectors.toList());
      List<Map<String, Object>> mapList = resultList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "主材统计");
      header.put("boolTaxIncluded", boolTaxIncluded);
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      header.put(
         "statisticalDate",
         CollUtil.getFirst(yearMonthDateList).format(DatePattern.NORM_MONTH_FORMATTER)
            + " ～ "
            + CollUtil.getLast(yearMonthDateList).format(DatePattern.NORM_MONTH_FORMATTER)
      );
      header.put("project", project.getSerialNumber() + "-" + project.getShortName());
      header.put("basicMaterialClassEnum", BasicClassEnum.getNameStr(basicMaterialClassEnum));
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<ManufactureCostAmortizationDTO> otherSteelMaterialsAmortization(Long projectId, Boolean boolTaxIncluded) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      List<ManufactureCostAmortizationDTO> auxiliaryMaterialsAmortizationCostList = this.manufactureCostMapper
         .getTotalYieldAndProjectYield(projectId, yearMonthDateList);
      List<CostSummaryValueDTO> auxiliaryMaterialAmortizationValueList = this.moveOutboundDetailService
         .getMeteByProjectId(
            new ArrayList<>(Arrays.asList(BasicClassEnum.OTHER_STEEL_MATERIALS.getType())), null, yearMonthDateList, null, null, null, null, boolTaxIncluded
         );
      Map<String, BigDecimal> auxiliaryMaterialAmortizationCostMonthTotalMap = auxiliaryMaterialAmortizationValueList.stream()
         .collect(Collectors.toMap(CostSummaryValueDTO::getYearMonth, v -> Optional.ofNullable(v.getCostMonthTotal()).orElse(BigDecimal.ZERO), BigDecimal::add));
      List<com.hzchum.scim.wms.core.api.pojo._do.wmsReport.CommonDetailsDO> outboundDetailsDOList = this.moveOutboundDetailService
         .groupOutboundDetail(new ArrayList<>(Arrays.asList(BasicClassEnum.OTHER_STEEL_MATERIALS.getType())), null, yearMonthDateList, null, null, null, null);
      Map<String, List<CommonDetailsDO>> outboundDetailsDOGroup = outboundDetailsDOList.stream()
         .map(i -> BeanUtil.toBean(i, CommonDetailsDO.class))
         .collect(Collectors.groupingBy(CommonDetailsDO::getYearMonth));
      List<com.hzchum.scim.wms.core.api.pojo._do.wmsReport.CommonDetailsDO> returnDetailsDOList = this.returnDetailService
         .groupReturnDetail(new ArrayList<>(Arrays.asList(BasicClassEnum.OTHER_STEEL_MATERIALS.getType())), null, yearMonthDateList, null, null, null, null);
      Map<String, List<CommonDetailsDO>> returnDetailsDOGroup = returnDetailsDOList.stream()
         .map(i -> BeanUtil.toBean(i, CommonDetailsDO.class))
         .collect(Collectors.groupingBy(CommonDetailsDO::getYearMonth));
      auxiliaryMaterialsAmortizationCostList.forEach(i -> {
         List<Map<String, List<CommonDetailsDO>>> auxiliaryMaterialDetailList = new ArrayList<>();
         BigDecimal costMonthTotalNow = auxiliaryMaterialAmortizationCostMonthTotalMap.getOrDefault(i.getYearMonth(), BigDecimal.ZERO);
         i.setTotalFee(costMonthTotalNow.setScale(2, RoundingMode.HALF_UP));
         if (i.getTotalYield().compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal proportion = i.getProjectYield().divide(i.getTotalYield(), 2, RoundingMode.HALF_UP);
            BigDecimal amortizationAmount = i.getTotalFee().multiply(proportion).setScale(2, RoundingMode.HALF_UP);
            i.setProportion(proportion);
            i.setAmortizationAmount(amortizationAmount);
         } else {
            i.setAmortizationAmount(BigDecimal.ZERO);
         }

         if (i.getProportion() == null) {
            i.setProportion(BigDecimal.ZERO);
         }

         Map<String, List<CommonDetailsDO>> auxiliaryMaterialDetail = new HashMap<>();
         List<CommonDetailsDO> outboundDetails = outboundDetailsDOGroup.get(i.getYearMonth());
         List<CommonDetailsDO> returnDetails = returnDetailsDOGroup.get(i.getYearMonth());
         if (CollUtil.isNotEmpty(outboundDetails) || CollUtil.isNotEmpty(returnDetails)) {
            auxiliaryMaterialDetail.put("outboundList", outboundDetails);
            auxiliaryMaterialDetail.put("returnList", returnDetails);
            auxiliaryMaterialDetailList.add(auxiliaryMaterialDetail);
         }

         i.setAuxiliaryMaterialDetailList(auxiliaryMaterialDetailList);
      });
      return auxiliaryMaterialsAmortizationCostList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> otherSteelMaterialsAmortizationPrint(Long projectId, Boolean boolTaxIncluded) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<ManufactureCostAmortizationDTO> dtoList = this.auxiliaryMaterialsAmortizationCost(projectId, boolTaxIncluded);
      List<Map<String, Object>> mapList = dtoList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "其它钢材摊销");
      header.put("statisticalDate", CollUtil.getFirst(dtoList).getYearMonth() + " ～ " + CollUtil.getLast(dtoList).getYearMonth());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<Map<String, List<CommonDetailsDO>>> auxiliaryMaterialsDirectCost(Long projectId) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      List<Map<String, List<CommonDetailsDO>>> resultList = new ArrayList<>();
      List<com.hzchum.scim.wms.core.api.pojo._do.wmsReport.CommonDetailsDO> outboundDetailsDOList = this.moveOutboundDetailService
         .groupOutboundDetail(
            new ArrayList<>(Arrays.asList(BasicClassEnum.GENERAL_MATERIAL.getType(), BasicClassEnum.OTHER.getType())),
            projectId,
            yearMonthDateList,
            null,
            null,
            Arrays.asList("油漆", "焊材", "焊接材料", "焊丝焊剂"),
            null
         );
      Map<String, List<CommonDetailsDO>> outboundDetailsDOGroup = outboundDetailsDOList.stream()
         .map(i -> BeanUtil.toBean(i, CommonDetailsDO.class))
         .collect(Collectors.groupingBy(CommonDetailsDO::getYearMonth));
      List<com.hzchum.scim.wms.core.api.pojo._do.wmsReport.CommonDetailsDO> returnDetailsDOList = this.returnDetailService
         .groupReturnDetail(
            new ArrayList<>(Arrays.asList(BasicClassEnum.GENERAL_MATERIAL.getType(), BasicClassEnum.OTHER.getType())),
            projectId,
            yearMonthDateList,
            null,
            null,
            Arrays.asList("油漆", "焊材", "焊接材料", "焊丝焊剂"),
            null
         );
      Map<String, List<CommonDetailsDO>> returnDetailsDOGroup = returnDetailsDOList.stream()
         .map(i -> BeanUtil.toBean(i, CommonDetailsDO.class))
         .collect(Collectors.groupingBy(CommonDetailsDO::getYearMonth));
      yearMonthDateList.forEach(i -> {
         String yearMonth = i.format(DatePattern.NORM_MONTH_FORMATTER);
         Map<String, List<CommonDetailsDO>> resultMap = new HashMap<>();
         List<CommonDetailsDO> outboundDetails = outboundDetailsDOGroup.get(yearMonth);
         List<CommonDetailsDO> returnDetails = returnDetailsDOGroup.get(yearMonth);
         if (CollUtil.isNotEmpty(outboundDetails) || CollUtil.isNotEmpty(returnDetails)) {
            resultMap.put("outboundList", outboundDetails);
            resultMap.put("returnList", returnDetails);
            resultList.add(resultMap);
         }
      });
      return resultList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> auxiliaryMaterialsDirectCostPrint(Long projectId, Boolean boolTaxIncluded) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<Map<String, List<CommonDetailsDO>>> dtoList = this.auxiliaryMaterialsDirectCost(projectId);
      List<CommonDetailsDO> resultList = dtoList.stream().map(i -> {
         List<CommonDetailsDO> allList = new ArrayList<>();
         List<CommonDetailsDO> outboundList = i.get("outboundList");
         if (CollUtil.isNotEmpty(outboundList)) {
            allList.addAll(outboundList);
         }

         List<CommonDetailsDO> returnList = i.get("returnList");
         if (CollUtil.isNotEmpty(returnList)) {
            returnList.forEach(r -> {
               if (r.getMeteCount() != null) {
                  r.setMeteCount(r.getMeteCount().negate());
               }

               if (r.getAmountCount() != null) {
                  r.setAmountCount(r.getAmountCount().negate());
               }

               if (r.getAmountExcludingVatCount() != null) {
                  r.setAmountExcludingVatCount(r.getAmountExcludingVatCount().negate());
               }
            });
            allList.addAll(returnList);
         }

         return allList;
      }).flatMap(Collection::stream).collect(Collectors.toList());
      List<Map<String, Object>> mapList = resultList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "辅材直接成本");
      header.put("boolTaxIncluded", boolTaxIncluded);
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      header.put(
         "statisticalDate",
         CollUtil.getFirst(yearMonthDateList).format(DatePattern.NORM_MONTH_FORMATTER)
            + " ～ "
            + CollUtil.getLast(yearMonthDateList).format(DatePattern.NORM_MONTH_FORMATTER)
      );
      header.put("project", project.getSerialNumber() + "-" + project.getShortName());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<ManufactureCostAmortizationDTO> auxiliaryMaterialsAmortizationCost(Long projectId, Boolean boolTaxIncluded) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      List<ManufactureCostAmortizationDTO> auxiliaryMaterialsAmortizationCostList = this.manufactureCostMapper
         .getTotalYieldAndProjectYield(projectId, yearMonthDateList);
      List<CostSummaryValueDTO> auxiliaryMaterialAmortizationValueList = this.moveOutboundDetailService
         .getMeteByProjectId(
            new ArrayList<>(Arrays.asList(BasicClassEnum.GENERAL_MATERIAL.getType(), BasicClassEnum.OTHER.getType())),
            null,
            yearMonthDateList,
            null,
            null,
            null,
            null,
            boolTaxIncluded
         );
      Map<String, BigDecimal> auxiliaryMaterialAmortizationCostMonthTotalMap = auxiliaryMaterialAmortizationValueList.stream()
         .collect(Collectors.toMap(CostSummaryValueDTO::getYearMonth, v -> Optional.ofNullable(v.getCostMonthTotal()).orElse(BigDecimal.ZERO), BigDecimal::add));
      List<com.hzchum.scim.wms.core.api.pojo._do.wmsReport.CommonDetailsDO> outboundDetailsDOList = this.moveOutboundDetailService
         .groupOutboundDetail(
            new ArrayList<>(Arrays.asList(BasicClassEnum.GENERAL_MATERIAL.getType(), BasicClassEnum.OTHER.getType())),
            null,
            yearMonthDateList,
            null,
            null,
            null,
            null
         );
      Map<String, List<CommonDetailsDO>> outboundDetailsDOGroup = outboundDetailsDOList.stream()
         .map(i -> BeanUtil.toBean(i, CommonDetailsDO.class))
         .collect(Collectors.groupingBy(CommonDetailsDO::getYearMonth));
      List<com.hzchum.scim.wms.core.api.pojo._do.wmsReport.CommonDetailsDO> returnDetailsDOList = this.returnDetailService
         .groupReturnDetail(
            new ArrayList<>(Arrays.asList(BasicClassEnum.GENERAL_MATERIAL.getType(), BasicClassEnum.OTHER.getType())),
            null,
            yearMonthDateList,
            null,
            null,
            null,
            null
         );
      Map<String, List<CommonDetailsDO>> returnDetailsDOGroup = returnDetailsDOList.stream()
         .map(i -> BeanUtil.toBean(i, CommonDetailsDO.class))
         .collect(Collectors.groupingBy(CommonDetailsDO::getYearMonth));
      auxiliaryMaterialsAmortizationCostList.forEach(i -> {
         List<Map<String, List<CommonDetailsDO>>> auxiliaryMaterialDetailList = new ArrayList<>();
         BigDecimal costMonthTotalNow = auxiliaryMaterialAmortizationCostMonthTotalMap.getOrDefault(i.getYearMonth(), BigDecimal.ZERO);
         i.setTotalFee(costMonthTotalNow.setScale(2, RoundingMode.HALF_UP));
         if (i.getTotalYield().compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal proportion = i.getProjectYield().divide(i.getTotalYield(), 2, RoundingMode.HALF_UP);
            BigDecimal amortizationAmount = i.getTotalFee().multiply(proportion).setScale(2, RoundingMode.HALF_UP);
            i.setProportion(proportion);
            i.setAmortizationAmount(amortizationAmount);
         } else {
            i.setAmortizationAmount(BigDecimal.ZERO);
         }

         if (i.getProportion() == null) {
            i.setProportion(BigDecimal.ZERO);
         }

         Map<String, List<CommonDetailsDO>> auxiliaryMaterialDetail = new HashMap<>();
         List<CommonDetailsDO> outboundDetails = outboundDetailsDOGroup.get(i.getYearMonth());
         List<CommonDetailsDO> returnDetails = returnDetailsDOGroup.get(i.getYearMonth());
         if (CollUtil.isNotEmpty(outboundDetails) || CollUtil.isNotEmpty(returnDetails)) {
            auxiliaryMaterialDetail.put("outboundList", outboundDetails);
            auxiliaryMaterialDetail.put("returnList", returnDetails);
            auxiliaryMaterialDetailList.add(auxiliaryMaterialDetail);
         }

         i.setAuxiliaryMaterialDetailList(auxiliaryMaterialDetailList);
      });
      return auxiliaryMaterialsAmortizationCostList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> auxiliaryMaterialsAmortizationCostPrint(Long projectId, Boolean boolTaxIncluded) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<ManufactureCostAmortizationDTO> dtoList = this.auxiliaryMaterialsAmortizationCost(projectId, boolTaxIncluded);
      List<Map<String, Object>> mapList = dtoList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "辅材摊销成本");
      header.put("statisticalDate", CollUtil.getFirst(dtoList).getYearMonth() + " ～ " + CollUtil.getLast(dtoList).getYearMonth());
      header.put("project", project.getSerialNumber() + "-" + project.getShortName());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<Map<String, List<CommonDetailsDO>>> paintCost(Long projectId) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      List<Map<String, List<CommonDetailsDO>>> resultList = new ArrayList<>();
      Map<String, List<CommonDetailsDO>> outboundDetailsDOGroup = this.moveOutboundDetailService
         .groupOutboundDetail(
            new ArrayList<>(Arrays.asList(BasicClassEnum.GENERAL_MATERIAL.getType())), projectId, yearMonthDateList, null, null, null, Arrays.asList("油漆")
         )
         .stream()
         .map(i -> BeanUtil.toBean(i, CommonDetailsDO.class))
         .collect(Collectors.groupingBy(CommonDetailsDO::getYearMonth));
      Map<String, List<CommonDetailsDO>> returnDetailsDOGroup = this.returnDetailService
         .groupReturnDetail(
            new ArrayList<>(Arrays.asList(BasicClassEnum.GENERAL_MATERIAL.getType())), projectId, yearMonthDateList, null, null, null, Arrays.asList("油漆")
         )
         .stream()
         .map(i -> BeanUtil.toBean(i, CommonDetailsDO.class))
         .collect(Collectors.groupingBy(CommonDetailsDO::getYearMonth));
      yearMonthDateList.forEach(i -> {
         String yearMonth = i.format(DatePattern.NORM_MONTH_FORMATTER);
         Map<String, List<CommonDetailsDO>> resultMap = new HashMap<>();
         List<CommonDetailsDO> outboundDetails = outboundDetailsDOGroup.get(yearMonth);
         List<CommonDetailsDO> returnDetails = returnDetailsDOGroup.get(yearMonth);
         if (CollUtil.isNotEmpty(outboundDetails) || CollUtil.isNotEmpty(returnDetails)) {
            resultMap.put("outboundList", outboundDetails);
            resultMap.put("returnList", returnDetails);
            resultList.add(resultMap);
         }
      });
      return resultList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> paintCostPrint(Long projectId, Boolean boolTaxIncluded) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<Map<String, List<CommonDetailsDO>>> dtoList = this.paintCost(projectId);
      List<CommonDetailsDO> resultList = dtoList.stream().map(i -> {
         List<CommonDetailsDO> allList = new ArrayList<>();
         List<CommonDetailsDO> outboundList = i.get("outboundList");
         if (CollUtil.isNotEmpty(outboundList)) {
            allList.addAll(outboundList);
         }

         List<CommonDetailsDO> returnList = i.get("returnList");
         if (CollUtil.isNotEmpty(returnList)) {
            returnList.forEach(r -> {
               if (r.getMeteCount() != null) {
                  r.setMeteCount(r.getMeteCount().negate());
               }

               if (r.getAmountCount() != null) {
                  r.setAmountCount(r.getAmountCount().negate());
               }

               if (r.getAmountExcludingVatCount() != null) {
                  r.setAmountExcludingVatCount(r.getAmountExcludingVatCount().negate());
               }
            });
            allList.addAll(returnList);
         }

         return allList;
      }).flatMap(Collection::stream).collect(Collectors.toList());
      List<Map<String, Object>> mapList = resultList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "油漆成本");
      header.put("boolTaxIncluded", boolTaxIncluded);
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      header.put(
         "statisticalDate",
         CollUtil.getFirst(yearMonthDateList).format(DatePattern.NORM_MONTH_FORMATTER)
            + " ～ "
            + CollUtil.getLast(yearMonthDateList).format(DatePattern.NORM_MONTH_FORMATTER)
      );
      header.put("project", project.getSerialNumber() + "-" + project.getShortName());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<Map<String, List<CommonDetailsDO>>> weldingConsumableCost(Long projectId) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      List<Map<String, List<CommonDetailsDO>>> resultList = new ArrayList<>();
      Map<String, List<CommonDetailsDO>> outboundDetailsDOGroup = this.moveOutboundDetailService
         .groupOutboundDetail(
            new ArrayList<>(Arrays.asList(BasicClassEnum.GENERAL_MATERIAL.getType())),
            projectId,
            yearMonthDateList,
            null,
            null,
            null,
            Arrays.asList("焊材", "焊接材料", "焊丝焊剂")
         )
         .stream()
         .map(i -> BeanUtil.toBean(i, CommonDetailsDO.class))
         .collect(Collectors.groupingBy(CommonDetailsDO::getYearMonth));
      Map<String, List<CommonDetailsDO>> returnDetailsDOGroup = this.returnDetailService
         .groupReturnDetail(
            new ArrayList<>(Arrays.asList(BasicClassEnum.GENERAL_MATERIAL.getType())),
            projectId,
            yearMonthDateList,
            null,
            null,
            null,
            Arrays.asList("焊材", "焊接材料", "焊丝焊剂")
         )
         .stream()
         .map(i -> BeanUtil.toBean(i, CommonDetailsDO.class))
         .collect(Collectors.groupingBy(CommonDetailsDO::getYearMonth));
      yearMonthDateList.forEach(i -> {
         String yearMonth = i.format(DatePattern.NORM_MONTH_FORMATTER);
         Map<String, List<CommonDetailsDO>> resultMap = new HashMap<>();
         List<CommonDetailsDO> outboundDetails = outboundDetailsDOGroup.get(yearMonth);
         List<CommonDetailsDO> returnDetails = returnDetailsDOGroup.get(yearMonth);
         if (CollUtil.isNotEmpty(outboundDetails) || CollUtil.isNotEmpty(returnDetails)) {
            resultMap.put("outboundList", outboundDetails);
            resultMap.put("returnList", returnDetails);
            resultList.add(resultMap);
         }
      });
      return resultList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> weldingConsumableCostPrint(Long projectId, Boolean boolTaxIncluded) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<Map<String, List<CommonDetailsDO>>> dtoList = this.weldingConsumableCost(projectId);
      List<CommonDetailsDO> resultList = dtoList.stream().map(i -> {
         List<CommonDetailsDO> allList = new ArrayList<>();
         List<CommonDetailsDO> outboundList = i.get("outboundList");
         if (CollUtil.isNotEmpty(outboundList)) {
            allList.addAll(outboundList);
         }

         List<CommonDetailsDO> returnList = i.get("returnList");
         if (CollUtil.isNotEmpty(returnList)) {
            returnList.forEach(r -> {
               if (r.getMeteCount() != null) {
                  r.setMeteCount(r.getMeteCount().negate());
               }

               if (r.getAmountCount() != null) {
                  r.setAmountCount(r.getAmountCount().negate());
               }

               if (r.getAmountExcludingVatCount() != null) {
                  r.setAmountExcludingVatCount(r.getAmountExcludingVatCount().negate());
               }
            });
            allList.addAll(returnList);
         }

         return allList;
      }).flatMap(Collection::stream).collect(Collectors.toList());
      List<Map<String, Object>> mapList = resultList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "焊材成本");
      header.put("boolTaxIncluded", boolTaxIncluded);
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      header.put(
         "statisticalDate",
         CollUtil.getFirst(yearMonthDateList).format(DatePattern.NORM_MONTH_FORMATTER)
            + " ～ "
            + CollUtil.getLast(yearMonthDateList).format(DatePattern.NORM_MONTH_FORMATTER)
      );
      header.put("project", project.getSerialNumber() + "-" + project.getShortName());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<ProjectMaterialsAllDto> getSendDirectlyConstructionSiteMaterialCostList(Long projectId) {
      List<PurchaseOrder> orderList = this.purchaseOrderService
         .list(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .eq(PurchaseOrder::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
               .eq(PurchaseOrder::getReviewStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(PurchaseOrder::getOrderPlace, PlaceEnum.CONSTRUCTION_SITE.getType())
               .eq(PurchaseOrder::getProjectIds, String.valueOf(projectId))
         );
      if (orderList.isEmpty()) {
         return Collections.emptyList();
      }

      List<Long> orderIds = orderList.stream().map(PurchaseOrder::getId).collect(Collectors.toList());
      List<SupplierPayment> supplierPaymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .in(SupplierPayment::getOrderId, orderIds)
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      Map<Long, BigDecimal> orderIdPaymentAmountMap = supplierPaymentList.stream()
         .collect(
            Collectors.groupingBy(SupplierPayment::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierPayment::getActuallyPaymentAmount, BigDecimal::add))
         );
      Map<Long, BigDecimal> orderIdPreSettlementAmountMap = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .in(SupplierSettlement::getOrderId, orderIds)
               .eq(SupplierSettlement::getBoolPreSettlement, true)
               .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
               .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .collect(Collectors.groupingBy(SupplierSettlement::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierSettlement::getAmount, BigDecimal::add)));
      Map<Long, Supplier> supplierMap = this.supplierService
         .listByIds(orderList.stream().map(PurchaseOrder::getSupplierId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(Supplier::getId, Function.identity()));
      List<ProjectMaterialsAllDto> dtoList = new ArrayList<>(16);
      orderList.forEach(
         a -> {
            BigDecimal paymentAmount = orderIdPaymentAmountMap.get(a.getId());
            BigDecimal totalAmount = a.getSettlementAmount();
            if (a.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())) {
               BigDecimal preSettlementAmount = orderIdPreSettlementAmountMap.get(a.getId());
               totalAmount = preSettlementAmount != null ? preSettlementAmount : a.getAmount();
            }

            BigDecimal preSettlementAmount = orderIdPreSettlementAmountMap.getOrDefault(a.getId(), BigDecimal.ZERO);
            ProjectMaterialsAllDto materialsAllDto = ProjectMaterialsAllDto.builder()
               .id(a.getId())
               .basicClass(a.getBasicClass())
               .supplierId(a.getSupplierId())
               .signingDate(a.getCreateTime())
               .status(a.getSettlementStatus())
               .statusName(
                  SettlementStatusEnum.SETTLED.getType().equals(a.getSettlementStatus())
                     ? SettlementStatusEnum.SETTLED.getName()
                     : SettlementStatusEnum.UN_SETTLED.getName()
               )
               .supplierName(supplierMap.get(a.getSupplierId()).getName())
               .serialNumber(a.getSerialNumber())
               .contractAmount(a.getAmount())
               .settlementStatus(a.getSettlementStatus())
               .settlementAmount(a.getSettlementAmount())
               .preSettlementAmount(orderIdPreSettlementAmountMap.get(a.getId()))
               .totalPaid(paymentAmount)
               .cost(
                  a.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())
                     ? a.getSettlementAmount()
                     : Collections.max(Arrays.asList(paymentAmount, preSettlementAmount))
               )
               .unpaid(
                  paymentAmount == null
                     ? totalAmount
                     : (totalAmount.subtract(paymentAmount).compareTo(BigDecimal.ZERO) >= 0 ? totalAmount.subtract(paymentAmount) : BigDecimal.ZERO)
               )
               .build();
            dtoList.add(materialsAllDto);
         }
      );
      return dtoList;
   }

   @Override
   public PrintVO<List<ProjectMaterialsAllDto>> printSendDirectlyConstructionSiteMaterialCostList(Long projectId) {
      ProjectInfo projectInfo = this.projectService.getSimpleById(projectId);
      PrintVO<List<ProjectMaterialsAllDto>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("project", projectInfo);
      printVO.setHeader(header);
      List<ProjectMaterialsAllDto> dtoList = this.getSendDirectlyConstructionSiteMaterialCostList(projectId);
      printVO.setTable(dtoList);
      return printVO;
   }

   @Override
   public List<ProjectLedgerSupplierInvoiceDetailDTO> getSendDirectlyConstructionSiteOrderPaymentList(Long orderId) {
      List<SupplierPayment> supplierPaymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, orderId)
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .orderByDesc(SupplierPayment::getPaymentDate)
               .orderByDesc(SupplierPayment::getId)
         );
      return supplierPaymentList.stream()
         .map(
            s -> ProjectLedgerSupplierInvoiceDetailDTO.builder()
               .number(s.getApprovalSerialNumber())
               .paymentDate(s.getPaymentDate().atStartOfDay())
               .paymentAmount(s.getActuallyPaymentAmount())
               .type(s.getPaymentReasonId() != null ? Integer.valueOf(s.getPaymentReasonId()) : null)
               .build()
         )
         .collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<ProjectLedgerSupplierInvoiceDetailDTO>> printSendDirectlyConstructionSiteOrderPaymentList(Long orderId) {
      PurchaseOrder order = this.purchaseOrderService.getById(orderId);
      Preconditions.checkArgument(order != null, "材料订单不存在!");
      ProjectInfo projectInfo = this.projectService.getSimpleById(Long.valueOf(order.getProjectIds()));
      Supplier supplier = this.supplierService.getById(order.getSupplierId());
      PrintVO<List<ProjectLedgerSupplierInvoiceDetailDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("project", projectInfo);
      header.put("serialNumber", order.getSerialNumber());
      header.put("amount", order.getAmount());
      header.put("settlementAmount", SettlementStatusEnum.SETTLED.getType().equals(order.getSettlementStatus()) ? order.getSettlementAmount() : null);
      header.put("supplier", supplier != null ? NameInfo.builder().id(supplier.getId()).name(supplier.getName()).build() : null);
      printVO.setHeader(header);
      List<ProjectLedgerSupplierInvoiceDetailDTO> paymentList = this.getSendDirectlyConstructionSiteOrderPaymentList(orderId);
      printVO.setTable(paymentList);
      return printVO;
   }

   @Override
   public List<ManufactureCostAmortizationDTO> gasFee(Long projectId, Boolean boolTaxIncluded) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      List<ManufactureCostAmortizationDTO> auxiliaryMaterialsAmortizationCostList = this.manufactureCostMapper
         .getTotalYieldAndProjectYield(projectId, yearMonthDateList);
      Map<String, CostSummaryValueDTO> auxiliaryMaterialAmortizationValueMap = this.moveOutboundDetailService
         .getMeteByProjectId(new ArrayList<>(Arrays.asList(BasicClassEnum.GAS.getType())), null, yearMonthDateList, null, null, null, null, boolTaxIncluded)
         .stream()
         .collect(Collectors.toMap(CostSummaryValueDTO::getYearMonth, Function.identity()));
      auxiliaryMaterialsAmortizationCostList.forEach(i -> {
         CostSummaryValueDTO costSummaryValueDTO = auxiliaryMaterialAmortizationValueMap.get(i.getYearMonth());
         if (BeanUtil.isNotEmpty(costSummaryValueDTO)) {
            if (costSummaryValueDTO.getCostMonthTotal() != null) {
               i.setTotalFee(costSummaryValueDTO.getCostMonthTotal().setScale(2, RoundingMode.HALF_UP));
            } else {
               i.setTotalFee(BigDecimal.ZERO);
            }
         } else {
            i.setTotalFee(BigDecimal.ZERO);
         }

         if (i.getTotalYield().compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal proportion = i.getProjectYield().divide(i.getTotalYield(), 2, RoundingMode.HALF_UP);
            BigDecimal amortizationAmount = i.getTotalFee().multiply(proportion).setScale(2, RoundingMode.HALF_UP);
            i.setProportion(proportion);
            i.setAmortizationAmount(amortizationAmount);
         } else {
            i.setAmortizationAmount(BigDecimal.ZERO);
         }

         if (i.getProportion() == null) {
            i.setProportion(BigDecimal.ZERO);
         }
      });
      return auxiliaryMaterialsAmortizationCostList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> gasFeePrint(Long projectId, Boolean boolTaxIncluded) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<ManufactureCostAmortizationDTO> dtoList = this.gasFee(projectId, boolTaxIncluded);
      List<Map<String, Object>> mapList = dtoList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "气体费摊销");
      header.put("statisticalDate", CollUtil.getFirst(dtoList).getYearMonth() + " ～ " + CollUtil.getLast(dtoList).getYearMonth());
      header.put("project", project.getSerialNumber() + "-" + project.getShortName());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<Map<String, List<CommonDetailsDO>>> gasDirectCost(Long projectId) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      List<Map<String, List<CommonDetailsDO>>> resultList = new ArrayList<>();
      Map<String, List<CommonDetailsDO>> outboundDetailsDOGroup = this.moveOutboundDetailService
         .groupOutboundDetail(new ArrayList<>(Arrays.asList(BasicClassEnum.GAS.getType())), projectId, yearMonthDateList, null, null, null, null)
         .stream()
         .map(i -> BeanUtil.toBean(i, CommonDetailsDO.class))
         .collect(Collectors.groupingBy(CommonDetailsDO::getYearMonth));
      Map<String, List<CommonDetailsDO>> returnDetailsDOGroup = this.returnDetailService
         .groupReturnDetail(new ArrayList<>(Arrays.asList(BasicClassEnum.GAS.getType())), projectId, yearMonthDateList, null, null, null, null)
         .stream()
         .map(i -> BeanUtil.toBean(i, CommonDetailsDO.class))
         .collect(Collectors.groupingBy(CommonDetailsDO::getYearMonth));
      yearMonthDateList.forEach(i -> {
         String yearMonth = i.format(DatePattern.NORM_MONTH_FORMATTER);
         Map<String, List<CommonDetailsDO>> resultMap = new HashMap<>();
         List<CommonDetailsDO> outboundDetails = outboundDetailsDOGroup.get(yearMonth);
         List<CommonDetailsDO> returnDetails = returnDetailsDOGroup.get(yearMonth);
         if (CollUtil.isNotEmpty(outboundDetails) || CollUtil.isNotEmpty(returnDetails)) {
            resultMap.put("outboundList", outboundDetails);
            resultMap.put("returnList", returnDetails);
            resultList.add(resultMap);
         }
      });
      return resultList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> gasDirectCostPrint(Long projectId, Boolean boolTaxIncluded) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<Map<String, List<CommonDetailsDO>>> dtoList = this.gasDirectCost(projectId);
      List<CommonDetailsDO> resultList = dtoList.stream().map(i -> {
         List<CommonDetailsDO> allList = new ArrayList<>();
         List<CommonDetailsDO> outboundList = i.get("outboundList");
         if (CollUtil.isNotEmpty(outboundList)) {
            allList.addAll(outboundList);
         }

         List<CommonDetailsDO> returnList = i.get("returnList");
         if (CollUtil.isNotEmpty(returnList)) {
            returnList.forEach(r -> {
               if (r.getMeteCount() != null) {
                  r.setMeteCount(r.getMeteCount().negate());
               }

               if (r.getAmountCount() != null) {
                  r.setAmountCount(r.getAmountCount().negate());
               }

               if (r.getAmountExcludingVatCount() != null) {
                  r.setAmountExcludingVatCount(r.getAmountExcludingVatCount().negate());
               }
            });
            allList.addAll(returnList);
         }

         return allList;
      }).flatMap(Collection::stream).collect(Collectors.toList());
      List<Map<String, Object>> mapList = resultList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "气体费直接成本");
      header.put("boolTaxIncluded", boolTaxIncluded);
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      header.put(
         "statisticalDate",
         CollUtil.getFirst(yearMonthDateList).format(DatePattern.NORM_MONTH_FORMATTER)
            + " ～ "
            + CollUtil.getLast(yearMonthDateList).format(DatePattern.NORM_MONTH_FORMATTER)
      );
      header.put("project", project.getSerialNumber() + "-" + project.getShortName());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public List<ManufactureCostAmortizationDTO> managerAmortizationCost(Long projectId) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      return this.manufactureCostMapper.managerAmortizationList(projectId, yearMonthDateList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> managerAmortizationCostPrint(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      String projectName = project.getSerialNumber() + "-" + project.getShortName();
      List<ManufactureCostAmortizationDTO> list = this.managerAmortizationCost(projectId);
      return this.getPrint(list, "管理人员摊销成本", projectName);
   }

   @Override
   public List<ManufactureCostAmortizationDTO> tempWorkAmortizationCost(Long projectId) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      return this.manufactureCostMapper.tempWorkAmortizationList(projectId, yearMonthDateList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> tempWorkAmortizationCostPrint(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      String projectName = project.getSerialNumber() + "-" + project.getShortName();
      List<ManufactureCostAmortizationDTO> list = this.tempWorkAmortizationCost(projectId);
      return this.getPrint(list, "零工摊销成本", projectName);
   }

   @Override
   public List<Map<String, List<ManufactureCostProductionLaborDTO>>> productionLaborCost(Long projectId) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      List<Map<String, List<ManufactureCostProductionLaborDTO>>> resultList = new ArrayList<>();
      List<ManufactureCostProductionLaborDTO> list = this.manufactureCostMapper.productionLaborCostList(projectId, yearMonthDateList);
      Map<String, List<ManufactureCostProductionLaborDTO>> group = list.stream()
         .collect(Collectors.groupingBy(ManufactureCostProductionLaborDTO::getYearMonth));
      yearMonthDateList.forEach(i -> {
         String yearMonth = i.format(DatePattern.NORM_MONTH_FORMATTER);
         Map<String, List<ManufactureCostProductionLaborDTO>> result = new HashMap<>();
         List<ManufactureCostProductionLaborDTO> monthList = group.get(yearMonth);
         if (CollUtil.isNotEmpty(monthList)) {
            result.put("monthList", monthList);
            resultList.add(result);
         }
      });
      return resultList;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> productionLaborCostPrint(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<Map<String, List<ManufactureCostProductionLaborDTO>>> dtoList = this.productionLaborCost(projectId);
      List<ManufactureCostProductionLaborDTO> resultList = dtoList.stream()
         .map(i -> i.get("monthList"))
         .flatMap(Collection::stream)
         .filter(Objects::nonNull)
         .collect(Collectors.toList());
      List<Map<String, Object>> mapList = resultList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "生产人工成本");
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      header.put(
         "statisticalDate",
         CollUtil.getFirst(yearMonthDateList).format(DatePattern.NORM_MONTH_FORMATTER)
            + " ～ "
            + CollUtil.getLast(yearMonthDateList).format(DatePattern.NORM_MONTH_FORMATTER)
      );
      header.put("project", project.getSerialNumber() + "-" + project.getShortName());
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   private PrintVO<List<Map<String, Object>>> getPrint(List<ManufactureCostAmortizationDTO> List, String title, String projectName) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<Map<String, Object>> mapList = List.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", title);
      header.put("statisticalDate", CollUtil.getFirst(List).getYearMonth() + " ～ " + CollUtil.getLast(List).getYearMonth());
      header.put("project", projectName);
      printVO.setHeader(header);
      printVO.setTable(mapList);
      return printVO;
   }

   private List<LocalDate> getYearMonthDateList(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(project), "项目不存在");
      LocalDate startDate = project.getCreateTime().toLocalDate().with(TemporalAdjusters.firstDayOfMonth());
      LocalDate endDate = ProjectStatusEnum.COMPLETED.getType().equals(project.getStatus()) ? project.getCompleteDate() : LocalDate.now();
      endDate = endDate.with(TemporalAdjusters.firstDayOfMonth());
      List<LocalDate> yearMonthList = new ArrayList<>();
      long monthsBetween = ChronoUnit.MONTHS.between(startDate, endDate);
      Stream.<LocalDate>iterate(startDate, date -> date.plusMonths(1L)).limit(monthsBetween + 1L).forEach(yearMonthList::add);
      return yearMonthList;
   }

   private Map<Long, BigDecimal> getSecondCollectionAmountMap(Collection<Long> projectIds, String yearMonth) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(projectIds), "未传项目id");
      List<BranchCompany> branchCompanyList = this.branchCompanyService
         .list(Wrappers.lambdaQuery(BranchCompany.builder().level(BranchCompanyLevelEnum.SECONDARY_UNIT.getType()).build()));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(branchCompanyList), "系统未查询到分支机构!");
      Map<Long, BigDecimal> collectionAmountMap = this.collectionService
         .list(
            Wrappers.lambdaQuery(ContractCollection.class)
               .in(ContractCollection::getProjectId, projectIds)
               .in(ContractCollection::getCollectionUnitId, branchCompanyList.stream().map(BranchCompany::getId).collect(Collectors.toList()))
               .eq(ContractCollection::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .apply(StringUtils.isNotBlank(yearMonth), "date_format(collection_date,'%Y-%m') = {0}", yearMonth)
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               ContractCollection::getProjectId, Collectors.reducing(BigDecimal.ZERO, ContractCollection::getCollectionAmount, BigDecimal::add)
            )
         );
      Map<Long, BigDecimal> projectCollectionAmountMap = new HashMap<>(projectIds.size());
      projectIds.forEach(projectId -> {
         BigDecimal var10000 = projectCollectionAmountMap.put(projectId, collectionAmountMap.getOrDefault(projectId, BigDecimal.ZERO));
      });
      return projectCollectionAmountMap;
   }

   private Map<String, BigDecimal> getSecondCollectionAmountAll(Long projectId) {
      Preconditions.checkArgument(projectId != null, "未传项目id");
      List<BranchCompany> branchCompanyList = this.branchCompanyService
         .list(Wrappers.lambdaQuery(BranchCompany.builder().level(BranchCompanyLevelEnum.SECONDARY_UNIT.getType()).build()));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(branchCompanyList), "系统未查询到分支机构!");
      List<ContractCollection> collections = this.collectionService
         .list(
            Wrappers.lambdaQuery(ContractCollection.class)
               .eq(ContractCollection::getProjectId, projectId)
               .in(ContractCollection::getCollectionUnitId, branchCompanyList.stream().map(BranchCompany::getId).collect(Collectors.toList()))
               .eq(ContractCollection::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      return collections.stream()
         .collect(
            Collectors.groupingBy(
               collection -> collection.getCollectionDate().format(DateTimeFormatter.ofPattern("yyyy-MM")),
               Collectors.mapping(ContractCollection::getCollectionAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
            )
         );
   }
}
