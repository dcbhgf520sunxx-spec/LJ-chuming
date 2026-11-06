package com.hzchum.scim.contract.core.api.pojo.dtoParam.project;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class SupplierLedgerParam {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("供应商id")
   private Long supplierId;
   @ApiModelProperty("订单编号")
   private String serialNumber;
   @ApiModelProperty("结算状态 1已结算 0未结算")
   private Integer settlementStatus;
   @ApiModelProperty("订单类型 1原材料 2制成品 4物流 8分包 16其他")
   private Integer purchaseType;
   @ApiModelProperty("年份")
   private LocalDateTime year;
   @ApiModelProperty("单位等级 1一级单位 2二级单位")
   private Integer level;
   @ApiModelProperty("分支机构id")
   private Long branchCompanyId;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public Integer getPurchaseType() {
      return this.purchaseType;
   }

   public LocalDateTime getYear() {
      return this.year;
   }

   public Integer getLevel() {
      return this.level;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setPurchaseType(final Integer purchaseType) {
      this.purchaseType = purchaseType;
   }

   public void setYear(final LocalDateTime year) {
      this.year = year;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierLedgerParam)) {
         return false;
      }

      SupplierLedgerParam other = (SupplierLedgerParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$settlementStatus = this.getSettlementStatus();
            Object other$settlementStatus = other.getSettlementStatus();
            if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
               Object this$purchaseType = this.getPurchaseType();
               Object other$purchaseType = other.getPurchaseType();
               if (this$purchaseType == null ? other$purchaseType == null : this$purchaseType.equals(other$purchaseType)) {
                  Object this$level = this.getLevel();
                  Object other$level = other.getLevel();
                  if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                     Object this$branchCompanyId = this.getBranchCompanyId();
                     Object other$branchCompanyId = other.getBranchCompanyId();
                     if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$year = this.getYear();
                           Object other$year = other.getYear();
                           return this$year == null ? other$year == null : this$year.equals(other$year);
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
      return other instanceof SupplierLedgerParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $purchaseType = this.getPurchaseType();
      result = result * 59 + ($purchaseType == null ? 43 : $purchaseType.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $year = this.getYear();
      return result * 59 + ($year == null ? 43 : $year.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierLedgerParam(projectId="
         + this.getProjectId()
         + ", supplierId="
         + this.getSupplierId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", purchaseType="
         + this.getPurchaseType()
         + ", year="
         + this.getYear()
         + ", level="
         + this.getLevel()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ")";
   }
}
