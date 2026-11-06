package com.hzchum.scim.scm.core.api.pojo.dtoParam.scm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ScmSupplierConfigDTOParam", description = "供应商配置入参对象")
public class ScmSupplierConfigDTOParam {
   @ApiModelProperty("主键ID（修改时必传）")
   private Long id;
   @ApiModelProperty(value = "配置类型（1-评价分类配置 2-分数评级配置 3-资质配置 4-评审模板配置）", required = true)
   @NotNull(message = "配置类型不能为空")
   private Integer configTypeEnum;
   @ApiModelProperty(value = "名称", required = true)
   @NotBlank(message = "名称不能为空")
   private String name;
   @ApiModelProperty("分值（分数评级使用）")
   private String value;
   @ApiModelProperty("最小分值（分数评级使用）")
   private Integer minValue;
   @ApiModelProperty("最大分值（分数评级使用）")
   private Integer maxValue;
   @ApiModelProperty("分类ID（评价分类使用）")
   private Long classifyId;

   public static ScmSupplierConfigDTOParam.ScmSupplierConfigDTOParamBuilder builder() {
      return new ScmSupplierConfigDTOParam.ScmSupplierConfigDTOParamBuilder();
   }

   public ScmSupplierConfigDTOParam() {
   }

   public ScmSupplierConfigDTOParam(
      final Long id, final Integer configTypeEnum, final String name, final String value, final Integer minValue, final Integer maxValue, final Long classifyId
   ) {
      this.id = id;
      this.configTypeEnum = configTypeEnum;
      this.name = name;
      this.value = value;
      this.minValue = minValue;
      this.maxValue = maxValue;
      this.classifyId = classifyId;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getConfigTypeEnum() {
      return this.configTypeEnum;
   }

   public String getName() {
      return this.name;
   }

   public String getValue() {
      return this.value;
   }

   public Integer getMinValue() {
      return this.minValue;
   }

   public Integer getMaxValue() {
      return this.maxValue;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setConfigTypeEnum(final Integer configTypeEnum) {
      this.configTypeEnum = configTypeEnum;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setValue(final String value) {
      this.value = value;
   }

   public void setMinValue(final Integer minValue) {
      this.minValue = minValue;
   }

   public void setMaxValue(final Integer maxValue) {
      this.maxValue = maxValue;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScmSupplierConfigDTOParam)) {
         return false;
      }

      ScmSupplierConfigDTOParam other = (ScmSupplierConfigDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$configTypeEnum = this.getConfigTypeEnum();
         Object other$configTypeEnum = other.getConfigTypeEnum();
         if (this$configTypeEnum == null ? other$configTypeEnum == null : this$configTypeEnum.equals(other$configTypeEnum)) {
            Object this$minValue = this.getMinValue();
            Object other$minValue = other.getMinValue();
            if (this$minValue == null ? other$minValue == null : this$minValue.equals(other$minValue)) {
               Object this$maxValue = this.getMaxValue();
               Object other$maxValue = other.getMaxValue();
               if (this$maxValue == null ? other$maxValue == null : this$maxValue.equals(other$maxValue)) {
                  Object this$classifyId = this.getClassifyId();
                  Object other$classifyId = other.getClassifyId();
                  if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$value = this.getValue();
                        Object other$value = other.getValue();
                        return this$value == null ? other$value == null : this$value.equals(other$value);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ScmSupplierConfigDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $configTypeEnum = this.getConfigTypeEnum();
      result = result * 59 + ($configTypeEnum == null ? 43 : $configTypeEnum.hashCode());
      Object $minValue = this.getMinValue();
      result = result * 59 + ($minValue == null ? 43 : $minValue.hashCode());
      Object $maxValue = this.getMaxValue();
      result = result * 59 + ($maxValue == null ? 43 : $maxValue.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $value = this.getValue();
      return result * 59 + ($value == null ? 43 : $value.hashCode());
   }

   @Override
   public String toString() {
      return "ScmSupplierConfigDTOParam(id="
         + this.getId()
         + ", configTypeEnum="
         + this.getConfigTypeEnum()
         + ", name="
         + this.getName()
         + ", value="
         + this.getValue()
         + ", minValue="
         + this.getMinValue()
         + ", maxValue="
         + this.getMaxValue()
         + ", classifyId="
         + this.getClassifyId()
         + ")";
   }

   public static class ScmSupplierConfigDTOParamBuilder {
      private Long id;
      private Integer configTypeEnum;
      private String name;
      private String value;
      private Integer minValue;
      private Integer maxValue;
      private Long classifyId;

      ScmSupplierConfigDTOParamBuilder() {
      }

      public ScmSupplierConfigDTOParam.ScmSupplierConfigDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ScmSupplierConfigDTOParam.ScmSupplierConfigDTOParamBuilder configTypeEnum(final Integer configTypeEnum) {
         this.configTypeEnum = configTypeEnum;
         return this;
      }

      public ScmSupplierConfigDTOParam.ScmSupplierConfigDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ScmSupplierConfigDTOParam.ScmSupplierConfigDTOParamBuilder value(final String value) {
         this.value = value;
         return this;
      }

      public ScmSupplierConfigDTOParam.ScmSupplierConfigDTOParamBuilder minValue(final Integer minValue) {
         this.minValue = minValue;
         return this;
      }

      public ScmSupplierConfigDTOParam.ScmSupplierConfigDTOParamBuilder maxValue(final Integer maxValue) {
         this.maxValue = maxValue;
         return this;
      }

      public ScmSupplierConfigDTOParam.ScmSupplierConfigDTOParamBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ScmSupplierConfigDTOParam build() {
         return new ScmSupplierConfigDTOParam(this.id, this.configTypeEnum, this.name, this.value, this.minValue, this.maxValue, this.classifyId);
      }

      @Override
      public String toString() {
         return "ScmSupplierConfigDTOParam.ScmSupplierConfigDTOParamBuilder(id="
            + this.id
            + ", configTypeEnum="
            + this.configTypeEnum
            + ", name="
            + this.name
            + ", value="
            + this.value
            + ", minValue="
            + this.minValue
            + ", maxValue="
            + this.maxValue
            + ", classifyId="
            + this.classifyId
            + ")";
      }
   }
}
