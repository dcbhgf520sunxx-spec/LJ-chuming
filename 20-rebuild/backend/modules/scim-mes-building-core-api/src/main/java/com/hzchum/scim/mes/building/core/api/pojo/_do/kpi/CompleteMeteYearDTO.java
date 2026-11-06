package com.hzchum.scim.mes.building.core.api.pojo._do.kpi;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "CompleteMeteYearDTO", description = "每月产量kpi")
public class CompleteMeteYearDTO {
   @ApiModelProperty(name = "completeMete", value = "产量", notes = "产量")
   @JsonProperty("completeMete")
   @JSONField(name = "completeMete")
   private BigDecimal completeMete;
   @ApiModelProperty(name = "target", value = "目标产量", notes = "目标产量")
   @JsonProperty("target")
   @JSONField(name = "target")
   private BigDecimal target;

   public static CompleteMeteYearDTO.CompleteMeteYearDTOBuilder builder() {
      return new CompleteMeteYearDTO.CompleteMeteYearDTOBuilder();
   }

   public CompleteMeteYearDTO(final BigDecimal completeMete, final BigDecimal target) {
      this.completeMete = completeMete;
      this.target = target;
   }

   public CompleteMeteYearDTO() {
   }

   public BigDecimal getCompleteMete() {
      return this.completeMete;
   }

   public BigDecimal getTarget() {
      return this.target;
   }

   @JsonProperty("completeMete")
   public CompleteMeteYearDTO setCompleteMete(final BigDecimal completeMete) {
      this.completeMete = completeMete;
      return this;
   }

   @JsonProperty("target")
   public CompleteMeteYearDTO setTarget(final BigDecimal target) {
      this.target = target;
      return this;
   }

   @Override
   public String toString() {
      return "CompleteMeteYearDTO(completeMete=" + this.getCompleteMete() + ", target=" + this.getTarget() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CompleteMeteYearDTO)) {
         return false;
      } else {
         CompleteMeteYearDTO other = (CompleteMeteYearDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$completeMete = this.getCompleteMete();
            Object other$completeMete = other.getCompleteMete();
            if (this$completeMete == null ? other$completeMete == null : this$completeMete.equals(other$completeMete)) {
               Object this$target = this.getTarget();
               Object other$target = other.getTarget();
               return this$target == null ? other$target == null : this$target.equals(other$target);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CompleteMeteYearDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $completeMete = this.getCompleteMete();
      result = result * 59 + ($completeMete == null ? 43 : $completeMete.hashCode());
      Object $target = this.getTarget();
      return result * 59 + ($target == null ? 43 : $target.hashCode());
   }

   public static class CompleteMeteYearDTOBuilder {
      private BigDecimal completeMete;
      private BigDecimal target;

      CompleteMeteYearDTOBuilder() {
      }

      @JsonProperty("completeMete")
      public CompleteMeteYearDTO.CompleteMeteYearDTOBuilder completeMete(final BigDecimal completeMete) {
         this.completeMete = completeMete;
         return this;
      }

      @JsonProperty("target")
      public CompleteMeteYearDTO.CompleteMeteYearDTOBuilder target(final BigDecimal target) {
         this.target = target;
         return this;
      }

      public CompleteMeteYearDTO build() {
         return new CompleteMeteYearDTO(this.completeMete, this.target);
      }

      @Override
      public String toString() {
         return "CompleteMeteYearDTO.CompleteMeteYearDTOBuilder(completeMete=" + this.completeMete + ", target=" + this.target + ")";
      }
   }
}
