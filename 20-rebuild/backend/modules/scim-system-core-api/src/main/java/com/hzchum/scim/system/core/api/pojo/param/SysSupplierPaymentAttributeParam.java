package com.hzchum.scim.system.core.api.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel(value = "SysSupplierPaymentReason对象", description = "付款属性配置表")
public class SysSupplierPaymentAttributeParam {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @NotBlank(message = "付款属性(原因)名称不能为空!")
   @Size(max = 255, message = "字数过多!")
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   private Integer sort;

   public static SysSupplierPaymentAttributeParam.SysSupplierPaymentAttributeParamBuilder builder() {
      return new SysSupplierPaymentAttributeParam.SysSupplierPaymentAttributeParamBuilder();
   }

   public SysSupplierPaymentAttributeParam() {
   }

   public SysSupplierPaymentAttributeParam(final Long id, final String name, final Integer sort) {
      this.id = id;
      this.name = name;
      this.sort = sort;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysSupplierPaymentAttributeParam)) {
         return false;
      }

      SysSupplierPaymentAttributeParam other = (SysSupplierPaymentAttributeParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
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
      return other instanceof SysSupplierPaymentAttributeParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "SysSupplierPaymentAttributeParam(id=" + this.getId() + ", name=" + this.getName() + ", sort=" + this.getSort() + ")";
   }

   public static class SysSupplierPaymentAttributeParamBuilder {
      private Long id;
      private String name;
      private Integer sort;

      SysSupplierPaymentAttributeParamBuilder() {
      }

      public SysSupplierPaymentAttributeParam.SysSupplierPaymentAttributeParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysSupplierPaymentAttributeParam.SysSupplierPaymentAttributeParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysSupplierPaymentAttributeParam.SysSupplierPaymentAttributeParamBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public SysSupplierPaymentAttributeParam build() {
         return new SysSupplierPaymentAttributeParam(this.id, this.name, this.sort);
      }

      @Override
      public String toString() {
         return "SysSupplierPaymentAttributeParam.SysSupplierPaymentAttributeParamBuilder(id=" + this.id + ", name=" + this.name + ", sort=" + this.sort + ")";
      }
   }
}
