package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "ContractInvoice对象", description = "合同发票")
public class ContractInvoiceV2DTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   private Long id;
   @ApiModelProperty(name = "type", value = "开票类型 1项目开票 2废料开票 CreateInvoiceTypeEnum")
   private Integer type;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "contractWasteId", value = "废料合同id")
   private Long contractWasteId;
   @ApiModelProperty(name = "invoiceAmount", value = "发票面额(元)")
   private BigDecimal invoiceAmount;
   @ApiModelProperty(name = "actualInvoiceAmount", value = "实开发票面额(元)")
   private BigDecimal actualInvoiceAmount;
   @ApiModelProperty(name = "invoiceUnitId", value = "开票单位id")
   private Long invoiceUnitId;
   @ApiModelProperty(name = "invoiceUnit", value = "开票单位")
   private String invoiceUnit;
   @ApiModelProperty(name = "collectionUnit", value = "收票单位(客户单位)")
   private String collectionUnit;
   @ApiModelProperty(name = "invoiceDate", value = "开票日期")
   private LocalDateTime invoiceDate;
   @ApiModelProperty(name = "invoiceNo", value = "发票号码")
   private String invoiceNo;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 1增值专用票 2增值普发票 4收据")
   private Integer invoiceType;
   @ApiModelProperty(name = "tax", value = "税额")
   private BigDecimal tax;
   @ApiModelProperty(name = "boolIncludeTax", value = "是否含税 true含税 false免税")
   private Boolean boolIncludeTax;
   @ApiModelProperty(name = "taxRateTypeValue", value = "字典配置税率value值")
   private String taxRateTypeValue;
   @ApiModelProperty(name = "taxRate", value = "税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "invoiceContent", value = "发票内容")
   private String invoiceContent;
   @ApiModelProperty(name = "writtenById", value = "填报人id")
   private Long writtenById;
   @ApiModelProperty(name = "writtenByName", value = "填报人姓名")
   private String writtenByName;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1审核中 2审核通过4已驳回")
   private Integer auditStatus;
   @ApiModelProperty(name = "auditorId", value = "审核人id")
   private Long auditorId;
   @ApiModelProperty(name = "auditorName", value = "审核人名字")
   private String auditorName;
   @ApiModelProperty(name = "auditTime", value = "审核时间")
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "lastEditorUserId", value = "最后编辑人id")
   private Long lastEditorUserId;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "attachments", value = "附件列表")
   private List<AttachmentDTO> attachments;

   public static ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder builder() {
      return new ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder();
   }

   public ContractInvoiceV2DTO() {
   }

   public ContractInvoiceV2DTO(
      final Long id,
      final Integer type,
      final Long projectId,
      final Long contractWasteId,
      final BigDecimal invoiceAmount,
      final BigDecimal actualInvoiceAmount,
      final Long invoiceUnitId,
      final String invoiceUnit,
      final String collectionUnit,
      final LocalDateTime invoiceDate,
      final String invoiceNo,
      final Integer invoiceType,
      final BigDecimal tax,
      final Boolean boolIncludeTax,
      final String taxRateTypeValue,
      final BigDecimal taxRate,
      final String invoiceContent,
      final Long writtenById,
      final String writtenByName,
      final Integer auditStatus,
      final Long auditorId,
      final String auditorName,
      final LocalDateTime auditTime,
      final Long lastEditorUserId,
      final String remark,
      final List<AttachmentDTO> attachments
   ) {
      this.id = id;
      this.type = type;
      this.projectId = projectId;
      this.contractWasteId = contractWasteId;
      this.invoiceAmount = invoiceAmount;
      this.actualInvoiceAmount = actualInvoiceAmount;
      this.invoiceUnitId = invoiceUnitId;
      this.invoiceUnit = invoiceUnit;
      this.collectionUnit = collectionUnit;
      this.invoiceDate = invoiceDate;
      this.invoiceNo = invoiceNo;
      this.invoiceType = invoiceType;
      this.tax = tax;
      this.boolIncludeTax = boolIncludeTax;
      this.taxRateTypeValue = taxRateTypeValue;
      this.taxRate = taxRate;
      this.invoiceContent = invoiceContent;
      this.writtenById = writtenById;
      this.writtenByName = writtenByName;
      this.auditStatus = auditStatus;
      this.auditorId = auditorId;
      this.auditorName = auditorName;
      this.auditTime = auditTime;
      this.lastEditorUserId = lastEditorUserId;
      this.remark = remark;
      this.attachments = attachments;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getType() {
      return this.type;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getContractWasteId() {
      return this.contractWasteId;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getActualInvoiceAmount() {
      return this.actualInvoiceAmount;
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

   public LocalDateTime getInvoiceDate() {
      return this.invoiceDate;
   }

   public String getInvoiceNo() {
      return this.invoiceNo;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTax() {
      return this.tax;
   }

   public Boolean getBoolIncludeTax() {
      return this.boolIncludeTax;
   }

   public String getTaxRateTypeValue() {
      return this.taxRateTypeValue;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public String getInvoiceContent() {
      return this.invoiceContent;
   }

   public Long getWrittenById() {
      return this.writtenById;
   }

   public String getWrittenByName() {
      return this.writtenByName;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public Long getAuditorId() {
      return this.auditorId;
   }

   public String getAuditorName() {
      return this.auditorName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Long getLastEditorUserId() {
      return this.lastEditorUserId;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setContractWasteId(final Long contractWasteId) {
      this.contractWasteId = contractWasteId;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setActualInvoiceAmount(final BigDecimal actualInvoiceAmount) {
      this.actualInvoiceAmount = actualInvoiceAmount;
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

   public void setInvoiceDate(final LocalDateTime invoiceDate) {
      this.invoiceDate = invoiceDate;
   }

   public void setInvoiceNo(final String invoiceNo) {
      this.invoiceNo = invoiceNo;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTax(final BigDecimal tax) {
      this.tax = tax;
   }

   public void setBoolIncludeTax(final Boolean boolIncludeTax) {
      this.boolIncludeTax = boolIncludeTax;
   }

   public void setTaxRateTypeValue(final String taxRateTypeValue) {
      this.taxRateTypeValue = taxRateTypeValue;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setInvoiceContent(final String invoiceContent) {
      this.invoiceContent = invoiceContent;
   }

   public void setWrittenById(final Long writtenById) {
      this.writtenById = writtenById;
   }

   public void setWrittenByName(final String writtenByName) {
      this.writtenByName = writtenByName;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setAuditorId(final Long auditorId) {
      this.auditorId = auditorId;
   }

   public void setAuditorName(final String auditorName) {
      this.auditorName = auditorName;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setLastEditorUserId(final Long lastEditorUserId) {
      this.lastEditorUserId = lastEditorUserId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractInvoiceV2DTO)) {
         return false;
      }

      ContractInvoiceV2DTO other = (ContractInvoiceV2DTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$contractWasteId = this.getContractWasteId();
               Object other$contractWasteId = other.getContractWasteId();
               if (this$contractWasteId == null ? other$contractWasteId == null : this$contractWasteId.equals(other$contractWasteId)) {
                  Object this$invoiceUnitId = this.getInvoiceUnitId();
                  Object other$invoiceUnitId = other.getInvoiceUnitId();
                  if (this$invoiceUnitId == null ? other$invoiceUnitId == null : this$invoiceUnitId.equals(other$invoiceUnitId)) {
                     Object this$invoiceType = this.getInvoiceType();
                     Object other$invoiceType = other.getInvoiceType();
                     if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                        Object this$boolIncludeTax = this.getBoolIncludeTax();
                        Object other$boolIncludeTax = other.getBoolIncludeTax();
                        if (this$boolIncludeTax == null ? other$boolIncludeTax == null : this$boolIncludeTax.equals(other$boolIncludeTax)) {
                           Object this$writtenById = this.getWrittenById();
                           Object other$writtenById = other.getWrittenById();
                           if (this$writtenById == null ? other$writtenById == null : this$writtenById.equals(other$writtenById)) {
                              Object this$auditStatus = this.getAuditStatus();
                              Object other$auditStatus = other.getAuditStatus();
                              if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                 Object this$auditorId = this.getAuditorId();
                                 Object other$auditorId = other.getAuditorId();
                                 if (this$auditorId == null ? other$auditorId == null : this$auditorId.equals(other$auditorId)) {
                                    Object this$lastEditorUserId = this.getLastEditorUserId();
                                    Object other$lastEditorUserId = other.getLastEditorUserId();
                                    if (this$lastEditorUserId == null ? other$lastEditorUserId == null : this$lastEditorUserId.equals(other$lastEditorUserId)) {
                                       Object this$invoiceAmount = this.getInvoiceAmount();
                                       Object other$invoiceAmount = other.getInvoiceAmount();
                                       if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                                          Object this$actualInvoiceAmount = this.getActualInvoiceAmount();
                                          Object other$actualInvoiceAmount = other.getActualInvoiceAmount();
                                          if (this$actualInvoiceAmount == null
                                             ? other$actualInvoiceAmount == null
                                             : this$actualInvoiceAmount.equals(other$actualInvoiceAmount)) {
                                             Object this$invoiceUnit = this.getInvoiceUnit();
                                             Object other$invoiceUnit = other.getInvoiceUnit();
                                             if (this$invoiceUnit == null ? other$invoiceUnit == null : this$invoiceUnit.equals(other$invoiceUnit)) {
                                                Object this$collectionUnit = this.getCollectionUnit();
                                                Object other$collectionUnit = other.getCollectionUnit();
                                                if (this$collectionUnit == null
                                                   ? other$collectionUnit == null
                                                   : this$collectionUnit.equals(other$collectionUnit)) {
                                                   Object this$invoiceDate = this.getInvoiceDate();
                                                   Object other$invoiceDate = other.getInvoiceDate();
                                                   if (this$invoiceDate == null ? other$invoiceDate == null : this$invoiceDate.equals(other$invoiceDate)) {
                                                      Object this$invoiceNo = this.getInvoiceNo();
                                                      Object other$invoiceNo = other.getInvoiceNo();
                                                      if (this$invoiceNo == null ? other$invoiceNo == null : this$invoiceNo.equals(other$invoiceNo)) {
                                                         Object this$tax = this.getTax();
                                                         Object other$tax = other.getTax();
                                                         if (this$tax == null ? other$tax == null : this$tax.equals(other$tax)) {
                                                            Object this$taxRateTypeValue = this.getTaxRateTypeValue();
                                                            Object other$taxRateTypeValue = other.getTaxRateTypeValue();
                                                            if (this$taxRateTypeValue == null
                                                               ? other$taxRateTypeValue == null
                                                               : this$taxRateTypeValue.equals(other$taxRateTypeValue)) {
                                                               Object this$taxRate = this.getTaxRate();
                                                               Object other$taxRate = other.getTaxRate();
                                                               if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                                  Object this$invoiceContent = this.getInvoiceContent();
                                                                  Object other$invoiceContent = other.getInvoiceContent();
                                                                  if (this$invoiceContent == null
                                                                     ? other$invoiceContent == null
                                                                     : this$invoiceContent.equals(other$invoiceContent)) {
                                                                     Object this$writtenByName = this.getWrittenByName();
                                                                     Object other$writtenByName = other.getWrittenByName();
                                                                     if (this$writtenByName == null
                                                                        ? other$writtenByName == null
                                                                        : this$writtenByName.equals(other$writtenByName)) {
                                                                        Object this$auditorName = this.getAuditorName();
                                                                        Object other$auditorName = other.getAuditorName();
                                                                        if (this$auditorName == null
                                                                           ? other$auditorName == null
                                                                           : this$auditorName.equals(other$auditorName)) {
                                                                           Object this$auditTime = this.getAuditTime();
                                                                           Object other$auditTime = other.getAuditTime();
                                                                           if (this$auditTime == null
                                                                              ? other$auditTime == null
                                                                              : this$auditTime.equals(other$auditTime)) {
                                                                              Object this$remark = this.getRemark();
                                                                              Object other$remark = other.getRemark();
                                                                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)
                                                                                 )
                                                                               {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractInvoiceV2DTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $invoiceUnitId = this.getInvoiceUnitId();
      result = result * 59 + ($invoiceUnitId == null ? 43 : $invoiceUnitId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $boolIncludeTax = this.getBoolIncludeTax();
      result = result * 59 + ($boolIncludeTax == null ? 43 : $boolIncludeTax.hashCode());
      Object $writtenById = this.getWrittenById();
      result = result * 59 + ($writtenById == null ? 43 : $writtenById.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $auditorId = this.getAuditorId();
      result = result * 59 + ($auditorId == null ? 43 : $auditorId.hashCode());
      Object $lastEditorUserId = this.getLastEditorUserId();
      result = result * 59 + ($lastEditorUserId == null ? 43 : $lastEditorUserId.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $actualInvoiceAmount = this.getActualInvoiceAmount();
      result = result * 59 + ($actualInvoiceAmount == null ? 43 : $actualInvoiceAmount.hashCode());
      Object $invoiceUnit = this.getInvoiceUnit();
      result = result * 59 + ($invoiceUnit == null ? 43 : $invoiceUnit.hashCode());
      Object $collectionUnit = this.getCollectionUnit();
      result = result * 59 + ($collectionUnit == null ? 43 : $collectionUnit.hashCode());
      Object $invoiceDate = this.getInvoiceDate();
      result = result * 59 + ($invoiceDate == null ? 43 : $invoiceDate.hashCode());
      Object $invoiceNo = this.getInvoiceNo();
      result = result * 59 + ($invoiceNo == null ? 43 : $invoiceNo.hashCode());
      Object $tax = this.getTax();
      result = result * 59 + ($tax == null ? 43 : $tax.hashCode());
      Object $taxRateTypeValue = this.getTaxRateTypeValue();
      result = result * 59 + ($taxRateTypeValue == null ? 43 : $taxRateTypeValue.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $invoiceContent = this.getInvoiceContent();
      result = result * 59 + ($invoiceContent == null ? 43 : $invoiceContent.hashCode());
      Object $writtenByName = this.getWrittenByName();
      result = result * 59 + ($writtenByName == null ? 43 : $writtenByName.hashCode());
      Object $auditorName = this.getAuditorName();
      result = result * 59 + ($auditorName == null ? 43 : $auditorName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachments = this.getAttachments();
      return result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
   }

   @Override
   public String toString() {
      return "ContractInvoiceV2DTO(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", projectId="
         + this.getProjectId()
         + ", contractWasteId="
         + this.getContractWasteId()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", actualInvoiceAmount="
         + this.getActualInvoiceAmount()
         + ", invoiceUnitId="
         + this.getInvoiceUnitId()
         + ", invoiceUnit="
         + this.getInvoiceUnit()
         + ", collectionUnit="
         + this.getCollectionUnit()
         + ", invoiceDate="
         + this.getInvoiceDate()
         + ", invoiceNo="
         + this.getInvoiceNo()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", tax="
         + this.getTax()
         + ", boolIncludeTax="
         + this.getBoolIncludeTax()
         + ", taxRateTypeValue="
         + this.getTaxRateTypeValue()
         + ", taxRate="
         + this.getTaxRate()
         + ", invoiceContent="
         + this.getInvoiceContent()
         + ", writtenById="
         + this.getWrittenById()
         + ", writtenByName="
         + this.getWrittenByName()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", auditorId="
         + this.getAuditorId()
         + ", auditorName="
         + this.getAuditorName()
         + ", auditTime="
         + this.getAuditTime()
         + ", lastEditorUserId="
         + this.getLastEditorUserId()
         + ", remark="
         + this.getRemark()
         + ", attachments="
         + this.getAttachments()
         + ")";
   }

   public static class ContractInvoiceV2DTOBuilder {
      private Long id;
      private Integer type;
      private Long projectId;
      private Long contractWasteId;
      private BigDecimal invoiceAmount;
      private BigDecimal actualInvoiceAmount;
      private Long invoiceUnitId;
      private String invoiceUnit;
      private String collectionUnit;
      private LocalDateTime invoiceDate;
      private String invoiceNo;
      private Integer invoiceType;
      private BigDecimal tax;
      private Boolean boolIncludeTax;
      private String taxRateTypeValue;
      private BigDecimal taxRate;
      private String invoiceContent;
      private Long writtenById;
      private String writtenByName;
      private Integer auditStatus;
      private Long auditorId;
      private String auditorName;
      private LocalDateTime auditTime;
      private Long lastEditorUserId;
      private String remark;
      private List<AttachmentDTO> attachments;

      ContractInvoiceV2DTOBuilder() {
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder contractWasteId(final Long contractWasteId) {
         this.contractWasteId = contractWasteId;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder actualInvoiceAmount(final BigDecimal actualInvoiceAmount) {
         this.actualInvoiceAmount = actualInvoiceAmount;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder invoiceUnitId(final Long invoiceUnitId) {
         this.invoiceUnitId = invoiceUnitId;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder invoiceUnit(final String invoiceUnit) {
         this.invoiceUnit = invoiceUnit;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder collectionUnit(final String collectionUnit) {
         this.collectionUnit = collectionUnit;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder invoiceDate(final LocalDateTime invoiceDate) {
         this.invoiceDate = invoiceDate;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder invoiceNo(final String invoiceNo) {
         this.invoiceNo = invoiceNo;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder tax(final BigDecimal tax) {
         this.tax = tax;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder boolIncludeTax(final Boolean boolIncludeTax) {
         this.boolIncludeTax = boolIncludeTax;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder taxRateTypeValue(final String taxRateTypeValue) {
         this.taxRateTypeValue = taxRateTypeValue;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder invoiceContent(final String invoiceContent) {
         this.invoiceContent = invoiceContent;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder writtenById(final Long writtenById) {
         this.writtenById = writtenById;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder writtenByName(final String writtenByName) {
         this.writtenByName = writtenByName;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder auditorId(final Long auditorId) {
         this.auditorId = auditorId;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder auditorName(final String auditorName) {
         this.auditorName = auditorName;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder lastEditorUserId(final Long lastEditorUserId) {
         this.lastEditorUserId = lastEditorUserId;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public ContractInvoiceV2DTO build() {
         return new ContractInvoiceV2DTO(
            this.id,
            this.type,
            this.projectId,
            this.contractWasteId,
            this.invoiceAmount,
            this.actualInvoiceAmount,
            this.invoiceUnitId,
            this.invoiceUnit,
            this.collectionUnit,
            this.invoiceDate,
            this.invoiceNo,
            this.invoiceType,
            this.tax,
            this.boolIncludeTax,
            this.taxRateTypeValue,
            this.taxRate,
            this.invoiceContent,
            this.writtenById,
            this.writtenByName,
            this.auditStatus,
            this.auditorId,
            this.auditorName,
            this.auditTime,
            this.lastEditorUserId,
            this.remark,
            this.attachments
         );
      }

      @Override
      public String toString() {
         return "ContractInvoiceV2DTO.ContractInvoiceV2DTOBuilder(id="
            + this.id
            + ", type="
            + this.type
            + ", projectId="
            + this.projectId
            + ", contractWasteId="
            + this.contractWasteId
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", actualInvoiceAmount="
            + this.actualInvoiceAmount
            + ", invoiceUnitId="
            + this.invoiceUnitId
            + ", invoiceUnit="
            + this.invoiceUnit
            + ", collectionUnit="
            + this.collectionUnit
            + ", invoiceDate="
            + this.invoiceDate
            + ", invoiceNo="
            + this.invoiceNo
            + ", invoiceType="
            + this.invoiceType
            + ", tax="
            + this.tax
            + ", boolIncludeTax="
            + this.boolIncludeTax
            + ", taxRateTypeValue="
            + this.taxRateTypeValue
            + ", taxRate="
            + this.taxRate
            + ", invoiceContent="
            + this.invoiceContent
            + ", writtenById="
            + this.writtenById
            + ", writtenByName="
            + this.writtenByName
            + ", auditStatus="
            + this.auditStatus
            + ", auditorId="
            + this.auditorId
            + ", auditorName="
            + this.auditorName
            + ", auditTime="
            + this.auditTime
            + ", lastEditorUserId="
            + this.lastEditorUserId
            + ", remark="
            + this.remark
            + ", attachments="
            + this.attachments
            + ")";
      }
   }
}
