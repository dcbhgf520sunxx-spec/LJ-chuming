package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
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

@ApiModel(value = "盘亏调整对象", description = "盘亏调整")
@Entity
@TableName("wms_deficit")
@Table(name = "wms_deficit")
public class WmsDeficit extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "盘亏单号")
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
   @ApiModelProperty(name = "deficitType", value = "盘亏成本归属 1公司 2项目")
   @JsonProperty("deficitType")
   @JSONField(name = "deficitType")
   @TableField("deficit_type")
   @Column(name = "deficit_type")
   private Integer deficitType;
   @ApiModelProperty(name = "basicClass", value = "物料基础分类")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int(2)  COMMENT '物料基础分类'", nullable = false)
   private Integer basicClass;
   @ApiModelProperty(name = "projectIds", value = "盘亏ID集")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   @TableField(value = "project_ids", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "project_ids")
   private String projectIds;
   @ApiModelProperty(name = "approveRecordId", value = "审批日志ID", notes = "审批日志ID")
   @JsonProperty("approveRecordId")
   @JSONField(name = "approveRecordId")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint  COMMENT '审批日志ID'", nullable = true)
   private Long approveRecordId;

   public static WmsDeficit.WmsDeficitBuilder builder() {
      return new WmsDeficit.WmsDeficitBuilder();
   }

   public WmsDeficit() {
   }

   public WmsDeficit(
      final Long id,
      final String serialNumber,
      final Integer reviewStatus,
      final LocalDateTime reviewTime,
      final Long applicantId,
      final String applicantName,
      final String reviewerName,
      final Long reviewerId,
      final Integer deficitType,
      final Integer basicClass,
      final String projectIds,
      final Long approveRecordId
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.reviewStatus = reviewStatus;
      this.reviewTime = reviewTime;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.reviewerName = reviewerName;
      this.reviewerId = reviewerId;
      this.deficitType = deficitType;
      this.basicClass = basicClass;
      this.projectIds = projectIds;
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

   public Integer getDeficitType() {
      return this.deficitType;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   @JsonProperty("id")
   public WmsDeficit setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public WmsDeficit setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("reviewStatus")
   public WmsDeficit setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("reviewTime")
   public WmsDeficit setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
      return this;
   }

   @JsonProperty("applicantId")
   public WmsDeficit setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public WmsDeficit setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("reviewerName")
   public WmsDeficit setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
      return this;
   }

   @JsonProperty("reviewerId")
   public WmsDeficit setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
      return this;
   }

   @JsonProperty("deficitType")
   public WmsDeficit setDeficitType(final Integer deficitType) {
      this.deficitType = deficitType;
      return this;
   }

   @JsonProperty("basicClass")
   public WmsDeficit setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("projectIds")
   public WmsDeficit setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @JsonProperty("approveRecordId")
   public WmsDeficit setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   @Override
   public String toString() {
      return "WmsDeficit(id="
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
         + ", deficitType="
         + this.getDeficitType()
         + ", basicClass="
         + this.getBasicClass()
         + ", projectIds="
         + this.getProjectIds()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsDeficit)) {
         return false;
      }

      WmsDeficit other = (WmsDeficit)o;
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
                  Object this$deficitType = this.getDeficitType();
                  Object other$deficitType = other.getDeficitType();
                  if (this$deficitType == null ? other$deficitType == null : this$deficitType.equals(other$deficitType)) {
                     Object this$basicClass = this.getBasicClass();
                     Object other$basicClass = other.getBasicClass();
                     if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
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
                                    if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WmsDeficit;
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
      Object $deficitType = this.getDeficitType();
      result = result * 59 + ($deficitType == null ? 43 : $deficitType.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $projectIds = this.getProjectIds();
      return result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
   }

   public static class WmsDeficitBuilder {
      private Long id;
      private String serialNumber;
      private Integer reviewStatus;
      private LocalDateTime reviewTime;
      private Long applicantId;
      private String applicantName;
      private String reviewerName;
      private Long reviewerId;
      private Integer deficitType;
      private Integer basicClass;
      private String projectIds;
      private Long approveRecordId;

      WmsDeficitBuilder() {
      }

      @JsonProperty("id")
      public WmsDeficit.WmsDeficitBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public WmsDeficit.WmsDeficitBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("reviewStatus")
      public WmsDeficit.WmsDeficitBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("reviewTime")
      public WmsDeficit.WmsDeficitBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      @JsonProperty("applicantId")
      public WmsDeficit.WmsDeficitBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public WmsDeficit.WmsDeficitBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("reviewerName")
      public WmsDeficit.WmsDeficitBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      @JsonProperty("reviewerId")
      public WmsDeficit.WmsDeficitBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      @JsonProperty("deficitType")
      public WmsDeficit.WmsDeficitBuilder deficitType(final Integer deficitType) {
         this.deficitType = deficitType;
         return this;
      }

      @JsonProperty("basicClass")
      public WmsDeficit.WmsDeficitBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("projectIds")
      public WmsDeficit.WmsDeficitBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      @JsonProperty("approveRecordId")
      public WmsDeficit.WmsDeficitBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public WmsDeficit build() {
         return new WmsDeficit(
            this.id,
            this.serialNumber,
            this.reviewStatus,
            this.reviewTime,
            this.applicantId,
            this.applicantName,
            this.reviewerName,
            this.reviewerId,
            this.deficitType,
            this.basicClass,
            this.projectIds,
            this.approveRecordId
         );
      }

      @Override
      public String toString() {
         return "WmsDeficit.WmsDeficitBuilder(id="
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
            + ", deficitType="
            + this.deficitType
            + ", basicClass="
            + this.basicClass
            + ", projectIds="
            + this.projectIds
            + ", approveRecordId="
            + this.approveRecordId
            + ")";
      }
   }
}
