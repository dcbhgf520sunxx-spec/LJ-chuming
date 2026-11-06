package com.hzchum.scim.mes.building.core.api.pojo._do.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingProductionLineSumDO对象", description = "生产线 ")
public class MesBuildingProductionLineSumDO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", value = "生产线名称", notes = "生产线名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "boolEnabledEnum", value = "禁用状态 禁用状态 启用状态 [0 禁用, 1 启用]", notes = "禁用状态 禁用状态 启用状态 [0 禁用, 1 启用]")
   @JsonProperty("boolEnabledEnum")
   @JSONField(name = "boolEnabledEnum")
   private Boolean boolEnabledEnum;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "factoryName", value = "工厂name", notes = "工厂name")
   @JsonProperty("factoryName")
   @JSONField(name = "factoryName")
   private String factoryName;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "workshopName", value = "车间name", notes = "车间name")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "userId", value = "用户id", notes = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;

   public static MesBuildingProductionLineSumDO.MesBuildingProductionLineSumDOBuilder builder() {
      return new MesBuildingProductionLineSumDO.MesBuildingProductionLineSumDOBuilder();
   }

   public MesBuildingProductionLineSumDO() {
   }

   public MesBuildingProductionLineSumDO(
      final Long id,
      final String name,
      final Integer productType,
      final Integer sort,
      final Boolean boolEnabledEnum,
      final String remark,
      final Long factoryId,
      final String factoryName,
      final Long workshopId,
      final String workshopName,
      final Long userId
   ) {
      this.id = id;
      this.name = name;
      this.productType = productType;
      this.sort = sort;
      this.boolEnabledEnum = boolEnabledEnum;
      this.remark = remark;
      this.factoryId = factoryId;
      this.factoryName = factoryName;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Boolean getBoolEnabledEnum() {
      return this.boolEnabledEnum;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public String getFactoryName() {
      return this.factoryName;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("productType")
   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   @JsonProperty("sort")
   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   @JsonProperty("boolEnabledEnum")
   public void setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
   }

   @JsonProperty("remark")
   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @JsonProperty("factoryId")
   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   @JsonProperty("factoryName")
   public void setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
   }

   @JsonProperty("workshopId")
   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   @JsonProperty("workshopName")
   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   @JsonProperty("userId")
   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductionLineSumDO)) {
         return false;
      }

      MesBuildingProductionLineSumDO other = (MesBuildingProductionLineSumDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$boolEnabledEnum = this.getBoolEnabledEnum();
               Object other$boolEnabledEnum = other.getBoolEnabledEnum();
               if (this$boolEnabledEnum == null ? other$boolEnabledEnum == null : this$boolEnabledEnum.equals(other$boolEnabledEnum)) {
                  Object this$factoryId = this.getFactoryId();
                  Object other$factoryId = other.getFactoryId();
                  if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                     Object this$workshopId = this.getWorkshopId();
                     Object other$workshopId = other.getWorkshopId();
                     if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                 Object this$factoryName = this.getFactoryName();
                                 Object other$factoryName = other.getFactoryName();
                                 if (this$factoryName == null ? other$factoryName == null : this$factoryName.equals(other$factoryName)) {
                                    Object this$workshopName = this.getWorkshopName();
                                    Object other$workshopName = other.getWorkshopName();
                                    return this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProductionLineSumDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      result = result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $factoryName = this.getFactoryName();
      result = result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
      Object $workshopName = this.getWorkshopName();
      return result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingProductionLineSumDO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", productType="
         + this.getProductType()
         + ", sort="
         + this.getSort()
         + ", boolEnabledEnum="
         + this.getBoolEnabledEnum()
         + ", remark="
         + this.getRemark()
         + ", factoryId="
         + this.getFactoryId()
         + ", factoryName="
         + this.getFactoryName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   public static class MesBuildingProductionLineSumDOBuilder {
      private Long id;
      private String name;
      private Integer productType;
      private Integer sort;
      private Boolean boolEnabledEnum;
      private String remark;
      private Long factoryId;
      private String factoryName;
      private Long workshopId;
      private String workshopName;
      private Long userId;

      MesBuildingProductionLineSumDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProductionLineSumDO.MesBuildingProductionLineSumDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingProductionLineSumDO.MesBuildingProductionLineSumDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingProductionLineSumDO.MesBuildingProductionLineSumDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingProductionLineSumDO.MesBuildingProductionLineSumDOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public MesBuildingProductionLineSumDO.MesBuildingProductionLineSumDOBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingProductionLineSumDO.MesBuildingProductionLineSumDOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingProductionLineSumDO.MesBuildingProductionLineSumDOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("factoryName")
      public MesBuildingProductionLineSumDO.MesBuildingProductionLineSumDOBuilder factoryName(final String factoryName) {
         this.factoryName = factoryName;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingProductionLineSumDO.MesBuildingProductionLineSumDOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("workshopName")
      public MesBuildingProductionLineSumDO.MesBuildingProductionLineSumDOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProductionLineSumDO.MesBuildingProductionLineSumDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingProductionLineSumDO build() {
         return new MesBuildingProductionLineSumDO(
            this.id,
            this.name,
            this.productType,
            this.sort,
            this.boolEnabledEnum,
            this.remark,
            this.factoryId,
            this.factoryName,
            this.workshopId,
            this.workshopName,
            this.userId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProductionLineSumDO.MesBuildingProductionLineSumDOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", productType="
            + this.productType
            + ", sort="
            + this.sort
            + ", boolEnabledEnum="
            + this.boolEnabledEnum
            + ", remark="
            + this.remark
            + ", factoryId="
            + this.factoryId
            + ", factoryName="
            + this.factoryName
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
