package com.hzchum.scim.rest.pojo.vo.scm.supplierConfig;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ReviewTemplateVORequest", description = "评审模板配置编辑请求入参")
public class ReviewTemplateVORequest {
   @ApiModelProperty(value = "主键ID（必传）", required = true)
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(value = "评价分类ID（必传）", required = true)
   @NotNull(message = "评价分类ID不能为空")
   private Long classifyId;
   @ApiModelProperty(value = "评审模板内容（必传）", required = true)
   @NotNull(message = "评审模板内容不能为空")
   @Valid
   private ReviewTemplateVORequest.ReviewTemplateContentVO reviewTemplate;

   public Long getId() {
      return this.id;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public ReviewTemplateVORequest.ReviewTemplateContentVO getReviewTemplate() {
      return this.reviewTemplate;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setReviewTemplate(final ReviewTemplateVORequest.ReviewTemplateContentVO reviewTemplate) {
      this.reviewTemplate = reviewTemplate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReviewTemplateVORequest)) {
         return false;
      }

      ReviewTemplateVORequest other = (ReviewTemplateVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$reviewTemplate = this.getReviewTemplate();
            Object other$reviewTemplate = other.getReviewTemplate();
            return this$reviewTemplate == null ? other$reviewTemplate == null : this$reviewTemplate.equals(other$reviewTemplate);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ReviewTemplateVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $reviewTemplate = this.getReviewTemplate();
      return result * 59 + ($reviewTemplate == null ? 43 : $reviewTemplate.hashCode());
   }

   @Override
   public String toString() {
      return "ReviewTemplateVORequest(id=" + this.getId() + ", classifyId=" + this.getClassifyId() + ", reviewTemplate=" + this.getReviewTemplate() + ")";
   }

   @ApiModel(value = "ReviewTemplateContentVO", description = "评审模板内容")
   public static class ReviewTemplateContentVO {
      @ApiModelProperty("考核项目")
      private String assessmentProject;
      @ApiModelProperty("考核内容列表")
      private List<String> assessmentContents;

      public String getAssessmentProject() {
         return this.assessmentProject;
      }

      public List<String> getAssessmentContents() {
         return this.assessmentContents;
      }

      public void setAssessmentProject(final String assessmentProject) {
         this.assessmentProject = assessmentProject;
      }

      public void setAssessmentContents(final List<String> assessmentContents) {
         this.assessmentContents = assessmentContents;
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         } else if (!(o instanceof ReviewTemplateVORequest.ReviewTemplateContentVO)) {
            return false;
         } else {
            ReviewTemplateVORequest.ReviewTemplateContentVO other = (ReviewTemplateVORequest.ReviewTemplateContentVO)o;
            if (!other.canEqual(this)) {
               return false;
            } else {
               Object this$assessmentProject = this.getAssessmentProject();
               Object other$assessmentProject = other.getAssessmentProject();
               if (this$assessmentProject == null ? other$assessmentProject == null : this$assessmentProject.equals(other$assessmentProject)) {
                  Object this$assessmentContents = this.getAssessmentContents();
                  Object other$assessmentContents = other.getAssessmentContents();
                  return this$assessmentContents == null ? other$assessmentContents == null : this$assessmentContents.equals(other$assessmentContents);
               } else {
                  return false;
               }
            }
         }
      }

      protected boolean canEqual(final Object other) {
         return other instanceof ReviewTemplateVORequest.ReviewTemplateContentVO;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         Object $assessmentProject = this.getAssessmentProject();
         result = result * 59 + ($assessmentProject == null ? 43 : $assessmentProject.hashCode());
         Object $assessmentContents = this.getAssessmentContents();
         return result * 59 + ($assessmentContents == null ? 43 : $assessmentContents.hashCode());
      }

      @Override
      public String toString() {
         return "ReviewTemplateVORequest.ReviewTemplateContentVO(assessmentProject="
            + this.getAssessmentProject()
            + ", assessmentContents="
            + this.getAssessmentContents()
            + ")";
      }
   }
}
