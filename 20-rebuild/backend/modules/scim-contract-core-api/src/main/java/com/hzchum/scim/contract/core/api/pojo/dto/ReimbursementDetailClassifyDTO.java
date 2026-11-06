package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("报销费用-大类")
public class ReimbursementDetailClassifyDTO {
   @ApiModelProperty("费用类别id")
   private Long expenseTypeId;
   @ApiModelProperty("费用类别名称")
   private String expenseTypeName;
   @ApiModelProperty("报销明细列表")
   private List<ReimbursementDetailDTO> reimbursementDetailList;

   public Long getExpenseTypeId() {
      return this.expenseTypeId;
   }

   public String getExpenseTypeName() {
      return this.expenseTypeName;
   }

   public List<ReimbursementDetailDTO> getReimbursementDetailList() {
      return this.reimbursementDetailList;
   }

   public void setExpenseTypeId(final Long expenseTypeId) {
      this.expenseTypeId = expenseTypeId;
   }

   public void setExpenseTypeName(final String expenseTypeName) {
      this.expenseTypeName = expenseTypeName;
   }

   public void setReimbursementDetailList(final List<ReimbursementDetailDTO> reimbursementDetailList) {
      this.reimbursementDetailList = reimbursementDetailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReimbursementDetailClassifyDTO)) {
         return false;
      }

      ReimbursementDetailClassifyDTO other = (ReimbursementDetailClassifyDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$expenseTypeId = this.getExpenseTypeId();
      Object other$expenseTypeId = other.getExpenseTypeId();
      if (this$expenseTypeId == null ? other$expenseTypeId == null : this$expenseTypeId.equals(other$expenseTypeId)) {
         Object this$expenseTypeName = this.getExpenseTypeName();
         Object other$expenseTypeName = other.getExpenseTypeName();
         if (this$expenseTypeName == null ? other$expenseTypeName == null : this$expenseTypeName.equals(other$expenseTypeName)) {
            Object this$reimbursementDetailList = this.getReimbursementDetailList();
            Object other$reimbursementDetailList = other.getReimbursementDetailList();
            return this$reimbursementDetailList == null
               ? other$reimbursementDetailList == null
               : this$reimbursementDetailList.equals(other$reimbursementDetailList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ReimbursementDetailClassifyDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $expenseTypeId = this.getExpenseTypeId();
      result = result * 59 + ($expenseTypeId == null ? 43 : $expenseTypeId.hashCode());
      Object $expenseTypeName = this.getExpenseTypeName();
      result = result * 59 + ($expenseTypeName == null ? 43 : $expenseTypeName.hashCode());
      Object $reimbursementDetailList = this.getReimbursementDetailList();
      return result * 59 + ($reimbursementDetailList == null ? 43 : $reimbursementDetailList.hashCode());
   }

   @Override
   public String toString() {
      return "ReimbursementDetailClassifyDTO(expenseTypeId="
         + this.getExpenseTypeId()
         + ", expenseTypeName="
         + this.getExpenseTypeName()
         + ", reimbursementDetailList="
         + this.getReimbursementDetailList()
         + ")";
   }
}
