package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.DrillHoleConfigPricingMannerEnum;
import com.hzchum.scim.system.core.api.common.enums.StatisticsConfigStatisticsModeEnum;
import com.hzchum.scim.system.core.api.common.enums.WageConfigStatisticsModeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ApiModel("钻孔配置新增类")
public class MesDrillHoleConfigSaveDTOParam {
   @NotNull(groups = Update.class, message = "主键ID不能为空")
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @NotNull(groups = {Add.class, Update.class}, message = "零件类型不能为空")
   @EnumValidator(groups = {Add.class, Update.class}, value = ProductClassificationEnum.class, message = "零件类型不存在")
   @ApiModelProperty(name = "machinePartType", value = "零件类型", notes = "零件类型")
   private Integer machinePartType;
   @NotNull(groups = {Add.class, Update.class}, message = "零件类型分类不能为空")
   @ApiModelProperty(name = "steelClassificationId", value = "零件类型分类ID", notes = "零件类型分类ID")
   private Long steelClassificationId;
   @NotNull(groups = {Add.class, Update.class}, message = "统计模式不能为空")
   @EnumValidator(value = WageConfigStatisticsModeEnum.class, message = "统计模式不存在")
   @ApiModelProperty(name = "statisticsMode", value = "统计模式", notes = "统计模式")
   private Integer statisticsMode;
   @ApiModelProperty(name = "processIdList", value = "生产工序", notes = "生产工序")
   private List<Long> processIdList;
   @ApiModelProperty(name = "pricingManner", value = "计价方式", notes = "计价方式")
   @EnumValidator(groups = {Add.class, Update.class}, value = DrillHoleConfigPricingMannerEnum.class, message = "计价方式不存在")
   private Integer pricingManner;
   @NotNull(groups = {Add.class, Update.class}, message = "计量方式不能为空")
   @EnumValidator(groups = {Add.class, Update.class}, value = WageQuotaTypeEnum.class, message = "计量方式不存在")
   @ApiModelProperty(name = "measurementManner", value = "计量方式", notes = "计量方式")
   private Integer measurementManner;
   @ApiModelProperty(name = "organizationInsidePrice", value = "编制内单价(元)", notes = "编制内单价(元)")
   @Positive(groups = {Add.class, Update.class}, message = "编制内单价要大于0")
   private BigDecimal organizationInsidePrice;
   @ApiModelProperty(name = "organizationOutsidePrice", value = "编制外单价(元)", notes = "编制外单价(元)")
   @Positive(groups = {Add.class, Update.class}, message = "编制外单价要大于0")
   private BigDecimal organizationOutsidePrice;
   @ApiModelProperty(name = "fixedPrice", value = "一口价(元)", notes = "一口价(元)")
   @Positive(groups = {Add.class, Update.class}, message = "一口价要大于0")
   private BigDecimal fixedPrice;
   @NotNull(groups = {Add.class, Update.class}, message = "统计配置统计模式不能为空")
   @EnumValidator(groups = {Add.class, Update.class}, value = StatisticsConfigStatisticsModeEnum.class, message = "统计配置统计模式不存在")
   @ApiModelProperty(name = "statisticsConfigStatisticsMode", value = "统计配置统计模式", notes = "统计配置统计模式")
   private Integer statisticsConfigStatisticsMode;
   @ApiModelProperty(name = "detailList", value = "计价详情", notes = "计价详情")
   @Valid
   private List<MesDrillHoleConfigDetailSaveDTOParam> detailList;

   public Long getId() {
      return this.id;
   }

   public Integer getMachinePartType() {
      return this.machinePartType;
   }

   public Long getSteelClassificationId() {
      return this.steelClassificationId;
   }

   public Integer getStatisticsMode() {
      return this.statisticsMode;
   }

   public List<Long> getProcessIdList() {
      return this.processIdList;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   public Integer getMeasurementManner() {
      return this.measurementManner;
   }

   public BigDecimal getOrganizationInsidePrice() {
      return this.organizationInsidePrice;
   }

   public BigDecimal getOrganizationOutsidePrice() {
      return this.organizationOutsidePrice;
   }

   public BigDecimal getFixedPrice() {
      return this.fixedPrice;
   }

   public Integer getStatisticsConfigStatisticsMode() {
      return this.statisticsConfigStatisticsMode;
   }

   public List<MesDrillHoleConfigDetailSaveDTOParam> getDetailList() {
      return this.detailList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMachinePartType(final Integer machinePartType) {
      this.machinePartType = machinePartType;
   }

   public void setSteelClassificationId(final Long steelClassificationId) {
      this.steelClassificationId = steelClassificationId;
   }

   public void setStatisticsMode(final Integer statisticsMode) {
      this.statisticsMode = statisticsMode;
   }

   public void setProcessIdList(final List<Long> processIdList) {
      this.processIdList = processIdList;
   }

   public void setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
   }

   public void setMeasurementManner(final Integer measurementManner) {
      this.measurementManner = measurementManner;
   }

   public void setOrganizationInsidePrice(final BigDecimal organizationInsidePrice) {
      this.organizationInsidePrice = organizationInsidePrice;
   }

   public void setOrganizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
      this.organizationOutsidePrice = organizationOutsidePrice;
   }

   public void setFixedPrice(final BigDecimal fixedPrice) {
      this.fixedPrice = fixedPrice;
   }

   public void setStatisticsConfigStatisticsMode(final Integer statisticsConfigStatisticsMode) {
      this.statisticsConfigStatisticsMode = statisticsConfigStatisticsMode;
   }

