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

@ApiModel(value = "CrmOaConfig", description = "CRM OA审批配置")
@Entity
@TableName("crm_oa_config")
@Table(name = "crm_oa_config")
@org.hibernate.annotations.Table(appliesTo = "crm_oa_config")
public class CrmOaConfig extends BaseEntity<Long> {
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("是否走OA审批")
   @TableField("enabled")
   @Column(name = "enabled", columnDefinition = "bit(1) COMMENT '是否走OA审批'", nullable = false)
   private Boolean enabled;

   public static CrmOaConfig.CrmOaConfigBuilder builder() {
      return new CrmOaConfig.CrmOaConfigBuilder();
   }

   public CrmOaConfig() {
   }

   public CrmOaConfig(final Long id, final Boolean enabled) {
      this.id = id;
      this.enabled = enabled;
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getEnabled() {
      return this.enabled;
   }

   public CrmOaConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmOaConfig setEnabled(final Boolean enabled) {
      this.enabled = enabled;
      return this;
   }

   @Override
   public String toString() {
      return "CrmOaConfig(id=" + this.getId() + ", enabled=" + this.getEnabled() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CrmOaConfig)) {
         return false;
      } else {
         CrmOaConfig other = (CrmOaConfig)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (!super.equals(o)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$enabled = this.getEnabled();
               Object other$enabled = other.getEnabled();
               return this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CrmOaConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $enabled = this.getEnabled();
      return result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
   }

   public static class CrmOaConfigBuilder {
      private Long id;
      private Boolean enabled;

      CrmOaConfigBuilder() {
      }

      public CrmOaConfig.CrmOaConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmOaConfig.CrmOaConfigBuilder enabled(final Boolean enabled) {
         this.enabled = enabled;
         return this;
      }

      public CrmOaConfig build() {
         return new CrmOaConfig(this.id, this.enabled);
      }

      @Override
      public String toString() {
         return "CrmOaConfig.CrmOaConfigBuilder(id=" + this.id + ", enabled=" + this.enabled + ")";
      }
   }
}
