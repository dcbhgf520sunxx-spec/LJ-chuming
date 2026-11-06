package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrder;
import java.math.BigDecimal;
import java.util.List;

public class ManufacturesInboundDTOParam {
   private Long id;
   private String licensePlate;
   private String shipmentNumber;
   private Integer basicClass;
   private LogisticsOrder logistics;
   private Long orderId;
   private String orderSn;
   private Long projectId;
   private Long supplierId;
   private Long logisticsSupplierId;
   private BigDecimal loadingWeight;
   List<ManufacturesInboundDetailDTOParam> list;

   public static ManufacturesInboundDTOParam.ManufacturesInboundDTOParamBuilder builder() {
      return new ManufacturesInboundDTOParam.ManufacturesInboundDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getShipmentNumber() {
      return this.shipmentNumber;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public LogisticsOrder getLogistics() {
      return this.logistics;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public String getOrderSn() {
      return this.orderSn;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getLogisticsSupplierId() {
      return this.logisticsSupplierId;
   }

   public BigDecimal getLoadingWeight() {
      return this.loadingWeight;
   }

   public List<ManufacturesInboundDetailDTOParam> getList() {
      return this.list;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setShipmentNumber(final String shipmentNumber) {
      this.shipmentNumber = shipmentNumber;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setLogistics(final LogisticsOrder logistics) {
      this.logistics = logistics;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setOrderSn(final String orderSn) {
      this.orderSn = orderSn;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setLogisticsSupplierId(final Long logisticsSupplierId) {
      this.logisticsSupplierId = logisticsSupplierId;
   }

   public void setLoadingWeight(final BigDecimal loadingWeight) {
      this.loadingWeight = loadingWeight;
   }

   public void setList(final List<ManufacturesInboundDetailDTOParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ManufacturesInboundDTOParam)) {
         return false;
      }

      ManufacturesInboundDTOParam other = (ManufacturesInboundDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$orderId = this.getOrderId();
            Object other$orderId = other.getOrderId();
            if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$logisticsSupplierId = this.getLogisticsSupplierId();
                     Object other$logisticsSupplierId = other.getLogisticsSupplierId();
                     if (this$logisticsSupplierId == null ? other$logisticsSupplierId == null : this$logisticsSupplierId.equals(other$logisticsSupplierId)) {
                        Object this$licensePlate = this.getLicensePlate();
                        Object other$licensePlate = other.getLicensePlate();
                        if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                           Object this$shipmentNumber = this.getShipmentNumber();
                           Object other$shipmentNumber = other.getShipmentNumber();
                           if (this$shipmentNumber == null ? other$shipmentNumber == null : this$shipmentNumber.equals(other$shipmentNumber)) {
                              Object this$logistics = this.getLogistics();
                              Object other$logistics = other.getLogistics();
                              if (this$logistics == null ? other$logistics == null : this$logistics.equals(other$logistics)) {
                                 Object this$orderSn = this.getOrderSn();
                                 Object other$orderSn = other.getOrderSn();
                                 if (this$orderSn == null ? other$orderSn == null : this$orderSn.equals(other$orderSn)) {
                                    Object this$loadingWeight = this.getLoadingWeight();
                                    Object other$loadingWeight = other.getLoadingWeight();
                                    if (this$loadingWeight == null ? other$loadingWeight == null : this$loadingWeight.equals(other$loadingWeight)) {
                                       Object this$list = this.getList();
                                       Object other$list = other.getList();
                                       return this$list == null ? other$list == null : this$list.equals(other$list);
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
      return other instanceof ManufacturesInboundDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $logisticsSupplierId = this.getLogisticsSupplierId();
      result = result * 59 + ($logisticsSupplierId == null ? 43 : $logisticsSupplierId.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $logistics = this.getLogistics();
      result = result * 59 + ($logistics == null ? 43 : $logistics.hashCode());
      Object $orderSn = this.getOrderSn();
      result = result * 59 + ($orderSn == null ? 43 : $orderSn.hashCode());
      Object $loadingWeight = this.getLoadingWeight();
      result = result * 59 + ($loadingWeight == null ? 43 : $loadingWeight.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "ManufacturesInboundDTOParam(id="
         + this.getId()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", basicClass="
         + this.getBasicClass()
         + ", logistics="
         + this.getLogistics()
         + ", orderId="
         + this.getOrderId()
         + ", orderSn="
         + this.getOrderSn()
         + ", projectId="
         + this.getProjectId()
         + ", supplierId="
         + this.getSupplierId()
         + ", logisticsSupplierId="
         + this.getLogisticsSupplierId()
         + ", loadingWeight="
         + this.getLoadingWeight()
         + ", list="
         + this.getList()
         + ")";
   }

   public ManufacturesInboundDTOParam(
      final Long id,
      final String licensePlate,
      final String shipmentNumber,
      final Integer basicClass,
      final LogisticsOrder logistics,
      final Long orderId,
      final String orderSn,
      final Long projectId,
      final Long supplierId,
      final Long logisticsSupplierId,
      final BigDecimal loadingWeight,
      final List<ManufacturesInboundDetailDTOParam> list
   ) {
      this.id = id;
      this.licensePlate = licensePlate;
      this.shipmentNumber = shipmentNumber;
      this.basicClass = basicClass;
      this.logistics = logistics;
      this.orderId = orderId;
      this.orderSn = orderSn;
      this.projectId = projectId;
      this.supplierId = supplierId;
      this.logisticsSupplierId = logisticsSupplierId;
      this.loadingWeight = loadingWeight;
      this.list = list;
   }

   public ManufacturesInboundDTOParam() {
   }

   public static class ManufacturesInboundDTOParamBuilder {
      private Long id;
      private String licensePlate;
      private String shipmentNumber;
      private Integer basicClass;
      private LogisticsOrder logistics;
      private Long orderId;
      private String orderSn;
      private Long projectId;
      private Long supplierId;
      private Long logisticsSupplierId;
      private BigDecimal loadingWeight;
      private List<ManufacturesInboundDetailDTOParam> list;

      ManufacturesInboundDTOParamBuilder() {
      }

      public ManufacturesInboundDTOParam.ManufacturesInboundDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ManufacturesInboundDTOParam.ManufacturesInboundDTOParamBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public ManufacturesInboundDTOParam.ManufacturesInboundDTOParamBuilder shipmentNumber(final String shipmentNumber) {
         this.shipmentNumber = shipmentNumber;
         return this;
      }

      public ManufacturesInboundDTOParam.ManufacturesInboundDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ManufacturesInboundDTOParam.ManufacturesInboundDTOParamBuilder logistics(final LogisticsOrder logistics) {
         this.logistics = logistics;
         return this;
      }

      public ManufacturesInboundDTOParam.ManufacturesInboundDTOParamBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public ManufacturesInboundDTOParam.ManufacturesInboundDTOParamBuilder orderSn(final String orderSn) {
         this.orderSn = orderSn;
         return this;
      }

      public ManufacturesInboundDTOParam.ManufacturesInboundDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ManufacturesInboundDTOParam.ManufacturesInboundDTOParamBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ManufacturesInboundDTOParam.ManufacturesInboundDTOParamBuilder logisticsSupplierId(final Long logisticsSupplierId) {
         this.logisticsSupplierId = logisticsSupplierId;
         return this;
      }

      public ManufacturesInboundDTOParam.ManufacturesInboundDTOParamBuilder loadingWeight(final BigDecimal loadingWeight) {
         this.loadingWeight = loadingWeight;
         return this;
      }

      public ManufacturesInboundDTOParam.ManufacturesInboundDTOParamBuilder list(final List<ManufacturesInboundDetailDTOParam> list) {
         this.list = list;
         return this;
      }

      public ManufacturesInboundDTOParam build() {
         return new ManufacturesInboundDTOParam(
            this.id,
            this.licensePlate,
            this.shipmentNumber,
            this.basicClass,
            this.logistics,
            this.orderId,
            this.orderSn,
            this.projectId,
            this.supplierId,
            this.logisticsSupplierId,
            this.loadingWeight,
            this.list
         );
      }

      @Override
      public String toString() {
         return "ManufacturesInboundDTOParam.ManufacturesInboundDTOParamBuilder(id="
            + this.id
            + ", licensePlate="
            + this.licensePlate
            + ", shipmentNumber="
            + this.shipmentNumber
            + ", basicClass="
            + this.basicClass
            + ", logistics="
            + this.logistics
            + ", orderId="
            + this.orderId
            + ", orderSn="
            + this.orderSn
            + ", projectId="
            + this.projectId
            + ", supplierId="
            + this.supplierId
            + ", logisticsSupplierId="
            + this.logisticsSupplierId
            + ", loadingWeight="
            + this.loadingWeight
            + ", list="
            + this.list
            + ")";
      }
   }
}
