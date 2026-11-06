package com.hzchum.scim.scm.core.api.pojo._do;

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

@ApiModel(value = "ApplyPurchaseDetail对象", description = "申购单详情 ")
@Entity
@TableName("scm_apply_purchase_detail")
@Table(name = "scm_apply_purchase_detail")
public class ApplyPurchaseDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "applyPurchaseId", value = "申购单ID", notes = "申购单ID")
   @JsonProperty("applyPurchaseId")
   @JSONField(name = "applyPurchaseId")
   @TableField("apply_purchase_id")
   @Column(name = "apply_purchase_id", columnDefinition = "bigint(20)  COMMENT '申购单ID'", nullable = true)
   private Long applyPurchaseId;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint(20)  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "materialInventoryId", value = "物料仓ID", notes = "物料仓ID")
   @JsonProperty("materialInventoryId")
   @JSONField(name = "materialInventoryId")
   @TableField("material_inventory_id")
   @Column(name = "material_inventory_id", columnDefinition = "bigint(20)  COMMENT '物料仓ID'", nullable = true)
   private Long materialInventoryId;
   @ApiModelProperty(name = "classifyName", value = "科目名称", notes = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   @TableField("classify_name")
   @Column(name = "classify_name", columnDefinition = "varchar(255)  COMMENT '科目名称'", nullable = true)
   private String classifyName;
   @ApiModelProperty(name = "basicClass", value = "基础类型", notes = "基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int(11)  COMMENT '基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "model", value = "型号（是制成品时为材质）", notes = "型号（是制成品时为材质）")
   @JsonProperty("model")
   @JSONField(name = "model")
   @TableField("model")
   @Column(name = "model", columnDefinition = "varchar(64)  COMMENT '型号（是制成品时为材质）'", nullable = true)
   private String model;
   @ApiModelProperty(name = "length", value = "长度", notes = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,8)  COMMENT '长度'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "宽度", notes = "宽度")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,8)  COMMENT '宽度'", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "measureUnit", value = "计量单位")
   @JsonProperty("measureUnit")
   @JSONField(name = "measureUnit")
   @TableField("measure_unit")
   @Column(name = "measure_unit")
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   @JsonProperty("accountingUnit")
   @JSONField(name = "accountingUnit")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit")
   private String accountingUnit;
   @ApiModelProperty(name = "thickness", value = "厚度", notes = "厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8)  COMMENT '厚度'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(255)  COMMENT '品牌'", nullable = true)
   private String brand;
   @ApiModelProperty(name = "color", value = "颜色", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @TableField("color")
   @Column(name = "color", columnDefinition = "varchar(255)  COMMENT '颜色'", nullable = true)
   private String color;
   @ApiModelProperty(name = "quantity", value = "计量量", notes = "计量量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '计量量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "boolPurchase", value = "是否采购(单条物料只可采购一次)", notes = "是否采购(单条物料只可采购一次)")
   @JsonProperty("boolPurchase")
   @JSONField(name = "boolPurchase")
   @TableField("bool_purchase")
   @Column(name = "bool_purchase", columnDefinition = "tinyint(1) default '0' COMMENT '是否采购(单条物料只可采购一次)'", nullable = true)
   private Boolean boolPurchase;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "arrivalTime", value = "到厂时间", notes = "到厂时间")
   @JsonProperty("arrivalTime")
   @JSONField(name = "arrivalTime")
   @TableField("arrival_time")
   @Column(name = "arrival_time", columnDefinition = "datetime  COMMENT '到厂时间'", nullable = true)
   private LocalDateTime arrivalTime;
   @ApiModelProperty(name = "artifactEnclosureId", value = "构件/围护ID", notes = "构件/围护ID")
   @JsonProperty("artifactEnclosureId")
   @JSONField(name = "artifactEnclosureId")
   @TableField("artifact_enclosure_id")
   @Column(name = "artifact_enclosure_id", columnDefinition = "bigint  COMMENT '构件/围护ID'", nullable = true)
   private Long artifactEnclosureId;
   @ApiModelProperty(name = "productMete", value = "采购核算量", notes = "采购核算量")
   @JsonProperty("productMete")
   @JSONField(name = "productMete")
   @TableField("product_mete")
   @Column(name = "product_mete", columnDefinition = "decimal(32,8) default '0' COMMENT '采购核算量'", nullable = true)
   private BigDecimal productMete;
   @ApiModelProperty(name = "productQuantity", value = "采购计量量", notes = "采购计量量")
   @JsonProperty("productQuantity")
   @JSONField(name = "productQuantity")
   @TableField("product_quantity")
   @Column(name = "product_quantity", columnDefinition = "decimal(32,8) default '0' COMMENT '采购计量量'", nullable = true)
   private BigDecimal productQuantity;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "standardId", value = "型材执行的国标ID", notes = "型材执行的国标ID")
   @JsonProperty("standardId")
   @JSONField(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id", columnDefinition = "bigint  COMMENT '型材执行的国标ID'", nullable = true)
   private Long standardId;
   @ApiModelProperty(name = "sectionSteelSpec", value = "型材规格", notes = "型材规格")
   @JsonProperty("sectionSteelSpec")
   @JSONField(name = "sectionSteelSpec")
   @TableField("section_steel_spec")
   @Column(name = "section_steel_spec", columnDefinition = "varchar(255)  COMMENT '型材规格'", nullable = true)
   private String sectionSteelSpec;
   @ApiModelProperty(name = "doNotSectionSteelSpec", value = "除去型材规格外的 规格", notes = "除去型材规格外的 规格")
   @JsonProperty("doNotSectionSteelSpec")
   @JSONField(name = "doNotSectionSteelSpec")
   @TableField("do_not_section_steel_spec")
   @Column(name = "do_not_section_steel_spec", columnDefinition = "varchar(255)  COMMENT '除去型材规格外的 规格'", nullable = true)
   private String doNotSectionSteelSpec;
   @ApiModelProperty(name = "materialSn", value = "材料编号", notes = "材料编号")
   @JsonProperty("materialSn")
   @JSONField(name = "materialSn")
   @TableField("material_sn")
   @Column(name = "material_sn", columnDefinition = "varchar(255)  COMMENT '材料编号'", nullable = true)
   private String materialSn;
   @ApiModelProperty(name = "sectionSteelSpecId", value = "型材规格ID", notes = "型材规格ID")
   @JsonProperty("sectionSteelSpecId")
   @JSONField(name = "sectionSteelSpecId")
   @TableField("section_steel_spec_id")
   @Column(name = "section_steel_spec_id", columnDefinition = "bigint  COMMENT '型材规格ID'", nullable = true)
   private Long sectionSteelSpecId;
   @ApiModelProperty(name = "specificationIds", value = "规格ID集", notes = "规格ID集")
   @JsonProperty("specificationIds")
   @JSONField(name = "specificationIds")
   @TableField("specification_ids")
   @Column(name = "specification_ids", columnDefinition = "varchar(255)  COMMENT '规格ID集'", nullable = true)
   private String specificationIds;
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
   @ApiModelProperty(name = "manufacturedName", value = "制成品名称", notes = "制成品名称")
   @JsonProperty("manufacturedName")
   @JSONField(name = "manufacturedName")
   @TableField("manufactured_name")
   @Column(name = "manufactured_name", columnDefinition = "varchar(255)  COMMENT '制成品名称'", nullable = true)
   private String manufacturedName;
   @ApiModelProperty(
      name = "manufacturedType",
      value = "制成品类型 结构制品 ArtifactTypeEnum  围护制品 EnclosureCategoryEnum",
      notes = "制成品类型 结构制品 ArtifactTypeEnum  围护制品 EnclosureCategoryEnum"
   )
   @JsonProperty("manufacturedType")
   @JSONField(name = "manufacturedType")
   @TableField("manufactured_type")
   @Column(name = "manufactured_type", columnDefinition = "varchar(255)  COMMENT '制成品类型 结构制品 ArtifactTypeEnum  围护制品 EnclosureCategoryEnum'", nullable = true)
   private Integer manufacturedType;
   @ApiModelProperty(name = "manufacturedSn", value = "制成品编号", notes = "制成品编号")
   @JsonProperty("manufacturedSn")
   @JSONField(name = "manufacturedSn")
   @TableField("manufactured_sn")
   @Column(name = "manufactured_sn", columnDefinition = "varchar(255)  COMMENT '制成品编号'", nullable = true)
   private String manufacturedSn;
   @ApiModelProperty(name = "manufacturedUnit", value = "制成品单位", notes = "制成品单位")
   @JsonProperty("manufacturedUnit")
   @JSONField(name = "manufacturedUnit")
   @TableField("manufactured_unit")
   @Column(name = "manufactured_unit", columnDefinition = "varchar(255)  COMMENT '制成品单位'", nullable = true)
   private String manufacturedUnit;
   @ApiModelProperty(name = "material", value = "制成品材质", notes = "制成品材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255)  COMMENT '制成品材质'", nullable = true)
   private String material;
   @ApiModelProperty(name = "steelDensity", value = "钢材密度", notes = "钢材密度")
   @JsonProperty("steelDensity")
   @JSONField(name = "steelDensity")
   @TableField("steel_density")
   @Column(name = "steel_density", columnDefinition = "decimal(10,5)  COMMENT '钢材密度'", nullable = true)
   private BigDecimal steelDensity;

   public static ApplyPurchaseDetail.ApplyPurchaseDetailBuilder builder() {
      return new ApplyPurchaseDetail.ApplyPurchaseDetailBuilder();
   }

   public ApplyPurchaseDetail() {
   }

   public ApplyPurchaseDetail(
      final Long id,
      final Long applyPurchaseId,
      final Long classifyId,
      final Long materialInventoryId,
      final String classifyName,
      final Integer basicClass,
      final String specification,
      final String model,
      final BigDecimal length,
      final BigDecimal width,
      final String measureUnit,
      final String accountingUnit,
      final BigDecimal thickness,
      final String brand,
      final String color,
      final BigDecimal quantity,
      final Boolean boolPurchase,
      final BigDecimal mete,
      final LocalDateTime arrivalTime,
      final Long artifactEnclosureId,
      final BigDecimal productMete,
      final BigDecimal productQuantity,
      final Long projectId,
      final Long standardId,
      final String sectionSteelSpec,
      final String doNotSectionSteelSpec,
      final String materialSn,
      final Long sectionSteelSpecId,
      final String specificationIds,
      final Long monomerId,
      final Long areaId,
      final BigDecimal weight,
      final BigDecimal totalWeight,
      final BigDecimal totalLength,
      final BigDecimal surfaceArea,
      final BigDecimal totalArea,
      final String manufacturedName,
      final Integer manufacturedType,
      final String manufacturedSn,
      final String manufacturedUnit,
      final String material,
      final BigDecimal steelDensity
   ) {
      this.id = id;
      this.applyPurchaseId = applyPurchaseId;
      this.classifyId = classifyId;
      this.materialInventoryId = materialInventoryId;
      this.classifyName = classifyName;
      this.basicClass = basicClass;
      this.specification = specification;
      this.model = model;
      this.length = length;
      this.width = width;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.thickness = thickness;
      this.brand = brand;
      this.color = color;
      this.quantity = quantity;
      this.boolPurchase = boolPurchase;
      this.mete = mete;
      this.arrivalTime = arrivalTime;
      this.artifactEnclosureId = artifactEnclosureId;
      this.productMete = productMete;
      this.productQuantity = productQuantity;
      this.projectId = projectId;
      this.standardId = standardId;
      this.sectionSteelSpec = sectionSteelSpec;
      this.doNotSectionSteelSpec = doNotSectionSteelSpec;
      this.materialSn = materialSn;
      this.sectionSteelSpecId = sectionSteelSpecId;
      this.specificationIds = specificationIds;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.weight = weight;
      this.totalWeight = totalWeight;
      this.totalLength = totalLength;
      this.surfaceArea = surfaceArea;
      this.totalArea = totalArea;
      this.manufacturedName = manufacturedName;
      this.manufacturedType = manufacturedType;
      this.manufacturedSn = manufacturedSn;
      this.manufacturedUnit = manufacturedUnit;
      this.material = material;
      this.steelDensity = steelDensity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getApplyPurchaseId() {
      return this.applyPurchaseId;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
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

   public String getModel() {
      return this.model;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
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

   public Boolean getBoolPurchase() {
      return this.boolPurchase;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public LocalDateTime getArrivalTime() {
      return this.arrivalTime;
   }

   public Long getArtifactEnclosureId() {
      return this.artifactEnclosureId;
   }

   public BigDecimal getProductMete() {
      return this.productMete;
   }

   public BigDecimal getProductQuantity() {
      return this.productQuantity;
   }

   public Long getProjectId() {
      return this.projectId;
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

   public String getMaterialSn() {
      return this.materialSn;
   }

   public Long getSectionSteelSpecId() {
      return this.sectionSteelSpecId;
   }

   public String getSpecificationIds() {
      return this.specificationIds;
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

   public String getManufacturedName() {
      return this.manufacturedName;
   }

   public Integer getManufacturedType() {
      return this.manufacturedType;
   }

   public String getManufacturedSn() {
      return this.manufacturedSn;
   }

   public String getManufacturedUnit() {
      return this.manufacturedUnit;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getSteelDensity() {
      return this.steelDensity;
   }

   @JsonProperty("id")
   public ApplyPurchaseDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("applyPurchaseId")
   public ApplyPurchaseDetail setApplyPurchaseId(final Long applyPurchaseId) {
      this.applyPurchaseId = applyPurchaseId;
      return this;
   }

   @JsonProperty("classifyId")
   public ApplyPurchaseDetail setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("materialInventoryId")
   public ApplyPurchaseDetail setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
      return this;
   }

   @JsonProperty("classifyName")
   public ApplyPurchaseDetail setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("basicClass")
   public ApplyPurchaseDetail setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("specification")
   public ApplyPurchaseDetail setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("model")
   public ApplyPurchaseDetail setModel(final String model) {
      this.model = model;
      return this;
   }

   @JsonProperty("length")
   public ApplyPurchaseDetail setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public ApplyPurchaseDetail setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("measureUnit")
   public ApplyPurchaseDetail setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   @JsonProperty("accountingUnit")
   public ApplyPurchaseDetail setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @JsonProperty("thickness")
   public ApplyPurchaseDetail setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("brand")
   public ApplyPurchaseDetail setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("color")
   public ApplyPurchaseDetail setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("quantity")
   public ApplyPurchaseDetail setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("boolPurchase")
   public ApplyPurchaseDetail setBoolPurchase(final Boolean boolPurchase) {
      this.boolPurchase = boolPurchase;
      return this;
   }

   @JsonProperty("mete")
   public ApplyPurchaseDetail setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("arrivalTime")
   public ApplyPurchaseDetail setArrivalTime(final LocalDateTime arrivalTime) {
      this.arrivalTime = arrivalTime;
      return this;
   }

   @JsonProperty("artifactEnclosureId")
   public ApplyPurchaseDetail setArtifactEnclosureId(final Long artifactEnclosureId) {
      this.artifactEnclosureId = artifactEnclosureId;
      return this;
   }

   @JsonProperty("productMete")
   public ApplyPurchaseDetail setProductMete(final BigDecimal productMete) {
      this.productMete = productMete;
      return this;
   }

   @JsonProperty("productQuantity")
   public ApplyPurchaseDetail setProductQuantity(final BigDecimal productQuantity) {
      this.productQuantity = productQuantity;
      return this;
   }

   @JsonProperty("projectId")
   public ApplyPurchaseDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("standardId")
   public ApplyPurchaseDetail setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("sectionSteelSpec")
   public ApplyPurchaseDetail setSectionSteelSpec(final String sectionSteelSpec) {
      this.sectionSteelSpec = sectionSteelSpec;
      return this;
   }

   @JsonProperty("doNotSectionSteelSpec")
   public ApplyPurchaseDetail setDoNotSectionSteelSpec(final String doNotSectionSteelSpec) {
      this.doNotSectionSteelSpec = doNotSectionSteelSpec;
      return this;
   }

   @JsonProperty("materialSn")
   public ApplyPurchaseDetail setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
      return this;
   }

   @JsonProperty("sectionSteelSpecId")
   public ApplyPurchaseDetail setSectionSteelSpecId(final Long sectionSteelSpecId) {
      this.sectionSteelSpecId = sectionSteelSpecId;
      return this;
   }

   @JsonProperty("specificationIds")
   public ApplyPurchaseDetail setSpecificationIds(final String specificationIds) {
      this.specificationIds = specificationIds;
      return this;
   }

   @JsonProperty("monomerId")
   public ApplyPurchaseDetail setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public ApplyPurchaseDetail setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("weight")
   public ApplyPurchaseDetail setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("totalWeight")
   public ApplyPurchaseDetail setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   @JsonProperty("totalLength")
   public ApplyPurchaseDetail setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("surfaceArea")
   public ApplyPurchaseDetail setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("totalArea")
   public ApplyPurchaseDetail setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   @JsonProperty("manufacturedName")
   public ApplyPurchaseDetail setManufacturedName(final String manufacturedName) {
      this.manufacturedName = manufacturedName;
      return this;
   }

   @JsonProperty("manufacturedType")
   public ApplyPurchaseDetail setManufacturedType(final Integer manufacturedType) {
      this.manufacturedType = manufacturedType;
      return this;
   }

   @JsonProperty("manufacturedSn")
   public ApplyPurchaseDetail setManufacturedSn(final String manufacturedSn) {
      this.manufacturedSn = manufacturedSn;
      return this;
   }

   @JsonProperty("manufacturedUnit")
   public ApplyPurchaseDetail setManufacturedUnit(final String manufacturedUnit) {
      this.manufacturedUnit = manufacturedUnit;
      return this;
   }

   @JsonProperty("material")
   public ApplyPurchaseDetail setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("steelDensity")
   public ApplyPurchaseDetail setSteelDensity(final BigDecimal steelDensity) {
      this.steelDensity = steelDensity;
      return this;
   }

   @Override
   public String toString() {
      return "ApplyPurchaseDetail(id="
         + this.getId()
         + ", applyPurchaseId="
         + this.getApplyPurchaseId()
         + ", classifyId="
         + this.getClassifyId()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", classifyName="
         + this.getClassifyName()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", model="
         + this.getModel()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", thickness="
         + this.getThickness()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", quantity="
         + this.getQuantity()
         + ", boolPurchase="
         + this.getBoolPurchase()
         + ", mete="
         + this.getMete()
         + ", arrivalTime="
         + this.getArrivalTime()
         + ", artifactEnclosureId="
         + this.getArtifactEnclosureId()
         + ", productMete="
         + this.getProductMete()
         + ", productQuantity="
         + this.getProductQuantity()
         + ", projectId="
         + this.getProjectId()
         + ", standardId="
         + this.getStandardId()
         + ", sectionSteelSpec="
         + this.getSectionSteelSpec()
         + ", doNotSectionSteelSpec="
         + this.getDoNotSectionSteelSpec()
         + ", materialSn="
         + this.getMaterialSn()
         + ", sectionSteelSpecId="
         + this.getSectionSteelSpecId()
         + ", specificationIds="
         + this.getSpecificationIds()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
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
         + ", manufacturedName="
         + this.getManufacturedName()
         + ", manufacturedType="
         + this.getManufacturedType()
         + ", manufacturedSn="
         + this.getManufacturedSn()
         + ", manufacturedUnit="
         + this.getManufacturedUnit()
         + ", material="
         + this.getMaterial()
         + ", steelDensity="
         + this.getSteelDensity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApplyPurchaseDetail)) {
         return false;
      }

      ApplyPurchaseDetail other = (ApplyPurchaseDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$applyPurchaseId = this.getApplyPurchaseId();
         Object other$applyPurchaseId = other.getApplyPurchaseId();
         if (this$applyPurchaseId == null ? other$applyPurchaseId == null : this$applyPurchaseId.equals(other$applyPurchaseId)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$materialInventoryId = this.getMaterialInventoryId();
               Object other$materialInventoryId = other.getMaterialInventoryId();
               if (this$materialInventoryId == null ? other$materialInventoryId == null : this$materialInventoryId.equals(other$materialInventoryId)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$boolPurchase = this.getBoolPurchase();
                     Object other$boolPurchase = other.getBoolPurchase();
                     if (this$boolPurchase == null ? other$boolPurchase == null : this$boolPurchase.equals(other$boolPurchase)) {
                        Object this$artifactEnclosureId = this.getArtifactEnclosureId();
                        Object other$artifactEnclosureId = other.getArtifactEnclosureId();
                        if (this$artifactEnclosureId == null ? other$artifactEnclosureId == null : this$artifactEnclosureId.equals(other$artifactEnclosureId)) {
                           Object this$projectId = this.getProjectId();
                           Object other$projectId = other.getProjectId();
                           if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                              Object this$standardId = this.getStandardId();
                              Object other$standardId = other.getStandardId();
                              if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                 Object this$sectionSteelSpecId = this.getSectionSteelSpecId();
                                 Object other$sectionSteelSpecId = other.getSectionSteelSpecId();
                                 if (this$sectionSteelSpecId == null
                                    ? other$sectionSteelSpecId == null
                                    : this$sectionSteelSpecId.equals(other$sectionSteelSpecId)) {
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
                                             Object this$classifyName = this.getClassifyName();
                                             Object other$classifyName = other.getClassifyName();
                                             if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                   Object this$model = this.getModel();
                                                   Object other$model = other.getModel();
                                                   if (this$model == null ? other$model == null : this$model.equals(other$model)) {
                                                      Object this$length = this.getLength();
                                                      Object other$length = other.getLength();
                                                      if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                         Object this$width = this.getWidth();
                                                         Object other$width = other.getWidth();
                                                         if (this$width == null ? other$width == null : this$width.equals(other$width)) {
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
                                                                           Object this$quantity = this.getQuantity();
                                                                           Object other$quantity = other.getQuantity();
                                                                           if (this$quantity == null
                                                                              ? other$quantity == null
                                                                              : this$quantity.equals(other$quantity)) {
                                                                              Object this$mete = this.getMete();
                                                                              Object other$mete = other.getMete();
                                                                              if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                                 Object this$arrivalTime = this.getArrivalTime();
                                                                                 Object other$arrivalTime = other.getArrivalTime();
                                                                                 if (this$arrivalTime == null
                                                                                    ? other$arrivalTime == null
                                                                                    : this$arrivalTime.equals(other$arrivalTime)) {
                                                                                    Object this$productMete = this.getProductMete();
                                                                                    Object other$productMete = other.getProductMete();
                                                                                    if (this$productMete == null
                                                                                       ? other$productMete == null
                                                                                       : this$productMete.equals(other$productMete)) {
                                                                                       Object this$productQuantity = this.getProductQuantity();
                                                                                       Object other$productQuantity = other.getProductQuantity();
                                                                                       if (this$productQuantity == null
                                                                                          ? other$productQuantity == null
                                                                                          : this$productQuantity.equals(other$productQuantity)) {
                                                                                          Object this$sectionSteelSpec = this.getSectionSteelSpec();
                                                                                          Object other$sectionSteelSpec = other.getSectionSteelSpec();
                                                                                          if (this$sectionSteelSpec == null
                                                                                             ? other$sectionSteelSpec == null
                                                                                             : this$sectionSteelSpec.equals(other$sectionSteelSpec)) {
                                                                                             Object this$doNotSectionSteelSpec = this.getDoNotSectionSteelSpec();
                                                                                             Object other$doNotSectionSteelSpec = other.getDoNotSectionSteelSpec();
                                                                                             if (this$doNotSectionSteelSpec == null
                                                                                                ? other$doNotSectionSteelSpec == null
                                                                                                : this$doNotSectionSteelSpec.equals(other$doNotSectionSteelSpec)
                                                                                                )
                                                                                              {
                                                                                                Object this$materialSn = this.getMaterialSn();
                                                                                                Object other$materialSn = other.getMaterialSn();
                                                                                                if (this$materialSn == null
                                                                                                   ? other$materialSn == null
                                                                                                   : this$materialSn.equals(other$materialSn)) {
                                                                                                   Object this$specificationIds = this.getSpecificationIds();
                                                                                                   Object other$specificationIds = other.getSpecificationIds();
                                                                                                   if (this$specificationIds == null
                                                                                                      ? other$specificationIds == null
                                                                                                      : this$specificationIds.equals(other$specificationIds)) {
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
                                                                                                                     Object this$manufacturedName = this.getManufacturedName();
                                                                                                                     Object other$manufacturedName = other.getManufacturedName();
                                                                                                                     if (this$manufacturedName == null
                                                                                                                        ? other$manufacturedName == null
                                                                                                                        : this$manufacturedName.equals(
                                                                                                                           other$manufacturedName
                                                                                                                        )) {
                                                                                                                        Object this$manufacturedSn = this.getManufacturedSn();
                                                                                                                        Object other$manufacturedSn = other.getManufacturedSn();
                                                                                                                        if (this$manufacturedSn == null
                                                                                                                           ? other$manufacturedSn == null
                                                                                                                           : this$manufacturedSn.equals(
                                                                                                                              other$manufacturedSn
                                                                                                                           )) {
                                                                                                                           Object this$manufacturedUnit = this.getManufacturedUnit();
                                                                                                                           Object other$manufacturedUnit = other.getManufacturedUnit();
                                                                                                                           if (this$manufacturedUnit == null
                                                                                                                              ? other$manufacturedUnit == null
                                                                                                                              : this$manufacturedUnit.equals(
                                                                                                                                 other$manufacturedUnit
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ApplyPurchaseDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $applyPurchaseId = this.getApplyPurchaseId();
      result = result * 59 + ($applyPurchaseId == null ? 43 : $applyPurchaseId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $boolPurchase = this.getBoolPurchase();
      result = result * 59 + ($boolPurchase == null ? 43 : $boolPurchase.hashCode());
      Object $artifactEnclosureId = this.getArtifactEnclosureId();
      result = result * 59 + ($artifactEnclosureId == null ? 43 : $artifactEnclosureId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $sectionSteelSpecId = this.getSectionSteelSpecId();
      result = result * 59 + ($sectionSteelSpecId == null ? 43 : $sectionSteelSpecId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $manufacturedType = this.getManufacturedType();
      result = result * 59 + ($manufacturedType == null ? 43 : $manufacturedType.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $model = this.getModel();
      result = result * 59 + ($model == null ? 43 : $model.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
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
      Object $arrivalTime = this.getArrivalTime();
      result = result * 59 + ($arrivalTime == null ? 43 : $arrivalTime.hashCode());
      Object $productMete = this.getProductMete();
      result = result * 59 + ($productMete == null ? 43 : $productMete.hashCode());
      Object $productQuantity = this.getProductQuantity();
      result = result * 59 + ($productQuantity == null ? 43 : $productQuantity.hashCode());
      Object $sectionSteelSpec = this.getSectionSteelSpec();
      result = result * 59 + ($sectionSteelSpec == null ? 43 : $sectionSteelSpec.hashCode());
      Object $doNotSectionSteelSpec = this.getDoNotSectionSteelSpec();
      result = result * 59 + ($doNotSectionSteelSpec == null ? 43 : $doNotSectionSteelSpec.hashCode());
      Object $materialSn = this.getMaterialSn();
      result = result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
      Object $specificationIds = this.getSpecificationIds();
      result = result * 59 + ($specificationIds == null ? 43 : $specificationIds.hashCode());
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
      Object $manufacturedName = this.getManufacturedName();
      result = result * 59 + ($manufacturedName == null ? 43 : $manufacturedName.hashCode());
      Object $manufacturedSn = this.getManufacturedSn();
      result = result * 59 + ($manufacturedSn == null ? 43 : $manufacturedSn.hashCode());
      Object $manufacturedUnit = this.getManufacturedUnit();
      result = result * 59 + ($manufacturedUnit == null ? 43 : $manufacturedUnit.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $steelDensity = this.getSteelDensity();
      return result * 59 + ($steelDensity == null ? 43 : $steelDensity.hashCode());
   }

   public static class ApplyPurchaseDetailBuilder {
      private Long id;
      private Long applyPurchaseId;
      private Long classifyId;
      private Long materialInventoryId;
      private String classifyName;
      private Integer basicClass;
      private String specification;
      private String model;
      private BigDecimal length;
      private BigDecimal width;
      private String measureUnit;
      private String accountingUnit;
      private BigDecimal thickness;
      private String brand;
      private String color;
      private BigDecimal quantity;
      private Boolean boolPurchase;
      private BigDecimal mete;
      private LocalDateTime arrivalTime;
      private Long artifactEnclosureId;
      private BigDecimal productMete;
      private BigDecimal productQuantity;
      private Long projectId;
      private Long standardId;
      private String sectionSteelSpec;
      private String doNotSectionSteelSpec;
      private String materialSn;
      private Long sectionSteelSpecId;
      private String specificationIds;
      private Long monomerId;
      private Long areaId;
      private BigDecimal weight;
      private BigDecimal totalWeight;
      private BigDecimal totalLength;
      private BigDecimal surfaceArea;
      private BigDecimal totalArea;
      private String manufacturedName;
      private Integer manufacturedType;
      private String manufacturedSn;
      private String manufacturedUnit;
      private String material;
      private BigDecimal steelDensity;

      ApplyPurchaseDetailBuilder() {
      }

      @JsonProperty("id")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("applyPurchaseId")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder applyPurchaseId(final Long applyPurchaseId) {
         this.applyPurchaseId = applyPurchaseId;
         return this;
      }

      @JsonProperty("classifyId")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("materialInventoryId")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      @JsonProperty("classifyName")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("basicClass")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("specification")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("model")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder model(final String model) {
         this.model = model;
         return this;
      }

      @JsonProperty("length")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("measureUnit")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      @JsonProperty("accountingUnit")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("thickness")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("brand")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("color")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("quantity")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("boolPurchase")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder boolPurchase(final Boolean boolPurchase) {
         this.boolPurchase = boolPurchase;
         return this;
      }

      @JsonProperty("mete")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("arrivalTime")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder arrivalTime(final LocalDateTime arrivalTime) {
         this.arrivalTime = arrivalTime;
         return this;
      }

      @JsonProperty("artifactEnclosureId")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder artifactEnclosureId(final Long artifactEnclosureId) {
         this.artifactEnclosureId = artifactEnclosureId;
         return this;
      }

      @JsonProperty("productMete")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder productMete(final BigDecimal productMete) {
         this.productMete = productMete;
         return this;
      }

      @JsonProperty("productQuantity")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder productQuantity(final BigDecimal productQuantity) {
         this.productQuantity = productQuantity;
         return this;
      }

      @JsonProperty("projectId")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("standardId")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("sectionSteelSpec")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder sectionSteelSpec(final String sectionSteelSpec) {
         this.sectionSteelSpec = sectionSteelSpec;
         return this;
      }

      @JsonProperty("doNotSectionSteelSpec")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder doNotSectionSteelSpec(final String doNotSectionSteelSpec) {
         this.doNotSectionSteelSpec = doNotSectionSteelSpec;
         return this;
      }

      @JsonProperty("materialSn")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      @JsonProperty("sectionSteelSpecId")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder sectionSteelSpecId(final Long sectionSteelSpecId) {
         this.sectionSteelSpecId = sectionSteelSpecId;
         return this;
      }

      @JsonProperty("specificationIds")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder specificationIds(final String specificationIds) {
         this.specificationIds = specificationIds;
         return this;
      }

      @JsonProperty("monomerId")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("weight")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("totalWeight")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      @JsonProperty("totalLength")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("surfaceArea")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("totalArea")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("manufacturedName")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder manufacturedName(final String manufacturedName) {
         this.manufacturedName = manufacturedName;
         return this;
      }

      @JsonProperty("manufacturedType")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder manufacturedType(final Integer manufacturedType) {
         this.manufacturedType = manufacturedType;
         return this;
      }

      @JsonProperty("manufacturedSn")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder manufacturedSn(final String manufacturedSn) {
         this.manufacturedSn = manufacturedSn;
         return this;
      }

      @JsonProperty("manufacturedUnit")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder manufacturedUnit(final String manufacturedUnit) {
         this.manufacturedUnit = manufacturedUnit;
         return this;
      }

      @JsonProperty("material")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("steelDensity")
      public ApplyPurchaseDetail.ApplyPurchaseDetailBuilder steelDensity(final BigDecimal steelDensity) {
         this.steelDensity = steelDensity;
         return this;
      }

      public ApplyPurchaseDetail build() {
         return new ApplyPurchaseDetail(
            this.id,
            this.applyPurchaseId,
            this.classifyId,
            this.materialInventoryId,
            this.classifyName,
            this.basicClass,
            this.specification,
            this.model,
            this.length,
            this.width,
            this.measureUnit,
            this.accountingUnit,
            this.thickness,
            this.brand,
            this.color,
            this.quantity,
            this.boolPurchase,
            this.mete,
            this.arrivalTime,
            this.artifactEnclosureId,
            this.productMete,
            this.productQuantity,
            this.projectId,
            this.standardId,
            this.sectionSteelSpec,
            this.doNotSectionSteelSpec,
            this.materialSn,
            this.sectionSteelSpecId,
            this.specificationIds,
            this.monomerId,
            this.areaId,
            this.weight,
            this.totalWeight,
            this.totalLength,
            this.surfaceArea,
            this.totalArea,
            this.manufacturedName,
            this.manufacturedType,
            this.manufacturedSn,
            this.manufacturedUnit,
            this.material,
            this.steelDensity
         );
      }

      @Override
      public String toString() {
         return "ApplyPurchaseDetail.ApplyPurchaseDetailBuilder(id="
            + this.id
            + ", applyPurchaseId="
            + this.applyPurchaseId
            + ", classifyId="
            + this.classifyId
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", classifyName="
            + this.classifyName
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", model="
            + this.model
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", thickness="
            + this.thickness
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", quantity="
            + this.quantity
            + ", boolPurchase="
            + this.boolPurchase
            + ", mete="
            + this.mete
            + ", arrivalTime="
            + this.arrivalTime
            + ", artifactEnclosureId="
            + this.artifactEnclosureId
            + ", productMete="
            + this.productMete
            + ", productQuantity="
            + this.productQuantity
            + ", projectId="
            + this.projectId
            + ", standardId="
            + this.standardId
            + ", sectionSteelSpec="
            + this.sectionSteelSpec
            + ", doNotSectionSteelSpec="
            + this.doNotSectionSteelSpec
            + ", materialSn="
            + this.materialSn
            + ", sectionSteelSpecId="
            + this.sectionSteelSpecId
            + ", specificationIds="
            + this.specificationIds
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
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
            + ", manufacturedName="
            + this.manufacturedName
            + ", manufacturedType="
            + this.manufacturedType
            + ", manufacturedSn="
            + this.manufacturedSn
            + ", manufacturedUnit="
            + this.manufacturedUnit
            + ", material="
            + this.material
            + ", steelDensity="
            + this.steelDensity
            + ")";
      }
   }
}
