package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
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

@ApiModel(value = "StatisticsEndPeriod对象", description = "期初物料记录")
@Entity
@TableName("wms_statistics_end_period")
@Table(name = "wms_statistics_end_period")
public class StatisticsEndPeriod extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "statisticsId", value = "收发存ID", notes = "收发存ID")
   @JsonProperty("statisticsId")
   @JSONField(name = "statisticsId")
   @TableField("statistics_id")
   @Column(name = "statistics_id", columnDefinition = "bigint  COMMENT '收发存ID'", nullable = true)
   private Long statisticsId;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型", notes = "物料基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "科目名称", notes = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   @TableField("classify_name")
   @Column(name = "classify_name", columnDefinition = "varchar(255)  COMMENT '科目名称'", nullable = true)
   private String classifyName;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(128)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "materialIsWhole", value = "物料状态(1 整料, 余料)", notes = "物料状态(1 整料, 余料)")
   @JsonProperty("materialIsWhole")
   @JSONField(name = "materialIsWhole")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole", columnDefinition = "int  COMMENT '物料状态(1 整料, 余料)'", nullable = true)
   private Integer materialIsWhole;
   @ApiModelProperty(name = "warehouseType", value = "仓库类型[1 公共库,2 项目库]", notes = "仓库类型[1 公共库,2 项目库]")
   @JsonProperty("warehouseType")
   @JSONField(name = "warehouseType")
   @TableField("warehouse_type")
   @Column(name = "warehouse_type", columnDefinition = "int  COMMENT '仓库类型[1 公共库,2 项目库]'", nullable = true)
   private Integer warehouseType;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,0)  COMMENT '数量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "length", value = "长度", notes = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,0)  COMMENT '长度'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "宽度", notes = "宽度")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,0)  COMMENT '宽度'", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚度", notes = "厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,3)  COMMENT '厚度'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚度", notes = "理论厚度")
   @JsonProperty("theoryThickness")
   @JSONField(name = "theoryThickness")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness", columnDefinition = "decimal(32,8)  COMMENT '理论厚度'", nullable = true)
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(128)  COMMENT '品牌'", nullable = true)
   private String brand;
   @ApiModelProperty(name = "heatNoAndBatchNo", value = "炉批号", notes = "炉批号")
   @JsonProperty("heatNoAndBatchNo")
   @JSONField(name = "heatNoAndBatchNo")
   @TableField("heat_no_and_batch_no")
   @Column(name = "heat_no_and_batch_no", columnDefinition = "varchar(255)  COMMENT '炉批号'", nullable = true)
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "color", value = "颜色", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @TableField("color")
   @Column(name = "color", columnDefinition = "varchar(128)  COMMENT '颜色'", nullable = true)
   private String color;
   @ApiModelProperty(name = "mete", value = "核算量(在计量单位未设置时,数量=核算量)", notes = "核算量(在计量单位未设置时,数量=核算量)")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '核算量(在计量单位未设置时,数量=核算量)'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "unitNet", value = "单位净量(针对辅材,计量/核算量=单位净量)", notes = "单位净量(针对辅材,计量/核算量=单位净量)")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(32,8)  COMMENT '单位净量(针对辅材,计量/核算量=单位净量)'", nullable = true)
   private BigDecimal unitNet;
   @ApiModelProperty(name = "warehouseId", value = "仓库ID", notes = "仓库ID")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '仓库ID'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "weightMeasurementMode", value = "重量计量方式 [1理计 , 2 磅计 ,混合计]", notes = "重量计量方式 [1理计 , 2 磅计 ,混合计]")
   @JsonProperty("weightMeasurementMode")
   @JSONField(name = "weightMeasurementMode")
   @TableField("weight_measurement_mode")
   @Column(name = "weight_measurement_mode", columnDefinition = "int  COMMENT '重量计量方式 [1理计 , 2 磅计 ,混合计]'", nullable = true)
   private Integer weightMeasurementMode;
   @ApiModelProperty(name = "boolPartyA")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint  COMMENT ''", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "invoiceType", value = "收据类型", notes = "收据类型")
   @JsonProperty("invoiceType")
   @JSONField(name = "invoiceType")
   @TableField("invoice_type")
   @Column(name = "invoice_type", columnDefinition = "int  COMMENT '收据类型'", nullable = true)
   private Integer invoiceType;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(32,8)  COMMENT '税率'", nullable = true)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "standardId", value = "国标ID", notes = "国标ID")
   @JsonProperty("standardId")
   @JSONField(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id", columnDefinition = "bigint  COMMENT '国标ID'", nullable = true)
   private Long standardId;
   @ApiModelProperty(name = "standardName", value = "国标名称", notes = "国标名称")
   @JsonProperty("standardName")
   @JSONField(name = "standardName")
   @TableField("standard_name")
   @Column(name = "standard_name", columnDefinition = "varchar(255)  COMMENT '国标名称'", nullable = true)
   private String standardName;
   @ApiModelProperty(name = "weightedAveragePriceId", value = "引用加权价ID", notes = "引用加权价ID")
   @JsonProperty("weightedAveragePriceId")
   @JSONField(name = "weightedAveragePriceId")
   @TableField("weighted_average_price_id")
   @Column(name = "weighted_average_price_id", columnDefinition = "bigint  COMMENT '引用加权价ID'", nullable = true)
   private Long weightedAveragePriceId;
   @ApiModelProperty(name = "unitPrice", value = "含税单价", notes = "含税单价")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField(value = "unit_price", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "unit_price", columnDefinition = "decimal(32,12)  COMMENT '含税单价'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "unitPriceExcludingVat", value = "不含税单价", notes = "不含税单价")
   @JsonProperty("unitPriceExcludingVat")
   @JSONField(name = "unitPriceExcludingVat")
   @TableField(value = "unit_price_excluding_vat", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "unit_price_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '不含税单价'", nullable = true)
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty(name = "amount", value = "含税总价", notes = "含税总价")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField(value = "amount", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '含税总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税总价", notes = "不含税总价")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField(value = "amount_excluding_vat", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '不含税总价'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "inputVat", value = "进项税", notes = "进项税")
   @JsonProperty("inputVat")
   @JSONField(name = "inputVat")
   @TableField("input_vat")
   @Column(name = "input_vat", columnDefinition = "decimal(32,12)  COMMENT '进项税'", nullable = true)
   private BigDecimal inputVat;
   @ApiModelProperty(name = "materialInventoryId")
   @JsonProperty("materialInventoryId")
   @JSONField(name = "materialInventoryId")
   @TableField("material_inventory_id")
   @Column(name = "material_inventory_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long materialInventoryId;
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
   @ApiModelProperty(name = "workshopId")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '车间ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "unitPriceExcludingVatNoFreight", value = "不含税单价 不含运费", notes = "不含税单价 不含运费")
   @JsonProperty("unitPriceExcludingVatNoFreight")
   @JSONField(name = "unitPriceExcludingVatNoFreight")
   @TableField("unit_price_excluding_vat_no_freight")
   @Column(name = "unit_price_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税单价 不含运费'", nullable = true)
   private BigDecimal unitPriceExcludingVatNoFreight;
   @ApiModelProperty(name = "unitPriceNoFreight", value = "含税单价 不含运费", notes = "含税单价 不含运费")
   @JsonProperty("unitPriceNoFreight")
   @JSONField(name = "unitPriceNoFreight")
   @TableField("unit_price_no_freight")
   @Column(name = "unit_price_no_freight", columnDefinition = "decimal(32,12)  COMMENT '含税单价 不含运费'", nullable = true)
   private BigDecimal unitPriceNoFreight;
   @ApiModelProperty(name = "amountExcludingVatNoFreight", value = "不含税总价 不含运费", notes = "不含税总价 不含运费")
   @JsonProperty("amountExcludingVatNoFreight")
   @JSONField(name = "amountExcludingVatNoFreight")
   @TableField("amount_excluding_vat_no_freight")
   @Column(name = "amount_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税总价 不含运费'", nullable = true)
   private BigDecimal amountExcludingVatNoFreight;
   @ApiModelProperty(name = "amountNoFreight", value = "含税总价 不含运费", notes = "含税总价 不含运费")
   @JsonProperty("amountNoFreight")
   @JSONField(name = "amountNoFreight")
   @TableField("amount_no_freight")
   @Column(name = "amount_no_freight", columnDefinition = "decimal(32,12)  COMMENT '含税总价 不含运费'", nullable = true)
   private BigDecimal amountNoFreight;
   @ApiModelProperty(name = "inputVatNoFreight", value = "进项税 不含运费", notes = "进项税 不含运费")
   @JsonProperty("inputVatNoFreight")
   @JSONField(name = "inputVatNoFreight")
   @TableField("input_vat_no_freight")
   @Column(name = "input_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '进项税 不含运费'", nullable = true)
   private BigDecimal inputVatNoFreight;
   @ApiModelProperty(name = "WmsClosingTimeId")
   @JsonProperty("WmsClosingTimeId")
   @JSONField(name = "WmsClosingTimeId")
   @TableField("wms_closing_time_id")
   @Column(name = "wms_closing_time_id", columnDefinition = "bigint  COMMENT '关账id'", nullable = true)
   private Long WmsClosingTimeId;

   public static StatisticsEndPeriod.StatisticsEndPeriodBuilder builder() {
      return new StatisticsEndPeriod.StatisticsEndPeriodBuilder();
   }

   public StatisticsEndPeriod() {
   }

   public StatisticsEndPeriod(
      final Long id,
      final Long statisticsId,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final String specification,
      final Integer materialIsWhole,
      final Integer warehouseType,
      final Long projectId,
      final BigDecimal quantity,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final BigDecimal mete,
      final BigDecimal unitNet,
      final Long warehouseId,
      final Integer weightMeasurementMode,
      final Boolean boolPartyA,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final Long standardId,
      final String standardName,
      final Long weightedAveragePriceId,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final BigDecimal inputVat,
      final Long materialInventoryId,
      final Long monomerId,
      final Long areaId,
      final Long workshopId,
      final BigDecimal unitPriceExcludingVatNoFreight,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal amountExcludingVatNoFreight,
      final BigDecimal amountNoFreight,
      final BigDecimal inputVatNoFreight,
      final Long WmsClosingTimeId
   ) {
      this.id = id;
      this.statisticsId = statisticsId;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.specification = specification;
      this.materialIsWhole = materialIsWhole;
      this.warehouseType = warehouseType;
      this.projectId = projectId;
      this.quantity = quantity;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.mete = mete;
      this.unitNet = unitNet;
      this.warehouseId = warehouseId;
      this.weightMeasurementMode = weightMeasurementMode;
      this.boolPartyA = boolPartyA;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.standardId = standardId;
      this.standardName = standardName;
      this.weightedAveragePriceId = weightedAveragePriceId;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.inputVat = inputVat;
      this.materialInventoryId = materialInventoryId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.workshopId = workshopId;
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.amountNoFreight = amountNoFreight;
      this.inputVatNoFreight = inputVatNoFreight;
      this.WmsClosingTimeId = WmsClosingTimeId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getStatisticsId() {
      return this.statisticsId;
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

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public Long getProjectId() {
      return this.projectId;
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

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public Long getWeightedAveragePriceId() {
      return this.weightedAveragePriceId;
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

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public BigDecimal getUnitPriceExcludingVatNoFreight() {
      return this.unitPriceExcludingVatNoFreight;
   }

   public BigDecimal getUnitPriceNoFreight() {
      return this.unitPriceNoFreight;
   }

   public BigDecimal getAmountExcludingVatNoFreight() {
      return this.amountExcludingVatNoFreight;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public BigDecimal getInputVatNoFreight() {
      return this.inputVatNoFreight;
   }

   public Long getWmsClosingTimeId() {
      return this.WmsClosingTimeId;
   }

   @JsonProperty("id")
   public StatisticsEndPeriod setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("statisticsId")
   public StatisticsEndPeriod setStatisticsId(final Long statisticsId) {
      this.statisticsId = statisticsId;
      return this;
   }

   @JsonProperty("basicClass")
   public StatisticsEndPeriod setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public StatisticsEndPeriod setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("classifyName")
   public StatisticsEndPeriod setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("specification")
   public StatisticsEndPeriod setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("materialIsWhole")
   public StatisticsEndPeriod setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   @JsonProperty("warehouseType")
   public StatisticsEndPeriod setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   @JsonProperty("projectId")
   public StatisticsEndPeriod setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("quantity")
   public StatisticsEndPeriod setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("length")
   public StatisticsEndPeriod setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public StatisticsEndPeriod setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public StatisticsEndPeriod setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("theoryThickness")
   public StatisticsEndPeriod setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("brand")
   public StatisticsEndPeriod setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public StatisticsEndPeriod setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("color")
   public StatisticsEndPeriod setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("mete")
   public StatisticsEndPeriod setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("unitNet")
   public StatisticsEndPeriod setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("warehouseId")
   public StatisticsEndPeriod setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("weightMeasurementMode")
   public StatisticsEndPeriod setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
      return this;
   }

   @JsonProperty("boolPartyA")
   public StatisticsEndPeriod setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("invoiceType")
   public StatisticsEndPeriod setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("taxRate")
   public StatisticsEndPeriod setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("standardId")
   public StatisticsEndPeriod setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public StatisticsEndPeriod setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("weightedAveragePriceId")
   public StatisticsEndPeriod setWeightedAveragePriceId(final Long weightedAveragePriceId) {
      this.weightedAveragePriceId = weightedAveragePriceId;
      return this;
   }

   @JsonProperty("unitPrice")
   public StatisticsEndPeriod setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("unitPriceExcludingVat")
   public StatisticsEndPeriod setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   @JsonProperty("amount")
   public StatisticsEndPeriod setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public StatisticsEndPeriod setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("inputVat")
   public StatisticsEndPeriod setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   @JsonProperty("materialInventoryId")
   public StatisticsEndPeriod setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
      return this;
   }

   @JsonProperty("monomerId")
   public StatisticsEndPeriod setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public StatisticsEndPeriod setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("workshopId")
   public StatisticsEndPeriod setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("unitPriceExcludingVatNoFreight")
   public StatisticsEndPeriod setUnitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("unitPriceNoFreight")
   public StatisticsEndPeriod setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public StatisticsEndPeriod setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public StatisticsEndPeriod setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @JsonProperty("inputVatNoFreight")
   public StatisticsEndPeriod setInputVatNoFreight(final BigDecimal inputVatNoFreight) {
      this.inputVatNoFreight = inputVatNoFreight;
      return this;
   }

   @JsonProperty("WmsClosingTimeId")
   public StatisticsEndPeriod setWmsClosingTimeId(final Long WmsClosingTimeId) {
      this.WmsClosingTimeId = WmsClosingTimeId;
      return this;
   }

   @Override
   public String toString() {
      return "StatisticsEndPeriod(id="
         + this.getId()
         + ", statisticsId="
         + this.getStatisticsId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", specification="
         + this.getSpecification()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", projectId="
         + this.getProjectId()
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
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", mete="
         + this.getMete()
         + ", unitNet="
         + this.getUnitNet()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", weightedAveragePriceId="
         + this.getWeightedAveragePriceId()
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
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", unitPriceExcludingVatNoFreight="
         + this.getUnitPriceExcludingVatNoFreight()
         + ", unitPriceNoFreight="
         + this.getUnitPriceNoFreight()
         + ", amountExcludingVatNoFreight="
         + this.getAmountExcludingVatNoFreight()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", inputVatNoFreight="
         + this.getInputVatNoFreight()
         + ", WmsClosingTimeId="
         + this.getWmsClosingTimeId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StatisticsEndPeriod)) {
         return false;
      }

      StatisticsEndPeriod other = (StatisticsEndPeriod)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$statisticsId = this.getStatisticsId();
         Object other$statisticsId = other.getStatisticsId();
         if (this$statisticsId == null ? other$statisticsId == null : this$statisticsId.equals(other$statisticsId)) {
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
                           Object this$warehouseId = this.getWarehouseId();
                           Object other$warehouseId = other.getWarehouseId();
                           if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                              Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                              Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                              if (this$weightMeasurementMode == null
                                 ? other$weightMeasurementMode == null
                                 : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                 Object this$boolPartyA = this.getBoolPartyA();
                                 Object other$boolPartyA = other.getBoolPartyA();
                                 if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                                    Object this$invoiceType = this.getInvoiceType();
                                    Object other$invoiceType = other.getInvoiceType();
                                    if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                       Object this$standardId = this.getStandardId();
                                       Object other$standardId = other.getStandardId();
                                       if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                          Object this$weightedAveragePriceId = this.getWeightedAveragePriceId();
                                          Object other$weightedAveragePriceId = other.getWeightedAveragePriceId();
                                          if (this$weightedAveragePriceId == null
                                             ? other$weightedAveragePriceId == null
                                             : this$weightedAveragePriceId.equals(other$weightedAveragePriceId)) {
                                             Object this$materialInventoryId = this.getMaterialInventoryId();
                                             Object other$materialInventoryId = other.getMaterialInventoryId();
                                             if (this$materialInventoryId == null
                                                ? other$materialInventoryId == null
                                                : this$materialInventoryId.equals(other$materialInventoryId)) {
                                                Object this$monomerId = this.getMonomerId();
                                                Object other$monomerId = other.getMonomerId();
                                                if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                                   Object this$areaId = this.getAreaId();
                                                   Object other$areaId = other.getAreaId();
                                                   if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                                      Object this$workshopId = this.getWorkshopId();
                                                      Object other$workshopId = other.getWorkshopId();
                                                      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                                         Object this$WmsClosingTimeId = this.getWmsClosingTimeId();
                                                         Object other$WmsClosingTimeId = other.getWmsClosingTimeId();
                                                         if (this$WmsClosingTimeId == null
                                                            ? other$WmsClosingTimeId == null
                                                            : this$WmsClosingTimeId.equals(other$WmsClosingTimeId)) {
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
                                                                  Object this$quantity = this.getQuantity();
                                                                  Object other$quantity = other.getQuantity();
                                                                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                                     Object this$length = this.getLength();
                                                                     Object other$length = other.getLength();
                                                                     if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                        Object this$width = this.getWidth();
                                                                        Object other$width = other.getWidth();
                                                                        if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                                           Object this$thickness = this.getThickness();
                                                                           Object other$thickness = other.getThickness();
                                                                           if (this$thickness == null
                                                                              ? other$thickness == null
                                                                              : this$thickness.equals(other$thickness)) {
                                                                              Object this$theoryThickness = this.getTheoryThickness();
                                                                              Object other$theoryThickness = other.getTheoryThickness();
                                                                              if (this$theoryThickness == null
                                                                                 ? other$theoryThickness == null
                                                                                 : this$theoryThickness.equals(other$theoryThickness)) {
                                                                                 Object this$brand = this.getBrand();
                                                                                 Object other$brand = other.getBrand();
                                                                                 if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
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
                                                                                          Object this$mete = this.getMete();
                                                                                          Object other$mete = other.getMete();
                                                                                          if (this$mete == null
                                                                                             ? other$mete == null
                                                                                             : this$mete.equals(other$mete)) {
                                                                                             Object this$unitNet = this.getUnitNet();
                                                                                             Object other$unitNet = other.getUnitNet();
                                                                                             if (this$unitNet == null
                                                                                                ? other$unitNet == null
                                                                                                : this$unitNet.equals(other$unitNet)) {
                                                                                                Object this$taxRate = this.getTaxRate();
                                                                                                Object other$taxRate = other.getTaxRate();
                                                                                                if (this$taxRate == null
                                                                                                   ? other$taxRate == null
                                                                                                   : this$taxRate.equals(other$taxRate)) {
                                                                                                   Object this$standardName = this.getStandardName();
                                                                                                   Object other$standardName = other.getStandardName();
                                                                                                   if (this$standardName == null
                                                                                                      ? other$standardName == null
                                                                                                      : this$standardName.equals(other$standardName)) {
                                                                                                      Object this$unitPrice = this.getUnitPrice();
                                                                                                      Object other$unitPrice = other.getUnitPrice();
                                                                                                      if (this$unitPrice == null
                                                                                                         ? other$unitPrice == null
                                                                                                         : this$unitPrice.equals(other$unitPrice)) {
                                                                                                         Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                                                                                         Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                                                                                         if (this$unitPriceExcludingVat == null
                                                                                                            ? other$unitPriceExcludingVat == null
                                                                                                            : this$unitPriceExcludingVat.equals(
                                                                                                               other$unitPriceExcludingVat
                                                                                                            )) {
                                                                                                            Object this$amount = this.getAmount();
                                                                                                            Object other$amount = other.getAmount();
                                                                                                            if (this$amount == null
                                                                                                               ? other$amount == null
                                                                                                               : this$amount.equals(other$amount)) {
                                                                                                               Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                                                               Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                                                               if (this$amountExcludingVat == null
                                                                                                                  ? other$amountExcludingVat == null
                                                                                                                  : this$amountExcludingVat.equals(
                                                                                                                     other$amountExcludingVat
                                                                                                                  )) {
                                                                                                                  Object this$inputVat = this.getInputVat();
                                                                                                                  Object other$inputVat = other.getInputVat();
                                                                                                                  if (this$inputVat == null
                                                                                                                     ? other$inputVat == null
                                                                                                                     : this$inputVat.equals(other$inputVat)) {
                                                                                                                     Object this$unitPriceExcludingVatNoFreight = this.getUnitPriceExcludingVatNoFreight();
                                                                                                                     Object other$unitPriceExcludingVatNoFreight = other.getUnitPriceExcludingVatNoFreight();
                                                                                                                     if (this$unitPriceExcludingVatNoFreight
                                                                                                                           == null
                                                                                                                        ? other$unitPriceExcludingVatNoFreight
                                                                                                                           == null
                                                                                                                        : this$unitPriceExcludingVatNoFreight.equals(
                                                                                                                           other$unitPriceExcludingVatNoFreight
                                                                                                                        )) {
                                                                                                                        Object this$unitPriceNoFreight = this.getUnitPriceNoFreight();
                                                                                                                        Object other$unitPriceNoFreight = other.getUnitPriceNoFreight();
                                                                                                                        if (this$unitPriceNoFreight == null
                                                                                                                           ? other$unitPriceNoFreight == null
                                                                                                                           : this$unitPriceNoFreight.equals(
                                                                                                                              other$unitPriceNoFreight
                                                                                                                           )) {
                                                                                                                           Object this$amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
                                                                                                                           Object other$amountExcludingVatNoFreight = other.getAmountExcludingVatNoFreight();
                                                                                                                           if (this$amountExcludingVatNoFreight
                                                                                                                                 == null
                                                                                                                              ? other$amountExcludingVatNoFreight
                                                                                                                                 == null
                                                                                                                              : this$amountExcludingVatNoFreight.equals(
                                                                                                                                 other$amountExcludingVatNoFreight
                                                                                                                              )) {
                                                                                                                              Object this$amountNoFreight = this.getAmountNoFreight();
                                                                                                                              Object other$amountNoFreight = other.getAmountNoFreight();
                                                                                                                              if (this$amountNoFreight == null
                                                                                                                                 ? other$amountNoFreight
                                                                                                                                    == null
                                                                                                                                 : this$amountNoFreight.equals(
                                                                                                                                    other$amountNoFreight
                                                                                                                                 )) {
                                                                                                                                 Object this$inputVatNoFreight = this.getInputVatNoFreight();
                                                                                                                                 Object other$inputVatNoFreight = other.getInputVatNoFreight();
                                                                                                                                 return this$inputVatNoFreight
                                                                                                                                       == null
                                                                                                                                    ? other$inputVatNoFreight
                                                                                                                                       == null
                                                                                                                                    : this$inputVatNoFreight.equals(
                                                                                                                                       other$inputVatNoFreight
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
      return other instanceof StatisticsEndPeriod;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $statisticsId = this.getStatisticsId();
      result = result * 59 + ($statisticsId == null ? 43 : $statisticsId.hashCode());
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
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $weightedAveragePriceId = this.getWeightedAveragePriceId();
      result = result * 59 + ($weightedAveragePriceId == null ? 43 : $weightedAveragePriceId.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $WmsClosingTimeId = this.getWmsClosingTimeId();
      result = result * 59 + ($WmsClosingTimeId == null ? 43 : $WmsClosingTimeId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
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
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
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
      Object $unitPriceExcludingVatNoFreight = this.getUnitPriceExcludingVatNoFreight();
      result = result * 59 + ($unitPriceExcludingVatNoFreight == null ? 43 : $unitPriceExcludingVatNoFreight.hashCode());
      Object $unitPriceNoFreight = this.getUnitPriceNoFreight();
      result = result * 59 + ($unitPriceNoFreight == null ? 43 : $unitPriceNoFreight.hashCode());
      Object $amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
      result = result * 59 + ($amountExcludingVatNoFreight == null ? 43 : $amountExcludingVatNoFreight.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $inputVatNoFreight = this.getInputVatNoFreight();
      return result * 59 + ($inputVatNoFreight == null ? 43 : $inputVatNoFreight.hashCode());
   }

   public static class StatisticsEndPeriodBuilder {
      private Long id;
      private Long statisticsId;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private String specification;
      private Integer materialIsWhole;
      private Integer warehouseType;
      private Long projectId;
      private BigDecimal quantity;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private BigDecimal mete;
      private BigDecimal unitNet;
      private Long warehouseId;
      private Integer weightMeasurementMode;
      private Boolean boolPartyA;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private Long standardId;
      private String standardName;
      private Long weightedAveragePriceId;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private BigDecimal inputVat;
      private Long materialInventoryId;
      private Long monomerId;
      private Long areaId;
      private Long workshopId;
      private BigDecimal unitPriceExcludingVatNoFreight;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal amountExcludingVatNoFreight;
      private BigDecimal amountNoFreight;
      private BigDecimal inputVatNoFreight;
      private Long WmsClosingTimeId;

      StatisticsEndPeriodBuilder() {
      }

      @JsonProperty("id")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("statisticsId")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder statisticsId(final Long statisticsId) {
         this.statisticsId = statisticsId;
         return this;
      }

      @JsonProperty("basicClass")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("specification")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("warehouseType")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      @JsonProperty("projectId")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("quantity")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("length")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("theoryThickness")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("brand")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("color")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("mete")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("unitNet")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("warehouseId")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("weightMeasurementMode")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      @JsonProperty("boolPartyA")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("invoiceType")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("taxRate")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("standardId")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("weightedAveragePriceId")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder weightedAveragePriceId(final Long weightedAveragePriceId) {
         this.weightedAveragePriceId = weightedAveragePriceId;
         return this;
      }

      @JsonProperty("unitPrice")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("unitPriceExcludingVat")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      @JsonProperty("amount")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("inputVat")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      @JsonProperty("materialInventoryId")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      @JsonProperty("monomerId")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("workshopId")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("unitPriceExcludingVatNoFreight")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder unitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
         this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("unitPriceNoFreight")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      @JsonProperty("amountExcludingVatNoFreight")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("amountNoFreight")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      @JsonProperty("inputVatNoFreight")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder inputVatNoFreight(final BigDecimal inputVatNoFreight) {
         this.inputVatNoFreight = inputVatNoFreight;
         return this;
      }

      @JsonProperty("WmsClosingTimeId")
      public StatisticsEndPeriod.StatisticsEndPeriodBuilder WmsClosingTimeId(final Long WmsClosingTimeId) {
         this.WmsClosingTimeId = WmsClosingTimeId;
         return this;
      }

      public StatisticsEndPeriod build() {
         return new StatisticsEndPeriod(
            this.id,
            this.statisticsId,
            this.basicClass,
            this.classifyId,
            this.classifyName,
            this.specification,
            this.materialIsWhole,
            this.warehouseType,
            this.projectId,
            this.quantity,
            this.length,
            this.width,
            this.thickness,
            this.theoryThickness,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.mete,
            this.unitNet,
            this.warehouseId,
            this.weightMeasurementMode,
            this.boolPartyA,
            this.invoiceType,
            this.taxRate,
            this.standardId,
            this.standardName,
            this.weightedAveragePriceId,
            this.unitPrice,
            this.unitPriceExcludingVat,
            this.amount,
            this.amountExcludingVat,
            this.inputVat,
            this.materialInventoryId,
            this.monomerId,
            this.areaId,
            this.workshopId,
            this.unitPriceExcludingVatNoFreight,
            this.unitPriceNoFreight,
            this.amountExcludingVatNoFreight,
            this.amountNoFreight,
            this.inputVatNoFreight,
            this.WmsClosingTimeId
         );
      }

      @Override
      public String toString() {
         return "StatisticsEndPeriod.StatisticsEndPeriodBuilder(id="
            + this.id
            + ", statisticsId="
            + this.statisticsId
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", specification="
            + this.specification
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", warehouseType="
            + this.warehouseType
            + ", projectId="
            + this.projectId
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
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", mete="
            + this.mete
            + ", unitNet="
            + this.unitNet
            + ", warehouseId="
            + this.warehouseId
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", boolPartyA="
            + this.boolPartyA
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", weightedAveragePriceId="
            + this.weightedAveragePriceId
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
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", workshopId="
            + this.workshopId
            + ", unitPriceExcludingVatNoFreight="
            + this.unitPriceExcludingVatNoFreight
            + ", unitPriceNoFreight="
            + this.unitPriceNoFreight
            + ", amountExcludingVatNoFreight="
            + this.amountExcludingVatNoFreight
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", inputVatNoFreight="
            + this.inputVatNoFreight
            + ", WmsClosingTimeId="
            + this.WmsClosingTimeId
            + ")";
      }
   }
}
