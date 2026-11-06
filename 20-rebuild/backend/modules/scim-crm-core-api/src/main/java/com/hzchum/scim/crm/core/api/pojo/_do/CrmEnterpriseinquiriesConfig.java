package com.hzchum.scim.crm.core.api.pojo._do;

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

@ApiModel(value = "CrmEnterpriseinquiriesConfig对象", description = "")
@Entity
@TableName("crm_enterpriseinquiries_config")
@Table(name = "crm_enterpriseinquiries_config")
@org.hibernate.annotations.Table(appliesTo = "crm_enterpriseinquiries_config")
public class CrmEnterpriseinquiriesConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "appCode", value = "app密钥", notes = "app密钥")
   @TableField("app_code")
   @Column(name = "app_code", columnDefinition = "varchar(255)  COMMENT 'app密钥'", nullable = false)
   private String appCode;

   public static CrmEnterpriseinquiriesConfig.CrmEnterpriseinquiriesConfigBuilder builder() {
      return new CrmEnterpriseinquiriesConfig.CrmEnterpriseinquiriesConfigBuilder();
   }

   public CrmEnterpriseinquiriesConfig() {
   }

   public CrmEnterpriseinquiriesConfig(final Long id, final String appCode) {
      this.id = id;
      this.appCode = appCode;
   }

   public Long getId() {
      return this.id;
   }

   public String getAppCode() {
      return this.appCode;
   }

   public CrmEnterpriseinquiriesConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmEnterpriseinquiriesConfig setAppCode(final String appCode) {
      this.appCode = appCode;
      return this;
   }

   @Override
   public String toString() {
      return "CrmEnterpriseinquiriesConfig(id=" + this.getId() + ", appCode=" + this.getAppCode() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CrmEnterpriseinquiriesConfig)) {
         return false;
      } else {
         CrmEnterpriseinquiriesConfig other = (CrmEnterpriseinquiriesConfig)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (!super.equals(o)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$appCode = this.getAppCode();
               Object other$appCode = other.getAppCode();
               return this$appCode == null ? other$appCode == null : this$appCode.equals(other$appCode);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CrmEnterpriseinquiriesConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $appCode = this.getAppCode();
      return result * 59 + ($appCode == null ? 43 : $appCode.hashCode());
   }

   public static class CrmEnterpriseinquiriesConfigBuilder {
      private Long id;
      private String appCode;

      CrmEnterpriseinquiriesConfigBuilder() {
      }

      public CrmEnterpriseinquiriesConfig.CrmEnterpriseinquiriesConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmEnterpriseinquiriesConfig.CrmEnterpriseinquiriesConfigBuilder appCode(final String appCode) {
         this.appCode = appCode;
         return this;
      }

      public CrmEnterpriseinquiriesConfig build() {
         return new CrmEnterpriseinquiriesConfig(this.id, this.appCode);
      }

      @Override
      public String toString() {
         return "CrmEnterpriseinquiriesConfig.CrmEnterpriseinquiriesConfigBuilder(id=" + this.id + ", appCode=" + this.appCode + ")";
      }
   }
}
