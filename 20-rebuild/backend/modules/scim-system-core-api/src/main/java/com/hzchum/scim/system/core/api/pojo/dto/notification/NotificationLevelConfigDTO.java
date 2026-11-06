package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModelProperty;

public class NotificationLevelConfigDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "level", notes = "等级")
   private Integer level;
   @ApiModelProperty(name = "color", notes = "颜色")
   private String color;

   public Long getId() {
      return this.id;
   }

   public Integer getLevel() {
      return this.level;
   }

   public String getColor() {
      return this.color;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NotificationLevelConfigDTO)) {
         return false;
      }

      NotificationLevelConfigDTO other = (NotificationLevelConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$level = this.getLevel();
         Object other$level = other.getLevel();
         if (this$level == null ? other$level == null : this$level.equals(other$level)) {
            Object this$color = this.getColor();
            Object other$color = other.getColor();
            return this$color == null ? other$color == null : this$color.equals(other$color);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof NotificationLevelConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $color = this.getColor();
      return result * 59 + ($color == null ? 43 : $color.hashCode());
   }

   @Override
   public String toString() {
      return "NotificationLevelConfigDTO(id=" + this.getId() + ", level=" + this.getLevel() + ", color=" + this.getColor() + ")";
   }
}
