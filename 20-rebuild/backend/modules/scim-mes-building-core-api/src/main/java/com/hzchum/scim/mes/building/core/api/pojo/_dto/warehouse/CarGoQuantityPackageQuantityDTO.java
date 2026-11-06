package com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse;

public class CarGoQuantityPackageQuantityDTO {
   private Long shopId;
   private Integer taskType;
   private Long packageId;
   private Integer quantity;

   public static CarGoQuantityPackageQuantityDTO.CarGoQuantityPackageQuantityDTOBuilder builder() {
      return new CarGoQuantityPackageQuantityDTO.CarGoQuantityPackageQuantityDTOBuilder();
   }

   public Long getShopId() {
      return this.shopId;
   }

   public Integer getTaskType() {
      return this.taskType;
   }

   public Long getPackageId() {
      return this.packageId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setShopId(final Long shopId) {
      this.shopId = shopId;
   }

   public void setTaskType(final Integer taskType) {
      this.taskType = taskType;
   }

   public void setPackageId(final Long packageId) {
      this.packageId = packageId;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CarGoQuantityPackageQuantityDTO)) {
         return false;
      }

      CarGoQuantityPackageQuantityDTO other = (CarGoQuantityPackageQuantityDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$shopId = this.getShopId();
      Object other$shopId = other.getShopId();
      if (this$shopId == null ? other$shopId == null : this$shopId.equals(other$shopId)) {
         Object this$taskType = this.getTaskType();
         Object other$taskType = other.getTaskType();
         if (this$taskType == null ? other$taskType == null : this$taskType.equals(other$taskType)) {
            Object this$packageId = this.getPackageId();
            Object other$packageId = other.getPackageId();
            if (this$packageId == null ? other$packageId == null : this$packageId.equals(other$packageId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
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
      return other instanceof CarGoQuantityPackageQuantityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $shopId = this.getShopId();
      result = result * 59 + ($shopId == null ? 43 : $shopId.hashCode());
      Object $taskType = this.getTaskType();
      result = result * 59 + ($taskType == null ? 43 : $taskType.hashCode());
      Object $packageId = this.getPackageId();
      result = result * 59 + ($packageId == null ? 43 : $packageId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "CarGoQuantityPackageQuantityDTO(shopId="
         + this.getShopId()
         + ", taskType="
         + this.getTaskType()
         + ", packageId="
         + this.getPackageId()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   public CarGoQuantityPackageQuantityDTO(final Long shopId, final Integer taskType, final Long packageId, final Integer quantity) {
      this.shopId = shopId;
      this.taskType = taskType;
      this.packageId = packageId;
      this.quantity = quantity;
   }

   public CarGoQuantityPackageQuantityDTO() {
   }

   public static class CarGoQuantityPackageQuantityDTOBuilder {
      private Long shopId;
      private Integer taskType;
      private Long packageId;
      private Integer quantity;

      CarGoQuantityPackageQuantityDTOBuilder() {
      }

      public CarGoQuantityPackageQuantityDTO.CarGoQuantityPackageQuantityDTOBuilder shopId(final Long shopId) {
         this.shopId = shopId;
         return this;
      }

      public CarGoQuantityPackageQuantityDTO.CarGoQuantityPackageQuantityDTOBuilder taskType(final Integer taskType) {
         this.taskType = taskType;
         return this;
      }

      public CarGoQuantityPackageQuantityDTO.CarGoQuantityPackageQuantityDTOBuilder packageId(final Long packageId) {
         this.packageId = packageId;
         return this;
      }

      public CarGoQuantityPackageQuantityDTO.CarGoQuantityPackageQuantityDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public CarGoQuantityPackageQuantityDTO build() {
         return new CarGoQuantityPackageQuantityDTO(this.shopId, this.taskType, this.packageId, this.quantity);
      }

      @Override
      public String toString() {
         return "CarGoQuantityPackageQuantityDTO.CarGoQuantityPackageQuantityDTOBuilder(shopId="
            + this.shopId
            + ", taskType="
            + this.taskType
            + ", packageId="
            + this.packageId
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
