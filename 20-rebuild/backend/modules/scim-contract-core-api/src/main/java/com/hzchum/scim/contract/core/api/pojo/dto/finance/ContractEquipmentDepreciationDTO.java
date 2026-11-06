package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractEquipmentDepreciation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "设备折旧DTO类")
public class ContractEquipmentDepreciationDTO extends ContractEquipmentDepreciation {
   @ApiModelProperty("费用归属名称")
   private String branchCompanyName;
   @ApiModelProperty("录用用户名称")
   private String userName;
   @ApiModelProperty("剩余年限")
   private String remainingYears;

   @Override
   public String toString() {
      return "ContractEquipmentDepreciationDTO(super="
         + super.toString()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", userName="
         + this.getUserName()
         + ", remainingYears="
         + this.getRemainingYears()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractEquipmentDepreciationDTO)) {
         return false;
      }

      ContractEquipmentDepreciationDTO other = (ContractEquipmentDepreciationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$branchCompanyName = this.getBranchCompanyName();
      Object other$branchCompanyName = other.getBranchCompanyName();
      if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
         Object this$userName = this.getUserName();
         Object other$userName = other.getUserName();
         if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
            Object this$remainingYears = this.getRemainingYears();
            Object other$remainingYears = other.getRemainingYears();
            return this$remainingYears == null ? other$remainingYears == null : this$remainingYears.equals(other$remainingYears);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractEquipmentDepreciationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $remainingYears = this.getRemainingYears();
      return result * 59 + ($remainingYears == null ? 43 : $remainingYears.hashCode());
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getRemainingYears() {
      return this.remainingYears;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setRemainingYears(final String remainingYears) {
      this.remainingYears = remainingYears;
   }
}
