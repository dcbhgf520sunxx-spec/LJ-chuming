package com.hzchum.scim.scm.core.api.pojo.dtoParam.scm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.Map;

@ApiModel(value = "ScmSupplierEvaluateQueryParam", description = "供应商评价记录查询参数")
public class ScmSupplierEvaluateQueryParam {
   @ApiModelProperty("供应商名称")
   private String supplierName;
   @ApiModelProperty("分类id")
   private Long classifyId;
   @ApiModelProperty("评价年份(精确到年)")
   private Integer evaluateYear;
   @ApiModelProperty("分数评级")
   private String scoreRating;
   @ApiModelProperty("审核状态；为空或为0时默认仅查询审核通过(2)记录；传入2/16/4时按对应状态过滤")
   private Integer reviewStatus;
   @ApiModelProperty("页码")
   private Integer pageNumber = 1;
   @ApiModelProperty("每页条数")
   private Integer pageSize = 20;
   @ApiModelProperty("评审模板固定字段映射")
   private Map<String, String> columnMap = new HashMap<>();

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Integer getEvaluateYear() {
      return this.evaluateYear;
   }

   public String getScoreRating() {
      return this.scoreRating;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
   }

   public Map<String, String> getColumnMap() {
      return this.columnMap;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setEvaluateYear(final Integer evaluateYear) {
      this.evaluateYear = evaluateYear;
   }

   public void setScoreRating(final String scoreRating) {
      this.scoreRating = scoreRating;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setPageNumber(final Integer pageNumber) {
      this.pageNumber = pageNumber;
   }

   public void setPageSize(final Integer pageSize) {
      this.pageSize = pageSize;
   }

   public void setColumnMap(final Map<String, String> columnMap) {
      this.columnMap = columnMap;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScmSupplierEvaluateQueryParam)) {
         return false;
      }

      ScmSupplierEvaluateQueryParam other = (ScmSupplierEvaluateQueryParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$classifyId = this.getClassifyId();
      Object other$classifyId = other.getClassifyId();
      if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
         Object this$evaluateYear = this.getEvaluateYear();
         Object other$evaluateYear = other.getEvaluateYear();
         if (this$evaluateYear == null ? other$evaluateYear == null : this$evaluateYear.equals(other$evaluateYear)) {
            Object this$reviewStatus = this.getReviewStatus();
            Object other$reviewStatus = other.getReviewStatus();
            if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
               Object this$pageNumber = this.getPageNumber();
               Object other$pageNumber = other.getPageNumber();
               if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
                  Object this$pageSize = this.getPageSize();
                  Object other$pageSize = other.getPageSize();
                  if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                     Object this$supplierName = this.getSupplierName();
                     Object other$supplierName = other.getSupplierName();
                     if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                        Object this$scoreRating = this.getScoreRating();
                        Object other$scoreRating = other.getScoreRating();
                        if (this$scoreRating == null ? other$scoreRating == null : this$scoreRating.equals(other$scoreRating)) {
                           Object this$columnMap = this.getColumnMap();
                           Object other$columnMap = other.getColumnMap();
                           return this$columnMap == null ? other$columnMap == null : this$columnMap.equals(other$columnMap);
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
      return other instanceof ScmSupplierEvaluateQueryParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $evaluateYear = this.getEvaluateYear();
      result = result * 59 + ($evaluateYear == null ? 43 : $evaluateYear.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $scoreRating = this.getScoreRating();
      result = result * 59 + ($scoreRating == null ? 43 : $scoreRating.hashCode());
      Object $columnMap = this.getColumnMap();
      return result * 59 + ($columnMap == null ? 43 : $columnMap.hashCode());
   }

   @Override
   public String toString() {
      return "ScmSupplierEvaluateQueryParam(supplierName="
         + this.getSupplierName()
         + ", classifyId="
         + this.getClassifyId()
         + ", evaluateYear="
         + this.getEvaluateYear()
         + ", scoreRating="
         + this.getScoreRating()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", columnMap="
         + this.getColumnMap()
         + ")";
   }
}
