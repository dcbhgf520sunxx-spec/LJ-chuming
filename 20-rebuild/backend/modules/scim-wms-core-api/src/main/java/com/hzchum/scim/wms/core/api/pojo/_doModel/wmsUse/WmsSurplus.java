package com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse;

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

@ApiModel(value = "WmsSurplus对象", description = "")
@Entity
@TableName("wms_surplus")
@Table(name = "wms_surplus")
@org.hibernate.annotations.Table(appliesTo = "wms_surplus")
public class WmsSurplus extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "reviewTime")
   @TableField("review_time")
   @Column(name = "review_time", columnDefinition = "datetime(6)  COMMENT ''", nullable = true)
   private LocalDateTime reviewTime;
   @ApiModelProperty(name = "applicantId")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String applicantName;
   @ApiModelProperty(name = "reviewerName")
   @TableField("reviewer_name")
   @Column(name = "reviewer_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String reviewerName;
   @ApiModelProperty(name = "reviewerId")
   @TableField("reviewer_id")
   @Column(name = "reviewer_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long reviewerId;
   @ApiModelProperty(name = "basicClass", value = "物料基础分类", notes = "物料基础分类")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础分类'", nullable = false)
   private Integer basicClass;
   @ApiModelProperty(name = "projectIds")
   @TableField("project_ids")
   @Column(name = "project_ids", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String projectIds;
   @ApiModelProperty(name = "classifyIds")
   @TableField("classify_ids")
   @Column(name = "classify_ids", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String classifyIds;
   @ApiModelProperty(name = "approveRecordIdNow", value = "当前审批日志ID")
   @JsonProperty("approveRecordIdNow")
   @JSONField(name = "approveRecordIdNow")
   @TableField("approve_record_id_now")
   @Column(name = "approve_record_id_now", columnDefinition = "bigint COMMENT '当前审批日志ID'", nullable = true)
   private Long approveRecordIdNow;
   @ApiModelProperty(name = "amountExcludingVat", value = "入库金额[不含税]", notes = "入库金额[不含税]")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_VAT")
   @Column(name = "amount_excluding_VAT", columnDefinition = "decimal(32,8)  COMMENT '入库金额[不含税]'", nullable = true)
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "amountExcludingVatNoFreight", value = "入库金额[不含税 不含运费]", notes = "入库金额[不含税 不含运费]")
   @JsonProperty("amountExcludingVatNoFreight")
   @JSONField(name = "amountExcludingVatNoFreight")
   @TableField("amount_excluding_VAT_no_freight")
   @Column(name = "amount_excluding_VAT_no_freight", columnDefinition = "decimal(32,8)  COMMENT '入库金额[不含税 不含运费]'", nullable = true)
   private BigDecimal amountExcludingVatNoFreight;
   @ApiModelProperty(name = "amount", value = "入库金额[含税]", notes = "入库金额[含税]")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,8)  COMMENT '入库金额[含税]'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "amountNoFreight", value = "入库金额[含税 不含运费]", notes = "入库金额[含税 不含运费]")
   @JsonProperty("amountNoFreight")
   @JSONField(name = "amountNoFreight")
   @TableField("amount_no_freight")
   @Column(name = "amount_no_freight", columnDefinition = "decimal(32,8)  COMMENT '入库金额[含税 不含运费]'", nullable = true)
   private BigDecimal amountNoFreight;
   @ApiModelProperty(name = "applicationSn", value = "申请出库单编号", notes = "申请出库单编号")
   @JsonProperty("applicationSn")
   @JSONField(name = "applicationSn")
   @TableField("application_SN")
   @Column(name = "application_SN", columnDefinition = "varchar(255)  COMMENT '申请出库单编号'", nullable = true)
   private String applicationSn;

   public static WmsSurplus.WmsSurplusBuilder builder() {
      return new WmsSurplus.WmsSurplusBuilder();
   }

   public WmsSurplus() {
   }

   public WmsSurplus(
      final Long id,
      final String serialNumber,
      final Integer reviewStatus,
      final LocalDateTime reviewTime,
      final Long applicantId,
      final String applicantName,
      final String reviewerName,
      final Long reviewerId,
      final Integer basicClass,
      final String projectIds,
      final String classifyIds,
      final Long approveRecordIdNow,
      final BigDecimal amountExcludingVat,
      final BigDecimal amountExcludingVatNoFreight,
      final BigDecimal amount,
      final BigDecimal amountNoFreight,
      final String applicationSn
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.reviewStatus = reviewStatus;
      this.reviewTime = reviewTime;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.reviewerName = reviewerName;
      this.reviewerId = reviewerId;
      this.basicClass = basicClass;
      this.projectIds = projectIds;
      this.classifyIds = classifyIds;
      this.approveRecordIdNow = approveRecordIdNow;
      this.amountExcludingVat = amountExcludingVat;
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      this.amount = amount;
      this.amountNoFreight = amountNoFreight;
      this.applicationSn = applicationSn;
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

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public String getClassifyIds() {
      return this.classifyIds;
   }

   public Long getApproveRecordIdNow() {
      return this.approveRecordIdNow;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getAmountExcludingVatNoFreight() {
      return this.amountExcludingVatNoFreight;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountNoFreight() {
      return this.amountNoFreight;
   }

   public String getApplicationSn() {
      return this.applicationSn;
   }

   public WmsSurplus setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsSurplus setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public WmsSurplus setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   public WmsSurplus setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
      return this;
   }

   public WmsSurplus setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   public WmsSurplus setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   public WmsSurplus setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
      return this;
   }

   public WmsSurplus setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
      return this;
   }

   public WmsSurplus setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public WmsSurplus setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   public WmsSurplus setClassifyIds(final String classifyIds) {
      this.classifyIds = classifyIds;
      return this;
   }

   @JsonProperty("approveRecordIdNow")
   public WmsSurplus setApproveRecordIdNow(final Long approveRecordIdNow) {
      this.approveRecordIdNow = approveRecordIdNow;
      return this;
   }

   @JsonProperty("amountExcludingVat")
   public WmsSurplus setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
      return this;
   }

   @JsonProperty("amountExcludingVatNoFreight")
   public WmsSurplus setAmountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
      this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
      return this;
   }

   @JsonProperty("amount")
   public WmsSurplus setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("amountNoFreight")
   public WmsSurplus setAmountNoFreight(final BigDecimal amountNoFreight) {
      this.amountNoFreight = amountNoFreight;
      return this;
   }

   @JsonProperty("applicationSn")
   public WmsSurplus setApplicationSn(final String applicationSn) {
      this.applicationSn = applicationSn;
      return this;
   }

   @Override
   public String toString() {
      return "WmsSurplus(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", reviewTime="
         + this.getReviewTime()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewerName="
         + this.getReviewerName()
         + ", reviewerId="
         + this.getReviewerId()
         + ", basicClass="
         + this.getBasicClass()
         + ", projectIds="
         + this.getProjectIds()
         + ", classifyIds="
         + this.getClassifyIds()
         + ", approveRecordIdNow="
         + this.getApproveRecordIdNow()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", amountExcludingVatNoFreight="
         + this.getAmountExcludingVatNoFreight()
         + ", amount="
         + this.getAmount()
         + ", amountNoFreight="
         + this.getAmountNoFreight()
         + ", applicationSn="
         + this.getApplicationSn()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsSurplus)) {
         return false;
      }

      WmsSurplus other = (WmsSurplus)o;
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
            Object this$applicantId = this.getApplicantId();
            Object other$applicantId = other.getApplicantId();
            if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
               Object this$reviewerId = this.getReviewerId();
               Object other$reviewerId = other.getReviewerId();
               if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$approveRecordIdNow = this.getApproveRecordIdNow();
                     Object other$approveRecordIdNow = other.getApproveRecordIdNow();
                     if (this$approveRecordIdNow == null ? other$approveRecordIdNow == null : this$approveRecordIdNow.equals(other$approveRecordIdNow)) {
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
                                 if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                                    Object this$projectIds = this.getProjectIds();
                                    Object other$projectIds = other.getProjectIds();
                                    if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                       Object this$classifyIds = this.getClassifyIds();
                                       Object other$classifyIds = other.getClassifyIds();
                                       if (this$classifyIds == null ? other$classifyIds == null : this$classifyIds.equals(other$classifyIds)) {
                                          Object this$amountExcludingVat = this.getAmountExcludingVat();
                                          Object other$amountExcludingVat = other.getAmountExcludingVat();
                                          if (this$amountExcludingVat == null
                                             ? other$amountExcludingVat == null
                                             : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                             Object this$amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
                                             Object other$amountExcludingVatNoFreight = other.getAmountExcludingVatNoFreight();
                                             if (this$amountExcludingVatNoFreight == null
                                                ? other$amountExcludingVatNoFreight == null
                                                : this$amountExcludingVatNoFreight.equals(other$amountExcludingVatNoFreight)) {
                                                Object this$amount = this.getAmount();
                                                Object other$amount = other.getAmount();
                                                if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                   Object this$amountNoFreight = this.getAmountNoFreight();
                                                   Object other$amountNoFreight = other.getAmountNoFreight();
                                                   if (this$amountNoFreight == null
                                                      ? other$amountNoFreight == null
                                                      : this$amountNoFreight.equals(other$amountNoFreight)) {
                                                      Object this$applicationSn = this.getApplicationSn();
                                                      Object other$applicationSn = other.getApplicationSn();
                                                      return this$applicationSn == null
                                                         ? other$applicationSn == null
                                                         : this$applicationSn.equals(other$applicationSn);
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
      return other instanceof WmsSurplus;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $approveRecordIdNow = this.getApproveRecordIdNow();
      result = result * 59 + ($approveRecordIdNow == null ? 43 : $approveRecordIdNow.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $classifyIds = this.getClassifyIds();
      result = result * 59 + ($classifyIds == null ? 43 : $classifyIds.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $amountExcludingVatNoFreight = this.getAmountExcludingVatNoFreight();
      result = result * 59 + ($amountExcludingVatNoFreight == null ? 43 : $amountExcludingVatNoFreight.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountNoFreight = this.getAmountNoFreight();
      result = result * 59 + ($amountNoFreight == null ? 43 : $amountNoFreight.hashCode());
      Object $applicationSn = this.getApplicationSn();
      return result * 59 + ($applicationSn == null ? 43 : $applicationSn.hashCode());
   }

   public static class WmsSurplusBuilder {
      private Long id;
      private String serialNumber;
      private Integer reviewStatus;
      private LocalDateTime reviewTime;
      private Long applicantId;
      private String applicantName;
      private String reviewerName;
      private Long reviewerId;
      private Integer basicClass;
      private String projectIds;
      private String classifyIds;
      private Long approveRecordIdNow;
      private BigDecimal amountExcludingVat;
      private BigDecimal amountExcludingVatNoFreight;
      private BigDecimal amount;
      private BigDecimal amountNoFreight;
      private String applicationSn;

      WmsSurplusBuilder() {
      }

      public WmsSurplus.WmsSurplusBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsSurplus.WmsSurplusBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public WmsSurplus.WmsSurplusBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public WmsSurplus.WmsSurplusBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public WmsSurplus.WmsSurplusBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public WmsSurplus.WmsSurplusBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public WmsSurplus.WmsSurplusBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public WmsSurplus.WmsSurplusBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      public WmsSurplus.WmsSurplusBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public WmsSurplus.WmsSurplusBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public WmsSurplus.WmsSurplusBuilder classifyIds(final String classifyIds) {
         this.classifyIds = classifyIds;
         return this;
      }

      @JsonProperty("approveRecordIdNow")
      public WmsSurplus.WmsSurplusBuilder approveRecordIdNow(final Long approveRecordIdNow) {
         this.approveRecordIdNow = approveRecordIdNow;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public WmsSurplus.WmsSurplusBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("amountExcludingVatNoFreight")
      public WmsSurplus.WmsSurplusBuilder amountExcludingVatNoFreight(final BigDecimal amountExcludingVatNoFreight) {
         this.amountExcludingVatNoFreight = amountExcludingVatNoFreight;
         return this;
      }

      @JsonProperty("amount")
      public WmsSurplus.WmsSurplusBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountNoFreight")
      public WmsSurplus.WmsSurplusBuilder amountNoFreight(final BigDecimal amountNoFreight) {
         this.amountNoFreight = amountNoFreight;
         return this;
      }

      @JsonProperty("applicationSn")
      public WmsSurplus.WmsSurplusBuilder applicationSn(final String applicationSn) {
         this.applicationSn = applicationSn;
         return this;
      }

      public WmsSurplus build() {
         return new WmsSurplus(
            this.id,
            this.serialNumber,
            this.reviewStatus,
            this.reviewTime,
            this.applicantId,
            this.applicantName,
            this.reviewerName,
            this.reviewerId,
            this.basicClass,
            this.projectIds,
            this.classifyIds,
            this.approveRecordIdNow,
            this.amountExcludingVat,
            this.amountExcludingVatNoFreight,
            this.amount,
            this.amountNoFreight,
            this.applicationSn
         );
      }

      @Override
      public String toString() {
         return "WmsSurplus.WmsSurplusBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", reviewStatus="
            + this.reviewStatus
            + ", reviewTime="
            + this.reviewTime
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", reviewerName="
            + this.reviewerName
            + ", reviewerId="
            + this.reviewerId
            + ", basicClass="
            + this.basicClass
            + ", projectIds="
            + this.projectIds
            + ", classifyIds="
            + this.classifyIds
            + ", approveRecordIdNow="
            + this.approveRecordIdNow
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", amountExcludingVatNoFreight="
            + this.amountExcludingVatNoFreight
            + ", amount="
            + this.amount
            + ", amountNoFreight="
            + this.amountNoFreight
            + ", applicationSn="
            + this.applicationSn
            + ")";
      }
   }
}
