package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmCanBeReleasedSimpleDTO {
   @ApiModelProperty(name = "crmPageManagementConfigEnum", notes = "配置枚举")
   private Integer crmPageManagementConfigEnum;
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;

   public static CrmCanBeReleasedSimpleDTO.CrmCanBeReleasedSimpleDTOBuilder builder() {
      return new CrmCanBeReleasedSimpleDTO.CrmCanBeReleasedSimpleDTOBuilder();
   }

   public CrmCanBeReleasedSimpleDTO(final Integer crmPageManagementConfigEnum, final Long id, final String projectName) {
      this.crmPageManagementConfigEnum = crmPageManagementConfigEnum;
      this.id = id;
      this.projectName = projectName;
   }

   public CrmCanBeReleasedSimpleDTO() {
   }

   public Integer getCrmPageManagementConfigEnum() {
      return this.crmPageManagementConfigEnum;
   }

   public Long getId() {
      return this.id;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public void setCrmPageManagementConfigEnum(final Integer crmPageManagementConfigEnum) {
      this.crmPageManagementConfigEnum = crmPageManagementConfigEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmCanBeReleasedSimpleDTO)) {
         return false;
      }

      CrmCanBeReleasedSimpleDTO other = (CrmCanBeReleasedSimpleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmPageManagementConfigEnum = this.getCrmPageManagementConfigEnum();
      Object other$crmPageManagementConfigEnum = other.getCrmPageManagementConfigEnum();
      if (this$crmPageManagementConfigEnum == null
         ? other$crmPageManagementConfigEnum == null
         : this$crmPageManagementConfigEnum.equals(other$crmPageManagementConfigEnum)) {
         Object this$id = this.getId();
         Object other$id = other.getId();
         if (this$id == null ? other$id == null : this$id.equals(other$id)) {
            Object this$projectName = this.getProjectName();
            Object other$projectName = other.getProjectName();
            return this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmCanBeReleasedSimpleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmPageManagementConfigEnum = this.getCrmPageManagementConfigEnum();
      result = result * 59 + ($crmPageManagementConfigEnum == null ? 43 : $crmPageManagementConfigEnum.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectName = this.getProjectName();
      return result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
   }

   @Override
   public String toString() {
      return "CrmCanBeReleasedSimpleDTO(crmPageManagementConfigEnum="
         + this.getCrmPageManagementConfigEnum()
         + ", id="
         + this.getId()
         + ", projectName="
         + this.getProjectName()
         + ")";
   }

   public static class CrmCanBeReleasedSimpleDTOBuilder {
      private Integer crmPageManagementConfigEnum;
      private Long id;
      private String projectName;

      CrmCanBeReleasedSimpleDTOBuilder() {
      }

      public CrmCanBeReleasedSimpleDTO.CrmCanBeReleasedSimpleDTOBuilder crmPageManagementConfigEnum(final Integer crmPageManagementConfigEnum) {
         this.crmPageManagementConfigEnum = crmPageManagementConfigEnum;
         return this;
      }

      public CrmCanBeReleasedSimpleDTO.CrmCanBeReleasedSimpleDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmCanBeReleasedSimpleDTO.CrmCanBeReleasedSimpleDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public CrmCanBeReleasedSimpleDTO build() {
         return new CrmCanBeReleasedSimpleDTO(this.crmPageManagementConfigEnum, this.id, this.projectName);
      }

      @Override
      public String toString() {
         return "CrmCanBeReleasedSimpleDTO.CrmCanBeReleasedSimpleDTOBuilder(crmPageManagementConfigEnum="
            + this.crmPageManagementConfigEnum
            + ", id="
            + this.id
            + ", projectName="
            + this.projectName
            + ")";
      }
   }
}
