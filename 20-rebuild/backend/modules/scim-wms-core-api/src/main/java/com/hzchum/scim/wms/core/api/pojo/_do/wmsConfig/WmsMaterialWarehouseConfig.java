package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

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

@ApiModel(value = "WmsMaterialWarehouseConfig对象", description = "辅材仓库自定义配置")
@Entity
@TableName("wms_material_warehouse_config")
@Table(name = "wms_material_warehouse_config")
@org.hibernate.annotations.Table(appliesTo = "wms_material_warehouse_config")
public class WmsMaterialWarehouseConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(225)  COMMENT '仓库名'", nullable = true)
   private String name;
   @ApiModelProperty(name = "basicClass", value = "基础分类", notes = "基础分类")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int(11)  COMMENT '基础分类'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "classifyIds")
   @JsonProperty("classifyIds")
   @JSONField(name = "classifyIds")
   @TableField("classify_Ids")
   @Column(name = "classify_Ids", columnDefinition = "longtext  COMMENT '自定义仓库包含末级科目id集合'", nullable = true)
   private String classifyIds;

   public static WmsMaterialWarehouseConfig.WmsMaterialWarehouseConfigBuilder builder() {
      return new WmsMaterialWarehouseConfig.WmsMaterialWarehouseConfigBuilder();
   }

   public WmsMaterialWarehouseConfig() {
   }

   public WmsMaterialWarehouseConfig(final Long id, final String name, final Integer basicClass, final String classifyIds) {
      this.id = id;
      this.name = name;
      this.basicClass = basicClass;
      this.classifyIds = classifyIds;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getClassifyIds() {
      return this.classifyIds;
   }

   @JsonProperty("id")
   public WmsMaterialWarehouseConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsMaterialWarehouseConfig setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("basicClass")
   public WmsMaterialWarehouseConfig setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyIds")
   public WmsMaterialWarehouseConfig setClassifyIds(final String classifyIds) {
      this.classifyIds = classifyIds;
      return this;
   }

   @Override
   public String toString() {
      return "WmsMaterialWarehouseConfig(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyIds="
         + this.getClassifyIds()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsMaterialWarehouseConfig)) {
         return false;
      }

      WmsMaterialWarehouseConfig other = (WmsMaterialWarehouseConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$classifyIds = this.getClassifyIds();
               Object other$classifyIds = other.getClassifyIds();
               return this$classifyIds == null ? other$classifyIds == null : this$classifyIds.equals(other$classifyIds);
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
      return other instanceof WmsMaterialWarehouseConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $classifyIds = this.getClassifyIds();
      return result * 59 + ($classifyIds == null ? 43 : $classifyIds.hashCode());
   }

   public static class WmsMaterialWarehouseConfigBuilder {
      private Long id;
      private String name;
      private Integer basicClass;
      private String classifyIds;

      WmsMaterialWarehouseConfigBuilder() {
      }

      @JsonProperty("id")
      public WmsMaterialWarehouseConfig.WmsMaterialWarehouseConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsMaterialWarehouseConfig.WmsMaterialWarehouseConfigBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("basicClass")
      public WmsMaterialWarehouseConfig.WmsMaterialWarehouseConfigBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyIds")
      public WmsMaterialWarehouseConfig.WmsMaterialWarehouseConfigBuilder classifyIds(final String classifyIds) {
         this.classifyIds = classifyIds;
         return this;
      }

      public WmsMaterialWarehouseConfig build() {
         return new WmsMaterialWarehouseConfig(this.id, this.name, this.basicClass, this.classifyIds);
      }

      @Override
      public String toString() {
         return "WmsMaterialWarehouseConfig.WmsMaterialWarehouseConfigBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", basicClass="
            + this.basicClass
            + ", classifyIds="
            + this.classifyIds
            + ")";
      }
   }
}
