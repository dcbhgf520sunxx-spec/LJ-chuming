package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "GroupDetailDTO", description = "生产组详细信息")
public class GroupDetailDTO {
   @ApiModelProperty(name = "groupId", notes = "班组id")
   @JsonProperty("groupId")
   @JSONField(name = "groupId")
   private Long groupId;
   @ApiModelProperty(name = "groupName", value = "班组名")
   @JsonProperty("groupName")
   @JSONField(name = "groupName")
   private String groupName;
   @ApiModelProperty(name = "productionLineId", notes = "产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "productionLineName", value = "产线名")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   private String productionLineName;
   @ApiModelProperty(name = "workshopId", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "workshopName", value = "车间名")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "factoryName", value = "工厂名")
   @JsonProperty("factoryName")
   @JSONField(name = "factoryName")
   private String factoryName;

   public static GroupDetailDTO.GroupDetailDTOBuilder builder() {
      return new GroupDetailDTO.GroupDetailDTOBuilder();
   }

   public GroupDetailDTO() {
   }

   public GroupDetailDTO(
      final Long groupId,
      final String groupName,
      final Long productionLineId,
      final String productionLineName,
      final Long workshopId,
      final String workshopName,
      final Long factoryId,
      final String factoryName
   ) {
      this.groupId = groupId;
      this.groupName = groupName;
      this.productionLineId = productionLineId;
      this.productionLineName = productionLineName;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.factoryId = factoryId;
      this.factoryName = factoryName;
   }

   public Long getGroupId() {
      return this.groupId;
   }

   public String getGroupName() {
      return this.groupName;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getProductionLineName() {
      return this.productionLineName;
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

   @JsonProperty("groupId")
   public GroupDetailDTO setGroupId(final Long groupId) {
      this.groupId = groupId;
      return this;
   }

   @JsonProperty("groupName")
   public GroupDetailDTO setGroupName(final String groupName) {
      this.groupName = groupName;
      return this;
   }

   @JsonProperty("productionLineId")
   public GroupDetailDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productionLineName")
   public GroupDetailDTO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("workshopId")
   public GroupDetailDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("workshopName")
   public GroupDetailDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("factoryId")
   public GroupDetailDTO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("factoryName")
   public GroupDetailDTO setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
      return this;
   }

   @Override
   public String toString() {
      return "GroupDetailDTO(groupId="
         + this.getGroupId()
         + ", groupName="
         + this.getGroupName()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", factoryId="
         + this.getFactoryId()
         + ", factoryName="
         + this.getFactoryName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof GroupDetailDTO)) {
         return false;
      }

      GroupDetailDTO other = (GroupDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$groupId = this.getGroupId();
      Object other$groupId = other.getGroupId();
      if (this$groupId == null ? other$groupId == null : this$groupId.equals(other$groupId)) {
         Object this$productionLineId = this.getProductionLineId();
         Object other$productionLineId = other.getProductionLineId();
         if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$factoryId = this.getFactoryId();
               Object other$factoryId = other.getFactoryId();
               if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                  Object this$groupName = this.getGroupName();
                  Object other$groupName = other.getGroupName();
                  if (this$groupName == null ? other$groupName == null : this$groupName.equals(other$groupName)) {
                     Object this$productionLineName = this.getProductionLineName();
                     Object other$productionLineName = other.getProductionLineName();
                     if (this$productionLineName == null ? other$productionLineName == null : this$productionLineName.equals(other$productionLineName)) {
                        Object this$workshopName = this.getWorkshopName();
                        Object other$workshopName = other.getWorkshopName();
                        if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                           Object this$factoryName = this.getFactoryName();
                           Object other$factoryName = other.getFactoryName();
                           return this$factoryName == null ? other$factoryName == null : this$factoryName.equals(other$factoryName);
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
      return other instanceof GroupDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $groupId = this.getGroupId();
      result = result * 59 + ($groupId == null ? 43 : $groupId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $groupName = this.getGroupName();
      result = result * 59 + ($groupName == null ? 43 : $groupName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $factoryName = this.getFactoryName();
      return result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
   }

   public static class GroupDetailDTOBuilder {
      private Long groupId;
      private String groupName;
      private Long productionLineId;
      private String productionLineName;
      private Long workshopId;
      private String workshopName;
      private Long factoryId;
      private String factoryName;

      GroupDetailDTOBuilder() {
      }

      @JsonProperty("groupId")
      public GroupDetailDTO.GroupDetailDTOBuilder groupId(final Long groupId) {
         this.groupId = groupId;
         return this;
      }

      @JsonProperty("groupName")
      public GroupDetailDTO.GroupDetailDTOBuilder groupName(final String groupName) {
         this.groupName = groupName;
         return this;
      }

      @JsonProperty("productionLineId")
      public GroupDetailDTO.GroupDetailDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productionLineName")
      public GroupDetailDTO.GroupDetailDTOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("workshopId")
      public GroupDetailDTO.GroupDetailDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("workshopName")
      public GroupDetailDTO.GroupDetailDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("factoryId")
      public GroupDetailDTO.GroupDetailDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("factoryName")
      public GroupDetailDTO.GroupDetailDTOBuilder factoryName(final String factoryName) {
         this.factoryName = factoryName;
         return this;
      }

      public GroupDetailDTO build() {
         return new GroupDetailDTO(
            this.groupId, this.groupName, this.productionLineId, this.productionLineName, this.workshopId, this.workshopName, this.factoryId, this.factoryName
         );
      }

      @Override
      public String toString() {
         return "GroupDetailDTO.GroupDetailDTOBuilder(groupId="
            + this.groupId
            + ", groupName="
            + this.groupName
            + ", productionLineId="
            + this.productionLineId
            + ", productionLineName="
            + this.productionLineName
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", factoryId="
            + this.factoryId
            + ", factoryName="
            + this.factoryName
            + ")";
      }
   }
}
