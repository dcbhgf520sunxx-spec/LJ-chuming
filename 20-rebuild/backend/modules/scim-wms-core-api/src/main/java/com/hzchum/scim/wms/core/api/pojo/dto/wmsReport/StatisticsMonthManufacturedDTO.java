package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class StatisticsMonthManufacturedDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   private Long id;
   @ApiModelProperty("月份 String类型yyyy-MM形式")
   private String monthStr;
   @ApiModelProperty("物料基础类型")
   private Integer basicClass;
   @ApiModelProperty("单体ID")
   private Long monomerId;
   @ApiModelProperty("区域ID")
   private Long areaId;
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("构件/围护ID")
   private Long artifactEnclosureId;
   @ApiModelProperty("制成品名称")
   private String manufacturedName;
   @ApiModelProperty("制成品编号")
   private String manufacturedSn;
   @ApiModelProperty("制成品材质")
   private String material;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("长度（mm）")
   private BigDecimal length;
   @ApiModelProperty("有效宽度（mm）")
   private BigDecimal width;
   @ApiModelProperty("厚度（mm）")
   private BigDecimal thickness;
   @ApiModelProperty("品牌")
   private String brand;
   @ApiModelProperty("颜色")
   private String color;
   @ApiModelProperty("单重（g）")
   private BigDecimal weight;
   @ApiModelProperty("单面积（mm²）")
   private BigDecimal surfaceArea;
   @ApiModelProperty("制成品计价方式 WageQuotaTypeEnum")
   private Integer wageQuotaType;
   @ApiModelProperty("税率(百分比)")
   private BigDecimal taxRate;
   @ApiModelProperty("不含税单价")
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty("含税单价")
   private BigDecimal unitPrice;
   @ApiModelProperty("入库总数量")
   private BigDecimal inboundTotalQuantity;
   @ApiModelProperty("入库总重（g）")
   private BigDecimal inboundTotalWeight;
   @ApiModelProperty("入库总长（mm）")
   private BigDecimal inboundTotalLength;
   @ApiModelProperty("入库总面积（mm²）")
   private BigDecimal inboundTotalArea;
   @ApiModelProperty("入库不含税总价")
   private BigDecimal inboundAmountExcludingVat;
   @ApiModelProperty("入库总价 含税")
   private BigDecimal inboundAmount;
   @ApiModelProperty("出库总数量")
   private BigDecimal outboundTotalQuantity;
   @ApiModelProperty("出库总重（g）")
   private BigDecimal outboundTotalWeight;
   @ApiModelProperty("出库总长（mm）")
   private BigDecimal outboundTotalLength;
   @ApiModelProperty("出库总面积（mm²）")
   private BigDecimal outboundTotalArea;
   @ApiModelProperty("出库不含税总价")
   private BigDecimal outboundAmountExcludingVat;
   @ApiModelProperty("出库总价 含税")
   private BigDecimal outboundAmount;
   @ApiModelProperty("退库总数量")
   private BigDecimal returnTotalQuantity;
   @ApiModelProperty("退库总重（g）")
   private BigDecimal returnTotalWeight;
   @ApiModelProperty("退库总长（mm）")
   private BigDecimal returnTotalLength;
   @ApiModelProperty("退库总面积（mm²）")
   private BigDecimal returnTotalArea;
   @ApiModelProperty("退库不含税总价")
   private BigDecimal returnAmountExcludingVat;
   @ApiModelProperty("退库总价 含税")
   private BigDecimal returnAmount;
   @ApiModelProperty("期初总数量")
   private BigDecimal beginMonthTotalQuantity;
   @ApiModelProperty("期初总重（g）")
   private BigDecimal beginMonthTotalWeight;
   @ApiModelProperty("期初总长（mm）")
   private BigDecimal beginMonthTotalLength;
   @ApiModelProperty("期初总面积（mm²）")
   private BigDecimal beginMonthTotalArea;
   @ApiModelProperty("期初不含税总价")
   private BigDecimal beginMonthAmountExcludingVat;
   @ApiModelProperty("期初总价 含税")
   private BigDecimal beginMonthAmount;
   @ApiModelProperty("期末总数量")
   private BigDecimal endMonthTotalQuantity;
   @ApiModelProperty("期末总重（g）")
   private BigDecimal endMonthTotalWeight;
   @ApiModelProperty("期末总长（mm）")
   private BigDecimal endMonthTotalLength;
   @ApiModelProperty("期末总面积（mm²）")
   private BigDecimal endMonthTotalArea;
   @ApiModelProperty("期末不含税总价")
   private BigDecimal endMonthAmountExcludingVat;
   @ApiModelProperty(value = "期末总价 含税", notes = "期末总价 含税")
   private BigDecimal endMonthAmount;
   @ApiModelProperty("备注")
   private String remark;

   public static StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder builder() {
      return new StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getMonthStr() {
      return this.monthStr;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getArtifactEnclosureId() {
      return this.artifactEnclosureId;
   }

   public String getManufacturedName() {
      return this.manufacturedName;
   }

   public String getManufacturedSn() {
      return this.manufacturedSn;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getInboundTotalQuantity() {
      return this.inboundTotalQuantity;
   }

   public BigDecimal getInboundTotalWeight() {
      return this.inboundTotalWeight;
   }

   public BigDecimal getInboundTotalLength() {
      return this.inboundTotalLength;
   }

   public BigDecimal getInboundTotalArea() {
      return this.inboundTotalArea;
   }

   public BigDecimal getInboundAmountExcludingVat() {
      return this.inboundAmountExcludingVat;
   }

   public BigDecimal getInboundAmount() {
      return this.inboundAmount;
   }

   public BigDecimal getOutboundTotalQuantity() {
      return this.outboundTotalQuantity;
   }

   public BigDecimal getOutboundTotalWeight() {
      return this.outboundTotalWeight;
   }

   public BigDecimal getOutboundTotalLength() {
      return this.outboundTotalLength;
   }

   public BigDecimal getOutboundTotalArea() {
      return this.outboundTotalArea;
   }

   public BigDecimal getOutboundAmountExcludingVat() {
      return this.outboundAmountExcludingVat;
   }

   public BigDecimal getOutboundAmount() {
      return this.outboundAmount;
   }

   public BigDecimal getReturnTotalQuantity() {
      return this.returnTotalQuantity;
   }

   public BigDecimal getReturnTotalWeight() {
      return this.returnTotalWeight;
   }

   public BigDecimal getReturnTotalLength() {
      return this.returnTotalLength;
   }

   public BigDecimal getReturnTotalArea() {
      return this.returnTotalArea;
   }

   public BigDecimal getReturnAmountExcludingVat() {
      return this.returnAmountExcludingVat;
   }

   public BigDecimal getReturnAmount() {
      return this.returnAmount;
   }

   public BigDecimal getBeginMonthTotalQuantity() {
      return this.beginMonthTotalQuantity;
   }

   public BigDecimal getBeginMonthTotalWeight() {
      return this.beginMonthTotalWeight;
   }

   public BigDecimal getBeginMonthTotalLength() {
      return this.beginMonthTotalLength;
   }

   public BigDecimal getBeginMonthTotalArea() {
      return this.beginMonthTotalArea;
   }

   public BigDecimal getBeginMonthAmountExcludingVat() {
      return this.beginMonthAmountExcludingVat;
   }

   public BigDecimal getBeginMonthAmount() {
      return this.beginMonthAmount;
   }

   public BigDecimal getEndMonthTotalQuantity() {
      return this.endMonthTotalQuantity;
   }

   public BigDecimal getEndMonthTotalWeight() {
      return this.endMonthTotalWeight;
   }

   public BigDecimal getEndMonthTotalLength() {
      return this.endMonthTotalLength;
   }

   public BigDecimal getEndMonthTotalArea() {
      return this.endMonthTotalArea;
   }

   public BigDecimal getEndMonthAmountExcludingVat() {
      return this.endMonthAmountExcludingVat;
   }

   public BigDecimal getEndMonthAmount() {
      return this.endMonthAmount;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMonthStr(final String monthStr) {
      this.monthStr = monthStr;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setArtifactEnclosureId(final Long artifactEnclosureId) {
      this.artifactEnclosureId = artifactEnclosureId;
   }

   public void setManufacturedName(final String manufacturedName) {
      this.manufacturedName = manufacturedName;
   }

   public void setManufacturedSn(final String manufacturedSn) {
      this.manufacturedSn = manufacturedSn;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setInboundTotalQuantity(final BigDecimal inboundTotalQuantity) {
      this.inboundTotalQuantity = inboundTotalQuantity;
   }

   public void setInboundTotalWeight(final BigDecimal inboundTotalWeight) {
      this.inboundTotalWeight = inboundTotalWeight;
   }

   public void setInboundTotalLength(final BigDecimal inboundTotalLength) {
      this.inboundTotalLength = inboundTotalLength;
   }

   public void setInboundTotalArea(final BigDecimal inboundTotalArea) {
      this.inboundTotalArea = inboundTotalArea;
   }

   public void setInboundAmountExcludingVat(final BigDecimal inboundAmountExcludingVat) {
      this.inboundAmountExcludingVat = inboundAmountExcludingVat;
   }

   public void setInboundAmount(final BigDecimal inboundAmount) {
      this.inboundAmount = inboundAmount;
   }

   public void setOutboundTotalQuantity(final BigDecimal outboundTotalQuantity) {
      this.outboundTotalQuantity = outboundTotalQuantity;
   }

   public void setOutboundTotalWeight(final BigDecimal outboundTotalWeight) {
      this.outboundTotalWeight = outboundTotalWeight;
   }

   public void setOutboundTotalLength(final BigDecimal outboundTotalLength) {
      this.outboundTotalLength = outboundTotalLength;
   }

   public void setOutboundTotalArea(final BigDecimal outboundTotalArea) {
      this.outboundTotalArea = outboundTotalArea;
   }

   public void setOutboundAmountExcludingVat(final BigDecimal outboundAmountExcludingVat) {
      this.outboundAmountExcludingVat = outboundAmountExcludingVat;
   }

   public void setOutboundAmount(final BigDecimal outboundAmount) {
      this.outboundAmount = outboundAmount;
   }

   public void setReturnTotalQuantity(final BigDecimal returnTotalQuantity) {
      this.returnTotalQuantity = returnTotalQuantity;
   }

   public void setReturnTotalWeight(final BigDecimal returnTotalWeight) {
      this.returnTotalWeight = returnTotalWeight;
   }

   public void setReturnTotalLength(final BigDecimal returnTotalLength) {
      this.returnTotalLength = returnTotalLength;
   }

   public void setReturnTotalArea(final BigDecimal returnTotalArea) {
      this.returnTotalArea = returnTotalArea;
   }

   public void setReturnAmountExcludingVat(final BigDecimal returnAmountExcludingVat) {
      this.returnAmountExcludingVat = returnAmountExcludingVat;
   }

   public void setReturnAmount(final BigDecimal returnAmount) {
      this.returnAmount = returnAmount;
   }

   public void setBeginMonthTotalQuantity(final BigDecimal beginMonthTotalQuantity) {
      this.beginMonthTotalQuantity = beginMonthTotalQuantity;
   }

   public void setBeginMonthTotalWeight(final BigDecimal beginMonthTotalWeight) {
      this.beginMonthTotalWeight = beginMonthTotalWeight;
   }

   public void setBeginMonthTotalLength(final BigDecimal beginMonthTotalLength) {
      this.beginMonthTotalLength = beginMonthTotalLength;
   }

   public void setBeginMonthTotalArea(final BigDecimal beginMonthTotalArea) {
      this.beginMonthTotalArea = beginMonthTotalArea;
   }

   public void setBeginMonthAmountExcludingVat(final BigDecimal beginMonthAmountExcludingVat) {
      this.beginMonthAmountExcludingVat = beginMonthAmountExcludingVat;
   }

   public void setBeginMonthAmount(final BigDecimal beginMonthAmount) {
      this.beginMonthAmount = beginMonthAmount;
   }

   public void setEndMonthTotalQuantity(final BigDecimal endMonthTotalQuantity) {
      this.endMonthTotalQuantity = endMonthTotalQuantity;
   }

   public void setEndMonthTotalWeight(final BigDecimal endMonthTotalWeight) {
      this.endMonthTotalWeight = endMonthTotalWeight;
   }

   public void setEndMonthTotalLength(final BigDecimal endMonthTotalLength) {
      this.endMonthTotalLength = endMonthTotalLength;
   }

   public void setEndMonthTotalArea(final BigDecimal endMonthTotalArea) {
      this.endMonthTotalArea = endMonthTotalArea;
   }

   public void setEndMonthAmountExcludingVat(final BigDecimal endMonthAmountExcludingVat) {
      this.endMonthAmountExcludingVat = endMonthAmountExcludingVat;
   }

   public void setEndMonthAmount(final BigDecimal endMonthAmount) {
      this.endMonthAmount = endMonthAmount;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StatisticsMonthManufacturedDTO)) {
         return false;
      }

      StatisticsMonthManufacturedDTO other = (StatisticsMonthManufacturedDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$artifactEnclosureId = this.getArtifactEnclosureId();
                     Object other$artifactEnclosureId = other.getArtifactEnclosureId();
                     if (this$artifactEnclosureId == null ? other$artifactEnclosureId == null : this$artifactEnclosureId.equals(other$artifactEnclosureId)) {
                        Object this$wageQuotaType = this.getWageQuotaType();
                        Object other$wageQuotaType = other.getWageQuotaType();
                        if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                           Object this$monthStr = this.getMonthStr();
                           Object other$monthStr = other.getMonthStr();
                           if (this$monthStr == null ? other$monthStr == null : this$monthStr.equals(other$monthStr)) {
                              Object this$manufacturedName = this.getManufacturedName();
                              Object other$manufacturedName = other.getManufacturedName();
                              if (this$manufacturedName == null ? other$manufacturedName == null : this$manufacturedName.equals(other$manufacturedName)) {
                                 Object this$manufacturedSn = this.getManufacturedSn();
                                 Object other$manufacturedSn = other.getManufacturedSn();
                                 if (this$manufacturedSn == null ? other$manufacturedSn == null : this$manufacturedSn.equals(other$manufacturedSn)) {
                                    Object this$material = this.getMaterial();
                                    Object other$material = other.getMaterial();
                                    if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                       Object this$specification = this.getSpecification();
                                       Object other$specification = other.getSpecification();
                                       if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                          Object this$length = this.getLength();
                                          Object other$length = other.getLength();
                                          if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                             Object this$width = this.getWidth();
                                             Object other$width = other.getWidth();
                                             if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                Object this$thickness = this.getThickness();
                                                Object other$thickness = other.getThickness();
                                                if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                   Object this$brand = this.getBrand();
                                                   Object other$brand = other.getBrand();
                                                   if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                      Object this$color = this.getColor();
                                                      Object other$color = other.getColor();
                                                      if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                         Object this$weight = this.getWeight();
                                                         Object other$weight = other.getWeight();
                                                         if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                            Object this$surfaceArea = this.getSurfaceArea();
                                                            Object other$surfaceArea = other.getSurfaceArea();
                                                            if (this$surfaceArea == null
                                                               ? other$surfaceArea == null
                                                               : this$surfaceArea.equals(other$surfaceArea)) {
                                                               Object this$taxRate = this.getTaxRate();
                                                               Object other$taxRate = other.getTaxRate();
                                                               if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                                  Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                                                  Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                                                  if (this$unitPriceExcludingVat == null
                                                                     ? other$unitPriceExcludingVat == null
                                                                     : this$unitPriceExcludingVat.equals(other$unitPriceExcludingVat)) {
                                                                     Object this$unitPrice = this.getUnitPrice();
                                                                     Object other$unitPrice = other.getUnitPrice();
                                                                     if (this$unitPrice == null
                                                                        ? other$unitPrice == null
                                                                        : this$unitPrice.equals(other$unitPrice)) {
                                                                        Object this$inboundTotalQuantity = this.getInboundTotalQuantity();
                                                                        Object other$inboundTotalQuantity = other.getInboundTotalQuantity();
                                                                        if (this$inboundTotalQuantity == null
                                                                           ? other$inboundTotalQuantity == null
                                                                           : this$inboundTotalQuantity.equals(other$inboundTotalQuantity)) {
                                                                           Object this$inboundTotalWeight = this.getInboundTotalWeight();
                                                                           Object other$inboundTotalWeight = other.getInboundTotalWeight();
                                                                           if (this$inboundTotalWeight == null
                                                                              ? other$inboundTotalWeight == null
                                                                              : this$inboundTotalWeight.equals(other$inboundTotalWeight)) {
                                                                              Object this$inboundTotalLength = this.getInboundTotalLength();
                                                                              Object other$inboundTotalLength = other.getInboundTotalLength();
                                                                              if (this$inboundTotalLength == null
                                                                                 ? other$inboundTotalLength == null
                                                                                 : this$inboundTotalLength.equals(other$inboundTotalLength)) {
                                                                                 Object this$inboundTotalArea = this.getInboundTotalArea();
                                                                                 Object other$inboundTotalArea = other.getInboundTotalArea();
                                                                                 if (this$inboundTotalArea == null
                                                                                    ? other$inboundTotalArea == null
                                                                                    : this$inboundTotalArea.equals(other$inboundTotalArea)) {
                                                                                    Object this$inboundAmountExcludingVat = this.getInboundAmountExcludingVat();
                                                                                    Object other$inboundAmountExcludingVat = other.getInboundAmountExcludingVat();
                                                                                    if (this$inboundAmountExcludingVat == null
                                                                                       ? other$inboundAmountExcludingVat == null
                                                                                       : this$inboundAmountExcludingVat.equals(other$inboundAmountExcludingVat)
                                                                                       )
                                                                                     {
                                                                                       Object this$inboundAmount = this.getInboundAmount();
                                                                                       Object other$inboundAmount = other.getInboundAmount();
                                                                                       if (this$inboundAmount == null
                                                                                          ? other$inboundAmount == null
                                                                                          : this$inboundAmount.equals(other$inboundAmount)) {
                                                                                          Object this$outboundTotalQuantity = this.getOutboundTotalQuantity();
                                                                                          Object other$outboundTotalQuantity = other.getOutboundTotalQuantity();
                                                                                          if (this$outboundTotalQuantity == null
                                                                                             ? other$outboundTotalQuantity == null
                                                                                             : this$outboundTotalQuantity.equals(other$outboundTotalQuantity)) {
                                                                                             Object this$outboundTotalWeight = this.getOutboundTotalWeight();
                                                                                             Object other$outboundTotalWeight = other.getOutboundTotalWeight();
                                                                                             if (this$outboundTotalWeight == null
                                                                                                ? other$outboundTotalWeight == null
                                                                                                : this$outboundTotalWeight.equals(other$outboundTotalWeight)) {
                                                                                                Object this$outboundTotalLength = this.getOutboundTotalLength();
                                                                                                Object other$outboundTotalLength = other.getOutboundTotalLength();
                                                                                                if (this$outboundTotalLength == null
                                                                                                   ? other$outboundTotalLength == null
                                                                                                   : this$outboundTotalLength.equals(other$outboundTotalLength)
                                                                                                   )
                                                                                                 {
                                                                                                   Object this$outboundTotalArea = this.getOutboundTotalArea();
                                                                                                   Object other$outboundTotalArea = other.getOutboundTotalArea();
                                                                                                   if (this$outboundTotalArea == null
                                                                                                      ? other$outboundTotalArea == null
                                                                                                      : this$outboundTotalArea.equals(other$outboundTotalArea)) {
                                                                                                      Object this$outboundAmountExcludingVat = this.getOutboundAmountExcludingVat();
                                                                                                      Object other$outboundAmountExcludingVat = other.getOutboundAmountExcludingVat();
                                                                                                      if (this$outboundAmountExcludingVat == null
                                                                                                         ? other$outboundAmountExcludingVat == null
                                                                                                         : this$outboundAmountExcludingVat.equals(
                                                                                                            other$outboundAmountExcludingVat
                                                                                                         )) {
                                                                                                         Object this$outboundAmount = this.getOutboundAmount();
                                                                                                         Object other$outboundAmount = other.getOutboundAmount();
                                                                                                         if (this$outboundAmount == null
                                                                                                            ? other$outboundAmount == null
                                                                                                            : this$outboundAmount.equals(other$outboundAmount)) {
                                                                                                            Object this$returnTotalQuantity = this.getReturnTotalQuantity();
                                                                                                            Object other$returnTotalQuantity = other.getReturnTotalQuantity();
                                                                                                            if (this$returnTotalQuantity == null
                                                                                                               ? other$returnTotalQuantity == null
                                                                                                               : this$returnTotalQuantity.equals(
                                                                                                                  other$returnTotalQuantity
                                                                                                               )) {
                                                                                                               Object this$returnTotalWeight = this.getReturnTotalWeight();
                                                                                                               Object other$returnTotalWeight = other.getReturnTotalWeight();
                                                                                                               if (this$returnTotalWeight == null
                                                                                                                  ? other$returnTotalWeight == null
                                                                                                                  : this$returnTotalWeight.equals(
                                                                                                                     other$returnTotalWeight
                                                                                                                  )) {
                                                                                                                  Object this$returnTotalLength = this.getReturnTotalLength();
                                                                                                                  Object other$returnTotalLength = other.getReturnTotalLength();
                                                                                                                  if (this$returnTotalLength == null
                                                                                                                     ? other$returnTotalLength == null
                                                                                                                     : this$returnTotalLength.equals(
                                                                                                                        other$returnTotalLength
                                                                                                                     )) {
                                                                                                                     Object this$returnTotalArea = this.getReturnTotalArea();
                                                                                                                     Object other$returnTotalArea = other.getReturnTotalArea();
                                                                                                                     if (this$returnTotalArea == null
                                                                                                                        ? other$returnTotalArea == null
                                                                                                                        : this$returnTotalArea.equals(
                                                                                                                           other$returnTotalArea
                                                                                                                        )) {
                                                                                                                        Object this$returnAmountExcludingVat = this.getReturnAmountExcludingVat();
                                                                                                                        Object other$returnAmountExcludingVat = other.getReturnAmountExcludingVat();
                                                                                                                        if (this$returnAmountExcludingVat
                                                                                                                              == null
                                                                                                                           ? other$returnAmountExcludingVat
                                                                                                                              == null
                                                                                                                           : this$returnAmountExcludingVat.equals(
                                                                                                                              other$returnAmountExcludingVat
                                                                                                                           )) {
                                                                                                                           Object this$returnAmount = this.getReturnAmount();
                                                                                                                           Object other$returnAmount = other.getReturnAmount();
                                                                                                                           if (this$returnAmount == null
                                                                                                                              ? other$returnAmount == null
                                                                                                                              : this$returnAmount.equals(
                                                                                                                                 other$returnAmount
                                                                                                                              )) {
                                                                                                                              Object this$beginMonthTotalQuantity = this.getBeginMonthTotalQuantity();
                                                                                                                              Object other$beginMonthTotalQuantity = other.getBeginMonthTotalQuantity();
                                                                                                                              if (this$beginMonthTotalQuantity
                                                                                                                                    == null
                                                                                                                                 ? other$beginMonthTotalQuantity
                                                                                                                                    == null
                                                                                                                                 : this$beginMonthTotalQuantity.equals(
                                                                                                                                    other$beginMonthTotalQuantity
                                                                                                                                 )) {
                                                                                                                                 Object this$beginMonthTotalWeight = this.getBeginMonthTotalWeight();
                                                                                                                                 Object other$beginMonthTotalWeight = other.getBeginMonthTotalWeight();
                                                                                                                                 if (this$beginMonthTotalWeight
                                                                                                                                       == null
                                                                                                                                    ? other$beginMonthTotalWeight
                                                                                                                                       == null
                                                                                                                                    : this$beginMonthTotalWeight.equals(
                                                                                                                                       other$beginMonthTotalWeight
                                                                                                                                    )) {
                                                                                                                                    Object this$beginMonthTotalLength = this.getBeginMonthTotalLength();
                                                                                                                                    Object other$beginMonthTotalLength = other.getBeginMonthTotalLength();
                                                                                                                                    if (this$beginMonthTotalLength
                                                                                                                                          == null
                                                                                                                                       ? other$beginMonthTotalLength
                                                                                                                                          == null
                                                                                                                                       : this$beginMonthTotalLength.equals(
                                                                                                                                          other$beginMonthTotalLength
                                                                                                                                       )) {
                                                                                                                                       Object this$beginMonthTotalArea = this.getBeginMonthTotalArea();
                                                                                                                                       Object other$beginMonthTotalArea = other.getBeginMonthTotalArea();
                                                                                                                                       if (this$beginMonthTotalArea
                                                                                                                                             == null
                                                                                                                                          ? other$beginMonthTotalArea
                                                                                                                                             == null
                                                                                                                                          : this$beginMonthTotalArea.equals(
                                                                                                                                             other$beginMonthTotalArea
                                                                                                                                          )) {
                                                                                                                                          Object this$beginMonthAmountExcludingVat = this.getBeginMonthAmountExcludingVat();
                                                                                                                                          Object other$beginMonthAmountExcludingVat = other.getBeginMonthAmountExcludingVat();
                                                                                                                                          if (this$beginMonthAmountExcludingVat
                                                                                                                                                == null
                                                                                                                                             ? other$beginMonthAmountExcludingVat
                                                                                                                                                == null
                                                                                                                                             : this$beginMonthAmountExcludingVat.equals(
                                                                                                                                                other$beginMonthAmountExcludingVat
                                                                                                                                             )) {
                                                                                                                                             Object this$beginMonthAmount = this.getBeginMonthAmount();
                                                                                                                                             Object other$beginMonthAmount = other.getBeginMonthAmount();
                                                                                                                                             if (this$beginMonthAmount
                                                                                                                                                   == null
                                                                                                                                                ? other$beginMonthAmount
                                                                                                                                                   == null
                                                                                                                                                : this$beginMonthAmount.equals(
                                                                                                                                                   other$beginMonthAmount
                                                                                                                                                )) {
                                                                                                                                                Object this$endMonthTotalQuantity = this.getEndMonthTotalQuantity();
                                                                                                                                                Object other$endMonthTotalQuantity = other.getEndMonthTotalQuantity();
                                                                                                                                                if (this$endMonthTotalQuantity
                                                                                                                                                      == null
                                                                                                                                                   ? other$endMonthTotalQuantity
                                                                                                                                                      == null
                                                                                                                                                   : this$endMonthTotalQuantity.equals(
                                                                                                                                                      other$endMonthTotalQuantity
                                                                                                                                                   )) {
                                                                                                                                                   Object this$endMonthTotalWeight = this.getEndMonthTotalWeight();
                                                                                                                                                   Object other$endMonthTotalWeight = other.getEndMonthTotalWeight();
                                                                                                                                                   if (this$endMonthTotalWeight
                                                                                                                                                         == null
                                                                                                                                                      ? other$endMonthTotalWeight
                                                                                                                                                         == null
                                                                                                                                                      : this$endMonthTotalWeight.equals(
                                                                                                                                                         other$endMonthTotalWeight
                                                                                                                                                      )) {
                                                                                                                                                      Object this$endMonthTotalLength = this.getEndMonthTotalLength();
                                                                                                                                                      Object other$endMonthTotalLength = other.getEndMonthTotalLength();
                                                                                                                                                      if (this$endMonthTotalLength
                                                                                                                                                            == null
                                                                                                                                                         ? other$endMonthTotalLength
                                                                                                                                                            == null
                                                                                                                                                         : this$endMonthTotalLength.equals(
                                                                                                                                                            other$endMonthTotalLength
                                                                                                                                                         )) {
                                                                                                                                                         Object this$endMonthTotalArea = this.getEndMonthTotalArea();
                                                                                                                                                         Object other$endMonthTotalArea = other.getEndMonthTotalArea();
                                                                                                                                                         if (this$endMonthTotalArea
                                                                                                                                                               == null
                                                                                                                                                            ? other$endMonthTotalArea
                                                                                                                                                               == null
                                                                                                                                                            : this$endMonthTotalArea.equals(
                                                                                                                                                               other$endMonthTotalArea
                                                                                                                                                            )) {
                                                                                                                                                            Object this$endMonthAmountExcludingVat = this.getEndMonthAmountExcludingVat();
                                                                                                                                                            Object other$endMonthAmountExcludingVat = other.getEndMonthAmountExcludingVat();
                                                                                                                                                            if (this$endMonthAmountExcludingVat
                                                                                                                                                                  == null
                                                                                                                                                               ? other$endMonthAmountExcludingVat
                                                                                                                                                                  == null
                                                                                                                                                               : this$endMonthAmountExcludingVat.equals(
                                                                                                                                                                  other$endMonthAmountExcludingVat
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$endMonthAmount = this.getEndMonthAmount();
                                                                                                                                                               Object other$endMonthAmount = other.getEndMonthAmount();
                                                                                                                                                               if (this$endMonthAmount
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$endMonthAmount
                                                                                                                                                                     == null
                                                                                                                                                                  : this$endMonthAmount.equals(
                                                                                                                                                                     other$endMonthAmount
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$remark = this.getRemark();
                                                                                                                                                                  Object other$remark = other.getRemark();
                                                                                                                                                                  return this$remark
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$remark
                                                                                                                                                                        == null
                                                                                                                                                                     : this$remark.equals(
                                                                                                                                                                        other$remark
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
      return other instanceof StatisticsMonthManufacturedDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $artifactEnclosureId = this.getArtifactEnclosureId();
      result = result * 59 + ($artifactEnclosureId == null ? 43 : $artifactEnclosureId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $monthStr = this.getMonthStr();
      result = result * 59 + ($monthStr == null ? 43 : $monthStr.hashCode());
      Object $manufacturedName = this.getManufacturedName();
      result = result * 59 + ($manufacturedName == null ? 43 : $manufacturedName.hashCode());
      Object $manufacturedSn = this.getManufacturedSn();
      result = result * 59 + ($manufacturedSn == null ? 43 : $manufacturedSn.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $inboundTotalQuantity = this.getInboundTotalQuantity();
      result = result * 59 + ($inboundTotalQuantity == null ? 43 : $inboundTotalQuantity.hashCode());
      Object $inboundTotalWeight = this.getInboundTotalWeight();
      result = result * 59 + ($inboundTotalWeight == null ? 43 : $inboundTotalWeight.hashCode());
      Object $inboundTotalLength = this.getInboundTotalLength();
      result = result * 59 + ($inboundTotalLength == null ? 43 : $inboundTotalLength.hashCode());
      Object $inboundTotalArea = this.getInboundTotalArea();
      result = result * 59 + ($inboundTotalArea == null ? 43 : $inboundTotalArea.hashCode());
      Object $inboundAmountExcludingVat = this.getInboundAmountExcludingVat();
      result = result * 59 + ($inboundAmountExcludingVat == null ? 43 : $inboundAmountExcludingVat.hashCode());
      Object $inboundAmount = this.getInboundAmount();
      result = result * 59 + ($inboundAmount == null ? 43 : $inboundAmount.hashCode());
      Object $outboundTotalQuantity = this.getOutboundTotalQuantity();
      result = result * 59 + ($outboundTotalQuantity == null ? 43 : $outboundTotalQuantity.hashCode());
      Object $outboundTotalWeight = this.getOutboundTotalWeight();
      result = result * 59 + ($outboundTotalWeight == null ? 43 : $outboundTotalWeight.hashCode());
      Object $outboundTotalLength = this.getOutboundTotalLength();
      result = result * 59 + ($outboundTotalLength == null ? 43 : $outboundTotalLength.hashCode());
      Object $outboundTotalArea = this.getOutboundTotalArea();
      result = result * 59 + ($outboundTotalArea == null ? 43 : $outboundTotalArea.hashCode());
      Object $outboundAmountExcludingVat = this.getOutboundAmountExcludingVat();
      result = result * 59 + ($outboundAmountExcludingVat == null ? 43 : $outboundAmountExcludingVat.hashCode());
      Object $outboundAmount = this.getOutboundAmount();
      result = result * 59 + ($outboundAmount == null ? 43 : $outboundAmount.hashCode());
      Object $returnTotalQuantity = this.getReturnTotalQuantity();
      result = result * 59 + ($returnTotalQuantity == null ? 43 : $returnTotalQuantity.hashCode());
      Object $returnTotalWeight = this.getReturnTotalWeight();
      result = result * 59 + ($returnTotalWeight == null ? 43 : $returnTotalWeight.hashCode());
      Object $returnTotalLength = this.getReturnTotalLength();
      result = result * 59 + ($returnTotalLength == null ? 43 : $returnTotalLength.hashCode());
      Object $returnTotalArea = this.getReturnTotalArea();
      result = result * 59 + ($returnTotalArea == null ? 43 : $returnTotalArea.hashCode());
      Object $returnAmountExcludingVat = this.getReturnAmountExcludingVat();
      result = result * 59 + ($returnAmountExcludingVat == null ? 43 : $returnAmountExcludingVat.hashCode());
      Object $returnAmount = this.getReturnAmount();
      result = result * 59 + ($returnAmount == null ? 43 : $returnAmount.hashCode());
      Object $beginMonthTotalQuantity = this.getBeginMonthTotalQuantity();
      result = result * 59 + ($beginMonthTotalQuantity == null ? 43 : $beginMonthTotalQuantity.hashCode());
      Object $beginMonthTotalWeight = this.getBeginMonthTotalWeight();
      result = result * 59 + ($beginMonthTotalWeight == null ? 43 : $beginMonthTotalWeight.hashCode());
      Object $beginMonthTotalLength = this.getBeginMonthTotalLength();
      result = result * 59 + ($beginMonthTotalLength == null ? 43 : $beginMonthTotalLength.hashCode());
      Object $beginMonthTotalArea = this.getBeginMonthTotalArea();
      result = result * 59 + ($beginMonthTotalArea == null ? 43 : $beginMonthTotalArea.hashCode());
      Object $beginMonthAmountExcludingVat = this.getBeginMonthAmountExcludingVat();
      result = result * 59 + ($beginMonthAmountExcludingVat == null ? 43 : $beginMonthAmountExcludingVat.hashCode());
      Object $beginMonthAmount = this.getBeginMonthAmount();
      result = result * 59 + ($beginMonthAmount == null ? 43 : $beginMonthAmount.hashCode());
      Object $endMonthTotalQuantity = this.getEndMonthTotalQuantity();
      result = result * 59 + ($endMonthTotalQuantity == null ? 43 : $endMonthTotalQuantity.hashCode());
      Object $endMonthTotalWeight = this.getEndMonthTotalWeight();
      result = result * 59 + ($endMonthTotalWeight == null ? 43 : $endMonthTotalWeight.hashCode());
      Object $endMonthTotalLength = this.getEndMonthTotalLength();
      result = result * 59 + ($endMonthTotalLength == null ? 43 : $endMonthTotalLength.hashCode());
      Object $endMonthTotalArea = this.getEndMonthTotalArea();
      result = result * 59 + ($endMonthTotalArea == null ? 43 : $endMonthTotalArea.hashCode());
      Object $endMonthAmountExcludingVat = this.getEndMonthAmountExcludingVat();
      result = result * 59 + ($endMonthAmountExcludingVat == null ? 43 : $endMonthAmountExcludingVat.hashCode());
      Object $endMonthAmount = this.getEndMonthAmount();
      result = result * 59 + ($endMonthAmount == null ? 43 : $endMonthAmount.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "StatisticsMonthManufacturedDTO(id="
         + this.getId()
         + ", monthStr="
         + this.getMonthStr()
         + ", basicClass="
         + this.getBasicClass()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", projectId="
         + this.getProjectId()
         + ", artifactEnclosureId="
         + this.getArtifactEnclosureId()
         + ", manufacturedName="
         + this.getManufacturedName()
         + ", manufacturedSn="
         + this.getManufacturedSn()
         + ", material="
         + this.getMaterial()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", weight="
         + this.getWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", taxRate="
         + this.getTaxRate()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", inboundTotalQuantity="
         + this.getInboundTotalQuantity()
         + ", inboundTotalWeight="
         + this.getInboundTotalWeight()
         + ", inboundTotalLength="
         + this.getInboundTotalLength()
         + ", inboundTotalArea="
         + this.getInboundTotalArea()
         + ", inboundAmountExcludingVat="
         + this.getInboundAmountExcludingVat()
         + ", inboundAmount="
         + this.getInboundAmount()
         + ", outboundTotalQuantity="
         + this.getOutboundTotalQuantity()
         + ", outboundTotalWeight="
         + this.getOutboundTotalWeight()
         + ", outboundTotalLength="
         + this.getOutboundTotalLength()
         + ", outboundTotalArea="
         + this.getOutboundTotalArea()
         + ", outboundAmountExcludingVat="
         + this.getOutboundAmountExcludingVat()
         + ", outboundAmount="
         + this.getOutboundAmount()
         + ", returnTotalQuantity="
         + this.getReturnTotalQuantity()
         + ", returnTotalWeight="
         + this.getReturnTotalWeight()
         + ", returnTotalLength="
         + this.getReturnTotalLength()
         + ", returnTotalArea="
         + this.getReturnTotalArea()
         + ", returnAmountExcludingVat="
         + this.getReturnAmountExcludingVat()
         + ", returnAmount="
         + this.getReturnAmount()
         + ", beginMonthTotalQuantity="
         + this.getBeginMonthTotalQuantity()
         + ", beginMonthTotalWeight="
         + this.getBeginMonthTotalWeight()
         + ", beginMonthTotalLength="
         + this.getBeginMonthTotalLength()
         + ", beginMonthTotalArea="
         + this.getBeginMonthTotalArea()
         + ", beginMonthAmountExcludingVat="
         + this.getBeginMonthAmountExcludingVat()
         + ", beginMonthAmount="
         + this.getBeginMonthAmount()
         + ", endMonthTotalQuantity="
         + this.getEndMonthTotalQuantity()
         + ", endMonthTotalWeight="
         + this.getEndMonthTotalWeight()
         + ", endMonthTotalLength="
         + this.getEndMonthTotalLength()
         + ", endMonthTotalArea="
         + this.getEndMonthTotalArea()
         + ", endMonthAmountExcludingVat="
         + this.getEndMonthAmountExcludingVat()
         + ", endMonthAmount="
         + this.getEndMonthAmount()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public StatisticsMonthManufacturedDTO(
      final Long id,
      final String monthStr,
      final Integer basicClass,
      final Long monomerId,
      final Long areaId,
      final Long projectId,
      final Long artifactEnclosureId,
      final String manufacturedName,
      final String manufacturedSn,
      final String material,
      final String specification,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final String brand,
      final String color,
      final BigDecimal weight,
      final BigDecimal surfaceArea,
      final Integer wageQuotaType,
      final BigDecimal taxRate,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal unitPrice,
      final BigDecimal inboundTotalQuantity,
      final BigDecimal inboundTotalWeight,
      final BigDecimal inboundTotalLength,
      final BigDecimal inboundTotalArea,
      final BigDecimal inboundAmountExcludingVat,
      final BigDecimal inboundAmount,
      final BigDecimal outboundTotalQuantity,
      final BigDecimal outboundTotalWeight,
      final BigDecimal outboundTotalLength,
      final BigDecimal outboundTotalArea,
      final BigDecimal outboundAmountExcludingVat,
      final BigDecimal outboundAmount,
      final BigDecimal returnTotalQuantity,
      final BigDecimal returnTotalWeight,
      final BigDecimal returnTotalLength,
      final BigDecimal returnTotalArea,
      final BigDecimal returnAmountExcludingVat,
      final BigDecimal returnAmount,
      final BigDecimal beginMonthTotalQuantity,
      final BigDecimal beginMonthTotalWeight,
      final BigDecimal beginMonthTotalLength,
      final BigDecimal beginMonthTotalArea,
      final BigDecimal beginMonthAmountExcludingVat,
      final BigDecimal beginMonthAmount,
      final BigDecimal endMonthTotalQuantity,
      final BigDecimal endMonthTotalWeight,
      final BigDecimal endMonthTotalLength,
      final BigDecimal endMonthTotalArea,
      final BigDecimal endMonthAmountExcludingVat,
      final BigDecimal endMonthAmount,
      final String remark
   ) {
      this.id = id;
      this.monthStr = monthStr;
      this.basicClass = basicClass;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.projectId = projectId;
      this.artifactEnclosureId = artifactEnclosureId;
      this.manufacturedName = manufacturedName;
      this.manufacturedSn = manufacturedSn;
      this.material = material;
      this.specification = specification;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.brand = brand;
      this.color = color;
      this.weight = weight;
      this.surfaceArea = surfaceArea;
      this.wageQuotaType = wageQuotaType;
      this.taxRate = taxRate;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.unitPrice = unitPrice;
      this.inboundTotalQuantity = inboundTotalQuantity;
      this.inboundTotalWeight = inboundTotalWeight;
      this.inboundTotalLength = inboundTotalLength;
      this.inboundTotalArea = inboundTotalArea;
      this.inboundAmountExcludingVat = inboundAmountExcludingVat;
      this.inboundAmount = inboundAmount;
      this.outboundTotalQuantity = outboundTotalQuantity;
      this.outboundTotalWeight = outboundTotalWeight;
      this.outboundTotalLength = outboundTotalLength;
      this.outboundTotalArea = outboundTotalArea;
      this.outboundAmountExcludingVat = outboundAmountExcludingVat;
      this.outboundAmount = outboundAmount;
      this.returnTotalQuantity = returnTotalQuantity;
      this.returnTotalWeight = returnTotalWeight;
      this.returnTotalLength = returnTotalLength;
      this.returnTotalArea = returnTotalArea;
      this.returnAmountExcludingVat = returnAmountExcludingVat;
      this.returnAmount = returnAmount;
      this.beginMonthTotalQuantity = beginMonthTotalQuantity;
      this.beginMonthTotalWeight = beginMonthTotalWeight;
      this.beginMonthTotalLength = beginMonthTotalLength;
      this.beginMonthTotalArea = beginMonthTotalArea;
      this.beginMonthAmountExcludingVat = beginMonthAmountExcludingVat;
      this.beginMonthAmount = beginMonthAmount;
      this.endMonthTotalQuantity = endMonthTotalQuantity;
      this.endMonthTotalWeight = endMonthTotalWeight;
      this.endMonthTotalLength = endMonthTotalLength;
      this.endMonthTotalArea = endMonthTotalArea;
      this.endMonthAmountExcludingVat = endMonthAmountExcludingVat;
      this.endMonthAmount = endMonthAmount;
      this.remark = remark;
   }

   public StatisticsMonthManufacturedDTO() {
   }

   public static class StatisticsMonthManufacturedDTOBuilder {
      private Long id;
      private String monthStr;
      private Integer basicClass;
      private Long monomerId;
      private Long areaId;
      private Long projectId;
      private Long artifactEnclosureId;
      private String manufacturedName;
      private String manufacturedSn;
      private String material;
      private String specification;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private String brand;
      private String color;
      private BigDecimal weight;
      private BigDecimal surfaceArea;
      private Integer wageQuotaType;
      private BigDecimal taxRate;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal unitPrice;
      private BigDecimal inboundTotalQuantity;
      private BigDecimal inboundTotalWeight;
      private BigDecimal inboundTotalLength;
      private BigDecimal inboundTotalArea;
      private BigDecimal inboundAmountExcludingVat;
      private BigDecimal inboundAmount;
      private BigDecimal outboundTotalQuantity;
      private BigDecimal outboundTotalWeight;
      private BigDecimal outboundTotalLength;
      private BigDecimal outboundTotalArea;
      private BigDecimal outboundAmountExcludingVat;
      private BigDecimal outboundAmount;
      private BigDecimal returnTotalQuantity;
      private BigDecimal returnTotalWeight;
      private BigDecimal returnTotalLength;
      private BigDecimal returnTotalArea;
      private BigDecimal returnAmountExcludingVat;
      private BigDecimal returnAmount;
      private BigDecimal beginMonthTotalQuantity;
      private BigDecimal beginMonthTotalWeight;
      private BigDecimal beginMonthTotalLength;
      private BigDecimal beginMonthTotalArea;
      private BigDecimal beginMonthAmountExcludingVat;
      private BigDecimal beginMonthAmount;
      private BigDecimal endMonthTotalQuantity;
      private BigDecimal endMonthTotalWeight;
      private BigDecimal endMonthTotalLength;
      private BigDecimal endMonthTotalArea;
      private BigDecimal endMonthAmountExcludingVat;
      private BigDecimal endMonthAmount;
      private String remark;

      StatisticsMonthManufacturedDTOBuilder() {
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder monthStr(final String monthStr) {
         this.monthStr = monthStr;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder artifactEnclosureId(final Long artifactEnclosureId) {
         this.artifactEnclosureId = artifactEnclosureId;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder manufacturedName(final String manufacturedName) {
         this.manufacturedName = manufacturedName;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder manufacturedSn(final String manufacturedSn) {
         this.manufacturedSn = manufacturedSn;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder inboundTotalQuantity(final BigDecimal inboundTotalQuantity) {
         this.inboundTotalQuantity = inboundTotalQuantity;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder inboundTotalWeight(final BigDecimal inboundTotalWeight) {
         this.inboundTotalWeight = inboundTotalWeight;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder inboundTotalLength(final BigDecimal inboundTotalLength) {
         this.inboundTotalLength = inboundTotalLength;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder inboundTotalArea(final BigDecimal inboundTotalArea) {
         this.inboundTotalArea = inboundTotalArea;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder inboundAmountExcludingVat(final BigDecimal inboundAmountExcludingVat) {
         this.inboundAmountExcludingVat = inboundAmountExcludingVat;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder inboundAmount(final BigDecimal inboundAmount) {
         this.inboundAmount = inboundAmount;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder outboundTotalQuantity(final BigDecimal outboundTotalQuantity) {
         this.outboundTotalQuantity = outboundTotalQuantity;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder outboundTotalWeight(final BigDecimal outboundTotalWeight) {
         this.outboundTotalWeight = outboundTotalWeight;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder outboundTotalLength(final BigDecimal outboundTotalLength) {
         this.outboundTotalLength = outboundTotalLength;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder outboundTotalArea(final BigDecimal outboundTotalArea) {
         this.outboundTotalArea = outboundTotalArea;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder outboundAmountExcludingVat(final BigDecimal outboundAmountExcludingVat) {
         this.outboundAmountExcludingVat = outboundAmountExcludingVat;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder outboundAmount(final BigDecimal outboundAmount) {
         this.outboundAmount = outboundAmount;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder returnTotalQuantity(final BigDecimal returnTotalQuantity) {
         this.returnTotalQuantity = returnTotalQuantity;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder returnTotalWeight(final BigDecimal returnTotalWeight) {
         this.returnTotalWeight = returnTotalWeight;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder returnTotalLength(final BigDecimal returnTotalLength) {
         this.returnTotalLength = returnTotalLength;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder returnTotalArea(final BigDecimal returnTotalArea) {
         this.returnTotalArea = returnTotalArea;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder returnAmountExcludingVat(final BigDecimal returnAmountExcludingVat) {
         this.returnAmountExcludingVat = returnAmountExcludingVat;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder returnAmount(final BigDecimal returnAmount) {
         this.returnAmount = returnAmount;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder beginMonthTotalQuantity(final BigDecimal beginMonthTotalQuantity) {
         this.beginMonthTotalQuantity = beginMonthTotalQuantity;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder beginMonthTotalWeight(final BigDecimal beginMonthTotalWeight) {
         this.beginMonthTotalWeight = beginMonthTotalWeight;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder beginMonthTotalLength(final BigDecimal beginMonthTotalLength) {
         this.beginMonthTotalLength = beginMonthTotalLength;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder beginMonthTotalArea(final BigDecimal beginMonthTotalArea) {
         this.beginMonthTotalArea = beginMonthTotalArea;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder beginMonthAmountExcludingVat(final BigDecimal beginMonthAmountExcludingVat) {
         this.beginMonthAmountExcludingVat = beginMonthAmountExcludingVat;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder beginMonthAmount(final BigDecimal beginMonthAmount) {
         this.beginMonthAmount = beginMonthAmount;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder endMonthTotalQuantity(final BigDecimal endMonthTotalQuantity) {
         this.endMonthTotalQuantity = endMonthTotalQuantity;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder endMonthTotalWeight(final BigDecimal endMonthTotalWeight) {
         this.endMonthTotalWeight = endMonthTotalWeight;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder endMonthTotalLength(final BigDecimal endMonthTotalLength) {
         this.endMonthTotalLength = endMonthTotalLength;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder endMonthTotalArea(final BigDecimal endMonthTotalArea) {
         this.endMonthTotalArea = endMonthTotalArea;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder endMonthAmountExcludingVat(final BigDecimal endMonthAmountExcludingVat) {
         this.endMonthAmountExcludingVat = endMonthAmountExcludingVat;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder endMonthAmount(final BigDecimal endMonthAmount) {
         this.endMonthAmount = endMonthAmount;
         return this;
      }

      public StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public StatisticsMonthManufacturedDTO build() {
         return new StatisticsMonthManufacturedDTO(
            this.id,
            this.monthStr,
            this.basicClass,
            this.monomerId,
            this.areaId,
            this.projectId,
            this.artifactEnclosureId,
            this.manufacturedName,
            this.manufacturedSn,
            this.material,
            this.specification,
            this.length,
            this.width,
            this.thickness,
            this.brand,
            this.color,
            this.weight,
            this.surfaceArea,
            this.wageQuotaType,
            this.taxRate,
            this.unitPriceExcludingVat,
            this.unitPrice,
            this.inboundTotalQuantity,
            this.inboundTotalWeight,
            this.inboundTotalLength,
            this.inboundTotalArea,
            this.inboundAmountExcludingVat,
            this.inboundAmount,
            this.outboundTotalQuantity,
            this.outboundTotalWeight,
            this.outboundTotalLength,
            this.outboundTotalArea,
            this.outboundAmountExcludingVat,
            this.outboundAmount,
            this.returnTotalQuantity,
            this.returnTotalWeight,
            this.returnTotalLength,
            this.returnTotalArea,
            this.returnAmountExcludingVat,
            this.returnAmount,
            this.beginMonthTotalQuantity,
            this.beginMonthTotalWeight,
            this.beginMonthTotalLength,
            this.beginMonthTotalArea,
            this.beginMonthAmountExcludingVat,
            this.beginMonthAmount,
            this.endMonthTotalQuantity,
            this.endMonthTotalWeight,
            this.endMonthTotalLength,
            this.endMonthTotalArea,
            this.endMonthAmountExcludingVat,
            this.endMonthAmount,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "StatisticsMonthManufacturedDTO.StatisticsMonthManufacturedDTOBuilder(id="
            + this.id
            + ", monthStr="
            + this.monthStr
            + ", basicClass="
            + this.basicClass
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", projectId="
            + this.projectId
            + ", artifactEnclosureId="
            + this.artifactEnclosureId
            + ", manufacturedName="
            + this.manufacturedName
            + ", manufacturedSn="
            + this.manufacturedSn
            + ", material="
            + this.material
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", weight="
            + this.weight
            + ", surfaceArea="
            + this.surfaceArea
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", taxRate="
            + this.taxRate
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", unitPrice="
            + this.unitPrice
            + ", inboundTotalQuantity="
            + this.inboundTotalQuantity
            + ", inboundTotalWeight="
            + this.inboundTotalWeight
            + ", inboundTotalLength="
            + this.inboundTotalLength
            + ", inboundTotalArea="
            + this.inboundTotalArea
            + ", inboundAmountExcludingVat="
            + this.inboundAmountExcludingVat
            + ", inboundAmount="
            + this.inboundAmount
            + ", outboundTotalQuantity="
            + this.outboundTotalQuantity
            + ", outboundTotalWeight="
            + this.outboundTotalWeight
            + ", outboundTotalLength="
            + this.outboundTotalLength
            + ", outboundTotalArea="
            + this.outboundTotalArea
            + ", outboundAmountExcludingVat="
            + this.outboundAmountExcludingVat
            + ", outboundAmount="
            + this.outboundAmount
            + ", returnTotalQuantity="
            + this.returnTotalQuantity
            + ", returnTotalWeight="
            + this.returnTotalWeight
            + ", returnTotalLength="
            + this.returnTotalLength
            + ", returnTotalArea="
            + this.returnTotalArea
            + ", returnAmountExcludingVat="
            + this.returnAmountExcludingVat
            + ", returnAmount="
            + this.returnAmount
            + ", beginMonthTotalQuantity="
            + this.beginMonthTotalQuantity
            + ", beginMonthTotalWeight="
            + this.beginMonthTotalWeight
            + ", beginMonthTotalLength="
            + this.beginMonthTotalLength
            + ", beginMonthTotalArea="
            + this.beginMonthTotalArea
            + ", beginMonthAmountExcludingVat="
            + this.beginMonthAmountExcludingVat
            + ", beginMonthAmount="
            + this.beginMonthAmount
            + ", endMonthTotalQuantity="
            + this.endMonthTotalQuantity
            + ", endMonthTotalWeight="
            + this.endMonthTotalWeight
            + ", endMonthTotalLength="
            + this.endMonthTotalLength
            + ", endMonthTotalArea="
            + this.endMonthTotalArea
            + ", endMonthAmountExcludingVat="
            + this.endMonthAmountExcludingVat
            + ", endMonthAmount="
            + this.endMonthAmount
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
