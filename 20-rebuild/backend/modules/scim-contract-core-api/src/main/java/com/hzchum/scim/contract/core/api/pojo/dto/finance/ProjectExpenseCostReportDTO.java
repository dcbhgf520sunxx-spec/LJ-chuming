package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProjectExpenseCostReportDTO", description = "成本报表汇总返回表 ")
public class ProjectExpenseCostReportDTO {
   @ApiModelProperty("成本科目")
   private Integer costType;
   @ApiModelProperty("成本科目名称")
   private String costTypeName;
   @ApiModelProperty("金额")
   private BigDecimal amount;
   @ApiModelProperty("占比")
   private BigDecimal proportion;

   public static ProjectExpenseCostReportDTO.ProjectExpenseCostReportDTOBuilder builder() {
      return new ProjectExpenseCostReportDTO.ProjectExpenseCostReportDTOBuilder();
   }

   public Integer getCostType() {
      return this.costType;
   }

   public String getCostTypeName() {
      return this.costTypeName;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getProportion() {
      return this.proportion;
   }

   public ProjectExpenseCostReportDTO setCostType(final Integer costType) {
      this.costType = costType;
      return this;
   }

   public ProjectExpenseCostReportDTO setCostTypeName(final String costTypeName) {
      this.costTypeName = costTypeName;
      return this;
   }

   public ProjectExpenseCostReportDTO setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public ProjectExpenseCostReportDTO setProportion(final BigDecimal proportion) {
      this.proportion = proportion;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectExpenseCostReportDTO)) {
         return false;
      }

      ProjectExpenseCostReportDTO other = (ProjectExpenseCostReportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$costType = this.getCostType();
      Object other$costType = other.getCostType();
      if (this$costType == null ? other$costType == null : this$costType.equals(other$costType)) {
         Object this$costTypeName = this.getCostTypeName();
         Object other$costTypeName = other.getCostTypeName();
         if (this$costTypeName == null ? other$costTypeName == null : this$costTypeName.equals(other$costTypeName)) {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
               Object this$proportion = this.getProportion();
               Object other$proportion = other.getProportion();
               return this$proportion == null ? other$proportion == null : this$proportion.equals(other$proportion);
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
      return other instanceof ProjectExpenseCostReportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $costType = this.getCostType();
      result = result * 59 + ($costType == null ? 43 : $costType.hashCode());
      Object $costTypeName = this.getCostTypeName();
      result = result * 59 + ($costTypeName == null ? 43 : $costTypeName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $proportion = this.getProportion();
      return result * 59 + ($proportion == null ? 43 : $proportion.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectExpenseCostReportDTO(costType="
         + this.getCostType()
         + ", costTypeName="
         + this.getCostTypeName()
         + ", amount="
         + this.getAmount()
         + ", proportion="
         + this.getProportion()
         + ")";
   }

   public ProjectExpenseCostReportDTO(final Integer costType, final String costTypeName, final BigDecimal amount, final BigDecimal proportion) {
      this.costType = costType;
      this.costTypeName = costTypeName;
      this.amount = amount;
      this.proportion = proportion;
   }

   public ProjectExpenseCostReportDTO() {
   }

   public static class ProjectExpenseCostReportDTOBuilder {
      private Integer costType;
      private String costTypeName;
      private BigDecimal amount;
      private BigDecimal proportion;

      ProjectExpenseCostReportDTOBuilder() {
      }

      public ProjectExpenseCostReportDTO.ProjectExpenseCostReportDTOBuilder costType(final Integer costType) {
         this.costType = costType;
         return this;
      }

      public ProjectExpenseCostReportDTO.ProjectExpenseCostReportDTOBuilder costTypeName(final String costTypeName) {
         this.costTypeName = costTypeName;
         return this;
      }

      public ProjectExpenseCostReportDTO.ProjectExpenseCostReportDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public ProjectExpenseCostReportDTO.ProjectExpenseCostReportDTOBuilder proportion(final BigDecimal proportion) {
         this.proportion = proportion;
         return this;
      }

      public ProjectExpenseCostReportDTO build() {
         return new ProjectExpenseCostReportDTO(this.costType, this.costTypeName, this.amount, this.proportion);
      }

      @Override
      public String toString() {
         return "ProjectExpenseCostReportDTO.ProjectExpenseCostReportDTOBuilder(costType="
            + this.costType
            + ", costTypeName="
            + this.costTypeName
            + ", amount="
            + this.amount
            + ", proportion="
            + this.proportion
            + ")";
      }
   }
}
