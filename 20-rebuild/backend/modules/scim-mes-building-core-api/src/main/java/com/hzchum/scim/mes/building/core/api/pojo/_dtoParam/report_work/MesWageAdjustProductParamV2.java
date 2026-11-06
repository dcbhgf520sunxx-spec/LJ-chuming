package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("工价调整产品新增修改Param")
public class MesWageAdjustProductParamV2 {
   @ApiModelProperty("产品类型")
   @NotNull(message = "产品类型不能为空")
   private Integer productTypeEnum;
   @ApiModelProperty("产品id")
   private Long productId;
   @ApiModelProperty("产品编号")
   @NotBlank(message = "产品编号不能为空")
   private String productSerialNumber;
   @ApiModelProperty("定额配置id")
   @NotNull(message = "定额配置不能为空")
   private Long quotaConfigId;
   @ApiModelProperty("定额编号")
   @NotBlank(message = "定额编号不能为空")
   private String quotaNumber;
   @ApiModelProperty("计算方式")
   private Integer calculationWay;
   @ApiModelProperty("单位")
   @NotBlank(message = "单位不能为空")
   private String unit;
   @ApiModelProperty("定额工价(元/?)")
   private BigDecimal quotaPrice;
   @ApiModelProperty("新工价(元/?)")
   private BigDecimal newPrice;
   @ApiModelProperty("编制内单价(元)")
   @NotNull(message = "编制内单价不能为空")
   private BigDecimal organizationInsidePrice;
   @ApiModelProperty("编制外单价(元)")
   @NotNull(message = "编制外单价不能为空")
   private BigDecimal organizationOutsidePrice;
   @ApiModelProperty("新编制内单价(元)")
   @NotNull(message = "新编制内单价不能为空")
   private BigDecimal newOrganizationInsidePrice;
   @ApiModelProperty("新编制外单价(元)")
   @NotNull(message = "新编制外单价不能为空")
   private BigDecimal newOrganizationOutsidePrice;

