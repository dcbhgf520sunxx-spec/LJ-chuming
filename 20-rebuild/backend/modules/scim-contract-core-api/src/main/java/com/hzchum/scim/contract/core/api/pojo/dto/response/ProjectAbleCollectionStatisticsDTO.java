package com.hzchum.scim.contract.core.api.pojo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("项目应收款统计类")
public class ProjectAbleCollectionStatisticsDTO {
   @ApiModelProperty("应收项目数")
   Integer ableCollectionQuantity;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("开票总额")
   BigDecimal invoiceAmount;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("结算总额")
   BigDecimal settlementAmount;
   @ApiModelProperty("已收款总额")
   BigDecimal collectionAmount;
   @ApiModelProperty("应收总额")
   BigDecimal ableCollectionAmount;

   public Integer getAbleCollectionQuantity() {
      return this.ableCollectionQuantity;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getCollectionAmount() {
      return this.collectionAmount;
   }

   public BigDecimal getAbleCollectionAmount() {
      return this.ableCollectionAmount;
   }

   public void setAbleCollectionQuantity(final Integer ableCollectionQuantity) {
      this.ableCollectionQuantity = ableCollectionQuantity;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setCollectionAmount(final BigDecimal collectionAmount) {
      this.collectionAmount = collectionAmount;
   }

   public void setAbleCollectionAmount(final BigDecimal ableCollectionAmount) {
      this.ableCollectionAmount = ableCollectionAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectAbleCollectionStatisticsDTO)) {
         return false;
      }

      ProjectAbleCollectionStatisticsDTO other = (ProjectAbleCollectionStatisticsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$ableCollectionQuantity = this.getAbleCollectionQuantity();
      Object other$ableCollectionQuantity = other.getAbleCollectionQuantity();
      if (this$ableCollectionQuantity == null ? other$ableCollectionQuantity == null : this$ableCollectionQuantity.equals(other$ableCollectionQuantity)) {
         Object this$invoiceAmount = this.getInvoiceAmount();
         Object other$invoiceAmount = other.getInvoiceAmount();
         if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
            Object this$settlementAmount = this.getSettlementAmount();
            Object other$settlementAmount = other.getSettlementAmount();
            if (this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount)) {
               Object this$collectionAmount = this.getCollectionAmount();
               Object other$collectionAmount = other.getCollectionAmount();
               if (this$collectionAmount == null ? other$collectionAmount == null : this$collectionAmount.equals(other$collectionAmount)) {
                  Object this$ableCollectionAmount = this.getAbleCollectionAmount();
                  Object other$ableCollectionAmount = other.getAbleCollectionAmount();
                  return this$ableCollectionAmount == null ? other$ableCollectionAmount == null : this$ableCollectionAmount.equals(other$ableCollectionAmount);
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
      return other instanceof ProjectAbleCollectionStatisticsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $ableCollectionQuantity = this.getAbleCollectionQuantity();
      result = result * 59 + ($ableCollectionQuantity == null ? 43 : $ableCollectionQuantity.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $ableCollectionAmount = this.getAbleCollectionAmount();
      return result * 59 + ($ableCollectionAmount == null ? 43 : $ableCollectionAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectAbleCollectionStatisticsDTO(ableCollectionQuantity="
         + this.getAbleCollectionQuantity()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", ableCollectionAmount="
         + this.getAbleCollectionAmount()
         + ")";
   }
}
