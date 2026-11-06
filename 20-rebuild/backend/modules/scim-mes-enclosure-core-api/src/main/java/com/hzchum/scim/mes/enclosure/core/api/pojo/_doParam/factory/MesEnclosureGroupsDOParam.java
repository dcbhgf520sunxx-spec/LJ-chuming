package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesEnclosureGroupsDOParam", description = "生产组 ")
public class MesEnclosureGroupsDOParam extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "type", notes = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;

   public static MesEnclosureGroupsDOParam.MesEnclosureGroupsDOParamBuilder builder() {
      return new MesEnclosureGroupsDOParam.MesEnclosureGroupsDOParamBuilder();
   }

   public MesEnclosureGroupsDOParam() {
   }

   public MesEnclosureGroupsDOParam(
      final Long id,
      final String name,
      final Integer sort,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long userId,
      final Integer type
   ) {
      this.id = id;
      this.name = name;
      this.sort = sort;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.userId = userId;
      this.type = type;
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

   public Integer getType() {
      return this.type;
   }

   @JsonProperty("id")
   public MesEnclosureGroupsDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesEnclosureGroupsDOParam setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("sort")
   public MesEnclosureGroupsDOParam setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureGroupsDOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesEnclosureGroupsDOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureGroupsDOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureGroupsDOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("type")
   public MesEnclosureGroupsDOParam setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureGroupsDOParam(id="
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
         + ", type="
         + this.getType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureGroupsDOParam)) {
         return false;
      }

      MesEnclosureGroupsDOParam other = (MesEnclosureGroupsDOParam)o;
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
                        Object this$type = this.getType();
                        Object other$type = other.getType();
                        if (this$type == null ? other$type == null : this$type.equals(other$type)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureGroupsDOParam;
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
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class MesEnclosureGroupsDOParamBuilder {
      private Long id;
      private String name;
      private Integer sort;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long userId;
      private Integer type;

      MesEnclosureGroupsDOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureGroupsDOParam.MesEnclosureGroupsDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesEnclosureGroupsDOParam.MesEnclosureGroupsDOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("sort")
      public MesEnclosureGroupsDOParam.MesEnclosureGroupsDOParamBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureGroupsDOParam.MesEnclosureGroupsDOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesEnclosureGroupsDOParam.MesEnclosureGroupsDOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureGroupsDOParam.MesEnclosureGroupsDOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureGroupsDOParam.MesEnclosureGroupsDOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("type")
      public MesEnclosureGroupsDOParam.MesEnclosureGroupsDOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public MesEnclosureGroupsDOParam build() {
         return new MesEnclosureGroupsDOParam(this.id, this.name, this.sort, this.factoryId, this.workshopId, this.productionLineId, this.userId, this.type);
      }

      @Override
      public String toString() {
         return "MesEnclosureGroupsDOParam.MesEnclosureGroupsDOParamBuilder(id="
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
            + ", type="
            + this.type
            + ")";
      }
   }
}
