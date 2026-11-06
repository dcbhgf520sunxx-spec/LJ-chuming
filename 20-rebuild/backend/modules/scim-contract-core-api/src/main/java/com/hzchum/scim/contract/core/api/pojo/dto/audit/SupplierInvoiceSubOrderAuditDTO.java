package com.hzchum.scim.contract.core.api.pojo.dto.audit;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSettlementEchoDto;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.List;

@ApiOperation("审批管理-分包收票信息")
public class SupplierInvoiceSubOrderAuditDTO {
   @ApiModelProperty(name = "paymentEnum", value = "付款类型", notes = "付款类型")
   private Integer paymentEnum;
   @ApiModelProperty("通过按钮")
   private Boolean passButton;
   @ApiModelProperty("申请人id")
   private Long applyUserId;
   @ApiModelProperty("申请人名称")
   private String applyUserName;
   @ApiModelProperty
   private String projectManagerName;
   @ApiModelProperty
   private String salesLeaderName;
   @ApiModelProperty
   private String supplierName;
   @ApiModelProperty(name = "serialNumber", value = "采购合同号", notes = "采购合同号")
   private List<String> serialNumber;
   @ApiModelProperty("发票号码")
   private String invoiceSerialNumber;
   @ApiModelProperty("项目类型")
   private Integer projectAttribute;
   @ApiModelProperty("签约主体id")
   private Long branchCompanyId;
   @ApiModelProperty("签约主体名称")
   private String branchCompanyName;
   @ApiModelProperty("合同金额")
   private BigDecimal amount;
   @ApiModelProperty("物资类型")
   private Integer basicClass;
   @ApiModelProperty("物资类型")
   private String basicClassName;
   @ApiModelProperty("结算金额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("本次发票额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty(name = "attachments", value = "附件列表", notes = "附件列表")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty(name = "boolFinalApprover", value = "是否最后一个审批人", notes = "是否最后一个审批人")
   private Boolean boolFinalApprover;
   @ApiModelProperty(name = "supplierSettlementEchoDtoList", value = "付款开票信息回显（内包制and自合营通用）", notes = "付款开票信息回显（内包制and自合营通用）")
   private List<SupplierSettlementEchoDto> supplierSettlementEchoDtoList;

   public static SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder builder() {
      return new SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder();
   }

   public Integer getPaymentEnum() {
      return this.paymentEnum;
   }

   public Boolean getPassButton() {
      return this.passButton;
   }

   public Long getApplyUserId() {
      return this.applyUserId;
   }

   public String getApplyUserName() {
      return this.applyUserName;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public String getSalesLeaderName() {
      return this.salesLeaderName;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public List<String> getSerialNumber() {
      return this.serialNumber;
   }

   public String getInvoiceSerialNumber() {
      return this.invoiceSerialNumber;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
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

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public Boolean getBoolFinalApprover() {
      return this.boolFinalApprover;
   }

   public List<SupplierSettlementEchoDto> getSupplierSettlementEchoDtoList() {
      return this.supplierSettlementEchoDtoList;
   }

   public SupplierInvoiceSubOrderAuditDTO setPaymentEnum(final Integer paymentEnum) {
      this.paymentEnum = paymentEnum;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setPassButton(final Boolean passButton) {
      this.passButton = passButton;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setApplyUserId(final Long applyUserId) {
      this.applyUserId = applyUserId;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setApplyUserName(final String applyUserName) {
      this.applyUserName = applyUserName;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setSalesLeaderName(final String salesLeaderName) {
      this.salesLeaderName = salesLeaderName;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setSerialNumber(final List<String> serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setInvoiceSerialNumber(final String invoiceSerialNumber) {
      this.invoiceSerialNumber = invoiceSerialNumber;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setBasicClassName(final String basicClassName) {
      this.basicClassName = basicClassName;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setBoolFinalApprover(final Boolean boolFinalApprover) {
      this.boolFinalApprover = boolFinalApprover;
      return this;
   }

   public SupplierInvoiceSubOrderAuditDTO setSupplierSettlementEchoDtoList(final List<SupplierSettlementEchoDto> supplierSettlementEchoDtoList) {
      this.supplierSettlementEchoDtoList = supplierSettlementEchoDtoList;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierInvoiceSubOrderAuditDTO)) {
         return false;
      }

      SupplierInvoiceSubOrderAuditDTO other = (SupplierInvoiceSubOrderAuditDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$paymentEnum = this.getPaymentEnum();
      Object other$paymentEnum = other.getPaymentEnum();
      if (this$paymentEnum == null ? other$paymentEnum == null : this$paymentEnum.equals(other$paymentEnum)) {
         Object this$passButton = this.getPassButton();
         Object other$passButton = other.getPassButton();
         if (this$passButton == null ? other$passButton == null : this$passButton.equals(other$passButton)) {
            Object this$applyUserId = this.getApplyUserId();
            Object other$applyUserId = other.getApplyUserId();
            if (this$applyUserId == null ? other$applyUserId == null : this$applyUserId.equals(other$applyUserId)) {
               Object this$projectAttribute = this.getProjectAttribute();
               Object other$projectAttribute = other.getProjectAttribute();
               if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                  Object this$branchCompanyId = this.getBranchCompanyId();
                  Object other$branchCompanyId = other.getBranchCompanyId();
                  if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                     Object this$basicClass = this.getBasicClass();
                     Object other$basicClass = other.getBasicClass();
                     if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                        Object this$boolFinalApprover = this.getBoolFinalApprover();
                        Object other$boolFinalApprover = other.getBoolFinalApprover();
                        if (this$boolFinalApprover == null ? other$boolFinalApprover == null : this$boolFinalApprover.equals(other$boolFinalApprover)) {
                           Object this$applyUserName = this.getApplyUserName();
                           Object other$applyUserName = other.getApplyUserName();
                           if (this$applyUserName == null ? other$applyUserName == null : this$applyUserName.equals(other$applyUserName)) {
                              Object this$projectManagerName = this.getProjectManagerName();
                              Object other$projectManagerName = other.getProjectManagerName();
                              if (this$projectManagerName == null ? other$projectManagerName == null : this$projectManagerName.equals(other$projectManagerName)
                                 )
                               {
                                 Object this$salesLeaderName = this.getSalesLeaderName();
                                 Object other$salesLeaderName = other.getSalesLeaderName();
                                 if (this$salesLeaderName == null ? other$salesLeaderName == null : this$salesLeaderName.equals(other$salesLeaderName)) {
                                    Object this$supplierName = this.getSupplierName();
                                    Object other$supplierName = other.getSupplierName();
                                    if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$invoiceSerialNumber = this.getInvoiceSerialNumber();
                                          Object other$invoiceSerialNumber = other.getInvoiceSerialNumber();
                                          if (this$invoiceSerialNumber == null
                                             ? other$invoiceSerialNumber == null
                                             : this$invoiceSerialNumber.equals(other$invoiceSerialNumber)) {
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
                                                         Object this$invoiceAmount = this.getInvoiceAmount();
                                                         Object other$invoiceAmount = other.getInvoiceAmount();
                                                         if (this$invoiceAmount == null
                                                            ? other$invoiceAmount == null
                                                            : this$invoiceAmount.equals(other$invoiceAmount)) {
                                                            Object this$remark = this.getRemark();
                                                            Object other$remark = other.getRemark();
                                                            if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                               Object this$projectName = this.getProjectName();
                                                               Object other$projectName = other.getProjectName();
                                                               if (this$projectName == null
                                                                  ? other$projectName == null
                                                                  : this$projectName.equals(other$projectName)) {
                                                                  Object this$attachments = this.getAttachments();
                                                                  Object other$attachments = other.getAttachments();
                                                                  if (this$attachments == null
                                                                     ? other$attachments == null
                                                                     : this$attachments.equals(other$attachments)) {
                                                                     Object this$supplierSettlementEchoDtoList = this.getSupplierSettlementEchoDtoList();
                                                                     Object other$supplierSettlementEchoDtoList = other.getSupplierSettlementEchoDtoList();
                                                                     return this$supplierSettlementEchoDtoList == null
                                                                        ? other$supplierSettlementEchoDtoList == null
                                                                        : this$supplierSettlementEchoDtoList.equals(other$supplierSettlementEchoDtoList);
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
      return other instanceof SupplierInvoiceSubOrderAuditDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $paymentEnum = this.getPaymentEnum();
      result = result * 59 + ($paymentEnum == null ? 43 : $paymentEnum.hashCode());
      Object $passButton = this.getPassButton();
      result = result * 59 + ($passButton == null ? 43 : $passButton.hashCode());
      Object $applyUserId = this.getApplyUserId();
      result = result * 59 + ($applyUserId == null ? 43 : $applyUserId.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $boolFinalApprover = this.getBoolFinalApprover();
      result = result * 59 + ($boolFinalApprover == null ? 43 : $boolFinalApprover.hashCode());
      Object $applyUserName = this.getApplyUserName();
      result = result * 59 + ($applyUserName == null ? 43 : $applyUserName.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $salesLeaderName = this.getSalesLeaderName();
      result = result * 59 + ($salesLeaderName == null ? 43 : $salesLeaderName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $invoiceSerialNumber = this.getInvoiceSerialNumber();
      result = result * 59 + ($invoiceSerialNumber == null ? 43 : $invoiceSerialNumber.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $basicClassName = this.getBasicClassName();
      result = result * 59 + ($basicClassName == null ? 43 : $basicClassName.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $supplierSettlementEchoDtoList = this.getSupplierSettlementEchoDtoList();
      return result * 59 + ($supplierSettlementEchoDtoList == null ? 43 : $supplierSettlementEchoDtoList.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierInvoiceSubOrderAuditDTO(paymentEnum="
         + this.getPaymentEnum()
         + ", passButton="
         + this.getPassButton()
         + ", applyUserId="
         + this.getApplyUserId()
         + ", applyUserName="
         + this.getApplyUserName()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", salesLeaderName="
         + this.getSalesLeaderName()
         + ", supplierName="
         + this.getSupplierName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", invoiceSerialNumber="
         + this.getInvoiceSerialNumber()
         + ", projectAttribute="
         + this.getProjectAttribute()
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
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", remark="
         + this.getRemark()
         + ", projectName="
         + this.getProjectName()
         + ", attachments="
         + this.getAttachments()
         + ", boolFinalApprover="
         + this.getBoolFinalApprover()
         + ", supplierSettlementEchoDtoList="
         + this.getSupplierSettlementEchoDtoList()
         + ")";
   }

   public SupplierInvoiceSubOrderAuditDTO(
      final Integer paymentEnum,
      final Boolean passButton,
      final Long applyUserId,
      final String applyUserName,
      final String projectManagerName,
      final String salesLeaderName,
      final String supplierName,
      final List<String> serialNumber,
      final String invoiceSerialNumber,
      final Integer projectAttribute,
      final Long branchCompanyId,
      final String branchCompanyName,
      final BigDecimal amount,
      final Integer basicClass,
      final String basicClassName,
      final BigDecimal settlementAmount,
      final BigDecimal invoiceAmount,
      final String remark,
      final String projectName,
      final List<AttachmentDTO> attachments,
      final Boolean boolFinalApprover,
      final List<SupplierSettlementEchoDto> supplierSettlementEchoDtoList
   ) {
      this.paymentEnum = paymentEnum;
      this.passButton = passButton;
      this.applyUserId = applyUserId;
      this.applyUserName = applyUserName;
      this.projectManagerName = projectManagerName;
      this.salesLeaderName = salesLeaderName;
      this.supplierName = supplierName;
      this.serialNumber = serialNumber;
      this.invoiceSerialNumber = invoiceSerialNumber;
      this.projectAttribute = projectAttribute;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.amount = amount;
      this.basicClass = basicClass;
      this.basicClassName = basicClassName;
      this.settlementAmount = settlementAmount;
      this.invoiceAmount = invoiceAmount;
      this.remark = remark;
      this.projectName = projectName;
      this.attachments = attachments;
      this.boolFinalApprover = boolFinalApprover;
      this.supplierSettlementEchoDtoList = supplierSettlementEchoDtoList;
   }

   public SupplierInvoiceSubOrderAuditDTO() {
   }

   public static class SupplierInvoiceSubOrderAuditDTOBuilder {
      private Integer paymentEnum;
      private Boolean passButton;
      private Long applyUserId;
      private String applyUserName;
      private String projectManagerName;
      private String salesLeaderName;
      private String supplierName;
      private List<String> serialNumber;
      private String invoiceSerialNumber;
      private Integer projectAttribute;
      private Long branchCompanyId;
      private String branchCompanyName;
      private BigDecimal amount;
      private Integer basicClass;
      private String basicClassName;
      private BigDecimal settlementAmount;
      private BigDecimal invoiceAmount;
      private String remark;
      private String projectName;
      private List<AttachmentDTO> attachments;
      private Boolean boolFinalApprover;
      private List<SupplierSettlementEchoDto> supplierSettlementEchoDtoList;

      SupplierInvoiceSubOrderAuditDTOBuilder() {
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder paymentEnum(final Integer paymentEnum) {
         this.paymentEnum = paymentEnum;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder passButton(final Boolean passButton) {
         this.passButton = passButton;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder applyUserId(final Long applyUserId) {
         this.applyUserId = applyUserId;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder applyUserName(final String applyUserName) {
         this.applyUserName = applyUserName;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder projectManagerName(final String projectManagerName) {
         this.projectManagerName = projectManagerName;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder salesLeaderName(final String salesLeaderName) {
         this.salesLeaderName = salesLeaderName;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder serialNumber(final List<String> serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder invoiceSerialNumber(final String invoiceSerialNumber) {
         this.invoiceSerialNumber = invoiceSerialNumber;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder basicClassName(final String basicClassName) {
         this.basicClassName = basicClassName;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder boolFinalApprover(final Boolean boolFinalApprover) {
         this.boolFinalApprover = boolFinalApprover;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder supplierSettlementEchoDtoList(
         final List<SupplierSettlementEchoDto> supplierSettlementEchoDtoList
      ) {
         this.supplierSettlementEchoDtoList = supplierSettlementEchoDtoList;
         return this;
      }

      public SupplierInvoiceSubOrderAuditDTO build() {
         return new SupplierInvoiceSubOrderAuditDTO(
            this.paymentEnum,
            this.passButton,
            this.applyUserId,
            this.applyUserName,
            this.projectManagerName,
            this.salesLeaderName,
            this.supplierName,
            this.serialNumber,
            this.invoiceSerialNumber,
            this.projectAttribute,
            this.branchCompanyId,
            this.branchCompanyName,
            this.amount,
            this.basicClass,
            this.basicClassName,
            this.settlementAmount,
            this.invoiceAmount,
            this.remark,
            this.projectName,
            this.attachments,
            this.boolFinalApprover,
            this.supplierSettlementEchoDtoList
         );
      }

      @Override
      public String toString() {
         return "SupplierInvoiceSubOrderAuditDTO.SupplierInvoiceSubOrderAuditDTOBuilder(paymentEnum="
            + this.paymentEnum
            + ", passButton="
            + this.passButton
            + ", applyUserId="
            + this.applyUserId
            + ", applyUserName="
            + this.applyUserName
            + ", projectManagerName="
            + this.projectManagerName
            + ", salesLeaderName="
            + this.salesLeaderName
            + ", supplierName="
            + this.supplierName
            + ", serialNumber="
            + this.serialNumber
            + ", invoiceSerialNumber="
            + this.invoiceSerialNumber
            + ", projectAttribute="
            + this.projectAttribute
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
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", remark="
            + this.remark
            + ", projectName="
            + this.projectName
            + ", attachments="
            + this.attachments
            + ", boolFinalApprover="
            + this.boolFinalApprover
            + ", supplierSettlementEchoDtoList="
            + this.supplierSettlementEchoDtoList
            + ")";
      }
   }
}
