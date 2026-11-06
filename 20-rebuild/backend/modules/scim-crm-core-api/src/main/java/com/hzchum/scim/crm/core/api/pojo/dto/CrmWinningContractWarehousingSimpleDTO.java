package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmWinningContractWarehousingSimpleDTO {
   @ApiModelProperty(name = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "projectName", notes = "项目名称   crm中标编号 + 项目名称")
   private String projectName;

   public static CrmWinningContractWarehousingSimpleDTO.CrmWinningContractWarehousingSimpleDTOBuilder builder() {
      return new CrmWinningContractWarehousingSimpleDTO.CrmWinningContractWarehousingSimpleDTOBuilder();
   }

   public CrmWinningContractWarehousingSimpleDTO() {
   }

   public CrmWinningContractWarehousingSimpleDTO(final Long id, final String projectName) {
      this.id = id;
      this.projectName = projectName;
   }

   public Long getId() {
      return this.id;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public CrmWinningContractWarehousingSimpleDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmWinningContractWarehousingSimpleDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @Override
   public String toString() {
      return "CrmWinningContractWarehousingSimpleDTO(id=" + this.getId() + ", projectName=" + this.getProjectName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CrmWinningContractWarehousingSimpleDTO)) {
         return false;
      } else {
         CrmWinningContractWarehousingSimpleDTO other = (CrmWinningContractWarehousingSimpleDTO)o;
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
      return other instanceof CrmWinningContractWarehousingSimpleDTO;
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

   public static class CrmWinningContractWarehousingSimpleDTOBuilder {
      private Long id;
      private String projectName;

      CrmWinningContractWarehousingSimpleDTOBuilder() {
      }

      public CrmWinningContractWarehousingSimpleDTO.CrmWinningContractWarehousingSimpleDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmWinningContractWarehousingSimpleDTO.CrmWinningContractWarehousingSimpleDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public CrmWinningContractWarehousingSimpleDTO build() {
         return new CrmWinningContractWarehousingSimpleDTO(this.id, this.projectName);
      }

      @Override
      public String toString() {
         return "CrmWinningContractWarehousingSimpleDTO.CrmWinningContractWarehousingSimpleDTOBuilder(id="
            + this.id
            + ", projectName="
            + this.projectName
            + ")";
      }
   }
}
