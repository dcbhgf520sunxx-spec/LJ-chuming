package com.hzchum.scim.business.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "销售台账")
public class ContractSaleLedgerDTO {
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
   @ApiModelProperty("合同内容名称")
   private String projectContentName;
   @ApiModelProperty("合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty("结算额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("收款金额")
   private BigDecimal collectionAmount;
   @ApiModelProperty("开票金额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("已发生额(发运额或者安装额)")
   private BigDecimal happenedAmount;
   @ApiModelProperty("运输车次")
   private Integer transportQuantity;
   @ApiModelProperty("入库总额")
   private BigDecimal warehouseAmount;

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

   public String getProjectContentName() {
      return this.projectContentName;
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

   public BigDecimal getHappenedAmount() {
      return this.happenedAmount;
   }

   public Integer getTransportQuantity() {
      return this.transportQuantity;
   }

   public BigDecimal getWarehouseAmount() {
      return this.warehouseAmount;
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

   public void setProjectContentName(final String projectContentName) {
      this.projectContentName = projectContentName;
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

   public void setHappenedAmount(final BigDecimal happenedAmount) {
      this.happenedAmount = happenedAmount;
   }

   public void setTransportQuantity(final Integer transportQuantity) {
      this.transportQuantity = transportQuantity;
   }

   public void setWarehouseAmount(final BigDecimal warehouseAmount) {
      this.warehouseAmount = warehouseAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractSaleLedgerDTO)) {
         return false;
      }

      ContractSaleLedgerDTO other = (ContractSaleLedgerDTO)o;
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
               Object this$transportQuantity = this.getTransportQuantity();
               Object other$transportQuantity = other.getTransportQuantity();
               if (this$transportQuantity == null ? other$transportQuantity == null : this$transportQuantity.equals(other$transportQuantity)) {
                  Object this$project = this.getProject();
                  Object other$project = other.getProject();
                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                     Object this$projectContent = this.getProjectContent();
                     Object other$projectContent = other.getProjectContent();
                     if (this$projectContent == null ? other$projectContent == null : this$projectContent.equals(other$projectContent)) {
                        Object this$projectContentName = this.getProjectContentName();
                        Object other$projectContentName = other.getProjectContentName();
                        if (this$projectContentName == null ? other$projectContentName == null : this$projectContentName.equals(other$projectContentName)) {
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
                                    if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                                       Object this$happenedAmount = this.getHappenedAmount();
                                       Object other$happenedAmount = other.getHappenedAmount();
                                       if (this$happenedAmount == null ? other$happenedAmount == null : this$happenedAmount.equals(other$happenedAmount)) {
                                          Object this$warehouseAmount = this.getWarehouseAmount();
                                          Object other$warehouseAmount = other.getWarehouseAmount();
                                          return this$warehouseAmount == null
                                             ? other$warehouseAmount == null
                                             : this$warehouseAmount.equals(other$warehouseAmount);
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
      return other instanceof ContractSaleLedgerDTO;
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
      Object $transportQuantity = this.getTransportQuantity();
      result = result * 59 + ($transportQuantity == null ? 43 : $transportQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $projectContent = this.getProjectContent();
      result = result * 59 + ($projectContent == null ? 43 : $projectContent.hashCode());
      Object $projectContentName = this.getProjectContentName();
      result = result * 59 + ($projectContentName == null ? 43 : $projectContentName.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $happenedAmount = this.getHappenedAmount();
      result = result * 59 + ($happenedAmount == null ? 43 : $happenedAmount.hashCode());
      Object $warehouseAmount = this.getWarehouseAmount();
      return result * 59 + ($warehouseAmount == null ? 43 : $warehouseAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ContractSaleLedgerDTO(project="
         + this.getProject()
         + ", status="
         + this.getStatus()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", orderSourceType="
         + this.getOrderSourceType()
         + ", projectContent="
         + this.getProjectContent()
         + ", projectContentName="
         + this.getProjectContentName()
         + ", contractAmount="
         + this.getContractAmount()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", happenedAmount="
         + this.getHappenedAmount()
         + ", transportQuantity="
         + this.getTransportQuantity()
         + ", warehouseAmount="
         + this.getWarehouseAmount()
         + ")";
   }
}
