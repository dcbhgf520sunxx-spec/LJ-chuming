package com.hzchum.scim.project.core.api.pojo.dtoParam.put;

import io.swagger.annotations.ApiModel;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("关闭收货问题")
public class ProjectReceivedProblemPutDTOParam {
   @NotNull(message = "问题id不能为空")
   private Long problemId;
   private List<Long> attachmentIds;
   @NotBlank(message = "关闭描述不能为空！")
   private String describe;

   public static ProjectReceivedProblemPutDTOParam.ProjectReceivedProblemPutDTOParamBuilder builder() {
      return new ProjectReceivedProblemPutDTOParam.ProjectReceivedProblemPutDTOParamBuilder();
   }

   public Long getProblemId() {
      return this.problemId;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getDescribe() {
      return this.describe;
   }

   public void setProblemId(final Long problemId) {
      this.problemId = problemId;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setDescribe(final String describe) {
      this.describe = describe;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReceivedProblemPutDTOParam)) {
         return false;
      }

      ProjectReceivedProblemPutDTOParam other = (ProjectReceivedProblemPutDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$problemId = this.getProblemId();
      Object other$problemId = other.getProblemId();
      if (this$problemId == null ? other$problemId == null : this$problemId.equals(other$problemId)) {
         Object this$attachmentIds = this.getAttachmentIds();
         Object other$attachmentIds = other.getAttachmentIds();
         if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
            Object this$describe = this.getDescribe();
            Object other$describe = other.getDescribe();
            return this$describe == null ? other$describe == null : this$describe.equals(other$describe);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectReceivedProblemPutDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $problemId = this.getProblemId();
      result = result * 59 + ($problemId == null ? 43 : $problemId.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $describe = this.getDescribe();
      return result * 59 + ($describe == null ? 43 : $describe.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReceivedProblemPutDTOParam(problemId="
         + this.getProblemId()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", describe="
         + this.getDescribe()
         + ")";
   }

   public ProjectReceivedProblemPutDTOParam() {
   }

   public ProjectReceivedProblemPutDTOParam(final Long problemId, final List<Long> attachmentIds, final String describe) {
      this.problemId = problemId;
      this.attachmentIds = attachmentIds;
      this.describe = describe;
   }

   public static class ProjectReceivedProblemPutDTOParamBuilder {
      private Long problemId;
      private List<Long> attachmentIds;
      private String describe;

      ProjectReceivedProblemPutDTOParamBuilder() {
      }

      public ProjectReceivedProblemPutDTOParam.ProjectReceivedProblemPutDTOParamBuilder problemId(final Long problemId) {
         this.problemId = problemId;
         return this;
      }

      public ProjectReceivedProblemPutDTOParam.ProjectReceivedProblemPutDTOParamBuilder attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ProjectReceivedProblemPutDTOParam.ProjectReceivedProblemPutDTOParamBuilder describe(final String describe) {
         this.describe = describe;
         return this;
      }

      public ProjectReceivedProblemPutDTOParam build() {
         return new ProjectReceivedProblemPutDTOParam(this.problemId, this.attachmentIds, this.describe);
      }

      @Override
      public String toString() {
         return "ProjectReceivedProblemPutDTOParam.ProjectReceivedProblemPutDTOParamBuilder(problemId="
            + this.problemId
            + ", attachmentIds="
            + this.attachmentIds
            + ", describe="
            + this.describe
            + ")";
      }
   }
}
