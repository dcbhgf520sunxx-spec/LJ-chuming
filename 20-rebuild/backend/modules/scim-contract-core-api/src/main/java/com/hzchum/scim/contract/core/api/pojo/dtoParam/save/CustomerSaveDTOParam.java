package com.hzchum.scim.contract.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel("客户信息 新增类")
public class CustomerSaveDTOParam {
   @NotBlank(message = "客户单位名称不能为空")
   @Size(max = 50, message = "字数超出限制!")
   @ApiModelProperty(name = "customer_unit", notes = "客户单位名称")
   private String customerUnit;
   @Size(max = 50, message = "字数超出限制!")
   @ApiModelProperty(name = "social_code", notes = "客户统一社会信用代码")
   private String socialCode;
   @Size(max = 50, message = "字数超出限制!")
   @ApiModelProperty(name = "customer_unit_phone", notes = "客户单位电话")
   private String customerUnitPhone;
   @ApiModelProperty(name = "customer_province_id", notes = "客户单位省id")
   private Long customerProvinceId;
   @ApiModelProperty(name = "customer_city_id", notes = "客户单位城市id")
   private Long customerCityId;
   @ApiModelProperty(name = "customer_region_id", notes = "客户单位区ID")
   private Long customerRegionId;
   @ApiModelProperty(name = "customer_country_id", notes = "客户单位国家id")
   private Long customerCountryId;
   @Size(max = 50, message = "客户单位详细地址-字数超出限制!")
   @ApiModelProperty(name = "customer_address", notes = "客户单位详细地址")
   private String customerAddress;
   @Size(max = 50, message = "银行账户户名-字数超出限制!")
   @ApiModelProperty(name = "customer_bank_user_name", notes = "银行账户户名")
   private String customerBankUserName;
   @Size(max = 50, message = "银行账户账号-字数超出限制!")
   @ApiModelProperty(name = "customer_bank_code", notes = "银行账户账号")
   private String customerBankCode;
   @Size(max = 50, message = "开户行-字数超出限制!")
   @ApiModelProperty(name = "customer_bank_name", notes = "开户行   (中国工商银行...)")
   private String customerBankName;
   @Size(max = 50, message = "客户负责人1姓名-字数超出限制!")
   @ApiModelProperty(name = "customer_manager_one", notes = "客户负责人1姓名")
   private String customerManagerOne;
   @Size(max = 50, message = "客户负责人1电话-字数超出限制!")
   @ApiModelProperty(name = "customer_manager_one_phone", notes = "客户负责人1电话")
   private String customerManagerOnePhone;
   @Size(max = 50, message = "客户负责人2姓名-字数超出限制!")
   @ApiModelProperty(name = "customer_manager_two", notes = "客户负责人2姓名")
   private String customerManagerTwo;
   @Size(max = 50, message = "客户负责人2电话-字数超出限制!")
   @ApiModelProperty(name = "customer_manager_two_phone", notes = "客户负责人2电话")
   private String customerManagerTwoPhone;
   @Size(max = 50, message = "客户邮箱-字数超出限制!")
   @ApiModelProperty(name = "customer_email", notes = "客户邮箱")
   private String customerEmail;
   @Size(max = 20, message = "收货负责人-字数超出限制!")
   @ApiModelProperty(name = "receivingManager", notes = "收货负责人")
   private String receivingManager;
   @Size(max = 20, message = "收货负责人电话-字数超出限制!")
   @ApiModelProperty(name = "receivingManagerPhone", notes = "收货负责人电话")
   private String receivingManagerPhone;
   @Size(max = 20, message = "结算负责人-字数超出限制!")
   @ApiModelProperty(name = "settleManager", notes = "结算负责人")
   private String settleManager;
   @Size(max = 20, message = "结算负责人电话-字数超出限制!")
   @ApiModelProperty(name = "settleManagerPhone", notes = "结算负责人电话")
   private String settleManagerPhone;
   @Size(max = 20, message = "财务负责人-字数超出限制!")
   @ApiModelProperty(name = "financeManager", notes = "财务负责人")
   private String financeManager;
   @Size(max = 20, message = "财务负责人电话-字数超出限制!")
   @ApiModelProperty(name = "financeManagerPhone", notes = "财务负责人电话")
   private String financeManagerPhone;
   @Size(max = 20, message = "审核负责人-字数超出限制!")
   @ApiModelProperty(name = "auditManager", notes = "审核负责人")
   private String auditManager;
   @Size(max = 20, message = "审核负责人电话-字数超出限制!")
   @ApiModelProperty(name = "auditManagerPhone", notes = "审核负责人电话")
   private String auditManagerPhone;
   @Size(max = 20, message = "设计负责人-字数超出限制!")
   @ApiModelProperty(name = "designManager", notes = "设计负责人")
   private String designManager;
   @Size(max = 20, message = "设计负责人电话-字数超出限制!")
   @ApiModelProperty(name = "designManagerPhone", notes = "设计负责人电话")
   private String designManagerPhone;
   @Size(max = 1000, message = "客户信息备注-字数超出限制!")
   @ApiModelProperty(name = "customerRemark", notes = "客户信息备注")
   private String customerRemark;

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public String getSocialCode() {
      return this.socialCode;
   }

