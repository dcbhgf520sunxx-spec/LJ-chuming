package com.hzchum.scim.contract.core.api.pojo.dto.audit;

import com.hzchum.scim.contract.core.api.pojo.dto.project.ProjectSupplierDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.ProjectOutputInvoiceDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierAuditSelfEmployedDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSettlementEchoDto;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class AuditReplyDataDto {
   @ApiModelProperty("签约主体id")
   private Long branchCompanyId;
   @ApiModelProperty("签约主体名称")
   private String branchCompanyName;
   @ApiModelProperty("合同金额")
   private BigDecimal amount;
   @ApiModelProperty("物资类型")
   private Integer basicClass;
   @ApiModelProperty("结算金额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("本次发票额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("通过按钮")
   private Boolean passButton;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty(name = "serialNumber", value = "采购合同号", notes = "采购合同号")
   private List<String> serialNumber;
   @ApiModelProperty(name = "paymentEnum", value = "付款类型", notes = "付款类型")
   private Integer paymentEnum;
   @ApiModelProperty(name = "projectType", value = "自合营 or 内包制", notes = "自合营 or 内包制")
   private Integer projectType;
   @ApiModelProperty(name = "attachmentIds", value = "附件id", notes = "附件id")
   private String attachmentIds;
   @ApiModelProperty(name = "ProjectSupplierDto", value = "采购付款（内包）", notes = "采购付款（内包）")
   private ProjectSupplierDto projectSupplierDto;
   @ApiModelProperty(name = "SupplierAuditSelfEmployedDto", value = "采购付款（自合营）", notes = "采购付款（自合营）")
   private SupplierAuditSelfEmployedDto supplierAuditSelfEmployedDto;
   @ApiModelProperty(name = "supplierSettlementEchoDtoList", value = "付款开票信息回显（内包制and自合营通用）", notes = "付款开票信息回显（内包制and自合营通用）")
   private List<SupplierSettlementEchoDto> supplierSettlementEchoDtoList;
   @ApiModelProperty(name = "outputInvoice", value = "销项发票数据回显", notes = "销项发票数据回显")
   private ProjectOutputInvoiceDto outputInvoice;

   public static AuditReplyDataDto.AuditReplyDataDtoBuilder builder() {
      return new AuditReplyDataDto.AuditReplyDataDtoBuilder();
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

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public Boolean getPassButton() {
      return this.passButton;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public List<String> getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getPaymentEnum() {
      return this.paymentEnum;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public ProjectSupplierDto getProjectSupplierDto() {
      return this.projectSupplierDto;
   }

   public SupplierAuditSelfEmployedDto getSupplierAuditSelfEmployedDto() {
      return this.supplierAuditSelfEmployedDto;
   }

   public List<SupplierSettlementEchoDto> getSupplierSettlementEchoDtoList() {
      return this.supplierSettlementEchoDtoList;
   }

   public ProjectOutputInvoiceDto getOutputInvoice() {
      return this.outputInvoice;
   }

   public AuditReplyDataDto setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public AuditReplyDataDto setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
      return this;
   }

   public AuditReplyDataDto setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public AuditReplyDataDto setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public AuditReplyDataDto setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
      return this;
   }

   public AuditReplyDataDto setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
      return this;
   }

   public AuditReplyDataDto setPassButton(final Boolean passButton) {
      this.passButton = passButton;
      return this;
   }

   public AuditReplyDataDto setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public AuditReplyDataDto setSerialNumber(final List<String> serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public AuditReplyDataDto setPaymentEnum(final Integer paymentEnum) {
      this.paymentEnum = paymentEnum;
      return this;
   }

   public AuditReplyDataDto setProjectType(final Integer projectType) {
      this.projectType = projectType;
      return this;
   }

   public AuditReplyDataDto setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public AuditReplyDataDto setProjectSupplierDto(final ProjectSupplierDto projectSupplierDto) {
      this.projectSupplierDto = projectSupplierDto;
      return this;
   }

   public AuditReplyDataDto setSupplierAuditSelfEmployedDto(final SupplierAuditSelfEmployedDto supplierAuditSelfEmployedDto) {
      this.supplierAuditSelfEmployedDto = supplierAuditSelfEmployedDto;
      return this;
   }

   public AuditReplyDataDto setSupplierSettlementEchoDtoList(final List<SupplierSettlementEchoDto> supplierSettlementEchoDtoList) {
      this.supplierSettlementEchoDtoList = supplierSettlementEchoDtoList;
      return this;
   }

   public AuditReplyDataDto setOutputInvoice(final ProjectOutputInvoiceDto outputInvoice) {
      this.outputInvoice = outputInvoice;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AuditReplyDataDto)) {
         return false;
      }

      AuditReplyDataDto other = (AuditReplyDataDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$branchCompanyId = this.getBranchCompanyId();
      Object other$branchCompanyId = other.getBranchCompanyId();
      if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$passButton = this.getPassButton();
            Object other$passButton = other.getPassButton();
            if (this$passButton == null ? other$passButton == null : this$passButton.equals(other$passButton)) {
               Object this$paymentEnum = this.getPaymentEnum();
               Object other$paymentEnum = other.getPaymentEnum();
               if (this$paymentEnum == null ? other$paymentEnum == null : this$paymentEnum.equals(other$paymentEnum)) {
                  Object this$projectType = this.getProjectType();
                  Object other$projectType = other.getProjectType();
                  if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                     Object this$branchCompanyName = this.getBranchCompanyName();
                     Object other$branchCompanyName = other.getBranchCompanyName();
                     if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
                        Object this$amount = this.getAmount();
                        Object other$amount = other.getAmount();
                        if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                           Object this$settlementAmount = this.getSettlementAmount();
                           Object other$settlementAmount = other.getSettlementAmount();
                           if (this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount)) {
                              Object this$invoiceAmount = this.getInvoiceAmount();
                              Object other$invoiceAmount = other.getInvoiceAmount();
                              if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                                 Object this$projectName = this.getProjectName();
                                 Object other$projectName = other.getProjectName();
                                 if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$attachmentIds = this.getAttachmentIds();
                                       Object other$attachmentIds = other.getAttachmentIds();
                                       if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                                          Object this$projectSupplierDto = this.getProjectSupplierDto();
                                          Object other$projectSupplierDto = other.getProjectSupplierDto();
                                          if (this$projectSupplierDto == null
                                             ? other$projectSupplierDto == null
                                             : this$projectSupplierDto.equals(other$projectSupplierDto)) {
                                             Object this$supplierAuditSelfEmployedDto = this.getSupplierAuditSelfEmployedDto();
                                             Object other$supplierAuditSelfEmployedDto = other.getSupplierAuditSelfEmployedDto();
                                             if (this$supplierAuditSelfEmployedDto == null
                                                ? other$supplierAuditSelfEmployedDto == null
                                                : this$supplierAuditSelfEmployedDto.equals(other$supplierAuditSelfEmployedDto)) {
                                                Object this$supplierSettlementEchoDtoList = this.getSupplierSettlementEchoDtoList();
                                                Object other$supplierSettlementEchoDtoList = other.getSupplierSettlementEchoDtoList();
                                                if (this$supplierSettlementEchoDtoList == null
                                                   ? other$supplierSettlementEchoDtoList == null
                                                   : this$supplierSettlementEchoDtoList.equals(other$supplierSettlementEchoDtoList)) {
                                                   Object this$outputInvoice = this.getOutputInvoice();
                                                   Object other$outputInvoice = other.getOutputInvoice();
                                                   return this$outputInvoice == null
                                                      ? other$outputInvoice == null
                                                      : this$outputInvoice.equals(other$outputInvoice);
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
      return other instanceof AuditReplyDataDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $passButton = this.getPassButton();
      result = result * 59 + ($passButton == null ? 43 : $passButton.hashCode());
      Object $paymentEnum = this.getPaymentEnum();
      result = result * 59 + ($paymentEnum == null ? 43 : $paymentEnum.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $projectSupplierDto = this.getProjectSupplierDto();
      result = result * 59 + ($projectSupplierDto == null ? 43 : $projectSupplierDto.hashCode());
      Object $supplierAuditSelfEmployedDto = this.getSupplierAuditSelfEmployedDto();
      result = result * 59 + ($supplierAuditSelfEmployedDto == null ? 43 : $supplierAuditSelfEmployedDto.hashCode());
      Object $supplierSettlementEchoDtoList = this.getSupplierSettlementEchoDtoList();
      result = result * 59 + ($supplierSettlementEchoDtoList == null ? 43 : $supplierSettlementEchoDtoList.hashCode());
      Object $outputInvoice = this.getOutputInvoice();
      return result * 59 + ($outputInvoice == null ? 43 : $outputInvoice.hashCode());
   }

   @Override
   public String toString() {
      return "AuditReplyDataDto(branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", amount="
         + this.getAmount()
         + ", basicClass="
         + this.getBasicClass()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", passButton="
         + this.getPassButton()
         + ", projectName="
         + this.getProjectName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", paymentEnum="
         + this.getPaymentEnum()
         + ", projectType="
         + this.getProjectType()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", projectSupplierDto="
         + this.getProjectSupplierDto()
         + ", supplierAuditSelfEmployedDto="
         + this.getSupplierAuditSelfEmployedDto()
         + ", supplierSettlementEchoDtoList="
         + this.getSupplierSettlementEchoDtoList()
         + ", outputInvoice="
         + this.getOutputInvoice()
         + ")";
   }

   public AuditReplyDataDto(
      final Long branchCompanyId,
      final String branchCompanyName,
      final BigDecimal amount,
      final Integer basicClass,
      final BigDecimal settlementAmount,
      final BigDecimal invoiceAmount,
      final Boolean passButton,
      final String projectName,
      final List<String> serialNumber,
      final Integer paymentEnum,
      final Integer projectType,
      final String attachmentIds,
      final ProjectSupplierDto projectSupplierDto,
      final SupplierAuditSelfEmployedDto supplierAuditSelfEmployedDto,
      final List<SupplierSettlementEchoDto> supplierSettlementEchoDtoList,
      final ProjectOutputInvoiceDto outputInvoice
   ) {
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.amount = amount;
      this.basicClass = basicClass;
      this.settlementAmount = settlementAmount;
      this.invoiceAmount = invoiceAmount;
      this.passButton = passButton;
      this.projectName = projectName;
      this.serialNumber = serialNumber;
      this.paymentEnum = paymentEnum;
      this.projectType = projectType;
      this.attachmentIds = attachmentIds;
      this.projectSupplierDto = projectSupplierDto;
      this.supplierAuditSelfEmployedDto = supplierAuditSelfEmployedDto;
      this.supplierSettlementEchoDtoList = supplierSettlementEchoDtoList;
      this.outputInvoice = outputInvoice;
   }

   public AuditReplyDataDto() {
   }

   public static class AuditReplyDataDtoBuilder {
      private Long branchCompanyId;
      private String branchCompanyName;
      private BigDecimal amount;
      private Integer basicClass;
      private BigDecimal settlementAmount;
      private BigDecimal invoiceAmount;
      private Boolean passButton;
      private String projectName;
      private List<String> serialNumber;
      private Integer paymentEnum;
      private Integer projectType;
      private String attachmentIds;
      private ProjectSupplierDto projectSupplierDto;
      private SupplierAuditSelfEmployedDto supplierAuditSelfEmployedDto;
      private List<SupplierSettlementEchoDto> supplierSettlementEchoDtoList;
      private ProjectOutputInvoiceDto outputInvoice;

      AuditReplyDataDtoBuilder() {
      }

      public AuditReplyDataDto.AuditReplyDataDtoBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public AuditReplyDataDto.AuditReplyDataDtoBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public AuditReplyDataDto.AuditReplyDataDtoBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public AuditReplyDataDto.AuditReplyDataDtoBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public AuditReplyDataDto.AuditReplyDataDtoBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public AuditReplyDataDto.AuditReplyDataDtoBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public AuditReplyDataDto.AuditReplyDataDtoBuilder passButton(final Boolean passButton) {
         this.passButton = passButton;
         return this;
      }

      public AuditReplyDataDto.AuditReplyDataDtoBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public AuditReplyDataDto.AuditReplyDataDtoBuilder serialNumber(final List<String> serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public AuditReplyDataDto.AuditReplyDataDtoBuilder paymentEnum(final Integer paymentEnum) {
         this.paymentEnum = paymentEnum;
         return this;
      }

      public AuditReplyDataDto.AuditReplyDataDtoBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public AuditReplyDataDto.AuditReplyDataDtoBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public AuditReplyDataDto.AuditReplyDataDtoBuilder projectSupplierDto(final ProjectSupplierDto projectSupplierDto) {
         this.projectSupplierDto = projectSupplierDto;
         return this;
      }

      public AuditReplyDataDto.AuditReplyDataDtoBuilder supplierAuditSelfEmployedDto(final SupplierAuditSelfEmployedDto supplierAuditSelfEmployedDto) {
         this.supplierAuditSelfEmployedDto = supplierAuditSelfEmployedDto;
         return this;
      }

      public AuditReplyDataDto.AuditReplyDataDtoBuilder supplierSettlementEchoDtoList(final List<SupplierSettlementEchoDto> supplierSettlementEchoDtoList) {
         this.supplierSettlementEchoDtoList = supplierSettlementEchoDtoList;
         return this;
      }

      public AuditReplyDataDto.AuditReplyDataDtoBuilder outputInvoice(final ProjectOutputInvoiceDto outputInvoice) {
         this.outputInvoice = outputInvoice;
         return this;
      }

      public AuditReplyDataDto build() {
         return new AuditReplyDataDto(
            this.branchCompanyId,
            this.branchCompanyName,
            this.amount,
            this.basicClass,
            this.settlementAmount,
            this.invoiceAmount,
            this.passButton,
            this.projectName,
            this.serialNumber,
            this.paymentEnum,
            this.projectType,
            this.attachmentIds,
            this.projectSupplierDto,
            this.supplierAuditSelfEmployedDto,
            this.supplierSettlementEchoDtoList,
            this.outputInvoice
         );
      }

      @Override
      public String toString() {
         return "AuditReplyDataDto.AuditReplyDataDtoBuilder(branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", amount="
            + this.amount
            + ", basicClass="
            + this.basicClass
            + ", settlementAmount="
            + this.settlementAmount
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", passButton="
            + this.passButton
            + ", projectName="
            + this.projectName
            + ", serialNumber="
            + this.serialNumber
            + ", paymentEnum="
            + this.paymentEnum
            + ", projectType="
            + this.projectType
            + ", attachmentIds="
            + this.attachmentIds
            + ", projectSupplierDto="
            + this.projectSupplierDto
            + ", supplierAuditSelfEmployedDto="
            + this.supplierAuditSelfEmployedDto
            + ", supplierSettlementEchoDtoList="
            + this.supplierSettlementEchoDtoList
            + ", outputInvoice="
            + this.outputInvoice
            + ")";
      }
   }
}
