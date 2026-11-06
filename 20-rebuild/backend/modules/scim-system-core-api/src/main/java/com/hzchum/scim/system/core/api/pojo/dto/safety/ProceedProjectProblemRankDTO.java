package com.hzchum.scim.system.core.api.pojo.dto.safety;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("在建项目质安问题排名DTO")
public class ProceedProjectProblemRankDTO {
   @ApiModelProperty(name = "projectSortName", notes = "项目简称")
   private String projectSortName;
   @ApiModelProperty(name = "qualityProblemTotal", notes = "质量问题总数")
   private Integer qualityProblemTotal;
   @ApiModelProperty(name = "safetyProblemTotal", notes = "安全问题总数")
   private Integer safetyProblemTotal;
   @ApiModelProperty(name = "problemTotal", notes = "问题总数")
   private Integer problemTotal;

   public static ProceedProjectProblemRankDTO.ProceedProjectProblemRankDTOBuilder builder() {
      return new ProceedProjectProblemRankDTO.ProceedProjectProblemRankDTOBuilder();
   }

   public ProceedProjectProblemRankDTO() {
   }

   public ProceedProjectProblemRankDTO(
      final String projectSortName, final Integer qualityProblemTotal, final Integer safetyProblemTotal, final Integer problemTotal
   ) {
      this.projectSortName = projectSortName;
      this.qualityProblemTotal = qualityProblemTotal;
      this.safetyProblemTotal = safetyProblemTotal;
      this.problemTotal = problemTotal;
   }

   public String getProjectSortName() {
      return this.projectSortName;
   }

   public Integer getQualityProblemTotal() {
      return this.qualityProblemTotal;
   }

   public Integer getSafetyProblemTotal() {
      return this.safetyProblemTotal;
   }

   public Integer getProblemTotal() {
      return this.problemTotal;
   }

   public ProceedProjectProblemRankDTO setProjectSortName(final String projectSortName) {
      this.projectSortName = projectSortName;
      return this;
   }

   public ProceedProjectProblemRankDTO setQualityProblemTotal(final Integer qualityProblemTotal) {
      this.qualityProblemTotal = qualityProblemTotal;
      return this;
   }

   public ProceedProjectProblemRankDTO setSafetyProblemTotal(final Integer safetyProblemTotal) {
      this.safetyProblemTotal = safetyProblemTotal;
      return this;
   }

   public ProceedProjectProblemRankDTO setProblemTotal(final Integer problemTotal) {
      this.problemTotal = problemTotal;
      return this;
   }

   @Override
   public String toString() {
      return "ProceedProjectProblemRankDTO(projectSortName="
         + this.getProjectSortName()
         + ", qualityProblemTotal="
         + this.getQualityProblemTotal()
         + ", safetyProblemTotal="
         + this.getSafetyProblemTotal()
         + ", problemTotal="
         + this.getProblemTotal()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProceedProjectProblemRankDTO)) {
         return false;
      }

      ProceedProjectProblemRankDTO other = (ProceedProjectProblemRankDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$qualityProblemTotal = this.getQualityProblemTotal();
      Object other$qualityProblemTotal = other.getQualityProblemTotal();
      if (this$qualityProblemTotal == null ? other$qualityProblemTotal == null : this$qualityProblemTotal.equals(other$qualityProblemTotal)) {
         Object this$safetyProblemTotal = this.getSafetyProblemTotal();
         Object other$safetyProblemTotal = other.getSafetyProblemTotal();
         if (this$safetyProblemTotal == null ? other$safetyProblemTotal == null : this$safetyProblemTotal.equals(other$safetyProblemTotal)) {
            Object this$problemTotal = this.getProblemTotal();
            Object other$problemTotal = other.getProblemTotal();
            if (this$problemTotal == null ? other$problemTotal == null : this$problemTotal.equals(other$problemTotal)) {
               Object this$projectSortName = this.getProjectSortName();
               Object other$projectSortName = other.getProjectSortName();
               return this$projectSortName == null ? other$projectSortName == null : this$projectSortName.equals(other$projectSortName);
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
      return other instanceof ProceedProjectProblemRankDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $qualityProblemTotal = this.getQualityProblemTotal();
      result = result * 59 + ($qualityProblemTotal == null ? 43 : $qualityProblemTotal.hashCode());
      Object $safetyProblemTotal = this.getSafetyProblemTotal();
      result = result * 59 + ($safetyProblemTotal == null ? 43 : $safetyProblemTotal.hashCode());
      Object $problemTotal = this.getProblemTotal();
      result = result * 59 + ($problemTotal == null ? 43 : $problemTotal.hashCode());
      Object $projectSortName = this.getProjectSortName();
      return result * 59 + ($projectSortName == null ? 43 : $projectSortName.hashCode());
   }

   public static class ProceedProjectProblemRankDTOBuilder {
      private String projectSortName;
      private Integer qualityProblemTotal;
      private Integer safetyProblemTotal;
      private Integer problemTotal;

      ProceedProjectProblemRankDTOBuilder() {
      }

      public ProceedProjectProblemRankDTO.ProceedProjectProblemRankDTOBuilder projectSortName(final String projectSortName) {
         this.projectSortName = projectSortName;
         return this;
      }

      public ProceedProjectProblemRankDTO.ProceedProjectProblemRankDTOBuilder qualityProblemTotal(final Integer qualityProblemTotal) {
         this.qualityProblemTotal = qualityProblemTotal;
         return this;
      }

      public ProceedProjectProblemRankDTO.ProceedProjectProblemRankDTOBuilder safetyProblemTotal(final Integer safetyProblemTotal) {
         this.safetyProblemTotal = safetyProblemTotal;
         return this;
      }

      public ProceedProjectProblemRankDTO.ProceedProjectProblemRankDTOBuilder problemTotal(final Integer problemTotal) {
         this.problemTotal = problemTotal;
         return this;
      }

      public ProceedProjectProblemRankDTO build() {
         return new ProceedProjectProblemRankDTO(this.projectSortName, this.qualityProblemTotal, this.safetyProblemTotal, this.problemTotal);
      }

      @Override
      public String toString() {
         return "ProceedProjectProblemRankDTO.ProceedProjectProblemRankDTOBuilder(projectSortName="
            + this.projectSortName
            + ", qualityProblemTotal="
            + this.qualityProblemTotal
            + ", safetyProblemTotal="
            + this.safetyProblemTotal
            + ", problemTotal="
            + this.problemTotal
            + ")";
      }
   }
}
