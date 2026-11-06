package com.hzchum.scim.scm.core.api.pojo._doModel.scm;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "ScmSupplierEvaluate对象", description = "")
@Entity
@TableName("scm_supplier_evaluate")
@Table(name = "scm_supplier_evaluate")
@org.hibernate.annotations.Table(appliesTo = "scm_supplier_evaluate")
public class ScmSupplierEvaluate extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "supplierId", value = "供应商id", notes = "供应商id")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint(20)  COMMENT '供应商id'", nullable = true)
   private Long supplierId;
   @ApiModelProperty(name = "templateId", value = "评价模板id", notes = "评价模板id")
   @TableField("template_id")
   @Column(name = "template_id", columnDefinition = "bigint(20)  COMMENT '评价模板id'", nullable = true)
   private Long templateId;
   @ApiModelProperty(name = "evaluateJson", value = "评价记录", notes = "评价记录")
   @TableField("evaluate_json")
   @Column(name = "evaluate_json", columnDefinition = "text  COMMENT '评价记录'", nullable = true)
   private String evaluateJson;
   @ApiModelProperty(name = "evaluateDate", value = "评价日期", notes = "评价日期")
   @TableField("evaluate_date")
   @Column(name = "evaluate_date", columnDefinition = "datetime  COMMENT '评价日期'", nullable = true)
   private LocalDateTime evaluateDate;
   @ApiModelProperty(name = "score", value = "总分", notes = "总分")
   @TableField("score")
   @Column(name = "score", columnDefinition = "int(11)  COMMENT '总分'", nullable = true)
   private Integer score;
   @ApiModelProperty(name = "scoreRating", value = "分数评级", notes = "分数评级")
   @TableField("score_rating")
   @Column(name = "score_rating", columnDefinition = "varchar(255)  COMMENT '分数评级'", nullable = true)
   private String scoreRating;
   @ApiModelProperty(name = "classifyId", value = "分类id", notes = "分类id")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '分类id'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "userId", value = "评价人", notes = "评价人")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint  COMMENT '评价人'", nullable = true)
   private Long userId;
   @ApiModelProperty(name = "columnMapJson")
   @TableField("column_map_json")
   @Column(name = "column_map_json", columnDefinition = "text  COMMENT '字段名称中英文映射json'", nullable = true)
   private String columnMapJson;
   @ApiModelProperty(name = "serialNumber", value = "评价记录编号", notes = "评价记录编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(50)  COMMENT '评价记录编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态 16审核中 2通过 4驳回", notes = "审核状态")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int(11) default'2' COMMENT '审核状态 16审核中 2通过 4驳回'", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "approveRecordId", value = "审批记录id", notes = "审批记录id")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint  COMMENT '审批记录id'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty(name = "reviewerId", value = "审核人ID", notes = "审核人ID")
   @TableField("reviewer_id")
   @Column(name = "reviewer_id", columnDefinition = "bigint  COMMENT '审核人ID'", nullable = true)
   private Long reviewerId;
   @ApiModelProperty(name = "reviewerName", value = "审核人名称", notes = "审核人名称")
   @TableField("reviewer_name")
   @Column(name = "reviewer_name", columnDefinition = "varchar(255)  COMMENT '审核人名称'", nullable = true)
   private String reviewerName;
   @ApiModelProperty(name = "reviewTime", value = "审核时间", notes = "审核时间")
   @TableField("review_time")
   @Column(name = "review_time", columnDefinition = "datetime  COMMENT '审核时间'", nullable = true)
   private LocalDateTime reviewTime;

   public static ScmSupplierEvaluate.ScmSupplierEvaluateBuilder builder() {
      return new ScmSupplierEvaluate.ScmSupplierEvaluateBuilder();
   }

   public ScmSupplierEvaluate() {
   }

   public ScmSupplierEvaluate(
      final Long id,
      final Long supplierId,
      final Long templateId,
      final String evaluateJson,
      final LocalDateTime evaluateDate,
      final Integer score,
      final String scoreRating,
      final Long classifyId,
      final Long userId,
      final String columnMapJson,
      final String serialNumber,
      final Integer reviewStatus,
      final Long approveRecordId,
      final Long reviewerId,
      final String reviewerName,
      final LocalDateTime reviewTime
   ) {
      this.id = id;
      this.supplierId = supplierId;
      this.templateId = templateId;
      this.evaluateJson = evaluateJson;
      this.evaluateDate = evaluateDate;
      this.score = score;
      this.scoreRating = scoreRating;
      this.classifyId = classifyId;
      this.userId = userId;
      this.columnMapJson = columnMapJson;
      this.serialNumber = serialNumber;
      this.reviewStatus = reviewStatus;
      this.approveRecordId = approveRecordId;
      this.reviewerId = reviewerId;
      this.reviewerName = reviewerName;
      this.reviewTime = reviewTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getTemplateId() {
      return this.templateId;
   }

   public String getEvaluateJson() {
      return this.evaluateJson;
   }

   public LocalDateTime getEvaluateDate() {
      return this.evaluateDate;
   }

   public Integer getScore() {
      return this.score;
   }

   public String getScoreRating() {
      return this.scoreRating;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getColumnMapJson() {
      return this.columnMapJson;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
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

   public ScmSupplierEvaluate setId(final Long id) {
      this.id = id;
      return this;
   }

   public ScmSupplierEvaluate setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public ScmSupplierEvaluate setTemplateId(final Long templateId) {
      this.templateId = templateId;
      return this;
   }

   public ScmSupplierEvaluate setEvaluateJson(final String evaluateJson) {
      this.evaluateJson = evaluateJson;
      return this;
   }

   public ScmSupplierEvaluate setEvaluateDate(final LocalDateTime evaluateDate) {
      this.evaluateDate = evaluateDate;
      return this;
   }

   public ScmSupplierEvaluate setScore(final Integer score) {
      this.score = score;
      return this;
   }

   public ScmSupplierEvaluate setScoreRating(final String scoreRating) {
      this.scoreRating = scoreRating;
      return this;
   }

   public ScmSupplierEvaluate setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   public ScmSupplierEvaluate setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ScmSupplierEvaluate setColumnMapJson(final String columnMapJson) {
      this.columnMapJson = columnMapJson;
      return this;
   }

   public ScmSupplierEvaluate setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ScmSupplierEvaluate setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   public ScmSupplierEvaluate setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public ScmSupplierEvaluate setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
      return this;
   }

   public ScmSupplierEvaluate setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
      return this;
   }

   public ScmSupplierEvaluate setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
      return this;
   }

   @Override
   public String toString() {
      return "ScmSupplierEvaluate(id="
         + this.getId()
         + ", supplierId="
         + this.getSupplierId()
         + ", templateId="
         + this.getTemplateId()
         + ", evaluateJson="
         + this.getEvaluateJson()
         + ", evaluateDate="
         + this.getEvaluateDate()
         + ", score="
         + this.getScore()
         + ", scoreRating="
         + this.getScoreRating()
         + ", classifyId="
         + this.getClassifyId()
         + ", userId="
         + this.getUserId()
         + ", columnMapJson="
         + this.getColumnMapJson()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", reviewerId="
         + this.getReviewerId()
         + ", reviewerName="
         + this.getReviewerName()
         + ", reviewTime="
         + this.getReviewTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScmSupplierEvaluate)) {
         return false;
      }

      ScmSupplierEvaluate other = (ScmSupplierEvaluate)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$templateId = this.getTemplateId();
            Object other$templateId = other.getTemplateId();
            if (this$templateId == null ? other$templateId == null : this$templateId.equals(other$templateId)) {
               Object this$score = this.getScore();
               Object other$score = other.getScore();
               if (this$score == null ? other$score == null : this$score.equals(other$score)) {
                  Object this$classifyId = this.getClassifyId();
                  Object other$classifyId = other.getClassifyId();
                  if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$reviewStatus = this.getReviewStatus();
                        Object other$reviewStatus = other.getReviewStatus();
                        if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                           Object this$approveRecordId = this.getApproveRecordId();
                           Object other$approveRecordId = other.getApproveRecordId();
                           if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                              Object this$reviewerId = this.getReviewerId();
                              Object other$reviewerId = other.getReviewerId();
                              if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
                                 Object this$evaluateJson = this.getEvaluateJson();
                                 Object other$evaluateJson = other.getEvaluateJson();
                                 if (this$evaluateJson == null ? other$evaluateJson == null : this$evaluateJson.equals(other$evaluateJson)) {
                                    Object this$evaluateDate = this.getEvaluateDate();
                                    Object other$evaluateDate = other.getEvaluateDate();
                                    if (this$evaluateDate == null ? other$evaluateDate == null : this$evaluateDate.equals(other$evaluateDate)) {
                                       Object this$scoreRating = this.getScoreRating();
                                       Object other$scoreRating = other.getScoreRating();
                                       if (this$scoreRating == null ? other$scoreRating == null : this$scoreRating.equals(other$scoreRating)) {
                                          Object this$columnMapJson = this.getColumnMapJson();
                                          Object other$columnMapJson = other.getColumnMapJson();
                                          if (this$columnMapJson == null ? other$columnMapJson == null : this$columnMapJson.equals(other$columnMapJson)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$reviewerName = this.getReviewerName();
                                                Object other$reviewerName = other.getReviewerName();
                                                if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
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
      return other instanceof ScmSupplierEvaluate;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $templateId = this.getTemplateId();
      result = result * 59 + ($templateId == null ? 43 : $templateId.hashCode());
      Object $score = this.getScore();
      result = result * 59 + ($score == null ? 43 : $score.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $evaluateJson = this.getEvaluateJson();
      result = result * 59 + ($evaluateJson == null ? 43 : $evaluateJson.hashCode());
      Object $evaluateDate = this.getEvaluateDate();
      result = result * 59 + ($evaluateDate == null ? 43 : $evaluateDate.hashCode());
      Object $scoreRating = this.getScoreRating();
      result = result * 59 + ($scoreRating == null ? 43 : $scoreRating.hashCode());
      Object $columnMapJson = this.getColumnMapJson();
      result = result * 59 + ($columnMapJson == null ? 43 : $columnMapJson.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $reviewTime = this.getReviewTime();
      return result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
   }

   public static class ScmSupplierEvaluateBuilder {
      private Long id;
      private Long supplierId;
      private Long templateId;
      private String evaluateJson;
      private LocalDateTime evaluateDate;
      private Integer score;
      private String scoreRating;
      private Long classifyId;
      private Long userId;
      private String columnMapJson;
      private String serialNumber;
      private Integer reviewStatus;
      private Long approveRecordId;
      private Long reviewerId;
      private String reviewerName;
      private LocalDateTime reviewTime;

      ScmSupplierEvaluateBuilder() {
      }

      public ScmSupplierEvaluate.ScmSupplierEvaluateBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ScmSupplierEvaluate.ScmSupplierEvaluateBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ScmSupplierEvaluate.ScmSupplierEvaluateBuilder templateId(final Long templateId) {
         this.templateId = templateId;
         return this;
      }

      public ScmSupplierEvaluate.ScmSupplierEvaluateBuilder evaluateJson(final String evaluateJson) {
         this.evaluateJson = evaluateJson;
         return this;
      }

      public ScmSupplierEvaluate.ScmSupplierEvaluateBuilder evaluateDate(final LocalDateTime evaluateDate) {
         this.evaluateDate = evaluateDate;
         return this;
      }

      public ScmSupplierEvaluate.ScmSupplierEvaluateBuilder score(final Integer score) {
         this.score = score;
         return this;
      }

      public ScmSupplierEvaluate.ScmSupplierEvaluateBuilder scoreRating(final String scoreRating) {
         this.scoreRating = scoreRating;
         return this;
      }

      public ScmSupplierEvaluate.ScmSupplierEvaluateBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ScmSupplierEvaluate.ScmSupplierEvaluateBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ScmSupplierEvaluate.ScmSupplierEvaluateBuilder columnMapJson(final String columnMapJson) {
         this.columnMapJson = columnMapJson;
         return this;
      }

      public ScmSupplierEvaluate.ScmSupplierEvaluateBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ScmSupplierEvaluate.ScmSupplierEvaluateBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public ScmSupplierEvaluate.ScmSupplierEvaluateBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public ScmSupplierEvaluate.ScmSupplierEvaluateBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      public ScmSupplierEvaluate.ScmSupplierEvaluateBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public ScmSupplierEvaluate.ScmSupplierEvaluateBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public ScmSupplierEvaluate build() {
         return new ScmSupplierEvaluate(
            this.id,
            this.supplierId,
            this.templateId,
            this.evaluateJson,
            this.evaluateDate,
            this.score,
            this.scoreRating,
            this.classifyId,
            this.userId,
            this.columnMapJson,
            this.serialNumber,
            this.reviewStatus,
            this.approveRecordId,
            this.reviewerId,
            this.reviewerName,
            this.reviewTime
         );
      }

      @Override
      public String toString() {
         return "ScmSupplierEvaluate.ScmSupplierEvaluateBuilder(id="
            + this.id
            + ", supplierId="
            + this.supplierId
            + ", templateId="
            + this.templateId
            + ", evaluateJson="
            + this.evaluateJson
            + ", evaluateDate="
            + this.evaluateDate
            + ", score="
            + this.score
            + ", scoreRating="
            + this.scoreRating
            + ", classifyId="
            + this.classifyId
            + ", userId="
            + this.userId
            + ", columnMapJson="
            + this.columnMapJson
            + ", serialNumber="
            + this.serialNumber
            + ", reviewStatus="
            + this.reviewStatus
            + ", approveRecordId="
            + this.approveRecordId
            + ", reviewerId="
            + this.reviewerId
            + ", reviewerName="
            + this.reviewerName
            + ", reviewTime="
            + this.reviewTime
            + ")";
      }
   }
}
