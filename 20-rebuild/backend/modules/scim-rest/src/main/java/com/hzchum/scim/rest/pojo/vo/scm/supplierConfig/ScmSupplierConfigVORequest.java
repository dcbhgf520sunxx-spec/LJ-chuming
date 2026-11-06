package com.hzchum.scim.rest.pojo.vo.scm.supplierConfig;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

@ApiModel(value = "ScmSupplierConfigVORequest", description = "供应商配置请求入参")
public class ScmSupplierConfigVORequest {
   @ApiModelProperty("主键ID（修改时必传）")
   private Long id;
   @ApiModelProperty(value = "名称", required = true)
   @NotBlank(message = "名称不能为空")
   private String name;
   @ApiModelProperty("最小分值（分数评级使用）")
   private Integer minValue;
   @ApiModelProperty("最大分值（分数评级使用）")
   private Integer maxValue;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getMinValue() {
      return this.minValue;
   }

   public Integer getMaxValue() {
      return this.maxValue;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMinValue(final Integer minValue) {
      this.minValue = minValue;
   }

   public void setMaxValue(final Integer maxValue) {
      this.maxValue = maxValue;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScmSupplierConfigVORequest)) {
         return false;
      }

      ScmSupplierConfigVORequest other = (ScmSupplierConfigVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$minValue = this.getMinValue();
         Object other$minValue = other.getMinValue();
         if (this$minValue == null ? other$minValue == null : this$minValue.equals(other$minValue)) {
            Object this$maxValue = this.getMaxValue();
            Object other$maxValue = other.getMaxValue();
            if (this$maxValue == null ? other$maxValue == null : this$maxValue.equals(other$maxValue)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ScmSupplierConfigVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $minValue = this.getMinValue();
      result = result * 59 + ($minValue == null ? 43 : $minValue.hashCode());
      Object $maxValue = this.getMaxValue();
      result = result * 59 + ($maxValue == null ? 43 : $maxValue.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "ScmSupplierConfigVORequest(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", minValue="
         + this.getMinValue()
         + ", maxValue="
         + this.getMaxValue()
         + ")";
   }
}
