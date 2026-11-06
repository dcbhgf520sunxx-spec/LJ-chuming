package com.hzchum.scim.business.core.api.pojo.dtoParam;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

public class ProductionControlCheckDetailDTOParam {
   @NotNull(message = "id不能为空")
   private Long id;
   @NotNull(message = "启用状态不能为空")
   private Boolean boolEnableEnum;
   @NotNull(message = "损耗系数不能为空")
   private BigDecimal lossFactor;

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolEnableEnum() {
      return this.boolEnableEnum;
   }

   public BigDecimal getLossFactor() {
      return this.lossFactor;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBoolEnableEnum(final Boolean boolEnableEnum) {
      this.boolEnableEnum = boolEnableEnum;
   }

   public void setLossFactor(final BigDecimal lossFactor) {
      this.lossFactor = lossFactor;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionControlCheckDetailDTOParam)) {
         return false;
      }

      ProductionControlCheckDetailDTOParam other = (ProductionControlCheckDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolEnableEnum = this.getBoolEnableEnum();
         Object other$boolEnableEnum = other.getBoolEnableEnum();
         if (this$boolEnableEnum == null ? other$boolEnableEnum == null : this$boolEnableEnum.equals(other$boolEnableEnum)) {
            Object this$lossFactor = this.getLossFactor();
            Object other$lossFactor = other.getLossFactor();
            return this$lossFactor == null ? other$lossFactor == null : this$lossFactor.equals(other$lossFactor);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductionControlCheckDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolEnableEnum = this.getBoolEnableEnum();
      result = result * 59 + ($boolEnableEnum == null ? 43 : $boolEnableEnum.hashCode());
      Object $lossFactor = this.getLossFactor();
      return result * 59 + ($lossFactor == null ? 43 : $lossFactor.hashCode());
   }

   @Override
   public String toString() {
      return "ProductionControlCheckDetailDTOParam(id="
         + this.getId()
         + ", boolEnableEnum="
         + this.getBoolEnableEnum()
         + ", lossFactor="
         + this.getLossFactor()
         + ")";
   }
}
