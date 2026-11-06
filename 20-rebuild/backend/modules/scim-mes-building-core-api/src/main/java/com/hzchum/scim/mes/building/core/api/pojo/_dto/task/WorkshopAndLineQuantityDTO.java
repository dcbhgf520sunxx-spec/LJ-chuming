package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "WorkshopAndLineQuantityDTO", description = "")
public class WorkshopAndLineQuantityDTO {
   @ApiModelProperty(name = "workShopId", notes = "车间id")
   @JsonProperty("workShopId")
   @JSONField(name = "workShopId")
   private Long workShopId;
   @ApiModelProperty(name = "workShopName", value = "车间名称")
   @JsonProperty("workShopName")
   @JSONField(name = "workShopName")
   private String workShopName;
   @ApiModelProperty(name = "productionLineId", notes = "产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "groupId", notes = "生产组id")
   @JsonProperty("groupId")
   @JSONField(name = "groupId")
   private Long groupId;
   @ApiModelProperty(name = "groupName", value = "生产组名称")
   @JsonProperty("groupName")
   @JSONField(name = "groupName")
   private String groupName;
   @ApiModelProperty(name = "productionLineName", value = "产线名称")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   private String productionLineName;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "boolDrillEnum", value = "是否分配到钻孔")
   @JsonProperty("boolDrillEnum")
   @JSONField(name = "boolDrillEnum")
   private Boolean boolDrillEnum;

   public static WorkshopAndLineQuantityDTO.WorkshopAndLineQuantityDTOBuilder builder() {
      return new WorkshopAndLineQuantityDTO.WorkshopAndLineQuantityDTOBuilder();
   }

   public WorkshopAndLineQuantityDTO() {
   }

