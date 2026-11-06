package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmRemainderCanEstablishProjectInfoDTO {
   @ApiModelProperty(name = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "projectName", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "serialNumber", notes = "项目备案号")
   private String serialNumber;

   public static CrmRemainderCanEstablishProjectInfoDTO.CrmRemainderCanEstablishProjectInfoDTOBuilder builder() {
      return new CrmRemainderCanEstablishProjectInfoDTO.CrmRemainderCanEstablishProjectInfoDTOBuilder();
   }

   public CrmRemainderCanEstablishProjectInfoDTO() {
   }

   public CrmRemainderCanEstablishProjectInfoDTO(final Long id, final String projectName, final String serialNumber) {
      this.id = id;
      this.projectName = projectName;
      this.serialNumber = serialNumber;
   }

   public Long getId() {
      return this.id;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public CrmRemainderCanEstablishProjectInfoDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmRemainderCanEstablishProjectInfoDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public CrmRemainderCanEstablishProjectInfoDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @Override
   public String toString() {
      return "CrmRemainderCanEstablishProjectInfoDTO(id="
         + this.getId()
         + ", projectName="
         + this.getProjectName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmRemainderCanEstablishProjectInfoDTO)) {
         return false;
      }

      CrmRemainderCanEstablishProjectInfoDTO other = (CrmRemainderCanEstablishProjectInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectName = this.getProjectName();
         Object other$projectName = other.getProjectName();
         if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmRemainderCanEstablishProjectInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   public static class CrmRemainderCanEstablishProjectInfoDTOBuilder {
      private Long id;
      private String projectName;
      private String serialNumber;

      CrmRemainderCanEstablishProjectInfoDTOBuilder() {
      }

      public CrmRemainderCanEstablishProjectInfoDTO.CrmRemainderCanEstablishProjectInfoDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmRemainderCanEstablishProjectInfoDTO.CrmRemainderCanEstablishProjectInfoDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public CrmRemainderCanEstablishProjectInfoDTO.CrmRemainderCanEstablishProjectInfoDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CrmRemainderCanEstablishProjectInfoDTO build() {
         return new CrmRemainderCanEstablishProjectInfoDTO(this.id, this.projectName, this.serialNumber);
      }

      @Override
      public String toString() {
         return "CrmRemainderCanEstablishProjectInfoDTO.CrmRemainderCanEstablishProjectInfoDTOBuilder(id="
            + this.id
            + ", projectName="
            + this.projectName
            + ", serialNumber="
            + this.serialNumber
            + ")";
      }
   }
}
