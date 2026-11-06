package com.hzchum.scim.mes.building.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "QuantityAndWeightDetailDO", description = "数量和重量DO")
public class QuantityAndWeightDetailDO {
   @ApiModelProperty(name = "projectId", notes = "项目Id", value = "项目Id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "quantity", notes = "数量", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", notes = "净重", value = "净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", notes = "毛重", value = "毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;

   public static QuantityAndWeightDetailDO.QuantityAndWeightDetailDOBuilder builder() {
      return new QuantityAndWeightDetailDO.QuantityAndWeightDetailDOBuilder();
   }

   public QuantityAndWeightDetailDO() {
   }

   public QuantityAndWeightDetailDO(final Long projectId, final Integer quantity, final BigDecimal netWeight, final BigDecimal grossWeight) {
      this.projectId = projectId;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   @JsonProperty("projectId")
   public QuantityAndWeightDetailDO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("quantity")
   public QuantityAndWeightDetailDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public QuantityAndWeightDetailDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public QuantityAndWeightDetailDO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @Override
   public String toString() {
      return "QuantityAndWeightDetailDO(projectId="
         + this.getProjectId()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QuantityAndWeightDetailDO)) {
         return false;
      }

      QuantityAndWeightDetailDO other = (QuantityAndWeightDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$netWeight = this.getNetWeight();
            Object other$netWeight = other.getNetWeight();
            if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
               Object this$grossWeight = this.getGrossWeight();
               Object other$grossWeight = other.getGrossWeight();
               return this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight);
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
      return other instanceof QuantityAndWeightDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      return result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
   }

   public static class QuantityAndWeightDetailDOBuilder {
      private Long projectId;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;

      QuantityAndWeightDetailDOBuilder() {
      }

      @JsonProperty("projectId")
      public QuantityAndWeightDetailDO.QuantityAndWeightDetailDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("quantity")
      public QuantityAndWeightDetailDO.QuantityAndWeightDetailDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public QuantityAndWeightDetailDO.QuantityAndWeightDetailDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public QuantityAndWeightDetailDO.QuantityAndWeightDetailDOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public QuantityAndWeightDetailDO build() {
         return new QuantityAndWeightDetailDO(this.projectId, this.quantity, this.netWeight, this.grossWeight);
      }

      @Override
      public String toString() {
         return "QuantityAndWeightDetailDO.QuantityAndWeightDetailDOBuilder(projectId="
            + this.projectId
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ")";
      }
   }
}
