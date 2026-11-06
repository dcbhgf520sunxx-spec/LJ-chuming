package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("收票列表")
public class SupplierInvoiceDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty("属性 1原材料-采购费 2物流费 4制成品-采购费 8分包费")
   private Integer propertyType;
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
   @ApiModelProperty("购方单位(签订主体名称)")
   private String branchCompanyName;
   @ApiModelProperty("销售单位(供应商)")
   private String supplierName;
   @ApiModelProperty("发票号码")
   private String invoiceSerialNumber;
   @ApiModelProperty("申请人名字")
   private String applyUserName;
   @ApiModelProperty("审核人名字")
   private String auditUserName;
   @ApiModelProperty("审核时间")
   private LocalDateTime auditTime;
   @ApiModelProperty("审核状态 1未审核(审核中、待审核) 2审核通过 4驳回")
   private Integer auditStatus;
   @ApiModelProperty("申请时间")
   private LocalDateTime createTime;
   @ApiModelProperty("附件列表")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty("备注")
   private String remark;

   public SupplierInvoiceDTO() {
   }

   SupplierInvoiceDTO(
      final Long id,
      final Integer propertyType,
      final LocalDate receiveInvoiceDate,
      final BigDecimal invoiceAmount,
      final Integer invoiceType,
      final Boolean boolIncludeTax,
      final BigDecimal taxRate,
      final String branchCompanyName,
      final String supplierName,
      final String invoiceSerialNumber,
      final String applyUserName,
      final String auditUserName,
      final LocalDateTime auditTime,
      final Integer auditStatus,
      final LocalDateTime createTime,
      final List<AttachmentDTO> attachments,
      final String remark
   ) {
      this.id = id;
      this.propertyType = propertyType;
      this.receiveInvoiceDate = receiveInvoiceDate;
      this.invoiceAmount = invoiceAmount;
      this.invoiceType = invoiceType;
      this.boolIncludeTax = boolIncludeTax;
      this.taxRate = taxRate;
      this.branchCompanyName = branchCompanyName;
      this.supplierName = supplierName;
      this.invoiceSerialNumber = invoiceSerialNumber;
      this.applyUserName = applyUserName;
      this.auditUserName = auditUserName;
      this.auditTime = auditTime;
      this.auditStatus = auditStatus;
      this.createTime = createTime;
      this.attachments = attachments;
      this.remark = remark;
   }

   public static SupplierInvoiceDTO.SupplierInvoiceDTOBuilder builder() {
      return new SupplierInvoiceDTO.SupplierInvoiceDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getPropertyType() {
      return this.propertyType;
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

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getInvoiceSerialNumber() {
      return this.invoiceSerialNumber;
   }

   public String getApplyUserName() {
      return this.applyUserName;
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

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPropertyType(final Integer propertyType) {
      this.propertyType = propertyType;
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

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setInvoiceSerialNumber(final String invoiceSerialNumber) {
      this.invoiceSerialNumber = invoiceSerialNumber;
   }

   public void setApplyUserName(final String applyUserName) {
      this.applyUserName = applyUserName;
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

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierInvoiceDTO)) {
         return false;
      }

      SupplierInvoiceDTO other = (SupplierInvoiceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$propertyType = this.getPropertyType();
         Object other$propertyType = other.getPropertyType();
         if (this$propertyType == null ? other$propertyType == null : this$propertyType.equals(other$propertyType)) {
            Object this$invoiceType = this.getInvoiceType();
            Object other$invoiceType = other.getInvoiceType();
            if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
               Object this$boolIncludeTax = this.getBoolIncludeTax();
               Object other$boolIncludeTax = other.getBoolIncludeTax();
               if (this$boolIncludeTax == null ? other$boolIncludeTax == null : this$boolIncludeTax.equals(other$boolIncludeTax)) {
                  Object this$auditStatus = this.getAuditStatus();
                  Object other$auditStatus = other.getAuditStatus();
                  if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                     Object this$receiveInvoiceDate = this.getReceiveInvoiceDate();
                     Object other$receiveInvoiceDate = other.getReceiveInvoiceDate();
                     if (this$receiveInvoiceDate == null ? other$receiveInvoiceDate == null : this$receiveInvoiceDate.equals(other$receiveInvoiceDate)) {
                        Object this$invoiceAmount = this.getInvoiceAmount();
                        Object other$invoiceAmount = other.getInvoiceAmount();
                        if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                           Object this$taxRate = this.getTaxRate();
                           Object other$taxRate = other.getTaxRate();
                           if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                              Object this$branchCompanyName = this.getBranchCompanyName();
                              Object other$branchCompanyName = other.getBranchCompanyName();
                              if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
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
                                       if (this$applyUserName == null ? other$applyUserName == null : this$applyUserName.equals(other$applyUserName)) {
                                          Object this$auditUserName = this.getAuditUserName();
                                          Object other$auditUserName = other.getAuditUserName();
                                          if (this$auditUserName == null ? other$auditUserName == null : this$auditUserName.equals(other$auditUserName)) {
                                             Object this$auditTime = this.getAuditTime();
                                             Object other$auditTime = other.getAuditTime();
                                             if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
                                                Object this$createTime = this.getCreateTime();
                                                Object other$createTime = other.getCreateTime();
                                                if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                   Object this$attachments = this.getAttachments();
                                                   Object other$attachments = other.getAttachments();
                                                   if (this$attachments == null ? other$attachments == null : this$attachments.equals(other$attachments)) {
                                                      Object this$remark = this.getRemark();
                                                      Object other$remark = other.getRemark();
                                                      return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof SupplierInvoiceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $propertyType = this.getPropertyType();
      result = result * 59 + ($propertyType == null ? 43 : $propertyType.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $boolIncludeTax = this.getBoolIncludeTax();
      result = result * 59 + ($boolIncludeTax == null ? 43 : $boolIncludeTax.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $receiveInvoiceDate = this.getReceiveInvoiceDate();
      result = result * 59 + ($receiveInvoiceDate == null ? 43 : $receiveInvoiceDate.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
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
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierInvoiceDTO(id="
         + this.getId()
         + ", propertyType="
         + this.getPropertyType()
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
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", supplierName="
         + this.getSupplierName()
         + ", invoiceSerialNumber="
         + this.getInvoiceSerialNumber()
         + ", applyUserName="
         + this.getApplyUserName()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", createTime="
         + this.getCreateTime()
         + ", attachments="
         + this.getAttachments()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class SupplierInvoiceDTOBuilder {
      private Long id;
      private Integer propertyType;
      private LocalDate receiveInvoiceDate;
      private BigDecimal invoiceAmount;
      private Integer invoiceType;
      private Boolean boolIncludeTax;
      private BigDecimal taxRate;
      private String branchCompanyName;
      private String supplierName;
      private String invoiceSerialNumber;
      private String applyUserName;
      private String auditUserName;
      private LocalDateTime auditTime;
      private Integer auditStatus;
      private LocalDateTime createTime;
      private List<AttachmentDTO> attachments;
      private String remark;

      SupplierInvoiceDTOBuilder() {
      }

      public SupplierInvoiceDTO.SupplierInvoiceDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SupplierInvoiceDTO.SupplierInvoiceDTOBuilder propertyType(final Integer propertyType) {
         this.propertyType = propertyType;
         return this;
      }

      public SupplierInvoiceDTO.SupplierInvoiceDTOBuilder receiveInvoiceDate(final LocalDate receiveInvoiceDate) {
         this.receiveInvoiceDate = receiveInvoiceDate;
         return this;
      }

      public SupplierInvoiceDTO.SupplierInvoiceDTOBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public SupplierInvoiceDTO.SupplierInvoiceDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public SupplierInvoiceDTO.SupplierInvoiceDTOBuilder boolIncludeTax(final Boolean boolIncludeTax) {
         this.boolIncludeTax = boolIncludeTax;
         return this;
      }

      public SupplierInvoiceDTO.SupplierInvoiceDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public SupplierInvoiceDTO.SupplierInvoiceDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public SupplierInvoiceDTO.SupplierInvoiceDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SupplierInvoiceDTO.SupplierInvoiceDTOBuilder invoiceSerialNumber(final String invoiceSerialNumber) {
         this.invoiceSerialNumber = invoiceSerialNumber;
         return this;
      }

      public SupplierInvoiceDTO.SupplierInvoiceDTOBuilder applyUserName(final String applyUserName) {
         this.applyUserName = applyUserName;
         return this;
      }

      public SupplierInvoiceDTO.SupplierInvoiceDTOBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public SupplierInvoiceDTO.SupplierInvoiceDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public SupplierInvoiceDTO.SupplierInvoiceDTOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public SupplierInvoiceDTO.SupplierInvoiceDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public SupplierInvoiceDTO.SupplierInvoiceDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public SupplierInvoiceDTO.SupplierInvoiceDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SupplierInvoiceDTO build() {
         return new SupplierInvoiceDTO(
            this.id,
            this.propertyType,
            this.receiveInvoiceDate,
            this.invoiceAmount,
            this.invoiceType,
            this.boolIncludeTax,
            this.taxRate,
            this.branchCompanyName,
            this.supplierName,
            this.invoiceSerialNumber,
            this.applyUserName,
            this.auditUserName,
            this.auditTime,
            this.auditStatus,
            this.createTime,
            this.attachments,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "SupplierInvoiceDTO.SupplierInvoiceDTOBuilder(id="
            + this.id
            + ", propertyType="
            + this.propertyType
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
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", supplierName="
            + this.supplierName
            + ", invoiceSerialNumber="
            + this.invoiceSerialNumber
            + ", applyUserName="
            + this.applyUserName
            + ", auditUserName="
            + this.auditUserName
            + ", auditTime="
            + this.auditTime
            + ", auditStatus="
            + this.auditStatus
            + ", createTime="
            + this.createTime
            + ", attachments="
            + this.attachments
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
