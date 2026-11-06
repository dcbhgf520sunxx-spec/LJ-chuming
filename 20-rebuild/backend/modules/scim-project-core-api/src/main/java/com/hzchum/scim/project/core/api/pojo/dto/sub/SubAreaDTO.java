package com.hzchum.scim.project.core.api.pojo.dto.sub;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("区域类")
public class SubAreaDTO {
   @ApiModelProperty(name = "id", notes = "区域ID")
   private Long id;
   @ApiModelProperty(name = "name", notes = "名称")
   private String name;
   @ApiModelProperty(name = "axis", notes = "轴线或标高")
   private String axis;
   @ApiModelProperty(name = "type", notes = "制造方式 0：自制，1：外协")
   private Integer type;
   @ApiModelProperty(name = "productType", notes = "区域产品类型 1结构件 2压型彩板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer productType;
   @ApiModelProperty(name = "productCategory", notes = "产品类型 2构件 4围护")
   private Integer productCategory;

   public static SubAreaDTO.SubAreaDTOBuilder builder() {
      return new SubAreaDTO.SubAreaDTOBuilder();
   }

   public SubAreaDTO() {
   }

   public SubAreaDTO(final Long id, final String name, final String axis, final Integer type, final Integer productType, final Integer productCategory) {
      this.id = id;
      this.name = name;
      this.axis = axis;
      this.type = type;
      this.productType = productType;
      this.productCategory = productCategory;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getAxis() {
      return this.axis;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getProductCategory() {
      return this.productCategory;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setAxis(final String axis) {
      this.axis = axis;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductCategory(final Integer productCategory) {
      this.productCategory = productCategory;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubAreaDTO)) {
         return false;
      }

      SubAreaDTO other = (SubAreaDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$productCategory = this.getProductCategory();
               Object other$productCategory = other.getProductCategory();
               if (this$productCategory == null ? other$productCategory == null : this$productCategory.equals(other$productCategory)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$axis = this.getAxis();
                     Object other$axis = other.getAxis();
                     return this$axis == null ? other$axis == null : this$axis.equals(other$axis);
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
      return other instanceof SubAreaDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productCategory = this.getProductCategory();
      result = result * 59 + ($productCategory == null ? 43 : $productCategory.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $axis = this.getAxis();
      return result * 59 + ($axis == null ? 43 : $axis.hashCode());
   }

   @Override
   public String toString() {
      return "SubAreaDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", axis="
         + this.getAxis()
         + ", type="
         + this.getType()
         + ", productType="
         + this.getProductType()
         + ", productCategory="
         + this.getProductCategory()
         + ")";
   }

   public static class SubAreaDTOBuilder {
      private Long id;
      private String name;
      private String axis;
      private Integer type;
      private Integer productType;
      private Integer productCategory;

      SubAreaDTOBuilder() {
      }

      public SubAreaDTO.SubAreaDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SubAreaDTO.SubAreaDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SubAreaDTO.SubAreaDTOBuilder axis(final String axis) {
         this.axis = axis;
         return this;
      }

      public SubAreaDTO.SubAreaDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public SubAreaDTO.SubAreaDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public SubAreaDTO.SubAreaDTOBuilder productCategory(final Integer productCategory) {
         this.productCategory = productCategory;
         return this;
      }

      public SubAreaDTO build() {
         return new SubAreaDTO(this.id, this.name, this.axis, this.type, this.productType, this.productCategory);
      }

      @Override
      public String toString() {
         return "SubAreaDTO.SubAreaDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", axis="
            + this.axis
            + ", type="
            + this.type
            + ", productType="
            + this.productType
            + ", productCategory="
            + this.productCategory
            + ")";
      }
   }
}
