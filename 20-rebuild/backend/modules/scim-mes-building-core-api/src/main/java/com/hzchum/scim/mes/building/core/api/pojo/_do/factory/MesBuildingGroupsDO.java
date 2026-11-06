package com.hzchum.scim.mes.building.core.api.pojo._do.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingGroupsDO", description = "生产组 ")
public class MesBuildingGroupsDO extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "teamIds", value = "所包含班组ids", notes = "所包含班组ids")
   @JsonProperty("teamIds")
   @JSONField(name = "teamIds")
   @JsonInclude(Include.NON_NULL)
   private List<Long> teamIds;
   @ApiModelProperty(name = "inspectionTeamIds", value = "所包含质检班组ids", notes = "所包含质检班组ids")
   @JsonProperty("inspectionTeamIds")
   @JSONField(name = "inspectionTeamIds")
   @JsonInclude(Include.NON_NULL)
   private List<Long> inspectionTeamIds;

   public static MesBuildingGroupsDO.MesBuildingGroupsDOBuilder builder() {
      return new MesBuildingGroupsDO.MesBuildingGroupsDOBuilder();
   }

   public MesBuildingGroupsDO() {
   }

   public MesBuildingGroupsDO(
      final Long id,
      final String name,
      final Integer sort,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long userId,
      final List<Long> teamIds,
      final List<Long> inspectionTeamIds
   ) {
      this.id = id;
      this.name = name;
      this.sort = sort;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.userId = userId;
      this.teamIds = teamIds;
      this.inspectionTeamIds = inspectionTeamIds;
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

   public List<Long> getTeamIds() {
      return this.teamIds;
   }

   public List<Long> getInspectionTeamIds() {
      return this.inspectionTeamIds;
   }

   @JsonProperty("id")
   public MesBuildingGroupsDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingGroupsDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("sort")
   public MesBuildingGroupsDO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingGroupsDO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingGroupsDO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingGroupsDO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingGroupsDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("teamIds")
   public MesBuildingGroupsDO setTeamIds(final List<Long> teamIds) {
      this.teamIds = teamIds;
      return this;
   }

   @JsonProperty("inspectionTeamIds")
   public MesBuildingGroupsDO setInspectionTeamIds(final List<Long> inspectionTeamIds) {
      this.inspectionTeamIds = inspectionTeamIds;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingGroupsDO(id="
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
         + ", teamIds="
         + this.getTeamIds()
         + ", inspectionTeamIds="
         + this.getInspectionTeamIds()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingGroupsDO)) {
         return false;
      }

      MesBuildingGroupsDO other = (MesBuildingGroupsDO)o;
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
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$teamIds = this.getTeamIds();
                           Object other$teamIds = other.getTeamIds();
                           if (this$teamIds == null ? other$teamIds == null : this$teamIds.equals(other$teamIds)) {
                              Object this$inspectionTeamIds = this.getInspectionTeamIds();
                              Object other$inspectionTeamIds = other.getInspectionTeamIds();
                              return this$inspectionTeamIds == null ? other$inspectionTeamIds == null : this$inspectionTeamIds.equals(other$inspectionTeamIds);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingGroupsDO;
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
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $teamIds = this.getTeamIds();
      result = result * 59 + ($teamIds == null ? 43 : $teamIds.hashCode());
      Object $inspectionTeamIds = this.getInspectionTeamIds();
      return result * 59 + ($inspectionTeamIds == null ? 43 : $inspectionTeamIds.hashCode());
   }

   public static class MesBuildingGroupsDOBuilder {
      private Long id;
      private String name;
      private Integer sort;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long userId;
      private List<Long> teamIds;
      private List<Long> inspectionTeamIds;

      MesBuildingGroupsDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingGroupsDO.MesBuildingGroupsDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingGroupsDO.MesBuildingGroupsDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingGroupsDO.MesBuildingGroupsDOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingGroupsDO.MesBuildingGroupsDOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingGroupsDO.MesBuildingGroupsDOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingGroupsDO.MesBuildingGroupsDOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingGroupsDO.MesBuildingGroupsDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("teamIds")
      public MesBuildingGroupsDO.MesBuildingGroupsDOBuilder teamIds(final List<Long> teamIds) {
         this.teamIds = teamIds;
         return this;
      }

      @JsonProperty("inspectionTeamIds")
      public MesBuildingGroupsDO.MesBuildingGroupsDOBuilder inspectionTeamIds(final List<Long> inspectionTeamIds) {
         this.inspectionTeamIds = inspectionTeamIds;
         return this;
      }

      public MesBuildingGroupsDO build() {
         return new MesBuildingGroupsDO(
            this.id, this.name, this.sort, this.factoryId, this.workshopId, this.productionLineId, this.userId, this.teamIds, this.inspectionTeamIds
         );
      }

      @Override
      public String toString() {
         return "MesBuildingGroupsDO.MesBuildingGroupsDOBuilder(id="
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
            + ", teamIds="
            + this.teamIds
            + ", inspectionTeamIds="
            + this.inspectionTeamIds
            + ")";
      }
   }
}
