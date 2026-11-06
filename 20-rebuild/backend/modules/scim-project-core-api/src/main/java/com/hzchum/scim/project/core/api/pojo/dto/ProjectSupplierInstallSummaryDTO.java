package com.hzchum.scim.project.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("项目下分包安装汇总返回类")
public class ProjectSupplierInstallSummaryDTO {
   @ApiModelProperty(name = "supplierId", value = "安装供应商id", notes = "安装供应商id")
   @JsonInclude(Include.NON_NULL)
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "安装供应商名称", notes = "安装供应商名称")
   @JsonInclude(Include.NON_NULL)
   private String supplierName;
   @ApiModelProperty(name = "productType", value = "产品类型(2构件 , 4围护 , 8配套件)")
   private Integer productType;
   @ApiModelProperty(name = "taskMete", value = "划分总量")
   private BigDecimal taskMete;
   @ApiModelProperty(name = "mete", value = "安装总量")
   private BigDecimal mete;
   @ApiModelProperty(name = "mete", value = "安装总件")
   private Integer quantity;
   @ApiModelProperty(name = "currentMonthMete", value = "本月安装总量")
   private BigDecimal currentMonthMete;
   @ApiModelProperty(name = "currentMonthQuantity", value = "本月安装总件")
   private Integer currentMonthQuantity;
   @ApiModelProperty(name = "lastMonthMete", value = "上月安装总量")
   private BigDecimal lastMonthMete;
   @ApiModelProperty(name = "lastMonthQuantity", value = "上月安装总件")
   private Integer lastMonthQuantity;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;

   public static ProjectSupplierInstallSummaryDTO.ProjectSupplierInstallSummaryDTOBuilder builder() {
      return new ProjectSupplierInstallSummaryDTO.ProjectSupplierInstallSummaryDTOBuilder();
   }

   public ProjectSupplierInstallSummaryDTO() {
   }

   public ProjectSupplierInstallSummaryDTO(
      final Long supplierId,
      final String supplierName,
      final Integer productType,
      final BigDecimal taskMete,
      final BigDecimal mete,
      final Integer quantity,
      final BigDecimal currentMonthMete,
      final Integer currentMonthQuantity,
      final BigDecimal lastMonthMete,
      final Integer lastMonthQuantity,
      final String measureUnit,
      final String accountingUnit
   ) {
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.productType = productType;
      this.taskMete = taskMete;
      this.mete = mete;
      this.quantity = quantity;
      this.currentMonthMete = currentMonthMete;
      this.currentMonthQuantity = currentMonthQuantity;
      this.lastMonthMete = lastMonthMete;
      this.lastMonthQuantity = lastMonthQuantity;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public BigDecimal getTaskMete() {
      return this.taskMete;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getCurrentMonthMete() {
      return this.currentMonthMete;
   }

   public Integer getCurrentMonthQuantity() {
      return this.currentMonthQuantity;
   }

   public BigDecimal getLastMonthMete() {
      return this.lastMonthMete;
   }

   public Integer getLastMonthQuantity() {
      return this.lastMonthQuantity;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setTaskMete(final BigDecimal taskMete) {
      this.taskMete = taskMete;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setCurrentMonthMete(final BigDecimal currentMonthMete) {
      this.currentMonthMete = currentMonthMete;
   }

   public void setCurrentMonthQuantity(final Integer currentMonthQuantity) {
      this.currentMonthQuantity = currentMonthQuantity;
   }

   public void setLastMonthMete(final BigDecimal lastMonthMete) {
      this.lastMonthMete = lastMonthMete;
   }

   public void setLastMonthQuantity(final Integer lastMonthQuantity) {
      this.lastMonthQuantity = lastMonthQuantity;
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

      if (!(o instanceof ProjectSupplierInstallSummaryDTO)) {
         return false;
      }

      ProjectSupplierInstallSummaryDTO other = (ProjectSupplierInstallSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$supplierId = this.getSupplierId();
      Object other$supplierId = other.getSupplierId();
      if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$currentMonthQuantity = this.getCurrentMonthQuantity();
               Object other$currentMonthQuantity = other.getCurrentMonthQuantity();
               if (this$currentMonthQuantity == null ? other$currentMonthQuantity == null : this$currentMonthQuantity.equals(other$currentMonthQuantity)) {
                  Object this$lastMonthQuantity = this.getLastMonthQuantity();
                  Object other$lastMonthQuantity = other.getLastMonthQuantity();
                  if (this$lastMonthQuantity == null ? other$lastMonthQuantity == null : this$lastMonthQuantity.equals(other$lastMonthQuantity)) {
                     Object this$supplierName = this.getSupplierName();
                     Object other$supplierName = other.getSupplierName();
                     if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                        Object this$taskMete = this.getTaskMete();
                        Object other$taskMete = other.getTaskMete();
                        if (this$taskMete == null ? other$taskMete == null : this$taskMete.equals(other$taskMete)) {
                           Object this$mete = this.getMete();
                           Object other$mete = other.getMete();
                           if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                              Object this$currentMonthMete = this.getCurrentMonthMete();
                              Object other$currentMonthMete = other.getCurrentMonthMete();
                              if (this$currentMonthMete == null ? other$currentMonthMete == null : this$currentMonthMete.equals(other$currentMonthMete)) {
                                 Object this$lastMonthMete = this.getLastMonthMete();
                                 Object other$lastMonthMete = other.getLastMonthMete();
                                 if (this$lastMonthMete == null ? other$lastMonthMete == null : this$lastMonthMete.equals(other$lastMonthMete)) {
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
      return other instanceof ProjectSupplierInstallSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $currentMonthQuantity = this.getCurrentMonthQuantity();
      result = result * 59 + ($currentMonthQuantity == null ? 43 : $currentMonthQuantity.hashCode());
      Object $lastMonthQuantity = this.getLastMonthQuantity();
      result = result * 59 + ($lastMonthQuantity == null ? 43 : $lastMonthQuantity.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $taskMete = this.getTaskMete();
      result = result * 59 + ($taskMete == null ? 43 : $taskMete.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $currentMonthMete = this.getCurrentMonthMete();
      result = result * 59 + ($currentMonthMete == null ? 43 : $currentMonthMete.hashCode());
      Object $lastMonthMete = this.getLastMonthMete();
      result = result * 59 + ($lastMonthMete == null ? 43 : $lastMonthMete.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      return result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSupplierInstallSummaryDTO(supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", productType="
         + this.getProductType()
         + ", taskMete="
         + this.getTaskMete()
         + ", mete="
         + this.getMete()
         + ", quantity="
         + this.getQuantity()
         + ", currentMonthMete="
         + this.getCurrentMonthMete()
         + ", currentMonthQuantity="
         + this.getCurrentMonthQuantity()
         + ", lastMonthMete="
         + this.getLastMonthMete()
         + ", lastMonthQuantity="
         + this.getLastMonthQuantity()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ")";
   }

   public static class ProjectSupplierInstallSummaryDTOBuilder {
      private Long supplierId;
      private String supplierName;
      private Integer productType;
      private BigDecimal taskMete;
      private BigDecimal mete;
      private Integer quantity;
      private BigDecimal currentMonthMete;
      private Integer currentMonthQuantity;
      private BigDecimal lastMonthMete;
      private Integer lastMonthQuantity;
      private String measureUnit;
      private String accountingUnit;

      ProjectSupplierInstallSummaryDTOBuilder() {
      }

      public ProjectSupplierInstallSummaryDTO.ProjectSupplierInstallSummaryDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectSupplierInstallSummaryDTO.ProjectSupplierInstallSummaryDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectSupplierInstallSummaryDTO.ProjectSupplierInstallSummaryDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectSupplierInstallSummaryDTO.ProjectSupplierInstallSummaryDTOBuilder taskMete(final BigDecimal taskMete) {
         this.taskMete = taskMete;
         return this;
      }

      public ProjectSupplierInstallSummaryDTO.ProjectSupplierInstallSummaryDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProjectSupplierInstallSummaryDTO.ProjectSupplierInstallSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectSupplierInstallSummaryDTO.ProjectSupplierInstallSummaryDTOBuilder currentMonthMete(final BigDecimal currentMonthMete) {
         this.currentMonthMete = currentMonthMete;
         return this;
      }

      public ProjectSupplierInstallSummaryDTO.ProjectSupplierInstallSummaryDTOBuilder currentMonthQuantity(final Integer currentMonthQuantity) {
         this.currentMonthQuantity = currentMonthQuantity;
         return this;
      }

      public ProjectSupplierInstallSummaryDTO.ProjectSupplierInstallSummaryDTOBuilder lastMonthMete(final BigDecimal lastMonthMete) {
         this.lastMonthMete = lastMonthMete;
         return this;
      }

      public ProjectSupplierInstallSummaryDTO.ProjectSupplierInstallSummaryDTOBuilder lastMonthQuantity(final Integer lastMonthQuantity) {
         this.lastMonthQuantity = lastMonthQuantity;
         return this;
      }

      public ProjectSupplierInstallSummaryDTO.ProjectSupplierInstallSummaryDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectSupplierInstallSummaryDTO.ProjectSupplierInstallSummaryDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ProjectSupplierInstallSummaryDTO build() {
         return new ProjectSupplierInstallSummaryDTO(
            this.supplierId,
            this.supplierName,
            this.productType,
            this.taskMete,
            this.mete,
            this.quantity,
            this.currentMonthMete,
            this.currentMonthQuantity,
            this.lastMonthMete,
            this.lastMonthQuantity,
            this.measureUnit,
            this.accountingUnit
         );
      }

      @Override
      public String toString() {
         return "ProjectSupplierInstallSummaryDTO.ProjectSupplierInstallSummaryDTOBuilder(supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", productType="
            + this.productType
            + ", taskMete="
            + this.taskMete
            + ", mete="
            + this.mete
            + ", quantity="
            + this.quantity
            + ", currentMonthMete="
            + this.currentMonthMete
            + ", currentMonthQuantity="
            + this.currentMonthQuantity
            + ", lastMonthMete="
            + this.lastMonthMete
            + ", lastMonthQuantity="
            + this.lastMonthQuantity
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ")";
      }
   }
}
