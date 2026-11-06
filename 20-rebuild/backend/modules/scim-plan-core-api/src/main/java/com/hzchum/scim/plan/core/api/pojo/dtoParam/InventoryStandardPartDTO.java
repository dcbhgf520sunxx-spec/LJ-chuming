package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;

@ApiModel(value = "标准件(配套件)导入记录DTO", description = "标准件(配套件)导入记录DTO")
public class InventoryStandardPartDTO extends ArtifactPartCommonDTO {
   @ApiModelProperty(name = "category", value = "品类 2压型彩板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划表id")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "relationType", value = "关联类型 2构件 4围护", notes = "关联类型 2构件 4围护")
   private Integer relationType;
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地 2工厂 AuxiliaryUsePropertyEnum", notes = "使用属性 1工地 2工厂")
   private Integer useProperty;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "boolWeightTypeEnum", value = "(核算单位)是否重量类型 true是 false否", notes = "(核算单位)是否重量类型 true是 false否")
   private Boolean boolWeightTypeEnum;
   @ApiModelProperty(name = "boolArtifactImport", value = "是否关联清单 true是 false否", notes = "是否关联清单 true是 false否")
   private Boolean boolArtifactImport;
   @ApiModelProperty(name = "userId", value = "上传用户Id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20) COMMENT '上传用户Id'", nullable = false)
   private Long userId;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryStandardPartDTO)) {
         return false;
      }

      InventoryStandardPartDTO other = (InventoryStandardPartDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$category = this.getCategory();
      Object other$category = other.getCategory();
      if (this$category == null ? other$category == null : this$category.equals(other$category)) {
         Object this$enclosurePlanId = this.getEnclosurePlanId();
         Object other$enclosurePlanId = other.getEnclosurePlanId();
         if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
            Object this$relationType = this.getRelationType();
            Object other$relationType = other.getRelationType();
            if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
               Object this$useProperty = this.getUseProperty();
               Object other$useProperty = other.getUseProperty();
               if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
                  Object this$boolWeightTypeEnum = this.getBoolWeightTypeEnum();
                  Object other$boolWeightTypeEnum = other.getBoolWeightTypeEnum();
                  if (this$boolWeightTypeEnum == null ? other$boolWeightTypeEnum == null : this$boolWeightTypeEnum.equals(other$boolWeightTypeEnum)) {
                     Object this$boolArtifactImport = this.getBoolArtifactImport();
                     Object other$boolArtifactImport = other.getBoolArtifactImport();
                     if (this$boolArtifactImport == null ? other$boolArtifactImport == null : this$boolArtifactImport.equals(other$boolArtifactImport)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$measureUnit = this.getMeasureUnit();
                           Object other$measureUnit = other.getMeasureUnit();
                           if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                              Object this$mete = this.getMete();
                              Object other$mete = other.getMete();
                              if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof InventoryStandardPartDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $boolWeightTypeEnum = this.getBoolWeightTypeEnum();
      result = result * 59 + ($boolWeightTypeEnum == null ? 43 : $boolWeightTypeEnum.hashCode());
      Object $boolArtifactImport = this.getBoolArtifactImport();
      result = result * 59 + ($boolArtifactImport == null ? 43 : $boolArtifactImport.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      return result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Boolean getBoolWeightTypeEnum() {
      return this.boolWeightTypeEnum;
   }

   public Boolean getBoolArtifactImport() {
      return this.boolArtifactImport;
   }

   public Long getUserId() {
      return this.userId;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
   }

   public void setRelationType(final Integer relationType) {
      this.relationType = relationType;
   }

   public void setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setBoolWeightTypeEnum(final Boolean boolWeightTypeEnum) {
      this.boolWeightTypeEnum = boolWeightTypeEnum;
   }

   public void setBoolArtifactImport(final Boolean boolArtifactImport) {
      this.boolArtifactImport = boolArtifactImport;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   @Override
   public String toString() {
      return "InventoryStandardPartDTO(category="
         + this.getCategory()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", relationType="
         + this.getRelationType()
         + ", useProperty="
         + this.getUseProperty()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", boolWeightTypeEnum="
         + this.getBoolWeightTypeEnum()
         + ", boolArtifactImport="
         + this.getBoolArtifactImport()
         + ", userId="
         + this.getUserId()
         + ")";
   }
}
