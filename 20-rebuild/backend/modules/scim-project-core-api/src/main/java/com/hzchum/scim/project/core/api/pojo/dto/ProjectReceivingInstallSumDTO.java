package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("收货安装统计类")
public class ProjectReceivingInstallSumDTO {
   @ApiModelProperty(name = "quantity", value = "清单数量", notes = "清单数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "总量(重量kg/长度m)")
   private BigDecimal mete;
   @ApiModelProperty(name = "quantity", value = "收货数量")
   private BigDecimal receivingQuantity;
   @ApiModelProperty(name = "receivingMete", value = "收货总量(重量kg/长度m)")
   private BigDecimal receivingMete;
   @ApiModelProperty(name = "quantity", value = "安装数量")
   private BigDecimal installQuantity;
   @ApiModelProperty(name = "installMete", value = "安装总量(重量kg/长度m)")
   private BigDecimal installMete;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;

   public static ProjectReceivingInstallSumDTO.ProjectReceivingInstallSumDTOBuilder builder() {
      return new ProjectReceivingInstallSumDTO.ProjectReceivingInstallSumDTOBuilder();
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getReceivingQuantity() {
      return this.receivingQuantity;
   }

   public BigDecimal getReceivingMete() {
      return this.receivingMete;
   }

   public BigDecimal getInstallQuantity() {
      return this.installQuantity;
   }

   public BigDecimal getInstallMete() {
      return this.installMete;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setReceivingQuantity(final BigDecimal receivingQuantity) {
      this.receivingQuantity = receivingQuantity;
   }

   public void setReceivingMete(final BigDecimal receivingMete) {
      this.receivingMete = receivingMete;
   }

   public void setInstallQuantity(final BigDecimal installQuantity) {
      this.installQuantity = installQuantity;
   }

   public void setInstallMete(final BigDecimal installMete) {
      this.installMete = installMete;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReceivingInstallSumDTO)) {
         return false;
      }

      ProjectReceivingInstallSumDTO other = (ProjectReceivingInstallSumDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$mete = this.getMete();
         Object other$mete = other.getMete();
         if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
            Object this$receivingQuantity = this.getReceivingQuantity();
            Object other$receivingQuantity = other.getReceivingQuantity();
            if (this$receivingQuantity == null ? other$receivingQuantity == null : this$receivingQuantity.equals(other$receivingQuantity)) {
               Object this$receivingMete = this.getReceivingMete();
               Object other$receivingMete = other.getReceivingMete();
               if (this$receivingMete == null ? other$receivingMete == null : this$receivingMete.equals(other$receivingMete)) {
                  Object this$installQuantity = this.getInstallQuantity();
                  Object other$installQuantity = other.getInstallQuantity();
                  if (this$installQuantity == null ? other$installQuantity == null : this$installQuantity.equals(other$installQuantity)) {
                     Object this$installMete = this.getInstallMete();
                     Object other$installMete = other.getInstallMete();
                     if (this$installMete == null ? other$installMete == null : this$installMete.equals(other$installMete)) {
                        Object this$measureUnit = this.getMeasureUnit();
                        Object other$measureUnit = other.getMeasureUnit();
                        if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                           Object this$accountingUnit = this.getAccountingUnit();
                           Object other$accountingUnit = other.getAccountingUnit();
                           return this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit);
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
      return other instanceof ProjectReceivingInstallSumDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $receivingQuantity = this.getReceivingQuantity();
      result = result * 59 + ($receivingQuantity == null ? 43 : $receivingQuantity.hashCode());
      Object $receivingMete = this.getReceivingMete();
      result = result * 59 + ($receivingMete == null ? 43 : $receivingMete.hashCode());
      Object $installQuantity = this.getInstallQuantity();
      result = result * 59 + ($installQuantity == null ? 43 : $installQuantity.hashCode());
      Object $installMete = this.getInstallMete();
      result = result * 59 + ($installMete == null ? 43 : $installMete.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      return result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReceivingInstallSumDTO(quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", receivingQuantity="
         + this.getReceivingQuantity()
         + ", receivingMete="
         + this.getReceivingMete()
         + ", installQuantity="
         + this.getInstallQuantity()
         + ", installMete="
         + this.getInstallMete()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ")";
   }

   public ProjectReceivingInstallSumDTO(
      final BigDecimal quantity,
      final BigDecimal mete,
      final BigDecimal receivingQuantity,
      final BigDecimal receivingMete,
      final BigDecimal installQuantity,
      final BigDecimal installMete,
      final String measureUnit,
      final String accountingUnit
   ) {
      this.quantity = quantity;
      this.mete = mete;
      this.receivingQuantity = receivingQuantity;
      this.receivingMete = receivingMete;
      this.installQuantity = installQuantity;
      this.installMete = installMete;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
   }

   public ProjectReceivingInstallSumDTO() {
   }

   public static class ProjectReceivingInstallSumDTOBuilder {
      private BigDecimal quantity;
      private BigDecimal mete;
      private BigDecimal receivingQuantity;
      private BigDecimal receivingMete;
      private BigDecimal installQuantity;
      private BigDecimal installMete;
      private String measureUnit;
      private String accountingUnit;

      ProjectReceivingInstallSumDTOBuilder() {
      }

      public ProjectReceivingInstallSumDTO.ProjectReceivingInstallSumDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectReceivingInstallSumDTO.ProjectReceivingInstallSumDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProjectReceivingInstallSumDTO.ProjectReceivingInstallSumDTOBuilder receivingQuantity(final BigDecimal receivingQuantity) {
         this.receivingQuantity = receivingQuantity;
         return this;
      }

      public ProjectReceivingInstallSumDTO.ProjectReceivingInstallSumDTOBuilder receivingMete(final BigDecimal receivingMete) {
         this.receivingMete = receivingMete;
         return this;
      }

      public ProjectReceivingInstallSumDTO.ProjectReceivingInstallSumDTOBuilder installQuantity(final BigDecimal installQuantity) {
         this.installQuantity = installQuantity;
         return this;
      }

      public ProjectReceivingInstallSumDTO.ProjectReceivingInstallSumDTOBuilder installMete(final BigDecimal installMete) {
         this.installMete = installMete;
         return this;
      }

      public ProjectReceivingInstallSumDTO.ProjectReceivingInstallSumDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectReceivingInstallSumDTO.ProjectReceivingInstallSumDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ProjectReceivingInstallSumDTO build() {
         return new ProjectReceivingInstallSumDTO(
            this.quantity, this.mete, this.receivingQuantity, this.receivingMete, this.installQuantity, this.installMete, this.measureUnit, this.accountingUnit
         );
      }

      @Override
      public String toString() {
         return "ProjectReceivingInstallSumDTO.ProjectReceivingInstallSumDTOBuilder(quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", receivingQuantity="
            + this.receivingQuantity
            + ", receivingMete="
            + this.receivingMete
            + ", installQuantity="
            + this.installQuantity
            + ", installMete="
            + this.installMete
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ")";
      }
   }
}
