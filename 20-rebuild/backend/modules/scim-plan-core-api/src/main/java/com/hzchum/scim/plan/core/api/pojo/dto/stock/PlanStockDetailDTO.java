package com.hzchum.scim.plan.core.api.pojo.dto.stock;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ApiModel("备料单详情DTO类")
public class PlanStockDetailDTO {
   @NotNull(message = "备料单id不能为空")
   @ApiModelProperty("备料单id")
   private Long id;
   @Valid
   @ApiModelProperty("备料清单(无清单备料)")
   private List<PlanStockListDTO> technologyList;
   @Valid
   @ApiModelProperty("库存利用清单单")
   private List<PlanStockInventoryBasicsDTO> inventoryList;
   @Valid
   @ApiModelProperty("需采购清单")
   private List<PlanStockPurchaseBasicsDTO> purchaseList;

   public static PlanStockDetailDTO.PlanStockDetailDTOBuilder builder() {
      return new PlanStockDetailDTO.PlanStockDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public List<PlanStockListDTO> getTechnologyList() {
      return this.technologyList;
   }

   public List<PlanStockInventoryBasicsDTO> getInventoryList() {
      return this.inventoryList;
   }

   public List<PlanStockPurchaseBasicsDTO> getPurchaseList() {
      return this.purchaseList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setTechnologyList(final List<PlanStockListDTO> technologyList) {
      this.technologyList = technologyList;
   }

   public void setInventoryList(final List<PlanStockInventoryBasicsDTO> inventoryList) {
      this.inventoryList = inventoryList;
   }

   public void setPurchaseList(final List<PlanStockPurchaseBasicsDTO> purchaseList) {
      this.purchaseList = purchaseList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanStockDetailDTO)) {
         return false;
      }

      PlanStockDetailDTO other = (PlanStockDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$technologyList = this.getTechnologyList();
         Object other$technologyList = other.getTechnologyList();
         if (this$technologyList == null ? other$technologyList == null : this$technologyList.equals(other$technologyList)) {
            Object this$inventoryList = this.getInventoryList();
            Object other$inventoryList = other.getInventoryList();
            if (this$inventoryList == null ? other$inventoryList == null : this$inventoryList.equals(other$inventoryList)) {
               Object this$purchaseList = this.getPurchaseList();
               Object other$purchaseList = other.getPurchaseList();
               return this$purchaseList == null ? other$purchaseList == null : this$purchaseList.equals(other$purchaseList);
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
      return other instanceof PlanStockDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $technologyList = this.getTechnologyList();
      result = result * 59 + ($technologyList == null ? 43 : $technologyList.hashCode());
      Object $inventoryList = this.getInventoryList();
      result = result * 59 + ($inventoryList == null ? 43 : $inventoryList.hashCode());
      Object $purchaseList = this.getPurchaseList();
      return result * 59 + ($purchaseList == null ? 43 : $purchaseList.hashCode());
   }

   @Override
   public String toString() {
      return "PlanStockDetailDTO(id="
         + this.getId()
         + ", technologyList="
         + this.getTechnologyList()
         + ", inventoryList="
         + this.getInventoryList()
         + ", purchaseList="
         + this.getPurchaseList()
         + ")";
   }

   public PlanStockDetailDTO() {
   }

   public PlanStockDetailDTO(
      final Long id,
      final List<PlanStockListDTO> technologyList,
      final List<PlanStockInventoryBasicsDTO> inventoryList,
      final List<PlanStockPurchaseBasicsDTO> purchaseList
   ) {
      this.id = id;
      this.technologyList = technologyList;
      this.inventoryList = inventoryList;
      this.purchaseList = purchaseList;
   }

   public static class PlanStockDetailDTOBuilder {
      private Long id;
      private List<PlanStockListDTO> technologyList;
      private List<PlanStockInventoryBasicsDTO> inventoryList;
      private List<PlanStockPurchaseBasicsDTO> purchaseList;

      PlanStockDetailDTOBuilder() {
      }

      public PlanStockDetailDTO.PlanStockDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PlanStockDetailDTO.PlanStockDetailDTOBuilder technologyList(final List<PlanStockListDTO> technologyList) {
         this.technologyList = technologyList;
         return this;
      }

      public PlanStockDetailDTO.PlanStockDetailDTOBuilder inventoryList(final List<PlanStockInventoryBasicsDTO> inventoryList) {
         this.inventoryList = inventoryList;
         return this;
      }

      public PlanStockDetailDTO.PlanStockDetailDTOBuilder purchaseList(final List<PlanStockPurchaseBasicsDTO> purchaseList) {
         this.purchaseList = purchaseList;
         return this;
      }

      public PlanStockDetailDTO build() {
         return new PlanStockDetailDTO(this.id, this.technologyList, this.inventoryList, this.purchaseList);
      }

      @Override
      public String toString() {
         return "PlanStockDetailDTO.PlanStockDetailDTOBuilder(id="
            + this.id
            + ", technologyList="
            + this.technologyList
            + ", inventoryList="
            + this.inventoryList
            + ", purchaseList="
            + this.purchaseList
            + ")";
      }
   }
}
