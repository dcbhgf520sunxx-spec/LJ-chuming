package com.hzchum.scim.contract.core.api.pojo.dto.logistics;

import com.hzchum.scim.contract.core.api.pojo.dto.BriefIdAndSNDTO;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LoadingChargeRecordDTO implements Serializable {
   private Long id;
   private LocalDateTime inboundPassTime;
   private String licensePlate;
   private BigDecimal loadingCharge;
   private BriefIdAndSNDTO inboundReceipt;
   private BigDecimal loadingWeight;
   private BigDecimal freightWeight;
   private BriefIdAndSNDTO purchaseOrder;
   private String purchaseUserName;
   private String inboundUserName;

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getInboundPassTime() {
      return this.inboundPassTime;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public BigDecimal getLoadingCharge() {
      return this.loadingCharge;
   }

   public BriefIdAndSNDTO getInboundReceipt() {
      return this.inboundReceipt;
   }

   public BigDecimal getLoadingWeight() {
      return this.loadingWeight;
   }

   public BigDecimal getFreightWeight() {
      return this.freightWeight;
   }

   public BriefIdAndSNDTO getPurchaseOrder() {
      return this.purchaseOrder;
   }

   public String getPurchaseUserName() {
      return this.purchaseUserName;
   }

   public String getInboundUserName() {
      return this.inboundUserName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setInboundPassTime(final LocalDateTime inboundPassTime) {
      this.inboundPassTime = inboundPassTime;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setLoadingCharge(final BigDecimal loadingCharge) {
      this.loadingCharge = loadingCharge;
   }

   public void setInboundReceipt(final BriefIdAndSNDTO inboundReceipt) {
      this.inboundReceipt = inboundReceipt;
   }

   public void setLoadingWeight(final BigDecimal loadingWeight) {
      this.loadingWeight = loadingWeight;
   }

   public void setFreightWeight(final BigDecimal freightWeight) {
      this.freightWeight = freightWeight;
   }

   public void setPurchaseOrder(final BriefIdAndSNDTO purchaseOrder) {
      this.purchaseOrder = purchaseOrder;
   }

   public void setPurchaseUserName(final String purchaseUserName) {
      this.purchaseUserName = purchaseUserName;
   }

   public void setInboundUserName(final String inboundUserName) {
      this.inboundUserName = inboundUserName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LoadingChargeRecordDTO)) {
         return false;
      }

      LoadingChargeRecordDTO other = (LoadingChargeRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$inboundPassTime = this.getInboundPassTime();
         Object other$inboundPassTime = other.getInboundPassTime();
         if (this$inboundPassTime == null ? other$inboundPassTime == null : this$inboundPassTime.equals(other$inboundPassTime)) {
            Object this$licensePlate = this.getLicensePlate();
            Object other$licensePlate = other.getLicensePlate();
            if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
               Object this$loadingCharge = this.getLoadingCharge();
               Object other$loadingCharge = other.getLoadingCharge();
               if (this$loadingCharge == null ? other$loadingCharge == null : this$loadingCharge.equals(other$loadingCharge)) {
                  Object this$inboundReceipt = this.getInboundReceipt();
                  Object other$inboundReceipt = other.getInboundReceipt();
                  if (this$inboundReceipt == null ? other$inboundReceipt == null : this$inboundReceipt.equals(other$inboundReceipt)) {
                     Object this$loadingWeight = this.getLoadingWeight();
                     Object other$loadingWeight = other.getLoadingWeight();
                     if (this$loadingWeight == null ? other$loadingWeight == null : this$loadingWeight.equals(other$loadingWeight)) {
                        Object this$freightWeight = this.getFreightWeight();
                        Object other$freightWeight = other.getFreightWeight();
                        if (this$freightWeight == null ? other$freightWeight == null : this$freightWeight.equals(other$freightWeight)) {
                           Object this$purchaseOrder = this.getPurchaseOrder();
                           Object other$purchaseOrder = other.getPurchaseOrder();
                           if (this$purchaseOrder == null ? other$purchaseOrder == null : this$purchaseOrder.equals(other$purchaseOrder)) {
                              Object this$purchaseUserName = this.getPurchaseUserName();
                              Object other$purchaseUserName = other.getPurchaseUserName();
                              if (this$purchaseUserName == null ? other$purchaseUserName == null : this$purchaseUserName.equals(other$purchaseUserName)) {
                                 Object this$inboundUserName = this.getInboundUserName();
                                 Object other$inboundUserName = other.getInboundUserName();
                                 return this$inboundUserName == null ? other$inboundUserName == null : this$inboundUserName.equals(other$inboundUserName);
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
      return other instanceof LoadingChargeRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inboundPassTime = this.getInboundPassTime();
      result = result * 59 + ($inboundPassTime == null ? 43 : $inboundPassTime.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $loadingCharge = this.getLoadingCharge();
      result = result * 59 + ($loadingCharge == null ? 43 : $loadingCharge.hashCode());
      Object $inboundReceipt = this.getInboundReceipt();
      result = result * 59 + ($inboundReceipt == null ? 43 : $inboundReceipt.hashCode());
      Object $loadingWeight = this.getLoadingWeight();
      result = result * 59 + ($loadingWeight == null ? 43 : $loadingWeight.hashCode());
      Object $freightWeight = this.getFreightWeight();
      result = result * 59 + ($freightWeight == null ? 43 : $freightWeight.hashCode());
      Object $purchaseOrder = this.getPurchaseOrder();
      result = result * 59 + ($purchaseOrder == null ? 43 : $purchaseOrder.hashCode());
      Object $purchaseUserName = this.getPurchaseUserName();
      result = result * 59 + ($purchaseUserName == null ? 43 : $purchaseUserName.hashCode());
      Object $inboundUserName = this.getInboundUserName();
      return result * 59 + ($inboundUserName == null ? 43 : $inboundUserName.hashCode());
   }

   @Override
   public String toString() {
      return "LoadingChargeRecordDTO(id="
         + this.getId()
         + ", inboundPassTime="
         + this.getInboundPassTime()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", loadingCharge="
         + this.getLoadingCharge()
         + ", inboundReceipt="
         + this.getInboundReceipt()
         + ", loadingWeight="
         + this.getLoadingWeight()
         + ", freightWeight="
         + this.getFreightWeight()
         + ", purchaseOrder="
         + this.getPurchaseOrder()
         + ", purchaseUserName="
         + this.getPurchaseUserName()
         + ", inboundUserName="
         + this.getInboundUserName()
         + ")";
   }
}