   public String getCustomerUnitPhone() {
      return this.customerUnitPhone;
   }

   public Long getCustomerProvinceId() {
      return this.customerProvinceId;
   }

   public Long getCustomerCityId() {
      return this.customerCityId;
   }

   public Long getCustomerRegionId() {
      return this.customerRegionId;
   }

   public Long getCustomerCountryId() {
      return this.customerCountryId;
   }

   public String getCustomerAddress() {
      return this.customerAddress;
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

   public String getCustomerManagerOne() {
      return this.customerManagerOne;
   }

   public String getCustomerManagerOnePhone() {
      return this.customerManagerOnePhone;
   }

   public String getCustomerManagerTwo() {
      return this.customerManagerTwo;
   }

   public String getCustomerManagerTwoPhone() {
      return this.customerManagerTwoPhone;
   }

   public String getCustomerEmail() {
      return this.customerEmail;
   }

   public String getReceivingManager() {
      return this.receivingManager;
   }

   public String getReceivingManagerPhone() {
      return this.receivingManagerPhone;
   }

   public String getSettleManager() {
      return this.settleManager;
   }

   public String getSettleManagerPhone() {
      return this.settleManagerPhone;
   }

   public String getFinanceManager() {
      return this.financeManager;
   }

   public String getFinanceManagerPhone() {
      return this.financeManagerPhone;
   }

   public String getAuditManager() {
      return this.auditManager;
   }

   public String getAuditManagerPhone() {
      return this.auditManagerPhone;
   }

   public String getDesignManager() {
      return this.designManager;
   }

   public String getDesignManagerPhone() {
      return this.designManagerPhone;
   }

   public String getCustomerRemark() {
      return this.customerRemark;
   }

   public void setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
   }

   public void setSocialCode(final String socialCode) {
      this.socialCode = socialCode;
   }

   public void setCustomerUnitPhone(final String customerUnitPhone) {
      this.customerUnitPhone = customerUnitPhone;
   }

   public void setCustomerProvinceId(final Long customerProvinceId) {
      this.customerProvinceId = customerProvinceId;
   }

   public void setCustomerCityId(final Long customerCityId) {
      this.customerCityId = customerCityId;
   }

   public void setCustomerRegionId(final Long customerRegionId) {
      this.customerRegionId = customerRegionId;
   }

   public void setCustomerCountryId(final Long customerCountryId) {
      this.customerCountryId = customerCountryId;
   }

