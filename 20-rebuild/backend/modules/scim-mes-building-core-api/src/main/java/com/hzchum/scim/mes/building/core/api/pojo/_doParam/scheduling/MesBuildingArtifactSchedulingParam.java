package com.hzchum.scim.mes.building.core.api.pojo._doParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingArtifactSchedulingDOParam", description = "构件排产信息")
public class MesBuildingArtifactSchedulingParam {
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "structureClassIds", value = "构件种类id")
   @JsonProperty("structureClassIds")
   @JSONField(name = "structureClassIds")
   @NotNull(message = "构件种类id不能为空")
   private List<Long> structureClassIds;
   @ApiModelProperty(name = "structureClassId", value = "构件种类id")
   @JsonProperty("structureClassId")
   @JSONField(name = "structureClassId")
   private Long structureClassId;
   @ApiModelProperty(name = "serialNumber", notes = "构件编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "name", notes = "构件名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "material", notes = "构件材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "specification", notes = "构件规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;

   public static MesBuildingArtifactSchedulingParam.MesBuildingArtifactSchedulingParamBuilder builder() {
      return new MesBuildingArtifactSchedulingParam.MesBuildingArtifactSchedulingParamBuilder();
   }

   public MesBuildingArtifactSchedulingParam(
      final Long areaId,
      final List<Long> structureClassIds,
      final Long structureClassId,
      final String serialNumber,
      final String name,
      final String material,
      final String specification
   ) {
      this.areaId = areaId;
      this.structureClassIds = structureClassIds;
      this.structureClassId = structureClassId;
      this.serialNumber = serialNumber;
      this.name = name;
      this.material = material;
      this.specification = specification;
   }

   public MesBuildingArtifactSchedulingParam() {
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public List<Long> getStructureClassIds() {
      return this.structureClassIds;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getSpecification() {
      return this.specification;
   }

   @JsonProperty("areaId")
   public MesBuildingArtifactSchedulingParam setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("structureClassIds")
   public MesBuildingArtifactSchedulingParam setStructureClassIds(final List<Long> structureClassIds) {
      this.structureClassIds = structureClassIds;
      return this;
   }

   @JsonProperty("structureClassId")
   public MesBuildingArtifactSchedulingParam setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingArtifactSchedulingParam setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingArtifactSchedulingParam setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingArtifactSchedulingParam setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingArtifactSchedulingParam setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingArtifactSchedulingParam(areaId="
         + this.getAreaId()
         + ", structureClassIds="
         + this.getStructureClassIds()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", specification="
         + this.getSpecification()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingArtifactSchedulingParam)) {
         return false;
      }

      MesBuildingArtifactSchedulingParam other = (MesBuildingArtifactSchedulingParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$areaId = this.getAreaId();
      Object other$areaId = other.getAreaId();
      if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
         Object this$structureClassId = this.getStructureClassId();
         Object other$structureClassId = other.getStructureClassId();
         if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
            Object this$structureClassIds = this.getStructureClassIds();
            Object other$structureClassIds = other.getStructureClassIds();
            if (this$structureClassIds == null ? other$structureClassIds == null : this$structureClassIds.equals(other$structureClassIds)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$material = this.getMaterial();
                     Object other$material = other.getMaterial();
                     if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        return this$specification == null ? other$specification == null : this$specification.equals(other$specification);
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
      return other instanceof MesBuildingArtifactSchedulingParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $structureClassIds = this.getStructureClassIds();
      result = result * 59 + ($structureClassIds == null ? 43 : $structureClassIds.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $specification = this.getSpecification();
      return result * 59 + ($specification == null ? 43 : $specification.hashCode());
   }

   public static class MesBuildingArtifactSchedulingParamBuilder {
      private Long areaId;
      private List<Long> structureClassIds;
      private Long structureClassId;
      private String serialNumber;
      private String name;
      private String material;
      private String specification;

      MesBuildingArtifactSchedulingParamBuilder() {
      }

      @JsonProperty("areaId")
      public MesBuildingArtifactSchedulingParam.MesBuildingArtifactSchedulingParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("structureClassIds")
      public MesBuildingArtifactSchedulingParam.MesBuildingArtifactSchedulingParamBuilder structureClassIds(final List<Long> structureClassIds) {
         this.structureClassIds = structureClassIds;
         return this;
      }

      @JsonProperty("structureClassId")
      public MesBuildingArtifactSchedulingParam.MesBuildingArtifactSchedulingParamBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingArtifactSchedulingParam.MesBuildingArtifactSchedulingParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingArtifactSchedulingParam.MesBuildingArtifactSchedulingParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingArtifactSchedulingParam.MesBuildingArtifactSchedulingParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingArtifactSchedulingParam.MesBuildingArtifactSchedulingParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public MesBuildingArtifactSchedulingParam build() {
         return new MesBuildingArtifactSchedulingParam(
            this.areaId, this.structureClassIds, this.structureClassId, this.serialNumber, this.name, this.material, this.specification
         );
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactSchedulingParam.MesBuildingArtifactSchedulingParamBuilder(areaId="
            + this.areaId
            + ", structureClassIds="
            + this.structureClassIds
            + ", structureClassId="
            + this.structureClassId
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", material="
            + this.material
            + ", specification="
            + this.specification
            + ")";
      }
   }
}
