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

@ApiModel(value = "TransferDetail对象", description = "物料调拨详情 ")
@Entity
@TableName("wms_transfer_detail")
@Table(name = "wms_transfer_detail")
public class TransferDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "transferId", value = "调拨单ID", notes = "调拨单ID")
   @JsonProperty("transferId")
   @JSONField(name = "transferId")
   @TableField("transfer_id")
   @Column(name = "transfer_id", columnDefinition = "bigint  COMMENT '调拨单ID'", nullable = true)
   private Long transferId;
   @ApiModelProperty(name = "materialInventoryId", value = "物料仓库ID", notes = "物料仓库ID")
   @JsonProperty("materialInventoryId")
   @JSONField(name = "materialInventoryId")
   @TableField("material_inventory_id")
   @Column(name = "material_inventory_id", columnDefinition = "bigint  COMMENT '物料仓库ID'", nullable = true)
   private Long materialInventoryId;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "sourceProjectId", value = "来源项目", notes = "来源项目")
   @JsonProperty("sourceProjectId")
   @JSONField(name = "sourceProjectId")
   @TableField("source_project_id")
   @Column(name = "source_project_id", columnDefinition = "bigint  COMMENT '来源项目'", nullable = true)
   private Long sourceProjectId;
   @ApiModelProperty(name = "sourceWarehouseId", value = "来源仓库", notes = "来源仓库")
   @JsonProperty("sourceWarehouseId")
   @JSONField(name = "sourceWarehouseId")
   @TableField("source_warehouse_id")
   @Column(name = "source_warehouse_id", columnDefinition = "bigint  COMMENT '来源仓库'", nullable = true)
   private Long sourceWarehouseId;
   @ApiModelProperty(name = "transferType", value = "调拨类型,参考枚举[TransferTypeEnum]", notes = "调拨类型,参考枚举[TransferTypeEnum]")
   @JsonProperty("transferType")
   @JSONField(name = "transferType")
   @TableField("transfer_type")
   @Column(name = "transfer_type", columnDefinition = "int  COMMENT '调拨类型,参考枚举[TransferTypeEnum]'", nullable = true)
   private Integer transferType;
   @ApiModelProperty(name = "quantity", value = "调拨数量", notes = "调拨数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '调拨数量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "remark", value = "调拨备注", notes = "调拨备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '调拨备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "mete", value = "调拨核算量", notes = "调拨核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '调拨核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "unitPrice", value = "加权价(含税)", notes = "加权价(含税)")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,12)  COMMENT '加权价(含税)'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "unitPriceExcludingVat", value = "不含税加权价", notes = "不含税加权价")
   @JsonProperty("unitPriceExcludingVat")
   @JSONField(name = "unitPriceExcludingVat")
   @TableField("unit_price_excluding_VAT")
   @Column(name = "unit_price_excluding_VAT", columnDefinition = "decimal(32,12)  COMMENT '不含税加权价'", nullable = true)
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty(name = "boolBorrow", value = "是否为调拨借用", notes = "是否为调拨借用")
   @JsonProperty("boolBorrow")
   @JSONField(name = "boolBorrow")
   @TableField("bool_borrow")
   @Column(name = "bool_borrow", columnDefinition = "tinyint(1)  COMMENT '是否为调拨借用'", nullable = true)
   private Boolean boolBorrow;
   @ApiModelProperty(name = "basicClass", value = "基础类型", notes = "基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "specification", value = "物料规格", notes = "物料规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '物料规格'", nullable = true)
   private String specification;
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
   @ApiModelProperty(name = "color", value = "颜色", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @TableField("color")
   @Column(name = "color", columnDefinition = "varchar(255)  COMMENT '颜色'", nullable = true)
   private String color;
   @ApiModelProperty(name = "scale", value = "小数保留位数", notes = "小数保留位数")
   @JsonProperty("scale")
   @JSONField(name = "scale")
   @TableField("scale")
   @Column(name = "scale", columnDefinition = "int  COMMENT '小数保留位数'", nullable = true)
   private Integer scale;
   @ApiModelProperty(name = "amount", value = "总价", notes = "总价")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税总价", notes = "不含税总价")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_vat")
   @Column(name = "amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '不含税总价'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "inputVat", value = "进项税", notes = "进项税")
   @JsonProperty("inputVat")
   @JSONField(name = "inputVat")
   @TableField("input_vat")
   @Column(name = "input_vat", columnDefinition = "decimal(32,12)  COMMENT '进项税'", nullable = true)
   private BigDecimal inputVat;
   @ApiModelProperty(name = "invoiceType", value = "票据类型", notes = "票据类型")
   @JsonProperty("invoiceType")
   @JSONField(name = "invoiceType")
   @TableField("invoice_type")
   @Column(name = "invoice_type", columnDefinition = "int  COMMENT '票据类型'", nullable = true)
   private Integer invoiceType;
   @ApiModelProperty(name = "materialIsWhole", value = "物料状态", notes = "物料状态")
   @JsonProperty("materialIsWhole")
   @JSONField(name = "materialIsWhole")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole", columnDefinition = "int  COMMENT '物料状态'", nullable = true)
   private Integer materialIsWhole;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(32,8)  COMMENT '税率'", nullable = true)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚度", notes = "理论厚度")
   @JsonProperty("theoryThickness")
   @JSONField(name = "theoryThickness")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness", columnDefinition = "decimal(32,8)  COMMENT '理论厚度'", nullable = true)
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "standardId", value = "执行国标ID", notes = "执行国标ID")
   @JsonProperty("standardId")
   @JSONField(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id", columnDefinition = "bigint  COMMENT '执行国标ID'", nullable = true)
   private Long standardId;
   @ApiModelProperty(name = "standardName", value = "执行国标名称", notes = "执行国标名称")
   @JsonProperty("standardName")
   @JSONField(name = "standardName")
   @TableField("standard_name")
   @Column(name = "standard_name", columnDefinition = "varchar(255)  COMMENT '执行国标名称'", nullable = true)
   private String standardName;
   @ApiModelProperty(name = "boolPartyA", value = "是否为甲供物料", notes = "是否为甲供物料")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否为甲供物料'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "sourceMonomerId", value = "来源单体ID", notes = "来源单体ID")
   @JsonProperty("sourceMonomerId")
   @JSONField(name = "sourceMonomerId")
   @TableField("source_monomer_id")
   @Column(name = "source_monomer_id", columnDefinition = "bigint  COMMENT '来源单体ID'", nullable = true)
   private Long sourceMonomerId;
   @ApiModelProperty(name = "sourceAreaId", value = "来源区域ID", notes = "来源区域ID")
   @JsonProperty("sourceAreaId")
   @JSONField(name = "sourceAreaId")
   @TableField("source_area_id")
   @Column(name = "source_area_id", columnDefinition = "bigint  COMMENT '来源区域ID'", nullable = true)
   private Long sourceAreaId;
   @ApiModelProperty(name = "materialSn", value = "物料编码", notes = "物料编码")
   @JsonProperty("materialSn")
   @JSONField(name = "materialSn")
   @TableField("material_sn")
   @Column(name = "material_sn", columnDefinition = "varchar(255)  COMMENT '物料编码'", nullable = true)
   private String materialSn;
   @ApiModelProperty(name = "sourceWorkshopId", value = "来源车间ID", notes = "来源车间ID")
   @JsonProperty("sourceWorkshopId")
   @JSONField(name = "sourceWorkshopId")
   @TableField("source_workshop_id")
   @Column(name = "source_workshop_id", columnDefinition = "bigint  COMMENT '来源车间ID'", nullable = true)
   private Long sourceWorkshopId;
   @ApiModelProperty(name = "unitPriceNoFreight", value = "加权价(含税) 不含运费", notes = "加权价(含税) 不含运费")
   @JsonProperty("unitPriceNoFreight")
   @JSONField(name = "unitPriceNoFreight")
   @TableField("unit_price_no_freight")
   @Column(name = "unit_price_no_freight", columnDefinition = "decimal(32,12)  COMMENT '加权价(含税) 不含运费'", nullable = true)
   private BigDecimal unitPriceNoFreight;
   @ApiModelProperty(name = "unitPriceExcludingVatNoFreight", value = "不含税加权价 不含运费", notes = "不含税加权价 不含运费")
   @JsonProperty("unitPriceExcludingVatNoFreight")
   @JSONField(name = "unitPriceExcludingVatNoFreight")
   @TableField("unit_price_excluding_VAT_no_freight")
   @Column(name = "unit_price_excluding_VAT_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税加权价 不含运费'", nullable = true)
   private BigDecimal unitPriceExcludingVatNoFreight;
   @ApiModelProperty(name = "amountNoFreight", value = "总价 不含运费", notes = "总价 不含运费")
   @JsonProperty("amountNoFreight")
   @JSONField(name = "amountNoFreight")
   @TableField("amount_no_freight")
   @Column(name = "amount_no_freight", columnDefinition = "decimal(32,12)  COMMENT '总价 不含运费'", nullable = true)
   private BigDecimal amountNoFreight;
   @ApiModelProperty(name = "amountExcludingVatNoFreight", value = "不含税总价 不含运费", notes = "不含税总价 不含运费")
   @JsonProperty("amountExcludingVatNoFreight")
   @JSONField(name = "amountExcludingVatNoFreight")
   @TableField("amount_excluding_vat_no_freight")
   @Column(name = "amount_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税总价 不含运费'", nullable = true)
   private BigDecimal amountExcludingVatNoFreight;
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
   @ApiModelProperty(name = "wapId", value = "加权价ID", notes = "加权价ID")
   @JsonProperty("wapId")
   @JSONField(name = "wapId")
   @TableField("wap_id")
   @Column(name = "wap_id", columnDefinition = "bigint(20)  COMMENT '加权价ID'", nullable = true)
   private Long wapId;

   public static TransferDetail.TransferDetailBuilder builder() {
      return new TransferDetail.TransferDetailBuilder();
   }

   public TransferDetail() {
   }

   public TransferDetail(
      final Long id,
      final Long transferId,
      final Long materialInventoryId,
      final Long classifyId,
      final Long sourceProjectId,
      final Long sourceWarehouseId,
      final Integer transferType,
      final BigDecimal quantity,
      final String remark,
      final BigDecimal mete,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVat,
      final Boolean boolBorrow,
      final Integer basicClass,
      final String specification,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final Integer scale,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final BigDecimal inputVat,
      final Integer invoiceType,
      final Integer materialIsWhole,
      final BigDecimal taxRate,
      final BigDecimal theoryThickness,
      final Long standardId,
      final String standardName,
      final Boolean boolPartyA,
      final Long sourceMonomerId,
      final Long sourceAreaId,
      final String materialSn,
      final Long sourceWorkshopId,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal unitPriceExcludingVatNoFreight,
      final BigDecimal amountNoFreight,
      final BigDecimal amountExcludingVatNoFreight,
      final BigDecimal inputVatNoFreight,
      final LocalDateTime realTime,
      final Long wapId
   ) {
      this.id = id;
      this.transferId = transferId;
      this.materialInventoryId = materialInventoryId;
      this.classifyId = classifyId;
      this.sourceProjectId = sourceProjectId;
      this.sourceWarehouseId = sourceWarehouseId;
      this.transferType = transferType;
      this.quantity = quantity;
      this.remark = remark;
      this.mete = mete;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.boolBorrow = boolBorrow;
      this.basicClass = basicClass;
      this.specification = specification;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.scale = scale;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.inputVat = inputVat;
      this.invoiceType = invoiceType;
      this.materialIsWhole = materialIsWhole;
      this.taxRate = taxRate;
      this.theoryThickness = theoryThickness;
      this.standardId = standardId;
      this.standardName = standardName;
      this.boolPartyA = boolPartyA;
      this.sourceMonomerId = sourceMonomerId;
      this.sourceAreaId = sourceAreaId;
      this.materialSn = materialSn;
      this.sourceWorkshopId = sourceWorkshopId;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      this.amountNoFreight = amountNoFreight;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.inputVatNoFreight = inputVatNoFreight;
      this.realTime = realTime;
      this.wapId = wapId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTransferId() {
      return this.transferId;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Long getSourceProjectId() {
      return this.sourceProjectId;
   }

   public Long getSourceWarehouseId() {
      return this.sourceWarehouseId;
   }

   public Integer getTransferType() {
      return this.transferType;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
   }

   public Boolean getBoolBorrow() {
      return this.boolBorrow;
   }

   public Integer getBasicClass() {
      return this.basicClass;
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

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public Integer getScale() {
      return this.scale;
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

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Long getSourceMonomerId() {
      return this.sourceMonomerId;
   }

   public Long getSourceAreaId() {
      return this.sourceAreaId;
   }

   public String getMaterialSn() {
      return this.materialSn;
   }

   public Long getSourceWorkshopId() {
      return this.sourceWorkshopId;
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

   public LocalDateTime getRealTime() {
      return this.realTime;
   }

   public Long getWapId() {
      return this.wapId;
   }

   @JsonProperty("id")
   public TransferDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("transferId")
   public TransferDetail setTransferId(final Long transferId) {
      this.transferId = transferId;
      return this;
   }

   @JsonProperty("materialInventoryId")
   public TransferDetail setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
      return this;
   }

   @JsonProperty("classifyId")
   public TransferDetail setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("sourceProjectId")
   public TransferDetail setSourceProjectId(final Long sourceProjectId) {
      this.sourceProjectId = sourceProjectId;
      return this;
   }

   @JsonProperty("sourceWarehouseId")
   public TransferDetail setSourceWarehouseId(final Long sourceWarehouseId) {
      this.sourceWarehouseId = sourceWarehouseId;
      return this;
   }

   @JsonProperty("transferType")
   public TransferDetail setTransferType(final Integer transferType) {
      this.transferType = transferType;
      return this;
   }

   @JsonProperty("quantity")
   public TransferDetail setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("remark")
   public TransferDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("mete")
   public TransferDetail setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("unitPrice")
   public TransferDetail setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("unitPriceExcludingVat")
   public TransferDetail setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   @JsonProperty("boolBorrow")
   public TransferDetail setBoolBorrow(final Boolean boolBorrow) {
      this.boolBorrow = boolBorrow;
      return this;
   }

   @JsonProperty("basicClass")
   public TransferDetail setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("specification")
   public TransferDetail setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public TransferDetail setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public TransferDetail setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public TransferDetail setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("brand")
   public TransferDetail setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public TransferDetail setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("color")
   public TransferDetail setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("scale")
   public TransferDetail setScale(final Integer scale) {
      this.scale = scale;
      return this;
   }

   @JsonProperty("amount")
   public TransferDetail setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public TransferDetail setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("inputVat")
   public TransferDetail setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   @JsonProperty("invoiceType")
   public TransferDetail setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("materialIsWhole")
   public TransferDetail setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   @JsonProperty("taxRate")
   public TransferDetail setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("theoryThickness")
   public TransferDetail setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("standardId")
   public TransferDetail setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public TransferDetail setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("boolPartyA")
   public TransferDetail setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("sourceMonomerId")
   public TransferDetail setSourceMonomerId(final Long sourceMonomerId) {
      this.sourceMonomerId = sourceMonomerId;
      return this;
   }

   @JsonProperty("sourceAreaId")
   public TransferDetail setSourceAreaId(final Long sourceAreaId) {
      this.sourceAreaId = sourceAreaId;
      return this;
   }

   @JsonProperty("materialSn")
   public TransferDetail setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
      return this;
   }

   @JsonProperty("sourceWorkshopId")
   public TransferDetail setSourceWorkshopId(final Long sourceWorkshopId) {
      this.sourceWorkshopId = sourceWorkshopId;
      return this;
   }

   @JsonProperty("unitPriceNoFreight")
   public TransferDetail setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
      return this;
   }

   @JsonProperty("unitPriceExcludingVatNoFreight")
   public TransferDetail setUnitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public TransferDetail setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public TransferDetail setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("inputVatNoFreight")
   public TransferDetail setInputVatNoFreight(final BigDecimal inputVatNoFreight) {
      this.inputVatNoFreight = inputVatNoFreight;
      return this;
   }

   @JsonProperty("realTime")
   public TransferDetail setRealTime(final LocalDateTime realTime) {
      this.realTime = realTime;
      return this;
   }

   @JsonProperty("wapId")
   public TransferDetail setWapId(final Long wapId) {
      this.wapId = wapId;
      return this;
   }

   @Override
   public String toString() {
      return "TransferDetail(id="
         + this.getId()
         + ", transferId="
         + this.getTransferId()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", classifyId="
         + this.getClassifyId()
         + ", sourceProjectId="
         + this.getSourceProjectId()
         + ", sourceWarehouseId="
         + this.getSourceWarehouseId()
         + ", transferType="
         + this.getTransferType()
         + ", quantity="
         + this.getQuantity()
         + ", remark="
         + this.getRemark()
         + ", mete="
         + this.getMete()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", boolBorrow="
         + this.getBoolBorrow()
         + ", basicClass="
         + this.getBasicClass()
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
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", scale="
         + this.getScale()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", taxRate="
         + this.getTaxRate()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", sourceMonomerId="
         + this.getSourceMonomerId()
         + ", sourceAreaId="
         + this.getSourceAreaId()
         + ", materialSn="
         + this.getMaterialSn()
         + ", sourceWorkshopId="
         + this.getSourceWorkshopId()
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
         + ", realTime="
         + this.getRealTime()
         + ", wapId="
         + this.getWapId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TransferDetail)) {
         return false;
      }

      TransferDetail other = (TransferDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$transferId = this.getTransferId();
         Object other$transferId = other.getTransferId();
         if (this$transferId == null ? other$transferId == null : this$transferId.equals(other$transferId)) {
            Object this$materialInventoryId = this.getMaterialInventoryId();
            Object other$materialInventoryId = other.getMaterialInventoryId();
            if (this$materialInventoryId == null ? other$materialInventoryId == null : this$materialInventoryId.equals(other$materialInventoryId)) {
               Object this$classifyId = this.getClassifyId();
               Object other$classifyId = other.getClassifyId();
               if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                  Object this$sourceProjectId = this.getSourceProjectId();
                  Object other$sourceProjectId = other.getSourceProjectId();
                  if (this$sourceProjectId == null ? other$sourceProjectId == null : this$sourceProjectId.equals(other$sourceProjectId)) {
                     Object this$sourceWarehouseId = this.getSourceWarehouseId();
                     Object other$sourceWarehouseId = other.getSourceWarehouseId();
                     if (this$sourceWarehouseId == null ? other$sourceWarehouseId == null : this$sourceWarehouseId.equals(other$sourceWarehouseId)) {
                        Object this$transferType = this.getTransferType();
                        Object other$transferType = other.getTransferType();
                        if (this$transferType == null ? other$transferType == null : this$transferType.equals(other$transferType)) {
                           Object this$boolBorrow = this.getBoolBorrow();
                           Object other$boolBorrow = other.getBoolBorrow();
                           if (this$boolBorrow == null ? other$boolBorrow == null : this$boolBorrow.equals(other$boolBorrow)) {
                              Object this$basicClass = this.getBasicClass();
                              Object other$basicClass = other.getBasicClass();
                              if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                                 Object this$scale = this.getScale();
                                 Object other$scale = other.getScale();
                                 if (this$scale == null ? other$scale == null : this$scale.equals(other$scale)) {
                                    Object this$invoiceType = this.getInvoiceType();
                                    Object other$invoiceType = other.getInvoiceType();
                                    if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                       Object this$materialIsWhole = this.getMaterialIsWhole();
                                       Object other$materialIsWhole = other.getMaterialIsWhole();
                                       if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
                                          Object this$standardId = this.getStandardId();
                                          Object other$standardId = other.getStandardId();
                                          if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                             Object this$boolPartyA = this.getBoolPartyA();
                                             Object other$boolPartyA = other.getBoolPartyA();
                                             if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                                                Object this$sourceMonomerId = this.getSourceMonomerId();
                                                Object other$sourceMonomerId = other.getSourceMonomerId();
                                                if (this$sourceMonomerId == null
                                                   ? other$sourceMonomerId == null
                                                   : this$sourceMonomerId.equals(other$sourceMonomerId)) {
                                                   Object this$sourceAreaId = this.getSourceAreaId();
                                                   Object other$sourceAreaId = other.getSourceAreaId();
                                                   if (this$sourceAreaId == null ? other$sourceAreaId == null : this$sourceAreaId.equals(other$sourceAreaId)) {
                                                      Object this$sourceWorkshopId = this.getSourceWorkshopId();
                                                      Object other$sourceWorkshopId = other.getSourceWorkshopId();
                                                      if (this$sourceWorkshopId == null
                                                         ? other$sourceWorkshopId == null
                                                         : this$sourceWorkshopId.equals(other$sourceWorkshopId)) {
                                                         Object this$wapId = this.getWapId();
                                                         Object other$wapId = other.getWapId();
                                                         if (this$wapId == null ? other$wapId == null : this$wapId.equals(other$wapId)) {
                                                            Object this$quantity = this.getQuantity();
                                                            Object other$quantity = other.getQuantity();
                                                            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                               Object this$remark = this.getRemark();
                                                               Object other$remark = other.getRemark();
                                                               if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                  Object this$mete = this.getMete();
                                                                  Object other$mete = other.getMete();
                                                                  if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
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
                                                                           Object this$specification = this.getSpecification();
                                                                           Object other$specification = other.getSpecification();
                                                                           if (this$specification == null
                                                                              ? other$specification == null
                                                                              : this$specification.equals(other$specification)) {
                                                                              Object this$length = this.getLength();
                                                                              Object other$length = other.getLength();
                                                                              if (this$length == null ? other$length == null : this$length.equals(other$length)
                                                                                 )
                                                                               {
                                                                                 Object this$width = this.getWidth();
                                                                                 Object other$width = other.getWidth();
                                                                                 if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                                                    Object this$thickness = this.getThickness();
                                                                                    Object other$thickness = other.getThickness();
                                                                                    if (this$thickness == null
                                                                                       ? other$thickness == null
                                                                                       : this$thickness.equals(other$thickness)) {
                                                                                       Object this$brand = this.getBrand();
                                                                                       Object other$brand = other.getBrand();
                                                                                       if (this$brand == null
                                                                                          ? other$brand == null
                                                                                          : this$brand.equals(other$brand)) {
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
                                                                                                Object this$amount = this.getAmount();
                                                                                                Object other$amount = other.getAmount();
                                                                                                if (this$amount == null
                                                                                                   ? other$amount == null
                                                                                                   : this$amount.equals(other$amount)) {
                                                                                                   Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                                                   Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                                                   if (this$amountExcludingVat == null
                                                                                                      ? other$amountExcludingVat == null
                                                                                                      : this$amountExcludingVat.equals(other$amountExcludingVat)
                                                                                                      )
                                                                                                    {
                                                                                                      Object this$inputVat = this.getInputVat();
                                                                                                      Object other$inputVat = other.getInputVat();
                                                                                                      if (this$inputVat == null
                                                                                                         ? other$inputVat == null
                                                                                                         : this$inputVat.equals(other$inputVat)) {
                                                                                                         Object this$taxRate = this.getTaxRate();
                                                                                                         Object other$taxRate = other.getTaxRate();
                                                                                                         if (this$taxRate == null
                                                                                                            ? other$taxRate == null
                                                                                                            : this$taxRate.equals(other$taxRate)) {
                                                                                                            Object this$theoryThickness = this.getTheoryThickness();
                                                                                                            Object other$theoryThickness = other.getTheoryThickness();
                                                                                                            if (this$theoryThickness == null
                                                                                                               ? other$theoryThickness == null
                                                                                                               : this$theoryThickness.equals(
                                                                                                                  other$theoryThickness
                                                                                                               )) {
                                                                                                               Object this$standardName = this.getStandardName();
                                                                                                               Object other$standardName = other.getStandardName();
                                                                                                               if (this$standardName == null
                                                                                                                  ? other$standardName == null
                                                                                                                  : this$standardName.equals(other$standardName)
                                                                                                                  )
                                                                                                                {
                                                                                                                  Object this$materialSn = this.getMaterialSn();
                                                                                                                  Object other$materialSn = other.getMaterialSn();
                                                                                                                  if (this$materialSn == null
                                                                                                                     ? other$materialSn == null
                                                                                                                     : this$materialSn.equals(other$materialSn)
                                                                                                                     )
                                                                                                                   {
                                                                                                                     Object this$unitPriceNoFreight = this.getUnitPriceNoFreight();
                                                                                                                     Object other$unitPriceNoFreight = other.getUnitPriceNoFreight();
                                                                                                                     if (this$unitPriceNoFreight == null
                                                                                                                        ? other$unitPriceNoFreight == null
                                                                                                                        : this$unitPriceNoFreight.equals(
                                                                                                                           other$unitPriceNoFreight
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
                                                                                                                           Object this$amountNoFreight = this.getAmountNoFreight();
                                                                                                                           Object other$amountNoFreight = other.getAmountNoFreight();
                                                                                                                           if (this$amountNoFreight == null
                                                                                                                              ? other$amountNoFreight == null
                                                                                                                              : this$amountNoFreight.equals(
                                                                                                                                 other$amountNoFreight
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
                                                                                                                                       ? other$realTime == null
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TransferDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $transferId = this.getTransferId();
      result = result * 59 + ($transferId == null ? 43 : $transferId.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $sourceProjectId = this.getSourceProjectId();
      result = result * 59 + ($sourceProjectId == null ? 43 : $sourceProjectId.hashCode());
      Object $sourceWarehouseId = this.getSourceWarehouseId();
      result = result * 59 + ($sourceWarehouseId == null ? 43 : $sourceWarehouseId.hashCode());
      Object $transferType = this.getTransferType();
      result = result * 59 + ($transferType == null ? 43 : $transferType.hashCode());
      Object $boolBorrow = this.getBoolBorrow();
      result = result * 59 + ($boolBorrow == null ? 43 : $boolBorrow.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $scale = this.getScale();
      result = result * 59 + ($scale == null ? 43 : $scale.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $sourceMonomerId = this.getSourceMonomerId();
      result = result * 59 + ($sourceMonomerId == null ? 43 : $sourceMonomerId.hashCode());
      Object $sourceAreaId = this.getSourceAreaId();
      result = result * 59 + ($sourceAreaId == null ? 43 : $sourceAreaId.hashCode());
      Object $sourceWorkshopId = this.getSourceWorkshopId();
      result = result * 59 + ($sourceWorkshopId == null ? 43 : $sourceWorkshopId.hashCode());
      Object $wapId = this.getWapId();
      result = result * 59 + ($wapId == null ? 43 : $wapId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
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
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
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
      result = result * 59 + ($inputVatNoFreight == null ? 43 : $inputVatNoFreight.hashCode());
      Object $realTime = this.getRealTime();
      return result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
   }

   public static class TransferDetailBuilder {
      private Long id;
      private Long transferId;
      private Long materialInventoryId;
      private Long classifyId;
      private Long sourceProjectId;
      private Long sourceWarehouseId;
      private Integer transferType;
      private BigDecimal quantity;
      private String remark;
      private BigDecimal mete;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVat;
      private Boolean boolBorrow;
      private Integer basicClass;
      private String specification;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private Integer scale;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private BigDecimal inputVat;
      private Integer invoiceType;
      private Integer materialIsWhole;
      private BigDecimal taxRate;
      private BigDecimal theoryThickness;
      private Long standardId;
      private String standardName;
      private Boolean boolPartyA;
      private Long sourceMonomerId;
      private Long sourceAreaId;
      private String materialSn;
      private Long sourceWorkshopId;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal unitPriceExcludingVatNoFreight;
      private BigDecimal amountNoFreight;
      private BigDecimal amountExcludingVatNoFreight;
      private BigDecimal inputVatNoFreight;
      private LocalDateTime realTime;
      private Long wapId;

      TransferDetailBuilder() {
      }

      @JsonProperty("id")
      public TransferDetail.TransferDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("transferId")
      public TransferDetail.TransferDetailBuilder transferId(final Long transferId) {
         this.transferId = transferId;
         return this;
      }

      @JsonProperty("materialInventoryId")
      public TransferDetail.TransferDetailBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      @JsonProperty("classifyId")
      public TransferDetail.TransferDetailBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("sourceProjectId")
      public TransferDetail.TransferDetailBuilder sourceProjectId(final Long sourceProjectId) {
         this.sourceProjectId = sourceProjectId;
         return this;
      }

      @JsonProperty("sourceWarehouseId")
      public TransferDetail.TransferDetailBuilder sourceWarehouseId(final Long sourceWarehouseId) {
         this.sourceWarehouseId = sourceWarehouseId;
         return this;
      }

      @JsonProperty("transferType")
      public TransferDetail.TransferDetailBuilder transferType(final Integer transferType) {
         this.transferType = transferType;
         return this;
      }

      @JsonProperty("quantity")
      public TransferDetail.TransferDetailBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("remark")
      public TransferDetail.TransferDetailBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("mete")
      public TransferDetail.TransferDetailBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("unitPrice")
      public TransferDetail.TransferDetailBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("unitPriceExcludingVat")
      public TransferDetail.TransferDetailBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      @JsonProperty("boolBorrow")
      public TransferDetail.TransferDetailBuilder boolBorrow(final Boolean boolBorrow) {
         this.boolBorrow = boolBorrow;
         return this;
      }

      @JsonProperty("basicClass")
      public TransferDetail.TransferDetailBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("specification")
      public TransferDetail.TransferDetailBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public TransferDetail.TransferDetailBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public TransferDetail.TransferDetailBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public TransferDetail.TransferDetailBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("brand")
      public TransferDetail.TransferDetailBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public TransferDetail.TransferDetailBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("color")
      public TransferDetail.TransferDetailBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("scale")
      public TransferDetail.TransferDetailBuilder scale(final Integer scale) {
         this.scale = scale;
         return this;
      }

      @JsonProperty("amount")
      public TransferDetail.TransferDetailBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public TransferDetail.TransferDetailBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("inputVat")
      public TransferDetail.TransferDetailBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      @JsonProperty("invoiceType")
      public TransferDetail.TransferDetailBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public TransferDetail.TransferDetailBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("taxRate")
      public TransferDetail.TransferDetailBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("theoryThickness")
      public TransferDetail.TransferDetailBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("standardId")
      public TransferDetail.TransferDetailBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public TransferDetail.TransferDetailBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("boolPartyA")
      public TransferDetail.TransferDetailBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("sourceMonomerId")
      public TransferDetail.TransferDetailBuilder sourceMonomerId(final Long sourceMonomerId) {
         this.sourceMonomerId = sourceMonomerId;
         return this;
      }

      @JsonProperty("sourceAreaId")
      public TransferDetail.TransferDetailBuilder sourceAreaId(final Long sourceAreaId) {
         this.sourceAreaId = sourceAreaId;
         return this;
      }

      @JsonProperty("materialSn")
      public TransferDetail.TransferDetailBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      @JsonProperty("sourceWorkshopId")
      public TransferDetail.TransferDetailBuilder sourceWorkshopId(final Long sourceWorkshopId) {
         this.sourceWorkshopId = sourceWorkshopId;
         return this;
      }

      @JsonProperty("unitPriceNoFreight")
      public TransferDetail.TransferDetailBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      @JsonProperty("unitPriceExcludingVatNoFreight")
      public TransferDetail.TransferDetailBuilder unitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
         this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("amountNoFreight")
      public TransferDetail.TransferDetailBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      @JsonProperty("amountExcludingVatNoFreight")
      public TransferDetail.TransferDetailBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("inputVatNoFreight")
      public TransferDetail.TransferDetailBuilder inputVatNoFreight(final BigDecimal inputVatNoFreight) {
         this.inputVatNoFreight = inputVatNoFreight;
         return this;
      }

      @JsonProperty("realTime")
      public TransferDetail.TransferDetailBuilder realTime(final LocalDateTime realTime) {
         this.realTime = realTime;
         return this;
      }

      @JsonProperty("wapId")
      public TransferDetail.TransferDetailBuilder wapId(final Long wapId) {
         this.wapId = wapId;
         return this;
      }

      public TransferDetail build() {
         return new TransferDetail(
            this.id,
            this.transferId,
            this.materialInventoryId,
            this.classifyId,
            this.sourceProjectId,
            this.sourceWarehouseId,
            this.transferType,
            this.quantity,
            this.remark,
            this.mete,
            this.unitPrice,
            this.unitPriceExcludingVat,
            this.boolBorrow,
            this.basicClass,
            this.specification,
            this.length,
            this.width,
            this.thickness,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.scale,
            this.amount,
            this.amountExcludingVat,
            this.inputVat,
            this.invoiceType,
            this.materialIsWhole,
            this.taxRate,
            this.theoryThickness,
            this.standardId,
            this.standardName,
            this.boolPartyA,
            this.sourceMonomerId,
            this.sourceAreaId,
            this.materialSn,
            this.sourceWorkshopId,
            this.unitPriceNoFreight,
            this.unitPriceExcludingVatNoFreight,
            this.amountNoFreight,
            this.amountExcludingVatNoFreight,
            this.inputVatNoFreight,
            this.realTime,
            this.wapId
         );
      }

      @Override
      public String toString() {
         return "TransferDetail.TransferDetailBuilder(id="
            + this.id
            + ", transferId="
            + this.transferId
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", classifyId="
            + this.classifyId
            + ", sourceProjectId="
            + this.sourceProjectId
            + ", sourceWarehouseId="
            + this.sourceWarehouseId
            + ", transferType="
            + this.transferType
            + ", quantity="
            + this.quantity
            + ", remark="
            + this.remark
            + ", mete="
            + this.mete
            + ", unitPrice="
            + this.unitPrice
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", boolBorrow="
            + this.boolBorrow
            + ", basicClass="
            + this.basicClass
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
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", scale="
            + this.scale
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", inputVat="
            + this.inputVat
            + ", invoiceType="
            + this.invoiceType
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", taxRate="
            + this.taxRate
            + ", theoryThickness="
            + this.theoryThickness
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", boolPartyA="
            + this.boolPartyA
            + ", sourceMonomerId="
            + this.sourceMonomerId
            + ", sourceAreaId="
            + this.sourceAreaId
            + ", materialSn="
            + this.materialSn
            + ", sourceWorkshopId="
            + this.sourceWorkshopId
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
            + ", realTime="
            + this.realTime
            + ", wapId="
            + this.wapId
            + ")";
      }
   }
}
