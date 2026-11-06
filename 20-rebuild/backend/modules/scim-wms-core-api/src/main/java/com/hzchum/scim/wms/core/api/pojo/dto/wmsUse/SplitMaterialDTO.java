package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.PickingApproveOutboundDTOParam;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class SplitMaterialDTO {
   @ApiModelProperty("库存ID")
   private Long materialInventoryId;
   @ApiModelProperty("是否甲供")
   private Boolean boolPartA;
   @ApiModelProperty("单物料核算量")
   private BigDecimal materialInventoryMete;
   @ApiModelProperty("数量为1")
   private BigDecimal quantity = BigDecimal.ONE;
   @ApiModelProperty("拆分之后每份的核算量")
   private List<SplitMaterialAndPickingDetailDTO> splitDTOS;
   @ApiModelProperty("关联的领料单明细信息")
   private List<PickingApproveOutboundDTOParam> pickingApproveOutboundDTOParams;

   public static SplitMaterialDTO.SplitMaterialDTOBuilder builder() {
      return new SplitMaterialDTO.SplitMaterialDTOBuilder();
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public Boolean getBoolPartA() {
      return this.boolPartA;
   }

   public BigDecimal getMaterialInventoryMete() {
      return this.materialInventoryMete;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public List<SplitMaterialAndPickingDetailDTO> getSplitDTOS() {
      return this.splitDTOS;
   }

   public List<PickingApproveOutboundDTOParam> getPickingApproveOutboundDTOParams() {
      return this.pickingApproveOutboundDTOParams;
   }

   public void setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
   }

   public void setBoolPartA(final Boolean boolPartA) {
      this.boolPartA = boolPartA;
   }

   public void setMaterialInventoryMete(final BigDecimal materialInventoryMete) {
      this.materialInventoryMete = materialInventoryMete;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setSplitDTOS(final List<SplitMaterialAndPickingDetailDTO> splitDTOS) {
      this.splitDTOS = splitDTOS;
   }

   public void setPickingApproveOutboundDTOParams(final List<PickingApproveOutboundDTOParam> pickingApproveOutboundDTOParams) {
      this.pickingApproveOutboundDTOParams = pickingApproveOutboundDTOParams;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SplitMaterialDTO)) {
         return false;
      }

      SplitMaterialDTO other = (SplitMaterialDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$materialInventoryId = this.getMaterialInventoryId();
      Object other$materialInventoryId = other.getMaterialInventoryId();
      if (this$materialInventoryId == null ? other$materialInventoryId == null : this$materialInventoryId.equals(other$materialInventoryId)) {
         Object this$boolPartA = this.getBoolPartA();
         Object other$boolPartA = other.getBoolPartA();
         if (this$boolPartA == null ? other$boolPartA == null : this$boolPartA.equals(other$boolPartA)) {
            Object this$materialInventoryMete = this.getMaterialInventoryMete();
            Object other$materialInventoryMete = other.getMaterialInventoryMete();
            if (this$materialInventoryMete == null ? other$materialInventoryMete == null : this$materialInventoryMete.equals(other$materialInventoryMete)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$splitDTOS = this.getSplitDTOS();
                  Object other$splitDTOS = other.getSplitDTOS();
                  if (this$splitDTOS == null ? other$splitDTOS == null : this$splitDTOS.equals(other$splitDTOS)) {
                     Object this$pickingApproveOutboundDTOParams = this.getPickingApproveOutboundDTOParams();
                     Object other$pickingApproveOutboundDTOParams = other.getPickingApproveOutboundDTOParams();
                     return this$pickingApproveOutboundDTOParams == null
                        ? other$pickingApproveOutboundDTOParams == null
                        : this$pickingApproveOutboundDTOParams.equals(other$pickingApproveOutboundDTOParams);
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
      return other instanceof SplitMaterialDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $boolPartA = this.getBoolPartA();
      result = result * 59 + ($boolPartA == null ? 43 : $boolPartA.hashCode());
      Object $materialInventoryMete = this.getMaterialInventoryMete();
      result = result * 59 + ($materialInventoryMete == null ? 43 : $materialInventoryMete.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $splitDTOS = this.getSplitDTOS();
      result = result * 59 + ($splitDTOS == null ? 43 : $splitDTOS.hashCode());
      Object $pickingApproveOutboundDTOParams = this.getPickingApproveOutboundDTOParams();
      return result * 59 + ($pickingApproveOutboundDTOParams == null ? 43 : $pickingApproveOutboundDTOParams.hashCode());
   }

   @Override
   public String toString() {
      return "SplitMaterialDTO(materialInventoryId="
         + this.getMaterialInventoryId()
         + ", boolPartA="
         + this.getBoolPartA()
         + ", materialInventoryMete="
         + this.getMaterialInventoryMete()
         + ", quantity="
         + this.getQuantity()
         + ", splitDTOS="
         + this.getSplitDTOS()
         + ", pickingApproveOutboundDTOParams="
         + this.getPickingApproveOutboundDTOParams()
         + ")";
   }

   public SplitMaterialDTO(
      final Long materialInventoryId,
      final Boolean boolPartA,
      final BigDecimal materialInventoryMete,
      final BigDecimal quantity,
      final List<SplitMaterialAndPickingDetailDTO> splitDTOS,
      final List<PickingApproveOutboundDTOParam> pickingApproveOutboundDTOParams
   ) {
      this.materialInventoryId = materialInventoryId;
      this.boolPartA = boolPartA;
      this.materialInventoryMete = materialInventoryMete;
      this.quantity = quantity;
      this.splitDTOS = splitDTOS;
      this.pickingApproveOutboundDTOParams = pickingApproveOutboundDTOParams;
   }

   public SplitMaterialDTO() {
   }

   public static class SplitMaterialDTOBuilder {
      private Long materialInventoryId;
      private Boolean boolPartA;
      private BigDecimal materialInventoryMete;
      private BigDecimal quantity;
      private List<SplitMaterialAndPickingDetailDTO> splitDTOS;
      private List<PickingApproveOutboundDTOParam> pickingApproveOutboundDTOParams;

      SplitMaterialDTOBuilder() {
      }

      public SplitMaterialDTO.SplitMaterialDTOBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      public SplitMaterialDTO.SplitMaterialDTOBuilder boolPartA(final Boolean boolPartA) {
         this.boolPartA = boolPartA;
         return this;
      }

      public SplitMaterialDTO.SplitMaterialDTOBuilder materialInventoryMete(final BigDecimal materialInventoryMete) {
         this.materialInventoryMete = materialInventoryMete;
         return this;
      }

      public SplitMaterialDTO.SplitMaterialDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public SplitMaterialDTO.SplitMaterialDTOBuilder splitDTOS(final List<SplitMaterialAndPickingDetailDTO> splitDTOS) {
         this.splitDTOS = splitDTOS;
         return this;
      }

      public SplitMaterialDTO.SplitMaterialDTOBuilder pickingApproveOutboundDTOParams(
         final List<PickingApproveOutboundDTOParam> pickingApproveOutboundDTOParams
      ) {
         this.pickingApproveOutboundDTOParams = pickingApproveOutboundDTOParams;
         return this;
      }

      public SplitMaterialDTO build() {
         return new SplitMaterialDTO(
            this.materialInventoryId, this.boolPartA, this.materialInventoryMete, this.quantity, this.splitDTOS, this.pickingApproveOutboundDTOParams
         );
      }

      @Override
      public String toString() {
         return "SplitMaterialDTO.SplitMaterialDTOBuilder(materialInventoryId="
            + this.materialInventoryId
            + ", boolPartA="
            + this.boolPartA
            + ", materialInventoryMete="
            + this.materialInventoryMete
            + ", quantity="
            + this.quantity
            + ", splitDTOS="
            + this.splitDTOS
            + ", pickingApproveOutboundDTOParams="
            + this.pickingApproveOutboundDTOParams
            + ")";
      }
   }
}
