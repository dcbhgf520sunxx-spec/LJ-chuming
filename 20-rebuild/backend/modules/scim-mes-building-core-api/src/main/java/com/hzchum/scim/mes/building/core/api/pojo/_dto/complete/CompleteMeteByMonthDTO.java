package com.hzchum.scim.mes.building.core.api.pojo._dto.complete;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "CompleteMeteByMonthDTO", description = "班组全年每月产量")
public class CompleteMeteByMonthDTO {
   @ApiModelProperty(name = "month", notes = "月份")
   @JsonProperty("month")
   @JSONField(name = "month")
   private Integer month;
   @ApiModelProperty(name = "mete", notes = "产量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;

   public static CompleteMeteByMonthDTO.CompleteMeteByMonthDTOBuilder builder() {
      return new CompleteMeteByMonthDTO.CompleteMeteByMonthDTOBuilder();
   }

   public CompleteMeteByMonthDTO() {
   }

   public CompleteMeteByMonthDTO(final Integer month, final BigDecimal mete) {
      this.month = month;
      this.mete = mete;
   }

   public Integer getMonth() {
      return this.month;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   @JsonProperty("month")
   public CompleteMeteByMonthDTO setMonth(final Integer month) {
      this.month = month;
      return this;
   }

   @JsonProperty("mete")
   public CompleteMeteByMonthDTO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CompleteMeteByMonthDTO)) {
         return false;
      } else {
         CompleteMeteByMonthDTO other = (CompleteMeteByMonthDTO)o;
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
      return other instanceof CompleteMeteByMonthDTO;
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

   @Override
   public String toString() {
      return "CompleteMeteByMonthDTO(month=" + this.getMonth() + ", mete=" + this.getMete() + ")";
   }

   public static class CompleteMeteByMonthDTOBuilder {
      private Integer month;
      private BigDecimal mete;

      CompleteMeteByMonthDTOBuilder() {
      }

      @JsonProperty("month")
      public CompleteMeteByMonthDTO.CompleteMeteByMonthDTOBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      @JsonProperty("mete")
      public CompleteMeteByMonthDTO.CompleteMeteByMonthDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public CompleteMeteByMonthDTO build() {
         return new CompleteMeteByMonthDTO(this.month, this.mete);
      }

      @Override
      public String toString() {
         return "CompleteMeteByMonthDTO.CompleteMeteByMonthDTOBuilder(month=" + this.month + ", mete=" + this.mete + ")";
      }
   }
}
