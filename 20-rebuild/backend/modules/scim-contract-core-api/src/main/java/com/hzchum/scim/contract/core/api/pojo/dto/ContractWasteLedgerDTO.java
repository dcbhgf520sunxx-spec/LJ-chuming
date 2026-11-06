package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("废料台账类")
public class ContractWasteLedgerDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "contractWasteId", value = "废料合同ID", notes = "废料合同ID")
   private Long contractWasteId;
   @ApiModelProperty(name = "serialNumber", value = "合同编号", notes = "合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "purchaser", value = "购买方", notes = "购买方")
   private String purchaser;
   @ApiModelProperty(name = "branchCompanyId", value = "出售单位id (分支机构id)", notes = "出售单位id (分支机构id)")
   private Long branchCompanyId;
   @ApiModelProperty(name = "branchCompanyName", value = "出售单位(分支机构)", notes = "出售单位(分支机构)")
   private String branchCompanyName;
   @ApiModelProperty(name = "totalAmount", value = "出售总额(元)", notes = "出售总额(元)")
   private BigDecimal totalAmount;
   @ApiModelProperty(name = "collectionAmount", value = "收款总额(元)", notes = "收款总额(元)")
   private BigDecimal collectionAmount;
   @ApiModelProperty(name = "collectionRate", value = "收款率", notes = "收款率")
   private BigDecimal collectionRate;
   @ApiModelProperty(name = "invoiceAmount", value = "开票总额(元)", notes = "开票总额(元)")
   private BigDecimal invoiceAmount;
   @ApiModelProperty(name = "invoiceRate", value = "开票率", notes = "开票率")
   private BigDecimal invoiceRate;
   @ApiModelProperty(name = "unCheckCollectionCount", value = "未审核收款数")
   private Integer unCheckCollectionCount;
   @ApiModelProperty(name = "unCheckInvoiceCount", value = "未审核开票数")
   private Integer unCheckInvoiceCount;

   public static ContractWasteLedgerDTO.ContractWasteLedgerDTOBuilder builder() {
      return new ContractWasteLedgerDTO.ContractWasteLedgerDTOBuilder();
   }

   public ContractWasteLedgerDTO(
      final Long contractWasteId,
      final String serialNumber,
      final String purchaser,
      final Long branchCompanyId,
      final String branchCompanyName,
      final BigDecimal totalAmount,
      final BigDecimal collectionAmount,
      final BigDecimal collectionRate,
      final BigDecimal invoiceAmount,
      final BigDecimal invoiceRate,
      final Integer unCheckCollectionCount,
      final Integer unCheckInvoiceCount
   ) {
      this.contractWasteId = contractWasteId;
      this.serialNumber = serialNumber;
      this.purchaser = purchaser;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.totalAmount = totalAmount;
      this.collectionAmount = collectionAmount;
      this.collectionRate = collectionRate;
      this.invoiceAmount = invoiceAmount;
      this.invoiceRate = invoiceRate;
      this.unCheckCollectionCount = unCheckCollectionCount;
      this.unCheckInvoiceCount = unCheckInvoiceCount;
   }

   public ContractWasteLedgerDTO() {
   }

   public Long getContractWasteId() {
      return this.contractWasteId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getPurchaser() {
      return this.purchaser;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public BigDecimal getCollectionAmount() {
      return this.collectionAmount;
   }

   public BigDecimal getCollectionRate() {
      return this.collectionRate;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getInvoiceRate() {
      return this.invoiceRate;
   }

   public Integer getUnCheckCollectionCount() {
      return this.unCheckCollectionCount;
   }

   public Integer getUnCheckInvoiceCount() {
      return this.unCheckInvoiceCount;
   }

   public void setContractWasteId(final Long contractWasteId) {
      this.contractWasteId = contractWasteId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setPurchaser(final String purchaser) {
      this.purchaser = purchaser;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   public void setCollectionAmount(final BigDecimal collectionAmount) {
      this.collectionAmount = collectionAmount;
   }

   public void setCollectionRate(final BigDecimal collectionRate) {
      this.collectionRate = collectionRate;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setInvoiceRate(final BigDecimal invoiceRate) {
      this.invoiceRate = invoiceRate;
   }

   public void setUnCheckCollectionCount(final Integer unCheckCollectionCount) {
      this.unCheckCollectionCount = unCheckCollectionCount;
   }

   public void setUnCheckInvoiceCount(final Integer unCheckInvoiceCount) {
      this.unCheckInvoiceCount = unCheckInvoiceCount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWasteLedgerDTO)) {
         return false;
      }

      ContractWasteLedgerDTO other = (ContractWasteLedgerDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$contractWasteId = this.getContractWasteId();
      Object other$contractWasteId = other.getContractWasteId();
      if (this$contractWasteId == null ? other$contractWasteId == null : this$contractWasteId.equals(other$contractWasteId)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$unCheckCollectionCount = this.getUnCheckCollectionCount();
            Object other$unCheckCollectionCount = other.getUnCheckCollectionCount();
            if (this$unCheckCollectionCount == null ? other$unCheckCollectionCount == null : this$unCheckCollectionCount.equals(other$unCheckCollectionCount)) {
               Object this$unCheckInvoiceCount = this.getUnCheckInvoiceCount();
               Object other$unCheckInvoiceCount = other.getUnCheckInvoiceCount();
               if (this$unCheckInvoiceCount == null ? other$unCheckInvoiceCount == null : this$unCheckInvoiceCount.equals(other$unCheckInvoiceCount)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$purchaser = this.getPurchaser();
                     Object other$purchaser = other.getPurchaser();
                     if (this$purchaser == null ? other$purchaser == null : this$purchaser.equals(other$purchaser)) {
                        Object this$branchCompanyName = this.getBranchCompanyName();
                        Object other$branchCompanyName = other.getBranchCompanyName();
                        if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
                           Object this$totalAmount = this.getTotalAmount();
                           Object other$totalAmount = other.getTotalAmount();
                           if (this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount)) {
                              Object this$collectionAmount = this.getCollectionAmount();
                              Object other$collectionAmount = other.getCollectionAmount();
                              if (this$collectionAmount == null ? other$collectionAmount == null : this$collectionAmount.equals(other$collectionAmount)) {
                                 Object this$collectionRate = this.getCollectionRate();
                                 Object other$collectionRate = other.getCollectionRate();
                                 if (this$collectionRate == null ? other$collectionRate == null : this$collectionRate.equals(other$collectionRate)) {
                                    Object this$invoiceAmount = this.getInvoiceAmount();
                                    Object other$invoiceAmount = other.getInvoiceAmount();
                                    if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                                       Object this$invoiceRate = this.getInvoiceRate();
                                       Object other$invoiceRate = other.getInvoiceRate();
                                       return this$invoiceRate == null ? other$invoiceRate == null : this$invoiceRate.equals(other$invoiceRate);
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
      return other instanceof ContractWasteLedgerDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $unCheckCollectionCount = this.getUnCheckCollectionCount();
      result = result * 59 + ($unCheckCollectionCount == null ? 43 : $unCheckCollectionCount.hashCode());
      Object $unCheckInvoiceCount = this.getUnCheckInvoiceCount();
      result = result * 59 + ($unCheckInvoiceCount == null ? 43 : $unCheckInvoiceCount.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $purchaser = this.getPurchaser();
      result = result * 59 + ($purchaser == null ? 43 : $purchaser.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $collectionRate = this.getCollectionRate();
      result = result * 59 + ($collectionRate == null ? 43 : $collectionRate.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $invoiceRate = this.getInvoiceRate();
      return result * 59 + ($invoiceRate == null ? 43 : $invoiceRate.hashCode());
   }

   @Override
   public String toString() {
      return "ContractWasteLedgerDTO(contractWasteId="
         + this.getContractWasteId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", purchaser="
         + this.getPurchaser()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", collectionRate="
         + this.getCollectionRate()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", invoiceRate="
         + this.getInvoiceRate()
         + ", unCheckCollectionCount="
         + this.getUnCheckCollectionCount()
         + ", unCheckInvoiceCount="
         + this.getUnCheckInvoiceCount()
         + ")";
   }

   public static class ContractWasteLedgerDTOBuilder {
      private Long contractWasteId;
      private String serialNumber;
      private String purchaser;
      private Long branchCompanyId;
      private String branchCompanyName;
      private BigDecimal totalAmount;
      private BigDecimal collectionAmount;
      private BigDecimal collectionRate;
      private BigDecimal invoiceAmount;
      private BigDecimal invoiceRate;
      private Integer unCheckCollectionCount;
      private Integer unCheckInvoiceCount;

      ContractWasteLedgerDTOBuilder() {
      }

      public ContractWasteLedgerDTO.ContractWasteLedgerDTOBuilder contractWasteId(final Long contractWasteId) {
         this.contractWasteId = contractWasteId;
         return this;
      }

      public ContractWasteLedgerDTO.ContractWasteLedgerDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ContractWasteLedgerDTO.ContractWasteLedgerDTOBuilder purchaser(final String purchaser) {
         this.purchaser = purchaser;
         return this;
      }

      public ContractWasteLedgerDTO.ContractWasteLedgerDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ContractWasteLedgerDTO.ContractWasteLedgerDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public ContractWasteLedgerDTO.ContractWasteLedgerDTOBuilder totalAmount(final BigDecimal totalAmount) {
         this.totalAmount = totalAmount;
         return this;
      }

      public ContractWasteLedgerDTO.ContractWasteLedgerDTOBuilder collectionAmount(final BigDecimal collectionAmount) {
         this.collectionAmount = collectionAmount;
         return this;
      }

      public ContractWasteLedgerDTO.ContractWasteLedgerDTOBuilder collectionRate(final BigDecimal collectionRate) {
         this.collectionRate = collectionRate;
         return this;
      }

      public ContractWasteLedgerDTO.ContractWasteLedgerDTOBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public ContractWasteLedgerDTO.ContractWasteLedgerDTOBuilder invoiceRate(final BigDecimal invoiceRate) {
         this.invoiceRate = invoiceRate;
         return this;
      }

      public ContractWasteLedgerDTO.ContractWasteLedgerDTOBuilder unCheckCollectionCount(final Integer unCheckCollectionCount) {
         this.unCheckCollectionCount = unCheckCollectionCount;
         return this;
      }

      public ContractWasteLedgerDTO.ContractWasteLedgerDTOBuilder unCheckInvoiceCount(final Integer unCheckInvoiceCount) {
         this.unCheckInvoiceCount = unCheckInvoiceCount;
         return this;
      }

      public ContractWasteLedgerDTO build() {
         return new ContractWasteLedgerDTO(
            this.contractWasteId,
            this.serialNumber,
            this.purchaser,
            this.branchCompanyId,
            this.branchCompanyName,
            this.totalAmount,
            this.collectionAmount,
            this.collectionRate,
            this.invoiceAmount,
            this.invoiceRate,
            this.unCheckCollectionCount,
            this.unCheckInvoiceCount
         );
      }

      @Override
      public String toString() {
         return "ContractWasteLedgerDTO.ContractWasteLedgerDTOBuilder(contractWasteId="
            + this.contractWasteId
            + ", serialNumber="
            + this.serialNumber
            + ", purchaser="
            + this.purchaser
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", totalAmount="
            + this.totalAmount
            + ", collectionAmount="
            + this.collectionAmount
            + ", collectionRate="
            + this.collectionRate
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", invoiceRate="
            + this.invoiceRate
            + ", unCheckCollectionCount="
            + this.unCheckCollectionCount
            + ", unCheckInvoiceCount="
            + this.unCheckInvoiceCount
            + ")";
      }
   }
}
