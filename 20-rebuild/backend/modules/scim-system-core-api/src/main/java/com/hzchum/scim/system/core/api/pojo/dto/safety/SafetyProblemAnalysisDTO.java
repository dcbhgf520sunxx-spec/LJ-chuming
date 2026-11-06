package com.hzchum.scim.system.core.api.pojo.dto.safety;

import io.swagger.annotations.ApiModel;

@ApiModel("年度问题分析DTO")
public class SafetyProblemAnalysisDTO {
   private Integer safetyProblemTotal;
   private Integer qualityProblemTotal;

   public static SafetyProblemAnalysisDTO.SafetyProblemAnalysisDTOBuilder builder() {
      return new SafetyProblemAnalysisDTO.SafetyProblemAnalysisDTOBuilder();
   }

   public SafetyProblemAnalysisDTO() {
   }

   public SafetyProblemAnalysisDTO(final Integer safetyProblemTotal, final Integer qualityProblemTotal) {
      this.safetyProblemTotal = safetyProblemTotal;
      this.qualityProblemTotal = qualityProblemTotal;
   }

   public Integer getSafetyProblemTotal() {
      return this.safetyProblemTotal;
   }

   public Integer getQualityProblemTotal() {
      return this.qualityProblemTotal;
   }

   public SafetyProblemAnalysisDTO setSafetyProblemTotal(final Integer safetyProblemTotal) {
      this.safetyProblemTotal = safetyProblemTotal;
      return this;
   }

   public SafetyProblemAnalysisDTO setQualityProblemTotal(final Integer qualityProblemTotal) {
      this.qualityProblemTotal = qualityProblemTotal;
      return this;
   }

   @Override
   public String toString() {
      return "SafetyProblemAnalysisDTO(safetyProblemTotal=" + this.getSafetyProblemTotal() + ", qualityProblemTotal=" + this.getQualityProblemTotal() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SafetyProblemAnalysisDTO)) {
         return false;
      } else {
         SafetyProblemAnalysisDTO other = (SafetyProblemAnalysisDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$safetyProblemTotal = this.getSafetyProblemTotal();
            Object other$safetyProblemTotal = other.getSafetyProblemTotal();
            if (this$safetyProblemTotal == null ? other$safetyProblemTotal == null : this$safetyProblemTotal.equals(other$safetyProblemTotal)) {
               Object this$qualityProblemTotal = this.getQualityProblemTotal();
               Object other$qualityProblemTotal = other.getQualityProblemTotal();
               return this$qualityProblemTotal == null ? other$qualityProblemTotal == null : this$qualityProblemTotal.equals(other$qualityProblemTotal);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SafetyProblemAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $safetyProblemTotal = this.getSafetyProblemTotal();
      result = result * 59 + ($safetyProblemTotal == null ? 43 : $safetyProblemTotal.hashCode());
      Object $qualityProblemTotal = this.getQualityProblemTotal();
      return result * 59 + ($qualityProblemTotal == null ? 43 : $qualityProblemTotal.hashCode());
   }

   public static class SafetyProblemAnalysisDTOBuilder {
      private Integer safetyProblemTotal;
      private Integer qualityProblemTotal;

      SafetyProblemAnalysisDTOBuilder() {
      }

      public SafetyProblemAnalysisDTO.SafetyProblemAnalysisDTOBuilder safetyProblemTotal(final Integer safetyProblemTotal) {
         this.safetyProblemTotal = safetyProblemTotal;
         return this;
      }

      public SafetyProblemAnalysisDTO.SafetyProblemAnalysisDTOBuilder qualityProblemTotal(final Integer qualityProblemTotal) {
         this.qualityProblemTotal = qualityProblemTotal;
         return this;
      }

      public SafetyProblemAnalysisDTO build() {
         return new SafetyProblemAnalysisDTO(this.safetyProblemTotal, this.qualityProblemTotal);
      }

      @Override
      public String toString() {
         return "SafetyProblemAnalysisDTO.SafetyProblemAnalysisDTOBuilder(safetyProblemTotal="
            + this.safetyProblemTotal
            + ", qualityProblemTotal="
            + this.qualityProblemTotal
            + ")";
      }
   }
}
