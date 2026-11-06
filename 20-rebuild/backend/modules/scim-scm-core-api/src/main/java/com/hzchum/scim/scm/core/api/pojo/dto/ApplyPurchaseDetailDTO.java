package com.hzchum.scim.scm.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ApplyPurchaseDetailDTO {
   private Long id;
   @JsonInclude(Include.NON_NULL)
   private Long classifyId;
   @JsonInclude(Include.NON_NULL)
   private Long applyPurchaseId;
   @JsonInclude(Include.NON_NULL)
   private String classifyName;
   @JsonInclude(Include.NON_NULL)
   private Integer basicClass;
   @JsonInclude(Include.NON_NULL)
   private String specification;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal length;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal width;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal thickness;
   @JsonInclude(Include.NON_NULL)
   private String brand;
   @JsonInclude(Include.NON_NULL)
   private String color;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal quantity;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal mete;
   @JsonInclude(Include.NON_NULL)
   private String materialSn;
   @JsonInclude(Include.NON_NULL)
   private Long materialInventoryId;
   @JsonInclude(Include.NON_NULL)
   private MaterialFreezeNumDTO materialFreezeNum;
   @JsonInclude(Include.NON_NULL)
   private String name;
   @JsonInclude(Include.NON_NULL)
   private ProjectInfo project;
   @JsonInclude(Include.NON_NULL)
   private NameInfo monomer;
   @JsonInclude(Include.NON_NULL)
   private NameInfo area;
   @JsonInclude(Include.NON_NULL)
   private String serialNumber;
   @JsonInclude(Include.NON_NULL)
   private String heatNoAndBatchNo;
   @JsonInclude(Include.NON_NULL)
   private String remark;
   @JsonInclude(Include.NON_NULL)
   private NameInfo structureClassify;
   @JsonInclude(Include.NON_NULL)
   private String material;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal netWeight;
   @JsonInclude(Include.NON_NULL)
   private LocalDateTime arrivalTime;
   @JsonInclude(Include.NON_NULL)
   private Boolean boolPurchase;
   @JsonInclude(Include.NON_NULL)
   private LocalDateTime inboundTime;
   private BigDecimal productMete;
   private BigDecimal productQuantity;
   private String projectName;
   private String model;
   private Long standardId;
   private String sectionSteelSpec;
   private String doNotSectionSteelSpec;
   private String measureUnit;
   private String accountingUnit;
   private String symbol;
   @ApiModelProperty("单重（kg）")
   private BigDecimal oneWeight;
   @ApiModelProperty("制成品名称")
   private String manufacturedName;
   @ApiModelProperty("制成品类型 结构制品 ArtifactTypeEnum  围护制品 EnclosureCategoryEnum")
   private Integer manufacturedType;
   @ApiModelProperty("制成品编号")
   private String manufacturedSn;
   @ApiModelProperty("单重（kg）")
   private BigDecimal weight;
   @ApiModelProperty("总重（kg）")
   private BigDecimal totalWeight;
   @ApiModelProperty("总长(m)")
   private BigDecimal totalLength;
   @ApiModelProperty("单面积(mm²)")
   private BigDecimal surfaceArea;
   @ApiModelProperty("总面积(m²)")
   private BigDecimal totalArea;
   @ApiModelProperty("构件/围护ID")
   private Long artifactEnclosureId;
   private BigDecimal havePurchasedMete;
   private BigDecimal unPurchaseMete;
   private BigDecimal steelDensity;
   private BigDecimal inboundMete;

   public static ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder builder() {
      return new ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Long getApplyPurchaseId() {
      return this.applyPurchaseId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public Integer getBasicClass() {
      return this.basicClass;
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

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getMaterialSn() {
      return this.materialSn;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public MaterialFreezeNumDTO getMaterialFreezeNum() {
      return this.materialFreezeNum;
   }

   public String getName() {
      return this.name;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getRemark() {
      return this.remark;
   }

   public NameInfo getStructureClassify() {
      return this.structureClassify;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public LocalDateTime getArrivalTime() {
      return this.arrivalTime;
   }

   public Boolean getBoolPurchase() {
      return this.boolPurchase;
   }

   public LocalDateTime getInboundTime() {
      return this.inboundTime;
   }

   public BigDecimal getProductMete() {
      return this.productMete;
   }

   public BigDecimal getProductQuantity() {
      return this.productQuantity;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getModel() {
      return this.model;
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

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public String getSymbol() {
      return this.symbol;
   }

   public BigDecimal getOneWeight() {
      return this.oneWeight;
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

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Long getArtifactEnclosureId() {
      return this.artifactEnclosureId;
   }

   public BigDecimal getHavePurchasedMete() {
      return this.havePurchasedMete;
   }

   public BigDecimal getUnPurchaseMete() {
      return this.unPurchaseMete;
   }

   public BigDecimal getSteelDensity() {
      return this.steelDensity;
   }

   public BigDecimal getInboundMete() {
      return this.inboundMete;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setApplyPurchaseId(final Long applyPurchaseId) {
      this.applyPurchaseId = applyPurchaseId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
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

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
   }

   public void setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
   }

   public void setMaterialFreezeNum(final MaterialFreezeNumDTO materialFreezeNum) {
      this.materialFreezeNum = materialFreezeNum;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setStructureClassify(final NameInfo structureClassify) {
      this.structureClassify = structureClassify;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setArrivalTime(final LocalDateTime arrivalTime) {
      this.arrivalTime = arrivalTime;
   }

   public void setBoolPurchase(final Boolean boolPurchase) {
      this.boolPurchase = boolPurchase;
   }

   public void setInboundTime(final LocalDateTime inboundTime) {
      this.inboundTime = inboundTime;
   }

   public void setProductMete(final BigDecimal productMete) {
      this.productMete = productMete;
   }

   public void setProductQuantity(final BigDecimal productQuantity) {
      this.productQuantity = productQuantity;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setModel(final String model) {
      this.model = model;
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

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setSymbol(final String symbol) {
      this.symbol = symbol;
   }

   public void setOneWeight(final BigDecimal oneWeight) {
      this.oneWeight = oneWeight;
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

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setArtifactEnclosureId(final Long artifactEnclosureId) {
      this.artifactEnclosureId = artifactEnclosureId;
   }

   public void setHavePurchasedMete(final BigDecimal havePurchasedMete) {
      this.havePurchasedMete = havePurchasedMete;
   }

   public void setUnPurchaseMete(final BigDecimal unPurchaseMete) {
      this.unPurchaseMete = unPurchaseMete;
   }

   public void setSteelDensity(final BigDecimal steelDensity) {
      this.steelDensity = steelDensity;
   }

   public void setInboundMete(final BigDecimal inboundMete) {
      this.inboundMete = inboundMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApplyPurchaseDetailDTO)) {
         return false;
      }

      ApplyPurchaseDetailDTO other = (ApplyPurchaseDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$applyPurchaseId = this.getApplyPurchaseId();
            Object other$applyPurchaseId = other.getApplyPurchaseId();
            if (this$applyPurchaseId == null ? other$applyPurchaseId == null : this$applyPurchaseId.equals(other$applyPurchaseId)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$materialInventoryId = this.getMaterialInventoryId();
                  Object other$materialInventoryId = other.getMaterialInventoryId();
                  if (this$materialInventoryId == null ? other$materialInventoryId == null : this$materialInventoryId.equals(other$materialInventoryId)) {
                     Object this$boolPurchase = this.getBoolPurchase();
                     Object other$boolPurchase = other.getBoolPurchase();
                     if (this$boolPurchase == null ? other$boolPurchase == null : this$boolPurchase.equals(other$boolPurchase)) {
                        Object this$standardId = this.getStandardId();
                        Object other$standardId = other.getStandardId();
                        if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                           Object this$manufacturedType = this.getManufacturedType();
                           Object other$manufacturedType = other.getManufacturedType();
                           if (this$manufacturedType == null ? other$manufacturedType == null : this$manufacturedType.equals(other$manufacturedType)) {
                              Object this$artifactEnclosureId = this.getArtifactEnclosureId();
                              Object other$artifactEnclosureId = other.getArtifactEnclosureId();
                              if (this$artifactEnclosureId == null
                                 ? other$artifactEnclosureId == null
                                 : this$artifactEnclosureId.equals(other$artifactEnclosureId)) {
                                 Object this$classifyName = this.getClassifyName();
                                 Object other$classifyName = other.getClassifyName();
                                 if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
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
                                                      Object this$quantity = this.getQuantity();
                                                      Object other$quantity = other.getQuantity();
                                                      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                         Object this$mete = this.getMete();
                                                         Object other$mete = other.getMete();
                                                         if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                            Object this$materialSn = this.getMaterialSn();
                                                            Object other$materialSn = other.getMaterialSn();
                                                            if (this$materialSn == null ? other$materialSn == null : this$materialSn.equals(other$materialSn)) {
                                                               Object this$materialFreezeNum = this.getMaterialFreezeNum();
                                                               Object other$materialFreezeNum = other.getMaterialFreezeNum();
                                                               if (this$materialFreezeNum == null
                                                                  ? other$materialFreezeNum == null
                                                                  : this$materialFreezeNum.equals(other$materialFreezeNum)) {
                                                                  Object this$name = this.getName();
                                                                  Object other$name = other.getName();
                                                                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                                     Object this$project = this.getProject();
                                                                     Object other$project = other.getProject();
                                                                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                                        Object this$monomer = this.getMonomer();
                                                                        Object other$monomer = other.getMonomer();
                                                                        if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                                                           Object this$area = this.getArea();
                                                                           Object other$area = other.getArea();
                                                                           if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                                              Object this$serialNumber = this.getSerialNumber();
                                                                              Object other$serialNumber = other.getSerialNumber();
                                                                              if (this$serialNumber == null
                                                                                 ? other$serialNumber == null
                                                                                 : this$serialNumber.equals(other$serialNumber)) {
                                                                                 Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                                 Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                                 if (this$heatNoAndBatchNo == null
                                                                                    ? other$heatNoAndBatchNo == null
                                                                                    : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                                    Object this$remark = this.getRemark();
                                                                                    Object other$remark = other.getRemark();
                                                                                    if (this$remark == null
                                                                                       ? other$remark == null
                                                                                       : this$remark.equals(other$remark)) {
                                                                                       Object this$structureClassify = this.getStructureClassify();
                                                                                       Object other$structureClassify = other.getStructureClassify();
                                                                                       if (this$structureClassify == null
                                                                                          ? other$structureClassify == null
                                                                                          : this$structureClassify.equals(other$structureClassify)) {
                                                                                          Object this$material = this.getMaterial();
                                                                                          Object other$material = other.getMaterial();
                                                                                          if (this$material == null
                                                                                             ? other$material == null
                                                                                             : this$material.equals(other$material)) {
                                                                                             Object this$netWeight = this.getNetWeight();
                                                                                             Object other$netWeight = other.getNetWeight();
                                                                                             if (this$netWeight == null
                                                                                                ? other$netWeight == null
                                                                                                : this$netWeight.equals(other$netWeight)) {
                                                                                                Object this$arrivalTime = this.getArrivalTime();
                                                                                                Object other$arrivalTime = other.getArrivalTime();
                                                                                                if (this$arrivalTime == null
                                                                                                   ? other$arrivalTime == null
                                                                                                   : this$arrivalTime.equals(other$arrivalTime)) {
                                                                                                   Object this$inboundTime = this.getInboundTime();
                                                                                                   Object other$inboundTime = other.getInboundTime();
                                                                                                   if (this$inboundTime == null
                                                                                                      ? other$inboundTime == null
                                                                                                      : this$inboundTime.equals(other$inboundTime)) {
                                                                                                      Object this$productMete = this.getProductMete();
                                                                                                      Object other$productMete = other.getProductMete();
                                                                                                      if (this$productMete == null
                                                                                                         ? other$productMete == null
                                                                                                         : this$productMete.equals(other$productMete)) {
                                                                                                         Object this$productQuantity = this.getProductQuantity();
                                                                                                         Object other$productQuantity = other.getProductQuantity();
                                                                                                         if (this$productQuantity == null
                                                                                                            ? other$productQuantity == null
                                                                                                            : this$productQuantity.equals(other$productQuantity)
                                                                                                            )
                                                                                                          {
                                                                                                            Object this$projectName = this.getProjectName();
                                                                                                            Object other$projectName = other.getProjectName();
                                                                                                            if (this$projectName == null
                                                                                                               ? other$projectName == null
                                                                                                               : this$projectName.equals(other$projectName)) {
                                                                                                               Object this$model = this.getModel();
                                                                                                               Object other$model = other.getModel();
                                                                                                               if (this$model == null
                                                                                                                  ? other$model == null
                                                                                                                  : this$model.equals(other$model)) {
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
                                                                                                                        Object this$measureUnit = this.getMeasureUnit();
                                                                                                                        Object other$measureUnit = other.getMeasureUnit();
                                                                                                                        if (this$measureUnit == null
                                                                                                                           ? other$measureUnit == null
                                                                                                                           : this$measureUnit.equals(
                                                                                                                              other$measureUnit
                                                                                                                           )) {
                                                                                                                           Object this$accountingUnit = this.getAccountingUnit();
                                                                                                                           Object other$accountingUnit = other.getAccountingUnit();
                                                                                                                           if (this$accountingUnit == null
                                                                                                                              ? other$accountingUnit == null
                                                                                                                              : this$accountingUnit.equals(
                                                                                                                                 other$accountingUnit
                                                                                                                              )) {
                                                                                                                              Object this$symbol = this.getSymbol();
                                                                                                                              Object other$symbol = other.getSymbol();
                                                                                                                              if (this$symbol == null
                                                                                                                                 ? other$symbol == null
                                                                                                                                 : this$symbol.equals(
                                                                                                                                    other$symbol
                                                                                                                                 )) {
                                                                                                                                 Object this$oneWeight = this.getOneWeight();
                                                                                                                                 Object other$oneWeight = other.getOneWeight();
                                                                                                                                 if (this$oneWeight == null
                                                                                                                                    ? other$oneWeight == null
                                                                                                                                    : this$oneWeight.equals(
                                                                                                                                       other$oneWeight
                                                                                                                                    )) {
                                                                                                                                    Object this$manufacturedName = this.getManufacturedName();
                                                                                                                                    Object other$manufacturedName = other.getManufacturedName();
                                                                                                                                    if (this$manufacturedName
                                                                                                                                          == null
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
                                                                                                                                          Object this$weight = this.getWeight();
                                                                                                                                          Object other$weight = other.getWeight();
                                                                                                                                          if (this$weight
                                                                                                                                                == null
                                                                                                                                             ? other$weight
                                                                                                                                                == null
                                                                                                                                             : this$weight.equals(
                                                                                                                                                other$weight
                                                                                                                                             )) {
                                                                                                                                             Object this$totalWeight = this.getTotalWeight();
                                                                                                                                             Object other$totalWeight = other.getTotalWeight();
                                                                                                                                             if (this$totalWeight
                                                                                                                                                   == null
                                                                                                                                                ? other$totalWeight
                                                                                                                                                   == null
                                                                                                                                                : this$totalWeight.equals(
                                                                                                                                                   other$totalWeight
                                                                                                                                                )) {
                                                                                                                                                Object this$totalLength = this.getTotalLength();
                                                                                                                                                Object other$totalLength = other.getTotalLength();
                                                                                                                                                if (this$totalLength
                                                                                                                                                      == null
                                                                                                                                                   ? other$totalLength
                                                                                                                                                      == null
                                                                                                                                                   : this$totalLength.equals(
                                                                                                                                                      other$totalLength
                                                                                                                                                   )) {
                                                                                                                                                   Object this$surfaceArea = this.getSurfaceArea();
                                                                                                                                                   Object other$surfaceArea = other.getSurfaceArea();
                                                                                                                                                   if (this$surfaceArea
                                                                                                                                                         == null
                                                                                                                                                      ? other$surfaceArea
                                                                                                                                                         == null
                                                                                                                                                      : this$surfaceArea.equals(
                                                                                                                                                         other$surfaceArea
                                                                                                                                                      )) {
                                                                                                                                                      Object this$totalArea = this.getTotalArea();
                                                                                                                                                      Object other$totalArea = other.getTotalArea();
                                                                                                                                                      if (this$totalArea
                                                                                                                                                            == null
                                                                                                                                                         ? other$totalArea
                                                                                                                                                            == null
                                                                                                                                                         : this$totalArea.equals(
                                                                                                                                                            other$totalArea
                                                                                                                                                         )) {
                                                                                                                                                         Object this$havePurchasedMete = this.getHavePurchasedMete();
                                                                                                                                                         Object other$havePurchasedMete = other.getHavePurchasedMete();
                                                                                                                                                         if (this$havePurchasedMete
                                                                                                                                                               == null
                                                                                                                                                            ? other$havePurchasedMete
                                                                                                                                                               == null
                                                                                                                                                            : this$havePurchasedMete.equals(
                                                                                                                                                               other$havePurchasedMete
                                                                                                                                                            )) {
                                                                                                                                                            Object this$unPurchaseMete = this.getUnPurchaseMete();
                                                                                                                                                            Object other$unPurchaseMete = other.getUnPurchaseMete();
                                                                                                                                                            if (this$unPurchaseMete
                                                                                                                                                                  == null
                                                                                                                                                               ? other$unPurchaseMete
                                                                                                                                                                  == null
                                                                                                                                                               : this$unPurchaseMete.equals(
                                                                                                                                                                  other$unPurchaseMete
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$steelDensity = this.getSteelDensity();
                                                                                                                                                               Object other$steelDensity = other.getSteelDensity();
                                                                                                                                                               if (this$steelDensity
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$steelDensity
                                                                                                                                                                     == null
                                                                                                                                                                  : this$steelDensity.equals(
                                                                                                                                                                     other$steelDensity
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$inboundMete = this.getInboundMete();
                                                                                                                                                                  Object other$inboundMete = other.getInboundMete();
                                                                                                                                                                  return this$inboundMete
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$inboundMete
                                                                                                                                                                        == null
                                                                                                                                                                     : this$inboundMete.equals(
                                                                                                                                                                        other$inboundMete
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
      return other instanceof ApplyPurchaseDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $applyPurchaseId = this.getApplyPurchaseId();
      result = result * 59 + ($applyPurchaseId == null ? 43 : $applyPurchaseId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $boolPurchase = this.getBoolPurchase();
      result = result * 59 + ($boolPurchase == null ? 43 : $boolPurchase.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $manufacturedType = this.getManufacturedType();
      result = result * 59 + ($manufacturedType == null ? 43 : $manufacturedType.hashCode());
      Object $artifactEnclosureId = this.getArtifactEnclosureId();
      result = result * 59 + ($artifactEnclosureId == null ? 43 : $artifactEnclosureId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
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
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $materialSn = this.getMaterialSn();
      result = result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
      Object $materialFreezeNum = this.getMaterialFreezeNum();
      result = result * 59 + ($materialFreezeNum == null ? 43 : $materialFreezeNum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $structureClassify = this.getStructureClassify();
      result = result * 59 + ($structureClassify == null ? 43 : $structureClassify.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $arrivalTime = this.getArrivalTime();
      result = result * 59 + ($arrivalTime == null ? 43 : $arrivalTime.hashCode());
      Object $inboundTime = this.getInboundTime();
      result = result * 59 + ($inboundTime == null ? 43 : $inboundTime.hashCode());
      Object $productMete = this.getProductMete();
      result = result * 59 + ($productMete == null ? 43 : $productMete.hashCode());
      Object $productQuantity = this.getProductQuantity();
      result = result * 59 + ($productQuantity == null ? 43 : $productQuantity.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $model = this.getModel();
      result = result * 59 + ($model == null ? 43 : $model.hashCode());
      Object $sectionSteelSpec = this.getSectionSteelSpec();
      result = result * 59 + ($sectionSteelSpec == null ? 43 : $sectionSteelSpec.hashCode());
      Object $doNotSectionSteelSpec = this.getDoNotSectionSteelSpec();
      result = result * 59 + ($doNotSectionSteelSpec == null ? 43 : $doNotSectionSteelSpec.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $symbol = this.getSymbol();
      result = result * 59 + ($symbol == null ? 43 : $symbol.hashCode());
      Object $oneWeight = this.getOneWeight();
      result = result * 59 + ($oneWeight == null ? 43 : $oneWeight.hashCode());
      Object $manufacturedName = this.getManufacturedName();
      result = result * 59 + ($manufacturedName == null ? 43 : $manufacturedName.hashCode());
      Object $manufacturedSn = this.getManufacturedSn();
      result = result * 59 + ($manufacturedSn == null ? 43 : $manufacturedSn.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $havePurchasedMete = this.getHavePurchasedMete();
      result = result * 59 + ($havePurchasedMete == null ? 43 : $havePurchasedMete.hashCode());
      Object $unPurchaseMete = this.getUnPurchaseMete();
      result = result * 59 + ($unPurchaseMete == null ? 43 : $unPurchaseMete.hashCode());
      Object $steelDensity = this.getSteelDensity();
      result = result * 59 + ($steelDensity == null ? 43 : $steelDensity.hashCode());
      Object $inboundMete = this.getInboundMete();
      return result * 59 + ($inboundMete == null ? 43 : $inboundMete.hashCode());
   }

   @Override
   public String toString() {
      return "ApplyPurchaseDetailDTO(id="
         + this.getId()
         + ", classifyId="
         + this.getClassifyId()
         + ", applyPurchaseId="
         + this.getApplyPurchaseId()
         + ", classifyName="
         + this.getClassifyName()
         + ", basicClass="
         + this.getBasicClass()
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
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", materialSn="
         + this.getMaterialSn()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", materialFreezeNum="
         + this.getMaterialFreezeNum()
         + ", name="
         + this.getName()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", remark="
         + this.getRemark()
         + ", structureClassify="
         + this.getStructureClassify()
         + ", material="
         + this.getMaterial()
         + ", netWeight="
         + this.getNetWeight()
         + ", arrivalTime="
         + this.getArrivalTime()
         + ", boolPurchase="
         + this.getBoolPurchase()
         + ", inboundTime="
         + this.getInboundTime()
         + ", productMete="
         + this.getProductMete()
         + ", productQuantity="
         + this.getProductQuantity()
         + ", projectName="
         + this.getProjectName()
         + ", model="
         + this.getModel()
         + ", standardId="
         + this.getStandardId()
         + ", sectionSteelSpec="
         + this.getSectionSteelSpec()
         + ", doNotSectionSteelSpec="
         + this.getDoNotSectionSteelSpec()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", symbol="
         + this.getSymbol()
         + ", oneWeight="
         + this.getOneWeight()
         + ", manufacturedName="
         + this.getManufacturedName()
         + ", manufacturedType="
         + this.getManufacturedType()
         + ", manufacturedSn="
         + this.getManufacturedSn()
         + ", weight="
         + this.getWeight()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", totalLength="
         + this.getTotalLength()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", totalArea="
         + this.getTotalArea()
         + ", artifactEnclosureId="
         + this.getArtifactEnclosureId()
         + ", havePurchasedMete="
         + this.getHavePurchasedMete()
         + ", unPurchaseMete="
         + this.getUnPurchaseMete()
         + ", steelDensity="
         + this.getSteelDensity()
         + ", inboundMete="
         + this.getInboundMete()
         + ")";
   }

   public ApplyPurchaseDetailDTO(
      final Long id,
      final Long classifyId,
      final Long applyPurchaseId,
      final String classifyName,
      final Integer basicClass,
      final String specification,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final String brand,
      final String color,
      final BigDecimal quantity,
      final BigDecimal mete,
      final String materialSn,
      final Long materialInventoryId,
      final MaterialFreezeNumDTO materialFreezeNum,
      final String name,
      final ProjectInfo project,
      final NameInfo monomer,
      final NameInfo area,
      final String serialNumber,
      final String heatNoAndBatchNo,
      final String remark,
      final NameInfo structureClassify,
      final String material,
      final BigDecimal netWeight,
      final LocalDateTime arrivalTime,
      final Boolean boolPurchase,
      final LocalDateTime inboundTime,
      final BigDecimal productMete,
      final BigDecimal productQuantity,
      final String projectName,
      final String model,
      final Long standardId,
      final String sectionSteelSpec,
      final String doNotSectionSteelSpec,
      final String measureUnit,
      final String accountingUnit,
      final String symbol,
      final BigDecimal oneWeight,
      final String manufacturedName,
      final Integer manufacturedType,
      final String manufacturedSn,
      final BigDecimal weight,
      final BigDecimal totalWeight,
      final BigDecimal totalLength,
      final BigDecimal surfaceArea,
      final BigDecimal totalArea,
      final Long artifactEnclosureId,
      final BigDecimal havePurchasedMete,
      final BigDecimal unPurchaseMete,
      final BigDecimal steelDensity,
      final BigDecimal inboundMete
   ) {
      this.id = id;
      this.classifyId = classifyId;
      this.applyPurchaseId = applyPurchaseId;
      this.classifyName = classifyName;
      this.basicClass = basicClass;
      this.specification = specification;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.brand = brand;
      this.color = color;
      this.quantity = quantity;
      this.mete = mete;
      this.materialSn = materialSn;
      this.materialInventoryId = materialInventoryId;
      this.materialFreezeNum = materialFreezeNum;
      this.name = name;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.serialNumber = serialNumber;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.remark = remark;
      this.structureClassify = structureClassify;
      this.material = material;
      this.netWeight = netWeight;
      this.arrivalTime = arrivalTime;
      this.boolPurchase = boolPurchase;
      this.inboundTime = inboundTime;
      this.productMete = productMete;
      this.productQuantity = productQuantity;
      this.projectName = projectName;
      this.model = model;
      this.standardId = standardId;
      this.sectionSteelSpec = sectionSteelSpec;
      this.doNotSectionSteelSpec = doNotSectionSteelSpec;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.symbol = symbol;
      this.oneWeight = oneWeight;
      this.manufacturedName = manufacturedName;
      this.manufacturedType = manufacturedType;
      this.manufacturedSn = manufacturedSn;
      this.weight = weight;
      this.totalWeight = totalWeight;
      this.totalLength = totalLength;
      this.surfaceArea = surfaceArea;
      this.totalArea = totalArea;
      this.artifactEnclosureId = artifactEnclosureId;
      this.havePurchasedMete = havePurchasedMete;
      this.unPurchaseMete = unPurchaseMete;
      this.steelDensity = steelDensity;
      this.inboundMete = inboundMete;
   }

   public ApplyPurchaseDetailDTO() {
   }

   public static class ApplyPurchaseDetailDTOBuilder {
      private Long id;
      private Long classifyId;
      private Long applyPurchaseId;
      private String classifyName;
      private Integer basicClass;
      private String specification;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private String brand;
      private String color;
      private BigDecimal quantity;
      private BigDecimal mete;
      private String materialSn;
      private Long materialInventoryId;
      private MaterialFreezeNumDTO materialFreezeNum;
      private String name;
      private ProjectInfo project;
      private NameInfo monomer;
      private NameInfo area;
      private String serialNumber;
      private String heatNoAndBatchNo;
      private String remark;
      private NameInfo structureClassify;
      private String material;
      private BigDecimal netWeight;
      private LocalDateTime arrivalTime;
      private Boolean boolPurchase;
      private LocalDateTime inboundTime;
      private BigDecimal productMete;
      private BigDecimal productQuantity;
      private String projectName;
      private String model;
      private Long standardId;
      private String sectionSteelSpec;
      private String doNotSectionSteelSpec;
      private String measureUnit;
      private String accountingUnit;
      private String symbol;
      private BigDecimal oneWeight;
      private String manufacturedName;
      private Integer manufacturedType;
      private String manufacturedSn;
      private BigDecimal weight;
      private BigDecimal totalWeight;
      private BigDecimal totalLength;
      private BigDecimal surfaceArea;
      private BigDecimal totalArea;
      private Long artifactEnclosureId;
      private BigDecimal havePurchasedMete;
      private BigDecimal unPurchaseMete;
      private BigDecimal steelDensity;
      private BigDecimal inboundMete;

      ApplyPurchaseDetailDTOBuilder() {
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder applyPurchaseId(final Long applyPurchaseId) {
         this.applyPurchaseId = applyPurchaseId;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder materialFreezeNum(final MaterialFreezeNumDTO materialFreezeNum) {
         this.materialFreezeNum = materialFreezeNum;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder structureClassify(final NameInfo structureClassify) {
         this.structureClassify = structureClassify;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder arrivalTime(final LocalDateTime arrivalTime) {
         this.arrivalTime = arrivalTime;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder boolPurchase(final Boolean boolPurchase) {
         this.boolPurchase = boolPurchase;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder inboundTime(final LocalDateTime inboundTime) {
         this.inboundTime = inboundTime;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder productMete(final BigDecimal productMete) {
         this.productMete = productMete;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder productQuantity(final BigDecimal productQuantity) {
         this.productQuantity = productQuantity;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder model(final String model) {
         this.model = model;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder sectionSteelSpec(final String sectionSteelSpec) {
         this.sectionSteelSpec = sectionSteelSpec;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder doNotSectionSteelSpec(final String doNotSectionSteelSpec) {
         this.doNotSectionSteelSpec = doNotSectionSteelSpec;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder symbol(final String symbol) {
         this.symbol = symbol;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder oneWeight(final BigDecimal oneWeight) {
         this.oneWeight = oneWeight;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder manufacturedName(final String manufacturedName) {
         this.manufacturedName = manufacturedName;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder manufacturedType(final Integer manufacturedType) {
         this.manufacturedType = manufacturedType;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder manufacturedSn(final String manufacturedSn) {
         this.manufacturedSn = manufacturedSn;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder artifactEnclosureId(final Long artifactEnclosureId) {
         this.artifactEnclosureId = artifactEnclosureId;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder havePurchasedMete(final BigDecimal havePurchasedMete) {
         this.havePurchasedMete = havePurchasedMete;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder unPurchaseMete(final BigDecimal unPurchaseMete) {
         this.unPurchaseMete = unPurchaseMete;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder steelDensity(final BigDecimal steelDensity) {
         this.steelDensity = steelDensity;
         return this;
      }

      public ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder inboundMete(final BigDecimal inboundMete) {
         this.inboundMete = inboundMete;
         return this;
      }

      public ApplyPurchaseDetailDTO build() {
         return new ApplyPurchaseDetailDTO(
            this.id,
            this.classifyId,
            this.applyPurchaseId,
            this.classifyName,
            this.basicClass,
            this.specification,
            this.length,
            this.width,
            this.thickness,
            this.brand,
            this.color,
            this.quantity,
            this.mete,
            this.materialSn,
            this.materialInventoryId,
            this.materialFreezeNum,
            this.name,
            this.project,
            this.monomer,
            this.area,
            this.serialNumber,
            this.heatNoAndBatchNo,
            this.remark,
            this.structureClassify,
            this.material,
            this.netWeight,
            this.arrivalTime,
            this.boolPurchase,
            this.inboundTime,
            this.productMete,
            this.productQuantity,
            this.projectName,
            this.model,
            this.standardId,
            this.sectionSteelSpec,
            this.doNotSectionSteelSpec,
            this.measureUnit,
            this.accountingUnit,
            this.symbol,
            this.oneWeight,
            this.manufacturedName,
            this.manufacturedType,
            this.manufacturedSn,
            this.weight,
            this.totalWeight,
            this.totalLength,
            this.surfaceArea,
            this.totalArea,
            this.artifactEnclosureId,
            this.havePurchasedMete,
            this.unPurchaseMete,
            this.steelDensity,
            this.inboundMete
         );
      }

      @Override
      public String toString() {
         return "ApplyPurchaseDetailDTO.ApplyPurchaseDetailDTOBuilder(id="
            + this.id
            + ", classifyId="
            + this.classifyId
            + ", applyPurchaseId="
            + this.applyPurchaseId
            + ", classifyName="
            + this.classifyName
            + ", basicClass="
            + this.basicClass
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
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", materialSn="
            + this.materialSn
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", materialFreezeNum="
            + this.materialFreezeNum
            + ", name="
            + this.name
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", serialNumber="
            + this.serialNumber
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", remark="
            + this.remark
            + ", structureClassify="
            + this.structureClassify
            + ", material="
            + this.material
            + ", netWeight="
            + this.netWeight
            + ", arrivalTime="
            + this.arrivalTime
            + ", boolPurchase="
            + this.boolPurchase
            + ", inboundTime="
            + this.inboundTime
            + ", productMete="
            + this.productMete
            + ", productQuantity="
            + this.productQuantity
            + ", projectName="
            + this.projectName
            + ", model="
            + this.model
            + ", standardId="
            + this.standardId
            + ", sectionSteelSpec="
            + this.sectionSteelSpec
            + ", doNotSectionSteelSpec="
            + this.doNotSectionSteelSpec
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", symbol="
            + this.symbol
            + ", oneWeight="
            + this.oneWeight
            + ", manufacturedName="
            + this.manufacturedName
            + ", manufacturedType="
            + this.manufacturedType
            + ", manufacturedSn="
            + this.manufacturedSn
            + ", weight="
            + this.weight
            + ", totalWeight="
            + this.totalWeight
            + ", totalLength="
            + this.totalLength
            + ", surfaceArea="
            + this.surfaceArea
            + ", totalArea="
            + this.totalArea
            + ", artifactEnclosureId="
            + this.artifactEnclosureId
            + ", havePurchasedMete="
            + this.havePurchasedMete
            + ", unPurchaseMete="
            + this.unPurchaseMete
            + ", steelDensity="
            + this.steelDensity
            + ", inboundMete="
            + this.inboundMete
            + ")";
      }
   }
}
