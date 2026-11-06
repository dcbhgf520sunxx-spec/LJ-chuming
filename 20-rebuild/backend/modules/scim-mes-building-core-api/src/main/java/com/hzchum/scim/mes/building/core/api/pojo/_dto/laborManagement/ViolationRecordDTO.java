package com.hzchum.scim.mes.building.core.api.pojo._dto.laborManagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel("违章记录DTO类")
public class ViolationRecordDTO {
   @ApiModelProperty("记录日期")
   private LocalDate recordDate;
   @ApiModelProperty("问题编号")
   private String qhseNumber;
   @ApiModelProperty("记录人名称")
   private String recorderName;
   @ApiModelProperty("行为扣分")
   private Integer behaviorScore;
   @ApiModelProperty("处罚（元）")
   private BigDecimal penalty;

   public LocalDate getRecordDate() {
      return this.recordDate;
   }

   public String getQhseNumber() {
      return this.qhseNumber;
   }

   public String getRecorderName() {
      return this.recorderName;
   }

   public Integer getBehaviorScore() {
      return this.behaviorScore;
   }

   public BigDecimal getPenalty() {
      return this.penalty;
   }

   public void setRecordDate(final LocalDate recordDate) {
      this.recordDate = recordDate;
   }

   public void setQhseNumber(final String qhseNumber) {
      this.qhseNumber = qhseNumber;
   }

   public void setRecorderName(final String recorderName) {
      this.recorderName = recorderName;
   }

   public void setBehaviorScore(final Integer behaviorScore) {
      this.behaviorScore = behaviorScore;
   }

   public void setPenalty(final BigDecimal penalty) {
      this.penalty = penalty;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ViolationRecordDTO)) {
         return false;
      }

      ViolationRecordDTO other = (ViolationRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$behaviorScore = this.getBehaviorScore();
      Object other$behaviorScore = other.getBehaviorScore();
      if (this$behaviorScore == null ? other$behaviorScore == null : this$behaviorScore.equals(other$behaviorScore)) {
         Object this$recordDate = this.getRecordDate();
         Object other$recordDate = other.getRecordDate();
         if (this$recordDate == null ? other$recordDate == null : this$recordDate.equals(other$recordDate)) {
            Object this$qhseNumber = this.getQhseNumber();
            Object other$qhseNumber = other.getQhseNumber();
            if (this$qhseNumber == null ? other$qhseNumber == null : this$qhseNumber.equals(other$qhseNumber)) {
               Object this$recorderName = this.getRecorderName();
               Object other$recorderName = other.getRecorderName();
               if (this$recorderName == null ? other$recorderName == null : this$recorderName.equals(other$recorderName)) {
                  Object this$penalty = this.getPenalty();
                  Object other$penalty = other.getPenalty();
                  return this$penalty == null ? other$penalty == null : this$penalty.equals(other$penalty);
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
      return other instanceof ViolationRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $behaviorScore = this.getBehaviorScore();
      result = result * 59 + ($behaviorScore == null ? 43 : $behaviorScore.hashCode());
      Object $recordDate = this.getRecordDate();
      result = result * 59 + ($recordDate == null ? 43 : $recordDate.hashCode());
      Object $qhseNumber = this.getQhseNumber();
      result = result * 59 + ($qhseNumber == null ? 43 : $qhseNumber.hashCode());
      Object $recorderName = this.getRecorderName();
      result = result * 59 + ($recorderName == null ? 43 : $recorderName.hashCode());
      Object $penalty = this.getPenalty();
      return result * 59 + ($penalty == null ? 43 : $penalty.hashCode());
   }

   @Override
   public String toString() {
      return "ViolationRecordDTO(recordDate="
         + this.getRecordDate()
         + ", qhseNumber="
         + this.getQhseNumber()
         + ", recorderName="
         + this.getRecorderName()
         + ", behaviorScore="
         + this.getBehaviorScore()
         + ", penalty="
         + this.getPenalty()
         + ")";
   }
}
