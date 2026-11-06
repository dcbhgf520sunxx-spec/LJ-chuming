package com.hzchum.scim.scm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveFlowDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ApiModel(value = "SubcontractOrderTemp对象", description = "分包订单表-临时表 ")
public class SubcontractOrderTempDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(
      name = "changeTypeEnum",
      value = "分包订单-变更类型 SubOrderChangeTypeEnum 1.新增 2.修改 4.删除",
      notes = "分包订单-变更类型 SubOrderChangeTypeEnum 1.新增 2.修改 4.删除"
   )
   private Integer changeTypeEnum;
   @ApiModelProperty(name = "orderId", value = "分包订单id", notes = "分包订单id")
   private Long orderId;
   @ApiModelProperty(name = "serialNumber", value = "订单编号", notes = "订单编号")
   private String serialNumber;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "projectAttribute", value = "项目属性: 1.自营 2.合营 3.包干制 参考枚举：ProjectAttributeEnum")
   private Integer projectAttribute;
   @ApiModelProperty(name = "branchCompanyId", value = "签订主体公司ID")
   private Long branchCompanyId;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理id", notes = "项目经理id")
   private Long projectManagerId;
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
   @ApiModelProperty(name = "signDate", value = "签订日期", notes = "签订日期")
   private LocalDate signDate;
   @ApiModelProperty(name = "invoiceType", value = "发票类型", notes = "发票类型")
   private Integer invoiceType;
   @ApiModelProperty(name = "taxRateTypeValue", value = "字典税率value值", notes = "字典税率value值")
   private String taxRateTypeValue;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "userId", value = "创建人ID", notes = "创建人ID")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "创建人", notes = "创建人")
   private String userName;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID字符串", notes = "附件ID字符串")
   private String attachmentIds;
   @ApiModelProperty(name = "attachmentList", value = "附件列表", notes = "附件列表")
   private List<AttachmentDTO> attachmentList;
   @ApiModelProperty(name = "auditStatusEnum", value = "审核状态 1待审核 2已通过 4已驳回", notes = "审核状态 1待审核 2已通过 4已驳回")
   private Integer auditStatusEnum;
   @ApiModelProperty("审批流程信息列表")
   private List<WmsApproveFlowDTO> wmsApproveFlowList;

   public static SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder builder() {
      return new SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder();
   }

   public SubcontractOrderTempDTO() {
   }

   public SubcontractOrderTempDTO(
      final Long id,
      final Integer changeTypeEnum,
      final Long orderId,
      final String serialNumber,
      final Long projectId,
      final Integer projectAttribute,
      final Long branchCompanyId,
      final Long projectManagerId,
      final Long supplierId,
      final String supplierName,
      final Long subcontractClassId,
      final String subcontractClassName,
      final BigDecimal amount,
      final LocalDate signDate,
      final Integer invoiceType,
      final String taxRateTypeValue,
      final BigDecimal taxRate,
      final Long userId,
      final String userName,
      final String remark,
      final String attachmentIds,
      final List<AttachmentDTO> attachmentList,
      final Integer auditStatusEnum,
      final List<WmsApproveFlowDTO> wmsApproveFlowList
   ) {
      this.id = id;
      this.changeTypeEnum = changeTypeEnum;
      this.orderId = orderId;
      this.serialNumber = serialNumber;
      this.projectId = projectId;
      this.projectAttribute = projectAttribute;
      this.branchCompanyId = branchCompanyId;
      this.projectManagerId = projectManagerId;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.subcontractClassId = subcontractClassId;
      this.subcontractClassName = subcontractClassName;
      this.amount = amount;
      this.signDate = signDate;
      this.invoiceType = invoiceType;
      this.taxRateTypeValue = taxRateTypeValue;
      this.taxRate = taxRate;
      this.userId = userId;
      this.userName = userName;
      this.remark = remark;
      this.attachmentIds = attachmentIds;
      this.attachmentList = attachmentList;
      this.auditStatusEnum = auditStatusEnum;
      this.wmsApproveFlowList = wmsApproveFlowList;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getChangeTypeEnum() {
      return this.changeTypeEnum;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
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

   public LocalDate getSignDate() {
      return this.signDate;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public String getTaxRateTypeValue() {
      return this.taxRateTypeValue;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
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

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<AttachmentDTO> getAttachmentList() {
      return this.attachmentList;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public List<WmsApproveFlowDTO> getWmsApproveFlowList() {
      return this.wmsApproveFlowList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setChangeTypeEnum(final Integer changeTypeEnum) {
      this.changeTypeEnum = changeTypeEnum;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
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

   public void setSignDate(final LocalDate signDate) {
      this.signDate = signDate;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRateTypeValue(final String taxRateTypeValue) {
      this.taxRateTypeValue = taxRateTypeValue;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
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

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setAttachmentList(final List<AttachmentDTO> attachmentList) {
      this.attachmentList = attachmentList;
   }

   public void setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
   }

   public void setWmsApproveFlowList(final List<WmsApproveFlowDTO> wmsApproveFlowList) {
      this.wmsApproveFlowList = wmsApproveFlowList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubcontractOrderTempDTO)) {
         return false;
      }

      SubcontractOrderTempDTO other = (SubcontractOrderTempDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$changeTypeEnum = this.getChangeTypeEnum();
         Object other$changeTypeEnum = other.getChangeTypeEnum();
         if (this$changeTypeEnum == null ? other$changeTypeEnum == null : this$changeTypeEnum.equals(other$changeTypeEnum)) {
            Object this$orderId = this.getOrderId();
            Object other$orderId = other.getOrderId();
            if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$projectAttribute = this.getProjectAttribute();
                  Object other$projectAttribute = other.getProjectAttribute();
                  if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                     Object this$branchCompanyId = this.getBranchCompanyId();
                     Object other$branchCompanyId = other.getBranchCompanyId();
                     if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                        Object this$projectManagerId = this.getProjectManagerId();
                        Object other$projectManagerId = other.getProjectManagerId();
                        if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                           Object this$supplierId = this.getSupplierId();
                           Object other$supplierId = other.getSupplierId();
                           if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                              Object this$subcontractClassId = this.getSubcontractClassId();
                              Object other$subcontractClassId = other.getSubcontractClassId();
                              if (this$subcontractClassId == null ? other$subcontractClassId == null : this$subcontractClassId.equals(other$subcontractClassId)
                                 )
                               {
                                 Object this$invoiceType = this.getInvoiceType();
                                 Object other$invoiceType = other.getInvoiceType();
                                 if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                    Object this$userId = this.getUserId();
                                    Object other$userId = other.getUserId();
                                    if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                       Object this$auditStatusEnum = this.getAuditStatusEnum();
                                       Object other$auditStatusEnum = other.getAuditStatusEnum();
                                       if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
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
                                                      Object this$signDate = this.getSignDate();
                                                      Object other$signDate = other.getSignDate();
                                                      if (this$signDate == null ? other$signDate == null : this$signDate.equals(other$signDate)) {
                                                         Object this$taxRateTypeValue = this.getTaxRateTypeValue();
                                                         Object other$taxRateTypeValue = other.getTaxRateTypeValue();
                                                         if (this$taxRateTypeValue == null
                                                            ? other$taxRateTypeValue == null
                                                            : this$taxRateTypeValue.equals(other$taxRateTypeValue)) {
                                                            Object this$taxRate = this.getTaxRate();
                                                            Object other$taxRate = other.getTaxRate();
                                                            if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                               Object this$userName = this.getUserName();
                                                               Object other$userName = other.getUserName();
                                                               if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                                  Object this$remark = this.getRemark();
                                                                  Object other$remark = other.getRemark();
                                                                  if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
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
                                                                           Object this$wmsApproveFlowList = this.getWmsApproveFlowList();
                                                                           Object other$wmsApproveFlowList = other.getWmsApproveFlowList();
                                                                           return this$wmsApproveFlowList == null
                                                                              ? other$wmsApproveFlowList == null
                                                                              : this$wmsApproveFlowList.equals(other$wmsApproveFlowList);
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
      return other instanceof SubcontractOrderTempDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $changeTypeEnum = this.getChangeTypeEnum();
      result = result * 59 + ($changeTypeEnum == null ? 43 : $changeTypeEnum.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $subcontractClassId = this.getSubcontractClassId();
      result = result * 59 + ($subcontractClassId == null ? 43 : $subcontractClassId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $subcontractClassName = this.getSubcontractClassName();
      result = result * 59 + ($subcontractClassName == null ? 43 : $subcontractClassName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $signDate = this.getSignDate();
      result = result * 59 + ($signDate == null ? 43 : $signDate.hashCode());
      Object $taxRateTypeValue = this.getTaxRateTypeValue();
      result = result * 59 + ($taxRateTypeValue == null ? 43 : $taxRateTypeValue.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachmentList = this.getAttachmentList();
      result = result * 59 + ($attachmentList == null ? 43 : $attachmentList.hashCode());
      Object $wmsApproveFlowList = this.getWmsApproveFlowList();
      return result * 59 + ($wmsApproveFlowList == null ? 43 : $wmsApproveFlowList.hashCode());
   }

   @Override
   public String toString() {
      return "SubcontractOrderTempDTO(id="
         + this.getId()
         + ", changeTypeEnum="
         + this.getChangeTypeEnum()
         + ", orderId="
         + this.getOrderId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", projectManagerId="
         + this.getProjectManagerId()
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
         + ", signDate="
         + this.getSignDate()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRateTypeValue="
         + this.getTaxRateTypeValue()
         + ", taxRate="
         + this.getTaxRate()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", remark="
         + this.getRemark()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachmentList="
         + this.getAttachmentList()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", wmsApproveFlowList="
         + this.getWmsApproveFlowList()
         + ")";
   }

   public static class SubcontractOrderTempDTOBuilder {
      private Long id;
      private Integer changeTypeEnum;
      private Long orderId;
      private String serialNumber;
      private Long projectId;
      private Integer projectAttribute;
      private Long branchCompanyId;
      private Long projectManagerId;
      private Long supplierId;
      private String supplierName;
      private Long subcontractClassId;
      private String subcontractClassName;
      private BigDecimal amount;
      private LocalDate signDate;
      private Integer invoiceType;
      private String taxRateTypeValue;
      private BigDecimal taxRate;
      private Long userId;
      private String userName;
      private String remark;
      private String attachmentIds;
      private List<AttachmentDTO> attachmentList;
      private Integer auditStatusEnum;
      private List<WmsApproveFlowDTO> wmsApproveFlowList;

      SubcontractOrderTempDTOBuilder() {
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder changeTypeEnum(final Integer changeTypeEnum) {
         this.changeTypeEnum = changeTypeEnum;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder subcontractClassName(final String subcontractClassName) {
         this.subcontractClassName = subcontractClassName;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder signDate(final LocalDate signDate) {
         this.signDate = signDate;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder taxRateTypeValue(final String taxRateTypeValue) {
         this.taxRateTypeValue = taxRateTypeValue;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder attachmentList(final List<AttachmentDTO> attachmentList) {
         this.attachmentList = attachmentList;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder wmsApproveFlowList(final List<WmsApproveFlowDTO> wmsApproveFlowList) {
         this.wmsApproveFlowList = wmsApproveFlowList;
         return this;
      }

      public SubcontractOrderTempDTO build() {
         return new SubcontractOrderTempDTO(
            this.id,
            this.changeTypeEnum,
            this.orderId,
            this.serialNumber,
            this.projectId,
            this.projectAttribute,
            this.branchCompanyId,
            this.projectManagerId,
            this.supplierId,
            this.supplierName,
            this.subcontractClassId,
            this.subcontractClassName,
            this.amount,
            this.signDate,
            this.invoiceType,
            this.taxRateTypeValue,
            this.taxRate,
            this.userId,
            this.userName,
            this.remark,
            this.attachmentIds,
            this.attachmentList,
            this.auditStatusEnum,
            this.wmsApproveFlowList
         );
      }

      @Override
      public String toString() {
         return "SubcontractOrderTempDTO.SubcontractOrderTempDTOBuilder(id="
            + this.id
            + ", changeTypeEnum="
            + this.changeTypeEnum
            + ", orderId="
            + this.orderId
            + ", serialNumber="
            + this.serialNumber
            + ", projectId="
            + this.projectId
            + ", projectAttribute="
            + this.projectAttribute
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", projectManagerId="
            + this.projectManagerId
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
            + ", signDate="
            + this.signDate
            + ", invoiceType="
            + this.invoiceType
            + ", taxRateTypeValue="
            + this.taxRateTypeValue
            + ", taxRate="
            + this.taxRate
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", remark="
            + this.remark
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachmentList="
            + this.attachmentList
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ", wmsApproveFlowList="
            + this.wmsApproveFlowList
            + ")";
      }
   }
}
