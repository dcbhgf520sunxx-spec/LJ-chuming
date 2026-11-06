package com.hzchum.scim.system.core.api.pojo.vo;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(description = "类型截面库配置VO类 ")
public class MesSectionWarehouseConfigVO {
   @ApiModelProperty(name = "id")
   @NotNull(message = "id不能为空!!!")
   private Long id;
   @ApiModelProperty(name = "productSectionName", value = "产品截面类型名称(产品名称/产品截面名称/截面类型名称/编号前缀)")
   @NotEmpty(message = "产品截面类型名称不能为空!!!")
   private List<String> productSectionNameList;
   @ApiModelProperty(name = "ProductSectionNameEnum", value = "产品截面类型名称枚举 1.产品名称 2.产品类型名称 4.截面类型名称 8.编号前缀")
   @NotNull(message = "产品截面类型名称类型不存在!!!")
   @EnumValidator(value = ProductClassificationEnum.class, message = "产品截面类型名称类型不存在!!!")
   private Integer productSectionNameEnum;

   public static MesSectionWarehouseConfigVO.MesSectionWarehouseConfigVOBuilder builder() {
      return new MesSectionWarehouseConfigVO.MesSectionWarehouseConfigVOBuilder();
   }

   public MesSectionWarehouseConfigVO() {
   }

   public MesSectionWarehouseConfigVO(final Long id, final List<String> productSectionNameList, final Integer productSectionNameEnum) {
      this.id = id;
      this.productSectionNameList = productSectionNameList;
      this.productSectionNameEnum = productSectionNameEnum;
   }

   public Long getId() {
      return this.id;
   }

   public List<String> getProductSectionNameList() {
      return this.productSectionNameList;
   }

   public Integer getProductSectionNameEnum() {
      return this.productSectionNameEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProductSectionNameList(final List<String> productSectionNameList) {
      this.productSectionNameList = productSectionNameList;
   }

   public void setProductSectionNameEnum(final Integer productSectionNameEnum) {
      this.productSectionNameEnum = productSectionNameEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesSectionWarehouseConfigVO)) {
         return false;
      }

      MesSectionWarehouseConfigVO other = (MesSectionWarehouseConfigVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productSectionNameEnum = this.getProductSectionNameEnum();
         Object other$productSectionNameEnum = other.getProductSectionNameEnum();
         if (this$productSectionNameEnum == null ? other$productSectionNameEnum == null : this$productSectionNameEnum.equals(other$productSectionNameEnum)) {
            Object this$productSectionNameList = this.getProductSectionNameList();
            Object other$productSectionNameList = other.getProductSectionNameList();
            return this$productSectionNameList == null
               ? other$productSectionNameList == null
               : this$productSectionNameList.equals(other$productSectionNameList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesSectionWarehouseConfigVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productSectionNameEnum = this.getProductSectionNameEnum();
      result = result * 59 + ($productSectionNameEnum == null ? 43 : $productSectionNameEnum.hashCode());
      Object $productSectionNameList = this.getProductSectionNameList();
      return result * 59 + ($productSectionNameList == null ? 43 : $productSectionNameList.hashCode());
   }

   @Override
   public String toString() {
      return "MesSectionWarehouseConfigVO(id="
         + this.getId()
         + ", productSectionNameList="
         + this.getProductSectionNameList()
         + ", productSectionNameEnum="
         + this.getProductSectionNameEnum()
         + ")";
   }

   public static class MesSectionWarehouseConfigVOBuilder {
      private Long id;
      private List<String> productSectionNameList;
      private Integer productSectionNameEnum;

      MesSectionWarehouseConfigVOBuilder() {
      }

      public MesSectionWarehouseConfigVO.MesSectionWarehouseConfigVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesSectionWarehouseConfigVO.MesSectionWarehouseConfigVOBuilder productSectionNameList(final List<String> productSectionNameList) {
         this.productSectionNameList = productSectionNameList;
         return this;
      }

      public MesSectionWarehouseConfigVO.MesSectionWarehouseConfigVOBuilder productSectionNameEnum(final Integer productSectionNameEnum) {
         this.productSectionNameEnum = productSectionNameEnum;
         return this;
      }

      public MesSectionWarehouseConfigVO build() {
         return new MesSectionWarehouseConfigVO(this.id, this.productSectionNameList, this.productSectionNameEnum);
      }

      @Override
      public String toString() {
         return "MesSectionWarehouseConfigVO.MesSectionWarehouseConfigVOBuilder(id="
            + this.id
            + ", productSectionNameList="
            + this.productSectionNameList
            + ", productSectionNameEnum="
            + this.productSectionNameEnum
            + ")";
      }
   }
}
