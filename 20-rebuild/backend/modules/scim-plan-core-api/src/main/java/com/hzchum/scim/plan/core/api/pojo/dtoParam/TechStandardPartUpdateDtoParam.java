package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.plan.core.api.enums.AuxiliaryUsePropertyEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "TechStandardPart对象", description = "标准件")
public class TechStandardPartUpdateDtoParam {
   @ApiModelProperty(name = "id", value = "主键id", notes = "主键id")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @NotBlank(message = "标准件名称不能为空")
   private String name;
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地 2工厂", notes = "使用属性 1工地 2工厂")
   @NotNull(message = "使用范围不能为空!")
   @EnumValidator(value = AuxiliaryUsePropertyEnum.class, message = "使用范围错误!")
   private Integer useProperty;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @NotNull(message = "标准件规格不能为空")
   @Size(max = 64, message = "规格字数超出范围")
   private String specification;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   @NotNull(message = "标准件计量单位不能为空")
   @Size(max = 16, message = "计量单位字数超出范围")
   private String measureUnit;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @NotNull(message = "标准件数量不能为空")
   @DecimalMin(value = "1", message = "数量最小为1")
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @NotNull(message = "核算量不能为空!")
   @DecimalMin(value = "0", message = "核算量不能为负数!")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   @NotBlank(message = "核算单位不能为空!")
   private String accountingUnit;
   @NotNull(message = "请确认核算单位是否为重量类型!!")
   @ApiModelProperty(name = "boolWeightTypeEnum", value = "(核算单位)是否重量类型 true是 false否", notes = "(核算单位)是否重量类型 true是 false否")
   private Boolean boolWeightTypeEnum;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @Size(max = 255, message = "备注字数超出范围")
   private String remark;

   public static TechStandardPartUpdateDtoParam.TechStandardPartUpdateDtoParamBuilder builder() {
      return new TechStandardPartUpdateDtoParam.TechStandardPartUpdateDtoParamBuilder();
   }

   public TechStandardPartUpdateDtoParam() {
   }

   public TechStandardPartUpdateDtoParam(
      final Long id,
      final String name,
      final Integer useProperty,
      final String specification,
      final String measureUnit,
      final BigDecimal quantity,
      final BigDecimal mete,
      final String accountingUnit,
      final Boolean boolWeightTypeEnum,
      final String remark
   ) {
      this.id = id;
      this.name = name;
      this.useProperty = useProperty;
      this.specification = specification;
      this.measureUnit = measureUnit;
      this.quantity = quantity;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.boolWeightTypeEnum = boolWeightTypeEnum;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getUseProperty() {
      return this.useProperty;
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

   public Boolean getBoolWeightTypeEnum() {
      return this.boolWeightTypeEnum;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
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

   public void setBoolWeightTypeEnum(final Boolean boolWeightTypeEnum) {
      this.boolWeightTypeEnum = boolWeightTypeEnum;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechStandardPartUpdateDtoParam)) {
         return false;
      }

      TechStandardPartUpdateDtoParam other = (TechStandardPartUpdateDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$useProperty = this.getUseProperty();
         Object other$useProperty = other.getUseProperty();
         if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
            Object this$boolWeightTypeEnum = this.getBoolWeightTypeEnum();
            Object other$boolWeightTypeEnum = other.getBoolWeightTypeEnum();
            if (this$boolWeightTypeEnum == null ? other$boolWeightTypeEnum == null : this$boolWeightTypeEnum.equals(other$boolWeightTypeEnum)) {
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
                              if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechStandardPartUpdateDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $boolWeightTypeEnum = this.getBoolWeightTypeEnum();
      result = result * 59 + ($boolWeightTypeEnum == null ? 43 : $boolWeightTypeEnum.hashCode());
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
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "TechStandardPartUpdateDtoParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", useProperty="
         + this.getUseProperty()
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
         + ", boolWeightTypeEnum="
         + this.getBoolWeightTypeEnum()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class TechStandardPartUpdateDtoParamBuilder {
      private Long id;
      private String name;
      private Integer useProperty;
      private String specification;
      private String measureUnit;
      private BigDecimal quantity;
      private BigDecimal mete;
      private String accountingUnit;
      private Boolean boolWeightTypeEnum;
      private String remark;

      TechStandardPartUpdateDtoParamBuilder() {
      }

      public TechStandardPartUpdateDtoParam.TechStandardPartUpdateDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechStandardPartUpdateDtoParam.TechStandardPartUpdateDtoParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechStandardPartUpdateDtoParam.TechStandardPartUpdateDtoParamBuilder useProperty(final Integer useProperty) {
         this.useProperty = useProperty;
         return this;
      }

      public TechStandardPartUpdateDtoParam.TechStandardPartUpdateDtoParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechStandardPartUpdateDtoParam.TechStandardPartUpdateDtoParamBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public TechStandardPartUpdateDtoParam.TechStandardPartUpdateDtoParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechStandardPartUpdateDtoParam.TechStandardPartUpdateDtoParamBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public TechStandardPartUpdateDtoParam.TechStandardPartUpdateDtoParamBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public TechStandardPartUpdateDtoParam.TechStandardPartUpdateDtoParamBuilder boolWeightTypeEnum(final Boolean boolWeightTypeEnum) {
         this.boolWeightTypeEnum = boolWeightTypeEnum;
         return this;
      }

      public TechStandardPartUpdateDtoParam.TechStandardPartUpdateDtoParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechStandardPartUpdateDtoParam build() {
         return new TechStandardPartUpdateDtoParam(
            this.id,
            this.name,
            this.useProperty,
            this.specification,
            this.measureUnit,
            this.quantity,
            this.mete,
            this.accountingUnit,
            this.boolWeightTypeEnum,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "TechStandardPartUpdateDtoParam.TechStandardPartUpdateDtoParamBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", useProperty="
            + this.useProperty
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
            + ", boolWeightTypeEnum="
            + this.boolWeightTypeEnum
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
