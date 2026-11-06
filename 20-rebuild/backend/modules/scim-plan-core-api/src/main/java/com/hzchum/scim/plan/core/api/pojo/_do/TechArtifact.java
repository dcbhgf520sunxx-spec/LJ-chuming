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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "TechArtifact对象", description = "构件 ")
@Entity
@TableName("tech_artifact")
@Table(
   name = "tech_artifact",
   indexes = {
         @Index(name = "projectId_index", columnList = "project_id"),
         @Index(name = "monomerId_index", columnList = "monomer_id"),
         @Index(name = "areaId_index", columnList = "area_id"),
         @Index(name = "seriaNumberindex", columnList = "serial_number")
   }
)
public class TechArtifact extends BaseEntity<Long> {
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
   @ApiModelProperty("变更前的id")
   private Long oldArtifactId;
   @ApiModelProperty("变更前的编号")
   private String oldArtifactSerialNumber;
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 0暂停 1进行中")
   @JsonProperty("boolStatusEnum")
   @JSONField(name = "boolStatusEnum")
   @TableField("bool_status_enum")
   @Column(name = "bool_status_enum", columnDefinition = "tinyint(1) DEFAULT 1 COMMENT '状态 0暂停 1进行中'", nullable = false)
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "boolAbnormalEnum", value = "是否异常状态 0否(正常状态) 1是(异常状态)")
   @JsonProperty("boolAbnormalEnum")
   @JSONField(name = "boolAbnormalEnum")
   @TableField("bool_abnormal_enum")
   @Column(name = "bool_abnormal_enum", columnDefinition = "tinyint(1) DEFAULT 0 COMMENT '是否异常状态 0否(正常状态) 1是(异常状态)'", nullable = false)
   private Boolean boolAbnormalEnum;
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
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(64)  COMMENT '规格'", nullable = true)
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
   @ApiModelProperty(name = "purchaseQuantity", value = "采购数量")
   @JsonProperty("purchaseQuantity")
   @JSONField(name = "purchaseQuantity")
   @TableField("purchase_quantity")
   @Column(name = "purchase_quantity", columnDefinition = "decimal(32,2) DEFAULT 0 COMMENT '采购数量'", nullable = true)
   private BigDecimal purchaseQuantity;
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
   @ApiModelProperty(name = "topFlangeArea", value = "上翼缘(单)面积（mm²）")
   @TableField("top_flange_area")
   @Column(name = "top_flange_area", columnDefinition = "decimal(32,8) DEFAULT 0.0 COMMENT '上翼缘(单)面积(mm²)'")
   private BigDecimal topFlangeArea;
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
   @ApiModelProperty(name = "userNames", value = "上传人名称(多个以逗号分隔)")
   @JsonProperty("userNames")
   @JSONField(name = "userNames")
   @TableField("user_names")
   @Column(name = "user_names", columnDefinition = "varchar(522)  COMMENT '上传人名称(多个以逗号分隔)'")
   private String userNames;
   @ApiModelProperty(name = "businessId", value = "商务id")
   @JsonProperty("businessId")
   @JSONField(name = "businessId")
   @TableField("business_id")
   @Column(name = "business_id", columnDefinition = "bigint(20) COMMENT '构件商务表id'")
   private Long businessId;
   @ApiModelProperty(name = "producedQuantity", value = "已生产量")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   @TableField("produced_quantity")
   @Column(name = "produced_quantity", columnDefinition = "int(11) DEFAULT 0 COMMENT '已生产数量'", nullable = false)
   private Integer producedQuantity;
   @ApiModelProperty(name = "areaType", value = "区域制造类型 0自制 1外包")
   @JsonProperty("areaType")
   @JSONField(name = "areaType")
   @TableField("area_type")
   @Column(name = "area_type", columnDefinition = "int(11) DEFAULT 0 COMMENT '区域类型 0自制 1外包'", nullable = false)
   private Integer areaType;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀")
   @JsonProperty("specPrefix")
   @JSONField(name = "specPrefix")
   @TableField("spec_prefix")
   @Column(name = "spec_prefix", columnDefinition = "varchar(255) COMMENT '规格前缀'", nullable = false)
   private String specPrefix;
   @ApiModelProperty(name = "serialNumberPrefix", value = "匹配名称")
   @JsonProperty("serialNumberPrefix")
   @JSONField(name = "serialNumberPrefix")
   @TableField("serial_number_prefix")
   @Column(name = "serial_number_prefix", columnDefinition = "varchar(255) COMMENT '匹配名称'", nullable = false)
   private String serialNumberPrefix;
   @ApiModelProperty(name = "smartLineMarkWord", value = "智能生产线标记词")
   @TableField("smart_line_mark_word")
   @Column(name = "smart_line_mark_word", columnDefinition = "varchar(64) comment '智能生产线标记词'")
   private String smartLineMarkWord;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   @TableField("production_line_type_enum")
   @Column(name = "production_line_type_enum", columnDefinition = "int(11) default 1 COMMENT '生产线类型 1传统线 2智能线'", nullable = false)
   private Integer productionLineTypeEnum;
   @ApiModelProperty("构件类型 1普通构件 2次构件")
   @TableField("artifact_type")
   @Column(name = "artifact_type", columnDefinition = "int(11) default 1 comment '构件类型 1普通构件 2次构件'", nullable = false)
   private Integer artifactType;
   @ApiModelProperty(name = "boolBlastingEnum", value = "是否抛丸 true是 false否")
   @TableField("bool_blasting_enum")
   @Column(name = "bool_blasting_enum", columnDefinition = "tinyint(1) default 0 comment '是否抛丸 1是 0否'", nullable = false)
   private Boolean boolBlastingEnum;
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
   @ApiModelProperty(name = "boolSinglePartEnum", value = "是否单零件类型构件 true是 false否")
   @TableField("bool_single_part_enum")
   @Column(name = "bool_single_part_enum", columnDefinition = "tinyint(1) default 0 comment '是否单零件类型构件 1是 0否'", nullable = false)
   private Boolean boolSinglePartEnum;
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
   @ApiModelProperty(name = "drawingWeight", value = "图纸单重（kg）")
   @JsonProperty("drawingWeight")
   @JSONField(name = "drawingWeight")
   @TableField("drawing_weight")
   @Column(name = "drawing_weight", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '图纸单重(kg)'")
   private BigDecimal drawingWeight;
   @ApiModelProperty(name = "totalDrawingWeight", value = "图纸总重（kg）")
   @JsonProperty("totalDrawingWeight")
   @JSONField(name = "totalDrawingWeight")
   @TableField("total_drawing_weight")
   @Column(name = "total_drawing_weight", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '图纸总重(kg)'")
   private BigDecimal totalDrawingWeight;
   @ApiModelProperty(name = "topPaintArea", value = "桥顶面油漆(单)面积(mm2)")
   @JsonProperty("topPaintArea")
   @JSONField(name = "topPaintArea")
   @TableField("top_paint_area")
   @Column(name = "top_paint_area", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '桥顶面油漆(单)面积(mm2)'")
   private BigDecimal topPaintArea;
   @ApiModelProperty(name = "innerPaintArea", value = "内表面油漆(单)面积(mm2)")
   @JsonProperty("innerPaintArea")
   @JSONField(name = "innerPaintArea")
   @TableField("inner_paint_area")
   @Column(name = "inner_paint_area", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '内表面油漆(单)面积(mm2)'")
   private BigDecimal innerPaintArea;
   @ApiModelProperty(name = "outerPaintArea", value = "外表面油漆(单)面积(mm2)")
   @JsonProperty("outerPaintArea")
   @JSONField(name = "outerPaintArea")
   @TableField("outer_paint_area")
   @Column(name = "outer_paint_area", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '外表面油漆(单)面积(mm2)'")
   private BigDecimal outerPaintArea;
   @ApiModelProperty(name = "uRibPaintArea", value = "U肋油漆(单)面积(mm2)")
   @JsonProperty("uRibPaintArea")
   @JSONField(name = "uRibPaintArea")
   @TableField("u_rib_paint_area")
   @Column(name = "u_rib_paint_area", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT 'U肋油漆(单)面积(mm2)'")
   private BigDecimal uRibPaintArea;
   @ApiModelProperty(name = "buildingType", value = "建筑类型 1建钢 2桥梁")
   @TableField("building_type")
   @Column(name = "building_type", columnDefinition = "int(11) DEFAULT 1 comment '建筑类型 1建钢 2桥梁'", nullable = false)
   private Integer buildingType;
   @ApiModelProperty(name = "boolComposeAssemble", value = "是否组合部件 true 是 false 否")
   @JsonProperty("boolComposeAssemble")
   @JSONField(name = "boolComposeAssemble")
   @TableField("bool_compose_assemble")
   @Column(name = "bool_compose_assemble", nullable = false, columnDefinition = "tinyint(1) default 0 comment 'PL构件是否组合部件 1是 0否'")
   private Boolean boolComposeAssemble;
   @ApiModelProperty(name = "outsourcingQuantity", value = "外协数量")
   @JsonProperty("outsourcingQuantity")
   @JSONField(name = "outsourcingQuantity")
   @TableField("outsourcing_quantity")
   @Column(name = "outsourcing_quantity", columnDefinition = "int(11) DEFAULT 0 COMMENT '外协数量'", nullable = false)
   private Integer outsourcingQuantity;
   @ApiModelProperty(name = "subscriptionQuantity", value = "申购数量")
   @JsonProperty("subscriptionQuantity")
   @JSONField(name = "subscriptionQuantity")
   @TableField("subscription_quantity")
   @Column(name = "subscription_quantity", columnDefinition = "int(11) DEFAULT 0 COMMENT '申购数量'", nullable = true)
   private Integer subscriptionQuantity;
   @ApiModelProperty(name = "printedCode", value = "喷印编码")
   @JsonProperty("printedCode")
   @JSONField(name = "printedCode")
   @TableField("printed_code")
   @Column(name = "printed_code", columnDefinition = "varchar(255) DEFAULT '' COMMENT '喷印编码'")
   private String printedCode;
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

   public static TechArtifact.TechArtifactBuilder builder() {
      return new TechArtifact.TechArtifactBuilder();
   }

   public TechArtifact() {
   }

   public TechArtifact(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaBatchId,
      final Long areaId,
      final Long oldArtifactId,
      final String oldArtifactSerialNumber,
      final Boolean boolStatusEnum,
      final Boolean boolAbnormalEnum,
      final String structureType,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal purchaseQuantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal topFlangeArea,
      final BigDecimal surfaceArea,
      final String drawingNumber,
      final String remark,
      final Long userId,
      final String userNames,
      final Long businessId,
      final Integer producedQuantity,
      final Integer areaType,
      final String specPrefix,
      final String serialNumberPrefix,
      final String smartLineMarkWord,
      final Integer productionLineTypeEnum,
      final Integer artifactType,
      final Boolean boolBlastingEnum,
      final Boolean boolCoatingEnum,
      final Boolean boolSchedulingEnum,
      final Integer codingType,
      final Long structureClassId,
      final Boolean boolSinglePartEnum,
      final Boolean boolAllPartSendDirectly,
      final Boolean boolSendDirectly,
      final BigDecimal drawingWeight,
      final BigDecimal totalDrawingWeight,
      final BigDecimal topPaintArea,
      final BigDecimal innerPaintArea,
      final BigDecimal outerPaintArea,
      final BigDecimal uRibPaintArea,
      final Integer buildingType,
      final Boolean boolComposeAssemble,
      final Integer outsourcingQuantity,
      final Integer subscriptionQuantity,
      final String printedCode,
      final BigDecimal cuttingLength,
      final String highStrengthBolt,
      final Integer boltQuantity,
      final Integer matchingPartsQuantity,
      final BigDecimal totalPoleLength,
      final BigDecimal poleWeight,
      final BigDecimal sealingOrPlateWeight,
      final BigDecimal boltWeight,
      final BigDecimal sleeveWeight,
      final BigDecimal dowelPinWeight
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaBatchId = areaBatchId;
      this.areaId = areaId;
      this.oldArtifactId = oldArtifactId;
      this.oldArtifactSerialNumber = oldArtifactSerialNumber;
      this.boolStatusEnum = boolStatusEnum;
      this.boolAbnormalEnum = boolAbnormalEnum;
      this.structureType = structureType;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.purchaseQuantity = purchaseQuantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.topFlangeArea = topFlangeArea;
      this.surfaceArea = surfaceArea;
      this.drawingNumber = drawingNumber;
      this.remark = remark;
      this.userId = userId;
      this.userNames = userNames;
      this.businessId = businessId;
      this.producedQuantity = producedQuantity;
      this.areaType = areaType;
      this.specPrefix = specPrefix;
      this.serialNumberPrefix = serialNumberPrefix;
      this.smartLineMarkWord = smartLineMarkWord;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.artifactType = artifactType;
      this.boolBlastingEnum = boolBlastingEnum;
      this.boolCoatingEnum = boolCoatingEnum;
      this.boolSchedulingEnum = boolSchedulingEnum;
      this.codingType = codingType;
      this.structureClassId = structureClassId;
      this.boolSinglePartEnum = boolSinglePartEnum;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      this.boolSendDirectly = boolSendDirectly;
      this.drawingWeight = drawingWeight;
      this.totalDrawingWeight = totalDrawingWeight;
      this.topPaintArea = topPaintArea;
      this.innerPaintArea = innerPaintArea;
      this.outerPaintArea = outerPaintArea;
      this.uRibPaintArea = uRibPaintArea;
      this.buildingType = buildingType;
      this.boolComposeAssemble = boolComposeAssemble;
      this.outsourcingQuantity = outsourcingQuantity;
      this.subscriptionQuantity = subscriptionQuantity;
      this.printedCode = printedCode;
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

   public Long getOldArtifactId() {
      return this.oldArtifactId;
   }

   public String getOldArtifactSerialNumber() {
      return this.oldArtifactSerialNumber;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public Boolean getBoolAbnormalEnum() {
      return this.boolAbnormalEnum;
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

   public BigDecimal getPurchaseQuantity() {
      return this.purchaseQuantity;
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

   public BigDecimal getTopFlangeArea() {
      return this.topFlangeArea;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserNames() {
      return this.userNames;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getAreaType() {
      return this.areaType;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public String getSerialNumberPrefix() {
      return this.serialNumberPrefix;
   }

   public String getSmartLineMarkWord() {
      return this.smartLineMarkWord;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Boolean getBoolBlastingEnum() {
      return this.boolBlastingEnum;
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

   public Boolean getBoolSinglePartEnum() {
      return this.boolSinglePartEnum;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   public BigDecimal getDrawingWeight() {
      return this.drawingWeight;
   }

   public BigDecimal getTotalDrawingWeight() {
      return this.totalDrawingWeight;
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

   public Integer getBuildingType() {
      return this.buildingType;
   }

   public Boolean getBoolComposeAssemble() {
      return this.boolComposeAssemble;
   }

   public Integer getOutsourcingQuantity() {
      return this.outsourcingQuantity;
   }

   public Integer getSubscriptionQuantity() {
      return this.subscriptionQuantity;
   }

   public String getPrintedCode() {
      return this.printedCode;
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

   @JsonProperty("id")
   public TechArtifact setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public TechArtifact setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public TechArtifact setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public TechArtifact setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("areaId")
   public TechArtifact setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public TechArtifact setOldArtifactId(final Long oldArtifactId) {
      this.oldArtifactId = oldArtifactId;
      return this;
   }

   public TechArtifact setOldArtifactSerialNumber(final String oldArtifactSerialNumber) {
      this.oldArtifactSerialNumber = oldArtifactSerialNumber;
      return this;
   }

   @JsonProperty("boolStatusEnum")
   public TechArtifact setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
      return this;
   }

   @JsonProperty("boolAbnormalEnum")
   public TechArtifact setBoolAbnormalEnum(final Boolean boolAbnormalEnum) {
      this.boolAbnormalEnum = boolAbnormalEnum;
      return this;
   }

   public TechArtifact setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   @JsonProperty("name")
   public TechArtifact setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public TechArtifact setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public TechArtifact setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public TechArtifact setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public TechArtifact setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public TechArtifact setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("purchaseQuantity")
   public TechArtifact setPurchaseQuantity(final BigDecimal purchaseQuantity) {
      this.purchaseQuantity = purchaseQuantity;
      return this;
   }

   @JsonProperty("netWeight")
   public TechArtifact setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public TechArtifact setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public TechArtifact setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public TechArtifact setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   public TechArtifact setTopFlangeArea(final BigDecimal topFlangeArea) {
      this.topFlangeArea = topFlangeArea;
      return this;
   }

   @JsonProperty("surfaceArea")
   public TechArtifact setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("drawingNumber")
   public TechArtifact setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
      return this;
   }

   @JsonProperty("remark")
   public TechArtifact setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("userId")
   public TechArtifact setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userNames")
   public TechArtifact setUserNames(final String userNames) {
      this.userNames = userNames;
      return this;
   }

   @JsonProperty("businessId")
   public TechArtifact setBusinessId(final Long businessId) {
      this.businessId = businessId;
      return this;
   }

   @JsonProperty("producedQuantity")
   public TechArtifact setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("areaType")
   public TechArtifact setAreaType(final Integer areaType) {
      this.areaType = areaType;
      return this;
   }

   @JsonProperty("specPrefix")
   public TechArtifact setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
      return this;
   }

   @JsonProperty("serialNumberPrefix")
   public TechArtifact setSerialNumberPrefix(final String serialNumberPrefix) {
      this.serialNumberPrefix = serialNumberPrefix;
      return this;
   }

   public TechArtifact setSmartLineMarkWord(final String smartLineMarkWord) {
      this.smartLineMarkWord = smartLineMarkWord;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public TechArtifact setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   public TechArtifact setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
      return this;
   }

   public TechArtifact setBoolBlastingEnum(final Boolean boolBlastingEnum) {
      this.boolBlastingEnum = boolBlastingEnum;
      return this;
   }

   public TechArtifact setBoolCoatingEnum(final Boolean boolCoatingEnum) {
      this.boolCoatingEnum = boolCoatingEnum;
      return this;
   }

   public TechArtifact setBoolSchedulingEnum(final Boolean boolSchedulingEnum) {
      this.boolSchedulingEnum = boolSchedulingEnum;
      return this;
   }

   @JsonProperty("coding_type")
   public TechArtifact setCodingType(final Integer codingType) {
      this.codingType = codingType;
      return this;
   }

   public TechArtifact setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
      return this;
   }

   public TechArtifact setBoolSinglePartEnum(final Boolean boolSinglePartEnum) {
      this.boolSinglePartEnum = boolSinglePartEnum;
      return this;
   }

   public TechArtifact setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      return this;
   }

   @JsonProperty("boolSendDirectly")
   public TechArtifact setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
      return this;
   }

   @JsonProperty("drawingWeight")
   public TechArtifact setDrawingWeight(final BigDecimal drawingWeight) {
      this.drawingWeight = drawingWeight;
      return this;
   }

   @JsonProperty("totalDrawingWeight")
   public TechArtifact setTotalDrawingWeight(final BigDecimal totalDrawingWeight) {
      this.totalDrawingWeight = totalDrawingWeight;
      return this;
   }

   @JsonProperty("topPaintArea")
   public TechArtifact setTopPaintArea(final BigDecimal topPaintArea) {
      this.topPaintArea = topPaintArea;
      return this;
   }

   @JsonProperty("innerPaintArea")
   public TechArtifact setInnerPaintArea(final BigDecimal innerPaintArea) {
      this.innerPaintArea = innerPaintArea;
      return this;
   }

   @JsonProperty("outerPaintArea")
   public TechArtifact setOuterPaintArea(final BigDecimal outerPaintArea) {
      this.outerPaintArea = outerPaintArea;
      return this;
   }

   @JsonProperty("uRibPaintArea")
   public TechArtifact setURibPaintArea(final BigDecimal uRibPaintArea) {
      this.uRibPaintArea = uRibPaintArea;
      return this;
   }

   public TechArtifact setBuildingType(final Integer buildingType) {
      this.buildingType = buildingType;
      return this;
   }

   @JsonProperty("boolComposeAssemble")
   public TechArtifact setBoolComposeAssemble(final Boolean boolComposeAssemble) {
      this.boolComposeAssemble = boolComposeAssemble;
      return this;
   }

   @JsonProperty("outsourcingQuantity")
   public TechArtifact setOutsourcingQuantity(final Integer outsourcingQuantity) {
      this.outsourcingQuantity = outsourcingQuantity;
      return this;
   }

   @JsonProperty("subscriptionQuantity")
   public TechArtifact setSubscriptionQuantity(final Integer subscriptionQuantity) {
      this.subscriptionQuantity = subscriptionQuantity;
      return this;
   }

   @JsonProperty("printedCode")
   public TechArtifact setPrintedCode(final String printedCode) {
      this.printedCode = printedCode;
      return this;
   }

   @JsonProperty("cuttingLength")
   public TechArtifact setCuttingLength(final BigDecimal cuttingLength) {
      this.cuttingLength = cuttingLength;
      return this;
   }

   @JsonProperty("highStrengthBolt")
   public TechArtifact setHighStrengthBolt(final String highStrengthBolt) {
      this.highStrengthBolt = highStrengthBolt;
      return this;
   }

   @JsonProperty("boltQuantity")
   public TechArtifact setBoltQuantity(final Integer boltQuantity) {
      this.boltQuantity = boltQuantity;
      return this;
   }

   @JsonProperty("matchingPartsQuantity")
   public TechArtifact setMatchingPartsQuantity(final Integer matchingPartsQuantity) {
      this.matchingPartsQuantity = matchingPartsQuantity;
      return this;
   }

   @JsonProperty("totalPoleLength")
   public TechArtifact setTotalPoleLength(final BigDecimal totalPoleLength) {
      this.totalPoleLength = totalPoleLength;
      return this;
   }

   @JsonProperty("poleWeight")
   public TechArtifact setPoleWeight(final BigDecimal poleWeight) {
      this.poleWeight = poleWeight;
      return this;
   }

   @JsonProperty("sealingOrPlateWeight")
   public TechArtifact setSealingOrPlateWeight(final BigDecimal sealingOrPlateWeight) {
      this.sealingOrPlateWeight = sealingOrPlateWeight;
      return this;
   }

   @JsonProperty("boltWeight")
   public TechArtifact setBoltWeight(final BigDecimal boltWeight) {
      this.boltWeight = boltWeight;
      return this;
   }

   @JsonProperty("sleeveWeight")
   public TechArtifact setSleeveWeight(final BigDecimal sleeveWeight) {
      this.sleeveWeight = sleeveWeight;
      return this;
   }

   @JsonProperty("dowelPinWeight")
   public TechArtifact setDowelPinWeight(final BigDecimal dowelPinWeight) {
      this.dowelPinWeight = dowelPinWeight;
      return this;
   }

   @Override
   public String toString() {
      return "TechArtifact(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", areaId="
         + this.getAreaId()
         + ", oldArtifactId="
         + this.getOldArtifactId()
         + ", oldArtifactSerialNumber="
         + this.getOldArtifactSerialNumber()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", boolAbnormalEnum="
         + this.getBoolAbnormalEnum()
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
         + ", purchaseQuantity="
         + this.getPurchaseQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", topFlangeArea="
         + this.getTopFlangeArea()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ", userNames="
         + this.getUserNames()
         + ", businessId="
         + this.getBusinessId()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", areaType="
         + this.getAreaType()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", serialNumberPrefix="
         + this.getSerialNumberPrefix()
         + ", smartLineMarkWord="
         + this.getSmartLineMarkWord()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", artifactType="
         + this.getArtifactType()
         + ", boolBlastingEnum="
         + this.getBoolBlastingEnum()
         + ", boolCoatingEnum="
         + this.getBoolCoatingEnum()
         + ", boolSchedulingEnum="
         + this.getBoolSchedulingEnum()
         + ", codingType="
         + this.getCodingType()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", boolSinglePartEnum="
         + this.getBoolSinglePartEnum()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", drawingWeight="
         + this.getDrawingWeight()
         + ", totalDrawingWeight="
         + this.getTotalDrawingWeight()
         + ", topPaintArea="
         + this.getTopPaintArea()
         + ", innerPaintArea="
         + this.getInnerPaintArea()
         + ", outerPaintArea="
         + this.getOuterPaintArea()
         + ", uRibPaintArea="
         + this.getURibPaintArea()
         + ", buildingType="
         + this.getBuildingType()
         + ", boolComposeAssemble="
         + this.getBoolComposeAssemble()
         + ", outsourcingQuantity="
         + this.getOutsourcingQuantity()
         + ", subscriptionQuantity="
         + this.getSubscriptionQuantity()
         + ", printedCode="
         + this.getPrintedCode()
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifact)) {
         return false;
      }

      TechArtifact other = (TechArtifact)o;
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
                     Object this$oldArtifactId = this.getOldArtifactId();
                     Object other$oldArtifactId = other.getOldArtifactId();
                     if (this$oldArtifactId == null ? other$oldArtifactId == null : this$oldArtifactId.equals(other$oldArtifactId)) {
                        Object this$boolStatusEnum = this.getBoolStatusEnum();
                        Object other$boolStatusEnum = other.getBoolStatusEnum();
                        if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
                           Object this$boolAbnormalEnum = this.getBoolAbnormalEnum();
                           Object other$boolAbnormalEnum = other.getBoolAbnormalEnum();
                           if (this$boolAbnormalEnum == null ? other$boolAbnormalEnum == null : this$boolAbnormalEnum.equals(other$boolAbnormalEnum)) {
                              Object this$quantity = this.getQuantity();
                              Object other$quantity = other.getQuantity();
                              if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                 Object this$userId = this.getUserId();
                                 Object other$userId = other.getUserId();
                                 if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                    Object this$businessId = this.getBusinessId();
                                    Object other$businessId = other.getBusinessId();
                                    if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
                                       Object this$producedQuantity = this.getProducedQuantity();
                                       Object other$producedQuantity = other.getProducedQuantity();
                                       if (this$producedQuantity == null
                                          ? other$producedQuantity == null
                                          : this$producedQuantity.equals(other$producedQuantity)) {
                                          Object this$areaType = this.getAreaType();
                                          Object other$areaType = other.getAreaType();
                                          if (this$areaType == null ? other$areaType == null : this$areaType.equals(other$areaType)) {
                                             Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                                             Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                                             if (this$productionLineTypeEnum == null
                                                ? other$productionLineTypeEnum == null
                                                : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                                                Object this$artifactType = this.getArtifactType();
                                                Object other$artifactType = other.getArtifactType();
                                                if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
                                                   Object this$boolBlastingEnum = this.getBoolBlastingEnum();
                                                   Object other$boolBlastingEnum = other.getBoolBlastingEnum();
                                                   if (this$boolBlastingEnum == null
                                                      ? other$boolBlastingEnum == null
                                                      : this$boolBlastingEnum.equals(other$boolBlastingEnum)) {
                                                      Object this$boolCoatingEnum = this.getBoolCoatingEnum();
                                                      Object other$boolCoatingEnum = other.getBoolCoatingEnum();
                                                      if (this$boolCoatingEnum == null
                                                         ? other$boolCoatingEnum == null
                                                         : this$boolCoatingEnum.equals(other$boolCoatingEnum)) {
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
                                                                              Object this$boolComposeAssemble = this.getBoolComposeAssemble();
                                                                              Object other$boolComposeAssemble = other.getBoolComposeAssemble();
                                                                              if (this$boolComposeAssemble == null
                                                                                 ? other$boolComposeAssemble == null
                                                                                 : this$boolComposeAssemble.equals(other$boolComposeAssemble)) {
                                                                                 Object this$outsourcingQuantity = this.getOutsourcingQuantity();
                                                                                 Object other$outsourcingQuantity = other.getOutsourcingQuantity();
                                                                                 if (this$outsourcingQuantity == null
                                                                                    ? other$outsourcingQuantity == null
                                                                                    : this$outsourcingQuantity.equals(other$outsourcingQuantity)) {
                                                                                    Object this$subscriptionQuantity = this.getSubscriptionQuantity();
                                                                                    Object other$subscriptionQuantity = other.getSubscriptionQuantity();
                                                                                    if (this$subscriptionQuantity == null
                                                                                       ? other$subscriptionQuantity == null
                                                                                       : this$subscriptionQuantity.equals(other$subscriptionQuantity)) {
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
                                                                                             Object this$oldArtifactSerialNumber = this.getOldArtifactSerialNumber();
                                                                                             Object other$oldArtifactSerialNumber = other.getOldArtifactSerialNumber();
                                                                                             if (this$oldArtifactSerialNumber == null
                                                                                                ? other$oldArtifactSerialNumber == null
                                                                                                : this$oldArtifactSerialNumber.equals(
                                                                                                   other$oldArtifactSerialNumber
                                                                                                )) {
                                                                                                Object this$structureType = this.getStructureType();
                                                                                                Object other$structureType = other.getStructureType();
                                                                                                if (this$structureType == null
                                                                                                   ? other$structureType == null
                                                                                                   : this$structureType.equals(other$structureType)) {
                                                                                                   Object this$name = this.getName();
                                                                                                   Object other$name = other.getName();
                                                                                                   if (this$name == null
                                                                                                      ? other$name == null
                                                                                                      : this$name.equals(other$name)) {
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
                                                                                                                  Object this$purchaseQuantity = this.getPurchaseQuantity();
                                                                                                                  Object other$purchaseQuantity = other.getPurchaseQuantity();
                                                                                                                  if (this$purchaseQuantity == null
                                                                                                                     ? other$purchaseQuantity == null
                                                                                                                     : this$purchaseQuantity.equals(
                                                                                                                        other$purchaseQuantity
                                                                                                                     )) {
                                                                                                                     Object this$netWeight = this.getNetWeight();
                                                                                                                     Object other$netWeight = other.getNetWeight();
                                                                                                                     if (this$netWeight == null
                                                                                                                        ? other$netWeight == null
                                                                                                                        : this$netWeight.equals(other$netWeight)
                                                                                                                        )
                                                                                                                      {
                                                                                                                        Object this$totalNetWeight = this.getTotalNetWeight();
                                                                                                                        Object other$totalNetWeight = other.getTotalNetWeight();
                                                                                                                        if (this$totalNetWeight == null
                                                                                                                           ? other$totalNetWeight == null
                                                                                                                           : this$totalNetWeight.equals(
                                                                                                                              other$totalNetWeight
                                                                                                                           )) {
                                                                                                                           Object this$grossWeight = this.getGrossWeight();
                                                                                                                           Object other$grossWeight = other.getGrossWeight();
                                                                                                                           if (this$grossWeight == null
                                                                                                                              ? other$grossWeight == null
                                                                                                                              : this$grossWeight.equals(
                                                                                                                                 other$grossWeight
                                                                                                                              )) {
                                                                                                                              Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                                                                                              Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                                                                                              if (this$totalGrossWeight == null
                                                                                                                                 ? other$totalGrossWeight
                                                                                                                                    == null
                                                                                                                                 : this$totalGrossWeight.equals(
                                                                                                                                    other$totalGrossWeight
                                                                                                                                 )) {
                                                                                                                                 Object this$topFlangeArea = this.getTopFlangeArea();
                                                                                                                                 Object other$topFlangeArea = other.getTopFlangeArea();
                                                                                                                                 if (this$topFlangeArea == null
                                                                                                                                    ? other$topFlangeArea
                                                                                                                                       == null
                                                                                                                                    : this$topFlangeArea.equals(
                                                                                                                                       other$topFlangeArea
                                                                                                                                    )) {
                                                                                                                                    Object this$surfaceArea = this.getSurfaceArea();
                                                                                                                                    Object other$surfaceArea = other.getSurfaceArea();
                                                                                                                                    if (this$surfaceArea
                                                                                                                                          == null
                                                                                                                                       ? other$surfaceArea
                                                                                                                                          == null
                                                                                                                                       : this$surfaceArea.equals(
                                                                                                                                          other$surfaceArea
                                                                                                                                       )) {
                                                                                                                                       Object this$drawingNumber = this.getDrawingNumber();
                                                                                                                                       Object other$drawingNumber = other.getDrawingNumber();
                                                                                                                                       if (this$drawingNumber
                                                                                                                                             == null
                                                                                                                                          ? other$drawingNumber
                                                                                                                                             == null
                                                                                                                                          : this$drawingNumber.equals(
                                                                                                                                             other$drawingNumber
                                                                                                                                          )) {
                                                                                                                                          Object this$remark = this.getRemark();
                                                                                                                                          Object other$remark = other.getRemark();
                                                                                                                                          if (this$remark
                                                                                                                                                == null
                                                                                                                                             ? other$remark
                                                                                                                                                == null
                                                                                                                                             : this$remark.equals(
                                                                                                                                                other$remark
                                                                                                                                             )) {
                                                                                                                                             Object this$userNames = this.getUserNames();
                                                                                                                                             Object other$userNames = other.getUserNames();
                                                                                                                                             if (this$userNames
                                                                                                                                                   == null
                                                                                                                                                ? other$userNames
                                                                                                                                                   == null
                                                                                                                                                : this$userNames.equals(
                                                                                                                                                   other$userNames
                                                                                                                                                )) {
                                                                                                                                                Object this$specPrefix = this.getSpecPrefix();
                                                                                                                                                Object other$specPrefix = other.getSpecPrefix();
                                                                                                                                                if (this$specPrefix
                                                                                                                                                      == null
                                                                                                                                                   ? other$specPrefix
                                                                                                                                                      == null
                                                                                                                                                   : this$specPrefix.equals(
                                                                                                                                                      other$specPrefix
                                                                                                                                                   )) {
                                                                                                                                                   Object this$serialNumberPrefix = this.getSerialNumberPrefix();
                                                                                                                                                   Object other$serialNumberPrefix = other.getSerialNumberPrefix();
                                                                                                                                                   if (this$serialNumberPrefix
                                                                                                                                                         == null
                                                                                                                                                      ? other$serialNumberPrefix
                                                                                                                                                         == null
                                                                                                                                                      : this$serialNumberPrefix.equals(
                                                                                                                                                         other$serialNumberPrefix
                                                                                                                                                      )) {
                                                                                                                                                      Object this$smartLineMarkWord = this.getSmartLineMarkWord();
                                                                                                                                                      Object other$smartLineMarkWord = other.getSmartLineMarkWord();
                                                                                                                                                      if (this$smartLineMarkWord
                                                                                                                                                            == null
                                                                                                                                                         ? other$smartLineMarkWord
                                                                                                                                                            == null
                                                                                                                                                         : this$smartLineMarkWord.equals(
                                                                                                                                                            other$smartLineMarkWord
                                                                                                                                                         )) {
                                                                                                                                                         Object this$drawingWeight = this.getDrawingWeight();
                                                                                                                                                         Object other$drawingWeight = other.getDrawingWeight();
                                                                                                                                                         if (this$drawingWeight
                                                                                                                                                               == null
                                                                                                                                                            ? other$drawingWeight
                                                                                                                                                               == null
                                                                                                                                                            : this$drawingWeight.equals(
                                                                                                                                                               other$drawingWeight
                                                                                                                                                            )) {
                                                                                                                                                            Object this$totalDrawingWeight = this.getTotalDrawingWeight();
                                                                                                                                                            Object other$totalDrawingWeight = other.getTotalDrawingWeight();
                                                                                                                                                            if (this$totalDrawingWeight
                                                                                                                                                                  == null
                                                                                                                                                               ? other$totalDrawingWeight
                                                                                                                                                                  == null
                                                                                                                                                               : this$totalDrawingWeight.equals(
                                                                                                                                                                  other$totalDrawingWeight
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$topPaintArea = this.getTopPaintArea();
                                                                                                                                                               Object other$topPaintArea = other.getTopPaintArea();
                                                                                                                                                               if (this$topPaintArea
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$topPaintArea
                                                                                                                                                                     == null
                                                                                                                                                                  : this$topPaintArea.equals(
                                                                                                                                                                     other$topPaintArea
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$innerPaintArea = this.getInnerPaintArea();
                                                                                                                                                                  Object other$innerPaintArea = other.getInnerPaintArea();
                                                                                                                                                                  if (this$innerPaintArea
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$innerPaintArea
                                                                                                                                                                        == null
                                                                                                                                                                     : this$innerPaintArea.equals(
                                                                                                                                                                        other$innerPaintArea
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$outerPaintArea = this.getOuterPaintArea();
                                                                                                                                                                     Object other$outerPaintArea = other.getOuterPaintArea();
                                                                                                                                                                     if (this$outerPaintArea
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$outerPaintArea
                                                                                                                                                                           == null
                                                                                                                                                                        : this$outerPaintArea.equals(
                                                                                                                                                                           other$outerPaintArea
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$uRibPaintArea = this.getURibPaintArea();
                                                                                                                                                                        Object other$uRibPaintArea = other.getURibPaintArea();
                                                                                                                                                                        if (this$uRibPaintArea
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$uRibPaintArea
                                                                                                                                                                              == null
                                                                                                                                                                           : this$uRibPaintArea.equals(
                                                                                                                                                                              other$uRibPaintArea
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$printedCode = this.getPrintedCode();
                                                                                                                                                                           Object other$printedCode = other.getPrintedCode();
                                                                                                                                                                           if (this$printedCode
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$printedCode
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$printedCode.equals(
                                                                                                                                                                                 other$printedCode
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$cuttingLength = this.getCuttingLength();
                                                                                                                                                                              Object other$cuttingLength = other.getCuttingLength();
                                                                                                                                                                              if (this$cuttingLength
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$cuttingLength
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$cuttingLength.equals(
                                                                                                                                                                                    other$cuttingLength
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$highStrengthBolt = this.getHighStrengthBolt();
                                                                                                                                                                                 Object other$highStrengthBolt = other.getHighStrengthBolt();
                                                                                                                                                                                 if (this$highStrengthBolt
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$highStrengthBolt
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$highStrengthBolt.equals(
                                                                                                                                                                                       other$highStrengthBolt
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$totalPoleLength = this.getTotalPoleLength();
                                                                                                                                                                                    Object other$totalPoleLength = other.getTotalPoleLength();
                                                                                                                                                                                    if (this$totalPoleLength
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$totalPoleLength
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$totalPoleLength.equals(
                                                                                                                                                                                          other$totalPoleLength
                                                                                                                                                                                       )
                                                                                                                                                                                       )
                                                                                                                                                                                     {
                                                                                                                                                                                       Object this$poleWeight = this.getPoleWeight();
                                                                                                                                                                                       Object other$poleWeight = other.getPoleWeight();
                                                                                                                                                                                       if (this$poleWeight
                                                                                                                                                                                             == null
                                                                                                                                                                                          ? other$poleWeight
                                                                                                                                                                                             == null
                                                                                                                                                                                          : this$poleWeight.equals(
                                                                                                                                                                                             other$poleWeight
                                                                                                                                                                                          )
                                                                                                                                                                                          )
                                                                                                                                                                                        {
                                                                                                                                                                                          Object this$sealingOrPlateWeight = this.getSealingOrPlateWeight();
                                                                                                                                                                                          Object other$sealingOrPlateWeight = other.getSealingOrPlateWeight();
                                                                                                                                                                                          if (this$sealingOrPlateWeight
                                                                                                                                                                                                == null
                                                                                                                                                                                             ? other$sealingOrPlateWeight
                                                                                                                                                                                                == null
                                                                                                                                                                                             : this$sealingOrPlateWeight.equals(
                                                                                                                                                                                                other$sealingOrPlateWeight
                                                                                                                                                                                             )
                                                                                                                                                                                             )
                                                                                                                                                                                           {
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
                                                                                                                                                                                                   return this$dowelPinWeight
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      ? other$dowelPinWeight
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      : this$dowelPinWeight.equals(
                                                                                                                                                                                                         other$dowelPinWeight
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
               } else {
                  return false;
               }
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
      return other instanceof TechArtifact;
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
      Object $oldArtifactId = this.getOldArtifactId();
      result = result * 59 + ($oldArtifactId == null ? 43 : $oldArtifactId.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $boolAbnormalEnum = this.getBoolAbnormalEnum();
      result = result * 59 + ($boolAbnormalEnum == null ? 43 : $boolAbnormalEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $areaType = this.getAreaType();
      result = result * 59 + ($areaType == null ? 43 : $areaType.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $boolBlastingEnum = this.getBoolBlastingEnum();
      result = result * 59 + ($boolBlastingEnum == null ? 43 : $boolBlastingEnum.hashCode());
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
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $buildingType = this.getBuildingType();
      result = result * 59 + ($buildingType == null ? 43 : $buildingType.hashCode());
      Object $boolComposeAssemble = this.getBoolComposeAssemble();
      result = result * 59 + ($boolComposeAssemble == null ? 43 : $boolComposeAssemble.hashCode());
      Object $outsourcingQuantity = this.getOutsourcingQuantity();
      result = result * 59 + ($outsourcingQuantity == null ? 43 : $outsourcingQuantity.hashCode());
      Object $subscriptionQuantity = this.getSubscriptionQuantity();
      result = result * 59 + ($subscriptionQuantity == null ? 43 : $subscriptionQuantity.hashCode());
      Object $boltQuantity = this.getBoltQuantity();
      result = result * 59 + ($boltQuantity == null ? 43 : $boltQuantity.hashCode());
      Object $matchingPartsQuantity = this.getMatchingPartsQuantity();
      result = result * 59 + ($matchingPartsQuantity == null ? 43 : $matchingPartsQuantity.hashCode());
      Object $oldArtifactSerialNumber = this.getOldArtifactSerialNumber();
      result = result * 59 + ($oldArtifactSerialNumber == null ? 43 : $oldArtifactSerialNumber.hashCode());
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
      Object $purchaseQuantity = this.getPurchaseQuantity();
      result = result * 59 + ($purchaseQuantity == null ? 43 : $purchaseQuantity.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $topFlangeArea = this.getTopFlangeArea();
      result = result * 59 + ($topFlangeArea == null ? 43 : $topFlangeArea.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $userNames = this.getUserNames();
      result = result * 59 + ($userNames == null ? 43 : $userNames.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $serialNumberPrefix = this.getSerialNumberPrefix();
      result = result * 59 + ($serialNumberPrefix == null ? 43 : $serialNumberPrefix.hashCode());
      Object $smartLineMarkWord = this.getSmartLineMarkWord();
      result = result * 59 + ($smartLineMarkWord == null ? 43 : $smartLineMarkWord.hashCode());
      Object $drawingWeight = this.getDrawingWeight();
      result = result * 59 + ($drawingWeight == null ? 43 : $drawingWeight.hashCode());
      Object $totalDrawingWeight = this.getTotalDrawingWeight();
      result = result * 59 + ($totalDrawingWeight == null ? 43 : $totalDrawingWeight.hashCode());
      Object $topPaintArea = this.getTopPaintArea();
      result = result * 59 + ($topPaintArea == null ? 43 : $topPaintArea.hashCode());
      Object $innerPaintArea = this.getInnerPaintArea();
      result = result * 59 + ($innerPaintArea == null ? 43 : $innerPaintArea.hashCode());
      Object $outerPaintArea = this.getOuterPaintArea();
      result = result * 59 + ($outerPaintArea == null ? 43 : $outerPaintArea.hashCode());
      Object $uRibPaintArea = this.getURibPaintArea();
      result = result * 59 + ($uRibPaintArea == null ? 43 : $uRibPaintArea.hashCode());
      Object $printedCode = this.getPrintedCode();
      result = result * 59 + ($printedCode == null ? 43 : $printedCode.hashCode());
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
      return result * 59 + ($dowelPinWeight == null ? 43 : $dowelPinWeight.hashCode());
   }

   public static class TechArtifactBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaBatchId;
      private Long areaId;
      private Long oldArtifactId;
      private String oldArtifactSerialNumber;
      private Boolean boolStatusEnum;
      private Boolean boolAbnormalEnum;
      private String structureType;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal purchaseQuantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal topFlangeArea;
      private BigDecimal surfaceArea;
      private String drawingNumber;
      private String remark;
      private Long userId;
      private String userNames;
      private Long businessId;
      private Integer producedQuantity;
      private Integer areaType;
      private String specPrefix;
      private String serialNumberPrefix;
      private String smartLineMarkWord;
      private Integer productionLineTypeEnum;
      private Integer artifactType;
      private Boolean boolBlastingEnum;
      private Boolean boolCoatingEnum;
      private Boolean boolSchedulingEnum;
      private Integer codingType;
      private Long structureClassId;
      private Boolean boolSinglePartEnum;
      private Boolean boolAllPartSendDirectly;
      private Boolean boolSendDirectly;
      private BigDecimal drawingWeight;
      private BigDecimal totalDrawingWeight;
      private BigDecimal topPaintArea;
      private BigDecimal innerPaintArea;
      private BigDecimal outerPaintArea;
      private BigDecimal uRibPaintArea;
      private Integer buildingType;
      private Boolean boolComposeAssemble;
      private Integer outsourcingQuantity;
      private Integer subscriptionQuantity;
      private String printedCode;
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

      TechArtifactBuilder() {
      }

      @JsonProperty("id")
      public TechArtifact.TechArtifactBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public TechArtifact.TechArtifactBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public TechArtifact.TechArtifactBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public TechArtifact.TechArtifactBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("areaId")
      public TechArtifact.TechArtifactBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechArtifact.TechArtifactBuilder oldArtifactId(final Long oldArtifactId) {
         this.oldArtifactId = oldArtifactId;
         return this;
      }

      public TechArtifact.TechArtifactBuilder oldArtifactSerialNumber(final String oldArtifactSerialNumber) {
         this.oldArtifactSerialNumber = oldArtifactSerialNumber;
         return this;
      }

      @JsonProperty("boolStatusEnum")
      public TechArtifact.TechArtifactBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      @JsonProperty("boolAbnormalEnum")
      public TechArtifact.TechArtifactBuilder boolAbnormalEnum(final Boolean boolAbnormalEnum) {
         this.boolAbnormalEnum = boolAbnormalEnum;
         return this;
      }

      public TechArtifact.TechArtifactBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      @JsonProperty("name")
      public TechArtifact.TechArtifactBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public TechArtifact.TechArtifactBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public TechArtifact.TechArtifactBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public TechArtifact.TechArtifactBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public TechArtifact.TechArtifactBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public TechArtifact.TechArtifactBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("purchaseQuantity")
      public TechArtifact.TechArtifactBuilder purchaseQuantity(final BigDecimal purchaseQuantity) {
         this.purchaseQuantity = purchaseQuantity;
         return this;
      }

      @JsonProperty("netWeight")
      public TechArtifact.TechArtifactBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public TechArtifact.TechArtifactBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public TechArtifact.TechArtifactBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public TechArtifact.TechArtifactBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public TechArtifact.TechArtifactBuilder topFlangeArea(final BigDecimal topFlangeArea) {
         this.topFlangeArea = topFlangeArea;
         return this;
      }

      @JsonProperty("surfaceArea")
      public TechArtifact.TechArtifactBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("drawingNumber")
      public TechArtifact.TechArtifactBuilder drawingNumber(final String drawingNumber) {
         this.drawingNumber = drawingNumber;
         return this;
      }

      @JsonProperty("remark")
      public TechArtifact.TechArtifactBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("userId")
      public TechArtifact.TechArtifactBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userNames")
      public TechArtifact.TechArtifactBuilder userNames(final String userNames) {
         this.userNames = userNames;
         return this;
      }

      @JsonProperty("businessId")
      public TechArtifact.TechArtifactBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      @JsonProperty("producedQuantity")
      public TechArtifact.TechArtifactBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("areaType")
      public TechArtifact.TechArtifactBuilder areaType(final Integer areaType) {
         this.areaType = areaType;
         return this;
      }

      @JsonProperty("specPrefix")
      public TechArtifact.TechArtifactBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      @JsonProperty("serialNumberPrefix")
      public TechArtifact.TechArtifactBuilder serialNumberPrefix(final String serialNumberPrefix) {
         this.serialNumberPrefix = serialNumberPrefix;
         return this;
      }

      public TechArtifact.TechArtifactBuilder smartLineMarkWord(final String smartLineMarkWord) {
         this.smartLineMarkWord = smartLineMarkWord;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public TechArtifact.TechArtifactBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      public TechArtifact.TechArtifactBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      public TechArtifact.TechArtifactBuilder boolBlastingEnum(final Boolean boolBlastingEnum) {
         this.boolBlastingEnum = boolBlastingEnum;
         return this;
      }

      public TechArtifact.TechArtifactBuilder boolCoatingEnum(final Boolean boolCoatingEnum) {
         this.boolCoatingEnum = boolCoatingEnum;
         return this;
      }

      public TechArtifact.TechArtifactBuilder boolSchedulingEnum(final Boolean boolSchedulingEnum) {
         this.boolSchedulingEnum = boolSchedulingEnum;
         return this;
      }

      @JsonProperty("coding_type")
      public TechArtifact.TechArtifactBuilder codingType(final Integer codingType) {
         this.codingType = codingType;
         return this;
      }

      public TechArtifact.TechArtifactBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      public TechArtifact.TechArtifactBuilder boolSinglePartEnum(final Boolean boolSinglePartEnum) {
         this.boolSinglePartEnum = boolSinglePartEnum;
         return this;
      }

      public TechArtifact.TechArtifactBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      @JsonProperty("boolSendDirectly")
      public TechArtifact.TechArtifactBuilder boolSendDirectly(final Boolean boolSendDirectly) {
         this.boolSendDirectly = boolSendDirectly;
         return this;
      }

      @JsonProperty("drawingWeight")
      public TechArtifact.TechArtifactBuilder drawingWeight(final BigDecimal drawingWeight) {
         this.drawingWeight = drawingWeight;
         return this;
      }

      @JsonProperty("totalDrawingWeight")
      public TechArtifact.TechArtifactBuilder totalDrawingWeight(final BigDecimal totalDrawingWeight) {
         this.totalDrawingWeight = totalDrawingWeight;
         return this;
      }

      @JsonProperty("topPaintArea")
      public TechArtifact.TechArtifactBuilder topPaintArea(final BigDecimal topPaintArea) {
         this.topPaintArea = topPaintArea;
         return this;
      }

      @JsonProperty("innerPaintArea")
      public TechArtifact.TechArtifactBuilder innerPaintArea(final BigDecimal innerPaintArea) {
         this.innerPaintArea = innerPaintArea;
         return this;
      }

      @JsonProperty("outerPaintArea")
      public TechArtifact.TechArtifactBuilder outerPaintArea(final BigDecimal outerPaintArea) {
         this.outerPaintArea = outerPaintArea;
         return this;
      }

      @JsonProperty("uRibPaintArea")
      public TechArtifact.TechArtifactBuilder uRibPaintArea(final BigDecimal uRibPaintArea) {
         this.uRibPaintArea = uRibPaintArea;
         return this;
      }

      public TechArtifact.TechArtifactBuilder buildingType(final Integer buildingType) {
         this.buildingType = buildingType;
         return this;
      }

      @JsonProperty("boolComposeAssemble")
      public TechArtifact.TechArtifactBuilder boolComposeAssemble(final Boolean boolComposeAssemble) {
         this.boolComposeAssemble = boolComposeAssemble;
         return this;
      }

      @JsonProperty("outsourcingQuantity")
      public TechArtifact.TechArtifactBuilder outsourcingQuantity(final Integer outsourcingQuantity) {
         this.outsourcingQuantity = outsourcingQuantity;
         return this;
      }

      @JsonProperty("subscriptionQuantity")
      public TechArtifact.TechArtifactBuilder subscriptionQuantity(final Integer subscriptionQuantity) {
         this.subscriptionQuantity = subscriptionQuantity;
         return this;
      }

      @JsonProperty("printedCode")
      public TechArtifact.TechArtifactBuilder printedCode(final String printedCode) {
         this.printedCode = printedCode;
         return this;
      }

      @JsonProperty("cuttingLength")
      public TechArtifact.TechArtifactBuilder cuttingLength(final BigDecimal cuttingLength) {
         this.cuttingLength = cuttingLength;
         return this;
      }

      @JsonProperty("highStrengthBolt")
      public TechArtifact.TechArtifactBuilder highStrengthBolt(final String highStrengthBolt) {
         this.highStrengthBolt = highStrengthBolt;
         return this;
      }

      @JsonProperty("boltQuantity")
      public TechArtifact.TechArtifactBuilder boltQuantity(final Integer boltQuantity) {
         this.boltQuantity = boltQuantity;
         return this;
      }

      @JsonProperty("matchingPartsQuantity")
      public TechArtifact.TechArtifactBuilder matchingPartsQuantity(final Integer matchingPartsQuantity) {
         this.matchingPartsQuantity = matchingPartsQuantity;
         return this;
      }

      @JsonProperty("totalPoleLength")
      public TechArtifact.TechArtifactBuilder totalPoleLength(final BigDecimal totalPoleLength) {
         this.totalPoleLength = totalPoleLength;
         return this;
      }

      @JsonProperty("poleWeight")
      public TechArtifact.TechArtifactBuilder poleWeight(final BigDecimal poleWeight) {
         this.poleWeight = poleWeight;
         return this;
      }

      @JsonProperty("sealingOrPlateWeight")
      public TechArtifact.TechArtifactBuilder sealingOrPlateWeight(final BigDecimal sealingOrPlateWeight) {
         this.sealingOrPlateWeight = sealingOrPlateWeight;
         return this;
      }

      @JsonProperty("boltWeight")
      public TechArtifact.TechArtifactBuilder boltWeight(final BigDecimal boltWeight) {
         this.boltWeight = boltWeight;
         return this;
      }

      @JsonProperty("sleeveWeight")
      public TechArtifact.TechArtifactBuilder sleeveWeight(final BigDecimal sleeveWeight) {
         this.sleeveWeight = sleeveWeight;
         return this;
      }

      @JsonProperty("dowelPinWeight")
      public TechArtifact.TechArtifactBuilder dowelPinWeight(final BigDecimal dowelPinWeight) {
         this.dowelPinWeight = dowelPinWeight;
         return this;
      }

      public TechArtifact build() {
         return new TechArtifact(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaBatchId,
            this.areaId,
            this.oldArtifactId,
            this.oldArtifactSerialNumber,
            this.boolStatusEnum,
            this.boolAbnormalEnum,
            this.structureType,
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.purchaseQuantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.topFlangeArea,
            this.surfaceArea,
            this.drawingNumber,
            this.remark,
            this.userId,
            this.userNames,
            this.businessId,
            this.producedQuantity,
            this.areaType,
            this.specPrefix,
            this.serialNumberPrefix,
            this.smartLineMarkWord,
            this.productionLineTypeEnum,
            this.artifactType,
            this.boolBlastingEnum,
            this.boolCoatingEnum,
            this.boolSchedulingEnum,
            this.codingType,
            this.structureClassId,
            this.boolSinglePartEnum,
            this.boolAllPartSendDirectly,
            this.boolSendDirectly,
            this.drawingWeight,
            this.totalDrawingWeight,
            this.topPaintArea,
            this.innerPaintArea,
            this.outerPaintArea,
            this.uRibPaintArea,
            this.buildingType,
            this.boolComposeAssemble,
            this.outsourcingQuantity,
            this.subscriptionQuantity,
            this.printedCode,
            this.cuttingLength,
            this.highStrengthBolt,
            this.boltQuantity,
            this.matchingPartsQuantity,
            this.totalPoleLength,
            this.poleWeight,
            this.sealingOrPlateWeight,
            this.boltWeight,
            this.sleeveWeight,
            this.dowelPinWeight
         );
      }

      @Override
      public String toString() {
         return "TechArtifact.TechArtifactBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaBatchId="
            + this.areaBatchId
            + ", areaId="
            + this.areaId
            + ", oldArtifactId="
            + this.oldArtifactId
            + ", oldArtifactSerialNumber="
            + this.oldArtifactSerialNumber
            + ", boolStatusEnum="
            + this.boolStatusEnum
            + ", boolAbnormalEnum="
            + this.boolAbnormalEnum
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
            + ", purchaseQuantity="
            + this.purchaseQuantity
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", grossWeight="
            + this.grossWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", topFlangeArea="
            + this.topFlangeArea
            + ", surfaceArea="
            + this.surfaceArea
            + ", drawingNumber="
            + this.drawingNumber
            + ", remark="
            + this.remark
            + ", userId="
            + this.userId
            + ", userNames="
            + this.userNames
            + ", businessId="
            + this.businessId
            + ", producedQuantity="
            + this.producedQuantity
            + ", areaType="
            + this.areaType
            + ", specPrefix="
            + this.specPrefix
            + ", serialNumberPrefix="
            + this.serialNumberPrefix
            + ", smartLineMarkWord="
            + this.smartLineMarkWord
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", artifactType="
            + this.artifactType
            + ", boolBlastingEnum="
            + this.boolBlastingEnum
            + ", boolCoatingEnum="
            + this.boolCoatingEnum
            + ", boolSchedulingEnum="
            + this.boolSchedulingEnum
            + ", codingType="
            + this.codingType
            + ", structureClassId="
            + this.structureClassId
            + ", boolSinglePartEnum="
            + this.boolSinglePartEnum
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ", boolSendDirectly="
            + this.boolSendDirectly
            + ", drawingWeight="
            + this.drawingWeight
            + ", totalDrawingWeight="
            + this.totalDrawingWeight
            + ", topPaintArea="
            + this.topPaintArea
            + ", innerPaintArea="
            + this.innerPaintArea
            + ", outerPaintArea="
            + this.outerPaintArea
            + ", uRibPaintArea="
            + this.uRibPaintArea
            + ", buildingType="
            + this.buildingType
            + ", boolComposeAssemble="
            + this.boolComposeAssemble
            + ", outsourcingQuantity="
            + this.outsourcingQuantity
            + ", subscriptionQuantity="
            + this.subscriptionQuantity
            + ", printedCode="
            + this.printedCode
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
            + ")";
      }
   }
}
