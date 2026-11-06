package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("项目结算返回类")
public class ProjectSettlementDTO {
   @ApiModelProperty(name = "passButton", value = "结算按钮")
   private Boolean passButton;
   @ApiModelProperty(name = "paymentEnum", value = "审批类型")
   private Integer paymentEnum;
   @ApiModelProperty(name = "projectManager", value = "项目经理id/项目负责人id")
   private NameInfo projectManager;
   @ApiModelProperty(name = "project", value = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "branchComment", value = "签订主体")
   private NameInfo branchComment;
   @ApiModelProperty(name = "customer_unit", notes = "客户单位名称")
   private String customerUnit;
   @ApiModelProperty(name = "contractProjectAmount", value = "合同额")
   private BigDecimal contractProjectAmount;
   @ApiModelProperty(name = "paymentAmount", value = "累计收款")
   private BigDecimal paymentAmount;
   @ApiModelProperty(name = "paymentRate", value = "收款率")
   private BigDecimal paymentRate;
   @ApiModelProperty(name = "invoiceAmount", value = "累计开票")
   private BigDecimal invoiceAmount;
   @ApiModelProperty(name = "invoiceRate", value = "开票率")
   private BigDecimal invoiceRate;
   @ApiModelProperty(name = "settlementAmount", value = "结算额")
   private BigDecimal settlementAmount;
   @ApiModelProperty(name = "settlementTime", value = "结算时间")
   private LocalDateTime settlementTime;
   @ApiModelProperty(name = "remainderPayment", value = "应收款")
   private BigDecimal remainderPayment;
   @ApiModelProperty(name = "remainderInvoice", value = "应开票")
   private BigDecimal remainderInvoice;
   @ApiModelProperty(name = "attachmentId", value = "审批id")
   private Long attachmentId;
   @ApiModelProperty(name = "attachmentIds", value = "附件id字符串")
   private String attachmentIds;
   @ApiModelProperty(name = "attachments", value = "附件")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty(name = "boolFinalApprover", value = "是否最后一个审批人", notes = "是否最后一个审批人")
   private Boolean boolFinalApprover;

   public static ProjectSettlementDTO.ProjectSettlementDTOBuilder builder() {
      return new ProjectSettlementDTO.ProjectSettlementDTOBuilder();
   }

   public Boolean getPassButton() {
      return this.passButton;
   }

   public Integer getPaymentEnum() {
      return this.paymentEnum;
   }

