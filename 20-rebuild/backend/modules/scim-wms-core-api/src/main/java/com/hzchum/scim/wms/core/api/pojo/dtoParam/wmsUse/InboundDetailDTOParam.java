package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public class InboundDetailDTOParam {
   private Long id;
   private Integer basicClass;
   private String classifyFullName;
   private Long classifyId;
   private String classifyName;
   private String classifySerialNumber;
   private Long projectId;
   private Long purchaseOrderDetailId;
   private Long purchaseDetailId;
   private String specification;
   private String specificationLabels;
   private Map<String, String> specificationMap;
   private BigDecimal unitPrice;
   private BigDecimal amount;
   private BigDecimal length;
   private BigDecimal quantity;
   private BigDecimal thickness;
   private BigDecimal weight;
   private BigDecimal width;
   private BigDecimal mete;
   private Long workshopId;
   private Long warehouseId;
   private String brand;
   private String heatNoAndBatchNo;
   private String color;
   private String remark;
   private Long mergeId;
   private Long applyPurchaseId;
   private BigDecimal amountExcludingVatFreight;
   private BigDecimal unitPriceExcludingVatFreight;
   private BigDecimal freight;
   private Long standardId;
   private String sectionSteelSpec;
   private String doNotSectionSteelSpec;
   @ApiModelProperty(name = "boolNestSurplus", value = "柏楚余料(只有来柏楚拍照的余料和套料剩下的余料此属性才有true)", notes = "柏楚余料")
   private Boolean boolNestSurplus;
   @ApiModelProperty(name = "taxRate", value = "税率(百分比)app余料拍照使用", notes = "税率(百分比)app余料拍照使用")
   private BigDecimal taxRate;
   private BigDecimal area;
   private String dxfUrl;
   private String imgUrl;
   private LocalDateTime realTime;
   @ApiModelProperty(name = "weightMeasurementMode", value = "重量计量方式[参考枚举 MeasureEnum]")
   private Integer weightMeasurementMode;
   private BigDecimal steelDensity;
   private Integer materialIsWhole = 1;
   private String measureUnit;
   private String accountingUnit;

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
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

   public String getClassifySerialNumber() {
      return this.classifySerialNumber;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getPurchaseOrderDetailId() {
      return this.purchaseOrderDetailId;
   }

   public Long getPurchaseDetailId() {
      return this.purchaseDetailId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getSpecificationLabels() {
      return this.specificationLabels;
   }

   public Map<String, String> getSpecificationMap() {
      return this.specificationMap;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getAmount() {
      return this.amount;
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

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getMergeId() {
      return this.mergeId;
   }

   public Long getApplyPurchaseId() {
      return this.applyPurchaseId;
   }

   public BigDecimal getAmountExcludingVatFreight() {
      return this.amountExcludingVatFreight;
   }

   public BigDecimal getUnitPriceExcludingVatFreight() {
      return this.unitPriceExcludingVatFreight;
   }

   public BigDecimal getFreight() {
      return this.freight;
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

   public Boolean getBoolNestSurplus() {
      return this.boolNestSurplus;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public String getDxfUrl() {
      return this.dxfUrl;
   }

   public String getImgUrl() {
      return this.imgUrl;
   }

   public LocalDateTime getRealTime() {
      return this.realTime;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public BigDecimal getSteelDensity() {
      return this.steelDensity;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
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

   public void setClassifySerialNumber(final String classifySerialNumber) {
      this.classifySerialNumber = classifySerialNumber;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setPurchaseOrderDetailId(final Long purchaseOrderDetailId) {
      this.purchaseOrderDetailId = purchaseOrderDetailId;
   }

   public void setPurchaseDetailId(final Long purchaseDetailId) {
      this.purchaseDetailId = purchaseDetailId;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setSpecificationLabels(final String specificationLabels) {
      this.specificationLabels = specificationLabels;
   }

   public void setSpecificationMap(final Map<String, String> specificationMap) {
      this.specificationMap = specificationMap;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
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

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setMergeId(final Long mergeId) {
      this.mergeId = mergeId;
   }

   public void setApplyPurchaseId(final Long applyPurchaseId) {
      this.applyPurchaseId = applyPurchaseId;
   }

   public void setAmountExcludingVatFreight(final BigDecimal amountExcludingVatFreight) {
      this.amountExcludingVatFreight = amountExcludingVatFreight;
   }

   public void setUnitPriceExcludingVatFreight(final BigDecimal unitPriceExcludingVatFreight) {
      this.unitPriceExcludingVatFreight = unitPriceExcludingVatFreight;
   }

   public void setFreight(final BigDecimal freight) {
      this.freight = freight;
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

   public void setBoolNestSurplus(final Boolean boolNestSurplus) {
      this.boolNestSurplus = boolNestSurplus;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setArea(final BigDecimal area) {
      this.area = area;
   }

   public void setDxfUrl(final String dxfUrl) {
      this.dxfUrl = dxfUrl;
   }

   public void setImgUrl(final String imgUrl) {
      this.imgUrl = imgUrl;
   }

   public void setRealTime(final LocalDateTime realTime) {
      this.realTime = realTime;
   }

   public void setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
   }

   public void setSteelDensity(final BigDecimal steelDensity) {
      this.steelDensity = steelDensity;
   }

   public void setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InboundDetailDTOParam)) {
         return false;
      }

      InboundDetailDTOParam other = (InboundDetailDTOParam)o;
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
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$purchaseOrderDetailId = this.getPurchaseOrderDetailId();
                  Object other$purchaseOrderDetailId = other.getPurchaseOrderDetailId();
                  if (this$purchaseOrderDetailId == null ? other$purchaseOrderDetailId == null : this$purchaseOrderDetailId.equals(other$purchaseOrderDetailId)
                     )
                   {
                     Object this$purchaseDetailId = this.getPurchaseDetailId();
                     Object other$purchaseDetailId = other.getPurchaseDetailId();
                     if (this$purchaseDetailId == null ? other$purchaseDetailId == null : this$purchaseDetailId.equals(other$purchaseDetailId)) {
                        Object this$workshopId = this.getWorkshopId();
                        Object other$workshopId = other.getWorkshopId();
                        if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                           Object this$warehouseId = this.getWarehouseId();
                           Object other$warehouseId = other.getWarehouseId();
                           if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                              Object this$mergeId = this.getMergeId();
                              Object other$mergeId = other.getMergeId();
                              if (this$mergeId == null ? other$mergeId == null : this$mergeId.equals(other$mergeId)) {
                                 Object this$applyPurchaseId = this.getApplyPurchaseId();
                                 Object other$applyPurchaseId = other.getApplyPurchaseId();
                                 if (this$applyPurchaseId == null ? other$applyPurchaseId == null : this$applyPurchaseId.equals(other$applyPurchaseId)) {
                                    Object this$standardId = this.getStandardId();
                                    Object other$standardId = other.getStandardId();
                                    if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                       Object this$boolNestSurplus = this.getBoolNestSurplus();
                                       Object other$boolNestSurplus = other.getBoolNestSurplus();
                                       if (this$boolNestSurplus == null ? other$boolNestSurplus == null : this$boolNestSurplus.equals(other$boolNestSurplus)) {
                                          Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                                          Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                                          if (this$weightMeasurementMode == null
                                             ? other$weightMeasurementMode == null
                                             : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                             Object this$materialIsWhole = this.getMaterialIsWhole();
                                             Object other$materialIsWhole = other.getMaterialIsWhole();
                                             if (this$materialIsWhole == null
                                                ? other$materialIsWhole == null
                                                : this$materialIsWhole.equals(other$materialIsWhole)) {
                                                Object this$classifyFullName = this.getClassifyFullName();
                                                Object other$classifyFullName = other.getClassifyFullName();
                                                if (this$classifyFullName == null
                                                   ? other$classifyFullName == null
                                                   : this$classifyFullName.equals(other$classifyFullName)) {
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
                                                         if (this$specification == null
                                                            ? other$specification == null
                                                            : this$specification.equals(other$specification)) {
                                                            Object this$specificationLabels = this.getSpecificationLabels();
                                                            Object other$specificationLabels = other.getSpecificationLabels();
                                                            if (this$specificationLabels == null
                                                               ? other$specificationLabels == null
                                                               : this$specificationLabels.equals(other$specificationLabels)) {
                                                               Object this$specificationMap = this.getSpecificationMap();
                                                               Object other$specificationMap = other.getSpecificationMap();
                                                               if (this$specificationMap == null
                                                                  ? other$specificationMap == null
                                                                  : this$specificationMap.equals(other$specificationMap)) {
                                                                  Object this$unitPrice = this.getUnitPrice();
                                                                  Object other$unitPrice = other.getUnitPrice();
                                                                  if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)
                                                                     )
                                                                   {
                                                                     Object this$amount = this.getAmount();
                                                                     Object other$amount = other.getAmount();
                                                                     if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                                        Object this$length = this.getLength();
                                                                        Object other$length = other.getLength();
                                                                        if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                           Object this$quantity = this.getQuantity();
                                                                           Object other$quantity = other.getQuantity();
                                                                           if (this$quantity == null
                                                                              ? other$quantity == null
                                                                              : this$quantity.equals(other$quantity)) {
                                                                              Object this$thickness = this.getThickness();
                                                                              Object other$thickness = other.getThickness();
                                                                              if (this$thickness == null
                                                                                 ? other$thickness == null
                                                                                 : this$thickness.equals(other$thickness)) {
                                                                                 Object this$weight = this.getWeight();
                                                                                 Object other$weight = other.getWeight();
                                                                                 if (this$weight == null
                                                                                    ? other$weight == null
                                                                                    : this$weight.equals(other$weight)) {
                                                                                    Object this$width = this.getWidth();
                                                                                    Object other$width = other.getWidth();
                                                                                    if (this$width == null
                                                                                       ? other$width == null
                                                                                       : this$width.equals(other$width)) {
                                                                                       Object this$mete = this.getMete();
                                                                                       Object other$mete = other.getMete();
                                                                                       if (this$mete == null
                                                                                          ? other$mete == null
                                                                                          : this$mete.equals(other$mete)) {
                                                                                          Object this$brand = this.getBrand();
                                                                                          Object other$brand = other.getBrand();
                                                                                          if (this$brand == null
                                                                                             ? other$brand == null
                                                                                             : this$brand.equals(other$brand)) {
                                                                                             Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                                             Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                                             if (this$heatNoAndBatchNo == null
                                                                                                ? other$heatNoAndBatchNo == null
                                                                                                : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                                                Object this$color = this.getColor();
                                                                                                Object other$color = other.getColor();
                                                                                                if (this$color == null
                                                                                                   ? other$color == null
                                                                                                   : this$color.equals(other$color)) {
                                                                                                   Object this$remark = this.getRemark();
                                                                                                   Object other$remark = other.getRemark();
                                                                                                   if (this$remark == null
                                                                                                      ? other$remark == null
                                                                                                      : this$remark.equals(other$remark)) {
                                                                                                      Object this$amountExcludingVatFreight = this.getAmountExcludingVatFreight();
                                                                                                      Object other$amountExcludingVatFreight = other.getAmountExcludingVatFreight();
                                                                                                      if (this$amountExcludingVatFreight == null
                                                                                                         ? other$amountExcludingVatFreight == null
                                                                                                         : this$amountExcludingVatFreight.equals(
                                                                                                            other$amountExcludingVatFreight
                                                                                                         )) {
                                                                                                         Object this$unitPriceExcludingVatFreight = this.getUnitPriceExcludingVatFreight();
                                                                                                         Object other$unitPriceExcludingVatFreight = other.getUnitPriceExcludingVatFreight();
                                                                                                         if (this$unitPriceExcludingVatFreight == null
                                                                                                            ? other$unitPriceExcludingVatFreight == null
                                                                                                            : this$unitPriceExcludingVatFreight.equals(
                                                                                                               other$unitPriceExcludingVatFreight
                                                                                                            )) {
                                                                                                            Object this$freight = this.getFreight();
                                                                                                            Object other$freight = other.getFreight();
                                                                                                            if (this$freight == null
                                                                                                               ? other$freight == null
                                                                                                               : this$freight.equals(other$freight)) {
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
                                                                                                                     Object this$taxRate = this.getTaxRate();
                                                                                                                     Object other$taxRate = other.getTaxRate();
                                                                                                                     if (this$taxRate == null
                                                                                                                        ? other$taxRate == null
                                                                                                                        : this$taxRate.equals(other$taxRate)) {
                                                                                                                        Object this$area = this.getArea();
                                                                                                                        Object other$area = other.getArea();
                                                                                                                        if (this$area == null
                                                                                                                           ? other$area == null
                                                                                                                           : this$area.equals(other$area)) {
                                                                                                                           Object this$dxfUrl = this.getDxfUrl();
                                                                                                                           Object other$dxfUrl = other.getDxfUrl();
                                                                                                                           if (this$dxfUrl == null
                                                                                                                              ? other$dxfUrl == null
                                                                                                                              : this$dxfUrl.equals(other$dxfUrl)
                                                                                                                              )
                                                                                                                            {
                                                                                                                              Object this$imgUrl = this.getImgUrl();
                                                                                                                              Object other$imgUrl = other.getImgUrl();
                                                                                                                              if (this$imgUrl == null
                                                                                                                                 ? other$imgUrl == null
                                                                                                                                 : this$imgUrl.equals(
                                                                                                                                    other$imgUrl
                                                                                                                                 )) {
                                                                                                                                 Object this$realTime = this.getRealTime();
                                                                                                                                 Object other$realTime = other.getRealTime();
                                                                                                                                 if (this$realTime == null
                                                                                                                                    ? other$realTime == null
                                                                                                                                    : this$realTime.equals(
                                                                                                                                       other$realTime
                                                                                                                                    )) {
                                                                                                                                    Object this$steelDensity = this.getSteelDensity();
                                                                                                                                    Object other$steelDensity = other.getSteelDensity();
                                                                                                                                    if (this$steelDensity
                                                                                                                                          == null
                                                                                                                                       ? other$steelDensity
                                                                                                                                          == null
                                                                                                                                       : this$steelDensity.equals(
                                                                                                                                          other$steelDensity
                                                                                                                                       )) {
                                                                                                                                       Object this$measureUnit = this.getMeasureUnit();
                                                                                                                                       Object other$measureUnit = other.getMeasureUnit();
                                                                                                                                       if (this$measureUnit
                                                                                                                                             == null
                                                                                                                                          ? other$measureUnit
                                                                                                                                             == null
                                                                                                                                          : this$measureUnit.equals(
                                                                                                                                             other$measureUnit
                                                                                                                                          )) {
                                                                                                                                          Object this$accountingUnit = this.getAccountingUnit();
                                                                                                                                          Object other$accountingUnit = other.getAccountingUnit();
                                                                                                                                          return this$accountingUnit
                                                                                                                                                == null
                                                                                                                                             ? other$accountingUnit
                                                                                                                                                == null
                                                                                                                                             : this$accountingUnit.equals(
                                                                                                                                                other$accountingUnit
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InboundDetailDTOParam;
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
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $purchaseOrderDetailId = this.getPurchaseOrderDetailId();
      result = result * 59 + ($purchaseOrderDetailId == null ? 43 : $purchaseOrderDetailId.hashCode());
      Object $purchaseDetailId = this.getPurchaseDetailId();
      result = result * 59 + ($purchaseDetailId == null ? 43 : $purchaseDetailId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $mergeId = this.getMergeId();
      result = result * 59 + ($mergeId == null ? 43 : $mergeId.hashCode());
      Object $applyPurchaseId = this.getApplyPurchaseId();
      result = result * 59 + ($applyPurchaseId == null ? 43 : $applyPurchaseId.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $boolNestSurplus = this.getBoolNestSurplus();
      result = result * 59 + ($boolNestSurplus == null ? 43 : $boolNestSurplus.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $classifyFullName = this.getClassifyFullName();
      result = result * 59 + ($classifyFullName == null ? 43 : $classifyFullName.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $classifySerialNumber = this.getClassifySerialNumber();
      result = result * 59 + ($classifySerialNumber == null ? 43 : $classifySerialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $specificationLabels = this.getSpecificationLabels();
      result = result * 59 + ($specificationLabels == null ? 43 : $specificationLabels.hashCode());
      Object $specificationMap = this.getSpecificationMap();
      result = result * 59 + ($specificationMap == null ? 43 : $specificationMap.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $amountExcludingVatFreight = this.getAmountExcludingVatFreight();
      result = result * 59 + ($amountExcludingVatFreight == null ? 43 : $amountExcludingVatFreight.hashCode());
      Object $unitPriceExcludingVatFreight = this.getUnitPriceExcludingVatFreight();
      result = result * 59 + ($unitPriceExcludingVatFreight == null ? 43 : $unitPriceExcludingVatFreight.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $sectionSteelSpec = this.getSectionSteelSpec();
      result = result * 59 + ($sectionSteelSpec == null ? 43 : $sectionSteelSpec.hashCode());
      Object $doNotSectionSteelSpec = this.getDoNotSectionSteelSpec();
      result = result * 59 + ($doNotSectionSteelSpec == null ? 43 : $doNotSectionSteelSpec.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $dxfUrl = this.getDxfUrl();
      result = result * 59 + ($dxfUrl == null ? 43 : $dxfUrl.hashCode());
      Object $imgUrl = this.getImgUrl();
      result = result * 59 + ($imgUrl == null ? 43 : $imgUrl.hashCode());
      Object $realTime = this.getRealTime();
      result = result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
      Object $steelDensity = this.getSteelDensity();
      result = result * 59 + ($steelDensity == null ? 43 : $steelDensity.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      return result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
   }

   @Override
   public String toString() {
      return "InboundDetailDTOParam(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyFullName="
         + this.getClassifyFullName()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", classifySerialNumber="
         + this.getClassifySerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", purchaseOrderDetailId="
         + this.getPurchaseOrderDetailId()
         + ", purchaseDetailId="
         + this.getPurchaseDetailId()
         + ", specification="
         + this.getSpecification()
         + ", specificationLabels="
         + this.getSpecificationLabels()
         + ", specificationMap="
         + this.getSpecificationMap()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", amount="
         + this.getAmount()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", thickness="
         + this.getThickness()
         + ", weight="
         + this.getWeight()
         + ", width="
         + this.getWidth()
         + ", mete="
         + this.getMete()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", remark="
         + this.getRemark()
         + ", mergeId="
         + this.getMergeId()
         + ", applyPurchaseId="
         + this.getApplyPurchaseId()
         + ", amountExcludingVatFreight="
         + this.getAmountExcludingVatFreight()
         + ", unitPriceExcludingVatFreight="
         + this.getUnitPriceExcludingVatFreight()
         + ", freight="
         + this.getFreight()
         + ", standardId="
         + this.getStandardId()
         + ", sectionSteelSpec="
         + this.getSectionSteelSpec()
         + ", doNotSectionSteelSpec="
         + this.getDoNotSectionSteelSpec()
         + ", boolNestSurplus="
         + this.getBoolNestSurplus()
         + ", taxRate="
         + this.getTaxRate()
         + ", area="
         + this.getArea()
         + ", dxfUrl="
         + this.getDxfUrl()
         + ", imgUrl="
         + this.getImgUrl()
         + ", realTime="
         + this.getRealTime()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", steelDensity="
         + this.getSteelDensity()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ")";
   }

   public InboundDetailDTOParam(
      final Long id,
      final Integer basicClass,
      final String classifyFullName,
      final Long classifyId,
      final String classifyName,
      final String classifySerialNumber,
      final Long projectId,
      final Long purchaseOrderDetailId,
      final Long purchaseDetailId,
      final String specification,
      final String specificationLabels,
      final Map<String, String> specificationMap,
      final BigDecimal unitPrice,
      final BigDecimal amount,
      final BigDecimal length,
      final BigDecimal quantity,
      final BigDecimal thickness,
      final BigDecimal weight,
      final BigDecimal width,
      final BigDecimal mete,
      final Long workshopId,
      final Long warehouseId,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final String remark,
      final Long mergeId,
      final Long applyPurchaseId,
      final BigDecimal amountExcludingVatFreight,
      final BigDecimal unitPriceExcludingVatFreight,
      final BigDecimal freight,
      final Long standardId,
      final String sectionSteelSpec,
      final String doNotSectionSteelSpec,
      final Boolean boolNestSurplus,
      final BigDecimal taxRate,
      final BigDecimal area,
      final String dxfUrl,
      final String imgUrl,
      final LocalDateTime realTime,
      final Integer weightMeasurementMode,
      final BigDecimal steelDensity,
      final Integer materialIsWhole,
      final String measureUnit,
      final String accountingUnit
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.classifyFullName = classifyFullName;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.classifySerialNumber = classifySerialNumber;
      this.projectId = projectId;
      this.purchaseOrderDetailId = purchaseOrderDetailId;
      this.purchaseDetailId = purchaseDetailId;
      this.specification = specification;
      this.specificationLabels = specificationLabels;
      this.specificationMap = specificationMap;
      this.unitPrice = unitPrice;
      this.amount = amount;
      this.length = length;
      this.quantity = quantity;
      this.thickness = thickness;
      this.weight = weight;
      this.width = width;
      this.mete = mete;
      this.workshopId = workshopId;
      this.warehouseId = warehouseId;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.remark = remark;
      this.mergeId = mergeId;
      this.applyPurchaseId = applyPurchaseId;
      this.amountExcludingVatFreight = amountExcludingVatFreight;
      this.unitPriceExcludingVatFreight = unitPriceExcludingVatFreight;
      this.freight = freight;
      this.standardId = standardId;
      this.sectionSteelSpec = sectionSteelSpec;
      this.doNotSectionSteelSpec = doNotSectionSteelSpec;
      this.boolNestSurplus = boolNestSurplus;
      this.taxRate = taxRate;
      this.area = area;
      this.dxfUrl = dxfUrl;
      this.imgUrl = imgUrl;
      this.realTime = realTime;
      this.weightMeasurementMode = weightMeasurementMode;
      this.steelDensity = steelDensity;
      this.materialIsWhole = materialIsWhole;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
   }

   public InboundDetailDTOParam() {
   }
}