   public void setDetailList(final List<MesDrillHoleConfigDetailSaveDTOParam> detailList) {
      this.detailList = detailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesDrillHoleConfigSaveDTOParam)) {
         return false;
      }

      MesDrillHoleConfigSaveDTOParam other = (MesDrillHoleConfigSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$machinePartType = this.getMachinePartType();
         Object other$machinePartType = other.getMachinePartType();
         if (this$machinePartType == null ? other$machinePartType == null : this$machinePartType.equals(other$machinePartType)) {
            Object this$steelClassificationId = this.getSteelClassificationId();
            Object other$steelClassificationId = other.getSteelClassificationId();
            if (this$steelClassificationId == null ? other$steelClassificationId == null : this$steelClassificationId.equals(other$steelClassificationId)) {
               Object this$statisticsMode = this.getStatisticsMode();
               Object other$statisticsMode = other.getStatisticsMode();
               if (this$statisticsMode == null ? other$statisticsMode == null : this$statisticsMode.equals(other$statisticsMode)) {
                  Object this$pricingManner = this.getPricingManner();
                  Object other$pricingManner = other.getPricingManner();
                  if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
                     Object this$measurementManner = this.getMeasurementManner();
                     Object other$measurementManner = other.getMeasurementManner();
                     if (this$measurementManner == null ? other$measurementManner == null : this$measurementManner.equals(other$measurementManner)) {
                        Object this$statisticsConfigStatisticsMode = this.getStatisticsConfigStatisticsMode();
                        Object other$statisticsConfigStatisticsMode = other.getStatisticsConfigStatisticsMode();
                        if (this$statisticsConfigStatisticsMode == null
                           ? other$statisticsConfigStatisticsMode == null
                           : this$statisticsConfigStatisticsMode.equals(other$statisticsConfigStatisticsMode)) {
                           Object this$processIdList = this.getProcessIdList();
                           Object other$processIdList = other.getProcessIdList();
                           if (this$processIdList == null ? other$processIdList == null : this$processIdList.equals(other$processIdList)) {
                              Object this$organizationInsidePrice = this.getOrganizationInsidePrice();
                              Object other$organizationInsidePrice = other.getOrganizationInsidePrice();
                              if (this$organizationInsidePrice == null
                                 ? other$organizationInsidePrice == null
                                 : this$organizationInsidePrice.equals(other$organizationInsidePrice)) {
                                 Object this$organizationOutsidePrice = this.getOrganizationOutsidePrice();
                                 Object other$organizationOutsidePrice = other.getOrganizationOutsidePrice();
                                 if (this$organizationOutsidePrice == null
                                    ? other$organizationOutsidePrice == null
                                    : this$organizationOutsidePrice.equals(other$organizationOutsidePrice)) {
                                    Object this$fixedPrice = this.getFixedPrice();
                                    Object other$fixedPrice = other.getFixedPrice();
                                    if (this$fixedPrice == null ? other$fixedPrice == null : this$fixedPrice.equals(other$fixedPrice)) {
                                       Object this$detailList = this.getDetailList();
                                       Object other$detailList = other.getDetailList();
                                       return this$detailList == null ? other$detailList == null : this$detailList.equals(other$detailList);
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesDrillHoleConfigSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $machinePartType = this.getMachinePartType();
      result = result * 59 + ($machinePartType == null ? 43 : $machinePartType.hashCode());
      Object $steelClassificationId = this.getSteelClassificationId();
      result = result * 59 + ($steelClassificationId == null ? 43 : $steelClassificationId.hashCode());
      Object $statisticsMode = this.getStatisticsMode();
      result = result * 59 + ($statisticsMode == null ? 43 : $statisticsMode.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $measurementManner = this.getMeasurementManner();
      result = result * 59 + ($measurementManner == null ? 43 : $measurementManner.hashCode());
      Object $statisticsConfigStatisticsMode = this.getStatisticsConfigStatisticsMode();
      result = result * 59 + ($statisticsConfigStatisticsMode == null ? 43 : $statisticsConfigStatisticsMode.hashCode());
      Object $processIdList = this.getProcessIdList();
      result = result * 59 + ($processIdList == null ? 43 : $processIdList.hashCode());
      Object $organizationInsidePrice = this.getOrganizationInsidePrice();
      result = result * 59 + ($organizationInsidePrice == null ? 43 : $organizationInsidePrice.hashCode());
      Object $organizationOutsidePrice = this.getOrganizationOutsidePrice();
      result = result * 59 + ($organizationOutsidePrice == null ? 43 : $organizationOutsidePrice.hashCode());
      Object $fixedPrice = this.getFixedPrice();
      result = result * 59 + ($fixedPrice == null ? 43 : $fixedPrice.hashCode());
      Object $detailList = this.getDetailList();
      return result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
   }

   @Override
   public String toString() {
      return "MesDrillHoleConfigSaveDTOParam(id="
         + this.getId()
         + ", machinePartType="
         + this.getMachinePartType()
         + ", steelClassificationId="
         + this.getSteelClassificationId()
         + ", statisticsMode="
         + this.getStatisticsMode()
         + ", processIdList="
         + this.getProcessIdList()
         + ", pricingManner="
         + this.getPricingManner()
         + ", measurementManner="
         + this.getMeasurementManner()
         + ", organizationInsidePrice="
         + this.getOrganizationInsidePrice()
         + ", organizationOutsidePrice="
         + this.getOrganizationOutsidePrice()
         + ", fixedPrice="
         + this.getFixedPrice()
         + ", statisticsConfigStatisticsMode="
         + this.getStatisticsConfigStatisticsMode()
         + ", detailList="
         + this.getDetailList()
         + ")";
   }
}
