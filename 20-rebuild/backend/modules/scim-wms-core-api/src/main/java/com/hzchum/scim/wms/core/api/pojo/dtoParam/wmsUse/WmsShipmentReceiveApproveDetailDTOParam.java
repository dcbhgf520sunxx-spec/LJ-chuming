package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;

public class WmsShipmentReceiveApproveDetailDTOParam {
   private Long detailId;
   private String detailName;
   private Long materialId;
   private Long projectId;
   private Long mesWorkshopId;
   private Long recipientId;
   private BigDecimal quantity;
   private Long outboundDetailId;
   private Long outboundId;
   private BigDecimal outboundQuantity;
   private BigDecimal outboundMete;
   private Integer outboundAddress;
   private BigDecimal unitNet;
   private Long workshopId;
   private Long warehouseId;
   private String remark;

   public static WmsShipmentReceiveApproveDetailDTOParam.WmsShipmentReceiveApproveDetailDTOParamBuilder builder() {
      return new WmsShipmentReceiveApproveDetailDTOParam.WmsShipmentReceiveApproveDetailDTOParamBuilder();
   }

   public Long getDetailId() {
      return this.detailId;
   }

   public String getDetailName() {
      return this.detailName;
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

   public Integer getOutboundAddress() {
      return this.outboundAddress;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setDetailId(final Long detailId) {
      this.detailId = detailId;
   }

   public void setDetailName(final String detailName) {
      this.detailName = detailName;
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

   public void setOutboundAddress(final Integer outboundAddress) {
      this.outboundAddress = outboundAddress;
   }

   public void setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsShipmentReceiveApproveDetailDTOParam)) {
         return false;
      }

      WmsShipmentReceiveApproveDetailDTOParam other = (WmsShipmentReceiveApproveDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$detailId = this.getDetailId();
      Object other$detailId = other.getDetailId();
      if (this$detailId == null ? other$detailId == null : this$detailId.equals(other$detailId)) {
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
                           Object this$outboundAddress = this.getOutboundAddress();
                           Object other$outboundAddress = other.getOutboundAddress();
                           if (this$outboundAddress == null ? other$outboundAddress == null : this$outboundAddress.equals(other$outboundAddress)) {
                              Object this$workshopId = this.getWorkshopId();
                              Object other$workshopId = other.getWorkshopId();
                              if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                 Object this$warehouseId = this.getWarehouseId();
                                 Object other$warehouseId = other.getWarehouseId();
                                 if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                    Object this$detailName = this.getDetailName();
                                    Object other$detailName = other.getDetailName();
                                    if (this$detailName == null ? other$detailName == null : this$detailName.equals(other$detailName)) {
                                       Object this$quantity = this.getQuantity();
                                       Object other$quantity = other.getQuantity();
                                       if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                          Object this$outboundQuantity = this.getOutboundQuantity();
                                          Object other$outboundQuantity = other.getOutboundQuantity();
                                          if (this$outboundQuantity == null
                                             ? other$outboundQuantity == null
                                             : this$outboundQuantity.equals(other$outboundQuantity)) {
                                             Object this$outboundMete = this.getOutboundMete();
                                             Object other$outboundMete = other.getOutboundMete();
                                             if (this$outboundMete == null ? other$outboundMete == null : this$outboundMete.equals(other$outboundMete)) {
                                                Object this$unitNet = this.getUnitNet();
                                                Object other$unitNet = other.getUnitNet();
                                                if (this$unitNet == null ? other$unitNet == null : this$unitNet.equals(other$unitNet)) {
                                                   Object this$remark = this.getRemark();
                                                   Object other$remark = other.getRemark();
                                                   return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WmsShipmentReceiveApproveDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $detailId = this.getDetailId();
      result = result * 59 + ($detailId == null ? 43 : $detailId.hashCode());
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
      Object $outboundAddress = this.getOutboundAddress();
      result = result * 59 + ($outboundAddress == null ? 43 : $outboundAddress.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $detailName = this.getDetailName();
      result = result * 59 + ($detailName == null ? 43 : $detailName.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $outboundQuantity = this.getOutboundQuantity();
      result = result * 59 + ($outboundQuantity == null ? 43 : $outboundQuantity.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "WmsShipmentReceiveApproveDetailDTOParam(detailId="
         + this.getDetailId()
         + ", detailName="
         + this.getDetailName()
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
         + ", outboundAddress="
         + this.getOutboundAddress()
         + ", unitNet="
         + this.getUnitNet()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public WmsShipmentReceiveApproveDetailDTOParam(
      final Long detailId,
      final String detailName,
      final Long materialId,
      final Long projectId,
      final Long mesWorkshopId,
      final Long recipientId,
      final BigDecimal quantity,
      final Long outboundDetailId,
      final Long outboundId,
      final BigDecimal outboundQuantity,
      final BigDecimal outboundMete,
      final Integer outboundAddress,
      final BigDecimal unitNet,
      final Long workshopId,
      final Long warehouseId,
      final String remark
   ) {
      this.detailId = detailId;
      this.detailName = detailName;
      this.materialId = materialId;
      this.projectId = projectId;
      this.mesWorkshopId = mesWorkshopId;
      this.recipientId = recipientId;
      this.quantity = quantity;
      this.outboundDetailId = outboundDetailId;
      this.outboundId = outboundId;
      this.outboundQuantity = outboundQuantity;
      this.outboundMete = outboundMete;
      this.outboundAddress = outboundAddress;
      this.unitNet = unitNet;
      this.workshopId = workshopId;
      this.warehouseId = warehouseId;
      this.remark = remark;
   }

   public WmsShipmentReceiveApproveDetailDTOParam() {
   }

   public static class WmsShipmentReceiveApproveDetailDTOParamBuilder {
      private Long detailId;
      private String detailName;
      private Long materialId;
      private Long projectId;
      private Long mesWorkshopId;
      private Long recipientId;
      private BigDecimal quantity;
      private Long outboundDetailId;
      private Long outboundId;
      private BigDecimal outboundQuantity;
      private BigDecimal outboundMete;
      private Integer outboundAddress;
      private BigDecimal unitNet;
      private Long workshopId;
      private Long warehouseId;
      private String remark;

      WmsShipmentReceiveApproveDetailDTOParamBuilder() {
      }

      public WmsShipmentReceiveApproveDetailDTOParam.WmsShipmentReceiveApproveDetailDTOParamBuilder detailId(final Long detailId) {
         this.detailId = detailId;
         return this;
      }

      public WmsShipmentReceiveApproveDetailDTOParam.WmsShipmentReceiveApproveDetailDTOParamBuilder detailName(final String detailName) {
         this.detailName = detailName;
         return this;
      }

      public WmsShipmentReceiveApproveDetailDTOParam.WmsShipmentReceiveApproveDetailDTOParamBuilder materialId(final Long materialId) {
         this.materialId = materialId;
         return this;
      }

      public WmsShipmentReceiveApproveDetailDTOParam.WmsShipmentReceiveApproveDetailDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public WmsShipmentReceiveApproveDetailDTOParam.WmsShipmentReceiveApproveDetailDTOParamBuilder mesWorkshopId(final Long mesWorkshopId) {
         this.mesWorkshopId = mesWorkshopId;
         return this;
      }

      public WmsShipmentReceiveApproveDetailDTOParam.WmsShipmentReceiveApproveDetailDTOParamBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      public WmsShipmentReceiveApproveDetailDTOParam.WmsShipmentReceiveApproveDetailDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public WmsShipmentReceiveApproveDetailDTOParam.WmsShipmentReceiveApproveDetailDTOParamBuilder outboundDetailId(final Long outboundDetailId) {
         this.outboundDetailId = outboundDetailId;
         return this;
      }

      public WmsShipmentReceiveApproveDetailDTOParam.WmsShipmentReceiveApproveDetailDTOParamBuilder outboundId(final Long outboundId) {
         this.outboundId = outboundId;
         return this;
      }

      public WmsShipmentReceiveApproveDetailDTOParam.WmsShipmentReceiveApproveDetailDTOParamBuilder outboundQuantity(final BigDecimal outboundQuantity) {
         this.outboundQuantity = outboundQuantity;
         return this;
      }

      public WmsShipmentReceiveApproveDetailDTOParam.WmsShipmentReceiveApproveDetailDTOParamBuilder outboundMete(final BigDecimal outboundMete) {
         this.outboundMete = outboundMete;
         return this;
      }

      public WmsShipmentReceiveApproveDetailDTOParam.WmsShipmentReceiveApproveDetailDTOParamBuilder outboundAddress(final Integer outboundAddress) {
         this.outboundAddress = outboundAddress;
         return this;
      }

      public WmsShipmentReceiveApproveDetailDTOParam.WmsShipmentReceiveApproveDetailDTOParamBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      public WmsShipmentReceiveApproveDetailDTOParam.WmsShipmentReceiveApproveDetailDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public WmsShipmentReceiveApproveDetailDTOParam.WmsShipmentReceiveApproveDetailDTOParamBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public WmsShipmentReceiveApproveDetailDTOParam.WmsShipmentReceiveApproveDetailDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public WmsShipmentReceiveApproveDetailDTOParam build() {
         return new WmsShipmentReceiveApproveDetailDTOParam(
            this.detailId,
            this.detailName,
            this.materialId,
            this.projectId,
            this.mesWorkshopId,
            this.recipientId,
            this.quantity,
            this.outboundDetailId,
            this.outboundId,
            this.outboundQuantity,
            this.outboundMete,
            this.outboundAddress,
            this.unitNet,
            this.workshopId,
            this.warehouseId,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "WmsShipmentReceiveApproveDetailDTOParam.WmsShipmentReceiveApproveDetailDTOParamBuilder(detailId="
            + this.detailId
            + ", detailName="
            + this.detailName
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
            + ", outboundAddress="
            + this.outboundAddress
            + ", unitNet="
            + this.unitNet
            + ", workshopId="
            + this.workshopId
            + ", warehouseId="
            + this.warehouseId
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
