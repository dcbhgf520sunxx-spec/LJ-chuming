package com.hzchum.scim.mes.enclosure.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProductionLineDO", description = "工厂信息")
public class ProductionLineDetailDO {
   @ApiModelProperty(name = "id", notes = "生产线id", value = "生产线id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "生产线名", value = "生产线名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "productType", notes = "产品类型", value = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;

   public static ProductionLineDetailDO.ProductionLineDetailDOBuilder builder() {
      return new ProductionLineDetailDO.ProductionLineDetailDOBuilder();
   }

   public ProductionLineDetailDO() {
   }

   public ProductionLineDetailDO(final Long id, final String name, final Integer productType) {
      this.id = id;
      this.name = name;
      this.productType = productType;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProductType() {
      return this.productType;
   }

   @JsonProperty("id")
   public ProductionLineDetailDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ProductionLineDetailDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("productType")
   public ProductionLineDetailDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @Override
   public String toString() {
      return "ProductionLineDetailDO(id=" + this.getId() + ", name=" + this.getName() + ", productType=" + this.getProductType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionLineDetailDO)) {
         return false;
      }

      ProductionLineDetailDO other = (ProductionLineDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
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
      return other instanceof ProductionLineDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class ProductionLineDetailDOBuilder {
      private Long id;
      private String name;
      private Integer productType;

      ProductionLineDetailDOBuilder() {
      }

      @JsonProperty("id")
      public ProductionLineDetailDO.ProductionLineDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ProductionLineDetailDO.ProductionLineDetailDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("productType")
      public ProductionLineDetailDO.ProductionLineDetailDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProductionLineDetailDO build() {
         return new ProductionLineDetailDO(this.id, this.name, this.productType);
      }

      @Override
      public String toString() {
         return "ProductionLineDetailDO.ProductionLineDetailDOBuilder(id=" + this.id + ", name=" + this.name + ", productType=" + this.productType + ")";
      }
   }
}
