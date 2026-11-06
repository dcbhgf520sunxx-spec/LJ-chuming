package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("报销填报 类")
public class ReimbursementSaveDTOParam {
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
   @ApiModelProperty(name = "source", value = "来源 1当前系统 2钉钉")
   private Integer source;
   @ApiModelProperty(name = "detailList", value = "新增费用明细列表")
   @NotEmpty(message = "新增费用明细列表不能为空")
   private List<ReimbursementDetailSaveDTOParam> detailList;

   public static ReimbursementSaveDTOParam.ReimbursementSaveDTOParamBuilder builder() {
      return new ReimbursementSaveDTOParam.ReimbursementSaveDTOParamBuilder();
   }

   public ReimbursementSaveDTOParam() {
   }

   public ReimbursementSaveDTOParam(
      final Long projectId,
      final BigDecimal applyAmount,
      final Long applyDepartId,
      final Long applyUserId,
      final LocalDate applyDate,
      final String collectionDepositBank,
      final String collectionBankAccount,
      final Long collectionUserId,
      final String remark,
      final Integer source,
      final List<ReimbursementDetailSaveDTOParam> detailList
   ) {
      this.projectId = projectId;
      this.applyAmount = applyAmount;
      this.applyDepartId = applyDepartId;
      this.applyUserId = applyUserId;
      this.applyDate = applyDate;
      this.collectionDepositBank = collectionDepositBank;
      this.collectionBankAccount = collectionBankAccount;
      this.collectionUserId = collectionUserId;
      this.remark = remark;
      this.source = source;
      this.detailList = detailList;
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

   public Integer getSource() {
      return this.source;
   }

   public List<ReimbursementDetailSaveDTOParam> getDetailList() {
      return this.detailList;
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

   public void setSource(final Integer source) {
      this.source = source;
   }

   public void setDetailList(final List<ReimbursementDetailSaveDTOParam> detailList) {
      this.detailList = detailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReimbursementSaveDTOParam)) {
         return false;
      }

      ReimbursementSaveDTOParam other = (ReimbursementSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

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
                  Object this$source = this.getSource();
                  Object other$source = other.getSource();
                  if (this$source == null ? other$source == null : this$source.equals(other$source)) {
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
      return other instanceof ReimbursementSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $applyDepartId = this.getApplyDepartId();
      result = result * 59 + ($applyDepartId == null ? 43 : $applyDepartId.hashCode());
      Object $applyUserId = this.getApplyUserId();
      result = result * 59 + ($applyUserId == null ? 43 : $applyUserId.hashCode());
      Object $collectionUserId = this.getCollectionUserId();
      result = result * 59 + ($collectionUserId == null ? 43 : $collectionUserId.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
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
      return "ReimbursementSaveDTOParam(projectId="
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
         + ", source="
         + this.getSource()
         + ", detailList="
         + this.getDetailList()
         + ")";
   }

   public static class ReimbursementSaveDTOParamBuilder {
      private Long projectId;
      private BigDecimal applyAmount;
      private Long applyDepartId;
      private Long applyUserId;
      private LocalDate applyDate;
      private String collectionDepositBank;
      private String collectionBankAccount;
      private Long collectionUserId;
      private String remark;
      private Integer source;
      private List<ReimbursementDetailSaveDTOParam> detailList;

      ReimbursementSaveDTOParamBuilder() {
      }

      public ReimbursementSaveDTOParam.ReimbursementSaveDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ReimbursementSaveDTOParam.ReimbursementSaveDTOParamBuilder applyAmount(final BigDecimal applyAmount) {
         this.applyAmount = applyAmount;
         return this;
      }

      public ReimbursementSaveDTOParam.ReimbursementSaveDTOParamBuilder applyDepartId(final Long applyDepartId) {
         this.applyDepartId = applyDepartId;
         return this;
      }

      public ReimbursementSaveDTOParam.ReimbursementSaveDTOParamBuilder applyUserId(final Long applyUserId) {
         this.applyUserId = applyUserId;
         return this;
      }

      public ReimbursementSaveDTOParam.ReimbursementSaveDTOParamBuilder applyDate(final LocalDate applyDate) {
         this.applyDate = applyDate;
         return this;
      }

      public ReimbursementSaveDTOParam.ReimbursementSaveDTOParamBuilder collectionDepositBank(final String collectionDepositBank) {
         this.collectionDepositBank = collectionDepositBank;
         return this;
      }

      public ReimbursementSaveDTOParam.ReimbursementSaveDTOParamBuilder collectionBankAccount(final String collectionBankAccount) {
         this.collectionBankAccount = collectionBankAccount;
         return this;
      }

      public ReimbursementSaveDTOParam.ReimbursementSaveDTOParamBuilder collectionUserId(final Long collectionUserId) {
         this.collectionUserId = collectionUserId;
         return this;
      }

      public ReimbursementSaveDTOParam.ReimbursementSaveDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ReimbursementSaveDTOParam.ReimbursementSaveDTOParamBuilder source(final Integer source) {
         this.source = source;
         return this;
      }

      public ReimbursementSaveDTOParam.ReimbursementSaveDTOParamBuilder detailList(final List<ReimbursementDetailSaveDTOParam> detailList) {
         this.detailList = detailList;
         return this;
      }

      public ReimbursementSaveDTOParam build() {
         return new ReimbursementSaveDTOParam(
            this.projectId,
            this.applyAmount,
            this.applyDepartId,
            this.applyUserId,
            this.applyDate,
            this.collectionDepositBank,
            this.collectionBankAccount,
            this.collectionUserId,
            this.remark,
            this.source,
            this.detailList
         );
      }

      @Override
      public String toString() {
         return "ReimbursementSaveDTOParam.ReimbursementSaveDTOParamBuilder(projectId="
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
            + ", source="
            + this.source
            + ", detailList="
            + this.detailList
            + ")";
      }
   }
}
