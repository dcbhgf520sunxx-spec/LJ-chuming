package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class ContractProjectChangeInfoDTO {
   @ApiModelProperty("变更前项目信息")
   private ContractProjectDTO projectDto;
   @ApiModelProperty("变更后项目信息")
   private ContractProjectTempDTO projectTempDto;

   public static ContractProjectChangeInfoDTO.ContractProjectChangeInfoDTOBuilder builder() {
      return new ContractProjectChangeInfoDTO.ContractProjectChangeInfoDTOBuilder();
   }

   public ContractProjectDTO getProjectDto() {
      return this.projectDto;
   }

   public ContractProjectTempDTO getProjectTempDto() {
      return this.projectTempDto;
   }

   public void setProjectDto(final ContractProjectDTO projectDto) {
      this.projectDto = projectDto;
   }

   public void setProjectTempDto(final ContractProjectTempDTO projectTempDto) {
      this.projectTempDto = projectTempDto;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ContractProjectChangeInfoDTO)) {
         return false;
      } else {
         ContractProjectChangeInfoDTO other = (ContractProjectChangeInfoDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectDto = this.getProjectDto();
            Object other$projectDto = other.getProjectDto();
            if (this$projectDto == null ? other$projectDto == null : this$projectDto.equals(other$projectDto)) {
               Object this$projectTempDto = this.getProjectTempDto();
               Object other$projectTempDto = other.getProjectTempDto();
               return this$projectTempDto == null ? other$projectTempDto == null : this$projectTempDto.equals(other$projectTempDto);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractProjectChangeInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectDto = this.getProjectDto();
      result = result * 59 + ($projectDto == null ? 43 : $projectDto.hashCode());
      Object $projectTempDto = this.getProjectTempDto();
      return result * 59 + ($projectTempDto == null ? 43 : $projectTempDto.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectChangeInfoDTO(projectDto=" + this.getProjectDto() + ", projectTempDto=" + this.getProjectTempDto() + ")";
   }

   public ContractProjectChangeInfoDTO(final ContractProjectDTO projectDto, final ContractProjectTempDTO projectTempDto) {
      this.projectDto = projectDto;
      this.projectTempDto = projectTempDto;
   }

   public ContractProjectChangeInfoDTO() {
   }

   public static class ContractProjectChangeInfoDTOBuilder {
      private ContractProjectDTO projectDto;
      private ContractProjectTempDTO projectTempDto;

      ContractProjectChangeInfoDTOBuilder() {
      }

      public ContractProjectChangeInfoDTO.ContractProjectChangeInfoDTOBuilder projectDto(final ContractProjectDTO projectDto) {
         this.projectDto = projectDto;
         return this;
      }

      public ContractProjectChangeInfoDTO.ContractProjectChangeInfoDTOBuilder projectTempDto(final ContractProjectTempDTO projectTempDto) {
         this.projectTempDto = projectTempDto;
         return this;
      }

      public ContractProjectChangeInfoDTO build() {
         return new ContractProjectChangeInfoDTO(this.projectDto, this.projectTempDto);
      }

      @Override
      public String toString() {
         return "ContractProjectChangeInfoDTO.ContractProjectChangeInfoDTOBuilder(projectDto="
            + this.projectDto
            + ", projectTempDto="
            + this.projectTempDto
            + ")";
      }
   }
}
