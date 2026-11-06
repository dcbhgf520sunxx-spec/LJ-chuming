package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PeriodCostDTO {
   @ApiModelProperty("日期")
   private LocalDateTime date;
   @ApiModelProperty("填报人")
   private NameInfo informant;
   @ApiModelProperty("报销人")
   private NameInfo reimburseUser;
   @ApiModelProperty("摘要")
   private String summary;
   @ApiModelProperty("报销金额")
   private BigDecimal reimburseAmount;

   public static PeriodCostDTO.PeriodCostDTOBuilder builder() {
      return new PeriodCostDTO.PeriodCostDTOBuilder();
   }

   public LocalDateTime getDate() {
      return this.date;
   }

   public NameInfo getInformant() {
      return this.informant;
   }

   public NameInfo getReimburseUser() {
      return this.reimburseUser;
   }

   public String getSummary() {
      return this.summary;
   }

   public BigDecimal getReimburseAmount() {
      return this.reimburseAmount;
   }

   public void setDate(final LocalDateTime date) {
      this.date = date;
   }

   public void setInformant(final NameInfo informant) {
      this.informant = informant;
   }

   public void setReimburseUser(final NameInfo reimburseUser) {
      this.reimburseUser = reimburseUser;
   }

   public void setSummary(final String summary) {
      this.summary = summary;
   }

   public void setReimburseAmount(final BigDecimal reimburseAmount) {
      this.reimburseAmount = reimburseAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PeriodCostDTO)) {
         return false;
      }

      PeriodCostDTO other = (PeriodCostDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$date = this.getDate();
      Object other$date = other.getDate();
      if (this$date == null ? other$date == null : this$date.equals(other$date)) {
         Object this$informant = this.getInformant();
         Object other$informant = other.getInformant();
         if (this$informant == null ? other$informant == null : this$informant.equals(other$informant)) {
            Object this$reimburseUser = this.getReimburseUser();
            Object other$reimburseUser = other.getReimburseUser();
            if (this$reimburseUser == null ? other$reimburseUser == null : this$reimburseUser.equals(other$reimburseUser)) {
               Object this$summary = this.getSummary();
               Object other$summary = other.getSummary();
               if (this$summary == null ? other$summary == null : this$summary.equals(other$summary)) {
                  Object this$reimburseAmount = this.getReimburseAmount();
                  Object other$reimburseAmount = other.getReimburseAmount();
                  return this$reimburseAmount == null ? other$reimburseAmount == null : this$reimburseAmount.equals(other$reimburseAmount);
               } else {
                  return false;
               }
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
      return other instanceof PeriodCostDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $informant = this.getInformant();
      result = result * 59 + ($informant == null ? 43 : $informant.hashCode());
      Object $reimburseUser = this.getReimburseUser();
      result = result * 59 + ($reimburseUser == null ? 43 : $reimburseUser.hashCode());
      Object $summary = this.getSummary();
      result = result * 59 + ($summary == null ? 43 : $summary.hashCode());
      Object $reimburseAmount = this.getReimburseAmount();
      return result * 59 + ($reimburseAmount == null ? 43 : $reimburseAmount.hashCode());
   }

   @Override
   public String toString() {
      return "PeriodCostDTO(date="
         + this.getDate()
         + ", informant="
         + this.getInformant()
         + ", reimburseUser="
         + this.getReimburseUser()
         + ", summary="
         + this.getSummary()
         + ", reimburseAmount="
         + this.getReimburseAmount()
         + ")";
   }

   public PeriodCostDTO(
      final LocalDateTime date, final NameInfo informant, final NameInfo reimburseUser, final String summary, final BigDecimal reimburseAmount
   ) {
      this.date = date;
      this.informant = informant;
      this.reimburseUser = reimburseUser;
      this.summary = summary;
      this.reimburseAmount = reimburseAmount;
   }

   public PeriodCostDTO() {
   }

   public static class PeriodCostDTOBuilder {
      private LocalDateTime date;
      private NameInfo informant;
      private NameInfo reimburseUser;
      private String summary;
      private BigDecimal reimburseAmount;

      PeriodCostDTOBuilder() {
      }

      public PeriodCostDTO.PeriodCostDTOBuilder date(final LocalDateTime date) {
         this.date = date;
         return this;
      }

      public PeriodCostDTO.PeriodCostDTOBuilder informant(final NameInfo informant) {
         this.informant = informant;
         return this;
      }

      public PeriodCostDTO.PeriodCostDTOBuilder reimburseUser(final NameInfo reimburseUser) {
         this.reimburseUser = reimburseUser;
         return this;
      }

      public PeriodCostDTO.PeriodCostDTOBuilder summary(final String summary) {
         this.summary = summary;
         return this;
      }

      public PeriodCostDTO.PeriodCostDTOBuilder reimburseAmount(final BigDecimal reimburseAmount) {
         this.reimburseAmount = reimburseAmount;
         return this;
      }

      public PeriodCostDTO build() {
         return new PeriodCostDTO(this.date, this.informant, this.reimburseUser, this.summary, this.reimburseAmount);
      }

      @Override
      public String toString() {
         return "PeriodCostDTO.PeriodCostDTOBuilder(date="
            + this.date
            + ", informant="
            + this.informant
            + ", reimburseUser="
            + this.reimburseUser
            + ", summary="
            + this.summary
            + ", reimburseAmount="
            + this.reimburseAmount
            + ")";
      }
   }
}
