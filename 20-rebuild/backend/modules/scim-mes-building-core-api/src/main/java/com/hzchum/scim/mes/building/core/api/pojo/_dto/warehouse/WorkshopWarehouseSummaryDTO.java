package com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class WorkshopWarehouseSummaryDTO {
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("车间")
   private NameInfo workshop;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("仓库")
   private NameInfo warehouse;
   @ApiModelProperty("库存数量")
   private Integer quantity;
   @ApiModelProperty("库存吨位")
   private BigDecimal totalWeight;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("仓库库存列表")
   private List<WorkshopWarehouseSummaryDTO> warehouseList;

   public static WorkshopWarehouseSummaryDTO.WorkshopWarehouseSummaryDTOBuilder builder() {
      return new WorkshopWarehouseSummaryDTO.WorkshopWarehouseSummaryDTOBuilder();
   }

   public WorkshopWarehouseSummaryDTO() {
   }

   public WorkshopWarehouseSummaryDTO(
      final NameInfo workshop,
      final NameInfo warehouse,
      final Integer quantity,
      final BigDecimal totalWeight,
      final List<WorkshopWarehouseSummaryDTO> warehouseList
   ) {
      this.workshop = workshop;
      this.warehouse = warehouse;
      this.quantity = quantity;
      this.totalWeight = totalWeight;
      this.warehouseList = warehouseList;
   }

   public NameInfo getWorkshop() {
      return this.workshop;
   }

   public NameInfo getWarehouse() {
      return this.warehouse;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public List<WorkshopWarehouseSummaryDTO> getWarehouseList() {
      return this.warehouseList;
   }

   public void setWorkshop(final NameInfo workshop) {
      this.workshop = workshop;
   }

   public void setWarehouse(final NameInfo warehouse) {
      this.warehouse = warehouse;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setWarehouseList(final List<WorkshopWarehouseSummaryDTO> warehouseList) {
      this.warehouseList = warehouseList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkshopWarehouseSummaryDTO)) {
         return false;
      }

      WorkshopWarehouseSummaryDTO other = (WorkshopWarehouseSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$workshop = this.getWorkshop();
         Object other$workshop = other.getWorkshop();
         if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
            Object this$warehouse = this.getWarehouse();
            Object other$warehouse = other.getWarehouse();
            if (this$warehouse == null ? other$warehouse == null : this$warehouse.equals(other$warehouse)) {
               Object this$totalWeight = this.getTotalWeight();
               Object other$totalWeight = other.getTotalWeight();
               if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WorkshopWarehouseSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $warehouseList = this.getWarehouseList();
      return result * 59 + ($warehouseList == null ? 43 : $warehouseList.hashCode());
   }

   @Override
   public String toString() {
      return "WorkshopWarehouseSummaryDTO(workshop="
         + this.getWorkshop()
         + ", warehouse="
         + this.getWarehouse()
         + ", quantity="
         + this.getQuantity()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", warehouseList="
         + this.getWarehouseList()
         + ")";
   }

   public static class WorkshopWarehouseSummaryDTOBuilder {
      private NameInfo workshop;
      private NameInfo warehouse;
      private Integer quantity;
      private BigDecimal totalWeight;
      private List<WorkshopWarehouseSummaryDTO> warehouseList;

      WorkshopWarehouseSummaryDTOBuilder() {
      }

      public WorkshopWarehouseSummaryDTO.WorkshopWarehouseSummaryDTOBuilder workshop(final NameInfo workshop) {
         this.workshop = workshop;
         return this;
      }

      public WorkshopWarehouseSummaryDTO.WorkshopWarehouseSummaryDTOBuilder warehouse(final NameInfo warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public WorkshopWarehouseSummaryDTO.WorkshopWarehouseSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public WorkshopWarehouseSummaryDTO.WorkshopWarehouseSummaryDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public WorkshopWarehouseSummaryDTO.WorkshopWarehouseSummaryDTOBuilder warehouseList(final List<WorkshopWarehouseSummaryDTO> warehouseList) {
         this.warehouseList = warehouseList;
         return this;
      }

      public WorkshopWarehouseSummaryDTO build() {
         return new WorkshopWarehouseSummaryDTO(this.workshop, this.warehouse, this.quantity, this.totalWeight, this.warehouseList);
      }

      @Override
      public String toString() {
         return "WorkshopWarehouseSummaryDTO.WorkshopWarehouseSummaryDTOBuilder(workshop="
            + this.workshop
            + ", warehouse="
            + this.warehouse
            + ", quantity="
            + this.quantity
            + ", totalWeight="
            + this.totalWeight
            + ", warehouseList="
            + this.warehouseList
            + ")";
      }
   }
}
