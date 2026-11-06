package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "wmsPickingApproveDetail对象", description = "领料明细排产出库审核对象")
@Entity
@TableName("wms_picking_approve_detail")
@Table(name = "wms_picking_approve_detail")
public class WmsPickingApproveDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键", notes = "主键")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "pickingApproveId", value = "领料排产出库审核单ID", notes = "领料排产出库审核单ID")
   @TableField("picking_approve_id")
   @Column(name = "picking_approve_id", columnDefinition = "bigint  COMMENT '领料排产出库审核单ID'", nullable = true)
   private Long pickingApproveId;
   @ApiModelProperty(name = "pickingId", value = "领料单ID", notes = "领料单ID")
   @TableField("picking_id")
   @Column(name = "picking_id", columnDefinition = "bigint  COMMENT '领料单ID'", nullable = true)
   private Long pickingId;
   @ApiModelProperty(name = "taskOrderId", value = "工单ID", notes = "工单ID")
   @TableField("task_order_id")
   @Column(name = "task_order_id", columnDefinition = "bigint  COMMENT '工单ID'", nullable = true)
   private Long taskOrderId;
   @ApiModelProperty(name = "taskOrderNumber", value = "工单号", notes = "工单号")
   @TableField("task_order_number")
   @Column(name = "task_order_number", columnDefinition = "varchar(255)  COMMENT '工单号'", nullable = true)
   private String taskOrderNumber;
   @ApiModelProperty(name = "pickingDetailId", value = "领料明细ID", notes = "领料明细ID")
   @TableField("picking_detail_id")
   @Column(name = "picking_detail_id", columnDefinition = "varchar(255)  COMMENT '领料明细ID'", nullable = true)
   private Long pickingDetailId;
   @ApiModelProperty(name = "outId", value = "关联出库单ID", notes = "关联出库单ID")
   @TableField("out_id")
   @Column(name = "out_id", columnDefinition = "bigint  COMMENT '关联出库单ID'", nullable = true)
   private Long outId;
   @ApiModelProperty(name = "outDetailId", value = "关联出库明细ID", notes = "关联出库明细ID")
   @TableField("out_detail_id")
   @Column(name = "out_detail_id", columnDefinition = "bigint  COMMENT '关联出库明细ID'", nullable = true)
   private Long outDetailId;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "pickingDetailMaterial", value = "领料材质", notes = "领料材质")
   @TableField("picking_detail_material")
   @Column(name = "picking_detail_material", columnDefinition = "varchar(128)  COMMENT '领料材质'", nullable = true)
   private String pickingDetailMaterial;
   @ApiModelProperty(name = "pickingDetailSpecification", value = "领料规格", notes = "领料规格")
   @TableField("picking_detail_specification")
   @Column(name = "picking_detail_specification", columnDefinition = "varchar(128)  COMMENT '领料规格'", nullable = true)
   private String pickingDetailSpecification;
   @ApiModelProperty(name = "pickingDetailThickness", value = "领料厚度", notes = "领料厚度")
   @TableField("picking_detail_thickness")
   @Column(name = "picking_detail_thickness", columnDefinition = "decimal(32,8)  COMMENT '领料厚度'", nullable = true)
   private BigDecimal pickingDetailThickness;
   @ApiModelProperty(name = "pickingOutSumQuantity", value = "当前领料单关联出库明细总量", notes = "当前领料单关联出库明细总量")
   @TableField("picking_out_sum_quantity")
   @Column(name = "picking_out_sum_quantity", columnDefinition = "decimal(32,0) default '0' COMMENT '当前领料单关联出库明细总量'", nullable = true)
   private BigDecimal pickingOutSumQuantity;
   @ApiModelProperty(name = "pickingOutSumMete", value = "当前领料单关联出库明细总核算量", notes = "当前领料单关联出库明细总核算量")
   @TableField("picking_out_sum_mete")
   @Column(name = "picking_out_sum_mete", columnDefinition = "decimal(32,0) default '0' COMMENT '当前领料单关联出库明细总核算量'", nullable = true)
   private BigDecimal pickingOutSumMete;
   @ApiModelProperty(name = "pickingOutSumArea", value = "当前领料单关联出库明细总面积", notes = "当前领料单关联出库明细总面积")
   @TableField("picking_out_sum_area")
   @Column(name = "picking_out_sum_area", columnDefinition = "decimal(32,0) default '0' COMMENT '当前领料单关联出库明细总面积'", nullable = true)
   private BigDecimal pickingOutSumArea;
   @ApiModelProperty(name = "pickingOutSumLength", value = "当前领料单关联出库明细总长度", notes = "当前领料单关联出库明细总长度")
   @TableField("picking_out_sum_length")
   @Column(name = "picking_out_sum_length", columnDefinition = "decimal(32,0) default '0' COMMENT '当前领料单关联出库明细总长度'", nullable = true)
   private BigDecimal pickingOutSumLength;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型", notes = "物料基础类型")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "outSpecification", value = "出库规格", notes = "出库规格")
   @TableField("out_specification")
   @Column(name = "out_specification", columnDefinition = "varchar(128)  COMMENT '出库规格'", nullable = true)
   private String outSpecification;
   @ApiModelProperty(name = "outLength", value = "出库物料单个长度", notes = "出库物料单个长度")
   @TableField("out_length")
   @Column(name = "out_length", columnDefinition = "decimal(32,0)  COMMENT '出库物料单个长度'", nullable = true)
   private BigDecimal outLength;
   @ApiModelProperty(name = "outWidth", value = "出库物料单个宽度", notes = "出库物料单个宽度")
   @TableField("out_width")
   @Column(name = "out_width", columnDefinition = "decimal(32,0)  COMMENT '出库物料单个宽度'", nullable = true)
   private BigDecimal outWidth;
   @ApiModelProperty(name = "outThickness", value = "出库物料单个厚度", notes = "出库物料单个厚度")
   @TableField("out_thickness")
   @Column(name = "out_thickness", columnDefinition = "decimal(32,8)  COMMENT '出库物料单个厚度'", nullable = true)
   private BigDecimal outThickness;
   @ApiModelProperty(name = "outBrand", value = "出库品牌", notes = "出库品牌")
   @TableField("out_brand")
   @Column(name = "out_brand", columnDefinition = "varchar(255)  COMMENT '出库品牌'", nullable = true)
   private String outBrand;
   @ApiModelProperty(name = "outColor", value = "出库颜色", notes = "出库颜色")
   @TableField("out_color")
   @Column(name = "out_color", columnDefinition = "varchar(255)  COMMENT '出库颜色'", nullable = true)
   private String outColor;
   @ApiModelProperty(name = "outHeatNoAndBatchNo", value = "出库炉批号", notes = "出库炉批号")
   @TableField("out_heat_no_and_batch_no")
   @Column(name = "out_heat_no_and_batch_no", columnDefinition = "varchar(255)  COMMENT '出库炉批号'", nullable = true)
   private String outHeatNoAndBatchNo;
   @ApiModelProperty(name = "outBoolPartyA", value = "是否为甲供", notes = "是否为甲供")
   @TableField("out_bool_party_a")
   @Column(name = "out_bool_party_a", columnDefinition = "tinyint(1)  COMMENT '是否为甲供'", nullable = true)
   private Boolean outBoolPartyA;
   @ApiModelProperty(name = "outTheoryThickness", value = "出库理论厚", notes = "出库理论厚")
   @TableField("out_theory_thickness")
   @Column(name = "out_theory_thickness", columnDefinition = "decimal(32,8)  COMMENT '出库理论厚'", nullable = true)
   private BigDecimal outTheoryThickness;
   @ApiModelProperty(name = "outStandardId", value = "出库型材执行的国标", notes = "出库型材执行的国标")
   @TableField("out_standard_id")
   @Column(name = "out_standard_id", columnDefinition = "bigint  COMMENT '出库型材执行的国标'", nullable = true)
   private Long outStandardId;
   @ApiModelProperty(name = "outStandardName", value = "出库型材执行的国标", notes = "出库型材执行的国标")
   @TableField("out_standard_name")
   @Column(name = "out_standard_name", columnDefinition = "varchar(255)  COMMENT '出库型材执行的国标'", nullable = true)
   private String outStandardName;
   @ApiModelProperty(name = "outMaterialSn", value = "出库物料编号", notes = "出库物料编号")
   @TableField("out_material_sn")
   @Column(name = "out_material_sn", columnDefinition = "varchar(255)  COMMENT '出库物料编号'", nullable = true)
   private String outMaterialSn;
   @ApiModelProperty(name = "boolProcess", value = "是否报工 0未报工 1已报工", notes = "是否报工 0未报工 1已报工")
   @TableField("bool_process")
   @Column(name = "bool_process", columnDefinition = "tinyint(1) default '0'  COMMENT '是否报工 0未报工 1已报工'", nullable = true)
   private Boolean boolProcess;
   @ApiModelProperty(name = "boolSplit", value = "领取物料是否为拆分料 默认为否", notes = "领取物料是否为拆分料 默认为否")
   @TableField("bool_split")
   @Column(name = "bool_split", columnDefinition = "tinyint(1) default '0'  COMMENT '领取物料是否为拆分料 默认为否'", nullable = true)
   private Boolean boolSplit;

   public static WmsPickingApproveDetail.WmsPickingApproveDetailBuilder builder() {
      return new WmsPickingApproveDetail.WmsPickingApproveDetailBuilder();
   }

   public WmsPickingApproveDetail() {
   }

   public WmsPickingApproveDetail(
      final Long id,
      final Long pickingApproveId,
      final Long pickingId,
      final Long taskOrderId,
      final String taskOrderNumber,
      final Long pickingDetailId,
      final Long outId,
      final Long outDetailId,
      final Long projectId,
      final String pickingDetailMaterial,
      final String pickingDetailSpecification,
      final BigDecimal pickingDetailThickness,
      final BigDecimal pickingOutSumQuantity,
      final BigDecimal pickingOutSumMete,
      final BigDecimal pickingOutSumArea,
      final BigDecimal pickingOutSumLength,
      final Integer basicClass,
      final Long classifyId,
      final String outSpecification,
      final BigDecimal outLength,
      final BigDecimal outWidth,
      final BigDecimal outThickness,
      final String outBrand,
      final String outColor,
      final String outHeatNoAndBatchNo,
      final Boolean outBoolPartyA,
      final BigDecimal outTheoryThickness,
      final Long outStandardId,
      final String outStandardName,
      final String outMaterialSn,
      final Boolean boolProcess,
      final Boolean boolSplit
   ) {
      this.id = id;
      this.pickingApproveId = pickingApproveId;
      this.pickingId = pickingId;
      this.taskOrderId = taskOrderId;
      this.taskOrderNumber = taskOrderNumber;
      this.pickingDetailId = pickingDetailId;
      this.outId = outId;
      this.outDetailId = outDetailId;
      this.projectId = projectId;
      this.pickingDetailMaterial = pickingDetailMaterial;
      this.pickingDetailSpecification = pickingDetailSpecification;
      this.pickingDetailThickness = pickingDetailThickness;
      this.pickingOutSumQuantity = pickingOutSumQuantity;
      this.pickingOutSumMete = pickingOutSumMete;
      this.pickingOutSumArea = pickingOutSumArea;
      this.pickingOutSumLength = pickingOutSumLength;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.outSpecification = outSpecification;
      this.outLength = outLength;
      this.outWidth = outWidth;
      this.outThickness = outThickness;
      this.outBrand = outBrand;
      this.outColor = outColor;
      this.outHeatNoAndBatchNo = outHeatNoAndBatchNo;
      this.outBoolPartyA = outBoolPartyA;
      this.outTheoryThickness = outTheoryThickness;
      this.outStandardId = outStandardId;
      this.outStandardName = outStandardName;
      this.outMaterialSn = outMaterialSn;
      this.boolProcess = boolProcess;
      this.boolSplit = boolSplit;
   }

   public Long getId() {
      return this.id;
   }

   public Long getPickingApproveId() {
      return this.pickingApproveId;
   }

   public Long getPickingId() {
      return this.pickingId;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public String getTaskOrderNumber() {
      return this.taskOrderNumber;
   }

   public Long getPickingDetailId() {
      return this.pickingDetailId;
   }

   public Long getOutId() {
      return this.outId;
   }

   public Long getOutDetailId() {
      return this.outDetailId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getPickingDetailMaterial() {
      return this.pickingDetailMaterial;
   }

   public String getPickingDetailSpecification() {
      return this.pickingDetailSpecification;
   }

   public BigDecimal getPickingDetailThickness() {
      return this.pickingDetailThickness;
   }

   public BigDecimal getPickingOutSumQuantity() {
      return this.pickingOutSumQuantity;
   }

   public BigDecimal getPickingOutSumMete() {
      return this.pickingOutSumMete;
   }

   public BigDecimal getPickingOutSumArea() {
      return this.pickingOutSumArea;
   }

   public BigDecimal getPickingOutSumLength() {
      return this.pickingOutSumLength;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getOutSpecification() {
      return this.outSpecification;
   }

   public BigDecimal getOutLength() {
      return this.outLength;
   }

   public BigDecimal getOutWidth() {
      return this.outWidth;
   }

   public BigDecimal getOutThickness() {
      return this.outThickness;
   }

   public String getOutBrand() {
      return this.outBrand;
   }

   public String getOutColor() {
      return this.outColor;
   }

   public String getOutHeatNoAndBatchNo() {
      return this.outHeatNoAndBatchNo;
   }

   public Boolean getOutBoolPartyA() {
      return this.outBoolPartyA;
   }

   public BigDecimal getOutTheoryThickness() {
      return this.outTheoryThickness;
   }

   public Long getOutStandardId() {
      return this.outStandardId;
   }

   public String getOutStandardName() {
      return this.outStandardName;
   }

   public String getOutMaterialSn() {
      return this.outMaterialSn;
   }

   public Boolean getBoolProcess() {
      return this.boolProcess;
   }

   public Boolean getBoolSplit() {
      return this.boolSplit;
   }

   public WmsPickingApproveDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsPickingApproveDetail setPickingApproveId(final Long pickingApproveId) {
      this.pickingApproveId = pickingApproveId;
      return this;
   }

   public WmsPickingApproveDetail setPickingId(final Long pickingId) {
      this.pickingId = pickingId;
      return this;
   }

   public WmsPickingApproveDetail setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   public WmsPickingApproveDetail setTaskOrderNumber(final String taskOrderNumber) {
      this.taskOrderNumber = taskOrderNumber;
      return this;
   }

   public WmsPickingApproveDetail setPickingDetailId(final Long pickingDetailId) {
      this.pickingDetailId = pickingDetailId;
      return this;
   }

   public WmsPickingApproveDetail setOutId(final Long outId) {
      this.outId = outId;
      return this;
   }

   public WmsPickingApproveDetail setOutDetailId(final Long outDetailId) {
      this.outDetailId = outDetailId;
      return this;
   }

   public WmsPickingApproveDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public WmsPickingApproveDetail setPickingDetailMaterial(final String pickingDetailMaterial) {
      this.pickingDetailMaterial = pickingDetailMaterial;
      return this;
   }

   public WmsPickingApproveDetail setPickingDetailSpecification(final String pickingDetailSpecification) {
      this.pickingDetailSpecification = pickingDetailSpecification;
      return this;
   }

   public WmsPickingApproveDetail setPickingDetailThickness(final BigDecimal pickingDetailThickness) {
      this.pickingDetailThickness = pickingDetailThickness;
      return this;
   }

   public WmsPickingApproveDetail setPickingOutSumQuantity(final BigDecimal pickingOutSumQuantity) {
      this.pickingOutSumQuantity = pickingOutSumQuantity;
      return this;
   }

   public WmsPickingApproveDetail setPickingOutSumMete(final BigDecimal pickingOutSumMete) {
      this.pickingOutSumMete = pickingOutSumMete;
      return this;
   }

   public WmsPickingApproveDetail setPickingOutSumArea(final BigDecimal pickingOutSumArea) {
      this.pickingOutSumArea = pickingOutSumArea;
      return this;
   }

   public WmsPickingApproveDetail setPickingOutSumLength(final BigDecimal pickingOutSumLength) {
      this.pickingOutSumLength = pickingOutSumLength;
      return this;
   }

   public WmsPickingApproveDetail setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public WmsPickingApproveDetail setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   public WmsPickingApproveDetail setOutSpecification(final String outSpecification) {
      this.outSpecification = outSpecification;
      return this;
   }

   public WmsPickingApproveDetail setOutLength(final BigDecimal outLength) {
      this.outLength = outLength;
      return this;
   }

   public WmsPickingApproveDetail setOutWidth(final BigDecimal outWidth) {
      this.outWidth = outWidth;
      return this;
   }

   public WmsPickingApproveDetail setOutThickness(final BigDecimal outThickness) {
      this.outThickness = outThickness;
      return this;
   }

   public WmsPickingApproveDetail setOutBrand(final String outBrand) {
      this.outBrand = outBrand;
      return this;
   }

   public WmsPickingApproveDetail setOutColor(final String outColor) {
      this.outColor = outColor;
      return this;
   }

   public WmsPickingApproveDetail setOutHeatNoAndBatchNo(final String outHeatNoAndBatchNo) {
      this.outHeatNoAndBatchNo = outHeatNoAndBatchNo;
      return this;
   }

   public WmsPickingApproveDetail setOutBoolPartyA(final Boolean outBoolPartyA) {
      this.outBoolPartyA = outBoolPartyA;
      return this;
   }

   public WmsPickingApproveDetail setOutTheoryThickness(final BigDecimal outTheoryThickness) {
      this.outTheoryThickness = outTheoryThickness;
      return this;
   }

   public WmsPickingApproveDetail setOutStandardId(final Long outStandardId) {
      this.outStandardId = outStandardId;
      return this;
   }

   public WmsPickingApproveDetail setOutStandardName(final String outStandardName) {
      this.outStandardName = outStandardName;
      return this;
   }

   public WmsPickingApproveDetail setOutMaterialSn(final String outMaterialSn) {
      this.outMaterialSn = outMaterialSn;
      return this;
   }

   public WmsPickingApproveDetail setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
      return this;
   }

   public WmsPickingApproveDetail setBoolSplit(final Boolean boolSplit) {
      this.boolSplit = boolSplit;
      return this;
   }

   @Override
   public String toString() {
      return "WmsPickingApproveDetail(id="
         + this.getId()
         + ", pickingApproveId="
         + this.getPickingApproveId()
         + ", pickingId="
         + this.getPickingId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", taskOrderNumber="
         + this.getTaskOrderNumber()
         + ", pickingDetailId="
         + this.getPickingDetailId()
         + ", outId="
         + this.getOutId()
         + ", outDetailId="
         + this.getOutDetailId()
         + ", projectId="
         + this.getProjectId()
         + ", pickingDetailMaterial="
         + this.getPickingDetailMaterial()
         + ", pickingDetailSpecification="
         + this.getPickingDetailSpecification()
         + ", pickingDetailThickness="
         + this.getPickingDetailThickness()
         + ", pickingOutSumQuantity="
         + this.getPickingOutSumQuantity()
         + ", pickingOutSumMete="
         + this.getPickingOutSumMete()
         + ", pickingOutSumArea="
         + this.getPickingOutSumArea()
         + ", pickingOutSumLength="
         + this.getPickingOutSumLength()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", outSpecification="
         + this.getOutSpecification()
         + ", outLength="
         + this.getOutLength()
         + ", outWidth="
         + this.getOutWidth()
         + ", outThickness="
         + this.getOutThickness()
         + ", outBrand="
         + this.getOutBrand()
         + ", outColor="
         + this.getOutColor()
         + ", outHeatNoAndBatchNo="
         + this.getOutHeatNoAndBatchNo()
         + ", outBoolPartyA="
         + this.getOutBoolPartyA()
         + ", outTheoryThickness="
         + this.getOutTheoryThickness()
         + ", outStandardId="
         + this.getOutStandardId()
         + ", outStandardName="
         + this.getOutStandardName()
         + ", outMaterialSn="
         + this.getOutMaterialSn()
         + ", boolProcess="
         + this.getBoolProcess()
         + ", boolSplit="
         + this.getBoolSplit()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsPickingApproveDetail)) {
         return false;
      }

      WmsPickingApproveDetail other = (WmsPickingApproveDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$pickingApproveId = this.getPickingApproveId();
         Object other$pickingApproveId = other.getPickingApproveId();
         if (this$pickingApproveId == null ? other$pickingApproveId == null : this$pickingApproveId.equals(other$pickingApproveId)) {
            Object this$pickingId = this.getPickingId();
            Object other$pickingId = other.getPickingId();
            if (this$pickingId == null ? other$pickingId == null : this$pickingId.equals(other$pickingId)) {
               Object this$taskOrderId = this.getTaskOrderId();
               Object other$taskOrderId = other.getTaskOrderId();
               if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                  Object this$pickingDetailId = this.getPickingDetailId();
                  Object other$pickingDetailId = other.getPickingDetailId();
                  if (this$pickingDetailId == null ? other$pickingDetailId == null : this$pickingDetailId.equals(other$pickingDetailId)) {
                     Object this$outId = this.getOutId();
                     Object other$outId = other.getOutId();
                     if (this$outId == null ? other$outId == null : this$outId.equals(other$outId)) {
                        Object this$outDetailId = this.getOutDetailId();
                        Object other$outDetailId = other.getOutDetailId();
                        if (this$outDetailId == null ? other$outDetailId == null : this$outDetailId.equals(other$outDetailId)) {
                           Object this$projectId = this.getProjectId();
                           Object other$projectId = other.getProjectId();
                           if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                              Object this$basicClass = this.getBasicClass();
                              Object other$basicClass = other.getBasicClass();
                              if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                                 Object this$classifyId = this.getClassifyId();
                                 Object other$classifyId = other.getClassifyId();
                                 if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                                    Object this$outBoolPartyA = this.getOutBoolPartyA();
                                    Object other$outBoolPartyA = other.getOutBoolPartyA();
                                    if (this$outBoolPartyA == null ? other$outBoolPartyA == null : this$outBoolPartyA.equals(other$outBoolPartyA)) {
                                       Object this$outStandardId = this.getOutStandardId();
                                       Object other$outStandardId = other.getOutStandardId();
                                       if (this$outStandardId == null ? other$outStandardId == null : this$outStandardId.equals(other$outStandardId)) {
                                          Object this$boolProcess = this.getBoolProcess();
                                          Object other$boolProcess = other.getBoolProcess();
                                          if (this$boolProcess == null ? other$boolProcess == null : this$boolProcess.equals(other$boolProcess)) {
                                             Object this$boolSplit = this.getBoolSplit();
                                             Object other$boolSplit = other.getBoolSplit();
                                             if (this$boolSplit == null ? other$boolSplit == null : this$boolSplit.equals(other$boolSplit)) {
                                                Object this$taskOrderNumber = this.getTaskOrderNumber();
                                                Object other$taskOrderNumber = other.getTaskOrderNumber();
                                                if (this$taskOrderNumber == null
                                                   ? other$taskOrderNumber == null
                                                   : this$taskOrderNumber.equals(other$taskOrderNumber)) {
                                                   Object this$pickingDetailMaterial = this.getPickingDetailMaterial();
                                                   Object other$pickingDetailMaterial = other.getPickingDetailMaterial();
                                                   if (this$pickingDetailMaterial == null
                                                      ? other$pickingDetailMaterial == null
                                                      : this$pickingDetailMaterial.equals(other$pickingDetailMaterial)) {
                                                      Object this$pickingDetailSpecification = this.getPickingDetailSpecification();
                                                      Object other$pickingDetailSpecification = other.getPickingDetailSpecification();
                                                      if (this$pickingDetailSpecification == null
                                                         ? other$pickingDetailSpecification == null
                                                         : this$pickingDetailSpecification.equals(other$pickingDetailSpecification)) {
                                                         Object this$pickingDetailThickness = this.getPickingDetailThickness();
                                                         Object other$pickingDetailThickness = other.getPickingDetailThickness();
                                                         if (this$pickingDetailThickness == null
                                                            ? other$pickingDetailThickness == null
                                                            : this$pickingDetailThickness.equals(other$pickingDetailThickness)) {
                                                            Object this$pickingOutSumQuantity = this.getPickingOutSumQuantity();
                                                            Object other$pickingOutSumQuantity = other.getPickingOutSumQuantity();
                                                            if (this$pickingOutSumQuantity == null
                                                               ? other$pickingOutSumQuantity == null
                                                               : this$pickingOutSumQuantity.equals(other$pickingOutSumQuantity)) {
                                                               Object this$pickingOutSumMete = this.getPickingOutSumMete();
                                                               Object other$pickingOutSumMete = other.getPickingOutSumMete();
                                                               if (this$pickingOutSumMete == null
                                                                  ? other$pickingOutSumMete == null
                                                                  : this$pickingOutSumMete.equals(other$pickingOutSumMete)) {
                                                                  Object this$pickingOutSumArea = this.getPickingOutSumArea();
                                                                  Object other$pickingOutSumArea = other.getPickingOutSumArea();
                                                                  if (this$pickingOutSumArea == null
                                                                     ? other$pickingOutSumArea == null
                                                                     : this$pickingOutSumArea.equals(other$pickingOutSumArea)) {
                                                                     Object this$pickingOutSumLength = this.getPickingOutSumLength();
                                                                     Object other$pickingOutSumLength = other.getPickingOutSumLength();
                                                                     if (this$pickingOutSumLength == null
                                                                        ? other$pickingOutSumLength == null
                                                                        : this$pickingOutSumLength.equals(other$pickingOutSumLength)) {
                                                                        Object this$outSpecification = this.getOutSpecification();
                                                                        Object other$outSpecification = other.getOutSpecification();
                                                                        if (this$outSpecification == null
                                                                           ? other$outSpecification == null
                                                                           : this$outSpecification.equals(other$outSpecification)) {
                                                                           Object this$outLength = this.getOutLength();
                                                                           Object other$outLength = other.getOutLength();
                                                                           if (this$outLength == null
                                                                              ? other$outLength == null
                                                                              : this$outLength.equals(other$outLength)) {
                                                                              Object this$outWidth = this.getOutWidth();
                                                                              Object other$outWidth = other.getOutWidth();
                                                                              if (this$outWidth == null
                                                                                 ? other$outWidth == null
                                                                                 : this$outWidth.equals(other$outWidth)) {
                                                                                 Object this$outThickness = this.getOutThickness();
                                                                                 Object other$outThickness = other.getOutThickness();
                                                                                 if (this$outThickness == null
                                                                                    ? other$outThickness == null
                                                                                    : this$outThickness.equals(other$outThickness)) {
                                                                                    Object this$outBrand = this.getOutBrand();
                                                                                    Object other$outBrand = other.getOutBrand();
                                                                                    if (this$outBrand == null
                                                                                       ? other$outBrand == null
                                                                                       : this$outBrand.equals(other$outBrand)) {
                                                                                       Object this$outColor = this.getOutColor();
                                                                                       Object other$outColor = other.getOutColor();
                                                                                       if (this$outColor == null
                                                                                          ? other$outColor == null
                                                                                          : this$outColor.equals(other$outColor)) {
                                                                                          Object this$outHeatNoAndBatchNo = this.getOutHeatNoAndBatchNo();
                                                                                          Object other$outHeatNoAndBatchNo = other.getOutHeatNoAndBatchNo();
                                                                                          if (this$outHeatNoAndBatchNo == null
                                                                                             ? other$outHeatNoAndBatchNo == null
                                                                                             : this$outHeatNoAndBatchNo.equals(other$outHeatNoAndBatchNo)) {
                                                                                             Object this$outTheoryThickness = this.getOutTheoryThickness();
                                                                                             Object other$outTheoryThickness = other.getOutTheoryThickness();
                                                                                             if (this$outTheoryThickness == null
                                                                                                ? other$outTheoryThickness == null
                                                                                                : this$outTheoryThickness.equals(other$outTheoryThickness)) {
                                                                                                Object this$outStandardName = this.getOutStandardName();
                                                                                                Object other$outStandardName = other.getOutStandardName();
                                                                                                if (this$outStandardName == null
                                                                                                   ? other$outStandardName == null
                                                                                                   : this$outStandardName.equals(other$outStandardName)) {
                                                                                                   Object this$outMaterialSn = this.getOutMaterialSn();
                                                                                                   Object other$outMaterialSn = other.getOutMaterialSn();
                                                                                                   return this$outMaterialSn == null
                                                                                                      ? other$outMaterialSn == null
                                                                                                      : this$outMaterialSn.equals(other$outMaterialSn);
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof WmsPickingApproveDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $pickingApproveId = this.getPickingApproveId();
      result = result * 59 + ($pickingApproveId == null ? 43 : $pickingApproveId.hashCode());
      Object $pickingId = this.getPickingId();
      result = result * 59 + ($pickingId == null ? 43 : $pickingId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $pickingDetailId = this.getPickingDetailId();
      result = result * 59 + ($pickingDetailId == null ? 43 : $pickingDetailId.hashCode());
      Object $outId = this.getOutId();
      result = result * 59 + ($outId == null ? 43 : $outId.hashCode());
      Object $outDetailId = this.getOutDetailId();
      result = result * 59 + ($outDetailId == null ? 43 : $outDetailId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $outBoolPartyA = this.getOutBoolPartyA();
      result = result * 59 + ($outBoolPartyA == null ? 43 : $outBoolPartyA.hashCode());
      Object $outStandardId = this.getOutStandardId();
      result = result * 59 + ($outStandardId == null ? 43 : $outStandardId.hashCode());
      Object $boolProcess = this.getBoolProcess();
      result = result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
      Object $boolSplit = this.getBoolSplit();
      result = result * 59 + ($boolSplit == null ? 43 : $boolSplit.hashCode());
      Object $taskOrderNumber = this.getTaskOrderNumber();
      result = result * 59 + ($taskOrderNumber == null ? 43 : $taskOrderNumber.hashCode());
      Object $pickingDetailMaterial = this.getPickingDetailMaterial();
      result = result * 59 + ($pickingDetailMaterial == null ? 43 : $pickingDetailMaterial.hashCode());
      Object $pickingDetailSpecification = this.getPickingDetailSpecification();
      result = result * 59 + ($pickingDetailSpecification == null ? 43 : $pickingDetailSpecification.hashCode());
      Object $pickingDetailThickness = this.getPickingDetailThickness();
      result = result * 59 + ($pickingDetailThickness == null ? 43 : $pickingDetailThickness.hashCode());
      Object $pickingOutSumQuantity = this.getPickingOutSumQuantity();
      result = result * 59 + ($pickingOutSumQuantity == null ? 43 : $pickingOutSumQuantity.hashCode());
      Object $pickingOutSumMete = this.getPickingOutSumMete();
      result = result * 59 + ($pickingOutSumMete == null ? 43 : $pickingOutSumMete.hashCode());
      Object $pickingOutSumArea = this.getPickingOutSumArea();
      result = result * 59 + ($pickingOutSumArea == null ? 43 : $pickingOutSumArea.hashCode());
      Object $pickingOutSumLength = this.getPickingOutSumLength();
      result = result * 59 + ($pickingOutSumLength == null ? 43 : $pickingOutSumLength.hashCode());
      Object $outSpecification = this.getOutSpecification();
      result = result * 59 + ($outSpecification == null ? 43 : $outSpecification.hashCode());
      Object $outLength = this.getOutLength();
      result = result * 59 + ($outLength == null ? 43 : $outLength.hashCode());
      Object $outWidth = this.getOutWidth();
      result = result * 59 + ($outWidth == null ? 43 : $outWidth.hashCode());
      Object $outThickness = this.getOutThickness();
      result = result * 59 + ($outThickness == null ? 43 : $outThickness.hashCode());
      Object $outBrand = this.getOutBrand();
      result = result * 59 + ($outBrand == null ? 43 : $outBrand.hashCode());
      Object $outColor = this.getOutColor();
      result = result * 59 + ($outColor == null ? 43 : $outColor.hashCode());
      Object $outHeatNoAndBatchNo = this.getOutHeatNoAndBatchNo();
      result = result * 59 + ($outHeatNoAndBatchNo == null ? 43 : $outHeatNoAndBatchNo.hashCode());
      Object $outTheoryThickness = this.getOutTheoryThickness();
      result = result * 59 + ($outTheoryThickness == null ? 43 : $outTheoryThickness.hashCode());
      Object $outStandardName = this.getOutStandardName();
      result = result * 59 + ($outStandardName == null ? 43 : $outStandardName.hashCode());
      Object $outMaterialSn = this.getOutMaterialSn();
      return result * 59 + ($outMaterialSn == null ? 43 : $outMaterialSn.hashCode());
   }

   public static class WmsPickingApproveDetailBuilder {
      private Long id;
      private Long pickingApproveId;
      private Long pickingId;
      private Long taskOrderId;
      private String taskOrderNumber;
      private Long pickingDetailId;
      private Long outId;
      private Long outDetailId;
      private Long projectId;
      private String pickingDetailMaterial;
      private String pickingDetailSpecification;
      private BigDecimal pickingDetailThickness;
      private BigDecimal pickingOutSumQuantity;
      private BigDecimal pickingOutSumMete;
      private BigDecimal pickingOutSumArea;
      private BigDecimal pickingOutSumLength;
      private Integer basicClass;
      private Long classifyId;
      private String outSpecification;
      private BigDecimal outLength;
      private BigDecimal outWidth;
      private BigDecimal outThickness;
      private String outBrand;
      private String outColor;
      private String outHeatNoAndBatchNo;
      private Boolean outBoolPartyA;
      private BigDecimal outTheoryThickness;
      private Long outStandardId;
      private String outStandardName;
      private String outMaterialSn;
      private Boolean boolProcess;
      private Boolean boolSplit;

      WmsPickingApproveDetailBuilder() {
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder pickingApproveId(final Long pickingApproveId) {
         this.pickingApproveId = pickingApproveId;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder pickingId(final Long pickingId) {
         this.pickingId = pickingId;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder taskOrderNumber(final String taskOrderNumber) {
         this.taskOrderNumber = taskOrderNumber;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder pickingDetailId(final Long pickingDetailId) {
         this.pickingDetailId = pickingDetailId;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder outId(final Long outId) {
         this.outId = outId;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder outDetailId(final Long outDetailId) {
         this.outDetailId = outDetailId;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder pickingDetailMaterial(final String pickingDetailMaterial) {
         this.pickingDetailMaterial = pickingDetailMaterial;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder pickingDetailSpecification(final String pickingDetailSpecification) {
         this.pickingDetailSpecification = pickingDetailSpecification;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder pickingDetailThickness(final BigDecimal pickingDetailThickness) {
         this.pickingDetailThickness = pickingDetailThickness;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder pickingOutSumQuantity(final BigDecimal pickingOutSumQuantity) {
         this.pickingOutSumQuantity = pickingOutSumQuantity;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder pickingOutSumMete(final BigDecimal pickingOutSumMete) {
         this.pickingOutSumMete = pickingOutSumMete;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder pickingOutSumArea(final BigDecimal pickingOutSumArea) {
         this.pickingOutSumArea = pickingOutSumArea;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder pickingOutSumLength(final BigDecimal pickingOutSumLength) {
         this.pickingOutSumLength = pickingOutSumLength;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder outSpecification(final String outSpecification) {
         this.outSpecification = outSpecification;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder outLength(final BigDecimal outLength) {
         this.outLength = outLength;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder outWidth(final BigDecimal outWidth) {
         this.outWidth = outWidth;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder outThickness(final BigDecimal outThickness) {
         this.outThickness = outThickness;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder outBrand(final String outBrand) {
         this.outBrand = outBrand;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder outColor(final String outColor) {
         this.outColor = outColor;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder outHeatNoAndBatchNo(final String outHeatNoAndBatchNo) {
         this.outHeatNoAndBatchNo = outHeatNoAndBatchNo;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder outBoolPartyA(final Boolean outBoolPartyA) {
         this.outBoolPartyA = outBoolPartyA;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder outTheoryThickness(final BigDecimal outTheoryThickness) {
         this.outTheoryThickness = outTheoryThickness;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder outStandardId(final Long outStandardId) {
         this.outStandardId = outStandardId;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder outStandardName(final String outStandardName) {
         this.outStandardName = outStandardName;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder outMaterialSn(final String outMaterialSn) {
         this.outMaterialSn = outMaterialSn;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder boolProcess(final Boolean boolProcess) {
         this.boolProcess = boolProcess;
         return this;
      }

      public WmsPickingApproveDetail.WmsPickingApproveDetailBuilder boolSplit(final Boolean boolSplit) {
         this.boolSplit = boolSplit;
         return this;
      }

      public WmsPickingApproveDetail build() {
         return new WmsPickingApproveDetail(
            this.id,
            this.pickingApproveId,
            this.pickingId,
            this.taskOrderId,
            this.taskOrderNumber,
            this.pickingDetailId,
            this.outId,
            this.outDetailId,
            this.projectId,
            this.pickingDetailMaterial,
            this.pickingDetailSpecification,
            this.pickingDetailThickness,
            this.pickingOutSumQuantity,
            this.pickingOutSumMete,
            this.pickingOutSumArea,
            this.pickingOutSumLength,
            this.basicClass,
            this.classifyId,
            this.outSpecification,
            this.outLength,
            this.outWidth,
            this.outThickness,
            this.outBrand,
            this.outColor,
            this.outHeatNoAndBatchNo,
            this.outBoolPartyA,
            this.outTheoryThickness,
            this.outStandardId,
            this.outStandardName,
            this.outMaterialSn,
            this.boolProcess,
            this.boolSplit
         );
      }

      @Override
      public String toString() {
         return "WmsPickingApproveDetail.WmsPickingApproveDetailBuilder(id="
            + this.id
            + ", pickingApproveId="
            + this.pickingApproveId
            + ", pickingId="
            + this.pickingId
            + ", taskOrderId="
            + this.taskOrderId
            + ", taskOrderNumber="
            + this.taskOrderNumber
            + ", pickingDetailId="
            + this.pickingDetailId
            + ", outId="
            + this.outId
            + ", outDetailId="
            + this.outDetailId
            + ", projectId="
            + this.projectId
            + ", pickingDetailMaterial="
            + this.pickingDetailMaterial
            + ", pickingDetailSpecification="
            + this.pickingDetailSpecification
            + ", pickingDetailThickness="
            + this.pickingDetailThickness
            + ", pickingOutSumQuantity="
            + this.pickingOutSumQuantity
            + ", pickingOutSumMete="
            + this.pickingOutSumMete
            + ", pickingOutSumArea="
            + this.pickingOutSumArea
            + ", pickingOutSumLength="
            + this.pickingOutSumLength
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", outSpecification="
            + this.outSpecification
            + ", outLength="
            + this.outLength
            + ", outWidth="
            + this.outWidth
            + ", outThickness="
            + this.outThickness
            + ", outBrand="
            + this.outBrand
            + ", outColor="
            + this.outColor
            + ", outHeatNoAndBatchNo="
            + this.outHeatNoAndBatchNo
            + ", outBoolPartyA="
            + this.outBoolPartyA
            + ", outTheoryThickness="
            + this.outTheoryThickness
            + ", outStandardId="
            + this.outStandardId
            + ", outStandardName="
            + this.outStandardName
            + ", outMaterialSn="
            + this.outMaterialSn
            + ", boolProcess="
            + this.boolProcess
            + ", boolSplit="
            + this.boolSplit
            + ")";
      }
   }
}
