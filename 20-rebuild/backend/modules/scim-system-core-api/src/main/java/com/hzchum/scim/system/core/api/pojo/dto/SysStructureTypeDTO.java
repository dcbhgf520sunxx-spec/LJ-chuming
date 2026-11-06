package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysStructureType对象", description = "项目结构类型表 ")
public class SysStructureTypeDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "类型名称", notes = "类型名称")
   private String name;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢 2桥梁", notes = "项目类型 1建钢 2桥梁")
   private Integer projectType;
   @ApiModelProperty(name = "bool_enable_enum", value = "是否启用 1启用 0禁用 ")
   private Boolean boolEnableEnum;
   @ApiModelProperty(name = "userId", value = "创建人id", notes = "创建人id")
   private Long userId;

   public static SysStructureTypeDTO.SysStructureTypeDTOBuilder builder() {
      return new SysStructureTypeDTO.SysStructureTypeDTOBuilder();
   }

   public SysStructureTypeDTO() {
   }

   public SysStructureTypeDTO(final Long id, final String name, final Integer projectType, final Boolean boolEnableEnum, final Long userId) {
      this.id = id;
      this.name = name;
      this.projectType = projectType;
      this.boolEnableEnum = boolEnableEnum;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Boolean getBoolEnableEnum() {
      return this.boolEnableEnum;
   }

   public Long getUserId() {
      return this.userId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setBoolEnableEnum(final Boolean boolEnableEnum) {
      this.boolEnableEnum = boolEnableEnum;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysStructureTypeDTO)) {
         return false;
      }

      SysStructureTypeDTO other = (SysStructureTypeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectType = this.getProjectType();
         Object other$projectType = other.getProjectType();
         if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
            Object this$boolEnableEnum = this.getBoolEnableEnum();
            Object other$boolEnableEnum = other.getBoolEnableEnum();
            if (this$boolEnableEnum == null ? other$boolEnableEnum == null : this$boolEnableEnum.equals(other$boolEnableEnum)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof SysStructureTypeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $boolEnableEnum = this.getBoolEnableEnum();
      result = result * 59 + ($boolEnableEnum == null ? 43 : $boolEnableEnum.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "SysStructureTypeDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", projectType="
         + this.getProjectType()
         + ", boolEnableEnum="
         + this.getBoolEnableEnum()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   public static class SysStructureTypeDTOBuilder {
      private Long id;
      private String name;
      private Integer projectType;
      private Boolean boolEnableEnum;
      private Long userId;

      SysStructureTypeDTOBuilder() {
      }

      public SysStructureTypeDTO.SysStructureTypeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysStructureTypeDTO.SysStructureTypeDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysStructureTypeDTO.SysStructureTypeDTOBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public SysStructureTypeDTO.SysStructureTypeDTOBuilder boolEnableEnum(final Boolean boolEnableEnum) {
         this.boolEnableEnum = boolEnableEnum;
         return this;
      }

      public SysStructureTypeDTO.SysStructureTypeDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public SysStructureTypeDTO build() {
         return new SysStructureTypeDTO(this.id, this.name, this.projectType, this.boolEnableEnum, this.userId);
      }

      @Override
      public String toString() {
         return "SysStructureTypeDTO.SysStructureTypeDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", projectType="
            + this.projectType
            + ", boolEnableEnum="
            + this.boolEnableEnum
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
