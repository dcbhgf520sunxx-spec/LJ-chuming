package com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config;

import com.hzchum.scim.common.core.api.pojo.common.ProductInfo;
import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesProductionReportingApprovalPassed;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("报工审核通过DTO")
public class MesProductionReportingApprovalPassedDTO extends MesProductionReportingApprovalPassed {
   @ApiModelProperty("产品")
   private ProductInfo product;
   @ApiModelProperty("班组")
   private ShowInfo team;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesProductionReportingApprovalPassedDTO)) {
         return false;
      } else {
         MesProductionReportingApprovalPassedDTO other = (MesProductionReportingApprovalPassedDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (!super.equals(o)) {
            return false;
         } else {
            Object this$product = this.getProduct();
            Object other$product = other.getProduct();
            if (this$product == null ? other$product == null : this$product.equals(other$product)) {
               Object this$team = this.getTeam();
               Object other$team = other.getTeam();
               return this$team == null ? other$team == null : this$team.equals(other$team);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesProductionReportingApprovalPassedDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $product = this.getProduct();
      result = result * 59 + ($product == null ? 43 : $product.hashCode());
      Object $team = this.getTeam();
      return result * 59 + ($team == null ? 43 : $team.hashCode());
   }

   public ProductInfo getProduct() {
      return this.product;
   }

   public ShowInfo getTeam() {
      return this.team;
   }

   public void setProduct(final ProductInfo product) {
      this.product = product;
   }

   public void setTeam(final ShowInfo team) {
      this.team = team;
   }

   @Override
   public String toString() {
      return "MesProductionReportingApprovalPassedDTO(product=" + this.getProduct() + ", team=" + this.getTeam() + ")";
   }
}
