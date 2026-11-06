package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("配套件(辅材)类别DTO类")
public class AuxiliaryMaterialClassDTO {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "classifyId", value = "科目id")
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "科目名称")
   private String classifyName;
   @ApiModelProperty("是否无需上报 true 不上报(即入即安) false 上报 ")
   private Boolean boolNoReport;

   public static AuxiliaryMaterialClassDTO.AuxiliaryMaterialClassDTOBuilder builder() {
      return new AuxiliaryMaterialClassDTO.AuxiliaryMaterialClassDTOBuilder();
   }

   public AuxiliaryMaterialClassDTO() {
   }

   public AuxiliaryMaterialClassDTO(final Long projectId, final Long classifyId, final String classifyName, final Boolean boolNoReport) {
      this.projectId = projectId;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.boolNoReport = boolNoReport;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
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

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setBoolNoReport(final Boolean boolNoReport) {
      this.boolNoReport = boolNoReport;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AuxiliaryMaterialClassDTO)) {
         return false;
      }

      AuxiliaryMaterialClassDTO other = (AuxiliaryMaterialClassDTO)o;
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
            if (this$boolNoReport == null ? other$boolNoReport == null : this$boolNoReport.equals(other$boolNoReport)) {
               Object this$classifyName = this.getClassifyName();
               Object other$classifyName = other.getClassifyName();
               return this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName);
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
      return other instanceof AuxiliaryMaterialClassDTO;
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
      result = result * 59 + ($boolNoReport == null ? 43 : $boolNoReport.hashCode());
      Object $classifyName = this.getClassifyName();
      return result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
   }

   @Override
   public String toString() {
      return "AuxiliaryMaterialClassDTO(projectId="
         + this.getProjectId()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", boolNoReport="
         + this.getBoolNoReport()
         + ")";
   }

   public static class AuxiliaryMaterialClassDTOBuilder {
      private Long projectId;
      private Long classifyId;
      private String classifyName;
      private Boolean boolNoReport;

      AuxiliaryMaterialClassDTOBuilder() {
      }

      public AuxiliaryMaterialClassDTO.AuxiliaryMaterialClassDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public AuxiliaryMaterialClassDTO.AuxiliaryMaterialClassDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public AuxiliaryMaterialClassDTO.AuxiliaryMaterialClassDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public AuxiliaryMaterialClassDTO.AuxiliaryMaterialClassDTOBuilder boolNoReport(final Boolean boolNoReport) {
         this.boolNoReport = boolNoReport;
         return this;
      }

      public AuxiliaryMaterialClassDTO build() {
         return new AuxiliaryMaterialClassDTO(this.projectId, this.classifyId, this.classifyName, this.boolNoReport);
      }

      @Override
      public String toString() {
         return "AuxiliaryMaterialClassDTO.AuxiliaryMaterialClassDTOBuilder(projectId="
            + this.projectId
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", boolNoReport="
            + this.boolNoReport
            + ")";
      }
   }
}
