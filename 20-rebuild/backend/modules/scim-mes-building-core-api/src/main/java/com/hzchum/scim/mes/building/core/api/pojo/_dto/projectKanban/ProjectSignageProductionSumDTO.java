package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "projectSignageProductionSumDTO", description = "项目看板汇总")
public class ProjectSignageProductionSumDTO {
   @ApiModelProperty(name = "artifactNoTaskQuantity", notes = "构件未下发数", value = "构件未下发数")
   private Integer artifactNoTaskQuantity;
   @ApiModelProperty(name = "artifactTaskQuantity", notes = "构件任务数", value = "构件任务数")
   private Integer artifactTaskQuantity;
   @ApiModelProperty(name = "artifactCompanyQuantity", notes = "构件任务完成数", value = "构件任务完成数")
   private Integer artifactCompanyQuantity = 0;
   @ApiModelProperty(name = "assembleTaskQuantity", notes = "部件任务数", value = "部件任务数")
   private Integer assembleTaskQuantity = 0;
   @ApiModelProperty(name = "assembleCompanyQuantity", notes = "部件任务完成数", value = "部件任务完成数")
   private Integer assembleCompanyQuantity = 0;
   @ApiModelProperty(name = "partNeedTaskQuantity", notes = "零件需要排产任务数", value = "零件需要排产任务数")
   private Integer partNeedTaskQuantity = 0;
   @ApiModelProperty(name = "partTaskQuantity", notes = "零件任务数", value = "零件任务数")
   private Integer partTaskQuantity = 0;
   @ApiModelProperty(name = "partCompanyQuantity", notes = "零件任务完成数", value = "零件任务完成数")
   private Integer partCompanyQuantity = 0;

   private static Integer $default$artifactNoTaskQuantity() {
      return 0;
   }

   private static Integer $default$artifactTaskQuantity() {
      return 0;
   }

   public static ProjectSignageProductionSumDTO.ProjectSignageProductionSumDTOBuilder builder() {
      return new ProjectSignageProductionSumDTO.ProjectSignageProductionSumDTOBuilder();
   }

   public Integer getArtifactNoTaskQuantity() {
      return this.artifactNoTaskQuantity;
   }

   public Integer getArtifactTaskQuantity() {
      return this.artifactTaskQuantity;
   }

   public Integer getArtifactCompanyQuantity() {
      return this.artifactCompanyQuantity;
   }

   public Integer getAssembleTaskQuantity() {
      return this.assembleTaskQuantity;
   }

   public Integer getAssembleCompanyQuantity() {
      return this.assembleCompanyQuantity;
   }

   public Integer getPartNeedTaskQuantity() {
      return this.partNeedTaskQuantity;
   }

   public Integer getPartTaskQuantity() {
      return this.partTaskQuantity;
   }

   public Integer getPartCompanyQuantity() {
      return this.partCompanyQuantity;
   }

   public void setArtifactNoTaskQuantity(final Integer artifactNoTaskQuantity) {
      this.artifactNoTaskQuantity = artifactNoTaskQuantity;
   }

   public void setArtifactTaskQuantity(final Integer artifactTaskQuantity) {
      this.artifactTaskQuantity = artifactTaskQuantity;
   }

   public void setArtifactCompanyQuantity(final Integer artifactCompanyQuantity) {
      this.artifactCompanyQuantity = artifactCompanyQuantity;
   }

   public void setAssembleTaskQuantity(final Integer assembleTaskQuantity) {
      this.assembleTaskQuantity = assembleTaskQuantity;
   }

   public void setAssembleCompanyQuantity(final Integer assembleCompanyQuantity) {
      this.assembleCompanyQuantity = assembleCompanyQuantity;
   }

   public void setPartNeedTaskQuantity(final Integer partNeedTaskQuantity) {
      this.partNeedTaskQuantity = partNeedTaskQuantity;
   }

   public void setPartTaskQuantity(final Integer partTaskQuantity) {
      this.partTaskQuantity = partTaskQuantity;
   }

