package com.hzchum.scim.contract.core.api.pojo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("项目统计类")
public class ProjectAnalysisSummaryDTO {
   @ApiModelProperty("项目类型")
   @JsonInclude(Include.NON_NULL)
   private Integer businessType;
   @ApiModelProperty("时间")
   @JsonInclude(Include.NON_NULL)
   private String dateTime;
   @ApiModelProperty("合同数量")
   private Integer contractQuantity;
   @ApiModelProperty("合同总金额")
   private BigDecimal contractAmount;
   @ApiModelProperty("清单量")
   private BigDecimal deepMete;

   public static ProjectAnalysisSummaryDTO.ProjectAnalysisSummaryDTOBuilder builder() {
      return new ProjectAnalysisSummaryDTO.ProjectAnalysisSummaryDTOBuilder();
   }

   public ProjectAnalysisSummaryDTO() {
   }

   public ProjectAnalysisSummaryDTO(
      final Integer businessType, final String dateTime, final Integer contractQuantity, final BigDecimal contractAmount, final BigDecimal deepMete
   ) {
      this.businessType = businessType;
      this.dateTime = dateTime;
      this.contractQuantity = contractQuantity;
      this.contractAmount = contractAmount;
      this.deepMete = deepMete;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public String getDateTime() {
      return this.dateTime;
   }

   public Integer getContractQuantity() {
      return this.contractQuantity;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getDeepMete() {
      return this.deepMete;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setDateTime(final String dateTime) {
      this.dateTime = dateTime;
   }

   public void setContractQuantity(final Integer contractQuantity) {
      this.contractQuantity = contractQuantity;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setDeepMete(final BigDecimal deepMete) {
      this.deepMete = deepMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectAnalysisSummaryDTO)) {
         return false;
      }

      ProjectAnalysisSummaryDTO other = (ProjectAnalysisSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$businessType = this.getBusinessType();
      Object other$businessType = other.getBusinessType();
      if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
         Object this$contractQuantity = this.getContractQuantity();
         Object other$contractQuantity = other.getContractQuantity();
         if (this$contractQuantity == null ? other$contractQuantity == null : this$contractQuantity.equals(other$contractQuantity)) {
            Object this$dateTime = this.getDateTime();
            Object other$dateTime = other.getDateTime();
            if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
               Object this$contractAmount = this.getContractAmount();
               Object other$contractAmount = other.getContractAmount();
               if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                  Object this$deepMete = this.getDeepMete();
                  Object other$deepMete = other.getDeepMete();
                  return this$deepMete == null ? other$deepMete == null : this$deepMete.equals(other$deepMete);
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
      return other instanceof ProjectAnalysisSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $contractQuantity = this.getContractQuantity();
      result = result * 59 + ($contractQuantity == null ? 43 : $contractQuantity.hashCode());
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $deepMete = this.getDeepMete();
      return result * 59 + ($deepMete == null ? 43 : $deepMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectAnalysisSummaryDTO(businessType="
         + this.getBusinessType()
         + ", dateTime="
         + this.getDateTime()
         + ", contractQuantity="
         + this.getContractQuantity()
         + ", contractAmount="
         + this.getContractAmount()
         + ", deepMete="
         + this.getDeepMete()
         + ")";
   }

   public static class ProjectAnalysisSummaryDTOBuilder {
      private Integer businessType;
      private String dateTime;
      private Integer contractQuantity;
      private BigDecimal contractAmount;
      private BigDecimal deepMete;

      ProjectAnalysisSummaryDTOBuilder() {
      }

      public ProjectAnalysisSummaryDTO.ProjectAnalysisSummaryDTOBuilder businessType(final Integer businessType) {
         this.businessType = businessType;
         return this;
      }

      public ProjectAnalysisSummaryDTO.ProjectAnalysisSummaryDTOBuilder dateTime(final String dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      public ProjectAnalysisSummaryDTO.ProjectAnalysisSummaryDTOBuilder contractQuantity(final Integer contractQuantity) {
         this.contractQuantity = contractQuantity;
         return this;
      }

      public ProjectAnalysisSummaryDTO.ProjectAnalysisSummaryDTOBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ProjectAnalysisSummaryDTO.ProjectAnalysisSummaryDTOBuilder deepMete(final BigDecimal deepMete) {
         this.deepMete = deepMete;
         return this;
      }

      public ProjectAnalysisSummaryDTO build() {
         return new ProjectAnalysisSummaryDTO(this.businessType, this.dateTime, this.contractQuantity, this.contractAmount, this.deepMete);
      }

      @Override
      public String toString() {
         return "ProjectAnalysisSummaryDTO.ProjectAnalysisSummaryDTOBuilder(businessType="
            + this.businessType
            + ", dateTime="
            + this.dateTime
            + ", contractQuantity="
            + this.contractQuantity
            + ", contractAmount="
            + this.contractAmount
            + ", deepMete="
            + this.deepMete
            + ")";
      }
   }
}
