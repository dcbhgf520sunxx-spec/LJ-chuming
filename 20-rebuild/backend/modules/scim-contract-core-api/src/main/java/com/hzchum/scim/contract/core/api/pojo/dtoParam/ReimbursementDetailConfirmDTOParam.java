package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel("报销明细-确认类")
public class ReimbursementDetailConfirmDTOParam {
   @ApiModelProperty(name = "id", value = "报销明细id")
   @NotNull(message = "报销明细id不能为空!")
   private Long id;
   @ApiModelProperty(name = "actuallyPayAmount", value = "实付金额")
   private BigDecimal actuallyPayAmount;

   public static ReimbursementDetailConfirmDTOParam.ReimbursementDetailConfirmDTOParamBuilder builder() {
      return new ReimbursementDetailConfirmDTOParam.ReimbursementDetailConfirmDTOParamBuilder();
   }

   public ReimbursementDetailConfirmDTOParam() {
   }

   public ReimbursementDetailConfirmDTOParam(final Long id, final BigDecimal actuallyPayAmount) {
      this.id = id;
      this.actuallyPayAmount = actuallyPayAmount;
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getActuallyPayAmount() {
      return this.actuallyPayAmount;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setActuallyPayAmount(final BigDecimal actuallyPayAmount) {
      this.actuallyPayAmount = actuallyPayAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ReimbursementDetailConfirmDTOParam)) {
         return false;
      } else {
         ReimbursementDetailConfirmDTOParam other = (ReimbursementDetailConfirmDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$actuallyPayAmount = this.getActuallyPayAmount();
               Object other$actuallyPayAmount = other.getActuallyPayAmount();
               return this$actuallyPayAmount == null ? other$actuallyPayAmount == null : this$actuallyPayAmount.equals(other$actuallyPayAmount);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ReimbursementDetailConfirmDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $actuallyPayAmount = this.getActuallyPayAmount();
      return result * 59 + ($actuallyPayAmount == null ? 43 : $actuallyPayAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ReimbursementDetailConfirmDTOParam(id=" + this.getId() + ", actuallyPayAmount=" + this.getActuallyPayAmount() + ")";
   }

   public static class ReimbursementDetailConfirmDTOParamBuilder {
      private Long id;
      private BigDecimal actuallyPayAmount;

      ReimbursementDetailConfirmDTOParamBuilder() {
      }

      public ReimbursementDetailConfirmDTOParam.ReimbursementDetailConfirmDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ReimbursementDetailConfirmDTOParam.ReimbursementDetailConfirmDTOParamBuilder actuallyPayAmount(final BigDecimal actuallyPayAmount) {
         this.actuallyPayAmount = actuallyPayAmount;
         return this;
      }

      public ReimbursementDetailConfirmDTOParam build() {
         return new ReimbursementDetailConfirmDTOParam(this.id, this.actuallyPayAmount);
      }

      @Override
      public String toString() {
         return "ReimbursementDetailConfirmDTOParam.ReimbursementDetailConfirmDTOParamBuilder(id="
            + this.id
            + ", actuallyPayAmount="
            + this.actuallyPayAmount
            + ")";
      }
   }
}
