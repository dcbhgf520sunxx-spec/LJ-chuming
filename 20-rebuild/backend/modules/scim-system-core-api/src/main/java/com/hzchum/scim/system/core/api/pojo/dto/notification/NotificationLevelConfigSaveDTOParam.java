package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "NotificationLevelConfigSaveDTOParam", description = "推送等级配置")
public class NotificationLevelConfigSaveDTOParam {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "level", value = "等级")
   private Integer level;
   @ApiModelProperty(name = "color", notes = "颜色  存储（#ddd3e8）格式")
   private String color;

   public static NotificationLevelConfigSaveDTOParam.NotificationLevelConfigSaveDTOParamBuilder builder() {
      return new NotificationLevelConfigSaveDTOParam.NotificationLevelConfigSaveDTOParamBuilder();
   }

   public NotificationLevelConfigSaveDTOParam() {
   }

   public NotificationLevelConfigSaveDTOParam(final Long id, final Integer level, final String color) {
      this.id = id;
      this.level = level;
      this.color = color;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getLevel() {
      return this.level;
   }

   public String getColor() {
      return this.color;
   }

   public NotificationLevelConfigSaveDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   public NotificationLevelConfigSaveDTOParam setLevel(final Integer level) {
      this.level = level;
      return this;
   }

   public NotificationLevelConfigSaveDTOParam setColor(final String color) {
      this.color = color;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NotificationLevelConfigSaveDTOParam)) {
         return false;
      }

      NotificationLevelConfigSaveDTOParam other = (NotificationLevelConfigSaveDTOParam)o;
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
      return other instanceof NotificationLevelConfigSaveDTOParam;
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
      return "NotificationLevelConfigSaveDTOParam(id=" + this.getId() + ", level=" + this.getLevel() + ", color=" + this.getColor() + ")";
   }

   public static class NotificationLevelConfigSaveDTOParamBuilder {
      private Long id;
      private Integer level;
      private String color;

      NotificationLevelConfigSaveDTOParamBuilder() {
      }

      public NotificationLevelConfigSaveDTOParam.NotificationLevelConfigSaveDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public NotificationLevelConfigSaveDTOParam.NotificationLevelConfigSaveDTOParamBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public NotificationLevelConfigSaveDTOParam.NotificationLevelConfigSaveDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public NotificationLevelConfigSaveDTOParam build() {
         return new NotificationLevelConfigSaveDTOParam(this.id, this.level, this.color);
      }

      @Override
      public String toString() {
         return "NotificationLevelConfigSaveDTOParam.NotificationLevelConfigSaveDTOParamBuilder(id="
            + this.id
            + ", level="
            + this.level
            + ", color="
            + this.color
            + ")";
      }
   }
}
