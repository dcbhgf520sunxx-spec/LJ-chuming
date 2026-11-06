package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "WorkshopMonthAndMeteDTO", description = "车间报表")
public class WorkshopMonthAndMeteDTO {
   @ApiModelProperty(name = "date", value = "月份")
   @JsonProperty("date")
   @JSONField(name = "date")
   private String date;
   @ApiModelProperty(name = "totalLength", value = "总长度 ")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;

   public String getDate() {
      return this.date;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   @JsonProperty("date")
   public WorkshopMonthAndMeteDTO setDate(final String date) {
      this.date = date;
      return this;
   }

   @JsonProperty("totalLength")
   public WorkshopMonthAndMeteDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @Override
   public String toString() {
      return "WorkshopMonthAndMeteDTO(date=" + this.getDate() + ", totalLength=" + this.getTotalLength() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof WorkshopMonthAndMeteDTO)) {
         return false;
      } else {
         WorkshopMonthAndMeteDTO other = (WorkshopMonthAndMeteDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$date = this.getDate();
            Object other$date = other.getDate();
            if (this$date == null ? other$date == null : this$date.equals(other$date)) {
               Object this$totalLength = this.getTotalLength();
               Object other$totalLength = other.getTotalLength();
               return this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WorkshopMonthAndMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $totalLength = this.getTotalLength();
      return result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
   }
}
