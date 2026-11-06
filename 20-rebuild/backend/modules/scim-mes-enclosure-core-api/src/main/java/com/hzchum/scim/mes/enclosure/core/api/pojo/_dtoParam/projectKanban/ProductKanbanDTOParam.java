package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProjectSummaryDTOParam", description = "项目状态查询")
public class ProductKanbanDTOParam {
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
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "category", notes = "围护类型")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
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
   @ApiModelProperty("钢材厚度/规格")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String steelSpec;
   @ApiModelProperty(name = "structureClassId", notes = "构件种类Id")
   @JsonProperty("structureClassId")
   @JSONField(name = "structureClassId")
   private Long structureClassId;

   public static ProductKanbanDTOParam.ProductKanbanDTOParamBuilder builder() {
      return new ProductKanbanDTOParam.ProductKanbanDTOParamBuilder();
   }

   public ProductKanbanDTOParam() {
   }

   public ProductKanbanDTOParam(
      final Long projectId,
      final Integer status,
      final Long monomerId,
      final Long planId,
      final Long factoryId,
      final Long processId,
      final Integer productType,
      final String name,
      final String serialNumber,
      final Integer category,
      final String specification,
      final String material,
      final String plate,
      final String color,
      final String steelSpec,
      final Long structureClassId
   ) {
      this.projectId = projectId;
      this.status = status;
      this.monomerId = monomerId;
      this.planId = planId;
      this.factoryId = factoryId;
      this.processId = processId;
      this.productType = productType;
      this.name = name;
      this.serialNumber = serialNumber;
      this.category = category;
      this.specification = specification;
      this.material = material;
      this.plate = plate;
      this.color = color;
      this.steelSpec = steelSpec;
      this.structureClassId = structureClassId;
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

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getCategory() {
      return this.category;
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

   public String getSteelSpec() {
      return this.steelSpec;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   @JsonProperty("projectId")
   public ProductKanbanDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("status")
   public ProductKanbanDTOParam setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("monomerId")
   public ProductKanbanDTOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("planId")
   public ProductKanbanDTOParam setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("factoryId")
   public ProductKanbanDTOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("processId")
   public ProductKanbanDTOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("productType")
   public ProductKanbanDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("name")
   public ProductKanbanDTOParam setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProductKanbanDTOParam setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("category")
   public ProductKanbanDTOParam setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("specification")
   public ProductKanbanDTOParam setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public ProductKanbanDTOParam setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("plate")
   public ProductKanbanDTOParam setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public ProductKanbanDTOParam setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("name")
   public ProductKanbanDTOParam setSteelSpec(final String steelSpec) {
      this.steelSpec = steelSpec;
      return this;
   }

   @JsonProperty("structureClassId")
   public ProductKanbanDTOParam setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
      return this;
   }

   @Override
   public String toString() {
      return "ProductKanbanDTOParam(projectId="
         + this.getProjectId()
         + ", status="
         + this.getStatus()
         + ", monomerId="
         + this.getMonomerId()
         + ", planId="
         + this.getPlanId()
         + ", factoryId="
         + this.getFactoryId()
         + ", processId="
         + this.getProcessId()
         + ", productType="
         + this.getProductType()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", category="
         + this.getCategory()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", steelSpec="
         + this.getSteelSpec()
         + ", structureClassId="
         + this.getStructureClassId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductKanbanDTOParam)) {
         return false;
      }

      ProductKanbanDTOParam other = (ProductKanbanDTOParam)o;
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
                     Object this$processId = this.getProcessId();
                     Object other$processId = other.getProcessId();
                     if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                        Object this$productType = this.getProductType();
                        Object other$productType = other.getProductType();
                        if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                           Object this$category = this.getCategory();
                           Object other$category = other.getCategory();
                           if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                              Object this$structureClassId = this.getStructureClassId();
                              Object other$structureClassId = other.getStructureClassId();
                              if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductKanbanDTOParam;
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
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
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
      Object $steelSpec = this.getSteelSpec();
      return result * 59 + ($steelSpec == null ? 43 : $steelSpec.hashCode());
   }

   public static class ProductKanbanDTOParamBuilder {
      private Long projectId;
      private Integer status;
      private Long monomerId;
      private Long planId;
      private Long factoryId;
      private Long processId;
      private Integer productType;
      private String name;
      private String serialNumber;
      private Integer category;
      private String specification;
      private String material;
      private String plate;
      private String color;
      private String steelSpec;
      private Long structureClassId;

      ProductKanbanDTOParamBuilder() {
      }

      @JsonProperty("projectId")
      public ProductKanbanDTOParam.ProductKanbanDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("status")
      public ProductKanbanDTOParam.ProductKanbanDTOParamBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("monomerId")
      public ProductKanbanDTOParam.ProductKanbanDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("planId")
      public ProductKanbanDTOParam.ProductKanbanDTOParamBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("factoryId")
      public ProductKanbanDTOParam.ProductKanbanDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("processId")
      public ProductKanbanDTOParam.ProductKanbanDTOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("productType")
      public ProductKanbanDTOParam.ProductKanbanDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("name")
      public ProductKanbanDTOParam.ProductKanbanDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProductKanbanDTOParam.ProductKanbanDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("category")
      public ProductKanbanDTOParam.ProductKanbanDTOParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("specification")
      public ProductKanbanDTOParam.ProductKanbanDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public ProductKanbanDTOParam.ProductKanbanDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("plate")
      public ProductKanbanDTOParam.ProductKanbanDTOParamBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public ProductKanbanDTOParam.ProductKanbanDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("name")
      public ProductKanbanDTOParam.ProductKanbanDTOParamBuilder steelSpec(final String steelSpec) {
         this.steelSpec = steelSpec;
         return this;
      }

      @JsonProperty("structureClassId")
      public ProductKanbanDTOParam.ProductKanbanDTOParamBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      public ProductKanbanDTOParam build() {
         return new ProductKanbanDTOParam(
            this.projectId,
            this.status,
            this.monomerId,
            this.planId,
            this.factoryId,
            this.processId,
            this.productType,
            this.name,
            this.serialNumber,
            this.category,
            this.specification,
            this.material,
            this.plate,
            this.color,
            this.steelSpec,
            this.structureClassId
         );
      }

      @Override
      public String toString() {
         return "ProductKanbanDTOParam.ProductKanbanDTOParamBuilder(projectId="
            + this.projectId
            + ", status="
            + this.status
            + ", monomerId="
            + this.monomerId
            + ", planId="
            + this.planId
            + ", factoryId="
            + this.factoryId
            + ", processId="
            + this.processId
            + ", productType="
            + this.productType
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", category="
            + this.category
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", plate="
            + this.plate
            + ", color="
            + this.color
            + ", steelSpec="
            + this.steelSpec
            + ", structureClassId="
            + this.structureClassId
            + ")";
      }
   }
}
