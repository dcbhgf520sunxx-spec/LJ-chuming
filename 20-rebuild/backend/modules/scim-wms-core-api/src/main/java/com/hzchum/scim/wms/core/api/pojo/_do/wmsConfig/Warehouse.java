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

@Entity
@ApiModel(value = "Warehouse对象", description = "仓库位置信息 ")
@TableName("wms_warehouse")
@Table(name = "wms_warehouse")
public class Warehouse extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(128)  COMMENT '名称'", nullable = true)
   private String name;
   @ApiModelProperty(name = "materialType", value = "可存储材料类型位运算", notes = "可存储材料类型位运算")
   @JsonProperty("materialType")
   @JSONField(name = "materialType")
   @TableField("material_type")
   @Column(name = "material_type", columnDefinition = "int  COMMENT '可存储材料类型位运算'", nullable = false)
   private Integer materialType;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int  COMMENT '排序'", nullable = true)
   private Integer sort;
   @ApiModelProperty(name = "enabled", value = "使用状态[0-false ,1-true],创建时默认启用", notes = "使用状态[0-false ,1-true],创建时默认启用")
   @JsonProperty("enabled")
   @JSONField(name = "enabled")
   @TableField("enabled")
   @Column(name = "enabled", columnDefinition = "tinyint(1) default '1' COMMENT '使用状态[0-false ,1-true],创建时默认启用'", nullable = true)
   private Boolean enabled;
   @ApiModelProperty(name = "workshopId", value = "车间ID", notes = "车间ID")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT '车间ID'", nullable = true)
   private Long workshopId;

   public static Warehouse.WarehouseBuilder builder() {
      return new Warehouse.WarehouseBuilder();
   }

   public Warehouse() {
   }

   public Warehouse(final Long id, final String name, final Integer materialType, final Integer sort, final Boolean enabled, final Long workshopId) {
      this.id = id;
      this.name = name;
      this.materialType = materialType;
      this.sort = sort;
      this.enabled = enabled;
      this.workshopId = workshopId;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getMaterialType() {
      return this.materialType;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Boolean getEnabled() {
      return this.enabled;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   @JsonProperty("id")
   public Warehouse setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public Warehouse setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("materialType")
   public Warehouse setMaterialType(final Integer materialType) {
      this.materialType = materialType;
      return this;
   }

   @JsonProperty("sort")
   public Warehouse setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("enabled")
   public Warehouse setEnabled(final Boolean enabled) {
      this.enabled = enabled;
      return this;
   }

   @JsonProperty("workshopId")
   public Warehouse setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @Override
   public String toString() {
      return "Warehouse(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", materialType="
         + this.getMaterialType()
         + ", sort="
         + this.getSort()
         + ", enabled="
         + this.getEnabled()
         + ", workshopId="
         + this.getWorkshopId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Warehouse)) {
         return false;
      }

      Warehouse other = (Warehouse)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$materialType = this.getMaterialType();
         Object other$materialType = other.getMaterialType();
         if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$enabled = this.getEnabled();
               Object other$enabled = other.getEnabled();
               if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof Warehouse;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class WarehouseBuilder {
      private Long id;
      private String name;
      private Integer materialType;
      private Integer sort;
      private Boolean enabled;
      private Long workshopId;

      WarehouseBuilder() {
      }

      @JsonProperty("id")
      public Warehouse.WarehouseBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public Warehouse.WarehouseBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("materialType")
      public Warehouse.WarehouseBuilder materialType(final Integer materialType) {
         this.materialType = materialType;
         return this;
      }

      @JsonProperty("sort")
      public Warehouse.WarehouseBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("enabled")
      public Warehouse.WarehouseBuilder enabled(final Boolean enabled) {
         this.enabled = enabled;
         return this;
      }

      @JsonProperty("workshopId")
      public Warehouse.WarehouseBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public Warehouse build() {
         return new Warehouse(this.id, this.name, this.materialType, this.sort, this.enabled, this.workshopId);
      }

      @Override
      public String toString() {
         return "Warehouse.WarehouseBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", materialType="
            + this.materialType
            + ", sort="
            + this.sort
            + ", enabled="
            + this.enabled
            + ", workshopId="
            + this.workshopId
            + ")";
      }
   }
}
