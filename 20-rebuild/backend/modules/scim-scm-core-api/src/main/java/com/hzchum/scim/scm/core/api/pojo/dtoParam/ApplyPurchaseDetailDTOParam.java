package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ApplyPurchaseDetailDTOParam {
   private Long id;
   private Integer basicClass;
   private Long classifyId;
   private String classifyName;
   private String classifySerialNumber;
   private String specification;
   private String model;
   private BigDecimal length;
   private BigDecimal quantity;
   private BigDecimal thickness;
   private BigDecimal width;
   private BigDecimal mete;
   private String color;
   private String brand;
   private LocalDateTime arrivalTime;
   @ApiModelProperty(name = "materialInventoryId", value = "物料仓ID[申购冻结时才有]")
   private Long materialInventoryId;
   @ApiModelProperty(name = "artifactEnclosureId", value = "构件或围护ID")
   private Long artifactEnclosureId;
   @ApiModelProperty(name = "projectId", value = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "remark", value = "备注字段")
   private String remark;
   private String accountingUnit;
   private Long standardId;
   private String sectionSteelSpec;
   private String doNotSectionSteelSpec;
   private BigDecimal steelDensity;

   public static ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder builder() {
      return new ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getClassifySerialNumber() {
      return this.classifySerialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getModel() {
      return this.model;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getColor() {
      return this.color;
   }

   public String getBrand() {
      return this.brand;
   }

   public LocalDateTime getArrivalTime() {
      return this.arrivalTime;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public Long getArtifactEnclosureId() {
      return this.artifactEnclosureId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getSectionSteelSpec() {
      return this.sectionSteelSpec;
   }

   public String getDoNotSectionSteelSpec() {
      return this.doNotSectionSteelSpec;
   }

   public BigDecimal getSteelDensity() {
      return this.steelDensity;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setClassifySerialNumber(final String classifySerialNumber) {
      this.classifySerialNumber = classifySerialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setModel(final String model) {
      this.model = model;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setArrivalTime(final LocalDateTime arrivalTime) {
      this.arrivalTime = arrivalTime;
   }

   public void setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
   }

   public void setArtifactEnclosureId(final Long artifactEnclosureId) {
      this.artifactEnclosureId = artifactEnclosureId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setStandardId(final Long standardId) {
      this.standardId = standardId;
   }

   public void setSectionSteelSpec(final String sectionSteelSpec) {
      this.sectionSteelSpec = sectionSteelSpec;
   }

   public void setDoNotSectionSteelSpec(final String doNotSectionSteelSpec) {
      this.doNotSectionSteelSpec = doNotSectionSteelSpec;
   }

   public void setSteelDensity(final BigDecimal steelDensity) {
      this.steelDensity = steelDensity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApplyPurchaseDetailDTOParam)) {
         return false;
      }

      ApplyPurchaseDetailDTOParam other = (ApplyPurchaseDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$materialInventoryId = this.getMaterialInventoryId();
               Object other$materialInventoryId = other.getMaterialInventoryId();
               if (this$materialInventoryId == null ? other$materialInventoryId == null : this$materialInventoryId.equals(other$materialInventoryId)) {
                  Object this$artifactEnclosureId = this.getArtifactEnclosureId();
                  Object other$artifactEnclosureId = other.getArtifactEnclosureId();
                  if (this$artifactEnclosureId == null ? other$artifactEnclosureId == null : this$artifactEnclosureId.equals(other$artifactEnclosureId)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$standardId = this.getStandardId();
                        Object other$standardId = other.getStandardId();
                        if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                           Object this$classifyName = this.getClassifyName();
                           Object other$classifyName = other.getClassifyName();
                           if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                              Object this$classifySerialNumber = this.getClassifySerialNumber();
                              Object other$classifySerialNumber = other.getClassifySerialNumber();
                              if (this$classifySerialNumber == null
                                 ? other$classifySerialNumber == null
                                 : this$classifySerialNumber.equals(other$classifySerialNumber)) {
                                 Object this$specification = this.getSpecification();
                                 Object other$specification = other.getSpecification();
                                 if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                    Object this$model = this.getModel();
                                    Object other$model = other.getModel();
                                    if (this$model == null ? other$model == null : this$model.equals(other$model)) {
                                       Object this$length = this.getLength();
                                       Object other$length = other.getLength();
                                       if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                          Object this$quantity = this.getQuantity();
                                          Object other$quantity = other.getQuantity();
                                          if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                             Object this$thickness = this.getThickness();
                                             Object other$thickness = other.getThickness();
                                             if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                Object this$width = this.getWidth();
                                                Object other$width = other.getWidth();
                                                if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                   Object this$mete = this.getMete();
                                                   Object other$mete = other.getMete();
                                                   if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                      Object this$color = this.getColor();
                                                      Object other$color = other.getColor();
                                                      if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                         Object this$brand = this.getBrand();
                                                         Object other$brand = other.getBrand();
                                                         if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                            Object this$arrivalTime = this.getArrivalTime();
                                                            Object other$arrivalTime = other.getArrivalTime();
                                                            if (this$arrivalTime == null
                                                               ? other$arrivalTime == null
                                                               : this$arrivalTime.equals(other$arrivalTime)) {
                                                               Object this$remark = this.getRemark();
                                                               Object other$remark = other.getRemark();
                                                               if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                  Object this$accountingUnit = this.getAccountingUnit();
                                                                  Object other$accountingUnit = other.getAccountingUnit();
                                                                  if (this$accountingUnit == null
                                                                     ? other$accountingUnit == null
                                                                     : this$accountingUnit.equals(other$accountingUnit)) {
                                                                     Object this$sectionSteelSpec = this.getSectionSteelSpec();
                                                                     Object other$sectionSteelSpec = other.getSectionSteelSpec();
                                                                     if (this$sectionSteelSpec == null
                                                                        ? other$sectionSteelSpec == null
                                                                        : this$sectionSteelSpec.equals(other$sectionSteelSpec)) {
                                                                        Object this$doNotSectionSteelSpec = this.getDoNotSectionSteelSpec();
                                                                        Object other$doNotSectionSteelSpec = other.getDoNotSectionSteelSpec();
                                                                        if (this$doNotSectionSteelSpec == null
                                                                           ? other$doNotSectionSteelSpec == null
                                                                           : this$doNotSectionSteelSpec.equals(other$doNotSectionSteelSpec)) {
                                                                           Object this$steelDensity = this.getSteelDensity();
                                                                           Object other$steelDensity = other.getSteelDensity();
                                                                           return this$steelDensity == null
                                                                              ? other$steelDensity == null
                                                                              : this$steelDensity.equals(other$steelDensity);
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
      return other instanceof ApplyPurchaseDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $artifactEnclosureId = this.getArtifactEnclosureId();
      result = result * 59 + ($artifactEnclosureId == null ? 43 : $artifactEnclosureId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $classifySerialNumber = this.getClassifySerialNumber();
      result = result * 59 + ($classifySerialNumber == null ? 43 : $classifySerialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $model = this.getModel();
      result = result * 59 + ($model == null ? 43 : $model.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $arrivalTime = this.getArrivalTime();
      result = result * 59 + ($arrivalTime == null ? 43 : $arrivalTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $sectionSteelSpec = this.getSectionSteelSpec();
      result = result * 59 + ($sectionSteelSpec == null ? 43 : $sectionSteelSpec.hashCode());
      Object $doNotSectionSteelSpec = this.getDoNotSectionSteelSpec();
      result = result * 59 + ($doNotSectionSteelSpec == null ? 43 : $doNotSectionSteelSpec.hashCode());
      Object $steelDensity = this.getSteelDensity();
      return result * 59 + ($steelDensity == null ? 43 : $steelDensity.hashCode());
   }

   @Override
   public String toString() {
      return "ApplyPurchaseDetailDTOParam(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", classifySerialNumber="
         + this.getClassifySerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", model="
         + this.getModel()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", mete="
         + this.getMete()
         + ", color="
         + this.getColor()
         + ", brand="
         + this.getBrand()
         + ", arrivalTime="
         + this.getArrivalTime()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", artifactEnclosureId="
         + this.getArtifactEnclosureId()
         + ", projectId="
         + this.getProjectId()
         + ", remark="
         + this.getRemark()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", standardId="
         + this.getStandardId()
         + ", sectionSteelSpec="
         + this.getSectionSteelSpec()
         + ", doNotSectionSteelSpec="
         + this.getDoNotSectionSteelSpec()
         + ", steelDensity="
         + this.getSteelDensity()
         + ")";
   }

   public ApplyPurchaseDetailDTOParam(
      final Long id,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final String classifySerialNumber,
      final String specification,
      final String model,
      final BigDecimal length,
      final BigDecimal quantity,
      final BigDecimal thickness,
      final BigDecimal width,
      final BigDecimal mete,
      final String color,
      final String brand,
      final LocalDateTime arrivalTime,
      final Long materialInventoryId,
      final Long artifactEnclosureId,
      final Long projectId,
      final String remark,
      final String accountingUnit,
      final Long standardId,
      final String sectionSteelSpec,
      final String doNotSectionSteelSpec,
      final BigDecimal steelDensity
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.classifySerialNumber = classifySerialNumber;
      this.specification = specification;
      this.model = model;
      this.length = length;
      this.quantity = quantity;
      this.thickness = thickness;
      this.width = width;
      this.mete = mete;
      this.color = color;
      this.brand = brand;
      this.arrivalTime = arrivalTime;
      this.materialInventoryId = materialInventoryId;
      this.artifactEnclosureId = artifactEnclosureId;
      this.projectId = projectId;
      this.remark = remark;
      this.accountingUnit = accountingUnit;
      this.standardId = standardId;
      this.sectionSteelSpec = sectionSteelSpec;
      this.doNotSectionSteelSpec = doNotSectionSteelSpec;
      this.steelDensity = steelDensity;
   }

   public ApplyPurchaseDetailDTOParam() {
   }

   public static class ApplyPurchaseDetailDTOParamBuilder {
      private Long id;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private String classifySerialNumber;
      private String specification;
      private String model;
      private BigDecimal length;
      private BigDecimal quantity;
      private BigDecimal thickness;
      private BigDecimal width;
      private BigDecimal mete;
      private String color;
      private String brand;
      private LocalDateTime arrivalTime;
      private Long materialInventoryId;
      private Long artifactEnclosureId;
      private Long projectId;
      private String remark;
      private String accountingUnit;
      private Long standardId;
      private String sectionSteelSpec;
      private String doNotSectionSteelSpec;
      private BigDecimal steelDensity;

      ApplyPurchaseDetailDTOParamBuilder() {
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder classifySerialNumber(final String classifySerialNumber) {
         this.classifySerialNumber = classifySerialNumber;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder model(final String model) {
         this.model = model;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder arrivalTime(final LocalDateTime arrivalTime) {
         this.arrivalTime = arrivalTime;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder artifactEnclosureId(final Long artifactEnclosureId) {
         this.artifactEnclosureId = artifactEnclosureId;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder sectionSteelSpec(final String sectionSteelSpec) {
         this.sectionSteelSpec = sectionSteelSpec;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder doNotSectionSteelSpec(final String doNotSectionSteelSpec) {
         this.doNotSectionSteelSpec = doNotSectionSteelSpec;
         return this;
      }

      public ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder steelDensity(final BigDecimal steelDensity) {
         this.steelDensity = steelDensity;
         return this;
      }

      public ApplyPurchaseDetailDTOParam build() {
         return new ApplyPurchaseDetailDTOParam(
            this.id,
            this.basicClass,
            this.classifyId,
            this.classifyName,
            this.classifySerialNumber,
            this.specification,
            this.model,
            this.length,
            this.quantity,
            this.thickness,
            this.width,
            this.mete,
            this.color,
            this.brand,
            this.arrivalTime,
            this.materialInventoryId,
            this.artifactEnclosureId,
            this.projectId,
            this.remark,
            this.accountingUnit,
            this.standardId,
            this.sectionSteelSpec,
            this.doNotSectionSteelSpec,
            this.steelDensity
         );
      }

      @Override
      public String toString() {
         return "ApplyPurchaseDetailDTOParam.ApplyPurchaseDetailDTOParamBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", classifySerialNumber="
            + this.classifySerialNumber
            + ", specification="
            + this.specification
            + ", model="
            + this.model
            + ", length="
            + this.length
            + ", quantity="
            + this.quantity
            + ", thickness="
            + this.thickness
            + ", width="
            + this.width
            + ", mete="
            + this.mete
            + ", color="
            + this.color
            + ", brand="
            + this.brand
            + ", arrivalTime="
            + this.arrivalTime
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", artifactEnclosureId="
            + this.artifactEnclosureId
            + ", projectId="
            + this.projectId
            + ", remark="
            + this.remark
            + ", accountingUnit="
            + this.accountingUnit
            + ", standardId="
            + this.standardId
            + ", sectionSteelSpec="
            + this.sectionSteelSpec
            + ", doNotSectionSteelSpec="
            + this.doNotSectionSteelSpec
            + ", steelDensity="
            + this.steelDensity
            + ")";
      }
   }
}
