package com.hzchum.scim.scm.core.api.pojo.dto.scm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ApiModel(value = "ScmSupplierEvaluateDTO", description = "供应商评价记录返回对象")
public class ScmSupplierEvaluateDTO {
   @ApiModelProperty("评价记录ID")
   private Long id;
   @ApiModelProperty("供应商id")
   private Long supplierId;
   @ApiModelProperty("供应商名称")
   private String supplierName;
   @ApiModelProperty("供应商简称")
   private String supplierShortName;
   @ApiModelProperty("评价模板id")
   private Integer templateId;
   @ApiModelProperty("评价分数详情JSON")
   private String evaluateJson;
   @ApiModelProperty("评价日期")
   private LocalDateTime evaluateDate;
   @ApiModelProperty("总分")
   private Integer score;
   @ApiModelProperty("分数评级")
   private String scoreRating;
   @ApiModelProperty("分类id")
   private Long classifyId;
   @ApiModelProperty("评价人id")
   private Long userId;
   @ApiModelProperty("评价人姓名")
   private String evaluatorName;
   @ApiModelProperty("列名")
   private String columnMapJson;
   @ApiModelProperty("评审模板固定字段映射")
   private Map<String, String> columnMap = new HashMap<>();
   @ApiModelProperty("评价分类")
   ScmSupplierConfigDTO scmSupplierConfigDTO;
   @ApiModelProperty("评价记录编号")
   private String serialNumber;
   @ApiModelProperty("审核状态 1审核中 2通过 4驳回")
   private Integer reviewStatus;
   @ApiModelProperty("审批记录id")
   private Long approveRecordId;
   @ApiModelProperty("审核人ID")
   private Long reviewerId;
   @ApiModelProperty("审核人名称")
   private String reviewerName;
   @ApiModelProperty("审核时间")
   private LocalDateTime reviewTime;

   public static ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder builder() {
      return new ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder();
   }

   public ScmSupplierEvaluateDTO() {
   }

