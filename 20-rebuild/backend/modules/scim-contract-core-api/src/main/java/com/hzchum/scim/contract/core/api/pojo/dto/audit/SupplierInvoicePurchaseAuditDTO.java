package com.hzchum.scim.contract.core.api.pojo.dto.audit;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSelfEmployedDto;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.List;

@ApiOperation("审批管理-采购收票信息")
public class SupplierInvoicePurchaseAuditDTO {
   @ApiModelProperty(name = "paymentEnum", value = "付款类型", notes = "付款类型")
   private Integer paymentEnum;
   @ApiModelProperty("通过按钮")
   private Boolean passButton;
   @ApiModelProperty("申请人id")
   private Long applyUserId;
   @ApiModelProperty("申请人名称")
   private String applyUserName;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("项目属性")
   private Integer projectAttribute;
   @ApiModelProperty(name = "serialNumber", value = "采购合同号", notes = "采购合同号")
   private List<String> serialNumber;
   @ApiModelProperty("供应商")
   private String supplierName;
   @ApiModelProperty("物资类型")
   private Integer basicClass;
   @ApiModelProperty("物资类型名称")
   private String basicClassName;
   @ApiModelProperty("发票号码")
   private String invoiceSerialNumber;
   @ApiModelProperty("本次申请发票总额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("本次实开发票总额")
   private BigDecimal actualInvoiceAmount;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty(name = "attachments", value = "附件列表", notes = "附件列表")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty(name = "boolFinalApprover", value = "是否最后一个审批人", notes = "是否最后一个审批人")
   private Boolean boolFinalApprover;
   @ApiModelProperty("订单开票详情列表")
   private List<SupplierSelfEmployedDto> orderInvoiceList;

   public static SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder builder() {
      return new SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder();
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

   public String getProjectName() {
      return this.projectName;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public List<String> getSerialNumber() {
      return this.serialNumber;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getBasicClassName() {
      return this.basicClassName;
   }

   public String getInvoiceSerialNumber() {
      return this.invoiceSerialNumber;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getActualInvoiceAmount() {
      return this.actualInvoiceAmount;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public Boolean getBoolFinalApprover() {
      return this.boolFinalApprover;
   }

   public List<SupplierSelfEmployedDto> getOrderInvoiceList() {
      return this.orderInvoiceList;
   }

   public SupplierInvoicePurchaseAuditDTO setPaymentEnum(final Integer paymentEnum) {
      this.paymentEnum = paymentEnum;
      return this;
   }

   public SupplierInvoicePurchaseAuditDTO setPassButton(final Boolean passButton) {
      this.passButton = passButton;
      return this;
   }

   public SupplierInvoicePurchaseAuditDTO setApplyUserId(final Long applyUserId) {
      this.applyUserId = applyUserId;
      return this;
   }

   public SupplierInvoicePurchaseAuditDTO setApplyUserName(final String applyUserName) {
      this.applyUserName = applyUserName;
      return this;
   }

   public SupplierInvoicePurchaseAuditDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public SupplierInvoicePurchaseAuditDTO setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   public SupplierInvoicePurchaseAuditDTO setSerialNumber(final List<String> serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public SupplierInvoicePurchaseAuditDTO setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public SupplierInvoicePurchaseAuditDTO setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public SupplierInvoicePurchaseAuditDTO setBasicClassName(final String basicClassName) {
      this.basicClassName = basicClassName;
      return this;
   }

   public SupplierInvoicePurchaseAuditDTO setInvoiceSerialNumber(final String invoiceSerialNumber) {
      this.invoiceSerialNumber = invoiceSerialNumber;
      return this;
   }

   public SupplierInvoicePurchaseAuditDTO setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
      return this;
   }

   public SupplierInvoicePurchaseAuditDTO setActualInvoiceAmount(final BigDecimal actualInvoiceAmount) {
      this.actualInvoiceAmount = actualInvoiceAmount;
      return this;
   }

   public SupplierInvoicePurchaseAuditDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public SupplierInvoicePurchaseAuditDTO setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
      return this;
   }

   public SupplierInvoicePurchaseAuditDTO setBoolFinalApprover(final Boolean boolFinalApprover) {
      this.boolFinalApprover = boolFinalApprover;
      return this;
   }

   public SupplierInvoicePurchaseAuditDTO setOrderInvoiceList(final List<SupplierSelfEmployedDto> orderInvoiceList) {
      this.orderInvoiceList = orderInvoiceList;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierInvoicePurchaseAuditDTO)) {
         return false;
      }

      SupplierInvoicePurchaseAuditDTO other = (SupplierInvoicePurchaseAuditDTO)o;
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
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$boolFinalApprover = this.getBoolFinalApprover();
                     Object other$boolFinalApprover = other.getBoolFinalApprover();
                     if (this$boolFinalApprover == null ? other$boolFinalApprover == null : this$boolFinalApprover.equals(other$boolFinalApprover)) {
                        Object this$applyUserName = this.getApplyUserName();
                        Object other$applyUserName = other.getApplyUserName();
                        if (this$applyUserName == null ? other$applyUserName == null : this$applyUserName.equals(other$applyUserName)) {
                           Object this$projectName = this.getProjectName();
                           Object other$projectName = other.getProjectName();
                           if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$supplierName = this.getSupplierName();
                                 Object other$supplierName = other.getSupplierName();
                                 if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                    Object this$basicClassName = this.getBasicClassName();
                                    Object other$basicClassName = other.getBasicClassName();
                                    if (this$basicClassName == null ? other$basicClassName == null : this$basicClassName.equals(other$basicClassName)) {
                                       Object this$invoiceSerialNumber = this.getInvoiceSerialNumber();
                                       Object other$invoiceSerialNumber = other.getInvoiceSerialNumber();
                                       if (this$invoiceSerialNumber == null
                                          ? other$invoiceSerialNumber == null
                                          : this$invoiceSerialNumber.equals(other$invoiceSerialNumber)) {
                                          Object this$invoiceAmount = this.getInvoiceAmount();
                                          Object other$invoiceAmount = other.getInvoiceAmount();
                                          if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                                             Object this$actualInvoiceAmount = this.getActualInvoiceAmount();
                                             Object other$actualInvoiceAmount = other.getActualInvoiceAmount();
                                             if (this$actualInvoiceAmount == null
                                                ? other$actualInvoiceAmount == null
                                                : this$actualInvoiceAmount.equals(other$actualInvoiceAmount)) {
                                                Object this$remark = this.getRemark();
                                                Object other$remark = other.getRemark();
                                                if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                   Object this$attachments = this.getAttachments();
                                                   Object other$attachments = other.getAttachments();
                                                   if (this$attachments == null ? other$attachments == null : this$attachments.equals(other$attachments)) {
                                                      Object this$orderInvoiceList = this.getOrderInvoiceList();
                                                      Object other$orderInvoiceList = other.getOrderInvoiceList();
                                                      return this$orderInvoiceList == null
                                                         ? other$orderInvoiceList == null
                                                         : this$orderInvoiceList.equals(other$orderInvoiceList);
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
      return other instanceof SupplierInvoicePurchaseAuditDTO;
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
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $boolFinalApprover = this.getBoolFinalApprover();
      result = result * 59 + ($boolFinalApprover == null ? 43 : $boolFinalApprover.hashCode());
      Object $applyUserName = this.getApplyUserName();
      result = result * 59 + ($applyUserName == null ? 43 : $applyUserName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $basicClassName = this.getBasicClassName();
      result = result * 59 + ($basicClassName == null ? 43 : $basicClassName.hashCode());
      Object $invoiceSerialNumber = this.getInvoiceSerialNumber();
      result = result * 59 + ($invoiceSerialNumber == null ? 43 : $invoiceSerialNumber.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $actualInvoiceAmount = this.getActualInvoiceAmount();
      result = result * 59 + ($actualInvoiceAmount == null ? 43 : $actualInvoiceAmount.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $orderInvoiceList = this.getOrderInvoiceList();
      return result * 59 + ($orderInvoiceList == null ? 43 : $orderInvoiceList.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierInvoicePurchaseAuditDTO(paymentEnum="
         + this.getPaymentEnum()
         + ", passButton="
         + this.getPassButton()
         + ", applyUserId="
         + this.getApplyUserId()
         + ", applyUserName="
         + this.getApplyUserName()
         + ", projectName="
         + this.getProjectName()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", supplierName="
         + this.getSupplierName()
         + ", basicClass="
         + this.getBasicClass()
         + ", basicClassName="
         + this.getBasicClassName()
         + ", invoiceSerialNumber="
         + this.getInvoiceSerialNumber()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", actualInvoiceAmount="
         + this.getActualInvoiceAmount()
         + ", remark="
         + this.getRemark()
         + ", attachments="
         + this.getAttachments()
         + ", boolFinalApprover="
         + this.getBoolFinalApprover()
         + ", orderInvoiceList="
         + this.getOrderInvoiceList()
         + ")";
   }

   public SupplierInvoicePurchaseAuditDTO(
      final Integer paymentEnum,
      final Boolean passButton,
      final Long applyUserId,
      final String applyUserName,
      final String projectName,
      final Integer projectAttribute,
      final List<String> serialNumber,
      final String supplierName,
      final Integer basicClass,
      final String basicClassName,
      final String invoiceSerialNumber,
      final BigDecimal invoiceAmount,
      final BigDecimal actualInvoiceAmount,
      final String remark,
      final List<AttachmentDTO> attachments,
      final Boolean boolFinalApprover,
      final List<SupplierSelfEmployedDto> orderInvoiceList
   ) {
      this.paymentEnum = paymentEnum;
      this.passButton = passButton;
      this.applyUserId = applyUserId;
      this.applyUserName = applyUserName;
      this.projectName = projectName;
      this.projectAttribute = projectAttribute;
      this.serialNumber = serialNumber;
      this.supplierName = supplierName;
      this.basicClass = basicClass;
      this.basicClassName = basicClassName;
      this.invoiceSerialNumber = invoiceSerialNumber;
      this.invoiceAmount = invoiceAmount;
      this.actualInvoiceAmount = actualInvoiceAmount;
      this.remark = remark;
      this.attachments = attachments;
      this.boolFinalApprover = boolFinalApprover;
      this.orderInvoiceList = orderInvoiceList;
   }

   public SupplierInvoicePurchaseAuditDTO() {
   }

   public static class SupplierInvoicePurchaseAuditDTOBuilder {
      private Integer paymentEnum;
      private Boolean passButton;
      private Long applyUserId;
      private String applyUserName;
      private String projectName;
      private Integer projectAttribute;
      private List<String> serialNumber;
      private String supplierName;
      private Integer basicClass;
      private String basicClassName;
      private String invoiceSerialNumber;
      private BigDecimal invoiceAmount;
      private BigDecimal actualInvoiceAmount;
      private String remark;
      private List<AttachmentDTO> attachments;
      private Boolean boolFinalApprover;
      private List<SupplierSelfEmployedDto> orderInvoiceList;

      SupplierInvoicePurchaseAuditDTOBuilder() {
      }

      public SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder paymentEnum(final Integer paymentEnum) {
         this.paymentEnum = paymentEnum;
         return this;
      }

      public SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder passButton(final Boolean passButton) {
         this.passButton = passButton;
         return this;
      }

      public SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder applyUserId(final Long applyUserId) {
         this.applyUserId = applyUserId;
         return this;
      }

      public SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder applyUserName(final String applyUserName) {
         this.applyUserName = applyUserName;
         return this;
      }

      public SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder serialNumber(final List<String> serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder basicClassName(final String basicClassName) {
         this.basicClassName = basicClassName;
         return this;
      }

      public SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder invoiceSerialNumber(final String invoiceSerialNumber) {
         this.invoiceSerialNumber = invoiceSerialNumber;
         return this;
      }

      public SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder actualInvoiceAmount(final BigDecimal actualInvoiceAmount) {
         this.actualInvoiceAmount = actualInvoiceAmount;
         return this;
      }

      public SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder boolFinalApprover(final Boolean boolFinalApprover) {
         this.boolFinalApprover = boolFinalApprover;
         return this;
      }

      public SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder orderInvoiceList(final List<SupplierSelfEmployedDto> orderInvoiceList) {
         this.orderInvoiceList = orderInvoiceList;
         return this;
      }

      public SupplierInvoicePurchaseAuditDTO build() {
         return new SupplierInvoicePurchaseAuditDTO(
            this.paymentEnum,
            this.passButton,
            this.applyUserId,
            this.applyUserName,
            this.projectName,
            this.projectAttribute,
            this.serialNumber,
            this.supplierName,
            this.basicClass,
            this.basicClassName,
            this.invoiceSerialNumber,
            this.invoiceAmount,
            this.actualInvoiceAmount,
            this.remark,
            this.attachments,
            this.boolFinalApprover,
            this.orderInvoiceList
         );
      }

      @Override
      public String toString() {
         return "SupplierInvoicePurchaseAuditDTO.SupplierInvoicePurchaseAuditDTOBuilder(paymentEnum="
            + this.paymentEnum
            + ", passButton="
            + this.passButton
            + ", applyUserId="
            + this.applyUserId
            + ", applyUserName="
            + this.applyUserName
            + ", projectName="
            + this.projectName
            + ", projectAttribute="
            + this.projectAttribute
            + ", serialNumber="
            + this.serialNumber
            + ", supplierName="
            + this.supplierName
            + ", basicClass="
            + this.basicClass
            + ", basicClassName="
            + this.basicClassName
            + ", invoiceSerialNumber="
            + this.invoiceSerialNumber
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", actualInvoiceAmount="
            + this.actualInvoiceAmount
            + ", remark="
            + this.remark
            + ", attachments="
            + this.attachments
            + ", boolFinalApprover="
            + this.boolFinalApprover
            + ", orderInvoiceList="
            + this.orderInvoiceList
            + ")";
      }
   }
}
