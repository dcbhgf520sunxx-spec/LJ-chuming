package com.hzchum.scim.rest.pojo.vo.mes.building.request.wages.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProductRequest", description = "")
public class ProductRequest {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "steelSpec", notes = "板厚或规格", value = "板厚或规格")
   @JsonProperty("steelSpec")
   @JSONField(name = "steelSpec")
   private String steelSpec;
   @ApiModelProperty(name = "steelId", notes = "版型id", value = "版型id")
   @JsonProperty("steelId")
   @JSONField(name = "steelId")
   private Integer steelId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @NotNull(message = "产品类型不能为空")
   private Integer productType;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "category", notes = "围护类型")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private Integer serialNumber;

   public static ProductRequest.ProductRequestBuilder builder() {
      return new ProductRequest.ProductRequestBuilder();
   }

   public ProductRequest(
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final String name,
      final String steelSpec,
      final Integer steelId,
      final Integer productType,
      final String material,
      final Integer category,
      final Integer serialNumber
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.name = name;
      this.steelSpec = steelSpec;
      this.steelId = steelId;
      this.productType = productType;
      this.material = material;
      this.category = category;
      this.serialNumber = serialNumber;
   }

   public ProductRequest() {
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getName() {
      return this.name;
   }

   public String getSteelSpec() {
      return this.steelSpec;
   }

   public Integer getSteelId() {
      return this.steelId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Integer getSerialNumber() {
      return this.serialNumber;
   }

   @JsonProperty("projectId")
   public ProductRequest setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public ProductRequest setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public ProductRequest setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("name")
   public ProductRequest setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("steelSpec")
   public ProductRequest setSteelSpec(final String steelSpec) {
      this.steelSpec = steelSpec;
      return this;
   }

   @JsonProperty("steelId")
   public ProductRequest setSteelId(final Integer steelId) {
      this.steelId = steelId;
      return this;
   }

   @JsonProperty("productType")
   public ProductRequest setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("material")
   public ProductRequest setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("category")
   public ProductRequest setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProductRequest setSerialNumber(final Integer serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @Override
   public String toString() {
      return "ProductRequest(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", name="
         + this.getName()
         + ", steelSpec="
         + this.getSteelSpec()
         + ", steelId="
         + this.getSteelId()
         + ", productType="
         + this.getProductType()
         + ", material="
         + this.getMaterial()
         + ", category="
         + this.getCategory()
         + ", serialNumber="
         + this.getSerialNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductRequest)) {
         return false;
      }

      ProductRequest other = (ProductRequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$steelId = this.getSteelId();
               Object other$steelId = other.getSteelId();
               if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
                  Object this$productType = this.getProductType();
                  Object other$productType = other.getProductType();
                  if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                     Object this$category = this.getCategory();
                     Object other$category = other.getCategory();
                     if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$steelSpec = this.getSteelSpec();
                              Object other$steelSpec = other.getSteelSpec();
                              if (this$steelSpec == null ? other$steelSpec == null : this$steelSpec.equals(other$steelSpec)) {
                                 Object this$material = this.getMaterial();
                                 Object other$material = other.getMaterial();
                                 return this$material == null ? other$material == null : this$material.equals(other$material);
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
      return other instanceof ProductRequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $steelSpec = this.getSteelSpec();
      result = result * 59 + ($steelSpec == null ? 43 : $steelSpec.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   public static class ProductRequestBuilder {
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private String name;
      private String steelSpec;
      private Integer steelId;
      private Integer productType;
      private String material;
      private Integer category;
      private Integer serialNumber;

      ProductRequestBuilder() {
      }

      @JsonProperty("projectId")
      public ProductRequest.ProductRequestBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public ProductRequest.ProductRequestBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public ProductRequest.ProductRequestBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("name")
      public ProductRequest.ProductRequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("steelSpec")
      public ProductRequest.ProductRequestBuilder steelSpec(final String steelSpec) {
         this.steelSpec = steelSpec;
         return this;
      }

      @JsonProperty("steelId")
      public ProductRequest.ProductRequestBuilder steelId(final Integer steelId) {
         this.steelId = steelId;
         return this;
      }

      @JsonProperty("productType")
      public ProductRequest.ProductRequestBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("material")
      public ProductRequest.ProductRequestBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("category")
      public ProductRequest.ProductRequestBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProductRequest.ProductRequestBuilder serialNumber(final Integer serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProductRequest build() {
         return new ProductRequest(
            this.projectId,
            this.monomerId,
            this.areaId,
            this.name,
            this.steelSpec,
            this.steelId,
            this.productType,
            this.material,
            this.category,
            this.serialNumber
         );
      }

      @Override
      public String toString() {
         return "ProductRequest.ProductRequestBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", name="
            + this.name
            + ", steelSpec="
            + this.steelSpec
            + ", steelId="
            + this.steelId
            + ", productType="
            + this.productType
            + ", material="
            + this.material
            + ", category="
            + this.category
            + ", serialNumber="
            + this.serialNumber
            + ")";
      }
   }
}
