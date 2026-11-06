package com.hzchum.scim.mes.building.core.api.pojo._do.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingGroupSumDO", description = "生产组详细信息")
public class MesBuildingGroupSumDO {
   @ApiModelProperty(name = "groupId", value = "班组ID", notes = "班组ID")
   @JsonProperty("groupId")
   @JSONField(name = "groupId")
   private Long groupId;
   @ApiModelProperty(name = "groupName", value = "班组名称", notes = "班组名称")
   @JsonProperty("groupName")
   @JSONField(name = "groupName")
   private String groupName;
   @ApiModelProperty(name = "lineId", value = "生产线ID", notes = "生产线ID")
   @JsonProperty("lineId")
   @JSONField(name = "lineId")
   private Long lineId;
   @ApiModelProperty(name = "lineName", value = "生产线名称", notes = "生产线名称")
   @JsonProperty("lineName")
   @JSONField(name = "lineName")
   private String lineName;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "workshopName", value = "车间name", notes = "车间name")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "factoryName", value = "工厂name", notes = "工厂name")
   @JsonProperty("factoryName")
   @JSONField(name = "factoryName")
   private String factoryName;
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
   @ApiModelProperty(name = "userId", value = "用户id", notes = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;

   public static MesBuildingGroupSumDO.MesBuildingGroupSumDOBuilder builder() {
      return new MesBuildingGroupSumDO.MesBuildingGroupSumDOBuilder();
   }

   public MesBuildingGroupSumDO() {
   }

   public MesBuildingGroupSumDO(
      final Long groupId,
      final String groupName,
      final Long lineId,
      final String lineName,
      final Long workshopId,
      final String workshopName,
      final Long factoryId,
      final String factoryName,
      final Integer productType,
      final Integer sort,
      final Boolean boolEnabledEnum,
      final String remark,
      final Long userId
   ) {
      this.groupId = groupId;
      this.groupName = groupName;
      this.lineId = lineId;
      this.lineName = lineName;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.factoryId = factoryId;
      this.factoryName = factoryName;
      this.productType = productType;
      this.sort = sort;
      this.boolEnabledEnum = boolEnabledEnum;
      this.remark = remark;
      this.userId = userId;
   }

   public Long getGroupId() {
      return this.groupId;
   }

   public String getGroupName() {
      return this.groupName;
   }

   public Long getLineId() {
      return this.lineId;
   }

   public String getLineName() {
      return this.lineName;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public String getFactoryName() {
      return this.factoryName;
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

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("groupId")
   public MesBuildingGroupSumDO setGroupId(final Long groupId) {
      this.groupId = groupId;
      return this;
   }

   @JsonProperty("groupName")
   public MesBuildingGroupSumDO setGroupName(final String groupName) {
      this.groupName = groupName;
      return this;
   }

   @JsonProperty("lineId")
   public MesBuildingGroupSumDO setLineId(final Long lineId) {
      this.lineId = lineId;
      return this;
   }

   @JsonProperty("lineName")
   public MesBuildingGroupSumDO setLineName(final String lineName) {
      this.lineName = lineName;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingGroupSumDO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("workshopName")
   public MesBuildingGroupSumDO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingGroupSumDO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("factoryName")
   public MesBuildingGroupSumDO setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingGroupSumDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("sort")
   public MesBuildingGroupSumDO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public MesBuildingGroupSumDO setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingGroupSumDO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingGroupSumDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingGroupSumDO)) {
         return false;
      }

      MesBuildingGroupSumDO other = (MesBuildingGroupSumDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$groupId = this.getGroupId();
      Object other$groupId = other.getGroupId();
      if (this$groupId == null ? other$groupId == null : this$groupId.equals(other$groupId)) {
         Object this$lineId = this.getLineId();
         Object other$lineId = other.getLineId();
         if (this$lineId == null ? other$lineId == null : this$lineId.equals(other$lineId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$factoryId = this.getFactoryId();
               Object other$factoryId = other.getFactoryId();
               if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                  Object this$productType = this.getProductType();
                  Object other$productType = other.getProductType();
                  if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                     Object this$sort = this.getSort();
                     Object other$sort = other.getSort();
                     if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                        Object this$boolEnabledEnum = this.getBoolEnabledEnum();
                        Object other$boolEnabledEnum = other.getBoolEnabledEnum();
                        if (this$boolEnabledEnum == null ? other$boolEnabledEnum == null : this$boolEnabledEnum.equals(other$boolEnabledEnum)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$groupName = this.getGroupName();
                              Object other$groupName = other.getGroupName();
                              if (this$groupName == null ? other$groupName == null : this$groupName.equals(other$groupName)) {
                                 Object this$lineName = this.getLineName();
                                 Object other$lineName = other.getLineName();
                                 if (this$lineName == null ? other$lineName == null : this$lineName.equals(other$lineName)) {
                                    Object this$workshopName = this.getWorkshopName();
                                    Object other$workshopName = other.getWorkshopName();
                                    if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                       Object this$factoryName = this.getFactoryName();
                                       Object other$factoryName = other.getFactoryName();
                                       if (this$factoryName == null ? other$factoryName == null : this$factoryName.equals(other$factoryName)) {
                                          Object this$remark = this.getRemark();
                                          Object other$remark = other.getRemark();
                                          return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingGroupSumDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $groupId = this.getGroupId();
      result = result * 59 + ($groupId == null ? 43 : $groupId.hashCode());
      Object $lineId = this.getLineId();
      result = result * 59 + ($lineId == null ? 43 : $lineId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      result = result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $groupName = this.getGroupName();
      result = result * 59 + ($groupName == null ? 43 : $groupName.hashCode());
      Object $lineName = this.getLineName();
      result = result * 59 + ($lineName == null ? 43 : $lineName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $factoryName = this.getFactoryName();
      result = result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingGroupSumDO(groupId="
         + this.getGroupId()
         + ", groupName="
         + this.getGroupName()
         + ", lineId="
         + this.getLineId()
         + ", lineName="
         + this.getLineName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", factoryId="
         + this.getFactoryId()
         + ", factoryName="
         + this.getFactoryName()
         + ", productType="
         + this.getProductType()
         + ", sort="
         + this.getSort()
         + ", boolEnabledEnum="
         + this.getBoolEnabledEnum()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   public static class MesBuildingGroupSumDOBuilder {
      private Long groupId;
      private String groupName;
      private Long lineId;
      private String lineName;
      private Long workshopId;
      private String workshopName;
      private Long factoryId;
      private String factoryName;
      private Integer productType;
      private Integer sort;
      private Boolean boolEnabledEnum;
      private String remark;
      private Long userId;

      MesBuildingGroupSumDOBuilder() {
      }

      @JsonProperty("groupId")
      public MesBuildingGroupSumDO.MesBuildingGroupSumDOBuilder groupId(final Long groupId) {
         this.groupId = groupId;
         return this;
      }

      @JsonProperty("groupName")
      public MesBuildingGroupSumDO.MesBuildingGroupSumDOBuilder groupName(final String groupName) {
         this.groupName = groupName;
         return this;
      }

      @JsonProperty("lineId")
      public MesBuildingGroupSumDO.MesBuildingGroupSumDOBuilder lineId(final Long lineId) {
         this.lineId = lineId;
         return this;
      }

      @JsonProperty("lineName")
      public MesBuildingGroupSumDO.MesBuildingGroupSumDOBuilder lineName(final String lineName) {
         this.lineName = lineName;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingGroupSumDO.MesBuildingGroupSumDOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("workshopName")
      public MesBuildingGroupSumDO.MesBuildingGroupSumDOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingGroupSumDO.MesBuildingGroupSumDOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("factoryName")
      public MesBuildingGroupSumDO.MesBuildingGroupSumDOBuilder factoryName(final String factoryName) {
         this.factoryName = factoryName;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingGroupSumDO.MesBuildingGroupSumDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("sort")
      public MesBuildingGroupSumDO.MesBuildingGroupSumDOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public MesBuildingGroupSumDO.MesBuildingGroupSumDOBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingGroupSumDO.MesBuildingGroupSumDOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingGroupSumDO.MesBuildingGroupSumDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingGroupSumDO build() {
         return new MesBuildingGroupSumDO(
            this.groupId,
            this.groupName,
            this.lineId,
            this.lineName,
            this.workshopId,
            this.workshopName,
            this.factoryId,
            this.factoryName,
            this.productType,
            this.sort,
            this.boolEnabledEnum,
            this.remark,
            this.userId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingGroupSumDO.MesBuildingGroupSumDOBuilder(groupId="
            + this.groupId
            + ", groupName="
            + this.groupName
            + ", lineId="
            + this.lineId
            + ", lineName="
            + this.lineName
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", factoryId="
            + this.factoryId
            + ", factoryName="
            + this.factoryName
            + ", productType="
            + this.productType
            + ", sort="
            + this.sort
            + ", boolEnabledEnum="
            + this.boolEnabledEnum
            + ", remark="
            + this.remark
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
