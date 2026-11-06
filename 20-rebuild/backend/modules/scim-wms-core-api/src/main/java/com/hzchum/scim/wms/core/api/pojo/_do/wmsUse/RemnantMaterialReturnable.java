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

@ApiModel(value = "RemnantMaterialReturnable对象", description = "可退库余料物料表")
@Entity
@TableName("wms_remnant_material_returnable")
@Table(name = "wms_remnant_material_returnable")
public class RemnantMaterialReturnable extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
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
   @ApiModelProperty(name = "classifyName", value = "科目名称", notes = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   @TableField("classify_name")
   @Column(name = "classify_name", columnDefinition = "varchar(255)  COMMENT '科目名称'", nullable = true)
   private String classifyName;
   @ApiModelProperty(name = "boolPartyA", value = "是否甲供物料", notes = "是否甲供物料")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_A")
   @Column(name = "bool_party_A", columnDefinition = "tinyint(1)  COMMENT '是否甲供物料'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "outboundUnitType", value = "出库单位类型", notes = "出库单位类型")
   @JsonProperty("outboundUnitType")
   @JSONField(name = "outboundUnitType")
   @TableField("outbound_unit_type")
   @Column(name = "outbound_unit_type", columnDefinition = "int  COMMENT '出库单位类型'", nullable = true)
   private Integer outboundUnitType;
   @ApiModelProperty(name = "materialSn", value = "物料编号", notes = "物料编号")
   @JsonProperty("materialSn")
   @JSONField(name = "materialSn")
   @TableField("material_SN")
   @Column(name = "material_SN", columnDefinition = "varchar(255)  COMMENT '物料编号'", nullable = true)
   private String materialSn;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型", notes = "物料基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   @JsonProperty("accountingUnit")
   @JSONField(name = "accountingUnit")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(255)  COMMENT '核算单位'", nullable = true)
   private String accountingUnit;
   @ApiModelProperty(name = "returnableMete", value = "可退库核算量", notes = "可退库核算量")
   @JsonProperty("returnableMete")
   @JSONField(name = "returnableMete")
   @TableField("returnable_mete")
   @Column(name = "returnable_mete", columnDefinition = "decimal(32,8)  COMMENT '可退库核算量'", nullable = true)
   private BigDecimal returnableMete;
   @ApiModelProperty(name = "singleMete", value = "出库单件核算量", notes = "出库单件核算量")
   @JsonProperty("singleMete")
   @JSONField(name = "singleMete")
   @TableField("single_mete")
   @Column(name = "single_mete", columnDefinition = "decimal(32,8)  COMMENT '出库单件核算量'", nullable = true)
   private BigDecimal singleMete;
   @ApiModelProperty(name = "singleReturnableMete", value = "可退库单件核算量", notes = "可退库单件核算量")
   @JsonProperty("singleReturnableMete")
   @JSONField(name = "singleReturnableMete")
   @TableField("single_returnable_mete")
   @Column(name = "single_returnable_mete", columnDefinition = "decimal(32,8)  COMMENT '可退库单件核算量'", nullable = true)
   private BigDecimal singleReturnableMete;
   @ApiModelProperty(name = "singleReturnableLength", value = "可退库单件定尺长度", notes = "可退库单件定尺长度")
   @JsonProperty("singleReturnableLength")
   @JSONField(name = "singleReturnableLength")
   @TableField("single_returnable_length")
   @Column(name = "single_returnable_length", columnDefinition = "decimal(32,8)  COMMENT '可退库单件定尺长度'", nullable = true)
   private BigDecimal singleReturnableLength;
   @ApiModelProperty(name = "unitNet", value = "单位净量", notes = "单位净量")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(32,8)  COMMENT '单位净量'", nullable = true)
   private BigDecimal unitNet;
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
   @Column(name = "theory_thickness", columnDefinition = "decimal(32,0)  COMMENT '理论厚度'", nullable = true)
   private BigDecimal theoryThickness;
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
   @ApiModelProperty(name = "projectId", value = "出库项目", notes = "出库项目")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '出库项目'", nullable = true)
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
   @ApiModelProperty(name = "factoryId", value = "工厂ID")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id")
   private Long factoryId;
   @ApiModelProperty(name = "warehouseId", value = "仓库ID", notes = "仓库ID")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '仓库ID'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "workshopId", value = "车间ID", notes = "车间ID")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间ID'", nullable = true)
   private Long workshopId;
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
   @ApiModelProperty(name = "weightedAverageSpec", value = "加权平均规格(将规格拆分获取不参与加权规格以*号拼接)", notes = "加权平均规格(将规格拆分获取不参与加权规格以*号拼接)")
   @JsonProperty("weightedAverageSpec")
   @JSONField(name = "weightedAverageSpec")
   @TableField("weighted_average_spec")
   @Column(name = "weighted_average_spec", columnDefinition = "varchar(255)  COMMENT '加权平均规格(将规格拆分获取不参与加权规格以*号拼接)'", nullable = true)
   private String weightedAverageSpec;
   @ApiModelProperty(name = "boolReviewPending", value = "是否存在审核中退库单", notes = "是否存在审核中退库单")
   @JsonProperty("boolReviewPending")
   @JSONField(name = "boolReviewPending")
   @TableField("bool_review_pending")
   @Column(name = "bool_review_pending", columnDefinition = "tinyint(1) default '0' COMMENT '是否存在审核中退库单'", nullable = true)
   private Boolean boolReviewPending;
   @ApiModelProperty(name = "sectionSteelWeight", value = "型材国标重量", notes = "型材国标重量")
   @JsonProperty("sectionSteelWeight")
   @JSONField(name = "sectionSteelWeight")
   @TableField("section_steel_weight")
   @Column(name = "section_steel_weight", columnDefinition = "decimal(19,2)  COMMENT '型材国标重量'", nullable = true)
   private BigDecimal sectionSteelWeight;
   @ApiModelProperty(name = "oneTheoryWeight", value = "单件钢材理论重量", notes = "单件钢材理论重量")
   @JsonProperty("oneTheoryWeight")
   @JSONField(name = "oneTheoryWeight")
   @TableField("one_theory_weight")
   @Column(name = "one_theory_weight", columnDefinition = "decimal(19,2)  COMMENT '单件钢材理论重量'", nullable = true)
   private BigDecimal oneTheoryWeight;
   @ApiModelProperty(name = "MaterialReturnableId", value = "可退库ID", notes = "可退库ID")
   @JsonProperty("MaterialReturnableId")
   @JSONField(name = "MaterialReturnableId")
   @TableField("material_returnable_id")
   @Column(name = "material_returnable_id", columnDefinition = "bigint  COMMENT '可退库ID'", nullable = true)
   private Long MaterialReturnableId;
   @ApiModelProperty(name = "areaBatchId", value = "批次ID", notes = "批次ID")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint  COMMENT '批次ID'", nullable = true)
   private Long areaBatchId;
   @ApiModelProperty(name = "recipientId", value = "领用人ID", notes = "领用人ID")
   @JsonProperty("recipientId")
   @JSONField(name = "recipientId")
   @TableField("recipient_id")
   @Column(name = "recipient_id", columnDefinition = "bigint  COMMENT '领用人ID'", nullable = true)
   private Long recipientId;
   @ApiModelProperty(name = "recipientName", value = "领用人名称", notes = "领用人名称")
   @JsonProperty("recipientName")
   @JSONField(name = "recipientName")
   @TableField("recipient_name")
   @Column(name = "recipient_name", columnDefinition = "varchar(255)  COMMENT '领用人名称'", nullable = true)
   private String recipientName;

   public static RemnantMaterialReturnable.RemnantMaterialReturnableBuilder builder() {
      return new RemnantMaterialReturnable.RemnantMaterialReturnableBuilder();
   }

   public RemnantMaterialReturnable() {
   }

   public RemnantMaterialReturnable(
      final Long id,
      final Long classifyId,
      final String classifyName,
      final Boolean boolPartyA,
      final Integer outboundUnitType,
      final String materialSn,
      final Integer basicClass,
      final String specification,
      final String accountingUnit,
      final BigDecimal returnableMete,
      final BigDecimal singleMete,
      final BigDecimal singleReturnableMete,
      final BigDecimal singleReturnableLength,
      final BigDecimal unitNet,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long factoryId,
      final Long warehouseId,
      final Long workshopId,
      final Long standardId,
      final String standardName,
      final String weightedAverageSpec,
      final Boolean boolReviewPending,
      final BigDecimal sectionSteelWeight,
      final BigDecimal oneTheoryWeight,
      final Long MaterialReturnableId,
      final Long areaBatchId,
      final Long recipientId,
      final String recipientName
   ) {
      this.id = id;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.boolPartyA = boolPartyA;
      this.outboundUnitType = outboundUnitType;
      this.materialSn = materialSn;
      this.basicClass = basicClass;
      this.specification = specification;
      this.accountingUnit = accountingUnit;
      this.returnableMete = returnableMete;
      this.singleMete = singleMete;
      this.singleReturnableMete = singleReturnableMete;
      this.singleReturnableLength = singleReturnableLength;
      this.unitNet = unitNet;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.factoryId = factoryId;
      this.warehouseId = warehouseId;
      this.workshopId = workshopId;
      this.standardId = standardId;
      this.standardName = standardName;
      this.weightedAverageSpec = weightedAverageSpec;
      this.boolReviewPending = boolReviewPending;
      this.sectionSteelWeight = sectionSteelWeight;
      this.oneTheoryWeight = oneTheoryWeight;
      this.MaterialReturnableId = MaterialReturnableId;
      this.areaBatchId = areaBatchId;
      this.recipientId = recipientId;
      this.recipientName = recipientName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Integer getOutboundUnitType() {
      return this.outboundUnitType;
   }

   public String getMaterialSn() {
      return this.materialSn;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getReturnableMete() {
      return this.returnableMete;
   }

   public BigDecimal getSingleMete() {
      return this.singleMete;
   }

   public BigDecimal getSingleReturnableMete() {
      return this.singleReturnableMete;
   }

   public BigDecimal getSingleReturnableLength() {
      return this.singleReturnableLength;
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

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
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

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public String getWeightedAverageSpec() {
      return this.weightedAverageSpec;
   }

   public Boolean getBoolReviewPending() {
      return this.boolReviewPending;
   }

   public BigDecimal getSectionSteelWeight() {
      return this.sectionSteelWeight;
   }

   public BigDecimal getOneTheoryWeight() {
      return this.oneTheoryWeight;
   }

   public Long getMaterialReturnableId() {
      return this.MaterialReturnableId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public String getRecipientName() {
      return this.recipientName;
   }

   @JsonProperty("id")
   public RemnantMaterialReturnable setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("classifyId")
   public RemnantMaterialReturnable setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("classifyName")
   public RemnantMaterialReturnable setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("boolPartyA")
   public RemnantMaterialReturnable setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("outboundUnitType")
   public RemnantMaterialReturnable setOutboundUnitType(final Integer outboundUnitType) {
      this.outboundUnitType = outboundUnitType;
      return this;
   }

   @JsonProperty("materialSn")
   public RemnantMaterialReturnable setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
      return this;
   }

   @JsonProperty("basicClass")
   public RemnantMaterialReturnable setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("specification")
   public RemnantMaterialReturnable setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("accountingUnit")
   public RemnantMaterialReturnable setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @JsonProperty("returnableMete")
   public RemnantMaterialReturnable setReturnableMete(final BigDecimal returnableMete) {
      this.returnableMete = returnableMete;
      return this;
   }

   @JsonProperty("singleMete")
   public RemnantMaterialReturnable setSingleMete(final BigDecimal singleMete) {
      this.singleMete = singleMete;
      return this;
   }

   @JsonProperty("singleReturnableMete")
   public RemnantMaterialReturnable setSingleReturnableMete(final BigDecimal singleReturnableMete) {
      this.singleReturnableMete = singleReturnableMete;
      return this;
   }

   @JsonProperty("singleReturnableLength")
   public RemnantMaterialReturnable setSingleReturnableLength(final BigDecimal singleReturnableLength) {
      this.singleReturnableLength = singleReturnableLength;
      return this;
   }

   @JsonProperty("unitNet")
   public RemnantMaterialReturnable setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("length")
   public RemnantMaterialReturnable setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public RemnantMaterialReturnable setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public RemnantMaterialReturnable setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("theoryThickness")
   public RemnantMaterialReturnable setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("brand")
   public RemnantMaterialReturnable setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public RemnantMaterialReturnable setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("color")
   public RemnantMaterialReturnable setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("projectId")
   public RemnantMaterialReturnable setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public RemnantMaterialReturnable setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public RemnantMaterialReturnable setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("factoryId")
   public RemnantMaterialReturnable setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("warehouseId")
   public RemnantMaterialReturnable setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("workshopId")
   public RemnantMaterialReturnable setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("standardId")
   public RemnantMaterialReturnable setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public RemnantMaterialReturnable setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("weightedAverageSpec")
   public RemnantMaterialReturnable setWeightedAverageSpec(final String weightedAverageSpec) {
      this.weightedAverageSpec = weightedAverageSpec;
      return this;
   }

   @JsonProperty("boolReviewPending")
   public RemnantMaterialReturnable setBoolReviewPending(final Boolean boolReviewPending) {
      this.boolReviewPending = boolReviewPending;
      return this;
   }

   @JsonProperty("sectionSteelWeight")
   public RemnantMaterialReturnable setSectionSteelWeight(final BigDecimal sectionSteelWeight) {
      this.sectionSteelWeight = sectionSteelWeight;
      return this;
   }

   @JsonProperty("oneTheoryWeight")
   public RemnantMaterialReturnable setOneTheoryWeight(final BigDecimal oneTheoryWeight) {
      this.oneTheoryWeight = oneTheoryWeight;
      return this;
   }

   @JsonProperty("MaterialReturnableId")
   public RemnantMaterialReturnable setMaterialReturnableId(final Long MaterialReturnableId) {
      this.MaterialReturnableId = MaterialReturnableId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public RemnantMaterialReturnable setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("recipientId")
   public RemnantMaterialReturnable setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
      return this;
   }

   @JsonProperty("recipientName")
   public RemnantMaterialReturnable setRecipientName(final String recipientName) {
      this.recipientName = recipientName;
      return this;
   }

   @Override
   public String toString() {
      return "RemnantMaterialReturnable(id="
         + this.getId()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", outboundUnitType="
         + this.getOutboundUnitType()
         + ", materialSn="
         + this.getMaterialSn()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", returnableMete="
         + this.getReturnableMete()
         + ", singleMete="
         + this.getSingleMete()
         + ", singleReturnableMete="
         + this.getSingleReturnableMete()
         + ", singleReturnableLength="
         + this.getSingleReturnableLength()
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
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", factoryId="
         + this.getFactoryId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", weightedAverageSpec="
         + this.getWeightedAverageSpec()
         + ", boolReviewPending="
         + this.getBoolReviewPending()
         + ", sectionSteelWeight="
         + this.getSectionSteelWeight()
         + ", oneTheoryWeight="
         + this.getOneTheoryWeight()
         + ", MaterialReturnableId="
         + this.getMaterialReturnableId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", recipientId="
         + this.getRecipientId()
         + ", recipientName="
         + this.getRecipientName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RemnantMaterialReturnable)) {
         return false;
      }

      RemnantMaterialReturnable other = (RemnantMaterialReturnable)o;
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
            Object this$boolPartyA = this.getBoolPartyA();
            Object other$boolPartyA = other.getBoolPartyA();
            if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
               Object this$outboundUnitType = this.getOutboundUnitType();
               Object other$outboundUnitType = other.getOutboundUnitType();
               if (this$outboundUnitType == null ? other$outboundUnitType == null : this$outboundUnitType.equals(other$outboundUnitType)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$monomerId = this.getMonomerId();
                        Object other$monomerId = other.getMonomerId();
                        if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                           Object this$areaId = this.getAreaId();
                           Object other$areaId = other.getAreaId();
                           if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                              Object this$factoryId = this.getFactoryId();
                              Object other$factoryId = other.getFactoryId();
                              if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                                 Object this$warehouseId = this.getWarehouseId();
                                 Object other$warehouseId = other.getWarehouseId();
                                 if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                    Object this$workshopId = this.getWorkshopId();
                                    Object other$workshopId = other.getWorkshopId();
                                    if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                       Object this$standardId = this.getStandardId();
                                       Object other$standardId = other.getStandardId();
                                       if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                          Object this$boolReviewPending = this.getBoolReviewPending();
                                          Object other$boolReviewPending = other.getBoolReviewPending();
                                          if (this$boolReviewPending == null
                                             ? other$boolReviewPending == null
                                             : this$boolReviewPending.equals(other$boolReviewPending)) {
                                             Object this$MaterialReturnableId = this.getMaterialReturnableId();
                                             Object other$MaterialReturnableId = other.getMaterialReturnableId();
                                             if (this$MaterialReturnableId == null
                                                ? other$MaterialReturnableId == null
                                                : this$MaterialReturnableId.equals(other$MaterialReturnableId)) {
                                                Object this$areaBatchId = this.getAreaBatchId();
                                                Object other$areaBatchId = other.getAreaBatchId();
                                                if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                                                   Object this$recipientId = this.getRecipientId();
                                                   Object other$recipientId = other.getRecipientId();
                                                   if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
                                                      Object this$classifyName = this.getClassifyName();
                                                      Object other$classifyName = other.getClassifyName();
                                                      if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)
                                                         )
                                                       {
                                                         Object this$materialSn = this.getMaterialSn();
                                                         Object other$materialSn = other.getMaterialSn();
                                                         if (this$materialSn == null ? other$materialSn == null : this$materialSn.equals(other$materialSn)) {
                                                            Object this$specification = this.getSpecification();
                                                            Object other$specification = other.getSpecification();
                                                            if (this$specification == null
                                                               ? other$specification == null
                                                               : this$specification.equals(other$specification)) {
                                                               Object this$accountingUnit = this.getAccountingUnit();
                                                               Object other$accountingUnit = other.getAccountingUnit();
                                                               if (this$accountingUnit == null
                                                                  ? other$accountingUnit == null
                                                                  : this$accountingUnit.equals(other$accountingUnit)) {
                                                                  Object this$returnableMete = this.getReturnableMete();
                                                                  Object other$returnableMete = other.getReturnableMete();
                                                                  if (this$returnableMete == null
                                                                     ? other$returnableMete == null
                                                                     : this$returnableMete.equals(other$returnableMete)) {
                                                                     Object this$singleMete = this.getSingleMete();
                                                                     Object other$singleMete = other.getSingleMete();
                                                                     if (this$singleMete == null
                                                                        ? other$singleMete == null
                                                                        : this$singleMete.equals(other$singleMete)) {
                                                                        Object this$singleReturnableMete = this.getSingleReturnableMete();
                                                                        Object other$singleReturnableMete = other.getSingleReturnableMete();
                                                                        if (this$singleReturnableMete == null
                                                                           ? other$singleReturnableMete == null
                                                                           : this$singleReturnableMete.equals(other$singleReturnableMete)) {
                                                                           Object this$singleReturnableLength = this.getSingleReturnableLength();
                                                                           Object other$singleReturnableLength = other.getSingleReturnableLength();
                                                                           if (this$singleReturnableLength == null
                                                                              ? other$singleReturnableLength == null
                                                                              : this$singleReturnableLength.equals(other$singleReturnableLength)) {
                                                                              Object this$unitNet = this.getUnitNet();
                                                                              Object other$unitNet = other.getUnitNet();
                                                                              if (this$unitNet == null
                                                                                 ? other$unitNet == null
                                                                                 : this$unitNet.equals(other$unitNet)) {
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
                                                                                                      Object this$standardName = this.getStandardName();
                                                                                                      Object other$standardName = other.getStandardName();
                                                                                                      if (this$standardName == null
                                                                                                         ? other$standardName == null
                                                                                                         : this$standardName.equals(other$standardName)) {
                                                                                                         Object this$weightedAverageSpec = this.getWeightedAverageSpec();
                                                                                                         Object other$weightedAverageSpec = other.getWeightedAverageSpec();
                                                                                                         if (this$weightedAverageSpec == null
                                                                                                            ? other$weightedAverageSpec == null
                                                                                                            : this$weightedAverageSpec.equals(
                                                                                                               other$weightedAverageSpec
                                                                                                            )) {
                                                                                                            Object this$sectionSteelWeight = this.getSectionSteelWeight();
                                                                                                            Object other$sectionSteelWeight = other.getSectionSteelWeight();
                                                                                                            if (this$sectionSteelWeight == null
                                                                                                               ? other$sectionSteelWeight == null
                                                                                                               : this$sectionSteelWeight.equals(
                                                                                                                  other$sectionSteelWeight
                                                                                                               )) {
                                                                                                               Object this$oneTheoryWeight = this.getOneTheoryWeight();
                                                                                                               Object other$oneTheoryWeight = other.getOneTheoryWeight();
                                                                                                               if (this$oneTheoryWeight == null
                                                                                                                  ? other$oneTheoryWeight == null
                                                                                                                  : this$oneTheoryWeight.equals(
                                                                                                                     other$oneTheoryWeight
                                                                                                                  )) {
                                                                                                                  Object this$recipientName = this.getRecipientName();
                                                                                                                  Object other$recipientName = other.getRecipientName();
                                                                                                                  return this$recipientName == null
                                                                                                                     ? other$recipientName == null
                                                                                                                     : this$recipientName.equals(
                                                                                                                        other$recipientName
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
      return other instanceof RemnantMaterialReturnable;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $outboundUnitType = this.getOutboundUnitType();
      result = result * 59 + ($outboundUnitType == null ? 43 : $outboundUnitType.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $boolReviewPending = this.getBoolReviewPending();
      result = result * 59 + ($boolReviewPending == null ? 43 : $boolReviewPending.hashCode());
      Object $MaterialReturnableId = this.getMaterialReturnableId();
      result = result * 59 + ($MaterialReturnableId == null ? 43 : $MaterialReturnableId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $materialSn = this.getMaterialSn();
      result = result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $returnableMete = this.getReturnableMete();
      result = result * 59 + ($returnableMete == null ? 43 : $returnableMete.hashCode());
      Object $singleMete = this.getSingleMete();
      result = result * 59 + ($singleMete == null ? 43 : $singleMete.hashCode());
      Object $singleReturnableMete = this.getSingleReturnableMete();
      result = result * 59 + ($singleReturnableMete == null ? 43 : $singleReturnableMete.hashCode());
      Object $singleReturnableLength = this.getSingleReturnableLength();
      result = result * 59 + ($singleReturnableLength == null ? 43 : $singleReturnableLength.hashCode());
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
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $weightedAverageSpec = this.getWeightedAverageSpec();
      result = result * 59 + ($weightedAverageSpec == null ? 43 : $weightedAverageSpec.hashCode());
      Object $sectionSteelWeight = this.getSectionSteelWeight();
      result = result * 59 + ($sectionSteelWeight == null ? 43 : $sectionSteelWeight.hashCode());
      Object $oneTheoryWeight = this.getOneTheoryWeight();
      result = result * 59 + ($oneTheoryWeight == null ? 43 : $oneTheoryWeight.hashCode());
      Object $recipientName = this.getRecipientName();
      return result * 59 + ($recipientName == null ? 43 : $recipientName.hashCode());
   }

   public static class RemnantMaterialReturnableBuilder {
      private Long id;
      private Long classifyId;
      private String classifyName;
      private Boolean boolPartyA;
      private Integer outboundUnitType;
      private String materialSn;
      private Integer basicClass;
      private String specification;
      private String accountingUnit;
      private BigDecimal returnableMete;
      private BigDecimal singleMete;
      private BigDecimal singleReturnableMete;
      private BigDecimal singleReturnableLength;
      private BigDecimal unitNet;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long factoryId;
      private Long warehouseId;
      private Long workshopId;
      private Long standardId;
      private String standardName;
      private String weightedAverageSpec;
      private Boolean boolReviewPending;
      private BigDecimal sectionSteelWeight;
      private BigDecimal oneTheoryWeight;
      private Long MaterialReturnableId;
      private Long areaBatchId;
      private Long recipientId;
      private String recipientName;

      RemnantMaterialReturnableBuilder() {
      }

      @JsonProperty("id")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("classifyId")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("boolPartyA")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("outboundUnitType")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder outboundUnitType(final Integer outboundUnitType) {
         this.outboundUnitType = outboundUnitType;
         return this;
      }

      @JsonProperty("materialSn")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      @JsonProperty("basicClass")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("specification")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("accountingUnit")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("returnableMete")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder returnableMete(final BigDecimal returnableMete) {
         this.returnableMete = returnableMete;
         return this;
      }

      @JsonProperty("singleMete")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder singleMete(final BigDecimal singleMete) {
         this.singleMete = singleMete;
         return this;
      }

      @JsonProperty("singleReturnableMete")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder singleReturnableMete(final BigDecimal singleReturnableMete) {
         this.singleReturnableMete = singleReturnableMete;
         return this;
      }

      @JsonProperty("singleReturnableLength")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder singleReturnableLength(final BigDecimal singleReturnableLength) {
         this.singleReturnableLength = singleReturnableLength;
         return this;
      }

      @JsonProperty("unitNet")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("length")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("theoryThickness")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("brand")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("color")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("projectId")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("factoryId")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("warehouseId")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("workshopId")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("standardId")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("weightedAverageSpec")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder weightedAverageSpec(final String weightedAverageSpec) {
         this.weightedAverageSpec = weightedAverageSpec;
         return this;
      }

      @JsonProperty("boolReviewPending")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder boolReviewPending(final Boolean boolReviewPending) {
         this.boolReviewPending = boolReviewPending;
         return this;
      }

      @JsonProperty("sectionSteelWeight")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder sectionSteelWeight(final BigDecimal sectionSteelWeight) {
         this.sectionSteelWeight = sectionSteelWeight;
         return this;
      }

      @JsonProperty("oneTheoryWeight")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder oneTheoryWeight(final BigDecimal oneTheoryWeight) {
         this.oneTheoryWeight = oneTheoryWeight;
         return this;
      }

      @JsonProperty("MaterialReturnableId")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder MaterialReturnableId(final Long MaterialReturnableId) {
         this.MaterialReturnableId = MaterialReturnableId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("recipientId")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      @JsonProperty("recipientName")
      public RemnantMaterialReturnable.RemnantMaterialReturnableBuilder recipientName(final String recipientName) {
         this.recipientName = recipientName;
         return this;
      }

      public RemnantMaterialReturnable build() {
         return new RemnantMaterialReturnable(
            this.id,
            this.classifyId,
            this.classifyName,
            this.boolPartyA,
            this.outboundUnitType,
            this.materialSn,
            this.basicClass,
            this.specification,
            this.accountingUnit,
            this.returnableMete,
            this.singleMete,
            this.singleReturnableMete,
            this.singleReturnableLength,
            this.unitNet,
            this.length,
            this.width,
            this.thickness,
            this.theoryThickness,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.factoryId,
            this.warehouseId,
            this.workshopId,
            this.standardId,
            this.standardName,
            this.weightedAverageSpec,
            this.boolReviewPending,
            this.sectionSteelWeight,
            this.oneTheoryWeight,
            this.MaterialReturnableId,
            this.areaBatchId,
            this.recipientId,
            this.recipientName
         );
      }

      @Override
      public String toString() {
         return "RemnantMaterialReturnable.RemnantMaterialReturnableBuilder(id="
            + this.id
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", boolPartyA="
            + this.boolPartyA
            + ", outboundUnitType="
            + this.outboundUnitType
            + ", materialSn="
            + this.materialSn
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", accountingUnit="
            + this.accountingUnit
            + ", returnableMete="
            + this.returnableMete
            + ", singleMete="
            + this.singleMete
            + ", singleReturnableMete="
            + this.singleReturnableMete
            + ", singleReturnableLength="
            + this.singleReturnableLength
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
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", factoryId="
            + this.factoryId
            + ", warehouseId="
            + this.warehouseId
            + ", workshopId="
            + this.workshopId
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", weightedAverageSpec="
            + this.weightedAverageSpec
            + ", boolReviewPending="
            + this.boolReviewPending
            + ", sectionSteelWeight="
            + this.sectionSteelWeight
            + ", oneTheoryWeight="
            + this.oneTheoryWeight
            + ", MaterialReturnableId="
            + this.MaterialReturnableId
            + ", areaBatchId="
            + this.areaBatchId
            + ", recipientId="
            + this.recipientId
            + ", recipientName="
            + this.recipientName
            + ")";
      }
   }
}
