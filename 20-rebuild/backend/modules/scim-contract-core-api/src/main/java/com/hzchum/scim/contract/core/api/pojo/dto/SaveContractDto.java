package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class SaveContractDto {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "collectionUnitId", value = "收款单位id")
   private Long collectionUnitId;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "projectAttribute", value = "项目类型")
   private Integer projectAttribute;
   @ApiModelProperty(name = "projectManagerName", value = "项目经理姓名")
   private String projectManagerName;
   @ApiModelProperty(name = "projectManagerId", notes = "项目经理id")
   private Long projectManagerId;
   @ApiModelProperty(name = "collectionAmountSum", value = "已收款金额")
   private BigDecimal collectionAmountSum;
   @ApiModelProperty(name = "paymentUnit", value = "付款单位")
   private String paymentUnit;
   @ApiModelProperty(name = "paymentDepositBank", value = "付款方银行")
   private String paymentDepositBank;
   @ApiModelProperty(name = "collectionDepositBank", value = "收款开户行")
   private String collectionDepositBank;
   @ApiModelProperty(name = "collectionDepositBankList", value = "收款开户行列表")
   private List<String> collectionDepositBankList;
   @ApiModelProperty(name = "collectionUnit", value = "收款单位")
   private String collectionUnit;
   @ApiModelProperty(name = "userId", value = "创建人id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "创建人姓名")
   private String userName;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getCollectionUnitId() {
      return this.collectionUnitId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public BigDecimal getCollectionAmountSum() {
      return this.collectionAmountSum;
   }

   public String getPaymentUnit() {
      return this.paymentUnit;
   }

   public String getPaymentDepositBank() {
      return this.paymentDepositBank;
   }

   public String getCollectionDepositBank() {
      return this.collectionDepositBank;
   }

   public List<String> getCollectionDepositBankList() {
      return this.collectionDepositBankList;
   }

   public String getCollectionUnit() {
      return this.collectionUnit;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public SaveContractDto setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public SaveContractDto setCollectionUnitId(final Long collectionUnitId) {
      this.collectionUnitId = collectionUnitId;
      return this;
   }

   public SaveContractDto setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public SaveContractDto setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   public SaveContractDto setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
      return this;
   }

   public SaveContractDto setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   public SaveContractDto setCollectionAmountSum(final BigDecimal collectionAmountSum) {
      this.collectionAmountSum = collectionAmountSum;
      return this;
   }

   public SaveContractDto setPaymentUnit(final String paymentUnit) {
      this.paymentUnit = paymentUnit;
      return this;
   }

   public SaveContractDto setPaymentDepositBank(final String paymentDepositBank) {
      this.paymentDepositBank = paymentDepositBank;
      return this;
   }

   public SaveContractDto setCollectionDepositBank(final String collectionDepositBank) {
      this.collectionDepositBank = collectionDepositBank;
      return this;
   }

   public SaveContractDto setCollectionDepositBankList(final List<String> collectionDepositBankList) {
      this.collectionDepositBankList = collectionDepositBankList;
      return this;
   }

   public SaveContractDto setCollectionUnit(final String collectionUnit) {
      this.collectionUnit = collectionUnit;
      return this;
   }

   public SaveContractDto setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public SaveContractDto setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SaveContractDto)) {
         return false;
      }

      SaveContractDto other = (SaveContractDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$collectionUnitId = this.getCollectionUnitId();
         Object other$collectionUnitId = other.getCollectionUnitId();
         if (this$collectionUnitId == null ? other$collectionUnitId == null : this$collectionUnitId.equals(other$collectionUnitId)) {
            Object this$projectAttribute = this.getProjectAttribute();
            Object other$projectAttribute = other.getProjectAttribute();
            if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
               Object this$projectManagerId = this.getProjectManagerId();
               Object other$projectManagerId = other.getProjectManagerId();
               if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$projectName = this.getProjectName();
                     Object other$projectName = other.getProjectName();
                     if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                        Object this$projectManagerName = this.getProjectManagerName();
                        Object other$projectManagerName = other.getProjectManagerName();
                        if (this$projectManagerName == null ? other$projectManagerName == null : this$projectManagerName.equals(other$projectManagerName)) {
                           Object this$collectionAmountSum = this.getCollectionAmountSum();
                           Object other$collectionAmountSum = other.getCollectionAmountSum();
                           if (this$collectionAmountSum == null
                              ? other$collectionAmountSum == null
                              : this$collectionAmountSum.equals(other$collectionAmountSum)) {
                              Object this$paymentUnit = this.getPaymentUnit();
                              Object other$paymentUnit = other.getPaymentUnit();
                              if (this$paymentUnit == null ? other$paymentUnit == null : this$paymentUnit.equals(other$paymentUnit)) {
                                 Object this$paymentDepositBank = this.getPaymentDepositBank();
                                 Object other$paymentDepositBank = other.getPaymentDepositBank();
                                 if (this$paymentDepositBank == null
                                    ? other$paymentDepositBank == null
                                    : this$paymentDepositBank.equals(other$paymentDepositBank)) {
                                    Object this$collectionDepositBank = this.getCollectionDepositBank();
                                    Object other$collectionDepositBank = other.getCollectionDepositBank();
                                    if (this$collectionDepositBank == null
                                       ? other$collectionDepositBank == null
                                       : this$collectionDepositBank.equals(other$collectionDepositBank)) {
                                       Object this$collectionDepositBankList = this.getCollectionDepositBankList();
                                       Object other$collectionDepositBankList = other.getCollectionDepositBankList();
                                       if (this$collectionDepositBankList == null
                                          ? other$collectionDepositBankList == null
                                          : this$collectionDepositBankList.equals(other$collectionDepositBankList)) {
                                          Object this$collectionUnit = this.getCollectionUnit();
                                          Object other$collectionUnit = other.getCollectionUnit();
                                          if (this$collectionUnit == null ? other$collectionUnit == null : this$collectionUnit.equals(other$collectionUnit)) {
                                             Object this$userName = this.getUserName();
                                             Object other$userName = other.getUserName();
                                             return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
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
      return other instanceof SaveContractDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $collectionUnitId = this.getCollectionUnitId();
      result = result * 59 + ($collectionUnitId == null ? 43 : $collectionUnitId.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $collectionAmountSum = this.getCollectionAmountSum();
      result = result * 59 + ($collectionAmountSum == null ? 43 : $collectionAmountSum.hashCode());
      Object $paymentUnit = this.getPaymentUnit();
      result = result * 59 + ($paymentUnit == null ? 43 : $paymentUnit.hashCode());
      Object $paymentDepositBank = this.getPaymentDepositBank();
      result = result * 59 + ($paymentDepositBank == null ? 43 : $paymentDepositBank.hashCode());
      Object $collectionDepositBank = this.getCollectionDepositBank();
      result = result * 59 + ($collectionDepositBank == null ? 43 : $collectionDepositBank.hashCode());
      Object $collectionDepositBankList = this.getCollectionDepositBankList();
      result = result * 59 + ($collectionDepositBankList == null ? 43 : $collectionDepositBankList.hashCode());
      Object $collectionUnit = this.getCollectionUnit();
      result = result * 59 + ($collectionUnit == null ? 43 : $collectionUnit.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "SaveContractDto(projectId="
         + this.getProjectId()
         + ", collectionUnitId="
         + this.getCollectionUnitId()
         + ", projectName="
         + this.getProjectName()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", collectionAmountSum="
         + this.getCollectionAmountSum()
         + ", paymentUnit="
         + this.getPaymentUnit()
         + ", paymentDepositBank="
         + this.getPaymentDepositBank()
         + ", collectionDepositBank="
         + this.getCollectionDepositBank()
         + ", collectionDepositBankList="
         + this.getCollectionDepositBankList()
         + ", collectionUnit="
         + this.getCollectionUnit()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ")";
   }

   public SaveContractDto(
      final Long projectId,
      final Long collectionUnitId,
      final String projectName,
      final Integer projectAttribute,
      final String projectManagerName,
      final Long projectManagerId,
      final BigDecimal collectionAmountSum,
      final String paymentUnit,
      final String paymentDepositBank,
      final String collectionDepositBank,
      final List<String> collectionDepositBankList,
      final String collectionUnit,
      final Long userId,
      final String userName
   ) {
      this.projectId = projectId;
      this.collectionUnitId = collectionUnitId;
      this.projectName = projectName;
      this.projectAttribute = projectAttribute;
      this.projectManagerName = projectManagerName;
      this.projectManagerId = projectManagerId;
      this.collectionAmountSum = collectionAmountSum;
      this.paymentUnit = paymentUnit;
      this.paymentDepositBank = paymentDepositBank;
      this.collectionDepositBank = collectionDepositBank;
      this.collectionDepositBankList = collectionDepositBankList;
      this.collectionUnit = collectionUnit;
      this.userId = userId;
      this.userName = userName;
   }

   public SaveContractDto() {
   }
}
