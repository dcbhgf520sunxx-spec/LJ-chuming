package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class SplitMaterialAndPickingDetailDTO {
   @ApiModelProperty("库存ID")
   private Long materialInventoryId;
   @ApiModelProperty("拆分之后的核算量")
   private BigDecimal mete;
   private BigDecimal actualTheoryWeight;
   @ApiModelProperty("拆分之后面积")
   private BigDecimal area;
   @ApiModelProperty("拆分之后的长度")
   private BigDecimal length;
   @ApiModelProperty("对应的领料单明细ID")
   private Long pickingDetailId;
   @ApiModelProperty("关联的领料单ID")
   private Long pickingId;
   @ApiModelProperty("关联的出库明细ID")
   private Long outboundDetailId;

   public static SplitMaterialAndPickingDetailDTO.SplitMaterialAndPickingDetailDTOBuilder builder() {
      return new SplitMaterialAndPickingDetailDTO.SplitMaterialAndPickingDetailDTOBuilder();
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getActualTheoryWeight() {
      return this.actualTheoryWeight;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public Long getPickingDetailId() {
      return this.pickingDetailId;
   }

   public Long getPickingId() {
      return this.pickingId;
   }

   public Long getOutboundDetailId() {
      return this.outboundDetailId;
   }

   public void setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setActualTheoryWeight(final BigDecimal actualTheoryWeight) {
      this.actualTheoryWeight = actualTheoryWeight;
   }

   public void setArea(final BigDecimal area) {
      this.area = area;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setPickingDetailId(final Long pickingDetailId) {
      this.pickingDetailId = pickingDetailId;
   }

   public void setPickingId(final Long pickingId) {
      this.pickingId = pickingId;
   }

   public void setOutboundDetailId(final Long outboundDetailId) {
      this.outboundDetailId = outboundDetailId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SplitMaterialAndPickingDetailDTO)) {
         return false;
      }

      SplitMaterialAndPickingDetailDTO other = (SplitMaterialAndPickingDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$materialInventoryId = this.getMaterialInventoryId();
      Object other$materialInventoryId = other.getMaterialInventoryId();
      if (this$materialInventoryId == null ? other$materialInventoryId == null : this$materialInventoryId.equals(other$materialInventoryId)) {
         Object this$pickingDetailId = this.getPickingDetailId();
         Object other$pickingDetailId = other.getPickingDetailId();
         if (this$pickingDetailId == null ? other$pickingDetailId == null : this$pickingDetailId.equals(other$pickingDetailId)) {
            Object this$pickingId = this.getPickingId();
            Object other$pickingId = other.getPickingId();
            if (this$pickingId == null ? other$pickingId == null : this$pickingId.equals(other$pickingId)) {
               Object this$outboundDetailId = this.getOutboundDetailId();
               Object other$outboundDetailId = other.getOutboundDetailId();
               if (this$outboundDetailId == null ? other$outboundDetailId == null : this$outboundDetailId.equals(other$outboundDetailId)) {
                  Object this$mete = this.getMete();
                  Object other$mete = other.getMete();
                  if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                     Object this$actualTheoryWeight = this.getActualTheoryWeight();
                     Object other$actualTheoryWeight = other.getActualTheoryWeight();
                     if (this$actualTheoryWeight == null ? other$actualTheoryWeight == null : this$actualTheoryWeight.equals(other$actualTheoryWeight)) {
                        Object this$area = this.getArea();
                        Object other$area = other.getArea();
                        if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                           Object this$length = this.getLength();
                           Object other$length = other.getLength();
                           return this$length == null ? other$length == null : this$length.equals(other$length);
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
      return other instanceof SplitMaterialAndPickingDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $pickingDetailId = this.getPickingDetailId();
      result = result * 59 + ($pickingDetailId == null ? 43 : $pickingDetailId.hashCode());
      Object $pickingId = this.getPickingId();
      result = result * 59 + ($pickingId == null ? 43 : $pickingId.hashCode());
      Object $outboundDetailId = this.getOutboundDetailId();
      result = result * 59 + ($outboundDetailId == null ? 43 : $outboundDetailId.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $actualTheoryWeight = this.getActualTheoryWeight();
      result = result * 59 + ($actualTheoryWeight == null ? 43 : $actualTheoryWeight.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $length = this.getLength();
      return result * 59 + ($length == null ? 43 : $length.hashCode());
   }

   @Override
   public String toString() {
      return "SplitMaterialAndPickingDetailDTO(materialInventoryId="
         + this.getMaterialInventoryId()
         + ", mete="
         + this.getMete()
         + ", actualTheoryWeight="
         + this.getActualTheoryWeight()
         + ", area="
         + this.getArea()
         + ", length="
         + this.getLength()
         + ", pickingDetailId="
         + this.getPickingDetailId()
         + ", pickingId="
         + this.getPickingId()
         + ", outboundDetailId="
         + this.getOutboundDetailId()
         + ")";
   }

   public SplitMaterialAndPickingDetailDTO(
      final Long materialInventoryId,
      final BigDecimal mete,
      final BigDecimal actualTheoryWeight,
      final BigDecimal area,
      final BigDecimal length,
      final Long pickingDetailId,
      final Long pickingId,
      final Long outboundDetailId
   ) {
      this.materialInventoryId = materialInventoryId;
      this.mete = mete;
      this.actualTheoryWeight = actualTheoryWeight;
      this.area = area;
      this.length = length;
      this.pickingDetailId = pickingDetailId;
      this.pickingId = pickingId;
      this.outboundDetailId = outboundDetailId;
   }

   public SplitMaterialAndPickingDetailDTO() {
   }

   public static class SplitMaterialAndPickingDetailDTOBuilder {
      private Long materialInventoryId;
      private BigDecimal mete;
      private BigDecimal actualTheoryWeight;
      private BigDecimal area;
      private BigDecimal length;
      private Long pickingDetailId;
      private Long pickingId;
      private Long outboundDetailId;

      SplitMaterialAndPickingDetailDTOBuilder() {
      }

      public SplitMaterialAndPickingDetailDTO.SplitMaterialAndPickingDetailDTOBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      public SplitMaterialAndPickingDetailDTO.SplitMaterialAndPickingDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public SplitMaterialAndPickingDetailDTO.SplitMaterialAndPickingDetailDTOBuilder actualTheoryWeight(final BigDecimal actualTheoryWeight) {
         this.actualTheoryWeight = actualTheoryWeight;
         return this;
      }

      public SplitMaterialAndPickingDetailDTO.SplitMaterialAndPickingDetailDTOBuilder area(final BigDecimal area) {
         this.area = area;
         return this;
      }

      public SplitMaterialAndPickingDetailDTO.SplitMaterialAndPickingDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public SplitMaterialAndPickingDetailDTO.SplitMaterialAndPickingDetailDTOBuilder pickingDetailId(final Long pickingDetailId) {
         this.pickingDetailId = pickingDetailId;
         return this;
      }

      public SplitMaterialAndPickingDetailDTO.SplitMaterialAndPickingDetailDTOBuilder pickingId(final Long pickingId) {
         this.pickingId = pickingId;
         return this;
      }

      public SplitMaterialAndPickingDetailDTO.SplitMaterialAndPickingDetailDTOBuilder outboundDetailId(final Long outboundDetailId) {
         this.outboundDetailId = outboundDetailId;
         return this;
      }

      public SplitMaterialAndPickingDetailDTO build() {
         return new SplitMaterialAndPickingDetailDTO(
            this.materialInventoryId, this.mete, this.actualTheoryWeight, this.area, this.length, this.pickingDetailId, this.pickingId, this.outboundDetailId
         );
      }

      @Override
      public String toString() {
         return "SplitMaterialAndPickingDetailDTO.SplitMaterialAndPickingDetailDTOBuilder(materialInventoryId="
            + this.materialInventoryId
            + ", mete="
            + this.mete
            + ", actualTheoryWeight="
            + this.actualTheoryWeight
            + ", area="
            + this.area
            + ", length="
            + this.length
            + ", pickingDetailId="
            + this.pickingDetailId
            + ", pickingId="
            + this.pickingId
            + ", outboundDetailId="
            + this.outboundDetailId
            + ")";
      }
   }
}
