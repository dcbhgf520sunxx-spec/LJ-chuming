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

@ApiModel(value = "OutboundManufactured对象", description = "制成品出库表 ")
@Entity
@TableName("wms_outbound_manufactured")
@Table(name = "wms_outbound_manufactured")
public class OutboundManufactured extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "出库单编号", notes = "出库单编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '出库单编号'", nullable = true)
   private String serialNumber;
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
   @Column(name = "applicant_name", columnDefinition = "varchar(128)  COMMENT '申请人名称'", nullable = true)
   private String applicantName;
   @ApiModelProperty(name = "applicationTime", value = "提交申请时间", notes = "提交申请时间")
   @JsonProperty("applicationTime")
   @JSONField(name = "applicationTime")
   @TableField("application_time")
   @Column(name = "application_time", columnDefinition = "datetime(6)  COMMENT '提交申请时间'", nullable = true)
   private LocalDateTime applicationTime;
   @ApiModelProperty(name = "recipients", value = "领用人名称集", notes = "领用人名称集")
   @JsonProperty("recipients")
   @JSONField(name = "recipients")
   @TableField("recipients")
   @Column(name = "recipients", columnDefinition = "text  COMMENT '领用人名称集'", nullable = true)
   private String recipients;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态", notes = "审核状态")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int  COMMENT '审核状态'", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "reviewPassTime", value = "审核通过时间", notes = "审核通过时间")
   @JsonProperty("reviewPassTime")
   @JSONField(name = "reviewPassTime")
   @TableField("review_pass_time")
   @Column(name = "review_pass_time", columnDefinition = "datetime(6)  COMMENT '审核通过时间'", nullable = true)
   private LocalDateTime reviewPassTime;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型[位运算]", notes = "物料基础类型[位运算]")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础类型[位运算]'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "projectIds", value = "出库项目ID集", notes = "出库项目ID集")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   @TableField("project_ids")
   @Column(name = "project_ids", columnDefinition = "varchar(255)  COMMENT '出库项目ID集'", nullable = true)
   private String projectIds;
   @ApiModelProperty(name = "amountExcludingVat", value = "入库金额[不含税]", notes = "入库金额[不含税]")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_vat")
   @Column(name = "amount_excluding_vat", columnDefinition = "decimal(32,8)  COMMENT '入库金额[不含税]'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "amount", value = "入库金额[含税]", notes = "入库金额[含税]")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,8)  COMMENT '入库金额[含税]'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "approveRecordId", value = "审批日志ID", notes = "审批日志ID")
   @JsonProperty("approveRecordId")
   @JSONField(name = "approveRecordId")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint  COMMENT '审批日志ID'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty(name = "inboundManufacturedId", value = "制成品入库单ID 即入即出相关联,审批日志就用入库单的审批日志ID", notes = "制成品入库单ID 即入即出相关联,审批日志就用入库单的审批日志ID")
   @JsonProperty("inboundManufacturedId")
   @JSONField(name = "inboundManufacturedId")
   @TableField("inbound_manufactured_id")
   @Column(name = "inbound_manufactured_id", columnDefinition = "bigint  COMMENT '制成品入库单ID 即入即出相关联,审批日志就用入库单的审批日志ID'", nullable = true)
   private Long inboundManufacturedId;

   public static OutboundManufactured.OutboundManufacturedBuilder builder() {
      return new OutboundManufactured.OutboundManufacturedBuilder();
   }

   public OutboundManufactured() {
   }

   public OutboundManufactured(
      final Long id,
      final String serialNumber,
      final Long applicantId,
      final String applicantName,
      final LocalDateTime applicationTime,
      final String recipients,
      final Integer reviewStatus,
      final LocalDateTime reviewPassTime,
      final Integer basicClass,
      final String projectIds,
      final BigDecimal amountExcludingVat,
      final BigDecimal amount,
      final Long approveRecordId,
      final Long inboundManufacturedId
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.applicationTime = applicationTime;
      this.recipients = recipients;
      this.reviewStatus = reviewStatus;
      this.reviewPassTime = reviewPassTime;
      this.basicClass = basicClass;
      this.projectIds = projectIds;
      this.amountExcludingVat = amountExcludingVat;
      this.amount = amount;
      this.approveRecordId = approveRecordId;
      this.inboundManufacturedId = inboundManufacturedId;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public LocalDateTime getApplicationTime() {
      return this.applicationTime;
   }

   public String getRecipients() {
      return this.recipients;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public LocalDateTime getReviewPassTime() {
      return this.reviewPassTime;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public Long getInboundManufacturedId() {
      return this.inboundManufacturedId;
   }

   @JsonProperty("id")
   public OutboundManufactured setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public OutboundManufactured setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("applicantId")
   public OutboundManufactured setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public OutboundManufactured setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("applicationTime")
   public OutboundManufactured setApplicationTime(final LocalDateTime applicationTime) {
      this.applicationTime = applicationTime;
      return this;
   }

   @JsonProperty("recipients")
   public OutboundManufactured setRecipients(final String recipients) {
      this.recipients = recipients;
      return this;
   }

   @JsonProperty("reviewStatus")
   public OutboundManufactured setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("reviewPassTime")
   public OutboundManufactured setReviewPassTime(final LocalDateTime reviewPassTime) {
      this.reviewPassTime = reviewPassTime;
      return this;
   }

   @JsonProperty("basicClass")
   public OutboundManufactured setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("projectIds")
   public OutboundManufactured setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public OutboundManufactured setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("amount")
   public OutboundManufactured setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("approveRecordId")
   public OutboundManufactured setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   @JsonProperty("inboundManufacturedId")
   public OutboundManufactured setInboundManufacturedId(final Long inboundManufacturedId) {
      this.inboundManufacturedId = inboundManufacturedId;
      return this;
   }

   @Override
   public String toString() {
      return "OutboundManufactured(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", applicationTime="
         + this.getApplicationTime()
         + ", recipients="
         + this.getRecipients()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", reviewPassTime="
         + this.getReviewPassTime()
         + ", basicClass="
         + this.getBasicClass()
         + ", projectIds="
         + this.getProjectIds()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", amount="
         + this.getAmount()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", inboundManufacturedId="
         + this.getInboundManufacturedId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutboundManufactured)) {
         return false;
      }

      OutboundManufactured other = (OutboundManufactured)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$applicantId = this.getApplicantId();
         Object other$applicantId = other.getApplicantId();
         if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
            Object this$reviewStatus = this.getReviewStatus();
            Object other$reviewStatus = other.getReviewStatus();
            if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$approveRecordId = this.getApproveRecordId();
                  Object other$approveRecordId = other.getApproveRecordId();
                  if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                     Object this$inboundManufacturedId = this.getInboundManufacturedId();
                     Object other$inboundManufacturedId = other.getInboundManufacturedId();
                     if (this$inboundManufacturedId == null
                        ? other$inboundManufacturedId == null
                        : this$inboundManufacturedId.equals(other$inboundManufacturedId)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$applicantName = this.getApplicantName();
                           Object other$applicantName = other.getApplicantName();
                           if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                              Object this$applicationTime = this.getApplicationTime();
                              Object other$applicationTime = other.getApplicationTime();
                              if (this$applicationTime == null ? other$applicationTime == null : this$applicationTime.equals(other$applicationTime)) {
                                 Object this$recipients = this.getRecipients();
                                 Object other$recipients = other.getRecipients();
                                 if (this$recipients == null ? other$recipients == null : this$recipients.equals(other$recipients)) {
                                    Object this$reviewPassTime = this.getReviewPassTime();
                                    Object other$reviewPassTime = other.getReviewPassTime();
                                    if (this$reviewPassTime == null ? other$reviewPassTime == null : this$reviewPassTime.equals(other$reviewPassTime)) {
                                       Object this$projectIds = this.getProjectIds();
                                       Object other$projectIds = other.getProjectIds();
                                       if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                          Object this$amountExcludingVat = this.getAmountExcludingVat();
                                          Object other$amountExcludingVat = other.getAmountExcludingVat();
                                          if (this$amountExcludingVat == null
                                             ? other$amountExcludingVat == null
                                             : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                             Object this$amount = this.getAmount();
                                             Object other$amount = other.getAmount();
                                             return this$amount == null ? other$amount == null : this$amount.equals(other$amount);
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof OutboundManufactured;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $inboundManufacturedId = this.getInboundManufacturedId();
      result = result * 59 + ($inboundManufacturedId == null ? 43 : $inboundManufacturedId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $applicationTime = this.getApplicationTime();
      result = result * 59 + ($applicationTime == null ? 43 : $applicationTime.hashCode());
      Object $recipients = this.getRecipients();
      result = result * 59 + ($recipients == null ? 43 : $recipients.hashCode());
      Object $reviewPassTime = this.getReviewPassTime();
      result = result * 59 + ($reviewPassTime == null ? 43 : $reviewPassTime.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $amount = this.getAmount();
      return result * 59 + ($amount == null ? 43 : $amount.hashCode());
   }

   public static class OutboundManufacturedBuilder {
      private Long id;
      private String serialNumber;
      private Long applicantId;
      private String applicantName;
      private LocalDateTime applicationTime;
      private String recipients;
      private Integer reviewStatus;
      private LocalDateTime reviewPassTime;
      private Integer basicClass;
      private String projectIds;
      private BigDecimal amountExcludingVat;
      private BigDecimal amount;
      private Long approveRecordId;
      private Long inboundManufacturedId;

      OutboundManufacturedBuilder() {
      }

      @JsonProperty("id")
      public OutboundManufactured.OutboundManufacturedBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public OutboundManufactured.OutboundManufacturedBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("applicantId")
      public OutboundManufactured.OutboundManufacturedBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public OutboundManufactured.OutboundManufacturedBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("applicationTime")
      public OutboundManufactured.OutboundManufacturedBuilder applicationTime(final LocalDateTime applicationTime) {
         this.applicationTime = applicationTime;
         return this;
      }

      @JsonProperty("recipients")
      public OutboundManufactured.OutboundManufacturedBuilder recipients(final String recipients) {
         this.recipients = recipients;
         return this;
      }

      @JsonProperty("reviewStatus")
      public OutboundManufactured.OutboundManufacturedBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("reviewPassTime")
      public OutboundManufactured.OutboundManufacturedBuilder reviewPassTime(final LocalDateTime reviewPassTime) {
         this.reviewPassTime = reviewPassTime;
         return this;
      }

      @JsonProperty("basicClass")
      public OutboundManufactured.OutboundManufacturedBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("projectIds")
      public OutboundManufactured.OutboundManufacturedBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public OutboundManufactured.OutboundManufacturedBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("amount")
      public OutboundManufactured.OutboundManufacturedBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("approveRecordId")
      public OutboundManufactured.OutboundManufacturedBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      @JsonProperty("inboundManufacturedId")
      public OutboundManufactured.OutboundManufacturedBuilder inboundManufacturedId(final Long inboundManufacturedId) {
         this.inboundManufacturedId = inboundManufacturedId;
         return this;
      }

      public OutboundManufactured build() {
         return new OutboundManufactured(
            this.id,
            this.serialNumber,
            this.applicantId,
            this.applicantName,
            this.applicationTime,
            this.recipients,
            this.reviewStatus,
            this.reviewPassTime,
            this.basicClass,
            this.projectIds,
            this.amountExcludingVat,
            this.amount,
            this.approveRecordId,
            this.inboundManufacturedId
         );
      }

      @Override
      public String toString() {
         return "OutboundManufactured.OutboundManufacturedBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", applicationTime="
            + this.applicationTime
            + ", recipients="
            + this.recipients
            + ", reviewStatus="
            + this.reviewStatus
            + ", reviewPassTime="
            + this.reviewPassTime
            + ", basicClass="
            + this.basicClass
            + ", projectIds="
            + this.projectIds
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", amount="
            + this.amount
            + ", approveRecordId="
            + this.approveRecordId
            + ", inboundManufacturedId="
            + this.inboundManufacturedId
            + ")";
      }
   }
}
