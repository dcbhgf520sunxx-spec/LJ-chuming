package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("施工资料新增类")
public class ConstructionDataSaveDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   @NotNull(message = "项目ID不能为空")
   private Long projectId;
   @ApiModelProperty(name = "constructionStageType", value = "施工阶段类型 1 开工前 2 施工中 4 完工后")
   @NotNull(message = "施工阶段类型不能为空")
   private Integer constructionStageType;
   @ApiModelProperty(name = "fileName", value = "文件名称")
   private String fileName;

   public static ConstructionDataSaveDTOParam.ConstructionDataSaveDTOParamBuilder builder() {
      return new ConstructionDataSaveDTOParam.ConstructionDataSaveDTOParamBuilder();
   }

   public ConstructionDataSaveDTOParam() {
   }

   public ConstructionDataSaveDTOParam(final Long projectId, final Integer constructionStageType, final String fileName) {
      this.projectId = projectId;
      this.constructionStageType = constructionStageType;
      this.fileName = fileName;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getConstructionStageType() {
      return this.constructionStageType;
   }

   public String getFileName() {
      return this.fileName;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setConstructionStageType(final Integer constructionStageType) {
      this.constructionStageType = constructionStageType;
   }

   public void setFileName(final String fileName) {
      this.fileName = fileName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ConstructionDataSaveDTOParam)) {
         return false;
      }

      ConstructionDataSaveDTOParam other = (ConstructionDataSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$constructionStageType = this.getConstructionStageType();
         Object other$constructionStageType = other.getConstructionStageType();
         if (this$constructionStageType == null ? other$constructionStageType == null : this$constructionStageType.equals(other$constructionStageType)) {
            Object this$fileName = this.getFileName();
            Object other$fileName = other.getFileName();
            return this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ConstructionDataSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $constructionStageType = this.getConstructionStageType();
      result = result * 59 + ($constructionStageType == null ? 43 : $constructionStageType.hashCode());
      Object $fileName = this.getFileName();
      return result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
   }

   @Override
   public String toString() {
      return "ConstructionDataSaveDTOParam(projectId="
         + this.getProjectId()
         + ", constructionStageType="
         + this.getConstructionStageType()
         + ", fileName="
         + this.getFileName()
         + ")";
   }

   public static class ConstructionDataSaveDTOParamBuilder {
      private Long projectId;
      private Integer constructionStageType;
      private String fileName;

      ConstructionDataSaveDTOParamBuilder() {
      }

      public ConstructionDataSaveDTOParam.ConstructionDataSaveDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ConstructionDataSaveDTOParam.ConstructionDataSaveDTOParamBuilder constructionStageType(final Integer constructionStageType) {
         this.constructionStageType = constructionStageType;
         return this;
      }

      public ConstructionDataSaveDTOParam.ConstructionDataSaveDTOParamBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public ConstructionDataSaveDTOParam build() {
         return new ConstructionDataSaveDTOParam(this.projectId, this.constructionStageType, this.fileName);
      }

      @Override
      public String toString() {
         return "ConstructionDataSaveDTOParam.ConstructionDataSaveDTOParamBuilder(projectId="
            + this.projectId
            + ", constructionStageType="
            + this.constructionStageType
            + ", fileName="
            + this.fileName
            + ")";
      }
   }
}
