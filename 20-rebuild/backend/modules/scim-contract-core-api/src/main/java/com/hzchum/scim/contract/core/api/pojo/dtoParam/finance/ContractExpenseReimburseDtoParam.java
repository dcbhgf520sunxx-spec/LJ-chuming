package com.hzchum.scim.contract.core.api.pojo.dtoParam.finance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "ContractExpenseReimburse对象dto", description = "费用报销表 ")
public class ContractExpenseReimburseDtoParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "reimburseDate", value = "报销日期", notes = "报销日期")
   @NotNull(message = "日期不能为空")
   private LocalDate reimburseDate;
   @ApiModelProperty(name = "reimburseUserId", value = "报销人ID", notes = "报销人ID")
   @NotNull(message = "填报人不能为空")
   private Long reimburseUserId;
   @ApiModelProperty(name = "reimburseAmount", value = "报销金额", notes = "报销金额")
   @NotNull(message = "报销金额不能为空")
   @DecimalMin(value = "0.0001", message = "金额不合法")
   private BigDecimal reimburseAmount;
   @ApiModelProperty(name = "expenseTypeId", value = "费用分类ID", notes = "费用分类ID")
   @NotNull(message = "费用分类不能为空")
   private Long expenseTypeId;
   @ApiModelProperty(name = "expenseSubjectId", value = "费用科目ID", notes = "费用科目ID")
   @NotNull(message = "费用科目不能为空")
   private Long expenseSubjectId;
   @ApiModelProperty(name = "projectId", value = "关联项目id(可不填)", notes = "关联项目id(可不填)")
   private Long projectId;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @Size(max = 1000, message = "字数超出限制")
   private String remark;

   public static ContractExpenseReimburseDtoParam.ContractExpenseReimburseDtoParamBuilder builder() {
      return new ContractExpenseReimburseDtoParam.ContractExpenseReimburseDtoParamBuilder();
   }

   public ContractExpenseReimburseDtoParam() {
   }

   public ContractExpenseReimburseDtoParam(
      final Long id,
      final LocalDate reimburseDate,
      final Long reimburseUserId,
      final BigDecimal reimburseAmount,
      final Long expenseTypeId,
      final Long expenseSubjectId,
      final Long projectId,
      final String remark
   ) {
      this.id = id;
      this.reimburseDate = reimburseDate;
      this.reimburseUserId = reimburseUserId;
      this.reimburseAmount = reimburseAmount;
      this.expenseTypeId = expenseTypeId;
      this.expenseSubjectId = expenseSubjectId;
      this.projectId = projectId;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDate getReimburseDate() {
      return this.reimburseDate;
   }

   public Long getReimburseUserId() {
      return this.reimburseUserId;
   }

   public BigDecimal getReimburseAmount() {
      return this.reimburseAmount;
   }

   public Long getExpenseTypeId() {
      return this.expenseTypeId;
   }

   public Long getExpenseSubjectId() {
      return this.expenseSubjectId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setReimburseDate(final LocalDate reimburseDate) {
      this.reimburseDate = reimburseDate;
   }

   public void setReimburseUserId(final Long reimburseUserId) {
      this.reimburseUserId = reimburseUserId;
   }

   public void setReimburseAmount(final BigDecimal reimburseAmount) {
      this.reimburseAmount = reimburseAmount;
   }

   public void setExpenseTypeId(final Long expenseTypeId) {
      this.expenseTypeId = expenseTypeId;
   }

   public void setExpenseSubjectId(final Long expenseSubjectId) {
      this.expenseSubjectId = expenseSubjectId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractExpenseReimburseDtoParam)) {
         return false;
      }

      ContractExpenseReimburseDtoParam other = (ContractExpenseReimburseDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$reimburseUserId = this.getReimburseUserId();
         Object other$reimburseUserId = other.getReimburseUserId();
         if (this$reimburseUserId == null ? other$reimburseUserId == null : this$reimburseUserId.equals(other$reimburseUserId)) {
            Object this$expenseTypeId = this.getExpenseTypeId();
            Object other$expenseTypeId = other.getExpenseTypeId();
            if (this$expenseTypeId == null ? other$expenseTypeId == null : this$expenseTypeId.equals(other$expenseTypeId)) {
               Object this$expenseSubjectId = this.getExpenseSubjectId();
               Object other$expenseSubjectId = other.getExpenseSubjectId();
               if (this$expenseSubjectId == null ? other$expenseSubjectId == null : this$expenseSubjectId.equals(other$expenseSubjectId)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$reimburseDate = this.getReimburseDate();
                     Object other$reimburseDate = other.getReimburseDate();
                     if (this$reimburseDate == null ? other$reimburseDate == null : this$reimburseDate.equals(other$reimburseDate)) {
                        Object this$reimburseAmount = this.getReimburseAmount();
                        Object other$reimburseAmount = other.getReimburseAmount();
                        if (this$reimburseAmount == null ? other$reimburseAmount == null : this$reimburseAmount.equals(other$reimburseAmount)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof ContractExpenseReimburseDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $reimburseUserId = this.getReimburseUserId();
      result = result * 59 + ($reimburseUserId == null ? 43 : $reimburseUserId.hashCode());
      Object $expenseTypeId = this.getExpenseTypeId();
      result = result * 59 + ($expenseTypeId == null ? 43 : $expenseTypeId.hashCode());
      Object $expenseSubjectId = this.getExpenseSubjectId();
      result = result * 59 + ($expenseSubjectId == null ? 43 : $expenseSubjectId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $reimburseDate = this.getReimburseDate();
      result = result * 59 + ($reimburseDate == null ? 43 : $reimburseDate.hashCode());
      Object $reimburseAmount = this.getReimburseAmount();
      result = result * 59 + ($reimburseAmount == null ? 43 : $reimburseAmount.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractExpenseReimburseDtoParam(id="
         + this.getId()
         + ", reimburseDate="
         + this.getReimburseDate()
         + ", reimburseUserId="
         + this.getReimburseUserId()
         + ", reimburseAmount="
         + this.getReimburseAmount()
         + ", expenseTypeId="
         + this.getExpenseTypeId()
         + ", expenseSubjectId="
         + this.getExpenseSubjectId()
         + ", projectId="
         + this.getProjectId()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class ContractExpenseReimburseDtoParamBuilder {
      private Long id;
      private LocalDate reimburseDate;
      private Long reimburseUserId;
      private BigDecimal reimburseAmount;
      private Long expenseTypeId;
      private Long expenseSubjectId;
      private Long projectId;
      private String remark;

      ContractExpenseReimburseDtoParamBuilder() {
      }

      public ContractExpenseReimburseDtoParam.ContractExpenseReimburseDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractExpenseReimburseDtoParam.ContractExpenseReimburseDtoParamBuilder reimburseDate(final LocalDate reimburseDate) {
         this.reimburseDate = reimburseDate;
         return this;
      }

      public ContractExpenseReimburseDtoParam.ContractExpenseReimburseDtoParamBuilder reimburseUserId(final Long reimburseUserId) {
         this.reimburseUserId = reimburseUserId;
         return this;
      }

      public ContractExpenseReimburseDtoParam.ContractExpenseReimburseDtoParamBuilder reimburseAmount(final BigDecimal reimburseAmount) {
         this.reimburseAmount = reimburseAmount;
         return this;
      }

      public ContractExpenseReimburseDtoParam.ContractExpenseReimburseDtoParamBuilder expenseTypeId(final Long expenseTypeId) {
         this.expenseTypeId = expenseTypeId;
         return this;
      }

      public ContractExpenseReimburseDtoParam.ContractExpenseReimburseDtoParamBuilder expenseSubjectId(final Long expenseSubjectId) {
         this.expenseSubjectId = expenseSubjectId;
         return this;
      }

      public ContractExpenseReimburseDtoParam.ContractExpenseReimburseDtoParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractExpenseReimburseDtoParam.ContractExpenseReimburseDtoParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractExpenseReimburseDtoParam build() {
         return new ContractExpenseReimburseDtoParam(
            this.id, this.reimburseDate, this.reimburseUserId, this.reimburseAmount, this.expenseTypeId, this.expenseSubjectId, this.projectId, this.remark
         );
      }

      @Override
      public String toString() {
         return "ContractExpenseReimburseDtoParam.ContractExpenseReimburseDtoParamBuilder(id="
            + this.id
            + ", reimburseDate="
            + this.reimburseDate
            + ", reimburseUserId="
            + this.reimburseUserId
            + ", reimburseAmount="
            + this.reimburseAmount
            + ", expenseTypeId="
            + this.expenseTypeId
            + ", expenseSubjectId="
            + this.expenseSubjectId
            + ", projectId="
            + this.projectId
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
