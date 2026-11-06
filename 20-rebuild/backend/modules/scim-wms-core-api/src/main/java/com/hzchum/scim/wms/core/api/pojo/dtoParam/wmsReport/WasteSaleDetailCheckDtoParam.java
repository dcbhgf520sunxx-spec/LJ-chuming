package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

@ApiModel(value = "WasteSaleDetail对象", description = "废料出售明细表 ")
public class WasteSaleDetailCheckDtoParam {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "price", value = "单价(元)", notes = "单价(元)")
   @DecimalMin(value = "0.0", message = "单价不能为负数!")
   private BigDecimal price;
   @ApiModelProperty(name = "amount", value = "金额 = 销量*单价", notes = "金额 = 销量*单价")
   @DecimalMin(value = "0.0", message = "金额不能为负数!")
   private BigDecimal amount;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @Size(max = 255, message = "销售明细备注字数太长!")
   private String remark;

   public static WasteSaleDetailCheckDtoParam.WasteSaleDetailCheckDtoParamBuilder builder() {
      return new WasteSaleDetailCheckDtoParam.WasteSaleDetailCheckDtoParamBuilder();
   }

   public WasteSaleDetailCheckDtoParam() {
   }

   public WasteSaleDetailCheckDtoParam(final Long id, final BigDecimal price, final BigDecimal amount, final String remark) {
      this.id = id;
      this.price = price;
      this.amount = amount;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WasteSaleDetailCheckDtoParam)) {
         return false;
      }

      WasteSaleDetailCheckDtoParam other = (WasteSaleDetailCheckDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$price = this.getPrice();
         Object other$price = other.getPrice();
         if (this$price == null ? other$price == null : this$price.equals(other$price)) {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
               Object this$remark = this.getRemark();
               Object other$remark = other.getRemark();
               return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof WasteSaleDetailCheckDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "WasteSaleDetailCheckDtoParam(id="
         + this.getId()
         + ", price="
         + this.getPrice()
         + ", amount="
         + this.getAmount()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class WasteSaleDetailCheckDtoParamBuilder {
      private Long id;
      private BigDecimal price;
      private BigDecimal amount;
      private String remark;

      WasteSaleDetailCheckDtoParamBuilder() {
      }

      public WasteSaleDetailCheckDtoParam.WasteSaleDetailCheckDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WasteSaleDetailCheckDtoParam.WasteSaleDetailCheckDtoParamBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public WasteSaleDetailCheckDtoParam.WasteSaleDetailCheckDtoParamBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public WasteSaleDetailCheckDtoParam.WasteSaleDetailCheckDtoParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public WasteSaleDetailCheckDtoParam build() {
         return new WasteSaleDetailCheckDtoParam(this.id, this.price, this.amount, this.remark);
      }

      @Override
      public String toString() {
         return "WasteSaleDetailCheckDtoParam.WasteSaleDetailCheckDtoParamBuilder(id="
            + this.id
            + ", price="
            + this.price
            + ", amount="
            + this.amount
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
