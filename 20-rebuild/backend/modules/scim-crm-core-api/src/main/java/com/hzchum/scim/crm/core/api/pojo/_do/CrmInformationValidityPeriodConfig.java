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

@ApiModel(value = "CrmInformationValidityPeriodConfig对象", description = "CA锁配置")
@Entity
@TableName("crm_information_validity_period_config")
@Table(name = "crm_information_validity_period_config")
@org.hibernate.annotations.Table(appliesTo = "crm_information_validity_period_config")
public class CrmInformationValidityPeriodConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "crmInformationValidityPeriodConfigEnum", value = "信息配置类型枚举（信息，ca锁）", notes = "信息配置类型枚举（信息，ca锁）")
   @TableField("crm_information_validity_period_config_enum")
   @Column(name = "crm_information_validity_period_config_enum", columnDefinition = "int(11)  COMMENT '信息配置类型枚举（信息，ca锁）'", nullable = false)
   private Integer crmInformationValidityPeriodConfigEnum;
   @ApiModelProperty(name = "validityOfRegistration", value = "项目信息登记有效期", notes = "项目信息登记有效期")
   @TableField("validity_of_registration")
   @Column(name = "validity_of_registration", columnDefinition = "int(11)  COMMENT '项目信息登记有效期'", nullable = true)
   private Integer validityOfRegistration;
   @ApiModelProperty(name = "remindInAdvance", value = "有效期提前提醒设置", notes = "有效期提前提醒设置")
   @TableField("remind_in_advance")
   @Column(name = "remind_in_advance", columnDefinition = "int(11)  COMMENT '有效期提前提醒设置'", nullable = true)
   private Integer remindInAdvance;
   @ApiModelProperty(name = "projectQuota", value = "项目名额数量配置", notes = "项目名额数量配置")
   @TableField("project_quota")
   @Column(name = "project_quota", columnDefinition = "int(11)  COMMENT '项目名额数量配置'", nullable = true)
   private Integer projectQuota;

   public static CrmInformationValidityPeriodConfig.CrmInformationValidityPeriodConfigBuilder builder() {
      return new CrmInformationValidityPeriodConfig.CrmInformationValidityPeriodConfigBuilder();
   }

   public CrmInformationValidityPeriodConfig() {
   }

   public CrmInformationValidityPeriodConfig(
      final Long id,
      final Integer crmInformationValidityPeriodConfigEnum,
      final Integer validityOfRegistration,
      final Integer remindInAdvance,
      final Integer projectQuota
   ) {
      this.id = id;
      this.crmInformationValidityPeriodConfigEnum = crmInformationValidityPeriodConfigEnum;
      this.validityOfRegistration = validityOfRegistration;
      this.remindInAdvance = remindInAdvance;
      this.projectQuota = projectQuota;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getCrmInformationValidityPeriodConfigEnum() {
      return this.crmInformationValidityPeriodConfigEnum;
   }

   public Integer getValidityOfRegistration() {
      return this.validityOfRegistration;
   }

   public Integer getRemindInAdvance() {
      return this.remindInAdvance;
   }

   public Integer getProjectQuota() {
      return this.projectQuota;
   }

   public CrmInformationValidityPeriodConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmInformationValidityPeriodConfig setCrmInformationValidityPeriodConfigEnum(final Integer crmInformationValidityPeriodConfigEnum) {
      this.crmInformationValidityPeriodConfigEnum = crmInformationValidityPeriodConfigEnum;
      return this;
   }

   public CrmInformationValidityPeriodConfig setValidityOfRegistration(final Integer validityOfRegistration) {
      this.validityOfRegistration = validityOfRegistration;
      return this;
   }

   public CrmInformationValidityPeriodConfig setRemindInAdvance(final Integer remindInAdvance) {
      this.remindInAdvance = remindInAdvance;
      return this;
   }

   public CrmInformationValidityPeriodConfig setProjectQuota(final Integer projectQuota) {
      this.projectQuota = projectQuota;
      return this;
   }

   @Override
   public String toString() {
      return "CrmInformationValidityPeriodConfig(id="
         + this.getId()
         + ", crmInformationValidityPeriodConfigEnum="
         + this.getCrmInformationValidityPeriodConfigEnum()
         + ", validityOfRegistration="
         + this.getValidityOfRegistration()
         + ", remindInAdvance="
         + this.getRemindInAdvance()
         + ", projectQuota="
         + this.getProjectQuota()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmInformationValidityPeriodConfig)) {
         return false;
      }

      CrmInformationValidityPeriodConfig other = (CrmInformationValidityPeriodConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmInformationValidityPeriodConfigEnum = this.getCrmInformationValidityPeriodConfigEnum();
         Object other$crmInformationValidityPeriodConfigEnum = other.getCrmInformationValidityPeriodConfigEnum();
         if (this$crmInformationValidityPeriodConfigEnum == null
            ? other$crmInformationValidityPeriodConfigEnum == null
            : this$crmInformationValidityPeriodConfigEnum.equals(other$crmInformationValidityPeriodConfigEnum)) {
            Object this$validityOfRegistration = this.getValidityOfRegistration();
            Object other$validityOfRegistration = other.getValidityOfRegistration();
            if (this$validityOfRegistration == null ? other$validityOfRegistration == null : this$validityOfRegistration.equals(other$validityOfRegistration)) {
               Object this$remindInAdvance = this.getRemindInAdvance();
               Object other$remindInAdvance = other.getRemindInAdvance();
               if (this$remindInAdvance == null ? other$remindInAdvance == null : this$remindInAdvance.equals(other$remindInAdvance)) {
                  Object this$projectQuota = this.getProjectQuota();
                  Object other$projectQuota = other.getProjectQuota();
                  return this$projectQuota == null ? other$projectQuota == null : this$projectQuota.equals(other$projectQuota);
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
      return other instanceof CrmInformationValidityPeriodConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmInformationValidityPeriodConfigEnum = this.getCrmInformationValidityPeriodConfigEnum();
      result = result * 59 + ($crmInformationValidityPeriodConfigEnum == null ? 43 : $crmInformationValidityPeriodConfigEnum.hashCode());
      Object $validityOfRegistration = this.getValidityOfRegistration();
      result = result * 59 + ($validityOfRegistration == null ? 43 : $validityOfRegistration.hashCode());
      Object $remindInAdvance = this.getRemindInAdvance();
      result = result * 59 + ($remindInAdvance == null ? 43 : $remindInAdvance.hashCode());
      Object $projectQuota = this.getProjectQuota();
      return result * 59 + ($projectQuota == null ? 43 : $projectQuota.hashCode());
   }

   public static class CrmInformationValidityPeriodConfigBuilder {
      private Long id;
      private Integer crmInformationValidityPeriodConfigEnum;
      private Integer validityOfRegistration;
      private Integer remindInAdvance;
      private Integer projectQuota;

      CrmInformationValidityPeriodConfigBuilder() {
      }

      public CrmInformationValidityPeriodConfig.CrmInformationValidityPeriodConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmInformationValidityPeriodConfig.CrmInformationValidityPeriodConfigBuilder crmInformationValidityPeriodConfigEnum(
         final Integer crmInformationValidityPeriodConfigEnum
      ) {
         this.crmInformationValidityPeriodConfigEnum = crmInformationValidityPeriodConfigEnum;
         return this;
      }

      public CrmInformationValidityPeriodConfig.CrmInformationValidityPeriodConfigBuilder validityOfRegistration(final Integer validityOfRegistration) {
         this.validityOfRegistration = validityOfRegistration;
         return this;
      }

      public CrmInformationValidityPeriodConfig.CrmInformationValidityPeriodConfigBuilder remindInAdvance(final Integer remindInAdvance) {
         this.remindInAdvance = remindInAdvance;
         return this;
      }

      public CrmInformationValidityPeriodConfig.CrmInformationValidityPeriodConfigBuilder projectQuota(final Integer projectQuota) {
         this.projectQuota = projectQuota;
         return this;
      }

      public CrmInformationValidityPeriodConfig build() {
         return new CrmInformationValidityPeriodConfig(
            this.id, this.crmInformationValidityPeriodConfigEnum, this.validityOfRegistration, this.remindInAdvance, this.projectQuota
         );
      }

      @Override
      public String toString() {
         return "CrmInformationValidityPeriodConfig.CrmInformationValidityPeriodConfigBuilder(id="
            + this.id
            + ", crmInformationValidityPeriodConfigEnum="
            + this.crmInformationValidityPeriodConfigEnum
            + ", validityOfRegistration="
            + this.validityOfRegistration
            + ", remindInAdvance="
            + this.remindInAdvance
            + ", projectQuota="
            + this.projectQuota
            + ")";
      }
   }
}
