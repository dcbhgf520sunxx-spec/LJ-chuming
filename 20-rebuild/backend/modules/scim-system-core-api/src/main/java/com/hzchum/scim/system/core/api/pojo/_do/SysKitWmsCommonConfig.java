package com.hzchum.scim.system.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SysKitWmsCommonConfig对象", description = "配套件关联物料配置")
@Entity
@TableName("sys_kit_wms_common_config")
@Table(name = "sys_kit_wms_common_config")
@org.hibernate.annotations.Table(appliesTo = "sys_kit_wms_common_config")
public class SysKitWmsCommonConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "value")
   @TableField("value")
   @Column(name = "value", columnDefinition = "varchar(1024)  COMMENT ''", nullable = false)
   private String value;
   @ApiModelProperty(name = "boolGeneralConfig")
   @JsonProperty("boolGeneralConfig")
   @JSONField(name = "boolGeneralConfig")
   @TableField("bool_general_config")
   @Column(name = "bool_general_config", columnDefinition = "tinyint(1) DEFAULT 0 comment '是否通用配置'", nullable = false)
   private Boolean boolGeneralConfig;

   public static SysKitWmsCommonConfig.SysKitWmsCommonConfigBuilder builder() {
      return new SysKitWmsCommonConfig.SysKitWmsCommonConfigBuilder();
   }

   public SysKitWmsCommonConfig() {
   }

   public SysKitWmsCommonConfig(final Long id, final String value, final Boolean boolGeneralConfig) {
      this.id = id;
      this.value = value;
      this.boolGeneralConfig = boolGeneralConfig;
   }

   public Long getId() {
      return this.id;
   }

   public String getValue() {
      return this.value;
   }

   public Boolean getBoolGeneralConfig() {
      return this.boolGeneralConfig;
   }

   public SysKitWmsCommonConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysKitWmsCommonConfig setValue(final String value) {
      this.value = value;
      return this;
   }

   @JsonProperty("boolGeneralConfig")
   public SysKitWmsCommonConfig setBoolGeneralConfig(final Boolean boolGeneralConfig) {
      this.boolGeneralConfig = boolGeneralConfig;
      return this;
   }

   @Override
   public String toString() {
      return "SysKitWmsCommonConfig(id=" + this.getId() + ", value=" + this.getValue() + ", boolGeneralConfig=" + this.getBoolGeneralConfig() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysKitWmsCommonConfig)) {
         return false;
      }

      SysKitWmsCommonConfig other = (SysKitWmsCommonConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolGeneralConfig = this.getBoolGeneralConfig();
         Object other$boolGeneralConfig = other.getBoolGeneralConfig();
         if (this$boolGeneralConfig == null ? other$boolGeneralConfig == null : this$boolGeneralConfig.equals(other$boolGeneralConfig)) {
            Object this$value = this.getValue();
            Object other$value = other.getValue();
            return this$value == null ? other$value == null : this$value.equals(other$value);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysKitWmsCommonConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolGeneralConfig = this.getBoolGeneralConfig();
      result = result * 59 + ($boolGeneralConfig == null ? 43 : $boolGeneralConfig.hashCode());
      Object $value = this.getValue();
      return result * 59 + ($value == null ? 43 : $value.hashCode());
   }

   public static class SysKitWmsCommonConfigBuilder {
      private Long id;
      private String value;
      private Boolean boolGeneralConfig;

      SysKitWmsCommonConfigBuilder() {
      }

      public SysKitWmsCommonConfig.SysKitWmsCommonConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysKitWmsCommonConfig.SysKitWmsCommonConfigBuilder value(final String value) {
         this.value = value;
         return this;
      }

      @JsonProperty("boolGeneralConfig")
      public SysKitWmsCommonConfig.SysKitWmsCommonConfigBuilder boolGeneralConfig(final Boolean boolGeneralConfig) {
         this.boolGeneralConfig = boolGeneralConfig;
         return this;
      }

      public SysKitWmsCommonConfig build() {
         return new SysKitWmsCommonConfig(this.id, this.value, this.boolGeneralConfig);
      }

      @Override
      public String toString() {
         return "SysKitWmsCommonConfig.SysKitWmsCommonConfigBuilder(id="
            + this.id
            + ", value="
            + this.value
            + ", boolGeneralConfig="
            + this.boolGeneralConfig
            + ")";
      }
   }
}
