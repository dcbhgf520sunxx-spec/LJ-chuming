package com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.groups.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "SchedulingGroupsTreeVORequest", description = "生产线列表请求类")
public class SchedulingGroupsTreeVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "生产线名称", value = "生产线名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "factoryId", notes = "工厂id", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", notes = "车间id", value = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "productionLineTypeEnum", value = "生产线类型", notes = "生产线类型")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Long productionLineTypeEnum;
   @ApiModelProperty(name = "productType", notes = "产品类型", value = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @NotNull(message = "产品类型不能为空")
   private Integer productType;
   @ApiModelProperty(name = "structureClassId", value = "构件种类id")
   @JsonProperty("structureClassId")
   @JSONField(name = "structureClassId")
   private Long structureClassId;

   public static SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder builder() {
      return new SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   @JsonProperty("id")
   public SchedulingGroupsTreeVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public SchedulingGroupsTreeVORequest setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("factoryId")
   public SchedulingGroupsTreeVORequest setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public SchedulingGroupsTreeVORequest setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public SchedulingGroupsTreeVORequest setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public SchedulingGroupsTreeVORequest setProductionLineTypeEnum(final Long productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("productType")
   public SchedulingGroupsTreeVORequest setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("structureClassId")
   public SchedulingGroupsTreeVORequest setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
      return this;
   }

   @Override
   public String toString() {
      return "SchedulingGroupsTreeVORequest(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", productType="
         + this.getProductType()
         + ", structureClassId="
         + this.getStructureClassId()
         + ")";
   }

   public SchedulingGroupsTreeVORequest(
      final Long id,
      final String name,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long productionLineTypeEnum,
      final Integer productType,
      final Long structureClassId
   ) {
      this.id = id;
      this.name = name;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.productType = productType;
      this.structureClassId = structureClassId;
   }

   public SchedulingGroupsTreeVORequest() {
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SchedulingGroupsTreeVORequest)) {
         return false;
      }

      SchedulingGroupsTreeVORequest other = (SchedulingGroupsTreeVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$productionLineId = this.getProductionLineId();
               Object other$productionLineId = other.getProductionLineId();
               if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                  Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                  Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                  if (this$productionLineTypeEnum == null
                     ? other$productionLineTypeEnum == null
                     : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$structureClassId = this.getStructureClassId();
                        Object other$structureClassId = other.getStructureClassId();
                        if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SchedulingGroupsTreeVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class SchedulingGroupsTreeVORequestBuilder {
      private Long id;
      private String name;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long productionLineTypeEnum;
      private Integer productType;
      private Long structureClassId;

      SchedulingGroupsTreeVORequestBuilder() {
      }

      @JsonProperty("id")
      public SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("factoryId")
      public SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder productionLineTypeEnum(final Long productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("productType")
      public SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("structureClassId")
      public SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      public SchedulingGroupsTreeVORequest build() {
         return new SchedulingGroupsTreeVORequest(
            this.id, this.name, this.factoryId, this.workshopId, this.productionLineId, this.productionLineTypeEnum, this.productType, this.structureClassId
         );
      }

      @Override
      public String toString() {
         return "SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", productType="
            + this.productType
            + ", structureClassId="
            + this.structureClassId
            + ")";
      }
   }
}
