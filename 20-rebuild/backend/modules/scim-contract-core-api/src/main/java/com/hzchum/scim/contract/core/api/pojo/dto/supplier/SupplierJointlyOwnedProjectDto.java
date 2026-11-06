package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;

@ApiOperation("供应商-合营项目返回")
public class SupplierJointlyOwnedProjectDto {
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("项目经理id")
   private Long projectManagerId;
   @ApiModelProperty("项目经理")
   private String projectManagerName;
   @ApiModelProperty("项目经理占比")
   private BigDecimal projectManagerRatio;
   @ApiModelProperty("签约主体id")
   private Long signeeId;
   @ApiModelProperty("签约主体")
   private String signeeName;
   @ApiModelProperty("签约主体占比")
   private BigDecimal signeeRatio;

   public static SupplierJointlyOwnedProjectDto.SupplierJointlyOwnedProjectDtoBuilder builder() {
      return new SupplierJointlyOwnedProjectDto.SupplierJointlyOwnedProjectDtoBuilder();
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public BigDecimal getProjectManagerRatio() {
      return this.projectManagerRatio;
   }

   public Long getSigneeId() {
      return this.signeeId;
   }

   public String getSigneeName() {
      return this.signeeName;
   }

   public BigDecimal getSigneeRatio() {
      return this.signeeRatio;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setProjectManagerRatio(final BigDecimal projectManagerRatio) {
      this.projectManagerRatio = projectManagerRatio;
   }

   public void setSigneeId(final Long signeeId) {
      this.signeeId = signeeId;
   }

   public void setSigneeName(final String signeeName) {
      this.signeeName = signeeName;
   }

   public void setSigneeRatio(final BigDecimal signeeRatio) {
      this.signeeRatio = signeeRatio;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierJointlyOwnedProjectDto)) {
         return false;
      }

      SupplierJointlyOwnedProjectDto other = (SupplierJointlyOwnedProjectDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectManagerId = this.getProjectManagerId();
      Object other$projectManagerId = other.getProjectManagerId();
      if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
         Object this$signeeId = this.getSigneeId();
         Object other$signeeId = other.getSigneeId();
         if (this$signeeId == null ? other$signeeId == null : this$signeeId.equals(other$signeeId)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$projectManagerName = this.getProjectManagerName();
               Object other$projectManagerName = other.getProjectManagerName();
               if (this$projectManagerName == null ? other$projectManagerName == null : this$projectManagerName.equals(other$projectManagerName)) {
                  Object this$projectManagerRatio = this.getProjectManagerRatio();
                  Object other$projectManagerRatio = other.getProjectManagerRatio();
                  if (this$projectManagerRatio == null ? other$projectManagerRatio == null : this$projectManagerRatio.equals(other$projectManagerRatio)) {
                     Object this$signeeName = this.getSigneeName();
                     Object other$signeeName = other.getSigneeName();
                     if (this$signeeName == null ? other$signeeName == null : this$signeeName.equals(other$signeeName)) {
                        Object this$signeeRatio = this.getSigneeRatio();
                        Object other$signeeRatio = other.getSigneeRatio();
                        return this$signeeRatio == null ? other$signeeRatio == null : this$signeeRatio.equals(other$signeeRatio);
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
      return other instanceof SupplierJointlyOwnedProjectDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $signeeId = this.getSigneeId();
      result = result * 59 + ($signeeId == null ? 43 : $signeeId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $projectManagerRatio = this.getProjectManagerRatio();
      result = result * 59 + ($projectManagerRatio == null ? 43 : $projectManagerRatio.hashCode());
      Object $signeeName = this.getSigneeName();
      result = result * 59 + ($signeeName == null ? 43 : $signeeName.hashCode());
      Object $signeeRatio = this.getSigneeRatio();
      return result * 59 + ($signeeRatio == null ? 43 : $signeeRatio.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierJointlyOwnedProjectDto(project="
         + this.getProject()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", projectManagerRatio="
         + this.getProjectManagerRatio()
         + ", signeeId="
         + this.getSigneeId()
         + ", signeeName="
         + this.getSigneeName()
         + ", signeeRatio="
         + this.getSigneeRatio()
         + ")";
   }

   public SupplierJointlyOwnedProjectDto(
      final ProjectInfo project,
      final Long projectManagerId,
      final String projectManagerName,
      final BigDecimal projectManagerRatio,
      final Long signeeId,
      final String signeeName,
      final BigDecimal signeeRatio
   ) {
      this.project = project;
      this.projectManagerId = projectManagerId;
      this.projectManagerName = projectManagerName;
      this.projectManagerRatio = projectManagerRatio;
      this.signeeId = signeeId;
      this.signeeName = signeeName;
      this.signeeRatio = signeeRatio;
   }

   public SupplierJointlyOwnedProjectDto() {
   }

   public static class SupplierJointlyOwnedProjectDtoBuilder {
      private ProjectInfo project;
      private Long projectManagerId;
      private String projectManagerName;
      private BigDecimal projectManagerRatio;
      private Long signeeId;
      private String signeeName;
      private BigDecimal signeeRatio;

      SupplierJointlyOwnedProjectDtoBuilder() {
      }

      public SupplierJointlyOwnedProjectDto.SupplierJointlyOwnedProjectDtoBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public SupplierJointlyOwnedProjectDto.SupplierJointlyOwnedProjectDtoBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public SupplierJointlyOwnedProjectDto.SupplierJointlyOwnedProjectDtoBuilder projectManagerName(final String projectManagerName) {
         this.projectManagerName = projectManagerName;
         return this;
      }

      public SupplierJointlyOwnedProjectDto.SupplierJointlyOwnedProjectDtoBuilder projectManagerRatio(final BigDecimal projectManagerRatio) {
         this.projectManagerRatio = projectManagerRatio;
         return this;
      }

      public SupplierJointlyOwnedProjectDto.SupplierJointlyOwnedProjectDtoBuilder signeeId(final Long signeeId) {
         this.signeeId = signeeId;
         return this;
      }

      public SupplierJointlyOwnedProjectDto.SupplierJointlyOwnedProjectDtoBuilder signeeName(final String signeeName) {
         this.signeeName = signeeName;
         return this;
      }

      public SupplierJointlyOwnedProjectDto.SupplierJointlyOwnedProjectDtoBuilder signeeRatio(final BigDecimal signeeRatio) {
         this.signeeRatio = signeeRatio;
         return this;
      }

      public SupplierJointlyOwnedProjectDto build() {
         return new SupplierJointlyOwnedProjectDto(
            this.project, this.projectManagerId, this.projectManagerName, this.projectManagerRatio, this.signeeId, this.signeeName, this.signeeRatio
         );
      }

      @Override
      public String toString() {
         return "SupplierJointlyOwnedProjectDto.SupplierJointlyOwnedProjectDtoBuilder(project="
            + this.project
            + ", projectManagerId="
            + this.projectManagerId
            + ", projectManagerName="
            + this.projectManagerName
            + ", projectManagerRatio="
            + this.projectManagerRatio
            + ", signeeId="
            + this.signeeId
            + ", signeeName="
            + this.signeeName
            + ", signeeRatio="
            + this.signeeRatio
            + ")";
      }
   }
}
