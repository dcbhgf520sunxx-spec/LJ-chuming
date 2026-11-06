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

@ApiModel(value = "MonthWeightedAveragePrice对象", description = "月末加权平均价 ")
@Entity
@TableName("wms_month_weighted_average_price")
@Table(name = "wms_month_weighted_average_price")
public class MonthWeightedAveragePrice extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,12)  COMMENT '单价'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "unitPriceExcludingVat", value = "不含税单价", notes = "不含税单价")
   @JsonProperty("unitPriceExcludingVat")
   @JSONField(name = "unitPriceExcludingVat")
   @TableField("unit_price_excluding_vat")
   @Column(name = "unit_price_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '不含税单价'", nullable = true)
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty(name = "basicClass", value = "基础物料分类", notes = "基础物料分类")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '基础物料分类'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "specification", value = "科目不计入加权价的规格[不计入加权价的规格不同,则不合并]", notes = "科目不计入加权价的规格[不计入加权价的规格不同,则不合并]")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(128)  COMMENT '科目不计入加权价的规格[不计入加权价的规格不同,则不合并]'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "thickness", value = "厚度", notes = "厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8)  COMMENT '厚度'", nullable = true)
   private BigDecimal thickness;
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
   @Column(name = "color", columnDefinition = "varchar(255)  COMMENT '颜色'", nullable = true)
   private String color;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(255)  COMMENT '品牌'", nullable = true)
   private String brand;
   @ApiModelProperty(name = "mete", value = "当前库存核算量", notes = "当前库存核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '当前库存核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   @JsonProperty("accountingUnit")
   @JSONField(name = "accountingUnit")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(128)  COMMENT '核算单位'", nullable = true)
   private String accountingUnit;
   @ApiModelProperty(name = "boolNewestPrice", value = "是否为最新加权 [0 非最新, 1最新]", notes = "是否为最新加权 [0 非最新, 1最新]")
   @JsonProperty("boolNewestPrice")
   @JSONField(name = "boolNewestPrice")
   @TableField("bool_newest_price")
   @Column(name = "bool_newest_price", columnDefinition = "tinyint(1) default '1' COMMENT '是否为最新加权 [0 非最新, 1最新]'", nullable = true)
   private Boolean boolNewestPrice;
   @ApiModelProperty(name = "unitNet", value = "单为净量", notes = "单为净量")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(32,8)  COMMENT '单为净量'", nullable = true)
   private BigDecimal unitNet;
   @ApiModelProperty(name = "boolPartyA", value = "是否为甲供", notes = "是否为甲供")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否为甲供'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "invoiceType", value = "发票类型", notes = "发票类型")
   @JsonProperty("invoiceType")
   @JSONField(name = "invoiceType")
   @TableField("invoice_type")
   @Column(name = "invoice_type", columnDefinition = "int  COMMENT '发票类型'", nullable = true)
   private Integer invoiceType;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(32,8)  COMMENT '税率'", nullable = true)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "boolAllOutbound", value = "是否全部出库", notes = "是否全部出库")
   @JsonProperty("boolAllOutbound")
   @JSONField(name = "boolAllOutbound")
   @TableField("bool_all_outbound")
   @Column(name = "bool_all_outbound", columnDefinition = "bit(1)  COMMENT '是否全部出库'", nullable = true)
   private Boolean boolAllOutbound;
   @ApiModelProperty(name = "quantity", value = "计量量", notes = "计量量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '计量量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "standardId", value = "型材执行的国标ID", notes = "型材执行的国标ID")
   @JsonProperty("standardId")
   @JSONField(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id", columnDefinition = "bigint  COMMENT '型材执行的国标ID'", nullable = true)
   private Long standardId;
   @ApiModelProperty(name = "standardName", value = "型材执行的国标名称", notes = "型材执行的国标名称")
   @JsonProperty("standardName")
   @JSONField(name = "standardName")
   @TableField("standard_name")
   @Column(name = "standard_name", columnDefinition = "varchar(255)  COMMENT '型材执行的国标名称'", nullable = true)
   private String standardName;
   @ApiModelProperty(name = "outboundUnitType", value = "出库单位类型", notes = "出库单位类型")
   @JsonProperty("outboundUnitType")
   @JSONField(name = "outboundUnitType")
   @TableField("outbound_unit_type")
   @Column(name = "outbound_unit_type", columnDefinition = "int  COMMENT '出库单位类型'", nullable = true)
   private Integer outboundUnitType;
   @ApiModelProperty(name = "amount")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,8)  COMMENT ''", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "amountExcludingVat")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_vat")
   @Column(name = "amount_excluding_vat", columnDefinition = "decimal(32,8)  COMMENT ''", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "wholeWapId", value = "全库加权ID", notes = "全库加权ID")
   @JsonProperty("wholeWapId")
   @JSONField(name = "wholeWapId")
   @TableField("whole_wap_id")
   @Column(name = "whole_wap_id", columnDefinition = "bigint  COMMENT '全库加权ID'", nullable = true)
   private Long wholeWapId;
   @ApiModelProperty(name = "unitPriceNoFreight", value = "单价 不含运费", notes = "单价 不含运费")
   @JsonProperty("unitPriceNoFreight")
   @JSONField(name = "unitPriceNoFreight")
   @TableField("unit_price_no_freight")
   @Column(name = "unit_price_no_freight", columnDefinition = "decimal(32,12)  COMMENT '单价 不含运费'", nullable = true)
   private BigDecimal unitPriceNoFreight;
   @ApiModelProperty(name = "unitPriceExcludingVatNoFreight", value = "不含税单价 不含运费", notes = "不含税单价 不含运费")
   @JsonProperty("unitPriceExcludingVatNoFreight")
   @JSONField(name = "unitPriceExcludingVatNoFreight")
   @TableField("unit_price_excluding_vat_no_freight")
   @Column(name = "unit_price_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税单价 不含运费'", nullable = true)
   private BigDecimal unitPriceExcludingVatNoFreight;
   @ApiModelProperty(name = "amountNoFreight")
   @JsonProperty("amountNoFreight")
   @JSONField(name = "amountNoFreight")
   @TableField("amount_no_freight")
   @Column(name = "amount_no_freight", columnDefinition = "decimal(32,8)  COMMENT ' 不含运费'", nullable = true)
   private BigDecimal amountNoFreight;
   @ApiModelProperty(name = "amountExcludingVatNoFreight")
   @JsonProperty("amountExcludingVatNoFreight")
   @JSONField(name = "amountExcludingVatNoFreight")
   @TableField("amount_excluding_vat_no_freight")
   @Column(name = "amount_excluding_vat_no_freight", columnDefinition = "decimal(32,8)  COMMENT ' 不含运费'", nullable = true)
   private BigDecimal amountExcludingVatNoFreight;
   @ApiModelProperty(name = "startTime", value = "开始时间")
   @JsonProperty("startTime")
   @JSONField(name = "startTime")
   @TableField("start_time")
   @Column(name = "start_time")
   private LocalDateTime startTime;
   @ApiModelProperty(name = "endTime", value = "结束时间")
   @JsonProperty("endTime")
   @JSONField(name = "endTime")
   @TableField("end_time")
   @Column(name = "end_time")
   private LocalDateTime endTime;

   public static MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder builder() {
      return new MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder();
   }

   public MonthWeightedAveragePrice() {
   }

   public MonthWeightedAveragePrice(
      final Long id,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVat,
      final Integer basicClass,
      final Long classifyId,
      final Long projectId,
      final String specification,
      final BigDecimal thickness,
      final String heatNoAndBatchNo,
      final String color,
      final String brand,
      final BigDecimal mete,
      final String accountingUnit,
      final Boolean boolNewestPrice,
      final BigDecimal unitNet,
      final Boolean boolPartyA,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final Boolean boolAllOutbound,
      final BigDecimal quantity,
      final Long standardId,
      final String standardName,
      final Integer outboundUnitType,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final Long wholeWapId,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal unitPriceExcludingVatNoFreight,
      final BigDecimal amountNoFreight,
      final BigDecimal amountExcludingVatNoFreight,
      final LocalDateTime startTime,
      final LocalDateTime endTime
   ) {
      this.id = id;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.projectId = projectId;
      this.specification = specification;
      this.thickness = thickness;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.brand = brand;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.boolNewestPrice = boolNewestPrice;
      this.unitNet = unitNet;
      this.boolPartyA = boolPartyA;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.boolAllOutbound = boolAllOutbound;
      this.quantity = quantity;
      this.standardId = standardId;
      this.standardName = standardName;
      this.outboundUnitType = outboundUnitType;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.wholeWapId = wholeWapId;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      this.amountNoFreight = amountNoFreight;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.startTime = startTime;
      this.endTime = endTime;
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public String getBrand() {
      return this.brand;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Boolean getBoolNewestPrice() {
      return this.boolNewestPrice;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
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

   public Boolean getBoolAllOutbound() {
      return this.boolAllOutbound;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public Integer getOutboundUnitType() {
      return this.outboundUnitType;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public Long getWholeWapId() {
      return this.wholeWapId;
   }

   public BigDecimal getUnitPriceNoFreight() {
      return this.unitPriceNoFreight;
   }

   public BigDecimal getUnitPriceExcludingVatNoFreight() {
      return this.unitPriceExcludingVatNoFreight;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public BigDecimal getAmountExcludingVatNoFreight() {
      return this.amountExcludingVatNoFreight;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   @JsonProperty("id")
   public MonthWeightedAveragePrice setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("unitPrice")
   public MonthWeightedAveragePrice setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("unitPriceExcludingVat")
   public MonthWeightedAveragePrice setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   @JsonProperty("basicClass")
   public MonthWeightedAveragePrice setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public MonthWeightedAveragePrice setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("projectId")
   public MonthWeightedAveragePrice setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("specification")
   public MonthWeightedAveragePrice setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("thickness")
   public MonthWeightedAveragePrice setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public MonthWeightedAveragePrice setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("color")
   public MonthWeightedAveragePrice setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("brand")
   public MonthWeightedAveragePrice setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("mete")
   public MonthWeightedAveragePrice setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("accountingUnit")
   public MonthWeightedAveragePrice setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @JsonProperty("boolNewestPrice")
   public MonthWeightedAveragePrice setBoolNewestPrice(final Boolean boolNewestPrice) {
      this.boolNewestPrice = boolNewestPrice;
      return this;
   }

   @JsonProperty("unitNet")
   public MonthWeightedAveragePrice setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("boolPartyA")
   public MonthWeightedAveragePrice setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("invoiceType")
   public MonthWeightedAveragePrice setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("taxRate")
   public MonthWeightedAveragePrice setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("boolAllOutbound")
   public MonthWeightedAveragePrice setBoolAllOutbound(final Boolean boolAllOutbound) {
      this.boolAllOutbound = boolAllOutbound;
      return this;
   }

   @JsonProperty("quantity")
   public MonthWeightedAveragePrice setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("standardId")
   public MonthWeightedAveragePrice setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public MonthWeightedAveragePrice setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("outboundUnitType")
   public MonthWeightedAveragePrice setOutboundUnitType(final Integer outboundUnitType) {
      this.outboundUnitType = outboundUnitType;
      return this;
   }

   @JsonProperty("amount")
   public MonthWeightedAveragePrice setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public MonthWeightedAveragePrice setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("wholeWapId")
   public MonthWeightedAveragePrice setWholeWapId(final Long wholeWapId) {
      this.wholeWapId = wholeWapId;
      return this;
   }

   @JsonProperty("unitPriceNoFreight")
   public MonthWeightedAveragePrice setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
      return this;
   }

   @JsonProperty("unitPriceExcludingVatNoFreight")
   public MonthWeightedAveragePrice setUnitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public MonthWeightedAveragePrice setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public MonthWeightedAveragePrice setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("startTime")
   public MonthWeightedAveragePrice setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
      return this;
   }

   @JsonProperty("endTime")
   public MonthWeightedAveragePrice setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
      return this;
   }

   @Override
   public String toString() {
      return "MonthWeightedAveragePrice(id="
         + this.getId()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", projectId="
         + this.getProjectId()
         + ", specification="
         + this.getSpecification()
         + ", thickness="
         + this.getThickness()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", brand="
         + this.getBrand()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", boolNewestPrice="
         + this.getBoolNewestPrice()
         + ", unitNet="
         + this.getUnitNet()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", boolAllOutbound="
         + this.getBoolAllOutbound()
         + ", quantity="
         + this.getQuantity()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", outboundUnitType="
         + this.getOutboundUnitType()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", wholeWapId="
         + this.getWholeWapId()
         + ", unitPriceNoFreight="
         + this.getUnitPriceNoFreight()
         + ", unitPriceExcludingVatNoFreight="
         + this.getUnitPriceExcludingVatNoFreight()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", amountExcludingVatNoFreight="
         + this.getAmountExcludingVatNoFreight()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MonthWeightedAveragePrice)) {
         return false;
      }

      MonthWeightedAveragePrice other = (MonthWeightedAveragePrice)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$boolNewestPrice = this.getBoolNewestPrice();
                  Object other$boolNewestPrice = other.getBoolNewestPrice();
                  if (this$boolNewestPrice == null ? other$boolNewestPrice == null : this$boolNewestPrice.equals(other$boolNewestPrice)) {
                     Object this$boolPartyA = this.getBoolPartyA();
                     Object other$boolPartyA = other.getBoolPartyA();
                     if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                        Object this$invoiceType = this.getInvoiceType();
                        Object other$invoiceType = other.getInvoiceType();
                        if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                           Object this$boolAllOutbound = this.getBoolAllOutbound();
                           Object other$boolAllOutbound = other.getBoolAllOutbound();
                           if (this$boolAllOutbound == null ? other$boolAllOutbound == null : this$boolAllOutbound.equals(other$boolAllOutbound)) {
                              Object this$standardId = this.getStandardId();
                              Object other$standardId = other.getStandardId();
                              if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                 Object this$outboundUnitType = this.getOutboundUnitType();
                                 Object other$outboundUnitType = other.getOutboundUnitType();
                                 if (this$outboundUnitType == null ? other$outboundUnitType == null : this$outboundUnitType.equals(other$outboundUnitType)) {
                                    Object this$wholeWapId = this.getWholeWapId();
                                    Object other$wholeWapId = other.getWholeWapId();
                                    if (this$wholeWapId == null ? other$wholeWapId == null : this$wholeWapId.equals(other$wholeWapId)) {
                                       Object this$unitPrice = this.getUnitPrice();
                                       Object other$unitPrice = other.getUnitPrice();
                                       if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                          Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                          Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                          if (this$unitPriceExcludingVat == null
                                             ? other$unitPriceExcludingVat == null
                                             : this$unitPriceExcludingVat.equals(other$unitPriceExcludingVat)) {
                                             Object this$specification = this.getSpecification();
                                             Object other$specification = other.getSpecification();
                                             if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                Object this$thickness = this.getThickness();
                                                Object other$thickness = other.getThickness();
                                                if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                   Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                   Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                   if (this$heatNoAndBatchNo == null
                                                      ? other$heatNoAndBatchNo == null
                                                      : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                      Object this$color = this.getColor();
                                                      Object other$color = other.getColor();
                                                      if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                         Object this$brand = this.getBrand();
                                                         Object other$brand = other.getBrand();
                                                         if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                            Object this$mete = this.getMete();
                                                            Object other$mete = other.getMete();
                                                            if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                               Object this$accountingUnit = this.getAccountingUnit();
                                                               Object other$accountingUnit = other.getAccountingUnit();
                                                               if (this$accountingUnit == null
                                                                  ? other$accountingUnit == null
                                                                  : this$accountingUnit.equals(other$accountingUnit)) {
                                                                  Object this$unitNet = this.getUnitNet();
                                                                  Object other$unitNet = other.getUnitNet();
                                                                  if (this$unitNet == null ? other$unitNet == null : this$unitNet.equals(other$unitNet)) {
                                                                     Object this$taxRate = this.getTaxRate();
                                                                     Object other$taxRate = other.getTaxRate();
                                                                     if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                                        Object this$quantity = this.getQuantity();
                                                                        Object other$quantity = other.getQuantity();
                                                                        if (this$quantity == null
                                                                           ? other$quantity == null
                                                                           : this$quantity.equals(other$quantity)) {
                                                                           Object this$standardName = this.getStandardName();
                                                                           Object other$standardName = other.getStandardName();
                                                                           if (this$standardName == null
                                                                              ? other$standardName == null
                                                                              : this$standardName.equals(other$standardName)) {
                                                                              Object this$amount = this.getAmount();
                                                                              Object other$amount = other.getAmount();
                                                                              if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)
                                                                                 )
                                                                               {
                                                                                 Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                                 Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                                 if (this$amountExcludingVat == null
                                                                                    ? other$amountExcludingVat == null
                                                                                    : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                                                                    Object this$unitPriceNoFreight = this.getUnitPriceNoFreight();
                                                                                    Object other$unitPriceNoFreight = other.getUnitPriceNoFreight();
                                                                                    if (this$unitPriceNoFreight == null
                                                                                       ? other$unitPriceNoFreight == null
                                                                                       : this$unitPriceNoFreight.equals(other$unitPriceNoFreight)) {
                                                                                       Object this$unitPriceExcludingVatNoFreight = this.getUnitPriceExcludingVatNoFreight();
                                                                                       Object other$unitPriceExcludingVatNoFreight = other.getUnitPriceExcludingVatNoFreight();
                                                                                       if (this$unitPriceExcludingVatNoFreight == null
                                                                                          ? other$unitPriceExcludingVatNoFreight == null
                                                                                          : this$unitPriceExcludingVatNoFreight.equals(
                                                                                             other$unitPriceExcludingVatNoFreight
                                                                                          )) {
                                                                                          Object this$amountNoFreight = this.getAmountNoFreight();
                                                                                          Object other$amountNoFreight = other.getAmountNoFreight();
                                                                                          if (this$amountNoFreight == null
                                                                                             ? other$amountNoFreight == null
                                                                                             : this$amountNoFreight.equals(other$amountNoFreight)) {
                                                                                             Object this$amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
                                                                                             Object other$amountExcludingVatNoFreight = other.getAmountExcludingVatNoFreight();
                                                                                             if (this$amountExcludingVatNoFreight == null
                                                                                                ? other$amountExcludingVatNoFreight == null
                                                                                                : this$amountExcludingVatNoFreight.equals(
                                                                                                   other$amountExcludingVatNoFreight
                                                                                                )) {
                                                                                                Object this$startTime = this.getStartTime();
                                                                                                Object other$startTime = other.getStartTime();
                                                                                                if (this$startTime == null
                                                                                                   ? other$startTime == null
                                                                                                   : this$startTime.equals(other$startTime)) {
                                                                                                   Object this$endTime = this.getEndTime();
                                                                                                   Object other$endTime = other.getEndTime();
                                                                                                   return this$endTime == null
                                                                                                      ? other$endTime == null
                                                                                                      : this$endTime.equals(other$endTime);
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MonthWeightedAveragePrice;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $boolNewestPrice = this.getBoolNewestPrice();
      result = result * 59 + ($boolNewestPrice == null ? 43 : $boolNewestPrice.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $boolAllOutbound = this.getBoolAllOutbound();
      result = result * 59 + ($boolAllOutbound == null ? 43 : $boolAllOutbound.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $outboundUnitType = this.getOutboundUnitType();
      result = result * 59 + ($outboundUnitType == null ? 43 : $outboundUnitType.hashCode());
      Object $wholeWapId = this.getWholeWapId();
      result = result * 59 + ($wholeWapId == null ? 43 : $wholeWapId.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $unitPriceNoFreight = this.getUnitPriceNoFreight();
      result = result * 59 + ($unitPriceNoFreight == null ? 43 : $unitPriceNoFreight.hashCode());
      Object $unitPriceExcludingVatNoFreight = this.getUnitPriceExcludingVatNoFreight();
      result = result * 59 + ($unitPriceExcludingVatNoFreight == null ? 43 : $unitPriceExcludingVatNoFreight.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
      result = result * 59 + ($amountExcludingVatNoFreight == null ? 43 : $amountExcludingVatNoFreight.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      return result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
   }

   public static class MonthWeightedAveragePriceBuilder {
      private Long id;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVat;
      private Integer basicClass;
      private Long classifyId;
      private Long projectId;
      private String specification;
      private BigDecimal thickness;
      private String heatNoAndBatchNo;
      private String color;
      private String brand;
      private BigDecimal mete;
      private String accountingUnit;
      private Boolean boolNewestPrice;
      private BigDecimal unitNet;
      private Boolean boolPartyA;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private Boolean boolAllOutbound;
      private BigDecimal quantity;
      private Long standardId;
      private String standardName;
      private Integer outboundUnitType;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private Long wholeWapId;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal unitPriceExcludingVatNoFreight;
      private BigDecimal amountNoFreight;
      private BigDecimal amountExcludingVatNoFreight;
      private LocalDateTime startTime;
      private LocalDateTime endTime;

      MonthWeightedAveragePriceBuilder() {
      }

      @JsonProperty("id")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("unitPrice")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("unitPriceExcludingVat")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      @JsonProperty("basicClass")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("projectId")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("specification")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("thickness")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("color")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("brand")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("mete")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("accountingUnit")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("boolNewestPrice")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder boolNewestPrice(final Boolean boolNewestPrice) {
         this.boolNewestPrice = boolNewestPrice;
         return this;
      }

      @JsonProperty("unitNet")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("boolPartyA")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("invoiceType")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("taxRate")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("boolAllOutbound")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder boolAllOutbound(final Boolean boolAllOutbound) {
         this.boolAllOutbound = boolAllOutbound;
         return this;
      }

      @JsonProperty("quantity")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("standardId")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("outboundUnitType")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder outboundUnitType(final Integer outboundUnitType) {
         this.outboundUnitType = outboundUnitType;
         return this;
      }

      @JsonProperty("amount")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("wholeWapId")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder wholeWapId(final Long wholeWapId) {
         this.wholeWapId = wholeWapId;
         return this;
      }

      @JsonProperty("unitPriceNoFreight")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      @JsonProperty("unitPriceExcludingVatNoFreight")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder unitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
         this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("amountNoFreight")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      @JsonProperty("amountExcludingVatNoFreight")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("startTime")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      @JsonProperty("endTime")
      public MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      public MonthWeightedAveragePrice build() {
         return new MonthWeightedAveragePrice(
            this.id,
            this.unitPrice,
            this.unitPriceExcludingVat,
            this.basicClass,
            this.classifyId,
            this.projectId,
            this.specification,
            this.thickness,
            this.heatNoAndBatchNo,
            this.color,
            this.brand,
            this.mete,
            this.accountingUnit,
            this.boolNewestPrice,
            this.unitNet,
            this.boolPartyA,
            this.invoiceType,
            this.taxRate,
            this.boolAllOutbound,
            this.quantity,
            this.standardId,
            this.standardName,
            this.outboundUnitType,
            this.amount,
            this.amountExcludingVat,
            this.wholeWapId,
            this.unitPriceNoFreight,
            this.unitPriceExcludingVatNoFreight,
            this.amountNoFreight,
            this.amountExcludingVatNoFreight,
            this.startTime,
            this.endTime
         );
      }

      @Override
      public String toString() {
         return "MonthWeightedAveragePrice.MonthWeightedAveragePriceBuilder(id="
            + this.id
            + ", unitPrice="
            + this.unitPrice
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", projectId="
            + this.projectId
            + ", specification="
            + this.specification
            + ", thickness="
            + this.thickness
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", brand="
            + this.brand
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", boolNewestPrice="
            + this.boolNewestPrice
            + ", unitNet="
            + this.unitNet
            + ", boolPartyA="
            + this.boolPartyA
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", boolAllOutbound="
            + this.boolAllOutbound
            + ", quantity="
            + this.quantity
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", outboundUnitType="
            + this.outboundUnitType
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", wholeWapId="
            + this.wholeWapId
            + ", unitPriceNoFreight="
            + this.unitPriceNoFreight
            + ", unitPriceExcludingVatNoFreight="
            + this.unitPriceExcludingVatNoFreight
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", amountExcludingVatNoFreight="
            + this.amountExcludingVatNoFreight
            + ", startTime="
            + this.startTime
            + ", endTime="
            + this.endTime
            + ")";
      }
   }
}
