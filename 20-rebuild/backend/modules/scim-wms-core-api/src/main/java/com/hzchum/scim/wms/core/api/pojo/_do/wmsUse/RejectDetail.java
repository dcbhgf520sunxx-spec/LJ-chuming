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

@ApiModel(value = "RejectDetail对象", description = "退货详情表")
@Entity
@TableName("wms_reject_detail")
@Table(name = "wms_reject_detail")
public class RejectDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "basicClass", value = "基础分类", notes = "基础分类")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '基础分类'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(255)  COMMENT '品牌'", nullable = true)
   private String brand;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
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
   @ApiModelProperty(name = "length", value = "长", notes = "长")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,8)  COMMENT '长'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "materialIsWhole", value = "物料状态", notes = "物料状态")
   @JsonProperty("materialIsWhole")
   @JSONField(name = "materialIsWhole")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole", columnDefinition = "int  COMMENT '物料状态'", nullable = true)
   private Integer materialIsWhole;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "quantity", value = "计量量", notes = "计量量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '计量量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "rejectId", value = "退库单ID", notes = "退库单ID")
   @JsonProperty("rejectId")
   @JSONField(name = "rejectId")
   @TableField("reject_id")
   @Column(name = "reject_id", columnDefinition = "bigint  COMMENT '退库单ID'", nullable = true)
   private Long rejectId;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚", notes = "理论厚")
   @JsonProperty("theoryThickness")
   @JSONField(name = "theoryThickness")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness", columnDefinition = "decimal(32,8)  COMMENT '理论厚'", nullable = true)
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "thickness", value = "厚", notes = "厚")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8)  COMMENT '厚'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "boolPartyA", value = "是否为甲供", notes = "是否为甲供")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否为甲供'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "warehouseId", value = "存储位置ID", notes = "存储位置ID")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '存储位置ID'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "warehouseType", value = "仓库类型", notes = "仓库类型")
   @JsonProperty("warehouseType")
   @JSONField(name = "warehouseType")
   @TableField("warehouse_type")
   @Column(name = "warehouse_type", columnDefinition = "int  COMMENT '仓库类型'", nullable = true)
   private Integer warehouseType;
   @ApiModelProperty(name = "width", value = "宽", notes = "宽")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,8)  COMMENT '宽'", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "materialInventoryId", value = "物料仓ID", notes = "物料仓ID")
   @JsonProperty("materialInventoryId")
   @JSONField(name = "materialInventoryId")
   @TableField("material_inventory_id")
   @Column(name = "material_inventory_id", columnDefinition = "bigint  COMMENT '物料仓ID'", nullable = true)
   private Long materialInventoryId;
   @ApiModelProperty(name = "inboundDetailId", value = "入库详情ID", notes = "入库详情ID")
   @JsonProperty("inboundDetailId")
   @JSONField(name = "inboundDetailId")
   @TableField("inbound_detail_id")
   @Column(name = "inbound_detail_id", columnDefinition = "bigint  COMMENT '入库详情ID'", nullable = true)
   private Long inboundDetailId;
   @ApiModelProperty(name = "unitNet", value = "单位净量", notes = "单位净量")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(32,8)  COMMENT '单位净量'", nullable = true)
   private BigDecimal unitNet;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 [InvoiceTypeEnum]", notes = "发票类型 [InvoiceTypeEnum]")
   @JsonProperty("invoiceType")
   @JSONField(name = "invoiceType")
   @TableField("invoice_type")
   @Column(name = "invoice_type", columnDefinition = "int  COMMENT '发票类型 [InvoiceTypeEnum]'", nullable = true)
   private Integer invoiceType;
   @ApiModelProperty(name = "taxRate", value = "税率(百分比)", notes = "税率(百分比)")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate", columnDefinition = "decimal(32,8)  COMMENT '税率(百分比)'", nullable = true)
   private BigDecimal taxRate;
   @ApiModelProperty(name = "standardId", value = "型材执行国标ID", notes = "型材执行国标ID")
   @JsonProperty("standardId")
   @JSONField(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id", columnDefinition = "bigint  COMMENT '型材执行国标ID'", nullable = true)
   private Long standardId;
   @ApiModelProperty(name = "standardName", value = "型材执行国标名称", notes = "型材执行国标名称")
   @JsonProperty("standardName")
   @JSONField(name = "standardName")
   @TableField("standard_name")
   @Column(name = "standard_name", columnDefinition = "varchar(255)  COMMENT '型材执行国标名称'", nullable = true)
   private String standardName;
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
   @ApiModelProperty(name = "materialSn")
   @JsonProperty("materialSn")
   @JSONField(name = "materialSn")
   @TableField("material_sn")
   @Column(name = "material_sn", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String materialSn;
   @ApiModelProperty(name = "workshopId")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long workshopId;
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
   @ApiModelProperty(name = "amountNoFreight", value = "总价不含运费", notes = "总价不含运费")
   @JsonProperty("amountNoFreight")
   @JSONField(name = "amountNoFreight")
   @TableField("amount_no_freight")
   @Column(name = "amount_no_freight", columnDefinition = "decimal(32,12)  COMMENT '总价不含运费'", nullable = true)
   private BigDecimal amountNoFreight;
   @ApiModelProperty(name = "amountExcludingVatNoFreight", value = "不含税总价不含运费", notes = "不含税总价不含运费")
   @JsonProperty("amountExcludingVatNoFreight")
   @JSONField(name = "amountExcludingVatNoFreight")
   @TableField("amount_excluding_vat_no_freight")
   @Column(name = "amount_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税总价不含运费'", nullable = true)
   private BigDecimal amountExcludingVatNoFreight;
   @ApiModelProperty(name = "inputVatNoFreight", value = "进项税不含运费", notes = "进项税不含运费")
   @JsonProperty("inputVatNoFreight")
   @JSONField(name = "inputVatNoFreight")
   @TableField("input_vat_no_freight")
   @Column(name = "input_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '进项税不含运费'", nullable = true)
   private BigDecimal inputVatNoFreight;
   @ApiModelProperty(name = "unitPriceNoFreight", value = "单价不含运费", notes = "单价不含运费")
   @JsonProperty("unitPriceNoFreight")
   @JSONField(name = "unitPriceNoFreight")
   @TableField("unit_price_no_freight")
   @Column(name = "unit_price_no_freight", columnDefinition = "decimal(32,12)  COMMENT '单价不含运费'", nullable = true)
   private BigDecimal unitPriceNoFreight;
   @ApiModelProperty(name = "unitPriceExcludingVatNoFreight", value = "不含税单价不含运费", notes = "不含税单价不含运费")
   @JsonProperty("unitPriceExcludingVatNoFreight")
   @JSONField(name = "unitPriceExcludingVatNoFreight")
   @TableField("unit_price_excluding_vat_no_freight")
   @Column(name = "unit_price_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税单价不含运费'", nullable = true)
   private BigDecimal unitPriceExcludingVatNoFreight;
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
   @ApiModelProperty(name = "reviewStatus", value = "审核状态[1 待审核,2 审核通过, 15 该出库单已被删除]")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status")
   private Integer reviewStatus;

   public static RejectDetail.RejectDetailBuilder builder() {
      return new RejectDetail.RejectDetailBuilder();
   }

   public RejectDetail() {
   }

   public RejectDetail(
      final Long id,
      final Integer basicClass,
      final String brand,
      final Long classifyId,
      final String color,
      final String heatNoAndBatchNo,
      final BigDecimal length,
      final Integer materialIsWhole,
      final Long projectId,
      final BigDecimal quantity,
      final Long rejectId,
      final String remark,
      final String specification,
      final BigDecimal theoryThickness,
      final BigDecimal thickness,
      final Boolean boolPartyA,
      final Long warehouseId,
      final Integer warehouseType,
      final BigDecimal width,
      final BigDecimal mete,
      final Long materialInventoryId,
      final Long inboundDetailId,
      final BigDecimal unitNet,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final Long standardId,
      final String standardName,
      final Long monomerId,
      final Long areaId,
      final String materialSn,
      final Long workshopId,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final BigDecimal inputVat,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal amountNoFreight,
      final BigDecimal amountExcludingVatNoFreight,
      final BigDecimal inputVatNoFreight,
      final BigDecimal unitPriceNoFreight,
      final BigDecimal unitPriceExcludingVatNoFreight,
      final LocalDateTime realTime,
      final Long wapId,
      final Integer reviewStatus
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.brand = brand;
      this.classifyId = classifyId;
      this.color = color;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.length = length;
      this.materialIsWhole = materialIsWhole;
      this.projectId = projectId;
      this.quantity = quantity;
      this.rejectId = rejectId;
      this.remark = remark;
      this.specification = specification;
      this.theoryThickness = theoryThickness;
      this.thickness = thickness;
      this.boolPartyA = boolPartyA;
      this.warehouseId = warehouseId;
      this.warehouseType = warehouseType;
      this.width = width;
      this.mete = mete;
      this.materialInventoryId = materialInventoryId;
      this.inboundDetailId = inboundDetailId;
      this.unitNet = unitNet;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.standardId = standardId;
      this.standardName = standardName;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.materialSn = materialSn;
      this.workshopId = workshopId;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.inputVat = inputVat;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.amountNoFreight = amountNoFreight;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.inputVatNoFreight = inputVatNoFreight;
      this.unitPriceNoFreight = unitPriceNoFreight;
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      this.realTime = realTime;
      this.wapId = wapId;
      this.reviewStatus = reviewStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getBrand() {
      return this.brand;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getColor() {
      return this.color;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Long getRejectId() {
      return this.rejectId;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public Long getInboundDetailId() {
      return this.inboundDetailId;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
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

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getMaterialSn() {
      return this.materialSn;
   }

   public Long getWorkshopId() {
      return this.workshopId;
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

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
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

   public BigDecimal getUnitPriceNoFreight() {
      return this.unitPriceNoFreight;
   }

   public BigDecimal getUnitPriceExcludingVatNoFreight() {
      return this.unitPriceExcludingVatNoFreight;
   }

   public LocalDateTime getRealTime() {
      return this.realTime;
   }

   public Long getWapId() {
      return this.wapId;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   @JsonProperty("id")
   public RejectDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("basicClass")
   public RejectDetail setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("brand")
   public RejectDetail setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("classifyId")
   public RejectDetail setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("color")
   public RejectDetail setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public RejectDetail setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("length")
   public RejectDetail setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("materialIsWhole")
   public RejectDetail setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   @JsonProperty("projectId")
   public RejectDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("quantity")
   public RejectDetail setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("rejectId")
   public RejectDetail setRejectId(final Long rejectId) {
      this.rejectId = rejectId;
      return this;
   }

   @JsonProperty("remark")
   public RejectDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("specification")
   public RejectDetail setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("theoryThickness")
   public RejectDetail setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("thickness")
   public RejectDetail setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("boolPartyA")
   public RejectDetail setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("warehouseId")
   public RejectDetail setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("warehouseType")
   public RejectDetail setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   @JsonProperty("width")
   public RejectDetail setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("mete")
   public RejectDetail setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("materialInventoryId")
   public RejectDetail setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
      return this;
   }

   @JsonProperty("inboundDetailId")
   public RejectDetail setInboundDetailId(final Long inboundDetailId) {
      this.inboundDetailId = inboundDetailId;
      return this;
   }

   @JsonProperty("unitNet")
   public RejectDetail setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("invoiceType")
   public RejectDetail setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("taxRate")
   public RejectDetail setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("standardId")
   public RejectDetail setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public RejectDetail setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("monomerId")
   public RejectDetail setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public RejectDetail setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("materialSn")
   public RejectDetail setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
      return this;
   }

   @JsonProperty("workshopId")
   public RejectDetail setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("amount")
   public RejectDetail setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public RejectDetail setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("inputVat")
   public RejectDetail setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
      return this;
   }

   @JsonProperty("unitPrice")
   public RejectDetail setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("unitPriceExcludingVat")
   public RejectDetail setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public RejectDetail setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public RejectDetail setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("inputVatNoFreight")
   public RejectDetail setInputVatNoFreight(final BigDecimal inputVatNoFreight) {
      this.inputVatNoFreight = inputVatNoFreight;
      return this;
   }

   @JsonProperty("unitPriceNoFreight")
   public RejectDetail setUnitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
      this.unitPriceNoFreight = unitPriceNoFreight;
      return this;
   }

   @JsonProperty("unitPriceExcludingVatNoFreight")
   public RejectDetail setUnitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
      this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("realTime")
   public RejectDetail setRealTime(final LocalDateTime realTime) {
      this.realTime = realTime;
      return this;
   }

   @JsonProperty("wapId")
   public RejectDetail setWapId(final Long wapId) {
      this.wapId = wapId;
      return this;
   }

   @JsonProperty("reviewStatus")
   public RejectDetail setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @Override
   public String toString() {
      return "RejectDetail(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", brand="
         + this.getBrand()
         + ", classifyId="
         + this.getClassifyId()
         + ", color="
         + this.getColor()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", length="
         + this.getLength()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", projectId="
         + this.getProjectId()
         + ", quantity="
         + this.getQuantity()
         + ", rejectId="
         + this.getRejectId()
         + ", remark="
         + this.getRemark()
         + ", specification="
         + this.getSpecification()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", thickness="
         + this.getThickness()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", width="
         + this.getWidth()
         + ", mete="
         + this.getMete()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", inboundDetailId="
         + this.getInboundDetailId()
         + ", unitNet="
         + this.getUnitNet()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", materialSn="
         + this.getMaterialSn()
         + ", workshopId="
         + this.getWorkshopId()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", amountExcludingVatNoFreight="
         + this.getAmountExcludingVatNoFreight()
         + ", inputVatNoFreight="
         + this.getInputVatNoFreight()
         + ", unitPriceNoFreight="
         + this.getUnitPriceNoFreight()
         + ", unitPriceExcludingVatNoFreight="
         + this.getUnitPriceExcludingVatNoFreight()
         + ", realTime="
         + this.getRealTime()
         + ", wapId="
         + this.getWapId()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RejectDetail)) {
         return false;
      }

      RejectDetail other = (RejectDetail)o;
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
               Object this$materialIsWhole = this.getMaterialIsWhole();
               Object other$materialIsWhole = other.getMaterialIsWhole();
               if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$rejectId = this.getRejectId();
                     Object other$rejectId = other.getRejectId();
                     if (this$rejectId == null ? other$rejectId == null : this$rejectId.equals(other$rejectId)) {
                        Object this$boolPartyA = this.getBoolPartyA();
                        Object other$boolPartyA = other.getBoolPartyA();
                        if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                           Object this$warehouseId = this.getWarehouseId();
                           Object other$warehouseId = other.getWarehouseId();
                           if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                              Object this$warehouseType = this.getWarehouseType();
                              Object other$warehouseType = other.getWarehouseType();
                              if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
                                 Object this$materialInventoryId = this.getMaterialInventoryId();
                                 Object other$materialInventoryId = other.getMaterialInventoryId();
                                 if (this$materialInventoryId == null
                                    ? other$materialInventoryId == null
                                    : this$materialInventoryId.equals(other$materialInventoryId)) {
                                    Object this$inboundDetailId = this.getInboundDetailId();
                                    Object other$inboundDetailId = other.getInboundDetailId();
                                    if (this$inboundDetailId == null ? other$inboundDetailId == null : this$inboundDetailId.equals(other$inboundDetailId)) {
                                       Object this$invoiceType = this.getInvoiceType();
                                       Object other$invoiceType = other.getInvoiceType();
                                       if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                          Object this$standardId = this.getStandardId();
                                          Object other$standardId = other.getStandardId();
                                          if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                             Object this$monomerId = this.getMonomerId();
                                             Object other$monomerId = other.getMonomerId();
                                             if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                                Object this$areaId = this.getAreaId();
                                                Object other$areaId = other.getAreaId();
                                                if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                                   Object this$workshopId = this.getWorkshopId();
                                                   Object other$workshopId = other.getWorkshopId();
                                                   if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                                      Object this$wapId = this.getWapId();
                                                      Object other$wapId = other.getWapId();
                                                      if (this$wapId == null ? other$wapId == null : this$wapId.equals(other$wapId)) {
                                                         Object this$reviewStatus = this.getReviewStatus();
                                                         Object other$reviewStatus = other.getReviewStatus();
                                                         if (this$reviewStatus == null
                                                            ? other$reviewStatus == null
                                                            : this$reviewStatus.equals(other$reviewStatus)) {
                                                            Object this$brand = this.getBrand();
                                                            Object other$brand = other.getBrand();
                                                            if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                               Object this$color = this.getColor();
                                                               Object other$color = other.getColor();
                                                               if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                  Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                  Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                  if (this$heatNoAndBatchNo == null
                                                                     ? other$heatNoAndBatchNo == null
                                                                     : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                     Object this$length = this.getLength();
                                                                     Object other$length = other.getLength();
                                                                     if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                        Object this$quantity = this.getQuantity();
                                                                        Object other$quantity = other.getQuantity();
                                                                        if (this$quantity == null
                                                                           ? other$quantity == null
                                                                           : this$quantity.equals(other$quantity)) {
                                                                           Object this$remark = this.getRemark();
                                                                           Object other$remark = other.getRemark();
                                                                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                              Object this$specification = this.getSpecification();
                                                                              Object other$specification = other.getSpecification();
                                                                              if (this$specification == null
                                                                                 ? other$specification == null
                                                                                 : this$specification.equals(other$specification)) {
                                                                                 Object this$theoryThickness = this.getTheoryThickness();
                                                                                 Object other$theoryThickness = other.getTheoryThickness();
                                                                                 if (this$theoryThickness == null
                                                                                    ? other$theoryThickness == null
                                                                                    : this$theoryThickness.equals(other$theoryThickness)) {
                                                                                    Object this$thickness = this.getThickness();
                                                                                    Object other$thickness = other.getThickness();
                                                                                    if (this$thickness == null
                                                                                       ? other$thickness == null
                                                                                       : this$thickness.equals(other$thickness)) {
                                                                                       Object this$width = this.getWidth();
                                                                                       Object other$width = other.getWidth();
                                                                                       if (this$width == null
                                                                                          ? other$width == null
                                                                                          : this$width.equals(other$width)) {
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
                                                                                                      Object this$materialSn = this.getMaterialSn();
                                                                                                      Object other$materialSn = other.getMaterialSn();
                                                                                                      if (this$materialSn == null
                                                                                                         ? other$materialSn == null
                                                                                                         : this$materialSn.equals(other$materialSn)) {
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
                                                                                                                                 Object this$unitPriceNoFreight = this.getUnitPriceNoFreight();
                                                                                                                                 Object other$unitPriceNoFreight = other.getUnitPriceNoFreight();
                                                                                                                                 if (this$unitPriceNoFreight
                                                                                                                                       == null
                                                                                                                                    ? other$unitPriceNoFreight
                                                                                                                                       == null
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
      return other instanceof RejectDetail;
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
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $rejectId = this.getRejectId();
      result = result * 59 + ($rejectId == null ? 43 : $rejectId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $inboundDetailId = this.getInboundDetailId();
      result = result * 59 + ($inboundDetailId == null ? 43 : $inboundDetailId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $wapId = this.getWapId();
      result = result * 59 + ($wapId == null ? 43 : $wapId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $materialSn = this.getMaterialSn();
      result = result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
      result = result * 59 + ($amountExcludingVatNoFreight == null ? 43 : $amountExcludingVatNoFreight.hashCode());
      Object $inputVatNoFreight = this.getInputVatNoFreight();
      result = result * 59 + ($inputVatNoFreight == null ? 43 : $inputVatNoFreight.hashCode());
      Object $unitPriceNoFreight = this.getUnitPriceNoFreight();
      result = result * 59 + ($unitPriceNoFreight == null ? 43 : $unitPriceNoFreight.hashCode());
      Object $unitPriceExcludingVatNoFreight = this.getUnitPriceExcludingVatNoFreight();
      result = result * 59 + ($unitPriceExcludingVatNoFreight == null ? 43 : $unitPriceExcludingVatNoFreight.hashCode());
      Object $realTime = this.getRealTime();
      return result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
   }

   public static class RejectDetailBuilder {
      private Long id;
      private Integer basicClass;
      private String brand;
      private Long classifyId;
      private String color;
      private String heatNoAndBatchNo;
      private BigDecimal length;
      private Integer materialIsWhole;
      private Long projectId;
      private BigDecimal quantity;
      private Long rejectId;
      private String remark;
      private String specification;
      private BigDecimal theoryThickness;
      private BigDecimal thickness;
      private Boolean boolPartyA;
      private Long warehouseId;
      private Integer warehouseType;
      private BigDecimal width;
      private BigDecimal mete;
      private Long materialInventoryId;
      private Long inboundDetailId;
      private BigDecimal unitNet;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private Long standardId;
      private String standardName;
      private Long monomerId;
      private Long areaId;
      private String materialSn;
      private Long workshopId;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private BigDecimal inputVat;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal amountNoFreight;
      private BigDecimal amountExcludingVatNoFreight;
      private BigDecimal inputVatNoFreight;
      private BigDecimal unitPriceNoFreight;
      private BigDecimal unitPriceExcludingVatNoFreight;
      private LocalDateTime realTime;
      private Long wapId;
      private Integer reviewStatus;

      RejectDetailBuilder() {
      }

      @JsonProperty("id")
      public RejectDetail.RejectDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("basicClass")
      public RejectDetail.RejectDetailBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("brand")
      public RejectDetail.RejectDetailBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("classifyId")
      public RejectDetail.RejectDetailBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("color")
      public RejectDetail.RejectDetailBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public RejectDetail.RejectDetailBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("length")
      public RejectDetail.RejectDetailBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public RejectDetail.RejectDetailBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("projectId")
      public RejectDetail.RejectDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("quantity")
      public RejectDetail.RejectDetailBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("rejectId")
      public RejectDetail.RejectDetailBuilder rejectId(final Long rejectId) {
         this.rejectId = rejectId;
         return this;
      }

      @JsonProperty("remark")
      public RejectDetail.RejectDetailBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("specification")
      public RejectDetail.RejectDetailBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("theoryThickness")
      public RejectDetail.RejectDetailBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("thickness")
      public RejectDetail.RejectDetailBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("boolPartyA")
      public RejectDetail.RejectDetailBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("warehouseId")
      public RejectDetail.RejectDetailBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("warehouseType")
      public RejectDetail.RejectDetailBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      @JsonProperty("width")
      public RejectDetail.RejectDetailBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("mete")
      public RejectDetail.RejectDetailBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("materialInventoryId")
      public RejectDetail.RejectDetailBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      @JsonProperty("inboundDetailId")
      public RejectDetail.RejectDetailBuilder inboundDetailId(final Long inboundDetailId) {
         this.inboundDetailId = inboundDetailId;
         return this;
      }

      @JsonProperty("unitNet")
      public RejectDetail.RejectDetailBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("invoiceType")
      public RejectDetail.RejectDetailBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("taxRate")
      public RejectDetail.RejectDetailBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("standardId")
      public RejectDetail.RejectDetailBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public RejectDetail.RejectDetailBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("monomerId")
      public RejectDetail.RejectDetailBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public RejectDetail.RejectDetailBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("materialSn")
      public RejectDetail.RejectDetailBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      @JsonProperty("workshopId")
      public RejectDetail.RejectDetailBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("amount")
      public RejectDetail.RejectDetailBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public RejectDetail.RejectDetailBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("inputVat")
      public RejectDetail.RejectDetailBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      @JsonProperty("unitPrice")
      public RejectDetail.RejectDetailBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("unitPriceExcludingVat")
      public RejectDetail.RejectDetailBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      @JsonProperty("amountNoFreight")
      public RejectDetail.RejectDetailBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      @JsonProperty("amountExcludingVatNoFreight")
      public RejectDetail.RejectDetailBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("inputVatNoFreight")
      public RejectDetail.RejectDetailBuilder inputVatNoFreight(final BigDecimal inputVatNoFreight) {
         this.inputVatNoFreight = inputVatNoFreight;
         return this;
      }

      @JsonProperty("unitPriceNoFreight")
      public RejectDetail.RejectDetailBuilder unitPriceNoFreight(final BigDecimal unitPriceNoFreight) {
         this.unitPriceNoFreight = unitPriceNoFreight;
         return this;
      }

      @JsonProperty("unitPriceExcludingVatNoFreight")
      public RejectDetail.RejectDetailBuilder unitPriceExcludingVatNoFreight(final BigDecimal unitPriceExcludingVatNoFreight) {
         this.unitPriceExcludingVatNoFreight = unitPriceExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("realTime")
      public RejectDetail.RejectDetailBuilder realTime(final LocalDateTime realTime) {
         this.realTime = realTime;
         return this;
      }

      @JsonProperty("wapId")
      public RejectDetail.RejectDetailBuilder wapId(final Long wapId) {
         this.wapId = wapId;
         return this;
      }

      @JsonProperty("reviewStatus")
      public RejectDetail.RejectDetailBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public RejectDetail build() {
         return new RejectDetail(
            this.id,
            this.basicClass,
            this.brand,
            this.classifyId,
            this.color,
            this.heatNoAndBatchNo,
            this.length,
            this.materialIsWhole,
            this.projectId,
            this.quantity,
            this.rejectId,
            this.remark,
            this.specification,
            this.theoryThickness,
            this.thickness,
            this.boolPartyA,
            this.warehouseId,
            this.warehouseType,
            this.width,
            this.mete,
            this.materialInventoryId,
            this.inboundDetailId,
            this.unitNet,
            this.invoiceType,
            this.taxRate,
            this.standardId,
            this.standardName,
            this.monomerId,
            this.areaId,
            this.materialSn,
            this.workshopId,
            this.amount,
            this.amountExcludingVat,
            this.inputVat,
            this.unitPrice,
            this.unitPriceExcludingVat,
            this.amountNoFreight,
            this.amountExcludingVatNoFreight,
            this.inputVatNoFreight,
            this.unitPriceNoFreight,
            this.unitPriceExcludingVatNoFreight,
            this.realTime,
            this.wapId,
            this.reviewStatus
         );
      }

      @Override
      public String toString() {
         return "RejectDetail.RejectDetailBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", brand="
            + this.brand
            + ", classifyId="
            + this.classifyId
            + ", color="
            + this.color
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", length="
            + this.length
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", projectId="
            + this.projectId
            + ", quantity="
            + this.quantity
            + ", rejectId="
            + this.rejectId
            + ", remark="
            + this.remark
            + ", specification="
            + this.specification
            + ", theoryThickness="
            + this.theoryThickness
            + ", thickness="
            + this.thickness
            + ", boolPartyA="
            + this.boolPartyA
            + ", warehouseId="
            + this.warehouseId
            + ", warehouseType="
            + this.warehouseType
            + ", width="
            + this.width
            + ", mete="
            + this.mete
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", inboundDetailId="
            + this.inboundDetailId
            + ", unitNet="
            + this.unitNet
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", materialSn="
            + this.materialSn
            + ", workshopId="
            + this.workshopId
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", inputVat="
            + this.inputVat
            + ", unitPrice="
            + this.unitPrice
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", amountExcludingVatNoFreight="
            + this.amountExcludingVatNoFreight
            + ", inputVatNoFreight="
            + this.inputVatNoFreight
            + ", unitPriceNoFreight="
            + this.unitPriceNoFreight
            + ", unitPriceExcludingVatNoFreight="
            + this.unitPriceExcludingVatNoFreight
            + ", realTime="
            + this.realTime
            + ", wapId="
            + this.wapId
            + ", reviewStatus="
            + this.reviewStatus
            + ")";
      }
   }
}
