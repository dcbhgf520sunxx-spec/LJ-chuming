package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class SysHomeCreateTripPageDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "day", value = "行程日", notes = "行程日")
   private Long day;
   @ApiModelProperty(name = "setTime", value = "行程时间", notes = "行程时间")
   private LocalDateTime setTime;
   @ApiModelProperty(name = "createUserName", value = "创建人姓名", notes = "创建人姓名")
   private String createUserName;
   @ApiModelProperty(name = "title", value = "标题", notes = "标题")
   private String title;

   public static SysHomeCreateTripPageDTO.SysHomeCreateTripPageDTOBuilder builder() {
      return new SysHomeCreateTripPageDTO.SysHomeCreateTripPageDTOBuilder();
   }

   public SysHomeCreateTripPageDTO() {
   }

   public SysHomeCreateTripPageDTO(final Long id, final Long day, final LocalDateTime setTime, final String createUserName, final String title) {
      this.id = id;
      this.day = day;
      this.setTime = setTime;
      this.createUserName = createUserName;
      this.title = title;
   }

   public Long getId() {
      return this.id;
   }

   public Long getDay() {
      return this.day;
   }

   public LocalDateTime getSetTime() {
      return this.setTime;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public String getTitle() {
      return this.title;
   }

   public SysHomeCreateTripPageDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysHomeCreateTripPageDTO setDay(final Long day) {
      this.day = day;
      return this;
   }

   public SysHomeCreateTripPageDTO setSetTime(final LocalDateTime setTime) {
      this.setTime = setTime;
      return this;
   }

   public SysHomeCreateTripPageDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public SysHomeCreateTripPageDTO setTitle(final String title) {
      this.title = title;
      return this;
   }

   @Override
   public String toString() {
      return "SysHomeCreateTripPageDTO(id="
         + this.getId()
         + ", day="
         + this.getDay()
         + ", setTime="
         + this.getSetTime()
         + ", createUserName="
         + this.getCreateUserName()
         + ", title="
         + this.getTitle()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysHomeCreateTripPageDTO)) {
         return false;
      }

      SysHomeCreateTripPageDTO other = (SysHomeCreateTripPageDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$day = this.getDay();
         Object other$day = other.getDay();
         if (this$day == null ? other$day == null : this$day.equals(other$day)) {
            Object this$setTime = this.getSetTime();
            Object other$setTime = other.getSetTime();
            if (this$setTime == null ? other$setTime == null : this$setTime.equals(other$setTime)) {
               Object this$createUserName = this.getCreateUserName();
               Object other$createUserName = other.getCreateUserName();
               if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                  Object this$title = this.getTitle();
                  Object other$title = other.getTitle();
                  return this$title == null ? other$title == null : this$title.equals(other$title);
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
      return other instanceof SysHomeCreateTripPageDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $day = this.getDay();
      result = result * 59 + ($day == null ? 43 : $day.hashCode());
      Object $setTime = this.getSetTime();
      result = result * 59 + ($setTime == null ? 43 : $setTime.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $title = this.getTitle();
      return result * 59 + ($title == null ? 43 : $title.hashCode());
   }

   public static class SysHomeCreateTripPageDTOBuilder {
      private Long id;
      private Long day;
      private LocalDateTime setTime;
      private String createUserName;
      private String title;

      SysHomeCreateTripPageDTOBuilder() {
      }

      public SysHomeCreateTripPageDTO.SysHomeCreateTripPageDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysHomeCreateTripPageDTO.SysHomeCreateTripPageDTOBuilder day(final Long day) {
         this.day = day;
         return this;
      }

      public SysHomeCreateTripPageDTO.SysHomeCreateTripPageDTOBuilder setTime(final LocalDateTime setTime) {
         this.setTime = setTime;
         return this;
      }

      public SysHomeCreateTripPageDTO.SysHomeCreateTripPageDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public SysHomeCreateTripPageDTO.SysHomeCreateTripPageDTOBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public SysHomeCreateTripPageDTO build() {
         return new SysHomeCreateTripPageDTO(this.id, this.day, this.setTime, this.createUserName, this.title);
      }

      @Override
      public String toString() {
         return "SysHomeCreateTripPageDTO.SysHomeCreateTripPageDTOBuilder(id="
            + this.id
            + ", day="
            + this.day
            + ", setTime="
            + this.setTime
            + ", createUserName="
            + this.createUserName
            + ", title="
            + this.title
            + ")";
      }
   }
}