   public Integer getProductTypeEnum() {
      return this.productTypeEnum;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public Long getQuotaConfigId() {
      return this.quotaConfigId;
   }

   public String getQuotaNumber() {
      return this.quotaNumber;
   }

   public Integer getCalculationWay() {
      return this.calculationWay;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getQuotaPrice() {
      return this.quotaPrice;
   }

   public BigDecimal getNewPrice() {
      return this.newPrice;
   }

   public BigDecimal getOrganizationInsidePrice() {
      return this.organizationInsidePrice;
   }

   public BigDecimal getOrganizationOutsidePrice() {
      return this.organizationOutsidePrice;
   }

   public BigDecimal getNewOrganizationInsidePrice() {
      return this.newOrganizationInsidePrice;
   }

   public BigDecimal getNewOrganizationOutsidePrice() {
      return this.newOrganizationOutsidePrice;
   }

   public void setProductTypeEnum(final Integer productTypeEnum) {
      this.productTypeEnum = productTypeEnum;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   public void setQuotaConfigId(final Long quotaConfigId) {
      this.quotaConfigId = quotaConfigId;
   }

   public void setQuotaNumber(final String quotaNumber) {
      this.quotaNumber = quotaNumber;
   }

   public void setCalculationWay(final Integer calculationWay) {
      this.calculationWay = calculationWay;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setQuotaPrice(final BigDecimal quotaPrice) {
      this.quotaPrice = quotaPrice;
   }

   public void setNewPrice(final BigDecimal newPrice) {
      this.newPrice = newPrice;
   }

   public void setOrganizationInsidePrice(final BigDecimal organizationInsidePrice) {
      this.organizationInsidePrice = organizationInsidePrice;
   }

   public void setOrganizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
      this.organizationOutsidePrice = organizationOutsidePrice;
   }

   public void setNewOrganizationInsidePrice(final BigDecimal newOrganizationInsidePrice) {
      this.newOrganizationInsidePrice = newOrganizationInsidePrice;
   }

   public void setNewOrganizationOutsidePrice(final BigDecimal newOrganizationOutsidePrice) {
      this.newOrganizationOutsidePrice = newOrganizationOutsidePrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesWageAdjustProductParamV2)) {
         return false;
      }

      MesWageAdjustProductParamV2 other = (MesWageAdjustProductParamV2)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productTypeEnum = this.getProductTypeEnum();
      Object other$productTypeEnum = other.getProductTypeEnum();
      if (this$productTypeEnum == null ? other$productTypeEnum == null : this$productTypeEnum.equals(other$productTypeEnum)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$quotaConfigId = this.getQuotaConfigId();
            Object other$quotaConfigId = other.getQuotaConfigId();
            if (this$quotaConfigId == null ? other$quotaConfigId == null : this$quotaConfigId.equals(other$quotaConfigId)) {
               Object this$calculationWay = this.getCalculationWay();
               Object other$calculationWay = other.getCalculationWay();
               if (this$calculationWay == null ? other$calculationWay == null : this$calculationWay.equals(other$calculationWay)) {
                  Object this$productSerialNumber = this.getProductSerialNumber();
                  Object other$productSerialNumber = other.getProductSerialNumber();
                  if (this$productSerialNumber == null ? other$productSerialNumber == null : this$productSerialNumber.equals(other$productSerialNumber)) {
                     Object this$quotaNumber = this.getQuotaNumber();
                     Object other$quotaNumber = other.getQuotaNumber();
                     if (this$quotaNumber == null ? other$quotaNumber == null : this$quotaNumber.equals(other$quotaNumber)) {
                        Object this$unit = this.getUnit();
                        Object other$unit = other.getUnit();
                        if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                           Object this$quotaPrice = this.getQuotaPrice();
                           Object other$quotaPrice = other.getQuotaPrice();
                           if (this$quotaPrice == null ? other$quotaPrice == null : this$quotaPrice.equals(other$quotaPrice)) {
                              Object this$newPrice = this.getNewPrice();
                              Object other$newPrice = other.getNewPrice();
                              if (this$newPrice == null ? other$newPrice == null : this$newPrice.equals(other$newPrice)) {
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
                                       Object this$newOrganizationInsidePrice = this.getNewOrganizationInsidePrice();
                                       Object other$newOrganizationInsidePrice = other.getNewOrganizationInsidePrice();
                                       if (this$newOrganizationInsidePrice == null
                                          ? other$newOrganizationInsidePrice == null
                                          : this$newOrganizationInsidePrice.equals(other$newOrganizationInsidePrice)) {
                                          Object this$newOrganizationOutsidePrice = this.getNewOrganizationOutsidePrice();
                                          Object other$newOrganizationOutsidePrice = other.getNewOrganizationOutsidePrice();
                                          return this$newOrganizationOutsidePrice == null
                                             ? other$newOrganizationOutsidePrice == null
                                             : this$newOrganizationOutsidePrice.equals(other$newOrganizationOutsidePrice);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesWageAdjustProductParamV2;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productTypeEnum = this.getProductTypeEnum();
      result = result * 59 + ($productTypeEnum == null ? 43 : $productTypeEnum.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quotaConfigId = this.getQuotaConfigId();
      result = result * 59 + ($quotaConfigId == null ? 43 : $quotaConfigId.hashCode());
      Object $calculationWay = this.getCalculationWay();
      result = result * 59 + ($calculationWay == null ? 43 : $calculationWay.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $quotaNumber = this.getQuotaNumber();
      result = result * 59 + ($quotaNumber == null ? 43 : $quotaNumber.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $quotaPrice = this.getQuotaPrice();
      result = result * 59 + ($quotaPrice == null ? 43 : $quotaPrice.hashCode());
      Object $newPrice = this.getNewPrice();
      result = result * 59 + ($newPrice == null ? 43 : $newPrice.hashCode());
      Object $organizationInsidePrice = this.getOrganizationInsidePrice();
      result = result * 59 + ($organizationInsidePrice == null ? 43 : $organizationInsidePrice.hashCode());
      Object $organizationOutsidePrice = this.getOrganizationOutsidePrice();
      result = result * 59 + ($organizationOutsidePrice == null ? 43 : $organizationOutsidePrice.hashCode());
      Object $newOrganizationInsidePrice = this.getNewOrganizationInsidePrice();
      result = result * 59 + ($newOrganizationInsidePrice == null ? 43 : $newOrganizationInsidePrice.hashCode());
      Object $newOrganizationOutsidePrice = this.getNewOrganizationOutsidePrice();
      return result * 59 + ($newOrganizationOutsidePrice == null ? 43 : $newOrganizationOutsidePrice.hashCode());
   }

   @Override
   public String toString() {
      return "MesWageAdjustProductParamV2(productTypeEnum="
         + this.getProductTypeEnum()
         + ", productId="
         + this.getProductId()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", quotaConfigId="
         + this.getQuotaConfigId()
         + ", quotaNumber="
         + this.getQuotaNumber()
         + ", calculationWay="
         + this.getCalculationWay()
         + ", unit="
         + this.getUnit()
         + ", quotaPrice="
         + this.getQuotaPrice()
         + ", newPrice="
         + this.getNewPrice()
         + ", organizationInsidePrice="
         + this.getOrganizationInsidePrice()
         + ", organizationOutsidePrice="
         + this.getOrganizationOutsidePrice()
         + ", newOrganizationInsidePrice="
         + this.getNewOrganizationInsidePrice()
         + ", newOrganizationOutsidePrice="
         + this.getNewOrganizationOutsidePrice()
         + ")";
   }
}
