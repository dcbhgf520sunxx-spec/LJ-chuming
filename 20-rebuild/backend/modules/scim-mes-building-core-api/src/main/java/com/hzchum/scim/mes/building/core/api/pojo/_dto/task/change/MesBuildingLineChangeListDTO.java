package com.hzchum.scim.mes.building.core.api.pojo._dto.task.change;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingLineChangeListDTO", description = "产线协同,获取车间库存汇总信息请求类")
public class MesBuildingLineChangeListDTO {
   private Long shopId;
   private Long productId;
   private Integer taskType;

   public static MesBuildingLineChangeListDTO.MesBuildingLineChangeListDTOBuilder builder() {
      return new MesBuildingLineChangeListDTO.MesBuildingLineChangeListDTOBuilder();
   }

   public MesBuildingLineChangeListDTO() {
   }

   public MesBuildingLineChangeListDTO(final Long shopId, final Long productId, final Integer taskType) {
      this.shopId = shopId;
      this.productId = productId;
      this.taskType = taskType;
   }

   public Long getShopId() {
      return this.shopId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getTaskType() {
      return this.taskType;
   }

   public MesBuildingLineChangeListDTO setShopId(final Long shopId) {
      this.shopId = shopId;
      return this;
   }

   public MesBuildingLineChangeListDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public MesBuildingLineChangeListDTO setTaskType(final Integer taskType) {
      this.taskType = taskType;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingLineChangeListDTO(shopId=" + this.getShopId() + ", productId=" + this.getProductId() + ", taskType=" + this.getTaskType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingLineChangeListDTO)) {
         return false;
      }

      MesBuildingLineChangeListDTO other = (MesBuildingLineChangeListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$shopId = this.getShopId();
      Object other$shopId = other.getShopId();
      if (this$shopId == null ? other$shopId == null : this$shopId.equals(other$shopId)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$taskType = this.getTaskType();
            Object other$taskType = other.getTaskType();
            return this$taskType == null ? other$taskType == null : this$taskType.equals(other$taskType);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingLineChangeListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $shopId = this.getShopId();
      result = result * 59 + ($shopId == null ? 43 : $shopId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskType = this.getTaskType();
      return result * 59 + ($taskType == null ? 43 : $taskType.hashCode());
   }

   public static class MesBuildingLineChangeListDTOBuilder {
      private Long shopId;
      private Long productId;
      private Integer taskType;

      MesBuildingLineChangeListDTOBuilder() {
      }

      public MesBuildingLineChangeListDTO.MesBuildingLineChangeListDTOBuilder shopId(final Long shopId) {
         this.shopId = shopId;
         return this;
      }

      public MesBuildingLineChangeListDTO.MesBuildingLineChangeListDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesBuildingLineChangeListDTO.MesBuildingLineChangeListDTOBuilder taskType(final Integer taskType) {
         this.taskType = taskType;
         return this;
      }

      public MesBuildingLineChangeListDTO build() {
         return new MesBuildingLineChangeListDTO(this.shopId, this.productId, this.taskType);
      }

      @Override
      public String toString() {
         return "MesBuildingLineChangeListDTO.MesBuildingLineChangeListDTOBuilder(shopId="
            + this.shopId
            + ", productId="
            + this.productId
            + ", taskType="
            + this.taskType
            + ")";
      }
   }
}
