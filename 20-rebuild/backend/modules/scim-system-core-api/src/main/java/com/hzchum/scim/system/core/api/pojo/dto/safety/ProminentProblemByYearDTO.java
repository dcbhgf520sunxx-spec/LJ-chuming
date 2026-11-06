package com.hzchum.scim.system.core.api.pojo.dto.safety;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("年度突出问题DTO")
public class ProminentProblemByYearDTO {
   @ApiModelProperty(name = "problemName", notes = "问题名称")
   private String problemName;
   @ApiModelProperty(name = "problemCount")
   private Integer problemCount;
   @ApiModelProperty(name = "QualityOrSafetyEnum")
   private Integer qualityOrSafetyEnum;

   public static ProminentProblemByYearDTO.ProminentProblemByYearDTOBuilder builder() {
      return new ProminentProblemByYearDTO.ProminentProblemByYearDTOBuilder();
   }

   public ProminentProblemByYearDTO() {
   }

   public ProminentProblemByYearDTO(final String problemName, final Integer problemCount, final Integer qualityOrSafetyEnum) {
      this.problemName = problemName;
      this.problemCount = problemCount;
      this.qualityOrSafetyEnum = qualityOrSafetyEnum;
   }

   public String getProblemName() {
      return this.problemName;
   }

   public Integer getProblemCount() {
      return this.problemCount;
   }

   public Integer getQualityOrSafetyEnum() {
      return this.qualityOrSafetyEnum;
   }

   public ProminentProblemByYearDTO setProblemName(final String problemName) {
      this.problemName = problemName;
      return this;
   }

   public ProminentProblemByYearDTO setProblemCount(final Integer problemCount) {
      this.problemCount = problemCount;
      return this;
   }

   public ProminentProblemByYearDTO setQualityOrSafetyEnum(final Integer qualityOrSafetyEnum) {
      this.qualityOrSafetyEnum = qualityOrSafetyEnum;
      return this;
   }

   @Override
   public String toString() {
      return "ProminentProblemByYearDTO(problemName="
         + this.getProblemName()
         + ", problemCount="
         + this.getProblemCount()
         + ", qualityOrSafetyEnum="
         + this.getQualityOrSafetyEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProminentProblemByYearDTO)) {
         return false;
      }

      ProminentProblemByYearDTO other = (ProminentProblemByYearDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$problemCount = this.getProblemCount();
      Object other$problemCount = other.getProblemCount();
      if (this$problemCount == null ? other$problemCount == null : this$problemCount.equals(other$problemCount)) {
         Object this$qualityOrSafetyEnum = this.getQualityOrSafetyEnum();
         Object other$qualityOrSafetyEnum = other.getQualityOrSafetyEnum();
         if (this$qualityOrSafetyEnum == null ? other$qualityOrSafetyEnum == null : this$qualityOrSafetyEnum.equals(other$qualityOrSafetyEnum)) {
            Object this$problemName = this.getProblemName();
            Object other$problemName = other.getProblemName();
            return this$problemName == null ? other$problemName == null : this$problemName.equals(other$problemName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProminentProblemByYearDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $problemCount = this.getProblemCount();
      result = result * 59 + ($problemCount == null ? 43 : $problemCount.hashCode());
      Object $qualityOrSafetyEnum = this.getQualityOrSafetyEnum();
      result = result * 59 + ($qualityOrSafetyEnum == null ? 43 : $qualityOrSafetyEnum.hashCode());
      Object $problemName = this.getProblemName();
      return result * 59 + ($problemName == null ? 43 : $problemName.hashCode());
   }

   public static class ProminentProblemByYearDTOBuilder {
      private String problemName;
      private Integer problemCount;
      private Integer qualityOrSafetyEnum;

      ProminentProblemByYearDTOBuilder() {
      }

      public ProminentProblemByYearDTO.ProminentProblemByYearDTOBuilder problemName(final String problemName) {
         this.problemName = problemName;
         return this;
      }

      public ProminentProblemByYearDTO.ProminentProblemByYearDTOBuilder problemCount(final Integer problemCount) {
         this.problemCount = problemCount;
         return this;
      }

      public ProminentProblemByYearDTO.ProminentProblemByYearDTOBuilder qualityOrSafetyEnum(final Integer qualityOrSafetyEnum) {
         this.qualityOrSafetyEnum = qualityOrSafetyEnum;
         return this;
      }

      public ProminentProblemByYearDTO build() {
         return new ProminentProblemByYearDTO(this.problemName, this.problemCount, this.qualityOrSafetyEnum);
      }

      @Override
      public String toString() {
         return "ProminentProblemByYearDTO.ProminentProblemByYearDTOBuilder(problemName="
            + this.problemName
            + ", problemCount="
            + this.problemCount
            + ", qualityOrSafetyEnum="
            + this.qualityOrSafetyEnum
            + ")";
      }
   }
}
