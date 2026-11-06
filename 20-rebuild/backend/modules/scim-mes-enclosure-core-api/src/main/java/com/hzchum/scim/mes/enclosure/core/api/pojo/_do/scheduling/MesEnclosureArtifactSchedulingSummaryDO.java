package com.hzchum.scim.mes.enclosure.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesEnclosureArtifactSchedulingSummaryDO", description = "构件汇总信息")
public class MesEnclosureArtifactSchedulingSummaryDO {
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;

   public static MesEnclosureArtifactSchedulingSummaryDO.MesEnclosureArtifactSchedulingSummaryDOBuilder builder() {
      return new MesEnclosureArtifactSchedulingSummaryDO.MesEnclosureArtifactSchedulingSummaryDOBuilder();
   }

   public MesEnclosureArtifactSchedulingSummaryDO(final Integer quantity, final BigDecimal totalNetWeight) {
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
   }

   public MesEnclosureArtifactSchedulingSummaryDO() {
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   @JsonProperty("quantity")
   public MesEnclosureArtifactSchedulingSummaryDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesEnclosureArtifactSchedulingSummaryDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureArtifactSchedulingSummaryDO(quantity=" + this.getQuantity() + ", totalNetWeight=" + this.getTotalNetWeight() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesEnclosureArtifactSchedulingSummaryDO)) {
         return false;
      } else {
         MesEnclosureArtifactSchedulingSummaryDO other = (MesEnclosureArtifactSchedulingSummaryDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$totalNetWeight = this.getTotalNetWeight();
               Object other$totalNetWeight = other.getTotalNetWeight();
               return this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureArtifactSchedulingSummaryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      return result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
   }

   public static class MesEnclosureArtifactSchedulingSummaryDOBuilder {
      private Integer quantity;
      private BigDecimal totalNetWeight;

      MesEnclosureArtifactSchedulingSummaryDOBuilder() {
      }

      @JsonProperty("quantity")
      public MesEnclosureArtifactSchedulingSummaryDO.MesEnclosureArtifactSchedulingSummaryDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesEnclosureArtifactSchedulingSummaryDO.MesEnclosureArtifactSchedulingSummaryDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public MesEnclosureArtifactSchedulingSummaryDO build() {
         return new MesEnclosureArtifactSchedulingSummaryDO(this.quantity, this.totalNetWeight);
      }

      @Override
      public String toString() {
         return "MesEnclosureArtifactSchedulingSummaryDO.MesEnclosureArtifactSchedulingSummaryDOBuilder(quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ")";
      }
   }
}
