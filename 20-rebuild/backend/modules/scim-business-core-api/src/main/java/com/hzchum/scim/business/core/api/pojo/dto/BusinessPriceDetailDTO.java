package com.hzchum.scim.business.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "BusinessPriceDetail对象", description = "商务产品计价明细表 ")
public class BusinessPriceDetailDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "boolAddEnum", value = "是否追加", notes = "是否追加")
   private Boolean boolAddEnum;
   @ApiModelProperty(name = "businessPriceId", value = "计价表id", notes = "计价表id")
   private Long businessPriceId;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id", notes = "分支机构id")
   private Long branchCompanyId;
   @ApiModelProperty(name = "level", value = "分支机构等级", notes = "分支机构等级")
   private Integer level;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   private Long areaId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "pricingMannerEnum", value = "计价类型", notes = "计价类型")
   private Integer pricingMannerEnum;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "pricingUnitTypeEnum", value = "计价单位类型 1千克 2吨 ", notes = "计价单位 1千克 2吨")
   private Integer pricingUnitTypeEnum;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "pricingWeightTypeEnum", value = "(构件)计价重量类型 1净重 2毛重 4图纸重'", notes = "(构件)计价重量类型 1净重 2毛重 4图纸重'")
   private Integer pricingWeightTypeEnum;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty("围护类型名称")
   @JsonInclude(Include.NON_NULL)
   private String enclosureType;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("材质")
   @JsonInclude(Include.NON_NULL)
   private String material;
   @ApiModelProperty("长度")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal length;
   @ApiModelProperty(name = "totalLength", value = "总长度(m)")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalLength;
   @ApiModelProperty(name = "surfaceArea", value = "单面积(m²)")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "totalArea", value = "总面积(m²)")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalArea;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   private BigDecimal quantity;
   @ApiModelProperty("单重（kg）")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal weight;
   @ApiModelProperty("总重（kg）")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalWeight;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   private BigDecimal totalNetWeight;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   private BigDecimal grossWeight;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）")
   private BigDecimal totalGrossWeight;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "drawingWeight", value = "单图纸重量")
   private BigDecimal drawingWeight;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "drawingTotalWeight", value = "总图纸重量")
   private BigDecimal drawingTotalWeight;
   @ApiModelProperty(name = "pricingMete", value = "计价量", notes = "计价量")
   private BigDecimal pricingMete;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   private String measureUnit;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "totalPrice", value = "总价", notes = "总价")
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "auditStatus", value = "审核状态", notes = "审核状态")
   private Integer auditStatus;
   @ApiModelProperty(name = "auditUserId", value = "审核人id", notes = "审核人id")
   private Long auditUserId;
   @ApiModelProperty(name = "auditUserName", value = "审核人", notes = "审核人")
   private String auditUserName;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   private LocalDateTime auditTime;

   public static BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder builder() {
      return new BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder();
   }

   public BusinessPriceDetailDTO() {
   }

   public BusinessPriceDetailDTO(
      final Long id,
      final Boolean boolAddEnum,
      final Long businessPriceId,
      final Long branchCompanyId,
      final Integer level,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer pricingMannerEnum,
      final Integer pricingUnitTypeEnum,
      final Integer pricingWeightTypeEnum,
      final Integer productType,
      final Long productId,
      final String enclosureType,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final BigDecimal length,
      final BigDecimal totalLength,
      final BigDecimal surfaceArea,
      final BigDecimal totalArea,
      final BigDecimal quantity,
      final BigDecimal weight,
      final BigDecimal totalWeight,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal drawingWeight,
      final BigDecimal drawingTotalWeight,
      final BigDecimal pricingMete,
      final String measureUnit,
      final String accountingUnit,
      final BigDecimal unitPrice,
      final BigDecimal totalPrice,
      final Integer auditStatus,
      final Long auditUserId,
      final String auditUserName,
      final LocalDateTime auditTime
   ) {
      this.id = id;
      this.boolAddEnum = boolAddEnum;
      this.businessPriceId = businessPriceId;
      this.branchCompanyId = branchCompanyId;
      this.level = level;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.pricingMannerEnum = pricingMannerEnum;
      this.pricingUnitTypeEnum = pricingUnitTypeEnum;
      this.pricingWeightTypeEnum = pricingWeightTypeEnum;
      this.productType = productType;
      this.productId = productId;
      this.enclosureType = enclosureType;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.length = length;
      this.totalLength = totalLength;
      this.surfaceArea = surfaceArea;
      this.totalArea = totalArea;
      this.quantity = quantity;
      this.weight = weight;
      this.totalWeight = totalWeight;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.drawingWeight = drawingWeight;
      this.drawingTotalWeight = drawingTotalWeight;
      this.pricingMete = pricingMete;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.unitPrice = unitPrice;
      this.totalPrice = totalPrice;
      this.auditStatus = auditStatus;
      this.auditUserId = auditUserId;
      this.auditUserName = auditUserName;
      this.auditTime = auditTime;
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolAddEnum() {
      return this.boolAddEnum;
   }

   public Long getBusinessPriceId() {
      return this.businessPriceId;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Integer getLevel() {
      return this.level;
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

   public Integer getPricingMannerEnum() {
      return this.pricingMannerEnum;
   }

   public Integer getPricingUnitTypeEnum() {
      return this.pricingUnitTypeEnum;
   }

   public Integer getPricingWeightTypeEnum() {
      return this.pricingWeightTypeEnum;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getEnclosureType() {
      return this.enclosureType;
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

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getLength() {
      return this.length;
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

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
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

   public BigDecimal getDrawingWeight() {
      return this.drawingWeight;
   }

   public BigDecimal getDrawingTotalWeight() {
      return this.drawingTotalWeight;
   }

   public BigDecimal getPricingMete() {
      return this.pricingMete;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBoolAddEnum(final Boolean boolAddEnum) {
      this.boolAddEnum = boolAddEnum;
   }

   public void setBusinessPriceId(final Long businessPriceId) {
      this.businessPriceId = businessPriceId;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setLevel(final Integer level) {
      this.level = level;
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

   public void setPricingMannerEnum(final Integer pricingMannerEnum) {
      this.pricingMannerEnum = pricingMannerEnum;
   }

   public void setPricingUnitTypeEnum(final Integer pricingUnitTypeEnum) {
      this.pricingUnitTypeEnum = pricingUnitTypeEnum;
   }

   public void setPricingWeightTypeEnum(final Integer pricingWeightTypeEnum) {
      this.pricingWeightTypeEnum = pricingWeightTypeEnum;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setEnclosureType(final String enclosureType) {
      this.enclosureType = enclosureType;
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

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
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

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
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

   public void setDrawingWeight(final BigDecimal drawingWeight) {
      this.drawingWeight = drawingWeight;
   }

   public void setDrawingTotalWeight(final BigDecimal drawingTotalWeight) {
      this.drawingTotalWeight = drawingTotalWeight;
   }

   public void setPricingMete(final BigDecimal pricingMete) {
      this.pricingMete = pricingMete;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessPriceDetailDTO)) {
         return false;
      }

      BusinessPriceDetailDTO other = (BusinessPriceDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolAddEnum = this.getBoolAddEnum();
         Object other$boolAddEnum = other.getBoolAddEnum();
         if (this$boolAddEnum == null ? other$boolAddEnum == null : this$boolAddEnum.equals(other$boolAddEnum)) {
            Object this$businessPriceId = this.getBusinessPriceId();
            Object other$businessPriceId = other.getBusinessPriceId();
            if (this$businessPriceId == null ? other$businessPriceId == null : this$businessPriceId.equals(other$businessPriceId)) {
               Object this$branchCompanyId = this.getBranchCompanyId();
               Object other$branchCompanyId = other.getBranchCompanyId();
               if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                  Object this$level = this.getLevel();
                  Object other$level = other.getLevel();
                  if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$monomerId = this.getMonomerId();
                        Object other$monomerId = other.getMonomerId();
                        if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                           Object this$areaId = this.getAreaId();
                           Object other$areaId = other.getAreaId();
                           if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                              Object this$pricingMannerEnum = this.getPricingMannerEnum();
                              Object other$pricingMannerEnum = other.getPricingMannerEnum();
                              if (this$pricingMannerEnum == null ? other$pricingMannerEnum == null : this$pricingMannerEnum.equals(other$pricingMannerEnum)) {
                                 Object this$pricingUnitTypeEnum = this.getPricingUnitTypeEnum();
                                 Object other$pricingUnitTypeEnum = other.getPricingUnitTypeEnum();
                                 if (this$pricingUnitTypeEnum == null
                                    ? other$pricingUnitTypeEnum == null
                                    : this$pricingUnitTypeEnum.equals(other$pricingUnitTypeEnum)) {
                                    Object this$pricingWeightTypeEnum = this.getPricingWeightTypeEnum();
                                    Object other$pricingWeightTypeEnum = other.getPricingWeightTypeEnum();
                                    if (this$pricingWeightTypeEnum == null
                                       ? other$pricingWeightTypeEnum == null
                                       : this$pricingWeightTypeEnum.equals(other$pricingWeightTypeEnum)) {
                                       Object this$productType = this.getProductType();
                                       Object other$productType = other.getProductType();
                                       if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                          Object this$productId = this.getProductId();
                                          Object other$productId = other.getProductId();
                                          if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                             Object this$auditStatus = this.getAuditStatus();
                                             Object other$auditStatus = other.getAuditStatus();
                                             if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                                Object this$auditUserId = this.getAuditUserId();
                                                Object other$auditUserId = other.getAuditUserId();
                                                if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                                                   Object this$enclosureType = this.getEnclosureType();
                                                   Object other$enclosureType = other.getEnclosureType();
                                                   if (this$enclosureType == null
                                                      ? other$enclosureType == null
                                                      : this$enclosureType.equals(other$enclosureType)) {
                                                      Object this$name = this.getName();
                                                      Object other$name = other.getName();
                                                      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                         Object this$serialNumber = this.getSerialNumber();
                                                         Object other$serialNumber = other.getSerialNumber();
                                                         if (this$serialNumber == null
                                                            ? other$serialNumber == null
                                                            : this$serialNumber.equals(other$serialNumber)) {
                                                            Object this$specification = this.getSpecification();
                                                            Object other$specification = other.getSpecification();
                                                            if (this$specification == null
                                                               ? other$specification == null
                                                               : this$specification.equals(other$specification)) {
                                                               Object this$material = this.getMaterial();
                                                               Object other$material = other.getMaterial();
                                                               if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                                  Object this$length = this.getLength();
                                                                  Object other$length = other.getLength();
                                                                  if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                     Object this$totalLength = this.getTotalLength();
                                                                     Object other$totalLength = other.getTotalLength();
                                                                     if (this$totalLength == null
                                                                        ? other$totalLength == null
                                                                        : this$totalLength.equals(other$totalLength)) {
                                                                        Object this$surfaceArea = this.getSurfaceArea();
                                                                        Object other$surfaceArea = other.getSurfaceArea();
                                                                        if (this$surfaceArea == null
                                                                           ? other$surfaceArea == null
                                                                           : this$surfaceArea.equals(other$surfaceArea)) {
                                                                           Object this$totalArea = this.getTotalArea();
                                                                           Object other$totalArea = other.getTotalArea();
                                                                           if (this$totalArea == null
                                                                              ? other$totalArea == null
                                                                              : this$totalArea.equals(other$totalArea)) {
                                                                              Object this$quantity = this.getQuantity();
                                                                              Object other$quantity = other.getQuantity();
                                                                              if (this$quantity == null
                                                                                 ? other$quantity == null
                                                                                 : this$quantity.equals(other$quantity)) {
                                                                                 Object this$weight = this.getWeight();
                                                                                 Object other$weight = other.getWeight();
                                                                                 if (this$weight == null
                                                                                    ? other$weight == null
                                                                                    : this$weight.equals(other$weight)) {
                                                                                    Object this$totalWeight = this.getTotalWeight();
                                                                                    Object other$totalWeight = other.getTotalWeight();
                                                                                    if (this$totalWeight == null
                                                                                       ? other$totalWeight == null
                                                                                       : this$totalWeight.equals(other$totalWeight)) {
                                                                                       Object this$netWeight = this.getNetWeight();
                                                                                       Object other$netWeight = other.getNetWeight();
                                                                                       if (this$netWeight == null
                                                                                          ? other$netWeight == null
                                                                                          : this$netWeight.equals(other$netWeight)) {
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
                                                                                                   Object this$drawingWeight = this.getDrawingWeight();
                                                                                                   Object other$drawingWeight = other.getDrawingWeight();
                                                                                                   if (this$drawingWeight == null
                                                                                                      ? other$drawingWeight == null
                                                                                                      : this$drawingWeight.equals(other$drawingWeight)) {
                                                                                                      Object this$drawingTotalWeight = this.getDrawingTotalWeight();
                                                                                                      Object other$drawingTotalWeight = other.getDrawingTotalWeight();
                                                                                                      if (this$drawingTotalWeight == null
                                                                                                         ? other$drawingTotalWeight == null
                                                                                                         : this$drawingTotalWeight.equals(
                                                                                                            other$drawingTotalWeight
                                                                                                         )) {
                                                                                                         Object this$pricingMete = this.getPricingMete();
                                                                                                         Object other$pricingMete = other.getPricingMete();
                                                                                                         if (this$pricingMete == null
                                                                                                            ? other$pricingMete == null
                                                                                                            : this$pricingMete.equals(other$pricingMete)) {
                                                                                                            Object this$measureUnit = this.getMeasureUnit();
                                                                                                            Object other$measureUnit = other.getMeasureUnit();
                                                                                                            if (this$measureUnit == null
                                                                                                               ? other$measureUnit == null
                                                                                                               : this$measureUnit.equals(other$measureUnit)) {
                                                                                                               Object this$accountingUnit = this.getAccountingUnit();
                                                                                                               Object other$accountingUnit = other.getAccountingUnit();
                                                                                                               if (this$accountingUnit == null
                                                                                                                  ? other$accountingUnit == null
                                                                                                                  : this$accountingUnit.equals(
                                                                                                                     other$accountingUnit
                                                                                                                  )) {
                                                                                                                  Object this$unitPrice = this.getUnitPrice();
                                                                                                                  Object other$unitPrice = other.getUnitPrice();
                                                                                                                  if (this$unitPrice == null
                                                                                                                     ? other$unitPrice == null
                                                                                                                     : this$unitPrice.equals(other$unitPrice)) {
                                                                                                                     Object this$totalPrice = this.getTotalPrice();
                                                                                                                     Object other$totalPrice = other.getTotalPrice();
                                                                                                                     if (this$totalPrice == null
                                                                                                                        ? other$totalPrice == null
                                                                                                                        : this$totalPrice.equals(
                                                                                                                           other$totalPrice
                                                                                                                        )) {
                                                                                                                        Object this$auditUserName = this.getAuditUserName();
                                                                                                                        Object other$auditUserName = other.getAuditUserName();
                                                                                                                        if (this$auditUserName == null
                                                                                                                           ? other$auditUserName == null
                                                                                                                           : this$auditUserName.equals(
                                                                                                                              other$auditUserName
                                                                                                                           )) {
                                                                                                                           Object this$auditTime = this.getAuditTime();
                                                                                                                           Object other$auditTime = other.getAuditTime();
                                                                                                                           return this$auditTime == null
                                                                                                                              ? other$auditTime == null
                                                                                                                              : this$auditTime.equals(
                                                                                                                                 other$auditTime
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BusinessPriceDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolAddEnum = this.getBoolAddEnum();
      result = result * 59 + ($boolAddEnum == null ? 43 : $boolAddEnum.hashCode());
      Object $businessPriceId = this.getBusinessPriceId();
      result = result * 59 + ($businessPriceId == null ? 43 : $businessPriceId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $pricingMannerEnum = this.getPricingMannerEnum();
      result = result * 59 + ($pricingMannerEnum == null ? 43 : $pricingMannerEnum.hashCode());
      Object $pricingUnitTypeEnum = this.getPricingUnitTypeEnum();
      result = result * 59 + ($pricingUnitTypeEnum == null ? 43 : $pricingUnitTypeEnum.hashCode());
      Object $pricingWeightTypeEnum = this.getPricingWeightTypeEnum();
      result = result * 59 + ($pricingWeightTypeEnum == null ? 43 : $pricingWeightTypeEnum.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $enclosureType = this.getEnclosureType();
      result = result * 59 + ($enclosureType == null ? 43 : $enclosureType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $drawingWeight = this.getDrawingWeight();
      result = result * 59 + ($drawingWeight == null ? 43 : $drawingWeight.hashCode());
      Object $drawingTotalWeight = this.getDrawingTotalWeight();
      result = result * 59 + ($drawingTotalWeight == null ? 43 : $drawingTotalWeight.hashCode());
      Object $pricingMete = this.getPricingMete();
      result = result * 59 + ($pricingMete == null ? 43 : $pricingMete.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessPriceDetailDTO(id="
         + this.getId()
         + ", boolAddEnum="
         + this.getBoolAddEnum()
         + ", businessPriceId="
         + this.getBusinessPriceId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", level="
         + this.getLevel()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", pricingMannerEnum="
         + this.getPricingMannerEnum()
         + ", pricingUnitTypeEnum="
         + this.getPricingUnitTypeEnum()
         + ", pricingWeightTypeEnum="
         + this.getPricingWeightTypeEnum()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", enclosureType="
         + this.getEnclosureType()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
         + ", totalLength="
         + this.getTotalLength()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", totalArea="
         + this.getTotalArea()
         + ", quantity="
         + this.getQuantity()
         + ", weight="
         + this.getWeight()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", drawingWeight="
         + this.getDrawingWeight()
         + ", drawingTotalWeight="
         + this.getDrawingTotalWeight()
         + ", pricingMete="
         + this.getPricingMete()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ")";
   }

   public static class BusinessPriceDetailDTOBuilder {
      private Long id;
      private Boolean boolAddEnum;
      private Long businessPriceId;
      private Long branchCompanyId;
      private Integer level;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer pricingMannerEnum;
      private Integer pricingUnitTypeEnum;
      private Integer pricingWeightTypeEnum;
      private Integer productType;
      private Long productId;
      private String enclosureType;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private BigDecimal length;
      private BigDecimal totalLength;
      private BigDecimal surfaceArea;
      private BigDecimal totalArea;
      private BigDecimal quantity;
      private BigDecimal weight;
      private BigDecimal totalWeight;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal drawingWeight;
      private BigDecimal drawingTotalWeight;
      private BigDecimal pricingMete;
      private String measureUnit;
      private String accountingUnit;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private Integer auditStatus;
      private Long auditUserId;
      private String auditUserName;
      private LocalDateTime auditTime;

      BusinessPriceDetailDTOBuilder() {
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder boolAddEnum(final Boolean boolAddEnum) {
         this.boolAddEnum = boolAddEnum;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder businessPriceId(final Long businessPriceId) {
         this.businessPriceId = businessPriceId;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder pricingMannerEnum(final Integer pricingMannerEnum) {
         this.pricingMannerEnum = pricingMannerEnum;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder pricingUnitTypeEnum(final Integer pricingUnitTypeEnum) {
         this.pricingUnitTypeEnum = pricingUnitTypeEnum;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder pricingWeightTypeEnum(final Integer pricingWeightTypeEnum) {
         this.pricingWeightTypeEnum = pricingWeightTypeEnum;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder enclosureType(final String enclosureType) {
         this.enclosureType = enclosureType;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder drawingWeight(final BigDecimal drawingWeight) {
         this.drawingWeight = drawingWeight;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder drawingTotalWeight(final BigDecimal drawingTotalWeight) {
         this.drawingTotalWeight = drawingTotalWeight;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder pricingMete(final BigDecimal pricingMete) {
         this.pricingMete = pricingMete;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public BusinessPriceDetailDTO build() {
         return new BusinessPriceDetailDTO(
            this.id,
            this.boolAddEnum,
            this.businessPriceId,
            this.branchCompanyId,
            this.level,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.pricingMannerEnum,
            this.pricingUnitTypeEnum,
            this.pricingWeightTypeEnum,
            this.productType,
            this.productId,
            this.enclosureType,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.length,
            this.totalLength,
            this.surfaceArea,
            this.totalArea,
            this.quantity,
            this.weight,
            this.totalWeight,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.drawingWeight,
            this.drawingTotalWeight,
            this.pricingMete,
            this.measureUnit,
            this.accountingUnit,
            this.unitPrice,
            this.totalPrice,
            this.auditStatus,
            this.auditUserId,
            this.auditUserName,
            this.auditTime
         );
      }

      @Override
      public String toString() {
         return "BusinessPriceDetailDTO.BusinessPriceDetailDTOBuilder(id="
            + this.id
            + ", boolAddEnum="
            + this.boolAddEnum
            + ", businessPriceId="
            + this.businessPriceId
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", level="
            + this.level
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", pricingMannerEnum="
            + this.pricingMannerEnum
            + ", pricingUnitTypeEnum="
            + this.pricingUnitTypeEnum
            + ", pricingWeightTypeEnum="
            + this.pricingWeightTypeEnum
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
            + ", enclosureType="
            + this.enclosureType
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", length="
            + this.length
            + ", totalLength="
            + this.totalLength
            + ", surfaceArea="
            + this.surfaceArea
            + ", totalArea="
            + this.totalArea
            + ", quantity="
            + this.quantity
            + ", weight="
            + this.weight
            + ", totalWeight="
            + this.totalWeight
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", grossWeight="
            + this.grossWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", drawingWeight="
            + this.drawingWeight
            + ", drawingTotalWeight="
            + this.drawingTotalWeight
            + ", pricingMete="
            + this.pricingMete
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", unitPrice="
            + this.unitPrice
            + ", totalPrice="
            + this.totalPrice
            + ", auditStatus="
            + this.auditStatus
            + ", auditUserId="
            + this.auditUserId
            + ", auditUserName="
            + this.auditUserName
            + ", auditTime="
            + this.auditTime
            + ")";
      }
   }
}
