package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrder;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundManufactured;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class InboundManufacturedDTOParam {
   @ApiModelProperty("制成品入库单Id")
   private Long id;
   @ApiModelProperty("过磅重量")
   private BigDecimal loadingWeight;
   @ApiModelProperty("物流信息")
   private LogisticsOrder logistics;
   @ApiModelProperty("采购订单ID")
   private Long purchaseId;
   @ApiModelProperty("车牌号")
   private String licensePlate;
   @ApiModelProperty("物流单号")
   private String shipmentNumber;
   @ApiModelProperty("入库单编号")
   private String serialNumber;
   @ApiModelProperty("制成品入库详情")
   List<InboundDetailManufacturedDTOParam> list;
   @ApiModelProperty("入库主对象 -> 后端自用")
   private InboundManufactured inboundManufactured;
   @ApiModelProperty("入库明细集合 -> 后端自用")
   private List<InboundDetailManufactured> inboundDetailManufactureds;
   @ApiModelProperty("发起审批事由")
   private String cause;
   @ApiModelProperty("审核状态")
   private Integer reviewStatus;

   public Long getId() {
      return this.id;
   }

   public BigDecimal getLoadingWeight() {
      return this.loadingWeight;
   }

   public LogisticsOrder getLogistics() {
      return this.logistics;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getShipmentNumber() {
      return this.shipmentNumber;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public List<InboundDetailManufacturedDTOParam> getList() {
      return this.list;
   }

   public InboundManufactured getInboundManufactured() {
      return this.inboundManufactured;
   }

   public List<InboundDetailManufactured> getInboundDetailManufactureds() {
      return this.inboundDetailManufactureds;
   }

   public String getCause() {
      return this.cause;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setLoadingWeight(final BigDecimal loadingWeight) {
      this.loadingWeight = loadingWeight;
   }

   public void setLogistics(final LogisticsOrder logistics) {
      this.logistics = logistics;
   }

   public void setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setShipmentNumber(final String shipmentNumber) {
      this.shipmentNumber = shipmentNumber;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setList(final List<InboundDetailManufacturedDTOParam> list) {
      this.list = list;
   }

   public void setInboundManufactured(final InboundManufactured inboundManufactured) {
      this.inboundManufactured = inboundManufactured;
   }

   public void setInboundDetailManufactureds(final List<InboundDetailManufactured> inboundDetailManufactureds) {
      this.inboundDetailManufactureds = inboundDetailManufactureds;
   }

   public void setCause(final String cause) {
      this.cause = cause;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InboundManufacturedDTOParam)) {
         return false;
      }

      InboundManufacturedDTOParam other = (InboundManufacturedDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$purchaseId = this.getPurchaseId();
         Object other$purchaseId = other.getPurchaseId();
         if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
            Object this$reviewStatus = this.getReviewStatus();
            Object other$reviewStatus = other.getReviewStatus();
            if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
               Object this$loadingWeight = this.getLoadingWeight();
               Object other$loadingWeight = other.getLoadingWeight();
               if (this$loadingWeight == null ? other$loadingWeight == null : this$loadingWeight.equals(other$loadingWeight)) {
                  Object this$logistics = this.getLogistics();
                  Object other$logistics = other.getLogistics();
                  if (this$logistics == null ? other$logistics == null : this$logistics.equals(other$logistics)) {
                     Object this$licensePlate = this.getLicensePlate();
                     Object other$licensePlate = other.getLicensePlate();
                     if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                        Object this$shipmentNumber = this.getShipmentNumber();
                        Object other$shipmentNumber = other.getShipmentNumber();
                        if (this$shipmentNumber == null ? other$shipmentNumber == null : this$shipmentNumber.equals(other$shipmentNumber)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$list = this.getList();
                              Object other$list = other.getList();
                              if (this$list == null ? other$list == null : this$list.equals(other$list)) {
                                 Object this$inboundManufactured = this.getInboundManufactured();
                                 Object other$inboundManufactured = other.getInboundManufactured();
                                 if (this$inboundManufactured == null
                                    ? other$inboundManufactured == null
                                    : this$inboundManufactured.equals(other$inboundManufactured)) {
                                    Object this$inboundDetailManufactureds = this.getInboundDetailManufactureds();
                                    Object other$inboundDetailManufactureds = other.getInboundDetailManufactureds();
                                    if (this$inboundDetailManufactureds == null
                                       ? other$inboundDetailManufactureds == null
                                       : this$inboundDetailManufactureds.equals(other$inboundDetailManufactureds)) {
                                       Object this$cause = this.getCause();
                                       Object other$cause = other.getCause();
                                       return this$cause == null ? other$cause == null : this$cause.equals(other$cause);
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
      return other instanceof InboundManufacturedDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $loadingWeight = this.getLoadingWeight();
      result = result * 59 + ($loadingWeight == null ? 43 : $loadingWeight.hashCode());
      Object $logistics = this.getLogistics();
      result = result * 59 + ($logistics == null ? 43 : $logistics.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $list = this.getList();
      result = result * 59 + ($list == null ? 43 : $list.hashCode());
      Object $inboundManufactured = this.getInboundManufactured();
      result = result * 59 + ($inboundManufactured == null ? 43 : $inboundManufactured.hashCode());
      Object $inboundDetailManufactureds = this.getInboundDetailManufactureds();
      result = result * 59 + ($inboundDetailManufactureds == null ? 43 : $inboundDetailManufactureds.hashCode());
      Object $cause = this.getCause();
      return result * 59 + ($cause == null ? 43 : $cause.hashCode());
   }

   @Override
   public String toString() {
      return "InboundManufacturedDTOParam(id="
         + this.getId()
         + ", loadingWeight="
         + this.getLoadingWeight()
         + ", logistics="
         + this.getLogistics()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", list="
         + this.getList()
         + ", inboundManufactured="
         + this.getInboundManufactured()
         + ", inboundDetailManufactureds="
         + this.getInboundDetailManufactureds()
         + ", cause="
         + this.getCause()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ")";
   }
}
