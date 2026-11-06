package com.hzchum.scim.plan.core.api.pojo._do.check;

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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "TechArtifactRecord对象", description = "构件审核表")
@Entity
@TableName("tech_artifact_record")
@Table(
   name = "tech_artifact_record",
   indexes = {
         @Index(name = "idx_project_monomer_area", columnList = "project_id,monomer_id,area_id"),
         @Index(name = "id_inventory_operation_id", columnList = "inventory_operation_id")
   }
)
public class TechArtifactRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '单体ID'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '批次Id'", nullable = false)
   private Long areaBatchId;
   @ApiModelProperty(name = "areaId", value = "区域Id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '区域Id'", nullable = false)
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
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '名称'")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255) COMMENT '编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255) COMMENT '规格'", nullable = false)
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '长度(mm)'", nullable = false)
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255) COMMENT '材质'")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) COMMENT '数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   @TableField("net_weight")
   @Column(name = "net_weight", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '单净重(kg)'", nullable = false)
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   @TableField("total_net_weight")
   @Column(name = "total_net_weight", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '总净重(kg)'", nullable = false)
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   @TableField("gross_weight")
   @Column(name = "gross_weight", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '单毛重(kg)'")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   @TableField("total_gross_weight")
   @Column(name = "total_gross_weight", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '总毛重(kg)'")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "单面积（mm²）")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   @TableField("surface_area")
   @Column(name = "surface_area", columnDefinition = "decimal(32,8) DEFAULT 0.0 COMMENT '单面积(mm²)'")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "drawingNumber", value = "图号")
   @JsonProperty("drawingNumber")
   @JSONField(name = "drawingNumber")
   @TableField("drawing_number")
   @Column(name = "drawing_number", columnDefinition = "varchar(255) COMMENT '图号'")
   private String drawingNumber;
   @ApiModelProperty(name = "drawingWeight", value = "单图纸重量")
   @JsonProperty("drawingWeight")
   @JSONField(name = "drawingNumber")
   @TableField("drawing_weight")
   @Column(name = "drawing_weight", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '单图纸重量'")
   private BigDecimal drawingWeight;
   @ApiModelProperty(name = "drawingTotalWeight", value = "总图纸重量")
   @JsonProperty("drawingTotalWeight")
   @JSONField(name = "drawingTotalWeight")
   @TableField("drawing_total_weight")
   @Column(name = "drawing_total_weight", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '总图纸重量'")
   private BigDecimal drawingTotalWeight;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255) COMMENT '备注'")
   private String remark;
   @ApiModelProperty(name = "userId", value = "上传人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '上传人id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "userName", value = "上传人名称")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(522)  COMMENT '上传人名称'")
   private String userName;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀")
   @JsonProperty("specPrefix")
   @JSONField(name = "specPrefix")
   @TableField("spec_prefix")
   @Column(name = "spec_prefix", columnDefinition = "varchar(255) COMMENT '规格前缀'", nullable = false)
   private String specPrefix;
   @ApiModelProperty("构件类型 1普通构件 2次构件")
   @TableField("artifact_type")
   @Column(name = "artifact_type", columnDefinition = "int(11) comment '构件类型 1普通构件 2次构件'", nullable = false)
   private Integer artifactType;
   @ApiModelProperty(name = "boolCoatingEnum", value = "是否涂装 true是 false否")
   @TableField("bool_coating_enum")
   @Column(name = "bool_coating_enum", columnDefinition = "tinyint(1) default 1 comment '是否涂装 1是 0否'", nullable = false)
   private Boolean boolCoatingEnum;
   @ApiModelProperty(name = "boolSchedulingEnum", value = "是否排产 true 排产 false 不排产")
   @TableField("bool_scheduling_enum")
   @Column(name = "bool_scheduling_enum", columnDefinition = "tinyint(1) default 1 comment '是否排产 1是 0否'", nullable = false)
   private Boolean boolSchedulingEnum;
   @ApiModelProperty("扫码方式 1:一物一码  2:一码多物(批量) 枚举: CodingTypeEnum")
   @JsonProperty("coding_type")
   @JSONField(name = "coding_type")
   @TableField("coding_type")
   @Column(name = "coding_type", columnDefinition = "int(2) default 2 comment '扫码方式'", nullable = false)
   private Integer codingType;
   @ApiModelProperty("构件种类表id")
   @TableField("structure_class_id")
   @Column(name = "structure_class_id", columnDefinition = "bigint(20)  comment '构件种类表id'")
   private Long structureClassId;
   @ApiModelProperty(name = "serialNumberPrefix", value = "匹配名称")
   @JsonProperty("serialNumberPrefix")
   @JSONField(name = "serialNumberPrefix")
   @TableField("serial_number_prefix")
   @Column(name = "serial_number_prefix", columnDefinition = "varchar(255) COMMENT '匹配名称'", nullable = false)
   private String serialNumberPrefix;
   @ApiModelProperty(name = "boolSinglePartEnum", value = "是否单零件类型构件 true是 false否")
   @TableField("bool_single_part_enum")
   @Column(name = "bool_single_part_enum", columnDefinition = "tinyint(1) default 0 comment '是否单零件类型构件 1是 0否'", nullable = false)
   private Boolean boolSinglePartEnum;
   @ApiModelProperty(name = "boolSinglePartEnum", value = "是否只有一行零件")
   private Boolean boolOnePartLine;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否全部零件都是直发件 true 是 false 否")
   @TableField("bool_all_part_send_directly")
   @Column(name = "bool_all_part_send_directly", columnDefinition = "tinyint(1) default 0 comment '是否全部零件都是直发件 1是 0否'", nullable = false)
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty(name = "boolSendDirectly", value = "是否直发件 true 是 false 否")
   @JsonProperty("boolSendDirectly")
   @JSONField(name = "boolSendDirectly")
   @TableField("bool_send_directly")
   @Column(name = "bool_send_directly", nullable = false, columnDefinition = "tinyint(1) default 0 comment '是否直发件 1是 0否'")
   private Boolean boolSendDirectly;
   @ApiModelProperty(name = "buildingType", value = "建筑类型 1建钢 2桥梁")
   @TableField("building_type")
   @Column(name = "building_type", columnDefinition = "int(11)  comment '建筑类型 1建钢 2桥梁'", nullable = false)
   private Integer buildingType;
   @ApiModelProperty(name = "boolRepetition", value = "是否与单体中已有构件重复")
   @JsonProperty("boolRepetition")
   @JSONField(name = "boolRepetition")
   @TableField("bool_repetition")
   @Column(name = "bool_repetition", nullable = false, columnDefinition = "tinyint(1) default 0 comment '是否与区域中已有构件重复'")
   private Boolean boolRepetition;
   @ApiModelProperty(name = "boolComposeAssemble", value = "是否组合过部件 true 是 false 否")
   @JsonProperty("boolComposeAssemble")
   @JSONField(name = "boolComposeAssemble")
   @TableField("bool_compose_assemble")
   @Column(name = "bool_compose_assemble", nullable = false, columnDefinition = "tinyint(1) default 0 comment '是否组合过部件 1是 0否'")
   private Boolean boolComposeAssemble;
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
   @ApiModelProperty(name = "topFlangeArea", value = "上翼缘(单)面积（mm²）")
   @JsonProperty("topFlangeArea")
   @JSONField(name = "topFlangeArea")
   @TableField("top_flange_area")
   @Column(name = "top_flange_area", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '上翼缘(单)面积（mm²）'")
   private BigDecimal topFlangeArea;
   @ApiModelProperty(name = "下料长度")
   @JsonProperty("cuttingLength")
   @JSONField(name = "cuttingLength")
   @TableField("cutting_length")
   @Column(name = "cutting_length", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '下料长度（mm²）'")
   private BigDecimal cuttingLength;
   @ApiModelProperty(name = "高强螺栓")
   @JsonProperty("highStrengthBolt")
   @JSONField(name = "highStrengthBolt")
   @TableField("high_strength_bolt")
   @Column(name = "high_strength_bolt", columnDefinition = "varchar(255) COMMENT '高强螺栓'")
   private String highStrengthBolt;
   @ApiModelProperty(name = "螺栓数量")
   @JsonProperty("boltQuantity")
   @JSONField(name = "boltQuantity")
   @TableField("bolt_quantity")
   @Column(name = "bolt_quantity", columnDefinition = "int(11) COMMENT '螺栓数量'")
   private Integer boltQuantity;
   @ApiModelProperty(name = "配件数量")
   @JsonProperty("matchingPartsQuantity")
   @JSONField(name = "matchingPartsQuantity")
   @TableField("matching_parts_quantity")
   @Column(name = "matching_parts_quantity", columnDefinition = "int(11) COMMENT '配件数量'")
   private Integer matchingPartsQuantity;
   @ApiModelProperty(name = "杆子总长")
   @JsonProperty("totalPoleLength")
   @JSONField(name = "totalPoleLength")
   @TableField("total_pole_length")
   @Column(name = "total_pole_length", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '杆子总长'")
   private BigDecimal totalPoleLength;
   @ApiModelProperty(name = "杆子重量")
   @JsonProperty("poleWeight")
   @JSONField(name = "poleWeight")
   @TableField("pole_weight")
   @Column(name = "pole_weight", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '杆子重量'")
   private BigDecimal poleWeight;
   @ApiModelProperty(name = "封板或锥头重量")
   @JsonProperty("sealingOrPlateWeight")
   @JSONField(name = "sealingOrPlateWeight")
   @TableField("sealing_or_plate_weight")
   @Column(name = "sealing_or_plate_weight", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '封板或锥头重量'")
   private BigDecimal sealingOrPlateWeight;
   @ApiModelProperty(name = "螺栓重量")
   @JsonProperty("boltWeight")
   @JSONField(name = "boltWeight")
   @TableField("bolt_weight")
   @Column(name = "bolt_weight", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '螺栓重量'")
   private BigDecimal boltWeight;
   @ApiModelProperty(name = "套筒重量")
   @JsonProperty("sleeveWeight")
   @JSONField(name = "sleeveWeight")
   @TableField("sleeve_weight")
   @Column(name = "sleeve_weight", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '套筒重量'")
   private BigDecimal sleeveWeight;
   @ApiModelProperty(name = "销钉重量")
   @JsonProperty("dowelPinWeight")
   @JSONField(name = "dowelPinWeight")
   @TableField("dowel_pin_weight")
   @Column(name = "dowel_pin_weight", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '销钉重量'")
   private BigDecimal dowelPinWeight;
   @ApiModelProperty(name = "printedCode", value = "喷印编码")
   @JsonProperty("printedCode")
   @JSONField(name = "printedCode")
   @TableField("printed_code")
   @Column(name = "printed_code", columnDefinition = "varchar(255) COMMENT '喷印编码'")
   private String printedCode;

   public static TechArtifactRecord.TechArtifactRecordBuilder builder() {
      return new TechArtifactRecord.TechArtifactRecordBuilder();
   }

   public TechArtifactRecord() {
   }

   public TechArtifactRecord(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaBatchId,
      final Long areaId,
      final Long inventoryOperationId,
      final String structureType,
      final String name,
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
      final String drawingNumber,
      final BigDecimal drawingWeight,
      final BigDecimal drawingTotalWeight,
      final String remark,
      final Long userId,
      final String userName,
      final String specPrefix,
      final Integer artifactType,
      final Boolean boolCoatingEnum,
      final Boolean boolSchedulingEnum,
      final Integer codingType,
      final Long structureClassId,
      final String serialNumberPrefix,
      final Boolean boolSinglePartEnum,
      final Boolean boolOnePartLine,
      final Boolean boolAllPartSendDirectly,
      final Boolean boolSendDirectly,
      final Integer buildingType,
      final Boolean boolRepetition,
      final Boolean boolComposeAssemble,
      final BigDecimal topPaintArea,
      final BigDecimal innerPaintArea,
      final BigDecimal outerPaintArea,
      final BigDecimal uRibPaintArea,
      final BigDecimal topFlangeArea,
      final BigDecimal cuttingLength,
      final String highStrengthBolt,
      final Integer boltQuantity,
      final Integer matchingPartsQuantity,
      final BigDecimal totalPoleLength,
      final BigDecimal poleWeight,
      final BigDecimal sealingOrPlateWeight,
      final BigDecimal boltWeight,
      final BigDecimal sleeveWeight,
      final BigDecimal dowelPinWeight,
      final String printedCode
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaBatchId = areaBatchId;
      this.areaId = areaId;
      this.inventoryOperationId = inventoryOperationId;
      this.structureType = structureType;
      this.name = name;
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
      this.drawingNumber = drawingNumber;
      this.drawingWeight = drawingWeight;
      this.drawingTotalWeight = drawingTotalWeight;
      this.remark = remark;
      this.userId = userId;
      this.userName = userName;
      this.specPrefix = specPrefix;
      this.artifactType = artifactType;
      this.boolCoatingEnum = boolCoatingEnum;
      this.boolSchedulingEnum = boolSchedulingEnum;
      this.codingType = codingType;
      this.structureClassId = structureClassId;
      this.serialNumberPrefix = serialNumberPrefix;
      this.boolSinglePartEnum = boolSinglePartEnum;
      this.boolOnePartLine = boolOnePartLine;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      this.boolSendDirectly = boolSendDirectly;
      this.buildingType = buildingType;
      this.boolRepetition = boolRepetition;
      this.boolComposeAssemble = boolComposeAssemble;
      this.topPaintArea = topPaintArea;
      this.innerPaintArea = innerPaintArea;
      this.outerPaintArea = outerPaintArea;
      this.uRibPaintArea = uRibPaintArea;
      this.topFlangeArea = topFlangeArea;
      this.cuttingLength = cuttingLength;
      this.highStrengthBolt = highStrengthBolt;
      this.boltQuantity = boltQuantity;
      this.matchingPartsQuantity = matchingPartsQuantity;
      this.totalPoleLength = totalPoleLength;
      this.poleWeight = poleWeight;
      this.sealingOrPlateWeight = sealingOrPlateWeight;
      this.boltWeight = boltWeight;
      this.sleeveWeight = sleeveWeight;
      this.dowelPinWeight = dowelPinWeight;
      this.printedCode = printedCode;
   }

   public Long getId() {
      return this.id;
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

   public String getName() {
      return this.name;
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

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public BigDecimal getDrawingWeight() {
      return this.drawingWeight;
   }

   public BigDecimal getDrawingTotalWeight() {
      return this.drawingTotalWeight;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Boolean getBoolCoatingEnum() {
      return this.boolCoatingEnum;
   }

   public Boolean getBoolSchedulingEnum() {
      return this.boolSchedulingEnum;
   }

   public Integer getCodingType() {
      return this.codingType;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public String getSerialNumberPrefix() {
      return this.serialNumberPrefix;
   }

   public Boolean getBoolSinglePartEnum() {
      return this.boolSinglePartEnum;
   }

   public Boolean getBoolOnePartLine() {
      return this.boolOnePartLine;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   public Integer getBuildingType() {
      return this.buildingType;
   }

   public Boolean getBoolRepetition() {
      return this.boolRepetition;
   }

   public Boolean getBoolComposeAssemble() {
      return this.boolComposeAssemble;
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

   public BigDecimal getTopFlangeArea() {
      return this.topFlangeArea;
   }

   public BigDecimal getCuttingLength() {
      return this.cuttingLength;
   }

   public String getHighStrengthBolt() {
      return this.highStrengthBolt;
   }

   public Integer getBoltQuantity() {
      return this.boltQuantity;
   }

   public Integer getMatchingPartsQuantity() {
      return this.matchingPartsQuantity;
   }

   public BigDecimal getTotalPoleLength() {
      return this.totalPoleLength;
   }

   public BigDecimal getPoleWeight() {
      return this.poleWeight;
   }

   public BigDecimal getSealingOrPlateWeight() {
      return this.sealingOrPlateWeight;
   }

   public BigDecimal getBoltWeight() {
      return this.boltWeight;
   }

   public BigDecimal getSleeveWeight() {
      return this.sleeveWeight;
   }

   public BigDecimal getDowelPinWeight() {
      return this.dowelPinWeight;
   }

   public String getPrintedCode() {
      return this.printedCode;
   }

   @JsonProperty("id")
   public TechArtifactRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public TechArtifactRecord setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public TechArtifactRecord setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public TechArtifactRecord setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("areaId")
   public TechArtifactRecord setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("inventoryOperationId")
   public TechArtifactRecord setInventoryOperationId(final Long inventoryOperationId) {
      this.inventoryOperationId = inventoryOperationId;
      return this;
   }

   public TechArtifactRecord setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   @JsonProperty("name")
   public TechArtifactRecord setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public TechArtifactRecord setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public TechArtifactRecord setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public TechArtifactRecord setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public TechArtifactRecord setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public TechArtifactRecord setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public TechArtifactRecord setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public TechArtifactRecord setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public TechArtifactRecord setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public TechArtifactRecord setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("surfaceArea")
   public TechArtifactRecord setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("drawingNumber")
   public TechArtifactRecord setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
      return this;
   }

   @JsonProperty("drawingWeight")
   public TechArtifactRecord setDrawingWeight(final BigDecimal drawingWeight) {
      this.drawingWeight = drawingWeight;
      return this;
   }

   @JsonProperty("drawingTotalWeight")
   public TechArtifactRecord setDrawingTotalWeight(final BigDecimal drawingTotalWeight) {
      this.drawingTotalWeight = drawingTotalWeight;
      return this;
   }

   @JsonProperty("remark")
   public TechArtifactRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("userId")
   public TechArtifactRecord setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public TechArtifactRecord setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("specPrefix")
   public TechArtifactRecord setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
      return this;
   }

   public TechArtifactRecord setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
      return this;
   }

   public TechArtifactRecord setBoolCoatingEnum(final Boolean boolCoatingEnum) {
      this.boolCoatingEnum = boolCoatingEnum;
      return this;
   }

   public TechArtifactRecord setBoolSchedulingEnum(final Boolean boolSchedulingEnum) {
      this.boolSchedulingEnum = boolSchedulingEnum;
      return this;
   }

   @JsonProperty("coding_type")
   public TechArtifactRecord setCodingType(final Integer codingType) {
      this.codingType = codingType;
      return this;
   }

   public TechArtifactRecord setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
      return this;
   }

   @JsonProperty("serialNumberPrefix")
   public TechArtifactRecord setSerialNumberPrefix(final String serialNumberPrefix) {
      this.serialNumberPrefix = serialNumberPrefix;
      return this;
   }

   public TechArtifactRecord setBoolSinglePartEnum(final Boolean boolSinglePartEnum) {
      this.boolSinglePartEnum = boolSinglePartEnum;
      return this;
   }

   public TechArtifactRecord setBoolOnePartLine(final Boolean boolOnePartLine) {
      this.boolOnePartLine = boolOnePartLine;
      return this;
   }

   public TechArtifactRecord setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      return this;
   }

   @JsonProperty("boolSendDirectly")
   public TechArtifactRecord setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
      return this;
   }

   public TechArtifactRecord setBuildingType(final Integer buildingType) {
      this.buildingType = buildingType;
      return this;
   }

   @JsonProperty("boolRepetition")
   public TechArtifactRecord setBoolRepetition(final Boolean boolRepetition) {
      this.boolRepetition = boolRepetition;
      return this;
   }

   @JsonProperty("boolComposeAssemble")
   public TechArtifactRecord setBoolComposeAssemble(final Boolean boolComposeAssemble) {
      this.boolComposeAssemble = boolComposeAssemble;
      return this;
   }

   public TechArtifactRecord setTopPaintArea(final BigDecimal topPaintArea) {
      this.topPaintArea = topPaintArea;
      return this;
   }

   public TechArtifactRecord setInnerPaintArea(final BigDecimal innerPaintArea) {
      this.innerPaintArea = innerPaintArea;
      return this;
   }

   public TechArtifactRecord setOuterPaintArea(final BigDecimal outerPaintArea) {
      this.outerPaintArea = outerPaintArea;
      return this;
   }

   public TechArtifactRecord setURibPaintArea(final BigDecimal uRibPaintArea) {
      this.uRibPaintArea = uRibPaintArea;
      return this;
   }

   @JsonProperty("topFlangeArea")
   public TechArtifactRecord setTopFlangeArea(final BigDecimal topFlangeArea) {
      this.topFlangeArea = topFlangeArea;
      return this;
   }

   @JsonProperty("cuttingLength")
   public TechArtifactRecord setCuttingLength(final BigDecimal cuttingLength) {
      this.cuttingLength = cuttingLength;
      return this;
   }

   @JsonProperty("highStrengthBolt")
   public TechArtifactRecord setHighStrengthBolt(final String highStrengthBolt) {
      this.highStrengthBolt = highStrengthBolt;
      return this;
   }

   @JsonProperty("boltQuantity")
   public TechArtifactRecord setBoltQuantity(final Integer boltQuantity) {
      this.boltQuantity = boltQuantity;
      return this;
   }

   @JsonProperty("matchingPartsQuantity")
   public TechArtifactRecord setMatchingPartsQuantity(final Integer matchingPartsQuantity) {
      this.matchingPartsQuantity = matchingPartsQuantity;
      return this;
   }

   @JsonProperty("totalPoleLength")
   public TechArtifactRecord setTotalPoleLength(final BigDecimal totalPoleLength) {
      this.totalPoleLength = totalPoleLength;
      return this;
   }

   @JsonProperty("poleWeight")
   public TechArtifactRecord setPoleWeight(final BigDecimal poleWeight) {
      this.poleWeight = poleWeight;
      return this;
   }

   @JsonProperty("sealingOrPlateWeight")
   public TechArtifactRecord setSealingOrPlateWeight(final BigDecimal sealingOrPlateWeight) {
      this.sealingOrPlateWeight = sealingOrPlateWeight;
      return this;
   }

   @JsonProperty("boltWeight")
   public TechArtifactRecord setBoltWeight(final BigDecimal boltWeight) {
      this.boltWeight = boltWeight;
      return this;
   }

   @JsonProperty("sleeveWeight")
   public TechArtifactRecord setSleeveWeight(final BigDecimal sleeveWeight) {
      this.sleeveWeight = sleeveWeight;
      return this;
   }

   @JsonProperty("dowelPinWeight")
   public TechArtifactRecord setDowelPinWeight(final BigDecimal dowelPinWeight) {
      this.dowelPinWeight = dowelPinWeight;
      return this;
   }

   @JsonProperty("printedCode")
   public TechArtifactRecord setPrintedCode(final String printedCode) {
      this.printedCode = printedCode;
      return this;
   }

   @Override
   public String toString() {
      return "TechArtifactRecord(id="
         + this.getId()
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
         + ", name="
         + this.getName()
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
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", drawingWeight="
         + this.getDrawingWeight()
         + ", drawingTotalWeight="
         + this.getDrawingTotalWeight()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", artifactType="
         + this.getArtifactType()
         + ", boolCoatingEnum="
         + this.getBoolCoatingEnum()
         + ", boolSchedulingEnum="
         + this.getBoolSchedulingEnum()
         + ", codingType="
         + this.getCodingType()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", serialNumberPrefix="
         + this.getSerialNumberPrefix()
         + ", boolSinglePartEnum="
         + this.getBoolSinglePartEnum()
         + ", boolOnePartLine="
         + this.getBoolOnePartLine()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", buildingType="
         + this.getBuildingType()
         + ", boolRepetition="
         + this.getBoolRepetition()
         + ", boolComposeAssemble="
         + this.getBoolComposeAssemble()
         + ", topPaintArea="
         + this.getTopPaintArea()
         + ", innerPaintArea="
         + this.getInnerPaintArea()
         + ", outerPaintArea="
         + this.getOuterPaintArea()
         + ", uRibPaintArea="
         + this.getURibPaintArea()
         + ", topFlangeArea="
         + this.getTopFlangeArea()
         + ", cuttingLength="
         + this.getCuttingLength()
         + ", highStrengthBolt="
         + this.getHighStrengthBolt()
         + ", boltQuantity="
         + this.getBoltQuantity()
         + ", matchingPartsQuantity="
         + this.getMatchingPartsQuantity()
         + ", totalPoleLength="
         + this.getTotalPoleLength()
         + ", poleWeight="
         + this.getPoleWeight()
         + ", sealingOrPlateWeight="
         + this.getSealingOrPlateWeight()
         + ", boltWeight="
         + this.getBoltWeight()
         + ", sleeveWeight="
         + this.getSleeveWeight()
         + ", dowelPinWeight="
         + this.getDowelPinWeight()
         + ", printedCode="
         + this.getPrintedCode()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactRecord)) {
         return false;
      }

      TechArtifactRecord other = (TechArtifactRecord)o;
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
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$artifactType = this.getArtifactType();
                              Object other$artifactType = other.getArtifactType();
                              if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
                                 Object this$boolCoatingEnum = this.getBoolCoatingEnum();
                                 Object other$boolCoatingEnum = other.getBoolCoatingEnum();
                                 if (this$boolCoatingEnum == null ? other$boolCoatingEnum == null : this$boolCoatingEnum.equals(other$boolCoatingEnum)) {
                                    Object this$boolSchedulingEnum = this.getBoolSchedulingEnum();
                                    Object other$boolSchedulingEnum = other.getBoolSchedulingEnum();
                                    if (this$boolSchedulingEnum == null
                                       ? other$boolSchedulingEnum == null
                                       : this$boolSchedulingEnum.equals(other$boolSchedulingEnum)) {
                                       Object this$codingType = this.getCodingType();
                                       Object other$codingType = other.getCodingType();
                                       if (this$codingType == null ? other$codingType == null : this$codingType.equals(other$codingType)) {
                                          Object this$structureClassId = this.getStructureClassId();
                                          Object other$structureClassId = other.getStructureClassId();
                                          if (this$structureClassId == null
                                             ? other$structureClassId == null
                                             : this$structureClassId.equals(other$structureClassId)) {
                                             Object this$boolSinglePartEnum = this.getBoolSinglePartEnum();
                                             Object other$boolSinglePartEnum = other.getBoolSinglePartEnum();
                                             if (this$boolSinglePartEnum == null
                                                ? other$boolSinglePartEnum == null
                                                : this$boolSinglePartEnum.equals(other$boolSinglePartEnum)) {
                                                Object this$boolOnePartLine = this.getBoolOnePartLine();
                                                Object other$boolOnePartLine = other.getBoolOnePartLine();
                                                if (this$boolOnePartLine == null
                                                   ? other$boolOnePartLine == null
                                                   : this$boolOnePartLine.equals(other$boolOnePartLine)) {
                                                   Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                                                   Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                                                   if (this$boolAllPartSendDirectly == null
                                                      ? other$boolAllPartSendDirectly == null
                                                      : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                                                      Object this$boolSendDirectly = this.getBoolSendDirectly();
                                                      Object other$boolSendDirectly = other.getBoolSendDirectly();
                                                      if (this$boolSendDirectly == null
                                                         ? other$boolSendDirectly == null
                                                         : this$boolSendDirectly.equals(other$boolSendDirectly)) {
                                                         Object this$buildingType = this.getBuildingType();
                                                         Object other$buildingType = other.getBuildingType();
                                                         if (this$buildingType == null
                                                            ? other$buildingType == null
                                                            : this$buildingType.equals(other$buildingType)) {
                                                            Object this$boolRepetition = this.getBoolRepetition();
                                                            Object other$boolRepetition = other.getBoolRepetition();
                                                            if (this$boolRepetition == null
                                                               ? other$boolRepetition == null
                                                               : this$boolRepetition.equals(other$boolRepetition)) {
                                                               Object this$boolComposeAssemble = this.getBoolComposeAssemble();
                                                               Object other$boolComposeAssemble = other.getBoolComposeAssemble();
                                                               if (this$boolComposeAssemble == null
                                                                  ? other$boolComposeAssemble == null
                                                                  : this$boolComposeAssemble.equals(other$boolComposeAssemble)) {
                                                                  Object this$boltQuantity = this.getBoltQuantity();
                                                                  Object other$boltQuantity = other.getBoltQuantity();
                                                                  if (this$boltQuantity == null
                                                                     ? other$boltQuantity == null
                                                                     : this$boltQuantity.equals(other$boltQuantity)) {
                                                                     Object this$matchingPartsQuantity = this.getMatchingPartsQuantity();
                                                                     Object other$matchingPartsQuantity = other.getMatchingPartsQuantity();
                                                                     if (this$matchingPartsQuantity == null
                                                                        ? other$matchingPartsQuantity == null
                                                                        : this$matchingPartsQuantity.equals(other$matchingPartsQuantity)) {
                                                                        Object this$structureType = this.getStructureType();
                                                                        Object other$structureType = other.getStructureType();
                                                                        if (this$structureType == null
                                                                           ? other$structureType == null
                                                                           : this$structureType.equals(other$structureType)) {
                                                                           Object this$name = this.getName();
                                                                           Object other$name = other.getName();
                                                                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
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
                                                                                                         Object this$drawingNumber = this.getDrawingNumber();
                                                                                                         Object other$drawingNumber = other.getDrawingNumber();
                                                                                                         if (this$drawingNumber == null
                                                                                                            ? other$drawingNumber == null
                                                                                                            : this$drawingNumber.equals(other$drawingNumber)) {
                                                                                                            Object this$drawingWeight = this.getDrawingWeight();
                                                                                                            Object other$drawingWeight = other.getDrawingWeight();
                                                                                                            if (this$drawingWeight == null
                                                                                                               ? other$drawingWeight == null
                                                                                                               : this$drawingWeight.equals(other$drawingWeight)
                                                                                                               )
                                                                                                             {
                                                                                                               Object this$drawingTotalWeight = this.getDrawingTotalWeight();
                                                                                                               Object other$drawingTotalWeight = other.getDrawingTotalWeight();
                                                                                                               if (this$drawingTotalWeight == null
                                                                                                                  ? other$drawingTotalWeight == null
                                                                                                                  : this$drawingTotalWeight.equals(
                                                                                                                     other$drawingTotalWeight
                                                                                                                  )) {
                                                                                                                  Object this$remark = this.getRemark();
                                                                                                                  Object other$remark = other.getRemark();
                                                                                                                  if (this$remark == null
                                                                                                                     ? other$remark == null
                                                                                                                     : this$remark.equals(other$remark)) {
                                                                                                                     Object this$userName = this.getUserName();
                                                                                                                     Object other$userName = other.getUserName();
                                                                                                                     if (this$userName == null
                                                                                                                        ? other$userName == null
                                                                                                                        : this$userName.equals(other$userName)) {
                                                                                                                        Object this$specPrefix = this.getSpecPrefix();
                                                                                                                        Object other$specPrefix = other.getSpecPrefix();
                                                                                                                        if (this$specPrefix == null
                                                                                                                           ? other$specPrefix == null
                                                                                                                           : this$specPrefix.equals(
                                                                                                                              other$specPrefix
                                                                                                                           )) {
                                                                                                                           Object this$serialNumberPrefix = this.getSerialNumberPrefix();
                                                                                                                           Object other$serialNumberPrefix = other.getSerialNumberPrefix();
                                                                                                                           if (this$serialNumberPrefix == null
                                                                                                                              ? other$serialNumberPrefix
                                                                                                                                 == null
                                                                                                                              : this$serialNumberPrefix.equals(
                                                                                                                                 other$serialNumberPrefix
                                                                                                                              )) {
                                                                                                                              Object this$topPaintArea = this.getTopPaintArea();
                                                                                                                              Object other$topPaintArea = other.getTopPaintArea();
                                                                                                                              if (this$topPaintArea == null
                                                                                                                                 ? other$topPaintArea == null
                                                                                                                                 : this$topPaintArea.equals(
                                                                                                                                    other$topPaintArea
                                                                                                                                 )) {
                                                                                                                                 Object this$innerPaintArea = this.getInnerPaintArea();
                                                                                                                                 Object other$innerPaintArea = other.getInnerPaintArea();
                                                                                                                                 if (this$innerPaintArea
                                                                                                                                       == null
                                                                                                                                    ? other$innerPaintArea
                                                                                                                                       == null
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
                                                                                                                                          Object this$topFlangeArea = this.getTopFlangeArea();
                                                                                                                                          Object other$topFlangeArea = other.getTopFlangeArea();
                                                                                                                                          if (this$topFlangeArea
                                                                                                                                                == null
                                                                                                                                             ? other$topFlangeArea
                                                                                                                                                == null
                                                                                                                                             : this$topFlangeArea.equals(
                                                                                                                                                other$topFlangeArea
                                                                                                                                             )) {
                                                                                                                                             Object this$cuttingLength = this.getCuttingLength();
                                                                                                                                             Object other$cuttingLength = other.getCuttingLength();
                                                                                                                                             if (this$cuttingLength
                                                                                                                                                   == null
                                                                                                                                                ? other$cuttingLength
                                                                                                                                                   == null
                                                                                                                                                : this$cuttingLength.equals(
                                                                                                                                                   other$cuttingLength
                                                                                                                                                )) {
                                                                                                                                                Object this$highStrengthBolt = this.getHighStrengthBolt();
                                                                                                                                                Object other$highStrengthBolt = other.getHighStrengthBolt();
                                                                                                                                                if (this$highStrengthBolt
                                                                                                                                                      == null
                                                                                                                                                   ? other$highStrengthBolt
                                                                                                                                                      == null
                                                                                                                                                   : this$highStrengthBolt.equals(
                                                                                                                                                      other$highStrengthBolt
                                                                                                                                                   )) {
                                                                                                                                                   Object this$totalPoleLength = this.getTotalPoleLength();
                                                                                                                                                   Object other$totalPoleLength = other.getTotalPoleLength();
                                                                                                                                                   if (this$totalPoleLength
                                                                                                                                                         == null
                                                                                                                                                      ? other$totalPoleLength
                                                                                                                                                         == null
                                                                                                                                                      : this$totalPoleLength.equals(
                                                                                                                                                         other$totalPoleLength
                                                                                                                                                      )) {
                                                                                                                                                      Object this$poleWeight = this.getPoleWeight();
                                                                                                                                                      Object other$poleWeight = other.getPoleWeight();
                                                                                                                                                      if (this$poleWeight
                                                                                                                                                            == null
                                                                                                                                                         ? other$poleWeight
                                                                                                                                                            == null
                                                                                                                                                         : this$poleWeight.equals(
                                                                                                                                                            other$poleWeight
                                                                                                                                                         )) {
                                                                                                                                                         Object this$sealingOrPlateWeight = this.getSealingOrPlateWeight();
                                                                                                                                                         Object other$sealingOrPlateWeight = other.getSealingOrPlateWeight();
                                                                                                                                                         if (this$sealingOrPlateWeight
                                                                                                                                                               == null
                                                                                                                                                            ? other$sealingOrPlateWeight
                                                                                                                                                               == null
                                                                                                                                                            : this$sealingOrPlateWeight.equals(
                                                                                                                                                               other$sealingOrPlateWeight
                                                                                                                                                            )) {
                                                                                                                                                            Object this$boltWeight = this.getBoltWeight();
                                                                                                                                                            Object other$boltWeight = other.getBoltWeight();
                                                                                                                                                            if (this$boltWeight
                                                                                                                                                                  == null
                                                                                                                                                               ? other$boltWeight
                                                                                                                                                                  == null
                                                                                                                                                               : this$boltWeight.equals(
                                                                                                                                                                  other$boltWeight
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$sleeveWeight = this.getSleeveWeight();
                                                                                                                                                               Object other$sleeveWeight = other.getSleeveWeight();
                                                                                                                                                               if (this$sleeveWeight
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$sleeveWeight
                                                                                                                                                                     == null
                                                                                                                                                                  : this$sleeveWeight.equals(
                                                                                                                                                                     other$sleeveWeight
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$dowelPinWeight = this.getDowelPinWeight();
                                                                                                                                                                  Object other$dowelPinWeight = other.getDowelPinWeight();
                                                                                                                                                                  if (this$dowelPinWeight
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$dowelPinWeight
                                                                                                                                                                        == null
                                                                                                                                                                     : this$dowelPinWeight.equals(
                                                                                                                                                                        other$dowelPinWeight
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$printedCode = this.getPrintedCode();
                                                                                                                                                                     Object other$printedCode = other.getPrintedCode();
                                                                                                                                                                     return this$printedCode
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$printedCode
                                                                                                                                                                           == null
                                                                                                                                                                        : this$printedCode.equals(
                                                                                                                                                                           other$printedCode
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechArtifactRecord;
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
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $boolCoatingEnum = this.getBoolCoatingEnum();
      result = result * 59 + ($boolCoatingEnum == null ? 43 : $boolCoatingEnum.hashCode());
      Object $boolSchedulingEnum = this.getBoolSchedulingEnum();
      result = result * 59 + ($boolSchedulingEnum == null ? 43 : $boolSchedulingEnum.hashCode());
      Object $codingType = this.getCodingType();
      result = result * 59 + ($codingType == null ? 43 : $codingType.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $boolSinglePartEnum = this.getBoolSinglePartEnum();
      result = result * 59 + ($boolSinglePartEnum == null ? 43 : $boolSinglePartEnum.hashCode());
      Object $boolOnePartLine = this.getBoolOnePartLine();
      result = result * 59 + ($boolOnePartLine == null ? 43 : $boolOnePartLine.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $buildingType = this.getBuildingType();
      result = result * 59 + ($buildingType == null ? 43 : $buildingType.hashCode());
      Object $boolRepetition = this.getBoolRepetition();
      result = result * 59 + ($boolRepetition == null ? 43 : $boolRepetition.hashCode());
      Object $boolComposeAssemble = this.getBoolComposeAssemble();
      result = result * 59 + ($boolComposeAssemble == null ? 43 : $boolComposeAssemble.hashCode());
      Object $boltQuantity = this.getBoltQuantity();
      result = result * 59 + ($boltQuantity == null ? 43 : $boltQuantity.hashCode());
      Object $matchingPartsQuantity = this.getMatchingPartsQuantity();
      result = result * 59 + ($matchingPartsQuantity == null ? 43 : $matchingPartsQuantity.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
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
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $drawingWeight = this.getDrawingWeight();
      result = result * 59 + ($drawingWeight == null ? 43 : $drawingWeight.hashCode());
      Object $drawingTotalWeight = this.getDrawingTotalWeight();
      result = result * 59 + ($drawingTotalWeight == null ? 43 : $drawingTotalWeight.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $serialNumberPrefix = this.getSerialNumberPrefix();
      result = result * 59 + ($serialNumberPrefix == null ? 43 : $serialNumberPrefix.hashCode());
      Object $topPaintArea = this.getTopPaintArea();
      result = result * 59 + ($topPaintArea == null ? 43 : $topPaintArea.hashCode());
      Object $innerPaintArea = this.getInnerPaintArea();
      result = result * 59 + ($innerPaintArea == null ? 43 : $innerPaintArea.hashCode());
      Object $outerPaintArea = this.getOuterPaintArea();
      result = result * 59 + ($outerPaintArea == null ? 43 : $outerPaintArea.hashCode());
      Object $uRibPaintArea = this.getURibPaintArea();
      result = result * 59 + ($uRibPaintArea == null ? 43 : $uRibPaintArea.hashCode());
      Object $topFlangeArea = this.getTopFlangeArea();
      result = result * 59 + ($topFlangeArea == null ? 43 : $topFlangeArea.hashCode());
      Object $cuttingLength = this.getCuttingLength();
      result = result * 59 + ($cuttingLength == null ? 43 : $cuttingLength.hashCode());
      Object $highStrengthBolt = this.getHighStrengthBolt();
      result = result * 59 + ($highStrengthBolt == null ? 43 : $highStrengthBolt.hashCode());
      Object $totalPoleLength = this.getTotalPoleLength();
      result = result * 59 + ($totalPoleLength == null ? 43 : $totalPoleLength.hashCode());
      Object $poleWeight = this.getPoleWeight();
      result = result * 59 + ($poleWeight == null ? 43 : $poleWeight.hashCode());
      Object $sealingOrPlateWeight = this.getSealingOrPlateWeight();
      result = result * 59 + ($sealingOrPlateWeight == null ? 43 : $sealingOrPlateWeight.hashCode());
      Object $boltWeight = this.getBoltWeight();
      result = result * 59 + ($boltWeight == null ? 43 : $boltWeight.hashCode());
      Object $sleeveWeight = this.getSleeveWeight();
      result = result * 59 + ($sleeveWeight == null ? 43 : $sleeveWeight.hashCode());
      Object $dowelPinWeight = this.getDowelPinWeight();
      result = result * 59 + ($dowelPinWeight == null ? 43 : $dowelPinWeight.hashCode());
      Object $printedCode = this.getPrintedCode();
      return result * 59 + ($printedCode == null ? 43 : $printedCode.hashCode());
   }

   public static class TechArtifactRecordBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaBatchId;
      private Long areaId;
      private Long inventoryOperationId;
      private String structureType;
      private String name;
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
      private String drawingNumber;
      private BigDecimal drawingWeight;
      private BigDecimal drawingTotalWeight;
      private String remark;
      private Long userId;
      private String userName;
      private String specPrefix;
      private Integer artifactType;
      private Boolean boolCoatingEnum;
      private Boolean boolSchedulingEnum;
      private Integer codingType;
      private Long structureClassId;
      private String serialNumberPrefix;
      private Boolean boolSinglePartEnum;
      private Boolean boolOnePartLine;
      private Boolean boolAllPartSendDirectly;
      private Boolean boolSendDirectly;
      private Integer buildingType;
      private Boolean boolRepetition;
      private Boolean boolComposeAssemble;
      private BigDecimal topPaintArea;
      private BigDecimal innerPaintArea;
      private BigDecimal outerPaintArea;
      private BigDecimal uRibPaintArea;
      private BigDecimal topFlangeArea;
      private BigDecimal cuttingLength;
      private String highStrengthBolt;
      private Integer boltQuantity;
      private Integer matchingPartsQuantity;
      private BigDecimal totalPoleLength;
      private BigDecimal poleWeight;
      private BigDecimal sealingOrPlateWeight;
      private BigDecimal boltWeight;
      private BigDecimal sleeveWeight;
      private BigDecimal dowelPinWeight;
      private String printedCode;

      TechArtifactRecordBuilder() {
      }

      @JsonProperty("id")
      public TechArtifactRecord.TechArtifactRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public TechArtifactRecord.TechArtifactRecordBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public TechArtifactRecord.TechArtifactRecordBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public TechArtifactRecord.TechArtifactRecordBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("areaId")
      public TechArtifactRecord.TechArtifactRecordBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("inventoryOperationId")
      public TechArtifactRecord.TechArtifactRecordBuilder inventoryOperationId(final Long inventoryOperationId) {
         this.inventoryOperationId = inventoryOperationId;
         return this;
      }

      public TechArtifactRecord.TechArtifactRecordBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      @JsonProperty("name")
      public TechArtifactRecord.TechArtifactRecordBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public TechArtifactRecord.TechArtifactRecordBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public TechArtifactRecord.TechArtifactRecordBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public TechArtifactRecord.TechArtifactRecordBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public TechArtifactRecord.TechArtifactRecordBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public TechArtifactRecord.TechArtifactRecordBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public TechArtifactRecord.TechArtifactRecordBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public TechArtifactRecord.TechArtifactRecordBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public TechArtifactRecord.TechArtifactRecordBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public TechArtifactRecord.TechArtifactRecordBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("surfaceArea")
      public TechArtifactRecord.TechArtifactRecordBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("drawingNumber")
      public TechArtifactRecord.TechArtifactRecordBuilder drawingNumber(final String drawingNumber) {
         this.drawingNumber = drawingNumber;
         return this;
      }

      @JsonProperty("drawingWeight")
      public TechArtifactRecord.TechArtifactRecordBuilder drawingWeight(final BigDecimal drawingWeight) {
         this.drawingWeight = drawingWeight;
         return this;
      }

      @JsonProperty("drawingTotalWeight")
      public TechArtifactRecord.TechArtifactRecordBuilder drawingTotalWeight(final BigDecimal drawingTotalWeight) {
         this.drawingTotalWeight = drawingTotalWeight;
         return this;
      }

      @JsonProperty("remark")
      public TechArtifactRecord.TechArtifactRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("userId")
      public TechArtifactRecord.TechArtifactRecordBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public TechArtifactRecord.TechArtifactRecordBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("specPrefix")
      public TechArtifactRecord.TechArtifactRecordBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public TechArtifactRecord.TechArtifactRecordBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      public TechArtifactRecord.TechArtifactRecordBuilder boolCoatingEnum(final Boolean boolCoatingEnum) {
         this.boolCoatingEnum = boolCoatingEnum;
         return this;
      }

      public TechArtifactRecord.TechArtifactRecordBuilder boolSchedulingEnum(final Boolean boolSchedulingEnum) {
         this.boolSchedulingEnum = boolSchedulingEnum;
         return this;
      }

      @JsonProperty("coding_type")
      public TechArtifactRecord.TechArtifactRecordBuilder codingType(final Integer codingType) {
         this.codingType = codingType;
         return this;
      }

      public TechArtifactRecord.TechArtifactRecordBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      @JsonProperty("serialNumberPrefix")
      public TechArtifactRecord.TechArtifactRecordBuilder serialNumberPrefix(final String serialNumberPrefix) {
         this.serialNumberPrefix = serialNumberPrefix;
         return this;
      }

      public TechArtifactRecord.TechArtifactRecordBuilder boolSinglePartEnum(final Boolean boolSinglePartEnum) {
         this.boolSinglePartEnum = boolSinglePartEnum;
         return this;
      }

      public TechArtifactRecord.TechArtifactRecordBuilder boolOnePartLine(final Boolean boolOnePartLine) {
         this.boolOnePartLine = boolOnePartLine;
         return this;
      }

      public TechArtifactRecord.TechArtifactRecordBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      @JsonProperty("boolSendDirectly")
      public TechArtifactRecord.TechArtifactRecordBuilder boolSendDirectly(final Boolean boolSendDirectly) {
         this.boolSendDirectly = boolSendDirectly;
         return this;
      }

      public TechArtifactRecord.TechArtifactRecordBuilder buildingType(final Integer buildingType) {
         this.buildingType = buildingType;
         return this;
      }

      @JsonProperty("boolRepetition")
      public TechArtifactRecord.TechArtifactRecordBuilder boolRepetition(final Boolean boolRepetition) {
         this.boolRepetition = boolRepetition;
         return this;
      }

      @JsonProperty("boolComposeAssemble")
      public TechArtifactRecord.TechArtifactRecordBuilder boolComposeAssemble(final Boolean boolComposeAssemble) {
         this.boolComposeAssemble = boolComposeAssemble;
         return this;
      }

      public TechArtifactRecord.TechArtifactRecordBuilder topPaintArea(final BigDecimal topPaintArea) {
         this.topPaintArea = topPaintArea;
         return this;
      }

      public TechArtifactRecord.TechArtifactRecordBuilder innerPaintArea(final BigDecimal innerPaintArea) {
         this.innerPaintArea = innerPaintArea;
         return this;
      }

      public TechArtifactRecord.TechArtifactRecordBuilder outerPaintArea(final BigDecimal outerPaintArea) {
         this.outerPaintArea = outerPaintArea;
         return this;
      }

      public TechArtifactRecord.TechArtifactRecordBuilder uRibPaintArea(final BigDecimal uRibPaintArea) {
         this.uRibPaintArea = uRibPaintArea;
         return this;
      }

      @JsonProperty("topFlangeArea")
      public TechArtifactRecord.TechArtifactRecordBuilder topFlangeArea(final BigDecimal topFlangeArea) {
         this.topFlangeArea = topFlangeArea;
         return this;
      }

      @JsonProperty("cuttingLength")
      public TechArtifactRecord.TechArtifactRecordBuilder cuttingLength(final BigDecimal cuttingLength) {
         this.cuttingLength = cuttingLength;
         return this;
      }

      @JsonProperty("highStrengthBolt")
      public TechArtifactRecord.TechArtifactRecordBuilder highStrengthBolt(final String highStrengthBolt) {
         this.highStrengthBolt = highStrengthBolt;
         return this;
      }

      @JsonProperty("boltQuantity")
      public TechArtifactRecord.TechArtifactRecordBuilder boltQuantity(final Integer boltQuantity) {
         this.boltQuantity = boltQuantity;
         return this;
      }

      @JsonProperty("matchingPartsQuantity")
      public TechArtifactRecord.TechArtifactRecordBuilder matchingPartsQuantity(final Integer matchingPartsQuantity) {
         this.matchingPartsQuantity = matchingPartsQuantity;
         return this;
      }

      @JsonProperty("totalPoleLength")
      public TechArtifactRecord.TechArtifactRecordBuilder totalPoleLength(final BigDecimal totalPoleLength) {
         this.totalPoleLength = totalPoleLength;
         return this;
      }

      @JsonProperty("poleWeight")
      public TechArtifactRecord.TechArtifactRecordBuilder poleWeight(final BigDecimal poleWeight) {
         this.poleWeight = poleWeight;
         return this;
      }

      @JsonProperty("sealingOrPlateWeight")
      public TechArtifactRecord.TechArtifactRecordBuilder sealingOrPlateWeight(final BigDecimal sealingOrPlateWeight) {
         this.sealingOrPlateWeight = sealingOrPlateWeight;
         return this;
      }

      @JsonProperty("boltWeight")
      public TechArtifactRecord.TechArtifactRecordBuilder boltWeight(final BigDecimal boltWeight) {
         this.boltWeight = boltWeight;
         return this;
      }

      @JsonProperty("sleeveWeight")
      public TechArtifactRecord.TechArtifactRecordBuilder sleeveWeight(final BigDecimal sleeveWeight) {
         this.sleeveWeight = sleeveWeight;
         return this;
      }

      @JsonProperty("dowelPinWeight")
      public TechArtifactRecord.TechArtifactRecordBuilder dowelPinWeight(final BigDecimal dowelPinWeight) {
         this.dowelPinWeight = dowelPinWeight;
         return this;
      }

      @JsonProperty("printedCode")
      public TechArtifactRecord.TechArtifactRecordBuilder printedCode(final String printedCode) {
         this.printedCode = printedCode;
         return this;
      }

      public TechArtifactRecord build() {
         return new TechArtifactRecord(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaBatchId,
            this.areaId,
            this.inventoryOperationId,
            this.structureType,
            this.name,
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
            this.drawingNumber,
            this.drawingWeight,
            this.drawingTotalWeight,
            this.remark,
            this.userId,
            this.userName,
            this.specPrefix,
            this.artifactType,
            this.boolCoatingEnum,
            this.boolSchedulingEnum,
            this.codingType,
            this.structureClassId,
            this.serialNumberPrefix,
            this.boolSinglePartEnum,
            this.boolOnePartLine,
            this.boolAllPartSendDirectly,
            this.boolSendDirectly,
            this.buildingType,
            this.boolRepetition,
            this.boolComposeAssemble,
            this.topPaintArea,
            this.innerPaintArea,
            this.outerPaintArea,
            this.uRibPaintArea,
            this.topFlangeArea,
            this.cuttingLength,
            this.highStrengthBolt,
            this.boltQuantity,
            this.matchingPartsQuantity,
            this.totalPoleLength,
            this.poleWeight,
            this.sealingOrPlateWeight,
            this.boltWeight,
            this.sleeveWeight,
            this.dowelPinWeight,
            this.printedCode
         );
      }

      @Override
      public String toString() {
         return "TechArtifactRecord.TechArtifactRecordBuilder(id="
            + this.id
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
            + ", name="
            + this.name
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
            + ", drawingNumber="
            + this.drawingNumber
            + ", drawingWeight="
            + this.drawingWeight
            + ", drawingTotalWeight="
            + this.drawingTotalWeight
            + ", remark="
            + this.remark
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", specPrefix="
            + this.specPrefix
            + ", artifactType="
            + this.artifactType
            + ", boolCoatingEnum="
            + this.boolCoatingEnum
            + ", boolSchedulingEnum="
            + this.boolSchedulingEnum
            + ", codingType="
            + this.codingType
            + ", structureClassId="
            + this.structureClassId
            + ", serialNumberPrefix="
            + this.serialNumberPrefix
            + ", boolSinglePartEnum="
            + this.boolSinglePartEnum
            + ", boolOnePartLine="
            + this.boolOnePartLine
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ", boolSendDirectly="
            + this.boolSendDirectly
            + ", buildingType="
            + this.buildingType
            + ", boolRepetition="
            + this.boolRepetition
            + ", boolComposeAssemble="
            + this.boolComposeAssemble
            + ", topPaintArea="
            + this.topPaintArea
            + ", innerPaintArea="
            + this.innerPaintArea
            + ", outerPaintArea="
            + this.outerPaintArea
            + ", uRibPaintArea="
            + this.uRibPaintArea
            + ", topFlangeArea="
            + this.topFlangeArea
            + ", cuttingLength="
            + this.cuttingLength
            + ", highStrengthBolt="
            + this.highStrengthBolt
            + ", boltQuantity="
            + this.boltQuantity
            + ", matchingPartsQuantity="
            + this.matchingPartsQuantity
            + ", totalPoleLength="
            + this.totalPoleLength
            + ", poleWeight="
            + this.poleWeight
            + ", sealingOrPlateWeight="
            + this.sealingOrPlateWeight
            + ", boltWeight="
            + this.boltWeight
            + ", sleeveWeight="
            + this.sleeveWeight
            + ", dowelPinWeight="
            + this.dowelPinWeight
            + ", printedCode="
            + this.printedCode
            + ")";
      }
   }
}
