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

@ApiModel(value = "TechAssembleRecord对象", description = "部件(单元件)审核表 ")
@Entity
@TableName("tech_assemble_record")
@Table(name = "tech_assemble_record", indexes = @Index(name = "id_inventory_operation_id", columnList = "inventory_operation_id"))
public class TechAssembleRecord extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number")
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(64)  COMMENT '名称'")
   private String name;
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
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
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
   @ApiModelProperty(name = "surfaceArea", value = "单面积（mm²）")
   @TableField("surface_area")
   @Column(name = "surface_area", columnDefinition = "decimal(32,8) default 0.0 comment '单面积(mm²)'", nullable = false)
   private BigDecimal surfaceArea;
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
   @ApiModelProperty(name = "areaType", value = "区域制造类型 0自制 1外包")
   @JsonProperty("areaType")
   @JSONField(name = "areaType")
   @TableField("area_type")
   @Column(name = "area_type")
   private Integer areaType;
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
   @ApiModelProperty(name = "userId", value = "导入人id")
   @JsonProperty("userId")
   @Column(name = "user_id", columnDefinition = "bigint(20) default 0 comment '导入人id'", nullable = false)
   private Long userId;
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
   @ApiModelProperty("部件(单元件)类型 16 焊接部件(单元件)  4 成品型材")
   @TableField("artifact_type")
   @Column(name = "artifact_type", columnDefinition = "int(11)  comment '4 焊接部件(单元件)  16 成品型材'", nullable = false)
   private Integer assembleType;
   @ApiModelProperty(name = "boolMainAssemble", value = "是否主部件 true是 false否")
   @TableField("bool_main_assemble")
   @Column(name = "bool_main_assemble", columnDefinition = "tinyint(1) default 0 comment '是否主部件 1是 0否'", nullable = false)
   private Boolean boolMainAssemble;
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
   @ApiModelProperty(name = "booInventory", value = "是否清单导入 true是 false否")
   @TableField("bool_inventory")
   @Column(name = "bool_inventory", columnDefinition = "tinyint(1) default 1 comment '是否清单导入 1是 0否'")
   private Boolean booInventory;
   @ApiModelProperty(name = "topFlangeArea", value = "上翼缘(单)面积（mm²）")
   @JsonProperty("topFlangeArea")
   @JSONField(name = "topFlangeArea")
   @TableField("top_flange_area")
   @Column(name = "top_flange_area", columnDefinition = "decimal(32,4) DEFAULT 0 COMMENT '上翼缘(单)面积（mm²）'")
   private BigDecimal topFlangeArea;

   public static TechAssembleRecord.TechAssembleRecordBuilder builder() {
      return new TechAssembleRecord.TechAssembleRecordBuilder();
   }

   public TechAssembleRecord() {
   }

   public TechAssembleRecord(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaBatchId,
      final Long areaId,
      final Long inventoryOperationId,
      final String structureType,
      final String serialNumber,
      final String name,
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
      final String drawingNumber,
      final Integer areaType,
      final String specPrefix,
      final Long assembleConfigId,
      final Long userId,
      final Boolean boolSendDirectly,
      final Boolean boolSinglePartEnum,
      final Boolean boolAllPartSendDirectly,
      final Integer assembleType,
      final Boolean boolMainAssemble,
      final BigDecimal topPaintArea,
      final BigDecimal innerPaintArea,
      final BigDecimal outerPaintArea,
      final BigDecimal uRibPaintArea,
      final Boolean booInventory,
      final BigDecimal topFlangeArea
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaBatchId = areaBatchId;
      this.areaId = areaId;
      this.inventoryOperationId = inventoryOperationId;
      this.structureType = structureType;
      this.serialNumber = serialNumber;
      this.name = name;
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
      this.drawingNumber = drawingNumber;
      this.areaType = areaType;
      this.specPrefix = specPrefix;
      this.assembleConfigId = assembleConfigId;
      this.userId = userId;
      this.boolSendDirectly = boolSendDirectly;
      this.boolSinglePartEnum = boolSinglePartEnum;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      this.assembleType = assembleType;
      this.boolMainAssemble = boolMainAssemble;
      this.topPaintArea = topPaintArea;
      this.innerPaintArea = innerPaintArea;
      this.outerPaintArea = outerPaintArea;
      this.uRibPaintArea = uRibPaintArea;
      this.booInventory = booInventory;
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

   public Long getInventoryOperationId() {
      return this.inventoryOperationId;
   }

   public String getStructureType() {
      return this.structureType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
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

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public Integer getAreaType() {
      return this.areaType;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Long getAssembleConfigId() {
      return this.assembleConfigId;
   }

   public Long getUserId() {
      return this.userId;
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

   public Integer getAssembleType() {
      return this.assembleType;
   }

   public Boolean getBoolMainAssemble() {
      return this.boolMainAssemble;
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

   public Boolean getBooInventory() {
      return this.booInventory;
   }

   public BigDecimal getTopFlangeArea() {
      return this.topFlangeArea;
   }

   @JsonProperty("id")
   public TechAssembleRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public TechAssembleRecord setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public TechAssembleRecord setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public TechAssembleRecord setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("areaId")
   public TechAssembleRecord setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("inventoryOperationId")
   public TechAssembleRecord setInventoryOperationId(final Long inventoryOperationId) {
      this.inventoryOperationId = inventoryOperationId;
      return this;
   }

   public TechAssembleRecord setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   @JsonProperty("serialNumber")
   public TechAssembleRecord setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("name")
   public TechAssembleRecord setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("specification")
   public TechAssembleRecord setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public TechAssembleRecord setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public TechAssembleRecord setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public TechAssembleRecord setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public TechAssembleRecord setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public TechAssembleRecord setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public TechAssembleRecord setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public TechAssembleRecord setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   public TechAssembleRecord setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("remark")
   public TechAssembleRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("drawingNumber")
   public TechAssembleRecord setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
      return this;
   }

   @JsonProperty("areaType")
   public TechAssembleRecord setAreaType(final Integer areaType) {
      this.areaType = areaType;
      return this;
   }

   @JsonProperty("specPrefix")
   public TechAssembleRecord setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
      return this;
   }

   public TechAssembleRecord setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
      return this;
   }

   @JsonProperty("userId")
   public TechAssembleRecord setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public TechAssembleRecord setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
      return this;
   }

   public TechAssembleRecord setBoolSinglePartEnum(final Boolean boolSinglePartEnum) {
      this.boolSinglePartEnum = boolSinglePartEnum;
      return this;
   }

   public TechAssembleRecord setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      return this;
   }

   public TechAssembleRecord setAssembleType(final Integer assembleType) {
      this.assembleType = assembleType;
      return this;
   }

   public TechAssembleRecord setBoolMainAssemble(final Boolean boolMainAssemble) {
      this.boolMainAssemble = boolMainAssemble;
      return this;
   }

   public TechAssembleRecord setTopPaintArea(final BigDecimal topPaintArea) {
      this.topPaintArea = topPaintArea;
      return this;
   }

   public TechAssembleRecord setInnerPaintArea(final BigDecimal innerPaintArea) {
      this.innerPaintArea = innerPaintArea;
      return this;
   }

   public TechAssembleRecord setOuterPaintArea(final BigDecimal outerPaintArea) {
      this.outerPaintArea = outerPaintArea;
      return this;
   }

   public TechAssembleRecord setURibPaintArea(final BigDecimal uRibPaintArea) {
      this.uRibPaintArea = uRibPaintArea;
      return this;
   }

   public TechAssembleRecord setBooInventory(final Boolean booInventory) {
      this.booInventory = booInventory;
      return this;
   }

   @JsonProperty("topFlangeArea")
   public TechAssembleRecord setTopFlangeArea(final BigDecimal topFlangeArea) {
      this.topFlangeArea = topFlangeArea;
      return this;
   }

   @Override
   public String toString() {
      return "TechAssembleRecord(id="
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
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
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
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", areaType="
         + this.getAreaType()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", assembleConfigId="
         + this.getAssembleConfigId()
         + ", userId="
         + this.getUserId()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", boolSinglePartEnum="
         + this.getBoolSinglePartEnum()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", assembleType="
         + this.getAssembleType()
         + ", boolMainAssemble="
         + this.getBoolMainAssemble()
         + ", topPaintArea="
         + this.getTopPaintArea()
         + ", innerPaintArea="
         + this.getInnerPaintArea()
         + ", outerPaintArea="
         + this.getOuterPaintArea()
         + ", uRibPaintArea="
         + this.getURibPaintArea()
         + ", booInventory="
         + this.getBooInventory()
         + ", topFlangeArea="
         + this.getTopFlangeArea()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechAssembleRecord)) {
         return false;
      }

      TechAssembleRecord other = (TechAssembleRecord)o;
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
                           Object this$areaType = this.getAreaType();
                           Object other$areaType = other.getAreaType();
                           if (this$areaType == null ? other$areaType == null : this$areaType.equals(other$areaType)) {
                              Object this$assembleConfigId = this.getAssembleConfigId();
                              Object other$assembleConfigId = other.getAssembleConfigId();
                              if (this$assembleConfigId == null ? other$assembleConfigId == null : this$assembleConfigId.equals(other$assembleConfigId)) {
                                 Object this$userId = this.getUserId();
                                 Object other$userId = other.getUserId();
                                 if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                    Object this$boolSendDirectly = this.getBoolSendDirectly();
                                    Object other$boolSendDirectly = other.getBoolSendDirectly();
                                    if (this$boolSendDirectly == null ? other$boolSendDirectly == null : this$boolSendDirectly.equals(other$boolSendDirectly)) {
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
                                             Object this$assembleType = this.getAssembleType();
                                             Object other$assembleType = other.getAssembleType();
                                             if (this$assembleType == null ? other$assembleType == null : this$assembleType.equals(other$assembleType)) {
                                                Object this$boolMainAssemble = this.getBoolMainAssemble();
                                                Object other$boolMainAssemble = other.getBoolMainAssemble();
                                                if (this$boolMainAssemble == null
                                                   ? other$boolMainAssemble == null
                                                   : this$boolMainAssemble.equals(other$boolMainAssemble)) {
                                                   Object this$booInventory = this.getBooInventory();
                                                   Object other$booInventory = other.getBooInventory();
                                                   if (this$booInventory == null ? other$booInventory == null : this$booInventory.equals(other$booInventory)) {
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
                                                            Object this$name = this.getName();
                                                            Object other$name = other.getName();
                                                            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                               Object this$specification = this.getSpecification();
                                                               Object other$specification = other.getSpecification();
                                                               if (this$specification == null
                                                                  ? other$specification == null
                                                                  : this$specification.equals(other$specification)) {
                                                                  Object this$length = this.getLength();
                                                                  Object other$length = other.getLength();
                                                                  if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                     Object this$material = this.getMaterial();
                                                                     Object other$material = other.getMaterial();
                                                                     if (this$material == null ? other$material == null : this$material.equals(other$material)) {
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
                                                                                          Object this$drawingNumber = this.getDrawingNumber();
                                                                                          Object other$drawingNumber = other.getDrawingNumber();
                                                                                          if (this$drawingNumber == null
                                                                                             ? other$drawingNumber == null
                                                                                             : this$drawingNumber.equals(other$drawingNumber)) {
                                                                                             Object this$specPrefix = this.getSpecPrefix();
                                                                                             Object other$specPrefix = other.getSpecPrefix();
                                                                                             if (this$specPrefix == null
                                                                                                ? other$specPrefix == null
                                                                                                : this$specPrefix.equals(other$specPrefix)) {
                                                                                                Object this$topPaintArea = this.getTopPaintArea();
                                                                                                Object other$topPaintArea = other.getTopPaintArea();
                                                                                                if (this$topPaintArea == null
                                                                                                   ? other$topPaintArea == null
                                                                                                   : this$topPaintArea.equals(other$topPaintArea)) {
                                                                                                   Object this$innerPaintArea = this.getInnerPaintArea();
                                                                                                   Object other$innerPaintArea = other.getInnerPaintArea();
                                                                                                   if (this$innerPaintArea == null
                                                                                                      ? other$innerPaintArea == null
                                                                                                      : this$innerPaintArea.equals(other$innerPaintArea)) {
                                                                                                      Object this$outerPaintArea = this.getOuterPaintArea();
                                                                                                      Object other$outerPaintArea = other.getOuterPaintArea();
                                                                                                      if (this$outerPaintArea == null
                                                                                                         ? other$outerPaintArea == null
                                                                                                         : this$outerPaintArea.equals(other$outerPaintArea)) {
                                                                                                         Object this$uRibPaintArea = this.getURibPaintArea();
                                                                                                         Object other$uRibPaintArea = other.getURibPaintArea();
                                                                                                         if (this$uRibPaintArea == null
                                                                                                            ? other$uRibPaintArea == null
                                                                                                            : this$uRibPaintArea.equals(other$uRibPaintArea)) {
                                                                                                            Object this$topFlangeArea = this.getTopFlangeArea();
                                                                                                            Object other$topFlangeArea = other.getTopFlangeArea();
                                                                                                            return this$topFlangeArea == null
                                                                                                               ? other$topFlangeArea == null
                                                                                                               : this$topFlangeArea.equals(other$topFlangeArea);
                                                                                                         } else {
                                                                                                            return false;
                                                                                                         }
                                                                                                      } else {
                                                                                                         return false;
                                                                                                      }
                                                                                                   } else {
                                                                                                      return false;
                                                                                                   }
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof TechAssembleRecord;
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
      Object $areaType = this.getAreaType();
      result = result * 59 + ($areaType == null ? 43 : $areaType.hashCode());
      Object $assembleConfigId = this.getAssembleConfigId();
      result = result * 59 + ($assembleConfigId == null ? 43 : $assembleConfigId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $boolSinglePartEnum = this.getBoolSinglePartEnum();
      result = result * 59 + ($boolSinglePartEnum == null ? 43 : $boolSinglePartEnum.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $assembleType = this.getAssembleType();
      result = result * 59 + ($assembleType == null ? 43 : $assembleType.hashCode());
      Object $boolMainAssemble = this.getBoolMainAssemble();
      result = result * 59 + ($boolMainAssemble == null ? 43 : $boolMainAssemble.hashCode());
      Object $booInventory = this.getBooInventory();
      result = result * 59 + ($booInventory == null ? 43 : $booInventory.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
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
      Object $topFlangeArea = this.getTopFlangeArea();
      return result * 59 + ($topFlangeArea == null ? 43 : $topFlangeArea.hashCode());
   }

   public static class TechAssembleRecordBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaBatchId;
      private Long areaId;
      private Long inventoryOperationId;
      private String structureType;
      private String serialNumber;
      private String name;
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
      private String drawingNumber;
      private Integer areaType;
      private String specPrefix;
      private Long assembleConfigId;
      private Long userId;
      private Boolean boolSendDirectly;
      private Boolean boolSinglePartEnum;
      private Boolean boolAllPartSendDirectly;
      private Integer assembleType;
      private Boolean boolMainAssemble;
      private BigDecimal topPaintArea;
      private BigDecimal innerPaintArea;
      private BigDecimal outerPaintArea;
      private BigDecimal uRibPaintArea;
      private Boolean booInventory;
      private BigDecimal topFlangeArea;

      TechAssembleRecordBuilder() {
      }

      @JsonProperty("id")
      public TechAssembleRecord.TechAssembleRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public TechAssembleRecord.TechAssembleRecordBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public TechAssembleRecord.TechAssembleRecordBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public TechAssembleRecord.TechAssembleRecordBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("areaId")
      public TechAssembleRecord.TechAssembleRecordBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("inventoryOperationId")
      public TechAssembleRecord.TechAssembleRecordBuilder inventoryOperationId(final Long inventoryOperationId) {
         this.inventoryOperationId = inventoryOperationId;
         return this;
      }

      public TechAssembleRecord.TechAssembleRecordBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      @JsonProperty("serialNumber")
      public TechAssembleRecord.TechAssembleRecordBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("name")
      public TechAssembleRecord.TechAssembleRecordBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("specification")
      public TechAssembleRecord.TechAssembleRecordBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public TechAssembleRecord.TechAssembleRecordBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public TechAssembleRecord.TechAssembleRecordBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public TechAssembleRecord.TechAssembleRecordBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public TechAssembleRecord.TechAssembleRecordBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public TechAssembleRecord.TechAssembleRecordBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public TechAssembleRecord.TechAssembleRecordBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public TechAssembleRecord.TechAssembleRecordBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public TechAssembleRecord.TechAssembleRecordBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("remark")
      public TechAssembleRecord.TechAssembleRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("drawingNumber")
      public TechAssembleRecord.TechAssembleRecordBuilder drawingNumber(final String drawingNumber) {
         this.drawingNumber = drawingNumber;
         return this;
      }

      @JsonProperty("areaType")
      public TechAssembleRecord.TechAssembleRecordBuilder areaType(final Integer areaType) {
         this.areaType = areaType;
         return this;
      }

      @JsonProperty("specPrefix")
      public TechAssembleRecord.TechAssembleRecordBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public TechAssembleRecord.TechAssembleRecordBuilder assembleConfigId(final Long assembleConfigId) {
         this.assembleConfigId = assembleConfigId;
         return this;
      }

      @JsonProperty("userId")
      public TechAssembleRecord.TechAssembleRecordBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechAssembleRecord.TechAssembleRecordBuilder boolSendDirectly(final Boolean boolSendDirectly) {
         this.boolSendDirectly = boolSendDirectly;
         return this;
      }

      public TechAssembleRecord.TechAssembleRecordBuilder boolSinglePartEnum(final Boolean boolSinglePartEnum) {
         this.boolSinglePartEnum = boolSinglePartEnum;
         return this;
      }

      public TechAssembleRecord.TechAssembleRecordBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public TechAssembleRecord.TechAssembleRecordBuilder assembleType(final Integer assembleType) {
         this.assembleType = assembleType;
         return this;
      }

      public TechAssembleRecord.TechAssembleRecordBuilder boolMainAssemble(final Boolean boolMainAssemble) {
         this.boolMainAssemble = boolMainAssemble;
         return this;
      }

      public TechAssembleRecord.TechAssembleRecordBuilder topPaintArea(final BigDecimal topPaintArea) {
         this.topPaintArea = topPaintArea;
         return this;
      }

      public TechAssembleRecord.TechAssembleRecordBuilder innerPaintArea(final BigDecimal innerPaintArea) {
         this.innerPaintArea = innerPaintArea;
         return this;
      }

      public TechAssembleRecord.TechAssembleRecordBuilder outerPaintArea(final BigDecimal outerPaintArea) {
         this.outerPaintArea = outerPaintArea;
         return this;
      }

      public TechAssembleRecord.TechAssembleRecordBuilder uRibPaintArea(final BigDecimal uRibPaintArea) {
         this.uRibPaintArea = uRibPaintArea;
         return this;
      }

      public TechAssembleRecord.TechAssembleRecordBuilder booInventory(final Boolean booInventory) {
         this.booInventory = booInventory;
         return this;
      }

      @JsonProperty("topFlangeArea")
      public TechAssembleRecord.TechAssembleRecordBuilder topFlangeArea(final BigDecimal topFlangeArea) {
         this.topFlangeArea = topFlangeArea;
         return this;
      }

      public TechAssembleRecord build() {
         return new TechAssembleRecord(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaBatchId,
            this.areaId,
            this.inventoryOperationId,
            this.structureType,
            this.serialNumber,
            this.name,
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
            this.drawingNumber,
            this.areaType,
            this.specPrefix,
            this.assembleConfigId,
            this.userId,
            this.boolSendDirectly,
            this.boolSinglePartEnum,
            this.boolAllPartSendDirectly,
            this.assembleType,
            this.boolMainAssemble,
            this.topPaintArea,
            this.innerPaintArea,
            this.outerPaintArea,
            this.uRibPaintArea,
            this.booInventory,
            this.topFlangeArea
         );
      }

      @Override
      public String toString() {
         return "TechAssembleRecord.TechAssembleRecordBuilder(id="
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
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
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
            + ", drawingNumber="
            + this.drawingNumber
            + ", areaType="
            + this.areaType
            + ", specPrefix="
            + this.specPrefix
            + ", assembleConfigId="
            + this.assembleConfigId
            + ", userId="
            + this.userId
            + ", boolSendDirectly="
            + this.boolSendDirectly
            + ", boolSinglePartEnum="
            + this.boolSinglePartEnum
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ", assembleType="
            + this.assembleType
            + ", boolMainAssemble="
            + this.boolMainAssemble
            + ", topPaintArea="
            + this.topPaintArea
            + ", innerPaintArea="
            + this.innerPaintArea
            + ", outerPaintArea="
            + this.outerPaintArea
            + ", uRibPaintArea="
            + this.uRibPaintArea
            + ", booInventory="
            + this.booInventory
            + ", topFlangeArea="
            + this.topFlangeArea
            + ")";
      }
   }
}
