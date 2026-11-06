package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

public class PurchaseOrderDetailDTOParam {
   private Long id;
   private Long artifactEnclosureId;
   private BigDecimal quantity;
   private String measureUnit;
   @NotNull(message = "单价不能为空")
   private BigDecimal unitPrice;
   private BigDecimal amount;
   private Integer destination;
   private Integer pricingMethod;
   private Integer basicClass;
   private Long classifyId;
   private String classifyName;
   private String classifySerialNumber;
   private String specification;
   private String model;
   private BigDecimal length;
   private BigDecimal thickness;
   private BigDecimal width;
   private String accountingUnit;
   private BigDecimal mete;
   private String color;
   private String brand;
   private Integer weightMeasurementMode;
   private Long applyPurchaseId;
   private String applyPurchaseSN;
   private Long applyPurchaseDetailId;
   private Long projectId;
   private Long factoryId;
   private Long standardId;
   private String sectionSteelSpec;
   private String doNotSectionSteelSpec;
   private Boolean boolOriginalDetail;
   private Long workshopId;
   @ApiModelProperty("制成品计价方式 WmsWageQuotaTypeEnum")
   private Integer wageQuotaType;
   @ApiModelProperty("当材料为制成品的时候会有创建类型")
   private String finishedGoodsTypeName;
   @ApiModelProperty("制成品自定义规格")
   private String manufacturedSpecification;
   @ApiModelProperty("单体ID")
   private Long monomerId;
   @ApiModelProperty("区域ID")
   private Long areaId;
   @ApiModelProperty("单重")
   private BigDecimal weight;
   @ApiModelProperty("单面积mm²")
   private BigDecimal surfaceArea;
   @ApiModelProperty("制成品名称")
   private String manufacturedName;
   @ApiModelProperty("制成品类型 结构制品 ArtifactTypeEnum  围护制品 EnclosureCategoryEnum")
   private Integer manufacturedType;
   @ApiModelProperty("制成品编号")
   private String manufacturedSn;
   @ApiModelProperty("制成品材质")
   private String material;
   private BigDecimal steelDensity;

