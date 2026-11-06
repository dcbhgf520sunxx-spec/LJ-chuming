package com.hzchum.scim.business.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "BusinessStandardPart对象", description = "标准件商务表 ")
public class StandardPartAddDtoParam {
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "relationType", value = "关联类型 2构件 4围护", notes = "关联类型 2构件 4围护")
   private Integer relationType;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id", notes = "批次Id")
   private Long areaBatchId;
   @ApiModelProperty(name = "category", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划表id")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "dictionaryId", value = "围护字典类型id")
   private Long dictionaryId;
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地 2工厂", notes = "使用属性 1工地 2工厂")
   private Integer useProperty;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "measureUnit", value = "单位", notes = "单位")
   private String measureUnit;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "materialInventoryId", notes = "库存Id")
   private Long materialInventoryId;

   public static StandardPartAddDtoParam.StandardPartAddDtoParamBuilder builder() {
      return new StandardPartAddDtoParam.StandardPartAddDtoParamBuilder();
   }

   public StandardPartAddDtoParam() {
   }

   public StandardPartAddDtoParam(
      final Long projectId,
      final Integer relationType,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final Integer category,
      final Long enclosurePlanId,
      final Long dictionaryId,
      final Integer useProperty,
      final String name,
      final String specification,
      final String measureUnit,
      final BigDecimal quantity,
      final BigDecimal mete,
      final String accountingUnit,
      final Long materialInventoryId
   ) {
      this.projectId = projectId;
      this.relationType = relationType;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.category = category;
      this.enclosurePlanId = enclosurePlanId;
      this.dictionaryId = dictionaryId;
      this.useProperty = useProperty;
      this.name = name;
      this.specification = specification;
      this.measureUnit = measureUnit;
      this.quantity = quantity;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.materialInventoryId = materialInventoryId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public String getName() {
      return this.name;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setRelationType(final Integer relationType) {
      this.relationType = relationType;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
   }

   public void setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
   }

   public void setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StandardPartAddDtoParam)) {
         return false;
      }

      StandardPartAddDtoParam other = (StandardPartAddDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$relationType = this.getRelationType();
         Object other$relationType = other.getRelationType();
         if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$areaBatchId = this.getAreaBatchId();
                  Object other$areaBatchId = other.getAreaBatchId();
                  if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                     Object this$category = this.getCategory();
                     Object other$category = other.getCategory();
                     if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                        Object this$enclosurePlanId = this.getEnclosurePlanId();
                        Object other$enclosurePlanId = other.getEnclosurePlanId();
                        if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
                           Object this$dictionaryId = this.getDictionaryId();
                           Object other$dictionaryId = other.getDictionaryId();
                           if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                              Object this$useProperty = this.getUseProperty();
                              Object other$useProperty = other.getUseProperty();
                              if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
                                 Object this$materialInventoryId = this.getMaterialInventoryId();
                                 Object other$materialInventoryId = other.getMaterialInventoryId();
                                 if (this$materialInventoryId == null
                                    ? other$materialInventoryId == null
                                    : this$materialInventoryId.equals(other$materialInventoryId)) {
                                    Object this$name = this.getName();
                                    Object other$name = other.getName();
                                    if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                       Object this$specification = this.getSpecification();
                                       Object other$specification = other.getSpecification();
                                       if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                          Object this$measureUnit = this.getMeasureUnit();
                                          Object other$measureUnit = other.getMeasureUnit();
                                          if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                             Object this$quantity = this.getQuantity();
                                             Object other$quantity = other.getQuantity();
                                             if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                Object this$mete = this.getMete();
                                                Object other$mete = other.getMete();
                                                if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                   Object this$accountingUnit = this.getAccountingUnit();
                                                   Object other$accountingUnit = other.getAccountingUnit();
                                                   return this$accountingUnit == null
                                                      ? other$accountingUnit == null
                                                      : this$accountingUnit.equals(other$accountingUnit);
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
      return other instanceof StandardPartAddDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      return result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
   }

   @Override
   public String toString() {
      return "StandardPartAddDtoParam(projectId="
         + this.getProjectId()
         + ", relationType="
         + this.getRelationType()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", category="
         + this.getCategory()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", useProperty="
         + this.getUseProperty()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ")";
   }

   public static class StandardPartAddDtoParamBuilder {
      private Long projectId;
      private Integer relationType;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private Integer category;
      private Long enclosurePlanId;
      private Long dictionaryId;
      private Integer useProperty;
      private String name;
      private String specification;
      private String measureUnit;
      private BigDecimal quantity;
      private BigDecimal mete;
      private String accountingUnit;
      private Long materialInventoryId;

      StandardPartAddDtoParamBuilder() {
      }

      public StandardPartAddDtoParam.StandardPartAddDtoParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public StandardPartAddDtoParam.StandardPartAddDtoParamBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      public StandardPartAddDtoParam.StandardPartAddDtoParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public StandardPartAddDtoParam.StandardPartAddDtoParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public StandardPartAddDtoParam.StandardPartAddDtoParamBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      public StandardPartAddDtoParam.StandardPartAddDtoParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public StandardPartAddDtoParam.StandardPartAddDtoParamBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      public StandardPartAddDtoParam.StandardPartAddDtoParamBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public StandardPartAddDtoParam.StandardPartAddDtoParamBuilder useProperty(final Integer useProperty) {
         this.useProperty = useProperty;
         return this;
      }

      public StandardPartAddDtoParam.StandardPartAddDtoParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public StandardPartAddDtoParam.StandardPartAddDtoParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public StandardPartAddDtoParam.StandardPartAddDtoParamBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public StandardPartAddDtoParam.StandardPartAddDtoParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public StandardPartAddDtoParam.StandardPartAddDtoParamBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public StandardPartAddDtoParam.StandardPartAddDtoParamBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public StandardPartAddDtoParam.StandardPartAddDtoParamBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      public StandardPartAddDtoParam build() {
         return new StandardPartAddDtoParam(
            this.projectId,
            this.relationType,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.category,
            this.enclosurePlanId,
            this.dictionaryId,
            this.useProperty,
            this.name,
            this.specification,
            this.measureUnit,
            this.quantity,
            this.mete,
            this.accountingUnit,
            this.materialInventoryId
         );
      }

      @Override
      public String toString() {
         return "StandardPartAddDtoParam.StandardPartAddDtoParamBuilder(projectId="
            + this.projectId
            + ", relationType="
            + this.relationType
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", category="
            + this.category
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", dictionaryId="
            + this.dictionaryId
            + ", useProperty="
            + this.useProperty
            + ", name="
            + this.name
            + ", specification="
            + this.specification
            + ", measureUnit="
            + this.measureUnit
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", materialInventoryId="
            + this.materialInventoryId
            + ")";
      }
   }
}
