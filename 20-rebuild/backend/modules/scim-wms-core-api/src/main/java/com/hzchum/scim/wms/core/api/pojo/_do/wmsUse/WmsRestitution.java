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

@ApiModel(value = "WmsRestitution对象", description = "归还单")
@Entity
@TableName("wms_restitution")
@Table(name = "wms_restitution")
public class WmsRestitution extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "审核出库单编号", notes = "审核出库单编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '审核出库单编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "outboundId", value = "出库单ID", notes = "出库单ID")
   @JsonProperty("outboundId")
   @JSONField(name = "outboundId")
   @TableField("outbound_id")
   @Column(name = "outbound_id", columnDefinition = "bigint  COMMENT '出库单ID'", nullable = true)
   private Long outboundId;
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
   @ApiModelProperty(name = "recipientId", value = "退还人ID", notes = "退还人ID")
   @JsonProperty("recipientId")
   @JSONField(name = "recipientId")
   @TableField("recipient_id")
   @Column(name = "recipient_id", columnDefinition = "bigint  COMMENT '退还人ID'", nullable = true)
   private Long recipientId;
   @ApiModelProperty(name = "recipientName", value = "退还人名称", notes = "退还人名称")
   @JsonProperty("recipientName")
   @JSONField(name = "recipientName")
   @TableField("recipient_name")
   @Column(name = "recipient_name", columnDefinition = "varchar(128)  COMMENT '退还人名称'", nullable = true)
   private String recipientName;
   @ApiModelProperty(name = "reviewTime", value = "审核时间", notes = "审核时间")
   @JsonProperty("reviewTime")
   @JSONField(name = "reviewTime")
   @TableField("review_time")
   @Column(name = "review_time", columnDefinition = "datetime  COMMENT '审核时间'", nullable = true)
   private LocalDateTime reviewTime;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态", notes = "审核状态")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int  COMMENT '审核状态'", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "restitutionType", value = "退还类型", notes = "退还类型")
   @JsonProperty("restitutionType")
   @JSONField(name = "restitutionType")
   @TableField("restitution_type")
   @Column(name = "restitution_type", columnDefinition = "int  COMMENT '1归还 2报损'", nullable = true)
   private Integer restitutionType;

   public static WmsRestitution.WmsRestitutionBuilder builder() {
      return new WmsRestitution.WmsRestitutionBuilder();
   }

   public WmsRestitution() {
   }

   public WmsRestitution(
      final Long id,
      final String serialNumber,
      final Long outboundId,
      final Long applicantId,
      final String applicantName,
      final Long recipientId,
      final String recipientName,
      final LocalDateTime reviewTime,
      final Integer reviewStatus,
      final Integer restitutionType
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.outboundId = outboundId;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.recipientId = recipientId;
      this.recipientName = recipientName;
      this.reviewTime = reviewTime;
      this.reviewStatus = reviewStatus;
      this.restitutionType = restitutionType;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getOutboundId() {
      return this.outboundId;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public String getRecipientName() {
      return this.recipientName;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Integer getRestitutionType() {
      return this.restitutionType;
   }

   public WmsRestitution setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public WmsRestitution setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("outboundId")
   public WmsRestitution setOutboundId(final Long outboundId) {
      this.outboundId = outboundId;
      return this;
   }

   @JsonProperty("applicantId")
   public WmsRestitution setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public WmsRestitution setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("recipientId")
   public WmsRestitution setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
      return this;
   }

   @JsonProperty("recipientName")
   public WmsRestitution setRecipientName(final String recipientName) {
      this.recipientName = recipientName;
      return this;
   }

   @JsonProperty("reviewTime")
   public WmsRestitution setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
      return this;
   }

   @JsonProperty("reviewStatus")
   public WmsRestitution setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("restitutionType")
   public WmsRestitution setRestitutionType(final Integer restitutionType) {
      this.restitutionType = restitutionType;
      return this;
   }

   @Override
   public String toString() {
      return "WmsRestitution(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", outboundId="
         + this.getOutboundId()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", recipientId="
         + this.getRecipientId()
         + ", recipientName="
         + this.getRecipientName()
         + ", reviewTime="
         + this.getReviewTime()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", restitutionType="
         + this.getRestitutionType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsRestitution)) {
         return false;
      }

      WmsRestitution other = (WmsRestitution)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$outboundId = this.getOutboundId();
         Object other$outboundId = other.getOutboundId();
         if (this$outboundId == null ? other$outboundId == null : this$outboundId.equals(other$outboundId)) {
            Object this$applicantId = this.getApplicantId();
            Object other$applicantId = other.getApplicantId();
            if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
               Object this$recipientId = this.getRecipientId();
               Object other$recipientId = other.getRecipientId();
               if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
                  Object this$reviewStatus = this.getReviewStatus();
                  Object other$reviewStatus = other.getReviewStatus();
                  if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                     Object this$restitutionType = this.getRestitutionType();
                     Object other$restitutionType = other.getRestitutionType();
                     if (this$restitutionType == null ? other$restitutionType == null : this$restitutionType.equals(other$restitutionType)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$applicantName = this.getApplicantName();
                           Object other$applicantName = other.getApplicantName();
                           if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                              Object this$recipientName = this.getRecipientName();
                              Object other$recipientName = other.getRecipientName();
                              if (this$recipientName == null ? other$recipientName == null : this$recipientName.equals(other$recipientName)) {
                                 Object this$reviewTime = this.getReviewTime();
                                 Object other$reviewTime = other.getReviewTime();
                                 return this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime);
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
      return other instanceof WmsRestitution;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $outboundId = this.getOutboundId();
      result = result * 59 + ($outboundId == null ? 43 : $outboundId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $restitutionType = this.getRestitutionType();
      result = result * 59 + ($restitutionType == null ? 43 : $restitutionType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $recipientName = this.getRecipientName();
      result = result * 59 + ($recipientName == null ? 43 : $recipientName.hashCode());
      Object $reviewTime = this.getReviewTime();
      return result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
   }

   public static class WmsRestitutionBuilder {
      private Long id;
      private String serialNumber;
      private Long outboundId;
      private Long applicantId;
      private String applicantName;
      private Long recipientId;
      private String recipientName;
      private LocalDateTime reviewTime;
      private Integer reviewStatus;
      private Integer restitutionType;

      WmsRestitutionBuilder() {
      }

      public WmsRestitution.WmsRestitutionBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public WmsRestitution.WmsRestitutionBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("outboundId")
      public WmsRestitution.WmsRestitutionBuilder outboundId(final Long outboundId) {
         this.outboundId = outboundId;
         return this;
      }

      @JsonProperty("applicantId")
      public WmsRestitution.WmsRestitutionBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public WmsRestitution.WmsRestitutionBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("recipientId")
      public WmsRestitution.WmsRestitutionBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      @JsonProperty("recipientName")
      public WmsRestitution.WmsRestitutionBuilder recipientName(final String recipientName) {
         this.recipientName = recipientName;
         return this;
      }

      @JsonProperty("reviewTime")
      public WmsRestitution.WmsRestitutionBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      @JsonProperty("reviewStatus")
      public WmsRestitution.WmsRestitutionBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("restitutionType")
      public WmsRestitution.WmsRestitutionBuilder restitutionType(final Integer restitutionType) {
         this.restitutionType = restitutionType;
         return this;
      }

      public WmsRestitution build() {
         return new WmsRestitution(
            this.id,
            this.serialNumber,
            this.outboundId,
            this.applicantId,
            this.applicantName,
            this.recipientId,
            this.recipientName,
            this.reviewTime,
            this.reviewStatus,
            this.restitutionType
         );
      }

      @Override
      public String toString() {
         return "WmsRestitution.WmsRestitutionBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", outboundId="
            + this.outboundId
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", recipientId="
            + this.recipientId
            + ", recipientName="
            + this.recipientName
            + ", reviewTime="
            + this.reviewTime
            + ", reviewStatus="
            + this.reviewStatus
            + ", restitutionType="
            + this.restitutionType
            + ")";
      }
   }
}
