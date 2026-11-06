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

@ApiModel(value = "MaterialUnfreeze对象", description = "物料冻结解冻记录表 ")
@Entity
@TableName("wms_material_unfreeze")
@Table(name = "wms_material_unfreeze")
public class MaterialUnfreeze extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "freezeType", value = "冻结类型", notes = "冻结类型")
   @JsonProperty("freezeType")
   @JSONField(name = "freezeType")
   @TableField("freeze_type")
   @Column(name = "freeze_type", columnDefinition = "int  COMMENT '冻结类型'", nullable = true)
   private Integer freezeType;
   @ApiModelProperty(name = "freezeDetailId", value = "冻结详情ID", notes = "冻结详情ID")
   @JsonProperty("freezeDetailId")
   @JSONField(name = "freezeDetailId")
   @TableField("freeze_detail_id")
   @Column(name = "freeze_detail_id", columnDefinition = "bigint  COMMENT '冻结详情ID'", nullable = true)
   private Long freezeDetailId;
   @ApiModelProperty(name = "sourceId", value = "冻结来源ID", notes = "冻结来源ID")
   @JsonProperty("sourceId")
   @JSONField(name = "sourceId")
   @TableField("source_id")
   @Column(name = "source_id", columnDefinition = "bigint  COMMENT '冻结来源ID'", nullable = true)
   private Long sourceId;
   @ApiModelProperty(name = "sourceSn", value = "来源单号", notes = "来源单号")
   @JsonProperty("sourceSn")
   @JSONField(name = "sourceSn")
   @TableField("source_SN")
   @Column(name = "source_SN", columnDefinition = "varchar(255)  COMMENT '来源单号'", nullable = true)
   private String sourceSn;
   @ApiModelProperty(name = "basicClass", value = "基础类型", notes = "基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "quantity", value = "解冻数量", notes = "解冻数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '解冻数量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "解冻核算量", notes = "解冻核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '解冻核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "warehouseId", value = "仓库ID", notes = "仓库ID")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint  COMMENT '仓库ID'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "applicantId", value = "解冻申请人ID", notes = "解冻申请人ID")
   @JsonProperty("applicantId")
   @JSONField(name = "applicantId")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint  COMMENT '解冻申请人ID'", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "解冻申请人名称", notes = "解冻申请人名称")
   @JsonProperty("applicantName")
   @JSONField(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(255)  COMMENT '解冻申请人名称'", nullable = true)
   private String applicantName;
   @ApiModelProperty(name = "unfreezeType", value = "解冻类型[1 手动解冻, 2 自动解冻]", notes = "解冻类型[1 手动解冻, 2 自动解冻]")
   @JsonProperty("unfreezeType")
   @JSONField(name = "unfreezeType")
   @TableField("unfreeze_type")
   @Column(name = "unfreeze_type", columnDefinition = "int  COMMENT '解冻类型[1 手动解冻, 2 自动解冻]'", nullable = true)
   private Integer unfreezeType;
   @ApiModelProperty(name = "remark", value = "解冻备注", notes = "解冻备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '解冻备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "materialInventoryId", value = "物料仓ID", notes = "物料仓ID")
   @JsonProperty("materialInventoryId")
   @JSONField(name = "materialInventoryId")
   @TableField("material_inventory_id")
   @Column(name = "material_inventory_id", columnDefinition = "bigint  COMMENT '物料仓ID'", nullable = true)
   private Long materialInventoryId;
   @ApiModelProperty(name = "brand", value = "品牌", notes = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(255)  COMMENT '品牌'", nullable = true)
   private String brand;
   @ApiModelProperty(name = "color", value = "颜色", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @TableField("color")
   @Column(name = "color", columnDefinition = "varchar(255)  COMMENT '颜色'", nullable = true)
   private String color;
   @ApiModelProperty(name = "heatNoAndBatchNo", value = "炉批号", notes = "炉批号")
   @JsonProperty("heatNoAndBatchNo")
   @JSONField(name = "heatNoAndBatchNo")
   @TableField("heat_no_and_batch_no")
   @Column(name = "heat_no_and_batch_no", columnDefinition = "varchar(255)  COMMENT '炉批号'", nullable = true)
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "length", value = "长", notes = "长")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,8)  COMMENT '长'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "materialIsWhole", value = "物料状态", notes = "物料状态")
   @JsonProperty("materialIsWhole")
   @JSONField(name = "materialIsWhole")
   @TableField("material_is_whole")
   @Column(name = "material_is_whole", columnDefinition = "int  COMMENT '物料状态'", nullable = true)
   private Integer materialIsWhole;
   @ApiModelProperty(name = "sourceProjectId", value = "原项目", notes = "原项目")
   @JsonProperty("sourceProjectId")
   @JSONField(name = "sourceProjectId")
   @TableField("source_project_id")
   @Column(name = "source_project_id", columnDefinition = "bigint  COMMENT '原项目'", nullable = true)
   private Long sourceProjectId;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚", notes = "理论厚")
   @JsonProperty("theoryThickness")
   @JSONField(name = "theoryThickness")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness", columnDefinition = "decimal(32,8)  COMMENT '理论厚'", nullable = true)
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "thickness", value = "厚", notes = "厚")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8)  COMMENT '厚'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "boolPartyA", value = "是否为甲供物料", notes = "是否为甲供物料")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否为甲供物料'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "width", value = "宽", notes = "宽")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,8)  COMMENT '宽'", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "standardId", value = "型材执行国标ID", notes = "型材执行国标ID")
   @JsonProperty("standardId")
   @JSONField(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id", columnDefinition = "bigint  COMMENT '型材执行国标ID'", nullable = true)
   private Long standardId;
   @ApiModelProperty(name = "standardName", value = "型材执行国标名称", notes = "型材执行国标名称")
   @JsonProperty("standardName")
   @JSONField(name = "standardName")
   @TableField("standard_name")
   @Column(name = "standard_name", columnDefinition = "varchar(255)  COMMENT '型材执行国标名称'", nullable = true)
   private String standardName;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint  COMMENT '单体ID'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint  COMMENT '区域ID'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "workshopId")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long workshopId;

   public static MaterialUnfreeze.MaterialUnfreezeBuilder builder() {
      return new MaterialUnfreeze.MaterialUnfreezeBuilder();
   }

   public MaterialUnfreeze() {
   }

   public MaterialUnfreeze(
      final Long id,
      final Integer freezeType,
      final Long freezeDetailId,
      final Long sourceId,
      final String sourceSn,
      final Integer basicClass,
      final Long classifyId,
      final BigDecimal quantity,
      final BigDecimal mete,
      final Long projectId,
      final Long warehouseId,
      final Long applicantId,
      final String applicantName,
      final Integer unfreezeType,
      final String remark,
      final Long materialInventoryId,
      final String brand,
      final String color,
      final String heatNoAndBatchNo,
      final BigDecimal length,
      final Integer materialIsWhole,
      final Long sourceProjectId,
      final String specification,
      final BigDecimal theoryThickness,
      final BigDecimal thickness,
      final Boolean boolPartyA,
      final BigDecimal width,
      final Long standardId,
      final String standardName,
      final Long monomerId,
      final Long areaId,
      final Long workshopId
   ) {
      this.id = id;
      this.freezeType = freezeType;
      this.freezeDetailId = freezeDetailId;
      this.sourceId = sourceId;
      this.sourceSn = sourceSn;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.quantity = quantity;
      this.mete = mete;
      this.projectId = projectId;
      this.warehouseId = warehouseId;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.unfreezeType = unfreezeType;
      this.remark = remark;
      this.materialInventoryId = materialInventoryId;
      this.brand = brand;
      this.color = color;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.length = length;
      this.materialIsWhole = materialIsWhole;
      this.sourceProjectId = sourceProjectId;
      this.specification = specification;
      this.theoryThickness = theoryThickness;
      this.thickness = thickness;
      this.boolPartyA = boolPartyA;
      this.width = width;
      this.standardId = standardId;
      this.standardName = standardName;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.workshopId = workshopId;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getFreezeType() {
      return this.freezeType;
   }

   public Long getFreezeDetailId() {
      return this.freezeDetailId;
   }

   public Long getSourceId() {
      return this.sourceId;
   }

   public String getSourceSn() {
      return this.sourceSn;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Integer getUnfreezeType() {
      return this.unfreezeType;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public Long getSourceProjectId() {
      return this.sourceProjectId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   @JsonProperty("id")
   public MaterialUnfreeze setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("freezeType")
   public MaterialUnfreeze setFreezeType(final Integer freezeType) {
      this.freezeType = freezeType;
      return this;
   }

   @JsonProperty("freezeDetailId")
   public MaterialUnfreeze setFreezeDetailId(final Long freezeDetailId) {
      this.freezeDetailId = freezeDetailId;
      return this;
   }

   @JsonProperty("sourceId")
   public MaterialUnfreeze setSourceId(final Long sourceId) {
      this.sourceId = sourceId;
      return this;
   }

   @JsonProperty("sourceSn")
   public MaterialUnfreeze setSourceSn(final String sourceSn) {
      this.sourceSn = sourceSn;
      return this;
   }

   @JsonProperty("basicClass")
   public MaterialUnfreeze setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyId")
   public MaterialUnfreeze setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("quantity")
   public MaterialUnfreeze setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("mete")
   public MaterialUnfreeze setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("projectId")
   public MaterialUnfreeze setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("warehouseId")
   public MaterialUnfreeze setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("applicantId")
   public MaterialUnfreeze setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public MaterialUnfreeze setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("unfreezeType")
   public MaterialUnfreeze setUnfreezeType(final Integer unfreezeType) {
      this.unfreezeType = unfreezeType;
      return this;
   }

   @JsonProperty("remark")
   public MaterialUnfreeze setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("materialInventoryId")
   public MaterialUnfreeze setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
      return this;
   }

   @JsonProperty("brand")
   public MaterialUnfreeze setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("color")
   public MaterialUnfreeze setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public MaterialUnfreeze setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("length")
   public MaterialUnfreeze setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("materialIsWhole")
   public MaterialUnfreeze setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
      return this;
   }

   @JsonProperty("sourceProjectId")
   public MaterialUnfreeze setSourceProjectId(final Long sourceProjectId) {
      this.sourceProjectId = sourceProjectId;
      return this;
   }

   @JsonProperty("specification")
   public MaterialUnfreeze setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("theoryThickness")
   public MaterialUnfreeze setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("thickness")
   public MaterialUnfreeze setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("boolPartyA")
   public MaterialUnfreeze setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("width")
   public MaterialUnfreeze setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("standardId")
   public MaterialUnfreeze setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public MaterialUnfreeze setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("monomerId")
   public MaterialUnfreeze setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MaterialUnfreeze setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("workshopId")
   public MaterialUnfreeze setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @Override
   public String toString() {
      return "MaterialUnfreeze(id="
         + this.getId()
         + ", freezeType="
         + this.getFreezeType()
         + ", freezeDetailId="
         + this.getFreezeDetailId()
         + ", sourceId="
         + this.getSourceId()
         + ", sourceSn="
         + this.getSourceSn()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", projectId="
         + this.getProjectId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", unfreezeType="
         + this.getUnfreezeType()
         + ", remark="
         + this.getRemark()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", length="
         + this.getLength()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", sourceProjectId="
         + this.getSourceProjectId()
         + ", specification="
         + this.getSpecification()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", thickness="
         + this.getThickness()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", width="
         + this.getWidth()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", workshopId="
         + this.getWorkshopId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialUnfreeze)) {
         return false;
      }

      MaterialUnfreeze other = (MaterialUnfreeze)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$freezeType = this.getFreezeType();
         Object other$freezeType = other.getFreezeType();
         if (this$freezeType == null ? other$freezeType == null : this$freezeType.equals(other$freezeType)) {
            Object this$freezeDetailId = this.getFreezeDetailId();
            Object other$freezeDetailId = other.getFreezeDetailId();
            if (this$freezeDetailId == null ? other$freezeDetailId == null : this$freezeDetailId.equals(other$freezeDetailId)) {
               Object this$sourceId = this.getSourceId();
               Object other$sourceId = other.getSourceId();
               if (this$sourceId == null ? other$sourceId == null : this$sourceId.equals(other$sourceId)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$classifyId = this.getClassifyId();
                     Object other$classifyId = other.getClassifyId();
                     if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                        Object this$projectId = this.getProjectId();
                        Object other$projectId = other.getProjectId();
                        if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                           Object this$warehouseId = this.getWarehouseId();
                           Object other$warehouseId = other.getWarehouseId();
                           if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                              Object this$applicantId = this.getApplicantId();
                              Object other$applicantId = other.getApplicantId();
                              if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                                 Object this$unfreezeType = this.getUnfreezeType();
                                 Object other$unfreezeType = other.getUnfreezeType();
                                 if (this$unfreezeType == null ? other$unfreezeType == null : this$unfreezeType.equals(other$unfreezeType)) {
                                    Object this$materialInventoryId = this.getMaterialInventoryId();
                                    Object other$materialInventoryId = other.getMaterialInventoryId();
                                    if (this$materialInventoryId == null
                                       ? other$materialInventoryId == null
                                       : this$materialInventoryId.equals(other$materialInventoryId)) {
                                       Object this$materialIsWhole = this.getMaterialIsWhole();
                                       Object other$materialIsWhole = other.getMaterialIsWhole();
                                       if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
                                          Object this$sourceProjectId = this.getSourceProjectId();
                                          Object other$sourceProjectId = other.getSourceProjectId();
                                          if (this$sourceProjectId == null ? other$sourceProjectId == null : this$sourceProjectId.equals(other$sourceProjectId)
                                             )
                                           {
                                             Object this$boolPartyA = this.getBoolPartyA();
                                             Object other$boolPartyA = other.getBoolPartyA();
                                             if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                                                Object this$standardId = this.getStandardId();
                                                Object other$standardId = other.getStandardId();
                                                if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                                   Object this$monomerId = this.getMonomerId();
                                                   Object other$monomerId = other.getMonomerId();
                                                   if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                                      Object this$areaId = this.getAreaId();
                                                      Object other$areaId = other.getAreaId();
                                                      if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                                         Object this$workshopId = this.getWorkshopId();
                                                         Object other$workshopId = other.getWorkshopId();
                                                         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                                            Object this$sourceSn = this.getSourceSn();
                                                            Object other$sourceSn = other.getSourceSn();
                                                            if (this$sourceSn == null ? other$sourceSn == null : this$sourceSn.equals(other$sourceSn)) {
                                                               Object this$quantity = this.getQuantity();
                                                               Object other$quantity = other.getQuantity();
                                                               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                                  Object this$mete = this.getMete();
                                                                  Object other$mete = other.getMete();
                                                                  if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                     Object this$applicantName = this.getApplicantName();
                                                                     Object other$applicantName = other.getApplicantName();
                                                                     if (this$applicantName == null
                                                                        ? other$applicantName == null
                                                                        : this$applicantName.equals(other$applicantName)) {
                                                                        Object this$remark = this.getRemark();
                                                                        Object other$remark = other.getRemark();
                                                                        if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                           Object this$brand = this.getBrand();
                                                                           Object other$brand = other.getBrand();
                                                                           if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                              Object this$color = this.getColor();
                                                                              Object other$color = other.getColor();
                                                                              if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                                 Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                                 Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                                 if (this$heatNoAndBatchNo == null
                                                                                    ? other$heatNoAndBatchNo == null
                                                                                    : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                                    Object this$length = this.getLength();
                                                                                    Object other$length = other.getLength();
                                                                                    if (this$length == null
                                                                                       ? other$length == null
                                                                                       : this$length.equals(other$length)) {
                                                                                       Object this$specification = this.getSpecification();
                                                                                       Object other$specification = other.getSpecification();
                                                                                       if (this$specification == null
                                                                                          ? other$specification == null
                                                                                          : this$specification.equals(other$specification)) {
                                                                                          Object this$theoryThickness = this.getTheoryThickness();
                                                                                          Object other$theoryThickness = other.getTheoryThickness();
                                                                                          if (this$theoryThickness == null
                                                                                             ? other$theoryThickness == null
                                                                                             : this$theoryThickness.equals(other$theoryThickness)) {
                                                                                             Object this$thickness = this.getThickness();
                                                                                             Object other$thickness = other.getThickness();
                                                                                             if (this$thickness == null
                                                                                                ? other$thickness == null
                                                                                                : this$thickness.equals(other$thickness)) {
                                                                                                Object this$width = this.getWidth();
                                                                                                Object other$width = other.getWidth();
                                                                                                if (this$width == null
                                                                                                   ? other$width == null
                                                                                                   : this$width.equals(other$width)) {
                                                                                                   Object this$standardName = this.getStandardName();
                                                                                                   Object other$standardName = other.getStandardName();
                                                                                                   return this$standardName == null
                                                                                                      ? other$standardName == null
                                                                                                      : this$standardName.equals(other$standardName);
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MaterialUnfreeze;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $freezeType = this.getFreezeType();
      result = result * 59 + ($freezeType == null ? 43 : $freezeType.hashCode());
      Object $freezeDetailId = this.getFreezeDetailId();
      result = result * 59 + ($freezeDetailId == null ? 43 : $freezeDetailId.hashCode());
      Object $sourceId = this.getSourceId();
      result = result * 59 + ($sourceId == null ? 43 : $sourceId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $unfreezeType = this.getUnfreezeType();
      result = result * 59 + ($unfreezeType == null ? 43 : $unfreezeType.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $sourceProjectId = this.getSourceProjectId();
      result = result * 59 + ($sourceProjectId == null ? 43 : $sourceProjectId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $sourceSn = this.getSourceSn();
      result = result * 59 + ($sourceSn == null ? 43 : $sourceSn.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $standardName = this.getStandardName();
      return result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
   }

   public static class MaterialUnfreezeBuilder {
      private Long id;
      private Integer freezeType;
      private Long freezeDetailId;
      private Long sourceId;
      private String sourceSn;
      private Integer basicClass;
      private Long classifyId;
      private BigDecimal quantity;
      private BigDecimal mete;
      private Long projectId;
      private Long warehouseId;
      private Long applicantId;
      private String applicantName;
      private Integer unfreezeType;
      private String remark;
      private Long materialInventoryId;
      private String brand;
      private String color;
      private String heatNoAndBatchNo;
      private BigDecimal length;
      private Integer materialIsWhole;
      private Long sourceProjectId;
      private String specification;
      private BigDecimal theoryThickness;
      private BigDecimal thickness;
      private Boolean boolPartyA;
      private BigDecimal width;
      private Long standardId;
      private String standardName;
      private Long monomerId;
      private Long areaId;
      private Long workshopId;

      MaterialUnfreezeBuilder() {
      }

      @JsonProperty("id")
      public MaterialUnfreeze.MaterialUnfreezeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("freezeType")
      public MaterialUnfreeze.MaterialUnfreezeBuilder freezeType(final Integer freezeType) {
         this.freezeType = freezeType;
         return this;
      }

      @JsonProperty("freezeDetailId")
      public MaterialUnfreeze.MaterialUnfreezeBuilder freezeDetailId(final Long freezeDetailId) {
         this.freezeDetailId = freezeDetailId;
         return this;
      }

      @JsonProperty("sourceId")
      public MaterialUnfreeze.MaterialUnfreezeBuilder sourceId(final Long sourceId) {
         this.sourceId = sourceId;
         return this;
      }

      @JsonProperty("sourceSn")
      public MaterialUnfreeze.MaterialUnfreezeBuilder sourceSn(final String sourceSn) {
         this.sourceSn = sourceSn;
         return this;
      }

      @JsonProperty("basicClass")
      public MaterialUnfreeze.MaterialUnfreezeBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyId")
      public MaterialUnfreeze.MaterialUnfreezeBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("quantity")
      public MaterialUnfreeze.MaterialUnfreezeBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public MaterialUnfreeze.MaterialUnfreezeBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("projectId")
      public MaterialUnfreeze.MaterialUnfreezeBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("warehouseId")
      public MaterialUnfreeze.MaterialUnfreezeBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("applicantId")
      public MaterialUnfreeze.MaterialUnfreezeBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public MaterialUnfreeze.MaterialUnfreezeBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("unfreezeType")
      public MaterialUnfreeze.MaterialUnfreezeBuilder unfreezeType(final Integer unfreezeType) {
         this.unfreezeType = unfreezeType;
         return this;
      }

      @JsonProperty("remark")
      public MaterialUnfreeze.MaterialUnfreezeBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("materialInventoryId")
      public MaterialUnfreeze.MaterialUnfreezeBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      @JsonProperty("brand")
      public MaterialUnfreeze.MaterialUnfreezeBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("color")
      public MaterialUnfreeze.MaterialUnfreezeBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public MaterialUnfreeze.MaterialUnfreezeBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("length")
      public MaterialUnfreeze.MaterialUnfreezeBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public MaterialUnfreeze.MaterialUnfreezeBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("sourceProjectId")
      public MaterialUnfreeze.MaterialUnfreezeBuilder sourceProjectId(final Long sourceProjectId) {
         this.sourceProjectId = sourceProjectId;
         return this;
      }

      @JsonProperty("specification")
      public MaterialUnfreeze.MaterialUnfreezeBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("theoryThickness")
      public MaterialUnfreeze.MaterialUnfreezeBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("thickness")
      public MaterialUnfreeze.MaterialUnfreezeBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("boolPartyA")
      public MaterialUnfreeze.MaterialUnfreezeBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("width")
      public MaterialUnfreeze.MaterialUnfreezeBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("standardId")
      public MaterialUnfreeze.MaterialUnfreezeBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public MaterialUnfreeze.MaterialUnfreezeBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("monomerId")
      public MaterialUnfreeze.MaterialUnfreezeBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MaterialUnfreeze.MaterialUnfreezeBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("workshopId")
      public MaterialUnfreeze.MaterialUnfreezeBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MaterialUnfreeze build() {
         return new MaterialUnfreeze(
            this.id,
            this.freezeType,
            this.freezeDetailId,
            this.sourceId,
            this.sourceSn,
            this.basicClass,
            this.classifyId,
            this.quantity,
            this.mete,
            this.projectId,
            this.warehouseId,
            this.applicantId,
            this.applicantName,
            this.unfreezeType,
            this.remark,
            this.materialInventoryId,
            this.brand,
            this.color,
            this.heatNoAndBatchNo,
            this.length,
            this.materialIsWhole,
            this.sourceProjectId,
            this.specification,
            this.theoryThickness,
            this.thickness,
            this.boolPartyA,
            this.width,
            this.standardId,
            this.standardName,
            this.monomerId,
            this.areaId,
            this.workshopId
         );
      }

      @Override
      public String toString() {
         return "MaterialUnfreeze.MaterialUnfreezeBuilder(id="
            + this.id
            + ", freezeType="
            + this.freezeType
            + ", freezeDetailId="
            + this.freezeDetailId
            + ", sourceId="
            + this.sourceId
            + ", sourceSn="
            + this.sourceSn
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", projectId="
            + this.projectId
            + ", warehouseId="
            + this.warehouseId
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", unfreezeType="
            + this.unfreezeType
            + ", remark="
            + this.remark
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", length="
            + this.length
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", sourceProjectId="
            + this.sourceProjectId
            + ", specification="
            + this.specification
            + ", theoryThickness="
            + this.theoryThickness
            + ", thickness="
            + this.thickness
            + ", boolPartyA="
            + this.boolPartyA
            + ", width="
            + this.width
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", workshopId="
            + this.workshopId
            + ")";
      }
   }
}
