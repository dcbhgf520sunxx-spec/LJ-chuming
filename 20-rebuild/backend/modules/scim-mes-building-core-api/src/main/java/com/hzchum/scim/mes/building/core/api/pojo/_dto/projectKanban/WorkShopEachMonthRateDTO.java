package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "WorkShopEachMonthRateDTO", description = "车间每月比率")
public class WorkShopEachMonthRateDTO {
   @ApiModelProperty(name = "date", value = "日期", notes = "日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   private String date;
   @ApiModelProperty(name = "workShopId", value = "车间id", notes = "车间id")
   @JsonProperty("workShopId")
   @JSONField(name = "workShopId")
   private Long workShopId;
   @ApiModelProperty(name = "workShopName", value = "车间名", notes = "车间名")
   @JsonProperty("workShopName")
   @JSONField(name = "workShopName")
   private String workShopName;
   @ApiModelProperty(name = "rate", value = "占比(百分比)", notes = "占比(百分比)")
   @JsonProperty("rate")
   @JSONField(name = "rate")
   private BigDecimal rate;

   public String getDate() {
      return this.date;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public String getWorkShopName() {
      return this.workShopName;
   }

   public BigDecimal getRate() {
      return this.rate;
   }

   @JsonProperty("date")
   public WorkShopEachMonthRateDTO setDate(final String date) {
      this.date = date;
      return this;
   }

   @JsonProperty("workShopId")
   public WorkShopEachMonthRateDTO setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
      return this;
   }

   @JsonProperty("workShopName")
   public WorkShopEachMonthRateDTO setWorkShopName(final String workShopName) {
      this.workShopName = workShopName;
      return this;
   }

   @JsonProperty("rate")
   public WorkShopEachMonthRateDTO setRate(final BigDecimal rate) {
      this.rate = rate;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkShopEachMonthRateDTO)) {
         return false;
      }

      WorkShopEachMonthRateDTO other = (WorkShopEachMonthRateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workShopId = this.getWorkShopId();
      Object other$workShopId = other.getWorkShopId();
      if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
         Object this$date = this.getDate();
         Object other$date = other.getDate();
         if (this$date == null ? other$date == null : this$date.equals(other$date)) {
            Object this$workShopName = this.getWorkShopName();
            Object other$workShopName = other.getWorkShopName();
            if (this$workShopName == null ? other$workShopName == null : this$workShopName.equals(other$workShopName)) {
               Object this$rate = this.getRate();
               Object other$rate = other.getRate();
               return this$rate == null ? other$rate == null : this$rate.equals(other$rate);
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
      return other instanceof WorkShopEachMonthRateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $workShopName = this.getWorkShopName();
      result = result * 59 + ($workShopName == null ? 43 : $workShopName.hashCode());
      Object $rate = this.getRate();
      return result * 59 + ($rate == null ? 43 : $rate.hashCode());
   }

   @Override
   public String toString() {
      return "WorkShopEachMonthRateDTO(date="
         + this.getDate()
         + ", workShopId="
         + this.getWorkShopId()
         + ", workShopName="
         + this.getWorkShopName()
         + ", rate="
         + this.getRate()
         + ")";
   }
}
