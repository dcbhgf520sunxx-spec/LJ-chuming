package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.BriefPurchaseOrderDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class RejectDetailDTO {
   private BriefPurchaseOrderDTO purchaseOrder;
   private Long id;
   private String remark;
   private Integer basicClass;
   private String serialNumber;
   private String shipmentNumber;
   private BigDecimal loadingWeight;
   private Boolean boolHasUnfreeze;
   @ApiModelProperty(name = "rejectFreightType", value = "退运费处理方式")
   private Integer rejectFreightType;
   @ApiModelProperty(name = "freight", value = "所退运费金额")
   private BigDecimal freight;
   @ApiModelProperty(name = "freightExcludingVat", value = "所退运费金额 不含税")
   private BigDecimal freightExcludingVat;
   private List<MaterialUnfreezeDTO> unfreezeList;
   private List<MaterialInventoryDTO> list;
   private Long approveRecordId;
   private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO;

   public static RejectDetailDTO.RejectDetailDTOBuilder builder() {
      return new RejectDetailDTO.RejectDetailDTOBuilder();
   }

   public BriefPurchaseOrderDTO getPurchaseOrder() {
      return this.purchaseOrder;
   }

   public Long getId() {
      return this.id;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getShipmentNumber() {
      return this.shipmentNumber;
   }

   public BigDecimal getLoadingWeight() {
      return this.loadingWeight;
   }

   public Boolean getBoolHasUnfreeze() {
      return this.boolHasUnfreeze;
   }

   public Integer getRejectFreightType() {
      return this.rejectFreightType;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public BigDecimal getFreightExcludingVat() {
      return this.freightExcludingVat;
   }

   public List<MaterialUnfreezeDTO> getUnfreezeList() {
      return this.unfreezeList;
   }

   public List<MaterialInventoryDTO> getList() {
      return this.list;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public WmsApproveRecordFlowDTO getWmsApproveRecordFlowDTO() {
      return this.wmsApproveRecordFlowDTO;
   }

   public void setPurchaseOrder(final BriefPurchaseOrderDTO purchaseOrder) {
      this.purchaseOrder = purchaseOrder;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setShipmentNumber(final String shipmentNumber) {
      this.shipmentNumber = shipmentNumber;
   }

   public void setLoadingWeight(final BigDecimal loadingWeight) {
      this.loadingWeight = loadingWeight;
   }

   public void setBoolHasUnfreeze(final Boolean boolHasUnfreeze) {
      this.boolHasUnfreeze = boolHasUnfreeze;
   }

   public void setRejectFreightType(final Integer rejectFreightType) {
      this.rejectFreightType = rejectFreightType;
   }

   public void setFreight(final BigDecimal freight) {
      this.freight = freight;
   }

   public void setFreightExcludingVat(final BigDecimal freightExcludingVat) {
      this.freightExcludingVat = freightExcludingVat;
   }

   public void setUnfreezeList(final List<MaterialUnfreezeDTO> unfreezeList) {
      this.unfreezeList = unfreezeList;
   }

   public void setList(final List<MaterialInventoryDTO> list) {
      this.list = list;
   }

   public void setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
   }

   public void setWmsApproveRecordFlowDTO(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO) {
      this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RejectDetailDTO)) {
         return false;
      }

      RejectDetailDTO other = (RejectDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$boolHasUnfreeze = this.getBoolHasUnfreeze();
            Object other$boolHasUnfreeze = other.getBoolHasUnfreeze();
            if (this$boolHasUnfreeze == null ? other$boolHasUnfreeze == null : this$boolHasUnfreeze.equals(other$boolHasUnfreeze)) {
               Object this$rejectFreightType = this.getRejectFreightType();
               Object other$rejectFreightType = other.getRejectFreightType();
               if (this$rejectFreightType == null ? other$rejectFreightType == null : this$rejectFreightType.equals(other$rejectFreightType)) {
                  Object this$approveRecordId = this.getApproveRecordId();
                  Object other$approveRecordId = other.getApproveRecordId();
                  if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                     Object this$purchaseOrder = this.getPurchaseOrder();
                     Object other$purchaseOrder = other.getPurchaseOrder();
                     if (this$purchaseOrder == null ? other$purchaseOrder == null : this$purchaseOrder.equals(other$purchaseOrder)) {
                        Object this$remark = this.getRemark();
                        Object other$remark = other.getRemark();
                        if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$shipmentNumber = this.getShipmentNumber();
                              Object other$shipmentNumber = other.getShipmentNumber();
                              if (this$shipmentNumber == null ? other$shipmentNumber == null : this$shipmentNumber.equals(other$shipmentNumber)) {
                                 Object this$loadingWeight = this.getLoadingWeight();
                                 Object other$loadingWeight = other.getLoadingWeight();
                                 if (this$loadingWeight == null ? other$loadingWeight == null : this$loadingWeight.equals(other$loadingWeight)) {
                                    Object this$freight = this.getFreight();
                                    Object other$freight = other.getFreight();
                                    if (this$freight == null ? other$freight == null : this$freight.equals(other$freight)) {
                                       Object this$freightExcludingVat = this.getFreightExcludingVat();
                                       Object other$freightExcludingVat = other.getFreightExcludingVat();
                                       if (this$freightExcludingVat == null
                                          ? other$freightExcludingVat == null
                                          : this$freightExcludingVat.equals(other$freightExcludingVat)) {
                                          Object this$unfreezeList = this.getUnfreezeList();
                                          Object other$unfreezeList = other.getUnfreezeList();
                                          if (this$unfreezeList == null ? other$unfreezeList == null : this$unfreezeList.equals(other$unfreezeList)) {
                                             Object this$list = this.getList();
                                             Object other$list = other.getList();
                                             if (this$list == null ? other$list == null : this$list.equals(other$list)) {
                                                Object this$wmsApproveRecordFlowDTO = this.getWmsApproveRecordFlowDTO();
                                                Object other$wmsApproveRecordFlowDTO = other.getWmsApproveRecordFlowDTO();
                                                return this$wmsApproveRecordFlowDTO == null
                                                   ? other$wmsApproveRecordFlowDTO == null
                                                   : this$wmsApproveRecordFlowDTO.equals(other$wmsApproveRecordFlowDTO);
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
      return other instanceof RejectDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $boolHasUnfreeze = this.getBoolHasUnfreeze();
      result = result * 59 + ($boolHasUnfreeze == null ? 43 : $boolHasUnfreeze.hashCode());
      Object $rejectFreightType = this.getRejectFreightType();
      result = result * 59 + ($rejectFreightType == null ? 43 : $rejectFreightType.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $purchaseOrder = this.getPurchaseOrder();
      result = result * 59 + ($purchaseOrder == null ? 43 : $purchaseOrder.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $loadingWeight = this.getLoadingWeight();
      result = result * 59 + ($loadingWeight == null ? 43 : $loadingWeight.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $freightExcludingVat = this.getFreightExcludingVat();
      result = result * 59 + ($freightExcludingVat == null ? 43 : $freightExcludingVat.hashCode());
      Object $unfreezeList = this.getUnfreezeList();
      result = result * 59 + ($unfreezeList == null ? 43 : $unfreezeList.hashCode());
      Object $list = this.getList();
      result = result * 59 + ($list == null ? 43 : $list.hashCode());
      Object $wmsApproveRecordFlowDTO = this.getWmsApproveRecordFlowDTO();
      return result * 59 + ($wmsApproveRecordFlowDTO == null ? 43 : $wmsApproveRecordFlowDTO.hashCode());
   }

   @Override
   public String toString() {
      return "RejectDetailDTO(purchaseOrder="
         + this.getPurchaseOrder()
         + ", id="
         + this.getId()
         + ", remark="
         + this.getRemark()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", loadingWeight="
         + this.getLoadingWeight()
         + ", boolHasUnfreeze="
         + this.getBoolHasUnfreeze()
         + ", rejectFreightType="
         + this.getRejectFreightType()
         + ", freight="
         + this.getFreight()
         + ", freightExcludingVat="
         + this.getFreightExcludingVat()
         + ", unfreezeList="
         + this.getUnfreezeList()
         + ", list="
         + this.getList()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", wmsApproveRecordFlowDTO="
         + this.getWmsApproveRecordFlowDTO()
         + ")";
   }

   public RejectDetailDTO(
      final BriefPurchaseOrderDTO purchaseOrder,
      final Long id,
      final String remark,
      final Integer basicClass,
      final String serialNumber,
      final String shipmentNumber,
      final BigDecimal loadingWeight,
      final Boolean boolHasUnfreeze,
      final Integer rejectFreightType,
      final BigDecimal freight,
      final BigDecimal freightExcludingVat,
      final List<MaterialUnfreezeDTO> unfreezeList,
      final List<MaterialInventoryDTO> list,
      final Long approveRecordId,
      final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO
   ) {
      this.purchaseOrder = purchaseOrder;
      this.id = id;
      this.remark = remark;
      this.basicClass = basicClass;
      this.serialNumber = serialNumber;
      this.shipmentNumber = shipmentNumber;
      this.loadingWeight = loadingWeight;
      this.boolHasUnfreeze = boolHasUnfreeze;
      this.rejectFreightType = rejectFreightType;
      this.freight = freight;
      this.freightExcludingVat = freightExcludingVat;
      this.unfreezeList = unfreezeList;
      this.list = list;
      this.approveRecordId = approveRecordId;
      this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
   }

   public RejectDetailDTO() {
   }

   public static class RejectDetailDTOBuilder {
      private BriefPurchaseOrderDTO purchaseOrder;
      private Long id;
      private String remark;
      private Integer basicClass;
      private String serialNumber;
      private String shipmentNumber;
      private BigDecimal loadingWeight;
      private Boolean boolHasUnfreeze;
      private Integer rejectFreightType;
      private BigDecimal freight;
      private BigDecimal freightExcludingVat;
      private List<MaterialUnfreezeDTO> unfreezeList;
      private List<MaterialInventoryDTO> list;
      private Long approveRecordId;
      private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO;

      RejectDetailDTOBuilder() {
      }

      public RejectDetailDTO.RejectDetailDTOBuilder purchaseOrder(final BriefPurchaseOrderDTO purchaseOrder) {
         this.purchaseOrder = purchaseOrder;
         return this;
      }

      public RejectDetailDTO.RejectDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public RejectDetailDTO.RejectDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public RejectDetailDTO.RejectDetailDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public RejectDetailDTO.RejectDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public RejectDetailDTO.RejectDetailDTOBuilder shipmentNumber(final String shipmentNumber) {
         this.shipmentNumber = shipmentNumber;
         return this;
      }

      public RejectDetailDTO.RejectDetailDTOBuilder loadingWeight(final BigDecimal loadingWeight) {
         this.loadingWeight = loadingWeight;
         return this;
      }

      public RejectDetailDTO.RejectDetailDTOBuilder boolHasUnfreeze(final Boolean boolHasUnfreeze) {
         this.boolHasUnfreeze = boolHasUnfreeze;
         return this;
      }

      public RejectDetailDTO.RejectDetailDTOBuilder rejectFreightType(final Integer rejectFreightType) {
         this.rejectFreightType = rejectFreightType;
         return this;
      }

      public RejectDetailDTO.RejectDetailDTOBuilder freight(final BigDecimal freight) {
         this.freight = freight;
         return this;
      }

      public RejectDetailDTO.RejectDetailDTOBuilder freightExcludingVat(final BigDecimal freightExcludingVat) {
         this.freightExcludingVat = freightExcludingVat;
         return this;
      }

      public RejectDetailDTO.RejectDetailDTOBuilder unfreezeList(final List<MaterialUnfreezeDTO> unfreezeList) {
         this.unfreezeList = unfreezeList;
         return this;
      }

      public RejectDetailDTO.RejectDetailDTOBuilder list(final List<MaterialInventoryDTO> list) {
         this.list = list;
         return this;
      }

      public RejectDetailDTO.RejectDetailDTOBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public RejectDetailDTO.RejectDetailDTOBuilder wmsApproveRecordFlowDTO(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO) {
         this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
         return this;
      }

      public RejectDetailDTO build() {
         return new RejectDetailDTO(
            this.purchaseOrder,
            this.id,
            this.remark,
            this.basicClass,
            this.serialNumber,
            this.shipmentNumber,
            this.loadingWeight,
            this.boolHasUnfreeze,
            this.rejectFreightType,
            this.freight,
            this.freightExcludingVat,
            this.unfreezeList,
            this.list,
            this.approveRecordId,
            this.wmsApproveRecordFlowDTO
         );
      }

      @Override
      public String toString() {
         return "RejectDetailDTO.RejectDetailDTOBuilder(purchaseOrder="
            + this.purchaseOrder
            + ", id="
            + this.id
            + ", remark="
            + this.remark
            + ", basicClass="
            + this.basicClass
            + ", serialNumber="
            + this.serialNumber
            + ", shipmentNumber="
            + this.shipmentNumber
            + ", loadingWeight="
            + this.loadingWeight
            + ", boolHasUnfreeze="
            + this.boolHasUnfreeze
            + ", rejectFreightType="
            + this.rejectFreightType
            + ", freight="
            + this.freight
            + ", freightExcludingVat="
            + this.freightExcludingVat
            + ", unfreezeList="
            + this.unfreezeList
            + ", list="
            + this.list
            + ", approveRecordId="
            + this.approveRecordId
            + ", wmsApproveRecordFlowDTO="
            + this.wmsApproveRecordFlowDTO
            + ")";
      }
   }
}
