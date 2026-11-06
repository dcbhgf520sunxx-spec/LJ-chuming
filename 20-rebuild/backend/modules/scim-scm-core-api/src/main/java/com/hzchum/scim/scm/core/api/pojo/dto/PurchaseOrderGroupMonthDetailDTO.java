package com.hzchum.scim.scm.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("采购订单月度")
public class PurchaseOrderGroupMonthDetailDTO {
   @ApiModelProperty(name = "index")
   private String index;
   @ApiModelProperty(name = "purchaseSn", value = "采购单号", notes = "采购单号")
   private String purchaseSn;
   @ApiModelProperty("购方单位(签订主体名称)")
   private String branchCompanyName;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型", notes = "物料基础类型")
   private Integer basicClass;
   @ApiModelProperty(name = "amount", value = "订单金额", notes = "订单金额")
   private BigDecimal amount;

   public static PurchaseOrderGroupMonthDetailDTO.PurchaseOrderGroupMonthDetailDTOBuilder builder() {
      return new PurchaseOrderGroupMonthDetailDTO.PurchaseOrderGroupMonthDetailDTOBuilder();
   }

   public String getIndex() {
      return this.index;
   }

   public String getPurchaseSn() {
      return this.purchaseSn;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public void setIndex(final String index) {
      this.index = index;
   }

   public void setPurchaseSn(final String purchaseSn) {
      this.purchaseSn = purchaseSn;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseOrderGroupMonthDetailDTO)) {
         return false;
      }

      PurchaseOrderGroupMonthDetailDTO other = (PurchaseOrderGroupMonthDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$index = this.getIndex();
         Object other$index = other.getIndex();
         if (this$index == null ? other$index == null : this$index.equals(other$index)) {
            Object this$purchaseSn = this.getPurchaseSn();
            Object other$purchaseSn = other.getPurchaseSn();
            if (this$purchaseSn == null ? other$purchaseSn == null : this$purchaseSn.equals(other$purchaseSn)) {
               Object this$branchCompanyName = this.getBranchCompanyName();
               Object other$branchCompanyName = other.getBranchCompanyName();
               if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PurchaseOrderGroupMonthDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $index = this.getIndex();
      result = result * 59 + ($index == null ? 43 : $index.hashCode());
      Object $purchaseSn = this.getPurchaseSn();
      result = result * 59 + ($purchaseSn == null ? 43 : $purchaseSn.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $amount = this.getAmount();
      return result * 59 + ($amount == null ? 43 : $amount.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseOrderGroupMonthDetailDTO(index="
         + this.getIndex()
         + ", purchaseSn="
         + this.getPurchaseSn()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", basicClass="
         + this.getBasicClass()
         + ", amount="
         + this.getAmount()
         + ")";
   }

   public PurchaseOrderGroupMonthDetailDTO(
      final String index, final String purchaseSn, final String branchCompanyName, final Integer basicClass, final BigDecimal amount
   ) {
      this.index = index;
      this.purchaseSn = purchaseSn;
      this.branchCompanyName = branchCompanyName;
      this.basicClass = basicClass;
      this.amount = amount;
   }

   public PurchaseOrderGroupMonthDetailDTO() {
   }

   public static class PurchaseOrderGroupMonthDetailDTOBuilder {
      private String index;
      private String purchaseSn;
      private String branchCompanyName;
      private Integer basicClass;
      private BigDecimal amount;

      PurchaseOrderGroupMonthDetailDTOBuilder() {
      }

      public PurchaseOrderGroupMonthDetailDTO.PurchaseOrderGroupMonthDetailDTOBuilder index(final String index) {
         this.index = index;
         return this;
      }

      public PurchaseOrderGroupMonthDetailDTO.PurchaseOrderGroupMonthDetailDTOBuilder purchaseSn(final String purchaseSn) {
         this.purchaseSn = purchaseSn;
         return this;
      }

      public PurchaseOrderGroupMonthDetailDTO.PurchaseOrderGroupMonthDetailDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public PurchaseOrderGroupMonthDetailDTO.PurchaseOrderGroupMonthDetailDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public PurchaseOrderGroupMonthDetailDTO.PurchaseOrderGroupMonthDetailDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public PurchaseOrderGroupMonthDetailDTO build() {
         return new PurchaseOrderGroupMonthDetailDTO(this.index, this.purchaseSn, this.branchCompanyName, this.basicClass, this.amount);
      }

      @Override
      public String toString() {
         return "PurchaseOrderGroupMonthDetailDTO.PurchaseOrderGroupMonthDetailDTOBuilder(index="
            + this.index
            + ", purchaseSn="
            + this.purchaseSn
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", basicClass="
            + this.basicClass
            + ", amount="
            + this.amount
            + ")";
      }
   }
}
