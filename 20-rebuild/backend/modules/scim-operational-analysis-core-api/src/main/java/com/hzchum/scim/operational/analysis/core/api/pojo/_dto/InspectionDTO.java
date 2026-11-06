package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class InspectionDTO {
   @ApiModelProperty(name = "quantitySummary", value = "年度检验总数", notes = "年度检验总数")
   @JsonProperty("quantitySummary")
   @JSONField(name = "quantitySummary")
   private Integer quantitySummary;
   @ApiModelProperty(name = "problemQuantitySummary", value = "年度不合格总数", notes = "年度不合格总数")
   @JsonProperty("problemQuantitySummary")
   @JSONField(name = "problemQuantitySummary")
   private Integer problemQuantitySummary;
   @ApiModelProperty(name = "avgPassRatio", value = "平均合格率", notes = "平均合格率")
   @JsonProperty("avgPassRatio")
   @JSONField(name = "avgPassRatio")
   private BigDecimal avgPassRatio;
   @ApiModelProperty(name = "details", value = "每月详情", notes = "每月详情")
   @JsonProperty("details")
   @JSONField(name = "details")
   private List<InspectionDetailsDTO> details;

   public static InspectionDTO.InspectionDTOBuilder builder() {
      return new InspectionDTO.InspectionDTOBuilder();
   }

   public Integer getQuantitySummary() {
      return this.quantitySummary;
   }

   public Integer getProblemQuantitySummary() {
      return this.problemQuantitySummary;
   }

   public BigDecimal getAvgPassRatio() {
      return this.avgPassRatio;
   }

   public List<InspectionDetailsDTO> getDetails() {
      return this.details;
   }

   @JsonProperty("quantitySummary")
   public void setQuantitySummary(final Integer quantitySummary) {
      this.quantitySummary = quantitySummary;
   }

   @JsonProperty("problemQuantitySummary")
   public void setProblemQuantitySummary(final Integer problemQuantitySummary) {
      this.problemQuantitySummary = problemQuantitySummary;
   }

   @JsonProperty("avgPassRatio")
   public void setAvgPassRatio(final BigDecimal avgPassRatio) {
      this.avgPassRatio = avgPassRatio;
   }

   @JsonProperty("details")
   public void setDetails(final List<InspectionDetailsDTO> details) {
      this.details = details;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectionDTO)) {
         return false;
      }

      InspectionDTO other = (InspectionDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantitySummary = this.getQuantitySummary();
      Object other$quantitySummary = other.getQuantitySummary();
      if (this$quantitySummary == null ? other$quantitySummary == null : this$quantitySummary.equals(other$quantitySummary)) {
         Object this$problemQuantitySummary = this.getProblemQuantitySummary();
         Object other$problemQuantitySummary = other.getProblemQuantitySummary();
         if (this$problemQuantitySummary == null ? other$problemQuantitySummary == null : this$problemQuantitySummary.equals(other$problemQuantitySummary)) {
            Object this$avgPassRatio = this.getAvgPassRatio();
            Object other$avgPassRatio = other.getAvgPassRatio();
            if (this$avgPassRatio == null ? other$avgPassRatio == null : this$avgPassRatio.equals(other$avgPassRatio)) {
               Object this$details = this.getDetails();
               Object other$details = other.getDetails();
               return this$details == null ? other$details == null : this$details.equals(other$details);
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
      return other instanceof InspectionDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantitySummary = this.getQuantitySummary();
      result = result * 59 + ($quantitySummary == null ? 43 : $quantitySummary.hashCode());
      Object $problemQuantitySummary = this.getProblemQuantitySummary();
      result = result * 59 + ($problemQuantitySummary == null ? 43 : $problemQuantitySummary.hashCode());
      Object $avgPassRatio = this.getAvgPassRatio();
      result = result * 59 + ($avgPassRatio == null ? 43 : $avgPassRatio.hashCode());
      Object $details = this.getDetails();
      return result * 59 + ($details == null ? 43 : $details.hashCode());
   }

   @Override
   public String toString() {
      return "InspectionDTO(quantitySummary="
         + this.getQuantitySummary()
         + ", problemQuantitySummary="
         + this.getProblemQuantitySummary()
         + ", avgPassRatio="
         + this.getAvgPassRatio()
         + ", details="
         + this.getDetails()
         + ")";
   }

   public InspectionDTO(
      final Integer quantitySummary, final Integer problemQuantitySummary, final BigDecimal avgPassRatio, final List<InspectionDetailsDTO> details
   ) {
      this.quantitySummary = quantitySummary;
      this.problemQuantitySummary = problemQuantitySummary;
      this.avgPassRatio = avgPassRatio;
      this.details = details;
   }

   public InspectionDTO() {
   }

   public static class InspectionDTOBuilder {
      private Integer quantitySummary;
      private Integer problemQuantitySummary;
      private BigDecimal avgPassRatio;
      private List<InspectionDetailsDTO> details;

      InspectionDTOBuilder() {
      }

      @JsonProperty("quantitySummary")
      public InspectionDTO.InspectionDTOBuilder quantitySummary(final Integer quantitySummary) {
         this.quantitySummary = quantitySummary;
         return this;
      }

      @JsonProperty("problemQuantitySummary")
      public InspectionDTO.InspectionDTOBuilder problemQuantitySummary(final Integer problemQuantitySummary) {
         this.problemQuantitySummary = problemQuantitySummary;
         return this;
      }

      @JsonProperty("avgPassRatio")
      public InspectionDTO.InspectionDTOBuilder avgPassRatio(final BigDecimal avgPassRatio) {
         this.avgPassRatio = avgPassRatio;
         return this;
      }

      @JsonProperty("details")
      public InspectionDTO.InspectionDTOBuilder details(final List<InspectionDetailsDTO> details) {
         this.details = details;
         return this;
      }

      public InspectionDTO build() {
         return new InspectionDTO(this.quantitySummary, this.problemQuantitySummary, this.avgPassRatio, this.details);
      }

      @Override
      public String toString() {
         return "InspectionDTO.InspectionDTOBuilder(quantitySummary="
            + this.quantitySummary
            + ", problemQuantitySummary="
            + this.problemQuantitySummary
            + ", avgPassRatio="
            + this.avgPassRatio
            + ", details="
            + this.details
            + ")";
      }
   }
}
