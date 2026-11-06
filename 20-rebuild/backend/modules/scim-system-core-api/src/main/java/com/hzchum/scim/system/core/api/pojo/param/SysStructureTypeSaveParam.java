package com.hzchum.scim.system.core.api.pojo.param;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.ProjectTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "SysStructureType对象", description = "项目结构类型表 ")
public class SysStructureTypeSaveParam {
   private static final long serialVersionUID = 1L;
   @NotBlank(message = "结构类型名称不能为空!")
   @Size(max = 255, message = "结构类型名称长度过大!")
   @ApiModelProperty(name = "name", value = "类型名称", notes = "类型名称")
   private String name;
   @NotNull(message = "项目类型不能为空!")
   @EnumValidator(value = ProjectTypeEnum.class, message = "项目类型有误!")
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢 2桥梁", notes = "项目类型 1建钢 2桥梁")
   private Integer projectType;

   public static SysStructureTypeSaveParam.SysStructureTypeSaveParamBuilder builder() {
      return new SysStructureTypeSaveParam.SysStructureTypeSaveParamBuilder();
   }

   public SysStructureTypeSaveParam() {
   }

   public SysStructureTypeSaveParam(final String name, final Integer projectType) {
      this.name = name;
      this.projectType = projectType;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SysStructureTypeSaveParam)) {
         return false;
      } else {
         SysStructureTypeSaveParam other = (SysStructureTypeSaveParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectType = this.getProjectType();
            Object other$projectType = other.getProjectType();
            if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysStructureTypeSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "SysStructureTypeSaveParam(name=" + this.getName() + ", projectType=" + this.getProjectType() + ")";
   }

   public static class SysStructureTypeSaveParamBuilder {
      private String name;
      private Integer projectType;

      SysStructureTypeSaveParamBuilder() {
      }

      public SysStructureTypeSaveParam.SysStructureTypeSaveParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysStructureTypeSaveParam.SysStructureTypeSaveParamBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public SysStructureTypeSaveParam build() {
         return new SysStructureTypeSaveParam(this.name, this.projectType);
      }

      @Override
      public String toString() {
         return "SysStructureTypeSaveParam.SysStructureTypeSaveParamBuilder(name=" + this.name + ", projectType=" + this.projectType + ")";
      }
   }
}
