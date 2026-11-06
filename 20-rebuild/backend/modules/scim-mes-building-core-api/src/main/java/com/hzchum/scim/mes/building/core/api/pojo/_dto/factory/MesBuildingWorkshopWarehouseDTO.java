package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

class MesBuildingWorkshopWarehouseDTO {
   @JsonProperty("id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "车间名称")
   private String name;
   @ApiModelProperty(name = "shortName", notes = "车间简称")
   private String shortName;
   @ApiModelProperty(name = "shortName", notes = "车间简称")
   private List<MesBuildingWorkshopWarehouseDTO> warehouseList;

   public MesBuildingWorkshopWarehouseDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public List<MesBuildingWorkshopWarehouseDTO> getWarehouseList() {
      return this.warehouseList;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setWarehouseList(final List<MesBuildingWorkshopWarehouseDTO> warehouseList) {
      this.warehouseList = warehouseList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWorkshopWarehouseDTO)) {
         return false;
      }

      MesBuildingWorkshopWarehouseDTO other = (MesBuildingWorkshopWarehouseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$shortName = this.getShortName();
            Object other$shortName = other.getShortName();
            if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
               Object this$warehouseList = this.getWarehouseList();
               Object other$warehouseList = other.getWarehouseList();
               return this$warehouseList == null ? other$warehouseList == null : this$warehouseList.equals(other$warehouseList);
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
      return other instanceof MesBuildingWorkshopWarehouseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $warehouseList = this.getWarehouseList();
      return result * 59 + ($warehouseList == null ? 43 : $warehouseList.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingWorkshopWarehouseDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", warehouseList="
         + this.getWarehouseList()
         + ")";
   }
}
