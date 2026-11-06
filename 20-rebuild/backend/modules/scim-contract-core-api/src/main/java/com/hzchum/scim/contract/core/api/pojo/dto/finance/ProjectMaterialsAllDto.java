package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiOperation("成本报表返回表-材料支出明细")
public class ProjectMaterialsAllDto {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("签订日期")
   private LocalDateTime signingDate;
   @ApiModelProperty("状态")
   private Integer status;
   @ApiModelProperty("状态")
   private String statusName;
   @ApiModelProperty("类型")
   private Integer basicClass;
   @ApiModelProperty("供应商id")
   private Long supplierId;
   @ApiModelProperty("供应商")
   private String supplierName;
   @ApiModelProperty("合同编号")
   private String serialNumber;
   @ApiModelProperty("合同额")
   private BigDecimal contractAmount;
   @ApiModelProperty("预结算总额")
   private BigDecimal preSettlementAmount;
   @ApiModelProperty("结算状态")
   private Integer settlementStatus;
   @ApiModelProperty("结算金额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("累计已付款")
   private BigDecimal totalPaid;
   @ApiModelProperty("未付款")
   private BigDecimal unpaid;
   @ApiModelProperty("成本")
   private BigDecimal cost;

   public static ProjectMaterialsAllDto.ProjectMaterialsAllDtoBuilder builder() {
      return new ProjectMaterialsAllDto.ProjectMaterialsAllDtoBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getSigningDate() {
      return this.signingDate;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getStatusName() {
      return this.statusName;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getPreSettlementAmount() {
      return this.preSettlementAmount;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getTotalPaid() {
      return this.totalPaid;
   }

   public BigDecimal getUnpaid() {
      return this.unpaid;
   }

   public BigDecimal getCost() {
      return this.cost;
   }

   public ProjectMaterialsAllDto setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectMaterialsAllDto setSigningDate(final LocalDateTime signingDate) {
      this.signingDate = signingDate;
      return this;
   }

   public ProjectMaterialsAllDto setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public ProjectMaterialsAllDto setStatusName(final String statusName) {
      this.statusName = statusName;
      return this;
   }

   public ProjectMaterialsAllDto setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public ProjectMaterialsAllDto setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public ProjectMaterialsAllDto setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public ProjectMaterialsAllDto setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ProjectMaterialsAllDto setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
      return this;
   }

   public ProjectMaterialsAllDto setPreSettlementAmount(final BigDecimal preSettlementAmount) {
      this.preSettlementAmount = preSettlementAmount;
      return this;
   }

   public ProjectMaterialsAllDto setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
      return this;
   }

   public ProjectMaterialsAllDto setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
      return this;
   }

   public ProjectMaterialsAllDto setTotalPaid(final BigDecimal totalPaid) {
      this.totalPaid = totalPaid;
      return this;
   }

   public ProjectMaterialsAllDto setUnpaid(final BigDecimal unpaid) {
      this.unpaid = unpaid;
      return this;
   }

   public ProjectMaterialsAllDto setCost(final BigDecimal cost) {
      this.cost = cost;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectMaterialsAllDto)) {
         return false;
      }

      ProjectMaterialsAllDto other = (ProjectMaterialsAllDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$supplierId = this.getSupplierId();
               Object other$supplierId = other.getSupplierId();
               if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                  Object this$settlementStatus = this.getSettlementStatus();
                  Object other$settlementStatus = other.getSettlementStatus();
                  if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
                     Object this$signingDate = this.getSigningDate();
                     Object other$signingDate = other.getSigningDate();
                     if (this$signingDate == null ? other$signingDate == null : this$signingDate.equals(other$signingDate)) {
                        Object this$statusName = this.getStatusName();
                        Object other$statusName = other.getStatusName();
                        if (this$statusName == null ? other$statusName == null : this$statusName.equals(other$statusName)) {
                           Object this$supplierName = this.getSupplierName();
                           Object other$supplierName = other.getSupplierName();
                           if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$contractAmount = this.getContractAmount();
                                 Object other$contractAmount = other.getContractAmount();
                                 if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                                    Object this$preSettlementAmount = this.getPreSettlementAmount();
                                    Object other$preSettlementAmount = other.getPreSettlementAmount();
                                    if (this$preSettlementAmount == null
                                       ? other$preSettlementAmount == null
                                       : this$preSettlementAmount.equals(other$preSettlementAmount)) {
                                       Object this$settlementAmount = this.getSettlementAmount();
                                       Object other$settlementAmount = other.getSettlementAmount();
                                       if (this$settlementAmount == null
                                          ? other$settlementAmount == null
                                          : this$settlementAmount.equals(other$settlementAmount)) {
                                          Object this$totalPaid = this.getTotalPaid();
                                          Object other$totalPaid = other.getTotalPaid();
                                          if (this$totalPaid == null ? other$totalPaid == null : this$totalPaid.equals(other$totalPaid)) {
                                             Object this$unpaid = this.getUnpaid();
                                             Object other$unpaid = other.getUnpaid();
                                             if (this$unpaid == null ? other$unpaid == null : this$unpaid.equals(other$unpaid)) {
                                                Object this$cost = this.getCost();
                                                Object other$cost = other.getCost();
                                                return this$cost == null ? other$cost == null : this$cost.equals(other$cost);
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
      return other instanceof ProjectMaterialsAllDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $signingDate = this.getSigningDate();
      result = result * 59 + ($signingDate == null ? 43 : $signingDate.hashCode());
      Object $statusName = this.getStatusName();
      result = result * 59 + ($statusName == null ? 43 : $statusName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $preSettlementAmount = this.getPreSettlementAmount();
      result = result * 59 + ($preSettlementAmount == null ? 43 : $preSettlementAmount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $totalPaid = this.getTotalPaid();
      result = result * 59 + ($totalPaid == null ? 43 : $totalPaid.hashCode());
      Object $unpaid = this.getUnpaid();
      result = result * 59 + ($unpaid == null ? 43 : $unpaid.hashCode());
      Object $cost = this.getCost();
      return result * 59 + ($cost == null ? 43 : $cost.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectMaterialsAllDto(id="
         + this.getId()
         + ", signingDate="
         + this.getSigningDate()
         + ", status="
         + this.getStatus()
         + ", statusName="
         + this.getStatusName()
         + ", basicClass="
         + this.getBasicClass()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", contractAmount="
         + this.getContractAmount()
         + ", preSettlementAmount="
         + this.getPreSettlementAmount()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", totalPaid="
         + this.getTotalPaid()
         + ", unpaid="
         + this.getUnpaid()
         + ", cost="
         + this.getCost()
         + ")";
   }

   public ProjectMaterialsAllDto(
      final Long id,
      final LocalDateTime signingDate,
      final Integer status,
      final String statusName,
      final Integer basicClass,
      final Long supplierId,
      final String supplierName,
      final String serialNumber,
      final BigDecimal contractAmount,
      final BigDecimal preSettlementAmount,
      final Integer settlementStatus,
      final BigDecimal settlementAmount,
      final BigDecimal totalPaid,
      final BigDecimal unpaid,
      final BigDecimal cost
   ) {
      this.id = id;
      this.signingDate = signingDate;
      this.status = status;
      this.statusName = statusName;
      this.basicClass = basicClass;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.serialNumber = serialNumber;
      this.contractAmount = contractAmount;
      this.preSettlementAmount = preSettlementAmount;
      this.settlementStatus = settlementStatus;
      this.settlementAmount = settlementAmount;
      this.totalPaid = totalPaid;
      this.unpaid = unpaid;
      this.cost = cost;
   }

   public ProjectMaterialsAllDto() {
   }

   public static class ProjectMaterialsAllDtoBuilder {
      private Long id;
      private LocalDateTime signingDate;
      private Integer status;
      private String statusName;
      private Integer basicClass;
      private Long supplierId;
      private String supplierName;
      private String serialNumber;
      private BigDecimal contractAmount;
      private BigDecimal preSettlementAmount;
      private Integer settlementStatus;
      private BigDecimal settlementAmount;
      private BigDecimal totalPaid;
      private BigDecimal unpaid;
      private BigDecimal cost;

      ProjectMaterialsAllDtoBuilder() {
      }

      public ProjectMaterialsAllDto.ProjectMaterialsAllDtoBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectMaterialsAllDto.ProjectMaterialsAllDtoBuilder signingDate(final LocalDateTime signingDate) {
         this.signingDate = signingDate;
         return this;
      }

      public ProjectMaterialsAllDto.ProjectMaterialsAllDtoBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ProjectMaterialsAllDto.ProjectMaterialsAllDtoBuilder statusName(final String statusName) {
         this.statusName = statusName;
         return this;
      }

      public ProjectMaterialsAllDto.ProjectMaterialsAllDtoBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ProjectMaterialsAllDto.ProjectMaterialsAllDtoBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectMaterialsAllDto.ProjectMaterialsAllDtoBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectMaterialsAllDto.ProjectMaterialsAllDtoBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectMaterialsAllDto.ProjectMaterialsAllDtoBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ProjectMaterialsAllDto.ProjectMaterialsAllDtoBuilder preSettlementAmount(final BigDecimal preSettlementAmount) {
         this.preSettlementAmount = preSettlementAmount;
         return this;
      }

      public ProjectMaterialsAllDto.ProjectMaterialsAllDtoBuilder settlementStatus(final Integer settlementStatus) {
         this.settlementStatus = settlementStatus;
         return this;
      }

      public ProjectMaterialsAllDto.ProjectMaterialsAllDtoBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public ProjectMaterialsAllDto.ProjectMaterialsAllDtoBuilder totalPaid(final BigDecimal totalPaid) {
         this.totalPaid = totalPaid;
         return this;
      }

      public ProjectMaterialsAllDto.ProjectMaterialsAllDtoBuilder unpaid(final BigDecimal unpaid) {
         this.unpaid = unpaid;
         return this;
      }

      public ProjectMaterialsAllDto.ProjectMaterialsAllDtoBuilder cost(final BigDecimal cost) {
         this.cost = cost;
         return this;
      }

      public ProjectMaterialsAllDto build() {
         return new ProjectMaterialsAllDto(
            this.id,
            this.signingDate,
            this.status,
            this.statusName,
            this.basicClass,
            this.supplierId,
            this.supplierName,
            this.serialNumber,
            this.contractAmount,
            this.preSettlementAmount,
            this.settlementStatus,
            this.settlementAmount,
            this.totalPaid,
            this.unpaid,
            this.cost
         );
      }

      @Override
      public String toString() {
         return "ProjectMaterialsAllDto.ProjectMaterialsAllDtoBuilder(id="
            + this.id
            + ", signingDate="
            + this.signingDate
            + ", status="
            + this.status
            + ", statusName="
            + this.statusName
            + ", basicClass="
            + this.basicClass
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", serialNumber="
            + this.serialNumber
            + ", contractAmount="
            + this.contractAmount
            + ", preSettlementAmount="
            + this.preSettlementAmount
            + ", settlementStatus="
            + this.settlementStatus
            + ", settlementAmount="
            + this.settlementAmount
            + ", totalPaid="
            + this.totalPaid
            + ", unpaid="
            + this.unpaid
            + ", cost="
            + this.cost
            + ")";
      }
   }
}
