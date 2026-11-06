package com.hzchum.scim.mes.building.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "CompleteSummaryDO", description = "完成统计工具类")
public class CompleteSummaryDO {
   @ApiModelProperty(name = "quantity", notes = "清单数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "mate", notes = "清单量")
   @JsonProperty("mate")
   @JSONField(name = "mate")
   private BigDecimal mate;
   @ApiModelProperty(name = "completeMate", notes = "完成清单量")
   @JsonProperty("completeMate")
   @JSONField(name = "completeMate")
   private BigDecimal completeMate;

   public static CompleteSummaryDO.CompleteSummaryDOBuilder builder() {
      return new CompleteSummaryDO.CompleteSummaryDOBuilder();
   }

   public CompleteSummaryDO() {
   }

   public CompleteSummaryDO(final Integer quantity, final Integer completeQuantity, final BigDecimal mate, final BigDecimal completeMate) {
      this.quantity = quantity;
      this.completeQuantity = completeQuantity;
      this.mate = mate;
      this.completeMate = completeMate;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getMate() {
      return this.mate;
   }

   public BigDecimal getCompleteMate() {
      return this.completeMate;
   }

   @JsonProperty("quantity")
   public CompleteSummaryDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public CompleteSummaryDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("mate")
   public CompleteSummaryDO setMate(final BigDecimal mate) {
      this.mate = mate;
      return this;
   }

   @JsonProperty("completeMate")
   public CompleteSummaryDO setCompleteMate(final BigDecimal completeMate) {
      this.completeMate = completeMate;
      return this;
   }

   @Override
   public String toString() {
      return "CompleteSummaryDO(quantity="
         + this.getQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", mate="
         + this.getMate()
         + ", completeMate="
         + this.getCompleteMate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CompleteSummaryDO)) {
         return false;
      }

      CompleteSummaryDO other = (CompleteSummaryDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$completeQuantity = this.getCompleteQuantity();
         Object other$completeQuantity = other.getCompleteQuantity();
         if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
            Object this$mate = this.getMate();
            Object other$mate = other.getMate();
            if (this$mate == null ? other$mate == null : this$mate.equals(other$mate)) {
               Object this$completeMate = this.getCompleteMate();
               Object other$completeMate = other.getCompleteMate();
               return this$completeMate == null ? other$completeMate == null : this$completeMate.equals(other$completeMate);
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
      return other instanceof CompleteSummaryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $mate = this.getMate();
      result = result * 59 + ($mate == null ? 43 : $mate.hashCode());
      Object $completeMate = this.getCompleteMate();
      return result * 59 + ($completeMate == null ? 43 : $completeMate.hashCode());
   }

   public static class CompleteSummaryDOBuilder {
      private Integer quantity;
      private Integer completeQuantity;
      private BigDecimal mate;
      private BigDecimal completeMate;

      CompleteSummaryDOBuilder() {
      }

      @JsonProperty("quantity")
      public CompleteSummaryDO.CompleteSummaryDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public CompleteSummaryDO.CompleteSummaryDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("mate")
      public CompleteSummaryDO.CompleteSummaryDOBuilder mate(final BigDecimal mate) {
         this.mate = mate;
         return this;
      }

      @JsonProperty("completeMate")
      public CompleteSummaryDO.CompleteSummaryDOBuilder completeMate(final BigDecimal completeMate) {
         this.completeMate = completeMate;
         return this;
      }

      public CompleteSummaryDO build() {
         return new CompleteSummaryDO(this.quantity, this.completeQuantity, this.mate, this.completeMate);
      }

      @Override
      public String toString() {
         return "CompleteSummaryDO.CompleteSummaryDOBuilder(quantity="
            + this.quantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", mate="
            + this.mate
            + ", completeMate="
            + this.completeMate
            + ")";
      }
   }
}
