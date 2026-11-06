package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SupplierSummaryLogisticsOrderDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "purchaseId", value = "采购单ID")
   private Long purchaseId;
   @ApiModelProperty(name = "purchaseSn", value = "采购单号")
   private String purchaseSn;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型")
   private Integer basicClass;
   @ApiModelProperty(name = "serialNumber", value = "物流订单编号")
   private String serialNumber;
   @ApiModelProperty(name = "inboundId", value = "入库ID")
   private Long inboundId;
   @ApiModelProperty(name = "inboundSn", value = "入库单号")
   private String inboundSn;
   @ApiModelProperty(name = "inboundTime", value = "入库时间")
   private LocalDateTime inboundTime;
   @ApiModelProperty(name = "supplierId", value = "供应商ID")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "供应商名称")
   private String supplierName;
   @ApiModelProperty(name = "licensePlate", value = "车牌号")
   private String licensePlate;
   @ApiModelProperty(name = "loadingWeight", value = "装载重量")
   private BigDecimal loadingWeight;
   @ApiModelProperty(name = "freight", value = "运费")
   private BigDecimal freight;
   @ApiModelProperty(name = "freightWeight", value = "运重")
   private BigDecimal freightWeight;
   @ApiModelProperty(name = "changeFreight", value = "运费变更类型 默认为1正常 ChangeFreightEnum")
   private Integer changeFreight;
   @ApiModelProperty(name = "purchaseUserId", value = "采购人员id")
   private Long purchaseUserId;
   @ApiModelProperty(name = "purchaseUserName", value = "采购人员")
   private String purchaseUserName;

   public Long getId() {
      return this.id;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public String getPurchaseSn() {
      return this.purchaseSn;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public String getInboundSn() {
      return this.inboundSn;
   }

   public LocalDateTime getInboundTime() {
      return this.inboundTime;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public BigDecimal getLoadingWeight() {
      return this.loadingWeight;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public BigDecimal getFreightWeight() {
      return this.freightWeight;
   }

   public Integer getChangeFreight() {
      return this.changeFreight;
   }

   public Long getPurchaseUserId() {
      return this.purchaseUserId;
   }

   public String getPurchaseUserName() {
      return this.purchaseUserName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
   }

   public void setPurchaseSn(final String purchaseSn) {
      this.purchaseSn = purchaseSn;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
   }

   public void setInboundSn(final String inboundSn) {
      this.inboundSn = inboundSn;
   }

   public void setInboundTime(final LocalDateTime inboundTime) {
      this.inboundTime = inboundTime;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setLoadingWeight(final BigDecimal loadingWeight) {
      this.loadingWeight = loadingWeight;
   }

   public void setFreight(final BigDecimal freight) {
      this.freight = freight;
   }

   public void setFreightWeight(final BigDecimal freightWeight) {
      this.freightWeight = freightWeight;
   }

   public void setChangeFreight(final Integer changeFreight) {
      this.changeFreight = changeFreight;
   }

   public void setPurchaseUserId(final Long purchaseUserId) {
      this.purchaseUserId = purchaseUserId;
   }

   public void setPurchaseUserName(final String purchaseUserName) {
      this.purchaseUserName = purchaseUserName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierSummaryLogisticsOrderDTO)) {
         return false;
      }

      SupplierSummaryLogisticsOrderDTO other = (SupplierSummaryLogisticsOrderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$purchaseId = this.getPurchaseId();
         Object other$purchaseId = other.getPurchaseId();
         if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$inboundId = this.getInboundId();
               Object other$inboundId = other.getInboundId();
               if (this$inboundId == null ? other$inboundId == null : this$inboundId.equals(other$inboundId)) {
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$changeFreight = this.getChangeFreight();
                     Object other$changeFreight = other.getChangeFreight();
                     if (this$changeFreight == null ? other$changeFreight == null : this$changeFreight.equals(other$changeFreight)) {
                        Object this$purchaseUserId = this.getPurchaseUserId();
                        Object other$purchaseUserId = other.getPurchaseUserId();
                        if (this$purchaseUserId == null ? other$purchaseUserId == null : this$purchaseUserId.equals(other$purchaseUserId)) {
                           Object this$purchaseSn = this.getPurchaseSn();
                           Object other$purchaseSn = other.getPurchaseSn();
                           if (this$purchaseSn == null ? other$purchaseSn == null : this$purchaseSn.equals(other$purchaseSn)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$inboundSn = this.getInboundSn();
                                 Object other$inboundSn = other.getInboundSn();
                                 if (this$inboundSn == null ? other$inboundSn == null : this$inboundSn.equals(other$inboundSn)) {
                                    Object this$inboundTime = this.getInboundTime();
                                    Object other$inboundTime = other.getInboundTime();
                                    if (this$inboundTime == null ? other$inboundTime == null : this$inboundTime.equals(other$inboundTime)) {
                                       Object this$supplierName = this.getSupplierName();
                                       Object other$supplierName = other.getSupplierName();
                                       if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                          Object this$licensePlate = this.getLicensePlate();
                                          Object other$licensePlate = other.getLicensePlate();
                                          if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                                             Object this$loadingWeight = this.getLoadingWeight();
                                             Object other$loadingWeight = other.getLoadingWeight();
                                             if (this$loadingWeight == null ? other$loadingWeight == null : this$loadingWeight.equals(other$loadingWeight)) {
                                                Object this$freight = this.getFreight();
                                                Object other$freight = other.getFreight();
                                                if (this$freight == null ? other$freight == null : this$freight.equals(other$freight)) {
                                                   Object this$freightWeight = this.getFreightWeight();
                                                   Object other$freightWeight = other.getFreightWeight();
                                                   if (this$freightWeight == null
                                                      ? other$freightWeight == null
                                                      : this$freightWeight.equals(other$freightWeight)) {
                                                      Object this$purchaseUserName = this.getPurchaseUserName();
                                                      Object other$purchaseUserName = other.getPurchaseUserName();
                                                      return this$purchaseUserName == null
                                                         ? other$purchaseUserName == null
                                                         : this$purchaseUserName.equals(other$purchaseUserName);
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
      return other instanceof SupplierSummaryLogisticsOrderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $changeFreight = this.getChangeFreight();
      result = result * 59 + ($changeFreight == null ? 43 : $changeFreight.hashCode());
      Object $purchaseUserId = this.getPurchaseUserId();
      result = result * 59 + ($purchaseUserId == null ? 43 : $purchaseUserId.hashCode());
      Object $purchaseSn = this.getPurchaseSn();
      result = result * 59 + ($purchaseSn == null ? 43 : $purchaseSn.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $inboundSn = this.getInboundSn();
      result = result * 59 + ($inboundSn == null ? 43 : $inboundSn.hashCode());
      Object $inboundTime = this.getInboundTime();
      result = result * 59 + ($inboundTime == null ? 43 : $inboundTime.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $loadingWeight = this.getLoadingWeight();
      result = result * 59 + ($loadingWeight == null ? 43 : $loadingWeight.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $freightWeight = this.getFreightWeight();
      result = result * 59 + ($freightWeight == null ? 43 : $freightWeight.hashCode());
      Object $purchaseUserName = this.getPurchaseUserName();
      return result * 59 + ($purchaseUserName == null ? 43 : $purchaseUserName.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierSummaryLogisticsOrderDTO(id="
         + this.getId()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", purchaseSn="
         + this.getPurchaseSn()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", inboundId="
         + this.getInboundId()
         + ", inboundSn="
         + this.getInboundSn()
         + ", inboundTime="
         + this.getInboundTime()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", loadingWeight="
         + this.getLoadingWeight()
         + ", freight="
         + this.getFreight()
         + ", freightWeight="
         + this.getFreightWeight()
         + ", changeFreight="
         + this.getChangeFreight()
         + ", purchaseUserId="
         + this.getPurchaseUserId()
         + ", purchaseUserName="
         + this.getPurchaseUserName()
         + ")";
   }
}
