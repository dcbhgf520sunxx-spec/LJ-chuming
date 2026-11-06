package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "InboundDetailManufactured对象", description = "制成品入库明细表")
@Entity
@TableName("wms_inbound_detail_manufactured")
@Table(name = "wms_inbound_detail_manufactured")
public class InboundDetailManufactured extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "inboundManufacturedId", value = "制成品入库单ID", notes = "制成品入库单ID")
   @JsonProperty("inboundManufacturedId")
   @JSONField(name = "inboundManufacturedId")
   @TableField("inbound_manufactured_id")
   @Column(name = "inbound_manufactured_id", columnDefinition = "bigint  COMMENT '制成品入库单ID'", nullable = true)
   private Long inboundManufacturedId;
   @ApiModelProperty(name = "purchaseId", value = "采购订单ID", notes = "采购订单ID")
   @JsonProperty("purchaseId")
   @JSONField(name = "purchaseId")
   @TableField("purchase_id")
   @Column(name = "purchase_id", columnDefinition = "bigint  COMMENT '采购订单ID'", nullable = true)
   private Long purchaseId;
   @ApiModelProperty(name = "purchaseOrderDetailId", value = "采购详情ID", notes = "采购详情ID")
   @JsonProperty("purchaseOrderDetailId")
   @JSONField(name = "purchaseOrderDetailId")
   @TableField("purchase_order_detail_id")
   @Column(name = "purchase_order_detail_id", columnDefinition = "bigint  COMMENT '采购详情ID'", nullable = true)
   private Long purchaseOrderDetailId;
   @ApiModelProperty(name = "applyPurchaseId", value = "申购订单ID", notes = "申购订单ID")
   @JsonProperty("applyPurchaseId")
   @JSONField(name = "applyPurchaseId")
   @TableField("apply_purchase_id")
   @Column(name = "apply_purchase_id", columnDefinition = "bigint  COMMENT '申购订单ID'", nullable = true)
   private Long applyPurchaseId;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型", notes = "物料基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint  COMMENT '单体ID'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint  COMMENT '区域ID'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "artifactEnclosureId", value = "构件/围护ID", notes = "构件/围护ID")
   @JsonProperty("artifactEnclosureId")
   @JSONField(name = "artifactEnclosureId")
   @TableField("artifact_enclosure_id")
   @Column(name = "artifact_enclosure_id", columnDefinition = "bigint  COMMENT '构件/围护ID'", nullable = true)
   private Long artifactEnclosureId;
   @ApiModelProperty(name = "manufacturedName", value = "制成品名称", notes = "制成品名称")
   @JsonProperty("manufacturedName")
   @JSONField(name = "manufacturedName")
   @TableField("manufactured_name")
   @Column(name = "manufactured_name", columnDefinition = "varchar(255)  COMMENT '制成品名称'", nullable = true)
   private String manufacturedName;
   @ApiModelProperty(name = "manufacturedSn", value = "制成品编号", notes = "制成品编号")
   @JsonProperty("manufacturedSn")
   @JSONField(name = "manufacturedSn")
   @TableField("manufactured_sn")
   @Column(name = "manufactured_sn", columnDefinition = "varchar(255)  COMMENT '制成品编号'", nullable = true)
   private String manufacturedSn;
   @ApiModelProperty(name = "material", value = "制成品材质", notes = "制成品材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255)  COMMENT '制成品材质'", nullable = true)
   private String material;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(128)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）", notes = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,0)  COMMENT '长度(mm)'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "有效宽度（mm）", notes = "有效宽度（mm）")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,0)  COMMENT '有效宽度(mm)'", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚度（mm）", notes = "厚度（mm）")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,3)  COMMENT '厚度（mm）'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(128)  COMMENT '品牌'", nullable = true)
   private String brand;
   @ApiModelProperty(name = "color", value = "颜色", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @TableField("color")
   @Column(name = "color", columnDefinition = "varchar(128)  COMMENT '颜色'", nullable = true)
   private String color;
   @ApiModelProperty(name = "weight", value = "单重（g）", notes = "单重（g）")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   @TableField("weight")
   @Column(name = "weight", columnDefinition = "decimal(32,8)  COMMENT '单重（g）'", nullable = true)
   private BigDecimal weight;
   @ApiModelProperty(name = "totalWeight", value = "总重（g）", notes = "总重（g）")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   @TableField("total_weight")
   @Column(name = "total_weight", columnDefinition = "decimal(32,8)  COMMENT '总重（g）'", nullable = true)
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "totalLength", value = "总长（mm）", notes = "总长（mm）")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   @TableField("total_length")
   @Column(name = "total_length", columnDefinition = "decimal(32,8)  COMMENT '总长（mm）'", nullable = true)
   private BigDecimal totalLength;
   @ApiModelProperty(name = "surfaceArea", value = "单面积（mm²）", notes = "单面积（mm²）")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   @TableField("surface_area")
   @Column(name = "surface_area", columnDefinition = "decimal(32,8)  COMMENT '单面积（mm²）'", nullable = true)
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "totalArea", value = "总面积（mm²）", notes = "总面积（mm²）")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   @TableField("total_area")
   @Column(name = "total_area", columnDefinition = "decimal(32,8)  COMMENT '总面积（mm²）'", nullable = true)
   private BigDecimal totalArea;
   @ApiModelProperty(name = "wageQuotaType", value = "制成品计价方式 WmsWageQuotaTypeEnum", notes = "制成品计价方式 计价方式 WmsWageQuotaTypeEnum")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   @TableField("wage_quota_type")
   @Column(name = "wage_quota_type", columnDefinition = "int(11)  COMMENT '制成品计价方式 计价方式 WmsWageQuotaTypeEnum'", nullable = true)
   private Integer wageQuotaType;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '数量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "manufacturedUnit", value = "制成品单位", notes = "制成品单位")
   @JsonProperty("manufacturedUnit")
   @JSONField(name = "manufacturedUnit")
   @TableField("manufactured_unit")
   @Column(name = "manufactured_unit", columnDefinition = "varchar(255)  COMMENT '制成品单位'", nullable = true)
   private String manufacturedUnit;
   @ApiModelProperty(name = "workshopId", value = "仓库ID", notes = "仓库ID")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '仓库ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "warehouseId", value = "仓库位置ID", notes = "仓库位置ID")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '仓库位置ID'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税总价", notes = "不含税总价")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_vat")
   @Column(name = "amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '不含税总价'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "unitPriceExcludingVat", value = "不含税单价", notes = "不含税单价")
   @JsonProperty("unitPriceExcludingVat")
   @JSONField(name = "unitPriceExcludingVat")
   @TableField("unit_price_excluding_vat")
   @Column(name = "unit_price_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '不含税单价'", nullable = true)
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty(name = "inputVat", value = "进项税", notes = "进项税")
   @JsonProperty("inputVat")
   @JSONField(name = "inputVat")
   @TableField("input_vat")
   @Column(name = "input_vat", columnDefinition = "decimal(32,12)  COMMENT '进项税'", nullable = true)
   private BigDecimal inputVat;
   @ApiModelProperty(name = "unitPrice", value = "含税单价", notes = "含税单价")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,12)  COMMENT '含税单价'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "amount", value = "入库总价 含税", notes = "入库总价 含税")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '入库总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "materialInventoryManufacturedId", value = "制成品库存ID", notes = "制成品库存ID")
   @JsonProperty("materialInventoryManufacturedId")
   @JSONField(name = "materialInventoryManufacturedId")
   @TableField("material_inventory_manufactured_id")
   @Column(name = "material_inventory_manufactured_id", columnDefinition = "bigint  COMMENT '制成品库存ID'", nullable = true)
   private Long materialInventoryManufacturedId;
   @ApiModelProperty(name = "taxRate", value = "税率(百分比)", notes = "税率(百分比)")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(32,8)  COMMENT '税率(百分比)'", nullable = true)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;

   public static InboundDetailManufactured.InboundDetailManufacturedBuilder builder() {
      return new InboundDetailManufactured.InboundDetailManufacturedBuilder();
   }

   public InboundDetailManufactured() {
   }

   public InboundDetailManufactured(
      final Long id,
      final Long inboundManufacturedId,
      final Long purchaseId,
      final Long purchaseOrderDetailId,
      final Long applyPurchaseId,
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
      final BigDecimal totalWeight,
      final BigDecimal totalLength,
      final BigDecimal surfaceArea,
      final BigDecimal totalArea,
      final Integer wageQuotaType,
      final BigDecimal quantity,
      final String manufacturedUnit,
      final Long workshopId,
      final Long warehouseId,
      final BigDecimal amountExcludingVat,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal inputVat,
      final BigDecimal unitPrice,
      final BigDecimal amount,
      final Long materialInventoryManufacturedId,
      final BigDecimal taxRate,
      final String remark
   ) {
      this.id = id;
      this.inboundManufacturedId = inboundManufacturedId;
      this.purchaseId = purchaseId;
      this.purchaseOrderDetailId = purchaseOrderDetailId;
      this.applyPurchaseId = applyPurchaseId;
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
      this.totalWeight = totalWeight;
      this.totalLength = totalLength;
      this.surfaceArea = surfaceArea;
      this.totalArea = totalArea;
      this.wageQuotaType = wageQuotaType;
      this.quantity = quantity;
      this.manufacturedUnit = manufacturedUnit;
      this.workshopId = workshopId;
      this.warehouseId = warehouseId;
      this.amountExcludingVat = amountExcludingVat;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.inputVat = inputVat;
      this.unitPrice = unitPrice;
      this.amount = amount;
      this.materialInventoryManufacturedId = materialInventoryManufacturedId;
      this.taxRate = taxRate;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getInboundManufacturedId() {
      return this.inboundManufacturedId;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public Long getPurchaseOrderDetailId() {
      return this.purchaseOrderDetailId;
   }

   public Long getApplyPurchaseId() {
      return this.applyPurchaseId;
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

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getManufacturedUnit() {
      return this.manufacturedUnit;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Long getMaterialInventoryManufacturedId() {
      return this.materialInventoryManufacturedId;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public InboundDetailManufactured setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("inboundManufacturedId")
   public InboundDetailManufactured setInboundManufacturedId(final Long inboundManufacturedId) {
      this.inboundManufacturedId = inboundManufacturedId;
      return this;
   }

   @JsonProperty("purchaseId")
   public InboundDetailManufactured setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
      return this;
   }

   @JsonProperty("purchaseOrderDetailId")
   public InboundDetailManufactured setPurchaseOrderDetailId(final Long purchaseOrderDetailId) {
      this.purchaseOrderDetailId = purchaseOrderDetailId;
      return this;
   }

   @JsonProperty("applyPurchaseId")
   public InboundDetailManufactured setApplyPurchaseId(final Long applyPurchaseId) {
      this.applyPurchaseId = applyPurchaseId;
      return this;
   }

   @JsonProperty("basicClass")
   public InboundDetailManufactured setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("monomerId")
   public InboundDetailManufactured setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public InboundDetailManufactured setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("projectId")
   public InboundDetailManufactured setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("artifactEnclosureId")
   public InboundDetailManufactured setArtifactEnclosureId(final Long artifactEnclosureId) {
      this.artifactEnclosureId = artifactEnclosureId;
      return this;
   }

   @JsonProperty("manufacturedName")
   public InboundDetailManufactured setManufacturedName(final String manufacturedName) {
      this.manufacturedName = manufacturedName;
      return this;
   }

   @JsonProperty("manufacturedSn")
   public InboundDetailManufactured setManufacturedSn(final String manufacturedSn) {
      this.manufacturedSn = manufacturedSn;
      return this;
   }

   @JsonProperty("material")
   public InboundDetailManufactured setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("specification")
   public InboundDetailManufactured setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public InboundDetailManufactured setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public InboundDetailManufactured setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public InboundDetailManufactured setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("brand")
   public InboundDetailManufactured setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("color")
   public InboundDetailManufactured setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("weight")
   public InboundDetailManufactured setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("totalWeight")
   public InboundDetailManufactured setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   @JsonProperty("totalLength")
   public InboundDetailManufactured setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("surfaceArea")
   public InboundDetailManufactured setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("totalArea")
   public InboundDetailManufactured setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public InboundDetailManufactured setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("quantity")
   public InboundDetailManufactured setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("manufacturedUnit")
   public InboundDetailManufactured setManufacturedUnit(final String manufacturedUnit) {
      this.manufacturedUnit = manufacturedUnit;
      return this;
   }

   @JsonProperty("workshopId")
   public InboundDetailManufactured setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("warehouseId")
   public InboundDetailManufactured setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public InboundDetailManufactured setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("unitPriceExcludingVat")
   public InboundDetailManufactured setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   @JsonProperty("inputVat")
   public InboundDetailManufactured setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   @JsonProperty("unitPrice")
   public InboundDetailManufactured setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("amount")
   public InboundDetailManufactured setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("materialInventoryManufacturedId")
   public InboundDetailManufactured setMaterialInventoryManufacturedId(final Long materialInventoryManufacturedId) {
      this.materialInventoryManufacturedId = materialInventoryManufacturedId;
      return this;
   }

   @JsonProperty("taxRate")
   public InboundDetailManufactured setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("remark")
   public InboundDetailManufactured setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "InboundDetailManufactured(id="
         + this.getId()
         + ", inboundManufacturedId="
         + this.getInboundManufacturedId()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", purchaseOrderDetailId="
         + this.getPurchaseOrderDetailId()
         + ", applyPurchaseId="
         + this.getApplyPurchaseId()
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
         + ", totalWeight="
         + this.getTotalWeight()
         + ", totalLength="
         + this.getTotalLength()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", totalArea="
         + this.getTotalArea()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", quantity="
         + this.getQuantity()
         + ", manufacturedUnit="
         + this.getManufacturedUnit()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", amount="
         + this.getAmount()
         + ", materialInventoryManufacturedId="
         + this.getMaterialInventoryManufacturedId()
         + ", taxRate="
         + this.getTaxRate()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InboundDetailManufactured)) {
         return false;
      }

      InboundDetailManufactured other = (InboundDetailManufactured)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$inboundManufacturedId = this.getInboundManufacturedId();
         Object other$inboundManufacturedId = other.getInboundManufacturedId();
         if (this$inboundManufacturedId == null ? other$inboundManufacturedId == null : this$inboundManufacturedId.equals(other$inboundManufacturedId)) {
            Object this$purchaseId = this.getPurchaseId();
            Object other$purchaseId = other.getPurchaseId();
            if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
               Object this$purchaseOrderDetailId = this.getPurchaseOrderDetailId();
               Object other$purchaseOrderDetailId = other.getPurchaseOrderDetailId();
               if (this$purchaseOrderDetailId == null ? other$purchaseOrderDetailId == null : this$purchaseOrderDetailId.equals(other$purchaseOrderDetailId)) {
                  Object this$applyPurchaseId = this.getApplyPurchaseId();
                  Object other$applyPurchaseId = other.getApplyPurchaseId();
                  if (this$applyPurchaseId == null ? other$applyPurchaseId == null : this$applyPurchaseId.equals(other$applyPurchaseId)) {
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
                                 if (this$artifactEnclosureId == null
                                    ? other$artifactEnclosureId == null
                                    : this$artifactEnclosureId.equals(other$artifactEnclosureId)) {
                                    Object this$wageQuotaType = this.getWageQuotaType();
                                    Object other$wageQuotaType = other.getWageQuotaType();
                                    if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                                       Object this$workshopId = this.getWorkshopId();
                                       Object other$workshopId = other.getWorkshopId();
                                       if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                          Object this$warehouseId = this.getWarehouseId();
                                          Object other$warehouseId = other.getWarehouseId();
                                          if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                             Object this$materialInventoryManufacturedId = this.getMaterialInventoryManufacturedId();
                                             Object other$materialInventoryManufacturedId = other.getMaterialInventoryManufacturedId();
                                             if (this$materialInventoryManufacturedId == null
                                                ? other$materialInventoryManufacturedId == null
                                                : this$materialInventoryManufacturedId.equals(other$materialInventoryManufacturedId)) {
                                                Object this$manufacturedName = this.getManufacturedName();
                                                Object other$manufacturedName = other.getManufacturedName();
                                                if (this$manufacturedName == null
                                                   ? other$manufacturedName == null
                                                   : this$manufacturedName.equals(other$manufacturedName)) {
                                                   Object this$manufacturedSn = this.getManufacturedSn();
                                                   Object other$manufacturedSn = other.getManufacturedSn();
                                                   if (this$manufacturedSn == null
                                                      ? other$manufacturedSn == null
                                                      : this$manufacturedSn.equals(other$manufacturedSn)) {
                                                      Object this$material = this.getMaterial();
                                                      Object other$material = other.getMaterial();
                                                      if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                         Object this$specification = this.getSpecification();
                                                         Object other$specification = other.getSpecification();
                                                         if (this$specification == null
                                                            ? other$specification == null
                                                            : this$specification.equals(other$specification)) {
                                                            Object this$length = this.getLength();
                                                            Object other$length = other.getLength();
                                                            if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                               Object this$width = this.getWidth();
                                                               Object other$width = other.getWidth();
                                                               if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                                  Object this$thickness = this.getThickness();
                                                                  Object other$thickness = other.getThickness();
                                                                  if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)
                                                                     )
                                                                   {
                                                                     Object this$brand = this.getBrand();
                                                                     Object other$brand = other.getBrand();
                                                                     if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                        Object this$color = this.getColor();
                                                                        Object other$color = other.getColor();
                                                                        if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                           Object this$weight = this.getWeight();
                                                                           Object other$weight = other.getWeight();
                                                                           if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                                              Object this$totalWeight = this.getTotalWeight();
                                                                              Object other$totalWeight = other.getTotalWeight();
                                                                              if (this$totalWeight == null
                                                                                 ? other$totalWeight == null
                                                                                 : this$totalWeight.equals(other$totalWeight)) {
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
                                                                                             Object this$manufacturedUnit = this.getManufacturedUnit();
                                                                                             Object other$manufacturedUnit = other.getManufacturedUnit();
                                                                                             if (this$manufacturedUnit == null
                                                                                                ? other$manufacturedUnit == null
                                                                                                : this$manufacturedUnit.equals(other$manufacturedUnit)) {
                                                                                                Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                                                Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                                                if (this$amountExcludingVat == null
                                                                                                   ? other$amountExcludingVat == null
                                                                                                   : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                                                                                   Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                                                                                   Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                                                                                   if (this$unitPriceExcludingVat == null
                                                                                                      ? other$unitPriceExcludingVat == null
                                                                                                      : this$unitPriceExcludingVat.equals(
                                                                                                         other$unitPriceExcludingVat
                                                                                                      )) {
                                                                                                      Object this$inputVat = this.getInputVat();
                                                                                                      Object other$inputVat = other.getInputVat();
                                                                                                      if (this$inputVat == null
                                                                                                         ? other$inputVat == null
                                                                                                         : this$inputVat.equals(other$inputVat)) {
                                                                                                         Object this$unitPrice = this.getUnitPrice();
                                                                                                         Object other$unitPrice = other.getUnitPrice();
                                                                                                         if (this$unitPrice == null
                                                                                                            ? other$unitPrice == null
                                                                                                            : this$unitPrice.equals(other$unitPrice)) {
                                                                                                            Object this$amount = this.getAmount();
                                                                                                            Object other$amount = other.getAmount();
                                                                                                            if (this$amount == null
                                                                                                               ? other$amount == null
                                                                                                               : this$amount.equals(other$amount)) {
                                                                                                               Object this$taxRate = this.getTaxRate();
                                                                                                               Object other$taxRate = other.getTaxRate();
                                                                                                               if (this$taxRate == null
                                                                                                                  ? other$taxRate == null
                                                                                                                  : this$taxRate.equals(other$taxRate)) {
                                                                                                                  Object this$remark = this.getRemark();
                                                                                                                  Object other$remark = other.getRemark();
                                                                                                                  return this$remark == null
                                                                                                                     ? other$remark == null
                                                                                                                     : this$remark.equals(other$remark);
                                                                                                               } else {
                                                                                                                  return false;
                                                                                                               }
                                                                                                            } else {
                                                                                                               return false;
                                                                                                            }
                                                                                                         } else {
                                                                                                            return false;
                                                                                                         }
                                                                                                      } else {
                                                                                                         return false;
                                                                                                      }
                                                                                                   } else {
                                                                                                      return false;
                                                                                                   }
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof InboundDetailManufactured;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inboundManufacturedId = this.getInboundManufacturedId();
      result = result * 59 + ($inboundManufacturedId == null ? 43 : $inboundManufacturedId.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $purchaseOrderDetailId = this.getPurchaseOrderDetailId();
      result = result * 59 + ($purchaseOrderDetailId == null ? 43 : $purchaseOrderDetailId.hashCode());
      Object $applyPurchaseId = this.getApplyPurchaseId();
      result = result * 59 + ($applyPurchaseId == null ? 43 : $applyPurchaseId.hashCode());
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
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $materialInventoryManufacturedId = this.getMaterialInventoryManufacturedId();
      result = result * 59 + ($materialInventoryManufacturedId == null ? 43 : $materialInventoryManufacturedId.hashCode());
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
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $manufacturedUnit = this.getManufacturedUnit();
      result = result * 59 + ($manufacturedUnit == null ? 43 : $manufacturedUnit.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class InboundDetailManufacturedBuilder {
      private Long id;
      private Long inboundManufacturedId;
      private Long purchaseId;
      private Long purchaseOrderDetailId;
      private Long applyPurchaseId;
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
      private BigDecimal totalWeight;
      private BigDecimal totalLength;
      private BigDecimal surfaceArea;
      private BigDecimal totalArea;
      private Integer wageQuotaType;
      private BigDecimal quantity;
      private String manufacturedUnit;
      private Long workshopId;
      private Long warehouseId;
      private BigDecimal amountExcludingVat;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal inputVat;
      private BigDecimal unitPrice;
      private BigDecimal amount;
      private Long materialInventoryManufacturedId;
      private BigDecimal taxRate;
      private String remark;

      InboundDetailManufacturedBuilder() {
      }

      @JsonProperty("id")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("inboundManufacturedId")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder inboundManufacturedId(final Long inboundManufacturedId) {
         this.inboundManufacturedId = inboundManufacturedId;
         return this;
      }

      @JsonProperty("purchaseId")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      @JsonProperty("purchaseOrderDetailId")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder purchaseOrderDetailId(final Long purchaseOrderDetailId) {
         this.purchaseOrderDetailId = purchaseOrderDetailId;
         return this;
      }

      @JsonProperty("applyPurchaseId")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder applyPurchaseId(final Long applyPurchaseId) {
         this.applyPurchaseId = applyPurchaseId;
         return this;
      }

      @JsonProperty("basicClass")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("monomerId")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("projectId")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("artifactEnclosureId")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder artifactEnclosureId(final Long artifactEnclosureId) {
         this.artifactEnclosureId = artifactEnclosureId;
         return this;
      }

      @JsonProperty("manufacturedName")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder manufacturedName(final String manufacturedName) {
         this.manufacturedName = manufacturedName;
         return this;
      }

      @JsonProperty("manufacturedSn")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder manufacturedSn(final String manufacturedSn) {
         this.manufacturedSn = manufacturedSn;
         return this;
      }

      @JsonProperty("material")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("specification")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("brand")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("color")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("weight")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("totalWeight")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      @JsonProperty("totalLength")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("surfaceArea")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("totalArea")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("quantity")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("manufacturedUnit")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder manufacturedUnit(final String manufacturedUnit) {
         this.manufacturedUnit = manufacturedUnit;
         return this;
      }

      @JsonProperty("workshopId")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("warehouseId")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("unitPriceExcludingVat")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      @JsonProperty("inputVat")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      @JsonProperty("unitPrice")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("amount")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("materialInventoryManufacturedId")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder materialInventoryManufacturedId(final Long materialInventoryManufacturedId) {
         this.materialInventoryManufacturedId = materialInventoryManufacturedId;
         return this;
      }

      @JsonProperty("taxRate")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("remark")
      public InboundDetailManufactured.InboundDetailManufacturedBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public InboundDetailManufactured build() {
         return new InboundDetailManufactured(
            this.id,
            this.inboundManufacturedId,
            this.purchaseId,
            this.purchaseOrderDetailId,
            this.applyPurchaseId,
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
            this.totalWeight,
            this.totalLength,
            this.surfaceArea,
            this.totalArea,
            this.wageQuotaType,
            this.quantity,
            this.manufacturedUnit,
            this.workshopId,
            this.warehouseId,
            this.amountExcludingVat,
            this.unitPriceExcludingVat,
            this.inputVat,
            this.unitPrice,
            this.amount,
            this.materialInventoryManufacturedId,
            this.taxRate,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "InboundDetailManufactured.InboundDetailManufacturedBuilder(id="
            + this.id
            + ", inboundManufacturedId="
            + this.inboundManufacturedId
            + ", purchaseId="
            + this.purchaseId
            + ", purchaseOrderDetailId="
            + this.purchaseOrderDetailId
            + ", applyPurchaseId="
            + this.applyPurchaseId
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
            + ", totalWeight="
            + this.totalWeight
            + ", totalLength="
            + this.totalLength
            + ", surfaceArea="
            + this.surfaceArea
            + ", totalArea="
            + this.totalArea
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", quantity="
            + this.quantity
            + ", manufacturedUnit="
            + this.manufacturedUnit
            + ", workshopId="
            + this.workshopId
            + ", warehouseId="
            + this.warehouseId
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", inputVat="
            + this.inputVat
            + ", unitPrice="
            + this.unitPrice
            + ", amount="
            + this.amount
            + ", materialInventoryManufacturedId="
            + this.materialInventoryManufacturedId
            + ", taxRate="
            + this.taxRate
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
