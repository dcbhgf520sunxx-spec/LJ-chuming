package com.hzchum.scim.mes.building.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingGroupsDO", description = "生产组 ")
public class GroupsCurrencyDO extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", value = "生产组名", notes = "生产组名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "userId", value = "用户id", notes = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;

   public static GroupsCurrencyDO.GroupsCurrencyDOBuilder builder() {
      return new GroupsCurrencyDO.GroupsCurrencyDOBuilder();
   }

   public GroupsCurrencyDO() {
   }

   public GroupsCurrencyDO(
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
   public GroupsCurrencyDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public GroupsCurrencyDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("sort")
   public GroupsCurrencyDO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("factoryId")
   public GroupsCurrencyDO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public GroupsCurrencyDO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public GroupsCurrencyDO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("userId")
   public GroupsCurrencyDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "GroupsCurrencyDO(id="
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

      if (!(o instanceof GroupsCurrencyDO)) {
         return false;
      }

      GroupsCurrencyDO other = (GroupsCurrencyDO)o;
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
      return other instanceof GroupsCurrencyDO;
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

   public static class GroupsCurrencyDOBuilder {
      private Long id;
      private String name;
      private Integer sort;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long userId;

      GroupsCurrencyDOBuilder() {
      }

      @JsonProperty("id")
      public GroupsCurrencyDO.GroupsCurrencyDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public GroupsCurrencyDO.GroupsCurrencyDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("sort")
      public GroupsCurrencyDO.GroupsCurrencyDOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("factoryId")
      public GroupsCurrencyDO.GroupsCurrencyDOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public GroupsCurrencyDO.GroupsCurrencyDOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public GroupsCurrencyDO.GroupsCurrencyDOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("userId")
      public GroupsCurrencyDO.GroupsCurrencyDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public GroupsCurrencyDO build() {
         return new GroupsCurrencyDO(this.id, this.name, this.sort, this.factoryId, this.workshopId, this.productionLineId, this.userId);
      }

      @Override
      public String toString() {
         return "GroupsCurrencyDO.GroupsCurrencyDOBuilder(id="
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
