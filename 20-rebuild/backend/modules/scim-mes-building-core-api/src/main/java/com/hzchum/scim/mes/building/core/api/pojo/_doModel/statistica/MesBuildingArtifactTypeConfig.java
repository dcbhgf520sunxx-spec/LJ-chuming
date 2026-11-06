package com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica;

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

@ApiModel(value = "MesBuildingArtifactTypeConfig对象", description = "构件种类配置")
@Entity
@TableName("mes_building_artifact_type_config")
@Table(name = "mes_building_artifact_type_config")
public class MesBuildingArtifactTypeConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "typeName", value = "构件种类名称")
   @JsonProperty("typeName")
   @JSONField(name = "typeName")
   @TableField("type_name")
   @Column(name = "type_name", columnDefinition = "varchar(64)  COMMENT '构件种类名称'", nullable = false)
   private String typeName;
   @ApiModelProperty(name = "inventoryName", value = "清单构件名称")
   @JsonProperty("inventoryName")
   @JSONField(name = "inventoryName")
   @TableField("inventory_name")
   @Column(name = "inventory_name", columnDefinition = "varchar(256)  COMMENT '清单构件名称'")
   private String inventoryName;

   public static MesBuildingArtifactTypeConfig.MesBuildingArtifactTypeConfigBuilder builder() {
      return new MesBuildingArtifactTypeConfig.MesBuildingArtifactTypeConfigBuilder();
   }

   public MesBuildingArtifactTypeConfig() {
   }

   public MesBuildingArtifactTypeConfig(final Long id, final String typeName, final String inventoryName) {
      this.id = id;
      this.typeName = typeName;
      this.inventoryName = inventoryName;
   }

   public Long getId() {
      return this.id;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public String getInventoryName() {
      return this.inventoryName;
   }

   @JsonProperty("id")
   public MesBuildingArtifactTypeConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("typeName")
   public MesBuildingArtifactTypeConfig setTypeName(final String typeName) {
      this.typeName = typeName;
      return this;
   }

   @JsonProperty("inventoryName")
   public MesBuildingArtifactTypeConfig setInventoryName(final String inventoryName) {
      this.inventoryName = inventoryName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingArtifactTypeConfig(id=" + this.getId() + ", typeName=" + this.getTypeName() + ", inventoryName=" + this.getInventoryName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingArtifactTypeConfig)) {
         return false;
      }

      MesBuildingArtifactTypeConfig other = (MesBuildingArtifactTypeConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$typeName = this.getTypeName();
         Object other$typeName = other.getTypeName();
         if (this$typeName == null ? other$typeName == null : this$typeName.equals(other$typeName)) {
            Object this$inventoryName = this.getInventoryName();
            Object other$inventoryName = other.getInventoryName();
            return this$inventoryName == null ? other$inventoryName == null : this$inventoryName.equals(other$inventoryName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingArtifactTypeConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $inventoryName = this.getInventoryName();
      return result * 59 + ($inventoryName == null ? 43 : $inventoryName.hashCode());
   }

   public static class MesBuildingArtifactTypeConfigBuilder {
      private Long id;
      private String typeName;
      private String inventoryName;

      MesBuildingArtifactTypeConfigBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingArtifactTypeConfig.MesBuildingArtifactTypeConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("typeName")
      public MesBuildingArtifactTypeConfig.MesBuildingArtifactTypeConfigBuilder typeName(final String typeName) {
         this.typeName = typeName;
         return this;
      }

      @JsonProperty("inventoryName")
      public MesBuildingArtifactTypeConfig.MesBuildingArtifactTypeConfigBuilder inventoryName(final String inventoryName) {
         this.inventoryName = inventoryName;
         return this;
      }

      public MesBuildingArtifactTypeConfig build() {
         return new MesBuildingArtifactTypeConfig(this.id, this.typeName, this.inventoryName);
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactTypeConfig.MesBuildingArtifactTypeConfigBuilder(id="
            + this.id
            + ", typeName="
            + this.typeName
            + ", inventoryName="
            + this.inventoryName
            + ")";
      }
   }
}
