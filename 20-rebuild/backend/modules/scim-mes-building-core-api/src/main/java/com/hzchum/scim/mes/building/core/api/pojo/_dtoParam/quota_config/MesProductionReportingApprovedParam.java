package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("报工审核已审核编辑Param")
public class MesProductionReportingApprovedParam {
   @ApiModelProperty("id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty("车间id")
   @NotNull(message = "车间不能为空")
   private Long workshopId;
   @ApiModelProperty("班组id")
   @NotNull(message = "班组不能为空")
   private Long teamId;
   @ApiModelProperty("定额配置id")
   @NotNull(message = "定额编号不能为空")
   private Long quotaConfigId;
   @ApiModelProperty("定额配置编号")
   @NotBlank(message = "定额编号不能为空")
   private String quotaConfigSerialNumber;
   @ApiModelProperty("定额匹配条件")
   private String quotaMatchingCondition;
   @ApiModelProperty("计量单位")
   @NotBlank(message = "计量单位不能为空")
   private String measureUnit;
   @ApiModelProperty("计量量")
   @NotNull(message = "计量量不能为空")
   private BigDecimal measurementQuantity;
   @ApiModelProperty("单价(元)")
   @NotNull(message = "单价不能为空")
   private BigDecimal price;
   @ApiModelProperty("金额(元)")
   @NotNull(message = "金额不能为空")
   private BigDecimal amount;
   @ApiModelProperty("上报人id")
   @NotNull(message = "上报人不能为空")
   private Long reportPersonId;

   public Long getId() {
      return this.id;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getQuotaConfigId() {
      return this.quotaConfigId;
   }

   public String getQuotaConfigSerialNumber() {
      return this.quotaConfigSerialNumber;
   }

   public String getQuotaMatchingCondition() {
      return this.quotaMatchingCondition;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getMeasurementQuantity() {
      return this.measurementQuantity;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Long getReportPersonId() {
      return this.reportPersonId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   public void setQuotaConfigId(final Long quotaConfigId) {
      this.quotaConfigId = quotaConfigId;
   }

   public void setQuotaConfigSerialNumber(final String quotaConfigSerialNumber) {
      this.quotaConfigSerialNumber = quotaConfigSerialNumber;
   }

   public void setQuotaMatchingCondition(final String quotaMatchingCondition) {
      this.quotaMatchingCondition = quotaMatchingCondition;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMeasurementQuantity(final BigDecimal measurementQuantity) {
      this.measurementQuantity = measurementQuantity;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setReportPersonId(final Long reportPersonId) {
      this.reportPersonId = reportPersonId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProductionReportingApprovedParam)) {
         return false;
      }

      MesProductionReportingApprovedParam other = (MesProductionReportingApprovedParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
               Object this$quotaConfigId = this.getQuotaConfigId();
               Object other$quotaConfigId = other.getQuotaConfigId();
               if (this$quotaConfigId == null ? other$quotaConfigId == null : this$quotaConfigId.equals(other$quotaConfigId)) {
                  Object this$reportPersonId = this.getReportPersonId();
                  Object other$reportPersonId = other.getReportPersonId();
                  if (this$reportPersonId == null ? other$reportPersonId == null : this$reportPersonId.equals(other$reportPersonId)) {
                     Object this$quotaConfigSerialNumber = this.getQuotaConfigSerialNumber();
                     Object other$quotaConfigSerialNumber = other.getQuotaConfigSerialNumber();
                     if (this$quotaConfigSerialNumber == null
                        ? other$quotaConfigSerialNumber == null
                        : this$quotaConfigSerialNumber.equals(other$quotaConfigSerialNumber)) {
                        Object this$quotaMatchingCondition = this.getQuotaMatchingCondition();
                        Object other$quotaMatchingCondition = other.getQuotaMatchingCondition();
                        if (this$quotaMatchingCondition == null
                           ? other$quotaMatchingCondition == null
                           : this$quotaMatchingCondition.equals(other$quotaMatchingCondition)) {
                           Object this$measureUnit = this.getMeasureUnit();
                           Object other$measureUnit = other.getMeasureUnit();
                           if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                              Object this$measurementQuantity = this.getMeasurementQuantity();
                              Object other$measurementQuantity = other.getMeasurementQuantity();
                              if (this$measurementQuantity == null
                                 ? other$measurementQuantity == null
                                 : this$measurementQuantity.equals(other$measurementQuantity)) {
                                 Object this$price = this.getPrice();
                                 Object other$price = other.getPrice();
                                 if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                    Object this$amount = this.getAmount();
                                    Object other$amount = other.getAmount();
                                    return this$amount == null ? other$amount == null : this$amount.equals(other$amount);
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
      return other instanceof MesProductionReportingApprovedParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $quotaConfigId = this.getQuotaConfigId();
      result = result * 59 + ($quotaConfigId == null ? 43 : $quotaConfigId.hashCode());
      Object $reportPersonId = this.getReportPersonId();
      result = result * 59 + ($reportPersonId == null ? 43 : $reportPersonId.hashCode());
      Object $quotaConfigSerialNumber = this.getQuotaConfigSerialNumber();
      result = result * 59 + ($quotaConfigSerialNumber == null ? 43 : $quotaConfigSerialNumber.hashCode());
      Object $quotaMatchingCondition = this.getQuotaMatchingCondition();
      result = result * 59 + ($quotaMatchingCondition == null ? 43 : $quotaMatchingCondition.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $measurementQuantity = this.getMeasurementQuantity();
      result = result * 59 + ($measurementQuantity == null ? 43 : $measurementQuantity.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $amount = this.getAmount();
      return result * 59 + ($amount == null ? 43 : $amount.hashCode());
   }

   @Override
   public String toString() {
      return "MesProductionReportingApprovedParam(id="
         + this.getId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", teamId="
         + this.getTeamId()
         + ", quotaConfigId="
         + this.getQuotaConfigId()
         + ", quotaConfigSerialNumber="
         + this.getQuotaConfigSerialNumber()
         + ", quotaMatchingCondition="
         + this.getQuotaMatchingCondition()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", measurementQuantity="
         + this.getMeasurementQuantity()
         + ", price="
         + this.getPrice()
         + ", amount="
         + this.getAmount()
         + ", reportPersonId="
         + this.getReportPersonId()
         + ")";
   }
}
