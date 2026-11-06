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

@ApiModel(value = "Reject对象", description = "退货表")
@Entity
@TableName("wms_reject")
@Table(name = "wms_reject")
public class Reject extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "basicClass", value = "基础类型", notes = "基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "editorId", value = "最后编辑人ID", notes = "最后编辑人ID")
   @JsonProperty("editorId")
   @JSONField(name = "editorId")
   @TableField("editor_id")
   @Column(name = "editor_id", columnDefinition = "bigint  COMMENT '最后编辑人ID'", nullable = true)
   private Long editorId;
   @ApiModelProperty(name = "editorName", value = "最后编辑人", notes = "最后编辑人")
   @JsonProperty("editorName")
   @JSONField(name = "editorName")
   @TableField("editor_name")
   @Column(name = "editor_name", columnDefinition = "varchar(255)  COMMENT '最后编辑人'", nullable = true)
   private String editorName;
   @ApiModelProperty(name = "applicantId", value = "申请人ID", notes = "申请人ID")
   @JsonProperty("applicantId")
   @JSONField(name = "applicantId")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint  COMMENT '申请人ID'", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称", notes = "申请人名称")
   @JsonProperty("applicantName")
   @JSONField(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(255)  COMMENT '申请人名称'", nullable = true)
   private String applicantName;
   @ApiModelProperty(name = "inboundId", value = "入库单ID", notes = "入库单ID")
   @JsonProperty("inboundId")
   @JSONField(name = "inboundId")
   @TableField("inbound_id")
   @Column(name = "inbound_id", columnDefinition = "bigint  COMMENT '入库单ID'", nullable = true)
   private Long inboundId;
   @ApiModelProperty(name = "inboundSn", value = "入库单编号", notes = "入库单编号")
   @JsonProperty("inboundSn")
   @JSONField(name = "inboundSn")
   @TableField("inbound_sn")
   @Column(name = "inbound_sn", columnDefinition = "varchar(255)  COMMENT '入库单编号'", nullable = true)
   private String inboundSn;
   @ApiModelProperty(name = "projectIds", value = "项目ID集", notes = "项目ID集")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   @TableField("project_ids")
   @Column(name = "project_ids", columnDefinition = "varchar(255)  COMMENT '项目ID集'", nullable = true)
   private String projectIds;
   @ApiModelProperty(name = "purchaseOrderId", value = "采购单ID", notes = "采购单ID")
   @JsonProperty("purchaseOrderId")
   @JSONField(name = "purchaseOrderId")
   @TableField("purchase_order_id")
   @Column(name = "purchase_order_id", columnDefinition = "bigint  COMMENT '采购单ID'", nullable = true)
   private Long purchaseOrderId;
   @ApiModelProperty(name = "purchaseSn", value = "采购单编号", notes = "采购单编号")
   @JsonProperty("purchaseSn")
   @JSONField(name = "purchaseSn")
   @TableField("purchase_sn")
   @Column(name = "purchase_sn", columnDefinition = "varchar(255)  COMMENT '采购单编号'", nullable = true)
   private String purchaseSn;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态", notes = "审核状态")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int  COMMENT '审核状态'", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "reviewerId", value = "审核人ID", notes = "审核人ID")
   @JsonProperty("reviewerId")
   @JSONField(name = "reviewerId")
   @TableField("reviewer_id")
   @Column(name = "reviewer_id", columnDefinition = "bigint  COMMENT '审核人ID'", nullable = true)
   private Long reviewerId;
   @ApiModelProperty(name = "reviewerName", value = "审核人名称", notes = "审核人名称")
   @JsonProperty("reviewerName")
   @JSONField(name = "reviewerName")
   @TableField("reviewer_name")
   @Column(name = "reviewer_name", columnDefinition = "varchar(255)  COMMENT '审核人名称'", nullable = true)
   private String reviewerName;
   @ApiModelProperty(name = "serialNumber", value = "退货单号", notes = "退货单号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '退货单号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "shipmentNumber", value = "物流单号", notes = "物流单号")
   @JsonProperty("shipmentNumber")
   @JSONField(name = "shipmentNumber")
   @TableField("shipment_number")
   @Column(name = "shipment_number", columnDefinition = "varchar(255)  COMMENT '物流单号'", nullable = true)
   private String shipmentNumber;
   @ApiModelProperty(name = "supplierId", value = "供应商ID", notes = "供应商ID")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint  COMMENT '供应商ID'", nullable = true)
   private Long supplierId;
   @ApiModelProperty(name = "userUpdateTime", value = "用户修改时间", notes = "用户修改时间")
   @JsonProperty("userUpdateTime")
   @JSONField(name = "userUpdateTime")
   @TableField("user_update_time")
   @Column(name = "user_update_time", columnDefinition = "datetime  COMMENT '用户修改时间'", nullable = true)
   private LocalDateTime userUpdateTime;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "approvalComments", value = "审批意见", notes = "审批意见")
   @JsonProperty("approvalComments")
   @JSONField(name = "approvalComments")
   @TableField("approval_comments")
   @Column(name = "approval_comments", columnDefinition = "text  COMMENT '审批意见'", nullable = true)
   private String approvalComments;
   @ApiModelProperty(name = "amount", value = "总价", notes = "总价")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "amountNoFreight", value = "总价不含运费", notes = "总价不含运费")
   @JsonProperty("amountNoFreight")
   @JSONField(name = "amountNoFreight")
   @TableField("amount_no_freight")
   @Column(name = "amount_no_freight", columnDefinition = "decimal(32,12)  COMMENT '总价不含运费'", nullable = true)
   private BigDecimal amountNoFreight;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税总价", notes = "不含税总价")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_vat")
   @Column(name = "amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '不含税总价'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "amountExcludingVatNoFreight", value = "不含税总价不含运费", notes = "不含税总价不含运费")
   @JsonProperty("amountExcludingVatNoFreight")
   @JSONField(name = "amountExcludingVatNoFreight")
   @TableField("amount_excluding_vat_no_freight")
   @Column(name = "amount_excluding_vat_no_freight", columnDefinition = "decimal(32,12)  COMMENT '不含税总价不含运费'", nullable = true)
   private BigDecimal amountExcludingVatNoFreight;
   @ApiModelProperty(name = "reviewTime", value = "审核时间", notes = "审核时间")
   @JsonProperty("reviewTime")
   @JSONField(name = "reviewTime")
   @TableField("review_time")
   @Column(name = "review_time", columnDefinition = "datetime  COMMENT '审核时间'", nullable = true)
   private LocalDateTime reviewTime;
   @ApiModelProperty(name = "rejectFreightType", value = "退运费处理方式", notes = "退运费处理方式 1、保留运费 2、退运费 RejectFreightTypeEnum")
   @JsonProperty("rejectFreightType")
   @JSONField(name = "rejectFreightType")
   @TableField("reject_freight_type")
   @Column(name = "reject_freight_type", columnDefinition = "int  COMMENT '退运费处理方式 1、保留运费 2、退运费 RejectFreightTypeEnum'", nullable = true)
   private Integer rejectFreightType;
   @ApiModelProperty(name = "freight", value = "所退运费金额", notes = "所退运费金额")
   @JsonProperty("freight")
   @JSONField(name = "freight")
   @TableField("freight")
   @Column(name = "freight", columnDefinition = "decimal(32,12)  COMMENT '所退运费金额'", nullable = true)
   private BigDecimal freight;
   @ApiModelProperty(name = "freightExcludingVat", value = "所退运费金额 不含税", notes = "所退运费金额 不含税")
   @JsonProperty("freightExcludingVat")
   @JSONField(name = "freightExcludingVat")
   @TableField("freight_excluding_vat")
   @Column(name = "freight_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '所退运费金额 不含税'", nullable = true)
   private BigDecimal freightExcludingVat;
   @ApiModelProperty(name = "approveRecordId", value = "审批日志ID", notes = "审批日志ID")
   @JsonProperty("approveRecordId")
   @JSONField(name = "approveRecordId")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint  COMMENT '审批日志ID'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty(name = "boolPrinted", value = "是否打印")
   @JsonProperty("boolPrinted")
   @JSONField(name = "boolPrinted")
   @TableField("bool_printed")
   @Column(name = "bool_printed", nullable = false, columnDefinition = "tinyint(1) default 0 COMMENT '是否打印: 0 未打印,1 打印'")
   private Boolean boolPrinted;

   public static Reject.RejectBuilder builder() {
      return new Reject.RejectBuilder();
   }

   public Reject() {
   }

   public Reject(
      final Long id,
      final Integer basicClass,
      final Long editorId,
      final String editorName,
      final Long applicantId,
      final String applicantName,
      final Long inboundId,
      final String inboundSn,
      final String projectIds,
      final Long purchaseOrderId,
      final String purchaseSn,
      final Integer reviewStatus,
      final Long reviewerId,
      final String reviewerName,
      final String serialNumber,
      final String shipmentNumber,
      final Long supplierId,
      final LocalDateTime userUpdateTime,
      final String remark,
      final String approvalComments,
      final BigDecimal amount,
      final BigDecimal amountNoFreight,
      final BigDecimal amountExcludingVat,
      final BigDecimal amountExcludingVatNoFreight,
      final LocalDateTime reviewTime,
      final Integer rejectFreightType,
      final BigDecimal freight,
      final BigDecimal freightExcludingVat,
      final Long approveRecordId,
      final Boolean boolPrinted
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.editorId = editorId;
      this.editorName = editorName;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.inboundId = inboundId;
      this.inboundSn = inboundSn;
      this.projectIds = projectIds;
      this.purchaseOrderId = purchaseOrderId;
      this.purchaseSn = purchaseSn;
      this.reviewStatus = reviewStatus;
      this.reviewerId = reviewerId;
      this.reviewerName = reviewerName;
      this.serialNumber = serialNumber;
      this.shipmentNumber = shipmentNumber;
      this.supplierId = supplierId;
      this.userUpdateTime = userUpdateTime;
      this.remark = remark;
      this.approvalComments = approvalComments;
      this.amount = amount;
      this.amountNoFreight = amountNoFreight;
      this.amountExcludingVat = amountExcludingVat;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.reviewTime = reviewTime;
      this.rejectFreightType = rejectFreightType;
      this.freight = freight;
      this.freightExcludingVat = freightExcludingVat;
      this.approveRecordId = approveRecordId;
      this.boolPrinted = boolPrinted;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getEditorId() {
      return this.editorId;
   }

   public String getEditorName() {
      return this.editorName;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public String getInboundSn() {
      return this.inboundSn;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public Long getPurchaseOrderId() {
      return this.purchaseOrderId;
   }

   public String getPurchaseSn() {
      return this.purchaseSn;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getShipmentNumber() {
      return this.shipmentNumber;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getApprovalComments() {
      return this.approvalComments;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getAmountExcludingVatNoFreight() {
      return this.amountExcludingVatNoFreight;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public Integer getRejectFreightType() {
      return this.rejectFreightType;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public BigDecimal getFreightExcludingVat() {
      return this.freightExcludingVat;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public Boolean getBoolPrinted() {
      return this.boolPrinted;
   }

   @JsonProperty("id")
   public Reject setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("basicClass")
   public Reject setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("editorId")
   public Reject setEditorId(final Long editorId) {
      this.editorId = editorId;
      return this;
   }

   @JsonProperty("editorName")
   public Reject setEditorName(final String editorName) {
      this.editorName = editorName;
      return this;
   }

   @JsonProperty("applicantId")
   public Reject setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public Reject setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("inboundId")
   public Reject setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
      return this;
   }

   @JsonProperty("inboundSn")
   public Reject setInboundSn(final String inboundSn) {
      this.inboundSn = inboundSn;
      return this;
   }

   @JsonProperty("projectIds")
   public Reject setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @JsonProperty("purchaseOrderId")
   public Reject setPurchaseOrderId(final Long purchaseOrderId) {
      this.purchaseOrderId = purchaseOrderId;
      return this;
   }

   @JsonProperty("purchaseSn")
   public Reject setPurchaseSn(final String purchaseSn) {
      this.purchaseSn = purchaseSn;
      return this;
   }

   @JsonProperty("reviewStatus")
   public Reject setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("reviewerId")
   public Reject setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
      return this;
   }

   @JsonProperty("reviewerName")
   public Reject setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
      return this;
   }

   @JsonProperty("serialNumber")
   public Reject setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("shipmentNumber")
   public Reject setShipmentNumber(final String shipmentNumber) {
      this.shipmentNumber = shipmentNumber;
      return this;
   }

   @JsonProperty("supplierId")
   public Reject setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("userUpdateTime")
   public Reject setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
      return this;
   }

   @JsonProperty("remark")
   public Reject setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("approvalComments")
   public Reject setApprovalComments(final String approvalComments) {
      this.approvalComments = approvalComments;
      return this;
   }

   @JsonProperty("amount")
   public Reject setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public Reject setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public Reject setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public Reject setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("reviewTime")
   public Reject setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
      return this;
   }

   @JsonProperty("rejectFreightType")
   public Reject setRejectFreightType(final Integer rejectFreightType) {
      this.rejectFreightType = rejectFreightType;
      return this;
   }

   @JsonProperty("freight")
   public Reject setFreight(final BigDecimal freight) {
      this.freight = freight;
      return this;
   }

   @JsonProperty("freightExcludingVat")
   public Reject setFreightExcludingVat(final BigDecimal freightExcludingVat) {
      this.freightExcludingVat = freightExcludingVat;
      return this;
   }

   @JsonProperty("approveRecordId")
   public Reject setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   @JsonProperty("boolPrinted")
   public Reject setBoolPrinted(final Boolean boolPrinted) {
      this.boolPrinted = boolPrinted;
      return this;
   }

   @Override
   public String toString() {
      return "Reject(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", editorId="
         + this.getEditorId()
         + ", editorName="
         + this.getEditorName()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", inboundId="
         + this.getInboundId()
         + ", inboundSn="
         + this.getInboundSn()
         + ", projectIds="
         + this.getProjectIds()
         + ", purchaseOrderId="
         + this.getPurchaseOrderId()
         + ", purchaseSn="
         + this.getPurchaseSn()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", reviewerId="
         + this.getReviewerId()
         + ", reviewerName="
         + this.getReviewerName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", supplierId="
         + this.getSupplierId()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", remark="
         + this.getRemark()
         + ", approvalComments="
         + this.getApprovalComments()
         + ", amount="
         + this.getAmount()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", amountExcludingVatNoFreight="
         + this.getAmountExcludingVatNoFreight()
         + ", reviewTime="
         + this.getReviewTime()
         + ", rejectFreightType="
         + this.getRejectFreightType()
         + ", freight="
         + this.getFreight()
         + ", freightExcludingVat="
         + this.getFreightExcludingVat()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", boolPrinted="
         + this.getBoolPrinted()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Reject)) {
         return false;
      }

      Reject other = (Reject)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$editorId = this.getEditorId();
            Object other$editorId = other.getEditorId();
            if (this$editorId == null ? other$editorId == null : this$editorId.equals(other$editorId)) {
               Object this$applicantId = this.getApplicantId();
               Object other$applicantId = other.getApplicantId();
               if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                  Object this$inboundId = this.getInboundId();
                  Object other$inboundId = other.getInboundId();
                  if (this$inboundId == null ? other$inboundId == null : this$inboundId.equals(other$inboundId)) {
                     Object this$purchaseOrderId = this.getPurchaseOrderId();
                     Object other$purchaseOrderId = other.getPurchaseOrderId();
                     if (this$purchaseOrderId == null ? other$purchaseOrderId == null : this$purchaseOrderId.equals(other$purchaseOrderId)) {
                        Object this$reviewStatus = this.getReviewStatus();
                        Object other$reviewStatus = other.getReviewStatus();
                        if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                           Object this$reviewerId = this.getReviewerId();
                           Object other$reviewerId = other.getReviewerId();
                           if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
                              Object this$supplierId = this.getSupplierId();
                              Object other$supplierId = other.getSupplierId();
                              if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                                 Object this$rejectFreightType = this.getRejectFreightType();
                                 Object other$rejectFreightType = other.getRejectFreightType();
                                 if (this$rejectFreightType == null ? other$rejectFreightType == null : this$rejectFreightType.equals(other$rejectFreightType)) {
                                    Object this$approveRecordId = this.getApproveRecordId();
                                    Object other$approveRecordId = other.getApproveRecordId();
                                    if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                                       Object this$boolPrinted = this.getBoolPrinted();
                                       Object other$boolPrinted = other.getBoolPrinted();
                                       if (this$boolPrinted == null ? other$boolPrinted == null : this$boolPrinted.equals(other$boolPrinted)) {
                                          Object this$editorName = this.getEditorName();
                                          Object other$editorName = other.getEditorName();
                                          if (this$editorName == null ? other$editorName == null : this$editorName.equals(other$editorName)) {
                                             Object this$applicantName = this.getApplicantName();
                                             Object other$applicantName = other.getApplicantName();
                                             if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                                Object this$inboundSn = this.getInboundSn();
                                                Object other$inboundSn = other.getInboundSn();
                                                if (this$inboundSn == null ? other$inboundSn == null : this$inboundSn.equals(other$inboundSn)) {
                                                   Object this$projectIds = this.getProjectIds();
                                                   Object other$projectIds = other.getProjectIds();
                                                   if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                                      Object this$purchaseSn = this.getPurchaseSn();
                                                      Object other$purchaseSn = other.getPurchaseSn();
                                                      if (this$purchaseSn == null ? other$purchaseSn == null : this$purchaseSn.equals(other$purchaseSn)) {
                                                         Object this$reviewerName = this.getReviewerName();
                                                         Object other$reviewerName = other.getReviewerName();
                                                         if (this$reviewerName == null
                                                            ? other$reviewerName == null
                                                            : this$reviewerName.equals(other$reviewerName)) {
                                                            Object this$serialNumber = this.getSerialNumber();
                                                            Object other$serialNumber = other.getSerialNumber();
                                                            if (this$serialNumber == null
                                                               ? other$serialNumber == null
                                                               : this$serialNumber.equals(other$serialNumber)) {
                                                               Object this$shipmentNumber = this.getShipmentNumber();
                                                               Object other$shipmentNumber = other.getShipmentNumber();
                                                               if (this$shipmentNumber == null
                                                                  ? other$shipmentNumber == null
                                                                  : this$shipmentNumber.equals(other$shipmentNumber)) {
                                                                  Object this$userUpdateTime = this.getUserUpdateTime();
                                                                  Object other$userUpdateTime = other.getUserUpdateTime();
                                                                  if (this$userUpdateTime == null
                                                                     ? other$userUpdateTime == null
                                                                     : this$userUpdateTime.equals(other$userUpdateTime)) {
                                                                     Object this$remark = this.getRemark();
                                                                     Object other$remark = other.getRemark();
                                                                     if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                        Object this$approvalComments = this.getApprovalComments();
                                                                        Object other$approvalComments = other.getApprovalComments();
                                                                        if (this$approvalComments == null
                                                                           ? other$approvalComments == null
                                                                           : this$approvalComments.equals(other$approvalComments)) {
                                                                           Object this$amount = this.getAmount();
                                                                           Object other$amount = other.getAmount();
                                                                           if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                                              Object this$amountNoFreight = this.getAmountNoFreight();
                                                                              Object other$amountNoFreight = other.getAmountNoFreight();
                                                                              if (this$amountNoFreight == null
                                                                                 ? other$amountNoFreight == null
                                                                                 : this$amountNoFreight.equals(other$amountNoFreight)) {
                                                                                 Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                                 Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                                 if (this$amountExcludingVat == null
                                                                                    ? other$amountExcludingVat == null
                                                                                    : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                                                                    Object this$amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
                                                                                    Object other$amountExcludingVatNoFreight = other.getAmountExcludingVatNoFreight();
                                                                                    if (this$amountExcludingVatNoFreight == null
                                                                                       ? other$amountExcludingVatNoFreight == null
                                                                                       : this$amountExcludingVatNoFreight.equals(
                                                                                          other$amountExcludingVatNoFreight
                                                                                       )) {
                                                                                       Object this$reviewTime = this.getReviewTime();
                                                                                       Object other$reviewTime = other.getReviewTime();
                                                                                       if (this$reviewTime == null
                                                                                          ? other$reviewTime == null
                                                                                          : this$reviewTime.equals(other$reviewTime)) {
                                                                                          Object this$freight = this.getFreight();
                                                                                          Object other$freight = other.getFreight();
                                                                                          if (this$freight == null
                                                                                             ? other$freight == null
                                                                                             : this$freight.equals(other$freight)) {
                                                                                             Object this$freightExcludingVat = this.getFreightExcludingVat();
                                                                                             Object other$freightExcludingVat = other.getFreightExcludingVat();
                                                                                             return this$freightExcludingVat == null
                                                                                                ? other$freightExcludingVat == null
                                                                                                : this$freightExcludingVat.equals(other$freightExcludingVat);
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof Reject;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $editorId = this.getEditorId();
      result = result * 59 + ($editorId == null ? 43 : $editorId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $purchaseOrderId = this.getPurchaseOrderId();
      result = result * 59 + ($purchaseOrderId == null ? 43 : $purchaseOrderId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $rejectFreightType = this.getRejectFreightType();
      result = result * 59 + ($rejectFreightType == null ? 43 : $rejectFreightType.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $boolPrinted = this.getBoolPrinted();
      result = result * 59 + ($boolPrinted == null ? 43 : $boolPrinted.hashCode());
      Object $editorName = this.getEditorName();
      result = result * 59 + ($editorName == null ? 43 : $editorName.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $inboundSn = this.getInboundSn();
      result = result * 59 + ($inboundSn == null ? 43 : $inboundSn.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $purchaseSn = this.getPurchaseSn();
      result = result * 59 + ($purchaseSn == null ? 43 : $purchaseSn.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $approvalComments = this.getApprovalComments();
      result = result * 59 + ($approvalComments == null ? 43 : $approvalComments.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
      result = result * 59 + ($amountExcludingVatNoFreight == null ? 43 : $amountExcludingVatNoFreight.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $freightExcludingVat = this.getFreightExcludingVat();
      return result * 59 + ($freightExcludingVat == null ? 43 : $freightExcludingVat.hashCode());
   }

   public static class RejectBuilder {
      private Long id;
      private Integer basicClass;
      private Long editorId;
      private String editorName;
      private Long applicantId;
      private String applicantName;
      private Long inboundId;
      private String inboundSn;
      private String projectIds;
      private Long purchaseOrderId;
      private String purchaseSn;
      private Integer reviewStatus;
      private Long reviewerId;
      private String reviewerName;
      private String serialNumber;
      private String shipmentNumber;
      private Long supplierId;
      private LocalDateTime userUpdateTime;
      private String remark;
      private String approvalComments;
      private BigDecimal amount;
      private BigDecimal amountNoFreight;
      private BigDecimal amountExcludingVat;
      private BigDecimal amountExcludingVatNoFreight;
      private LocalDateTime reviewTime;
      private Integer rejectFreightType;
      private BigDecimal freight;
      private BigDecimal freightExcludingVat;
      private Long approveRecordId;
      private Boolean boolPrinted;

      RejectBuilder() {
      }

      @JsonProperty("id")
      public Reject.RejectBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("basicClass")
      public Reject.RejectBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("editorId")
      public Reject.RejectBuilder editorId(final Long editorId) {
         this.editorId = editorId;
         return this;
      }

      @JsonProperty("editorName")
      public Reject.RejectBuilder editorName(final String editorName) {
         this.editorName = editorName;
         return this;
      }

      @JsonProperty("applicantId")
      public Reject.RejectBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public Reject.RejectBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("inboundId")
      public Reject.RejectBuilder inboundId(final Long inboundId) {
         this.inboundId = inboundId;
         return this;
      }

      @JsonProperty("inboundSn")
      public Reject.RejectBuilder inboundSn(final String inboundSn) {
         this.inboundSn = inboundSn;
         return this;
      }

      @JsonProperty("projectIds")
      public Reject.RejectBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      @JsonProperty("purchaseOrderId")
      public Reject.RejectBuilder purchaseOrderId(final Long purchaseOrderId) {
         this.purchaseOrderId = purchaseOrderId;
         return this;
      }

      @JsonProperty("purchaseSn")
      public Reject.RejectBuilder purchaseSn(final String purchaseSn) {
         this.purchaseSn = purchaseSn;
         return this;
      }

      @JsonProperty("reviewStatus")
      public Reject.RejectBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("reviewerId")
      public Reject.RejectBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      @JsonProperty("reviewerName")
      public Reject.RejectBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      @JsonProperty("serialNumber")
      public Reject.RejectBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("shipmentNumber")
      public Reject.RejectBuilder shipmentNumber(final String shipmentNumber) {
         this.shipmentNumber = shipmentNumber;
         return this;
      }

      @JsonProperty("supplierId")
      public Reject.RejectBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("userUpdateTime")
      public Reject.RejectBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      @JsonProperty("remark")
      public Reject.RejectBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("approvalComments")
      public Reject.RejectBuilder approvalComments(final String approvalComments) {
         this.approvalComments = approvalComments;
         return this;
      }

      @JsonProperty("amount")
      public Reject.RejectBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountNoFreight")
      public Reject.RejectBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public Reject.RejectBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("amountExcludingVatNoFreight")
      public Reject.RejectBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("reviewTime")
      public Reject.RejectBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      @JsonProperty("rejectFreightType")
      public Reject.RejectBuilder rejectFreightType(final Integer rejectFreightType) {
         this.rejectFreightType = rejectFreightType;
         return this;
      }

      @JsonProperty("freight")
      public Reject.RejectBuilder freight(final BigDecimal freight) {
         this.freight = freight;
         return this;
      }

      @JsonProperty("freightExcludingVat")
      public Reject.RejectBuilder freightExcludingVat(final BigDecimal freightExcludingVat) {
         this.freightExcludingVat = freightExcludingVat;
         return this;
      }

      @JsonProperty("approveRecordId")
      public Reject.RejectBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      @JsonProperty("boolPrinted")
      public Reject.RejectBuilder boolPrinted(final Boolean boolPrinted) {
         this.boolPrinted = boolPrinted;
         return this;
      }

      public Reject build() {
         return new Reject(
            this.id,
            this.basicClass,
            this.editorId,
            this.editorName,
            this.applicantId,
            this.applicantName,
            this.inboundId,
            this.inboundSn,
            this.projectIds,
            this.purchaseOrderId,
            this.purchaseSn,
            this.reviewStatus,
            this.reviewerId,
            this.reviewerName,
            this.serialNumber,
            this.shipmentNumber,
            this.supplierId,
            this.userUpdateTime,
            this.remark,
            this.approvalComments,
            this.amount,
            this.amountNoFreight,
            this.amountExcludingVat,
            this.amountExcludingVatNoFreight,
            this.reviewTime,
            this.rejectFreightType,
            this.freight,
            this.freightExcludingVat,
            this.approveRecordId,
            this.boolPrinted
         );
      }

      @Override
      public String toString() {
         return "Reject.RejectBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", editorId="
            + this.editorId
            + ", editorName="
            + this.editorName
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", inboundId="
            + this.inboundId
            + ", inboundSn="
            + this.inboundSn
            + ", projectIds="
            + this.projectIds
            + ", purchaseOrderId="
            + this.purchaseOrderId
            + ", purchaseSn="
            + this.purchaseSn
            + ", reviewStatus="
            + this.reviewStatus
            + ", reviewerId="
            + this.reviewerId
            + ", reviewerName="
            + this.reviewerName
            + ", serialNumber="
            + this.serialNumber
            + ", shipmentNumber="
            + this.shipmentNumber
            + ", supplierId="
            + this.supplierId
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", remark="
            + this.remark
            + ", approvalComments="
            + this.approvalComments
            + ", amount="
            + this.amount
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", amountExcludingVatNoFreight="
            + this.amountExcludingVatNoFreight
            + ", reviewTime="
            + this.reviewTime
            + ", rejectFreightType="
            + this.rejectFreightType
            + ", freight="
            + this.freight
            + ", freightExcludingVat="
            + this.freightExcludingVat
            + ", approveRecordId="
            + this.approveRecordId
            + ", boolPrinted="
            + this.boolPrinted
            + ")";
      }
   }
}
