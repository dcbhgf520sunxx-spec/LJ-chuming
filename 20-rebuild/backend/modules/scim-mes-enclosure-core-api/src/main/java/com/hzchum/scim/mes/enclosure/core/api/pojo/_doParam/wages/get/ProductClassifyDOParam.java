package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.wages.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProductClassifDTOParam", description = "")
public class ProductClassifyDOParam {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "planId", notes = "区域id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   private Long planId;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "category", notes = "围护类型")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;

   public static ProductClassifyDOParam.ProductClassifyDOParamBuilder builder() {
      return new ProductClassifyDOParam.ProductClassifyDOParamBuilder();
   }

   public ProductClassifyDOParam(
      final Long projectId, final Long monomerId, final Long planId, final String name, final Integer productType, final Integer category
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.planId = planId;
      this.name = name;
      this.productType = productType;
      this.category = category;
   }

   public ProductClassifyDOParam() {
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   @JsonProperty("projectId")
   public ProductClassifyDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public ProductClassifyDOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("planId")
   public ProductClassifyDOParam setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("name")
   public ProductClassifyDOParam setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("productType")
   public ProductClassifyDOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("category")
   public ProductClassifyDOParam setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @Override
   public String toString() {
      return "ProductClassifyDOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", planId="
         + this.getPlanId()
         + ", name="
         + this.getName()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductClassifyDOParam)) {
         return false;
      }

      ProductClassifyDOParam other = (ProductClassifyDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$planId = this.getPlanId();
            Object other$planId = other.getPlanId();
            if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$category = this.getCategory();
                  Object other$category = other.getCategory();
                  if (this$category == null ? other$category == null : this$category.equals(other$category)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductClassifyDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class ProductClassifyDOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Long planId;
      private String name;
      private Integer productType;
      private Integer category;

      ProductClassifyDOParamBuilder() {
      }

      @JsonProperty("projectId")
      public ProductClassifyDOParam.ProductClassifyDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public ProductClassifyDOParam.ProductClassifyDOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("planId")
      public ProductClassifyDOParam.ProductClassifyDOParamBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("name")
      public ProductClassifyDOParam.ProductClassifyDOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("productType")
      public ProductClassifyDOParam.ProductClassifyDOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("category")
      public ProductClassifyDOParam.ProductClassifyDOParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public ProductClassifyDOParam build() {
         return new ProductClassifyDOParam(this.projectId, this.monomerId, this.planId, this.name, this.productType, this.category);
      }

      @Override
      public String toString() {
         return "ProductClassifyDOParam.ProductClassifyDOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", planId="
            + this.planId
            + ", name="
            + this.name
            + ", productType="
            + this.productType
            + ", category="
            + this.category
            + ")";
      }
   }
}
