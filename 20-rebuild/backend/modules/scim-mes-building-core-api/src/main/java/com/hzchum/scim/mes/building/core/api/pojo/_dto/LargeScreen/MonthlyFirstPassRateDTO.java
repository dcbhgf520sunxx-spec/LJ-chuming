package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(description = "月度质量问题统计对象")
public class MonthlyFirstPassRateDTO {
   private String date;
   private Integer InspectQuantity;
   private Integer qhseQuantity;
   private BigDecimal passingRate;

   public static MonthlyFirstPassRateDTO.MonthlyFirstPassRateDTOBuilder builder() {
      return new MonthlyFirstPassRateDTO.MonthlyFirstPassRateDTOBuilder();
   }

   public String getDate() {
      return this.date;
   }

   public Integer getInspectQuantity() {
      return this.InspectQuantity;
   }

   public Integer getQhseQuantity() {
      return this.qhseQuantity;
   }

   public BigDecimal getPassingRate() {
      return this.passingRate;
   }

   public void setDate(final String date) {
      this.date = date;
   }

   public void setInspectQuantity(final Integer InspectQuantity) {
      this.InspectQuantity = InspectQuantity;
   }

   public void setQhseQuantity(final Integer qhseQuantity) {
      this.qhseQuantity = qhseQuantity;
   }

   public void setPassingRate(final BigDecimal passingRate) {
      this.passingRate = passingRate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MonthlyFirstPassRateDTO)) {
         return false;
      }

      MonthlyFirstPassRateDTO other = (MonthlyFirstPassRateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$InspectQuantity = this.getInspectQuantity();
      Object other$InspectQuantity = other.getInspectQuantity();
      if (this$InspectQuantity == null ? other$InspectQuantity == null : this$InspectQuantity.equals(other$InspectQuantity)) {
         Object this$qhseQuantity = this.getQhseQuantity();
         Object other$qhseQuantity = other.getQhseQuantity();
         if (this$qhseQuantity == null ? other$qhseQuantity == null : this$qhseQuantity.equals(other$qhseQuantity)) {
            Object this$date = this.getDate();
            Object other$date = other.getDate();
            if (this$date == null ? other$date == null : this$date.equals(other$date)) {
               Object this$passingRate = this.getPassingRate();
               Object other$passingRate = other.getPassingRate();
               return this$passingRate == null ? other$passingRate == null : this$passingRate.equals(other$passingRate);
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
      return other instanceof MonthlyFirstPassRateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $InspectQuantity = this.getInspectQuantity();
      result = result * 59 + ($InspectQuantity == null ? 43 : $InspectQuantity.hashCode());
      Object $qhseQuantity = this.getQhseQuantity();
      result = result * 59 + ($qhseQuantity == null ? 43 : $qhseQuantity.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $passingRate = this.getPassingRate();
      return result * 59 + ($passingRate == null ? 43 : $passingRate.hashCode());
   }

   @Override
   public String toString() {
      return "MonthlyFirstPassRateDTO(super="
         + super.toString()
         + ", date="
         + this.getDate()
         + ", InspectQuantity="
         + this.getInspectQuantity()
         + ", qhseQuantity="
         + this.getQhseQuantity()
         + ", passingRate="
         + this.getPassingRate()
         + ")";
   }

   public MonthlyFirstPassRateDTO(final String date, final Integer InspectQuantity, final Integer qhseQuantity, final BigDecimal passingRate) {
      this.date = date;
      this.InspectQuantity = InspectQuantity;
      this.qhseQuantity = qhseQuantity;
      this.passingRate = passingRate;
   }

   public MonthlyFirstPassRateDTO() {
   }

   public static class MonthlyFirstPassRateDTOBuilder {
      private String date;
      private Integer InspectQuantity;
      private Integer qhseQuantity;
      private BigDecimal passingRate;

      MonthlyFirstPassRateDTOBuilder() {
      }

      public MonthlyFirstPassRateDTO.MonthlyFirstPassRateDTOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      public MonthlyFirstPassRateDTO.MonthlyFirstPassRateDTOBuilder InspectQuantity(final Integer InspectQuantity) {
         this.InspectQuantity = InspectQuantity;
         return this;
      }

      public MonthlyFirstPassRateDTO.MonthlyFirstPassRateDTOBuilder qhseQuantity(final Integer qhseQuantity) {
         this.qhseQuantity = qhseQuantity;
         return this;
      }

      public MonthlyFirstPassRateDTO.MonthlyFirstPassRateDTOBuilder passingRate(final BigDecimal passingRate) {
         this.passingRate = passingRate;
         return this;
      }

      public MonthlyFirstPassRateDTO build() {
         return new MonthlyFirstPassRateDTO(this.date, this.InspectQuantity, this.qhseQuantity, this.passingRate);
      }

      @Override
      public String toString() {
         return "MonthlyFirstPassRateDTO.MonthlyFirstPassRateDTOBuilder(date="
            + this.date
            + ", InspectQuantity="
            + this.InspectQuantity
            + ", qhseQuantity="
            + this.qhseQuantity
            + ", passingRate="
            + this.passingRate
            + ")";
      }
   }
}
