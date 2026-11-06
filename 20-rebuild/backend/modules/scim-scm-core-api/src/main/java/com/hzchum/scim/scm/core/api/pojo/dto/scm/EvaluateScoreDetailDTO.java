package com.hzchum.scim.scm.core.api.pojo.dto.scm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "EvaluateScoreDetailDTO", description = "评价分数详情")
@JsonInclude(Include.NON_NULL)
public class EvaluateScoreDetailDTO {
   @ApiModelProperty("serialNumber")
   private String serialNumber;
   @ApiModelProperty("考核项目")
   private String assessmentProject;
   @ApiModelProperty("考核内容列表")
   private String assessmentContents;
   @ApiModelProperty("分数")
   private String fraction;
   @ApiModelProperty("备注")
   private String remarks;
   @ApiModelProperty("是否有否决项")
   private Boolean hasVeto;
   @ApiModelProperty("得分")
   private Integer score;

   public static EvaluateScoreDetailDTO.EvaluateScoreDetailDTOBuilder builder() {
      return new EvaluateScoreDetailDTO.EvaluateScoreDetailDTOBuilder();
   }

   public EvaluateScoreDetailDTO() {
   }

   public EvaluateScoreDetailDTO(
      final String serialNumber,
      final String assessmentProject,
      final String assessmentContents,
      final String fraction,
      final String remarks,
      final Boolean hasVeto,
      final Integer score
   ) {
      this.serialNumber = serialNumber;
      this.assessmentProject = assessmentProject;
      this.assessmentContents = assessmentContents;
      this.fraction = fraction;
      this.remarks = remarks;
      this.hasVeto = hasVeto;
      this.score = score;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getAssessmentProject() {
      return this.assessmentProject;
   }

   public String getAssessmentContents() {
      return this.assessmentContents;
   }

   public String getFraction() {
      return this.fraction;
   }

   public String getRemarks() {
      return this.remarks;
   }

   public Boolean getHasVeto() {
      return this.hasVeto;
   }

   public Integer getScore() {
      return this.score;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setAssessmentProject(final String assessmentProject) {
      this.assessmentProject = assessmentProject;
   }

   public void setAssessmentContents(final String assessmentContents) {
      this.assessmentContents = assessmentContents;
   }

   public void setFraction(final String fraction) {
      this.fraction = fraction;
   }

   public void setRemarks(final String remarks) {
      this.remarks = remarks;
   }

   public void setHasVeto(final Boolean hasVeto) {
      this.hasVeto = hasVeto;
   }

   public void setScore(final Integer score) {
      this.score = score;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EvaluateScoreDetailDTO)) {
         return false;
      }

      EvaluateScoreDetailDTO other = (EvaluateScoreDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$hasVeto = this.getHasVeto();
      Object other$hasVeto = other.getHasVeto();
      if (this$hasVeto == null ? other$hasVeto == null : this$hasVeto.equals(other$hasVeto)) {
         Object this$score = this.getScore();
         Object other$score = other.getScore();
         if (this$score == null ? other$score == null : this$score.equals(other$score)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$assessmentProject = this.getAssessmentProject();
               Object other$assessmentProject = other.getAssessmentProject();
               if (this$assessmentProject == null ? other$assessmentProject == null : this$assessmentProject.equals(other$assessmentProject)) {
                  Object this$assessmentContents = this.getAssessmentContents();
                  Object other$assessmentContents = other.getAssessmentContents();
                  if (this$assessmentContents == null ? other$assessmentContents == null : this$assessmentContents.equals(other$assessmentContents)) {
                     Object this$fraction = this.getFraction();
                     Object other$fraction = other.getFraction();
                     if (this$fraction == null ? other$fraction == null : this$fraction.equals(other$fraction)) {
                        Object this$remarks = this.getRemarks();
                        Object other$remarks = other.getRemarks();
                        return this$remarks == null ? other$remarks == null : this$remarks.equals(other$remarks);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EvaluateScoreDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $hasVeto = this.getHasVeto();
      result = result * 59 + ($hasVeto == null ? 43 : $hasVeto.hashCode());
      Object $score = this.getScore();
      result = result * 59 + ($score == null ? 43 : $score.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $assessmentProject = this.getAssessmentProject();
      result = result * 59 + ($assessmentProject == null ? 43 : $assessmentProject.hashCode());
      Object $assessmentContents = this.getAssessmentContents();
      result = result * 59 + ($assessmentContents == null ? 43 : $assessmentContents.hashCode());
      Object $fraction = this.getFraction();
      result = result * 59 + ($fraction == null ? 43 : $fraction.hashCode());
      Object $remarks = this.getRemarks();
      return result * 59 + ($remarks == null ? 43 : $remarks.hashCode());
   }

   @Override
   public String toString() {
      return "EvaluateScoreDetailDTO(serialNumber="
         + this.getSerialNumber()
         + ", assessmentProject="
         + this.getAssessmentProject()
         + ", assessmentContents="
         + this.getAssessmentContents()
         + ", fraction="
         + this.getFraction()
         + ", remarks="
         + this.getRemarks()
         + ", hasVeto="
         + this.getHasVeto()
         + ", score="
         + this.getScore()
         + ")";
   }

   public static class EvaluateScoreDetailDTOBuilder {
      private String serialNumber;
      private String assessmentProject;
      private String assessmentContents;
      private String fraction;
      private String remarks;
      private Boolean hasVeto;
      private Integer score;

      EvaluateScoreDetailDTOBuilder() {
      }

      public EvaluateScoreDetailDTO.EvaluateScoreDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public EvaluateScoreDetailDTO.EvaluateScoreDetailDTOBuilder assessmentProject(final String assessmentProject) {
         this.assessmentProject = assessmentProject;
         return this;
      }

      public EvaluateScoreDetailDTO.EvaluateScoreDetailDTOBuilder assessmentContents(final String assessmentContents) {
         this.assessmentContents = assessmentContents;
         return this;
      }

      public EvaluateScoreDetailDTO.EvaluateScoreDetailDTOBuilder fraction(final String fraction) {
         this.fraction = fraction;
         return this;
      }

      public EvaluateScoreDetailDTO.EvaluateScoreDetailDTOBuilder remarks(final String remarks) {
         this.remarks = remarks;
         return this;
      }

      public EvaluateScoreDetailDTO.EvaluateScoreDetailDTOBuilder hasVeto(final Boolean hasVeto) {
         this.hasVeto = hasVeto;
         return this;
      }

      public EvaluateScoreDetailDTO.EvaluateScoreDetailDTOBuilder score(final Integer score) {
         this.score = score;
         return this;
      }

      public EvaluateScoreDetailDTO build() {
         return new EvaluateScoreDetailDTO(
            this.serialNumber, this.assessmentProject, this.assessmentContents, this.fraction, this.remarks, this.hasVeto, this.score
         );
      }

      @Override
      public String toString() {
         return "EvaluateScoreDetailDTO.EvaluateScoreDetailDTOBuilder(serialNumber="
            + this.serialNumber
            + ", assessmentProject="
            + this.assessmentProject
            + ", assessmentContents="
            + this.assessmentContents
            + ", fraction="
            + this.fraction
            + ", remarks="
            + this.remarks
            + ", hasVeto="
            + this.hasVeto
            + ", score="
            + this.score
            + ")";
      }
   }
}
