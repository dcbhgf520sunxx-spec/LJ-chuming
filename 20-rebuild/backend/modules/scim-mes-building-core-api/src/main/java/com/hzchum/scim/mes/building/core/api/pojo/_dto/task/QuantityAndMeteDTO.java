package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProgressProcessDTO", description = "工序进度列表")
public class QuantityAndMeteDTO {
   @ApiModelProperty(name = "cutId", notes = "切割指令id")
   @JsonProperty("cutId")
   @JSONField(name = "cutId")
   private Long cutId;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "mete", notes = "任务量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;

   public static QuantityAndMeteDTO.QuantityAndMeteDTOBuilder builder() {
      return new QuantityAndMeteDTO.QuantityAndMeteDTOBuilder();
   }

   public QuantityAndMeteDTO() {
   }

   public QuantityAndMeteDTO(final Long cutId, final Integer quantity, final BigDecimal mete) {
      this.cutId = cutId;
      this.quantity = quantity;
      this.mete = mete;
   }

   public Long getCutId() {
      return this.cutId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   @JsonProperty("cutId")
   public QuantityAndMeteDTO setCutId(final Long cutId) {
      this.cutId = cutId;
      return this;
   }

   @JsonProperty("quantity")
   public QuantityAndMeteDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("mete")
   public QuantityAndMeteDTO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @Override
   public String toString() {
      return "QuantityAndMeteDTO(cutId=" + this.getCutId() + ", quantity=" + this.getQuantity() + ", mete=" + this.getMete() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QuantityAndMeteDTO)) {
         return false;
      }

      QuantityAndMeteDTO other = (QuantityAndMeteDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$cutId = this.getCutId();
      Object other$cutId = other.getCutId();
      if (this$cutId == null ? other$cutId == null : this$cutId.equals(other$cutId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$mete = this.getMete();
            Object other$mete = other.getMete();
            return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QuantityAndMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $cutId = this.getCutId();
      result = result * 59 + ($cutId == null ? 43 : $cutId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   public static class QuantityAndMeteDTOBuilder {
      private Long cutId;
      private Integer quantity;
      private BigDecimal mete;

      QuantityAndMeteDTOBuilder() {
      }

      @JsonProperty("cutId")
      public QuantityAndMeteDTO.QuantityAndMeteDTOBuilder cutId(final Long cutId) {
         this.cutId = cutId;
         return this;
      }

      @JsonProperty("quantity")
      public QuantityAndMeteDTO.QuantityAndMeteDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public QuantityAndMeteDTO.QuantityAndMeteDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public QuantityAndMeteDTO build() {
         return new QuantityAndMeteDTO(this.cutId, this.quantity, this.mete);
      }

      @Override
      public String toString() {
         return "QuantityAndMeteDTO.QuantityAndMeteDTOBuilder(cutId=" + this.cutId + ", quantity=" + this.quantity + ", mete=" + this.mete + ")";
      }
   }
}
