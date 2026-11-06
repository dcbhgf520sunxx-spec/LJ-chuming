package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class DateAndMeteDTO {
   @ApiModelProperty(name = "dateStr", value = "时间")
   private String dateStr;
   @ApiModelProperty(name = "value", value = "值")
   private BigDecimal value;

   public static DateAndMeteDTO.DateAndMeteDTOBuilder builder() {
      return new DateAndMeteDTO.DateAndMeteDTOBuilder();
   }

   public String getDateStr() {
      return this.dateStr;
   }

   public BigDecimal getValue() {
      return this.value;
   }

   public void setDateStr(final String dateStr) {
      this.dateStr = dateStr;
   }

   public void setValue(final BigDecimal value) {
      this.value = value;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof DateAndMeteDTO)) {
         return false;
      } else {
         DateAndMeteDTO other = (DateAndMeteDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$dateStr = this.getDateStr();
            Object other$dateStr = other.getDateStr();
            if (this$dateStr == null ? other$dateStr == null : this$dateStr.equals(other$dateStr)) {
               Object this$value = this.getValue();
               Object other$value = other.getValue();
               return this$value == null ? other$value == null : this$value.equals(other$value);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DateAndMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $dateStr = this.getDateStr();
      result = result * 59 + ($dateStr == null ? 43 : $dateStr.hashCode());
      Object $value = this.getValue();
      return result * 59 + ($value == null ? 43 : $value.hashCode());
   }

   @Override
   public String toString() {
      return "DateAndMeteDTO(dateStr=" + this.getDateStr() + ", value=" + this.getValue() + ")";
   }

   public DateAndMeteDTO(final String dateStr, final BigDecimal value) {
      this.dateStr = dateStr;
      this.value = value;
   }

   public DateAndMeteDTO() {
   }

   public static class DateAndMeteDTOBuilder {
      private String dateStr;
      private BigDecimal value;

      DateAndMeteDTOBuilder() {
      }

      public DateAndMeteDTO.DateAndMeteDTOBuilder dateStr(final String dateStr) {
         this.dateStr = dateStr;
         return this;
      }

      public DateAndMeteDTO.DateAndMeteDTOBuilder value(final BigDecimal value) {
         this.value = value;
         return this;
      }

      public DateAndMeteDTO build() {
         return new DateAndMeteDTO(this.dateStr, this.value);
      }

      @Override
      public String toString() {
         return "DateAndMeteDTO.DateAndMeteDTOBuilder(dateStr=" + this.dateStr + ", value=" + this.value + ")";
      }
   }
}
