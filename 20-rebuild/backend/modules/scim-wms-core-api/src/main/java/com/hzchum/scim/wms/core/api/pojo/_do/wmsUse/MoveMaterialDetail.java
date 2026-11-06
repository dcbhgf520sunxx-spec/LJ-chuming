package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "WmsMoveMaterialDetail对象", description = "物料移库明细表")
@Entity
@TableName("wms_move_material_detail")
@Table(name = "wms_move_material_detail")
@org.hibernate.annotations.Table(appliesTo = "wms_move_material_detail", comment = "物料移库明细表")
public class MoveMaterialDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "moveMaterialId", value = "移库单ID", notes = "移库单ID")
   @TableField("move_material_id")
   @Column(name = "move_material_id", columnDefinition = "bigint  COMMENT '移库单ID'", nullable = true)
   private Long moveMaterialId;
   @ApiModelProperty(name = "serialNumber", value = "物料编号", notes = "物料编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(128)  COMMENT '物料编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型", notes = "物料基础类型")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "科目名称", notes = "科目名称")
   @TableField("classify_name")
   @Column(name = "classify_name", columnDefinition = "varchar(128)  COMMENT '科目名称'", nullable = true)
   private String classifyName;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(128)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "model", value = "型号")
   @TableField("model")
   @Column(name = "model", columnDefinition = "varchar(255)  COMMENT '型号'", nullable = true)
   private String model;
   @ApiModelProperty(name = "materialIsWhole", value = "物料是否完整[1 整料,2 余料", notes = "物料是否完整[1 整料,2 余料")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole", columnDefinition = "int  COMMENT '物料是否完整[1 整料,2 余料'", nullable = true)
   private Integer materialIsWhole;
   @ApiModelProperty(name = "warehouseType", value = "仓库类型[1 公共库,2 项目库]", notes = "仓库类型[1 公共库,2 项目库]")
   @TableField("warehouse_type")
   @Column(name = "warehouse_type", columnDefinition = "int  COMMENT '仓库类型[1 公共库,2 项目库]'", nullable = true)
   private Integer warehouseType;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint  COMMENT '单体ID'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint  COMMENT '区域ID'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "boolPartyA", value = "是否甲供物料", notes = "是否甲供物料")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否甲供物料'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "quantity", value = "移库数量", notes = "移库数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '移库数量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "length", value = "长度", notes = "长度")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,0)  COMMENT '长度'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "宽度", notes = "宽度")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,0)  COMMENT '宽度'", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚度", notes = "厚度")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8)  COMMENT '厚度'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚", notes = "理论厚")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness", columnDefinition = "decimal(32,8)  COMMENT '理论厚'", nullable = true)
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "oneTheoryWeight", value = "单件理论重量", notes = "单件理论重量")
   @TableField("one_theory_weight")
   @Column(name = "one_theory_weight", columnDefinition = "decimal(32,8)  COMMENT '单件理论重量'", nullable = true)
   private BigDecimal oneTheoryWeight;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(255)  COMMENT '品牌'", nullable = true)
   private String brand;
   @ApiModelProperty(name = "heatNoAndBatchNo", value = "炉批号", notes = "炉批号")
   @TableField("heat_no_and_batch_no")
   @Column(name = "heat_no_and_batch_no", columnDefinition = "varchar(255)  COMMENT '炉批号'", nullable = true)
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "color", value = "颜色", notes = "颜色")
   @TableField("color")
   @Column(name = "color", columnDefinition = "varchar(255)  COMMENT '颜色'", nullable = true)
   private String color;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(50)  COMMENT '计量单位'", nullable = true)
   private String measureUnit;
   @ApiModelProperty(name = "accountingPrecision", value = "核算精度", notes = "核算精度")
   @TableField("accounting_precision")
   @Column(name = "accounting_precision", columnDefinition = "int  COMMENT '核算精度'", nullable = true)
   private Integer accountingPrecision;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(20)  COMMENT '核算单位'", nullable = true)
   private String accountingUnit;
   @ApiModelProperty(name = "unitNet", value = "单位净量", notes = "单位净量")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(32,8)  COMMENT '单位净量'", nullable = true)
   private BigDecimal unitNet;
   @ApiModelProperty(name = "mete", value = "移库总核算量,钢材为当前物料总核算,辅材为单个的核算", notes = "移库总核算量,钢材为当前物料总核算,辅材为单个的核算")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '移库总核算量,钢材为当前物料总核算,辅材为单个的核算'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "sourceWorkshopId", value = "原仓库ID -> wms", notes = "原仓库ID -> wms")
   @TableField("source_workshop_id")
   @Column(name = "source_workshop_id", columnDefinition = "bigint  COMMENT '原仓库ID -> wms'", nullable = true)
   private Long sourceWorkshopId;
   @ApiModelProperty(name = "directionWorkshopId", value = "目标仓库ID -> wms", notes = "目标仓库ID -> wms")
   @TableField("direction_workshop_id")
   @Column(name = "direction_workshop_id", columnDefinition = "bigint  COMMENT '目标仓库ID -> wms'", nullable = true)
   private Long directionWorkshopId;
   @ApiModelProperty(name = "sourceWarehouseId", value = "原存储位置ID -> wms", notes = "原存储位置ID -> wms")
   @TableField("source_warehouse_id")
   @Column(name = "source_warehouse_id", columnDefinition = "bigint  COMMENT '原存储位置ID -> wms'", nullable = true)
   private Long sourceWarehouseId;
   @ApiModelProperty(name = "directionWarehouseId", value = "目标存储位置ID -> wms", notes = "目标存储位置ID -> wms")
   @TableField("direction_warehouse_id")
   @Column(name = "direction_warehouse_id", columnDefinition = "bigint  COMMENT '目标存储位置ID -> wms'", nullable = true)
   private Long directionWarehouseId;
   @ApiModelProperty(name = "sourceFactoryId", value = "原工厂ID", notes = "原工厂ID")
   @TableField("source_factory_id")
   @Column(name = "source_factory_id", columnDefinition = "bigint  COMMENT '原工厂ID'", nullable = true)
   private Long sourceFactoryId;
   @ApiModelProperty(name = "directionFactoryId", value = "目标工厂ID", notes = "目标工厂ID")
   @TableField("direction_factory_id")
   @Column(name = "direction_factory_id", columnDefinition = "bigint  COMMENT '目标工厂ID '", nullable = true)
   private Long directionFactoryId;
   @ApiModelProperty(name = "weightMeasurementMode", value = "重量计量方式 [1理计 , 2 磅计 ,混合计]", notes = "重量计量方式 [1理计 , 2 磅计 ,混合计]")
   @TableField("weight_measurement_mode")
   @Column(name = "weight_measurement_mode", columnDefinition = "varchar(255)  COMMENT '重量计量方式 [1理计 , 2 磅计 ,混合计]'", nullable = true)
   private Integer weightMeasurementMode;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(32,8)  COMMENT '税率'", nullable = true)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "invoiceType", value = "票据类型", notes = "票据类型")
   @TableField("invoice_type")
   @Column(name = "invoice_type", columnDefinition = "int  COMMENT '票据类型'", nullable = true)
   private Integer invoiceType;
   @ApiModelProperty(name = "outboundSn", value = "出库单编号,针对物料半出后产生余料的溯源", notes = "税率")
   @TableField("outbound_SN")
   @Column(name = "outbound_SN", columnDefinition = "varchar(50)  COMMENT '出库单编号,针对物料半出后产生余料的溯源'", nullable = true)
   private String outboundSn;
   @ApiModelProperty(name = "weightedAverageSpec", value = "加权平均规格(将规格拆分获取不参与加权规格以*号拼接)", notes = "加权平均规格(将规格拆分获取不参与加权规格以*号拼接)")
   @TableField("weighted_average_spec")
   @Column(name = "weighted_average_spec", columnDefinition = "varchar(255)  COMMENT '加权平均规格(将规格拆分获取不参与加权规格以*号拼接)'", nullable = true)
   private String weightedAverageSpec;
   @ApiModelProperty(name = "standardId", value = "型材执行国标ID", notes = "型材执行国标ID")
   @TableField("standard_id")
   @Column(name = "standard_id", columnDefinition = "bigint  COMMENT '型材执行国标ID'", nullable = true)
   private Long standardId;
   @ApiModelProperty(name = "standardName", value = "型材执行国标名称", notes = "型材执行国标名称")
   @TableField("standard_name")
   @Column(name = "standard_name", columnDefinition = "varchar(50)  COMMENT '型材执行国标名称'", nullable = true)
   private String standardName;
   @ApiModelProperty(name = "sectionSteelWeight", value = "型材标准重量(Kg/m)", notes = "型材标准重量(Kg/m)")
   @TableField("section_steel_weight")
   @Column(name = "section_steel_weight", columnDefinition = "decimal(32,8)  COMMENT '型材标准重量(Kg/m)'", nullable = true)
   private BigDecimal sectionSteelWeight;
   @ApiModelProperty(name = "surplusSn", value = "余料编号", notes = "余料编号")
   @TableField("surplus_sn")
   @Column(name = "surplus_sn", columnDefinition = "varchar(255)  COMMENT '余料编号'", nullable = true)
   private String surplusSn;
   @ApiModelProperty(name = "boolVirtual", value = "是否虚拟", notes = "是否虚拟")
   @TableField("bool_virtual")
   @Column(name = "bool_virtual", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '是否虚拟'", nullable = true)
   private Boolean boolVirtual;
   @ApiModelProperty(name = "outboundId", value = "出库单ID", notes = "出库单ID")
   @TableField("outbound_id")
   @Column(name = "outbound_id", columnDefinition = "bigint  COMMENT '出库单ID,跨组织出库使用(重工)'", nullable = true)
   private Long outboundId;
   @ApiModelProperty(name = "inboundId", value = "入库单ID", notes = "入库单ID")
   @TableField("inbound_id")
   @Column(name = "inbound_id", columnDefinition = "bigint  COMMENT '入库单ID,跨组织出库使用(装配式)'", nullable = true)
   private Long inboundId;
   @ApiModelProperty(name = "sourceMaterialInventoryId", value = "来源库存id", notes = "来源库存id")
   @TableField("source_material_inventory_id")
   @Column(name = "source_material_inventory_id", columnDefinition = "bigint  COMMENT '来源库存id,跨组织出库使用(来自重工)'", nullable = true)
   private Long sourceMaterialInventoryId;
   @ApiModelProperty(name = "sourceMaterielId", value = "原物料存储ID （若想查询需要连删除的一块查）", notes = "原物料存储ID （若想查询需要连删除的一块查）")
   @TableField("source_materiel_id")
   @Column(name = "source_materiel_id", columnDefinition = "bigint  COMMENT '原物料存储ID （若想查询需要连删除的一块查）'", nullable = true)
   private Long sourceMaterielId;
   @ApiModelProperty(name = "newMaterialId", value = "新物料存储ID （若想查询需要连删除的一块查）", notes = "新物料存储ID （若想查询需要连删除的一块查）")
   @TableField("new_material_id")
   @Column(name = "new_material_id", columnDefinition = "bigint  COMMENT '新物料存储ID （若想查询需要连删除的一块查）'", nullable = true)
   private Long newMaterialId;
   @ApiModelProperty(name = "unitPrice", value = "加权价(含税)", notes = "加权价(含税)")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,8)  COMMENT '加权价(含税)'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "unitPriceExcludingVat", value = "不含税加权价", notes = "不含税加权价")
   @TableField("unit_price_excluding_VAT")
   @Column(name = "unit_price_excluding_VAT", columnDefinition = "decimal(32,8)  COMMENT '不含税加权价'", nullable = true)
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty(name = "amount", value = "总价", notes = "总价")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,8)  COMMENT '总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税总价", notes = "不含税总价")
   @TableField("amount_excluding_VAT")
   @Column(name = "amount_excluding_VAT ", columnDefinition = "decimal(32,8)  COMMENT '不含税总价'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "inputVat", value = "进项税", notes = "进项税")
   @TableField("input_VAT")
   @Column(name = "input_VAT", columnDefinition = "decimal(32,8)  COMMENT '进项税'", nullable = true)
   private BigDecimal inputVat;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;

   public static MoveMaterialDetail.MoveMaterialDetailBuilder builder() {
      return new MoveMaterialDetail.MoveMaterialDetailBuilder();
   }

   public MoveMaterialDetail() {
   }

   public MoveMaterialDetail(
      final Long id,
      final Long moveMaterialId,
      final String serialNumber,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final String specification,
      final String model,
      final Integer materialIsWhole,
      final Integer warehouseType,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Boolean boolPartyA,
      final BigDecimal quantity,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final BigDecimal oneTheoryWeight,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final String measureUnit,
      final Integer accountingPrecision,
      final String accountingUnit,
      final BigDecimal unitNet,
      final BigDecimal mete,
      final Long sourceWorkshopId,
      final Long directionWorkshopId,
      final Long sourceWarehouseId,
      final Long directionWarehouseId,
      final Long sourceFactoryId,
      final Long directionFactoryId,
      final Integer weightMeasurementMode,
      final BigDecimal taxRate,
      final Integer invoiceType,
      final String outboundSn,
      final String weightedAverageSpec,
      final Long standardId,
      final String standardName,
      final BigDecimal sectionSteelWeight,
      final String surplusSn,
      final Boolean boolVirtual,
      final Long outboundId,
      final Long inboundId,
      final Long sourceMaterialInventoryId,
      final Long sourceMaterielId,
      final Long newMaterialId,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final BigDecimal inputVat,
      final String remark
   ) {
      this.id = id;
      this.moveMaterialId = moveMaterialId;
      this.serialNumber = serialNumber;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.specification = specification;
      this.model = model;
      this.materialIsWhole = materialIsWhole;
      this.warehouseType = warehouseType;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.boolPartyA = boolPartyA;
      this.quantity = quantity;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.oneTheoryWeight = oneTheoryWeight;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.measureUnit = measureUnit;
      this.accountingPrecision = accountingPrecision;
      this.accountingUnit = accountingUnit;
      this.unitNet = unitNet;
      this.mete = mete;
      this.sourceWorkshopId = sourceWorkshopId;
      this.directionWorkshopId = directionWorkshopId;
      this.sourceWarehouseId = sourceWarehouseId;
      this.directionWarehouseId = directionWarehouseId;
      this.sourceFactoryId = sourceFactoryId;
      this.directionFactoryId = directionFactoryId;
      this.weightMeasurementMode = weightMeasurementMode;
      this.taxRate = taxRate;
      this.invoiceType = invoiceType;
      this.outboundSn = outboundSn;
      this.weightedAverageSpec = weightedAverageSpec;
      this.standardId = standardId;
      this.standardName = standardName;
      this.sectionSteelWeight = sectionSteelWeight;
      this.surplusSn = surplusSn;
      this.boolVirtual = boolVirtual;
      this.outboundId = outboundId;
      this.inboundId = inboundId;
      this.sourceMaterialInventoryId = sourceMaterialInventoryId;
      this.sourceMaterielId = sourceMaterielId;
      this.newMaterialId = newMaterialId;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.inputVat = inputVat;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getMoveMaterialId() {
      return this.moveMaterialId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
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

   public String getSpecification() {
      return this.specification;
   }

   public String getModel() {
      return this.model;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
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

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
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

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
   }

   public BigDecimal getOneTheoryWeight() {
      return this.oneTheoryWeight;
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

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Long getSourceWorkshopId() {
      return this.sourceWorkshopId;
   }

   public Long getDirectionWorkshopId() {
      return this.directionWorkshopId;
   }

   public Long getSourceWarehouseId() {
      return this.sourceWarehouseId;
   }

   public Long getDirectionWarehouseId() {
      return this.directionWarehouseId;
   }

   public Long getSourceFactoryId() {
      return this.sourceFactoryId;
   }

   public Long getDirectionFactoryId() {
      return this.directionFactoryId;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public String getOutboundSn() {
      return this.outboundSn;
   }

   public String getWeightedAverageSpec() {
      return this.weightedAverageSpec;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public BigDecimal getSectionSteelWeight() {
      return this.sectionSteelWeight;
   }

   public String getSurplusSn() {
      return this.surplusSn;
   }

   public Boolean getBoolVirtual() {
      return this.boolVirtual;
   }

   public Long getOutboundId() {
      return this.outboundId;
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public Long getSourceMaterialInventoryId() {
      return this.sourceMaterialInventoryId;
   }

   public Long getSourceMaterielId() {
      return this.sourceMaterielId;
   }

   public Long getNewMaterialId() {
      return this.newMaterialId;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public String getRemark() {
      return this.remark;
   }

   public MoveMaterialDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public MoveMaterialDetail setMoveMaterialId(final Long moveMaterialId) {
      this.moveMaterialId = moveMaterialId;
      return this;
   }

   public MoveMaterialDetail setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MoveMaterialDetail setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public MoveMaterialDetail setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   public MoveMaterialDetail setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   public MoveMaterialDetail setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public MoveMaterialDetail setModel(final String model) {
      this.model = model;
      return this;
   }

   public MoveMaterialDetail setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   public MoveMaterialDetail setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   public MoveMaterialDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MoveMaterialDetail setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MoveMaterialDetail setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public MoveMaterialDetail setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   public MoveMaterialDetail setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   public MoveMaterialDetail setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public MoveMaterialDetail setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   public MoveMaterialDetail setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   public MoveMaterialDetail setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   public MoveMaterialDetail setOneTheoryWeight(final BigDecimal oneTheoryWeight) {
      this.oneTheoryWeight = oneTheoryWeight;
      return this;
   }

   public MoveMaterialDetail setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   public MoveMaterialDetail setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   public MoveMaterialDetail setColor(final String color) {
      this.color = color;
      return this;
   }

   public MoveMaterialDetail setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public MoveMaterialDetail setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
      return this;
   }

   public MoveMaterialDetail setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   public MoveMaterialDetail setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   public MoveMaterialDetail setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   public MoveMaterialDetail setSourceWorkshopId(final Long sourceWorkshopId) {
      this.sourceWorkshopId = sourceWorkshopId;
      return this;
   }

   public MoveMaterialDetail setDirectionWorkshopId(final Long directionWorkshopId) {
      this.directionWorkshopId = directionWorkshopId;
      return this;
   }

   public MoveMaterialDetail setSourceWarehouseId(final Long sourceWarehouseId) {
      this.sourceWarehouseId = sourceWarehouseId;
      return this;
   }

   public MoveMaterialDetail setDirectionWarehouseId(final Long directionWarehouseId) {
      this.directionWarehouseId = directionWarehouseId;
      return this;
   }

   public MoveMaterialDetail setSourceFactoryId(final Long sourceFactoryId) {
      this.sourceFactoryId = sourceFactoryId;
      return this;
   }

   public MoveMaterialDetail setDirectionFactoryId(final Long directionFactoryId) {
      this.directionFactoryId = directionFactoryId;
      return this;
   }

   public MoveMaterialDetail setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
      return this;
   }

   public MoveMaterialDetail setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   public MoveMaterialDetail setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   public MoveMaterialDetail setOutboundSn(final String outboundSn) {
      this.outboundSn = outboundSn;
      return this;
   }

   public MoveMaterialDetail setWeightedAverageSpec(final String weightedAverageSpec) {
      this.weightedAverageSpec = weightedAverageSpec;
      return this;
   }

   public MoveMaterialDetail setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   public MoveMaterialDetail setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   public MoveMaterialDetail setSectionSteelWeight(final BigDecimal sectionSteelWeight) {
      this.sectionSteelWeight = sectionSteelWeight;
      return this;
   }

   public MoveMaterialDetail setSurplusSn(final String surplusSn) {
      this.surplusSn = surplusSn;
      return this;
   }

   public MoveMaterialDetail setBoolVirtual(final Boolean boolVirtual) {
      this.boolVirtual = boolVirtual;
      return this;
   }

   public MoveMaterialDetail setOutboundId(final Long outboundId) {
      this.outboundId = outboundId;
      return this;
   }

   public MoveMaterialDetail setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
      return this;
   }

   public MoveMaterialDetail setSourceMaterialInventoryId(final Long sourceMaterialInventoryId) {
      this.sourceMaterialInventoryId = sourceMaterialInventoryId;
      return this;
   }

   public MoveMaterialDetail setSourceMaterielId(final Long sourceMaterielId) {
      this.sourceMaterielId = sourceMaterielId;
      return this;
   }

   public MoveMaterialDetail setNewMaterialId(final Long newMaterialId) {
      this.newMaterialId = newMaterialId;
      return this;
   }

   public MoveMaterialDetail setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   public MoveMaterialDetail setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   public MoveMaterialDetail setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public MoveMaterialDetail setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   public MoveMaterialDetail setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   public MoveMaterialDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "MoveMaterialDetail(id="
         + this.getId()
         + ", moveMaterialId="
         + this.getMoveMaterialId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", specification="
         + this.getSpecification()
         + ", model="
         + this.getModel()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", quantity="
         + this.getQuantity()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", oneTheoryWeight="
         + this.getOneTheoryWeight()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", unitNet="
         + this.getUnitNet()
         + ", mete="
         + this.getMete()
         + ", sourceWorkshopId="
         + this.getSourceWorkshopId()
         + ", directionWorkshopId="
         + this.getDirectionWorkshopId()
         + ", sourceWarehouseId="
         + this.getSourceWarehouseId()
         + ", directionWarehouseId="
         + this.getDirectionWarehouseId()
         + ", sourceFactoryId="
         + this.getSourceFactoryId()
         + ", directionFactoryId="
         + this.getDirectionFactoryId()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", taxRate="
         + this.getTaxRate()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", outboundSn="
         + this.getOutboundSn()
         + ", weightedAverageSpec="
         + this.getWeightedAverageSpec()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", sectionSteelWeight="
         + this.getSectionSteelWeight()
         + ", surplusSn="
         + this.getSurplusSn()
         + ", boolVirtual="
         + this.getBoolVirtual()
         + ", outboundId="
         + this.getOutboundId()
         + ", inboundId="
         + this.getInboundId()
         + ", sourceMaterialInventoryId="
         + this.getSourceMaterialInventoryId()
         + ", sourceMaterielId="
         + this.getSourceMaterielId()
         + ", newMaterialId="
         + this.getNewMaterialId()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MoveMaterialDetail)) {
         return false;
      }

      MoveMaterialDetail other = (MoveMaterialDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$moveMaterialId = this.getMoveMaterialId();
         Object other$moveMaterialId = other.getMoveMaterialId();
         if (this$moveMaterialId == null ? other$moveMaterialId == null : this$moveMaterialId.equals(other$moveMaterialId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$classifyId = this.getClassifyId();
               Object other$classifyId = other.getClassifyId();
               if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                  Object this$materialIsWhole = this.getMaterialIsWhole();
                  Object other$materialIsWhole = other.getMaterialIsWhole();
                  if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
                     Object this$warehouseType = this.getWarehouseType();
                     Object other$warehouseType = other.getWarehouseType();
                     if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
                        Object this$projectId = this.getProjectId();
                        Object other$projectId = other.getProjectId();
                        if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                           Object this$monomerId = this.getMonomerId();
                           Object other$monomerId = other.getMonomerId();
                           if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                              Object this$areaId = this.getAreaId();
                              Object other$areaId = other.getAreaId();
                              if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                 Object this$boolPartyA = this.getBoolPartyA();
                                 Object other$boolPartyA = other.getBoolPartyA();
                                 if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                                    Object this$accountingPrecision = this.getAccountingPrecision();
                                    Object other$accountingPrecision = other.getAccountingPrecision();
                                    if (this$accountingPrecision == null
                                       ? other$accountingPrecision == null
                                       : this$accountingPrecision.equals(other$accountingPrecision)) {
                                       Object this$sourceWorkshopId = this.getSourceWorkshopId();
                                       Object other$sourceWorkshopId = other.getSourceWorkshopId();
                                       if (this$sourceWorkshopId == null
                                          ? other$sourceWorkshopId == null
                                          : this$sourceWorkshopId.equals(other$sourceWorkshopId)) {
                                          Object this$directionWorkshopId = this.getDirectionWorkshopId();
                                          Object other$directionWorkshopId = other.getDirectionWorkshopId();
                                          if (this$directionWorkshopId == null
                                             ? other$directionWorkshopId == null
                                             : this$directionWorkshopId.equals(other$directionWorkshopId)) {
                                             Object this$sourceWarehouseId = this.getSourceWarehouseId();
                                             Object other$sourceWarehouseId = other.getSourceWarehouseId();
                                             if (this$sourceWarehouseId == null
                                                ? other$sourceWarehouseId == null
                                                : this$sourceWarehouseId.equals(other$sourceWarehouseId)) {
                                                Object this$directionWarehouseId = this.getDirectionWarehouseId();
                                                Object other$directionWarehouseId = other.getDirectionWarehouseId();
                                                if (this$directionWarehouseId == null
                                                   ? other$directionWarehouseId == null
                                                   : this$directionWarehouseId.equals(other$directionWarehouseId)) {
                                                   Object this$sourceFactoryId = this.getSourceFactoryId();
                                                   Object other$sourceFactoryId = other.getSourceFactoryId();
                                                   if (this$sourceFactoryId == null
                                                      ? other$sourceFactoryId == null
                                                      : this$sourceFactoryId.equals(other$sourceFactoryId)) {
                                                      Object this$directionFactoryId = this.getDirectionFactoryId();
                                                      Object other$directionFactoryId = other.getDirectionFactoryId();
                                                      if (this$directionFactoryId == null
                                                         ? other$directionFactoryId == null
                                                         : this$directionFactoryId.equals(other$directionFactoryId)) {
                                                         Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                                                         Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                                                         if (this$weightMeasurementMode == null
                                                            ? other$weightMeasurementMode == null
                                                            : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                                            Object this$invoiceType = this.getInvoiceType();
                                                            Object other$invoiceType = other.getInvoiceType();
                                                            if (this$invoiceType == null
                                                               ? other$invoiceType == null
                                                               : this$invoiceType.equals(other$invoiceType)) {
                                                               Object this$standardId = this.getStandardId();
                                                               Object other$standardId = other.getStandardId();
                                                               if (this$standardId == null
                                                                  ? other$standardId == null
                                                                  : this$standardId.equals(other$standardId)) {
                                                                  Object this$boolVirtual = this.getBoolVirtual();
                                                                  Object other$boolVirtual = other.getBoolVirtual();
                                                                  if (this$boolVirtual == null
                                                                     ? other$boolVirtual == null
                                                                     : this$boolVirtual.equals(other$boolVirtual)) {
                                                                     Object this$outboundId = this.getOutboundId();
                                                                     Object other$outboundId = other.getOutboundId();
                                                                     if (this$outboundId == null
                                                                        ? other$outboundId == null
                                                                        : this$outboundId.equals(other$outboundId)) {
                                                                        Object this$inboundId = this.getInboundId();
                                                                        Object other$inboundId = other.getInboundId();
                                                                        if (this$inboundId == null
                                                                           ? other$inboundId == null
                                                                           : this$inboundId.equals(other$inboundId)) {
                                                                           Object this$sourceMaterialInventoryId = this.getSourceMaterialInventoryId();
                                                                           Object other$sourceMaterialInventoryId = other.getSourceMaterialInventoryId();
                                                                           if (this$sourceMaterialInventoryId == null
                                                                              ? other$sourceMaterialInventoryId == null
                                                                              : this$sourceMaterialInventoryId.equals(other$sourceMaterialInventoryId)) {
                                                                              Object this$sourceMaterielId = this.getSourceMaterielId();
                                                                              Object other$sourceMaterielId = other.getSourceMaterielId();
                                                                              if (this$sourceMaterielId == null
                                                                                 ? other$sourceMaterielId == null
                                                                                 : this$sourceMaterielId.equals(other$sourceMaterielId)) {
                                                                                 Object this$newMaterialId = this.getNewMaterialId();
                                                                                 Object other$newMaterialId = other.getNewMaterialId();
                                                                                 if (this$newMaterialId == null
                                                                                    ? other$newMaterialId == null
                                                                                    : this$newMaterialId.equals(other$newMaterialId)) {
                                                                                    Object this$serialNumber = this.getSerialNumber();
                                                                                    Object other$serialNumber = other.getSerialNumber();
                                                                                    if (this$serialNumber == null
                                                                                       ? other$serialNumber == null
                                                                                       : this$serialNumber.equals(other$serialNumber)) {
                                                                                       Object this$classifyName = this.getClassifyName();
                                                                                       Object other$classifyName = other.getClassifyName();
                                                                                       if (this$classifyName == null
                                                                                          ? other$classifyName == null
                                                                                          : this$classifyName.equals(other$classifyName)) {
                                                                                          Object this$specification = this.getSpecification();
                                                                                          Object other$specification = other.getSpecification();
                                                                                          if (this$specification == null
                                                                                             ? other$specification == null
                                                                                             : this$specification.equals(other$specification)) {
                                                                                             Object this$model = this.getModel();
                                                                                             Object other$model = other.getModel();
                                                                                             if (this$model == null
                                                                                                ? other$model == null
                                                                                                : this$model.equals(other$model)) {
                                                                                                Object this$quantity = this.getQuantity();
                                                                                                Object other$quantity = other.getQuantity();
                                                                                                if (this$quantity == null
                                                                                                   ? other$quantity == null
                                                                                                   : this$quantity.equals(other$quantity)) {
                                                                                                   Object this$length = this.getLength();
                                                                                                   Object other$length = other.getLength();
                                                                                                   if (this$length == null
                                                                                                      ? other$length == null
                                                                                                      : this$length.equals(other$length)) {
                                                                                                      Object this$width = this.getWidth();
                                                                                                      Object other$width = other.getWidth();
                                                                                                      if (this$width == null
                                                                                                         ? other$width == null
                                                                                                         : this$width.equals(other$width)) {
                                                                                                         Object this$thickness = this.getThickness();
                                                                                                         Object other$thickness = other.getThickness();
                                                                                                         if (this$thickness == null
                                                                                                            ? other$thickness == null
                                                                                                            : this$thickness.equals(other$thickness)) {
                                                                                                            Object this$theoryThickness = this.getTheoryThickness();
                                                                                                            Object other$theoryThickness = other.getTheoryThickness();
                                                                                                            if (this$theoryThickness == null
                                                                                                               ? other$theoryThickness == null
                                                                                                               : this$theoryThickness.equals(
                                                                                                                  other$theoryThickness
                                                                                                               )) {
                                                                                                               Object this$oneTheoryWeight = this.getOneTheoryWeight();
                                                                                                               Object other$oneTheoryWeight = other.getOneTheoryWeight();
                                                                                                               if (this$oneTheoryWeight == null
                                                                                                                  ? other$oneTheoryWeight == null
                                                                                                                  : this$oneTheoryWeight.equals(
                                                                                                                     other$oneTheoryWeight
                                                                                                                  )) {
                                                                                                                  Object this$brand = this.getBrand();
                                                                                                                  Object other$brand = other.getBrand();
                                                                                                                  if (this$brand == null
                                                                                                                     ? other$brand == null
                                                                                                                     : this$brand.equals(other$brand)) {
                                                                                                                     Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                                                                     Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                                                                     if (this$heatNoAndBatchNo == null
                                                                                                                        ? other$heatNoAndBatchNo == null
                                                                                                                        : this$heatNoAndBatchNo.equals(
                                                                                                                           other$heatNoAndBatchNo
                                                                                                                        )) {
                                                                                                                        Object this$color = this.getColor();
                                                                                                                        Object other$color = other.getColor();
                                                                                                                        if (this$color == null
                                                                                                                           ? other$color == null
                                                                                                                           : this$color.equals(other$color)) {
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
                                                                                                                                 Object this$unitNet = this.getUnitNet();
                                                                                                                                 Object other$unitNet = other.getUnitNet();
                                                                                                                                 if (this$unitNet == null
                                                                                                                                    ? other$unitNet == null
                                                                                                                                    : this$unitNet.equals(
                                                                                                                                       other$unitNet
                                                                                                                                    )) {
                                                                                                                                    Object this$mete = this.getMete();
                                                                                                                                    Object other$mete = other.getMete();
                                                                                                                                    if (this$mete == null
                                                                                                                                       ? other$mete == null
                                                                                                                                       : this$mete.equals(
                                                                                                                                          other$mete
                                                                                                                                       )) {
                                                                                                                                       Object this$taxRate = this.getTaxRate();
                                                                                                                                       Object other$taxRate = other.getTaxRate();
                                                                                                                                       if (this$taxRate == null
                                                                                                                                          ? other$taxRate
                                                                                                                                             == null
                                                                                                                                          : this$taxRate.equals(
                                                                                                                                             other$taxRate
                                                                                                                                          )) {
                                                                                                                                          Object this$outboundSn = this.getOutboundSn();
                                                                                                                                          Object other$outboundSn = other.getOutboundSn();
                                                                                                                                          if (this$outboundSn
                                                                                                                                                == null
                                                                                                                                             ? other$outboundSn
                                                                                                                                                == null
                                                                                                                                             : this$outboundSn.equals(
                                                                                                                                                other$outboundSn
                                                                                                                                             )) {
                                                                                                                                             Object this$weightedAverageSpec = this.getWeightedAverageSpec();
                                                                                                                                             Object other$weightedAverageSpec = other.getWeightedAverageSpec();
                                                                                                                                             if (this$weightedAverageSpec
                                                                                                                                                   == null
                                                                                                                                                ? other$weightedAverageSpec
                                                                                                                                                   == null
                                                                                                                                                : this$weightedAverageSpec.equals(
                                                                                                                                                   other$weightedAverageSpec
                                                                                                                                                )) {
                                                                                                                                                Object this$standardName = this.getStandardName();
                                                                                                                                                Object other$standardName = other.getStandardName();
                                                                                                                                                if (this$standardName
                                                                                                                                                      == null
                                                                                                                                                   ? other$standardName
                                                                                                                                                      == null
                                                                                                                                                   : this$standardName.equals(
                                                                                                                                                      other$standardName
                                                                                                                                                   )) {
                                                                                                                                                   Object this$sectionSteelWeight = this.getSectionSteelWeight();
                                                                                                                                                   Object other$sectionSteelWeight = other.getSectionSteelWeight();
                                                                                                                                                   if (this$sectionSteelWeight
                                                                                                                                                         == null
                                                                                                                                                      ? other$sectionSteelWeight
                                                                                                                                                         == null
                                                                                                                                                      : this$sectionSteelWeight.equals(
                                                                                                                                                         other$sectionSteelWeight
                                                                                                                                                      )) {
                                                                                                                                                      Object this$surplusSn = this.getSurplusSn();
                                                                                                                                                      Object other$surplusSn = other.getSurplusSn();
                                                                                                                                                      if (this$surplusSn
                                                                                                                                                            == null
                                                                                                                                                         ? other$surplusSn
                                                                                                                                                            == null
                                                                                                                                                         : this$surplusSn.equals(
                                                                                                                                                            other$surplusSn
                                                                                                                                                         )) {
                                                                                                                                                         Object this$unitPrice = this.getUnitPrice();
                                                                                                                                                         Object other$unitPrice = other.getUnitPrice();
                                                                                                                                                         if (this$unitPrice
                                                                                                                                                               == null
                                                                                                                                                            ? other$unitPrice
                                                                                                                                                               == null
                                                                                                                                                            : this$unitPrice.equals(
                                                                                                                                                               other$unitPrice
                                                                                                                                                            )) {
                                                                                                                                                            Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                                                                                                                                            Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                                                                                                                                            if (this$unitPriceExcludingVat
                                                                                                                                                                  == null
                                                                                                                                                               ? other$unitPriceExcludingVat
                                                                                                                                                                  == null
                                                                                                                                                               : this$unitPriceExcludingVat.equals(
                                                                                                                                                                  other$unitPriceExcludingVat
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$amount = this.getAmount();
                                                                                                                                                               Object other$amount = other.getAmount();
                                                                                                                                                               if (this$amount
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$amount
                                                                                                                                                                     == null
                                                                                                                                                                  : this$amount.equals(
                                                                                                                                                                     other$amount
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                                                                                                                  Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                                                                                                                  if (this$amountExcludingVat
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$amountExcludingVat
                                                                                                                                                                        == null
                                                                                                                                                                     : this$amountExcludingVat.equals(
                                                                                                                                                                        other$amountExcludingVat
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$inputVat = this.getInputVat();
                                                                                                                                                                     Object other$inputVat = other.getInputVat();
                                                                                                                                                                     if (this$inputVat
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$inputVat
                                                                                                                                                                           == null
                                                                                                                                                                        : this$inputVat.equals(
                                                                                                                                                                           other$inputVat
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MoveMaterialDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $moveMaterialId = this.getMoveMaterialId();
      result = result * 59 + ($moveMaterialId == null ? 43 : $moveMaterialId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $sourceWorkshopId = this.getSourceWorkshopId();
      result = result * 59 + ($sourceWorkshopId == null ? 43 : $sourceWorkshopId.hashCode());
      Object $directionWorkshopId = this.getDirectionWorkshopId();
      result = result * 59 + ($directionWorkshopId == null ? 43 : $directionWorkshopId.hashCode());
      Object $sourceWarehouseId = this.getSourceWarehouseId();
      result = result * 59 + ($sourceWarehouseId == null ? 43 : $sourceWarehouseId.hashCode());
      Object $directionWarehouseId = this.getDirectionWarehouseId();
      result = result * 59 + ($directionWarehouseId == null ? 43 : $directionWarehouseId.hashCode());
      Object $sourceFactoryId = this.getSourceFactoryId();
      result = result * 59 + ($sourceFactoryId == null ? 43 : $sourceFactoryId.hashCode());
      Object $directionFactoryId = this.getDirectionFactoryId();
      result = result * 59 + ($directionFactoryId == null ? 43 : $directionFactoryId.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $boolVirtual = this.getBoolVirtual();
      result = result * 59 + ($boolVirtual == null ? 43 : $boolVirtual.hashCode());
      Object $outboundId = this.getOutboundId();
      result = result * 59 + ($outboundId == null ? 43 : $outboundId.hashCode());
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $sourceMaterialInventoryId = this.getSourceMaterialInventoryId();
      result = result * 59 + ($sourceMaterialInventoryId == null ? 43 : $sourceMaterialInventoryId.hashCode());
      Object $sourceMaterielId = this.getSourceMaterielId();
      result = result * 59 + ($sourceMaterielId == null ? 43 : $sourceMaterielId.hashCode());
      Object $newMaterialId = this.getNewMaterialId();
      result = result * 59 + ($newMaterialId == null ? 43 : $newMaterialId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $model = this.getModel();
      result = result * 59 + ($model == null ? 43 : $model.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $oneTheoryWeight = this.getOneTheoryWeight();
      result = result * 59 + ($oneTheoryWeight == null ? 43 : $oneTheoryWeight.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $outboundSn = this.getOutboundSn();
      result = result * 59 + ($outboundSn == null ? 43 : $outboundSn.hashCode());
      Object $weightedAverageSpec = this.getWeightedAverageSpec();
      result = result * 59 + ($weightedAverageSpec == null ? 43 : $weightedAverageSpec.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $sectionSteelWeight = this.getSectionSteelWeight();
      result = result * 59 + ($sectionSteelWeight == null ? 43 : $sectionSteelWeight.hashCode());
      Object $surplusSn = this.getSurplusSn();
      result = result * 59 + ($surplusSn == null ? 43 : $surplusSn.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class MoveMaterialDetailBuilder {
      private Long id;
      private Long moveMaterialId;
      private String serialNumber;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private String specification;
      private String model;
      private Integer materialIsWhole;
      private Integer warehouseType;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Boolean boolPartyA;
      private BigDecimal quantity;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private BigDecimal oneTheoryWeight;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private String measureUnit;
      private Integer accountingPrecision;
      private String accountingUnit;
      private BigDecimal unitNet;
      private BigDecimal mete;
      private Long sourceWorkshopId;
      private Long directionWorkshopId;
      private Long sourceWarehouseId;
      private Long directionWarehouseId;
      private Long sourceFactoryId;
      private Long directionFactoryId;
      private Integer weightMeasurementMode;
      private BigDecimal taxRate;
      private Integer invoiceType;
      private String outboundSn;
      private String weightedAverageSpec;
      private Long standardId;
      private String standardName;
      private BigDecimal sectionSteelWeight;
      private String surplusSn;
      private Boolean boolVirtual;
      private Long outboundId;
      private Long inboundId;
      private Long sourceMaterialInventoryId;
      private Long sourceMaterielId;
      private Long newMaterialId;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private BigDecimal inputVat;
      private String remark;

      MoveMaterialDetailBuilder() {
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder moveMaterialId(final Long moveMaterialId) {
         this.moveMaterialId = moveMaterialId;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder model(final String model) {
         this.model = model;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder oneTheoryWeight(final BigDecimal oneTheoryWeight) {
         this.oneTheoryWeight = oneTheoryWeight;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder sourceWorkshopId(final Long sourceWorkshopId) {
         this.sourceWorkshopId = sourceWorkshopId;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder directionWorkshopId(final Long directionWorkshopId) {
         this.directionWorkshopId = directionWorkshopId;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder sourceWarehouseId(final Long sourceWarehouseId) {
         this.sourceWarehouseId = sourceWarehouseId;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder directionWarehouseId(final Long directionWarehouseId) {
         this.directionWarehouseId = directionWarehouseId;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder sourceFactoryId(final Long sourceFactoryId) {
         this.sourceFactoryId = sourceFactoryId;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder directionFactoryId(final Long directionFactoryId) {
         this.directionFactoryId = directionFactoryId;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder outboundSn(final String outboundSn) {
         this.outboundSn = outboundSn;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder weightedAverageSpec(final String weightedAverageSpec) {
         this.weightedAverageSpec = weightedAverageSpec;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder sectionSteelWeight(final BigDecimal sectionSteelWeight) {
         this.sectionSteelWeight = sectionSteelWeight;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder surplusSn(final String surplusSn) {
         this.surplusSn = surplusSn;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder boolVirtual(final Boolean boolVirtual) {
         this.boolVirtual = boolVirtual;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder outboundId(final Long outboundId) {
         this.outboundId = outboundId;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder inboundId(final Long inboundId) {
         this.inboundId = inboundId;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder sourceMaterialInventoryId(final Long sourceMaterialInventoryId) {
         this.sourceMaterialInventoryId = sourceMaterialInventoryId;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder sourceMaterielId(final Long sourceMaterielId) {
         this.sourceMaterielId = sourceMaterielId;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder newMaterialId(final Long newMaterialId) {
         this.newMaterialId = newMaterialId;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      public MoveMaterialDetail.MoveMaterialDetailBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MoveMaterialDetail build() {
         return new MoveMaterialDetail(
            this.id,
            this.moveMaterialId,
            this.serialNumber,
            this.basicClass,
            this.classifyId,
            this.classifyName,
            this.specification,
            this.model,
            this.materialIsWhole,
            this.warehouseType,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.boolPartyA,
            this.quantity,
            this.length,
            this.width,
            this.thickness,
            this.theoryThickness,
            this.oneTheoryWeight,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.measureUnit,
            this.accountingPrecision,
            this.accountingUnit,
            this.unitNet,
            this.mete,
            this.sourceWorkshopId,
            this.directionWorkshopId,
            this.sourceWarehouseId,
            this.directionWarehouseId,
            this.sourceFactoryId,
            this.directionFactoryId,
            this.weightMeasurementMode,
            this.taxRate,
            this.invoiceType,
            this.outboundSn,
            this.weightedAverageSpec,
            this.standardId,
            this.standardName,
            this.sectionSteelWeight,
            this.surplusSn,
            this.boolVirtual,
            this.outboundId,
            this.inboundId,
            this.sourceMaterialInventoryId,
            this.sourceMaterielId,
            this.newMaterialId,
            this.unitPrice,
            this.unitPriceExcludingVat,
            this.amount,
            this.amountExcludingVat,
            this.inputVat,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "MoveMaterialDetail.MoveMaterialDetailBuilder(id="
            + this.id
            + ", moveMaterialId="
            + this.moveMaterialId
            + ", serialNumber="
            + this.serialNumber
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", specification="
            + this.specification
            + ", model="
            + this.model
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", warehouseType="
            + this.warehouseType
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", boolPartyA="
            + this.boolPartyA
            + ", quantity="
            + this.quantity
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", theoryThickness="
            + this.theoryThickness
            + ", oneTheoryWeight="
            + this.oneTheoryWeight
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", measureUnit="
            + this.measureUnit
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", accountingUnit="
            + this.accountingUnit
            + ", unitNet="
            + this.unitNet
            + ", mete="
            + this.mete
            + ", sourceWorkshopId="
            + this.sourceWorkshopId
            + ", directionWorkshopId="
            + this.directionWorkshopId
            + ", sourceWarehouseId="
            + this.sourceWarehouseId
            + ", directionWarehouseId="
            + this.directionWarehouseId
            + ", sourceFactoryId="
            + this.sourceFactoryId
            + ", directionFactoryId="
            + this.directionFactoryId
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", taxRate="
            + this.taxRate
            + ", invoiceType="
            + this.invoiceType
            + ", outboundSn="
            + this.outboundSn
            + ", weightedAverageSpec="
            + this.weightedAverageSpec
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", sectionSteelWeight="
            + this.sectionSteelWeight
            + ", surplusSn="
            + this.surplusSn
            + ", boolVirtual="
            + this.boolVirtual
            + ", outboundId="
            + this.outboundId
            + ", inboundId="
            + this.inboundId
            + ", sourceMaterialInventoryId="
            + this.sourceMaterialInventoryId
            + ", sourceMaterielId="
            + this.sourceMaterielId
            + ", newMaterialId="
            + this.newMaterialId
            + ", unitPrice="
            + this.unitPrice
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", inputVat="
            + this.inputVat
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