   public ScmSupplierEvaluateDTO(
      final Long id,
      final Long supplierId,
      final String supplierName,
      final String supplierShortName,
      final Integer templateId,
      final String evaluateJson,
      final LocalDateTime evaluateDate,
      final Integer score,
      final String scoreRating,
      final Long classifyId,
      final Long userId,
      final String evaluatorName,
      final String columnMapJson,
      final Map<String, String> columnMap,
      final ScmSupplierConfigDTO scmSupplierConfigDTO,
      final String serialNumber,
      final Integer reviewStatus,
      final Long approveRecordId,
      final Long reviewerId,
      final String reviewerName,
      final LocalDateTime reviewTime
   ) {
      this.id = id;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.supplierShortName = supplierShortName;
      this.templateId = templateId;
      this.evaluateJson = evaluateJson;
      this.evaluateDate = evaluateDate;
      this.score = score;
      this.scoreRating = scoreRating;
      this.classifyId = classifyId;
      this.userId = userId;
      this.evaluatorName = evaluatorName;
      this.columnMapJson = columnMapJson;
      this.columnMap = columnMap;
      this.scmSupplierConfigDTO = scmSupplierConfigDTO;
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

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getSupplierShortName() {
      return this.supplierShortName;
   }

   public Integer getTemplateId() {
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

   public String getEvaluatorName() {
      return this.evaluatorName;
   }

   public String getColumnMapJson() {
      return this.columnMapJson;
   }

   public Map<String, String> getColumnMap() {
      return this.columnMap;
   }

   public ScmSupplierConfigDTO getScmSupplierConfigDTO() {
      return this.scmSupplierConfigDTO;
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setSupplierShortName(final String supplierShortName) {
      this.supplierShortName = supplierShortName;
   }

   public void setTemplateId(final Integer templateId) {
      this.templateId = templateId;
   }

   public void setEvaluateJson(final String evaluateJson) {
      this.evaluateJson = evaluateJson;
   }

   public void setEvaluateDate(final LocalDateTime evaluateDate) {
      this.evaluateDate = evaluateDate;
   }

   public void setScore(final Integer score) {
      this.score = score;
   }

   public void setScoreRating(final String scoreRating) {
      this.scoreRating = scoreRating;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setEvaluatorName(final String evaluatorName) {
      this.evaluatorName = evaluatorName;
   }

   public void setColumnMapJson(final String columnMapJson) {
      this.columnMapJson = columnMapJson;
   }

   public void setColumnMap(final Map<String, String> columnMap) {
      this.columnMap = columnMap;
   }

   public void setScmSupplierConfigDTO(final ScmSupplierConfigDTO scmSupplierConfigDTO) {
      this.scmSupplierConfigDTO = scmSupplierConfigDTO;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
   }

   public void setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScmSupplierEvaluateDTO)) {
         return false;
      }

      ScmSupplierEvaluateDTO other = (ScmSupplierEvaluateDTO)o;
      if (!other.canEqual(this)) {
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
                                 Object this$supplierName = this.getSupplierName();
                                 Object other$supplierName = other.getSupplierName();
                                 if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                    Object this$supplierShortName = this.getSupplierShortName();
                                    Object other$supplierShortName = other.getSupplierShortName();
                                    if (this$supplierShortName == null
                                       ? other$supplierShortName == null
                                       : this$supplierShortName.equals(other$supplierShortName)) {
                                       Object this$evaluateJson = this.getEvaluateJson();
                                       Object other$evaluateJson = other.getEvaluateJson();
                                       if (this$evaluateJson == null ? other$evaluateJson == null : this$evaluateJson.equals(other$evaluateJson)) {
                                          Object this$evaluateDate = this.getEvaluateDate();
                                          Object other$evaluateDate = other.getEvaluateDate();
                                          if (this$evaluateDate == null ? other$evaluateDate == null : this$evaluateDate.equals(other$evaluateDate)) {
                                             Object this$scoreRating = this.getScoreRating();
                                             Object other$scoreRating = other.getScoreRating();
                                             if (this$scoreRating == null ? other$scoreRating == null : this$scoreRating.equals(other$scoreRating)) {
                                                Object this$evaluatorName = this.getEvaluatorName();
                                                Object other$evaluatorName = other.getEvaluatorName();
                                                if (this$evaluatorName == null ? other$evaluatorName == null : this$evaluatorName.equals(other$evaluatorName)) {
                                                   Object this$columnMapJson = this.getColumnMapJson();
                                                   Object other$columnMapJson = other.getColumnMapJson();
                                                   if (this$columnMapJson == null
                                                      ? other$columnMapJson == null
                                                      : this$columnMapJson.equals(other$columnMapJson)) {
                                                      Object this$columnMap = this.getColumnMap();
                                                      Object other$columnMap = other.getColumnMap();
                                                      if (this$columnMap == null ? other$columnMap == null : this$columnMap.equals(other$columnMap)) {
                                                         Object this$scmSupplierConfigDTO = this.getScmSupplierConfigDTO();
                                                         Object other$scmSupplierConfigDTO = other.getScmSupplierConfigDTO();
                                                         if (this$scmSupplierConfigDTO == null
                                                            ? other$scmSupplierConfigDTO == null
                                                            : this$scmSupplierConfigDTO.equals(other$scmSupplierConfigDTO)) {
                                                            Object this$serialNumber = this.getSerialNumber();
                                                            Object other$serialNumber = other.getSerialNumber();
                                                            if (this$serialNumber == null
                                                               ? other$serialNumber == null
                                                               : this$serialNumber.equals(other$serialNumber)) {
                                                               Object this$reviewerName = this.getReviewerName();
                                                               Object other$reviewerName = other.getReviewerName();
                                                               if (this$reviewerName == null
                                                                  ? other$reviewerName == null
                                                                  : this$reviewerName.equals(other$reviewerName)) {
                                                                  Object this$reviewTime = this.getReviewTime();
                                                                  Object other$reviewTime = other.getReviewTime();
                                                                  return this$reviewTime == null
                                                                     ? other$reviewTime == null
                                                                     : this$reviewTime.equals(other$reviewTime);
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

   protected boolean canEqual(final Object other) {
      return other instanceof ScmSupplierEvaluateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
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
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $supplierShortName = this.getSupplierShortName();
      result = result * 59 + ($supplierShortName == null ? 43 : $supplierShortName.hashCode());
      Object $evaluateJson = this.getEvaluateJson();
      result = result * 59 + ($evaluateJson == null ? 43 : $evaluateJson.hashCode());
      Object $evaluateDate = this.getEvaluateDate();
      result = result * 59 + ($evaluateDate == null ? 43 : $evaluateDate.hashCode());
      Object $scoreRating = this.getScoreRating();
      result = result * 59 + ($scoreRating == null ? 43 : $scoreRating.hashCode());
      Object $evaluatorName = this.getEvaluatorName();
      result = result * 59 + ($evaluatorName == null ? 43 : $evaluatorName.hashCode());
      Object $columnMapJson = this.getColumnMapJson();
      result = result * 59 + ($columnMapJson == null ? 43 : $columnMapJson.hashCode());
      Object $columnMap = this.getColumnMap();
      result = result * 59 + ($columnMap == null ? 43 : $columnMap.hashCode());
      Object $scmSupplierConfigDTO = this.getScmSupplierConfigDTO();
      result = result * 59 + ($scmSupplierConfigDTO == null ? 43 : $scmSupplierConfigDTO.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $reviewTime = this.getReviewTime();
      return result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
   }

   @Override
   public String toString() {
      return "ScmSupplierEvaluateDTO(id="
         + this.getId()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", supplierShortName="
         + this.getSupplierShortName()
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
         + ", evaluatorName="
         + this.getEvaluatorName()
         + ", columnMapJson="
         + this.getColumnMapJson()
         + ", columnMap="
         + this.getColumnMap()
         + ", scmSupplierConfigDTO="
         + this.getScmSupplierConfigDTO()
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

   public static class ScmSupplierEvaluateDTOBuilder {
      private Long id;
      private Long supplierId;
      private String supplierName;
      private String supplierShortName;
      private Integer templateId;
      private String evaluateJson;
      private LocalDateTime evaluateDate;
      private Integer score;
      private String scoreRating;
      private Long classifyId;
      private Long userId;
      private String evaluatorName;
      private String columnMapJson;
      private Map<String, String> columnMap;
      private ScmSupplierConfigDTO scmSupplierConfigDTO;
      private String serialNumber;
      private Integer reviewStatus;
      private Long approveRecordId;
      private Long reviewerId;
      private String reviewerName;
      private LocalDateTime reviewTime;

      ScmSupplierEvaluateDTOBuilder() {
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder supplierShortName(final String supplierShortName) {
         this.supplierShortName = supplierShortName;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder templateId(final Integer templateId) {
         this.templateId = templateId;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder evaluateJson(final String evaluateJson) {
         this.evaluateJson = evaluateJson;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder evaluateDate(final LocalDateTime evaluateDate) {
         this.evaluateDate = evaluateDate;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder score(final Integer score) {
         this.score = score;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder scoreRating(final String scoreRating) {
         this.scoreRating = scoreRating;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder evaluatorName(final String evaluatorName) {
         this.evaluatorName = evaluatorName;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder columnMapJson(final String columnMapJson) {
         this.columnMapJson = columnMapJson;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder columnMap(final Map<String, String> columnMap) {
         this.columnMap = columnMap;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder scmSupplierConfigDTO(final ScmSupplierConfigDTO scmSupplierConfigDTO) {
         this.scmSupplierConfigDTO = scmSupplierConfigDTO;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public ScmSupplierEvaluateDTO build() {
         return new ScmSupplierEvaluateDTO(
            this.id,
            this.supplierId,
            this.supplierName,
            this.supplierShortName,
            this.templateId,
            this.evaluateJson,
            this.evaluateDate,
            this.score,
            this.scoreRating,
            this.classifyId,
            this.userId,
            this.evaluatorName,
            this.columnMapJson,
            this.columnMap,
            this.scmSupplierConfigDTO,
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
         return "ScmSupplierEvaluateDTO.ScmSupplierEvaluateDTOBuilder(id="
            + this.id
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", supplierShortName="
            + this.supplierShortName
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
            + ", evaluatorName="
            + this.evaluatorName
            + ", columnMapJson="
            + this.columnMapJson
            + ", columnMap="
            + this.columnMap
            + ", scmSupplierConfigDTO="
            + this.scmSupplierConfigDTO
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
