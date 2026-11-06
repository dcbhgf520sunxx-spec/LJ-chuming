package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel(value = "WasteClassification对象", description = "废料种类-配置 ")
public class WasteClassificationDtoParam {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @NotBlank(message = "废料类型名称不能为空!")
   @Size(max = 32, message = "废料类型名称不能为空")
   private String name;
   @ApiModelProperty(name = "measureUnit", value = "单位", notes = "单位")
   @NotBlank(message = "单位不能为空!")
   @Size(max = 32, message = "单位长度超出范围!")
   private String measureUnit;

   public static WasteClassificationDtoParam.WasteClassificationDtoParamBuilder builder() {
      return new WasteClassificationDtoParam.WasteClassificationDtoParamBuilder();
   }

   public WasteClassificationDtoParam() {
   }

   public WasteClassificationDtoParam(final Long id, final String name, final String measureUnit) {
      this.id = id;
      this.name = name;
      this.measureUnit = measureUnit;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WasteClassificationDtoParam)) {
         return false;
      }

      WasteClassificationDtoParam other = (WasteClassificationDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$measureUnit = this.getMeasureUnit();
            Object other$measureUnit = other.getMeasureUnit();
            return this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WasteClassificationDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      return result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
   }

   @Override
   public String toString() {
      return "WasteClassificationDtoParam(id=" + this.getId() + ", name=" + this.getName() + ", measureUnit=" + this.getMeasureUnit() + ")";
   }

   public static class WasteClassificationDtoParamBuilder {
      private Long id;
      private String name;
      private String measureUnit;

      WasteClassificationDtoParamBuilder() {
      }

      public WasteClassificationDtoParam.WasteClassificationDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WasteClassificationDtoParam.WasteClassificationDtoParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public WasteClassificationDtoParam.WasteClassificationDtoParamBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public WasteClassificationDtoParam build() {
         return new WasteClassificationDtoParam(this.id, this.name, this.measureUnit);
      }

      @Override
      public String toString() {
         return "WasteClassificationDtoParam.WasteClassificationDtoParamBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", measureUnit="
            + this.measureUnit
            + ")";
      }
   }
}
