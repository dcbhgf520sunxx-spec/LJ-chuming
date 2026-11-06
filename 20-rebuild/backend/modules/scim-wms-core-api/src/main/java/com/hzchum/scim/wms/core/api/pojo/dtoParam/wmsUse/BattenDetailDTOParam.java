package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BattenDetailDTOParam {
   private BigDecimal length;
   private BigDecimal quantity;
   private BigDecimal width;
   private BigDecimal mete;
   private Long projectId;
   private Long monomerId;
   private Long areaId;
   private Long workshopId;
   private Long warehouseId;
   private Boolean boolSurplus;
   private Long recipientId;
   private Boolean boolOutbound;
   private LocalDateTime outboundTime;
   private Integer outboundAddress;

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Boolean getBoolSurplus() {
      return this.boolSurplus;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public Boolean getBoolOutbound() {
      return this.boolOutbound;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public Integer getOutboundAddress() {
      return this.outboundAddress;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setBoolSurplus(final Boolean boolSurplus) {
      this.boolSurplus = boolSurplus;
   }

   public void setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
   }

   public void setBoolOutbound(final Boolean boolOutbound) {
      this.boolOutbound = boolOutbound;
   }

   public void setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
   }

   public void setOutboundAddress(final Integer outboundAddress) {
      this.outboundAddress = outboundAddress;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BattenDetailDTOParam)) {
         return false;
      }

      BattenDetailDTOParam other = (BattenDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$workshopId = this.getWorkshopId();
               Object other$workshopId = other.getWorkshopId();
               if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                  Object this$warehouseId = this.getWarehouseId();
                  Object other$warehouseId = other.getWarehouseId();
                  if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                     Object this$boolSurplus = this.getBoolSurplus();
                     Object other$boolSurplus = other.getBoolSurplus();
                     if (this$boolSurplus == null ? other$boolSurplus == null : this$boolSurplus.equals(other$boolSurplus)) {
                        Object this$recipientId = this.getRecipientId();
                        Object other$recipientId = other.getRecipientId();
                        if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
                           Object this$boolOutbound = this.getBoolOutbound();
                           Object other$boolOutbound = other.getBoolOutbound();
                           if (this$boolOutbound == null ? other$boolOutbound == null : this$boolOutbound.equals(other$boolOutbound)) {
                              Object this$outboundAddress = this.getOutboundAddress();
                              Object other$outboundAddress = other.getOutboundAddress();
                              if (this$outboundAddress == null ? other$outboundAddress == null : this$outboundAddress.equals(other$outboundAddress)) {
                                 Object this$length = this.getLength();
                                 Object other$length = other.getLength();
                                 if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                    Object this$quantity = this.getQuantity();
                                    Object other$quantity = other.getQuantity();
                                    if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                       Object this$width = this.getWidth();
                                       Object other$width = other.getWidth();
                                       if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                          Object this$mete = this.getMete();
                                          Object other$mete = other.getMete();
                                          if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                             Object this$outboundTime = this.getOutboundTime();
                                             Object other$outboundTime = other.getOutboundTime();
                                             return this$outboundTime == null ? other$outboundTime == null : this$outboundTime.equals(other$outboundTime);
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
      return other instanceof BattenDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $boolSurplus = this.getBoolSurplus();
      result = result * 59 + ($boolSurplus == null ? 43 : $boolSurplus.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $boolOutbound = this.getBoolOutbound();
      result = result * 59 + ($boolOutbound == null ? 43 : $boolOutbound.hashCode());
      Object $outboundAddress = this.getOutboundAddress();
      result = result * 59 + ($outboundAddress == null ? 43 : $outboundAddress.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $outboundTime = this.getOutboundTime();
      return result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
   }

   @Override
   public String toString() {
      return "BattenDetailDTOParam(length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", width="
         + this.getWidth()
         + ", mete="
         + this.getMete()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", boolSurplus="
         + this.getBoolSurplus()
         + ", recipientId="
         + this.getRecipientId()
         + ", boolOutbound="
         + this.getBoolOutbound()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", outboundAddress="
         + this.getOutboundAddress()
         + ")";
   }

   public BattenDetailDTOParam(
      final BigDecimal length,
      final BigDecimal quantity,
      final BigDecimal width,
      final BigDecimal mete,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long workshopId,
      final Long warehouseId,
      final Boolean boolSurplus,
      final Long recipientId,
      final Boolean boolOutbound,
      final LocalDateTime outboundTime,
      final Integer outboundAddress
   ) {
      this.length = length;
      this.quantity = quantity;
      this.width = width;
      this.mete = mete;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.workshopId = workshopId;
      this.warehouseId = warehouseId;
      this.boolSurplus = boolSurplus;
      this.recipientId = recipientId;
      this.boolOutbound = boolOutbound;
      this.outboundTime = outboundTime;
      this.outboundAddress = outboundAddress;
   }

   public BattenDetailDTOParam() {
   }
}