   public static PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder builder() {
      return new PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getArtifactEnclosureId() {
      return this.artifactEnclosureId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Integer getDestination() {
      return this.destination;
   }

   public Integer getPricingMethod() {
      return this.pricingMethod;
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

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
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

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public Long getApplyPurchaseId() {
      return this.applyPurchaseId;
   }

   public String getApplyPurchaseSN() {
      return this.applyPurchaseSN;
   }

   public Long getApplyPurchaseDetailId() {
      return this.applyPurchaseDetailId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getFactoryId() {
      return this.factoryId;
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

   public Boolean getBoolOriginalDetail() {
      return this.boolOriginalDetail;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public String getFinishedGoodsTypeName() {
      return this.finishedGoodsTypeName;
   }

   public String getManufacturedSpecification() {
      return this.manufacturedSpecification;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public String getManufacturedName() {
      return this.manufacturedName;
   }

   public Integer getManufacturedType() {
      return this.manufacturedType;
   }

   public String getManufacturedSn() {
      return this.manufacturedSn;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getSteelDensity() {
      return this.steelDensity;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setArtifactEnclosureId(final Long artifactEnclosureId) {
      this.artifactEnclosureId = artifactEnclosureId;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setDestination(final Integer destination) {
      this.destination = destination;
   }

   public void setPricingMethod(final Integer pricingMethod) {
      this.pricingMethod = pricingMethod;
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

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
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

   public void setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
   }

   public void setApplyPurchaseId(final Long applyPurchaseId) {
      this.applyPurchaseId = applyPurchaseId;
   }

   public void setApplyPurchaseSN(final String applyPurchaseSN) {
      this.applyPurchaseSN = applyPurchaseSN;
   }

   public void setApplyPurchaseDetailId(final Long applyPurchaseDetailId) {
      this.applyPurchaseDetailId = applyPurchaseDetailId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
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

   public void setBoolOriginalDetail(final Boolean boolOriginalDetail) {
      this.boolOriginalDetail = boolOriginalDetail;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
   }

   public void setFinishedGoodsTypeName(final String finishedGoodsTypeName) {
      this.finishedGoodsTypeName = finishedGoodsTypeName;
   }

   public void setManufacturedSpecification(final String manufacturedSpecification) {
      this.manufacturedSpecification = manufacturedSpecification;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setManufacturedName(final String manufacturedName) {
      this.manufacturedName = manufacturedName;
   }

   public void setManufacturedType(final Integer manufacturedType) {
      this.manufacturedType = manufacturedType;
   }

   public void setManufacturedSn(final String manufacturedSn) {
      this.manufacturedSn = manufacturedSn;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setSteelDensity(final BigDecimal steelDensity) {
      this.steelDensity = steelDensity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseOrderDetailDTOParam)) {
         return false;
      }

      PurchaseOrderDetailDTOParam other = (PurchaseOrderDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactEnclosureId = this.getArtifactEnclosureId();
         Object other$artifactEnclosureId = other.getArtifactEnclosureId();
         if (this$artifactEnclosureId == null ? other$artifactEnclosureId == null : this$artifactEnclosureId.equals(other$artifactEnclosureId)) {
            Object this$destination = this.getDestination();
            Object other$destination = other.getDestination();
            if (this$destination == null ? other$destination == null : this$destination.equals(other$destination)) {
               Object this$pricingMethod = this.getPricingMethod();
               Object other$pricingMethod = other.getPricingMethod();
               if (this$pricingMethod == null ? other$pricingMethod == null : this$pricingMethod.equals(other$pricingMethod)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$classifyId = this.getClassifyId();
                     Object other$classifyId = other.getClassifyId();
                     if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                        Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                        Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                        if (this$weightMeasurementMode == null
                           ? other$weightMeasurementMode == null
                           : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                           Object this$applyPurchaseId = this.getApplyPurchaseId();
                           Object other$applyPurchaseId = other.getApplyPurchaseId();
                           if (this$applyPurchaseId == null ? other$applyPurchaseId == null : this$applyPurchaseId.equals(other$applyPurchaseId)) {
                              Object this$applyPurchaseDetailId = this.getApplyPurchaseDetailId();
                              Object other$applyPurchaseDetailId = other.getApplyPurchaseDetailId();
                              if (this$applyPurchaseDetailId == null
                                 ? other$applyPurchaseDetailId == null
                                 : this$applyPurchaseDetailId.equals(other$applyPurchaseDetailId)) {
                                 Object this$projectId = this.getProjectId();
                                 Object other$projectId = other.getProjectId();
                                 if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                                    Object this$factoryId = this.getFactoryId();
                                    Object other$factoryId = other.getFactoryId();
                                    if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                                       Object this$standardId = this.getStandardId();
                                       Object other$standardId = other.getStandardId();
                                       if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                          Object this$boolOriginalDetail = this.getBoolOriginalDetail();
                                          Object other$boolOriginalDetail = other.getBoolOriginalDetail();
                                          if (this$boolOriginalDetail == null
                                             ? other$boolOriginalDetail == null
                                             : this$boolOriginalDetail.equals(other$boolOriginalDetail)) {
                                             Object this$workshopId = this.getWorkshopId();
                                             Object other$workshopId = other.getWorkshopId();
                                             if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                                Object this$wageQuotaType = this.getWageQuotaType();
                                                Object other$wageQuotaType = other.getWageQuotaType();
                                                if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                                                   Object this$monomerId = this.getMonomerId();
                                                   Object other$monomerId = other.getMonomerId();
                                                   if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                                      Object this$areaId = this.getAreaId();
                                                      Object other$areaId = other.getAreaId();
                                                      if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                                         Object this$manufacturedType = this.getManufacturedType();
                                                         Object other$manufacturedType = other.getManufacturedType();
                                                         if (this$manufacturedType == null
                                                            ? other$manufacturedType == null
                                                            : this$manufacturedType.equals(other$manufacturedType)) {
                                                            Object this$quantity = this.getQuantity();
                                                            Object other$quantity = other.getQuantity();
                                                            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                               Object this$measureUnit = this.getMeasureUnit();
                                                               Object other$measureUnit = other.getMeasureUnit();
                                                               if (this$measureUnit == null
                                                                  ? other$measureUnit == null
                                                                  : this$measureUnit.equals(other$measureUnit)) {
                                                                  Object this$unitPrice = this.getUnitPrice();
                                                                  Object other$unitPrice = other.getUnitPrice();
                                                                  if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)
                                                                     )
                                                                   {
                                                                     Object this$amount = this.getAmount();
                                                                     Object other$amount = other.getAmount();
                                                                     if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                                        Object this$classifyName = this.getClassifyName();
                                                                        Object other$classifyName = other.getClassifyName();
                                                                        if (this$classifyName == null
                                                                           ? other$classifyName == null
                                                                           : this$classifyName.equals(other$classifyName)) {
                                                                           Object this$classifySerialNumber = this.getClassifySerialNumber();
                                                                           Object other$classifySerialNumber = other.getClassifySerialNumber();
                                                                           if (this$classifySerialNumber == null
                                                                              ? other$classifySerialNumber == null
                                                                              : this$classifySerialNumber.equals(other$classifySerialNumber)) {
                                                                              Object this$specification = this.getSpecification();
                                                                              Object other$specification = other.getSpecification();
                                                                              if (this$specification == null
                                                                                 ? other$specification == null
                                                                                 : this$specification.equals(other$specification)) {
                                                                                 Object this$model = this.getModel();
                                                                                 Object other$model = other.getModel();
                                                                                 if (this$model == null ? other$model == null : this$model.equals(other$model)) {
                                                                                    Object this$length = this.getLength();
                                                                                    Object other$length = other.getLength();
                                                                                    if (this$length == null
                                                                                       ? other$length == null
                                                                                       : this$length.equals(other$length)) {
                                                                                       Object this$thickness = this.getThickness();
                                                                                       Object other$thickness = other.getThickness();
                                                                                       if (this$thickness == null
                                                                                          ? other$thickness == null
                                                                                          : this$thickness.equals(other$thickness)) {
                                                                                          Object this$width = this.getWidth();
                                                                                          Object other$width = other.getWidth();
                                                                                          if (this$width == null
                                                                                             ? other$width == null
                                                                                             : this$width.equals(other$width)) {
                                                                                             Object this$accountingUnit = this.getAccountingUnit();
                                                                                             Object other$accountingUnit = other.getAccountingUnit();
                                                                                             if (this$accountingUnit == null
                                                                                                ? other$accountingUnit == null
                                                                                                : this$accountingUnit.equals(other$accountingUnit)) {
                                                                                                Object this$mete = this.getMete();
                                                                                                Object other$mete = other.getMete();
                                                                                                if (this$mete == null
                                                                                                   ? other$mete == null
                                                                                                   : this$mete.equals(other$mete)) {
                                                                                                   Object this$color = this.getColor();
                                                                                                   Object other$color = other.getColor();
                                                                                                   if (this$color == null
                                                                                                      ? other$color == null
                                                                                                      : this$color.equals(other$color)) {
                                                                                                      Object this$brand = this.getBrand();
                                                                                                      Object other$brand = other.getBrand();
                                                                                                      if (this$brand == null
                                                                                                         ? other$brand == null
                                                                                                         : this$brand.equals(other$brand)) {
                                                                                                         Object this$applyPurchaseSN = this.getApplyPurchaseSN();
                                                                                                         Object other$applyPurchaseSN = other.getApplyPurchaseSN();
                                                                                                         if (this$applyPurchaseSN == null
                                                                                                            ? other$applyPurchaseSN == null
                                                                                                            : this$applyPurchaseSN.equals(other$applyPurchaseSN)
                                                                                                            )
                                                                                                          {
                                                                                                            Object this$sectionSteelSpec = this.getSectionSteelSpec();
                                                                                                            Object other$sectionSteelSpec = other.getSectionSteelSpec();
                                                                                                            if (this$sectionSteelSpec == null
                                                                                                               ? other$sectionSteelSpec == null
                                                                                                               : this$sectionSteelSpec.equals(
                                                                                                                  other$sectionSteelSpec
                                                                                                               )) {
                                                                                                               Object this$doNotSectionSteelSpec = this.getDoNotSectionSteelSpec();
                                                                                                               Object other$doNotSectionSteelSpec = other.getDoNotSectionSteelSpec();
                                                                                                               if (this$doNotSectionSteelSpec == null
                                                                                                                  ? other$doNotSectionSteelSpec == null
                                                                                                                  : this$doNotSectionSteelSpec.equals(
                                                                                                                     other$doNotSectionSteelSpec
                                                                                                                  )) {
                                                                                                                  Object this$finishedGoodsTypeName = this.getFinishedGoodsTypeName();
                                                                                                                  Object other$finishedGoodsTypeName = other.getFinishedGoodsTypeName();
                                                                                                                  if (this$finishedGoodsTypeName == null
                                                                                                                     ? other$finishedGoodsTypeName == null
                                                                                                                     : this$finishedGoodsTypeName.equals(
                                                                                                                        other$finishedGoodsTypeName
                                                                                                                     )) {
                                                                                                                     Object this$manufacturedSpecification = this.getManufacturedSpecification();
                                                                                                                     Object other$manufacturedSpecification = other.getManufacturedSpecification();
                                                                                                                     if (this$manufacturedSpecification == null
                                                                                                                        ? other$manufacturedSpecification
                                                                                                                           == null
                                                                                                                        : this$manufacturedSpecification.equals(
                                                                                                                           other$manufacturedSpecification
                                                                                                                        )) {
                                                                                                                        Object this$weight = this.getWeight();
                                                                                                                        Object other$weight = other.getWeight();
                                                                                                                        if (this$weight == null
                                                                                                                           ? other$weight == null
                                                                                                                           : this$weight.equals(other$weight)) {
                                                                                                                           Object this$surfaceArea = this.getSurfaceArea();
                                                                                                                           Object other$surfaceArea = other.getSurfaceArea();
                                                                                                                           if (this$surfaceArea == null
                                                                                                                              ? other$surfaceArea == null
                                                                                                                              : this$surfaceArea.equals(
                                                                                                                                 other$surfaceArea
                                                                                                                              )) {
                                                                                                                              Object this$manufacturedName = this.getManufacturedName();
                                                                                                                              Object other$manufacturedName = other.getManufacturedName();
                                                                                                                              if (this$manufacturedName == null
                                                                                                                                 ? other$manufacturedName
                                                                                                                                    == null
                                                                                                                                 : this$manufacturedName.equals(
                                                                                                                                    other$manufacturedName
                                                                                                                                 )) {
                                                                                                                                 Object this$manufacturedSn = this.getManufacturedSn();
                                                                                                                                 Object other$manufacturedSn = other.getManufacturedSn();
                                                                                                                                 if (this$manufacturedSn
                                                                                                                                       == null
                                                                                                                                    ? other$manufacturedSn
                                                                                                                                       == null
                                                                                                                                    : this$manufacturedSn.equals(
                                                                                                                                       other$manufacturedSn
                                                                                                                                    )) {
                                                                                                                                    Object this$material = this.getMaterial();
                                                                                                                                    Object other$material = other.getMaterial();
                                                                                                                                    if (this$material == null
                                                                                                                                       ? other$material == null
                                                                                                                                       : this$material.equals(
                                                                                                                                          other$material
                                                                                                                                       )) {
                                                                                                                                       Object this$steelDensity = this.getSteelDensity();
                                                                                                                                       Object other$steelDensity = other.getSteelDensity();
                                                                                                                                       return this$steelDensity
                                                                                                                                             == null
                                                                                                                                          ? other$steelDensity
                                                                                                                                             == null
                                                                                                                                          : this$steelDensity.equals(
                                                                                                                                             other$steelDensity
                                                                                                                                          );
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
      return other instanceof PurchaseOrderDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactEnclosureId = this.getArtifactEnclosureId();
      result = result * 59 + ($artifactEnclosureId == null ? 43 : $artifactEnclosureId.hashCode());
      Object $destination = this.getDestination();
      result = result * 59 + ($destination == null ? 43 : $destination.hashCode());
      Object $pricingMethod = this.getPricingMethod();
      result = result * 59 + ($pricingMethod == null ? 43 : $pricingMethod.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $applyPurchaseId = this.getApplyPurchaseId();
      result = result * 59 + ($applyPurchaseId == null ? 43 : $applyPurchaseId.hashCode());
      Object $applyPurchaseDetailId = this.getApplyPurchaseDetailId();
      result = result * 59 + ($applyPurchaseDetailId == null ? 43 : $applyPurchaseDetailId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $boolOriginalDetail = this.getBoolOriginalDetail();
      result = result * 59 + ($boolOriginalDetail == null ? 43 : $boolOriginalDetail.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $manufacturedType = this.getManufacturedType();
      result = result * 59 + ($manufacturedType == null ? 43 : $manufacturedType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
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
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $applyPurchaseSN = this.getApplyPurchaseSN();
      result = result * 59 + ($applyPurchaseSN == null ? 43 : $applyPurchaseSN.hashCode());
      Object $sectionSteelSpec = this.getSectionSteelSpec();
      result = result * 59 + ($sectionSteelSpec == null ? 43 : $sectionSteelSpec.hashCode());
      Object $doNotSectionSteelSpec = this.getDoNotSectionSteelSpec();
      result = result * 59 + ($doNotSectionSteelSpec == null ? 43 : $doNotSectionSteelSpec.hashCode());
      Object $finishedGoodsTypeName = this.getFinishedGoodsTypeName();
      result = result * 59 + ($finishedGoodsTypeName == null ? 43 : $finishedGoodsTypeName.hashCode());
      Object $manufacturedSpecification = this.getManufacturedSpecification();
      result = result * 59 + ($manufacturedSpecification == null ? 43 : $manufacturedSpecification.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $manufacturedName = this.getManufacturedName();
      result = result * 59 + ($manufacturedName == null ? 43 : $manufacturedName.hashCode());
      Object $manufacturedSn = this.getManufacturedSn();
      result = result * 59 + ($manufacturedSn == null ? 43 : $manufacturedSn.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $steelDensity = this.getSteelDensity();
      return result * 59 + ($steelDensity == null ? 43 : $steelDensity.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseOrderDetailDTOParam(id="
         + this.getId()
         + ", artifactEnclosureId="
         + this.getArtifactEnclosureId()
         + ", quantity="
         + this.getQuantity()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", amount="
         + this.getAmount()
         + ", destination="
         + this.getDestination()
         + ", pricingMethod="
         + this.getPricingMethod()
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
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", color="
         + this.getColor()
         + ", brand="
         + this.getBrand()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", applyPurchaseId="
         + this.getApplyPurchaseId()
         + ", applyPurchaseSN="
         + this.getApplyPurchaseSN()
         + ", applyPurchaseDetailId="
         + this.getApplyPurchaseDetailId()
         + ", projectId="
         + this.getProjectId()
         + ", factoryId="
         + this.getFactoryId()
         + ", standardId="
         + this.getStandardId()
         + ", sectionSteelSpec="
         + this.getSectionSteelSpec()
         + ", doNotSectionSteelSpec="
         + this.getDoNotSectionSteelSpec()
         + ", boolOriginalDetail="
         + this.getBoolOriginalDetail()
         + ", workshopId="
         + this.getWorkshopId()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", finishedGoodsTypeName="
         + this.getFinishedGoodsTypeName()
         + ", manufacturedSpecification="
         + this.getManufacturedSpecification()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", weight="
         + this.getWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", manufacturedName="
         + this.getManufacturedName()
         + ", manufacturedType="
         + this.getManufacturedType()
         + ", manufacturedSn="
         + this.getManufacturedSn()
         + ", material="
         + this.getMaterial()
         + ", steelDensity="
         + this.getSteelDensity()
         + ")";
   }

   public PurchaseOrderDetailDTOParam() {
   }

   public PurchaseOrderDetailDTOParam(
      final Long id,
      final Long artifactEnclosureId,
      final BigDecimal quantity,
      final String measureUnit,
      final BigDecimal unitPrice,
      final BigDecimal amount,
      final Integer destination,
      final Integer pricingMethod,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final String classifySerialNumber,
      final String specification,
      final String model,
      final BigDecimal length,
      final BigDecimal thickness,
      final BigDecimal width,
      final String accountingUnit,
      final BigDecimal mete,
      final String color,
      final String brand,
      final Integer weightMeasurementMode,
      final Long applyPurchaseId,
      final String applyPurchaseSN,
      final Long applyPurchaseDetailId,
      final Long projectId,
      final Long factoryId,
      final Long standardId,
      final String sectionSteelSpec,
      final String doNotSectionSteelSpec,
      final Boolean boolOriginalDetail,
      final Long workshopId,
      final Integer wageQuotaType,
      final String finishedGoodsTypeName,
      final String manufacturedSpecification,
      final Long monomerId,
      final Long areaId,
      final BigDecimal weight,
      final BigDecimal surfaceArea,
      final String manufacturedName,
      final Integer manufacturedType,
      final String manufacturedSn,
      final String material,
      final BigDecimal steelDensity
   ) {
      this.id = id;
      this.artifactEnclosureId = artifactEnclosureId;
      this.quantity = quantity;
      this.measureUnit = measureUnit;
      this.unitPrice = unitPrice;
      this.amount = amount;
      this.destination = destination;
      this.pricingMethod = pricingMethod;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.classifySerialNumber = classifySerialNumber;
      this.specification = specification;
      this.model = model;
      this.length = length;
      this.thickness = thickness;
      this.width = width;
      this.accountingUnit = accountingUnit;
      this.mete = mete;
      this.color = color;
      this.brand = brand;
      this.weightMeasurementMode = weightMeasurementMode;
      this.applyPurchaseId = applyPurchaseId;
      this.applyPurchaseSN = applyPurchaseSN;
      this.applyPurchaseDetailId = applyPurchaseDetailId;
      this.projectId = projectId;
      this.factoryId = factoryId;
      this.standardId = standardId;
      this.sectionSteelSpec = sectionSteelSpec;
      this.doNotSectionSteelSpec = doNotSectionSteelSpec;
      this.boolOriginalDetail = boolOriginalDetail;
      this.workshopId = workshopId;
      this.wageQuotaType = wageQuotaType;
      this.finishedGoodsTypeName = finishedGoodsTypeName;
      this.manufacturedSpecification = manufacturedSpecification;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.weight = weight;
      this.surfaceArea = surfaceArea;
      this.manufacturedName = manufacturedName;
      this.manufacturedType = manufacturedType;
      this.manufacturedSn = manufacturedSn;
      this.material = material;
      this.steelDensity = steelDensity;
   }

   public static class PurchaseOrderDetailDTOParamBuilder {
      private Long id;
      private Long artifactEnclosureId;
      private BigDecimal quantity;
      private String measureUnit;
      private BigDecimal unitPrice;
      private BigDecimal amount;
      private Integer destination;
      private Integer pricingMethod;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private String classifySerialNumber;
      private String specification;
      private String model;
      private BigDecimal length;
      private BigDecimal thickness;
      private BigDecimal width;
      private String accountingUnit;
      private BigDecimal mete;
      private String color;
      private String brand;
      private Integer weightMeasurementMode;
      private Long applyPurchaseId;
      private String applyPurchaseSN;
      private Long applyPurchaseDetailId;
      private Long projectId;
      private Long factoryId;
      private Long standardId;
      private String sectionSteelSpec;
      private String doNotSectionSteelSpec;
      private Boolean boolOriginalDetail;
      private Long workshopId;
      private Integer wageQuotaType;
      private String finishedGoodsTypeName;
      private String manufacturedSpecification;
      private Long monomerId;
      private Long areaId;
      private BigDecimal weight;
      private BigDecimal surfaceArea;
      private String manufacturedName;
      private Integer manufacturedType;
      private String manufacturedSn;
      private String material;
      private BigDecimal steelDensity;

      PurchaseOrderDetailDTOParamBuilder() {
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder artifactEnclosureId(final Long artifactEnclosureId) {
         this.artifactEnclosureId = artifactEnclosureId;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder destination(final Integer destination) {
         this.destination = destination;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder pricingMethod(final Integer pricingMethod) {
         this.pricingMethod = pricingMethod;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder classifySerialNumber(final String classifySerialNumber) {
         this.classifySerialNumber = classifySerialNumber;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder model(final String model) {
         this.model = model;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder applyPurchaseId(final Long applyPurchaseId) {
         this.applyPurchaseId = applyPurchaseId;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder applyPurchaseSN(final String applyPurchaseSN) {
         this.applyPurchaseSN = applyPurchaseSN;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder applyPurchaseDetailId(final Long applyPurchaseDetailId) {
         this.applyPurchaseDetailId = applyPurchaseDetailId;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder sectionSteelSpec(final String sectionSteelSpec) {
         this.sectionSteelSpec = sectionSteelSpec;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder doNotSectionSteelSpec(final String doNotSectionSteelSpec) {
         this.doNotSectionSteelSpec = doNotSectionSteelSpec;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder boolOriginalDetail(final Boolean boolOriginalDetail) {
         this.boolOriginalDetail = boolOriginalDetail;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder finishedGoodsTypeName(final String finishedGoodsTypeName) {
         this.finishedGoodsTypeName = finishedGoodsTypeName;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder manufacturedSpecification(final String manufacturedSpecification) {
         this.manufacturedSpecification = manufacturedSpecification;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder manufacturedName(final String manufacturedName) {
         this.manufacturedName = manufacturedName;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder manufacturedType(final Integer manufacturedType) {
         this.manufacturedType = manufacturedType;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder manufacturedSn(final String manufacturedSn) {
         this.manufacturedSn = manufacturedSn;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder steelDensity(final BigDecimal steelDensity) {
         this.steelDensity = steelDensity;
         return this;
      }

      public PurchaseOrderDetailDTOParam build() {
         return new PurchaseOrderDetailDTOParam(
            this.id,
            this.artifactEnclosureId,
            this.quantity,
            this.measureUnit,
            this.unitPrice,
            this.amount,
            this.destination,
            this.pricingMethod,
            this.basicClass,
            this.classifyId,
            this.classifyName,
            this.classifySerialNumber,
            this.specification,
            this.model,
            this.length,
            this.thickness,
            this.width,
            this.accountingUnit,
            this.mete,
            this.color,
            this.brand,
            this.weightMeasurementMode,
            this.applyPurchaseId,
            this.applyPurchaseSN,
            this.applyPurchaseDetailId,
            this.projectId,
            this.factoryId,
            this.standardId,
            this.sectionSteelSpec,
            this.doNotSectionSteelSpec,
            this.boolOriginalDetail,
            this.workshopId,
            this.wageQuotaType,
            this.finishedGoodsTypeName,
            this.manufacturedSpecification,
            this.monomerId,
            this.areaId,
            this.weight,
            this.surfaceArea,
            this.manufacturedName,
            this.manufacturedType,
            this.manufacturedSn,
            this.material,
            this.steelDensity
         );
      }

      @Override
      public String toString() {
         return "PurchaseOrderDetailDTOParam.PurchaseOrderDetailDTOParamBuilder(id="
            + this.id
            + ", artifactEnclosureId="
            + this.artifactEnclosureId
            + ", quantity="
            + this.quantity
            + ", measureUnit="
            + this.measureUnit
            + ", unitPrice="
            + this.unitPrice
            + ", amount="
            + this.amount
            + ", destination="
            + this.destination
            + ", pricingMethod="
            + this.pricingMethod
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
            + ", thickness="
            + this.thickness
            + ", width="
            + this.width
            + ", accountingUnit="
            + this.accountingUnit
            + ", mete="
            + this.mete
            + ", color="
            + this.color
            + ", brand="
            + this.brand
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", applyPurchaseId="
            + this.applyPurchaseId
            + ", applyPurchaseSN="
            + this.applyPurchaseSN
            + ", applyPurchaseDetailId="
            + this.applyPurchaseDetailId
            + ", projectId="
            + this.projectId
            + ", factoryId="
            + this.factoryId
            + ", standardId="
            + this.standardId
            + ", sectionSteelSpec="
            + this.sectionSteelSpec
            + ", doNotSectionSteelSpec="
            + this.doNotSectionSteelSpec
            + ", boolOriginalDetail="
            + this.boolOriginalDetail
            + ", workshopId="
            + this.workshopId
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", finishedGoodsTypeName="
            + this.finishedGoodsTypeName
            + ", manufacturedSpecification="
            + this.manufacturedSpecification
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", weight="
            + this.weight
            + ", surfaceArea="
            + this.surfaceArea
            + ", manufacturedName="
            + this.manufacturedName
            + ", manufacturedType="
            + this.manufacturedType
            + ", manufacturedSn="
            + this.manufacturedSn
            + ", material="
            + this.material
            + ", steelDensity="
            + this.steelDensity
            + ")";
      }
   }
}
