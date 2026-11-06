package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "SysHomeCreateTrip对象", description = "")
@Entity
@TableName("sys_home_create_trip")
@Table(name = "sys_home_create_trip")
@org.hibernate.annotations.Table(appliesTo = "sys_home_create_trip")
public class SysHomeCreateTrip extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "createUserId", value = "创建人", notes = "创建人")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "int  COMMENT '创建人'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人姓名", notes = "创建人姓名")
   @TableField("create_user_name")
   @Column(name = "create_user_name", columnDefinition = "varchar(255)  COMMENT '创建人姓名'", nullable = false)
   private String createUserName;
   @ApiModelProperty(name = "setTime", value = "行程时间", notes = "行程时间")
   @TableField("set_time")
   @Column(name = "set_time", columnDefinition = "datetime  COMMENT '行程时间'", nullable = false)
   private LocalDateTime setTime;
   @ApiModelProperty(name = "title", value = "标题", notes = "标题")
   @TableField("title")
   @Column(name = "title", columnDefinition = "varchar(4096)  COMMENT '标题'", nullable = false)
   private String title;

   public static SysHomeCreateTrip.SysHomeCreateTripBuilder builder() {
      return new SysHomeCreateTrip.SysHomeCreateTripBuilder();
   }

   public SysHomeCreateTrip() {
   }

   public SysHomeCreateTrip(final Long id, final Long createUserId, final String createUserName, final LocalDateTime setTime, final String title) {
      this.id = id;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.setTime = setTime;
      this.title = title;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public LocalDateTime getSetTime() {
      return this.setTime;
   }

   public String getTitle() {
      return this.title;
   }

   public SysHomeCreateTrip setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysHomeCreateTrip setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public SysHomeCreateTrip setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public SysHomeCreateTrip setSetTime(final LocalDateTime setTime) {
      this.setTime = setTime;
      return this;
   }

   public SysHomeCreateTrip setTitle(final String title) {
      this.title = title;
      return this;
   }

   @Override
   public String toString() {
      return "SysHomeCreateTrip(id="
         + this.getId()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", setTime="
         + this.getSetTime()
         + ", title="
         + this.getTitle()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysHomeCreateTrip)) {
         return false;
      }

      SysHomeCreateTrip other = (SysHomeCreateTrip)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$createUserId = this.getCreateUserId();
         Object other$createUserId = other.getCreateUserId();
         if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
            Object this$createUserName = this.getCreateUserName();
            Object other$createUserName = other.getCreateUserName();
            if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
               Object this$setTime = this.getSetTime();
               Object other$setTime = other.getSetTime();
               if (this$setTime == null ? other$setTime == null : this$setTime.equals(other$setTime)) {
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysHomeCreateTrip;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $setTime = this.getSetTime();
      result = result * 59 + ($setTime == null ? 43 : $setTime.hashCode());
      Object $title = this.getTitle();
      return result * 59 + ($title == null ? 43 : $title.hashCode());
   }

   public static class SysHomeCreateTripBuilder {
      private Long id;
      private Long createUserId;
      private String createUserName;
      private LocalDateTime setTime;
      private String title;

      SysHomeCreateTripBuilder() {
      }

      public SysHomeCreateTrip.SysHomeCreateTripBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysHomeCreateTrip.SysHomeCreateTripBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public SysHomeCreateTrip.SysHomeCreateTripBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public SysHomeCreateTrip.SysHomeCreateTripBuilder setTime(final LocalDateTime setTime) {
         this.setTime = setTime;
         return this;
      }

      public SysHomeCreateTrip.SysHomeCreateTripBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public SysHomeCreateTrip build() {
         return new SysHomeCreateTrip(this.id, this.createUserId, this.createUserName, this.setTime, this.title);
      }

      @Override
      public String toString() {
         return "SysHomeCreateTrip.SysHomeCreateTripBuilder(id="
            + this.id
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", setTime="
            + this.setTime
            + ", title="
            + this.title
            + ")";
      }
   }
}
