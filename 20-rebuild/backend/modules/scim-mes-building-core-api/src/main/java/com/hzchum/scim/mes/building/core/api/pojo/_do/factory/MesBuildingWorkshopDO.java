package com.hzchum.scim.mes.building.core.api.pojo._do.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingWorkshopDTO对象", description = "")
public class MesBuildingWorkshopDO extends BaseEntity<Long> {
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "车间名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "sort", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "userId", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "boolEnabledEnum", notes = "禁用状态 启用状态 [0 禁用, 1 启用]")
   @JsonProperty("boolEnabledEnum")
   @JSONField(name = "boolEnabledEnum")
   private Boolean boolEnabledEnum;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "remark", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "productionLineList", notes = "生产线列表", value = "生产线列表")
   @JsonProperty("productionLineList")
   @JSONField(name = "productionLineList")
   @JsonInclude(Include.NON_NULL)
   private List<MesBuildingProductionLineDO> productionLineList;

   public static MesBuildingWorkshopDO.MesBuildingWorkshopDOBuilder builder() {
      return new MesBuildingWorkshopDO.MesBuildingWorkshopDOBuilder();
   }

   public MesBuildingWorkshopDO(
      final Long id,
      final String name,
      final Integer sort,
      final Long userId,
      final Boolean boolEnabledEnum,
      final Long factoryId,
      final String remark,
      final List<MesBuildingProductionLineDO> productionLineList
   ) {
      this.id = id;
      this.name = name;
      this.sort = sort;
      this.userId = userId;
      this.boolEnabledEnum = boolEnabledEnum;
      this.factoryId = factoryId;
      this.remark = remark;
      this.productionLineList = productionLineList;
   }

   public MesBuildingWorkshopDO() {
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

   public Long getUserId() {
      return this.userId;
   }

   public Boolean getBoolEnabledEnum() {
      return this.boolEnabledEnum;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<MesBuildingProductionLineDO> getProductionLineList() {
      return this.productionLineList;
   }

   @JsonProperty("id")
   public MesBuildingWorkshopDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingWorkshopDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("sort")
   public MesBuildingWorkshopDO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingWorkshopDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public MesBuildingWorkshopDO setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingWorkshopDO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingWorkshopDO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("productionLineList")
   public MesBuildingWorkshopDO setProductionLineList(final List<MesBuildingProductionLineDO> productionLineList) {
      this.productionLineList = productionLineList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingWorkshopDO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", userId="
         + this.getUserId()
         + ", boolEnabledEnum="
         + this.getBoolEnabledEnum()
         + ", factoryId="
         + this.getFactoryId()
         + ", remark="
         + this.getRemark()
         + ", productionLineList="
         + this.getProductionLineList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWorkshopDO)) {
         return false;
      }

      MesBuildingWorkshopDO other = (MesBuildingWorkshopDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$boolEnabledEnum = this.getBoolEnabledEnum();
               Object other$boolEnabledEnum = other.getBoolEnabledEnum();
               if (this$boolEnabledEnum == null ? other$boolEnabledEnum == null : this$boolEnabledEnum.equals(other$boolEnabledEnum)) {
                  Object this$factoryId = this.getFactoryId();
                  Object other$factoryId = other.getFactoryId();
                  if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$remark = this.getRemark();
                        Object other$remark = other.getRemark();
                        if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                           Object this$productionLineList = this.getProductionLineList();
                           Object other$productionLineList = other.getProductionLineList();
                           return this$productionLineList == null ? other$productionLineList == null : this$productionLineList.equals(other$productionLineList);
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
      return other instanceof MesBuildingWorkshopDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      result = result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $productionLineList = this.getProductionLineList();
      return result * 59 + ($productionLineList == null ? 43 : $productionLineList.hashCode());
   }

   public static class MesBuildingWorkshopDOBuilder {
      private Long id;
      private String name;
      private Integer sort;
      private Long userId;
      private Boolean boolEnabledEnum;
      private Long factoryId;
      private String remark;
      private List<MesBuildingProductionLineDO> productionLineList;

      MesBuildingWorkshopDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingWorkshopDO.MesBuildingWorkshopDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingWorkshopDO.MesBuildingWorkshopDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingWorkshopDO.MesBuildingWorkshopDOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingWorkshopDO.MesBuildingWorkshopDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public MesBuildingWorkshopDO.MesBuildingWorkshopDOBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingWorkshopDO.MesBuildingWorkshopDOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingWorkshopDO.MesBuildingWorkshopDOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("productionLineList")
      public MesBuildingWorkshopDO.MesBuildingWorkshopDOBuilder productionLineList(final List<MesBuildingProductionLineDO> productionLineList) {
         this.productionLineList = productionLineList;
         return this;
      }

      public MesBuildingWorkshopDO build() {
         return new MesBuildingWorkshopDO(
            this.id, this.name, this.sort, this.userId, this.boolEnabledEnum, this.factoryId, this.remark, this.productionLineList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingWorkshopDO.MesBuildingWorkshopDOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ", userId="
            + this.userId
            + ", boolEnabledEnum="
            + this.boolEnabledEnum
            + ", factoryId="
            + this.factoryId
            + ", remark="
            + this.remark
            + ", productionLineList="
            + this.productionLineList
            + ")";
      }
   }
}
