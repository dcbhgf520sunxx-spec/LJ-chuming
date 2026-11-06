package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "AddWarehouseDTO", description = "")
public class AddWarehouseDTO {
   private Long factoryId;
   private Long workshopId;
   private Integer productType;
   private Long productId;
   private Integer type;

   public static AddWarehouseDTO.AddWarehouseDTOBuilder builder() {
      return new AddWarehouseDTO.AddWarehouseDTOBuilder();
   }

   public AddWarehouseDTO() {
   }

   public AddWarehouseDTO(final Long factoryId, final Long workshopId, final Integer productType, final Long productId, final Integer type) {
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productType = productType;
      this.productId = productId;
      this.type = type;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getType() {
      return this.type;
   }

   public AddWarehouseDTO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   public AddWarehouseDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public AddWarehouseDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public AddWarehouseDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public AddWarehouseDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AddWarehouseDTO)) {
         return false;
      }

      AddWarehouseDTO other = (AddWarehouseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$factoryId = this.getFactoryId();
      Object other$factoryId = other.getFactoryId();
      if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$productId = this.getProductId();
               Object other$productId = other.getProductId();
               if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                  Object this$type = this.getType();
                  Object other$type = other.getType();
                  return this$type == null ? other$type == null : this$type.equals(other$type);
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
      return other instanceof AddWarehouseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $type = this.getType();
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   @Override
   public String toString() {
      return "AddWarehouseDTO(factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", type="
         + this.getType()
         + ")";
   }

   public static class AddWarehouseDTOBuilder {
      private Long factoryId;
      private Long workshopId;
      private Integer productType;
      private Long productId;
      private Integer type;

      AddWarehouseDTOBuilder() {
      }

      public AddWarehouseDTO.AddWarehouseDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public AddWarehouseDTO.AddWarehouseDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public AddWarehouseDTO.AddWarehouseDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public AddWarehouseDTO.AddWarehouseDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public AddWarehouseDTO.AddWarehouseDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public AddWarehouseDTO build() {
         return new AddWarehouseDTO(this.factoryId, this.workshopId, this.productType, this.productId, this.type);
      }

      @Override
      public String toString() {
         return "AddWarehouseDTO.AddWarehouseDTOBuilder(factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
            + ", type="
            + this.type
            + ")";
      }
   }
}
