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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "PartyABorrow对象", description = "甲供借用归还")
@Entity
@TableName("wms_party_a_borrow")
@Table(name = "wms_party_a_borrow")
public class PartyABorrow extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
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
   @ApiModelProperty(name = "materialInventoryId", value = "物料仓库ID", notes = "物料仓库ID")
   @JsonProperty("materialInventoryId")
   @JSONField(name = "materialInventoryId")
   @TableField("material_inventory_id")
   @Column(name = "material_inventory_id", columnDefinition = "bigint  COMMENT '物料仓库ID'", nullable = true)
   private Long materialInventoryId;
   @ApiModelProperty(name = "returnedMete", value = "归还核算量", notes = "归还核算量")
   @JsonProperty("returnedMete")
   @JSONField(name = "returnedMete")
   @TableField("returned_mete")
   @Column(name = "returned_mete", columnDefinition = "decimal(32,8)  COMMENT '归还核算量'", nullable = true)
   private BigDecimal returnedMete;
   @ApiModelProperty(name = "returnedQuantity", value = "归还数量", notes = "归还数量")
   @JsonProperty("returnedQuantity")
   @JSONField(name = "returnedQuantity")
   @TableField("returned_quantity")
   @Column(name = "returned_quantity", columnDefinition = "decimal(32,8)  COMMENT '归还数量'", nullable = true)
   private BigDecimal returnedQuantity;
   @ApiModelProperty(name = "underReviewMete", value = "归还审核中核算量", notes = "归还审核中核算量")
   @JsonProperty("underReviewMete")
   @JSONField(name = "underReviewMete")
   @TableField("under_review_mete")
   @Column(name = "under_review_mete", columnDefinition = "decimal(32,8)  COMMENT '归还审核中核算量'", nullable = true)
   private BigDecimal underReviewMete;
   @ApiModelProperty(name = "underReviewQuantity", value = "归还审核中数量", notes = "归还审核中数量")
   @JsonProperty("underReviewQuantity")
   @JSONField(name = "underReviewQuantity")
   @TableField("under_review_quantity")
   @Column(name = "under_review_quantity", columnDefinition = "decimal(32,8)  COMMENT '归还审核中数量'", nullable = true)
   private BigDecimal underReviewQuantity;
   @ApiModelProperty(name = "mete", value = "借出核算量", notes = "借出核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '借出核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "quantity", value = "借出数量", notes = "借出数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '借出数量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "projectId", value = "原项目ID", notes = "原项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '原项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "borrowProjectId", value = "借用项目ID", notes = "借用项目ID")
   @JsonProperty("borrowProjectId")
   @JSONField(name = "borrowProjectId")
   @TableField("borrow_project_id")
   @Column(name = "borrow_project_id", columnDefinition = "bigint  COMMENT '借用项目ID'", nullable = true)
   private Long borrowProjectId;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "returnStatus", value = "归还状态", notes = "归还状态")
   @JsonProperty("returnStatus")
   @JSONField(name = "returnStatus")
   @TableField("return_status")
   @Column(name = "return_status", columnDefinition = "int  COMMENT '归还状态'", nullable = true)
   private Integer returnStatus;
   @ApiModelProperty(name = "borrowTransferId", value = "借用调拨单ID", notes = "借用调拨单ID")
   @JsonProperty("borrowTransferId")
   @JSONField(name = "borrowTransferId")
   @TableField("borrow_transfer_id")
   @Column(name = "borrow_transfer_id", columnDefinition = "bigint  COMMENT '借用调拨单ID'", nullable = true)
   private Long borrowTransferId;
   @ApiModelProperty(name = "returnTransferIds", value = "归还调拨单ID集", notes = "归还调拨单ID集")
   @JsonProperty("returnTransferIds")
   @JSONField(name = "returnTransferIds")
   @TableField("return_transfer_ids")
   @Column(name = "return_transfer_ids", columnDefinition = "varchar(255)  COMMENT '归还调拨单ID集'", nullable = true)
   private String returnTransferIds;
   @ApiModelProperty(name = "transferId", value = "借用人id", notes = "借用人id")
   @JsonProperty("transferId")
   @JSONField(name = "transferId")
   @TableField("transfer_id")
   @Column(name = "transfer_id", columnDefinition = "bigint  COMMENT '借用人id'", nullable = true)
   private Long transferId;
   @ApiModelProperty(name = "transferName", value = "借用人名称", notes = "借用人名称")
   @JsonProperty("transferName")
   @JSONField(name = "transferName")
   @TableField("transfer_name")
   @Column(name = "transfer_name", columnDefinition = "varchar(128)  COMMENT '借用人名称'", nullable = true)
   private String transferName;
   @ApiModelProperty(name = "transferTime", value = "借用时间", notes = "借用时间")
   @JsonProperty("transferTime")
   @JSONField(name = "transferTime")
   @TableField("transfer_time")
   @Column(name = "transfer_time", columnDefinition = "datetime  COMMENT '借用时间'", nullable = true)
   private LocalDateTime transferTime;
   @ApiModelProperty(name = "basicClass", value = "基础分类", notes = "基础分类")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '基础分类'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "length", value = "长", notes = "长")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,8)  COMMENT '长'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "宽", notes = "宽")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,8)  COMMENT '宽'", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚度", notes = "厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8)  COMMENT '厚度'", nullable = true)
   private BigDecimal thickness;
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
   @ApiModelProperty(name = "returnTime")
   @JsonProperty("returnTime")
   @JSONField(name = "returnTime")
   @TableField("return_time")
   @Column(name = "return_time", columnDefinition = "datetime(6)  COMMENT '归还时间'", nullable = true)
   private LocalDateTime returnTime;
   @ApiModelProperty(name = "materialSn")
   @JsonProperty("materialSn")
   @JSONField(name = "materialSn")
   @TableField("material_sn")
   @Column(name = "material_sn", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String materialSn;

   public static PartyABorrow.PartyABorrowBuilder builder() {
      return new PartyABorrow.PartyABorrowBuilder();
   }

   public PartyABorrow() {
   }

   public PartyABorrow(
      final Long id,
      final Long classifyId,
      final Long materialInventoryId,
      final BigDecimal returnedMete,
      final BigDecimal returnedQuantity,
      final BigDecimal underReviewMete,
      final BigDecimal underReviewQuantity,
      final BigDecimal mete,
      final BigDecimal quantity,
      final Long projectId,
      final Long borrowProjectId,
      final String remark,
      final Integer returnStatus,
      final Long borrowTransferId,
      final String returnTransferIds,
      final Long transferId,
      final String transferName,
      final LocalDateTime transferTime,
      final Integer basicClass,
      final String specification,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final Long standardId,
      final String standardName,
      final LocalDateTime returnTime,
      final String materialSn
   ) {
      this.id = id;
      this.classifyId = classifyId;
      this.materialInventoryId = materialInventoryId;
      this.returnedMete = returnedMete;
      this.returnedQuantity = returnedQuantity;
      this.underReviewMete = underReviewMete;
      this.underReviewQuantity = underReviewQuantity;
      this.mete = mete;
      this.quantity = quantity;
      this.projectId = projectId;
      this.borrowProjectId = borrowProjectId;
      this.remark = remark;
      this.returnStatus = returnStatus;
      this.borrowTransferId = borrowTransferId;
      this.returnTransferIds = returnTransferIds;
      this.transferId = transferId;
      this.transferName = transferName;
      this.transferTime = transferTime;
      this.basicClass = basicClass;
      this.specification = specification;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.standardId = standardId;
      this.standardName = standardName;
      this.returnTime = returnTime;
      this.materialSn = materialSn;
   }

   public Long getId() {
      return this.id;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public BigDecimal getReturnedMete() {
      return this.returnedMete;
   }

   public BigDecimal getReturnedQuantity() {
      return this.returnedQuantity;
   }

   public BigDecimal getUnderReviewMete() {
      return this.underReviewMete;
   }

   public BigDecimal getUnderReviewQuantity() {
      return this.underReviewQuantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getBorrowProjectId() {
      return this.borrowProjectId;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getReturnStatus() {
      return this.returnStatus;
   }

   public Long getBorrowTransferId() {
      return this.borrowTransferId;
   }

   public String getReturnTransferIds() {
      return this.returnTransferIds;
   }

   public Long getTransferId() {
      return this.transferId;
   }

   public String getTransferName() {
      return this.transferName;
   }

   public LocalDateTime getTransferTime() {
      return this.transferTime;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecification() {
      return this.specification;
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

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public LocalDateTime getReturnTime() {
      return this.returnTime;
   }

   public String getMaterialSn() {
      return this.materialSn;
   }

   @JsonProperty("id")
   public PartyABorrow setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("classifyId")
   public PartyABorrow setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("materialInventoryId")
   public PartyABorrow setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
      return this;
   }

   @JsonProperty("returnedMete")
   public PartyABorrow setReturnedMete(final BigDecimal returnedMete) {
      this.returnedMete = returnedMete;
      return this;
   }

   @JsonProperty("returnedQuantity")
   public PartyABorrow setReturnedQuantity(final BigDecimal returnedQuantity) {
      this.returnedQuantity = returnedQuantity;
      return this;
   }

   @JsonProperty("underReviewMete")
   public PartyABorrow setUnderReviewMete(final BigDecimal underReviewMete) {
      this.underReviewMete = underReviewMete;
      return this;
   }

   @JsonProperty("underReviewQuantity")
   public PartyABorrow setUnderReviewQuantity(final BigDecimal underReviewQuantity) {
      this.underReviewQuantity = underReviewQuantity;
      return this;
   }

   @JsonProperty("mete")
   public PartyABorrow setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("quantity")
   public PartyABorrow setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("projectId")
   public PartyABorrow setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("borrowProjectId")
   public PartyABorrow setBorrowProjectId(final Long borrowProjectId) {
      this.borrowProjectId = borrowProjectId;
      return this;
   }

   @JsonProperty("remark")
   public PartyABorrow setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("returnStatus")
   public PartyABorrow setReturnStatus(final Integer returnStatus) {
      this.returnStatus = returnStatus;
      return this;
   }

   @JsonProperty("borrowTransferId")
   public PartyABorrow setBorrowTransferId(final Long borrowTransferId) {
      this.borrowTransferId = borrowTransferId;
      return this;
   }

   @JsonProperty("returnTransferIds")
   public PartyABorrow setReturnTransferIds(final String returnTransferIds) {
      this.returnTransferIds = returnTransferIds;
      return this;
   }

   @JsonProperty("transferId")
   public PartyABorrow setTransferId(final Long transferId) {
      this.transferId = transferId;
      return this;
   }

   @JsonProperty("transferName")
   public PartyABorrow setTransferName(final String transferName) {
      this.transferName = transferName;
      return this;
   }

   @JsonProperty("transferTime")
   public PartyABorrow setTransferTime(final LocalDateTime transferTime) {
      this.transferTime = transferTime;
      return this;
   }

   @JsonProperty("basicClass")
   public PartyABorrow setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("specification")
   public PartyABorrow setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public PartyABorrow setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public PartyABorrow setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public PartyABorrow setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("brand")
   public PartyABorrow setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public PartyABorrow setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("color")
   public PartyABorrow setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("standardId")
   public PartyABorrow setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("standardName")
   public PartyABorrow setStandardName(final String standardName) {
      this.standardName = standardName;
      return this;
   }

   @JsonProperty("returnTime")
   public PartyABorrow setReturnTime(final LocalDateTime returnTime) {
      this.returnTime = returnTime;
      return this;
   }

   @JsonProperty("materialSn")
   public PartyABorrow setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
      return this;
   }

   @Override
   public String toString() {
      return "PartyABorrow(id="
         + this.getId()
         + ", classifyId="
         + this.getClassifyId()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", returnedMete="
         + this.getReturnedMete()
         + ", returnedQuantity="
         + this.getReturnedQuantity()
         + ", underReviewMete="
         + this.getUnderReviewMete()
         + ", underReviewQuantity="
         + this.getUnderReviewQuantity()
         + ", mete="
         + this.getMete()
         + ", quantity="
         + this.getQuantity()
         + ", projectId="
         + this.getProjectId()
         + ", borrowProjectId="
         + this.getBorrowProjectId()
         + ", remark="
         + this.getRemark()
         + ", returnStatus="
         + this.getReturnStatus()
         + ", borrowTransferId="
         + this.getBorrowTransferId()
         + ", returnTransferIds="
         + this.getReturnTransferIds()
         + ", transferId="
         + this.getTransferId()
         + ", transferName="
         + this.getTransferName()
         + ", transferTime="
         + this.getTransferTime()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", returnTime="
         + this.getReturnTime()
         + ", materialSn="
         + this.getMaterialSn()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PartyABorrow)) {
         return false;
      }

      PartyABorrow other = (PartyABorrow)o;
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
            Object this$materialInventoryId = this.getMaterialInventoryId();
            Object other$materialInventoryId = other.getMaterialInventoryId();
            if (this$materialInventoryId == null ? other$materialInventoryId == null : this$materialInventoryId.equals(other$materialInventoryId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$borrowProjectId = this.getBorrowProjectId();
                  Object other$borrowProjectId = other.getBorrowProjectId();
                  if (this$borrowProjectId == null ? other$borrowProjectId == null : this$borrowProjectId.equals(other$borrowProjectId)) {
                     Object this$returnStatus = this.getReturnStatus();
                     Object other$returnStatus = other.getReturnStatus();
                     if (this$returnStatus == null ? other$returnStatus == null : this$returnStatus.equals(other$returnStatus)) {
                        Object this$borrowTransferId = this.getBorrowTransferId();
                        Object other$borrowTransferId = other.getBorrowTransferId();
                        if (this$borrowTransferId == null ? other$borrowTransferId == null : this$borrowTransferId.equals(other$borrowTransferId)) {
                           Object this$transferId = this.getTransferId();
                           Object other$transferId = other.getTransferId();
                           if (this$transferId == null ? other$transferId == null : this$transferId.equals(other$transferId)) {
                              Object this$basicClass = this.getBasicClass();
                              Object other$basicClass = other.getBasicClass();
                              if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                                 Object this$standardId = this.getStandardId();
                                 Object other$standardId = other.getStandardId();
                                 if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                    Object this$returnedMete = this.getReturnedMete();
                                    Object other$returnedMete = other.getReturnedMete();
                                    if (this$returnedMete == null ? other$returnedMete == null : this$returnedMete.equals(other$returnedMete)) {
                                       Object this$returnedQuantity = this.getReturnedQuantity();
                                       Object other$returnedQuantity = other.getReturnedQuantity();
                                       if (this$returnedQuantity == null
                                          ? other$returnedQuantity == null
                                          : this$returnedQuantity.equals(other$returnedQuantity)) {
                                          Object this$underReviewMete = this.getUnderReviewMete();
                                          Object other$underReviewMete = other.getUnderReviewMete();
                                          if (this$underReviewMete == null ? other$underReviewMete == null : this$underReviewMete.equals(other$underReviewMete)
                                             )
                                           {
                                             Object this$underReviewQuantity = this.getUnderReviewQuantity();
                                             Object other$underReviewQuantity = other.getUnderReviewQuantity();
                                             if (this$underReviewQuantity == null
                                                ? other$underReviewQuantity == null
                                                : this$underReviewQuantity.equals(other$underReviewQuantity)) {
                                                Object this$mete = this.getMete();
                                                Object other$mete = other.getMete();
                                                if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                   Object this$quantity = this.getQuantity();
                                                   Object other$quantity = other.getQuantity();
                                                   if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                      Object this$remark = this.getRemark();
                                                      Object other$remark = other.getRemark();
                                                      if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                         Object this$returnTransferIds = this.getReturnTransferIds();
                                                         Object other$returnTransferIds = other.getReturnTransferIds();
                                                         if (this$returnTransferIds == null
                                                            ? other$returnTransferIds == null
                                                            : this$returnTransferIds.equals(other$returnTransferIds)) {
                                                            Object this$transferName = this.getTransferName();
                                                            Object other$transferName = other.getTransferName();
                                                            if (this$transferName == null
                                                               ? other$transferName == null
                                                               : this$transferName.equals(other$transferName)) {
                                                               Object this$transferTime = this.getTransferTime();
                                                               Object other$transferTime = other.getTransferTime();
                                                               if (this$transferTime == null
                                                                  ? other$transferTime == null
                                                                  : this$transferTime.equals(other$transferTime)) {
                                                                  Object this$specification = this.getSpecification();
                                                                  Object other$specification = other.getSpecification();
                                                                  if (this$specification == null
                                                                     ? other$specification == null
                                                                     : this$specification.equals(other$specification)) {
                                                                     Object this$length = this.getLength();
                                                                     Object other$length = other.getLength();
                                                                     if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                        Object this$width = this.getWidth();
                                                                        Object other$width = other.getWidth();
                                                                        if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                                           Object this$thickness = this.getThickness();
                                                                           Object other$thickness = other.getThickness();
                                                                           if (this$thickness == null
                                                                              ? other$thickness == null
                                                                              : this$thickness.equals(other$thickness)) {
                                                                              Object this$brand = this.getBrand();
                                                                              Object other$brand = other.getBrand();
                                                                              if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
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
                                                                                          Object this$returnTime = this.getReturnTime();
                                                                                          Object other$returnTime = other.getReturnTime();
                                                                                          if (this$returnTime == null
                                                                                             ? other$returnTime == null
                                                                                             : this$returnTime.equals(other$returnTime)) {
                                                                                             Object this$materialSn = this.getMaterialSn();
                                                                                             Object other$materialSn = other.getMaterialSn();
                                                                                             return this$materialSn == null
                                                                                                ? other$materialSn == null
                                                                                                : this$materialSn.equals(other$materialSn);
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof PartyABorrow;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $borrowProjectId = this.getBorrowProjectId();
      result = result * 59 + ($borrowProjectId == null ? 43 : $borrowProjectId.hashCode());
      Object $returnStatus = this.getReturnStatus();
      result = result * 59 + ($returnStatus == null ? 43 : $returnStatus.hashCode());
      Object $borrowTransferId = this.getBorrowTransferId();
      result = result * 59 + ($borrowTransferId == null ? 43 : $borrowTransferId.hashCode());
      Object $transferId = this.getTransferId();
      result = result * 59 + ($transferId == null ? 43 : $transferId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $returnedMete = this.getReturnedMete();
      result = result * 59 + ($returnedMete == null ? 43 : $returnedMete.hashCode());
      Object $returnedQuantity = this.getReturnedQuantity();
      result = result * 59 + ($returnedQuantity == null ? 43 : $returnedQuantity.hashCode());
      Object $underReviewMete = this.getUnderReviewMete();
      result = result * 59 + ($underReviewMete == null ? 43 : $underReviewMete.hashCode());
      Object $underReviewQuantity = this.getUnderReviewQuantity();
      result = result * 59 + ($underReviewQuantity == null ? 43 : $underReviewQuantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $returnTransferIds = this.getReturnTransferIds();
      result = result * 59 + ($returnTransferIds == null ? 43 : $returnTransferIds.hashCode());
      Object $transferName = this.getTransferName();
      result = result * 59 + ($transferName == null ? 43 : $transferName.hashCode());
      Object $transferTime = this.getTransferTime();
      result = result * 59 + ($transferTime == null ? 43 : $transferTime.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $returnTime = this.getReturnTime();
      result = result * 59 + ($returnTime == null ? 43 : $returnTime.hashCode());
      Object $materialSn = this.getMaterialSn();
      return result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
   }

   public static class PartyABorrowBuilder {
      private Long id;
      private Long classifyId;
      private Long materialInventoryId;
      private BigDecimal returnedMete;
      private BigDecimal returnedQuantity;
      private BigDecimal underReviewMete;
      private BigDecimal underReviewQuantity;
      private BigDecimal mete;
      private BigDecimal quantity;
      private Long projectId;
      private Long borrowProjectId;
      private String remark;
      private Integer returnStatus;
      private Long borrowTransferId;
      private String returnTransferIds;
      private Long transferId;
      private String transferName;
      private LocalDateTime transferTime;
      private Integer basicClass;
      private String specification;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private Long standardId;
      private String standardName;
      private LocalDateTime returnTime;
      private String materialSn;

      PartyABorrowBuilder() {
      }

      @JsonProperty("id")
      public PartyABorrow.PartyABorrowBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("classifyId")
      public PartyABorrow.PartyABorrowBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("materialInventoryId")
      public PartyABorrow.PartyABorrowBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      @JsonProperty("returnedMete")
      public PartyABorrow.PartyABorrowBuilder returnedMete(final BigDecimal returnedMete) {
         this.returnedMete = returnedMete;
         return this;
      }

      @JsonProperty("returnedQuantity")
      public PartyABorrow.PartyABorrowBuilder returnedQuantity(final BigDecimal returnedQuantity) {
         this.returnedQuantity = returnedQuantity;
         return this;
      }

      @JsonProperty("underReviewMete")
      public PartyABorrow.PartyABorrowBuilder underReviewMete(final BigDecimal underReviewMete) {
         this.underReviewMete = underReviewMete;
         return this;
      }

      @JsonProperty("underReviewQuantity")
      public PartyABorrow.PartyABorrowBuilder underReviewQuantity(final BigDecimal underReviewQuantity) {
         this.underReviewQuantity = underReviewQuantity;
         return this;
      }

      @JsonProperty("mete")
      public PartyABorrow.PartyABorrowBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("quantity")
      public PartyABorrow.PartyABorrowBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("projectId")
      public PartyABorrow.PartyABorrowBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("borrowProjectId")
      public PartyABorrow.PartyABorrowBuilder borrowProjectId(final Long borrowProjectId) {
         this.borrowProjectId = borrowProjectId;
         return this;
      }

      @JsonProperty("remark")
      public PartyABorrow.PartyABorrowBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("returnStatus")
      public PartyABorrow.PartyABorrowBuilder returnStatus(final Integer returnStatus) {
         this.returnStatus = returnStatus;
         return this;
      }

      @JsonProperty("borrowTransferId")
      public PartyABorrow.PartyABorrowBuilder borrowTransferId(final Long borrowTransferId) {
         this.borrowTransferId = borrowTransferId;
         return this;
      }

      @JsonProperty("returnTransferIds")
      public PartyABorrow.PartyABorrowBuilder returnTransferIds(final String returnTransferIds) {
         this.returnTransferIds = returnTransferIds;
         return this;
      }

      @JsonProperty("transferId")
      public PartyABorrow.PartyABorrowBuilder transferId(final Long transferId) {
         this.transferId = transferId;
         return this;
      }

      @JsonProperty("transferName")
      public PartyABorrow.PartyABorrowBuilder transferName(final String transferName) {
         this.transferName = transferName;
         return this;
      }

      @JsonProperty("transferTime")
      public PartyABorrow.PartyABorrowBuilder transferTime(final LocalDateTime transferTime) {
         this.transferTime = transferTime;
         return this;
      }

      @JsonProperty("basicClass")
      public PartyABorrow.PartyABorrowBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("specification")
      public PartyABorrow.PartyABorrowBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public PartyABorrow.PartyABorrowBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public PartyABorrow.PartyABorrowBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public PartyABorrow.PartyABorrowBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("brand")
      public PartyABorrow.PartyABorrowBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public PartyABorrow.PartyABorrowBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("color")
      public PartyABorrow.PartyABorrowBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("standardId")
      public PartyABorrow.PartyABorrowBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("standardName")
      public PartyABorrow.PartyABorrowBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      @JsonProperty("returnTime")
      public PartyABorrow.PartyABorrowBuilder returnTime(final LocalDateTime returnTime) {
         this.returnTime = returnTime;
         return this;
      }

      @JsonProperty("materialSn")
      public PartyABorrow.PartyABorrowBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      public PartyABorrow build() {
         return new PartyABorrow(
            this.id,
            this.classifyId,
            this.materialInventoryId,
            this.returnedMete,
            this.returnedQuantity,
            this.underReviewMete,
            this.underReviewQuantity,
            this.mete,
            this.quantity,
            this.projectId,
            this.borrowProjectId,
            this.remark,
            this.returnStatus,
            this.borrowTransferId,
            this.returnTransferIds,
            this.transferId,
            this.transferName,
            this.transferTime,
            this.basicClass,
            this.specification,
            this.length,
            this.width,
            this.thickness,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.standardId,
            this.standardName,
            this.returnTime,
            this.materialSn
         );
      }

      @Override
      public String toString() {
         return "PartyABorrow.PartyABorrowBuilder(id="
            + this.id
            + ", classifyId="
            + this.classifyId
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", returnedMete="
            + this.returnedMete
            + ", returnedQuantity="
            + this.returnedQuantity
            + ", underReviewMete="
            + this.underReviewMete
            + ", underReviewQuantity="
            + this.underReviewQuantity
            + ", mete="
            + this.mete
            + ", quantity="
            + this.quantity
            + ", projectId="
            + this.projectId
            + ", borrowProjectId="
            + this.borrowProjectId
            + ", remark="
            + this.remark
            + ", returnStatus="
            + this.returnStatus
            + ", borrowTransferId="
            + this.borrowTransferId
            + ", returnTransferIds="
            + this.returnTransferIds
            + ", transferId="
            + this.transferId
            + ", transferName="
            + this.transferName
            + ", transferTime="
            + this.transferTime
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", returnTime="
            + this.returnTime
            + ", materialSn="
            + this.materialSn
            + ")";
      }
   }
}
