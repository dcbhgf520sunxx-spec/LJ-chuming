package com.hzchum.scim.system.core.api.pojo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysStructureType对象", description = "项目结构类型表 ")
public class SysStructureTypeQueryParam {
   @ApiModelProperty(name = "name", value = "类型名称", notes = "类型名称")
   private String name;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢 2桥梁", notes = "项目类型 1建钢 2桥梁")
   private Integer projectType;
   @ApiModelProperty(name = "bool_enable_enum", value = "是否启用 1启用 0禁用 ")
   private Boolean boolEnableEnum;

   public static SysStructureTypeQueryParam.SysStructureTypeQueryParamBuilder builder() {
      return new SysStructureTypeQueryParam.SysStructureTypeQueryParamBuilder();
   }

   public SysStructureTypeQueryParam() {
   }

   public SysStructureTypeQueryParam(final String name, final Integer projectType, final Boolean boolEnableEnum) {
      this.name = name;
      this.projectType = projectType;
      this.boolEnableEnum = boolEnableEnum;
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

   public void setName(final String name) {
      this.name = name;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setBoolEnableEnum(final Boolean boolEnableEnum) {
      this.boolEnableEnum = boolEnableEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysStructureTypeQueryParam)) {
         return false;
      }

      SysStructureTypeQueryParam other = (SysStructureTypeQueryParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectType = this.getProjectType();
      Object other$projectType = other.getProjectType();
      if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
         Object this$boolEnableEnum = this.getBoolEnableEnum();
         Object other$boolEnableEnum = other.getBoolEnableEnum();
         if (this$boolEnableEnum == null ? other$boolEnableEnum == null : this$boolEnableEnum.equals(other$boolEnableEnum)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysStructureTypeQueryParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $boolEnableEnum = this.getBoolEnableEnum();
      result = result * 59 + ($boolEnableEnum == null ? 43 : $boolEnableEnum.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "SysStructureTypeQueryParam(name="
         + this.getName()
         + ", projectType="
         + this.getProjectType()
         + ", boolEnableEnum="
         + this.getBoolEnableEnum()
         + ")";
   }

   public static class SysStructureTypeQueryParamBuilder {
      private String name;
      private Integer projectType;
      private Boolean boolEnableEnum;

      SysStructureTypeQueryParamBuilder() {
      }

      public SysStructureTypeQueryParam.SysStructureTypeQueryParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysStructureTypeQueryParam.SysStructureTypeQueryParamBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public SysStructureTypeQueryParam.SysStructureTypeQueryParamBuilder boolEnableEnum(final Boolean boolEnableEnum) {
         this.boolEnableEnum = boolEnableEnum;
         return this;
      }

      public SysStructureTypeQueryParam build() {
         return new SysStructureTypeQueryParam(this.name, this.projectType, this.boolEnableEnum);
      }

      @Override
      public String toString() {
         return "SysStructureTypeQueryParam.SysStructureTypeQueryParamBuilder(name="
            + this.name
            + ", projectType="
            + this.projectType
            + ", boolEnableEnum="
            + this.boolEnableEnum
            + ")";
      }
   }
}
