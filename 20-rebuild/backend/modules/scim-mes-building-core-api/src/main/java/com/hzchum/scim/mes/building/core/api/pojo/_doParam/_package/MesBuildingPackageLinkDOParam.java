package com.hzchum.scim.mes.building.core.api.pojo._doParam._package;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingPackageLink对象", description = "包的产品关联表 ")
public class MesBuildingPackageLinkDOParam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "packageId", value = "包id")
   @JsonProperty("packageId")
   @JSONField(name = "packageId")
   private Long packageId;
   @ApiModelProperty(name = "productType", value = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Long productType;
   @ApiModelProperty(name = "productId", value = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @NotNull(message = "产品id不能为空")
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Long quantity;
   @ApiModelProperty(name = "warehouseRecordId", value = "出入库id")
   @JsonProperty("warehouseRecordId")
   @JSONField(name = "warehouseRecordId")
   private Long warehouseRecordId;

   public static MesBuildingPackageLinkDOParam.MesBuildingPackageLinkDOParamBuilder builder() {
      return new MesBuildingPackageLinkDOParam.MesBuildingPackageLinkDOParamBuilder();
   }

   public MesBuildingPackageLinkDOParam() {
   }

   public MesBuildingPackageLinkDOParam(
      final Long id, final Long packageId, final Long productType, final Long productId, final Long quantity, final Long warehouseRecordId
   ) {
      this.id = id;
      this.packageId = packageId;
      this.productType = productType;
      this.productId = productId;
      this.quantity = quantity;
      this.warehouseRecordId = warehouseRecordId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getPackageId() {
      return this.packageId;
   }

   public Long getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getQuantity() {
      return this.quantity;
   }

   public Long getWarehouseRecordId() {
      return this.warehouseRecordId;
   }

   @JsonProperty("id")
   public MesBuildingPackageLinkDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("packageId")
   public MesBuildingPackageLinkDOParam setPackageId(final Long packageId) {
      this.packageId = packageId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingPackageLinkDOParam setProductType(final Long productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingPackageLinkDOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingPackageLinkDOParam setQuantity(final Long quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("warehouseRecordId")
   public MesBuildingPackageLinkDOParam setWarehouseRecordId(final Long warehouseRecordId) {
      this.warehouseRecordId = warehouseRecordId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingPackageLinkDOParam(id="
         + this.getId()
         + ", packageId="
         + this.getPackageId()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", warehouseRecordId="
         + this.getWarehouseRecordId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPackageLinkDOParam)) {
         return false;
      }

      MesBuildingPackageLinkDOParam other = (MesBuildingPackageLinkDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$packageId = this.getPackageId();
         Object other$packageId = other.getPackageId();
         if (this$packageId == null ? other$packageId == null : this$packageId.equals(other$packageId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$productId = this.getProductId();
               Object other$productId = other.getProductId();
               if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$warehouseRecordId = this.getWarehouseRecordId();
                     Object other$warehouseRecordId = other.getWarehouseRecordId();
                     return this$warehouseRecordId == null ? other$warehouseRecordId == null : this$warehouseRecordId.equals(other$warehouseRecordId);
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
      return other instanceof MesBuildingPackageLinkDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $packageId = this.getPackageId();
      result = result * 59 + ($packageId == null ? 43 : $packageId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $warehouseRecordId = this.getWarehouseRecordId();
      return result * 59 + ($warehouseRecordId == null ? 43 : $warehouseRecordId.hashCode());
   }

   public static class MesBuildingPackageLinkDOParamBuilder {
      private Long id;
      private Long packageId;
      private Long productType;
      private Long productId;
      private Long quantity;
      private Long warehouseRecordId;

      MesBuildingPackageLinkDOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingPackageLinkDOParam.MesBuildingPackageLinkDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("packageId")
      public MesBuildingPackageLinkDOParam.MesBuildingPackageLinkDOParamBuilder packageId(final Long packageId) {
         this.packageId = packageId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingPackageLinkDOParam.MesBuildingPackageLinkDOParamBuilder productType(final Long productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingPackageLinkDOParam.MesBuildingPackageLinkDOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingPackageLinkDOParam.MesBuildingPackageLinkDOParamBuilder quantity(final Long quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("warehouseRecordId")
      public MesBuildingPackageLinkDOParam.MesBuildingPackageLinkDOParamBuilder warehouseRecordId(final Long warehouseRecordId) {
         this.warehouseRecordId = warehouseRecordId;
         return this;
      }

      public MesBuildingPackageLinkDOParam build() {
         return new MesBuildingPackageLinkDOParam(this.id, this.packageId, this.productType, this.productId, this.quantity, this.warehouseRecordId);
      }

      @Override
      public String toString() {
         return "MesBuildingPackageLinkDOParam.MesBuildingPackageLinkDOParamBuilder(id="
            + this.id
            + ", packageId="
            + this.packageId
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", warehouseRecordId="
            + this.warehouseRecordId
            + ")";
      }
   }
}
