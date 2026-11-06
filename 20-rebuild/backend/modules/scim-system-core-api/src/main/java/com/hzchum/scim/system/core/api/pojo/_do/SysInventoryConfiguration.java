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

@ApiModel(value = "SysInventoryConfiguration对象", description = "清单误差配置表")
@Entity
@TableName("sys_inventory_configuration")
@Table(name = "sys_inventory_configuration")
public class SysInventoryConfiguration extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目Id", notes = "项目Id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目Id'")
   private Long projectId;
   @ApiModelProperty(name = "value")
   @JsonProperty("value")
   @JSONField(name = "value")
   @TableField("value")
   @Column(name = "value", columnDefinition = "varchar(1024)", nullable = false)
   private String value;
   @ApiModelProperty(name = "boolGeneralConfig")
   @JsonProperty("boolGeneralConfig")
   @JSONField(name = "boolGeneralConfig")
   @TableField("bool_general_config")
   @Column(name = "bool_general_config", columnDefinition = "tinyint(1) DEFAULT 0 comment '是否通用配置'", nullable = false)
   private Boolean boolGeneralConfig;

   public static SysInventoryConfiguration.SysInventoryConfigurationBuilder builder() {
      return new SysInventoryConfiguration.SysInventoryConfigurationBuilder();
   }

   public SysInventoryConfiguration() {
   }

   public SysInventoryConfiguration(final Long id, final Long projectId, final String value, final Boolean boolGeneralConfig) {
      this.id = id;
      this.projectId = projectId;
      this.value = value;
      this.boolGeneralConfig = boolGeneralConfig;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getValue() {
      return this.value;
   }

   public Boolean getBoolGeneralConfig() {
      return this.boolGeneralConfig;
   }

   @JsonProperty("id")
   public SysInventoryConfiguration setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public SysInventoryConfiguration setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("value")
   public SysInventoryConfiguration setValue(final String value) {
      this.value = value;
      return this;
   }

   @JsonProperty("boolGeneralConfig")
   public SysInventoryConfiguration setBoolGeneralConfig(final Boolean boolGeneralConfig) {
      this.boolGeneralConfig = boolGeneralConfig;
      return this;
   }

   @Override
   public String toString() {
      return "SysInventoryConfiguration(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", value="
         + this.getValue()
         + ", boolGeneralConfig="
         + this.getBoolGeneralConfig()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysInventoryConfiguration)) {
         return false;
      }

      SysInventoryConfiguration other = (SysInventoryConfiguration)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysInventoryConfiguration;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $boolGeneralConfig = this.getBoolGeneralConfig();
      result = result * 59 + ($boolGeneralConfig == null ? 43 : $boolGeneralConfig.hashCode());
      Object $value = this.getValue();
      return result * 59 + ($value == null ? 43 : $value.hashCode());
   }

   public static class SysInventoryConfigurationBuilder {
      private Long id;
      private Long projectId;
      private String value;
      private Boolean boolGeneralConfig;

      SysInventoryConfigurationBuilder() {
      }

      @JsonProperty("id")
      public SysInventoryConfiguration.SysInventoryConfigurationBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public SysInventoryConfiguration.SysInventoryConfigurationBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("value")
      public SysInventoryConfiguration.SysInventoryConfigurationBuilder value(final String value) {
         this.value = value;
         return this;
      }

      @JsonProperty("boolGeneralConfig")
      public SysInventoryConfiguration.SysInventoryConfigurationBuilder boolGeneralConfig(final Boolean boolGeneralConfig) {
         this.boolGeneralConfig = boolGeneralConfig;
         return this;
      }

      public SysInventoryConfiguration build() {
         return new SysInventoryConfiguration(this.id, this.projectId, this.value, this.boolGeneralConfig);
      }

      @Override
      public String toString() {
         return "SysInventoryConfiguration.SysInventoryConfigurationBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", value="
            + this.value
            + ", boolGeneralConfig="
            + this.boolGeneralConfig
            + ")";
      }
   }
}
