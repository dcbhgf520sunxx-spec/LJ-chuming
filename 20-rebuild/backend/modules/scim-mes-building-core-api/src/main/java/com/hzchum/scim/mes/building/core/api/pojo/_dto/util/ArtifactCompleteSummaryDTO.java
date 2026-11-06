package com.hzchum.scim.mes.building.core.api.pojo._dto.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "CompleteSummaryDTO", description = "完成统计工具类")
public class ArtifactCompleteSummaryDTO {
   @ApiModelProperty(name = "quantity", notes = "清单数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "mate", notes = "清单净重量")
   @JsonProperty("mate")
   @JSONField(name = "mate")
   private BigDecimal netMate;
   @ApiModelProperty(name = "completeMate", notes = "完成清单净重量")
   @JsonProperty("completeMate")
   @JSONField(name = "completeMate")
   private BigDecimal completeNetMate;
   @ApiModelProperty(name = "mate", notes = "清单毛重量")
   @JsonProperty("mate")
   @JSONField(name = "mate")
   private BigDecimal grossMate;
   @ApiModelProperty(name = "completeMate", notes = "完成清单毛重量")
   @JsonProperty("completeMate")
   @JSONField(name = "completeMate")
   private BigDecimal completeGrossMate;

   public static ArtifactCompleteSummaryDTO.ArtifactCompleteSummaryDTOBuilder builder() {
      return new ArtifactCompleteSummaryDTO.ArtifactCompleteSummaryDTOBuilder();
   }

   public ArtifactCompleteSummaryDTO() {
   }

   public ArtifactCompleteSummaryDTO(
      final Integer quantity,
      final Integer completeQuantity,
      final BigDecimal netMate,
      final BigDecimal completeNetMate,
      final BigDecimal grossMate,
      final BigDecimal completeGrossMate
   ) {
      this.quantity = quantity;
      this.completeQuantity = completeQuantity;
      this.netMate = netMate;
      this.completeNetMate = completeNetMate;
      this.grossMate = grossMate;
      this.completeGrossMate = completeGrossMate;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getNetMate() {
      return this.netMate;
   }

   public BigDecimal getCompleteNetMate() {
      return this.completeNetMate;
   }

   public BigDecimal getGrossMate() {
      return this.grossMate;
   }

   public BigDecimal getCompleteGrossMate() {
      return this.completeGrossMate;
   }

   @JsonProperty("quantity")
   public ArtifactCompleteSummaryDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public ArtifactCompleteSummaryDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("mate")
   public ArtifactCompleteSummaryDTO setNetMate(final BigDecimal netMate) {
      this.netMate = netMate;
      return this;
   }

   @JsonProperty("completeMate")
   public ArtifactCompleteSummaryDTO setCompleteNetMate(final BigDecimal completeNetMate) {
      this.completeNetMate = completeNetMate;
      return this;
   }

   @JsonProperty("mate")
   public ArtifactCompleteSummaryDTO setGrossMate(final BigDecimal grossMate) {
      this.grossMate = grossMate;
      return this;
   }

   @JsonProperty("completeMate")
   public ArtifactCompleteSummaryDTO setCompleteGrossMate(final BigDecimal completeGrossMate) {
      this.completeGrossMate = completeGrossMate;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactCompleteSummaryDTO(quantity="
         + this.getQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", netMate="
         + this.getNetMate()
         + ", completeNetMate="
         + this.getCompleteNetMate()
         + ", grossMate="
         + this.getGrossMate()
         + ", completeGrossMate="
         + this.getCompleteGrossMate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactCompleteSummaryDTO)) {
         return false;
      }

      ArtifactCompleteSummaryDTO other = (ArtifactCompleteSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$completeQuantity = this.getCompleteQuantity();
         Object other$completeQuantity = other.getCompleteQuantity();
         if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
            Object this$netMate = this.getNetMate();
            Object other$netMate = other.getNetMate();
            if (this$netMate == null ? other$netMate == null : this$netMate.equals(other$netMate)) {
               Object this$completeNetMate = this.getCompleteNetMate();
               Object other$completeNetMate = other.getCompleteNetMate();
               if (this$completeNetMate == null ? other$completeNetMate == null : this$completeNetMate.equals(other$completeNetMate)) {
                  Object this$grossMate = this.getGrossMate();
                  Object other$grossMate = other.getGrossMate();
                  if (this$grossMate == null ? other$grossMate == null : this$grossMate.equals(other$grossMate)) {
                     Object this$completeGrossMate = this.getCompleteGrossMate();
                     Object other$completeGrossMate = other.getCompleteGrossMate();
                     return this$completeGrossMate == null ? other$completeGrossMate == null : this$completeGrossMate.equals(other$completeGrossMate);
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof ArtifactCompleteSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $netMate = this.getNetMate();
      result = result * 59 + ($netMate == null ? 43 : $netMate.hashCode());
      Object $completeNetMate = this.getCompleteNetMate();
      result = result * 59 + ($completeNetMate == null ? 43 : $completeNetMate.hashCode());
      Object $grossMate = this.getGrossMate();
      result = result * 59 + ($grossMate == null ? 43 : $grossMate.hashCode());
      Object $completeGrossMate = this.getCompleteGrossMate();
      return result * 59 + ($completeGrossMate == null ? 43 : $completeGrossMate.hashCode());
   }

   public static class ArtifactCompleteSummaryDTOBuilder {
      private Integer quantity;
      private Integer completeQuantity;
      private BigDecimal netMate;
      private BigDecimal completeNetMate;
      private BigDecimal grossMate;
      private BigDecimal completeGrossMate;

      ArtifactCompleteSummaryDTOBuilder() {
      }

      @JsonProperty("quantity")
      public ArtifactCompleteSummaryDTO.ArtifactCompleteSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public ArtifactCompleteSummaryDTO.ArtifactCompleteSummaryDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("mate")
      public ArtifactCompleteSummaryDTO.ArtifactCompleteSummaryDTOBuilder netMate(final BigDecimal netMate) {
         this.netMate = netMate;
         return this;
      }

      @JsonProperty("completeMate")
      public ArtifactCompleteSummaryDTO.ArtifactCompleteSummaryDTOBuilder completeNetMate(final BigDecimal completeNetMate) {
         this.completeNetMate = completeNetMate;
         return this;
      }

      @JsonProperty("mate")
      public ArtifactCompleteSummaryDTO.ArtifactCompleteSummaryDTOBuilder grossMate(final BigDecimal grossMate) {
         this.grossMate = grossMate;
         return this;
      }

      @JsonProperty("completeMate")
      public ArtifactCompleteSummaryDTO.ArtifactCompleteSummaryDTOBuilder completeGrossMate(final BigDecimal completeGrossMate) {
         this.completeGrossMate = completeGrossMate;
         return this;
      }

      public ArtifactCompleteSummaryDTO build() {
         return new ArtifactCompleteSummaryDTO(this.quantity, this.completeQuantity, this.netMate, this.completeNetMate, this.grossMate, this.completeGrossMate);
      }

      @Override
      public String toString() {
         return "ArtifactCompleteSummaryDTO.ArtifactCompleteSummaryDTOBuilder(quantity="
            + this.quantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", netMate="
            + this.netMate
            + ", completeNetMate="
            + this.completeNetMate
            + ", grossMate="
            + this.grossMate
            + ", completeGrossMate="
            + this.completeGrossMate
            + ")";
      }
   }
}
