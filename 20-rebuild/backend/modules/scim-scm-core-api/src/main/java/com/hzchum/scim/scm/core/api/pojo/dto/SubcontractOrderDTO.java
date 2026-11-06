package com.hzchum.scim.scm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ApiModel("SubcontractOrderDTO对象")
public class SubcontractOrderDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "订单编号", notes = "订单编号")
   private String serialNumber;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "branchCompany", value = "分包单位(分公司)", notes = "分包单位(分公司")
   private NameInfo branchCompany;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理id", notes = "项目经理Id")
   private Long projectManagerId;
   @ApiModelProperty(name = "projectManagerName", value = "项目经理", notes = "项目经理")
   private String projectManagerName;
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
   @ApiModelProperty(name = "taxRateTypeValue", value = "字典税率value值", notes = "字典税率value值")
   private String taxRateTypeValue;
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
   @ApiModelProperty(name = "attachmentIds", value = "附件ID列表", notes = "附件ID列表")
   private List<Long> attachmentIds;
   @ApiModelProperty(name = "attachments", value = "附件列表", notes = "附件列表")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "signDate", value = "签订日期", notes = "签订日期")
   private LocalDate signDate;
   @ApiModelProperty(name = "monomerList", value = "单体列表")
   private List<NameInfo> monomerList;

   protected SubcontractOrderDTO(final SubcontractOrderDTO.SubcontractOrderDTOBuilder<?, ?> b) {
      this.id = b.id;
      this.serialNumber = b.serialNumber;
      this.projectId = b.projectId;
      this.project = b.project;
      this.branchCompany = b.branchCompany;
      this.projectManagerId = b.projectManagerId;
      this.projectManagerName = b.projectManagerName;
      this.supplierId = b.supplierId;
      this.supplierName = b.supplierName;
      this.subcontractClassId = b.subcontractClassId;
      this.subcontractClassName = b.subcontractClassName;
      this.amount = b.amount;
      this.invoiceType = b.invoiceType;
      this.taxRateTypeValue = b.taxRateTypeValue;
      this.taxRate = b.taxRate;
      this.orderStatus = b.orderStatus;
      this.boolSettlementStatus = b.boolSettlementStatus;
      this.settlementAmount = b.settlementAmount;
      this.userId = b.userId;
      this.userName = b.userName;
      this.attachmentIds = b.attachmentIds;
      this.attachments = b.attachments;
      this.remark = b.remark;
      this.signDate = b.signDate;
      this.monomerList = b.monomerList;
   }

   public static SubcontractOrderDTO.SubcontractOrderDTOBuilder<?, ?> builder() {
      return new SubcontractOrderDTO.SubcontractOrderDTOBuilderImpl();
   }

   public SubcontractOrderDTO() {
   }

   public SubcontractOrderDTO(
      final Long id,
      final String serialNumber,
      final Long projectId,
      final ProjectInfo project,
      final NameInfo branchCompany,
      final Long projectManagerId,
      final String projectManagerName,
      final Long supplierId,
      final String supplierName,
      final Long subcontractClassId,
      final String subcontractClassName,
      final BigDecimal amount,
      final Integer invoiceType,
      final String taxRateTypeValue,
      final BigDecimal taxRate,
      final Integer orderStatus,
      final Boolean boolSettlementStatus,
      final BigDecimal settlementAmount,
      final Long userId,
      final String userName,
      final List<Long> attachmentIds,
      final List<AttachmentDTO> attachments,
      final String remark,
      final LocalDate signDate,
      final List<NameInfo> monomerList
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.projectId = projectId;
      this.project = project;
      this.branchCompany = branchCompany;
      this.projectManagerId = projectManagerId;
      this.projectManagerName = projectManagerName;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.subcontractClassId = subcontractClassId;
      this.subcontractClassName = subcontractClassName;
      this.amount = amount;
      this.invoiceType = invoiceType;
      this.taxRateTypeValue = taxRateTypeValue;
      this.taxRate = taxRate;
      this.orderStatus = orderStatus;
      this.boolSettlementStatus = boolSettlementStatus;
      this.settlementAmount = settlementAmount;
      this.userId = userId;
      this.userName = userName;
      this.attachmentIds = attachmentIds;
      this.attachments = attachments;
      this.remark = remark;
      this.signDate = signDate;
      this.monomerList = monomerList;
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

   public NameInfo getBranchCompany() {
      return this.branchCompany;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
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

   public String getTaxRateTypeValue() {
      return this.taxRateTypeValue;
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

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public String getRemark() {
      return this.remark;
   }

   public LocalDate getSignDate() {
      return this.signDate;
   }

   public List<NameInfo> getMonomerList() {
      return this.monomerList;
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

   public void setBranchCompany(final NameInfo branchCompany) {
      this.branchCompany = branchCompany;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
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

   public void setTaxRateTypeValue(final String taxRateTypeValue) {
      this.taxRateTypeValue = taxRateTypeValue;
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

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setSignDate(final LocalDate signDate) {
      this.signDate = signDate;
   }

   public void setMonomerList(final List<NameInfo> monomerList) {
      this.monomerList = monomerList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubcontractOrderDTO)) {
         return false;
      }

      SubcontractOrderDTO other = (SubcontractOrderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$projectManagerId = this.getProjectManagerId();
            Object other$projectManagerId = other.getProjectManagerId();
            if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
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
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$project = this.getProject();
                                    Object other$project = other.getProject();
                                    if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                       Object this$branchCompany = this.getBranchCompany();
                                       Object other$branchCompany = other.getBranchCompany();
                                       if (this$branchCompany == null ? other$branchCompany == null : this$branchCompany.equals(other$branchCompany)) {
                                          Object this$projectManagerName = this.getProjectManagerName();
                                          Object other$projectManagerName = other.getProjectManagerName();
                                          if (this$projectManagerName == null
                                             ? other$projectManagerName == null
                                             : this$projectManagerName.equals(other$projectManagerName)) {
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
                                                      Object this$taxRateTypeValue = this.getTaxRateTypeValue();
                                                      Object other$taxRateTypeValue = other.getTaxRateTypeValue();
                                                      if (this$taxRateTypeValue == null
                                                         ? other$taxRateTypeValue == null
                                                         : this$taxRateTypeValue.equals(other$taxRateTypeValue)) {
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
                                                                           Object this$signDate = this.getSignDate();
                                                                           Object other$signDate = other.getSignDate();
                                                                           if (this$signDate == null
                                                                              ? other$signDate == null
                                                                              : this$signDate.equals(other$signDate)) {
                                                                              Object this$monomerList = this.getMonomerList();
                                                                              Object other$monomerList = other.getMonomerList();
                                                                              return this$monomerList == null
                                                                                 ? other$monomerList == null
                                                                                 : this$monomerList.equals(other$monomerList);
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
      return other instanceof SubcontractOrderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
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
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $branchCompany = this.getBranchCompany();
      result = result * 59 + ($branchCompany == null ? 43 : $branchCompany.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $subcontractClassName = this.getSubcontractClassName();
      result = result * 59 + ($subcontractClassName == null ? 43 : $subcontractClassName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $taxRateTypeValue = this.getTaxRateTypeValue();
      result = result * 59 + ($taxRateTypeValue == null ? 43 : $taxRateTypeValue.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $signDate = this.getSignDate();
      result = result * 59 + ($signDate == null ? 43 : $signDate.hashCode());
      Object $monomerList = this.getMonomerList();
      return result * 59 + ($monomerList == null ? 43 : $monomerList.hashCode());
   }

   @Override
   public String toString() {
      return "SubcontractOrderDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", project="
         + this.getProject()
         + ", branchCompany="
         + this.getBranchCompany()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerName="
         + this.getProjectManagerName()
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
         + ", taxRateTypeValue="
         + this.getTaxRateTypeValue()
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
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachments="
         + this.getAttachments()
         + ", remark="
         + this.getRemark()
         + ", signDate="
         + this.getSignDate()
         + ", monomerList="
         + this.getMonomerList()
         + ")";
   }

   public abstract static class SubcontractOrderDTOBuilder<C extends SubcontractOrderDTO, B extends SubcontractOrderDTO.SubcontractOrderDTOBuilder<C, B>> {
      private Long id;
      private String serialNumber;
      private Long projectId;
      private ProjectInfo project;
      private NameInfo branchCompany;
      private Long projectManagerId;
      private String projectManagerName;
      private Long supplierId;
      private String supplierName;
      private Long subcontractClassId;
      private String subcontractClassName;
      private BigDecimal amount;
      private Integer invoiceType;
      private String taxRateTypeValue;
      private BigDecimal taxRate;
      private Integer orderStatus;
      private Boolean boolSettlementStatus;
      private BigDecimal settlementAmount;
      private Long userId;
      private String userName;
      private List<Long> attachmentIds;
      private List<AttachmentDTO> attachments;
      private String remark;
      private LocalDate signDate;
      private List<NameInfo> monomerList;

      protected abstract B self();

      public abstract C build();

      public B id(final Long id) {
         this.id = id;
         return this.self();
      }

      public B serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this.self();
      }

      public B projectId(final Long projectId) {
         this.projectId = projectId;
         return this.self();
      }

      public B project(final ProjectInfo project) {
         this.project = project;
         return this.self();
      }

      public B branchCompany(final NameInfo branchCompany) {
         this.branchCompany = branchCompany;
         return this.self();
      }

      public B projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this.self();
      }

      public B projectManagerName(final String projectManagerName) {
         this.projectManagerName = projectManagerName;
         return this.self();
      }

      public B supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this.self();
      }

      public B supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this.self();
      }

      public B subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this.self();
      }

      public B subcontractClassName(final String subcontractClassName) {
         this.subcontractClassName = subcontractClassName;
         return this.self();
      }

      public B amount(final BigDecimal amount) {
         this.amount = amount;
         return this.self();
      }

      public B invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this.self();
      }

      public B taxRateTypeValue(final String taxRateTypeValue) {
         this.taxRateTypeValue = taxRateTypeValue;
         return this.self();
      }

      public B taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this.self();
      }

      public B orderStatus(final Integer orderStatus) {
         this.orderStatus = orderStatus;
         return this.self();
      }

      public B boolSettlementStatus(final Boolean boolSettlementStatus) {
         this.boolSettlementStatus = boolSettlementStatus;
         return this.self();
      }

      public B settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this.self();
      }

      public B userId(final Long userId) {
         this.userId = userId;
         return this.self();
      }

      public B userName(final String userName) {
         this.userName = userName;
         return this.self();
      }

      public B attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this.self();
      }

      public B attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this.self();
      }

      public B remark(final String remark) {
         this.remark = remark;
         return this.self();
      }

      public B signDate(final LocalDate signDate) {
         this.signDate = signDate;
         return this.self();
      }

      public B monomerList(final List<NameInfo> monomerList) {
         this.monomerList = monomerList;
         return this.self();
      }

      @Override
      public String toString() {
         return "SubcontractOrderDTO.SubcontractOrderDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", projectId="
            + this.projectId
            + ", project="
            + this.project
            + ", branchCompany="
            + this.branchCompany
            + ", projectManagerId="
            + this.projectManagerId
            + ", projectManagerName="
            + this.projectManagerName
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
            + ", taxRateTypeValue="
            + this.taxRateTypeValue
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
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachments="
            + this.attachments
            + ", remark="
            + this.remark
            + ", signDate="
            + this.signDate
            + ", monomerList="
            + this.monomerList
            + ")";
      }
   }

   private static final class SubcontractOrderDTOBuilderImpl
      extends SubcontractOrderDTO.SubcontractOrderDTOBuilder<SubcontractOrderDTO, SubcontractOrderDTO.SubcontractOrderDTOBuilderImpl> {
      private SubcontractOrderDTOBuilderImpl() {
      }

      protected SubcontractOrderDTO.SubcontractOrderDTOBuilderImpl self() {
         return this;
      }

      @Override
      public SubcontractOrderDTO build() {
         return new SubcontractOrderDTO(this);
      }
   }
}
