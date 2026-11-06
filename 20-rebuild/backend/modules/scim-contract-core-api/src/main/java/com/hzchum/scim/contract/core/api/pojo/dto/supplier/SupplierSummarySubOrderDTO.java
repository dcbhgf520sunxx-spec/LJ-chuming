package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SupplierSummarySubOrderDTO {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty("合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "subcontractClassId", value = "分包类别id", notes = "分包类别id")
   private Long subcontractClassId;
   @ApiModelProperty(name = "subcontractClassName", value = "分包类别名称", notes = "分包类别名称")
   private String subcontractClassName;
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
   @ApiModelProperty("合同额")
   private BigDecimal amount;
   @ApiModelProperty("结算状态 0未结算 1已结算")
   private Integer settlementStatus;
   @ApiModelProperty("结算额（元）")
   private BigDecimal settlementAmount;
   @ApiModelProperty(notes = "已付款额")
   private BigDecimal paidAmount;
   @ApiModelProperty(notes = "已收票额")
   private BigDecimal receivedInvoiceAmount;

   public static SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder builder() {
      return new SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getSubcontractClassId() {
      return this.subcontractClassId;
   }

   public String getSubcontractClassName() {
      return this.subcontractClassName;
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

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
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

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSubcontractClassId(final Long subcontractClassId) {
      this.subcontractClassId = subcontractClassId;
   }

   public void setSubcontractClassName(final String subcontractClassName) {
      this.subcontractClassName = subcontractClassName;
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

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
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

      if (!(o instanceof SupplierSummarySubOrderDTO)) {
         return false;
      }

      SupplierSummarySubOrderDTO other = (SupplierSummarySubOrderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$subcontractClassId = this.getSubcontractClassId();
         Object other$subcontractClassId = other.getSubcontractClassId();
         if (this$subcontractClassId == null ? other$subcontractClassId == null : this$subcontractClassId.equals(other$subcontractClassId)) {
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
                              Object this$subcontractClassName = this.getSubcontractClassName();
                              Object other$subcontractClassName = other.getSubcontractClassName();
                              if (this$subcontractClassName == null
                                 ? other$subcontractClassName == null
                                 : this$subcontractClassName.equals(other$subcontractClassName)) {
                                 Object this$branchCompanyName = this.getBranchCompanyName();
                                 Object other$branchCompanyName = other.getBranchCompanyName();
                                 if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
                                    Object this$supplierName = this.getSupplierName();
                                    Object other$supplierName = other.getSupplierName();
                                    if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                       Object this$projectList = this.getProjectList();
                                       Object other$projectList = other.getProjectList();
                                       if (this$projectList == null ? other$projectList == null : this$projectList.equals(other$projectList)) {
                                          Object this$createUserName = this.getCreateUserName();
                                          Object other$createUserName = other.getCreateUserName();
                                          if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                                             Object this$amount = this.getAmount();
                                             Object other$amount = other.getAmount();
                                             if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                Object this$settlementAmount = this.getSettlementAmount();
                                                Object other$settlementAmount = other.getSettlementAmount();
                                                if (this$settlementAmount == null
                                                   ? other$settlementAmount == null
                                                   : this$settlementAmount.equals(other$settlementAmount)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SupplierSummarySubOrderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $subcontractClassId = this.getSubcontractClassId();
      result = result * 59 + ($subcontractClassId == null ? 43 : $subcontractClassId.hashCode());
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
      Object $subcontractClassName = this.getSubcontractClassName();
      result = result * 59 + ($subcontractClassName == null ? 43 : $subcontractClassName.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $projectList = this.getProjectList();
      result = result * 59 + ($projectList == null ? 43 : $projectList.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $paidAmount = this.getPaidAmount();
      result = result * 59 + ($paidAmount == null ? 43 : $paidAmount.hashCode());
      Object $receivedInvoiceAmount = this.getReceivedInvoiceAmount();
      return result * 59 + ($receivedInvoiceAmount == null ? 43 : $receivedInvoiceAmount.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierSummarySubOrderDTO(id="
         + this.getId()
         + ", createTime="
         + this.getCreateTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", subcontractClassId="
         + this.getSubcontractClassId()
         + ", subcontractClassName="
         + this.getSubcontractClassName()
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
         + ", amount="
         + this.getAmount()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", paidAmount="
         + this.getPaidAmount()
         + ", receivedInvoiceAmount="
         + this.getReceivedInvoiceAmount()
         + ")";
   }

   public SupplierSummarySubOrderDTO(
      final Long id,
      final LocalDateTime createTime,
      final String serialNumber,
      final Long subcontractClassId,
      final String subcontractClassName,
      final Long branchCompanyId,
      final String branchCompanyName,
      final Long supplierId,
      final String supplierName,
      final List<ProjectInfo> projectList,
      final Long createUserId,
      final String createUserName,
      final BigDecimal amount,
      final Integer settlementStatus,
      final BigDecimal settlementAmount,
      final BigDecimal paidAmount,
      final BigDecimal receivedInvoiceAmount
   ) {
      this.id = id;
      this.createTime = createTime;
      this.serialNumber = serialNumber;
      this.subcontractClassId = subcontractClassId;
      this.subcontractClassName = subcontractClassName;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.projectList = projectList;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.amount = amount;
      this.settlementStatus = settlementStatus;
      this.settlementAmount = settlementAmount;
      this.paidAmount = paidAmount;
      this.receivedInvoiceAmount = receivedInvoiceAmount;
   }

   public SupplierSummarySubOrderDTO() {
   }

   public static class SupplierSummarySubOrderDTOBuilder {
      private Long id;
      private LocalDateTime createTime;
      private String serialNumber;
      private Long subcontractClassId;
      private String subcontractClassName;
      private Long branchCompanyId;
      private String branchCompanyName;
      private Long supplierId;
      private String supplierName;
      private List<ProjectInfo> projectList;
      private Long createUserId;
      private String createUserName;
      private BigDecimal amount;
      private Integer settlementStatus;
      private BigDecimal settlementAmount;
      private BigDecimal paidAmount;
      private BigDecimal receivedInvoiceAmount;

      SupplierSummarySubOrderDTOBuilder() {
      }

      public SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this;
      }

      public SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder subcontractClassName(final String subcontractClassName) {
         this.subcontractClassName = subcontractClassName;
         return this;
      }

      public SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder projectList(final List<ProjectInfo> projectList) {
         this.projectList = projectList;
         return this;
      }

      public SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder settlementStatus(final Integer settlementStatus) {
         this.settlementStatus = settlementStatus;
         return this;
      }

      public SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder paidAmount(final BigDecimal paidAmount) {
         this.paidAmount = paidAmount;
         return this;
      }

      public SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder receivedInvoiceAmount(final BigDecimal receivedInvoiceAmount) {
         this.receivedInvoiceAmount = receivedInvoiceAmount;
         return this;
      }

      public SupplierSummarySubOrderDTO build() {
         return new SupplierSummarySubOrderDTO(
            this.id,
            this.createTime,
            this.serialNumber,
            this.subcontractClassId,
            this.subcontractClassName,
            this.branchCompanyId,
            this.branchCompanyName,
            this.supplierId,
            this.supplierName,
            this.projectList,
            this.createUserId,
            this.createUserName,
            this.amount,
            this.settlementStatus,
            this.settlementAmount,
            this.paidAmount,
            this.receivedInvoiceAmount
         );
      }

      @Override
      public String toString() {
         return "SupplierSummarySubOrderDTO.SupplierSummarySubOrderDTOBuilder(id="
            + this.id
            + ", createTime="
            + this.createTime
            + ", serialNumber="
            + this.serialNumber
            + ", subcontractClassId="
            + this.subcontractClassId
            + ", subcontractClassName="
            + this.subcontractClassName
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
            + ", amount="
            + this.amount
            + ", settlementStatus="
            + this.settlementStatus
            + ", settlementAmount="
            + this.settlementAmount
            + ", paidAmount="
            + this.paidAmount
            + ", receivedInvoiceAmount="
            + this.receivedInvoiceAmount
            + ")";
      }
   }
}
