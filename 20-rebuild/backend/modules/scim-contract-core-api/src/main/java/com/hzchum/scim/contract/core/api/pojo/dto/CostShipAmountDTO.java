package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("成本发运量")
public class CostShipAmountDTO {
   @ApiModelProperty("结构发运量")
   private BigDecimal totalOutputArtifact;
   @ApiModelProperty("围护发运量")
   private BigDecimal totalOutputEnclosure;
   @ApiModelProperty("配套制品发运量")
   private BigDecimal totalOutputStandard;

   public BigDecimal getTotalOutputArtifact() {
      return this.totalOutputArtifact;
   }

   public BigDecimal getTotalOutputEnclosure() {
      return this.totalOutputEnclosure;
   }

   public BigDecimal getTotalOutputStandard() {
      return this.totalOutputStandard;
   }

   public void setTotalOutputArtifact(final BigDecimal totalOutputArtifact) {
      this.totalOutputArtifact = totalOutputArtifact;
   }

   public void setTotalOutputEnclosure(final BigDecimal totalOutputEnclosure) {
      this.totalOutputEnclosure = totalOutputEnclosure;
   }

   public void setTotalOutputStandard(final BigDecimal totalOutputStandard) {
      this.totalOutputStandard = totalOutputStandard;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CostShipAmountDTO)) {
         return false;
      }

      CostShipAmountDTO other = (CostShipAmountDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalOutputArtifact = this.getTotalOutputArtifact();
      Object other$totalOutputArtifact = other.getTotalOutputArtifact();
      if (this$totalOutputArtifact == null ? other$totalOutputArtifact == null : this$totalOutputArtifact.equals(other$totalOutputArtifact)) {
         Object this$totalOutputEnclosure = this.getTotalOutputEnclosure();
         Object other$totalOutputEnclosure = other.getTotalOutputEnclosure();
         if (this$totalOutputEnclosure == null ? other$totalOutputEnclosure == null : this$totalOutputEnclosure.equals(other$totalOutputEnclosure)) {
            Object this$totalOutputStandard = this.getTotalOutputStandard();
            Object other$totalOutputStandard = other.getTotalOutputStandard();
            return this$totalOutputStandard == null ? other$totalOutputStandard == null : this$totalOutputStandard.equals(other$totalOutputStandard);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CostShipAmountDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalOutputArtifact = this.getTotalOutputArtifact();
      result = result * 59 + ($totalOutputArtifact == null ? 43 : $totalOutputArtifact.hashCode());
      Object $totalOutputEnclosure = this.getTotalOutputEnclosure();
      result = result * 59 + ($totalOutputEnclosure == null ? 43 : $totalOutputEnclosure.hashCode());
      Object $totalOutputStandard = this.getTotalOutputStandard();
      return result * 59 + ($totalOutputStandard == null ? 43 : $totalOutputStandard.hashCode());
   }

   @Override
   public String toString() {
      return "CostShipAmountDTO(totalOutputArtifact="
         + this.getTotalOutputArtifact()
         + ", totalOutputEnclosure="
         + this.getTotalOutputEnclosure()
         + ", totalOutputStandard="
         + this.getTotalOutputStandard()
         + ")";
   }

   public CostShipAmountDTO() {
   }

   public CostShipAmountDTO(final BigDecimal totalOutputArtifact, final BigDecimal totalOutputEnclosure, final BigDecimal totalOutputStandard) {
      this.totalOutputArtifact = totalOutputArtifact;
      this.totalOutputEnclosure = totalOutputEnclosure;
      this.totalOutputStandard = totalOutputStandard;
   }
}