   public void setCustomerAddress(final String customerAddress) {
      this.customerAddress = customerAddress;
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

   public void setCustomerManagerOne(final String customerManagerOne) {
      this.customerManagerOne = customerManagerOne;
   }

   public void setCustomerManagerOnePhone(final String customerManagerOnePhone) {
      this.customerManagerOnePhone = customerManagerOnePhone;
   }

   public void setCustomerManagerTwo(final String customerManagerTwo) {
      this.customerManagerTwo = customerManagerTwo;
   }

   public void setCustomerManagerTwoPhone(final String customerManagerTwoPhone) {
      this.customerManagerTwoPhone = customerManagerTwoPhone;
   }

   public void setCustomerEmail(final String customerEmail) {
      this.customerEmail = customerEmail;
   }

   public void setReceivingManager(final String receivingManager) {
      this.receivingManager = receivingManager;
   }

   public void setReceivingManagerPhone(final String receivingManagerPhone) {
      this.receivingManagerPhone = receivingManagerPhone;
   }

   public void setSettleManager(final String settleManager) {
      this.settleManager = settleManager;
   }

   public void setSettleManagerPhone(final String settleManagerPhone) {
      this.settleManagerPhone = settleManagerPhone;
   }

   public void setFinanceManager(final String financeManager) {
      this.financeManager = financeManager;
   }

   public void setFinanceManagerPhone(final String financeManagerPhone) {
      this.financeManagerPhone = financeManagerPhone;
   }

   public void setAuditManager(final String auditManager) {
      this.auditManager = auditManager;
   }

   public void setAuditManagerPhone(final String auditManagerPhone) {
      this.auditManagerPhone = auditManagerPhone;
   }

   public void setDesignManager(final String designManager) {
      this.designManager = designManager;
   }

   public void setDesignManagerPhone(final String designManagerPhone) {
      this.designManagerPhone = designManagerPhone;
   }

   public void setCustomerRemark(final String customerRemark) {
      this.customerRemark = customerRemark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CustomerSaveDTOParam)) {
         return false;
      }

