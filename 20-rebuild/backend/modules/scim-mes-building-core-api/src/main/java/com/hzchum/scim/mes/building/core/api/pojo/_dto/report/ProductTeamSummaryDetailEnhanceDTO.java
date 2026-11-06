package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "ProductTeamSummaryDetailEnhanceDTO", description = "详情和详情汇总信息")
public class ProductTeamSummaryDetailEnhanceDTO {
   private int quantity;
   private BigDecimal totalNetWeight;
   private BigDecimal totalGrossWeight;
   PageVO<ProductTeamSummaryDetailDTO> detailPages;

   public static ProductTeamSummaryDetailEnhanceDTO.ProductTeamSummaryDetailEnhanceDTOBuilder builder() {
      return new ProductTeamSummaryDetailEnhanceDTO.ProductTeamSummaryDetailEnhanceDTOBuilder();
   }

   public ProductTeamSummaryDetailEnhanceDTO() {
   }

   public ProductTeamSummaryDetailEnhanceDTO(
      final int quantity, final BigDecimal totalNetWeight, final BigDecimal totalGrossWeight, final PageVO<ProductTeamSummaryDetailDTO> detailPages
   ) {
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.detailPages = detailPages;
   }

   public int getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public PageVO<ProductTeamSummaryDetailDTO> getDetailPages() {
      return this.detailPages;
   }

   public ProductTeamSummaryDetailEnhanceDTO setQuantity(final int quantity) {
      this.quantity = quantity;
      return this;
   }

   public ProductTeamSummaryDetailEnhanceDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   public ProductTeamSummaryDetailEnhanceDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   public ProductTeamSummaryDetailEnhanceDTO setDetailPages(final PageVO<ProductTeamSummaryDetailDTO> detailPages) {
      this.detailPages = detailPages;
      return this;
   }

   @Override
   public String toString() {
      return "ProductTeamSummaryDetailEnhanceDTO(quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", detailPages="
         + this.getDetailPages()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductTeamSummaryDetailEnhanceDTO)) {
         return false;
      }

      ProductTeamSummaryDetailEnhanceDTO other = (ProductTeamSummaryDetailEnhanceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getQuantity() != other.getQuantity()) {
         return false;
      }

      Object this$totalNetWeight = this.getTotalNetWeight();
      Object other$totalNetWeight = other.getTotalNetWeight();
      if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
         Object this$totalGrossWeight = this.getTotalGrossWeight();
         Object other$totalGrossWeight = other.getTotalGrossWeight();
         if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
            Object this$detailPages = this.getDetailPages();
            Object other$detailPages = other.getDetailPages();
            return this$detailPages == null ? other$detailPages == null : this$detailPages.equals(other$detailPages);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductTeamSummaryDetailEnhanceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getQuantity();
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $detailPages = this.getDetailPages();
      return result * 59 + ($detailPages == null ? 43 : $detailPages.hashCode());
   }

   public static class ProductTeamSummaryDetailEnhanceDTOBuilder {
      private int quantity;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private PageVO<ProductTeamSummaryDetailDTO> detailPages;

      ProductTeamSummaryDetailEnhanceDTOBuilder() {
      }

      public ProductTeamSummaryDetailEnhanceDTO.ProductTeamSummaryDetailEnhanceDTOBuilder quantity(final int quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProductTeamSummaryDetailEnhanceDTO.ProductTeamSummaryDetailEnhanceDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public ProductTeamSummaryDetailEnhanceDTO.ProductTeamSummaryDetailEnhanceDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public ProductTeamSummaryDetailEnhanceDTO.ProductTeamSummaryDetailEnhanceDTOBuilder detailPages(final PageVO<ProductTeamSummaryDetailDTO> detailPages) {
         this.detailPages = detailPages;
         return this;
      }

      public ProductTeamSummaryDetailEnhanceDTO build() {
         return new ProductTeamSummaryDetailEnhanceDTO(this.quantity, this.totalNetWeight, this.totalGrossWeight, this.detailPages);
      }

      @Override
      public String toString() {
         return "ProductTeamSummaryDetailEnhanceDTO.ProductTeamSummaryDetailEnhanceDTOBuilder(quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", detailPages="
            + this.detailPages
            + ")";
      }
   }
}
