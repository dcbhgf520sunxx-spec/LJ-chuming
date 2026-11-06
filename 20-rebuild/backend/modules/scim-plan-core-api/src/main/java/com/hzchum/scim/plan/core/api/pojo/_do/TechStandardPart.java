package com.hzchum.scim.plan.core.api.pojo._do;

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

@ApiModel(value = "TechStandardPart对象", description = "标准件(配套件)")
@Entity
@TableName("tech_standard_part")
@Table(name = "tech_standard_part")
@org.hibernate.annotations.Table(appliesTo = "tech_standard_part", comment = "标准件(配套件)")
public class TechStandardPart extends BaseEntity<Long> implements Cloneable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id", notes = "主键id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '物料编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'")
   private Long monomerId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id", notes = "批次Id")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '批次Id'")
   private Long areaBatchId;
   @ApiModelProperty(name = "areaId", value = "区域Id", notes = "区域Id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域Id'")
   private Long areaId;
   @ApiModelProperty(name = "category", value = "品类 2压型彩板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11) DEFAULT NULL comment '围护分类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件'")
   private Integer category;
   @ApiModelProperty(name = "dictionaryId", value = "字典种类id")
   @TableField("dictionary_id")
   @Column(name = "dictionary_id", columnDefinition = "bigint(11) DEFAULT NULL comment '字典种类id'")
   private Integer dictionaryId;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划表id")
   @TableField("enclosure_plan_id")
   @Column(name = "enclosure_plan_id", columnDefinition = "bigint(20) DEFAULT NULL comment '围护计划表id'")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "relationType", value = "关联类型 2构件 4围护", notes = "关联类型 2构件 4围护")
   @TableField("relation_type")
   @Column(name = "relation_type", columnDefinition = "int(11) default 2  COMMENT '关联类型 2构件 4围护'", nullable = false)
   private Integer relationType;
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地 2工厂 AuxiliaryUsePropertyEnum", notes = "使用属性 1工地 2工厂")
   @TableField("use_property")
   @Column(name = "use_property", columnDefinition = "int(11)  COMMENT '使用属性 1工地 2工厂'")
   private Integer useProperty;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = false)
   private String specification;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(18,4) default null COMMENT '数量'")
   private BigDecimal quantity;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(16)  default null COMMENT '计量单位'")
   private String measureUnit;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(18,4) DEFAULT 0 COMMENT '核算量'")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(16)  COMMENT '单位'")
   private String accountingUnit;
   @ApiModelProperty(name = "boolWeightTypeEnum", value = "(核算单位)是否重量类型 true是 false否", notes = "(核算单位)是否重量类型 true是 false否")
   @TableField("bool_weight_type_enum")
   @Column(name = "bool_weight_type_enum", columnDefinition = "tinyint(1) DEFAULT 0 COMMENT '(核算单位)是否重量类型 1是 0否'", nullable = false)
   private Boolean boolWeightTypeEnum;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'")
   private String remark;
   @ApiModelProperty(name = "boolReturn", value = "是否退量 true是 false否", notes = "是否退量 true是 false否")
   @TableField("bool_return")
   @Column(name = "bool_return", columnDefinition = "tinyint(1) DEFAULT 0 COMMENT '是否退量 1是 0否'", nullable = false)
   private Boolean boolReturn;
   @ApiModelProperty(name = "userId", value = "创建用户id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20) COMMENT '创建用户id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "lastEditorId", value = "最后修改用户id")
   @TableField("last_editor_id")
   @Column(name = "last_editor_id", columnDefinition = "bigint(20) COMMENT '最后修改用户id'")
   private Long lastEditorId;
   @ApiModelProperty(name = "businessId", value = "标准件商务ID")
   @TableField("business_id")
   @Column(name = "business_id", columnDefinition = "bigint(20)  COMMENT '标准件商务ID'", nullable = false)
   private Long businessId;
   @ApiModelProperty("打印数量")
   @TableField("print_quantity")
   @Column(name = "print_quantity", columnDefinition = "decimal(18,4) default 0  COMMENT '打印数量'")
   private BigDecimal printQuantity;
   @ApiModelProperty("打印时间")
   @TableField("print_time")
   @Column(name = "print_time")
   private LocalDateTime printTime;
   @ApiModelProperty(name = "boolArtifactImport", value = "是否关联清单 true是 false否", notes = "是否关联清单 true是 false否")
   @TableField("bool_artifact_import")
   @Column(name = "bool_artifact_import", columnDefinition = "tinyint(1) DEFAULT 0 COMMENT '是否构件清单导入 1是 0否'", nullable = false)
   private Boolean boolArtifactImport;
   @ApiModelProperty(name = "boolSubscription", value = "是否申购 ")
   @TableField("bool_subscription")
   @Column(name = "bool_subscription", columnDefinition = "tinyint(1) DEFAULT 0 COMMENT '是否申购 false未申购 true已申购'", nullable = false)
   private Boolean boolSubscription;
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
   @ApiModelProperty(name = "model", value = "型号")
   @JsonProperty("model")
   @JSONField(name = "model")
   @TableField("model")
   @Column(name = "model", columnDefinition = "varchar(255)  COMMENT '型号'", nullable = true)
   private String model;
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
   @ApiModelProperty(name = "accountingPrecision", value = "核算精度", notes = "核算精度")
   @JsonProperty("accountingPrecision")
   @JSONField(name = "accountingPrecision")
   @TableField("accounting_precision")
   @Column(name = "accounting_precision", columnDefinition = "int  COMMENT '核算精度'", nullable = true)
   private Integer accountingPrecision;
   @ApiModelProperty(name = "configStatus", value = "配置状态 0未配置  1已配置  默认0", notes = "配置状态 0未配置  1已配置  默认0")
   @JsonProperty("configStatus")
   @JSONField(name = "configStatus")
   @TableField("config_status")
   @Column(name = "config_status", columnDefinition = "tinyint(1) default '0' COMMENT '配置状态 0未配置  1已配置  默认0'")
   private Boolean configStatus;
   @ApiModelProperty(name = "unitNet", value = "单位净量(针对辅材,计量/核算量=单位净量)", notes = "单位净量(针对辅材,计量/核算量=单位净量)")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net", columnDefinition = "decimal(32,12)  COMMENT '单位净量(针对辅材,计量/核算量=单位净量)'", nullable = true)
   private BigDecimal unitNet;
   @ApiModelProperty(name = "materialInventoryId", value = "WMS库存Id", notes = "WMS库存Id")
   @JsonProperty("materialInventoryId")
   @JSONField(name = "materialInventoryId")
   @TableField("material_inventory_id")
   @Column(name = "material_inventory_id", columnDefinition = "bigint(20)  COMMENT 'WMS库存Id'")
   private Long materialInventoryId;
   @ApiModelProperty(name = "outboundDetailId", value = "wms出库详情Id", notes = "wms出库详情Id")
   @TableField("outbound_detail_id")
   @Column(name = "outbound_detail_id", columnDefinition = "bigint(20)  COMMENT 'wms出库详情Id'")
   private Long outboundDetailId;
   @ApiModelProperty(name = "originalId", value = "原清单id", notes = "原清单id (同时为0时用于工厂判断入库)")
   @TableField("original_id")
   @Column(name = "original_id", columnDefinition = "bigint(20)  COMMENT '原清单id'")
   private Long originalId;
   @ApiModelProperty(name = "boolWmsLink", value = "是否关联物料导入", notes = "是否关联物料导入")
   @TableField("bool_wms_link")
   @Column(name = "bool_wms_link", columnDefinition = "tinyint(1) default 0 COMMENT '是否关联物料导入0 否 1 是'", nullable = false)
   private Boolean boolWmsLink;

   public TechStandardPart clone() {
      try {
         return (TechStandardPart)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError();
      }
   }

   public static TechStandardPart.TechStandardPartBuilder builder() {
      return new TechStandardPart.TechStandardPartBuilder();
   }

   public TechStandardPart() {
   }

   public TechStandardPart(
      final Long id,
      final String serialNumber,
      final String name,
      final Long projectId,
      final Long monomerId,
      final Long areaBatchId,
      final Long areaId,
      final Integer category,
      final Integer dictionaryId,
      final Long enclosurePlanId,
      final Integer relationType,
      final Integer useProperty,
      final String specification,
      final BigDecimal quantity,
      final String measureUnit,
      final BigDecimal mete,
      final String accountingUnit,
      final Boolean boolWeightTypeEnum,
      final String remark,
      final Boolean boolReturn,
      final Long userId,
      final Long lastEditorId,
      final Long businessId,
      final BigDecimal printQuantity,
      final LocalDateTime printTime,
      final Boolean boolArtifactImport,
      final Boolean boolSubscription,
      final Long classifyId,
      final String classifyName,
      final String model,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final Integer accountingPrecision,
      final Boolean configStatus,
      final BigDecimal unitNet,
      final Long materialInventoryId,
      final Long outboundDetailId,
      final Long originalId,
      final Boolean boolWmsLink
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.name = name;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaBatchId = areaBatchId;
      this.areaId = areaId;
      this.category = category;
      this.dictionaryId = dictionaryId;
      this.enclosurePlanId = enclosurePlanId;
      this.relationType = relationType;
      this.useProperty = useProperty;
      this.specification = specification;
      this.quantity = quantity;
      this.measureUnit = measureUnit;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.boolWeightTypeEnum = boolWeightTypeEnum;
      this.remark = remark;
      this.boolReturn = boolReturn;
      this.userId = userId;
      this.lastEditorId = lastEditorId;
      this.businessId = businessId;
      this.printQuantity = printQuantity;
      this.printTime = printTime;
      this.boolArtifactImport = boolArtifactImport;
      this.boolSubscription = boolSubscription;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.model = model;
      this.width = width;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.accountingPrecision = accountingPrecision;
      this.configStatus = configStatus;
      this.unitNet = unitNet;
      this.materialInventoryId = materialInventoryId;
      this.outboundDetailId = outboundDetailId;
      this.originalId = originalId;
      this.boolWmsLink = boolWmsLink;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Integer getDictionaryId() {
      return this.dictionaryId;
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Boolean getBoolWeightTypeEnum() {
      return this.boolWeightTypeEnum;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getBoolReturn() {
      return this.boolReturn;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getLastEditorId() {
      return this.lastEditorId;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public BigDecimal getPrintQuantity() {
      return this.printQuantity;
   }

   public LocalDateTime getPrintTime() {
      return this.printTime;
   }

   public Boolean getBoolArtifactImport() {
      return this.boolArtifactImport;
   }

   public Boolean getBoolSubscription() {
      return this.boolSubscription;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getModel() {
      return this.model;
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

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public Boolean getConfigStatus() {
      return this.configStatus;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public Long getOutboundDetailId() {
      return this.outboundDetailId;
   }

   public Long getOriginalId() {
      return this.originalId;
   }

   public Boolean getBoolWmsLink() {
      return this.boolWmsLink;
   }

   public TechStandardPart setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public TechStandardPart setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechStandardPart setName(final String name) {
      this.name = name;
      return this;
   }

   public TechStandardPart setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechStandardPart setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechStandardPart setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   public TechStandardPart setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public TechStandardPart setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   public TechStandardPart setDictionaryId(final Integer dictionaryId) {
      this.dictionaryId = dictionaryId;
      return this;
   }

   public TechStandardPart setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
      return this;
   }

   public TechStandardPart setRelationType(final Integer relationType) {
      this.relationType = relationType;
      return this;
   }

   public TechStandardPart setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
      return this;
   }

   public TechStandardPart setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public TechStandardPart setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   public TechStandardPart setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public TechStandardPart setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   public TechStandardPart setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   public TechStandardPart setBoolWeightTypeEnum(final Boolean boolWeightTypeEnum) {
      this.boolWeightTypeEnum = boolWeightTypeEnum;
      return this;
   }

   public TechStandardPart setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public TechStandardPart setBoolReturn(final Boolean boolReturn) {
      this.boolReturn = boolReturn;
      return this;
   }

   public TechStandardPart setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public TechStandardPart setLastEditorId(final Long lastEditorId) {
      this.lastEditorId = lastEditorId;
      return this;
   }

   public TechStandardPart setBusinessId(final Long businessId) {
      this.businessId = businessId;
      return this;
   }

   public TechStandardPart setPrintQuantity(final BigDecimal printQuantity) {
      this.printQuantity = printQuantity;
      return this;
   }

   public TechStandardPart setPrintTime(final LocalDateTime printTime) {
      this.printTime = printTime;
      return this;
   }

   public TechStandardPart setBoolArtifactImport(final Boolean boolArtifactImport) {
      this.boolArtifactImport = boolArtifactImport;
      return this;
   }

   public TechStandardPart setBoolSubscription(final Boolean boolSubscription) {
      this.boolSubscription = boolSubscription;
      return this;
   }

   @JsonProperty("classifyId")
   public TechStandardPart setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("classifyName")
   public TechStandardPart setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("model")
   public TechStandardPart setModel(final String model) {
      this.model = model;
      return this;
   }

   @JsonProperty("width")
   public TechStandardPart setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public TechStandardPart setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("theoryThickness")
   public TechStandardPart setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("brand")
   public TechStandardPart setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public TechStandardPart setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("color")
   public TechStandardPart setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("accountingPrecision")
   public TechStandardPart setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
      return this;
   }

   @JsonProperty("configStatus")
   public TechStandardPart setConfigStatus(final Boolean configStatus) {
      this.configStatus = configStatus;
      return this;
   }

   @JsonProperty("unitNet")
   public TechStandardPart setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("materialInventoryId")
   public TechStandardPart setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
      return this;
   }

   public TechStandardPart setOutboundDetailId(final Long outboundDetailId) {
      this.outboundDetailId = outboundDetailId;
      return this;
   }

   public TechStandardPart setOriginalId(final Long originalId) {
      this.originalId = originalId;
      return this;
   }

   public TechStandardPart setBoolWmsLink(final Boolean boolWmsLink) {
      this.boolWmsLink = boolWmsLink;
      return this;
   }

   @Override
   public String toString() {
      return "TechStandardPart(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", areaId="
         + this.getAreaId()
         + ", category="
         + this.getCategory()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", relationType="
         + this.getRelationType()
         + ", useProperty="
         + this.getUseProperty()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", boolWeightTypeEnum="
         + this.getBoolWeightTypeEnum()
         + ", remark="
         + this.getRemark()
         + ", boolReturn="
         + this.getBoolReturn()
         + ", userId="
         + this.getUserId()
         + ", lastEditorId="
         + this.getLastEditorId()
         + ", businessId="
         + this.getBusinessId()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", printTime="
         + this.getPrintTime()
         + ", boolArtifactImport="
         + this.getBoolArtifactImport()
         + ", boolSubscription="
         + this.getBoolSubscription()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", model="
         + this.getModel()
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
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", configStatus="
         + this.getConfigStatus()
         + ", unitNet="
         + this.getUnitNet()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", outboundDetailId="
         + this.getOutboundDetailId()
         + ", originalId="
         + this.getOriginalId()
         + ", boolWmsLink="
         + this.getBoolWmsLink()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechStandardPart)) {
         return false;
      }

      TechStandardPart other = (TechStandardPart)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaBatchId = this.getAreaBatchId();
               Object other$areaBatchId = other.getAreaBatchId();
               if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$category = this.getCategory();
                     Object other$category = other.getCategory();
                     if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                        Object this$dictionaryId = this.getDictionaryId();
                        Object other$dictionaryId = other.getDictionaryId();
                        if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                           Object this$enclosurePlanId = this.getEnclosurePlanId();
                           Object other$enclosurePlanId = other.getEnclosurePlanId();
                           if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
                              Object this$relationType = this.getRelationType();
                              Object other$relationType = other.getRelationType();
                              if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                                 Object this$useProperty = this.getUseProperty();
                                 Object other$useProperty = other.getUseProperty();
                                 if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
                                    Object this$boolWeightTypeEnum = this.getBoolWeightTypeEnum();
                                    Object other$boolWeightTypeEnum = other.getBoolWeightTypeEnum();
                                    if (this$boolWeightTypeEnum == null
                                       ? other$boolWeightTypeEnum == null
                                       : this$boolWeightTypeEnum.equals(other$boolWeightTypeEnum)) {
                                       Object this$boolReturn = this.getBoolReturn();
                                       Object other$boolReturn = other.getBoolReturn();
                                       if (this$boolReturn == null ? other$boolReturn == null : this$boolReturn.equals(other$boolReturn)) {
                                          Object this$userId = this.getUserId();
                                          Object other$userId = other.getUserId();
                                          if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                             Object this$lastEditorId = this.getLastEditorId();
                                             Object other$lastEditorId = other.getLastEditorId();
                                             if (this$lastEditorId == null ? other$lastEditorId == null : this$lastEditorId.equals(other$lastEditorId)) {
                                                Object this$businessId = this.getBusinessId();
                                                Object other$businessId = other.getBusinessId();
                                                if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
                                                   Object this$boolArtifactImport = this.getBoolArtifactImport();
                                                   Object other$boolArtifactImport = other.getBoolArtifactImport();
                                                   if (this$boolArtifactImport == null
                                                      ? other$boolArtifactImport == null
                                                      : this$boolArtifactImport.equals(other$boolArtifactImport)) {
                                                      Object this$boolSubscription = this.getBoolSubscription();
                                                      Object other$boolSubscription = other.getBoolSubscription();
                                                      if (this$boolSubscription == null
                                                         ? other$boolSubscription == null
                                                         : this$boolSubscription.equals(other$boolSubscription)) {
                                                         Object this$classifyId = this.getClassifyId();
                                                         Object other$classifyId = other.getClassifyId();
                                                         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                                                            Object this$accountingPrecision = this.getAccountingPrecision();
                                                            Object other$accountingPrecision = other.getAccountingPrecision();
                                                            if (this$accountingPrecision == null
                                                               ? other$accountingPrecision == null
                                                               : this$accountingPrecision.equals(other$accountingPrecision)) {
                                                               Object this$configStatus = this.getConfigStatus();
                                                               Object other$configStatus = other.getConfigStatus();
                                                               if (this$configStatus == null
                                                                  ? other$configStatus == null
                                                                  : this$configStatus.equals(other$configStatus)) {
                                                                  Object this$materialInventoryId = this.getMaterialInventoryId();
                                                                  Object other$materialInventoryId = other.getMaterialInventoryId();
                                                                  if (this$materialInventoryId == null
                                                                     ? other$materialInventoryId == null
                                                                     : this$materialInventoryId.equals(other$materialInventoryId)) {
                                                                     Object this$outboundDetailId = this.getOutboundDetailId();
                                                                     Object other$outboundDetailId = other.getOutboundDetailId();
                                                                     if (this$outboundDetailId == null
                                                                        ? other$outboundDetailId == null
                                                                        : this$outboundDetailId.equals(other$outboundDetailId)) {
                                                                        Object this$originalId = this.getOriginalId();
                                                                        Object other$originalId = other.getOriginalId();
                                                                        if (this$originalId == null
                                                                           ? other$originalId == null
                                                                           : this$originalId.equals(other$originalId)) {
                                                                           Object this$boolWmsLink = this.getBoolWmsLink();
                                                                           Object other$boolWmsLink = other.getBoolWmsLink();
                                                                           if (this$boolWmsLink == null
                                                                              ? other$boolWmsLink == null
                                                                              : this$boolWmsLink.equals(other$boolWmsLink)) {
                                                                              Object this$serialNumber = this.getSerialNumber();
                                                                              Object other$serialNumber = other.getSerialNumber();
                                                                              if (this$serialNumber == null
                                                                                 ? other$serialNumber == null
                                                                                 : this$serialNumber.equals(other$serialNumber)) {
                                                                                 Object this$name = this.getName();
                                                                                 Object other$name = other.getName();
                                                                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
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
                                                                                          Object this$measureUnit = this.getMeasureUnit();
                                                                                          Object other$measureUnit = other.getMeasureUnit();
                                                                                          if (this$measureUnit == null
                                                                                             ? other$measureUnit == null
                                                                                             : this$measureUnit.equals(other$measureUnit)) {
                                                                                             Object this$mete = this.getMete();
                                                                                             Object other$mete = other.getMete();
                                                                                             if (this$mete == null
                                                                                                ? other$mete == null
                                                                                                : this$mete.equals(other$mete)) {
                                                                                                Object this$accountingUnit = this.getAccountingUnit();
                                                                                                Object other$accountingUnit = other.getAccountingUnit();
                                                                                                if (this$accountingUnit == null
                                                                                                   ? other$accountingUnit == null
                                                                                                   : this$accountingUnit.equals(other$accountingUnit)) {
                                                                                                   Object this$remark = this.getRemark();
                                                                                                   Object other$remark = other.getRemark();
                                                                                                   if (this$remark == null
                                                                                                      ? other$remark == null
                                                                                                      : this$remark.equals(other$remark)) {
                                                                                                      Object this$printQuantity = this.getPrintQuantity();
                                                                                                      Object other$printQuantity = other.getPrintQuantity();
                                                                                                      if (this$printQuantity == null
                                                                                                         ? other$printQuantity == null
                                                                                                         : this$printQuantity.equals(other$printQuantity)) {
                                                                                                         Object this$printTime = this.getPrintTime();
                                                                                                         Object other$printTime = other.getPrintTime();
                                                                                                         if (this$printTime == null
                                                                                                            ? other$printTime == null
                                                                                                            : this$printTime.equals(other$printTime)) {
                                                                                                            Object this$classifyName = this.getClassifyName();
                                                                                                            Object other$classifyName = other.getClassifyName();
                                                                                                            if (this$classifyName == null
                                                                                                               ? other$classifyName == null
                                                                                                               : this$classifyName.equals(other$classifyName)) {
                                                                                                               Object this$model = this.getModel();
                                                                                                               Object other$model = other.getModel();
                                                                                                               if (this$model == null
                                                                                                                  ? other$model == null
                                                                                                                  : this$model.equals(other$model)) {
                                                                                                                  Object this$width = this.getWidth();
                                                                                                                  Object other$width = other.getWidth();
                                                                                                                  if (this$width == null
                                                                                                                     ? other$width == null
                                                                                                                     : this$width.equals(other$width)) {
                                                                                                                     Object this$thickness = this.getThickness();
                                                                                                                     Object other$thickness = other.getThickness();
                                                                                                                     if (this$thickness == null
                                                                                                                        ? other$thickness == null
                                                                                                                        : this$thickness.equals(other$thickness)
                                                                                                                        )
                                                                                                                      {
                                                                                                                        Object this$theoryThickness = this.getTheoryThickness();
                                                                                                                        Object other$theoryThickness = other.getTheoryThickness();
                                                                                                                        if (this$theoryThickness == null
                                                                                                                           ? other$theoryThickness == null
                                                                                                                           : this$theoryThickness.equals(
                                                                                                                              other$theoryThickness
                                                                                                                           )) {
                                                                                                                           Object this$brand = this.getBrand();
                                                                                                                           Object other$brand = other.getBrand();
                                                                                                                           if (this$brand == null
                                                                                                                              ? other$brand == null
                                                                                                                              : this$brand.equals(other$brand)) {
                                                                                                                              Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                                                                              Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                                                                              if (this$heatNoAndBatchNo == null
                                                                                                                                 ? other$heatNoAndBatchNo
                                                                                                                                    == null
                                                                                                                                 : this$heatNoAndBatchNo.equals(
                                                                                                                                    other$heatNoAndBatchNo
                                                                                                                                 )) {
                                                                                                                                 Object this$color = this.getColor();
                                                                                                                                 Object other$color = other.getColor();
                                                                                                                                 if (this$color == null
                                                                                                                                    ? other$color == null
                                                                                                                                    : this$color.equals(
                                                                                                                                       other$color
                                                                                                                                    )) {
                                                                                                                                    Object this$unitNet = this.getUnitNet();
                                                                                                                                    Object other$unitNet = other.getUnitNet();
                                                                                                                                    return this$unitNet == null
                                                                                                                                       ? other$unitNet == null
                                                                                                                                       : this$unitNet.equals(
                                                                                                                                          other$unitNet
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
      return other instanceof TechStandardPart;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $boolWeightTypeEnum = this.getBoolWeightTypeEnum();
      result = result * 59 + ($boolWeightTypeEnum == null ? 43 : $boolWeightTypeEnum.hashCode());
      Object $boolReturn = this.getBoolReturn();
      result = result * 59 + ($boolReturn == null ? 43 : $boolReturn.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $lastEditorId = this.getLastEditorId();
      result = result * 59 + ($lastEditorId == null ? 43 : $lastEditorId.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $boolArtifactImport = this.getBoolArtifactImport();
      result = result * 59 + ($boolArtifactImport == null ? 43 : $boolArtifactImport.hashCode());
      Object $boolSubscription = this.getBoolSubscription();
      result = result * 59 + ($boolSubscription == null ? 43 : $boolSubscription.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $configStatus = this.getConfigStatus();
      result = result * 59 + ($configStatus == null ? 43 : $configStatus.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $outboundDetailId = this.getOutboundDetailId();
      result = result * 59 + ($outboundDetailId == null ? 43 : $outboundDetailId.hashCode());
      Object $originalId = this.getOriginalId();
      result = result * 59 + ($originalId == null ? 43 : $originalId.hashCode());
      Object $boolWmsLink = this.getBoolWmsLink();
      result = result * 59 + ($boolWmsLink == null ? 43 : $boolWmsLink.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $printTime = this.getPrintTime();
      result = result * 59 + ($printTime == null ? 43 : $printTime.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $model = this.getModel();
      result = result * 59 + ($model == null ? 43 : $model.hashCode());
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
      return result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
   }

   public static class TechStandardPartBuilder {
      private Long id;
      private String serialNumber;
      private String name;
      private Long projectId;
      private Long monomerId;
      private Long areaBatchId;
      private Long areaId;
      private Integer category;
      private Integer dictionaryId;
      private Long enclosurePlanId;
      private Integer relationType;
      private Integer useProperty;
      private String specification;
      private BigDecimal quantity;
      private String measureUnit;
      private BigDecimal mete;
      private String accountingUnit;
      private Boolean boolWeightTypeEnum;
      private String remark;
      private Boolean boolReturn;
      private Long userId;
      private Long lastEditorId;
      private Long businessId;
      private BigDecimal printQuantity;
      private LocalDateTime printTime;
      private Boolean boolArtifactImport;
      private Boolean boolSubscription;
      private Long classifyId;
      private String classifyName;
      private String model;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private Integer accountingPrecision;
      private Boolean configStatus;
      private BigDecimal unitNet;
      private Long materialInventoryId;
      private Long outboundDetailId;
      private Long originalId;
      private Boolean boolWmsLink;

      TechStandardPartBuilder() {
      }

      public TechStandardPart.TechStandardPartBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public TechStandardPart.TechStandardPartBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder dictionaryId(final Integer dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder useProperty(final Integer useProperty) {
         this.useProperty = useProperty;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder boolWeightTypeEnum(final Boolean boolWeightTypeEnum) {
         this.boolWeightTypeEnum = boolWeightTypeEnum;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder boolReturn(final Boolean boolReturn) {
         this.boolReturn = boolReturn;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder lastEditorId(final Long lastEditorId) {
         this.lastEditorId = lastEditorId;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder printQuantity(final BigDecimal printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder printTime(final LocalDateTime printTime) {
         this.printTime = printTime;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder boolArtifactImport(final Boolean boolArtifactImport) {
         this.boolArtifactImport = boolArtifactImport;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder boolSubscription(final Boolean boolSubscription) {
         this.boolSubscription = boolSubscription;
         return this;
      }

      @JsonProperty("classifyId")
      public TechStandardPart.TechStandardPartBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public TechStandardPart.TechStandardPartBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("model")
      public TechStandardPart.TechStandardPartBuilder model(final String model) {
         this.model = model;
         return this;
      }

      @JsonProperty("width")
      public TechStandardPart.TechStandardPartBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public TechStandardPart.TechStandardPartBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("theoryThickness")
      public TechStandardPart.TechStandardPartBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("brand")
      public TechStandardPart.TechStandardPartBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public TechStandardPart.TechStandardPartBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("color")
      public TechStandardPart.TechStandardPartBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("accountingPrecision")
      public TechStandardPart.TechStandardPartBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      @JsonProperty("configStatus")
      public TechStandardPart.TechStandardPartBuilder configStatus(final Boolean configStatus) {
         this.configStatus = configStatus;
         return this;
      }

      @JsonProperty("unitNet")
      public TechStandardPart.TechStandardPartBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("materialInventoryId")
      public TechStandardPart.TechStandardPartBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder outboundDetailId(final Long outboundDetailId) {
         this.outboundDetailId = outboundDetailId;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder originalId(final Long originalId) {
         this.originalId = originalId;
         return this;
      }

      public TechStandardPart.TechStandardPartBuilder boolWmsLink(final Boolean boolWmsLink) {
         this.boolWmsLink = boolWmsLink;
         return this;
      }

      public TechStandardPart build() {
         return new TechStandardPart(
            this.id,
            this.serialNumber,
            this.name,
            this.projectId,
            this.monomerId,
            this.areaBatchId,
            this.areaId,
            this.category,
            this.dictionaryId,
            this.enclosurePlanId,
            this.relationType,
            this.useProperty,
            this.specification,
            this.quantity,
            this.measureUnit,
            this.mete,
            this.accountingUnit,
            this.boolWeightTypeEnum,
            this.remark,
            this.boolReturn,
            this.userId,
            this.lastEditorId,
            this.businessId,
            this.printQuantity,
            this.printTime,
            this.boolArtifactImport,
            this.boolSubscription,
            this.classifyId,
            this.classifyName,
            this.model,
            this.width,
            this.thickness,
            this.theoryThickness,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.accountingPrecision,
            this.configStatus,
            this.unitNet,
            this.materialInventoryId,
            this.outboundDetailId,
            this.originalId,
            this.boolWmsLink
         );
      }

      @Override
      public String toString() {
         return "TechStandardPart.TechStandardPartBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaBatchId="
            + this.areaBatchId
            + ", areaId="
            + this.areaId
            + ", category="
            + this.category
            + ", dictionaryId="
            + this.dictionaryId
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", relationType="
            + this.relationType
            + ", useProperty="
            + this.useProperty
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", measureUnit="
            + this.measureUnit
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", boolWeightTypeEnum="
            + this.boolWeightTypeEnum
            + ", remark="
            + this.remark
            + ", boolReturn="
            + this.boolReturn
            + ", userId="
            + this.userId
            + ", lastEditorId="
            + this.lastEditorId
            + ", businessId="
            + this.businessId
            + ", printQuantity="
            + this.printQuantity
            + ", printTime="
            + this.printTime
            + ", boolArtifactImport="
            + this.boolArtifactImport
            + ", boolSubscription="
            + this.boolSubscription
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", model="
            + this.model
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
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", configStatus="
            + this.configStatus
            + ", unitNet="
            + this.unitNet
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", outboundDetailId="
            + this.outboundDetailId
            + ", originalId="
            + this.originalId
            + ", boolWmsLink="
            + this.boolWmsLink
            + ")";
      }
   }
}
