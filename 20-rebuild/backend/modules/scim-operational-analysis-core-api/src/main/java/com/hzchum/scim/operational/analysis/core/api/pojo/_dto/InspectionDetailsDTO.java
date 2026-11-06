package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class InspectionDetailsDTO {
   @ApiModelProperty(name = "month", value = "月份", notes = "月份")
   @JsonProperty("month")
   @JSONField(name = "month")
   private Integer month;
   @ApiModelProperty(name = "quantity", value = "检验总数", notes = "检验总数")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "problemQuantity", value = "不合格总数", notes = "不合格总数")
   @JsonProperty("problemQuantity")
   @JSONField(name = "problemQuantity")
   private Integer problemQuantity;
   @ApiModelProperty(name = "passRatio", value = "合格率", notes = "合格率")
   @JsonProperty("passRatio")
   @JSONField(name = "passRatio")
   private BigDecimal passRatio;

   public static InspectionDetailsDTO.InspectionDetailsDTOBuilder builder() {
      return new InspectionDetailsDTO.InspectionDetailsDTOBuilder();
   }

   public Integer getMonth() {
      return this.month;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getProblemQuantity() {
      return this.problemQuantity;
   }

   public BigDecimal getPassRatio() {
      return this.passRatio;
   }

   @JsonProperty("month")
   public void setMonth(final Integer month) {
      this.month = month;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("problemQuantity")
   public void setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
   }

   @JsonProperty("passRatio")
   public void setPassRatio(final BigDecimal passRatio) {
      this.passRatio = passRatio;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectionDetailsDTO)) {
         return false;
      }

      InspectionDetailsDTO other = (InspectionDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$month = this.getMonth();
      Object other$month = other.getMonth();
      if (this$month == null ? other$month == null : this$month.equals(other$month)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$problemQuantity = this.getProblemQuantity();
            Object other$problemQuantity = other.getProblemQuantity();
            if (this$problemQuantity == null ? other$problemQuantity == null : this$problemQuantity.equals(other$problemQuantity)) {
               Object this$passRatio = this.getPassRatio();
               Object other$passRatio = other.getPassRatio();
               return this$passRatio == null ? other$passRatio == null : this$passRatio.equals(other$passRatio);
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
      return other instanceof InspectionDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $problemQuantity = this.getProblemQuantity();
      result = result * 59 + ($problemQuantity == null ? 43 : $problemQuantity.hashCode());
      Object $passRatio = this.getPassRatio();
      return result * 59 + ($passRatio == null ? 43 : $passRatio.hashCode());
   }

   @Override
   public String toString() {
      return "InspectionDetailsDTO(month="
         + this.getMonth()
         + ", quantity="
         + this.getQuantity()
         + ", problemQuantity="
         + this.getProblemQuantity()
         + ", passRatio="
         + this.getPassRatio()
         + ")";
   }

   public InspectionDetailsDTO(final Integer month, final Integer quantity, final Integer problemQuantity, final BigDecimal passRatio) {
      this.month = month;
      this.quantity = quantity;
      this.problemQuantity = problemQuantity;
      this.passRatio = passRatio;
   }

   public InspectionDetailsDTO() {
   }

   public static class InspectionDetailsDTOBuilder {
      private Integer month;
      private Integer quantity;
      private Integer problemQuantity;
      private BigDecimal passRatio;

      InspectionDetailsDTOBuilder() {
      }

      @JsonProperty("month")
      public InspectionDetailsDTO.InspectionDetailsDTOBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      @JsonProperty("quantity")
      public InspectionDetailsDTO.InspectionDetailsDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("problemQuantity")
      public InspectionDetailsDTO.InspectionDetailsDTOBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      @JsonProperty("passRatio")
      public InspectionDetailsDTO.InspectionDetailsDTOBuilder passRatio(final BigDecimal passRatio) {
         this.passRatio = passRatio;
         return this;
      }

      public InspectionDetailsDTO build() {
         return new InspectionDetailsDTO(this.month, this.quantity, this.problemQuantity, this.passRatio);
      }

      @Override
      public String toString() {
         return "InspectionDetailsDTO.InspectionDetailsDTOBuilder(month="
            + this.month
            + ", quantity="
            + this.quantity
            + ", problemQuantity="
            + this.problemQuantity
            + ", passRatio="
            + this.passRatio
            + ")";
      }
   }
}
