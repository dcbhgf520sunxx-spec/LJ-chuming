package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

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

@ApiModel(value = "StatisticsInbound对象", description = "入库统计,入库+调拨入-退货")
@Entity
@TableName("wms_statistics_inbound")
@Table(name = "wms_statistics_inbound")
public class StatisticsInbound extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "materialInventoryId", value = "物料仓ID", notes = "物料仓ID")
   @JsonProperty("materialInventoryId")
   @JSONField(name = "materialInventoryId")
   @TableField("material_inventory_id")
   @Column(name = "material_inventory_id", columnDefinition = "bigint  COMMENT '物料仓ID'", nullable = true)
   private Long materialInventoryId;
   @ApiModelProperty(name = "statisticsId", value = "收发存ID", notes = "收发存ID")
   @JsonProperty("statisticsId")
   @JSONField(name = "statisticsId")
   @TableField("statistics_id")
   @Column(name = "statistics_id", columnDefinition = "bigint  COMMENT '收发存ID'", nullable = true)
   private Long statisticsId;
   @ApiModelProperty(name = "basicClass", value = "基础分类", notes = "基础分类")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '基础分类'", nullable = true)
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
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "materialIsWhole", value = "物料状态", notes = "物料状态")
   @JsonProperty("materialIsWhole")
   @JSONField(name = "materialIsWhole")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole", columnDefinition = "int  COMMENT '物料状态'", nullable = true)
   private Integer materialIsWhole;
   @ApiModelProperty(name = "warehouseType", value = "仓库类型", notes = "仓库类型")
   @JsonProperty("warehouseType")
   @JSONField(name = "warehouseType")
   @TableField("warehouse_type")
   @Column(name = "warehouse_type", columnDefinition = "int  COMMENT '仓库类型'", nullable = true)
   private Integer warehouseType;
   @ApiModelProperty(name = "type", value = "物料类型", notes = "物料类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int  COMMENT '物料类型'", nullable = true)
   private Integer type;
   @ApiModelProperty(name = "boolPartyA", value = "是否为甲供物料", notes = "是否为甲供物料")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否为甲供物料'", nullable = true)
   private Boolean boolPartyA;
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
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '数量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "unitNet", value = "单位净量", notes = "单位净量")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(32,8)  COMMENT '单位净量'", nullable = true)
   private BigDecimal unitNet;
   @ApiModelProperty(name = "length", value = "长", notes = "长")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,8)  COMMENT '长'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "宽", notes = "宽")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,8)  COMMENT '宽'", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚", notes = "厚")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8)  COMMENT '厚'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚", notes = "理论厚")
   @JsonProperty("theoryThickness")
   @JSONField(name = "theoryThickness")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness", columnDefinition = "decimal(32,8)  COMMENT '理论厚'", nullable = true)
   private BigDecimal theoryThickness;
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
   @ApiModelProperty(name = "heatNoAndBatchNo", value = "炉批号", notes = "炉批号")
   @JsonProperty("heatNoAndBatchNo")
   @JSONField(name = "heatNoAndBatchNo")
   @TableField("heat_no_and_batch_no")
   @Column(name = "heat_no_and_batch_no", columnDefinition = "varchar(255)  COMMENT '炉批号'", nullable = true)
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "warehouseId", value = "仓库", notes = "仓库")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '仓库'", nullable = true)
   private Long warehouseId;
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
   @ApiModelProperty(name = "unitPriceExcludingVat", value = "不含税单价", notes = "不含税单价")
   @JsonProperty("unitPriceExcludingVat")
   @JSONField(name = "unitPriceExcludingVat")
   @TableField("unit_price_excluding_vat")
   @Column(name = "unit_price_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '不含税单价'", nullable = true)
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty(name = "unitPrice", value = "含税单价", notes = "含税单价")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,12)  COMMENT '含税单价'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税总价", notes = "不含税总价")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_vat")
   @Column(name = "amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '不含税总价'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "amount", value = "含税总价", notes = "含税总价")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '含税总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "inputVat", value = "进项税", notes = "进项税")
   @JsonProperty("inputVat")
   @JSONField(name = "inputVat")
   @TableField("input_vat")
   @Column(name = "input_vat", columnDefinition = "decimal(32,12)  COMMENT '进项税'", nullable = true)
   private BigDecimal inputVat;
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
   @ApiModelProperty(name = "receiptType", value = "单据类型 [ ReceiptTypeEnum ]", notes = "单据类型 [ ReceiptTypeEnum ]")
   @JsonProperty("receiptType")
   @JSONField(name = "receiptType")
   @TableField("receipt_type")
   @Column(name = "receipt_type", columnDefinition = "int  COMMENT '单据类型 [ ReceiptTypeEnum ]'", nullable = true)
   private Integer receiptType;
   @ApiModelProperty(name = "receiptId")
   @JsonProperty("receiptId")
   @JSONField(name = "receiptId")
   @TableField("receipt_id")
   @Column(name = "receipt_id", columnDefinition = "bigint  COMMENT '单据ID'", nullable = true)
   private Long receiptId;
   @ApiModelProperty(name = "receiptSerialNumber")
   @JsonProperty("receiptSerialNumber")
   @JSONField(name = "receiptSerialNumber")
   @TableField("receipt_serial_number")
   @Column(name = "receipt_serial_number", columnDefinition = "varchar(255)  COMMENT '单据编号'", nullable = true)
   private String receiptSerialNumber;
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
   @ApiModelProperty(name = "realTime", value = "实际时间")
   @JsonProperty("realTime")
   @JSONField(name = "realTime")
   @TableField("real_time")
   @Column(name = "real_time")
   private LocalDateTime realTime;

   public static StatisticsInbound.StatisticsInboundBuilder builder() {
      return new StatisticsInbound.StatisticsInboundBuilder();
   }

   public StatisticsInbound() {
   }

   public StatisticsInbound(
      final Long id,
      final Long materialInventoryId,
      final Long statisticsId,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final String specification,
      final Integer materialIsWhole,
      final Integer warehouseType,
      final Integer type,
      final Boolean boolPartyA,
      final Long projectId,
      final BigDecimal quantity,
      final BigDecimal mete,
      final BigDecimal unitNet,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final String brand,
      final String color,
      final String heatNoAndBatchNo,
      final Long warehouseId,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal unitPrice,
      final BigDecimal amountExcludingVat,
      final BigDecimal amount,
      final BigDecimal inputVat,
      final Long standardId,
      final String standardName,
      final Integer receiptType,
      final Long receiptId,
      final String receiptSerialNumber,
      final Long monomerId,
      final Long areaId,
      final Long workshopId,
      final BigDecimal unitPriceExcludingVatNoFreight,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal amountExcludingVatNoFreight,
      final BigDecimal amountNoFreight,
      final BigDecimal inputVatNoFreight,
      final LocalDateTime realTime
   ) {
      this.id = id;
      this.materialInventoryId = materialInventoryId;
      this.statisticsId = statisticsId;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.specification = specification;
      this.materialIsWhole = materialIsWhole;
      this.warehouseType = warehouseType;
      this.type = type;
      this.boolPartyA = boolPartyA;
      this.projectId = projectId;
      this.quantity = quantity;
      this.mete = mete;
      this.unitNet = unitNet;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.brand = brand;
      this.color = color;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.warehouseId = warehouseId;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.unitPrice = unitPrice;
      this.amountExcludingVat = amountExcludingVat;
      this.amount = amount;
      this.inputVat = inputVat;
      this.standardId = standardId;
      this.standardName = standardName;
      this.receiptType = receiptType;
      this.receiptId = receiptId;
      this.receiptSerialNumber = receiptSerialNumber;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.workshopId = workshopId;
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.amountNoFreight = amountNoFreight;
      this.inputVatNoFreight = inputVatNoFreight;
      this.realTime = realTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
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

   public Integer getType() {
      return this.type;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
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

   public String getColor() {
      return this.color;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
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

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public Integer getReceiptType() {
      return this.receiptType;
   }

   public Long getReceiptId() {
      return this.receiptId;
   }

   public String getReceiptSerialNumber() {
      return this.receiptSerialNumber;
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

   public LocalDateTime getRealTime() {
      return this.realTime;
   }

   @JsonProperty("id")
   public StatisticsInbound setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("materialInventoryId")
   public StatisticsInbound setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
      return this;
   }

   @JsonProperty("statisticsId")
   public StatisticsInbound setStatisticsId(final Long statisticsId) {
      this.statisticsId = statisticsId;
      return this;
   }

   @JsonProperty("basicClass")
   public StatisticsInbound setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public StatisticsInbound setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("classifyName")
   public StatisticsInbound setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("specification")
   public StatisticsInbound setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("materialIsWhole")
   public StatisticsInbound setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   @JsonProperty("warehouseType")
   public StatisticsInbound setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   @JsonProperty("type")
   public StatisticsInbound setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("boolPartyA")
   public StatisticsInbound setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("projectId")
   public StatisticsInbound setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("quantity")
   public StatisticsInbound setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("mete")
   public StatisticsInbound setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("unitNet")
   public StatisticsInbound setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("length")
   public StatisticsInbound setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public StatisticsInbound setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public StatisticsInbound setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("theoryThickness")
   public StatisticsInbound setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("brand")
   public StatisticsInbound setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("color")
   public StatisticsInbound setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public StatisticsInbound setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("warehouseId")
   public StatisticsInbound setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("invoiceType")
   public StatisticsInbound setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("taxRate")
   public StatisticsInbound setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("unitPriceExcludingVat")
   public StatisticsInbound setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   @JsonProperty("unitPrice")
   public StatisticsInbound setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public StatisticsInbound setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("amount")
   public StatisticsInbound setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("inputVat")
   public StatisticsInbound setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   @JsonProperty("standardId")
   public StatisticsInbound setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public StatisticsInbound setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("receiptType")
   public StatisticsInbound setReceiptType(final Integer receiptType) {
      this.receiptType = receiptType;
      return this;
   }

   @JsonProperty("receiptId")
   public StatisticsInbound setReceiptId(final Long receiptId) {
      this.receiptId = receiptId;
      return this;
   }

   @JsonProperty("receiptSerialNumber")
   public StatisticsInbound setReceiptSerialNumber(final String receiptSerialNumber) {
      this.receiptSerialNumber = receiptSerialNumber;
      return this;
   }

   @JsonProperty("monomerId")
   public StatisticsInbound setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public StatisticsInbound setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("workshopId")
   public StatisticsInbound setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("unitPriceExcludingVatNoFreight")
   public StatisticsInbound setUnitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("unitPriceNoFreight")
   public StatisticsInbound setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public StatisticsInbound setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public StatisticsInbound setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @JsonProperty("inputVatNoFreight")
   public StatisticsInbound setInputVatNoFreight(final BigDecimal inputVatNoFreight) {
      this.inputVatNoFreight = inputVatNoFreight;
      return this;
   }

   @JsonProperty("realTime")
   public StatisticsInbound setRealTime(final LocalDateTime realTime) {
      this.realTime = realTime;
      return this;
   }

   @Override
   public String toString() {
      return "StatisticsInbound(id="
         + this.getId()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
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
         + ", type="
         + this.getType()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", projectId="
         + this.getProjectId()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", unitNet="
         + this.getUnitNet()
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
         + ", color="
         + this.getColor()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", amount="
         + this.getAmount()
         + ", inputVat="
         + this.getInputVat()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", receiptType="
         + this.getReceiptType()
         + ", receiptId="
         + this.getReceiptId()
         + ", receiptSerialNumber="
         + this.getReceiptSerialNumber()
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
         + ", realTime="
         + this.getRealTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StatisticsInbound)) {
         return false;
      }

      StatisticsInbound other = (StatisticsInbound)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$materialInventoryId = this.getMaterialInventoryId();
         Object other$materialInventoryId = other.getMaterialInventoryId();
         if (this$materialInventoryId == null ? other$materialInventoryId == null : this$materialInventoryId.equals(other$materialInventoryId)) {
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
                           Object this$type = this.getType();
                           Object other$type = other.getType();
                           if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                              Object this$boolPartyA = this.getBoolPartyA();
                              Object other$boolPartyA = other.getBoolPartyA();
                              if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                                 Object this$projectId = this.getProjectId();
                                 Object other$projectId = other.getProjectId();
                                 if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                                    Object this$warehouseId = this.getWarehouseId();
                                    Object other$warehouseId = other.getWarehouseId();
                                    if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                       Object this$invoiceType = this.getInvoiceType();
                                       Object other$invoiceType = other.getInvoiceType();
                                       if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                          Object this$standardId = this.getStandardId();
                                          Object other$standardId = other.getStandardId();
                                          if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                             Object this$receiptType = this.getReceiptType();
                                             Object other$receiptType = other.getReceiptType();
                                             if (this$receiptType == null ? other$receiptType == null : this$receiptType.equals(other$receiptType)) {
                                                Object this$receiptId = this.getReceiptId();
                                                Object other$receiptId = other.getReceiptId();
                                                if (this$receiptId == null ? other$receiptId == null : this$receiptId.equals(other$receiptId)) {
                                                   Object this$monomerId = this.getMonomerId();
                                                   Object other$monomerId = other.getMonomerId();
                                                   if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                                      Object this$areaId = this.getAreaId();
                                                      Object other$areaId = other.getAreaId();
                                                      if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                                         Object this$workshopId = this.getWorkshopId();
                                                         Object other$workshopId = other.getWorkshopId();
                                                         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
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
                                                                     Object this$mete = this.getMete();
                                                                     Object other$mete = other.getMete();
                                                                     if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                        Object this$unitNet = this.getUnitNet();
                                                                        Object other$unitNet = other.getUnitNet();
                                                                        if (this$unitNet == null ? other$unitNet == null : this$unitNet.equals(other$unitNet)) {
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
                                                                                       if (this$brand == null
                                                                                          ? other$brand == null
                                                                                          : this$brand.equals(other$brand)) {
                                                                                          Object this$color = this.getColor();
                                                                                          Object other$color = other.getColor();
                                                                                          if (this$color == null
                                                                                             ? other$color == null
                                                                                             : this$color.equals(other$color)) {
                                                                                             Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                                             Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                                             if (this$heatNoAndBatchNo == null
                                                                                                ? other$heatNoAndBatchNo == null
                                                                                                : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                                                Object this$taxRate = this.getTaxRate();
                                                                                                Object other$taxRate = other.getTaxRate();
                                                                                                if (this$taxRate == null
                                                                                                   ? other$taxRate == null
                                                                                                   : this$taxRate.equals(other$taxRate)) {
                                                                                                   Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                                                                                   Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                                                                                   if (this$unitPriceExcludingVat == null
                                                                                                      ? other$unitPriceExcludingVat == null
                                                                                                      : this$unitPriceExcludingVat.equals(
                                                                                                         other$unitPriceExcludingVat
                                                                                                      )) {
                                                                                                      Object this$unitPrice = this.getUnitPrice();
                                                                                                      Object other$unitPrice = other.getUnitPrice();
                                                                                                      if (this$unitPrice == null
                                                                                                         ? other$unitPrice == null
                                                                                                         : this$unitPrice.equals(other$unitPrice)) {
                                                                                                         Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                                                         Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                                                         if (this$amountExcludingVat == null
                                                                                                            ? other$amountExcludingVat == null
                                                                                                            : this$amountExcludingVat.equals(
                                                                                                               other$amountExcludingVat
                                                                                                            )) {
                                                                                                            Object this$amount = this.getAmount();
                                                                                                            Object other$amount = other.getAmount();
                                                                                                            if (this$amount == null
                                                                                                               ? other$amount == null
                                                                                                               : this$amount.equals(other$amount)) {
                                                                                                               Object this$inputVat = this.getInputVat();
                                                                                                               Object other$inputVat = other.getInputVat();
                                                                                                               if (this$inputVat == null
                                                                                                                  ? other$inputVat == null
                                                                                                                  : this$inputVat.equals(other$inputVat)) {
                                                                                                                  Object this$standardName = this.getStandardName();
                                                                                                                  Object other$standardName = other.getStandardName();
                                                                                                                  if (this$standardName == null
                                                                                                                     ? other$standardName == null
                                                                                                                     : this$standardName.equals(
                                                                                                                        other$standardName
                                                                                                                     )) {
                                                                                                                     Object this$receiptSerialNumber = this.getReceiptSerialNumber();
                                                                                                                     Object other$receiptSerialNumber = other.getReceiptSerialNumber();
                                                                                                                     if (this$receiptSerialNumber == null
                                                                                                                        ? other$receiptSerialNumber == null
                                                                                                                        : this$receiptSerialNumber.equals(
                                                                                                                           other$receiptSerialNumber
                                                                                                                        )) {
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
                                                                                                                              ? other$unitPriceNoFreight
                                                                                                                                 == null
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
                                                                                                                                 if (this$amountNoFreight
                                                                                                                                       == null
                                                                                                                                    ? other$amountNoFreight
                                                                                                                                       == null
                                                                                                                                    : this$amountNoFreight.equals(
                                                                                                                                       other$amountNoFreight
                                                                                                                                    )) {
                                                                                                                                    Object this$inputVatNoFreight = this.getInputVatNoFreight();
                                                                                                                                    Object other$inputVatNoFreight = other.getInputVatNoFreight();
                                                                                                                                    if (this$inputVatNoFreight
                                                                                                                                          == null
                                                                                                                                       ? other$inputVatNoFreight
                                                                                                                                          == null
                                                                                                                                       : this$inputVatNoFreight.equals(
                                                                                                                                          other$inputVatNoFreight
                                                                                                                                       )) {
                                                                                                                                       Object this$realTime = this.getRealTime();
                                                                                                                                       Object other$realTime = other.getRealTime();
                                                                                                                                       return this$realTime
                                                                                                                                             == null
                                                                                                                                          ? other$realTime
                                                                                                                                             == null
                                                                                                                                          : this$realTime.equals(
                                                                                                                                             other$realTime
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof StatisticsInbound;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
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
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $receiptType = this.getReceiptType();
      result = result * 59 + ($receiptType == null ? 43 : $receiptType.hashCode());
      Object $receiptId = this.getReceiptId();
      result = result * 59 + ($receiptId == null ? 43 : $receiptId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
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
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $receiptSerialNumber = this.getReceiptSerialNumber();
      result = result * 59 + ($receiptSerialNumber == null ? 43 : $receiptSerialNumber.hashCode());
      Object $unitPriceExcludingVatNoFreight = this.getUnitPriceExcludingVatNoFreight();
      result = result * 59 + ($unitPriceExcludingVatNoFreight == null ? 43 : $unitPriceExcludingVatNoFreight.hashCode());
      Object $unitPriceNoFreight = this.getUnitPriceNoFreight();
      result = result * 59 + ($unitPriceNoFreight == null ? 43 : $unitPriceNoFreight.hashCode());
      Object $amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
      result = result * 59 + ($amountExcludingVatNoFreight == null ? 43 : $amountExcludingVatNoFreight.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $inputVatNoFreight = this.getInputVatNoFreight();
      result = result * 59 + ($inputVatNoFreight == null ? 43 : $inputVatNoFreight.hashCode());
      Object $realTime = this.getRealTime();
      return result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
   }

   public static class StatisticsInboundBuilder {
      private Long id;
      private Long materialInventoryId;
      private Long statisticsId;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private String specification;
      private Integer materialIsWhole;
      private Integer warehouseType;
      private Integer type;
      private Boolean boolPartyA;
      private Long projectId;
      private BigDecimal quantity;
      private BigDecimal mete;
      private BigDecimal unitNet;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private String brand;
      private String color;
      private String heatNoAndBatchNo;
      private Long warehouseId;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal unitPrice;
      private BigDecimal amountExcludingVat;
      private BigDecimal amount;
      private BigDecimal inputVat;
      private Long standardId;
      private String standardName;
      private Integer receiptType;
      private Long receiptId;
      private String receiptSerialNumber;
      private Long monomerId;
      private Long areaId;
      private Long workshopId;
      private BigDecimal unitPriceExcludingVatNoFreight;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal amountExcludingVatNoFreight;
      private BigDecimal amountNoFreight;
      private BigDecimal inputVatNoFreight;
      private LocalDateTime realTime;

      StatisticsInboundBuilder() {
      }

      @JsonProperty("id")
      public StatisticsInbound.StatisticsInboundBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("materialInventoryId")
      public StatisticsInbound.StatisticsInboundBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      @JsonProperty("statisticsId")
      public StatisticsInbound.StatisticsInboundBuilder statisticsId(final Long statisticsId) {
         this.statisticsId = statisticsId;
         return this;
      }

      @JsonProperty("basicClass")
      public StatisticsInbound.StatisticsInboundBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public StatisticsInbound.StatisticsInboundBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public StatisticsInbound.StatisticsInboundBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("specification")
      public StatisticsInbound.StatisticsInboundBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public StatisticsInbound.StatisticsInboundBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("warehouseType")
      public StatisticsInbound.StatisticsInboundBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      @JsonProperty("type")
      public StatisticsInbound.StatisticsInboundBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("boolPartyA")
      public StatisticsInbound.StatisticsInboundBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("projectId")
      public StatisticsInbound.StatisticsInboundBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("quantity")
      public StatisticsInbound.StatisticsInboundBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public StatisticsInbound.StatisticsInboundBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("unitNet")
      public StatisticsInbound.StatisticsInboundBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("length")
      public StatisticsInbound.StatisticsInboundBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public StatisticsInbound.StatisticsInboundBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public StatisticsInbound.StatisticsInboundBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("theoryThickness")
      public StatisticsInbound.StatisticsInboundBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("brand")
      public StatisticsInbound.StatisticsInboundBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("color")
      public StatisticsInbound.StatisticsInboundBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public StatisticsInbound.StatisticsInboundBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("warehouseId")
      public StatisticsInbound.StatisticsInboundBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("invoiceType")
      public StatisticsInbound.StatisticsInboundBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("taxRate")
      public StatisticsInbound.StatisticsInboundBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("unitPriceExcludingVat")
      public StatisticsInbound.StatisticsInboundBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      @JsonProperty("unitPrice")
      public StatisticsInbound.StatisticsInboundBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public StatisticsInbound.StatisticsInboundBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("amount")
      public StatisticsInbound.StatisticsInboundBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("inputVat")
      public StatisticsInbound.StatisticsInboundBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      @JsonProperty("standardId")
      public StatisticsInbound.StatisticsInboundBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public StatisticsInbound.StatisticsInboundBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("receiptType")
      public StatisticsInbound.StatisticsInboundBuilder receiptType(final Integer receiptType) {
         this.receiptType = receiptType;
         return this;
      }

      @JsonProperty("receiptId")
      public StatisticsInbound.StatisticsInboundBuilder receiptId(final Long receiptId) {
         this.receiptId = receiptId;
         return this;
      }

      @JsonProperty("receiptSerialNumber")
      public StatisticsInbound.StatisticsInboundBuilder receiptSerialNumber(final String receiptSerialNumber) {
         this.receiptSerialNumber = receiptSerialNumber;
         return this;
      }

      @JsonProperty("monomerId")
      public StatisticsInbound.StatisticsInboundBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public StatisticsInbound.StatisticsInboundBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("workshopId")
      public StatisticsInbound.StatisticsInboundBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("unitPriceExcludingVatNoFreight")
      public StatisticsInbound.StatisticsInboundBuilder unitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
         this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("unitPriceNoFreight")
      public StatisticsInbound.StatisticsInboundBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      @JsonProperty("amountExcludingVatNoFreight")
      public StatisticsInbound.StatisticsInboundBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("amountNoFreight")
      public StatisticsInbound.StatisticsInboundBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      @JsonProperty("inputVatNoFreight")
      public StatisticsInbound.StatisticsInboundBuilder inputVatNoFreight(final BigDecimal inputVatNoFreight) {
         this.inputVatNoFreight = inputVatNoFreight;
         return this;
      }

      @JsonProperty("realTime")
      public StatisticsInbound.StatisticsInboundBuilder realTime(final LocalDateTime realTime) {
         this.realTime = realTime;
         return this;
      }

      public StatisticsInbound build() {
         return new StatisticsInbound(
            this.id,
            this.materialInventoryId,
            this.statisticsId,
            this.basicClass,
            this.classifyId,
            this.classifyName,
            this.specification,
            this.materialIsWhole,
            this.warehouseType,
            this.type,
            this.boolPartyA,
            this.projectId,
            this.quantity,
            this.mete,
            this.unitNet,
            this.length,
            this.width,
            this.thickness,
            this.theoryThickness,
            this.brand,
            this.color,
            this.heatNoAndBatchNo,
            this.warehouseId,
            this.invoiceType,
            this.taxRate,
            this.unitPriceExcludingVat,
            this.unitPrice,
            this.amountExcludingVat,
            this.amount,
            this.inputVat,
            this.standardId,
            this.standardName,
            this.receiptType,
            this.receiptId,
            this.receiptSerialNumber,
            this.monomerId,
            this.areaId,
            this.workshopId,
            this.unitPriceExcludingVatNoFreight,
            this.unitPriceNoFreight,
            this.amountExcludingVatNoFreight,
            this.amountNoFreight,
            this.inputVatNoFreight,
            this.realTime
         );
      }

      @Override
      public String toString() {
         return "StatisticsInbound.StatisticsInboundBuilder(id="
            + this.id
            + ", materialInventoryId="
            + this.materialInventoryId
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
            + ", type="
            + this.type
            + ", boolPartyA="
            + this.boolPartyA
            + ", projectId="
            + this.projectId
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", unitNet="
            + this.unitNet
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
            + ", color="
            + this.color
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", warehouseId="
            + this.warehouseId
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", unitPrice="
            + this.unitPrice
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", amount="
            + this.amount
            + ", inputVat="
            + this.inputVat
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", receiptType="
            + this.receiptType
            + ", receiptId="
            + this.receiptId
            + ", receiptSerialNumber="
            + this.receiptSerialNumber
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
            + ", realTime="
            + this.realTime
            + ")";
      }
   }
}
