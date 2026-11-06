package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

import java.io.Serializable;
import java.util.List;

public class WarehouseDTOParam implements Serializable {
   private static final long serialVersionUID = 4997258960900601384L;
   private Long id;
   private String name;
   private Integer materialType;
   private Integer sort;
   private Boolean enabled;
   private Long workshopId;
   private Integer warehouseType;
   private Long factoryId;
   private List<String> workshopUsers;
   private List<Long> mesWorkshopId;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getMaterialType() {
      return this.materialType;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Boolean getEnabled() {
      return this.enabled;
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

   public List<String> getWorkshopUsers() {
      return this.workshopUsers;
   }

   public List<Long> getMesWorkshopId() {
      return this.mesWorkshopId;
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

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setEnabled(final Boolean enabled) {
      this.enabled = enabled;
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

   public void setWorkshopUsers(final List<String> workshopUsers) {
      this.workshopUsers = workshopUsers;
   }

   public void setMesWorkshopId(final List<Long> mesWorkshopId) {
      this.mesWorkshopId = mesWorkshopId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarehouseDTOParam)) {
         return false;
      }

      WarehouseDTOParam other = (WarehouseDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$materialType = this.getMaterialType();
         Object other$materialType = other.getMaterialType();
         if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$enabled = this.getEnabled();
               Object other$enabled = other.getEnabled();
               if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
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
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$workshopUsers = this.getWorkshopUsers();
                              Object other$workshopUsers = other.getWorkshopUsers();
                              if (this$workshopUsers == null ? other$workshopUsers == null : this$workshopUsers.equals(other$workshopUsers)) {
                                 Object this$mesWorkshopId = this.getMesWorkshopId();
                                 Object other$mesWorkshopId = other.getMesWorkshopId();
                                 return this$mesWorkshopId == null ? other$mesWorkshopId == null : this$mesWorkshopId.equals(other$mesWorkshopId);
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
      return other instanceof WarehouseDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $workshopUsers = this.getWorkshopUsers();
      result = result * 59 + ($workshopUsers == null ? 43 : $workshopUsers.hashCode());
      Object $mesWorkshopId = this.getMesWorkshopId();
      return result * 59 + ($mesWorkshopId == null ? 43 : $mesWorkshopId.hashCode());
   }

   @Override
   public String toString() {
      return "WarehouseDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", materialType="
         + this.getMaterialType()
         + ", sort="
         + this.getSort()
         + ", enabled="
         + this.getEnabled()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopUsers="
         + this.getWorkshopUsers()
         + ", mesWorkshopId="
         + this.getMesWorkshopId()
         + ")";
   }

   public WarehouseDTOParam(
      final Long id,
      final String name,
      final Integer materialType,
      final Integer sort,
      final Boolean enabled,
      final Long workshopId,
      final Integer warehouseType,
      final Long factoryId,
      final List<String> workshopUsers,
      final List<Long> mesWorkshopId
   ) {
      this.id = id;
      this.name = name;
      this.materialType = materialType;
      this.sort = sort;
      this.enabled = enabled;
      this.workshopId = workshopId;
      this.warehouseType = warehouseType;
      this.factoryId = factoryId;
      this.workshopUsers = workshopUsers;
      this.mesWorkshopId = mesWorkshopId;
   }

   public WarehouseDTOParam() {
   }
}
