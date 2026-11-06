package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSettlementEchoDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ApiModel("付款开票信息回显（内包制and自合营通用）")
public class SupplierSettlementDto {
   @ApiModelProperty(name = "passButton", value = "结算按钮")
   private Boolean passButton;
   @ApiModelProperty(name = "paymentEnum", value = "审批类型")
   private Integer paymentEnum;
   @ApiModelProperty(name = "boolFinalApprover", value = "是否最后一个审批人")
   private Boolean boolFinalApprover;
   @ApiModelProperty("申请人id")
   private Long applyUserId;
   @ApiModelProperty("申请人名称")
   private String applyUserName;
   @ApiModelProperty("申请日期")
   private LocalDate applyDate;
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("签约主体id")
   private Long branchCompanyId;
   @ApiModelProperty("签约主体名称")
   private String branchCompanyName;
   @ApiModelProperty("供应商id")
   private Long supplierId;
   @ApiModelProperty("供应商名称")
   private String supplierName;
   @ApiModelProperty("项目类型")
   private Integer projectAttribute;
   @ApiModelProperty("采购/分包合同号")
   private String contractNumber;
   @ApiModelProperty("合同金额")
   private BigDecimal amount;
   @ApiModelProperty("物资类型")
   private Integer basicClass;
   @ApiModelProperty("物资类型")
   private String basicClassName;
   @ApiModelProperty("分包类别id")
   private Long subcontractClassId;
   @ApiModelProperty("分包类别")
   private String subcontractClassName;
   @ApiModelProperty("结算金额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("附件列表")
   private List<AttachmentDTO> attachmentList;
   @ApiModelProperty("付款及发票记录")
   private List<SupplierSettlementEchoDto> dto;

   public static SupplierSettlementDto.SupplierSettlementDtoBuilder builder() {
      return new SupplierSettlementDto.SupplierSettlementDtoBuilder();
   }

   public SupplierSettlementDto(
      final Boolean passButton,
      final Integer paymentEnum,
      final Boolean boolFinalApprover,
      final Long applyUserId,
      final String applyUserName,
      final LocalDate applyDate,
      final Long projectId,
      final String projectName,
      final Long branchCompanyId,
      final String branchCompanyName,
      final Long supplierId,
      final String supplierName,
      final Integer projectAttribute,
      final String contractNumber,
      final BigDecimal amount,
      final Integer basicClass,
      final String basicClassName,
      final Long subcontractClassId,
      final String subcontractClassName,
      final BigDecimal settlementAmount,
      final String remark,
      final List<AttachmentDTO> attachmentList,
      final List<SupplierSettlementEchoDto> dto
   ) {
      this.passButton = passButton;
      this.paymentEnum = paymentEnum;
      this.boolFinalApprover = boolFinalApprover;
      this.applyUserId = applyUserId;
      this.applyUserName = applyUserName;
      this.applyDate = applyDate;
      this.projectId = projectId;
      this.projectName = projectName;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.projectAttribute = projectAttribute;
      this.contractNumber = contractNumber;
      this.amount = amount;
      this.basicClass = basicClass;
      this.basicClassName = basicClassName;
      this.subcontractClassId = subcontractClassId;
      this.subcontractClassName = subcontractClassName;
      this.settlementAmount = settlementAmount;
      this.remark = remark;
      this.attachmentList = attachmentList;
      this.dto = dto;
   }

   public SupplierSettlementDto() {
   }

   public Boolean getPassButton() {
      return this.passButton;
   }

   public Integer getPaymentEnum() {
      return this.paymentEnum;
   }

   public Boolean getBoolFinalApprover() {
      return this.boolFinalApprover;
   }

   public Long getApplyUserId() {
      return this.applyUserId;
   }

   public String getApplyUserName() {
      return this.applyUserName;
   }

   public LocalDate getApplyDate() {
      return this.applyDate;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
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

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public String getContractNumber() {
      return this.contractNumber;
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

   public Long getSubcontractClassId() {
      return this.subcontractClassId;
   }

   public String getSubcontractClassName() {
      return this.subcontractClassName;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<AttachmentDTO> getAttachmentList() {
      return this.attachmentList;
   }

   public List<SupplierSettlementEchoDto> getDto() {
      return this.dto;
   }

   public SupplierSettlementDto setPassButton(final Boolean passButton) {
      this.passButton = passButton;
      return this;
   }

   public SupplierSettlementDto setPaymentEnum(final Integer paymentEnum) {
      this.paymentEnum = paymentEnum;
      return this;
   }

   public SupplierSettlementDto setBoolFinalApprover(final Boolean boolFinalApprover) {
      this.boolFinalApprover = boolFinalApprover;
      return this;
   }

   public SupplierSettlementDto setApplyUserId(final Long applyUserId) {
      this.applyUserId = applyUserId;
      return this;
   }

   public SupplierSettlementDto setApplyUserName(final String applyUserName) {
      this.applyUserName = applyUserName;
      return this;
   }

   public SupplierSettlementDto setApplyDate(final LocalDate applyDate) {
      this.applyDate = applyDate;
      return this;
   }

   public SupplierSettlementDto setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public SupplierSettlementDto setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public SupplierSettlementDto setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public SupplierSettlementDto setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
      return this;
   }

   public SupplierSettlementDto setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public SupplierSettlementDto setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public SupplierSettlementDto setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   public SupplierSettlementDto setContractNumber(final String contractNumber) {
      this.contractNumber = contractNumber;
      return this;
   }

   public SupplierSettlementDto setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public SupplierSettlementDto setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public SupplierSettlementDto setBasicClassName(final String basicClassName) {
      this.basicClassName = basicClassName;
      return this;
   }

   public SupplierSettlementDto setSubcontractClassId(final Long subcontractClassId) {
      this.subcontractClassId = subcontractClassId;
      return this;
   }

   public SupplierSettlementDto setSubcontractClassName(final String subcontractClassName) {
      this.subcontractClassName = subcontractClassName;
      return this;
   }

   public SupplierSettlementDto setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
      return this;
   }

   public SupplierSettlementDto setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public SupplierSettlementDto setAttachmentList(final List<AttachmentDTO> attachmentList) {
      this.attachmentList = attachmentList;
      return this;
   }

   public SupplierSettlementDto setDto(final List<SupplierSettlementEchoDto> dto) {
      this.dto = dto;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierSettlementDto)) {
         return false;
      }

      SupplierSettlementDto other = (SupplierSettlementDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$passButton = this.getPassButton();
      Object other$passButton = other.getPassButton();
      if (this$passButton == null ? other$passButton == null : this$passButton.equals(other$passButton)) {
         Object this$paymentEnum = this.getPaymentEnum();
         Object other$paymentEnum = other.getPaymentEnum();
         if (this$paymentEnum == null ? other$paymentEnum == null : this$paymentEnum.equals(other$paymentEnum)) {
            Object this$boolFinalApprover = this.getBoolFinalApprover();
            Object other$boolFinalApprover = other.getBoolFinalApprover();
            if (this$boolFinalApprover == null ? other$boolFinalApprover == null : this$boolFinalApprover.equals(other$boolFinalApprover)) {
               Object this$applyUserId = this.getApplyUserId();
               Object other$applyUserId = other.getApplyUserId();
               if (this$applyUserId == null ? other$applyUserId == null : this$applyUserId.equals(other$applyUserId)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$branchCompanyId = this.getBranchCompanyId();
                     Object other$branchCompanyId = other.getBranchCompanyId();
                     if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                        Object this$supplierId = this.getSupplierId();
                        Object other$supplierId = other.getSupplierId();
                        if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                           Object this$projectAttribute = this.getProjectAttribute();
                           Object other$projectAttribute = other.getProjectAttribute();
                           if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                              Object this$basicClass = this.getBasicClass();
                              Object other$basicClass = other.getBasicClass();
                              if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                                 Object this$subcontractClassId = this.getSubcontractClassId();
                                 Object other$subcontractClassId = other.getSubcontractClassId();
                                 if (this$subcontractClassId == null
                                    ? other$subcontractClassId == null
                                    : this$subcontractClassId.equals(other$subcontractClassId)) {
                                    Object this$applyUserName = this.getApplyUserName();
                                    Object other$applyUserName = other.getApplyUserName();
                                    if (this$applyUserName == null ? other$applyUserName == null : this$applyUserName.equals(other$applyUserName)) {
                                       Object this$applyDate = this.getApplyDate();
                                       Object other$applyDate = other.getApplyDate();
                                       if (this$applyDate == null ? other$applyDate == null : this$applyDate.equals(other$applyDate)) {
                                          Object this$projectName = this.getProjectName();
                                          Object other$projectName = other.getProjectName();
                                          if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                             Object this$branchCompanyName = this.getBranchCompanyName();
                                             Object other$branchCompanyName = other.getBranchCompanyName();
                                             if (this$branchCompanyName == null
                                                ? other$branchCompanyName == null
                                                : this$branchCompanyName.equals(other$branchCompanyName)) {
                                                Object this$supplierName = this.getSupplierName();
                                                Object other$supplierName = other.getSupplierName();
                                                if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                                   Object this$contractNumber = this.getContractNumber();
                                                   Object other$contractNumber = other.getContractNumber();
                                                   if (this$contractNumber == null
                                                      ? other$contractNumber == null
                                                      : this$contractNumber.equals(other$contractNumber)) {
                                                      Object this$amount = this.getAmount();
                                                      Object other$amount = other.getAmount();
                                                      if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                         Object this$basicClassName = this.getBasicClassName();
                                                         Object other$basicClassName = other.getBasicClassName();
                                                         if (this$basicClassName == null
                                                            ? other$basicClassName == null
                                                            : this$basicClassName.equals(other$basicClassName)) {
                                                            Object this$subcontractClassName = this.getSubcontractClassName();
                                                            Object other$subcontractClassName = other.getSubcontractClassName();
                                                            if (this$subcontractClassName == null
                                                               ? other$subcontractClassName == null
                                                               : this$subcontractClassName.equals(other$subcontractClassName)) {
                                                               Object this$settlementAmount = this.getSettlementAmount();
                                                               Object other$settlementAmount = other.getSettlementAmount();
                                                               if (this$settlementAmount == null
                                                                  ? other$settlementAmount == null
                                                                  : this$settlementAmount.equals(other$settlementAmount)) {
                                                                  Object this$remark = this.getRemark();
                                                                  Object other$remark = other.getRemark();
                                                                  if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                     Object this$attachmentList = this.getAttachmentList();
                                                                     Object other$attachmentList = other.getAttachmentList();
                                                                     if (this$attachmentList == null
                                                                        ? other$attachmentList == null
                                                                        : this$attachmentList.equals(other$attachmentList)) {
                                                                        Object this$dto = this.getDto();
                                                                        Object other$dto = other.getDto();
                                                                        return this$dto == null ? other$dto == null : this$dto.equals(other$dto);
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
      return other instanceof SupplierSettlementDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $passButton = this.getPassButton();
      result = result * 59 + ($passButton == null ? 43 : $passButton.hashCode());
      Object $paymentEnum = this.getPaymentEnum();
      result = result * 59 + ($paymentEnum == null ? 43 : $paymentEnum.hashCode());
      Object $boolFinalApprover = this.getBoolFinalApprover();
      result = result * 59 + ($boolFinalApprover == null ? 43 : $boolFinalApprover.hashCode());
      Object $applyUserId = this.getApplyUserId();
      result = result * 59 + ($applyUserId == null ? 43 : $applyUserId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $subcontractClassId = this.getSubcontractClassId();
      result = result * 59 + ($subcontractClassId == null ? 43 : $subcontractClassId.hashCode());
      Object $applyUserName = this.getApplyUserName();
      result = result * 59 + ($applyUserName == null ? 43 : $applyUserName.hashCode());
      Object $applyDate = this.getApplyDate();
      result = result * 59 + ($applyDate == null ? 43 : $applyDate.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $contractNumber = this.getContractNumber();
      result = result * 59 + ($contractNumber == null ? 43 : $contractNumber.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $basicClassName = this.getBasicClassName();
      result = result * 59 + ($basicClassName == null ? 43 : $basicClassName.hashCode());
      Object $subcontractClassName = this.getSubcontractClassName();
      result = result * 59 + ($subcontractClassName == null ? 43 : $subcontractClassName.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachmentList = this.getAttachmentList();
      result = result * 59 + ($attachmentList == null ? 43 : $attachmentList.hashCode());
      Object $dto = this.getDto();
      return result * 59 + ($dto == null ? 43 : $dto.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierSettlementDto(passButton="
         + this.getPassButton()
         + ", paymentEnum="
         + this.getPaymentEnum()
         + ", boolFinalApprover="
         + this.getBoolFinalApprover()
         + ", applyUserId="
         + this.getApplyUserId()
         + ", applyUserName="
         + this.getApplyUserName()
         + ", applyDate="
         + this.getApplyDate()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", contractNumber="
         + this.getContractNumber()
         + ", amount="
         + this.getAmount()
         + ", basicClass="
         + this.getBasicClass()
         + ", basicClassName="
         + this.getBasicClassName()
         + ", subcontractClassId="
         + this.getSubcontractClassId()
         + ", subcontractClassName="
         + this.getSubcontractClassName()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", remark="
         + this.getRemark()
         + ", attachmentList="
         + this.getAttachmentList()
         + ", dto="
         + this.getDto()
         + ")";
   }

   public static class SupplierSettlementDtoBuilder {
      private Boolean passButton;
      private Integer paymentEnum;
      private Boolean boolFinalApprover;
      private Long applyUserId;
      private String applyUserName;
      private LocalDate applyDate;
      private Long projectId;
      private String projectName;
      private Long branchCompanyId;
      private String branchCompanyName;
      private Long supplierId;
      private String supplierName;
      private Integer projectAttribute;
      private String contractNumber;
      private BigDecimal amount;
      private Integer basicClass;
      private String basicClassName;
      private Long subcontractClassId;
      private String subcontractClassName;
      private BigDecimal settlementAmount;
      private String remark;
      private List<AttachmentDTO> attachmentList;
      private List<SupplierSettlementEchoDto> dto;

      SupplierSettlementDtoBuilder() {
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder passButton(final Boolean passButton) {
         this.passButton = passButton;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder paymentEnum(final Integer paymentEnum) {
         this.paymentEnum = paymentEnum;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder boolFinalApprover(final Boolean boolFinalApprover) {
         this.boolFinalApprover = boolFinalApprover;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder applyUserId(final Long applyUserId) {
         this.applyUserId = applyUserId;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder applyUserName(final String applyUserName) {
         this.applyUserName = applyUserName;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder applyDate(final LocalDate applyDate) {
         this.applyDate = applyDate;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder contractNumber(final String contractNumber) {
         this.contractNumber = contractNumber;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder basicClassName(final String basicClassName) {
         this.basicClassName = basicClassName;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder subcontractClassName(final String subcontractClassName) {
         this.subcontractClassName = subcontractClassName;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder attachmentList(final List<AttachmentDTO> attachmentList) {
         this.attachmentList = attachmentList;
         return this;
      }

      public SupplierSettlementDto.SupplierSettlementDtoBuilder dto(final List<SupplierSettlementEchoDto> dto) {
         this.dto = dto;
         return this;
      }

      public SupplierSettlementDto build() {
         return new SupplierSettlementDto(
            this.passButton,
            this.paymentEnum,
            this.boolFinalApprover,
            this.applyUserId,
            this.applyUserName,
            this.applyDate,
            this.projectId,
            this.projectName,
            this.branchCompanyId,
            this.branchCompanyName,
            this.supplierId,
            this.supplierName,
            this.projectAttribute,
            this.contractNumber,
            this.amount,
            this.basicClass,
            this.basicClassName,
            this.subcontractClassId,
            this.subcontractClassName,
            this.settlementAmount,
            this.remark,
            this.attachmentList,
            this.dto
         );
      }

      @Override
      public String toString() {
         return "SupplierSettlementDto.SupplierSettlementDtoBuilder(passButton="
            + this.passButton
            + ", paymentEnum="
            + this.paymentEnum
            + ", boolFinalApprover="
            + this.boolFinalApprover
            + ", applyUserId="
            + this.applyUserId
            + ", applyUserName="
            + this.applyUserName
            + ", applyDate="
            + this.applyDate
            + ", projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", projectAttribute="
            + this.projectAttribute
            + ", contractNumber="
            + this.contractNumber
            + ", amount="
            + this.amount
            + ", basicClass="
            + this.basicClass
            + ", basicClassName="
            + this.basicClassName
            + ", subcontractClassId="
            + this.subcontractClassId
            + ", subcontractClassName="
            + this.subcontractClassName
            + ", settlementAmount="
            + this.settlementAmount
            + ", remark="
            + this.remark
            + ", attachmentList="
            + this.attachmentList
            + ", dto="
            + this.dto
            + ")";
      }
   }
}
