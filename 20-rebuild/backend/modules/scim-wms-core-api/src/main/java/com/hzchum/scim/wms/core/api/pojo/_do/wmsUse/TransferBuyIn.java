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

@ApiModel(value = "TransferBuyIn对象", description = "调拨买入记录表 甲供材料调拨到项目库时有两个状态[借用,买入],调拨到公共库默认买入")
@Entity
@TableName("wms_transfer_buy_in")
@Table(name = "wms_transfer_buy_in")
public class TransferBuyIn extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "basicClass", value = "物料基础分类", notes = "物料基础分类")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础分类'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "mete", value = "买入核算量", notes = "买入核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '买入核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '数量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "thickness", value = "厚度", notes = "厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8)  COMMENT '厚度'", nullable = true)
   private BigDecimal thickness;
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
   @Column(name = "width", columnDefinition = "decimal(32,0)  COMMENT '宽度'", nullable = true)
   private BigDecimal width;
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
   @ApiModelProperty(name = "heatNoAndBatchNo", value = "炉批号", notes = "炉批号")
   @JsonProperty("heatNoAndBatchNo")
   @JSONField(name = "heatNoAndBatchNo")
   @TableField("heat_no_and_batch_no")
   @Column(name = "heat_no_and_batch_no", columnDefinition = "varchar(255)  COMMENT '炉批号'", nullable = true)
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "invoiceType", value = "票据类型", notes = "票据类型")
   @JsonProperty("invoiceType")
   @JSONField(name = "invoiceType")
   @TableField("invoice_type")
   @Column(name = "invoice_type", columnDefinition = "int  COMMENT '票据类型'", nullable = true)
   private Integer invoiceType;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(32,8)  COMMENT '税率'", nullable = true)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "unitPrice", value = "含税单价", notes = "含税单价")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,12)  COMMENT '含税单价'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "unitPriceExcludingVat", value = "不含税单价", notes = "不含税单价")
   @JsonProperty("unitPriceExcludingVat")
   @JSONField(name = "unitPriceExcludingVat")
   @TableField("unit_price_excluding_VAT")
   @Column(name = "unit_price_excluding_VAT", columnDefinition = "decimal(32,12)  COMMENT '不含税单价'", nullable = true)
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty(name = "amount", value = "含税总价", notes = "含税总价")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '含税总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税总价", notes = "不含税总价")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_VAT")
   @Column(name = "amount_excluding_VAT", columnDefinition = "decimal(32,12)  COMMENT '不含税总价'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "inputVat", value = "进项税", notes = "进项税")
   @JsonProperty("inputVat")
   @JSONField(name = "inputVat")
   @TableField("input_VAT")
   @Column(name = "input_VAT", columnDefinition = "decimal(32,12)  COMMENT '进项税'", nullable = true)
   private BigDecimal inputVat;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "workshopId", value = "车间ID", notes = "车间ID")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '车间ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "warehouseId", value = "仓库ID", notes = "仓库ID")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '仓库ID'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "transferId", value = "调拨单ID", notes = "调拨单ID")
   @JsonProperty("transferId")
   @JSONField(name = "transferId")
   @TableField("transfer_id")
   @Column(name = "transfer_id", columnDefinition = "bigint  COMMENT '调拨单ID'", nullable = true)
   private Long transferId;
   @ApiModelProperty(name = "founderId", value = "调拨人ID", notes = "调拨人ID")
   @JsonProperty("founderId")
   @JSONField(name = "founderId")
   @TableField("founder_id")
   @Column(name = "founder_id", columnDefinition = "bigint  COMMENT '调拨人ID'", nullable = true)
   private Long founderId;
   @ApiModelProperty(name = "founderName", value = "调拨人", notes = "调拨人")
   @JsonProperty("founderName")
   @JSONField(name = "founderName")
   @TableField("founder_name")
   @Column(name = "founder_name", columnDefinition = "varchar(255)  COMMENT '调拨人'", nullable = true)
   private String founderName;
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
   @ApiModelProperty(name = "theoryThickness", value = "理论厚度", notes = "理论厚度")
   @JsonProperty("theoryThickness")
   @JSONField(name = "theoryThickness")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness", columnDefinition = "decimal(32,8)  COMMENT '理论厚度'", nullable = true)
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "applicantId", value = "申请人ID", notes = "申请人ID")
   @JsonProperty("applicantId")
   @JSONField(name = "applicantId")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint  COMMENT '申请人ID'", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称", notes = "申请人名称")
   @JsonProperty("applicantName")
   @JSONField(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(255)  COMMENT '申请人名称'", nullable = true)
   private String applicantName;
   @ApiModelProperty(name = "materialIsWhole", value = "物料状态[1 整料,2 余料]", notes = "物料状态[1 整料,2 余料]")
   @JsonProperty("materialIsWhole")
   @JSONField(name = "materialIsWhole")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole", columnDefinition = "int  COMMENT '物料状态[1 整料,2 余料]'", nullable = true)
   private Integer materialIsWhole;
   @ApiModelProperty(name = "materialSn", value = "物料编号", notes = "物料编号")
   @JsonProperty("materialSn")
   @JSONField(name = "materialSn")
   @TableField("material_sn")
   @Column(name = "material_sn", columnDefinition = "varchar(255)  COMMENT '物料编号'", nullable = true)
   private String materialSn;
   @ApiModelProperty(name = "unitPriceNoFreight", value = "含税单价 不含运费", notes = "含税单价 不含运费")
   @JsonProperty("unitPriceNoFreight")
   @JSONField(name = "unitPriceNoFreight")
   @TableField("unit_price_no_freight")
   @Column(name = "unit_price_no_freight", columnDefinition = "decimal(32,12)  COMMENT '含税单价 不含运费'", nullable = true)
   private BigDecimal unitPriceNoFreight;
   @ApiModelProperty(name = "unitPriceExcludingVatNoFreight", value = "不含税单价 不含运费", notes = "不含税单价 不含运费")
   @JsonProperty("unitPriceExcludingVatNoFreight")
   @JSONField(name = "unitPriceExcludingVatNoFreight")
   @TableField("unit_price_excluding_VAT_no_freight")
   @Column(name = "unit_price_excluding_VAT_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税单价 不含运费'", nullable = true)
   private BigDecimal unitPriceExcludingVatNoFreight;
   @ApiModelProperty(name = "amountNoFreight", value = "含税总价 不含运费", notes = "含税总价 不含运费")
   @JsonProperty("amountNoFreight")
   @JSONField(name = "amountNoFreight")
   @TableField("amount_no_freight")
   @Column(name = "amount_no_freight", columnDefinition = "decimal(32,12)  COMMENT '含税总价 不含运费'", nullable = true)
   private BigDecimal amountNoFreight;
   @ApiModelProperty(name = "amountExcludingVatNoFreight", value = "不含税总价 不含运费", notes = "不含税总价 不含运费")
   @JsonProperty("amountExcludingVatNoFreight")
   @JSONField(name = "amountExcludingVatNoFreight")
   @TableField("amount_excluding_VAT_no_freight")
   @Column(name = "amount_excluding_VAT_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税总价 不含运费'", nullable = true)
   private BigDecimal amountExcludingVatNoFreight;
   @ApiModelProperty(name = "inputVatNoFreight", value = "进项税 不含运费", notes = "进项税 不含运费")
   @JsonProperty("inputVatNoFreight")
   @JSONField(name = "inputVatNoFreight")
   @TableField("input_VAT_no_freight")
   @Column(name = "input_VAT_no_freight", columnDefinition = "decimal(32,12)  COMMENT '进项税 不含运费'", nullable = true)
   private BigDecimal inputVatNoFreight;

   public static TransferBuyIn.TransferBuyInBuilder builder() {
      return new TransferBuyIn.TransferBuyInBuilder();
   }

   public TransferBuyIn() {
   }

   public TransferBuyIn(
      final Long id,
      final Long classifyId,
      final Integer basicClass,
      final String specification,
      final BigDecimal mete,
      final BigDecimal quantity,
      final BigDecimal thickness,
      final BigDecimal length,
      final BigDecimal width,
      final String color,
      final String brand,
      final String heatNoAndBatchNo,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final BigDecimal inputVat,
      final Long projectId,
      final Long workshopId,
      final Long warehouseId,
      final Long transferId,
      final Long founderId,
      final String founderName,
      final Long standardId,
      final String standardName,
      final BigDecimal theoryThickness,
      final Long applicantId,
      final String applicantName,
      final Integer materialIsWhole,
      final String materialSn,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal unitPriceExcludingVatNoFreight,
      final BigDecimal amountNoFreight,
      final BigDecimal amountExcludingVatNoFreight,
      final BigDecimal inputVatNoFreight
   ) {
      this.id = id;
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.specification = specification;
      this.mete = mete;
      this.quantity = quantity;
      this.thickness = thickness;
      this.length = length;
      this.width = width;
      this.color = color;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.inputVat = inputVat;
      this.projectId = projectId;
      this.workshopId = workshopId;
      this.warehouseId = warehouseId;
      this.transferId = transferId;
      this.founderId = founderId;
      this.founderName = founderName;
      this.standardId = standardId;
      this.standardName = standardName;
      this.theoryThickness = theoryThickness;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.materialIsWhole = materialIsWhole;
      this.materialSn = materialSn;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      this.amountNoFreight = amountNoFreight;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.inputVatNoFreight = inputVatNoFreight;
   }

   public Long getId() {
      return this.id;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public String getColor() {
      return this.color;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
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

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getTransferId() {
      return this.transferId;
   }

   public Long getFounderId() {
      return this.founderId;
   }

   public String getFounderName() {
      return this.founderName;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public String getMaterialSn() {
      return this.materialSn;
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

   public BigDecimal getInputVatNoFreight() {
      return this.inputVatNoFreight;
   }

   @JsonProperty("id")
   public TransferBuyIn setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("classifyId")
   public TransferBuyIn setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("basicClass")
   public TransferBuyIn setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("specification")
   public TransferBuyIn setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("mete")
   public TransferBuyIn setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("quantity")
   public TransferBuyIn setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("thickness")
   public TransferBuyIn setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("length")
   public TransferBuyIn setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public TransferBuyIn setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("color")
   public TransferBuyIn setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("brand")
   public TransferBuyIn setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public TransferBuyIn setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("invoiceType")
   public TransferBuyIn setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("taxRate")
   public TransferBuyIn setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("unitPrice")
   public TransferBuyIn setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("unitPriceExcludingVat")
   public TransferBuyIn setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   @JsonProperty("amount")
   public TransferBuyIn setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public TransferBuyIn setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("inputVat")
   public TransferBuyIn setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   @JsonProperty("projectId")
   public TransferBuyIn setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("workshopId")
   public TransferBuyIn setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("warehouseId")
   public TransferBuyIn setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("transferId")
   public TransferBuyIn setTransferId(final Long transferId) {
      this.transferId = transferId;
      return this;
   }

   @JsonProperty("founderId")
   public TransferBuyIn setFounderId(final Long founderId) {
      this.founderId = founderId;
      return this;
   }

   @JsonProperty("founderName")
   public TransferBuyIn setFounderName(final String founderName) {
      this.founderName = founderName;
      return this;
   }

   @JsonProperty("standardId")
   public TransferBuyIn setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public TransferBuyIn setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("theoryThickness")
   public TransferBuyIn setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("applicantId")
   public TransferBuyIn setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public TransferBuyIn setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("materialIsWhole")
   public TransferBuyIn setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   @JsonProperty("materialSn")
   public TransferBuyIn setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
      return this;
   }

   @JsonProperty("unitPriceNoFreight")
   public TransferBuyIn setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
      return this;
   }

   @JsonProperty("unitPriceExcludingVatNoFreight")
   public TransferBuyIn setUnitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public TransferBuyIn setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public TransferBuyIn setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("inputVatNoFreight")
   public TransferBuyIn setInputVatNoFreight(final BigDecimal inputVatNoFreight) {
      this.inputVatNoFreight = inputVatNoFreight;
      return this;
   }

   @Override
   public String toString() {
      return "TransferBuyIn(id="
         + this.getId()
         + ", classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", mete="
         + this.getMete()
         + ", quantity="
         + this.getQuantity()
         + ", thickness="
         + this.getThickness()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", color="
         + this.getColor()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
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
         + ", projectId="
         + this.getProjectId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", transferId="
         + this.getTransferId()
         + ", founderId="
         + this.getFounderId()
         + ", founderName="
         + this.getFounderName()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", materialSn="
         + this.getMaterialSn()
         + ", unitPriceNoFreight="
         + this.getUnitPriceNoFreight()
         + ", unitPriceExcludingVatNoFreight="
         + this.getUnitPriceExcludingVatNoFreight()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", amountExcludingVatNoFreight="
         + this.getAmountExcludingVatNoFreight()
         + ", inputVatNoFreight="
         + this.getInputVatNoFreight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TransferBuyIn)) {
         return false;
      }

      TransferBuyIn other = (TransferBuyIn)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$invoiceType = this.getInvoiceType();
               Object other$invoiceType = other.getInvoiceType();
               if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$workshopId = this.getWorkshopId();
                     Object other$workshopId = other.getWorkshopId();
                     if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                        Object this$warehouseId = this.getWarehouseId();
                        Object other$warehouseId = other.getWarehouseId();
                        if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                           Object this$transferId = this.getTransferId();
                           Object other$transferId = other.getTransferId();
                           if (this$transferId == null ? other$transferId == null : this$transferId.equals(other$transferId)) {
                              Object this$founderId = this.getFounderId();
                              Object other$founderId = other.getFounderId();
                              if (this$founderId == null ? other$founderId == null : this$founderId.equals(other$founderId)) {
                                 Object this$standardId = this.getStandardId();
                                 Object other$standardId = other.getStandardId();
                                 if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                    Object this$applicantId = this.getApplicantId();
                                    Object other$applicantId = other.getApplicantId();
                                    if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                                       Object this$materialIsWhole = this.getMaterialIsWhole();
                                       Object other$materialIsWhole = other.getMaterialIsWhole();
                                       if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
                                          Object this$specification = this.getSpecification();
                                          Object other$specification = other.getSpecification();
                                          if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                             Object this$mete = this.getMete();
                                             Object other$mete = other.getMete();
                                             if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                Object this$quantity = this.getQuantity();
                                                Object other$quantity = other.getQuantity();
                                                if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                   Object this$thickness = this.getThickness();
                                                   Object other$thickness = other.getThickness();
                                                   if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                      Object this$length = this.getLength();
                                                      Object other$length = other.getLength();
                                                      if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                         Object this$width = this.getWidth();
                                                         Object other$width = other.getWidth();
                                                         if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                            Object this$color = this.getColor();
                                                            Object other$color = other.getColor();
                                                            if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                               Object this$brand = this.getBrand();
                                                               Object other$brand = other.getBrand();
                                                               if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                  Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                  Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                  if (this$heatNoAndBatchNo == null
                                                                     ? other$heatNoAndBatchNo == null
                                                                     : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                     Object this$taxRate = this.getTaxRate();
                                                                     Object other$taxRate = other.getTaxRate();
                                                                     if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                                        Object this$unitPrice = this.getUnitPrice();
                                                                        Object other$unitPrice = other.getUnitPrice();
                                                                        if (this$unitPrice == null
                                                                           ? other$unitPrice == null
                                                                           : this$unitPrice.equals(other$unitPrice)) {
                                                                           Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                                                           Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                                                           if (this$unitPriceExcludingVat == null
                                                                              ? other$unitPriceExcludingVat == null
                                                                              : this$unitPriceExcludingVat.equals(other$unitPriceExcludingVat)) {
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
                                                                                    Object this$inputVat = this.getInputVat();
                                                                                    Object other$inputVat = other.getInputVat();
                                                                                    if (this$inputVat == null
                                                                                       ? other$inputVat == null
                                                                                       : this$inputVat.equals(other$inputVat)) {
                                                                                       Object this$founderName = this.getFounderName();
                                                                                       Object other$founderName = other.getFounderName();
                                                                                       if (this$founderName == null
                                                                                          ? other$founderName == null
                                                                                          : this$founderName.equals(other$founderName)) {
                                                                                          Object this$standardName = this.getStandardName();
                                                                                          Object other$standardName = other.getStandardName();
                                                                                          if (this$standardName == null
                                                                                             ? other$standardName == null
                                                                                             : this$standardName.equals(other$standardName)) {
                                                                                             Object this$theoryThickness = this.getTheoryThickness();
                                                                                             Object other$theoryThickness = other.getTheoryThickness();
                                                                                             if (this$theoryThickness == null
                                                                                                ? other$theoryThickness == null
                                                                                                : this$theoryThickness.equals(other$theoryThickness)) {
                                                                                                Object this$applicantName = this.getApplicantName();
                                                                                                Object other$applicantName = other.getApplicantName();
                                                                                                if (this$applicantName == null
                                                                                                   ? other$applicantName == null
                                                                                                   : this$applicantName.equals(other$applicantName)) {
                                                                                                   Object this$materialSn = this.getMaterialSn();
                                                                                                   Object other$materialSn = other.getMaterialSn();
                                                                                                   if (this$materialSn == null
                                                                                                      ? other$materialSn == null
                                                                                                      : this$materialSn.equals(other$materialSn)) {
                                                                                                      Object this$unitPriceNoFreight = this.getUnitPriceNoFreight();
                                                                                                      Object other$unitPriceNoFreight = other.getUnitPriceNoFreight();
                                                                                                      if (this$unitPriceNoFreight == null
                                                                                                         ? other$unitPriceNoFreight == null
                                                                                                         : this$unitPriceNoFreight.equals(
                                                                                                            other$unitPriceNoFreight
                                                                                                         )) {
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
                                                                                                               : this$amountNoFreight.equals(
                                                                                                                  other$amountNoFreight
                                                                                                               )) {
                                                                                                               Object this$amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
                                                                                                               Object other$amountExcludingVatNoFreight = other.getAmountExcludingVatNoFreight();
                                                                                                               if (this$amountExcludingVatNoFreight == null
                                                                                                                  ? other$amountExcludingVatNoFreight == null
                                                                                                                  : this$amountExcludingVatNoFreight.equals(
                                                                                                                     other$amountExcludingVatNoFreight
                                                                                                                  )) {
                                                                                                                  Object this$inputVatNoFreight = this.getInputVatNoFreight();
                                                                                                                  Object other$inputVatNoFreight = other.getInputVatNoFreight();
                                                                                                                  return this$inputVatNoFreight == null
                                                                                                                     ? other$inputVatNoFreight == null
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TransferBuyIn;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $transferId = this.getTransferId();
      result = result * 59 + ($transferId == null ? 43 : $transferId.hashCode());
      Object $founderId = this.getFounderId();
      result = result * 59 + ($founderId == null ? 43 : $founderId.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
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
      Object $founderName = this.getFounderName();
      result = result * 59 + ($founderName == null ? 43 : $founderName.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $materialSn = this.getMaterialSn();
      result = result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
      Object $unitPriceNoFreight = this.getUnitPriceNoFreight();
      result = result * 59 + ($unitPriceNoFreight == null ? 43 : $unitPriceNoFreight.hashCode());
      Object $unitPriceExcludingVatNoFreight = this.getUnitPriceExcludingVatNoFreight();
      result = result * 59 + ($unitPriceExcludingVatNoFreight == null ? 43 : $unitPriceExcludingVatNoFreight.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
      result = result * 59 + ($amountExcludingVatNoFreight == null ? 43 : $amountExcludingVatNoFreight.hashCode());
      Object $inputVatNoFreight = this.getInputVatNoFreight();
      return result * 59 + ($inputVatNoFreight == null ? 43 : $inputVatNoFreight.hashCode());
   }

   public static class TransferBuyInBuilder {
      private Long id;
      private Long classifyId;
      private Integer basicClass;
      private String specification;
      private BigDecimal mete;
      private BigDecimal quantity;
      private BigDecimal thickness;
      private BigDecimal length;
      private BigDecimal width;
      private String color;
      private String brand;
      private String heatNoAndBatchNo;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private BigDecimal inputVat;
      private Long projectId;
      private Long workshopId;
      private Long warehouseId;
      private Long transferId;
      private Long founderId;
      private String founderName;
      private Long standardId;
      private String standardName;
      private BigDecimal theoryThickness;
      private Long applicantId;
      private String applicantName;
      private Integer materialIsWhole;
      private String materialSn;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal unitPriceExcludingVatNoFreight;
      private BigDecimal amountNoFreight;
      private BigDecimal amountExcludingVatNoFreight;
      private BigDecimal inputVatNoFreight;

      TransferBuyInBuilder() {
      }

      @JsonProperty("id")
      public TransferBuyIn.TransferBuyInBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("classifyId")
      public TransferBuyIn.TransferBuyInBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("basicClass")
      public TransferBuyIn.TransferBuyInBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("specification")
      public TransferBuyIn.TransferBuyInBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("mete")
      public TransferBuyIn.TransferBuyInBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("quantity")
      public TransferBuyIn.TransferBuyInBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("thickness")
      public TransferBuyIn.TransferBuyInBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("length")
      public TransferBuyIn.TransferBuyInBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public TransferBuyIn.TransferBuyInBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("color")
      public TransferBuyIn.TransferBuyInBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("brand")
      public TransferBuyIn.TransferBuyInBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public TransferBuyIn.TransferBuyInBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("invoiceType")
      public TransferBuyIn.TransferBuyInBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("taxRate")
      public TransferBuyIn.TransferBuyInBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("unitPrice")
      public TransferBuyIn.TransferBuyInBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("unitPriceExcludingVat")
      public TransferBuyIn.TransferBuyInBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      @JsonProperty("amount")
      public TransferBuyIn.TransferBuyInBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public TransferBuyIn.TransferBuyInBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("inputVat")
      public TransferBuyIn.TransferBuyInBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      @JsonProperty("projectId")
      public TransferBuyIn.TransferBuyInBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("workshopId")
      public TransferBuyIn.TransferBuyInBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("warehouseId")
      public TransferBuyIn.TransferBuyInBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("transferId")
      public TransferBuyIn.TransferBuyInBuilder transferId(final Long transferId) {
         this.transferId = transferId;
         return this;
      }

      @JsonProperty("founderId")
      public TransferBuyIn.TransferBuyInBuilder founderId(final Long founderId) {
         this.founderId = founderId;
         return this;
      }

      @JsonProperty("founderName")
      public TransferBuyIn.TransferBuyInBuilder founderName(final String founderName) {
         this.founderName = founderName;
         return this;
      }

      @JsonProperty("standardId")
      public TransferBuyIn.TransferBuyInBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public TransferBuyIn.TransferBuyInBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("theoryThickness")
      public TransferBuyIn.TransferBuyInBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("applicantId")
      public TransferBuyIn.TransferBuyInBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public TransferBuyIn.TransferBuyInBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public TransferBuyIn.TransferBuyInBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("materialSn")
      public TransferBuyIn.TransferBuyInBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      @JsonProperty("unitPriceNoFreight")
      public TransferBuyIn.TransferBuyInBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      @JsonProperty("unitPriceExcludingVatNoFreight")
      public TransferBuyIn.TransferBuyInBuilder unitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
         this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("amountNoFreight")
      public TransferBuyIn.TransferBuyInBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      @JsonProperty("amountExcludingVatNoFreight")
      public TransferBuyIn.TransferBuyInBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("inputVatNoFreight")
      public TransferBuyIn.TransferBuyInBuilder inputVatNoFreight(final BigDecimal inputVatNoFreight) {
         this.inputVatNoFreight = inputVatNoFreight;
         return this;
      }

      public TransferBuyIn build() {
         return new TransferBuyIn(
            this.id,
            this.classifyId,
            this.basicClass,
            this.specification,
            this.mete,
            this.quantity,
            this.thickness,
            this.length,
            this.width,
            this.color,
            this.brand,
            this.heatNoAndBatchNo,
            this.invoiceType,
            this.taxRate,
            this.unitPrice,
            this.unitPriceExcludingVat,
            this.amount,
            this.amountExcludingVat,
            this.inputVat,
            this.projectId,
            this.workshopId,
            this.warehouseId,
            this.transferId,
            this.founderId,
            this.founderName,
            this.standardId,
            this.standardName,
            this.theoryThickness,
            this.applicantId,
            this.applicantName,
            this.materialIsWhole,
            this.materialSn,
            this.unitPriceNoFreight,
            this.unitPriceExcludingVatNoFreight,
            this.amountNoFreight,
            this.amountExcludingVatNoFreight,
            this.inputVatNoFreight
         );
      }

      @Override
      public String toString() {
         return "TransferBuyIn.TransferBuyInBuilder(id="
            + this.id
            + ", classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", mete="
            + this.mete
            + ", quantity="
            + this.quantity
            + ", thickness="
            + this.thickness
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", color="
            + this.color
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
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
            + ", projectId="
            + this.projectId
            + ", workshopId="
            + this.workshopId
            + ", warehouseId="
            + this.warehouseId
            + ", transferId="
            + this.transferId
            + ", founderId="
            + this.founderId
            + ", founderName="
            + this.founderName
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", theoryThickness="
            + this.theoryThickness
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", materialSn="
            + this.materialSn
            + ", unitPriceNoFreight="
            + this.unitPriceNoFreight
            + ", unitPriceExcludingVatNoFreight="
            + this.unitPriceExcludingVatNoFreight
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", amountExcludingVatNoFreight="
            + this.amountExcludingVatNoFreight
            + ", inputVatNoFreight="
            + this.inputVatNoFreight
            + ")";
      }
   }
}
