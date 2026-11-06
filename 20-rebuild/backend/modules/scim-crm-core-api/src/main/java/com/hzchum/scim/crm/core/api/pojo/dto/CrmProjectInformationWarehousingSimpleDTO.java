package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmProjectInformationWarehousingSimpleDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "备案号", notes = "备案号")
   private String serialNumber;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;

   public static CrmProjectInformationWarehousingSimpleDTO.CrmProjectInformationWarehousingSimpleDTOBuilder builder() {
      return new CrmProjectInformationWarehousingSimpleDTO.CrmProjectInformationWarehousingSimpleDTOBuilder();
   }

   public CrmProjectInformationWarehousingSimpleDTO() {
   }

   public CrmProjectInformationWarehousingSimpleDTO(final Long id, final String serialNumber, final String projectName) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.projectName = projectName;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public CrmProjectInformationWarehousingSimpleDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmProjectInformationWarehousingSimpleDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public CrmProjectInformationWarehousingSimpleDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @Override
   public String toString() {
      return "CrmProjectInformationWarehousingSimpleDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectName="
         + this.getProjectName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmProjectInformationWarehousingSimpleDTO)) {
         return false;
      }

      CrmProjectInformationWarehousingSimpleDTO other = (CrmProjectInformationWarehousingSimpleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
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
      return other instanceof CrmProjectInformationWarehousingSimpleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectName = this.getProjectName();
      return result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
   }

   public static class CrmProjectInformationWarehousingSimpleDTOBuilder {
      private Long id;
      private String serialNumber;
      private String projectName;

      CrmProjectInformationWarehousingSimpleDTOBuilder() {
      }

      public CrmProjectInformationWarehousingSimpleDTO.CrmProjectInformationWarehousingSimpleDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmProjectInformationWarehousingSimpleDTO.CrmProjectInformationWarehousingSimpleDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CrmProjectInformationWarehousingSimpleDTO.CrmProjectInformationWarehousingSimpleDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public CrmProjectInformationWarehousingSimpleDTO build() {
         return new CrmProjectInformationWarehousingSimpleDTO(this.id, this.serialNumber, this.projectName);
      }

      @Override
      public String toString() {
         return "CrmProjectInformationWarehousingSimpleDTO.CrmProjectInformationWarehousingSimpleDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", projectName="
            + this.projectName
            + ")";
      }
   }
}
