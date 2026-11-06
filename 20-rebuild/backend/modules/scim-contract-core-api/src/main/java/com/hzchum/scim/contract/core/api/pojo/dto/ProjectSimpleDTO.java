package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@ApiModel("收款开票信息类")
public class ProjectSimpleDTO {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long id;
   @ApiModelProperty(name = "serial_number", notes = "合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "name", notes = "项目名称")
   private String name;
   @ApiModelProperty(name = "short_name", notes = "项目简称")
   private String shortName;
   @ApiModelProperty(name = "business_type", notes = "业务类型 1.加工承揽  2.项目承包")
   private Integer businessType;
   @ApiModelProperty(name = "contractAmount", value = "合同总金额")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "haveInvoiceAmount", value = "已开票总额")
   private BigDecimal haveInvoiceAmount;
   @ApiModelProperty(name = "haveCollectionAmount", value = "已收款总额")
   private BigDecimal haveCollectionAmount;
   @ApiModelProperty(name = "is_tax", notes = "合同额是否含税 1是 0否")
   private Integer isTax;
   @ApiModelProperty(name = "invoiceType", value = "合同发票类型 1增值专用票 2增值普发票 4收据")
   private Integer invoiceType;
   @ApiModelProperty(name = "pay_type", notes = "支付方式  1.对公转账 2对私转账 4承兑汇票 8转账支票 ")
   private Integer payType;
   @ApiModelProperty(name = "customer_unit", notes = "客户单位名称")
   private String customerUnit;
   @ApiModelProperty(name = "social_code", notes = "客户统一社会信用代码")
   private String socialCode;
   @ApiModelProperty(name = "customer_bank_user_name", notes = "银行账户户名")
   private String customerBankUserName;
   @ApiModelProperty(name = "customer_bank_code", notes = "银行账户账号")
   private String customerBankCode;
   @ApiModelProperty(name = "customer_bank_name", notes = "开户行   (中国工商银行...)")
   private String customerBankName;
   @ApiModelProperty(name = "status", notes = "项目状态  0：进行中，1：已暂停，2：已完工 ")
   private Integer status;
   @ApiModelProperty(name = "bankAccountDTOList", value = "收款、开票方信息 列表")
   private List<Map<String, Object>> companyBankAccountList;

   public static ProjectSimpleDTO.ProjectSimpleDTOBuilder builder() {
      return new ProjectSimpleDTO.ProjectSimpleDTOBuilder();
   }

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

