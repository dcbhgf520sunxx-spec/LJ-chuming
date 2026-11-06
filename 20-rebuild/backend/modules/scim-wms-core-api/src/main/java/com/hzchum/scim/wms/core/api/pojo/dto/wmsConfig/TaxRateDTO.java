package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class TaxRateDTO {
   private Long id;
   private Integer classification;
   private List<BigDecimal> taxRateList;
   @JsonInclude(Include.NON_NULL)
   private LocalDateTime createTime;
   @JsonInclude(Include.NON_NULL)
   private LocalDateTime userUpdateTime;

   public static TaxRateDTO.TaxRateDTOBuilder builder() {
      return new TaxRateDTO.TaxRateDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getClassification() {
      return this.classification;
   }

   public List<BigDecimal> getTaxRateList() {
      return this.taxRateList;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassification(final Integer classification) {
      this.classification = classification;
   }

   public void setTaxRateList(final List<BigDecimal> taxRateList) {
      this.taxRateList = taxRateList;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaxRateDTO)) {
         return false;
      }

      TaxRateDTO other = (TaxRateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classification = this.getClassification();
         Object other$classification = other.getClassification();
         if (this$classification == null ? other$classification == null : this$classification.equals(other$classification)) {
            Object this$taxRateList = this.getTaxRateList();
            Object other$taxRateList = other.getTaxRateList();
            if (this$taxRateList == null ? other$taxRateList == null : this$taxRateList.equals(other$taxRateList)) {
               Object this$createTime = this.getCreateTime();
               Object other$createTime = other.getCreateTime();
               if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                  Object this$userUpdateTime = this.getUserUpdateTime();
                  Object other$userUpdateTime = other.getUserUpdateTime();
                  return this$userUpdateTime == null ? other$userUpdateTime == null : this$userUpdateTime.equals(other$userUpdateTime);
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
      return other instanceof TaxRateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classification = this.getClassification();
      result = result * 59 + ($classification == null ? 43 : $classification.hashCode());
      Object $taxRateList = this.getTaxRateList();
      result = result * 59 + ($taxRateList == null ? 43 : $taxRateList.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      return result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
   }

   @Override
   public String toString() {
      return "TaxRateDTO(id="
         + this.getId()
         + ", classification="
         + this.getClassification()
         + ", taxRateList="
         + this.getTaxRateList()
         + ", createTime="
         + this.getCreateTime()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ")";
   }

   public TaxRateDTO(
      final Long id, final Integer classification, final List<BigDecimal> taxRateList, final LocalDateTime createTime, final LocalDateTime userUpdateTime
   ) {
      this.id = id;
      this.classification = classification;
      this.taxRateList = taxRateList;
      this.createTime = createTime;
      this.userUpdateTime = userUpdateTime;
   }

   public TaxRateDTO() {
   }

   public static class TaxRateDTOBuilder {
      private Long id;
      private Integer classification;
      private List<BigDecimal> taxRateList;
      private LocalDateTime createTime;
      private LocalDateTime userUpdateTime;

      TaxRateDTOBuilder() {
      }

      public TaxRateDTO.TaxRateDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TaxRateDTO.TaxRateDTOBuilder classification(final Integer classification) {
         this.classification = classification;
         return this;
      }

      public TaxRateDTO.TaxRateDTOBuilder taxRateList(final List<BigDecimal> taxRateList) {
         this.taxRateList = taxRateList;
         return this;
      }

      public TaxRateDTO.TaxRateDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public TaxRateDTO.TaxRateDTOBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      public TaxRateDTO build() {
         return new TaxRateDTO(this.id, this.classification, this.taxRateList, this.createTime, this.userUpdateTime);
      }

      @Override
      public String toString() {
         return "TaxRateDTO.TaxRateDTOBuilder(id="
            + this.id
            + ", classification="
            + this.classification
            + ", taxRateList="
            + this.taxRateList
            + ", createTime="
            + this.createTime
            + ", userUpdateTime="
            + this.userUpdateTime
            + ")";
      }
   }
}