      CustomerSaveDTOParam other = (CustomerSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$customerProvinceId = this.getCustomerProvinceId();
      Object other$customerProvinceId = other.getCustomerProvinceId();
      if (this$customerProvinceId == null ? other$customerProvinceId == null : this$customerProvinceId.equals(other$customerProvinceId)) {
         Object this$customerCityId = this.getCustomerCityId();
         Object other$customerCityId = other.getCustomerCityId();
         if (this$customerCityId == null ? other$customerCityId == null : this$customerCityId.equals(other$customerCityId)) {
            Object this$customerRegionId = this.getCustomerRegionId();
            Object other$customerRegionId = other.getCustomerRegionId();
            if (this$customerRegionId == null ? other$customerRegionId == null : this$customerRegionId.equals(other$customerRegionId)) {
               Object this$customerCountryId = this.getCustomerCountryId();
               Object other$customerCountryId = other.getCustomerCountryId();
               if (this$customerCountryId == null ? other$customerCountryId == null : this$customerCountryId.equals(other$customerCountryId)) {
                  Object this$customerUnit = this.getCustomerUnit();
                  Object other$customerUnit = other.getCustomerUnit();
                  if (this$customerUnit == null ? other$customerUnit == null : this$customerUnit.equals(other$customerUnit)) {
                     Object this$socialCode = this.getSocialCode();
                     Object other$socialCode = other.getSocialCode();
                     if (this$socialCode == null ? other$socialCode == null : this$socialCode.equals(other$socialCode)) {
                        Object this$customerUnitPhone = this.getCustomerUnitPhone();
                        Object other$customerUnitPhone = other.getCustomerUnitPhone();
                        if (this$customerUnitPhone == null ? other$customerUnitPhone == null : this$customerUnitPhone.equals(other$customerUnitPhone)) {
                           Object this$customerAddress = this.getCustomerAddress();
                           Object other$customerAddress = other.getCustomerAddress();
                           if (this$customerAddress == null ? other$customerAddress == null : this$customerAddress.equals(other$customerAddress)) {
                              Object this$customerBankUserName = this.getCustomerBankUserName();
                              Object other$customerBankUserName = other.getCustomerBankUserName();
                              if (this$customerBankUserName == null
                                 ? other$customerBankUserName == null
                                 : this$customerBankUserName.equals(other$customerBankUserName)) {
                                 Object this$customerBankCode = this.getCustomerBankCode();
                                 Object other$customerBankCode = other.getCustomerBankCode();
                                 if (this$customerBankCode == null ? other$customerBankCode == null : this$customerBankCode.equals(other$customerBankCode)) {
                                    Object this$customerBankName = this.getCustomerBankName();
                                    Object other$customerBankName = other.getCustomerBankName();
                                    if (this$customerBankName == null ? other$customerBankName == null : this$customerBankName.equals(other$customerBankName)) {
                                       Object this$customerManagerOne = this.getCustomerManagerOne();
                                       Object other$customerManagerOne = other.getCustomerManagerOne();
                                       if (this$customerManagerOne == null
                                          ? other$customerManagerOne == null
                                          : this$customerManagerOne.equals(other$customerManagerOne)) {
                                          Object this$customerManagerOnePhone = this.getCustomerManagerOnePhone();
                                          Object other$customerManagerOnePhone = other.getCustomerManagerOnePhone();
                                          if (this$customerManagerOnePhone == null
                                             ? other$customerManagerOnePhone == null
                                             : this$customerManagerOnePhone.equals(other$customerManagerOnePhone)) {
                                             Object this$customerManagerTwo = this.getCustomerManagerTwo();
                                             Object other$customerManagerTwo = other.getCustomerManagerTwo();
                                             if (this$customerManagerTwo == null
                                                ? other$customerManagerTwo == null
                                                : this$customerManagerTwo.equals(other$customerManagerTwo)) {
                                                Object this$customerManagerTwoPhone = this.getCustomerManagerTwoPhone();
                                                Object other$customerManagerTwoPhone = other.getCustomerManagerTwoPhone();
                                                if (this$customerManagerTwoPhone == null
                                                   ? other$customerManagerTwoPhone == null
                                                   : this$customerManagerTwoPhone.equals(other$customerManagerTwoPhone)) {
                                                   Object this$customerEmail = this.getCustomerEmail();
                                                   Object other$customerEmail = other.getCustomerEmail();
                                                   if (this$customerEmail == null
                                                      ? other$customerEmail == null
                                                      : this$customerEmail.equals(other$customerEmail)) {
                                                      Object this$receivingManager = this.getReceivingManager();
                                                      Object other$receivingManager = other.getReceivingManager();
                                                      if (this$receivingManager == null
                                                         ? other$receivingManager == null
                                                         : this$receivingManager.equals(other$receivingManager)) {
                                                         Object this$receivingManagerPhone = this.getReceivingManagerPhone();
                                                         Object other$receivingManagerPhone = other.getReceivingManagerPhone();
                                                         if (this$receivingManagerPhone == null
                                                            ? other$receivingManagerPhone == null
                                                            : this$receivingManagerPhone.equals(other$receivingManagerPhone)) {
                                                            Object this$settleManager = this.getSettleManager();
                                                            Object other$settleManager = other.getSettleManager();
                                                            if (this$settleManager == null
                                                               ? other$settleManager == null
                                                               : this$settleManager.equals(other$settleManager)) {
                                                               Object this$settleManagerPhone = this.getSettleManagerPhone();
                                                               Object other$settleManagerPhone = other.getSettleManagerPhone();
                                                               if (this$settleManagerPhone == null
                                                                  ? other$settleManagerPhone == null
                                                                  : this$settleManagerPhone.equals(other$settleManagerPhone)) {
                                                                  Object this$financeManager = this.getFinanceManager();
                                                                  Object other$financeManager = other.getFinanceManager();
                                                                  if (this$financeManager == null
                                                                     ? other$financeManager == null
                                                                     : this$financeManager.equals(other$financeManager)) {
                                                                     Object this$financeManagerPhone = this.getFinanceManagerPhone();
                                                                     Object other$financeManagerPhone = other.getFinanceManagerPhone();
                                                                     if (this$financeManagerPhone == null
                                                                        ? other$financeManagerPhone == null
                                                                        : this$financeManagerPhone.equals(other$financeManagerPhone)) {
                                                                        Object this$auditManager = this.getAuditManager();
                                                                        Object other$auditManager = other.getAuditManager();
                                                                        if (this$auditManager == null
                                                                           ? other$auditManager == null
                                                                           : this$auditManager.equals(other$auditManager)) {
                                                                           Object this$auditManagerPhone = this.getAuditManagerPhone();
                                                                           Object other$auditManagerPhone = other.getAuditManagerPhone();
                                                                           if (this$auditManagerPhone == null
                                                                              ? other$auditManagerPhone == null
                                                                              : this$auditManagerPhone.equals(other$auditManagerPhone)) {
                                                                              Object this$designManager = this.getDesignManager();
                                                                              Object other$designManager = other.getDesignManager();
                                                                              if (this$designManager == null
                                                                                 ? other$designManager == null
                                                                                 : this$designManager.equals(other$designManager)) {
                                                                                 Object this$designManagerPhone = this.getDesignManagerPhone();
                                                                                 Object other$designManagerPhone = other.getDesignManagerPhone();
                                                                                 if (this$designManagerPhone == null
                                                                                    ? other$designManagerPhone == null
                                                                                    : this$designManagerPhone.equals(other$designManagerPhone)) {
                                                                                    Object this$customerRemark = this.getCustomerRemark();
                                                                                    Object other$customerRemark = other.getCustomerRemark();
                                                                                    return this$customerRemark == null
                                                                                       ? other$customerRemark == null
                                                                                       : this$customerRemark.equals(other$customerRemark);
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
      return other instanceof CustomerSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $customerProvinceId = this.getCustomerProvinceId();
      result = result * 59 + ($customerProvinceId == null ? 43 : $customerProvinceId.hashCode());
      Object $customerCityId = this.getCustomerCityId();
      result = result * 59 + ($customerCityId == null ? 43 : $customerCityId.hashCode());
      Object $customerRegionId = this.getCustomerRegionId();
      result = result * 59 + ($customerRegionId == null ? 43 : $customerRegionId.hashCode());
      Object $customerCountryId = this.getCustomerCountryId();
      result = result * 59 + ($customerCountryId == null ? 43 : $customerCountryId.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $socialCode = this.getSocialCode();
      result = result * 59 + ($socialCode == null ? 43 : $socialCode.hashCode());
      Object $customerUnitPhone = this.getCustomerUnitPhone();
      result = result * 59 + ($customerUnitPhone == null ? 43 : $customerUnitPhone.hashCode());
      Object $customerAddress = this.getCustomerAddress();
      result = result * 59 + ($customerAddress == null ? 43 : $customerAddress.hashCode());
      Object $customerBankUserName = this.getCustomerBankUserName();
      result = result * 59 + ($customerBankUserName == null ? 43 : $customerBankUserName.hashCode());
      Object $customerBankCode = this.getCustomerBankCode();
      result = result * 59 + ($customerBankCode == null ? 43 : $customerBankCode.hashCode());
      Object $customerBankName = this.getCustomerBankName();
      result = result * 59 + ($customerBankName == null ? 43 : $customerBankName.hashCode());
      Object $customerManagerOne = this.getCustomerManagerOne();
      result = result * 59 + ($customerManagerOne == null ? 43 : $customerManagerOne.hashCode());
      Object $customerManagerOnePhone = this.getCustomerManagerOnePhone();
      result = result * 59 + ($customerManagerOnePhone == null ? 43 : $customerManagerOnePhone.hashCode());
      Object $customerManagerTwo = this.getCustomerManagerTwo();
      result = result * 59 + ($customerManagerTwo == null ? 43 : $customerManagerTwo.hashCode());
      Object $customerManagerTwoPhone = this.getCustomerManagerTwoPhone();
      result = result * 59 + ($customerManagerTwoPhone == null ? 43 : $customerManagerTwoPhone.hashCode());
      Object $customerEmail = this.getCustomerEmail();
      result = result * 59 + ($customerEmail == null ? 43 : $customerEmail.hashCode());
      Object $receivingManager = this.getReceivingManager();
      result = result * 59 + ($receivingManager == null ? 43 : $receivingManager.hashCode());
      Object $receivingManagerPhone = this.getReceivingManagerPhone();
      result = result * 59 + ($receivingManagerPhone == null ? 43 : $receivingManagerPhone.hashCode());
      Object $settleManager = this.getSettleManager();
      result = result * 59 + ($settleManager == null ? 43 : $settleManager.hashCode());
      Object $settleManagerPhone = this.getSettleManagerPhone();
      result = result * 59 + ($settleManagerPhone == null ? 43 : $settleManagerPhone.hashCode());
      Object $financeManager = this.getFinanceManager();
      result = result * 59 + ($financeManager == null ? 43 : $financeManager.hashCode());
      Object $financeManagerPhone = this.getFinanceManagerPhone();
      result = result * 59 + ($financeManagerPhone == null ? 43 : $financeManagerPhone.hashCode());
      Object $auditManager = this.getAuditManager();
      result = result * 59 + ($auditManager == null ? 43 : $auditManager.hashCode());
      Object $auditManagerPhone = this.getAuditManagerPhone();
      result = result * 59 + ($auditManagerPhone == null ? 43 : $auditManagerPhone.hashCode());
      Object $designManager = this.getDesignManager();
      result = result * 59 + ($designManager == null ? 43 : $designManager.hashCode());
      Object $designManagerPhone = this.getDesignManagerPhone();
      result = result * 59 + ($designManagerPhone == null ? 43 : $designManagerPhone.hashCode());
      Object $customerRemark = this.getCustomerRemark();
      return result * 59 + ($customerRemark == null ? 43 : $customerRemark.hashCode());
   }

   @Override
   public String toString() {
      return "CustomerSaveDTOParam(customerUnit="
         + this.getCustomerUnit()
         + ", socialCode="
         + this.getSocialCode()
         + ", customerUnitPhone="
         + this.getCustomerUnitPhone()
         + ", customerProvinceId="
         + this.getCustomerProvinceId()
         + ", customerCityId="
         + this.getCustomerCityId()
         + ", customerRegionId="
         + this.getCustomerRegionId()
         + ", customerCountryId="
         + this.getCustomerCountryId()
         + ", customerAddress="
         + this.getCustomerAddress()
         + ", customerBankUserName="
         + this.getCustomerBankUserName()
         + ", customerBankCode="
         + this.getCustomerBankCode()
         + ", customerBankName="
         + this.getCustomerBankName()
         + ", customerManagerOne="
         + this.getCustomerManagerOne()
         + ", customerManagerOnePhone="
         + this.getCustomerManagerOnePhone()
         + ", customerManagerTwo="
         + this.getCustomerManagerTwo()
         + ", customerManagerTwoPhone="
         + this.getCustomerManagerTwoPhone()
         + ", customerEmail="
         + this.getCustomerEmail()
         + ", receivingManager="
         + this.getReceivingManager()
         + ", receivingManagerPhone="
         + this.getReceivingManagerPhone()
         + ", settleManager="
         + this.getSettleManager()
         + ", settleManagerPhone="
         + this.getSettleManagerPhone()
         + ", financeManager="
         + this.getFinanceManager()
         + ", financeManagerPhone="
         + this.getFinanceManagerPhone()
         + ", auditManager="
         + this.getAuditManager()
         + ", auditManagerPhone="
         + this.getAuditManagerPhone()
         + ", designManager="
         + this.getDesignManager()
         + ", designManagerPhone="
         + this.getDesignManagerPhone()
         + ", customerRemark="
         + this.getCustomerRemark()
         + ")";
   }
}
