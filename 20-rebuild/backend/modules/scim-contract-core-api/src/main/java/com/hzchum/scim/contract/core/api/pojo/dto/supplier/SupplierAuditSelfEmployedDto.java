package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiOperation("供应商自营付款审核")
public class SupplierAuditSelfEmployedDto {
   @ApiModelProperty("创建日期")
   private LocalDateTime createDate;
   @ApiModelProperty("创建人id")
   private Long createUserId;
   @ApiModelProperty("创建人名称")
   private String createUserName;
   @ApiModelProperty("供应商id")
   private Long supplierId;
   @ApiModelProperty("供应商名称")
   private String supplierName;
   @ApiModelProperty("项目名称")
   private List<String> projectName;
   @ApiModelProperty("项目总收入")
   BigDecimal projectCollectionAmount;
   @ApiModelProperty("项目总支出")
   BigDecimal projectDisburseAmount;
   @ApiModelProperty("付款银行")
   private String paymentBank;
   @ApiModelProperty("付款账号")
   private String paymentBankAccount;
   @ApiModelProperty("付款类型")
   private Integer paymentType;
   @ApiModelProperty("付款属性id")
   private Long paymentAttributeId;
   @ApiModelProperty("付款属性名称")
   private String paymentAttributeName;
   @ApiModelProperty("付款日期")
   private LocalDate paymentDate;
   @ApiModelProperty("本次付款额")
   private BigDecimal paymentAmount;
   @ApiModelProperty("本合同付款总额")
   private BigDecimal totalPaymentAmount;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("签约主体id")
   private Long branchCompanyId;
   @ApiModelProperty("签约主体名称")
   private String branchCompanyName;
   @ApiModelProperty("合同金额")
   private BigDecimal amount;
   @ApiModelProperty("物资类型")
   private Integer basicClass;
   @ApiModelProperty("物资类型名称")
   private String basicClassName;
   @ApiModelProperty("结算金额")
   private BigDecimal settlementAmount;
   @ApiModelProperty(name = "serialNumber", value = "采购合同号", notes = "采购合同号")
   private List<String> serialNumber;
   @ApiModelProperty("付款信息")
   private List<SupplierSelfEmployedDto> list;
   @ApiModelProperty(name = "attachmentIds", value = "附件id", notes = "附件id")
   private String attachmentIds;
   @ApiModelProperty(name = "attachmentDtoList", value = "附件对象列表", notes = "附件对象列表")
   private List<AttachmentDTO> attachmentDtoList;
   @ApiModelProperty(name = "attachments", value = "附件对象列表", notes = "附件对象列表")
   private List<AttachmentDTO> attachments;

   public static SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder builder() {
      return new SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder();
   }

