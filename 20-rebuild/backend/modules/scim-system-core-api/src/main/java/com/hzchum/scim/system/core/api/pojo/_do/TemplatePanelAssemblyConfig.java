package com.hzchum.scim.system.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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

@ApiModel(description = "板拼部件模板配置表 ")
@Entity
@Table(name = "template_panel_assembly_config")
public class TemplatePanelAssemblyConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "structureClassificationId", value = "构件特征定义Id")
   @JsonProperty("structureClassificationId")
   @JSONField(name = "structureClassificationId")
   @TableField("structure_classification_id")
   @Column(name = "structure_classification_id", columnDefinition = "bigint(20)  COMMENT '构件特征定义Id'", nullable = false)
   private Long structureClassificationId;
   @ApiModelProperty(name = "artifactPartNumberPrefix", value = "零件编号前缀列表(用于判断构件特征定义归属)")
   @JsonProperty("artifactPartNumberPrefix")
   @JSONField(name = "artifactPartNumberPrefix")
   @TableField(value = "artifact_part_number_prefix", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "artifact_part_number_prefix", columnDefinition = "varchar(255)  COMMENT '零件编号前缀列表(用于判断构件特征定义归属)'")
   private String artifactPartNumberPrefix;
   @ApiModelProperty(name = "webPartNumberPrefix", value = "腹板零件编号前缀")
   @JsonProperty("webPartNumberPrefix")
   @JSONField(name = "webPartNumberPrefix")
   @TableField(value = "web_part_number_prefix", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "web_part_number_prefix", columnDefinition = "varchar(255)  COMMENT '腹板零件编号前缀'")
   private String webPartNumberPrefix;
   @ApiModelProperty(name = "sailPartNumberPrefix", value = "翼板零件编号前缀")
   @JsonProperty("sailPartNumberPrefix")
   @JSONField(name = "sailPartNumberPrefix")
   @TableField(value = "sail_part_number_prefix", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "sail_part_number_prefix", columnDefinition = "varchar(255)  COMMENT '翼板零件编号前缀'")
   private String sailPartNumberPrefix;

   public static TemplatePanelAssemblyConfig.TemplatePanelAssemblyConfigBuilder builder() {
      return new TemplatePanelAssemblyConfig.TemplatePanelAssemblyConfigBuilder();
   }

   public TemplatePanelAssemblyConfig() {
   }

   public TemplatePanelAssemblyConfig(
      final Long id,
      final Long structureClassificationId,
      final String artifactPartNumberPrefix,
      final String webPartNumberPrefix,
      final String sailPartNumberPrefix
   ) {
      this.id = id;
      this.structureClassificationId = structureClassificationId;
      this.artifactPartNumberPrefix = artifactPartNumberPrefix;
      this.webPartNumberPrefix = webPartNumberPrefix;
      this.sailPartNumberPrefix = sailPartNumberPrefix;
   }

   public Long getId() {
      return this.id;
   }

   public Long getStructureClassificationId() {
      return this.structureClassificationId;
   }

   public String getArtifactPartNumberPrefix() {
      return this.artifactPartNumberPrefix;
   }

   public String getWebPartNumberPrefix() {
      return this.webPartNumberPrefix;
   }

   public String getSailPartNumberPrefix() {
      return this.sailPartNumberPrefix;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("structureClassificationId")
   public void setStructureClassificationId(final Long structureClassificationId) {
      this.structureClassificationId = structureClassificationId;
   }

   @JsonProperty("artifactPartNumberPrefix")
   public void setArtifactPartNumberPrefix(final String artifactPartNumberPrefix) {
      this.artifactPartNumberPrefix = artifactPartNumberPrefix;
   }

   @JsonProperty("webPartNumberPrefix")
   public void setWebPartNumberPrefix(final String webPartNumberPrefix) {
      this.webPartNumberPrefix = webPartNumberPrefix;
   }

   @JsonProperty("sailPartNumberPrefix")
   public void setSailPartNumberPrefix(final String sailPartNumberPrefix) {
      this.sailPartNumberPrefix = sailPartNumberPrefix;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TemplatePanelAssemblyConfig)) {
         return false;
      }

      TemplatePanelAssemblyConfig other = (TemplatePanelAssemblyConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$structureClassificationId = this.getStructureClassificationId();
         Object other$structureClassificationId = other.getStructureClassificationId();
         if (this$structureClassificationId == null
            ? other$structureClassificationId == null
            : this$structureClassificationId.equals(other$structureClassificationId)) {
            Object this$artifactPartNumberPrefix = this.getArtifactPartNumberPrefix();
            Object other$artifactPartNumberPrefix = other.getArtifactPartNumberPrefix();
            if (this$artifactPartNumberPrefix == null
               ? other$artifactPartNumberPrefix == null
               : this$artifactPartNumberPrefix.equals(other$artifactPartNumberPrefix)) {
               Object this$webPartNumberPrefix = this.getWebPartNumberPrefix();
               Object other$webPartNumberPrefix = other.getWebPartNumberPrefix();
               if (this$webPartNumberPrefix == null ? other$webPartNumberPrefix == null : this$webPartNumberPrefix.equals(other$webPartNumberPrefix)) {
                  Object this$sailPartNumberPrefix = this.getSailPartNumberPrefix();
                  Object other$sailPartNumberPrefix = other.getSailPartNumberPrefix();
                  return this$sailPartNumberPrefix == null ? other$sailPartNumberPrefix == null : this$sailPartNumberPrefix.equals(other$sailPartNumberPrefix);
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
      return other instanceof TemplatePanelAssemblyConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $structureClassificationId = this.getStructureClassificationId();
      result = result * 59 + ($structureClassificationId == null ? 43 : $structureClassificationId.hashCode());
      Object $artifactPartNumberPrefix = this.getArtifactPartNumberPrefix();
      result = result * 59 + ($artifactPartNumberPrefix == null ? 43 : $artifactPartNumberPrefix.hashCode());
      Object $webPartNumberPrefix = this.getWebPartNumberPrefix();
      result = result * 59 + ($webPartNumberPrefix == null ? 43 : $webPartNumberPrefix.hashCode());
      Object $sailPartNumberPrefix = this.getSailPartNumberPrefix();
      return result * 59 + ($sailPartNumberPrefix == null ? 43 : $sailPartNumberPrefix.hashCode());
   }

   @Override
   public String toString() {
      return "TemplatePanelAssemblyConfig(id="
         + this.getId()
         + ", structureClassificationId="
         + this.getStructureClassificationId()
         + ", artifactPartNumberPrefix="
         + this.getArtifactPartNumberPrefix()
         + ", webPartNumberPrefix="
         + this.getWebPartNumberPrefix()
         + ", sailPartNumberPrefix="
         + this.getSailPartNumberPrefix()
         + ")";
   }

   public static class TemplatePanelAssemblyConfigBuilder {
      private Long id;
      private Long structureClassificationId;
      private String artifactPartNumberPrefix;
      private String webPartNumberPrefix;
      private String sailPartNumberPrefix;

      TemplatePanelAssemblyConfigBuilder() {
      }

      public TemplatePanelAssemblyConfig.TemplatePanelAssemblyConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("structureClassificationId")
      public TemplatePanelAssemblyConfig.TemplatePanelAssemblyConfigBuilder structureClassificationId(final Long structureClassificationId) {
         this.structureClassificationId = structureClassificationId;
         return this;
      }

      @JsonProperty("artifactPartNumberPrefix")
      public TemplatePanelAssemblyConfig.TemplatePanelAssemblyConfigBuilder artifactPartNumberPrefix(final String artifactPartNumberPrefix) {
         this.artifactPartNumberPrefix = artifactPartNumberPrefix;
         return this;
      }

      @JsonProperty("webPartNumberPrefix")
      public TemplatePanelAssemblyConfig.TemplatePanelAssemblyConfigBuilder webPartNumberPrefix(final String webPartNumberPrefix) {
         this.webPartNumberPrefix = webPartNumberPrefix;
         return this;
      }

      @JsonProperty("sailPartNumberPrefix")
      public TemplatePanelAssemblyConfig.TemplatePanelAssemblyConfigBuilder sailPartNumberPrefix(final String sailPartNumberPrefix) {
         this.sailPartNumberPrefix = sailPartNumberPrefix;
         return this;
      }

      public TemplatePanelAssemblyConfig build() {
         return new TemplatePanelAssemblyConfig(
            this.id, this.structureClassificationId, this.artifactPartNumberPrefix, this.webPartNumberPrefix, this.sailPartNumberPrefix
         );
      }

      @Override
      public String toString() {
         return "TemplatePanelAssemblyConfig.TemplatePanelAssemblyConfigBuilder(id="
            + this.id
            + ", structureClassificationId="
            + this.structureClassificationId
            + ", artifactPartNumberPrefix="
            + this.artifactPartNumberPrefix
            + ", webPartNumberPrefix="
            + this.webPartNumberPrefix
            + ", sailPartNumberPrefix="
            + this.sailPartNumberPrefix
            + ")";
      }
   }
}
