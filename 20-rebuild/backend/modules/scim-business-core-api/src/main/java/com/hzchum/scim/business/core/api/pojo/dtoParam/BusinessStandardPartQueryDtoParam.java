package com.hzchum.scim.business.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "BusinessStandardPart对象", description = "标准件商务表 ")
public class BusinessStandardPartQueryDtoParam {
   private List<Long> ids;
   @NotNull(message = "项目id必传!")
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @NotNull(message = "关联类型必传!")
   @ApiModelProperty(name = "relationType", value = "关联类型 2构件 4围护", notes = "关联类型 2构件 4围护")
   private Integer relationType;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "category", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划表id")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "measureUnit", value = "单位", notes = "单位")
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地 2工厂", notes = "使用属性 1工地 2工厂")
   private Integer useProperty;

   public static BusinessStandardPartQueryDtoParam.BusinessStandardPartQueryDtoParamBuilder builder() {
      return new BusinessStandardPartQueryDtoParam.BusinessStandardPartQueryDtoParamBuilder();
   }

   public BusinessStandardPartQueryDtoParam() {
   }

   public BusinessStandardPartQueryDtoParam(
      final List<Long> ids,
      final Long projectId,
      final Integer relationType,
      final Long monomerId,
      final Long areaId,
      final Integer category,
      final Long enclosurePlanId,
      final String name,
      final String specification,
      final String measureUnit,
      final String accountingUnit,
      final Integer useProperty
   ) {
      this.ids = ids;
      this.projectId = projectId;
      this.relationType = relationType;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.category = category;
      this.enclosurePlanId = enclosurePlanId;
      this.name = name;
      this.specification = specification;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.useProperty = useProperty;
   }

   public List<Long> getIds() {
      return this.ids;
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

   public Integer getCategory() {
      return this.category;
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
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

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public void setIds(final List<Long> ids) {
      this.ids = ids;
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

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
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

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessStandardPartQueryDtoParam)) {
         return false;
      }

      BusinessStandardPartQueryDtoParam other = (BusinessStandardPartQueryDtoParam)o;
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
                  Object this$category = this.getCategory();
                  Object other$category = other.getCategory();
                  if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                     Object this$enclosurePlanId = this.getEnclosurePlanId();
                     Object other$enclosurePlanId = other.getEnclosurePlanId();
                     if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
                        Object this$useProperty = this.getUseProperty();
                        Object other$useProperty = other.getUseProperty();
                        if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
                           Object this$ids = this.getIds();
                           Object other$ids = other.getIds();
                           if (this$ids == null ? other$ids == null : this$ids.equals(other$ids)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$specification = this.getSpecification();
                                 Object other$specification = other.getSpecification();
                                 if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                    Object this$measureUnit = this.getMeasureUnit();
                                    Object other$measureUnit = other.getMeasureUnit();
                                    if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                       Object this$accountingUnit = this.getAccountingUnit();
                                       Object other$accountingUnit = other.getAccountingUnit();
                                       return this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit);
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
      return other instanceof BusinessStandardPartQueryDtoParam;
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
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $ids = this.getIds();
      result = result * 59 + ($ids == null ? 43 : $ids.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      return result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessStandardPartQueryDtoParam(ids="
         + this.getIds()
         + ", projectId="
         + this.getProjectId()
         + ", relationType="
         + this.getRelationType()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", category="
         + this.getCategory()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", useProperty="
         + this.getUseProperty()
         + ")";
   }

   public static class BusinessStandardPartQueryDtoParamBuilder {
      private List<Long> ids;
      private Long projectId;
      private Integer relationType;
      private Long monomerId;
      private Long areaId;
      private Integer category;
      private Long enclosurePlanId;
      private String name;
      private String specification;
      private String measureUnit;
      private String accountingUnit;
      private Integer useProperty;

      BusinessStandardPartQueryDtoParamBuilder() {
      }

      public BusinessStandardPartQueryDtoParam.BusinessStandardPartQueryDtoParamBuilder ids(final List<Long> ids) {
         this.ids = ids;
         return this;
      }

      public BusinessStandardPartQueryDtoParam.BusinessStandardPartQueryDtoParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessStandardPartQueryDtoParam.BusinessStandardPartQueryDtoParamBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      public BusinessStandardPartQueryDtoParam.BusinessStandardPartQueryDtoParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public BusinessStandardPartQueryDtoParam.BusinessStandardPartQueryDtoParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public BusinessStandardPartQueryDtoParam.BusinessStandardPartQueryDtoParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public BusinessStandardPartQueryDtoParam.BusinessStandardPartQueryDtoParamBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      public BusinessStandardPartQueryDtoParam.BusinessStandardPartQueryDtoParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BusinessStandardPartQueryDtoParam.BusinessStandardPartQueryDtoParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public BusinessStandardPartQueryDtoParam.BusinessStandardPartQueryDtoParamBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public BusinessStandardPartQueryDtoParam.BusinessStandardPartQueryDtoParamBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public BusinessStandardPartQueryDtoParam.BusinessStandardPartQueryDtoParamBuilder useProperty(final Integer useProperty) {
         this.useProperty = useProperty;
         return this;
      }

      public BusinessStandardPartQueryDtoParam build() {
         return new BusinessStandardPartQueryDtoParam(
            this.ids,
            this.projectId,
            this.relationType,
            this.monomerId,
            this.areaId,
            this.category,
            this.enclosurePlanId,
            this.name,
            this.specification,
            this.measureUnit,
            this.accountingUnit,
            this.useProperty
         );
      }

      @Override
      public String toString() {
         return "BusinessStandardPartQueryDtoParam.BusinessStandardPartQueryDtoParamBuilder(ids="
            + this.ids
            + ", projectId="
            + this.projectId
            + ", relationType="
            + this.relationType
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", category="
            + this.category
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", name="
            + this.name
            + ", specification="
            + this.specification
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", useProperty="
            + this.useProperty
            + ")";
      }
   }
}
