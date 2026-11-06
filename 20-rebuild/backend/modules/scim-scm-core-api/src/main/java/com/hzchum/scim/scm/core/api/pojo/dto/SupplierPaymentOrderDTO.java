package com.hzchum.scim.scm.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SupplierPaymentOrderDTO {
   @ApiModelProperty("订单id ")
   private Long id;
   @ApiModelProperty("项目id")
   @JsonIgnore
   private String projectIds;
   @ApiModelProperty("采购单号")
   private String serialNumber;
   @ApiModelProperty("采购类型[1 原材料采购,2 制成品采购]")
   private Integer propertyType;
   @ApiModelProperty("采购状态[1 采购中,2 采购完成]")
   private Integer purchaseStatus;
   @ApiModelProperty("结算状态[待确定]")
   private Integer settlementStatus;
   @ApiModelProperty("创建时间 签订时间")
   private LocalDateTime createTime;
   @ApiModelProperty("购方单位(签订主体id)")
   private Long branchCompanyId;
   @ApiModelProperty("购方单位(签订主体名称)")
   private String branchCompanyName;
   @ApiModelProperty("销售单位(供应商id)")
   private Long supplierId;
   @ApiModelProperty("销售单位(供应商名称)")
   private String supplierName;
   @ApiModelProperty("供应商银行")
   private String supplierBankName;
   @ApiModelProperty("供应商银行账号")
   private String supplierBankAccount;
   @ApiModelProperty("基础物料分类")
   private Integer basicClass;
   @ApiModelProperty("合同额")
   private BigDecimal amount;
   @ApiModelProperty("结算额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("入库额")
   private BigDecimal inboundAmount;
   @ApiModelProperty("付款额")
   private BigDecimal paymentAmount;
   @ApiModelProperty("未审核付款数")
   private Integer unCheckPaymentCount;
   @ApiModelProperty("收票额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("未审核收票额")
   private Integer unCheckInvoiceAmount;

   public Long getId() {
      return this.id;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getPropertyType() {
      return this.propertyType;
   }

   public Integer getPurchaseStatus() {
      return this.purchaseStatus;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getSupplierBankName() {
      return this.supplierBankName;
   }

   public String getSupplierBankAccount() {
      return this.supplierBankAccount;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getInboundAmount() {
      return this.inboundAmount;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public Integer getUnCheckPaymentCount() {
      return this.unCheckPaymentCount;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public Integer getUnCheckInvoiceAmount() {
      return this.unCheckInvoiceAmount;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   @JsonIgnore
   public void setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setPropertyType(final Integer propertyType) {
      this.propertyType = propertyType;
   }

   public void setPurchaseStatus(final Integer purchaseStatus) {
      this.purchaseStatus = purchaseStatus;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setSupplierBankName(final String supplierBankName) {
      this.supplierBankName = supplierBankName;
   }

   public void setSupplierBankAccount(final String supplierBankAccount) {
      this.supplierBankAccount = supplierBankAccount;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setInboundAmount(final BigDecimal inboundAmount) {
      this.inboundAmount = inboundAmount;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setUnCheckPaymentCount(final Integer unCheckPaymentCount) {
      this.unCheckPaymentCount = unCheckPaymentCount;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setUnCheckInvoiceAmount(final Integer unCheckInvoiceAmount) {
      this.unCheckInvoiceAmount = unCheckInvoiceAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierPaymentOrderDTO)) {
         return false;
      }

      SupplierPaymentOrderDTO other = (SupplierPaymentOrderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$propertyType = this.getPropertyType();
         Object other$propertyType = other.getPropertyType();
         if (this$propertyType == null ? other$propertyType == null : this$propertyType.equals(other$propertyType)) {
            Object this$purchaseStatus = this.getPurchaseStatus();
            Object other$purchaseStatus = other.getPurchaseStatus();
            if (this$purchaseStatus == null ? other$purchaseStatus == null : this$purchaseStatus.equals(other$purchaseStatus)) {
               Object this$settlementStatus = this.getSettlementStatus();
               Object other$settlementStatus = other.getSettlementStatus();
               if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
                  Object this$branchCompanyId = this.getBranchCompanyId();
                  Object other$branchCompanyId = other.getBranchCompanyId();
                  if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                     Object this$supplierId = this.getSupplierId();
                     Object other$supplierId = other.getSupplierId();
                     if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                        Object this$basicClass = this.getBasicClass();
                        Object other$basicClass = other.getBasicClass();
                        if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                           Object this$unCheckPaymentCount = this.getUnCheckPaymentCount();
                           Object other$unCheckPaymentCount = other.getUnCheckPaymentCount();
                           if (this$unCheckPaymentCount == null
                              ? other$unCheckPaymentCount == null
                              : this$unCheckPaymentCount.equals(other$unCheckPaymentCount)) {
                              Object this$unCheckInvoiceAmount = this.getUnCheckInvoiceAmount();
                              Object other$unCheckInvoiceAmount = other.getUnCheckInvoiceAmount();
                              if (this$unCheckInvoiceAmount == null
                                 ? other$unCheckInvoiceAmount == null
                                 : this$unCheckInvoiceAmount.equals(other$unCheckInvoiceAmount)) {
                                 Object this$projectIds = this.getProjectIds();
                                 Object other$projectIds = other.getProjectIds();
                                 if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$createTime = this.getCreateTime();
                                       Object other$createTime = other.getCreateTime();
                                       if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                          Object this$branchCompanyName = this.getBranchCompanyName();
                                          Object other$branchCompanyName = other.getBranchCompanyName();
                                          if (this$branchCompanyName == null
                                             ? other$branchCompanyName == null
                                             : this$branchCompanyName.equals(other$branchCompanyName)) {
                                             Object this$supplierName = this.getSupplierName();
                                             Object other$supplierName = other.getSupplierName();
                                             if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                                Object this$supplierBankName = this.getSupplierBankName();
                                                Object other$supplierBankName = other.getSupplierBankName();
                                                if (this$supplierBankName == null
                                                   ? other$supplierBankName == null
                                                   : this$supplierBankName.equals(other$supplierBankName)) {
                                                   Object this$supplierBankAccount = this.getSupplierBankAccount();
                                                   Object other$supplierBankAccount = other.getSupplierBankAccount();
                                                   if (this$supplierBankAccount == null
                                                      ? other$supplierBankAccount == null
                                                      : this$supplierBankAccount.equals(other$supplierBankAccount)) {
                                                      Object this$amount = this.getAmount();
                                                      Object other$amount = other.getAmount();
                                                      if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                         Object this$settlementAmount = this.getSettlementAmount();
                                                         Object other$settlementAmount = other.getSettlementAmount();
                                                         if (this$settlementAmount == null
                                                            ? other$settlementAmount == null
                                                            : this$settlementAmount.equals(other$settlementAmount)) {
                                                            Object this$inboundAmount = this.getInboundAmount();
                                                            Object other$inboundAmount = other.getInboundAmount();
                                                            if (this$inboundAmount == null
                                                               ? other$inboundAmount == null
                                                               : this$inboundAmount.equals(other$inboundAmount)) {
                                                               Object this$paymentAmount = this.getPaymentAmount();
                                                               Object other$paymentAmount = other.getPaymentAmount();
                                                               if (this$paymentAmount == null
                                                                  ? other$paymentAmount == null
                                                                  : this$paymentAmount.equals(other$paymentAmount)) {
                                                                  Object this$invoiceAmount = this.getInvoiceAmount();
                                                                  Object other$invoiceAmount = other.getInvoiceAmount();
                                                                  return this$invoiceAmount == null
                                                                     ? other$invoiceAmount == null
                                                                     : this$invoiceAmount.equals(other$invoiceAmount);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SupplierPaymentOrderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $propertyType = this.getPropertyType();
      result = result * 59 + ($propertyType == null ? 43 : $propertyType.hashCode());
      Object $purchaseStatus = this.getPurchaseStatus();
      result = result * 59 + ($purchaseStatus == null ? 43 : $purchaseStatus.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $unCheckPaymentCount = this.getUnCheckPaymentCount();
      result = result * 59 + ($unCheckPaymentCount == null ? 43 : $unCheckPaymentCount.hashCode());
      Object $unCheckInvoiceAmount = this.getUnCheckInvoiceAmount();
      result = result * 59 + ($unCheckInvoiceAmount == null ? 43 : $unCheckInvoiceAmount.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $supplierBankName = this.getSupplierBankName();
      result = result * 59 + ($supplierBankName == null ? 43 : $supplierBankName.hashCode());
      Object $supplierBankAccount = this.getSupplierBankAccount();
      result = result * 59 + ($supplierBankAccount == null ? 43 : $supplierBankAccount.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $inboundAmount = this.getInboundAmount();
      result = result * 59 + ($inboundAmount == null ? 43 : $inboundAmount.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      return result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierPaymentOrderDTO(id="
         + this.getId()
         + ", projectIds="
         + this.getProjectIds()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", propertyType="
         + this.getPropertyType()
         + ", purchaseStatus="
         + this.getPurchaseStatus()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", createTime="
         + this.getCreateTime()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", supplierBankName="
         + this.getSupplierBankName()
         + ", supplierBankAccount="
         + this.getSupplierBankAccount()
         + ", basicClass="
         + this.getBasicClass()
         + ", amount="
         + this.getAmount()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", inboundAmount="
         + this.getInboundAmount()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", unCheckPaymentCount="
         + this.getUnCheckPaymentCount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", unCheckInvoiceAmount="
         + this.getUnCheckInvoiceAmount()
         + ")";
   }
}