   public LocalDateTime getCreateDate() {
      return this.createDate;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public List<String> getProjectName() {
      return this.projectName;
   }

   public BigDecimal getProjectCollectionAmount() {
      return this.projectCollectionAmount;
   }

   public BigDecimal getProjectDisburseAmount() {
      return this.projectDisburseAmount;
   }

   public String getPaymentBank() {
      return this.paymentBank;
   }

   public String getPaymentBankAccount() {
      return this.paymentBankAccount;
   }

   public Integer getPaymentType() {
      return this.paymentType;
   }

   public Long getPaymentAttributeId() {
      return this.paymentAttributeId;
   }

   public String getPaymentAttributeName() {
      return this.paymentAttributeName;
   }

   public LocalDate getPaymentDate() {
      return this.paymentDate;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public BigDecimal getTotalPaymentAmount() {
      return this.totalPaymentAmount;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getBasicClassName() {
      return this.basicClassName;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public List<String> getSerialNumber() {
      return this.serialNumber;
   }

   public List<SupplierSelfEmployedDto> getList() {
      return this.list;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<AttachmentDTO> getAttachmentDtoList() {
      return this.attachmentDtoList;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public void setCreateDate(final LocalDateTime createDate) {
      this.createDate = createDate;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setProjectName(final List<String> projectName) {
      this.projectName = projectName;
   }

   public void setProjectCollectionAmount(final BigDecimal projectCollectionAmount) {
      this.projectCollectionAmount = projectCollectionAmount;
   }

   public void setProjectDisburseAmount(final BigDecimal projectDisburseAmount) {
      this.projectDisburseAmount = projectDisburseAmount;
   }

   public void setPaymentBank(final String paymentBank) {
      this.paymentBank = paymentBank;
   }

   public void setPaymentBankAccount(final String paymentBankAccount) {
      this.paymentBankAccount = paymentBankAccount;
   }

   public void setPaymentType(final Integer paymentType) {
      this.paymentType = paymentType;
   }

   public void setPaymentAttributeId(final Long paymentAttributeId) {
      this.paymentAttributeId = paymentAttributeId;
   }

   public void setPaymentAttributeName(final String paymentAttributeName) {
      this.paymentAttributeName = paymentAttributeName;
   }

   public void setPaymentDate(final LocalDate paymentDate) {
      this.paymentDate = paymentDate;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setTotalPaymentAmount(final BigDecimal totalPaymentAmount) {
      this.totalPaymentAmount = totalPaymentAmount;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setBasicClassName(final String basicClassName) {
      this.basicClassName = basicClassName;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setSerialNumber(final List<String> serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setList(final List<SupplierSelfEmployedDto> list) {
      this.list = list;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setAttachmentDtoList(final List<AttachmentDTO> attachmentDtoList) {
      this.attachmentDtoList = attachmentDtoList;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierAuditSelfEmployedDto)) {
         return false;
      }

      SupplierAuditSelfEmployedDto other = (SupplierAuditSelfEmployedDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$createUserId = this.getCreateUserId();
      Object other$createUserId = other.getCreateUserId();
      if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$paymentType = this.getPaymentType();
            Object other$paymentType = other.getPaymentType();
            if (this$paymentType == null ? other$paymentType == null : this$paymentType.equals(other$paymentType)) {
               Object this$paymentAttributeId = this.getPaymentAttributeId();
               Object other$paymentAttributeId = other.getPaymentAttributeId();
               if (this$paymentAttributeId == null ? other$paymentAttributeId == null : this$paymentAttributeId.equals(other$paymentAttributeId)) {
                  Object this$branchCompanyId = this.getBranchCompanyId();
                  Object other$branchCompanyId = other.getBranchCompanyId();
                  if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                     Object this$basicClass = this.getBasicClass();
                     Object other$basicClass = other.getBasicClass();
                     if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                        Object this$createDate = this.getCreateDate();
                        Object other$createDate = other.getCreateDate();
                        if (this$createDate == null ? other$createDate == null : this$createDate.equals(other$createDate)) {
                           Object this$createUserName = this.getCreateUserName();
                           Object other$createUserName = other.getCreateUserName();
                           if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                              Object this$supplierName = this.getSupplierName();
                              Object other$supplierName = other.getSupplierName();
                              if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                 Object this$projectName = this.getProjectName();
                                 Object other$projectName = other.getProjectName();
                                 if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                    Object this$projectCollectionAmount = this.getProjectCollectionAmount();
                                    Object other$projectCollectionAmount = other.getProjectCollectionAmount();
                                    if (this$projectCollectionAmount == null
                                       ? other$projectCollectionAmount == null
                                       : this$projectCollectionAmount.equals(other$projectCollectionAmount)) {
                                       Object this$projectDisburseAmount = this.getProjectDisburseAmount();
                                       Object other$projectDisburseAmount = other.getProjectDisburseAmount();
                                       if (this$projectDisburseAmount == null
                                          ? other$projectDisburseAmount == null
                                          : this$projectDisburseAmount.equals(other$projectDisburseAmount)) {
                                          Object this$paymentBank = this.getPaymentBank();
                                          Object other$paymentBank = other.getPaymentBank();
                                          if (this$paymentBank == null ? other$paymentBank == null : this$paymentBank.equals(other$paymentBank)) {
                                             Object this$paymentBankAccount = this.getPaymentBankAccount();
                                             Object other$paymentBankAccount = other.getPaymentBankAccount();
                                             if (this$paymentBankAccount == null
                                                ? other$paymentBankAccount == null
                                                : this$paymentBankAccount.equals(other$paymentBankAccount)) {
                                                Object this$paymentAttributeName = this.getPaymentAttributeName();
                                                Object other$paymentAttributeName = other.getPaymentAttributeName();
                                                if (this$paymentAttributeName == null
                                                   ? other$paymentAttributeName == null
                                                   : this$paymentAttributeName.equals(other$paymentAttributeName)) {
                                                   Object this$paymentDate = this.getPaymentDate();
                                                   Object other$paymentDate = other.getPaymentDate();
                                                   if (this$paymentDate == null ? other$paymentDate == null : this$paymentDate.equals(other$paymentDate)) {
                                                      Object this$paymentAmount = this.getPaymentAmount();
                                                      Object other$paymentAmount = other.getPaymentAmount();
                                                      if (this$paymentAmount == null
                                                         ? other$paymentAmount == null
                                                         : this$paymentAmount.equals(other$paymentAmount)) {
                                                         Object this$totalPaymentAmount = this.getTotalPaymentAmount();
                                                         Object other$totalPaymentAmount = other.getTotalPaymentAmount();
                                                         if (this$totalPaymentAmount == null
                                                            ? other$totalPaymentAmount == null
                                                            : this$totalPaymentAmount.equals(other$totalPaymentAmount)) {
                                                            Object this$remark = this.getRemark();
                                                            Object other$remark = other.getRemark();
                                                            if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                               Object this$branchCompanyName = this.getBranchCompanyName();
                                                               Object other$branchCompanyName = other.getBranchCompanyName();
                                                               if (this$branchCompanyName == null
                                                                  ? other$branchCompanyName == null
                                                                  : this$branchCompanyName.equals(other$branchCompanyName)) {
                                                                  Object this$amount = this.getAmount();
                                                                  Object other$amount = other.getAmount();
                                                                  if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                                     Object this$basicClassName = this.getBasicClassName();
                                                                     Object other$basicClassName = other.getBasicClassName();
                                                                     if (this$basicClassName == null
                                                                        ? other$basicClassName == null
                                                                        : this$basicClassName.equals(other$basicClassName)) {
                                                                        Object this$settlementAmount = this.getSettlementAmount();
                                                                        Object other$settlementAmount = other.getSettlementAmount();
                                                                        if (this$settlementAmount == null
                                                                           ? other$settlementAmount == null
                                                                           : this$settlementAmount.equals(other$settlementAmount)) {
                                                                           Object this$serialNumber = this.getSerialNumber();
                                                                           Object other$serialNumber = other.getSerialNumber();
                                                                           if (this$serialNumber == null
                                                                              ? other$serialNumber == null
                                                                              : this$serialNumber.equals(other$serialNumber)) {
                                                                              Object this$list = this.getList();
                                                                              Object other$list = other.getList();
                                                                              if (this$list == null ? other$list == null : this$list.equals(other$list)) {
                                                                                 Object this$attachmentIds = this.getAttachmentIds();
                                                                                 Object other$attachmentIds = other.getAttachmentIds();
                                                                                 if (this$attachmentIds == null
                                                                                    ? other$attachmentIds == null
                                                                                    : this$attachmentIds.equals(other$attachmentIds)) {
                                                                                    Object this$attachmentDtoList = this.getAttachmentDtoList();
                                                                                    Object other$attachmentDtoList = other.getAttachmentDtoList();
                                                                                    if (this$attachmentDtoList == null
                                                                                       ? other$attachmentDtoList == null
                                                                                       : this$attachmentDtoList.equals(other$attachmentDtoList)) {
                                                                                       Object this$attachments = this.getAttachments();
                                                                                       Object other$attachments = other.getAttachments();
                                                                                       return this$attachments == null
                                                                                          ? other$attachments == null
                                                                                          : this$attachments.equals(other$attachments);
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
      return other instanceof SupplierAuditSelfEmployedDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $paymentType = this.getPaymentType();
      result = result * 59 + ($paymentType == null ? 43 : $paymentType.hashCode());
      Object $paymentAttributeId = this.getPaymentAttributeId();
      result = result * 59 + ($paymentAttributeId == null ? 43 : $paymentAttributeId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $createDate = this.getCreateDate();
      result = result * 59 + ($createDate == null ? 43 : $createDate.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectCollectionAmount = this.getProjectCollectionAmount();
      result = result * 59 + ($projectCollectionAmount == null ? 43 : $projectCollectionAmount.hashCode());
      Object $projectDisburseAmount = this.getProjectDisburseAmount();
      result = result * 59 + ($projectDisburseAmount == null ? 43 : $projectDisburseAmount.hashCode());
      Object $paymentBank = this.getPaymentBank();
      result = result * 59 + ($paymentBank == null ? 43 : $paymentBank.hashCode());
      Object $paymentBankAccount = this.getPaymentBankAccount();
      result = result * 59 + ($paymentBankAccount == null ? 43 : $paymentBankAccount.hashCode());
      Object $paymentAttributeName = this.getPaymentAttributeName();
      result = result * 59 + ($paymentAttributeName == null ? 43 : $paymentAttributeName.hashCode());
      Object $paymentDate = this.getPaymentDate();
      result = result * 59 + ($paymentDate == null ? 43 : $paymentDate.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $totalPaymentAmount = this.getTotalPaymentAmount();
      result = result * 59 + ($totalPaymentAmount == null ? 43 : $totalPaymentAmount.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $basicClassName = this.getBasicClassName();
      result = result * 59 + ($basicClassName == null ? 43 : $basicClassName.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $list = this.getList();
      result = result * 59 + ($list == null ? 43 : $list.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachmentDtoList = this.getAttachmentDtoList();
      result = result * 59 + ($attachmentDtoList == null ? 43 : $attachmentDtoList.hashCode());
      Object $attachments = this.getAttachments();
      return result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierAuditSelfEmployedDto(createDate="
         + this.getCreateDate()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", projectName="
         + this.getProjectName()
         + ", projectCollectionAmount="
         + this.getProjectCollectionAmount()
         + ", projectDisburseAmount="
         + this.getProjectDisburseAmount()
         + ", paymentBank="
         + this.getPaymentBank()
         + ", paymentBankAccount="
         + this.getPaymentBankAccount()
         + ", paymentType="
         + this.getPaymentType()
         + ", paymentAttributeId="
         + this.getPaymentAttributeId()
         + ", paymentAttributeName="
         + this.getPaymentAttributeName()
         + ", paymentDate="
         + this.getPaymentDate()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", totalPaymentAmount="
         + this.getTotalPaymentAmount()
         + ", remark="
         + this.getRemark()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", amount="
         + this.getAmount()
         + ", basicClass="
         + this.getBasicClass()
         + ", basicClassName="
         + this.getBasicClassName()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", list="
         + this.getList()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachmentDtoList="
         + this.getAttachmentDtoList()
         + ", attachments="
         + this.getAttachments()
         + ")";
   }

   public SupplierAuditSelfEmployedDto() {
   }

   public SupplierAuditSelfEmployedDto(
      final LocalDateTime createDate,
      final Long createUserId,
      final String createUserName,
      final Long supplierId,
      final String supplierName,
      final List<String> projectName,
      final BigDecimal projectCollectionAmount,
      final BigDecimal projectDisburseAmount,
      final String paymentBank,
      final String paymentBankAccount,
      final Integer paymentType,
      final Long paymentAttributeId,
      final String paymentAttributeName,
      final LocalDate paymentDate,
      final BigDecimal paymentAmount,
      final BigDecimal totalPaymentAmount,
      final String remark,
      final Long branchCompanyId,
      final String branchCompanyName,
      final BigDecimal amount,
      final Integer basicClass,
      final String basicClassName,
      final BigDecimal settlementAmount,
      final List<String> serialNumber,
      final List<SupplierSelfEmployedDto> list,
      final String attachmentIds,
      final List<AttachmentDTO> attachmentDtoList,
      final List<AttachmentDTO> attachments
   ) {
      this.createDate = createDate;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.projectName = projectName;
      this.projectCollectionAmount = projectCollectionAmount;
      this.projectDisburseAmount = projectDisburseAmount;
      this.paymentBank = paymentBank;
      this.paymentBankAccount = paymentBankAccount;
      this.paymentType = paymentType;
      this.paymentAttributeId = paymentAttributeId;
      this.paymentAttributeName = paymentAttributeName;
      this.paymentDate = paymentDate;
      this.paymentAmount = paymentAmount;
      this.totalPaymentAmount = totalPaymentAmount;
      this.remark = remark;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.amount = amount;
      this.basicClass = basicClass;
      this.basicClassName = basicClassName;
      this.settlementAmount = settlementAmount;
      this.serialNumber = serialNumber;
      this.list = list;
      this.attachmentIds = attachmentIds;
      this.attachmentDtoList = attachmentDtoList;
      this.attachments = attachments;
   }

   public static class SupplierAuditSelfEmployedDtoBuilder {
      private LocalDateTime createDate;
      private Long createUserId;
      private String createUserName;
      private Long supplierId;
      private String supplierName;
      private List<String> projectName;
      private BigDecimal projectCollectionAmount;
      private BigDecimal projectDisburseAmount;
      private String paymentBank;
      private String paymentBankAccount;
      private Integer paymentType;
      private Long paymentAttributeId;
      private String paymentAttributeName;
      private LocalDate paymentDate;
      private BigDecimal paymentAmount;
      private BigDecimal totalPaymentAmount;
      private String remark;
      private Long branchCompanyId;
      private String branchCompanyName;
      private BigDecimal amount;
      private Integer basicClass;
      private String basicClassName;
      private BigDecimal settlementAmount;
      private List<String> serialNumber;
      private List<SupplierSelfEmployedDto> list;
      private String attachmentIds;
      private List<AttachmentDTO> attachmentDtoList;
      private List<AttachmentDTO> attachments;

      SupplierAuditSelfEmployedDtoBuilder() {
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder createDate(final LocalDateTime createDate) {
         this.createDate = createDate;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder projectName(final List<String> projectName) {
         this.projectName = projectName;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder projectCollectionAmount(final BigDecimal projectCollectionAmount) {
         this.projectCollectionAmount = projectCollectionAmount;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder projectDisburseAmount(final BigDecimal projectDisburseAmount) {
         this.projectDisburseAmount = projectDisburseAmount;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder paymentBank(final String paymentBank) {
         this.paymentBank = paymentBank;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder paymentBankAccount(final String paymentBankAccount) {
         this.paymentBankAccount = paymentBankAccount;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder paymentType(final Integer paymentType) {
         this.paymentType = paymentType;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder paymentAttributeId(final Long paymentAttributeId) {
         this.paymentAttributeId = paymentAttributeId;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder paymentAttributeName(final String paymentAttributeName) {
         this.paymentAttributeName = paymentAttributeName;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder paymentDate(final LocalDate paymentDate) {
         this.paymentDate = paymentDate;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder totalPaymentAmount(final BigDecimal totalPaymentAmount) {
         this.totalPaymentAmount = totalPaymentAmount;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder basicClassName(final String basicClassName) {
         this.basicClassName = basicClassName;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder serialNumber(final List<String> serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder list(final List<SupplierSelfEmployedDto> list) {
         this.list = list;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder attachmentDtoList(final List<AttachmentDTO> attachmentDtoList) {
         this.attachmentDtoList = attachmentDtoList;
         return this;
      }

      public SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public SupplierAuditSelfEmployedDto build() {
         return new SupplierAuditSelfEmployedDto(
            this.createDate,
            this.createUserId,
            this.createUserName,
            this.supplierId,
            this.supplierName,
            this.projectName,
            this.projectCollectionAmount,
            this.projectDisburseAmount,
            this.paymentBank,
            this.paymentBankAccount,
            this.paymentType,
            this.paymentAttributeId,
            this.paymentAttributeName,
            this.paymentDate,
            this.paymentAmount,
            this.totalPaymentAmount,
            this.remark,
            this.branchCompanyId,
            this.branchCompanyName,
            this.amount,
            this.basicClass,
            this.basicClassName,
            this.settlementAmount,
            this.serialNumber,
            this.list,
            this.attachmentIds,
            this.attachmentDtoList,
            this.attachments
         );
      }

      @Override
      public String toString() {
         return "SupplierAuditSelfEmployedDto.SupplierAuditSelfEmployedDtoBuilder(createDate="
            + this.createDate
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", projectName="
            + this.projectName
            + ", projectCollectionAmount="
            + this.projectCollectionAmount
            + ", projectDisburseAmount="
            + this.projectDisburseAmount
            + ", paymentBank="
            + this.paymentBank
            + ", paymentBankAccount="
            + this.paymentBankAccount
            + ", paymentType="
            + this.paymentType
            + ", paymentAttributeId="
            + this.paymentAttributeId
            + ", paymentAttributeName="
            + this.paymentAttributeName
            + ", paymentDate="
            + this.paymentDate
            + ", paymentAmount="
            + this.paymentAmount
            + ", totalPaymentAmount="
            + this.totalPaymentAmount
            + ", remark="
            + this.remark
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", amount="
            + this.amount
            + ", basicClass="
            + this.basicClass
            + ", basicClassName="
            + this.basicClassName
            + ", settlementAmount="
            + this.settlementAmount
            + ", serialNumber="
            + this.serialNumber
            + ", list="
            + this.list
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachmentDtoList="
            + this.attachmentDtoList
            + ", attachments="
            + this.attachments
            + ")";
      }
   }
}
