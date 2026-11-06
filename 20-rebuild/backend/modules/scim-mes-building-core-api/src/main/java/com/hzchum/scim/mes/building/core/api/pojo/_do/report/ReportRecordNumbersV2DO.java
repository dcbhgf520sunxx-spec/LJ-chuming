package com.hzchum.scim.mes.building.core.api.pojo._do.report;

import java.time.LocalDateTime;

public class ReportRecordNumbersV2DO {
   private Long taskProcessId;
   private Long groupId;
   private Long teamId;
   private Long userId;
   private LocalDateTime reportTime;
   private Long reportNumberId;
   private Boolean booleOneCode;
   private Integer number;
   private Integer quantity;
   private Integer problemQuantity;
   private Integer inspectionQuantity;

   public static ReportRecordNumbersV2DO.ReportRecordNumbersV2DOBuilder builder() {
      return new ReportRecordNumbersV2DO.ReportRecordNumbersV2DOBuilder();
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getGroupId() {
      return this.groupId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public LocalDateTime getReportTime() {
      return this.reportTime;
   }

   public Long getReportNumberId() {
      return this.reportNumberId;
   }

   public Boolean getBooleOneCode() {
      return this.booleOneCode;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getProblemQuantity() {
      return this.problemQuantity;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public void setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
   }

   public void setGroupId(final Long groupId) {
      this.groupId = groupId;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setReportTime(final LocalDateTime reportTime) {
      this.reportTime = reportTime;
   }

   public void setReportNumberId(final Long reportNumberId) {
      this.reportNumberId = reportNumberId;
   }

   public void setBooleOneCode(final Boolean booleOneCode) {
      this.booleOneCode = booleOneCode;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
   }

   public void setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReportRecordNumbersV2DO)) {
         return false;
      }

      ReportRecordNumbersV2DO other = (ReportRecordNumbersV2DO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskProcessId = this.getTaskProcessId();
      Object other$taskProcessId = other.getTaskProcessId();
      if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
         Object this$groupId = this.getGroupId();
         Object other$groupId = other.getGroupId();
         if (this$groupId == null ? other$groupId == null : this$groupId.equals(other$groupId)) {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$reportNumberId = this.getReportNumberId();
                  Object other$reportNumberId = other.getReportNumberId();
                  if (this$reportNumberId == null ? other$reportNumberId == null : this$reportNumberId.equals(other$reportNumberId)) {
                     Object this$booleOneCode = this.getBooleOneCode();
                     Object other$booleOneCode = other.getBooleOneCode();
                     if (this$booleOneCode == null ? other$booleOneCode == null : this$booleOneCode.equals(other$booleOneCode)) {
                        Object this$number = this.getNumber();
                        Object other$number = other.getNumber();
                        if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$problemQuantity = this.getProblemQuantity();
                              Object other$problemQuantity = other.getProblemQuantity();
                              if (this$problemQuantity == null ? other$problemQuantity == null : this$problemQuantity.equals(other$problemQuantity)) {
                                 Object this$inspectionQuantity = this.getInspectionQuantity();
                                 Object other$inspectionQuantity = other.getInspectionQuantity();
                                 if (this$inspectionQuantity == null
                                    ? other$inspectionQuantity == null
                                    : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                                    Object this$reportTime = this.getReportTime();
                                    Object other$reportTime = other.getReportTime();
                                    return this$reportTime == null ? other$reportTime == null : this$reportTime.equals(other$reportTime);
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
      return other instanceof ReportRecordNumbersV2DO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $groupId = this.getGroupId();
      result = result * 59 + ($groupId == null ? 43 : $groupId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $reportNumberId = this.getReportNumberId();
      result = result * 59 + ($reportNumberId == null ? 43 : $reportNumberId.hashCode());
      Object $booleOneCode = this.getBooleOneCode();
      result = result * 59 + ($booleOneCode == null ? 43 : $booleOneCode.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $problemQuantity = this.getProblemQuantity();
      result = result * 59 + ($problemQuantity == null ? 43 : $problemQuantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $reportTime = this.getReportTime();
      return result * 59 + ($reportTime == null ? 43 : $reportTime.hashCode());
   }

   @Override
   public String toString() {
      return "ReportRecordNumbersV2DO(taskProcessId="
         + this.getTaskProcessId()
         + ", groupId="
         + this.getGroupId()
         + ", teamId="
         + this.getTeamId()
         + ", userId="
         + this.getUserId()
         + ", reportTime="
         + this.getReportTime()
         + ", reportNumberId="
         + this.getReportNumberId()
         + ", booleOneCode="
         + this.getBooleOneCode()
         + ", number="
         + this.getNumber()
         + ", quantity="
         + this.getQuantity()
         + ", problemQuantity="
         + this.getProblemQuantity()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ")";
   }

   public ReportRecordNumbersV2DO(
      final Long taskProcessId,
      final Long groupId,
      final Long teamId,
      final Long userId,
      final LocalDateTime reportTime,
      final Long reportNumberId,
      final Boolean booleOneCode,
      final Integer number,
      final Integer quantity,
      final Integer problemQuantity,
      final Integer inspectionQuantity
   ) {
      this.taskProcessId = taskProcessId;
      this.groupId = groupId;
      this.teamId = teamId;
      this.userId = userId;
      this.reportTime = reportTime;
      this.reportNumberId = reportNumberId;
      this.booleOneCode = booleOneCode;
      this.number = number;
      this.quantity = quantity;
      this.problemQuantity = problemQuantity;
      this.inspectionQuantity = inspectionQuantity;
   }

   public ReportRecordNumbersV2DO() {
   }

   public static class ReportRecordNumbersV2DOBuilder {
      private Long taskProcessId;
      private Long groupId;
      private Long teamId;
      private Long userId;
      private LocalDateTime reportTime;
      private Long reportNumberId;
      private Boolean booleOneCode;
      private Integer number;
      private Integer quantity;
      private Integer problemQuantity;
      private Integer inspectionQuantity;

      ReportRecordNumbersV2DOBuilder() {
      }

      public ReportRecordNumbersV2DO.ReportRecordNumbersV2DOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      public ReportRecordNumbersV2DO.ReportRecordNumbersV2DOBuilder groupId(final Long groupId) {
         this.groupId = groupId;
         return this;
      }

      public ReportRecordNumbersV2DO.ReportRecordNumbersV2DOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public ReportRecordNumbersV2DO.ReportRecordNumbersV2DOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ReportRecordNumbersV2DO.ReportRecordNumbersV2DOBuilder reportTime(final LocalDateTime reportTime) {
         this.reportTime = reportTime;
         return this;
      }

      public ReportRecordNumbersV2DO.ReportRecordNumbersV2DOBuilder reportNumberId(final Long reportNumberId) {
         this.reportNumberId = reportNumberId;
         return this;
      }

      public ReportRecordNumbersV2DO.ReportRecordNumbersV2DOBuilder booleOneCode(final Boolean booleOneCode) {
         this.booleOneCode = booleOneCode;
         return this;
      }

      public ReportRecordNumbersV2DO.ReportRecordNumbersV2DOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public ReportRecordNumbersV2DO.ReportRecordNumbersV2DOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ReportRecordNumbersV2DO.ReportRecordNumbersV2DOBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      public ReportRecordNumbersV2DO.ReportRecordNumbersV2DOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      public ReportRecordNumbersV2DO build() {
         return new ReportRecordNumbersV2DO(
            this.taskProcessId,
            this.groupId,
            this.teamId,
            this.userId,
            this.reportTime,
            this.reportNumberId,
            this.booleOneCode,
            this.number,
            this.quantity,
            this.problemQuantity,
            this.inspectionQuantity
         );
      }

      @Override
      public String toString() {
         return "ReportRecordNumbersV2DO.ReportRecordNumbersV2DOBuilder(taskProcessId="
            + this.taskProcessId
            + ", groupId="
            + this.groupId
            + ", teamId="
            + this.teamId
            + ", userId="
            + this.userId
            + ", reportTime="
            + this.reportTime
            + ", reportNumberId="
            + this.reportNumberId
            + ", booleOneCode="
            + this.booleOneCode
            + ", number="
            + this.number
            + ", quantity="
            + this.quantity
            + ", problemQuantity="
            + this.problemQuantity
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ")";
      }
   }
}
