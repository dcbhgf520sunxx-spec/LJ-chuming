package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("发票")
public class ContractInvoiceDTO {
   @ApiModelProperty(name = "id", value = "主键id")
   private Long id;
   @ApiModelProperty(name = "type", value = "开票类型 1项目开票 2废料出售开票")
   private Integer type;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "project", value = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "contractWasteId", value = "废料合同id")
   private Long contractWasteId;
   @ApiModelProperty(name = "contractWaste", value = "废料合同信息")
   private ContractWasteInfo contractWaste;
   @ApiModelProperty(name = "businessType", value = "项目业务类型")
   private Integer businessType;
   @ApiModelProperty(name = "contract_amount", notes = "合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "invoiceAmount", value = "发票面额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty(name = "invoiceUnitId", value = "开票单位id")
   private String invoiceUnitId;
   @ApiModelProperty(name = "invoiceUnit", value = "开票单位")
   private String invoiceUnit;
   @ApiModelProperty(name = "collectionUnit", value = "收票单位")
   private String collectionUnit;
   @ApiModelProperty(name = "invoiceDate", value = "开票日期")
   private LocalDateTime invoiceDate;
   @ApiModelProperty(name = "invoiceNo", value = "发票号码")
   private String invoiceNo;
   @ApiModelProperty(name = "invoiceContent", value = "发票内容")
   private String invoiceContent;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 1增值专用票 2增值普发票 4收据")
   private Integer invoiceType;
   @ApiModelProperty(name = "boolIncludeTax", value = "是否含税 true含税 false免税")
   private Boolean boolIncludeTax;
   @ApiModelProperty(name = "tax", value = "税额")
   private BigDecimal tax;
   @ApiModelProperty(name = "taxRate", value = "税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "amountExcludingTax", value = "不含税金额")
   private BigDecimal amountExcludingTax;
   @ApiModelProperty(name = "writtenById", value = "填报人id")
   private Long writtenById;
   @ApiModelProperty(name = "writtenByName", value = "填报人姓名")
   private String writtenByName;
   @ApiModelProperty(name = "createTime", value = "填报时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1审核中 2审核通过 4已驳回")
   private Integer auditStatus;
   @ApiModelProperty(name = "auditorId", value = "审核人id")
   private Long auditorId;
   @ApiModelProperty(name = "auditorName", value = "审核人名字")
   private String auditorName;
   @ApiModelProperty(name = "auditTime", value = "审核时间")
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "lastEditorUserId", value = "最后编辑人id")
   private Long lastEditorUserId;
   @ApiModelProperty(name = "lastEditorUserName", value = "最后编辑人名字")
   private Long lastEditorUserName;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "attachments", value = "附件id字符串")
   private String attachments;
   @ApiModelProperty(name = "attachmentList", value = "附件列表")
   private List<AttachmentDTO> attachmentList;

   public static ContractInvoiceDTO.ContractInvoiceDTOBuilder builder() {
      return new ContractInvoiceDTO.ContractInvoiceDTOBuilder();
   }

   public ContractInvoiceDTO() {
   }

   public ContractInvoiceDTO(
      final Long id,
      final Integer type,
      final Long projectId,
      final ProjectInfo project,
      final Long contractWasteId,
      final ContractWasteInfo contractWaste,
      final Integer businessType,
      final BigDecimal contractAmount,
      final BigDecimal invoiceAmount,
      final String invoiceUnitId,
      final String invoiceUnit,
      final String collectionUnit,
      final LocalDateTime invoiceDate,
      final String invoiceNo,
      final String invoiceContent,
      final Integer invoiceType,
      final Boolean boolIncludeTax,
      final BigDecimal tax,
      final BigDecimal taxRate,
      final BigDecimal amountExcludingTax,
      final Long writtenById,
      final String writtenByName,
      final LocalDateTime createTime,
      final Integer auditStatus,
      final Long auditorId,
      final String auditorName,
      final LocalDateTime auditTime,
      final Long lastEditorUserId,
      final Long lastEditorUserName,
      final String remark,
      final String attachments,
      final List<AttachmentDTO> attachmentList
   ) {
      this.id = id;
      this.type = type;
      this.projectId = projectId;
      this.project = project;
      this.contractWasteId = contractWasteId;
      this.contractWaste = contractWaste;
      this.businessType = businessType;
      this.contractAmount = contractAmount;
      this.invoiceAmount = invoiceAmount;
      this.invoiceUnitId = invoiceUnitId;
      this.invoiceUnit = invoiceUnit;
      this.collectionUnit = collectionUnit;
      this.invoiceDate = invoiceDate;
      this.invoiceNo = invoiceNo;
      this.invoiceContent = invoiceContent;
      this.invoiceType = invoiceType;
      this.boolIncludeTax = boolIncludeTax;
      this.tax = tax;
      this.taxRate = taxRate;
      this.amountExcludingTax = amountExcludingTax;
      this.writtenById = writtenById;
      this.writtenByName = writtenByName;
      this.createTime = createTime;
      this.auditStatus = auditStatus;
      this.auditorId = auditorId;
      this.auditorName = auditorName;
      this.auditTime = auditTime;
      this.lastEditorUserId = lastEditorUserId;
      this.lastEditorUserName = lastEditorUserName;
      this.remark = remark;
      this.attachments = attachments;
      this.attachmentList = attachmentList;
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

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getContractWasteId() {
      return this.contractWasteId;
   }

   public ContractWasteInfo getContractWaste() {
      return this.contractWaste;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public String getInvoiceUnitId() {
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

   public String getInvoiceContent() {
      return this.invoiceContent;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Boolean getBoolIncludeTax() {
      return this.boolIncludeTax;
   }

   public BigDecimal getTax() {
      return this.tax;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getAmountExcludingTax() {
      return this.amountExcludingTax;
   }

   public Long getWrittenById() {
      return this.writtenById;
   }

   public String getWrittenByName() {
      return this.writtenByName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
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

   public Long getLastEditorUserName() {
      return this.lastEditorUserName;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getAttachments() {
      return this.attachments;
   }

   public List<AttachmentDTO> getAttachmentList() {
      return this.attachmentList;
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

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setContractWasteId(final Long contractWasteId) {
      this.contractWasteId = contractWasteId;
   }

   public void setContractWaste(final ContractWasteInfo contractWaste) {
      this.contractWaste = contractWaste;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setInvoiceUnitId(final String invoiceUnitId) {
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

   public void setInvoiceContent(final String invoiceContent) {
      this.invoiceContent = invoiceContent;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setBoolIncludeTax(final Boolean boolIncludeTax) {
      this.boolIncludeTax = boolIncludeTax;
   }

   public void setTax(final BigDecimal tax) {
      this.tax = tax;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setAmountExcludingTax(final BigDecimal amountExcludingTax) {
      this.amountExcludingTax = amountExcludingTax;
   }

   public void setWrittenById(final Long writtenById) {
      this.writtenById = writtenById;
   }

   public void setWrittenByName(final String writtenByName) {
      this.writtenByName = writtenByName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
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

   public void setLastEditorUserName(final Long lastEditorUserName) {
      this.lastEditorUserName = lastEditorUserName;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAttachments(final String attachments) {
      this.attachments = attachments;
   }

   public void setAttachmentList(final List<AttachmentDTO> attachmentList) {
      this.attachmentList = attachmentList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractInvoiceDTO)) {
         return false;
      }

      ContractInvoiceDTO other = (ContractInvoiceDTO)o;
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
                  Object this$businessType = this.getBusinessType();
                  Object other$businessType = other.getBusinessType();
                  if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
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
                                       Object this$lastEditorUserName = this.getLastEditorUserName();
                                       Object other$lastEditorUserName = other.getLastEditorUserName();
                                       if (this$lastEditorUserName == null
                                          ? other$lastEditorUserName == null
                                          : this$lastEditorUserName.equals(other$lastEditorUserName)) {
                                          Object this$project = this.getProject();
                                          Object other$project = other.getProject();
                                          if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                             Object this$contractWaste = this.getContractWaste();
                                             Object other$contractWaste = other.getContractWaste();
                                             if (this$contractWaste == null ? other$contractWaste == null : this$contractWaste.equals(other$contractWaste)) {
                                                Object this$contractAmount = this.getContractAmount();
                                                Object other$contractAmount = other.getContractAmount();
                                                if (this$contractAmount == null
                                                   ? other$contractAmount == null
                                                   : this$contractAmount.equals(other$contractAmount)) {
                                                   Object this$invoiceAmount = this.getInvoiceAmount();
                                                   Object other$invoiceAmount = other.getInvoiceAmount();
                                                   if (this$invoiceAmount == null
                                                      ? other$invoiceAmount == null
                                                      : this$invoiceAmount.equals(other$invoiceAmount)) {
                                                      Object this$invoiceUnitId = this.getInvoiceUnitId();
                                                      Object other$invoiceUnitId = other.getInvoiceUnitId();
                                                      if (this$invoiceUnitId == null
                                                         ? other$invoiceUnitId == null
                                                         : this$invoiceUnitId.equals(other$invoiceUnitId)) {
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
                                                               if (this$invoiceDate == null
                                                                  ? other$invoiceDate == null
                                                                  : this$invoiceDate.equals(other$invoiceDate)) {
                                                                  Object this$invoiceNo = this.getInvoiceNo();
                                                                  Object other$invoiceNo = other.getInvoiceNo();
                                                                  if (this$invoiceNo == null ? other$invoiceNo == null : this$invoiceNo.equals(other$invoiceNo)
                                                                     )
                                                                   {
                                                                     Object this$invoiceContent = this.getInvoiceContent();
                                                                     Object other$invoiceContent = other.getInvoiceContent();
                                                                     if (this$invoiceContent == null
                                                                        ? other$invoiceContent == null
                                                                        : this$invoiceContent.equals(other$invoiceContent)) {
                                                                        Object this$tax = this.getTax();
                                                                        Object other$tax = other.getTax();
                                                                        if (this$tax == null ? other$tax == null : this$tax.equals(other$tax)) {
                                                                           Object this$taxRate = this.getTaxRate();
                                                                           Object other$taxRate = other.getTaxRate();
                                                                           if (this$taxRate == null
                                                                              ? other$taxRate == null
                                                                              : this$taxRate.equals(other$taxRate)) {
                                                                              Object this$amountExcludingTax = this.getAmountExcludingTax();
                                                                              Object other$amountExcludingTax = other.getAmountExcludingTax();
                                                                              if (this$amountExcludingTax == null
                                                                                 ? other$amountExcludingTax == null
                                                                                 : this$amountExcludingTax.equals(other$amountExcludingTax)) {
                                                                                 Object this$writtenByName = this.getWrittenByName();
                                                                                 Object other$writtenByName = other.getWrittenByName();
                                                                                 if (this$writtenByName == null
                                                                                    ? other$writtenByName == null
                                                                                    : this$writtenByName.equals(other$writtenByName)) {
                                                                                    Object this$createTime = this.getCreateTime();
                                                                                    Object other$createTime = other.getCreateTime();
                                                                                    if (this$createTime == null
                                                                                       ? other$createTime == null
                                                                                       : this$createTime.equals(other$createTime)) {
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
                                                                                             if (this$remark == null
                                                                                                ? other$remark == null
                                                                                                : this$remark.equals(other$remark)) {
                                                                                                Object this$attachments = this.getAttachments();
                                                                                                Object other$attachments = other.getAttachments();
                                                                                                if (this$attachments == null
                                                                                                   ? other$attachments == null
                                                                                                   : this$attachments.equals(other$attachments)) {
                                                                                                   Object this$attachmentList = this.getAttachmentList();
                                                                                                   Object other$attachmentList = other.getAttachmentList();
                                                                                                   return this$attachmentList == null
                                                                                                      ? other$attachmentList == null
                                                                                                      : this$attachmentList.equals(other$attachmentList);
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
      return other instanceof ContractInvoiceDTO;
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
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
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
      Object $lastEditorUserName = this.getLastEditorUserName();
      result = result * 59 + ($lastEditorUserName == null ? 43 : $lastEditorUserName.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $contractWaste = this.getContractWaste();
      result = result * 59 + ($contractWaste == null ? 43 : $contractWaste.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $invoiceUnitId = this.getInvoiceUnitId();
      result = result * 59 + ($invoiceUnitId == null ? 43 : $invoiceUnitId.hashCode());
      Object $invoiceUnit = this.getInvoiceUnit();
      result = result * 59 + ($invoiceUnit == null ? 43 : $invoiceUnit.hashCode());
      Object $collectionUnit = this.getCollectionUnit();
      result = result * 59 + ($collectionUnit == null ? 43 : $collectionUnit.hashCode());
      Object $invoiceDate = this.getInvoiceDate();
      result = result * 59 + ($invoiceDate == null ? 43 : $invoiceDate.hashCode());
      Object $invoiceNo = this.getInvoiceNo();
      result = result * 59 + ($invoiceNo == null ? 43 : $invoiceNo.hashCode());
      Object $invoiceContent = this.getInvoiceContent();
      result = result * 59 + ($invoiceContent == null ? 43 : $invoiceContent.hashCode());
      Object $tax = this.getTax();
      result = result * 59 + ($tax == null ? 43 : $tax.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $amountExcludingTax = this.getAmountExcludingTax();
      result = result * 59 + ($amountExcludingTax == null ? 43 : $amountExcludingTax.hashCode());
      Object $writtenByName = this.getWrittenByName();
      result = result * 59 + ($writtenByName == null ? 43 : $writtenByName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $auditorName = this.getAuditorName();
      result = result * 59 + ($auditorName == null ? 43 : $auditorName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $attachmentList = this.getAttachmentList();
      return result * 59 + ($attachmentList == null ? 43 : $attachmentList.hashCode());
   }

   @Override
   public String toString() {
      return "ContractInvoiceDTO(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", projectId="
         + this.getProjectId()
         + ", project="
         + this.getProject()
         + ", contractWasteId="
         + this.getContractWasteId()
         + ", contractWaste="
         + this.getContractWaste()
         + ", businessType="
         + this.getBusinessType()
         + ", contractAmount="
         + this.getContractAmount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
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
         + ", invoiceContent="
         + this.getInvoiceContent()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", boolIncludeTax="
         + this.getBoolIncludeTax()
         + ", tax="
         + this.getTax()
         + ", taxRate="
         + this.getTaxRate()
         + ", amountExcludingTax="
         + this.getAmountExcludingTax()
         + ", writtenById="
         + this.getWrittenById()
         + ", writtenByName="
         + this.getWrittenByName()
         + ", createTime="
         + this.getCreateTime()
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
         + ", lastEditorUserName="
         + this.getLastEditorUserName()
         + ", remark="
         + this.getRemark()
         + ", attachments="
         + this.getAttachments()
         + ", attachmentList="
         + this.getAttachmentList()
         + ")";
   }

   public static class ContractInvoiceDTOBuilder {
      private Long id;
      private Integer type;
      private Long projectId;
      private ProjectInfo project;
      private Long contractWasteId;
      private ContractWasteInfo contractWaste;
      private Integer businessType;
      private BigDecimal contractAmount;
      private BigDecimal invoiceAmount;
      private String invoiceUnitId;
      private String invoiceUnit;
      private String collectionUnit;
      private LocalDateTime invoiceDate;
      private String invoiceNo;
      private String invoiceContent;
      private Integer invoiceType;
      private Boolean boolIncludeTax;
      private BigDecimal tax;
      private BigDecimal taxRate;
      private BigDecimal amountExcludingTax;
      private Long writtenById;
      private String writtenByName;
      private LocalDateTime createTime;
      private Integer auditStatus;
      private Long auditorId;
      private String auditorName;
      private LocalDateTime auditTime;
      private Long lastEditorUserId;
      private Long lastEditorUserName;
      private String remark;
      private String attachments;
      private List<AttachmentDTO> attachmentList;

      ContractInvoiceDTOBuilder() {
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder contractWasteId(final Long contractWasteId) {
         this.contractWasteId = contractWasteId;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder contractWaste(final ContractWasteInfo contractWaste) {
         this.contractWaste = contractWaste;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder businessType(final Integer businessType) {
         this.businessType = businessType;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder invoiceUnitId(final String invoiceUnitId) {
         this.invoiceUnitId = invoiceUnitId;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder invoiceUnit(final String invoiceUnit) {
         this.invoiceUnit = invoiceUnit;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder collectionUnit(final String collectionUnit) {
         this.collectionUnit = collectionUnit;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder invoiceDate(final LocalDateTime invoiceDate) {
         this.invoiceDate = invoiceDate;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder invoiceNo(final String invoiceNo) {
         this.invoiceNo = invoiceNo;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder invoiceContent(final String invoiceContent) {
         this.invoiceContent = invoiceContent;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder boolIncludeTax(final Boolean boolIncludeTax) {
         this.boolIncludeTax = boolIncludeTax;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder tax(final BigDecimal tax) {
         this.tax = tax;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder amountExcludingTax(final BigDecimal amountExcludingTax) {
         this.amountExcludingTax = amountExcludingTax;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder writtenById(final Long writtenById) {
         this.writtenById = writtenById;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder writtenByName(final String writtenByName) {
         this.writtenByName = writtenByName;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder auditorId(final Long auditorId) {
         this.auditorId = auditorId;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder auditorName(final String auditorName) {
         this.auditorName = auditorName;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder lastEditorUserId(final Long lastEditorUserId) {
         this.lastEditorUserId = lastEditorUserId;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder lastEditorUserName(final Long lastEditorUserName) {
         this.lastEditorUserName = lastEditorUserName;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder attachments(final String attachments) {
         this.attachments = attachments;
         return this;
      }

      public ContractInvoiceDTO.ContractInvoiceDTOBuilder attachmentList(final List<AttachmentDTO> attachmentList) {
         this.attachmentList = attachmentList;
         return this;
      }

      public ContractInvoiceDTO build() {
         return new ContractInvoiceDTO(
            this.id,
            this.type,
            this.projectId,
            this.project,
            this.contractWasteId,
            this.contractWaste,
            this.businessType,
            this.contractAmount,
            this.invoiceAmount,
            this.invoiceUnitId,
            this.invoiceUnit,
            this.collectionUnit,
            this.invoiceDate,
            this.invoiceNo,
            this.invoiceContent,
            this.invoiceType,
            this.boolIncludeTax,
            this.tax,
            this.taxRate,
            this.amountExcludingTax,
            this.writtenById,
            this.writtenByName,
            this.createTime,
            this.auditStatus,
            this.auditorId,
            this.auditorName,
            this.auditTime,
            this.lastEditorUserId,
            this.lastEditorUserName,
            this.remark,
            this.attachments,
            this.attachmentList
         );
      }

      @Override
      public String toString() {
         return "ContractInvoiceDTO.ContractInvoiceDTOBuilder(id="
            + this.id
            + ", type="
            + this.type
            + ", projectId="
            + this.projectId
            + ", project="
            + this.project
            + ", contractWasteId="
            + this.contractWasteId
            + ", contractWaste="
            + this.contractWaste
            + ", businessType="
            + this.businessType
            + ", contractAmount="
            + this.contractAmount
            + ", invoiceAmount="
            + this.invoiceAmount
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
            + ", invoiceContent="
            + this.invoiceContent
            + ", invoiceType="
            + this.invoiceType
            + ", boolIncludeTax="
            + this.boolIncludeTax
            + ", tax="
            + this.tax
            + ", taxRate="
            + this.taxRate
            + ", amountExcludingTax="
            + this.amountExcludingTax
            + ", writtenById="
            + this.writtenById
            + ", writtenByName="
            + this.writtenByName
            + ", createTime="
            + this.createTime
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
            + ", lastEditorUserName="
            + this.lastEditorUserName
            + ", remark="
            + this.remark
            + ", attachments="
            + this.attachments
            + ", attachmentList="
            + this.attachmentList
            + ")";
      }
   }
}
