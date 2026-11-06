package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("配套件类别修改类")
public class AuxiliaryMaterialClassUpdateDtoParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   @NotNull(message = "项目ID不能为空")
   private Long projectId;
   @ApiModelProperty(name = "classifyId", value = "科目id")
   @NotNull(message = "配套件分类ID不能为空")
   private Long classifyId;
   @ApiModelProperty("true 不上报(即入即安) false上报 ")
   private Boolean boolNoReport;

   public static AuxiliaryMaterialClassUpdateDtoParam.AuxiliaryMaterialClassUpdateDtoParamBuilder builder() {
      return new AuxiliaryMaterialClassUpdateDtoParam.AuxiliaryMaterialClassUpdateDtoParamBuilder();
   }

   public AuxiliaryMaterialClassUpdateDtoParam() {
   }

   public AuxiliaryMaterialClassUpdateDtoParam(final Long projectId, final Long classifyId, final Boolean boolNoReport) {
      this.projectId = projectId;
      this.classifyId = classifyId;
      this.boolNoReport = boolNoReport;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Boolean getBoolNoReport() {
      return this.boolNoReport;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setBoolNoReport(final Boolean boolNoReport) {
      this.boolNoReport = boolNoReport;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AuxiliaryMaterialClassUpdateDtoParam)) {
         return false;
      }

      AuxiliaryMaterialClassUpdateDtoParam other = (AuxiliaryMaterialClassUpdateDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$boolNoReport = this.getBoolNoReport();
            Object other$boolNoReport = other.getBoolNoReport();
            return this$boolNoReport == null ? other$boolNoReport == null : this$boolNoReport.equals(other$boolNoReport);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AuxiliaryMaterialClassUpdateDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $boolNoReport = this.getBoolNoReport();
      return result * 59 + ($boolNoReport == null ? 43 : $boolNoReport.hashCode());
   }

   @Override
   public String toString() {
      return "AuxiliaryMaterialClassUpdateDtoParam(projectId="
         + this.getProjectId()
         + ", classifyId="
         + this.getClassifyId()
         + ", boolNoReport="
         + this.getBoolNoReport()
         + ")";
   }

   public static class AuxiliaryMaterialClassUpdateDtoParamBuilder {
      private Long projectId;
      private Long classifyId;
      private Boolean boolNoReport;

      AuxiliaryMaterialClassUpdateDtoParamBuilder() {
      }

      public AuxiliaryMaterialClassUpdateDtoParam.AuxiliaryMaterialClassUpdateDtoParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public AuxiliaryMaterialClassUpdateDtoParam.AuxiliaryMaterialClassUpdateDtoParamBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public AuxiliaryMaterialClassUpdateDtoParam.AuxiliaryMaterialClassUpdateDtoParamBuilder boolNoReport(final Boolean boolNoReport) {
         this.boolNoReport = boolNoReport;
         return this;
      }

      public AuxiliaryMaterialClassUpdateDtoParam build() {
         return new AuxiliaryMaterialClassUpdateDtoParam(this.projectId, this.classifyId, this.boolNoReport);
      }

      @Override
      public String toString() {
         return "AuxiliaryMaterialClassUpdateDtoParam.AuxiliaryMaterialClassUpdateDtoParamBuilder(projectId="
            + this.projectId
            + ", classifyId="
            + this.classifyId
            + ", boolNoReport="
            + this.boolNoReport
            + ")";
      }
   }
}