   public NameInfo getProjectManager() {
      return this.projectManager;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getBranchComment() {
      return this.branchComment;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public BigDecimal getContractProjectAmount() {
      return this.contractProjectAmount;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public BigDecimal getPaymentRate() {
      return this.paymentRate;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getInvoiceRate() {
      return this.invoiceRate;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public LocalDateTime getSettlementTime() {
      return this.settlementTime;
   }

   public BigDecimal getRemainderPayment() {
      return this.remainderPayment;
   }

   public BigDecimal getRemainderInvoice() {
      return this.remainderInvoice;
   }

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public Boolean getBoolFinalApprover() {
      return this.boolFinalApprover;
   }

   public void setPassButton(final Boolean passButton) {
      this.passButton = passButton;
   }

   public void setPaymentEnum(final Integer paymentEnum) {
      this.paymentEnum = paymentEnum;
   }

   public void setProjectManager(final NameInfo projectManager) {
      this.projectManager = projectManager;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setBranchComment(final NameInfo branchComment) {
      this.branchComment = branchComment;
   }

   public void setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
   }

   public void setContractProjectAmount(final BigDecimal contractProjectAmount) {
      this.contractProjectAmount = contractProjectAmount;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setPaymentRate(final BigDecimal paymentRate) {
      this.paymentRate = paymentRate;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setInvoiceRate(final BigDecimal invoiceRate) {
      this.invoiceRate = invoiceRate;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setSettlementTime(final LocalDateTime settlementTime) {
      this.settlementTime = settlementTime;
   }

   public void setRemainderPayment(final BigDecimal remainderPayment) {
      this.remainderPayment = remainderPayment;
   }

   public void setRemainderInvoice(final BigDecimal remainderInvoice) {
      this.remainderInvoice = remainderInvoice;
   }

   public void setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setBoolFinalApprover(final Boolean boolFinalApprover) {
      this.boolFinalApprover = boolFinalApprover;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSettlementDTO)) {
         return false;
      }

      ProjectSettlementDTO other = (ProjectSettlementDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$passButton = this.getPassButton();
      Object other$passButton = other.getPassButton();
      if (this$passButton == null ? other$passButton == null : this$passButton.equals(other$passButton)) {
         Object this$paymentEnum = this.getPaymentEnum();
         Object other$paymentEnum = other.getPaymentEnum();
         if (this$paymentEnum == null ? other$paymentEnum == null : this$paymentEnum.equals(other$paymentEnum)) {
            Object this$attachmentId = this.getAttachmentId();
            Object other$attachmentId = other.getAttachmentId();
            if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
               Object this$boolFinalApprover = this.getBoolFinalApprover();
               Object other$boolFinalApprover = other.getBoolFinalApprover();
               if (this$boolFinalApprover == null ? other$boolFinalApprover == null : this$boolFinalApprover.equals(other$boolFinalApprover)) {
                  Object this$projectManager = this.getProjectManager();
                  Object other$projectManager = other.getProjectManager();
                  if (this$projectManager == null ? other$projectManager == null : this$projectManager.equals(other$projectManager)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$branchComment = this.getBranchComment();
                        Object other$branchComment = other.getBranchComment();
                        if (this$branchComment == null ? other$branchComment == null : this$branchComment.equals(other$branchComment)) {
                           Object this$customerUnit = this.getCustomerUnit();
                           Object other$customerUnit = other.getCustomerUnit();
                           if (this$customerUnit == null ? other$customerUnit == null : this$customerUnit.equals(other$customerUnit)) {
                              Object this$contractProjectAmount = this.getContractProjectAmount();
                              Object other$contractProjectAmount = other.getContractProjectAmount();
                              if (this$contractProjectAmount == null
                                 ? other$contractProjectAmount == null
                                 : this$contractProjectAmount.equals(other$contractProjectAmount)) {
                                 Object this$paymentAmount = this.getPaymentAmount();
                                 Object other$paymentAmount = other.getPaymentAmount();
                                 if (this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount)) {
                                    Object this$paymentRate = this.getPaymentRate();
                                    Object other$paymentRate = other.getPaymentRate();
                                    if (this$paymentRate == null ? other$paymentRate == null : this$paymentRate.equals(other$paymentRate)) {
                                       Object this$invoiceAmount = this.getInvoiceAmount();
                                       Object other$invoiceAmount = other.getInvoiceAmount();
                                       if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                                          Object this$invoiceRate = this.getInvoiceRate();
                                          Object other$invoiceRate = other.getInvoiceRate();
                                          if (this$invoiceRate == null ? other$invoiceRate == null : this$invoiceRate.equals(other$invoiceRate)) {
                                             Object this$settlementAmount = this.getSettlementAmount();
                                             Object other$settlementAmount = other.getSettlementAmount();
                                             if (this$settlementAmount == null
                                                ? other$settlementAmount == null
                                                : this$settlementAmount.equals(other$settlementAmount)) {
                                                Object this$settlementTime = this.getSettlementTime();
                                                Object other$settlementTime = other.getSettlementTime();
                                                if (this$settlementTime == null
                                                   ? other$settlementTime == null
                                                   : this$settlementTime.equals(other$settlementTime)) {
                                                   Object this$remainderPayment = this.getRemainderPayment();
                                                   Object other$remainderPayment = other.getRemainderPayment();
                                                   if (this$remainderPayment == null
                                                      ? other$remainderPayment == null
                                                      : this$remainderPayment.equals(other$remainderPayment)) {
                                                      Object this$remainderInvoice = this.getRemainderInvoice();
                                                      Object other$remainderInvoice = other.getRemainderInvoice();
                                                      if (this$remainderInvoice == null
                                                         ? other$remainderInvoice == null
                                                         : this$remainderInvoice.equals(other$remainderInvoice)) {
                                                         Object this$attachmentIds = this.getAttachmentIds();
                                                         Object other$attachmentIds = other.getAttachmentIds();
                                                         if (this$attachmentIds == null
                                                            ? other$attachmentIds == null
                                                            : this$attachmentIds.equals(other$attachmentIds)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectSettlementDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $passButton = this.getPassButton();
      result = result * 59 + ($passButton == null ? 43 : $passButton.hashCode());
      Object $paymentEnum = this.getPaymentEnum();
      result = result * 59 + ($paymentEnum == null ? 43 : $paymentEnum.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $boolFinalApprover = this.getBoolFinalApprover();
      result = result * 59 + ($boolFinalApprover == null ? 43 : $boolFinalApprover.hashCode());
      Object $projectManager = this.getProjectManager();
      result = result * 59 + ($projectManager == null ? 43 : $projectManager.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $branchComment = this.getBranchComment();
      result = result * 59 + ($branchComment == null ? 43 : $branchComment.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $contractProjectAmount = this.getContractProjectAmount();
      result = result * 59 + ($contractProjectAmount == null ? 43 : $contractProjectAmount.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $paymentRate = this.getPaymentRate();
      result = result * 59 + ($paymentRate == null ? 43 : $paymentRate.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $invoiceRate = this.getInvoiceRate();
      result = result * 59 + ($invoiceRate == null ? 43 : $invoiceRate.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $settlementTime = this.getSettlementTime();
      result = result * 59 + ($settlementTime == null ? 43 : $settlementTime.hashCode());
      Object $remainderPayment = this.getRemainderPayment();
      result = result * 59 + ($remainderPayment == null ? 43 : $remainderPayment.hashCode());
      Object $remainderInvoice = this.getRemainderInvoice();
      result = result * 59 + ($remainderInvoice == null ? 43 : $remainderInvoice.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachments = this.getAttachments();
      return result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSettlementDTO(passButton="
         + this.getPassButton()
         + ", paymentEnum="
         + this.getPaymentEnum()
         + ", projectManager="
         + this.getProjectManager()
         + ", project="
         + this.getProject()
         + ", branchComment="
         + this.getBranchComment()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ", contractProjectAmount="
         + this.getContractProjectAmount()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", paymentRate="
         + this.getPaymentRate()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", invoiceRate="
         + this.getInvoiceRate()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", settlementTime="
         + this.getSettlementTime()
         + ", remainderPayment="
         + this.getRemainderPayment()
         + ", remainderInvoice="
         + this.getRemainderInvoice()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachments="
         + this.getAttachments()
         + ", boolFinalApprover="
         + this.getBoolFinalApprover()
         + ")";
   }

   public ProjectSettlementDTO(
      final Boolean passButton,
      final Integer paymentEnum,
      final NameInfo projectManager,
      final ProjectInfo project,
      final NameInfo branchComment,
      final String customerUnit,
      final BigDecimal contractProjectAmount,
      final BigDecimal paymentAmount,
      final BigDecimal paymentRate,
      final BigDecimal invoiceAmount,
      final BigDecimal invoiceRate,
      final BigDecimal settlementAmount,
      final LocalDateTime settlementTime,
      final BigDecimal remainderPayment,
      final BigDecimal remainderInvoice,
      final Long attachmentId,
      final String attachmentIds,
      final List<AttachmentDTO> attachments,
      final Boolean boolFinalApprover
   ) {
      this.passButton = passButton;
      this.paymentEnum = paymentEnum;
      this.projectManager = projectManager;
      this.project = project;
      this.branchComment = branchComment;
      this.customerUnit = customerUnit;
      this.contractProjectAmount = contractProjectAmount;
      this.paymentAmount = paymentAmount;
      this.paymentRate = paymentRate;
      this.invoiceAmount = invoiceAmount;
      this.invoiceRate = invoiceRate;
      this.settlementAmount = settlementAmount;
      this.settlementTime = settlementTime;
      this.remainderPayment = remainderPayment;
      this.remainderInvoice = remainderInvoice;
      this.attachmentId = attachmentId;
      this.attachmentIds = attachmentIds;
      this.attachments = attachments;
      this.boolFinalApprover = boolFinalApprover;
   }

   public ProjectSettlementDTO() {
   }

   public static class ProjectSettlementDTOBuilder {
      private Boolean passButton;
      private Integer paymentEnum;
      private NameInfo projectManager;
      private ProjectInfo project;
      private NameInfo branchComment;
      private String customerUnit;
      private BigDecimal contractProjectAmount;
      private BigDecimal paymentAmount;
      private BigDecimal paymentRate;
      private BigDecimal invoiceAmount;
      private BigDecimal invoiceRate;
      private BigDecimal settlementAmount;
      private LocalDateTime settlementTime;
      private BigDecimal remainderPayment;
      private BigDecimal remainderInvoice;
      private Long attachmentId;
      private String attachmentIds;
      private List<AttachmentDTO> attachments;
      private Boolean boolFinalApprover;

      ProjectSettlementDTOBuilder() {
      }

      public ProjectSettlementDTO.ProjectSettlementDTOBuilder passButton(final Boolean passButton) {
         this.passButton = passButton;
         return this;
      }

      public ProjectSettlementDTO.ProjectSettlementDTOBuilder paymentEnum(final Integer paymentEnum) {
         this.paymentEnum = paymentEnum;
         return this;
      }

      public ProjectSettlementDTO.ProjectSettlementDTOBuilder projectManager(final NameInfo projectManager) {
         this.projectManager = projectManager;
         return this;
      }

      public ProjectSettlementDTO.ProjectSettlementDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectSettlementDTO.ProjectSettlementDTOBuilder branchComment(final NameInfo branchComment) {
         this.branchComment = branchComment;
         return this;
      }

      public ProjectSettlementDTO.ProjectSettlementDTOBuilder customerUnit(final String customerUnit) {
         this.customerUnit = customerUnit;
         return this;
      }

      public ProjectSettlementDTO.ProjectSettlementDTOBuilder contractProjectAmount(final BigDecimal contractProjectAmount) {
         this.contractProjectAmount = contractProjectAmount;
         return this;
      }

      public ProjectSettlementDTO.ProjectSettlementDTOBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public ProjectSettlementDTO.ProjectSettlementDTOBuilder paymentRate(final BigDecimal paymentRate) {
         this.paymentRate = paymentRate;
         return this;
      }

      public ProjectSettlementDTO.ProjectSettlementDTOBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public ProjectSettlementDTO.ProjectSettlementDTOBuilder invoiceRate(final BigDecimal invoiceRate) {
         this.invoiceRate = invoiceRate;
         return this;
      }

      public ProjectSettlementDTO.ProjectSettlementDTOBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public ProjectSettlementDTO.ProjectSettlementDTOBuilder settlementTime(final LocalDateTime settlementTime) {
         this.settlementTime = settlementTime;
         return this;
      }

      public ProjectSettlementDTO.ProjectSettlementDTOBuilder remainderPayment(final BigDecimal remainderPayment) {
         this.remainderPayment = remainderPayment;
         return this;
      }

      public ProjectSettlementDTO.ProjectSettlementDTOBuilder remainderInvoice(final BigDecimal remainderInvoice) {
         this.remainderInvoice = remainderInvoice;
         return this;
      }

      public ProjectSettlementDTO.ProjectSettlementDTOBuilder attachmentId(final Long attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public ProjectSettlementDTO.ProjectSettlementDTOBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ProjectSettlementDTO.ProjectSettlementDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public ProjectSettlementDTO.ProjectSettlementDTOBuilder boolFinalApprover(final Boolean boolFinalApprover) {
         this.boolFinalApprover = boolFinalApprover;
         return this;
      }

      public ProjectSettlementDTO build() {
         return new ProjectSettlementDTO(
            this.passButton,
            this.paymentEnum,
            this.projectManager,
            this.project,
            this.branchComment,
            this.customerUnit,
            this.contractProjectAmount,
            this.paymentAmount,
            this.paymentRate,
            this.invoiceAmount,
            this.invoiceRate,
            this.settlementAmount,
            this.settlementTime,
            this.remainderPayment,
            this.remainderInvoice,
            this.attachmentId,
            this.attachmentIds,
            this.attachments,
            this.boolFinalApprover
         );
      }

      @Override
      public String toString() {
         return "ProjectSettlementDTO.ProjectSettlementDTOBuilder(passButton="
            + this.passButton
            + ", paymentEnum="
            + this.paymentEnum
            + ", projectManager="
            + this.projectManager
            + ", project="
            + this.project
            + ", branchComment="
            + this.branchComment
            + ", customerUnit="
            + this.customerUnit
            + ", contractProjectAmount="
            + this.contractProjectAmount
            + ", paymentAmount="
            + this.paymentAmount
            + ", paymentRate="
            + this.paymentRate
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", invoiceRate="
            + this.invoiceRate
            + ", settlementAmount="
            + this.settlementAmount
            + ", settlementTime="
            + this.settlementTime
            + ", remainderPayment="
            + this.remainderPayment
            + ", remainderInvoice="
            + this.remainderInvoice
            + ", attachmentId="
            + this.attachmentId
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachments="
            + this.attachments
            + ", boolFinalApprover="
            + this.boolFinalApprover
            + ")";
      }
   }
}
