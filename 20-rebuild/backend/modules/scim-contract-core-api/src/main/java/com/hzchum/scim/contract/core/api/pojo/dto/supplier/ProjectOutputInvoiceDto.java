package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("销项发票")
public class ProjectOutputInvoiceDto {
   @ApiModelProperty("申请日期")
   private LocalDateTime applyDate;
   @ApiModelProperty("申请人id")
   private Long applyUserId;
   @ApiModelProperty("申请人")
   private String applyName;
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("项目经理id")
   private Long projectManagerId;
   @ApiModelProperty("项目经理名称")
   private String projectManagerName;
   @ApiModelProperty(name = "salesLeaderId", value = "销售负责人id")
   private Long salesLeaderId;
   @ApiModelProperty(name = "salesLeaderName", notes = "销售负责人名字")
   private String salesLeaderName;
   @ApiModelProperty("签约主体id")
   private Long branchCompanyId;
   @ApiModelProperty("签约主体名称")
   private String branchCompanyName;
   @ApiModelProperty(name = "invoiceUnitId", value = "开票单位(合同签约主体ID)id")
   private Long invoiceUnitId;
   @ApiModelProperty(name = "invoiceUnit", value = "开票单位(合同签约主体)")
   private String invoiceUnit;
   @ApiModelProperty(name = "collectionUnit", value = "收票单位(客户单位)")
   private String collectionUnit;
   @ApiModelProperty("合同额")
   private BigDecimal amount;
   @ApiModelProperty("累计开票")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("累计收款")
   private BigDecimal paymentAmount;
   @ApiModelProperty("本次申请额")
   private BigDecimal applyAmount;
   @ApiModelProperty(name = "invoice_type", notes = "发票类型 1 增值税专用发票  2普通发票 4收据")
   private Integer invoiceType;
   @ApiModelProperty("购方全称")
   private String buyerName;
   @ApiModelProperty("纳税人识别号")
   private String buyerTaxpayerId;
   @ApiModelProperty("开户行")
   private String buyerBank;
   @ApiModelProperty("开户行账号")
   private String buyerBankAccount;
   @ApiModelProperty("地址")
   private String buyerAddress;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("发票号")
   private String invoiceNumber;
   @ApiModelProperty(name = "taxRateTypeValue", value = "字典配置税率value值")
   private String taxRateTypeValue;
   @ApiModelProperty("税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "actualInvoiceAmount", value = "实开发票面额(元)")
   private BigDecimal actualInvoiceAmount;
   @ApiModelProperty(name = "auditorId", value = "审核人id")
   private Long auditorId;
   @ApiModelProperty(name = "auditorName", value = "审核人名字")
   private String auditorName;
   @ApiModelProperty(name = "attachmentIds", value = "附件id", notes = "附件id")
   private String attachmentIds;
   @ApiModelProperty(name = "attachmentList", value = "附件列表", notes = "附件列表")
   private List<AttachmentDTO> attachmentList;
   @ApiModelProperty(name = "attachments", value = "附件列表", notes = "附件列表")
   private List<AttachmentDTO> attachments;

   ProjectOutputInvoiceDto(
      final LocalDateTime applyDate,
      final Long applyUserId,
      final String applyName,
      final Long projectId,
      final String projectName,
      final Long projectManagerId,
      final String projectManagerName,
      final Long salesLeaderId,
      final String salesLeaderName,
      final Long branchCompanyId,
      final String branchCompanyName,
      final Long invoiceUnitId,
      final String invoiceUnit,
      final String collectionUnit,
      final BigDecimal amount,
      final BigDecimal invoiceAmount,
      final BigDecimal paymentAmount,
      final BigDecimal applyAmount,
      final Integer invoiceType,
      final String buyerName,
      final String buyerTaxpayerId,
      final String buyerBank,
      final String buyerBankAccount,
      final String buyerAddress,
      final String remark,
      final String invoiceNumber,
      final String taxRateTypeValue,
      final BigDecimal taxRate,
      final BigDecimal actualInvoiceAmount,
      final Long auditorId,
      final String auditorName,
      final String attachmentIds,
      final List<AttachmentDTO> attachmentList,
      final List<AttachmentDTO> attachments
   ) {
      this.applyDate = applyDate;
      this.applyUserId = applyUserId;
      this.applyName = applyName;
      this.projectId = projectId;
      this.projectName = projectName;
      this.projectManagerId = projectManagerId;
      this.projectManagerName = projectManagerName;
      this.salesLeaderId = salesLeaderId;
      this.salesLeaderName = salesLeaderName;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.invoiceUnitId = invoiceUnitId;
      this.invoiceUnit = invoiceUnit;
      this.collectionUnit = collectionUnit;
      this.amount = amount;
      this.invoiceAmount = invoiceAmount;
      this.paymentAmount = paymentAmount;
      this.applyAmount = applyAmount;
      this.invoiceType = invoiceType;
      this.buyerName = buyerName;
      this.buyerTaxpayerId = buyerTaxpayerId;
      this.buyerBank = buyerBank;
      this.buyerBankAccount = buyerBankAccount;
      this.buyerAddress = buyerAddress;
      this.remark = remark;
      this.invoiceNumber = invoiceNumber;
      this.taxRateTypeValue = taxRateTypeValue;
      this.taxRate = taxRate;
      this.actualInvoiceAmount = actualInvoiceAmount;
      this.auditorId = auditorId;
      this.auditorName = auditorName;
      this.attachmentIds = attachmentIds;
      this.attachmentList = attachmentList;
      this.attachments = attachments;
   }

   public static ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder builder() {
      return new ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder();
   }

   public LocalDateTime getApplyDate() {
      return this.applyDate;
   }

   public Long getApplyUserId() {
      return this.applyUserId;
   }

   public String getApplyName() {
      return this.applyName;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public Long getSalesLeaderId() {
      return this.salesLeaderId;
   }

   public String getSalesLeaderName() {
      return this.salesLeaderName;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public Long getInvoiceUnitId() {
      return this.invoiceUnitId;
   }

   public String getInvoiceUnit() {
      return this.invoiceUnit;
   }

   public String getCollectionUnit() {
      return this.collectionUnit;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public BigDecimal getApplyAmount() {
      return this.applyAmount;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public String getBuyerName() {
      return this.buyerName;
   }

   public String getBuyerTaxpayerId() {
      return this.buyerTaxpayerId;
   }

   public String getBuyerBank() {
      return this.buyerBank;
   }

   public String getBuyerBankAccount() {
      return this.buyerBankAccount;
   }

   public String getBuyerAddress() {
      return this.buyerAddress;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getInvoiceNumber() {
      return this.invoiceNumber;
   }

   public String getTaxRateTypeValue() {
      return this.taxRateTypeValue;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getActualInvoiceAmount() {
      return this.actualInvoiceAmount;
   }

   public Long getAuditorId() {
      return this.auditorId;
   }

   public String getAuditorName() {
      return this.auditorName;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<AttachmentDTO> getAttachmentList() {
      return this.attachmentList;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public void setApplyDate(final LocalDateTime applyDate) {
      this.applyDate = applyDate;
   }

   public void setApplyUserId(final Long applyUserId) {
      this.applyUserId = applyUserId;
   }

   public void setApplyName(final String applyName) {
      this.applyName = applyName;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setSalesLeaderId(final Long salesLeaderId) {
      this.salesLeaderId = salesLeaderId;
   }

   public void setSalesLeaderName(final String salesLeaderName) {
      this.salesLeaderName = salesLeaderName;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setInvoiceUnitId(final Long invoiceUnitId) {
      this.invoiceUnitId = invoiceUnitId;
   }

   public void setInvoiceUnit(final String invoiceUnit) {
      this.invoiceUnit = invoiceUnit;
   }

   public void setCollectionUnit(final String collectionUnit) {
      this.collectionUnit = collectionUnit;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setBuyerName(final String buyerName) {
      this.buyerName = buyerName;
   }

   public void setBuyerTaxpayerId(final String buyerTaxpayerId) {
      this.buyerTaxpayerId = buyerTaxpayerId;
   }

   public void setBuyerBank(final String buyerBank) {
      this.buyerBank = buyerBank;
   }

   public void setBuyerBankAccount(final String buyerBankAccount) {
      this.buyerBankAccount = buyerBankAccount;
   }

   public void setBuyerAddress(final String buyerAddress) {
      this.buyerAddress = buyerAddress;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setInvoiceNumber(final String invoiceNumber) {
      this.invoiceNumber = invoiceNumber;
   }

   public void setTaxRateTypeValue(final String taxRateTypeValue) {
      this.taxRateTypeValue = taxRateTypeValue;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setActualInvoiceAmount(final BigDecimal actualInvoiceAmount) {
      this.actualInvoiceAmount = actualInvoiceAmount;
   }

   public void setAuditorId(final Long auditorId) {
      this.auditorId = auditorId;
   }

   public void setAuditorName(final String auditorName) {
      this.auditorName = auditorName;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setAttachmentList(final List<AttachmentDTO> attachmentList) {
      this.attachmentList = attachmentList;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectOutputInvoiceDto)) {
         return false;
      }

      ProjectOutputInvoiceDto other = (ProjectOutputInvoiceDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$applyUserId = this.getApplyUserId();
      Object other$applyUserId = other.getApplyUserId();
      if (this$applyUserId == null ? other$applyUserId == null : this$applyUserId.equals(other$applyUserId)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$projectManagerId = this.getProjectManagerId();
            Object other$projectManagerId = other.getProjectManagerId();
            if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
               Object this$salesLeaderId = this.getSalesLeaderId();
               Object other$salesLeaderId = other.getSalesLeaderId();
               if (this$salesLeaderId == null ? other$salesLeaderId == null : this$salesLeaderId.equals(other$salesLeaderId)) {
                  Object this$branchCompanyId = this.getBranchCompanyId();
                  Object other$branchCompanyId = other.getBranchCompanyId();
                  if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                     Object this$invoiceUnitId = this.getInvoiceUnitId();
                     Object other$invoiceUnitId = other.getInvoiceUnitId();
                     if (this$invoiceUnitId == null ? other$invoiceUnitId == null : this$invoiceUnitId.equals(other$invoiceUnitId)) {
                        Object this$invoiceType = this.getInvoiceType();
                        Object other$invoiceType = other.getInvoiceType();
                        if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                           Object this$auditorId = this.getAuditorId();
                           Object other$auditorId = other.getAuditorId();
                           if (this$auditorId == null ? other$auditorId == null : this$auditorId.equals(other$auditorId)) {
                              Object this$applyDate = this.getApplyDate();
                              Object other$applyDate = other.getApplyDate();
                              if (this$applyDate == null ? other$applyDate == null : this$applyDate.equals(other$applyDate)) {
                                 Object this$applyName = this.getApplyName();
                                 Object other$applyName = other.getApplyName();
                                 if (this$applyName == null ? other$applyName == null : this$applyName.equals(other$applyName)) {
                                    Object this$projectName = this.getProjectName();
                                    Object other$projectName = other.getProjectName();
                                    if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                       Object this$projectManagerName = this.getProjectManagerName();
                                       Object other$projectManagerName = other.getProjectManagerName();
                                       if (this$projectManagerName == null
                                          ? other$projectManagerName == null
                                          : this$projectManagerName.equals(other$projectManagerName)) {
                                          Object this$salesLeaderName = this.getSalesLeaderName();
                                          Object other$salesLeaderName = other.getSalesLeaderName();
                                          if (this$salesLeaderName == null ? other$salesLeaderName == null : this$salesLeaderName.equals(other$salesLeaderName)
                                             )
                                           {
                                             Object this$branchCompanyName = this.getBranchCompanyName();
                                             Object other$branchCompanyName = other.getBranchCompanyName();
                                             if (this$branchCompanyName == null
                                                ? other$branchCompanyName == null
                                                : this$branchCompanyName.equals(other$branchCompanyName)) {
                                                Object this$invoiceUnit = this.getInvoiceUnit();
                                                Object other$invoiceUnit = other.getInvoiceUnit();
                                                if (this$invoiceUnit == null ? other$invoiceUnit == null : this$invoiceUnit.equals(other$invoiceUnit)) {
                                                   Object this$collectionUnit = this.getCollectionUnit();
                                                   Object other$collectionUnit = other.getCollectionUnit();
                                                   if (this$collectionUnit == null
                                                      ? other$collectionUnit == null
                                                      : this$collectionUnit.equals(other$collectionUnit)) {
                                                      Object this$amount = this.getAmount();
                                                      Object other$amount = other.getAmount();
                                                      if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                         Object this$invoiceAmount = this.getInvoiceAmount();
                                                         Object other$invoiceAmount = other.getInvoiceAmount();
                                                         if (this$invoiceAmount == null
                                                            ? other$invoiceAmount == null
                                                            : this$invoiceAmount.equals(other$invoiceAmount)) {
                                                            Object this$paymentAmount = this.getPaymentAmount();
                                                            Object other$paymentAmount = other.getPaymentAmount();
                                                            if (this$paymentAmount == null
                                                               ? other$paymentAmount == null
                                                               : this$paymentAmount.equals(other$paymentAmount)) {
                                                               Object this$applyAmount = this.getApplyAmount();
                                                               Object other$applyAmount = other.getApplyAmount();
                                                               if (this$applyAmount == null
                                                                  ? other$applyAmount == null
                                                                  : this$applyAmount.equals(other$applyAmount)) {
                                                                  Object this$buyerName = this.getBuyerName();
                                                                  Object other$buyerName = other.getBuyerName();
                                                                  if (this$buyerName == null ? other$buyerName == null : this$buyerName.equals(other$buyerName)
                                                                     )
                                                                   {
                                                                     Object this$buyerTaxpayerId = this.getBuyerTaxpayerId();
                                                                     Object other$buyerTaxpayerId = other.getBuyerTaxpayerId();
                                                                     if (this$buyerTaxpayerId == null
                                                                        ? other$buyerTaxpayerId == null
                                                                        : this$buyerTaxpayerId.equals(other$buyerTaxpayerId)) {
                                                                        Object this$buyerBank = this.getBuyerBank();
                                                                        Object other$buyerBank = other.getBuyerBank();
                                                                        if (this$buyerBank == null
                                                                           ? other$buyerBank == null
                                                                           : this$buyerBank.equals(other$buyerBank)) {
                                                                           Object this$buyerBankAccount = this.getBuyerBankAccount();
                                                                           Object other$buyerBankAccount = other.getBuyerBankAccount();
                                                                           if (this$buyerBankAccount == null
                                                                              ? other$buyerBankAccount == null
                                                                              : this$buyerBankAccount.equals(other$buyerBankAccount)) {
                                                                              Object this$buyerAddress = this.getBuyerAddress();
                                                                              Object other$buyerAddress = other.getBuyerAddress();
                                                                              if (this$buyerAddress == null
                                                                                 ? other$buyerAddress == null
                                                                                 : this$buyerAddress.equals(other$buyerAddress)) {
                                                                                 Object this$remark = this.getRemark();
                                                                                 Object other$remark = other.getRemark();
                                                                                 if (this$remark == null
                                                                                    ? other$remark == null
                                                                                    : this$remark.equals(other$remark)) {
                                                                                    Object this$invoiceNumber = this.getInvoiceNumber();
                                                                                    Object other$invoiceNumber = other.getInvoiceNumber();
                                                                                    if (this$invoiceNumber == null
                                                                                       ? other$invoiceNumber == null
                                                                                       : this$invoiceNumber.equals(other$invoiceNumber)) {
                                                                                       Object this$taxRateTypeValue = this.getTaxRateTypeValue();
                                                                                       Object other$taxRateTypeValue = other.getTaxRateTypeValue();
                                                                                       if (this$taxRateTypeValue == null
                                                                                          ? other$taxRateTypeValue == null
                                                                                          : this$taxRateTypeValue.equals(other$taxRateTypeValue)) {
                                                                                          Object this$taxRate = this.getTaxRate();
                                                                                          Object other$taxRate = other.getTaxRate();
                                                                                          if (this$taxRate == null
                                                                                             ? other$taxRate == null
                                                                                             : this$taxRate.equals(other$taxRate)) {
                                                                                             Object this$actualInvoiceAmount = this.getActualInvoiceAmount();
                                                                                             Object other$actualInvoiceAmount = other.getActualInvoiceAmount();
                                                                                             if (this$actualInvoiceAmount == null
                                                                                                ? other$actualInvoiceAmount == null
                                                                                                : this$actualInvoiceAmount.equals(other$actualInvoiceAmount)) {
                                                                                                Object this$auditorName = this.getAuditorName();
                                                                                                Object other$auditorName = other.getAuditorName();
                                                                                                if (this$auditorName == null
                                                                                                   ? other$auditorName == null
                                                                                                   : this$auditorName.equals(other$auditorName)) {
                                                                                                   Object this$attachmentIds = this.getAttachmentIds();
                                                                                                   Object other$attachmentIds = other.getAttachmentIds();
                                                                                                   if (this$attachmentIds == null
                                                                                                      ? other$attachmentIds == null
                                                                                                      : this$attachmentIds.equals(other$attachmentIds)) {
                                                                                                      Object this$attachmentList = this.getAttachmentList();
                                                                                                      Object other$attachmentList = other.getAttachmentList();
                                                                                                      if (this$attachmentList == null
                                                                                                         ? other$attachmentList == null
                                                                                                         : this$attachmentList.equals(other$attachmentList)) {
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
      return other instanceof ProjectOutputInvoiceDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $applyUserId = this.getApplyUserId();
      result = result * 59 + ($applyUserId == null ? 43 : $applyUserId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $salesLeaderId = this.getSalesLeaderId();
      result = result * 59 + ($salesLeaderId == null ? 43 : $salesLeaderId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $invoiceUnitId = this.getInvoiceUnitId();
      result = result * 59 + ($invoiceUnitId == null ? 43 : $invoiceUnitId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $auditorId = this.getAuditorId();
      result = result * 59 + ($auditorId == null ? 43 : $auditorId.hashCode());
      Object $applyDate = this.getApplyDate();
      result = result * 59 + ($applyDate == null ? 43 : $applyDate.hashCode());
      Object $applyName = this.getApplyName();
      result = result * 59 + ($applyName == null ? 43 : $applyName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $salesLeaderName = this.getSalesLeaderName();
      result = result * 59 + ($salesLeaderName == null ? 43 : $salesLeaderName.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $invoiceUnit = this.getInvoiceUnit();
      result = result * 59 + ($invoiceUnit == null ? 43 : $invoiceUnit.hashCode());
      Object $collectionUnit = this.getCollectionUnit();
      result = result * 59 + ($collectionUnit == null ? 43 : $collectionUnit.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $buyerName = this.getBuyerName();
      result = result * 59 + ($buyerName == null ? 43 : $buyerName.hashCode());
      Object $buyerTaxpayerId = this.getBuyerTaxpayerId();
      result = result * 59 + ($buyerTaxpayerId == null ? 43 : $buyerTaxpayerId.hashCode());
      Object $buyerBank = this.getBuyerBank();
      result = result * 59 + ($buyerBank == null ? 43 : $buyerBank.hashCode());
      Object $buyerBankAccount = this.getBuyerBankAccount();
      result = result * 59 + ($buyerBankAccount == null ? 43 : $buyerBankAccount.hashCode());
      Object $buyerAddress = this.getBuyerAddress();
      result = result * 59 + ($buyerAddress == null ? 43 : $buyerAddress.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $invoiceNumber = this.getInvoiceNumber();
      result = result * 59 + ($invoiceNumber == null ? 43 : $invoiceNumber.hashCode());
      Object $taxRateTypeValue = this.getTaxRateTypeValue();
      result = result * 59 + ($taxRateTypeValue == null ? 43 : $taxRateTypeValue.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $actualInvoiceAmount = this.getActualInvoiceAmount();
      result = result * 59 + ($actualInvoiceAmount == null ? 43 : $actualInvoiceAmount.hashCode());
      Object $auditorName = this.getAuditorName();
      result = result * 59 + ($auditorName == null ? 43 : $auditorName.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachmentList = this.getAttachmentList();
      result = result * 59 + ($attachmentList == null ? 43 : $attachmentList.hashCode());
      Object $attachments = this.getAttachments();
      return result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectOutputInvoiceDto(applyDate="
         + this.getApplyDate()
         + ", applyUserId="
         + this.getApplyUserId()
         + ", applyName="
         + this.getApplyName()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", salesLeaderId="
         + this.getSalesLeaderId()
         + ", salesLeaderName="
         + this.getSalesLeaderName()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", invoiceUnitId="
         + this.getInvoiceUnitId()
         + ", invoiceUnit="
         + this.getInvoiceUnit()
         + ", collectionUnit="
         + this.getCollectionUnit()
         + ", amount="
         + this.getAmount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", applyAmount="
         + this.getApplyAmount()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", buyerName="
         + this.getBuyerName()
         + ", buyerTaxpayerId="
         + this.getBuyerTaxpayerId()
         + ", buyerBank="
         + this.getBuyerBank()
         + ", buyerBankAccount="
         + this.getBuyerBankAccount()
         + ", buyerAddress="
         + this.getBuyerAddress()
         + ", remark="
         + this.getRemark()
         + ", invoiceNumber="
         + this.getInvoiceNumber()
         + ", taxRateTypeValue="
         + this.getTaxRateTypeValue()
         + ", taxRate="
         + this.getTaxRate()
         + ", actualInvoiceAmount="
         + this.getActualInvoiceAmount()
         + ", auditorId="
         + this.getAuditorId()
         + ", auditorName="
         + this.getAuditorName()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachmentList="
         + this.getAttachmentList()
         + ", attachments="
         + this.getAttachments()
         + ")";
   }

   public static class ProjectOutputInvoiceDtoBuilder {
      private LocalDateTime applyDate;
      private Long applyUserId;
      private String applyName;
      private Long projectId;
      private String projectName;
      private Long projectManagerId;
      private String projectManagerName;
      private Long salesLeaderId;
      private String salesLeaderName;
      private Long branchCompanyId;
      private String branchCompanyName;
      private Long invoiceUnitId;
      private String invoiceUnit;
      private String collectionUnit;
      private BigDecimal amount;
      private BigDecimal invoiceAmount;
      private BigDecimal paymentAmount;
      private BigDecimal applyAmount;
      private Integer invoiceType;
      private String buyerName;
      private String buyerTaxpayerId;
      private String buyerBank;
      private String buyerBankAccount;
      private String buyerAddress;
      private String remark;
      private String invoiceNumber;
      private String taxRateTypeValue;
      private BigDecimal taxRate;
      private BigDecimal actualInvoiceAmount;
      private Long auditorId;
      private String auditorName;
      private String attachmentIds;
      private List<AttachmentDTO> attachmentList;
      private List<AttachmentDTO> attachments;

      ProjectOutputInvoiceDtoBuilder() {
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder applyDate(final LocalDateTime applyDate) {
         this.applyDate = applyDate;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder applyUserId(final Long applyUserId) {
         this.applyUserId = applyUserId;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder applyName(final String applyName) {
         this.applyName = applyName;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder projectManagerName(final String projectManagerName) {
         this.projectManagerName = projectManagerName;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder salesLeaderId(final Long salesLeaderId) {
         this.salesLeaderId = salesLeaderId;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder salesLeaderName(final String salesLeaderName) {
         this.salesLeaderName = salesLeaderName;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder invoiceUnitId(final Long invoiceUnitId) {
         this.invoiceUnitId = invoiceUnitId;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder invoiceUnit(final String invoiceUnit) {
         this.invoiceUnit = invoiceUnit;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder collectionUnit(final String collectionUnit) {
         this.collectionUnit = collectionUnit;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder applyAmount(final BigDecimal applyAmount) {
         this.applyAmount = applyAmount;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder buyerName(final String buyerName) {
         this.buyerName = buyerName;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder buyerTaxpayerId(final String buyerTaxpayerId) {
         this.buyerTaxpayerId = buyerTaxpayerId;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder buyerBank(final String buyerBank) {
         this.buyerBank = buyerBank;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder buyerBankAccount(final String buyerBankAccount) {
         this.buyerBankAccount = buyerBankAccount;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder buyerAddress(final String buyerAddress) {
         this.buyerAddress = buyerAddress;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder invoiceNumber(final String invoiceNumber) {
         this.invoiceNumber = invoiceNumber;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder taxRateTypeValue(final String taxRateTypeValue) {
         this.taxRateTypeValue = taxRateTypeValue;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder actualInvoiceAmount(final BigDecimal actualInvoiceAmount) {
         this.actualInvoiceAmount = actualInvoiceAmount;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder auditorId(final Long auditorId) {
         this.auditorId = auditorId;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder auditorName(final String auditorName) {
         this.auditorName = auditorName;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder attachmentList(final List<AttachmentDTO> attachmentList) {
         this.attachmentList = attachmentList;
         return this;
      }

      public ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public ProjectOutputInvoiceDto build() {
         return new ProjectOutputInvoiceDto(
            this.applyDate,
            this.applyUserId,
            this.applyName,
            this.projectId,
            this.projectName,
            this.projectManagerId,
            this.projectManagerName,
            this.salesLeaderId,
            this.salesLeaderName,
            this.branchCompanyId,
            this.branchCompanyName,
            this.invoiceUnitId,
            this.invoiceUnit,
            this.collectionUnit,
            this.amount,
            this.invoiceAmount,
            this.paymentAmount,
            this.applyAmount,
            this.invoiceType,
            this.buyerName,
            this.buyerTaxpayerId,
            this.buyerBank,
            this.buyerBankAccount,
            this.buyerAddress,
            this.remark,
            this.invoiceNumber,
            this.taxRateTypeValue,
            this.taxRate,
            this.actualInvoiceAmount,
            this.auditorId,
            this.auditorName,
            this.attachmentIds,
            this.attachmentList,
            this.attachments
         );
      }

      @Override
      public String toString() {
         return "ProjectOutputInvoiceDto.ProjectOutputInvoiceDtoBuilder(applyDate="
            + this.applyDate
            + ", applyUserId="
            + this.applyUserId
            + ", applyName="
            + this.applyName
            + ", projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", projectManagerId="
            + this.projectManagerId
            + ", projectManagerName="
            + this.projectManagerName
            + ", salesLeaderId="
            + this.salesLeaderId
            + ", salesLeaderName="
            + this.salesLeaderName
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", invoiceUnitId="
            + this.invoiceUnitId
            + ", invoiceUnit="
            + this.invoiceUnit
            + ", collectionUnit="
            + this.collectionUnit
            + ", amount="
            + this.amount
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", paymentAmount="
            + this.paymentAmount
            + ", applyAmount="
            + this.applyAmount
            + ", invoiceType="
            + this.invoiceType
            + ", buyerName="
            + this.buyerName
            + ", buyerTaxpayerId="
            + this.buyerTaxpayerId
            + ", buyerBank="
            + this.buyerBank
            + ", buyerBankAccount="
            + this.buyerBankAccount
            + ", buyerAddress="
            + this.buyerAddress
            + ", remark="
            + this.remark
            + ", invoiceNumber="
            + this.invoiceNumber
            + ", taxRateTypeValue="
            + this.taxRateTypeValue
            + ", taxRate="
            + this.taxRate
            + ", actualInvoiceAmount="
            + this.actualInvoiceAmount
            + ", auditorId="
            + this.auditorId
            + ", auditorName="
            + this.auditorName
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachmentList="
            + this.attachmentList
            + ", attachments="
            + this.attachments
            + ")";
      }
   }
}
