package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "项目加工进度")
public class SimpleProcessRate {
   @ApiModelProperty(name = "processName", value = "工序名称")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "rate", value = "工序完成率")
   @JsonProperty("rate")
   @JSONField(name = "rate")
   private BigDecimal rate;

   public static SimpleProcessRate.SimpleProcessRateBuilder builder() {
      return new SimpleProcessRate.SimpleProcessRateBuilder();
   }

   public String getProcessName() {
      return this.processName;
   }

   public BigDecimal getRate() {
      return this.rate;
   }

   @JsonProperty("processName")
   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   @JsonProperty("rate")
   public void setRate(final BigDecimal rate) {
      this.rate = rate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SimpleProcessRate)) {
         return false;
      } else {
         SimpleProcessRate other = (SimpleProcessRate)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$processName = this.getProcessName();
            Object other$processName = other.getProcessName();
            if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
               Object this$rate = this.getRate();
               Object other$rate = other.getRate();
               return this$rate == null ? other$rate == null : this$rate.equals(other$rate);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SimpleProcessRate;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $rate = this.getRate();
      return result * 59 + ($rate == null ? 43 : $rate.hashCode());
   }

   @Override
   public String toString() {
      return "SimpleProcessRate(super=" + super.toString() + ", processName=" + this.getProcessName() + ", rate=" + this.getRate() + ")";
   }

   public SimpleProcessRate(final String processName, final BigDecimal rate) {
      this.processName = processName;
      this.rate = rate;
   }

   public SimpleProcessRate() {
   }

   public static class SimpleProcessRateBuilder {
      private String processName;
      private BigDecimal rate;

      SimpleProcessRateBuilder() {
      }

      @JsonProperty("processName")
      public SimpleProcessRate.SimpleProcessRateBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("rate")
      public SimpleProcessRate.SimpleProcessRateBuilder rate(final BigDecimal rate) {
         this.rate = rate;
         return this;
      }

      public SimpleProcessRate build() {
         return new SimpleProcessRate(this.processName, this.rate);
      }

      @Override
      public String toString() {
         return "SimpleProcessRate.SimpleProcessRateBuilder(processName=" + this.processName + ", rate=" + this.rate + ")";
      }
   }
}
