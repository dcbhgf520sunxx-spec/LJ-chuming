package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWaterElectricityPropertyFee;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "水、电、物业费DTO类")
public class ContractWaterElectricityPropertyFeeDTO extends ContractWaterElectricityPropertyFee {
   @ApiModelProperty("费用归属")
   private String branchCompanyName;
   @ApiModelProperty("录入人名称")
   private String userName;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ContractWaterElectricityPropertyFeeDTO)) {
         return false;
      } else {
         ContractWaterElectricityPropertyFeeDTO other = (ContractWaterElectricityPropertyFeeDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (!super.equals(o)) {
            return false;
         } else {
            Object this$branchCompanyName = this.getBranchCompanyName();
            Object other$branchCompanyName = other.getBranchCompanyName();
            if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
               Object this$userName = this.getUserName();
               Object other$userName = other.getUserName();
               return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractWaterElectricityPropertyFeeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "ContractWaterElectricityPropertyFeeDTO(super="
         + super.toString()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", userName="
         + this.getUserName()
         + ")";
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }
}
