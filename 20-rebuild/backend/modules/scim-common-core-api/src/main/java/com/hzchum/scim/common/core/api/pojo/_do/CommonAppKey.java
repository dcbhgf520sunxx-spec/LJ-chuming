package com.hzchum.scim.common.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(description = "应用加密 ")
@Entity
@Table(name = "common_app_key")
public class CommonAppKey extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("应用id（1，物联，2，中南）")
   @Column
   private Long appId;
   @ApiModelProperty("访问密钥 ID")
   @Column
   private String appKey;
   @ApiModelProperty("访问密钥")
   @Column
   private String appSecret;

   public static CommonAppKey.CommonAppKeyBuilder builder() {
      return new CommonAppKey.CommonAppKeyBuilder();
   }

   public CommonAppKey() {
   }

   public CommonAppKey(final Long id, final Long appId, final String appKey, final String appSecret) {
      this.id = id;
      this.appId = appId;
      this.appKey = appKey;
      this.appSecret = appSecret;
   }

   public Long getId() {
      return this.id;
   }

   public Long getAppId() {
      return this.appId;
   }

   public String getAppKey() {
      return this.appKey;
   }

   public String getAppSecret() {
      return this.appSecret;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAppId(final Long appId) {
      this.appId = appId;
   }

   public void setAppKey(final String appKey) {
      this.appKey = appKey;
   }

   public void setAppSecret(final String appSecret) {
      this.appSecret = appSecret;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CommonAppKey)) {
         return false;
      }

      CommonAppKey other = (CommonAppKey)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$appId = this.getAppId();
         Object other$appId = other.getAppId();
         if (this$appId == null ? other$appId == null : this$appId.equals(other$appId)) {
            Object this$appKey = this.getAppKey();
            Object other$appKey = other.getAppKey();
            if (this$appKey == null ? other$appKey == null : this$appKey.equals(other$appKey)) {
               Object this$appSecret = this.getAppSecret();
               Object other$appSecret = other.getAppSecret();
               return this$appSecret == null ? other$appSecret == null : this$appSecret.equals(other$appSecret);
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
      return other instanceof CommonAppKey;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $appId = this.getAppId();
      result = result * 59 + ($appId == null ? 43 : $appId.hashCode());
      Object $appKey = this.getAppKey();
      result = result * 59 + ($appKey == null ? 43 : $appKey.hashCode());
      Object $appSecret = this.getAppSecret();
      return result * 59 + ($appSecret == null ? 43 : $appSecret.hashCode());
   }

   @Override
   public String toString() {
      return "CommonAppKey(id=" + this.getId() + ", appId=" + this.getAppId() + ", appKey=" + this.getAppKey() + ", appSecret=" + this.getAppSecret() + ")";
   }

   public static class CommonAppKeyBuilder {
      private Long id;
      private Long appId;
      private String appKey;
      private String appSecret;

      CommonAppKeyBuilder() {
      }

      public CommonAppKey.CommonAppKeyBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CommonAppKey.CommonAppKeyBuilder appId(final Long appId) {
         this.appId = appId;
         return this;
      }

      public CommonAppKey.CommonAppKeyBuilder appKey(final String appKey) {
         this.appKey = appKey;
         return this;
      }

      public CommonAppKey.CommonAppKeyBuilder appSecret(final String appSecret) {
         this.appSecret = appSecret;
         return this;
      }

      public CommonAppKey build() {
         return new CommonAppKey(this.id, this.appId, this.appKey, this.appSecret);
      }

      @Override
      public String toString() {
         return "CommonAppKey.CommonAppKeyBuilder(id=" + this.id + ", appId=" + this.appId + ", appKey=" + this.appKey + ", appSecret=" + this.appSecret + ")";
      }
   }
}
