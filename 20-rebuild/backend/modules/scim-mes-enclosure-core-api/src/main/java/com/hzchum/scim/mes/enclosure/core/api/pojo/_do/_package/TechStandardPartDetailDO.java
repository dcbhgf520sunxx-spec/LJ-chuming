package com.hzchum.scim.mes.enclosure.core.api.pojo._do._package;

import com.hzchum.scim.common.core.api.pojo.common.TechStandardPartBaseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("辅材发运")
public class TechStandardPartDetailDO extends TechStandardPartBaseInfo {
   @ApiModelProperty(name = "id", notes = "出入库id")
   private Long id;
   @ApiModelProperty(notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "inQuantity", notes = "入库数量")
   private Integer inQuantity;
   @ApiModelProperty(name = "packageQuantity", value = "打包数量")
   private Integer packageQuantity;
   @ApiModelProperty(name = "unPackageQuantity", value = "可使用数量")
   private Integer unPackageQuantity;
   @ApiModelProperty(notes = "产品类型")
   private Integer productType;

   public static TechStandardPartDetailDO.TechStandardPartDetailDOBuilder builder() {
      return new TechStandardPartDetailDO.TechStandardPartDetailDOBuilder();
   }

   public TechStandardPartDetailDO() {
   }

   public TechStandardPartDetailDO(
      final Long id, final Long productId, final Integer inQuantity, final Integer packageQuantity, final Integer unPackageQuantity, final Integer productType
   ) {
      this.id = id;
      this.productId = productId;
      this.inQuantity = inQuantity;
      this.packageQuantity = packageQuantity;
      this.unPackageQuantity = unPackageQuantity;
      this.productType = productType;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getInQuantity() {
      return this.inQuantity;
   }

   public Integer getPackageQuantity() {
      return this.packageQuantity;
   }

   public Integer getUnPackageQuantity() {
      return this.unPackageQuantity;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public TechStandardPartDetailDO setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechStandardPartDetailDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public TechStandardPartDetailDO setInQuantity(final Integer inQuantity) {
      this.inQuantity = inQuantity;
      return this;
   }

   public TechStandardPartDetailDO setPackageQuantity(final Integer packageQuantity) {
      this.packageQuantity = packageQuantity;
      return this;
   }

   public TechStandardPartDetailDO setUnPackageQuantity(final Integer unPackageQuantity) {
      this.unPackageQuantity = unPackageQuantity;
      return this;
   }

   public TechStandardPartDetailDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @Override
   public String toString() {
      return "TechStandardPartDetailDO(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", inQuantity="
         + this.getInQuantity()
         + ", packageQuantity="
         + this.getPackageQuantity()
         + ", unPackageQuantity="
         + this.getUnPackageQuantity()
         + ", productType="
         + this.getProductType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechStandardPartDetailDO)) {
         return false;
      }

      TechStandardPartDetailDO other = (TechStandardPartDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$inQuantity = this.getInQuantity();
            Object other$inQuantity = other.getInQuantity();
            if (this$inQuantity == null ? other$inQuantity == null : this$inQuantity.equals(other$inQuantity)) {
               Object this$packageQuantity = this.getPackageQuantity();
               Object other$packageQuantity = other.getPackageQuantity();
               if (this$packageQuantity == null ? other$packageQuantity == null : this$packageQuantity.equals(other$packageQuantity)) {
                  Object this$unPackageQuantity = this.getUnPackageQuantity();
                  Object other$unPackageQuantity = other.getUnPackageQuantity();
                  if (this$unPackageQuantity == null ? other$unPackageQuantity == null : this$unPackageQuantity.equals(other$unPackageQuantity)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     return this$productType == null ? other$productType == null : this$productType.equals(other$productType);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechStandardPartDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $inQuantity = this.getInQuantity();
      result = result * 59 + ($inQuantity == null ? 43 : $inQuantity.hashCode());
      Object $packageQuantity = this.getPackageQuantity();
      result = result * 59 + ($packageQuantity == null ? 43 : $packageQuantity.hashCode());
      Object $unPackageQuantity = this.getUnPackageQuantity();
      result = result * 59 + ($unPackageQuantity == null ? 43 : $unPackageQuantity.hashCode());
      Object $productType = this.getProductType();
      return result * 59 + ($productType == null ? 43 : $productType.hashCode());
   }

   public static class TechStandardPartDetailDOBuilder {
      private Long id;
      private Long productId;
      private Integer inQuantity;
      private Integer packageQuantity;
      private Integer unPackageQuantity;
      private Integer productType;

      TechStandardPartDetailDOBuilder() {
      }

      public TechStandardPartDetailDO.TechStandardPartDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechStandardPartDetailDO.TechStandardPartDetailDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public TechStandardPartDetailDO.TechStandardPartDetailDOBuilder inQuantity(final Integer inQuantity) {
         this.inQuantity = inQuantity;
         return this;
      }

      public TechStandardPartDetailDO.TechStandardPartDetailDOBuilder packageQuantity(final Integer packageQuantity) {
         this.packageQuantity = packageQuantity;
         return this;
      }

      public TechStandardPartDetailDO.TechStandardPartDetailDOBuilder unPackageQuantity(final Integer unPackageQuantity) {
         this.unPackageQuantity = unPackageQuantity;
         return this;
      }

      public TechStandardPartDetailDO.TechStandardPartDetailDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public TechStandardPartDetailDO build() {
         return new TechStandardPartDetailDO(this.id, this.productId, this.inQuantity, this.packageQuantity, this.unPackageQuantity, this.productType);
      }

      @Override
      public String toString() {
         return "TechStandardPartDetailDO.TechStandardPartDetailDOBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", inQuantity="
            + this.inQuantity
            + ", packageQuantity="
            + this.packageQuantity
            + ", unPackageQuantity="
            + this.unPackageQuantity
            + ", productType="
            + this.productType
            + ")";
      }
   }
}
