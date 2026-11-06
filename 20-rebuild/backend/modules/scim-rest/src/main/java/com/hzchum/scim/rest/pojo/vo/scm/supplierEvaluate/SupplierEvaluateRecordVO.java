package com.hzchum.scim.rest.pojo.vo.scm.supplierEvaluate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "SupplierEvaluateRecordVO", description = "供应商评价记录返回对象")
public class SupplierEvaluateRecordVO {
   @ApiModelProperty("评价记录ID")
   private Long id;
   @ApiModelProperty("供应商名称")
   private String supplierName;
   @ApiModelProperty("供应商简称")
   private String supplierShortName;
   @ApiModelProperty("评价人")
   private String evaluatorName;
   @ApiModelProperty("评价时间")
   private LocalDateTime evaluateDate;
   @ApiModelProperty("评价结果（总分）")
   private String score;

   public Long getId() {
      return this.id;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getSupplierShortName() {
      return this.supplierShortName;
   }

   public String getEvaluatorName() {
      return this.evaluatorName;
   }

   public LocalDateTime getEvaluateDate() {
      return this.evaluateDate;
   }

   public String getScore() {
      return this.score;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setSupplierShortName(final String supplierShortName) {
      this.supplierShortName = supplierShortName;
   }

   public void setEvaluatorName(final String evaluatorName) {
      this.evaluatorName = evaluatorName;
   }

   public void setEvaluateDate(final LocalDateTime evaluateDate) {
      this.evaluateDate = evaluateDate;
   }

   public void setScore(final String score) {
      this.score = score;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierEvaluateRecordVO)) {
         return false;
      }

      SupplierEvaluateRecordVO other = (SupplierEvaluateRecordVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierName = this.getSupplierName();
         Object other$supplierName = other.getSupplierName();
         if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
            Object this$supplierShortName = this.getSupplierShortName();
            Object other$supplierShortName = other.getSupplierShortName();
            if (this$supplierShortName == null ? other$supplierShortName == null : this$supplierShortName.equals(other$supplierShortName)) {
               Object this$evaluatorName = this.getEvaluatorName();
               Object other$evaluatorName = other.getEvaluatorName();
               if (this$evaluatorName == null ? other$evaluatorName == null : this$evaluatorName.equals(other$evaluatorName)) {
                  Object this$evaluateDate = this.getEvaluateDate();
                  Object other$evaluateDate = other.getEvaluateDate();
                  if (this$evaluateDate == null ? other$evaluateDate == null : this$evaluateDate.equals(other$evaluateDate)) {
                     Object this$score = this.getScore();
                     Object other$score = other.getScore();
                     return this$score == null ? other$score == null : this$score.equals(other$score);
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
      return other instanceof SupplierEvaluateRecordVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $supplierShortName = this.getSupplierShortName();
      result = result * 59 + ($supplierShortName == null ? 43 : $supplierShortName.hashCode());
      Object $evaluatorName = this.getEvaluatorName();
      result = result * 59 + ($evaluatorName == null ? 43 : $evaluatorName.hashCode());
      Object $evaluateDate = this.getEvaluateDate();
      result = result * 59 + ($evaluateDate == null ? 43 : $evaluateDate.hashCode());
      Object $score = this.getScore();
      return result * 59 + ($score == null ? 43 : $score.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierEvaluateRecordVO(id="
         + this.getId()
         + ", supplierName="
         + this.getSupplierName()
         + ", supplierShortName="
         + this.getSupplierShortName()
         + ", evaluatorName="
         + this.getEvaluatorName()
         + ", evaluateDate="
         + this.getEvaluateDate()
         + ", score="
         + this.getScore()
         + ")";
   }
}
