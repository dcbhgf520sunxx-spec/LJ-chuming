package com.hzchum.scim.mes.building.core.api.pojo._do.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "YearMeteDO", description = "产量统计按月分组 ")
public class YearMeteDO {
   @ApiModelProperty(name = "month", value = "月份")
   @JsonProperty("month")
   @JSONField(name = "month")
   private String month;
   @ApiModelProperty(name = "mete", value = "产量（kg）")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;

   public static YearMeteDO.YearMeteDOBuilder builder() {
      return new YearMeteDO.YearMeteDOBuilder();
   }

   public YearMeteDO() {
   }

   public YearMeteDO(final String month, final BigDecimal mete) {
      this.month = month;
      this.mete = mete;
   }

   public String getMonth() {
      return this.month;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   @JsonProperty("month")
   public YearMeteDO setMonth(final String month) {
      this.month = month;
      return this;
   }

   @JsonProperty("mete")
   public YearMeteDO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @Override
   public String toString() {
      return "YearMeteDO(month=" + this.getMonth() + ", mete=" + this.getMete() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof YearMeteDO)) {
         return false;
      } else {
         YearMeteDO other = (YearMeteDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$month = this.getMonth();
            Object other$month = other.getMonth();
            if (this$month == null ? other$month == null : this$month.equals(other$month)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof YearMeteDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   public static class YearMeteDOBuilder {
      private String month;
      private BigDecimal mete;

      YearMeteDOBuilder() {
      }

      @JsonProperty("month")
      public YearMeteDO.YearMeteDOBuilder month(final String month) {
         this.month = month;
         return this;
      }

      @JsonProperty("mete")
      public YearMeteDO.YearMeteDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public YearMeteDO build() {
         return new YearMeteDO(this.month, this.mete);
      }

      @Override
      public String toString() {
         return "YearMeteDO.YearMeteDOBuilder(month=" + this.month + ", mete=" + this.mete + ")";
      }
   }
}
