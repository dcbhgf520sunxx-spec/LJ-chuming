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
import org.apache.commons.lang3.StringUtils;

@ApiModel(value = "TechAssemble对象", description = "组立信息 ")
@Entity
@TableName("tech_assemble")
@Table(
   name = "tech_assemble",
   indexes = {
         @Index(name = "monomer_id", columnList = "monomer_id"),
         @Index(name = "projectId_index", columnList = "project_id"),
         @Index(name = "area_id", columnList = "area_id")
   }
)
public class TechAssemble extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "areaId", value = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id")
   private Long areaId;
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
   @Column(name = "length")
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
   @Column(name = "net_weight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   @TableField("total_net_weight")
   @Column(name = "total_net_weight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "surfaceArea", value = "单面积（mm²）")
   @TableField("surface_area")
   @Column(name = "surface_area", columnDefinition = "decimal(32,8) default 0.0 comment '单面机(mm²)'", nullable = false)
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "producedQuantity", value = "已生产")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   @TableField("produced_quantity")
   @Column(name = "produced_quantity", columnDefinition = "int(11) default 0 comment '已生产数'", nullable = false)
   private Integer producedQuantity;
   @ApiModelProperty(name = "usedQuantity", value = "已使用")
   @JsonProperty("usedQuantity")
   @JSONField(name = "usedQuantity")
   @TableField("used_quantity")
   @Column(name = "used_quantity", columnDefinition = "int(11) default 0 comment '已使用数'", nullable = false)
   private Integer usedQuantity;
   @ApiModelProperty(name = "useCompleteQuantity", value = "二次利用默认生产完成数")
   @JsonProperty("useCompleteQuantity")
   @JSONField(name = "useCompleteQuantity")
   @TableField("use_complete_quantity")
   @Column(name = "use_complete_quantity", columnDefinition = "int(11) default 0 comment '二次利用默认生产完成数'", nullable = false)
   private Integer useCompleteQuantity;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "drawingNumber", value = "图号")
   @JsonProperty("drawingNumber")
   @JSONField(name = "drawingNumber")
   @TableField("drawing_number")
   @Column(name = "drawing_number")
   private String drawingNumber;
   @ApiModelProperty(name = "machinePartId", value = "部件对应零件表id")
   @JsonProperty("machinePartId")
   @JSONField(name = "machinePartId")
   @TableField("machine_part_id")
   @Column(name = "machine_part_id", columnDefinition = "bigint(20) comment '对应零件表id'")
   private Long machinePartId;
   @ApiModelProperty(name = "areaType", value = "区域制造类型 0自制 1外包")
   @JsonProperty("areaType")
   @JSONField(name = "areaType")
   @TableField("area_type")
   @Column(name = "area_type")
   private Integer areaType;
   @ApiModelProperty(name = "boolAbnormalEnum", value = "是否异常状态 0否(正常状态) 1是(异常状态)")
   @JsonProperty("boolAbnormalEnum")
   @JSONField(name = "boolAbnormalEnum")
   @TableField("bool_abnormal_enum")
   @Column(name = "bool_abnormal_enum", columnDefinition = "tinyint(1) default 0", nullable = false)
   private Boolean boolAbnormalEnum;
   @ApiModelProperty(name = "boolSchedulingEnum", value = "是否排产")
   @JsonProperty("boolSchedulingEnum")
   @JSONField(name = "boolSchedulingEnum")
   @TableField("bool_scheduling_enum")
   @Column(name = "bool_scheduling_enum", columnDefinition = "tinyint(1) default 1 COMMENT '是否排产'")
   private Boolean boolSchedulingEnum;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀")
   @JsonProperty("specPrefix")
   @JSONField(name = "specPrefix")
   @TableField("spec_prefix")
   @Column(name = "spec_prefix")
   private String specPrefix;
   @ApiModelProperty("部件配置表id")
   @TableField("assemble_config_id")
   @Column(name = "assemble_config_id", columnDefinition = "bigint(20) comment '部件配置表id'", nullable = false)
   private Long assembleConfigId;
   @ApiModelProperty(name = "boolSectionSteel", value = "是否成品型材 [false 否, true 是]", notes = "是否成品型材 [false 否, true 是]]")
   @TableField("bool_section_steel")
   @Column(name = "bool_section_steel", columnDefinition = "tinyint(1) default '0' COMMENT '是否成品型材 [0 否, 1 是]'", nullable = false)
   private Boolean boolSectionSteel;
   @ApiModelProperty(name = "boolProcess", value = "是否有工序 true是 false否")
   @JsonProperty("boolProcess")
   @JSONField(name = "boolProcess")
   @TableField("bool_process")
   @Column(name = "bool_process", nullable = false, columnDefinition = "tinyint(1) default 0 comment '1是 0否'")
   private Boolean boolProcess;
   @ApiModelProperty(name = "boolHaveNC1", value = "是否导入NC1文件 ture有 false无")
   @TableField("bool_have_nc1")
   @Column(name = "bool_have_nc1", nullable = false, columnDefinition = "tinyint(1) default 0 comment '是否导入NC1文件 1有 0无'")
   private Boolean boolHaveNC1;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @TableField("production_line_type_enum")
   @Column(name = "production_line_type_enum", columnDefinition = "int(11) default 1 COMMENT '生产线类型 1传统线 2智能线'", nullable = false)
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "userId", value = "导入人id")
   @JsonProperty("userId")
   @Column(name = "user_id", columnDefinition = "bigint(20) default 0 comment '导入人id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "nc1_length", value = "NC1长度（mm）")
   @TableField("nc1_length")
   @Column(name = "nc1_length", columnDefinition = "decimal(32,8)  default null  COMMENT '主部件解析的NC1长度'")
   private BigDecimal nc1Length;
   @ApiModelProperty(name = "boolMainAssemble", value = "是否主部件 true是 false否")
   @TableField("bool_main_assemble")
   @Column(name = "bool_main_assemble", columnDefinition = "tinyint(1) default 0 comment '是否主部件 1是 0否'", nullable = false)
   private Boolean boolMainAssemble;
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
   @ApiModelProperty(name = "grossWeight", value = "毛重（kg）")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   @TableField("gross_weight")
   @Column(name = "gross_weight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   @TableField("total_gross_weight")
   @Column(name = "total_gross_weight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "name", value = "部件名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(64)  COMMENT '名称'")
   private String name;
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 false暂停 true进行中")
   @JsonProperty("boolStatusEnum")
   @JSONField(name = "boolStatusEnum")
   @TableField("bool_status_enum")
   @Column(name = "bool_status_enum", columnDefinition = "tinyint(1) default 1 comment '状态 0暂停 1进行中'", nullable = false)
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "initialSerialNumber", value = "部件初始编号")
   @JsonProperty("initialSerialNumber")
   @JSONField(name = "initialSerialNumber")
   @TableField("initial_serial_number")
   @Column(name = "initial_serial_number")
   private String initialSerialNumber;
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

   public String getInitialSerialNumber() {
      return StringUtils.isBlank(this.initialSerialNumber) && StringUtils.isNotBlank(this.getSerialNumber())
         ? this.getSerialNumber().replaceFirst("组", "")
         : this.initialSerialNumber;
   }

   public static TechAssemble.TechAssembleBuilder builder() {
      return new TechAssemble.TechAssembleBuilder();
   }

   public TechAssemble() {
   }

   public TechAssemble(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaBatchId,
      final Long areaId,
      final String structureType,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal surfaceArea,
      final Integer producedQuantity,
      final Integer usedQuantity,
      final Integer useCompleteQuantity,
      final String remark,
      final String drawingNumber,
      final Long machinePartId,
      final Integer areaType,
      final Boolean boolAbnormalEnum,
      final Boolean boolSchedulingEnum,
      final String specPrefix,
      final Long assembleConfigId,
      final Boolean boolSectionSteel,
      final Boolean boolProcess,
      final Boolean boolHaveNC1,
      final Integer productionLineTypeEnum,
      final Long userId,
      final BigDecimal nc1Length,
      final Boolean boolMainAssemble,
      final Boolean boolSendDirectly,
      final Boolean boolSinglePartEnum,
      final Boolean boolAllPartSendDirectly,
      final Long businessId,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final String name,
      final Boolean boolStatusEnum,
      final String initialSerialNumber,
      final BigDecimal topPaintArea,
      final BigDecimal innerPaintArea,
      final BigDecimal outerPaintArea,
      final BigDecimal uRibPaintArea,
      final BigDecimal topFlangeArea
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaBatchId = areaBatchId;
      this.areaId = areaId;
      this.structureType = structureType;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.surfaceArea = surfaceArea;
      this.producedQuantity = producedQuantity;
      this.usedQuantity = usedQuantity;
      this.useCompleteQuantity = useCompleteQuantity;
      this.remark = remark;
      this.drawingNumber = drawingNumber;
      this.machinePartId = machinePartId;
      this.areaType = areaType;
      this.boolAbnormalEnum = boolAbnormalEnum;
      this.boolSchedulingEnum = boolSchedulingEnum;
      this.specPrefix = specPrefix;
      this.assembleConfigId = assembleConfigId;
      this.boolSectionSteel = boolSectionSteel;
      this.boolProcess = boolProcess;
      this.boolHaveNC1 = boolHaveNC1;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.userId = userId;
      this.nc1Length = nc1Length;
      this.boolMainAssemble = boolMainAssemble;
      this.boolSendDirectly = boolSendDirectly;
      this.boolSinglePartEnum = boolSinglePartEnum;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      this.businessId = businessId;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.name = name;
      this.boolStatusEnum = boolStatusEnum;
      this.initialSerialNumber = initialSerialNumber;
      this.topPaintArea = topPaintArea;
      this.innerPaintArea = innerPaintArea;
      this.outerPaintArea = outerPaintArea;
      this.uRibPaintArea = uRibPaintArea;
      this.topFlangeArea = topFlangeArea;
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

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getUsedQuantity() {
      return this.usedQuantity;
   }

   public Integer getUseCompleteQuantity() {
      return this.useCompleteQuantity;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public Long getMachinePartId() {
      return this.machinePartId;
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

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Long getAssembleConfigId() {
      return this.assembleConfigId;
   }

   public Boolean getBoolSectionSteel() {
      return this.boolSectionSteel;
   }

   public Boolean getBoolProcess() {
      return this.boolProcess;
   }

   public Boolean getBoolHaveNC1() {
      return this.boolHaveNC1;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Long getUserId() {
      return this.userId;
   }

   public BigDecimal getNc1Length() {
      return this.nc1Length;
   }

   public Boolean getBoolMainAssemble() {
      return this.boolMainAssemble;
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

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public String getName() {
      return this.name;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
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

   @JsonProperty("id")
   public TechAssemble setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public TechAssemble setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public TechAssemble setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public TechAssemble setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("areaId")
   public TechAssemble setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public TechAssemble setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   @JsonProperty("serialNumber")
   public TechAssemble setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public TechAssemble setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public TechAssemble setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public TechAssemble setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public TechAssemble setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public TechAssemble setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public TechAssemble setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   public TechAssemble setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("producedQuantity")
   public TechAssemble setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("usedQuantity")
   public TechAssemble setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
      return this;
   }

   @JsonProperty("useCompleteQuantity")
   public TechAssemble setUseCompleteQuantity(final Integer useCompleteQuantity) {
      this.useCompleteQuantity = useCompleteQuantity;
      return this;
   }

   @JsonProperty("remark")
   public TechAssemble setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("drawingNumber")
   public TechAssemble setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
      return this;
   }

   @JsonProperty("machinePartId")
   public TechAssemble setMachinePartId(final Long machinePartId) {
      this.machinePartId = machinePartId;
      return this;
   }

   @JsonProperty("areaType")
   public TechAssemble setAreaType(final Integer areaType) {
      this.areaType = areaType;
      return this;
   }

   @JsonProperty("boolAbnormalEnum")
   public TechAssemble setBoolAbnormalEnum(final Boolean boolAbnormalEnum) {
      this.boolAbnormalEnum = boolAbnormalEnum;
      return this;
   }

   @JsonProperty("boolSchedulingEnum")
   public TechAssemble setBoolSchedulingEnum(final Boolean boolSchedulingEnum) {
      this.boolSchedulingEnum = boolSchedulingEnum;
      return this;
   }

   @JsonProperty("specPrefix")
   public TechAssemble setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
      return this;
   }

   public TechAssemble setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
      return this;
   }

   public TechAssemble setBoolSectionSteel(final Boolean boolSectionSteel) {
      this.boolSectionSteel = boolSectionSteel;
      return this;
   }

   @JsonProperty("boolProcess")
   public TechAssemble setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
      return this;
   }

   public TechAssemble setBoolHaveNC1(final Boolean boolHaveNC1) {
      this.boolHaveNC1 = boolHaveNC1;
      return this;
   }

   public TechAssemble setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("userId")
   public TechAssemble setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public TechAssemble setNc1Length(final BigDecimal nc1Length) {
      this.nc1Length = nc1Length;
      return this;
   }

   public TechAssemble setBoolMainAssemble(final Boolean boolMainAssemble) {
      this.boolMainAssemble = boolMainAssemble;
      return this;
   }

   public TechAssemble setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
      return this;
   }

   public TechAssemble setBoolSinglePartEnum(final Boolean boolSinglePartEnum) {
      this.boolSinglePartEnum = boolSinglePartEnum;
      return this;
   }

   public TechAssemble setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      return this;
   }

   public TechAssemble setBusinessId(final Long businessId) {
      this.businessId = businessId;
      return this;
   }

   @JsonProperty("grossWeight")
   public TechAssemble setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public TechAssemble setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("name")
   public TechAssemble setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("boolStatusEnum")
   public TechAssemble setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
      return this;
   }

   @JsonProperty("initialSerialNumber")
   public TechAssemble setInitialSerialNumber(final String initialSerialNumber) {
      this.initialSerialNumber = initialSerialNumber;
      return this;
   }

   public TechAssemble setTopPaintArea(final BigDecimal topPaintArea) {
      this.topPaintArea = topPaintArea;
      return this;
   }

   public TechAssemble setInnerPaintArea(final BigDecimal innerPaintArea) {
      this.innerPaintArea = innerPaintArea;
      return this;
   }

   public TechAssemble setOuterPaintArea(final BigDecimal outerPaintArea) {
      this.outerPaintArea = outerPaintArea;
      return this;
   }

   public TechAssemble setURibPaintArea(final BigDecimal uRibPaintArea) {
      this.uRibPaintArea = uRibPaintArea;
      return this;
   }

   @JsonProperty("topFlangeArea")
   public TechAssemble setTopFlangeArea(final BigDecimal topFlangeArea) {
      this.topFlangeArea = topFlangeArea;
      return this;
   }

   @Override
   public String toString() {
      return "TechAssemble(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", areaId="
         + this.getAreaId()
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
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", useCompleteQuantity="
         + this.getUseCompleteQuantity()
         + ", remark="
         + this.getRemark()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", machinePartId="
         + this.getMachinePartId()
         + ", areaType="
         + this.getAreaType()
         + ", boolAbnormalEnum="
         + this.getBoolAbnormalEnum()
         + ", boolSchedulingEnum="
         + this.getBoolSchedulingEnum()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", assembleConfigId="
         + this.getAssembleConfigId()
         + ", boolSectionSteel="
         + this.getBoolSectionSteel()
         + ", boolProcess="
         + this.getBoolProcess()
         + ", boolHaveNC1="
         + this.getBoolHaveNC1()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", userId="
         + this.getUserId()
         + ", nc1Length="
         + this.getNc1Length()
         + ", boolMainAssemble="
         + this.getBoolMainAssemble()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", boolSinglePartEnum="
         + this.getBoolSinglePartEnum()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", businessId="
         + this.getBusinessId()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", name="
         + this.getName()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", initialSerialNumber="
         + this.getInitialSerialNumber()
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechAssemble)) {
         return false;
      }

      TechAssemble other = (TechAssemble)o;
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
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$producedQuantity = this.getProducedQuantity();
                        Object other$producedQuantity = other.getProducedQuantity();
                        if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                           Object this$usedQuantity = this.getUsedQuantity();
                           Object other$usedQuantity = other.getUsedQuantity();
                           if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                              Object this$useCompleteQuantity = this.getUseCompleteQuantity();
                              Object other$useCompleteQuantity = other.getUseCompleteQuantity();
                              if (this$useCompleteQuantity == null
                                 ? other$useCompleteQuantity == null
                                 : this$useCompleteQuantity.equals(other$useCompleteQuantity)) {
                                 Object this$machinePartId = this.getMachinePartId();
                                 Object other$machinePartId = other.getMachinePartId();
                                 if (this$machinePartId == null ? other$machinePartId == null : this$machinePartId.equals(other$machinePartId)) {
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
                                             Object this$assembleConfigId = this.getAssembleConfigId();
                                             Object other$assembleConfigId = other.getAssembleConfigId();
                                             if (this$assembleConfigId == null
                                                ? other$assembleConfigId == null
                                                : this$assembleConfigId.equals(other$assembleConfigId)) {
                                                Object this$boolSectionSteel = this.getBoolSectionSteel();
                                                Object other$boolSectionSteel = other.getBoolSectionSteel();
                                                if (this$boolSectionSteel == null
                                                   ? other$boolSectionSteel == null
                                                   : this$boolSectionSteel.equals(other$boolSectionSteel)) {
                                                   Object this$boolProcess = this.getBoolProcess();
                                                   Object other$boolProcess = other.getBoolProcess();
                                                   if (this$boolProcess == null ? other$boolProcess == null : this$boolProcess.equals(other$boolProcess)) {
                                                      Object this$boolHaveNC1 = this.getBoolHaveNC1();
                                                      Object other$boolHaveNC1 = other.getBoolHaveNC1();
                                                      if (this$boolHaveNC1 == null ? other$boolHaveNC1 == null : this$boolHaveNC1.equals(other$boolHaveNC1)) {
                                                         Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                                                         Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                                                         if (this$productionLineTypeEnum == null
                                                            ? other$productionLineTypeEnum == null
                                                            : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                                                            Object this$userId = this.getUserId();
                                                            Object other$userId = other.getUserId();
                                                            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                                               Object this$boolMainAssemble = this.getBoolMainAssemble();
                                                               Object other$boolMainAssemble = other.getBoolMainAssemble();
                                                               if (this$boolMainAssemble == null
                                                                  ? other$boolMainAssemble == null
                                                                  : this$boolMainAssemble.equals(other$boolMainAssemble)) {
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
                                                                              Object this$boolStatusEnum = this.getBoolStatusEnum();
                                                                              Object other$boolStatusEnum = other.getBoolStatusEnum();
                                                                              if (this$boolStatusEnum == null
                                                                                 ? other$boolStatusEnum == null
                                                                                 : this$boolStatusEnum.equals(other$boolStatusEnum)) {
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
                                                                                                            Object this$drawingNumber = this.getDrawingNumber();
                                                                                                            Object other$drawingNumber = other.getDrawingNumber();
                                                                                                            if (this$drawingNumber == null
                                                                                                               ? other$drawingNumber == null
                                                                                                               : this$drawingNumber.equals(other$drawingNumber)
                                                                                                               )
                                                                                                             {
                                                                                                               Object this$specPrefix = this.getSpecPrefix();
                                                                                                               Object other$specPrefix = other.getSpecPrefix();
                                                                                                               if (this$specPrefix == null
                                                                                                                  ? other$specPrefix == null
                                                                                                                  : this$specPrefix.equals(other$specPrefix)) {
                                                                                                                  Object this$nc1Length = this.getNc1Length();
                                                                                                                  Object other$nc1Length = other.getNc1Length();
                                                                                                                  if (this$nc1Length == null
                                                                                                                     ? other$nc1Length == null
                                                                                                                     : this$nc1Length.equals(other$nc1Length)) {
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
                                                                                                                           ? other$totalGrossWeight == null
                                                                                                                           : this$totalGrossWeight.equals(
                                                                                                                              other$totalGrossWeight
                                                                                                                           )) {
                                                                                                                           Object this$name = this.getName();
                                                                                                                           Object other$name = other.getName();
                                                                                                                           if (this$name == null
                                                                                                                              ? other$name == null
                                                                                                                              : this$name.equals(other$name)) {
                                                                                                                              Object this$initialSerialNumber = this.getInitialSerialNumber();
                                                                                                                              Object other$initialSerialNumber = other.getInitialSerialNumber();
                                                                                                                              if (this$initialSerialNumber
                                                                                                                                    == null
                                                                                                                                 ? other$initialSerialNumber
                                                                                                                                    == null
                                                                                                                                 : this$initialSerialNumber.equals(
                                                                                                                                    other$initialSerialNumber
                                                                                                                                 )) {
                                                                                                                                 Object this$topPaintArea = this.getTopPaintArea();
                                                                                                                                 Object other$topPaintArea = other.getTopPaintArea();
                                                                                                                                 if (this$topPaintArea == null
                                                                                                                                    ? other$topPaintArea
                                                                                                                                       == null
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechAssemble;
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
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $useCompleteQuantity = this.getUseCompleteQuantity();
      result = result * 59 + ($useCompleteQuantity == null ? 43 : $useCompleteQuantity.hashCode());
      Object $machinePartId = this.getMachinePartId();
      result = result * 59 + ($machinePartId == null ? 43 : $machinePartId.hashCode());
      Object $areaType = this.getAreaType();
      result = result * 59 + ($areaType == null ? 43 : $areaType.hashCode());
      Object $boolAbnormalEnum = this.getBoolAbnormalEnum();
      result = result * 59 + ($boolAbnormalEnum == null ? 43 : $boolAbnormalEnum.hashCode());
      Object $boolSchedulingEnum = this.getBoolSchedulingEnum();
      result = result * 59 + ($boolSchedulingEnum == null ? 43 : $boolSchedulingEnum.hashCode());
      Object $assembleConfigId = this.getAssembleConfigId();
      result = result * 59 + ($assembleConfigId == null ? 43 : $assembleConfigId.hashCode());
      Object $boolSectionSteel = this.getBoolSectionSteel();
      result = result * 59 + ($boolSectionSteel == null ? 43 : $boolSectionSteel.hashCode());
      Object $boolProcess = this.getBoolProcess();
      result = result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
      Object $boolHaveNC1 = this.getBoolHaveNC1();
      result = result * 59 + ($boolHaveNC1 == null ? 43 : $boolHaveNC1.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolMainAssemble = this.getBoolMainAssemble();
      result = result * 59 + ($boolMainAssemble == null ? 43 : $boolMainAssemble.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $boolSinglePartEnum = this.getBoolSinglePartEnum();
      result = result * 59 + ($boolSinglePartEnum == null ? 43 : $boolSinglePartEnum.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
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
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $nc1Length = this.getNc1Length();
      result = result * 59 + ($nc1Length == null ? 43 : $nc1Length.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $initialSerialNumber = this.getInitialSerialNumber();
      result = result * 59 + ($initialSerialNumber == null ? 43 : $initialSerialNumber.hashCode());
      Object $topPaintArea = this.getTopPaintArea();
      result = result * 59 + ($topPaintArea == null ? 43 : $topPaintArea.hashCode());
      Object $innerPaintArea = this.getInnerPaintArea();
      result = result * 59 + ($innerPaintArea == null ? 43 : $innerPaintArea.hashCode());
      Object $outerPaintArea = this.getOuterPaintArea();
      result = result * 59 + ($outerPaintArea == null ? 43 : $outerPaintArea.hashCode());
      Object $uRibPaintArea = this.getURibPaintArea();
      result = result * 59 + ($uRibPaintArea == null ? 43 : $uRibPaintArea.hashCode());
      Object $topFlangeArea = this.getTopFlangeArea();
      return result * 59 + ($topFlangeArea == null ? 43 : $topFlangeArea.hashCode());
   }

   public static class TechAssembleBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaBatchId;
      private Long areaId;
      private String structureType;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal surfaceArea;
      private Integer producedQuantity;
      private Integer usedQuantity;
      private Integer useCompleteQuantity;
      private String remark;
      private String drawingNumber;
      private Long machinePartId;
      private Integer areaType;
      private Boolean boolAbnormalEnum;
      private Boolean boolSchedulingEnum;
      private String specPrefix;
      private Long assembleConfigId;
      private Boolean boolSectionSteel;
      private Boolean boolProcess;
      private Boolean boolHaveNC1;
      private Integer productionLineTypeEnum;
      private Long userId;
      private BigDecimal nc1Length;
      private Boolean boolMainAssemble;
      private Boolean boolSendDirectly;
      private Boolean boolSinglePartEnum;
      private Boolean boolAllPartSendDirectly;
      private Long businessId;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private String name;
      private Boolean boolStatusEnum;
      private String initialSerialNumber;
      private BigDecimal topPaintArea;
      private BigDecimal innerPaintArea;
      private BigDecimal outerPaintArea;
      private BigDecimal uRibPaintArea;
      private BigDecimal topFlangeArea;

      TechAssembleBuilder() {
      }

      @JsonProperty("id")
      public TechAssemble.TechAssembleBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public TechAssemble.TechAssembleBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public TechAssemble.TechAssembleBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public TechAssemble.TechAssembleBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("areaId")
      public TechAssemble.TechAssembleBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechAssemble.TechAssembleBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      @JsonProperty("serialNumber")
      public TechAssemble.TechAssembleBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public TechAssemble.TechAssembleBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public TechAssemble.TechAssembleBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public TechAssemble.TechAssembleBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public TechAssemble.TechAssembleBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public TechAssemble.TechAssembleBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public TechAssemble.TechAssembleBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public TechAssemble.TechAssembleBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("producedQuantity")
      public TechAssemble.TechAssembleBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("usedQuantity")
      public TechAssemble.TechAssembleBuilder usedQuantity(final Integer usedQuantity) {
         this.usedQuantity = usedQuantity;
         return this;
      }

      @JsonProperty("useCompleteQuantity")
      public TechAssemble.TechAssembleBuilder useCompleteQuantity(final Integer useCompleteQuantity) {
         this.useCompleteQuantity = useCompleteQuantity;
         return this;
      }

      @JsonProperty("remark")
      public TechAssemble.TechAssembleBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("drawingNumber")
      public TechAssemble.TechAssembleBuilder drawingNumber(final String drawingNumber) {
         this.drawingNumber = drawingNumber;
         return this;
      }

      @JsonProperty("machinePartId")
      public TechAssemble.TechAssembleBuilder machinePartId(final Long machinePartId) {
         this.machinePartId = machinePartId;
         return this;
      }

      @JsonProperty("areaType")
      public TechAssemble.TechAssembleBuilder areaType(final Integer areaType) {
         this.areaType = areaType;
         return this;
      }

      @JsonProperty("boolAbnormalEnum")
      public TechAssemble.TechAssembleBuilder boolAbnormalEnum(final Boolean boolAbnormalEnum) {
         this.boolAbnormalEnum = boolAbnormalEnum;
         return this;
      }

      @JsonProperty("boolSchedulingEnum")
      public TechAssemble.TechAssembleBuilder boolSchedulingEnum(final Boolean boolSchedulingEnum) {
         this.boolSchedulingEnum = boolSchedulingEnum;
         return this;
      }

      @JsonProperty("specPrefix")
      public TechAssemble.TechAssembleBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public TechAssemble.TechAssembleBuilder assembleConfigId(final Long assembleConfigId) {
         this.assembleConfigId = assembleConfigId;
         return this;
      }

      public TechAssemble.TechAssembleBuilder boolSectionSteel(final Boolean boolSectionSteel) {
         this.boolSectionSteel = boolSectionSteel;
         return this;
      }

      @JsonProperty("boolProcess")
      public TechAssemble.TechAssembleBuilder boolProcess(final Boolean boolProcess) {
         this.boolProcess = boolProcess;
         return this;
      }

      public TechAssemble.TechAssembleBuilder boolHaveNC1(final Boolean boolHaveNC1) {
         this.boolHaveNC1 = boolHaveNC1;
         return this;
      }

      public TechAssemble.TechAssembleBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("userId")
      public TechAssemble.TechAssembleBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechAssemble.TechAssembleBuilder nc1Length(final BigDecimal nc1Length) {
         this.nc1Length = nc1Length;
         return this;
      }

      public TechAssemble.TechAssembleBuilder boolMainAssemble(final Boolean boolMainAssemble) {
         this.boolMainAssemble = boolMainAssemble;
         return this;
      }

      public TechAssemble.TechAssembleBuilder boolSendDirectly(final Boolean boolSendDirectly) {
         this.boolSendDirectly = boolSendDirectly;
         return this;
      }

      public TechAssemble.TechAssembleBuilder boolSinglePartEnum(final Boolean boolSinglePartEnum) {
         this.boolSinglePartEnum = boolSinglePartEnum;
         return this;
      }

      public TechAssemble.TechAssembleBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public TechAssemble.TechAssembleBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      @JsonProperty("grossWeight")
      public TechAssemble.TechAssembleBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public TechAssemble.TechAssembleBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("name")
      public TechAssemble.TechAssembleBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("boolStatusEnum")
      public TechAssemble.TechAssembleBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      @JsonProperty("initialSerialNumber")
      public TechAssemble.TechAssembleBuilder initialSerialNumber(final String initialSerialNumber) {
         this.initialSerialNumber = initialSerialNumber;
         return this;
      }

      public TechAssemble.TechAssembleBuilder topPaintArea(final BigDecimal topPaintArea) {
         this.topPaintArea = topPaintArea;
         return this;
      }

      public TechAssemble.TechAssembleBuilder innerPaintArea(final BigDecimal innerPaintArea) {
         this.innerPaintArea = innerPaintArea;
         return this;
      }

      public TechAssemble.TechAssembleBuilder outerPaintArea(final BigDecimal outerPaintArea) {
         this.outerPaintArea = outerPaintArea;
         return this;
      }

      public TechAssemble.TechAssembleBuilder uRibPaintArea(final BigDecimal uRibPaintArea) {
         this.uRibPaintArea = uRibPaintArea;
         return this;
      }

      @JsonProperty("topFlangeArea")
      public TechAssemble.TechAssembleBuilder topFlangeArea(final BigDecimal topFlangeArea) {
         this.topFlangeArea = topFlangeArea;
         return this;
      }

      public TechAssemble build() {
         return new TechAssemble(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaBatchId,
            this.areaId,
            this.structureType,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.surfaceArea,
            this.producedQuantity,
            this.usedQuantity,
            this.useCompleteQuantity,
            this.remark,
            this.drawingNumber,
            this.machinePartId,
            this.areaType,
            this.boolAbnormalEnum,
            this.boolSchedulingEnum,
            this.specPrefix,
            this.assembleConfigId,
            this.boolSectionSteel,
            this.boolProcess,
            this.boolHaveNC1,
            this.productionLineTypeEnum,
            this.userId,
            this.nc1Length,
            this.boolMainAssemble,
            this.boolSendDirectly,
            this.boolSinglePartEnum,
            this.boolAllPartSendDirectly,
            this.businessId,
            this.grossWeight,
            this.totalGrossWeight,
            this.name,
            this.boolStatusEnum,
            this.initialSerialNumber,
            this.topPaintArea,
            this.innerPaintArea,
            this.outerPaintArea,
            this.uRibPaintArea,
            this.topFlangeArea
         );
      }

      @Override
      public String toString() {
         return "TechAssemble.TechAssembleBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaBatchId="
            + this.areaBatchId
            + ", areaId="
            + this.areaId
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
            + ", surfaceArea="
            + this.surfaceArea
            + ", producedQuantity="
            + this.producedQuantity
            + ", usedQuantity="
            + this.usedQuantity
            + ", useCompleteQuantity="
            + this.useCompleteQuantity
            + ", remark="
            + this.remark
            + ", drawingNumber="
            + this.drawingNumber
            + ", machinePartId="
            + this.machinePartId
            + ", areaType="
            + this.areaType
            + ", boolAbnormalEnum="
            + this.boolAbnormalEnum
            + ", boolSchedulingEnum="
            + this.boolSchedulingEnum
            + ", specPrefix="
            + this.specPrefix
            + ", assembleConfigId="
            + this.assembleConfigId
            + ", boolSectionSteel="
            + this.boolSectionSteel
            + ", boolProcess="
            + this.boolProcess
            + ", boolHaveNC1="
            + this.boolHaveNC1
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", userId="
            + this.userId
            + ", nc1Length="
            + this.nc1Length
            + ", boolMainAssemble="
            + this.boolMainAssemble
            + ", boolSendDirectly="
            + this.boolSendDirectly
            + ", boolSinglePartEnum="
            + this.boolSinglePartEnum
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ", businessId="
            + this.businessId
            + ", grossWeight="
            + this.grossWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", name="
            + this.name
            + ", boolStatusEnum="
            + this.boolStatusEnum
            + ", initialSerialNumber="
            + this.initialSerialNumber
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
            + ")";
      }
   }
}
