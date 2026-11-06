package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("采购对账返回类")
public class PurchaseStandingBookDTO {
   @ApiModelProperty("采购id")
   private Long orderId;
   @ApiModelProperty("签订主体")
   private String contractSignBodyName;
   @ApiModelProperty("采购合同号")
   private String purchaseContractNumber;
   @ApiModelProperty(name = "materialType", value = "材料类型", notes = "材料类型")
   private Integer materialType;
   @ApiModelProperty("入库额")
   private BigDecimal purchaseAmount;
   @ApiModelProperty("结算状态")
   private Integer settlementStatus;
   @ApiModelProperty("采购对账是否打印")
   private Boolean standingBookIsPrint;

   public static PurchaseStandingBookDTO.PurchaseStandingBookDTOBuilder builder() {
      return new PurchaseStandingBookDTO.PurchaseStandingBookDTOBuilder();
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public String getContractSignBodyName() {
      return this.contractSignBodyName;
   }

   public String getPurchaseContractNumber() {
      return this.purchaseContractNumber;
   }

   public Integer getMaterialType() {
      return this.materialType;
   }

   public BigDecimal getPurchaseAmount() {
      return this.purchaseAmount;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public Boolean getStandingBookIsPrint() {
      return this.standingBookIsPrint;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setContractSignBodyName(final String contractSignBodyName) {
      this.contractSignBodyName = contractSignBodyName;
   }

   public void setPurchaseContractNumber(final String purchaseContractNumber) {
      this.purchaseContractNumber = purchaseContractNumber;
   }

   public void setMaterialType(final Integer materialType) {
      this.materialType = materialType;
   }

   public void setPurchaseAmount(final BigDecimal purchaseAmount) {
      this.purchaseAmount = purchaseAmount;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setStandingBookIsPrint(final Boolean standingBookIsPrint) {
      this.standingBookIsPrint = standingBookIsPrint;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseStandingBookDTO)) {
         return false;
      }

      PurchaseStandingBookDTO other = (PurchaseStandingBookDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderId = this.getOrderId();
      Object other$orderId = other.getOrderId();
      if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
         Object this$materialType = this.getMaterialType();
         Object other$materialType = other.getMaterialType();
         if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
            Object this$settlementStatus = this.getSettlementStatus();
            Object other$settlementStatus = other.getSettlementStatus();
            if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
               Object this$standingBookIsPrint = this.getStandingBookIsPrint();
               Object other$standingBookIsPrint = other.getStandingBookIsPrint();
               if (this$standingBookIsPrint == null ? other$standingBookIsPrint == null : this$standingBookIsPrint.equals(other$standingBookIsPrint)) {
                  Object this$contractSignBodyName = this.getContractSignBodyName();
                  Object other$contractSignBodyName = other.getContractSignBodyName();
                  if (this$contractSignBodyName == null ? other$contractSignBodyName == null : this$contractSignBodyName.equals(other$contractSignBodyName)) {
                     Object this$purchaseContractNumber = this.getPurchaseContractNumber();
                     Object other$purchaseContractNumber = other.getPurchaseContractNumber();
                     if (this$purchaseContractNumber == null
                        ? other$purchaseContractNumber == null
                        : this$purchaseContractNumber.equals(other$purchaseContractNumber)) {
                        Object this$purchaseAmount = this.getPurchaseAmount();
                        Object other$purchaseAmount = other.getPurchaseAmount();
                        return this$purchaseAmount == null ? other$purchaseAmount == null : this$purchaseAmount.equals(other$purchaseAmount);
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
      return other instanceof PurchaseStandingBookDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $standingBookIsPrint = this.getStandingBookIsPrint();
      result = result * 59 + ($standingBookIsPrint == null ? 43 : $standingBookIsPrint.hashCode());
      Object $contractSignBodyName = this.getContractSignBodyName();
      result = result * 59 + ($contractSignBodyName == null ? 43 : $contractSignBodyName.hashCode());
      Object $purchaseContractNumber = this.getPurchaseContractNumber();
      result = result * 59 + ($purchaseContractNumber == null ? 43 : $purchaseContractNumber.hashCode());
      Object $purchaseAmount = this.getPurchaseAmount();
      return result * 59 + ($purchaseAmount == null ? 43 : $purchaseAmount.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseStandingBookDTO(orderId="
         + this.getOrderId()
         + ", contractSignBodyName="
         + this.getContractSignBodyName()
         + ", purchaseContractNumber="
         + this.getPurchaseContractNumber()
         + ", materialType="
         + this.getMaterialType()
         + ", purchaseAmount="
         + this.getPurchaseAmount()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", standingBookIsPrint="
         + this.getStandingBookIsPrint()
         + ")";
   }

   public PurchaseStandingBookDTO(
      final Long orderId,
      final String contractSignBodyName,
      final String purchaseContractNumber,
      final Integer materialType,
      final BigDecimal purchaseAmount,
      final Integer settlementStatus,
      final Boolean standingBookIsPrint
   ) {
      this.orderId = orderId;
      this.contractSignBodyName = contractSignBodyName;
      this.purchaseContractNumber = purchaseContractNumber;
      this.materialType = materialType;
      this.purchaseAmount = purchaseAmount;
      this.settlementStatus = settlementStatus;
      this.standingBookIsPrint = standingBookIsPrint;
   }

   public PurchaseStandingBookDTO() {
   }

   public static class PurchaseStandingBookDTOBuilder {
      private Long orderId;
      private String contractSignBodyName;
      private String purchaseContractNumber;
      private Integer materialType;
      private BigDecimal purchaseAmount;
      private Integer settlementStatus;
      private Boolean standingBookIsPrint;

      PurchaseStandingBookDTOBuilder() {
      }

      public PurchaseStandingBookDTO.PurchaseStandingBookDTOBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public PurchaseStandingBookDTO.PurchaseStandingBookDTOBuilder contractSignBodyName(final String contractSignBodyName) {
         this.contractSignBodyName = contractSignBodyName;
         return this;
      }

      public PurchaseStandingBookDTO.PurchaseStandingBookDTOBuilder purchaseContractNumber(final String purchaseContractNumber) {
         this.purchaseContractNumber = purchaseContractNumber;
         return this;
      }

      public PurchaseStandingBookDTO.PurchaseStandingBookDTOBuilder materialType(final Integer materialType) {
         this.materialType = materialType;
         return this;
      }

      public PurchaseStandingBookDTO.PurchaseStandingBookDTOBuilder purchaseAmount(final BigDecimal purchaseAmount) {
         this.purchaseAmount = purchaseAmount;
         return this;
      }

      public PurchaseStandingBookDTO.PurchaseStandingBookDTOBuilder settlementStatus(final Integer settlementStatus) {
         this.settlementStatus = settlementStatus;
         return this;
      }

      public PurchaseStandingBookDTO.PurchaseStandingBookDTOBuilder standingBookIsPrint(final Boolean standingBookIsPrint) {
         this.standingBookIsPrint = standingBookIsPrint;
         return this;
      }

      public PurchaseStandingBookDTO build() {
         return new PurchaseStandingBookDTO(
            this.orderId,
            this.contractSignBodyName,
            this.purchaseContractNumber,
            this.materialType,
            this.purchaseAmount,
            this.settlementStatus,
            this.standingBookIsPrint
         );
      }

      @Override
      public String toString() {
         return "PurchaseStandingBookDTO.PurchaseStandingBookDTOBuilder(orderId="
            + this.orderId
            + ", contractSignBodyName="
            + this.contractSignBodyName
            + ", purchaseContractNumber="
            + this.purchaseContractNumber
            + ", materialType="
            + this.materialType
            + ", purchaseAmount="
            + this.purchaseAmount
            + ", settlementStatus="
            + this.settlementStatus
            + ", standingBookIsPrint="
            + this.standingBookIsPrint
            + ")";
      }
   }
}
