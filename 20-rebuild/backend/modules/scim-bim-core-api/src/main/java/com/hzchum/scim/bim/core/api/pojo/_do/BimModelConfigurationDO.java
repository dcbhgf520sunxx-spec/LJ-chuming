package com.hzchum.scim.bim.core.api.pojo._do;

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

@ApiModel(value = "BimModelConfiguration对象", description = "bim导入模式")
@Entity
@TableName("bim_model_configuration")
@Table(name = "bim_model_configuration")
public class BimModelConfigurationDO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "importMode", value = "导入模式")
   @JsonProperty("importMode")
   @JSONField(name = "importMode")
   @TableField("import_mode")
   @Column(name = "import_mode", columnDefinition = "int(2)  default'1' COMMENT '导入模式'", nullable = false)
   private Integer importMode;
   @ApiModelProperty(name = "edition", value = "Tekla版本")
   @JsonProperty("edition")
   @JSONField(name = "edition")
   @TableField("edition")
   @Column(name = "edition", columnDefinition = "int(2)  COMMENT 'Tekla版本'", nullable = false)
   private Integer edition;

   public static BimModelConfigurationDO.BimModelConfigurationDOBuilder builder() {
      return new BimModelConfigurationDO.BimModelConfigurationDOBuilder();
   }

   public BimModelConfigurationDO() {
   }

   public BimModelConfigurationDO(final Long id, final Long projectId, final Long monomerId, final Integer importMode, final Integer edition) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.importMode = importMode;
      this.edition = edition;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getImportMode() {
      return this.importMode;
   }

   public Integer getEdition() {
      return this.edition;
   }

   @JsonProperty("id")
   public BimModelConfigurationDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public BimModelConfigurationDO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public BimModelConfigurationDO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("importMode")
   public BimModelConfigurationDO setImportMode(final Integer importMode) {
      this.importMode = importMode;
      return this;
   }

   @JsonProperty("edition")
   public BimModelConfigurationDO setEdition(final Integer edition) {
      this.edition = edition;
      return this;
   }

   @Override
   public String toString() {
      return "BimModelConfigurationDO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", importMode="
         + this.getImportMode()
         + ", edition="
         + this.getEdition()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BimModelConfigurationDO)) {
         return false;
      }

      BimModelConfigurationDO other = (BimModelConfigurationDO)o;
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
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$importMode = this.getImportMode();
               Object other$importMode = other.getImportMode();
               if (this$importMode == null ? other$importMode == null : this$importMode.equals(other$importMode)) {
                  Object this$edition = this.getEdition();
                  Object other$edition = other.getEdition();
                  return this$edition == null ? other$edition == null : this$edition.equals(other$edition);
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
      return other instanceof BimModelConfigurationDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $importMode = this.getImportMode();
      result = result * 59 + ($importMode == null ? 43 : $importMode.hashCode());
      Object $edition = this.getEdition();
      return result * 59 + ($edition == null ? 43 : $edition.hashCode());
   }

   public static class BimModelConfigurationDOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Integer importMode;
      private Integer edition;

      BimModelConfigurationDOBuilder() {
      }

      @JsonProperty("id")
      public BimModelConfigurationDO.BimModelConfigurationDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public BimModelConfigurationDO.BimModelConfigurationDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public BimModelConfigurationDO.BimModelConfigurationDOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("importMode")
      public BimModelConfigurationDO.BimModelConfigurationDOBuilder importMode(final Integer importMode) {
         this.importMode = importMode;
         return this;
      }

      @JsonProperty("edition")
      public BimModelConfigurationDO.BimModelConfigurationDOBuilder edition(final Integer edition) {
         this.edition = edition;
         return this;
      }

      public BimModelConfigurationDO build() {
         return new BimModelConfigurationDO(this.id, this.projectId, this.monomerId, this.importMode, this.edition);
      }

      @Override
      public String toString() {
         return "BimModelConfigurationDO.BimModelConfigurationDOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", importMode="
            + this.importMode
            + ", edition="
            + this.edition
            + ")";
      }
   }
}
