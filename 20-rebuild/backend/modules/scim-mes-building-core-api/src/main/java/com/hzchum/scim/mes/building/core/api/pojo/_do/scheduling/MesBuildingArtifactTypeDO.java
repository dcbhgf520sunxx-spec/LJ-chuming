package com.hzchum.scim.mes.building.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingArtifactTypeDO", description = "构件类型信息")
public class MesBuildingArtifactTypeDO {
   @ApiModelProperty(name = "structureClassId", value = "构件种类表id")
   @JsonProperty("structureClassId")
   @JSONField(name = "structureClassId")
   private Long structureClassId;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "artifactType", value = "构件类型 1普通构件 2次构件")
   @JsonProperty("artifactType")
   @JSONField(name = "artifactType")
   private Integer artifactType;
   @ApiModelProperty(name = "productionLineTypeEnum", value = "生产线类型")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Integer productionLineTypeEnum;
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   private Integer mesProductEnum;

   public static MesBuildingArtifactTypeDO.MesBuildingArtifactTypeDOBuilder builder() {
      return new MesBuildingArtifactTypeDO.MesBuildingArtifactTypeDOBuilder();
   }

   public MesBuildingArtifactTypeDO(
      final Long structureClassId,
      final String name,
      final Integer quantity,
      final Integer artifactType,
      final Integer productionLineTypeEnum,
      final Integer mesProductEnum
   ) {
      this.structureClassId = structureClassId;
      this.name = name;
      this.quantity = quantity;
      this.artifactType = artifactType;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.mesProductEnum = mesProductEnum;
   }

   public MesBuildingArtifactTypeDO() {
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public String getName() {
      return this.name;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   @JsonProperty("structureClassId")
   public MesBuildingArtifactTypeDO setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingArtifactTypeDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingArtifactTypeDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("artifactType")
   public MesBuildingArtifactTypeDO setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingArtifactTypeDO setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   public MesBuildingArtifactTypeDO setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingArtifactTypeDO(structureClassId="
         + this.getStructureClassId()
         + ", name="
         + this.getName()
         + ", quantity="
         + this.getQuantity()
         + ", artifactType="
         + this.getArtifactType()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingArtifactTypeDO)) {
         return false;
      }

      MesBuildingArtifactTypeDO other = (MesBuildingArtifactTypeDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$structureClassId = this.getStructureClassId();
      Object other$structureClassId = other.getStructureClassId();
      if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$artifactType = this.getArtifactType();
            Object other$artifactType = other.getArtifactType();
            if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
               Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
               Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
               if (this$productionLineTypeEnum == null
                  ? other$productionLineTypeEnum == null
                  : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                  Object this$mesProductEnum = this.getMesProductEnum();
                  Object other$mesProductEnum = other.getMesProductEnum();
                  if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
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
      return other instanceof MesBuildingArtifactTypeDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class MesBuildingArtifactTypeDOBuilder {
      private Long structureClassId;
      private String name;
      private Integer quantity;
      private Integer artifactType;
      private Integer productionLineTypeEnum;
      private Integer mesProductEnum;

      MesBuildingArtifactTypeDOBuilder() {
      }

      @JsonProperty("structureClassId")
      public MesBuildingArtifactTypeDO.MesBuildingArtifactTypeDOBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingArtifactTypeDO.MesBuildingArtifactTypeDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingArtifactTypeDO.MesBuildingArtifactTypeDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("artifactType")
      public MesBuildingArtifactTypeDO.MesBuildingArtifactTypeDOBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingArtifactTypeDO.MesBuildingArtifactTypeDOBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      public MesBuildingArtifactTypeDO.MesBuildingArtifactTypeDOBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public MesBuildingArtifactTypeDO build() {
         return new MesBuildingArtifactTypeDO(
            this.structureClassId, this.name, this.quantity, this.artifactType, this.productionLineTypeEnum, this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactTypeDO.MesBuildingArtifactTypeDOBuilder(structureClassId="
            + this.structureClassId
            + ", name="
            + this.name
            + ", quantity="
            + this.quantity
            + ", artifactType="
            + this.artifactType
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
