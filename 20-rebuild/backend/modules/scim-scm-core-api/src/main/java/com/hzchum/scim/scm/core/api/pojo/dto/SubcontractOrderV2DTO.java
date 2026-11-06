package com.hzchum.scim.scm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("SubcontractOrderDTO对象")
public class SubcontractOrderV2DTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "分包合同编号", notes = "分包合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "createDate", value = "创建时间", notes = "创建时间")
   private LocalDateTime createDate;
   @ApiModelProperty(name = "subSupplyTypeEnum", value = "分供类型", notes = "分供类型")
   private Long subSupplyTypeEnum;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id", notes = "分支机构id")
   private Long branchCompanyId;
   @ApiModelProperty(name = "branchCompanyName", value = "分支机构名称", notes = "分支机构名称")
   private String branchCompanyName;
   @ApiModelProperty(name = "supplierInfo", value = "供应商", notes = "供应商")
   private SupplierInfo supplier;
   @ApiModelProperty("合同额")
   private BigDecimal amount;
   @ApiModelProperty(name = "boolSettlementStatus", value = "结算状态 true 已结算 false 未结算", notes = "结算状态 true 已结算 false 未结算")
   private Boolean boolSettlementStatus;
   @ApiModelProperty("结算额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("预结算额")
   private BigDecimal preSettlementAmount;
   @ApiModelProperty("累计付款")
   private BigDecimal totalPayment;
   @ApiModelProperty("累计开票")
   private BigDecimal totalInvoice;
   @ApiModelProperty("付款率")
   private BigDecimal paymentRate;
   @ApiModelProperty("开票率")
   private BigDecimal invoiceRate;
   @ApiModelProperty("待审批-付款数")
   private Integer paymentSize;
   @ApiModelProperty("待审批-开票数")
   private Integer invoiceSize;
   @ApiModelProperty("待审批-结算数")
   private Integer settlementSize;
   @ApiModelProperty("待审批-预结算数")
   private Integer preSettlementSize;
   @ApiModelProperty("项目状态")
   private Integer projectStatus;
   @ApiModelProperty("创建人")
   private NameInfo user;
   @ApiModelProperty(name = "orderStatus", value = "订单状态 1进行中2暂停4已完成", notes = "订单状态 1进行中2暂停4已完成8已结算")
   private Integer orderStatus;

   public static SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder builder() {
      return new SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder();
   }

   public SubcontractOrderV2DTO() {
   }

   public SubcontractOrderV2DTO(
      final Long id,
      final String serialNumber,
      final ProjectInfo project,
      final LocalDateTime createDate,
      final Long subSupplyTypeEnum,
      final Long branchCompanyId,
      final String branchCompanyName,
      final SupplierInfo supplier,
      final BigDecimal amount,
      final Boolean boolSettlementStatus,
      final BigDecimal settlementAmount,
      final BigDecimal preSettlementAmount,
      final BigDecimal totalPayment,
      final BigDecimal totalInvoice,
      final BigDecimal paymentRate,
      final BigDecimal invoiceRate,
      final Integer paymentSize,
      final Integer invoiceSize,
      final Integer settlementSize,
      final Integer preSettlementSize,
      final Integer projectStatus,
      final NameInfo user,
      final Integer orderStatus
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.project = project;
      this.createDate = createDate;
      this.subSupplyTypeEnum = subSupplyTypeEnum;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.supplier = supplier;
      this.amount = amount;
      this.boolSettlementStatus = boolSettlementStatus;
      this.settlementAmount = settlementAmount;
      this.preSettlementAmount = preSettlementAmount;
      this.totalPayment = totalPayment;
      this.totalInvoice = totalInvoice;
      this.paymentRate = paymentRate;
      this.invoiceRate = invoiceRate;
      this.paymentSize = paymentSize;
      this.invoiceSize = invoiceSize;
      this.settlementSize = settlementSize;
      this.preSettlementSize = preSettlementSize;
      this.projectStatus = projectStatus;
      this.user = user;
      this.orderStatus = orderStatus;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public LocalDateTime getCreateDate() {
      return this.createDate;
   }

   public Long getSubSupplyTypeEnum() {
      return this.subSupplyTypeEnum;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public SupplierInfo getSupplier() {
      return this.supplier;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Boolean getBoolSettlementStatus() {
      return this.boolSettlementStatus;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getPreSettlementAmount() {
      return this.preSettlementAmount;
   }

   public BigDecimal getTotalPayment() {
      return this.totalPayment;
   }

   public BigDecimal getTotalInvoice() {
      return this.totalInvoice;
   }

   public BigDecimal getPaymentRate() {
      return this.paymentRate;
   }

   public BigDecimal getInvoiceRate() {
      return this.invoiceRate;
   }

   public Integer getPaymentSize() {
      return this.paymentSize;
   }

   public Integer getInvoiceSize() {
      return this.invoiceSize;
   }

   public Integer getSettlementSize() {
      return this.settlementSize;
   }

   public Integer getPreSettlementSize() {
      return this.preSettlementSize;
   }

   public Integer getProjectStatus() {
      return this.projectStatus;
   }

   public NameInfo getUser() {
      return this.user;
   }

   public Integer getOrderStatus() {
      return this.orderStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setCreateDate(final LocalDateTime createDate) {
      this.createDate = createDate;
   }

   public void setSubSupplyTypeEnum(final Long subSupplyTypeEnum) {
      this.subSupplyTypeEnum = subSupplyTypeEnum;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setSupplier(final SupplierInfo supplier) {
      this.supplier = supplier;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setBoolSettlementStatus(final Boolean boolSettlementStatus) {
      this.boolSettlementStatus = boolSettlementStatus;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setPreSettlementAmount(final BigDecimal preSettlementAmount) {
      this.preSettlementAmount = preSettlementAmount;
   }

   public void setTotalPayment(final BigDecimal totalPayment) {
      this.totalPayment = totalPayment;
   }

   public void setTotalInvoice(final BigDecimal totalInvoice) {
      this.totalInvoice = totalInvoice;
   }

   public void setPaymentRate(final BigDecimal paymentRate) {
      this.paymentRate = paymentRate;
   }

   public void setInvoiceRate(final BigDecimal invoiceRate) {
      this.invoiceRate = invoiceRate;
   }

   public void setPaymentSize(final Integer paymentSize) {
      this.paymentSize = paymentSize;
   }

   public void setInvoiceSize(final Integer invoiceSize) {
      this.invoiceSize = invoiceSize;
   }

   public void setSettlementSize(final Integer settlementSize) {
      this.settlementSize = settlementSize;
   }

   public void setPreSettlementSize(final Integer preSettlementSize) {
      this.preSettlementSize = preSettlementSize;
   }

   public void setProjectStatus(final Integer projectStatus) {
      this.projectStatus = projectStatus;
   }

   public void setUser(final NameInfo user) {
      this.user = user;
   }

   public void setOrderStatus(final Integer orderStatus) {
      this.orderStatus = orderStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubcontractOrderV2DTO)) {
         return false;
      }

      SubcontractOrderV2DTO other = (SubcontractOrderV2DTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$subSupplyTypeEnum = this.getSubSupplyTypeEnum();
         Object other$subSupplyTypeEnum = other.getSubSupplyTypeEnum();
         if (this$subSupplyTypeEnum == null ? other$subSupplyTypeEnum == null : this$subSupplyTypeEnum.equals(other$subSupplyTypeEnum)) {
            Object this$branchCompanyId = this.getBranchCompanyId();
            Object other$branchCompanyId = other.getBranchCompanyId();
            if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
               Object this$boolSettlementStatus = this.getBoolSettlementStatus();
               Object other$boolSettlementStatus = other.getBoolSettlementStatus();
               if (this$boolSettlementStatus == null ? other$boolSettlementStatus == null : this$boolSettlementStatus.equals(other$boolSettlementStatus)) {
                  Object this$paymentSize = this.getPaymentSize();
                  Object other$paymentSize = other.getPaymentSize();
                  if (this$paymentSize == null ? other$paymentSize == null : this$paymentSize.equals(other$paymentSize)) {
                     Object this$invoiceSize = this.getInvoiceSize();
                     Object other$invoiceSize = other.getInvoiceSize();
                     if (this$invoiceSize == null ? other$invoiceSize == null : this$invoiceSize.equals(other$invoiceSize)) {
                        Object this$settlementSize = this.getSettlementSize();
                        Object other$settlementSize = other.getSettlementSize();
                        if (this$settlementSize == null ? other$settlementSize == null : this$settlementSize.equals(other$settlementSize)) {
                           Object this$preSettlementSize = this.getPreSettlementSize();
                           Object other$preSettlementSize = other.getPreSettlementSize();
                           if (this$preSettlementSize == null ? other$preSettlementSize == null : this$preSettlementSize.equals(other$preSettlementSize)) {
                              Object this$projectStatus = this.getProjectStatus();
                              Object other$projectStatus = other.getProjectStatus();
                              if (this$projectStatus == null ? other$projectStatus == null : this$projectStatus.equals(other$projectStatus)) {
                                 Object this$orderStatus = this.getOrderStatus();
                                 Object other$orderStatus = other.getOrderStatus();
                                 if (this$orderStatus == null ? other$orderStatus == null : this$orderStatus.equals(other$orderStatus)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$project = this.getProject();
                                       Object other$project = other.getProject();
                                       if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                          Object this$createDate = this.getCreateDate();
                                          Object other$createDate = other.getCreateDate();
                                          if (this$createDate == null ? other$createDate == null : this$createDate.equals(other$createDate)) {
                                             Object this$branchCompanyName = this.getBranchCompanyName();
                                             Object other$branchCompanyName = other.getBranchCompanyName();
                                             if (this$branchCompanyName == null
                                                ? other$branchCompanyName == null
                                                : this$branchCompanyName.equals(other$branchCompanyName)) {
                                                Object this$supplier = this.getSupplier();
                                                Object other$supplier = other.getSupplier();
                                                if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
                                                   Object this$amount = this.getAmount();
                                                   Object other$amount = other.getAmount();
                                                   if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                      Object this$settlementAmount = this.getSettlementAmount();
                                                      Object other$settlementAmount = other.getSettlementAmount();
                                                      if (this$settlementAmount == null
                                                         ? other$settlementAmount == null
                                                         : this$settlementAmount.equals(other$settlementAmount)) {
                                                         Object this$preSettlementAmount = this.getPreSettlementAmount();
                                                         Object other$preSettlementAmount = other.getPreSettlementAmount();
                                                         if (this$preSettlementAmount == null
                                                            ? other$preSettlementAmount == null
                                                            : this$preSettlementAmount.equals(other$preSettlementAmount)) {
                                                            Object this$totalPayment = this.getTotalPayment();
                                                            Object other$totalPayment = other.getTotalPayment();
                                                            if (this$totalPayment == null
                                                               ? other$totalPayment == null
                                                               : this$totalPayment.equals(other$totalPayment)) {
                                                               Object this$totalInvoice = this.getTotalInvoice();
                                                               Object other$totalInvoice = other.getTotalInvoice();
                                                               if (this$totalInvoice == null
                                                                  ? other$totalInvoice == null
                                                                  : this$totalInvoice.equals(other$totalInvoice)) {
                                                                  Object this$paymentRate = this.getPaymentRate();
                                                                  Object other$paymentRate = other.getPaymentRate();
                                                                  if (this$paymentRate == null
                                                                     ? other$paymentRate == null
                                                                     : this$paymentRate.equals(other$paymentRate)) {
                                                                     Object this$invoiceRate = this.getInvoiceRate();
                                                                     Object other$invoiceRate = other.getInvoiceRate();
                                                                     if (this$invoiceRate == null
                                                                        ? other$invoiceRate == null
                                                                        : this$invoiceRate.equals(other$invoiceRate)) {
                                                                        Object this$user = this.getUser();
                                                                        Object other$user = other.getUser();
                                                                        return this$user == null ? other$user == null : this$user.equals(other$user);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SubcontractOrderV2DTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $subSupplyTypeEnum = this.getSubSupplyTypeEnum();
      result = result * 59 + ($subSupplyTypeEnum == null ? 43 : $subSupplyTypeEnum.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $boolSettlementStatus = this.getBoolSettlementStatus();
      result = result * 59 + ($boolSettlementStatus == null ? 43 : $boolSettlementStatus.hashCode());
      Object $paymentSize = this.getPaymentSize();
      result = result * 59 + ($paymentSize == null ? 43 : $paymentSize.hashCode());
      Object $invoiceSize = this.getInvoiceSize();
      result = result * 59 + ($invoiceSize == null ? 43 : $invoiceSize.hashCode());
      Object $settlementSize = this.getSettlementSize();
      result = result * 59 + ($settlementSize == null ? 43 : $settlementSize.hashCode());
      Object $preSettlementSize = this.getPreSettlementSize();
      result = result * 59 + ($preSettlementSize == null ? 43 : $preSettlementSize.hashCode());
      Object $projectStatus = this.getProjectStatus();
      result = result * 59 + ($projectStatus == null ? 43 : $projectStatus.hashCode());
      Object $orderStatus = this.getOrderStatus();
      result = result * 59 + ($orderStatus == null ? 43 : $orderStatus.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $createDate = this.getCreateDate();
      result = result * 59 + ($createDate == null ? 43 : $createDate.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $preSettlementAmount = this.getPreSettlementAmount();
      result = result * 59 + ($preSettlementAmount == null ? 43 : $preSettlementAmount.hashCode());
      Object $totalPayment = this.getTotalPayment();
      result = result * 59 + ($totalPayment == null ? 43 : $totalPayment.hashCode());
      Object $totalInvoice = this.getTotalInvoice();
      result = result * 59 + ($totalInvoice == null ? 43 : $totalInvoice.hashCode());
      Object $paymentRate = this.getPaymentRate();
      result = result * 59 + ($paymentRate == null ? 43 : $paymentRate.hashCode());
      Object $invoiceRate = this.getInvoiceRate();
      result = result * 59 + ($invoiceRate == null ? 43 : $invoiceRate.hashCode());
      Object $user = this.getUser();
      return result * 59 + ($user == null ? 43 : $user.hashCode());
   }

   @Override
   public String toString() {
      return "SubcontractOrderV2DTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", project="
         + this.getProject()
         + ", createDate="
         + this.getCreateDate()
         + ", subSupplyTypeEnum="
         + this.getSubSupplyTypeEnum()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", supplier="
         + this.getSupplier()
         + ", amount="
         + this.getAmount()
         + ", boolSettlementStatus="
         + this.getBoolSettlementStatus()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", preSettlementAmount="
         + this.getPreSettlementAmount()
         + ", totalPayment="
         + this.getTotalPayment()
         + ", totalInvoice="
         + this.getTotalInvoice()
         + ", paymentRate="
         + this.getPaymentRate()
         + ", invoiceRate="
         + this.getInvoiceRate()
         + ", paymentSize="
         + this.getPaymentSize()
         + ", invoiceSize="
         + this.getInvoiceSize()
         + ", settlementSize="
         + this.getSettlementSize()
         + ", preSettlementSize="
         + this.getPreSettlementSize()
         + ", projectStatus="
         + this.getProjectStatus()
         + ", user="
         + this.getUser()
         + ", orderStatus="
         + this.getOrderStatus()
         + ")";
   }

   public static class SubcontractOrderV2DTOBuilder {
      private Long id;
      private String serialNumber;
      private ProjectInfo project;
      private LocalDateTime createDate;
      private Long subSupplyTypeEnum;
      private Long branchCompanyId;
      private String branchCompanyName;
      private SupplierInfo supplier;
      private BigDecimal amount;
      private Boolean boolSettlementStatus;
      private BigDecimal settlementAmount;
      private BigDecimal preSettlementAmount;
      private BigDecimal totalPayment;
      private BigDecimal totalInvoice;
      private BigDecimal paymentRate;
      private BigDecimal invoiceRate;
      private Integer paymentSize;
      private Integer invoiceSize;
      private Integer settlementSize;
      private Integer preSettlementSize;
      private Integer projectStatus;
      private NameInfo user;
      private Integer orderStatus;

      SubcontractOrderV2DTOBuilder() {
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder createDate(final LocalDateTime createDate) {
         this.createDate = createDate;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder subSupplyTypeEnum(final Long subSupplyTypeEnum) {
         this.subSupplyTypeEnum = subSupplyTypeEnum;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder supplier(final SupplierInfo supplier) {
         this.supplier = supplier;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder boolSettlementStatus(final Boolean boolSettlementStatus) {
         this.boolSettlementStatus = boolSettlementStatus;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder preSettlementAmount(final BigDecimal preSettlementAmount) {
         this.preSettlementAmount = preSettlementAmount;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder totalPayment(final BigDecimal totalPayment) {
         this.totalPayment = totalPayment;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder totalInvoice(final BigDecimal totalInvoice) {
         this.totalInvoice = totalInvoice;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder paymentRate(final BigDecimal paymentRate) {
         this.paymentRate = paymentRate;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder invoiceRate(final BigDecimal invoiceRate) {
         this.invoiceRate = invoiceRate;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder paymentSize(final Integer paymentSize) {
         this.paymentSize = paymentSize;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder invoiceSize(final Integer invoiceSize) {
         this.invoiceSize = invoiceSize;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder settlementSize(final Integer settlementSize) {
         this.settlementSize = settlementSize;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder preSettlementSize(final Integer preSettlementSize) {
         this.preSettlementSize = preSettlementSize;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder projectStatus(final Integer projectStatus) {
         this.projectStatus = projectStatus;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder user(final NameInfo user) {
         this.user = user;
         return this;
      }

      public SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder orderStatus(final Integer orderStatus) {
         this.orderStatus = orderStatus;
         return this;
      }

      public SubcontractOrderV2DTO build() {
         return new SubcontractOrderV2DTO(
            this.id,
            this.serialNumber,
            this.project,
            this.createDate,
            this.subSupplyTypeEnum,
            this.branchCompanyId,
            this.branchCompanyName,
            this.supplier,
            this.amount,
            this.boolSettlementStatus,
            this.settlementAmount,
            this.preSettlementAmount,
            this.totalPayment,
            this.totalInvoice,
            this.paymentRate,
            this.invoiceRate,
            this.paymentSize,
            this.invoiceSize,
            this.settlementSize,
            this.preSettlementSize,
            this.projectStatus,
            this.user,
            this.orderStatus
         );
      }

      @Override
      public String toString() {
         return "SubcontractOrderV2DTO.SubcontractOrderV2DTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", project="
            + this.project
            + ", createDate="
            + this.createDate
            + ", subSupplyTypeEnum="
            + this.subSupplyTypeEnum
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", supplier="
            + this.supplier
            + ", amount="
            + this.amount
            + ", boolSettlementStatus="
            + this.boolSettlementStatus
            + ", settlementAmount="
            + this.settlementAmount
            + ", preSettlementAmount="
            + this.preSettlementAmount
            + ", totalPayment="
            + this.totalPayment
            + ", totalInvoice="
            + this.totalInvoice
            + ", paymentRate="
            + this.paymentRate
            + ", invoiceRate="
            + this.invoiceRate
            + ", paymentSize="
            + this.paymentSize
            + ", invoiceSize="
            + this.invoiceSize
            + ", settlementSize="
            + this.settlementSize
            + ", preSettlementSize="
            + this.preSettlementSize
            + ", projectStatus="
            + this.projectStatus
            + ", user="
            + this.user
            + ", orderStatus="
            + this.orderStatus
            + ")";
      }
   }
}
