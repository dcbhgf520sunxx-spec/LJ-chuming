package com.hzchum.scim.contract.core.api.pojo._doParam;

import java.time.LocalDateTime;

public class ContractAnalysisQueryDTOParam {
   private LocalDateTime registerDate;
   private Integer type;
   private LocalDateTime startTime;
   private LocalDateTime endTime;

   public static ContractAnalysisQueryDTOParam.ContractAnalysisQueryDTOParamBuilder builder() {
      return new ContractAnalysisQueryDTOParam.ContractAnalysisQueryDTOParamBuilder();
   }

   public ContractAnalysisQueryDTOParam() {
   }

   public ContractAnalysisQueryDTOParam(final LocalDateTime registerDate, final Integer type, final LocalDateTime startTime, final LocalDateTime endTime) {
      this.registerDate = registerDate;
      this.type = type;
      this.startTime = startTime;
      this.endTime = endTime;
   }

   public LocalDateTime getRegisterDate() {
      return this.registerDate;
   }

   public Integer getType() {
      return this.type;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public void setRegisterDate(final LocalDateTime registerDate) {
      this.registerDate = registerDate;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
   }

   public void setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractAnalysisQueryDTOParam)) {
         return false;
      }

      ContractAnalysisQueryDTOParam other = (ContractAnalysisQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$registerDate = this.getRegisterDate();
         Object other$registerDate = other.getRegisterDate();
         if (this$registerDate == null ? other$registerDate == null : this$registerDate.equals(other$registerDate)) {
            Object this$startTime = this.getStartTime();
            Object other$startTime = other.getStartTime();
            if (this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime)) {
               Object this$endTime = this.getEndTime();
               Object other$endTime = other.getEndTime();
               return this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime);
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
      return other instanceof ContractAnalysisQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $registerDate = this.getRegisterDate();
      result = result * 59 + ($registerDate == null ? 43 : $registerDate.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      return result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
   }

   @Override
   public String toString() {
      return "ContractAnalysisQueryDTOParam(registerDate="
         + this.getRegisterDate()
         + ", type="
         + this.getType()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ")";
   }

   public static class ContractAnalysisQueryDTOParamBuilder {
      private LocalDateTime registerDate;
      private Integer type;
      private LocalDateTime startTime;
      private LocalDateTime endTime;

      ContractAnalysisQueryDTOParamBuilder() {
      }

      public ContractAnalysisQueryDTOParam.ContractAnalysisQueryDTOParamBuilder registerDate(final LocalDateTime registerDate) {
         this.registerDate = registerDate;
         return this;
      }

      public ContractAnalysisQueryDTOParam.ContractAnalysisQueryDTOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractAnalysisQueryDTOParam.ContractAnalysisQueryDTOParamBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      public ContractAnalysisQueryDTOParam.ContractAnalysisQueryDTOParamBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      public ContractAnalysisQueryDTOParam build() {
         return new ContractAnalysisQueryDTOParam(this.registerDate, this.type, this.startTime, this.endTime);
      }

      @Override
      public String toString() {
         return "ContractAnalysisQueryDTOParam.ContractAnalysisQueryDTOParamBuilder(registerDate="
            + this.registerDate
            + ", type="
            + this.type
            + ", startTime="
            + this.startTime
            + ", endTime="
            + this.endTime
            + ")";
      }
   }
}