   public Integer getBusinessType() {
      return this.businessType;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getHaveInvoiceAmount() {
      return this.haveInvoiceAmount;
   }

   public BigDecimal getHaveCollectionAmount() {
      return this.haveCollectionAmount;
   }

   public Integer getIsTax() {
      return this.isTax;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Integer getPayType() {
      return this.payType;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public String getSocialCode() {
      return this.socialCode;
   }

   public String getCustomerBankUserName() {
      return this.customerBankUserName;
   }

   public String getCustomerBankCode() {
      return this.customerBankCode;
   }

   public String getCustomerBankName() {
      return this.customerBankName;
   }

   public Integer getStatus() {
      return this.status;
   }

   public List<Map<String, Object>> getCompanyBankAccountList() {
      return this.companyBankAccountList;
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

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setHaveInvoiceAmount(final BigDecimal haveInvoiceAmount) {
      this.haveInvoiceAmount = haveInvoiceAmount;
   }

   public void setHaveCollectionAmount(final BigDecimal haveCollectionAmount) {
      this.haveCollectionAmount = haveCollectionAmount;
   }

   public void setIsTax(final Integer isTax) {
      this.isTax = isTax;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setPayType(final Integer payType) {
      this.payType = payType;
   }

   public void setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
   }

   public void setSocialCode(final String socialCode) {
      this.socialCode = socialCode;
   }

   public void setCustomerBankUserName(final String customerBankUserName) {
      this.customerBankUserName = customerBankUserName;
   }

   public void setCustomerBankCode(final String customerBankCode) {
      this.customerBankCode = customerBankCode;
   }

   public void setCustomerBankName(final String customerBankName) {
      this.customerBankName = customerBankName;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setCompanyBankAccountList(final List<Map<String, Object>> companyBankAccountList) {
      this.companyBankAccountList = companyBankAccountList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSimpleDTO)) {
         return false;
      }

      ProjectSimpleDTO other = (ProjectSimpleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$businessType = this.getBusinessType();
         Object other$businessType = other.getBusinessType();
         if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
            Object this$isTax = this.getIsTax();
            Object other$isTax = other.getIsTax();
            if (this$isTax == null ? other$isTax == null : this$isTax.equals(other$isTax)) {
               Object this$invoiceType = this.getInvoiceType();
               Object other$invoiceType = other.getInvoiceType();
               if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                  Object this$payType = this.getPayType();
                  Object other$payType = other.getPayType();
                  if (this$payType == null ? other$payType == null : this$payType.equals(other$payType)) {
                     Object this$status = this.getStatus();
                     Object other$status = other.getStatus();
                     if (this$status == null ? other$status == null : this$status.equals(other$status)) {
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
                                    Object this$haveInvoiceAmount = this.getHaveInvoiceAmount();
                                    Object other$haveInvoiceAmount = other.getHaveInvoiceAmount();
                                    if (this$haveInvoiceAmount == null
                                       ? other$haveInvoiceAmount == null
                                       : this$haveInvoiceAmount.equals(other$haveInvoiceAmount)) {
                                       Object this$haveCollectionAmount = this.getHaveCollectionAmount();
                                       Object other$haveCollectionAmount = other.getHaveCollectionAmount();
                                       if (this$haveCollectionAmount == null
                                          ? other$haveCollectionAmount == null
                                          : this$haveCollectionAmount.equals(other$haveCollectionAmount)) {
                                          Object this$customerUnit = this.getCustomerUnit();
                                          Object other$customerUnit = other.getCustomerUnit();
                                          if (this$customerUnit == null ? other$customerUnit == null : this$customerUnit.equals(other$customerUnit)) {
                                             Object this$socialCode = this.getSocialCode();
                                             Object other$socialCode = other.getSocialCode();
                                             if (this$socialCode == null ? other$socialCode == null : this$socialCode.equals(other$socialCode)) {
                                                Object this$customerBankUserName = this.getCustomerBankUserName();
                                                Object other$customerBankUserName = other.getCustomerBankUserName();
                                                if (this$customerBankUserName == null
                                                   ? other$customerBankUserName == null
                                                   : this$customerBankUserName.equals(other$customerBankUserName)) {
                                                   Object this$customerBankCode = this.getCustomerBankCode();
                                                   Object other$customerBankCode = other.getCustomerBankCode();
                                                   if (this$customerBankCode == null
                                                      ? other$customerBankCode == null
                                                      : this$customerBankCode.equals(other$customerBankCode)) {
                                                      Object this$customerBankName = this.getCustomerBankName();
                                                      Object other$customerBankName = other.getCustomerBankName();
                                                      if (this$customerBankName == null
                                                         ? other$customerBankName == null
                                                         : this$customerBankName.equals(other$customerBankName)) {
                                                         Object this$companyBankAccountList = this.getCompanyBankAccountList();
                                                         Object other$companyBankAccountList = other.getCompanyBankAccountList();
                                                         return this$companyBankAccountList == null
                                                            ? other$companyBankAccountList == null
                                                            : this$companyBankAccountList.equals(other$companyBankAccountList);
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
      return other instanceof ProjectSimpleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $isTax = this.getIsTax();
      result = result * 59 + ($isTax == null ? 43 : $isTax.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $payType = this.getPayType();
      result = result * 59 + ($payType == null ? 43 : $payType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $haveInvoiceAmount = this.getHaveInvoiceAmount();
      result = result * 59 + ($haveInvoiceAmount == null ? 43 : $haveInvoiceAmount.hashCode());
      Object $haveCollectionAmount = this.getHaveCollectionAmount();
      result = result * 59 + ($haveCollectionAmount == null ? 43 : $haveCollectionAmount.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $socialCode = this.getSocialCode();
      result = result * 59 + ($socialCode == null ? 43 : $socialCode.hashCode());
      Object $customerBankUserName = this.getCustomerBankUserName();
      result = result * 59 + ($customerBankUserName == null ? 43 : $customerBankUserName.hashCode());
      Object $customerBankCode = this.getCustomerBankCode();
      result = result * 59 + ($customerBankCode == null ? 43 : $customerBankCode.hashCode());
      Object $customerBankName = this.getCustomerBankName();
      result = result * 59 + ($customerBankName == null ? 43 : $customerBankName.hashCode());
      Object $companyBankAccountList = this.getCompanyBankAccountList();
      return result * 59 + ($companyBankAccountList == null ? 43 : $companyBankAccountList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSimpleDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", businessType="
         + this.getBusinessType()
         + ", contractAmount="
         + this.getContractAmount()
         + ", haveInvoiceAmount="
         + this.getHaveInvoiceAmount()
         + ", haveCollectionAmount="
         + this.getHaveCollectionAmount()
         + ", isTax="
         + this.getIsTax()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", payType="
         + this.getPayType()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ", socialCode="
         + this.getSocialCode()
         + ", customerBankUserName="
         + this.getCustomerBankUserName()
         + ", customerBankCode="
         + this.getCustomerBankCode()
         + ", customerBankName="
         + this.getCustomerBankName()
         + ", status="
         + this.getStatus()
         + ", companyBankAccountList="
         + this.getCompanyBankAccountList()
         + ")";
   }

   public ProjectSimpleDTO(
      final Long id,
      final String serialNumber,
      final String name,
      final String shortName,
      final Integer businessType,
      final BigDecimal contractAmount,
      final BigDecimal haveInvoiceAmount,
      final BigDecimal haveCollectionAmount,
      final Integer isTax,
      final Integer invoiceType,
      final Integer payType,
      final String customerUnit,
      final String socialCode,
      final String customerBankUserName,
      final String customerBankCode,
      final String customerBankName,
      final Integer status,
      final List<Map<String, Object>> companyBankAccountList
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.name = name;
      this.shortName = shortName;
      this.businessType = businessType;
      this.contractAmount = contractAmount;
      this.haveInvoiceAmount = haveInvoiceAmount;
      this.haveCollectionAmount = haveCollectionAmount;
      this.isTax = isTax;
      this.invoiceType = invoiceType;
      this.payType = payType;
      this.customerUnit = customerUnit;
      this.socialCode = socialCode;
      this.customerBankUserName = customerBankUserName;
      this.customerBankCode = customerBankCode;
      this.customerBankName = customerBankName;
      this.status = status;
      this.companyBankAccountList = companyBankAccountList;
   }

   public ProjectSimpleDTO() {
   }

   public static class ProjectSimpleDTOBuilder {
      private Long id;
      private String serialNumber;
      private String name;
      private String shortName;
      private Integer businessType;
      private BigDecimal contractAmount;
      private BigDecimal haveInvoiceAmount;
      private BigDecimal haveCollectionAmount;
      private Integer isTax;
      private Integer invoiceType;
      private Integer payType;
      private String customerUnit;
      private String socialCode;
      private String customerBankUserName;
      private String customerBankCode;
      private String customerBankName;
      private Integer status;
      private List<Map<String, Object>> companyBankAccountList;

      ProjectSimpleDTOBuilder() {
      }

      public ProjectSimpleDTO.ProjectSimpleDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectSimpleDTO.ProjectSimpleDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectSimpleDTO.ProjectSimpleDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectSimpleDTO.ProjectSimpleDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public ProjectSimpleDTO.ProjectSimpleDTOBuilder businessType(final Integer businessType) {
         this.businessType = businessType;
         return this;
      }

      public ProjectSimpleDTO.ProjectSimpleDTOBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ProjectSimpleDTO.ProjectSimpleDTOBuilder haveInvoiceAmount(final BigDecimal haveInvoiceAmount) {
         this.haveInvoiceAmount = haveInvoiceAmount;
         return this;
      }

      public ProjectSimpleDTO.ProjectSimpleDTOBuilder haveCollectionAmount(final BigDecimal haveCollectionAmount) {
         this.haveCollectionAmount = haveCollectionAmount;
         return this;
      }

      public ProjectSimpleDTO.ProjectSimpleDTOBuilder isTax(final Integer isTax) {
         this.isTax = isTax;
         return this;
      }

      public ProjectSimpleDTO.ProjectSimpleDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public ProjectSimpleDTO.ProjectSimpleDTOBuilder payType(final Integer payType) {
         this.payType = payType;
         return this;
      }

      public ProjectSimpleDTO.ProjectSimpleDTOBuilder customerUnit(final String customerUnit) {
         this.customerUnit = customerUnit;
         return this;
      }

      public ProjectSimpleDTO.ProjectSimpleDTOBuilder socialCode(final String socialCode) {
         this.socialCode = socialCode;
         return this;
      }

      public ProjectSimpleDTO.ProjectSimpleDTOBuilder customerBankUserName(final String customerBankUserName) {
         this.customerBankUserName = customerBankUserName;
         return this;
      }

      public ProjectSimpleDTO.ProjectSimpleDTOBuilder customerBankCode(final String customerBankCode) {
         this.customerBankCode = customerBankCode;
         return this;
      }

      public ProjectSimpleDTO.ProjectSimpleDTOBuilder customerBankName(final String customerBankName) {
         this.customerBankName = customerBankName;
         return this;
      }

      public ProjectSimpleDTO.ProjectSimpleDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ProjectSimpleDTO.ProjectSimpleDTOBuilder companyBankAccountList(final List<Map<String, Object>> companyBankAccountList) {
         this.companyBankAccountList = companyBankAccountList;
         return this;
      }

      public ProjectSimpleDTO build() {
         return new ProjectSimpleDTO(
            this.id,
            this.serialNumber,
            this.name,
            this.shortName,
            this.businessType,
            this.contractAmount,
            this.haveInvoiceAmount,
            this.haveCollectionAmount,
            this.isTax,
            this.invoiceType,
            this.payType,
            this.customerUnit,
            this.socialCode,
            this.customerBankUserName,
            this.customerBankCode,
            this.customerBankName,
            this.status,
            this.companyBankAccountList
         );
      }

      @Override
      public String toString() {
         return "ProjectSimpleDTO.ProjectSimpleDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", businessType="
            + this.businessType
            + ", contractAmount="
            + this.contractAmount
            + ", haveInvoiceAmount="
            + this.haveInvoiceAmount
            + ", haveCollectionAmount="
            + this.haveCollectionAmount
            + ", isTax="
            + this.isTax
            + ", invoiceType="
            + this.invoiceType
            + ", payType="
            + this.payType
            + ", customerUnit="
            + this.customerUnit
            + ", socialCode="
            + this.socialCode
            + ", customerBankUserName="
            + this.customerBankUserName
            + ", customerBankCode="
            + this.customerBankCode
            + ", customerBankName="
            + this.customerBankName
            + ", status="
            + this.status
            + ", companyBankAccountList="
            + this.companyBankAccountList
            + ")";
      }
   }
}
