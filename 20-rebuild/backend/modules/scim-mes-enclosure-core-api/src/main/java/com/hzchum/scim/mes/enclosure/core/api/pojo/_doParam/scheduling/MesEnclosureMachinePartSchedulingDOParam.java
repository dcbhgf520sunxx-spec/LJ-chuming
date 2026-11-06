package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureMachinePartSchedulingDOParam", description = "零件排产信息")
public class MesEnclosureMachinePartSchedulingDOParam {
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @NotNull(message = "产品id不能为空")
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "排产数量", notes = "排产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @NotNull(message = "排产数量不能为空")
   @Min(value = 1L, message = "排产数量不能小于1")
   private Integer quantity;
   @ApiModelProperty(name = "layWayConfigId", value = "下料配置id", notes = "下料配置id")
   @JsonProperty("layWayConfigId")
   @JSONField(name = "layWayConfigId")
   private Long layWayConfigId;

   public static MesEnclosureMachinePartSchedulingDOParam.MesEnclosureMachinePartSchedulingDOParamBuilder builder() {
      return new MesEnclosureMachinePartSchedulingDOParam.MesEnclosureMachinePartSchedulingDOParamBuilder();
   }

   public MesEnclosureMachinePartSchedulingDOParam(final Long productId, final Integer quantity, final Long layWayConfigId) {
      this.productId = productId;
      this.quantity = quantity;
      this.layWayConfigId = layWayConfigId;
   }

   public MesEnclosureMachinePartSchedulingDOParam() {
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getLayWayConfigId() {
      return this.layWayConfigId;
   }

   @JsonProperty("productId")
   public MesEnclosureMachinePartSchedulingDOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureMachinePartSchedulingDOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("layWayConfigId")
   public MesEnclosureMachinePartSchedulingDOParam setLayWayConfigId(final Long layWayConfigId) {
      this.layWayConfigId = layWayConfigId;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureMachinePartSchedulingDOParam(productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", layWayConfigId="
         + this.getLayWayConfigId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureMachinePartSchedulingDOParam)) {
         return false;
      }

      MesEnclosureMachinePartSchedulingDOParam other = (MesEnclosureMachinePartSchedulingDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$layWayConfigId = this.getLayWayConfigId();
            Object other$layWayConfigId = other.getLayWayConfigId();
            return this$layWayConfigId == null ? other$layWayConfigId == null : this$layWayConfigId.equals(other$layWayConfigId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureMachinePartSchedulingDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $layWayConfigId = this.getLayWayConfigId();
      return result * 59 + ($layWayConfigId == null ? 43 : $layWayConfigId.hashCode());
   }

   public static class MesEnclosureMachinePartSchedulingDOParamBuilder {
      private Long productId;
      private Integer quantity;
      private Long layWayConfigId;

      MesEnclosureMachinePartSchedulingDOParamBuilder() {
      }

      @JsonProperty("productId")
      public MesEnclosureMachinePartSchedulingDOParam.MesEnclosureMachinePartSchedulingDOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureMachinePartSchedulingDOParam.MesEnclosureMachinePartSchedulingDOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("layWayConfigId")
      public MesEnclosureMachinePartSchedulingDOParam.MesEnclosureMachinePartSchedulingDOParamBuilder layWayConfigId(final Long layWayConfigId) {
         this.layWayConfigId = layWayConfigId;
         return this;
      }

      public MesEnclosureMachinePartSchedulingDOParam build() {
         return new MesEnclosureMachinePartSchedulingDOParam(this.productId, this.quantity, this.layWayConfigId);
      }

      @Override
      public String toString() {
         return "MesEnclosureMachinePartSchedulingDOParam.MesEnclosureMachinePartSchedulingDOParamBuilder(productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", layWayConfigId="
            + this.layWayConfigId
            + ")";
      }
   }
}
