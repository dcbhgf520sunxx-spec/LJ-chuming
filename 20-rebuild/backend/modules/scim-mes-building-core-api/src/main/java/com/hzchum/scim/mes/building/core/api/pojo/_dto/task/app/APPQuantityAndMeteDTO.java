package com.hzchum.scim.mes.building.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "APPQuantityAndMeteDTO", description = "")
public class APPQuantityAndMeteDTO {
   @ApiModelProperty(name = "quantity", notes = "任务数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "mete", notes = "任务量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "completeMete", notes = "完成量")
   @JsonProperty("completeMete")
   @JSONField(name = "completeMete")
   private BigDecimal completeMete;

   public static APPQuantityAndMeteDTO.APPQuantityAndMeteDTOBuilder builder() {
      return new APPQuantityAndMeteDTO.APPQuantityAndMeteDTOBuilder();
   }

   public APPQuantityAndMeteDTO() {
   }

   public APPQuantityAndMeteDTO(final Integer quantity, final Integer completeQuantity, final BigDecimal mete, final BigDecimal completeMete) {
      this.quantity = quantity;
      this.completeQuantity = completeQuantity;
      this.mete = mete;
      this.completeMete = completeMete;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getCompleteMete() {
      return this.completeMete;
   }

   @JsonProperty("quantity")
   public APPQuantityAndMeteDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public APPQuantityAndMeteDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("mete")
   public APPQuantityAndMeteDTO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("completeMete")
   public APPQuantityAndMeteDTO setCompleteMete(final BigDecimal completeMete) {
      this.completeMete = completeMete;
      return this;
   }

   @Override
   public String toString() {
      return "APPQuantityAndMeteDTO(quantity="
         + this.getQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", mete="
         + this.getMete()
         + ", completeMete="
         + this.getCompleteMete()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof APPQuantityAndMeteDTO)) {
         return false;
      }

      APPQuantityAndMeteDTO other = (APPQuantityAndMeteDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$completeQuantity = this.getCompleteQuantity();
         Object other$completeQuantity = other.getCompleteQuantity();
         if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
            Object this$mete = this.getMete();
            Object other$mete = other.getMete();
            if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
               Object this$completeMete = this.getCompleteMete();
               Object other$completeMete = other.getCompleteMete();
               return this$completeMete == null ? other$completeMete == null : this$completeMete.equals(other$completeMete);
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
      return other instanceof APPQuantityAndMeteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $completeMete = this.getCompleteMete();
      return result * 59 + ($completeMete == null ? 43 : $completeMete.hashCode());
   }

   public static class APPQuantityAndMeteDTOBuilder {
      private Integer quantity;
      private Integer completeQuantity;
      private BigDecimal mete;
      private BigDecimal completeMete;

      APPQuantityAndMeteDTOBuilder() {
      }

      @JsonProperty("quantity")
      public APPQuantityAndMeteDTO.APPQuantityAndMeteDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public APPQuantityAndMeteDTO.APPQuantityAndMeteDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("mete")
      public APPQuantityAndMeteDTO.APPQuantityAndMeteDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("completeMete")
      public APPQuantityAndMeteDTO.APPQuantityAndMeteDTOBuilder completeMete(final BigDecimal completeMete) {
         this.completeMete = completeMete;
         return this;
      }

      public APPQuantityAndMeteDTO build() {
         return new APPQuantityAndMeteDTO(this.quantity, this.completeQuantity, this.mete, this.completeMete);
      }

      @Override
      public String toString() {
         return "APPQuantityAndMeteDTO.APPQuantityAndMeteDTOBuilder(quantity="
            + this.quantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", mete="
            + this.mete
            + ", completeMete="
            + this.completeMete
            + ")";
      }
   }
}
