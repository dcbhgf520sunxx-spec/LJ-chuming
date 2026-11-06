package com.hzchum.scim.system.core.api.pojo.request;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class SysHomeCreateTripSaveParam {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "setTime", value = "行程时间", notes = "行程时间")
   private LocalDateTime setTime;
   @ApiModelProperty(name = "createUserName", value = "创建人姓名", notes = "创建人姓名")
   private String createUserName;
   @ApiModelProperty(name = "title", value = "标题", notes = "标题")
   private String title;

   public SysHomeCreateTripSaveParam(final Long id, final LocalDateTime setTime, final String createUserName, final String title) {
      this.id = id;
      this.setTime = setTime;
      this.createUserName = createUserName;
      this.title = title;
   }

   public SysHomeCreateTripSaveParam() {
   }

   public Long getId() {
      return this.id;
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSetTime(final LocalDateTime setTime) {
      this.setTime = setTime;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setTitle(final String title) {
      this.title = title;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysHomeCreateTripSaveParam)) {
         return false;
      }

      SysHomeCreateTripSaveParam other = (SysHomeCreateTripSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysHomeCreateTripSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $setTime = this.getSetTime();
      result = result * 59 + ($setTime == null ? 43 : $setTime.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $title = this.getTitle();
      return result * 59 + ($title == null ? 43 : $title.hashCode());
   }

   @Override
   public String toString() {
      return "SysHomeCreateTripSaveParam(id="
         + this.getId()
         + ", setTime="
         + this.getSetTime()
         + ", createUserName="
         + this.getCreateUserName()
         + ", title="
         + this.getTitle()
         + ")";
   }
}
