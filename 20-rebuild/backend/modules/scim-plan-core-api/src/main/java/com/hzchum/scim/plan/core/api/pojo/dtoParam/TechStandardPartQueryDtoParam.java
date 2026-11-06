package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "TechStandardPart对象", description = "标准件查询类")
public class TechStandardPartQueryDtoParam {
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @NotNull(message = "项目必传!")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id(选填)", notes = "单体id(选填)")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id(选填)", notes = "区域id(选填)")
   private Long areaId;
   @ApiModelProperty(name = "areaId", value = "区域id(选填)", notes = "区域id(选填)")
   private Long areaBatchId;
   @ApiModelProperty(name = "relationType", value = "关联类型 2构件 4围护", notes = "关联类型 2构件 4围护")
   private Integer relationType;
   @ApiModelProperty(name = "category", value = "品类 2压型彩板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty(name = "dictionaryId", value = "字典类型id")
   private Long dictionaryId;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划表id")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地 2工厂", notes = "使用属性 1工地 2工厂")
   private Integer useProperty;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "measureUnit", value = "单位", notes = "单位")
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "boolArtifactImport", value = "是否关联清单 true是 false否", notes = "是否关联清单 true是 false否")
   private Boolean boolArtifactImport;
   @ApiModelProperty(name = "boolInbound", value = "是否入库 0未入库 1 wms已入库", notes = "是否入库 0未入库 1 wms已入库")
   private Boolean boolInbound;
   @ApiModelProperty(name = "configStatus", value = "配置状态 0未配置  1已配置  默认0", notes = "配置状态 0未配置  1已配置  默认0")
   @JsonProperty("configStatus")
   @JSONField(name = "configStatus")
   private Boolean configStatus;

   public static TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder builder() {
      return new TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder();
   }

   public TechStandardPartQueryDtoParam() {
   }

   public TechStandardPartQueryDtoParam(
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final Integer relationType,
      final Integer category,
      final Long dictionaryId,
      final Long enclosurePlanId,
      final Integer useProperty,
      final String name,
      final String specification,
      final String measureUnit,
      final String accountingUnit,
      final String remark,
      final Boolean boolArtifactImport,
      final Boolean boolInbound,
      final Boolean configStatus
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.relationType = relationType;
      this.category = category;
      this.dictionaryId = dictionaryId;
      this.enclosurePlanId = enclosurePlanId;
      this.useProperty = useProperty;
      this.name = name;
      this.specification = specification;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.remark = remark;
      this.boolArtifactImport = boolArtifactImport;
      this.boolInbound = boolInbound;
      this.configStatus = configStatus;
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

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
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

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getBoolArtifactImport() {
      return this.boolArtifactImport;
   }

   public Boolean getBoolInbound() {
      return this.boolInbound;
   }

   public Boolean getConfigStatus() {
      return this.configStatus;
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

   public void setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
   }

   public void setRelationType(final Integer relationType) {
      this.relationType = relationType;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
   }

   public void setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
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

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBoolArtifactImport(final Boolean boolArtifactImport) {
      this.boolArtifactImport = boolArtifactImport;
   }

   public void setBoolInbound(final Boolean boolInbound) {
      this.boolInbound = boolInbound;
   }

   @JsonProperty("configStatus")
   public void setConfigStatus(final Boolean configStatus) {
      this.configStatus = configStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechStandardPartQueryDtoParam)) {
         return false;
      }

      TechStandardPartQueryDtoParam other = (TechStandardPartQueryDtoParam)o;
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
               Object this$areaBatchId = this.getAreaBatchId();
               Object other$areaBatchId = other.getAreaBatchId();
               if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                  Object this$relationType = this.getRelationType();
                  Object other$relationType = other.getRelationType();
                  if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                     Object this$category = this.getCategory();
                     Object other$category = other.getCategory();
                     if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                        Object this$dictionaryId = this.getDictionaryId();
                        Object other$dictionaryId = other.getDictionaryId();
                        if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                           Object this$enclosurePlanId = this.getEnclosurePlanId();
                           Object other$enclosurePlanId = other.getEnclosurePlanId();
                           if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
                              Object this$useProperty = this.getUseProperty();
                              Object other$useProperty = other.getUseProperty();
                              if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
                                 Object this$boolArtifactImport = this.getBoolArtifactImport();
                                 Object other$boolArtifactImport = other.getBoolArtifactImport();
                                 if (this$boolArtifactImport == null
                                    ? other$boolArtifactImport == null
                                    : this$boolArtifactImport.equals(other$boolArtifactImport)) {
                                    Object this$boolInbound = this.getBoolInbound();
                                    Object other$boolInbound = other.getBoolInbound();
                                    if (this$boolInbound == null ? other$boolInbound == null : this$boolInbound.equals(other$boolInbound)) {
                                       Object this$configStatus = this.getConfigStatus();
                                       Object other$configStatus = other.getConfigStatus();
                                       if (this$configStatus == null ? other$configStatus == null : this$configStatus.equals(other$configStatus)) {
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
                                                   if (this$accountingUnit == null
                                                      ? other$accountingUnit == null
                                                      : this$accountingUnit.equals(other$accountingUnit)) {
                                                      Object this$remark = this.getRemark();
                                                      Object other$remark = other.getRemark();
                                                      return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechStandardPartQueryDtoParam;
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
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $boolArtifactImport = this.getBoolArtifactImport();
      result = result * 59 + ($boolArtifactImport == null ? 43 : $boolArtifactImport.hashCode());
      Object $boolInbound = this.getBoolInbound();
      result = result * 59 + ($boolInbound == null ? 43 : $boolInbound.hashCode());
      Object $configStatus = this.getConfigStatus();
      result = result * 59 + ($configStatus == null ? 43 : $configStatus.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "TechStandardPartQueryDtoParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", relationType="
         + this.getRelationType()
         + ", category="
         + this.getCategory()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", useProperty="
         + this.getUseProperty()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", remark="
         + this.getRemark()
         + ", boolArtifactImport="
         + this.getBoolArtifactImport()
         + ", boolInbound="
         + this.getBoolInbound()
         + ", configStatus="
         + this.getConfigStatus()
         + ")";
   }

   public static class TechStandardPartQueryDtoParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private Integer relationType;
      private Integer category;
      private Long dictionaryId;
      private Long enclosurePlanId;
      private Integer useProperty;
      private String name;
      private String specification;
      private String measureUnit;
      private String accountingUnit;
      private String remark;
      private Boolean boolArtifactImport;
      private Boolean boolInbound;
      private Boolean configStatus;

      TechStandardPartQueryDtoParamBuilder() {
      }

      public TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      public TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      public TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      public TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder useProperty(final Integer useProperty) {
         this.useProperty = useProperty;
         return this;
      }

      public TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder boolArtifactImport(final Boolean boolArtifactImport) {
         this.boolArtifactImport = boolArtifactImport;
         return this;
      }

      public TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder boolInbound(final Boolean boolInbound) {
         this.boolInbound = boolInbound;
         return this;
      }

      @JsonProperty("configStatus")
      public TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder configStatus(final Boolean configStatus) {
         this.configStatus = configStatus;
         return this;
      }

      public TechStandardPartQueryDtoParam build() {
         return new TechStandardPartQueryDtoParam(
            this.projectId,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.relationType,
            this.category,
            this.dictionaryId,
            this.enclosurePlanId,
            this.useProperty,
            this.name,
            this.specification,
            this.measureUnit,
            this.accountingUnit,
            this.remark,
            this.boolArtifactImport,
            this.boolInbound,
            this.configStatus
         );
      }

      @Override
      public String toString() {
         return "TechStandardPartQueryDtoParam.TechStandardPartQueryDtoParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", relationType="
            + this.relationType
            + ", category="
            + this.category
            + ", dictionaryId="
            + this.dictionaryId
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", useProperty="
            + this.useProperty
            + ", name="
            + this.name
            + ", specification="
            + this.specification
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", remark="
            + this.remark
            + ", boolArtifactImport="
            + this.boolArtifactImport
            + ", boolInbound="
            + this.boolInbound
            + ", configStatus="
            + this.configStatus
            + ")";
      }
   }
}
