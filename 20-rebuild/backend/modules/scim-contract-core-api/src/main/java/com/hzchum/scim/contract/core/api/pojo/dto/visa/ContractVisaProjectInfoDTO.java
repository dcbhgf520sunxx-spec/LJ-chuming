package com.hzchum.scim.contract.core.api.pojo.dto.visa;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel(description = "项目签证信息")
public class ContractVisaProjectInfoDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("项目id")
   private Long id;
   @ApiModelProperty("项目名称")
   private String name;
   @ApiModelProperty("项目简称")
   private String shortName;
   @ApiModelProperty("合同编号")
   private String serialNumber;
   @ApiModelProperty(notes = "合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty("施工单位")
   private String contractSignBodyName;
   @ApiModelProperty("发包单位")
   private String customerUnit;
   @ApiModelProperty("签订日期")
   private LocalDate signingDate;
   @ApiModelProperty("项目经理")
   private String projectManagerName;
   @ApiModelProperty("保证金额")
   private BigDecimal marginAmount;
   @ApiModelProperty("保证金类型 1.现金 2保函")
   private String marginType;
   @ApiModelProperty("签证额")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal visaAmount;
   @ApiModelProperty("收款金额")
   private BigDecimal collectionAmount;
   @ApiModelProperty("开票金额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty(notes = "已发生额(发运额或者安装额)")
   private BigDecimal happenedAmount;
   @ApiModelProperty("合同内容名称")
   private String projectContentName;
   @ApiModelProperty("签约人")
   private String signerName;
   @ApiModelProperty("发票类型")
   private Integer invoiceType;
   @ApiModelProperty("税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "is_tax", notes = "合同额是否含税 1是 0否")
   private Integer isTax;

   public static ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder builder() {
      return new ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public String getContractSignBodyName() {
      return this.contractSignBodyName;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public LocalDate getSigningDate() {
      return this.signingDate;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public BigDecimal getMarginAmount() {
      return this.marginAmount;
   }

   public String getMarginType() {
      return this.marginType;
   }

   public BigDecimal getVisaAmount() {
      return this.visaAmount;
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

   public String getProjectContentName() {
      return this.projectContentName;
   }

   public String getSignerName() {
      return this.signerName;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Integer getIsTax() {
      return this.isTax;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setContractSignBodyName(final String contractSignBodyName) {
      this.contractSignBodyName = contractSignBodyName;
   }

   public void setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
   }

   public void setSigningDate(final LocalDate signingDate) {
      this.signingDate = signingDate;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setMarginAmount(final BigDecimal marginAmount) {
      this.marginAmount = marginAmount;
   }

   public void setMarginType(final String marginType) {
      this.marginType = marginType;
   }

   public void setVisaAmount(final BigDecimal visaAmount) {
      this.visaAmount = visaAmount;
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

   public void setProjectContentName(final String projectContentName) {
      this.projectContentName = projectContentName;
   }

   public void setSignerName(final String signerName) {
      this.signerName = signerName;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setIsTax(final Integer isTax) {
      this.isTax = isTax;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractVisaProjectInfoDTO)) {
         return false;
      }

      ContractVisaProjectInfoDTO other = (ContractVisaProjectInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$invoiceType = this.getInvoiceType();
         Object other$invoiceType = other.getInvoiceType();
         if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
            Object this$isTax = this.getIsTax();
            Object other$isTax = other.getIsTax();
            if (this$isTax == null ? other$isTax == null : this$isTax.equals(other$isTax)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$shortName = this.getShortName();
                  Object other$shortName = other.getShortName();
                  if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$contractAmount = this.getContractAmount();
                        Object other$contractAmount = other.getContractAmount();
                        if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                           Object this$contractSignBodyName = this.getContractSignBodyName();
                           Object other$contractSignBodyName = other.getContractSignBodyName();
                           if (this$contractSignBodyName == null
                              ? other$contractSignBodyName == null
                              : this$contractSignBodyName.equals(other$contractSignBodyName)) {
                              Object this$customerUnit = this.getCustomerUnit();
                              Object other$customerUnit = other.getCustomerUnit();
                              if (this$customerUnit == null ? other$customerUnit == null : this$customerUnit.equals(other$customerUnit)) {
                                 Object this$signingDate = this.getSigningDate();
                                 Object other$signingDate = other.getSigningDate();
                                 if (this$signingDate == null ? other$signingDate == null : this$signingDate.equals(other$signingDate)) {
                                    Object this$projectManagerName = this.getProjectManagerName();
                                    Object other$projectManagerName = other.getProjectManagerName();
                                    if (this$projectManagerName == null
                                       ? other$projectManagerName == null
                                       : this$projectManagerName.equals(other$projectManagerName)) {
                                       Object this$marginAmount = this.getMarginAmount();
                                       Object other$marginAmount = other.getMarginAmount();
                                       if (this$marginAmount == null ? other$marginAmount == null : this$marginAmount.equals(other$marginAmount)) {
                                          Object this$marginType = this.getMarginType();
                                          Object other$marginType = other.getMarginType();
                                          if (this$marginType == null ? other$marginType == null : this$marginType.equals(other$marginType)) {
                                             Object this$visaAmount = this.getVisaAmount();
                                             Object other$visaAmount = other.getVisaAmount();
                                             if (this$visaAmount == null ? other$visaAmount == null : this$visaAmount.equals(other$visaAmount)) {
                                                Object this$collectionAmount = this.getCollectionAmount();
                                                Object other$collectionAmount = other.getCollectionAmount();
                                                if (this$collectionAmount == null
                                                   ? other$collectionAmount == null
                                                   : this$collectionAmount.equals(other$collectionAmount)) {
                                                   Object this$invoiceAmount = this.getInvoiceAmount();
                                                   Object other$invoiceAmount = other.getInvoiceAmount();
                                                   if (this$invoiceAmount == null
                                                      ? other$invoiceAmount == null
                                                      : this$invoiceAmount.equals(other$invoiceAmount)) {
                                                      Object this$happenedAmount = this.getHappenedAmount();
                                                      Object other$happenedAmount = other.getHappenedAmount();
                                                      if (this$happenedAmount == null
                                                         ? other$happenedAmount == null
                                                         : this$happenedAmount.equals(other$happenedAmount)) {
                                                         Object this$projectContentName = this.getProjectContentName();
                                                         Object other$projectContentName = other.getProjectContentName();
                                                         if (this$projectContentName == null
                                                            ? other$projectContentName == null
                                                            : this$projectContentName.equals(other$projectContentName)) {
                                                            Object this$signerName = this.getSignerName();
                                                            Object other$signerName = other.getSignerName();
                                                            if (this$signerName == null ? other$signerName == null : this$signerName.equals(other$signerName)) {
                                                               Object this$taxRate = this.getTaxRate();
                                                               Object other$taxRate = other.getTaxRate();
                                                               return this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate);
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
      return other instanceof ContractVisaProjectInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $isTax = this.getIsTax();
      result = result * 59 + ($isTax == null ? 43 : $isTax.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $contractSignBodyName = this.getContractSignBodyName();
      result = result * 59 + ($contractSignBodyName == null ? 43 : $contractSignBodyName.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $signingDate = this.getSigningDate();
      result = result * 59 + ($signingDate == null ? 43 : $signingDate.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $marginAmount = this.getMarginAmount();
      result = result * 59 + ($marginAmount == null ? 43 : $marginAmount.hashCode());
      Object $marginType = this.getMarginType();
      result = result * 59 + ($marginType == null ? 43 : $marginType.hashCode());
      Object $visaAmount = this.getVisaAmount();
      result = result * 59 + ($visaAmount == null ? 43 : $visaAmount.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $happenedAmount = this.getHappenedAmount();
      result = result * 59 + ($happenedAmount == null ? 43 : $happenedAmount.hashCode());
      Object $projectContentName = this.getProjectContentName();
      result = result * 59 + ($projectContentName == null ? 43 : $projectContentName.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $taxRate = this.getTaxRate();
      return result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
   }

   @Override
   public String toString() {
      return "ContractVisaProjectInfoDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", contractAmount="
         + this.getContractAmount()
         + ", contractSignBodyName="
         + this.getContractSignBodyName()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ", signingDate="
         + this.getSigningDate()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", marginAmount="
         + this.getMarginAmount()
         + ", marginType="
         + this.getMarginType()
         + ", visaAmount="
         + this.getVisaAmount()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", happenedAmount="
         + this.getHappenedAmount()
         + ", projectContentName="
         + this.getProjectContentName()
         + ", signerName="
         + this.getSignerName()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", isTax="
         + this.getIsTax()
         + ")";
   }

   public ContractVisaProjectInfoDTO() {
   }

   public ContractVisaProjectInfoDTO(
      final Long id,
      final String name,
      final String shortName,
      final String serialNumber,
      final BigDecimal contractAmount,
      final String contractSignBodyName,
      final String customerUnit,
      final LocalDate signingDate,
      final String projectManagerName,
      final BigDecimal marginAmount,
      final String marginType,
      final BigDecimal visaAmount,
      final BigDecimal collectionAmount,
      final BigDecimal invoiceAmount,
      final BigDecimal happenedAmount,
      final String projectContentName,
      final String signerName,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final Integer isTax
   ) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.serialNumber = serialNumber;
      this.contractAmount = contractAmount;
      this.contractSignBodyName = contractSignBodyName;
      this.customerUnit = customerUnit;
      this.signingDate = signingDate;
      this.projectManagerName = projectManagerName;
      this.marginAmount = marginAmount;
      this.marginType = marginType;
      this.visaAmount = visaAmount;
      this.collectionAmount = collectionAmount;
      this.invoiceAmount = invoiceAmount;
      this.happenedAmount = happenedAmount;
      this.projectContentName = projectContentName;
      this.signerName = signerName;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.isTax = isTax;
   }

   public static class ContractVisaProjectInfoDTOBuilder {
      private Long id;
      private String name;
      private String shortName;
      private String serialNumber;
      private BigDecimal contractAmount;
      private String contractSignBodyName;
      private String customerUnit;
      private LocalDate signingDate;
      private String projectManagerName;
      private BigDecimal marginAmount;
      private String marginType;
      private BigDecimal visaAmount;
      private BigDecimal collectionAmount;
      private BigDecimal invoiceAmount;
      private BigDecimal happenedAmount;
      private String projectContentName;
      private String signerName;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private Integer isTax;

      ContractVisaProjectInfoDTOBuilder() {
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder contractSignBodyName(final String contractSignBodyName) {
         this.contractSignBodyName = contractSignBodyName;
         return this;
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder customerUnit(final String customerUnit) {
         this.customerUnit = customerUnit;
         return this;
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder signingDate(final LocalDate signingDate) {
         this.signingDate = signingDate;
         return this;
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder projectManagerName(final String projectManagerName) {
         this.projectManagerName = projectManagerName;
         return this;
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder marginAmount(final BigDecimal marginAmount) {
         this.marginAmount = marginAmount;
         return this;
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder marginType(final String marginType) {
         this.marginType = marginType;
         return this;
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder visaAmount(final BigDecimal visaAmount) {
         this.visaAmount = visaAmount;
         return this;
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder collectionAmount(final BigDecimal collectionAmount) {
         this.collectionAmount = collectionAmount;
         return this;
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder happenedAmount(final BigDecimal happenedAmount) {
         this.happenedAmount = happenedAmount;
         return this;
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder projectContentName(final String projectContentName) {
         this.projectContentName = projectContentName;
         return this;
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder signerName(final String signerName) {
         this.signerName = signerName;
         return this;
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder isTax(final Integer isTax) {
         this.isTax = isTax;
         return this;
      }

      public ContractVisaProjectInfoDTO build() {
         return new ContractVisaProjectInfoDTO(
            this.id,
            this.name,
            this.shortName,
            this.serialNumber,
            this.contractAmount,
            this.contractSignBodyName,
            this.customerUnit,
            this.signingDate,
            this.projectManagerName,
            this.marginAmount,
            this.marginType,
            this.visaAmount,
            this.collectionAmount,
            this.invoiceAmount,
            this.happenedAmount,
            this.projectContentName,
            this.signerName,
            this.invoiceType,
            this.taxRate,
            this.isTax
         );
      }

      @Override
      public String toString() {
         return "ContractVisaProjectInfoDTO.ContractVisaProjectInfoDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", serialNumber="
            + this.serialNumber
            + ", contractAmount="
            + this.contractAmount
            + ", contractSignBodyName="
            + this.contractSignBodyName
            + ", customerUnit="
            + this.customerUnit
            + ", signingDate="
            + this.signingDate
            + ", projectManagerName="
            + this.projectManagerName
            + ", marginAmount="
            + this.marginAmount
            + ", marginType="
            + this.marginType
            + ", visaAmount="
            + this.visaAmount
            + ", collectionAmount="
            + this.collectionAmount
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", happenedAmount="
            + this.happenedAmount
            + ", projectContentName="
            + this.projectContentName
            + ", signerName="
            + this.signerName
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", isTax="
            + this.isTax
            + ")";
      }
   }
}
