package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import io.swagger.annotations.ApiModelProperty;

public class ProjectResponseDTO {
   @ApiModelProperty(name = "id", value = "项目id")
   private Long id;
   @ApiModelProperty(name = "name", value = "项目名称")
   private String name;
   @ApiModelProperty(name = "shortName", value = "项目简称")
   private String shortName;
   @ApiModelProperty(name = "serialNumber", value = "合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建筑钢结构 2桥梁钢结构 3立体停车库 4围护材料")
   private Integer projectType;

   public static ProjectResponseDTO.ProjectResponseDTOBuilder builder() {
      return new ProjectResponseDTO.ProjectResponseDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectResponseDTO)) {
         return false;
      }

      ProjectResponseDTO other = (ProjectResponseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectType = this.getProjectType();
         Object other$projectType = other.getProjectType();
         if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$shortName = this.getShortName();
               Object other$shortName = other.getShortName();
               if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
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
      return other instanceof ProjectResponseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectResponseDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectType="
         + this.getProjectType()
         + ")";
   }

   public ProjectResponseDTO() {
   }

   public ProjectResponseDTO(final Long id, final String name, final String shortName, final String serialNumber, final Integer projectType) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.serialNumber = serialNumber;
      this.projectType = projectType;
   }

   public static class ProjectResponseDTOBuilder {
      private Long id;
      private String name;
      private String shortName;
      private String serialNumber;
      private Integer projectType;

      ProjectResponseDTOBuilder() {
      }

      public ProjectResponseDTO.ProjectResponseDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectResponseDTO.ProjectResponseDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectResponseDTO.ProjectResponseDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public ProjectResponseDTO.ProjectResponseDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectResponseDTO.ProjectResponseDTOBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public ProjectResponseDTO build() {
         return new ProjectResponseDTO(this.id, this.name, this.shortName, this.serialNumber, this.projectType);
      }

      @Override
      public String toString() {
         return "ProjectResponseDTO.ProjectResponseDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", serialNumber="
            + this.serialNumber
            + ", projectType="
            + this.projectType
            + ")";
      }
   }
}
