package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("项目执行台账 返回类")
public class ProjectLedgerV2DTO {
   @ApiModelProperty(name = "project", value = "项目信息")
   private ProjectInfo project;
   @ApiModelProperty(name = "contractAmount", value = "合同额")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "status", value = "状态")
   private Integer status;
   @ApiModelProperty(name = "settlementAmount", value = "结算额")
   private BigDecimal settlementAmount;
   @ApiModelProperty(name = "injectionAmount", value = "注资额")
   private BigDecimal injectionAmount;
   @ApiModelProperty(name = "collectionAmountSum", value = "累计收款")
   private BigDecimal collectionAmountSum;
   @ApiModelProperty(name = "invoiceAmountSum", value = "累计开票")
   private BigDecimal invoiceAmountSum;
   @ApiModelProperty(name = "paymentAmountSum", value = "累计支出")
   private BigDecimal paymentAmountSum;
   @ApiModelProperty(name = "creditAmount", value = "授信额度")
   private BigDecimal creditAmount;
   @ApiModelProperty(name = "projectSummary", value = "项目结余")
   private BigDecimal projectSummary;

   ProjectLedgerV2DTO(
      final ProjectInfo project,
      final BigDecimal contractAmount,
      final Integer status,
      final BigDecimal settlementAmount,
      final BigDecimal injectionAmount,
      final BigDecimal collectionAmountSum,
      final BigDecimal invoiceAmountSum,
      final BigDecimal paymentAmountSum,
      final BigDecimal creditAmount,
      final BigDecimal projectSummary
   ) {
      this.project = project;
      this.contractAmount = contractAmount;
      this.status = status;
      this.settlementAmount = settlementAmount;
      this.injectionAmount = injectionAmount;
      this.collectionAmountSum = collectionAmountSum;
      this.invoiceAmountSum = invoiceAmountSum;
      this.paymentAmountSum = paymentAmountSum;
      this.creditAmount = creditAmount;
      this.projectSummary = projectSummary;
   }

   public static ProjectLedgerV2DTO.ProjectLedgerV2DTOBuilder builder() {
      return new ProjectLedgerV2DTO.ProjectLedgerV2DTOBuilder();
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public Integer getStatus() {
      return this.status;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getInjectionAmount() {
      return this.injectionAmount;
   }

   public BigDecimal getCollectionAmountSum() {
      return this.collectionAmountSum;
   }

   public BigDecimal getInvoiceAmountSum() {
      return this.invoiceAmountSum;
   }

   public BigDecimal getPaymentAmountSum() {
      return this.paymentAmountSum;
   }

   public BigDecimal getCreditAmount() {
      return this.creditAmount;
   }

   public BigDecimal getProjectSummary() {
      return this.projectSummary;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setInjectionAmount(final BigDecimal injectionAmount) {
      this.injectionAmount = injectionAmount;
   }

   public void setCollectionAmountSum(final BigDecimal collectionAmountSum) {
      this.collectionAmountSum = collectionAmountSum;
   }

   public void setInvoiceAmountSum(final BigDecimal invoiceAmountSum) {
      this.invoiceAmountSum = invoiceAmountSum;
   }

   public void setPaymentAmountSum(final BigDecimal paymentAmountSum) {
      this.paymentAmountSum = paymentAmountSum;
   }

   public void setCreditAmount(final BigDecimal creditAmount) {
      this.creditAmount = creditAmount;
   }

   public void setProjectSummary(final BigDecimal projectSummary) {
      this.projectSummary = projectSummary;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectLedgerV2DTO)) {
         return false;
      }

      ProjectLedgerV2DTO other = (ProjectLedgerV2DTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$status = this.getStatus();
      Object other$status = other.getStatus();
      if (this$status == null ? other$status == null : this$status.equals(other$status)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
            Object this$contractAmount = this.getContractAmount();
            Object other$contractAmount = other.getContractAmount();
            if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
               Object this$settlementAmount = this.getSettlementAmount();
               Object other$settlementAmount = other.getSettlementAmount();
               if (this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount)) {
                  Object this$injectionAmount = this.getInjectionAmount();
                  Object other$injectionAmount = other.getInjectionAmount();
                  if (this$injectionAmount == null ? other$injectionAmount == null : this$injectionAmount.equals(other$injectionAmount)) {
                     Object this$collectionAmountSum = this.getCollectionAmountSum();
                     Object other$collectionAmountSum = other.getCollectionAmountSum();
                     if (this$collectionAmountSum == null ? other$collectionAmountSum == null : this$collectionAmountSum.equals(other$collectionAmountSum)) {
                        Object this$invoiceAmountSum = this.getInvoiceAmountSum();
                        Object other$invoiceAmountSum = other.getInvoiceAmountSum();
                        if (this$invoiceAmountSum == null ? other$invoiceAmountSum == null : this$invoiceAmountSum.equals(other$invoiceAmountSum)) {
                           Object this$paymentAmountSum = this.getPaymentAmountSum();
                           Object other$paymentAmountSum = other.getPaymentAmountSum();
                           if (this$paymentAmountSum == null ? other$paymentAmountSum == null : this$paymentAmountSum.equals(other$paymentAmountSum)) {
                              Object this$creditAmount = this.getCreditAmount();
                              Object other$creditAmount = other.getCreditAmount();
                              if (this$creditAmount == null ? other$creditAmount == null : this$creditAmount.equals(other$creditAmount)) {
                                 Object this$projectSummary = this.getProjectSummary();
                                 Object other$projectSummary = other.getProjectSummary();
                                 return this$projectSummary == null ? other$projectSummary == null : this$projectSummary.equals(other$projectSummary);
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
      return other instanceof ProjectLedgerV2DTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $injectionAmount = this.getInjectionAmount();
      result = result * 59 + ($injectionAmount == null ? 43 : $injectionAmount.hashCode());
      Object $collectionAmountSum = this.getCollectionAmountSum();
      result = result * 59 + ($collectionAmountSum == null ? 43 : $collectionAmountSum.hashCode());
      Object $invoiceAmountSum = this.getInvoiceAmountSum();
      result = result * 59 + ($invoiceAmountSum == null ? 43 : $invoiceAmountSum.hashCode());
      Object $paymentAmountSum = this.getPaymentAmountSum();
      result = result * 59 + ($paymentAmountSum == null ? 43 : $paymentAmountSum.hashCode());
      Object $creditAmount = this.getCreditAmount();
      result = result * 59 + ($creditAmount == null ? 43 : $creditAmount.hashCode());
      Object $projectSummary = this.getProjectSummary();
      return result * 59 + ($projectSummary == null ? 43 : $projectSummary.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectLedgerV2DTO(project="
         + this.getProject()
         + ", contractAmount="
         + this.getContractAmount()
         + ", status="
         + this.getStatus()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", injectionAmount="
         + this.getInjectionAmount()
         + ", collectionAmountSum="
         + this.getCollectionAmountSum()
         + ", invoiceAmountSum="
         + this.getInvoiceAmountSum()
         + ", paymentAmountSum="
         + this.getPaymentAmountSum()
         + ", creditAmount="
         + this.getCreditAmount()
         + ", projectSummary="
         + this.getProjectSummary()
         + ")";
   }

   public static class ProjectLedgerV2DTOBuilder {
      private ProjectInfo project;
      private BigDecimal contractAmount;
      private Integer status;
      private BigDecimal settlementAmount;
      private BigDecimal injectionAmount;
      private BigDecimal collectionAmountSum;
      private BigDecimal invoiceAmountSum;
      private BigDecimal paymentAmountSum;
      private BigDecimal creditAmount;
      private BigDecimal projectSummary;

      ProjectLedgerV2DTOBuilder() {
      }

      public ProjectLedgerV2DTO.ProjectLedgerV2DTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectLedgerV2DTO.ProjectLedgerV2DTOBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ProjectLedgerV2DTO.ProjectLedgerV2DTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ProjectLedgerV2DTO.ProjectLedgerV2DTOBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public ProjectLedgerV2DTO.ProjectLedgerV2DTOBuilder injectionAmount(final BigDecimal injectionAmount) {
         this.injectionAmount = injectionAmount;
         return this;
      }

      public ProjectLedgerV2DTO.ProjectLedgerV2DTOBuilder collectionAmountSum(final BigDecimal collectionAmountSum) {
         this.collectionAmountSum = collectionAmountSum;
         return this;
      }

      public ProjectLedgerV2DTO.ProjectLedgerV2DTOBuilder invoiceAmountSum(final BigDecimal invoiceAmountSum) {
         this.invoiceAmountSum = invoiceAmountSum;
         return this;
      }

      public ProjectLedgerV2DTO.ProjectLedgerV2DTOBuilder paymentAmountSum(final BigDecimal paymentAmountSum) {
         this.paymentAmountSum = paymentAmountSum;
         return this;
      }

      public ProjectLedgerV2DTO.ProjectLedgerV2DTOBuilder creditAmount(final BigDecimal creditAmount) {
         this.creditAmount = creditAmount;
         return this;
      }

      public ProjectLedgerV2DTO.ProjectLedgerV2DTOBuilder projectSummary(final BigDecimal projectSummary) {
         this.projectSummary = projectSummary;
         return this;
      }

      public ProjectLedgerV2DTO build() {
         return new ProjectLedgerV2DTO(
            this.project,
            this.contractAmount,
            this.status,
            this.settlementAmount,
            this.injectionAmount,
            this.collectionAmountSum,
            this.invoiceAmountSum,
            this.paymentAmountSum,
            this.creditAmount,
            this.projectSummary
         );
      }

      @Override
      public String toString() {
         return "ProjectLedgerV2DTO.ProjectLedgerV2DTOBuilder(project="
            + this.project
            + ", contractAmount="
            + this.contractAmount
            + ", status="
            + this.status
            + ", settlementAmount="
            + this.settlementAmount
            + ", injectionAmount="
            + this.injectionAmount
            + ", collectionAmountSum="
            + this.collectionAmountSum
            + ", invoiceAmountSum="
            + this.invoiceAmountSum
            + ", paymentAmountSum="
            + this.paymentAmountSum
            + ", creditAmount="
            + this.creditAmount
            + ", projectSummary="
            + this.projectSummary
            + ")";
      }
   }
}
