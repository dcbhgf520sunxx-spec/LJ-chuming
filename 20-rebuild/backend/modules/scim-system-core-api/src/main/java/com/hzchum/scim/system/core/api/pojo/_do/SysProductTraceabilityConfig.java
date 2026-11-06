package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "SysProductTraceabilityConfig对象", description = "产品溯源配置表")
@Entity
@TableName("sys_product_traceability_config")
@Table(name = "sys_product_traceability_config")
@org.hibernate.annotations.Table(appliesTo = "sys_product_traceability_config", comment = "产品溯源配置表")
public class SysProductTraceabilityConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "systemName", value = "系统名称", notes = "系统名称")
   @TableField("system_name")
   @Column(name = "system_name", columnDefinition = "VARCHAR(64) COMMENT '系统名称'", nullable = false)
   private String systemName;
   @ApiModelProperty(name = "systemName", value = "公司名称", notes = "公司名称")
   @TableField("company_name")
   @Column(name = "company_name", columnDefinition = "VARCHAR(64) COMMENT '公司名称'", nullable = false)
   private String companyName;
   @ApiModelProperty(name = "productionBaseName", value = "生产基地名称", notes = "生产基地名称")
   @TableField("production_base_name")
   @Column(name = "production_base_name", columnDefinition = "VARCHAR(64) COMMENT '生产基地名称'", nullable = true)
   private String productionBaseName;
   @ApiModelProperty(name = "boolDefault", value = "是否默认值 true 是 false 否", notes = "是否默认值  true 是 false 否")
   @TableField("bool_default")
   @Column(name = "bool_default", columnDefinition = "tinyint(1) default 0 COMMENT '是否默认值 1是 0否'", nullable = false)
   private Boolean boolDefault;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20) COMMENT '创建人id'", nullable = false)
   private Long createUserId;

   public static SysProductTraceabilityConfig.SysProductTraceabilityConfigBuilder builder() {
      return new SysProductTraceabilityConfig.SysProductTraceabilityConfigBuilder();
   }

   public SysProductTraceabilityConfig() {
   }

   public SysProductTraceabilityConfig(
      final Long id, final String systemName, final String companyName, final String productionBaseName, final Boolean boolDefault, final Long createUserId
   ) {
      this.id = id;
      this.systemName = systemName;
      this.companyName = companyName;
      this.productionBaseName = productionBaseName;
      this.boolDefault = boolDefault;
      this.createUserId = createUserId;
   }

   public Long getId() {
      return this.id;
   }

   public String getSystemName() {
      return this.systemName;
   }

   public String getCompanyName() {
      return this.companyName;
   }

   public String getProductionBaseName() {
      return this.productionBaseName;
   }

   public Boolean getBoolDefault() {
      return this.boolDefault;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public SysProductTraceabilityConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysProductTraceabilityConfig setSystemName(final String systemName) {
      this.systemName = systemName;
      return this;
   }

   public SysProductTraceabilityConfig setCompanyName(final String companyName) {
      this.companyName = companyName;
      return this;
   }

   public SysProductTraceabilityConfig setProductionBaseName(final String productionBaseName) {
      this.productionBaseName = productionBaseName;
      return this;
   }

   public SysProductTraceabilityConfig setBoolDefault(final Boolean boolDefault) {
      this.boolDefault = boolDefault;
      return this;
   }

   public SysProductTraceabilityConfig setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   @Override
   public String toString() {
      return "SysProductTraceabilityConfig(id="
         + this.getId()
         + ", systemName="
         + this.getSystemName()
         + ", companyName="
         + this.getCompanyName()
         + ", productionBaseName="
         + this.getProductionBaseName()
         + ", boolDefault="
         + this.getBoolDefault()
         + ", createUserId="
         + this.getCreateUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysProductTraceabilityConfig)) {
         return false;
      }

      SysProductTraceabilityConfig other = (SysProductTraceabilityConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolDefault = this.getBoolDefault();
         Object other$boolDefault = other.getBoolDefault();
         if (this$boolDefault == null ? other$boolDefault == null : this$boolDefault.equals(other$boolDefault)) {
            Object this$createUserId = this.getCreateUserId();
            Object other$createUserId = other.getCreateUserId();
            if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
               Object this$systemName = this.getSystemName();
               Object other$systemName = other.getSystemName();
               if (this$systemName == null ? other$systemName == null : this$systemName.equals(other$systemName)) {
                  Object this$companyName = this.getCompanyName();
                  Object other$companyName = other.getCompanyName();
                  if (this$companyName == null ? other$companyName == null : this$companyName.equals(other$companyName)) {
                     Object this$productionBaseName = this.getProductionBaseName();
                     Object other$productionBaseName = other.getProductionBaseName();
                     return this$productionBaseName == null ? other$productionBaseName == null : this$productionBaseName.equals(other$productionBaseName);
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
      return other instanceof SysProductTraceabilityConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolDefault = this.getBoolDefault();
      result = result * 59 + ($boolDefault == null ? 43 : $boolDefault.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $systemName = this.getSystemName();
      result = result * 59 + ($systemName == null ? 43 : $systemName.hashCode());
      Object $companyName = this.getCompanyName();
      result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
      Object $productionBaseName = this.getProductionBaseName();
      return result * 59 + ($productionBaseName == null ? 43 : $productionBaseName.hashCode());
   }

   public static class SysProductTraceabilityConfigBuilder {
      private Long id;
      private String systemName;
      private String companyName;
      private String productionBaseName;
      private Boolean boolDefault;
      private Long createUserId;

      SysProductTraceabilityConfigBuilder() {
      }

      public SysProductTraceabilityConfig.SysProductTraceabilityConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysProductTraceabilityConfig.SysProductTraceabilityConfigBuilder systemName(final String systemName) {
         this.systemName = systemName;
         return this;
      }

      public SysProductTraceabilityConfig.SysProductTraceabilityConfigBuilder companyName(final String companyName) {
         this.companyName = companyName;
         return this;
      }

      public SysProductTraceabilityConfig.SysProductTraceabilityConfigBuilder productionBaseName(final String productionBaseName) {
         this.productionBaseName = productionBaseName;
         return this;
      }

      public SysProductTraceabilityConfig.SysProductTraceabilityConfigBuilder boolDefault(final Boolean boolDefault) {
         this.boolDefault = boolDefault;
         return this;
      }

      public SysProductTraceabilityConfig.SysProductTraceabilityConfigBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public SysProductTraceabilityConfig build() {
         return new SysProductTraceabilityConfig(this.id, this.systemName, this.companyName, this.productionBaseName, this.boolDefault, this.createUserId);
      }

      @Override
      public String toString() {
         return "SysProductTraceabilityConfig.SysProductTraceabilityConfigBuilder(id="
            + this.id
            + ", systemName="
            + this.systemName
            + ", companyName="
            + this.companyName
            + ", productionBaseName="
            + this.productionBaseName
            + ", boolDefault="
            + this.boolDefault
            + ", createUserId="
            + this.createUserId
            + ")";
      }
   }
}
