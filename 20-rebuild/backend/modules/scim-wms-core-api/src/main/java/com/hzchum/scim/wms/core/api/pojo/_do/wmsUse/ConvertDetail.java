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

@ApiModel(value = "WmsConvertDetail对象", description = "")
@Entity
@TableName("wms_convert_detail")
@Table(name = "wms_convert_detail")
public class ConvertDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "物料编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number")
   private String serialNumber;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class")
   private Integer basicClass;
   @ApiModelProperty(name = "classifyId", value = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id")
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   @TableField("classify_name")
   @Column(name = "classify_name")
   private String classifyName;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification")
   private String specification;
   @ApiModelProperty(name = "warehouseType", value = "仓库类型[1 公共库,2 项目库]")
   @JsonProperty("warehouseType")
   @JSONField(name = "warehouseType")
   @TableField("warehouse_type")
   @Column(name = "warehouse_type")
   private Integer warehouseType;
   @ApiModelProperty(name = "projectId", value = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体ID'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域ID'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "boolPartyA", value = "是否甲供物料")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a")
   private Boolean boolPartyA;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity")
   private BigDecimal quantity;
   @ApiModelProperty(name = "length", value = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "宽度")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width")
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚度")
   @JsonProperty("theoryThickness")
   @JSONField(name = "theoryThickness")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness")
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "oneTheoryWeight", value = "单件理论重量")
   @JsonProperty("oneTheoryWeight")
   @JSONField(name = "oneTheoryWeight")
   @TableField("one_theory_weight")
   @Column(name = "one_theory_weight")
   private BigDecimal oneTheoryWeight;
   @ApiModelProperty(name = "brand", value = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand")
   private String brand;
   @ApiModelProperty(name = "heatNoAndBatchNo", value = "炉批号")
   @JsonProperty("heatNoAndBatchNo")
   @JSONField(name = "heatNoAndBatchNo")
   @TableField("heat_no_and_batch_no")
   @Column(name = "heat_no_and_batch_no")
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "color", value = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @TableField("color")
   @Column(name = "color")
   private String color;
   @ApiModelProperty(name = "measureUnit", value = "计量单位")
   @JsonProperty("measureUnit")
   @JSONField(name = "measureUnit")
   @TableField("measure_unit")
   @Column(name = "measure_unit")
   private String measureUnit;
   @ApiModelProperty(name = "accountingPrecision", value = "核算精度")
   @JsonProperty("accountingPrecision")
   @JSONField(name = "accountingPrecision")
   @TableField("accounting_precision")
   @Column(name = "accounting_precision")
   private Integer accountingPrecision;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   @JsonProperty("accountingUnit")
   @JSONField(name = "accountingUnit")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit")
   private String accountingUnit;
   @ApiModelProperty(name = "unitNet", value = "单位净量")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net")
   private BigDecimal unitNet;
   @ApiModelProperty(name = "mete", value = "总核算量,钢材为当前物料总核算,辅材为单个的核算")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "warehouseId", value = "仓库ID")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id")
   private Long warehouseId;
   @ApiModelProperty(name = "factoryId", value = "工厂ID")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间ID")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id")
   private Long workshopId;
   @ApiModelProperty(name = "weightMeasurementMode", value = "重量计量方式 [1理计 , 2 磅计 ,混合计]")
   @JsonProperty("weightMeasurementMode")
   @JSONField(name = "weightMeasurementMode")
   @TableField("weight_measurement_mode")
   @Column(name = "weight_measurement_mode")
   private Integer weightMeasurementMode;
   @ApiModelProperty(name = "taxRate", value = "税率(百分比)")
   @JsonProperty("taxRate")
   @JSONField(name = "taxRate")
   @TableField("tax_rate")
   @Column(name = "tax_rate")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 [InvoiceTypeEnum]")
   @JsonProperty("invoiceType")
   @JSONField(name = "invoiceType")
   @TableField("invoice_type")
   @Column(name = "invoice_type")
   private Integer invoiceType;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "outboundSn", value = "出库单编号,针对物料半出后产生余料的溯源")
   @JsonProperty("outboundSn")
   @JSONField(name = "outboundSn")
   @TableField("outbound_SN")
   @Column(name = "outbound_SN")
   private String outboundSn;
   @ApiModelProperty(name = "sourceMaterielId", value = "原物料ID")
   @JsonProperty("sourceMaterielId")
   @JSONField(name = "sourceMaterielId")
   @TableField("source_materiel_id")
   @Column(name = "source_materiel_id")
   private Long sourceMaterielId;
   @ApiModelProperty(name = "barcode", value = "条形码")
   @JsonProperty("barcode")
   @JSONField(name = "barcode")
   @TableField("barcode")
   @Column(name = "barcode")
   private String barcode;
   @ApiModelProperty(name = "boolVirtual", value = "是否虚拟", notes = "是否虚拟")
   @JsonProperty("boolVirtual")
   @JSONField(name = "boolVirtual")
   @TableField("bool_virtual")
   @Column(name = "bool_virtual", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '是否虚拟'", nullable = true)
   private Boolean boolVirtual;
   @ApiModelProperty(name = "convertId", value = "转换单id")
   @JsonProperty("convertId")
   @JSONField(name = "convertId")
   @TableField("convert_id")
   @Column(name = "convert_id")
   private Long convertId;
   @ApiModelProperty(name = "convertNumber", value = "转换单编号", notes = "转换单编号")
   @JsonProperty("convertNumber")
   @JSONField(name = "convertNumber")
   @TableField("convert_number")
   @Column(name = "convert_number", columnDefinition = "varchar(255)  COMMENT '转换单编号'", nullable = true)
   private String convertNumber;
   @ApiModelProperty(name = "recipientId", value = "领用人ID")
   @JsonProperty("recipientId")
   @JSONField(name = "recipientId")
   @TableField("recipient_id")
   @Column(name = "recipient_id")
   private Long recipientId;
   @ApiModelProperty(name = "sourceProjectId", value = "物料原项目ID")
   @JsonProperty("sourceProjectId")
   @JSONField(name = "sourceProjectId")
   @TableField("source_project_id")
   @Column(name = "source_project_id")
   private Long sourceProjectId;
   @ApiModelProperty(name = "sourceMonomerId", value = "物料原单体ID")
   @JsonProperty("sourceMonomerId")
   @JSONField(name = "sourceMonomerId")
   @TableField("source_monomer_id")
   @Column(name = "source_monomer_id")
   private Long sourceMonomerId;
   @ApiModelProperty(name = "sourceAreaId", value = "物料原区域ID")
   @JsonProperty("sourceAreaId")
   @JSONField(name = "sourceAreaId")
   @TableField("source_area_id")
   @Column(name = "source_area_id")
   private Long sourceAreaId;
   @ApiModelProperty(name = "boolContinue", value = "是否转换完成之后结束流程（条板出库使用）", notes = "是否转换完成之后结束流程（条板出库使用）")
   @JsonProperty("boolContinue")
   @JSONField(name = "boolContinue")
   @TableField("bool_continue")
   @Column(name = "bool_continue", columnDefinition = "tinyint(1) default '0' COMMENT '是否转换完成之后结束流程（条板出库使用）'", nullable = true)
   private Boolean boolContinue;
   @ApiModelProperty(name = "boolOutbound", value = "条板是否出库", notes = "条板是否出库（条板出库使用）")
   @JsonProperty("boolOutbound")
   @JSONField(name = "boolOutbound")
   @TableField("bool_outbound")
   @Column(name = "bool_outbound", columnDefinition = "tinyint(1) default '0' COMMENT '条板是否出库（条板出库使用）'", nullable = true)
   private Boolean boolOutbound;
   @ApiModelProperty(name = "outboundTime", value = "出库时间(可修改,默认生成时间)")
   @JsonProperty("outboundTime")
   @JSONField(name = "outboundTime")
   @TableField("outbound_time")
   @Column(name = "outbound_time")
   private LocalDateTime outboundTime;
   @ApiModelProperty(name = "boolSurplus", value = "是否余料", notes = "是否余料（条板出库使用）")
   @JsonProperty("boolSurplus")
   @JSONField(name = "boolSurplus")
   @TableField("bool_surplus")
   @Column(name = "bool_surplus", columnDefinition = "tinyint(1) default '0' COMMENT '是否余料（条板出库使用）'", nullable = true)
   private Boolean boolSurplus;
   @ApiModelProperty(name = "amount", value = "入库总价 含税", notes = "入库总价 含税")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '入库总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "amountExcludingVat", value = "转换总金额（不含税）")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_VAT")
   @Column(name = "amount_excluding_VAT")
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "outboundAddress", value = "出库目的地", notes = "1工厂  2工地")
   @JsonProperty("outboundAddress")
   @JSONField(name = "outboundAddress")
   @TableField("outbound_address")
   @Column(name = "outbound_address", columnDefinition = "bigint(20)  COMMENT '加权价ID'", nullable = true)
   private Integer outboundAddress;
   @ApiModelProperty(name = "amountExcludingVatNoFreight", value = "转换总金额（不含税） 不含运费")
   @JsonProperty("amountExcludingVatNoFreight")
   @JSONField(name = "amountExcludingVatNoFreight")
   @TableField("amount_excluding_VAT_no_freight")
   @Column(name = "amount_excluding_VAT_no_freight")
   private BigDecimal amountExcludingVatNoFreight;
   @ApiModelProperty(name = "amountNoFreight", value = "入库总价含税 不含运费", notes = "入库总价含税 不含运费")
   @JsonProperty("amountNoFreight")
   @JSONField(name = "amountNoFreight")
   @TableField("amount_no_freight")
   @Column(name = "amount_no_freight", columnDefinition = "decimal(32,12)  COMMENT '入库总价含税 不含运费'", nullable = true)
   private BigDecimal amountNoFreight;

   public static ConvertDetail.ConvertDetailBuilder builder() {
      return new ConvertDetail.ConvertDetailBuilder();
   }

   public ConvertDetail() {
   }

   public ConvertDetail(
      final Long id,
      final String serialNumber,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final String specification,
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
      final Long warehouseId,
      final Long factoryId,
      final Long workshopId,
      final Integer weightMeasurementMode,
      final BigDecimal taxRate,
      final Integer invoiceType,
      final String remark,
      final String outboundSn,
      final Long sourceMaterielId,
      final String barcode,
      final Boolean boolVirtual,
      final Long convertId,
      final String convertNumber,
      final Long recipientId,
      final Long sourceProjectId,
      final Long sourceMonomerId,
      final Long sourceAreaId,
      final Boolean boolContinue,
      final Boolean boolOutbound,
      final LocalDateTime outboundTime,
      final Boolean boolSurplus,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final Integer outboundAddress,
      final BigDecimal amountExcludingVatNoFreight,
      final BigDecimal amountNoFreight
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.specification = specification;
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
      this.warehouseId = warehouseId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.weightMeasurementMode = weightMeasurementMode;
      this.taxRate = taxRate;
      this.invoiceType = invoiceType;
      this.remark = remark;
      this.outboundSn = outboundSn;
      this.sourceMaterielId = sourceMaterielId;
      this.barcode = barcode;
      this.boolVirtual = boolVirtual;
      this.convertId = convertId;
      this.convertNumber = convertNumber;
      this.recipientId = recipientId;
      this.sourceProjectId = sourceProjectId;
      this.sourceMonomerId = sourceMonomerId;
      this.sourceAreaId = sourceAreaId;
      this.boolContinue = boolContinue;
      this.boolOutbound = boolOutbound;
      this.outboundTime = outboundTime;
      this.boolSurplus = boolSurplus;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.outboundAddress = outboundAddress;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.amountNoFreight = amountNoFreight;
   }

   public Long getId() {
      return this.id;
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

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
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

   public String getRemark() {
      return this.remark;
   }

   public String getOutboundSn() {
      return this.outboundSn;
   }

   public Long getSourceMaterielId() {
      return this.sourceMaterielId;
   }

   public String getBarcode() {
      return this.barcode;
   }

   public Boolean getBoolVirtual() {
      return this.boolVirtual;
   }

   public Long getConvertId() {
      return this.convertId;
   }

   public String getConvertNumber() {
      return this.convertNumber;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public Long getSourceProjectId() {
      return this.sourceProjectId;
   }

   public Long getSourceMonomerId() {
      return this.sourceMonomerId;
   }

   public Long getSourceAreaId() {
      return this.sourceAreaId;
   }

   public Boolean getBoolContinue() {
      return this.boolContinue;
   }

   public Boolean getBoolOutbound() {
      return this.boolOutbound;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public Boolean getBoolSurplus() {
      return this.boolSurplus;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public Integer getOutboundAddress() {
      return this.outboundAddress;
   }

   public BigDecimal getAmountExcludingVatNoFreight() {
      return this.amountExcludingVatNoFreight;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   @JsonProperty("id")
   public ConvertDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public ConvertDetail setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("basicClass")
   public ConvertDetail setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public ConvertDetail setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("classifyName")
   public ConvertDetail setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("specification")
   public ConvertDetail setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("warehouseType")
   public ConvertDetail setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   @JsonProperty("projectId")
   public ConvertDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public ConvertDetail setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public ConvertDetail setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("boolPartyA")
   public ConvertDetail setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("quantity")
   public ConvertDetail setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("length")
   public ConvertDetail setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public ConvertDetail setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public ConvertDetail setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("theoryThickness")
   public ConvertDetail setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("oneTheoryWeight")
   public ConvertDetail setOneTheoryWeight(final BigDecimal oneTheoryWeight) {
      this.oneTheoryWeight = oneTheoryWeight;
      return this;
   }

   @JsonProperty("brand")
   public ConvertDetail setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public ConvertDetail setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("color")
   public ConvertDetail setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("measureUnit")
   public ConvertDetail setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   @JsonProperty("accountingPrecision")
   public ConvertDetail setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
      return this;
   }

   @JsonProperty("accountingUnit")
   public ConvertDetail setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @JsonProperty("unitNet")
   public ConvertDetail setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("mete")
   public ConvertDetail setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("warehouseId")
   public ConvertDetail setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("factoryId")
   public ConvertDetail setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public ConvertDetail setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("weightMeasurementMode")
   public ConvertDetail setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
      return this;
   }

   @JsonProperty("taxRate")
   public ConvertDetail setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   @JsonProperty("invoiceType")
   public ConvertDetail setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
      return this;
   }

   @JsonProperty("remark")
   public ConvertDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("outboundSn")
   public ConvertDetail setOutboundSn(final String outboundSn) {
      this.outboundSn = outboundSn;
      return this;
   }

   @JsonProperty("sourceMaterielId")
   public ConvertDetail setSourceMaterielId(final Long sourceMaterielId) {
      this.sourceMaterielId = sourceMaterielId;
      return this;
   }

   @JsonProperty("barcode")
   public ConvertDetail setBarcode(final String barcode) {
      this.barcode = barcode;
      return this;
   }

   @JsonProperty("boolVirtual")
   public ConvertDetail setBoolVirtual(final Boolean boolVirtual) {
      this.boolVirtual = boolVirtual;
      return this;
   }

   @JsonProperty("convertId")
   public ConvertDetail setConvertId(final Long convertId) {
      this.convertId = convertId;
      return this;
   }

   @JsonProperty("convertNumber")
   public ConvertDetail setConvertNumber(final String convertNumber) {
      this.convertNumber = convertNumber;
      return this;
   }

   @JsonProperty("recipientId")
   public ConvertDetail setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
      return this;
   }

   @JsonProperty("sourceProjectId")
   public ConvertDetail setSourceProjectId(final Long sourceProjectId) {
      this.sourceProjectId = sourceProjectId;
      return this;
   }

   @JsonProperty("sourceMonomerId")
   public ConvertDetail setSourceMonomerId(final Long sourceMonomerId) {
      this.sourceMonomerId = sourceMonomerId;
      return this;
   }

   @JsonProperty("sourceAreaId")
   public ConvertDetail setSourceAreaId(final Long sourceAreaId) {
      this.sourceAreaId = sourceAreaId;
      return this;
   }

   @JsonProperty("boolContinue")
   public ConvertDetail setBoolContinue(final Boolean boolContinue) {
      this.boolContinue = boolContinue;
      return this;
   }

   @JsonProperty("boolOutbound")
   public ConvertDetail setBoolOutbound(final Boolean boolOutbound) {
      this.boolOutbound = boolOutbound;
      return this;
   }

   @JsonProperty("outboundTime")
   public ConvertDetail setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
      return this;
   }

   @JsonProperty("boolSurplus")
   public ConvertDetail setBoolSurplus(final Boolean boolSurplus) {
      this.boolSurplus = boolSurplus;
      return this;
   }

   @JsonProperty("amount")
   public ConvertDetail setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public ConvertDetail setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("outboundAddress")
   public ConvertDetail setOutboundAddress(final Integer outboundAddress) {
      this.outboundAddress = outboundAddress;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public ConvertDetail setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public ConvertDetail setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @Override
   public String toString() {
      return "ConvertDetail(id="
         + this.getId()
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
         + ", warehouseId="
         + this.getWarehouseId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", taxRate="
         + this.getTaxRate()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", remark="
         + this.getRemark()
         + ", outboundSn="
         + this.getOutboundSn()
         + ", sourceMaterielId="
         + this.getSourceMaterielId()
         + ", barcode="
         + this.getBarcode()
         + ", boolVirtual="
         + this.getBoolVirtual()
         + ", convertId="
         + this.getConvertId()
         + ", convertNumber="
         + this.getConvertNumber()
         + ", recipientId="
         + this.getRecipientId()
         + ", sourceProjectId="
         + this.getSourceProjectId()
         + ", sourceMonomerId="
         + this.getSourceMonomerId()
         + ", sourceAreaId="
         + this.getSourceAreaId()
         + ", boolContinue="
         + this.getBoolContinue()
         + ", boolOutbound="
         + this.getBoolOutbound()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", boolSurplus="
         + this.getBoolSurplus()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", outboundAddress="
         + this.getOutboundAddress()
         + ", amountExcludingVatNoFreight="
         + this.getAmountExcludingVatNoFreight()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ConvertDetail)) {
         return false;
      }

      ConvertDetail other = (ConvertDetail)o;
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
                                 Object this$warehouseId = this.getWarehouseId();
                                 Object other$warehouseId = other.getWarehouseId();
                                 if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                    Object this$factoryId = this.getFactoryId();
                                    Object other$factoryId = other.getFactoryId();
                                    if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                                       Object this$workshopId = this.getWorkshopId();
                                       Object other$workshopId = other.getWorkshopId();
                                       if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                          Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                                          Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                                          if (this$weightMeasurementMode == null
                                             ? other$weightMeasurementMode == null
                                             : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                             Object this$invoiceType = this.getInvoiceType();
                                             Object other$invoiceType = other.getInvoiceType();
                                             if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                                Object this$sourceMaterielId = this.getSourceMaterielId();
                                                Object other$sourceMaterielId = other.getSourceMaterielId();
                                                if (this$sourceMaterielId == null
                                                   ? other$sourceMaterielId == null
                                                   : this$sourceMaterielId.equals(other$sourceMaterielId)) {
                                                   Object this$boolVirtual = this.getBoolVirtual();
                                                   Object other$boolVirtual = other.getBoolVirtual();
                                                   if (this$boolVirtual == null ? other$boolVirtual == null : this$boolVirtual.equals(other$boolVirtual)) {
                                                      Object this$convertId = this.getConvertId();
                                                      Object other$convertId = other.getConvertId();
                                                      if (this$convertId == null ? other$convertId == null : this$convertId.equals(other$convertId)) {
                                                         Object this$recipientId = this.getRecipientId();
                                                         Object other$recipientId = other.getRecipientId();
                                                         if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
                                                            Object this$sourceProjectId = this.getSourceProjectId();
                                                            Object other$sourceProjectId = other.getSourceProjectId();
                                                            if (this$sourceProjectId == null
                                                               ? other$sourceProjectId == null
                                                               : this$sourceProjectId.equals(other$sourceProjectId)) {
                                                               Object this$sourceMonomerId = this.getSourceMonomerId();
                                                               Object other$sourceMonomerId = other.getSourceMonomerId();
                                                               if (this$sourceMonomerId == null
                                                                  ? other$sourceMonomerId == null
                                                                  : this$sourceMonomerId.equals(other$sourceMonomerId)) {
                                                                  Object this$sourceAreaId = this.getSourceAreaId();
                                                                  Object other$sourceAreaId = other.getSourceAreaId();
                                                                  if (this$sourceAreaId == null
                                                                     ? other$sourceAreaId == null
                                                                     : this$sourceAreaId.equals(other$sourceAreaId)) {
                                                                     Object this$boolContinue = this.getBoolContinue();
                                                                     Object other$boolContinue = other.getBoolContinue();
                                                                     if (this$boolContinue == null
                                                                        ? other$boolContinue == null
                                                                        : this$boolContinue.equals(other$boolContinue)) {
                                                                        Object this$boolOutbound = this.getBoolOutbound();
                                                                        Object other$boolOutbound = other.getBoolOutbound();
                                                                        if (this$boolOutbound == null
                                                                           ? other$boolOutbound == null
                                                                           : this$boolOutbound.equals(other$boolOutbound)) {
                                                                           Object this$boolSurplus = this.getBoolSurplus();
                                                                           Object other$boolSurplus = other.getBoolSurplus();
                                                                           if (this$boolSurplus == null
                                                                              ? other$boolSurplus == null
                                                                              : this$boolSurplus.equals(other$boolSurplus)) {
                                                                              Object this$outboundAddress = this.getOutboundAddress();
                                                                              Object other$outboundAddress = other.getOutboundAddress();
                                                                              if (this$outboundAddress == null
                                                                                 ? other$outboundAddress == null
                                                                                 : this$outboundAddress.equals(other$outboundAddress)) {
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
                                                                                                         : this$theoryThickness.equals(other$theoryThickness)) {
                                                                                                         Object this$oneTheoryWeight = this.getOneTheoryWeight();
                                                                                                         Object other$oneTheoryWeight = other.getOneTheoryWeight();
                                                                                                         if (this$oneTheoryWeight == null
                                                                                                            ? other$oneTheoryWeight == null
                                                                                                            : this$oneTheoryWeight.equals(other$oneTheoryWeight)
                                                                                                            )
                                                                                                          {
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
                                                                                                                                 : this$mete.equals(other$mete)
                                                                                                                                 )
                                                                                                                               {
                                                                                                                                 Object this$taxRate = this.getTaxRate();
                                                                                                                                 Object other$taxRate = other.getTaxRate();
                                                                                                                                 if (this$taxRate == null
                                                                                                                                    ? other$taxRate == null
                                                                                                                                    : this$taxRate.equals(
                                                                                                                                       other$taxRate
                                                                                                                                    )) {
                                                                                                                                    Object this$remark = this.getRemark();
                                                                                                                                    Object other$remark = other.getRemark();
                                                                                                                                    if (this$remark == null
                                                                                                                                       ? other$remark == null
                                                                                                                                       : this$remark.equals(
                                                                                                                                          other$remark
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
                                                                                                                                          Object this$barcode = this.getBarcode();
                                                                                                                                          Object other$barcode = other.getBarcode();
                                                                                                                                          if (this$barcode
                                                                                                                                                == null
                                                                                                                                             ? other$barcode
                                                                                                                                                == null
                                                                                                                                             : this$barcode.equals(
                                                                                                                                                other$barcode
                                                                                                                                             )) {
                                                                                                                                             Object this$convertNumber = this.getConvertNumber();
                                                                                                                                             Object other$convertNumber = other.getConvertNumber();
                                                                                                                                             if (this$convertNumber
                                                                                                                                                   == null
                                                                                                                                                ? other$convertNumber
                                                                                                                                                   == null
                                                                                                                                                : this$convertNumber.equals(
                                                                                                                                                   other$convertNumber
                                                                                                                                                )) {
                                                                                                                                                Object this$outboundTime = this.getOutboundTime();
                                                                                                                                                Object other$outboundTime = other.getOutboundTime();
                                                                                                                                                if (this$outboundTime
                                                                                                                                                      == null
                                                                                                                                                   ? other$outboundTime
                                                                                                                                                      == null
                                                                                                                                                   : this$outboundTime.equals(
                                                                                                                                                      other$outboundTime
                                                                                                                                                   )) {
                                                                                                                                                   Object this$amount = this.getAmount();
                                                                                                                                                   Object other$amount = other.getAmount();
                                                                                                                                                   if (this$amount
                                                                                                                                                         == null
                                                                                                                                                      ? other$amount
                                                                                                                                                         == null
                                                                                                                                                      : this$amount.equals(
                                                                                                                                                         other$amount
                                                                                                                                                      )) {
                                                                                                                                                      Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                                                                                                      Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                                                                                                      if (this$amountExcludingVat
                                                                                                                                                            == null
                                                                                                                                                         ? other$amountExcludingVat
                                                                                                                                                            == null
                                                                                                                                                         : this$amountExcludingVat.equals(
                                                                                                                                                            other$amountExcludingVat
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
                                                                                                                                                            return this$amountNoFreight
                                                                                                                                                                  == null
                                                                                                                                                               ? other$amountNoFreight
                                                                                                                                                                  == null
                                                                                                                                                               : this$amountNoFreight.equals(
                                                                                                                                                                  other$amountNoFreight
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ConvertDetail;
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
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $sourceMaterielId = this.getSourceMaterielId();
      result = result * 59 + ($sourceMaterielId == null ? 43 : $sourceMaterielId.hashCode());
      Object $boolVirtual = this.getBoolVirtual();
      result = result * 59 + ($boolVirtual == null ? 43 : $boolVirtual.hashCode());
      Object $convertId = this.getConvertId();
      result = result * 59 + ($convertId == null ? 43 : $convertId.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $sourceProjectId = this.getSourceProjectId();
      result = result * 59 + ($sourceProjectId == null ? 43 : $sourceProjectId.hashCode());
      Object $sourceMonomerId = this.getSourceMonomerId();
      result = result * 59 + ($sourceMonomerId == null ? 43 : $sourceMonomerId.hashCode());
      Object $sourceAreaId = this.getSourceAreaId();
      result = result * 59 + ($sourceAreaId == null ? 43 : $sourceAreaId.hashCode());
      Object $boolContinue = this.getBoolContinue();
      result = result * 59 + ($boolContinue == null ? 43 : $boolContinue.hashCode());
      Object $boolOutbound = this.getBoolOutbound();
      result = result * 59 + ($boolOutbound == null ? 43 : $boolOutbound.hashCode());
      Object $boolSurplus = this.getBoolSurplus();
      result = result * 59 + ($boolSurplus == null ? 43 : $boolSurplus.hashCode());
      Object $outboundAddress = this.getOutboundAddress();
      result = result * 59 + ($outboundAddress == null ? 43 : $outboundAddress.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
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
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $outboundSn = this.getOutboundSn();
      result = result * 59 + ($outboundSn == null ? 43 : $outboundSn.hashCode());
      Object $barcode = this.getBarcode();
      result = result * 59 + ($barcode == null ? 43 : $barcode.hashCode());
      Object $convertNumber = this.getConvertNumber();
      result = result * 59 + ($convertNumber == null ? 43 : $convertNumber.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
      result = result * 59 + ($amountExcludingVatNoFreight == null ? 43 : $amountExcludingVatNoFreight.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      return result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
   }

   public static class ConvertDetailBuilder {
      private Long id;
      private String serialNumber;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private String specification;
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
      private Long warehouseId;
      private Long factoryId;
      private Long workshopId;
      private Integer weightMeasurementMode;
      private BigDecimal taxRate;
      private Integer invoiceType;
      private String remark;
      private String outboundSn;
      private Long sourceMaterielId;
      private String barcode;
      private Boolean boolVirtual;
      private Long convertId;
      private String convertNumber;
      private Long recipientId;
      private Long sourceProjectId;
      private Long sourceMonomerId;
      private Long sourceAreaId;
      private Boolean boolContinue;
      private Boolean boolOutbound;
      private LocalDateTime outboundTime;
      private Boolean boolSurplus;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private Integer outboundAddress;
      private BigDecimal amountExcludingVatNoFreight;
      private BigDecimal amountNoFreight;

      ConvertDetailBuilder() {
      }

      @JsonProperty("id")
      public ConvertDetail.ConvertDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public ConvertDetail.ConvertDetailBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("basicClass")
      public ConvertDetail.ConvertDetailBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public ConvertDetail.ConvertDetailBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public ConvertDetail.ConvertDetailBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("specification")
      public ConvertDetail.ConvertDetailBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("warehouseType")
      public ConvertDetail.ConvertDetailBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      @JsonProperty("projectId")
      public ConvertDetail.ConvertDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public ConvertDetail.ConvertDetailBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public ConvertDetail.ConvertDetailBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("boolPartyA")
      public ConvertDetail.ConvertDetailBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("quantity")
      public ConvertDetail.ConvertDetailBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("length")
      public ConvertDetail.ConvertDetailBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public ConvertDetail.ConvertDetailBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public ConvertDetail.ConvertDetailBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("theoryThickness")
      public ConvertDetail.ConvertDetailBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("oneTheoryWeight")
      public ConvertDetail.ConvertDetailBuilder oneTheoryWeight(final BigDecimal oneTheoryWeight) {
         this.oneTheoryWeight = oneTheoryWeight;
         return this;
      }

      @JsonProperty("brand")
      public ConvertDetail.ConvertDetailBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public ConvertDetail.ConvertDetailBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("color")
      public ConvertDetail.ConvertDetailBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("measureUnit")
      public ConvertDetail.ConvertDetailBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      @JsonProperty("accountingPrecision")
      public ConvertDetail.ConvertDetailBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      @JsonProperty("accountingUnit")
      public ConvertDetail.ConvertDetailBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("unitNet")
      public ConvertDetail.ConvertDetailBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("mete")
      public ConvertDetail.ConvertDetailBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("warehouseId")
      public ConvertDetail.ConvertDetailBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("factoryId")
      public ConvertDetail.ConvertDetailBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public ConvertDetail.ConvertDetailBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("weightMeasurementMode")
      public ConvertDetail.ConvertDetailBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      @JsonProperty("taxRate")
      public ConvertDetail.ConvertDetailBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("invoiceType")
      public ConvertDetail.ConvertDetailBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("remark")
      public ConvertDetail.ConvertDetailBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("outboundSn")
      public ConvertDetail.ConvertDetailBuilder outboundSn(final String outboundSn) {
         this.outboundSn = outboundSn;
         return this;
      }

      @JsonProperty("sourceMaterielId")
      public ConvertDetail.ConvertDetailBuilder sourceMaterielId(final Long sourceMaterielId) {
         this.sourceMaterielId = sourceMaterielId;
         return this;
      }

      @JsonProperty("barcode")
      public ConvertDetail.ConvertDetailBuilder barcode(final String barcode) {
         this.barcode = barcode;
         return this;
      }

      @JsonProperty("boolVirtual")
      public ConvertDetail.ConvertDetailBuilder boolVirtual(final Boolean boolVirtual) {
         this.boolVirtual = boolVirtual;
         return this;
      }

      @JsonProperty("convertId")
      public ConvertDetail.ConvertDetailBuilder convertId(final Long convertId) {
         this.convertId = convertId;
         return this;
      }

      @JsonProperty("convertNumber")
      public ConvertDetail.ConvertDetailBuilder convertNumber(final String convertNumber) {
         this.convertNumber = convertNumber;
         return this;
      }

      @JsonProperty("recipientId")
      public ConvertDetail.ConvertDetailBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      @JsonProperty("sourceProjectId")
      public ConvertDetail.ConvertDetailBuilder sourceProjectId(final Long sourceProjectId) {
         this.sourceProjectId = sourceProjectId;
         return this;
      }

      @JsonProperty("sourceMonomerId")
      public ConvertDetail.ConvertDetailBuilder sourceMonomerId(final Long sourceMonomerId) {
         this.sourceMonomerId = sourceMonomerId;
         return this;
      }

      @JsonProperty("sourceAreaId")
      public ConvertDetail.ConvertDetailBuilder sourceAreaId(final Long sourceAreaId) {
         this.sourceAreaId = sourceAreaId;
         return this;
      }

      @JsonProperty("boolContinue")
      public ConvertDetail.ConvertDetailBuilder boolContinue(final Boolean boolContinue) {
         this.boolContinue = boolContinue;
         return this;
      }

      @JsonProperty("boolOutbound")
      public ConvertDetail.ConvertDetailBuilder boolOutbound(final Boolean boolOutbound) {
         this.boolOutbound = boolOutbound;
         return this;
      }

      @JsonProperty("outboundTime")
      public ConvertDetail.ConvertDetailBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      @JsonProperty("boolSurplus")
      public ConvertDetail.ConvertDetailBuilder boolSurplus(final Boolean boolSurplus) {
         this.boolSurplus = boolSurplus;
         return this;
      }

      @JsonProperty("amount")
      public ConvertDetail.ConvertDetailBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public ConvertDetail.ConvertDetailBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("outboundAddress")
      public ConvertDetail.ConvertDetailBuilder outboundAddress(final Integer outboundAddress) {
         this.outboundAddress = outboundAddress;
         return this;
      }

      @JsonProperty("amountExcludingVatNoFreight")
      public ConvertDetail.ConvertDetailBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("amountNoFreight")
      public ConvertDetail.ConvertDetailBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      public ConvertDetail build() {
         return new ConvertDetail(
            this.id,
            this.serialNumber,
            this.basicClass,
            this.classifyId,
            this.classifyName,
            this.specification,
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
            this.warehouseId,
            this.factoryId,
            this.workshopId,
            this.weightMeasurementMode,
            this.taxRate,
            this.invoiceType,
            this.remark,
            this.outboundSn,
            this.sourceMaterielId,
            this.barcode,
            this.boolVirtual,
            this.convertId,
            this.convertNumber,
            this.recipientId,
            this.sourceProjectId,
            this.sourceMonomerId,
            this.sourceAreaId,
            this.boolContinue,
            this.boolOutbound,
            this.outboundTime,
            this.boolSurplus,
            this.amount,
            this.amountExcludingVat,
            this.outboundAddress,
            this.amountExcludingVatNoFreight,
            this.amountNoFreight
         );
      }

      @Override
      public String toString() {
         return "ConvertDetail.ConvertDetailBuilder(id="
            + this.id
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
            + ", warehouseId="
            + this.warehouseId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", taxRate="
            + this.taxRate
            + ", invoiceType="
            + this.invoiceType
            + ", remark="
            + this.remark
            + ", outboundSn="
            + this.outboundSn
            + ", sourceMaterielId="
            + this.sourceMaterielId
            + ", barcode="
            + this.barcode
            + ", boolVirtual="
            + this.boolVirtual
            + ", convertId="
            + this.convertId
            + ", convertNumber="
            + this.convertNumber
            + ", recipientId="
            + this.recipientId
            + ", sourceProjectId="
            + this.sourceProjectId
            + ", sourceMonomerId="
            + this.sourceMonomerId
            + ", sourceAreaId="
            + this.sourceAreaId
            + ", boolContinue="
            + this.boolContinue
            + ", boolOutbound="
            + this.boolOutbound
            + ", outboundTime="
            + this.outboundTime
            + ", boolSurplus="
            + this.boolSurplus
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", outboundAddress="
            + this.outboundAddress
            + ", amountExcludingVatNoFreight="
            + this.amountExcludingVatNoFreight
            + ", amountNoFreight="
            + this.amountNoFreight
            + ")";
      }
   }
}
