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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "InventoryUseStatistics对象", description = "库存使用统计")
@Entity
@TableName("wms_inventory_use_statistics")
@Table(name = "wms_inventory_use_statistics")
public class InventoryUseStatistics extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "statisticsDateId", value = "关联的库存使用统计日期ID", notes = "关联的库存使用统计日期ID")
   @JsonProperty("statisticsDateId")
   @JSONField(name = "statisticsDateId")
   @TableField("statistics_date_id")
   @Column(name = "statistics_date_id", columnDefinition = "bigint  COMMENT '关联的库存使用统计日期ID'", nullable = true)
   private Long statisticsDateId;
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
   @ApiModelProperty(name = "model", value = "型号", notes = "型号")
   @JsonProperty("model")
   @JSONField(name = "model")
   @TableField("model")
   @Column(name = "model", columnDefinition = "varchar(255)  COMMENT '型号'", nullable = true)
   private String model;
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
   @ApiModelProperty(name = "boolPartyA", value = "是否为甲供物料", notes = "是否为甲供物料")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否为甲供物料'", nullable = true)
   private Boolean boolPartyA;
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
   @ApiModelProperty(name = "thickness", value = "厚度", notes = "厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8)  COMMENT '厚度'", nullable = true)
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
   @ApiModelProperty(name = "unitNet", value = "单位净量(针对辅材,计量/核算量=单位净量)", notes = "单位净量(针对辅材,计量/核算量=单位净量)")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(32,12)  COMMENT '单位净量(针对辅材,计量/核算量=单位净量)'", nullable = true)
   private BigDecimal unitNet;
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
   @ApiModelProperty(name = "serialNumber", value = "物料编号", notes = "物料编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '物料编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "workshopId", value = "仓库ID -> wms", notes = "仓库ID -> wms")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '仓库ID -> wms'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "warehouseId", value = "仓库位置ID -> wms", notes = "仓库位置ID -> wms")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '仓库位置ID -> wms'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "beginStageTotalQuantity", value = "期初总数量", notes = "期初总数量")
   @JsonProperty("beginStageTotalQuantity")
   @JSONField(name = "beginStageTotalQuantity")
   @TableField("begin_stage_total_quantity")
   @Column(name = "begin_stage_total_quantity", columnDefinition = "decimal(32,8) default '0' COMMENT '期初总数量'", nullable = true)
   private BigDecimal beginStageTotalQuantity;
   @ApiModelProperty(name = "beginStageTotalMete", value = "期初总核算量", notes = "期初总核算量")
   @JsonProperty("beginStageTotalMete")
   @JSONField(name = "beginStageTotalMete")
   @TableField("begin_stage_total_mete")
   @Column(name = "begin_stage_total_mete", columnDefinition = "decimal(32,8) default '0' COMMENT '期初总核算量'", nullable = true)
   private BigDecimal beginStageTotalMete;
   @ApiModelProperty(name = "inboundStageTotalQuantity", value = "入库总数量", notes = "入库总数量")
   @JsonProperty("inboundStageTotalQuantity")
   @JSONField(name = "inboundStageTotalQuantity")
   @TableField("inbound_stage_total_quantity")
   @Column(name = "inbound_stage_total_quantity", columnDefinition = "decimal(32,8) default '0' COMMENT '入库总数量'", nullable = true)
   private BigDecimal inboundStageTotalQuantity;
   @ApiModelProperty(name = "inboundStageTotalMete", value = "入库总核算量", notes = "入库总核算量")
   @JsonProperty("inboundStageTotalMete")
   @JSONField(name = "inboundStageTotalMete")
   @TableField("inbound_stage_total_mete")
   @Column(name = "inbound_stage_total_mete", columnDefinition = "decimal(32,8) default '0' COMMENT '入库总核算量'", nullable = true)
   private BigDecimal inboundStageTotalMete;
   @ApiModelProperty(name = "transferStageTotalQuantity", value = "调拨总数量", notes = "调拨总数量")
   @JsonProperty("transferStageTotalQuantity")
   @JSONField(name = "transferStageTotalQuantity")
   @TableField("transfer_stage_total_quantity")
   @Column(name = "transfer_stage_total_quantity", columnDefinition = "decimal(32,8) default '0' COMMENT '调拨总数量'", nullable = true)
   private BigDecimal transferStageTotalQuantity;
   @ApiModelProperty(name = "transferStageTotalMete", value = "调拨总核算量", notes = "调拨总核算量")
   @JsonProperty("transferStageTotalMete")
   @JSONField(name = "transferStageTotalMete")
   @TableField("transfer_stage_total_mete")
   @Column(name = "transfer_stage_total_mete", columnDefinition = "decimal(32,8) default '0' COMMENT '调拨总核算量'", nullable = true)
   private BigDecimal transferStageTotalMete;
   @ApiModelProperty(name = "outboundStageTotalQuantity", value = "出库总数量", notes = "出库总数量")
   @JsonProperty("outboundStageTotalQuantity")
   @JSONField(name = "outboundStageTotalQuantity")
   @TableField("outbound_stage_total_quantity")
   @Column(name = "outbound_stage_total_quantity", columnDefinition = "decimal(32,8) default '0' COMMENT '出库总数量'", nullable = true)
   private BigDecimal outboundStageTotalQuantity;
   @ApiModelProperty(name = "outboundStageTotalMete", value = "出库总核算量", notes = "出库总核算量")
   @JsonProperty("outboundStageTotalMete")
   @JSONField(name = "outboundStageTotalMete")
   @TableField("outbound_stage_total_mete")
   @Column(name = "outbound_stage_total_mete", columnDefinition = "decimal(32,8) default '0' COMMENT '出库总核算量'", nullable = true)
   private BigDecimal outboundStageTotalMete;
   @ApiModelProperty(name = "endStageTotalQuantity", value = "期末总数量", notes = "期末总数量")
   @JsonProperty("endStageTotalQuantity")
   @JSONField(name = "endStageTotalQuantity")
   @TableField("end_stage_total_quantity")
   @Column(name = "end_stage_total_quantity", columnDefinition = "decimal(32,8) default '0' COMMENT '期末总数量'", nullable = true)
   private BigDecimal endStageTotalQuantity;
   @ApiModelProperty(name = "endStageTotalMete", value = "期末总核算量", notes = "期末总核算量")
   @JsonProperty("endStageTotalMete")
   @JSONField(name = "endStageTotalMete")
   @TableField("end_stage_total_mete")
   @Column(name = "end_stage_total_mete", columnDefinition = "decimal(32,8) default '0' COMMENT '期末总核算量'", nullable = true)
   private BigDecimal endStageTotalMete;

   public static InventoryUseStatistics.InventoryUseStatisticsBuilder builder() {
      return new InventoryUseStatistics.InventoryUseStatisticsBuilder();
   }

   public InventoryUseStatistics() {
   }

   public InventoryUseStatistics(
      final Long id,
      final Long statisticsDateId,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final String specification,
      final String model,
      final Integer materialIsWhole,
      final Integer warehouseType,
      final Long projectId,
      final Boolean boolPartyA,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final BigDecimal unitNet,
      final Long standardId,
      final String standardName,
      final String serialNumber,
      final Long workshopId,
      final Long warehouseId,
      final BigDecimal beginStageTotalQuantity,
      final BigDecimal beginStageTotalMete,
      final BigDecimal inboundStageTotalQuantity,
      final BigDecimal inboundStageTotalMete,
      final BigDecimal transferStageTotalQuantity,
      final BigDecimal transferStageTotalMete,
      final BigDecimal outboundStageTotalQuantity,
      final BigDecimal outboundStageTotalMete,
      final BigDecimal endStageTotalQuantity,
      final BigDecimal endStageTotalMete
   ) {
      this.id = id;
      this.statisticsDateId = statisticsDateId;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.specification = specification;
      this.model = model;
      this.materialIsWhole = materialIsWhole;
      this.warehouseType = warehouseType;
      this.projectId = projectId;
      this.boolPartyA = boolPartyA;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.unitNet = unitNet;
      this.standardId = standardId;
      this.standardName = standardName;
      this.serialNumber = serialNumber;
      this.workshopId = workshopId;
      this.warehouseId = warehouseId;
      this.beginStageTotalQuantity = beginStageTotalQuantity;
      this.beginStageTotalMete = beginStageTotalMete;
      this.inboundStageTotalQuantity = inboundStageTotalQuantity;
      this.inboundStageTotalMete = inboundStageTotalMete;
      this.transferStageTotalQuantity = transferStageTotalQuantity;
      this.transferStageTotalMete = transferStageTotalMete;
      this.outboundStageTotalQuantity = outboundStageTotalQuantity;
      this.outboundStageTotalMete = outboundStageTotalMete;
      this.endStageTotalQuantity = endStageTotalQuantity;
      this.endStageTotalMete = endStageTotalMete;
   }

   public Long getId() {
      return this.id;
   }

   public Long getStatisticsDateId() {
      return this.statisticsDateId;
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

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
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

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public BigDecimal getBeginStageTotalQuantity() {
      return this.beginStageTotalQuantity;
   }

   public BigDecimal getBeginStageTotalMete() {
      return this.beginStageTotalMete;
   }

   public BigDecimal getInboundStageTotalQuantity() {
      return this.inboundStageTotalQuantity;
   }

   public BigDecimal getInboundStageTotalMete() {
      return this.inboundStageTotalMete;
   }

   public BigDecimal getTransferStageTotalQuantity() {
      return this.transferStageTotalQuantity;
   }

   public BigDecimal getTransferStageTotalMete() {
      return this.transferStageTotalMete;
   }

   public BigDecimal getOutboundStageTotalQuantity() {
      return this.outboundStageTotalQuantity;
   }

   public BigDecimal getOutboundStageTotalMete() {
      return this.outboundStageTotalMete;
   }

   public BigDecimal getEndStageTotalQuantity() {
      return this.endStageTotalQuantity;
   }

   public BigDecimal getEndStageTotalMete() {
      return this.endStageTotalMete;
   }

   @JsonProperty("id")
   public InventoryUseStatistics setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("statisticsDateId")
   public InventoryUseStatistics setStatisticsDateId(final Long statisticsDateId) {
      this.statisticsDateId = statisticsDateId;
      return this;
   }

   @JsonProperty("basicClass")
   public InventoryUseStatistics setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public InventoryUseStatistics setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("classifyName")
   public InventoryUseStatistics setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("specification")
   public InventoryUseStatistics setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("model")
   public InventoryUseStatistics setModel(final String model) {
      this.model = model;
      return this;
   }

   @JsonProperty("materialIsWhole")
   public InventoryUseStatistics setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   @JsonProperty("warehouseType")
   public InventoryUseStatistics setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   @JsonProperty("projectId")
   public InventoryUseStatistics setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("boolPartyA")
   public InventoryUseStatistics setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("length")
   public InventoryUseStatistics setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public InventoryUseStatistics setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public InventoryUseStatistics setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("theoryThickness")
   public InventoryUseStatistics setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("brand")
   public InventoryUseStatistics setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public InventoryUseStatistics setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("color")
   public InventoryUseStatistics setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("unitNet")
   public InventoryUseStatistics setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("standardId")
   public InventoryUseStatistics setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public InventoryUseStatistics setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("serialNumber")
   public InventoryUseStatistics setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("workshopId")
   public InventoryUseStatistics setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("warehouseId")
   public InventoryUseStatistics setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("beginStageTotalQuantity")
   public InventoryUseStatistics setBeginStageTotalQuantity(final BigDecimal beginStageTotalQuantity) {
      this.beginStageTotalQuantity = beginStageTotalQuantity;
      return this;
   }

   @JsonProperty("beginStageTotalMete")
   public InventoryUseStatistics setBeginStageTotalMete(final BigDecimal beginStageTotalMete) {
      this.beginStageTotalMete = beginStageTotalMete;
      return this;
   }

   @JsonProperty("inboundStageTotalQuantity")
   public InventoryUseStatistics setInboundStageTotalQuantity(final BigDecimal inboundStageTotalQuantity) {
      this.inboundStageTotalQuantity = inboundStageTotalQuantity;
      return this;
   }

   @JsonProperty("inboundStageTotalMete")
   public InventoryUseStatistics setInboundStageTotalMete(final BigDecimal inboundStageTotalMete) {
      this.inboundStageTotalMete = inboundStageTotalMete;
      return this;
   }

   @JsonProperty("transferStageTotalQuantity")
   public InventoryUseStatistics setTransferStageTotalQuantity(final BigDecimal transferStageTotalQuantity) {
      this.transferStageTotalQuantity = transferStageTotalQuantity;
      return this;
   }

   @JsonProperty("transferStageTotalMete")
   public InventoryUseStatistics setTransferStageTotalMete(final BigDecimal transferStageTotalMete) {
      this.transferStageTotalMete = transferStageTotalMete;
      return this;
   }

   @JsonProperty("outboundStageTotalQuantity")
   public InventoryUseStatistics setOutboundStageTotalQuantity(final BigDecimal outboundStageTotalQuantity) {
      this.outboundStageTotalQuantity = outboundStageTotalQuantity;
      return this;
   }

   @JsonProperty("outboundStageTotalMete")
   public InventoryUseStatistics setOutboundStageTotalMete(final BigDecimal outboundStageTotalMete) {
      this.outboundStageTotalMete = outboundStageTotalMete;
      return this;
   }

   @JsonProperty("endStageTotalQuantity")
   public InventoryUseStatistics setEndStageTotalQuantity(final BigDecimal endStageTotalQuantity) {
      this.endStageTotalQuantity = endStageTotalQuantity;
      return this;
   }

   @JsonProperty("endStageTotalMete")
   public InventoryUseStatistics setEndStageTotalMete(final BigDecimal endStageTotalMete) {
      this.endStageTotalMete = endStageTotalMete;
      return this;
   }

   @Override
   public String toString() {
      return "InventoryUseStatistics(id="
         + this.getId()
         + ", statisticsDateId="
         + this.getStatisticsDateId()
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
         + ", boolPartyA="
         + this.getBoolPartyA()
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
         + ", unitNet="
         + this.getUnitNet()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", beginStageTotalQuantity="
         + this.getBeginStageTotalQuantity()
         + ", beginStageTotalMete="
         + this.getBeginStageTotalMete()
         + ", inboundStageTotalQuantity="
         + this.getInboundStageTotalQuantity()
         + ", inboundStageTotalMete="
         + this.getInboundStageTotalMete()
         + ", transferStageTotalQuantity="
         + this.getTransferStageTotalQuantity()
         + ", transferStageTotalMete="
         + this.getTransferStageTotalMete()
         + ", outboundStageTotalQuantity="
         + this.getOutboundStageTotalQuantity()
         + ", outboundStageTotalMete="
         + this.getOutboundStageTotalMete()
         + ", endStageTotalQuantity="
         + this.getEndStageTotalQuantity()
         + ", endStageTotalMete="
         + this.getEndStageTotalMete()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryUseStatistics)) {
         return false;
      }

      InventoryUseStatistics other = (InventoryUseStatistics)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$statisticsDateId = this.getStatisticsDateId();
         Object other$statisticsDateId = other.getStatisticsDateId();
         if (this$statisticsDateId == null ? other$statisticsDateId == null : this$statisticsDateId.equals(other$statisticsDateId)) {
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
                           Object this$boolPartyA = this.getBoolPartyA();
                           Object other$boolPartyA = other.getBoolPartyA();
                           if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                              Object this$standardId = this.getStandardId();
                              Object other$standardId = other.getStandardId();
                              if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                 Object this$workshopId = this.getWorkshopId();
                                 Object other$workshopId = other.getWorkshopId();
                                 if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                    Object this$warehouseId = this.getWarehouseId();
                                    Object other$warehouseId = other.getWarehouseId();
                                    if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
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
                                                      Object this$thickness = this.getThickness();
                                                      Object other$thickness = other.getThickness();
                                                      if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
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
                                                                  if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                     Object this$unitNet = this.getUnitNet();
                                                                     Object other$unitNet = other.getUnitNet();
                                                                     if (this$unitNet == null ? other$unitNet == null : this$unitNet.equals(other$unitNet)) {
                                                                        Object this$standardName = this.getStandardName();
                                                                        Object other$standardName = other.getStandardName();
                                                                        if (this$standardName == null
                                                                           ? other$standardName == null
                                                                           : this$standardName.equals(other$standardName)) {
                                                                           Object this$serialNumber = this.getSerialNumber();
                                                                           Object other$serialNumber = other.getSerialNumber();
                                                                           if (this$serialNumber == null
                                                                              ? other$serialNumber == null
                                                                              : this$serialNumber.equals(other$serialNumber)) {
                                                                              Object this$beginStageTotalQuantity = this.getBeginStageTotalQuantity();
                                                                              Object other$beginStageTotalQuantity = other.getBeginStageTotalQuantity();
                                                                              if (this$beginStageTotalQuantity == null
                                                                                 ? other$beginStageTotalQuantity == null
                                                                                 : this$beginStageTotalQuantity.equals(other$beginStageTotalQuantity)) {
                                                                                 Object this$beginStageTotalMete = this.getBeginStageTotalMete();
                                                                                 Object other$beginStageTotalMete = other.getBeginStageTotalMete();
                                                                                 if (this$beginStageTotalMete == null
                                                                                    ? other$beginStageTotalMete == null
                                                                                    : this$beginStageTotalMete.equals(other$beginStageTotalMete)) {
                                                                                    Object this$inboundStageTotalQuantity = this.getInboundStageTotalQuantity();
                                                                                    Object other$inboundStageTotalQuantity = other.getInboundStageTotalQuantity();
                                                                                    if (this$inboundStageTotalQuantity == null
                                                                                       ? other$inboundStageTotalQuantity == null
                                                                                       : this$inboundStageTotalQuantity.equals(other$inboundStageTotalQuantity)
                                                                                       )
                                                                                     {
                                                                                       Object this$inboundStageTotalMete = this.getInboundStageTotalMete();
                                                                                       Object other$inboundStageTotalMete = other.getInboundStageTotalMete();
                                                                                       if (this$inboundStageTotalMete == null
                                                                                          ? other$inboundStageTotalMete == null
                                                                                          : this$inboundStageTotalMete.equals(other$inboundStageTotalMete)) {
                                                                                          Object this$transferStageTotalQuantity = this.getTransferStageTotalQuantity();
                                                                                          Object other$transferStageTotalQuantity = other.getTransferStageTotalQuantity();
                                                                                          if (this$transferStageTotalQuantity == null
                                                                                             ? other$transferStageTotalQuantity == null
                                                                                             : this$transferStageTotalQuantity.equals(
                                                                                                other$transferStageTotalQuantity
                                                                                             )) {
                                                                                             Object this$transferStageTotalMete = this.getTransferStageTotalMete();
                                                                                             Object other$transferStageTotalMete = other.getTransferStageTotalMete();
                                                                                             if (this$transferStageTotalMete == null
                                                                                                ? other$transferStageTotalMete == null
                                                                                                : this$transferStageTotalMete.equals(
                                                                                                   other$transferStageTotalMete
                                                                                                )) {
                                                                                                Object this$outboundStageTotalQuantity = this.getOutboundStageTotalQuantity();
                                                                                                Object other$outboundStageTotalQuantity = other.getOutboundStageTotalQuantity();
                                                                                                if (this$outboundStageTotalQuantity == null
                                                                                                   ? other$outboundStageTotalQuantity == null
                                                                                                   : this$outboundStageTotalQuantity.equals(
                                                                                                      other$outboundStageTotalQuantity
                                                                                                   )) {
                                                                                                   Object this$outboundStageTotalMete = this.getOutboundStageTotalMete();
                                                                                                   Object other$outboundStageTotalMete = other.getOutboundStageTotalMete();
                                                                                                   if (this$outboundStageTotalMete == null
                                                                                                      ? other$outboundStageTotalMete == null
                                                                                                      : this$outboundStageTotalMete.equals(
                                                                                                         other$outboundStageTotalMete
                                                                                                      )) {
                                                                                                      Object this$endStageTotalQuantity = this.getEndStageTotalQuantity();
                                                                                                      Object other$endStageTotalQuantity = other.getEndStageTotalQuantity();
                                                                                                      if (this$endStageTotalQuantity == null
                                                                                                         ? other$endStageTotalQuantity == null
                                                                                                         : this$endStageTotalQuantity.equals(
                                                                                                            other$endStageTotalQuantity
                                                                                                         )) {
                                                                                                         Object this$endStageTotalMete = this.getEndStageTotalMete();
                                                                                                         Object other$endStageTotalMete = other.getEndStageTotalMete();
                                                                                                         return this$endStageTotalMete == null
                                                                                                            ? other$endStageTotalMete == null
                                                                                                            : this$endStageTotalMete.equals(
                                                                                                               other$endStageTotalMete
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof InventoryUseStatistics;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $statisticsDateId = this.getStatisticsDateId();
      result = result * 59 + ($statisticsDateId == null ? 43 : $statisticsDateId.hashCode());
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
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
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
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $beginStageTotalQuantity = this.getBeginStageTotalQuantity();
      result = result * 59 + ($beginStageTotalQuantity == null ? 43 : $beginStageTotalQuantity.hashCode());
      Object $beginStageTotalMete = this.getBeginStageTotalMete();
      result = result * 59 + ($beginStageTotalMete == null ? 43 : $beginStageTotalMete.hashCode());
      Object $inboundStageTotalQuantity = this.getInboundStageTotalQuantity();
      result = result * 59 + ($inboundStageTotalQuantity == null ? 43 : $inboundStageTotalQuantity.hashCode());
      Object $inboundStageTotalMete = this.getInboundStageTotalMete();
      result = result * 59 + ($inboundStageTotalMete == null ? 43 : $inboundStageTotalMete.hashCode());
      Object $transferStageTotalQuantity = this.getTransferStageTotalQuantity();
      result = result * 59 + ($transferStageTotalQuantity == null ? 43 : $transferStageTotalQuantity.hashCode());
      Object $transferStageTotalMete = this.getTransferStageTotalMete();
      result = result * 59 + ($transferStageTotalMete == null ? 43 : $transferStageTotalMete.hashCode());
      Object $outboundStageTotalQuantity = this.getOutboundStageTotalQuantity();
      result = result * 59 + ($outboundStageTotalQuantity == null ? 43 : $outboundStageTotalQuantity.hashCode());
      Object $outboundStageTotalMete = this.getOutboundStageTotalMete();
      result = result * 59 + ($outboundStageTotalMete == null ? 43 : $outboundStageTotalMete.hashCode());
      Object $endStageTotalQuantity = this.getEndStageTotalQuantity();
      result = result * 59 + ($endStageTotalQuantity == null ? 43 : $endStageTotalQuantity.hashCode());
      Object $endStageTotalMete = this.getEndStageTotalMete();
      return result * 59 + ($endStageTotalMete == null ? 43 : $endStageTotalMete.hashCode());
   }

   public static class InventoryUseStatisticsBuilder {
      private Long id;
      private Long statisticsDateId;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private String specification;
      private String model;
      private Integer materialIsWhole;
      private Integer warehouseType;
      private Long projectId;
      private Boolean boolPartyA;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private BigDecimal unitNet;
      private Long standardId;
      private String standardName;
      private String serialNumber;
      private Long workshopId;
      private Long warehouseId;
      private BigDecimal beginStageTotalQuantity;
      private BigDecimal beginStageTotalMete;
      private BigDecimal inboundStageTotalQuantity;
      private BigDecimal inboundStageTotalMete;
      private BigDecimal transferStageTotalQuantity;
      private BigDecimal transferStageTotalMete;
      private BigDecimal outboundStageTotalQuantity;
      private BigDecimal outboundStageTotalMete;
      private BigDecimal endStageTotalQuantity;
      private BigDecimal endStageTotalMete;

      InventoryUseStatisticsBuilder() {
      }

      @JsonProperty("id")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("statisticsDateId")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder statisticsDateId(final Long statisticsDateId) {
         this.statisticsDateId = statisticsDateId;
         return this;
      }

      @JsonProperty("basicClass")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("specification")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("model")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder model(final String model) {
         this.model = model;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("warehouseType")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      @JsonProperty("projectId")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("boolPartyA")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("length")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("theoryThickness")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("brand")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("color")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("unitNet")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("standardId")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("serialNumber")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("workshopId")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("warehouseId")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("beginStageTotalQuantity")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder beginStageTotalQuantity(final BigDecimal beginStageTotalQuantity) {
         this.beginStageTotalQuantity = beginStageTotalQuantity;
         return this;
      }

      @JsonProperty("beginStageTotalMete")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder beginStageTotalMete(final BigDecimal beginStageTotalMete) {
         this.beginStageTotalMete = beginStageTotalMete;
         return this;
      }

      @JsonProperty("inboundStageTotalQuantity")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder inboundStageTotalQuantity(final BigDecimal inboundStageTotalQuantity) {
         this.inboundStageTotalQuantity = inboundStageTotalQuantity;
         return this;
      }

      @JsonProperty("inboundStageTotalMete")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder inboundStageTotalMete(final BigDecimal inboundStageTotalMete) {
         this.inboundStageTotalMete = inboundStageTotalMete;
         return this;
      }

      @JsonProperty("transferStageTotalQuantity")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder transferStageTotalQuantity(final BigDecimal transferStageTotalQuantity) {
         this.transferStageTotalQuantity = transferStageTotalQuantity;
         return this;
      }

      @JsonProperty("transferStageTotalMete")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder transferStageTotalMete(final BigDecimal transferStageTotalMete) {
         this.transferStageTotalMete = transferStageTotalMete;
         return this;
      }

      @JsonProperty("outboundStageTotalQuantity")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder outboundStageTotalQuantity(final BigDecimal outboundStageTotalQuantity) {
         this.outboundStageTotalQuantity = outboundStageTotalQuantity;
         return this;
      }

      @JsonProperty("outboundStageTotalMete")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder outboundStageTotalMete(final BigDecimal outboundStageTotalMete) {
         this.outboundStageTotalMete = outboundStageTotalMete;
         return this;
      }

      @JsonProperty("endStageTotalQuantity")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder endStageTotalQuantity(final BigDecimal endStageTotalQuantity) {
         this.endStageTotalQuantity = endStageTotalQuantity;
         return this;
      }

      @JsonProperty("endStageTotalMete")
      public InventoryUseStatistics.InventoryUseStatisticsBuilder endStageTotalMete(final BigDecimal endStageTotalMete) {
         this.endStageTotalMete = endStageTotalMete;
         return this;
      }

      public InventoryUseStatistics build() {
         return new InventoryUseStatistics(
            this.id,
            this.statisticsDateId,
            this.basicClass,
            this.classifyId,
            this.classifyName,
            this.specification,
            this.model,
            this.materialIsWhole,
            this.warehouseType,
            this.projectId,
            this.boolPartyA,
            this.length,
            this.width,
            this.thickness,
            this.theoryThickness,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.unitNet,
            this.standardId,
            this.standardName,
            this.serialNumber,
            this.workshopId,
            this.warehouseId,
            this.beginStageTotalQuantity,
            this.beginStageTotalMete,
            this.inboundStageTotalQuantity,
            this.inboundStageTotalMete,
            this.transferStageTotalQuantity,
            this.transferStageTotalMete,
            this.outboundStageTotalQuantity,
            this.outboundStageTotalMete,
            this.endStageTotalQuantity,
            this.endStageTotalMete
         );
      }

      @Override
      public String toString() {
         return "InventoryUseStatistics.InventoryUseStatisticsBuilder(id="
            + this.id
            + ", statisticsDateId="
            + this.statisticsDateId
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
            + ", boolPartyA="
            + this.boolPartyA
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
            + ", unitNet="
            + this.unitNet
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", serialNumber="
            + this.serialNumber
            + ", workshopId="
            + this.workshopId
            + ", warehouseId="
            + this.warehouseId
            + ", beginStageTotalQuantity="
            + this.beginStageTotalQuantity
            + ", beginStageTotalMete="
            + this.beginStageTotalMete
            + ", inboundStageTotalQuantity="
            + this.inboundStageTotalQuantity
            + ", inboundStageTotalMete="
            + this.inboundStageTotalMete
            + ", transferStageTotalQuantity="
            + this.transferStageTotalQuantity
            + ", transferStageTotalMete="
            + this.transferStageTotalMete
            + ", outboundStageTotalQuantity="
            + this.outboundStageTotalQuantity
            + ", outboundStageTotalMete="
            + this.outboundStageTotalMete
            + ", endStageTotalQuantity="
            + this.endStageTotalQuantity
            + ", endStageTotalMete="
            + this.endStageTotalMete
            + ")";
      }
   }
}
