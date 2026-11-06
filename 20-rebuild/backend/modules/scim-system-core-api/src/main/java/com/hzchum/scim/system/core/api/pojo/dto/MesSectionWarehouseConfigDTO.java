package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(description = "类型截面库配置DTO类 ")
public class MesSectionWarehouseConfigDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "productSectionNameList", value = "产品截面类型名称列表(产品名称/产品截面名称/截面类型名称)")
   private List<MesSectionWarehouseConfigDetailDTO> sectionWarehouseConfigDTOList;
   @ApiModelProperty(name = "productType", value = "产品类型 1.零件 2.构件 16.组立")
   private Integer productType;
   @ApiModelProperty(name = "productClassificationEnum", value = "产品分类 1.普通构件 2.次构件 4.型材制品 8.钢板制品 16.部件")
   private Integer productClassificationEnum;
   @ApiModelProperty(name = "ProductSectionNameEnum", value = "产品截面类型名称枚举 1.产品名称 2.产品类型名称 4.截面类型名称")
   private Integer productSectionNameEnum;

   public static MesSectionWarehouseConfigDTO.MesSectionWarehouseConfigDTOBuilder builder() {
      return new MesSectionWarehouseConfigDTO.MesSectionWarehouseConfigDTOBuilder();
   }

   public MesSectionWarehouseConfigDTO() {
   }

   public MesSectionWarehouseConfigDTO(
      final Long id,
      final List<MesSectionWarehouseConfigDetailDTO> sectionWarehouseConfigDTOList,
      final Integer productType,
      final Integer productClassificationEnum,
      final Integer productSectionNameEnum
   ) {
      this.id = id;
      this.sectionWarehouseConfigDTOList = sectionWarehouseConfigDTOList;
      this.productType = productType;
      this.productClassificationEnum = productClassificationEnum;
      this.productSectionNameEnum = productSectionNameEnum;
   }

   public Long getId() {
      return this.id;
   }

   public List<MesSectionWarehouseConfigDetailDTO> getSectionWarehouseConfigDTOList() {
      return this.sectionWarehouseConfigDTOList;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public Integer getProductSectionNameEnum() {
      return this.productSectionNameEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSectionWarehouseConfigDTOList(final List<MesSectionWarehouseConfigDetailDTO> sectionWarehouseConfigDTOList) {
      this.sectionWarehouseConfigDTOList = sectionWarehouseConfigDTOList;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
   }

   public void setProductSectionNameEnum(final Integer productSectionNameEnum) {
      this.productSectionNameEnum = productSectionNameEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesSectionWarehouseConfigDTO)) {
         return false;
      }

      MesSectionWarehouseConfigDTO other = (MesSectionWarehouseConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$productClassificationEnum = this.getProductClassificationEnum();
            Object other$productClassificationEnum = other.getProductClassificationEnum();
            if (this$productClassificationEnum == null
               ? other$productClassificationEnum == null
               : this$productClassificationEnum.equals(other$productClassificationEnum)) {
               Object this$productSectionNameEnum = this.getProductSectionNameEnum();
               Object other$productSectionNameEnum = other.getProductSectionNameEnum();
               if (this$productSectionNameEnum == null
                  ? other$productSectionNameEnum == null
                  : this$productSectionNameEnum.equals(other$productSectionNameEnum)) {
                  Object this$sectionWarehouseConfigDTOList = this.getSectionWarehouseConfigDTOList();
                  Object other$sectionWarehouseConfigDTOList = other.getSectionWarehouseConfigDTOList();
                  return this$sectionWarehouseConfigDTOList == null
                     ? other$sectionWarehouseConfigDTOList == null
                     : this$sectionWarehouseConfigDTOList.equals(other$sectionWarehouseConfigDTOList);
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
      return other instanceof MesSectionWarehouseConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $productSectionNameEnum = this.getProductSectionNameEnum();
      result = result * 59 + ($productSectionNameEnum == null ? 43 : $productSectionNameEnum.hashCode());
      Object $sectionWarehouseConfigDTOList = this.getSectionWarehouseConfigDTOList();
      return result * 59 + ($sectionWarehouseConfigDTOList == null ? 43 : $sectionWarehouseConfigDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "MesSectionWarehouseConfigDTO(id="
         + this.getId()
         + ", sectionWarehouseConfigDTOList="
         + this.getSectionWarehouseConfigDTOList()
         + ", productType="
         + this.getProductType()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", productSectionNameEnum="
         + this.getProductSectionNameEnum()
         + ")";
   }

   public static class MesSectionWarehouseConfigDTOBuilder {
      private Long id;
      private List<MesSectionWarehouseConfigDetailDTO> sectionWarehouseConfigDTOList;
      private Integer productType;
      private Integer productClassificationEnum;
      private Integer productSectionNameEnum;

      MesSectionWarehouseConfigDTOBuilder() {
      }

      public MesSectionWarehouseConfigDTO.MesSectionWarehouseConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesSectionWarehouseConfigDTO.MesSectionWarehouseConfigDTOBuilder sectionWarehouseConfigDTOList(
         final List<MesSectionWarehouseConfigDetailDTO> sectionWarehouseConfigDTOList
      ) {
         this.sectionWarehouseConfigDTOList = sectionWarehouseConfigDTOList;
         return this;
      }

      public MesSectionWarehouseConfigDTO.MesSectionWarehouseConfigDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public MesSectionWarehouseConfigDTO.MesSectionWarehouseConfigDTOBuilder productClassificationEnum(final Integer productClassificationEnum) {
         this.productClassificationEnum = productClassificationEnum;
         return this;
      }

      public MesSectionWarehouseConfigDTO.MesSectionWarehouseConfigDTOBuilder productSectionNameEnum(final Integer productSectionNameEnum) {
         this.productSectionNameEnum = productSectionNameEnum;
         return this;
      }

      public MesSectionWarehouseConfigDTO build() {
         return new MesSectionWarehouseConfigDTO(
            this.id, this.sectionWarehouseConfigDTOList, this.productType, this.productClassificationEnum, this.productSectionNameEnum
         );
      }

      @Override
      public String toString() {
         return "MesSectionWarehouseConfigDTO.MesSectionWarehouseConfigDTOBuilder(id="
            + this.id
            + ", sectionWarehouseConfigDTOList="
            + this.sectionWarehouseConfigDTOList
            + ", productType="
            + this.productType
            + ", productClassificationEnum="
            + this.productClassificationEnum
            + ", productSectionNameEnum="
            + this.productSectionNameEnum
            + ")";
      }
   }
}
