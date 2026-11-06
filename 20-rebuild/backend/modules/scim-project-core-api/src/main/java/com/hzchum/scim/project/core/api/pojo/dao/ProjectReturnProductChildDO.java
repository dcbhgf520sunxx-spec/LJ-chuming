package com.hzchum.scim.project.core.api.pojo.dao;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "ProjectReturnProductChildDO对象", description = "制成品退货子表 ")
public class ProjectReturnProductChildDO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "mainId", value = "主表id", notes = "主表id")
   private Long mainId;
   @ApiModelProperty(name = "mesBuildingWarehouseRecordId", value = "入库记录id", notes = "入库记录id")
   private Long mesBuildingWarehouseRecordId;
   @ApiModelProperty(name = "mesBuildingReturnWarehouseRecordId", value = "制成品退货记录id", notes = "入库记录id")
   private Long mesBuildingReturnWarehouseRecordId;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", value = "单体名称", notes = "单体名称")
   private String monomerName;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   private Long areaId;
   @ApiModelProperty(name = "areaName", value = "区域名称", notes = "区域名称")
   private String areaName;
   @ApiModelProperty(name = "planId", value = "计划id", notes = "计划id")
   private Long planId;
   @ApiModelProperty(name = "planName", value = "计划名称", notes = "计划名称")
   private String planName;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "productName", value = "产品名称", notes = "产品名称")
   private String productName;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   private String material;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "singleMete", value = "单核算量", notes = "单核算量")
   private BigDecimal singleMete;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "pricingManner", value = "计价方式  0重量 1长度 2面积", notes = "计价方式  0重量 1长度 2面积")
   private Integer pricingManner;
   @ApiModelProperty(name = "length", value = "单长度(mm)", notes = "单长度(mm)")
   private BigDecimal length;
   @ApiModelProperty(name = "surfaceArea", value = "单面积(mm²)")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "totalLength", value = "总长度（mm）", notes = "总长度（mm）")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "plate", value = "版型", notes = "版型")
   private String plate;
   @ApiModelProperty(name = "totalArea", value = "总面积（㎡）", notes = "总面积（㎡）")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "totalAmount", value = "总金额", notes = "总金额")
   private BigDecimal totalAmount;
   @ApiModelProperty(name = "netWeight", value = "单净重（t）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（t）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（t）")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（t）")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "storageDuration", value = "存储时长", notes = "存储时长")
   private String storageDuration;
   @ApiModelProperty(name = "warehouseId", value = "存储仓库id", notes = "存储仓库id")
   private Long warehouseId;
   @ApiModelProperty(name = "warehouse", value = "存储仓库", notes = "存储仓库")
   private NameInfo warehouse;
   @ApiModelProperty(name = "productReason", value = "产品原因", notes = "产品原因")
   private String productReason;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   private Long factoryId;
   @ApiModelProperty("车间id")
   private Long workshopId;
   @ApiModelProperty(name = "thickness", value = "厚度", notes = "厚度")
   private BigDecimal thickness;
   @ApiModelProperty(name = "color", value = "颜色", notes = "颜色")
   private String color;
   @ApiModelProperty(name = "createTime", value = "退货时间", notes = "退货时间")
   private LocalDateTime createTime;

   public static ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder builder() {
      return new ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder();
   }

   public ProjectReturnProductChildDO(
      final Long id,
      final Long mainId,
      final Long mesBuildingWarehouseRecordId,
      final Long mesBuildingReturnWarehouseRecordId,
      final Long projectId,
      final String projectName,
      final Long monomerId,
      final String monomerName,
      final Long areaId,
      final String areaName,
      final Long planId,
      final String planName,
      final Long productId,
      final String productName,
      final Integer productType,
      final String serialNumber,
      final String specification,
      final String material,
      final String measureUnit,
      final String accountingUnit,
      final BigDecimal quantity,
      final BigDecimal mete,
      final BigDecimal singleMete,
      final BigDecimal unitPrice,
      final Integer pricingManner,
      final BigDecimal length,
      final BigDecimal surfaceArea,
      final BigDecimal totalLength,
      final String plate,
      final BigDecimal totalArea,
      final BigDecimal totalAmount,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final String storageDuration,
      final Long warehouseId,
      final NameInfo warehouse,
      final String productReason,
      final Long factoryId,
      final Long workshopId,
      final BigDecimal thickness,
      final String color,
      final LocalDateTime createTime
   ) {
      this.id = id;
      this.mainId = mainId;
      this.mesBuildingWarehouseRecordId = mesBuildingWarehouseRecordId;
      this.mesBuildingReturnWarehouseRecordId = mesBuildingReturnWarehouseRecordId;
      this.projectId = projectId;
      this.projectName = projectName;
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.areaId = areaId;
      this.areaName = areaName;
      this.planId = planId;
      this.planName = planName;
      this.productId = productId;
      this.productName = productName;
      this.productType = productType;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.quantity = quantity;
      this.mete = mete;
      this.singleMete = singleMete;
      this.unitPrice = unitPrice;
      this.pricingManner = pricingManner;
      this.length = length;
      this.surfaceArea = surfaceArea;
      this.totalLength = totalLength;
      this.plate = plate;
      this.totalArea = totalArea;
      this.totalAmount = totalAmount;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.storageDuration = storageDuration;
      this.warehouseId = warehouseId;
      this.warehouse = warehouse;
      this.productReason = productReason;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.thickness = thickness;
      this.color = color;
      this.createTime = createTime;
   }

   public ProjectReturnProductChildDO() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getMainId() {
      return this.mainId;
   }

   public Long getMesBuildingWarehouseRecordId() {
      return this.mesBuildingWarehouseRecordId;
   }

   public Long getMesBuildingReturnWarehouseRecordId() {
      return this.mesBuildingReturnWarehouseRecordId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public String getPlanName() {
      return this.planName;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getProductName() {
      return this.productName;
   }

   public Integer getProductType() {
      return this.productType;
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

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getSingleMete() {
      return this.singleMete;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public String getPlate() {
      return this.plate;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
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

   public String getStorageDuration() {
      return this.storageDuration;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public NameInfo getWarehouse() {
      return this.warehouse;
   }

   public String getProductReason() {
      return this.productReason;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getColor() {
      return this.color;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMainId(final Long mainId) {
      this.mainId = mainId;
   }

   public void setMesBuildingWarehouseRecordId(final Long mesBuildingWarehouseRecordId) {
      this.mesBuildingWarehouseRecordId = mesBuildingWarehouseRecordId;
   }

   public void setMesBuildingReturnWarehouseRecordId(final Long mesBuildingReturnWarehouseRecordId) {
      this.mesBuildingReturnWarehouseRecordId = mesBuildingReturnWarehouseRecordId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setPlanId(final Long planId) {
      this.planId = planId;
   }

   public void setPlanName(final String planName) {
      this.planName = planName;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductName(final String productName) {
      this.productName = productName;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
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

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setSingleMete(final BigDecimal singleMete) {
      this.singleMete = singleMete;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setPlate(final String plate) {
      this.plate = plate;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
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

   public void setStorageDuration(final String storageDuration) {
      this.storageDuration = storageDuration;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setWarehouse(final NameInfo warehouse) {
      this.warehouse = warehouse;
   }

   public void setProductReason(final String productReason) {
      this.productReason = productReason;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReturnProductChildDO)) {
         return false;
      }

      ProjectReturnProductChildDO other = (ProjectReturnProductChildDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$mainId = this.getMainId();
         Object other$mainId = other.getMainId();
         if (this$mainId == null ? other$mainId == null : this$mainId.equals(other$mainId)) {
            Object this$mesBuildingWarehouseRecordId = this.getMesBuildingWarehouseRecordId();
            Object other$mesBuildingWarehouseRecordId = other.getMesBuildingWarehouseRecordId();
            if (this$mesBuildingWarehouseRecordId == null
               ? other$mesBuildingWarehouseRecordId == null
               : this$mesBuildingWarehouseRecordId.equals(other$mesBuildingWarehouseRecordId)) {
               Object this$mesBuildingReturnWarehouseRecordId = this.getMesBuildingReturnWarehouseRecordId();
               Object other$mesBuildingReturnWarehouseRecordId = other.getMesBuildingReturnWarehouseRecordId();
               if (this$mesBuildingReturnWarehouseRecordId == null
                  ? other$mesBuildingReturnWarehouseRecordId == null
                  : this$mesBuildingReturnWarehouseRecordId.equals(other$mesBuildingReturnWarehouseRecordId)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$monomerId = this.getMonomerId();
                     Object other$monomerId = other.getMonomerId();
                     if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                        Object this$areaId = this.getAreaId();
                        Object other$areaId = other.getAreaId();
                        if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                           Object this$planId = this.getPlanId();
                           Object other$planId = other.getPlanId();
                           if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                              Object this$productId = this.getProductId();
                              Object other$productId = other.getProductId();
                              if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                 Object this$productType = this.getProductType();
                                 Object other$productType = other.getProductType();
                                 if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                    Object this$pricingManner = this.getPricingManner();
                                    Object other$pricingManner = other.getPricingManner();
                                    if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
                                       Object this$warehouseId = this.getWarehouseId();
                                       Object other$warehouseId = other.getWarehouseId();
                                       if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                          Object this$factoryId = this.getFactoryId();
                                          Object other$factoryId = other.getFactoryId();
                                          if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                                             Object this$workshopId = this.getWorkshopId();
                                             Object other$workshopId = other.getWorkshopId();
                                             if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                                Object this$projectName = this.getProjectName();
                                                Object other$projectName = other.getProjectName();
                                                if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                                   Object this$monomerName = this.getMonomerName();
                                                   Object other$monomerName = other.getMonomerName();
                                                   if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                                      Object this$areaName = this.getAreaName();
                                                      Object other$areaName = other.getAreaName();
                                                      if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                                         Object this$planName = this.getPlanName();
                                                         Object other$planName = other.getPlanName();
                                                         if (this$planName == null ? other$planName == null : this$planName.equals(other$planName)) {
                                                            Object this$productName = this.getProductName();
                                                            Object other$productName = other.getProductName();
                                                            if (this$productName == null
                                                               ? other$productName == null
                                                               : this$productName.equals(other$productName)) {
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
                                                                        Object this$measureUnit = this.getMeasureUnit();
                                                                        Object other$measureUnit = other.getMeasureUnit();
                                                                        if (this$measureUnit == null
                                                                           ? other$measureUnit == null
                                                                           : this$measureUnit.equals(other$measureUnit)) {
                                                                           Object this$accountingUnit = this.getAccountingUnit();
                                                                           Object other$accountingUnit = other.getAccountingUnit();
                                                                           if (this$accountingUnit == null
                                                                              ? other$accountingUnit == null
                                                                              : this$accountingUnit.equals(other$accountingUnit)) {
                                                                              Object this$quantity = this.getQuantity();
                                                                              Object other$quantity = other.getQuantity();
                                                                              if (this$quantity == null
                                                                                 ? other$quantity == null
                                                                                 : this$quantity.equals(other$quantity)) {
                                                                                 Object this$mete = this.getMete();
                                                                                 Object other$mete = other.getMete();
                                                                                 if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                                    Object this$singleMete = this.getSingleMete();
                                                                                    Object other$singleMete = other.getSingleMete();
                                                                                    if (this$singleMete == null
                                                                                       ? other$singleMete == null
                                                                                       : this$singleMete.equals(other$singleMete)) {
                                                                                       Object this$unitPrice = this.getUnitPrice();
                                                                                       Object other$unitPrice = other.getUnitPrice();
                                                                                       if (this$unitPrice == null
                                                                                          ? other$unitPrice == null
                                                                                          : this$unitPrice.equals(other$unitPrice)) {
                                                                                          Object this$length = this.getLength();
                                                                                          Object other$length = other.getLength();
                                                                                          if (this$length == null
                                                                                             ? other$length == null
                                                                                             : this$length.equals(other$length)) {
                                                                                             Object this$surfaceArea = this.getSurfaceArea();
                                                                                             Object other$surfaceArea = other.getSurfaceArea();
                                                                                             if (this$surfaceArea == null
                                                                                                ? other$surfaceArea == null
                                                                                                : this$surfaceArea.equals(other$surfaceArea)) {
                                                                                                Object this$totalLength = this.getTotalLength();
                                                                                                Object other$totalLength = other.getTotalLength();
                                                                                                if (this$totalLength == null
                                                                                                   ? other$totalLength == null
                                                                                                   : this$totalLength.equals(other$totalLength)) {
                                                                                                   Object this$plate = this.getPlate();
                                                                                                   Object other$plate = other.getPlate();
                                                                                                   if (this$plate == null
                                                                                                      ? other$plate == null
                                                                                                      : this$plate.equals(other$plate)) {
                                                                                                      Object this$totalArea = this.getTotalArea();
                                                                                                      Object other$totalArea = other.getTotalArea();
                                                                                                      if (this$totalArea == null
                                                                                                         ? other$totalArea == null
                                                                                                         : this$totalArea.equals(other$totalArea)) {
                                                                                                         Object this$totalAmount = this.getTotalAmount();
                                                                                                         Object other$totalAmount = other.getTotalAmount();
                                                                                                         if (this$totalAmount == null
                                                                                                            ? other$totalAmount == null
                                                                                                            : this$totalAmount.equals(other$totalAmount)) {
                                                                                                            Object this$netWeight = this.getNetWeight();
                                                                                                            Object other$netWeight = other.getNetWeight();
                                                                                                            if (this$netWeight == null
                                                                                                               ? other$netWeight == null
                                                                                                               : this$netWeight.equals(other$netWeight)) {
                                                                                                               Object this$totalNetWeight = this.getTotalNetWeight();
                                                                                                               Object other$totalNetWeight = other.getTotalNetWeight();
                                                                                                               if (this$totalNetWeight == null
                                                                                                                  ? other$totalNetWeight == null
                                                                                                                  : this$totalNetWeight.equals(
                                                                                                                     other$totalNetWeight
                                                                                                                  )) {
                                                                                                                  Object this$grossWeight = this.getGrossWeight();
                                                                                                                  Object other$grossWeight = other.getGrossWeight();
                                                                                                                  if (this$grossWeight == null
                                                                                                                     ? other$grossWeight == null
                                                                                                                     : this$grossWeight.equals(
                                                                                                                        other$grossWeight
                                                                                                                     )) {
                                                                                                                     Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                                                                                     Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                                                                                     if (this$totalGrossWeight == null
                                                                                                                        ? other$totalGrossWeight == null
                                                                                                                        : this$totalGrossWeight.equals(
                                                                                                                           other$totalGrossWeight
                                                                                                                        )) {
                                                                                                                        Object this$storageDuration = this.getStorageDuration();
                                                                                                                        Object other$storageDuration = other.getStorageDuration();
                                                                                                                        if (this$storageDuration == null
                                                                                                                           ? other$storageDuration == null
                                                                                                                           : this$storageDuration.equals(
                                                                                                                              other$storageDuration
                                                                                                                           )) {
                                                                                                                           Object this$warehouse = this.getWarehouse();
                                                                                                                           Object other$warehouse = other.getWarehouse();
                                                                                                                           if (this$warehouse == null
                                                                                                                              ? other$warehouse == null
                                                                                                                              : this$warehouse.equals(
                                                                                                                                 other$warehouse
                                                                                                                              )) {
                                                                                                                              Object this$productReason = this.getProductReason();
                                                                                                                              Object other$productReason = other.getProductReason();
                                                                                                                              if (this$productReason == null
                                                                                                                                 ? other$productReason == null
                                                                                                                                 : this$productReason.equals(
                                                                                                                                    other$productReason
                                                                                                                                 )) {
                                                                                                                                 Object this$thickness = this.getThickness();
                                                                                                                                 Object other$thickness = other.getThickness();
                                                                                                                                 if (this$thickness == null
                                                                                                                                    ? other$thickness == null
                                                                                                                                    : this$thickness.equals(
                                                                                                                                       other$thickness
                                                                                                                                    )) {
                                                                                                                                    Object this$color = this.getColor();
                                                                                                                                    Object other$color = other.getColor();
                                                                                                                                    if (this$color == null
                                                                                                                                       ? other$color == null
                                                                                                                                       : this$color.equals(
                                                                                                                                          other$color
                                                                                                                                       )) {
                                                                                                                                       Object this$createTime = this.getCreateTime();
                                                                                                                                       Object other$createTime = other.getCreateTime();
                                                                                                                                       return this$createTime
                                                                                                                                             == null
                                                                                                                                          ? other$createTime
                                                                                                                                             == null
                                                                                                                                          : this$createTime.equals(
                                                                                                                                             other$createTime
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
      return other instanceof ProjectReturnProductChildDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $mainId = this.getMainId();
      result = result * 59 + ($mainId == null ? 43 : $mainId.hashCode());
      Object $mesBuildingWarehouseRecordId = this.getMesBuildingWarehouseRecordId();
      result = result * 59 + ($mesBuildingWarehouseRecordId == null ? 43 : $mesBuildingWarehouseRecordId.hashCode());
      Object $mesBuildingReturnWarehouseRecordId = this.getMesBuildingReturnWarehouseRecordId();
      result = result * 59 + ($mesBuildingReturnWarehouseRecordId == null ? 43 : $mesBuildingReturnWarehouseRecordId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $planName = this.getPlanName();
      result = result * 59 + ($planName == null ? 43 : $planName.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $singleMete = this.getSingleMete();
      result = result * 59 + ($singleMete == null ? 43 : $singleMete.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $storageDuration = this.getStorageDuration();
      result = result * 59 + ($storageDuration == null ? 43 : $storageDuration.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $productReason = this.getProductReason();
      result = result * 59 + ($productReason == null ? 43 : $productReason.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReturnProductChildDO(id="
         + this.getId()
         + ", mainId="
         + this.getMainId()
         + ", mesBuildingWarehouseRecordId="
         + this.getMesBuildingWarehouseRecordId()
         + ", mesBuildingReturnWarehouseRecordId="
         + this.getMesBuildingReturnWarehouseRecordId()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", planId="
         + this.getPlanId()
         + ", planName="
         + this.getPlanName()
         + ", productId="
         + this.getProductId()
         + ", productName="
         + this.getProductName()
         + ", productType="
         + this.getProductType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", singleMete="
         + this.getSingleMete()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", pricingManner="
         + this.getPricingManner()
         + ", length="
         + this.getLength()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", totalLength="
         + this.getTotalLength()
         + ", plate="
         + this.getPlate()
         + ", totalArea="
         + this.getTotalArea()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", storageDuration="
         + this.getStorageDuration()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", warehouse="
         + this.getWarehouse()
         + ", productReason="
         + this.getProductReason()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", thickness="
         + this.getThickness()
         + ", color="
         + this.getColor()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public static class ProjectReturnProductChildDOBuilder {
      private Long id;
      private Long mainId;
      private Long mesBuildingWarehouseRecordId;
      private Long mesBuildingReturnWarehouseRecordId;
      private Long projectId;
      private String projectName;
      private Long monomerId;
      private String monomerName;
      private Long areaId;
      private String areaName;
      private Long planId;
      private String planName;
      private Long productId;
      private String productName;
      private Integer productType;
      private String serialNumber;
      private String specification;
      private String material;
      private String measureUnit;
      private String accountingUnit;
      private BigDecimal quantity;
      private BigDecimal mete;
      private BigDecimal singleMete;
      private BigDecimal unitPrice;
      private Integer pricingManner;
      private BigDecimal length;
      private BigDecimal surfaceArea;
      private BigDecimal totalLength;
      private String plate;
      private BigDecimal totalArea;
      private BigDecimal totalAmount;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private String storageDuration;
      private Long warehouseId;
      private NameInfo warehouse;
      private String productReason;
      private Long factoryId;
      private Long workshopId;
      private BigDecimal thickness;
      private String color;
      private LocalDateTime createTime;

      ProjectReturnProductChildDOBuilder() {
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder mainId(final Long mainId) {
         this.mainId = mainId;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder mesBuildingWarehouseRecordId(final Long mesBuildingWarehouseRecordId) {
         this.mesBuildingWarehouseRecordId = mesBuildingWarehouseRecordId;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder mesBuildingReturnWarehouseRecordId(final Long mesBuildingReturnWarehouseRecordId) {
         this.mesBuildingReturnWarehouseRecordId = mesBuildingReturnWarehouseRecordId;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder planName(final String planName) {
         this.planName = planName;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder productName(final String productName) {
         this.productName = productName;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder singleMete(final BigDecimal singleMete) {
         this.singleMete = singleMete;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder pricingManner(final Integer pricingManner) {
         this.pricingManner = pricingManner;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder totalAmount(final BigDecimal totalAmount) {
         this.totalAmount = totalAmount;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder storageDuration(final String storageDuration) {
         this.storageDuration = storageDuration;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder warehouse(final NameInfo warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder productReason(final String productReason) {
         this.productReason = productReason;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ProjectReturnProductChildDO build() {
         return new ProjectReturnProductChildDO(
            this.id,
            this.mainId,
            this.mesBuildingWarehouseRecordId,
            this.mesBuildingReturnWarehouseRecordId,
            this.projectId,
            this.projectName,
            this.monomerId,
            this.monomerName,
            this.areaId,
            this.areaName,
            this.planId,
            this.planName,
            this.productId,
            this.productName,
            this.productType,
            this.serialNumber,
            this.specification,
            this.material,
            this.measureUnit,
            this.accountingUnit,
            this.quantity,
            this.mete,
            this.singleMete,
            this.unitPrice,
            this.pricingManner,
            this.length,
            this.surfaceArea,
            this.totalLength,
            this.plate,
            this.totalArea,
            this.totalAmount,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.storageDuration,
            this.warehouseId,
            this.warehouse,
            this.productReason,
            this.factoryId,
            this.workshopId,
            this.thickness,
            this.color,
            this.createTime
         );
      }

      @Override
      public String toString() {
         return "ProjectReturnProductChildDO.ProjectReturnProductChildDOBuilder(id="
            + this.id
            + ", mainId="
            + this.mainId
            + ", mesBuildingWarehouseRecordId="
            + this.mesBuildingWarehouseRecordId
            + ", mesBuildingReturnWarehouseRecordId="
            + this.mesBuildingReturnWarehouseRecordId
            + ", projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", areaId="
            + this.areaId
            + ", areaName="
            + this.areaName
            + ", planId="
            + this.planId
            + ", planName="
            + this.planName
            + ", productId="
            + this.productId
            + ", productName="
            + this.productName
            + ", productType="
            + this.productType
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", singleMete="
            + this.singleMete
            + ", unitPrice="
            + this.unitPrice
            + ", pricingManner="
            + this.pricingManner
            + ", length="
            + this.length
            + ", surfaceArea="
            + this.surfaceArea
            + ", totalLength="
            + this.totalLength
            + ", plate="
            + this.plate
            + ", totalArea="
            + this.totalArea
            + ", totalAmount="
            + this.totalAmount
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", grossWeight="
            + this.grossWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", storageDuration="
            + this.storageDuration
            + ", warehouseId="
            + this.warehouseId
            + ", warehouse="
            + this.warehouse
            + ", productReason="
            + this.productReason
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", thickness="
            + this.thickness
            + ", color="
            + this.color
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
