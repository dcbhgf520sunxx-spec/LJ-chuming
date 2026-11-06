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
import com.hzchum.scim.wms.core.api.manager.ReturnManufacturedMesManager;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsMonthManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventoryManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnManufactured;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.manager.ReturnManufacturedVORequest;
import com.hzchum.scim.wms.core.api.service.wmsReport.StatisticsMonthManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnDetailManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnManufacturedService;
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
public class ReturnManufacturedMesManagerImpl implements ReturnManufacturedMesManager {
   @Resource
   ReturnManufacturedService returnManufacturedService;
   @Resource
   ReturnDetailManufacturedService returnDetailManufacturedService;
   @Resource
   MaterialInventoryManufacturedService materialInventoryManufacturedService;
   @Resource
   StatisticsMonthManufacturedService statisticsMonthManufacturedService;
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   UserService userService;

   @Override
   public Boolean insertReturnManufactured(List<ReturnManufacturedVORequest> returnManufacturedVORequests) {
      String serviceNumber = this.numberConfigService
         .getNumber(NumberTypeEnum.RETURN_MANUFACTURED, this.returnManufacturedService.getCount(LocalDateTime.now()));
      ReturnManufactured returnManufactured = ReturnManufactured.builder()
         .serialNumber(serviceNumber)
         .applicantId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .applicationTime(LocalDateTime.now())
         .reviewStatus(ReviewStatusEnum.REVIEWED.getType())
         .reviewPassTime(LocalDateTime.now())
         .build();
      this.returnManufacturedService.save(returnManufactured);
      List<Long> collect = returnManufacturedVORequests.stream().map(ReturnManufacturedVORequest::getMaterialInventoryId).collect(Collectors.toList());
      List<MaterialInventoryManufactured> materialInventoryManufactureds = this.materialInventoryManufacturedService.listByIds(collect);
      Integer basicClass = 0;
      Set<Long> projectIds = new TreeSet<>();
      LocalDateTime now = LocalDateTime.now();
      BigDecimal sumAmount = new BigDecimal(0);
      BigDecimal sumAmountExcludingVat = new BigDecimal(0);
      String monthStr = now.format(DateTimeFormatter.ofPattern("yyyy-MM"));

      for (ReturnManufacturedVORequest voRequest : returnManufacturedVORequests) {
         MaterialInventoryManufactured materialInventoryManufactured = materialInventoryManufactureds.stream()
            .filter(m -> m.getId().equals(voRequest.getMaterialInventoryId()) && m.getArtifactEnclosureId().equals(voRequest.getProductId()))
            .findAny()
            .orElse(null);
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(materialInventoryManufactured), "未获取到制成品库存信息！！！");
         ReturnDetailManufactured returnDetailManufactured = ReturnDetailManufactured.builder()
            .returnManufacturedId(returnManufactured.getId())
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
            .returneeId(voRequest.getUserId())
            .returneeName(this.userService.getNameById(voRequest.getUserId()))
            .returnTime(ObjectUtil.isNotEmpty(voRequest.getReturnTime()) ? voRequest.getReturnTime() : now)
            .taxRate(materialInventoryManufactured.getTaxRate())
            .remark(voRequest.getRemark())
            .build();
         basicClass = basicClass | materialInventoryManufactured.getBasicClass();
         projectIds.add(materialInventoryManufactured.getProjectId());
         materialInventoryManufactured.setQuantity(materialInventoryManufactured.getQuantity().add(voRequest.getQuantity()));
         if (ObjectUtil.isNotEmpty(materialInventoryManufactured.getTotalWeight())) {
            BigDecimal totalWeight = voRequest.getQuantity().multiply(materialInventoryManufactured.getWeight());
            returnDetailManufactured.setTotalWeight(totalWeight);
            materialInventoryManufactured.setTotalWeight(materialInventoryManufactured.getTotalWeight().add(totalWeight));
         }

         if (ObjectUtil.isNotEmpty(materialInventoryManufactured.getTotalLength())) {
            BigDecimal totalLength = voRequest.getQuantity().multiply(materialInventoryManufactured.getLength());
            returnDetailManufactured.setTotalLength(totalLength);
            materialInventoryManufactured.setTotalLength(materialInventoryManufactured.getTotalLength().add(totalLength));
         }

         if (ObjectUtil.isNotEmpty(materialInventoryManufactured.getTotalArea())) {
            BigDecimal totalArea = voRequest.getQuantity().multiply(materialInventoryManufactured.getSurfaceArea());
            returnDetailManufactured.setTotalArea(totalArea);
            materialInventoryManufactured.setTotalArea(materialInventoryManufactured.getTotalArea().add(totalArea));
         }

         BigDecimal amount = new BigDecimal(0);
         BigDecimal amountExcludingVat = new BigDecimal(0);
         if (materialInventoryManufactured.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType())) {
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(materialInventoryManufactured.getTotalWeight()), "重量不存在，不可为重量计价！！！");
            amount = materialInventoryManufactured.getUnitPrice().multiply(returnDetailManufactured.getTotalWeight());
            amountExcludingVat = materialInventoryManufactured.getUnitPriceExcludingVat().multiply(returnDetailManufactured.getTotalWeight());
         } else if (materialInventoryManufactured.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType())) {
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(materialInventoryManufactured.getTotalLength()), "长度不存在，不可为长度计价！！！");
            amount = materialInventoryManufactured.getUnitPrice().multiply(returnDetailManufactured.getTotalLength());
            amountExcludingVat = materialInventoryManufactured.getUnitPriceExcludingVat().multiply(returnDetailManufactured.getTotalLength());
         } else if (materialInventoryManufactured.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType())) {
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(materialInventoryManufactured.getTotalArea()), "面积不存在，不可为面积计价！！！");
            amount = materialInventoryManufactured.getUnitPrice().multiply(returnDetailManufactured.getTotalArea());
            amountExcludingVat = materialInventoryManufactured.getUnitPriceExcludingVat().multiply(returnDetailManufactured.getTotalArea());
         } else if (materialInventoryManufactured.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_QUANTITY_PRICE.getType())) {
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(materialInventoryManufactured.getQuantity()), "数量不存在，不可为数量计价！！！");
            amount = materialInventoryManufactured.getUnitPrice().multiply(returnDetailManufactured.getQuantity());
            amountExcludingVat = materialInventoryManufactured.getUnitPriceExcludingVat().multiply(returnDetailManufactured.getQuantity());
         } else {
            Preconditions.checkArgument(false, "未知计价方式");
         }

         returnDetailManufactured.setAmount(amount);
         returnDetailManufactured.setAmountExcludingVat(amountExcludingVat);
         this.returnDetailManufacturedService.save(returnDetailManufactured);
         this.materialInventoryManufacturedService.updateById(materialInventoryManufactured);
         this.setStatisticsMonthManufactured(returnDetailManufactured, monthStr);
         sumAmount = sumAmount.add(amount);
         sumAmountExcludingVat = sumAmountExcludingVat.add(amountExcludingVat);
      }

      returnManufactured.setBasicClass(basicClass);
      if (CollectionUtil.isNotEmpty(projectIds)) {
         returnManufactured.setProjectIds(StringUtils.join(projectIds, ","));
      }

      returnManufactured.setAmount(sumAmount);
      returnManufactured.setAmountExcludingVat(sumAmountExcludingVat);
      return this.returnManufacturedService.updateById(returnManufactured);
   }

   private void setStatisticsMonthManufactured(ReturnDetailManufactured returnDetailManufactured, String monthStr) {
      StatisticsMonthManufactured statisticsMonthManufactured = this.statisticsMonthManufacturedService
         .getOne(
            (Wrapper<StatisticsMonthManufactured>)(((((new LambdaQueryWrapper<StatisticsMonthManufactured>()
                              .eq(StatisticsMonthManufactured::getMonomerId, returnDetailManufactured.getMonomerId()))
                           .eq(StatisticsMonthManufactured::getAreaId, returnDetailManufactured.getAreaId()))
                        .eq(StatisticsMonthManufactured::getManufacturedSn, returnDetailManufactured.getManufacturedSn()))
                     .eq(StatisticsMonthManufactured::getUnitPrice, returnDetailManufactured.getUnitPrice()))
                  .eq(StatisticsMonthManufactured::getTaxRate, returnDetailManufactured.getTaxRate()))
               .eq(StatisticsMonthManufactured::getMonthStr, monthStr)
         );
      if (ObjectUtil.isEmpty(statisticsMonthManufactured)) {
         statisticsMonthManufactured = BeanUtil.toBean(returnDetailManufactured, StatisticsMonthManufactured.class);
         statisticsMonthManufactured.setReturnTotalQuantity(returnDetailManufactured.getQuantity());
         statisticsMonthManufactured.setReturnTotalWeight(returnDetailManufactured.getTotalWeight());
         statisticsMonthManufactured.setReturnTotalLength(returnDetailManufactured.getTotalLength());
         statisticsMonthManufactured.setReturnTotalArea(returnDetailManufactured.getTotalArea());
         statisticsMonthManufactured.setReturnAmount(returnDetailManufactured.getAmount());
         statisticsMonthManufactured.setReturnAmountExcludingVat(returnDetailManufactured.getAmountExcludingVat());
         statisticsMonthManufactured.setMonthStr(monthStr);
         this.statisticsMonthManufacturedService.save(statisticsMonthManufactured);
      } else {
         statisticsMonthManufactured.setReturnTotalQuantity(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getReturnTotalQuantity())
               ? statisticsMonthManufactured.getReturnTotalQuantity().add(returnDetailManufactured.getQuantity())
               : returnDetailManufactured.getQuantity()
         );
         statisticsMonthManufactured.setReturnTotalWeight(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getReturnTotalWeight())
               ? statisticsMonthManufactured.getReturnTotalWeight().add(returnDetailManufactured.getTotalWeight())
               : returnDetailManufactured.getTotalWeight()
         );
         statisticsMonthManufactured.setReturnTotalLength(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getReturnTotalLength())
               ? statisticsMonthManufactured.getReturnTotalLength().add(returnDetailManufactured.getTotalLength())
               : returnDetailManufactured.getTotalLength()
         );
         statisticsMonthManufactured.setReturnTotalArea(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getReturnTotalArea())
               ? statisticsMonthManufactured.getReturnTotalArea().add(returnDetailManufactured.getTotalArea())
               : returnDetailManufactured.getTotalArea()
         );
         statisticsMonthManufactured.setReturnAmount(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getReturnAmount())
               ? statisticsMonthManufactured.getReturnAmount().add(returnDetailManufactured.getAmount())
               : returnDetailManufactured.getAmount()
         );
         statisticsMonthManufactured.setReturnAmountExcludingVat(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getReturnAmountExcludingVat())
               ? statisticsMonthManufactured.getReturnAmountExcludingVat().add(returnDetailManufactured.getAmountExcludingVat())
               : returnDetailManufactured.getAmountExcludingVat()
         );
         this.statisticsMonthManufacturedService.updateById(statisticsMonthManufactured);
      }
   }
}
