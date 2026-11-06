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
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "WmsConvert对象", description = "")
@Entity
@TableName("wms_convert")
@Table(name = "wms_convert")
public class Convert extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "materialInventoryId", value = "物料池ID")
   @JsonProperty("materialInventoryId")
   @JSONField(name = "materialInventoryId")
   @TableField("material_Inventory_id")
   @Column(name = "material_Inventory_id")
   private Long materialInventoryId;
   @ApiModelProperty(name = "receiptSerialNumber", value = "单据编号")
   @JsonProperty("receiptSerialNumber")
   @JSONField(name = "receiptSerialNumber")
   @TableField("receipt_serial_number")
   @Column(name = "receipt_serial_number")
   private String receiptSerialNumber;
   @ApiModelProperty(name = "outboundId", value = "出库单ID")
   @JsonProperty("outboundId")
   @JSONField(name = "outboundId")
   @TableField("outbound_id")
   @Column(name = "outbound_id")
   private Long outboundId;
   @ApiModelProperty(name = "outSerialNumber", value = "审核出库单编号")
   @JsonProperty("outSerialNumber")
   @JSONField(name = "outSerialNumber")
   @TableField("out_serial_number")
   @Column(name = "out_serial_number")
   private String outSerialNumber;
   @ApiModelProperty(name = "brand", value = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand")
   private String brand;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification")
   private String specification;
   @ApiModelProperty(name = "serialNumber", value = "物料编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number")
   private String serialNumber;
   @ApiModelProperty(name = "classifyId", value = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id")
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   @TableField("classify_name")
   @Column(name = "classify_name")
   private String classifyName;
   @ApiModelProperty(name = "width", value = "宽度")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width")
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "color", value = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @TableField("color")
   @Column(name = "color")
   private String color;
   @ApiModelProperty(name = "heatNoAndBatchNo", value = "炉批号")
   @JsonProperty("heatNoAndBatchNo")
   @JSONField(name = "heatNoAndBatchNo")
   @TableField("heat_no_and_batch_no")
   @Column(name = "heat_no_and_batch_no")
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "warehouseId", value = "仓库ID")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id")
   private Long warehouseId;
   @ApiModelProperty(name = "projectId", value = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "status", value = "审核状态 1未审核 2已审核 4拒绝 8撤销 ReviewStatusEnum")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(11) default '2' COMMENT '审核状态'", nullable = false)
   private Integer status;
   @ApiModelProperty(name = "mete", value = "总核算量,钢材为当前物料总核算,辅材为单个的核算")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "reviewerId", value = "审核人ID")
   @JsonProperty("reviewerId")
   @JSONField(name = "reviewerId")
   @TableField("reviewer_id")
   @Column(name = "reviewer_id")
   private Long reviewerId;
   @ApiModelProperty(name = "reviewerName", value = "审核人名称")
   @JsonProperty("reviewerName")
   @JSONField(name = "reviewerName")
   @TableField("reviewer_name")
   @Column(name = "reviewer_name")
   private String reviewerName;
   @ApiModelProperty(name = "reviewTime", value = "审核时间")
   @JsonProperty("reviewTime")
   @JSONField(name = "reviewTime")
   @TableField("review_time")
   @Column(name = "review_time")
   private LocalDateTime reviewTime;
   @ApiModelProperty(name = "applyUserId", value = "申请人id")
   @JsonProperty("applyUserId")
   @JSONField(name = "applyUserId")
   @TableField("apply_user_id")
   @Column(name = "apply_user_id")
   private Long applyUserId;
   @ApiModelProperty(name = "applyUserName", value = "申请人名字")
   @JsonProperty("applyUserName")
   @JSONField(name = "applyUserName")
   @TableField("apply_user_name")
   @Column(name = "apply_user_name")
   private String applyUserName;
   @ApiModelProperty(name = "applyTime", value = "申请时间")
   @JsonProperty("applyTime")
   @JSONField(name = "applyTime")
   @TableField("apply_time")
   @Column(name = "apply_time")
   private LocalDate applyTime;
   @ApiModelProperty(name = "warehouseType", value = "仓库类型[1 公共库,2 项目库]")
   @JsonProperty("warehouseType")
   @JSONField(name = "warehouseType")
   @TableField("warehouse_type")
   @Column(name = "warehouse_type")
   private Integer warehouseType;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "amountExcludingVat", value = "转换总金额（不含税）")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_VAT")
   @Column(name = "amount_excluding_VAT")
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity")
   private BigDecimal quantity;
   @ApiModelProperty(name = "boolPartyA", value = "是否甲供物料")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a")
   private Boolean boolPartyA;
   @ApiModelProperty(name = "approveRecordId", value = "审批日志ID", notes = "审批日志ID")
   @JsonProperty("approveRecordId")
   @JSONField(name = "approveRecordId")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint  COMMENT '审批日志ID'", nullable = true)
   private Long approveRecordId;

   public static Convert.ConvertBuilder builder() {
      return new Convert.ConvertBuilder();
   }

   public Convert() {
   }

   public Convert(
      final Long id,
      final Long materialInventoryId,
      final String receiptSerialNumber,
      final Long outboundId,
      final String outSerialNumber,
      final String brand,
      final String specification,
      final String serialNumber,
      final Long classifyId,
      final String classifyName,
      final BigDecimal width,
      final BigDecimal thickness,
      final String color,
      final String heatNoAndBatchNo,
      final Long warehouseId,
      final Long projectId,
      final Integer status,
      final BigDecimal mete,
      final Long reviewerId,
      final String reviewerName,
      final LocalDateTime reviewTime,
      final Long applyUserId,
      final String applyUserName,
      final LocalDate applyTime,
      final Integer warehouseType,
      final String remark,
      final BigDecimal amountExcludingVat,
      final BigDecimal quantity,
      final Boolean boolPartyA,
      final Long approveRecordId
   ) {
      this.id = id;
      this.materialInventoryId = materialInventoryId;
      this.receiptSerialNumber = receiptSerialNumber;
      this.outboundId = outboundId;
      this.outSerialNumber = outSerialNumber;
      this.brand = brand;
      this.specification = specification;
      this.serialNumber = serialNumber;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.width = width;
      this.thickness = thickness;
      this.color = color;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.warehouseId = warehouseId;
      this.projectId = projectId;
      this.status = status;
      this.mete = mete;
      this.reviewerId = reviewerId;
      this.reviewerName = reviewerName;
      this.reviewTime = reviewTime;
      this.applyUserId = applyUserId;
      this.applyUserName = applyUserName;
      this.applyTime = applyTime;
      this.warehouseType = warehouseType;
      this.remark = remark;
      this.amountExcludingVat = amountExcludingVat;
      this.quantity = quantity;
      this.boolPartyA = boolPartyA;
      this.approveRecordId = approveRecordId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public String getReceiptSerialNumber() {
      return this.receiptSerialNumber;
   }

   public Long getOutboundId() {
      return this.outboundId;
   }

   public String getOutSerialNumber() {
      return this.outSerialNumber;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getColor() {
      return this.color;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getStatus() {
      return this.status;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public Long getApplyUserId() {
      return this.applyUserId;
   }

   public String getApplyUserName() {
      return this.applyUserName;
   }

   public LocalDate getApplyTime() {
      return this.applyTime;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public Convert setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("materialInventoryId")
   public Convert setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
      return this;
   }

   @JsonProperty("receiptSerialNumber")
   public Convert setReceiptSerialNumber(final String receiptSerialNumber) {
      this.receiptSerialNumber = receiptSerialNumber;
      return this;
   }

   @JsonProperty("outboundId")
   public Convert setOutboundId(final Long outboundId) {
      this.outboundId = outboundId;
      return this;
   }

   @JsonProperty("outSerialNumber")
   public Convert setOutSerialNumber(final String outSerialNumber) {
      this.outSerialNumber = outSerialNumber;
      return this;
   }

   @JsonProperty("brand")
   public Convert setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("specification")
   public Convert setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("serialNumber")
   public Convert setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("classifyId")
   public Convert setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("classifyName")
   public Convert setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("width")
   public Convert setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public Convert setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("color")
   public Convert setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public Convert setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("warehouseId")
   public Convert setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("projectId")
   public Convert setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("status")
   public Convert setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("mete")
   public Convert setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("reviewerId")
   public Convert setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
      return this;
   }

   @JsonProperty("reviewerName")
   public Convert setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
      return this;
   }

   @JsonProperty("reviewTime")
   public Convert setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
      return this;
   }

   @JsonProperty("applyUserId")
   public Convert setApplyUserId(final Long applyUserId) {
      this.applyUserId = applyUserId;
      return this;
   }

   @JsonProperty("applyUserName")
   public Convert setApplyUserName(final String applyUserName) {
      this.applyUserName = applyUserName;
      return this;
   }

   @JsonProperty("applyTime")
   public Convert setApplyTime(final LocalDate applyTime) {
      this.applyTime = applyTime;
      return this;
   }

   @JsonProperty("warehouseType")
   public Convert setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   @JsonProperty("remark")
   public Convert setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public Convert setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("quantity")
   public Convert setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("boolPartyA")
   public Convert setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("approveRecordId")
   public Convert setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   @Override
   public String toString() {
      return "Convert(id="
         + this.getId()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", receiptSerialNumber="
         + this.getReceiptSerialNumber()
         + ", outboundId="
         + this.getOutboundId()
         + ", outSerialNumber="
         + this.getOutSerialNumber()
         + ", brand="
         + this.getBrand()
         + ", specification="
         + this.getSpecification()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", color="
         + this.getColor()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", projectId="
         + this.getProjectId()
         + ", status="
         + this.getStatus()
         + ", mete="
         + this.getMete()
         + ", reviewerId="
         + this.getReviewerId()
         + ", reviewerName="
         + this.getReviewerName()
         + ", reviewTime="
         + this.getReviewTime()
         + ", applyUserId="
         + this.getApplyUserId()
         + ", applyUserName="
         + this.getApplyUserName()
         + ", applyTime="
         + this.getApplyTime()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", remark="
         + this.getRemark()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", quantity="
         + this.getQuantity()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Convert)) {
         return false;
      }

      Convert other = (Convert)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$materialInventoryId = this.getMaterialInventoryId();
         Object other$materialInventoryId = other.getMaterialInventoryId();
         if (this$materialInventoryId == null ? other$materialInventoryId == null : this$materialInventoryId.equals(other$materialInventoryId)) {
            Object this$outboundId = this.getOutboundId();
            Object other$outboundId = other.getOutboundId();
            if (this$outboundId == null ? other$outboundId == null : this$outboundId.equals(other$outboundId)) {
               Object this$classifyId = this.getClassifyId();
               Object other$classifyId = other.getClassifyId();
               if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                  Object this$warehouseId = this.getWarehouseId();
                  Object other$warehouseId = other.getWarehouseId();
                  if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                           Object this$reviewerId = this.getReviewerId();
                           Object other$reviewerId = other.getReviewerId();
                           if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
                              Object this$applyUserId = this.getApplyUserId();
                              Object other$applyUserId = other.getApplyUserId();
                              if (this$applyUserId == null ? other$applyUserId == null : this$applyUserId.equals(other$applyUserId)) {
                                 Object this$warehouseType = this.getWarehouseType();
                                 Object other$warehouseType = other.getWarehouseType();
                                 if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
                                    Object this$boolPartyA = this.getBoolPartyA();
                                    Object other$boolPartyA = other.getBoolPartyA();
                                    if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                                       Object this$approveRecordId = this.getApproveRecordId();
                                       Object other$approveRecordId = other.getApproveRecordId();
                                       if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                                          Object this$receiptSerialNumber = this.getReceiptSerialNumber();
                                          Object other$receiptSerialNumber = other.getReceiptSerialNumber();
                                          if (this$receiptSerialNumber == null
                                             ? other$receiptSerialNumber == null
                                             : this$receiptSerialNumber.equals(other$receiptSerialNumber)) {
                                             Object this$outSerialNumber = this.getOutSerialNumber();
                                             Object other$outSerialNumber = other.getOutSerialNumber();
                                             if (this$outSerialNumber == null
                                                ? other$outSerialNumber == null
                                                : this$outSerialNumber.equals(other$outSerialNumber)) {
                                                Object this$brand = this.getBrand();
                                                Object other$brand = other.getBrand();
                                                if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                   Object this$specification = this.getSpecification();
                                                   Object other$specification = other.getSpecification();
                                                   if (this$specification == null
                                                      ? other$specification == null
                                                      : this$specification.equals(other$specification)) {
                                                      Object this$serialNumber = this.getSerialNumber();
                                                      Object other$serialNumber = other.getSerialNumber();
                                                      if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)
                                                         )
                                                       {
                                                         Object this$classifyName = this.getClassifyName();
                                                         Object other$classifyName = other.getClassifyName();
                                                         if (this$classifyName == null
                                                            ? other$classifyName == null
                                                            : this$classifyName.equals(other$classifyName)) {
                                                            Object this$width = this.getWidth();
                                                            Object other$width = other.getWidth();
                                                            if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                               Object this$thickness = this.getThickness();
                                                               Object other$thickness = other.getThickness();
                                                               if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                                  Object this$color = this.getColor();
                                                                  Object other$color = other.getColor();
                                                                  if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                     Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                     Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                     if (this$heatNoAndBatchNo == null
                                                                        ? other$heatNoAndBatchNo == null
                                                                        : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                        Object this$mete = this.getMete();
                                                                        Object other$mete = other.getMete();
                                                                        if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                           Object this$reviewerName = this.getReviewerName();
                                                                           Object other$reviewerName = other.getReviewerName();
                                                                           if (this$reviewerName == null
                                                                              ? other$reviewerName == null
                                                                              : this$reviewerName.equals(other$reviewerName)) {
                                                                              Object this$reviewTime = this.getReviewTime();
                                                                              Object other$reviewTime = other.getReviewTime();
                                                                              if (this$reviewTime == null
                                                                                 ? other$reviewTime == null
                                                                                 : this$reviewTime.equals(other$reviewTime)) {
                                                                                 Object this$applyUserName = this.getApplyUserName();
                                                                                 Object other$applyUserName = other.getApplyUserName();
                                                                                 if (this$applyUserName == null
                                                                                    ? other$applyUserName == null
                                                                                    : this$applyUserName.equals(other$applyUserName)) {
                                                                                    Object this$applyTime = this.getApplyTime();
                                                                                    Object other$applyTime = other.getApplyTime();
                                                                                    if (this$applyTime == null
                                                                                       ? other$applyTime == null
                                                                                       : this$applyTime.equals(other$applyTime)) {
                                                                                       Object this$remark = this.getRemark();
                                                                                       Object other$remark = other.getRemark();
                                                                                       if (this$remark == null
                                                                                          ? other$remark == null
                                                                                          : this$remark.equals(other$remark)) {
                                                                                          Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                                          Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                                          if (this$amountExcludingVat == null
                                                                                             ? other$amountExcludingVat == null
                                                                                             : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                                                                             Object this$quantity = this.getQuantity();
                                                                                             Object other$quantity = other.getQuantity();
                                                                                             return this$quantity == null
                                                                                                ? other$quantity == null
                                                                                                : this$quantity.equals(other$quantity);
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof Convert;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $outboundId = this.getOutboundId();
      result = result * 59 + ($outboundId == null ? 43 : $outboundId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $applyUserId = this.getApplyUserId();
      result = result * 59 + ($applyUserId == null ? 43 : $applyUserId.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $receiptSerialNumber = this.getReceiptSerialNumber();
      result = result * 59 + ($receiptSerialNumber == null ? 43 : $receiptSerialNumber.hashCode());
      Object $outSerialNumber = this.getOutSerialNumber();
      result = result * 59 + ($outSerialNumber == null ? 43 : $outSerialNumber.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $applyUserName = this.getApplyUserName();
      result = result * 59 + ($applyUserName == null ? 43 : $applyUserName.hashCode());
      Object $applyTime = this.getApplyTime();
      result = result * 59 + ($applyTime == null ? 43 : $applyTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   public static class ConvertBuilder {
      private Long id;
      private Long materialInventoryId;
      private String receiptSerialNumber;
      private Long outboundId;
      private String outSerialNumber;
      private String brand;
      private String specification;
      private String serialNumber;
      private Long classifyId;
      private String classifyName;
      private BigDecimal width;
      private BigDecimal thickness;
      private String color;
      private String heatNoAndBatchNo;
      private Long warehouseId;
      private Long projectId;
      private Integer status;
      private BigDecimal mete;
      private Long reviewerId;
      private String reviewerName;
      private LocalDateTime reviewTime;
      private Long applyUserId;
      private String applyUserName;
      private LocalDate applyTime;
      private Integer warehouseType;
      private String remark;
      private BigDecimal amountExcludingVat;
      private BigDecimal quantity;
      private Boolean boolPartyA;
      private Long approveRecordId;

      ConvertBuilder() {
      }

      public Convert.ConvertBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("materialInventoryId")
      public Convert.ConvertBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      @JsonProperty("receiptSerialNumber")
      public Convert.ConvertBuilder receiptSerialNumber(final String receiptSerialNumber) {
         this.receiptSerialNumber = receiptSerialNumber;
         return this;
      }

      @JsonProperty("outboundId")
      public Convert.ConvertBuilder outboundId(final Long outboundId) {
         this.outboundId = outboundId;
         return this;
      }

      @JsonProperty("outSerialNumber")
      public Convert.ConvertBuilder outSerialNumber(final String outSerialNumber) {
         this.outSerialNumber = outSerialNumber;
         return this;
      }

      @JsonProperty("brand")
      public Convert.ConvertBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("specification")
      public Convert.ConvertBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("serialNumber")
      public Convert.ConvertBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("classifyId")
      public Convert.ConvertBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public Convert.ConvertBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("width")
      public Convert.ConvertBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public Convert.ConvertBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("color")
      public Convert.ConvertBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public Convert.ConvertBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("warehouseId")
      public Convert.ConvertBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("projectId")
      public Convert.ConvertBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("status")
      public Convert.ConvertBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("mete")
      public Convert.ConvertBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("reviewerId")
      public Convert.ConvertBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      @JsonProperty("reviewerName")
      public Convert.ConvertBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      @JsonProperty("reviewTime")
      public Convert.ConvertBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      @JsonProperty("applyUserId")
      public Convert.ConvertBuilder applyUserId(final Long applyUserId) {
         this.applyUserId = applyUserId;
         return this;
      }

      @JsonProperty("applyUserName")
      public Convert.ConvertBuilder applyUserName(final String applyUserName) {
         this.applyUserName = applyUserName;
         return this;
      }

      @JsonProperty("applyTime")
      public Convert.ConvertBuilder applyTime(final LocalDate applyTime) {
         this.applyTime = applyTime;
         return this;
      }

      @JsonProperty("warehouseType")
      public Convert.ConvertBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      @JsonProperty("remark")
      public Convert.ConvertBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public Convert.ConvertBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("quantity")
      public Convert.ConvertBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("boolPartyA")
      public Convert.ConvertBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("approveRecordId")
      public Convert.ConvertBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public Convert build() {
         return new Convert(
            this.id,
            this.materialInventoryId,
            this.receiptSerialNumber,
            this.outboundId,
            this.outSerialNumber,
            this.brand,
            this.specification,
            this.serialNumber,
            this.classifyId,
            this.classifyName,
            this.width,
            this.thickness,
            this.color,
            this.heatNoAndBatchNo,
            this.warehouseId,
            this.projectId,
            this.status,
            this.mete,
            this.reviewerId,
            this.reviewerName,
            this.reviewTime,
            this.applyUserId,
            this.applyUserName,
            this.applyTime,
            this.warehouseType,
            this.remark,
            this.amountExcludingVat,
            this.quantity,
            this.boolPartyA,
            this.approveRecordId
         );
      }

      @Override
      public String toString() {
         return "Convert.ConvertBuilder(id="
            + this.id
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", receiptSerialNumber="
            + this.receiptSerialNumber
            + ", outboundId="
            + this.outboundId
            + ", outSerialNumber="
            + this.outSerialNumber
            + ", brand="
            + this.brand
            + ", specification="
            + this.specification
            + ", serialNumber="
            + this.serialNumber
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", color="
            + this.color
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", warehouseId="
            + this.warehouseId
            + ", projectId="
            + this.projectId
            + ", status="
            + this.status
            + ", mete="
            + this.mete
            + ", reviewerId="
            + this.reviewerId
            + ", reviewerName="
            + this.reviewerName
            + ", reviewTime="
            + this.reviewTime
            + ", applyUserId="
            + this.applyUserId
            + ", applyUserName="
            + this.applyUserName
            + ", applyTime="
            + this.applyTime
            + ", warehouseType="
            + this.warehouseType
            + ", remark="
            + this.remark
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", quantity="
            + this.quantity
            + ", boolPartyA="
            + this.boolPartyA
            + ", approveRecordId="
            + this.approveRecordId
            + ")";
      }
   }
}
