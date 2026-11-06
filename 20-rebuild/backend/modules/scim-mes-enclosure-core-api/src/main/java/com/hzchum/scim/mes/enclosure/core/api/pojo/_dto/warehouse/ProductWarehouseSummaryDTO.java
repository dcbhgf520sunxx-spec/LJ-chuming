package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.warehouse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ProductWarehouseSummaryDTO {
   @ApiModelProperty("清单数量")
   @JsonInclude(Include.NON_NULL)
   private Integer quantity;
   @ApiModelProperty("任务数量")
   @JsonInclude(Include.NON_NULL)
   private Integer taskQuantity;
   @ApiModelProperty("入库数量")
   @JsonInclude(Include.NON_NULL)
   private Integer inboundQuantity;
   @ApiModelProperty("出库数量")
   @JsonInclude(Include.NON_NULL)
   private Integer outboundQuantity;
   @ApiModelProperty("库存数量")
   @JsonInclude(Include.NON_NULL)
   private Integer stockQuantity;
   @ApiModelProperty("清单量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal mete;
   @ApiModelProperty("任务量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal taskMete;
   @ApiModelProperty("入库量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal inboundMete;
   @ApiModelProperty("出库量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal outboundMete;
   @ApiModelProperty("库存量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal stockMete;

   ProductWarehouseSummaryDTO(
      final Integer quantity,
      final Integer taskQuantity,
      final Integer inboundQuantity,
      final Integer outboundQuantity,
      final Integer stockQuantity,
      final BigDecimal mete,
      final BigDecimal taskMete,
      final BigDecimal inboundMete,
      final BigDecimal outboundMete,
      final BigDecimal stockMete
   ) {
      this.quantity = quantity;
      this.taskQuantity = taskQuantity;
      this.inboundQuantity = inboundQuantity;
      this.outboundQuantity = outboundQuantity;
      this.stockQuantity = stockQuantity;
      this.mete = mete;
      this.taskMete = taskMete;
      this.inboundMete = inboundMete;
      this.outboundMete = outboundMete;
      this.stockMete = stockMete;
   }

   public static ProductWarehouseSummaryDTO.ProductWarehouseSummaryDTOBuilder builder() {
      return new ProductWarehouseSummaryDTO.ProductWarehouseSummaryDTOBuilder();
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getInboundQuantity() {
      return this.inboundQuantity;
   }

   public Integer getOutboundQuantity() {
      return this.outboundQuantity;
   }

   public Integer getStockQuantity() {
      return this.stockQuantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getTaskMete() {
      return this.taskMete;
   }

   public BigDecimal getInboundMete() {
      return this.inboundMete;
   }

   public BigDecimal getOutboundMete() {
      return this.outboundMete;
   }

   public BigDecimal getStockMete() {
      return this.stockMete;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   public void setInboundQuantity(final Integer inboundQuantity) {
      this.inboundQuantity = inboundQuantity;
   }

   public void setOutboundQuantity(final Integer outboundQuantity) {
      this.outboundQuantity = outboundQuantity;
   }

   public void setStockQuantity(final Integer stockQuantity) {
      this.stockQuantity = stockQuantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setTaskMete(final BigDecimal taskMete) {
      this.taskMete = taskMete;
   }

   public void setInboundMete(final BigDecimal inboundMete) {
      this.inboundMete = inboundMete;
   }

   public void setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
   }

   public void setStockMete(final BigDecimal stockMete) {
      this.stockMete = stockMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductWarehouseSummaryDTO)) {
         return false;
      }

      ProductWarehouseSummaryDTO other = (ProductWarehouseSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$taskQuantity = this.getTaskQuantity();
         Object other$taskQuantity = other.getTaskQuantity();
         if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
            Object this$inboundQuantity = this.getInboundQuantity();
            Object other$inboundQuantity = other.getInboundQuantity();
            if (this$inboundQuantity == null ? other$inboundQuantity == null : this$inboundQuantity.equals(other$inboundQuantity)) {
               Object this$outboundQuantity = this.getOutboundQuantity();
               Object other$outboundQuantity = other.getOutboundQuantity();
               if (this$outboundQuantity == null ? other$outboundQuantity == null : this$outboundQuantity.equals(other$outboundQuantity)) {
                  Object this$stockQuantity = this.getStockQuantity();
                  Object other$stockQuantity = other.getStockQuantity();
                  if (this$stockQuantity == null ? other$stockQuantity == null : this$stockQuantity.equals(other$stockQuantity)) {
                     Object this$mete = this.getMete();
                     Object other$mete = other.getMete();
                     if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                        Object this$taskMete = this.getTaskMete();
                        Object other$taskMete = other.getTaskMete();
                        if (this$taskMete == null ? other$taskMete == null : this$taskMete.equals(other$taskMete)) {
                           Object this$inboundMete = this.getInboundMete();
                           Object other$inboundMete = other.getInboundMete();
                           if (this$inboundMete == null ? other$inboundMete == null : this$inboundMete.equals(other$inboundMete)) {
                              Object this$outboundMete = this.getOutboundMete();
                              Object other$outboundMete = other.getOutboundMete();
                              if (this$outboundMete == null ? other$outboundMete == null : this$outboundMete.equals(other$outboundMete)) {
                                 Object this$stockMete = this.getStockMete();
                                 Object other$stockMete = other.getStockMete();
                                 return this$stockMete == null ? other$stockMete == null : this$stockMete.equals(other$stockMete);
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
      return other instanceof ProductWarehouseSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $inboundQuantity = this.getInboundQuantity();
      result = result * 59 + ($inboundQuantity == null ? 43 : $inboundQuantity.hashCode());
      Object $outboundQuantity = this.getOutboundQuantity();
      result = result * 59 + ($outboundQuantity == null ? 43 : $outboundQuantity.hashCode());
      Object $stockQuantity = this.getStockQuantity();
      result = result * 59 + ($stockQuantity == null ? 43 : $stockQuantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $taskMete = this.getTaskMete();
      result = result * 59 + ($taskMete == null ? 43 : $taskMete.hashCode());
      Object $inboundMete = this.getInboundMete();
      result = result * 59 + ($inboundMete == null ? 43 : $inboundMete.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $stockMete = this.getStockMete();
      return result * 59 + ($stockMete == null ? 43 : $stockMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProductWarehouseSummaryDTO(quantity="
         + this.getQuantity()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", inboundQuantity="
         + this.getInboundQuantity()
         + ", outboundQuantity="
         + this.getOutboundQuantity()
         + ", stockQuantity="
         + this.getStockQuantity()
         + ", mete="
         + this.getMete()
         + ", taskMete="
         + this.getTaskMete()
         + ", inboundMete="
         + this.getInboundMete()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", stockMete="
         + this.getStockMete()
         + ")";
   }

   public static class ProductWarehouseSummaryDTOBuilder {
      private Integer quantity;
      private Integer taskQuantity;
      private Integer inboundQuantity;
      private Integer outboundQuantity;
      private Integer stockQuantity;
      private BigDecimal mete;
      private BigDecimal taskMete;
      private BigDecimal inboundMete;
      private BigDecimal outboundMete;
      private BigDecimal stockMete;

      ProductWarehouseSummaryDTOBuilder() {
      }

      public ProductWarehouseSummaryDTO.ProductWarehouseSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProductWarehouseSummaryDTO.ProductWarehouseSummaryDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      public ProductWarehouseSummaryDTO.ProductWarehouseSummaryDTOBuilder inboundQuantity(final Integer inboundQuantity) {
         this.inboundQuantity = inboundQuantity;
         return this;
      }

      public ProductWarehouseSummaryDTO.ProductWarehouseSummaryDTOBuilder outboundQuantity(final Integer outboundQuantity) {
         this.outboundQuantity = outboundQuantity;
         return this;
      }

      public ProductWarehouseSummaryDTO.ProductWarehouseSummaryDTOBuilder stockQuantity(final Integer stockQuantity) {
         this.stockQuantity = stockQuantity;
         return this;
      }

      public ProductWarehouseSummaryDTO.ProductWarehouseSummaryDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProductWarehouseSummaryDTO.ProductWarehouseSummaryDTOBuilder taskMete(final BigDecimal taskMete) {
         this.taskMete = taskMete;
         return this;
      }

      public ProductWarehouseSummaryDTO.ProductWarehouseSummaryDTOBuilder inboundMete(final BigDecimal inboundMete) {
         this.inboundMete = inboundMete;
         return this;
      }

      public ProductWarehouseSummaryDTO.ProductWarehouseSummaryDTOBuilder outboundMete(final BigDecimal outboundMete) {
         this.outboundMete = outboundMete;
         return this;
      }

      public ProductWarehouseSummaryDTO.ProductWarehouseSummaryDTOBuilder stockMete(final BigDecimal stockMete) {
         this.stockMete = stockMete;
         return this;
      }

      public ProductWarehouseSummaryDTO build() {
         return new ProductWarehouseSummaryDTO(
            this.quantity,
            this.taskQuantity,
            this.inboundQuantity,
            this.outboundQuantity,
            this.stockQuantity,
            this.mete,
            this.taskMete,
            this.inboundMete,
            this.outboundMete,
            this.stockMete
         );
      }

      @Override
      public String toString() {
         return "ProductWarehouseSummaryDTO.ProductWarehouseSummaryDTOBuilder(quantity="
            + this.quantity
            + ", taskQuantity="
            + this.taskQuantity
            + ", inboundQuantity="
            + this.inboundQuantity
            + ", outboundQuantity="
            + this.outboundQuantity
            + ", stockQuantity="
            + this.stockQuantity
            + ", mete="
            + this.mete
            + ", taskMete="
            + this.taskMete
            + ", inboundMete="
            + this.inboundMete
            + ", outboundMete="
            + this.outboundMete
            + ", stockMete="
            + this.stockMete
            + ")";
      }
   }
}
