package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmProjectInformationWarehousingCheckSimpleDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;

   public static CrmProjectInformationWarehousingCheckSimpleDTO.CrmProjectInformationWarehousingCheckSimpleDTOBuilder builder() {
      return new CrmProjectInformationWarehousingCheckSimpleDTO.CrmProjectInformationWarehousingCheckSimpleDTOBuilder();
   }

   public CrmProjectInformationWarehousingCheckSimpleDTO() {
   }

   public CrmProjectInformationWarehousingCheckSimpleDTO(final Long id, final String projectName) {
      this.id = id;
      this.projectName = projectName;
   }

   public Long getId() {
      return this.id;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public CrmProjectInformationWarehousingCheckSimpleDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmProjectInformationWarehousingCheckSimpleDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @Override
   public String toString() {
      return "CrmProjectInformationWarehousingCheckSimpleDTO(id=" + this.getId() + ", projectName=" + this.getProjectName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CrmProjectInformationWarehousingCheckSimpleDTO)) {
         return false;
      } else {
         CrmProjectInformationWarehousingCheckSimpleDTO other = (CrmProjectInformationWarehousingCheckSimpleDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$projectName = this.getProjectName();
               Object other$projectName = other.getProjectName();
               return this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmProjectInformationWarehousingCheckSimpleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectName = this.getProjectName();
      return result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
   }

   public static class CrmProjectInformationWarehousingCheckSimpleDTOBuilder {
      private Long id;
      private String projectName;

      CrmProjectInformationWarehousingCheckSimpleDTOBuilder() {
      }

      public CrmProjectInformationWarehousingCheckSimpleDTO.CrmProjectInformationWarehousingCheckSimpleDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmProjectInformationWarehousingCheckSimpleDTO.CrmProjectInformationWarehousingCheckSimpleDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public CrmProjectInformationWarehousingCheckSimpleDTO build() {
         return new CrmProjectInformationWarehousingCheckSimpleDTO(this.id, this.projectName);
      }

      @Override
      public String toString() {
         return "CrmProjectInformationWarehousingCheckSimpleDTO.CrmProjectInformationWarehousingCheckSimpleDTOBuilder(id="
            + this.id
            + ", projectName="
            + this.projectName
            + ")";
      }
   }
}
