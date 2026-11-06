package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ArtifactKanbanDOParam", description = "产品看板")
public class ProductKanbanDOParam {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "status", notes = "产品状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "planId", notes = "区域id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   private Long planId;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "category", notes = "围护类型")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "plate", notes = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   private String plate;
   @ApiModelProperty(name = "color", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   private String color;
   @ApiModelProperty(name = "productProcessIds", notes = "总工序id")
   @JsonProperty("productProcessIds")
   @JSONField(name = "productProcessIds")
   private List<Long> productProcessIds;
   @ApiModelProperty("钢材厚度/规格")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String steelSpec;

   public static ProductKanbanDOParam.ProductKanbanDOParamBuilder builder() {
      return new ProductKanbanDOParam.ProductKanbanDOParamBuilder();
   }

   public ProductKanbanDOParam() {
   }

   public ProductKanbanDOParam(
      final Long projectId,
      final Integer status,
      final Long monomerId,
      final Long planId,
      final Long factoryId,
      final Integer productType,
      final Integer category,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final String plate,
      final String color,
      final List<Long> productProcessIds,
      final String steelSpec
   ) {
      this.projectId = projectId;
      this.status = status;
      this.monomerId = monomerId;
      this.planId = planId;
      this.factoryId = factoryId;
      this.productType = productType;
      this.category = category;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.plate = plate;
      this.color = color;
      this.productProcessIds = productProcessIds;
      this.steelSpec = steelSpec;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getPlate() {
      return this.plate;
   }

   public String getColor() {
      return this.color;
   }

   public List<Long> getProductProcessIds() {
      return this.productProcessIds;
   }

   public String getSteelSpec() {
      return this.steelSpec;
   }

   @JsonProperty("projectId")
   public ProductKanbanDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("status")
   public ProductKanbanDOParam setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("monomerId")
   public ProductKanbanDOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("planId")
   public ProductKanbanDOParam setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("factoryId")
   public ProductKanbanDOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("productType")
   public ProductKanbanDOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("category")
   public ProductKanbanDOParam setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("name")
   public ProductKanbanDOParam setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProductKanbanDOParam setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public ProductKanbanDOParam setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public ProductKanbanDOParam setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("plate")
   public ProductKanbanDOParam setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public ProductKanbanDOParam setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("productProcessIds")
   public ProductKanbanDOParam setProductProcessIds(final List<Long> productProcessIds) {
      this.productProcessIds = productProcessIds;
      return this;
   }

   @JsonProperty("name")
   public ProductKanbanDOParam setSteelSpec(final String steelSpec) {
      this.steelSpec = steelSpec;
      return this;
   }

   @Override
   public String toString() {
      return "ProductKanbanDOParam(projectId="
         + this.getProjectId()
         + ", status="
         + this.getStatus()
         + ", monomerId="
         + this.getMonomerId()
         + ", planId="
         + this.getPlanId()
         + ", factoryId="
         + this.getFactoryId()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", productProcessIds="
         + this.getProductProcessIds()
         + ", steelSpec="
         + this.getSteelSpec()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductKanbanDOParam)) {
         return false;
      }

      ProductKanbanDOParam other = (ProductKanbanDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$planId = this.getPlanId();
               Object other$planId = other.getPlanId();
               if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                  Object this$factoryId = this.getFactoryId();
                  Object other$factoryId = other.getFactoryId();
                  if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$category = this.getCategory();
                        Object other$category = other.getCategory();
                        if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$specification = this.getSpecification();
                                 Object other$specification = other.getSpecification();
                                 if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                    Object this$material = this.getMaterial();
                                    Object other$material = other.getMaterial();
                                    if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                       Object this$plate = this.getPlate();
                                       Object other$plate = other.getPlate();
                                       if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                          Object this$color = this.getColor();
                                          Object other$color = other.getColor();
                                          if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                             Object this$productProcessIds = this.getProductProcessIds();
                                             Object other$productProcessIds = other.getProductProcessIds();
                                             if (this$productProcessIds == null
                                                ? other$productProcessIds == null
                                                : this$productProcessIds.equals(other$productProcessIds)) {
                                                Object this$steelSpec = this.getSteelSpec();
                                                Object other$steelSpec = other.getSteelSpec();
                                                return this$steelSpec == null ? other$steelSpec == null : this$steelSpec.equals(other$steelSpec);
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
      return other instanceof ProductKanbanDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $productProcessIds = this.getProductProcessIds();
      result = result * 59 + ($productProcessIds == null ? 43 : $productProcessIds.hashCode());
      Object $steelSpec = this.getSteelSpec();
      return result * 59 + ($steelSpec == null ? 43 : $steelSpec.hashCode());
   }

   public static class ProductKanbanDOParamBuilder {
      private Long projectId;
      private Integer status;
      private Long monomerId;
      private Long planId;
      private Long factoryId;
      private Integer productType;
      private Integer category;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private String plate;
      private String color;
      private List<Long> productProcessIds;
      private String steelSpec;

      ProductKanbanDOParamBuilder() {
      }

      @JsonProperty("projectId")
      public ProductKanbanDOParam.ProductKanbanDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("status")
      public ProductKanbanDOParam.ProductKanbanDOParamBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("monomerId")
      public ProductKanbanDOParam.ProductKanbanDOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("planId")
      public ProductKanbanDOParam.ProductKanbanDOParamBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("factoryId")
      public ProductKanbanDOParam.ProductKanbanDOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("productType")
      public ProductKanbanDOParam.ProductKanbanDOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("category")
      public ProductKanbanDOParam.ProductKanbanDOParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("name")
      public ProductKanbanDOParam.ProductKanbanDOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProductKanbanDOParam.ProductKanbanDOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ProductKanbanDOParam.ProductKanbanDOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public ProductKanbanDOParam.ProductKanbanDOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("plate")
      public ProductKanbanDOParam.ProductKanbanDOParamBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public ProductKanbanDOParam.ProductKanbanDOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("productProcessIds")
      public ProductKanbanDOParam.ProductKanbanDOParamBuilder productProcessIds(final List<Long> productProcessIds) {
         this.productProcessIds = productProcessIds;
         return this;
      }

      @JsonProperty("name")
      public ProductKanbanDOParam.ProductKanbanDOParamBuilder steelSpec(final String steelSpec) {
         this.steelSpec = steelSpec;
         return this;
      }

      public ProductKanbanDOParam build() {
         return new ProductKanbanDOParam(
            this.projectId,
            this.status,
            this.monomerId,
            this.planId,
            this.factoryId,
            this.productType,
            this.category,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.plate,
            this.color,
            this.productProcessIds,
            this.steelSpec
         );
      }

      @Override
      public String toString() {
         return "ProductKanbanDOParam.ProductKanbanDOParamBuilder(projectId="
            + this.projectId
            + ", status="
            + this.status
            + ", monomerId="
            + this.monomerId
            + ", planId="
            + this.planId
            + ", factoryId="
            + this.factoryId
            + ", productType="
            + this.productType
            + ", category="
            + this.category
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", plate="
            + this.plate
            + ", color="
            + this.color
            + ", productProcessIds="
            + this.productProcessIds
            + ", steelSpec="
            + this.steelSpec
            + ")";
      }
   }
}
