package com.hzchum.scim.system.core.api.pojo.dto.safety;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("年度问题分析DTO")
public class ProblemAnalysisByYearDTO {
   @ApiModelProperty(name = "problemName", notes = "问题名称")
   private String problemName;
   @ApiModelProperty(name = "problemCount")
   private Integer problemCount;

   public static ProblemAnalysisByYearDTO.ProblemAnalysisByYearDTOBuilder builder() {
      return new ProblemAnalysisByYearDTO.ProblemAnalysisByYearDTOBuilder();
   }

   public ProblemAnalysisByYearDTO() {
   }

   public ProblemAnalysisByYearDTO(final String problemName, final Integer problemCount) {
      this.problemName = problemName;
      this.problemCount = problemCount;
   }

   public String getProblemName() {
      return this.problemName;
   }

   public Integer getProblemCount() {
      return this.problemCount;
   }

   public ProblemAnalysisByYearDTO setProblemName(final String problemName) {
      this.problemName = problemName;
      return this;
   }

   public ProblemAnalysisByYearDTO setProblemCount(final Integer problemCount) {
      this.problemCount = problemCount;
      return this;
   }

   @Override
   public String toString() {
      return "ProblemAnalysisByYearDTO(problemName=" + this.getProblemName() + ", problemCount=" + this.getProblemCount() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProblemAnalysisByYearDTO)) {
         return false;
      } else {
         ProblemAnalysisByYearDTO other = (ProblemAnalysisByYearDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$problemCount = this.getProblemCount();
            Object other$problemCount = other.getProblemCount();
            if (this$problemCount == null ? other$problemCount == null : this$problemCount.equals(other$problemCount)) {
               Object this$problemName = this.getProblemName();
               Object other$problemName = other.getProblemName();
               return this$problemName == null ? other$problemName == null : this$problemName.equals(other$problemName);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProblemAnalysisByYearDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $problemCount = this.getProblemCount();
      result = result * 59 + ($problemCount == null ? 43 : $problemCount.hashCode());
      Object $problemName = this.getProblemName();
      return result * 59 + ($problemName == null ? 43 : $problemName.hashCode());
   }

   public static class ProblemAnalysisByYearDTOBuilder {
      private String problemName;
      private Integer problemCount;

      ProblemAnalysisByYearDTOBuilder() {
      }

      public ProblemAnalysisByYearDTO.ProblemAnalysisByYearDTOBuilder problemName(final String problemName) {
         this.problemName = problemName;
         return this;
      }

      public ProblemAnalysisByYearDTO.ProblemAnalysisByYearDTOBuilder problemCount(final Integer problemCount) {
         this.problemCount = problemCount;
         return this;
      }

      public ProblemAnalysisByYearDTO build() {
         return new ProblemAnalysisByYearDTO(this.problemName, this.problemCount);
      }

      @Override
      public String toString() {
         return "ProblemAnalysisByYearDTO.ProblemAnalysisByYearDTOBuilder(problemName=" + this.problemName + ", problemCount=" + this.problemCount + ")";
      }
   }
}
