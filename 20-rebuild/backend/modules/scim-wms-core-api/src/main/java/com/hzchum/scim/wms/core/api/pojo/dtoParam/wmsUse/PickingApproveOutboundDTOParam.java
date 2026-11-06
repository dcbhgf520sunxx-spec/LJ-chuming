package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;

public class PickingApproveOutboundDTOParam {
   private Long pickingDetailId;
   private Long pickingId;
   private Long materialId;
   private Long projectId;
   private Long mesWorkshopId;
   private Long recipientId;
   private BigDecimal quantity;
   private Long outboundDetailId;
   private Long outboundId;
   private BigDecimal outboundQuantity;
   private BigDecimal outboundMete;
   private BigDecimal outboundArea;
   private BigDecimal outboundLength;
   private Boolean boolSplit;
   private BigDecimal actualTheoryWeight;

   public static PickingApproveOutboundDTOParam.PickingApproveOutboundDTOParamBuilder builder() {
      return new PickingApproveOutboundDTOParam.PickingApproveOutboundDTOParamBuilder();
   }

   public Long getPickingDetailId() {
      return this.pickingDetailId;
   }

   public Long getPickingId() {
      return this.pickingId;
   }

   public Long getMaterialId() {
      return this.materialId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMesWorkshopId() {
      return this.mesWorkshopId;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Long getOutboundDetailId() {
      return this.outboundDetailId;
   }

   public Long getOutboundId() {
      return this.outboundId;
   }

   public BigDecimal getOutboundQuantity() {
      return this.outboundQuantity;
   }

   public BigDecimal getOutboundMete() {
      return this.outboundMete;
   }

   public BigDecimal getOutboundArea() {
      return this.outboundArea;
   }

   public BigDecimal getOutboundLength() {
      return this.outboundLength;
   }

   public Boolean getBoolSplit() {
      return this.boolSplit;
   }

   public BigDecimal getActualTheoryWeight() {
      return this.actualTheoryWeight;
   }

   public void setPickingDetailId(final Long pickingDetailId) {
      this.pickingDetailId = pickingDetailId;
   }

   public void setPickingId(final Long pickingId) {
      this.pickingId = pickingId;
   }

   public void setMaterialId(final Long materialId) {
      this.materialId = materialId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMesWorkshopId(final Long mesWorkshopId) {
      this.mesWorkshopId = mesWorkshopId;
   }

   public void setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setOutboundDetailId(final Long outboundDetailId) {
      this.outboundDetailId = outboundDetailId;
   }

   public void setOutboundId(final Long outboundId) {
      this.outboundId = outboundId;
   }

   public void setOutboundQuantity(final BigDecimal outboundQuantity) {
      this.outboundQuantity = outboundQuantity;
   }

   public void setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
   }

   public void setOutboundArea(final BigDecimal outboundArea) {
      this.outboundArea = outboundArea;
   }

   public void setOutboundLength(final BigDecimal outboundLength) {
      this.outboundLength = outboundLength;
   }

   public void setBoolSplit(final Boolean boolSplit) {
      this.boolSplit = boolSplit;
   }

   public void setActualTheoryWeight(final BigDecimal actualTheoryWeight) {
      this.actualTheoryWeight = actualTheoryWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PickingApproveOutboundDTOParam)) {
         return false;
      }

      PickingApproveOutboundDTOParam other = (PickingApproveOutboundDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$pickingDetailId = this.getPickingDetailId();
      Object other$pickingDetailId = other.getPickingDetailId();
      if (this$pickingDetailId == null ? other$pickingDetailId == null : this$pickingDetailId.equals(other$pickingDetailId)) {
         Object this$pickingId = this.getPickingId();
         Object other$pickingId = other.getPickingId();
         if (this$pickingId == null ? other$pickingId == null : this$pickingId.equals(other$pickingId)) {
            Object this$materialId = this.getMaterialId();
            Object other$materialId = other.getMaterialId();
            if (this$materialId == null ? other$materialId == null : this$materialId.equals(other$materialId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$mesWorkshopId = this.getMesWorkshopId();
                  Object other$mesWorkshopId = other.getMesWorkshopId();
                  if (this$mesWorkshopId == null ? other$mesWorkshopId == null : this$mesWorkshopId.equals(other$mesWorkshopId)) {
                     Object this$recipientId = this.getRecipientId();
                     Object other$recipientId = other.getRecipientId();
                     if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
                        Object this$outboundDetailId = this.getOutboundDetailId();
                        Object other$outboundDetailId = other.getOutboundDetailId();
                        if (this$outboundDetailId == null ? other$outboundDetailId == null : this$outboundDetailId.equals(other$outboundDetailId)) {
                           Object this$outboundId = this.getOutboundId();
                           Object other$outboundId = other.getOutboundId();
                           if (this$outboundId == null ? other$outboundId == null : this$outboundId.equals(other$outboundId)) {
                              Object this$boolSplit = this.getBoolSplit();
                              Object other$boolSplit = other.getBoolSplit();
                              if (this$boolSplit == null ? other$boolSplit == null : this$boolSplit.equals(other$boolSplit)) {
                                 Object this$quantity = this.getQuantity();
                                 Object other$quantity = other.getQuantity();
                                 if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                    Object this$outboundQuantity = this.getOutboundQuantity();
                                    Object other$outboundQuantity = other.getOutboundQuantity();
                                    if (this$outboundQuantity == null ? other$outboundQuantity == null : this$outboundQuantity.equals(other$outboundQuantity)) {
                                       Object this$outboundMete = this.getOutboundMete();
                                       Object other$outboundMete = other.getOutboundMete();
                                       if (this$outboundMete == null ? other$outboundMete == null : this$outboundMete.equals(other$outboundMete)) {
                                          Object this$outboundArea = this.getOutboundArea();
                                          Object other$outboundArea = other.getOutboundArea();
                                          if (this$outboundArea == null ? other$outboundArea == null : this$outboundArea.equals(other$outboundArea)) {
                                             Object this$outboundLength = this.getOutboundLength();
                                             Object other$outboundLength = other.getOutboundLength();
                                             if (this$outboundLength == null ? other$outboundLength == null : this$outboundLength.equals(other$outboundLength)) {
                                                Object this$actualTheoryWeight = this.getActualTheoryWeight();
                                                Object other$actualTheoryWeight = other.getActualTheoryWeight();
                                                return this$actualTheoryWeight == null
                                                   ? other$actualTheoryWeight == null
                                                   : this$actualTheoryWeight.equals(other$actualTheoryWeight);
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
      return other instanceof PickingApproveOutboundDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $pickingDetailId = this.getPickingDetailId();
      result = result * 59 + ($pickingDetailId == null ? 43 : $pickingDetailId.hashCode());
      Object $pickingId = this.getPickingId();
      result = result * 59 + ($pickingId == null ? 43 : $pickingId.hashCode());
      Object $materialId = this.getMaterialId();
      result = result * 59 + ($materialId == null ? 43 : $materialId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $mesWorkshopId = this.getMesWorkshopId();
      result = result * 59 + ($mesWorkshopId == null ? 43 : $mesWorkshopId.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $outboundDetailId = this.getOutboundDetailId();
      result = result * 59 + ($outboundDetailId == null ? 43 : $outboundDetailId.hashCode());
      Object $outboundId = this.getOutboundId();
      result = result * 59 + ($outboundId == null ? 43 : $outboundId.hashCode());
      Object $boolSplit = this.getBoolSplit();
      result = result * 59 + ($boolSplit == null ? 43 : $boolSplit.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $outboundQuantity = this.getOutboundQuantity();
      result = result * 59 + ($outboundQuantity == null ? 43 : $outboundQuantity.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $outboundArea = this.getOutboundArea();
      result = result * 59 + ($outboundArea == null ? 43 : $outboundArea.hashCode());
      Object $outboundLength = this.getOutboundLength();
      result = result * 59 + ($outboundLength == null ? 43 : $outboundLength.hashCode());
      Object $actualTheoryWeight = this.getActualTheoryWeight();
      return result * 59 + ($actualTheoryWeight == null ? 43 : $actualTheoryWeight.hashCode());
   }

   @Override
   public String toString() {
      return "PickingApproveOutboundDTOParam(pickingDetailId="
         + this.getPickingDetailId()
         + ", pickingId="
         + this.getPickingId()
         + ", materialId="
         + this.getMaterialId()
         + ", projectId="
         + this.getProjectId()
         + ", mesWorkshopId="
         + this.getMesWorkshopId()
         + ", recipientId="
         + this.getRecipientId()
         + ", quantity="
         + this.getQuantity()
         + ", outboundDetailId="
         + this.getOutboundDetailId()
         + ", outboundId="
         + this.getOutboundId()
         + ", outboundQuantity="
         + this.getOutboundQuantity()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", outboundArea="
         + this.getOutboundArea()
         + ", outboundLength="
         + this.getOutboundLength()
         + ", boolSplit="
         + this.getBoolSplit()
         + ", actualTheoryWeight="
         + this.getActualTheoryWeight()
         + ")";
   }

   public PickingApproveOutboundDTOParam(
      final Long pickingDetailId,
      final Long pickingId,
      final Long materialId,
      final Long projectId,
      final Long mesWorkshopId,
      final Long recipientId,
      final BigDecimal quantity,
      final Long outboundDetailId,
      final Long outboundId,
      final BigDecimal outboundQuantity,
      final BigDecimal outboundMete,
      final BigDecimal outboundArea,
      final BigDecimal outboundLength,
      final Boolean boolSplit,
      final BigDecimal actualTheoryWeight
   ) {
      this.pickingDetailId = pickingDetailId;
      this.pickingId = pickingId;
      this.materialId = materialId;
      this.projectId = projectId;
      this.mesWorkshopId = mesWorkshopId;
      this.recipientId = recipientId;
      this.quantity = quantity;
      this.outboundDetailId = outboundDetailId;
      this.outboundId = outboundId;
      this.outboundQuantity = outboundQuantity;
      this.outboundMete = outboundMete;
      this.outboundArea = outboundArea;
      this.outboundLength = outboundLength;
      this.boolSplit = boolSplit;
      this.actualTheoryWeight = actualTheoryWeight;
   }

   public PickingApproveOutboundDTOParam() {
   }

   public static class PickingApproveOutboundDTOParamBuilder {
      private Long pickingDetailId;
      private Long pickingId;
      private Long materialId;
      private Long projectId;
      private Long mesWorkshopId;
      private Long recipientId;
      private BigDecimal quantity;
      private Long outboundDetailId;
      private Long outboundId;
      private BigDecimal outboundQuantity;
      private BigDecimal outboundMete;
      private BigDecimal outboundArea;
      private BigDecimal outboundLength;
      private Boolean boolSplit;
      private BigDecimal actualTheoryWeight;

      PickingApproveOutboundDTOParamBuilder() {
      }

      public PickingApproveOutboundDTOParam.PickingApproveOutboundDTOParamBuilder pickingDetailId(final Long pickingDetailId) {
         this.pickingDetailId = pickingDetailId;
         return this;
      }

      public PickingApproveOutboundDTOParam.PickingApproveOutboundDTOParamBuilder pickingId(final Long pickingId) {
         this.pickingId = pickingId;
         return this;
      }

      public PickingApproveOutboundDTOParam.PickingApproveOutboundDTOParamBuilder materialId(final Long materialId) {
         this.materialId = materialId;
         return this;
      }

      public PickingApproveOutboundDTOParam.PickingApproveOutboundDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public PickingApproveOutboundDTOParam.PickingApproveOutboundDTOParamBuilder mesWorkshopId(final Long mesWorkshopId) {
         this.mesWorkshopId = mesWorkshopId;
         return this;
      }

      public PickingApproveOutboundDTOParam.PickingApproveOutboundDTOParamBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      public PickingApproveOutboundDTOParam.PickingApproveOutboundDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public PickingApproveOutboundDTOParam.PickingApproveOutboundDTOParamBuilder outboundDetailId(final Long outboundDetailId) {
         this.outboundDetailId = outboundDetailId;
         return this;
      }

      public PickingApproveOutboundDTOParam.PickingApproveOutboundDTOParamBuilder outboundId(final Long outboundId) {
         this.outboundId = outboundId;
         return this;
      }

      public PickingApproveOutboundDTOParam.PickingApproveOutboundDTOParamBuilder outboundQuantity(final BigDecimal outboundQuantity) {
         this.outboundQuantity = outboundQuantity;
         return this;
      }

      public PickingApproveOutboundDTOParam.PickingApproveOutboundDTOParamBuilder outboundMete(final BigDecimal outboundMete) {
         this.outboundMete = outboundMete;
         return this;
      }

      public PickingApproveOutboundDTOParam.PickingApproveOutboundDTOParamBuilder outboundArea(final BigDecimal outboundArea) {
         this.outboundArea = outboundArea;
         return this;
      }

      public PickingApproveOutboundDTOParam.PickingApproveOutboundDTOParamBuilder outboundLength(final BigDecimal outboundLength) {
         this.outboundLength = outboundLength;
         return this;
      }

      public PickingApproveOutboundDTOParam.PickingApproveOutboundDTOParamBuilder boolSplit(final Boolean boolSplit) {
         this.boolSplit = boolSplit;
         return this;
      }

      public PickingApproveOutboundDTOParam.PickingApproveOutboundDTOParamBuilder actualTheoryWeight(final BigDecimal actualTheoryWeight) {
         this.actualTheoryWeight = actualTheoryWeight;
         return this;
      }

      public PickingApproveOutboundDTOParam build() {
         return new PickingApproveOutboundDTOParam(
            this.pickingDetailId,
            this.pickingId,
            this.materialId,
            this.projectId,
            this.mesWorkshopId,
            this.recipientId,
            this.quantity,
            this.outboundDetailId,
            this.outboundId,
            this.outboundQuantity,
            this.outboundMete,
            this.outboundArea,
            this.outboundLength,
            this.boolSplit,
            this.actualTheoryWeight
         );
      }

      @Override
      public String toString() {
         return "PickingApproveOutboundDTOParam.PickingApproveOutboundDTOParamBuilder(pickingDetailId="
            + this.pickingDetailId
            + ", pickingId="
            + this.pickingId
            + ", materialId="
            + this.materialId
            + ", projectId="
            + this.projectId
            + ", mesWorkshopId="
            + this.mesWorkshopId
            + ", recipientId="
            + this.recipientId
            + ", quantity="
            + this.quantity
            + ", outboundDetailId="
            + this.outboundDetailId
            + ", outboundId="
            + this.outboundId
            + ", outboundQuantity="
            + this.outboundQuantity
            + ", outboundMete="
            + this.outboundMete
            + ", outboundArea="
            + this.outboundArea
            + ", outboundLength="
            + this.outboundLength
            + ", boolSplit="
            + this.boolSplit
            + ", actualTheoryWeight="
            + this.actualTheoryWeight
            + ")";
      }
   }
}
