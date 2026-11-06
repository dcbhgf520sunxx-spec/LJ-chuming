package com.hzchum.scim.project.core.api.pojo.dto.sub;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel("SubcontractOrderDTO对象")
public class SubcontractOrderPayInvoiceDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "订单编号", notes = "订单编号")
   private String serialNumber;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "supplierId", value = "分包单位(供应商)id", notes = "分包单位(供应商)id")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "分包单位(供应商)", notes = "分包单位(供应商)")
   private String supplierName;
   @ApiModelProperty(name = "subcontractClassId", value = "分包类别id", notes = "分包类别id")
   private Long subcontractClassId;
   @ApiModelProperty(name = "subcontractClassName", value = "分包类别名称", notes = "分包类别名称")
   private String subcontractClassName;
   @ApiModelProperty(name = "amount", value = "合同金额", notes = "合同金额")
   private BigDecimal amount;
   @ApiModelProperty(name = "invoiceType", value = "发票类型", notes = "发票类型")
   private Integer invoiceType;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "orderStatus", value = "订单状态 1进行中2暂停4已完成", notes = "订单状态 1进行中2暂停4已完成")
   private Integer orderStatus;
   @ApiModelProperty(name = "boolSettlementStatus", value = "结算状态 1已结算0未结算", notes = "结算状态 1已结算0未结算")
   private Boolean boolSettlementStatus;
   @ApiModelProperty(name = "settlementAmount", value = "结算额", notes = "结算额")
   private BigDecimal settlementAmount;
   @ApiModelProperty(name = "userId", value = "创建人ID", notes = "创建人ID")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "创建人", notes = "创建人")
   private String userName;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "signDate", value = "签订日期", notes = "签订日期")
   private LocalDate signDate;
   @ApiModelProperty(name = "settlementAmount", value = "付款额", notes = "付款额")
   private BigDecimal paymentAmount;
   @ApiModelProperty(name = "settlementAmount", value = "开票额", notes = "开票额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty(name = "lastPaymentAmount", value = "最后一次付款金额")
   private BigDecimal lastPaymentAmount;
   @ApiModelProperty(name = "lastPaymentTime", value = "最后一次付款时间")
   private LocalDate lastPaymentTime;
   @ApiModelProperty(name = "supplier", value = "供应商信息")
   private SupplierInfo supplier;
   @ApiModelProperty(name = "penalty", value = "违约金")
   private BigDecimal penalty;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构ID")
   private Long branchCompanyId;
   @ApiModelProperty(name = "branchCompanyName", value = "分支机构名称")
   private String branchCompanyName;
   @ApiModelProperty(name = "visaAmount", value = "签证金额", notes = "签证金额")
   private BigDecimal visaAmount;
   @ApiModelProperty(name = "unCheckPaymentCount", value = "未审核付款数")
   private int unCheckPaymentCount;
   @ApiModelProperty(name = "unCheckInvoiceCount", value = "未审核开票数")
   private int unCheckInvoiceCount;
   @ApiModelProperty(name = "unCheckSettlementCount", value = "未审核结算数")
   private int unCheckSettlementCount;
   @ApiModelProperty(name = "settlementInfo", value = "结算申请记录信息")
   private SupplierSettlementInfo settlementInfo;

   public static SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder builder() {
      return new SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder();
   }

   public SubcontractOrderPayInvoiceDTO() {
   }

   public SubcontractOrderPayInvoiceDTO(
      final Long id,
      final String serialNumber,
      final Long projectId,
      final ProjectInfo project,
      final Long supplierId,
      final String supplierName,
      final Long subcontractClassId,
      final String subcontractClassName,
      final BigDecimal amount,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final Integer orderStatus,
      final Boolean boolSettlementStatus,
      final BigDecimal settlementAmount,
      final Long userId,
      final String userName,
      final String remark,
      final LocalDate signDate,
      final BigDecimal paymentAmount,
      final BigDecimal invoiceAmount,
      final BigDecimal lastPaymentAmount,
      final LocalDate lastPaymentTime,
      final SupplierInfo supplier,
      final BigDecimal penalty,
      final Long branchCompanyId,
      final String branchCompanyName,
      final BigDecimal visaAmount,
      final int unCheckPaymentCount,
      final int unCheckInvoiceCount,
      final int unCheckSettlementCount,
      final SupplierSettlementInfo settlementInfo
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.projectId = projectId;
      this.project = project;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.subcontractClassId = subcontractClassId;
      this.subcontractClassName = subcontractClassName;
      this.amount = amount;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.orderStatus = orderStatus;
      this.boolSettlementStatus = boolSettlementStatus;
      this.settlementAmount = settlementAmount;
      this.userId = userId;
      this.userName = userName;
      this.remark = remark;
      this.signDate = signDate;
      this.paymentAmount = paymentAmount;
      this.invoiceAmount = invoiceAmount;
      this.lastPaymentAmount = lastPaymentAmount;
      this.lastPaymentTime = lastPaymentTime;
      this.supplier = supplier;
      this.penalty = penalty;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.visaAmount = visaAmount;
      this.unCheckPaymentCount = unCheckPaymentCount;
      this.unCheckInvoiceCount = unCheckInvoiceCount;
      this.unCheckSettlementCount = unCheckSettlementCount;
      this.settlementInfo = settlementInfo;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getSubcontractClassId() {
      return this.subcontractClassId;
   }

   public String getSubcontractClassName() {
      return this.subcontractClassName;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Integer getOrderStatus() {
      return this.orderStatus;
   }

   public Boolean getBoolSettlementStatus() {
      return this.boolSettlementStatus;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getRemark() {
      return this.remark;
   }

   public LocalDate getSignDate() {
      return this.signDate;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getLastPaymentAmount() {
      return this.lastPaymentAmount;
   }

   public LocalDate getLastPaymentTime() {
      return this.lastPaymentTime;
   }

   public SupplierInfo getSupplier() {
      return this.supplier;
   }

   public BigDecimal getPenalty() {
      return this.penalty;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public BigDecimal getVisaAmount() {
      return this.visaAmount;
   }

   public int getUnCheckPaymentCount() {
      return this.unCheckPaymentCount;
   }

   public int getUnCheckInvoiceCount() {
      return this.unCheckInvoiceCount;
   }

   public int getUnCheckSettlementCount() {
      return this.unCheckSettlementCount;
   }

   public SupplierSettlementInfo getSettlementInfo() {
      return this.settlementInfo;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setSubcontractClassId(final Long subcontractClassId) {
      this.subcontractClassId = subcontractClassId;
   }

   public void setSubcontractClassName(final String subcontractClassName) {
      this.subcontractClassName = subcontractClassName;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setOrderStatus(final Integer orderStatus) {
      this.orderStatus = orderStatus;
   }

   public void setBoolSettlementStatus(final Boolean boolSettlementStatus) {
      this.boolSettlementStatus = boolSettlementStatus;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setSignDate(final LocalDate signDate) {
      this.signDate = signDate;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setLastPaymentAmount(final BigDecimal lastPaymentAmount) {
      this.lastPaymentAmount = lastPaymentAmount;
   }

   public void setLastPaymentTime(final LocalDate lastPaymentTime) {
      this.lastPaymentTime = lastPaymentTime;
   }

   public void setSupplier(final SupplierInfo supplier) {
      this.supplier = supplier;
   }

   public void setPenalty(final BigDecimal penalty) {
      this.penalty = penalty;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setVisaAmount(final BigDecimal visaAmount) {
      this.visaAmount = visaAmount;
   }

   public void setUnCheckPaymentCount(final int unCheckPaymentCount) {
      this.unCheckPaymentCount = unCheckPaymentCount;
   }

   public void setUnCheckInvoiceCount(final int unCheckInvoiceCount) {
      this.unCheckInvoiceCount = unCheckInvoiceCount;
   }

   public void setUnCheckSettlementCount(final int unCheckSettlementCount) {
      this.unCheckSettlementCount = unCheckSettlementCount;
   }

   public void setSettlementInfo(final SupplierSettlementInfo settlementInfo) {
      this.settlementInfo = settlementInfo;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubcontractOrderPayInvoiceDTO)) {
         return false;
      }

      SubcontractOrderPayInvoiceDTO other = (SubcontractOrderPayInvoiceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getUnCheckPaymentCount() != other.getUnCheckPaymentCount()) {
         return false;
      }

      if (this.getUnCheckInvoiceCount() != other.getUnCheckInvoiceCount()) {
         return false;
      }

      if (this.getUnCheckSettlementCount() != other.getUnCheckSettlementCount()) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$supplierId = this.getSupplierId();
            Object other$supplierId = other.getSupplierId();
            if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
               Object this$subcontractClassId = this.getSubcontractClassId();
               Object other$subcontractClassId = other.getSubcontractClassId();
               if (this$subcontractClassId == null ? other$subcontractClassId == null : this$subcontractClassId.equals(other$subcontractClassId)) {
                  Object this$invoiceType = this.getInvoiceType();
                  Object other$invoiceType = other.getInvoiceType();
                  if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                     Object this$orderStatus = this.getOrderStatus();
                     Object other$orderStatus = other.getOrderStatus();
                     if (this$orderStatus == null ? other$orderStatus == null : this$orderStatus.equals(other$orderStatus)) {
                        Object this$boolSettlementStatus = this.getBoolSettlementStatus();
                        Object other$boolSettlementStatus = other.getBoolSettlementStatus();
                        if (this$boolSettlementStatus == null
                           ? other$boolSettlementStatus == null
                           : this$boolSettlementStatus.equals(other$boolSettlementStatus)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$branchCompanyId = this.getBranchCompanyId();
                              Object other$branchCompanyId = other.getBranchCompanyId();
                              if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$project = this.getProject();
                                    Object other$project = other.getProject();
                                    if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                       Object this$supplierName = this.getSupplierName();
                                       Object other$supplierName = other.getSupplierName();
                                       if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                          Object this$subcontractClassName = this.getSubcontractClassName();
                                          Object other$subcontractClassName = other.getSubcontractClassName();
                                          if (this$subcontractClassName == null
                                             ? other$subcontractClassName == null
                                             : this$subcontractClassName.equals(other$subcontractClassName)) {
                                             Object this$amount = this.getAmount();
                                             Object other$amount = other.getAmount();
                                             if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                Object this$taxRate = this.getTaxRate();
                                                Object other$taxRate = other.getTaxRate();
                                                if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                   Object this$settlementAmount = this.getSettlementAmount();
                                                   Object other$settlementAmount = other.getSettlementAmount();
                                                   if (this$settlementAmount == null
                                                      ? other$settlementAmount == null
                                                      : this$settlementAmount.equals(other$settlementAmount)) {
                                                      Object this$userName = this.getUserName();
                                                      Object other$userName = other.getUserName();
                                                      if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                         Object this$remark = this.getRemark();
                                                         Object other$remark = other.getRemark();
                                                         if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                            Object this$signDate = this.getSignDate();
                                                            Object other$signDate = other.getSignDate();
                                                            if (this$signDate == null ? other$signDate == null : this$signDate.equals(other$signDate)) {
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
                                                                     Object this$lastPaymentAmount = this.getLastPaymentAmount();
                                                                     Object other$lastPaymentAmount = other.getLastPaymentAmount();
                                                                     if (this$lastPaymentAmount == null
                                                                        ? other$lastPaymentAmount == null
                                                                        : this$lastPaymentAmount.equals(other$lastPaymentAmount)) {
                                                                        Object this$lastPaymentTime = this.getLastPaymentTime();
                                                                        Object other$lastPaymentTime = other.getLastPaymentTime();
                                                                        if (this$lastPaymentTime == null
                                                                           ? other$lastPaymentTime == null
                                                                           : this$lastPaymentTime.equals(other$lastPaymentTime)) {
                                                                           Object this$supplier = this.getSupplier();
                                                                           Object other$supplier = other.getSupplier();
                                                                           if (this$supplier == null
                                                                              ? other$supplier == null
                                                                              : this$supplier.equals(other$supplier)) {
                                                                              Object this$penalty = this.getPenalty();
                                                                              Object other$penalty = other.getPenalty();
                                                                              if (this$penalty == null
                                                                                 ? other$penalty == null
                                                                                 : this$penalty.equals(other$penalty)) {
                                                                                 Object this$branchCompanyName = this.getBranchCompanyName();
                                                                                 Object other$branchCompanyName = other.getBranchCompanyName();
                                                                                 if (this$branchCompanyName == null
                                                                                    ? other$branchCompanyName == null
                                                                                    : this$branchCompanyName.equals(other$branchCompanyName)) {
                                                                                    Object this$visaAmount = this.getVisaAmount();
                                                                                    Object other$visaAmount = other.getVisaAmount();
                                                                                    if (this$visaAmount == null
                                                                                       ? other$visaAmount == null
                                                                                       : this$visaAmount.equals(other$visaAmount)) {
                                                                                       Object this$settlementInfo = this.getSettlementInfo();
                                                                                       Object other$settlementInfo = other.getSettlementInfo();
                                                                                       return this$settlementInfo == null
                                                                                          ? other$settlementInfo == null
                                                                                          : this$settlementInfo.equals(other$settlementInfo);
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
      return other instanceof SubcontractOrderPayInvoiceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getUnCheckPaymentCount();
      result = result * 59 + this.getUnCheckInvoiceCount();
      result = result * 59 + this.getUnCheckSettlementCount();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $subcontractClassId = this.getSubcontractClassId();
      result = result * 59 + ($subcontractClassId == null ? 43 : $subcontractClassId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $orderStatus = this.getOrderStatus();
      result = result * 59 + ($orderStatus == null ? 43 : $orderStatus.hashCode());
      Object $boolSettlementStatus = this.getBoolSettlementStatus();
      result = result * 59 + ($boolSettlementStatus == null ? 43 : $boolSettlementStatus.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $subcontractClassName = this.getSubcontractClassName();
      result = result * 59 + ($subcontractClassName == null ? 43 : $subcontractClassName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $signDate = this.getSignDate();
      result = result * 59 + ($signDate == null ? 43 : $signDate.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $lastPaymentAmount = this.getLastPaymentAmount();
      result = result * 59 + ($lastPaymentAmount == null ? 43 : $lastPaymentAmount.hashCode());
      Object $lastPaymentTime = this.getLastPaymentTime();
      result = result * 59 + ($lastPaymentTime == null ? 43 : $lastPaymentTime.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $penalty = this.getPenalty();
      result = result * 59 + ($penalty == null ? 43 : $penalty.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $visaAmount = this.getVisaAmount();
      result = result * 59 + ($visaAmount == null ? 43 : $visaAmount.hashCode());
      Object $settlementInfo = this.getSettlementInfo();
      return result * 59 + ($settlementInfo == null ? 43 : $settlementInfo.hashCode());
   }

   @Override
   public String toString() {
      return "SubcontractOrderPayInvoiceDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", project="
         + this.getProject()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", subcontractClassId="
         + this.getSubcontractClassId()
         + ", subcontractClassName="
         + this.getSubcontractClassName()
         + ", amount="
         + this.getAmount()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", orderStatus="
         + this.getOrderStatus()
         + ", boolSettlementStatus="
         + this.getBoolSettlementStatus()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", remark="
         + this.getRemark()
         + ", signDate="
         + this.getSignDate()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", lastPaymentAmount="
         + this.getLastPaymentAmount()
         + ", lastPaymentTime="
         + this.getLastPaymentTime()
         + ", supplier="
         + this.getSupplier()
         + ", penalty="
         + this.getPenalty()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", visaAmount="
         + this.getVisaAmount()
         + ", unCheckPaymentCount="
         + this.getUnCheckPaymentCount()
         + ", unCheckInvoiceCount="
         + this.getUnCheckInvoiceCount()
         + ", unCheckSettlementCount="
         + this.getUnCheckSettlementCount()
         + ", settlementInfo="
         + this.getSettlementInfo()
         + ")";
   }

   public static class SubcontractOrderPayInvoiceDTOBuilder {
      private Long id;
      private String serialNumber;
      private Long projectId;
      private ProjectInfo project;
      private Long supplierId;
      private String supplierName;
      private Long subcontractClassId;
      private String subcontractClassName;
      private BigDecimal amount;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private Integer orderStatus;
      private Boolean boolSettlementStatus;
      private BigDecimal settlementAmount;
      private Long userId;
      private String userName;
      private String remark;
      private LocalDate signDate;
      private BigDecimal paymentAmount;
      private BigDecimal invoiceAmount;
      private BigDecimal lastPaymentAmount;
      private LocalDate lastPaymentTime;
      private SupplierInfo supplier;
      private BigDecimal penalty;
      private Long branchCompanyId;
      private String branchCompanyName;
      private BigDecimal visaAmount;
      private int unCheckPaymentCount;
      private int unCheckInvoiceCount;
      private int unCheckSettlementCount;
      private SupplierSettlementInfo settlementInfo;

      SubcontractOrderPayInvoiceDTOBuilder() {
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder subcontractClassName(final String subcontractClassName) {
         this.subcontractClassName = subcontractClassName;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder orderStatus(final Integer orderStatus) {
         this.orderStatus = orderStatus;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder boolSettlementStatus(final Boolean boolSettlementStatus) {
         this.boolSettlementStatus = boolSettlementStatus;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder signDate(final LocalDate signDate) {
         this.signDate = signDate;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder lastPaymentAmount(final BigDecimal lastPaymentAmount) {
         this.lastPaymentAmount = lastPaymentAmount;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder lastPaymentTime(final LocalDate lastPaymentTime) {
         this.lastPaymentTime = lastPaymentTime;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder supplier(final SupplierInfo supplier) {
         this.supplier = supplier;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder penalty(final BigDecimal penalty) {
         this.penalty = penalty;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder visaAmount(final BigDecimal visaAmount) {
         this.visaAmount = visaAmount;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder unCheckPaymentCount(final int unCheckPaymentCount) {
         this.unCheckPaymentCount = unCheckPaymentCount;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder unCheckInvoiceCount(final int unCheckInvoiceCount) {
         this.unCheckInvoiceCount = unCheckInvoiceCount;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder unCheckSettlementCount(final int unCheckSettlementCount) {
         this.unCheckSettlementCount = unCheckSettlementCount;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder settlementInfo(final SupplierSettlementInfo settlementInfo) {
         this.settlementInfo = settlementInfo;
         return this;
      }

      public SubcontractOrderPayInvoiceDTO build() {
         return new SubcontractOrderPayInvoiceDTO(
            this.id,
            this.serialNumber,
            this.projectId,
            this.project,
            this.supplierId,
            this.supplierName,
            this.subcontractClassId,
            this.subcontractClassName,
            this.amount,
            this.invoiceType,
            this.taxRate,
            this.orderStatus,
            this.boolSettlementStatus,
            this.settlementAmount,
            this.userId,
            this.userName,
            this.remark,
            this.signDate,
            this.paymentAmount,
            this.invoiceAmount,
            this.lastPaymentAmount,
            this.lastPaymentTime,
            this.supplier,
            this.penalty,
            this.branchCompanyId,
            this.branchCompanyName,
            this.visaAmount,
            this.unCheckPaymentCount,
            this.unCheckInvoiceCount,
            this.unCheckSettlementCount,
            this.settlementInfo
         );
      }

      @Override
      public String toString() {
         return "SubcontractOrderPayInvoiceDTO.SubcontractOrderPayInvoiceDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", projectId="
            + this.projectId
            + ", project="
            + this.project
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", subcontractClassId="
            + this.subcontractClassId
            + ", subcontractClassName="
            + this.subcontractClassName
            + ", amount="
            + this.amount
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", orderStatus="
            + this.orderStatus
            + ", boolSettlementStatus="
            + this.boolSettlementStatus
            + ", settlementAmount="
            + this.settlementAmount
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", remark="
            + this.remark
            + ", signDate="
            + this.signDate
            + ", paymentAmount="
            + this.paymentAmount
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", lastPaymentAmount="
            + this.lastPaymentAmount
            + ", lastPaymentTime="
            + this.lastPaymentTime
            + ", supplier="
            + this.supplier
            + ", penalty="
            + this.penalty
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", visaAmount="
            + this.visaAmount
            + ", unCheckPaymentCount="
            + this.unCheckPaymentCount
            + ", unCheckInvoiceCount="
            + this.unCheckInvoiceCount
            + ", unCheckSettlementCount="
            + this.unCheckSettlementCount
            + ", settlementInfo="
            + this.settlementInfo
            + ")";
      }
   }
}
