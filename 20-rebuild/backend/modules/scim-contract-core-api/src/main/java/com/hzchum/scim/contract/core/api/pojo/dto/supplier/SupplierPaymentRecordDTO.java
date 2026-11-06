package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("供应商付款台账列表")
public class SupplierPaymentRecordDTO {
   @ApiModelProperty("订单id ")
   private Long id;
   @ApiModelProperty("采购单号")
   private String serialNumber;
   @ApiModelProperty("项目id")
   private String projectIds;
   @ApiModelProperty("项目信息")
   private List<ProjectInfo> projects;
   @ApiModelProperty("采购类型[1 原材料采购,2 制成品采购]")
   private Integer purchaseType;
   @ApiModelProperty("采购状态[1 采购中,2 采购完成]")
   private Integer purchaseStatus;
   @ApiModelProperty("基础物料分类")
   private Integer basicClass;
   @ApiModelProperty(name = "supplyType", value = "供货类型[1 自采,2 甲供]")
   private Integer supplyType;
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
   @ApiModelProperty(name = "mete", value = "合同量")
   private BigDecimal mete;
   @ApiModelProperty(name = "meteUnit", value = "单位")
   private String meteUnit;
   @ApiModelProperty("合同额")
   private BigDecimal amount;
   @ApiModelProperty("结算状态[待确定]")
   private Integer settlementStatus;
   @ApiModelProperty("创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "signingTime", value = "签订时间")
   private LocalDateTime signingTime;
   @ApiModelProperty("结算额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("未审核结算数")
   private Integer unCheckSettlementCount;
   @ApiModelProperty("未审核结算额")
   private BigDecimal unCheckSettlementAmount;
   @ApiModelProperty("结算附件")
   private List<AttachmentDTO> attachmentDTOS;
   @ApiModelProperty("结算备注")
   private String settlementRemark;
   @ApiModelProperty("付款额")
   private BigDecimal paymentAmount;
   @ApiModelProperty("未审核付款数")
   private Integer unCheckPaymentCount;
   @ApiModelProperty("收票额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("未审核收票数")
   private Integer unCheckInvoiceCount;
   @ApiModelProperty("入库额")
   private BigDecimal inboundAmount;
   @ApiModelProperty("最后一次付款金额")
   private BigDecimal lastPaymentAmount;
   @ApiModelProperty("最后一次付款时间")
   private LocalDateTime lastPaymentTime;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 [1 专用增值税发票,2 普通增值税发票,4 收据]")
   private Integer invoiceType;
   @ApiModelProperty(name = "taxRate", value = "税率(百分比)")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "logisticsPayerType", value = "付款方 1需方承担 2供方承担,参考[LogisticsPayerEnum]")
   private Integer logisticsPayerType;

   public static SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder builder() {
      return new SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder();
   }

   public SupplierPaymentRecordDTO() {
   }

   public SupplierPaymentRecordDTO(
      final Long id,
      final String serialNumber,
      final String projectIds,
      final List<ProjectInfo> projects,
      final Integer purchaseType,
      final Integer purchaseStatus,
      final Integer basicClass,
      final Integer supplyType,
      final Long branchCompanyId,
      final String branchCompanyName,
      final Long supplierId,
      final String supplierName,
      final String supplierBankName,
      final String supplierBankAccount,
      final BigDecimal mete,
      final String meteUnit,
      final BigDecimal amount,
      final Integer settlementStatus,
      final LocalDateTime createTime,
      final LocalDateTime signingTime,
      final BigDecimal settlementAmount,
      final Integer unCheckSettlementCount,
      final BigDecimal unCheckSettlementAmount,
      final List<AttachmentDTO> attachmentDTOS,
      final String settlementRemark,
      final BigDecimal paymentAmount,
      final Integer unCheckPaymentCount,
      final BigDecimal invoiceAmount,
      final Integer unCheckInvoiceCount,
      final BigDecimal inboundAmount,
      final BigDecimal lastPaymentAmount,
      final LocalDateTime lastPaymentTime,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final Integer logisticsPayerType
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.projectIds = projectIds;
      this.projects = projects;
      this.purchaseType = purchaseType;
      this.purchaseStatus = purchaseStatus;
      this.basicClass = basicClass;
      this.supplyType = supplyType;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.supplierBankName = supplierBankName;
      this.supplierBankAccount = supplierBankAccount;
      this.mete = mete;
      this.meteUnit = meteUnit;
      this.amount = amount;
      this.settlementStatus = settlementStatus;
      this.createTime = createTime;
      this.signingTime = signingTime;
      this.settlementAmount = settlementAmount;
      this.unCheckSettlementCount = unCheckSettlementCount;
      this.unCheckSettlementAmount = unCheckSettlementAmount;
      this.attachmentDTOS = attachmentDTOS;
      this.settlementRemark = settlementRemark;
      this.paymentAmount = paymentAmount;
      this.unCheckPaymentCount = unCheckPaymentCount;
      this.invoiceAmount = invoiceAmount;
      this.unCheckInvoiceCount = unCheckInvoiceCount;
      this.inboundAmount = inboundAmount;
      this.lastPaymentAmount = lastPaymentAmount;
      this.lastPaymentTime = lastPaymentTime;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.logisticsPayerType = logisticsPayerType;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public List<ProjectInfo> getProjects() {
      return this.projects;
   }

   public Integer getPurchaseType() {
      return this.purchaseType;
   }

   public Integer getPurchaseStatus() {
      return this.purchaseStatus;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getSupplyType() {
      return this.supplyType;
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

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getMeteUnit() {
      return this.meteUnit;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getSigningTime() {
      return this.signingTime;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public Integer getUnCheckSettlementCount() {
      return this.unCheckSettlementCount;
   }

   public BigDecimal getUnCheckSettlementAmount() {
      return this.unCheckSettlementAmount;
   }

   public List<AttachmentDTO> getAttachmentDTOS() {
      return this.attachmentDTOS;
   }

   public String getSettlementRemark() {
      return this.settlementRemark;
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

   public Integer getUnCheckInvoiceCount() {
      return this.unCheckInvoiceCount;
   }

   public BigDecimal getInboundAmount() {
      return this.inboundAmount;
   }

   public BigDecimal getLastPaymentAmount() {
      return this.lastPaymentAmount;
   }

   public LocalDateTime getLastPaymentTime() {
      return this.lastPaymentTime;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Integer getLogisticsPayerType() {
      return this.logisticsPayerType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
   }

   public void setProjects(final List<ProjectInfo> projects) {
      this.projects = projects;
   }

   public void setPurchaseType(final Integer purchaseType) {
      this.purchaseType = purchaseType;
   }

   public void setPurchaseStatus(final Integer purchaseStatus) {
      this.purchaseStatus = purchaseStatus;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSupplyType(final Integer supplyType) {
      this.supplyType = supplyType;
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

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setMeteUnit(final String meteUnit) {
      this.meteUnit = meteUnit;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setSigningTime(final LocalDateTime signingTime) {
      this.signingTime = signingTime;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setUnCheckSettlementCount(final Integer unCheckSettlementCount) {
      this.unCheckSettlementCount = unCheckSettlementCount;
   }

   public void setUnCheckSettlementAmount(final BigDecimal unCheckSettlementAmount) {
      this.unCheckSettlementAmount = unCheckSettlementAmount;
   }

   public void setAttachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
      this.attachmentDTOS = attachmentDTOS;
   }

   public void setSettlementRemark(final String settlementRemark) {
      this.settlementRemark = settlementRemark;
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

   public void setUnCheckInvoiceCount(final Integer unCheckInvoiceCount) {
      this.unCheckInvoiceCount = unCheckInvoiceCount;
   }

   public void setInboundAmount(final BigDecimal inboundAmount) {
      this.inboundAmount = inboundAmount;
   }

   public void setLastPaymentAmount(final BigDecimal lastPaymentAmount) {
      this.lastPaymentAmount = lastPaymentAmount;
   }

   public void setLastPaymentTime(final LocalDateTime lastPaymentTime) {
      this.lastPaymentTime = lastPaymentTime;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setLogisticsPayerType(final Integer logisticsPayerType) {
      this.logisticsPayerType = logisticsPayerType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierPaymentRecordDTO)) {
         return false;
      }

      SupplierPaymentRecordDTO other = (SupplierPaymentRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$purchaseType = this.getPurchaseType();
         Object other$purchaseType = other.getPurchaseType();
         if (this$purchaseType == null ? other$purchaseType == null : this$purchaseType.equals(other$purchaseType)) {
            Object this$purchaseStatus = this.getPurchaseStatus();
            Object other$purchaseStatus = other.getPurchaseStatus();
            if (this$purchaseStatus == null ? other$purchaseStatus == null : this$purchaseStatus.equals(other$purchaseStatus)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$supplyType = this.getSupplyType();
                  Object other$supplyType = other.getSupplyType();
                  if (this$supplyType == null ? other$supplyType == null : this$supplyType.equals(other$supplyType)) {
                     Object this$branchCompanyId = this.getBranchCompanyId();
                     Object other$branchCompanyId = other.getBranchCompanyId();
                     if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                        Object this$supplierId = this.getSupplierId();
                        Object other$supplierId = other.getSupplierId();
                        if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                           Object this$settlementStatus = this.getSettlementStatus();
                           Object other$settlementStatus = other.getSettlementStatus();
                           if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
                              Object this$unCheckSettlementCount = this.getUnCheckSettlementCount();
                              Object other$unCheckSettlementCount = other.getUnCheckSettlementCount();
                              if (this$unCheckSettlementCount == null
                                 ? other$unCheckSettlementCount == null
                                 : this$unCheckSettlementCount.equals(other$unCheckSettlementCount)) {
                                 Object this$unCheckPaymentCount = this.getUnCheckPaymentCount();
                                 Object other$unCheckPaymentCount = other.getUnCheckPaymentCount();
                                 if (this$unCheckPaymentCount == null
                                    ? other$unCheckPaymentCount == null
                                    : this$unCheckPaymentCount.equals(other$unCheckPaymentCount)) {
                                    Object this$unCheckInvoiceCount = this.getUnCheckInvoiceCount();
                                    Object other$unCheckInvoiceCount = other.getUnCheckInvoiceCount();
                                    if (this$unCheckInvoiceCount == null
                                       ? other$unCheckInvoiceCount == null
                                       : this$unCheckInvoiceCount.equals(other$unCheckInvoiceCount)) {
                                       Object this$invoiceType = this.getInvoiceType();
                                       Object other$invoiceType = other.getInvoiceType();
                                       if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                          Object this$logisticsPayerType = this.getLogisticsPayerType();
                                          Object other$logisticsPayerType = other.getLogisticsPayerType();
                                          if (this$logisticsPayerType == null
                                             ? other$logisticsPayerType == null
                                             : this$logisticsPayerType.equals(other$logisticsPayerType)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$projectIds = this.getProjectIds();
                                                Object other$projectIds = other.getProjectIds();
                                                if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                                   Object this$projects = this.getProjects();
                                                   Object other$projects = other.getProjects();
                                                   if (this$projects == null ? other$projects == null : this$projects.equals(other$projects)) {
                                                      Object this$branchCompanyName = this.getBranchCompanyName();
                                                      Object other$branchCompanyName = other.getBranchCompanyName();
                                                      if (this$branchCompanyName == null
                                                         ? other$branchCompanyName == null
                                                         : this$branchCompanyName.equals(other$branchCompanyName)) {
                                                         Object this$supplierName = this.getSupplierName();
                                                         Object other$supplierName = other.getSupplierName();
                                                         if (this$supplierName == null
                                                            ? other$supplierName == null
                                                            : this$supplierName.equals(other$supplierName)) {
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
                                                                  Object this$mete = this.getMete();
                                                                  Object other$mete = other.getMete();
                                                                  if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                     Object this$meteUnit = this.getMeteUnit();
                                                                     Object other$meteUnit = other.getMeteUnit();
                                                                     if (this$meteUnit == null ? other$meteUnit == null : this$meteUnit.equals(other$meteUnit)) {
                                                                        Object this$amount = this.getAmount();
                                                                        Object other$amount = other.getAmount();
                                                                        if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                                           Object this$createTime = this.getCreateTime();
                                                                           Object other$createTime = other.getCreateTime();
                                                                           if (this$createTime == null
                                                                              ? other$createTime == null
                                                                              : this$createTime.equals(other$createTime)) {
                                                                              Object this$signingTime = this.getSigningTime();
                                                                              Object other$signingTime = other.getSigningTime();
                                                                              if (this$signingTime == null
                                                                                 ? other$signingTime == null
                                                                                 : this$signingTime.equals(other$signingTime)) {
                                                                                 Object this$settlementAmount = this.getSettlementAmount();
                                                                                 Object other$settlementAmount = other.getSettlementAmount();
                                                                                 if (this$settlementAmount == null
                                                                                    ? other$settlementAmount == null
                                                                                    : this$settlementAmount.equals(other$settlementAmount)) {
                                                                                    Object this$unCheckSettlementAmount = this.getUnCheckSettlementAmount();
                                                                                    Object other$unCheckSettlementAmount = other.getUnCheckSettlementAmount();
                                                                                    if (this$unCheckSettlementAmount == null
                                                                                       ? other$unCheckSettlementAmount == null
                                                                                       : this$unCheckSettlementAmount.equals(other$unCheckSettlementAmount)) {
                                                                                       Object this$attachmentDTOS = this.getAttachmentDTOS();
                                                                                       Object other$attachmentDTOS = other.getAttachmentDTOS();
                                                                                       if (this$attachmentDTOS == null
                                                                                          ? other$attachmentDTOS == null
                                                                                          : this$attachmentDTOS.equals(other$attachmentDTOS)) {
                                                                                          Object this$settlementRemark = this.getSettlementRemark();
                                                                                          Object other$settlementRemark = other.getSettlementRemark();
                                                                                          if (this$settlementRemark == null
                                                                                             ? other$settlementRemark == null
                                                                                             : this$settlementRemark.equals(other$settlementRemark)) {
                                                                                             Object this$paymentAmount = this.getPaymentAmount();
                                                                                             Object other$paymentAmount = other.getPaymentAmount();
                                                                                             if (this$paymentAmount == null
                                                                                                ? other$paymentAmount == null
                                                                                                : this$paymentAmount.equals(other$paymentAmount)) {
                                                                                                Object this$invoiceAmount = this.getInvoiceAmount();
                                                                                                Object other$invoiceAmount = other.getInvoiceAmount();
                                                                                                if (this$invoiceAmount == null
                                                                                                   ? other$invoiceAmount == null
                                                                                                   : this$invoiceAmount.equals(other$invoiceAmount)) {
                                                                                                   Object this$inboundAmount = this.getInboundAmount();
                                                                                                   Object other$inboundAmount = other.getInboundAmount();
                                                                                                   if (this$inboundAmount == null
                                                                                                      ? other$inboundAmount == null
                                                                                                      : this$inboundAmount.equals(other$inboundAmount)) {
                                                                                                      Object this$lastPaymentAmount = this.getLastPaymentAmount();
                                                                                                      Object other$lastPaymentAmount = other.getLastPaymentAmount();
                                                                                                      if (this$lastPaymentAmount == null
                                                                                                         ? other$lastPaymentAmount == null
                                                                                                         : this$lastPaymentAmount.equals(
                                                                                                            other$lastPaymentAmount
                                                                                                         )) {
                                                                                                         Object this$lastPaymentTime = this.getLastPaymentTime();
                                                                                                         Object other$lastPaymentTime = other.getLastPaymentTime();
                                                                                                         if (this$lastPaymentTime == null
                                                                                                            ? other$lastPaymentTime == null
                                                                                                            : this$lastPaymentTime.equals(other$lastPaymentTime)
                                                                                                            )
                                                                                                          {
                                                                                                            Object this$taxRate = this.getTaxRate();
                                                                                                            Object other$taxRate = other.getTaxRate();
                                                                                                            return this$taxRate == null
                                                                                                               ? other$taxRate == null
                                                                                                               : this$taxRate.equals(other$taxRate);
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
      return other instanceof SupplierPaymentRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $purchaseType = this.getPurchaseType();
      result = result * 59 + ($purchaseType == null ? 43 : $purchaseType.hashCode());
      Object $purchaseStatus = this.getPurchaseStatus();
      result = result * 59 + ($purchaseStatus == null ? 43 : $purchaseStatus.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $supplyType = this.getSupplyType();
      result = result * 59 + ($supplyType == null ? 43 : $supplyType.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $unCheckSettlementCount = this.getUnCheckSettlementCount();
      result = result * 59 + ($unCheckSettlementCount == null ? 43 : $unCheckSettlementCount.hashCode());
      Object $unCheckPaymentCount = this.getUnCheckPaymentCount();
      result = result * 59 + ($unCheckPaymentCount == null ? 43 : $unCheckPaymentCount.hashCode());
      Object $unCheckInvoiceCount = this.getUnCheckInvoiceCount();
      result = result * 59 + ($unCheckInvoiceCount == null ? 43 : $unCheckInvoiceCount.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $logisticsPayerType = this.getLogisticsPayerType();
      result = result * 59 + ($logisticsPayerType == null ? 43 : $logisticsPayerType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $supplierBankName = this.getSupplierBankName();
      result = result * 59 + ($supplierBankName == null ? 43 : $supplierBankName.hashCode());
      Object $supplierBankAccount = this.getSupplierBankAccount();
      result = result * 59 + ($supplierBankAccount == null ? 43 : $supplierBankAccount.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $meteUnit = this.getMeteUnit();
      result = result * 59 + ($meteUnit == null ? 43 : $meteUnit.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $signingTime = this.getSigningTime();
      result = result * 59 + ($signingTime == null ? 43 : $signingTime.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $unCheckSettlementAmount = this.getUnCheckSettlementAmount();
      result = result * 59 + ($unCheckSettlementAmount == null ? 43 : $unCheckSettlementAmount.hashCode());
      Object $attachmentDTOS = this.getAttachmentDTOS();
      result = result * 59 + ($attachmentDTOS == null ? 43 : $attachmentDTOS.hashCode());
      Object $settlementRemark = this.getSettlementRemark();
      result = result * 59 + ($settlementRemark == null ? 43 : $settlementRemark.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $inboundAmount = this.getInboundAmount();
      result = result * 59 + ($inboundAmount == null ? 43 : $inboundAmount.hashCode());
      Object $lastPaymentAmount = this.getLastPaymentAmount();
      result = result * 59 + ($lastPaymentAmount == null ? 43 : $lastPaymentAmount.hashCode());
      Object $lastPaymentTime = this.getLastPaymentTime();
      result = result * 59 + ($lastPaymentTime == null ? 43 : $lastPaymentTime.hashCode());
      Object $taxRate = this.getTaxRate();
      return result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierPaymentRecordDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectIds="
         + this.getProjectIds()
         + ", projects="
         + this.getProjects()
         + ", purchaseType="
         + this.getPurchaseType()
         + ", purchaseStatus="
         + this.getPurchaseStatus()
         + ", basicClass="
         + this.getBasicClass()
         + ", supplyType="
         + this.getSupplyType()
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
         + ", mete="
         + this.getMete()
         + ", meteUnit="
         + this.getMeteUnit()
         + ", amount="
         + this.getAmount()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", createTime="
         + this.getCreateTime()
         + ", signingTime="
         + this.getSigningTime()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", unCheckSettlementCount="
         + this.getUnCheckSettlementCount()
         + ", unCheckSettlementAmount="
         + this.getUnCheckSettlementAmount()
         + ", attachmentDTOS="
         + this.getAttachmentDTOS()
         + ", settlementRemark="
         + this.getSettlementRemark()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", unCheckPaymentCount="
         + this.getUnCheckPaymentCount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", unCheckInvoiceCount="
         + this.getUnCheckInvoiceCount()
         + ", inboundAmount="
         + this.getInboundAmount()
         + ", lastPaymentAmount="
         + this.getLastPaymentAmount()
         + ", lastPaymentTime="
         + this.getLastPaymentTime()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", logisticsPayerType="
         + this.getLogisticsPayerType()
         + ")";
   }

   public static class SupplierPaymentRecordDTOBuilder {
      private Long id;
      private String serialNumber;
      private String projectIds;
      private List<ProjectInfo> projects;
      private Integer purchaseType;
      private Integer purchaseStatus;
      private Integer basicClass;
      private Integer supplyType;
      private Long branchCompanyId;
      private String branchCompanyName;
      private Long supplierId;
      private String supplierName;
      private String supplierBankName;
      private String supplierBankAccount;
      private BigDecimal mete;
      private String meteUnit;
      private BigDecimal amount;
      private Integer settlementStatus;
      private LocalDateTime createTime;
      private LocalDateTime signingTime;
      private BigDecimal settlementAmount;
      private Integer unCheckSettlementCount;
      private BigDecimal unCheckSettlementAmount;
      private List<AttachmentDTO> attachmentDTOS;
      private String settlementRemark;
      private BigDecimal paymentAmount;
      private Integer unCheckPaymentCount;
      private BigDecimal invoiceAmount;
      private Integer unCheckInvoiceCount;
      private BigDecimal inboundAmount;
      private BigDecimal lastPaymentAmount;
      private LocalDateTime lastPaymentTime;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private Integer logisticsPayerType;

      SupplierPaymentRecordDTOBuilder() {
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder projects(final List<ProjectInfo> projects) {
         this.projects = projects;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder purchaseType(final Integer purchaseType) {
         this.purchaseType = purchaseType;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder purchaseStatus(final Integer purchaseStatus) {
         this.purchaseStatus = purchaseStatus;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder supplyType(final Integer supplyType) {
         this.supplyType = supplyType;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder supplierBankName(final String supplierBankName) {
         this.supplierBankName = supplierBankName;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder supplierBankAccount(final String supplierBankAccount) {
         this.supplierBankAccount = supplierBankAccount;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder meteUnit(final String meteUnit) {
         this.meteUnit = meteUnit;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder settlementStatus(final Integer settlementStatus) {
         this.settlementStatus = settlementStatus;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder signingTime(final LocalDateTime signingTime) {
         this.signingTime = signingTime;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder unCheckSettlementCount(final Integer unCheckSettlementCount) {
         this.unCheckSettlementCount = unCheckSettlementCount;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder unCheckSettlementAmount(final BigDecimal unCheckSettlementAmount) {
         this.unCheckSettlementAmount = unCheckSettlementAmount;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder attachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
         this.attachmentDTOS = attachmentDTOS;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder settlementRemark(final String settlementRemark) {
         this.settlementRemark = settlementRemark;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder unCheckPaymentCount(final Integer unCheckPaymentCount) {
         this.unCheckPaymentCount = unCheckPaymentCount;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder unCheckInvoiceCount(final Integer unCheckInvoiceCount) {
         this.unCheckInvoiceCount = unCheckInvoiceCount;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder inboundAmount(final BigDecimal inboundAmount) {
         this.inboundAmount = inboundAmount;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder lastPaymentAmount(final BigDecimal lastPaymentAmount) {
         this.lastPaymentAmount = lastPaymentAmount;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder lastPaymentTime(final LocalDateTime lastPaymentTime) {
         this.lastPaymentTime = lastPaymentTime;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder logisticsPayerType(final Integer logisticsPayerType) {
         this.logisticsPayerType = logisticsPayerType;
         return this;
      }

      public SupplierPaymentRecordDTO build() {
         return new SupplierPaymentRecordDTO(
            this.id,
            this.serialNumber,
            this.projectIds,
            this.projects,
            this.purchaseType,
            this.purchaseStatus,
            this.basicClass,
            this.supplyType,
            this.branchCompanyId,
            this.branchCompanyName,
            this.supplierId,
            this.supplierName,
            this.supplierBankName,
            this.supplierBankAccount,
            this.mete,
            this.meteUnit,
            this.amount,
            this.settlementStatus,
            this.createTime,
            this.signingTime,
            this.settlementAmount,
            this.unCheckSettlementCount,
            this.unCheckSettlementAmount,
            this.attachmentDTOS,
            this.settlementRemark,
            this.paymentAmount,
            this.unCheckPaymentCount,
            this.invoiceAmount,
            this.unCheckInvoiceCount,
            this.inboundAmount,
            this.lastPaymentAmount,
            this.lastPaymentTime,
            this.invoiceType,
            this.taxRate,
            this.logisticsPayerType
         );
      }

      @Override
      public String toString() {
         return "SupplierPaymentRecordDTO.SupplierPaymentRecordDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", projectIds="
            + this.projectIds
            + ", projects="
            + this.projects
            + ", purchaseType="
            + this.purchaseType
            + ", purchaseStatus="
            + this.purchaseStatus
            + ", basicClass="
            + this.basicClass
            + ", supplyType="
            + this.supplyType
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", supplierBankName="
            + this.supplierBankName
            + ", supplierBankAccount="
            + this.supplierBankAccount
            + ", mete="
            + this.mete
            + ", meteUnit="
            + this.meteUnit
            + ", amount="
            + this.amount
            + ", settlementStatus="
            + this.settlementStatus
            + ", createTime="
            + this.createTime
            + ", signingTime="
            + this.signingTime
            + ", settlementAmount="
            + this.settlementAmount
            + ", unCheckSettlementCount="
            + this.unCheckSettlementCount
            + ", unCheckSettlementAmount="
            + this.unCheckSettlementAmount
            + ", attachmentDTOS="
            + this.attachmentDTOS
            + ", settlementRemark="
            + this.settlementRemark
            + ", paymentAmount="
            + this.paymentAmount
            + ", unCheckPaymentCount="
            + this.unCheckPaymentCount
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", unCheckInvoiceCount="
            + this.unCheckInvoiceCount
            + ", inboundAmount="
            + this.inboundAmount
            + ", lastPaymentAmount="
            + this.lastPaymentAmount
            + ", lastPaymentTime="
            + this.lastPaymentTime
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", logisticsPayerType="
            + this.logisticsPayerType
            + ")";
      }
   }
}
