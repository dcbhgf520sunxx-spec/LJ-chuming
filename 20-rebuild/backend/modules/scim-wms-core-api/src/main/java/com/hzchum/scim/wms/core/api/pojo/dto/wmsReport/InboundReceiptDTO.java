package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.time.LocalDateTime;

public class InboundReceiptDTO {
   private Long id;
   private String serialNumber;
   private String shipmentNumber;
   private String licensePlate;
   private Long supplierId;
   private String supplierName;
   private Long purchaseId;
   private String purchaseSN;
   private BriefIdAndNameDTO supplier;
   private BriefIdAndSNDTO purchaseOrder;
   private String applicantName;
   private String editorName;
   private String reviewerName;
   private LocalDateTime inboundTime;
   private LocalDateTime createTime;
   private LocalDateTime updateTime;
   private LocalDateTime userUpdateTime;
   private LocalDateTime reviewTime;
   private Integer inboundWay;

   public static InboundReceiptDTO.InboundReceiptDTOBuilder builder() {
      return new InboundReceiptDTO.InboundReceiptDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getShipmentNumber() {
      return this.shipmentNumber;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public String getPurchaseSN() {
      return this.purchaseSN;
   }

   public BriefIdAndNameDTO getSupplier() {
      return this.supplier;
   }

   public BriefIdAndSNDTO getPurchaseOrder() {
      return this.purchaseOrder;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public String getEditorName() {
      return this.editorName;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public LocalDateTime getInboundTime() {
      return this.inboundTime;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public Integer getInboundWay() {
      return this.inboundWay;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setShipmentNumber(final String shipmentNumber) {
      this.shipmentNumber = shipmentNumber;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
   }

   public void setPurchaseSN(final String purchaseSN) {
      this.purchaseSN = purchaseSN;
   }

   public void setSupplier(final BriefIdAndNameDTO supplier) {
      this.supplier = supplier;
   }

   public void setPurchaseOrder(final BriefIdAndSNDTO purchaseOrder) {
      this.purchaseOrder = purchaseOrder;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setEditorName(final String editorName) {
      this.editorName = editorName;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setInboundTime(final LocalDateTime inboundTime) {
      this.inboundTime = inboundTime;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
   }

   public void setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setInboundWay(final Integer inboundWay) {
      this.inboundWay = inboundWay;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InboundReceiptDTO)) {
         return false;
      }

      InboundReceiptDTO other = (InboundReceiptDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$purchaseId = this.getPurchaseId();
            Object other$purchaseId = other.getPurchaseId();
            if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
               Object this$inboundWay = this.getInboundWay();
               Object other$inboundWay = other.getInboundWay();
               if (this$inboundWay == null ? other$inboundWay == null : this$inboundWay.equals(other$inboundWay)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$shipmentNumber = this.getShipmentNumber();
                     Object other$shipmentNumber = other.getShipmentNumber();
                     if (this$shipmentNumber == null ? other$shipmentNumber == null : this$shipmentNumber.equals(other$shipmentNumber)) {
                        Object this$licensePlate = this.getLicensePlate();
                        Object other$licensePlate = other.getLicensePlate();
                        if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                           Object this$supplierName = this.getSupplierName();
                           Object other$supplierName = other.getSupplierName();
                           if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                              Object this$purchaseSN = this.getPurchaseSN();
                              Object other$purchaseSN = other.getPurchaseSN();
                              if (this$purchaseSN == null ? other$purchaseSN == null : this$purchaseSN.equals(other$purchaseSN)) {
                                 Object this$supplier = this.getSupplier();
                                 Object other$supplier = other.getSupplier();
                                 if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
                                    Object this$purchaseOrder = this.getPurchaseOrder();
                                    Object other$purchaseOrder = other.getPurchaseOrder();
                                    if (this$purchaseOrder == null ? other$purchaseOrder == null : this$purchaseOrder.equals(other$purchaseOrder)) {
                                       Object this$applicantName = this.getApplicantName();
                                       Object other$applicantName = other.getApplicantName();
                                       if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                          Object this$editorName = this.getEditorName();
                                          Object other$editorName = other.getEditorName();
                                          if (this$editorName == null ? other$editorName == null : this$editorName.equals(other$editorName)) {
                                             Object this$reviewerName = this.getReviewerName();
                                             Object other$reviewerName = other.getReviewerName();
                                             if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                                                Object this$inboundTime = this.getInboundTime();
                                                Object other$inboundTime = other.getInboundTime();
                                                if (this$inboundTime == null ? other$inboundTime == null : this$inboundTime.equals(other$inboundTime)) {
                                                   Object this$createTime = this.getCreateTime();
                                                   Object other$createTime = other.getCreateTime();
                                                   if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                      Object this$updateTime = this.getUpdateTime();
                                                      Object other$updateTime = other.getUpdateTime();
                                                      if (this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime)) {
                                                         Object this$userUpdateTime = this.getUserUpdateTime();
                                                         Object other$userUpdateTime = other.getUserUpdateTime();
                                                         if (this$userUpdateTime == null
                                                            ? other$userUpdateTime == null
                                                            : this$userUpdateTime.equals(other$userUpdateTime)) {
                                                            Object this$reviewTime = this.getReviewTime();
                                                            Object other$reviewTime = other.getReviewTime();
                                                            return this$reviewTime == null
                                                               ? other$reviewTime == null
                                                               : this$reviewTime.equals(other$reviewTime);
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
      return other instanceof InboundReceiptDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $inboundWay = this.getInboundWay();
      result = result * 59 + ($inboundWay == null ? 43 : $inboundWay.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $purchaseSN = this.getPurchaseSN();
      result = result * 59 + ($purchaseSN == null ? 43 : $purchaseSN.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $purchaseOrder = this.getPurchaseOrder();
      result = result * 59 + ($purchaseOrder == null ? 43 : $purchaseOrder.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $editorName = this.getEditorName();
      result = result * 59 + ($editorName == null ? 43 : $editorName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $inboundTime = this.getInboundTime();
      result = result * 59 + ($inboundTime == null ? 43 : $inboundTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      return result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
   }

   @Override
   public String toString() {
      return "InboundReceiptDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", purchaseSN="
         + this.getPurchaseSN()
         + ", supplier="
         + this.getSupplier()
         + ", purchaseOrder="
         + this.getPurchaseOrder()
         + ", applicantName="
         + this.getApplicantName()
         + ", editorName="
         + this.getEditorName()
         + ", reviewerName="
         + this.getReviewerName()
         + ", inboundTime="
         + this.getInboundTime()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", reviewTime="
         + this.getReviewTime()
         + ", inboundWay="
         + this.getInboundWay()
         + ")";
   }

   public InboundReceiptDTO(
      final Long id,
      final String serialNumber,
      final String shipmentNumber,
      final String licensePlate,
      final Long supplierId,
      final String supplierName,
      final Long purchaseId,
      final String purchaseSN,
      final BriefIdAndNameDTO supplier,
      final BriefIdAndSNDTO purchaseOrder,
      final String applicantName,
      final String editorName,
      final String reviewerName,
      final LocalDateTime inboundTime,
      final LocalDateTime createTime,
      final LocalDateTime updateTime,
      final LocalDateTime userUpdateTime,
      final LocalDateTime reviewTime,
      final Integer inboundWay
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.shipmentNumber = shipmentNumber;
      this.licensePlate = licensePlate;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.purchaseId = purchaseId;
      this.purchaseSN = purchaseSN;
      this.supplier = supplier;
      this.purchaseOrder = purchaseOrder;
      this.applicantName = applicantName;
      this.editorName = editorName;
      this.reviewerName = reviewerName;
      this.inboundTime = inboundTime;
      this.createTime = createTime;
      this.updateTime = updateTime;
      this.userUpdateTime = userUpdateTime;
      this.reviewTime = reviewTime;
      this.inboundWay = inboundWay;
   }

   public InboundReceiptDTO() {
   }

   public static class InboundReceiptDTOBuilder {
      private Long id;
      private String serialNumber;
      private String shipmentNumber;
      private String licensePlate;
      private Long supplierId;
      private String supplierName;
      private Long purchaseId;
      private String purchaseSN;
      private BriefIdAndNameDTO supplier;
      private BriefIdAndSNDTO purchaseOrder;
      private String applicantName;
      private String editorName;
      private String reviewerName;
      private LocalDateTime inboundTime;
      private LocalDateTime createTime;
      private LocalDateTime updateTime;
      private LocalDateTime userUpdateTime;
      private LocalDateTime reviewTime;
      private Integer inboundWay;

      InboundReceiptDTOBuilder() {
      }

      public InboundReceiptDTO.InboundReceiptDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public InboundReceiptDTO.InboundReceiptDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public InboundReceiptDTO.InboundReceiptDTOBuilder shipmentNumber(final String shipmentNumber) {
         this.shipmentNumber = shipmentNumber;
         return this;
      }

      public InboundReceiptDTO.InboundReceiptDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public InboundReceiptDTO.InboundReceiptDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public InboundReceiptDTO.InboundReceiptDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public InboundReceiptDTO.InboundReceiptDTOBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      public InboundReceiptDTO.InboundReceiptDTOBuilder purchaseSN(final String purchaseSN) {
         this.purchaseSN = purchaseSN;
         return this;
      }

      public InboundReceiptDTO.InboundReceiptDTOBuilder supplier(final BriefIdAndNameDTO supplier) {
         this.supplier = supplier;
         return this;
      }

      public InboundReceiptDTO.InboundReceiptDTOBuilder purchaseOrder(final BriefIdAndSNDTO purchaseOrder) {
         this.purchaseOrder = purchaseOrder;
         return this;
      }

      public InboundReceiptDTO.InboundReceiptDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public InboundReceiptDTO.InboundReceiptDTOBuilder editorName(final String editorName) {
         this.editorName = editorName;
         return this;
      }

      public InboundReceiptDTO.InboundReceiptDTOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public InboundReceiptDTO.InboundReceiptDTOBuilder inboundTime(final LocalDateTime inboundTime) {
         this.inboundTime = inboundTime;
         return this;
      }

      public InboundReceiptDTO.InboundReceiptDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public InboundReceiptDTO.InboundReceiptDTOBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      public InboundReceiptDTO.InboundReceiptDTOBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      public InboundReceiptDTO.InboundReceiptDTOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public InboundReceiptDTO.InboundReceiptDTOBuilder inboundWay(final Integer inboundWay) {
         this.inboundWay = inboundWay;
         return this;
      }

      public InboundReceiptDTO build() {
         return new InboundReceiptDTO(
            this.id,
            this.serialNumber,
            this.shipmentNumber,
            this.licensePlate,
            this.supplierId,
            this.supplierName,
            this.purchaseId,
            this.purchaseSN,
            this.supplier,
            this.purchaseOrder,
            this.applicantName,
            this.editorName,
            this.reviewerName,
            this.inboundTime,
            this.createTime,
            this.updateTime,
            this.userUpdateTime,
            this.reviewTime,
            this.inboundWay
         );
      }

      @Override
      public String toString() {
         return "InboundReceiptDTO.InboundReceiptDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", shipmentNumber="
            + this.shipmentNumber
            + ", licensePlate="
            + this.licensePlate
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", purchaseId="
            + this.purchaseId
            + ", purchaseSN="
            + this.purchaseSN
            + ", supplier="
            + this.supplier
            + ", purchaseOrder="
            + this.purchaseOrder
            + ", applicantName="
            + this.applicantName
            + ", editorName="
            + this.editorName
            + ", reviewerName="
            + this.reviewerName
            + ", inboundTime="
            + this.inboundTime
            + ", createTime="
            + this.createTime
            + ", updateTime="
            + this.updateTime
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", reviewTime="
            + this.reviewTime
            + ", inboundWay="
            + this.inboundWay
            + ")";
      }
   }
}
