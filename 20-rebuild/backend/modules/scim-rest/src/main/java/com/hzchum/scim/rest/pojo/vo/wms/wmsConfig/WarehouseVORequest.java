package com.hzchum.scim.rest.pojo.vo.wms.wmsConfig;

public class WarehouseVORequest {
   private Long id;
   private String name;
   private Integer materialType;
   private Integer type;
   private Integer sort;
   private Long workshopId;
   private Integer warehouseType;
   private Long factoryId;

   public static WarehouseVORequest.WarehouseVORequestBuilder builder() {
      return new WarehouseVORequest.WarehouseVORequestBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getMaterialType() {
      return this.materialType;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMaterialType(final Integer materialType) {
      this.materialType = materialType;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarehouseVORequest)) {
         return false;
      }

      WarehouseVORequest other = (WarehouseVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$materialType = this.getMaterialType();
         Object other$materialType = other.getMaterialType();
         if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$warehouseType = this.getWarehouseType();
                     Object other$warehouseType = other.getWarehouseType();
                     if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
                        Object this$factoryId = this.getFactoryId();
                        Object other$factoryId = other.getFactoryId();
                        if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof WarehouseVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "WarehouseVORequest(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", materialType="
         + this.getMaterialType()
         + ", type="
         + this.getType()
         + ", sort="
         + this.getSort()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", factoryId="
         + this.getFactoryId()
         + ")";
   }

   public WarehouseVORequest() {
   }

   public WarehouseVORequest(
      final Long id,
      final String name,
      final Integer materialType,
      final Integer type,
      final Integer sort,
      final Long workshopId,
      final Integer warehouseType,
      final Long factoryId
   ) {
      this.id = id;
      this.name = name;
      this.materialType = materialType;
      this.type = type;
      this.sort = sort;
      this.workshopId = workshopId;
      this.warehouseType = warehouseType;
      this.factoryId = factoryId;
   }

   public static class WarehouseVORequestBuilder {
      private Long id;
      private String name;
      private Integer materialType;
      private Integer type;
      private Integer sort;
      private Long workshopId;
      private Integer warehouseType;
      private Long factoryId;

      WarehouseVORequestBuilder() {
      }

      public WarehouseVORequest.WarehouseVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WarehouseVORequest.WarehouseVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public WarehouseVORequest.WarehouseVORequestBuilder materialType(final Integer materialType) {
         this.materialType = materialType;
         return this;
      }

      public WarehouseVORequest.WarehouseVORequestBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public WarehouseVORequest.WarehouseVORequestBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public WarehouseVORequest.WarehouseVORequestBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public WarehouseVORequest.WarehouseVORequestBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      public WarehouseVORequest.WarehouseVORequestBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public WarehouseVORequest build() {
         return new WarehouseVORequest(this.id, this.name, this.materialType, this.type, this.sort, this.workshopId, this.warehouseType, this.factoryId);
      }

      @Override
      public String toString() {
         return "WarehouseVORequest.WarehouseVORequestBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", materialType="
            + this.materialType
            + ", type="
            + this.type
            + ", sort="
            + this.sort
            + ", workshopId="
            + this.workshopId
            + ", warehouseType="
            + this.warehouseType
            + ", factoryId="
            + this.factoryId
            + ")";
      }
   }
}
