package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TechAuxiliaryPart对象", description = "新配套件表-查询类 ")
public class TechAuxiliaryPartQueryDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   private String material;
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地 2工厂", notes = "使用属性 1工地 2工厂4未标记")
   private Integer useProperty;

   public static TechAuxiliaryPartQueryDTOParam.TechAuxiliaryPartQueryDTOParamBuilder builder() {
      return new TechAuxiliaryPartQueryDTOParam.TechAuxiliaryPartQueryDTOParamBuilder();
   }

   public TechAuxiliaryPartQueryDTOParam() {
   }

   public TechAuxiliaryPartQueryDTOParam(
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final Integer useProperty
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.useProperty = useProperty;
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

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechAuxiliaryPartQueryDTOParam)) {
         return false;
      }

      TechAuxiliaryPartQueryDTOParam other = (TechAuxiliaryPartQueryDTOParam)o;
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
               Object this$useProperty = this.getUseProperty();
               Object other$useProperty = other.getUseProperty();
               if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechAuxiliaryPartQueryDTOParam;
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
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   @Override
   public String toString() {
      return "TechAuxiliaryPartQueryDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", useProperty="
         + this.getUseProperty()
         + ")";
   }

   public static class TechAuxiliaryPartQueryDTOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private Integer useProperty;

      TechAuxiliaryPartQueryDTOParamBuilder() {
      }

      public TechAuxiliaryPartQueryDTOParam.TechAuxiliaryPartQueryDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechAuxiliaryPartQueryDTOParam.TechAuxiliaryPartQueryDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechAuxiliaryPartQueryDTOParam.TechAuxiliaryPartQueryDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechAuxiliaryPartQueryDTOParam.TechAuxiliaryPartQueryDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechAuxiliaryPartQueryDTOParam.TechAuxiliaryPartQueryDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechAuxiliaryPartQueryDTOParam.TechAuxiliaryPartQueryDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechAuxiliaryPartQueryDTOParam.TechAuxiliaryPartQueryDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechAuxiliaryPartQueryDTOParam.TechAuxiliaryPartQueryDTOParamBuilder useProperty(final Integer useProperty) {
         this.useProperty = useProperty;
         return this;
      }

      public TechAuxiliaryPartQueryDTOParam build() {
         return new TechAuxiliaryPartQueryDTOParam(
            this.projectId, this.monomerId, this.areaId, this.name, this.serialNumber, this.specification, this.material, this.useProperty
         );
      }

      @Override
      public String toString() {
         return "TechAuxiliaryPartQueryDTOParam.TechAuxiliaryPartQueryDTOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", useProperty="
            + this.useProperty
            + ")";
      }
   }
}
