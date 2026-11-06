package com.hzchum.scim.wms.core.api.utils;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialFreezeTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialIsWholeEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryUseRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryUseStatistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryUseStatisticsDate;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SpecificationService;
import com.hzchum.scim.wms.core.api.service.wmsReport.InventoryUseRecordService;
import com.hzchum.scim.wms.core.api.service.wmsReport.InventoryUseStatisticsDateService;
import com.hzchum.scim.wms.core.api.service.wmsReport.InventoryUseStatisticsService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeRecordService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class WmsUtil {
   @Resource
   SpecificationService specificationService;
   @Resource
   MaterialFreezeService materialFreezeService;
   @Resource
   MaterialFreezeRecordService materialFreezeRecordService;
   @Resource
   MaterialInventoryService materialInventoryService;
   @Resource
   ClassificationService classificationService;
   @Resource
   MeasureService measureService;
   @Resource
   InventoryUseRecordService inventoryUseRecordService;
   @Resource
   InventoryUseStatisticsService inventoryUseStatisticsService;
   @Resource
   InventoryUseStatisticsDateService inventoryUseStatisticsDateService;
   @Resource
   RedisTemplate redisTemplate;

   @NotNull
   public MaterialInventory setMaterialInventoryV2(InboundDetail inboundDetail, MaterialInventory materialInventory) {
      if (materialInventory == null) {
         MaterialInventory mi = BeanUtil.copy(inboundDetail, MaterialInventory.class, "createTime");
         if (mi.getProjectId() != null) {
            mi.setWarehouseType(2);
         } else {
            mi.setWarehouseType(1);
         }

         mi.setSerialNumber(inboundDetail.getMaterialSn());
         mi.setMaterialIsWhole(MaterialIsWholeEnum.WHOLE.getType());
         mi.setInventoryStartTime(LocalDateTime.now());
         if (BasicClassEnum.SECTION_STEEL.getType().equals(mi.getBasicClass())) {
            String[] split = mi.getSpecification().split(" \\* ");
            if (split.length > 1 && StrUtil.isNotBlank(split[1])) {
               String spec = this.specificationService.getJoinSpec(inboundDetail.getClassifyId(), inboundDetail.getDoNotSectionSteelSpec());
               if (StrUtil.isNotBlank(spec)) {
                  mi.setWeightedAverageSpec(split[0] + "*" + spec);
               } else {
                  mi.setWeightedAverageSpec(split[0]);
               }
            } else {
               mi.setWeightedAverageSpec(split[0]);
            }
         } else if (StrUtil.isNotBlank(inboundDetail.getSpecification())) {
            String spec = this.specificationService.getJoinSpec(inboundDetail.getClassifyId(), inboundDetail.getSpecification());
            mi.setWeightedAverageSpec(spec);
         }

         return mi;
      } else {
         if (inboundDetail.getQuantity() != null) {
            materialInventory.setQuantity(materialInventory.getQuantity().add(inboundDetail.getQuantity()));
         }

         materialInventory.setMete(materialInventory.getMete().add(inboundDetail.getMete()));
         materialInventory.setInventoryEndTime(LocalDateTime.now());
         return materialInventory;
      }
   }

   public void setMaterialFreeze(MaterialInventory materialInventory, MoveOutboundDetail convertDetail, Outbound outbound) {
      MaterialFreeze materialFreeze = this.materialFreezeService
         .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
      if (materialFreeze == null) {
         materialFreeze = BeanUtil.copy(materialInventory, MaterialFreeze.class, "createTime");
         materialFreeze.setTotalQuantity(convertDetail.getQuantity());
         materialFreeze.setTotalMete(convertDetail.getMete());
         materialFreeze.setTotalFreezeTypes(MaterialFreezeTypeEnum.BORROW.getType() + "");
         materialFreeze.setMaterialInventoryId(materialInventory.getId());
         this.materialFreezeService.save(materialFreeze);
      } else {
         if (convertDetail.getQuantity() != null) {
            materialFreeze.setTotalQuantity(
               convertDetail.getQuantity() != null
                  ? materialFreeze.getTotalQuantity().add(convertDetail.getQuantity())
                  : materialFreeze.getTotalQuantity().add(convertDetail.getQuantity())
            );
         }

         List<Integer> t = Arrays.stream(materialFreeze.getTotalFreezeTypes().split(",")).map(Integer::parseInt).collect(Collectors.toList());
         if (!t.contains(MaterialFreezeTypeEnum.BORROW.getType())) {
            t.add(MaterialFreezeTypeEnum.BORROW.getType());
            materialFreeze.setTotalFreezeTypes(StrUtil.join(",", t));
         }

         materialFreeze.setTotalMete(materialFreeze.getTotalMete().add(convertDetail.getMete()));
         this.materialFreezeService.updateById(materialFreeze);
      }

      MaterialFreezeRecord materialFreezeRecord = MaterialFreezeRecord.builder()
         .materialFreezeId(materialFreeze.getId())
         .freezeDetailId(convertDetail.getId())
         .freezeType(MaterialFreezeTypeEnum.BORROW.getType())
         .freezeSourceId(convertDetail.getOutboundId())
         .freezeSourceSn(outbound.getSerialNumber())
         .operatorId(UserUtil.getCurrentUserId())
         .operatorName(UserUtil.getCurrentName())
         .mete(convertDetail.getMete())
         .quantity(convertDetail.getQuantity())
         .boolBatten(false)
         .projectId(convertDetail.getProjectId())
         .frozenTime(LocalDateTime.now())
         .outboundUnitType(1)
         .build();
      this.materialFreezeRecordService.save(materialFreezeRecord);
      if (!materialInventory.getBoolHasFrozen()) {
         this.materialInventoryService.updateBoolHasFrozen(materialInventory.getId(), true);
      }
   }

   public Measure getMeasure(Long pid) {
      Classification classification = this.classificationService.getById(pid);
      Measure m = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, pid));
      if (m.getAccountingUnit() != null) {
         m.setAccountingUnit(m.getAccountingUnit() + "/" + classification.getName());
         return m;
      } else {
         return this.getMeasure(classification.getParentId());
      }
   }

   public Measure getMeasured(Long id) {
      Classification classification = this.classificationService.getById(id);
      Measure m = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, id));
      return m.getOutboundUnitType() != null ? m : this.getMeasure(classification.getParentId());
   }

   public void setInventoryUse(
      MaterialInventory materialInventory,
      BigDecimal quantity,
      BigDecimal mete,
      ReceiptTypeEnum receiptTypeEnum,
      Long dataId,
      String serialNumber,
      Integer embodyType,
      Boolean positiveValue
   ) {
      SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
      SimpleDateFormat yyyyMM = new SimpleDateFormat("yyyy-MM");
      Date date = new Date();
      String yyyyMMddStr = yyyyMMdd.format(date);
      String yyyyMMStr = yyyyMM.format(date);
      this.redisTemplate.delete("warehouse_inventory_ratio-" + materialInventory.getWorkshopId());
      this.redisTemplate.delete("warehouse_inventory_ratio-null");
      this.redisTemplate.delete("warehouse_month_realtime_inventory_amount-" + yyyyMMStr + "-" + materialInventory.getWorkshopId());
      if (receiptTypeEnum.equals(ReceiptTypeEnum.INBOUND)
         || receiptTypeEnum.equals(ReceiptTypeEnum.OUTBOUND)
         || receiptTypeEnum.equals(ReceiptTypeEnum.REJECTED)
         || receiptTypeEnum.equals(ReceiptTypeEnum.RETURN)) {
         this.redisTemplate.delete("warehouse_inbound_and_outbound_data-" + yyyyMMddStr + "-" + materialInventory.getWorkshopId());
         this.redisTemplate.delete("warehouse_inbound_and_outbound_data-" + yyyyMMddStr + "-null");
         this.redisTemplate.delete("warehouse_month_realtime_inventory_amount-" + yyyyMMStr + "-null");
      }

      if (ObjectUtil.isEmpty(materialInventory.getSpecification())) {
         materialInventory.setSpecification(null);
      }

      if (ObjectUtil.isEmpty(materialInventory.getModel())) {
         materialInventory.setModel(null);
      }

      if (ObjectUtil.isEmpty(materialInventory.getMaterialIsWhole())) {
         materialInventory.setMaterialIsWhole(null);
      }

      if (ObjectUtil.isEmpty(materialInventory.getWarehouseType())) {
         materialInventory.setWarehouseType(null);
      }

      if (ObjectUtil.isEmpty(materialInventory.getProjectId())) {
         materialInventory.setProjectId(null);
      }

      if (ObjectUtil.isEmpty(materialInventory.getBoolPartyA())) {
         materialInventory.setBoolPartyA(null);
      }

      if (ObjectUtil.isEmpty(materialInventory.getLength())) {
         materialInventory.setLength(null);
      }

      if (ObjectUtil.isEmpty(materialInventory.getWidth())) {
         materialInventory.setWidth(null);
      }

      if (ObjectUtil.isEmpty(materialInventory.getThickness())) {
         materialInventory.setThickness(null);
      }

      if (ObjectUtil.isEmpty(materialInventory.getBrand())) {
         materialInventory.setBrand(null);
      }

      if (ObjectUtil.isEmpty(materialInventory.getHeatNoAndBatchNo())) {
         materialInventory.setHeatNoAndBatchNo(null);
      }

      if (ObjectUtil.isEmpty(materialInventory.getColor())) {
         materialInventory.setColor(null);
      }

      if (ObjectUtil.isEmpty(materialInventory.getUnitNet())) {
         materialInventory.setUnitNet(null);
      }

      if (ObjectUtil.isEmpty(materialInventory.getWarehouseId())) {
         materialInventory.setWarehouseId(null);
      }

      if (ObjectUtil.isEmpty(materialInventory.getStandardId())) {
         materialInventory.setStandardId(null);
      }

      if (ObjectUtil.isEmpty(materialInventory.getWorkshopId())) {
         materialInventory.setWorkshopId(null);
      }

      if (ObjectUtil.isEmpty(materialInventory.getSerialNumber())) {
         materialInventory.setSerialNumber(null);
      }

      LocalDateTime now = LocalDateTime.now();
      InventoryUseStatisticsDate inventoryUseStatisticsDate = this.inventoryUseStatisticsDateService
         .getOne((Wrapper<InventoryUseStatisticsDate>)new LambdaQueryWrapper<InventoryUseStatisticsDate>().eq(InventoryUseStatisticsDate::getBoolBalance, false));
      if (ObjectUtil.isEmpty(inventoryUseStatisticsDate)) {
         inventoryUseStatisticsDate = InventoryUseStatisticsDate.builder().startTime(LocalDateTime.now()).boolBalance(false).build();
         this.inventoryUseStatisticsDateService.save(inventoryUseStatisticsDate);
      } else {
         Preconditions.checkArgument(
            now.isAfter(inventoryUseStatisticsDate.getStartTime()),
            "当前时间已结存,请在<" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(inventoryUseStatisticsDate.getStartTime()) + ">后执行"
         );
      }

      quantity = ObjectUtil.isNotEmpty(quantity) ? quantity : BigDecimal.ZERO;
      mete = ObjectUtil.isNotEmpty(mete) ? mete : BigDecimal.ZERO;
      if (ObjectUtil.isNotEmpty(positiveValue) && !positiveValue) {
         quantity = quantity.compareTo(BigDecimal.ZERO) > 0 ? quantity.negate() : quantity;
         mete = mete.compareTo(BigDecimal.ZERO) > 0 ? mete.negate() : mete;
      }

      InventoryUseRecord inventoryUseRecord = BeanUtil.copy(materialInventory, InventoryUseRecord.class);
      inventoryUseRecord.setQuantity(quantity);
      inventoryUseRecord.setMete(mete);
      inventoryUseRecord.setUseType(receiptTypeEnum.getType());
      inventoryUseRecord.setEmbodyType(embodyType);
      inventoryUseRecord.setDataId(dataId);
      inventoryUseRecord.setUseOrderSerialNumber(serialNumber);
      InventoryUseStatistics inventoryUseStatistics = this.inventoryUseStatisticsService
         .getInventoryUseStatisticsByMaterialInventory(materialInventory, inventoryUseStatisticsDate.getId());
      if (ObjectUtil.isEmpty(inventoryUseStatistics)) {
         inventoryUseStatistics = InventoryUseStatistics.builder()
            .statisticsDateId(inventoryUseStatisticsDate.getId())
            .basicClass(materialInventory.getBasicClass())
            .classifyId(materialInventory.getClassifyId())
            .classifyName(materialInventory.getClassifyName())
            .specification(materialInventory.getSpecification())
            .model(materialInventory.getModel())
            .materialIsWhole(materialInventory.getMaterialIsWhole())
            .warehouseType(materialInventory.getWarehouseType())
            .projectId(materialInventory.getProjectId())
            .boolPartyA(materialInventory.getBoolPartyA())
            .length(materialInventory.getLength())
            .width(materialInventory.getWidth())
            .thickness(materialInventory.getThickness())
            .theoryThickness(materialInventory.getTheoryThickness())
            .brand(materialInventory.getBrand())
            .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
            .color(materialInventory.getColor())
            .unitNet(materialInventory.getUnitNet())
            .standardId(materialInventory.getStandardId())
            .standardName(materialInventory.getStandardName())
            .serialNumber(materialInventory.getSerialNumber())
            .workshopId(materialInventory.getWorkshopId())
            .warehouseId(materialInventory.getWarehouseId())
            .build();
         this.inventoryUseStatisticsService.save(inventoryUseStatistics);
      }

      inventoryUseRecord.setInventoryUseStatisticsId(inventoryUseStatistics.getId());
      this.inventoryUseRecordService.save(inventoryUseRecord);
   }

   public static String getSpecification(Integer basicClass, BigDecimal thickness, BigDecimal width, BigDecimal length, String specification) {
      StringBuilder spec = new StringBuilder();
      if (BasicClassEnum.STEEL_PLATE.getType().equals(basicClass)) {
         spec.append(thickness.stripTrailingZeros().toPlainString());
         if (width != null) {
            spec.append("*").append(width.stripTrailingZeros().toPlainString());
         }

         if (length != null) {
            spec.append("*").append(length.stripTrailingZeros().toPlainString());
         }

         if (specification != null) {
            spec.append(" * ").append(specification);
         }
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(basicClass)) {
         spec.append(thickness.stripTrailingZeros().toPlainString());
         if (width != null) {
            spec.append("*").append(width.stripTrailingZeros().toPlainString());
         }

         if (specification != null) {
            spec.append(" * ").append(specification);
         }
      } else if (BasicClassEnum.SECTION_STEEL.getType().equals(basicClass) || BasicClassEnum.checkNotSteel(basicClass)) {
         if (length != null) {
            spec.append(length.stripTrailingZeros().toPlainString());
         }

         if (spec.length() > 0) {
            spec.append(" * ");
         }

         if (specification != null) {
            spec.append(specification);
         }
      }

      return spec.length() > 0 ? spec.toString() : "-";
   }
}
