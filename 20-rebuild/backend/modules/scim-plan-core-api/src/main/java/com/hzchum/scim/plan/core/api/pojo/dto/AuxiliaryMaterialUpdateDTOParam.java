package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("配套件辅材 修改")
public class AuxiliaryMaterialUpdateDTOParam {
   @ApiModelProperty(name = "id")
   @NotNull(message = "配套件id不能为空")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id ")
   private Long monomerId;
   @ApiModelProperty(name = "classifyFullName", value = "分类全称 ")
   @NotBlank(message = "分类全称不能为空")
   private String classifyFullName;
   @ApiModelProperty(name = "classifyId", value = "科目id")
   @NotNull(message = "科目id不能为空")
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "科目名称")
   @NotBlank(message = "科目名称不能为空")
   private String classifyName;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @NotBlank(message = "编号不能为空")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "measureUnit", value = "计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "measurePrecision", value = "计量精度")
   private Integer measurePrecision;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "mete", value = "核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingPrecision", value = "核算精度")
   private Integer accountingPrecision;
   @ApiModelProperty(name = "color", value = "颜色")
   private String color;
   @ApiModelProperty(name = "brand", value = "品牌")
   private String brand;
   @ApiModelProperty(name = "remark")
   private String remark;
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地使用 2工厂使用")
   @NotNull(message = "使用属性不能为空")
   private Integer useProperty;
   @ApiModelProperty("是否无需上报 true 不上报(即入即安) false 上报 ")
   private Boolean boolNoReport;

   public static AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder builder() {
      return new AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder();
   }

   public AuxiliaryMaterialUpdateDTOParam() {
   }

   public AuxiliaryMaterialUpdateDTOParam(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final String classifyFullName,
      final Long classifyId,
      final String classifyName,
      final String serialNumber,
      final String specification,
      final Integer quantity,
      final String measureUnit,
      final Integer measurePrecision,
      final String accountingUnit,
      final BigDecimal mete,
      final Integer accountingPrecision,
      final String color,
      final String brand,
      final String remark,
      final Integer useProperty,
      final Boolean boolNoReport
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.classifyFullName = classifyFullName;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.quantity = quantity;
      this.measureUnit = measureUnit;
      this.measurePrecision = measurePrecision;
      this.accountingUnit = accountingUnit;
      this.mete = mete;
      this.accountingPrecision = accountingPrecision;
      this.color = color;
      this.brand = brand;
      this.remark = remark;
      this.useProperty = useProperty;
      this.boolNoReport = boolNoReport;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getClassifyFullName() {
      return this.classifyFullName;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public String getColor() {
      return this.color;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public Boolean getBoolNoReport() {
      return this.boolNoReport;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setClassifyFullName(final String classifyFullName) {
      this.classifyFullName = classifyFullName;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
   }

   public void setBoolNoReport(final Boolean boolNoReport) {
      this.boolNoReport = boolNoReport;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AuxiliaryMaterialUpdateDTOParam)) {
         return false;
      }

      AuxiliaryMaterialUpdateDTOParam other = (AuxiliaryMaterialUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$classifyId = this.getClassifyId();
               Object other$classifyId = other.getClassifyId();
               if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$measurePrecision = this.getMeasurePrecision();
                     Object other$measurePrecision = other.getMeasurePrecision();
                     if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
                        Object this$accountingPrecision = this.getAccountingPrecision();
                        Object other$accountingPrecision = other.getAccountingPrecision();
                        if (this$accountingPrecision == null ? other$accountingPrecision == null : this$accountingPrecision.equals(other$accountingPrecision)) {
                           Object this$useProperty = this.getUseProperty();
                           Object other$useProperty = other.getUseProperty();
                           if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
                              Object this$boolNoReport = this.getBoolNoReport();
                              Object other$boolNoReport = other.getBoolNoReport();
                              if (this$boolNoReport == null ? other$boolNoReport == null : this$boolNoReport.equals(other$boolNoReport)) {
                                 Object this$classifyFullName = this.getClassifyFullName();
                                 Object other$classifyFullName = other.getClassifyFullName();
                                 if (this$classifyFullName == null ? other$classifyFullName == null : this$classifyFullName.equals(other$classifyFullName)) {
                                    Object this$classifyName = this.getClassifyName();
                                    Object other$classifyName = other.getClassifyName();
                                    if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
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
                                                   Object this$mete = this.getMete();
                                                   Object other$mete = other.getMete();
                                                   if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                      Object this$color = this.getColor();
                                                      Object other$color = other.getColor();
                                                      if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                         Object this$brand = this.getBrand();
                                                         Object other$brand = other.getBrand();
                                                         if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AuxiliaryMaterialUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $boolNoReport = this.getBoolNoReport();
      result = result * 59 + ($boolNoReport == null ? 43 : $boolNoReport.hashCode());
      Object $classifyFullName = this.getClassifyFullName();
      result = result * 59 + ($classifyFullName == null ? 43 : $classifyFullName.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "AuxiliaryMaterialUpdateDTOParam(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", classifyFullName="
         + this.getClassifyFullName()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", color="
         + this.getColor()
         + ", brand="
         + this.getBrand()
         + ", remark="
         + this.getRemark()
         + ", useProperty="
         + this.getUseProperty()
         + ", boolNoReport="
         + this.getBoolNoReport()
         + ")";
   }

   public static class AuxiliaryMaterialUpdateDTOParamBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private String classifyFullName;
      private Long classifyId;
      private String classifyName;
      private String serialNumber;
      private String specification;
      private Integer quantity;
      private String measureUnit;
      private Integer measurePrecision;
      private String accountingUnit;
      private BigDecimal mete;
      private Integer accountingPrecision;
      private String color;
      private String brand;
      private String remark;
      private Integer useProperty;
      private Boolean boolNoReport;

      AuxiliaryMaterialUpdateDTOParamBuilder() {
      }

      public AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder classifyFullName(final String classifyFullName) {
         this.classifyFullName = classifyFullName;
         return this;
      }

      public AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder useProperty(final Integer useProperty) {
         this.useProperty = useProperty;
         return this;
      }

      public AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder boolNoReport(final Boolean boolNoReport) {
         this.boolNoReport = boolNoReport;
         return this;
      }

      public AuxiliaryMaterialUpdateDTOParam build() {
         return new AuxiliaryMaterialUpdateDTOParam(
            this.id,
            this.projectId,
            this.monomerId,
            this.classifyFullName,
            this.classifyId,
            this.classifyName,
            this.serialNumber,
            this.specification,
            this.quantity,
            this.measureUnit,
            this.measurePrecision,
            this.accountingUnit,
            this.mete,
            this.accountingPrecision,
            this.color,
            this.brand,
            this.remark,
            this.useProperty,
            this.boolNoReport
         );
      }

      @Override
      public String toString() {
         return "AuxiliaryMaterialUpdateDTOParam.AuxiliaryMaterialUpdateDTOParamBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", classifyFullName="
            + this.classifyFullName
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", measureUnit="
            + this.measureUnit
            + ", measurePrecision="
            + this.measurePrecision
            + ", accountingUnit="
            + this.accountingUnit
            + ", mete="
            + this.mete
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", color="
            + this.color
            + ", brand="
            + this.brand
            + ", remark="
            + this.remark
            + ", useProperty="
            + this.useProperty
            + ", boolNoReport="
            + this.boolNoReport
            + ")";
      }
   }
}