   public WorkshopAndLineQuantityDTO(
      final Long workShopId,
      final String workShopName,
      final Long productionLineId,
      final Long groupId,
      final String groupName,
      final String productionLineName,
      final Integer quantity,
      final Boolean boolDrillEnum
   ) {
      this.workShopId = workShopId;
      this.workShopName = workShopName;
      this.productionLineId = productionLineId;
      this.groupId = groupId;
      this.groupName = groupName;
      this.productionLineName = productionLineName;
      this.quantity = quantity;
      this.boolDrillEnum = boolDrillEnum;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public String getWorkShopName() {
      return this.workShopName;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getGroupId() {
      return this.groupId;
   }

   public String getGroupName() {
      return this.groupName;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Boolean getBoolDrillEnum() {
      return this.boolDrillEnum;
   }

   @JsonProperty("workShopId")
   public WorkshopAndLineQuantityDTO setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
      return this;
   }

   @JsonProperty("workShopName")
   public WorkshopAndLineQuantityDTO setWorkShopName(final String workShopName) {
      this.workShopName = workShopName;
      return this;
   }

   @JsonProperty("productionLineId")
   public WorkshopAndLineQuantityDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupId")
   public WorkshopAndLineQuantityDTO setGroupId(final Long groupId) {
      this.groupId = groupId;
      return this;
   }

   @JsonProperty("groupName")
   public WorkshopAndLineQuantityDTO setGroupName(final String groupName) {
      this.groupName = groupName;
      return this;
   }

   @JsonProperty("productionLineName")
   public WorkshopAndLineQuantityDTO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("quantity")
   public WorkshopAndLineQuantityDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("boolDrillEnum")
   public WorkshopAndLineQuantityDTO setBoolDrillEnum(final Boolean boolDrillEnum) {
      this.boolDrillEnum = boolDrillEnum;
      return this;
   }

   @Override
   public String toString() {
      return "WorkshopAndLineQuantityDTO(workShopId="
         + this.getWorkShopId()
         + ", workShopName="
         + this.getWorkShopName()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupId="
         + this.getGroupId()
         + ", groupName="
         + this.getGroupName()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", quantity="
         + this.getQuantity()
         + ", boolDrillEnum="
         + this.getBoolDrillEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkshopAndLineQuantityDTO)) {
         return false;
      }

      WorkshopAndLineQuantityDTO other = (WorkshopAndLineQuantityDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workShopId = this.getWorkShopId();
      Object other$workShopId = other.getWorkShopId();
      if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
         Object this$productionLineId = this.getProductionLineId();
         Object other$productionLineId = other.getProductionLineId();
         if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
            Object this$groupId = this.getGroupId();
            Object other$groupId = other.getGroupId();
            if (this$groupId == null ? other$groupId == null : this$groupId.equals(other$groupId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$boolDrillEnum = this.getBoolDrillEnum();
                  Object other$boolDrillEnum = other.getBoolDrillEnum();
                  if (this$boolDrillEnum == null ? other$boolDrillEnum == null : this$boolDrillEnum.equals(other$boolDrillEnum)) {
                     Object this$workShopName = this.getWorkShopName();
                     Object other$workShopName = other.getWorkShopName();
                     if (this$workShopName == null ? other$workShopName == null : this$workShopName.equals(other$workShopName)) {
                        Object this$groupName = this.getGroupName();
                        Object other$groupName = other.getGroupName();
                        if (this$groupName == null ? other$groupName == null : this$groupName.equals(other$groupName)) {
                           Object this$productionLineName = this.getProductionLineName();
                           Object other$productionLineName = other.getProductionLineName();
                           return this$productionLineName == null ? other$productionLineName == null : this$productionLineName.equals(other$productionLineName);
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
      return other instanceof WorkshopAndLineQuantityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupId = this.getGroupId();
      result = result * 59 + ($groupId == null ? 43 : $groupId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolDrillEnum = this.getBoolDrillEnum();
      result = result * 59 + ($boolDrillEnum == null ? 43 : $boolDrillEnum.hashCode());
      Object $workShopName = this.getWorkShopName();
      result = result * 59 + ($workShopName == null ? 43 : $workShopName.hashCode());
      Object $groupName = this.getGroupName();
      result = result * 59 + ($groupName == null ? 43 : $groupName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      return result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
   }

   public static class WorkshopAndLineQuantityDTOBuilder {
      private Long workShopId;
      private String workShopName;
      private Long productionLineId;
      private Long groupId;
      private String groupName;
      private String productionLineName;
      private Integer quantity;
      private Boolean boolDrillEnum;

      WorkshopAndLineQuantityDTOBuilder() {
      }

      @JsonProperty("workShopId")
      public WorkshopAndLineQuantityDTO.WorkshopAndLineQuantityDTOBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      @JsonProperty("workShopName")
      public WorkshopAndLineQuantityDTO.WorkshopAndLineQuantityDTOBuilder workShopName(final String workShopName) {
         this.workShopName = workShopName;
         return this;
      }

      @JsonProperty("productionLineId")
      public WorkshopAndLineQuantityDTO.WorkshopAndLineQuantityDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupId")
      public WorkshopAndLineQuantityDTO.WorkshopAndLineQuantityDTOBuilder groupId(final Long groupId) {
         this.groupId = groupId;
         return this;
      }

      @JsonProperty("groupName")
      public WorkshopAndLineQuantityDTO.WorkshopAndLineQuantityDTOBuilder groupName(final String groupName) {
         this.groupName = groupName;
         return this;
      }

      @JsonProperty("productionLineName")
      public WorkshopAndLineQuantityDTO.WorkshopAndLineQuantityDTOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("quantity")
      public WorkshopAndLineQuantityDTO.WorkshopAndLineQuantityDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("boolDrillEnum")
      public WorkshopAndLineQuantityDTO.WorkshopAndLineQuantityDTOBuilder boolDrillEnum(final Boolean boolDrillEnum) {
         this.boolDrillEnum = boolDrillEnum;
         return this;
      }

      public WorkshopAndLineQuantityDTO build() {
         return new WorkshopAndLineQuantityDTO(
            this.workShopId, this.workShopName, this.productionLineId, this.groupId, this.groupName, this.productionLineName, this.quantity, this.boolDrillEnum
         );
      }

      @Override
      public String toString() {
         return "WorkshopAndLineQuantityDTO.WorkshopAndLineQuantityDTOBuilder(workShopId="
            + this.workShopId
            + ", workShopName="
            + this.workShopName
            + ", productionLineId="
            + this.productionLineId
            + ", groupId="
            + this.groupId
            + ", groupName="
            + this.groupName
            + ", productionLineName="
            + this.productionLineName
            + ", quantity="
            + this.quantity
            + ", boolDrillEnum="
            + this.boolDrillEnum
            + ")";
      }
   }
}
