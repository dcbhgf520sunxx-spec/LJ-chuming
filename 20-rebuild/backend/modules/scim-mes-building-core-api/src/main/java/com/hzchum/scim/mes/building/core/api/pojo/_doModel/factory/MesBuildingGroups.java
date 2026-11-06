package com.hzchum.scim.mes.building.core.api.pojo._doModel.factory;

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

@ApiModel(value = "MesBuildingGroups对象", description = "生产组 ")
@Entity
@TableName("mes_building_groups")
@Table(name = "mes_building_groups")
public class MesBuildingGroups extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "生产组名", notes = "生产组名")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '生产组名'", nullable = false)
   private String name;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11)  COMMENT '排序'", nullable = true)
   private Integer sort;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'", nullable = false)
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = false)
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'", nullable = false)
   private Long productionLineId;
   @ApiModelProperty(name = "userId", value = "用户id", notes = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '用户id'", nullable = false)
   private Long userId;

   public static MesBuildingGroups.MesBuildingGroupsBuilder builder() {
      return new MesBuildingGroups.MesBuildingGroupsBuilder();
   }

   public MesBuildingGroups() {
   }

   public MesBuildingGroups(
      final Long id, final String name, final Integer sort, final Long factoryId, final Long workshopId, final Long productionLineId, final Long userId
   ) {
      this.id = id;
      this.name = name;
      this.sort = sort;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public MesBuildingGroups setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingGroups setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("sort")
   public MesBuildingGroups setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingGroups setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingGroups setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingGroups setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingGroups setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingGroups(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingGroups)) {
         return false;
      }

      MesBuildingGroups other = (MesBuildingGroups)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$factoryId = this.getFactoryId();
            Object other$factoryId = other.getFactoryId();
            if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
               Object this$workshopId = this.getWorkshopId();
               Object other$workshopId = other.getWorkshopId();
               if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                  Object this$productionLineId = this.getProductionLineId();
                  Object other$productionLineId = other.getProductionLineId();
                  if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingGroups;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class MesBuildingGroupsBuilder {
      private Long id;
      private String name;
      private Integer sort;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long userId;

      MesBuildingGroupsBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingGroups.MesBuildingGroupsBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingGroups.MesBuildingGroupsBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingGroups.MesBuildingGroupsBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingGroups.MesBuildingGroupsBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingGroups.MesBuildingGroupsBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingGroups.MesBuildingGroupsBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingGroups.MesBuildingGroupsBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingGroups build() {
         return new MesBuildingGroups(this.id, this.name, this.sort, this.factoryId, this.workshopId, this.productionLineId, this.userId);
      }

      @Override
      public String toString() {
         return "MesBuildingGroups.MesBuildingGroupsBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
