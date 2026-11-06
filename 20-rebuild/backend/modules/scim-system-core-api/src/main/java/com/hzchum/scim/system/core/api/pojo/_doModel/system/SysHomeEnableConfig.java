package com.hzchum.scim.system.core.api.pojo._doModel.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SysHomeEnableConfig对象", description = "")
@Entity
@TableName("sys_home_enable_config")
@Table(name = "sys_home_enable_config")
@org.hibernate.annotations.Table(appliesTo = "sys_home_enable_config")
public class SysHomeEnableConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "isEnable", value = "是否开启门户", notes = "是否开启门户")
   @TableField("is_enable")
   @Column(name = "is_enable", columnDefinition = "tinyint(1) default '1' COMMENT '是否开启门户'", nullable = false)
   private Boolean isEnable;

   public static SysHomeEnableConfig.SysHomeEnableConfigBuilder builder() {
      return new SysHomeEnableConfig.SysHomeEnableConfigBuilder();
   }

   public SysHomeEnableConfig() {
   }

   public SysHomeEnableConfig(final Long id, final Boolean isEnable) {
      this.id = id;
      this.isEnable = isEnable;
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getIsEnable() {
      return this.isEnable;
   }

   public SysHomeEnableConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysHomeEnableConfig setIsEnable(final Boolean isEnable) {
      this.isEnable = isEnable;
      return this;
   }

   @Override
   public String toString() {
      return "SysHomeEnableConfig(id=" + this.getId() + ", isEnable=" + this.getIsEnable() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SysHomeEnableConfig)) {
         return false;
      } else {
         SysHomeEnableConfig other = (SysHomeEnableConfig)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (!super.equals(o)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$isEnable = this.getIsEnable();
               Object other$isEnable = other.getIsEnable();
               return this$isEnable == null ? other$isEnable == null : this$isEnable.equals(other$isEnable);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysHomeEnableConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $isEnable = this.getIsEnable();
      return result * 59 + ($isEnable == null ? 43 : $isEnable.hashCode());
   }

   public static class SysHomeEnableConfigBuilder {
      private Long id;
      private Boolean isEnable;

      SysHomeEnableConfigBuilder() {
      }

      public SysHomeEnableConfig.SysHomeEnableConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysHomeEnableConfig.SysHomeEnableConfigBuilder isEnable(final Boolean isEnable) {
         this.isEnable = isEnable;
         return this;
      }

      public SysHomeEnableConfig build() {
         return new SysHomeEnableConfig(this.id, this.isEnable);
      }

      @Override
      public String toString() {
         return "SysHomeEnableConfig.SysHomeEnableConfigBuilder(id=" + this.id + ", isEnable=" + this.isEnable + ")";
      }
   }
}
