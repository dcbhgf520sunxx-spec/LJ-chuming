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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "Transfer对象", description = "物料调拨 ")
@Entity
@TableName("wms_transfer")
@Table(name = "wms_transfer")
public class Transfer extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "调拨单编号", notes = "调拨单编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '调拨单编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "basicClass", value = "基础物料类型 调拨单所包含类型", notes = "基础物料类型 调拨单所包含类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '基础物料类型 调拨单所包含类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "directionProjectId", value = "目标项目ID 调拨方向,到公共为空", notes = "目标项目ID 调拨方向,到公共为空")
   @JsonProperty("directionProjectId")
   @JSONField(name = "directionProjectId")
   @TableField("direction_project_id")
   @Column(name = "direction_project_id", columnDefinition = "bigint  COMMENT '目标项目ID 调拨方向,到公共为空'", nullable = true)
   private Long directionProjectId;
   @ApiModelProperty(name = "directionWarehouseId", value = "目标仓库ID", notes = "目标仓库ID")
   @JsonProperty("directionWarehouseId")
   @JSONField(name = "directionWarehouseId")
   @TableField("direction_warehouse_id")
   @Column(name = "direction_warehouse_id", columnDefinition = "bigint  COMMENT '目标仓库ID'", nullable = true)
   private Long directionWarehouseId;
   @ApiModelProperty(name = "transferType", value = "调拨类型,参考枚举[TransferTypeEnum]", notes = "调拨类型,参考枚举[TransferTypeEnum]")
   @JsonProperty("transferType")
   @JSONField(name = "transferType")
   @TableField("transfer_type")
   @Column(name = "transfer_type", columnDefinition = "int  COMMENT '调拨类型,参考枚举[TransferTypeEnum]'", nullable = true)
   private Integer transferType;
   @ApiModelProperty(name = "transferCreateType", value = "调拨单创建类型[1 手动调拨, 2 出库调拨]", notes = "调拨单创建类型[1 手动调拨, 2 出库调拨]")
   @JsonProperty("transferCreateType")
   @JSONField(name = "transferCreateType")
   @TableField("transfer_create_type")
   @Column(name = "transfer_create_type", columnDefinition = "int  COMMENT '调拨单创建类型[1 手动调拨, 2 出库调拨]'", nullable = true)
   private Integer transferCreateType;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态", notes = "审核状态")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int  COMMENT '审核状态'", nullable = true)
   private Integer reviewStatus;
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
   @ApiModelProperty(name = "editorId", value = "最后编辑人ID", notes = "最后编辑人ID")
   @JsonProperty("editorId")
   @JSONField(name = "editorId")
   @TableField("editor_id")
   @Column(name = "editor_id", columnDefinition = "bigint  COMMENT '最后编辑人ID'", nullable = true)
   private Long editorId;
   @ApiModelProperty(name = "editorName", value = "最后编辑人名称", notes = "最后编辑人名称")
   @JsonProperty("editorName")
   @JSONField(name = "editorName")
   @TableField("editor_name")
   @Column(name = "editor_name", columnDefinition = "varchar(255)  COMMENT '最后编辑人名称'", nullable = true)
   private String editorName;
   @ApiModelProperty(name = "reviewTime", value = "审核时间", notes = "审核时间")
   @JsonProperty("reviewTime")
   @JSONField(name = "reviewTime")
   @TableField("review_time")
   @Column(name = "review_time", columnDefinition = "datetime  COMMENT '审核时间'", nullable = true)
   private LocalDateTime reviewTime;
   @ApiModelProperty(name = "userUpdateTime", value = "用户修改时间", notes = "用户修改时间")
   @JsonProperty("userUpdateTime")
   @JSONField(name = "userUpdateTime")
   @TableField("user_update_time")
   @Column(name = "user_update_time", columnDefinition = "datetime  COMMENT '用户修改时间'", nullable = true)
   private LocalDateTime userUpdateTime;
   @ApiModelProperty(name = "partyABorrowId", value = "甲供借用单ID", notes = "甲供借用单ID")
   @JsonProperty("partyABorrowId")
   @JSONField(name = "partyABorrowId")
   @TableField("party_a_borrow_id")
   @Column(name = "party_a_borrow_id", columnDefinition = "bigint  COMMENT '甲供借用单ID'", nullable = true)
   private Long partyABorrowId;
   @ApiModelProperty(name = "approvalComments", value = "审批意见", notes = "审批意见")
   @JsonProperty("approvalComments")
   @JSONField(name = "approvalComments")
   @TableField("approval_comments")
   @Column(name = "approval_comments", columnDefinition = "text  COMMENT '审批意见'", nullable = true)
   private String approvalComments;
   @ApiModelProperty(name = "borrowProjectId", value = "借用项目ID", notes = "借用项目ID")
   @JsonProperty("borrowProjectId")
   @JSONField(name = "borrowProjectId")
   @TableField("borrow_project_id")
   @Column(name = "borrow_project_id", columnDefinition = "bigint  COMMENT '借用项目ID'", nullable = true)
   private Long borrowProjectId;
   @ApiModelProperty(name = "directionMonomerId", value = "目标单体ID", notes = "目标单体ID")
   @JsonProperty("directionMonomerId")
   @JSONField(name = "directionMonomerId")
   @TableField("direction_monomer_id")
   @Column(name = "direction_monomer_id", columnDefinition = "bigint  COMMENT '目标单体ID'", nullable = true)
   private Long directionMonomerId;
   @ApiModelProperty(name = "directionAreaId", value = "目标区域ID", notes = "目标区域ID")
   @JsonProperty("directionAreaId")
   @JSONField(name = "directionAreaId")
   @TableField("direction_area_id")
   @Column(name = "direction_area_id", columnDefinition = "bigint  COMMENT '目标区域ID'", nullable = true)
   private Long directionAreaId;
   @ApiModelProperty(name = "directionWorkshopId", value = "目标车间ID", notes = "目标车间ID")
   @JsonProperty("directionWorkshopId")
   @JSONField(name = "directionWorkshopId")
   @TableField("direction_workshop_id")
   @Column(name = "direction_workshop_id", columnDefinition = "bigint  COMMENT '目标车间ID'", nullable = true)
   private Long directionWorkshopId;
   @ApiModelProperty(name = "boolPrinted", value = "是否打印")
   @JsonProperty("boolPrinted")
   @JSONField(name = "boolPrinted")
   @TableField("bool_printed")
   @Column(name = "bool_printed", nullable = false, columnDefinition = "tinyint(1) default 0 COMMENT '是否打印: 0 未打印,1 打印'")
   private Boolean boolPrinted;
   @ApiModelProperty(name = "outboundId", value = "出库单ID", notes = "出库单ID")
   @JsonProperty("outboundId")
   @JSONField(name = "outboundId")
   @TableField("outbound_id")
   @Column(name = "outbound_id", columnDefinition = "bigint  COMMENT '出库单ID'", nullable = true)
   private Long outboundId;
   @ApiModelProperty(name = "outboundSn", value = "出库单编号", notes = "出库单编号")
   @JsonProperty("outboundSn")
   @JSONField(name = "outboundSn")
   @TableField("outbound_sn")
   @Column(name = "outbound_sn", columnDefinition = "varchar(255)  COMMENT '出库单编号'", nullable = true)
   private String outboundSn;

   public static Transfer.TransferBuilder builder() {
      return new Transfer.TransferBuilder();
   }

   public Transfer() {
   }

   public Transfer(
      final Long id,
      final String serialNumber,
      final Integer basicClass,
      final Long directionProjectId,
      final Long directionWarehouseId,
      final Integer transferType,
      final Integer transferCreateType,
      final Integer reviewStatus,
      final Long applicantId,
      final String applicantName,
      final Long reviewerId,
      final String reviewerName,
      final Long editorId,
      final String editorName,
      final LocalDateTime reviewTime,
      final LocalDateTime userUpdateTime,
      final Long partyABorrowId,
      final String approvalComments,
      final Long borrowProjectId,
      final Long directionMonomerId,
      final Long directionAreaId,
      final Long directionWorkshopId,
      final Boolean boolPrinted,
      final Long outboundId,
      final String outboundSn
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.basicClass = basicClass;
      this.directionProjectId = directionProjectId;
      this.directionWarehouseId = directionWarehouseId;
      this.transferType = transferType;
      this.transferCreateType = transferCreateType;
      this.reviewStatus = reviewStatus;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.reviewerId = reviewerId;
      this.reviewerName = reviewerName;
      this.editorId = editorId;
      this.editorName = editorName;
      this.reviewTime = reviewTime;
      this.userUpdateTime = userUpdateTime;
      this.partyABorrowId = partyABorrowId;
      this.approvalComments = approvalComments;
      this.borrowProjectId = borrowProjectId;
      this.directionMonomerId = directionMonomerId;
      this.directionAreaId = directionAreaId;
      this.directionWorkshopId = directionWorkshopId;
      this.boolPrinted = boolPrinted;
      this.outboundId = outboundId;
      this.outboundSn = outboundSn;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getDirectionProjectId() {
      return this.directionProjectId;
   }

   public Long getDirectionWarehouseId() {
      return this.directionWarehouseId;
   }

   public Integer getTransferType() {
      return this.transferType;
   }

   public Integer getTransferCreateType() {
      return this.transferCreateType;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public Long getEditorId() {
      return this.editorId;
   }

   public String getEditorName() {
      return this.editorName;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public Long getPartyABorrowId() {
      return this.partyABorrowId;
   }

   public String getApprovalComments() {
      return this.approvalComments;
   }

   public Long getBorrowProjectId() {
      return this.borrowProjectId;
   }

   public Long getDirectionMonomerId() {
      return this.directionMonomerId;
   }

   public Long getDirectionAreaId() {
      return this.directionAreaId;
   }

   public Long getDirectionWorkshopId() {
      return this.directionWorkshopId;
   }

   public Boolean getBoolPrinted() {
      return this.boolPrinted;
   }

   public Long getOutboundId() {
      return this.outboundId;
   }

   public String getOutboundSn() {
      return this.outboundSn;
   }

   @JsonProperty("id")
   public Transfer setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public Transfer setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("basicClass")
   public Transfer setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("directionProjectId")
   public Transfer setDirectionProjectId(final Long directionProjectId) {
      this.directionProjectId = directionProjectId;
      return this;
   }

   @JsonProperty("directionWarehouseId")
   public Transfer setDirectionWarehouseId(final Long directionWarehouseId) {
      this.directionWarehouseId = directionWarehouseId;
      return this;
   }

   @JsonProperty("transferType")
   public Transfer setTransferType(final Integer transferType) {
      this.transferType = transferType;
      return this;
   }

   @JsonProperty("transferCreateType")
   public Transfer setTransferCreateType(final Integer transferCreateType) {
      this.transferCreateType = transferCreateType;
      return this;
   }

   @JsonProperty("reviewStatus")
   public Transfer setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("applicantId")
   public Transfer setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public Transfer setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("reviewerId")
   public Transfer setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
      return this;
   }

   @JsonProperty("reviewerName")
   public Transfer setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
      return this;
   }

   @JsonProperty("editorId")
   public Transfer setEditorId(final Long editorId) {
      this.editorId = editorId;
      return this;
   }

   @JsonProperty("editorName")
   public Transfer setEditorName(final String editorName) {
      this.editorName = editorName;
      return this;
   }

   @JsonProperty("reviewTime")
   public Transfer setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
      return this;
   }

   @JsonProperty("userUpdateTime")
   public Transfer setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
      return this;
   }

   @JsonProperty("partyABorrowId")
   public Transfer setPartyABorrowId(final Long partyABorrowId) {
      this.partyABorrowId = partyABorrowId;
      return this;
   }

   @JsonProperty("approvalComments")
   public Transfer setApprovalComments(final String approvalComments) {
      this.approvalComments = approvalComments;
      return this;
   }

   @JsonProperty("borrowProjectId")
   public Transfer setBorrowProjectId(final Long borrowProjectId) {
      this.borrowProjectId = borrowProjectId;
      return this;
   }

   @JsonProperty("directionMonomerId")
   public Transfer setDirectionMonomerId(final Long directionMonomerId) {
      this.directionMonomerId = directionMonomerId;
      return this;
   }

   @JsonProperty("directionAreaId")
   public Transfer setDirectionAreaId(final Long directionAreaId) {
      this.directionAreaId = directionAreaId;
      return this;
   }

   @JsonProperty("directionWorkshopId")
   public Transfer setDirectionWorkshopId(final Long directionWorkshopId) {
      this.directionWorkshopId = directionWorkshopId;
      return this;
   }

   @JsonProperty("boolPrinted")
   public Transfer setBoolPrinted(final Boolean boolPrinted) {
      this.boolPrinted = boolPrinted;
      return this;
   }

   @JsonProperty("outboundId")
   public Transfer setOutboundId(final Long outboundId) {
      this.outboundId = outboundId;
      return this;
   }

   @JsonProperty("outboundSn")
   public Transfer setOutboundSn(final String outboundSn) {
      this.outboundSn = outboundSn;
      return this;
   }

   @Override
   public String toString() {
      return "Transfer(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", basicClass="
         + this.getBasicClass()
         + ", directionProjectId="
         + this.getDirectionProjectId()
         + ", directionWarehouseId="
         + this.getDirectionWarehouseId()
         + ", transferType="
         + this.getTransferType()
         + ", transferCreateType="
         + this.getTransferCreateType()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewerId="
         + this.getReviewerId()
         + ", reviewerName="
         + this.getReviewerName()
         + ", editorId="
         + this.getEditorId()
         + ", editorName="
         + this.getEditorName()
         + ", reviewTime="
         + this.getReviewTime()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", partyABorrowId="
         + this.getPartyABorrowId()
         + ", approvalComments="
         + this.getApprovalComments()
         + ", borrowProjectId="
         + this.getBorrowProjectId()
         + ", directionMonomerId="
         + this.getDirectionMonomerId()
         + ", directionAreaId="
         + this.getDirectionAreaId()
         + ", directionWorkshopId="
         + this.getDirectionWorkshopId()
         + ", boolPrinted="
         + this.getBoolPrinted()
         + ", outboundId="
         + this.getOutboundId()
         + ", outboundSn="
         + this.getOutboundSn()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Transfer)) {
         return false;
      }

      Transfer other = (Transfer)o;
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
            Object this$directionProjectId = this.getDirectionProjectId();
            Object other$directionProjectId = other.getDirectionProjectId();
            if (this$directionProjectId == null ? other$directionProjectId == null : this$directionProjectId.equals(other$directionProjectId)) {
               Object this$directionWarehouseId = this.getDirectionWarehouseId();
               Object other$directionWarehouseId = other.getDirectionWarehouseId();
               if (this$directionWarehouseId == null ? other$directionWarehouseId == null : this$directionWarehouseId.equals(other$directionWarehouseId)) {
                  Object this$transferType = this.getTransferType();
                  Object other$transferType = other.getTransferType();
                  if (this$transferType == null ? other$transferType == null : this$transferType.equals(other$transferType)) {
                     Object this$transferCreateType = this.getTransferCreateType();
                     Object other$transferCreateType = other.getTransferCreateType();
                     if (this$transferCreateType == null ? other$transferCreateType == null : this$transferCreateType.equals(other$transferCreateType)) {
                        Object this$reviewStatus = this.getReviewStatus();
                        Object other$reviewStatus = other.getReviewStatus();
                        if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                           Object this$applicantId = this.getApplicantId();
                           Object other$applicantId = other.getApplicantId();
                           if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                              Object this$reviewerId = this.getReviewerId();
                              Object other$reviewerId = other.getReviewerId();
                              if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
                                 Object this$editorId = this.getEditorId();
                                 Object other$editorId = other.getEditorId();
                                 if (this$editorId == null ? other$editorId == null : this$editorId.equals(other$editorId)) {
                                    Object this$partyABorrowId = this.getPartyABorrowId();
                                    Object other$partyABorrowId = other.getPartyABorrowId();
                                    if (this$partyABorrowId == null ? other$partyABorrowId == null : this$partyABorrowId.equals(other$partyABorrowId)) {
                                       Object this$borrowProjectId = this.getBorrowProjectId();
                                       Object other$borrowProjectId = other.getBorrowProjectId();
                                       if (this$borrowProjectId == null ? other$borrowProjectId == null : this$borrowProjectId.equals(other$borrowProjectId)) {
                                          Object this$directionMonomerId = this.getDirectionMonomerId();
                                          Object other$directionMonomerId = other.getDirectionMonomerId();
                                          if (this$directionMonomerId == null
                                             ? other$directionMonomerId == null
                                             : this$directionMonomerId.equals(other$directionMonomerId)) {
                                             Object this$directionAreaId = this.getDirectionAreaId();
                                             Object other$directionAreaId = other.getDirectionAreaId();
                                             if (this$directionAreaId == null
                                                ? other$directionAreaId == null
                                                : this$directionAreaId.equals(other$directionAreaId)) {
                                                Object this$directionWorkshopId = this.getDirectionWorkshopId();
                                                Object other$directionWorkshopId = other.getDirectionWorkshopId();
                                                if (this$directionWorkshopId == null
                                                   ? other$directionWorkshopId == null
                                                   : this$directionWorkshopId.equals(other$directionWorkshopId)) {
                                                   Object this$boolPrinted = this.getBoolPrinted();
                                                   Object other$boolPrinted = other.getBoolPrinted();
                                                   if (this$boolPrinted == null ? other$boolPrinted == null : this$boolPrinted.equals(other$boolPrinted)) {
                                                      Object this$outboundId = this.getOutboundId();
                                                      Object other$outboundId = other.getOutboundId();
                                                      if (this$outboundId == null ? other$outboundId == null : this$outboundId.equals(other$outboundId)) {
                                                         Object this$serialNumber = this.getSerialNumber();
                                                         Object other$serialNumber = other.getSerialNumber();
                                                         if (this$serialNumber == null
                                                            ? other$serialNumber == null
                                                            : this$serialNumber.equals(other$serialNumber)) {
                                                            Object this$applicantName = this.getApplicantName();
                                                            Object other$applicantName = other.getApplicantName();
                                                            if (this$applicantName == null
                                                               ? other$applicantName == null
                                                               : this$applicantName.equals(other$applicantName)) {
                                                               Object this$reviewerName = this.getReviewerName();
                                                               Object other$reviewerName = other.getReviewerName();
                                                               if (this$reviewerName == null
                                                                  ? other$reviewerName == null
                                                                  : this$reviewerName.equals(other$reviewerName)) {
                                                                  Object this$editorName = this.getEditorName();
                                                                  Object other$editorName = other.getEditorName();
                                                                  if (this$editorName == null
                                                                     ? other$editorName == null
                                                                     : this$editorName.equals(other$editorName)) {
                                                                     Object this$reviewTime = this.getReviewTime();
                                                                     Object other$reviewTime = other.getReviewTime();
                                                                     if (this$reviewTime == null
                                                                        ? other$reviewTime == null
                                                                        : this$reviewTime.equals(other$reviewTime)) {
                                                                        Object this$userUpdateTime = this.getUserUpdateTime();
                                                                        Object other$userUpdateTime = other.getUserUpdateTime();
                                                                        if (this$userUpdateTime == null
                                                                           ? other$userUpdateTime == null
                                                                           : this$userUpdateTime.equals(other$userUpdateTime)) {
                                                                           Object this$approvalComments = this.getApprovalComments();
                                                                           Object other$approvalComments = other.getApprovalComments();
                                                                           if (this$approvalComments == null
                                                                              ? other$approvalComments == null
                                                                              : this$approvalComments.equals(other$approvalComments)) {
                                                                              Object this$outboundSn = this.getOutboundSn();
                                                                              Object other$outboundSn = other.getOutboundSn();
                                                                              return this$outboundSn == null
                                                                                 ? other$outboundSn == null
                                                                                 : this$outboundSn.equals(other$outboundSn);
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof Transfer;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $directionProjectId = this.getDirectionProjectId();
      result = result * 59 + ($directionProjectId == null ? 43 : $directionProjectId.hashCode());
      Object $directionWarehouseId = this.getDirectionWarehouseId();
      result = result * 59 + ($directionWarehouseId == null ? 43 : $directionWarehouseId.hashCode());
      Object $transferType = this.getTransferType();
      result = result * 59 + ($transferType == null ? 43 : $transferType.hashCode());
      Object $transferCreateType = this.getTransferCreateType();
      result = result * 59 + ($transferCreateType == null ? 43 : $transferCreateType.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $editorId = this.getEditorId();
      result = result * 59 + ($editorId == null ? 43 : $editorId.hashCode());
      Object $partyABorrowId = this.getPartyABorrowId();
      result = result * 59 + ($partyABorrowId == null ? 43 : $partyABorrowId.hashCode());
      Object $borrowProjectId = this.getBorrowProjectId();
      result = result * 59 + ($borrowProjectId == null ? 43 : $borrowProjectId.hashCode());
      Object $directionMonomerId = this.getDirectionMonomerId();
      result = result * 59 + ($directionMonomerId == null ? 43 : $directionMonomerId.hashCode());
      Object $directionAreaId = this.getDirectionAreaId();
      result = result * 59 + ($directionAreaId == null ? 43 : $directionAreaId.hashCode());
      Object $directionWorkshopId = this.getDirectionWorkshopId();
      result = result * 59 + ($directionWorkshopId == null ? 43 : $directionWorkshopId.hashCode());
      Object $boolPrinted = this.getBoolPrinted();
      result = result * 59 + ($boolPrinted == null ? 43 : $boolPrinted.hashCode());
      Object $outboundId = this.getOutboundId();
      result = result * 59 + ($outboundId == null ? 43 : $outboundId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $editorName = this.getEditorName();
      result = result * 59 + ($editorName == null ? 43 : $editorName.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $approvalComments = this.getApprovalComments();
      result = result * 59 + ($approvalComments == null ? 43 : $approvalComments.hashCode());
      Object $outboundSn = this.getOutboundSn();
      return result * 59 + ($outboundSn == null ? 43 : $outboundSn.hashCode());
   }

   public static class TransferBuilder {
      private Long id;
      private String serialNumber;
      private Integer basicClass;
      private Long directionProjectId;
      private Long directionWarehouseId;
      private Integer transferType;
      private Integer transferCreateType;
      private Integer reviewStatus;
      private Long applicantId;
      private String applicantName;
      private Long reviewerId;
      private String reviewerName;
      private Long editorId;
      private String editorName;
      private LocalDateTime reviewTime;
      private LocalDateTime userUpdateTime;
      private Long partyABorrowId;
      private String approvalComments;
      private Long borrowProjectId;
      private Long directionMonomerId;
      private Long directionAreaId;
      private Long directionWorkshopId;
      private Boolean boolPrinted;
      private Long outboundId;
      private String outboundSn;

      TransferBuilder() {
      }

      @JsonProperty("id")
      public Transfer.TransferBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public Transfer.TransferBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("basicClass")
      public Transfer.TransferBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("directionProjectId")
      public Transfer.TransferBuilder directionProjectId(final Long directionProjectId) {
         this.directionProjectId = directionProjectId;
         return this;
      }

      @JsonProperty("directionWarehouseId")
      public Transfer.TransferBuilder directionWarehouseId(final Long directionWarehouseId) {
         this.directionWarehouseId = directionWarehouseId;
         return this;
      }

      @JsonProperty("transferType")
      public Transfer.TransferBuilder transferType(final Integer transferType) {
         this.transferType = transferType;
         return this;
      }

      @JsonProperty("transferCreateType")
      public Transfer.TransferBuilder transferCreateType(final Integer transferCreateType) {
         this.transferCreateType = transferCreateType;
         return this;
      }

      @JsonProperty("reviewStatus")
      public Transfer.TransferBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("applicantId")
      public Transfer.TransferBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public Transfer.TransferBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("reviewerId")
      public Transfer.TransferBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      @JsonProperty("reviewerName")
      public Transfer.TransferBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      @JsonProperty("editorId")
      public Transfer.TransferBuilder editorId(final Long editorId) {
         this.editorId = editorId;
         return this;
      }

      @JsonProperty("editorName")
      public Transfer.TransferBuilder editorName(final String editorName) {
         this.editorName = editorName;
         return this;
      }

      @JsonProperty("reviewTime")
      public Transfer.TransferBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      @JsonProperty("userUpdateTime")
      public Transfer.TransferBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      @JsonProperty("partyABorrowId")
      public Transfer.TransferBuilder partyABorrowId(final Long partyABorrowId) {
         this.partyABorrowId = partyABorrowId;
         return this;
      }

      @JsonProperty("approvalComments")
      public Transfer.TransferBuilder approvalComments(final String approvalComments) {
         this.approvalComments = approvalComments;
         return this;
      }

      @JsonProperty("borrowProjectId")
      public Transfer.TransferBuilder borrowProjectId(final Long borrowProjectId) {
         this.borrowProjectId = borrowProjectId;
         return this;
      }

      @JsonProperty("directionMonomerId")
      public Transfer.TransferBuilder directionMonomerId(final Long directionMonomerId) {
         this.directionMonomerId = directionMonomerId;
         return this;
      }

      @JsonProperty("directionAreaId")
      public Transfer.TransferBuilder directionAreaId(final Long directionAreaId) {
         this.directionAreaId = directionAreaId;
         return this;
      }

      @JsonProperty("directionWorkshopId")
      public Transfer.TransferBuilder directionWorkshopId(final Long directionWorkshopId) {
         this.directionWorkshopId = directionWorkshopId;
         return this;
      }

      @JsonProperty("boolPrinted")
      public Transfer.TransferBuilder boolPrinted(final Boolean boolPrinted) {
         this.boolPrinted = boolPrinted;
         return this;
      }

      @JsonProperty("outboundId")
      public Transfer.TransferBuilder outboundId(final Long outboundId) {
         this.outboundId = outboundId;
         return this;
      }

      @JsonProperty("outboundSn")
      public Transfer.TransferBuilder outboundSn(final String outboundSn) {
         this.outboundSn = outboundSn;
         return this;
      }

      public Transfer build() {
         return new Transfer(
            this.id,
            this.serialNumber,
            this.basicClass,
            this.directionProjectId,
            this.directionWarehouseId,
            this.transferType,
            this.transferCreateType,
            this.reviewStatus,
            this.applicantId,
            this.applicantName,
            this.reviewerId,
            this.reviewerName,
            this.editorId,
            this.editorName,
            this.reviewTime,
            this.userUpdateTime,
            this.partyABorrowId,
            this.approvalComments,
            this.borrowProjectId,
            this.directionMonomerId,
            this.directionAreaId,
            this.directionWorkshopId,
            this.boolPrinted,
            this.outboundId,
            this.outboundSn
         );
      }

      @Override
      public String toString() {
         return "Transfer.TransferBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", basicClass="
            + this.basicClass
            + ", directionProjectId="
            + this.directionProjectId
            + ", directionWarehouseId="
            + this.directionWarehouseId
            + ", transferType="
            + this.transferType
            + ", transferCreateType="
            + this.transferCreateType
            + ", reviewStatus="
            + this.reviewStatus
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", reviewerId="
            + this.reviewerId
            + ", reviewerName="
            + this.reviewerName
            + ", editorId="
            + this.editorId
            + ", editorName="
            + this.editorName
            + ", reviewTime="
            + this.reviewTime
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", partyABorrowId="
            + this.partyABorrowId
            + ", approvalComments="
            + this.approvalComments
            + ", borrowProjectId="
            + this.borrowProjectId
            + ", directionMonomerId="
            + this.directionMonomerId
            + ", directionAreaId="
            + this.directionAreaId
            + ", directionWorkshopId="
            + this.directionWorkshopId
            + ", boolPrinted="
            + this.boolPrinted
            + ", outboundId="
            + this.outboundId
            + ", outboundSn="
            + this.outboundSn
            + ")";
      }
   }
}
