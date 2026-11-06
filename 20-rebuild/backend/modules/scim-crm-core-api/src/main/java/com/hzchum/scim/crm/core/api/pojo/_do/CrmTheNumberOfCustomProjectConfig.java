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

@ApiModel(value = "CrmTheNumberOfCustomProjectConfig对象", description = "")
@Entity
@TableName("crm_the_number_of_custom_project_config")
@Table(name = "crm_the_number_of_custom_project_config")
@org.hibernate.annotations.Table(appliesTo = "crm_the_number_of_custom_project_config")
public class CrmTheNumberOfCustomProjectConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "userId", value = "人员id", notes = "人员id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '人员id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "projectQuota", value = "可挂载项目数量", notes = "可挂载项目数量")
   @TableField("project_quota")
   @Column(name = "project_quota", columnDefinition = "int(20)  COMMENT '可挂载项目数量'", nullable = false)
   private Integer projectQuota;

   public static CrmTheNumberOfCustomProjectConfig.CrmTheNumberOfCustomProjectConfigBuilder builder() {
      return new CrmTheNumberOfCustomProjectConfig.CrmTheNumberOfCustomProjectConfigBuilder();
   }

   public CrmTheNumberOfCustomProjectConfig() {
   }

   public CrmTheNumberOfCustomProjectConfig(final Long id, final Long userId, final Integer projectQuota) {
      this.id = id;
      this.userId = userId;
      this.projectQuota = projectQuota;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getProjectQuota() {
      return this.projectQuota;
   }

   public CrmTheNumberOfCustomProjectConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmTheNumberOfCustomProjectConfig setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public CrmTheNumberOfCustomProjectConfig setProjectQuota(final Integer projectQuota) {
      this.projectQuota = projectQuota;
      return this;
   }

   @Override
   public String toString() {
      return "CrmTheNumberOfCustomProjectConfig(id=" + this.getId() + ", userId=" + this.getUserId() + ", projectQuota=" + this.getProjectQuota() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmTheNumberOfCustomProjectConfig)) {
         return false;
      }

      CrmTheNumberOfCustomProjectConfig other = (CrmTheNumberOfCustomProjectConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$projectQuota = this.getProjectQuota();
            Object other$projectQuota = other.getProjectQuota();
            return this$projectQuota == null ? other$projectQuota == null : this$projectQuota.equals(other$projectQuota);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CrmTheNumberOfCustomProjectConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectQuota = this.getProjectQuota();
      return result * 59 + ($projectQuota == null ? 43 : $projectQuota.hashCode());
   }

   public static class CrmTheNumberOfCustomProjectConfigBuilder {
      private Long id;
      private Long userId;
      private Integer projectQuota;

      CrmTheNumberOfCustomProjectConfigBuilder() {
      }

      public CrmTheNumberOfCustomProjectConfig.CrmTheNumberOfCustomProjectConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmTheNumberOfCustomProjectConfig.CrmTheNumberOfCustomProjectConfigBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public CrmTheNumberOfCustomProjectConfig.CrmTheNumberOfCustomProjectConfigBuilder projectQuota(final Integer projectQuota) {
         this.projectQuota = projectQuota;
         return this;
      }

      public CrmTheNumberOfCustomProjectConfig build() {
         return new CrmTheNumberOfCustomProjectConfig(this.id, this.userId, this.projectQuota);
      }

      @Override
      public String toString() {
         return "CrmTheNumberOfCustomProjectConfig.CrmTheNumberOfCustomProjectConfigBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", projectQuota="
            + this.projectQuota
            + ")";
      }
   }
}
