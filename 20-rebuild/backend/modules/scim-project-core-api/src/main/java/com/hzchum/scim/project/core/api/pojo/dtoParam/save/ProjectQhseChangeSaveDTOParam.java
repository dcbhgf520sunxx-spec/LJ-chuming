package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "ProjectQhseChange对象", description = "质安问题整改表 ")
public class ProjectQhseChangeSaveDTOParam {
   @ApiModelProperty(name = "problemId", value = "质安问题表id", notes = "质安问题表id")
   @NotNull(message = "质安问题id不能为空")
   private Long problemId;
   @ApiModelProperty(name = "problemDesc", value = "问题描述", notes = "问题描述")
   @Size(max = 2000, message = "问题描述字数超出范围")
   private String problemDesc;
   @ApiModelProperty(name = "afterChangeImgIds", value = "整改后图片ID列表", notes = "整改后图片ID列表")
   private List<Long> afterChangeImgIds;

   public static ProjectQhseChangeSaveDTOParam.ProjectQhseChangeSaveDTOParamBuilder builder() {
      return new ProjectQhseChangeSaveDTOParam.ProjectQhseChangeSaveDTOParamBuilder();
   }

   public ProjectQhseChangeSaveDTOParam() {
   }

   public ProjectQhseChangeSaveDTOParam(final Long problemId, final String problemDesc, final List<Long> afterChangeImgIds) {
      this.problemId = problemId;
      this.problemDesc = problemDesc;
      this.afterChangeImgIds = afterChangeImgIds;
   }

   public Long getProblemId() {
      return this.problemId;
   }

   public String getProblemDesc() {
      return this.problemDesc;
   }

   public List<Long> getAfterChangeImgIds() {
      return this.afterChangeImgIds;
   }

   public void setProblemId(final Long problemId) {
      this.problemId = problemId;
   }

   public void setProblemDesc(final String problemDesc) {
      this.problemDesc = problemDesc;
   }

   public void setAfterChangeImgIds(final List<Long> afterChangeImgIds) {
      this.afterChangeImgIds = afterChangeImgIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectQhseChangeSaveDTOParam)) {
         return false;
      }

      ProjectQhseChangeSaveDTOParam other = (ProjectQhseChangeSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$problemId = this.getProblemId();
      Object other$problemId = other.getProblemId();
      if (this$problemId == null ? other$problemId == null : this$problemId.equals(other$problemId)) {
         Object this$problemDesc = this.getProblemDesc();
         Object other$problemDesc = other.getProblemDesc();
         if (this$problemDesc == null ? other$problemDesc == null : this$problemDesc.equals(other$problemDesc)) {
            Object this$afterChangeImgIds = this.getAfterChangeImgIds();
            Object other$afterChangeImgIds = other.getAfterChangeImgIds();
            return this$afterChangeImgIds == null ? other$afterChangeImgIds == null : this$afterChangeImgIds.equals(other$afterChangeImgIds);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectQhseChangeSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $problemId = this.getProblemId();
      result = result * 59 + ($problemId == null ? 43 : $problemId.hashCode());
      Object $problemDesc = this.getProblemDesc();
      result = result * 59 + ($problemDesc == null ? 43 : $problemDesc.hashCode());
      Object $afterChangeImgIds = this.getAfterChangeImgIds();
      return result * 59 + ($afterChangeImgIds == null ? 43 : $afterChangeImgIds.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectQhseChangeSaveDTOParam(problemId="
         + this.getProblemId()
         + ", problemDesc="
         + this.getProblemDesc()
         + ", afterChangeImgIds="
         + this.getAfterChangeImgIds()
         + ")";
   }

   public static class ProjectQhseChangeSaveDTOParamBuilder {
      private Long problemId;
      private String problemDesc;
      private List<Long> afterChangeImgIds;

      ProjectQhseChangeSaveDTOParamBuilder() {
      }

      public ProjectQhseChangeSaveDTOParam.ProjectQhseChangeSaveDTOParamBuilder problemId(final Long problemId) {
         this.problemId = problemId;
         return this;
      }

      public ProjectQhseChangeSaveDTOParam.ProjectQhseChangeSaveDTOParamBuilder problemDesc(final String problemDesc) {
         this.problemDesc = problemDesc;
         return this;
      }

      public ProjectQhseChangeSaveDTOParam.ProjectQhseChangeSaveDTOParamBuilder afterChangeImgIds(final List<Long> afterChangeImgIds) {
         this.afterChangeImgIds = afterChangeImgIds;
         return this;
      }

      public ProjectQhseChangeSaveDTOParam build() {
         return new ProjectQhseChangeSaveDTOParam(this.problemId, this.problemDesc, this.afterChangeImgIds);
      }

      @Override
      public String toString() {
         return "ProjectQhseChangeSaveDTOParam.ProjectQhseChangeSaveDTOParamBuilder(problemId="
            + this.problemId
            + ", problemDesc="
            + this.problemDesc
            + ", afterChangeImgIds="
            + this.afterChangeImgIds
            + ")";
      }
   }
}
