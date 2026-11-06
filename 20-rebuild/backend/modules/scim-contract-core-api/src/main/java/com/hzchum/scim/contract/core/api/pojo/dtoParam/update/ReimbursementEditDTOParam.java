package com.hzchum.scim.contract.core.api.pojo.dtoParam.update;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel("报销-重新编辑类")
public class ReimbursementEditDTOParam {
   @ApiModelProperty(name = "id", value = "报销id")
   @NotNull(message = "项目id不能为空")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty(name = "applyAmount", value = "申请金额")
   @NotNull(message = "申请金额不能为空")
   private BigDecimal applyAmount;
   @ApiModelProperty(name = "applyDepartId", value = "申请人部门id")
   @NotNull(message = "申请人部门id不能为空")
   private Long applyDepartId;
   @ApiModelProperty(name = "applyUserId", value = "申请人id")
   @NotNull(message = "申请人id不能为空")
   private Long applyUserId;
   @ApiModelProperty(name = "applyDate", value = "申请日期")
   @NotNull(message = "申请日期不能为空")
   private LocalDate applyDate;
   @ApiModelProperty(name = "collectionDepositBank", value = "收款开户行")
   private String collectionDepositBank;
   @ApiModelProperty(name = "collectionBankAccount", value = "收款银行账号")
   private String collectionBankAccount;
   @ApiModelProperty(name = "collectionUserId", value = "收款人id (默认是申请人)")
   @NotNull(message = "收款人id不能为空")
   private Long collectionUserId;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "detailList", value = "修改费用明细列表")
   private List<ReimbursementDetailEditDTOParam> detailList;

   public static ReimbursementEditDTOParam.ReimbursementEditDTOParamBuilder builder() {
      return new ReimbursementEditDTOParam.ReimbursementEditDTOParamBuilder();
   }

   public ReimbursementEditDTOParam() {
   }

   public ReimbursementEditDTOParam(
      final Long id,
      final Long projectId,
      final BigDecimal applyAmount,
      final Long applyDepartId,
      final Long applyUserId,
      final LocalDate applyDate,
      final String collectionDepositBank,
      final String collectionBankAccount,
      final Long collectionUserId,
      final String remark,
      final List<ReimbursementDetailEditDTOParam> detailList
   ) {
      this.id = id;
      this.projectId = projectId;
      this.applyAmount = applyAmount;
      this.applyDepartId = applyDepartId;
      this.applyUserId = applyUserId;
      this.applyDate = applyDate;
      this.collectionDepositBank = collectionDepositBank;
      this.collectionBankAccount = collectionBankAccount;
      this.collectionUserId = collectionUserId;
      this.remark = remark;
      this.detailList = detailList;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getApplyAmount() {
      return this.applyAmount;
   }

   public Long getApplyDepartId() {
      return this.applyDepartId;
   }

   public Long getApplyUserId() {
      return this.applyUserId;
   }

   public LocalDate getApplyDate() {
      return this.applyDate;
   }

   public String getCollectionDepositBank() {
      return this.collectionDepositBank;
   }

   public String getCollectionBankAccount() {
      return this.collectionBankAccount;
   }

   public Long getCollectionUserId() {
      return this.collectionUserId;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<ReimbursementDetailEditDTOParam> getDetailList() {
      return this.detailList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setApplyAmount(final BigDecimal applyAmount) {
      this.applyAmount = applyAmount;
   }

   public void setApplyDepartId(final Long applyDepartId) {
      this.applyDepartId = applyDepartId;
   }

   public void setApplyUserId(final Long applyUserId) {
      this.applyUserId = applyUserId;
   }

   public void setApplyDate(final LocalDate applyDate) {
      this.applyDate = applyDate;
   }

   public void setCollectionDepositBank(final String collectionDepositBank) {
      this.collectionDepositBank = collectionDepositBank;
   }

   public void setCollectionBankAccount(final String collectionBankAccount) {
      this.collectionBankAccount = collectionBankAccount;
   }

   public void setCollectionUserId(final Long collectionUserId) {
      this.collectionUserId = collectionUserId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setDetailList(final List<ReimbursementDetailEditDTOParam> detailList) {
      this.detailList = detailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReimbursementEditDTOParam)) {
         return false;
      }

      ReimbursementEditDTOParam other = (ReimbursementEditDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$applyDepartId = this.getApplyDepartId();
            Object other$applyDepartId = other.getApplyDepartId();
            if (this$applyDepartId == null ? other$applyDepartId == null : this$applyDepartId.equals(other$applyDepartId)) {
               Object this$applyUserId = this.getApplyUserId();
               Object other$applyUserId = other.getApplyUserId();
               if (this$applyUserId == null ? other$applyUserId == null : this$applyUserId.equals(other$applyUserId)) {
                  Object this$collectionUserId = this.getCollectionUserId();
                  Object other$collectionUserId = other.getCollectionUserId();
                  if (this$collectionUserId == null ? other$collectionUserId == null : this$collectionUserId.equals(other$collectionUserId)) {
                     Object this$applyAmount = this.getApplyAmount();
                     Object other$applyAmount = other.getApplyAmount();
                     if (this$applyAmount == null ? other$applyAmount == null : this$applyAmount.equals(other$applyAmount)) {
                        Object this$applyDate = this.getApplyDate();
                        Object other$applyDate = other.getApplyDate();
                        if (this$applyDate == null ? other$applyDate == null : this$applyDate.equals(other$applyDate)) {
                           Object this$collectionDepositBank = this.getCollectionDepositBank();
                           Object other$collectionDepositBank = other.getCollectionDepositBank();
                           if (this$collectionDepositBank == null
                              ? other$collectionDepositBank == null
                              : this$collectionDepositBank.equals(other$collectionDepositBank)) {
                              Object this$collectionBankAccount = this.getCollectionBankAccount();
                              Object other$collectionBankAccount = other.getCollectionBankAccount();
                              if (this$collectionBankAccount == null
                                 ? other$collectionBankAccount == null
                                 : this$collectionBankAccount.equals(other$collectionBankAccount)) {
                                 Object this$remark = this.getRemark();
                                 Object other$remark = other.getRemark();
                                 if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                    Object this$detailList = this.getDetailList();
                                    Object other$detailList = other.getDetailList();
                                    return this$detailList == null ? other$detailList == null : this$detailList.equals(other$detailList);
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
      return other instanceof ReimbursementEditDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $applyDepartId = this.getApplyDepartId();
      result = result * 59 + ($applyDepartId == null ? 43 : $applyDepartId.hashCode());
      Object $applyUserId = this.getApplyUserId();
      result = result * 59 + ($applyUserId == null ? 43 : $applyUserId.hashCode());
      Object $collectionUserId = this.getCollectionUserId();
      result = result * 59 + ($collectionUserId == null ? 43 : $collectionUserId.hashCode());
      Object $applyAmount = this.getApplyAmount();
      result = result * 59 + ($applyAmount == null ? 43 : $applyAmount.hashCode());
      Object $applyDate = this.getApplyDate();
      result = result * 59 + ($applyDate == null ? 43 : $applyDate.hashCode());
      Object $collectionDepositBank = this.getCollectionDepositBank();
      result = result * 59 + ($collectionDepositBank == null ? 43 : $collectionDepositBank.hashCode());
      Object $collectionBankAccount = this.getCollectionBankAccount();
      result = result * 59 + ($collectionBankAccount == null ? 43 : $collectionBankAccount.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $detailList = this.getDetailList();
      return result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
   }

   @Override
   public String toString() {
      return "ReimbursementEditDTOParam(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", applyAmount="
         + this.getApplyAmount()
         + ", applyDepartId="
         + this.getApplyDepartId()
         + ", applyUserId="
         + this.getApplyUserId()
         + ", applyDate="
         + this.getApplyDate()
         + ", collectionDepositBank="
         + this.getCollectionDepositBank()
         + ", collectionBankAccount="
         + this.getCollectionBankAccount()
         + ", collectionUserId="
         + this.getCollectionUserId()
         + ", remark="
         + this.getRemark()
         + ", detailList="
         + this.getDetailList()
         + ")";
   }

   public static class ReimbursementEditDTOParamBuilder {
      private Long id;
      private Long projectId;
      private BigDecimal applyAmount;
      private Long applyDepartId;
      private Long applyUserId;
      private LocalDate applyDate;
      private String collectionDepositBank;
      private String collectionBankAccount;
      private Long collectionUserId;
      private String remark;
      private List<ReimbursementDetailEditDTOParam> detailList;

      ReimbursementEditDTOParamBuilder() {
      }

      public ReimbursementEditDTOParam.ReimbursementEditDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ReimbursementEditDTOParam.ReimbursementEditDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ReimbursementEditDTOParam.ReimbursementEditDTOParamBuilder applyAmount(final BigDecimal applyAmount) {
         this.applyAmount = applyAmount;
         return this;
      }

      public ReimbursementEditDTOParam.ReimbursementEditDTOParamBuilder applyDepartId(final Long applyDepartId) {
         this.applyDepartId = applyDepartId;
         return this;
      }

      public ReimbursementEditDTOParam.ReimbursementEditDTOParamBuilder applyUserId(final Long applyUserId) {
         this.applyUserId = applyUserId;
         return this;
      }

      public ReimbursementEditDTOParam.ReimbursementEditDTOParamBuilder applyDate(final LocalDate applyDate) {
         this.applyDate = applyDate;
         return this;
      }

      public ReimbursementEditDTOParam.ReimbursementEditDTOParamBuilder collectionDepositBank(final String collectionDepositBank) {
         this.collectionDepositBank = collectionDepositBank;
         return this;
      }

      public ReimbursementEditDTOParam.ReimbursementEditDTOParamBuilder collectionBankAccount(final String collectionBankAccount) {
         this.collectionBankAccount = collectionBankAccount;
         return this;
      }

      public ReimbursementEditDTOParam.ReimbursementEditDTOParamBuilder collectionUserId(final Long collectionUserId) {
         this.collectionUserId = collectionUserId;
         return this;
      }

      public ReimbursementEditDTOParam.ReimbursementEditDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ReimbursementEditDTOParam.ReimbursementEditDTOParamBuilder detailList(final List<ReimbursementDetailEditDTOParam> detailList) {
         this.detailList = detailList;
         return this;
      }

      public ReimbursementEditDTOParam build() {
         return new ReimbursementEditDTOParam(
            this.id,
            this.projectId,
            this.applyAmount,
            this.applyDepartId,
            this.applyUserId,
            this.applyDate,
            this.collectionDepositBank,
            this.collectionBankAccount,
            this.collectionUserId,
            this.remark,
            this.detailList
         );
      }

      @Override
      public String toString() {
         return "ReimbursementEditDTOParam.ReimbursementEditDTOParamBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", applyAmount="
            + this.applyAmount
            + ", applyDepartId="
            + this.applyDepartId
            + ", applyUserId="
            + this.applyUserId
            + ", applyDate="
            + this.applyDate
            + ", collectionDepositBank="
            + this.collectionDepositBank
            + ", collectionBankAccount="
            + this.collectionBankAccount
            + ", collectionUserId="
            + this.collectionUserId
            + ", remark="
            + this.remark
            + ", detailList="
            + this.detailList
            + ")";
      }
   }
}
