package com.hzchum.scim.wms.core.utils;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchase;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchaseDetail;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseDetailService;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderDetailService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.biz.OutBoundServiceBiz;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.HalfModeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialLabelPrintTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialOutboundModeEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.enums.UnitEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicShowConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WasteConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedExecutionPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WmsMaterialCodeConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsEndPeriod;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.OutboundManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Print;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PrintDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Scrap;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPlantConvert;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPlantConvertDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.PriceDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.UnitService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarehouseService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarningService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WmsMaterialCodeConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeRecordService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.PrintService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WeightedAveragePriceService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsPlantConvertDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsPlantConvertService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.api.utils.WmsUtil;
import com.hzchum.scim.wms.core.mapper.wmsConfig.UnitMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsEndPeriodMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.InboundDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ReturnDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ScrapMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WholeWeightedAveragePriceMapper;
import com.hzchum.scim.common.core.api.enums.OutboundTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialFreezeTypeEnum;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class QueryUtilImpl implements QueryUtilService {
   @Resource
   ClassificationService classificationService;
   @Resource
   MesBuildingFactoryService factoryService;
   @Resource
   WarehouseService warehouseService;
   @Resource
   ContractProjectService contractProjectService;
   @Resource
   MaterialFreezeService materialFreezeService;
   @Resource
   MaterialFreezeRecordService materialFreezeRecordService;
   @Resource
   MeasureService measureService;
   @Resource
   SupplierService supplierService;
   @Resource
   PurchaseOrderService purchaseOrderService;
   @Resource
   WorkshopService workshopService;
   @Resource
   BranchCompanyService branchCompanyService;
   @Resource
   ApplyPurchaseService applyPurchaseService;
   @Resource
   UnitMapper unitMapper;
   @Resource
   PurchaseOrderDetailService purchaseOrderDetailService;
   @Resource
   ApplyPurchaseDetailService applyPurchaseDetailService;
   @Resource
   MonthWeightedAveragePriceMapper monthWAPMapper;
   @Resource
   WholeWeightedAveragePriceMapper wholeWeightedAveragePriceMapper;
   @Resource
   PlanMonomerService planMonomerService;
   @Resource
   PlanAreaService planAreaService;
   @Resource
   InboundManufacturedService inboundManufacturedService;
   @Resource
   OutboundManufacturedService outboundManufacturedService;
   @Resource
   ReturnManufacturedService returnManufacturedService;
   @Resource
   private BasicConfigService basicConfigService;
   @Resource
   private UnitService unitService;
   @Resource
   OutBoundServiceBiz outBoundServiceBiz;
   @Resource
   WeightedAveragePriceService weightedAveragePriceService;
   @Resource
   private RedisTemplate redisTemplate;
   @Resource
   InboundService inboundService;
   @Resource
   OutboundService outboundService;
   @Resource
   UserService userService;
   @Resource
   MesBuildingWorkshopService mesBuildingWorkshopService;
   @Resource
   InboundDetailMapper inboundDetailMapper;
   @Resource
   ReturnDetailMapper returnDetailMapper;
   @Resource
   MaterialInventoryMapper materialInventoryMapper;
   @Resource
   WmsMaterialCodeConfigService wmsMaterialCodeConfigService;
   RoundingMode ROUNDING = RoundingMode.HALF_UP;
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   WmsPlantConvertService wmsPlantConvertService;
   @Resource
   WmsPlantConvertDetailService wmsPlantConvertDetailService;
   @Resource
   MaterialInventoryService materialInventoryService;
   @Resource
   WarningService warningService;
   @Resource
   StatisticsMapper statisticsMapper;
   @Resource
   StatisticsEndPeriodMapper statisticsEndPeriodMapper;
   @Resource
   MoveOutboundDetailService outboundDetailService;
   @Resource
   ScrapMapper scrapMapper;
   @Resource
   PrintService printService;
   @Resource
   WmsUtil wmsUtil;

   @Override
   public Map<Long, PlanMonomer> getMonomerMapByIds(Collection<Long> list) {
      return CollectionUtil.isEmpty(list)
         ? new HashMap<>()
         : this.planMonomerService
            .list((Wrapper<PlanMonomer>)new LambdaQueryWrapper<PlanMonomer>().in(PlanMonomer::getId, list))
            .stream()
            .collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
   }

   @Override
   public Map<Long, PlanMonomer> getMonomerMapAll() {
      List<PlanMonomer> planMonomers = this.planMonomerService.list();
      return CollectionUtil.isEmpty(planMonomers) ? new HashMap<>() : planMonomers.stream().collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
   }

   @Override
   public Map<Long, PlanArea> getAreaMapByIds(Collection<Long> list) {
      return CollectionUtil.isEmpty(list)
         ? new HashMap<>()
         : this.planAreaService
            .list((Wrapper<PlanArea>)new LambdaQueryWrapper<PlanArea>().in(PlanArea::getId, list))
            .stream()
            .collect(Collectors.toMap(PlanArea::getId, Function.identity()));
   }

   @Override
   public Map<Long, PlanArea> getAreaMapAll() {
      List<PlanArea> planAreas = this.planAreaService.list();
      return CollectionUtil.isEmpty(planAreas) ? new HashMap<>() : planAreas.stream().collect(Collectors.toMap(PlanArea::getId, Function.identity()));
   }

   @Override
   public Map<Long, Classification> getClassificationMapByIds(Collection<Long> list) {
      return CollectionUtil.isEmpty(list)
         ? new HashMap<>()
         : this.classificationService
            .list((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().in(Classification::getId, list))
            .stream()
            .collect(Collectors.toMap(Classification::getId, Function.identity()));
   }

   @Override
   public Map<Long, Classification> getClassificationMap(List<Long> list) {
      return this.classificationService
         .list(new LambdaQueryWrapper<Classification>().in(CollectionUtil.isNotEmpty(list), Classification::getId, list))
         .stream()
         .collect(Collectors.toMap(Classification::getId, Function.identity()));
   }

   @Override
   public Map<Long, MesBuildingFactory> getFactoryMap(List<Long> list) {
      return this.factoryService
         .list(new LambdaQueryWrapper<MesBuildingFactory>().in(CollectionUtil.isNotEmpty(list), MesBuildingFactory::getId, list))
         .stream()
         .collect(Collectors.toMap(MesBuildingFactory::getId, Function.identity()));
   }

   @Override
   public Map<Long, Workshop> getWorkshopMapByIds(Collection<Long> list) {
      return CollectionUtil.isEmpty(list)
         ? new HashMap<>()
         : this.workshopService
            .list(new LambdaQueryWrapper<Workshop>().in(CollectionUtil.isNotEmpty(list), Workshop::getId, list))
            .stream()
            .collect(Collectors.toMap(Workshop::getId, Function.identity()));
   }

   @Override
   public Map<Long, Workshop> getWorkshopMap(List<Long> list) {
      return this.workshopService
         .list(new LambdaQueryWrapper<Workshop>().in(CollectionUtil.isNotEmpty(list), Workshop::getId, list))
         .stream()
         .collect(Collectors.toMap(Workshop::getId, Function.identity()));
   }

   @Override
   public Map<Long, Warehouse> getWarehouseMapByIds(Collection<Long> list) {
      return CollectionUtil.isEmpty(list)
         ? new HashMap<>()
         : this.warehouseService
            .list(new LambdaQueryWrapper<Warehouse>().in(CollectionUtil.isNotEmpty(list), Warehouse::getId, list))
            .stream()
            .collect(Collectors.toMap(Warehouse::getId, Function.identity()));
   }

   @Override
   public Map<Long, Warehouse> getWarehouseMap(List<Long> list) {
      return this.warehouseService
         .list(new LambdaQueryWrapper<Warehouse>().in(CollectionUtil.isNotEmpty(list), Warehouse::getId, list))
         .stream()
         .collect(Collectors.toMap(Warehouse::getId, Function.identity()));
   }

   @Override
   public Map<Long, ContractProject> getProjectMapByIds(Collection<Long> list) {
      return CollectionUtil.isEmpty(list)
         ? new HashMap<>()
         : this.contractProjectService
            .list((Wrapper<ContractProject>)new LambdaQueryWrapper<ContractProject>().in(ContractProject::getId, list))
            .stream()
            .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
   }

   @Override
   public Map<Long, ContractProject> getProjectMap(List<Long> list) {
      return this.contractProjectService
         .list(new LambdaQueryWrapper<ContractProject>().in(CollectionUtil.isNotEmpty(list), ContractProject::getId, list))
         .stream()
         .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
   }

   @Override
   public Map<Long, ProjectInfo> getProjectInfoMapByIds(Collection<Long> list) {
      return CollectionUtil.isEmpty(list)
         ? new HashMap<>()
         : this.contractProjectService.listInfoByIdList(list).stream().collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
   }

   @Override
   public Map<Long, MaterialFreeze> getMaterialFreezeMap(List<Long> list) {
      return this.materialFreezeService
         .list(new LambdaQueryWrapper<MaterialFreeze>().in(CollectionUtil.isNotEmpty(list), MaterialFreeze::getMaterialInventoryId, list))
         .stream()
         .collect(Collectors.toMap(MaterialFreeze::getMaterialInventoryId, Function.identity()));
   }

   @Override
   public Map<Long, List<MaterialFreezeRecord>> getMaterialFreezeRecordMap(Integer freezeType) {
      return this.materialFreezeRecordService
         .list((Wrapper<MaterialFreezeRecord>)new LambdaQueryWrapper<MaterialFreezeRecord>().eq(MaterialFreezeRecord::getFreezeType, freezeType))
         .stream()
         .collect(Collectors.groupingBy(MaterialFreezeRecord::getMaterialFreezeId));
   }

   @Override
   public Map<Long, Supplier> getSupplierMapByIds(Collection<Long> list) {
      return CollectionUtil.isEmpty(list)
         ? new HashMap<>()
         : this.supplierService
            .list((Wrapper<Supplier>)new LambdaQueryWrapper<Supplier>().in(Supplier::getId, list))
            .stream()
            .collect(Collectors.toMap(Supplier::getId, Function.identity()));
   }

   @Override
   public Map<Long, Supplier> getSupplierMap(List<Long> list) {
      return this.supplierService
         .list(new LambdaQueryWrapper<Supplier>().in(CollectionUtil.isNotEmpty(list), Supplier::getId, list))
         .stream()
         .collect(Collectors.toMap(Supplier::getId, Function.identity()));
   }

   @Override
   public Map<Long, PurchaseOrder> getPrchaseOrderMap(List<Long> list) {
      return this.purchaseOrderService.listAllByIds(list).stream().collect(Collectors.toMap(PurchaseOrder::getId, Function.identity()));
   }

   @Override
   public Map<Long, Measure> getMeasureMapByClassifyIds(Collection<Long> list) {
      return CollectionUtil.isEmpty(list)
         ? new HashMap<>()
         : this.measureService
            .list((Wrapper<Measure>)new LambdaQueryWrapper<Measure>().in(Measure::getClassificationId, list))
            .stream()
            .collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
   }

   @Override
   public Map<Long, Measure> getMeasureMap() {
      return this.measureService.list(new LambdaQueryWrapper<>()).stream().collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));
   }

   @Override
   public Map<Long, BranchCompany> getBranchCompanyMap(List<Long> list) {
      return this.branchCompanyService.list(new LambdaQueryWrapper<>()).stream().collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
   }

   @Override
   public Map<Long, ApplyPurchase> getApplyPurchaseMapByIds(Collection<Long> list) {
      return CollectionUtil.isEmpty(list)
         ? new HashMap<>()
         : this.applyPurchaseService
            .list((Wrapper<ApplyPurchase>)Wrappers.<ApplyPurchase>lambdaQuery().in(ApplyPurchase::getId, list))
            .stream()
            .collect(Collectors.toMap(ApplyPurchase::getId, Function.identity()));
   }

   @Override
   public Map<Long, ApplyPurchase> getApplyPurchaseMap(List<Long> list) {
      return this.applyPurchaseService
         .list(new LambdaQueryWrapper<ApplyPurchase>().in(CollectionUtil.isNotEmpty(list), ApplyPurchase::getId, list))
         .stream()
         .collect(Collectors.toMap(ApplyPurchase::getId, Function.identity()));
   }

   @Override
   public Map<Long, PurchaseOrder> getPurchaseOrderMapByIds(Collection<Long> list) {
      if (CollectionUtil.isEmpty(list)) {
         return new HashMap<>();
      }

      List<PurchaseOrder> purchaseOrders = this.purchaseOrderService.list((Wrapper<PurchaseOrder>)Wrappers.<PurchaseOrder>lambdaQuery().in(PurchaseOrder::getId, list));
      return purchaseOrders.stream().collect(Collectors.toMap(PurchaseOrder::getId, Function.identity()));
   }

   @Override
   public List<PurchaseOrderDetail> getPurchaseOrderDetail(List<Long> list) {
      return this.purchaseOrderDetailService.list(Wrappers.<PurchaseOrderDetail>lambdaQuery().in(CollectionUtil.isNotEmpty(list), PurchaseOrderDetail::getPurchaseId, list));
   }

   @Override
   public Map<Long, ApplyPurchaseDetail> getApplyPurchaseDetailMap(List<Long> list) {
      return this.applyPurchaseDetailService
         .list(new LambdaQueryWrapper<ApplyPurchaseDetail>().in(CollectionUtil.isNotEmpty(list), ApplyPurchaseDetail::getId, list))
         .stream()
         .collect(Collectors.toMap(ApplyPurchaseDetail::getId, Function.identity()));
   }

   @Override
   public Map<Long, MonthWeightedAveragePrice> getMonthWeightedAveragePriceMap(List<Long> list) {
      return this.monthWAPMapper
         .selectList(new LambdaQueryWrapper<MonthWeightedAveragePrice>().in(CollectionUtil.isNotEmpty(list), MonthWeightedAveragePrice::getId, list))
         .stream()
         .collect(Collectors.toMap(MonthWeightedAveragePrice::getId, Function.identity()));
   }

   @Override
   public Map<Long, WholeWeightedAveragePrice> getWholeWeightedAveragePriceMap(List<Long> list) {
      return this.wholeWeightedAveragePriceMapper
         .selectList(new LambdaQueryWrapper<WholeWeightedAveragePrice>().in(CollectionUtil.isNotEmpty(list), WholeWeightedAveragePrice::getId, list))
         .stream()
         .collect(Collectors.toMap(WholeWeightedAveragePrice::getId, Function.identity()));
   }

   public Map<String, Unit> getUnitMap(List<Long> list) {
      return this.unitMapper
         .selectList(new LambdaQueryWrapper<Unit>().in(CollectionUtil.isNotEmpty(list), Unit::getId, list))
         .stream()
         .collect(Collectors.toMap(Unit::getName, Function.identity()));
   }

   public Map<Integer, BigDecimal> unitConversionV2(BigDecimal value, String unit, Integer scale, Map<String, Unit> unitMap) {
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

   @Override
   public List<Long> getLateClassificationList(List<Long> list) {
      ArrayList<Long> ids = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(list)) {
         List<Classification> classifications = this.classificationService.listByIds(list);
         classifications.forEach(
            classification -> {
               if (!classification.getBoolLastEnum()) {
                  List<Long> collect = this.classificationService
                     .getLastSubject(classification.getId())
                     .stream()
                     .map(Classification::getId)
                     .collect(Collectors.toList());
                  ids.addAll(collect);
               } else {
                  ids.add(classification.getId());
               }
            }
         );
      }

      return ids;
   }

   @Override
   public Map<Long, InboundManufactured> getInboundManufacturedMapByIds(Collection<Long> list) {
      if (CollectionUtil.isEmpty(list)) {
         return new HashMap<>();
      }

      List<InboundManufactured> inboundManufactureds = this.inboundManufacturedService
         .list((Wrapper<InboundManufactured>)new LambdaQueryWrapper<InboundManufactured>().in(InboundManufactured::getId, list));
      return inboundManufactureds.stream().collect(Collectors.toMap(InboundManufactured::getId, Function.identity()));
   }

   @Override
   public Map<Long, OutboundManufactured> getOutboundManufacturedMapByIds(Collection<Long> list) {
      return CollectionUtil.isEmpty(list)
         ? new HashMap<>()
         : this.outboundManufacturedService
            .list((Wrapper<OutboundManufactured>)new LambdaQueryWrapper<OutboundManufactured>().in(OutboundManufactured::getId, list))
            .stream()
            .collect(Collectors.toMap(OutboundManufactured::getId, Function.identity()));
   }

   @Override
   public Map<Long, ReturnManufactured> getReturnManufacturedMapByIds(Collection<Long> list) {
      return CollectionUtil.isEmpty(list)
         ? new HashMap<>()
         : this.returnManufacturedService
            .list((Wrapper<ReturnManufactured>)new LambdaQueryWrapper<ReturnManufactured>().in(ReturnManufactured::getId, list))
            .stream()
            .collect(Collectors.toMap(ReturnManufactured::getId, Function.identity()));
   }

   @Override
   public String getConfigShowSpec(String jsonStr, BasicShowConfig basicShowConfig) {
      StringBuilder sb = new StringBuilder();
      JSONObject detailsJson = JSON.parseObject(jsonStr);
      String thickness = detailsJson.getString("thickness") != null ? detailsJson.getBigDecimal("thickness").stripTrailingZeros().toPlainString() : "";
      String width = detailsJson.getString("width") != null ? detailsJson.getBigDecimal("width").stripTrailingZeros().toPlainString() : "";
      String length = detailsJson.getString("length") != null ? detailsJson.getBigDecimal("length").stripTrailingZeros().toPlainString() : "";
      String specification = StrUtil.isNotBlank(detailsJson.getString("specification")) ? detailsJson.getString("specification").trim() : "";
      String color = StrUtil.isNotBlank(detailsJson.getString("color")) ? detailsJson.getString("color").trim() : "";
      Integer basicClass = detailsJson.getInteger("basicClass") != null ? detailsJson.getInteger("basicClass") : 0;
      Long classifyId = detailsJson.getLong("classifyId") != null ? detailsJson.getLong("classifyId") : null;
      String symbol = " * ";
      if (BasicClassEnum.STEEL_PLATE.getType().equals(basicClass)) {
         sb.append(thickness);
         if (StrUtil.isNotBlank(width)) {
            sb.append("*").append(width);
         }

         if (StrUtil.isNotBlank(length)) {
            sb.append("*").append(length);
         }
      } else if (BasicClassEnum.SECTION_STEEL.getType().equals(basicClass)) {
         if (length != null) {
            sb.append(length);
         }
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(basicClass)) {
         if (classifyId != null) {
            SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(classifyId);
            Map<Integer, BigDecimal> accuracyMap = this.unitConversion(
               BigDecimal.ZERO, subjectMeasureDTO.getMeasureUnit(), subjectMeasureDTO.getMeasurePrecision()
            );
            BigDecimal quantity = detailsJson.getBigDecimal("quantity") != null ? detailsJson.getBigDecimal("quantity").stripTrailingZeros() : null;
            if (quantity != null) {
               BigDecimal halfUpQuantity = quantity.divide(accuracyMap.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
               length = halfUpQuantity.stripTrailingZeros().toPlainString();
            }
         }

         sb.append(thickness);
         if (width != null) {
            sb.append("*").append(width);
         }

         if (length != null) {
            sb.append("*").append(length);
         }
      } else if (BasicClassEnum.checkNotSteel(basicClass) && specification != null) {
         sb.append(specification);
      }

      if (BasicClassEnum.checkIsSteel(basicClass)) {
         if (basicShowConfig.getSteelsSpeShowConfig().equals(1)) {
            if (specification != null) {
               sb.append(symbol).append(specification);
            }
         } else if (specification != null) {
            sb.insert(0, symbol).insert(0, specification);
         }

         if (BasicClassEnum.COLOR_ROLL.getType().equals(basicClass) && ObjectUtil.isNotEmpty(color)) {
            sb.append(symbol).append(color);
         }
      }

      return sb.toString();
   }

   @Override
   public Map<Long, User> getUserMapByIds(Collection<Long> list) {
      return CollectionUtil.isEmpty(list)
         ? new HashMap<>()
         : this.userService.listByIds(list).stream().collect(Collectors.toMap(User::getId, Function.identity()));
   }

   @Override
   public Map<Long, MesBuildingWorkshop> getMesWorkshopByIds(Collection<Long> list) {
      return CollectionUtil.isEmpty(list)
         ? new HashMap<>()
         : this.mesBuildingWorkshopService.listByIds(list).stream().collect(Collectors.toMap(MesBuildingWorkshop::getId, Function.identity()));
   }

   @Override
   public BigDecimal getMete(SubjectMeasureDTO subjectMeasureDTO, BigDecimal mete) {
      Integer accountingPrecision = subjectMeasureDTO.getAccountingPrecision();
      BigDecimal unitsPrecision = UnitsPrecisionEnum.getByName(subjectMeasureDTO.getAccountingUnit());
      return mete.divide(unitsPrecision, accountingPrecision, this.ROUNDING).multiply(unitsPrecision);
   }

   @Override
   public String getSurplusSn() {
      Integer count = this.materialInventoryMapper.getCount(LocalDateTime.now());
      LocalDate today = LocalDate.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      String formattedDate = today.format(formatter);
      int i = count + 1;
      return "余" + formattedDate + "-" + i;
   }

   @Override
   public Map<Long, WmsMaterialCodeConfig> getMaterialCodeConfigMap(Collection<Long> list) {
      return this.wmsMaterialCodeConfigService
         .list(new LambdaQueryWrapper<WmsMaterialCodeConfig>().in(CollectionUtil.isNotEmpty(list), WmsMaterialCodeConfig::getId, list))
         .stream()
         .collect(Collectors.toMap(WmsMaterialCodeConfig::getId, Function.identity()));
   }

   @Override
   public Map<String, WmsMaterialCodeConfig> getMaterialCodeConfigMaps(Collection<Long> list) {
      List<WmsMaterialCodeConfig> list1 = this.wmsMaterialCodeConfigService.list(new LambdaQueryWrapper<>());
      return list1.stream()
         .collect(
            Collectors.toMap(
               config -> this.buildCompositeKey(config.getClassifyId(), config.getSpecification(), config.getThickness()),
               config -> (WmsMaterialCodeConfig)config,
               (existing, replacement) -> existing
            )
         );
   }

   public String buildCompositeKey(Long classifyId, String specification, BigDecimal thickness) {
      String stringThickness = null;
      if (null != thickness) {
         stringThickness = thickness.toPlainString();
         stringThickness = stringThickness.replaceAll("(?<=\\.)0+$", "");
         stringThickness = stringThickness.replaceAll("\\.$", "");
      }

      return String.join("-", String.valueOf(classifyId), specification != null ? specification : "", stringThickness != null ? stringThickness : "");
   }

   private Map<Integer, BigDecimal> unitConversion(BigDecimal value, String unit, Integer scale) {
      Unit u = this.unitService.getOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, unit));
      Map<Integer, BigDecimal> map = new HashMap<>();
      if (UnitEnum.DIGIT.getType().equals(u.getType())) {
         map.put(2, BigDecimal.ONE);
         map.put(1, value.stripTrailingZeros());
      } else {
         BigDecimal precision = UnitsPrecisionEnum.getByName(unit);
         map.put(1, value.divide(precision, scale, 4));
         map.put(2, precision);
      }

      return map;
   }

   @Override
   public Integer createInboundSerialNumber(String tableNameKey) {
      String yyyy_mm_dd = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
      String key = MessageFormat.format("{0}:{1}", tableNameKey, yyyy_mm_dd);
      Boolean hasKey = this.redisTemplate.hasKey(key);
      Long increment;
      if (hasKey) {
         increment = this.redisTemplate.opsForValue().increment(key, 1L);
      } else {
         LocalDate today = LocalDate.now();
         LocalDateTime startOfDay = today.atStartOfDay();
         LocalDateTime endOfDay = today.atTime(LocalTime.MAX);
         int count = 0;
         if ("inbound".equals(tableNameKey)) {
            count = this.inboundService.count((Wrapper<Inbound>)new LambdaQueryWrapper<Inbound>().between(BaseEntity::getCreateTime, startOfDay, endOfDay));
         } else if ("outbound".equals(tableNameKey)) {
            count = this.outboundService.count((Wrapper<Outbound>)new LambdaQueryWrapper<Outbound>().between(BaseEntity::getCreateTime, startOfDay, endOfDay));
         }

         this.redisTemplate.opsForValue().set(key, count);
         this.redisTemplate.expire(key, 24L, TimeUnit.HOURS);
         increment = (long)count;
      }

      return increment.intValue();
   }

   private void checkHalfOutputDimensions(MoveOutboundDetail detail) {
      WasteConfig waste = this.basicConfigService.getSteelScrapDefinitionConf();
      boolean isScrap = BasicClassEnum.STEEL_PLATE.getType().equals(detail.getBasicClass())
         ? detail.getLength().compareTo(waste.getSteelPlateShortestSideMinLength()) <= 0
            || detail.getWidth().compareTo(waste.getSteelPlateShortestSideMinLength()) <= 0
         : detail.getLength().compareTo(waste.getSectionSteelMinLength()) <= 0;
      Preconditions.checkArgument(!isScrap, "截取尺寸低于废料标准，不能作为原料出库");
   }

   private BigDecimal getHalfSourceMete(Outbound outbound, MoveOutboundDetail detail, MaterialInventory inventory, Integer freezeType) {
      this.checkHalfOutputDimensions(detail);
      MaterialFreezeRecord source = this.materialFreezeRecordService.getOne(
         Wrappers.<MaterialFreezeRecord>lambdaQuery().eq(MaterialFreezeRecord::getFreezeSourceId, outbound.getId())
            .eq(MaterialFreezeRecord::getFreezeDetailId, detail.getId()).eq(MaterialFreezeRecord::getFreezeType, freezeType)
      );
      Preconditions.checkArgument(
         source != null && source.getMete() != null && source.getQuantity() != null && detail.getQuantity() != null
            && detail.getQuantity().signum() > 0 && source.getQuantity().compareTo(detail.getQuantity()) == 0
            && source.getMete().stripTrailingZeros().scale() <= 8 && source.getMete().signum() > 0
            && source.getMete().compareTo(inventory.getMete()) <= 0 && source.getQuantity().compareTo(inventory.getQuantity()) <= 0
            && detail.getMete() != null && detail.getMete().signum() > 0 && detail.getMete().compareTo(source.getMete()) < 0,
         "半出重量与来源冻结量不一致,请重新操作"
      );
      return source.getMete();
   }

   @Override
   public void getMaterialInventorys(Outbound outbound, List<MoveOutboundDetail> outboundDetailList, String currentName, Long currentUserId) {
      WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      WeightedExecutionPriceConf weightedExecutionPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权执行方式配置")).getValue(),
         WeightedExecutionPriceConf.class
      );
      Map<Long, Measure> measureMap = this.getMeasureMap();

      for (MoveOutboundDetail outboundDetail : outboundDetailList) {
         if (MaterialOutboundModeEnum.HALF.getType().equals(outboundDetail.getOutboundType())) {
            MaterialInventory materialInventory = this.materialInventoryMapper.selectById(outboundDetail.getMaterialInventoryId());
            Preconditions.checkArgument(!materialInventory.getBoolNestSurplus(), "带dxf图型的余料不允许半出");
            Measure measure = measureMap.get(outboundDetail.getClassifyId());
            BigDecimal unitsPrecision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
            Integer freezeType = OutboundTypeEnum.FOR_SALE.getType().equals(outbound.getOutboundTypeSelection())
               ? MaterialFreezeTypeEnum.FOR_SALE.getType()
               : OutboundTypeEnum.CONSTRUCTION_SITE_USE.getType().equals(outbound.getOutboundTypeSelection())
                  ? MaterialFreezeTypeEnum.CONSTRUCTION_SITE_USE.getType()
                  : Boolean.TRUE.equals(outbound.getBoolScheduling()) ? MaterialFreezeTypeEnum.SCHEDULING_OUTBOUND.getType() : MaterialFreezeTypeEnum.OUTBOUND.getType();
            BigDecimal outMete = this.getHalfSourceMete(outbound, outboundDetail, materialInventory, freezeType);
            Integer count = this.wmsPlantConvertService.getMaxDayConventNumber(LocalDateTime.now());
            String sn = this.numberConfigService.getNumber(NumberTypeEnum.PLANT_CONVERT, count);
            WmsPlantConvert build = WmsPlantConvert.builder()
               .outSerialNumber(outbound.getSerialNumber())
               .receiptSerialNumber(sn)
               .reviewerId(currentUserId)
               .reviewerName(currentName)
               .reviewTime(LocalDateTime.now())
               .basicClass(materialInventory.getBasicClass())
               .outboundId(outbound.getId())
               .projectIds(materialInventory.getProjectId() != null ? materialInventory.getProjectId().toString() : null)
               .materialInventoryId(materialInventory.getId())
               .build();
            this.wmsPlantConvertService.save(build);
            MaterialInventory copy = BeanUtil.copy(materialInventory, MaterialInventory.class);
            copy.setQuantity(outboundDetail.getQuantity());
            copy.setMete(outMete);
            WmsPlantConvertDetail plant = BeanUtil.copy(copy, WmsPlantConvertDetail.class);
            plant.setWmsPlantConvertId(build.getId());
            PriceDTO price1 = this.getPrice(weightedPriceConf, weightedExecutionPriceConf, copy, outboundDetail.getOutboundTime());
            price1.setOneMete(outMete);
            plant.setAmount(price1.getAmount());
            plant.setAmountExcludingVat(price1.getAmountExcludingVat());
            plant.setUnitPrice(price1.getAmount().divide(outMete, 12, RoundingMode.HALF_UP));
            plant.setUnitPriceExcludingVat(price1.getAmountExcludingVat().divide(outMete, 12, RoundingMode.HALF_UP));
            this.wmsPlantConvertDetailService.save(plant);
            this.weightedAveragePriceService
               .createMonthWAP(
                  InboundDetail.builder()
                     .mete(outMete.negate())
                     .quantity(outboundDetail.getQuantity().negate())
                     .projectId(materialInventory.getProjectId())
                     .accountingUnit(materialInventory.getAccountingUnit())
                     .invoiceType(materialInventory.getInvoiceType())
                     .unitPrice(price1.getAmount().divide(outMete, 12, RoundingMode.HALF_UP))
                     .unitPriceExcludingVat(price1.getAmountExcludingVat().divide(outMete, 12, RoundingMode.HALF_UP))
                     .amount(price1.getAmount().negate())
                     .amountExcludingVat(price1.getAmountExcludingVat().negate())
                     .unitPriceNoFreight(price1.getAmountNoFreight().divide(outMete, 12, RoundingMode.HALF_UP))
                     .unitPriceExcludingVatNoFreight(price1.getAmountExcludingVatNoFreight().divide(outMete, 12, RoundingMode.HALF_UP))
                     .amountNoFreight(price1.getAmountNoFreight().negate())
                     .amountExcludingVatNoFreight(price1.getAmountExcludingVatNoFreight().negate())
                     .realTime(outboundDetail.getOutboundTime())
                     .build(),
                  materialInventory,
                  build.getId(),
                  build.getReceiptSerialNumber(),
                  ReceiptTypeEnum.PLANT_CONVERT.getType()
               );
            materialInventory.setQuantity(materialInventory.getQuantity().subtract(outboundDetail.getQuantity()));
            materialInventory.setMete(materialInventory.getMete().subtract(outMete));
            this.wmsUtil
               .setInventoryUse(
                  materialInventory,
                  outboundDetail.getQuantity(),
                  outMete,
                  ReceiptTypeEnum.PLANT_CONVERT,
                  build.getId(),
                  build.getReceiptSerialNumber(),
                  1,
                  false
               );
            if (materialInventory.getMete().compareTo(BigDecimal.ZERO) == 0) {
               this.materialInventoryService.removeById(materialInventory);
            } else {
               this.materialInventoryService.updateById(materialInventory);
            }

            this.warningService.updateStatus(materialInventory, 2);
            Statistics statistics = this.statisticsMapper.get(materialInventory);
            this.setStatisticsEndPeriod(materialInventory, statistics);
            MaterialInventory newMaterialInventory = this.getNewMaterialInventory(
               outbound, materialInventory, outboundDetail, scrapDefinitionConf, outMete, true, null
            );
            outboundDetail.setMaterialInventoryId(newMaterialInventory.getId());
            outboundDetail.setOutboundType(MaterialOutboundModeEnum.WHOLE.getType());
            outboundDetail.setWmsPlantConvertNumber(build.getReceiptSerialNumber());
            this.outboundDetailService.updateById(outboundDetail);
            this.wmsUtil
               .setInventoryUse(
                  newMaterialInventory,
                  newMaterialInventory.getQuantity(),
                  newMaterialInventory.getMete(),
                  ReceiptTypeEnum.PLANT_CONVERT,
                  build.getId(),
                  build.getReceiptSerialNumber(),
                  1,
                  true
               );
            PriceDTO price2 = this.getPlantConvertDetail(outboundDetail, newMaterialInventory, price1, build, plant);
            this.getMaterialInventory(outbound, materialInventory, outboundDetail, price2, build, plant, scrapDefinitionConf, outMete);
            this.wmsPlantConvertService.updateById(build);
         }
      }
   }

   PriceDTO getPlantConvertDetail(
      MoveOutboundDetail outboundDetail,
      MaterialInventory newMaterialInventory,
      PriceDTO price1,
      WmsPlantConvert wmsPlantConvert,
      WmsPlantConvertDetail wmsPlantConvertDetail
   ) {
      PriceDTO priceCopy = BeanUtil.copy(price1, PriceDTO.class);
      WmsPlantConvertDetail copy1 = BeanUtil.copy(newMaterialInventory, WmsPlantConvertDetail.class);
      copy1.setWmsPlantConvertId(wmsPlantConvert.getId());
      copy1.setWmsPlantConvertDetailId(wmsPlantConvertDetail.getId());
      copy1.setOutboundDetailId(outboundDetail.getId());
      BigDecimal p1 = newMaterialInventory.getMete().divide(priceCopy.getOneMete(), 20, RoundingMode.HALF_UP);
      BigDecimal amount = priceCopy.getAmount().multiply(p1).setScale(2, RoundingMode.HALF_UP);
      BigDecimal amountExcludingVat = priceCopy.getAmountExcludingVat().multiply(p1).setScale(2, RoundingMode.HALF_UP);
      BigDecimal amountNoFreight = priceCopy.getAmountNoFreight().multiply(p1).setScale(2, RoundingMode.HALF_UP);
      BigDecimal amountExcludingVatNoFreight = priceCopy.getAmountExcludingVatNoFreight().multiply(p1).setScale(2, RoundingMode.HALF_UP);
      copy1.setAmount(amount);
      copy1.setAmountExcludingVat(amountExcludingVat);
      copy1.setUnitPrice(amount.divide(newMaterialInventory.getMete(), 12, RoundingMode.HALF_UP));
      copy1.setUnitPriceExcludingVat(amountExcludingVat.divide(newMaterialInventory.getMete(), 12, RoundingMode.HALF_UP));
      this.wmsPlantConvertDetailService.save(copy1);
      priceCopy.setAmount(priceCopy.getAmount().subtract(amount));
      priceCopy.setAmountExcludingVat(priceCopy.getAmountExcludingVat().subtract(amountExcludingVat));
      priceCopy.setAmountNoFreight(priceCopy.getAmountNoFreight().subtract(amountNoFreight));
      priceCopy.setAmountExcludingVatNoFreight(priceCopy.getAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight));
      priceCopy.setOneMete(priceCopy.getOneMete().subtract(newMaterialInventory.getMete()));
      InboundDetail inboundDetail = InboundDetail.builder()
         .mete(newMaterialInventory.getMete())
         .quantity(newMaterialInventory.getQuantity())
         .projectId(newMaterialInventory.getProjectId())
         .accountingUnit(newMaterialInventory.getAccountingUnit())
         .invoiceType(newMaterialInventory.getInvoiceType())
         .workshopId(newMaterialInventory.getWorkshopId())
         .unitPrice(amount.divide(newMaterialInventory.getMete(), 12, RoundingMode.HALF_UP))
         .unitPriceExcludingVat(amountExcludingVat.divide(newMaterialInventory.getMete(), 12, RoundingMode.HALF_UP))
         .amount(amount)
         .amountExcludingVat(amountExcludingVat)
         .unitPriceNoFreight(amountNoFreight.divide(newMaterialInventory.getMete(), 12, RoundingMode.HALF_UP))
         .unitPriceExcludingVatNoFreight(amountExcludingVatNoFreight.divide(newMaterialInventory.getMete(), 12, RoundingMode.HALF_UP))
         .amountNoFreight(amountNoFreight)
         .amountExcludingVatNoFreight(amountExcludingVatNoFreight)
         .realTime(outboundDetail.getOutboundTime())
         .build();
      this.weightedAveragePriceService
         .createMonthWAP(
            inboundDetail, newMaterialInventory, wmsPlantConvert.getId(), wmsPlantConvert.getReceiptSerialNumber(), ReceiptTypeEnum.PLANT_CONVERT.getType()
         );
      return priceCopy;
   }

   @Override
   public PriceDTO getPrice(
      WeightedPriceConf weightedPriceConf, WeightedExecutionPriceConf weightedExecutionPriceConf, MaterialInventory materialInventory, LocalDateTime realTime
   ) {
      MonthWeightedAveragePrice wap = this.weightedAveragePriceService.getPrice(materialInventory);
      PriceDTO build = PriceDTO.builder().build();
      BigDecimal amount;
      BigDecimal amountExcludingVat;
      BigDecimal amountNoFreight;
      BigDecimal amountExcludingVatNoFreight;
      if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
         MonthWeightedAveragePrice nowMothWap;
         if (weightedExecutionPriceConf.getWeightedExecutionType() == WeightedPriceTypeEnum.USER.getType()) {
            nowMothWap = this.weightedAveragePriceService.getNowMothWap(wap, MonthTimeRange.builder().endTime(realTime).build());
         } else {
            nowMothWap = wap;
         }

         BigDecimal p = materialInventory.getMete().divide(nowMothWap.getMete(), 20, this.ROUNDING);
         amount = nowMothWap.getAmount().multiply(p).setScale(2, this.ROUNDING);
         amountExcludingVat = nowMothWap.getAmountExcludingVat().multiply(p).setScale(2, this.ROUNDING);
         amountNoFreight = nowMothWap.getAmountNoFreight().multiply(p).setScale(2, this.ROUNDING);
         amountExcludingVatNoFreight = nowMothWap.getAmountExcludingVatNoFreight().multiply(p).setScale(2, this.ROUNDING);
      } else {
         WholeWeightedAveragePrice futureWholeWap = this.wholeWeightedAveragePriceMapper.getPrice(materialInventory);
         WholeWeightedAveragePrice price;
         if (weightedExecutionPriceConf.getWeightedExecutionType() == WeightedPriceTypeEnum.USER.getType()) {
            price = this.weightedAveragePriceService.getNowWholeWap(futureWholeWap, MonthTimeRange.builder().endTime(realTime).build());
         } else {
            price = futureWholeWap;
         }

         BigDecimal p = materialInventory.getMete().divide(price.getMete(), 20, this.ROUNDING);
         amount = price.getAmount().multiply(p).setScale(2, this.ROUNDING);
         amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(2, this.ROUNDING);
         amountNoFreight = price.getAmountNoFreight().multiply(p).setScale(2, this.ROUNDING);
         amountExcludingVatNoFreight = price.getAmountExcludingVatNoFreight().multiply(p).setScale(2, this.ROUNDING);
      }

      build.setAmount(amount);
      build.setAmountExcludingVat(amountExcludingVat);
      build.setAmountNoFreight(amountNoFreight);
      build.setAmountExcludingVatNoFreight(amountExcludingVatNoFreight);
      return build;
   }

   private void setStatisticsEndPeriod(MaterialInventory materialInventory, Statistics statistics) {
      StatisticsEndPeriod endPeriod = this.statisticsEndPeriodMapper.getOne(statistics.getId(), materialInventory.getId());
      endPeriod.setMete(materialInventory.getMete());
      endPeriod.setQuantity(materialInventory.getQuantity());
      this.statisticsEndPeriodMapper.updateById(endPeriod);
   }

   private MaterialInventory getNewMaterialInventory(
      Outbound outbound,
      MaterialInventory materialInventory,
      MoveOutboundDetail outboundDetail,
      WasteConfig scrapDefinitionConf,
      BigDecimal outMete,
      boolean isWhole,
      PriceDTO remainingPrice
   ) {
      BigDecimal length = outboundDetail.getLength();
      BigDecimal width = outboundDetail.getWidth();
      BigDecimal outboundRearMete = outboundDetail.getMete();
      if (!isWhole) {
         outboundRearMete = outMete.subtract(outboundDetail.getMete());
         if (HalfModeEnum.LENGTH.getType().equals(outboundDetail.getHalfMode())) {
            length = materialInventory.getLength().subtract(outboundDetail.getLength());
         } else {
            width = materialInventory.getWidth().subtract(outboundDetail.getWidth());
         }
      }

      boolean isScrap;
      if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
         isScrap = length.compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0
            || width.compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0;
      } else {
         isScrap = length.compareTo(scrapDefinitionConf.getSectionSteelMinLength()) <= 0;
      }

      MaterialInventory newMaterialInventory = BeanUtil.copy(materialInventory, MaterialInventory.class, "createTime", "guid", "plateId");
      if (isScrap) {
         Scrap scrap = BeanUtil.copy(materialInventory, Scrap.class, "createTime");
         scrap.setQuantity(outboundDetail.getQuantity());
         scrap.setMete(outboundRearMete);
         scrap.setLength(length);
         scrap.setWidth(width);
         scrap.setCreateTime(LocalDateTime.now());
         if (remainingPrice != null) {
            scrap.setAmount(remainingPrice.getAmount());
            scrap.setAmountExcludingVat(remainingPrice.getAmountExcludingVat());
            scrap.setAmountNoFreight(remainingPrice.getAmountNoFreight());
            scrap.setAmountExcludingVatNoFreight(remainingPrice.getAmountExcludingVatNoFreight());
         }
         this.scrapMapper.insert(scrap);
         return null;
      } else {
         newMaterialInventory.setSourceMaterielId(materialInventory.getId());
         newMaterialInventory.setMaterialIsWhole(MaterialOutboundModeEnum.WHOLE.getType());
         newMaterialInventory.setLength(length);
         newMaterialInventory.setWidth(width);
         newMaterialInventory.setCreateTime(LocalDateTime.now());
         newMaterialInventory.setInventoryStartTime(LocalDateTime.now());
         newMaterialInventory.setOutboundSn(outbound.getSerialNumber());
         newMaterialInventory.setOutboundId(outbound.getId());
         newMaterialInventory.setBoolHasFrozen(false);
         newMaterialInventory.setMete(outboundRearMete);
         newMaterialInventory.setQuantity(outboundDetail.getQuantity());
         if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
            newMaterialInventory.setOneTheoryWeight(
               CommonUtil.getTheoryMete(
                  materialInventory.getClassifyName(),
                  newMaterialInventory.getLength(),
                  newMaterialInventory.getWidth(),
                  newMaterialInventory.getThickness(),
                  null,
                  materialInventory.getClassifyId()
               )
            );
         } else {
            newMaterialInventory.setOneTheoryWeight(
               CommonUtil.getTheoryMete(
                  null, newMaterialInventory.getLength(), null, null, newMaterialInventory.getSectionSteelWeight(), materialInventory.getClassifyId()
               )
            );
         }

         Print print = Print.builder()
            .receiptId(outbound.getId())
            .receiptSerialNumber(outbound.getSerialNumber())
            .receiptReviewer(outbound.getReviewerName())
            .receiptReviewTime(outbound.getReviewTime())
            .receiptType(ReceiptTypeEnum.OUTBOUND.getType())
            .type(MaterialLabelPrintTypeEnum.OUTBOUND.getType())
            .totalNotPrintNumber(newMaterialInventory.getQuantity().intValue())
            .projectIds(materialInventory.getProjectId() != null ? "" + materialInventory.getProjectId() : null)
            .containBasicClass(materialInventory.getBasicClass())
            .build();
         this.printService.save(print);
         String barcode = this.printService
            .savePrint(
               PrintDetail.builder()
                  .printId(print.getId())
                  .basicClass(newMaterialInventory.getBasicClass())
                  .classifyId(newMaterialInventory.getClassifyId())
                  .classifyName(materialInventory.getClassifyName())
                  .specification(newMaterialInventory.getSpecification())
                  .mete(newMaterialInventory.getMete())
                  .quantity(newMaterialInventory.getQuantity())
                  .brand(newMaterialInventory.getBrand())
                  .heatNoAndBatchNo(newMaterialInventory.getHeatNoAndBatchNo())
                  .workshopId(newMaterialInventory.getWorkshopId())
                  .warehouseId(newMaterialInventory.getWarehouseId())
                  .projectId(newMaterialInventory.getProjectId())
                  .type(MaterialLabelPrintTypeEnum.OUTBOUND.getType())
                  .boolPartyA(newMaterialInventory.getBoolPartyA())
                  .length(newMaterialInventory.getLength())
                  .width(newMaterialInventory.getWidth())
                  .thickness(newMaterialInventory.getThickness())
                  .color(newMaterialInventory.getColor())
                  .notPrintNumber(1)
                  .standardId(newMaterialInventory.getStandardId())
                  .standardName(newMaterialInventory.getStandardName())
                  .materialIsWhole(newMaterialInventory.getMaterialIsWhole())
                  .monomerId(newMaterialInventory.getMonomerId())
                  .areaId(newMaterialInventory.getAreaId())
                  .build()
            );
         newMaterialInventory.setBarcode(barcode);
         this.materialInventoryService.save(newMaterialInventory);
      }

      return newMaterialInventory;
   }

   private void getMaterialInventory(
      Outbound outbound,
      MaterialInventory materialInventory,
      MoveOutboundDetail outboundDetail,
      PriceDTO price1,
      WmsPlantConvert wmsPlantConvert,
      WmsPlantConvertDetail wmsPlantConvertDetail,
      WasteConfig scrapDefinitionConf,
      BigDecimal outMete
   ) {
      MaterialInventory newMaterialInventory = this.getNewMaterialInventory(outbound, materialInventory, outboundDetail, scrapDefinitionConf, outMete, false, price1);
      if (newMaterialInventory == null) {
         return;
      }
      this.wmsUtil
         .setInventoryUse(
            newMaterialInventory,
            newMaterialInventory.getQuantity(),
            newMaterialInventory.getMete(),
            ReceiptTypeEnum.PLANT_CONVERT,
            wmsPlantConvert.getId(),
            wmsPlantConvert.getReceiptSerialNumber(),
            1,
            true
         );
      PriceDTO price2 = this.getPlantConvertDetail(outboundDetail, newMaterialInventory, price1, wmsPlantConvert, wmsPlantConvertDetail);
   }
}
