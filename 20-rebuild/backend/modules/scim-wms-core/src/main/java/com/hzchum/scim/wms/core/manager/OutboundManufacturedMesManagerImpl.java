package com.hzchum.scim.wms.core.manager;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.WmsWageQuotaTypeEnum;
import com.hzchum.scim.wms.core.api.manager.OutboundManufacturedMesManager;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsMonthManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventoryManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.OutboundDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.OutboundManufactured;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.manager.OutboundManufacturedVORequest;
import com.hzchum.scim.wms.core.api.service.wmsReport.StatisticsMonthManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundDetailManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundManufacturedService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class OutboundManufacturedMesManagerImpl implements OutboundManufacturedMesManager {
   @Resource
   private NumberConfigService numberConfigService;
   @Resource
   private OutboundManufacturedService outboundManufacturedService;
   @Resource
   private StatisticsMonthManufacturedService statisticsMonthManufacturedService;
   @Resource
   private OutboundDetailManufacturedService outboundDetailManufacturedService;
   @Resource
   private UserService userService;
   @Resource
   private MaterialInventoryManufacturedService materialInventoryManufacturedService;

   @Override
   public Boolean insertOutManufactured(List<OutboundManufacturedVORequest> outboundManufacturedVORequests) {
      String serviceNumber = this.numberConfigService
         .getNumber(NumberTypeEnum.OUTBOUND_MANUFACTURED, this.outboundManufacturedService.getCount(LocalDateTime.now()));
      OutboundManufactured outboundManufactured = OutboundManufactured.builder()
         .serialNumber(serviceNumber)
         .applicantId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .applicationTime(LocalDateTime.now())
         .reviewStatus(ReviewStatusEnum.REVIEWED.getType())
         .reviewPassTime(LocalDateTime.now())
         .build();
      this.outboundManufacturedService.save(outboundManufactured);
      List<Long> collect = outboundManufacturedVORequests.stream().map(OutboundManufacturedVORequest::getMaterialInventoryId).collect(Collectors.toList());
      List<MaterialInventoryManufactured> materialInventoryManufactureds = this.materialInventoryManufacturedService.listByIds(collect);
      Integer basicClass = 0;
      Set<Long> projectIds = new TreeSet<>();
      LocalDateTime now = LocalDateTime.now();
      BigDecimal sumAmount = new BigDecimal(0);
      BigDecimal sumAmountExcludingVat = new BigDecimal(0);
      String monthStr = now.format(DateTimeFormatter.ofPattern("yyyy-MM"));

      for (OutboundManufacturedVORequest voRequest : outboundManufacturedVORequests) {
         MaterialInventoryManufactured materialInventoryManufactured = materialInventoryManufactureds.stream()
            .filter(m -> m.getId().equals(voRequest.getMaterialInventoryId()) && m.getArtifactEnclosureId().equals(voRequest.getProductId()))
            .findAny()
            .orElse(null);
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(materialInventoryManufactured), "未获取到制成品库存信息！！！");
         Preconditions.checkArgument(
            materialInventoryManufactured.getQuantity().compareTo(voRequest.getQuantity()) > -1,
            "制成品【" + materialInventoryManufactured.getManufacturedName() + "】数量不足！！！"
         );
         OutboundDetailManufactured outboundDetailManufactured = OutboundDetailManufactured.builder()
            .outboundManufacturedId(outboundManufactured.getId())
            .materialInventoryManufacturedId(materialInventoryManufactured.getId())
            .basicClass(materialInventoryManufactured.getBasicClass())
            .monomerId(materialInventoryManufactured.getMonomerId())
            .areaId(materialInventoryManufactured.getAreaId())
            .projectId(materialInventoryManufactured.getProjectId())
            .artifactEnclosureId(materialInventoryManufactured.getArtifactEnclosureId())
            .manufacturedName(materialInventoryManufactured.getManufacturedName())
            .manufacturedSn(materialInventoryManufactured.getManufacturedSn())
            .material(materialInventoryManufactured.getMaterial())
            .specification(materialInventoryManufactured.getSpecification())
            .length(materialInventoryManufactured.getLength())
            .width(materialInventoryManufactured.getWidth())
            .thickness(materialInventoryManufactured.getThickness())
            .brand(materialInventoryManufactured.getBrand())
            .color(materialInventoryManufactured.getColor())
            .weight(materialInventoryManufactured.getWeight())
            .surfaceArea(materialInventoryManufactured.getSurfaceArea())
            .wageQuotaType(materialInventoryManufactured.getWageQuotaType())
            .quantity(voRequest.getQuantity())
            .manufacturedUnit(materialInventoryManufactured.getManufacturedUnit())
            .unitPrice(materialInventoryManufactured.getUnitPrice())
            .unitPriceExcludingVat(materialInventoryManufactured.getUnitPriceExcludingVat())
            .recipientId(voRequest.getUserId())
            .recipientName(this.userService.getNameById(voRequest.getUserId()))
            .outboundTime(ObjectUtil.isNotEmpty(voRequest.getOutboundTime()) ? voRequest.getOutboundTime() : now)
            .taxRate(materialInventoryManufactured.getTaxRate())
            .remark(voRequest.getRemark())
            .build();
         basicClass = basicClass | materialInventoryManufactured.getBasicClass();
         projectIds.add(materialInventoryManufactured.getProjectId());
         materialInventoryManufactured.setQuantity(materialInventoryManufactured.getQuantity().subtract(voRequest.getQuantity()));
         if (ObjectUtil.isNotEmpty(materialInventoryManufactured.getTotalWeight())) {
            BigDecimal totalWeight = voRequest.getQuantity().multiply(materialInventoryManufactured.getWeight());
            outboundDetailManufactured.setTotalWeight(totalWeight);
            materialInventoryManufactured.setTotalWeight(materialInventoryManufactured.getTotalWeight().subtract(totalWeight));
         }

         if (ObjectUtil.isNotEmpty(materialInventoryManufactured.getTotalLength())) {
            BigDecimal totalLength = voRequest.getQuantity().multiply(materialInventoryManufactured.getLength());
            outboundDetailManufactured.setTotalLength(totalLength);
            materialInventoryManufactured.setTotalLength(materialInventoryManufactured.getTotalLength().subtract(totalLength));
         }

         if (ObjectUtil.isNotEmpty(materialInventoryManufactured.getTotalArea())) {
            BigDecimal totalArea = voRequest.getQuantity().multiply(materialInventoryManufactured.getSurfaceArea());
            outboundDetailManufactured.setTotalArea(totalArea);
            materialInventoryManufactured.setTotalArea(materialInventoryManufactured.getTotalArea().subtract(totalArea));
         }

         BigDecimal amount = new BigDecimal(0);
         BigDecimal amountExcludingVat = new BigDecimal(0);
         if (materialInventoryManufactured.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType())) {
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(materialInventoryManufactured.getTotalWeight()), "重量不存在，不可为重量计价！！！");
            amount = materialInventoryManufactured.getUnitPrice().multiply(outboundDetailManufactured.getTotalWeight());
            amountExcludingVat = materialInventoryManufactured.getUnitPriceExcludingVat().multiply(outboundDetailManufactured.getTotalWeight());
         } else if (materialInventoryManufactured.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType())) {
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(materialInventoryManufactured.getTotalLength()), "长度不存在，不可为长度计价！！！");
            amount = materialInventoryManufactured.getUnitPrice().multiply(outboundDetailManufactured.getTotalLength());
            amountExcludingVat = materialInventoryManufactured.getUnitPriceExcludingVat().multiply(outboundDetailManufactured.getTotalLength());
         } else if (materialInventoryManufactured.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType())) {
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(materialInventoryManufactured.getTotalArea()), "面积不存在，不可为面积计价！！！");
            amount = materialInventoryManufactured.getUnitPrice().multiply(outboundDetailManufactured.getTotalArea());
            amountExcludingVat = materialInventoryManufactured.getUnitPriceExcludingVat().multiply(outboundDetailManufactured.getTotalArea());
         } else if (materialInventoryManufactured.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_QUANTITY_PRICE.getType())) {
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(materialInventoryManufactured.getQuantity()), "数量不存在，不可为数量计价！！！");
            amount = materialInventoryManufactured.getUnitPrice().multiply(outboundDetailManufactured.getQuantity());
            amountExcludingVat = materialInventoryManufactured.getUnitPriceExcludingVat().multiply(outboundDetailManufactured.getQuantity());
         } else {
            Preconditions.checkArgument(false, "未知计价方式");
         }

         outboundDetailManufactured.setAmount(amount);
         outboundDetailManufactured.setAmountExcludingVat(amountExcludingVat);
         this.outboundDetailManufacturedService.save(outboundDetailManufactured);
         this.materialInventoryManufacturedService.updateById(materialInventoryManufactured);
         this.setStatisticsMonthManufactured(outboundDetailManufactured, monthStr);
         sumAmount = sumAmount.add(amount);
         sumAmountExcludingVat = sumAmountExcludingVat.add(amountExcludingVat);
      }

      outboundManufactured.setBasicClass(basicClass);
      if (CollectionUtil.isNotEmpty(projectIds)) {
         outboundManufactured.setProjectIds(StringUtils.join(projectIds, ","));
      }

      outboundManufactured.setAmount(sumAmount);
      outboundManufactured.setAmountExcludingVat(sumAmountExcludingVat);
      return this.outboundManufacturedService.updateById(outboundManufactured);
   }

   private void setStatisticsMonthManufactured(OutboundDetailManufactured outboundDetailManufactured, String monthStr) {
      StatisticsMonthManufactured statisticsMonthManufactured = this.statisticsMonthManufacturedService
         .getOne(
            (Wrapper<StatisticsMonthManufactured>)(((((new LambdaQueryWrapper<StatisticsMonthManufactured>()
                              .eq(StatisticsMonthManufactured::getMonomerId, outboundDetailManufactured.getMonomerId()))
                           .eq(StatisticsMonthManufactured::getAreaId, outboundDetailManufactured.getAreaId()))
                        .eq(StatisticsMonthManufactured::getManufacturedSn, outboundDetailManufactured.getManufacturedSn()))
                     .eq(StatisticsMonthManufactured::getUnitPrice, outboundDetailManufactured.getUnitPrice()))
                  .eq(StatisticsMonthManufactured::getTaxRate, outboundDetailManufactured.getTaxRate()))
               .eq(StatisticsMonthManufactured::getMonthStr, monthStr)
         );
      if (ObjectUtil.isEmpty(statisticsMonthManufactured)) {
         statisticsMonthManufactured = BeanUtil.toBean(outboundDetailManufactured, StatisticsMonthManufactured.class);
         statisticsMonthManufactured.setOutboundTotalQuantity(outboundDetailManufactured.getQuantity());
         statisticsMonthManufactured.setOutboundTotalWeight(outboundDetailManufactured.getTotalWeight());
         statisticsMonthManufactured.setOutboundTotalLength(outboundDetailManufactured.getTotalLength());
         statisticsMonthManufactured.setOutboundTotalArea(outboundDetailManufactured.getTotalArea());
         statisticsMonthManufactured.setOutboundAmount(outboundDetailManufactured.getAmount());
         statisticsMonthManufactured.setOutboundAmountExcludingVat(outboundDetailManufactured.getAmountExcludingVat());
         statisticsMonthManufactured.setMonthStr(monthStr);
         this.statisticsMonthManufacturedService.save(statisticsMonthManufactured);
      } else {
         statisticsMonthManufactured.setOutboundTotalQuantity(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getOutboundTotalQuantity())
               ? statisticsMonthManufactured.getOutboundTotalQuantity().add(outboundDetailManufactured.getQuantity())
               : outboundDetailManufactured.getQuantity()
         );
         statisticsMonthManufactured.setOutboundTotalWeight(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getOutboundTotalWeight())
               ? statisticsMonthManufactured.getOutboundTotalWeight().add(outboundDetailManufactured.getTotalWeight())
               : outboundDetailManufactured.getTotalWeight()
         );
         statisticsMonthManufactured.setOutboundTotalLength(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getOutboundTotalLength())
               ? statisticsMonthManufactured.getOutboundTotalLength().add(outboundDetailManufactured.getTotalLength())
               : outboundDetailManufactured.getTotalLength()
         );
         statisticsMonthManufactured.setOutboundTotalArea(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getOutboundTotalArea())
               ? statisticsMonthManufactured.getOutboundTotalArea().add(outboundDetailManufactured.getTotalArea())
               : outboundDetailManufactured.getTotalArea()
         );
         statisticsMonthManufactured.setOutboundAmount(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getOutboundAmount())
               ? statisticsMonthManufactured.getOutboundAmount().add(outboundDetailManufactured.getAmount())
               : outboundDetailManufactured.getAmount()
         );
         statisticsMonthManufactured.setOutboundAmountExcludingVat(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getOutboundAmountExcludingVat())
               ? statisticsMonthManufactured.getOutboundAmountExcludingVat().add(outboundDetailManufactured.getAmountExcludingVat())
               : outboundDetailManufactured.getAmountExcludingVat()
         );
         this.statisticsMonthManufacturedService.updateById(statisticsMonthManufactured);
      }
   }
}
