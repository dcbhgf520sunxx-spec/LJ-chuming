package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.process.productProcess.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProductProcessListVORequest", description = "")
public class ProductProcessListVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "总工序名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "alias", notes = "别名")
   @JsonProperty("alias")
   @JSONField(name = "alias")
   private String alias;
   @ApiModelProperty(name = "productType", notes = "产品类型 [0 零件,1 构件,2 围护]")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "boolEnabledEnum", notes = "禁用状态 [0 禁用, 1 启用]")
   @JsonProperty("boolEnabledEnum")
   @JSONField(name = "boolEnabledEnum")
   private Boolean boolEnabledEnum;
   @ApiModelProperty(name = "sort", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;

   public static ProductProcessListVORequest.ProductProcessListVORequestBuilder builder() {
      return new ProductProcessListVORequest.ProductProcessListVORequestBuilder();
   }

   public ProductProcessListVORequest() {
   }

   public ProductProcessListVORequest(
      final Long id, final String name, final String alias, final Integer productType, final Boolean boolEnabledEnum, final Integer sort
   ) {
      this.id = id;
      this.name = name;
      this.alias = alias;
      this.productType = productType;
      this.boolEnabledEnum = boolEnabledEnum;
      this.sort = sort;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getAlias() {
      return this.alias;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Boolean getBoolEnabledEnum() {
      return this.boolEnabledEnum;
   }

   public Integer getSort() {
      return this.sort;
   }

   @JsonProperty("id")
   public ProductProcessListVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ProductProcessListVORequest setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("alias")
   public ProductProcessListVORequest setAlias(final String alias) {
      this.alias = alias;
      return this;
   }

   @JsonProperty("productType")
   public ProductProcessListVORequest setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public ProductProcessListVORequest setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @JsonProperty("sort")
   public ProductProcessListVORequest setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "ProductProcessListVORequest(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", alias="
         + this.getAlias()
         + ", productType="
         + this.getProductType()
         + ", boolEnabledEnum="
         + this.getBoolEnabledEnum()
         + ", sort="
         + this.getSort()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductProcessListVORequest)) {
         return false;
      }

      ProductProcessListVORequest other = (ProductProcessListVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$boolEnabledEnum = this.getBoolEnabledEnum();
            Object other$boolEnabledEnum = other.getBoolEnabledEnum();
            if (this$boolEnabledEnum == null ? other$boolEnabledEnum == null : this$boolEnabledEnum.equals(other$boolEnabledEnum)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$alias = this.getAlias();
                     Object other$alias = other.getAlias();
                     return this$alias == null ? other$alias == null : this$alias.equals(other$alias);
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
      return other instanceof ProductProcessListVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      result = result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $alias = this.getAlias();
      return result * 59 + ($alias == null ? 43 : $alias.hashCode());
   }

   public static class ProductProcessListVORequestBuilder {
      private Long id;
      private String name;
      private String alias;
      private Integer productType;
      private Boolean boolEnabledEnum;
      private Integer sort;

      ProductProcessListVORequestBuilder() {
      }

      @JsonProperty("id")
      public ProductProcessListVORequest.ProductProcessListVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ProductProcessListVORequest.ProductProcessListVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("alias")
      public ProductProcessListVORequest.ProductProcessListVORequestBuilder alias(final String alias) {
         this.alias = alias;
         return this;
      }

      @JsonProperty("productType")
      public ProductProcessListVORequest.ProductProcessListVORequestBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public ProductProcessListVORequest.ProductProcessListVORequestBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      @JsonProperty("sort")
      public ProductProcessListVORequest.ProductProcessListVORequestBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public ProductProcessListVORequest build() {
         return new ProductProcessListVORequest(this.id, this.name, this.alias, this.productType, this.boolEnabledEnum, this.sort);
      }

      @Override
      public String toString() {
         return "ProductProcessListVORequest.ProductProcessListVORequestBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", alias="
            + this.alias
            + ", productType="
            + this.productType
            + ", boolEnabledEnum="
            + this.boolEnabledEnum
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
