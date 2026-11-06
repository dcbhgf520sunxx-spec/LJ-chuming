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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ReturnDetailManufactured对象", description = "制成品退库详情表 ")
@Entity
@TableName("wms_return_detail_manufactured")
@Table(name = "wms_return_detail_manufactured")
public class ReturnDetailManufactured extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "returnManufacturedId", value = "制成品退库单ID", notes = "制成品退库单ID")
   @JsonProperty("returnManufacturedId")
   @JSONField(name = "returnManufacturedId")
   @TableField("return_manufactured_id")
   @Column(name = "return_manufactured_id", columnDefinition = "bigint  COMMENT '制成品退库单ID'", nullable = true)
   private Long returnManufacturedId;
   @ApiModelProperty(name = "materialInventoryManufacturedId", value = "制成品物料池ID", notes = "制成品物料池ID")
   @JsonProperty("materialInventoryManufacturedId")
   @JSONField(name = "materialInventoryManufacturedId")
   @TableField("material_Inventory_manufactured_id")
   @Column(name = "material_Inventory_manufactured_id", columnDefinition = "bigint  COMMENT '制成品物料池ID'", nullable = true)
   private Long materialInventoryManufacturedId;
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
   @ApiModelProperty(name = "amount", value = "退库总价 含税", notes = "退库总价 含税")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '退库总价 含税'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "returneeId", value = "退库人ID", notes = "退库人ID")
   @JsonProperty("returneeId")
   @JSONField(name = "returneeId")
   @TableField("returnee_id")
   @Column(name = "returnee_id", columnDefinition = "bigint  COMMENT '退库人ID'", nullable = true)
   private Long returneeId;
   @ApiModelProperty(name = "returneeName", value = "退库人名称", notes = "退库人名称")
   @JsonProperty("returneeName")
   @JSONField(name = "returneeName")
   @TableField("returnee_name")
   @Column(name = "returnee_name", columnDefinition = "varchar(255)  COMMENT '退库人名称'", nullable = true)
   private String returneeName;
   @ApiModelProperty(name = "returnTime", value = "退库时间(可修改,默认添加时设置)", notes = "退库时间(可修改,默认添加时设置)")
   @JsonProperty("returnTime")
   @JSONField(name = "returnTime")
   @TableField("return_time")
   @Column(name = "return_time", columnDefinition = "datetime  COMMENT '退库时间(可修改,默认添加时设置)'", nullable = true)
   private LocalDateTime returnTime;
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

   public static ReturnDetailManufactured.ReturnDetailManufacturedBuilder builder() {
      return new ReturnDetailManufactured.ReturnDetailManufacturedBuilder();
   }

   public ReturnDetailManufactured() {
   }

   public ReturnDetailManufactured(
      final Long id,
      final Long returnManufacturedId,
      final Long materialInventoryManufacturedId,
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
      final BigDecimal amountExcludingVat,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal inputVat,
      final BigDecimal unitPrice,
      final BigDecimal amount,
      final Long returneeId,
      final String returneeName,
      final LocalDateTime returnTime,
      final BigDecimal taxRate,
      final String remark
   ) {
      this.id = id;
      this.returnManufacturedId = returnManufacturedId;
      this.materialInventoryManufacturedId = materialInventoryManufacturedId;
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
      this.amountExcludingVat = amountExcludingVat;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.inputVat = inputVat;
      this.unitPrice = unitPrice;
      this.amount = amount;
      this.returneeId = returneeId;
      this.returneeName = returneeName;
      this.returnTime = returnTime;
      this.taxRate = taxRate;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getReturnManufacturedId() {
      return this.returnManufacturedId;
   }

   public Long getMaterialInventoryManufacturedId() {
      return this.materialInventoryManufacturedId;
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

   public Long getReturneeId() {
      return this.returneeId;
   }

   public String getReturneeName() {
      return this.returneeName;
   }

   public LocalDateTime getReturnTime() {
      return this.returnTime;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public ReturnDetailManufactured setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("returnManufacturedId")
   public ReturnDetailManufactured setReturnManufacturedId(final Long returnManufacturedId) {
      this.returnManufacturedId = returnManufacturedId;
      return this;
   }

   @JsonProperty("materialInventoryManufacturedId")
   public ReturnDetailManufactured setMaterialInventoryManufacturedId(final Long materialInventoryManufacturedId) {
      this.materialInventoryManufacturedId = materialInventoryManufacturedId;
      return this;
   }

   @JsonProperty("basicClass")
   public ReturnDetailManufactured setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("monomerId")
   public ReturnDetailManufactured setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public ReturnDetailManufactured setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("projectId")
   public ReturnDetailManufactured setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("artifactEnclosureId")
   public ReturnDetailManufactured setArtifactEnclosureId(final Long artifactEnclosureId) {
      this.artifactEnclosureId = artifactEnclosureId;
      return this;
   }

   @JsonProperty("manufacturedName")
   public ReturnDetailManufactured setManufacturedName(final String manufacturedName) {
      this.manufacturedName = manufacturedName;
      return this;
   }

   @JsonProperty("manufacturedSn")
   public ReturnDetailManufactured setManufacturedSn(final String manufacturedSn) {
      this.manufacturedSn = manufacturedSn;
      return this;
   }

   @JsonProperty("material")
   public ReturnDetailManufactured setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("specification")
   public ReturnDetailManufactured setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public ReturnDetailManufactured setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public ReturnDetailManufactured setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public ReturnDetailManufactured setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("brand")
   public ReturnDetailManufactured setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("color")
   public ReturnDetailManufactured setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("weight")
   public ReturnDetailManufactured setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("totalWeight")
   public ReturnDetailManufactured setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   @JsonProperty("totalLength")
   public ReturnDetailManufactured setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("surfaceArea")
   public ReturnDetailManufactured setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("totalArea")
   public ReturnDetailManufactured setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public ReturnDetailManufactured setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("quantity")
   public ReturnDetailManufactured setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("manufacturedUnit")
   public ReturnDetailManufactured setManufacturedUnit(final String manufacturedUnit) {
      this.manufacturedUnit = manufacturedUnit;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public ReturnDetailManufactured setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("unitPriceExcludingVat")
   public ReturnDetailManufactured setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   @JsonProperty("inputVat")
   public ReturnDetailManufactured setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   @JsonProperty("unitPrice")
   public ReturnDetailManufactured setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("amount")
   public ReturnDetailManufactured setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("returneeId")
   public ReturnDetailManufactured setReturneeId(final Long returneeId) {
      this.returneeId = returneeId;
      return this;
   }

   @JsonProperty("returneeName")
   public ReturnDetailManufactured setReturneeName(final String returneeName) {
      this.returneeName = returneeName;
      return this;
   }

   @JsonProperty("returnTime")
   public ReturnDetailManufactured setReturnTime(final LocalDateTime returnTime) {
      this.returnTime = returnTime;
      return this;
   }

   @JsonProperty("taxRate")
   public ReturnDetailManufactured setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("remark")
   public ReturnDetailManufactured setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "ReturnDetailManufactured(id="
         + this.getId()
         + ", returnManufacturedId="
         + this.getReturnManufacturedId()
         + ", materialInventoryManufacturedId="
         + this.getMaterialInventoryManufacturedId()
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
         + ", returneeId="
         + this.getReturneeId()
         + ", returneeName="
         + this.getReturneeName()
         + ", returnTime="
         + this.getReturnTime()
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

      if (!(o instanceof ReturnDetailManufactured)) {
         return false;
      }

      ReturnDetailManufactured other = (ReturnDetailManufactured)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$returnManufacturedId = this.getReturnManufacturedId();
         Object other$returnManufacturedId = other.getReturnManufacturedId();
         if (this$returnManufacturedId == null ? other$returnManufacturedId == null : this$returnManufacturedId.equals(other$returnManufacturedId)) {
            Object this$materialInventoryManufacturedId = this.getMaterialInventoryManufacturedId();
            Object other$materialInventoryManufacturedId = other.getMaterialInventoryManufacturedId();
            if (this$materialInventoryManufacturedId == null
               ? other$materialInventoryManufacturedId == null
               : this$materialInventoryManufacturedId.equals(other$materialInventoryManufacturedId)) {
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
                                 Object this$returneeId = this.getReturneeId();
                                 Object other$returneeId = other.getReturneeId();
                                 if (this$returneeId == null ? other$returneeId == null : this$returneeId.equals(other$returneeId)) {
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
                                                                                          : this$unitPriceExcludingVat.equals(other$unitPriceExcludingVat)) {
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
                                                                                                   Object this$returneeName = this.getReturneeName();
                                                                                                   Object other$returneeName = other.getReturneeName();
                                                                                                   if (this$returneeName == null
                                                                                                      ? other$returneeName == null
                                                                                                      : this$returneeName.equals(other$returneeName)) {
                                                                                                      Object this$returnTime = this.getReturnTime();
                                                                                                      Object other$returnTime = other.getReturnTime();
                                                                                                      if (this$returnTime == null
                                                                                                         ? other$returnTime == null
                                                                                                         : this$returnTime.equals(other$returnTime)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ReturnDetailManufactured;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $returnManufacturedId = this.getReturnManufacturedId();
      result = result * 59 + ($returnManufacturedId == null ? 43 : $returnManufacturedId.hashCode());
      Object $materialInventoryManufacturedId = this.getMaterialInventoryManufacturedId();
      result = result * 59 + ($materialInventoryManufacturedId == null ? 43 : $materialInventoryManufacturedId.hashCode());
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
      Object $returneeId = this.getReturneeId();
      result = result * 59 + ($returneeId == null ? 43 : $returneeId.hashCode());
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
      Object $returneeName = this.getReturneeName();
      result = result * 59 + ($returneeName == null ? 43 : $returneeName.hashCode());
      Object $returnTime = this.getReturnTime();
      result = result * 59 + ($returnTime == null ? 43 : $returnTime.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class ReturnDetailManufacturedBuilder {
      private Long id;
      private Long returnManufacturedId;
      private Long materialInventoryManufacturedId;
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
      private BigDecimal amountExcludingVat;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal inputVat;
      private BigDecimal unitPrice;
      private BigDecimal amount;
      private Long returneeId;
      private String returneeName;
      private LocalDateTime returnTime;
      private BigDecimal taxRate;
      private String remark;

      ReturnDetailManufacturedBuilder() {
      }

      @JsonProperty("id")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("returnManufacturedId")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder returnManufacturedId(final Long returnManufacturedId) {
         this.returnManufacturedId = returnManufacturedId;
         return this;
      }

      @JsonProperty("materialInventoryManufacturedId")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder materialInventoryManufacturedId(final Long materialInventoryManufacturedId) {
         this.materialInventoryManufacturedId = materialInventoryManufacturedId;
         return this;
      }

      @JsonProperty("basicClass")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("monomerId")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("projectId")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("artifactEnclosureId")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder artifactEnclosureId(final Long artifactEnclosureId) {
         this.artifactEnclosureId = artifactEnclosureId;
         return this;
      }

      @JsonProperty("manufacturedName")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder manufacturedName(final String manufacturedName) {
         this.manufacturedName = manufacturedName;
         return this;
      }

      @JsonProperty("manufacturedSn")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder manufacturedSn(final String manufacturedSn) {
         this.manufacturedSn = manufacturedSn;
         return this;
      }

      @JsonProperty("material")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("specification")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("brand")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("color")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("weight")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("totalWeight")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      @JsonProperty("totalLength")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("surfaceArea")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("totalArea")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("quantity")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("manufacturedUnit")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder manufacturedUnit(final String manufacturedUnit) {
         this.manufacturedUnit = manufacturedUnit;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("unitPriceExcludingVat")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      @JsonProperty("inputVat")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      @JsonProperty("unitPrice")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("amount")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("returneeId")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder returneeId(final Long returneeId) {
         this.returneeId = returneeId;
         return this;
      }

      @JsonProperty("returneeName")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder returneeName(final String returneeName) {
         this.returneeName = returneeName;
         return this;
      }

      @JsonProperty("returnTime")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder returnTime(final LocalDateTime returnTime) {
         this.returnTime = returnTime;
         return this;
      }

      @JsonProperty("taxRate")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("remark")
      public ReturnDetailManufactured.ReturnDetailManufacturedBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ReturnDetailManufactured build() {
         return new ReturnDetailManufactured(
            this.id,
            this.returnManufacturedId,
            this.materialInventoryManufacturedId,
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
            this.amountExcludingVat,
            this.unitPriceExcludingVat,
            this.inputVat,
            this.unitPrice,
            this.amount,
            this.returneeId,
            this.returneeName,
            this.returnTime,
            this.taxRate,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "ReturnDetailManufactured.ReturnDetailManufacturedBuilder(id="
            + this.id
            + ", returnManufacturedId="
            + this.returnManufacturedId
            + ", materialInventoryManufacturedId="
            + this.materialInventoryManufacturedId
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
            + ", returneeId="
            + this.returneeId
            + ", returneeName="
            + this.returneeName
            + ", returnTime="
            + this.returnTime
            + ", taxRate="
            + this.taxRate
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