   public void setPartCompanyQuantity(final Integer partCompanyQuantity) {
      this.partCompanyQuantity = partCompanyQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSignageProductionSumDTO)) {
         return false;
      }

      ProjectSignageProductionSumDTO other = (ProjectSignageProductionSumDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactNoTaskQuantity = this.getArtifactNoTaskQuantity();
      Object other$artifactNoTaskQuantity = other.getArtifactNoTaskQuantity();
      if (this$artifactNoTaskQuantity == null ? other$artifactNoTaskQuantity == null : this$artifactNoTaskQuantity.equals(other$artifactNoTaskQuantity)) {
         Object this$artifactTaskQuantity = this.getArtifactTaskQuantity();
         Object other$artifactTaskQuantity = other.getArtifactTaskQuantity();
         if (this$artifactTaskQuantity == null ? other$artifactTaskQuantity == null : this$artifactTaskQuantity.equals(other$artifactTaskQuantity)) {
            Object this$artifactCompanyQuantity = this.getArtifactCompanyQuantity();
            Object other$artifactCompanyQuantity = other.getArtifactCompanyQuantity();
            if (this$artifactCompanyQuantity == null
               ? other$artifactCompanyQuantity == null
               : this$artifactCompanyQuantity.equals(other$artifactCompanyQuantity)) {
               Object this$assembleTaskQuantity = this.getAssembleTaskQuantity();
               Object other$assembleTaskQuantity = other.getAssembleTaskQuantity();
               if (this$assembleTaskQuantity == null ? other$assembleTaskQuantity == null : this$assembleTaskQuantity.equals(other$assembleTaskQuantity)) {
                  Object this$assembleCompanyQuantity = this.getAssembleCompanyQuantity();
                  Object other$assembleCompanyQuantity = other.getAssembleCompanyQuantity();
                  if (this$assembleCompanyQuantity == null
                     ? other$assembleCompanyQuantity == null
                     : this$assembleCompanyQuantity.equals(other$assembleCompanyQuantity)) {
                     Object this$partNeedTaskQuantity = this.getPartNeedTaskQuantity();
                     Object other$partNeedTaskQuantity = other.getPartNeedTaskQuantity();
                     if (this$partNeedTaskQuantity == null ? other$partNeedTaskQuantity == null : this$partNeedTaskQuantity.equals(other$partNeedTaskQuantity)) {
                        Object this$partTaskQuantity = this.getPartTaskQuantity();
                        Object other$partTaskQuantity = other.getPartTaskQuantity();
                        if (this$partTaskQuantity == null ? other$partTaskQuantity == null : this$partTaskQuantity.equals(other$partTaskQuantity)) {
                           Object this$partCompanyQuantity = this.getPartCompanyQuantity();
                           Object other$partCompanyQuantity = other.getPartCompanyQuantity();
                           return this$partCompanyQuantity == null
                              ? other$partCompanyQuantity == null
                              : this$partCompanyQuantity.equals(other$partCompanyQuantity);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectSignageProductionSumDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactNoTaskQuantity = this.getArtifactNoTaskQuantity();
      result = result * 59 + ($artifactNoTaskQuantity == null ? 43 : $artifactNoTaskQuantity.hashCode());
      Object $artifactTaskQuantity = this.getArtifactTaskQuantity();
      result = result * 59 + ($artifactTaskQuantity == null ? 43 : $artifactTaskQuantity.hashCode());
      Object $artifactCompanyQuantity = this.getArtifactCompanyQuantity();
      result = result * 59 + ($artifactCompanyQuantity == null ? 43 : $artifactCompanyQuantity.hashCode());
      Object $assembleTaskQuantity = this.getAssembleTaskQuantity();
      result = result * 59 + ($assembleTaskQuantity == null ? 43 : $assembleTaskQuantity.hashCode());
      Object $assembleCompanyQuantity = this.getAssembleCompanyQuantity();
      result = result * 59 + ($assembleCompanyQuantity == null ? 43 : $assembleCompanyQuantity.hashCode());
      Object $partNeedTaskQuantity = this.getPartNeedTaskQuantity();
      result = result * 59 + ($partNeedTaskQuantity == null ? 43 : $partNeedTaskQuantity.hashCode());
      Object $partTaskQuantity = this.getPartTaskQuantity();
      result = result * 59 + ($partTaskQuantity == null ? 43 : $partTaskQuantity.hashCode());
      Object $partCompanyQuantity = this.getPartCompanyQuantity();
      return result * 59 + ($partCompanyQuantity == null ? 43 : $partCompanyQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSignageProductionSumDTO(artifactNoTaskQuantity="
         + this.getArtifactNoTaskQuantity()
         + ", artifactTaskQuantity="
         + this.getArtifactTaskQuantity()
         + ", artifactCompanyQuantity="
         + this.getArtifactCompanyQuantity()
         + ", assembleTaskQuantity="
         + this.getAssembleTaskQuantity()
         + ", assembleCompanyQuantity="
         + this.getAssembleCompanyQuantity()
         + ", partNeedTaskQuantity="
         + this.getPartNeedTaskQuantity()
         + ", partTaskQuantity="
         + this.getPartTaskQuantity()
         + ", partCompanyQuantity="
         + this.getPartCompanyQuantity()
         + ")";
   }

   public ProjectSignageProductionSumDTO(
      final Integer artifactNoTaskQuantity,
      final Integer artifactTaskQuantity,
      final Integer artifactCompanyQuantity,
      final Integer assembleTaskQuantity,
      final Integer assembleCompanyQuantity,
      final Integer partNeedTaskQuantity,
      final Integer partTaskQuantity,
      final Integer partCompanyQuantity
   ) {
      this.artifactNoTaskQuantity = artifactNoTaskQuantity;
      this.artifactTaskQuantity = artifactTaskQuantity;
      this.artifactCompanyQuantity = artifactCompanyQuantity;
      this.assembleTaskQuantity = assembleTaskQuantity;
      this.assembleCompanyQuantity = assembleCompanyQuantity;
      this.partNeedTaskQuantity = partNeedTaskQuantity;
      this.partTaskQuantity = partTaskQuantity;
      this.partCompanyQuantity = partCompanyQuantity;
   }

   public ProjectSignageProductionSumDTO() {
      this.artifactNoTaskQuantity = $default$artifactNoTaskQuantity();
      this.artifactTaskQuantity = $default$artifactTaskQuantity();
   }

   public static class ProjectSignageProductionSumDTOBuilder {
      private boolean artifactNoTaskQuantity$set;
      private Integer artifactNoTaskQuantity$value;
      private boolean artifactTaskQuantity$set;
      private Integer artifactTaskQuantity$value;
      private Integer artifactCompanyQuantity;
      private Integer assembleTaskQuantity;
      private Integer assembleCompanyQuantity;
      private Integer partNeedTaskQuantity;
      private Integer partTaskQuantity;
      private Integer partCompanyQuantity;

      ProjectSignageProductionSumDTOBuilder() {
      }

      public ProjectSignageProductionSumDTO.ProjectSignageProductionSumDTOBuilder artifactNoTaskQuantity(final Integer artifactNoTaskQuantity) {
         this.artifactNoTaskQuantity$value = artifactNoTaskQuantity;
         this.artifactNoTaskQuantity$set = true;
         return this;
      }

      public ProjectSignageProductionSumDTO.ProjectSignageProductionSumDTOBuilder artifactTaskQuantity(final Integer artifactTaskQuantity) {
         this.artifactTaskQuantity$value = artifactTaskQuantity;
         this.artifactTaskQuantity$set = true;
         return this;
      }

      public ProjectSignageProductionSumDTO.ProjectSignageProductionSumDTOBuilder artifactCompanyQuantity(final Integer artifactCompanyQuantity) {
         this.artifactCompanyQuantity = artifactCompanyQuantity;
         return this;
      }

      public ProjectSignageProductionSumDTO.ProjectSignageProductionSumDTOBuilder assembleTaskQuantity(final Integer assembleTaskQuantity) {
         this.assembleTaskQuantity = assembleTaskQuantity;
         return this;
      }

      public ProjectSignageProductionSumDTO.ProjectSignageProductionSumDTOBuilder assembleCompanyQuantity(final Integer assembleCompanyQuantity) {
         this.assembleCompanyQuantity = assembleCompanyQuantity;
         return this;
      }

      public ProjectSignageProductionSumDTO.ProjectSignageProductionSumDTOBuilder partNeedTaskQuantity(final Integer partNeedTaskQuantity) {
         this.partNeedTaskQuantity = partNeedTaskQuantity;
         return this;
      }

      public ProjectSignageProductionSumDTO.ProjectSignageProductionSumDTOBuilder partTaskQuantity(final Integer partTaskQuantity) {
         this.partTaskQuantity = partTaskQuantity;
         return this;
      }

      public ProjectSignageProductionSumDTO.ProjectSignageProductionSumDTOBuilder partCompanyQuantity(final Integer partCompanyQuantity) {
         this.partCompanyQuantity = partCompanyQuantity;
         return this;
      }

      public ProjectSignageProductionSumDTO build() {
         Integer artifactNoTaskQuantity$value = this.artifactNoTaskQuantity$value;
         if (!this.artifactNoTaskQuantity$set) {
            artifactNoTaskQuantity$value = ProjectSignageProductionSumDTO.$default$artifactNoTaskQuantity();
         }

         Integer artifactTaskQuantity$value = this.artifactTaskQuantity$value;
         if (!this.artifactTaskQuantity$set) {
            artifactTaskQuantity$value = ProjectSignageProductionSumDTO.$default$artifactTaskQuantity();
         }

         return new ProjectSignageProductionSumDTO(
            artifactNoTaskQuantity$value,
            artifactTaskQuantity$value,
            this.artifactCompanyQuantity,
            this.assembleTaskQuantity,
            this.assembleCompanyQuantity,
            this.partNeedTaskQuantity,
            this.partTaskQuantity,
            this.partCompanyQuantity
         );
      }

      @Override
      public String toString() {
         return "ProjectSignageProductionSumDTO.ProjectSignageProductionSumDTOBuilder(artifactNoTaskQuantity$value="
            + this.artifactNoTaskQuantity$value
            + ", artifactTaskQuantity$value="
            + this.artifactTaskQuantity$value
            + ", artifactCompanyQuantity="
            + this.artifactCompanyQuantity
            + ", assembleTaskQuantity="
            + this.assembleTaskQuantity
            + ", assembleCompanyQuantity="
            + this.assembleCompanyQuantity
            + ", partNeedTaskQuantity="
            + this.partNeedTaskQuantity
            + ", partTaskQuantity="
            + this.partTaskQuantity
            + ", partCompanyQuantity="
            + this.partCompanyQuantity
            + ")";
      }
   }
}
