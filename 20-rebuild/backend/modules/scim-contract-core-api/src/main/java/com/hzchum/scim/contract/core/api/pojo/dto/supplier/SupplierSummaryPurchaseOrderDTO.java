package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SupplierSummaryPurchaseOrderDTO {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty("购类型[1原材料采购 2制成品采购]")
   private Integer purchaseType;
   @ApiModelProperty("物料分类")
   private Integer basicClass;
   @ApiModelProperty("合同编号")
   private String serialNumber;
   @ApiModelProperty("合同额")
   private BigDecimal amount;
   @ApiModelProperty("签约主体id")
   private Long branchCompanyId;
   @ApiModelProperty("签约主体")
   private String branchCompanyName;
   @ApiModelProperty("供应商id")
   private Long supplierId;
   @ApiModelProperty("供应商")
   private String supplierName;
   @ApiModelProperty("关联项目列表")
   private List<ProjectInfo> projectList;
   @ApiModelProperty("创建人id")
   private Long createUserId;
   @ApiModelProperty("创建人")
   private String createUserName;
   @ApiModelProperty("结算状态 0未结算 1已结算")
   private Integer settlementStatus;
   @ApiModelProperty("结算额（元）")
   private BigDecimal settlementAmount;
   @ApiModelProperty("入库额（元）")
   private BigDecimal inboundAmount;
   @ApiModelProperty(notes = "已付款额")
   private BigDecimal paidAmount;
   @ApiModelProperty(notes = "已收票额")
   private BigDecimal receivedInvoiceAmount;

   public static SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder builder() {
      return new SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Integer getPurchaseType() {
      return this.purchaseType;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BigDecimal getAmount() {
      return this.amount;
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

   public List<ProjectInfo> getProjectList() {
      return this.projectList;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getInboundAmount() {
      return this.inboundAmount;
   }

   public BigDecimal getPaidAmount() {
      return this.paidAmount;
   }

   public BigDecimal getReceivedInvoiceAmount() {
      return this.receivedInvoiceAmount;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setPurchaseType(final Integer purchaseType) {
      this.purchaseType = purchaseType;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
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

   public void setProjectList(final List<ProjectInfo> projectList) {
      this.projectList = projectList;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setInboundAmount(final BigDecimal inboundAmount) {
      this.inboundAmount = inboundAmount;
   }

   public void setPaidAmount(final BigDecimal paidAmount) {
      this.paidAmount = paidAmount;
   }

   public void setReceivedInvoiceAmount(final BigDecimal receivedInvoiceAmount) {
      this.receivedInvoiceAmount = receivedInvoiceAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierSummaryPurchaseOrderDTO)) {
         return false;
      }

      SupplierSummaryPurchaseOrderDTO other = (SupplierSummaryPurchaseOrderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$purchaseType = this.getPurchaseType();
         Object other$purchaseType = other.getPurchaseType();
         if (this$purchaseType == null ? other$purchaseType == null : this$purchaseType.equals(other$purchaseType)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$branchCompanyId = this.getBranchCompanyId();
               Object other$branchCompanyId = other.getBranchCompanyId();
               if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$createUserId = this.getCreateUserId();
                     Object other$createUserId = other.getCreateUserId();
                     if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                        Object this$settlementStatus = this.getSettlementStatus();
                        Object other$settlementStatus = other.getSettlementStatus();
                        if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
                           Object this$createTime = this.getCreateTime();
                           Object other$createTime = other.getCreateTime();
                           if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$amount = this.getAmount();
                                 Object other$amount = other.getAmount();
                                 if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                    Object this$branchCompanyName = this.getBranchCompanyName();
                                    Object other$branchCompanyName = other.getBranchCompanyName();
                                    if (this$branchCompanyName == null
                                       ? other$branchCompanyName == null
                                       : this$branchCompanyName.equals(other$branchCompanyName)) {
                                       Object this$supplierName = this.getSupplierName();
                                       Object other$supplierName = other.getSupplierName();
                                       if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                          Object this$projectList = this.getProjectList();
                                          Object other$projectList = other.getProjectList();
                                          if (this$projectList == null ? other$projectList == null : this$projectList.equals(other$projectList)) {
                                             Object this$createUserName = this.getCreateUserName();
                                             Object other$createUserName = other.getCreateUserName();
                                             if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
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
                                                      Object this$paidAmount = this.getPaidAmount();
                                                      Object other$paidAmount = other.getPaidAmount();
                                                      if (this$paidAmount == null ? other$paidAmount == null : this$paidAmount.equals(other$paidAmount)) {
                                                         Object this$receivedInvoiceAmount = this.getReceivedInvoiceAmount();
                                                         Object other$receivedInvoiceAmount = other.getReceivedInvoiceAmount();
                                                         return this$receivedInvoiceAmount == null
                                                            ? other$receivedInvoiceAmount == null
                                                            : this$receivedInvoiceAmount.equals(other$receivedInvoiceAmount);
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
      return other instanceof SupplierSummaryPurchaseOrderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $purchaseType = this.getPurchaseType();
      result = result * 59 + ($purchaseType == null ? 43 : $purchaseType.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $projectList = this.getProjectList();
      result = result * 59 + ($projectList == null ? 43 : $projectList.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $inboundAmount = this.getInboundAmount();
      result = result * 59 + ($inboundAmount == null ? 43 : $inboundAmount.hashCode());
      Object $paidAmount = this.getPaidAmount();
      result = result * 59 + ($paidAmount == null ? 43 : $paidAmount.hashCode());
      Object $receivedInvoiceAmount = this.getReceivedInvoiceAmount();
      return result * 59 + ($receivedInvoiceAmount == null ? 43 : $receivedInvoiceAmount.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierSummaryPurchaseOrderDTO(id="
         + this.getId()
         + ", createTime="
         + this.getCreateTime()
         + ", purchaseType="
         + this.getPurchaseType()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", amount="
         + this.getAmount()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", projectList="
         + this.getProjectList()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", inboundAmount="
         + this.getInboundAmount()
         + ", paidAmount="
         + this.getPaidAmount()
         + ", receivedInvoiceAmount="
         + this.getReceivedInvoiceAmount()
         + ")";
   }

   public SupplierSummaryPurchaseOrderDTO(
      final Long id,
      final LocalDateTime createTime,
      final Integer purchaseType,
      final Integer basicClass,
      final String serialNumber,
      final BigDecimal amount,
      final Long branchCompanyId,
      final String branchCompanyName,
      final Long supplierId,
      final String supplierName,
      final List<ProjectInfo> projectList,
      final Long createUserId,
      final String createUserName,
      final Integer settlementStatus,
      final BigDecimal settlementAmount,
      final BigDecimal inboundAmount,
      final BigDecimal paidAmount,
      final BigDecimal receivedInvoiceAmount
   ) {
      this.id = id;
      this.createTime = createTime;
      this.purchaseType = purchaseType;
      this.basicClass = basicClass;
      this.serialNumber = serialNumber;
      this.amount = amount;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.projectList = projectList;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.settlementStatus = settlementStatus;
      this.settlementAmount = settlementAmount;
      this.inboundAmount = inboundAmount;
      this.paidAmount = paidAmount;
      this.receivedInvoiceAmount = receivedInvoiceAmount;
   }

   public SupplierSummaryPurchaseOrderDTO() {
   }

   public static class SupplierSummaryPurchaseOrderDTOBuilder {
      private Long id;
      private LocalDateTime createTime;
      private Integer purchaseType;
      private Integer basicClass;
      private String serialNumber;
      private BigDecimal amount;
      private Long branchCompanyId;
      private String branchCompanyName;
      private Long supplierId;
      private String supplierName;
      private List<ProjectInfo> projectList;
      private Long createUserId;
      private String createUserName;
      private Integer settlementStatus;
      private BigDecimal settlementAmount;
      private BigDecimal inboundAmount;
      private BigDecimal paidAmount;
      private BigDecimal receivedInvoiceAmount;

      SupplierSummaryPurchaseOrderDTOBuilder() {
      }

      public SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder purchaseType(final Integer purchaseType) {
         this.purchaseType = purchaseType;
         return this;
      }

      public SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder projectList(final List<ProjectInfo> projectList) {
         this.projectList = projectList;
         return this;
      }

      public SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder settlementStatus(final Integer settlementStatus) {
         this.settlementStatus = settlementStatus;
         return this;
      }

      public SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder inboundAmount(final BigDecimal inboundAmount) {
         this.inboundAmount = inboundAmount;
         return this;
      }

      public SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder paidAmount(final BigDecimal paidAmount) {
         this.paidAmount = paidAmount;
         return this;
      }

      public SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder receivedInvoiceAmount(final BigDecimal receivedInvoiceAmount) {
         this.receivedInvoiceAmount = receivedInvoiceAmount;
         return this;
      }

      public SupplierSummaryPurchaseOrderDTO build() {
         return new SupplierSummaryPurchaseOrderDTO(
            this.id,
            this.createTime,
            this.purchaseType,
            this.basicClass,
            this.serialNumber,
            this.amount,
            this.branchCompanyId,
            this.branchCompanyName,
            this.supplierId,
            this.supplierName,
            this.projectList,
            this.createUserId,
            this.createUserName,
            this.settlementStatus,
            this.settlementAmount,
            this.inboundAmount,
            this.paidAmount,
            this.receivedInvoiceAmount
         );
      }

      @Override
      public String toString() {
         return "SupplierSummaryPurchaseOrderDTO.SupplierSummaryPurchaseOrderDTOBuilder(id="
            + this.id
            + ", createTime="
            + this.createTime
            + ", purchaseType="
            + this.purchaseType
            + ", basicClass="
            + this.basicClass
            + ", serialNumber="
            + this.serialNumber
            + ", amount="
            + this.amount
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", projectList="
            + this.projectList
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", settlementStatus="
            + this.settlementStatus
            + ", settlementAmount="
            + this.settlementAmount
            + ", inboundAmount="
            + this.inboundAmount
            + ", paidAmount="
            + this.paidAmount
            + ", receivedInvoiceAmount="
            + this.receivedInvoiceAmount
            + ")";
      }
   }
}
