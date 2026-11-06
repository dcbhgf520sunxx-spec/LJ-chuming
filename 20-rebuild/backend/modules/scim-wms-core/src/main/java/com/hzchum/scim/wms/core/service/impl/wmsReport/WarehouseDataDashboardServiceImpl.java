package com.hzchum.scim.wms.core.service.impl.wmsReport;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.utils.DateTimeUtil;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.scm.core.api.enums.PlaceEnum;
import com.hzchum.scim.scm.core.api.enums.PurchaseEnum;
import com.hzchum.scim.scm.core.api.enums.PurchaseStatusEnum;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderDetailService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.DataStatusEnum;
import com.hzchum.scim.wms.core.api.enums.MessageEnum;
import com.hzchum.scim.wms.core.api.enums.UnitEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicShowConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InboundDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.OutboundDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.RejectDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.ReturnDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialReturnable;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Reject;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsAdjustDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InboundAndOutboundDataDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InstantMessageHintDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.MonthRealTimeInventoryAmountDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.NameAndValueDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ProjectSteelCountDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.RealTimeOutboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.RealTimePurchaseAndInboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WMSStockTurnoverMonthVO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InventoryReminderDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarningService;
import com.hzchum.scim.wms.core.api.service.wmsReport.StatisticsBeginPeriodService;
import com.hzchum.scim.wms.core.api.service.wmsReport.StatisticsInboundService;
import com.hzchum.scim.wms.core.api.service.wmsReport.StatisticsOutboundService;
import com.hzchum.scim.wms.core.api.service.wmsReport.WarehouseDataDashboardService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialReturnableService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MonthWeightedAveragePriceService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.RejectDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.RejectService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WholeWeightedAveragePriceService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsAdjustDetailService;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.UnitMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WholeWeightedAveragePriceMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class WarehouseDataDashboardServiceImpl implements WarehouseDataDashboardService {
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   ClassificationService classificationService;
   @Resource
   MaterialInventoryMapper materialInventoryMapper;
   @Resource
   MonthWeightedAveragePriceMapper monthWAPMapper;
   @Resource
   WholeWeightedAveragePriceMapper wholeWAPMapper;
   @Resource
   OutboundService outboundService;
   @Resource
   MoveOutboundDetailService moveOutboundDetailService;
   @Resource
   ContractProjectService contractProjectService;
   @Resource
   UserService userService;
   @Resource
   QueryUtilService queryUtilService;
   @Resource
   PurchaseOrderService purchaseOrderService;
   @Resource
   InboundService inboundService;
   @Resource
   InboundDetailService inboundDetailService;
   @Resource
   InboundManufacturedService inboundManufacturedService;
   @Resource
   SupplierService supplierService;
   @Resource
   RejectService rejectService;
   @Resource
   RejectDetailService rejectDetailService;
   @Resource
   ReturnService returnService;
   @Resource
   MaterialReturnableService materialReturnableService;
   @Resource
   ReturnDetailService returnDetailService;
   @Resource
   PurchaseOrderDetailService purchaseOrderDetailService;
   @Resource
   WmsAdjustDetailService wmsAdjustDetailService;
   @Resource
   StatisticsBeginPeriodService statisticsBeginPeriodService;
   @Resource
   private StatisticsInboundService statisticsInboundService;
   @Resource
   private MonthWeightedAveragePriceService monthWeightedAveragePriceService;
   @Resource
   private WholeWeightedAveragePriceService wholeWeightedAveragePriceService;
   @Resource
   private StatisticsOutboundService statisticsOutboundService;
   @Resource
   private TechArtifactService techArtifactService;
   @Resource
   private RedisTemplate redisTemplate;
   @Resource
   private WarningService warningService;
   @Resource
   private UnitMapper unitMapper;
   private static final BigDecimal ONE_HUNDRED = new BigDecimal("100");
   private static final BigDecimal THOUSAND = new BigDecimal("1000");
   private static final BigDecimal TEN_THOUSAND = new BigDecimal("10000");
   private static final BigDecimal MILLION = new BigDecimal("1000000");

   @Override
   public List<NameAndValueDTO> inventoryAmount(Long factoryId, Long workshopId) {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
      String format = simpleDateFormat.format(new Date());
      Object o = this.redisTemplate.opsForValue().get("warehouse_last_month_inventory_amount-" + format + "-" + workshopId);
      if (o != null) {
         return JSONArray.parseArray(o.toString(), NameAndValueDTO.class);
      }

      MonthTimeRange monthTimeRange = DateTimeUtil.getMonthTimeRange(LocalDateTime.now().toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
      List<Classification> classifications = this.classificationService.list((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().eq(Classification::getLevel, 1));
      if (CollectionUtil.isEmpty(classifications)) {
         return new ArrayList<>();
      }

      BigDecimal sumAmount = new BigDecimal("0");
      List<NameAndValueDTO> nameAndValueDTOS = new ArrayList<>();

      for (Classification classification : classifications) {
         List<Classification> lastSubjectNew = this.classificationService.getLastSubjectNew(classification.getId());
         List<Long> classifyIds = lastSubjectNew.stream().map(Classification::getId).collect(Collectors.toList());
         BigDecimal sumAmountNewOne = this.statisticsBeginPeriodService.getSumAmountNewOne(monthTimeRange, null, null, workshopId, classifyIds);
         NameAndValueDTO nameAndValueDTO = new NameAndValueDTO();
         nameAndValueDTO.setName(classification.getName());
         nameAndValueDTO.setValue(sumAmountNewOne.divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP));
         nameAndValueDTOS.add(nameAndValueDTO);
         sumAmount = sumAmount.add(sumAmountNewOne);
      }

      this.calculateSimplePercentages(nameAndValueDTOS);
      this.redisTemplate
         .opsForValue()
         .set("warehouse_last_month_inventory_amount-" + format + "-" + workshopId, JSON.toJSONString(nameAndValueDTOS), 1L, TimeUnit.DAYS);
      return nameAndValueDTOS;
   }

   public void calculateSimplePercentages(List<NameAndValueDTO> list) {
      if (list != null && !list.isEmpty()) {
         BigDecimal total = BigDecimal.ZERO;

         for (NameAndValueDTO dto : list) {
            if (dto.getValue() != null) {
               total = total.add(dto.getValue());
            }
         }

         if (total.compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal sum = BigDecimal.ZERO;

            for (int i = 0; i < list.size(); i++) {
               NameAndValueDTO dto = list.get(i);
               if (dto.getValue() == null) {
                  dto.setProportion(BigDecimal.ZERO);
               } else {
                  BigDecimal percentage = dto.getValue().multiply(new BigDecimal("100")).divide(total, 2, RoundingMode.HALF_UP);
                  if (i == list.size() - 1) {
                     percentage = new BigDecimal("100").subtract(sum);
                  } else {
                     sum = sum.add(percentage);
                  }

                  dto.setProportion(percentage);
               }
            }
         } else {
            for (NameAndValueDTO dto : list) {
               dto.setProportion(BigDecimal.ZERO);
            }
         }
      }
   }

   @Override
   public List<NameAndValueDTO> inventoryRatio(Long factoryId, Long workshopId) {
      Object o = this.redisTemplate.opsForValue().get("warehouse_inventory_ratio-" + workshopId);
      if (o != null) {
         return JSONArray.parseArray(o.toString(), NameAndValueDTO.class);
      }

      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      List<MaterialInventory> materialInventories = this.materialInventoryMapper
         .selectList(
            (Wrapper<MaterialInventory>)((new LambdaQueryWrapper<MaterialInventory>().eq(MaterialInventory::getUseStatus, 0))
                  .eq(ObjectUtil.isNotEmpty(workshopId), MaterialInventory::getWorkshopId, workshopId))
               .and(
                  c -> {
                     LambdaQueryWrapper var10000 = ((((((((c.eq(
                                                MaterialInventory::getBasicClass, BasicClassEnum.STEEL_PLATE.getType()
                                             ))
                                             .or())
                                          .eq(MaterialInventory::getBasicClass, BasicClassEnum.SECTION_STEEL.getType()))
                                       .or())
                                    .eq(MaterialInventory::getBasicClass, BasicClassEnum.COLOR_ROLL.getType()))
                                 .or())
                              .eq(MaterialInventory::getBasicClass, BasicClassEnum.GENERAL_MATERIAL.getType()))
                           .or())
                        .eq(MaterialInventory::getBasicClass, BasicClassEnum.OTHER.getType());
                  }
               )
         );
      if (CollectionUtil.isEmpty(materialInventories)) {
         return new ArrayList<>();
      }

      List<NameAndValueDTO> nameAndValueDTOS = new ArrayList<>();
      List<MaterialInventory> materialInventoryList = materialInventories.stream()
         .filter(m -> BasicClassEnum.checkIsSteel(m.getBasicClass()))
         .collect(Collectors.toList());
      BigDecimal amountByMaterialInventory = this.getAmountByMaterialInventory(materialInventoryList, weightedPriceConf);
      nameAndValueDTOS.add(NameAndValueDTO.builder().name("钢材").value(amountByMaterialInventory).build());
      materialInventoryList = materialInventories.stream()
         .filter(m -> BasicClassEnum.GENERAL_MATERIAL.getType().equals(m.getBasicClass()))
         .collect(Collectors.toList());
      amountByMaterialInventory = this.getAmountByMaterialInventory(materialInventoryList, weightedPriceConf);
      nameAndValueDTOS.add(NameAndValueDTO.builder().name("辅材").value(amountByMaterialInventory).build());
      materialInventoryList = materialInventories.stream().filter(m -> BasicClassEnum.OTHER.getType().equals(m.getBasicClass())).collect(Collectors.toList());
      amountByMaterialInventory = this.getAmountByMaterialInventory(materialInventoryList, weightedPriceConf);
      nameAndValueDTOS.add(NameAndValueDTO.builder().name("办公用品").value(amountByMaterialInventory).build());
      this.calculateSimplePercentages(nameAndValueDTOS);
      this.redisTemplate.opsForValue().set("warehouse_inventory_ratio-" + workshopId, JSON.toJSONString(nameAndValueDTOS), 1L, TimeUnit.DAYS);
      return nameAndValueDTOS;
   }

   private BigDecimal getAmountByMaterialInventory(List<MaterialInventory> materialInventories, WeightedPriceConf weightedPriceConf) {
      BigDecimal sumAmountExcludingVat = new BigDecimal("0");

      for (MaterialInventory materialInventory : materialInventories) {
         MonthWeightedAveragePrice price = this.monthWAPMapper.getPrice(materialInventory);
         if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
            WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWAPMapper.selectById(price.getWholeWapId());
            price.setMete(wholeWeightedAveragePrice.getMete());
            price.setAmount(wholeWeightedAveragePrice.getAmount());
            price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
         }

         BigDecimal p = materialInventory.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
         BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(2, RoundingMode.HALF_UP);
         sumAmountExcludingVat = sumAmountExcludingVat.add(amountExcludingVat);
      }

      return sumAmountExcludingVat;
   }

   @Override
   public Map<String, List<RealTimeOutboundDTO>> realTimeOutbound(Long factoryId, Long workshopId) {
      HashMap<String, List<RealTimeOutboundDTO>> map = new HashMap<>();
      List<MoveOutboundDetail> passOrderDetailSteel = this.outboundService.getPassOrderDetail(BasicClassEnum.getSteelNum(), workshopId, 20);
      if (CollectionUtil.isEmpty(passOrderDetailSteel)) {
         map.put("钢材", new ArrayList<>());
      }

      List<MoveOutboundDetail> passOrderDetailGeneralMaterial = this.outboundService
         .getPassOrderDetail(BasicClassEnum.GENERAL_MATERIAL.getType(), workshopId, 20);
      if (CollectionUtil.isEmpty(passOrderDetailGeneralMaterial)) {
         map.put("辅材", new ArrayList<>());
      }

      if (CollectionUtil.isEmpty(passOrderDetailSteel) && CollectionUtil.isEmpty(passOrderDetailGeneralMaterial)) {
         return map;
      }

      List<Long> classifyIds = passOrderDetailSteel.stream().map(MoveOutboundDetail::getClassifyId).collect(Collectors.toList());
      List<Long> classifyIdsOne = passOrderDetailGeneralMaterial.stream().map(MoveOutboundDetail::getClassifyId).collect(Collectors.toList());
      classifyIds.addAll(classifyIdsOne);
      Map<Long, String> classMap = this.classificationService
         .listByIds(classifyIds)
         .stream()
         .collect(Collectors.toMap(Classification::getId, Classification::getName));
      List<Long> collect = passOrderDetailSteel.stream()
         .map(MoveOutboundDetail::getProjectId)
         .distinct()
         .filter(ObjectUtil::isNotEmpty)
         .collect(Collectors.toList());
      List<Long> collect1 = passOrderDetailGeneralMaterial.stream()
         .map(MoveOutboundDetail::getProjectId)
         .filter(ObjectUtil::isNotEmpty)
         .distinct()
         .collect(Collectors.toList());
      collect.addAll(collect1);
      Map<String, Unit> unitMap = this.unitMapper.selectList(null).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));
      Map<Long, Measure> measureMap = this.queryUtilService.getMeasureMapByClassifyIds(classifyIds);
      Map<Long, String> projectMap = this.contractProjectService
         .getSimpleByIds(collect)
         .stream()
         .collect(Collectors.toMap(ProjectInfo::getId, ProjectInfo::getShortName));
      BasicShowConfig basicShowConfig = this.basicConfigService.getBasicShowConfig();
      List<RealTimeOutboundDTO> steelList = passOrderDetailSteel.stream()
         .map(
            p -> {
               Measure measure = measureMap.get(p.getClassifyId());
               RealTimeOutboundDTO realTimeOutboundDTO = new RealTimeOutboundDTO();
               realTimeOutboundDTO.setProjectName(projectMap.get(p.getProjectId()));
               realTimeOutboundDTO.setBasicClassName(BasicClassEnum.getNameByType(p.getBasicClass()));
               realTimeOutboundDTO.setClassifyName(classMap.get(p.getClassifyId()));
               realTimeOutboundDTO.setSpecification(this.queryUtilService.getConfigShowSpec(JSON.toJSONString(p), basicShowConfig));
               realTimeOutboundDTO.setMete(p.getMete().divide(THOUSAND).setScale(2, RoundingMode.HALF_UP));
               realTimeOutboundDTO.setUserName(p.getRecipientName());
               if (measure != null && measure.getAccountingUnit() != null && measure.getAccountingPrecision() != null) {
                  String s = p.getMete().compareTo(BigDecimal.ZERO) != 0
                     ? this.unitConversionV2(p.getMete(), measure.getAccountingUnit(), measure.getAccountingPrecision(), unitMap).get(1).toPlainString()
                     : "0";
                  realTimeOutboundDTO.setMete(new BigDecimal(s));
                  realTimeOutboundDTO.setAccountingUnit(measure.getAccountingUnit());
               }

               return realTimeOutboundDTO;
            }
         )
         .collect(Collectors.toList());
      map.put("钢材", steelList);
      List<RealTimeOutboundDTO> generalMaterialList = passOrderDetailGeneralMaterial.stream()
         .map(
            p -> {
               Measure measure = measureMap.get(p.getClassifyId());
               RealTimeOutboundDTO realTimeOutboundDTO = new RealTimeOutboundDTO();
               realTimeOutboundDTO.setProjectName(projectMap.get(p.getProjectId()));
               realTimeOutboundDTO.setBasicClassName(BasicClassEnum.getNameByType(p.getBasicClass()));
               realTimeOutboundDTO.setClassifyName(classMap.get(p.getClassifyId()));
               realTimeOutboundDTO.setSpecification(this.queryUtilService.getConfigShowSpec(JSON.toJSONString(p), basicShowConfig));
               realTimeOutboundDTO.setMete(p.getMete());
               realTimeOutboundDTO.setUserName(p.getRecipientName());
               if (measure != null && measure.getAccountingUnit() != null && measure.getAccountingPrecision() != null) {
                  String s = p.getMete().compareTo(BigDecimal.ZERO) != 0
                     ? this.unitConversionV2(p.getMete(), measure.getAccountingUnit(), measure.getAccountingPrecision(), unitMap).get(1).toPlainString()
                     : "0";
                  realTimeOutboundDTO.setMete(new BigDecimal(s));
                  realTimeOutboundDTO.setAccountingUnit(measure.getAccountingUnit());
               }

               return realTimeOutboundDTO;
            }
         )
         .collect(Collectors.toList());
      map.put("辅材", generalMaterialList);
      return map;
   }

   @Override
   public List<RealTimePurchaseAndInboundDTO> realTimePurchaseAndInbound(Long factoryId, Long workshopId) {
      List<PurchaseOrder> purchaseOrders = this.purchaseOrderService
         .list(
            (Wrapper<PurchaseOrder>)((new LambdaQueryWrapper<PurchaseOrder>()
                     .eq(PurchaseOrder::getDataStatus, DataStatusEnum.SUCCEED.getType()))
                  .orderByDesc(PurchaseOrder::getId))
               .last("limit 20")
         );
      if (CollectionUtil.isEmpty(purchaseOrders)) {
         return new ArrayList<>();
      }

      List<Long> supplierIds = purchaseOrders.stream().map(PurchaseOrder::getSupplierId).collect(Collectors.toList());
      Map<Long, String> supplierMap = this.supplierService.listByIds(supplierIds).stream().collect(Collectors.toMap(Supplier::getId, Supplier::getName));
      List<RealTimePurchaseAndInboundDTO> realTimePurchaseAndInboundDTOS = new ArrayList<>();
      List<Long> purchaseIds = purchaseOrders.stream().map(PurchaseOrder::getId).collect(Collectors.toList());
      Map<Long, BigDecimal> orderIdInboundAmountMap = this.inboundService
         .list(Wrappers.lambdaQuery(Inbound.class).eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).in(Inbound::getPurchaseId, purchaseIds))
         .stream()
         .filter(s -> s.getAmountNoFreight() != null)
         .collect(Collectors.groupingBy(Inbound::getPurchaseId, Collectors.reducing(BigDecimal.ZERO, Inbound::getAmountNoFreight, BigDecimal::add)));
      Map<Long, BigDecimal> orderIdInboundManufacturedAmountMap = this.inboundManufacturedService
         .list(
            Wrappers.lambdaQuery(InboundManufactured.class)
               .eq(InboundManufactured::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
               .in(InboundManufactured::getPurchaseId, purchaseIds)
         )
         .stream()
         .filter(s -> s.getAmount() != null)
         .collect(
            Collectors.groupingBy(InboundManufactured::getPurchaseId, Collectors.reducing(BigDecimal.ZERO, InboundManufactured::getAmount, BigDecimal::add))
         );
      Map<Long, BigDecimal> orderIdRejectAmountMap = this.rejectService
         .list(Wrappers.lambdaQuery(Reject.class).eq(Reject::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).in(Reject::getPurchaseOrderId, purchaseIds))
         .stream()
         .filter(s -> s.getAmountNoFreight() != null)
         .collect(Collectors.groupingBy(Reject::getPurchaseOrderId, Collectors.reducing(BigDecimal.ZERO, Reject::getAmountNoFreight, BigDecimal::add)));
      Map<Long, BigDecimal> receiviedAmountMap = this.getReceiviedAmount(purchaseIds);
      Map<Long, BigDecimal> orderIdAdjustAmountMap = this.getOrderIdAdjustAmountMap(purchaseIds);
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

      for (PurchaseOrder purchaseOrder : purchaseOrders) {
         RealTimePurchaseAndInboundDTO realTimePurchaseAndInboundDTO = new RealTimePurchaseAndInboundDTO();
         realTimePurchaseAndInboundDTO.setCreateTime(dateTimeFormatter.format(purchaseOrder.getCreateTime()));
         realTimePurchaseAndInboundDTO.setSerialNumber(purchaseOrder.getSerialNumber());
         realTimePurchaseAndInboundDTO.setSupplierName(supplierMap.get(purchaseOrder.getSupplierId()));
         realTimePurchaseAndInboundDTO.setBasicClass(BasicClassEnum.getNameStr(purchaseOrder.getBasicClass()));
         realTimePurchaseAndInboundDTO.setContractAmount(purchaseOrder.getAmount().divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP));
         realTimePurchaseAndInboundDTO.setStatus(purchaseOrder.getPurchaseStatus().equals(PurchaseStatusEnum.DURING.getType()) ? "办理中" : "办理完成");
         if (PlaceEnum.FACTORY.getType().equals(purchaseOrder.getOrderPlace())) {
            BigDecimal adjustAmount = orderIdAdjustAmountMap.getOrDefault(purchaseOrder.getId(), BigDecimal.ZERO);
            if (purchaseOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())) {
               realTimePurchaseAndInboundDTO.setInboundAmount(
                  orderIdInboundAmountMap.getOrDefault(purchaseOrder.getId(), BigDecimal.ZERO)
                     .subtract(orderIdRejectAmountMap.getOrDefault(purchaseOrder.getId(), BigDecimal.ZERO))
                     .add(adjustAmount)
                     .setScale(2, RoundingMode.HALF_UP)
               );
            } else {
               realTimePurchaseAndInboundDTO.setInboundAmount(
                  orderIdInboundManufacturedAmountMap.getOrDefault(purchaseOrder.getId(), BigDecimal.ZERO).add(adjustAmount).setScale(2, RoundingMode.HALF_UP)
               );
            }
         }

         if (PlaceEnum.CONSTRUCTION_SITE.getType().equals(purchaseOrder.getOrderPlace())) {
            realTimePurchaseAndInboundDTO.setInboundAmount(receiviedAmountMap.get(purchaseOrder.getId()));
         }

         realTimePurchaseAndInboundDTO.setInboundAmount(realTimePurchaseAndInboundDTO.getInboundAmount().divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP));
         realTimePurchaseAndInboundDTOS.add(realTimePurchaseAndInboundDTO);
      }

      return realTimePurchaseAndInboundDTOS;
   }

   @Override
   public List<WMSStockTurnoverMonthVO> steelStockTurnover(Long factoryId, Long workshopId) {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
      String format = simpleDateFormat.format(new Date());
      Object o = this.redisTemplate.opsForValue().get("warehouse_steel_stock_turnover-" + format + "-" + workshopId);
      if (o != null) {
         List<WMSStockTurnoverMonthVO> wmsStockTurnoverMonthVOS = JSONArray.parseArray(o.toString(), WMSStockTurnoverMonthVO.class);
         DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
         LocalDateTime now = LocalDateTime.now();
         String monthStr = dateTimeFormatter.format(now);
         WMSStockTurnoverMonthVO wmsStockTurnoverMonthVO = new WMSStockTurnoverMonthVO();
         wmsStockTurnoverMonthVO.setDateStr(monthStr);
         wmsStockTurnoverMonthVO.setDateTime(LocalDateTime.now());
         MonthTimeRange monthTimeRange = DateTimeUtil.getMonthTimeRange(now.toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
         BigDecimal beginMete = this.statisticsBeginPeriodService.getSumMeteNewOne(monthTimeRange, null, BasicClassEnum.getSteelNum(), workshopId, null);
         BigDecimal inboundMete = this.statisticsInboundService.getSumMeteNewOne(monthTimeRange, null, BasicClassEnum.getSteelNum(), workshopId);
         wmsStockTurnoverMonthVO.setInMete(inboundMete.divide(MILLION, 4, RoundingMode.HALF_UP));
         BigDecimal outboundMete = this.statisticsOutboundService.getSumMeteNewOne(monthTimeRange, null, BasicClassEnum.getSteelNum(), workshopId);
         wmsStockTurnoverMonthVO.setOutMete(outboundMete.divide(MILLION, 4, RoundingMode.HALF_UP));
         BigDecimal endPeriod = beginMete.add(inboundMete).subtract(outboundMete);
         if (beginMete.compareTo(BigDecimal.ZERO) == 0 && endPeriod.compareTo(BigDecimal.ZERO) == 0) {
            wmsStockTurnoverMonthVO.setStockTurnover(BigDecimal.ZERO);
         } else {
            BigDecimal stockTurnover = outboundMete.divide(
               beginMete.add(endPeriod).divide(BigDecimal.valueOf(2L), 2, RoundingMode.HALF_UP), 2, RoundingMode.HALF_UP
            );
            wmsStockTurnoverMonthVO.setStockTurnover(stockTurnover);
         }

         wmsStockTurnoverMonthVOS.add(wmsStockTurnoverMonthVO);
         return wmsStockTurnoverMonthVOS;
      } else {
         LocalDateTime startDate = LocalDateTime.of(LocalDate.from(LocalDateTime.now().with(TemporalAdjusters.firstDayOfYear())), LocalTime.MIN);
         LocalDateTime endDate = LocalDateTime.of(LocalDate.from(LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth())), LocalTime.MIN);
         long monthsBetween = ChronoUnit.MONTHS.between(startDate, endDate);
         DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
         List<String> monthStrList = new ArrayList<>();
         List<LocalDateTime> dateTimeList = new ArrayList<>();

         for (int i = 0; i <= monthsBetween; i++) {
            monthStrList.add(startDate.plusMonths(i).format(dateTimeFormatter));
            dateTimeList.add(startDate.plusMonths(i));
         }

         LocalDateTime localDateTimeNow = LocalDateTime.of(LocalDate.from(LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth())), LocalTime.MIN);
         List<WMSStockTurnoverMonthVO> wmsStockTurnoverMonthVOS = new ArrayList<>();

         for (String monthStr : monthStrList) {
            LocalDateTime dateTime = dateTimeList.get(monthStrList.indexOf(monthStr));
            WMSStockTurnoverMonthVO wmsStockTurnoverMonthVO = new WMSStockTurnoverMonthVO();
            wmsStockTurnoverMonthVO.setDateStr(monthStr);
            wmsStockTurnoverMonthVO.setDateTime(dateTime);
            if (dateTime.isAfter(localDateTimeNow)) {
               wmsStockTurnoverMonthVO.setInMete(BigDecimal.ZERO);
               wmsStockTurnoverMonthVO.setOutMete(BigDecimal.ZERO);
               wmsStockTurnoverMonthVO.setStockTurnover(BigDecimal.ZERO);
            } else {
               MonthTimeRange monthTimeRange = DateTimeUtil.getMonthTimeRange(dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
               BigDecimal beginMete = this.statisticsBeginPeriodService.getSumMeteNewOne(monthTimeRange, null, BasicClassEnum.getSteelNum(), workshopId, null);
               BigDecimal inboundMete = this.statisticsInboundService.getSumMeteNewOne(monthTimeRange, null, BasicClassEnum.getSteelNum(), workshopId);
               wmsStockTurnoverMonthVO.setInMete(inboundMete.divide(MILLION, 4, RoundingMode.HALF_UP));
               if (dateTime.isEqual(localDateTimeNow)) {
                  BigDecimal outboundMete = this.statisticsOutboundService.getSumMeteNewOne(monthTimeRange, null, BasicClassEnum.getSteelNum(), workshopId);
                  wmsStockTurnoverMonthVO.setOutMete(outboundMete.divide(MILLION, 4, RoundingMode.HALF_UP));
                  BigDecimal endPeriod = beginMete.add(inboundMete).subtract(outboundMete);
                  if (beginMete.compareTo(BigDecimal.ZERO) == 0 && endPeriod.compareTo(BigDecimal.ZERO) == 0) {
                     wmsStockTurnoverMonthVO.setStockTurnover(BigDecimal.ZERO);
                  } else {
                     BigDecimal stockTurnover = outboundMete.divide(
                        beginMete.add(endPeriod).divide(BigDecimal.valueOf(2L), 2, RoundingMode.HALF_UP), 2, RoundingMode.HALF_UP
                     );
                     wmsStockTurnoverMonthVO.setStockTurnover(stockTurnover);
                  }
               } else if (dateTime.isBefore(localDateTimeNow)) {
                  BigDecimal outboundMete = this.statisticsOutboundService.getSumMeteNewOne(monthTimeRange, null, BasicClassEnum.getSteelNum(), workshopId);
                  wmsStockTurnoverMonthVO.setOutMete(outboundMete.divide(MILLION, 4, RoundingMode.HALF_UP));
                  MonthTimeRange m = DateTimeUtil.getMonthTimeRange(
                     monthTimeRange.getEndTime().toLocalDate().plusMonths(1L).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                  );
                  BigDecimal endPeriodMete = this.statisticsBeginPeriodService.getSumMeteNewOne(m, null, BasicClassEnum.getSteelNum(), workshopId, null);
                  if (beginMete.compareTo(BigDecimal.ZERO) == 0 && beginMete.compareTo(BigDecimal.ZERO) == 0) {
                     wmsStockTurnoverMonthVO.setStockTurnover(BigDecimal.ZERO);
                  } else {
                     BigDecimal stockTurnover = outboundMete.divide(
                        beginMete.add(endPeriodMete).divide(BigDecimal.valueOf(2L), 2, RoundingMode.HALF_UP), 2, RoundingMode.HALF_UP
                     );
                     wmsStockTurnoverMonthVO.setStockTurnover(stockTurnover);
                  }
               }
            }

            wmsStockTurnoverMonthVOS.add(wmsStockTurnoverMonthVO);
         }

         List<WMSStockTurnoverMonthVO> collect = wmsStockTurnoverMonthVOS.stream()
            .filter(w -> ObjectUtil.notEqual(w.getDateStr(), dateTimeFormatter.format(LocalDateTime.now())))
            .collect(Collectors.toList());
         this.redisTemplate.opsForValue().set("warehouse_steel_stock_turnover-" + format + "-" + workshopId, JSON.toJSONString(collect), 1L, TimeUnit.DAYS);
         return wmsStockTurnoverMonthVOS;
      }
   }

   @Override
   public List<InboundAndOutboundDataDTO> inboundAndOutboundData(Long factoryId, Long workshopId) {
      LocalDateTime now = LocalDateTime.now();
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      String format = simpleDateFormat.format(new Date());
      Object o = this.redisTemplate.opsForValue().get("warehouse_inbound_and_outbound_data-" + format + "-" + workshopId);
      if (o != null) {
         return JSON.parseArray(o.toString(), InboundAndOutboundDataDTO.class);
      }

      LocalDateTime startDay = LocalDateTime.of(LocalDate.from(now.plusDays(-14L)), LocalDateTime.MIN.toLocalTime());
      LocalDateTime endDay = LocalDateTime.of(LocalDate.from(now), LocalDateTime.MAX.toLocalTime());
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      List<String> dateStrList = new ArrayList<>();
      List<LocalDateTime> dateTimeList = new ArrayList<>();

      for (int i = 0; i < 15; i++) {
         LocalDateTime localDateTime = startDay.plusDays(i);
         dateStrList.add(localDateTime.format(dateTimeFormatter));
         dateTimeList.add(localDateTime);
      }

      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      List<InboundDetailDO> inboundDetailDOS = this.inboundDetailService.selectPassDetail(workshopId, startDay, endDay);
      List<RejectDetailDO> rejectDetailDOS = this.rejectDetailService.selectPassDetail(workshopId, startDay, endDay);
      List<OutboundDetailDO> outboundDetailDOS = this.moveOutboundDetailService.selectPassDetail(workshopId, startDay, endDay, null, null);
      if (CollectionUtil.isNotEmpty(outboundDetailDOS)) {
         Map<Long, MonthWeightedAveragePrice> monthWeightedAveragePriceMap = new HashMap<>();
         List<Long> wapIds = outboundDetailDOS.stream().map(OutboundDetailDO::getWapId).filter(ObjectUtil::isNotEmpty).distinct().collect(Collectors.toList());
         List<MonthWeightedAveragePrice> monthWeightedAveragePriceList = this.monthWeightedAveragePriceService.listByIds(wapIds);
         if (CollectionUtil.isNotEmpty(wapIds)) {
            monthWeightedAveragePriceMap = monthWeightedAveragePriceList.stream()
               .collect(Collectors.toMap(MonthWeightedAveragePrice::getId, Function.identity()));
         }

         Map<Long, WholeWeightedAveragePrice> wholeWeightedAveragePriceMap = new HashMap<>();
         if (CollectionUtil.isNotEmpty(monthWeightedAveragePriceList)) {
            List<Long> wholeWapId = monthWeightedAveragePriceList.stream()
               .map(MonthWeightedAveragePrice::getWholeWapId)
               .filter(ObjectUtil::isNotEmpty)
               .collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(wholeWapId)) {
               wholeWeightedAveragePriceMap = this.wholeWeightedAveragePriceService
                  .listByIds(wholeWapId)
                  .stream()
                  .collect(Collectors.toMap(WholeWeightedAveragePrice::getId, Function.identity()));
            }
         }

         for (OutboundDetailDO outboundDetailDO : outboundDetailDOS) {
            if (outboundDetailDO.getAmount() == null && outboundDetailDO.getAmountExcludingVAT() == null) {
               MonthWeightedAveragePrice price = monthWeightedAveragePriceMap.get(outboundDetailDO.getWapId());
               if (price != null) {
                  if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
                     WholeWeightedAveragePrice wholeWeightedAveragePrice = wholeWeightedAveragePriceMap.get(price.getWholeWapId());
                     price.setMete(wholeWeightedAveragePrice.getMete());
                     price.setAmount(wholeWeightedAveragePrice.getAmount());
                     price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
                  }

                  outboundDetailDO.setAmount(BigDecimal.ZERO);
                  outboundDetailDO.setAmountExcludingVAT(BigDecimal.ZERO);
                  if (price.getMete().compareTo(BigDecimal.ZERO) != 0) {
                     BigDecimal p = outboundDetailDO.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
                     BigDecimal amount = price.getAmount().multiply(p).setScale(2, RoundingMode.HALF_UP);
                     BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(2, RoundingMode.HALF_UP);
                     outboundDetailDO.setAmount(amount);
                     outboundDetailDO.setAmountExcludingVAT(amountExcludingVat);
                  }
               }
            }
         }
      }

      List<ReturnDetailDO> returnDetailDOS = this.returnDetailService.selectPassDetail(workshopId, startDay, endDay);
      if (CollectionUtil.isNotEmpty(returnDetailDOS)) {
         List<Long> materialReturnableIds = returnDetailDOS.stream().map(ReturnDetailDO::getMaterialReturnableId).collect(Collectors.toList());
         List<MaterialReturnable> materialReturnables = this.materialReturnableService.listByIds(materialReturnableIds);
         List<Long> outboundDetailIds = materialReturnables.stream().map(MaterialReturnable::getOutboundDetailId).collect(Collectors.toList());
         List<MoveOutboundDetail> moveOutboundDetails = this.moveOutboundDetailService.listByIds(outboundDetailIds);

         for (ReturnDetailDO returnDetailDO : returnDetailDOS) {
            MaterialReturnable materialReturnable = materialReturnables.stream()
               .filter(e -> e.getId().equals(returnDetailDO.getMaterialReturnableId()))
               .findAny()
               .orElse(null);
            if (returnDetailDO.getAmount() == null && returnDetailDO.getAmountExcludingVAT() == null) {
               MoveOutboundDetail moveOutboundDetail = moveOutboundDetails.stream()
                  .filter(e -> e.getId().equals(materialReturnable.getOutboundDetailId()))
                  .findAny()
                  .orElse(null);
               if (moveOutboundDetail != null && moveOutboundDetail.getAmount() == null && moveOutboundDetail.getAmountExcludingVat() == null) {
                  MonthWeightedAveragePrice price = this.monthWAPMapper.getPriceById(moveOutboundDetail.getWapId());
                  if (price != null) {
                     if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
                        WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWAPMapper.selectById(price.getWholeWapId());
                        price.setMete(wholeWeightedAveragePrice.getMete());
                        price.setAmount(wholeWeightedAveragePrice.getAmount());
                        price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
                     }

                     if (price.getMete().compareTo(BigDecimal.ZERO) != 0) {
                        BigDecimal p = moveOutboundDetail.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
                        BigDecimal amount = price.getAmount().multiply(p).setScale(2, RoundingMode.HALF_UP);
                        BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(2, RoundingMode.HALF_UP);
                        BigDecimal p1 = returnDetailDO.getMete().divide(materialReturnable.getMete(), 20, RoundingMode.HALF_UP);
                        BigDecimal amount1 = amount.multiply(p1).setScale(2, RoundingMode.HALF_UP);
                        BigDecimal amountExcludingVat1 = amountExcludingVat.multiply(p1).setScale(2, RoundingMode.HALF_UP);
                        returnDetailDO.setAmount(amount1);
                        returnDetailDO.setAmountExcludingVAT(amountExcludingVat1);
                     }
                  }
               }
            }
         }
      }

      List<InboundAndOutboundDataDTO> inboundAndOutboundDataDTOS = new ArrayList<>();

      for (String dateStr : dateStrList) {
         InboundAndOutboundDataDTO inboundAndOutboundDataDTO = new InboundAndOutboundDataDTO();
         BigDecimal inboundAmount = inboundDetailDOS.stream()
            .filter(i -> ObjectUtil.equals(dateTimeFormatter.format(i.getInboundTime()), dateStr) && ObjectUtil.isNotEmpty(i.getAmountExcludingVat()))
            .map(InboundDetailDO::getAmountExcludingVat)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal rejectAmount = rejectDetailDOS.stream()
            .filter(i -> ObjectUtil.equals(dateTimeFormatter.format(i.getReviewTime()), dateStr) && ObjectUtil.isNotEmpty(i.getAmountExcludingVAT()))
            .map(RejectDetailDO::getAmountExcludingVAT)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         inboundAndOutboundDataDTO.setDateStr(dateStr);
         inboundAndOutboundDataDTO.setInboundAmount(inboundAmount.subtract(rejectAmount));
         List<OutboundDetailDO> collect = outboundDetailDOS.stream().filter(i -> ObjectUtil.isEmpty(i.getAmountExcludingVAT())).collect(Collectors.toList());
         BigDecimal outboundAmount = outboundDetailDOS.stream()
            .filter(i -> ObjectUtil.equals(dateTimeFormatter.format(i.getReviewTime()), dateStr) && ObjectUtil.isNotEmpty(i.getAmountExcludingVAT()))
            .map(OutboundDetailDO::getAmountExcludingVAT)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal returnAmount = returnDetailDOS.stream()
            .filter(i -> ObjectUtil.equals(dateTimeFormatter.format(i.getReviewTime()), dateStr) && ObjectUtil.isNotEmpty(i.getAmountExcludingVAT()))
            .map(ReturnDetailDO::getAmountExcludingVAT)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         inboundAndOutboundDataDTO.setOutboundAmount(outboundAmount.subtract(returnAmount));
         inboundAndOutboundDataDTOS.add(inboundAndOutboundDataDTO);
      }

      inboundAndOutboundDataDTOS.forEach(i -> {
         i.setInboundAmount(i.getInboundAmount().divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP));
         i.setOutboundAmount(i.getOutboundAmount().divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP));
      });
      this.redisTemplate
         .opsForValue()
         .set("warehouse_inbound_and_outbound_data-" + format + "-" + workshopId, JSON.toJSONString(inboundAndOutboundDataDTOS), 24L, TimeUnit.HOURS);
      return inboundAndOutboundDataDTOS;
   }

   @Override
   public List<ProjectSteelCountDTO> projectSteelCount(Long factoryId, Long workshopId) {
      Object o1 = this.redisTemplate.opsForValue().get("warehouse_project_steel_count-" + workshopId);
      if (o1 != null) {
         return JSON.parseArray(o1.toString(), ProjectSteelCountDTO.class);
      }

      List<ContractProject> projectList = this.contractProjectService
         .list((Wrapper<ContractProject>)new LambdaQueryWrapper<ContractProject>().eq(ContractProject::getStatus, ProjectStatusEnum.PROCESSING.getType()));
      if (CollectionUtils.isEmpty(projectList)) {
         return new ArrayList<>();
      }

      List<Long> projectIds = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      List<TechArtifact> techArtifacts = this.techArtifactService
         .list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().in(TechArtifact::getProjectId, projectIds));
      List<OutboundDetailDO> outboundDetailDOS = this.moveOutboundDetailService
         .selectPassDetail(workshopId, null, null, projectIds, BasicClassEnum.getSteelNum());
      LocalDateTime startDay = LocalDateTime.of(LocalDate.from(LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth())), LocalTime.MIN);
      List<ProjectSteelCountDTO> projectSteelCountDTOS = new ArrayList<>();

      for (ContractProject contractProject : projectList) {
         List<TechArtifact> techArtifactList = techArtifacts.stream()
            .filter(t -> t.getProjectId().equals(contractProject.getId()))
            .collect(Collectors.toList());
         BigDecimal techArtifactMete = techArtifactList.stream()
            .map(t -> t.getNetWeight().multiply(new BigDecimal(t.getQuantity())))
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(THOUSAND, 4, RoundingMode.HALF_UP);
         List<OutboundDetailDO> outboundDetailDOList = outboundDetailDOS.stream()
            .filter(o -> o.getProjectId().equals(contractProject.getId()))
            .collect(Collectors.toList());
         BigDecimal outboundMete = outboundDetailDOList.stream()
            .map(OutboundDetailDO::getMete)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(MILLION, 4, RoundingMode.HALF_UP);
         BigDecimal reduce = outboundDetailDOList.stream()
            .filter(o -> ObjectUtil.isNotEmpty(o.getReviewTime()) && o.getReviewTime().isAfter(startDay))
            .collect(Collectors.toList())
            .stream()
            .map(OutboundDetailDO::getMete)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(MILLION, 4, RoundingMode.HALF_UP);
         ProjectSteelCountDTO projectSteelCountDTO = new ProjectSteelCountDTO();
         projectSteelCountDTO.setProjectName(contractProject.getShortName());
         projectSteelCountDTO.setTechArtifactMete(techArtifactMete);
         projectSteelCountDTO.setOutboundMete(outboundMete);
         projectSteelCountDTO.setOutboundMeteThisMonth(reduce);
         projectSteelCountDTOS.add(projectSteelCountDTO);
      }

      this.redisTemplate.opsForValue().set("warehouse_project_steel_count-" + workshopId, JSON.toJSONString(projectSteelCountDTOS), 10L, TimeUnit.MINUTES);
      return projectSteelCountDTOS;
   }

   @Override
   public List<InstantMessageHintDTO> instantMessageHint(Long factoryId, Long workshopId) {
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      Object o = this.redisTemplate.opsForValue().get("instant_message_hint");
      List<InstantMessageHintDTO> instantMessageHintDTOS = ObjectUtil.isNotEmpty(o)
         ? JSON.parseArray(o.toString(), InstantMessageHintDTO.class)
         : new ArrayList<>();
      instantMessageHintDTOS = instantMessageHintDTOS.stream()
         .filter(
            i -> ObjectUtil.isNotEmpty(i.getExpireTime())
               && LocalDateTime.parse(i.getExpireTime(), dateTimeFormatter).isAfter(LocalDateTime.now())
               && (
                  ObjectUtil.isEmpty(workshopId)
                     || ObjectUtil.isEmpty(i.getWorkshopId())
                     || ObjectUtil.isNotEmpty(i.getWorkshopId()) && i.getWorkshopId().contains(workshopId)
               )
         )
         .collect(Collectors.toList());
      PageVO<InventoryReminderDTO> reminder = this.warningService.getReminder();
      if (CollectionUtil.isNotEmpty(reminder.getContent())) {
         List<Long> classifyIds = reminder.getContent().stream().map(InventoryReminderDTO::getClassifyId).collect(Collectors.toList());
         Map<String, Unit> unitMap = this.unitMapper.selectList(null).stream().collect(Collectors.toMap(Unit::getName, Function.identity()));
         Map<Long, Measure> measureMap = this.queryUtilService.getMeasureMapByClassifyIds(classifyIds);
         List<InstantMessageHintDTO> collect = reminder.getContent()
            .stream()
            .filter(r -> ObjectUtil.isEmpty(workshopId) || r.getWorkshopId().equals(workshopId))
            .map(r -> {
               Measure measure = measureMap.get(r.getClassifyId());
               InstantMessageHintDTO instantMessageHintDTO = new InstantMessageHintDTO();
               instantMessageHintDTO.setType(MessageEnum.INVENTORY_WARNING.getType());
               instantMessageHintDTO.setTypeName(MessageEnum.INVENTORY_WARNING.getName());
               instantMessageHintDTO.setClassifyCode(r.getClassifyCode());
               instantMessageHintDTO.setClassifyName(r.getClassifyName());
               instantMessageHintDTO.setSpec(r.getSpecification());
               BigDecimal inventoryRequirements = new BigDecimal("0");
               BigDecimal inventory = new BigDecimal("0");
               Unit unit = unitMap.get(r.getUnit());
               if (unit.getType().equals(UnitEnum.DIGIT.getType())) {
                  inventoryRequirements = r.getMinimumInventory();
                  inventory = r.getInventory();
               } else if (unit.getType().equals(UnitEnum.WEIGHT.getType())) {
                  if (unit.getName().equals("克")) {
                     inventoryRequirements = r.getMinimumInventory();
                     inventory = r.getInventory();
                  } else if (unit.getName().equals("千克")) {
                     inventoryRequirements = r.getMinimumInventory().divide(UnitsPrecisionEnum.EG_KG.getRate());
                     inventory = r.getInventory().divide(UnitsPrecisionEnum.EG_KG.getRate());
                  } else if (unit.getName().equals("吨")) {
                     inventoryRequirements = r.getMinimumInventory().divide(UnitsPrecisionEnum.EG_T.getRate());
                     inventory = r.getInventory().divide(UnitsPrecisionEnum.EG_T.getRate());
                  } else {
                     inventoryRequirements = r.getMinimumInventory();
                     inventory = r.getInventory();
                  }
               } else if (unit.getType().equals(UnitEnum.LENGTH.getType())) {
                  if (unit.getName().equals("毫米")) {
                     inventoryRequirements = r.getMinimumInventory();
                     inventory = r.getInventory();
                  } else if (unit.getName().equals("厘米")) {
                     inventoryRequirements = r.getMinimumInventory().divide(UnitsPrecisionEnum.LG_CM.getRate());
                     inventory = r.getInventory().divide(UnitsPrecisionEnum.LG_CM.getRate());
                  } else if (unit.getName().equals("分米")) {
                     inventoryRequirements = r.getMinimumInventory().divide(UnitsPrecisionEnum.LG_DM.getRate());
                     inventory = r.getInventory().divide(UnitsPrecisionEnum.LG_DM.getRate());
                  } else if (unit.getName().equals("米")) {
                     inventoryRequirements = r.getMinimumInventory().divide(UnitsPrecisionEnum.LG_M.getRate());
                     inventory = r.getInventory().divide(UnitsPrecisionEnum.LG_M.getRate());
                  } else if (unit.getName().equals("千米")) {
                     inventoryRequirements = r.getMinimumInventory().divide(UnitsPrecisionEnum.LG_KM.getRate());
                     inventory = r.getInventory().divide(UnitsPrecisionEnum.LG_KM.getRate());
                  } else {
                     inventoryRequirements = r.getMinimumInventory();
                     inventory = r.getInventory();
                  }
               } else if (unit.getType().equals(UnitEnum.AREA.getType())) {
                  if (unit.getName().equals("平方毫米")) {
                     inventoryRequirements = r.getMinimumInventory();
                     inventory = r.getInventory();
                  } else if (unit.getName().equals("平方厘米")) {
                     inventoryRequirements = r.getMinimumInventory().divide(UnitsPrecisionEnum.AG_CM.getRate());
                     inventory = r.getInventory().divide(UnitsPrecisionEnum.AG_CM.getRate());
                  } else if (unit.getName().equals("平方分米")) {
                     inventoryRequirements = r.getMinimumInventory().divide(UnitsPrecisionEnum.AG_DM.getRate());
                     inventory = r.getInventory().divide(UnitsPrecisionEnum.AG_DM.getRate());
                  } else if (unit.getName().equals("平方米")) {
                     inventoryRequirements = r.getMinimumInventory().divide(UnitsPrecisionEnum.AG_M.getRate());
                     inventory = r.getInventory().divide(UnitsPrecisionEnum.AG_M.getRate());
                  } else if (unit.getName().equals("公顷")) {
                     inventoryRequirements = r.getMinimumInventory().divide(UnitsPrecisionEnum.AG_HM.getRate());
                     inventory = r.getInventory().divide(UnitsPrecisionEnum.AG_HM.getRate());
                  } else if (unit.getName().equals("平方千米")) {
                     inventoryRequirements = r.getMinimumInventory().divide(UnitsPrecisionEnum.AG_KM.getRate());
                     inventory = r.getInventory().divide(UnitsPrecisionEnum.AG_KM.getRate());
                  } else {
                     inventoryRequirements = r.getMinimumInventory();
                     inventory = r.getInventory();
                  }
               } else if (unit.getType().equals(UnitEnum.VOLUME.getType())) {
                  if (unit.getName().equals("立方毫米")) {
                     inventoryRequirements = r.getMinimumInventory();
                     inventory = r.getInventory();
                  } else if (unit.getName().equals("立方厘米")) {
                     inventoryRequirements = r.getMinimumInventory().divide(UnitsPrecisionEnum.VG_CM.getRate());
                     inventory = r.getInventory().divide(UnitsPrecisionEnum.VG_CM.getRate());
                  } else if (unit.getName().equals("立方分米")) {
                     inventoryRequirements = r.getMinimumInventory().divide(UnitsPrecisionEnum.VG_DM.getRate());
                     inventory = r.getInventory().divide(UnitsPrecisionEnum.VG_DM.getRate());
                  } else if (unit.getName().equals("立方米")) {
                     inventoryRequirements = r.getMinimumInventory().divide(UnitsPrecisionEnum.VG_M.getRate());
                     inventory = r.getInventory().divide(UnitsPrecisionEnum.VG_M.getRate());
                  }

                  if (unit.getName().equals("微升")) {
                     inventoryRequirements = r.getMinimumInventory();
                     inventory = r.getInventory();
                  } else if (unit.getName().equals("毫升")) {
                     inventoryRequirements = r.getMinimumInventory().divide(UnitsPrecisionEnum.ML.getRate());
                     inventory = r.getInventory().divide(UnitsPrecisionEnum.ML.getRate());
                  } else if (unit.getName().equals("厘升")) {
                     inventoryRequirements = r.getMinimumInventory().divide(UnitsPrecisionEnum.CL.getRate());
                     inventory = r.getInventory().divide(UnitsPrecisionEnum.CL.getRate());
                  } else if (unit.getName().equals("分升")) {
                     inventoryRequirements = r.getMinimumInventory().divide(UnitsPrecisionEnum.DL.getRate());
                     inventory = r.getInventory().divide(UnitsPrecisionEnum.DL.getRate());
                  } else if (unit.getName().equals("升")) {
                     inventoryRequirements = r.getMinimumInventory().divide(UnitsPrecisionEnum.L.getRate());
                     inventory = r.getInventory().divide(UnitsPrecisionEnum.L.getRate());
                  }

                  if (ObjectUtil.isNotEmpty(measure.getAccountingUnit())) {
                     inventoryRequirements = r.getMinimumInventory();
                     inventory = r.getInventory();
                  }
               }

               instantMessageHintDTO.setInventoryRequirements(inventoryRequirements);
               instantMessageHintDTO.setInventory(inventory);
               instantMessageHintDTO.setUnit(r.getUnit());
               return instantMessageHintDTO;
            })
            .collect(Collectors.toList());
         instantMessageHintDTOS.addAll(collect);
      }

      AtomicInteger num = new AtomicInteger();
      instantMessageHintDTOS.stream().forEach(i -> i.setId((long)num.incrementAndGet()));
      this.redisTemplate.opsForValue().set("instant_message_hint", JSON.toJSONString(instantMessageHintDTOS));
      return instantMessageHintDTOS;
   }

   @Override
   public void saveInstantMessageHint(InstantMessageHintDTO instantMessageHintDTO) {
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      List<InstantMessageHintDTO> instantMessageHintDTOS = new ArrayList<>();
      Object o = this.redisTemplate.opsForValue().get("instant_message_hint");
      if (o != null) {
         instantMessageHintDTOS = JSON.parseArray(o.toString(), InstantMessageHintDTO.class);
      }

      if (!instantMessageHintDTO.getType().equals(MessageEnum.INVENTORY_WARNING.getType())) {
         if (instantMessageHintDTO.getType().equals(MessageEnum.PURCHASE_ORDER.getType())) {
            List<InstantMessageHintDTO> collect = instantMessageHintDTOS.stream()
               .filter(
                  i -> i.getType().equals(MessageEnum.PURCHASE_ORDER.getType())
                     && ObjectUtil.equals(instantMessageHintDTO.getOldSerialNumber(), i.getSerialNumber())
               )
               .collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(collect)) {
               instantMessageHintDTOS.removeAll(collect);
            }

            instantMessageHintDTO.setOldSerialNumber(null);
            instantMessageHintDTO.setExpireTime(dateTimeFormatter.format(LocalDateTime.now().plusHours(12L)));
         } else if (instantMessageHintDTO.getType().equals(MessageEnum.FREEZE_INFORMATION.getType())) {
            instantMessageHintDTO.setExpireTime(dateTimeFormatter.format(LocalDateTime.now().plusHours(24L)));
         } else if (instantMessageHintDTO.getType().equals(MessageEnum.RETURN_INVENTORY_INFORMATION.getType())) {
            instantMessageHintDTO.setExpireTime(dateTimeFormatter.format(LocalDateTime.now().plusHours(24L)));
         } else if (instantMessageHintDTO.getType().equals(MessageEnum.APPLICATION_INFORMATION.getType())) {
            instantMessageHintDTO.setExpireTime(dateTimeFormatter.format(LocalDateTime.now().plusHours(12L)));
         }
      }

      instantMessageHintDTOS.add(instantMessageHintDTO);
      this.redisTemplate.opsForValue().set("instant_message_hint", JSON.toJSONString(instantMessageHintDTOS));
   }

   @Override
   public void delInstantMessageHint(InstantMessageHintDTO instantMessageHintDTO) {
      List<InstantMessageHintDTO> instantMessageHintDTOS = new ArrayList<>();
      Object o = this.redisTemplate.opsForValue().get("instant_message_hint");
      if (o != null) {
         instantMessageHintDTOS = JSON.parseArray(o.toString(), InstantMessageHintDTO.class);
      }

      if (!instantMessageHintDTO.getType().equals(MessageEnum.INVENTORY_WARNING.getType())) {
         if (instantMessageHintDTO.getType().equals(MessageEnum.PURCHASE_ORDER.getType())) {
            List<InstantMessageHintDTO> collect = instantMessageHintDTOS.stream()
               .filter(
                  i -> i.getType().equals(MessageEnum.PURCHASE_ORDER.getType())
                     && ObjectUtil.equals(instantMessageHintDTO.getSerialNumber(), i.getSerialNumber())
               )
               .collect(Collectors.toList());
            instantMessageHintDTOS.removeAll(collect);
         } else if (!instantMessageHintDTO.getType().equals(MessageEnum.FREEZE_INFORMATION.getType())
            && !instantMessageHintDTO.getType().equals(MessageEnum.RETURN_INVENTORY_INFORMATION.getType())
            && instantMessageHintDTO.getType().equals(MessageEnum.APPLICATION_INFORMATION.getType())) {
         }
      }

      this.redisTemplate.opsForValue().set("instant_message_hint", JSON.toJSONString(instantMessageHintDTOS));
   }

   @Override
   public List<MonthRealTimeInventoryAmountDTO> monthRealTimeInventoryAmount(Long factoryId, Long workshopId) {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
      String format = simpleDateFormat.format(new Date());
      Object o = this.redisTemplate.opsForValue().get("warehouse_month_realtime_inventory_amount-" + format + "-" + workshopId);
      if (o != null) {
         return JSON.parseArray(o.toString(), MonthRealTimeInventoryAmountDTO.class);
      }

      LocalDateTime now = LocalDateTime.now();
      MonthTimeRange monthTimeRangeThis = DateTimeUtil.getMonthTimeRange(now.toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
      List<MonthRealTimeInventoryAmountDTO> monthRealTimeInventoryAmountDTOS = new ArrayList<>();
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      List<MaterialInventoryDTO> materialInventoryDTOS = this.materialInventoryMapper
         .getTotalInventoryNew(BasicClassEnum.getSteelNum() | BasicClassEnum.GENERAL_MATERIAL.getType() | BasicClassEnum.OTHER.getType(), factoryId, workshopId)
         .stream()
         .peek(dto -> {
            MaterialInventory materialInventory = BeanUtil.copy(dto, MaterialInventory.class);
            MaterialInventory materialInventory1 = this.materialInventoryMapper.selectById(dto.getId());
            MonthWeightedAveragePrice price = this.monthWAPMapper.getPrice(materialInventory1);
            if (WeightedPriceEnum.WHOLE.getType().equals(weightedPriceConf.getWeightedType())) {
               WholeWeightedAveragePrice wholeWeightedAveragePrice = this.wholeWAPMapper.selectById(price.getWholeWapId());
               price.setMete(wholeWeightedAveragePrice.getMete());
               price.setAmount(wholeWeightedAveragePrice.getAmount());
               price.setAmountExcludingVat(wholeWeightedAveragePrice.getAmountExcludingVat());
            }

            BigDecimal p = dto.getMete().divide(price.getMete(), 20, RoundingMode.HALF_UP);
            BigDecimal amountx = price.getAmount().multiply(p).setScale(2, RoundingMode.HALF_UP);
            BigDecimal amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(2, RoundingMode.HALF_UP);
            BigDecimal avgPrice = NumberUtil.div(amountx, dto.getMete(), 12);
            BigDecimal excludingVatAvgPrice = NumberUtil.div(amountExcludingVat, dto.getMete(), 12);
            dto.setAmount(amountx);
            dto.setAmountExcludingVAT(amountExcludingVat);
            dto.setUnitPrice(avgPrice);
            dto.setUnitPriceExcludingVAT(excludingVatAvgPrice);
            if (dto.getProject() != null) {
               materialInventory.setProjectId(dto.getProject().getId());
            }

            if (dto.getWorkshop() != null) {
               materialInventory.setWorkshopId(dto.getWorkshop().getId());
            }
         })
         .collect(Collectors.toList());
      MonthRealTimeInventoryAmountDTO monthRealTimeInventoryAmountDTO = new MonthRealTimeInventoryAmountDTO();
      BigDecimal beginPeriod = this.statisticsBeginPeriodService
         .getSumAmountNewOne(monthTimeRangeThis, null, BasicClassEnum.getSteelNum(), workshopId, null)
         .divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP);
      BigDecimal amount = materialInventoryDTOS.stream()
         .filter(dto -> (dto.getBasicClass() & BasicClassEnum.getSteelNum()) > 0)
         .map(MaterialInventoryDTO::getAmountExcludingVAT)
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP);
      monthRealTimeInventoryAmountDTO.setAmount(amount);
      monthRealTimeInventoryAmountDTO.setBasicClass("钢材");
      BigDecimal compareLastMonth = BigDecimal.ZERO;
      if (beginPeriod.compareTo(BigDecimal.ZERO) != 0) {
         compareLastMonth = monthRealTimeInventoryAmountDTO.getAmount().subtract(beginPeriod).divide(beginPeriod, 2, RoundingMode.HALF_UP);
      }

      monthRealTimeInventoryAmountDTO.setCompareLastMonth(compareLastMonth);
      monthRealTimeInventoryAmountDTOS.add(monthRealTimeInventoryAmountDTO);
      monthRealTimeInventoryAmountDTO = new MonthRealTimeInventoryAmountDTO();
      beginPeriod = this.statisticsBeginPeriodService
         .getSumAmountNewOne(monthTimeRangeThis, null, BasicClassEnum.GENERAL_MATERIAL.getType(), workshopId, null)
         .divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP);
      amount = materialInventoryDTOS.stream()
         .filter(dto -> (dto.getBasicClass() & BasicClassEnum.GENERAL_MATERIAL.getType()) > 0)
         .map(MaterialInventoryDTO::getAmountExcludingVAT)
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP);
      monthRealTimeInventoryAmountDTO.setAmount(amount);
      monthRealTimeInventoryAmountDTO.setBasicClass("辅材");
      compareLastMonth = BigDecimal.ZERO;
      if (beginPeriod.compareTo(BigDecimal.ZERO) != 0) {
         compareLastMonth = monthRealTimeInventoryAmountDTO.getAmount().subtract(beginPeriod).divide(beginPeriod, 2, RoundingMode.HALF_UP);
      }

      monthRealTimeInventoryAmountDTO.setCompareLastMonth(compareLastMonth);
      monthRealTimeInventoryAmountDTOS.add(monthRealTimeInventoryAmountDTO);
      monthRealTimeInventoryAmountDTO = new MonthRealTimeInventoryAmountDTO();
      beginPeriod = this.statisticsBeginPeriodService
         .getSumAmountNewOne(monthTimeRangeThis, null, BasicClassEnum.OTHER.getType(), workshopId, null)
         .divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP);
      amount = materialInventoryDTOS.stream()
         .filter(dto -> (dto.getBasicClass() & BasicClassEnum.OTHER.getType()) > 0)
         .map(MaterialInventoryDTO::getAmountExcludingVAT)
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .divide(TEN_THOUSAND, 4, RoundingMode.HALF_UP);
      monthRealTimeInventoryAmountDTO.setAmount(amount);
      monthRealTimeInventoryAmountDTO.setBasicClass("办公用品");
      compareLastMonth = BigDecimal.ZERO;
      if (beginPeriod.compareTo(BigDecimal.ZERO) != 0) {
         compareLastMonth = monthRealTimeInventoryAmountDTO.getAmount().subtract(beginPeriod).divide(beginPeriod, 2, RoundingMode.HALF_UP);
      }

      monthRealTimeInventoryAmountDTO.setCompareLastMonth(compareLastMonth);
      monthRealTimeInventoryAmountDTOS.add(monthRealTimeInventoryAmountDTO);
      this.redisTemplate
         .opsForValue()
         .set("warehouse_month_realtime_inventory_amount-" + format + "-" + workshopId, JSON.toJSONString(monthRealTimeInventoryAmountDTOS), 1L, TimeUnit.DAYS);
      return monthRealTimeInventoryAmountDTOS;
   }

   private Map<Long, BigDecimal> getReceiviedAmount(List<Long> purchaseIds) {
      Map<Long, BigDecimal> resultMap = new HashMap<>();
      if (CollectionUtils.isEmpty(purchaseIds)) {
         return resultMap;
      }

      Map<Long, List<PurchaseOrderDetail>> orderDetailMap = this.purchaseOrderDetailService
         .list(Wrappers.lambdaQuery(PurchaseOrderDetail.class).in(PurchaseOrderDetail::getPurchaseId, purchaseIds))
         .stream()
         .collect(Collectors.groupingBy(PurchaseOrderDetail::getPurchaseId));
      orderDetailMap.forEach(
         (purchaseId, orderDetailList) -> {
            BigDecimal purchaseOrderAmount = orderDetailList.stream()
               .filter(orderDetail -> orderDetail.getUnitPrice() != null)
               .filter(orderDetail -> orderDetail.getActualReceivedMete() != null)
               .map(orderDetail -> orderDetail.getActualReceivedMete().multiply(orderDetail.getUnitPrice()).setScale(2, 4))
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            resultMap.put(purchaseId, purchaseOrderAmount);
         }
      );
      return resultMap;
   }

   public Map<Long, BigDecimal> getOrderIdAdjustAmountMap(Collection<Long> orderIds) {
      List<Inbound> inboundList = this.inboundService
         .list(Wrappers.lambdaQuery(Inbound.class).eq(Inbound::getReviewStatus, ReviewStatusEnum.REVIEWED.getType()).in(Inbound::getPurchaseId, orderIds));
      if (inboundList.isEmpty()) {
         return Collections.emptyMap();
      }

      List<InboundDetail> inboundDetailList = this.inboundDetailService
         .list(Wrappers.lambdaQuery(InboundDetail.class).in(InboundDetail::getInboundId, inboundList.stream().map(Inbound::getId).collect(Collectors.toList())));
      Map<Long, BigDecimal> inboundDetailIdAdjustAmountMap = this.wmsAdjustDetailService
         .list(
            Wrappers.lambdaQuery(WmsAdjustDetail.class)
               .in(WmsAdjustDetail::getInboundDetailId, inboundDetailList.stream().map(InboundDetail::getId).collect(Collectors.toList()))
               .eq(WmsAdjustDetail::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
         )
         .stream()
         .filter(ad -> ad.getDifferentAmount() != null)
         .collect(
            Collectors.groupingBy(
               WmsAdjustDetail::getInboundDetailId, Collectors.reducing(BigDecimal.ZERO, WmsAdjustDetail::getDifferentAmount, BigDecimal::add)
            )
         );
      Map<Long, BigDecimal> inboundIdAdjustAmountMap = inboundDetailList.stream()
         .collect(
            Collectors.groupingBy(
               InboundDetail::getInboundId,
               Collectors.mapping(
                  de -> inboundDetailIdAdjustAmountMap.getOrDefault(de.getId(), BigDecimal.ZERO), Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
               )
            )
         );
      return inboundList.stream()
         .collect(
            Collectors.groupingBy(
               Inbound::getPurchaseId,
               Collectors.mapping(
                  in -> inboundIdAdjustAmountMap.getOrDefault(in.getId(), BigDecimal.ZERO), Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
               )
            )
         );
   }

   private static BigDecimal calculatePercentage(BigDecimal value, BigDecimal total) {
      return total.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : value.divide(total).multiply(ONE_HUNDRED);
   }

   private Map<Integer, BigDecimal> unitConversionV2(BigDecimal value, String unit, Integer scale, Map<String, Unit> unitMap) {
      Unit u = unitMap.get(unit);
      Map<Integer, BigDecimal> map = new HashMap<>();
      if (scale == null) {
         scale = 0;
      }

      if (UnitEnum.DIGIT.getType().equals(u.getType())) {
         map.put(2, BigDecimal.ONE);
         map.put(1, new BigDecimal(value.stripTrailingZeros().toPlainString()));
      } else {
         BigDecimal precision = UnitsPrecisionEnum.getByName(unit);
         map.put(1, value.divide(precision, scale, 4));
         map.put(2, precision);
      }

      return map;
   }
}
