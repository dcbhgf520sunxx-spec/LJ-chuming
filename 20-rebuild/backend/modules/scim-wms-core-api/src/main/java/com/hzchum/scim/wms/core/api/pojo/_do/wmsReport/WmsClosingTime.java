package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "WmsClosingTime对象", description = "")
@Entity
@TableName("wms_closing_time")
@Table(name = "wms_closing_time")
@org.hibernate.annotations.Table(appliesTo = "wms_closing_time")
public class WmsClosingTime extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "startTime", value = "关账开始时间", notes = "关账开始时间")
   @TableField("start_time")
   @Column(name = "start_time", columnDefinition = "datetime(6)  COMMENT '关账开始时间'", nullable = true)
   private LocalDateTime startTime;
   @ApiModelProperty(name = "endTime", value = "关账结束时间", notes = "关账结束时间")
   @TableField("end_time")
   @Column(name = "end_time", columnDefinition = "datetime(6)  COMMENT '关账结束时间'", nullable = true)
   private LocalDateTime endTime;
   @ApiModelProperty(name = "name", value = "关账名称", notes = "关账名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '关账名称'", nullable = true)
   private String name;

   public static WmsClosingTime.WmsClosingTimeBuilder builder() {
      return new WmsClosingTime.WmsClosingTimeBuilder();
   }

   public WmsClosingTime() {
   }

   public WmsClosingTime(final Long id, final LocalDateTime startTime, final LocalDateTime endTime, final String name) {
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

   public WmsClosingTime setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsClosingTime setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
      return this;
   }

   public WmsClosingTime setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
      return this;
   }

   public WmsClosingTime setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public String toString() {
      return "WmsClosingTime(id=" + this.getId() + ", startTime=" + this.getStartTime() + ", endTime=" + this.getEndTime() + ", name=" + this.getName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsClosingTime)) {
         return false;
      }

      WmsClosingTime other = (WmsClosingTime)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WmsClosingTime;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class WmsClosingTimeBuilder {
      private Long id;
      private LocalDateTime startTime;
      private LocalDateTime endTime;
      private String name;

      WmsClosingTimeBuilder() {
      }

      public WmsClosingTime.WmsClosingTimeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsClosingTime.WmsClosingTimeBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      public WmsClosingTime.WmsClosingTimeBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      public WmsClosingTime.WmsClosingTimeBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public WmsClosingTime build() {
         return new WmsClosingTime(this.id, this.startTime, this.endTime, this.name);
      }

      @Override
      public String toString() {
         return "WmsClosingTime.WmsClosingTimeBuilder(id="
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
