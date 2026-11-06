package com.hzchum.scim.mes.building.core.api.pojo._doParam.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingProductProcessDOParam对象", description = "")
public class MesBuildingProductProcessDOParam extends BaseEntity<Long> {
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

   public static MesBuildingProductProcessDOParam.MesBuildingProductProcessDOParamBuilder builder() {
      return new MesBuildingProductProcessDOParam.MesBuildingProductProcessDOParamBuilder();
   }

   public MesBuildingProductProcessDOParam() {
   }

   public MesBuildingProductProcessDOParam(final Long id, final Integer productType, final Boolean boolEnabledEnum, final Integer sort, final Long userId) {
      this.id = id;
      this.productType = productType;
      this.boolEnabledEnum = boolEnabledEnum;
      this.sort = sort;
      this.userId = userId;
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

   @JsonProperty("id")
   public MesBuildingProductProcessDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingProductProcessDOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public MesBuildingProductProcessDOParam setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @JsonProperty("sort")
   public MesBuildingProductProcessDOParam setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProductProcessDOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductProcessDOParam(id="
         + this.getId()
         + ", productType="
         + this.getProductType()
         + ", boolEnabledEnum="
         + this.getBoolEnabledEnum()
         + ", sort="
         + this.getSort()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductProcessDOParam)) {
         return false;
      }

      MesBuildingProductProcessDOParam other = (MesBuildingProductProcessDOParam)o;
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
                  return this$userId == null ? other$userId == null : this$userId.equals(other$userId);
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
      return other instanceof MesBuildingProductProcessDOParam;
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
      return result * 59 + ($userId == null ? 43 : $userId.hashCode());
   }

   public static class MesBuildingProductProcessDOParamBuilder {
      private Long id;
      private Integer productType;
      private Boolean boolEnabledEnum;
      private Integer sort;
      private Long userId;

      MesBuildingProductProcessDOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProductProcessDOParam.MesBuildingProductProcessDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingProductProcessDOParam.MesBuildingProductProcessDOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public MesBuildingProductProcessDOParam.MesBuildingProductProcessDOParamBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingProductProcessDOParam.MesBuildingProductProcessDOParamBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProductProcessDOParam.MesBuildingProductProcessDOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingProductProcessDOParam build() {
         return new MesBuildingProductProcessDOParam(this.id, this.productType, this.boolEnabledEnum, this.sort, this.userId);
      }

      @Override
      public String toString() {
         return "MesBuildingProductProcessDOParam.MesBuildingProductProcessDOParamBuilder(id="
            + this.id
            + ", productType="
            + this.productType
            + ", boolEnabledEnum="
            + this.boolEnabledEnum
            + ", sort="
            + this.sort
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
