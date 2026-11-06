package com.hzchum.scim.mes.building.core.api.pojo._doModel.attend;

import java.time.LocalDateTime;

public class OvertimeClockDTO {
   private Long id;
   private LocalDateTime workingTime;
   private LocalDateTime closingTime;

   public static OvertimeClockDTO.OvertimeClockDTOBuilder builder() {
      return new OvertimeClockDTO.OvertimeClockDTOBuilder();
   }

   public OvertimeClockDTO() {
   }

   public OvertimeClockDTO(final Long id, final LocalDateTime workingTime, final LocalDateTime closingTime) {
      this.id = id;
      this.workingTime = workingTime;
      this.closingTime = closingTime;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getWorkingTime() {
      return this.workingTime;
   }

   public LocalDateTime getClosingTime() {
      return this.closingTime;
   }

   public OvertimeClockDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public OvertimeClockDTO setWorkingTime(final LocalDateTime workingTime) {
      this.workingTime = workingTime;
      return this;
   }

   public OvertimeClockDTO setClosingTime(final LocalDateTime closingTime) {
      this.closingTime = closingTime;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OvertimeClockDTO)) {
         return false;
      }

      OvertimeClockDTO other = (OvertimeClockDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workingTime = this.getWorkingTime();
         Object other$workingTime = other.getWorkingTime();
         if (this$workingTime == null ? other$workingTime == null : this$workingTime.equals(other$workingTime)) {
            Object this$closingTime = this.getClosingTime();
            Object other$closingTime = other.getClosingTime();
            return this$closingTime == null ? other$closingTime == null : this$closingTime.equals(other$closingTime);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OvertimeClockDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workingTime = this.getWorkingTime();
      result = result * 59 + ($workingTime == null ? 43 : $workingTime.hashCode());
      Object $closingTime = this.getClosingTime();
      return result * 59 + ($closingTime == null ? 43 : $closingTime.hashCode());
   }

   @Override
   public String toString() {
      return "OvertimeClockDTO(id=" + this.getId() + ", workingTime=" + this.getWorkingTime() + ", closingTime=" + this.getClosingTime() + ")";
   }

   public static class OvertimeClockDTOBuilder {
      private Long id;
      private LocalDateTime workingTime;
      private LocalDateTime closingTime;

      OvertimeClockDTOBuilder() {
      }

      public OvertimeClockDTO.OvertimeClockDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public OvertimeClockDTO.OvertimeClockDTOBuilder workingTime(final LocalDateTime workingTime) {
         this.workingTime = workingTime;
         return this;
      }

      public OvertimeClockDTO.OvertimeClockDTOBuilder closingTime(final LocalDateTime closingTime) {
         this.closingTime = closingTime;
         return this;
      }

      public OvertimeClockDTO build() {
         return new OvertimeClockDTO(this.id, this.workingTime, this.closingTime);
      }

      @Override
      public String toString() {
         return "OvertimeClockDTO.OvertimeClockDTOBuilder(id=" + this.id + ", workingTime=" + this.workingTime + ", closingTime=" + this.closingTime + ")";
      }
   }
}
