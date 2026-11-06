package com.hzchum.scim.system.core.api.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "SysStructureType对象", description = "项目结构类型表 ")
public class SysStructureTypeUpdateParam {
   private static final long serialVersionUID = 1L;
   @NotNull(message = "结构类型id不能为空!")
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @NotBlank(message = "结构类型名称不能为空!")
   @Size(max = 255, message = "结构类型名称长度过大!")
   @ApiModelProperty(name = "name", value = "类型名称", notes = "类型名称")
   private String name;
   @NotNull(message = "启用状态不能为空!")
   @ApiModelProperty(name = "boolEnableEnum", value = "是否启用 1启用 0禁用 ")
   private Boolean boolEnableEnum;

   public static SysStructureTypeUpdateParam.SysStructureTypeUpdateParamBuilder builder() {
      return new SysStructureTypeUpdateParam.SysStructureTypeUpdateParamBuilder();
   }

   public SysStructureTypeUpdateParam() {
   }

   public SysStructureTypeUpdateParam(final Long id, final String name, final Boolean boolEnableEnum) {
      this.id = id;
      this.name = name;
      this.boolEnableEnum = boolEnableEnum;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Boolean getBoolEnableEnum() {
      return this.boolEnableEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setBoolEnableEnum(final Boolean boolEnableEnum) {
      this.boolEnableEnum = boolEnableEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysStructureTypeUpdateParam)) {
         return false;
      }

      SysStructureTypeUpdateParam other = (SysStructureTypeUpdateParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
      return other instanceof SysStructureTypeUpdateParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolEnableEnum = this.getBoolEnableEnum();
      result = result * 59 + ($boolEnableEnum == null ? 43 : $boolEnableEnum.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "SysStructureTypeUpdateParam(id=" + this.getId() + ", name=" + this.getName() + ", boolEnableEnum=" + this.getBoolEnableEnum() + ")";
   }

   public static class SysStructureTypeUpdateParamBuilder {
      private Long id;
      private String name;
      private Boolean boolEnableEnum;

      SysStructureTypeUpdateParamBuilder() {
      }

      public SysStructureTypeUpdateParam.SysStructureTypeUpdateParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysStructureTypeUpdateParam.SysStructureTypeUpdateParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysStructureTypeUpdateParam.SysStructureTypeUpdateParamBuilder boolEnableEnum(final Boolean boolEnableEnum) {
         this.boolEnableEnum = boolEnableEnum;
         return this;
      }

      public SysStructureTypeUpdateParam build() {
         return new SysStructureTypeUpdateParam(this.id, this.name, this.boolEnableEnum);
      }

      @Override
      public String toString() {
         return "SysStructureTypeUpdateParam.SysStructureTypeUpdateParamBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", boolEnableEnum="
            + this.boolEnableEnum
            + ")";
      }
   }
}
