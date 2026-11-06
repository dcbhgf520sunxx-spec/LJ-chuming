package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel(value = "NotificationLevelConfigSaveVO", description = "")
public class NotificationLevelConfigSaveVO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "level", value = "等级")
   @NotNull(message = "请先选择等级")
   private Integer level;
   @ApiModelProperty(name = "timeTypeEnum", value = "时间类型")
   @NotNull(message = "时间类型")
   private Integer timeTypeEnum;
   @ApiModelProperty(name = "color", notes = "颜色  存储（#ddd3e8）格式")
   @NotBlank(message = "请先配置颜色")
   private String color;
   @ApiModelProperty(name = "ids", notes = "ids集合")
   private List<Long> ids;

   public static NotificationLevelConfigSaveVO.NotificationLevelConfigSaveVOBuilder builder() {
      return new NotificationLevelConfigSaveVO.NotificationLevelConfigSaveVOBuilder();
   }

   public NotificationLevelConfigSaveVO() {
   }

   public NotificationLevelConfigSaveVO(final Long id, final Integer level, final Integer timeTypeEnum, final String color, final List<Long> ids) {
      this.id = id;
      this.level = level;
      this.timeTypeEnum = timeTypeEnum;
      this.color = color;
      this.ids = ids;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getLevel() {
      return this.level;
   }

   public Integer getTimeTypeEnum() {
      return this.timeTypeEnum;
   }

   public String getColor() {
      return this.color;
   }

   public List<Long> getIds() {
      return this.ids;
   }

   public NotificationLevelConfigSaveVO setId(final Long id) {
      this.id = id;
      return this;
   }

   public NotificationLevelConfigSaveVO setLevel(final Integer level) {
      this.level = level;
      return this;
   }

   public NotificationLevelConfigSaveVO setTimeTypeEnum(final Integer timeTypeEnum) {
      this.timeTypeEnum = timeTypeEnum;
      return this;
   }

   public NotificationLevelConfigSaveVO setColor(final String color) {
      this.color = color;
      return this;
   }

   public NotificationLevelConfigSaveVO setIds(final List<Long> ids) {
      this.ids = ids;
      return this;
   }

   @Override
   public String toString() {
      return "NotificationLevelConfigSaveVO(id="
         + this.getId()
         + ", level="
         + this.getLevel()
         + ", timeTypeEnum="
         + this.getTimeTypeEnum()
         + ", color="
         + this.getColor()
         + ", ids="
         + this.getIds()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NotificationLevelConfigSaveVO)) {
         return false;
      }

      NotificationLevelConfigSaveVO other = (NotificationLevelConfigSaveVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$level = this.getLevel();
         Object other$level = other.getLevel();
         if (this$level == null ? other$level == null : this$level.equals(other$level)) {
            Object this$timeTypeEnum = this.getTimeTypeEnum();
            Object other$timeTypeEnum = other.getTimeTypeEnum();
            if (this$timeTypeEnum == null ? other$timeTypeEnum == null : this$timeTypeEnum.equals(other$timeTypeEnum)) {
               Object this$color = this.getColor();
               Object other$color = other.getColor();
               if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                  Object this$ids = this.getIds();
                  Object other$ids = other.getIds();
                  return this$ids == null ? other$ids == null : this$ids.equals(other$ids);
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
      return other instanceof NotificationLevelConfigSaveVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $timeTypeEnum = this.getTimeTypeEnum();
      result = result * 59 + ($timeTypeEnum == null ? 43 : $timeTypeEnum.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $ids = this.getIds();
      return result * 59 + ($ids == null ? 43 : $ids.hashCode());
   }

   public static class NotificationLevelConfigSaveVOBuilder {
      private Long id;
      private Integer level;
      private Integer timeTypeEnum;
      private String color;
      private List<Long> ids;

      NotificationLevelConfigSaveVOBuilder() {
      }

      public NotificationLevelConfigSaveVO.NotificationLevelConfigSaveVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public NotificationLevelConfigSaveVO.NotificationLevelConfigSaveVOBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public NotificationLevelConfigSaveVO.NotificationLevelConfigSaveVOBuilder timeTypeEnum(final Integer timeTypeEnum) {
         this.timeTypeEnum = timeTypeEnum;
         return this;
      }

      public NotificationLevelConfigSaveVO.NotificationLevelConfigSaveVOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public NotificationLevelConfigSaveVO.NotificationLevelConfigSaveVOBuilder ids(final List<Long> ids) {
         this.ids = ids;
         return this;
      }

      public NotificationLevelConfigSaveVO build() {
         return new NotificationLevelConfigSaveVO(this.id, this.level, this.timeTypeEnum, this.color, this.ids);
      }

      @Override
      public String toString() {
         return "NotificationLevelConfigSaveVO.NotificationLevelConfigSaveVOBuilder(id="
            + this.id
            + ", level="
            + this.level
            + ", timeTypeEnum="
            + this.timeTypeEnum
            + ", color="
            + this.color
            + ", ids="
            + this.ids
            + ")";
      }
   }
}
