package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "AvgProductionLineInfoDTO", description = "平均班组能力分析")
public class AvgProductionLineInfoDTO {
   @ApiModelProperty(name = "date", notes = "日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   private String date;
   @ApiModelProperty(name = "quantity", notes = "生产数量（个/月）")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private BigDecimal quantity;
   @ApiModelProperty(name = "avgLineTon", notes = "平均班组能力（吨/月）")
   @JsonProperty("avgLineTon")
   @JSONField(name = "avgLineTon")
   private BigDecimal avgLineTon;

   public String getDate() {
      return this.date;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getAvgLineTon() {
      return this.avgLineTon;
   }

   @JsonProperty("date")
   public AvgProductionLineInfoDTO setDate(final String date) {
      this.date = date;
      return this;
   }

   @JsonProperty("quantity")
   public AvgProductionLineInfoDTO setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("avgLineTon")
   public AvgProductionLineInfoDTO setAvgLineTon(final BigDecimal avgLineTon) {
      this.avgLineTon = avgLineTon;
      return this;
   }

   @Override
   public String toString() {
      return "AvgProductionLineInfoDTO(date=" + this.getDate() + ", quantity=" + this.getQuantity() + ", avgLineTon=" + this.getAvgLineTon() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AvgProductionLineInfoDTO)) {
         return false;
      }

      AvgProductionLineInfoDTO other = (AvgProductionLineInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$date = this.getDate();
      Object other$date = other.getDate();
      if (this$date == null ? other$date == null : this$date.equals(other$date)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$avgLineTon = this.getAvgLineTon();
            Object other$avgLineTon = other.getAvgLineTon();
            return this$avgLineTon == null ? other$avgLineTon == null : this$avgLineTon.equals(other$avgLineTon);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AvgProductionLineInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $avgLineTon = this.getAvgLineTon();
      return result * 59 + ($avgLineTon == null ? 43 : $avgLineTon.hashCode());
   }
}
