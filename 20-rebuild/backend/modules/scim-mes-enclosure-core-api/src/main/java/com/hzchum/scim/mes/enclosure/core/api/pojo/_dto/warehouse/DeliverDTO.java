package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.warehouse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("交付量")
public class DeliverDTO {
   @ApiModelProperty(name = "month", value = "月份", notes = "月份")
   @JsonProperty("month")
   @JSONField(name = "month")
   private Integer month;
   @ApiModelProperty(name = "complete", value = "完成量", notes = "完成量")
   @JsonProperty("complete")
   @JSONField(name = "complete")
   private BigDecimal complete;

   public Integer getMonth() {
      return this.month;
   }

   public BigDecimal getComplete() {
      return this.complete;
   }

   @JsonProperty("month")
   public void setMonth(final Integer month) {
      this.month = month;
   }

   @JsonProperty("complete")
   public void setComplete(final BigDecimal complete) {
      this.complete = complete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof DeliverDTO)) {
         return false;
      } else {
         DeliverDTO other = (DeliverDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$month = this.getMonth();
            Object other$month = other.getMonth();
            if (this$month == null ? other$month == null : this$month.equals(other$month)) {
               Object this$complete = this.getComplete();
               Object other$complete = other.getComplete();
               return this$complete == null ? other$complete == null : this$complete.equals(other$complete);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DeliverDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $complete = this.getComplete();
      return result * 59 + ($complete == null ? 43 : $complete.hashCode());
   }

   @Override
   public String toString() {
      return "DeliverDTO(month=" + this.getMonth() + ", complete=" + this.getComplete() + ")";
   }
}
