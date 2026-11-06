package com.hzchum.scim.mes.building.core.api.pojo._doModel.attend;

import java.time.LocalDateTime;

public class OvertimeClockDO {
   private Long id;
   private LocalDateTime overClockTime;

   public static OvertimeClockDO.OvertimeClockDOBuilder builder() {
      return new OvertimeClockDO.OvertimeClockDOBuilder();
   }

   public OvertimeClockDO() {
   }

   public OvertimeClockDO(final Long id, final LocalDateTime overClockTime) {
      this.id = id;
      this.overClockTime = overClockTime;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getOverClockTime() {
      return this.overClockTime;
   }

   public OvertimeClockDO setId(final Long id) {
      this.id = id;
      return this;
   }

   public OvertimeClockDO setOverClockTime(final LocalDateTime overClockTime) {
      this.overClockTime = overClockTime;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof OvertimeClockDO)) {
         return false;
      } else {
         OvertimeClockDO other = (OvertimeClockDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$overClockTime = this.getOverClockTime();
               Object other$overClockTime = other.getOverClockTime();
               return this$overClockTime == null ? other$overClockTime == null : this$overClockTime.equals(other$overClockTime);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OvertimeClockDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $overClockTime = this.getOverClockTime();
      return result * 59 + ($overClockTime == null ? 43 : $overClockTime.hashCode());
   }

   @Override
   public String toString() {
      return "OvertimeClockDO(id=" + this.getId() + ", overClockTime=" + this.getOverClockTime() + ")";
   }

   public static class OvertimeClockDOBuilder {
      private Long id;
      private LocalDateTime overClockTime;

      OvertimeClockDOBuilder() {
      }

      public OvertimeClockDO.OvertimeClockDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public OvertimeClockDO.OvertimeClockDOBuilder overClockTime(final LocalDateTime overClockTime) {
         this.overClockTime = overClockTime;
         return this;
      }

      public OvertimeClockDO build() {
         return new OvertimeClockDO(this.id, this.overClockTime);
      }

      @Override
      public String toString() {
         return "OvertimeClockDO.OvertimeClockDOBuilder(id=" + this.id + ", overClockTime=" + this.overClockTime + ")";
      }
   }
}
