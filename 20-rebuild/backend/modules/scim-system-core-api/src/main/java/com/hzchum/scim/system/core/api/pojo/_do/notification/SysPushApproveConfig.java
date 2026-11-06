package com.hzchum.scim.system.core.api.pojo._do.notification;

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

@ApiModel(value = "SysPushApproveConfig对象", description = "")
@Entity
@TableName("sys_push_approve_config")
@Table(name = "sys_push_approve_config")
@org.hibernate.annotations.Table(appliesTo = "sys_push_approve_config")
public class SysPushApproveConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "app_key", value = "AppKey", notes = "AppKey")
   @TableField("app_key")
   @Column(name = "app_key", columnDefinition = "varchar(50)  COMMENT ''", unique = true, nullable = false)
   private String appKey;
   @ApiModelProperty(name = "app_secret", value = "秘密", notes = "秘密")
   @TableField("app_secret")
   @Column(name = "app_secret", columnDefinition = "varchar(100)  COMMENT '秘密'", nullable = false)
   private String appSecret;
   @ApiModelProperty(name = "robot_code", value = "工具人code", notes = "工具人code")
   @TableField("robot_code")
   @Column(name = "robot_code", columnDefinition = "varchar(50)  COMMENT '工具人code'", nullable = false)
   private String robotCode;
   @ApiModelProperty(name = "app_type", value = "1,钉钉，2，企微", notes = "1,钉钉，2，企微")
   @TableField("app_type")
   @Column(name = "app_type", columnDefinition = "int(2) default 1 comment '1,钉钉，2，企微'", nullable = false)
   private Integer appType;
   @ApiModelProperty(name = "status", value = "状态", notes = "状态")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(2) default 1 comment '开启状态 1启用 0禁用'", nullable = false)
   private Integer status;

   public static SysPushApproveConfig.SysPushApproveConfigBuilder builder() {
      return new SysPushApproveConfig.SysPushApproveConfigBuilder();
   }

   public SysPushApproveConfig() {
   }

   public SysPushApproveConfig(final Long id, final String appKey, final String appSecret, final String robotCode, final Integer appType, final Integer status) {
      this.id = id;
      this.appKey = appKey;
      this.appSecret = appSecret;
      this.robotCode = robotCode;
      this.appType = appType;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public String getAppKey() {
      return this.appKey;
   }

   public String getAppSecret() {
      return this.appSecret;
   }

   public String getRobotCode() {
      return this.robotCode;
   }

   public Integer getAppType() {
      return this.appType;
   }

   public Integer getStatus() {
      return this.status;
   }

   public SysPushApproveConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysPushApproveConfig setAppKey(final String appKey) {
      this.appKey = appKey;
      return this;
   }

   public SysPushApproveConfig setAppSecret(final String appSecret) {
      this.appSecret = appSecret;
      return this;
   }

   public SysPushApproveConfig setRobotCode(final String robotCode) {
      this.robotCode = robotCode;
      return this;
   }

   public SysPushApproveConfig setAppType(final Integer appType) {
      this.appType = appType;
      return this;
   }

   public SysPushApproveConfig setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "SysPushApproveConfig(id="
         + this.getId()
         + ", appKey="
         + this.getAppKey()
         + ", appSecret="
         + this.getAppSecret()
         + ", robotCode="
         + this.getRobotCode()
         + ", appType="
         + this.getAppType()
         + ", status="
         + this.getStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushApproveConfig)) {
         return false;
      }

      SysPushApproveConfig other = (SysPushApproveConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$appType = this.getAppType();
         Object other$appType = other.getAppType();
         if (this$appType == null ? other$appType == null : this$appType.equals(other$appType)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$appKey = this.getAppKey();
               Object other$appKey = other.getAppKey();
               if (this$appKey == null ? other$appKey == null : this$appKey.equals(other$appKey)) {
                  Object this$appSecret = this.getAppSecret();
                  Object other$appSecret = other.getAppSecret();
                  if (this$appSecret == null ? other$appSecret == null : this$appSecret.equals(other$appSecret)) {
                     Object this$robotCode = this.getRobotCode();
                     Object other$robotCode = other.getRobotCode();
                     return this$robotCode == null ? other$robotCode == null : this$robotCode.equals(other$robotCode);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysPushApproveConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $appType = this.getAppType();
      result = result * 59 + ($appType == null ? 43 : $appType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $appKey = this.getAppKey();
      result = result * 59 + ($appKey == null ? 43 : $appKey.hashCode());
      Object $appSecret = this.getAppSecret();
      result = result * 59 + ($appSecret == null ? 43 : $appSecret.hashCode());
      Object $robotCode = this.getRobotCode();
      return result * 59 + ($robotCode == null ? 43 : $robotCode.hashCode());
   }

   public static class SysPushApproveConfigBuilder {
      private Long id;
      private String appKey;
      private String appSecret;
      private String robotCode;
      private Integer appType;
      private Integer status;

      SysPushApproveConfigBuilder() {
      }

      public SysPushApproveConfig.SysPushApproveConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushApproveConfig.SysPushApproveConfigBuilder appKey(final String appKey) {
         this.appKey = appKey;
         return this;
      }

      public SysPushApproveConfig.SysPushApproveConfigBuilder appSecret(final String appSecret) {
         this.appSecret = appSecret;
         return this;
      }

      public SysPushApproveConfig.SysPushApproveConfigBuilder robotCode(final String robotCode) {
         this.robotCode = robotCode;
         return this;
      }

      public SysPushApproveConfig.SysPushApproveConfigBuilder appType(final Integer appType) {
         this.appType = appType;
         return this;
      }

      public SysPushApproveConfig.SysPushApproveConfigBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public SysPushApproveConfig build() {
         return new SysPushApproveConfig(this.id, this.appKey, this.appSecret, this.robotCode, this.appType, this.status);
      }

      @Override
      public String toString() {
         return "SysPushApproveConfig.SysPushApproveConfigBuilder(id="
            + this.id
            + ", appKey="
            + this.appKey
            + ", appSecret="
            + this.appSecret
            + ", robotCode="
            + this.robotCode
            + ", appType="
            + this.appType
            + ", status="
            + this.status
            + ")";
      }
   }
}
