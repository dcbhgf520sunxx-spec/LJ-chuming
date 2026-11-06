package com.hzchum.scim.mes.building.core.api.pojo._dto.productionStatements;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ArtifactProductionStatementsDTO", description = "构件生产报表")
public class EnclosureSummaryDTO {
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalLength", notes = "总长度（m）")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", notes = "总面积（㎡）")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   private BigDecimal totalArea;

   public static EnclosureSummaryDTO.EnclosureSummaryDTOBuilder builder() {
      return new EnclosureSummaryDTO.EnclosureSummaryDTOBuilder();
   }

   public EnclosureSummaryDTO(final Integer quantity, final BigDecimal totalLength, final BigDecimal totalArea) {
      this.quantity = quantity;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
   }

   public EnclosureSummaryDTO() {
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   @JsonProperty("quantity")
   public EnclosureSummaryDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalLength")
   public EnclosureSummaryDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("totalArea")
   public EnclosureSummaryDTO setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   @Override
   public String toString() {
      return "EnclosureSummaryDTO(quantity=" + this.getQuantity() + ", totalLength=" + this.getTotalLength() + ", totalArea=" + this.getTotalArea() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureSummaryDTO)) {
         return false;
      }

      EnclosureSummaryDTO other = (EnclosureSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$totalLength = this.getTotalLength();
         Object other$totalLength = other.getTotalLength();
         if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
            Object this$totalArea = this.getTotalArea();
            Object other$totalArea = other.getTotalArea();
            return this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EnclosureSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      return result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
   }

   public static class EnclosureSummaryDTOBuilder {
      private Integer quantity;
      private BigDecimal totalLength;
      private BigDecimal totalArea;

      EnclosureSummaryDTOBuilder() {
      }

      @JsonProperty("quantity")
      public EnclosureSummaryDTO.EnclosureSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalLength")
      public EnclosureSummaryDTO.EnclosureSummaryDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("totalArea")
      public EnclosureSummaryDTO.EnclosureSummaryDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public EnclosureSummaryDTO build() {
         return new EnclosureSummaryDTO(this.quantity, this.totalLength, this.totalArea);
      }

      @Override
      public String toString() {
         return "EnclosureSummaryDTO.EnclosureSummaryDTOBuilder(quantity="
            + this.quantity
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ")";
      }
   }
}
