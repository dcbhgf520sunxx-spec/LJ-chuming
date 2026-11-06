package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UnfreezeDTOParam {
   private Long id;
   @NotNull(message = "解冻数量不能为空")
   @Min(value = 0L, message = "解冻数量为零,请重新操作")
   private BigDecimal quantity;
   private String remark;

   public static UnfreezeDTOParam.UnfreezeDTOParamBuilder builder() {
      return new UnfreezeDTOParam.UnfreezeDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UnfreezeDTOParam)) {
         return false;
      }

      UnfreezeDTOParam other = (UnfreezeDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$remark = this.getRemark();
            Object other$remark = other.getRemark();
            return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UnfreezeDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "UnfreezeDTOParam(id=" + this.getId() + ", quantity=" + this.getQuantity() + ", remark=" + this.getRemark() + ")";
   }

   public UnfreezeDTOParam(final Long id, final BigDecimal quantity, final String remark) {
      this.id = id;
      this.quantity = quantity;
      this.remark = remark;
   }

   public UnfreezeDTOParam() {
   }

   public static class UnfreezeDTOParamBuilder {
      private Long id;
      private BigDecimal quantity;
      private String remark;

      UnfreezeDTOParamBuilder() {
      }

      public UnfreezeDTOParam.UnfreezeDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public UnfreezeDTOParam.UnfreezeDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public UnfreezeDTOParam.UnfreezeDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public UnfreezeDTOParam build() {
         return new UnfreezeDTOParam(this.id, this.quantity, this.remark);
      }

      @Override
      public String toString() {
         return "UnfreezeDTOParam.UnfreezeDTOParamBuilder(id=" + this.id + ", quantity=" + this.quantity + ", remark=" + this.remark + ")";
      }
   }
}
