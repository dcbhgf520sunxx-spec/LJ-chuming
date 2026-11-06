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

@ApiModel(value = "WmsBorrow对象", description = "借用单")
@Entity
@TableName("wms_borrow")
@Table(name = "wms_borrow")
@org.hibernate.annotations.Table(appliesTo = "wms_borrow")
public class WmsBorrow extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
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
   @Column(name = "reviewer_name", columnDefinition = "varchar(128)  COMMENT '审核人名称'", nullable = true)
   private String reviewerName;
   @ApiModelProperty(name = "recipients", value = "领用人名称集", notes = "领用人名称集")
   @JsonProperty("recipients")
   @JSONField(name = "recipients")
   @TableField("recipients")
   @Column(name = "recipients", columnDefinition = "text  COMMENT '领用人名称集'", nullable = true)
   private String recipients;
   @ApiModelProperty(name = "outboundTime", value = "出库时间", notes = "出库时间")
   @JsonProperty("outboundTime")
   @JSONField(name = "outboundTime")
   @TableField("outbound_time")
   @Column(name = "outbound_time", columnDefinition = "datetime  COMMENT '出库时间'", nullable = true)
   private LocalDateTime outboundTime;
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
   @ApiModelProperty(name = "userUpdateTime", value = "用户修改时间", notes = "用户修改时间")
   @JsonProperty("userUpdateTime")
   @JSONField(name = "userUpdateTime")
   @TableField("user_update_time")
   @Column(name = "user_update_time", columnDefinition = "datetime  COMMENT '用户修改时间'", nullable = true)
   private LocalDateTime userUpdateTime;
   @ApiModelProperty(name = "applicationSn", value = "申请出库单编号", notes = "申请出库单编号")
   @JsonProperty("applicationSn")
   @JSONField(name = "applicationSn")
   @TableField("application_SN")
   @Column(name = "application_SN", columnDefinition = "varchar(255)  COMMENT '申请出库单编号'", nullable = true)
   private String applicationSn;
   @ApiModelProperty(name = "boolPrinted", value = "是否打印", notes = "是否打印")
   @JsonProperty("boolPrinted")
   @JSONField(name = "boolPrinted")
   @TableField("bool_printed")
   @Column(name = "bool_printed", columnDefinition = "tinyint(1)  COMMENT '是否打印'", nullable = true)
   private Boolean boolPrinted;
   @ApiModelProperty(name = "containBasicClass", value = "出库单包含基础类型", notes = "出库单包含基础类型")
   @JsonProperty("containBasicClass")
   @JSONField(name = "containBasicClass")
   @TableField("contain_basic_class")
   @Column(name = "contain_basic_class", columnDefinition = "int  COMMENT '出库单包含基础类型'", nullable = true)
   private Integer containBasicClass;
   @ApiModelProperty(name = "outboundEndTime", value = "出库结束时间", notes = "出库结束时间")
   @JsonProperty("outboundEndTime")
   @JSONField(name = "outboundEndTime")
   @TableField("outbound_end_time")
   @Column(name = "outbound_end_time", columnDefinition = "datetime  COMMENT '出库结束时间'", nullable = true)
   private LocalDateTime outboundEndTime;
   @ApiModelProperty(name = "outboundStartTime", value = "出库开始时间", notes = "出库开始时间")
   @JsonProperty("outboundStartTime")
   @JSONField(name = "outboundStartTime")
   @TableField("outbound_start_time")
   @Column(name = "outbound_start_time", columnDefinition = "datetime  COMMENT '出库开始时间'", nullable = true)
   private LocalDateTime outboundStartTime;
   @ApiModelProperty(name = "projectIds", value = "出库项目ID集", notes = "出库项目ID集")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   @TableField("project_ids")
   @Column(name = "project_ids", columnDefinition = "varchar(255)  COMMENT '出库项目ID集'", nullable = true)
   private String projectIds;

   public static WmsBorrow.WmsBorrowBuilder builder() {
      return new WmsBorrow.WmsBorrowBuilder();
   }

   public WmsBorrow() {
   }

   public WmsBorrow(
      final Long id,
      final String serialNumber,
      final Long applicantId,
      final String applicantName,
      final Long reviewerId,
      final String reviewerName,
      final String recipients,
      final LocalDateTime outboundTime,
      final LocalDateTime reviewTime,
      final Integer reviewStatus,
      final LocalDateTime userUpdateTime,
      final String applicationSn,
      final Boolean boolPrinted,
      final Integer containBasicClass,
      final LocalDateTime outboundEndTime,
      final LocalDateTime outboundStartTime,
      final String projectIds
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.reviewerId = reviewerId;
      this.reviewerName = reviewerName;
      this.recipients = recipients;
      this.outboundTime = outboundTime;
      this.reviewTime = reviewTime;
      this.reviewStatus = reviewStatus;
      this.userUpdateTime = userUpdateTime;
      this.applicationSn = applicationSn;
      this.boolPrinted = boolPrinted;
      this.containBasicClass = containBasicClass;
      this.outboundEndTime = outboundEndTime;
      this.outboundStartTime = outboundStartTime;
      this.projectIds = projectIds;
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

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public String getRecipients() {
      return this.recipients;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public String getApplicationSn() {
      return this.applicationSn;
   }

   public Boolean getBoolPrinted() {
      return this.boolPrinted;
   }

   public Integer getContainBasicClass() {
      return this.containBasicClass;
   }

   public LocalDateTime getOutboundEndTime() {
      return this.outboundEndTime;
   }

   public LocalDateTime getOutboundStartTime() {
      return this.outboundStartTime;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   @JsonProperty("id")
   public WmsBorrow setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public WmsBorrow setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("applicantId")
   public WmsBorrow setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public WmsBorrow setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("reviewerId")
   public WmsBorrow setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
      return this;
   }

   @JsonProperty("reviewerName")
   public WmsBorrow setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
      return this;
   }

   @JsonProperty("recipients")
   public WmsBorrow setRecipients(final String recipients) {
      this.recipients = recipients;
      return this;
   }

   @JsonProperty("outboundTime")
   public WmsBorrow setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
      return this;
   }

   @JsonProperty("reviewTime")
   public WmsBorrow setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
      return this;
   }

   @JsonProperty("reviewStatus")
   public WmsBorrow setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("userUpdateTime")
   public WmsBorrow setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
      return this;
   }

   @JsonProperty("applicationSn")
   public WmsBorrow setApplicationSn(final String applicationSn) {
      this.applicationSn = applicationSn;
      return this;
   }

   @JsonProperty("boolPrinted")
   public WmsBorrow setBoolPrinted(final Boolean boolPrinted) {
      this.boolPrinted = boolPrinted;
      return this;
   }

   @JsonProperty("containBasicClass")
   public WmsBorrow setContainBasicClass(final Integer containBasicClass) {
      this.containBasicClass = containBasicClass;
      return this;
   }

   @JsonProperty("outboundEndTime")
   public WmsBorrow setOutboundEndTime(final LocalDateTime outboundEndTime) {
      this.outboundEndTime = outboundEndTime;
      return this;
   }

   @JsonProperty("outboundStartTime")
   public WmsBorrow setOutboundStartTime(final LocalDateTime outboundStartTime) {
      this.outboundStartTime = outboundStartTime;
      return this;
   }

   @JsonProperty("projectIds")
   public WmsBorrow setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @Override
   public String toString() {
      return "WmsBorrow(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewerId="
         + this.getReviewerId()
         + ", reviewerName="
         + this.getReviewerName()
         + ", recipients="
         + this.getRecipients()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", reviewTime="
         + this.getReviewTime()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", applicationSn="
         + this.getApplicationSn()
         + ", boolPrinted="
         + this.getBoolPrinted()
         + ", containBasicClass="
         + this.getContainBasicClass()
         + ", outboundEndTime="
         + this.getOutboundEndTime()
         + ", outboundStartTime="
         + this.getOutboundStartTime()
         + ", projectIds="
         + this.getProjectIds()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsBorrow)) {
         return false;
      }

      WmsBorrow other = (WmsBorrow)o;
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
            Object this$reviewerId = this.getReviewerId();
            Object other$reviewerId = other.getReviewerId();
            if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
               Object this$reviewStatus = this.getReviewStatus();
               Object other$reviewStatus = other.getReviewStatus();
               if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                  Object this$boolPrinted = this.getBoolPrinted();
                  Object other$boolPrinted = other.getBoolPrinted();
                  if (this$boolPrinted == null ? other$boolPrinted == null : this$boolPrinted.equals(other$boolPrinted)) {
                     Object this$containBasicClass = this.getContainBasicClass();
                     Object other$containBasicClass = other.getContainBasicClass();
                     if (this$containBasicClass == null ? other$containBasicClass == null : this$containBasicClass.equals(other$containBasicClass)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$applicantName = this.getApplicantName();
                           Object other$applicantName = other.getApplicantName();
                           if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                              Object this$reviewerName = this.getReviewerName();
                              Object other$reviewerName = other.getReviewerName();
                              if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                                 Object this$recipients = this.getRecipients();
                                 Object other$recipients = other.getRecipients();
                                 if (this$recipients == null ? other$recipients == null : this$recipients.equals(other$recipients)) {
                                    Object this$outboundTime = this.getOutboundTime();
                                    Object other$outboundTime = other.getOutboundTime();
                                    if (this$outboundTime == null ? other$outboundTime == null : this$outboundTime.equals(other$outboundTime)) {
                                       Object this$reviewTime = this.getReviewTime();
                                       Object other$reviewTime = other.getReviewTime();
                                       if (this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime)) {
                                          Object this$userUpdateTime = this.getUserUpdateTime();
                                          Object other$userUpdateTime = other.getUserUpdateTime();
                                          if (this$userUpdateTime == null ? other$userUpdateTime == null : this$userUpdateTime.equals(other$userUpdateTime)) {
                                             Object this$applicationSn = this.getApplicationSn();
                                             Object other$applicationSn = other.getApplicationSn();
                                             if (this$applicationSn == null ? other$applicationSn == null : this$applicationSn.equals(other$applicationSn)) {
                                                Object this$outboundEndTime = this.getOutboundEndTime();
                                                Object other$outboundEndTime = other.getOutboundEndTime();
                                                if (this$outboundEndTime == null
                                                   ? other$outboundEndTime == null
                                                   : this$outboundEndTime.equals(other$outboundEndTime)) {
                                                   Object this$outboundStartTime = this.getOutboundStartTime();
                                                   Object other$outboundStartTime = other.getOutboundStartTime();
                                                   if (this$outboundStartTime == null
                                                      ? other$outboundStartTime == null
                                                      : this$outboundStartTime.equals(other$outboundStartTime)) {
                                                      Object this$projectIds = this.getProjectIds();
                                                      Object other$projectIds = other.getProjectIds();
                                                      return this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds);
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
      return other instanceof WmsBorrow;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $boolPrinted = this.getBoolPrinted();
      result = result * 59 + ($boolPrinted == null ? 43 : $boolPrinted.hashCode());
      Object $containBasicClass = this.getContainBasicClass();
      result = result * 59 + ($containBasicClass == null ? 43 : $containBasicClass.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $recipients = this.getRecipients();
      result = result * 59 + ($recipients == null ? 43 : $recipients.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $applicationSn = this.getApplicationSn();
      result = result * 59 + ($applicationSn == null ? 43 : $applicationSn.hashCode());
      Object $outboundEndTime = this.getOutboundEndTime();
      result = result * 59 + ($outboundEndTime == null ? 43 : $outboundEndTime.hashCode());
      Object $outboundStartTime = this.getOutboundStartTime();
      result = result * 59 + ($outboundStartTime == null ? 43 : $outboundStartTime.hashCode());
      Object $projectIds = this.getProjectIds();
      return result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
   }

   public static class WmsBorrowBuilder {
      private Long id;
      private String serialNumber;
      private Long applicantId;
      private String applicantName;
      private Long reviewerId;
      private String reviewerName;
      private String recipients;
      private LocalDateTime outboundTime;
      private LocalDateTime reviewTime;
      private Integer reviewStatus;
      private LocalDateTime userUpdateTime;
      private String applicationSn;
      private Boolean boolPrinted;
      private Integer containBasicClass;
      private LocalDateTime outboundEndTime;
      private LocalDateTime outboundStartTime;
      private String projectIds;

      WmsBorrowBuilder() {
      }

      @JsonProperty("id")
      public WmsBorrow.WmsBorrowBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public WmsBorrow.WmsBorrowBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("applicantId")
      public WmsBorrow.WmsBorrowBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public WmsBorrow.WmsBorrowBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("reviewerId")
      public WmsBorrow.WmsBorrowBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      @JsonProperty("reviewerName")
      public WmsBorrow.WmsBorrowBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      @JsonProperty("recipients")
      public WmsBorrow.WmsBorrowBuilder recipients(final String recipients) {
         this.recipients = recipients;
         return this;
      }

      @JsonProperty("outboundTime")
      public WmsBorrow.WmsBorrowBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      @JsonProperty("reviewTime")
      public WmsBorrow.WmsBorrowBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      @JsonProperty("reviewStatus")
      public WmsBorrow.WmsBorrowBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("userUpdateTime")
      public WmsBorrow.WmsBorrowBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      @JsonProperty("applicationSn")
      public WmsBorrow.WmsBorrowBuilder applicationSn(final String applicationSn) {
         this.applicationSn = applicationSn;
         return this;
      }

      @JsonProperty("boolPrinted")
      public WmsBorrow.WmsBorrowBuilder boolPrinted(final Boolean boolPrinted) {
         this.boolPrinted = boolPrinted;
         return this;
      }

      @JsonProperty("containBasicClass")
      public WmsBorrow.WmsBorrowBuilder containBasicClass(final Integer containBasicClass) {
         this.containBasicClass = containBasicClass;
         return this;
      }

      @JsonProperty("outboundEndTime")
      public WmsBorrow.WmsBorrowBuilder outboundEndTime(final LocalDateTime outboundEndTime) {
         this.outboundEndTime = outboundEndTime;
         return this;
      }

      @JsonProperty("outboundStartTime")
      public WmsBorrow.WmsBorrowBuilder outboundStartTime(final LocalDateTime outboundStartTime) {
         this.outboundStartTime = outboundStartTime;
         return this;
      }

      @JsonProperty("projectIds")
      public WmsBorrow.WmsBorrowBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public WmsBorrow build() {
         return new WmsBorrow(
            this.id,
            this.serialNumber,
            this.applicantId,
            this.applicantName,
            this.reviewerId,
            this.reviewerName,
            this.recipients,
            this.outboundTime,
            this.reviewTime,
            this.reviewStatus,
            this.userUpdateTime,
            this.applicationSn,
            this.boolPrinted,
            this.containBasicClass,
            this.outboundEndTime,
            this.outboundStartTime,
            this.projectIds
         );
      }

      @Override
      public String toString() {
         return "WmsBorrow.WmsBorrowBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", reviewerId="
            + this.reviewerId
            + ", reviewerName="
            + this.reviewerName
            + ", recipients="
            + this.recipients
            + ", outboundTime="
            + this.outboundTime
            + ", reviewTime="
            + this.reviewTime
            + ", reviewStatus="
            + this.reviewStatus
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", applicationSn="
            + this.applicationSn
            + ", boolPrinted="
            + this.boolPrinted
            + ", containBasicClass="
            + this.containBasicClass
            + ", outboundEndTime="
            + this.outboundEndTime
            + ", outboundStartTime="
            + this.outboundStartTime
            + ", projectIds="
            + this.projectIds
            + ")";
      }
   }
}
