package com.hzchum.scim.plan.core.api.pojo._do.check;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "TechMachinePartRecord对象", description = "零件审核表 ")
@Entity
@TableName("tech_machine_part_record")
@Table(
   name = "tech_machine_part_record",
   indexes = {
         @Index(name = "id_monomer_id", columnList = "monomer_id"),
         @Index(name = "id_area_id", columnList = "area_id"),
         @Index(name = "id_inventory_operation_id", columnList = "inventory_operation_id")
   }
)
public class TechMachinePartRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "零件名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name")
   private String name;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id")
   private Long monomerId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id")
   private Long areaBatchId;
   @ApiModelProperty(name = "areaId", value = "区域Id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id")
   private Long areaId;
   @ApiModelProperty(name = "inventoryOperationId", value = "清单操作记录表Id")
   @JsonProperty("inventoryOperationId")
   @JSONField(name = "inventoryOperationId")
   @TableField("inventory_operation_id")
   @Column(name = "inventory_operation_id", columnDefinition = "bigint(20)  COMMENT '清单操作记录表Id'", nullable = false)
   private Long inventoryOperationId;
   @ApiModelProperty(name = "structureType", value = "结构类型")
   @TableField("structure_type")
   @Column(name = "structure_type", columnDefinition = "varchar(255) COMMENT '名称'")
   private String structureType;
   @ApiModelProperty(name = "relationType", value = "关联产品类型 2关联构件 16关联组立 18组立 枚举:MachinePartRelationTypeEnum")
   @JsonProperty("relationType")
   @JSONField(name = "relationType")
   @TableField("relation_type")
   @Column(name = "relation_type", columnDefinition = "int(11) default 2 comment '关联类型 2普通零件(关联构件) 16翼板腹板(关联组立) 18等于组立'", nullable = false)
   private Integer relationType;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,4) comment '长度(mm)'", nullable = false)
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   @TableField("net_weight")
   @Column(name = "net_weight", columnDefinition = "decimal(32,4) comment '单净重(kg)'", nullable = false)
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   @TableField("total_net_weight")
   @Column(name = "total_net_weight", columnDefinition = "decimal(32,4) comment '总净重(kg)'", nullable = false)
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   @TableField("gross_weight")
   @Column(name = "gross_weight", columnDefinition = "decimal(32,4) comment '单毛重(kg)'", nullable = false)
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   @TableField("total_gross_weight")
   @Column(name = "total_gross_weight", columnDefinition = "decimal(32,4) comment '总毛重(kg)'", nullable = false)
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "单面积（mm²）")
   @TableField("surface_area")
   @Column(name = "surface_area", columnDefinition = "decimal(32,4) default 0.0 comment '单面积(mm²)'", nullable = false)
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "userId", value = "上传人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id")
   private Long userId;
   @ApiModelProperty(name = "thick", value = "厚")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   @TableField("thick")
   @Column(name = "thick")
   private String thick;
   @ApiModelProperty("零件类型定义Id")
   @Column
   @TableField(updateStrategy = FieldStrategy.IGNORED)
   private Long steelId;
   @ApiModelProperty("零件厚度/规格")
   @Column
   @TableField(updateStrategy = FieldStrategy.IGNORED)
   private String steelSpec;
   @ApiModelProperty(name = "width", notes = "宽度（mm）")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width")
   private String width;
   @ApiModelProperty(name = "areaType", value = "区域制造类型 0自制 1外包")
   @JsonProperty("areaType")
   @JSONField(name = "areaType")
   @TableField("area_type")
   @Column(name = "area_type")
   private Integer areaType;
   @ApiModelProperty(name = "boolSchedulingEnum", value = "是否排产 TRUE是 false 否")
   @JsonProperty("boolSchedulingEnum")
   @JSONField(name = "boolSchedulingEnum")
   @TableField("bool_scheduling_enum")
   @Column(name = "bool_scheduling_enum", columnDefinition = "tinyint(1) default 1 comment '是否排产 1是 0否' ", nullable = false)
   private Boolean boolSchedulingEnum;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀")
   @TableField("spec_prefix")
   @Column(name = "spec_prefix", columnDefinition = "varchar(255) default '' comment '规格前缀' ")
   private String specPrefix;
   @ApiModelProperty(name = "boolProcess", value = "是否有工序 true是 false否")
   @JsonProperty("boolProcess")
   @JSONField(name = "boolProcess")
   @TableField("bool_process")
   @Column(name = "bool_process", nullable = false, columnDefinition = "tinyint(1) default 0 comment '是否有工序 1是 0否'")
   private Boolean boolProcess;
   @ApiModelProperty(name = "boolSendDirectly", value = "是否直发件 true 是 false 否")
   @TableField("bool_send_directly")
   @Column(name = "bool_send_directly", nullable = false, columnDefinition = "tinyint(1) default 0 comment '是否直发件 1是 0否'")
   private Boolean boolSendDirectly;
   @ApiModelProperty(name = "boolSinglePartEnum", value = "是否单零件类型 true是 false否")
   @TableField("bool_single_part_enum")
   @Column(name = "bool_single_part_enum", columnDefinition = "tinyint(1) default 0 comment '是否单零件类型 1是 0否'", nullable = false)
   private Boolean boolSinglePartEnum;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否构件全部零件都是直发件 true 是 false 否")
   @TableField("bool_all_part_send_directly")
   @Column(name = "bool_all_part_send_directly", columnDefinition = "tinyint(1) default 0 comment '是否构件全部零件都是直发件 1是 0否'", nullable = false)
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty("零件分类  8.钢板")
   @TableField("machine_part_type")
   @Column(name = "machine_part_type", columnDefinition = "int(11) comment '零件类型  8.钢板'", nullable = false)
   private Integer machinePartType;
   @ApiModelProperty("零件分类  4 成品型材 8.钢板")
   @TableField("product_classification_enum")
   @Column(name = "product_classification_enum", columnDefinition = "int(11) comment '零件类型  4 成品型材 8.钢板'", nullable = false)
   private Integer productClassificationEnum;
   @ApiModelProperty(name = "steelPlateTypeEnum", value = "零件类型 1.零件板 2.翼腹板")
   @JsonProperty("steelPlateTypeEnum")
   @JSONField(name = "steelPlateTypeEnum")
   @TableField("steel_plate_type_enum")
   @Column(name = "steel_plate_type_enum", columnDefinition = "int(11) COMMENT '零件类型 1.零件板 2.翼腹板'")
   private Integer steelPlateTypeEnum;
   @ApiModelProperty(name = "comboId", value = "组合id")
   @TableField("combo_id")
   @JsonProperty("comboId")
   @JSONField(name = "comboId")
   @Column(name = "combo_id", columnDefinition = "varchar(255) default '0' COMMENT ''", nullable = false)
   private String comboId;
   @ApiModelProperty(name = "oldMachinePartId", value = "旧零件id")
   @TableField("old_machine_part_id")
   @JsonProperty("oldMachinePartId")
   @JSONField(name = "oldMachinePartId")
   @Column(name = "old_machine_part_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '旧零件id'", nullable = false)
   private Long oldMachinePartId;
   @ApiModelProperty(name = "topPaintArea", value = "桥顶面油漆(单)面积(mm2)")
   @TableField("top_paint_area")
   @Column(name = "top_paint_area", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '桥顶面油漆(单)面积(mm2)'")
   private BigDecimal topPaintArea;
   @ApiModelProperty(name = "innerPaintArea", value = "内表面油漆(单)面积(mm2)")
   @TableField("inner_paint_area")
   @Column(name = "inner_paint_area", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '内表面油漆(单)面积(mm2)'")
   private BigDecimal innerPaintArea;
   @ApiModelProperty(name = "outerPaintArea", value = "外表面油漆(单)面积(mm2)")
   @TableField("outer_paint_area")
   @Column(name = "outer_paint_area", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '外表面油漆(单)面积(mm2)'")
   private BigDecimal outerPaintArea;
   @ApiModelProperty(name = "uRibPaintArea", value = "U肋油漆(单)面积(mm2)")
   @TableField("u_rib_paint_area")
   @Column(name = "u_rib_paint_area", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT 'U肋油漆(单)面积(mm2)'")
   private BigDecimal uRibPaintArea;
   @ApiModelProperty(name = "initialSerialNumber", value = "翼腹板初始编号")
   @JsonProperty("initialSerialNumber")
   @JSONField(name = "initialSerialNumber")
   @TableField("initial_serial_number")
   @Column(name = "initial_serial_number")
   private String initialSerialNumber;
   @ApiModelProperty(name = "boolItsOwnDrawing", value = "翼腹板是否导入自己的图纸 true 是 false 否")
   @TableField("bool_its_own_drawing")
   @Column(name = "bool_its_own_drawing", columnDefinition = "tinyint(1) default 0 comment '翼腹板是否导入自己的图纸 1是 0否'")
   private Boolean boolItsOwnDrawing;
   @ApiModelProperty(name = "sourcePartEnum", value = "翼腹板来源 1 直接导入 2 部件拆分 4 部件组合")
   @TableField("source_part_enum")
   @Column(name = "source_part_enum", columnDefinition = "tinyint(1) default 1 comment '翼腹板来源 1 直接导入 2 部件拆分 4 部件组合'")
   private Integer sourcePartEnum;
   @ApiModelProperty(name = "topFlangeArea", value = "上翼缘(单)面积（mm²）")
   @JsonProperty("topFlangeArea")
   @JSONField(name = "topFlangeArea")
   @TableField("top_flange_area")
   @Column(name = "top_flange_area", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '上翼缘(单)面积（mm²）'")
   private BigDecimal topFlangeArea;

   public static TechMachinePartRecord.TechMachinePartRecordBuilder builder() {
      return new TechMachinePartRecord.TechMachinePartRecordBuilder();
   }

   public TechMachinePartRecord() {
   }

   public TechMachinePartRecord(
      final Long id,
      final String name,
      final Long projectId,
      final Long monomerId,
      final Long areaBatchId,
      final Long areaId,
      final Long inventoryOperationId,
      final String structureType,
      final Integer relationType,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal surfaceArea,
      final String remark,
      final Long userId,
      final String thick,
      final Long steelId,
      final String steelSpec,
      final String width,
      final Integer areaType,
      final Boolean boolSchedulingEnum,
      final String specPrefix,
      final Boolean boolProcess,
      final Boolean boolSendDirectly,
      final Boolean boolSinglePartEnum,
      final Boolean boolAllPartSendDirectly,
      final Integer machinePartType,
      final Integer productClassificationEnum,
      final Integer steelPlateTypeEnum,
      final String comboId,
      final Long oldMachinePartId,
      final BigDecimal topPaintArea,
      final BigDecimal innerPaintArea,
      final BigDecimal outerPaintArea,
      final BigDecimal uRibPaintArea,
      final String initialSerialNumber,
      final Boolean boolItsOwnDrawing,
      final Integer sourcePartEnum,
      final BigDecimal topFlangeArea
   ) {
      this.id = id;
      this.name = name;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaBatchId = areaBatchId;
      this.areaId = areaId;
      this.inventoryOperationId = inventoryOperationId;
      this.structureType = structureType;
      this.relationType = relationType;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.surfaceArea = surfaceArea;
      this.remark = remark;
      this.userId = userId;
      this.thick = thick;
      this.steelId = steelId;
      this.steelSpec = steelSpec;
      this.width = width;
      this.areaType = areaType;
      this.boolSchedulingEnum = boolSchedulingEnum;
      this.specPrefix = specPrefix;
      this.boolProcess = boolProcess;
      this.boolSendDirectly = boolSendDirectly;
      this.boolSinglePartEnum = boolSinglePartEnum;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      this.machinePartType = machinePartType;
      this.productClassificationEnum = productClassificationEnum;
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      this.comboId = comboId;
      this.oldMachinePartId = oldMachinePartId;
      this.topPaintArea = topPaintArea;
      this.innerPaintArea = innerPaintArea;
      this.outerPaintArea = outerPaintArea;
      this.uRibPaintArea = uRibPaintArea;
      this.initialSerialNumber = initialSerialNumber;
      this.boolItsOwnDrawing = boolItsOwnDrawing;
      this.sourcePartEnum = sourcePartEnum;
      this.topFlangeArea = topFlangeArea;
   }

   public Long getId() {
      return this.id;
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

   public Long getInventoryOperationId() {
      return this.inventoryOperationId;
   }

   public String getStructureType() {
      return this.structureType;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getThick() {
      return this.thick;
   }

   public Long getSteelId() {
      return this.steelId;
   }

   public String getSteelSpec() {
      return this.steelSpec;
   }

   public String getWidth() {
      return this.width;
   }

   public Integer getAreaType() {
      return this.areaType;
   }

   public Boolean getBoolSchedulingEnum() {
      return this.boolSchedulingEnum;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Boolean getBoolProcess() {
      return this.boolProcess;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   public Boolean getBoolSinglePartEnum() {
      return this.boolSinglePartEnum;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public Integer getMachinePartType() {
      return this.machinePartType;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public Integer getSteelPlateTypeEnum() {
      return this.steelPlateTypeEnum;
   }

   public String getComboId() {
      return this.comboId;
   }

   public Long getOldMachinePartId() {
      return this.oldMachinePartId;
   }

   public BigDecimal getTopPaintArea() {
      return this.topPaintArea;
   }

   public BigDecimal getInnerPaintArea() {
      return this.innerPaintArea;
   }

   public BigDecimal getOuterPaintArea() {
      return this.outerPaintArea;
   }

   public BigDecimal getURibPaintArea() {
      return this.uRibPaintArea;
   }

   public String getInitialSerialNumber() {
      return this.initialSerialNumber;
   }

   public Boolean getBoolItsOwnDrawing() {
      return this.boolItsOwnDrawing;
   }

   public Integer getSourcePartEnum() {
      return this.sourcePartEnum;
   }

   public BigDecimal getTopFlangeArea() {
      return this.topFlangeArea;
   }

   @JsonProperty("id")
   public TechMachinePartRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public TechMachinePartRecord setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("projectId")
   public TechMachinePartRecord setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public TechMachinePartRecord setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public TechMachinePartRecord setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("areaId")
   public TechMachinePartRecord setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("inventoryOperationId")
   public TechMachinePartRecord setInventoryOperationId(final Long inventoryOperationId) {
      this.inventoryOperationId = inventoryOperationId;
      return this;
   }

   public TechMachinePartRecord setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   @JsonProperty("relationType")
   public TechMachinePartRecord setRelationType(final Integer relationType) {
      this.relationType = relationType;
      return this;
   }

   @JsonProperty("serialNumber")
   public TechMachinePartRecord setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public TechMachinePartRecord setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public TechMachinePartRecord setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public TechMachinePartRecord setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public TechMachinePartRecord setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public TechMachinePartRecord setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public TechMachinePartRecord setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public TechMachinePartRecord setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public TechMachinePartRecord setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   public TechMachinePartRecord setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("remark")
   public TechMachinePartRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("userId")
   public TechMachinePartRecord setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("thick")
   public TechMachinePartRecord setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   public TechMachinePartRecord setSteelId(final Long steelId) {
      this.steelId = steelId;
      return this;
   }

   public TechMachinePartRecord setSteelSpec(final String steelSpec) {
      this.steelSpec = steelSpec;
      return this;
   }

   @JsonProperty("width")
   public TechMachinePartRecord setWidth(final String width) {
      this.width = width;
      return this;
   }

   @JsonProperty("areaType")
   public TechMachinePartRecord setAreaType(final Integer areaType) {
      this.areaType = areaType;
      return this;
   }

   @JsonProperty("boolSchedulingEnum")
   public TechMachinePartRecord setBoolSchedulingEnum(final Boolean boolSchedulingEnum) {
      this.boolSchedulingEnum = boolSchedulingEnum;
      return this;
   }

   public TechMachinePartRecord setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
      return this;
   }

   @JsonProperty("boolProcess")
   public TechMachinePartRecord setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
      return this;
   }

   public TechMachinePartRecord setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
      return this;
   }

   public TechMachinePartRecord setBoolSinglePartEnum(final Boolean boolSinglePartEnum) {
      this.boolSinglePartEnum = boolSinglePartEnum;
      return this;
   }

   public TechMachinePartRecord setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      return this;
   }

   public TechMachinePartRecord setMachinePartType(final Integer machinePartType) {
      this.machinePartType = machinePartType;
      return this;
   }

   public TechMachinePartRecord setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
      return this;
   }

   @JsonProperty("steelPlateTypeEnum")
   public TechMachinePartRecord setSteelPlateTypeEnum(final Integer steelPlateTypeEnum) {
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      return this;
   }

   @JsonProperty("comboId")
   public TechMachinePartRecord setComboId(final String comboId) {
      this.comboId = comboId;
      return this;
   }

   @JsonProperty("oldMachinePartId")
   public TechMachinePartRecord setOldMachinePartId(final Long oldMachinePartId) {
      this.oldMachinePartId = oldMachinePartId;
      return this;
   }

   public TechMachinePartRecord setTopPaintArea(final BigDecimal topPaintArea) {
      this.topPaintArea = topPaintArea;
      return this;
   }

   public TechMachinePartRecord setInnerPaintArea(final BigDecimal innerPaintArea) {
      this.innerPaintArea = innerPaintArea;
      return this;
   }

   public TechMachinePartRecord setOuterPaintArea(final BigDecimal outerPaintArea) {
      this.outerPaintArea = outerPaintArea;
      return this;
   }

   public TechMachinePartRecord setURibPaintArea(final BigDecimal uRibPaintArea) {
      this.uRibPaintArea = uRibPaintArea;
      return this;
   }

   @JsonProperty("initialSerialNumber")
   public TechMachinePartRecord setInitialSerialNumber(final String initialSerialNumber) {
      this.initialSerialNumber = initialSerialNumber;
      return this;
   }

   public TechMachinePartRecord setBoolItsOwnDrawing(final Boolean boolItsOwnDrawing) {
      this.boolItsOwnDrawing = boolItsOwnDrawing;
      return this;
   }

   public TechMachinePartRecord setSourcePartEnum(final Integer sourcePartEnum) {
      this.sourcePartEnum = sourcePartEnum;
      return this;
   }

   @JsonProperty("topFlangeArea")
   public TechMachinePartRecord setTopFlangeArea(final BigDecimal topFlangeArea) {
      this.topFlangeArea = topFlangeArea;
      return this;
   }

   @Override
   public String toString() {
      return "TechMachinePartRecord(id="
         + this.getId()
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
         + ", inventoryOperationId="
         + this.getInventoryOperationId()
         + ", structureType="
         + this.getStructureType()
         + ", relationType="
         + this.getRelationType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ", thick="
         + this.getThick()
         + ", steelId="
         + this.getSteelId()
         + ", steelSpec="
         + this.getSteelSpec()
         + ", width="
         + this.getWidth()
         + ", areaType="
         + this.getAreaType()
         + ", boolSchedulingEnum="
         + this.getBoolSchedulingEnum()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", boolProcess="
         + this.getBoolProcess()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", boolSinglePartEnum="
         + this.getBoolSinglePartEnum()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", machinePartType="
         + this.getMachinePartType()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", steelPlateTypeEnum="
         + this.getSteelPlateTypeEnum()
         + ", comboId="
         + this.getComboId()
         + ", oldMachinePartId="
         + this.getOldMachinePartId()
         + ", topPaintArea="
         + this.getTopPaintArea()
         + ", innerPaintArea="
         + this.getInnerPaintArea()
         + ", outerPaintArea="
         + this.getOuterPaintArea()
         + ", uRibPaintArea="
         + this.getURibPaintArea()
         + ", initialSerialNumber="
         + this.getInitialSerialNumber()
         + ", boolItsOwnDrawing="
         + this.getBoolItsOwnDrawing()
         + ", sourcePartEnum="
         + this.getSourcePartEnum()
         + ", topFlangeArea="
         + this.getTopFlangeArea()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechMachinePartRecord)) {
         return false;
      }

      TechMachinePartRecord other = (TechMachinePartRecord)o;
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
                     Object this$inventoryOperationId = this.getInventoryOperationId();
                     Object other$inventoryOperationId = other.getInventoryOperationId();
                     if (this$inventoryOperationId == null ? other$inventoryOperationId == null : this$inventoryOperationId.equals(other$inventoryOperationId)) {
                        Object this$relationType = this.getRelationType();
                        Object other$relationType = other.getRelationType();
                        if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$userId = this.getUserId();
                              Object other$userId = other.getUserId();
                              if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                 Object this$steelId = this.getSteelId();
                                 Object other$steelId = other.getSteelId();
                                 if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
                                    Object this$areaType = this.getAreaType();
                                    Object other$areaType = other.getAreaType();
                                    if (this$areaType == null ? other$areaType == null : this$areaType.equals(other$areaType)) {
                                       Object this$boolSchedulingEnum = this.getBoolSchedulingEnum();
                                       Object other$boolSchedulingEnum = other.getBoolSchedulingEnum();
                                       if (this$boolSchedulingEnum == null
                                          ? other$boolSchedulingEnum == null
                                          : this$boolSchedulingEnum.equals(other$boolSchedulingEnum)) {
                                          Object this$boolProcess = this.getBoolProcess();
                                          Object other$boolProcess = other.getBoolProcess();
                                          if (this$boolProcess == null ? other$boolProcess == null : this$boolProcess.equals(other$boolProcess)) {
                                             Object this$boolSendDirectly = this.getBoolSendDirectly();
                                             Object other$boolSendDirectly = other.getBoolSendDirectly();
                                             if (this$boolSendDirectly == null
                                                ? other$boolSendDirectly == null
                                                : this$boolSendDirectly.equals(other$boolSendDirectly)) {
                                                Object this$boolSinglePartEnum = this.getBoolSinglePartEnum();
                                                Object other$boolSinglePartEnum = other.getBoolSinglePartEnum();
                                                if (this$boolSinglePartEnum == null
                                                   ? other$boolSinglePartEnum == null
                                                   : this$boolSinglePartEnum.equals(other$boolSinglePartEnum)) {
                                                   Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                                                   Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                                                   if (this$boolAllPartSendDirectly == null
                                                      ? other$boolAllPartSendDirectly == null
                                                      : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                                                      Object this$machinePartType = this.getMachinePartType();
                                                      Object other$machinePartType = other.getMachinePartType();
                                                      if (this$machinePartType == null
                                                         ? other$machinePartType == null
                                                         : this$machinePartType.equals(other$machinePartType)) {
                                                         Object this$productClassificationEnum = this.getProductClassificationEnum();
                                                         Object other$productClassificationEnum = other.getProductClassificationEnum();
                                                         if (this$productClassificationEnum == null
                                                            ? other$productClassificationEnum == null
                                                            : this$productClassificationEnum.equals(other$productClassificationEnum)) {
                                                            Object this$steelPlateTypeEnum = this.getSteelPlateTypeEnum();
                                                            Object other$steelPlateTypeEnum = other.getSteelPlateTypeEnum();
                                                            if (this$steelPlateTypeEnum == null
                                                               ? other$steelPlateTypeEnum == null
                                                               : this$steelPlateTypeEnum.equals(other$steelPlateTypeEnum)) {
                                                               Object this$oldMachinePartId = this.getOldMachinePartId();
                                                               Object other$oldMachinePartId = other.getOldMachinePartId();
                                                               if (this$oldMachinePartId == null
                                                                  ? other$oldMachinePartId == null
                                                                  : this$oldMachinePartId.equals(other$oldMachinePartId)) {
                                                                  Object this$boolItsOwnDrawing = this.getBoolItsOwnDrawing();
                                                                  Object other$boolItsOwnDrawing = other.getBoolItsOwnDrawing();
                                                                  if (this$boolItsOwnDrawing == null
                                                                     ? other$boolItsOwnDrawing == null
                                                                     : this$boolItsOwnDrawing.equals(other$boolItsOwnDrawing)) {
                                                                     Object this$sourcePartEnum = this.getSourcePartEnum();
                                                                     Object other$sourcePartEnum = other.getSourcePartEnum();
                                                                     if (this$sourcePartEnum == null
                                                                        ? other$sourcePartEnum == null
                                                                        : this$sourcePartEnum.equals(other$sourcePartEnum)) {
                                                                        Object this$name = this.getName();
                                                                        Object other$name = other.getName();
                                                                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                                           Object this$structureType = this.getStructureType();
                                                                           Object other$structureType = other.getStructureType();
                                                                           if (this$structureType == null
                                                                              ? other$structureType == null
                                                                              : this$structureType.equals(other$structureType)) {
                                                                              Object this$serialNumber = this.getSerialNumber();
                                                                              Object other$serialNumber = other.getSerialNumber();
                                                                              if (this$serialNumber == null
                                                                                 ? other$serialNumber == null
                                                                                 : this$serialNumber.equals(other$serialNumber)) {
                                                                                 Object this$specification = this.getSpecification();
                                                                                 Object other$specification = other.getSpecification();
                                                                                 if (this$specification == null
                                                                                    ? other$specification == null
                                                                                    : this$specification.equals(other$specification)) {
                                                                                    Object this$length = this.getLength();
                                                                                    Object other$length = other.getLength();
                                                                                    if (this$length == null
                                                                                       ? other$length == null
                                                                                       : this$length.equals(other$length)) {
                                                                                       Object this$material = this.getMaterial();
                                                                                       Object other$material = other.getMaterial();
                                                                                       if (this$material == null
                                                                                          ? other$material == null
                                                                                          : this$material.equals(other$material)) {
                                                                                          Object this$netWeight = this.getNetWeight();
                                                                                          Object other$netWeight = other.getNetWeight();
                                                                                          if (this$netWeight == null
                                                                                             ? other$netWeight == null
                                                                                             : this$netWeight.equals(other$netWeight)) {
                                                                                             Object this$totalNetWeight = this.getTotalNetWeight();
                                                                                             Object other$totalNetWeight = other.getTotalNetWeight();
                                                                                             if (this$totalNetWeight == null
                                                                                                ? other$totalNetWeight == null
                                                                                                : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                                                                Object this$grossWeight = this.getGrossWeight();
                                                                                                Object other$grossWeight = other.getGrossWeight();
                                                                                                if (this$grossWeight == null
                                                                                                   ? other$grossWeight == null
                                                                                                   : this$grossWeight.equals(other$grossWeight)) {
                                                                                                   Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                                                                   Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                                                                   if (this$totalGrossWeight == null
                                                                                                      ? other$totalGrossWeight == null
                                                                                                      : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                                                                      Object this$surfaceArea = this.getSurfaceArea();
                                                                                                      Object other$surfaceArea = other.getSurfaceArea();
                                                                                                      if (this$surfaceArea == null
                                                                                                         ? other$surfaceArea == null
                                                                                                         : this$surfaceArea.equals(other$surfaceArea)) {
                                                                                                         Object this$remark = this.getRemark();
                                                                                                         Object other$remark = other.getRemark();
                                                                                                         if (this$remark == null
                                                                                                            ? other$remark == null
                                                                                                            : this$remark.equals(other$remark)) {
                                                                                                            Object this$thick = this.getThick();
                                                                                                            Object other$thick = other.getThick();
                                                                                                            if (this$thick == null
                                                                                                               ? other$thick == null
                                                                                                               : this$thick.equals(other$thick)) {
                                                                                                               Object this$steelSpec = this.getSteelSpec();
                                                                                                               Object other$steelSpec = other.getSteelSpec();
                                                                                                               if (this$steelSpec == null
                                                                                                                  ? other$steelSpec == null
                                                                                                                  : this$steelSpec.equals(other$steelSpec)) {
                                                                                                                  Object this$width = this.getWidth();
                                                                                                                  Object other$width = other.getWidth();
                                                                                                                  if (this$width == null
                                                                                                                     ? other$width == null
                                                                                                                     : this$width.equals(other$width)) {
                                                                                                                     Object this$specPrefix = this.getSpecPrefix();
                                                                                                                     Object other$specPrefix = other.getSpecPrefix();
                                                                                                                     if (this$specPrefix == null
                                                                                                                        ? other$specPrefix == null
                                                                                                                        : this$specPrefix.equals(
                                                                                                                           other$specPrefix
                                                                                                                        )) {
                                                                                                                        Object this$comboId = this.getComboId();
                                                                                                                        Object other$comboId = other.getComboId();
                                                                                                                        if (this$comboId == null
                                                                                                                           ? other$comboId == null
                                                                                                                           : this$comboId.equals(other$comboId)
                                                                                                                           )
                                                                                                                         {
                                                                                                                           Object this$topPaintArea = this.getTopPaintArea();
                                                                                                                           Object other$topPaintArea = other.getTopPaintArea();
                                                                                                                           if (this$topPaintArea == null
                                                                                                                              ? other$topPaintArea == null
                                                                                                                              : this$topPaintArea.equals(
                                                                                                                                 other$topPaintArea
                                                                                                                              )) {
                                                                                                                              Object this$innerPaintArea = this.getInnerPaintArea();
                                                                                                                              Object other$innerPaintArea = other.getInnerPaintArea();
                                                                                                                              if (this$innerPaintArea == null
                                                                                                                                 ? other$innerPaintArea == null
                                                                                                                                 : this$innerPaintArea.equals(
                                                                                                                                    other$innerPaintArea
                                                                                                                                 )) {
                                                                                                                                 Object this$outerPaintArea = this.getOuterPaintArea();
                                                                                                                                 Object other$outerPaintArea = other.getOuterPaintArea();
                                                                                                                                 if (this$outerPaintArea
                                                                                                                                       == null
                                                                                                                                    ? other$outerPaintArea
                                                                                                                                       == null
                                                                                                                                    : this$outerPaintArea.equals(
                                                                                                                                       other$outerPaintArea
                                                                                                                                    )) {
                                                                                                                                    Object this$uRibPaintArea = this.getURibPaintArea();
                                                                                                                                    Object other$uRibPaintArea = other.getURibPaintArea();
                                                                                                                                    if (this$uRibPaintArea
                                                                                                                                          == null
                                                                                                                                       ? other$uRibPaintArea
                                                                                                                                          == null
                                                                                                                                       : this$uRibPaintArea.equals(
                                                                                                                                          other$uRibPaintArea
                                                                                                                                       )) {
                                                                                                                                       Object this$initialSerialNumber = this.getInitialSerialNumber();
                                                                                                                                       Object other$initialSerialNumber = other.getInitialSerialNumber();
                                                                                                                                       if (this$initialSerialNumber
                                                                                                                                             == null
                                                                                                                                          ? other$initialSerialNumber
                                                                                                                                             == null
                                                                                                                                          : this$initialSerialNumber.equals(
                                                                                                                                             other$initialSerialNumber
                                                                                                                                          )) {
                                                                                                                                          Object this$topFlangeArea = this.getTopFlangeArea();
                                                                                                                                          Object other$topFlangeArea = other.getTopFlangeArea();
                                                                                                                                          return this$topFlangeArea
                                                                                                                                                == null
                                                                                                                                             ? other$topFlangeArea
                                                                                                                                                == null
                                                                                                                                             : this$topFlangeArea.equals(
                                                                                                                                                other$topFlangeArea
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechMachinePartRecord;
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
      Object $inventoryOperationId = this.getInventoryOperationId();
      result = result * 59 + ($inventoryOperationId == null ? 43 : $inventoryOperationId.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $areaType = this.getAreaType();
      result = result * 59 + ($areaType == null ? 43 : $areaType.hashCode());
      Object $boolSchedulingEnum = this.getBoolSchedulingEnum();
      result = result * 59 + ($boolSchedulingEnum == null ? 43 : $boolSchedulingEnum.hashCode());
      Object $boolProcess = this.getBoolProcess();
      result = result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $boolSinglePartEnum = this.getBoolSinglePartEnum();
      result = result * 59 + ($boolSinglePartEnum == null ? 43 : $boolSinglePartEnum.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $machinePartType = this.getMachinePartType();
      result = result * 59 + ($machinePartType == null ? 43 : $machinePartType.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $steelPlateTypeEnum = this.getSteelPlateTypeEnum();
      result = result * 59 + ($steelPlateTypeEnum == null ? 43 : $steelPlateTypeEnum.hashCode());
      Object $oldMachinePartId = this.getOldMachinePartId();
      result = result * 59 + ($oldMachinePartId == null ? 43 : $oldMachinePartId.hashCode());
      Object $boolItsOwnDrawing = this.getBoolItsOwnDrawing();
      result = result * 59 + ($boolItsOwnDrawing == null ? 43 : $boolItsOwnDrawing.hashCode());
      Object $sourcePartEnum = this.getSourcePartEnum();
      result = result * 59 + ($sourcePartEnum == null ? 43 : $sourcePartEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $steelSpec = this.getSteelSpec();
      result = result * 59 + ($steelSpec == null ? 43 : $steelSpec.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $comboId = this.getComboId();
      result = result * 59 + ($comboId == null ? 43 : $comboId.hashCode());
      Object $topPaintArea = this.getTopPaintArea();
      result = result * 59 + ($topPaintArea == null ? 43 : $topPaintArea.hashCode());
      Object $innerPaintArea = this.getInnerPaintArea();
      result = result * 59 + ($innerPaintArea == null ? 43 : $innerPaintArea.hashCode());
      Object $outerPaintArea = this.getOuterPaintArea();
      result = result * 59 + ($outerPaintArea == null ? 43 : $outerPaintArea.hashCode());
      Object $uRibPaintArea = this.getURibPaintArea();
      result = result * 59 + ($uRibPaintArea == null ? 43 : $uRibPaintArea.hashCode());
      Object $initialSerialNumber = this.getInitialSerialNumber();
      result = result * 59 + ($initialSerialNumber == null ? 43 : $initialSerialNumber.hashCode());
      Object $topFlangeArea = this.getTopFlangeArea();
      return result * 59 + ($topFlangeArea == null ? 43 : $topFlangeArea.hashCode());
   }

   public static class TechMachinePartRecordBuilder {
      private Long id;
      private String name;
      private Long projectId;
      private Long monomerId;
      private Long areaBatchId;
      private Long areaId;
      private Long inventoryOperationId;
      private String structureType;
      private Integer relationType;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal surfaceArea;
      private String remark;
      private Long userId;
      private String thick;
      private Long steelId;
      private String steelSpec;
      private String width;
      private Integer areaType;
      private Boolean boolSchedulingEnum;
      private String specPrefix;
      private Boolean boolProcess;
      private Boolean boolSendDirectly;
      private Boolean boolSinglePartEnum;
      private Boolean boolAllPartSendDirectly;
      private Integer machinePartType;
      private Integer productClassificationEnum;
      private Integer steelPlateTypeEnum;
      private String comboId;
      private Long oldMachinePartId;
      private BigDecimal topPaintArea;
      private BigDecimal innerPaintArea;
      private BigDecimal outerPaintArea;
      private BigDecimal uRibPaintArea;
      private String initialSerialNumber;
      private Boolean boolItsOwnDrawing;
      private Integer sourcePartEnum;
      private BigDecimal topFlangeArea;

      TechMachinePartRecordBuilder() {
      }

      @JsonProperty("id")
      public TechMachinePartRecord.TechMachinePartRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public TechMachinePartRecord.TechMachinePartRecordBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("projectId")
      public TechMachinePartRecord.TechMachinePartRecordBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public TechMachinePartRecord.TechMachinePartRecordBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public TechMachinePartRecord.TechMachinePartRecordBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("areaId")
      public TechMachinePartRecord.TechMachinePartRecordBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("inventoryOperationId")
      public TechMachinePartRecord.TechMachinePartRecordBuilder inventoryOperationId(final Long inventoryOperationId) {
         this.inventoryOperationId = inventoryOperationId;
         return this;
      }

      public TechMachinePartRecord.TechMachinePartRecordBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      @JsonProperty("relationType")
      public TechMachinePartRecord.TechMachinePartRecordBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      @JsonProperty("serialNumber")
      public TechMachinePartRecord.TechMachinePartRecordBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public TechMachinePartRecord.TechMachinePartRecordBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public TechMachinePartRecord.TechMachinePartRecordBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public TechMachinePartRecord.TechMachinePartRecordBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public TechMachinePartRecord.TechMachinePartRecordBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public TechMachinePartRecord.TechMachinePartRecordBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public TechMachinePartRecord.TechMachinePartRecordBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public TechMachinePartRecord.TechMachinePartRecordBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public TechMachinePartRecord.TechMachinePartRecordBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public TechMachinePartRecord.TechMachinePartRecordBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("remark")
      public TechMachinePartRecord.TechMachinePartRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("userId")
      public TechMachinePartRecord.TechMachinePartRecordBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("thick")
      public TechMachinePartRecord.TechMachinePartRecordBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      public TechMachinePartRecord.TechMachinePartRecordBuilder steelId(final Long steelId) {
         this.steelId = steelId;
         return this;
      }

      public TechMachinePartRecord.TechMachinePartRecordBuilder steelSpec(final String steelSpec) {
         this.steelSpec = steelSpec;
         return this;
      }

      @JsonProperty("width")
      public TechMachinePartRecord.TechMachinePartRecordBuilder width(final String width) {
         this.width = width;
         return this;
      }

      @JsonProperty("areaType")
      public TechMachinePartRecord.TechMachinePartRecordBuilder areaType(final Integer areaType) {
         this.areaType = areaType;
         return this;
      }

      @JsonProperty("boolSchedulingEnum")
      public TechMachinePartRecord.TechMachinePartRecordBuilder boolSchedulingEnum(final Boolean boolSchedulingEnum) {
         this.boolSchedulingEnum = boolSchedulingEnum;
         return this;
      }

      public TechMachinePartRecord.TechMachinePartRecordBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      @JsonProperty("boolProcess")
      public TechMachinePartRecord.TechMachinePartRecordBuilder boolProcess(final Boolean boolProcess) {
         this.boolProcess = boolProcess;
         return this;
      }

      public TechMachinePartRecord.TechMachinePartRecordBuilder boolSendDirectly(final Boolean boolSendDirectly) {
         this.boolSendDirectly = boolSendDirectly;
         return this;
      }

      public TechMachinePartRecord.TechMachinePartRecordBuilder boolSinglePartEnum(final Boolean boolSinglePartEnum) {
         this.boolSinglePartEnum = boolSinglePartEnum;
         return this;
      }

      public TechMachinePartRecord.TechMachinePartRecordBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public TechMachinePartRecord.TechMachinePartRecordBuilder machinePartType(final Integer machinePartType) {
         this.machinePartType = machinePartType;
         return this;
      }

      public TechMachinePartRecord.TechMachinePartRecordBuilder productClassificationEnum(final Integer productClassificationEnum) {
         this.productClassificationEnum = productClassificationEnum;
         return this;
      }

      @JsonProperty("steelPlateTypeEnum")
      public TechMachinePartRecord.TechMachinePartRecordBuilder steelPlateTypeEnum(final Integer steelPlateTypeEnum) {
         this.steelPlateTypeEnum = steelPlateTypeEnum;
         return this;
      }

      @JsonProperty("comboId")
      public TechMachinePartRecord.TechMachinePartRecordBuilder comboId(final String comboId) {
         this.comboId = comboId;
         return this;
      }

      @JsonProperty("oldMachinePartId")
      public TechMachinePartRecord.TechMachinePartRecordBuilder oldMachinePartId(final Long oldMachinePartId) {
         this.oldMachinePartId = oldMachinePartId;
         return this;
      }

      public TechMachinePartRecord.TechMachinePartRecordBuilder topPaintArea(final BigDecimal topPaintArea) {
         this.topPaintArea = topPaintArea;
         return this;
      }

      public TechMachinePartRecord.TechMachinePartRecordBuilder innerPaintArea(final BigDecimal innerPaintArea) {
         this.innerPaintArea = innerPaintArea;
         return this;
      }

      public TechMachinePartRecord.TechMachinePartRecordBuilder outerPaintArea(final BigDecimal outerPaintArea) {
         this.outerPaintArea = outerPaintArea;
         return this;
      }

      public TechMachinePartRecord.TechMachinePartRecordBuilder uRibPaintArea(final BigDecimal uRibPaintArea) {
         this.uRibPaintArea = uRibPaintArea;
         return this;
      }

      @JsonProperty("initialSerialNumber")
      public TechMachinePartRecord.TechMachinePartRecordBuilder initialSerialNumber(final String initialSerialNumber) {
         this.initialSerialNumber = initialSerialNumber;
         return this;
      }

      public TechMachinePartRecord.TechMachinePartRecordBuilder boolItsOwnDrawing(final Boolean boolItsOwnDrawing) {
         this.boolItsOwnDrawing = boolItsOwnDrawing;
         return this;
      }

      public TechMachinePartRecord.TechMachinePartRecordBuilder sourcePartEnum(final Integer sourcePartEnum) {
         this.sourcePartEnum = sourcePartEnum;
         return this;
      }

      @JsonProperty("topFlangeArea")
      public TechMachinePartRecord.TechMachinePartRecordBuilder topFlangeArea(final BigDecimal topFlangeArea) {
         this.topFlangeArea = topFlangeArea;
         return this;
      }

      public TechMachinePartRecord build() {
         return new TechMachinePartRecord(
            this.id,
            this.name,
            this.projectId,
            this.monomerId,
            this.areaBatchId,
            this.areaId,
            this.inventoryOperationId,
            this.structureType,
            this.relationType,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.surfaceArea,
            this.remark,
            this.userId,
            this.thick,
            this.steelId,
            this.steelSpec,
            this.width,
            this.areaType,
            this.boolSchedulingEnum,
            this.specPrefix,
            this.boolProcess,
            this.boolSendDirectly,
            this.boolSinglePartEnum,
            this.boolAllPartSendDirectly,
            this.machinePartType,
            this.productClassificationEnum,
            this.steelPlateTypeEnum,
            this.comboId,
            this.oldMachinePartId,
            this.topPaintArea,
            this.innerPaintArea,
            this.outerPaintArea,
            this.uRibPaintArea,
            this.initialSerialNumber,
            this.boolItsOwnDrawing,
            this.sourcePartEnum,
            this.topFlangeArea
         );
      }

      @Override
      public String toString() {
         return "TechMachinePartRecord.TechMachinePartRecordBuilder(id="
            + this.id
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
            + ", inventoryOperationId="
            + this.inventoryOperationId
            + ", structureType="
            + this.structureType
            + ", relationType="
            + this.relationType
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", grossWeight="
            + this.grossWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", surfaceArea="
            + this.surfaceArea
            + ", remark="
            + this.remark
            + ", userId="
            + this.userId
            + ", thick="
            + this.thick
            + ", steelId="
            + this.steelId
            + ", steelSpec="
            + this.steelSpec
            + ", width="
            + this.width
            + ", areaType="
            + this.areaType
            + ", boolSchedulingEnum="
            + this.boolSchedulingEnum
            + ", specPrefix="
            + this.specPrefix
            + ", boolProcess="
            + this.boolProcess
            + ", boolSendDirectly="
            + this.boolSendDirectly
            + ", boolSinglePartEnum="
            + this.boolSinglePartEnum
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ", machinePartType="
            + this.machinePartType
            + ", productClassificationEnum="
            + this.productClassificationEnum
            + ", steelPlateTypeEnum="
            + this.steelPlateTypeEnum
            + ", comboId="
            + this.comboId
            + ", oldMachinePartId="
            + this.oldMachinePartId
            + ", topPaintArea="
            + this.topPaintArea
            + ", innerPaintArea="
            + this.innerPaintArea
            + ", outerPaintArea="
            + this.outerPaintArea
            + ", uRibPaintArea="
            + this.uRibPaintArea
            + ", initialSerialNumber="
            + this.initialSerialNumber
            + ", boolItsOwnDrawing="
            + this.boolItsOwnDrawing
            + ", sourcePartEnum="
            + this.sourcePartEnum
            + ", topFlangeArea="
            + this.topFlangeArea
            + ")";
      }
   }
}
