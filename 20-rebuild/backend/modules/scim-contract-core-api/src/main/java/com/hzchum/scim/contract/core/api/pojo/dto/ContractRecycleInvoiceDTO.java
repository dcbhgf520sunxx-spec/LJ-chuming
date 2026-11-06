package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "ContractRecycleInvoiceDTO对象", description = "制品回收-收票")
public class ContractRecycleInvoiceDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty("项目")
   private ProjectInfo project;
   @ApiModelProperty("收票日期")
   private LocalDate receiveInvoiceDate;
   @ApiModelProperty("发票面额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("发票类型 1增值专用票 2增值普发票 4收据")
   private Integer invoiceType;
   @ApiModelProperty(name = "boolIncludeTax", value = "是否含税 true含税 false免税")
   private Boolean boolIncludeTax;
   @ApiModelProperty("税率")
   private BigDecimal taxRate;
   @ApiModelProperty("税额")
   private BigDecimal tax;
   @ApiModelProperty("不含税金额")
   private BigDecimal amountExcludingTax;
   @ApiModelProperty("购方单位(签订主体id)")
   private Long branchCompanyId;
   @ApiModelProperty("购方单位(签订主体名称)")
   private String branchCompanyName;
   @ApiModelProperty("供应商id(开票单位id)")
   private Long supplierId;
   @ApiModelProperty("供应商(开票单位)")
   private String supplierName;
   @ApiModelProperty("发票号码")
   private String invoiceSerialNumber;
   @ApiModelProperty("申请人id")
   private Long applyUserId;
   @ApiModelProperty("申请人名称")
   private String applyUserName;
   @ApiModelProperty("审核人")
   private Long auditUserId;
   @ApiModelProperty("审核人名字")
   private String auditUserName;
   @ApiModelProperty("审核时间")
   private LocalDateTime auditTime;
   @ApiModelProperty("审核状态1 未审核(审核中、待审核) 2审核通过 4驳回")
   private Integer auditStatus;
   @ApiModelProperty("附件id字符串")
   private String attachmentIds;
   @ApiModelProperty("附件列表")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("创建时间")
   private LocalDateTime createTime;

   public static ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder builder() {
      return new ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder();
   }

   public ContractRecycleInvoiceDTO() {
   }

   public ContractRecycleInvoiceDTO(
      final Long id,
      final ProjectInfo project,
      final LocalDate receiveInvoiceDate,
      final BigDecimal invoiceAmount,
      final Integer invoiceType,
      final Boolean boolIncludeTax,
      final BigDecimal taxRate,
      final BigDecimal tax,
      final BigDecimal amountExcludingTax,
      final Long branchCompanyId,
      final String branchCompanyName,
      final Long supplierId,
      final String supplierName,
      final String invoiceSerialNumber,
      final Long applyUserId,
      final String applyUserName,
      final Long auditUserId,
      final String auditUserName,
      final LocalDateTime auditTime,
      final Integer auditStatus,
      final String attachmentIds,
      final List<AttachmentDTO> attachments,
      final String remark,
      final LocalDateTime createTime
   ) {
      this.id = id;
      this.project = project;
      this.receiveInvoiceDate = receiveInvoiceDate;
      this.invoiceAmount = invoiceAmount;
      this.invoiceType = invoiceType;
      this.boolIncludeTax = boolIncludeTax;
      this.taxRate = taxRate;
      this.tax = tax;
      this.amountExcludingTax = amountExcludingTax;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.invoiceSerialNumber = invoiceSerialNumber;
      this.applyUserId = applyUserId;
      this.applyUserName = applyUserName;
      this.auditUserId = auditUserId;
      this.auditUserName = auditUserName;
      this.auditTime = auditTime;
      this.auditStatus = auditStatus;
      this.attachmentIds = attachmentIds;
      this.attachments = attachments;
      this.remark = remark;
      this.createTime = createTime;
   }

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public LocalDate getReceiveInvoiceDate() {
      return this.receiveInvoiceDate;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Boolean getBoolIncludeTax() {
      return this.boolIncludeTax;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getTax() {
      return this.tax;
   }

   public BigDecimal getAmountExcludingTax() {
      return this.amountExcludingTax;
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

   public String getInvoiceSerialNumber() {
      return this.invoiceSerialNumber;
   }

   public Long getApplyUserId() {
      return this.applyUserId;
   }

   public String getApplyUserName() {
      return this.applyUserName;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public String getRemark() {
      return this.remark;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setReceiveInvoiceDate(final LocalDate receiveInvoiceDate) {
      this.receiveInvoiceDate = receiveInvoiceDate;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setBoolIncludeTax(final Boolean boolIncludeTax) {
      this.boolIncludeTax = boolIncludeTax;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setTax(final BigDecimal tax) {
      this.tax = tax;
   }

   public void setAmountExcludingTax(final BigDecimal amountExcludingTax) {
      this.amountExcludingTax = amountExcludingTax;
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

   public void setInvoiceSerialNumber(final String invoiceSerialNumber) {
      this.invoiceSerialNumber = invoiceSerialNumber;
   }

   public void setApplyUserId(final Long applyUserId) {
      this.applyUserId = applyUserId;
   }

   public void setApplyUserName(final String applyUserName) {
      this.applyUserName = applyUserName;
   }

   public void setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractRecycleInvoiceDTO)) {
         return false;
      }

      ContractRecycleInvoiceDTO other = (ContractRecycleInvoiceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$invoiceType = this.getInvoiceType();
         Object other$invoiceType = other.getInvoiceType();
         if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
            Object this$boolIncludeTax = this.getBoolIncludeTax();
            Object other$boolIncludeTax = other.getBoolIncludeTax();
            if (this$boolIncludeTax == null ? other$boolIncludeTax == null : this$boolIncludeTax.equals(other$boolIncludeTax)) {
               Object this$branchCompanyId = this.getBranchCompanyId();
               Object other$branchCompanyId = other.getBranchCompanyId();
               if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$applyUserId = this.getApplyUserId();
                     Object other$applyUserId = other.getApplyUserId();
                     if (this$applyUserId == null ? other$applyUserId == null : this$applyUserId.equals(other$applyUserId)) {
                        Object this$auditUserId = this.getAuditUserId();
                        Object other$auditUserId = other.getAuditUserId();
                        if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                           Object this$auditStatus = this.getAuditStatus();
                           Object other$auditStatus = other.getAuditStatus();
                           if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                              Object this$project = this.getProject();
                              Object other$project = other.getProject();
                              if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                 Object this$receiveInvoiceDate = this.getReceiveInvoiceDate();
                                 Object other$receiveInvoiceDate = other.getReceiveInvoiceDate();
                                 if (this$receiveInvoiceDate == null
                                    ? other$receiveInvoiceDate == null
                                    : this$receiveInvoiceDate.equals(other$receiveInvoiceDate)) {
                                    Object this$invoiceAmount = this.getInvoiceAmount();
                                    Object other$invoiceAmount = other.getInvoiceAmount();
                                    if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                                       Object this$taxRate = this.getTaxRate();
                                       Object other$taxRate = other.getTaxRate();
                                       if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                          Object this$tax = this.getTax();
                                          Object other$tax = other.getTax();
                                          if (this$tax == null ? other$tax == null : this$tax.equals(other$tax)) {
                                             Object this$amountExcludingTax = this.getAmountExcludingTax();
                                             Object other$amountExcludingTax = other.getAmountExcludingTax();
                                             if (this$amountExcludingTax == null
                                                ? other$amountExcludingTax == null
                                                : this$amountExcludingTax.equals(other$amountExcludingTax)) {
                                                Object this$branchCompanyName = this.getBranchCompanyName();
                                                Object other$branchCompanyName = other.getBranchCompanyName();
                                                if (this$branchCompanyName == null
                                                   ? other$branchCompanyName == null
                                                   : this$branchCompanyName.equals(other$branchCompanyName)) {
                                                   Object this$supplierName = this.getSupplierName();
                                                   Object other$supplierName = other.getSupplierName();
                                                   if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                                      Object this$invoiceSerialNumber = this.getInvoiceSerialNumber();
                                                      Object other$invoiceSerialNumber = other.getInvoiceSerialNumber();
                                                      if (this$invoiceSerialNumber == null
                                                         ? other$invoiceSerialNumber == null
                                                         : this$invoiceSerialNumber.equals(other$invoiceSerialNumber)) {
                                                         Object this$applyUserName = this.getApplyUserName();
                                                         Object other$applyUserName = other.getApplyUserName();
                                                         if (this$applyUserName == null
                                                            ? other$applyUserName == null
                                                            : this$applyUserName.equals(other$applyUserName)) {
                                                            Object this$auditUserName = this.getAuditUserName();
                                                            Object other$auditUserName = other.getAuditUserName();
                                                            if (this$auditUserName == null
                                                               ? other$auditUserName == null
                                                               : this$auditUserName.equals(other$auditUserName)) {
                                                               Object this$auditTime = this.getAuditTime();
                                                               Object other$auditTime = other.getAuditTime();
                                                               if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
                                                                  Object this$attachmentIds = this.getAttachmentIds();
                                                                  Object other$attachmentIds = other.getAttachmentIds();
                                                                  if (this$attachmentIds == null
                                                                     ? other$attachmentIds == null
                                                                     : this$attachmentIds.equals(other$attachmentIds)) {
                                                                     Object this$attachments = this.getAttachments();
                                                                     Object other$attachments = other.getAttachments();
                                                                     if (this$attachments == null
                                                                        ? other$attachments == null
                                                                        : this$attachments.equals(other$attachments)) {
                                                                        Object this$remark = this.getRemark();
                                                                        Object other$remark = other.getRemark();
                                                                        if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                           Object this$createTime = this.getCreateTime();
                                                                           Object other$createTime = other.getCreateTime();
                                                                           return this$createTime == null
                                                                              ? other$createTime == null
                                                                              : this$createTime.equals(other$createTime);
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
      return other instanceof ContractRecycleInvoiceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $boolIncludeTax = this.getBoolIncludeTax();
      result = result * 59 + ($boolIncludeTax == null ? 43 : $boolIncludeTax.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $applyUserId = this.getApplyUserId();
      result = result * 59 + ($applyUserId == null ? 43 : $applyUserId.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $receiveInvoiceDate = this.getReceiveInvoiceDate();
      result = result * 59 + ($receiveInvoiceDate == null ? 43 : $receiveInvoiceDate.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $tax = this.getTax();
      result = result * 59 + ($tax == null ? 43 : $tax.hashCode());
      Object $amountExcludingTax = this.getAmountExcludingTax();
      result = result * 59 + ($amountExcludingTax == null ? 43 : $amountExcludingTax.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $invoiceSerialNumber = this.getInvoiceSerialNumber();
      result = result * 59 + ($invoiceSerialNumber == null ? 43 : $invoiceSerialNumber.hashCode());
      Object $applyUserName = this.getApplyUserName();
      result = result * 59 + ($applyUserName == null ? 43 : $applyUserName.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "ContractRecycleInvoiceDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", receiveInvoiceDate="
         + this.getReceiveInvoiceDate()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", boolIncludeTax="
         + this.getBoolIncludeTax()
         + ", taxRate="
         + this.getTaxRate()
         + ", tax="
         + this.getTax()
         + ", amountExcludingTax="
         + this.getAmountExcludingTax()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", invoiceSerialNumber="
         + this.getInvoiceSerialNumber()
         + ", applyUserId="
         + this.getApplyUserId()
         + ", applyUserName="
         + this.getApplyUserName()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachments="
         + this.getAttachments()
         + ", remark="
         + this.getRemark()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public static class ContractRecycleInvoiceDTOBuilder {
      private Long id;
      private ProjectInfo project;
      private LocalDate receiveInvoiceDate;
      private BigDecimal invoiceAmount;
      private Integer invoiceType;
      private Boolean boolIncludeTax;
      private BigDecimal taxRate;
      private BigDecimal tax;
      private BigDecimal amountExcludingTax;
      private Long branchCompanyId;
      private String branchCompanyName;
      private Long supplierId;
      private String supplierName;
      private String invoiceSerialNumber;
      private Long applyUserId;
      private String applyUserName;
      private Long auditUserId;
      private String auditUserName;
      private LocalDateTime auditTime;
      private Integer auditStatus;
      private String attachmentIds;
      private List<AttachmentDTO> attachments;
      private String remark;
      private LocalDateTime createTime;

      ContractRecycleInvoiceDTOBuilder() {
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder receiveInvoiceDate(final LocalDate receiveInvoiceDate) {
         this.receiveInvoiceDate = receiveInvoiceDate;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder boolIncludeTax(final Boolean boolIncludeTax) {
         this.boolIncludeTax = boolIncludeTax;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder tax(final BigDecimal tax) {
         this.tax = tax;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder amountExcludingTax(final BigDecimal amountExcludingTax) {
         this.amountExcludingTax = amountExcludingTax;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder invoiceSerialNumber(final String invoiceSerialNumber) {
         this.invoiceSerialNumber = invoiceSerialNumber;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder applyUserId(final Long applyUserId) {
         this.applyUserId = applyUserId;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder applyUserName(final String applyUserName) {
         this.applyUserName = applyUserName;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ContractRecycleInvoiceDTO build() {
         return new ContractRecycleInvoiceDTO(
            this.id,
            this.project,
            this.receiveInvoiceDate,
            this.invoiceAmount,
            this.invoiceType,
            this.boolIncludeTax,
            this.taxRate,
            this.tax,
            this.amountExcludingTax,
            this.branchCompanyId,
            this.branchCompanyName,
            this.supplierId,
            this.supplierName,
            this.invoiceSerialNumber,
            this.applyUserId,
            this.applyUserName,
            this.auditUserId,
            this.auditUserName,
            this.auditTime,
            this.auditStatus,
            this.attachmentIds,
            this.attachments,
            this.remark,
            this.createTime
         );
      }

      @Override
      public String toString() {
         return "ContractRecycleInvoiceDTO.ContractRecycleInvoiceDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", receiveInvoiceDate="
            + this.receiveInvoiceDate
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", invoiceType="
            + this.invoiceType
            + ", boolIncludeTax="
            + this.boolIncludeTax
            + ", taxRate="
            + this.taxRate
            + ", tax="
            + this.tax
            + ", amountExcludingTax="
            + this.amountExcludingTax
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", invoiceSerialNumber="
            + this.invoiceSerialNumber
            + ", applyUserId="
            + this.applyUserId
            + ", applyUserName="
            + this.applyUserName
            + ", auditUserId="
            + this.auditUserId
            + ", auditUserName="
            + this.auditUserName
            + ", auditTime="
            + this.auditTime
            + ", auditStatus="
            + this.auditStatus
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachments="
            + this.attachments
            + ", remark="
            + this.remark
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
