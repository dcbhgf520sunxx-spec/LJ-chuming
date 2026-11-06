package com.hzchum.scim.plan.core.api.pojo._do;

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
import javax.persistence.Table;
import javax.persistence.Transient;

@ApiModel(value = "TechMachinePart对象", description = "零件 ")
@Entity
@TableName("tech_machine_part")
@Table(name = "tech_machine_part")
public class TechMachinePart extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 false暂停 true进行中")
   @JsonProperty("boolStatusEnum")
   @JSONField(name = "boolStatusEnum")
   @TableField("bool_status_enum")
   @Column(name = "bool_status_enum", columnDefinition = "tinyint(1) default 1 comment '状态 0暂停 1进行中'", nullable = false)
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "relationType", value = "关联产品类型 2关联构件 16关联组立 18组立 枚举:MachinePartRelationTypeEnum")
   @JsonProperty("relationType")
   @JSONField(name = "relationType")
   @TableField("relation_type")
   @Column(name = "relation_type", columnDefinition = "int(11) default 2 comment '关联类型 2普通零件(关联构件) 16翼板腹板(关联组立) 18等于组立'", nullable = false)
   private Integer relationType;
   @ApiModelProperty(name = "structureType", value = "结构类型")
   @TableField("structure_type")
   @Column(name = "structure_type", columnDefinition = "varchar(255) COMMENT '名称'")
   private String structureType;
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
   @ApiModelProperty(name = "type", value = "类型 1剪板2数控")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type")
   private Integer type;
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
   @ApiModelProperty(name = "usedQuantity", value = "已使用量")
   @JsonProperty("usedQuantity")
   @JSONField(name = "usedQuantity")
   @TableField("used_quantity")
   @Column(name = "used_quantity", columnDefinition = "int(11) default '0' COMMENT '使用量'", nullable = false)
   private Integer usedQuantity;
   @ApiModelProperty(name = "producedQuantity", value = "已生产量")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   @TableField("produced_quantity")
   @Column(name = "produced_quantity", columnDefinition = "int(11) default 0 comment '已生产数'", nullable = false)
   private Integer producedQuantity;
   @ApiModelProperty(name = "useCompleteQuantity", value = "二次利用默认生产完成数")
   @JsonProperty("useCompleteQuantity")
   @JSONField(name = "useCompleteQuantity")
   @TableField("use_complete_quantity")
   @Column(name = "use_complete_quantity", columnDefinition = "int(11) default 0 comment '二次利用默认生产完成数'", nullable = false)
   private Integer useCompleteQuantity;
   @ApiModelProperty(name = "drawingNumber", value = "图号")
   @JsonProperty("drawingNumber")
   @JSONField(name = "drawingNumber")
   @TableField("drawing_number")
   @Column(name = "drawing_number")
   private String drawingNumber;
   @ApiModelProperty(name = "thick", value = "厚(mm)")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   @TableField("thick")
   @Column(name = "thick")
   private String thick;
   @ApiModelProperty(name = "width", notes = "宽度（mm）")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width")
   private String width;
   @ApiModelProperty(name = "path", value = "路径")
   @JsonProperty("path")
   @JSONField(name = "path")
   @TableField(value = "path", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "path", columnDefinition = "varchar(255) comment '套料dxf文件云地址'")
   private String path;
   @ApiModelProperty(name = "ossRelativePath", value = "相对路径")
   @TableField(value = "OSS_relative_path", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "OSS_relative_path", columnDefinition = "varchar(255) comment '套料dxf文件相对地址'")
   private String ossRelativePath;
   @ApiModelProperty(name = "nestingState", value = "排套状态")
   @JsonProperty("nestingState")
   @JSONField(name = "nestingState")
   @TableField("nesting_state")
   @Column(name = "nesting_state")
   private Integer nestingState;
   @ApiModelProperty("钢材配置id")
   @Column
   @TableField(updateStrategy = FieldStrategy.IGNORED)
   private Long steelId;
   @ApiModelProperty("钢材厚度/规格")
   @Column
   @TableField(updateStrategy = FieldStrategy.IGNORED)
   private String steelSpec;
   @ApiModelProperty(name = "areaType", value = "区域制造类型 0自制 1外包")
   @JsonProperty("areaType")
   @JSONField(name = "areaType")
   @TableField("area_type")
   @Column(name = "area_type")
   private Integer areaType;
   @ApiModelProperty(name = "boolAbnormalEnum", value = "是否异常状态 false(正常状态) true(异常状态)")
   @JsonProperty("boolAbnormalEnum")
   @JSONField(name = "boolAbnormalEnum")
   @TableField("bool_abnormal_enum")
   @Column(name = "bool_abnormal_enum", columnDefinition = "tinyint(1) default 0 comment '是否异常状态 0否(正常状态) 1是(异常状态)'", nullable = false)
   private Boolean boolAbnormalEnum;
   @ApiModelProperty(name = "boolSchedulingEnum", value = "是否排产 TRUE是 false 否")
   @JsonProperty("boolSchedulingEnum")
   @JSONField(name = "boolSchedulingEnum")
   @TableField("bool_scheduling_enum")
   @Column(name = "bool_scheduling_enum", columnDefinition = "tinyint(1) default 1 comment '是否排产 1是 0否' ", nullable = false)
   private Boolean boolSchedulingEnum;
   @ApiModelProperty("是否套料")
   @TableField("bool_nest_enum")
   @Column(name = "bool_nest_enum", nullable = false, columnDefinition = "tinyint(1) default 1")
   private Boolean boolNestEnum;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀")
   @TableField("spec_prefix")
   @Column(name = "spec_prefix", columnDefinition = "varchar(255) default '' comment '规格前缀' ")
   private String specPrefix;
   @ApiModelProperty(name = "boolSectionSteel", value = "是否成品型材 [false 否, true 是]", notes = "是否成品型材 [false 否, true 是]]")
   @TableField("bool_section_steel")
   @Column(name = "bool_section_steel", columnDefinition = "tinyint(1) default 0 comment '是否成品型材' ", nullable = false)
   private Boolean boolSectionSteel;
   @ApiModelProperty(name = "boolProcess", value = "是否有工序 true是 false否")
   @JsonProperty("boolProcess")
   @JSONField(name = "boolProcess")
   @TableField("bool_process")
   @Column(name = "bool_process", nullable = false, columnDefinition = "tinyint(1) default 0 comment '是否有工序 1是 0否'")
   private Boolean boolProcess;
   @ApiModelProperty(name = "boolHaveHole", value = "是否有孔 true 有孔 false 无孔")
   @TableField("bool_have_hole")
   @Column(name = "bool_have_hole", nullable = false, columnDefinition = "tinyint(1) default 0 comment '是否有孔 1有 0无'")
   private Boolean boolHaveHole;
   @ApiModelProperty(name = "holeNumber", value = "孔的数量")
   @TableField("hole_number")
   @Column(name = "hole_number", columnDefinition = "bigint(20)  default 0 COMMENT '孔的数量'", nullable = false)
   private Long holeNumber;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @TableField("production_line_type_enum")
   @Column(name = "production_line_type_enum", columnDefinition = "int(11) default 1 COMMENT '生产线类型 1传统线 2智能线'", nullable = false)
   private Integer productionLineTypeEnum;
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
   @ApiModelProperty(name = "businessId", value = "商务直发零件表ID")
   @TableField("business_id")
   @Column(name = "business_id", columnDefinition = "bigint(20) DEFAULT NULL COMMENT '商务直发零件表ID'")
   private Long businessId;
   @ApiModelProperty("零件分类 4.成品型材 8.钢板")
   @TableField("product_classification_enum")
   @Column(name = "product_classification_enum", columnDefinition = "int(11) comment '零件类型 4.成品型材 8.钢板'", nullable = false)
   private Integer productClassificationEnum;
   @ApiModelProperty(name = "steelPlateTypeEnum", value = "零件类型 1.零件板 2.翼腹板 4成品型材 ")
   @JsonProperty("steelPlateTypeEnum")
   @JSONField(name = "steelPlateTypeEnum")
   @TableField("steel_plate_type_enum")
   @Column(name = "steel_plate_type_enum", columnDefinition = "int(11) COMMENT '零件类型 1.零件板 2.翼腹板 4成品型材'")
   private Integer steelPlateTypeEnum;
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
   @Transient
   @ApiModelProperty(name = "boolMainAssemble", value = "是否主部件 true是 false否")
   @TableField(value = "bool_main_assemble", exist = false)
   private Boolean boolMainAssemble;
   @Transient
   @ApiModelProperty(name = "boolHaveNC1", value = "是否导入NC1文件 ture有 false无")
   @TableField(value = "bool_have_nc1", exist = false)
   private Boolean boolHaveNC1;
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

   public static TechMachinePart.TechMachinePartBuilder builder() {
      return new TechMachinePart.TechMachinePartBuilder();
   }

   public TechMachinePart() {
   }

   public TechMachinePart(
      final Long id,
      final String name,
      final Long projectId,
      final Long monomerId,
      final Long areaBatchId,
      final Long areaId,
      final Boolean boolStatusEnum,
      final Integer relationType,
      final String structureType,
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
      final Integer type,
      final String remark,
      final Long userId,
      final Integer usedQuantity,
      final Integer producedQuantity,
      final Integer useCompleteQuantity,
      final String drawingNumber,
      final String thick,
      final String width,
      final String path,
      final String ossRelativePath,
      final Integer nestingState,
      final Long steelId,
      final String steelSpec,
      final Integer areaType,
      final Boolean boolAbnormalEnum,
      final Boolean boolSchedulingEnum,
      final Boolean boolNestEnum,
      final String specPrefix,
      final Boolean boolSectionSteel,
      final Boolean boolProcess,
      final Boolean boolHaveHole,
      final Long holeNumber,
      final Integer productionLineTypeEnum,
      final Boolean boolSendDirectly,
      final Boolean boolSinglePartEnum,
      final Boolean boolAllPartSendDirectly,
      final Long businessId,
      final Integer productClassificationEnum,
      final Integer steelPlateTypeEnum,
      final BigDecimal topPaintArea,
      final BigDecimal innerPaintArea,
      final BigDecimal outerPaintArea,
      final BigDecimal uRibPaintArea,
      final Boolean boolMainAssemble,
      final Boolean boolHaveNC1,
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
      this.boolStatusEnum = boolStatusEnum;
      this.relationType = relationType;
      this.structureType = structureType;
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
      this.type = type;
      this.remark = remark;
      this.userId = userId;
      this.usedQuantity = usedQuantity;
      this.producedQuantity = producedQuantity;
      this.useCompleteQuantity = useCompleteQuantity;
      this.drawingNumber = drawingNumber;
      this.thick = thick;
      this.width = width;
      this.path = path;
      this.ossRelativePath = ossRelativePath;
      this.nestingState = nestingState;
      this.steelId = steelId;
      this.steelSpec = steelSpec;
      this.areaType = areaType;
      this.boolAbnormalEnum = boolAbnormalEnum;
      this.boolSchedulingEnum = boolSchedulingEnum;
      this.boolNestEnum = boolNestEnum;
      this.specPrefix = specPrefix;
      this.boolSectionSteel = boolSectionSteel;
      this.boolProcess = boolProcess;
      this.boolHaveHole = boolHaveHole;
      this.holeNumber = holeNumber;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.boolSendDirectly = boolSendDirectly;
      this.boolSinglePartEnum = boolSinglePartEnum;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      this.businessId = businessId;
      this.productClassificationEnum = productClassificationEnum;
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      this.topPaintArea = topPaintArea;
      this.innerPaintArea = innerPaintArea;
      this.outerPaintArea = outerPaintArea;
      this.uRibPaintArea = uRibPaintArea;
      this.boolMainAssemble = boolMainAssemble;
      this.boolHaveNC1 = boolHaveNC1;
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

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public String getStructureType() {
      return this.structureType;
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

   public Integer getType() {
      return this.type;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getUsedQuantity() {
      return this.usedQuantity;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getUseCompleteQuantity() {
      return this.useCompleteQuantity;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public String getThick() {
      return this.thick;
   }

   public String getWidth() {
      return this.width;
   }

   public String getPath() {
      return this.path;
   }

   public String getOssRelativePath() {
      return this.ossRelativePath;
   }

   public Integer getNestingState() {
      return this.nestingState;
   }

   public Long getSteelId() {
      return this.steelId;
   }

   public String getSteelSpec() {
      return this.steelSpec;
   }

   public Integer getAreaType() {
      return this.areaType;
   }

   public Boolean getBoolAbnormalEnum() {
      return this.boolAbnormalEnum;
   }

   public Boolean getBoolSchedulingEnum() {
      return this.boolSchedulingEnum;
   }

   public Boolean getBoolNestEnum() {
      return this.boolNestEnum;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Boolean getBoolSectionSteel() {
      return this.boolSectionSteel;
   }

   public Boolean getBoolProcess() {
      return this.boolProcess;
   }

   public Boolean getBoolHaveHole() {
      return this.boolHaveHole;
   }

   public Long getHoleNumber() {
      return this.holeNumber;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
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

   public Long getBusinessId() {
      return this.businessId;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public Integer getSteelPlateTypeEnum() {
      return this.steelPlateTypeEnum;
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

   public Boolean getBoolMainAssemble() {
      return this.boolMainAssemble;
   }

   public Boolean getBoolHaveNC1() {
      return this.boolHaveNC1;
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
   public TechMachinePart setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public TechMachinePart setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("projectId")
   public TechMachinePart setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public TechMachinePart setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public TechMachinePart setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("areaId")
   public TechMachinePart setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("boolStatusEnum")
   public TechMachinePart setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
      return this;
   }

   @JsonProperty("relationType")
   public TechMachinePart setRelationType(final Integer relationType) {
      this.relationType = relationType;
      return this;
   }

   public TechMachinePart setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   @JsonProperty("serialNumber")
   public TechMachinePart setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public TechMachinePart setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public TechMachinePart setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public TechMachinePart setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public TechMachinePart setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public TechMachinePart setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public TechMachinePart setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public TechMachinePart setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public TechMachinePart setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   public TechMachinePart setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("type")
   public TechMachinePart setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("remark")
   public TechMachinePart setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("userId")
   public TechMachinePart setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("usedQuantity")
   public TechMachinePart setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
      return this;
   }

   @JsonProperty("producedQuantity")
   public TechMachinePart setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("useCompleteQuantity")
   public TechMachinePart setUseCompleteQuantity(final Integer useCompleteQuantity) {
      this.useCompleteQuantity = useCompleteQuantity;
      return this;
   }

   @JsonProperty("drawingNumber")
   public TechMachinePart setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
      return this;
   }

   @JsonProperty("thick")
   public TechMachinePart setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("width")
   public TechMachinePart setWidth(final String width) {
      this.width = width;
      return this;
   }

   @JsonProperty("path")
   public TechMachinePart setPath(final String path) {
      this.path = path;
      return this;
   }

   public TechMachinePart setOssRelativePath(final String ossRelativePath) {
      this.ossRelativePath = ossRelativePath;
      return this;
   }

   @JsonProperty("nestingState")
   public TechMachinePart setNestingState(final Integer nestingState) {
      this.nestingState = nestingState;
      return this;
   }

   public TechMachinePart setSteelId(final Long steelId) {
      this.steelId = steelId;
      return this;
   }

   public TechMachinePart setSteelSpec(final String steelSpec) {
      this.steelSpec = steelSpec;
      return this;
   }

   @JsonProperty("areaType")
   public TechMachinePart setAreaType(final Integer areaType) {
      this.areaType = areaType;
      return this;
   }

   @JsonProperty("boolAbnormalEnum")
   public TechMachinePart setBoolAbnormalEnum(final Boolean boolAbnormalEnum) {
      this.boolAbnormalEnum = boolAbnormalEnum;
      return this;
   }

   @JsonProperty("boolSchedulingEnum")
   public TechMachinePart setBoolSchedulingEnum(final Boolean boolSchedulingEnum) {
      this.boolSchedulingEnum = boolSchedulingEnum;
      return this;
   }

   public TechMachinePart setBoolNestEnum(final Boolean boolNestEnum) {
      this.boolNestEnum = boolNestEnum;
      return this;
   }

   public TechMachinePart setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
      return this;
   }

   public TechMachinePart setBoolSectionSteel(final Boolean boolSectionSteel) {
      this.boolSectionSteel = boolSectionSteel;
      return this;
   }

   @JsonProperty("boolProcess")
   public TechMachinePart setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
      return this;
   }

   public TechMachinePart setBoolHaveHole(final Boolean boolHaveHole) {
      this.boolHaveHole = boolHaveHole;
      return this;
   }

   public TechMachinePart setHoleNumber(final Long holeNumber) {
      this.holeNumber = holeNumber;
      return this;
   }

   public TechMachinePart setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   public TechMachinePart setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
      return this;
   }

   public TechMachinePart setBoolSinglePartEnum(final Boolean boolSinglePartEnum) {
      this.boolSinglePartEnum = boolSinglePartEnum;
      return this;
   }

   public TechMachinePart setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      return this;
   }

   public TechMachinePart setBusinessId(final Long businessId) {
      this.businessId = businessId;
      return this;
   }

   public TechMachinePart setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
      return this;
   }

   @JsonProperty("steelPlateTypeEnum")
   public TechMachinePart setSteelPlateTypeEnum(final Integer steelPlateTypeEnum) {
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      return this;
   }

   public TechMachinePart setTopPaintArea(final BigDecimal topPaintArea) {
      this.topPaintArea = topPaintArea;
      return this;
   }

   public TechMachinePart setInnerPaintArea(final BigDecimal innerPaintArea) {
      this.innerPaintArea = innerPaintArea;
      return this;
   }

   public TechMachinePart setOuterPaintArea(final BigDecimal outerPaintArea) {
      this.outerPaintArea = outerPaintArea;
      return this;
   }

   public TechMachinePart setURibPaintArea(final BigDecimal uRibPaintArea) {
      this.uRibPaintArea = uRibPaintArea;
      return this;
   }

   public TechMachinePart setBoolMainAssemble(final Boolean boolMainAssemble) {
      this.boolMainAssemble = boolMainAssemble;
      return this;
   }

   public TechMachinePart setBoolHaveNC1(final Boolean boolHaveNC1) {
      this.boolHaveNC1 = boolHaveNC1;
      return this;
   }

   @JsonProperty("initialSerialNumber")
   public TechMachinePart setInitialSerialNumber(final String initialSerialNumber) {
      this.initialSerialNumber = initialSerialNumber;
      return this;
   }

   public TechMachinePart setBoolItsOwnDrawing(final Boolean boolItsOwnDrawing) {
      this.boolItsOwnDrawing = boolItsOwnDrawing;
      return this;
   }

   public TechMachinePart setSourcePartEnum(final Integer sourcePartEnum) {
      this.sourcePartEnum = sourcePartEnum;
      return this;
   }

   @JsonProperty("topFlangeArea")
   public TechMachinePart setTopFlangeArea(final BigDecimal topFlangeArea) {
      this.topFlangeArea = topFlangeArea;
      return this;
   }

   @Override
   public String toString() {
      return "TechMachinePart(id="
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
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", relationType="
         + this.getRelationType()
         + ", structureType="
         + this.getStructureType()
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
         + ", type="
         + this.getType()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", useCompleteQuantity="
         + this.getUseCompleteQuantity()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", thick="
         + this.getThick()
         + ", width="
         + this.getWidth()
         + ", path="
         + this.getPath()
         + ", ossRelativePath="
         + this.getOssRelativePath()
         + ", nestingState="
         + this.getNestingState()
         + ", steelId="
         + this.getSteelId()
         + ", steelSpec="
         + this.getSteelSpec()
         + ", areaType="
         + this.getAreaType()
         + ", boolAbnormalEnum="
         + this.getBoolAbnormalEnum()
         + ", boolSchedulingEnum="
         + this.getBoolSchedulingEnum()
         + ", boolNestEnum="
         + this.getBoolNestEnum()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", boolSectionSteel="
         + this.getBoolSectionSteel()
         + ", boolProcess="
         + this.getBoolProcess()
         + ", boolHaveHole="
         + this.getBoolHaveHole()
         + ", holeNumber="
         + this.getHoleNumber()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", boolSinglePartEnum="
         + this.getBoolSinglePartEnum()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", businessId="
         + this.getBusinessId()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", steelPlateTypeEnum="
         + this.getSteelPlateTypeEnum()
         + ", topPaintArea="
         + this.getTopPaintArea()
         + ", innerPaintArea="
         + this.getInnerPaintArea()
         + ", outerPaintArea="
         + this.getOuterPaintArea()
         + ", uRibPaintArea="
         + this.getURibPaintArea()
         + ", boolMainAssemble="
         + this.getBoolMainAssemble()
         + ", boolHaveNC1="
         + this.getBoolHaveNC1()
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

      if (!(o instanceof TechMachinePart)) {
         return false;
      }

      TechMachinePart other = (TechMachinePart)o;
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
                     Object this$boolStatusEnum = this.getBoolStatusEnum();
                     Object other$boolStatusEnum = other.getBoolStatusEnum();
                     if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
                        Object this$relationType = this.getRelationType();
                        Object other$relationType = other.getRelationType();
                        if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$type = this.getType();
                              Object other$type = other.getType();
                              if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                 Object this$userId = this.getUserId();
                                 Object other$userId = other.getUserId();
                                 if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                    Object this$usedQuantity = this.getUsedQuantity();
                                    Object other$usedQuantity = other.getUsedQuantity();
                                    if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                                       Object this$producedQuantity = this.getProducedQuantity();
                                       Object other$producedQuantity = other.getProducedQuantity();
                                       if (this$producedQuantity == null
                                          ? other$producedQuantity == null
                                          : this$producedQuantity.equals(other$producedQuantity)) {
                                          Object this$useCompleteQuantity = this.getUseCompleteQuantity();
                                          Object other$useCompleteQuantity = other.getUseCompleteQuantity();
                                          if (this$useCompleteQuantity == null
                                             ? other$useCompleteQuantity == null
                                             : this$useCompleteQuantity.equals(other$useCompleteQuantity)) {
                                             Object this$nestingState = this.getNestingState();
                                             Object other$nestingState = other.getNestingState();
                                             if (this$nestingState == null ? other$nestingState == null : this$nestingState.equals(other$nestingState)) {
                                                Object this$steelId = this.getSteelId();
                                                Object other$steelId = other.getSteelId();
                                                if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
                                                   Object this$areaType = this.getAreaType();
                                                   Object other$areaType = other.getAreaType();
                                                   if (this$areaType == null ? other$areaType == null : this$areaType.equals(other$areaType)) {
                                                      Object this$boolAbnormalEnum = this.getBoolAbnormalEnum();
                                                      Object other$boolAbnormalEnum = other.getBoolAbnormalEnum();
                                                      if (this$boolAbnormalEnum == null
                                                         ? other$boolAbnormalEnum == null
                                                         : this$boolAbnormalEnum.equals(other$boolAbnormalEnum)) {
                                                         Object this$boolSchedulingEnum = this.getBoolSchedulingEnum();
                                                         Object other$boolSchedulingEnum = other.getBoolSchedulingEnum();
                                                         if (this$boolSchedulingEnum == null
                                                            ? other$boolSchedulingEnum == null
                                                            : this$boolSchedulingEnum.equals(other$boolSchedulingEnum)) {
                                                            Object this$boolNestEnum = this.getBoolNestEnum();
                                                            Object other$boolNestEnum = other.getBoolNestEnum();
                                                            if (this$boolNestEnum == null
                                                               ? other$boolNestEnum == null
                                                               : this$boolNestEnum.equals(other$boolNestEnum)) {
                                                               Object this$boolSectionSteel = this.getBoolSectionSteel();
                                                               Object other$boolSectionSteel = other.getBoolSectionSteel();
                                                               if (this$boolSectionSteel == null
                                                                  ? other$boolSectionSteel == null
                                                                  : this$boolSectionSteel.equals(other$boolSectionSteel)) {
                                                                  Object this$boolProcess = this.getBoolProcess();
                                                                  Object other$boolProcess = other.getBoolProcess();
                                                                  if (this$boolProcess == null
                                                                     ? other$boolProcess == null
                                                                     : this$boolProcess.equals(other$boolProcess)) {
                                                                     Object this$boolHaveHole = this.getBoolHaveHole();
                                                                     Object other$boolHaveHole = other.getBoolHaveHole();
                                                                     if (this$boolHaveHole == null
                                                                        ? other$boolHaveHole == null
                                                                        : this$boolHaveHole.equals(other$boolHaveHole)) {
                                                                        Object this$holeNumber = this.getHoleNumber();
                                                                        Object other$holeNumber = other.getHoleNumber();
                                                                        if (this$holeNumber == null
                                                                           ? other$holeNumber == null
                                                                           : this$holeNumber.equals(other$holeNumber)) {
                                                                           Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                                                                           Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                                                                           if (this$productionLineTypeEnum == null
                                                                              ? other$productionLineTypeEnum == null
                                                                              : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
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
                                                                                       Object this$businessId = this.getBusinessId();
                                                                                       Object other$businessId = other.getBusinessId();
                                                                                       if (this$businessId == null
                                                                                          ? other$businessId == null
                                                                                          : this$businessId.equals(other$businessId)) {
                                                                                          Object this$productClassificationEnum = this.getProductClassificationEnum();
                                                                                          Object other$productClassificationEnum = other.getProductClassificationEnum();
                                                                                          if (this$productClassificationEnum == null
                                                                                             ? other$productClassificationEnum == null
                                                                                             : this$productClassificationEnum.equals(
                                                                                                other$productClassificationEnum
                                                                                             )) {
                                                                                             Object this$steelPlateTypeEnum = this.getSteelPlateTypeEnum();
                                                                                             Object other$steelPlateTypeEnum = other.getSteelPlateTypeEnum();
                                                                                             if (this$steelPlateTypeEnum == null
                                                                                                ? other$steelPlateTypeEnum == null
                                                                                                : this$steelPlateTypeEnum.equals(other$steelPlateTypeEnum)) {
                                                                                                Object this$boolMainAssemble = this.getBoolMainAssemble();
                                                                                                Object other$boolMainAssemble = other.getBoolMainAssemble();
                                                                                                if (this$boolMainAssemble == null
                                                                                                   ? other$boolMainAssemble == null
                                                                                                   : this$boolMainAssemble.equals(other$boolMainAssemble)) {
                                                                                                   Object this$boolHaveNC1 = this.getBoolHaveNC1();
                                                                                                   Object other$boolHaveNC1 = other.getBoolHaveNC1();
                                                                                                   if (this$boolHaveNC1 == null
                                                                                                      ? other$boolHaveNC1 == null
                                                                                                      : this$boolHaveNC1.equals(other$boolHaveNC1)) {
                                                                                                      Object this$boolItsOwnDrawing = this.getBoolItsOwnDrawing();
                                                                                                      Object other$boolItsOwnDrawing = other.getBoolItsOwnDrawing();
                                                                                                      if (this$boolItsOwnDrawing == null
                                                                                                         ? other$boolItsOwnDrawing == null
                                                                                                         : this$boolItsOwnDrawing.equals(
                                                                                                            other$boolItsOwnDrawing
                                                                                                         )) {
                                                                                                         Object this$sourcePartEnum = this.getSourcePartEnum();
                                                                                                         Object other$sourcePartEnum = other.getSourcePartEnum();
                                                                                                         if (this$sourcePartEnum == null
                                                                                                            ? other$sourcePartEnum == null
                                                                                                            : this$sourcePartEnum.equals(other$sourcePartEnum)) {
                                                                                                            Object this$name = this.getName();
                                                                                                            Object other$name = other.getName();
                                                                                                            if (this$name == null
                                                                                                               ? other$name == null
                                                                                                               : this$name.equals(other$name)) {
                                                                                                               Object this$structureType = this.getStructureType();
                                                                                                               Object other$structureType = other.getStructureType();
                                                                                                               if (this$structureType == null
                                                                                                                  ? other$structureType == null
                                                                                                                  : this$structureType.equals(
                                                                                                                     other$structureType
                                                                                                                  )) {
                                                                                                                  Object this$serialNumber = this.getSerialNumber();
                                                                                                                  Object other$serialNumber = other.getSerialNumber();
                                                                                                                  if (this$serialNumber == null
                                                                                                                     ? other$serialNumber == null
                                                                                                                     : this$serialNumber.equals(
                                                                                                                        other$serialNumber
                                                                                                                     )) {
                                                                                                                     Object this$specification = this.getSpecification();
                                                                                                                     Object other$specification = other.getSpecification();
                                                                                                                     if (this$specification == null
                                                                                                                        ? other$specification == null
                                                                                                                        : this$specification.equals(
                                                                                                                           other$specification
                                                                                                                        )) {
                                                                                                                        Object this$length = this.getLength();
                                                                                                                        Object other$length = other.getLength();
                                                                                                                        if (this$length == null
                                                                                                                           ? other$length == null
                                                                                                                           : this$length.equals(other$length)) {
                                                                                                                           Object this$material = this.getMaterial();
                                                                                                                           Object other$material = other.getMaterial();
                                                                                                                           if (this$material == null
                                                                                                                              ? other$material == null
                                                                                                                              : this$material.equals(
                                                                                                                                 other$material
                                                                                                                              )) {
                                                                                                                              Object this$netWeight = this.getNetWeight();
                                                                                                                              Object other$netWeight = other.getNetWeight();
                                                                                                                              if (this$netWeight == null
                                                                                                                                 ? other$netWeight == null
                                                                                                                                 : this$netWeight.equals(
                                                                                                                                    other$netWeight
                                                                                                                                 )) {
                                                                                                                                 Object this$totalNetWeight = this.getTotalNetWeight();
                                                                                                                                 Object other$totalNetWeight = other.getTotalNetWeight();
                                                                                                                                 if (this$totalNetWeight
                                                                                                                                       == null
                                                                                                                                    ? other$totalNetWeight
                                                                                                                                       == null
                                                                                                                                    : this$totalNetWeight.equals(
                                                                                                                                       other$totalNetWeight
                                                                                                                                    )) {
                                                                                                                                    Object this$grossWeight = this.getGrossWeight();
                                                                                                                                    Object other$grossWeight = other.getGrossWeight();
                                                                                                                                    if (this$grossWeight
                                                                                                                                          == null
                                                                                                                                       ? other$grossWeight
                                                                                                                                          == null
                                                                                                                                       : this$grossWeight.equals(
                                                                                                                                          other$grossWeight
                                                                                                                                       )) {
                                                                                                                                       Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                                                                                                       Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                                                                                                       if (this$totalGrossWeight
                                                                                                                                             == null
                                                                                                                                          ? other$totalGrossWeight
                                                                                                                                             == null
                                                                                                                                          : this$totalGrossWeight.equals(
                                                                                                                                             other$totalGrossWeight
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
                                                                                                                                             Object this$remark = this.getRemark();
                                                                                                                                             Object other$remark = other.getRemark();
                                                                                                                                             if (this$remark
                                                                                                                                                   == null
                                                                                                                                                ? other$remark
                                                                                                                                                   == null
                                                                                                                                                : this$remark.equals(
                                                                                                                                                   other$remark
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
                                                                                                                                                   Object this$thick = this.getThick();
                                                                                                                                                   Object other$thick = other.getThick();
                                                                                                                                                   if (this$thick
                                                                                                                                                         == null
                                                                                                                                                      ? other$thick
                                                                                                                                                         == null
                                                                                                                                                      : this$thick.equals(
                                                                                                                                                         other$thick
                                                                                                                                                      )) {
                                                                                                                                                      Object this$width = this.getWidth();
                                                                                                                                                      Object other$width = other.getWidth();
                                                                                                                                                      if (this$width
                                                                                                                                                            == null
                                                                                                                                                         ? other$width
                                                                                                                                                            == null
                                                                                                                                                         : this$width.equals(
                                                                                                                                                            other$width
                                                                                                                                                         )) {
                                                                                                                                                         Object this$path = this.getPath();
                                                                                                                                                         Object other$path = other.getPath();
                                                                                                                                                         if (this$path
                                                                                                                                                               == null
                                                                                                                                                            ? other$path
                                                                                                                                                               == null
                                                                                                                                                            : this$path.equals(
                                                                                                                                                               other$path
                                                                                                                                                            )) {
                                                                                                                                                            Object this$ossRelativePath = this.getOssRelativePath();
                                                                                                                                                            Object other$ossRelativePath = other.getOssRelativePath();
                                                                                                                                                            if (this$ossRelativePath
                                                                                                                                                                  == null
                                                                                                                                                               ? other$ossRelativePath
                                                                                                                                                                  == null
                                                                                                                                                               : this$ossRelativePath.equals(
                                                                                                                                                                  other$ossRelativePath
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$steelSpec = this.getSteelSpec();
                                                                                                                                                               Object other$steelSpec = other.getSteelSpec();
                                                                                                                                                               if (this$steelSpec
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$steelSpec
                                                                                                                                                                     == null
                                                                                                                                                                  : this$steelSpec.equals(
                                                                                                                                                                     other$steelSpec
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$specPrefix = this.getSpecPrefix();
                                                                                                                                                                  Object other$specPrefix = other.getSpecPrefix();
                                                                                                                                                                  if (this$specPrefix
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$specPrefix
                                                                                                                                                                        == null
                                                                                                                                                                     : this$specPrefix.equals(
                                                                                                                                                                        other$specPrefix
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
                                                                                                                                                                                 Object this$initialSerialNumber = this.getInitialSerialNumber();
                                                                                                                                                                                 Object other$initialSerialNumber = other.getInitialSerialNumber();
                                                                                                                                                                                 if (this$initialSerialNumber
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$initialSerialNumber
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$initialSerialNumber.equals(
                                                                                                                                                                                       other$initialSerialNumber
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
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
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof TechMachinePart;
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
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $useCompleteQuantity = this.getUseCompleteQuantity();
      result = result * 59 + ($useCompleteQuantity == null ? 43 : $useCompleteQuantity.hashCode());
      Object $nestingState = this.getNestingState();
      result = result * 59 + ($nestingState == null ? 43 : $nestingState.hashCode());
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $areaType = this.getAreaType();
      result = result * 59 + ($areaType == null ? 43 : $areaType.hashCode());
      Object $boolAbnormalEnum = this.getBoolAbnormalEnum();
      result = result * 59 + ($boolAbnormalEnum == null ? 43 : $boolAbnormalEnum.hashCode());
      Object $boolSchedulingEnum = this.getBoolSchedulingEnum();
      result = result * 59 + ($boolSchedulingEnum == null ? 43 : $boolSchedulingEnum.hashCode());
      Object $boolNestEnum = this.getBoolNestEnum();
      result = result * 59 + ($boolNestEnum == null ? 43 : $boolNestEnum.hashCode());
      Object $boolSectionSteel = this.getBoolSectionSteel();
      result = result * 59 + ($boolSectionSteel == null ? 43 : $boolSectionSteel.hashCode());
      Object $boolProcess = this.getBoolProcess();
      result = result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
      Object $boolHaveHole = this.getBoolHaveHole();
      result = result * 59 + ($boolHaveHole == null ? 43 : $boolHaveHole.hashCode());
      Object $holeNumber = this.getHoleNumber();
      result = result * 59 + ($holeNumber == null ? 43 : $holeNumber.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $boolSinglePartEnum = this.getBoolSinglePartEnum();
      result = result * 59 + ($boolSinglePartEnum == null ? 43 : $boolSinglePartEnum.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $steelPlateTypeEnum = this.getSteelPlateTypeEnum();
      result = result * 59 + ($steelPlateTypeEnum == null ? 43 : $steelPlateTypeEnum.hashCode());
      Object $boolMainAssemble = this.getBoolMainAssemble();
      result = result * 59 + ($boolMainAssemble == null ? 43 : $boolMainAssemble.hashCode());
      Object $boolHaveNC1 = this.getBoolHaveNC1();
      result = result * 59 + ($boolHaveNC1 == null ? 43 : $boolHaveNC1.hashCode());
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
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $path = this.getPath();
      result = result * 59 + ($path == null ? 43 : $path.hashCode());
      Object $ossRelativePath = this.getOssRelativePath();
      result = result * 59 + ($ossRelativePath == null ? 43 : $ossRelativePath.hashCode());
      Object $steelSpec = this.getSteelSpec();
      result = result * 59 + ($steelSpec == null ? 43 : $steelSpec.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
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

   public static class TechMachinePartBuilder {
      private Long id;
      private String name;
      private Long projectId;
      private Long monomerId;
      private Long areaBatchId;
      private Long areaId;
      private Boolean boolStatusEnum;
      private Integer relationType;
      private String structureType;
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
      private Integer type;
      private String remark;
      private Long userId;
      private Integer usedQuantity;
      private Integer producedQuantity;
      private Integer useCompleteQuantity;
      private String drawingNumber;
      private String thick;
      private String width;
      private String path;
      private String ossRelativePath;
      private Integer nestingState;
      private Long steelId;
      private String steelSpec;
      private Integer areaType;
      private Boolean boolAbnormalEnum;
      private Boolean boolSchedulingEnum;
      private Boolean boolNestEnum;
      private String specPrefix;
      private Boolean boolSectionSteel;
      private Boolean boolProcess;
      private Boolean boolHaveHole;
      private Long holeNumber;
      private Integer productionLineTypeEnum;
      private Boolean boolSendDirectly;
      private Boolean boolSinglePartEnum;
      private Boolean boolAllPartSendDirectly;
      private Long businessId;
      private Integer productClassificationEnum;
      private Integer steelPlateTypeEnum;
      private BigDecimal topPaintArea;
      private BigDecimal innerPaintArea;
      private BigDecimal outerPaintArea;
      private BigDecimal uRibPaintArea;
      private Boolean boolMainAssemble;
      private Boolean boolHaveNC1;
      private String initialSerialNumber;
      private Boolean boolItsOwnDrawing;
      private Integer sourcePartEnum;
      private BigDecimal topFlangeArea;

      TechMachinePartBuilder() {
      }

      @JsonProperty("id")
      public TechMachinePart.TechMachinePartBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public TechMachinePart.TechMachinePartBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("projectId")
      public TechMachinePart.TechMachinePartBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public TechMachinePart.TechMachinePartBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public TechMachinePart.TechMachinePartBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("areaId")
      public TechMachinePart.TechMachinePartBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("boolStatusEnum")
      public TechMachinePart.TechMachinePartBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      @JsonProperty("relationType")
      public TechMachinePart.TechMachinePartBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      @JsonProperty("serialNumber")
      public TechMachinePart.TechMachinePartBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public TechMachinePart.TechMachinePartBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public TechMachinePart.TechMachinePartBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public TechMachinePart.TechMachinePartBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public TechMachinePart.TechMachinePartBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public TechMachinePart.TechMachinePartBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public TechMachinePart.TechMachinePartBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public TechMachinePart.TechMachinePartBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public TechMachinePart.TechMachinePartBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("type")
      public TechMachinePart.TechMachinePartBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("remark")
      public TechMachinePart.TechMachinePartBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("userId")
      public TechMachinePart.TechMachinePartBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("usedQuantity")
      public TechMachinePart.TechMachinePartBuilder usedQuantity(final Integer usedQuantity) {
         this.usedQuantity = usedQuantity;
         return this;
      }

      @JsonProperty("producedQuantity")
      public TechMachinePart.TechMachinePartBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("useCompleteQuantity")
      public TechMachinePart.TechMachinePartBuilder useCompleteQuantity(final Integer useCompleteQuantity) {
         this.useCompleteQuantity = useCompleteQuantity;
         return this;
      }

      @JsonProperty("drawingNumber")
      public TechMachinePart.TechMachinePartBuilder drawingNumber(final String drawingNumber) {
         this.drawingNumber = drawingNumber;
         return this;
      }

      @JsonProperty("thick")
      public TechMachinePart.TechMachinePartBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("width")
      public TechMachinePart.TechMachinePartBuilder width(final String width) {
         this.width = width;
         return this;
      }

      @JsonProperty("path")
      public TechMachinePart.TechMachinePartBuilder path(final String path) {
         this.path = path;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder ossRelativePath(final String ossRelativePath) {
         this.ossRelativePath = ossRelativePath;
         return this;
      }

      @JsonProperty("nestingState")
      public TechMachinePart.TechMachinePartBuilder nestingState(final Integer nestingState) {
         this.nestingState = nestingState;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder steelId(final Long steelId) {
         this.steelId = steelId;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder steelSpec(final String steelSpec) {
         this.steelSpec = steelSpec;
         return this;
      }

      @JsonProperty("areaType")
      public TechMachinePart.TechMachinePartBuilder areaType(final Integer areaType) {
         this.areaType = areaType;
         return this;
      }

      @JsonProperty("boolAbnormalEnum")
      public TechMachinePart.TechMachinePartBuilder boolAbnormalEnum(final Boolean boolAbnormalEnum) {
         this.boolAbnormalEnum = boolAbnormalEnum;
         return this;
      }

      @JsonProperty("boolSchedulingEnum")
      public TechMachinePart.TechMachinePartBuilder boolSchedulingEnum(final Boolean boolSchedulingEnum) {
         this.boolSchedulingEnum = boolSchedulingEnum;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder boolNestEnum(final Boolean boolNestEnum) {
         this.boolNestEnum = boolNestEnum;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder boolSectionSteel(final Boolean boolSectionSteel) {
         this.boolSectionSteel = boolSectionSteel;
         return this;
      }

      @JsonProperty("boolProcess")
      public TechMachinePart.TechMachinePartBuilder boolProcess(final Boolean boolProcess) {
         this.boolProcess = boolProcess;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder boolHaveHole(final Boolean boolHaveHole) {
         this.boolHaveHole = boolHaveHole;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder holeNumber(final Long holeNumber) {
         this.holeNumber = holeNumber;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder boolSendDirectly(final Boolean boolSendDirectly) {
         this.boolSendDirectly = boolSendDirectly;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder boolSinglePartEnum(final Boolean boolSinglePartEnum) {
         this.boolSinglePartEnum = boolSinglePartEnum;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder productClassificationEnum(final Integer productClassificationEnum) {
         this.productClassificationEnum = productClassificationEnum;
         return this;
      }

      @JsonProperty("steelPlateTypeEnum")
      public TechMachinePart.TechMachinePartBuilder steelPlateTypeEnum(final Integer steelPlateTypeEnum) {
         this.steelPlateTypeEnum = steelPlateTypeEnum;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder topPaintArea(final BigDecimal topPaintArea) {
         this.topPaintArea = topPaintArea;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder innerPaintArea(final BigDecimal innerPaintArea) {
         this.innerPaintArea = innerPaintArea;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder outerPaintArea(final BigDecimal outerPaintArea) {
         this.outerPaintArea = outerPaintArea;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder uRibPaintArea(final BigDecimal uRibPaintArea) {
         this.uRibPaintArea = uRibPaintArea;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder boolMainAssemble(final Boolean boolMainAssemble) {
         this.boolMainAssemble = boolMainAssemble;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder boolHaveNC1(final Boolean boolHaveNC1) {
         this.boolHaveNC1 = boolHaveNC1;
         return this;
      }

      @JsonProperty("initialSerialNumber")
      public TechMachinePart.TechMachinePartBuilder initialSerialNumber(final String initialSerialNumber) {
         this.initialSerialNumber = initialSerialNumber;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder boolItsOwnDrawing(final Boolean boolItsOwnDrawing) {
         this.boolItsOwnDrawing = boolItsOwnDrawing;
         return this;
      }

      public TechMachinePart.TechMachinePartBuilder sourcePartEnum(final Integer sourcePartEnum) {
         this.sourcePartEnum = sourcePartEnum;
         return this;
      }

      @JsonProperty("topFlangeArea")
      public TechMachinePart.TechMachinePartBuilder topFlangeArea(final BigDecimal topFlangeArea) {
         this.topFlangeArea = topFlangeArea;
         return this;
      }

      public TechMachinePart build() {
         return new TechMachinePart(
            this.id,
            this.name,
            this.projectId,
            this.monomerId,
            this.areaBatchId,
            this.areaId,
            this.boolStatusEnum,
            this.relationType,
            this.structureType,
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
            this.type,
            this.remark,
            this.userId,
            this.usedQuantity,
            this.producedQuantity,
            this.useCompleteQuantity,
            this.drawingNumber,
            this.thick,
            this.width,
            this.path,
            this.ossRelativePath,
            this.nestingState,
            this.steelId,
            this.steelSpec,
            this.areaType,
            this.boolAbnormalEnum,
            this.boolSchedulingEnum,
            this.boolNestEnum,
            this.specPrefix,
            this.boolSectionSteel,
            this.boolProcess,
            this.boolHaveHole,
            this.holeNumber,
            this.productionLineTypeEnum,
            this.boolSendDirectly,
            this.boolSinglePartEnum,
            this.boolAllPartSendDirectly,
            this.businessId,
            this.productClassificationEnum,
            this.steelPlateTypeEnum,
            this.topPaintArea,
            this.innerPaintArea,
            this.outerPaintArea,
            this.uRibPaintArea,
            this.boolMainAssemble,
            this.boolHaveNC1,
            this.initialSerialNumber,
            this.boolItsOwnDrawing,
            this.sourcePartEnum,
            this.topFlangeArea
         );
      }

      @Override
      public String toString() {
         return "TechMachinePart.TechMachinePartBuilder(id="
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
            + ", boolStatusEnum="
            + this.boolStatusEnum
            + ", relationType="
            + this.relationType
            + ", structureType="
            + this.structureType
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
            + ", type="
            + this.type
            + ", remark="
            + this.remark
            + ", userId="
            + this.userId
            + ", usedQuantity="
            + this.usedQuantity
            + ", producedQuantity="
            + this.producedQuantity
            + ", useCompleteQuantity="
            + this.useCompleteQuantity
            + ", drawingNumber="
            + this.drawingNumber
            + ", thick="
            + this.thick
            + ", width="
            + this.width
            + ", path="
            + this.path
            + ", ossRelativePath="
            + this.ossRelativePath
            + ", nestingState="
            + this.nestingState
            + ", steelId="
            + this.steelId
            + ", steelSpec="
            + this.steelSpec
            + ", areaType="
            + this.areaType
            + ", boolAbnormalEnum="
            + this.boolAbnormalEnum
            + ", boolSchedulingEnum="
            + this.boolSchedulingEnum
            + ", boolNestEnum="
            + this.boolNestEnum
            + ", specPrefix="
            + this.specPrefix
            + ", boolSectionSteel="
            + this.boolSectionSteel
            + ", boolProcess="
            + this.boolProcess
            + ", boolHaveHole="
            + this.boolHaveHole
            + ", holeNumber="
            + this.holeNumber
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", boolSendDirectly="
            + this.boolSendDirectly
            + ", boolSinglePartEnum="
            + this.boolSinglePartEnum
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ", businessId="
            + this.businessId
            + ", productClassificationEnum="
            + this.productClassificationEnum
            + ", steelPlateTypeEnum="
            + this.steelPlateTypeEnum
            + ", topPaintArea="
            + this.topPaintArea
            + ", innerPaintArea="
            + this.innerPaintArea
            + ", outerPaintArea="
            + this.outerPaintArea
            + ", uRibPaintArea="
            + this.uRibPaintArea
            + ", boolMainAssemble="
            + this.boolMainAssemble
            + ", boolHaveNC1="
            + this.boolHaveNC1
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
