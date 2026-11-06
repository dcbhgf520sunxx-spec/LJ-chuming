package com.hzchum.scim.wms.core.api.pojo.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class CommonSummaryDTO {
   @ApiModelProperty(name = "yearMonth", value = "出/入日期")
   private String dateTime;
   @ApiModelProperty(name = "totalMete", value = "总重")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalMete;
   @ApiModelProperty(name = "totalCost", value = "总费用")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalCost;

   public static CommonSummaryDTO.CommonSummaryDTOBuilder builder() {
      return new CommonSummaryDTO.CommonSummaryDTOBuilder();
   }

   public String getDateTime() {
      return this.dateTime;
   }

   public BigDecimal getTotalMete() {
      return this.totalMete;
   }

   public BigDecimal getTotalCost() {
      return this.totalCost;
   }

   public void setDateTime(final String dateTime) {
      this.dateTime = dateTime;
   }

   public void setTotalMete(final BigDecimal totalMete) {
      this.totalMete = totalMete;
   }

   public void setTotalCost(final BigDecimal totalCost) {
      this.totalCost = totalCost;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CommonSummaryDTO)) {
         return false;
      }

      CommonSummaryDTO other = (CommonSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$dateTime = this.getDateTime();
      Object other$dateTime = other.getDateTime();
      if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
         Object this$totalMete = this.getTotalMete();
         Object other$totalMete = other.getTotalMete();
         if (this$totalMete == null ? other$totalMete == null : this$totalMete.equals(other$totalMete)) {
            Object this$totalCost = this.getTotalCost();
            Object other$totalCost = other.getTotalCost();
            return this$totalCost == null ? other$totalCost == null : this$totalCost.equals(other$totalCost);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CommonSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $totalMete = this.getTotalMete();
      result = result * 59 + ($totalMete == null ? 43 : $totalMete.hashCode());
      Object $totalCost = this.getTotalCost();
      return result * 59 + ($totalCost == null ? 43 : $totalCost.hashCode());
   }

   @Override
   public String toString() {
      return "CommonSummaryDTO(dateTime=" + this.getDateTime() + ", totalMete=" + this.getTotalMete() + ", totalCost=" + this.getTotalCost() + ")";
   }

   public CommonSummaryDTO(final String dateTime, final BigDecimal totalMete, final BigDecimal totalCost) {
      this.dateTime = dateTime;
      this.totalMete = totalMete;
      this.totalCost = totalCost;
   }

   public CommonSummaryDTO() {
   }

   public static class CommonSummaryDTOBuilder {
      private String dateTime;
      private BigDecimal totalMete;
      private BigDecimal totalCost;

      CommonSummaryDTOBuilder() {
      }

      public CommonSummaryDTO.CommonSummaryDTOBuilder dateTime(final String dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      public CommonSummaryDTO.CommonSummaryDTOBuilder totalMete(final BigDecimal totalMete) {
         this.totalMete = totalMete;
         return this;
      }

      public CommonSummaryDTO.CommonSummaryDTOBuilder totalCost(final BigDecimal totalCost) {
         this.totalCost = totalCost;
         return this;
      }

      public CommonSummaryDTO build() {
         return new CommonSummaryDTO(this.dateTime, this.totalMete, this.totalCost);
      }

      @Override
      public String toString() {
         return "CommonSummaryDTO.CommonSummaryDTOBuilder(dateTime=" + this.dateTime + ", totalMete=" + this.totalMete + ", totalCost=" + this.totalCost + ")";
      }
   }
}
