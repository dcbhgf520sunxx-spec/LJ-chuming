package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import io.swagger.annotations.ApiModelProperty;

public class SupplierSummaryLedgerQueryParam {
   @ApiModelProperty("筛选类型: 1采购合同 2分包合同 4制成品物流 8原材料物料")
   private Integer type;
   @ApiModelProperty("是否有应付 true是  false否")
   private Boolean boolHavePayable;
   @ApiModelProperty("是否欠税 true是  false否")
   private Boolean boolArrearsTax;
   @ApiModelProperty(notes = "供应商名称")
   private String supplierName;

   public Integer getType() {
      return this.type;
   }

   public Boolean getBoolHavePayable() {
      return this.boolHavePayable;
   }

   public Boolean getBoolArrearsTax() {
      return this.boolArrearsTax;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setBoolHavePayable(final Boolean boolHavePayable) {
      this.boolHavePayable = boolHavePayable;
   }

   public void setBoolArrearsTax(final Boolean boolArrearsTax) {
      this.boolArrearsTax = boolArrearsTax;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierSummaryLedgerQueryParam)) {
         return false;
      }

      SupplierSummaryLedgerQueryParam other = (SupplierSummaryLedgerQueryParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$boolHavePayable = this.getBoolHavePayable();
         Object other$boolHavePayable = other.getBoolHavePayable();
         if (this$boolHavePayable == null ? other$boolHavePayable == null : this$boolHavePayable.equals(other$boolHavePayable)) {
            Object this$boolArrearsTax = this.getBoolArrearsTax();
            Object other$boolArrearsTax = other.getBoolArrearsTax();
            if (this$boolArrearsTax == null ? other$boolArrearsTax == null : this$boolArrearsTax.equals(other$boolArrearsTax)) {
               Object this$supplierName = this.getSupplierName();
               Object other$supplierName = other.getSupplierName();
               return this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName);
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
      return other instanceof SupplierSummaryLedgerQueryParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $boolHavePayable = this.getBoolHavePayable();
      result = result * 59 + ($boolHavePayable == null ? 43 : $boolHavePayable.hashCode());
      Object $boolArrearsTax = this.getBoolArrearsTax();
      result = result * 59 + ($boolArrearsTax == null ? 43 : $boolArrearsTax.hashCode());
      Object $supplierName = this.getSupplierName();
      return result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierSummaryLedgerQueryParam(type="
         + this.getType()
         + ", boolHavePayable="
         + this.getBoolHavePayable()
         + ", boolArrearsTax="
         + this.getBoolArrearsTax()
         + ", supplierName="
         + this.getSupplierName()
         + ")";
   }
}
