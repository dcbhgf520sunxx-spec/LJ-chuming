package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("清单导入通用属性DTO")
public class ArtifactPartImportCommonDTO {
   @ApiModelProperty(name = "orderNo", value = "序号")
   private Integer orderNo;
   @ApiModelProperty(name = "structureType", value = "结构类型")
   private String structureType;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀", notes = "规格前缀")
   private String specPrefix;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "面积（mm²）")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "thickness", notes = "厚度（mm）")
   private BigDecimal thickness;
   @ApiModelProperty(name = "thickness", notes = "宽度）")
   private BigDecimal Width;
   @ApiModelProperty(name = "topFlangeArea", value = "上翼缘(单)面积（mm²）")
   private BigDecimal topFlangeArea;
   @ApiModelProperty(name = "boolBlastingEnum", value = "是否抛丸")
   private Boolean boolBlastingEnum;
   @ApiModelProperty(name = "serialNumberPrefix", value = "编号前缀")
   private String serialNumberPrefix;
   @ApiModelProperty(name = "boolPurlineClass", value = "是否檩条")
   private Boolean boolPurlineClass;
   @ApiModelProperty(name = "boolSinglePartEnum", value = "是否单零件类型构件 true是 false否")
   private Boolean boolSinglePartEnum;
   @ApiModelProperty(name = "drawingWeight", value = "图纸单重")
   private BigDecimal drawingWeight;
   @ApiModelProperty(name = "drawingWeight", value = "图纸总重")
   private BigDecimal totalDrawingWeight;
   @ApiModelProperty("桥顶面油漆(单)面积(mm2)")
   private BigDecimal topPaintArea;
   @ApiModelProperty("内表面油漆(单)面积(mm2)")
   private BigDecimal innerPaintArea;
   @ApiModelProperty("外表面油漆(单)面积(mm2)")
   private BigDecimal outerPaintArea;
   @ApiModelProperty("U肋油漆(单)面积(mm2)")
   private BigDecimal uRibPaintArea;
   @ApiModelProperty("桥顶面油漆总面积(mm2)")
   private BigDecimal totalTopPaintArea;
   @ApiModelProperty("内表面油漆总面积(mm2)")
   private BigDecimal totalInnerPaintArea;
   @ApiModelProperty("外表面油漆总面积(mm2)")
   private BigDecimal totalOuterPaintArea;
   @ApiModelProperty("U肋油漆总面积(mm2)")
   private BigDecimal totalURibPaintArea;
   @ApiModelProperty("产品分类")
   private Integer productClassificationEnum;
   @ApiModelProperty(name = "boolComposeAssemble", value = "是否组合过部件 true 是 false 否")
   private Boolean boolComposeAssemble;
   @ApiModelProperty(name = "initialSerialNumber", value = "翼腹板初始编号")
   private String initialSerialNumber;
   @ApiModelProperty(name = "sourcePartEnum", value = "翼腹板来源 1 直接导入 2 部件拆分 4 部件组合")
   private Integer sourcePartEnum;
   @ApiModelProperty(name = "下料长度")
   private BigDecimal cuttingLength;
   @ApiModelProperty(name = "高强螺栓")
   private String highStrengthBolt;
   @ApiModelProperty(name = "螺栓数量")
   private Integer boltQuantity;
   @ApiModelProperty(name = "配件数量")
   private Integer matchingPartsQuantity;
   @ApiModelProperty(name = "杆子总长")
   private BigDecimal totalPoleLength;
   @ApiModelProperty(name = "杆子重量")
   private BigDecimal poleWeight;
   @ApiModelProperty(name = "封板或锥头重量")
   private BigDecimal sealingOrPlateWeight;
   @ApiModelProperty(name = "螺栓重量")
   private BigDecimal boltWeight;
   @ApiModelProperty(name = "套筒重量")
   private BigDecimal sleeveWeight;
   @ApiModelProperty(name = "销钉重量")
   private BigDecimal dowelPinWeight;

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getStructureType() {
      return this.structureType;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.Width;
   }

   public BigDecimal getTopFlangeArea() {
      return this.topFlangeArea;
   }

   public Boolean getBoolBlastingEnum() {
      return this.boolBlastingEnum;
   }

   public String getSerialNumberPrefix() {
      return this.serialNumberPrefix;
   }

   public Boolean getBoolPurlineClass() {
      return this.boolPurlineClass;
   }

   public Boolean getBoolSinglePartEnum() {
      return this.boolSinglePartEnum;
   }

   public BigDecimal getDrawingWeight() {
      return this.drawingWeight;
   }

   public BigDecimal getTotalDrawingWeight() {
      return this.totalDrawingWeight;
   }

   public BigDecimal getTopPaintArea() {
      return this.topPaintArea;
   }

   public BigDecimal getInnerPaintArea() {
      return this.innerPaintArea;
   }

   public BigDecimal getOuterPaintArea() {
      return this.outerPaintArea;
   }

   public BigDecimal getURibPaintArea() {
      return this.uRibPaintArea;
   }

   public BigDecimal getTotalTopPaintArea() {
      return this.totalTopPaintArea;
   }

   public BigDecimal getTotalInnerPaintArea() {
      return this.totalInnerPaintArea;
   }

   public BigDecimal getTotalOuterPaintArea() {
      return this.totalOuterPaintArea;
   }

   public BigDecimal getTotalURibPaintArea() {
      return this.totalURibPaintArea;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public Boolean getBoolComposeAssemble() {
      return this.boolComposeAssemble;
   }

   public String getInitialSerialNumber() {
      return this.initialSerialNumber;
   }

   public Integer getSourcePartEnum() {
      return this.sourcePartEnum;
   }

   public BigDecimal getCuttingLength() {
      return this.cuttingLength;
   }

   public String getHighStrengthBolt() {
      return this.highStrengthBolt;
   }

   public Integer getBoltQuantity() {
      return this.boltQuantity;
   }

   public Integer getMatchingPartsQuantity() {
      return this.matchingPartsQuantity;
   }

   public BigDecimal getTotalPoleLength() {
      return this.totalPoleLength;
   }

   public BigDecimal getPoleWeight() {
      return this.poleWeight;
   }

   public BigDecimal getSealingOrPlateWeight() {
      return this.sealingOrPlateWeight;
   }

   public BigDecimal getBoltWeight() {
      return this.boltWeight;
   }

   public BigDecimal getSleeveWeight() {
      return this.sleeveWeight;
   }

   public BigDecimal getDowelPinWeight() {
      return this.dowelPinWeight;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setStructureType(final String structureType) {
      this.structureType = structureType;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setWidth(final BigDecimal Width) {
      this.Width = Width;
   }

   public void setTopFlangeArea(final BigDecimal topFlangeArea) {
      this.topFlangeArea = topFlangeArea;
   }

   public void setBoolBlastingEnum(final Boolean boolBlastingEnum) {
      this.boolBlastingEnum = boolBlastingEnum;
   }

   public void setSerialNumberPrefix(final String serialNumberPrefix) {
      this.serialNumberPrefix = serialNumberPrefix;
   }

   public void setBoolPurlineClass(final Boolean boolPurlineClass) {
      this.boolPurlineClass = boolPurlineClass;
   }

   public void setBoolSinglePartEnum(final Boolean boolSinglePartEnum) {
      this.boolSinglePartEnum = boolSinglePartEnum;
   }

   public void setDrawingWeight(final BigDecimal drawingWeight) {
      this.drawingWeight = drawingWeight;
   }

   public void setTotalDrawingWeight(final BigDecimal totalDrawingWeight) {
      this.totalDrawingWeight = totalDrawingWeight;
   }

   public void setTopPaintArea(final BigDecimal topPaintArea) {
      this.topPaintArea = topPaintArea;
   }

   public void setInnerPaintArea(final BigDecimal innerPaintArea) {
      this.innerPaintArea = innerPaintArea;
   }

   public void setOuterPaintArea(final BigDecimal outerPaintArea) {
      this.outerPaintArea = outerPaintArea;
   }

   public void setURibPaintArea(final BigDecimal uRibPaintArea) {
      this.uRibPaintArea = uRibPaintArea;
   }

   public void setTotalTopPaintArea(final BigDecimal totalTopPaintArea) {
      this.totalTopPaintArea = totalTopPaintArea;
   }

   public void setTotalInnerPaintArea(final BigDecimal totalInnerPaintArea) {
      this.totalInnerPaintArea = totalInnerPaintArea;
   }

   public void setTotalOuterPaintArea(final BigDecimal totalOuterPaintArea) {
      this.totalOuterPaintArea = totalOuterPaintArea;
   }

   public void setTotalURibPaintArea(final BigDecimal totalURibPaintArea) {
      this.totalURibPaintArea = totalURibPaintArea;
   }

   public void setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
   }

   public void setBoolComposeAssemble(final Boolean boolComposeAssemble) {
      this.boolComposeAssemble = boolComposeAssemble;
   }

   public void setInitialSerialNumber(final String initialSerialNumber) {
      this.initialSerialNumber = initialSerialNumber;
   }

   public void setSourcePartEnum(final Integer sourcePartEnum) {
      this.sourcePartEnum = sourcePartEnum;
   }

   public void setCuttingLength(final BigDecimal cuttingLength) {
      this.cuttingLength = cuttingLength;
   }

   public void setHighStrengthBolt(final String highStrengthBolt) {
      this.highStrengthBolt = highStrengthBolt;
   }

   public void setBoltQuantity(final Integer boltQuantity) {
      this.boltQuantity = boltQuantity;
   }

   public void setMatchingPartsQuantity(final Integer matchingPartsQuantity) {
      this.matchingPartsQuantity = matchingPartsQuantity;
   }

   public void setTotalPoleLength(final BigDecimal totalPoleLength) {
      this.totalPoleLength = totalPoleLength;
   }

   public void setPoleWeight(final BigDecimal poleWeight) {
      this.poleWeight = poleWeight;
   }

   public void setSealingOrPlateWeight(final BigDecimal sealingOrPlateWeight) {
      this.sealingOrPlateWeight = sealingOrPlateWeight;
   }

   public void setBoltWeight(final BigDecimal boltWeight) {
      this.boltWeight = boltWeight;
   }

   public void setSleeveWeight(final BigDecimal sleeveWeight) {
      this.sleeveWeight = sleeveWeight;
   }

   public void setDowelPinWeight(final BigDecimal dowelPinWeight) {
      this.dowelPinWeight = dowelPinWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactPartImportCommonDTO)) {
         return false;
      }

      ArtifactPartImportCommonDTO other = (ArtifactPartImportCommonDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$boolBlastingEnum = this.getBoolBlastingEnum();
            Object other$boolBlastingEnum = other.getBoolBlastingEnum();
            if (this$boolBlastingEnum == null ? other$boolBlastingEnum == null : this$boolBlastingEnum.equals(other$boolBlastingEnum)) {
               Object this$boolPurlineClass = this.getBoolPurlineClass();
               Object other$boolPurlineClass = other.getBoolPurlineClass();
               if (this$boolPurlineClass == null ? other$boolPurlineClass == null : this$boolPurlineClass.equals(other$boolPurlineClass)) {
                  Object this$boolSinglePartEnum = this.getBoolSinglePartEnum();
                  Object other$boolSinglePartEnum = other.getBoolSinglePartEnum();
                  if (this$boolSinglePartEnum == null ? other$boolSinglePartEnum == null : this$boolSinglePartEnum.equals(other$boolSinglePartEnum)) {
                     Object this$productClassificationEnum = this.getProductClassificationEnum();
                     Object other$productClassificationEnum = other.getProductClassificationEnum();
                     if (this$productClassificationEnum == null
                        ? other$productClassificationEnum == null
                        : this$productClassificationEnum.equals(other$productClassificationEnum)) {
                        Object this$boolComposeAssemble = this.getBoolComposeAssemble();
                        Object other$boolComposeAssemble = other.getBoolComposeAssemble();
                        if (this$boolComposeAssemble == null ? other$boolComposeAssemble == null : this$boolComposeAssemble.equals(other$boolComposeAssemble)) {
                           Object this$sourcePartEnum = this.getSourcePartEnum();
                           Object other$sourcePartEnum = other.getSourcePartEnum();
                           if (this$sourcePartEnum == null ? other$sourcePartEnum == null : this$sourcePartEnum.equals(other$sourcePartEnum)) {
                              Object this$boltQuantity = this.getBoltQuantity();
                              Object other$boltQuantity = other.getBoltQuantity();
                              if (this$boltQuantity == null ? other$boltQuantity == null : this$boltQuantity.equals(other$boltQuantity)) {
                                 Object this$matchingPartsQuantity = this.getMatchingPartsQuantity();
                                 Object other$matchingPartsQuantity = other.getMatchingPartsQuantity();
                                 if (this$matchingPartsQuantity == null
                                    ? other$matchingPartsQuantity == null
                                    : this$matchingPartsQuantity.equals(other$matchingPartsQuantity)) {
                                    Object this$structureType = this.getStructureType();
                                    Object other$structureType = other.getStructureType();
                                    if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
                                       Object this$name = this.getName();
                                       Object other$name = other.getName();
                                       if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$specification = this.getSpecification();
                                             Object other$specification = other.getSpecification();
                                             if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                Object this$specPrefix = this.getSpecPrefix();
                                                Object other$specPrefix = other.getSpecPrefix();
                                                if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
                                                   Object this$length = this.getLength();
                                                   Object other$length = other.getLength();
                                                   if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                      Object this$material = this.getMaterial();
                                                      Object other$material = other.getMaterial();
                                                      if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                         Object this$netWeight = this.getNetWeight();
                                                         Object other$netWeight = other.getNetWeight();
                                                         if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                            Object this$totalNetWeight = this.getTotalNetWeight();
                                                            Object other$totalNetWeight = other.getTotalNetWeight();
                                                            if (this$totalNetWeight == null
                                                               ? other$totalNetWeight == null
                                                               : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                               Object this$grossWeight = this.getGrossWeight();
                                                               Object other$grossWeight = other.getGrossWeight();
                                                               if (this$grossWeight == null
                                                                  ? other$grossWeight == null
                                                                  : this$grossWeight.equals(other$grossWeight)) {
                                                                  Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                                  Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                                  if (this$totalGrossWeight == null
                                                                     ? other$totalGrossWeight == null
                                                                     : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                                     Object this$surfaceArea = this.getSurfaceArea();
                                                                     Object other$surfaceArea = other.getSurfaceArea();
                                                                     if (this$surfaceArea == null
                                                                        ? other$surfaceArea == null
                                                                        : this$surfaceArea.equals(other$surfaceArea)) {
                                                                        Object this$remark = this.getRemark();
                                                                        Object other$remark = other.getRemark();
                                                                        if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                           Object this$thickness = this.getThickness();
                                                                           Object other$thickness = other.getThickness();
                                                                           if (this$thickness == null
                                                                              ? other$thickness == null
                                                                              : this$thickness.equals(other$thickness)) {
                                                                              Object this$Width = this.getWidth();
                                                                              Object other$Width = other.getWidth();
                                                                              if (this$Width == null ? other$Width == null : this$Width.equals(other$Width)) {
                                                                                 Object this$topFlangeArea = this.getTopFlangeArea();
                                                                                 Object other$topFlangeArea = other.getTopFlangeArea();
                                                                                 if (this$topFlangeArea == null
                                                                                    ? other$topFlangeArea == null
                                                                                    : this$topFlangeArea.equals(other$topFlangeArea)) {
                                                                                    Object this$serialNumberPrefix = this.getSerialNumberPrefix();
                                                                                    Object other$serialNumberPrefix = other.getSerialNumberPrefix();
                                                                                    if (this$serialNumberPrefix == null
                                                                                       ? other$serialNumberPrefix == null
                                                                                       : this$serialNumberPrefix.equals(other$serialNumberPrefix)) {
                                                                                       Object this$drawingWeight = this.getDrawingWeight();
                                                                                       Object other$drawingWeight = other.getDrawingWeight();
                                                                                       if (this$drawingWeight == null
                                                                                          ? other$drawingWeight == null
                                                                                          : this$drawingWeight.equals(other$drawingWeight)) {
                                                                                          Object this$totalDrawingWeight = this.getTotalDrawingWeight();
                                                                                          Object other$totalDrawingWeight = other.getTotalDrawingWeight();
                                                                                          if (this$totalDrawingWeight == null
                                                                                             ? other$totalDrawingWeight == null
                                                                                             : this$totalDrawingWeight.equals(other$totalDrawingWeight)) {
                                                                                             Object this$topPaintArea = this.getTopPaintArea();
                                                                                             Object other$topPaintArea = other.getTopPaintArea();
                                                                                             if (this$topPaintArea == null
                                                                                                ? other$topPaintArea == null
                                                                                                : this$topPaintArea.equals(other$topPaintArea)) {
                                                                                                Object this$innerPaintArea = this.getInnerPaintArea();
                                                                                                Object other$innerPaintArea = other.getInnerPaintArea();
                                                                                                if (this$innerPaintArea == null
                                                                                                   ? other$innerPaintArea == null
                                                                                                   : this$innerPaintArea.equals(other$innerPaintArea)) {
                                                                                                   Object this$outerPaintArea = this.getOuterPaintArea();
                                                                                                   Object other$outerPaintArea = other.getOuterPaintArea();
                                                                                                   if (this$outerPaintArea == null
                                                                                                      ? other$outerPaintArea == null
                                                                                                      : this$outerPaintArea.equals(other$outerPaintArea)) {
                                                                                                      Object this$uRibPaintArea = this.getURibPaintArea();
                                                                                                      Object other$uRibPaintArea = other.getURibPaintArea();
                                                                                                      if (this$uRibPaintArea == null
                                                                                                         ? other$uRibPaintArea == null
                                                                                                         : this$uRibPaintArea.equals(other$uRibPaintArea)) {
                                                                                                         Object this$totalTopPaintArea = this.getTotalTopPaintArea();
                                                                                                         Object other$totalTopPaintArea = other.getTotalTopPaintArea();
                                                                                                         if (this$totalTopPaintArea == null
                                                                                                            ? other$totalTopPaintArea == null
                                                                                                            : this$totalTopPaintArea.equals(
                                                                                                               other$totalTopPaintArea
                                                                                                            )) {
                                                                                                            Object this$totalInnerPaintArea = this.getTotalInnerPaintArea();
                                                                                                            Object other$totalInnerPaintArea = other.getTotalInnerPaintArea();
                                                                                                            if (this$totalInnerPaintArea == null
                                                                                                               ? other$totalInnerPaintArea == null
                                                                                                               : this$totalInnerPaintArea.equals(
                                                                                                                  other$totalInnerPaintArea
                                                                                                               )) {
                                                                                                               Object this$totalOuterPaintArea = this.getTotalOuterPaintArea();
                                                                                                               Object other$totalOuterPaintArea = other.getTotalOuterPaintArea();
                                                                                                               if (this$totalOuterPaintArea == null
                                                                                                                  ? other$totalOuterPaintArea == null
                                                                                                                  : this$totalOuterPaintArea.equals(
                                                                                                                     other$totalOuterPaintArea
                                                                                                                  )) {
                                                                                                                  Object this$totalURibPaintArea = this.getTotalURibPaintArea();
                                                                                                                  Object other$totalURibPaintArea = other.getTotalURibPaintArea();
                                                                                                                  if (this$totalURibPaintArea == null
                                                                                                                     ? other$totalURibPaintArea == null
                                                                                                                     : this$totalURibPaintArea.equals(
                                                                                                                        other$totalURibPaintArea
                                                                                                                     )) {
                                                                                                                     Object this$initialSerialNumber = this.getInitialSerialNumber();
                                                                                                                     Object other$initialSerialNumber = other.getInitialSerialNumber();
                                                                                                                     if (this$initialSerialNumber == null
                                                                                                                        ? other$initialSerialNumber == null
                                                                                                                        : this$initialSerialNumber.equals(
                                                                                                                           other$initialSerialNumber
                                                                                                                        )) {
                                                                                                                        Object this$cuttingLength = this.getCuttingLength();
                                                                                                                        Object other$cuttingLength = other.getCuttingLength();
                                                                                                                        if (this$cuttingLength == null
                                                                                                                           ? other$cuttingLength == null
                                                                                                                           : this$cuttingLength.equals(
                                                                                                                              other$cuttingLength
                                                                                                                           )) {
                                                                                                                           Object this$highStrengthBolt = this.getHighStrengthBolt();
                                                                                                                           Object other$highStrengthBolt = other.getHighStrengthBolt();
                                                                                                                           if (this$highStrengthBolt == null
                                                                                                                              ? other$highStrengthBolt == null
                                                                                                                              : this$highStrengthBolt.equals(
                                                                                                                                 other$highStrengthBolt
                                                                                                                              )) {
                                                                                                                              Object this$totalPoleLength = this.getTotalPoleLength();
                                                                                                                              Object other$totalPoleLength = other.getTotalPoleLength();
                                                                                                                              if (this$totalPoleLength == null
                                                                                                                                 ? other$totalPoleLength
                                                                                                                                    == null
                                                                                                                                 : this$totalPoleLength.equals(
                                                                                                                                    other$totalPoleLength
                                                                                                                                 )) {
                                                                                                                                 Object this$poleWeight = this.getPoleWeight();
                                                                                                                                 Object other$poleWeight = other.getPoleWeight();
                                                                                                                                 if (this$poleWeight == null
                                                                                                                                    ? other$poleWeight == null
                                                                                                                                    : this$poleWeight.equals(
                                                                                                                                       other$poleWeight
                                                                                                                                    )) {
                                                                                                                                    Object this$sealingOrPlateWeight = this.getSealingOrPlateWeight();
                                                                                                                                    Object other$sealingOrPlateWeight = other.getSealingOrPlateWeight();
                                                                                                                                    if (this$sealingOrPlateWeight
                                                                                                                                          == null
                                                                                                                                       ? other$sealingOrPlateWeight
                                                                                                                                          == null
                                                                                                                                       : this$sealingOrPlateWeight.equals(
                                                                                                                                          other$sealingOrPlateWeight
                                                                                                                                       )) {
                                                                                                                                       Object this$boltWeight = this.getBoltWeight();
                                                                                                                                       Object other$boltWeight = other.getBoltWeight();
                                                                                                                                       if (this$boltWeight
                                                                                                                                             == null
                                                                                                                                          ? other$boltWeight
                                                                                                                                             == null
                                                                                                                                          : this$boltWeight.equals(
                                                                                                                                             other$boltWeight
                                                                                                                                          )) {
                                                                                                                                          Object this$sleeveWeight = this.getSleeveWeight();
                                                                                                                                          Object other$sleeveWeight = other.getSleeveWeight();
                                                                                                                                          if (this$sleeveWeight
                                                                                                                                                == null
                                                                                                                                             ? other$sleeveWeight
                                                                                                                                                == null
                                                                                                                                             : this$sleeveWeight.equals(
                                                                                                                                                other$sleeveWeight
                                                                                                                                             )) {
                                                                                                                                             Object this$dowelPinWeight = this.getDowelPinWeight();
                                                                                                                                             Object other$dowelPinWeight = other.getDowelPinWeight();
                                                                                                                                             return this$dowelPinWeight
                                                                                                                                                   == null
                                                                                                                                                ? other$dowelPinWeight
                                                                                                                                                   == null
                                                                                                                                                : this$dowelPinWeight.equals(
                                                                                                                                                   other$dowelPinWeight
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactPartImportCommonDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolBlastingEnum = this.getBoolBlastingEnum();
      result = result * 59 + ($boolBlastingEnum == null ? 43 : $boolBlastingEnum.hashCode());
      Object $boolPurlineClass = this.getBoolPurlineClass();
      result = result * 59 + ($boolPurlineClass == null ? 43 : $boolPurlineClass.hashCode());
      Object $boolSinglePartEnum = this.getBoolSinglePartEnum();
      result = result * 59 + ($boolSinglePartEnum == null ? 43 : $boolSinglePartEnum.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $boolComposeAssemble = this.getBoolComposeAssemble();
      result = result * 59 + ($boolComposeAssemble == null ? 43 : $boolComposeAssemble.hashCode());
      Object $sourcePartEnum = this.getSourcePartEnum();
      result = result * 59 + ($sourcePartEnum == null ? 43 : $sourcePartEnum.hashCode());
      Object $boltQuantity = this.getBoltQuantity();
      result = result * 59 + ($boltQuantity == null ? 43 : $boltQuantity.hashCode());
      Object $matchingPartsQuantity = this.getMatchingPartsQuantity();
      result = result * 59 + ($matchingPartsQuantity == null ? 43 : $matchingPartsQuantity.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $Width = this.getWidth();
      result = result * 59 + ($Width == null ? 43 : $Width.hashCode());
      Object $topFlangeArea = this.getTopFlangeArea();
      result = result * 59 + ($topFlangeArea == null ? 43 : $topFlangeArea.hashCode());
      Object $serialNumberPrefix = this.getSerialNumberPrefix();
      result = result * 59 + ($serialNumberPrefix == null ? 43 : $serialNumberPrefix.hashCode());
      Object $drawingWeight = this.getDrawingWeight();
      result = result * 59 + ($drawingWeight == null ? 43 : $drawingWeight.hashCode());
      Object $totalDrawingWeight = this.getTotalDrawingWeight();
      result = result * 59 + ($totalDrawingWeight == null ? 43 : $totalDrawingWeight.hashCode());
      Object $topPaintArea = this.getTopPaintArea();
      result = result * 59 + ($topPaintArea == null ? 43 : $topPaintArea.hashCode());
      Object $innerPaintArea = this.getInnerPaintArea();
      result = result * 59 + ($innerPaintArea == null ? 43 : $innerPaintArea.hashCode());
      Object $outerPaintArea = this.getOuterPaintArea();
      result = result * 59 + ($outerPaintArea == null ? 43 : $outerPaintArea.hashCode());
      Object $uRibPaintArea = this.getURibPaintArea();
      result = result * 59 + ($uRibPaintArea == null ? 43 : $uRibPaintArea.hashCode());
      Object $totalTopPaintArea = this.getTotalTopPaintArea();
      result = result * 59 + ($totalTopPaintArea == null ? 43 : $totalTopPaintArea.hashCode());
      Object $totalInnerPaintArea = this.getTotalInnerPaintArea();
      result = result * 59 + ($totalInnerPaintArea == null ? 43 : $totalInnerPaintArea.hashCode());
      Object $totalOuterPaintArea = this.getTotalOuterPaintArea();
      result = result * 59 + ($totalOuterPaintArea == null ? 43 : $totalOuterPaintArea.hashCode());
      Object $totalURibPaintArea = this.getTotalURibPaintArea();
      result = result * 59 + ($totalURibPaintArea == null ? 43 : $totalURibPaintArea.hashCode());
      Object $initialSerialNumber = this.getInitialSerialNumber();
      result = result * 59 + ($initialSerialNumber == null ? 43 : $initialSerialNumber.hashCode());
      Object $cuttingLength = this.getCuttingLength();
      result = result * 59 + ($cuttingLength == null ? 43 : $cuttingLength.hashCode());
      Object $highStrengthBolt = this.getHighStrengthBolt();
      result = result * 59 + ($highStrengthBolt == null ? 43 : $highStrengthBolt.hashCode());
      Object $totalPoleLength = this.getTotalPoleLength();
      result = result * 59 + ($totalPoleLength == null ? 43 : $totalPoleLength.hashCode());
      Object $poleWeight = this.getPoleWeight();
      result = result * 59 + ($poleWeight == null ? 43 : $poleWeight.hashCode());
      Object $sealingOrPlateWeight = this.getSealingOrPlateWeight();
      result = result * 59 + ($sealingOrPlateWeight == null ? 43 : $sealingOrPlateWeight.hashCode());
      Object $boltWeight = this.getBoltWeight();
      result = result * 59 + ($boltWeight == null ? 43 : $boltWeight.hashCode());
      Object $sleeveWeight = this.getSleeveWeight();
      result = result * 59 + ($sleeveWeight == null ? 43 : $sleeveWeight.hashCode());
      Object $dowelPinWeight = this.getDowelPinWeight();
      return result * 59 + ($dowelPinWeight == null ? 43 : $dowelPinWeight.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactPartImportCommonDTO(orderNo="
         + this.getOrderNo()
         + ", structureType="
         + this.getStructureType()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", remark="
         + this.getRemark()
         + ", thickness="
         + this.getThickness()
         + ", Width="
         + this.getWidth()
         + ", topFlangeArea="
         + this.getTopFlangeArea()
         + ", boolBlastingEnum="
         + this.getBoolBlastingEnum()
         + ", serialNumberPrefix="
         + this.getSerialNumberPrefix()
         + ", boolPurlineClass="
         + this.getBoolPurlineClass()
         + ", boolSinglePartEnum="
         + this.getBoolSinglePartEnum()
         + ", drawingWeight="
         + this.getDrawingWeight()
         + ", totalDrawingWeight="
         + this.getTotalDrawingWeight()
         + ", topPaintArea="
         + this.getTopPaintArea()
         + ", innerPaintArea="
         + this.getInnerPaintArea()
         + ", outerPaintArea="
         + this.getOuterPaintArea()
         + ", uRibPaintArea="
         + this.getURibPaintArea()
         + ", totalTopPaintArea="
         + this.getTotalTopPaintArea()
         + ", totalInnerPaintArea="
         + this.getTotalInnerPaintArea()
         + ", totalOuterPaintArea="
         + this.getTotalOuterPaintArea()
         + ", totalURibPaintArea="
         + this.getTotalURibPaintArea()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", boolComposeAssemble="
         + this.getBoolComposeAssemble()
         + ", initialSerialNumber="
         + this.getInitialSerialNumber()
         + ", sourcePartEnum="
         + this.getSourcePartEnum()
         + ", cuttingLength="
         + this.getCuttingLength()
         + ", highStrengthBolt="
         + this.getHighStrengthBolt()
         + ", boltQuantity="
         + this.getBoltQuantity()
         + ", matchingPartsQuantity="
         + this.getMatchingPartsQuantity()
         + ", totalPoleLength="
         + this.getTotalPoleLength()
         + ", poleWeight="
         + this.getPoleWeight()
         + ", sealingOrPlateWeight="
         + this.getSealingOrPlateWeight()
         + ", boltWeight="
         + this.getBoltWeight()
         + ", sleeveWeight="
         + this.getSleeveWeight()
         + ", dowelPinWeight="
         + this.getDowelPinWeight()
         + ")";
   }
}
