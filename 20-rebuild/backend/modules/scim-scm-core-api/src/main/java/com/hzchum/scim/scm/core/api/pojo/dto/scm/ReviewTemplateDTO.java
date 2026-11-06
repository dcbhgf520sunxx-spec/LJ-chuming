package com.hzchum.scim.scm.core.api.pojo.dto.scm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ReviewTemplateDTO", description = "评审模板")
@JsonInclude(Include.NON_NULL)
public class ReviewTemplateDTO {
   @ApiModelProperty("serialNumber")
   private String serialNumber;
   @ApiModelProperty("考核项目")
   private String assessmentProject;
   @ApiModelProperty("考核内容")
   private String assessmentContents;
   @ApiModelProperty("分数")
   private String fraction;
   @ApiModelProperty("备注")
   private String remarks;
   @ApiModelProperty("是否有否决项")
   private Boolean hasVeto;

   public static ReviewTemplateDTO.ReviewTemplateDTOBuilder builder() {
      return new ReviewTemplateDTO.ReviewTemplateDTOBuilder();
   }

   public ReviewTemplateDTO() {
   }

   public ReviewTemplateDTO(
      final String serialNumber,
      final String assessmentProject,
      final String assessmentContents,
      final String fraction,
      final String remarks,
      final Boolean hasVeto
   ) {
      this.serialNumber = serialNumber;
      this.assessmentProject = assessmentProject;
      this.assessmentContents = assessmentContents;
      this.fraction = fraction;
      this.remarks = remarks;
      this.hasVeto = hasVeto;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReviewTemplateDTO)) {
         return false;
      }

      ReviewTemplateDTO other = (ReviewTemplateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$hasVeto = this.getHasVeto();
      Object other$hasVeto = other.getHasVeto();
      if (this$hasVeto == null ? other$hasVeto == null : this$hasVeto.equals(other$hasVeto)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ReviewTemplateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $hasVeto = this.getHasVeto();
      result = result * 59 + ($hasVeto == null ? 43 : $hasVeto.hashCode());
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
      return "ReviewTemplateDTO(serialNumber="
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
         + ")";
   }

   public static class ReviewTemplateDTOBuilder {
      private String serialNumber;
      private String assessmentProject;
      private String assessmentContents;
      private String fraction;
      private String remarks;
      private Boolean hasVeto;

      ReviewTemplateDTOBuilder() {
      }

      public ReviewTemplateDTO.ReviewTemplateDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ReviewTemplateDTO.ReviewTemplateDTOBuilder assessmentProject(final String assessmentProject) {
         this.assessmentProject = assessmentProject;
         return this;
      }

      public ReviewTemplateDTO.ReviewTemplateDTOBuilder assessmentContents(final String assessmentContents) {
         this.assessmentContents = assessmentContents;
         return this;
      }

      public ReviewTemplateDTO.ReviewTemplateDTOBuilder fraction(final String fraction) {
         this.fraction = fraction;
         return this;
      }

      public ReviewTemplateDTO.ReviewTemplateDTOBuilder remarks(final String remarks) {
         this.remarks = remarks;
         return this;
      }

      public ReviewTemplateDTO.ReviewTemplateDTOBuilder hasVeto(final Boolean hasVeto) {
         this.hasVeto = hasVeto;
         return this;
      }

      public ReviewTemplateDTO build() {
         return new ReviewTemplateDTO(this.serialNumber, this.assessmentProject, this.assessmentContents, this.fraction, this.remarks, this.hasVeto);
      }

      @Override
      public String toString() {
         return "ReviewTemplateDTO.ReviewTemplateDTOBuilder(serialNumber="
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
            + ")";
      }
   }
}
