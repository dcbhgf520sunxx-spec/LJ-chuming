package com.hzchum.scim.contract.core.api.pojo.dto.business;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel(description = "客户交易汇总")
public class ContractBusinessDetailDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("合同额")
   private BigDecimal contractAmount;
   @ApiModelProperty("结算额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("签订日期")
   private LocalDate signingDate;
   @ApiModelProperty("签约人姓名")
   private String signerName;

   public ProjectInfo getProject() {
      return this.project;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public LocalDate getSigningDate() {
      return this.signingDate;
   }

   public String getSignerName() {
      return this.signerName;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setSigningDate(final LocalDate signingDate) {
      this.signingDate = signingDate;
   }

   public void setSignerName(final String signerName) {
      this.signerName = signerName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractBusinessDetailDTO)) {
         return false;
      }

      ContractBusinessDetailDTO other = (ContractBusinessDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$project = this.getProject();
      Object other$project = other.getProject();
      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
         Object this$contractAmount = this.getContractAmount();
         Object other$contractAmount = other.getContractAmount();
         if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
            Object this$settlementAmount = this.getSettlementAmount();
            Object other$settlementAmount = other.getSettlementAmount();
            if (this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount)) {
               Object this$signingDate = this.getSigningDate();
               Object other$signingDate = other.getSigningDate();
               if (this$signingDate == null ? other$signingDate == null : this$signingDate.equals(other$signingDate)) {
                  Object this$signerName = this.getSignerName();
                  Object other$signerName = other.getSignerName();
                  return this$signerName == null ? other$signerName == null : this$signerName.equals(other$signerName);
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
      return other instanceof ContractBusinessDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $signingDate = this.getSigningDate();
      result = result * 59 + ($signingDate == null ? 43 : $signingDate.hashCode());
      Object $signerName = this.getSignerName();
      return result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
   }

   @Override
   public String toString() {
      return "ContractBusinessDetailDTO(project="
         + this.getProject()
         + ", contractAmount="
         + this.getContractAmount()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", signingDate="
         + this.getSigningDate()
         + ", signerName="
         + this.getSignerName()
         + ")";
   }
}
