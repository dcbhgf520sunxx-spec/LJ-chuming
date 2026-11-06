package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;

public class ConvertDetailDTO {
   @ApiModelProperty(name = "useStatus", value = "使用状态[0 没有使用完,1 已使用完],物料入库后重量会进行加权,在退库时就会产生差会产生负数,设置为已使用完")
   @JsonProperty("useStatus")
   @JSONField(name = "useStatus")
   @TableField("use_status")
   @Column(name = "use_status")
   private Boolean useStatus;
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
   @ApiModelProperty(name = "materialIsWhole", value = "物料是否完整[1 整料,2 余料]")
   @JsonProperty("materialIsWhole")
   @JSONField(name = "materialIsWhole")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole")
   private Integer materialIsWhole;
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
   @ApiModelProperty(name = "weightedAverageSpec", value = "加权平均规格(将规格拆分获取不参与加权规格以*号拼接)")
   @JsonProperty("weightedAverageSpec")
   @JSONField(name = "weightedAverageSpec")
   @TableField("weighted_average_spec")
   @Column(name = "weighted_average_spec")
   private String weightedAverageSpec;
   @ApiModelProperty(name = "inventoryStartTime", value = "存储开始时间,物料第一次入库后的时间,当物料使用完后设置为空")
   @JsonProperty("inventoryStartTime")
   @JSONField(name = "inventoryStartTime")
   @TableField(value = "inventory_start_time", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "inventory_start_time")
   private LocalDateTime inventoryStartTime;
   @ApiModelProperty(name = "inventoryEndTime", value = "存储结束时间,记录物料每一次入库的时间")
   @JsonProperty("inventoryEndTime")
   @JSONField(name = "inventoryEndTime")
   @TableField(value = "inventory_end_time", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "inventory_end_time")
   private LocalDateTime inventoryEndTime;
   @ApiModelProperty(name = "standardId", value = "型材执行国标ID")
   @JsonProperty("standardId")
   @JSONField(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id")
   private Long standardId;
   @ApiModelProperty(name = "standardName", value = "型材执行国标名称")
   @JsonProperty("standardName")
   @JSONField(name = "standardName")
   @TableField("standard_name")
   @Column(name = "standard_name")
   private String standardName;
   @ApiModelProperty(name = "sectionSteelWeight", value = "型材标准重量(Kg/m)")
   @JsonProperty("sectionSteelWeight")
   @JSONField(name = "sectionSteelWeight")
   @TableField("section_steel_weight")
   @Column(name = "section_steel_weight")
   private BigDecimal sectionSteelWeight;
   @ApiModelProperty(name = "boolHasFrozen", value = "物料是否存在冻结")
   @JsonProperty("boolHasFrozen")
   @JSONField(name = "boolHasFrozen")
   @TableField("bool_has_frozen")
   @Column(name = "bool_has_frozen")
   private Boolean boolHasFrozen;
   @ApiModelProperty(name = "surplusGraphicsPath", value = "余料图纸路径")
   @JsonProperty("surplusGraphicsPath")
   @JSONField(name = "surplusGraphicsPath")
   @TableField("surplus_graphics_path")
   @Column(name = "surplus_graphics_path")
   private String surplusGraphicsPath;
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
   @ApiModelProperty(name = "surplusSn", value = "余料编号", notes = "余料编号")
   @JsonProperty("surplusSn")
   @JSONField(name = "surplusSn")
   @TableField("surplus_sn")
   @Column(name = "surplus_sn", columnDefinition = "varchar(255)  COMMENT '余料编号'", nullable = true)
   private String surplusSn;
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
   private Long workshopId;
   private String workshopName;
   private Long recipientId;
   private String recipientName;
   private BriefIdAndNameDTO warehouse;
   private ProjectInfo project;
   private String monomerName;
   private String areaName;
   private LocalDateTime outboundTime;
   private Boolean boolSurplus;
   private Boolean boolOutbound;
   private BigDecimal amountExcludingVat;
   private Integer outboundAddress;

   public static ConvertDetailDTO.ConvertDetailDTOBuilder builder() {
      return new ConvertDetailDTO.ConvertDetailDTOBuilder();
   }

   public Boolean getUseStatus() {
      return this.useStatus;
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

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getFactoryId() {
      return this.factoryId;
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

   public String getWeightedAverageSpec() {
      return this.weightedAverageSpec;
   }

   public LocalDateTime getInventoryStartTime() {
      return this.inventoryStartTime;
   }

   public LocalDateTime getInventoryEndTime() {
      return this.inventoryEndTime;
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

   public Boolean getBoolHasFrozen() {
      return this.boolHasFrozen;
   }

   public String getSurplusGraphicsPath() {
      return this.surplusGraphicsPath;
   }

   public Long getSourceMaterielId() {
      return this.sourceMaterielId;
   }

   public String getBarcode() {
      return this.barcode;
   }

   public String getSurplusSn() {
      return this.surplusSn;
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

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public String getRecipientName() {
      return this.recipientName;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public Boolean getBoolSurplus() {
      return this.boolSurplus;
   }

   public Boolean getBoolOutbound() {
      return this.boolOutbound;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public Integer getOutboundAddress() {
      return this.outboundAddress;
   }

   @JsonProperty("useStatus")
   public void setUseStatus(final Boolean useStatus) {
      this.useStatus = useStatus;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("basicClass")
   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   @JsonProperty("classifyId")
   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   @JsonProperty("classifyName")
   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   @JsonProperty("specification")
   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   @JsonProperty("materialIsWhole")
   public void setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
   }

   @JsonProperty("warehouseType")
   public void setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
   }

   @JsonProperty("projectId")
   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   @JsonProperty("monomerId")
   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   @JsonProperty("areaId")
   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   @JsonProperty("boolPartyA")
   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   @JsonProperty("quantity")
   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("length")
   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   @JsonProperty("width")
   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   @JsonProperty("thickness")
   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   @JsonProperty("theoryThickness")
   public void setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
   }

   @JsonProperty("oneTheoryWeight")
   public void setOneTheoryWeight(final BigDecimal oneTheoryWeight) {
      this.oneTheoryWeight = oneTheoryWeight;
   }

   @JsonProperty("brand")
   public void setBrand(final String brand) {
      this.brand = brand;
   }

   @JsonProperty("heatNoAndBatchNo")
   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   @JsonProperty("color")
   public void setColor(final String color) {
      this.color = color;
   }

   @JsonProperty("measureUnit")
   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   @JsonProperty("accountingPrecision")
   public void setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   @JsonProperty("accountingUnit")
   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   @JsonProperty("unitNet")
   public void setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
   }

   @JsonProperty("mete")
   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @JsonProperty("warehouseId")
   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   @JsonProperty("factoryId")
   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   @JsonProperty("weightMeasurementMode")
   public void setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
   }

   @JsonProperty("taxRate")
   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   @JsonProperty("invoiceType")
   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   @JsonProperty("remark")
   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @JsonProperty("outboundSn")
   public void setOutboundSn(final String outboundSn) {
      this.outboundSn = outboundSn;
   }

   @JsonProperty("weightedAverageSpec")
   public void setWeightedAverageSpec(final String weightedAverageSpec) {
      this.weightedAverageSpec = weightedAverageSpec;
   }

   @JsonProperty("inventoryStartTime")
   public void setInventoryStartTime(final LocalDateTime inventoryStartTime) {
      this.inventoryStartTime = inventoryStartTime;
   }

   @JsonProperty("inventoryEndTime")
   public void setInventoryEndTime(final LocalDateTime inventoryEndTime) {
      this.inventoryEndTime = inventoryEndTime;
   }

   @JsonProperty("standardId")
   public void setStandardId(final Long standardId) {
      this.standardId = standardId;
   }

   @JsonProperty("standardName")
   public void setStandardName(final String standardName) {
      this.standardName = standardName;
   }

   @JsonProperty("sectionSteelWeight")
   public void setSectionSteelWeight(final BigDecimal sectionSteelWeight) {
      this.sectionSteelWeight = sectionSteelWeight;
   }

   @JsonProperty("boolHasFrozen")
   public void setBoolHasFrozen(final Boolean boolHasFrozen) {
      this.boolHasFrozen = boolHasFrozen;
   }

   @JsonProperty("surplusGraphicsPath")
   public void setSurplusGraphicsPath(final String surplusGraphicsPath) {
      this.surplusGraphicsPath = surplusGraphicsPath;
   }

   @JsonProperty("sourceMaterielId")
   public void setSourceMaterielId(final Long sourceMaterielId) {
      this.sourceMaterielId = sourceMaterielId;
   }

   @JsonProperty("barcode")
   public void setBarcode(final String barcode) {
      this.barcode = barcode;
   }

   @JsonProperty("surplusSn")
   public void setSurplusSn(final String surplusSn) {
      this.surplusSn = surplusSn;
   }

   @JsonProperty("boolVirtual")
   public void setBoolVirtual(final Boolean boolVirtual) {
      this.boolVirtual = boolVirtual;
   }

   @JsonProperty("convertId")
   public void setConvertId(final Long convertId) {
      this.convertId = convertId;
   }

   @JsonProperty("convertNumber")
   public void setConvertNumber(final String convertNumber) {
      this.convertNumber = convertNumber;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
   }

   public void setRecipientName(final String recipientName) {
      this.recipientName = recipientName;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
   }

   public void setBoolSurplus(final Boolean boolSurplus) {
      this.boolSurplus = boolSurplus;
   }

   public void setBoolOutbound(final Boolean boolOutbound) {
      this.boolOutbound = boolOutbound;
   }

   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   public void setOutboundAddress(final Integer outboundAddress) {
      this.outboundAddress = outboundAddress;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ConvertDetailDTO)) {
         return false;
      }

      ConvertDetailDTO other = (ConvertDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$useStatus = this.getUseStatus();
      Object other$useStatus = other.getUseStatus();
      if (this$useStatus == null ? other$useStatus == null : this$useStatus.equals(other$useStatus)) {
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
                                    Object this$warehouseId = this.getWarehouseId();
                                    Object other$warehouseId = other.getWarehouseId();
                                    if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                       Object this$factoryId = this.getFactoryId();
                                       Object other$factoryId = other.getFactoryId();
                                       if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                                          Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                                          Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                                          if (this$weightMeasurementMode == null
                                             ? other$weightMeasurementMode == null
                                             : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                             Object this$invoiceType = this.getInvoiceType();
                                             Object other$invoiceType = other.getInvoiceType();
                                             if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                                Object this$standardId = this.getStandardId();
                                                Object other$standardId = other.getStandardId();
                                                if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                                   Object this$boolHasFrozen = this.getBoolHasFrozen();
                                                   Object other$boolHasFrozen = other.getBoolHasFrozen();
                                                   if (this$boolHasFrozen == null
                                                      ? other$boolHasFrozen == null
                                                      : this$boolHasFrozen.equals(other$boolHasFrozen)) {
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
                                                               Object this$workshopId = this.getWorkshopId();
                                                               Object other$workshopId = other.getWorkshopId();
                                                               if (this$workshopId == null
                                                                  ? other$workshopId == null
                                                                  : this$workshopId.equals(other$workshopId)) {
                                                                  Object this$recipientId = this.getRecipientId();
                                                                  Object other$recipientId = other.getRecipientId();
                                                                  if (this$recipientId == null
                                                                     ? other$recipientId == null
                                                                     : this$recipientId.equals(other$recipientId)) {
                                                                     Object this$boolSurplus = this.getBoolSurplus();
                                                                     Object other$boolSurplus = other.getBoolSurplus();
                                                                     if (this$boolSurplus == null
                                                                        ? other$boolSurplus == null
                                                                        : this$boolSurplus.equals(other$boolSurplus)) {
                                                                        Object this$boolOutbound = this.getBoolOutbound();
                                                                        Object other$boolOutbound = other.getBoolOutbound();
                                                                        if (this$boolOutbound == null
                                                                           ? other$boolOutbound == null
                                                                           : this$boolOutbound.equals(other$boolOutbound)) {
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
                                                                                                         : this$oneTheoryWeight.equals(other$oneTheoryWeight)) {
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
                                                                                                                           : this$unitNet.equals(other$unitNet)
                                                                                                                           )
                                                                                                                         {
                                                                                                                           Object this$mete = this.getMete();
                                                                                                                           Object other$mete = other.getMete();
                                                                                                                           if (this$mete == null
                                                                                                                              ? other$mete == null
                                                                                                                              : this$mete.equals(other$mete)) {
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
                                                                                                                                    if (this$outboundSn == null
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
                                                                                                                                          Object this$inventoryStartTime = this.getInventoryStartTime();
                                                                                                                                          Object other$inventoryStartTime = other.getInventoryStartTime();
                                                                                                                                          if (this$inventoryStartTime
                                                                                                                                                == null
                                                                                                                                             ? other$inventoryStartTime
                                                                                                                                                == null
                                                                                                                                             : this$inventoryStartTime.equals(
                                                                                                                                                other$inventoryStartTime
                                                                                                                                             )) {
                                                                                                                                             Object this$inventoryEndTime = this.getInventoryEndTime();
                                                                                                                                             Object other$inventoryEndTime = other.getInventoryEndTime();
                                                                                                                                             if (this$inventoryEndTime
                                                                                                                                                   == null
                                                                                                                                                ? other$inventoryEndTime
                                                                                                                                                   == null
                                                                                                                                                : this$inventoryEndTime.equals(
                                                                                                                                                   other$inventoryEndTime
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
                                                                                                                                                      Object this$surplusGraphicsPath = this.getSurplusGraphicsPath();
                                                                                                                                                      Object other$surplusGraphicsPath = other.getSurplusGraphicsPath();
                                                                                                                                                      if (this$surplusGraphicsPath
                                                                                                                                                            == null
                                                                                                                                                         ? other$surplusGraphicsPath
                                                                                                                                                            == null
                                                                                                                                                         : this$surplusGraphicsPath.equals(
                                                                                                                                                            other$surplusGraphicsPath
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
                                                                                                                                                            Object this$surplusSn = this.getSurplusSn();
                                                                                                                                                            Object other$surplusSn = other.getSurplusSn();
                                                                                                                                                            if (this$surplusSn
                                                                                                                                                                  == null
                                                                                                                                                               ? other$surplusSn
                                                                                                                                                                  == null
                                                                                                                                                               : this$surplusSn.equals(
                                                                                                                                                                  other$surplusSn
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$convertNumber = this.getConvertNumber();
                                                                                                                                                               Object other$convertNumber = other.getConvertNumber();
                                                                                                                                                               if (this$convertNumber
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$convertNumber
                                                                                                                                                                     == null
                                                                                                                                                                  : this$convertNumber.equals(
                                                                                                                                                                     other$convertNumber
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$workshopName = this.getWorkshopName();
                                                                                                                                                                  Object other$workshopName = other.getWorkshopName();
                                                                                                                                                                  if (this$workshopName
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$workshopName
                                                                                                                                                                        == null
                                                                                                                                                                     : this$workshopName.equals(
                                                                                                                                                                        other$workshopName
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$recipientName = this.getRecipientName();
                                                                                                                                                                     Object other$recipientName = other.getRecipientName();
                                                                                                                                                                     if (this$recipientName
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$recipientName
                                                                                                                                                                           == null
                                                                                                                                                                        : this$recipientName.equals(
                                                                                                                                                                           other$recipientName
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$warehouse = this.getWarehouse();
                                                                                                                                                                        Object other$warehouse = other.getWarehouse();
                                                                                                                                                                        if (this$warehouse
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$warehouse
                                                                                                                                                                              == null
                                                                                                                                                                           : this$warehouse.equals(
                                                                                                                                                                              other$warehouse
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$project = this.getProject();
                                                                                                                                                                           Object other$project = other.getProject();
                                                                                                                                                                           if (this$project
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$project
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$project.equals(
                                                                                                                                                                                 other$project
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$monomerName = this.getMonomerName();
                                                                                                                                                                              Object other$monomerName = other.getMonomerName();
                                                                                                                                                                              if (this$monomerName
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$monomerName
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$monomerName.equals(
                                                                                                                                                                                    other$monomerName
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$areaName = this.getAreaName();
                                                                                                                                                                                 Object other$areaName = other.getAreaName();
                                                                                                                                                                                 if (this$areaName
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$areaName
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$areaName.equals(
                                                                                                                                                                                       other$areaName
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$outboundTime = this.getOutboundTime();
                                                                                                                                                                                    Object other$outboundTime = other.getOutboundTime();
                                                                                                                                                                                    if (this$outboundTime
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$outboundTime
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$outboundTime.equals(
                                                                                                                                                                                          other$outboundTime
                                                                                                                                                                                       )
                                                                                                                                                                                       )
                                                                                                                                                                                     {
                                                                                                                                                                                       Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                                                                                                                                       Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                                                                                                                                       return this$amountExcludingVat
                                                                                                                                                                                             == null
                                                                                                                                                                                          ? other$amountExcludingVat
                                                                                                                                                                                             == null
                                                                                                                                                                                          : this$amountExcludingVat.equals(
                                                                                                                                                                                             other$amountExcludingVat
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
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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

   protected boolean canEqual(final Object other) {
      return other instanceof ConvertDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $useStatus = this.getUseStatus();
      result = result * 59 + ($useStatus == null ? 43 : $useStatus.hashCode());
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
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $boolHasFrozen = this.getBoolHasFrozen();
      result = result * 59 + ($boolHasFrozen == null ? 43 : $boolHasFrozen.hashCode());
      Object $sourceMaterielId = this.getSourceMaterielId();
      result = result * 59 + ($sourceMaterielId == null ? 43 : $sourceMaterielId.hashCode());
      Object $boolVirtual = this.getBoolVirtual();
      result = result * 59 + ($boolVirtual == null ? 43 : $boolVirtual.hashCode());
      Object $convertId = this.getConvertId();
      result = result * 59 + ($convertId == null ? 43 : $convertId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $boolSurplus = this.getBoolSurplus();
      result = result * 59 + ($boolSurplus == null ? 43 : $boolSurplus.hashCode());
      Object $boolOutbound = this.getBoolOutbound();
      result = result * 59 + ($boolOutbound == null ? 43 : $boolOutbound.hashCode());
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
      Object $weightedAverageSpec = this.getWeightedAverageSpec();
      result = result * 59 + ($weightedAverageSpec == null ? 43 : $weightedAverageSpec.hashCode());
      Object $inventoryStartTime = this.getInventoryStartTime();
      result = result * 59 + ($inventoryStartTime == null ? 43 : $inventoryStartTime.hashCode());
      Object $inventoryEndTime = this.getInventoryEndTime();
      result = result * 59 + ($inventoryEndTime == null ? 43 : $inventoryEndTime.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $sectionSteelWeight = this.getSectionSteelWeight();
      result = result * 59 + ($sectionSteelWeight == null ? 43 : $sectionSteelWeight.hashCode());
      Object $surplusGraphicsPath = this.getSurplusGraphicsPath();
      result = result * 59 + ($surplusGraphicsPath == null ? 43 : $surplusGraphicsPath.hashCode());
      Object $barcode = this.getBarcode();
      result = result * 59 + ($barcode == null ? 43 : $barcode.hashCode());
      Object $surplusSn = this.getSurplusSn();
      result = result * 59 + ($surplusSn == null ? 43 : $surplusSn.hashCode());
      Object $convertNumber = this.getConvertNumber();
      result = result * 59 + ($convertNumber == null ? 43 : $convertNumber.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $recipientName = this.getRecipientName();
      result = result * 59 + ($recipientName == null ? 43 : $recipientName.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      return result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
   }

   @Override
   public String toString() {
      return "ConvertDetailDTO(useStatus="
         + this.getUseStatus()
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
         + ", warehouseId="
         + this.getWarehouseId()
         + ", factoryId="
         + this.getFactoryId()
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
         + ", weightedAverageSpec="
         + this.getWeightedAverageSpec()
         + ", inventoryStartTime="
         + this.getInventoryStartTime()
         + ", inventoryEndTime="
         + this.getInventoryEndTime()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", sectionSteelWeight="
         + this.getSectionSteelWeight()
         + ", boolHasFrozen="
         + this.getBoolHasFrozen()
         + ", surplusGraphicsPath="
         + this.getSurplusGraphicsPath()
         + ", sourceMaterielId="
         + this.getSourceMaterielId()
         + ", barcode="
         + this.getBarcode()
         + ", surplusSn="
         + this.getSurplusSn()
         + ", boolVirtual="
         + this.getBoolVirtual()
         + ", convertId="
         + this.getConvertId()
         + ", convertNumber="
         + this.getConvertNumber()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", recipientId="
         + this.getRecipientId()
         + ", recipientName="
         + this.getRecipientName()
         + ", warehouse="
         + this.getWarehouse()
         + ", project="
         + this.getProject()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", boolSurplus="
         + this.getBoolSurplus()
         + ", boolOutbound="
         + this.getBoolOutbound()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", outboundAddress="
         + this.getOutboundAddress()
         + ")";
   }

   public ConvertDetailDTO(
      final Boolean useStatus,
      final String serialNumber,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final String specification,
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
      final Long warehouseId,
      final Long factoryId,
      final Integer weightMeasurementMode,
      final BigDecimal taxRate,
      final Integer invoiceType,
      final String remark,
      final String outboundSn,
      final String weightedAverageSpec,
      final LocalDateTime inventoryStartTime,
      final LocalDateTime inventoryEndTime,
      final Long standardId,
      final String standardName,
      final BigDecimal sectionSteelWeight,
      final Boolean boolHasFrozen,
      final String surplusGraphicsPath,
      final Long sourceMaterielId,
      final String barcode,
      final String surplusSn,
      final Boolean boolVirtual,
      final Long convertId,
      final String convertNumber,
      final Long workshopId,
      final String workshopName,
      final Long recipientId,
      final String recipientName,
      final BriefIdAndNameDTO warehouse,
      final ProjectInfo project,
      final String monomerName,
      final String areaName,
      final LocalDateTime outboundTime,
      final Boolean boolSurplus,
      final Boolean boolOutbound,
      final BigDecimal amountExcludingVat,
      final Integer outboundAddress
   ) {
      this.useStatus = useStatus;
      this.serialNumber = serialNumber;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.specification = specification;
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
      this.warehouseId = warehouseId;
      this.factoryId = factoryId;
      this.weightMeasurementMode = weightMeasurementMode;
      this.taxRate = taxRate;
      this.invoiceType = invoiceType;
      this.remark = remark;
      this.outboundSn = outboundSn;
      this.weightedAverageSpec = weightedAverageSpec;
      this.inventoryStartTime = inventoryStartTime;
      this.inventoryEndTime = inventoryEndTime;
      this.standardId = standardId;
      this.standardName = standardName;
      this.sectionSteelWeight = sectionSteelWeight;
      this.boolHasFrozen = boolHasFrozen;
      this.surplusGraphicsPath = surplusGraphicsPath;
      this.sourceMaterielId = sourceMaterielId;
      this.barcode = barcode;
      this.surplusSn = surplusSn;
      this.boolVirtual = boolVirtual;
      this.convertId = convertId;
      this.convertNumber = convertNumber;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.recipientId = recipientId;
      this.recipientName = recipientName;
      this.warehouse = warehouse;
      this.project = project;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.outboundTime = outboundTime;
      this.boolSurplus = boolSurplus;
      this.boolOutbound = boolOutbound;
      this.amountExcludingVat = amountExcludingVat;
      this.outboundAddress = outboundAddress;
   }

   public ConvertDetailDTO() {
   }

   public static class ConvertDetailDTOBuilder {
      private Boolean useStatus;
      private String serialNumber;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private String specification;
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
      private Long warehouseId;
      private Long factoryId;
      private Integer weightMeasurementMode;
      private BigDecimal taxRate;
      private Integer invoiceType;
      private String remark;
      private String outboundSn;
      private String weightedAverageSpec;
      private LocalDateTime inventoryStartTime;
      private LocalDateTime inventoryEndTime;
      private Long standardId;
      private String standardName;
      private BigDecimal sectionSteelWeight;
      private Boolean boolHasFrozen;
      private String surplusGraphicsPath;
      private Long sourceMaterielId;
      private String barcode;
      private String surplusSn;
      private Boolean boolVirtual;
      private Long convertId;
      private String convertNumber;
      private Long workshopId;
      private String workshopName;
      private Long recipientId;
      private String recipientName;
      private BriefIdAndNameDTO warehouse;
      private ProjectInfo project;
      private String monomerName;
      private String areaName;
      private LocalDateTime outboundTime;
      private Boolean boolSurplus;
      private Boolean boolOutbound;
      private BigDecimal amountExcludingVat;
      private Integer outboundAddress;

      ConvertDetailDTOBuilder() {
      }

      @JsonProperty("useStatus")
      public ConvertDetailDTO.ConvertDetailDTOBuilder useStatus(final Boolean useStatus) {
         this.useStatus = useStatus;
         return this;
      }

      @JsonProperty("serialNumber")
      public ConvertDetailDTO.ConvertDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("basicClass")
      public ConvertDetailDTO.ConvertDetailDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public ConvertDetailDTO.ConvertDetailDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public ConvertDetailDTO.ConvertDetailDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("specification")
      public ConvertDetailDTO.ConvertDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public ConvertDetailDTO.ConvertDetailDTOBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("warehouseType")
      public ConvertDetailDTO.ConvertDetailDTOBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      @JsonProperty("projectId")
      public ConvertDetailDTO.ConvertDetailDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public ConvertDetailDTO.ConvertDetailDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public ConvertDetailDTO.ConvertDetailDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("boolPartyA")
      public ConvertDetailDTO.ConvertDetailDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("quantity")
      public ConvertDetailDTO.ConvertDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("length")
      public ConvertDetailDTO.ConvertDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public ConvertDetailDTO.ConvertDetailDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public ConvertDetailDTO.ConvertDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("theoryThickness")
      public ConvertDetailDTO.ConvertDetailDTOBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("oneTheoryWeight")
      public ConvertDetailDTO.ConvertDetailDTOBuilder oneTheoryWeight(final BigDecimal oneTheoryWeight) {
         this.oneTheoryWeight = oneTheoryWeight;
         return this;
      }

      @JsonProperty("brand")
      public ConvertDetailDTO.ConvertDetailDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public ConvertDetailDTO.ConvertDetailDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("color")
      public ConvertDetailDTO.ConvertDetailDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("measureUnit")
      public ConvertDetailDTO.ConvertDetailDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      @JsonProperty("accountingPrecision")
      public ConvertDetailDTO.ConvertDetailDTOBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      @JsonProperty("accountingUnit")
      public ConvertDetailDTO.ConvertDetailDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("unitNet")
      public ConvertDetailDTO.ConvertDetailDTOBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("mete")
      public ConvertDetailDTO.ConvertDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("warehouseId")
      public ConvertDetailDTO.ConvertDetailDTOBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("factoryId")
      public ConvertDetailDTO.ConvertDetailDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("weightMeasurementMode")
      public ConvertDetailDTO.ConvertDetailDTOBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      @JsonProperty("taxRate")
      public ConvertDetailDTO.ConvertDetailDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      @JsonProperty("invoiceType")
      public ConvertDetailDTO.ConvertDetailDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      @JsonProperty("remark")
      public ConvertDetailDTO.ConvertDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("outboundSn")
      public ConvertDetailDTO.ConvertDetailDTOBuilder outboundSn(final String outboundSn) {
         this.outboundSn = outboundSn;
         return this;
      }

      @JsonProperty("weightedAverageSpec")
      public ConvertDetailDTO.ConvertDetailDTOBuilder weightedAverageSpec(final String weightedAverageSpec) {
         this.weightedAverageSpec = weightedAverageSpec;
         return this;
      }

      @JsonProperty("inventoryStartTime")
      public ConvertDetailDTO.ConvertDetailDTOBuilder inventoryStartTime(final LocalDateTime inventoryStartTime) {
         this.inventoryStartTime = inventoryStartTime;
         return this;
      }

      @JsonProperty("inventoryEndTime")
      public ConvertDetailDTO.ConvertDetailDTOBuilder inventoryEndTime(final LocalDateTime inventoryEndTime) {
         this.inventoryEndTime = inventoryEndTime;
         return this;
      }

      @JsonProperty("standardId")
      public ConvertDetailDTO.ConvertDetailDTOBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public ConvertDetailDTO.ConvertDetailDTOBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("sectionSteelWeight")
      public ConvertDetailDTO.ConvertDetailDTOBuilder sectionSteelWeight(final BigDecimal sectionSteelWeight) {
         this.sectionSteelWeight = sectionSteelWeight;
         return this;
      }

      @JsonProperty("boolHasFrozen")
      public ConvertDetailDTO.ConvertDetailDTOBuilder boolHasFrozen(final Boolean boolHasFrozen) {
         this.boolHasFrozen = boolHasFrozen;
         return this;
      }

      @JsonProperty("surplusGraphicsPath")
      public ConvertDetailDTO.ConvertDetailDTOBuilder surplusGraphicsPath(final String surplusGraphicsPath) {
         this.surplusGraphicsPath = surplusGraphicsPath;
         return this;
      }

      @JsonProperty("sourceMaterielId")
      public ConvertDetailDTO.ConvertDetailDTOBuilder sourceMaterielId(final Long sourceMaterielId) {
         this.sourceMaterielId = sourceMaterielId;
         return this;
      }

      @JsonProperty("barcode")
      public ConvertDetailDTO.ConvertDetailDTOBuilder barcode(final String barcode) {
         this.barcode = barcode;
         return this;
      }

      @JsonProperty("surplusSn")
      public ConvertDetailDTO.ConvertDetailDTOBuilder surplusSn(final String surplusSn) {
         this.surplusSn = surplusSn;
         return this;
      }

      @JsonProperty("boolVirtual")
      public ConvertDetailDTO.ConvertDetailDTOBuilder boolVirtual(final Boolean boolVirtual) {
         this.boolVirtual = boolVirtual;
         return this;
      }

      @JsonProperty("convertId")
      public ConvertDetailDTO.ConvertDetailDTOBuilder convertId(final Long convertId) {
         this.convertId = convertId;
         return this;
      }

      @JsonProperty("convertNumber")
      public ConvertDetailDTO.ConvertDetailDTOBuilder convertNumber(final String convertNumber) {
         this.convertNumber = convertNumber;
         return this;
      }

      public ConvertDetailDTO.ConvertDetailDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public ConvertDetailDTO.ConvertDetailDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public ConvertDetailDTO.ConvertDetailDTOBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      public ConvertDetailDTO.ConvertDetailDTOBuilder recipientName(final String recipientName) {
         this.recipientName = recipientName;
         return this;
      }

      public ConvertDetailDTO.ConvertDetailDTOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public ConvertDetailDTO.ConvertDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ConvertDetailDTO.ConvertDetailDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public ConvertDetailDTO.ConvertDetailDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public ConvertDetailDTO.ConvertDetailDTOBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      public ConvertDetailDTO.ConvertDetailDTOBuilder boolSurplus(final Boolean boolSurplus) {
         this.boolSurplus = boolSurplus;
         return this;
      }

      public ConvertDetailDTO.ConvertDetailDTOBuilder boolOutbound(final Boolean boolOutbound) {
         this.boolOutbound = boolOutbound;
         return this;
      }

      public ConvertDetailDTO.ConvertDetailDTOBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public ConvertDetailDTO.ConvertDetailDTOBuilder outboundAddress(final Integer outboundAddress) {
         this.outboundAddress = outboundAddress;
         return this;
      }

      public ConvertDetailDTO build() {
         return new ConvertDetailDTO(
            this.useStatus,
            this.serialNumber,
            this.basicClass,
            this.classifyId,
            this.classifyName,
            this.specification,
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
            this.warehouseId,
            this.factoryId,
            this.weightMeasurementMode,
            this.taxRate,
            this.invoiceType,
            this.remark,
            this.outboundSn,
            this.weightedAverageSpec,
            this.inventoryStartTime,
            this.inventoryEndTime,
            this.standardId,
            this.standardName,
            this.sectionSteelWeight,
            this.boolHasFrozen,
            this.surplusGraphicsPath,
            this.sourceMaterielId,
            this.barcode,
            this.surplusSn,
            this.boolVirtual,
            this.convertId,
            this.convertNumber,
            this.workshopId,
            this.workshopName,
            this.recipientId,
            this.recipientName,
            this.warehouse,
            this.project,
            this.monomerName,
            this.areaName,
            this.outboundTime,
            this.boolSurplus,
            this.boolOutbound,
            this.amountExcludingVat,
            this.outboundAddress
         );
      }

      @Override
      public String toString() {
         return "ConvertDetailDTO.ConvertDetailDTOBuilder(useStatus="
            + this.useStatus
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
            + ", warehouseId="
            + this.warehouseId
            + ", factoryId="
            + this.factoryId
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
            + ", weightedAverageSpec="
            + this.weightedAverageSpec
            + ", inventoryStartTime="
            + this.inventoryStartTime
            + ", inventoryEndTime="
            + this.inventoryEndTime
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", sectionSteelWeight="
            + this.sectionSteelWeight
            + ", boolHasFrozen="
            + this.boolHasFrozen
            + ", surplusGraphicsPath="
            + this.surplusGraphicsPath
            + ", sourceMaterielId="
            + this.sourceMaterielId
            + ", barcode="
            + this.barcode
            + ", surplusSn="
            + this.surplusSn
            + ", boolVirtual="
            + this.boolVirtual
            + ", convertId="
            + this.convertId
            + ", convertNumber="
            + this.convertNumber
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", recipientId="
            + this.recipientId
            + ", recipientName="
            + this.recipientName
            + ", warehouse="
            + this.warehouse
            + ", project="
            + this.project
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", outboundTime="
            + this.outboundTime
            + ", boolSurplus="
            + this.boolSurplus
            + ", boolOutbound="
            + this.boolOutbound
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", outboundAddress="
            + this.outboundAddress
            + ")";
      }
   }
}
