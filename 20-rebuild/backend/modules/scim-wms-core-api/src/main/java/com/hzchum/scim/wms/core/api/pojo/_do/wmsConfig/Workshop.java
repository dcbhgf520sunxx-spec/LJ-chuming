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

@ApiModel(value = "Workshop对象", description = "")
@Entity
@TableName("wms_workshop")
@Table(name = "wms_workshop")
public class Workshop extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "车间名", notes = "车间名")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '车间名'", nullable = false)
   private String name;
   @ApiModelProperty(name = "workshopId", value = "建钢车间ID", notes = "建钢车间ID")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "int(11) COMMENT '建钢车间ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "factoryId", value = "所属工厂ID", notes = "所属工厂ID")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint  COMMENT '项目ID'", nullable = true)
   private Long factoryId;
   @ApiModelProperty(name = "workshopUser", value = "仓库负责人", notes = "仓库负责人")
   @JsonProperty("workshopUser")
   @JSONField(name = "workshopUser")
   @TableField("workshop_user")
   @Column(name = "workshop_user", columnDefinition = "varchar(255)  COMMENT '仓库负责人'", nullable = true)
   private String workshopUser;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int COMMENT '排序'", nullable = true)
   private Integer sort;
   @ApiModelProperty(name = "enabled", value = "使用状态[0-false ,1-true],创建时默认启用", notes = "使用状态[0-false ,1-true],创建时默认启用")
   @JsonProperty("enabled")
   @JSONField(name = "enabled")
   @TableField("enabled")
   @Column(name = "enabled", columnDefinition = "tinyint(1) default '1' COMMENT '使用状态[0-false ,1-true],创建时默认启用'", nullable = true)
   private Boolean enabled;
   @ApiModelProperty(name = "mesWorkshopIds", value = "关联mes车间id集", notes = "关联mes车间id集")
   @JsonProperty("mesWorkshopIds")
   @JSONField(name = "mesWorkshopIds")
   @TableField("mes_workshop_ids")
   @Column(name = "mes_workshop_ids", columnDefinition = "varchar(255)  COMMENT '关联mes车间id集'", nullable = true)
   private String mesWorkshopIds;

   public static Workshop.WorkshopBuilder builder() {
      return new Workshop.WorkshopBuilder();
   }

   public Workshop() {
   }

   public Workshop(
      final Long id,
      final String name,
      final Long workshopId,
      final Long factoryId,
      final String workshopUser,
      final Integer sort,
      final Boolean enabled,
      final String mesWorkshopIds
   ) {
      this.id = id;
      this.name = name;
      this.workshopId = workshopId;
      this.factoryId = factoryId;
      this.workshopUser = workshopUser;
      this.sort = sort;
      this.enabled = enabled;
      this.mesWorkshopIds = mesWorkshopIds;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public String getWorkshopUser() {
      return this.workshopUser;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Boolean getEnabled() {
      return this.enabled;
   }

   public String getMesWorkshopIds() {
      return this.mesWorkshopIds;
   }

   @JsonProperty("id")
   public Workshop setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public Workshop setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("workshopId")
   public Workshop setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("factoryId")
   public Workshop setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopUser")
   public Workshop setWorkshopUser(final String workshopUser) {
      this.workshopUser = workshopUser;
      return this;
   }

   @JsonProperty("sort")
   public Workshop setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("enabled")
   public Workshop setEnabled(final Boolean enabled) {
      this.enabled = enabled;
      return this;
   }

   @JsonProperty("mesWorkshopIds")
   public Workshop setMesWorkshopIds(final String mesWorkshopIds) {
      this.mesWorkshopIds = mesWorkshopIds;
      return this;
   }

   @Override
   public String toString() {
      return "Workshop(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopUser="
         + this.getWorkshopUser()
         + ", sort="
         + this.getSort()
         + ", enabled="
         + this.getEnabled()
         + ", mesWorkshopIds="
         + this.getMesWorkshopIds()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Workshop)) {
         return false;
      }

      Workshop other = (Workshop)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$factoryId = this.getFactoryId();
            Object other$factoryId = other.getFactoryId();
            if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                  Object this$enabled = this.getEnabled();
                  Object other$enabled = other.getEnabled();
                  if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$workshopUser = this.getWorkshopUser();
                        Object other$workshopUser = other.getWorkshopUser();
                        if (this$workshopUser == null ? other$workshopUser == null : this$workshopUser.equals(other$workshopUser)) {
                           Object this$mesWorkshopIds = this.getMesWorkshopIds();
                           Object other$mesWorkshopIds = other.getMesWorkshopIds();
                           return this$mesWorkshopIds == null ? other$mesWorkshopIds == null : this$mesWorkshopIds.equals(other$mesWorkshopIds);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof Workshop;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $workshopUser = this.getWorkshopUser();
      result = result * 59 + ($workshopUser == null ? 43 : $workshopUser.hashCode());
      Object $mesWorkshopIds = this.getMesWorkshopIds();
      return result * 59 + ($mesWorkshopIds == null ? 43 : $mesWorkshopIds.hashCode());
   }

   public static class WorkshopBuilder {
      private Long id;
      private String name;
      private Long workshopId;
      private Long factoryId;
      private String workshopUser;
      private Integer sort;
      private Boolean enabled;
      private String mesWorkshopIds;

      WorkshopBuilder() {
      }

      @JsonProperty("id")
      public Workshop.WorkshopBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public Workshop.WorkshopBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("workshopId")
      public Workshop.WorkshopBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("factoryId")
      public Workshop.WorkshopBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopUser")
      public Workshop.WorkshopBuilder workshopUser(final String workshopUser) {
         this.workshopUser = workshopUser;
         return this;
      }

      @JsonProperty("sort")
      public Workshop.WorkshopBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("enabled")
      public Workshop.WorkshopBuilder enabled(final Boolean enabled) {
         this.enabled = enabled;
         return this;
      }

      @JsonProperty("mesWorkshopIds")
      public Workshop.WorkshopBuilder mesWorkshopIds(final String mesWorkshopIds) {
         this.mesWorkshopIds = mesWorkshopIds;
         return this;
      }

      public Workshop build() {
         return new Workshop(this.id, this.name, this.workshopId, this.factoryId, this.workshopUser, this.sort, this.enabled, this.mesWorkshopIds);
      }

      @Override
      public String toString() {
         return "Workshop.WorkshopBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", workshopId="
            + this.workshopId
            + ", factoryId="
            + this.factoryId
            + ", workshopUser="
            + this.workshopUser
            + ", sort="
            + this.sort
            + ", enabled="
            + this.enabled
            + ", mesWorkshopIds="
            + this.mesWorkshopIds
            + ")";
      }
   }
}
