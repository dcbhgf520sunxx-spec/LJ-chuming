package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import io.swagger.annotations.ApiModel;
import java.time.LocalDateTime;

@ApiModel(value = "WasteSale对象", description = "废料出售记录表 ")
public class WmsClosingTimeDTO {
   private Long id;
   private LocalDateTime startTime;
   private LocalDateTime endTime;
   private String name;

   public static WmsClosingTimeDTO.WmsClosingTimeDTOBuilder builder() {
      return new WmsClosingTimeDTO.WmsClosingTimeDTOBuilder();
   }

   public WmsClosingTimeDTO() {
   }

   public WmsClosingTimeDTO(final Long id, final LocalDateTime startTime, final LocalDateTime endTime, final String name) {
      this.id = id;
      this.startTime = startTime;
      this.endTime = endTime;
      this.name = name;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public String getName() {
      return this.name;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
   }

   public void setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsClosingTimeDTO)) {
         return false;
      }

      WmsClosingTimeDTO other = (WmsClosingTimeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$startTime = this.getStartTime();
         Object other$startTime = other.getStartTime();
         if (this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime)) {
            Object this$endTime = this.getEndTime();
            Object other$endTime = other.getEndTime();
            if (this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof WmsClosingTimeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "WmsClosingTimeDTO(id="
         + this.getId()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ", name="
         + this.getName()
         + ")";
   }

   public static class WmsClosingTimeDTOBuilder {
      private Long id;
      private LocalDateTime startTime;
      private LocalDateTime endTime;
      private String name;

      WmsClosingTimeDTOBuilder() {
      }

      public WmsClosingTimeDTO.WmsClosingTimeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsClosingTimeDTO.WmsClosingTimeDTOBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      public WmsClosingTimeDTO.WmsClosingTimeDTOBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      public WmsClosingTimeDTO.WmsClosingTimeDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public WmsClosingTimeDTO build() {
         return new WmsClosingTimeDTO(this.id, this.startTime, this.endTime, this.name);
      }

      @Override
      public String toString() {
         return "WmsClosingTimeDTO.WmsClosingTimeDTOBuilder(id="
            + this.id
            + ", startTime="
            + this.startTime
            + ", endTime="
            + this.endTime
            + ", name="
            + this.name
            + ")";
      }
   }
}
