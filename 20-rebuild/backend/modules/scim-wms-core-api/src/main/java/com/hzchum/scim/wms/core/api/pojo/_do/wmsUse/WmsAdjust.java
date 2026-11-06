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

@ApiModel(value = "WmsAdjust对象", description = "")
@Entity
@TableName("wms_adjust")
@Table(name = "wms_adjust")
@org.hibernate.annotations.Table(appliesTo = "wms_adjust")
public class WmsAdjust extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "调整单号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number")
   private String serialNumber;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status")
   private Integer reviewStatus;
   @ApiModelProperty(name = "reviewTime", value = "审核时间")
   @JsonProperty("reviewTime")
   @JSONField(name = "reviewTime")
   @TableField("review_time")
   @Column(name = "review_time")
   private LocalDateTime reviewTime;
   @ApiModelProperty(name = "inboundId", value = "入库单id")
   @JsonProperty("inboundId")
   @JSONField(name = "inboundId")
   @TableField("inbound_id")
   @Column(name = "inbound_id")
   private Long inboundId;
   @ApiModelProperty(name = "applicantId", value = "申请人ID")
   @JsonProperty("applicantId")
   @JSONField(name = "applicantId")
   @TableField("applicant_id")
   @Column(name = "applicant_id")
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称")
   @JsonProperty("applicantName")
   @JSONField(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name")
   private String applicantName;
   @ApiModelProperty(name = "reviewerName", value = "审核人名称")
   @JsonProperty("reviewerName")
   @JSONField(name = "reviewerName")
   @TableField("reviewer_name")
   @Column(name = "reviewer_name")
   private String reviewerName;
   @ApiModelProperty(name = "reviewerId", value = "审核人ID")
   @JsonProperty("reviewerId")
   @JSONField(name = "reviewerId")
   @TableField("reviewer_id")
   @Column(name = "reviewer_id")
   private Long reviewerId;
   @ApiModelProperty(name = "approveRecordId", value = "审批日志ID", notes = "审批日志ID")
   @JsonProperty("approveRecordId")
   @JSONField(name = "approveRecordId")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint  COMMENT '审批日志ID'", nullable = true)
   private Long approveRecordId;

   public static WmsAdjust.WmsAdjustBuilder builder() {
      return new WmsAdjust.WmsAdjustBuilder();
   }

   public WmsAdjust() {
   }

   public WmsAdjust(
      final Long id,
      final String serialNumber,
      final Integer reviewStatus,
      final LocalDateTime reviewTime,
      final Long inboundId,
      final Long applicantId,
      final String applicantName,
      final String reviewerName,
      final Long reviewerId,
      final Long approveRecordId
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.reviewStatus = reviewStatus;
      this.reviewTime = reviewTime;
      this.inboundId = inboundId;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.reviewerName = reviewerName;
      this.reviewerId = reviewerId;
      this.approveRecordId = approveRecordId;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public WmsAdjust setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public WmsAdjust setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("reviewStatus")
   public WmsAdjust setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("reviewTime")
   public WmsAdjust setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
      return this;
   }

   @JsonProperty("inboundId")
   public WmsAdjust setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
      return this;
   }

   @JsonProperty("applicantId")
   public WmsAdjust setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public WmsAdjust setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("reviewerName")
   public WmsAdjust setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
      return this;
   }

   @JsonProperty("reviewerId")
   public WmsAdjust setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
      return this;
   }

   @JsonProperty("approveRecordId")
   public WmsAdjust setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   @Override
   public String toString() {
      return "WmsAdjust(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", reviewTime="
         + this.getReviewTime()
         + ", inboundId="
         + this.getInboundId()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewerName="
         + this.getReviewerName()
         + ", reviewerId="
         + this.getReviewerId()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsAdjust)) {
         return false;
      }

      WmsAdjust other = (WmsAdjust)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$reviewStatus = this.getReviewStatus();
         Object other$reviewStatus = other.getReviewStatus();
         if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
            Object this$inboundId = this.getInboundId();
            Object other$inboundId = other.getInboundId();
            if (this$inboundId == null ? other$inboundId == null : this$inboundId.equals(other$inboundId)) {
               Object this$applicantId = this.getApplicantId();
               Object other$applicantId = other.getApplicantId();
               if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                  Object this$reviewerId = this.getReviewerId();
                  Object other$reviewerId = other.getReviewerId();
                  if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
                     Object this$approveRecordId = this.getApproveRecordId();
                     Object other$approveRecordId = other.getApproveRecordId();
                     if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$reviewTime = this.getReviewTime();
                           Object other$reviewTime = other.getReviewTime();
                           if (this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime)) {
                              Object this$applicantName = this.getApplicantName();
                              Object other$applicantName = other.getApplicantName();
                              if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                 Object this$reviewerName = this.getReviewerName();
                                 Object other$reviewerName = other.getReviewerName();
                                 return this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName);
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof WmsAdjust;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewerName = this.getReviewerName();
      return result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
   }

   public static class WmsAdjustBuilder {
      private Long id;
      private String serialNumber;
      private Integer reviewStatus;
      private LocalDateTime reviewTime;
      private Long inboundId;
      private Long applicantId;
      private String applicantName;
      private String reviewerName;
      private Long reviewerId;
      private Long approveRecordId;

      WmsAdjustBuilder() {
      }

      public WmsAdjust.WmsAdjustBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public WmsAdjust.WmsAdjustBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("reviewStatus")
      public WmsAdjust.WmsAdjustBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("reviewTime")
      public WmsAdjust.WmsAdjustBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      @JsonProperty("inboundId")
      public WmsAdjust.WmsAdjustBuilder inboundId(final Long inboundId) {
         this.inboundId = inboundId;
         return this;
      }

      @JsonProperty("applicantId")
      public WmsAdjust.WmsAdjustBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public WmsAdjust.WmsAdjustBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("reviewerName")
      public WmsAdjust.WmsAdjustBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      @JsonProperty("reviewerId")
      public WmsAdjust.WmsAdjustBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      @JsonProperty("approveRecordId")
      public WmsAdjust.WmsAdjustBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public WmsAdjust build() {
         return new WmsAdjust(
            this.id,
            this.serialNumber,
            this.reviewStatus,
            this.reviewTime,
            this.inboundId,
            this.applicantId,
            this.applicantName,
            this.reviewerName,
            this.reviewerId,
            this.approveRecordId
         );
      }

      @Override
      public String toString() {
         return "WmsAdjust.WmsAdjustBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", reviewStatus="
            + this.reviewStatus
            + ", reviewTime="
            + this.reviewTime
            + ", inboundId="
            + this.inboundId
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", reviewerName="
            + this.reviewerName
            + ", reviewerId="
            + this.reviewerId
            + ", approveRecordId="
            + this.approveRecordId
            + ")";
      }
   }
}
