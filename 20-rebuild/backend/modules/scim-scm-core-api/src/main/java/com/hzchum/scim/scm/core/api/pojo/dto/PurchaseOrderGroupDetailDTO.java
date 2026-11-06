package com.hzchum.scim.scm.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("采购月度详情")
public class PurchaseOrderGroupDetailDTO {
   @ApiModelProperty(name = "index")
   private String index;
   @ApiModelProperty(name = "materialType", value = "材料类型", notes = "材料类型")
   private Integer materialType;
   @ApiModelProperty(name = "materialTypeName", value = "材料类型", notes = "材料类型")
   private String materialTypeName;
   @ApiModelProperty(name = "supplierName", value = "供应商", notes = "供应商")
   private String supplierName;
   @ApiModelProperty(name = "amount", value = "订单金额", notes = "订单金额")
   private BigDecimal amount;
   @ApiModelProperty(name = "dateTime", value = "日期", notes = "日期")
   private String dateTime;

   public static PurchaseOrderGroupDetailDTO.PurchaseOrderGroupDetailDTOBuilder builder() {
      return new PurchaseOrderGroupDetailDTO.PurchaseOrderGroupDetailDTOBuilder();
   }

   public String getIndex() {
      return this.index;
   }

   public Integer getMaterialType() {
      return this.materialType;
   }

   public String getMaterialTypeName() {
      return this.materialTypeName;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public String getDateTime() {
      return this.dateTime;
   }

   public void setIndex(final String index) {
      this.index = index;
   }

   public void setMaterialType(final Integer materialType) {
      this.materialType = materialType;
   }

   public void setMaterialTypeName(final String materialTypeName) {
      this.materialTypeName = materialTypeName;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setDateTime(final String dateTime) {
      this.dateTime = dateTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseOrderGroupDetailDTO)) {
         return false;
      }

      PurchaseOrderGroupDetailDTO other = (PurchaseOrderGroupDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$materialType = this.getMaterialType();
      Object other$materialType = other.getMaterialType();
      if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
         Object this$index = this.getIndex();
         Object other$index = other.getIndex();
         if (this$index == null ? other$index == null : this$index.equals(other$index)) {
            Object this$materialTypeName = this.getMaterialTypeName();
            Object other$materialTypeName = other.getMaterialTypeName();
            if (this$materialTypeName == null ? other$materialTypeName == null : this$materialTypeName.equals(other$materialTypeName)) {
               Object this$supplierName = this.getSupplierName();
               Object other$supplierName = other.getSupplierName();
               if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                  Object this$amount = this.getAmount();
                  Object other$amount = other.getAmount();
                  if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                     Object this$dateTime = this.getDateTime();
                     Object other$dateTime = other.getDateTime();
                     return this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime);
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
      return other instanceof PurchaseOrderGroupDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $index = this.getIndex();
      result = result * 59 + ($index == null ? 43 : $index.hashCode());
      Object $materialTypeName = this.getMaterialTypeName();
      result = result * 59 + ($materialTypeName == null ? 43 : $materialTypeName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $dateTime = this.getDateTime();
      return result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseOrderGroupDetailDTO(index="
         + this.getIndex()
         + ", materialType="
         + this.getMaterialType()
         + ", materialTypeName="
         + this.getMaterialTypeName()
         + ", supplierName="
         + this.getSupplierName()
         + ", amount="
         + this.getAmount()
         + ", dateTime="
         + this.getDateTime()
         + ")";
   }

   public PurchaseOrderGroupDetailDTO(
      final String index, final Integer materialType, final String materialTypeName, final String supplierName, final BigDecimal amount, final String dateTime
   ) {
      this.index = index;
      this.materialType = materialType;
      this.materialTypeName = materialTypeName;
      this.supplierName = supplierName;
      this.amount = amount;
      this.dateTime = dateTime;
   }

   public PurchaseOrderGroupDetailDTO() {
   }

   public static class PurchaseOrderGroupDetailDTOBuilder {
      private String index;
      private Integer materialType;
      private String materialTypeName;
      private String supplierName;
      private BigDecimal amount;
      private String dateTime;

      PurchaseOrderGroupDetailDTOBuilder() {
      }

      public PurchaseOrderGroupDetailDTO.PurchaseOrderGroupDetailDTOBuilder index(final String index) {
         this.index = index;
         return this;
      }

      public PurchaseOrderGroupDetailDTO.PurchaseOrderGroupDetailDTOBuilder materialType(final Integer materialType) {
         this.materialType = materialType;
         return this;
      }

      public PurchaseOrderGroupDetailDTO.PurchaseOrderGroupDetailDTOBuilder materialTypeName(final String materialTypeName) {
         this.materialTypeName = materialTypeName;
         return this;
      }

      public PurchaseOrderGroupDetailDTO.PurchaseOrderGroupDetailDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public PurchaseOrderGroupDetailDTO.PurchaseOrderGroupDetailDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public PurchaseOrderGroupDetailDTO.PurchaseOrderGroupDetailDTOBuilder dateTime(final String dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      public PurchaseOrderGroupDetailDTO build() {
         return new PurchaseOrderGroupDetailDTO(this.index, this.materialType, this.materialTypeName, this.supplierName, this.amount, this.dateTime);
      }

      @Override
      public String toString() {
         return "PurchaseOrderGroupDetailDTO.PurchaseOrderGroupDetailDTOBuilder(index="
            + this.index
            + ", materialType="
            + this.materialType
            + ", materialTypeName="
            + this.materialTypeName
            + ", supplierName="
            + this.supplierName
            + ", amount="
            + this.amount
            + ", dateTime="
            + this.dateTime
            + ")";
      }
   }
}
