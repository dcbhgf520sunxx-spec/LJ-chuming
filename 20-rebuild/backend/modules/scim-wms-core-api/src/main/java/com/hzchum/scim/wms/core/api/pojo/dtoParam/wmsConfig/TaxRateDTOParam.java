package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

import java.math.BigDecimal;
import java.util.List;

public class TaxRateDTOParam {
   private Long id;
   private Integer classification;
   private List<BigDecimal> taxRateList;

   public static TaxRateDTOParam.TaxRateDTOParamBuilder builder() {
      return new TaxRateDTOParam.TaxRateDTOParamBuilder();
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassification(final Integer classification) {
      this.classification = classification;
   }

   public void setTaxRateList(final List<BigDecimal> taxRateList) {
      this.taxRateList = taxRateList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaxRateDTOParam)) {
         return false;
      }

      TaxRateDTOParam other = (TaxRateDTOParam)o;
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
            return this$taxRateList == null ? other$taxRateList == null : this$taxRateList.equals(other$taxRateList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TaxRateDTOParam;
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
      return result * 59 + ($taxRateList == null ? 43 : $taxRateList.hashCode());
   }

   @Override
   public String toString() {
      return "TaxRateDTOParam(id=" + this.getId() + ", classification=" + this.getClassification() + ", taxRateList=" + this.getTaxRateList() + ")";
   }

   public TaxRateDTOParam(final Long id, final Integer classification, final List<BigDecimal> taxRateList) {
      this.id = id;
      this.classification = classification;
      this.taxRateList = taxRateList;
   }

   public TaxRateDTOParam() {
   }

   public static class TaxRateDTOParamBuilder {
      private Long id;
      private Integer classification;
      private List<BigDecimal> taxRateList;

      TaxRateDTOParamBuilder() {
      }

      public TaxRateDTOParam.TaxRateDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TaxRateDTOParam.TaxRateDTOParamBuilder classification(final Integer classification) {
         this.classification = classification;
         return this;
      }

      public TaxRateDTOParam.TaxRateDTOParamBuilder taxRateList(final List<BigDecimal> taxRateList) {
         this.taxRateList = taxRateList;
         return this;
      }

      public TaxRateDTOParam build() {
         return new TaxRateDTOParam(this.id, this.classification, this.taxRateList);
      }

      @Override
      public String toString() {
         return "TaxRateDTOParam.TaxRateDTOParamBuilder(id=" + this.id + ", classification=" + this.classification + ", taxRateList=" + this.taxRateList + ")";
      }
   }
}
