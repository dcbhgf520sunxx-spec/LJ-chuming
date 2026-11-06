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

@ApiModel(value = "CrmPersonTemplateConfig对象", description = "")
@Entity
@TableName("crm_person_template_config")
@Table(name = "crm_person_template_config")
@org.hibernate.annotations.Table(appliesTo = "crm_person_template_config")
public class CrmPersonTemplateConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "crmPersonTemplateEnum", value = "负责人类型枚举", notes = "负责人类型枚举")
   @TableField("crm_person_template_enum")
   @Column(name = "crm_person_template_enum", columnDefinition = "int(11)  COMMENT '负责人类型枚举'", nullable = false)
   private Integer crmPersonTemplateEnum;
   @ApiModelProperty(name = "crmPersonOperateTypeEnum", value = "操作类型", notes = "操作类型")
   @TableField("crm_person_operate_type_enum")
   @Column(name = "crm_person_operate_type_enum", columnDefinition = "int(11)  COMMENT '操作类型'", nullable = false)
   private Integer crmPersonOperateTypeEnum;

   public static CrmPersonTemplateConfig.CrmPersonTemplateConfigBuilder builder() {
      return new CrmPersonTemplateConfig.CrmPersonTemplateConfigBuilder();
   }

   public CrmPersonTemplateConfig() {
   }

   public CrmPersonTemplateConfig(final Long id, final Integer crmPersonTemplateEnum, final Integer crmPersonOperateTypeEnum) {
      this.id = id;
      this.crmPersonTemplateEnum = crmPersonTemplateEnum;
      this.crmPersonOperateTypeEnum = crmPersonOperateTypeEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getCrmPersonTemplateEnum() {
      return this.crmPersonTemplateEnum;
   }

   public Integer getCrmPersonOperateTypeEnum() {
      return this.crmPersonOperateTypeEnum;
   }

   public CrmPersonTemplateConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmPersonTemplateConfig setCrmPersonTemplateEnum(final Integer crmPersonTemplateEnum) {
      this.crmPersonTemplateEnum = crmPersonTemplateEnum;
      return this;
   }

   public CrmPersonTemplateConfig setCrmPersonOperateTypeEnum(final Integer crmPersonOperateTypeEnum) {
      this.crmPersonOperateTypeEnum = crmPersonOperateTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "CrmPersonTemplateConfig(id="
         + this.getId()
         + ", crmPersonTemplateEnum="
         + this.getCrmPersonTemplateEnum()
         + ", crmPersonOperateTypeEnum="
         + this.getCrmPersonOperateTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmPersonTemplateConfig)) {
         return false;
      }

      CrmPersonTemplateConfig other = (CrmPersonTemplateConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmPersonTemplateEnum = this.getCrmPersonTemplateEnum();
         Object other$crmPersonTemplateEnum = other.getCrmPersonTemplateEnum();
         if (this$crmPersonTemplateEnum == null ? other$crmPersonTemplateEnum == null : this$crmPersonTemplateEnum.equals(other$crmPersonTemplateEnum)) {
            Object this$crmPersonOperateTypeEnum = this.getCrmPersonOperateTypeEnum();
            Object other$crmPersonOperateTypeEnum = other.getCrmPersonOperateTypeEnum();
            return this$crmPersonOperateTypeEnum == null
               ? other$crmPersonOperateTypeEnum == null
               : this$crmPersonOperateTypeEnum.equals(other$crmPersonOperateTypeEnum);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CrmPersonTemplateConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmPersonTemplateEnum = this.getCrmPersonTemplateEnum();
      result = result * 59 + ($crmPersonTemplateEnum == null ? 43 : $crmPersonTemplateEnum.hashCode());
      Object $crmPersonOperateTypeEnum = this.getCrmPersonOperateTypeEnum();
      return result * 59 + ($crmPersonOperateTypeEnum == null ? 43 : $crmPersonOperateTypeEnum.hashCode());
   }

   public static class CrmPersonTemplateConfigBuilder {
      private Long id;
      private Integer crmPersonTemplateEnum;
      private Integer crmPersonOperateTypeEnum;

      CrmPersonTemplateConfigBuilder() {
      }

      public CrmPersonTemplateConfig.CrmPersonTemplateConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmPersonTemplateConfig.CrmPersonTemplateConfigBuilder crmPersonTemplateEnum(final Integer crmPersonTemplateEnum) {
         this.crmPersonTemplateEnum = crmPersonTemplateEnum;
         return this;
      }

      public CrmPersonTemplateConfig.CrmPersonTemplateConfigBuilder crmPersonOperateTypeEnum(final Integer crmPersonOperateTypeEnum) {
         this.crmPersonOperateTypeEnum = crmPersonOperateTypeEnum;
         return this;
      }

      public CrmPersonTemplateConfig build() {
         return new CrmPersonTemplateConfig(this.id, this.crmPersonTemplateEnum, this.crmPersonOperateTypeEnum);
      }

      @Override
      public String toString() {
         return "CrmPersonTemplateConfig.CrmPersonTemplateConfigBuilder(id="
            + this.id
            + ", crmPersonTemplateEnum="
            + this.crmPersonTemplateEnum
            + ", crmPersonOperateTypeEnum="
            + this.crmPersonOperateTypeEnum
            + ")";
      }
   }
}
