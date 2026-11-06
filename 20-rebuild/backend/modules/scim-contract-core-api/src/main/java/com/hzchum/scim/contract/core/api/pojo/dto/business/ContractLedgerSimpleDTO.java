package com.hzchum.scim.contract.core.api.pojo.dto.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "销售台账")
public class ContractLedgerSimpleDTO {
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("项目状态")
   private Integer status;
   @ApiModelProperty("结算状态")
   private Integer settlementStatus;
   @ApiModelProperty("订单来源类型")
   private Integer orderSourceType;
   @ApiModelProperty("合同内容id")
   @JsonIgnore
   private String projectContent;
   @ApiModelProperty("合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty("结算额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("收款金额")
   private BigDecimal collectionAmount;
   @ApiModelProperty("开票金额")
   private BigDecimal invoiceAmount;

   public ProjectInfo getProject() {
      return this.project;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public Integer getOrderSourceType() {
      return this.orderSourceType;
   }

   public String getProjectContent() {
      return this.projectContent;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getCollectionAmount() {
      return this.collectionAmount;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setOrderSourceType(final Integer orderSourceType) {
      this.orderSourceType = orderSourceType;
   }

   @JsonIgnore
   public void setProjectContent(final String projectContent) {
      this.projectContent = projectContent;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setCollectionAmount(final BigDecimal collectionAmount) {
      this.collectionAmount = collectionAmount;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractLedgerSimpleDTO)) {
         return false;
      }

      ContractLedgerSimpleDTO other = (ContractLedgerSimpleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$status = this.getStatus();
      Object other$status = other.getStatus();
      if (this$status == null ? other$status == null : this$status.equals(other$status)) {
         Object this$settlementStatus = this.getSettlementStatus();
         Object other$settlementStatus = other.getSettlementStatus();
         if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
            Object this$orderSourceType = this.getOrderSourceType();
            Object other$orderSourceType = other.getOrderSourceType();
            if (this$orderSourceType == null ? other$orderSourceType == null : this$orderSourceType.equals(other$orderSourceType)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$projectContent = this.getProjectContent();
                  Object other$projectContent = other.getProjectContent();
                  if (this$projectContent == null ? other$projectContent == null : this$projectContent.equals(other$projectContent)) {
                     Object this$contractAmount = this.getContractAmount();
                     Object other$contractAmount = other.getContractAmount();
                     if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                        Object this$settlementAmount = this.getSettlementAmount();
                        Object other$settlementAmount = other.getSettlementAmount();
                        if (this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount)) {
                           Object this$collectionAmount = this.getCollectionAmount();
                           Object other$collectionAmount = other.getCollectionAmount();
                           if (this$collectionAmount == null ? other$collectionAmount == null : this$collectionAmount.equals(other$collectionAmount)) {
                              Object this$invoiceAmount = this.getInvoiceAmount();
                              Object other$invoiceAmount = other.getInvoiceAmount();
                              return this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount);
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
      return other instanceof ContractLedgerSimpleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $orderSourceType = this.getOrderSourceType();
      result = result * 59 + ($orderSourceType == null ? 43 : $orderSourceType.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $projectContent = this.getProjectContent();
      result = result * 59 + ($projectContent == null ? 43 : $projectContent.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      return result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ContractLedgerSimpleDTO(project="
         + this.getProject()
         + ", status="
         + this.getStatus()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", orderSourceType="
         + this.getOrderSourceType()
         + ", projectContent="
         + this.getProjectContent()
         + ", contractAmount="
         + this.getContractAmount()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ")";
   }
}
