package com.hzchum.scim.mes.building.core.api.pojo._do.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingProductProcessDO对象", description = "")
public class MesBuildingProductProcessDO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "productType", notes = "产品类型 [0 零件,1 构件,2 围护]")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "boolEnabledEnum", notes = "禁用状态 [0 禁用, 1 启用]")
   @JsonProperty("boolEnabledEnum")
   @JSONField(name = "boolEnabledEnum")
   private Boolean boolEnabledEnum;
   @ApiModelProperty(name = "sort", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "userId", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "medBuildingProductProcessLinkList", notes = "总工序下的工序列表")
   @JsonProperty("medBuildingProductProcessLinkList")
   @JSONField(name = "medBuildingProductProcessLinkList")
   private List<MesBuildingProductProcessLinkDO> medBuildingProductProcessLinkList;

   public static MesBuildingProductProcessDO.MesBuildingProductProcessDOBuilder builder() {
      return new MesBuildingProductProcessDO.MesBuildingProductProcessDOBuilder();
   }

   public MesBuildingProductProcessDO() {
   }

   public MesBuildingProductProcessDO(
      final Long id,
      final Integer productType,
      final Boolean boolEnabledEnum,
      final Integer sort,
      final Long userId,
      final List<MesBuildingProductProcessLinkDO> medBuildingProductProcessLinkList
   ) {
      this.id = id;
      this.productType = productType;
      this.boolEnabledEnum = boolEnabledEnum;
      this.sort = sort;
      this.userId = userId;
      this.medBuildingProductProcessLinkList = medBuildingProductProcessLinkList;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Boolean getBoolEnabledEnum() {
      return this.boolEnabledEnum;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Long getUserId() {
      return this.userId;
   }

   public List<MesBuildingProductProcessLinkDO> getMedBuildingProductProcessLinkList() {
      return this.medBuildingProductProcessLinkList;
   }

   @JsonProperty("id")
   public MesBuildingProductProcessDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingProductProcessDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public MesBuildingProductProcessDO setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @JsonProperty("sort")
   public MesBuildingProductProcessDO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProductProcessDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("medBuildingProductProcessLinkList")
   public MesBuildingProductProcessDO setMedBuildingProductProcessLinkList(final List<MesBuildingProductProcessLinkDO> medBuildingProductProcessLinkList) {
      this.medBuildingProductProcessLinkList = medBuildingProductProcessLinkList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductProcessDO(id="
         + this.getId()
         + ", productType="
         + this.getProductType()
         + ", boolEnabledEnum="
         + this.getBoolEnabledEnum()
         + ", sort="
         + this.getSort()
         + ", userId="
         + this.getUserId()
         + ", medBuildingProductProcessLinkList="
         + this.getMedBuildingProductProcessLinkList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductProcessDO)) {
         return false;
      }

      MesBuildingProductProcessDO other = (MesBuildingProductProcessDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$boolEnabledEnum = this.getBoolEnabledEnum();
            Object other$boolEnabledEnum = other.getBoolEnabledEnum();
            if (this$boolEnabledEnum == null ? other$boolEnabledEnum == null : this$boolEnabledEnum.equals(other$boolEnabledEnum)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$medBuildingProductProcessLinkList = this.getMedBuildingProductProcessLinkList();
                     Object other$medBuildingProductProcessLinkList = other.getMedBuildingProductProcessLinkList();
                     return this$medBuildingProductProcessLinkList == null
                        ? other$medBuildingProductProcessLinkList == null
                        : this$medBuildingProductProcessLinkList.equals(other$medBuildingProductProcessLinkList);
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
      return other instanceof MesBuildingProductProcessDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      result = result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $medBuildingProductProcessLinkList = this.getMedBuildingProductProcessLinkList();
      return result * 59 + ($medBuildingProductProcessLinkList == null ? 43 : $medBuildingProductProcessLinkList.hashCode());
   }

   public static class MesBuildingProductProcessDOBuilder {
      private Long id;
      private Integer productType;
      private Boolean boolEnabledEnum;
      private Integer sort;
      private Long userId;
      private List<MesBuildingProductProcessLinkDO> medBuildingProductProcessLinkList;

      MesBuildingProductProcessDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProductProcessDO.MesBuildingProductProcessDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingProductProcessDO.MesBuildingProductProcessDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public MesBuildingProductProcessDO.MesBuildingProductProcessDOBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingProductProcessDO.MesBuildingProductProcessDOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProductProcessDO.MesBuildingProductProcessDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("medBuildingProductProcessLinkList")
      public MesBuildingProductProcessDO.MesBuildingProductProcessDOBuilder medBuildingProductProcessLinkList(
         final List<MesBuildingProductProcessLinkDO> medBuildingProductProcessLinkList
      ) {
         this.medBuildingProductProcessLinkList = medBuildingProductProcessLinkList;
         return this;
      }

      public MesBuildingProductProcessDO build() {
         return new MesBuildingProductProcessDO(this.id, this.productType, this.boolEnabledEnum, this.sort, this.userId, this.medBuildingProductProcessLinkList);
      }

      @Override
      public String toString() {
         return "MesBuildingProductProcessDO.MesBuildingProductProcessDOBuilder(id="
            + this.id
            + ", productType="
            + this.productType
            + ", boolEnabledEnum="
            + this.boolEnabledEnum
            + ", sort="
            + this.sort
            + ", userId="
            + this.userId
            + ", medBuildingProductProcessLinkList="
            + this.medBuildingProductProcessLinkList
            + ")";
      }
   }
}
