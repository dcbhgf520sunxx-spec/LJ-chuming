package com.hzchum.scim.contract.core.api.pojo.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("应收款报表")
public class ProjectAbleCollectionDTO {
   @ApiModelProperty(name = "项目id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", notes = "合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "name", notes = "项目名称")
   private String name;
   @ApiModelProperty(name = "shortName", notes = "项目简称")
   private String shortName;
   @ApiModelProperty(name = "contractAmount", notes = "合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "settlementStatus", notes = "结算状态 0 未结算 1已结算")
   private Integer settlementStatus;
   @ApiModelProperty(name = "settlementAmount", notes = "结算金额(元)")
   private BigDecimal settlementAmount;
   @ApiModelProperty(name = "collectionAmount", notes = "项目已收款总额")
   private BigDecimal collectionAmount;
   @ApiModelProperty(name = "invoiceAmount", notes = "项目已开票总额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty(name = "accountAge", notes = "账龄(天)")
   private Integer accountAge;

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
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

   public Integer getAccountAge() {
      return this.accountAge;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
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

   public void setAccountAge(final Integer accountAge) {
      this.accountAge = accountAge;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectAbleCollectionDTO)) {
         return false;
      }

      ProjectAbleCollectionDTO other = (ProjectAbleCollectionDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$settlementStatus = this.getSettlementStatus();
         Object other$settlementStatus = other.getSettlementStatus();
         if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
            Object this$accountAge = this.getAccountAge();
            Object other$accountAge = other.getAccountAge();
            if (this$accountAge == null ? other$accountAge == null : this$accountAge.equals(other$accountAge)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$shortName = this.getShortName();
                     Object other$shortName = other.getShortName();
                     if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectAbleCollectionDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $accountAge = this.getAccountAge();
      result = result * 59 + ($accountAge == null ? 43 : $accountAge.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
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
      return "ProjectAbleCollectionDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", contractAmount="
         + this.getContractAmount()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", accountAge="
         + this.getAccountAge()
         + ")";
   }
}
