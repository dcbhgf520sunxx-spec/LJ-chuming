package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWageFee;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "工资费用DTO类")
public class ContractWageFeeDTO extends ContractWageFee {
   @ApiModelProperty("费用归属名称")
   private String branchCompanyName;
   @ApiModelProperty("费用类型名称")
   private String expenseTypeName;
   @ApiModelProperty("创建人名称")
   private String founderName;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWageFeeDTO)) {
         return false;
      }

      ContractWageFeeDTO other = (ContractWageFeeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$branchCompanyName = this.getBranchCompanyName();
      Object other$branchCompanyName = other.getBranchCompanyName();
      if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
         Object this$expenseTypeName = this.getExpenseTypeName();
         Object other$expenseTypeName = other.getExpenseTypeName();
         if (this$expenseTypeName == null ? other$expenseTypeName == null : this$expenseTypeName.equals(other$expenseTypeName)) {
            Object this$founderName = this.getFounderName();
            Object other$founderName = other.getFounderName();
            return this$founderName == null ? other$founderName == null : this$founderName.equals(other$founderName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractWageFeeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $expenseTypeName = this.getExpenseTypeName();
      result = result * 59 + ($expenseTypeName == null ? 43 : $expenseTypeName.hashCode());
      Object $founderName = this.getFounderName();
      return result * 59 + ($founderName == null ? 43 : $founderName.hashCode());
   }

   @Override
   public String toString() {
      return "ContractWageFeeDTO(super="
         + super.toString()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", expenseTypeName="
         + this.getExpenseTypeName()
         + ", founderName="
         + this.getFounderName()
         + ")";
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public String getExpenseTypeName() {
      return this.expenseTypeName;
   }

   public String getFounderName() {
      return this.founderName;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setExpenseTypeName(final String expenseTypeName) {
      this.expenseTypeName = expenseTypeName;
   }

   public void setFounderName(final String founderName) {
      this.founderName = founderName;
   }
}
